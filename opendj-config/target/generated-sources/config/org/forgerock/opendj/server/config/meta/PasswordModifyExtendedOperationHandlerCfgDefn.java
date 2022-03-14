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
import org.forgerock.opendj.server.config.client.PasswordModifyExtendedOperationHandlerCfgClient;
import org.forgerock.opendj.server.config.server.ExtendedOperationHandlerCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.PasswordModifyExtendedOperationHandlerCfg;



/**
 * An interface for querying the Password Modify Extended Operation
 * Handler managed object definition meta information.
 * <p>
 * The Password Modify Extended Operation Handler allows end users to
 * change their own passwords, or administrators to reset user
 * passwords.
 */
public final class PasswordModifyExtendedOperationHandlerCfgDefn extends ManagedObjectDefinition<PasswordModifyExtendedOperationHandlerCfgClient, PasswordModifyExtendedOperationHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final PasswordModifyExtendedOperationHandlerCfgDefn INSTANCE = new PasswordModifyExtendedOperationHandlerCfgDefn();



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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.PasswordModifyExtendedOperation");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.ExtendedOperationHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Password Modify Extended Operation Handler configuration
   * definition singleton.
   *
   * @return Returns the Password Modify Extended Operation Handler
   *         configuration definition singleton.
   */
  public static PasswordModifyExtendedOperationHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PasswordModifyExtendedOperationHandlerCfgDefn() {
    super("password-modify-extended-operation-handler", ExtendedOperationHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PasswordModifyExtendedOperationHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends PasswordModifyExtendedOperationHandlerCfgClient> impl) {
    return new PasswordModifyExtendedOperationHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PasswordModifyExtendedOperationHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends PasswordModifyExtendedOperationHandlerCfg> impl) {
    return new PasswordModifyExtendedOperationHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PasswordModifyExtendedOperationHandlerCfg> getServerConfigurationClass() {
    return PasswordModifyExtendedOperationHandlerCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Password Modify Extended Operation Handler
   * is enabled (that is, whether the types of extended operations are
   * allowed in the server).
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return ExtendedOperationHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "identity-mapper" property definition.
   * <p>
   * Specifies the name of the identity mapper that should be used in
   * conjunction with the password modify extended operation.
   * <p>
   * This property is used to identify a user based on an
   * authorization ID in the 'u:' form. Changes to this property take
   * effect immediately.
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
   * provides the Password Modify Extended Operation Handler
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class PasswordModifyExtendedOperationHandlerCfgClientImpl implements
    PasswordModifyExtendedOperationHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PasswordModifyExtendedOperationHandlerCfgClient> impl;



    /** Private constructor. */
    private PasswordModifyExtendedOperationHandlerCfgClientImpl(
        ManagedObject<? extends PasswordModifyExtendedOperationHandlerCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends PasswordModifyExtendedOperationHandlerCfgClient, ? extends PasswordModifyExtendedOperationHandlerCfg> definition() {
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
  private static class PasswordModifyExtendedOperationHandlerCfgServerImpl implements
    PasswordModifyExtendedOperationHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PasswordModifyExtendedOperationHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private PasswordModifyExtendedOperationHandlerCfgServerImpl(ServerManagedObject<? extends PasswordModifyExtendedOperationHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPasswordModifyChangeListener(
        ConfigurationChangeListener<PasswordModifyExtendedOperationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePasswordModifyChangeListener(
        ConfigurationChangeListener<PasswordModifyExtendedOperationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ExtendedOperationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ExtendedOperationHandlerCfg> listener) {
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
    public Class<? extends PasswordModifyExtendedOperationHandlerCfg> configurationClass() {
      return PasswordModifyExtendedOperationHandlerCfg.class;
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
