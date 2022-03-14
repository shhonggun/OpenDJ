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
 * Portions Copyright 2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap;

import java.util.List;

/**
 * An abstract filter visitor whose default implementation for all
 * {@code Visitor} methods is to invoke {@link #visitDefaultFilter(Object)}.
 * <p>
 * Implementations can override the methods on a case by case behavior.
 *
 * @param <R>
 *            The return type of this visitor's methods. Use
 *            {@link java.lang.Void} for visitors that do not need to return
 *            results.
 * @param <P>
 *            The type of the additional parameter to this visitor's methods.
 *            Use {@link java.lang.Void} for visitors that do not need an
 *            additional parameter.
 */
public abstract class AbstractFilterVisitor<R, P> implements FilterVisitor<R, P> {
    /** Default constructor. */
    protected AbstractFilterVisitor() {
        // Nothing to do.
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitAndFilter(final P p, final List<Filter> subFilters) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitApproxMatchFilter(final P p, final String attributeDescription,
            final ByteString assertionValue) {
        return visitDefaultFilter(p);
    }

    /**
     * Visits any filters which are not explicitly handled by other visitor
     * methods.
     * <p>
     * The default implementation of this method is to return {@code null}.
     *
     * @param p
     *            A visitor specified parameter.
     * @return A visitor specified result.
     */
    public R visitDefaultFilter(final P p) {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitEqualityMatchFilter(final P p, final String attributeDescription,
            final ByteString assertionValue) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitExtensibleMatchFilter(final P p, final String matchingRule,
            final String attributeDescription, final ByteString assertionValue,
            final boolean dnAttributes) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitGreaterOrEqualFilter(final P p, final String attributeDescription,
            final ByteString assertionValue) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitLessOrEqualFilter(final P p, final String attributeDescription,
            final ByteString assertionValue) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitNotFilter(final P p, final Filter subFilter) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitOrFilter(final P p, final List<Filter> subFilters) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitPresentFilter(final P p, final String attributeDescription) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitSubstringsFilter(final P p, final String attributeDescription,
            final ByteString initialSubstring, final List<ByteString> anySubstrings,
            final ByteString finalSubstring) {
        return visitDefaultFilter(p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The default implementation is to call {@link #visitDefaultFilter(Object)}.
     */
    @Override
    public R visitUnrecognizedFilter(final P p, final byte filterTag, final ByteString filterBytes) {
        return visitDefaultFilter(p);
    }
}
