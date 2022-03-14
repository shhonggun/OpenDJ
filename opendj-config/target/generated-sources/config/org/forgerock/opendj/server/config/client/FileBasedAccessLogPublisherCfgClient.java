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
import org.forgerock.opendj.server.config.meta.FileBasedAccessLogPublisherCfgDefn.LogFormat;
import org.forgerock.opendj.server.config.server.FileBasedAccessLogPublisherCfg;



/**
 * A client-side interface for reading and modifying File Based Access
 * Log Publisher settings.
 * <p>
 * File Based Access Log Publishers publish access messages to the
 * file system.
 */
public interface FileBasedAccessLogPublisherCfgClient extends AccessLogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this File Based Access Log Publisher.
   *
   * @return Returns the configuration definition associated with this File Based Access Log Publisher.
   */
  ManagedObjectDefinition<? extends FileBasedAccessLogPublisherCfgClient, ? extends FileBasedAccessLogPublisherCfg> definition();



  /**
   * Gets the "append" property.
   * <p>
   * Specifies whether to append to existing log files.
   *
   * @return Returns the value of the "append" property.
   */
  boolean isAppend();



  /**
   * Sets the "append" property.
   * <p>
   * Specifies whether to append to existing log files.
   *
   * @param value The value of the "append" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAppend(Boolean value) throws PropertyException;



  /**
   * Gets the "asynchronous" property.
   * <p>
   * Indicates whether the File Based Access Log Publisher will
   * publish records asynchronously.
   *
   * @return Returns the value of the "asynchronous" property.
   */
  boolean isAsynchronous();



  /**
   * Sets the "asynchronous" property.
   * <p>
   * Indicates whether the File Based Access Log Publisher will
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
   * Gets the "buffer-size" property.
   * <p>
   * Specifies the log file buffer size.
   *
   * @return Returns the value of the "buffer-size" property.
   */
  long getBufferSize();



  /**
   * Sets the "buffer-size" property.
   * <p>
   * Specifies the log file buffer size.
   *
   * @param value The value of the "buffer-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBufferSize(Long value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Access Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Access Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "log-control-oids" property.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @return Returns the value of the "log-control-oids" property.
   */
  boolean isLogControlOids();



  /**
   * Sets the "log-control-oids" property.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @param value The value of the "log-control-oids" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogControlOids(Boolean value) throws PropertyException;



  /**
   * Gets the "log-file" property.
   * <p>
   * The file name to use for the log files generated by the File
   * Based Access Log Publisher. The path to the file is relative to
   * the server root.
   *
   * @return Returns the value of the "log-file" property.
   */
  String getLogFile();



  /**
   * Sets the "log-file" property.
   * <p>
   * The file name to use for the log files generated by the File
   * Based Access Log Publisher. The path to the file is relative to
   * the server root.
   *
   * @param value The value of the "log-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogFile(String value) throws PropertyException;



  /**
   * Gets the "log-file-permissions" property.
   * <p>
   * The UNIX permissions of the log files created by this File Based
   * Access Log Publisher.
   *
   * @return Returns the value of the "log-file-permissions" property.
   */
  String getLogFilePermissions();



  /**
   * Sets the "log-file-permissions" property.
   * <p>
   * The UNIX permissions of the log files created by this File Based
   * Access Log Publisher.
   *
   * @param value The value of the "log-file-permissions" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogFilePermissions(String value) throws PropertyException;



  /**
   * Gets the "log-format" property.
   * <p>
   * Specifies how log records should be formatted and written to the
   * access log.
   *
   * @return Returns the value of the "log-format" property.
   */
  LogFormat getLogFormat();



  /**
   * Sets the "log-format" property.
   * <p>
   * Specifies how log records should be formatted and written to the
   * access log.
   *
   * @param value The value of the "log-format" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogFormat(LogFormat value) throws PropertyException;



  /**
   * Gets the "log-record-time-format" property.
   * <p>
   * Specifies the format string that is used to generate log record
   * timestamps.
   *
   * @return Returns the value of the "log-record-time-format" property.
   */
  String getLogRecordTimeFormat();



  /**
   * Sets the "log-record-time-format" property.
   * <p>
   * Specifies the format string that is used to generate log record
   * timestamps.
   *
   * @param value The value of the "log-record-time-format" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogRecordTimeFormat(String value) throws PropertyException;



  /**
   * Gets the "queue-size" property.
   * <p>
   * The maximum number of log records that can be stored in the
   * asynchronous queue.
   *
   * @return Returns the value of the "queue-size" property.
   */
  int getQueueSize();



  /**
   * Sets the "queue-size" property.
   * <p>
   * The maximum number of log records that can be stored in the
   * asynchronous queue.
   *
   * @param value The value of the "queue-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setQueueSize(Integer value) throws PropertyException;



  /**
   * Gets the "retention-policy" property.
   * <p>
   * The retention policy to use for the File Based Access Log
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
   * The retention policy to use for the File Based Access Log
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
   * The rotation policy to use for the File Based Access Log
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
   * The rotation policy to use for the File Based Access Log
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
   * Gets the "time-interval" property.
   * <p>
   * Specifies the interval at which to check whether the log files
   * need to be rotated.
   *
   * @return Returns the value of the "time-interval" property.
   */
  long getTimeInterval();



  /**
   * Sets the "time-interval" property.
   * <p>
   * Specifies the interval at which to check whether the log files
   * need to be rotated.
   *
   * @param value The value of the "time-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTimeInterval(Long value) throws PropertyException;

}
