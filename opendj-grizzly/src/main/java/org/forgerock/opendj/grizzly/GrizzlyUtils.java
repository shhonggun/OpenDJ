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
package org.forgerock.opendj.grizzly;

import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;

import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.io.LDAP;
import org.forgerock.opendj.io.LDAPReader;
import org.forgerock.opendj.io.LDAPWriter;
import org.forgerock.opendj.ldap.DecodeOptions;
import org.forgerock.util.Options;
import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.Processor;
import org.glassfish.grizzly.ThreadCache;
import org.glassfish.grizzly.filterchain.Filter;
import org.glassfish.grizzly.filterchain.FilterChain;
import org.glassfish.grizzly.filterchain.FilterChainBuilder;
import org.glassfish.grizzly.filterchain.FilterChainEnabledTransport;
import org.glassfish.grizzly.filterchain.TransportFilter;
import org.glassfish.grizzly.memory.BuffersBuffer;
import org.glassfish.grizzly.memory.MemoryManager;
import org.glassfish.grizzly.nio.transport.TCPNIOConnection;
import org.glassfish.grizzly.ssl.SSLFilter;

import static org.forgerock.opendj.ldap.LDAPConnectionFactory.*;

/** Common utility methods. */
final class GrizzlyUtils {
    @SuppressWarnings("rawtypes")
    private static final ThreadCache.CachedTypeIndex<LDAPWriter> WRITER_INDEX = ThreadCache
            .obtainIndex(LDAPWriter.class, 1);
    @SuppressWarnings("rawtypes")
    private static final ThreadCache.CachedTypeIndex<LDAPWriter> WRITER_INDEX_V2 = ThreadCache
            .obtainIndex(LDAPWriter.class.getName() + ".ldapV2", LDAPWriter.class, 1);

    /**
     * Build a filter chain from the provided processor if possible and the
     * provided filters.
     * <p>
     * If the provided processor can't be used for building the new filter
     * chain, then a chain with only a {@code TransportFilter} is used as a base
     * chain.
     *
     * @param processor
     *            processor to build the filter chain from. If the processor is
     *            not a filter chain (for example, it can be a
     *            {@code StandaloneProcessor} then it is ignored to build the
     *            returned filter chain
     * @param filters
     *            filters to add at the end of the filter chain
     * @return a new filter chain, based on the provided processor if processor
     *         is a {@code FilterChain}, and having the provided filters as the
     *         last filters
     */
    static FilterChain buildFilterChain(Processor<?> processor, Filter... filters) {
        if (processor instanceof FilterChain) {
            return FilterChainBuilder.stateless().addAll((FilterChain) processor).addAll(filters).build();
        } else if (processor instanceof FilterChainEnabledTransport) {
            return FilterChainBuilder.stateless().add(((FilterChainEnabledTransport) processor).getTransportFilter())
                                                 .addAll(filters).build();
        } else {
            return FilterChainBuilder.stateless().add(new TransportFilter()).addAll(filters).build();
        }
    }

    /**
     * Adds a filter to filter chain registered with the given connection.
     * <p>
     * For a non-SSL filter, filter is added at the last position before the
     * LDAP filter.
     * <p>
     * For a SSL filter, filter is added before any
     * {@code ConnectionSecurityLayerFilter} which is already present in the
     * filter chain.
     *
     * @param filter
     *            filter to add
     * @param connection
     *            connection to update with the new filter chain containing the
     *            provided filter
     */
    static void addFilterToConnection(final Filter filter, Connection<?> connection) {
        final FilterChain currentChain = (FilterChain) connection.getProcessor();
        final FilterChain newChain = addFilterToChain(filter, currentChain);
        connection.setProcessor(newChain);
    }

    /**
     * Adds a filter to a filter chain.
     * <p>
     * For a non-SSL filter, filter is added at the last position before the
     * LDAP filter.
     * <p>
     * For a SSL filter, filter is added before any
     * {@code ConnectionSecurityLayerFilter} which is already present in the
     * filter chain.
     *
     * @param filter
     *            filter to add
     * @param chain
     *            initial filter chain
     * @return a new filter chain which includes the provided filter
     */
    static FilterChain addFilterToChain(final Filter filter, final FilterChain chain) {
        // By default, before LDAP filter which is the last one
        if (filter instanceof SSLFilter || filter instanceof StartTLSFilter) {
            return FilterChainBuilder.stateless().addAll(chain).add(1, filter).build();
        }
        if (filter instanceof SaslFilter) {
            final int pos = (chain.get(1) instanceof SSLFilter || chain.get(1) instanceof StartTLSFilter) ? 2 : 1;
            return FilterChainBuilder.stateless().addAll(chain).add(pos, filter).build();
        }
        return FilterChainBuilder.stateless().addAll(chain).add(chain.size() - 1, filter).build();
    }

    /**
     * Creates a new LDAP Reader with the provided maximum size of ASN1 element,
     * options and memory manager.
     *
     * @param decodeOptions
     *            allow to control how responses and requests are decoded
     * @param maxASN1ElementSize
     *            The maximum BER element size, or <code>0</code> to indicate
     *            that there is no limit.
     * @param memoryManager
     *            The memory manager to use for buffering.
     * @return a LDAP reader
     */
    static LDAPReader<ASN1BufferReader> createReader(DecodeOptions decodeOptions,
            int maxASN1ElementSize, MemoryManager<?> memoryManager) {
        ASN1BufferReader asn1Reader = new ASN1BufferReader(maxASN1ElementSize, BuffersBuffer.create(memoryManager));
        return LDAP.getReader(asn1Reader, decodeOptions);
    }

    /**
     * Returns a LDAP writer, with a clean ASN1Writer, possibly from
     * the thread local cache.
     * <p>
     * The writer is either returned from thread local cache or created.
     * In the former case, the writer is removed from the cache.
     *
     * @return a LDAP writer
     */
    @SuppressWarnings("unchecked")
    static LDAPWriter<ASN1BufferWriter> getWriter(final MemoryManager memoryManager, final int protocolVersion) {
        LDAPWriter<ASN1BufferWriter> writer = protocolVersion >= 3
                ? ThreadCache.takeFromCache(WRITER_INDEX)
                : ThreadCache.takeFromCache(WRITER_INDEX_V2);
        if (writer == null) {
            writer = LDAP.getWriter(new ASN1BufferWriter(), protocolVersion);
        }
        writer.getASN1Writer().reset(memoryManager);
        return writer;
    }

    /**
     * Recycle a LDAP writer to a thread local cache.
     * <p>
     * The LDAP writer is then available for the thread using the
     * {@get()} method.
     *
     * @param writer LDAP writer to recycle
     */
    static void recycleWriter(LDAPWriter<ASN1BufferWriter> writer) {
        writer.getASN1Writer().recycle();
        ThreadCache.putToCache(writer.getProtocolVersion() >= 3 ? WRITER_INDEX : WRITER_INDEX_V2, writer);
    }

    static void configureConnection(final Connection<?> connection, final LocalizedLogger logger, Options options) {
        /*
         * Test shows that its much faster with non block writes but risk
         * running out of memory if the server is slow.
         */
        connection.configureBlocking(false);

        // Configure socket options.
        final SocketChannel channel = (SocketChannel) ((TCPNIOConnection) connection).getChannel();
        final Socket socket = channel.socket();
        final boolean tcpNoDelay = options.get(TCP_NO_DELAY);
        final boolean keepAlive = options.get(SO_KEEPALIVE);
        final boolean reuseAddress = options.get(SO_REUSE_ADDRESS);
        final int linger = options.get(SO_LINGER_IN_SECONDS);
        try {
            socket.setTcpNoDelay(tcpNoDelay);
        } catch (final SocketException e) {
            logger.traceException(e, "Unable to set TCP_NODELAY to %d on client connection",
                    tcpNoDelay);
        }
        try {
            socket.setKeepAlive(keepAlive);
        } catch (final SocketException e) {
            logger.traceException(e, "Unable to set SO_KEEPALIVE to %d on client connection",
                    keepAlive);
        }
        try {
            socket.setReuseAddress(reuseAddress);
        } catch (final SocketException e) {
            logger.traceException(e, "Unable to set SO_REUSEADDR to %d on client connection",
                    reuseAddress);
        }
        try {
            if (linger < 0) {
                socket.setSoLinger(false, 0);
            } else {
                socket.setSoLinger(true, linger);
            }
        } catch (final SocketException e) {
            logger.traceException(e, "Unable to set SO_LINGER to %d on client connection", linger);
        }
    }

    static long getLongProperty(final String name, final long defaultValue) {
        final String value = System.getProperty(name);
        try {
            return value != null ? Long.parseLong(value) : defaultValue;
        } catch (final NumberFormatException e) {
            return defaultValue;
        }
    }

    /** Prevent instantiation. */
    private GrizzlyUtils() {
        // No implementation required.
    }
}
