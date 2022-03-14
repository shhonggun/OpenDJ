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
 * A server-side interface for querying System Info Monitor Provider
 * settings.
 * <p>
 * The System Info Monitor Provider can be used to publish information
 * about the system and virtual machine on which the directory server
 * is running.
 */
public interface SystemInfoMonitorProviderCfg extends MonitorProviderCfg {

  /**
   * Gets the configuration class associated with this System Info Monitor Provider.
   *
   * @return Returns the configuration class associated with this System Info Monitor Provider.
   */
  Class<? extends SystemInfoMonitorProviderCfg> configurationClass();



  /**
   * Register to be notified when this System Info Monitor Provider is changed.
   *
   * @param listener
   *          The System Info Monitor Provider configuration change listener.
   */
  void addSystemInfoChangeListener(ConfigurationChangeListener<SystemInfoMonitorProviderCfg> listener);



  /**
   * Deregister an existing System Info Monitor Provider configuration change listener.
   *
   * @param listener
   *          The System Info Monitor Provider configuration change listener.
   */
  void removeSystemInfoChangeListener(ConfigurationChangeListener<SystemInfoMonitorProviderCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the System Info Monitor Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
