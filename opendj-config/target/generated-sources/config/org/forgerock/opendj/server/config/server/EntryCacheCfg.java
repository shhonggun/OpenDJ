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
 * A server-side interface for querying Entry Cache settings.
 * <p>
 * Entry Caches are responsible for caching entries which are likely
 * to be accessed by client applications in order to improve OpenDJ
 * directory server performance.
 */
public interface EntryCacheCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Entry Cache.
   *
   * @return Returns the configuration class associated with this Entry Cache.
   */
  Class<? extends EntryCacheCfg> configurationClass();



  /**
   * Register to be notified when this Entry Cache is changed.
   *
   * @param listener
   *          The Entry Cache configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<EntryCacheCfg> listener);



  /**
   * Deregister an existing Entry Cache configuration change listener.
   *
   * @param listener
   *          The Entry Cache configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<EntryCacheCfg> listener);



  /**
   * Gets the "cache-level" property.
   * <p>
   * Specifies the cache level in the cache order if more than one
   * instance of the cache is configured.
   *
   * @return Returns the value of the "cache-level" property.
   */
  int getCacheLevel();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Entry Cache is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Entry Cache implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}