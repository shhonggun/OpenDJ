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
 * Portions copyright 2011-2016 ForgeRock AS.
 */

package com.forgerock.opendj.util;

/**
 * A {@code ASCIICharProp} provides fast access to ASCII character properties.
 * In particular, the ability to query whether a character is a letter, a
 * digit, hexadecimal character, as well as various methods for performing
 * character conversions.
 * <p>
 * The methods in this class do not perform memory allocations nor calculations
 * and so can be used safely in high performance situations.
 */
public final class ASCIICharProp implements Comparable<ASCIICharProp> {
    private final char c;

    private final char upperCaseChar;

    private final char lowerCaseChar;

    private final boolean isUpperCaseChar;

    private final boolean isLowerCaseChar;

    private final boolean isDigit;

    private final boolean isLetter;

    private final boolean isKeyChar;

    private final boolean isCompatKeyChar;

    private final boolean isHexChar;

    private final int hexValue;

    private final int decimalValue;

    private final String stringValue;

    private static final ASCIICharProp[] CHAR_PROPS = new ASCIICharProp[128];

    static {
        for (int i = 0; i < 128; i++) {
            CHAR_PROPS[i] = new ASCIICharProp((char) i);
        }
    }

    /**
     * Returns the character properties for the provided ASCII character. If a
     * non-ASCII character is provided then this method returns {@code null}.
     *
     * @param c
     *            The ASCII character.
     * @return The character properties for the provided ASCII character, or
     *         {@code null} if {@code c} is greater than {@code \u007F} .
     */
    public static ASCIICharProp valueOf(final char c) {
        if (c < 128) {
            return CHAR_PROPS[c];
        } else {
            return null;
        }
    }

    /**
     * Returns the character properties for the provided ASCII character. If a
     * non-ASCII character is provided then this method returns {@code null}.
     *
     * @param c
     *            The ASCII character.
     * @return The character properties for the provided ASCII character, or
     *         {@code null} if {@code c} is less than zero or greater than
     *         {@code \u007F} .
     */
    public static ASCIICharProp valueOf(final int c) {
        if (c >= 0 && c < 128) {
            return CHAR_PROPS[c];
        } else {
            return null;
        }
    }

    private ASCIICharProp(final char c) {
        this.c = c;
        this.stringValue = new String(new char[] { c });

        if (c >= 'a' && c <= 'z') {
            this.upperCaseChar = (char) (c - 32);
            this.lowerCaseChar = c;
            this.isUpperCaseChar = false;
            this.isLowerCaseChar = true;
            this.isDigit = false;
            this.isLetter = true;
            this.isKeyChar = true;
            this.isCompatKeyChar = true;
            this.decimalValue = -1;
            if (c >= 'a' && c <= 'f') {
                this.isHexChar = true;
                this.hexValue = c - 87;
            } else {
                this.isHexChar = false;
                this.hexValue = -1;
            }
        } else if (c >= 'A' && c <= 'Z') {
            this.upperCaseChar = c;
            this.lowerCaseChar = (char) (c + 32);
            this.isUpperCaseChar = true;
            this.isLowerCaseChar = false;
            this.isDigit = false;
            this.isLetter = true;
            this.isKeyChar = true;
            this.isCompatKeyChar = true;
            this.decimalValue = -1;
            if (c >= 'A' && c <= 'F') {
                this.isHexChar = true;
                this.hexValue = c - 55;
            } else {
                this.isHexChar = false;
                this.hexValue = -1;
            }
        } else if (c >= '0' && c <= '9') {
            this.upperCaseChar = c;
            this.lowerCaseChar = c;
            this.isUpperCaseChar = false;
            this.isLowerCaseChar = false;
            this.isDigit = true;
            this.isLetter = false;
            this.isKeyChar = true;
            this.isCompatKeyChar = true;
            this.isHexChar = true;
            this.hexValue = c - 48;
            this.decimalValue = c - 48;
        } else {
            this.upperCaseChar = c;
            this.lowerCaseChar = c;
            this.isUpperCaseChar = false;
            this.isLowerCaseChar = false;
            this.isDigit = false;
            this.isLetter = false;
            this.isKeyChar = c == '-';
            this.isCompatKeyChar = (c == '-') || (c == '.') || (c == '_') || (c == '=');
            this.isHexChar = false;
            this.hexValue = -1;
            this.decimalValue = -1;
        }
    }

    /**
     * Returns the char value associated with this {@code ASCIICharProp}.
     *
     * @return The char value associated with this {@code ASCIICharProp}.
     */
    public char charValue() {
        return c;
    }

    @Override
    public int compareTo(final ASCIICharProp o) {
        return c - o.c;
    }

    /**
     * Returns the decimal value associated with this {@code ASCIICharProp}, or
     * {@code -1} if the value is not a decimal digit.
     *
     * @return The decimal value associated with this {@code ASCIICharProp}, or
     *         {@code -1} if the value is not a decimal digit.
     */
    public int decimalValue() {
        return decimalValue;
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return c;
    }

    /**
     * Returns the hexadecimal value associated with this {@code ASCIICharProp}
     * , or {@code -1} if the value is not a hexadecimal digit.
     *
     * @return The hexadecimal value associated with this {@code ASCIICharProp}
     *         , or {@code -1} if the value is not a hexadecimal digit.
     */
    public int hexValue() {
        return hexValue;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is a decimal digit.
     *
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is a decimal digit.
     */
    public boolean isDigit() {
        return isDigit;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is a hexadecimal digit.
     *
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is a hexadecimal digit.
     */
    public boolean isHexDigit() {
        return isHexChar;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is a {@code keychar} as defined in RFC 4512. A
     * {@code keychar} is a letter, a digit, or a hyphen. When
     * {@code allowCompatChars} is {@code true} the following illegal characters
     * will be permitted:
     *
     * <pre>
     * HYPHEN  = %x2D ; hyphen ("-")
     * DOT     = %x2E ; period (".")
     * EQUALS  = %x3D ; equals sign ("=")
     * USCORE  = %x5F ; underscore ("_")
     * </pre>
     *
     * @param allowCompatChars
     *            {@code true} if certain illegal characters should be allowed
     *            for compatibility reasons.
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is a {@code keychar}.
     */
    public boolean isKeyChar(final boolean allowCompatChars) {
        return allowCompatChars ? isCompatKeyChar : isKeyChar;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is a letter.
     *
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is a letter.
     */
    public boolean isLetter() {
        return isLetter;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is a lower-case character.
     *
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is a lower-case character.
     */
    public boolean isLowerCase() {
        return isLowerCaseChar;
    }

    /**
     * Indicates whether the char value associated with this
     * {@code ASCIICharProp} is an upper-case character.
     *
     * @return {@code true} if the char value associated with this
     *         {@code ASCIICharProp} is an upper-case character.
     */
    public boolean isUpperCase() {
        return isUpperCaseChar;
    }

    /**
     * Returns the lower-case char value associated with this
     * {@code ASCIICharProp}.
     *
     * @return The lower-case char value associated with this
     *         {@code ASCIICharProp}.
     */
    public char toLowerCase() {
        return lowerCaseChar;
    }

    @Override
    public String toString() {
        return stringValue;
    }

    /**
     * Returns the upper-case char value associated with this
     * {@code ASCIICharProp}.
     *
     * @return The upper-case char value associated with this
     *         {@code ASCIICharProp}.
     */
    public char toUpperCase() {
        return upperCaseChar;
    }

}
