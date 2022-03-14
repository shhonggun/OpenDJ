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
import org.forgerock.opendj.server.config.client.HTTPOauth2OpenamAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2AuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2OpenamAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the HTTP Oauth2 Openam Authorization
 * Mechanism managed object definition meta information.
 * <p>
 * The HTTP Oauth2 Openam Authorization Mechanism is used to define
 * OAuth2 authorization using an OpenAM server as authorization server
 * .
 */
public final class HTTPOauth2OpenamAuthorizationMechanismCfgDefn extends ManagedObjectDefinition<HTTPOauth2OpenamAuthorizationMechanismCfgClient, HTTPOauth2OpenamAuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPOauth2OpenamAuthorizationMechanismCfgDefn INSTANCE = new HTTPOauth2OpenamAuthorizationMechanismCfgDefn();



  /** The "authzid-json-pointer" property definition. */
  private static final StringPropertyDefinition PD_AUTHZID_JSON_POINTER;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "token-info-url" property definition. */
  private static final StringPropertyDefinition PD_TOKEN_INFO_URL;



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



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.authz.HttpOAuth2OpenAmAuthorizationMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.protocols.http.authz.HttpAuthorizationMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<KeyManagerProviderCfgClient, KeyManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "key-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-manager-provider"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "key-manager-provider"));
      builder.setParentPath("/");
      builder.setRelationDefinition("key-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_KEY_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_KEY_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "token-info-url" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "token-info-url");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "token-info-url"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TOKEN_INFO_URL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TOKEN_INFO_URL);
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
   * Get the HTTP Oauth2 Openam Authorization Mechanism configuration
   * definition singleton.
   *
   * @return Returns the HTTP Oauth2 Openam Authorization Mechanism
   *         configuration definition singleton.
   */
  public static HTTPOauth2OpenamAuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPOauth2OpenamAuthorizationMechanismCfgDefn() {
    super("http-oauth2-openam-authorization-mechanism", HTTPOauth2AuthorizationMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPOauth2OpenamAuthorizationMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfgClient> impl) {
    return new HTTPOauth2OpenamAuthorizationMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPOauth2OpenamAuthorizationMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfg> impl) {
    return new HTTPOauth2OpenamAuthorizationMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPOauth2OpenamAuthorizationMechanismCfg> getServerConfigurationClass() {
    return HTTPOauth2OpenamAuthorizationMechanismCfg.class;
  }



  /**
   * Get the "access-token-cache-enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Openam Authorization Mechanism
   * is enabled for use.
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
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Openam Authorization Mechanism
   * is enabled.
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
   * provides the HTTP Oauth2 Openam Authorization Mechanism
   * implementation.
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
   * this HTTP Oauth2 Openam Authorization Mechanism .
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
   * Get the "token-info-url" property definition.
   * <p>
   * Defines the OpenAM endpoint URL where the access-token resolution
   * request should be sent.
   *
   * @return Returns the "token-info-url" property definition.
   */
  public StringPropertyDefinition getTokenInfoUrlPropertyDefinition() {
    return PD_TOKEN_INFO_URL;
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
  private static class HTTPOauth2OpenamAuthorizationMechanismCfgClientImpl implements
    HTTPOauth2OpenamAuthorizationMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfgClient> impl;



    /** Private constructor. */
    private HTTPOauth2OpenamAuthorizationMechanismCfgClientImpl(
        ManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfgClient> impl) {
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
    public String getTokenInfoUrl() {
      return impl.getPropertyValue(INSTANCE.getTokenInfoUrlPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTokenInfoUrl(String value) {
      impl.setPropertyValue(INSTANCE.getTokenInfoUrlPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends HTTPOauth2OpenamAuthorizationMechanismCfgClient, ? extends HTTPOauth2OpenamAuthorizationMechanismCfg> definition() {
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
  private static class HTTPOauth2OpenamAuthorizationMechanismCfgServerImpl implements
    HTTPOauth2OpenamAuthorizationMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfg> impl;

    /** The value of the "access-token-cache-enabled" property. */
    private final boolean pAccessTokenCacheEnabled;

    /** The value of the "access-token-cache-expiration" property. */
    private final Long pAccessTokenCacheExpiration;

    /** The value of the "authzid-json-pointer" property. */
    private final String pAuthzidJsonPointer;

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

    /** The value of the "token-info-url" property. */
    private final String pTokenInfoUrl;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;



    /** Private constructor. */
    private HTTPOauth2OpenamAuthorizationMechanismCfgServerImpl(ServerManagedObject<? extends HTTPOauth2OpenamAuthorizationMechanismCfg> impl) {
      this.impl = impl;
      this.pAccessTokenCacheEnabled = impl.getPropertyValue(INSTANCE.getAccessTokenCacheEnabledPropertyDefinition());
      this.pAccessTokenCacheExpiration = impl.getPropertyValue(INSTANCE.getAccessTokenCacheExpirationPropertyDefinition());
      this.pAuthzidJsonPointer = impl.getPropertyValue(INSTANCE.getAuthzidJsonPointerPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pRequiredScope = impl.getPropertyValues(INSTANCE.getRequiredScopePropertyDefinition());
      this.pTokenInfoUrl = impl.getPropertyValue(INSTANCE.getTokenInfoUrlPropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPOauth2OpenamAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2OpenamAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPOauth2OpenamAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2OpenamAuthorizationMechanismCfg> listener) {
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
    public String getTokenInfoUrl() {
      return pTokenInfoUrl;
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
    public Class<? extends HTTPOauth2OpenamAuthorizationMechanismCfg> configurationClass() {
      return HTTPOauth2OpenamAuthorizationMechanismCfg.class;
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
