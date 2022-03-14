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
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.DisabledPrivilege;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.EtimeResolution;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.InvalidAttributeSyntaxBehavior;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.SingleStructuralObjectclassBehavior;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.WritabilityMode;



/**
 * A server-side interface for querying Global Configuration settings.
 * <p>
 * The Global Configuration contains properties that affect the
 * overall operation of the OpenDJ.
 */
public interface GlobalCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Global Configuration.
   *
   * @return Returns the configuration class associated with this Global Configuration.
   */
  Class<? extends GlobalCfg> configurationClass();



  /**
   * Register to be notified when this Global Configuration is changed.
   *
   * @param listener
   *          The Global Configuration configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<GlobalCfg> listener);



  /**
   * Deregister an existing Global Configuration configuration change listener.
   *
   * @param listener
   *          The Global Configuration configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<GlobalCfg> listener);



  /**
   * Gets the "add-missing-rdn-attributes" property.
   * <p>
   * Indicates whether the directory server should automatically add
   * any attribute values contained in the entry's RDN into that entry
   * when processing an add request.
   *
   * @return Returns the value of the "add-missing-rdn-attributes" property.
   */
  boolean isAddMissingRDNAttributes();



  /**
   * Gets the "allow-attribute-name-exceptions" property.
   * <p>
   * Indicates whether the directory server should allow underscores
   * in attribute names and allow attribute names to begin with numeric
   * digits (both of which are violations of the LDAP standards).
   *
   * @return Returns the value of the "allow-attribute-name-exceptions" property.
   */
  boolean isAllowAttributeNameExceptions();



  /**
   * Gets the "allowed-task" property.
   * <p>
   * Specifies the fully-qualified name of a Java class that may be
   * invoked in the server.
   * <p>
   * Any attempt to invoke a task not included in the list of allowed
   * tasks is rejected.
   *
   * @return Returns an unmodifiable set containing the values of the "allowed-task" property.
   */
  SortedSet<String> getAllowedTask();



  /**
   * Gets the "bind-with-dn-requires-password" property.
   * <p>
   * Indicates whether the directory server should reject any simple
   * bind request that contains a DN but no password.
   * <p>
   * Although such bind requests are technically allowed by the LDAPv3
   * specification (and should be treated as anonymous simple
   * authentication), they may introduce security problems in
   * applications that do not verify that the client actually provided
   * a password.
   *
   * @return Returns the value of the "bind-with-dn-requires-password" property.
   */
  boolean isBindWithDNRequiresPassword();



  /**
   * Gets the "check-schema" property.
   * <p>
   * Indicates whether schema enforcement is active.
   * <p>
   * When schema enforcement is activated, the directory server
   * ensures that all operations result in entries are valid according
   * to the defined server schema. It is strongly recommended that this
   * option be left enabled to prevent the inadvertent addition of
   * invalid data into the server.
   *
   * @return Returns the value of the "check-schema" property.
   */
  boolean isCheckSchema();



  /**
   * Gets the "default-password-policy" property.
   * <p>
   * Specifies the name of the password policy that is in effect for
   * users whose entries do not specify an alternate password policy
   * (either via a real or virtual attribute).
   * <p>
   * In addition, the default password policy will be used for
   * providing default parameters for sub-entry based password policies
   * when not provided or supported by the sub-entry itself. This
   * property must reference a password policy and no other type of
   * authentication policy.
   *
   * @return Returns the value of the "default-password-policy" property.
   */
  String getDefaultPasswordPolicy();



  /**
   * Gets the "default-password-policy" property as a DN.
   * <p>
   * Specifies the name of the password policy that is in effect for
   * users whose entries do not specify an alternate password policy
   * (either via a real or virtual attribute).
   * <p>
   * In addition, the default password policy will be used for
   * providing default parameters for sub-entry based password policies
   * when not provided or supported by the sub-entry itself. This
   * property must reference a password policy and no other type of
   * authentication policy.
   *
   * @return Returns the DN value of the "default-password-policy"
   *         property.
   */
  DN getDefaultPasswordPolicyDN();



  /**
   * Gets the "disabled-privilege" property.
   * <p>
   * Specifies the name of a privilege that should not be evaluated by
   * the server.
   * <p>
   * If a privilege is disabled, then it is assumed that all clients
   * (including unauthenticated clients) have that privilege.
   *
   * @return Returns an unmodifiable set containing the values of the "disabled-privilege" property.
   */
  SortedSet<DisabledPrivilege> getDisabledPrivilege();



  /**
   * Gets the "etime-resolution" property.
   * <p>
   * Specifies the resolution to use for operation elapsed processing
   * time (etime) measurements.
   *
   * @return Returns the value of the "etime-resolution" property.
   */
  EtimeResolution getEtimeResolution();



  /**
   * Gets the "idle-time-limit" property.
   * <p>
   * Specifies the maximum length of time that a client connection may
   * remain established since its last completed operation.
   * <p>
   * A value of "0 seconds" indicates that no idle time limit is
   * enforced.
   *
   * @return Returns the value of the "idle-time-limit" property.
   */
  long getIdleTimeLimit();



  /**
   * Gets the "invalid-attribute-syntax-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations
   * whenever an attribute value violates the associated attribute
   * syntax.
   *
   * @return Returns the value of the "invalid-attribute-syntax-behavior" property.
   */
  InvalidAttributeSyntaxBehavior getInvalidAttributeSyntaxBehavior();



  /**
   * Gets the "lookthrough-limit" property.
   * <p>
   * Specifies the maximum number of entries that the directory server
   * should "look through" in the course of processing a search
   * request.
   * <p>
   * This includes any entry that the server must examine in the
   * course of processing the request, regardless of whether it
   * actually matches the search criteria. A value of 0 indicates that
   * no lookthrough limit is enforced. Note that this is the default
   * server-wide limit, but it may be overridden on a per-user basis
   * using the ds-rlim-lookthrough-limit operational attribute.
   *
   * @return Returns the value of the "lookthrough-limit" property.
   */
  int getLookthroughLimit();



  /**
   * Gets the "max-allowed-client-connections" property.
   * <p>
   * Specifies the maximum number of client connections that may be
   * established at any given time
   * <p>
   * A value of 0 indicates that unlimited client connection is
   * allowed.
   *
   * @return Returns the value of the "max-allowed-client-connections" property.
   */
  int getMaxAllowedClientConnections();



  /**
   * Gets the "max-internal-buffer-size" property.
   * <p>
   * The threshold capacity beyond which internal cached buffers used
   * for encoding and decoding entries and protocol messages will be
   * trimmed after use.
   * <p>
   * Individual buffers may grow very large when encoding and decoding
   * large entries and protocol messages and should be reduced in size
   * when they are no longer needed. This setting specifies the
   * threshold at which a buffer is determined to have grown too big
   * and should be trimmed down after use.
   *
   * @return Returns the value of the "max-internal-buffer-size" property.
   */
  long getMaxInternalBufferSize();



  /**
   * Gets the "max-psearches" property.
   * <p>
   * Defines the maximum number of concurrent persistent searches that
   * can be performed on directory server
   * <p>
   * The persistent search mechanism provides an active channel
   * through which entries that change, and information about the
   * changes that occur, can be communicated. Because each persistent
   * search operation consumes resources, limiting the number of
   * simultaneous persistent searches keeps the performance impact
   * minimal. A value of -1 indicates that there is no limit on the
   * persistent searches.
   *
   * @return Returns the value of the "max-psearches" property.
   */
  int getMaxPsearches();



  /**
   * Gets the "notify-abandoned-operations" property.
   * <p>
   * Indicates whether the directory server should send a response to
   * any operation that is interrupted via an abandon request.
   * <p>
   * The LDAP specification states that abandoned operations should
   * not receive any response, but this may cause problems with client
   * applications that always expect to receive a response to each
   * request.
   *
   * @return Returns the value of the "notify-abandoned-operations" property.
   */
  boolean isNotifyAbandonedOperations();



  /**
   * Gets the "proxied-authorization-identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper to map authorization ID
   * values (using the "u:" form) provided in the proxied authorization
   * control to the corresponding user entry.
   *
   * @return Returns the value of the "proxied-authorization-identity-mapper" property.
   */
  String getProxiedAuthorizationIdentityMapper();



  /**
   * Gets the "proxied-authorization-identity-mapper" property as a
   * DN.
   * <p>
   * Specifies the name of the identity mapper to map authorization ID
   * values (using the "u:" form) provided in the proxied authorization
   * control to the corresponding user entry.
   *
   * @return Returns the DN value of the
   *         "proxied-authorization-identity-mapper" property.
   */
  DN getProxiedAuthorizationIdentityMapperDN();



  /**
   * Gets the "reject-unauthenticated-requests" property.
   * <p>
   * Indicates whether the directory server should reject any request
   * (other than bind or StartTLS requests) received from a client that
   * has not yet been authenticated, whose last authentication attempt
   * was unsuccessful, or whose last authentication attempt used
   * anonymous authentication.
   *
   * @return Returns the value of the "reject-unauthenticated-requests" property.
   */
  boolean isRejectUnauthenticatedRequests();



  /**
   * Gets the "return-bind-error-messages" property.
   * <p>
   * Indicates whether responses for failed bind operations should
   * include a message string providing the reason for the
   * authentication failure.
   * <p>
   * Note that these messages may include information that could
   * potentially be used by an attacker. If this option is disabled,
   * then these messages appears only in the server's access log.
   *
   * @return Returns the value of the "return-bind-error-messages" property.
   */
  boolean isReturnBindErrorMessages();



  /**
   * Gets the "save-config-on-successful-startup" property.
   * <p>
   * Indicates whether the directory server should save a copy of its
   * configuration whenever the startup process completes successfully.
   * <p>
   * This ensures that the server provides a "last known good"
   * configuration, which can be used as a reference (or copied into
   * the active config) if the server fails to start with the current
   * "active" configuration.
   *
   * @return Returns the value of the "save-config-on-successful-startup" property.
   */
  boolean isSaveConfigOnSuccessfulStartup();



  /**
   * Gets the "server-error-result-code" property.
   * <p>
   * Specifies the numeric value of the result code when request
   * processing fails due to an internal server error.
   *
   * @return Returns the value of the "server-error-result-code" property.
   */
  int getServerErrorResultCode();



  /**
   * Gets the "single-structural-objectclass-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations an
   * entry does not contain a structural object class or contains
   * multiple structural classes.
   *
   * @return Returns the value of the "single-structural-objectclass-behavior" property.
   */
  SingleStructuralObjectclassBehavior getSingleStructuralObjectclassBehavior();



  /**
   * Gets the "size-limit" property.
   * <p>
   * Specifies the maximum number of entries that can be returned to
   * the client during a single search operation.
   * <p>
   * A value of 0 indicates that no size limit is enforced. Note that
   * this is the default server-wide limit, but it may be overridden on
   * a per-user basis using the ds-rlim-size-limit operational
   * attribute.
   *
   * @return Returns the value of the "size-limit" property.
   */
  int getSizeLimit();



  /**
   * Gets the "smtp-server" property.
   * <p>
   * Specifies the address (and optional port number) for a mail
   * server that can be used to send email messages via SMTP.
   * <p>
   * It may be an IP address or resolvable hostname, optionally
   * followed by a colon and a port number.
   *
   * @return Returns an unmodifiable set containing the values of the "smtp-server" property.
   */
  SortedSet<String> getSMTPServer();



  /**
   * Gets the "subordinate-base-dn" property.
   * <p>
   * Specifies the set of base DNs used for singleLevel, wholeSubtree,
   * and subordinateSubtree searches based at the root DSE.
   *
   * @return Returns an unmodifiable set containing the values of the "subordinate-base-dn" property.
   */
  SortedSet<DN> getSubordinateBaseDN();



  /**
   * Gets the "time-limit" property.
   * <p>
   * Specifies the maximum length of time that should be spent
   * processing a single search operation.
   * <p>
   * A value of 0 seconds indicates that no time limit is enforced.
   * Note that this is the default server-wide time limit, but it may
   * be overridden on a per-user basis using the ds-rlim-time-limit
   * operational attribute.
   *
   * @return Returns the value of the "time-limit" property.
   */
  long getTimeLimit();



  /**
   * Gets the "trust-transaction-ids" property.
   * <p>
   * Indicates whether the directory server should trust the
   * transaction ids that may be received from requests, either through
   * a LDAP control or through a HTTP header.
   *
   * @return Returns the value of the "trust-transaction-ids" property.
   */
  boolean isTrustTransactionIds();



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the kinds of write operations the directory server can
   * process.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();

}
