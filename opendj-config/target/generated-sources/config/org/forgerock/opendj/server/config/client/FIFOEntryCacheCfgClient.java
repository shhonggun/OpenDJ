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
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.FIFOEntryCacheCfg;



/**
 * A client-side interface for reading and modifying FIFO Entry Cache
 * settings.
 * <p>
 * FIFO Entry Caches use a FIFO queue to keep track of the cached
 * entries.
 */
public interface FIFOEntryCacheCfgClient extends EntryCacheCfgClient {

  /**
   * Get the configuration definition associated with this FIFO Entry Cache.
   *
   * @return Returns the configuration definition associated with this FIFO Entry Cache.
   */
  ManagedObjectDefinition<? extends FIFOEntryCacheCfgClient, ? extends FIFOEntryCacheCfg> definition();



  /**
   * Gets the "exclude-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * excluded from the cache.
   *
   * @return Returns the values of the "exclude-filter" property.
   */
  SortedSet<String> getExcludeFilter();



  /**
   * Sets the "exclude-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * excluded from the cache.
   *
   * @param values The values of the "exclude-filter" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setExcludeFilter(Collection<String> values) throws PropertyException;



  /**
   * Gets the "include-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * included in the cache.
   *
   * @return Returns the values of the "include-filter" property.
   */
  SortedSet<String> getIncludeFilter();



  /**
   * Sets the "include-filter" property.
   * <p>
   * The set of filters that define the entries that should be
   * included in the cache.
   *
   * @param values The values of the "include-filter" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setIncludeFilter(Collection<String> values) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the FIFO Entry Cache implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



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
   * Sets the "lock-timeout" property.
   * <p>
   * Specifies the length of time to wait while attempting to acquire
   * a read or write lock.
   *
   * @param value The value of the "lock-timeout" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLockTimeout(Long value) throws PropertyException;



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
   * Sets the "max-entries" property.
   * <p>
   * Specifies the maximum number of entries that we will allow in the
   * cache.
   *
   * @param value The value of the "max-entries" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxEntries(Integer value) throws PropertyException;



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



  /**
   * Sets the "max-memory-percent" property.
   * <p>
   * Specifies the maximum percentage of JVM memory used by the server
   * before the entry caches stops caching and begins purging itself.
   * <p>
   * Very low settings such as 10 or 20 (percent) can prevent this
   * entry cache from having enough space to hold any of the entries to
   * cache, making it appear that the server is ignoring or skipping
   * the entry cache entirely.
   *
   * @param value The value of the "max-memory-percent" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxMemoryPercent(Integer value) throws PropertyException;

}
