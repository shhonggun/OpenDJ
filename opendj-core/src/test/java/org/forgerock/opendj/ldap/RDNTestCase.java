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
 * Portions copyright 2011-2016 ForgeRock AS.
 */

package org.forgerock.opendj.ldap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.Iterator;

import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.Schema;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class defines a set of tests for the
 * {@link org.forgerock.opendj.ldap.RDN} class.
 */
@SuppressWarnings("javadoc")
public final class RDNTestCase extends SdkTestCase {

    /** Domain component attribute type. */
    private static final AttributeType ATTR_TYPE_DC;

    /** Common name attribute type. */
    private static final AttributeType ATTR_TYPE_CN;

    /** Test attribute value. */
    private static final AVA ATTR_VALUE_DC_ORG;

    static {
        ATTR_TYPE_DC = Schema.getCoreSchema().getAttributeType("dc");
        ATTR_TYPE_CN = Schema.getCoreSchema().getAttributeType("cn");
        // Set the avas.
        ATTR_VALUE_DC_ORG = new AVA(ATTR_TYPE_DC, ByteString.valueOfUtf8("org"));
    }

    /** "org" bytestring. */
    private static final ByteString ORG = ByteString.valueOfUtf8("org");

    /**
     * RDN test data provider.
     *
     * @return The array of test RDN strings.
     */
    @DataProvider(name = "testRDNs")
    public Object[][] createData() {
        return new Object[][] {
            { "dc=hello world", "dc=hello world", "dc=hello world" },
            { "dc =hello world", "dc=hello world", "dc=hello world" },
            { "dc  =hello world", "dc=hello world", "dc=hello world" },
            { "dc= hello world", "dc=hello world", "dc=hello world" },
            { "dc=  hello world", "dc=hello world", "dc=hello world" },
            { "undefined=hello", "undefined=hello", "undefined=hello" },
            { "DC=HELLO WORLD", "dc=hello world", "DC=HELLO WORLD" },
            { "dc = hello    world", "dc=hello world", "dc=hello    world" },
            { "   dc = hello world   ", "dc=hello world", "dc=hello world" },
            { "givenName=John+cn=Doe", "cn=doe+givenname=john", "givenName=John+cn=Doe" },
            { "givenName=John\\+cn=Doe", "givenname=john\\+cn\\=doe", "givenName=John\\+cn=Doe" },
            { "cn=Doe\\, John", "cn=doe\\, john", "cn=Doe\\, John" },
            { "OU=Sales+CN=J. Smith", "cn=j. smith+ou=sales", "OU=Sales+CN=J. Smith" },
            { "CN=James \\\"Jim\\\" Smith\\, III", "cn=james \\\"jim\\\" smith\\, iii",
                "CN=James \\\"Jim\\\" Smith\\, III" },
            // \0d is a hex representation of Carriage return. It is mapped
            // to a SPACE as defined in the MAP ( RFC 4518)
            { "CN=Before\\0dAfter", "cn=before after", "CN=Before\\0dAfter" },
            { "cn=#04024869",
                // Unicode codepoints from 0000-0008 are mapped to nothing.
                "cn=hi", "cn=\\04\\02Hi" },
            { "CN=Lu\\C4\\8Di\\C4\\87", "cn=lu\u010di\u0107", "CN=Lu\u010di\u0107" },
            { "ou=\\e5\\96\\b6\\e6\\a5\\ad\\e9\\83\\a8", "ou=\u55b6\u696d\u90e8",
                "ou=\u55b6\u696d\u90e8" },
            { "photo=\\ john \\ ", "photo=\\ john \\ ", "photo=\\ john \\ " },
            { "AB-global=", "ab-global=", "AB-global=" },
            { "cn=John+a=", "a=+cn=john", "cn=John+a=" },
            { "O=\"Sue, Grabbit and Runn\"", "o=sue\\, grabbit and runn",
                "O=Sue\\, Grabbit and Runn" }, };
    }

    /**
     * Illegal RDN test data provider.
     *
     * @return The array of illegal test RDN strings.
     */
    @DataProvider(name = "illegalRDNs")
    public Object[][] createIllegalData() {
        // @formatter:off
        return new Object[][] {
            { null },
            { "" },
            { " " },
            { "=" },
            { "manager" },
            { "manager " },
            { "cn+" },
            { "cn+Jim" },
            { "cn=Jim+" },
            { "cn=Jim +" },
            { "cn=Jim+ " },
            { "cn=Jim+cn=John" },
            { "cn=Jim+sn" },
            { "cn=Jim+sn " },
            { "cn=Jim+sn equals" },
            { "cn=Jim," },
            { "cn=Jim;" },
            { "cn=Jim,  " },
            { "cn=Jim+sn=a," },
            { "cn=Jim, sn=Jam " },
            { "cn+uid=Jim" },
            { "-cn=Jim" },
            { "/tmp=a" },
            { "\\tmp=a" },
            { "cn;lang-en=Jim" },
            { "@cn=Jim" },
            { "_name_=Jim" },
            { "\u03c0=pi" },
            { "v1.0=buggy" },
            { "cn=Jim+sn=Bob++" },
            { "cn=Jim+sn=Bob+," },
            { "1.3.6.1.4.1.1466..0=#04024869" },
        };
        // @formatter:on
    }

    /**
     * RDN equality test data provider.
     *
     * @return The array of test RDN strings.
     */
    @DataProvider(name = "createRDNEqualityData")
    public Object[][] createRDNEqualityData() {
        // @formatter:off
        return new Object[][] {
            { "cn=hello world", "cn=hello world", 0 },
            { "cn=hello world", "CN=hello world", 0 },
            { "cn=hello   world", "cn=hello world", 0 },
            { "  cn =  hello world  ", "cn=hello world", 0 },
            { "cn=hello world\\ ", "cn=hello world", 0 },
            { "cn=HELLO WORLD", "cn=hello world", 0 },
            { "cn=HELLO+sn=WORLD", "sn=world+cn=hello", 0 },
            { "cn=HELLO+sn=WORLD", "cn=hello+sn=nurse", 1 },
            { "cn=HELLO+sn=WORLD", "cn=howdy+sn=yall", -1 },
            { "cn=hello", "cn=hello+sn=world", -1 },
            { "cn=hello+sn=world", "cn=hello", 1 },
            { "cn=hello+sn=world", "cn=hello+description=world", 1 },
            { "cn=hello", "sn=world", -1 },
            { "sn=hello", "cn=world", 1 },
            { "governingStructureRule=10", "governingStructureRule=9", 1 },
            { "governingStructureRule=999", "governingStructureRule=1000", -1 },
            { "governingStructureRule=-1", "governingStructureRule=0", -1 },
            { "governingStructureRule=0", "governingStructureRule=-1", 1 },
            { "cn=aaa", "cn=aaaa", -1 },
            { "cn=AAA", "cn=aaaa", -1 },
            { "cn=aaa", "cn=AAAA", -1 },
            { "cn=aaaa", "cn=aaa", 1 },
            { "cn=AAAA", "cn=aaa", 1 },
            { "cn=aaaa", "cn=AAA", 1 },
            { "cn=aaab", "cn=aaaa", 1 },
            { "cn=aaaa", "cn=aaab", -1 },
            { RDN.maxValue(), RDN.maxValue(), 0 },
            { RDN.maxValue(), "cn=aaa", 1 },
            { "cn=aaa", RDN.maxValue(), -1 },
        };
        // @formatter:on
    }

    /**
     * Test RDN compareTo
     *
     * @param first
     *            First RDN to compare.
     * @param second
     *            Second RDN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createRDNEqualityData")
    public void testCompareTo(final Object first, final Object second, final int result)
            throws Exception {
        final RDN rdn1 = parseRDN(first);
        final RDN rdn2 = parseRDN(second);

        int rc = rdn1.compareTo(rdn2);

        // Normalize the result.
        if (rc < 0) {
            rc = -1;
        } else if (rc > 0) {
            rc = 1;
        }

        assertEquals(rc, result, "Comparison for <" + first + "> and <" + second + ">.");
    }

    private RDN parseRDN(final Object value) {
        return (value instanceof RDN) ? ((RDN) value) : RDN.valueOf(value.toString());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void ensureRDNIsCreatedWithNonEmptyArguments() {
        new RDN();
    }

    /**
     * Test RDN construction with single AVA.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testConstructor() throws Exception {
        final RDN rdn = new RDN(ATTR_TYPE_DC, ORG);

        assertEquals(rdn.size(), 1);
        assertEquals(rdn.isMultiValued(), false);
        assertEquals(rdn.getFirstAVA().getAttributeType(), ATTR_TYPE_DC);
        assertEquals(rdn.getFirstAVA().getAttributeType().getNameOrOID(), ATTR_TYPE_DC.getNameOrOID());
        assertEquals(rdn.getFirstAVA(), ATTR_VALUE_DC_ORG);
    }

    /**
     * Test RDN construction with String attribute type and value.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testConstructorWithString() throws Exception {
        final RDN rdn = new RDN("dc", "org");
        assertEquals(rdn.size(), 1);
        assertEquals(rdn.getFirstAVA().getAttributeType(), ATTR_TYPE_DC);
        assertEquals(rdn.getFirstAVA().getAttributeType().getNameOrOID(), "dc");
        assertEquals(rdn.getFirstAVA(), ATTR_VALUE_DC_ORG);
    }

    @Test
    public void testConstructorWithAVA() throws Exception {
        final RDN rdn = new RDN(new AVA("dc", "org"));
        assertEquals(rdn.size(), 1);
        assertEquals(rdn.getFirstAVA().getAttributeType(), ATTR_TYPE_DC);
        assertEquals(rdn.getFirstAVA(), ATTR_VALUE_DC_ORG);
    }

    @Test
    public void testConstructorWithMultipleAVAs() throws Exception {
        AVA example = new AVA("dc", "example");
        AVA user = new AVA("cn", "bjensen");

        final RDN rdn = new RDN(example, user);
        assertEquals(rdn.size(), 2);
        Iterator<AVA> rdnIt = rdn.iterator();
        AVA firstAva = rdnIt.next();
        assertEquals(firstAva.getAttributeType(), ATTR_TYPE_DC);
        assertEquals(firstAva, example);

        AVA secondAva = rdnIt.next();
        assertEquals(secondAva.getAttributeType(), ATTR_TYPE_CN);
        assertEquals(secondAva, user);
    }

    @Test(expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testConstructorWithDuplicateAVAs() {
        AVA example = new AVA("dc", "example");
        AVA org = new AVA("dc", "org");
        new RDN(example, org);
    }

    @Test
    public void testConstructorWithCollectionOfAVAs() throws Exception {
        AVA example = new AVA("dc", "example");
        AVA user = new AVA("cn", "bjensen");

        final RDN rdn = new RDN(Arrays.asList(example, user));
        assertEquals(rdn.size(), 2);
        Iterator<AVA> rdnIt = rdn.iterator();
        AVA firstAva = rdnIt.next();
        assertEquals(firstAva.getAttributeType(), ATTR_TYPE_DC);
        assertEquals(firstAva, example);

        AVA secondAva = rdnIt.next();
        assertEquals(secondAva.getAttributeType(), ATTR_TYPE_CN);
        assertEquals(secondAva, user);
    }

    @Test(expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testConstructorWithCollectionOfDuplicateAVAs() {
        AVA example = new AVA("dc", "example");
        AVA org = new AVA("dc", "org");
        new RDN(Arrays.asList(example, org));
    }

    /**
     * Test RDN string decoder against illegal strings.
     *
     * @param rawRDN
     *            Illegal RDN string representation.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "illegalRDNs", expectedExceptions = { NullPointerException.class,
            LocalizedIllegalArgumentException.class, StringIndexOutOfBoundsException.class })
    public void testDecodeIllegalString(final String rawRDN) throws Exception {
        RDN.valueOf(rawRDN);

        fail("Expected exception for value \"" + rawRDN + "\"");
    }

    /**
     * Test RDN string decoder.
     *
     * @param rawRDN
     *            Raw RDN string representation.
     * @param normRDN
     *            Normalized RDN string representation.
     * @param stringRDN
     *            String representation.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    /**
     * @Test(dataProvider = "testRDNs") public void testToString(String rawRDN,
     *                    String normRDN, String stringRDN) throws Exception {
     *                    RDN rdn = RDN.valueOf(rawRDN);
     *                    assertEquals(rdn.toString(), stringRDN); }
     **/

    /**
     * Test RDN string decoder.
     *
     * @param rawRDN
     *            Raw RDN string representation.
     * @param normRDN
     *            Normalized RDN string representation.
     * @param stringRDN
     *            String representation.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "testRDNs")
    public void testDecodeString(final String rawRDN, final String normRDN, final String stringRDN)
            throws Exception {
        final RDN rdn = RDN.valueOf(rawRDN);
        final RDN string = RDN.valueOf(stringRDN);
        assertEquals(rdn, string);
    }

    /**
     * Tests the valueof with ctor.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testDuplicateSingle() {
        final RDN rdn1 = new RDN(ATTR_TYPE_DC, ORG);
        final RDN rdn2 = RDN.valueOf("dc=org");

        assertFalse(rdn1 == rdn2);
        assertEquals(rdn1, rdn2);
    }

    /**
     * Test RDN equality
     *
     * @param first
     *            First RDN to compare.
     * @param second
     *            Second RDN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createRDNEqualityData")
    public void testEquality(final Object first, final Object second, final int result)
            throws Exception {
        final RDN rdn1 = parseRDN(first);
        final RDN rdn2 = parseRDN(second);

        if (result == 0) {
            assertTrue(rdn1.equals(rdn2), "RDN equality for <" + first + "> and <" + second + ">");
        } else {
            assertFalse(rdn1.equals(rdn2), "RDN equality for <" + first + "> and <" + second + ">");
        }
    }

    /**
     * Tests the equals method with a non-RDN argument.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testEqualityNonRDN() {
        final RDN rdn = new RDN(ATTR_TYPE_DC, ORG);

        assertFalse(rdn.equals("this isn't an RDN"));
    }

    /**
     * Tests the equals method with a null argument.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testEqualityNull() {
        final RDN rdn = new RDN(ATTR_TYPE_DC, ORG);

        assertFalse(rdn.equals(null));
    }

    /**
     * Test getAttributeName.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testGetAttributeName() throws Exception {
        final RDN rdn = RDN.valueOf("dc=opendj+cn=org");
        assertTrue(rdn.isMultiValued());
        assertEquals(rdn.size(), 2);
        final Iterator<AVA> it = rdn.iterator();
        assertEquals(it.next().getAttributeType().getNameOrOID(), ATTR_TYPE_DC.getNameOrOID());
        assertEquals(it.next().getAttributeType().getNameOrOID(), ATTR_TYPE_CN.getNameOrOID());
    }

    /**
     * Test escaping of single space values.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testEscaping() {
        RDN rdn = new RDN(ATTR_TYPE_DC, ByteString.valueOfUtf8(" "));
        assertEquals(rdn.toString(), "dc=\\ ");
    }

    /**
     * Test RDN hashCode
     *
     * @param first
     *            First RDN to compare.
     * @param second
     *            Second RDN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createRDNEqualityData")
    public void testHashCode(final Object first, final Object second, final int result)
            throws Exception {
        final RDN rdn1 = parseRDN(first);
        final RDN rdn2 = parseRDN(second);

        final int h1 = rdn1.hashCode();
        final int h2 = rdn2.hashCode();

        if (result == 0) {
            assertThat(h1)
                    .as("Hash codes for <" + first + "> and <" + second + "> should be the same.")
                    .isEqualTo(h2);
        } else {
            assertThat(h1)
                    .as("Hash codes for <" + first + "> and <" + second + "> should NOT be the same.")
                    .isNotEqualTo(h2);
        }
    }

    @DataProvider
    public Object[][] toStringShouldStripOutIllegalWhitespaceDataProvider() {
        // @formatter:off
        return new Object[][] {
            { " dc = hello  world ", "dc=hello  world" },
            { " dc =\\  hello  world\\  ", "dc=\\  hello  world\\ " },
            { " uid = cpfc + dc = example ", "uid=cpfc+dc=example" },
        };
        // @formatter:on
    }

    @Test(dataProvider = "toStringShouldStripOutIllegalWhitespaceDataProvider")
    public void toStringShouldStripOutIllegalWhitespace(String withWhiteSpace, String withoutWhiteSpace) {
        assertThat(RDN.valueOf(withWhiteSpace).toString()).isEqualTo(withoutWhiteSpace);
        assertThat(RDN.valueOf(withWhiteSpace).toNormalizedByteString(new ByteStringBuilder()))
                .isEqualTo(RDN.valueOf(withoutWhiteSpace).toNormalizedByteString(new ByteStringBuilder()));
    }
}
