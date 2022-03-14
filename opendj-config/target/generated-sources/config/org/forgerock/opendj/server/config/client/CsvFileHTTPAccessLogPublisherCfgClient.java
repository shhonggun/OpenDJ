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
 */
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.CsvFileHTTPAccessLogPublisherCfg;



/**
 * A client-side interface for reading and modifying Csv File HTTP
 * Access Log Publisher settings.
 * <p>
 * Csv File HTTP Access Log Publishers publish HTTP access messages to
 * CSV files.
 */
public interface CsvFileHTTPAccessLogPublisherCfgClient extends HTTPAccessLogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this Csv File HTTP Access Log Publisher.
   *
   * @return Returns the configuration definition associated with this Csv File HTTP Access Log Publisher.
   */
  ManagedObjectDefinition<? extends CsvFileHTTPAccessLogPublisherCfgClient, ? extends CsvFileHTTPAccessLogPublisherCfg> definition();



  /**
   * Gets the "asynchronous" property.
   * <p>
   * Indicates whether the Csv File HTTP Access Log Publisher will
   * publish records asynchronously.
   *
   * @return Returns the value of the "asynchronous" property.
   */
  boolean isAsynchronous();



  /**
   * Sets the "asynchronous" property.
   * <p>
   * Indicates whether the Csv File HTTP Access Log Publisher will
   * publish records asynchronously.
   *
   * @param value The value of the "asynchronous" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAsynchronous(boolean value) throws PropertyException;



  /**
   * Gets the "auto-flush" property.
   * <p>
   * Specifies whether to flush the writer after every log record.
   * <p>
   * If the asynchronous writes option is used, the writer is flushed
   * after all the log records in the queue are written.
   *
   * @return Returns the value of the "auto-flush" property.
   */
  boolean isAutoFlush();



  /**
   * Sets the "auto-flush" property.
   * <p>
   * Specifies whether to flush the writer after every log record.
   * <p>
   * If the asynchronous writes option is used, the writer is flushed
   * after all the log records in the queue are written.
   *
   * @param value The value of the "auto-flush" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAutoFlush(Boolean value) throws PropertyException;



  /**
   * Gets the "csv-delimiter-char" property.
   * <p>
   * The delimiter character to use when writing in CSV format.
   *
   * @return Returns the value of the "csv-delimiter-char" property.
   */
  String getCsvDelimiterChar();



  /**
   * Sets the "csv-delimiter-char" property.
   * <p>
   * The delimiter character to use when writing in CSV format.
   *
   * @param value The value of the "csv-delimiter-char" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCsvDelimiterChar(String value) throws PropertyException;



  /**
   * Gets the "csv-eol-symbols" property.
   * <p>
   * The string that marks the end of a line.
   *
   * @return Returns the value of the "csv-eol-symbols" property.
   */
  String getCsvEolSymbols();



  /**
   * Sets the "csv-eol-symbols" property.
   * <p>
   * The string that marks the end of a line.
   *
   * @param value The value of the "csv-eol-symbols" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCsvEolSymbols(String value) throws PropertyException;



  /**
   * Gets the "csv-quote-char" property.
   * <p>
   * The character to append and prepend to a CSV field when writing
   * in CSV format.
   *
   * @return Returns the value of the "csv-quote-char" property.
   */
  String getCsvQuoteChar();



  /**
   * Sets the "csv-quote-char" property.
   * <p>
   * The character to append and prepend to a CSV field when writing
   * in CSV format.
   *
   * @param value The value of the "csv-quote-char" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCsvQuoteChar(String value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the Csv
   * File HTTP Access Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the Csv
   * File HTTP Access Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "key-store-file" property.
   * <p>
   * Specifies the path to the file that contains the private key
   * information. This may be an absolute path, or a path that is
   * relative to the OpenDJ instance root.
   * <p>
   * Changes to this property will take effect the next time that the
   * key store is accessed.
   *
   * @return Returns the value of the "key-store-file" property.
   */
  String getKeyStoreFile();



  /**
   * Sets the "key-store-file" property.
   * <p>
   * Specifies the path to the file that contains the private key
   * information. This may be an absolute path, or a path that is
   * relative to the OpenDJ instance root.
   * <p>
   * Changes to this property will take effect the next time that the
   * key store is accessed.
   *
   * @param value The value of the "key-store-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStoreFile(String value) throws PropertyException;



  /**
   * Gets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * Csv File HTTP Access Log Publisher .
   *
   * @return Returns the value of the "key-store-pin-file" property.
   */
  String getKeyStorePinFile();



  /**
   * Sets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * Csv File HTTP Access Log Publisher .
   *
   * @param value The value of the "key-store-pin-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStorePinFile(String value) throws PropertyException;



  /**
   * Gets the "log-directory" property.
   * <p>
   * The directory to use for the log files generated by the Csv File
   * HTTP Access Log Publisher. The path to the directory is relative
   * to the server root.
   *
   * @return Returns the value of the "log-directory" property.
   */
  String getLogDirectory();



  /**
   * Sets the "log-directory" property.
   * <p>
   * The directory to use for the log files generated by the Csv File
   * HTTP Access Log Publisher. The path to the directory is relative
   * to the server root.
   *
   * @param value The value of the "log-directory" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogDirectory(String value) throws PropertyException;



  /**
   * Gets the "retention-policy" property.
   * <p>
   * The retention policy to use for the Csv File HTTP Access Log
   * Publisher .
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @return Returns the values of the "retention-policy" property.
   */
  SortedSet<String> getRetentionPolicy();



  /**
   * Sets the "retention-policy" property.
   * <p>
   * The retention policy to use for the Csv File HTTP Access Log
   * Publisher .
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @param values The values of the "retention-policy" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRetentionPolicy(Collection<String> values) throws PropertyException;



  /**
   * Gets the "rotation-policy" property.
   * <p>
   * The rotation policy to use for the Csv File HTTP Access Log
   * Publisher .
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @return Returns the values of the "rotation-policy" property.
   */
  SortedSet<String> getRotationPolicy();



  /**
   * Sets the "rotation-policy" property.
   * <p>
   * The rotation policy to use for the Csv File HTTP Access Log
   * Publisher .
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @param values The values of the "rotation-policy" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRotationPolicy(Collection<String> values) throws PropertyException;



  /**
   * Gets the "signature-time-interval" property.
   * <p>
   * Specifies the interval at which to sign the log file when secure
   * option is enabled.
   *
   * @return Returns the value of the "signature-time-interval" property.
   */
  long getSignatureTimeInterval();



  /**
   * Sets the "signature-time-interval" property.
   * <p>
   * Specifies the interval at which to sign the log file when secure
   * option is enabled.
   *
   * @param value The value of the "signature-time-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSignatureTimeInterval(Long value) throws PropertyException;



  /**
   * Gets the "tamper-evident" property.
   * <p>
   * Specifies whether the log should be signed in order to detect
   * tampering.
   * <p>
   * Every log record will be signed, making it possible to verify
   * that the log has not been tampered with. This feature has a
   * significative impact on performance of the server.
   *
   * @return Returns the value of the "tamper-evident" property.
   */
  boolean isTamperEvident();



  /**
   * Sets the "tamper-evident" property.
   * <p>
   * Specifies whether the log should be signed in order to detect
   * tampering.
   * <p>
   * Every log record will be signed, making it possible to verify
   * that the log has not been tampered with. This feature has a
   * significative impact on performance of the server.
   *
   * @param value The value of the "tamper-evident" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTamperEvident(Boolean value) throws PropertyException;

}
