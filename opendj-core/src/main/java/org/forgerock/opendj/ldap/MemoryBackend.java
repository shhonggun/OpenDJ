/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2013-2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap;

import static org.forgerock.opendj.ldap.AttributeDescription.create;
import static org.forgerock.opendj.ldap.Attributes.singletonAttribute;
import static org.forgerock.opendj.ldap.Entries.modifyEntry;
import static org.forgerock.opendj.ldap.LdapException.newLdapException;
import static org.forgerock.opendj.ldap.responses.Responses.newBindResult;
import static org.forgerock.opendj.ldap.responses.Responses.newCompareResult;
import static org.forgerock.opendj.ldap.responses.Responses.newResult;
import static org.forgerock.opendj.ldap.responses.Responses.newSearchResultEntry;
import static org.forgerock.opendj.ldap.schema.CoreSchema.getHasSubordinatesAttributeType;
import static org.forgerock.opendj.ldap.schema.CoreSchema.getNumSubordinatesAttributeType;

import java.io.IOException;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListMap;

import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.forgerock.opendj.ldap.controls.AssertionRequestControl;
import org.forgerock.opendj.ldap.controls.PostReadRequestControl;
import org.forgerock.opendj.ldap.controls.PostReadResponseControl;
import org.forgerock.opendj.ldap.controls.PreReadRequestControl;
import org.forgerock.opendj.ldap.controls.PreReadResponseControl;
import org.forgerock.opendj.ldap.controls.SimplePagedResultsControl;
import org.forgerock.opendj.ldap.controls.SubtreeDeleteRequestControl;
import org.forgerock.opendj.ldap.requests.AddRequest;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.opendj.ldap.requests.CompareRequest;
import org.forgerock.opendj.ldap.requests.DeleteRequest;
import org.forgerock.opendj.ldap.requests.ExtendedRequest;
import org.forgerock.opendj.ldap.requests.GenericBindRequest;
import org.forgerock.opendj.ldap.requests.ModifyDNRequest;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.ldap.requests.Request;
import org.forgerock.opendj.ldap.requests.SearchRequest;
import org.forgerock.opendj.ldap.requests.SimpleBindRequest;
import org.forgerock.opendj.ldap.responses.BindResult;
import org.forgerock.opendj.ldap.responses.CompareResult;
import org.forgerock.opendj.ldap.responses.ExtendedResult;
import org.forgerock.opendj.ldap.responses.Result;
import org.forgerock.opendj.ldap.schema.Schema;
import org.forgerock.opendj.ldif.EntryReader;

/**
 * A simple in memory back-end which can be used for testing.
 * The back-end implementations supports the following:
 * <ul>
 * <li>add, bind (simple), compare, delete, modify, and search operations, but
 * not modifyDN nor extended operations
 * <li>assertion, pre-, and post- read controls, subtree delete control, and
 * permissive modify control
 * <li>thread safety - supports concurrent operations
 * </ul>
 * It does not support the following:
 * <ul>
 * <li>high performance
 * <li>secure password storage
 * <li>schema checking
 * <li>persistence
 * <li>indexing
 * </ul>
 * This class can be used in conjunction with the factories defined in
 * {@link Connections} to create simple servers as well as mock LDAP
 * connections. For example, to create a mock LDAP connection factory:
 *
 * <pre>
 * MemoryBackend backend = new MemoryBackend();
 * Connection connection = newInternalConnectionFactory(newServerConnectionFactory(backend), null)
 *         .getConnection();
 * </pre>
 *
 * To create a simple LDAP server listening on 0.0.0.0:1389:
 *
 * <pre>
 * MemoryBackend backend = new MemoryBackend();
 * LDAPListener listener = new LDAPListener(1389, Connections
 *         .&lt;LDAPClientContext&gt; newServerConnectionFactory(backend));
 * </pre>
 */
public final class MemoryBackend implements RequestHandler<RequestContext> {
    private static final AttributeDescription HAS_SUBORDINATES = create(getHasSubordinatesAttributeType());
    private static final AttributeDescription NUM_SUBORDINATES = create(getNumSubordinatesAttributeType());

    private final DecodeOptions decodeOptions;
    private final ConcurrentSkipListMap<DN, Entry> entries = new ConcurrentSkipListMap<>();
    private final Schema schema;
    private final Object writeLock = new Object();
    private boolean enableVirtualAttributes;

    /**
     * Creates a new empty memory backend which will use the default schema.
     */
    public MemoryBackend() {
        this(Schema.getDefaultSchema());
    }

    /**
     * Creates a new memory backend which will use the default schema, and will
     * contain the entries read from the provided entry reader.
     *
     * @param reader
     *            The entry reader.
     * @throws IOException
     *             If an unexpected IO error occurred while reading the entries,
     *             or if duplicate entries are detected.
     */
    public MemoryBackend(final EntryReader reader) throws IOException {
        this(Schema.getDefaultSchema(), reader);
    }

    /**
     * Creates a new empty memory backend which will use the provided schema.
     *
     * @param schema
     *            The schema to use for decoding filters, etc.
     */
    public MemoryBackend(final Schema schema) {
        this.schema = schema;
        this.decodeOptions = new DecodeOptions().setSchema(schema);
    }

    /**
     * Creates a new memory backend which will use the provided schema, and will
     * contain the entries read from the provided entry reader.
     *
     * @param schema
     *            The schema to use for decoding filters, etc.
     * @param reader
     *            The entry reader.
     * @throws IOException
     *             If an unexpected IO error occurred while reading the entries,
     *             or if duplicate entries are detected.
     */
    public MemoryBackend(final Schema schema, final EntryReader reader) throws IOException {
        this(schema);
        load(reader, false);
    }

    /**
     * Indicates whether search responses should include the {@code hasSubordinates} and {@code numSubordinates}
     * virtual attributes if requested.
     *
     * @param enabled
     *         {@code true} if the virtual attributes should be included.
     * @return This memory backend.
     */
    public MemoryBackend enableVirtualAttributes(final boolean enabled) {
        this.enableVirtualAttributes = enabled;
        return this;
    }

    /**
     * Clears the contents of this memory backend so that it does not contain
     * any entries.
     *
     * @return This memory backend.
     */
    public MemoryBackend clear() {
        synchronized (writeLock) {
            entries.clear();
        }
        return this;
    }

    /**
     * Returns {@code true} if the named entry exists in this memory backend.
     *
     * @param dn
     *            The name of the entry.
     * @return {@code true} if the named entry exists in this memory backend.
     */
    public boolean contains(final DN dn) {
        return get(dn) != null;
    }

    /**
     * Returns {@code true} if the named entry exists in this memory backend.
     *
     * @param dn
     *            The name of the entry.
     * @return {@code true} if the named entry exists in this memory backend.
     */
    public boolean contains(final String dn) {
        return get(dn) != null;
    }

    /**
     * Returns the named entry contained in this memory backend, or {@code null}
     * if it does not exist.
     *
     * @param dn
     *            The name of the entry to be returned.
     * @return The named entry.
     */
    public Entry get(final DN dn) {
        return entries.get(dn);
    }

    /**
     * Returns the named entry contained in this memory backend, or {@code null}
     * if it does not exist.
     *
     * @param dn
     *            The name of the entry to be returned.
     * @return The named entry.
     */
    public Entry get(final String dn) {
        return get(DN.valueOf(dn, schema));
    }

    /**
     * Returns a collection containing all of the entries in this memory
     * backend. The returned collection is backed by this memory backend, so
     * changes to the collection are reflected in this memory backend and
     * vice-versa. The returned collection supports entry removal, iteration,
     * and is thread safe, but it does not support addition of new entries.
     *
     * @return A collection containing all of the entries in this memory
     *         backend.
     */
    public Collection<Entry> getAll() {
        return entries.values();
    }

    /**
     * Returns {@code true} if the named entry exists and has at least one child entry.
     *
     * @param dn
     *         The name of the entry.
     * @return {@code true} if the named entry exists and has at least one child entry.
     */
    public boolean hasSubordinates(final String dn) {
        return hasSubordinates(DN.valueOf(dn, schema));
    }

    /**
     * Returns {@code true} if the named entry exists and has at least one child entry.
     *
     * @param dn
     *         The name of the entry.
     * @return {@code true} if the named entry exists and has at least one child entry.
     */
    public boolean hasSubordinates(final DN dn) {
        if (!contains(dn)) {
            return false;
        }
        final DN next = entries.higherKey(dn);
        return next != null && next.isChildOf(dn);
    }

    /**
     * Returns the number of entries which are immediately subordinate to the named entry, or {@code 0} if the named
     * entry does not exist.
     *
     * @param dn
     *         The name of the entry.
     * @return The number of entries which are immediately subordinate to the named entry.
     */
    public int numSubordinates(final String dn) {
        return numSubordinates(DN.valueOf(dn, schema));
    }

    /**
     * Returns the number of entries which are immediately subordinate to the named entry, or {@code 0} if the named
     * entry does not exist.
     *
     * @param dn
     *         The name of the entry.
     * @return The number of entries which are immediately subordinate to the named entry.
     */
    public int numSubordinates(final DN dn) {
        final DN start = dn.child(RDN.minValue());
        final DN end = dn.child(RDN.maxValue());
        final SortedSet<DN> subtree = entries.keySet().subSet(start, end);
        int numSubordinates = 0;
        for (DN subordinate : subtree) {
            if (subordinate.isChildOf(dn)) {
                numSubordinates++;
            }
        }
        return numSubordinates;
    }

    @Override
    public void handleAdd(final RequestContext requestContext, final AddRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<Result> resultHandler) {
        try {
            synchronized (writeLock) {
                final DN dn = request.getName();
                final DN parent = dn.parent();
                if (entries.containsKey(dn)) {
                    throw newLdapException(ResultCode.ENTRY_ALREADY_EXISTS, "The entry '" + dn + "' already exists");
                } else if (parent != null && !entries.containsKey(parent)) {
                    throw noSuchObject(parent);
                } else {
                    entries.put(dn, request);
                }
            }
            resultHandler.handleResult(getResult(request, null, request));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    @Override
    public void handleBind(final RequestContext requestContext, final int version,
            final BindRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<BindResult> resultHandler) {
        try {
            final Entry entry;
            synchronized (writeLock) {
                final DN username = DN.valueOf(request.getName(), schema);
                final byte[] password;
                if (request instanceof SimpleBindRequest) {
                    password = ((SimpleBindRequest) request).getPassword();
                } else if (request instanceof GenericBindRequest
                        && request.getAuthenticationType() == BindRequest.AUTHENTICATION_TYPE_SIMPLE) {
                    password = ((GenericBindRequest) request).getAuthenticationValue();
                } else {
                    throw newLdapException(ResultCode.PROTOCOL_ERROR,
                            "non-SIMPLE authentication not supported: " + request.getAuthenticationType());
                }
                entry = getRequiredEntry(null, username);
                if (!entry.containsAttribute("userPassword", (Object) password)) {
                    throw newLdapException(ResultCode.INVALID_CREDENTIALS, "Wrong password");
                }
            }
            resultHandler.handleResult(getBindResult(request, entry, entry));
        } catch (final LocalizedIllegalArgumentException e) {
            resultHandler.handleException(newLdapException(ResultCode.PROTOCOL_ERROR, e));
        } catch (final EntryNotFoundException e) {
            /*
             * Usually you would not include a diagnostic message, but we'll add
             * one here because the memory back-end is not intended for
             * production use.
             */
            resultHandler.handleException(newLdapException(ResultCode.INVALID_CREDENTIALS, "Unknown user"));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    @Override
    public void handleCompare(final RequestContext requestContext, final CompareRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<CompareResult> resultHandler) {
        try {
            final Entry entry;
            final Attribute assertion;
            synchronized (writeLock) {
                final DN dn = request.getName();
                entry = getRequiredEntry(request, dn);
                assertion =
                        singletonAttribute(request.getAttributeDescription(), request
                                .getAssertionValue());
            }
            resultHandler.handleResult(getCompareResult(request, entry, entry.containsAttribute(
                    assertion, null)));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    @Override
    public void handleDelete(final RequestContext requestContext, final DeleteRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<Result> resultHandler) {
        try {
            final Entry entry;
            synchronized (writeLock) {
                final DN dn = request.getName();
                entry = getRequiredEntry(request, dn);
                if (request.getControl(SubtreeDeleteRequestControl.DECODER, decodeOptions) != null) {
                    // Subtree delete.
                    entries.subMap(dn, dn.child(RDN.maxValue())).clear();
                } else {
                    // Must be leaf.
                    final DN next = entries.higherKey(dn);
                    if (next == null || !next.isChildOf(dn)) {
                        entries.remove(dn);
                    } else {
                        throw newLdapException(ResultCode.NOT_ALLOWED_ON_NONLEAF);
                    }
                }
            }
            resultHandler.handleResult(getResult(request, entry, null));
        } catch (final DecodeException e) {
            resultHandler.handleException(newLdapException(ResultCode.PROTOCOL_ERROR, e));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    @Override
    public <R extends ExtendedResult> void handleExtendedRequest(
            final RequestContext requestContext, final ExtendedRequest<R> request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<R> resultHandler) {
        resultHandler.handleException(newLdapException(ResultCode.UNWILLING_TO_PERFORM,
                "Extended request operation not supported"));
    }

    @Override
    public void handleModify(final RequestContext requestContext, final ModifyRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<Result> resultHandler) {
        try {
            final Entry entry;
            final Entry newEntry;
            synchronized (writeLock) {
                final DN dn = request.getName();
                entry = getRequiredEntry(request, dn);
                newEntry = new LinkedHashMapEntry(entry);
                entries.put(dn, modifyEntry(newEntry, request));
            }
            resultHandler.handleResult(getResult(request, entry, newEntry));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    @Override
    public void handleModifyDN(final RequestContext requestContext, final ModifyDNRequest request,
            final IntermediateResponseHandler intermediateResponseHandler,
            final LdapResultHandler<Result> resultHandler) {
        resultHandler.handleException(newLdapException(ResultCode.UNWILLING_TO_PERFORM,
                "ModifyDN request operation not supported"));
    }

    @Override
    public void handleSearch(final RequestContext requestContext, final SearchRequest request,
        final IntermediateResponseHandler intermediateResponseHandler, final SearchResultHandler entryHandler,
        LdapResultHandler<Result> resultHandler) {
        try {
            final DN dn = request.getName();
            final SearchScope scope = request.getScope();
            final Filter filter = request.getFilter();
            final Matcher matcher = filter.matcher(schema);
            final AttributeFilter attributeFilter =
                new AttributeFilter(request.getAttributes(), schema).typesOnly(request.isTypesOnly());
            switch (scope.asEnum()) {
            case BASE_OBJECT:
                final Entry baseEntry = getRequiredEntry(request, dn);
                final Entry augmentedEntry = addVirtualAttributesIfNeeded(baseEntry);
                if (matcher.matches(augmentedEntry).toBoolean()) {
                    sendEntry(attributeFilter, entryHandler, augmentedEntry);
                }
                resultHandler.handleResult(newResult(ResultCode.SUCCESS));
                break;

            case SINGLE_LEVEL:
            case SUBORDINATES:
            case WHOLE_SUBTREE:
                searchWithSubordinates(requestContext, entryHandler, resultHandler, dn, matcher, attributeFilter,
                    request.getSizeLimit(), scope,
                    request.getControl(SimplePagedResultsControl.DECODER, new DecodeOptions()));
                break;

            default:
                throw newLdapException(ResultCode.PROTOCOL_ERROR,
                        "Search request contains an unsupported search scope");
            }
        } catch (DecodeException e) {
            resultHandler.handleException(newLdapException(ResultCode.PROTOCOL_ERROR, e.getMessage(), e));
        } catch (final LdapException e) {
            resultHandler.handleException(e);
        }
    }

    private Entry addVirtualAttributesIfNeeded(final Entry entry) {
        if (!enableVirtualAttributes) {
            return entry;
        }
        final Entry augmentedEntry = new LinkedHashMapEntry(entry);
        final int numSubordinates = numSubordinates(entry.getName());
        augmentedEntry.addAttribute(singletonAttribute(NUM_SUBORDINATES, numSubordinates));
        augmentedEntry.addAttribute(singletonAttribute(HAS_SUBORDINATES, numSubordinates > 0));
        return augmentedEntry;
    }

    /**
     * Returns {@code true} if this memory backend does not contain any entries.
     *
     * @return {@code true} if this memory backend does not contain any entries.
     */
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    /**
     * Reads all of the entries from the provided entry reader and adds them to
     * the content of this memory backend.
     *
     * @param reader
     *            The entry reader.
     * @param overwrite
     *            {@code true} if existing entries should be replaced, or
     *            {@code false} if an error should be returned when duplicate
     *            entries are encountered.
     * @return This memory backend.
     * @throws IOException
     *             If an unexpected IO error occurred while reading the entries,
     *             or if duplicate entries are detected and {@code overwrite} is
     *             {@code false}.
     */
    public MemoryBackend load(final EntryReader reader, final boolean overwrite) throws IOException {
        synchronized (writeLock) {
            if (reader != null) {
                try {
                    while (reader.hasNext()) {
                        final Entry entry = reader.readEntry();
                        final DN dn = entry.getName();
                        if (!overwrite && entries.containsKey(dn)) {
                            throw newLdapException(ResultCode.ENTRY_ALREADY_EXISTS,
                                    "Attempted to add the entry '" + dn + "' multiple times");
                        }
                        entries.put(dn, entry);
                    }
                } finally {
                    reader.close();
                }
            }
        }
        return this;
    }

    /**
     * Returns the number of entries contained in this memory backend.
     *
     * @return The number of entries contained in this memory backend.
     */
    public int size() {
        return entries.size();
    }

    /**
     * Perform a search for scope that includes subordinates, i.e., either
     * <code>SearchScope.SINGLE_LEVEL</code> or <code>SearchScope.WHOLE_SUBTREE</code>.
     *
     * @param requestContext context of this request
     * @param resultHandler handler which should be used to send back the search results to the client.
     * @param dn distinguished name of the base entry used for this request
     * @param matcher to filter entries that matches this request
     * @param attributeFilter to select attributes to return in search results
     * @param sizeLimit maximum number of entries to return. A value of zero indicates no restriction
     *          on number of entries.
     * @param pagedResults The simple paged results control, if present.
     * @throws CancelledResultException
     *           If a cancellation request has been received and processing of
     *           the request should be aborted if possible.
     * @throws LdapException
     *           If the request is unsuccessful.
     */
    private void searchWithSubordinates(final RequestContext requestContext, final SearchResultHandler entryHandler,
            final LdapResultHandler<Result> resultHandler, final DN dn, final Matcher matcher,
            final AttributeFilter attributeFilter, final int sizeLimit, SearchScope scope,
            SimplePagedResultsControl pagedResults) throws LdapException {
        final NavigableMap<DN, Entry> subtree = entries.subMap(dn, dn.child(RDN.maxValue()));
        if (subtree.isEmpty() || !dn.equals(subtree.firstKey())) {
            throw newLdapException(newResult(ResultCode.NO_SUCH_OBJECT));
        }

        final int pageSize = pagedResults != null ? pagedResults.getSize() : 0;
        final int offset = (pagedResults != null && !pagedResults.getCookie().isEmpty())
                ? Integer.valueOf(pagedResults.getCookie().toString()) : 0;
        int numberOfResults = 0;
        int position = 0;
        for (final Entry entry : subtree.values()) {
            requestContext.checkIfCancelled(false);
            if (scope.equals(SearchScope.WHOLE_SUBTREE) || entry.getName().isChildOf(dn)
                    || (scope.equals(SearchScope.SUBORDINATES) && !entry.getName().equals(dn))) {
                final Entry augmentedEntry = addVirtualAttributesIfNeeded(entry);
                if (matcher.matches(augmentedEntry).toBoolean()) {
                    /*
                     * This entry is going to be returned to the client so it
                     * counts towards the size limit and any paging criteria.
                     */

                    // Check size limit.
                    if (sizeLimit > 0 && numberOfResults >= sizeLimit) {
                        throw newLdapException(newResult(ResultCode.SIZE_LIMIT_EXCEEDED));
                    }

                    // Ignore this entry if we haven't reached the first page yet.
                    if (pageSize > 0 && position++ < offset) {
                        continue;
                    }

                    // Send the entry back to the client.
                    if (!sendEntry(attributeFilter, entryHandler, augmentedEntry)) {
                        // Client has disconnected or cancelled.
                        break;
                    }

                    numberOfResults++;

                    // Stop if we've reached the end of the page.
                    if (pageSize > 0 && numberOfResults == pageSize) {
                        break;
                    }
                }
            }
        }
        final Result result = newResult(ResultCode.SUCCESS);
        if (pageSize > 0) {
            final ByteString cookie = numberOfResults == pageSize
                ? ByteString.valueOfUtf8(String.valueOf(position))
                : ByteString.empty();
            result.addControl(SimplePagedResultsControl.newControl(true, 0, cookie));
        }
        resultHandler.handleResult(result);
    }

    private <R extends Result> R addResultControls(final Request request, final Entry before,
            final Entry after, final R result) throws LdapException {
        try {
            // Add pre-read response control if requested.
            final PreReadRequestControl preRead =
                    request.getControl(PreReadRequestControl.DECODER, decodeOptions);
            if (preRead != null) {
                if (preRead.isCritical() && before == null) {
                    throw newLdapException(ResultCode.UNAVAILABLE_CRITICAL_EXTENSION);
                }
                final AttributeFilter filter = new AttributeFilter(preRead.getAttributes(), schema);
                result.addControl(PreReadResponseControl.newControl(filter.filteredViewOf(before)));
            }

            // Add post-read response control if requested.
            final PostReadRequestControl postRead =
                    request.getControl(PostReadRequestControl.DECODER, decodeOptions);
            if (postRead != null) {
                if (postRead.isCritical() && after == null) {
                    throw newLdapException(ResultCode.UNAVAILABLE_CRITICAL_EXTENSION);
                }
                final AttributeFilter filter = new AttributeFilter(postRead.getAttributes(), schema);
                result.addControl(PostReadResponseControl.newControl(filter.filteredViewOf(after)));
            }
            return result;
        } catch (final DecodeException e) {
            throw newLdapException(ResultCode.PROTOCOL_ERROR, e);
        }
    }

    private BindResult getBindResult(final BindRequest request, final Entry before,
            final Entry after) throws LdapException {
        return addResultControls(request, before, after, newBindResult(ResultCode.SUCCESS));
    }

    private CompareResult getCompareResult(final CompareRequest request, final Entry entry,
            final boolean compareResult) throws LdapException {
        return addResultControls(
                request,
                entry,
                entry,
                newCompareResult(compareResult ? ResultCode.COMPARE_TRUE : ResultCode.COMPARE_FALSE));
    }

    private Entry getRequiredEntry(final Request request, final DN dn) throws LdapException {
        final Entry entry = entries.get(dn);
        if (entry == null) {
            throw noSuchObject(dn);
        }
        AssertionRequestControl control = decodeAssertionRequestControl(request);
        if (control != null) {
            final Filter filter = control.getFilter();
            final Matcher matcher = filter.matcher(schema);
            if (!matcher.matches(entry).toBoolean()) {
                throw newLdapException(ResultCode.ASSERTION_FAILED,
                        "The filter '" + filter + "' did not match the entry '" + entry.getName() + "'");
            }
        }
        return entry;
    }

    private AssertionRequestControl decodeAssertionRequestControl(final Request request) throws LdapException {
        try {
            return request != null ? request.getControl(AssertionRequestControl.DECODER, decodeOptions) : null;
        } catch (final DecodeException e) {
            throw newLdapException(ResultCode.PROTOCOL_ERROR, e);
        }
    }

    private Result getResult(final Request request, final Entry before, final Entry after) throws LdapException {
        return addResultControls(request, before, after, newResult(ResultCode.SUCCESS));
    }

    private LdapException noSuchObject(final DN dn) {
        return newLdapException(ResultCode.NO_SUCH_OBJECT, "The entry '" + dn + "' does not exist");
    }

    private boolean sendEntry(final AttributeFilter filter,
            final SearchResultHandler resultHandler, final Entry entry) {
        return resultHandler.handleEntry(newSearchResultEntry(filter.filteredViewOf(entry)));
    }
}
