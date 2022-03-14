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
import org.forgerock.opendj.config.DNPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.SambaPasswordPluginCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.SambaPasswordPluginCfg;



/**
 * An interface for querying the Samba Password Plugin managed object
 * definition meta information.
 * <p>
 * Samba Password Synchronization Plugin.
 */
public final class SambaPasswordPluginCfgDefn extends ManagedObjectDefinition<SambaPasswordPluginCfgClient, SambaPasswordPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final SambaPasswordPluginCfgDefn INSTANCE = new SambaPasswordPluginCfgDefn();



  /**
   * Defines the set of permissable values for the "pwd-sync-policy" property.
   * <p>
   * Specifies which Samba passwords should be kept synchronized.
   */
  public static enum PwdSyncPolicy {

    /**
     * Synchronize the LanMan password attribute "sambaLMPassword"
     */
    SYNC_LM_PASSWORD("sync-lm-password"),



    /**
     * Synchronize the NT password attribute "sambaNTPassword"
     */
    SYNC_NT_PASSWORD("sync-nt-password");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private PwdSyncPolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** The "pwd-sync-policy" property definition. */
  private static final EnumPropertyDefinition<PwdSyncPolicy> PD_PWD_SYNC_POLICY;



  /** The "samba-administrator-dn" property definition. */
  private static final DNPropertyDefinition PD_SAMBA_ADMINISTRATOR_DN;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.plugins.SambaPasswordPlugin");
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
      DefaultBehaviorProvider<PluginType> provider = new DefinedDefaultBehaviorProvider<PluginType>("preoperationmodify", "postoperationextended");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(PluginType.class);
      PD_PLUGIN_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_TYPE);
  }



  /** Build the "pwd-sync-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<PwdSyncPolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "pwd-sync-policy");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "pwd-sync-policy"));
      DefaultBehaviorProvider<PwdSyncPolicy> provider = new DefinedDefaultBehaviorProvider<PwdSyncPolicy>("sync-nt-password");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(PwdSyncPolicy.class);
      PD_PWD_SYNC_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PWD_SYNC_POLICY);
  }



  /** Build the "samba-administrator-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "samba-administrator-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "samba-administrator-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "samba-administrator-dn"));
      PD_SAMBA_ADMINISTRATOR_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SAMBA_ADMINISTRATOR_DN);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Samba Password Plugin configuration definition singleton.
   *
   * @return Returns the Samba Password Plugin configuration
   *         definition singleton.
   */
  public static SambaPasswordPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SambaPasswordPluginCfgDefn() {
    super("samba-password-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SambaPasswordPluginCfgClient createClientConfiguration(
      ManagedObject<? extends SambaPasswordPluginCfgClient> impl) {
    return new SambaPasswordPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SambaPasswordPluginCfg createServerConfiguration(
      ServerManagedObject<? extends SambaPasswordPluginCfg> impl) {
    return new SambaPasswordPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SambaPasswordPluginCfg> getServerConfigurationClass() {
    return SambaPasswordPluginCfg.class;
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
   * Get the "pwd-sync-policy" property definition.
   * <p>
   * Specifies which Samba passwords should be kept synchronized.
   *
   * @return Returns the "pwd-sync-policy" property definition.
   */
  public EnumPropertyDefinition<PwdSyncPolicy> getPwdSyncPolicyPropertyDefinition() {
    return PD_PWD_SYNC_POLICY;
  }



  /**
   * Get the "samba-administrator-dn" property definition.
   * <p>
   * Specifies the distinguished name of the user which Samba uses to
   * perform Password Modify extended operations against this directory
   * server in order to synchronize the userPassword attribute after
   * the LanMan or NT passwords have been updated.
   * <p>
   * The user must have the 'password-reset' privilege and should not
   * be a root user. This user name can be used in order to identify
   * Samba connections and avoid double re-synchronization of the same
   * password. If this property is left undefined, then no password
   * updates will be skipped.
   *
   * @return Returns the "samba-administrator-dn" property definition.
   */
  public DNPropertyDefinition getSambaAdministratorDNPropertyDefinition() {
    return PD_SAMBA_ADMINISTRATOR_DN;
  }



  /**
   * Managed object client implementation.
   */
  private static class SambaPasswordPluginCfgClientImpl implements
    SambaPasswordPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SambaPasswordPluginCfgClient> impl;



    /** Private constructor. */
    private SambaPasswordPluginCfgClientImpl(
        ManagedObject<? extends SambaPasswordPluginCfgClient> impl) {
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
    public SortedSet<PwdSyncPolicy> getPwdSyncPolicy() {
      return impl.getPropertyValues(INSTANCE.getPwdSyncPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPwdSyncPolicy(Collection<PwdSyncPolicy> values) {
      impl.setPropertyValues(INSTANCE.getPwdSyncPolicyPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public DN getSambaAdministratorDN() {
      return impl.getPropertyValue(INSTANCE.getSambaAdministratorDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSambaAdministratorDN(DN value) {
      impl.setPropertyValue(INSTANCE.getSambaAdministratorDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SambaPasswordPluginCfgClient, ? extends SambaPasswordPluginCfg> definition() {
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
  private static class SambaPasswordPluginCfgServerImpl implements
    SambaPasswordPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SambaPasswordPluginCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;

    /** The value of the "pwd-sync-policy" property. */
    private final SortedSet<PwdSyncPolicy> pPwdSyncPolicy;

    /** The value of the "samba-administrator-dn" property. */
    private final DN pSambaAdministratorDN;



    /** Private constructor. */
    private SambaPasswordPluginCfgServerImpl(ServerManagedObject<? extends SambaPasswordPluginCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
      this.pPwdSyncPolicy = impl.getPropertyValues(INSTANCE.getPwdSyncPolicyPropertyDefinition());
      this.pSambaAdministratorDN = impl.getPropertyValue(INSTANCE.getSambaAdministratorDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSambaPasswordChangeListener(
        ConfigurationChangeListener<SambaPasswordPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSambaPasswordChangeListener(
        ConfigurationChangeListener<SambaPasswordPluginCfg> listener) {
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
    public SortedSet<PwdSyncPolicy> getPwdSyncPolicy() {
      return pPwdSyncPolicy;
    }



    /** {@inheritDoc} */
    public DN getSambaAdministratorDN() {
      return pSambaAdministratorDN;
    }



    /** {@inheritDoc} */
    public Class<? extends SambaPasswordPluginCfg> configurationClass() {
      return SambaPasswordPluginCfg.class;
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
