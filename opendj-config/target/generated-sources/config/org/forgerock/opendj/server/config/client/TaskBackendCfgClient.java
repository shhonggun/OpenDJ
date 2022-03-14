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



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.TaskBackendCfg;



/**
 * A client-side interface for reading and modifying Task Backend
 * settings.
 * <p>
 * The Task Backend provides a mechanism for scheduling tasks in the
 * OpenDJ directory server. Tasks are intended to provide access to
 * certain types of administrative functions in the server that may not
 * be convenient to perform remotely.
 */
public interface TaskBackendCfgClient extends LocalBackendCfgClient {

  /**
   * Get the configuration definition associated with this Task Backend.
   *
   * @return Returns the configuration definition associated with this Task Backend.
   */
  ManagedObjectDefinition<? extends TaskBackendCfgClient, ? extends TaskBackendCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "notification-sender-address" property.
   * <p>
   * Specifies the email address to use as the sender (that is, the
   * "From:" address) address for notification mail messages generated
   * when a task completes execution.
   *
   * @return Returns the value of the "notification-sender-address" property.
   */
  String getNotificationSenderAddress();



  /**
   * Sets the "notification-sender-address" property.
   * <p>
   * Specifies the email address to use as the sender (that is, the
   * "From:" address) address for notification mail messages generated
   * when a task completes execution.
   *
   * @param value The value of the "notification-sender-address" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setNotificationSenderAddress(String value) throws PropertyException;



  /**
   * Gets the "task-backing-file" property.
   * <p>
   * Specifies the path to the backing file for storing information
   * about the tasks configured in the server.
   * <p>
   * It may be either an absolute path or a relative path to the base
   * of the OpenDJ directory server instance.
   *
   * @return Returns the value of the "task-backing-file" property.
   */
  String getTaskBackingFile();



  /**
   * Sets the "task-backing-file" property.
   * <p>
   * Specifies the path to the backing file for storing information
   * about the tasks configured in the server.
   * <p>
   * It may be either an absolute path or a relative path to the base
   * of the OpenDJ directory server instance.
   *
   * @param value The value of the "task-backing-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTaskBackingFile(String value) throws PropertyException;



  /**
   * Gets the "task-retention-time" property.
   * <p>
   * Specifies the length of time that task entries should be retained
   * after processing on the associated task has been completed.
   *
   * @return Returns the value of the "task-retention-time" property.
   */
  long getTaskRetentionTime();



  /**
   * Sets the "task-retention-time" property.
   * <p>
   * Specifies the length of time that task entries should be retained
   * after processing on the associated task has been completed.
   *
   * @param value The value of the "task-retention-time" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTaskRetentionTime(Long value) throws PropertyException;



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();



  /**
   * Sets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @param value The value of the "writability-mode" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWritabilityMode(WritabilityMode value) throws PropertyException;

}
