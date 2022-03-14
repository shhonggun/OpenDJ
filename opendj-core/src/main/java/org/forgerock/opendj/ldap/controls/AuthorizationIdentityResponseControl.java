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
package org.forgerock.opendj.ldap.controls;

import static com.forgerock.opendj.ldap.CoreMessages.ERR_AUTHZIDRESP_CONTROL_BAD_OID;
import static com.forgerock.opendj.ldap.CoreMessages.ERR_AUTHZIDRESP_NO_CONTROL_VALUE;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.DecodeOptions;

import org.forgerock.util.Reject;

/**
 * The authorization response control as defined in RFC 3829. The authorization
 * identity control extends the Lightweight Directory Access Protocol (LDAP)
 * bind operation with a mechanism for requesting and returning the
 * authorization identity it establishes.
 * <p>
 * The authorization identity is specified using an authorization ID, or
 * {@code authzId}, as defined in RFC 4513 section 5.2.1.8.
 * <p>
 * The following excerpt shows how to get the authorization identity established
 * when binding to the directory server.
 *
 * <pre>
 * Connection connection = ...;
 * String bindDN = ...;
 * String bindPassword = ...;
 *
 * BindRequest request =
 *         Requests.newSimpleBindRequest(bindDN, bindPassword.toCharArray())
 *             .addControl(AuthorizationIdentityRequestControl
 *                     .newControl(true));
 *
 * BindResult result = connection.bind(request);
 * AuthorizationIdentityResponseControl control =
 *         result.getControl(AuthorizationIdentityResponseControl.DECODER,
 *                 new DecodeOptions());
 * // Authorization ID returned: control.getAuthorizationID()
 * </pre>
 *
 * @see AuthorizationIdentityRequestControl
 * @see org.forgerock.opendj.ldap.requests.WhoAmIExtendedRequest
 * @see <a href="http://tools.ietf.org/html/rfc3829">RFC 3829 - Lightweight
 *      Directory Access Protocol (LDAP) Authorization Identity Request and
 *      Response Controls </a>
 * @see <a href="http://tools.ietf.org/html/rfc4532">RFC 4532 - Lightweight
 *      Directory Access Protocol (LDAP) "Who am I?" Operation </a>
 * @see <a href="http://tools.ietf.org/html/rfc4513#section-5.2.1.8">RFC 4513 -
 *      SASL Authorization Identities (authzId) </a>
 */
public final class AuthorizationIdentityResponseControl implements Control {

    /** The OID for the authorization identity response control. */
    public static final String OID = "2.16.840.1.113730.3.4.15";

    /**
     * Creates a new authorization identity response control using the provided
     * authorization ID.
     *
     * @param authorizationID
     *            The authorization ID for this control.
     * @return The new control.
     * @throws NullPointerException
     *             If {@code authorizationID} was {@code null}.
     */
    public static AuthorizationIdentityResponseControl newControl(final String authorizationID) {
        return new AuthorizationIdentityResponseControl(false, authorizationID);
    }

    /** The authorization ID for this control. */
    private final String authorizationID;

    private final boolean isCritical;

    /** A decoder which can be used for decoding the authorization identity response control. */
    public static final ControlDecoder<AuthorizationIdentityResponseControl> DECODER =
            new ControlDecoder<AuthorizationIdentityResponseControl>() {

                @Override
                public AuthorizationIdentityResponseControl decodeControl(final Control control,
                        final DecodeOptions options) throws DecodeException {
                    Reject.ifNull(control);

                    if (control instanceof AuthorizationIdentityResponseControl) {
                        return (AuthorizationIdentityResponseControl) control;
                    }

                    if (!control.getOID().equals(OID)) {
                        final LocalizableMessage message =
                                ERR_AUTHZIDRESP_CONTROL_BAD_OID.get(control.getOID(), OID);
                        throw DecodeException.error(message);
                    }

                    if (!control.hasValue()) {
                        // The response control must always have a value.
                        final LocalizableMessage message = ERR_AUTHZIDRESP_NO_CONTROL_VALUE.get();
                        throw DecodeException.error(message);
                    }

                    final String authID = control.getValue().toString();
                    return new AuthorizationIdentityResponseControl(control.isCritical(), authID);
                }

                @Override
                public String getOID() {
                    return OID;
                }
            };

    /** Prevent direct instantiation. */
    private AuthorizationIdentityResponseControl(final boolean isCritical,
            final String authorizationID) {
        Reject.ifNull(authorizationID);
        this.isCritical = isCritical;
        this.authorizationID = authorizationID;
    }

    /**
     * Returns the authorization ID of the user. The authorization ID usually
     * has the form "dn:" immediately followed by the distinguished name of the
     * user, or "u:" followed by a user ID string, but other forms are
     * permitted.
     *
     * @return The authorization ID of the user.
     */
    public String getAuthorizationID() {
        return authorizationID;
    }

    @Override
    public String getOID() {
        return OID;
    }

    @Override
    public ByteString getValue() {
        return ByteString.valueOfUtf8(authorizationID);
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public boolean isCritical() {
        return isCritical;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AuthorizationIdentityResponseControl(oid=");
        builder.append(getOID());
        builder.append(", criticality=");
        builder.append(isCritical());
        builder.append(", authzID=\"");
        builder.append(authorizationID);
        builder.append("\")");
        return builder.toString();
    }

}
