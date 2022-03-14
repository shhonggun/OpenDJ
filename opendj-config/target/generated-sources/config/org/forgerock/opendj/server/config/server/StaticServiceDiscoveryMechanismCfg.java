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
 * A server-side interface for querying Static Service Discovery
 * Mechanism settings.
 * <p>
 * A Static Service Discovery Mechanism returns a fixed list of LDAP
 * directory servers.
 */
public interface StaticServiceDiscoveryMechanismCfg extends ServiceDiscoveryMechanismCfg {

  /**
   * Gets the configuration class associated with this Static Service Discovery Mechanism.
   *
   * @return Returns the configuration class associated with this Static Service Discovery Mechanism.
   */
  Class<? extends StaticServiceDiscoveryMechanismCfg> configurationClass();



  /**
   * Register to be notified when this Static Service Discovery Mechanism is changed.
   *
   * @param listener
   *          The Static Service Discovery Mechanism configuration change listener.
   */
  void addStaticChangeListener(ConfigurationChangeListener<StaticServiceDiscoveryMechanismCfg> listener);



  /**
   * Deregister an existing Static Service Discovery Mechanism configuration change listener.
   *
   * @param listener
   *          The Static Service Discovery Mechanism configuration change listener.
   */
  void removeStaticChangeListener(ConfigurationChangeListener<StaticServiceDiscoveryMechanismCfg> listener);



  /**
   * Gets the "discovery-interval" property.
   * <p>
   * Interval between two server configuration discovery executions.
   * <p>
   * Specifies how frequently to read the configuration of the servers
   * in order to discover their new information.
   *
   * @return Returns the value of the "discovery-interval" property.
   */
  long getDiscoveryInterval();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Static Service Discovery Mechanism implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "primary-server" property.
   * <p>
   * Specifies a list of servers that will be used in preference to
   * secondary servers when available.
   *
   * @return Returns an unmodifiable set containing the values of the "primary-server" property.
   */
  SortedSet<String> getPrimaryServer();



  /**
   * Gets the "secondary-server" property.
   * <p>
   * Specifies a list of servers that will be used in place of primary
   * servers when all primary servers are unavailable.
   *
   * @return Returns an unmodifiable set containing the values of the "secondary-server" property.
   */
  SortedSet<String> getSecondaryServer();

}
