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
package com.forgerock.opendj.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.forgerock.i18n.LocalizableMessage;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/** Unit tests for the console application class. */
@SuppressWarnings("javadoc")
public class ConsoleApplicationTestCase extends CliTestCase {
    final LocalizableMessage msg = LocalizableMessage.raw("Language is the source of misunderstandings.");
    final LocalizableMessage msg2 = LocalizableMessage
            .raw("If somebody wants a sheep, that is a proof that one exists.");

    /** For test purposes only. */
    private static class MockConsoleApplication extends ConsoleApplication {
        private static ByteArrayOutputStream out;
        private static ByteArrayOutputStream err;
        private boolean verbose;
        private boolean interactive;
        private boolean quiet;

        private MockConsoleApplication(PrintStream out, PrintStream err) {
            super(out, err);
        }

        static MockConsoleApplication getDefault() {
            out = new ByteArrayOutputStream();
            final PrintStream psOut = new PrintStream(out);
            err = new ByteArrayOutputStream();
            final PrintStream psErr = new PrintStream(err);
            return new MockConsoleApplication(psOut, psErr);
        }

        public String getOut() throws UnsupportedEncodingException {
            return out.toString("UTF-8");
        }

        public String getErr() throws UnsupportedEncodingException {
            return err.toString("UTF-8");
        }

        @Override
        public boolean isVerbose() {
            return verbose;
        }

        @Override
        public boolean isInteractive() {
            return interactive;
        }

        @Override
        public boolean isQuiet() {
            return quiet;
        }

        public void setVerbose(boolean v) {
            verbose = v;
        }

        public void setInteractive(boolean inter) {
            interactive = inter;
        }

        public void setQuiet(boolean q) {
            quiet = q;
        }

        @Override
        public boolean isMenuDrivenMode() {
            return false;
        }
    }

    @Test
    public void testWriteLineInOutputStream() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();
        ca.print(msg);
        assertThat(ca.getOut()).contains(msg.toString());
        assertThat(ca.getErr()).isEmpty();
    }

    @Test
    public void testWriteLineInErrorStream() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();
        ca.errPrintln(msg);
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).contains(msg.toString());
    }

    @Test
    public void testWriteOutputStreamVerbose() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();
        ca.printVerboseMessage(msg);
        assertThat(ca.isVerbose()).isFalse();
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).isEmpty();
        ca.setVerbose(true);
        ca.printVerboseMessage(msg);
        assertThat(ca.isVerbose()).isTrue();
        assertThat(ca.getOut()).contains(msg.toString());
        assertThat(ca.getErr()).isEmpty();
    }

    @Test
    public void testWriteErrorStreamVerbose() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();
        ca.errPrintVerboseMessage(msg);
        assertThat(ca.isVerbose()).isFalse();
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).isEmpty();
        ca.setVerbose(true);
        ca.errPrintVerboseMessage(msg);
        assertThat(ca.isVerbose()).isTrue();
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).contains(msg.toString());
    }

    /**
     * In non interactive applications, standard messages should be displayed in the stdout(info) and errors to the
     * stderr (warnings, errors).
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testNonInteractiveApplicationShouldNotStdoutErrors() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();

        assertFalse(ca.isInteractive());
        ca.errPrintln(msg);
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).contains(msg.toString());
        ca.println(msg2);
        assertThat(ca.getOut()).contains(msg2.toString());
        assertThat(ca.getErr()).doesNotContain(msg2.toString());
    }

    /**
     * If an application is interactive, all messages should be redirect to the stdout. (info, warnings, errors).
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testInteractiveApplicationShouldStdoutErrors() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();

        assertFalse(ca.isInteractive());
        ca.setInteractive(true);
        assertTrue(ca.isInteractive());
        ca.errPrintln(msg);
        assertThat(ca.getOut()).contains(msg.toString());
        assertThat(ca.getErr()).isEmpty();
        ca.println(msg2);
        assertThat(ca.getOut()).contains(msg2.toString());
        assertThat(ca.getErr()).isEmpty();
    }

    /**
     * In quiet mode, only the stderr should contain lines.
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testQuietMode() throws UnsupportedEncodingException {
        final MockConsoleApplication ca = MockConsoleApplication.getDefault();
        ca.setQuiet(true);
        assertTrue(ca.isQuiet());
        ca.println(msg);
        ca.errPrintln(msg2);
        assertThat(ca.getOut()).isEmpty();
        assertThat(ca.getErr()).contains(msg2.toString());
        assertThat(ca.getErr()).doesNotContain(msg.toString());
    }
}
