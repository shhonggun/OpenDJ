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

package org.forgerock.opendj.ldap.requests;

import static org.forgerock.opendj.ldap.LdapException.newLdapException;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.responses.BindResult;

/**
 * External SASL bind request implementation.
 */
final class ExternalSASLBindRequestImpl extends AbstractSASLBindRequest<ExternalSASLBindRequest>
        implements ExternalSASLBindRequest {
    private static final class Client extends SASLBindClientImpl {
        private final SaslClient saslClient;

        private Client(final ExternalSASLBindRequestImpl initialBindRequest, final String serverName)
                throws LdapException {
            super(initialBindRequest);

            try {
                saslClient =
                        Sasl.createSaslClient(new String[] { SASL_MECHANISM_NAME },
                                initialBindRequest.getAuthorizationID(), SASL_DEFAULT_PROTOCOL,
                                serverName, null, this);
                if (saslClient.hasInitialResponse()) {
                    setNextSASLCredentials(saslClient.evaluateChallenge(new byte[0]));
                } else {
                    setNextSASLCredentials((ByteString) null);
                }
            } catch (final SaslException e) {
                throw newLdapException(ResultCode.CLIENT_SIDE_LOCAL_ERROR, e);
            }
        }

        @Override
        public void dispose() {
            try {
                saslClient.dispose();
            } catch (final SaslException ignored) {
                // Ignore the SASL exception.
            }
        }

        @Override
        public boolean evaluateResult(final BindResult result) throws LdapException {
            return evaluateSaslBindResult(saslClient, result);
        }
    }

    private String authorizationID;

    ExternalSASLBindRequestImpl() {
        // Nothing to do.
    }

    ExternalSASLBindRequestImpl(final ExternalSASLBindRequest externalSASLBindRequest) {
        super(externalSASLBindRequest);
        this.authorizationID = externalSASLBindRequest.getAuthorizationID();
    }

    @Override
    public BindClient createBindClient(final String serverName) throws LdapException {
        return new Client(this, serverName);
    }

    @Override
    public String getAuthorizationID() {
        return authorizationID;
    }

    @Override
    public String getSASLMechanism() {
        return SASL_MECHANISM_NAME;
    }

    @Override
    public ExternalSASLBindRequest setAuthorizationID(final String authorizationID) {
        this.authorizationID = authorizationID;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ExternalSASLBindRequest(bindDN=");
        builder.append(getName());
        builder.append(", authentication=SASL");
        builder.append(", saslMechanism=");
        builder.append(getSASLMechanism());
        builder.append(", authorizationID=");
        builder.append(authorizationID);
        builder.append(", controls=");
        builder.append(getControls());
        builder.append(")");
        return builder.toString();
    }
}
