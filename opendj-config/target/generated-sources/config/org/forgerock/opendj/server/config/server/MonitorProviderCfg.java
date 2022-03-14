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
 * A server-side interface for querying Monitor Provider settings.
 * <p>
 * Monitor Providers can be used to provide information about the
 * state of the server or one of its components.
 */
public interface MonitorProviderCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Monitor Provider.
   *
   * @return Returns the configuration class associated with this Monitor Provider.
   */
  Class<? extends MonitorProviderCfg> configurationClass();



  /**
   * Register to be notified when this Monitor Provider is changed.
   *
   * @param listener
   *          The Monitor Provider configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<MonitorProviderCfg> listener);



  /**
   * Deregister an existing Monitor Provider configuration change listener.
   *
   * @param listener
   *          The Monitor Provider configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<MonitorProviderCfg> listener);



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Monitor Provider is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Monitor Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
