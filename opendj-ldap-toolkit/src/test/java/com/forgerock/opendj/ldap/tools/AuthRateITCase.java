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
import static com.forgerock.opendj.ldap.tools.ToolsMessages.INFO_TOOL_WARMING_UP;
import static org.fest.assertions.Assertions.assertThat;

import java.io.PrintStream;

import org.forgerock.opendj.ldap.ByteStringBuilder;
import org.forgerock.opendj.ldap.TestCaseUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("javadoc")
public class AuthRateITCase extends ToolsITCase {

    private static final String THROUGHPUT_TEXT = "Recent throughput (ops/second)";

    @DataProvider
    public Object[][] authRateArgs() throws Exception {
        return new Object[][] {
            { args(""), "", ERR_ERROR_PARSING_ARGS.get("") },
            { args("-42"), "", INFO_GLOBAL_HELP_REFERENCE.get("java " + AuthRate.class.getCanonicalName()) },
            // Warm-up test case
            {
                args("-h", TestCaseUtils.getServerSocketAddress().getHostName(),
                     "-p", Integer.toString(TestCaseUtils.getServerSocketAddress().getPort()),
                     "-g", "rand(0,1000)", "-D", "uid=%d,ou=people,o=test", "-w", "password",
                     "-i", "1", "-m", "10", "-f", "-B", "1"),
                INFO_TOOL_WARMING_UP.get(1), "" },

            // Correct test case
            {
                args("-h", TestCaseUtils.getServerSocketAddress().getHostName(),
                     "-p", Integer.toString(TestCaseUtils.getServerSocketAddress().getPort()),
                     "-g", "rand(0,1000)", "-D", "uid=%d,ou=people,o=test", "-w", "password",
                     "-i", "1", "-c", "1", "-m", "10", "-f", "-S", "-B", "0"),
                THROUGHPUT_TEXT, "" },
        };
    }

    @Test(dataProvider = "authRateArgs")
    public void testITAuthRate(String[] arguments, Object expectedOut, Object expectedErr) throws Exception {
        ByteStringBuilder out = new ByteStringBuilder();
        ByteStringBuilder err = new ByteStringBuilder();

        try (PrintStream outStream = new PrintStream(out.asOutputStream());
            PrintStream errStream = new PrintStream(err.asOutputStream())) {
            AuthRate authRate = new AuthRate(outStream, errStream);

            authRate.run(arguments);
            checkOuputStreams(out, err, expectedOut, expectedErr);
            String outContent = out.toString();

            if (expectedOut.toString().contains(THROUGHPUT_TEXT)) {
                // Check that there was no error in search
                String[] authRateResLines = outContent.split(System.getProperty("line.separator"));
                //Skip header line
                for (int i = 1; i < authRateResLines.length; i++) {
                    String[] authRateLineData = authRateResLines[i].split(",");
                    assertThat(authRateLineData[authRateLineData.length - 1].trim()).isEqualTo("0.0");
                }
            }
        }
    }
}
