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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.server.ReplicationServiceDiscoveryMechanismCfg;



/**
 * A client-side interface for reading and modifying Replication
 * Service Discovery Mechanism settings.
 * <p>
 * A Replication Service Discovery Mechanism returns the set of
 * directory servers participating in a replication topology.
 */
public interface ReplicationServiceDiscoveryMechanismCfgClient extends ServiceDiscoveryMechanismCfgClient {

  /**
   * Get the configuration definition associated with this Replication Service Discovery Mechanism.
   *
   * @return Returns the configuration definition associated with this Replication Service Discovery Mechanism.
   */
  ManagedObjectDefinition<? extends ReplicationServiceDiscoveryMechanismCfgClient, ? extends ReplicationServiceDiscoveryMechanismCfg> definition();



  /**
   * Gets the "bind-dn" property.
   * <p>
   * The bind DN for periodically reading replication server
   * configurations
   * <p>
   * The bind DN must be present on all replication servers and
   * directory servers, it must be able to read the server
   * configuration.
   *
   * @return Returns the value of the "bind-dn" property.
   */
  DN getBindDN();



  /**
   * Sets the "bind-dn" property.
   * <p>
   * The bind DN for periodically reading replication server
   * configurations
   * <p>
   * The bind DN must be present on all replication servers and
   * directory servers, it must be able to read the server
   * configuration.
   *
   * @param value The value of the "bind-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBindDN(DN value) throws PropertyException;



  /**
   * Gets the "bind-password" property.
   * <p>
   * The bind password for periodically reading replication server
   * configurations
   * <p>
   * The bind password must be the same on all replication and
   * directory servers
   *
   * @return Returns the value of the "bind-password" property.
   */
  String getBindPassword();



  /**
   * Sets the "bind-password" property.
   * <p>
   * The bind password for periodically reading replication server
   * configurations
   * <p>
   * The bind password must be the same on all replication and
   * directory servers
   *
   * @param value The value of the "bind-password" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBindPassword(String value) throws PropertyException;



  /**
   * Gets the "discovery-interval" property.
   * <p>
   * Interval between two replication server configuration discovery
   * queries.
   * <p>
   * Specifies how frequently to query a replication server
   * configuration in order to discover information about available
   * directory server replicas.
   *
   * @return Returns the value of the "discovery-interval" property.
   */
  long getDiscoveryInterval();



  /**
   * Sets the "discovery-interval" property.
   * <p>
   * Interval between two replication server configuration discovery
   * queries.
   * <p>
   * Specifies how frequently to query a replication server
   * configuration in order to discover information about available
   * directory server replicas.
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
   * provides the Replication Service Discovery Mechanism
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Replication Service Discovery Mechanism
   * implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "primary-group-id" property.
   * <p>
   * Replication domain group ID of preferred directory server
   * replicas.
   * <p>
   * Directory server replicas with this replication domain group ID
   * will be preferred over other directory server replicas. Secondary
   * server replicas will only be used when all primary server replicas
   * become unavailable.
   *
   * @return Returns the value of the "primary-group-id" property.
   */
  Integer getPrimaryGroupId();



  /**
   * Sets the "primary-group-id" property.
   * <p>
   * Replication domain group ID of preferred directory server
   * replicas.
   * <p>
   * Directory server replicas with this replication domain group ID
   * will be preferred over other directory server replicas. Secondary
   * server replicas will only be used when all primary server replicas
   * become unavailable.
   *
   * @param value The value of the "primary-group-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPrimaryGroupId(Integer value) throws PropertyException;



  /**
   * Gets the "replication-server" property.
   * <p>
   * Specifies the list of replication servers to contact periodically
   * when discovering server replicas.
   *
   * @return Returns the values of the "replication-server" property.
   */
  SortedSet<String> getReplicationServer();



  /**
   * Sets the "replication-server" property.
   * <p>
   * Specifies the list of replication servers to contact periodically
   * when discovering server replicas.
   *
   * @param values The values of the "replication-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setReplicationServer(Collection<String> values) throws PropertyException;

}
