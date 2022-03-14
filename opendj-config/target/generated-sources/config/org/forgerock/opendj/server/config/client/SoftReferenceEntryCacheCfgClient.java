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
import org.forgerock.opendj.server.config.server.SoftReferenceEntryCacheCfg;



/**
 * A client-side interface for reading and modifying Soft Reference
 * Entry Cache settings.
 * <p>
 * The Soft Reference Entry Cache is a directory server entry cache
 * implementation that uses soft references to manage objects to allow
 * them to be freed if the JVM is running low on memory.
 */
public interface SoftReferenceEntryCacheCfgClient extends EntryCacheCfgClient {

  /**
   * Get the configuration definition associated with this Soft Reference Entry Cache.
   *
   * @return Returns the configuration definition associated with this Soft Reference Entry Cache.
   */
  ManagedObjectDefinition<? extends SoftReferenceEntryCacheCfgClient, ? extends SoftReferenceEntryCacheCfg> definition();



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
   * provides the Soft Reference Entry Cache implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Soft Reference Entry Cache implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "lock-timeout" property.
   * <p>
   * Specifies the length of time in milliseconds to wait while
   * attempting to acquire a read or write lock.
   *
   * @return Returns the value of the "lock-timeout" property.
   */
  long getLockTimeout();



  /**
   * Sets the "lock-timeout" property.
   * <p>
   * Specifies the length of time in milliseconds to wait while
   * attempting to acquire a read or write lock.
   *
   * @param value The value of the "lock-timeout" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLockTimeout(Long value) throws PropertyException;

}
