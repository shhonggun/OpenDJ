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
 * Copyright 2009 Sun Microsystems, Inc.
 * Portions copyright 2012-2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.MatchingRule;

import org.forgerock.util.Reject;

/**
 * This class provides a skeletal implementation of the {@code Attribute}
 * interface, to minimize the effort required to implement this interface.
 */
public abstract class AbstractAttribute extends AbstractSet<ByteString> implements Attribute {

    /**
     * Returns {@code true} if {@code object} is an attribute which is equal to
     * {@code attribute}. Two attributes are considered equal if their attribute
     * descriptions are equal, they both have the same number of attribute
     * values, and every attribute value contained in the first attribute is
     * also contained in the second attribute.
     *
     * @param attribute
     *            The attribute to be tested for equality.
     * @param object
     *            The object to be tested for equality with the attribute.
     * @return {@code true} if {@code object} is an attribute which is equal to
     *         {@code attribute}, or {@code false} if not.
     */
    static boolean equals(final Attribute attribute, final Object object) {
        if (attribute == object) {
            return true;
        }
        if (!(object instanceof Attribute)) {
            return false;
        }

        final Attribute other = (Attribute) object;
        return attribute.getAttributeDescription().equals(other.getAttributeDescription())
                && attribute.size() == other.size()
                && attribute.containsAll(other);
    }

    /**
     * Returns the hash code for {@code attribute}. It will be calculated as the
     * sum of the hash codes of the attribute description and all of the
     * attribute values.
     *
     * @param attribute
     *            The attribute whose hash code should be calculated.
     * @return The hash code for {@code attribute}.
     */
    static int hashCode(final Attribute attribute) {
        int hashCode = attribute.getAttributeDescription().hashCode();
        for (final ByteString value : attribute) {
            hashCode += normalizeValue(attribute, value).hashCode();
        }
        return hashCode;
    }

    /**
     * Returns the normalized form of {@code value} normalized using
     * {@code attribute}'s equality matching rule.
     *
     * @param attribute
     *            The attribute whose equality matching rule should be used for
     *            normalization.
     * @param value
     *            The attribute value to be normalized.
     * @return The normalized form of {@code value} normalized using
     *         {@code attribute}'s equality matching rule.
     */
    static ByteString normalizeValue(final Attribute attribute, final ByteString value) {
        final AttributeDescription attributeDescription = attribute.getAttributeDescription();
        final AttributeType attributeType = attributeDescription.getAttributeType();
        final MatchingRule matchingRule = attributeType.getEqualityMatchingRule();

        try {
            return matchingRule.normalizeAttributeValue(value);
        } catch (final Exception e) {
            // Fall back to provided value.
            return value;
        }
    }

    /**
     * Returns a string representation of {@code attribute}.
     *
     * @param attribute
     *            The attribute whose string representation should be returned.
     * @return The string representation of {@code attribute}.
     */
    static String toString(final Attribute attribute) {
        final StringBuilder builder = new StringBuilder();
        builder.append('"');
        builder.append(attribute.getAttributeDescriptionAsString());
        builder.append("\":[");
        boolean firstValue = true;
        for (final ByteString value : attribute) {
            if (!firstValue) {
                builder.append(',');
            }
            builder.append('"');
            builder.append(value);
            builder.append('"');
            firstValue = false;
        }
        builder.append(']');
        return builder.toString();
    }

    /** Sole constructor. */
    protected AbstractAttribute() {
        // No implementation required.
    }

    @Override
    public abstract boolean add(ByteString value);

    @Override
    public boolean add(final Object... values) {
        Reject.ifNull(values);
        boolean modified = false;
        for (final Object value : values) {
            modified |= add(ByteString.valueOfObject(value));
        }
        return modified;
    }

    @Override
    public boolean addAll(final Collection<? extends ByteString> values) {
        return addAll(values, null);
    }

    @Override
    public <T> boolean addAll(final Collection<T> values,
            final Collection<? super T> duplicateValues) {
        boolean modified = false;
        for (final T value : values) {
            if (add(value)) {
                modified = true;
            } else if (duplicateValues != null) {
                duplicateValues.add(value);
            }
        }
        return modified;
    }

    @Override
    public abstract boolean contains(Object value);

    @Override
    public boolean containsAll(final Collection<?> values) {
        for (final Object value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(final Object object) {
        return equals(this, object);
    }

    @Override
    public ByteString firstValue() {
        return iterator().next();
    }

    @Override
    public String firstValueAsString() {
        return firstValue().toString();
    }

    @Override
    public abstract AttributeDescription getAttributeDescription();

    @Override
    public String getAttributeDescriptionAsString() {
        return getAttributeDescription().toString();
    }

    @Override
    public int hashCode() {
        return hashCode(this);
    }

    @Override
    public AttributeParser parse() {
        return AttributeParser.parseAttribute(this);
    }

    @Override
    public abstract Iterator<ByteString> iterator();

    @Override
    public abstract boolean remove(Object value);

    @Override
    public boolean removeAll(final Collection<?> values) {
        return removeAll(values, null);
    }

    @Override
    public <T> boolean removeAll(final Collection<T> values,
            final Collection<? super T> missingValues) {
        boolean modified = false;
        for (final T value : values) {
            if (remove(value)) {
                modified = true;
            } else if (missingValues != null) {
                missingValues.add(value);
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(final Collection<?> values) {
        return retainAll(values, null);
    }

    @Override
    public <T> boolean retainAll(final Collection<T> values,
            final Collection<? super T> missingValues) {
        if (values.isEmpty()) {
            if (isEmpty()) {
                return false;
            } else {
                clear();
                return true;
            }
        }

        if (isEmpty()) {
            if (missingValues != null) {
                missingValues.addAll(values);
            }
            return false;
        }

        final Map<ByteString, T> valuesToRetain = new HashMap<>(values.size());
        for (final T value : values) {
            valuesToRetain.put(normalizeValue(this, ByteString.valueOfObject(value)), value);
        }

        boolean modified = false;
        final Iterator<ByteString> iterator = iterator();
        while (iterator.hasNext()) {
            final ByteString value = iterator.next();
            final ByteString normalizedValue = normalizeValue(this, value);
            if (valuesToRetain.remove(normalizedValue) == null) {
                modified = true;
                iterator.remove();
            }
        }

        if (missingValues != null) {
            missingValues.addAll(valuesToRetain.values());
        }

        return modified;
    }

    @Override
    public abstract int size();

    @Override
    public ByteString[] toArray() {
        return toArray(new ByteString[size()]);
    }

    @Override
    public String toString() {
        return toString(this);
    }

}
