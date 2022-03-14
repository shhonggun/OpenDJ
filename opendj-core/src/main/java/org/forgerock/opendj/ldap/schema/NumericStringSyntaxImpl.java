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
 * Portions Copyright 2016 ForgeRock AS.
 */

package org.forgerock.opendj.ldap.schema;

import static com.forgerock.opendj.util.StaticUtils.isDigit;
import static com.forgerock.opendj.ldap.CoreMessages.ERR_ATTR_SYNTAX_NUMERIC_STRING_EMPTY_VALUE;
import static com.forgerock.opendj.ldap.CoreMessages.WARN_ATTR_SYNTAX_NUMERIC_STRING_ILLEGAL_CHAR;
import static org.forgerock.opendj.ldap.schema.SchemaConstants.EMR_NUMERIC_STRING_OID;
import static org.forgerock.opendj.ldap.schema.SchemaConstants.OMR_NUMERIC_STRING_OID;
import static org.forgerock.opendj.ldap.schema.SchemaConstants.SMR_CASE_EXACT_OID;
import static org.forgerock.opendj.ldap.schema.SchemaConstants.SYNTAX_NUMERIC_STRING_NAME;

import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.opendj.ldap.ByteSequence;

/**
 * This class implements the numeric string attribute syntax, which may be hold
 * one or more numeric digits and/or spaces. Equality, ordering, and substring
 * matching will be allowed by default.
 */
final class NumericStringSyntaxImpl extends AbstractSyntaxImpl {

    @Override
    public String getEqualityMatchingRule() {
        return EMR_NUMERIC_STRING_OID;
    }

    @Override
    public String getName() {
        return SYNTAX_NUMERIC_STRING_NAME;
    }

    @Override
    public String getOrderingMatchingRule() {
        return OMR_NUMERIC_STRING_OID;
    }

    @Override
    public String getSubstringMatchingRule() {
        return SMR_CASE_EXACT_OID;
    }

    @Override
    public boolean isHumanReadable() {
        return true;
    }

    @Override
    public boolean valueIsAcceptable(final Schema schema, final ByteSequence value,
            final LocalizableMessageBuilder invalidReason) {
        final String valueString = value.toString();
        final int length = valueString.length();

        // It must have at least one digit or space.
        if (length == 0) {
            invalidReason.append(ERR_ATTR_SYNTAX_NUMERIC_STRING_EMPTY_VALUE.get());
            return false;
        }

        // Iterate through the characters and make sure they are all digits
        // or spaces.
        for (int i = 0; i < length; i++) {
            final char c = valueString.charAt(i);
            if (!isDigit(c) && c != ' ') {
                invalidReason.append(WARN_ATTR_SYNTAX_NUMERIC_STRING_ILLEGAL_CHAR.get(valueString,
                        String.valueOf(c), i));
                return false;
            }
        }

        return true;
    }
}
