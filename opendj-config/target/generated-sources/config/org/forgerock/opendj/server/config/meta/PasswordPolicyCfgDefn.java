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
import java.util.TreeSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AttributeTypePropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.AccountStatusNotificationHandlerCfgClient;
import org.forgerock.opendj.server.config.client.PasswordGeneratorCfgClient;
import org.forgerock.opendj.server.config.client.PasswordPolicyCfgClient;
import org.forgerock.opendj.server.config.client.PasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.client.PasswordValidatorCfgClient;
import org.forgerock.opendj.server.config.server.AccountStatusNotificationHandlerCfg;
import org.forgerock.opendj.server.config.server.AuthenticationPolicyCfg;
import org.forgerock.opendj.server.config.server.PasswordGeneratorCfg;
import org.forgerock.opendj.server.config.server.PasswordPolicyCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;



/**
 * An interface for querying the Password Policy managed object
 * definition meta information.
 * <p>
 * Password Policies define a number of password management rules, as
 * well as requirements for authentication processing.
 */
public final class PasswordPolicyCfgDefn extends ManagedObjectDefinition<PasswordPolicyCfgClient, PasswordPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final PasswordPolicyCfgDefn INSTANCE = new PasswordPolicyCfgDefn();



  /**
   * Defines the set of permissable values for the "state-update-failure-policy" property.
   * <p>
   * Specifies how the server deals with the inability to update
   * password policy state information during an authentication
   * attempt.
   * <p>
   * In particular, this property can be used to control whether an
   * otherwise successful bind operation fails if a failure occurs
   * while attempting to update password policy state information (for
   * example, to clear a record of previous authentication failures or
   * to update the last login time). It can also be used to control
   * whether to reject a bind request if it is known ahead of time that
   * it will not be possible to update the authentication failure times
   * in the event of an unsuccessful bind attempt (for example, if the
   * backend writability mode is disabled).
   */
  public static enum StateUpdateFailurePolicy {

    /**
     * If a bind attempt would otherwise be successful, then do not
     * reject it if a problem occurs while attempting to update the
     * password policy state information for the user.
     */
    IGNORE("ignore"),



    /**
     * Proactively reject any bind attempt if it is known ahead of
     * time that it would not be possible to update the user's password
     * policy state information.
     */
    PROACTIVE("proactive"),



    /**
     * Even if a bind attempt would otherwise be successful, reject it
     * if a problem occurs while attempting to update the password
     * policy state information for the user.
     */
    REACTIVE("reactive");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private StateUpdateFailurePolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "account-status-notification-handler" property definition. */
  private static final AggregationPropertyDefinition<AccountStatusNotificationHandlerCfgClient, AccountStatusNotificationHandlerCfg> PD_ACCOUNT_STATUS_NOTIFICATION_HANDLER;



  /** The "allow-expired-password-changes" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_EXPIRED_PASSWORD_CHANGES;



  /** The "allow-multiple-password-values" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_MULTIPLE_PASSWORD_VALUES;



  /** The "allow-pre-encoded-passwords" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_PRE_ENCODED_PASSWORDS;



  /** The "allow-user-password-changes" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_USER_PASSWORD_CHANGES;



  /** The "default-password-storage-scheme" property definition. */
  private static final AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> PD_DEFAULT_PASSWORD_STORAGE_SCHEME;



  /** The "deprecated-password-storage-scheme" property definition. */
  private static final AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> PD_DEPRECATED_PASSWORD_STORAGE_SCHEME;



  /** The "expire-passwords-without-warning" property definition. */
  private static final BooleanPropertyDefinition PD_EXPIRE_PASSWORDS_WITHOUT_WARNING;



  /** The "force-change-on-add" property definition. */
  private static final BooleanPropertyDefinition PD_FORCE_CHANGE_ON_ADD;



  /** The "force-change-on-reset" property definition. */
  private static final BooleanPropertyDefinition PD_FORCE_CHANGE_ON_RESET;



  /** The "grace-login-count" property definition. */
  private static final IntegerPropertyDefinition PD_GRACE_LOGIN_COUNT;



  /** The "idle-lockout-interval" property definition. */
  private static final DurationPropertyDefinition PD_IDLE_LOCKOUT_INTERVAL;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "last-login-time-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_LAST_LOGIN_TIME_ATTRIBUTE;



  /** The "last-login-time-format" property definition. */
  private static final StringPropertyDefinition PD_LAST_LOGIN_TIME_FORMAT;



  /** The "lockout-duration" property definition. */
  private static final DurationPropertyDefinition PD_LOCKOUT_DURATION;



  /** The "lockout-failure-count" property definition. */
  private static final IntegerPropertyDefinition PD_LOCKOUT_FAILURE_COUNT;



  /** The "lockout-failure-expiration-interval" property definition. */
  private static final DurationPropertyDefinition PD_LOCKOUT_FAILURE_EXPIRATION_INTERVAL;



  /** The "max-password-age" property definition. */
  private static final DurationPropertyDefinition PD_MAX_PASSWORD_AGE;



  /** The "max-password-reset-age" property definition. */
  private static final DurationPropertyDefinition PD_MAX_PASSWORD_RESET_AGE;



  /** The "min-password-age" property definition. */
  private static final DurationPropertyDefinition PD_MIN_PASSWORD_AGE;



  /** The "password-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_PASSWORD_ATTRIBUTE;



  /** The "password-change-requires-current-password" property definition. */
  private static final BooleanPropertyDefinition PD_PASSWORD_CHANGE_REQUIRES_CURRENT_PASSWORD;



  /** The "password-expiration-warning-interval" property definition. */
  private static final DurationPropertyDefinition PD_PASSWORD_EXPIRATION_WARNING_INTERVAL;



  /** The "password-generator" property definition. */
  private static final AggregationPropertyDefinition<PasswordGeneratorCfgClient, PasswordGeneratorCfg> PD_PASSWORD_GENERATOR;



  /** The "password-history-count" property definition. */
  private static final IntegerPropertyDefinition PD_PASSWORD_HISTORY_COUNT;



  /** The "password-history-duration" property definition. */
  private static final DurationPropertyDefinition PD_PASSWORD_HISTORY_DURATION;



  /** The "password-validator" property definition. */
  private static final AggregationPropertyDefinition<PasswordValidatorCfgClient, PasswordValidatorCfg> PD_PASSWORD_VALIDATOR;



  /** The "previous-last-login-time-format" property definition. */
  private static final StringPropertyDefinition PD_PREVIOUS_LAST_LOGIN_TIME_FORMAT;



  /** The "require-change-by-time" property definition. */
  private static final StringPropertyDefinition PD_REQUIRE_CHANGE_BY_TIME;



  /** The "require-secure-authentication" property definition. */
  private static final BooleanPropertyDefinition PD_REQUIRE_SECURE_AUTHENTICATION;



  /** The "require-secure-password-changes" property definition. */
  private static final BooleanPropertyDefinition PD_REQUIRE_SECURE_PASSWORD_CHANGES;



  /** The "skip-validation-for-administrators" property definition. */
  private static final BooleanPropertyDefinition PD_SKIP_VALIDATION_FOR_ADMINISTRATORS;



  /** The "state-update-failure-policy" property definition. */
  private static final EnumPropertyDefinition<StateUpdateFailurePolicy> PD_STATE_UPDATE_FAILURE_POLICY;



  /** Build the "account-status-notification-handler" property definition. */
  static {
      AggregationPropertyDefinition.Builder<AccountStatusNotificationHandlerCfgClient, AccountStatusNotificationHandlerCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "account-status-notification-handler");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "account-status-notification-handler"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("account-status-notification-handler");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_ACCOUNT_STATUS_NOTIFICATION_HANDLER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ACCOUNT_STATUS_NOTIFICATION_HANDLER);
      INSTANCE.registerConstraint(PD_ACCOUNT_STATUS_NOTIFICATION_HANDLER.getSourceConstraint());
  }



  /** Build the "allow-expired-password-changes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-expired-password-changes");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-expired-password-changes"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_EXPIRED_PASSWORD_CHANGES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_EXPIRED_PASSWORD_CHANGES);
  }



  /** Build the "allow-multiple-password-values" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-multiple-password-values");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-multiple-password-values"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_MULTIPLE_PASSWORD_VALUES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_MULTIPLE_PASSWORD_VALUES);
  }



  /** Build the "allow-pre-encoded-passwords" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-pre-encoded-passwords");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-pre-encoded-passwords"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_PRE_ENCODED_PASSWORDS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_PRE_ENCODED_PASSWORDS);
  }



  /** Build the "allow-user-password-changes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-user-password-changes");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-user-password-changes"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_USER_PASSWORD_CHANGES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_USER_PASSWORD_CHANGES);
  }



  /** Build the "default-password-storage-scheme" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "default-password-storage-scheme");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-password-storage-scheme"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-storage-scheme");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_DEFAULT_PASSWORD_STORAGE_SCHEME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_PASSWORD_STORAGE_SCHEME);
      INSTANCE.registerConstraint(PD_DEFAULT_PASSWORD_STORAGE_SCHEME.getSourceConstraint());
  }



  /** Build the "deprecated-password-storage-scheme" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "deprecated-password-storage-scheme");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "deprecated-password-storage-scheme"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-storage-scheme");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_DEPRECATED_PASSWORD_STORAGE_SCHEME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEPRECATED_PASSWORD_STORAGE_SCHEME);
      INSTANCE.registerConstraint(PD_DEPRECATED_PASSWORD_STORAGE_SCHEME.getSourceConstraint());
  }



  /** Build the "expire-passwords-without-warning" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "expire-passwords-without-warning");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "expire-passwords-without-warning"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_EXPIRE_PASSWORDS_WITHOUT_WARNING = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_EXPIRE_PASSWORDS_WITHOUT_WARNING);
  }



  /** Build the "force-change-on-add" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "force-change-on-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "force-change-on-add"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_FORCE_CHANGE_ON_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_FORCE_CHANGE_ON_ADD);
  }



  /** Build the "force-change-on-reset" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "force-change-on-reset");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "force-change-on-reset"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_FORCE_CHANGE_ON_RESET = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_FORCE_CHANGE_ON_RESET);
  }



  /** Build the "grace-login-count" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "grace-login-count");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "grace-login-count"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_GRACE_LOGIN_COUNT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_GRACE_LOGIN_COUNT);
  }



  /** Build the "idle-lockout-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "idle-lockout-interval");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "idle-lockout-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_IDLE_LOCKOUT_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IDLE_LOCKOUT_INTERVAL);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.core.PasswordPolicyFactory");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AuthenticationPolicyFactory");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "last-login-time-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "last-login-time-attribute");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "last-login-time-attribute"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_LAST_LOGIN_TIME_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LAST_LOGIN_TIME_ATTRIBUTE);
  }



  /** Build the "last-login-time-format" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "last-login-time-format");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "last-login-time-format"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_LAST_LOGIN_TIME_FORMAT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LAST_LOGIN_TIME_FORMAT);
  }



  /** Build the "lockout-duration" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "lockout-duration");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "lockout-duration"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_LOCKOUT_DURATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOCKOUT_DURATION);
  }



  /** Build the "lockout-failure-count" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "lockout-failure-count");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "lockout-failure-count"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_LOCKOUT_FAILURE_COUNT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOCKOUT_FAILURE_COUNT);
  }



  /** Build the "lockout-failure-expiration-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "lockout-failure-expiration-interval");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "lockout-failure-expiration-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_LOCKOUT_FAILURE_EXPIRATION_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOCKOUT_FAILURE_EXPIRATION_INTERVAL);
  }



  /** Build the "max-password-age" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "max-password-age");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-password-age"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_MAX_PASSWORD_AGE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_PASSWORD_AGE);
  }



  /** Build the "max-password-reset-age" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "max-password-reset-age");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-password-reset-age"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_MAX_PASSWORD_RESET_AGE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_PASSWORD_RESET_AGE);
  }



  /** Build the "min-password-age" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "min-password-age");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "min-password-age"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_MIN_PASSWORD_AGE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MIN_PASSWORD_AGE);
  }



  /** Build the "password-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "password-attribute");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-attribute"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_PASSWORD_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_ATTRIBUTE);
  }



  /** Build the "password-change-requires-current-password" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "password-change-requires-current-password");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-change-requires-current-password"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_PASSWORD_CHANGE_REQUIRES_CURRENT_PASSWORD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_CHANGE_REQUIRES_CURRENT_PASSWORD);
  }



  /** Build the "password-expiration-warning-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "password-expiration-warning-interval");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-expiration-warning-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("5 days");
      builder.setDefaultBehaviorProvider(provider);
      PD_PASSWORD_EXPIRATION_WARNING_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_EXPIRATION_WARNING_INTERVAL);
  }



  /** Build the "password-generator" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordGeneratorCfgClient, PasswordGeneratorCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "password-generator");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-generator"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-generator");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_PASSWORD_GENERATOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_GENERATOR);
      INSTANCE.registerConstraint(PD_PASSWORD_GENERATOR.getSourceConstraint());
  }



  /** Build the "password-history-count" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "password-history-count");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-history-count"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_PASSWORD_HISTORY_COUNT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_HISTORY_COUNT);
  }



  /** Build the "password-history-duration" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "password-history-duration");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-history-duration"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setAllowUnlimited(false);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_PASSWORD_HISTORY_DURATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_HISTORY_DURATION);
  }



  /** Build the "password-validator" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordValidatorCfgClient, PasswordValidatorCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "password-validator");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-validator"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-validator");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_PASSWORD_VALIDATOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_VALIDATOR);
      INSTANCE.registerConstraint(PD_PASSWORD_VALIDATOR.getSourceConstraint());
  }



  /** Build the "previous-last-login-time-format" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "previous-last-login-time-format");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "previous-last-login-time-format"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_PREVIOUS_LAST_LOGIN_TIME_FORMAT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PREVIOUS_LAST_LOGIN_TIME_FORMAT);
  }



  /** Build the "require-change-by-time" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "require-change-by-time");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "require-change-by-time"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_REQUIRE_CHANGE_BY_TIME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUIRE_CHANGE_BY_TIME);
  }



  /** Build the "require-secure-authentication" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "require-secure-authentication");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "require-secure-authentication"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_REQUIRE_SECURE_AUTHENTICATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUIRE_SECURE_AUTHENTICATION);
  }



  /** Build the "require-secure-password-changes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "require-secure-password-changes");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "require-secure-password-changes"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_REQUIRE_SECURE_PASSWORD_CHANGES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUIRE_SECURE_PASSWORD_CHANGES);
  }



  /** Build the "skip-validation-for-administrators" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "skip-validation-for-administrators");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "skip-validation-for-administrators"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_SKIP_VALIDATION_FOR_ADMINISTRATORS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SKIP_VALIDATION_FOR_ADMINISTRATORS);
  }



  /** Build the "state-update-failure-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<StateUpdateFailurePolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "state-update-failure-policy");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "state-update-failure-policy"));
      DefaultBehaviorProvider<StateUpdateFailurePolicy> provider = new DefinedDefaultBehaviorProvider<StateUpdateFailurePolicy>("reactive");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(StateUpdateFailurePolicy.class);
      PD_STATE_UPDATE_FAILURE_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STATE_UPDATE_FAILURE_POLICY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Password Policy configuration definition singleton.
   *
   * @return Returns the Password Policy configuration definition
   *         singleton.
   */
  public static PasswordPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PasswordPolicyCfgDefn() {
    super("password-policy", AuthenticationPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PasswordPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends PasswordPolicyCfgClient> impl) {
    return new PasswordPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PasswordPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends PasswordPolicyCfg> impl) {
    return new PasswordPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PasswordPolicyCfg> getServerConfigurationClass() {
    return PasswordPolicyCfg.class;
  }



  /**
   * Get the "account-status-notification-handler" property definition.
   * <p>
   * Specifies the names of the account status notification handlers
   * that are used with the associated password storage scheme.
   *
   * @return Returns the "account-status-notification-handler" property definition.
   */
  public AggregationPropertyDefinition<AccountStatusNotificationHandlerCfgClient, AccountStatusNotificationHandlerCfg> getAccountStatusNotificationHandlerPropertyDefinition() {
    return PD_ACCOUNT_STATUS_NOTIFICATION_HANDLER;
  }



  /**
   * Get the "allow-expired-password-changes" property definition.
   * <p>
   * Indicates whether a user whose password is expired is still
   * allowed to change that password using the password modify extended
   * operation.
   *
   * @return Returns the "allow-expired-password-changes" property definition.
   */
  public BooleanPropertyDefinition getAllowExpiredPasswordChangesPropertyDefinition() {
    return PD_ALLOW_EXPIRED_PASSWORD_CHANGES;
  }



  /**
   * Get the "allow-multiple-password-values" property definition.
   * <p>
   * Indicates whether user entries can have multiple distinct values
   * for the password attribute.
   * <p>
   * This is potentially dangerous because many mechanisms used to
   * change the password do not work well with such a configuration. If
   * multiple password values are allowed, then any of them can be used
   * to authenticate, and they are all subject to the same policy
   * constraints.
   *
   * @return Returns the "allow-multiple-password-values" property definition.
   */
  public BooleanPropertyDefinition getAllowMultiplePasswordValuesPropertyDefinition() {
    return PD_ALLOW_MULTIPLE_PASSWORD_VALUES;
  }



  /**
   * Get the "allow-pre-encoded-passwords" property definition.
   * <p>
   * Indicates whether users can change their passwords by providing a
   * pre-encoded value.
   * <p>
   * This can cause a security risk because the clear-text version of
   * the password is not known and therefore validation checks cannot
   * be applied to it.
   *
   * @return Returns the "allow-pre-encoded-passwords" property definition.
   */
  public BooleanPropertyDefinition getAllowPreEncodedPasswordsPropertyDefinition() {
    return PD_ALLOW_PRE_ENCODED_PASSWORDS;
  }



  /**
   * Get the "allow-user-password-changes" property definition.
   * <p>
   * Indicates whether users can change their own passwords.
   * <p>
   * This check is made in addition to access control evaluation. Both
   * must allow the password change for it to occur.
   *
   * @return Returns the "allow-user-password-changes" property definition.
   */
  public BooleanPropertyDefinition getAllowUserPasswordChangesPropertyDefinition() {
    return PD_ALLOW_USER_PASSWORD_CHANGES;
  }



  /**
   * Get the "default-password-storage-scheme" property definition.
   * <p>
   * Specifies the names of the password storage schemes that are used
   * to encode clear-text passwords for this password policy.
   *
   * @return Returns the "default-password-storage-scheme" property definition.
   */
  public AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> getDefaultPasswordStorageSchemePropertyDefinition() {
    return PD_DEFAULT_PASSWORD_STORAGE_SCHEME;
  }



  /**
   * Get the "deprecated-password-storage-scheme" property definition.
   * <p>
   * Specifies the names of the password storage schemes that are
   * considered deprecated for this password policy.
   * <p>
   * If a user with this password policy authenticates to the server
   * and his/her password is encoded with a deprecated scheme, those
   * values are removed and replaced with values encoded using the
   * default password storage scheme(s).
   *
   * @return Returns the "deprecated-password-storage-scheme" property definition.
   */
  public AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> getDeprecatedPasswordStorageSchemePropertyDefinition() {
    return PD_DEPRECATED_PASSWORD_STORAGE_SCHEME;
  }



  /**
   * Get the "expire-passwords-without-warning" property definition.
   * <p>
   * Indicates whether the directory server allows a user's password
   * to expire even if that user has never seen an expiration warning
   * notification.
   * <p>
   * If this property is true, accounts always expire when the
   * expiration time arrives. If this property is false or disabled,
   * the user always receives at least one warning notification, and
   * the password expiration is set to the warning time plus the
   * warning interval.
   *
   * @return Returns the "expire-passwords-without-warning" property definition.
   */
  public BooleanPropertyDefinition getExpirePasswordsWithoutWarningPropertyDefinition() {
    return PD_EXPIRE_PASSWORDS_WITHOUT_WARNING;
  }



  /**
   * Get the "force-change-on-add" property definition.
   * <p>
   * Indicates whether users are forced to change their passwords upon
   * first authenticating to the directory server after their account
   * has been created.
   *
   * @return Returns the "force-change-on-add" property definition.
   */
  public BooleanPropertyDefinition getForceChangeOnAddPropertyDefinition() {
    return PD_FORCE_CHANGE_ON_ADD;
  }



  /**
   * Get the "force-change-on-reset" property definition.
   * <p>
   * Indicates whether users are forced to change their passwords if
   * they are reset by an administrator.
   * <p>
   * For this purpose, anyone with permission to change a given user's
   * password other than that user is considered an administrator.
   *
   * @return Returns the "force-change-on-reset" property definition.
   */
  public BooleanPropertyDefinition getForceChangeOnResetPropertyDefinition() {
    return PD_FORCE_CHANGE_ON_RESET;
  }



  /**
   * Get the "grace-login-count" property definition.
   * <p>
   * Specifies the number of grace logins that a user is allowed after
   * the account has expired to allow that user to choose a new
   * password.
   * <p>
   * A value of 0 indicates that no grace logins are allowed.
   *
   * @return Returns the "grace-login-count" property definition.
   */
  public IntegerPropertyDefinition getGraceLoginCountPropertyDefinition() {
    return PD_GRACE_LOGIN_COUNT;
  }



  /**
   * Get the "idle-lockout-interval" property definition.
   * <p>
   * Specifies the maximum length of time that an account may remain
   * idle (that is, the associated user does not authenticate to the
   * server) before that user is locked out.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * indicates that idle accounts are not automatically locked out.
   * This feature is available only if the last login time is
   * maintained.
   *
   * @return Returns the "idle-lockout-interval" property definition.
   */
  public DurationPropertyDefinition getIdleLockoutIntervalPropertyDefinition() {
    return PD_IDLE_LOCKOUT_INTERVAL;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class which
   * provides the Password Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "last-login-time-attribute" property definition.
   * <p>
   * Specifies the name or OID of the attribute type that is used to
   * hold the last login time for users with the associated password
   * policy.
   * <p>
   * This attribute type must be defined in the directory server
   * schema and must either be defined as an operational attribute or
   * must be allowed by the set of objectClasses for all users with the
   * associated password policy.
   *
   * @return Returns the "last-login-time-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getLastLoginTimeAttributePropertyDefinition() {
    return PD_LAST_LOGIN_TIME_ATTRIBUTE;
  }



  /**
   * Get the "last-login-time-format" property definition.
   * <p>
   * Specifies the format string that is used to generate the last
   * login time value for users with the associated password policy.
   * <p>
   * This format string conforms to the syntax described in the API
   * documentation for the java.text.SimpleDateFormat class.
   *
   * @return Returns the "last-login-time-format" property definition.
   */
  public StringPropertyDefinition getLastLoginTimeFormatPropertyDefinition() {
    return PD_LAST_LOGIN_TIME_FORMAT;
  }



  /**
   * Get the "lockout-duration" property definition.
   * <p>
   * Specifies the length of time that an account is locked after too
   * many authentication failures.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * indicates that the account must remain locked until an
   * administrator resets the password.
   *
   * @return Returns the "lockout-duration" property definition.
   */
  public DurationPropertyDefinition getLockoutDurationPropertyDefinition() {
    return PD_LOCKOUT_DURATION;
  }



  /**
   * Get the "lockout-failure-count" property definition.
   * <p>
   * Specifies the maximum number of authentication failures that a
   * user is allowed before the account is locked out.
   * <p>
   * A value of 0 indicates that accounts are never locked out due to
   * failed attempts.
   *
   * @return Returns the "lockout-failure-count" property definition.
   */
  public IntegerPropertyDefinition getLockoutFailureCountPropertyDefinition() {
    return PD_LOCKOUT_FAILURE_COUNT;
  }



  /**
   * Get the "lockout-failure-expiration-interval" property definition.
   * <p>
   * Specifies the length of time before an authentication failure is
   * no longer counted against a user for the purposes of account
   * lockout.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * indicates that the authentication failures must never expire. The
   * failure count is always cleared upon a successful authentication.
   *
   * @return Returns the "lockout-failure-expiration-interval" property definition.
   */
  public DurationPropertyDefinition getLockoutFailureExpirationIntervalPropertyDefinition() {
    return PD_LOCKOUT_FAILURE_EXPIRATION_INTERVAL;
  }



  /**
   * Get the "max-password-age" property definition.
   * <p>
   * Specifies the maximum length of time that a user can continue
   * using the same password before it must be changed (that is, the
   * password expiration interval).
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * disables password expiration.
   *
   * @return Returns the "max-password-age" property definition.
   */
  public DurationPropertyDefinition getMaxPasswordAgePropertyDefinition() {
    return PD_MAX_PASSWORD_AGE;
  }



  /**
   * Get the "max-password-reset-age" property definition.
   * <p>
   * Specifies the maximum length of time that users have to change
   * passwords after they have been reset by an administrator before
   * they become locked.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * disables this feature.
   *
   * @return Returns the "max-password-reset-age" property definition.
   */
  public DurationPropertyDefinition getMaxPasswordResetAgePropertyDefinition() {
    return PD_MAX_PASSWORD_RESET_AGE;
  }



  /**
   * Get the "min-password-age" property definition.
   * <p>
   * Specifies the minimum length of time after a password change
   * before the user is allowed to change the password again.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. This setting can be used
   * to prevent users from changing their passwords repeatedly over a
   * short period of time to flush an old password from the history so
   * that it can be re-used.
   *
   * @return Returns the "min-password-age" property definition.
   */
  public DurationPropertyDefinition getMinPasswordAgePropertyDefinition() {
    return PD_MIN_PASSWORD_AGE;
  }



  /**
   * Get the "password-attribute" property definition.
   * <p>
   * Specifies the attribute type used to hold user passwords.
   * <p>
   * This attribute type must be defined in the server schema, and it
   * must have either the user password or auth password syntax.
   *
   * @return Returns the "password-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getPasswordAttributePropertyDefinition() {
    return PD_PASSWORD_ATTRIBUTE;
  }



  /**
   * Get the "password-change-requires-current-password" property definition.
   * <p>
   * Indicates whether user password changes must use the password
   * modify extended operation and must include the user's current
   * password before the change is allowed.
   *
   * @return Returns the "password-change-requires-current-password" property definition.
   */
  public BooleanPropertyDefinition getPasswordChangeRequiresCurrentPasswordPropertyDefinition() {
    return PD_PASSWORD_CHANGE_REQUIRES_CURRENT_PASSWORD;
  }



  /**
   * Get the "password-expiration-warning-interval" property definition.
   * <p>
   * Specifies the maximum length of time before a user's password
   * actually expires that the server begins to include warning
   * notifications in bind responses for that user.
   * <p>
   * The value of this attribute is an integer followed by a unit of
   * seconds, minutes, hours, days, or weeks. A value of 0 seconds
   * disables the warning interval.
   *
   * @return Returns the "password-expiration-warning-interval" property definition.
   */
  public DurationPropertyDefinition getPasswordExpirationWarningIntervalPropertyDefinition() {
    return PD_PASSWORD_EXPIRATION_WARNING_INTERVAL;
  }



  /**
   * Get the "password-generator" property definition.
   * <p>
   * Specifies the name of the password generator that is used with
   * the associated password policy.
   * <p>
   * This is used in conjunction with the password modify extended
   * operation to generate a new password for a user when none was
   * provided in the request.
   *
   * @return Returns the "password-generator" property definition.
   */
  public AggregationPropertyDefinition<PasswordGeneratorCfgClient, PasswordGeneratorCfg> getPasswordGeneratorPropertyDefinition() {
    return PD_PASSWORD_GENERATOR;
  }



  /**
   * Get the "password-history-count" property definition.
   * <p>
   * Specifies the maximum number of former passwords to maintain in
   * the password history.
   * <p>
   * When choosing a new password, the proposed password is checked to
   * ensure that it does not match the current password, nor any other
   * password in the history list. A value of zero indicates that
   * either no password history is to be maintained (if the password
   * history duration has a value of zero seconds), or that there is no
   * maximum number of passwords to maintain in the history (if the
   * password history duration has a value greater than zero seconds).
   *
   * @return Returns the "password-history-count" property definition.
   */
  public IntegerPropertyDefinition getPasswordHistoryCountPropertyDefinition() {
    return PD_PASSWORD_HISTORY_COUNT;
  }



  /**
   * Get the "password-history-duration" property definition.
   * <p>
   * Specifies the maximum length of time that passwords remain in the
   * password history.
   * <p>
   * When choosing a new password, the proposed password is checked to
   * ensure that it does not match the current password, nor any other
   * password in the history list. A value of zero seconds indicates
   * that either no password history is to be maintained (if the
   * password history count has a value of zero), or that there is no
   * maximum duration for passwords in the history (if the password
   * history count has a value greater than zero).
   *
   * @return Returns the "password-history-duration" property definition.
   */
  public DurationPropertyDefinition getPasswordHistoryDurationPropertyDefinition() {
    return PD_PASSWORD_HISTORY_DURATION;
  }



  /**
   * Get the "password-validator" property definition.
   * <p>
   * Specifies the names of the password validators that are used with
   * the associated password storage scheme.
   * <p>
   * The password validators are invoked when a user attempts to
   * provide a new password, to determine whether the new password is
   * acceptable.
   *
   * @return Returns the "password-validator" property definition.
   */
  public AggregationPropertyDefinition<PasswordValidatorCfgClient, PasswordValidatorCfg> getPasswordValidatorPropertyDefinition() {
    return PD_PASSWORD_VALIDATOR;
  }



  /**
   * Get the "previous-last-login-time-format" property definition.
   * <p>
   * Specifies the format string(s) that might have been used with the
   * last login time at any point in the past for users associated with
   * the password policy.
   * <p>
   * These values are used to make it possible to parse previous
   * values, but are not used to set new values. The format strings
   * conform to the syntax described in the API documentation for the
   * java.text.SimpleDateFormat class.
   *
   * @return Returns the "previous-last-login-time-format" property definition.
   */
  public StringPropertyDefinition getPreviousLastLoginTimeFormatPropertyDefinition() {
    return PD_PREVIOUS_LAST_LOGIN_TIME_FORMAT;
  }



  /**
   * Get the "require-change-by-time" property definition.
   * <p>
   * Specifies the time by which all users with the associated
   * password policy must change their passwords.
   * <p>
   * The value is expressed in a generalized time format. If this time
   * is equal to the current time or is in the past, then all users are
   * required to change their passwords immediately. The behavior of
   * the server in this mode is identical to the behavior observed when
   * users are forced to change their passwords after an administrative
   * reset.
   *
   * @return Returns the "require-change-by-time" property definition.
   */
  public StringPropertyDefinition getRequireChangeByTimePropertyDefinition() {
    return PD_REQUIRE_CHANGE_BY_TIME;
  }



  /**
   * Get the "require-secure-authentication" property definition.
   * <p>
   * Indicates whether users with the associated password policy are
   * required to authenticate in a secure manner.
   * <p>
   * This might mean either using a secure communication channel
   * between the client and the server, or using a SASL mechanism that
   * does not expose the credentials.
   *
   * @return Returns the "require-secure-authentication" property definition.
   */
  public BooleanPropertyDefinition getRequireSecureAuthenticationPropertyDefinition() {
    return PD_REQUIRE_SECURE_AUTHENTICATION;
  }



  /**
   * Get the "require-secure-password-changes" property definition.
   * <p>
   * Indicates whether users with the associated password policy are
   * required to change their password in a secure manner that does not
   * expose the credentials.
   *
   * @return Returns the "require-secure-password-changes" property definition.
   */
  public BooleanPropertyDefinition getRequireSecurePasswordChangesPropertyDefinition() {
    return PD_REQUIRE_SECURE_PASSWORD_CHANGES;
  }



  /**
   * Get the "skip-validation-for-administrators" property definition.
   * <p>
   * Indicates whether passwords set by administrators are allowed to
   * bypass the password validation process that is required for user
   * password changes.
   *
   * @return Returns the "skip-validation-for-administrators" property definition.
   */
  public BooleanPropertyDefinition getSkipValidationForAdministratorsPropertyDefinition() {
    return PD_SKIP_VALIDATION_FOR_ADMINISTRATORS;
  }



  /**
   * Get the "state-update-failure-policy" property definition.
   * <p>
   * Specifies how the server deals with the inability to update
   * password policy state information during an authentication
   * attempt.
   * <p>
   * In particular, this property can be used to control whether an
   * otherwise successful bind operation fails if a failure occurs
   * while attempting to update password policy state information (for
   * example, to clear a record of previous authentication failures or
   * to update the last login time). It can also be used to control
   * whether to reject a bind request if it is known ahead of time that
   * it will not be possible to update the authentication failure times
   * in the event of an unsuccessful bind attempt (for example, if the
   * backend writability mode is disabled).
   *
   * @return Returns the "state-update-failure-policy" property definition.
   */
  public EnumPropertyDefinition<StateUpdateFailurePolicy> getStateUpdateFailurePolicyPropertyDefinition() {
    return PD_STATE_UPDATE_FAILURE_POLICY;
  }



  /**
   * Managed object client implementation.
   */
  private static class PasswordPolicyCfgClientImpl implements
    PasswordPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PasswordPolicyCfgClient> impl;



    /** Private constructor. */
    private PasswordPolicyCfgClientImpl(
        ManagedObject<? extends PasswordPolicyCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAccountStatusNotificationHandler() {
      return impl.getPropertyValues(INSTANCE.getAccountStatusNotificationHandlerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAccountStatusNotificationHandler(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getAccountStatusNotificationHandlerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isAllowExpiredPasswordChanges() {
      return impl.getPropertyValue(INSTANCE.getAllowExpiredPasswordChangesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowExpiredPasswordChanges(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowExpiredPasswordChangesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAllowMultiplePasswordValues() {
      return impl.getPropertyValue(INSTANCE.getAllowMultiplePasswordValuesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowMultiplePasswordValues(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowMultiplePasswordValuesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAllowPreEncodedPasswords() {
      return impl.getPropertyValue(INSTANCE.getAllowPreEncodedPasswordsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowPreEncodedPasswords(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowPreEncodedPasswordsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAllowUserPasswordChanges() {
      return impl.getPropertyValue(INSTANCE.getAllowUserPasswordChangesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowUserPasswordChanges(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowUserPasswordChangesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDefaultPasswordStorageScheme() {
      return impl.getPropertyValues(INSTANCE.getDefaultPasswordStorageSchemePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultPasswordStorageScheme(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDefaultPasswordStorageSchemePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDeprecatedPasswordStorageScheme() {
      return impl.getPropertyValues(INSTANCE.getDeprecatedPasswordStorageSchemePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDeprecatedPasswordStorageScheme(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDeprecatedPasswordStorageSchemePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isExpirePasswordsWithoutWarning() {
      return impl.getPropertyValue(INSTANCE.getExpirePasswordsWithoutWarningPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setExpirePasswordsWithoutWarning(Boolean value) {
      impl.setPropertyValue(INSTANCE.getExpirePasswordsWithoutWarningPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isForceChangeOnAdd() {
      return impl.getPropertyValue(INSTANCE.getForceChangeOnAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setForceChangeOnAdd(Boolean value) {
      impl.setPropertyValue(INSTANCE.getForceChangeOnAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isForceChangeOnReset() {
      return impl.getPropertyValue(INSTANCE.getForceChangeOnResetPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setForceChangeOnReset(Boolean value) {
      impl.setPropertyValue(INSTANCE.getForceChangeOnResetPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getGraceLoginCount() {
      return impl.getPropertyValue(INSTANCE.getGraceLoginCountPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setGraceLoginCount(Integer value) {
      impl.setPropertyValue(INSTANCE.getGraceLoginCountPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getIdleLockoutInterval() {
      return impl.getPropertyValue(INSTANCE.getIdleLockoutIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIdleLockoutInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getIdleLockoutIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public AttributeType getLastLoginTimeAttribute() {
      return impl.getPropertyValue(INSTANCE.getLastLoginTimeAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLastLoginTimeAttribute(AttributeType value) {
      impl.setPropertyValue(INSTANCE.getLastLoginTimeAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLastLoginTimeFormat() {
      return impl.getPropertyValue(INSTANCE.getLastLoginTimeFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLastLoginTimeFormat(String value) {
      impl.setPropertyValue(INSTANCE.getLastLoginTimeFormatPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getLockoutDuration() {
      return impl.getPropertyValue(INSTANCE.getLockoutDurationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLockoutDuration(Long value) {
      impl.setPropertyValue(INSTANCE.getLockoutDurationPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getLockoutFailureCount() {
      return impl.getPropertyValue(INSTANCE.getLockoutFailureCountPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLockoutFailureCount(Integer value) {
      impl.setPropertyValue(INSTANCE.getLockoutFailureCountPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getLockoutFailureExpirationInterval() {
      return impl.getPropertyValue(INSTANCE.getLockoutFailureExpirationIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLockoutFailureExpirationInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getLockoutFailureExpirationIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getMaxPasswordAge() {
      return impl.getPropertyValue(INSTANCE.getMaxPasswordAgePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxPasswordAge(Long value) {
      impl.setPropertyValue(INSTANCE.getMaxPasswordAgePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getMaxPasswordResetAge() {
      return impl.getPropertyValue(INSTANCE.getMaxPasswordResetAgePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxPasswordResetAge(Long value) {
      impl.setPropertyValue(INSTANCE.getMaxPasswordResetAgePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getMinPasswordAge() {
      return impl.getPropertyValue(INSTANCE.getMinPasswordAgePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMinPasswordAge(Long value) {
      impl.setPropertyValue(INSTANCE.getMinPasswordAgePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public AttributeType getPasswordAttribute() {
      return impl.getPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordAttribute(AttributeType value) {
      impl.setPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isPasswordChangeRequiresCurrentPassword() {
      return impl.getPropertyValue(INSTANCE.getPasswordChangeRequiresCurrentPasswordPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordChangeRequiresCurrentPassword(Boolean value) {
      impl.setPropertyValue(INSTANCE.getPasswordChangeRequiresCurrentPasswordPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getPasswordExpirationWarningInterval() {
      return impl.getPropertyValue(INSTANCE.getPasswordExpirationWarningIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordExpirationWarningInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getPasswordExpirationWarningIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPasswordGenerator() {
      return impl.getPropertyValue(INSTANCE.getPasswordGeneratorPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordGenerator(String value) {
      impl.setPropertyValue(INSTANCE.getPasswordGeneratorPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getPasswordHistoryCount() {
      return impl.getPropertyValue(INSTANCE.getPasswordHistoryCountPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordHistoryCount(Integer value) {
      impl.setPropertyValue(INSTANCE.getPasswordHistoryCountPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getPasswordHistoryDuration() {
      return impl.getPropertyValue(INSTANCE.getPasswordHistoryDurationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordHistoryDuration(Long value) {
      impl.setPropertyValue(INSTANCE.getPasswordHistoryDurationPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPasswordValidator() {
      return impl.getPropertyValues(INSTANCE.getPasswordValidatorPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordValidator(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getPasswordValidatorPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPreviousLastLoginTimeFormat() {
      return impl.getPropertyValues(INSTANCE.getPreviousLastLoginTimeFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPreviousLastLoginTimeFormat(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getPreviousLastLoginTimeFormatPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getRequireChangeByTime() {
      return impl.getPropertyValue(INSTANCE.getRequireChangeByTimePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequireChangeByTime(String value) {
      impl.setPropertyValue(INSTANCE.getRequireChangeByTimePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isRequireSecureAuthentication() {
      return impl.getPropertyValue(INSTANCE.getRequireSecureAuthenticationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequireSecureAuthentication(Boolean value) {
      impl.setPropertyValue(INSTANCE.getRequireSecureAuthenticationPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isRequireSecurePasswordChanges() {
      return impl.getPropertyValue(INSTANCE.getRequireSecurePasswordChangesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequireSecurePasswordChanges(Boolean value) {
      impl.setPropertyValue(INSTANCE.getRequireSecurePasswordChangesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSkipValidationForAdministrators() {
      return impl.getPropertyValue(INSTANCE.getSkipValidationForAdministratorsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSkipValidationForAdministrators(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSkipValidationForAdministratorsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public StateUpdateFailurePolicy getStateUpdateFailurePolicy() {
      return impl.getPropertyValue(INSTANCE.getStateUpdateFailurePolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStateUpdateFailurePolicy(StateUpdateFailurePolicy value) {
      impl.setPropertyValue(INSTANCE.getStateUpdateFailurePolicyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PasswordPolicyCfgClient, ? extends PasswordPolicyCfg> definition() {
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
  private static class PasswordPolicyCfgServerImpl implements
    PasswordPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PasswordPolicyCfg> impl;

    /** The value of the "account-status-notification-handler" property. */
    private final SortedSet<String> pAccountStatusNotificationHandler;

    /** The value of the "allow-expired-password-changes" property. */
    private final boolean pAllowExpiredPasswordChanges;

    /** The value of the "allow-multiple-password-values" property. */
    private final boolean pAllowMultiplePasswordValues;

    /** The value of the "allow-pre-encoded-passwords" property. */
    private final boolean pAllowPreEncodedPasswords;

    /** The value of the "allow-user-password-changes" property. */
    private final boolean pAllowUserPasswordChanges;

    /** The value of the "default-password-storage-scheme" property. */
    private final SortedSet<String> pDefaultPasswordStorageScheme;

    /** The value of the "deprecated-password-storage-scheme" property. */
    private final SortedSet<String> pDeprecatedPasswordStorageScheme;

    /** The value of the "expire-passwords-without-warning" property. */
    private final boolean pExpirePasswordsWithoutWarning;

    /** The value of the "force-change-on-add" property. */
    private final boolean pForceChangeOnAdd;

    /** The value of the "force-change-on-reset" property. */
    private final boolean pForceChangeOnReset;

    /** The value of the "grace-login-count" property. */
    private final int pGraceLoginCount;

    /** The value of the "idle-lockout-interval" property. */
    private final long pIdleLockoutInterval;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "last-login-time-attribute" property. */
    private final AttributeType pLastLoginTimeAttribute;

    /** The value of the "last-login-time-format" property. */
    private final String pLastLoginTimeFormat;

    /** The value of the "lockout-duration" property. */
    private final long pLockoutDuration;

    /** The value of the "lockout-failure-count" property. */
    private final int pLockoutFailureCount;

    /** The value of the "lockout-failure-expiration-interval" property. */
    private final long pLockoutFailureExpirationInterval;

    /** The value of the "max-password-age" property. */
    private final long pMaxPasswordAge;

    /** The value of the "max-password-reset-age" property. */
    private final long pMaxPasswordResetAge;

    /** The value of the "min-password-age" property. */
    private final long pMinPasswordAge;

    /** The value of the "password-attribute" property. */
    private final AttributeType pPasswordAttribute;

    /** The value of the "password-change-requires-current-password" property. */
    private final boolean pPasswordChangeRequiresCurrentPassword;

    /** The value of the "password-expiration-warning-interval" property. */
    private final long pPasswordExpirationWarningInterval;

    /** The value of the "password-generator" property. */
    private final String pPasswordGenerator;

    /** The value of the "password-history-count" property. */
    private final int pPasswordHistoryCount;

    /** The value of the "password-history-duration" property. */
    private final long pPasswordHistoryDuration;

    /** The value of the "password-validator" property. */
    private final SortedSet<String> pPasswordValidator;

    /** The value of the "previous-last-login-time-format" property. */
    private final SortedSet<String> pPreviousLastLoginTimeFormat;

    /** The value of the "require-change-by-time" property. */
    private final String pRequireChangeByTime;

    /** The value of the "require-secure-authentication" property. */
    private final boolean pRequireSecureAuthentication;

    /** The value of the "require-secure-password-changes" property. */
    private final boolean pRequireSecurePasswordChanges;

    /** The value of the "skip-validation-for-administrators" property. */
    private final boolean pSkipValidationForAdministrators;

    /** The value of the "state-update-failure-policy" property. */
    private final StateUpdateFailurePolicy pStateUpdateFailurePolicy;



    /** Private constructor. */
    private PasswordPolicyCfgServerImpl(ServerManagedObject<? extends PasswordPolicyCfg> impl) {
      this.impl = impl;
      this.pAccountStatusNotificationHandler = impl.getPropertyValues(INSTANCE.getAccountStatusNotificationHandlerPropertyDefinition());
      this.pAllowExpiredPasswordChanges = impl.getPropertyValue(INSTANCE.getAllowExpiredPasswordChangesPropertyDefinition());
      this.pAllowMultiplePasswordValues = impl.getPropertyValue(INSTANCE.getAllowMultiplePasswordValuesPropertyDefinition());
      this.pAllowPreEncodedPasswords = impl.getPropertyValue(INSTANCE.getAllowPreEncodedPasswordsPropertyDefinition());
      this.pAllowUserPasswordChanges = impl.getPropertyValue(INSTANCE.getAllowUserPasswordChangesPropertyDefinition());
      this.pDefaultPasswordStorageScheme = impl.getPropertyValues(INSTANCE.getDefaultPasswordStorageSchemePropertyDefinition());
      this.pDeprecatedPasswordStorageScheme = impl.getPropertyValues(INSTANCE.getDeprecatedPasswordStorageSchemePropertyDefinition());
      this.pExpirePasswordsWithoutWarning = impl.getPropertyValue(INSTANCE.getExpirePasswordsWithoutWarningPropertyDefinition());
      this.pForceChangeOnAdd = impl.getPropertyValue(INSTANCE.getForceChangeOnAddPropertyDefinition());
      this.pForceChangeOnReset = impl.getPropertyValue(INSTANCE.getForceChangeOnResetPropertyDefinition());
      this.pGraceLoginCount = impl.getPropertyValue(INSTANCE.getGraceLoginCountPropertyDefinition());
      this.pIdleLockoutInterval = impl.getPropertyValue(INSTANCE.getIdleLockoutIntervalPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLastLoginTimeAttribute = impl.getPropertyValue(INSTANCE.getLastLoginTimeAttributePropertyDefinition());
      this.pLastLoginTimeFormat = impl.getPropertyValue(INSTANCE.getLastLoginTimeFormatPropertyDefinition());
      this.pLockoutDuration = impl.getPropertyValue(INSTANCE.getLockoutDurationPropertyDefinition());
      this.pLockoutFailureCount = impl.getPropertyValue(INSTANCE.getLockoutFailureCountPropertyDefinition());
      this.pLockoutFailureExpirationInterval = impl.getPropertyValue(INSTANCE.getLockoutFailureExpirationIntervalPropertyDefinition());
      this.pMaxPasswordAge = impl.getPropertyValue(INSTANCE.getMaxPasswordAgePropertyDefinition());
      this.pMaxPasswordResetAge = impl.getPropertyValue(INSTANCE.getMaxPasswordResetAgePropertyDefinition());
      this.pMinPasswordAge = impl.getPropertyValue(INSTANCE.getMinPasswordAgePropertyDefinition());
      this.pPasswordAttribute = impl.getPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition());
      this.pPasswordChangeRequiresCurrentPassword = impl.getPropertyValue(INSTANCE.getPasswordChangeRequiresCurrentPasswordPropertyDefinition());
      this.pPasswordExpirationWarningInterval = impl.getPropertyValue(INSTANCE.getPasswordExpirationWarningIntervalPropertyDefinition());
      this.pPasswordGenerator = impl.getPropertyValue(INSTANCE.getPasswordGeneratorPropertyDefinition());
      this.pPasswordHistoryCount = impl.getPropertyValue(INSTANCE.getPasswordHistoryCountPropertyDefinition());
      this.pPasswordHistoryDuration = impl.getPropertyValue(INSTANCE.getPasswordHistoryDurationPropertyDefinition());
      this.pPasswordValidator = impl.getPropertyValues(INSTANCE.getPasswordValidatorPropertyDefinition());
      this.pPreviousLastLoginTimeFormat = impl.getPropertyValues(INSTANCE.getPreviousLastLoginTimeFormatPropertyDefinition());
      this.pRequireChangeByTime = impl.getPropertyValue(INSTANCE.getRequireChangeByTimePropertyDefinition());
      this.pRequireSecureAuthentication = impl.getPropertyValue(INSTANCE.getRequireSecureAuthenticationPropertyDefinition());
      this.pRequireSecurePasswordChanges = impl.getPropertyValue(INSTANCE.getRequireSecurePasswordChangesPropertyDefinition());
      this.pSkipValidationForAdministrators = impl.getPropertyValue(INSTANCE.getSkipValidationForAdministratorsPropertyDefinition());
      this.pStateUpdateFailurePolicy = impl.getPropertyValue(INSTANCE.getStateUpdateFailurePolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPasswordPolicyChangeListener(
        ConfigurationChangeListener<PasswordPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePasswordPolicyChangeListener(
        ConfigurationChangeListener<PasswordPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AuthenticationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AuthenticationPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAccountStatusNotificationHandler() {
      return pAccountStatusNotificationHandler;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getAccountStatusNotificationHandlerDNs() {
      SortedSet<String> values = getAccountStatusNotificationHandler();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getAccountStatusNotificationHandlerPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public boolean isAllowExpiredPasswordChanges() {
      return pAllowExpiredPasswordChanges;
    }



    /** {@inheritDoc} */
    public boolean isAllowMultiplePasswordValues() {
      return pAllowMultiplePasswordValues;
    }



    /** {@inheritDoc} */
    public boolean isAllowPreEncodedPasswords() {
      return pAllowPreEncodedPasswords;
    }



    /** {@inheritDoc} */
    public boolean isAllowUserPasswordChanges() {
      return pAllowUserPasswordChanges;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDefaultPasswordStorageScheme() {
      return pDefaultPasswordStorageScheme;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getDefaultPasswordStorageSchemeDNs() {
      SortedSet<String> values = getDefaultPasswordStorageScheme();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getDefaultPasswordStorageSchemePropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDeprecatedPasswordStorageScheme() {
      return pDeprecatedPasswordStorageScheme;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getDeprecatedPasswordStorageSchemeDNs() {
      SortedSet<String> values = getDeprecatedPasswordStorageScheme();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getDeprecatedPasswordStorageSchemePropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public boolean isExpirePasswordsWithoutWarning() {
      return pExpirePasswordsWithoutWarning;
    }



    /** {@inheritDoc} */
    public boolean isForceChangeOnAdd() {
      return pForceChangeOnAdd;
    }



    /** {@inheritDoc} */
    public boolean isForceChangeOnReset() {
      return pForceChangeOnReset;
    }



    /** {@inheritDoc} */
    public int getGraceLoginCount() {
      return pGraceLoginCount;
    }



    /** {@inheritDoc} */
    public long getIdleLockoutInterval() {
      return pIdleLockoutInterval;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public AttributeType getLastLoginTimeAttribute() {
      return pLastLoginTimeAttribute;
    }



    /** {@inheritDoc} */
    public String getLastLoginTimeFormat() {
      return pLastLoginTimeFormat;
    }



    /** {@inheritDoc} */
    public long getLockoutDuration() {
      return pLockoutDuration;
    }



    /** {@inheritDoc} */
    public int getLockoutFailureCount() {
      return pLockoutFailureCount;
    }



    /** {@inheritDoc} */
    public long getLockoutFailureExpirationInterval() {
      return pLockoutFailureExpirationInterval;
    }



    /** {@inheritDoc} */
    public long getMaxPasswordAge() {
      return pMaxPasswordAge;
    }



    /** {@inheritDoc} */
    public long getMaxPasswordResetAge() {
      return pMaxPasswordResetAge;
    }



    /** {@inheritDoc} */
    public long getMinPasswordAge() {
      return pMinPasswordAge;
    }



    /** {@inheritDoc} */
    public AttributeType getPasswordAttribute() {
      return pPasswordAttribute;
    }



    /** {@inheritDoc} */
    public boolean isPasswordChangeRequiresCurrentPassword() {
      return pPasswordChangeRequiresCurrentPassword;
    }



    /** {@inheritDoc} */
    public long getPasswordExpirationWarningInterval() {
      return pPasswordExpirationWarningInterval;
    }



    /** {@inheritDoc} */
    public String getPasswordGenerator() {
      return pPasswordGenerator;
    }



    /**
     * {@inheritDoc}
     */
    public DN getPasswordGeneratorDN() {
      String value = getPasswordGenerator();
      if (value == null) return null;
      return INSTANCE.getPasswordGeneratorPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public int getPasswordHistoryCount() {
      return pPasswordHistoryCount;
    }



    /** {@inheritDoc} */
    public long getPasswordHistoryDuration() {
      return pPasswordHistoryDuration;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPasswordValidator() {
      return pPasswordValidator;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getPasswordValidatorDNs() {
      SortedSet<String> values = getPasswordValidator();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getPasswordValidatorPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPreviousLastLoginTimeFormat() {
      return pPreviousLastLoginTimeFormat;
    }



    /** {@inheritDoc} */
    public String getRequireChangeByTime() {
      return pRequireChangeByTime;
    }



    /** {@inheritDoc} */
    public boolean isRequireSecureAuthentication() {
      return pRequireSecureAuthentication;
    }



    /** {@inheritDoc} */
    public boolean isRequireSecurePasswordChanges() {
      return pRequireSecurePasswordChanges;
    }



    /** {@inheritDoc} */
    public boolean isSkipValidationForAdministrators() {
      return pSkipValidationForAdministrators;
    }



    /** {@inheritDoc} */
    public StateUpdateFailurePolicy getStateUpdateFailurePolicy() {
      return pStateUpdateFailurePolicy;
    }



    /** {@inheritDoc} */
    public Class<? extends PasswordPolicyCfg> configurationClass() {
      return PasswordPolicyCfg.class;
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
