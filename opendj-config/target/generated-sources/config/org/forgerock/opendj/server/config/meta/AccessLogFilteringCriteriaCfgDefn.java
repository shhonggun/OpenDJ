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
package org.forgerock.opendj.server.config.meta;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.IPAddressMaskPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.AccessLogFilteringCriteriaCfgClient;
import org.forgerock.opendj.server.config.server.AccessLogFilteringCriteriaCfg;



/**
 * An interface for querying the Access Log Filtering Criteria managed
 * object definition meta information.
 * <p>
 * A set of rules which together determine whether a log record should
 * be logged or not.
 */
public final class AccessLogFilteringCriteriaCfgDefn extends ManagedObjectDefinition<AccessLogFilteringCriteriaCfgClient, AccessLogFilteringCriteriaCfg> {

  /** The singleton configuration definition instance. */
  private static final AccessLogFilteringCriteriaCfgDefn INSTANCE = new AccessLogFilteringCriteriaCfgDefn();



  /**
   * Defines the set of permissable values for the "log-record-type" property.
   * <p>
   * Filters log records based on their type.
   */
  public static enum LogRecordType {

    /**
     * Abandon operations
     */
    ABANDON("abandon"),



    /**
     * Add operations
     */
    ADD("add"),



    /**
     * Bind operations
     */
    BIND("bind"),



    /**
     * Compare operations
     */
    COMPARE("compare"),



    /**
     * Client connections
     */
    CONNECT("connect"),



    /**
     * Delete operations
     */
    DELETE("delete"),



    /**
     * Client disconnections
     */
    DISCONNECT("disconnect"),



    /**
     * Extended operations
     */
    EXTENDED("extended"),



    /**
     * Modify operations
     */
    MODIFY("modify"),



    /**
     * Rename operations
     */
    RENAME("rename"),



    /**
     * Search operations
     */
    SEARCH("search"),



    /**
     * Unbind operations
     */
    UNBIND("unbind");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private LogRecordType(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "connection-client-address-equal-to" property definition. */
  private static final IPAddressMaskPropertyDefinition PD_CONNECTION_CLIENT_ADDRESS_EQUAL_TO;



  /** The "connection-client-address-not-equal-to" property definition. */
  private static final IPAddressMaskPropertyDefinition PD_CONNECTION_CLIENT_ADDRESS_NOT_EQUAL_TO;



  /** The "connection-port-equal-to" property definition. */
  private static final IntegerPropertyDefinition PD_CONNECTION_PORT_EQUAL_TO;



  /** The "connection-protocol-equal-to" property definition. */
  private static final StringPropertyDefinition PD_CONNECTION_PROTOCOL_EQUAL_TO;



  /** The "log-record-type" property definition. */
  private static final EnumPropertyDefinition<LogRecordType> PD_LOG_RECORD_TYPE;



  /** The "request-target-dn-equal-to" property definition. */
  private static final StringPropertyDefinition PD_REQUEST_TARGET_DN_EQUAL_TO;



  /** The "request-target-dn-not-equal-to" property definition. */
  private static final StringPropertyDefinition PD_REQUEST_TARGET_DN_NOT_EQUAL_TO;



  /** The "response-etime-greater-than" property definition. */
  private static final IntegerPropertyDefinition PD_RESPONSE_ETIME_GREATER_THAN;



  /** The "response-etime-less-than" property definition. */
  private static final IntegerPropertyDefinition PD_RESPONSE_ETIME_LESS_THAN;



  /** The "response-result-code-equal-to" property definition. */
  private static final IntegerPropertyDefinition PD_RESPONSE_RESULT_CODE_EQUAL_TO;



  /** The "response-result-code-not-equal-to" property definition. */
  private static final IntegerPropertyDefinition PD_RESPONSE_RESULT_CODE_NOT_EQUAL_TO;



  /** The "search-response-is-indexed" property definition. */
  private static final BooleanPropertyDefinition PD_SEARCH_RESPONSE_IS_INDEXED;



  /** The "search-response-nentries-greater-than" property definition. */
  private static final IntegerPropertyDefinition PD_SEARCH_RESPONSE_NENTRIES_GREATER_THAN;



  /** The "search-response-nentries-less-than" property definition. */
  private static final IntegerPropertyDefinition PD_SEARCH_RESPONSE_NENTRIES_LESS_THAN;



  /** The "user-dn-equal-to" property definition. */
  private static final StringPropertyDefinition PD_USER_DN_EQUAL_TO;



  /** The "user-dn-not-equal-to" property definition. */
  private static final StringPropertyDefinition PD_USER_DN_NOT_EQUAL_TO;



  /** The "user-is-member-of" property definition. */
  private static final DNPropertyDefinition PD_USER_IS_MEMBER_OF;



  /** The "user-is-not-member-of" property definition. */
  private static final DNPropertyDefinition PD_USER_IS_NOT_MEMBER_OF;



  /** Build the "connection-client-address-equal-to" property definition. */
  static {
      IPAddressMaskPropertyDefinition.Builder builder = IPAddressMaskPropertyDefinition.createBuilder(INSTANCE, "connection-client-address-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-client-address-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AddressMask>());
      PD_CONNECTION_CLIENT_ADDRESS_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_CLIENT_ADDRESS_EQUAL_TO);
  }



  /** Build the "connection-client-address-not-equal-to" property definition. */
  static {
      IPAddressMaskPropertyDefinition.Builder builder = IPAddressMaskPropertyDefinition.createBuilder(INSTANCE, "connection-client-address-not-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-client-address-not-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AddressMask>());
      PD_CONNECTION_CLIENT_ADDRESS_NOT_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_CLIENT_ADDRESS_NOT_EQUAL_TO);
  }



  /** Build the "connection-port-equal-to" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "connection-port-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-port-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setUpperLimit(65535);
      builder.setLowerLimit(1);
      PD_CONNECTION_PORT_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_PORT_EQUAL_TO);
  }



  /** Build the "connection-protocol-equal-to" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "connection-protocol-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-protocol-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("[a-zA-Z0-9]+", "NAME");
      PD_CONNECTION_PROTOCOL_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_PROTOCOL_EQUAL_TO);
  }



  /** Build the "log-record-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<LogRecordType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "log-record-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-record-type"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<LogRecordType>());
      builder.setEnumClass(LogRecordType.class);
      PD_LOG_RECORD_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_RECORD_TYPE);
  }



  /** Build the "request-target-dn-equal-to" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "request-target-dn-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "request-target-dn-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_REQUEST_TARGET_DN_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUEST_TARGET_DN_EQUAL_TO);
  }



  /** Build the "request-target-dn-not-equal-to" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "request-target-dn-not-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "request-target-dn-not-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_REQUEST_TARGET_DN_NOT_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUEST_TARGET_DN_NOT_EQUAL_TO);
  }



  /** Build the "response-etime-greater-than" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "response-etime-greater-than");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "response-etime-greater-than"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_RESPONSE_ETIME_GREATER_THAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RESPONSE_ETIME_GREATER_THAN);
  }



  /** Build the "response-etime-less-than" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "response-etime-less-than");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "response-etime-less-than"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_RESPONSE_ETIME_LESS_THAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RESPONSE_ETIME_LESS_THAN);
  }



  /** Build the "response-result-code-equal-to" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "response-result-code-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "response-result-code-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_RESPONSE_RESULT_CODE_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RESPONSE_RESULT_CODE_EQUAL_TO);
  }



  /** Build the "response-result-code-not-equal-to" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "response-result-code-not-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "response-result-code-not-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_RESPONSE_RESULT_CODE_NOT_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RESPONSE_RESULT_CODE_NOT_EQUAL_TO);
  }



  /** Build the "search-response-is-indexed" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "search-response-is-indexed");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "search-response-is-indexed"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_SEARCH_RESPONSE_IS_INDEXED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SEARCH_RESPONSE_IS_INDEXED);
  }



  /** Build the "search-response-nentries-greater-than" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "search-response-nentries-greater-than");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "search-response-nentries-greater-than"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_SEARCH_RESPONSE_NENTRIES_GREATER_THAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SEARCH_RESPONSE_NENTRIES_GREATER_THAN);
  }



  /** Build the "search-response-nentries-less-than" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "search-response-nentries-less-than");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "search-response-nentries-less-than"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_SEARCH_RESPONSE_NENTRIES_LESS_THAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SEARCH_RESPONSE_NENTRIES_LESS_THAN);
  }



  /** Build the "user-dn-equal-to" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "user-dn-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-dn-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_USER_DN_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_DN_EQUAL_TO);
  }



  /** Build the "user-dn-not-equal-to" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "user-dn-not-equal-to");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-dn-not-equal-to"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_USER_DN_NOT_EQUAL_TO = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_DN_NOT_EQUAL_TO);
  }



  /** Build the "user-is-member-of" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "user-is-member-of");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-is-member-of"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_USER_IS_MEMBER_OF = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_IS_MEMBER_OF);
  }



  /** Build the "user-is-not-member-of" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "user-is-not-member-of");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-is-not-member-of"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_USER_IS_NOT_MEMBER_OF = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_IS_NOT_MEMBER_OF);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Access Log Filtering Criteria configuration definition
   * singleton.
   *
   * @return Returns the Access Log Filtering Criteria configuration
   *         definition singleton.
   */
  public static AccessLogFilteringCriteriaCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private AccessLogFilteringCriteriaCfgDefn() {
    super("access-log-filtering-criteria", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public AccessLogFilteringCriteriaCfgClient createClientConfiguration(
      ManagedObject<? extends AccessLogFilteringCriteriaCfgClient> impl) {
    return new AccessLogFilteringCriteriaCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public AccessLogFilteringCriteriaCfg createServerConfiguration(
      ServerManagedObject<? extends AccessLogFilteringCriteriaCfg> impl) {
    return new AccessLogFilteringCriteriaCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<AccessLogFilteringCriteriaCfg> getServerConfigurationClass() {
    return AccessLogFilteringCriteriaCfg.class;
  }



  /**
   * Get the "connection-client-address-equal-to" property definition.
   * <p>
   * Filters log records associated with connections which match at
   * least one of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the "connection-client-address-equal-to" property definition.
   */
  public IPAddressMaskPropertyDefinition getConnectionClientAddressEqualToPropertyDefinition() {
    return PD_CONNECTION_CLIENT_ADDRESS_EQUAL_TO;
  }



  /**
   * Get the "connection-client-address-not-equal-to" property definition.
   * <p>
   * Filters log records associated with connections which do not
   * match any of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the "connection-client-address-not-equal-to" property definition.
   */
  public IPAddressMaskPropertyDefinition getConnectionClientAddressNotEqualToPropertyDefinition() {
    return PD_CONNECTION_CLIENT_ADDRESS_NOT_EQUAL_TO;
  }



  /**
   * Get the "connection-port-equal-to" property definition.
   * <p>
   * Filters log records associated with connections to any of the
   * specified listener port numbers.
   *
   * @return Returns the "connection-port-equal-to" property definition.
   */
  public IntegerPropertyDefinition getConnectionPortEqualToPropertyDefinition() {
    return PD_CONNECTION_PORT_EQUAL_TO;
  }



  /**
   * Get the "connection-protocol-equal-to" property definition.
   * <p>
   * Filters log records associated with connections which match any
   * of the specified protocols.
   * <p>
   * Typical values include "ldap", "ldaps", or "jmx".
   *
   * @return Returns the "connection-protocol-equal-to" property definition.
   */
  public StringPropertyDefinition getConnectionProtocolEqualToPropertyDefinition() {
    return PD_CONNECTION_PROTOCOL_EQUAL_TO;
  }



  /**
   * Get the "log-record-type" property definition.
   * <p>
   * Filters log records based on their type.
   *
   * @return Returns the "log-record-type" property definition.
   */
  public EnumPropertyDefinition<LogRecordType> getLogRecordTypePropertyDefinition() {
    return PD_LOG_RECORD_TYPE;
  }



  /**
   * Get the "request-target-dn-equal-to" property definition.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching at least one of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the "request-target-dn-equal-to" property definition.
   */
  public StringPropertyDefinition getRequestTargetDNEqualToPropertyDefinition() {
    return PD_REQUEST_TARGET_DN_EQUAL_TO;
  }



  /**
   * Get the "request-target-dn-not-equal-to" property definition.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching none of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the "request-target-dn-not-equal-to" property definition.
   */
  public StringPropertyDefinition getRequestTargetDNNotEqualToPropertyDefinition() {
    return PD_REQUEST_TARGET_DN_NOT_EQUAL_TO;
  }



  /**
   * Get the "response-etime-greater-than" property definition.
   * <p>
   * Filters operation response log records associated with operations
   * which took longer than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "response-etime-greater-than" property definition.
   */
  public IntegerPropertyDefinition getResponseEtimeGreaterThanPropertyDefinition() {
    return PD_RESPONSE_ETIME_GREATER_THAN;
  }



  /**
   * Get the "response-etime-less-than" property definition.
   * <p>
   * Filters operation response log records associated with operations
   * which took less than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "response-etime-less-than" property definition.
   */
  public IntegerPropertyDefinition getResponseEtimeLessThanPropertyDefinition() {
    return PD_RESPONSE_ETIME_LESS_THAN;
  }



  /**
   * Get the "response-result-code-equal-to" property definition.
   * <p>
   * Filters operation response log records associated with operations
   * which include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "response-result-code-equal-to" property definition.
   */
  public IntegerPropertyDefinition getResponseResultCodeEqualToPropertyDefinition() {
    return PD_RESPONSE_RESULT_CODE_EQUAL_TO;
  }



  /**
   * Get the "response-result-code-not-equal-to" property definition.
   * <p>
   * Filters operation response log records associated with operations
   * which do not include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "response-result-code-not-equal-to" property definition.
   */
  public IntegerPropertyDefinition getResponseResultCodeNotEqualToPropertyDefinition() {
    return PD_RESPONSE_RESULT_CODE_NOT_EQUAL_TO;
  }



  /**
   * Get the "search-response-is-indexed" property definition.
   * <p>
   * Filters search operation response log records associated with
   * searches which were either indexed or unindexed.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "search-response-is-indexed" property definition.
   */
  public BooleanPropertyDefinition getSearchResponseIsIndexedPropertyDefinition() {
    return PD_SEARCH_RESPONSE_IS_INDEXED;
  }



  /**
   * Get the "search-response-nentries-greater-than" property definition.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned more than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "search-response-nentries-greater-than" property definition.
   */
  public IntegerPropertyDefinition getSearchResponseNentriesGreaterThanPropertyDefinition() {
    return PD_SEARCH_RESPONSE_NENTRIES_GREATER_THAN;
  }



  /**
   * Get the "search-response-nentries-less-than" property definition.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned less than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the "search-response-nentries-less-than" property definition.
   */
  public IntegerPropertyDefinition getSearchResponseNentriesLessThanPropertyDefinition() {
    return PD_SEARCH_RESPONSE_NENTRIES_LESS_THAN;
  }



  /**
   * Get the "user-dn-equal-to" property definition.
   * <p>
   * Filters log records associated with users matching at least one
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the "user-dn-equal-to" property definition.
   */
  public StringPropertyDefinition getUserDNEqualToPropertyDefinition() {
    return PD_USER_DN_EQUAL_TO;
  }



  /**
   * Get the "user-dn-not-equal-to" property definition.
   * <p>
   * Filters log records associated with users which do not match any
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the "user-dn-not-equal-to" property definition.
   */
  public StringPropertyDefinition getUserDNNotEqualToPropertyDefinition() {
    return PD_USER_DN_NOT_EQUAL_TO;
  }



  /**
   * Get the "user-is-member-of" property definition.
   * <p>
   * Filters log records associated with users which are members of at
   * least one of the specified groups.
   *
   * @return Returns the "user-is-member-of" property definition.
   */
  public DNPropertyDefinition getUserIsMemberOfPropertyDefinition() {
    return PD_USER_IS_MEMBER_OF;
  }



  /**
   * Get the "user-is-not-member-of" property definition.
   * <p>
   * Filters log records associated with users which are not members
   * of any of the specified groups.
   *
   * @return Returns the "user-is-not-member-of" property definition.
   */
  public DNPropertyDefinition getUserIsNotMemberOfPropertyDefinition() {
    return PD_USER_IS_NOT_MEMBER_OF;
  }



  /**
   * Managed object client implementation.
   */
  private static class AccessLogFilteringCriteriaCfgClientImpl implements
    AccessLogFilteringCriteriaCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends AccessLogFilteringCriteriaCfgClient> impl;



    /** Private constructor. */
    private AccessLogFilteringCriteriaCfgClientImpl(
        ManagedObject<? extends AccessLogFilteringCriteriaCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getConnectionClientAddressEqualTo() {
      return impl.getPropertyValues(INSTANCE.getConnectionClientAddressEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionClientAddressEqualTo(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getConnectionClientAddressEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getConnectionClientAddressNotEqualTo() {
      return impl.getPropertyValues(INSTANCE.getConnectionClientAddressNotEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionClientAddressNotEqualTo(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getConnectionClientAddressNotEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getConnectionPortEqualTo() {
      return impl.getPropertyValues(INSTANCE.getConnectionPortEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionPortEqualTo(Collection<Integer> values) {
      impl.setPropertyValues(INSTANCE.getConnectionPortEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getConnectionProtocolEqualTo() {
      return impl.getPropertyValues(INSTANCE.getConnectionProtocolEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionProtocolEqualTo(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getConnectionProtocolEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<LogRecordType> getLogRecordType() {
      return impl.getPropertyValues(INSTANCE.getLogRecordTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogRecordType(Collection<LogRecordType> values) {
      impl.setPropertyValues(INSTANCE.getLogRecordTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequestTargetDNEqualTo() {
      return impl.getPropertyValues(INSTANCE.getRequestTargetDNEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequestTargetDNEqualTo(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRequestTargetDNEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequestTargetDNNotEqualTo() {
      return impl.getPropertyValues(INSTANCE.getRequestTargetDNNotEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequestTargetDNNotEqualTo(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRequestTargetDNNotEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public Integer getResponseEtimeGreaterThan() {
      return impl.getPropertyValue(INSTANCE.getResponseEtimeGreaterThanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setResponseEtimeGreaterThan(Integer value) {
      impl.setPropertyValue(INSTANCE.getResponseEtimeGreaterThanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getResponseEtimeLessThan() {
      return impl.getPropertyValue(INSTANCE.getResponseEtimeLessThanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setResponseEtimeLessThan(Integer value) {
      impl.setPropertyValue(INSTANCE.getResponseEtimeLessThanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getResponseResultCodeEqualTo() {
      return impl.getPropertyValues(INSTANCE.getResponseResultCodeEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setResponseResultCodeEqualTo(Collection<Integer> values) {
      impl.setPropertyValues(INSTANCE.getResponseResultCodeEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getResponseResultCodeNotEqualTo() {
      return impl.getPropertyValues(INSTANCE.getResponseResultCodeNotEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setResponseResultCodeNotEqualTo(Collection<Integer> values) {
      impl.setPropertyValues(INSTANCE.getResponseResultCodeNotEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public Boolean isSearchResponseIsIndexed() {
      return impl.getPropertyValue(INSTANCE.getSearchResponseIsIndexedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSearchResponseIsIndexed(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSearchResponseIsIndexedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getSearchResponseNentriesGreaterThan() {
      return impl.getPropertyValue(INSTANCE.getSearchResponseNentriesGreaterThanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSearchResponseNentriesGreaterThan(Integer value) {
      impl.setPropertyValue(INSTANCE.getSearchResponseNentriesGreaterThanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getSearchResponseNentriesLessThan() {
      return impl.getPropertyValue(INSTANCE.getSearchResponseNentriesLessThanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSearchResponseNentriesLessThan(Integer value) {
      impl.setPropertyValue(INSTANCE.getSearchResponseNentriesLessThanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getUserDNEqualTo() {
      return impl.getPropertyValues(INSTANCE.getUserDNEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserDNEqualTo(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getUserDNEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getUserDNNotEqualTo() {
      return impl.getPropertyValues(INSTANCE.getUserDNNotEqualToPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserDNNotEqualTo(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getUserDNNotEqualToPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserIsMemberOf() {
      return impl.getPropertyValues(INSTANCE.getUserIsMemberOfPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserIsMemberOf(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getUserIsMemberOfPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserIsNotMemberOf() {
      return impl.getPropertyValues(INSTANCE.getUserIsNotMemberOfPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserIsNotMemberOf(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getUserIsNotMemberOfPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends AccessLogFilteringCriteriaCfgClient, ? extends AccessLogFilteringCriteriaCfg> definition() {
      return INSTANCE;
    }



    /** {@inheritDoc} */
    public PropertyProvider properties() {
      return impl;
    }



    /** {@inheritDoc} */
    public void commit() throws ManagedObjectAlreadyExistsException,
        MissingMandatoryPropertiesException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.commit();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }



  /**
   * Managed object server implementation.
   */
  private static class AccessLogFilteringCriteriaCfgServerImpl implements
    AccessLogFilteringCriteriaCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends AccessLogFilteringCriteriaCfg> impl;

    /** The value of the "connection-client-address-equal-to" property. */
    private final SortedSet<AddressMask> pConnectionClientAddressEqualTo;

    /** The value of the "connection-client-address-not-equal-to" property. */
    private final SortedSet<AddressMask> pConnectionClientAddressNotEqualTo;

    /** The value of the "connection-port-equal-to" property. */
    private final SortedSet<Integer> pConnectionPortEqualTo;

    /** The value of the "connection-protocol-equal-to" property. */
    private final SortedSet<String> pConnectionProtocolEqualTo;

    /** The value of the "log-record-type" property. */
    private final SortedSet<LogRecordType> pLogRecordType;

    /** The value of the "request-target-dn-equal-to" property. */
    private final SortedSet<String> pRequestTargetDNEqualTo;

    /** The value of the "request-target-dn-not-equal-to" property. */
    private final SortedSet<String> pRequestTargetDNNotEqualTo;

    /** The value of the "response-etime-greater-than" property. */
    private final Integer pResponseEtimeGreaterThan;

    /** The value of the "response-etime-less-than" property. */
    private final Integer pResponseEtimeLessThan;

    /** The value of the "response-result-code-equal-to" property. */
    private final SortedSet<Integer> pResponseResultCodeEqualTo;

    /** The value of the "response-result-code-not-equal-to" property. */
    private final SortedSet<Integer> pResponseResultCodeNotEqualTo;

    /** The value of the "search-response-is-indexed" property. */
    private final Boolean pSearchResponseIsIndexed;

    /** The value of the "search-response-nentries-greater-than" property. */
    private final Integer pSearchResponseNentriesGreaterThan;

    /** The value of the "search-response-nentries-less-than" property. */
    private final Integer pSearchResponseNentriesLessThan;

    /** The value of the "user-dn-equal-to" property. */
    private final SortedSet<String> pUserDNEqualTo;

    /** The value of the "user-dn-not-equal-to" property. */
    private final SortedSet<String> pUserDNNotEqualTo;

    /** The value of the "user-is-member-of" property. */
    private final SortedSet<DN> pUserIsMemberOf;

    /** The value of the "user-is-not-member-of" property. */
    private final SortedSet<DN> pUserIsNotMemberOf;



    /** Private constructor. */
    private AccessLogFilteringCriteriaCfgServerImpl(ServerManagedObject<? extends AccessLogFilteringCriteriaCfg> impl) {
      this.impl = impl;
      this.pConnectionClientAddressEqualTo = impl.getPropertyValues(INSTANCE.getConnectionClientAddressEqualToPropertyDefinition());
      this.pConnectionClientAddressNotEqualTo = impl.getPropertyValues(INSTANCE.getConnectionClientAddressNotEqualToPropertyDefinition());
      this.pConnectionPortEqualTo = impl.getPropertyValues(INSTANCE.getConnectionPortEqualToPropertyDefinition());
      this.pConnectionProtocolEqualTo = impl.getPropertyValues(INSTANCE.getConnectionProtocolEqualToPropertyDefinition());
      this.pLogRecordType = impl.getPropertyValues(INSTANCE.getLogRecordTypePropertyDefinition());
      this.pRequestTargetDNEqualTo = impl.getPropertyValues(INSTANCE.getRequestTargetDNEqualToPropertyDefinition());
      this.pRequestTargetDNNotEqualTo = impl.getPropertyValues(INSTANCE.getRequestTargetDNNotEqualToPropertyDefinition());
      this.pResponseEtimeGreaterThan = impl.getPropertyValue(INSTANCE.getResponseEtimeGreaterThanPropertyDefinition());
      this.pResponseEtimeLessThan = impl.getPropertyValue(INSTANCE.getResponseEtimeLessThanPropertyDefinition());
      this.pResponseResultCodeEqualTo = impl.getPropertyValues(INSTANCE.getResponseResultCodeEqualToPropertyDefinition());
      this.pResponseResultCodeNotEqualTo = impl.getPropertyValues(INSTANCE.getResponseResultCodeNotEqualToPropertyDefinition());
      this.pSearchResponseIsIndexed = impl.getPropertyValue(INSTANCE.getSearchResponseIsIndexedPropertyDefinition());
      this.pSearchResponseNentriesGreaterThan = impl.getPropertyValue(INSTANCE.getSearchResponseNentriesGreaterThanPropertyDefinition());
      this.pSearchResponseNentriesLessThan = impl.getPropertyValue(INSTANCE.getSearchResponseNentriesLessThanPropertyDefinition());
      this.pUserDNEqualTo = impl.getPropertyValues(INSTANCE.getUserDNEqualToPropertyDefinition());
      this.pUserDNNotEqualTo = impl.getPropertyValues(INSTANCE.getUserDNNotEqualToPropertyDefinition());
      this.pUserIsMemberOf = impl.getPropertyValues(INSTANCE.getUserIsMemberOfPropertyDefinition());
      this.pUserIsNotMemberOf = impl.getPropertyValues(INSTANCE.getUserIsNotMemberOfPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getConnectionClientAddressEqualTo() {
      return pConnectionClientAddressEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getConnectionClientAddressNotEqualTo() {
      return pConnectionClientAddressNotEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getConnectionPortEqualTo() {
      return pConnectionPortEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getConnectionProtocolEqualTo() {
      return pConnectionProtocolEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<LogRecordType> getLogRecordType() {
      return pLogRecordType;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequestTargetDNEqualTo() {
      return pRequestTargetDNEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequestTargetDNNotEqualTo() {
      return pRequestTargetDNNotEqualTo;
    }



    /** {@inheritDoc} */
    public Integer getResponseEtimeGreaterThan() {
      return pResponseEtimeGreaterThan;
    }



    /** {@inheritDoc} */
    public Integer getResponseEtimeLessThan() {
      return pResponseEtimeLessThan;
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getResponseResultCodeEqualTo() {
      return pResponseResultCodeEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<Integer> getResponseResultCodeNotEqualTo() {
      return pResponseResultCodeNotEqualTo;
    }



    /** {@inheritDoc} */
    public Boolean isSearchResponseIsIndexed() {
      return pSearchResponseIsIndexed;
    }



    /** {@inheritDoc} */
    public Integer getSearchResponseNentriesGreaterThan() {
      return pSearchResponseNentriesGreaterThan;
    }



    /** {@inheritDoc} */
    public Integer getSearchResponseNentriesLessThan() {
      return pSearchResponseNentriesLessThan;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getUserDNEqualTo() {
      return pUserDNEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getUserDNNotEqualTo() {
      return pUserDNNotEqualTo;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserIsMemberOf() {
      return pUserIsMemberOf;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserIsNotMemberOf() {
      return pUserIsNotMemberOf;
    }



    /** {@inheritDoc} */
    public Class<? extends AccessLogFilteringCriteriaCfg> configurationClass() {
      return AccessLogFilteringCriteriaCfg.class;
    }



    /** {@inheritDoc} */
    public DN dn() {
      return impl.getDN();
    }



    /** {@inheritDoc} */
    public String name() {
      return impl.getName();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }
}
