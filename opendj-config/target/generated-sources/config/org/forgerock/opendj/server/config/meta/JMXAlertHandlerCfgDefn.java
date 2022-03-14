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
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.JMXAlertHandlerCfgClient;
import org.forgerock.opendj.server.config.server.AlertHandlerCfg;
import org.forgerock.opendj.server.config.server.JMXAlertHandlerCfg;



/**
 * An interface for querying the JMX Alert Handler managed object
 * definition meta information.
 * <p>
 * The JMX Alert Handler is used to generate JMX notifications to
 * alert administrators of significant events that occur within the
 * server.
 */
public final class JMXAlertHandlerCfgDefn extends ManagedObjectDefinition<JMXAlertHandlerCfgClient, JMXAlertHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final JMXAlertHandlerCfgDefn INSTANCE = new JMXAlertHandlerCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.JMXAlertHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AlertHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the JMX Alert Handler configuration definition singleton.
   *
   * @return Returns the JMX Alert Handler configuration definition
   *         singleton.
   */
  public static JMXAlertHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private JMXAlertHandlerCfgDefn() {
    super("jmx-alert-handler", AlertHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public JMXAlertHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends JMXAlertHandlerCfgClient> impl) {
    return new JMXAlertHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public JMXAlertHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends JMXAlertHandlerCfg> impl) {
    return new JMXAlertHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<JMXAlertHandlerCfg> getServerConfigurationClass() {
    return JMXAlertHandlerCfg.class;
  }



  /**
   * Get the "disabled-alert-type" property definition.
   * <p>
   * Specifies the names of the alert types that are disabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then no alerts with
   * any of the specified types are allowed. If there are no values for
   * this attribute, then only alerts with a type included in the set
   * of enabled alert types are allowed, or if there are no values for
   * the enabled alert types option, then all alert types are allowed.
   *
   * @return Returns the "disabled-alert-type" property definition.
   */
  public StringPropertyDefinition getDisabledAlertTypePropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getDisabledAlertTypePropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the JMX Alert Handler is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "enabled-alert-type" property definition.
   * <p>
   * Specifies the names of the alert types that are enabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then only alerts with
   * one of the specified types are allowed (unless they are also
   * included in the disabled alert types). If there are no values for
   * this attribute, then any alert with a type not included in the
   * list of disabled alert types is allowed.
   *
   * @return Returns the "enabled-alert-type" property definition.
   */
  public StringPropertyDefinition getEnabledAlertTypePropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getEnabledAlertTypePropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the JMX Alert Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class JMXAlertHandlerCfgClientImpl implements
    JMXAlertHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends JMXAlertHandlerCfgClient> impl;



    /** Private constructor. */
    private JMXAlertHandlerCfgClientImpl(
        ManagedObject<? extends JMXAlertHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledAlertType() {
      return impl.getPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDisabledAlertType(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition(), values);
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
    public SortedSet<String> getEnabledAlertType() {
      return impl.getPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabledAlertType(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends JMXAlertHandlerCfgClient, ? extends JMXAlertHandlerCfg> definition() {
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
  private static class JMXAlertHandlerCfgServerImpl implements
    JMXAlertHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends JMXAlertHandlerCfg> impl;

    /** The value of the "disabled-alert-type" property. */
    private final SortedSet<String> pDisabledAlertType;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "enabled-alert-type" property. */
    private final SortedSet<String> pEnabledAlertType;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private JMXAlertHandlerCfgServerImpl(ServerManagedObject<? extends JMXAlertHandlerCfg> impl) {
      this.impl = impl;
      this.pDisabledAlertType = impl.getPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pEnabledAlertType = impl.getPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addJMXChangeListener(
        ConfigurationChangeListener<JMXAlertHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeJMXChangeListener(
        ConfigurationChangeListener<JMXAlertHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AlertHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AlertHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledAlertType() {
      return pDisabledAlertType;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getEnabledAlertType() {
      return pEnabledAlertType;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends JMXAlertHandlerCfg> configurationClass() {
      return JMXAlertHandlerCfg.class;
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
