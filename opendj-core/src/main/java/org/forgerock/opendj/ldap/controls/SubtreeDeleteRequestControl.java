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
 * Portions Copyright 2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap.controls;

import static com.forgerock.opendj.ldap.CoreMessages.ERR_SUBTREE_DELETE_CONTROL_BAD_OID;
import static com.forgerock.opendj.ldap.CoreMessages.ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.DecodeOptions;

import org.forgerock.util.Reject;

/**
 * The tree delete request control as defined in draft-armijo-ldap-treedelete.
 * This control allows a client to delete an entire subtree of a container entry
 * in a single delete operation.
 *
 * <pre>
 * Connection connection = ...;
 * String baseDN = ...;
 *
 * DeleteRequest request =
 *         Requests.newDeleteRequest(baseDN)
 *             .addControl(SubtreeDeleteRequestControl.newControl(true));
 * connection.delete(request);
 * </pre>
 *
 * @see <a
 *      href="http://tools.ietf.org/html/draft-armijo-ldap-treedelete">draft-armijo-ldap-treedelete
 *      - Tree Delete Control </a>
 */
public final class SubtreeDeleteRequestControl implements Control {
    /** The OID for the subtree delete request control. */
    public static final String OID = "1.2.840.113556.1.4.805";

    private static final SubtreeDeleteRequestControl CRITICAL_INSTANCE =
            new SubtreeDeleteRequestControl(true);

    private static final SubtreeDeleteRequestControl NONCRITICAL_INSTANCE =
            new SubtreeDeleteRequestControl(false);

    /** A decoder which can be used for decoding the sub-tree delete request control. */
    public static final ControlDecoder<SubtreeDeleteRequestControl> DECODER =
            new ControlDecoder<SubtreeDeleteRequestControl>() {

                @Override
                public SubtreeDeleteRequestControl decodeControl(final Control control,
                        final DecodeOptions options) throws DecodeException {
                    Reject.ifNull(control);

                    if (control instanceof SubtreeDeleteRequestControl) {
                        return (SubtreeDeleteRequestControl) control;
                    }

                    if (!control.getOID().equals(OID)) {
                        final LocalizableMessage message =
                                ERR_SUBTREE_DELETE_CONTROL_BAD_OID.get(control.getOID(), OID);
                        throw DecodeException.error(message);
                    }

                    if (control.hasValue()) {
                        final LocalizableMessage message =
                                ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE.get();
                        throw DecodeException.error(message);
                    }

                    return control.isCritical() ? CRITICAL_INSTANCE : NONCRITICAL_INSTANCE;
                }

                @Override
                public String getOID() {
                    return OID;
                }
            };

    /**
     * Creates a new tree delete request control having the provided
     * criticality.
     *
     * @param isCritical
     *            {@code true} if it is unacceptable to perform the operation
     *            without applying the semantics of this control, or
     *            {@code false} if it can be ignored.
     * @return The new control.
     */
    public static SubtreeDeleteRequestControl newControl(final boolean isCritical) {
        return isCritical ? CRITICAL_INSTANCE : NONCRITICAL_INSTANCE;
    }

    private final boolean isCritical;

    private SubtreeDeleteRequestControl(final boolean isCritical) {
        this.isCritical = isCritical;
    }

    @Override
    public String getOID() {
        return OID;
    }

    @Override
    public ByteString getValue() {
        return null;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public boolean isCritical() {
        return isCritical;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SubtreeDeleteRequestControl(oid=");
        builder.append(getOID());
        builder.append(", criticality=");
        builder.append(isCritical());
        builder.append(")");
        return builder.toString();
    }

}
