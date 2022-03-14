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
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2AuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the HTTP Oauth2 Token Introspection
 * Authorization Mechanism managed object definition meta information.
 * <p>
 * The HTTP Oauth2 Token Introspection Authorization Mechanism is used
 * to define OAuth2 authorization using an introspection (RFC7662)
 * compliant authorization server.
 */
public final class HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgDefn extends ManagedObjectDefinition<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient, HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgDefn INSTANCE = new HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgDefn();



  /** The "authzid-json-pointer" property definition. */
  private static final StringPropertyDefinition PD_AUTHZID_JSON_POINTER;



  /** The "client-id" property definition. */
  private static final StringPropertyDefinition PD_CLIENT_ID;



  /** The "client-secret" property definition. */
  private static final StringPropertyDefinition PD_CLIENT_SECRET;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "token-introspection-url" property definition. */
  private static final StringPropertyDefinition PD_TOKEN_INTROSPECTION_URL;



  /** The "trust-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> PD_TRUST_MANAGER_PROVIDER;



  /** Build the "authzid-json-pointer" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "authzid-json-pointer");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "authzid-json-pointer"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_AUTHZID_JSON_POINTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_AUTHZID_JSON_POINTER);
  }



  /** Build the "client-id" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "client-id");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "client-id"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_CLIENT_ID = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CLIENT_ID);
  }



  /** Build the "client-secret" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "client-secret");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "client-secret"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_CLIENT_SECRET = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CLIENT_SECRET);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.authz.HttpOAuth2TokenIntrospectionAuthorizationMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.protocols.http.authz.HttpAuthorizationMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<KeyManagerProviderCfgClient, KeyManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "key-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-manager-provider"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("key-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_KEY_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_KEY_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "token-introspection-url" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "token-introspection-url");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "token-introspection-url"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TOKEN_INTROSPECTION_URL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TOKEN_INTROSPECTION_URL);
  }



  /** Build the "trust-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<TrustManagerProviderCfgClient, TrustManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "trust-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-manager-provider"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "trust-manager-provider"));
      builder.setParentPath("/");
      builder.setRelationDefinition("trust-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_TRUST_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_TRUST_MANAGER_PROVIDER.getSourceConstraint());
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the HTTP Oauth2 Token Introspection Authorization Mechanism
   * configuration definition singleton.
   *
   * @return Returns the HTTP Oauth2 Token Introspection Authorization
   *         Mechanism configuration definition singleton.
   */
  public static HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgDefn() {
    super("http-oauth2-token-introspection-authorization-mechanism", HTTPOauth2AuthorizationMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient> impl) {
    return new HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> impl) {
    return new HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> getServerConfigurationClass() {
    return HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg.class;
  }



  /**
   * Get the "access-token-cache-enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Token Introspection
   * Authorization Mechanism is enabled for use.
   *
   * @return Returns the "access-token-cache-enabled" property definition.
   */
  public BooleanPropertyDefinition getAccessTokenCacheEnabledPropertyDefinition() {
    return HTTPOauth2AuthorizationMechanismCfgDefn.getInstance().getAccessTokenCacheEnabledPropertyDefinition();
  }



  /**
   * Get the "access-token-cache-expiration" property definition.
   * <p>
   * Token cache expiration
   *
   * @return Returns the "access-token-cache-expiration" property definition.
   */
  public DurationPropertyDefinition getAccessTokenCacheExpirationPropertyDefinition() {
    return HTTPOauth2AuthorizationMechanismCfgDefn.getInstance().getAccessTokenCacheExpirationPropertyDefinition();
  }



  /**
   * Get the "authzid-json-pointer" property definition.
   * <p>
   * Specifies the JSON pointer to the value to use as Authorization
   * ID. The JSON pointer is applied to the resolved access token JSON
   * document. (example: /uid)
   *
   * @return Returns the "authzid-json-pointer" property definition.
   */
  public StringPropertyDefinition getAuthzidJsonPointerPropertyDefinition() {
    return PD_AUTHZID_JSON_POINTER;
  }



  /**
   * Get the "client-id" property definition.
   * <p>
   * Client's ID to use during the HTTP basic authentication against
   * the authorization server.
   *
   * @return Returns the "client-id" property definition.
   */
  public StringPropertyDefinition getClientIdPropertyDefinition() {
    return PD_CLIENT_ID;
  }



  /**
   * Get the "client-secret" property definition.
   * <p>
   * Client's secret to use during the HTTP basic authentication
   * against the authorization server.
   *
   * @return Returns the "client-secret" property definition.
   */
  public StringPropertyDefinition getClientSecretPropertyDefinition() {
    return PD_CLIENT_SECRET;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Token Introspection
   * Authorization Mechanism is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPOauth2AuthorizationMechanismCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "identity-mapper" property definition.
   * <p>
   * > Specifies the name of the identity mapper to use in conjunction
   * with the authzid-json-pointer to get the user corresponding to the
   * acccess-token.
   *
   * @return Returns the "identity-mapper" property definition.
   */
  public AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> getIdentityMapperPropertyDefinition() {
    return HTTPOauth2AuthorizationMechanismCfgDefn.getInstance().getIdentityMapperPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Token Introspection Authorization
   * Mechanism implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "key-manager-provider" property definition.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Oauth2 Token Introspection Authorization Mechanism .
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return PD_KEY_MANAGER_PROVIDER;
  }



  /**
   * Get the "required-scope" property definition.
   * <p>
   * Scopes required to grant access to the service.
   *
   * @return Returns the "required-scope" property definition.
   */
  public StringPropertyDefinition getRequiredScopePropertyDefinition() {
    return HTTPOauth2AuthorizationMechanismCfgDefn.getInstance().getRequiredScopePropertyDefinition();
  }



  /**
   * Get the "token-introspection-url" property definition.
   * <p>
   * Defines the token introspection endpoint URL where the
   * access-token resolution request should be sent. (example:
   * http://example.com/introspect)
   *
   * @return Returns the "token-introspection-url" property definition.
   */
  public StringPropertyDefinition getTokenIntrospectionUrlPropertyDefinition() {
    return PD_TOKEN_INTROSPECTION_URL;
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with the remote authorization server.
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return PD_TRUST_MANAGER_PROVIDER;
  }



  /**
   * Managed object client implementation.
   */
  private static class HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClientImpl implements
    HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient> impl;



    /** Private constructor. */
    private HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClientImpl(
        ManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAccessTokenCacheEnabled() {
      return impl.getPropertyValue(INSTANCE.getAccessTokenCacheEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAccessTokenCacheEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getAccessTokenCacheEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Long getAccessTokenCacheExpiration() {
      return impl.getPropertyValue(INSTANCE.getAccessTokenCacheExpirationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAccessTokenCacheExpiration(Long value) {
      impl.setPropertyValue(INSTANCE.getAccessTokenCacheExpirationPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getAuthzidJsonPointer() {
      return impl.getPropertyValue(INSTANCE.getAuthzidJsonPointerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAuthzidJsonPointer(String value) {
      impl.setPropertyValue(INSTANCE.getAuthzidJsonPointerPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getClientId() {
      return impl.getPropertyValue(INSTANCE.getClientIdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setClientId(String value) {
      impl.setPropertyValue(INSTANCE.getClientIdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getClientSecret() {
      return impl.getPropertyValue(INSTANCE.getClientSecretPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setClientSecret(String value) {
      impl.setPropertyValue(INSTANCE.getClientSecretPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Boolean isEnabled() {
      return impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getIdentityMapper() {
      return impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIdentityMapper(String value) {
      impl.setPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition(), value);
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
    public String getKeyManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequiredScope() {
      return impl.getPropertyValues(INSTANCE.getRequiredScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequiredScope(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRequiredScopePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getTokenIntrospectionUrl() {
      return impl.getPropertyValue(INSTANCE.getTokenIntrospectionUrlPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTokenIntrospectionUrl(String value) {
      impl.setPropertyValue(INSTANCE.getTokenIntrospectionUrlPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient, ? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> definition() {
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
  private static class HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgServerImpl implements
    HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> impl;

    /** The value of the "access-token-cache-enabled" property. */
    private final boolean pAccessTokenCacheEnabled;

    /** The value of the "access-token-cache-expiration" property. */
    private final Long pAccessTokenCacheExpiration;

    /** The value of the "authzid-json-pointer" property. */
    private final String pAuthzidJsonPointer;

    /** The value of the "client-id" property. */
    private final String pClientId;

    /** The value of the "client-secret" property. */
    private final String pClientSecret;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "required-scope" property. */
    private final SortedSet<String> pRequiredScope;

    /** The value of the "token-introspection-url" property. */
    private final String pTokenIntrospectionUrl;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;



    /** Private constructor. */
    private HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgServerImpl(ServerManagedObject<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> impl) {
      this.impl = impl;
      this.pAccessTokenCacheEnabled = impl.getPropertyValue(INSTANCE.getAccessTokenCacheEnabledPropertyDefinition());
      this.pAccessTokenCacheExpiration = impl.getPropertyValue(INSTANCE.getAccessTokenCacheExpirationPropertyDefinition());
      this.pAuthzidJsonPointer = impl.getPropertyValue(INSTANCE.getAuthzidJsonPointerPropertyDefinition());
      this.pClientId = impl.getPropertyValue(INSTANCE.getClientIdPropertyDefinition());
      this.pClientSecret = impl.getPropertyValue(INSTANCE.getClientSecretPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pRequiredScope = impl.getPropertyValues(INSTANCE.getRequiredScopePropertyDefinition());
      this.pTokenIntrospectionUrl = impl.getPropertyValue(INSTANCE.getTokenIntrospectionUrlPropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPOauth2TokenIntrospectionAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPOauth2TokenIntrospectionAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addHTTPOauth2AuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2AuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPOauth2AuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2AuthorizationMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<HTTPAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<HTTPAuthorizationMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isAccessTokenCacheEnabled() {
      return pAccessTokenCacheEnabled;
    }



    /** {@inheritDoc} */
    public Long getAccessTokenCacheExpiration() {
      return pAccessTokenCacheExpiration;
    }



    /** {@inheritDoc} */
    public String getAuthzidJsonPointer() {
      return pAuthzidJsonPointer;
    }



    /** {@inheritDoc} */
    public String getClientId() {
      return pClientId;
    }



    /** {@inheritDoc} */
    public String getClientSecret() {
      return pClientSecret;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getIdentityMapper() {
      return pIdentityMapper;
    }



    /**
     * {@inheritDoc}
     */
    public DN getIdentityMapperDN() {
      String value = getIdentityMapper();
      if (value == null) return null;
      return INSTANCE.getIdentityMapperPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getKeyManagerProvider() {
      return pKeyManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getKeyManagerProviderDN() {
      String value = getKeyManagerProvider();
      if (value == null) return null;
      return INSTANCE.getKeyManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRequiredScope() {
      return pRequiredScope;
    }



    /** {@inheritDoc} */
    public String getTokenIntrospectionUrl() {
      return pTokenIntrospectionUrl;
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
    public Class<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> configurationClass() {
      return HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg.class;
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
