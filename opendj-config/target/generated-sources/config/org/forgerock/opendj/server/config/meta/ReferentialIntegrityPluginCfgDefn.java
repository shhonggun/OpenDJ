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
import org.forgerock.opendj.config.AttributeTypePropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.ReferentialIntegrityPluginCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.ReferentialIntegrityPluginCfg;



/**
 * An interface for querying the Referential Integrity Plugin managed
 * object definition meta information.
 * <p>
 * The Referential Integrity Plugin maintains referential integrity
 * for DN valued attributes.
 */
public final class ReferentialIntegrityPluginCfgDefn extends ManagedObjectDefinition<ReferentialIntegrityPluginCfgClient, ReferentialIntegrityPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final ReferentialIntegrityPluginCfgDefn INSTANCE = new ReferentialIntegrityPluginCfgDefn();



  /**
   * Defines the set of permissable values for the "check-references-scope-criteria" property.
   * <p>
   * Specifies whether referenced entries must reside within the same
   * naming context as the entry containing the reference.
   * <p>
   * The reference scope will only be enforced when reference checking
   * is enabled.
   */
  public static enum CheckReferencesScopeCriteria {

    /**
     * References may refer to existing entries located anywhere in
     * the Directory.
     */
    GLOBAL("global"),



    /**
     * References must refer to existing entries located within the
     * same naming context.
     */
    NAMING_CONTEXT("naming-context");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private CheckReferencesScopeCriteria(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE_TYPE;



  /** The "base-dn" property definition. */
  private static final DNPropertyDefinition PD_BASE_DN;



  /** The "check-references" property definition. */
  private static final BooleanPropertyDefinition PD_CHECK_REFERENCES;



  /** The "check-references-filter-criteria" property definition. */
  private static final StringPropertyDefinition PD_CHECK_REFERENCES_FILTER_CRITERIA;



  /** The "check-references-scope-criteria" property definition. */
  private static final EnumPropertyDefinition<CheckReferencesScopeCriteria> PD_CHECK_REFERENCES_SCOPE_CRITERIA;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "log-file" property definition. */
  private static final StringPropertyDefinition PD_LOG_FILE;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** The "update-interval" property definition. */
  private static final DurationPropertyDefinition PD_UPDATE_INTERVAL;



  /** Build the "attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute-type"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_ATTRIBUTE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ATTRIBUTE_TYPE);
  }



  /** Build the "base-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "base-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "base-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "base-dn"));
      PD_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BASE_DN);
  }



  /** Build the "check-references" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "check-references");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "check-references"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_CHECK_REFERENCES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHECK_REFERENCES);
  }



  /** Build the "check-references-filter-criteria" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "check-references-filter-criteria");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "check-references-filter-criteria"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^[^:]+:\\(.+\\)$", "ATTRIBUTE:FILTER");
      PD_CHECK_REFERENCES_FILTER_CRITERIA = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHECK_REFERENCES_FILTER_CRITERIA);
  }



  /** Build the "check-references-scope-criteria" property definition. */
  static {
      EnumPropertyDefinition.Builder<CheckReferencesScopeCriteria> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "check-references-scope-criteria");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "check-references-scope-criteria"));
      DefaultBehaviorProvider<CheckReferencesScopeCriteria> provider = new DefinedDefaultBehaviorProvider<CheckReferencesScopeCriteria>("global");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(CheckReferencesScopeCriteria.class);
      PD_CHECK_REFERENCES_SCOPE_CRITERIA = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHECK_REFERENCES_SCOPE_CRITERIA);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.plugins.ReferentialIntegrityPlugin");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.plugin.DirectoryServerPlugin");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "log-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-file"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("logs/referint");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "FILE");
      PD_LOG_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_FILE);
  }



  /** Build the "plugin-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<PluginType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "plugin-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "plugin-type"));
      DefaultBehaviorProvider<PluginType> provider = new DefinedDefaultBehaviorProvider<PluginType>("postoperationdelete", "postoperationmodifydn", "subordinatemodifydn", "subordinatedelete", "preoperationadd", "preoperationmodify");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(PluginType.class);
      PD_PLUGIN_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_TYPE);
  }



  /** Build the "update-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "update-interval");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "update-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setAllowUnlimited(false);
      builder.setBaseUnit("s");
      PD_UPDATE_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_UPDATE_INTERVAL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Referential Integrity Plugin configuration definition
   * singleton.
   *
   * @return Returns the Referential Integrity Plugin configuration
   *         definition singleton.
   */
  public static ReferentialIntegrityPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ReferentialIntegrityPluginCfgDefn() {
    super("referential-integrity-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ReferentialIntegrityPluginCfgClient createClientConfiguration(
      ManagedObject<? extends ReferentialIntegrityPluginCfgClient> impl) {
    return new ReferentialIntegrityPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ReferentialIntegrityPluginCfg createServerConfiguration(
      ServerManagedObject<? extends ReferentialIntegrityPluginCfg> impl) {
    return new ReferentialIntegrityPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ReferentialIntegrityPluginCfg> getServerConfigurationClass() {
    return ReferentialIntegrityPluginCfg.class;
  }



  /**
   * Get the "attribute-type" property definition.
   * <p>
   * Specifies the attribute types for which referential integrity is
   * to be maintained.
   * <p>
   * At least one attribute type must be specified, and the syntax of
   * any attributes must be either a distinguished name
   * (1.3.6.1.4.1.1466.115.121.1.12) or name and optional UID
   * (1.3.6.1.4.1.1466.115.121.1.34).
   *
   * @return Returns the "attribute-type" property definition.
   */
  public AttributeTypePropertyDefinition getAttributeTypePropertyDefinition() {
    return PD_ATTRIBUTE_TYPE;
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DN that limits the scope within which
   * referential integrity is maintained.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return PD_BASE_DN;
  }



  /**
   * Get the "check-references" property definition.
   * <p>
   * Specifies whether reference attributes must refer to existing
   * entries.
   * <p>
   * When this property is set to true, this plugin will ensure that
   * any new references added as part of an add or modify operation
   * point to existing entries, and that the referenced entries match
   * the filter criteria for the referencing attribute, if specified.
   *
   * @return Returns the "check-references" property definition.
   */
  public BooleanPropertyDefinition getCheckReferencesPropertyDefinition() {
    return PD_CHECK_REFERENCES;
  }



  /**
   * Get the "check-references-filter-criteria" property definition.
   * <p>
   * Specifies additional filter criteria which will be enforced when
   * checking references.
   * <p>
   * If a reference attribute has filter criteria defined then this
   * plugin will ensure that any new references added as part of an add
   * or modify operation refer to an existing entry which matches the
   * specified filter.
   *
   * @return Returns the "check-references-filter-criteria" property definition.
   */
  public StringPropertyDefinition getCheckReferencesFilterCriteriaPropertyDefinition() {
    return PD_CHECK_REFERENCES_FILTER_CRITERIA;
  }



  /**
   * Get the "check-references-scope-criteria" property definition.
   * <p>
   * Specifies whether referenced entries must reside within the same
   * naming context as the entry containing the reference.
   * <p>
   * The reference scope will only be enforced when reference checking
   * is enabled.
   *
   * @return Returns the "check-references-scope-criteria" property definition.
   */
  public EnumPropertyDefinition<CheckReferencesScopeCriteria> getCheckReferencesScopeCriteriaPropertyDefinition() {
    return PD_CHECK_REFERENCES_SCOPE_CRITERIA;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the plug-in is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PluginCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "invoke-for-internal-operations" property definition.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @return Returns the "invoke-for-internal-operations" property definition.
   */
  public BooleanPropertyDefinition getInvokeForInternalOperationsPropertyDefinition() {
    return PluginCfgDefn.getInstance().getInvokeForInternalOperationsPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "log-file" property definition.
   * <p>
   * Specifies the log file location where the update records are
   * written when the plug-in is in background-mode processing.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "referint".
   *
   * @return Returns the "log-file" property definition.
   */
  public StringPropertyDefinition getLogFilePropertyDefinition() {
    return PD_LOG_FILE;
  }



  /**
   * Get the "plugin-type" property definition.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the "plugin-type" property definition.
   */
  public EnumPropertyDefinition<PluginType> getPluginTypePropertyDefinition() {
    return PD_PLUGIN_TYPE;
  }



  /**
   * Get the "update-interval" property definition.
   * <p>
   * Specifies the interval in seconds when referential integrity
   * updates are made.
   * <p>
   * If this value is 0, then the updates are made synchronously in
   * the foreground.
   *
   * @return Returns the "update-interval" property definition.
   */
  public DurationPropertyDefinition getUpdateIntervalPropertyDefinition() {
    return PD_UPDATE_INTERVAL;
  }



  /**
   * Managed object client implementation.
   */
  private static class ReferentialIntegrityPluginCfgClientImpl implements
    ReferentialIntegrityPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ReferentialIntegrityPluginCfgClient> impl;



    /** Private constructor. */
    private ReferentialIntegrityPluginCfgClientImpl(
        ManagedObject<? extends ReferentialIntegrityPluginCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getAttributeType() {
      return impl.getPropertyValues(INSTANCE.getAttributeTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAttributeType(Collection<AttributeType> values) {
      impl.setPropertyValues(INSTANCE.getAttributeTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBaseDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getBaseDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isCheckReferences() {
      return impl.getPropertyValue(INSTANCE.getCheckReferencesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCheckReferences(Boolean value) {
      impl.setPropertyValue(INSTANCE.getCheckReferencesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCheckReferencesFilterCriteria() {
      return impl.getPropertyValues(INSTANCE.getCheckReferencesFilterCriteriaPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCheckReferencesFilterCriteria(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getCheckReferencesFilterCriteriaPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public CheckReferencesScopeCriteria getCheckReferencesScopeCriteria() {
      return impl.getPropertyValue(INSTANCE.getCheckReferencesScopeCriteriaPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCheckReferencesScopeCriteria(CheckReferencesScopeCriteria value) {
      impl.setPropertyValue(INSTANCE.getCheckReferencesScopeCriteriaPropertyDefinition(), value);
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
    public boolean isInvokeForInternalOperations() {
      return impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setInvokeForInternalOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition(), value);
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
    public String getLogFile() {
      return impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogFile(String value) {
      impl.setPropertyValue(INSTANCE.getLogFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<PluginType> getPluginType() {
      return impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginType(Collection<PluginType> values) {
      impl.setPropertyValues(INSTANCE.getPluginTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public long getUpdateInterval() {
      return impl.getPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUpdateInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends ReferentialIntegrityPluginCfgClient, ? extends ReferentialIntegrityPluginCfg> definition() {
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
  private static class ReferentialIntegrityPluginCfgServerImpl implements
    ReferentialIntegrityPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ReferentialIntegrityPluginCfg> impl;

    /** The value of the "attribute-type" property. */
    private final SortedSet<AttributeType> pAttributeType;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "check-references" property. */
    private final boolean pCheckReferences;

    /** The value of the "check-references-filter-criteria" property. */
    private final SortedSet<String> pCheckReferencesFilterCriteria;

    /** The value of the "check-references-scope-criteria" property. */
    private final CheckReferencesScopeCriteria pCheckReferencesScopeCriteria;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "log-file" property. */
    private final String pLogFile;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;

    /** The value of the "update-interval" property. */
    private final long pUpdateInterval;



    /** Private constructor. */
    private ReferentialIntegrityPluginCfgServerImpl(ServerManagedObject<? extends ReferentialIntegrityPluginCfg> impl) {
      this.impl = impl;
      this.pAttributeType = impl.getPropertyValues(INSTANCE.getAttributeTypePropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pCheckReferences = impl.getPropertyValue(INSTANCE.getCheckReferencesPropertyDefinition());
      this.pCheckReferencesFilterCriteria = impl.getPropertyValues(INSTANCE.getCheckReferencesFilterCriteriaPropertyDefinition());
      this.pCheckReferencesScopeCriteria = impl.getPropertyValue(INSTANCE.getCheckReferencesScopeCriteriaPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLogFile = impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
      this.pUpdateInterval = impl.getPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addReferentialIntegrityChangeListener(
        ConfigurationChangeListener<ReferentialIntegrityPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeReferentialIntegrityChangeListener(
        ConfigurationChangeListener<ReferentialIntegrityPluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getAttributeType() {
      return pAttributeType;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return pBaseDN;
    }



    /** {@inheritDoc} */
    public boolean isCheckReferences() {
      return pCheckReferences;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCheckReferencesFilterCriteria() {
      return pCheckReferencesFilterCriteria;
    }



    /** {@inheritDoc} */
    public CheckReferencesScopeCriteria getCheckReferencesScopeCriteria() {
      return pCheckReferencesScopeCriteria;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isInvokeForInternalOperations() {
      return pInvokeForInternalOperations;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getLogFile() {
      return pLogFile;
    }



    /** {@inheritDoc} */
    public SortedSet<PluginType> getPluginType() {
      return pPluginType;
    }



    /** {@inheritDoc} */
    public long getUpdateInterval() {
      return pUpdateInterval;
    }



    /** {@inheritDoc} */
    public Class<? extends ReferentialIntegrityPluginCfg> configurationClass() {
      return ReferentialIntegrityPluginCfg.class;
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
