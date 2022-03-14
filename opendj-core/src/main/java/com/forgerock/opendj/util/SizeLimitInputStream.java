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
 * Copyright 2006-2009 Sun Microsystems, Inc.
 * Portions Copyright 2016 ForgeRock AS.
 */
package com.forgerock.opendj.util;

import java.io.IOException;
import java.io.InputStream;

/** An implementation of input stream that enforces an read size limit. */
public class SizeLimitInputStream extends InputStream {
    private int bytesRead;
    private int markBytesRead;
    private final int readLimit;
    private final InputStream parentStream;

    /**
     * Creates a new a new size limit input stream.
     *
     * @param parentStream
     *            The parent stream.
     * @param readLimit
     *            The size limit.
     */
    public SizeLimitInputStream(final InputStream parentStream, final int readLimit) {
        this.parentStream = parentStream;
        this.readLimit = readLimit;
    }

    @Override
    public int available() throws IOException {
        final int streamAvail = parentStream.available();
        final int limitedAvail = readLimit - bytesRead;
        return limitedAvail < streamAvail ? limitedAvail : streamAvail;
    }

    @Override
    public void close() throws IOException {
        parentStream.close();
    }

    /**
     * Retrieves the number of bytes read from this stream.
     *
     * @return The number of bytes read from this stream.
     */
    public int getBytesRead() {
        return bytesRead;
    }

    /**
     * Retrieves the size limit of this stream.
     *
     * @return The size limit of this stream.
     */
    public int getSizeLimit() {
        return readLimit;
    }

    @Override
    public synchronized void mark(final int readlimit) {
        parentStream.mark(readlimit);
        markBytesRead = bytesRead;
    }

    @Override
    public boolean markSupported() {
        return parentStream.markSupported();
    }

    @Override
    public int read() throws IOException {
        if (bytesRead >= readLimit) {
            return -1;
        }

        final int b = parentStream.read();
        if (b != -1) {
            ++bytesRead;
        }
        return b;
    }

    @Override
    public int read(final byte[] b, final int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }

        if (len == 0) {
            return 0;
        }

        if (bytesRead >= readLimit) {
            return -1;
        }

        if (bytesRead + len > readLimit) {
            len = readLimit - bytesRead;
        }

        final int readLen = parentStream.read(b, off, len);
        if (readLen > 0) {
            bytesRead += readLen;
        }
        return readLen;
    }

    @Override
    public synchronized void reset() throws IOException {
        parentStream.reset();
        bytesRead = markBytesRead;
    }

    @Override
    public long skip(long n) throws IOException {
        if (bytesRead + n > readLimit) {
            n = readLimit - bytesRead;
        }

        bytesRead += n;
        return parentStream.skip(n);
    }
}
