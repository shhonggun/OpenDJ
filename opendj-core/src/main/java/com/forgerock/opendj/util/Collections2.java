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
 * Copyright 2009-2010 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package com.forgerock.opendj.util;

import static com.forgerock.opendj.util.Iterators.transformedIterator;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.forgerock.util.Function;

/** Additional {@code Collection} based utility methods. */
public final class Collections2 {
    private static class TransformedCollection<M, N, C extends Collection<M>, E0 extends RuntimeException,
            E1 extends RuntimeException> extends AbstractCollection<N> implements Collection<N> {
        protected final C collection;

        final Function<? super M, ? extends N, E0> funcMtoN;

        final Function<? super N, ? extends M, E1> funcNtoM;

        TransformedCollection(final C collection,
                              final Function<? super M, ? extends N, E0> funcMtoN,
                              final Function<? super N, ? extends M, E1> funcNtoM) {
            this.collection = collection;
            this.funcMtoN = funcMtoN;
            this.funcNtoM = funcNtoM;
        }

        @Override
        public boolean add(final N e) {
            return collection.add(funcNtoM.apply(e));
        }

        @Override
        public void clear() {
            collection.clear();
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean contains(final Object o) {
            return collection.contains(funcNtoM.apply((N) o));
        }

        @Override
        public boolean isEmpty() {
            return collection.isEmpty();
        }

        @Override
        public Iterator<N> iterator() {
            return transformedIterator(collection.iterator(), funcMtoN);
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean remove(final Object o) {
            return collection.remove(funcNtoM.apply((N) o));
        }

        @Override
        public int size() {
            return collection.size();
        }
    }

    private static final class TransformedList<M, N, E0 extends RuntimeException, E1 extends RuntimeException>
            extends TransformedCollection<M, N, List<M>, E0, E1> implements List<N> {
        private TransformedList(final List<M> list,
                                final Function<? super M, ? extends N, E0> funcMtoN,
                                final Function<? super N, ? extends M, E1> funcNtoM) {
            super(list, funcMtoN, funcNtoM);
        }

        @Override
        public void add(final int index, final N element) {
            collection.add(index, funcNtoM.apply(element));
        }

        @Override
        public boolean addAll(final int index, final Collection<? extends N> c) {
            // We cannot transform c here due to type-safety.
            boolean result = false;
            for (final N e : c) {
                result |= add(e);
            }
            return result;
        }

        @Override
        public N get(final int index) {
            return funcMtoN.apply(collection.get(index));
        }

        @Override
        @SuppressWarnings("unchecked")
        public int indexOf(final Object o) {
            return collection.indexOf(funcNtoM.apply((N) o));
        }

        @Override
        @SuppressWarnings("unchecked")
        public int lastIndexOf(final Object o) {
            return collection.lastIndexOf(funcNtoM.apply((N) o));
        }

        @Override
        public ListIterator<N> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<N> listIterator(final int index) {
            final ListIterator<M> iterator = collection.listIterator(index);
            return new ListIterator<N>() {

                @Override
                public void add(final N e) {
                    iterator.add(funcNtoM.apply(e));
                }

                @Override
                public boolean hasNext() {
                    return iterator.hasNext();
                }

                @Override
                public boolean hasPrevious() {
                    return iterator.hasPrevious();
                }

                @Override
                public N next() {
                    return funcMtoN.apply(iterator.next());
                }

                @Override
                public int nextIndex() {
                    return iterator.nextIndex();
                }

                @Override
                public N previous() {
                    return funcMtoN.apply(iterator.previous());
                }

                @Override
                public int previousIndex() {
                    return iterator.previousIndex();
                }

                @Override
                public void remove() {
                    iterator.remove();
                }

                @Override
                public void set(final N e) {
                    iterator.set(funcNtoM.apply(e));
                }

            };
        }

        @Override
        public N remove(final int index) {
            return funcMtoN.apply(collection.remove(index));
        }

        @Override
        public N set(final int index, final N element) {
            final M result = collection.set(index, funcNtoM.apply(element));
            return funcMtoN.apply(result);
        }

        @Override
        public List<N> subList(final int fromIndex, final int toIndex) {
            final List<M> subList = collection.subList(fromIndex, toIndex);
            return new TransformedList<>(subList, funcMtoN, funcNtoM);
        }
    }

    /**
     * Returns a view of {@code collection} whose values have been mapped to
     * elements of type {@code N} using {@code funcMtoN}. The returned
     * collection supports all operations.
     *
     * @param <M>
     *            The type of elements contained in {@code collection}.
     * @param <N>
     *            The type of elements contained in the returned collection.
     * @param <E0>
     *            The type of exception thrown by {@code funcMtoN}.
     * @param <E1>
     *            The type of exception thrown by {@code funcNtoM}.
     * @param collection
     *            The collection to be transformed.
     * @param funcMtoN
     *            A function which maps values of type {@code M} to values of
     *            type {@code N}. This function will be used when retrieving
     *            values from {@code collection}.
     * @param funcNtoM
     *            A function which maps values of type {@code N} to values of
     *            type {@code M}. This function will be used when performing
     *            queries and adding values to {@code collection} .
     * @return A view of {@code collection} whose values have been mapped to
     *         elements of type {@code N} using {@code funcMtoN}.
     */
    public static <M, N, E0 extends RuntimeException, E1 extends RuntimeException>
    Collection<N> transformedCollection(final Collection<M> collection,
                                        final Function<? super M, ? extends N, E0> funcMtoN,
                                        final Function<? super N, ? extends M, E1> funcNtoM) {
        return new TransformedCollection<>(collection, funcMtoN, funcNtoM);
    }

    /**
     * Returns a view of {@code list} whose values have been mapped to elements
     * of type {@code N} using {@code funcMtoN}. The returned list supports all
     * operations.
     *
     * @param <M>
     *            The type of elements contained in {@code list}.
     * @param <N>
     *            The type of elements contained in the returned list.
     * @param <E0>
     *            The type of exception thrown by {@code funcMtoN}.
     * @param <E1>
     *            The type of exception thrown by {@code funcNtoM}.
     * @param list
     *            The list to be transformed.
     * @param funcMtoN
     *            A function which maps values of type {@code M} to values of
     *            type {@code N}. This function will be used when retrieving
     *            values from {@code list}.
     * @param funcNtoM
     *            A function which maps values of type {@code N} to values of
     *            type {@code M}. This function will be used when performing
     *            queries and adding values to {@code list} .
     * @return A view of {@code list} whose values have been mapped to elements
     *         of type {@code N} using {@code funcMtoN}.
     */
    public static <M, N, E0 extends RuntimeException, E1 extends RuntimeException> List<N> transformedList(
            final List<M> list,
            final Function<? super M, ? extends N, E0> funcMtoN,
            final Function<? super N, ? extends M, E1> funcNtoM) {
        return new TransformedList<>(list, funcMtoN, funcNtoM);
    }

    /** Prevent instantiation. */
    private Collections2() {
        // Do nothing.
    }
}
