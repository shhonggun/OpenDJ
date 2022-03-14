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
 * Copyright 2009 Sun Microsystems, Inc.
 * Portions copyright 2012-2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap.schema;

import static org.forgerock.opendj.ldap.schema.SchemaConstants.*;

import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.forgerock.opendj.ldap.ByteSequence;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.GeneralizedTime;

/**
 * This class defines the generalizedTimeMatch matching rule defined in X.520
 * and referenced in RFC 2252.
 */
final class GeneralizedTimeEqualityMatchingRuleImpl extends AbstractEqualityMatchingRuleImpl {

    GeneralizedTimeEqualityMatchingRuleImpl() {
        super(EMR_GENERALIZED_TIME_NAME);
    }

    @Override
    public ByteString normalizeAttributeValue(final Schema schema, final ByteSequence value) throws DecodeException {
        return normalizeAttributeValue(value);
    }

    static ByteString normalizeAttributeValue(final ByteSequence value) throws DecodeException {
        try {
            final GeneralizedTime time = GeneralizedTime.valueOf(value.toString());
            return createNormalizedAttributeValue(time.getTimeInMillis());
        } catch (LocalizedIllegalArgumentException e) {
            throw DecodeException.error(e.getMessageObject());
        }
    }

    static ByteString createNormalizedAttributeValue(final long timeInMillis) {
        /* Dates older than 1970 will be negative and will sort after dates more recent than 1970 due to twos
         * complement encoding. Therefore mangle the time in order to ensure that it is positive for all valid values
         * of a generalized time.
         */
        return ByteString.valueOfLong(timeInMillis - GeneralizedTime.MIN_GENERALIZED_TIME_MS);
    }
}
