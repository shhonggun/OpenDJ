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
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.AccessLogFilteringCriteriaCfgClient;
import org.forgerock.opendj.server.config.client.ExternalAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.meta.AccessLogPublisherCfgDefn.FilteringPolicy;
import org.forgerock.opendj.server.config.server.AccessLogFilteringCriteriaCfg;
import org.forgerock.opendj.server.config.server.AccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.ExternalAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;



/**
 * An interface for querying the External Access Log Publisher managed
 * object definition meta information.
 * <p>
 * External Access Log Publishers publish access messages to an
 * external handler.
 */
public final class ExternalAccessLogPublisherCfgDefn extends ManagedObjectDefinition<ExternalAccessLogPublisherCfgClient, ExternalAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final ExternalAccessLogPublisherCfgDefn INSTANCE = new ExternalAccessLogPublisherCfgDefn();



  /** The "config-file" property definition. */
  private static final StringPropertyDefinition PD_CONFIG_FILE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "log-control-oids" property definition. */
  private static final BooleanPropertyDefinition PD_LOG_CONTROL_OIDS;



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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.ExternalAccessLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "log-control-oids" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "log-control-oids");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-control-oids"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_LOG_CONTROL_OIDS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_CONTROL_OIDS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the External Access Log Publisher configuration definition
   * singleton.
   *
   * @return Returns the External Access Log Publisher configuration
   *         definition singleton.
   */
  public static ExternalAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ExternalAccessLogPublisherCfgDefn() {
    super("external-access-log-publisher", AccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ExternalAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends ExternalAccessLogPublisherCfgClient> impl) {
    return new ExternalAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ExternalAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends ExternalAccessLogPublisherCfg> impl) {
    return new ExternalAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ExternalAccessLogPublisherCfg> getServerConfigurationClass() {
    return ExternalAccessLogPublisherCfg.class;
  }



  /**
   * Get the "config-file" property definition.
   * <p>
   * The JSON configuration file that defines the External Access Log
   * Publisher. The content of the JSON configuration file depends on
   * the type of external audit event handler. The path to the file is
   * relative to the server root.
   *
   * @return Returns the "config-file" property definition.
   */
  public StringPropertyDefinition getConfigFilePropertyDefinition() {
    return PD_CONFIG_FILE;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the External Access Log Publisher is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "filtering-policy" property definition.
   * <p>
   * Specifies how filtering criteria should be applied to log
   * records.
   *
   * @return Returns the "filtering-policy" property definition.
   */
  public EnumPropertyDefinition<FilteringPolicy> getFilteringPolicyPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getFilteringPolicyPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * External Access Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "log-control-oids" property definition.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @return Returns the "log-control-oids" property definition.
   */
  public BooleanPropertyDefinition getLogControlOidsPropertyDefinition() {
    return PD_LOG_CONTROL_OIDS;
  }



  /**
   * Get the "suppress-internal-operations" property definition.
   * <p>
   * Indicates whether internal operations (for example, operations
   * that are initiated by plugins) should be logged along with the
   * operations that are requested by users.
   *
   * @return Returns the "suppress-internal-operations" property definition.
   */
  public BooleanPropertyDefinition getSuppressInternalOperationsPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getSuppressInternalOperationsPropertyDefinition();
  }



  /**
   * Get the "suppress-synchronization-operations" property definition.
   * <p>
   * Indicates whether access messages that are generated by
   * synchronization operations should be suppressed.
   *
   * @return Returns the "suppress-synchronization-operations" property definition.
   */
  public BooleanPropertyDefinition getSuppressSynchronizationOperationsPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getSuppressSynchronizationOperationsPropertyDefinition();
  }



  /**
   * Get the "access-log-filtering-criteria" relation definition.
   *
   * @return Returns the "access-log-filtering-criteria" relation definition.
   */
  public InstantiableRelationDefinition<AccessLogFilteringCriteriaCfgClient,AccessLogFilteringCriteriaCfg> getAccessLogFilteringCriteriaRelationDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getAccessLogFilteringCriteriaRelationDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class ExternalAccessLogPublisherCfgClientImpl implements
    ExternalAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ExternalAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private ExternalAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends ExternalAccessLogPublisherCfgClient> impl) {
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
    public FilteringPolicy getFilteringPolicy() {
      return impl.getPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFilteringPolicy(FilteringPolicy value) {
      impl.setPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition(), value);
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
    public boolean isLogControlOids() {
      return impl.getPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogControlOids(Boolean value) {
      impl.setPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSuppressInternalOperations() {
      return impl.getPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSuppressInternalOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSuppressSynchronizationOperations() {
      return impl.getPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSuppressSynchronizationOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String[] listAccessLogFilteringCriteria() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition());
    }



    /** {@inheritDoc} */
    public AccessLogFilteringCriteriaCfgClient getAccessLogFilteringCriteria(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends AccessLogFilteringCriteriaCfgClient> M createAccessLogFilteringCriteria(
        ManagedObjectDefinition<M, ? extends AccessLogFilteringCriteriaCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteria(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends ExternalAccessLogPublisherCfgClient, ? extends ExternalAccessLogPublisherCfg> definition() {
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
  private static class ExternalAccessLogPublisherCfgServerImpl implements
    ExternalAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ExternalAccessLogPublisherCfg> impl;

    /** The value of the "config-file" property. */
    private final String pConfigFile;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "filtering-policy" property. */
    private final FilteringPolicy pFilteringPolicy;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "log-control-oids" property. */
    private final boolean pLogControlOids;

    /** The value of the "suppress-internal-operations" property. */
    private final boolean pSuppressInternalOperations;

    /** The value of the "suppress-synchronization-operations" property. */
    private final boolean pSuppressSynchronizationOperations;



    /** Private constructor. */
    private ExternalAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends ExternalAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pConfigFile = impl.getPropertyValue(INSTANCE.getConfigFilePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pFilteringPolicy = impl.getPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLogControlOids = impl.getPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition());
      this.pSuppressInternalOperations = impl.getPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition());
      this.pSuppressSynchronizationOperations = impl.getPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addExternalAccessChangeListener(
        ConfigurationChangeListener<ExternalAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeExternalAccessChangeListener(
        ConfigurationChangeListener<ExternalAccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addAccessChangeListener(
        ConfigurationChangeListener<AccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeAccessChangeListener(
        ConfigurationChangeListener<AccessLogPublisherCfg> listener) {
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
    public FilteringPolicy getFilteringPolicy() {
      return pFilteringPolicy;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public boolean isLogControlOids() {
      return pLogControlOids;
    }



    /** {@inheritDoc} */
    public boolean isSuppressInternalOperations() {
      return pSuppressInternalOperations;
    }



    /** {@inheritDoc} */
    public boolean isSuppressSynchronizationOperations() {
      return pSuppressSynchronizationOperations;
    }



    /** {@inheritDoc} */
    public String[] listAccessLogFilteringCriteria() {
      return impl.listChildren(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition());
    }



    /** {@inheritDoc} */
    public AccessLogFilteringCriteriaCfg getAccessLogFilteringCriteria(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addAccessLogFilteringCriteriaAddListener(
        ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteriaAddListener(
        ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addAccessLogFilteringCriteriaDeleteListener(
        ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteriaDeleteListener(
        ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends ExternalAccessLogPublisherCfg> configurationClass() {
      return ExternalAccessLogPublisherCfg.class;
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
