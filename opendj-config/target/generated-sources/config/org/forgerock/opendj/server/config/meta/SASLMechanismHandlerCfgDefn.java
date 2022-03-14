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
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.SASLMechanismHandlerCfgClient;
import org.forgerock.opendj.server.config.server.SASLMechanismHandlerCfg;



/**
 * An interface for querying the SASL Mechanism Handler managed object
 * definition meta information.
 * <p>
 * The SASL mechanism handler configuration entry is the parent for
 * all SASL mechanism handlers defined in the OpenDJ directory server.
 */
public final class SASLMechanismHandlerCfgDefn extends ManagedObjectDefinition<SASLMechanismHandlerCfgClient, SASLMechanismHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final SASLMechanismHandlerCfgDefn INSTANCE = new SASLMechanismHandlerCfgDefn();



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.SASLMechanismHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the SASL Mechanism Handler configuration definition
   * singleton.
   *
   * @return Returns the SASL Mechanism Handler configuration
   *         definition singleton.
   */
  public static SASLMechanismHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SASLMechanismHandlerCfgDefn() {
    super("sasl-mechanism-handler", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SASLMechanismHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends SASLMechanismHandlerCfgClient> impl) {
    return new SASLMechanismHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SASLMechanismHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends SASLMechanismHandlerCfg> impl) {
    return new SASLMechanismHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SASLMechanismHandlerCfg> getServerConfigurationClass() {
    return SASLMechanismHandlerCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SASL mechanism handler is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
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
  private static class SASLMechanismHandlerCfgClientImpl implements
    SASLMechanismHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SASLMechanismHandlerCfgClient> impl;



    /** Private constructor. */
    private SASLMechanismHandlerCfgClientImpl(
        ManagedObject<? extends SASLMechanismHandlerCfgClient> impl) {
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
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SASLMechanismHandlerCfgClient, ? extends SASLMechanismHandlerCfg> definition() {
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
  private static class SASLMechanismHandlerCfgServerImpl implements
    SASLMechanismHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SASLMechanismHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private SASLMechanismHandlerCfgServerImpl(ServerManagedObject<? extends SASLMechanismHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
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
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends SASLMechanismHandlerCfg> configurationClass() {
      return SASLMechanismHandlerCfg.class;
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
