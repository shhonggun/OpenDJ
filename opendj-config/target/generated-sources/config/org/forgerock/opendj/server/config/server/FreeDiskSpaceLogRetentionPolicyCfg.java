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
 * A server-side interface for querying Free Disk Space Log Retention
 * Policy settings.
 * <p>
 * Retention policy based on the free disk space available.
 */
public interface FreeDiskSpaceLogRetentionPolicyCfg extends LogRetentionPolicyCfg {

  /**
   * Gets the configuration class associated with this Free Disk Space Log Retention Policy.
   *
   * @return Returns the configuration class associated with this Free Disk Space Log Retention Policy.
   */
  Class<? extends FreeDiskSpaceLogRetentionPolicyCfg> configurationClass();



  /**
   * Register to be notified when this Free Disk Space Log Retention Policy is changed.
   *
   * @param listener
   *          The Free Disk Space Log Retention Policy configuration change listener.
   */
  void addFreeDiskSpaceChangeListener(ConfigurationChangeListener<FreeDiskSpaceLogRetentionPolicyCfg> listener);



  /**
   * Deregister an existing Free Disk Space Log Retention Policy configuration change listener.
   *
   * @param listener
   *          The Free Disk Space Log Retention Policy configuration change listener.
   */
  void removeFreeDiskSpaceChangeListener(ConfigurationChangeListener<FreeDiskSpaceLogRetentionPolicyCfg> listener);



  /**
   * Gets the "free-disk-space" property.
   * <p>
   * Specifies the minimum amount of free disk space that should be
   * available on the file system on which the archived log files are
   * stored.
   *
   * @return Returns the value of the "free-disk-space" property.
   */
  long getFreeDiskSpace();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Free Disk Space Log Retention Policy implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
