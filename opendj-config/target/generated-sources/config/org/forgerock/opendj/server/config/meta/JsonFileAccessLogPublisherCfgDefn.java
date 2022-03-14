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
import java.util.TreeSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.AccessLogFilteringCriteriaCfgClient;
import org.forgerock.opendj.server.config.client.JsonFileAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.client.LogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.meta.AccessLogPublisherCfgDefn.FilteringPolicy;
import org.forgerock.opendj.server.config.server.AccessLogFilteringCriteriaCfg;
import org.forgerock.opendj.server.config.server.AccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.JsonFileAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the Json File Access Log Publisher
 * managed object definition meta information.
 * <p>
 * Json File Access Log Publishers Publish access messages to Json
 * files.
 */
public final class JsonFileAccessLogPublisherCfgDefn extends ManagedObjectDefinition<JsonFileAccessLogPublisherCfgClient, JsonFileAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final JsonFileAccessLogPublisherCfgDefn INSTANCE = new JsonFileAccessLogPublisherCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "log-control-oids" property definition. */
  private static final BooleanPropertyDefinition PD_LOG_CONTROL_OIDS;



  /** The "log-directory" property definition. */
  private static final StringPropertyDefinition PD_LOG_DIRECTORY;



  /** The "retention-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> PD_RETENTION_POLICY;



  /** The "rotation-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRotationPolicyCfgClient, LogRotationPolicyCfg> PD_ROTATION_POLICY;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.JsonFileAccessLogPublisher");
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



  /** Build the "log-directory" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-directory");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "log-directory"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("logs");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "DIRECTORY");
      PD_LOG_DIRECTORY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_DIRECTORY);
  }



  /** Build the "retention-policy" property definition. */
  static {
      AggregationPropertyDefinition.Builder<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "retention-policy");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "retention-policy"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "retention-policy"));
      builder.setParentPath("/");
      builder.setRelationDefinition("log-retention-policy");
      PD_RETENTION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RETENTION_POLICY);
      INSTANCE.registerConstraint(PD_RETENTION_POLICY.getSourceConstraint());
  }



  /** Build the "rotation-policy" property definition. */
  static {
      AggregationPropertyDefinition.Builder<LogRotationPolicyCfgClient, LogRotationPolicyCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "rotation-policy");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "rotation-policy"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "rotation-policy"));
      builder.setParentPath("/");
      builder.setRelationDefinition("log-rotation-policy");
      PD_ROTATION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ROTATION_POLICY);
      INSTANCE.registerConstraint(PD_ROTATION_POLICY.getSourceConstraint());
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Json File Access Log Publisher configuration definition
   * singleton.
   *
   * @return Returns the Json File Access Log Publisher configuration
   *         definition singleton.
   */
  public static JsonFileAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private JsonFileAccessLogPublisherCfgDefn() {
    super("json-file-access-log-publisher", AccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public JsonFileAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends JsonFileAccessLogPublisherCfgClient> impl) {
    return new JsonFileAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public JsonFileAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends JsonFileAccessLogPublisherCfg> impl) {
    return new JsonFileAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<JsonFileAccessLogPublisherCfg> getServerConfigurationClass() {
    return JsonFileAccessLogPublisherCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Json File Access Log Publisher is enabled
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
   * The fully-qualified name of the Java class that provides the Json
   * File Access Log Publisher implementation.
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
   * Get the "log-directory" property definition.
   * <p>
   * The directory to use for the log files generated by the Json File
   * Access Log Publisher. The path to the directory is relative to the
   * server root.
   *
   * @return Returns the "log-directory" property definition.
   */
  public StringPropertyDefinition getLogDirectoryPropertyDefinition() {
    return PD_LOG_DIRECTORY;
  }



  /**
   * Get the "retention-policy" property definition.
   * <p>
   * The retention policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @return Returns the "retention-policy" property definition.
   */
  public AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> getRetentionPolicyPropertyDefinition() {
    return PD_RETENTION_POLICY;
  }



  /**
   * Get the "rotation-policy" property definition.
   * <p>
   * The rotation policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @return Returns the "rotation-policy" property definition.
   */
  public AggregationPropertyDefinition<LogRotationPolicyCfgClient, LogRotationPolicyCfg> getRotationPolicyPropertyDefinition() {
    return PD_ROTATION_POLICY;
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
  private static class JsonFileAccessLogPublisherCfgClientImpl implements
    JsonFileAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends JsonFileAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private JsonFileAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends JsonFileAccessLogPublisherCfgClient> impl) {
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
    public String getLogDirectory() {
      return impl.getPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogDirectory(String value) {
      impl.setPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRetentionPolicy() {
      return impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRetentionPolicy(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRotationPolicy() {
      return impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRotationPolicy(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends JsonFileAccessLogPublisherCfgClient, ? extends JsonFileAccessLogPublisherCfg> definition() {
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
  private static class JsonFileAccessLogPublisherCfgServerImpl implements
    JsonFileAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends JsonFileAccessLogPublisherCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "filtering-policy" property. */
    private final FilteringPolicy pFilteringPolicy;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "log-control-oids" property. */
    private final boolean pLogControlOids;

    /** The value of the "log-directory" property. */
    private final String pLogDirectory;

    /** The value of the "retention-policy" property. */
    private final SortedSet<String> pRetentionPolicy;

    /** The value of the "rotation-policy" property. */
    private final SortedSet<String> pRotationPolicy;

    /** The value of the "suppress-internal-operations" property. */
    private final boolean pSuppressInternalOperations;

    /** The value of the "suppress-synchronization-operations" property. */
    private final boolean pSuppressSynchronizationOperations;



    /** Private constructor. */
    private JsonFileAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends JsonFileAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pFilteringPolicy = impl.getPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLogControlOids = impl.getPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition());
      this.pLogDirectory = impl.getPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition());
      this.pRetentionPolicy = impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
      this.pRotationPolicy = impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
      this.pSuppressInternalOperations = impl.getPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition());
      this.pSuppressSynchronizationOperations = impl.getPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addJsonFileAccessChangeListener(
        ConfigurationChangeListener<JsonFileAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeJsonFileAccessChangeListener(
        ConfigurationChangeListener<JsonFileAccessLogPublisherCfg> listener) {
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
    public String getLogDirectory() {
      return pLogDirectory;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRetentionPolicy() {
      return pRetentionPolicy;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getRetentionPolicyDNs() {
      SortedSet<String> values = getRetentionPolicy();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getRetentionPolicyPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRotationPolicy() {
      return pRotationPolicy;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getRotationPolicyDNs() {
      SortedSet<String> values = getRotationPolicy();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getRotationPolicyPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
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
    public Class<? extends JsonFileAccessLogPublisherCfg> configurationClass() {
      return JsonFileAccessLogPublisherCfg.class;
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
