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
 * Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.server.types;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.Functions;
import org.forgerock.opendj.ldap.GeneralizedTime;
import org.forgerock.opendj.ldap.schema.Schema;
import org.forgerock.util.Function;


/**
 * A fluent API for parsing attributes as different types of object. An
 * attribute parser is obtained from an entry using the method
 * {@link Entry#parseAttribute}.
 * <p>
 * Methods throw an {@code IllegalArgumentException} when a value cannot be
 * parsed (e.g. because its syntax is invalid). Methods which return a
 * {@code Set} always return a modifiable non-{@code null} result, even if the
 * attribute is {@code null} or empty.
 * <p>
 * Examples:
 *
 * <pre>
 * Entry entry = ...;
 *
 * Calendar timestamp = entry.parseAttribute("createTimestamp").asCalendar();
 * boolean isEnabled = entry.parseAttribute("enabled").asBoolean(false);
 *
 * Entry group = ...;
 * Schema schema = ...;
 *
 * Set&lt;DN&gt; members = group.parseAttribute("member").usingSchema(schema).asSetOfDN();
 * </pre>
 *
 * @see Entry#parseAttribute
 */
public final class AttributeParser {
    // TODO: enums, filters, rdns?

    private static final AttributeParser NULL_INSTANCE = new AttributeParser(null);

    /**
     * Returns an attribute parser for the provided attribute. {@code null}
     * attributes are permitted and will be treated as if an empty attribute was
     * provided.
     *
     * @param attribute
     *            The attribute to be parsed, which may be {@code null}.
     * @return The attribute parser.
     */
    public static AttributeParser parseAttribute(final Attribute attribute) {
        return isEmpty(attribute) ? NULL_INSTANCE : new AttributeParser(attribute);
    }

    private static boolean isEmpty(final Attribute attribute) {
        return attribute == null || attribute.isEmpty();
    }

    private final Attribute attribute;
    private Schema schema;

    private AttributeParser(final Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     * Returns the first value decoded as a {@code T} using the provided
     * {@link Function}, or {@code null} if the attribute does not contain any
     * values.
     *
     * @param <T>
     *            The type of the value to be decoded.
     * @param <E>
     *            The type of exception thrown by the function.
     * @param f
     *            The function which should be used to decode the value.
     * @return The first value decoded as a {@code T}.
     * @throws E
     *         If an error occurred when parsing the attribute.
     */
    public <T, E extends Exception> T as(final Function<ByteString, ? extends T, E> f) throws E {
        return as(f, null);
    }

    /**
     * Returns the first value decoded as a {@code T} using the provided
     * {@link Function}, or {@code defaultValue} if the attribute does not
     * contain any values.
     *
     * @param <T>
     *            The type of the value to be decoded.
     * @param <E>
     *            The type of exception thrown by the function.
     * @param f
     *            The function which should be used to decode the value.
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as a {@code T}.
     * @throws E
     *         If an error occurred when parsing the attribute.
     */
    public <T, E extends Exception> T as(final Function<ByteString, ? extends T, E> f, final T defaultValue) throws E {
        if (!isEmpty(attribute)) {
            return f.apply(attribute.iterator().next());
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns the first value decoded as a boolean, or {@code null} if the
     * attribute does not contain any values.
     *
     * @return The first value decoded as a boolean.
     */
    public Boolean asBoolean() {
        return isEmpty(attribute) ? null : asBoolean(false /* ignored */);
    }

    /**
     * Returns the first value decoded as an {@code Boolean}, or
     * {@code defaultValue} if the attribute does not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as an {@code Boolean}.
     */
    public boolean asBoolean(final boolean defaultValue) {
        return as(Functions.byteStringToBoolean(), defaultValue);
    }

    /**
     * Returns the first value, or {@code null} if the attribute does not
     * contain any values.
     *
     * @return The first value.
     */
    public ByteString asByteString() {
        return asByteString(null);
    }

    /**
     * Returns the first value, or {@code defaultValue} if the attribute does
     * not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value.
     */
    public ByteString asByteString(final ByteString defaultValue) {
        return as(Functions.<ByteString> identityFunction(), defaultValue);
    }

    /**
     * Returns the first value decoded as a {@code GeneralizedTime} using the
     * generalized time syntax, or {@code null} if the attribute does not
     * contain any values.
     *
     * @return The first value decoded as a {@code GeneralizedTime}.
     */
    public GeneralizedTime asGeneralizedTime() {
        return asGeneralizedTime(null);
    }

    /**
     * Returns the first value decoded as an {@code GeneralizedTime} using the
     * generalized time syntax, or {@code defaultValue} if the attribute does
     * not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as an {@code GeneralizedTime}.
     */
    public GeneralizedTime asGeneralizedTime(final GeneralizedTime defaultValue) {
        return as(Functions.byteStringToGeneralizedTime(), defaultValue);
    }

    /**
     * Returns the first value decoded as an {@code Integer}, or {@code null} if
     * the attribute does not contain any values.
     *
     * @return The first value decoded as an {@code Integer}.
     */
    public Integer asInteger() {
        return isEmpty(attribute) ? null : asInteger(0 /* ignored */);
    }

    /**
     * Returns the first value decoded as an {@code Integer}, or
     * {@code defaultValue} if the attribute does not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as an {@code Integer}.
     */
    public int asInteger(final int defaultValue) {
        return as(Functions.byteStringToInteger(), defaultValue);
    }

    /**
     * Returns the first value decoded as a {@code Long}, or {@code null} if the
     * attribute does not contain any values.
     *
     * @return The first value decoded as a {@code Long}.
     */
    public Long asLong() {
        return isEmpty(attribute) ? null : asLong(0L /* ignored */);
    }

    /**
     * Returns the first value decoded as a {@code Long}, or
     * {@code defaultValue} if the attribute does not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as a {@code Long}.
     */
    public long asLong(final long defaultValue) {
        return as(Functions.byteStringToLong(), defaultValue);
    }

    /**
     * Returns the values decoded as a set of {@code T}s using the provided
     * {@link Function}, or {@code defaultValues} if the attribute does not
     * contain any values.
     *
     * @param <T>
     *            The type of the values to be decoded.
     * @param <E>
     *            The type of exception thrown by the function.
     * @param f
     *            The function which should be used to decode values.
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code T}s.
     * @throws E
     *         If an error occurred when parsing the attribute.
     */
    public <T, E extends Exception> Set<T> asSetOf(final Function<ByteString, ? extends T, E> f,
            final Collection<? extends T> defaultValues) throws E {
        if (!isEmpty(attribute)) {
            final LinkedHashSet<T> result = new LinkedHashSet<>(attribute.size());
            for (final ByteString v : attribute) {
                result.add(f.apply(v));
            }
            return result;
        } else if (defaultValues != null) {
            return new LinkedHashSet<>(defaultValues);
        } else {
            return new LinkedHashSet<>(0);
        }
    }

    /**
     * Returns the values decoded as a set of {@code T}s using the provided
     * {@link Function}, or {@code defaultValues} if the attribute does not
     * contain any values.
     *
     * @param <T>
     *            The type of the values to be decoded.
     * @param <E>
     *            The type of exception thrown by the function.
     * @param f
     *            The function which should be used to decode values.
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code T}s.
     * @throws E
     *         If an error occurred when parsing the attribute.
     */
    public <T, E extends Exception> Set<T> asSetOf(final Function<ByteString, ? extends T, E> f,
            final T... defaultValues) throws E {
        return asSetOf(f, Arrays.asList(defaultValues));
    }

    /**
     * Returns the values decoded as a set of {@code Boolean}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Boolean}s.
     */
    public Set<Boolean> asSetOfBoolean(final Boolean... defaultValues) {
        return asSetOfBoolean(Arrays.asList(defaultValues));
    }

    /**
     * Returns the values decoded as a set of {@code Boolean}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Boolean}s.
     */
    public Set<Boolean> asSetOfBoolean(final Collection<Boolean> defaultValues) {
        return asSetOf(Functions.byteStringToBoolean(), defaultValues);
    }

    /**
     * Returns the values contained in the attribute, or {@code defaultValues}
     * if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values contained in the attribute.
     */
    public Set<ByteString> asSetOfByteString(final ByteString... defaultValues) {
        return asSetOfByteString(Arrays.asList(defaultValues));
    }

    /**
     * Returns the values contained in the attribute, or {@code defaultValues}
     * if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values contained in the attribute.
     */
    public Set<ByteString> asSetOfByteString(final Collection<ByteString> defaultValues) {
        return asSetOf(Functions.<ByteString> identityFunction(), defaultValues);
    }

    /**
     * Returns the values decoded as a set of {@code GeneralizedTime}s using the
     * generalized time syntax, or {@code defaultValues} if the attribute does
     * not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code GeneralizedTime}s.
     */
    public Set<GeneralizedTime> asSetOfGeneralizedTime(
            final Collection<GeneralizedTime> defaultValues) {
        return asSetOf(Functions.byteStringToGeneralizedTime(), defaultValues);
    }

    /**
     * Returns the values decoded as a set of {@code GeneralizedTime}s using the
     * generalized time syntax, or {@code defaultValues} if the attribute does
     * not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code GeneralizedTime}s.
     */
    public Set<GeneralizedTime> asSetOfGeneralizedTime(final GeneralizedTime... defaultValues) {
        return asSetOfGeneralizedTime(Arrays.asList(defaultValues));
    }

    /**
     * Returns the values decoded as a set of {@code Integer}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Integer}s.
     */
    public Set<Integer> asSetOfInteger(final Collection<Integer> defaultValues) {
        return asSetOf(Functions.byteStringToInteger(), defaultValues);
    }

    /**
     * Returns the values decoded as a set of {@code Integer}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Integer}s.
     */
    public Set<Integer> asSetOfInteger(final Integer... defaultValues) {
        return asSetOfInteger(Arrays.asList(defaultValues));
    }

    /**
     * Returns the values decoded as a set of {@code Long}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Long}s.
     */
    public Set<Long> asSetOfLong(final Collection<Long> defaultValues) {
        return asSetOf(Functions.byteStringToLong(), defaultValues);
    }

    /**
     * Returns the values decoded as a set of {@code Long}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code Long}s.
     */
    public Set<Long> asSetOfLong(final Long... defaultValues) {
        return asSetOfLong(Arrays.asList(defaultValues));
    }

    /**
     * Returns the values decoded as a set of {@code String}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code String}s.
     */
    public Set<String> asSetOfString(final Collection<String> defaultValues) {
        return asSetOf(Functions.byteStringToString(), defaultValues);
    }

    /**
     * Returns the values decoded as a set of {@code String}s, or
     * {@code defaultValues} if the attribute does not contain any values.
     *
     * @param defaultValues
     *            The default values to return if the attribute is empty.
     * @return The values decoded as a set of {@code String}s.
     */
    public Set<String> asSetOfString(final String... defaultValues) {
        return asSetOfString(Arrays.asList(defaultValues));
    }

    /**
     * Returns the first value decoded as a {@code String}, or {@code null} if
     * the attribute does not contain any values.
     *
     * @return The first value decoded as a {@code String}.
     */
    public String asString() {
        return asString(null);
    }

    /**
     * Returns the first value decoded as a {@code String}, or
     * {@code defaultValue} if the attribute does not contain any values.
     *
     * @param defaultValue
     *            The default value to return if the attribute is empty.
     * @return The first value decoded as a {@code String}.
     */
    public String asString(final String defaultValue) {
        return as(Functions.byteStringToString(), defaultValue);
    }

    /**
     * Throws a {@code NoSuchElementException} if the attribute referenced by
     * this parser is {@code null} or empty.
     *
     * @return A reference to this attribute parser.
     * @throws NoSuchElementException
     *             If the attribute referenced by this parser is {@code null} or
     *             empty.
     */
    public AttributeParser requireValue() throws NoSuchElementException {
        if (isEmpty(attribute)) {
            throw new NoSuchElementException();
        }
        return this;
    }

    /**
     * Sets the {@code Schema} which will be used when parsing schema sensitive
     * values such as DNs and attribute descriptions.
     *
     * @param schema
     *            The {@code Schema} which will be used when parsing schema
     *            sensitive values.
     * @return This attribute parser.
     */
    public AttributeParser usingSchema(final Schema schema) {
        // Avoid modifying the null instance: a schema will not be needed anyway
        if (this != NULL_INSTANCE) {
            this.schema = schema;
        }
        return this;
    }
}
