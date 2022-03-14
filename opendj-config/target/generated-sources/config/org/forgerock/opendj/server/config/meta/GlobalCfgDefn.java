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
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.GlobalCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.client.PasswordPolicyCfgClient;
import org.forgerock.opendj.server.config.server.GlobalCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.PasswordPolicyCfg;



/**
 * An interface for querying the Global Configuration managed object
 * definition meta information.
 * <p>
 * The Global Configuration contains properties that affect the
 * overall operation of the OpenDJ.
 */
public final class GlobalCfgDefn extends ManagedObjectDefinition<GlobalCfgClient, GlobalCfg> {

  /** The singleton configuration definition instance. */
  private static final GlobalCfgDefn INSTANCE = new GlobalCfgDefn();



  /**
   * Defines the set of permissable values for the "disabled-privilege" property.
   * <p>
   * Specifies the name of a privilege that should not be evaluated by
   * the server.
   * <p>
   * If a privilege is disabled, then it is assumed that all clients
   * (including unauthenticated clients) have that privilege.
   */
  public static enum DisabledPrivilege {

    /**
     * Allows the user to request that the server process backup
     * tasks.
     */
    BACKEND_BACKUP("backend-backup"),



    /**
     * Allows the user to request that the server process restore
     * tasks.
     */
    BACKEND_RESTORE("backend-restore"),



    /**
     * Allows the associated user to bypass access control checks
     * performed by the server.
     */
    BYPASS_ACL("bypass-acl"),



    /**
     * Allows the associated user to bypass server lockdown mode.
     */
    BYPASS_LOCKDOWN("bypass-lockdown"),



    /**
     * Allows the user to cancel operations in progress on other
     * client connections.
     */
    CANCEL_REQUEST("cancel-request"),



    /**
     * The privilege that provides the ability to perform read
     * operations on the changelog
     */
    CHANGELOG_READ("changelog-read"),



    /**
     * Allows the associated user to read the server configuration.
     */
    CONFIG_READ("config-read"),



    /**
     * Allows the associated user to update the server configuration.
     * The config-read privilege is also required.
     */
    CONFIG_WRITE("config-write"),



    /**
     * Allows the user to participate in data synchronization.
     */
    DATA_SYNC("data-sync"),



    /**
     * Allows the user to terminate other client connections.
     */
    DISCONNECT_CLIENT("disconnect-client"),



    /**
     * Allows the associated user to subscribe to receive JMX
     * notifications.
     */
    JMX_NOTIFY("jmx-notify"),



    /**
     * Allows the associated user to perform JMX read operations.
     */
    JMX_READ("jmx-read"),



    /**
     * Allows the associated user to perform JMX write operations.
     */
    JMX_WRITE("jmx-write"),



    /**
     * Allows the user to request that the server process LDIF export
     * tasks.
     */
    LDIF_EXPORT("ldif-export"),



    /**
     * Allows the user to request that the server process LDIF import
     * tasks.
     */
    LDIF_IMPORT("ldif-import"),



    /**
     * Allows the associated user to modify the server's access
     * control configuration.
     */
    MODIFY_ACL("modify-acl"),



    /**
     * Allows the user to reset user passwords.
     */
    PASSWORD_RESET("password-reset"),



    /**
     * Allows the user to make changes to the set of defined root
     * privileges, as well as to grant and revoke privileges for users.
     */
    PRIVILEGE_CHANGE("privilege-change"),



    /**
     * Allows the user to use the proxied authorization control, or to
     * perform a bind that specifies an alternate authorization
     * identity.
     */
    PROXIED_AUTH("proxied-auth"),



    /**
     * Allows the user to place and bring the server of lockdown mode.
     */
    SERVER_LOCKDOWN("server-lockdown"),



    /**
     * Allows the user to request that the server perform an in-core
     * restart.
     */
    SERVER_RESTART("server-restart"),



    /**
     * Allows the user to request that the server shut down.
     */
    SERVER_SHUTDOWN("server-shutdown"),



    /**
     * Allows the associated user to perform LDAP subentry write
     * operations.
     */
    SUBENTRY_WRITE("subentry-write"),



    /**
     * Allows the user to request that the server process a search
     * that cannot be optimized using server indexes.
     */
    UNINDEXED_SEARCH("unindexed-search"),



    /**
     * Allows the user to make changes to the server schema.
     */
    UPDATE_SCHEMA("update-schema");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private DisabledPrivilege(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /**
   * Defines the set of permissable values for the "etime-resolution" property.
   * <p>
   * Specifies the resolution to use for operation elapsed processing
   * time (etime) measurements.
   */
  public static enum EtimeResolution {

    /**
     * Use millisecond resolution.
     */
    MILLISECONDS("milliseconds"),



    /**
     * Use nanosecond resolution.
     */
    NANOSECONDS("nanoseconds");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private EtimeResolution(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /**
   * Defines the set of permissable values for the "invalid-attribute-syntax-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations
   * whenever an attribute value violates the associated attribute
   * syntax.
   */
  public static enum InvalidAttributeSyntaxBehavior {

    /**
     * The directory server silently accepts attribute values that are
     * invalid according to their associated syntax. Matching
     * operations targeting those values may not behave as expected.
     */
    ACCEPT("accept"),



    /**
     * The directory server rejects attribute values that are invalid
     * according to their associated syntax.
     */
    REJECT("reject"),



    /**
     * The directory server accepts attribute values that are invalid
     * according to their associated syntax, but also logs a warning
     * message to the error log. Matching operations targeting those
     * values may not behave as expected.
     */
    WARN("warn");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private InvalidAttributeSyntaxBehavior(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /**
   * Defines the set of permissable values for the "single-structural-objectclass-behavior" property.
   * <p>
   * Specifies how the directory server should handle operations an
   * entry does not contain a structural object class or contains
   * multiple structural classes.
   */
  public static enum SingleStructuralObjectclassBehavior {

    /**
     * The directory server silently accepts entries that do not
     * contain exactly one structural object class. Certain schema
     * features that depend on the entry's structural class may not
     * behave as expected.
     */
    ACCEPT("accept"),



    /**
     * The directory server rejects entries that do not contain
     * exactly one structural object class.
     */
    REJECT("reject"),



    /**
     * The directory server accepts entries that do not contain
     * exactly one structural object class, but also logs a warning
     * message to the error log. Certain schema features that depend on
     * the entry's structural class may not behave as expected.
     */
    WARN("warn");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private SingleStructuralObjectclassBehavior(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /**
   * Defines the set of permissable values for the "writability-mode" property.
   * <p>
   * Specifies the kinds of write operations the directory server can
   * process.
   */
  public static enum WritabilityMode {

    /**
     * The directory server rejects all write operations that are
     * requested of it, regardless of their origin.
     */
    DISABLED("disabled"),



    /**
     * The directory server attempts to process all write operations
     * that are requested of it, regardless of their origin.
     */
    ENABLED("enabled"),



    /**
     * The directory server attempts to process write operations
     * requested as internal operations or through synchronization, but
     * rejects any such operations requested from external clients.
     */
    INTERNAL_ONLY("internal-only");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private WritabilityMode(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "add-missing-rdn-attributes" property definition. */
  private static final BooleanPropertyDefinition PD_ADD_MISSING_RDN_ATTRIBUTES;



  /** The "allow-attribute-name-exceptions" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_ATTRIBUTE_NAME_EXCEPTIONS;



  /** The "allowed-task" property definition. */
  private static final StringPropertyDefinition PD_ALLOWED_TASK;



  /** The "bind-with-dn-requires-password" property definition. */
  private static final BooleanPropertyDefinition PD_BIND_WITH_DN_REQUIRES_PASSWORD;



  /** The "check-schema" property definition. */
  private static final BooleanPropertyDefinition PD_CHECK_SCHEMA;



  /** The "default-password-policy" property definition. */
  private static final AggregationPropertyDefinition<PasswordPolicyCfgClient, PasswordPolicyCfg> PD_DEFAULT_PASSWORD_POLICY;



  /** The "disabled-privilege" property definition. */
  private static final EnumPropertyDefinition<DisabledPrivilege> PD_DISABLED_PRIVILEGE;



  /** The "etime-resolution" property definition. */
  private static final EnumPropertyDefinition<EtimeResolution> PD_ETIME_RESOLUTION;



  /** The "idle-time-limit" property definition. */
  private static final DurationPropertyDefinition PD_IDLE_TIME_LIMIT;



  /** The "invalid-attribute-syntax-behavior" property definition. */
  private static final EnumPropertyDefinition<InvalidAttributeSyntaxBehavior> PD_INVALID_ATTRIBUTE_SYNTAX_BEHAVIOR;



  /** The "lookthrough-limit" property definition. */
  private static final IntegerPropertyDefinition PD_LOOKTHROUGH_LIMIT;



  /** The "max-allowed-client-connections" property definition. */
  private static final IntegerPropertyDefinition PD_MAX_ALLOWED_CLIENT_CONNECTIONS;



  /** The "max-internal-buffer-size" property definition. */
  private static final SizePropertyDefinition PD_MAX_INTERNAL_BUFFER_SIZE;



  /** The "max-psearches" property definition. */
  private static final IntegerPropertyDefinition PD_MAX_PSEARCHES;



  /** The "notify-abandoned-operations" property definition. */
  private static final BooleanPropertyDefinition PD_NOTIFY_ABANDONED_OPERATIONS;



  /** The "proxied-authorization-identity-mapper" property definition. */
  private static final AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> PD_PROXIED_AUTHORIZATION_IDENTITY_MAPPER;



  /** The "reject-unauthenticated-requests" property definition. */
  private static final BooleanPropertyDefinition PD_REJECT_UNAUTHENTICATED_REQUESTS;



  /** The "return-bind-error-messages" property definition. */
  private static final BooleanPropertyDefinition PD_RETURN_BIND_ERROR_MESSAGES;



  /** The "save-config-on-successful-startup" property definition. */
  private static final BooleanPropertyDefinition PD_SAVE_CONFIG_ON_SUCCESSFUL_STARTUP;



  /** The "server-error-result-code" property definition. */
  private static final IntegerPropertyDefinition PD_SERVER_ERROR_RESULT_CODE;



  /** The "single-structural-objectclass-behavior" property definition. */
  private static final EnumPropertyDefinition<SingleStructuralObjectclassBehavior> PD_SINGLE_STRUCTURAL_OBJECTCLASS_BEHAVIOR;



  /** The "size-limit" property definition. */
  private static final IntegerPropertyDefinition PD_SIZE_LIMIT;



  /** The "smtp-server" property definition. */
  private static final StringPropertyDefinition PD_SMTP_SERVER;



  /** The "subordinate-base-dn" property definition. */
  private static final DNPropertyDefinition PD_SUBORDINATE_BASE_DN;



  /** The "time-limit" property definition. */
  private static final DurationPropertyDefinition PD_TIME_LIMIT;



  /** The "trust-transaction-ids" property definition. */
  private static final BooleanPropertyDefinition PD_TRUST_TRANSACTION_IDS;



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** Build the "add-missing-rdn-attributes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "add-missing-rdn-attributes");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "add-missing-rdn-attributes"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_ADD_MISSING_RDN_ATTRIBUTES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ADD_MISSING_RDN_ATTRIBUTES);
  }



  /** Build the "allow-attribute-name-exceptions" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-attribute-name-exceptions");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-attribute-name-exceptions"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_ATTRIBUTE_NAME_EXCEPTIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_ATTRIBUTE_NAME_EXCEPTIONS);
  }



  /** Build the "allowed-task" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "allowed-task");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allowed-task"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "allowed-task"));
      PD_ALLOWED_TASK = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOWED_TASK);
  }



  /** Build the "bind-with-dn-requires-password" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "bind-with-dn-requires-password");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "bind-with-dn-requires-password"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_BIND_WITH_DN_REQUIRES_PASSWORD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BIND_WITH_DN_REQUIRES_PASSWORD);
  }



  /** Build the "check-schema" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "check-schema");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "check-schema"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_CHECK_SCHEMA = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHECK_SCHEMA);
  }



  /** Build the "default-password-policy" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordPolicyCfgClient, PasswordPolicyCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "default-password-policy");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-password-policy"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-policy");
      PD_DEFAULT_PASSWORD_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_PASSWORD_POLICY);
      INSTANCE.registerConstraint(PD_DEFAULT_PASSWORD_POLICY.getSourceConstraint());
  }



  /** Build the "disabled-privilege" property definition. */
  static {
      EnumPropertyDefinition.Builder<DisabledPrivilege> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "disabled-privilege");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disabled-privilege"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DisabledPrivilege>(INSTANCE, "disabled-privilege"));
      builder.setEnumClass(DisabledPrivilege.class);
      PD_DISABLED_PRIVILEGE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISABLED_PRIVILEGE);
  }



  /** Build the "etime-resolution" property definition. */
  static {
      EnumPropertyDefinition.Builder<EtimeResolution> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "etime-resolution");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "etime-resolution"));
      DefaultBehaviorProvider<EtimeResolution> provider = new DefinedDefaultBehaviorProvider<EtimeResolution>("milliseconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(EtimeResolution.class);
      PD_ETIME_RESOLUTION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ETIME_RESOLUTION);
  }



  /** Build the "idle-time-limit" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "idle-time-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "idle-time-limit"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("0");
      PD_IDLE_TIME_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IDLE_TIME_LIMIT);
  }



  /** Build the "invalid-attribute-syntax-behavior" property definition. */
  static {
      EnumPropertyDefinition.Builder<InvalidAttributeSyntaxBehavior> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "invalid-attribute-syntax-behavior");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "invalid-attribute-syntax-behavior"));
      DefaultBehaviorProvider<InvalidAttributeSyntaxBehavior> provider = new DefinedDefaultBehaviorProvider<InvalidAttributeSyntaxBehavior>("reject");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(InvalidAttributeSyntaxBehavior.class);
      PD_INVALID_ATTRIBUTE_SYNTAX_BEHAVIOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INVALID_ATTRIBUTE_SYNTAX_BEHAVIOR);
  }



  /** Build the "lookthrough-limit" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "lookthrough-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "lookthrough-limit"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("5000");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(0);
      PD_LOOKTHROUGH_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOOKTHROUGH_LIMIT);
  }



  /** Build the "max-allowed-client-connections" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "max-allowed-client-connections");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-allowed-client-connections"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(0);
      PD_MAX_ALLOWED_CLIENT_CONNECTIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_ALLOWED_CLIENT_CONNECTIONS);
  }



  /** Build the "max-internal-buffer-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "max-internal-buffer-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-internal-buffer-size"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("32 KB");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("1 GB");
      builder.setLowerLimit("512 B");
      PD_MAX_INTERNAL_BUFFER_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_INTERNAL_BUFFER_SIZE);
  }



  /** Build the "max-psearches" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "max-psearches");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-psearches"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("-1");
      builder.setDefaultBehaviorProvider(provider);
      builder.setAllowUnlimited(true);
      builder.setLowerLimit(0);
      PD_MAX_PSEARCHES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_PSEARCHES);
  }



  /** Build the "notify-abandoned-operations" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "notify-abandoned-operations");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "notify-abandoned-operations"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_NOTIFY_ABANDONED_OPERATIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NOTIFY_ABANDONED_OPERATIONS);
  }



  /** Build the "proxied-authorization-identity-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<IdentityMapperCfgClient, IdentityMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "proxied-authorization-identity-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "proxied-authorization-identity-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("identity-mapper");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_PROXIED_AUTHORIZATION_IDENTITY_MAPPER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PROXIED_AUTHORIZATION_IDENTITY_MAPPER);
      INSTANCE.registerConstraint(PD_PROXIED_AUTHORIZATION_IDENTITY_MAPPER.getSourceConstraint());
  }



  /** Build the "reject-unauthenticated-requests" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "reject-unauthenticated-requests");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "reject-unauthenticated-requests"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_REJECT_UNAUTHENTICATED_REQUESTS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REJECT_UNAUTHENTICATED_REQUESTS);
  }



  /** Build the "return-bind-error-messages" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "return-bind-error-messages");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "return-bind-error-messages"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_RETURN_BIND_ERROR_MESSAGES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RETURN_BIND_ERROR_MESSAGES);
  }



  /** Build the "save-config-on-successful-startup" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "save-config-on-successful-startup");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "save-config-on-successful-startup"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_SAVE_CONFIG_ON_SUCCESSFUL_STARTUP = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SAVE_CONFIG_ON_SUCCESSFUL_STARTUP);
  }



  /** Build the "server-error-result-code" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "server-error-result-code");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "server-error-result-code"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("80");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(0);
      PD_SERVER_ERROR_RESULT_CODE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SERVER_ERROR_RESULT_CODE);
  }



  /** Build the "single-structural-objectclass-behavior" property definition. */
  static {
      EnumPropertyDefinition.Builder<SingleStructuralObjectclassBehavior> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "single-structural-objectclass-behavior");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "single-structural-objectclass-behavior"));
      DefaultBehaviorProvider<SingleStructuralObjectclassBehavior> provider = new DefinedDefaultBehaviorProvider<SingleStructuralObjectclassBehavior>("reject");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(SingleStructuralObjectclassBehavior.class);
      PD_SINGLE_STRUCTURAL_OBJECTCLASS_BEHAVIOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SINGLE_STRUCTURAL_OBJECTCLASS_BEHAVIOR);
  }



  /** Build the "size-limit" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "size-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "size-limit"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("1000");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(0);
      PD_SIZE_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SIZE_LIMIT);
  }



  /** Build the "smtp-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "smtp-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "smtp-server"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "smtp-server"));
      builder.setPattern("^.+(:[0-9]+)?$", "HOST[:PORT]");
      PD_SMTP_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SMTP_SERVER);
  }



  /** Build the "subordinate-base-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "subordinate-base-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "subordinate-base-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "subordinate-base-dn"));
      PD_SUBORDINATE_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SUBORDINATE_BASE_DN);
  }



  /** Build the "time-limit" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "time-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "time-limit"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("60 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setLowerLimit("0");
      PD_TIME_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TIME_LIMIT);
  }



  /** Build the "trust-transaction-ids" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "trust-transaction-ids");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-transaction-ids"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_TRUST_TRANSACTION_IDS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_TRANSACTION_IDS);
  }



  /** Build the "writability-mode" property definition. */
  static {
      EnumPropertyDefinition.Builder<WritabilityMode> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "writability-mode");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "writability-mode"));
      DefaultBehaviorProvider<WritabilityMode> provider = new DefinedDefaultBehaviorProvider<WritabilityMode>("enabled");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(WritabilityMode.class);
      PD_WRITABILITY_MODE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_WRITABILITY_MODE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Global Configuration configuration definition singleton.
   *
   * @return Returns the Global Configuration configuration definition
   *         singleton.
   */
  public static GlobalCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private GlobalCfgDefn() {
    super("global", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public GlobalCfgClient createClientConfiguration(
      ManagedObject<? extends GlobalCfgClient> impl) {
    return new GlobalCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public GlobalCfg createServerConfiguration(
      ServerManagedObject<? extends GlobalCfg> impl) {
    return new GlobalCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<GlobalCfg> getServerConfigurationClass() {
    return GlobalCfg.class;
  }



  /**
   * Get the "add-missing-rdn-attributes" property definition.
   * <p>
   * Indicates whether the directory server should automatically add
   * any attribute values contained in the entry's RDN into that entry
   * when processing an add request.
   *
   * @return Returns the "add-missing-rdn-attributes" property definition.
   */
  public BooleanPropertyDefinition getAddMissingRDNAttributesPropertyDefinition() {
    return PD_ADD_MISSING_RDN_ATTRIBUTES;
  }



  /**
   * Get the "allow-attribute-name-exceptions" property definition.
   * <p>
   * Indicates whether the directory server should allow underscores
   * in attribute names and allow attribute names to begin with numeric
   * digits (both of which are violations of the LDAP standards).
   *
   * @return Returns the "allow-attribute-name-exceptions" property definition.
   */
  public BooleanPropertyDefinition getAllowAttributeNameExceptionsPropertyDefinition() {
    return PD_ALLOW_ATTRIBUTE_NAME_EXCEPTIONS;
  }



  /**
   * Get the "allowed-task" property definition.
   * <p>
   * Specifies the fully-qualified name of a Java class that may be
   * invoked in the server.
   * <p>
   * Any attempt to invoke a task not included in the list of allowed
   * tasks is rejected.
   *
   * @return Returns the "allowed-task" property definition.
   */
  public StringPropertyDefinition getAllowedTaskPropertyDefinition() {
    return PD_ALLOWED_TASK;
  }



  /**
   * Get the "bind-with-dn-requires-password" property definition.
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
   * @return Returns the "bind-with-dn-requires-password" property definition.
   */
  public BooleanPropertyDefinition getBindWithDNRequiresPasswordPropertyDefinition() {
    return PD_BIND_WITH_DN_REQUIRES_PASSWORD;
  }



  /**
   * Get the "check-schema" property definition.
   * <p>
   * Indicates whether schema enforcement is active.
   * <p>
   * When schema enforcement is activated, the directory server
   * ensures that all operations result in entries are valid according
   * to the defined server schema. It is strongly recommended that this
   * option be left enabled to prevent the inadvertent addition of
   * invalid data into the server.
   *
   * @return Returns the "check-schema" property definition.
   */
  public BooleanPropertyDefinition getCheckSchemaPropertyDefinition() {
    return PD_CHECK_SCHEMA;
  }



  /**
   * Get the "default-password-policy" property definition.
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
   * @return Returns the "default-password-policy" property definition.
   */
  public AggregationPropertyDefinition<PasswordPolicyCfgClient, PasswordPolicyCfg> getDefaultPasswordPolicyPropertyDefinition() {
    return PD_DEFAULT_PASSWORD_POLICY;
  }



  /**
   * Get the "disabled-privilege" property definition.
   * <p>
   * Specifies the name of a privilege that should not be evaluated by
   * the server.
   * <p>
   * If a privilege is disabled, then it is assumed that all clients
   * (including unauthenticated clients) have that privilege.
   *
   * @return Returns the "disabled-privilege" property definition.
   */
  public EnumPropertyDefinition<DisabledPrivilege> getDisabledPrivilegePropertyDefinition() {
    return PD_DISABLED_PRIVILEGE;
  }



  /**
   * Get the "etime-resolution" property definition.
   * <p>
   * Specifies the resolution to use for operation elapsed processing
   * time (etime) measurements.
   *
   * @return Returns the "etime-resolution" property definition.
   */
  public EnumPropertyDefinition<EtimeResolution> getEtimeResolutionPropertyDefinition() {
    return PD_ETIME_RESOLUTION;
  }



  /**
   * Get the "idle-time-limit" property definition.
   * <p>
   * Specifies the maximum length of time that a client connection may
   * remain established since its last completed operation.
   * <p>
   * A value of "0 seconds" indicates that no idle time limit is
   * enforced.
   *
   * @return Returns the "idle-time-limit" property definition.
   */
  public DurationPropertyDefinition getIdleTimeLimitPropertyDefinition() {
    return PD_IDLE_TIME_LIMIT;
  }



  /**
   * Get the "invalid-attribute-syntax-behavior" property definition.
   * <p>
   * Specifies how the directory server should handle operations
   * whenever an attribute value violates the associated attribute
   * syntax.
   *
   * @return Returns the "invalid-attribute-syntax-behavior" property definition.
   */
  public EnumPropertyDefinition<InvalidAttributeSyntaxBehavior> getInvalidAttributeSyntaxBehaviorPropertyDefinition() {
    return PD_INVALID_ATTRIBUTE_SYNTAX_BEHAVIOR;
  }



  /**
   * Get the "lookthrough-limit" property definition.
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
   * @return Returns the "lookthrough-limit" property definition.
   */
  public IntegerPropertyDefinition getLookthroughLimitPropertyDefinition() {
    return PD_LOOKTHROUGH_LIMIT;
  }



  /**
   * Get the "max-allowed-client-connections" property definition.
   * <p>
   * Specifies the maximum number of client connections that may be
   * established at any given time
   * <p>
   * A value of 0 indicates that unlimited client connection is
   * allowed.
   *
   * @return Returns the "max-allowed-client-connections" property definition.
   */
  public IntegerPropertyDefinition getMaxAllowedClientConnectionsPropertyDefinition() {
    return PD_MAX_ALLOWED_CLIENT_CONNECTIONS;
  }



  /**
   * Get the "max-internal-buffer-size" property definition.
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
   * @return Returns the "max-internal-buffer-size" property definition.
   */
  public SizePropertyDefinition getMaxInternalBufferSizePropertyDefinition() {
    return PD_MAX_INTERNAL_BUFFER_SIZE;
  }



  /**
   * Get the "max-psearches" property definition.
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
   * @return Returns the "max-psearches" property definition.
   */
  public IntegerPropertyDefinition getMaxPsearchesPropertyDefinition() {
    return PD_MAX_PSEARCHES;
  }



  /**
   * Get the "notify-abandoned-operations" property definition.
   * <p>
   * Indicates whether the directory server should send a response to
   * any operation that is interrupted via an abandon request.
   * <p>
   * The LDAP specification states that abandoned operations should
   * not receive any response, but this may cause problems with client
   * applications that always expect to receive a response to each
   * request.
   *
   * @return Returns the "notify-abandoned-operations" property definition.
   */
  public BooleanPropertyDefinition getNotifyAbandonedOperationsPropertyDefinition() {
    return PD_NOTIFY_ABANDONED_OPERATIONS;
  }



  /**
   * Get the "proxied-authorization-identity-mapper" property definition.
   * <p>
   * Specifies the name of the identity mapper to map authorization ID
   * values (using the "u:" form) provided in the proxied authorization
   * control to the corresponding user entry.
   *
   * @return Returns the "proxied-authorization-identity-mapper" property definition.
   */
  public AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> getProxiedAuthorizationIdentityMapperPropertyDefinition() {
    return PD_PROXIED_AUTHORIZATION_IDENTITY_MAPPER;
  }



  /**
   * Get the "reject-unauthenticated-requests" property definition.
   * <p>
   * Indicates whether the directory server should reject any request
   * (other than bind or StartTLS requests) received from a client that
   * has not yet been authenticated, whose last authentication attempt
   * was unsuccessful, or whose last authentication attempt used
   * anonymous authentication.
   *
   * @return Returns the "reject-unauthenticated-requests" property definition.
   */
  public BooleanPropertyDefinition getRejectUnauthenticatedRequestsPropertyDefinition() {
    return PD_REJECT_UNAUTHENTICATED_REQUESTS;
  }



  /**
   * Get the "return-bind-error-messages" property definition.
   * <p>
   * Indicates whether responses for failed bind operations should
   * include a message string providing the reason for the
   * authentication failure.
   * <p>
   * Note that these messages may include information that could
   * potentially be used by an attacker. If this option is disabled,
   * then these messages appears only in the server's access log.
   *
   * @return Returns the "return-bind-error-messages" property definition.
   */
  public BooleanPropertyDefinition getReturnBindErrorMessagesPropertyDefinition() {
    return PD_RETURN_BIND_ERROR_MESSAGES;
  }



  /**
   * Get the "save-config-on-successful-startup" property definition.
   * <p>
   * Indicates whether the directory server should save a copy of its
   * configuration whenever the startup process completes successfully.
   * <p>
   * This ensures that the server provides a "last known good"
   * configuration, which can be used as a reference (or copied into
   * the active config) if the server fails to start with the current
   * "active" configuration.
   *
   * @return Returns the "save-config-on-successful-startup" property definition.
   */
  public BooleanPropertyDefinition getSaveConfigOnSuccessfulStartupPropertyDefinition() {
    return PD_SAVE_CONFIG_ON_SUCCESSFUL_STARTUP;
  }



  /**
   * Get the "server-error-result-code" property definition.
   * <p>
   * Specifies the numeric value of the result code when request
   * processing fails due to an internal server error.
   *
   * @return Returns the "server-error-result-code" property definition.
   */
  public IntegerPropertyDefinition getServerErrorResultCodePropertyDefinition() {
    return PD_SERVER_ERROR_RESULT_CODE;
  }



  /**
   * Get the "single-structural-objectclass-behavior" property definition.
   * <p>
   * Specifies how the directory server should handle operations an
   * entry does not contain a structural object class or contains
   * multiple structural classes.
   *
   * @return Returns the "single-structural-objectclass-behavior" property definition.
   */
  public EnumPropertyDefinition<SingleStructuralObjectclassBehavior> getSingleStructuralObjectclassBehaviorPropertyDefinition() {
    return PD_SINGLE_STRUCTURAL_OBJECTCLASS_BEHAVIOR;
  }



  /**
   * Get the "size-limit" property definition.
   * <p>
   * Specifies the maximum number of entries that can be returned to
   * the client during a single search operation.
   * <p>
   * A value of 0 indicates that no size limit is enforced. Note that
   * this is the default server-wide limit, but it may be overridden on
   * a per-user basis using the ds-rlim-size-limit operational
   * attribute.
   *
   * @return Returns the "size-limit" property definition.
   */
  public IntegerPropertyDefinition getSizeLimitPropertyDefinition() {
    return PD_SIZE_LIMIT;
  }



  /**
   * Get the "smtp-server" property definition.
   * <p>
   * Specifies the address (and optional port number) for a mail
   * server that can be used to send email messages via SMTP.
   * <p>
   * It may be an IP address or resolvable hostname, optionally
   * followed by a colon and a port number.
   *
   * @return Returns the "smtp-server" property definition.
   */
  public StringPropertyDefinition getSMTPServerPropertyDefinition() {
    return PD_SMTP_SERVER;
  }



  /**
   * Get the "subordinate-base-dn" property definition.
   * <p>
   * Specifies the set of base DNs used for singleLevel, wholeSubtree,
   * and subordinateSubtree searches based at the root DSE.
   *
   * @return Returns the "subordinate-base-dn" property definition.
   */
  public DNPropertyDefinition getSubordinateBaseDNPropertyDefinition() {
    return PD_SUBORDINATE_BASE_DN;
  }



  /**
   * Get the "time-limit" property definition.
   * <p>
   * Specifies the maximum length of time that should be spent
   * processing a single search operation.
   * <p>
   * A value of 0 seconds indicates that no time limit is enforced.
   * Note that this is the default server-wide time limit, but it may
   * be overridden on a per-user basis using the ds-rlim-time-limit
   * operational attribute.
   *
   * @return Returns the "time-limit" property definition.
   */
  public DurationPropertyDefinition getTimeLimitPropertyDefinition() {
    return PD_TIME_LIMIT;
  }



  /**
   * Get the "trust-transaction-ids" property definition.
   * <p>
   * Indicates whether the directory server should trust the
   * transaction ids that may be received from requests, either through
   * a LDAP control or through a HTTP header.
   *
   * @return Returns the "trust-transaction-ids" property definition.
   */
  public BooleanPropertyDefinition getTrustTransactionIdsPropertyDefinition() {
    return PD_TRUST_TRANSACTION_IDS;
  }



  /**
   * Get the "writability-mode" property definition.
   * <p>
   * Specifies the kinds of write operations the directory server can
   * process.
   *
   * @return Returns the "writability-mode" property definition.
   */
  public EnumPropertyDefinition<WritabilityMode> getWritabilityModePropertyDefinition() {
    return PD_WRITABILITY_MODE;
  }



  /**
   * Managed object client implementation.
   */
  private static class GlobalCfgClientImpl implements
    GlobalCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends GlobalCfgClient> impl;



    /** Private constructor. */
    private GlobalCfgClientImpl(
        ManagedObject<? extends GlobalCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAddMissingRDNAttributes() {
      return impl.getPropertyValue(INSTANCE.getAddMissingRDNAttributesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAddMissingRDNAttributes(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAddMissingRDNAttributesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAllowAttributeNameExceptions() {
      return impl.getPropertyValue(INSTANCE.getAllowAttributeNameExceptionsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowAttributeNameExceptions(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowAttributeNameExceptionsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedTask() {
      return impl.getPropertyValues(INSTANCE.getAllowedTaskPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowedTask(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getAllowedTaskPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isBindWithDNRequiresPassword() {
      return impl.getPropertyValue(INSTANCE.getBindWithDNRequiresPasswordPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBindWithDNRequiresPassword(Boolean value) {
      impl.setPropertyValue(INSTANCE.getBindWithDNRequiresPasswordPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isCheckSchema() {
      return impl.getPropertyValue(INSTANCE.getCheckSchemaPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCheckSchema(Boolean value) {
      impl.setPropertyValue(INSTANCE.getCheckSchemaPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getDefaultPasswordPolicy() {
      return impl.getPropertyValue(INSTANCE.getDefaultPasswordPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultPasswordPolicy(String value) {
      impl.setPropertyValue(INSTANCE.getDefaultPasswordPolicyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<DisabledPrivilege> getDisabledPrivilege() {
      return impl.getPropertyValues(INSTANCE.getDisabledPrivilegePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDisabledPrivilege(Collection<DisabledPrivilege> values) {
      impl.setPropertyValues(INSTANCE.getDisabledPrivilegePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public EtimeResolution getEtimeResolution() {
      return impl.getPropertyValue(INSTANCE.getEtimeResolutionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEtimeResolution(EtimeResolution value) {
      impl.setPropertyValue(INSTANCE.getEtimeResolutionPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getIdleTimeLimit() {
      return impl.getPropertyValue(INSTANCE.getIdleTimeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIdleTimeLimit(Long value) {
      impl.setPropertyValue(INSTANCE.getIdleTimeLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public InvalidAttributeSyntaxBehavior getInvalidAttributeSyntaxBehavior() {
      return impl.getPropertyValue(INSTANCE.getInvalidAttributeSyntaxBehaviorPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setInvalidAttributeSyntaxBehavior(InvalidAttributeSyntaxBehavior value) {
      impl.setPropertyValue(INSTANCE.getInvalidAttributeSyntaxBehaviorPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getLookthroughLimit() {
      return impl.getPropertyValue(INSTANCE.getLookthroughLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLookthroughLimit(Integer value) {
      impl.setPropertyValue(INSTANCE.getLookthroughLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getMaxAllowedClientConnections() {
      return impl.getPropertyValue(INSTANCE.getMaxAllowedClientConnectionsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxAllowedClientConnections(Integer value) {
      impl.setPropertyValue(INSTANCE.getMaxAllowedClientConnectionsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getMaxInternalBufferSize() {
      return impl.getPropertyValue(INSTANCE.getMaxInternalBufferSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxInternalBufferSize(Long value) {
      impl.setPropertyValue(INSTANCE.getMaxInternalBufferSizePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getMaxPsearches() {
      return impl.getPropertyValue(INSTANCE.getMaxPsearchesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxPsearches(Integer value) {
      impl.setPropertyValue(INSTANCE.getMaxPsearchesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isNotifyAbandonedOperations() {
      return impl.getPropertyValue(INSTANCE.getNotifyAbandonedOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setNotifyAbandonedOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getNotifyAbandonedOperationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getProxiedAuthorizationIdentityMapper() {
      return impl.getPropertyValue(INSTANCE.getProxiedAuthorizationIdentityMapperPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setProxiedAuthorizationIdentityMapper(String value) {
      impl.setPropertyValue(INSTANCE.getProxiedAuthorizationIdentityMapperPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isRejectUnauthenticatedRequests() {
      return impl.getPropertyValue(INSTANCE.getRejectUnauthenticatedRequestsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRejectUnauthenticatedRequests(Boolean value) {
      impl.setPropertyValue(INSTANCE.getRejectUnauthenticatedRequestsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isReturnBindErrorMessages() {
      return impl.getPropertyValue(INSTANCE.getReturnBindErrorMessagesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setReturnBindErrorMessages(Boolean value) {
      impl.setPropertyValue(INSTANCE.getReturnBindErrorMessagesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSaveConfigOnSuccessfulStartup() {
      return impl.getPropertyValue(INSTANCE.getSaveConfigOnSuccessfulStartupPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSaveConfigOnSuccessfulStartup(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSaveConfigOnSuccessfulStartupPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getServerErrorResultCode() {
      return impl.getPropertyValue(INSTANCE.getServerErrorResultCodePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setServerErrorResultCode(Integer value) {
      impl.setPropertyValue(INSTANCE.getServerErrorResultCodePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SingleStructuralObjectclassBehavior getSingleStructuralObjectclassBehavior() {
      return impl.getPropertyValue(INSTANCE.getSingleStructuralObjectclassBehaviorPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSingleStructuralObjectclassBehavior(SingleStructuralObjectclassBehavior value) {
      impl.setPropertyValue(INSTANCE.getSingleStructuralObjectclassBehaviorPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getSizeLimit() {
      return impl.getPropertyValue(INSTANCE.getSizeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSizeLimit(Integer value) {
      impl.setPropertyValue(INSTANCE.getSizeLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSMTPServer() {
      return impl.getPropertyValues(INSTANCE.getSMTPServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSMTPServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSMTPServerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getSubordinateBaseDN() {
      return impl.getPropertyValues(INSTANCE.getSubordinateBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSubordinateBaseDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getSubordinateBaseDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public long getTimeLimit() {
      return impl.getPropertyValue(INSTANCE.getTimeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTimeLimit(Long value) {
      impl.setPropertyValue(INSTANCE.getTimeLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isTrustTransactionIds() {
      return impl.getPropertyValue(INSTANCE.getTrustTransactionIdsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustTransactionIds(Boolean value) {
      impl.setPropertyValue(INSTANCE.getTrustTransactionIdsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setWritabilityMode(WritabilityMode value) {
      impl.setPropertyValue(INSTANCE.getWritabilityModePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends GlobalCfgClient, ? extends GlobalCfg> definition() {
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
  private static class GlobalCfgServerImpl implements
    GlobalCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends GlobalCfg> impl;

    /** The value of the "add-missing-rdn-attributes" property. */
    private final boolean pAddMissingRDNAttributes;

    /** The value of the "allow-attribute-name-exceptions" property. */
    private final boolean pAllowAttributeNameExceptions;

    /** The value of the "allowed-task" property. */
    private final SortedSet<String> pAllowedTask;

    /** The value of the "bind-with-dn-requires-password" property. */
    private final boolean pBindWithDNRequiresPassword;

    /** The value of the "check-schema" property. */
    private final boolean pCheckSchema;

    /** The value of the "default-password-policy" property. */
    private final String pDefaultPasswordPolicy;

    /** The value of the "disabled-privilege" property. */
    private final SortedSet<DisabledPrivilege> pDisabledPrivilege;

    /** The value of the "etime-resolution" property. */
    private final EtimeResolution pEtimeResolution;

    /** The value of the "idle-time-limit" property. */
    private final long pIdleTimeLimit;

    /** The value of the "invalid-attribute-syntax-behavior" property. */
    private final InvalidAttributeSyntaxBehavior pInvalidAttributeSyntaxBehavior;

    /** The value of the "lookthrough-limit" property. */
    private final int pLookthroughLimit;

    /** The value of the "max-allowed-client-connections" property. */
    private final int pMaxAllowedClientConnections;

    /** The value of the "max-internal-buffer-size" property. */
    private final long pMaxInternalBufferSize;

    /** The value of the "max-psearches" property. */
    private final int pMaxPsearches;

    /** The value of the "notify-abandoned-operations" property. */
    private final boolean pNotifyAbandonedOperations;

    /** The value of the "proxied-authorization-identity-mapper" property. */
    private final String pProxiedAuthorizationIdentityMapper;

    /** The value of the "reject-unauthenticated-requests" property. */
    private final boolean pRejectUnauthenticatedRequests;

    /** The value of the "return-bind-error-messages" property. */
    private final boolean pReturnBindErrorMessages;

    /** The value of the "save-config-on-successful-startup" property. */
    private final boolean pSaveConfigOnSuccessfulStartup;

    /** The value of the "server-error-result-code" property. */
    private final int pServerErrorResultCode;

    /** The value of the "single-structural-objectclass-behavior" property. */
    private final SingleStructuralObjectclassBehavior pSingleStructuralObjectclassBehavior;

    /** The value of the "size-limit" property. */
    private final int pSizeLimit;

    /** The value of the "smtp-server" property. */
    private final SortedSet<String> pSMTPServer;

    /** The value of the "subordinate-base-dn" property. */
    private final SortedSet<DN> pSubordinateBaseDN;

    /** The value of the "time-limit" property. */
    private final long pTimeLimit;

    /** The value of the "trust-transaction-ids" property. */
    private final boolean pTrustTransactionIds;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private GlobalCfgServerImpl(ServerManagedObject<? extends GlobalCfg> impl) {
      this.impl = impl;
      this.pAddMissingRDNAttributes = impl.getPropertyValue(INSTANCE.getAddMissingRDNAttributesPropertyDefinition());
      this.pAllowAttributeNameExceptions = impl.getPropertyValue(INSTANCE.getAllowAttributeNameExceptionsPropertyDefinition());
      this.pAllowedTask = impl.getPropertyValues(INSTANCE.getAllowedTaskPropertyDefinition());
      this.pBindWithDNRequiresPassword = impl.getPropertyValue(INSTANCE.getBindWithDNRequiresPasswordPropertyDefinition());
      this.pCheckSchema = impl.getPropertyValue(INSTANCE.getCheckSchemaPropertyDefinition());
      this.pDefaultPasswordPolicy = impl.getPropertyValue(INSTANCE.getDefaultPasswordPolicyPropertyDefinition());
      this.pDisabledPrivilege = impl.getPropertyValues(INSTANCE.getDisabledPrivilegePropertyDefinition());
      this.pEtimeResolution = impl.getPropertyValue(INSTANCE.getEtimeResolutionPropertyDefinition());
      this.pIdleTimeLimit = impl.getPropertyValue(INSTANCE.getIdleTimeLimitPropertyDefinition());
      this.pInvalidAttributeSyntaxBehavior = impl.getPropertyValue(INSTANCE.getInvalidAttributeSyntaxBehaviorPropertyDefinition());
      this.pLookthroughLimit = impl.getPropertyValue(INSTANCE.getLookthroughLimitPropertyDefinition());
      this.pMaxAllowedClientConnections = impl.getPropertyValue(INSTANCE.getMaxAllowedClientConnectionsPropertyDefinition());
      this.pMaxInternalBufferSize = impl.getPropertyValue(INSTANCE.getMaxInternalBufferSizePropertyDefinition());
      this.pMaxPsearches = impl.getPropertyValue(INSTANCE.getMaxPsearchesPropertyDefinition());
      this.pNotifyAbandonedOperations = impl.getPropertyValue(INSTANCE.getNotifyAbandonedOperationsPropertyDefinition());
      this.pProxiedAuthorizationIdentityMapper = impl.getPropertyValue(INSTANCE.getProxiedAuthorizationIdentityMapperPropertyDefinition());
      this.pRejectUnauthenticatedRequests = impl.getPropertyValue(INSTANCE.getRejectUnauthenticatedRequestsPropertyDefinition());
      this.pReturnBindErrorMessages = impl.getPropertyValue(INSTANCE.getReturnBindErrorMessagesPropertyDefinition());
      this.pSaveConfigOnSuccessfulStartup = impl.getPropertyValue(INSTANCE.getSaveConfigOnSuccessfulStartupPropertyDefinition());
      this.pServerErrorResultCode = impl.getPropertyValue(INSTANCE.getServerErrorResultCodePropertyDefinition());
      this.pSingleStructuralObjectclassBehavior = impl.getPropertyValue(INSTANCE.getSingleStructuralObjectclassBehaviorPropertyDefinition());
      this.pSizeLimit = impl.getPropertyValue(INSTANCE.getSizeLimitPropertyDefinition());
      this.pSMTPServer = impl.getPropertyValues(INSTANCE.getSMTPServerPropertyDefinition());
      this.pSubordinateBaseDN = impl.getPropertyValues(INSTANCE.getSubordinateBaseDNPropertyDefinition());
      this.pTimeLimit = impl.getPropertyValue(INSTANCE.getTimeLimitPropertyDefinition());
      this.pTrustTransactionIds = impl.getPropertyValue(INSTANCE.getTrustTransactionIdsPropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<GlobalCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<GlobalCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isAddMissingRDNAttributes() {
      return pAddMissingRDNAttributes;
    }



    /** {@inheritDoc} */
    public boolean isAllowAttributeNameExceptions() {
      return pAllowAttributeNameExceptions;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedTask() {
      return pAllowedTask;
    }



    /** {@inheritDoc} */
    public boolean isBindWithDNRequiresPassword() {
      return pBindWithDNRequiresPassword;
    }



    /** {@inheritDoc} */
    public boolean isCheckSchema() {
      return pCheckSchema;
    }



    /** {@inheritDoc} */
    public String getDefaultPasswordPolicy() {
      return pDefaultPasswordPolicy;
    }



    /**
     * {@inheritDoc}
     */
    public DN getDefaultPasswordPolicyDN() {
      String value = getDefaultPasswordPolicy();
      if (value == null) return null;
      return INSTANCE.getDefaultPasswordPolicyPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public SortedSet<DisabledPrivilege> getDisabledPrivilege() {
      return pDisabledPrivilege;
    }



    /** {@inheritDoc} */
    public EtimeResolution getEtimeResolution() {
      return pEtimeResolution;
    }



    /** {@inheritDoc} */
    public long getIdleTimeLimit() {
      return pIdleTimeLimit;
    }



    /** {@inheritDoc} */
    public InvalidAttributeSyntaxBehavior getInvalidAttributeSyntaxBehavior() {
      return pInvalidAttributeSyntaxBehavior;
    }



    /** {@inheritDoc} */
    public int getLookthroughLimit() {
      return pLookthroughLimit;
    }



    /** {@inheritDoc} */
    public int getMaxAllowedClientConnections() {
      return pMaxAllowedClientConnections;
    }



    /** {@inheritDoc} */
    public long getMaxInternalBufferSize() {
      return pMaxInternalBufferSize;
    }



    /** {@inheritDoc} */
    public int getMaxPsearches() {
      return pMaxPsearches;
    }



    /** {@inheritDoc} */
    public boolean isNotifyAbandonedOperations() {
      return pNotifyAbandonedOperations;
    }



    /** {@inheritDoc} */
    public String getProxiedAuthorizationIdentityMapper() {
      return pProxiedAuthorizationIdentityMapper;
    }



    /**
     * {@inheritDoc}
     */
    public DN getProxiedAuthorizationIdentityMapperDN() {
      String value = getProxiedAuthorizationIdentityMapper();
      if (value == null) return null;
      return INSTANCE.getProxiedAuthorizationIdentityMapperPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public boolean isRejectUnauthenticatedRequests() {
      return pRejectUnauthenticatedRequests;
    }



    /** {@inheritDoc} */
    public boolean isReturnBindErrorMessages() {
      return pReturnBindErrorMessages;
    }



    /** {@inheritDoc} */
    public boolean isSaveConfigOnSuccessfulStartup() {
      return pSaveConfigOnSuccessfulStartup;
    }



    /** {@inheritDoc} */
    public int getServerErrorResultCode() {
      return pServerErrorResultCode;
    }



    /** {@inheritDoc} */
    public SingleStructuralObjectclassBehavior getSingleStructuralObjectclassBehavior() {
      return pSingleStructuralObjectclassBehavior;
    }



    /** {@inheritDoc} */
    public int getSizeLimit() {
      return pSizeLimit;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSMTPServer() {
      return pSMTPServer;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getSubordinateBaseDN() {
      return pSubordinateBaseDN;
    }



    /** {@inheritDoc} */
    public long getTimeLimit() {
      return pTimeLimit;
    }



    /** {@inheritDoc} */
    public boolean isTrustTransactionIds() {
      return pTrustTransactionIds;
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public Class<? extends GlobalCfg> configurationClass() {
      return GlobalCfg.class;
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
