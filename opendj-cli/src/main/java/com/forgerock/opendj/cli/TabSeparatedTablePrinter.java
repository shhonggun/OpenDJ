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

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * An interface for creating a tab-separated formatted table.
 * <p>
 * This table printer will replace any tab, line-feeds, or carriage return control characters encountered in a cell with
 * a single space.
 */
public final class TabSeparatedTablePrinter extends TablePrinter {
    /** Table serializer implementation. */
    private final class Serializer extends TableSerializer {
        /**
         * Counts the number of separators that should be output the next time a non-empty cell is displayed. The tab
         * separators are not displayed immediately so that we can avoid displaying unnecessary trailing separators.
         */
        private int requiredSeparators;

        /** Private constructor. */
        private Serializer() {
            // No implementation required.
        }

        @Override
        public void addCell(String s) {
            // Avoid printing tab separators for trailing empty cells.
            if (s.length() == 0) {
                requiredSeparators++;
            } else {
                for (int i = 0; i < requiredSeparators; i++) {
                    writer.print('\t');
                }
                requiredSeparators = 1;
            }

            // Replace all new-lines and tabs with a single space.
            writer.print(s.replaceAll("[\\t\\n\\r]", " "));
        }

        @Override
        public void addHeading(String s) {
            if (displayHeadings) {
                addCell(s);
            }
        }

        @Override
        public void endHeader() {
            if (displayHeadings) {
                writer.println();
            }
        }

        @Override
        public void endRow() {
            writer.println();
        }

        @Override
        public void endTable() {
            writer.flush();
        }

        @Override
        public void startHeader() {
            requiredSeparators = 0;
        }

        @Override
        public void startRow() {
            requiredSeparators = 0;
        }
    }

    /** Indicates whether the headings should be output. */
    private boolean displayHeadings;

    /** The output destination. */
    private PrintWriter writer;

    /**
     * Creates a new tab separated table printer for the specified output stream. Headings will not be displayed by
     * default.
     *
     * @param stream
     *            The stream to output tables to.
     */
    public TabSeparatedTablePrinter(OutputStream stream) {
        this(new BufferedWriter(new OutputStreamWriter(stream)));
    }

    /**
     * Creates a new tab separated table printer for the specified writer. Headings will not be displayed by default.
     *
     * @param writer
     *            The writer to output tables to.
     */
    public TabSeparatedTablePrinter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    /**
     * Specify whether table headings should be displayed.
     *
     * @param displayHeadings
     *            <code>true</code> if table headings should be displayed.
     */
    public void setDisplayHeadings(boolean displayHeadings) {
        this.displayHeadings = displayHeadings;
    }

    @Override
    protected TableSerializer getSerializer() {
        return new Serializer();
    }
}
