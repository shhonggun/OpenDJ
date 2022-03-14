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
import org.forgerock.opendj.server.config.server.StaticServiceDiscoveryMechanismCfg;



/**
 * A client-side interface for reading and modifying Static Service
 * Discovery Mechanism settings.
 * <p>
 * A Static Service Discovery Mechanism returns a fixed list of LDAP
 * directory servers.
 */
public interface StaticServiceDiscoveryMechanismCfgClient extends ServiceDiscoveryMechanismCfgClient {

  /**
   * Get the configuration definition associated with this Static Service Discovery Mechanism.
   *
   * @return Returns the configuration definition associated with this Static Service Discovery Mechanism.
   */
  ManagedObjectDefinition<? extends StaticServiceDiscoveryMechanismCfgClient, ? extends StaticServiceDiscoveryMechanismCfg> definition();



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
   * Sets the "discovery-interval" property.
   * <p>
   * Interval between two server configuration discovery executions.
   * <p>
   * Specifies how frequently to read the configuration of the servers
   * in order to discover their new information.
   *
   * @param value The value of the "discovery-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDiscoveryInterval(Long value) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Static Service Discovery Mechanism implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "primary-server" property.
   * <p>
   * Specifies a list of servers that will be used in preference to
   * secondary servers when available.
   *
   * @return Returns the values of the "primary-server" property.
   */
  SortedSet<String> getPrimaryServer();



  /**
   * Sets the "primary-server" property.
   * <p>
   * Specifies a list of servers that will be used in preference to
   * secondary servers when available.
   *
   * @param values The values of the "primary-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPrimaryServer(Collection<String> values) throws PropertyException;



  /**
   * Gets the "secondary-server" property.
   * <p>
   * Specifies a list of servers that will be used in place of primary
   * servers when all primary servers are unavailable.
   *
   * @return Returns the values of the "secondary-server" property.
   */
  SortedSet<String> getSecondaryServer();



  /**
   * Sets the "secondary-server" property.
   * <p>
   * Specifies a list of servers that will be used in place of primary
   * servers when all primary servers are unavailable.
   *
   * @param values The values of the "secondary-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSecondaryServer(Collection<String> values) throws PropertyException;

}
