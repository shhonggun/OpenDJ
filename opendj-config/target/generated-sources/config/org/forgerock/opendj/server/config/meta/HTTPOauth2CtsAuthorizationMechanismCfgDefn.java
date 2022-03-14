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
import org.forgerock.opendj.server.config.client.HTTPOauth2CtsAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2AuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPOauth2CtsAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;



/**
 * An interface for querying the HTTP Oauth2 Cts Authorization
 * Mechanism managed object definition meta information.
 * <p>
 * The HTTP Oauth2 Cts Authorization Mechanism is used to define
 * OAuth2 authorization through a direct access to the CTS (Core Token
 * Service).
 */
public final class HTTPOauth2CtsAuthorizationMechanismCfgDefn extends ManagedObjectDefinition<HTTPOauth2CtsAuthorizationMechanismCfgClient, HTTPOauth2CtsAuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPOauth2CtsAuthorizationMechanismCfgDefn INSTANCE = new HTTPOauth2CtsAuthorizationMechanismCfgDefn();



  /** The "authzid-json-pointer" property definition. */
  private static final StringPropertyDefinition PD_AUTHZID_JSON_POINTER;



  /** The "base-dn" property definition. */
  private static final StringPropertyDefinition PD_BASE_DN;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "authzid-json-pointer" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "authzid-json-pointer");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "authzid-json-pointer"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_AUTHZID_JSON_POINTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_AUTHZID_JSON_POINTER);
  }



  /** Build the "base-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "base-dn");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "base-dn"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BASE_DN);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.authz.HttpOAuth2CtsAuthorizationMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.protocols.http.authz.HttpAuthorizationMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the HTTP Oauth2 Cts Authorization Mechanism configuration
   * definition singleton.
   *
   * @return Returns the HTTP Oauth2 Cts Authorization Mechanism
   *         configuration definition singleton.
   */
  public static HTTPOauth2CtsAuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPOauth2CtsAuthorizationMechanismCfgDefn() {
    super("http-oauth2-cts-authorization-mechanism", HTTPOauth2AuthorizationMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPOauth2CtsAuthorizationMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfgClient> impl) {
    return new HTTPOauth2CtsAuthorizationMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPOauth2CtsAuthorizationMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfg> impl) {
    return new HTTPOauth2CtsAuthorizationMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPOauth2CtsAuthorizationMechanismCfg> getServerConfigurationClass() {
    return HTTPOauth2CtsAuthorizationMechanismCfg.class;
  }



  /**
   * Get the "access-token-cache-enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Cts Authorization Mechanism is
   * enabled for use.
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
   * Get the "base-dn" property definition.
   * <p>
   * The base DN of the Core Token Service where access token are
   * stored. (example:
   * ou=famrecords,ou=openam-session,ou=tokens,dc=example,dc=com)
   *
   * @return Returns the "base-dn" property definition.
   */
  public StringPropertyDefinition getBaseDNPropertyDefinition() {
    return PD_BASE_DN;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Cts Authorization Mechanism is
   * enabled.
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
   * provides the HTTP Oauth2 Cts Authorization Mechanism
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
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
   * Managed object client implementation.
   */
  private static class HTTPOauth2CtsAuthorizationMechanismCfgClientImpl implements
    HTTPOauth2CtsAuthorizationMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfgClient> impl;



    /** Private constructor. */
    private HTTPOauth2CtsAuthorizationMechanismCfgClientImpl(
        ManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfgClient> impl) {
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
    public String getBaseDN() {
      return impl.getPropertyValue(INSTANCE.getBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBaseDN(String value) {
      impl.setPropertyValue(INSTANCE.getBaseDNPropertyDefinition(), value);
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
    public SortedSet<String> getRequiredScope() {
      return impl.getPropertyValues(INSTANCE.getRequiredScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRequiredScope(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRequiredScopePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends HTTPOauth2CtsAuthorizationMechanismCfgClient, ? extends HTTPOauth2CtsAuthorizationMechanismCfg> definition() {
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
  private static class HTTPOauth2CtsAuthorizationMechanismCfgServerImpl implements
    HTTPOauth2CtsAuthorizationMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfg> impl;

    /** The value of the "access-token-cache-enabled" property. */
    private final boolean pAccessTokenCacheEnabled;

    /** The value of the "access-token-cache-expiration" property. */
    private final Long pAccessTokenCacheExpiration;

    /** The value of the "authzid-json-pointer" property. */
    private final String pAuthzidJsonPointer;

    /** The value of the "base-dn" property. */
    private final String pBaseDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "required-scope" property. */
    private final SortedSet<String> pRequiredScope;



    /** Private constructor. */
    private HTTPOauth2CtsAuthorizationMechanismCfgServerImpl(ServerManagedObject<? extends HTTPOauth2CtsAuthorizationMechanismCfg> impl) {
      this.impl = impl;
      this.pAccessTokenCacheEnabled = impl.getPropertyValue(INSTANCE.getAccessTokenCacheEnabledPropertyDefinition());
      this.pAccessTokenCacheExpiration = impl.getPropertyValue(INSTANCE.getAccessTokenCacheExpirationPropertyDefinition());
      this.pAuthzidJsonPointer = impl.getPropertyValue(INSTANCE.getAuthzidJsonPointerPropertyDefinition());
      this.pBaseDN = impl.getPropertyValue(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pRequiredScope = impl.getPropertyValues(INSTANCE.getRequiredScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPOauth2CtsAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2CtsAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPOauth2CtsAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPOauth2CtsAuthorizationMechanismCfg> listener) {
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
    public String getBaseDN() {
      return pBaseDN;
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
    public SortedSet<String> getRequiredScope() {
      return pRequiredScope;
    }



    /** {@inheritDoc} */
    public Class<? extends HTTPOauth2CtsAuthorizationMechanismCfg> configurationClass() {
      return HTTPOauth2CtsAuthorizationMechanismCfg.class;
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
