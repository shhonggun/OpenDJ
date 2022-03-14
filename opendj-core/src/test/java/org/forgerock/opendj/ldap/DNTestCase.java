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

import static java.lang.Integer.signum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.UUID;

import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class defines a set of tests for the org.forgerock.opendj.ldap.DN class.
 */
@SuppressWarnings("javadoc")
public class DNTestCase extends SdkTestCase {
    /**
     * Child DN test data provider.
     *
     * @return The array of test data.
     */
    @DataProvider(name = "createChildDNTestData")
    public Object[][] createChildDNTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "", "" },
            { "", "dc=org", "dc=org" },
            { "", "dc=opendj,dc=org", "dc=opendj,dc=org" },
            { "dc=org", "", "dc=org" },
            { "dc=org", "dc=opendj", "dc=opendj,dc=org" },
            { "dc=org", "dc=foo,dc=opendj", "dc=foo,dc=opendj,dc=org" },
            { "dc=opendj,dc=org", "", "dc=opendj,dc=org" },
            { "dc=opendj,dc=org", "dc=foo", "dc=foo,dc=opendj,dc=org" },
            { "dc=opendj,dc=org", "dc=bar,dc=foo", "dc=bar,dc=foo,dc=opendj,dc=org" },
        };
        // @formatter:on
    }

    /**
     * Child RDN test data provider.
     *
     * @return The array of test data.
     */
    @DataProvider(name = "createChildRDNTestData")
    public Object[][] createChildRDNTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "dc=org", "dc=org" },
            { "dc=org", "dc=opendj", "dc=opendj,dc=org" },
            { "dc=opendj,dc=org", "dc=foo", "dc=foo,dc=opendj,dc=org" },
        };
        // @formatter:on

    }

    /**
     * DN test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "testDNs")
    public Object[][] createData() {
        // @formatter:off
        return new Object[][] {
            { "", "", "" },
            { "   ", "", "" },
            { "cn=", "cn=", "cn=" },
            { "cn= ", "cn=", "cn=" },
            { "cn =", "cn=", "cn=" },
            { "cn = ", "cn=", "cn=" },
            { "dc=com", "dc=com", "dc=com" },
            { "dc=com+o=com", "dc=com+o=com", "dc=com+o=com" },
            { "DC=COM", "dc=com", "DC=COM" },
            { "dc = com", "dc=com", "dc=com" },
            { " dc = com ", "dc=com", "dc=com" },
            { "dc=example,dc=com", "dc=example,dc=com", "dc=example,dc=com" },
            { "dc=example, dc=com", "dc=example,dc=com", "dc=example,dc=com" },
            { "dc=example ,dc=com", "dc=example,dc=com", "dc=example,dc=com" },
            { "dc =example , dc  =   com", "dc=example,dc=com", "dc=example,dc=com" },
            { "givenName=John+cn=Doe,ou=People,dc=example,dc=com",
                "cn=doe+givenname=john,ou=people,dc=example,dc=com",
                "givenName=John+cn=Doe,ou=People,dc=example,dc=com" },
            { "givenName=John\\+cn=Doe,ou=People,dc=example,dc=com",
                "givenname=john\\+cn=doe,ou=people,dc=example,dc=com",
                "givenName=John\\+cn=Doe,ou=People,dc=example,dc=com" },
            { "cn=Doe\\, John,ou=People,dc=example,dc=com",
                "cn=doe\\, john,ou=people,dc=example,dc=com",
                "cn=Doe\\, John,ou=People,dc=example,dc=com" },
            { "UID=jsmith,DC=example,DC=net", "uid=jsmith,dc=example,dc=net",
                "UID=jsmith,DC=example,DC=net" },
            { "OU=Sales+CN=J. Smith,DC=example,DC=net", "cn=j. smith+ou=sales,dc=example,dc=net",
                "OU=Sales+CN=J. Smith,DC=example,DC=net" },
            { "CN=James \\\"Jim\\\" Smith\\, III,DC=example,DC=net",
                "cn=james \\\"jim\\\" smith\\, iii,dc=example,dc=net",
                "CN=James \\\"Jim\\\" Smith\\, III,DC=example,DC=net" },
            { "CN=John Smith\\2C III,DC=example,DC=net", "cn=john smith\\, iii,dc=example,dc=net",
                "CN=John Smith\\, III,DC=example,DC=net" },
            { "CN=\\23John Smith\\20,DC=example,DC=net", "cn=\\#john smith,dc=example,dc=net",
                "CN=\\#John Smith\\ ,DC=example,DC=net" },
            { "CN=Before\\0dAfter,DC=example,DC=net",
                // \0d is a hex representation of Carriage return. It is mapped
                // to a SPACE as defined in the MAP ( RFC 4518)
                "cn=before after,dc=example,dc=net", "CN=Before\\0dAfter,DC=example,DC=net" },
            { "2.5.4.3=#04024869",
                // Unicode codepoints from 0000-0008 are mapped to nothing.
                "cn=hi", "2.5.4.3=#04024869" },
            { "1.1.1=", "1.1.1=", "1.1.1=" },
            { "CN=Lu\\C4\\8Di\\C4\\87", "cn=lu\u010di\u0107", "CN=Lu\u010di\u0107" },
            { "ou=\\e5\\96\\b6\\e6\\a5\\ad\\e9\\83\\a8,o=Airius", "ou=\u55b6\u696d\u90e8,o=airius",
                "ou=\u55b6\u696d\u90e8,o=Airius" },
            { "photo=\\ john \\ ,dc=com", "photo=\\ john \\ ,dc=com", "photo=\\ john \\ ,dc=com" },
            { "AB-global=", "ab-global=", "AB-global=" },
            { "OU= Sales + CN = J. Smith ,DC=example,DC=net",
                "cn=j. smith+ou=sales,dc=example,dc=net", "OU=Sales+CN=J. Smith,DC=example,DC=net" },
            { "cn=John+dc=", "dc=+cn=john", "cn=John+dc=" },
            { "O=\"Sue, Grabbit + Runn\",C=US", "o=sue\\, grabbit \\+ runn,c=us",
                "O=Sue\\, Grabbit \\+ Runn,C=US" },
            { "O=\"John \\\"Tiger\\\" Smith\",C=US", "o=john \\\"tiger\\\" smith,c=us",
                "O=John \\\"Tiger\\\" Smith,C=US" },
        };
        // @formatter:on
    }

    /**
     * DN comparison test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "createDNComparisonData")
    public Object[][] createDNComparisonData() {
        // @formatter:off
        return new Object[][] {
            { "cn=hello world,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=hello world,dc=com", "CN=hello world,dc=com", 0 },
            { "cn=hello   world,dc=com", "cn=hello world,dc=com", 0 },
            { "  cn =  hello world  ,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=hello world\\ ,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=HELLO WORLD,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=HELLO+sn=WORLD,dc=com", "sn=world+cn=hello,dc=com", 0 },
            { "governingStructureRule=10,dc=com", "governingStructureRule=9,dc=com", 1 },
            { "governingStructureRule=999,dc=com", "governingStructureRule=1000,dc=com", -1 },
            { "governingStructureRule=-1,dc=com", "governingStructureRule=0,dc=com", -1 },
            { "governingStructureRule=0,dc=com", "governingStructureRule=-1,dc=com", 1 },
            { "cn=aaa,dc=com", "cn=aaaa,dc=com", -1 }, { "cn=AAA,dc=com", "cn=aaaa,dc=com", -1 },
            { "cn=aaa,dc=com", "cn=AAAA,dc=com", -1 }, { "cn=aaaa,dc=com", "cn=aaa,dc=com", 1 },
            { "cn=AAAA,dc=com", "cn=aaa,dc=com", 1 }, { "cn=aaaa,dc=com", "cn=AAA,dc=com", 1 },
            { "cn=aaab,dc=com", "cn=aaaa,dc=com", 1 }, { "cn=aaaa,dc=com", "cn=aaab,dc=com", -1 },
            { "dc=aaa,dc=aaa", "dc=bbb", -1 }, { "dc=bbb,dc=aaa", "dc=bbb", -1 },
            { "dc=ccc,dc=aaa", "dc=bbb", -1 }, { "dc=aaa,dc=bbb", "dc=bbb", 1 },
            { "dc=bbb,dc=bbb", "dc=bbb", 1 }, { "dc=ccc,dc=bbb", "dc=bbb", 1 },
            { "dc=aaa,dc=ccc", "dc=bbb", 1 }, { "dc=bbb,dc=ccc", "dc=bbb", 1 },
            { "dc=ccc,dc=ccc", "dc=bbb", 1 }, { "", "dc=bbb", -1 }, { "dc=bbb", "", 1 }
        };
        // @formatter:on
    }

    /**
     * DN equality test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "createDNEqualityData")
    public Object[][] createDNEqualityData() {
        // @formatter:off
        return new Object[][] {
            { "cn=hello world,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=hello world,dc=com", "CN=hello world,dc=com", 0 },
            { "cn=hello   world,dc=com", "cn=hello world,dc=com", 0 },
            { "  cn =  hello world  ,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=hello world\\ ,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=HELLO WORLD,dc=com", "cn=hello world,dc=com", 0 },
            { "cn=HELLO+sn=WORLD,dc=com", "sn=world+cn=hello,dc=com", 0 },
            { "governingStructureRule=10,dc=com", "governingStructureRule=9,dc=com", 1 },
            { "governingStructureRule=999,dc=com", "governingStructureRule=1000,dc=com", -1 },
            { "governingStructureRule=-1,dc=com", "governingStructureRule=0,dc=com", -1 },
            { "governingStructureRule=0,dc=com", "governingStructureRule=-1,dc=com", 1 },
            { "cn=aaa,dc=com", "cn=aaaa,dc=com", -1 },
            { "cn=AAA,dc=com", "cn=aaaa,dc=com", -1 },
            { "cn=aaa,dc=com", "cn=AAAA,dc=com", -1 },
            { "cn=aaaa,dc=com", "cn=aaa,dc=com", 1 },
            { "cn=AAAA,dc=com", "cn=aaa,dc=com", 1 },
            { "cn=aaaa,dc=com", "cn=AAA,dc=com", 1 },
            { "cn=aaab,dc=com", "cn=aaaa,dc=com", 1 },
            { "cn=aaaa,dc=com", "cn=aaab,dc=com", -1 },
            { "dc=aaa,dc=aaa", "dc=bbb", -1 },
            { "dc=bbb,dc=aaa", "dc=bbb", -1 },
            { "dc=ccc,dc=aaa", "dc=bbb", -1 },
            { "dc=aaa,dc=bbb", "dc=bbb", 1 },
            { "dc=bbb,dc=bbb", "dc=bbb", 1 },
            { "dc=ccc,dc=bbb", "dc=bbb", 1 },
            { "dc=aaa,dc=ccc", "dc=bbb", 1 },
            { "dc=bbb,dc=ccc", "dc=bbb", 1 },
            { "dc=ccc,dc=ccc", "dc=bbb", 1 },
            { "", "dc=bbb", -1 },
            { "dc=bbb", "", 1 }
        };
        // @formatter:on
    }

    /**
     * Illegal DN test data provider.
     *
     * @return The array of illegal test DN strings.
     */
    @DataProvider(name = "illegalDNs")
    public Object[][] createIllegalData() {
        // @formatter:off
        return new Object[][] {
            { "manager" },
            { "manager " },
            { "=Jim" },
            { " =Jim" },
            { "= Jim" },
            { " = Jim" },
            { "cn+Jim" },
            { "cn + Jim" },
            { "cn=Jim+" },
            { "cn=Jim+manager" },
            { "cn=Jim+manager " },
            { "cn=Jim+manager," },
            { "cn=Jim," },
            { "cn=Jim,  " },
            { "c[n]=Jim" },
            { "_cn=Jim" },
            { "c_n=Jim" },
            { "cn\"=Jim" },
            { "c\"n=Jim" },
            { "1cn=Jim" },
            { "cn+uid=Jim" },
            { "-cn=Jim" },
            { "/tmp=a" },
            { "\\tmp=a" },
            { "cn;lang-en=Jim" },
            { "@cn=Jim" },
            { "_name_=Jim" },
            { "\u03c0=pi" },
            { "v1.0=buggy" },
            { "1.=buggy" },
            { ".1=buggy" },
            { "oid.1." },
            { "1.3.6.1.4.1.1466..0=#04024869" },
            { "cn=#a" },
            { "cn=#ag" },
            { "cn=#ga" },
            { "cn=#abcdefgh" },
            { "cn=a\\b" },
            { "cn=a\\bg" },
            { "cn=\"hello" },
            { "cn=+mail=,dc=example,dc=com" },
            { "cn=xyz+sn=,dc=example,dc=com" },
            { "cn=,dc=example,dc=com" },
            { "cn=a+cn=b,dc=example,dc=com" }
        };
        // @formatter:on
    }

    /**
     * Is Child of test data provider.
     *
     * @return The array of test data.
     */
    @DataProvider(name = "createIsChildOfTestData")
    public Object[][] createIsChildOfTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "", false },
            { "", "dc=org", false },
            { "", "dc=opendj,dc=org", false },
            { "", "dc=foo,dc=opendj,dc=org", false },
            { "dc=org", "", true },
            { "dc=org", "dc=org", false },
            { "dc=org", "dc=opendj,dc=org", false },
            { "dc=org", "dc=foo,dc=opendj,dc=org", false },
            { "dc=opendj,dc=org", "", false },
            { "dc=opendj,dc=org", "dc=org", true },
            { "dc=opendj,dc=org", "dc=opendj,dc=org", false },
            { "dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", false },
            { "dc=foo,dc=opendj,dc=org", "", false },
            { "dc=foo,dc=opendj,dc=org", "dc=org", false },
            { "dc=foo,dc=opendj,dc=org", "dc=opendj,dc=org", true },
            { "dc=foo,dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", false },
            { "dc=org", "dc=com", false },
            { "dc=opendj,dc=org", "dc=foo,dc=org", false },
            { "dc=opendj,dc=org", "dc=opendj,dc=com", false },
        };
        // @formatter:on
    }

    /**
     * DN test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "createNumComponentsTestData")
    public Object[][] createNumComponentsTestData() {
        // @formatter:off
        return new Object[][] {
            { "", 0 },
            { "dc=com", 1 },
            { "dc=opendj,dc=com", 2 },
            { "dc=world,dc=opendj,dc=com", 3 },
            { "dc=hello,dc=world,dc=opendj,dc=com", 4 },
        };
        // @formatter:on
    }

    /**
     * DN test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "createParentAndRDNTestData")
    public Object[][] createParentAndRDNTestData() {
        // @formatter:off
        return new Object[][] {
            { "", null, null },
            { "dc=com", "", "dc=com" },
            { "dc=opendj,dc=com", "dc=com", "dc=opendj" },
            { "dc=world,dc=opendj,dc=com", "dc=opendj,dc=com", "dc=world" },
            { "dc=hello,dc=world,dc=opendj,dc=com", "dc=world,dc=opendj,dc=com", "dc=hello" },
        };
        // @formatter:on
    }

    /**
     * DN test data provider.
     *
     * @return The array of test DN strings.
     */
    @DataProvider(name = "createRDNTestData")
    public Object[][] createRDNTestData() {
        // @formatter:off
        return new Object[][] {
            { "dc=com", 0, "dc=com" },
            { "dc=opendj,dc=com", 0, "dc=opendj" },
            { "dc=opendj,dc=com", 1, "dc=com" },
            { "dc=hello,dc=world,dc=opendj,dc=com", 0, "dc=hello" },
            { "dc=hello,dc=world,dc=opendj,dc=com", 1, "dc=world" },
            { "dc=hello,dc=world,dc=opendj,dc=com", 2, "dc=opendj" },
            { "dc=hello,dc=world,dc=opendj,dc=com", 3, "dc=com" },
        };
        // @formatter:on
    }

    /**
     * Subordinate test data provider.
     *
     * @return The array of subordinate and superior DN Strings.
     */
    @DataProvider(name = "createSubordinateTestData")
    public Object[][] createSubordinateTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "", true },
            { "", "dc=org", false },
            { "", "dc=opendj,dc=org", false },
            { "", "dc=foo,dc=opendj,dc=org", false },
            { "dc=org", "", true },
            { "dc=org", "dc=org", true },
            { "dc=org", "dc=opendj,dc=org", false },
            { "dc=org", "dc=foo,dc=opendj,dc=org", false },
            { "dc=opendj,dc=org", "", true },
            { "dc=opendj,dc=org", "dc=org", true },
            { "dc=opendj,dc=org", "dc=opendj,dc=org", true },
            { "dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", false },
            { "dc=foo,dc=opendj,dc=org", "", true },
            { "dc=foo,dc=opendj,dc=org", "dc=org", true },
            { "dc=foo,dc=opendj,dc=org", "dc=opendj,dc=org", true },
            { "dc=foo,dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", true },
            { "dc=org", "dc=com", false },
            { "dc=opendj,dc=org", "dc=foo,dc=org", false },
            { "dc=opendj,dc=org", "dc=opendj,dc=com", false },
        };
        // @formatter:on
    }

    /**
     * Superior test data provider.
     *
     * @return The array of superior and subordinate DN Strings.
     */
    @DataProvider(name = "createSuperiorTestData")
    public Object[][] createSuperiorTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "", true },
            { "", "dc=org", true },
            { "", "dc=opendj,dc=org", true },
            { "", "dc=foo,dc=opendj,dc=org", true },
            { "dc=org", "", false },
            { "dc=org", "dc=org", true },
            { "dc=org", "dc=opendj,dc=org", true },
            { "dc=org", "dc=foo,dc=opendj,dc=org", true },
            { "dc=opendj,dc=org", "", false },
            { "dc=opendj,dc=org", "dc=org", false },
            { "dc=opendj,dc=org", "dc=opendj,dc=org", true },
            { "dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", true },
            { "dc=foo,dc=opendj,dc=org", "", false },
            { "dc=foo,dc=opendj,dc=org", "dc=org", false },
            { "dc=foo,dc=opendj,dc=org", "dc=opendj,dc=org", false },
            { "dc=foo,dc=opendj,dc=org", "dc=foo,dc=opendj,dc=org", true },
            { "dc=org", "dc=com", false },
            { "dc=opendj,dc=org", "dc=foo,dc=org", false },
            { "dc=opendj,dc=org", "dc=opendj,dc=com", false },
        };
        // @formatter:on
    }

    @Test
    public void testAdminData() {
        DN.valueOf("cn=cn\\=admin data");
        final DN theDN = DN.valueOf("cn=my dn");
        final RDN theRDN = new RDN("cn", "my rdn");
        final DN theChildDN = theDN.child(theRDN);
        DN.valueOf(theChildDN.toString());
    }

    /**
     * Test the child(DN) method.
     *
     * @param s
     *            The test DN string.
     * @param l
     *            The local name to be appended.
     * @param e
     *            The expected DN.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createChildDNTestData")
    public void testChildDN(final String s, final String l, final String e) throws Exception {
        final DN dn = DN.valueOf(s);
        final DN localName = DN.valueOf(l);
        final DN expected = DN.valueOf(e);

        assertEquals(dn.child(localName), expected);
    }

    /**
     * Test the child(DN) method.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(expectedExceptions = { NullPointerException.class, AssertionError.class })
    public void testChildDNException() throws Exception {
        final DN dn = DN.valueOf("dc=org");
        dn.child((DN) null);
    }

    /**
     * Test the child(DN) method's interaction with other methods.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testChildDNInteraction() throws Exception {
        final DN p = DN.valueOf("dc=opendj,dc=org");
        final DN l = DN.valueOf("dc=foo");
        final DN e = DN.valueOf("dc=foo,dc=opendj,dc=org");
        final DN c = p.child(l);

        assertEquals(c.size(), 3);

        assertEquals(signum(c.compareTo(p)), 1);
        assertEquals(signum(p.compareTo(c)), -1);

        assertTrue(p.isParentOf(c));
        assertFalse(c.isParentOf(p));

        assertTrue(c.isChildOf(p));
        assertFalse(p.isChildOf(c));

        assertEquals(c, e);
        assertEquals(c.hashCode(), e.hashCode());

        assertEquals(c.toString(), e.toString());

        assertEquals(c.rdn(), RDN.valueOf("dc=foo"));
        assertEquals(c.rdn(), c.rdn(0));

        assertEquals(c.parent(), DN.valueOf("dc=opendj,dc=org"));
        assertEquals(c.parent(), e.parent());

        assertEquals(c.child(RDN.valueOf("dc=xxx")), DN.valueOf("dc=xxx,dc=foo,dc=opendj,dc=org"));
        assertEquals(c.child(DN.valueOf("dc=xxx,dc=yyy")), DN
                .valueOf("dc=xxx,dc=yyy,dc=foo,dc=opendj,dc=org"));
    }

    /**
     * Test the child(RDN...) method.
     *
     * @param s
     *            The test DN string.
     * @param r
     *            The RDN to be appended.
     * @param e
     *            The expected DN.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createChildRDNTestData")
    public void testChildSingleRDN(final String s, final String r, final String e) throws Exception {
        final DN dn = DN.valueOf(s);
        final RDN rdn = RDN.valueOf(r);
        final DN expected = DN.valueOf(e);

        assertEquals(dn.child(rdn), expected);
    }

    /**
     * Test the child(String attributeType, Object attributeValue) method.
     *
     * @param s
     *            The test DN string.
     * @param r
     *            The RDN to be appended.
     * @param e
     *            The expected DN.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createChildRDNTestData")
    public void testChildTypeValue(final String s, final String r, final String e) throws Exception {
        final DN dn = DN.valueOf(s);
        final RDN rdn = RDN.valueOf(r);
        final DN expected = DN.valueOf(e);

        assertEquals(dn.child(rdn.getFirstAVA().getAttributeType().getNameOrOID(), rdn
                .getFirstAVA().getAttributeValue()), expected);
    }

    /**
     * Test DN compareTo
     *
     * @param first
     *            First DN to compare.
     * @param second
     *            Second DN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createDNComparisonData")
    public void testCompareTo(final String first, final String second, final int result)
            throws Exception {
        final DN dn1 = DN.valueOf(first);
        final DN dn2 = DN.valueOf(second);

        int rc = dn1.compareTo(dn2);

        // Normalize the result.
        if (rc < 0) {
            rc = -1;
        } else if (rc > 0) {
            rc = 1;
        }

        assertEquals(rc, result, "Comparison for <" + first + "> and <" + second + ">.");
    }

    /**
     * Test DN equality
     *
     * @param first
     *            First DN to compare.
     * @param second
     *            Second DN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createDNEqualityData")
    public void testEquality(final String first, final String second, final int result)
            throws Exception {
        final DN dn1 = DN.valueOf(first);
        final DN dn2 = DN.valueOf(second);

        if (result == 0) {
            assertTrue(dn1.equals(dn2), "DN equality for <" + first + "> and <" + second + ">");
        } else {
            assertFalse(dn1.equals(dn2), "DN equality for <" + first + "> and <" + second + ">");
        }
    }

    /**
     * Tests the equals method with a value that's not a DN.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testEqualsNonDN() throws Exception {
        final DN dn = DN.valueOf("dc=example,dc=com");

        assertFalse(dn.equals(DN.valueOf("not a DN")));
    }

    /**
     * Test DN hashCode
     *
     * @param first
     *            First DN to compare.
     * @param second
     *            Second DN to compare.
     * @param result
     *            Expected comparison result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createDNEqualityData")
    public void testHashCode(final String first, final String second, final int result)
            throws Exception {
        final DN dn1 = DN.valueOf(first);
        final DN dn2 = DN.valueOf(second);

        final int h1 = dn1.hashCode();
        final int h2 = dn2.hashCode();

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

    /**
     * Test that decoding an illegal DN as a String throws an exception.
     *
     * @param dn
     *            The illegal DN to be tested.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "illegalDNs", expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testIllegalStringDNs(final String dn) throws Exception {
        DN.valueOf(dn);
    }

    @Test(dataProvider = "illegalDNs", expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testIllegalByteStringDNs(final String dn) throws Exception {
        DN.valueOf(ByteString.valueOfUtf8(dn));
    }

    /**
     * Test the isChildOf method.
     *
     * @param s
     *            The test DN string.
     * @param d
     *            The dn parameter.
     * @param e
     *            The expected result.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createIsChildOfTestData")
    public void testIsChildOf(final String s, final String d, final boolean e) throws Exception {
        final DN dn = DN.valueOf(s);
        final DN other = DN.valueOf(d);

        assertEquals(dn.isChildOf(other), e, s + " isChildOf " + d);
    }

    /**
     * Test the isChildOf method.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(expectedExceptions = { NullPointerException.class, AssertionError.class })
    public void testIsChildOfException() throws Exception {
        final DN dn = DN.valueOf("dc=com");
        dn.isChildOf((String) null);
    }

    /** Tests the parent and rdn method that require iteration. */
    @Test
    public void testIterableParentAndRdn() {
        final String str = "ou=people,dc=example,dc=com";
        final DN dn = DN.valueOf(str);
        // Parent at index 0 is self.
        assertEquals(dn.parent(0), dn);
        assertEquals(dn.parent(1), DN.valueOf("dc=example,dc=com"));
        assertEquals(dn.parent(2), DN.valueOf("dc=com"));
        assertEquals(dn.parent(3), DN.rootDN());
        assertEquals(dn.parent(4), null);

        assertEquals(dn.rdn(0), RDN.valueOf("ou=people"));
        assertEquals(dn.rdn(1), RDN.valueOf("dc=example"));
        assertEquals(dn.rdn(2), RDN.valueOf("dc=com"));
        assertEquals(dn.rdn(3), null);
    }

    /**
     * Test the getNumComponents method.
     *
     * @param s
     *            The test DN string.
     * @param sz
     *            The expected number of RDNs.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createNumComponentsTestData")
    public void testNumComponents(final String s, final int sz) throws Exception {
        final DN dn = DN.valueOf(s);
        assertEquals(dn.size(), sz);
    }

    /**
     * Test the parent method.
     *
     * @param s
     *            The test DN string.
     * @param p
     *            The expected parent.
     * @param r
     *            The expected rdn.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createParentAndRDNTestData")
    public void testParent(final String s, final String p, final String r) throws Exception {
        final DN dn = DN.valueOf(s);
        final DN parent = (p != null ? DN.valueOf(p) : null);

        assertEquals(dn.parent(), parent, "For DN " + s);
    }

    /**
     * Test the parent method's interaction with other methods.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testParentInteraction() throws Exception {
        final DN c = DN.valueOf("dc=foo,dc=bar,dc=opendj,dc=org");
        final DN e = DN.valueOf("dc=bar,dc=opendj,dc=org");
        final DN p = c.parent();

        assertEquals(p.size(), 3);

        assertEquals(signum(p.compareTo(c)), -1);
        assertEquals(signum(c.compareTo(p)), 1);

        assertTrue(p.isParentOf(c));
        assertFalse(c.isParentOf(p));

        assertTrue(c.isChildOf(p));
        assertFalse(p.isChildOf(c));

        assertEquals(p, e);
        assertEquals(p.hashCode(), e.hashCode());

        assertEquals(p.toString(), e.toString());

        assertEquals(p.rdn(), RDN.valueOf("dc=bar"));

        assertEquals(p.parent(), DN.valueOf("dc=opendj,dc=org"));
        assertEquals(p.parent(), e.parent());

        assertEquals(p.child(RDN.valueOf("dc=foo")), DN.valueOf("dc=foo,dc=bar,dc=opendj,dc=org"));
        assertEquals(p.child(RDN.valueOf("dc=foo")), c);
        assertEquals(p.child(DN.valueOf("dc=xxx,dc=foo")), DN
                .valueOf("dc=xxx,dc=foo,dc=bar,dc=opendj,dc=org"));
    }

    /**
     * Test the getRDN method.
     *
     * @param s
     *            The test DN string.
     * @param p
     *            The expected parent.
     * @param r
     *            The expected rdn.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "createParentAndRDNTestData")
    public void testRDN(final String s, final String p, final String r) throws Exception {
        final DN dn = DN.valueOf(s);
        final RDN rdn = (r != null ? RDN.valueOf(r) : null);

        assertEquals(dn.rdn(), rdn, "For DN " + s);
    }

    /**
     * Tests the root DN.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testRootDN1() throws Exception {
        final DN dn = DN.valueOf("");
        assertTrue(dn.isRootDN());
        assertEquals(dn, DN.rootDN());
    }

    /**
     * Tests {@link DN#valueOf(String)}.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(expectedExceptions = NullPointerException.class)
    public void valueOfStringShouldThrowNPEForNullParameter() {
        DN.valueOf((String) null);
    }

    /**
     * Tests {@link DN#valueOf(ByteString)}.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(expectedExceptions = NullPointerException.class)
    public void valueOfByteStringShouldThrowNPEForNullParameter() throws Exception {
        DN.valueOf((ByteString) null);
    }

    /**
     * Test the root dn.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testRootDN3() throws Exception {
        final DN nullDN = DN.rootDN();
        assertTrue(nullDN.isRootDN());
        assertTrue(nullDN.size() == 0);
    }

    /**
     * Test the root dn.
     *
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test
    public void testRootDN4() throws Exception {
        final DN dn = DN.valueOf("dc=com");
        assertFalse(dn.isRootDN());
    }

    /**
     * Tests the subordinate dns.
     */
    @Test(dataProvider = "createSubordinateTestData")
    public void testSubordinateDN(final String sub, final String base, final boolean e)
            throws Exception {
        final DN dn = DN.valueOf(sub);
        final DN other = DN.valueOf(base);
        assertEquals(dn.isSubordinateOrEqualTo(other), e, sub + " isSubordinateOf " + base);
    }

    /** Tests the superior dns. */
    @Test(dataProvider = "createSuperiorTestData")
    public void testSuperiorDN(final String base, final String sub, final boolean e)
            throws Exception {
        final DN dn = DN.valueOf(base);
        final DN other = DN.valueOf(sub);
        assertEquals(dn.isSuperiorOrEqualTo(other), e, base + " isSuperiorOf " + sub);
    }

    /**
     * Test the RFC 4514 string representation of the DN.
     *
     * @param rawDN
     *            Raw DN string representation.
     * @param normDN
     *            Normalized DN string representation.
     * @param stringDN
     *            String representation.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "testDNs")
    public void testToString(final String rawDN, final String normDN, final String stringDN)
            throws Exception {
        DN dn = DN.valueOf(rawDN);
        assertThat(dn.toString()).isEqualTo(stringDN);
    }

    /**
     * Tests the <CODE>valueOf</CODE> method which takes a String argument.
     *
     * @param rawDN
     *            Raw DN string representation.
     * @param normDN
     *            Normalized DN string representation.
     * @param stringDN
     *            String representation.
     * @throws Exception
     *             If the test failed unexpectedly.
     */
    @Test(dataProvider = "testDNs")
    public void testValueOfString(final String rawDN, final String normDN, final String stringDN)
            throws Exception {
        final DN raw = DN.valueOf(rawDN);
        final DN string = DN.valueOf(stringDN);
        assertEquals(raw, string);
    }

    /**
     * Test data for testInScopeOf tests.
     *
     * @return Test data.
     */
    @DataProvider
    public Object[][] createIsInScopeOfTestData() {
        // @formatter:off
        return new Object[][] {
            { "dc=x,dc=y", "dc=x,dc=y", SearchScope.BASE_OBJECT, true  },
            { "dc=x,dc=y", "dc=z,dc=y", SearchScope.BASE_OBJECT, false },
            { "dc=x,dc=z", "dc=x,dc=y", SearchScope.BASE_OBJECT, false },
            { "dc=x,dc=y", "dc=y",      SearchScope.BASE_OBJECT, false },
            { "dc=y",      "dc=x,dc=y", SearchScope.BASE_OBJECT, false },

            { "dc=x,dc=y",      "dc=x,dc=y", SearchScope.SINGLE_LEVEL, false },
            { "dc=x,dc=y",      "dc=y",      SearchScope.SINGLE_LEVEL, true  },
            { "dc=z,dc=x,dc=y", "dc=y",      SearchScope.SINGLE_LEVEL, false },
            { "dc=y",           "dc=x,dc=y", SearchScope.SINGLE_LEVEL, false },
            { "dc=x,dc=z",      "dc=y",      SearchScope.SINGLE_LEVEL, false },

            { "dc=x,dc=y",      "dc=x,dc=y", SearchScope.SUBORDINATES, false },
            { "dc=x,dc=y",      "dc=y",      SearchScope.SUBORDINATES, true  },
            { "dc=z,dc=x,dc=y", "dc=y",      SearchScope.SUBORDINATES, true  },
            { "dc=y",           "dc=x,dc=y", SearchScope.SUBORDINATES, false },
            { "dc=x,dc=z",      "dc=y",      SearchScope.SUBORDINATES, false },

            { "dc=x,dc=y",      "dc=x,dc=y", SearchScope.WHOLE_SUBTREE, true },
            { "dc=x,dc=y",      "dc=y",      SearchScope.WHOLE_SUBTREE, true  },
            { "dc=z,dc=x,dc=y", "dc=y",      SearchScope.WHOLE_SUBTREE, true  },
            { "dc=y",           "dc=x,dc=y", SearchScope.WHOLE_SUBTREE, false },
            { "dc=x,dc=z",      "dc=y",      SearchScope.WHOLE_SUBTREE, false },
        };
        // @formatter:on
    }

    /**
     * Tests {@link DN#isInScopeOf(String, SearchScope)}.
     *
     * @param dn
     *            The target DN.
     * @param baseDN
     *            The scope base DN.
     * @param scope
     *            The search scope.
     * @param expectedResult
     *            The expected result.
     */
    @Test(dataProvider = "createIsInScopeOfTestData")
    public void testIsInScopeOfString(final String dn, final String baseDN,
            final SearchScope scope, final boolean expectedResult) {
        assertEquals(DN.valueOf(dn).isInScopeOf(baseDN, scope), expectedResult);
    }

    /**
     * Tests {@link DN#isInScopeOf(DN, SearchScope)}.
     *
     * @param dn
     *            The target DN.
     * @param baseDN
     *            The scope base DN.
     * @param scope
     *            The search scope.
     * @param expectedResult
     *            The expected result.
     */
    @Test(dataProvider = "createIsInScopeOfTestData")
    public void testIsInScopeOfDN(final String dn, final String baseDN, final SearchScope scope,
            final boolean expectedResult) {
        assertEquals(DN.valueOf(dn).isInScopeOf(DN.valueOf(baseDN), scope), expectedResult);
    }

    /**
     * Test data for testLocalName tests.
     *
     * @return Test data.
     */
    @DataProvider
    public Object[][] createLocalNameTestData() {
        // @formatter:off
        return new Object[][] {
            { "", 0, "" },
            { "", 1, "" },

            { "dc=x", 0, "" },
            { "dc=x", 1, "dc=x" },
            { "dc=x", 2, "dc=x" },

            { "dc=x,dc=y", 0, "" },
            { "dc=x,dc=y", 1, "dc=x" },
            { "dc=x,dc=y", 2, "dc=x,dc=y" },
            { "dc=x,dc=y", 3, "dc=x,dc=y" },

            { "dc=x,dc=y,dc=z", 0, "" },
            { "dc=x,dc=y,dc=z", 1, "dc=x" },
            { "dc=x,dc=y,dc=z", 2, "dc=x,dc=y" },
            { "dc=x,dc=y,dc=z", 3, "dc=x,dc=y,dc=z" },
            { "dc=x,dc=y,dc=z", 4, "dc=x,dc=y,dc=z" },
        };
        // @formatter:on
    }

    /**
     * Tests {@link DN#localName(int)}.
     *
     * @param dn
     *            The DN whose local name is to be obtained.
     * @param index
     *            The number of RDNs in the local name.
     * @param expectedDN
     *            The expected local name.
     */
    @Test(dataProvider = "createLocalNameTestData")
    public void testLocalName(final String dn, final int index, final String expectedDN) {
        assertEquals(DN.valueOf(dn).localName(index), DN.valueOf(expectedDN));
    }

    /**
     * Test data for testLocalName tests.
     *
     * @return Test data.
     */
    @DataProvider
    public Object[][] createRenameTestData() {
        // @formatter:off
        return new Object[][] {
            { "", "", "", "" },
            { "", "", "dc=x", "dc=x" },
            { "dc=x", "", "dc=y", "dc=x,dc=y" },
            { "dc=x", "dc=x", "dc=y", "dc=y" },
            { "dc=x,dc=y", "dc=y", "dc=z", "dc=x,dc=z" },
            { "dc=x,dc=y", "dc=x,dc=y", "dc=z", "dc=z" },
            { "dc=x,dc=y", "dc=x", "dc=z", "dc=x,dc=y" },
        };
        // @formatter:on
    }

    /**
     * Tests {@link DN#rename(DN, DN)}.
     *
     * @param dn
     *            The DN to be renamed.
     * @param fromDN
     *            The source DN.
     * @param toDN
     *            The destination DN.
     * @param expectedDN
     *            The expected result.
     */
    @Test(dataProvider = "createRenameTestData")
    public void testRename(final String dn, final String fromDN, final String toDN,
            final String expectedDN) {
        DN actual = DN.valueOf(dn).rename(DN.valueOf(fromDN), DN.valueOf(toDN));
        assertEquals(actual, DN.valueOf(expectedDN));
    }

    /**
     * Tests the {@link DN#format(String, Object...)} method.
     */
    @Test
    public void testFormatNoEscape() {
        DN actual = DN.format("deviceId=%s,uid=%s,dc=test", 123, "bjensen");
        DN expected = DN.valueOf("dc=test").child("uid", "bjensen").child("deviceId", 123);
        assertEquals(actual, expected);
        assertEquals(actual.toString(), "deviceId=123,uid=bjensen,dc=test");
    }

    /** Tests the {@link DN#format(String, Object...)} method. */
    @Test
    public void testFormatEscape() {
        DN actual = DN.format("uid=%s,dc=test", "#cn=foo+sn=bar");
        DN expected = DN.valueOf("dc=test").child("uid", "#cn=foo+sn=bar");
        assertEquals(actual, expected);
        assertEquals(actual.toString(), "uid=\\#cn=foo\\+sn=bar,dc=test");
    }

    /** Tests the {@link DN#escapeAttributeValue(Object)} method. */
    @Test
    public void testEscapeAttributeValue() {
        String actual = DN.escapeAttributeValue("#cn=foo+sn=bar");
        assertEquals(actual, "\\#cn=foo\\+sn=bar");
    }

    /** Tests the {@link DN#toNormalizedByteString()} method. */
    @Test
    public void testToNormalizedByteStringWithRootDN() {
        ByteString actual = DN.rootDN().toNormalizedByteString();
        assertEquals(actual, ByteString.empty());
    }

    /** Tests the {@link DN#iterator()} method. */
    @Test
    public void testIterator() {
        final String childRdn = "dc=example";
        final String parentRdn = "dc=com";
        final Iterator<RDN> it = DN.valueOf(childRdn + "," + parentRdn).iterator();
        assertTrue(it.hasNext());
        assertEquals(it.next(), RDN.valueOf(childRdn));
        assertTrue(it.hasNext());
        assertEquals(it.next(), RDN.valueOf(parentRdn));
        assertFalse(it.hasNext());
        try {
            it.next();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException expected) {
            // do nothing
        }
        try {
            it.remove();
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException expected) {
            // do nothing
        }
    }

    @DataProvider
    public Object[][] toNormalizedByteStringDataProvider() {
        // @formatter:off
        return new Object[][] {
            // first value to normalize, second value to normalize, expected sign of comparison between the two
            { "dc=com", "dc=com", 0 },
            { "dc=example,dc=com", "dc=example,dc=com", 0 },
            { "cn=test+dc=example,dc=com", "cn=test+dc=example,dc=com", 0 },
            { "dc=example+cn=test,dc=com", "cn=test+dc=example,dc=com", 0 },
            // siblings
            { "cn=test,dc=com", "cn=test+dc=example,dc=com", -1 },
            { "cn=test+dc=example,dc=com", "cn=test,dc=com", 1 },
            { "dc=example,dc=com", "cn=test+dc=example,dc=com", 1 },
            { "cn=test+dc=example,dc=com", "dc=example,dc=com", -1 },
            { "dc=example,dc=com", "dc=example+cn=test,dc=com", 1 },
            { "dc=example+cn=test,dc=com", "dc=example,dc=com", -1 },
            // parent entry is followed by its children, not its siblings
            { "dc=com", "dc=example,dc=com", -1 },
            { "dc=com", "dc=test,dc=example,dc=com", -1},
            { "dc=example,dc=com", "dc=test,dc=example,dc=com", -1},
            { "dc=example,dc=com", "dc=example2,dc=com", -1},
            { "dc=example2,dc=com", "dc=test,dc=example,dc=com", 1},
            // with space
            { "dc=example,dc=com", "dc = example, dc = com", 0 },
            { "dc=example\\20test,dc=com", "dc=example test,dc=com", 0 },
            { "dc=example test,dc=com", "dc=exampletest,dc=com", -1 },
            // with various escaped characters
            { "dc=example\\2Dtest,dc=com", "dc=example-test,dc=com", 0 },
            { "dc=example\\28test,dc=com", "dc=example(test,dc=com", 0 },
            { "dc=example\\3Ftest,dc=com", "dc=example?test,dc=com", 0 },
            // with escaped comma
            { "dc=example\\,dc=com,dc=com", "dc=example\\2Cdc=com,dc=com", 0 },
            { "dc=example\\2Cdc=com,dc=com", "dc=example\\2Cdc\\3Dcom,dc=com", 0 },
            { "dc=example,dc=com", "dc=example\\,dc=com,dc=com", -1 },
            { "dc=example2,dc=com", "dc=example\\,dc=com,dc=com", 1 },
            // with escaped "="
            { "dc=example\\=other,dc=com", "dc=example\\3Dother,dc=com", 0 },
            // with escaped "+"
            { "dc=example\\+other,dc=com", "dc=example\\2Bother,dc=com", 0 },
            // integer
            { "governingStructureRule=10,dc=com", "governingStructureRule=10, dc=com", 0 },
            { "governingStructureRule=99,dc=com", "governingStructureRule=100, dc=com", -1 },
            { "governingStructureRule=999999,dc=com", "governingStructureRule=1000000, dc=com", -1 },
            // no matching rule for the attribute
            { "dummy=9,dc=com", "dummy=10,dc=com", 1 }
        };
        // @formatter:on
    }

    @Test(dataProvider = "toNormalizedByteStringDataProvider")
    public void testToNormalizedByteString(String first, String second, int expectedCompareResult) {
        DN actual = DN.valueOf(first);
        DN expected = DN.valueOf(second);
        int cmp = actual.toNormalizedByteString().compareTo(expected.toNormalizedByteString());
        assertThat(signum(cmp)).isEqualTo(expectedCompareResult);
    }

    /** Additional tests with testDNs data provider. */
    @Test(dataProvider = "testDNs")
    public void testToNormalizedByteString2(String one, String two, String three) {
        DN dn1 = DN.valueOf(one);
        DN dn2 = DN.valueOf(two);
        DN dn3 = DN.valueOf(three);
        int cmp = dn1.toNormalizedByteString().compareTo(dn2.toNormalizedByteString());
        assertThat(cmp).isEqualTo(0);
        int cmp2 = dn1.toNormalizedByteString().compareTo(dn3.toNormalizedByteString());
        assertThat(cmp2).isEqualTo(0);
    }

    @DataProvider
    private Object[][] minAndMaxRdnsDataProvider() {
        DN dcCom          = DN.valueOf("dc=com");
        DN dcExampleDcCom = DN.valueOf("dc=example,dc=com");
        DN cnTestDcCom    = DN.valueOf("cn=test,dc=com");
        return new Object[][] {
            { dcCom,          dcCom.child(RDN.minValue()),          -1 },
            { dcCom,          dcCom.child(RDN.maxValue()),          -1 },
            { dcExampleDcCom, dcExampleDcCom.child(RDN.minValue()), -1 },
            { dcExampleDcCom, dcExampleDcCom.child(RDN.maxValue()), -1 },
            { dcExampleDcCom, dcCom.child(RDN.minValue()),           1 },
            { dcExampleDcCom, dcCom.child(RDN.maxValue()),          -1 },
            // siblings
            { DN.valueOf("cn=test+dc=example,dc=com"), cnTestDcCom.child(RDN.minValue()), 1 },
            { DN.valueOf("dc=example+cn=test,dc=com"), cnTestDcCom.child(RDN.minValue()), 1 },
            { DN.valueOf("cn=test+dc=example,dc=com"), cnTestDcCom.child(RDN.maxValue()), 1 },
            { DN.valueOf("dc=example+cn=test,dc=com"), cnTestDcCom.child(RDN.maxValue()), 1 },
        };
    }

    /** Using DN as a Map key depends on this behaviour. In particular MemoryBackend depends on this behaviour. */
    @Test(dataProvider = "minAndMaxRdnsDataProvider")
    public void testToNormalizedByteStringWithMinAndMaxRdns(DN dn1, DN dn2, int expectedCompareResult) {
        int cmp = dn1.toNormalizedByteString().compareTo(dn2.toNormalizedByteString());
        assertThat(signum(cmp)).isEqualTo(expectedCompareResult);
    }

    @Test
    public void testToNormalizedByteStringWithMinAndMaxRdnsInOrderedCollection() {
        DN dcCom = DN.valueOf("dc=com");
        DN cnTestDcCom = DN.valueOf("cn=test,dc=com");
        DN cnDeeperCnTestDcCom = DN.valueOf("cn=deeper,cn=test,dc=com");
        DN cnTestAndDcExampleDcCom = DN.valueOf("cn=test+dc=example,dc=com");
        DN dcExampleDcCom = DN.valueOf("dc=example,dc=com");

        TreeMap<ByteString, DN> map = new TreeMap<>();
        putAll(map, dcCom, cnTestDcCom, cnDeeperCnTestDcCom, cnTestAndDcExampleDcCom, dcExampleDcCom);

        assertThat(subordinates(map, dcCom))
            .containsExactly(cnTestDcCom, cnDeeperCnTestDcCom, cnTestAndDcExampleDcCom, dcExampleDcCom);
        assertThat(subordinates(map, cnTestDcCom))
            .containsExactly(cnDeeperCnTestDcCom);

        assertThat(after(map, cnTestDcCom))
            .containsExactly(cnDeeperCnTestDcCom, cnTestAndDcExampleDcCom, dcExampleDcCom);
        assertThat(after(map, cnDeeperCnTestDcCom))
            .containsExactly(cnTestAndDcExampleDcCom, dcExampleDcCom);

        assertThat(before(map, cnTestDcCom))
            .containsExactly(dcCom);
        assertThat(before(map, cnDeeperCnTestDcCom))
            .containsExactly(dcCom, cnTestDcCom);
    }

    private void putAll(Map<ByteString, DN> map, DN... dns) {
        for (DN dn : dns) {
            map.put(dn.toNormalizedByteString(), dn);
        }
    }

    private Collection<DN> subordinates(TreeMap<ByteString, DN> map, DN dn) {
        return map.subMap(
            dn.child(RDN.minValue()).toNormalizedByteString(),
            dn.child(RDN.maxValue()).toNormalizedByteString()).values();
    }

    private Collection<DN> before(TreeMap<ByteString, DN> map, DN dn) {
        return map.headMap(dn.toNormalizedByteString(), false).values();
    }

    private Collection<DN> after(TreeMap<ByteString, DN> map, DN dn) {
        return map.tailMap(dn.toNormalizedByteString(), false).values();
    }

    @DataProvider
    public Object[][] toNormalizedUrlSafeStringDataProvider() {
        // @formatter:off
        return new Object[][] {
            // first value = string used to build DN, second value = expected readable string
            { "dc=com", "dc=com" },
            { "dc=example,dc=com", "dc=com,dc=example" },
            { "dc = example, dc = com", "dc=com,dc=example" },
            { "dc=example+cn=test,dc=com", "dc=com,cn=test+dc=example" },
            { "cn=test+dc=example,dc=com", "dc=com,cn=test+dc=example" },
            // with space
            { "dc=example test,dc=com", "dc=com,dc=example%20test" },
            { "dc=example\\20test,dc=com", "dc=com,dc=example%20test" },
            // with escaped comma
            { "dc=example\\,dc=com,dc=com", "dc=com,dc=example%2Cdc%3Dcom" },
            { "dc=example\\2Cdc=com,dc=com", "dc=com,dc=example%2Cdc%3Dcom" },
            // with escaped "="
            { "dc=example\\=other,dc=com", "dc=com,dc=example%3Dother" },
            { "dc=example\\3Dother,dc=com", "dc=com,dc=example%3Dother" },
            // with escaped "+"
            { "dc=example\\+other,dc=com", "dc=com,dc=example%2Bother" },
            { "dc=example\\2Bother,dc=com", "dc=com,dc=example%2Bother" },
            // integer
            { "governingStructureRule=256,dc=com", "dc=com,governingstructurerule=%82%01%00" },
            // uuid
            { "entryUUID=597ae2f6-16a6-1027-98f4-d28b5365dc14,dc=com",
              "dc=com,entryuuid=%59%7A%E2%F6%16%A6%10%27%98%F4%D2%8B%53%65%DC%14" },
            // characters unescaped by URL encoding (-, _, ., ~)
            { "dc=example\\2Dtest,dc=com", "dc=com,dc=example-test" },
            { "dc=example\\5Ftest,dc=com", "dc=com,dc=example_test" },
        };
        // @formatter:on
    }

    @Test(dataProvider = "toNormalizedUrlSafeStringDataProvider")
    public void testToNormalizedUrlSafeString(String dnAsString, String expectedReadableString) {
        DN actual = DN.valueOf(dnAsString);
        assertEquals(actual.toNormalizedUrlSafeString(), expectedReadableString);
    }

    /** Additional tests with testDNs data provider. */
    @Test(dataProvider = "testDNs")
    public void testToNormalizedUrlSafeString2(String one, String two, String three) {
        DN dn1 = DN.valueOf(one);
        DN dn2 = DN.valueOf(two);
        DN dn3 = DN.valueOf(three);
        String irreversibleReadableString = dn1.toNormalizedUrlSafeString();
        assertEquals(irreversibleReadableString, dn2.toNormalizedUrlSafeString());
        assertEquals(irreversibleReadableString, dn3.toNormalizedUrlSafeString());
    }

    @Test
    public void toUUID() {
        UUID uuid1 = DN.valueOf("dc=example+cn=test,dc=com").toUUID();
        UUID uuid2 = DN.valueOf("cn=test+dc=example,dc=com").toUUID();
        assertEquals(uuid1, uuid2);
    }

    @DataProvider
    public Object[][] toStringShouldStripOutIllegalWhitespaceDataProvider() {
        // @formatter:off
        return new Object[][] {
            { " ", "" },
            { " dc = hello  world ", "dc=hello  world" },
            { " dc =\\  hello  world\\  ", "dc=\\  hello  world\\ " },
            { " dc = example , dc = com ", "dc=example,dc=com" },
            { " uid = crystal + dc = example , uid = palace + dc = com ", "uid=crystal+dc=example,uid=palace+dc=com" },
        };
        // @formatter:on
    }

    @Test(dataProvider = "toStringShouldStripOutIllegalWhitespaceDataProvider")
    public void toStringShouldStripOutIllegalWhitespace(String withWhiteSpace, String withoutWhiteSpace) {
        assertThat(DN.valueOf(withWhiteSpace).toString()).isEqualTo(withoutWhiteSpace);
        assertThat(DN.valueOf(withWhiteSpace).toNormalizedByteString())
                .isEqualTo(DN.valueOf(withoutWhiteSpace).toNormalizedByteString());
    }

    @DataProvider
    public Object[][] rdnShouldReturnNullWhenIndexIsOutOfRangeData() {
        return new Object[][] {
            { "", 0 },
            { "", 1 },
            { "dc=com", 1 },
            { "dc=opends,dc=com", 2 },
            { "dc=hello,dc=world,dc=opends,dc=com", 4 },
        };
    }

    @Test(dataProvider = "rdnShouldReturnNullWhenIndexIsOutOfRangeData")
    public void rdnShouldReturnNullWhenIndexIsOutOfRange(String rdn, int i) {
        assertThat((Object) DN.valueOf(rdn).rdn(i)).isNull();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void rdnShouldThrowIAEForNegativeIndexes() throws Exception {
        DN.valueOf("dc=example,dc=com").rdn(-1);
    }

    @Test
    public void testToStringOnExtremelyLongDNs() {
        int numRDNs = 16384;
        String rdn = "cn=verylongdn,";
        String base = "dc=example,dc=com";
        StringBuilder builder = new StringBuilder(rdn.length() * numRDNs + base.length());
        for (int i = 0; i < numRDNs; i++) {
            builder.append(rdn);
        }
        builder.append(base);
        DN longDN = DN.valueOf(builder.toString());
        assertEquals(longDN.toString(), builder.toString(),
            "String representation of a very long DN does not match the source DN");
    }
}
