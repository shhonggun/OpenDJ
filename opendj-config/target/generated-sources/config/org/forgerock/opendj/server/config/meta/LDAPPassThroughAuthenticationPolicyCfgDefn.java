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



import java.net.InetAddress;
import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
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
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.GenericConstraint;
import org.forgerock.opendj.config.IPAddressPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.LDAPPassThroughAuthenticationPolicyCfgClient;
import org.forgerock.opendj.server.config.client.PasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.AuthenticationPolicyCfg;
import org.forgerock.opendj.server.config.server.LDAPPassThroughAuthenticationPolicyCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the LDAP Pass Through Authentication
 * Policy managed object definition meta information.
 * <p>
 * An authentication policy for users whose credentials are managed by
 * a remote LDAP directory service.
 */
public final class LDAPPassThroughAuthenticationPolicyCfgDefn extends ManagedObjectDefinition<LDAPPassThroughAuthenticationPolicyCfgClient, LDAPPassThroughAuthenticationPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final LDAPPassThroughAuthenticationPolicyCfgDefn INSTANCE = new LDAPPassThroughAuthenticationPolicyCfgDefn();



  /**
   * Defines the set of permissable values for the "mapping-policy" property.
   * <p>
   * Specifies the mapping algorithm for obtaining the bind DN from
   * the user's entry.
   */
  public static enum MappingPolicy {

    /**
     * Bind to the remote LDAP directory service using a DN obtained
     * from an attribute in the user's entry. This policy will check
     * each attribute named in the "mapped-attribute" property. If more
     * than one attribute or value is present then the first one will
     * be used.
     */
    MAPPED_BIND("mapped-bind"),



    /**
     * Bind to the remote LDAP directory service using the DN of an
     * entry obtained using a search against the remote LDAP directory
     * service. The search filter will comprise of an equality matching
     * filter whose attribute type is the "mapped-attribute" property,
     * and whose assertion value is the attribute value obtained from
     * the user's entry. If more than one attribute or value is present
     * then the filter will be composed of multiple equality filters
     * combined using a logical OR (union).
     */
    MAPPED_SEARCH("mapped-search"),



    /**
     * Bind to the remote LDAP directory service using the DN of the
     * user's entry in this directory server.
     */
    UNMAPPED("unmapped");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private MappingPolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "cached-password-storage-scheme" property definition. */
  private static final AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> PD_CACHED_PASSWORD_STORAGE_SCHEME;



  /** The "cached-password-ttl" property definition. */
  private static final DurationPropertyDefinition PD_CACHED_PASSWORD_TTL;



  /** The "connection-timeout" property definition. */
  private static final DurationPropertyDefinition PD_CONNECTION_TIMEOUT;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "mapped-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_MAPPED_ATTRIBUTE;



  /** The "mapped-search-base-dn" property definition. */
  private static final DNPropertyDefinition PD_MAPPED_SEARCH_BASE_DN;



  /** The "mapped-search-bind-dn" property definition. */
  private static final DNPropertyDefinition PD_MAPPED_SEARCH_BIND_DN;



  /** The "mapped-search-bind-password" property definition. */
  private static final StringPropertyDefinition PD_MAPPED_SEARCH_BIND_PASSWORD;



  /** The "mapped-search-bind-password-environment-variable" property definition. */
  private static final StringPropertyDefinition PD_MAPPED_SEARCH_BIND_PASSWORD_ENVIRONMENT_VARIABLE;



  /** The "mapped-search-bind-password-file" property definition. */
  private static final StringPropertyDefinition PD_MAPPED_SEARCH_BIND_PASSWORD_FILE;



  /** The "mapped-search-bind-password-property" property definition. */
  private static final StringPropertyDefinition PD_MAPPED_SEARCH_BIND_PASSWORD_PROPERTY;



  /** The "mapped-search-filter-template" property definition. */
  private static final StringPropertyDefinition PD_MAPPED_SEARCH_FILTER_TEMPLATE;



  /** The "mapping-policy" property definition. */
  private static final EnumPropertyDefinition<MappingPolicy> PD_MAPPING_POLICY;



  /** The "primary-remote-ldap-server" property definition. */
  private static final StringPropertyDefinition PD_PRIMARY_REMOTE_LDAP_SERVER;



  /** The "secondary-remote-ldap-server" property definition. */
  private static final StringPropertyDefinition PD_SECONDARY_REMOTE_LDAP_SERVER;



  /** The "source-address" property definition. */
  private static final IPAddressPropertyDefinition PD_SOURCE_ADDRESS;



  /** The "ssl-cipher-suite" property definition. */
  private static final StringPropertyDefinition PD_SSL_CIPHER_SUITE;



  /** The "ssl-protocol" property definition. */
  private static final StringPropertyDefinition PD_SSL_PROTOCOL;



  /** The "trust-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> PD_TRUST_MANAGER_PROVIDER;



  /** The "use-password-caching" property definition. */
  private static final BooleanPropertyDefinition PD_USE_PASSWORD_CACHING;



  /** The "use-ssl" property definition. */
  private static final BooleanPropertyDefinition PD_USE_SSL;



  /** The "use-tcp-keep-alive" property definition. */
  private static final BooleanPropertyDefinition PD_USE_TCP_KEEP_ALIVE;



  /** The "use-tcp-no-delay" property definition. */
  private static final BooleanPropertyDefinition PD_USE_TCP_NO_DELAY;



  /** Build the "cached-password-storage-scheme" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "cached-password-storage-scheme");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "cached-password-storage-scheme"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("password-storage-scheme");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_CACHED_PASSWORD_STORAGE_SCHEME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CACHED_PASSWORD_STORAGE_SCHEME);
      INSTANCE.registerConstraint(PD_CACHED_PASSWORD_STORAGE_SCHEME.getSourceConstraint());
  }



  /** Build the "cached-password-ttl" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "cached-password-ttl");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "cached-password-ttl"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("8 hours");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      PD_CACHED_PASSWORD_TTL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CACHED_PASSWORD_TTL);
  }



  /** Build the "connection-timeout" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "connection-timeout");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-timeout"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("3 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("0");
      PD_CONNECTION_TIMEOUT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_TIMEOUT);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.LDAPPassThroughAuthenticationPolicyFactory");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AuthenticationPolicyFactory");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "mapped-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "mapped-attribute");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-attribute"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_MAPPED_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_ATTRIBUTE);
  }



  /** Build the "mapped-search-base-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "mapped-search-base-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-base-dn"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_MAPPED_SEARCH_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BASE_DN);
  }



  /** Build the "mapped-search-bind-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "mapped-search-bind-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-bind-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "mapped-search-bind-dn"));
      PD_MAPPED_SEARCH_BIND_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BIND_DN);
  }



  /** Build the "mapped-search-bind-password" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "mapped-search-bind-password");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-bind-password"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MAPPED_SEARCH_BIND_PASSWORD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BIND_PASSWORD);
  }



  /** Build the "mapped-search-bind-password-environment-variable" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "mapped-search-bind-password-environment-variable");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-bind-password-environment-variable"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MAPPED_SEARCH_BIND_PASSWORD_ENVIRONMENT_VARIABLE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BIND_PASSWORD_ENVIRONMENT_VARIABLE);
  }



  /** Build the "mapped-search-bind-password-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "mapped-search-bind-password-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-bind-password-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MAPPED_SEARCH_BIND_PASSWORD_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BIND_PASSWORD_FILE);
  }



  /** Build the "mapped-search-bind-password-property" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "mapped-search-bind-password-property");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-bind-password-property"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MAPPED_SEARCH_BIND_PASSWORD_PROPERTY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_BIND_PASSWORD_PROPERTY);
  }



  /** Build the "mapped-search-filter-template" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "mapped-search-filter-template");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapped-search-filter-template"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MAPPED_SEARCH_FILTER_TEMPLATE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPED_SEARCH_FILTER_TEMPLATE);
  }



  /** Build the "mapping-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<MappingPolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "mapping-policy");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "mapping-policy"));
      DefaultBehaviorProvider<MappingPolicy> provider = new DefinedDefaultBehaviorProvider<MappingPolicy>("unmapped");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(MappingPolicy.class);
      PD_MAPPING_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAPPING_POLICY);
  }



  /** Build the "primary-remote-ldap-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "primary-remote-ldap-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "primary-remote-ldap-server"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^.+:[0-9]+$", "HOST:PORT");
      PD_PRIMARY_REMOTE_LDAP_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PRIMARY_REMOTE_LDAP_SERVER);
  }



  /** Build the "secondary-remote-ldap-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "secondary-remote-ldap-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "secondary-remote-ldap-server"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "secondary-remote-ldap-server"));
      builder.setPattern("^.+:[0-9]+$", "HOST:PORT");
      PD_SECONDARY_REMOTE_LDAP_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SECONDARY_REMOTE_LDAP_SERVER);
  }



  /** Build the "source-address" property definition. */
  static {
      IPAddressPropertyDefinition.Builder builder = IPAddressPropertyDefinition.createBuilder(INSTANCE, "source-address");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "source-address"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<InetAddress>(INSTANCE, "source-address"));
      PD_SOURCE_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SOURCE_ADDRESS);
  }



  /** Build the "ssl-cipher-suite" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cipher-suite");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-cipher-suite"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-cipher-suite"));
      PD_SSL_CIPHER_SUITE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CIPHER_SUITE);
  }



  /** Build the "ssl-protocol" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-protocol");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-protocol"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-protocol"));
      PD_SSL_PROTOCOL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_PROTOCOL);
  }



  /** Build the "trust-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<TrustManagerProviderCfgClient, TrustManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "trust-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-manager-provider"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "trust-manager-provider"));
      builder.setParentPath("/");
      builder.setRelationDefinition("trust-manager-provider");
      builder.setTargetNeedsEnablingCondition(Conditions.and(Conditions.contains("use-ssl", "true")));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_TRUST_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_TRUST_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "use-password-caching" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-password-caching");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "use-password-caching"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_PASSWORD_CACHING = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_PASSWORD_CACHING);
  }



  /** Build the "use-ssl" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-ssl");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "use-ssl"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_SSL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_SSL);
  }



  /** Build the "use-tcp-keep-alive" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-tcp-keep-alive");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "use-tcp-keep-alive"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_TCP_KEEP_ALIVE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_TCP_KEEP_ALIVE);
  }



  /** Build the "use-tcp-no-delay" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-tcp-no-delay");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "use-tcp-no-delay"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_TCP_NO_DELAY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_TCP_NO_DELAY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.or(Conditions.contains("mapping-policy", "mapped-bind"), Conditions.contains("mapping-policy", "mapped-search")), Conditions.isPresent("mapped-attribute"))));
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 2, Conditions.implies(Conditions.contains("mapping-policy", "mapped-search"), Conditions.isPresent("mapped-search-base-dn"))));
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 3, Conditions.implies(Conditions.and(Conditions.contains("mapping-policy", "mapped-search"), Conditions.isPresent("mapped-search-bind-dn")), Conditions.or(Conditions.isPresent("mapped-search-bind-password"), Conditions.isPresent("mapped-search-bind-password-property"), Conditions.isPresent("mapped-search-bind-password-environment-variable"), Conditions.isPresent("mapped-search-bind-password-file")))));
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 4, Conditions.implies(Conditions.contains("use-password-caching", "true"), Conditions.isPresent("cached-password-storage-scheme"))));
  }



  /**
   * Get the LDAP Pass Through Authentication Policy configuration
   * definition singleton.
   *
   * @return Returns the LDAP Pass Through Authentication Policy
   *         configuration definition singleton.
   */
  public static LDAPPassThroughAuthenticationPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private LDAPPassThroughAuthenticationPolicyCfgDefn() {
    super("ldap-pass-through-authentication-policy", AuthenticationPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public LDAPPassThroughAuthenticationPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfgClient> impl) {
    return new LDAPPassThroughAuthenticationPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public LDAPPassThroughAuthenticationPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfg> impl) {
    return new LDAPPassThroughAuthenticationPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<LDAPPassThroughAuthenticationPolicyCfg> getServerConfigurationClass() {
    return LDAPPassThroughAuthenticationPolicyCfg.class;
  }



  /**
   * Get the "cached-password-storage-scheme" property definition.
   * <p>
   * Specifies the name of a password storage scheme which should be
   * used for encoding cached passwords.
   * <p>
   * Changing the password storage scheme will cause all existing
   * cached passwords to be discarded.
   *
   * @return Returns the "cached-password-storage-scheme" property definition.
   */
  public AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> getCachedPasswordStorageSchemePropertyDefinition() {
    return PD_CACHED_PASSWORD_STORAGE_SCHEME;
  }



  /**
   * Get the "cached-password-ttl" property definition.
   * <p>
   * Specifies the maximum length of time that a locally cached
   * password may be used for authentication before it is refreshed
   * from the remote LDAP service.
   * <p>
   * This property represents a cache timeout. Increasing the timeout
   * period decreases the frequency that bind operations are delegated
   * to the remote LDAP service, but increases the risk of users
   * authenticating using stale passwords. Note that authentication
   * attempts which fail because the provided password does not match
   * the locally cached password will always be retried against the
   * remote LDAP service.
   *
   * @return Returns the "cached-password-ttl" property definition.
   */
  public DurationPropertyDefinition getCachedPasswordTTLPropertyDefinition() {
    return PD_CACHED_PASSWORD_TTL;
  }



  /**
   * Get the "connection-timeout" property definition.
   * <p>
   * Specifies the timeout used when connecting to remote LDAP
   * directory servers, performing SSL negotiation, and for individual
   * search and bind requests.
   * <p>
   * If the timeout expires then the current operation will be aborted
   * and retried against another LDAP server if one is available.
   *
   * @return Returns the "connection-timeout" property definition.
   */
  public DurationPropertyDefinition getConnectionTimeoutPropertyDefinition() {
    return PD_CONNECTION_TIMEOUT;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class which
   * provides the LDAP Pass Through Authentication Policy
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "mapped-attribute" property definition.
   * <p>
   * Specifies one or more attributes in the user's entry whose
   * value(s) will determine the bind DN used when authenticating to
   * the remote LDAP directory service. This property is mandatory when
   * using the "mapped-bind" or "mapped-search" mapping policies.
   * <p>
   * At least one value must be provided. All values must refer to the
   * name or OID of an attribute type defined in the directory server
   * schema. At least one of the named attributes must exist in a
   * user's local entry in order for authentication to proceed. When
   * multiple attributes or values are found in the user's entry then
   * the behavior is determined by the mapping policy.
   *
   * @return Returns the "mapped-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getMappedAttributePropertyDefinition() {
    return PD_MAPPED_ATTRIBUTE;
  }



  /**
   * Get the "mapped-search-base-dn" property definition.
   * <p>
   * Specifies the set of base DNs below which to search for users in
   * the remote LDAP directory service. This property is mandatory when
   * using the "mapped-search" mapping policy.
   * <p>
   * If multiple values are given, searches are performed below all
   * specified base DNs.
   *
   * @return Returns the "mapped-search-base-dn" property definition.
   */
  public DNPropertyDefinition getMappedSearchBaseDNPropertyDefinition() {
    return PD_MAPPED_SEARCH_BASE_DN;
  }



  /**
   * Get the "mapped-search-bind-dn" property definition.
   * <p>
   * Specifies the bind DN which should be used to perform user
   * searches in the remote LDAP directory service.
   *
   * @return Returns the "mapped-search-bind-dn" property definition.
   */
  public DNPropertyDefinition getMappedSearchBindDNPropertyDefinition() {
    return PD_MAPPED_SEARCH_BIND_DN;
  }



  /**
   * Get the "mapped-search-bind-password" property definition.
   * <p>
   * Specifies the bind password which should be used to perform user
   * searches in the remote LDAP directory service.
   *
   * @return Returns the "mapped-search-bind-password" property definition.
   */
  public StringPropertyDefinition getMappedSearchBindPasswordPropertyDefinition() {
    return PD_MAPPED_SEARCH_BIND_PASSWORD;
  }



  /**
   * Get the "mapped-search-bind-password-environment-variable" property definition.
   * <p>
   * Specifies the name of an environment variable containing the bind
   * password which should be used to perform user searches in the
   * remote LDAP directory service.
   *
   * @return Returns the "mapped-search-bind-password-environment-variable" property definition.
   */
  public StringPropertyDefinition getMappedSearchBindPasswordEnvironmentVariablePropertyDefinition() {
    return PD_MAPPED_SEARCH_BIND_PASSWORD_ENVIRONMENT_VARIABLE;
  }



  /**
   * Get the "mapped-search-bind-password-file" property definition.
   * <p>
   * Specifies the name of a file containing the bind password which
   * should be used to perform user searches in the remote LDAP
   * directory service.
   *
   * @return Returns the "mapped-search-bind-password-file" property definition.
   */
  public StringPropertyDefinition getMappedSearchBindPasswordFilePropertyDefinition() {
    return PD_MAPPED_SEARCH_BIND_PASSWORD_FILE;
  }



  /**
   * Get the "mapped-search-bind-password-property" property definition.
   * <p>
   * Specifies the name of a Java property containing the bind
   * password which should be used to perform user searches in the
   * remote LDAP directory service.
   *
   * @return Returns the "mapped-search-bind-password-property" property definition.
   */
  public StringPropertyDefinition getMappedSearchBindPasswordPropertyPropertyDefinition() {
    return PD_MAPPED_SEARCH_BIND_PASSWORD_PROPERTY;
  }



  /**
   * Get the "mapped-search-filter-template" property definition.
   * <p>
   * If defined, overrides the filter used when searching for the
   * user, substituting %s with the value of the local entry's
   * "mapped-attribute".
   * <p>
   * The filter-template may include ZERO or ONE %s substitutions. If
   * multiple mapped-attributes are configured, multiple renditions of
   * this template will be aggregated into one larger filter using an
   * OR (|) operator. An example use-case for this property would be to
   * use a different attribute type on the mapped search. For example,
   * mapped-attribute could be set to "uid" and filter-template to
   * "(samAccountName=%s)". You can also use the filter to restrict
   * search results. For example: "(&(uid=%s)(objectclass=student))"
   *
   * @return Returns the "mapped-search-filter-template" property definition.
   */
  public StringPropertyDefinition getMappedSearchFilterTemplatePropertyDefinition() {
    return PD_MAPPED_SEARCH_FILTER_TEMPLATE;
  }



  /**
   * Get the "mapping-policy" property definition.
   * <p>
   * Specifies the mapping algorithm for obtaining the bind DN from
   * the user's entry.
   *
   * @return Returns the "mapping-policy" property definition.
   */
  public EnumPropertyDefinition<MappingPolicy> getMappingPolicyPropertyDefinition() {
    return PD_MAPPING_POLICY;
  }



  /**
   * Get the "primary-remote-ldap-server" property definition.
   * <p>
   * Specifies the primary list of remote LDAP servers which should be
   * used for pass through authentication.
   * <p>
   * If more than one LDAP server is specified then operations may be
   * distributed across them. If all of the primary LDAP servers are
   * unavailable then operations will fail-over to the set of secondary
   * LDAP servers, if defined.
   *
   * @return Returns the "primary-remote-ldap-server" property definition.
   */
  public StringPropertyDefinition getPrimaryRemoteLDAPServerPropertyDefinition() {
    return PD_PRIMARY_REMOTE_LDAP_SERVER;
  }



  /**
   * Get the "secondary-remote-ldap-server" property definition.
   * <p>
   * Specifies the secondary list of remote LDAP servers which should
   * be used for pass through authentication in the event that the
   * primary LDAP servers are unavailable.
   * <p>
   * If more than one LDAP server is specified then operations may be
   * distributed across them. Operations will be rerouted to the
   * primary LDAP servers as soon as they are determined to be
   * available.
   *
   * @return Returns the "secondary-remote-ldap-server" property definition.
   */
  public StringPropertyDefinition getSecondaryRemoteLDAPServerPropertyDefinition() {
    return PD_SECONDARY_REMOTE_LDAP_SERVER;
  }



  /**
   * Get the "source-address" property definition.
   * <p>
   * If specified, the server will bind to the address before
   * connecting to the remote server.
   * <p>
   * The address must be one assigned to an existing network
   * interface.
   *
   * @return Returns the "source-address" property definition.
   */
  public IPAddressPropertyDefinition getSourceAddressPropertyDefinition() {
    return PD_SOURCE_ADDRESS;
  }



  /**
   * Get the "ssl-cipher-suite" property definition.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL based LDAP connections.
   *
   * @return Returns the "ssl-cipher-suite" property definition.
   */
  public StringPropertyDefinition getSSLCipherSuitePropertyDefinition() {
    return PD_SSL_CIPHER_SUITE;
  }



  /**
   * Get the "ssl-protocol" property definition.
   * <p>
   * Specifies the names of the SSL protocols which are allowed for
   * use in SSL based LDAP connections.
   *
   * @return Returns the "ssl-protocol" property definition.
   */
  public StringPropertyDefinition getSSLProtocolPropertyDefinition() {
    return PD_SSL_PROTOCOL;
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with remote LDAP directory servers.
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return PD_TRUST_MANAGER_PROVIDER;
  }



  /**
   * Get the "use-password-caching" property definition.
   * <p>
   * Indicates whether passwords should be cached locally within the
   * user's entry.
   *
   * @return Returns the "use-password-caching" property definition.
   */
  public BooleanPropertyDefinition getUsePasswordCachingPropertyDefinition() {
    return PD_USE_PASSWORD_CACHING;
  }



  /**
   * Get the "use-ssl" property definition.
   * <p>
   * Indicates whether the LDAP Pass Through Authentication Policy
   * should use SSL.
   * <p>
   * If enabled, the LDAP Pass Through Authentication Policy will use
   * SSL to encrypt communication with the clients.
   *
   * @return Returns the "use-ssl" property definition.
   */
  public BooleanPropertyDefinition getUseSSLPropertyDefinition() {
    return PD_USE_SSL;
  }



  /**
   * Get the "use-tcp-keep-alive" property definition.
   * <p>
   * Indicates whether LDAP connections should use TCP keep-alive.
   * <p>
   * If enabled, the SO_KEEPALIVE socket option is used to indicate
   * that TCP keepalive messages should periodically be sent to the
   * client to verify that the associated connection is still valid.
   * This may also help prevent cases in which intermediate network
   * hardware could silently drop an otherwise idle client connection,
   * provided that the keepalive interval configured in the underlying
   * operating system is smaller than the timeout enforced by the
   * network hardware.
   *
   * @return Returns the "use-tcp-keep-alive" property definition.
   */
  public BooleanPropertyDefinition getUseTCPKeepAlivePropertyDefinition() {
    return PD_USE_TCP_KEEP_ALIVE;
  }



  /**
   * Get the "use-tcp-no-delay" property definition.
   * <p>
   * Indicates whether LDAP connections should use TCP no-delay.
   * <p>
   * If enabled, the TCP_NODELAY socket option is used to ensure that
   * response messages to the client are sent immediately rather than
   * potentially waiting to determine whether additional response
   * messages can be sent in the same packet. In most cases, using the
   * TCP_NODELAY socket option provides better performance and lower
   * response times, but disabling it may help for some cases in which
   * the server sends a large number of entries to a client in response
   * to a search request.
   *
   * @return Returns the "use-tcp-no-delay" property definition.
   */
  public BooleanPropertyDefinition getUseTCPNoDelayPropertyDefinition() {
    return PD_USE_TCP_NO_DELAY;
  }



  /**
   * Managed object client implementation.
   */
  private static class LDAPPassThroughAuthenticationPolicyCfgClientImpl implements
    LDAPPassThroughAuthenticationPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfgClient> impl;



    /** Private constructor. */
    private LDAPPassThroughAuthenticationPolicyCfgClientImpl(
        ManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public String getCachedPasswordStorageScheme() {
      return impl.getPropertyValue(INSTANCE.getCachedPasswordStorageSchemePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCachedPasswordStorageScheme(String value) {
      impl.setPropertyValue(INSTANCE.getCachedPasswordStorageSchemePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getCachedPasswordTTL() {
      return impl.getPropertyValue(INSTANCE.getCachedPasswordTTLPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCachedPasswordTTL(Long value) {
      impl.setPropertyValue(INSTANCE.getCachedPasswordTTLPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getConnectionTimeout() {
      return impl.getPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionTimeout(Long value) {
      impl.setPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition(), value);
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
    public SortedSet<AttributeType> getMappedAttribute() {
      return impl.getPropertyValues(INSTANCE.getMappedAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedAttribute(Collection<AttributeType> values) {
      impl.setPropertyValues(INSTANCE.getMappedAttributePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getMappedSearchBaseDN() {
      return impl.getPropertyValues(INSTANCE.getMappedSearchBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBaseDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getMappedSearchBaseDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public DN getMappedSearchBindDN() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchBindDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBindDN(DN value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchBindDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPassword() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBindPassword(String value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordEnvironmentVariable() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordEnvironmentVariablePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBindPasswordEnvironmentVariable(String value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchBindPasswordEnvironmentVariablePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordFile() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBindPasswordFile(String value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchBindPasswordFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordProperty() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchBindPasswordProperty(String value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMappedSearchFilterTemplate() {
      return impl.getPropertyValue(INSTANCE.getMappedSearchFilterTemplatePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappedSearchFilterTemplate(String value) {
      impl.setPropertyValue(INSTANCE.getMappedSearchFilterTemplatePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public MappingPolicy getMappingPolicy() {
      return impl.getPropertyValue(INSTANCE.getMappingPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMappingPolicy(MappingPolicy value) {
      impl.setPropertyValue(INSTANCE.getMappingPolicyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPrimaryRemoteLDAPServer() {
      return impl.getPropertyValues(INSTANCE.getPrimaryRemoteLDAPServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPrimaryRemoteLDAPServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getPrimaryRemoteLDAPServerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSecondaryRemoteLDAPServer() {
      return impl.getPropertyValues(INSTANCE.getSecondaryRemoteLDAPServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSecondaryRemoteLDAPServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSecondaryRemoteLDAPServerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public InetAddress getSourceAddress() {
      return impl.getPropertyValue(INSTANCE.getSourceAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSourceAddress(InetAddress value) {
      impl.setPropertyValue(INSTANCE.getSourceAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCipherSuite() {
      return impl.getPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLCipherSuite(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLProtocol() {
      return impl.getPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLProtocol(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUsePasswordCaching() {
      return impl.getPropertyValue(INSTANCE.getUsePasswordCachingPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUsePasswordCaching(boolean value) {
      impl.setPropertyValue(INSTANCE.getUsePasswordCachingPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUseSSL() {
      return impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseSSL(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseSSLPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUseTCPKeepAlive() {
      return impl.getPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseTCPKeepAlive(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUseTCPNoDelay() {
      return impl.getPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseTCPNoDelay(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends LDAPPassThroughAuthenticationPolicyCfgClient, ? extends LDAPPassThroughAuthenticationPolicyCfg> definition() {
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
  private static class LDAPPassThroughAuthenticationPolicyCfgServerImpl implements
    LDAPPassThroughAuthenticationPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfg> impl;

    /** The value of the "cached-password-storage-scheme" property. */
    private final String pCachedPasswordStorageScheme;

    /** The value of the "cached-password-ttl" property. */
    private final long pCachedPasswordTTL;

    /** The value of the "connection-timeout" property. */
    private final long pConnectionTimeout;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "mapped-attribute" property. */
    private final SortedSet<AttributeType> pMappedAttribute;

    /** The value of the "mapped-search-base-dn" property. */
    private final SortedSet<DN> pMappedSearchBaseDN;

    /** The value of the "mapped-search-bind-dn" property. */
    private final DN pMappedSearchBindDN;

    /** The value of the "mapped-search-bind-password" property. */
    private final String pMappedSearchBindPassword;

    /** The value of the "mapped-search-bind-password-environment-variable" property. */
    private final String pMappedSearchBindPasswordEnvironmentVariable;

    /** The value of the "mapped-search-bind-password-file" property. */
    private final String pMappedSearchBindPasswordFile;

    /** The value of the "mapped-search-bind-password-property" property. */
    private final String pMappedSearchBindPasswordProperty;

    /** The value of the "mapped-search-filter-template" property. */
    private final String pMappedSearchFilterTemplate;

    /** The value of the "mapping-policy" property. */
    private final MappingPolicy pMappingPolicy;

    /** The value of the "primary-remote-ldap-server" property. */
    private final SortedSet<String> pPrimaryRemoteLDAPServer;

    /** The value of the "secondary-remote-ldap-server" property. */
    private final SortedSet<String> pSecondaryRemoteLDAPServer;

    /** The value of the "source-address" property. */
    private final InetAddress pSourceAddress;

    /** The value of the "ssl-cipher-suite" property. */
    private final SortedSet<String> pSSLCipherSuite;

    /** The value of the "ssl-protocol" property. */
    private final SortedSet<String> pSSLProtocol;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;

    /** The value of the "use-password-caching" property. */
    private final boolean pUsePasswordCaching;

    /** The value of the "use-ssl" property. */
    private final boolean pUseSSL;

    /** The value of the "use-tcp-keep-alive" property. */
    private final boolean pUseTCPKeepAlive;

    /** The value of the "use-tcp-no-delay" property. */
    private final boolean pUseTCPNoDelay;



    /** Private constructor. */
    private LDAPPassThroughAuthenticationPolicyCfgServerImpl(ServerManagedObject<? extends LDAPPassThroughAuthenticationPolicyCfg> impl) {
      this.impl = impl;
      this.pCachedPasswordStorageScheme = impl.getPropertyValue(INSTANCE.getCachedPasswordStorageSchemePropertyDefinition());
      this.pCachedPasswordTTL = impl.getPropertyValue(INSTANCE.getCachedPasswordTTLPropertyDefinition());
      this.pConnectionTimeout = impl.getPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMappedAttribute = impl.getPropertyValues(INSTANCE.getMappedAttributePropertyDefinition());
      this.pMappedSearchBaseDN = impl.getPropertyValues(INSTANCE.getMappedSearchBaseDNPropertyDefinition());
      this.pMappedSearchBindDN = impl.getPropertyValue(INSTANCE.getMappedSearchBindDNPropertyDefinition());
      this.pMappedSearchBindPassword = impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyDefinition());
      this.pMappedSearchBindPasswordEnvironmentVariable = impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordEnvironmentVariablePropertyDefinition());
      this.pMappedSearchBindPasswordFile = impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordFilePropertyDefinition());
      this.pMappedSearchBindPasswordProperty = impl.getPropertyValue(INSTANCE.getMappedSearchBindPasswordPropertyPropertyDefinition());
      this.pMappedSearchFilterTemplate = impl.getPropertyValue(INSTANCE.getMappedSearchFilterTemplatePropertyDefinition());
      this.pMappingPolicy = impl.getPropertyValue(INSTANCE.getMappingPolicyPropertyDefinition());
      this.pPrimaryRemoteLDAPServer = impl.getPropertyValues(INSTANCE.getPrimaryRemoteLDAPServerPropertyDefinition());
      this.pSecondaryRemoteLDAPServer = impl.getPropertyValues(INSTANCE.getSecondaryRemoteLDAPServerPropertyDefinition());
      this.pSourceAddress = impl.getPropertyValue(INSTANCE.getSourceAddressPropertyDefinition());
      this.pSSLCipherSuite = impl.getPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition());
      this.pSSLProtocol = impl.getPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
      this.pUsePasswordCaching = impl.getPropertyValue(INSTANCE.getUsePasswordCachingPropertyDefinition());
      this.pUseSSL = impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
      this.pUseTCPKeepAlive = impl.getPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition());
      this.pUseTCPNoDelay = impl.getPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addLDAPPassThroughChangeListener(
        ConfigurationChangeListener<LDAPPassThroughAuthenticationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeLDAPPassThroughChangeListener(
        ConfigurationChangeListener<LDAPPassThroughAuthenticationPolicyCfg> listener) {
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
    public String getCachedPasswordStorageScheme() {
      return pCachedPasswordStorageScheme;
    }



    /**
     * {@inheritDoc}
     */
    public DN getCachedPasswordStorageSchemeDN() {
      String value = getCachedPasswordStorageScheme();
      if (value == null) return null;
      return INSTANCE.getCachedPasswordStorageSchemePropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public long getCachedPasswordTTL() {
      return pCachedPasswordTTL;
    }



    /** {@inheritDoc} */
    public long getConnectionTimeout() {
      return pConnectionTimeout;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getMappedAttribute() {
      return pMappedAttribute;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getMappedSearchBaseDN() {
      return pMappedSearchBaseDN;
    }



    /** {@inheritDoc} */
    public DN getMappedSearchBindDN() {
      return pMappedSearchBindDN;
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPassword() {
      return pMappedSearchBindPassword;
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordEnvironmentVariable() {
      return pMappedSearchBindPasswordEnvironmentVariable;
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordFile() {
      return pMappedSearchBindPasswordFile;
    }



    /** {@inheritDoc} */
    public String getMappedSearchBindPasswordProperty() {
      return pMappedSearchBindPasswordProperty;
    }



    /** {@inheritDoc} */
    public String getMappedSearchFilterTemplate() {
      return pMappedSearchFilterTemplate;
    }



    /** {@inheritDoc} */
    public MappingPolicy getMappingPolicy() {
      return pMappingPolicy;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getPrimaryRemoteLDAPServer() {
      return pPrimaryRemoteLDAPServer;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSecondaryRemoteLDAPServer() {
      return pSecondaryRemoteLDAPServer;
    }



    /** {@inheritDoc} */
    public InetAddress getSourceAddress() {
      return pSourceAddress;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCipherSuite() {
      return pSSLCipherSuite;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLProtocol() {
      return pSSLProtocol;
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return pTrustManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getTrustManagerProviderDN() {
      String value = getTrustManagerProvider();
      if (value == null) return null;
      return INSTANCE.getTrustManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public boolean isUsePasswordCaching() {
      return pUsePasswordCaching;
    }



    /** {@inheritDoc} */
    public boolean isUseSSL() {
      return pUseSSL;
    }



    /** {@inheritDoc} */
    public boolean isUseTCPKeepAlive() {
      return pUseTCPKeepAlive;
    }



    /** {@inheritDoc} */
    public boolean isUseTCPNoDelay() {
      return pUseTCPNoDelay;
    }



    /** {@inheritDoc} */
    public Class<? extends LDAPPassThroughAuthenticationPolicyCfg> configurationClass() {
      return LDAPPassThroughAuthenticationPolicyCfg.class;
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
