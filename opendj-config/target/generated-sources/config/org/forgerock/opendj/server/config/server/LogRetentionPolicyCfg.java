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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Log Retention Policy settings.
 * <p>
 * Log Retention Policies are used to specify when log files should be
 * cleaned.
 */
public interface LogRetentionPolicyCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Log Retention Policy.
   *
   * @return Returns the configuration class associated with this Log Retention Policy.
   */
  Class<? extends LogRetentionPolicyCfg> configurationClass();



  /**
   * Register to be notified when this Log Retention Policy is changed.
   *
   * @param listener
   *          The Log Retention Policy configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<LogRetentionPolicyCfg> listener);



  /**
   * Deregister an existing Log Retention Policy configuration change listener.
   *
   * @param listener
   *          The Log Retention Policy configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<LogRetentionPolicyCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Log Retention Policy implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
