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
package org.forgerock.opendj.grizzly;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;
import static org.forgerock.opendj.ldap.LDAPListener.*;
import static org.forgerock.opendj.ldap.Connections.*;
import static org.forgerock.opendj.ldap.LDAPListener.REQUEST_MAX_SIZE_IN_BYTES;
import static org.forgerock.opendj.ldap.LdapException.newLdapException;
import static org.forgerock.opendj.ldap.TestCaseUtils.*;
import static org.forgerock.util.Options.defaultOptions;
import static org.mockito.Mockito.mock;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.ConnectionException;
import org.forgerock.opendj.ldap.ConnectionFactory;
import org.forgerock.opendj.ldap.Connections;
import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.IntermediateResponseHandler;
import org.forgerock.opendj.ldap.LDAPClientContext;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LDAPListener;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.LdapResultHandler;
import org.forgerock.opendj.ldap.ProviderNotFoundException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SdkTestCase;
import org.forgerock.opendj.ldap.SearchResultHandler;
import org.forgerock.opendj.ldap.ServerConnection;
import org.forgerock.opendj.ldap.ServerConnectionFactory;
import org.forgerock.opendj.ldap.TestCaseUtils;
import org.forgerock.opendj.ldap.requests.AbandonRequest;
import org.forgerock.opendj.ldap.requests.AddRequest;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.opendj.ldap.requests.CompareRequest;
import org.forgerock.opendj.ldap.requests.DeleteRequest;
import org.forgerock.opendj.ldap.requests.ExtendedRequest;
import org.forgerock.opendj.ldap.requests.ModifyDNRequest;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.ldap.requests.SearchRequest;
import org.forgerock.opendj.ldap.requests.UnbindRequest;
import org.forgerock.opendj.ldap.responses.BindResult;
import org.forgerock.opendj.ldap.responses.CompareResult;
import org.forgerock.opendj.ldap.responses.ExtendedResult;
import org.forgerock.opendj.ldap.responses.Responses;
import org.forgerock.opendj.ldap.responses.Result;
import org.forgerock.util.Options;
import org.forgerock.util.promise.PromiseImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.forgerock.reactive.ServerConnectionFactoryAdapter;

/** Tests the LDAPListener class. */
@SuppressWarnings("javadoc")
public class GrizzlyLDAPListenerTestCase extends SdkTestCase {

    private static class MockServerConnection implements ServerConnection<Integer> {
        final PromiseImpl<Throwable, LdapException> connectionError = PromiseImpl.create();
        final PromiseImpl<LDAPClientContext, LdapException> context = PromiseImpl.create();
        final CountDownLatch isClosed = new CountDownLatch(1);

        MockServerConnection() {
            // Do nothing.
        }

        @Override
        public void handleAbandon(final Integer requestContext, final AbandonRequest request)
                throws UnsupportedOperationException {
            // Do nothing.
        }

        @Override
        public void handleAdd(final Integer requestContext, final AddRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<Result> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
        }

        @Override
        public void handleBind(final Integer requestContext, final int version,
                final BindRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<BindResult> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newBindResult(ResultCode.SUCCESS));
        }

        @Override
        public void handleCompare(final Integer requestContext, final CompareRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<CompareResult> resultHandler)
                throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newCompareResult(ResultCode.SUCCESS));
        }

        @Override
        public void handleConnectionClosed(final Integer requestContext, final UnbindRequest request) {
            isClosed.countDown();
        }

        @Override
        public void handleConnectionDisconnected(final ResultCode resultCode, final String message) {
            // Do nothing.
        }

        @Override
        public void handleConnectionError(final Throwable error) {
            connectionError.handleResult(error);
        }

        @Override
        public void handleDelete(final Integer requestContext, final DeleteRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<Result> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
        }

        @Override
        public <R extends ExtendedResult> void handleExtendedRequest(final Integer requestContext,
                final ExtendedRequest<R> request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<R> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleException(newLdapException(request
                    .getResultDecoder().newExtendedErrorResult(ResultCode.PROTOCOL_ERROR, "",
                            "Extended operation " + request.getOID() + " not supported")));
        }

        @Override
        public void handleModify(final Integer requestContext, final ModifyRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<Result> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
        }

        @Override
        public void handleModifyDN(final Integer requestContext, final ModifyDNRequest request,
                final IntermediateResponseHandler intermediateResponseHandler,
                final LdapResultHandler<Result> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
        }

        @Override
        public void handleSearch(final Integer requestContext, final SearchRequest request,
            final IntermediateResponseHandler intermediateResponseHandler, final SearchResultHandler entryHandler,
            final LdapResultHandler<Result> resultHandler) throws UnsupportedOperationException {
            resultHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
        }
    }

    private static class MockServerConnectionFactory implements
            ServerConnectionFactory<LDAPClientContext, Integer> {
        private final MockServerConnection serverConnection;

        private MockServerConnectionFactory(final MockServerConnection serverConnection) {
            this.serverConnection = serverConnection;
        }

        @Override
        public ServerConnection<Integer> handleAccept(final LDAPClientContext clientContext) throws LdapException {
            serverConnection.context.handleResult(clientContext);
            return serverConnection;
        }
    }

    /** Disables logging before the tests. */
    @BeforeClass
    public void disableLogging() {
        TestCaseUtils.setDefaultLogLevel(Level.SEVERE);
    }

    /** Re-enable logging after the tests. */
    @AfterClass
    public void enableLogging() {
        TestCaseUtils.setDefaultLogLevel(Level.INFO);
    }

    /** Test creation of LDAP listener with default transport provider. */
    @SuppressWarnings("unchecked")
    @Test
    public void testCreateLDAPListener() throws Exception {
        // test no exception is thrown, which means transport provider is
        // correctly loaded
        LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        mock(ServerConnectionFactory.class)));
        listener.close();
    }

    /** Test creation of LDAP listener with default transport provider and custom class loader. */
    @SuppressWarnings("unchecked")
    @Test
    public void testCreateLDAPListenerWithCustomClassLoader() throws Exception {
        // test no exception is thrown, which means transport provider is correctly loaded
        Options options = defaultOptions().set(TRANSPORT_PROVIDER_CLASS_LOADER,
                                                       Thread.currentThread().getContextClassLoader());
        LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(options.get(LDAP_DECODE_OPTIONS),
                        mock(ServerConnectionFactory.class)),
                options);
        listener.close();
    }

    /** Test creation of LDAP listener with unknown transport provider. */
    @SuppressWarnings({ "unchecked" })
    @Test(expectedExceptions = ProviderNotFoundException.class,
        expectedExceptionsMessageRegExp = "^The requested provider 'unknown' .*")
    public void testCreateLDAPListenerFailureProviderNotFound() throws Exception {
        Options options = defaultOptions().set(TRANSPORT_PROVIDER, "unknown");
        LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(options.get(LDAP_DECODE_OPTIONS),
                        mock(ServerConnectionFactory.class)),
                options);
        listener.close();
    }

    /**
     * Tests basic LDAP listener functionality.
     *
     * @throws Exception
     *             If an unexpected exception occurred.
     */
    @Test(timeOut = 10000)
    public void testLDAPListenerBasic() throws Exception {
        final MockServerConnection serverConnection = new MockServerConnection();
        final MockServerConnectionFactory serverConnectionFactory =
                new MockServerConnectionFactory(serverConnection);
        final LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        serverConnectionFactory));
        final InetSocketAddress addr = listener.firstSocketAddress();
        try {
            // Connect and close.
            final Connection connection =
                    new LDAPConnectionFactory(addr.getHostName(), addr.getPort()).getConnection();
            assertThat(serverConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();
            assertThat(serverConnection.isClosed.getCount()).isEqualTo(1);
            connection.close();
            assertThat(serverConnection.isClosed.await(10, TimeUnit.SECONDS)).isTrue();
        } finally {
            listener.close();
        }
    }

    /**
     * Tests LDAP listener which attempts to open a connection to a remote
     * offline server at the point when the listener accepts the client
     * connection.
     *
     * @throws Exception
     *             If an unexpected exception occurred.
     */
    @Test(enabled = false)
    public void testLDAPListenerLoadBalanceDuringHandleAccept() throws Exception {
        // Online server listener.
        final MockServerConnection onlineServerConnection = new MockServerConnection();
        final MockServerConnectionFactory onlineServerConnectionFactory =
                new MockServerConnectionFactory(onlineServerConnection);
        final LDAPListener onlineServerListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        onlineServerConnectionFactory));
        final InetSocketAddress onlineAddr = onlineServerListener.firstSocketAddress();

        try {
            // Connection pool and load balancing tests.
            InetSocketAddress offlineAddress1 = findFreeSocketAddress();
            final ConnectionFactory offlineServer1 =
                    Connections.newNamedConnectionFactory(new LDAPConnectionFactory(
                            offlineAddress1.getHostName(),
                            offlineAddress1.getPort()), "offline1");
            InetSocketAddress offlineAddress2 = findFreeSocketAddress();
            final ConnectionFactory offlineServer2 =
                    Connections.newNamedConnectionFactory(new LDAPConnectionFactory(
                            offlineAddress2.getHostName(),
                            offlineAddress2.getPort()), "offline2");
            final ConnectionFactory onlineServer =
                    Connections.newNamedConnectionFactory(new LDAPConnectionFactory(
                            onlineAddr.getHostName(),
                            onlineAddr.getPort()), "online");

            // Round robin.
            final ConnectionFactory loadBalancer =
                    newRoundRobinLoadBalancer(asList(newFixedConnectionPool(offlineServer1, 10),
                                                     newFixedConnectionPool(offlineServer2, 10),
                                                     newFixedConnectionPool(onlineServer, 10)),
                                              defaultOptions());

            final MockServerConnection proxyServerConnection = new MockServerConnection();
            final MockServerConnectionFactory proxyServerConnectionFactory =
                    new MockServerConnectionFactory(proxyServerConnection) {

                        @Override
                        public ServerConnection<Integer> handleAccept(
                                final LDAPClientContext clientContext) throws LdapException {
                            // Get connection from load balancer, this should
                            // fail over twice before getting connection to
                            // online server.
                            loadBalancer.getConnection().close();
                            return super.handleAccept(clientContext);
                        }

                    };

            final LDAPListener proxyListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                    new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                            proxyServerConnectionFactory));
            final InetSocketAddress proxyAddr = proxyListener.firstSocketAddress();
            try {
                // Connect and close.
                final Connection connection =
                        new LDAPConnectionFactory(proxyAddr.getHostName(),
                            proxyAddr.getPort()).getConnection();

                assertThat(proxyServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();
                assertThat(onlineServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();

                // Wait for connect/close to complete.
                connection.close();

                proxyServerConnection.isClosed.await();
            } finally {
                proxyListener.close();
            }
        } finally {
            onlineServerListener.close();
        }
    }

    /**
     * Tests LDAP listener which attempts to open a connection to a load
     * balancing pool at the point when the listener handles a bind request.
     *
     * @throws Exception
     *             If an unexpected exception occurred.
     */
    @Test // (timeOut = 10000)
    public void testLDAPListenerLoadBalanceDuringHandleBind() throws Exception {
        // Online server listener.
        final MockServerConnection onlineServerConnection = new MockServerConnection();
        final MockServerConnectionFactory onlineServerConnectionFactory =
                new MockServerConnectionFactory(onlineServerConnection);
        final LDAPListener onlineServerListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        onlineServerConnectionFactory));
        final InetSocketAddress onlineServerAddr = onlineServerListener.firstSocketAddress();

        try {
            // Connection pool and load balancing tests.
            InetSocketAddress offlineAddress1 = findFreeSocketAddress();
            final ConnectionFactory offlineServer1 =
                    Connections.newNamedConnectionFactory(
                            new LDAPConnectionFactory(offlineAddress1.getHostName(),
                                    offlineAddress1.getPort()), "offline1");
            InetSocketAddress offlineAddress2 = findFreeSocketAddress();
            final ConnectionFactory offlineServer2 =
                    Connections.newNamedConnectionFactory(
                            new LDAPConnectionFactory(offlineAddress2.getHostName(),
                                    offlineAddress2.getPort()), "offline2");
            final ConnectionFactory onlineServer =
                    Connections.newNamedConnectionFactory(
                            new LDAPConnectionFactory(onlineServerAddr.getHostName(),
                                                      onlineServerAddr.getPort()), "online");

            // Round robin.
            final ConnectionFactory loadBalancer =
                    newRoundRobinLoadBalancer(asList(newFixedConnectionPool(offlineServer1, 10),
                                                     newFixedConnectionPool(offlineServer2, 10),
                                                     newFixedConnectionPool(onlineServer, 10)),
                                              defaultOptions());

            final MockServerConnection proxyServerConnection = new MockServerConnection() {

                @Override
                public void handleBind(final Integer requestContext, final int version,
                        final BindRequest request,
                        final IntermediateResponseHandler intermediateResponseHandler,
                        final LdapResultHandler<BindResult> resultHandler)
                        throws UnsupportedOperationException {
                    // Get connection from load balancer, this should fail over
                    // twice before getting connection to online server.
                    try {
                        loadBalancer.getConnection().close();
                        resultHandler.handleResult(Responses.newBindResult(ResultCode.SUCCESS));
                    } catch (final Exception e) {
                        // Unexpected.
                        resultHandler.handleException(newLdapException(ResultCode.OTHER,
                                "Unexpected exception when connecting to load balancer", e));
                    }
                }

            };
            final MockServerConnectionFactory proxyServerConnectionFactory =
                    new MockServerConnectionFactory(proxyServerConnection);

            final LDAPListener proxyListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                    new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                            proxyServerConnectionFactory));
            final InetSocketAddress proxyAddr = (InetSocketAddress) proxyListener.firstSocketAddress();

            try {
                // Connect, bind, and close.
                final Connection connection =
                        new LDAPConnectionFactory(proxyAddr.getHostName(),
                            proxyAddr.getPort()).getConnection();
                try {
                    connection.bind("cn=test", "password".toCharArray());

                    assertThat(proxyServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();
                    assertThat(onlineServerConnection.context.get(10, TimeUnit.SECONDS))
                            .isNotNull();
                } finally {
                    connection.close();
                }

                // Wait for connect/close to complete.
                proxyServerConnection.isClosed.await();
            } finally {
                proxyListener.close();
            }
        } finally {
            onlineServerListener.close();
        }
    }

    /**
     * Tests LDAP listener which attempts to open a connection to a remote
     * offline server at the point when the listener accepts the client
     * connection.
     *
     * @throws Exception
     *             If an unexpected exception occurred.
     */
    @Test(enabled = false)
    public void testLDAPListenerProxyDuringHandleAccept() throws Exception {
        final MockServerConnection onlineServerConnection = new MockServerConnection();
        final MockServerConnectionFactory onlineServerConnectionFactory =
                new MockServerConnectionFactory(onlineServerConnection);
        final LDAPListener onlineServerListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        onlineServerConnectionFactory));
        final InetSocketAddress onlineServerAddr = onlineServerListener.firstSocketAddress();

        try {
            final MockServerConnection proxyServerConnection = new MockServerConnection();
            final MockServerConnectionFactory proxyServerConnectionFactory =
                    new MockServerConnectionFactory(proxyServerConnection) {

                        @Override
                        public ServerConnection<Integer> handleAccept(
                                final LDAPClientContext clientContext) throws LdapException {
                            // First attempt offline server.
                            InetSocketAddress offlineAddress = findFreeSocketAddress();
                            LDAPConnectionFactory lcf =
                                    new LDAPConnectionFactory(offlineAddress.getHostName(),
                                            offlineAddress.getPort());
                            try {
                                // This is expected to fail.
                                lcf.getConnection().close();
                                throw newLdapException(ResultCode.OTHER,
                                        "Connection to offline server succeeded unexpectedly");
                            } catch (final ConnectionException ce) {
                                // This is expected - so go to online server.
                                try {
                                    lcf =
                                            new LDAPConnectionFactory(
                                                        onlineServerAddr.getHostName(),
                                                        onlineServerAddr.getPort());
                                    lcf.getConnection().close();
                                } catch (final Exception e) {
                                    // Unexpected.
                                    throw newLdapException(
                                                    ResultCode.OTHER,
                                                    "Unexpected exception when connecting to online server",
                                                    e);
                                }
                            } catch (final Exception e) {
                                // Unexpected.
                                throw newLdapException(
                                                ResultCode.OTHER,
                                                "Unexpected exception when connecting to offline server",
                                                e);
                            }

                            return super.handleAccept(clientContext);
                        }

                    };

            final LDAPListener proxyListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                    new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                            proxyServerConnectionFactory));
            try {
                // Connect and close.
                final Connection connection =
                        new LDAPConnectionFactory(onlineServerAddr.getHostName(),
                            onlineServerAddr.getPort()).getConnection();

                assertThat(proxyServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();
                assertThat(onlineServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();

                connection.close();

                // Wait for connect/close to complete.
                proxyServerConnection.isClosed.await();
            } finally {
                proxyListener.close();
            }
        } finally {
            onlineServerListener.close();
        }
    }

    /**
     * Tests LDAP listener which attempts to open a connection to a remote
     * offline server at the point when the listener handles a bind request.
     *
     * @throws Exception
     *             If an unexpected exception occurred.
     */
    @Test(timeOut = 10000)
    public void testLDAPListenerProxyDuringHandleBind() throws Exception {
        final MockServerConnection onlineServerConnection = new MockServerConnection();
        final MockServerConnectionFactory onlineServerConnectionFactory =
                new MockServerConnectionFactory(onlineServerConnection);
        final LDAPListener onlineServerListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                        onlineServerConnectionFactory));
        final InetSocketAddress onlineServerAddr = onlineServerListener.firstSocketAddress();

        try {
            final MockServerConnection proxyServerConnection = new MockServerConnection() {

                @Override
                public void handleBind(final Integer requestContext, final int version,
                        final BindRequest request,
                        final IntermediateResponseHandler intermediateResponseHandler,
                        final LdapResultHandler<BindResult> resultHandler)
                        throws UnsupportedOperationException {
                    // First attempt offline server.
                    InetSocketAddress offlineAddress = findFreeSocketAddress();
                    LDAPConnectionFactory lcf = new LDAPConnectionFactory(offlineAddress.getHostName(),
                            offlineAddress.getPort());
                    try {
                        // This is expected to fail.
                        lcf.getConnection().close();
                        resultHandler.handleException(newLdapException(
                                ResultCode.OTHER,
                                "Connection to offline server succeeded unexpectedly"));
                    } catch (final ConnectionException ce) {
                        // This is expected - so go to online server.
                        try {
                            lcf = new LDAPConnectionFactory(onlineServerAddr.getHostName(),
                                onlineServerAddr.getPort());
                            lcf.getConnection().close();
                            resultHandler.handleResult(Responses.newBindResult(ResultCode.SUCCESS));
                        } catch (final Exception e) {
                            // Unexpected.
                            resultHandler.handleException(newLdapException(
                                    ResultCode.OTHER,
                                    "Unexpected exception when connecting to online server", e));
                        }
                    } catch (final Exception e) {
                        // Unexpected.
                        resultHandler.handleException(newLdapException(
                                ResultCode.OTHER,
                                "Unexpected exception when connecting to offline server", e));
                    }
                }

            };
            final MockServerConnectionFactory proxyServerConnectionFactory =
                    new MockServerConnectionFactory(proxyServerConnection);
            final LDAPListener proxyListener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                    new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS),
                            proxyServerConnectionFactory));
            final InetSocketAddress proxyAddr = proxyListener.firstSocketAddress();
            try {
                // Connect, bind, and close.
                final Connection connection =
                        new LDAPConnectionFactory(proxyAddr.getHostName(),
                            proxyAddr.getPort()).getConnection();
                try {
                    connection.bind("cn=test", "password".toCharArray());

                    assertThat(proxyServerConnection.context.get(10, TimeUnit.SECONDS)).isNotNull();
                    assertThat(onlineServerConnection.context.get(10, TimeUnit.SECONDS))
                            .isNotNull();
                } finally {
                    connection.close();
                }

                // Wait for connect/close to complete.
                proxyServerConnection.isClosed.await();
            } finally {
                proxyListener.close();
            }
        } finally {
            onlineServerListener.close();
        }
    }

    /**
     * Tests that an incoming request which is too big triggers the connection
     * to be closed and an error notification to occur.
     *
     * @throws Exception
     *             If an unexpected error occurred.
     */
    @Test(expectedExceptions = LdapException.class)
    public void testMaxRequestSize() throws Exception {
        final MockServerConnection serverConnection = new MockServerConnection();
        final MockServerConnectionFactory factory =
                new MockServerConnectionFactory(serverConnection);
        final Options options = defaultOptions().set(REQUEST_MAX_SIZE_IN_BYTES, 2048);
        final LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(options.get(LDAP_DECODE_OPTIONS), factory), options);
        final InetSocketAddress addr = listener.firstSocketAddress();

        Connection connection = null;
        try {
            connection = new LDAPConnectionFactory(addr.getHostName(), addr.getPort()).
                    getConnection();

            // Small request
            connection.bind("cn=test", "password".toCharArray());
            assertThat(serverConnection.context.get().isClosed()).isFalse();
            assertThat(serverConnection.connectionError.isDone()).isFalse();

            // Big but valid request.
            final char[] password1 = new char[2000];
            Arrays.fill(password1, 'a');
            connection.bind("cn=test", password1);
            assertThat(serverConnection.context.get().isClosed()).isFalse();
            assertThat(serverConnection.connectionError.isDone()).isFalse();

            // Big invalid request.
            final char[] password2 = new char[2048];
            Arrays.fill(password2, 'a');
            try {
                connection.bind("cn=test", password2);
                fail("Big bind unexpectedly succeeded");
            } catch (final LdapException e) {
                // Expected exception.
                assertThat(e.getResult().getResultCode()).isEqualTo(
                        ResultCode.CLIENT_SIDE_SERVER_DOWN);

                assertThat(serverConnection.connectionError.get(10, TimeUnit.SECONDS)).isNotNull();
                assertThat(serverConnection.connectionError.get()).isInstanceOf(
                        DecodeException.class);
                assertThat(((DecodeException) serverConnection.connectionError.get()).isFatal())
                        .isTrue();
                assertThat(serverConnection.isClosed.getCount()).isEqualTo(1);
                assertThat(serverConnection.context.get().isClosed()).isTrue();
                throw e;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            listener.close();
        }
    }

    /**
     * Tests server-side disconnection.
     *
     * @throws Exception
     *             If an unexpected error occurred.
     */
    @Test
    public void testServerDisconnect() throws Exception {
        final MockServerConnection serverConnection = new MockServerConnection();
        final MockServerConnectionFactory factory = new MockServerConnectionFactory(serverConnection);
        final LDAPListener listener = new LDAPListener(Collections.singleton(loopbackWithDynamicPort()),
                new ServerConnectionFactoryAdapter(Options.defaultOptions().get(LDAP_DECODE_OPTIONS), factory));
        final InetSocketAddress listenerAddr = listener.firstSocketAddress();

        final Connection connection;
        try {
            // Connect and bind.
            connection = new LDAPConnectionFactory(listenerAddr.getHostName(), listenerAddr.getPort()).getConnection();
            try {
                connection.bind("cn=test", "password".toCharArray());
            } catch (final LdapException e) {
                connection.close();
                throw e;
            }
        } finally {
            serverConnection.context.get().disconnect();
            listener.close();
        }

        try {
            // Connect and bind.
            final Connection failedConnection =
                    new LDAPConnectionFactory(listenerAddr.getHostName(),
                        listenerAddr.getPort()).getConnection();
            failedConnection.close();
            failedConnection.bind("cn=test", "password".toCharArray());
            failedConnection.close();
            fail("Connection attempt to closed listener succeeded unexpectedly");
        } catch (final Exception e) {
            // Expected.
        }

        try {
            connection.bind("cn=test", "password".toCharArray());
            fail("Bind attempt on closed connection succeeded unexpectedly");
        } catch (final LdapException e) {
            // Expected.
            assertThat(connection.isValid()).isFalse();
            assertThat(connection.isClosed()).isFalse();
        } finally {
            connection.close();
            assertThat(connection.isValid()).isFalse();
            assertThat(connection.isClosed()).isTrue();
        }
    }
}
