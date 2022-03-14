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
 * Copyright 2011-2016 ForgeRock AS.
 */

package org.forgerock.opendj.ldap;

/**
 * The context associated with a request currently being processed by a request
 * handler. A request context can be used to query state information about the
 * request, such as whether it has been cancelled, as well as registering
 * to be notified if the request has been cancelled. Implementations may provide
 * additional information, such as the associated schema, time-stamp
 * information, etc.
 */
public interface RequestContext {

    /**
     * Registers the provided cancellation listener with this request context so
     * that it can be notified if a cancellation request is received and
     * processing of the request should be aborted if possible.
     * <p>
     * Requests may be cancelled as a result of an abandon request or a cancel
     * extended request sent from the client, or by the server itself (e.g.
     * during server shutdown).
     * <p>
     * This method provides a event notification mechanism which can be used by
     * asynchronous request handler implementations to detect cancellation of
     * requests.
     *
     * @param listener
     *            The listener which wants to be notified if a cancellation
     *            request is received and processing of the request should be
     *            aborted if possible.
     * @throws NullPointerException
     *             If the {@code listener} was {@code null}.
     * @see #checkIfCancelled
     */
    void addCancelRequestListener(CancelRequestListener listener);

    /**
     * Throws {@link CancelledResultException} if a cancellation request has
     * been received and processing of the request should be aborted if
     * possible.
     * <p>
     * Requests may be cancelled as a result of an abandon request or a cancel
     * extended request sent from the client, or by the server itself (e.g.
     * during server shutdown).
     * <p>
     * This method provides a polling mechanism which can be used by synchronous
     * request handler implementations to detect cancellation of requests.
     *
     * @param signalTooLate
     *            {@code true} to signal that, after this method returns,
     *            processing of the request will have proceeded too far for it
     *            to be aborted by subsequent cancellation requests.
     * @throws CancelledResultException
     *             If a cancellation request has been received and processing of
     *             the request should be aborted if possible.
     * @see #addCancelRequestListener
     */
    void checkIfCancelled(boolean signalTooLate) throws CancelledResultException;

    /**
     * Returns the message ID of the request, if available. Protocols, such as
     * LDAP and internal connections, include a unique message ID with each
     * request which may be useful for logging and auditing.
     *
     * @return The message ID of the request, or {@code -1} if there is no
     *         message ID associated with the request.
     */
    int getMessageID();

    /**
     * Removes the provided cancellation listener from this request context so
     * that it will not be notified if a cancellation request has been received.
     *
     * @param listener
     *            The listener which no longer wants to be notified if a
     *            cancellation request has been received.
     * @throws NullPointerException
     *             If the {@code listener} was {@code null}.
     */
    void removeCancelRequestListener(CancelRequestListener listener);
}
