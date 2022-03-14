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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.ExternalHTTPAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.server.ExternalHTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.HTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;



/**
 * An interface for querying the External HTTP Access Log Publisher
 * managed object definition meta information.
 * <p>
 * External HTTP Access Log Publishers publish HTTP access messages to
 * an external handler.
 */
public final class ExternalHTTPAccessLogPublisherCfgDefn extends ManagedObjectDefinition<ExternalHTTPAccessLogPublisherCfgClient, ExternalHTTPAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final ExternalHTTPAccessLogPublisherCfgDefn INSTANCE = new ExternalHTTPAccessLogPublisherCfgDefn();



  /** The "config-file" property definition. */
  private static final StringPropertyDefinition PD_CONFIG_FILE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "config-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "config-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "config-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FILE");
      PD_CONFIG_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFIG_FILE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.CommonAuditHTTPAccessLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the External HTTP Access Log Publisher configuration
   * definition singleton.
   *
   * @return Returns the External HTTP Access Log Publisher
   *         configuration definition singleton.
   */
  public static ExternalHTTPAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ExternalHTTPAccessLogPublisherCfgDefn() {
    super("external-http-access-log-publisher", HTTPAccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ExternalHTTPAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends ExternalHTTPAccessLogPublisherCfgClient> impl) {
    return new ExternalHTTPAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ExternalHTTPAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends ExternalHTTPAccessLogPublisherCfg> impl) {
    return new ExternalHTTPAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ExternalHTTPAccessLogPublisherCfg> getServerConfigurationClass() {
    return ExternalHTTPAccessLogPublisherCfg.class;
  }



  /**
   * Get the "config-file" property definition.
   * <p>
   * The JSON configuration file that defines the External HTTP Access
   * Log Publisher. The content of the JSON configuration file depends
   * on the type of external audit event handler. The path to the file
   * is relative to the server root.
   *
   * @return Returns the "config-file" property definition.
   */
  public StringPropertyDefinition getConfigFilePropertyDefinition() {
    return PD_CONFIG_FILE;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the External HTTP Access Log Publisher is
   * enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPAccessLogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * External HTTP Access Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class ExternalHTTPAccessLogPublisherCfgClientImpl implements
    ExternalHTTPAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ExternalHTTPAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private ExternalHTTPAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends ExternalHTTPAccessLogPublisherCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public String getConfigFile() {
      return impl.getPropertyValue(INSTANCE.getConfigFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConfigFile(String value) {
      impl.setPropertyValue(INSTANCE.getConfigFilePropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends ExternalHTTPAccessLogPublisherCfgClient, ? extends ExternalHTTPAccessLogPublisherCfg> definition() {
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
  private static class ExternalHTTPAccessLogPublisherCfgServerImpl implements
    ExternalHTTPAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ExternalHTTPAccessLogPublisherCfg> impl;

    /** The value of the "config-file" property. */
    private final String pConfigFile;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private ExternalHTTPAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends ExternalHTTPAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pConfigFile = impl.getPropertyValue(INSTANCE.getConfigFilePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addExternalHTTPAccessChangeListener(
        ConfigurationChangeListener<ExternalHTTPAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeExternalHTTPAccessChangeListener(
        ConfigurationChangeListener<ExternalHTTPAccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addHTTPAccessChangeListener(
        ConfigurationChangeListener<HTTPAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPAccessChangeListener(
        ConfigurationChangeListener<HTTPAccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<LogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<LogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getConfigFile() {
      return pConfigFile;
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
    public Class<? extends ExternalHTTPAccessLogPublisherCfg> configurationClass() {
      return ExternalHTTPAccessLogPublisherCfg.class;
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
