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
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.PasswordPolicyImportPluginCfgClient;
import org.forgerock.opendj.server.config.client.PasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.PasswordPolicyImportPluginCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PluginCfg;



/**
 * An interface for querying the Password Policy Import Plugin managed
 * object definition meta information.
 * <p>
 * The Password Policy Import Plugin ensures that clear-text passwords
 * contained in LDIF entries are properly encoded before they are
 * stored in the appropriate directory server backend.
 */
public final class PasswordPolicyImportPluginCfgDefn extends ManagedObjectDefinition<PasswordPolicyImportPluginCfgClient, PasswordPolicyImportPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final PasswordPolicyImportPluginCfgDefn INSTANCE = new PasswordPolicyImportPluginCfgDefn();



  /** The "default-auth-password-storage-scheme" property definition. */
  private static final AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> PD_DEFAULT_AUTH_PASSWORD_STORAGE_SCHEME;



  /** The "default-user-password-storage-scheme" property definition. */
  private static final AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> PD_DEFAULT_USER_PASSWORD_STORAGE_SCHEME;



  /** The "invoke-for-internal-operations" property definition. */
  private static final BooleanPropertyDefinition PD_INVOKE_FOR_INTERNAL_OPERATIONS;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** Build the "default-auth-password-storage-scheme" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "default-auth-password-storage-scheme");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-auth-password-storage-scheme"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "default-auth-password-storage-scheme"));
      builder.setParentPath("/");
      builder.setRelationDefinition("password-storage-scheme");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_DEFAULT_AUTH_PASSWORD_STORAGE_SCHEME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_AUTH_PASSWORD_STORAGE_SCHEME);
      INSTANCE.registerConstraint(PD_DEFAULT_AUTH_PASSWORD_STORAGE_SCHEME.getSourceConstraint());
  }



  /** Build the "default-user-password-storage-scheme" property definition. */
  static {
      AggregationPropertyDefinition.Builder<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "default-user-password-storage-scheme");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-user-password-storage-scheme"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "default-user-password-storage-scheme"));
      builder.setParentPath("/");
      builder.setRelationDefinition("password-storage-scheme");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_DEFAULT_USER_PASSWORD_STORAGE_SCHEME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_USER_PASSWORD_STORAGE_SCHEME);
      INSTANCE.registerConstraint(PD_DEFAULT_USER_PASSWORD_STORAGE_SCHEME.getSourceConstraint());
  }



  /** Build the "invoke-for-internal-operations" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "invoke-for-internal-operations");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "invoke-for-internal-operations"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_INVOKE_FOR_INTERNAL_OPERATIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INVOKE_FOR_INTERNAL_OPERATIONS);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.plugins.PasswordPolicyImportPlugin");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.plugin.DirectoryServerPlugin");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "plugin-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<PluginType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "plugin-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "plugin-type"));
      DefaultBehaviorProvider<PluginType> provider = new DefinedDefaultBehaviorProvider<PluginType>("ldifimport");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(PluginType.class);
      PD_PLUGIN_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_TYPE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Password Policy Import Plugin configuration definition
   * singleton.
   *
   * @return Returns the Password Policy Import Plugin configuration
   *         definition singleton.
   */
  public static PasswordPolicyImportPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PasswordPolicyImportPluginCfgDefn() {
    super("password-policy-import-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PasswordPolicyImportPluginCfgClient createClientConfiguration(
      ManagedObject<? extends PasswordPolicyImportPluginCfgClient> impl) {
    return new PasswordPolicyImportPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PasswordPolicyImportPluginCfg createServerConfiguration(
      ServerManagedObject<? extends PasswordPolicyImportPluginCfg> impl) {
    return new PasswordPolicyImportPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PasswordPolicyImportPluginCfg> getServerConfigurationClass() {
    return PasswordPolicyImportPluginCfg.class;
  }



  /**
   * Get the "default-auth-password-storage-scheme" property definition.
   * <p>
   * Specifies the names of password storage schemes that to be used
   * for encoding passwords contained in attributes with the auth
   * password syntax for entries that do not include the
   * ds-pwp-password-policy-dn attribute specifying which password
   * policy should be used to govern them.
   *
   * @return Returns the "default-auth-password-storage-scheme" property definition.
   */
  public AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> getDefaultAuthPasswordStorageSchemePropertyDefinition() {
    return PD_DEFAULT_AUTH_PASSWORD_STORAGE_SCHEME;
  }



  /**
   * Get the "default-user-password-storage-scheme" property definition.
   * <p>
   * Specifies the names of the password storage schemes to be used
   * for encoding passwords contained in attributes with the user
   * password syntax for entries that do not include the
   * ds-pwp-password-policy-dn attribute specifying which password
   * policy is to be used to govern them.
   *
   * @return Returns the "default-user-password-storage-scheme" property definition.
   */
  public AggregationPropertyDefinition<PasswordStorageSchemeCfgClient, PasswordStorageSchemeCfg> getDefaultUserPasswordStorageSchemePropertyDefinition() {
    return PD_DEFAULT_USER_PASSWORD_STORAGE_SCHEME;
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
    return PD_INVOKE_FOR_INTERNAL_OPERATIONS;
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
   * Managed object client implementation.
   */
  private static class PasswordPolicyImportPluginCfgClientImpl implements
    PasswordPolicyImportPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PasswordPolicyImportPluginCfgClient> impl;



    /** Private constructor. */
    private PasswordPolicyImportPluginCfgClientImpl(
        ManagedObject<? extends PasswordPolicyImportPluginCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDefaultAuthPasswordStorageScheme() {
      return impl.getPropertyValues(INSTANCE.getDefaultAuthPasswordStorageSchemePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultAuthPasswordStorageScheme(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDefaultAuthPasswordStorageSchemePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDefaultUserPasswordStorageScheme() {
      return impl.getPropertyValues(INSTANCE.getDefaultUserPasswordStorageSchemePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultUserPasswordStorageScheme(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDefaultUserPasswordStorageSchemePropertyDefinition(), values);
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
    public SortedSet<PluginType> getPluginType() {
      return impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginType(Collection<PluginType> values) {
      impl.setPropertyValues(INSTANCE.getPluginTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PasswordPolicyImportPluginCfgClient, ? extends PasswordPolicyImportPluginCfg> definition() {
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
  private static class PasswordPolicyImportPluginCfgServerImpl implements
    PasswordPolicyImportPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PasswordPolicyImportPluginCfg> impl;

    /** The value of the "default-auth-password-storage-scheme" property. */
    private final SortedSet<String> pDefaultAuthPasswordStorageScheme;

    /** The value of the "default-user-password-storage-scheme" property. */
    private final SortedSet<String> pDefaultUserPasswordStorageScheme;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;



    /** Private constructor. */
    private PasswordPolicyImportPluginCfgServerImpl(ServerManagedObject<? extends PasswordPolicyImportPluginCfg> impl) {
      this.impl = impl;
      this.pDefaultAuthPasswordStorageScheme = impl.getPropertyValues(INSTANCE.getDefaultAuthPasswordStorageSchemePropertyDefinition());
      this.pDefaultUserPasswordStorageScheme = impl.getPropertyValues(INSTANCE.getDefaultUserPasswordStorageSchemePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPasswordPolicyImportChangeListener(
        ConfigurationChangeListener<PasswordPolicyImportPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePasswordPolicyImportChangeListener(
        ConfigurationChangeListener<PasswordPolicyImportPluginCfg> listener) {
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
    public SortedSet<String> getDefaultAuthPasswordStorageScheme() {
      return pDefaultAuthPasswordStorageScheme;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getDefaultAuthPasswordStorageSchemeDNs() {
      SortedSet<String> values = getDefaultAuthPasswordStorageScheme();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getDefaultAuthPasswordStorageSchemePropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDefaultUserPasswordStorageScheme() {
      return pDefaultUserPasswordStorageScheme;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getDefaultUserPasswordStorageSchemeDNs() {
      SortedSet<String> values = getDefaultUserPasswordStorageScheme();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getDefaultUserPasswordStorageSchemePropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
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
    public SortedSet<PluginType> getPluginType() {
      return pPluginType;
    }



    /** {@inheritDoc} */
    public Class<? extends PasswordPolicyImportPluginCfg> configurationClass() {
      return PasswordPolicyImportPluginCfg.class;
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
