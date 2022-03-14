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



import java.net.InetAddress;
import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.ReplicationServerCfg;



/**
 * A client-side interface for reading and modifying Replication
 * Server settings.
 * <p>
 * Replication Servers publish updates to Directory Servers within a
 * Replication Domain.
 */
public interface ReplicationServerCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Replication Server.
   *
   * @return Returns the configuration definition associated with this Replication Server.
   */
  ManagedObjectDefinition<? extends ReplicationServerCfgClient, ? extends ReplicationServerCfg> definition();



  /**
   * Gets the "assured-timeout" property.
   * <p>
   * The timeout value when waiting for assured mode acknowledgments.
   * <p>
   * Defines the number of milliseconds that the replication server
   * will wait for assured acknowledgments (in either Safe Data or Safe
   * Read assured sub modes) before forgetting them and answer to the
   * entity that sent an update and is waiting for acknowledgment.
   *
   * @return Returns the value of the "assured-timeout" property.
   */
  long getAssuredTimeout();



  /**
   * Sets the "assured-timeout" property.
   * <p>
   * The timeout value when waiting for assured mode acknowledgments.
   * <p>
   * Defines the number of milliseconds that the replication server
   * will wait for assured acknowledgments (in either Safe Data or Safe
   * Read assured sub modes) before forgetting them and answer to the
   * entity that sent an update and is waiting for acknowledgment.
   *
   * @param value The value of the "assured-timeout" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAssuredTimeout(Long value) throws PropertyException;



  /**
   * Gets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the value of the "cipher-key-length" property.
   */
  int getCipherKeyLength();



  /**
   * Sets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @param value The value of the "cipher-key-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherKeyLength(Integer value) throws PropertyException;



  /**
   * Gets the "cipher-transformation" property.
   * <p>
   * Specifies the cipher for the directory server. The syntax is
   * "algorithm/mode/padding".
   * <p>
   * The full transformation is required: specifying only an algorithm
   * and allowing the cipher provider to supply the default mode and
   * padding is not supported, because there is no guarantee these
   * default values are the same among different implementations. Some
   * cipher algorithms, including RC4 and ARCFOUR, do not have a mode
   * or padding, and hence must be specified using NONE for the mode
   * field and NoPadding for the padding field. For example,
   * RC4/NONE/NoPadding.
   *
   * @return Returns the value of the "cipher-transformation" property.
   */
  String getCipherTransformation();



  /**
   * Sets the "cipher-transformation" property.
   * <p>
   * Specifies the cipher for the directory server. The syntax is
   * "algorithm/mode/padding".
   * <p>
   * The full transformation is required: specifying only an algorithm
   * and allowing the cipher provider to supply the default mode and
   * padding is not supported, because there is no guarantee these
   * default values are the same among different implementations. Some
   * cipher algorithms, including RC4 and ARCFOUR, do not have a mode
   * or padding, and hence must be specified using NONE for the mode
   * field and NoPadding for the padding field. For example,
   * RC4/NONE/NoPadding.
   *
   * @param value The value of the "cipher-transformation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherTransformation(String value) throws PropertyException;



  /**
   * Gets the "compute-change-number" property.
   * <p>
   * Whether the replication server will compute change numbers.
   * <p>
   * This boolean tells the replication server to compute change
   * numbers for each replicated change by maintaining a change number
   * index database. Changenumbers are computed according to
   * http://tools.ietf.org/html/draft-good-ldap-changelog-04. Note this
   * functionality has an impact on CPU, disk accesses and storage. If
   * changenumbers are not required, it is advisable to set this value
   * to false.
   *
   * @return Returns the value of the "compute-change-number" property.
   */
  boolean isComputeChangeNumber();



  /**
   * Sets the "compute-change-number" property.
   * <p>
   * Whether the replication server will compute change numbers.
   * <p>
   * This boolean tells the replication server to compute change
   * numbers for each replicated change by maintaining a change number
   * index database. Changenumbers are computed according to
   * http://tools.ietf.org/html/draft-good-ldap-changelog-04. Note this
   * functionality has an impact on CPU, disk accesses and storage. If
   * changenumbers are not required, it is advisable to set this value
   * to false.
   *
   * @param value The value of the "compute-change-number" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setComputeChangeNumber(Boolean value) throws PropertyException;



  /**
   * Gets the "confidentiality-enabled" property.
   * <p>
   * Indicates whether the replication change-log should make records
   * readable only by Directory Server. Throughput and disk space are
   * affected by the more expensive operations taking place.
   * <p>
   * Confidentiality is achieved by encrypting records on all domains
   * managed by this replication server. Encrypting the records
   * prevents unauthorized parties from accessing contents of LDAP
   * operations. For complete protection, consider enabling secure
   * communications between servers. Change number indexing is not
   * affected by the setting.
   *
   * @return Returns the value of the "confidentiality-enabled" property.
   */
  boolean isConfidentialityEnabled();



  /**
   * Sets the "confidentiality-enabled" property.
   * <p>
   * Indicates whether the replication change-log should make records
   * readable only by Directory Server. Throughput and disk space are
   * affected by the more expensive operations taking place.
   * <p>
   * Confidentiality is achieved by encrypting records on all domains
   * managed by this replication server. Encrypting the records
   * prevents unauthorized parties from accessing contents of LDAP
   * operations. For complete protection, consider enabling secure
   * communications between servers. Change number indexing is not
   * affected by the setting.
   *
   * @param value The value of the "confidentiality-enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConfidentialityEnabled(Boolean value) throws PropertyException;



  /**
   * Gets the "degraded-status-threshold" property.
   * <p>
   * The number of pending changes as threshold value for putting a
   * directory server in degraded status.
   * <p>
   * This value represents a number of pending changes a replication
   * server has in queue for sending to a directory server. Once this
   * value is crossed, the matching directory server goes in degraded
   * status. When number of pending changes goes back under this value,
   * the directory server is put back in normal status. 0 means status
   * analyzer is disabled and directory servers are never put in
   * degraded status.
   *
   * @return Returns the value of the "degraded-status-threshold" property.
   */
  int getDegradedStatusThreshold();



  /**
   * Sets the "degraded-status-threshold" property.
   * <p>
   * The number of pending changes as threshold value for putting a
   * directory server in degraded status.
   * <p>
   * This value represents a number of pending changes a replication
   * server has in queue for sending to a directory server. Once this
   * value is crossed, the matching directory server goes in degraded
   * status. When number of pending changes goes back under this value,
   * the directory server is put back in normal status. 0 means status
   * analyzer is disabled and directory servers are never put in
   * degraded status.
   *
   * @param value The value of the "degraded-status-threshold" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDegradedStatusThreshold(Integer value) throws PropertyException;



  /**
   * Gets the "group-id" property.
   * <p>
   * The group id for the replication server.
   * <p>
   * This value defines the group id of the replication server. The
   * replication system of a LDAP server uses the group id of the
   * replicated domain and tries to connect, if possible, to a
   * replication with the same group id.
   *
   * @return Returns the value of the "group-id" property.
   */
  int getGroupId();



  /**
   * Sets the "group-id" property.
   * <p>
   * The group id for the replication server.
   * <p>
   * This value defines the group id of the replication server. The
   * replication system of a LDAP server uses the group id of the
   * replicated domain and tries to connect, if possible, to a
   * replication with the same group id.
   *
   * @param value The value of the "group-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setGroupId(Integer value) throws PropertyException;



  /**
   * Gets the "monitoring-period" property.
   * <p>
   * The period between sending of monitoring messages.
   * <p>
   * Defines the duration that the replication server will wait before
   * sending new monitoring messages to its peers (replication servers
   * and directory servers). Larger values increase the length of time
   * it takes for a directory server to detect and switch to a more
   * suitable replication server, whereas smaller values increase the
   * amount of background network traffic.
   *
   * @return Returns the value of the "monitoring-period" property.
   */
  long getMonitoringPeriod();



  /**
   * Sets the "monitoring-period" property.
   * <p>
   * The period between sending of monitoring messages.
   * <p>
   * Defines the duration that the replication server will wait before
   * sending new monitoring messages to its peers (replication servers
   * and directory servers). Larger values increase the length of time
   * it takes for a directory server to detect and switch to a more
   * suitable replication server, whereas smaller values increase the
   * amount of background network traffic.
   *
   * @param value The value of the "monitoring-period" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMonitoringPeriod(Long value) throws PropertyException;



  /**
   * Gets the "queue-size" property.
   * <p>
   * Specifies the number of changes that are kept in memory for each
   * directory server in the Replication Domain.
   *
   * @return Returns the value of the "queue-size" property.
   */
  int getQueueSize();



  /**
   * Sets the "queue-size" property.
   * <p>
   * Specifies the number of changes that are kept in memory for each
   * directory server in the Replication Domain.
   *
   * @param value The value of the "queue-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setQueueSize(Integer value) throws PropertyException;



  /**
   * Gets the "replication-db-directory" property.
   * <p>
   * The path where the Replication Server stores all persistent
   * information.
   *
   * @return Returns the value of the "replication-db-directory" property.
   */
  String getReplicationDBDirectory();



  /**
   * Sets the "replication-db-directory" property.
   * <p>
   * The path where the Replication Server stores all persistent
   * information.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Replication Server.
   *
   * @param value The value of the "replication-db-directory" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Replication Server is not being initialized.
   */
  void setReplicationDBDirectory(String value) throws PropertyException, PropertyException;



  /**
   * Gets the "replication-port" property.
   * <p>
   * The port on which this Replication Server waits for connections
   * from other Replication Servers or Directory Servers.
   *
   * @return Returns the value of the "replication-port" property.
   */
  Integer getReplicationPort();



  /**
   * Sets the "replication-port" property.
   * <p>
   * The port on which this Replication Server waits for connections
   * from other Replication Servers or Directory Servers.
   *
   * @param value The value of the "replication-port" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setReplicationPort(int value) throws PropertyException;



  /**
   * Gets the "replication-purge-delay" property.
   * <p>
   * The time (in seconds) after which the Replication Server erases
   * all persistent information.
   *
   * @return Returns the value of the "replication-purge-delay" property.
   */
  long getReplicationPurgeDelay();



  /**
   * Sets the "replication-purge-delay" property.
   * <p>
   * The time (in seconds) after which the Replication Server erases
   * all persistent information.
   *
   * @param value The value of the "replication-purge-delay" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setReplicationPurgeDelay(Long value) throws PropertyException;



  /**
   * Gets the "replication-server" property.
   * <p>
   * Specifies the addresses of other Replication Servers to which
   * this Replication Server tries to connect at startup time.
   * <p>
   * Addresses must be specified using the syntax: "hostname:port". If
   * IPv6 addresses are used as the hostname, they must be specified
   * using the syntax "[IPv6Address]:port".
   *
   * @return Returns the values of the "replication-server" property.
   */
  SortedSet<String> getReplicationServer();



  /**
   * Sets the "replication-server" property.
   * <p>
   * Specifies the addresses of other Replication Servers to which
   * this Replication Server tries to connect at startup time.
   * <p>
   * Addresses must be specified using the syntax: "hostname:port". If
   * IPv6 addresses are used as the hostname, they must be specified
   * using the syntax "[IPv6Address]:port".
   *
   * @param values The values of the "replication-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setReplicationServer(Collection<String> values) throws PropertyException;



  /**
   * Gets the "replication-server-id" property.
   * <p>
   * Specifies a unique identifier for the Replication Server.
   * <p>
   * Each Replication Server must have a different server ID.
   *
   * @return Returns the value of the "replication-server-id" property.
   */
  Integer getReplicationServerId();



  /**
   * Sets the "replication-server-id" property.
   * <p>
   * Specifies a unique identifier for the Replication Server.
   * <p>
   * Each Replication Server must have a different server ID.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Replication Server.
   *
   * @param value The value of the "replication-server-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Replication Server is not being initialized.
   */
  void setReplicationServerId(int value) throws PropertyException, PropertyException;



  /**
   * Gets the "source-address" property.
   * <p>
   * If specified, the server will bind to the address before
   * connecting to the remote server.
   * <p>
   * The address must be one assigned to an existing network
   * interface.
   *
   * @return Returns the value of the "source-address" property.
   */
  InetAddress getSourceAddress();



  /**
   * Sets the "source-address" property.
   * <p>
   * If specified, the server will bind to the address before
   * connecting to the remote server.
   * <p>
   * The address must be one assigned to an existing network
   * interface.
   *
   * @param value The value of the "source-address" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSourceAddress(InetAddress value) throws PropertyException;



  /**
   * Gets the "weight" property.
   * <p>
   * The weight of the replication server.
   * <p>
   * The weight affected to the replication server. Each replication
   * server of the topology has a weight. When combined together, the
   * weights of the replication servers of a same group can be
   * translated to a percentage that determines the quantity of
   * directory servers of the topology that should be connected to a
   * replication server. For instance imagine a topology with 3
   * replication servers (with the same group id) with the following
   * weights: RS1=1, RS2=1, RS3=2. This means that RS1 should have 25%
   * of the directory servers connected in the topology, RS2 25%, and
   * RS3 50%. This may be useful if the replication servers of the
   * topology have a different power and one wants to spread the load
   * between the replication servers according to their power.
   *
   * @return Returns the value of the "weight" property.
   */
  int getWeight();



  /**
   * Sets the "weight" property.
   * <p>
   * The weight of the replication server.
   * <p>
   * The weight affected to the replication server. Each replication
   * server of the topology has a weight. When combined together, the
   * weights of the replication servers of a same group can be
   * translated to a percentage that determines the quantity of
   * directory servers of the topology that should be connected to a
   * replication server. For instance imagine a topology with 3
   * replication servers (with the same group id) with the following
   * weights: RS1=1, RS2=1, RS3=2. This means that RS1 should have 25%
   * of the directory servers connected in the topology, RS2 25%, and
   * RS3 50%. This may be useful if the replication servers of the
   * topology have a different power and one wants to spread the load
   * between the replication servers according to their power.
   *
   * @param value The value of the "weight" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWeight(Integer value) throws PropertyException;



  /**
   * Gets the "window-size" property.
   * <p>
   * Specifies the window size that the Replication Server uses when
   * communicating with other Replication Servers.
   * <p>
   * This option may be deprecated and removed in future releases.
   *
   * @return Returns the value of the "window-size" property.
   */
  int getWindowSize();



  /**
   * Sets the "window-size" property.
   * <p>
   * Specifies the window size that the Replication Server uses when
   * communicating with other Replication Servers.
   * <p>
   * This option may be deprecated and removed in future releases.
   *
   * @param value The value of the "window-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWindowSize(Integer value) throws PropertyException;

}
