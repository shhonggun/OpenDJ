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
 * Portions Copyright 2015-2016 ForgeRock AS.
 */
package org.opends.server.tools.makeldif;



import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.opends.server.types.LDIFExportConfig;
import org.opends.server.util.LDIFException;
import org.opends.server.util.LDIFWriter;



/**
 * This class creates an input stream that can be used to read entries generated
 * by MakeLDIF as if they were being read from another source like a file.  It
 * has a fixed-size queue that dictates how many entries may be held in memory
 * at any given time.
 */
public class MakeLDIFInputStream
       extends InputStream
       implements EntryWriter
{
  /** Indicates whether all of the entries have been generated. */
  private boolean allGenerated;

  /** Indicates whether this input stream has been closed. */
  private boolean closed;

  /**
   * The byte array output stream that will be used to convert entries to byte
   * arrays with their LDIF representations.
   */
  private ByteArrayOutputStream entryOutputStream;

  /** The byte array that will hold the LDIF representation of the next entry to be read. */
  private ByteBuffer entryBytes;

  /** The IOException that should be thrown the next time a read is requested. */
  private IOException ioException;

  /** The LDIF writer that will be used to write the entries to LDIF. */
  private LDIFWriter ldifWriter;

  /** The queue used to hold generated entries until they can be read. */
  private LinkedBlockingQueue<TemplateEntry> entryQueue;

  /**
   * Creates a new MakeLDIF input stream that will generate entries based on the
   * provided template file.
   *
   * @param  templateFile  The template file to use to generate the entries.
   */
  public MakeLDIFInputStream(TemplateFile templateFile)
  {
    allGenerated = false;
    closed       = false;
    entryQueue   = new LinkedBlockingQueue<>(10);
    ioException  = null;
    entryBytes   = null;

    entryOutputStream = new ByteArrayOutputStream(8192);
    LDIFExportConfig exportConfig = new LDIFExportConfig(entryOutputStream);

    try
    {
      ldifWriter = new LDIFWriter(exportConfig);
    }
    catch (IOException ioe)
    {
      // This should never happen.
      ioException = ioe;
    }

    /* The background thread being used to actually generate the entries. */
    new MakeLDIFInputStreamThread(this, templateFile).start();
  }



  /** Closes this input stream so that no more data may be read from it. */
  @Override
  public void close()
  {
    closed      = true;
    ioException = null;
  }



  /**
   * Reads a single byte of data from this input stream.
   *
   * @return  The byte read from the input stream, or -1 if the end of the
   *          stream has been reached.
   *
   * @throws  IOException  If a problem has occurred while generating data for
   *                       use by this input stream.
   */
  @Override
  public int read()
         throws IOException
  {
    if (closed)
    {
      return -1;
    }
    else if (ioException != null)
    {
      throw ioException;
    }

    if ((entryBytes == null || !entryBytes.hasRemaining())
        && !getNextEntry())
    {
      closed = true;
      return -1;
    }

    return 0xFF & entryBytes.get();
  }



  /**
   * Reads data from this input stream.
   *
   * @param  b    The array into which the data should be read.
   * @param  off  The position in the array at which point the data read may be
   *              placed.
   * @param  len  The maximum number of bytes that may be read into the
   *              provided array.
   *
   * @return  The number of bytes read from the input stream into the provided
   *          array, or -1 if the end of the stream has been reached.
   *
   * @throws  IOException  If a problem has occurred while generating data for
   *                       use by this input stream.
   */
  @Override
  public int read(byte[] b, int off, int len)
         throws IOException
  {
    if (closed)
    {
      return -1;
    }
    else if (ioException != null)
    {
      throw ioException;
    }

    if ((entryBytes == null || !entryBytes.hasRemaining())
        && !getNextEntry())
    {
      closed = true;
      return -1;
    }

    int bytesRead = Math.min(len, entryBytes.remaining());
    entryBytes.get(b, off, bytesRead);
    return bytesRead;
  }



  @Override
  public boolean writeEntry(TemplateEntry entry)
         throws IOException, MakeLDIFException
  {
    while (! closed)
    {
      try
      {
        if (entryQueue.offer(entry, 500, TimeUnit.MILLISECONDS))
        {
          return true;
        }
      } catch (InterruptedException ie) {}
    }

    return false;
  }



  @Override
  public void closeEntryWriter()
  {
    allGenerated = true;
  }



  /**
   * Sets the I/O exception that should be thrown on any subsequent calls to
   * <CODE>available</CODE> or <CODE>read</CODE>.
   *
   * @param  ioException   The I/O exception that should be thrown.
   */
  void setIOException(IOException ioException)
  {
    this.ioException = ioException;
  }



  /**
   * Retrieves the next entry and puts it in the entry byte buffer.
   *
   * @return  <CODE>true</CODE> if the next entry is available, or
   *          <CODE>false</CODE> if there are no more entries or if the input
   *          stream has been closed.
   */
  private boolean getNextEntry()
  {
    TemplateEntry entry = entryQueue.poll();
    while (entry == null)
    {
      if (closed)
      {
        return false;
      }
      else if (allGenerated)
      {
        entry = entryQueue.poll();
        if (entry == null)
        {
          return false;
        }
      }
      else
      {
        try
        {
          entry = entryQueue.poll(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ie) {}
      }
    }

    try
    {
      entryOutputStream.reset();
      ldifWriter.writeTemplateEntry(entry);
      ldifWriter.flush();
      entryBytes = ByteBuffer.wrap(entryOutputStream.toByteArray());
    }
    catch (LDIFException le)
    {
      // This should never happen.
      ioException = new IOException(le.getMessage());
      return false;
    }
    catch (IOException ioe)
    {
      // Neither should this.
      ioException = ioe;
      return false;
    }

    return true;
  }
}

