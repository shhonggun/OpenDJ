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



import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Soft Reference Entry Cache
 * settings.
 * <p>
 * The Soft Reference Entry Cache is a directory server entry cache
 * implementation that uses soft references to manage objects to allow
 * them to be freed if the JVM is running low on memory.
 */
public interface SoftReferenceEntryCacheCfg extends EntryCacheCfg {

  /**
   * Gets the configuration class associated with this Soft Reference Entry Cache.
   *
   * @return Returns the configuration class associated with this Soft Reference Entry Cache.
   */
  Class<? extends SoftReferenceEntryCacheCfg> configurationClass();



  /**
   * Register to be notified when this Soft Reference Entry Cache is changed.
   *
   * @param listener
   *          The Soft Reference Entry Cache configuration change listener.
   */
  void addSoftReferenceChangeListener(ConfigurationChangeListener<SoftReferenceEntryCacheCfg> listener);



  /**
   * Deregister an existing Soft Reference Entry Cache configuration change listener.
   *
   * @param listener
   *          The Soft Reference Entry Cache configuration change listener.
   */
  void removeSoftReferenceChangeListener(ConfigurationChangeListener<SoftReferenceEntryCacheCfg> listener);



  /**
   * Gets the "exclude-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * excluded from the cache.
   *
   * @return Returns an unmodifiable set containing the values of the "exclude-filter" property.
   */
  SortedSet<String> getExcludeFilter();



  /**
   * Gets the "include-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * included in the cache.
   *
   * @return Returns an unmodifiable set containing the values of the "include-filter" property.
   */
  SortedSet<String> getIncludeFilter();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Soft Reference Entry Cache implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "lock-timeout" property.
   * <p>
   * Specifies the length of time in milliseconds to wait while
   * attempting to acquire a read or write lock.
   *
   * @return Returns the value of the "lock-timeout" property.
   */
  long getLockTimeout();

}
