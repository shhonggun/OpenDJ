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



/**
 * A server-side interface for querying File Count Log Retention
 * Policy settings.
 * <p>
 * Retention policy based on the number of rotated log files on disk.
 */
public interface FileCountLogRetentionPolicyCfg extends LogRetentionPolicyCfg {

  /**
   * Gets the configuration class associated with this File Count Log Retention Policy.
   *
   * @return Returns the configuration class associated with this File Count Log Retention Policy.
   */
  Class<? extends FileCountLogRetentionPolicyCfg> configurationClass();



  /**
   * Register to be notified when this File Count Log Retention Policy is changed.
   *
   * @param listener
   *          The File Count Log Retention Policy configuration change listener.
   */
  void addFileCountChangeListener(ConfigurationChangeListener<FileCountLogRetentionPolicyCfg> listener);



  /**
   * Deregister an existing File Count Log Retention Policy configuration change listener.
   *
   * @param listener
   *          The File Count Log Retention Policy configuration change listener.
   */
  void removeFileCountChangeListener(ConfigurationChangeListener<FileCountLogRetentionPolicyCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the File Count Log Retention Policy implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "number-of-files" property.
   * <p>
   * Specifies the number of archived log files to retain before the
   * oldest ones are cleaned.
   *
   * @return Returns the value of the "number-of-files" property.
   */
  int getNumberOfFiles();

}
