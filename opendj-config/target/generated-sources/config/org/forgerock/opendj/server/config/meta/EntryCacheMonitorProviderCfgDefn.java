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
import org.forgerock.opendj.server.config.client.EntryCacheMonitorProviderCfgClient;
import org.forgerock.opendj.server.config.server.EntryCacheMonitorProviderCfg;
import org.forgerock.opendj.server.config.server.MonitorProviderCfg;



/**
 * An interface for querying the Entry Cache Monitor Provider managed
 * object definition meta information.
 * <p>
 * The Entry Cache Monitor Provider exposes monitor information about
 * the state of OpenDJ directory server entry caches.
 */
public final class EntryCacheMonitorProviderCfgDefn extends ManagedObjectDefinition<EntryCacheMonitorProviderCfgClient, EntryCacheMonitorProviderCfg> {

  /** The singleton configuration definition instance. */
  private static final EntryCacheMonitorProviderCfgDefn INSTANCE = new EntryCacheMonitorProviderCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.monitors.EntryCacheMonitorProvider");
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
   * Get the Entry Cache Monitor Provider configuration definition
   * singleton.
   *
   * @return Returns the Entry Cache Monitor Provider configuration
   *         definition singleton.
   */
  public static EntryCacheMonitorProviderCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private EntryCacheMonitorProviderCfgDefn() {
    super("entry-cache-monitor-provider", MonitorProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public EntryCacheMonitorProviderCfgClient createClientConfiguration(
      ManagedObject<? extends EntryCacheMonitorProviderCfgClient> impl) {
    return new EntryCacheMonitorProviderCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public EntryCacheMonitorProviderCfg createServerConfiguration(
      ServerManagedObject<? extends EntryCacheMonitorProviderCfg> impl) {
    return new EntryCacheMonitorProviderCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<EntryCacheMonitorProviderCfg> getServerConfigurationClass() {
    return EntryCacheMonitorProviderCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Entry Cache Monitor Provider is enabled for
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
   * provides the Entry Cache Monitor Provider implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class EntryCacheMonitorProviderCfgClientImpl implements
    EntryCacheMonitorProviderCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends EntryCacheMonitorProviderCfgClient> impl;



    /** Private constructor. */
    private EntryCacheMonitorProviderCfgClientImpl(
        ManagedObject<? extends EntryCacheMonitorProviderCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends EntryCacheMonitorProviderCfgClient, ? extends EntryCacheMonitorProviderCfg> definition() {
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
  private static class EntryCacheMonitorProviderCfgServerImpl implements
    EntryCacheMonitorProviderCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends EntryCacheMonitorProviderCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private EntryCacheMonitorProviderCfgServerImpl(ServerManagedObject<? extends EntryCacheMonitorProviderCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addEntryCacheChangeListener(
        ConfigurationChangeListener<EntryCacheMonitorProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeEntryCacheChangeListener(
        ConfigurationChangeListener<EntryCacheMonitorProviderCfg> listener) {
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
    public Class<? extends EntryCacheMonitorProviderCfg> configurationClass() {
      return EntryCacheMonitorProviderCfg.class;
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
