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
 * Copyright 2010 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap;

import java.util.LinkedList;
import java.util.List;

import org.forgerock.opendj.ldap.requests.AbandonRequest;
import org.forgerock.opendj.ldap.requests.AddRequest;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.opendj.ldap.requests.CompareRequest;
import org.forgerock.opendj.ldap.requests.DeleteRequest;
import org.forgerock.opendj.ldap.requests.ExtendedRequest;
import org.forgerock.opendj.ldap.requests.GenericExtendedRequest;
import org.forgerock.opendj.ldap.requests.ModifyDNRequest;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.ldap.requests.SearchRequest;
import org.forgerock.opendj.ldap.requests.UnbindRequest;
import org.forgerock.opendj.ldap.responses.BindResult;
import org.forgerock.opendj.ldap.responses.CompareResult;
import org.forgerock.opendj.ldap.responses.ExtendedResult;
import org.forgerock.opendj.ldap.responses.Result;
import org.forgerock.opendj.ldap.responses.SearchResultEntry;
import org.forgerock.util.promise.ExceptionHandler;
import org.forgerock.util.promise.ResultHandler;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.*;
import static org.fest.assertions.Fail.*;
import static org.forgerock.opendj.ldap.LdapException.*;
import static org.forgerock.opendj.ldap.TestCaseUtils.*;
import static org.forgerock.opendj.ldap.requests.Requests.*;
import static org.forgerock.opendj.ldap.responses.Responses.*;
import static org.forgerock.opendj.ldap.spi.LdapPromises.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit test for AbstractAsynchronousConnection. The tests verify that all
 * synchronous operation methods delegate to the equivalent asynchronous method.
 */
@SuppressWarnings("javadoc")
public class AbstractAsynchronousConnectionTestCase extends SdkTestCase {
    public final class MockConnection extends AbstractAsynchronousConnection {
        private final ResultCode resultCode;
        private final SearchResultEntry[] entries;

        public MockConnection(ResultCode resultCode, SearchResultEntry...entries) {
            this.resultCode = resultCode;
            this.entries = entries;
        }

        @Override
        public LdapPromise<Void> abandonAsync(AbandonRequest request) {
            if (!resultCode.isExceptional()) {
                return newSuccessfulLdapPromise((Void) null);
            } else {
                return newFailedLdapPromise(newLdapException(resultCode));
            }
        }

        @Override
        public LdapPromise<Result> addAsync(AddRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newResult(resultCode));
        }

        @Override
        public void addConnectionEventListener(ConnectionEventListener listener) {
            // Do nothing.
        }

        @Override
        public LdapPromise<BindResult> bindAsync(BindRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newBindResult(resultCode));
        }

        @Override
        public void close(UnbindRequest request, String reason) {
            // Do nothing.
        }

        @Override
        public LdapPromise<CompareResult> compareAsync(CompareRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newCompareResult(resultCode));
        }

        @Override
        public LdapPromise<Result> deleteAsync(DeleteRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newResult(resultCode));
        }

        @Override
        public <R extends ExtendedResult> LdapPromise<R> extendedRequestAsync(ExtendedRequest<R> request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(request.getResultDecoder().newExtendedErrorResult(resultCode, "", ""));
        }

        @Override
        public boolean isClosed() {
            return false;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public LdapPromise<Result> modifyAsync(ModifyRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newResult(resultCode));
        }

        @Override
        public LdapPromise<Result> modifyDNAsync(ModifyDNRequest request,
                IntermediateResponseHandler intermediateResponseHandler) {
            return getPromiseFromResultCode(newResult(resultCode));
        }

        @Override
        public void removeConnectionEventListener(ConnectionEventListener listener) {
            // Do nothing.
        }

        @Override
        public LdapPromise<Result> searchAsync(SearchRequest request,
                IntermediateResponseHandler intermediateResponseHandler, SearchResultHandler entryHandler) {
            for (SearchResultEntry entry : entries) {
                entryHandler.handleEntry(entry);
            }

            return getPromiseFromResultCode(newResult(resultCode));
        }

        private <T extends Result> LdapPromise<T> getPromiseFromResultCode(T correctResult) {
            if (resultCode.isExceptional()) {
                return newFailedLdapPromise(newLdapException(resultCode));
            } else {
                return newSuccessfulLdapPromise(correctResult);
            }
        }

        @Override
        public String toString() {
            return "MockConnection";
        }
    }

    @Test
    public void testAddRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final AddRequest addRequest = newAddRequest("cn=test");
        assertThat(mockConnection.add(addRequest).getResultCode()).isEqualTo(ResultCode.SUCCESS);
    }

    @Test
    public void testAddRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final AddRequest addRequest = newAddRequest("cn=test");
        try {
            mockConnection.add(addRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testBindRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final BindRequest bindRequest = newSimpleBindRequest();
        assertThat(mockConnection.bind(bindRequest).getResultCode()).isEqualTo(ResultCode.SUCCESS);
    }

    @Test
    public void testBindRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final BindRequest bindRequest = newSimpleBindRequest();
        try {
            mockConnection.bind(bindRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testCompareRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final CompareRequest compareRequest = newCompareRequest("cn=test", "cn", "test");
        assertThat(mockConnection.compare(compareRequest).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
    }

    @Test
    public void testCompareRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final CompareRequest compareRequest = newCompareRequest("cn=test", "cn", "test");
        try {
            mockConnection.compare(compareRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testDeleteRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final DeleteRequest deleteRequest = newDeleteRequest("cn=test");
        assertThat(mockConnection.delete(deleteRequest).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
    }

    @Test
    public void testDeleteRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final DeleteRequest deleteRequest = newDeleteRequest("cn=test");
        try {
            mockConnection.delete(deleteRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testExtendedRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final GenericExtendedRequest extendedRequest = newGenericExtendedRequest("test");
        assertThat(mockConnection.extendedRequest(extendedRequest).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
    }

    @Test
    public void testExtendedRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final GenericExtendedRequest extendedRequest = newGenericExtendedRequest("test");
        try {
            mockConnection.extendedRequest(extendedRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testModifyRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final ModifyRequest modifyRequest = newModifyRequest("cn=test");
        assertThat(mockConnection.modify(modifyRequest).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
    }

    @Test
    public void testModifyRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final ModifyRequest modifyRequest = newModifyRequest("cn=test");
        try {
            mockConnection.modify(modifyRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testModifyDNRequestSuccess() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final ModifyDNRequest modifyDNRequest = newModifyDNRequest("cn=test", "cn=newrdn");
        assertThat(mockConnection.modifyDN(modifyDNRequest).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
    }

    @Test
    public void testModifyDNRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final ModifyDNRequest modifyDNRequest = newModifyDNRequest("cn=test", "cn=newrdn");
        try {
            mockConnection.modifyDN(modifyDNRequest);
            fail();
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testSearchRequestSuccess() throws Exception {
        final SearchResultEntry entry = newSearchResultEntry("cn=test");
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS, entry);
        final SearchRequest searchRequest =
                newSearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        List<SearchResultEntry> entries = new LinkedList<>();
        assertThat(mockConnection.search(searchRequest, entries).getResultCode()).isEqualTo(
                ResultCode.SUCCESS);
        assertThat(entries.size()).isEqualTo(1);
        assertThat(entries.iterator().next()).isSameAs(entry);
    }

    @Test
    public void testSearchRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final SearchRequest searchRequest =
                newSearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        List<SearchResultEntry> entries = new LinkedList<>();
        try {
            mockConnection.search(searchRequest, entries);
            failWasExpected(LdapException.class);
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
            assertThat(entries.isEmpty());
        }
    }

    @Test
    public void testSingleEntrySearchRequestSuccess() throws Exception {
        final SearchResultEntry entry = newSearchResultEntry("cn=test");
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS, entry);
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        assertThat(mockConnection.searchSingleEntry(request)).isEqualTo(entry);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSingleEntrySearchAsyncRequestSuccess() throws Exception {
        final SearchResultEntry entry = newSearchResultEntry("cn=test");
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS, entry);
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        ResultHandler<SearchResultEntry> resultHandler = mock(ResultHandler.class);
        SearchResultEntry resultEntry = mockConnection.searchSingleEntryAsync(request)
                                                      .thenOnResult(resultHandler).get();
        assertThat(resultEntry).isEqualTo(entry);
        verify(resultHandler).handleResult(any(SearchResultEntry.class));
    }

    @Test
    public void testSingleEntrySearchRequestNoEntryReturned() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS);
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        try {
            mockConnection.searchSingleEntry(request);
            failWasExpected(EntryNotFoundException.class);
        } catch (EntryNotFoundException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.CLIENT_SIDE_NO_RESULTS_RETURNED);
        }
    }

    @Test
    public void testSingleEntrySearchRequestMultipleEntriesToReturn() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SIZE_LIMIT_EXCEEDED,
                newSearchResultEntry("cn=test"));
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        try {
            mockConnection.searchSingleEntry(request);
            failWasExpected(MultipleEntriesFoundException.class);
        } catch (MultipleEntriesFoundException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED);
        }
    }

    @Test
    public void testSingleEntrySearchRequestMultipleEntriesReturnedByServer() throws Exception {
        // could happen if server does not enforce size limit
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS, newSearchResultEntry("cn=test"),
                newSearchResultEntry("cn=test,ou=org"));
        final SearchRequest request = newSingleEntrySearchRequest("cn=test", SearchScope.WHOLE_SUBTREE,
                "(objectClass=*)");
        try {
            mockConnection.searchSingleEntry(request);
            failWasExpected(MultipleEntriesFoundException.class);
        } catch (MultipleEntriesFoundException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED);
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSingleEntrySearchAsyncRequestMultipleEntriesToReturn() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.SIZE_LIMIT_EXCEEDED,
                newSearchResultEntry("cn=test"));
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        ExceptionHandler<LdapException> exceptionHandler = mock(ExceptionHandler.class);

        try {
            mockConnection.searchSingleEntryAsync(request).thenOnException(exceptionHandler).getOrThrow();
            failWasExpected(MultipleEntriesFoundException.class);
        } catch (MultipleEntriesFoundException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED);
            verify(exceptionHandler).handleException(any(LdapException.class));
        }
    }

    @Test
    public void testSingleEntrySearchAsyncRequestMultipleEntriesReturnedByServer() throws Exception {
        // could happen if server does not enfore size limit
        final Connection mockConnection = new MockConnection(ResultCode.SUCCESS, newSearchResultEntry("cn=test"),
                newSearchResultEntry("cn=test,ou=org"));
        final SearchRequest request = newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT,
                "(objectClass=*)");
        @SuppressWarnings("unchecked")
        ExceptionHandler<LdapException> exceptionHandler = mock(ExceptionHandler.class);
        try {
            mockConnection.searchSingleEntryAsync(request).thenOnException(exceptionHandler).getOrThrow();
            failWasExpected(MultipleEntriesFoundException.class);
        } catch (MultipleEntriesFoundException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED);
            verify(exceptionHandler).handleException(any(LdapException.class));
        }
    }

    @Test
    public void testSingleEntrySearchRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        try {
            mockConnection.searchSingleEntry(request);
            failWasExpected(LdapException.class);
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
        }
    }

    @Test
    public void testSingleEntrySearchAsyncRequestFail() throws Exception {
        final Connection mockConnection = new MockConnection(ResultCode.UNWILLING_TO_PERFORM);
        final SearchRequest request =
                newSingleEntrySearchRequest("cn=test", SearchScope.BASE_OBJECT, "(objectClass=*)");
        @SuppressWarnings("unchecked")
        ExceptionHandler<LdapException> exceptionHandler = mock(ExceptionHandler.class);
        try {
            mockConnection.searchSingleEntryAsync(request).thenOnException(exceptionHandler).getOrThrow();
            failWasExpected(LdapException.class);
        } catch (LdapException e) {
            assertThat(e.getResult().getResultCode()).isEqualTo(ResultCode.UNWILLING_TO_PERFORM);
            verify(exceptionHandler).handleException(any(LdapException.class));
        }
    }
}
