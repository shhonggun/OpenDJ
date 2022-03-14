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
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.SystemInfoMonitorProviderCfgClient;
import org.forgerock.opendj.server.config.server.MonitorProviderCfg;
import org.forgerock.opendj.server.config.server.SystemInfoMonitorProviderCfg;



/**
 * An interface for querying the System Info Monitor Provider managed
 * object definition meta information.
 * <p>
 * The System Info Monitor Provider can be used to publish information
 * about the system and virtual machine on which the directory server
 * is running.
 */
public final class SystemInfoMonitorProviderCfgDefn extends ManagedObjectDefinition<SystemInfoMonitorProviderCfgClient, SystemInfoMonitorProviderCfg> {

  /** The singleton configuration definition instance. */
  private static final SystemInfoMonitorProviderCfgDefn INSTANCE = new SystemInfoMonitorProviderCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.monitors.SystemInfoMonitorProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.MonitorProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the System Info Monitor Provider configuration definition
   * singleton.
   *
   * @return Returns the System Info Monitor Provider configuration
   *         definition singleton.
   */
  public static SystemInfoMonitorProviderCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SystemInfoMonitorProviderCfgDefn() {
    super("system-info-monitor-provider", MonitorProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SystemInfoMonitorProviderCfgClient createClientConfiguration(
      ManagedObject<? extends SystemInfoMonitorProviderCfgClient> impl) {
    return new SystemInfoMonitorProviderCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SystemInfoMonitorProviderCfg createServerConfiguration(
      ServerManagedObject<? extends SystemInfoMonitorProviderCfg> impl) {
    return new SystemInfoMonitorProviderCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SystemInfoMonitorProviderCfg> getServerConfigurationClass() {
    return SystemInfoMonitorProviderCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the System Info Monitor Provider is enabled for
   * use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return MonitorProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the System Info Monitor Provider implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SystemInfoMonitorProviderCfgClientImpl implements
    SystemInfoMonitorProviderCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SystemInfoMonitorProviderCfgClient> impl;



    /** Private constructor. */
    private SystemInfoMonitorProviderCfgClientImpl(
        ManagedObject<? extends SystemInfoMonitorProviderCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends SystemInfoMonitorProviderCfgClient, ? extends SystemInfoMonitorProviderCfg> definition() {
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
  private static class SystemInfoMonitorProviderCfgServerImpl implements
    SystemInfoMonitorProviderCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SystemInfoMonitorProviderCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private SystemInfoMonitorProviderCfgServerImpl(ServerManagedObject<? extends SystemInfoMonitorProviderCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSystemInfoChangeListener(
        ConfigurationChangeListener<SystemInfoMonitorProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSystemInfoChangeListener(
        ConfigurationChangeListener<SystemInfoMonitorProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<MonitorProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<MonitorProviderCfg> listener) {
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
    public Class<? extends SystemInfoMonitorProviderCfg> configurationClass() {
      return SystemInfoMonitorProviderCfg.class;
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
