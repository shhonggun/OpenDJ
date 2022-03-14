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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.meta.ReplicationDomainCfgDefn.AssuredType;
import org.forgerock.opendj.server.config.meta.ReplicationDomainCfgDefn.IsolationPolicy;
import org.forgerock.opendj.server.config.server.ReplicationDomainCfg;



/**
 * A client-side interface for reading and modifying Replication
 * Domain settings.
 * <p>
 * A Replication Domain comprises of several Directory Servers sharing
 * the same synchronized set of data.
 */
public interface ReplicationDomainCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Replication Domain.
   *
   * @return Returns the configuration definition associated with this Replication Domain.
   */
  ManagedObjectDefinition<? extends ReplicationDomainCfgClient, ? extends ReplicationDomainCfg> definition();



  /**
   * Gets the "assured-sd-level" property.
   * <p>
   * The level of acknowledgment for Safe Data assured sub mode.
   * <p>
   * When assured replication is configured in Safe Data mode, this
   * value defines the number of replication servers (with the same
   * group ID of the local server) that should acknowledge the sent
   * update before the LDAP client call can return.
   *
   * @return Returns the value of the "assured-sd-level" property.
   */
  int getAssuredSdLevel();



  /**
   * Sets the "assured-sd-level" property.
   * <p>
   * The level of acknowledgment for Safe Data assured sub mode.
   * <p>
   * When assured replication is configured in Safe Data mode, this
   * value defines the number of replication servers (with the same
   * group ID of the local server) that should acknowledge the sent
   * update before the LDAP client call can return.
   *
   * @param value The value of the "assured-sd-level" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAssuredSdLevel(Integer value) throws PropertyException;



  /**
   * Gets the "assured-timeout" property.
   * <p>
   * The timeout value when waiting for assured replication
   * acknowledgments.
   * <p>
   * Defines the amount of milliseconds the server will wait for
   * assured acknowledgments (in either Safe Data or Safe Read assured
   * replication modes) before returning anyway the LDAP client call.
   *
   * @return Returns the value of the "assured-timeout" property.
   */
  long getAssuredTimeout();



  /**
   * Sets the "assured-timeout" property.
   * <p>
   * The timeout value when waiting for assured replication
   * acknowledgments.
   * <p>
   * Defines the amount of milliseconds the server will wait for
   * assured acknowledgments (in either Safe Data or Safe Read assured
   * replication modes) before returning anyway the LDAP client call.
   *
   * @param value The value of the "assured-timeout" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAssuredTimeout(Long value) throws PropertyException;



  /**
   * Gets the "assured-type" property.
   * <p>
   * Defines the assured replication mode of the replicated domain.
   * <p>
   * The assured replication can be disabled or enabled. When enabled,
   * two modes are available: Safe Data or Safe Read modes.
   *
   * @return Returns the value of the "assured-type" property.
   */
  AssuredType getAssuredType();



  /**
   * Sets the "assured-type" property.
   * <p>
   * Defines the assured replication mode of the replicated domain.
   * <p>
   * The assured replication can be disabled or enabled. When enabled,
   * two modes are available: Safe Data or Safe Read modes.
   *
   * @param value The value of the "assured-type" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAssuredType(AssuredType value) throws PropertyException;



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DN of the replicated data.
   *
   * @return Returns the value of the "base-dn" property.
   */
  DN getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * Specifies the base DN of the replicated data.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Replication Domain.
   *
   * @param value The value of the "base-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Replication Domain is not being initialized.
   */
  void setBaseDN(DN value) throws PropertyException, PropertyException;



  /**
   * Gets the "changetime-heartbeat-interval" property.
   * <p>
   * Specifies the heart-beat interval that the directory server will
   * use when sending its local change time to the Replication Server.
   * <p>
   * The directory server sends a regular heart-beat to the
   * Replication within the specified interval. The heart-beat
   * indicates the change time of the directory server to the
   * Replication Server.
   *
   * @return Returns the value of the "changetime-heartbeat-interval" property.
   */
  long getChangetimeHeartbeatInterval();



  /**
   * Sets the "changetime-heartbeat-interval" property.
   * <p>
   * Specifies the heart-beat interval that the directory server will
   * use when sending its local change time to the Replication Server.
   * <p>
   * The directory server sends a regular heart-beat to the
   * Replication within the specified interval. The heart-beat
   * indicates the change time of the directory server to the
   * Replication Server.
   *
   * @param value The value of the "changetime-heartbeat-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setChangetimeHeartbeatInterval(Long value) throws PropertyException;



  /**
   * Gets the "conflicts-historical-purge-delay" property.
   * <p>
   * This delay indicates the time (in minutes) the domain keeps the
   * historical information necessary to solve conflicts.When a change
   * stored in the historical part of the user entry has a date (from
   * its replication ChangeNumber) older than this delay, it is
   * candidate to be purged. The purge is applied on 2 events: modify
   * of the entry, dedicated purge task.
   *
   * @return Returns the value of the "conflicts-historical-purge-delay" property.
   */
  long getConflictsHistoricalPurgeDelay();



  /**
   * Sets the "conflicts-historical-purge-delay" property.
   * <p>
   * This delay indicates the time (in minutes) the domain keeps the
   * historical information necessary to solve conflicts.When a change
   * stored in the historical part of the user entry has a date (from
   * its replication ChangeNumber) older than this delay, it is
   * candidate to be purged. The purge is applied on 2 events: modify
   * of the entry, dedicated purge task.
   *
   * @param value The value of the "conflicts-historical-purge-delay" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConflictsHistoricalPurgeDelay(Long value) throws PropertyException;



  /**
   * Gets the "fractional-exclude" property.
   * <p>
   * Allows to exclude some attributes to replicate to this server.
   * <p>
   * If fractional-exclude configuration attribute is used, attributes
   * specified in this attribute will be ignored (not
   * added/modified/deleted) when an operation performed from another
   * directory server is being replayed in the local server. Note that
   * the usage of this configuration attribute is mutually exclusive
   * with the usage of the fractional-include attribute.
   *
   * @return Returns the values of the "fractional-exclude" property.
   */
  SortedSet<String> getFractionalExclude();



  /**
   * Sets the "fractional-exclude" property.
   * <p>
   * Allows to exclude some attributes to replicate to this server.
   * <p>
   * If fractional-exclude configuration attribute is used, attributes
   * specified in this attribute will be ignored (not
   * added/modified/deleted) when an operation performed from another
   * directory server is being replayed in the local server. Note that
   * the usage of this configuration attribute is mutually exclusive
   * with the usage of the fractional-include attribute.
   *
   * @param values The values of the "fractional-exclude" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setFractionalExclude(Collection<String> values) throws PropertyException;



  /**
   * Gets the "fractional-include" property.
   * <p>
   * Allows to include some attributes to replicate to this server.
   * <p>
   * If fractional-include configuration attribute is used, only
   * attributes specified in this attribute will be
   * added/modified/deleted when an operation performed from another
   * directory server is being replayed in the local server. Note that
   * the usage of this configuration attribute is mutually exclusive
   * with the usage of the fractional-exclude attribute.
   *
   * @return Returns the values of the "fractional-include" property.
   */
  SortedSet<String> getFractionalInclude();



  /**
   * Sets the "fractional-include" property.
   * <p>
   * Allows to include some attributes to replicate to this server.
   * <p>
   * If fractional-include configuration attribute is used, only
   * attributes specified in this attribute will be
   * added/modified/deleted when an operation performed from another
   * directory server is being replayed in the local server. Note that
   * the usage of this configuration attribute is mutually exclusive
   * with the usage of the fractional-exclude attribute.
   *
   * @param values The values of the "fractional-include" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setFractionalInclude(Collection<String> values) throws PropertyException;



  /**
   * Gets the "group-id" property.
   * <p>
   * The group ID associated with this replicated domain.
   * <p>
   * This value defines the group ID of the replicated domain. The
   * replication system will preferably connect and send updates to
   * replicate to a replication server with the same group ID as its
   * own one (the local server group ID).
   *
   * @return Returns the value of the "group-id" property.
   */
  int getGroupId();



  /**
   * Sets the "group-id" property.
   * <p>
   * The group ID associated with this replicated domain.
   * <p>
   * This value defines the group ID of the replicated domain. The
   * replication system will preferably connect and send updates to
   * replicate to a replication server with the same group ID as its
   * own one (the local server group ID).
   *
   * @param value The value of the "group-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setGroupId(Integer value) throws PropertyException;



  /**
   * Gets the "heartbeat-interval" property.
   * <p>
   * Specifies the heart-beat interval that the directory server will
   * use when communicating with Replication Servers.
   * <p>
   * The directory server expects a regular heart-beat coming from the
   * Replication Server within the specified interval. If a heartbeat
   * is not received within the interval, the Directory Server closes
   * its connection and connects to another Replication Server.
   *
   * @return Returns the value of the "heartbeat-interval" property.
   */
  long getHeartbeatInterval();



  /**
   * Sets the "heartbeat-interval" property.
   * <p>
   * Specifies the heart-beat interval that the directory server will
   * use when communicating with Replication Servers.
   * <p>
   * The directory server expects a regular heart-beat coming from the
   * Replication Server within the specified interval. If a heartbeat
   * is not received within the interval, the Directory Server closes
   * its connection and connects to another Replication Server.
   *
   * @param value The value of the "heartbeat-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setHeartbeatInterval(Long value) throws PropertyException;



  /**
   * Gets the "initialization-window-size" property.
   * <p>
   * Specifies the window size that this directory server may use when
   * communicating with remote Directory Servers for initialization.
   *
   * @return Returns the value of the "initialization-window-size" property.
   */
  int getInitializationWindowSize();



  /**
   * Sets the "initialization-window-size" property.
   * <p>
   * Specifies the window size that this directory server may use when
   * communicating with remote Directory Servers for initialization.
   *
   * @param value The value of the "initialization-window-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setInitializationWindowSize(Integer value) throws PropertyException;



  /**
   * Gets the "isolation-policy" property.
   * <p>
   * Specifies the behavior of the directory server if a write
   * operation is attempted on the data within the Replication Domain
   * when none of the configured Replication Servers are available.
   *
   * @return Returns the value of the "isolation-policy" property.
   */
  IsolationPolicy getIsolationPolicy();



  /**
   * Sets the "isolation-policy" property.
   * <p>
   * Specifies the behavior of the directory server if a write
   * operation is attempted on the data within the Replication Domain
   * when none of the configured Replication Servers are available.
   *
   * @param value The value of the "isolation-policy" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIsolationPolicy(IsolationPolicy value) throws PropertyException;



  /**
   * Gets the "log-changenumber" property.
   * <p>
   * Indicates if this server logs the ChangeNumber in access log.
   * <p>
   * This boolean indicates if the domain should log the ChangeNumber
   * of replicated operations in the access log.
   *
   * @return Returns the value of the "log-changenumber" property.
   */
  boolean isLogChangenumber();



  /**
   * Sets the "log-changenumber" property.
   * <p>
   * Indicates if this server logs the ChangeNumber in access log.
   * <p>
   * This boolean indicates if the domain should log the ChangeNumber
   * of replicated operations in the access log.
   *
   * @param value The value of the "log-changenumber" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogChangenumber(Boolean value) throws PropertyException;



  /**
   * Gets the "referrals-url" property.
   * <p>
   * The URLs other LDAP servers should use to refer to the local
   * server.
   * <p>
   * URLs used by peer servers in the topology to refer to the local
   * server through LDAP referrals. If this attribute is not defined,
   * every URLs available to access this server will be used. If
   * defined, only URLs specified here will be used.
   *
   * @return Returns the values of the "referrals-url" property.
   */
  SortedSet<String> getReferralsUrl();



  /**
   * Sets the "referrals-url" property.
   * <p>
   * The URLs other LDAP servers should use to refer to the local
   * server.
   * <p>
   * URLs used by peer servers in the topology to refer to the local
   * server through LDAP referrals. If this attribute is not defined,
   * every URLs available to access this server will be used. If
   * defined, only URLs specified here will be used.
   *
   * @param values The values of the "referrals-url" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setReferralsUrl(Collection<String> values) throws PropertyException;



  /**
   * Gets the "replication-server" property.
   * <p>
   * Specifies the addresses of the Replication Servers within the
   * Replication Domain to which the directory server should try to
   * connect at startup time.
   * <p>
   * Addresses must be specified using the syntax: hostname:port
   *
   * @return Returns the values of the "replication-server" property.
   */
  SortedSet<String> getReplicationServer();



  /**
   * Sets the "replication-server" property.
   * <p>
   * Specifies the addresses of the Replication Servers within the
   * Replication Domain to which the directory server should try to
   * connect at startup time.
   * <p>
   * Addresses must be specified using the syntax: hostname:port
   *
   * @param values The values of the "replication-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setReplicationServer(Collection<String> values) throws PropertyException;



  /**
   * Gets the "server-id" property.
   * <p>
   * Specifies a unique identifier for the directory server within the
   * Replication Domain.
   * <p>
   * Each directory server within the same Replication Domain must
   * have a different server ID. A directory server which is a member
   * of multiple Replication Domains may use the same server ID for
   * each of its Replication Domain configurations.
   *
   * @return Returns the value of the "server-id" property.
   */
  Integer getServerId();



  /**
   * Sets the "server-id" property.
   * <p>
   * Specifies a unique identifier for the directory server within the
   * Replication Domain.
   * <p>
   * Each directory server within the same Replication Domain must
   * have a different server ID. A directory server which is a member
   * of multiple Replication Domains may use the same server ID for
   * each of its Replication Domain configurations.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Replication Domain.
   *
   * @param value The value of the "server-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Replication Domain is not being initialized.
   */
  void setServerId(int value) throws PropertyException, PropertyException;



  /**
   * Gets the "solve-conflicts" property.
   * <p>
   * Indicates if this server solves conflict.
   * <p>
   * This boolean indicates if this domain keeps the historical
   * information necessary to solve conflicts. When set to false the
   * server will not maintain historical information and will therefore
   * not be able to solve conflict. This should therefore be done only
   * if the replication is used in a single master type of deployment.
   *
   * @return Returns the value of the "solve-conflicts" property.
   */
  boolean isSolveConflicts();



  /**
   * Sets the "solve-conflicts" property.
   * <p>
   * Indicates if this server solves conflict.
   * <p>
   * This boolean indicates if this domain keeps the historical
   * information necessary to solve conflicts. When set to false the
   * server will not maintain historical information and will therefore
   * not be able to solve conflict. This should therefore be done only
   * if the replication is used in a single master type of deployment.
   *
   * @param value The value of the "solve-conflicts" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSolveConflicts(Boolean value) throws PropertyException;



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
   * Gets the "window-size" property.
   * <p>
   * Specifies the window size that the directory server will use when
   * communicating with Replication Servers.
   * <p>
   * This option may be deprecated and removed in future releases.
   *
   * @return Returns the value of the "window-size" property.
   */
  int getWindowSize();



  /**
   * Sets the "window-size" property.
   * <p>
   * Specifies the window size that the directory server will use when
   * communicating with Replication Servers.
   * <p>
   * This option may be deprecated and removed in future releases.
   *
   * @param value The value of the "window-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWindowSize(Integer value) throws PropertyException;



  /**
   * Gets the External Changelog Domain.
   *
   * @return Returns the External Changelog Domain.
   * @throws DefinitionDecodingException
   *           If the External Changelog Domain was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the External Changelog Domain was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the External Changelog Domain could not be found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Replication Domain has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ExternalChangelogDomainCfgClient getExternalChangelogDomain()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;

}
