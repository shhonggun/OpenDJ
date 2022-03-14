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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.client.PlainSASLMechanismHandlerCfgClient;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.PlainSASLMechanismHandlerCfg;
import org.forgerock.opendj.server.config.server.SASLMechanismHandlerCfg;



/**
 * An interface for querying the Plain SASL Mechanism Handler managed
 * object definition meta information.
 * <p>
 * The Plain SASL Mechanism Handler performs all processing related to
 * SASL PLAIN authentication.
 */
public final class PlainSASLMechanismHandlerCfgDefn extends ManagedObjectDefinition<PlainSASLMechanismHandlerCfgClient, PlainSASLMechanismHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final PlainSASLMechanismHandlerCfgDefn INSTANCE = new PlainSASLMechanismHandlerCfgDefn();



  /** The "identity-mapper" property definition. */
  private static final AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> PD_IDENTITY_MAPPER;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "identity-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<IdentityMapperCfgClient, IdentityMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "identity-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "identity-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("identity-mapper");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
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
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.PlainSASLMechanismHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.SASLMechanismHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the Plain SASL Mechanism Handler configuration definition
   * singleton.
   *
   * @return Returns the Plain SASL Mechanism Handler configuration
   *         definition singleton.
   */
  public static PlainSASLMechanismHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PlainSASLMechanismHandlerCfgDefn() {
    super("plain-sasl-mechanism-handler", SASLMechanismHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PlainSASLMechanismHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends PlainSASLMechanismHandlerCfgClient> impl) {
    return new PlainSASLMechanismHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PlainSASLMechanismHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends PlainSASLMechanismHandlerCfg> impl) {
    return new PlainSASLMechanismHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PlainSASLMechanismHandlerCfg> getServerConfigurationClass() {
    return PlainSASLMechanismHandlerCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SASL mechanism handler is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return SASLMechanismHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "identity-mapper" property definition.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the authentication or
   * authorization ID included in the SASL bind request to the
   * corresponding user in the directory.
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
   * provides the SASL mechanism handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class PlainSASLMechanismHandlerCfgClientImpl implements
    PlainSASLMechanismHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PlainSASLMechanismHandlerCfgClient> impl;



    /** Private constructor. */
    private PlainSASLMechanismHandlerCfgClientImpl(
        ManagedObject<? extends PlainSASLMechanismHandlerCfgClient> impl) {
      this.impl = impl;
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
    public ManagedObjectDefinition<? extends PlainSASLMechanismHandlerCfgClient, ? extends PlainSASLMechanismHandlerCfg> definition() {
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
  private static class PlainSASLMechanismHandlerCfgServerImpl implements
    PlainSASLMechanismHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PlainSASLMechanismHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private PlainSASLMechanismHandlerCfgServerImpl(ServerManagedObject<? extends PlainSASLMechanismHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPlainChangeListener(
        ConfigurationChangeListener<PlainSASLMechanismHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePlainChangeListener(
        ConfigurationChangeListener<PlainSASLMechanismHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<SASLMechanismHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<SASLMechanismHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public Class<? extends PlainSASLMechanismHandlerCfg> configurationClass() {
      return PlainSASLMechanismHandlerCfg.class;
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
