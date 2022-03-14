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
 * Copyright 2014-2016 ForgeRock AS.
 */
package com.forgerock.opendj.ldap.tools;

import static com.forgerock.opendj.cli.CliMessages.*;
import static com.forgerock.opendj.ldap.tools.ToolsMessages.ERR_ERROR_PARSING_ARGS;
import static com.forgerock.opendj.ldap.tools.ToolsMessages.INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT;
import static com.forgerock.opendj.ldap.tools.ToolsMessages.INFO_LDAPSEARCH_TOOL_DESCRIPTION;
import static com.forgerock.opendj.ldap.tools.Utils.runTool;

import java.io.PrintStream;
import java.util.Random;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.ByteStringBuilder;
import org.forgerock.opendj.ldap.TestCaseUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** Simple integration tests to check the ldapsearch command. */
@SuppressWarnings("javadoc")
public class LDAPSearchITCase extends ToolsITCase {
    private static final int NB_RAND_SIMPLE_SEARCH = 10;
    private static final int NB_OTHER_SIMPLE_SEARCH = 3;

    @DataProvider
    public Object[][] ldapSearchArgs() throws Exception {
        Object[][] data = new Object[NB_RAND_SIMPLE_SEARCH + NB_OTHER_SIMPLE_SEARCH][];

        // Check if the help message is correctly prompted
        data[0] = new Object[] { args("--help"), INFO_LDAPSEARCH_TOOL_DESCRIPTION.get(), "" };

        // Check that there is a error message if no arguments were given to the
        // ldapsearch command
        data[1] = new Object[] { args(""), "", ERR_ERROR_PARSING_ARGS.get("") };

        // Check if the help reference message is prompted if arguments failed to be parsed
        data[2] = new Object[] {
            args("-42"), "", INFO_GLOBAL_HELP_REFERENCE.get("java " + LDAPSearch.class.getCanonicalName()) };

        // Perform some basic ldapsearch for random user in the test server
        for (int i = 0; i < NB_RAND_SIMPLE_SEARCH; i++) {
            long userID = new Random().nextInt(1000);
            data[i + NB_OTHER_SIMPLE_SEARCH] = produceLDAPSearchBasicTestCase(userID);
        }

        return data;
    }

    private Object[] produceLDAPSearchBasicTestCase(long userID) {
        String dn = String.format("uid=user.%d,ou=people,o=test", userID);
        LocalizableMessage matchEntryCnt = INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT.get(1);
        return new Object[] {
            args("--countEntries", "-h", TestCaseUtils.getServerSocketAddress().getHostName(), "-p",
                Integer.toString(TestCaseUtils.getServerSocketAddress().getPort()), "-b", dn, "(uid=user.%d)", "uid"),
            matchEntryCnt, "" };
    }

    @Test(dataProvider = "ldapSearchArgs")
    public void testITLDAPSearch(String[] arguments, Object expectedOut, Object expectedErr) throws Exception {
        ByteStringBuilder out = new ByteStringBuilder();
        ByteStringBuilder err = new ByteStringBuilder();

        try (PrintStream outStream = new PrintStream(out.asOutputStream());
             PrintStream errStream = new PrintStream(err.asOutputStream())) {
            runTool(new LDAPSearch(outStream, errStream), arguments);
            checkOuputStreams(out, err, expectedOut, expectedErr);
        } catch (final LDAPToolException e) {
            checkOuputStreams(out, err, expectedOut, expectedErr);
        }
    }
}
