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

import static com.forgerock.opendj.ldap.CoreMessages.WARN_ATTR_SYNTAX_PRINTABLE_STRING_EMPTY_VALUE;
import static com.forgerock.opendj.ldap.CoreMessages.WARN_ATTR_SYNTAX_PRINTABLE_STRING_ILLEGAL_CHARACTER;
import static org.forgerock.opendj.ldap.schema.SchemaConstants.*;

import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.opendj.ldap.ByteSequence;

/**
 * This class implements the printable string attribute syntax, which is simply
 * a string of characters from a limited ASCII character set (uppercase and
 * lowercase letters, numeric digits, the space, and a set of various symbols).
 * By default, they will be treated in a case-insensitive manner, and equality,
 * ordering, substring, and approximate matching will be allowed.
 */
final class PrintableStringSyntaxImpl extends AbstractSyntaxImpl {

    /**
     * Indicates whether the provided character is a valid printable character.
     *
     * @param c
     *            The character for which to make the determination.
     * @return <CODE>true</CODE> if the provided character is a printable
     *         character, or <CODE>false</CODE> if not.
     */
    static boolean isPrintableCharacter(final char c) {
        switch (c) {
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '\'':
        case '(':
        case ')':
        case '+':
        case ',':
        case '-':
        case '.':
        case '=':
        case '/':
        case ':':
        case '?':
        case ' ':
            return true;
        default:
            return false;
        }
    }

    @Override
    public String getApproximateMatchingRule() {
        return AMR_DOUBLE_METAPHONE_OID;
    }

    @Override
    public String getEqualityMatchingRule() {
        return EMR_CASE_IGNORE_OID;
    }

    @Override
    public String getName() {
        return SYNTAX_PRINTABLE_STRING_NAME;
    }

    @Override
    public String getOrderingMatchingRule() {
        return OMR_CASE_IGNORE_OID;
    }

    @Override
    public String getSubstringMatchingRule() {
        return SMR_CASE_IGNORE_OID;
    }

    @Override
    public boolean isHumanReadable() {
        return true;
    }

    @Override
    public boolean valueIsAcceptable(final Schema schema, final ByteSequence value,
            final LocalizableMessageBuilder invalidReason) {
        // Check to see if the provided value was null. If so, then that's
        // not acceptable.
        if (value == null) {
            invalidReason.append(WARN_ATTR_SYNTAX_PRINTABLE_STRING_EMPTY_VALUE.get());
            return false;
        }

        // Get the value as a string and determine its length. If it is
        // empty, then that's not acceptable.
        final String valueString = value.toString();
        final int valueLength = valueString.length();
        if (valueLength == 0) {
            invalidReason.append(WARN_ATTR_SYNTAX_PRINTABLE_STRING_EMPTY_VALUE.get());
            return false;
        }

        // Iterate through all the characters and see if they are
        // acceptable.
        for (int i = 0; i < valueLength; i++) {
            final char c = valueString.charAt(i);
            if (!isPrintableCharacter(c)) {
                invalidReason.append(WARN_ATTR_SYNTAX_PRINTABLE_STRING_ILLEGAL_CHARACTER.get(
                        valueString, String.valueOf(c), i));
                return false;
            }
        }

        // If we've gotten here, then the value is OK.
        return true;
    }
}
