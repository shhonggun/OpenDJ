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
import org.forgerock.opendj.config.GenericConstraint;
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
import org.forgerock.opendj.server.config.client.HTTPBasicAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPBasicAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;



/**
 * An interface for querying the HTTP Basic Authorization Mechanism
 * managed object definition meta information.
 * <p>
 * The HTTP Basic Authorization Mechanism authenticates the end-user
 * using credentials extracted from the HTTP Basic 'Authorization'
 * header.
 */
public final class HTTPBasicAuthorizationMechanismCfgDefn extends ManagedObjectDefinition<HTTPBasicAuthorizationMechanismCfgClient, HTTPBasicAuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPBasicAuthorizationMechanismCfgDefn INSTANCE = new HTTPBasicAuthorizationMechanismCfgDefn();



  /** The "alt-authentication-enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ALT_AUTHENTICATION_ENABLED;



  /** The "alt-password-header" property definition. */
  private static final StringPropertyDefinition PD_ALT_PASSWORD_HEADER;



  /** The "alt-username-header" property definition. */
  private static final StringPropertyDefinition PD_ALT_USERNAME_HEADER;



  /** The "identity-mapper" property definition. */
  private static final AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> PD_IDENTITY_MAPPER;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "alt-authentication-enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "alt-authentication-enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "alt-authentication-enabled"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALT_AUTHENTICATION_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALT_AUTHENTICATION_ENABLED);
  }



  /** Build the "alt-password-header" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "alt-password-header");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "alt-password-header"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_ALT_PASSWORD_HEADER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALT_PASSWORD_HEADER);
  }



  /** Build the "alt-username-header" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "alt-username-header");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "alt-username-header"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_ALT_USERNAME_HEADER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALT_USERNAME_HEADER);
  }



  /** Build the "identity-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<IdentityMapperCfgClient, IdentityMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "identity-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "identity-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("identity-mapper");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_IDENTITY_MAPPER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IDENTITY_MAPPER);
      INSTANCE.registerConstraint(PD_IDENTITY_MAPPER.getSourceConstraint());
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.authz.HttpBasicAuthorizationMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.protocols.http.authz.HttpAuthorizationMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.contains("alt-authentication-enabled", "true"), Conditions.implies(Conditions.isPresent("alt-username-header"), Conditions.isPresent("alt-password-header")))));
  }



  /**
   * Get the HTTP Basic Authorization Mechanism configuration
   * definition singleton.
   *
   * @return Returns the HTTP Basic Authorization Mechanism
   *         configuration definition singleton.
   */
  public static HTTPBasicAuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPBasicAuthorizationMechanismCfgDefn() {
    super("http-basic-authorization-mechanism", HTTPAuthorizationMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPBasicAuthorizationMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPBasicAuthorizationMechanismCfgClient> impl) {
    return new HTTPBasicAuthorizationMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPBasicAuthorizationMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPBasicAuthorizationMechanismCfg> impl) {
    return new HTTPBasicAuthorizationMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPBasicAuthorizationMechanismCfg> getServerConfigurationClass() {
    return HTTPBasicAuthorizationMechanismCfg.class;
  }



  /**
   * Get the "alt-authentication-enabled" property definition.
   * <p>
   * Specifies whether user credentials may be provided using
   * alternative headers to the standard 'Authorize' header.
   *
   * @return Returns the "alt-authentication-enabled" property definition.
   */
  public BooleanPropertyDefinition getAltAuthenticationEnabledPropertyDefinition() {
    return PD_ALT_AUTHENTICATION_ENABLED;
  }



  /**
   * Get the "alt-password-header" property definition.
   * <p>
   * Alternate HTTP headers to get the user's password from.
   *
   * @return Returns the "alt-password-header" property definition.
   */
  public StringPropertyDefinition getAltPasswordHeaderPropertyDefinition() {
    return PD_ALT_PASSWORD_HEADER;
  }



  /**
   * Get the "alt-username-header" property definition.
   * <p>
   * Alternate HTTP headers to get the user's name from.
   *
   * @return Returns the "alt-username-header" property definition.
   */
  public StringPropertyDefinition getAltUsernameHeaderPropertyDefinition() {
    return PD_ALT_USERNAME_HEADER;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Basic Authorization Mechanism is
   * enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPAuthorizationMechanismCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "identity-mapper" property definition.
   * <p>
   * > Specifies the name of the identity mapper used to get the
   * user's entry corresponding to the user-id provided in the HTTP
   * authentication header.
   *
   * @return Returns the "identity-mapper" property definition.
   */
  public AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> getIdentityMapperPropertyDefinition() {
    return PD_IDENTITY_MAPPER;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Basic Authorization Mechanism implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class HTTPBasicAuthorizationMechanismCfgClientImpl implements
    HTTPBasicAuthorizationMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPBasicAuthorizationMechanismCfgClient> impl;



    /** Private constructor. */
    private HTTPBasicAuthorizationMechanismCfgClientImpl(
        ManagedObject<? extends HTTPBasicAuthorizationMechanismCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAltAuthenticationEnabled() {
      return impl.getPropertyValue(INSTANCE.getAltAuthenticationEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAltAuthenticationEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getAltAuthenticationEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getAltPasswordHeader() {
      return impl.getPropertyValue(INSTANCE.getAltPasswordHeaderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAltPasswordHeader(String value) {
      impl.setPropertyValue(INSTANCE.getAltPasswordHeaderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getAltUsernameHeader() {
      return impl.getPropertyValue(INSTANCE.getAltUsernameHeaderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAltUsernameHeader(String value) {
      impl.setPropertyValue(INSTANCE.getAltUsernameHeaderPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends HTTPBasicAuthorizationMechanismCfgClient, ? extends HTTPBasicAuthorizationMechanismCfg> definition() {
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
  private static class HTTPBasicAuthorizationMechanismCfgServerImpl implements
    HTTPBasicAuthorizationMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPBasicAuthorizationMechanismCfg> impl;

    /** The value of the "alt-authentication-enabled" property. */
    private final boolean pAltAuthenticationEnabled;

    /** The value of the "alt-password-header" property. */
    private final String pAltPasswordHeader;

    /** The value of the "alt-username-header" property. */
    private final String pAltUsernameHeader;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private HTTPBasicAuthorizationMechanismCfgServerImpl(ServerManagedObject<? extends HTTPBasicAuthorizationMechanismCfg> impl) {
      this.impl = impl;
      this.pAltAuthenticationEnabled = impl.getPropertyValue(INSTANCE.getAltAuthenticationEnabledPropertyDefinition());
      this.pAltPasswordHeader = impl.getPropertyValue(INSTANCE.getAltPasswordHeaderPropertyDefinition());
      this.pAltUsernameHeader = impl.getPropertyValue(INSTANCE.getAltUsernameHeaderPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPBasicAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPBasicAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPBasicAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPBasicAuthorizationMechanismCfg> listener) {
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
    public boolean isAltAuthenticationEnabled() {
      return pAltAuthenticationEnabled;
    }



    /** {@inheritDoc} */
    public String getAltPasswordHeader() {
      return pAltPasswordHeader;
    }



    /** {@inheritDoc} */
    public String getAltUsernameHeader() {
      return pAltUsernameHeader;
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
    public Class<? extends HTTPBasicAuthorizationMechanismCfg> configurationClass() {
      return HTTPBasicAuthorizationMechanismCfg.class;
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
