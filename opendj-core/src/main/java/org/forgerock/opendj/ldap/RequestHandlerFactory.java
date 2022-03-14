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
 * Copyright 2011-2014 ForgeRock AS.
 */

package org.forgerock.opendj.ldap;

/**
 * A handler interface for accepting new connections from clients.
 *
 * @param <C>
 *            The type of client context.
 * @param <R>
 *            The type of request context.
 */
public interface RequestHandlerFactory<C, R extends RequestContext> {
    /**
     * Invoked when a new client connection is accepted by the associated
     * listener. Implementations should return a {@code RequestHandler} which
     * will be used to handle requests from the client connection.
     *
     * @param clientContext
     *            The protocol dependent context information associated with the
     *            client connection. Depending on the protocol this may contain
     *            information about the client such as their address and level
     *            connection security. It may also be used to manage the state
     *            of the client's connection.
     * @return A {@code RequestHandler} which will be used to handle requests
     *         from a client connection.
     * @throws LdapException
     *             If this request handler factory cannot accept the client
     *             connection.
     */
    RequestHandler<R> handleAccept(C clientContext) throws LdapException;
}
