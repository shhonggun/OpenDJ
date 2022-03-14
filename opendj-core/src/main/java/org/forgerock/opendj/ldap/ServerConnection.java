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
 * Portions copyright 2012-2016 ForgeRock AS.
 */

package org.forgerock.opendj.ldap;

import org.forgerock.opendj.ldap.requests.AbandonRequest;
import org.forgerock.opendj.ldap.requests.UnbindRequest;

/**
 * A handler interface for interacting with client connections. A
 * {@code ServerConnection} is associated with a client connection when the
 * {@link ServerConnectionFactory#handleAccept(Object) handleAccept} method is
 * invoked against a {@code ServerConnectionFactory}.
 * <p>
 * Implementations are responsible for handling connection life-cycle as well as
 * request life-cycle. In particular, a {@code ServerConnection} is responsible
 * for processing abandon and unbind requests, as well as extended operations
 * such as {@code StartTLS} and {@code Cancel} operations.
 *
 * @param <C>
 *            The type of request context.
 * @see ServerConnectionFactory
 * @deprecated will be removed as part of OPENDJ-3467.
 *             It has been replaced by {@code ReactiveHandler<>}
 */
@Deprecated
public interface ServerConnection<C> extends RequestHandler<C> {

    /**
     * Invoked when an abandon request is received from a client.
     *
     * @param requestContext
     *            The request context.
     * @param request
     *            The abandon request.
     * @throws UnsupportedOperationException
     *             If this server connection does not handle abandon requests.
     */
    void handleAbandon(C requestContext, AbandonRequest request);

    /**
     * Invoked when the client closes the connection, possibly using an unbind
     * request.
     *
     * @param requestContext
     *            The request context which should be ignored if there was no
     *            associated unbind request.
     * @param request
     *            The unbind request, which may be {@code null} if one was not
     *            sent before the connection was closed.
     */
    void handleConnectionClosed(C requestContext, UnbindRequest request);

    /**
     * Invoked when the server disconnects the client connection, possibly using
     * a disconnect notification.
     *
     * @param resultCode
     *            The result code which was included with the disconnect
     *            notification, or {@code null} if no disconnect notification
     *            was sent.
     * @param message
     *            The diagnostic message, which may be empty or {@code null}
     *            indicating that none was provided.
     */
    void handleConnectionDisconnected(ResultCode resultCode, String message);

    /**
     * Invoked when an error occurs on the connection and it is no longer
     * usable.
     *
     * @param error
     *            The exception describing the problem that occurred.
     */
    void handleConnectionError(Throwable error);

}
