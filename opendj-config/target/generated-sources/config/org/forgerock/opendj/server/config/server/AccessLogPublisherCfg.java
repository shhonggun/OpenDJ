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



import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.server.config.meta.AccessLogPublisherCfgDefn.FilteringPolicy;



/**
 * A server-side interface for querying Access Log Publisher settings.
 * <p>
 * Access Log Publishers are responsible for distributing access log
 * messages from the access logger to a destination.
 */
public interface AccessLogPublisherCfg extends LogPublisherCfg {

  /**
   * Gets the configuration class associated with this Access Log Publisher.
   *
   * @return Returns the configuration class associated with this Access Log Publisher.
   */
  Class<? extends AccessLogPublisherCfg> configurationClass();



  /**
   * Register to be notified when this Access Log Publisher is changed.
   *
   * @param listener
   *          The Access Log Publisher configuration change listener.
   */
  void addAccessChangeListener(ConfigurationChangeListener<AccessLogPublisherCfg> listener);



  /**
   * Deregister an existing Access Log Publisher configuration change listener.
   *
   * @param listener
   *          The Access Log Publisher configuration change listener.
   */
  void removeAccessChangeListener(ConfigurationChangeListener<AccessLogPublisherCfg> listener);



  /**
   * Gets the "filtering-policy" property.
   * <p>
   * Specifies how filtering criteria should be applied to log
   * records.
   *
   * @return Returns the value of the "filtering-policy" property.
   */
  FilteringPolicy getFilteringPolicy();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Access Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "suppress-internal-operations" property.
   * <p>
   * Indicates whether internal operations (for example, operations
   * that are initiated by plugins) should be logged along with the
   * operations that are requested by users.
   *
   * @return Returns the value of the "suppress-internal-operations" property.
   */
  boolean isSuppressInternalOperations();



  /**
   * Gets the "suppress-synchronization-operations" property.
   * <p>
   * Indicates whether access messages that are generated by
   * synchronization operations should be suppressed.
   *
   * @return Returns the value of the "suppress-synchronization-operations" property.
   */
  boolean isSuppressSynchronizationOperations();



  /**
   * Lists the Access Log Filtering Criteria.
   *
   * @return Returns an array containing the names of the
   *         Access Log Filtering Criteria.
   */
  String[] listAccessLogFilteringCriteria();



  /**
   * Gets the named Access Log Filtering Criteria.
   *
   * @param name
   *          The name of the Access Log Filtering Criteria to retrieve.
   * @return Returns the named Access Log Filtering Criteria.
   * @throws ConfigException
   *           If the Access Log Filtering Criteria could not be found or it
   *           could not be successfully decoded.
   */
  AccessLogFilteringCriteriaCfg getAccessLogFilteringCriteria(String name) throws ConfigException;



  /**
   * Registers to be notified when new Access Log Filtering Criteria are added.
   *
   * @param listener
   *          The Access Log Filtering Criteria configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addAccessLogFilteringCriteriaAddListener(ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Access Log Filtering Criteria configuration add listener.
   *
   * @param listener
   *          The Access Log Filtering Criteria configuration add listener.
   */
  void removeAccessLogFilteringCriteriaAddListener(ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener);



  /**
   * Registers to be notified when existing Access Log Filtering Criteria are deleted.
   *
   * @param listener
   *          The Access Log Filtering Criteria configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addAccessLogFilteringCriteriaDeleteListener(ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Access Log Filtering Criteria configuration delete listener.
   *
   * @param listener
   *          The Access Log Filtering Criteria configuration delete listener.
   */
  void removeAccessLogFilteringCriteriaDeleteListener(ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener);

}
