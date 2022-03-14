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
 * Copyright 2008 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package com.forgerock.opendj.cli;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.forgerock.i18n.LocalizableMessage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit tests for the SubCommand class.
 */
@SuppressWarnings("javadoc")
public final class TestSubCommandArgumentParserTestCase extends CliTestCase {

    private SubCommandArgumentParser parser;

    /** First sub-command. */
    private SubCommand sc1;
    /** Second sub-command. */
    private SubCommand sc2;

    /**
     * Create the sub-commands and parser.
     *
     * @throws Exception
     *             If something unexpected happened.
     */
    @BeforeClass
    public void setup() throws Exception {
        parser = new SubCommandArgumentParser(getClass().getName(), LocalizableMessage.raw("test description"), true);

        sc1 = new SubCommand(parser, "sub-command1", LocalizableMessage.raw("sub-command1"));
        sc2 = new SubCommand(parser, "sub-command2", true, 2, 4, "args1 arg2 [arg3 arg4]",
                             LocalizableMessage.raw("sub-command2"));
    }

    /**
     * Test the getSubCommand method.
     *
     * @throws Exception
     *             If something unexpected happened.
     */
    @Test
    public void testGetSubCommand() throws Exception {
        Assert.assertSame(parser.getSubCommand("sub-command1"), sc1);
        Assert.assertSame(parser.getSubCommand("sub-command2"), sc2);
        Assert.assertNull(parser.getSubCommand("sub-command3"));
    }

    /**
     * Provide valid command line args.
     *
     * @return Array of valid command line args.
     */
    @DataProvider(name = "validCommandLineArgs")
    public Object[][] createValidCommandLineArgs() {
        return new Object[][] {
            { new String[] {}, null },
            { new String[] { "sub-command1" }, sc1 },
            { new String[] { "sub-command2", "one", "two" }, sc2 },
            { new String[] { "sub-command2", "one", "two", "three" }, sc2 },
            { new String[] { "sub-command2", "one", "two", "three", "four" }, sc2 }, };
    }

    /**
     * Test the parseArguments method with valid args.
     *
     * @param args
     *            The command line args.
     * @param sc
     *            The expected sub-command.
     * @throws Exception
     *             If something unexpected happened.
     */
    @Test(dataProvider = "validCommandLineArgs")
    public void testParseArgumentsWithValidArgs(String[] args, SubCommand sc) throws Exception {
        parser.parseArguments(args);

        // Check the correct sub-command was parsed.
        Assert.assertEquals(parser.getSubCommand(), sc);

        // Check that the trailing arguments were retrieved correctly and
        // in the right order.
        if (args.length > 1) {
            List<String> scargs = new ArrayList<>();
            for (int i = 1; i < args.length; i++) {
                scargs.add(args[i]);
            }
            Assert.assertEquals(parser.getTrailingArguments(), scargs);
        } else {
            Assert.assertTrue(parser.getTrailingArguments().isEmpty());
        }
    }

    /**
     * Provide invalid command line args.
     *
     * @return Array of invalid command line args.
     */
    @DataProvider(name = "invalidCommandLineArgs")
    public Object[][] createInvalidCommandLineArgs() {
        return new Object[][] {
            { new String[] { "sub-command1", "one" } },
            { new String[] { "sub-command1", "one", "two" } },
            { new String[] { "sub-command2" } },
            { new String[] { "sub-command2", "one" } },
            { new String[] { "sub-command2", "one", "two", "three", "four", "five" } }, };
    }

    /**
     * Test the parseArguments method with invalid args.
     *
     * @param args
     *            The command line args.
     * @throws Exception
     *             If something unexpected happened.
     */
    @Test(dataProvider = "invalidCommandLineArgs", expectedExceptions = ArgumentException.class)
    public void testParseArgumentsWithInvalidArgs(String[] args) throws Exception {
        parser.parseArguments(args);
    }

    @DataProvider
    public Object[][] indentAndWrapProvider() throws Exception {
        final String eol = System.getProperty("line.separator");
        return new Object[][] {
            { "test1",                  5, " ", " test1" + eol },
            { "test1 test2",            5, " ", " test1" + eol + " test2" + eol },
            { "test1 test2test3",       5, " ", " test1" + eol + " test2test3" + eol },
            { "test1 test2test3 test4", 5, " ", " test1" + eol + " test2test3" + eol + " test4" + eol },
        };
    }

    @Test(dataProvider = "indentAndWrapProvider")
    public void testIndentAndWrap(String text, int wrapColumn, String indent, String expected) {
        final StringBuilder buffer = new StringBuilder();
        SubCommandArgumentParser.indentAndWrap(indent, buffer, wrapColumn, LocalizableMessage.raw(text));
        Assertions.assertThat(buffer.toString()).isEqualTo(expected);
    }
}
