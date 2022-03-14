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
package org.forgerock.opendj.server.config.server;



import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;



/**
 * A server-side interface for querying Task Backend settings.
 * <p>
 * The Task Backend provides a mechanism for scheduling tasks in the
 * OpenDJ directory server. Tasks are intended to provide access to
 * certain types of administrative functions in the server that may not
 * be convenient to perform remotely.
 */
public interface TaskBackendCfg extends LocalBackendCfg {

  /**
   * Gets the configuration class associated with this Task Backend.
   *
   * @return Returns the configuration class associated with this Task Backend.
   */
  Class<? extends TaskBackendCfg> configurationClass();



  /**
   * Register to be notified when this Task Backend is changed.
   *
   * @param listener
   *          The Task Backend configuration change listener.
   */
  void addTaskChangeListener(ConfigurationChangeListener<TaskBackendCfg> listener);



  /**
   * Deregister an existing Task Backend configuration change listener.
   *
   * @param listener
   *          The Task Backend configuration change listener.
   */
  void removeTaskChangeListener(ConfigurationChangeListener<TaskBackendCfg> listener);



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
   * Gets the "task-retention-time" property.
   * <p>
   * Specifies the length of time that task entries should be retained
   * after processing on the associated task has been completed.
   *
   * @return Returns the value of the "task-retention-time" property.
   */
  long getTaskRetentionTime();



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();

}
