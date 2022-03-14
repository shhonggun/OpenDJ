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
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.DisabledPrivilege;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.EtimeResolution;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.InvalidAttributeSyntaxBehavior;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.SingleStructuralObjectclassBehavior;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.GlobalCfg;



/**
 * A client-side interface for reading and modifying Global
 * Configuration settings.
 * <p>
 * The Global Configuration contains properties that affect the
 * overall operation of the OpenDJ.
 */
public interface GlobalCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Global Configuration.
   *
   * @return Returns the configuration definition associated with this Global Configuration.
   */
  ManagedObjectDefinition<? extends GlobalCfgClient, ? extends GlobalCfg> definition();



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
   * Sets the "add-missing-rdn-attributes" property.
   * <p>
   * Indicates whether the directory server should automatically add
   * any attribute values contained in the entry's RDN into that entry
   * when processing an add request.
   *
   * @param value The value of the "add-missing-rdn-attributes" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAddMissingRDNAttributes(Boolean value) throws PropertyException;



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
   * Sets the "allow-attribute-name-exceptions" property.
   * <p>
   * Indicates whether the directory server should allow underscores
   * in attribute names and allow attribute names to begin with numeric
   * digits (both of which are violations of the LDAP standards).
   *
   * @param value The value of the "allow-attribute-name-exceptions" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAllowAttributeNameExceptions(Boolean value) throws PropertyException;



  /**
   * Gets the "allowed-task" property.
   * <p>
   * Specifies the fully-qualified name of a Java class that may be
   * invoked in the server.
   * <p>
   * Any attempt to invoke a task not included in the list of allowed
   * tasks is rejected.
   *
   * @return Returns the values of the "allowed-task" property.
   */
  SortedSet<String> getAllowedTask();



  /**
   * Sets the "allowed-task" property.
   * <p>
   * Specifies the fully-qualified name of a Java class that may be
   * invoked in the server.
   * <p>
   * Any attempt to invoke a task not included in the list of allowed
   * tasks is rejected.
   *
   * @param values The values of the "allowed-task" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAllowedTask(Collection<String> values) throws PropertyException;



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
   * Sets the "bind-with-dn-requires-password" property.
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
   * @param value The value of the "bind-with-dn-requires-password" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBindWithDNRequiresPassword(Boolean value) throws PropertyException;



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
   * Sets the "check-schema" property.
   * <p>
   * Indicates whether schema enforcement is active.
   * <p>
   * When schema enforcement is activated, the directory server
   * ensures that all operations result in entries are valid according
   * to the defined server schema. It is strongly recommended that this
   * option be left enabled to prevent the inadvertent addition of
   * invalid data into the server.
   *
   * @param value The value of the "check-schema" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCheckSchema(Boolean value) throws PropertyException;



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
   * Sets the "default-password-policy" property.
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
   * @param value The value of the "default-password-policy" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultPasswordPolicy(String value) throws PropertyException;



  /**
   * Gets the "disabled-privilege" property.
   * <p>
   * Specifies the name of a privilege that should not be evaluated by
   * the server.
   * <p>
   * If a privilege is disabled, then it is assumed that all clients
   * (including unauthenticated clients) have that privilege.
   *
   * @return Returns the values of the "disabled-privilege" property.
   */
  SortedSet<DisabledPrivilege> getDisabledPrivilege();



  /**
   * Sets the "disabled-privilege" property.
   * <p>
   * Specifies the name of a privilege that should not be evaluated by
   * the server.
   * <p>
   * If a privilege is disabled, then it is assumed that all clients
   * (including unauthenticated clients) have that privilege.
   *
   * @param values The values of the "disabled-privilege" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setDisabledPrivilege(Collection<DisabledPrivilege> values) throws PropertyException;



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
   * Sets the "etime-resolution" property.
   * <p>
   * Specifies the resolution to use for operation elapsed processing
   * time (etime) measurements.
   *
   * @param value The value of the "etime-resolution" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEtimeResolution(EtimeResolution value) throws PropertyException;



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
   * Sets the "idle-time-limit" property.
   * <p>
   * Specifies the maximum length of time that a client connection may
   * remain established since its last completed operation.
   * <p>
   * A value of "0 seconds" indicates that no idle time limit is
   * enforced.
   *
   * @param value The value of the "idle-time-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIdleTimeLimit(Long value) throws PropertyException;



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
   * Sets the "invalid-attribute-syntax-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations
   * whenever an attribute value violates the associated attribute
   * syntax.
   *
   * @param value The value of the "invalid-attribute-syntax-behavior" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setInvalidAttributeSyntaxBehavior(InvalidAttributeSyntaxBehavior value) throws PropertyException;



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
   * Sets the "lookthrough-limit" property.
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
   * @param value The value of the "lookthrough-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLookthroughLimit(Integer value) throws PropertyException;



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
   * Sets the "max-allowed-client-connections" property.
   * <p>
   * Specifies the maximum number of client connections that may be
   * established at any given time
   * <p>
   * A value of 0 indicates that unlimited client connection is
   * allowed.
   *
   * @param value The value of the "max-allowed-client-connections" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxAllowedClientConnections(Integer value) throws PropertyException;



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
   * Sets the "max-internal-buffer-size" property.
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
   * @param value The value of the "max-internal-buffer-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxInternalBufferSize(Long value) throws PropertyException;



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
   * Sets the "max-psearches" property.
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
   * @param value The value of the "max-psearches" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxPsearches(Integer value) throws PropertyException;



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
   * Sets the "notify-abandoned-operations" property.
   * <p>
   * Indicates whether the directory server should send a response to
   * any operation that is interrupted via an abandon request.
   * <p>
   * The LDAP specification states that abandoned operations should
   * not receive any response, but this may cause problems with client
   * applications that always expect to receive a response to each
   * request.
   *
   * @param value The value of the "notify-abandoned-operations" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setNotifyAbandonedOperations(Boolean value) throws PropertyException;



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
   * Sets the "proxied-authorization-identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper to map authorization ID
   * values (using the "u:" form) provided in the proxied authorization
   * control to the corresponding user entry.
   *
   * @param value The value of the "proxied-authorization-identity-mapper" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setProxiedAuthorizationIdentityMapper(String value) throws PropertyException;



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
   * Sets the "reject-unauthenticated-requests" property.
   * <p>
   * Indicates whether the directory server should reject any request
   * (other than bind or StartTLS requests) received from a client that
   * has not yet been authenticated, whose last authentication attempt
   * was unsuccessful, or whose last authentication attempt used
   * anonymous authentication.
   *
   * @param value The value of the "reject-unauthenticated-requests" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setRejectUnauthenticatedRequests(Boolean value) throws PropertyException;



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
   * Sets the "return-bind-error-messages" property.
   * <p>
   * Indicates whether responses for failed bind operations should
   * include a message string providing the reason for the
   * authentication failure.
   * <p>
   * Note that these messages may include information that could
   * potentially be used by an attacker. If this option is disabled,
   * then these messages appears only in the server's access log.
   *
   * @param value The value of the "return-bind-error-messages" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setReturnBindErrorMessages(Boolean value) throws PropertyException;



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
   * Sets the "save-config-on-successful-startup" property.
   * <p>
   * Indicates whether the directory server should save a copy of its
   * configuration whenever the startup process completes successfully.
   * <p>
   * This ensures that the server provides a "last known good"
   * configuration, which can be used as a reference (or copied into
   * the active config) if the server fails to start with the current
   * "active" configuration.
   *
   * @param value The value of the "save-config-on-successful-startup" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSaveConfigOnSuccessfulStartup(Boolean value) throws PropertyException;



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
   * Sets the "server-error-result-code" property.
   * <p>
   * Specifies the numeric value of the result code when request
   * processing fails due to an internal server error.
   *
   * @param value The value of the "server-error-result-code" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setServerErrorResultCode(Integer value) throws PropertyException;



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
   * Sets the "single-structural-objectclass-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations an
   * entry does not contain a structural object class or contains
   * multiple structural classes.
   *
   * @param value The value of the "single-structural-objectclass-behavior" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSingleStructuralObjectclassBehavior(SingleStructuralObjectclassBehavior value) throws PropertyException;



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
   * Sets the "size-limit" property.
   * <p>
   * Specifies the maximum number of entries that can be returned to
   * the client during a single search operation.
   * <p>
   * A value of 0 indicates that no size limit is enforced. Note that
   * this is the default server-wide limit, but it may be overridden on
   * a per-user basis using the ds-rlim-size-limit operational
   * attribute.
   *
   * @param value The value of the "size-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSizeLimit(Integer value) throws PropertyException;



  /**
   * Gets the "smtp-server" property.
   * <p>
   * Specifies the address (and optional port number) for a mail
   * server that can be used to send email messages via SMTP.
   * <p>
   * It may be an IP address or resolvable hostname, optionally
   * followed by a colon and a port number.
   *
   * @return Returns the values of the "smtp-server" property.
   */
  SortedSet<String> getSMTPServer();



  /**
   * Sets the "smtp-server" property.
   * <p>
   * Specifies the address (and optional port number) for a mail
   * server that can be used to send email messages via SMTP.
   * <p>
   * It may be an IP address or resolvable hostname, optionally
   * followed by a colon and a port number.
   *
   * @param values The values of the "smtp-server" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSMTPServer(Collection<String> values) throws PropertyException;



  /**
   * Gets the "subordinate-base-dn" property.
   * <p>
   * Specifies the set of base DNs used for singleLevel, wholeSubtree,
   * and subordinateSubtree searches based at the root DSE.
   *
   * @return Returns the values of the "subordinate-base-dn" property.
   */
  SortedSet<DN> getSubordinateBaseDN();



  /**
   * Sets the "subordinate-base-dn" property.
   * <p>
   * Specifies the set of base DNs used for singleLevel, wholeSubtree,
   * and subordinateSubtree searches based at the root DSE.
   *
   * @param values The values of the "subordinate-base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSubordinateBaseDN(Collection<DN> values) throws PropertyException;



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
   * Sets the "time-limit" property.
   * <p>
   * Specifies the maximum length of time that should be spent
   * processing a single search operation.
   * <p>
   * A value of 0 seconds indicates that no time limit is enforced.
   * Note that this is the default server-wide time limit, but it may
   * be overridden on a per-user basis using the ds-rlim-time-limit
   * operational attribute.
   *
   * @param value The value of the "time-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTimeLimit(Long value) throws PropertyException;



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
   * Sets the "trust-transaction-ids" property.
   * <p>
   * Indicates whether the directory server should trust the
   * transaction ids that may be received from requests, either through
   * a LDAP control or through a HTTP header.
   *
   * @param value The value of the "trust-transaction-ids" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustTransactionIds(Boolean value) throws PropertyException;



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the kinds of write operations the directory server can
   * process.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();



  /**
   * Sets the "writability-mode" property.
   * <p>
   * Specifies the kinds of write operations the directory server can
   * process.
   *
   * @param value The value of the "writability-mode" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWritabilityMode(WritabilityMode value) throws PropertyException;

}
