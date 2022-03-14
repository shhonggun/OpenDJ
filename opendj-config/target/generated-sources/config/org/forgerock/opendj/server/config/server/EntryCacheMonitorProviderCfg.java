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
 * A server-side interface for querying Entry Cache Monitor Provider
 * settings.
 * <p>
 * The Entry Cache Monitor Provider exposes monitor information about
 * the state of OpenDJ directory server entry caches.
 */
public interface EntryCacheMonitorProviderCfg extends MonitorProviderCfg {

  /**
   * Gets the configuration class associated with this Entry Cache Monitor Provider.
   *
   * @return Returns the configuration class associated with this Entry Cache Monitor Provider.
   */
  Class<? extends EntryCacheMonitorProviderCfg> configurationClass();



  /**
   * Register to be notified when this Entry Cache Monitor Provider is changed.
   *
   * @param listener
   *          The Entry Cache Monitor Provider configuration change listener.
   */
  void addEntryCacheChangeListener(ConfigurationChangeListener<EntryCacheMonitorProviderCfg> listener);



  /**
   * Deregister an existing Entry Cache Monitor Provider configuration change listener.
   *
   * @param listener
   *          The Entry Cache Monitor Provider configuration change listener.
   */
  void removeEntryCacheChangeListener(ConfigurationChangeListener<EntryCacheMonitorProviderCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Entry Cache Monitor Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
