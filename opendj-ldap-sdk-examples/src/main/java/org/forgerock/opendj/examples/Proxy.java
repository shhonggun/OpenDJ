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
 * Portions Copyright 2011-2016 ForgeRock AS.
 */

package org.forgerock.opendj.examples;

import static org.forgerock.opendj.ldap.LDAPConnectionFactory.*;
import static org.forgerock.opendj.ldap.LDAPListener.*;
import static org.forgerock.opendj.ldap.requests.Requests.newSimpleBindRequest;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.forgerock.opendj.ldap.ConnectionFactory;
import org.forgerock.opendj.ldap.Connections;
import org.forgerock.opendj.ldap.ConsistentHashMap;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LDAPClientContext;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LDAPListener;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.RequestContext;
import org.forgerock.opendj.ldap.RequestHandlerFactory;
import org.forgerock.opendj.ldap.ServerConnectionFactory;
import org.forgerock.opendj.ldap.requests.BindRequest;
import org.forgerock.util.Options;

import com.forgerock.reactive.ServerConnectionFactoryAdapter;

/**
 * An LDAP load balancing proxy which forwards requests to one or more remote
 * Directory Servers. This is implementation is very simple and is only intended
 * as an example:
 * <ul>
 * <li>It does not support SSL connections
 * <li>It does not support StartTLS
 * <li>It does not support Abandon or Cancel requests
 * <li>Very basic authentication and authorization support.
 * </ul>
 * This example takes the following command line parameters:
 *
 * <pre>
 *     {@code [--load-balancer <mode>] <listenAddress> <listenPort> <proxyDN> <proxyPassword>
 *         <remoteAddress1> <remotePort1> [<remoteAddress2> <remotePort2> ...]}
 * </pre>
 *
 * Where {@code <mode>} is one of "least-requests", "fail-over", "affinity", or "distribution". The default is
 * least-requests.
 */
public final class Proxy {
    /**
     * Main method.
     *
     * @param args
     *            The command line arguments: [--load-balancer <mode>] listen address, listen port,
     *            remote address1, remote port1, remote address2, remote port2,
     *            ...
     */
    public static void main(final String[] args) {
        if (args.length < 6 || args.length % 2 != 0) {
            System.err.println("Usage: [--load-balancer <mode>] listenAddress listenPort "
                    + "proxyDN proxyPassword remoteAddress1 remotePort1 remoteAddress2 remotePort2 ...");
            System.exit(1);
        }

        // Parse command line arguments.
        int i = 0;

        final LoadBalancingAlgorithm algorithm;
        if ("--load-balancer".equals(args[i])) {
            algorithm = getLoadBalancingAlgorithm(args[i + 1]);
            i += 2;
        } else {
            algorithm = LoadBalancingAlgorithm.LEAST_REQUESTS;
        }

        final String localAddress = args[i++];
        final int localPort = Integer.parseInt(args[i++]);

        final String proxyDN = args[i++];
        final String proxyPassword = args[i++];

        // Create load balancer.
        // --- JCite pools ---
        final List<ConnectionFactory> factories = new LinkedList<>();
        final BindRequest bindRequest = newSimpleBindRequest(proxyDN, proxyPassword.toCharArray());
        final Options factoryOptions = Options.defaultOptions()
                                              .set(HEARTBEAT_ENABLED, true)
                                              .set(AUTHN_BIND_REQUEST, bindRequest);

        final List<ConnectionFactory> bindFactories = new LinkedList<>();
        final Options bindFactoryOptions = Options.defaultOptions().set(HEARTBEAT_ENABLED, true);

        for (; i < args.length; i += 2) {
            final String remoteAddress = args[i];
            final int remotePort = Integer.parseInt(args[i + 1]);

            factories.add(Connections.newCachedConnectionPool(new LDAPConnectionFactory(remoteAddress,
                                                                                        remotePort,
                                                                                        factoryOptions)));

            bindFactories.add(Connections.newCachedConnectionPool(new LDAPConnectionFactory(remoteAddress,
                                                                                            remotePort,
                                                                                            bindFactoryOptions)));
        }
        // --- JCite pools ---

        final ConnectionFactory factory = algorithm.newLoadBalancer(factories, factoryOptions);
        final ConnectionFactory bindFactory = algorithm.newLoadBalancer(bindFactories, bindFactoryOptions);

        // --- JCite backend ---
        /*
         * Create a server connection adapter which will create a new proxy
         * backend for each inbound client connection. This is required because
         * we need to maintain authorization state between client requests.
         */
        final RequestHandlerFactory<LDAPClientContext, RequestContext> proxyFactory =
                new RequestHandlerFactory<LDAPClientContext, RequestContext>() {
                    @Override
                    public ProxyBackend handleAccept(LDAPClientContext clientContext)
                            throws LdapException {
                        return new ProxyBackend(factory, bindFactory);
                    }
                };
        final ServerConnectionFactory<LDAPClientContext, Integer> connectionHandler =
                Connections.newServerConnectionFactory(proxyFactory);
        // --- JCite backend ---

        // --- JCite listener ---
        // Create listener.
        final Options options = Options.defaultOptions().set(CONNECT_MAX_BACKLOG, 4096);
        LDAPListener listener = null;
        try {
            listener = new LDAPListener(localAddress, localPort, new ServerConnectionFactoryAdapter(
                    options.get(LDAP_DECODE_OPTIONS), connectionHandler), options);
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (final IOException e) {
            System.out.println("Error listening on " + localAddress + ":" + localPort);
            e.printStackTrace();
        } finally {
            if (listener != null) {
                listener.close();
            }
        }
        // --- JCite listener ---
    }

    private static LoadBalancingAlgorithm getLoadBalancingAlgorithm(final String algorithmName) {
        switch (algorithmName) {
        case "least-requests":
            return LoadBalancingAlgorithm.LEAST_REQUESTS;
        case "fail-over":
            return LoadBalancingAlgorithm.FAIL_OVER;
        case "affinity":
            return LoadBalancingAlgorithm.AFFINITY;
        case "distribution":
            return LoadBalancingAlgorithm.DISTRIBUTION;
        default:
            System.err.println("Unrecognized load-balancing algorithm '" + algorithmName + "'. Should be one of "
                                       + "'least-requests', 'fail-over', 'affinity', or 'distribution'.");
            System.exit(1);
        }
        return LoadBalancingAlgorithm.LEAST_REQUESTS; // keep compiler happy.
    }

    private enum LoadBalancingAlgorithm {
        LEAST_REQUESTS {
            @Override
            ConnectionFactory newLoadBalancer(final Collection<ConnectionFactory> factories, final Options options) {
                // --- JCite load balancer ---
                return Connections.newLeastRequestsLoadBalancer(factories, options);
                // --- JCite load balancer ---
            }
        },
        FAIL_OVER {
            @Override
            ConnectionFactory newLoadBalancer(final Collection<ConnectionFactory> factories, final Options options) {
                return Connections.newFailoverLoadBalancer(factories, options);
            }
        },
        AFFINITY {
            @Override
            ConnectionFactory newLoadBalancer(final Collection<ConnectionFactory> factories, final Options options) {
                return Connections.newAffinityRequestLoadBalancer(factories, options);
            }
        },
        DISTRIBUTION {
            @Override
            ConnectionFactory newLoadBalancer(final Collection<ConnectionFactory> factories, final Options options) {
                final ConsistentHashMap<ConnectionFactory> partitions = new ConsistentHashMap<>();
                int i = 0;
                for (final ConnectionFactory factory : factories) {
                    partitions.put("partition-" + i++, factory);
                }
                return Connections.newFixedSizeDistributionLoadBalancer(DN.valueOf("ou=people,dc=example,dc=com"),
                                                                        partitions,
                                                                        options);
            }
        };

        abstract ConnectionFactory newLoadBalancer(Collection<ConnectionFactory> factories, Options options);
    }

    private Proxy() {
        // Not used.
    }
}
