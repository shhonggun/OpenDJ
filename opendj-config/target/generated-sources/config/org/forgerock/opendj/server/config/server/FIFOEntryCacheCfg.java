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
 * A server-side interface for querying FIFO Entry Cache settings.
 * <p>
 * FIFO Entry Caches use a FIFO queue to keep track of the cached
 * entries.
 */
public interface FIFOEntryCacheCfg extends EntryCacheCfg {

  /**
   * Gets the configuration class associated with this FIFO Entry Cache.
   *
   * @return Returns the configuration class associated with this FIFO Entry Cache.
   */
  Class<? extends FIFOEntryCacheCfg> configurationClass();



  /**
   * Register to be notified when this FIFO Entry Cache is changed.
   *
   * @param listener
   *          The FIFO Entry Cache configuration change listener.
   */
  void addFIFOChangeListener(ConfigurationChangeListener<FIFOEntryCacheCfg> listener);



  /**
   * Deregister an existing FIFO Entry Cache configuration change listener.
   *
   * @param listener
   *          The FIFO Entry Cache configuration change listener.
   */
  void removeFIFOChangeListener(ConfigurationChangeListener<FIFOEntryCacheCfg> listener);



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
   * provides the FIFO Entry Cache implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "lock-timeout" property.
   * <p>
   * Specifies the length of time to wait while attempting to acquire
   * a read or write lock.
   *
   * @return Returns the value of the "lock-timeout" property.
   */
  long getLockTimeout();



  /**
   * Gets the "max-entries" property.
   * <p>
   * Specifies the maximum number of entries that we will allow in the
   * cache.
   *
   * @return Returns the value of the "max-entries" property.
   */
  int getMaxEntries();



  /**
   * Gets the "max-memory-percent" property.
   * <p>
   * Specifies the maximum percentage of JVM memory used by the server
   * before the entry caches stops caching and begins purging itself.
   * <p>
   * Very low settings such as 10 or 20 (percent) can prevent this
   * entry cache from having enough space to hold any of the entries to
   * cache, making it appear that the server is ignoring or skipping
   * the entry cache entirely.
   *
   * @return Returns the value of the "max-memory-percent" property.
   */
  int getMaxMemoryPercent();

}
