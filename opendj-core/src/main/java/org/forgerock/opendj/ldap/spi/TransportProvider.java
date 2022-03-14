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
package org.forgerock.opendj.ldap.spi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;

import org.forgerock.opendj.ldap.LDAPClientContext;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.responses.Response;
import org.forgerock.opendj.ldap.spi.LdapMessages.LdapRequestEnvelope;
import org.forgerock.util.Function;
import org.forgerock.util.Options;

import com.forgerock.reactive.ReactiveHandler;
import com.forgerock.reactive.Stream;

/**
 * Interface for transport providers, which provide implementation
 * for {@code LDAPConnectionFactory} and {@code LDAPListener} classes,
 * using a specific transport.
 * <p>
 * A transport provider must be declared in the provider-configuration file
 * {@code META-INF/services/org.forgerock.opendj.ldap.spi.TransportProvider}
 * in order to allow automatic loading of the implementation classes using the
 * {@code java.util.ServiceLoader} facility.
 */
public interface TransportProvider extends Provider {

    /**
     * Returns an implementation of {@code LDAPConnectionFactory}. The address
     * will be resolved each time a new connection is returned.
     *
     * @param host
     *            The hostname of the Directory Server to connect to.
     * @param port
     *            The port number of the Directory Server to connect to.
     * @param options
     *            The LDAP options to use when creating connections.
     * @return an implementation of {@code LDAPConnectionFactory}
     */
    LDAPConnectionFactoryImpl getLDAPConnectionFactory(String host, int port, Options options);

  /**
     * Returns an implementation of {@code LDAPListener}.
     *
     * @param addresses
     *            The addresses to listen on.
     * @param factory
     *            The handler factory which will be used to create handlers.
     * @param options
     *            The LDAP listener options.
     * @return an implementation of {@code LDAPListener}
     * @throws IOException
     *             If an error occurred while trying to listen on the provided
     *             address.
     */
    LDAPListenerImpl getLDAPListener(Set<InetSocketAddress> addresses,
            Function<LDAPClientContext,
                     ReactiveHandler<LDAPClientContext, LdapRequestEnvelope, Stream<Response>>,
                     LdapException> factory,
            Options options) throws IOException;
}
