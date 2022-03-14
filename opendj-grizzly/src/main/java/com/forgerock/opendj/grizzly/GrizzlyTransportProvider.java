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
package com.forgerock.opendj.grizzly;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;

import org.forgerock.opendj.grizzly.GrizzlyLDAPConnectionFactory;
import org.forgerock.opendj.grizzly.GrizzlyLDAPListener;
import org.forgerock.opendj.ldap.LDAPClientContext;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.responses.Response;
import org.forgerock.opendj.ldap.spi.LDAPConnectionFactoryImpl;
import org.forgerock.opendj.ldap.spi.LDAPListenerImpl;
import org.forgerock.opendj.ldap.spi.LdapMessages.LdapRequestEnvelope;
import org.forgerock.opendj.ldap.spi.TransportProvider;
import org.forgerock.util.Function;
import org.forgerock.util.Options;

import com.forgerock.reactive.ReactiveHandler;
import com.forgerock.reactive.Stream;

/**
 * Grizzly transport provider implementation.
 */
public final class GrizzlyTransportProvider implements TransportProvider {

    @Override
    public LDAPConnectionFactoryImpl getLDAPConnectionFactory(String host, int port, Options options) {
        return new GrizzlyLDAPConnectionFactory(host, port, options);
    }

    @Override
    public LDAPListenerImpl getLDAPListener(final Set<InetSocketAddress> addresses,
            final Function<LDAPClientContext,
                           ReactiveHandler<LDAPClientContext, LdapRequestEnvelope, Stream<Response>>,
                           LdapException> factory,
            final Options options) throws IOException {
        return new GrizzlyLDAPListener(addresses, options, factory);
    }

    @Override
    public String getName() {
        return "Grizzly";
    }
}
