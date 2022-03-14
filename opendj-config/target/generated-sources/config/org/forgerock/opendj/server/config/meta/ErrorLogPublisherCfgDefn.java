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
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.ErrorLogPublisherCfgClient;
import org.forgerock.opendj.server.config.server.ErrorLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;



/**
 * An interface for querying the Error Log Publisher managed object
 * definition meta information.
 * <p>
 * Error Log Publishers are responsible for distributing error log
 * messages from the error logger to a destination.
 */
public final class ErrorLogPublisherCfgDefn extends ManagedObjectDefinition<ErrorLogPublisherCfgClient, ErrorLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final ErrorLogPublisherCfgDefn INSTANCE = new ErrorLogPublisherCfgDefn();



  /**
   * Defines the set of permissable values for the "default-severity" property.
   * <p>
   * Specifies the default severity levels for the logger.
   */
  public static enum DefaultSeverity {

    /**
     * Messages of all severity levels are logged.
     */
    ALL("all"),



    /**
     * The error log severity that is used for messages that provide
     * debugging information triggered during processing.
     */
    DEBUG("debug"),



    /**
     * The error log severity that is used for messages that provide
     * information about errors which may force the server to shut down
     * or operate in a significantly degraded state.
     */
    ERROR("error"),



    /**
     * The error log severity that is used for messages that provide
     * information about significant events within the server that are
     * not warnings or errors.
     */
    INFO("info"),



    /**
     * No messages of any severity are logged by default. This value
     * is intended to be used in conjunction with the override-severity
     * property to define an error logger that will publish no error
     * message beside the errors of a given category.
     */
    NONE("none"),



    /**
     * The error log severity that is used for the most important
     * informational messages (i.e., information that should almost
     * always be logged but is not associated with a warning or error
     * condition).
     */
    NOTICE("notice"),



    /**
     * The error log severity that is used for messages that provide
     * information about warnings triggered during processing.
     */
    WARNING("warning");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private DefaultSeverity(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "default-severity" property definition. */
  private static final EnumPropertyDefinition<DefaultSeverity> PD_DEFAULT_SEVERITY;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "override-severity" property definition. */
  private static final StringPropertyDefinition PD_OVERRIDE_SEVERITY;



  /** Build the "default-severity" property definition. */
  static {
      EnumPropertyDefinition.Builder<DefaultSeverity> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "default-severity");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-severity"));
      DefaultBehaviorProvider<DefaultSeverity> provider = new DefinedDefaultBehaviorProvider<DefaultSeverity>("error", "warning");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(DefaultSeverity.class);
      PD_DEFAULT_SEVERITY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_SEVERITY);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.ErrorLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "override-severity" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "override-severity");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "override-severity"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "override-severity"));
      builder.setPattern(".*", "STRING");
      PD_OVERRIDE_SEVERITY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OVERRIDE_SEVERITY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Error Log Publisher configuration definition singleton.
   *
   * @return Returns the Error Log Publisher configuration definition
   *         singleton.
   */
  public static ErrorLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ErrorLogPublisherCfgDefn() {
    super("error-log-publisher", LogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ErrorLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends ErrorLogPublisherCfgClient> impl) {
    return new ErrorLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ErrorLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends ErrorLogPublisherCfg> impl) {
    return new ErrorLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ErrorLogPublisherCfg> getServerConfigurationClass() {
    return ErrorLogPublisherCfg.class;
  }



  /**
   * Get the "default-severity" property definition.
   * <p>
   * Specifies the default severity levels for the logger.
   *
   * @return Returns the "default-severity" property definition.
   */
  public EnumPropertyDefinition<DefaultSeverity> getDefaultSeverityPropertyDefinition() {
    return PD_DEFAULT_SEVERITY;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Error Log Publisher is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return LogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Error Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "override-severity" property definition.
   * <p>
   * Specifies the override severity levels for the logger based on
   * the category of the messages.
   * <p>
   * Each override severity level should include the category and the
   * severity levels to log for that category, for example,
   * core=error,info,warning. Valid categories are: core, extensions,
   * protocol, config, log, util, schema, plugin, jeb, backend, tools,
   * task, access-control, admin, sync, version, quicksetup,
   * admin-tool, dsconfig, user-defined. Valid severities are: all,
   * error, info, warning, notice, debug.
   *
   * @return Returns the "override-severity" property definition.
   */
  public StringPropertyDefinition getOverrideSeverityPropertyDefinition() {
    return PD_OVERRIDE_SEVERITY;
  }



  /**
   * Managed object client implementation.
   */
  private static class ErrorLogPublisherCfgClientImpl implements
    ErrorLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ErrorLogPublisherCfgClient> impl;



    /** Private constructor. */
    private ErrorLogPublisherCfgClientImpl(
        ManagedObject<? extends ErrorLogPublisherCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<DefaultSeverity> getDefaultSeverity() {
      return impl.getPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultSeverity(Collection<DefaultSeverity> values) {
      impl.setPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition(), values);
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
    public SortedSet<String> getOverrideSeverity() {
      return impl.getPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOverrideSeverity(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends ErrorLogPublisherCfgClient, ? extends ErrorLogPublisherCfg> definition() {
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
  private static class ErrorLogPublisherCfgServerImpl implements
    ErrorLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ErrorLogPublisherCfg> impl;

    /** The value of the "default-severity" property. */
    private final SortedSet<DefaultSeverity> pDefaultSeverity;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "override-severity" property. */
    private final SortedSet<String> pOverrideSeverity;



    /** Private constructor. */
    private ErrorLogPublisherCfgServerImpl(ServerManagedObject<? extends ErrorLogPublisherCfg> impl) {
      this.impl = impl;
      this.pDefaultSeverity = impl.getPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pOverrideSeverity = impl.getPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addErrorChangeListener(
        ConfigurationChangeListener<ErrorLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeErrorChangeListener(
        ConfigurationChangeListener<ErrorLogPublisherCfg> listener) {
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
    public SortedSet<DefaultSeverity> getDefaultSeverity() {
      return pDefaultSeverity;
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
    public SortedSet<String> getOverrideSeverity() {
      return pOverrideSeverity;
    }



    /** {@inheritDoc} */
    public Class<? extends ErrorLogPublisherCfg> configurationClass() {
      return ErrorLogPublisherCfg.class;
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
