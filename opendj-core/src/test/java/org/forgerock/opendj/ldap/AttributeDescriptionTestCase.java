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
 * Copyright 2009-2010 Sun Microsystems, Inc.
 * Portions copyright 2012-2016 ForgeRock AS.
 */
package org.forgerock.opendj.ldap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.forgerock.i18n.LocalizedIllegalArgumentException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.Schema;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** Test {@link AttributeDescription}. */
@SuppressWarnings("javadoc")
public final class AttributeDescriptionTestCase extends SdkTestCase {

    @DataProvider
    public Object[][] dataForCompareCoreSchema() {
        // @formatter:off
        return new Object[][] {
            // AD1, AD2, compare result, isSubtype, isSuperType
            { "cn", "cn", 0, true, true },
            { "cn", "commonName", 0, true, true },
            { " cn", "commonName ", 0, true, true },
            { "commonName", "cn", 0, true, true },
            { "commonName", "commonName", 0, true, true },
            { "cn", "objectClass", 1, false, false },
            { "objectClass", "cn", -1, false, false },
            { "name", "cn", 1, false, true },
            { "cn", "name", -1, true, false },
            { "name;foo", "cn", 1, false, false },
            { "cn;foo", "name", -1, true, false },
            { "name", "cn;foo", 1, false, true },
            { "cn", "name;foo", -1, false, false },
        };
        // @formatter:on
    }

    @DataProvider
    public Object[][] dataForCompareNoSchema() {
        // @formatter:off
        return new Object[][] {
            // AD1, AD2, compare result, isSubtype, isSuperType
            { "cn", "cn", 0, true, true },
            { "cn", "CN", 0, true, true },
            { "CN", "cn", 0, true, true },
            { "CN", "CN", 0, true, true },
            { "cn", "commonName", -1, false, false },
            { "commonName", "cn", 1, false, false },
            { "commonName", "commonName", 0, true, true },
            { "cn", "cn;foo", -1, false, true },
            { "cn;foo", "cn", 1, true, false },
            { "cn;foo", "cn;foo", 0, true, true },
            { "CN;FOO", "cn;foo", 0, true, true },
            { "cn;foo", "CN;FOO", 0, true, true },
            { "CN;FOO", "CN;FOO", 0, true, true },
            { "cn;foo", "cn;bar", 1, false, false },
            { "cn;bar", "cn;foo", -1, false, false },

            { "cn;xxx;yyy", "cn", 1, true, false },
            { "cn;xxx;yyy", "cn;yyy", 1, true, false },
            { "cn;xxx;yyy", "cn;xxx", 1, true, false },
            { "cn;xxx;yyy", "cn;xxx;yyy", 0, true, true },
            { "cn;xxx;yyy", "cn;yyy;xxx", 0, true, true },
            { "cn;a;a;a;a", "cn;a", 0, false, false},
            { "cn;a;b;a", "cn;a;b", 0, false, false},

            { "cn", "cn;xxx;yyy", -1, false, true },
            { "cn;yyy", "cn;xxx;yyy", -1, false, true },
            { "cn;xxx", "cn;xxx;yyy", -1, false, true },
            { "cn;xxx;yyy", "cn;xxx;yyy", 0, true, true },
            { "cn;yyy;xxx", "cn;xxx;yyy", 0, true, true },
        };
        // @formatter:on
    }

    @DataProvider
    public Object[][] dataForValueOfCoreSchema() {
        // @formatter:off
        return new Object[][] {
            // Value, type, isObjectClass
            { "cn", "cn", false },
            { "CN", "cn", false },
            { "commonName", "cn", false },
            { "objectclass", "objectClass", true },
        };
        // @formatter:on
    }

    @DataProvider
    public Object[][] dataForValueOfInvalidAttributeDescriptions() {
        // @formatter:off
        return new Object[][] {
            { "" },
            { " " },
            { ";" },
            { " ; " },
            { "0cn" },
            { "cn+" },
            { "cn;foo+bar" },
            { "cn;foo;foo+bar" },
            { ";foo" },
            { "cn;" },
            { "cn;;foo" },
            { "cn; ;foo" },
            { "cn;foo;" },
            { "cn;foo; " },
            { "cn;foo;;bar" },
            { "cn;foo; ;bar" },
            { "cn;foo;bar;;" },
            { "1a" },
            { "1.a" },
            { "1-" },
            { "1.1a" },
            { "1.1.a" },
        };
        // @formatter:on
    }

    @DataProvider
    public Object[][] dataForValueOfNoSchema() {
        // @formatter:off
        return new Object[][] {
            // Value, type, options, containsOptions("foo")
            { "cn", "cn", new String[0], false },
            { " cn ", "cn", new String[0], false },
            { "  cn  ", "cn", new String[0], false },
            { "CN", "CN", new String[0], false },
            { "1", "1", new String[0], false },
            { "1.2", "1.2", new String[0], false },
            { "1.2.3", "1.2.3", new String[0], false },
            { "111.222.333", "111.222.333", new String[0], false },
            { "objectClass", "objectClass", new String[0], false },
            { "cn;foo", "cn", new String[] { "foo" }, true },
            { "cn;FOO", "cn", new String[] { "FOO" }, true },
            { "cn;bar", "cn", new String[] { "bar" }, false },
            { "cn;BAR", "cn", new String[] { "BAR" }, false },
            { "cn;foo;bar", "cn", new String[] { "foo", "bar" }, true },
            { "cn;FOO;bar", "cn", new String[] { "FOO", "bar" }, true },
            { "cn;foo;BAR", "cn", new String[] { "foo", "BAR" }, true },
            { "cn;FOO;BAR", "cn", new String[] { "FOO", "BAR" }, true },
            { "cn;bar;FOO", "cn", new String[] { "bar", "FOO" }, true },
            { "cn;BAR;foo", "cn", new String[] { "BAR", "foo" }, true },
            { "cn;bar;FOO", "cn", new String[] { "bar", "FOO" }, true },
            { "cn;BAR;FOO", "cn", new String[] { "BAR", "FOO" }, true },
            { " cn;BAR;FOO ", "cn", new String[] { "BAR", "FOO" }, true },
            { "  cn;BAR;FOO  ", "cn", new String[] { "BAR", "FOO" }, true },
            { "  CN;BAR;FOO  ", "CN", new String[] { "BAR", "FOO" }, true },
            { "cn;xxx;yyy;zzz", "cn", new String[] { "xxx", "yyy", "zzz" }, false },
            { "cn;zzz;YYY;xxx", "cn", new String[] { "zzz", "YYY", "xxx" }, false },
            { "CN;zzz;YYY;xxx", "CN", new String[] { "zzz", "YYY", "xxx" }, false },
            { "cn;a;a;b", "cn", new String[] { "a", "b" }, false},
            { "cn;a;a;a;a", "cn", new String[] { "a" }, false},
        };
        // @formatter:on
    }

    @Test(dataProvider = "dataForCompareCoreSchema")
    public void testCompareCoreSchema(final String ad1, final String ad2, final int compare,
            final boolean isSubType, final boolean isSuperType) {
        Schema schema = Schema.getCoreSchema();
        compare0(ad1, ad2, compare, isSubType, isSuperType, schema);
    }

    @Test(dataProvider = "dataForCompareNoSchema")
    public void testCompareNoSchema(final String ad1, final String ad2, final int compare,
            final boolean isSubType, final boolean isSuperType) {
        Schema schema = Schema.getEmptySchema();
        compare0(ad1, ad2, compare, isSubType, isSuperType, schema);
    }

    private void compare0(final String ad1, final String ad2, final int compare,
            final boolean isSubType, final boolean isSuperType, final Schema schema) {
        final AttributeDescription attributeDescription1 = AttributeDescription.valueOf(ad1, schema);
        final AttributeDescription attributeDescription2 = AttributeDescription.valueOf(ad2, schema);

        // Identity.
        assertEquals(attributeDescription1, attributeDescription1);
        assertEquals(attributeDescription1.compareTo(attributeDescription1), 0);
        assertTrue(attributeDescription1.isSubTypeOf(attributeDescription1));
        assertTrue(attributeDescription1.isSuperTypeOf(attributeDescription1));

        if (compare == 0) {
            assertEquals(attributeDescription1, attributeDescription2);
            assertEquals(attributeDescription2, attributeDescription1);
            assertEquals(attributeDescription1.compareTo(attributeDescription2), 0);
            assertEquals(attributeDescription2.compareTo(attributeDescription1), 0);

            assertTrue(attributeDescription1.isSubTypeOf(attributeDescription2));
            assertTrue(attributeDescription1.isSuperTypeOf(attributeDescription2));
            assertTrue(attributeDescription2.isSubTypeOf(attributeDescription1));
            assertTrue(attributeDescription2.isSuperTypeOf(attributeDescription1));
        } else {
            assertFalse(attributeDescription1.equals(attributeDescription2));
            assertFalse(attributeDescription2.equals(attributeDescription1));

            if (compare < 0) {
                assertTrue(attributeDescription1.compareTo(attributeDescription2) < 0);
                assertTrue(attributeDescription2.compareTo(attributeDescription1) > 0);
            } else {
                assertTrue(attributeDescription1.compareTo(attributeDescription2) > 0);
                assertTrue(attributeDescription2.compareTo(attributeDescription1) < 0);
            }

            assertEquals(attributeDescription1.isSubTypeOf(attributeDescription2), isSubType);
            assertEquals(attributeDescription1.isSuperTypeOf(attributeDescription2), isSuperType);
        }
    }

    @Test(dataProvider = "dataForValueOfCoreSchema")
    public void testValueOfCoreSchema(final String ad, final String at, final boolean isObjectClass) {
        final AttributeDescription attributeDescription =
                AttributeDescription.valueOf(ad, Schema.getCoreSchema());

        assertEquals(attributeDescription.toString(), ad);
        assertEquals(attributeDescription.getNameOrOID(), ad);
        assertEquals(attributeDescription.getAttributeType().getNameOrOID(), at);
        assertEquals(attributeDescription.isObjectClass(), isObjectClass);

        assertFalse(attributeDescription.hasOptions());
        assertFalse(attributeDescription.hasOption("dummy"));

        Assertions.assertThat(attributeDescription.getOptions()).isEmpty();
    }

    /** FIXME: none of these pass! The valueOf method is far too lenient. */
    @Test(dataProvider = "dataForValueOfInvalidAttributeDescriptions",
            expectedExceptions = LocalizedIllegalArgumentException.class)
    public void testValueOfInvalidAttributeDescriptions(final String ad) {
        AttributeDescription.valueOf(ad, Schema.getEmptySchema());
    }

    @Test(dataProvider = "dataForValueOfNoSchema")
    public void testValueOfNoSchema(final String ad, final String at, final String[] options,
            final boolean containsFoo) {
        final AttributeDescription attributeDescription =
                AttributeDescription.valueOf(ad, Schema.getEmptySchema());

        assertEquals(attributeDescription.toString(), ad);
        assertEquals(attributeDescription.getAttributeType().getNameOrOID(), at);
        assertFalse(attributeDescription.isObjectClass());

        assertOptions(attributeDescription, options);
        assertFalse(attributeDescription.hasOption("dummy"));
        if (containsFoo) {
            assertTrue(attributeDescription.hasOption("foo"));
            assertTrue(attributeDescription.hasOption("FOO"));
            assertTrue(attributeDescription.hasOption("FoO"));
        } else {
            assertFalse(attributeDescription.hasOption("foo"));
            assertFalse(attributeDescription.hasOption("FOO"));
            assertFalse(attributeDescription.hasOption("FoO"));
        }
    }

    private void assertOptions(final AttributeDescription attributeDescription, final String... options) {
        assertEquals(attributeDescription.hasOptions(), options.length != 0);
        for (final String option : options) {
            assertTrue(attributeDescription.hasOption(option));
        }

        Assertions.assertThat(attributeDescription.getOptions()).containsExactly(options);
    }

    @Test
    public void testWithOptionAddFirstOption() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn");
        AttributeDescription ad2 = ad1.withOption("test");
        assertOptions(ad2, "test");
        assertFalse(ad2.hasOption("dummy"));
        assertEquals(ad2.toString(), "cn;test");
    }

    @Test
    public void testWithOptionAddExistingFirstOption() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test");
        AttributeDescription ad2 = ad1.withOption("test");
        assertSame(ad1, ad2);
    }

    @Test
    public void testWithOptionAddSecondOption() {
        testWithOptionAddSecondOption("test1", "test2");
    }

    @Test
    public void testWithOptionAddSecondOption2() {
        testWithOptionAddSecondOption("test2", "test1");
    }

    private void testWithOptionAddSecondOption(String option1, String option2) {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;" + option1);
        AttributeDescription ad2 = ad1.withOption(option2);
        assertOptions(ad2, option1, option2);
        assertFalse(ad2.hasOption("dummy"));
        assertEquals(ad2.toString(), toAttributeDescriptionString("cn", option1, option2));
    }

    @Test
    public void testWithOptionAddExistingSecondOption() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withOption("test1");
        AttributeDescription ad3 = ad1.withOption("test2");
        assertSame(ad1, ad2);
        assertSame(ad1, ad3);
    }

    @Test
    public void testWithOptionAddMultipleOptions() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withOption("test4").withOption("test3");
        assertOptions(ad2, "test1", "test2", "test4", "test3");
        assertFalse(ad2.hasOption("dummy"));
        assertEquals(ad2.toString(), "cn;test1;test2;test4;test3");
    }

    @Test
    public void testWithOptionAddMultipleOptions2() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withOption("test0");
        assertOptions(ad2, "test1", "test2", "test0");
        assertFalse(ad2.hasOption("dummy"));
        assertEquals(ad2.toString(), "cn;test1;test2;test0");
    }

    @Test
    public void testWithoutOptionEmpty() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn");
        AttributeDescription ad2 = ad1.withoutOption("test");
        assertSame(ad1, ad2);
    }

    @Test
    public void testWithoutOptionFirstOption() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test");
        AttributeDescription ad2 = ad1.withoutOption("test");
        assertOptions(ad2);
        assertFalse(ad2.hasOption("test"));
        assertEquals(ad2.toString(), "cn");
    }

    @Test
    public void testWithoutOptionFirstOptionMissing() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test");
        AttributeDescription ad2 = ad1.withoutOption("dummy");
        assertSame(ad1, ad2);
    }

    @Test
    public void testWithoutOptionSecondOption1() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withoutOption("test1");
        assertOptions(ad2, "test2");
        assertFalse(ad2.hasOption("test1"));
        assertEquals(ad2.toString(), "cn;test2");
    }

    @Test
    public void testWithoutOptionSecondOption2() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withoutOption("test2");
        assertOptions(ad2, "test1");
        assertFalse(ad2.hasOption("test2"));
        assertEquals(ad2.toString(), "cn;test1");
    }

    @Test
    public void testWithoutOptionSecondOptionMissing() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2");
        AttributeDescription ad2 = ad1.withoutOption("dummy");
        assertSame(ad1, ad2);
    }

    @Test
    public void testWithoutOptionThirdOption1() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2;test3");
        AttributeDescription ad2 = ad1.withoutOption("test1");
        assertOptions(ad2, "test2", "test3");
        assertFalse(ad2.hasOption("test1"));
        assertEquals(ad2.toString(), "cn;test2;test3");
    }

    @Test
    public void testWithoutOptionThirdOption2() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2;test3");
        AttributeDescription ad2 = ad1.withoutOption("test2");
        assertOptions(ad2, "test1", "test3");
        assertFalse(ad2.hasOption("test2"));
        assertEquals(ad2.toString(), "cn;test1;test3");
    }

    @Test
    public void testWithoutOptionThirdOption3() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2;test3");
        AttributeDescription ad2 = ad1.withoutOption("test3");
        assertOptions(ad2, "test1", "test2");
        assertFalse(ad2.hasOption("test3"));
        assertEquals(ad2.toString(), "cn;test1;test2");
    }

    @Test
    public void testWithoutOptionThirdOptionMissing() {
        AttributeDescription ad1 = AttributeDescription.valueOf("cn;test1;test2;test3");
        AttributeDescription ad2 = ad1.withoutOption("dummy");
        assertSame(ad1, ad2);
    }

    @Test
    public void testCreateAttributeType() {
        Schema schema = Schema.getCoreSchema();
        AttributeType attributeType = schema.getAttributeType("cn");
        String name = attributeType.getNameOrOID();

        assertAttributeDescriptionCreate(
            AttributeDescription.create(attributeType),
            name, attributeType);
    }

    @Test
    public void testCreateAttributeNameAndType() {
        testCreateAttributeNameAndType0("CN");
        testCreateAttributeNameAndType0("OBJECTCLASS");
    }

    private void testCreateAttributeNameAndType0(String name) {
        Schema schema = Schema.getCoreSchema();
        AttributeType attributeType = schema.getAttributeType(name);

        assertAttributeDescriptionCreate(
            AttributeDescription.create(name, attributeType),
            name, attributeType);
    }

    @Test
    public void testCreateAttributeTypeAndOption() {
        Schema schema = Schema.getCoreSchema();
        AttributeType attributeType = schema.getAttributeType("cn");
        String name = attributeType.getNameOrOID();

        assertAttributeDescriptionCreate(
            AttributeDescription.create(attributeType, "option"),
            name, attributeType, "option");
    }

    @Test
    public void testCreateAttributeNameTypeAndOption() {
        Schema schema = Schema.getCoreSchema();
        String name = "CN";
        AttributeType attributeType = schema.getAttributeType(name);

        assertAttributeDescriptionCreate(
            AttributeDescription.create(name, attributeType, "option"),
            name, attributeType, "option");
    }

    @Test
    public void testCreateAttributeTypeAndOptionsArray() {
        Schema schema = Schema.getCoreSchema();
        AttributeType attributeType = schema.getAttributeType("cn");
        String name = attributeType.getNameOrOID();

        String[] options = { "option1", "option2" };
        assertAttributeDescriptionCreate(
            AttributeDescription.create(attributeType, options),
            name, attributeType, options);
    }

    @Test
    public void testCreateAttributeNameTypeAndOptionsArray() {
        Schema schema = Schema.getCoreSchema();
        String name = "CN";
        AttributeType attributeType = schema.getAttributeType(name);

        String[] options = { "option1", "option2" };
        assertAttributeDescriptionCreate(
            AttributeDescription.create(name, attributeType, options),
            name, attributeType, options);
    }

    @Test
    public void testCreateAttributeTypeAndOptionsCollection() {
        Schema schema = Schema.getCoreSchema();
        AttributeType attributeType = schema.getAttributeType("cn");
        String name = attributeType.getNameOrOID();

        String[] options = { "option1", "option2" };
        assertAttributeDescriptionCreate(
            AttributeDescription.create(attributeType, Arrays.asList(options)),
            name, attributeType, options);
    }

    @Test
    public void testCreateAttributeNameTypeAndNoOptionsCollection() {
        testCreateAttributeNameTypeAndOptionsCollection();
    }

    @Test
    public void testCreateAttributeNameTypeAndOneOptionCollection() {
        testCreateAttributeNameTypeAndOptionsCollection("option");
    }

    @Test
    public void testCreateAttributeNameTypeAndTwoOptionsCollection() {
        testCreateAttributeNameTypeAndOptionsCollection("option1", "option2");
    }

    private void testCreateAttributeNameTypeAndOptionsCollection(String... options) {
        Schema schema = Schema.getCoreSchema();
        String name = "CN";
        AttributeType attributeType = schema.getAttributeType(name);

        assertAttributeDescriptionCreate(
            AttributeDescription.create(name, attributeType, Arrays.asList(options)),
            name, attributeType, options);
    }

    private void assertAttributeDescriptionCreate(AttributeDescription attrDesc,
            String name, AttributeType attributeType, String... options) {
        assertEquals(attrDesc.getAttributeType(), attributeType);
        assertEquals(attrDesc.getNameOrOID(), name);
        assertOptions(attrDesc, options);
        assertEquals(attrDesc.toString(), toAttributeDescriptionString(name, options));
    }

    private String toAttributeDescriptionString(String name, String... options) {
        StringBuilder sb = new StringBuilder(name);
        for (String option : options) {
            sb.append(";").append(option);
        }
        return sb.toString();
    }
}
