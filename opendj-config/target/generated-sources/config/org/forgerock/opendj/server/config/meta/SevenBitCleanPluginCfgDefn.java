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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.SevenBitCleanPluginCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.SevenBitCleanPluginCfg;



/**
 * An interface for querying the Seven Bit Clean Plugin managed object
 * definition meta information.
 * <p>
 * The Seven Bit Clean Plugin ensures that values for a specified set
 * of attributes are 7-bit clean.
 */
public final class SevenBitCleanPluginCfgDefn extends ManagedObjectDefinition<SevenBitCleanPluginCfgClient, SevenBitCleanPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final SevenBitCleanPluginCfgDefn INSTANCE = new SevenBitCleanPluginCfgDefn();



  /** The "attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE_TYPE;



  /** The "base-dn" property definition. */
  private static final DNPropertyDefinition PD_BASE_DN;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** Build the "attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute-type"));
      DefaultBehaviorProvider<AttributeType> provider = new DefinedDefaultBehaviorProvider<AttributeType>("uid", "mail", "userPassword");
      builder.setDefaultBehaviorProvider(provider);
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



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.plugins.SevenBitCleanPlugin");
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
      DefaultBehaviorProvider<PluginType> provider = new DefinedDefaultBehaviorProvider<PluginType>("ldifimport", "preparseadd", "preparsemodify", "preparsemodifydn");
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
   * Get the Seven Bit Clean Plugin configuration definition
   * singleton.
   *
   * @return Returns the Seven Bit Clean Plugin configuration
   *         definition singleton.
   */
  public static SevenBitCleanPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SevenBitCleanPluginCfgDefn() {
    super("seven-bit-clean-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SevenBitCleanPluginCfgClient createClientConfiguration(
      ManagedObject<? extends SevenBitCleanPluginCfgClient> impl) {
    return new SevenBitCleanPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SevenBitCleanPluginCfg createServerConfiguration(
      ServerManagedObject<? extends SevenBitCleanPluginCfg> impl) {
    return new SevenBitCleanPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SevenBitCleanPluginCfg> getServerConfigurationClass() {
    return SevenBitCleanPluginCfg.class;
  }



  /**
   * Get the "attribute-type" property definition.
   * <p>
   * Specifies the name or OID of an attribute type for which values
   * should be checked to ensure that they are 7-bit clean.
   *
   * @return Returns the "attribute-type" property definition.
   */
  public AttributeTypePropertyDefinition getAttributeTypePropertyDefinition() {
    return PD_ATTRIBUTE_TYPE;
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DN below which the checking is performed.
   * <p>
   * Any attempt to update a value for one of the configured
   * attributes below this base DN must be 7-bit clean for the
   * operation to be allowed.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return PD_BASE_DN;
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
   * Managed object client implementation.
   */
  private static class SevenBitCleanPluginCfgClientImpl implements
    SevenBitCleanPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SevenBitCleanPluginCfgClient> impl;



    /** Private constructor. */
    private SevenBitCleanPluginCfgClientImpl(
        ManagedObject<? extends SevenBitCleanPluginCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends SevenBitCleanPluginCfgClient, ? extends SevenBitCleanPluginCfg> definition() {
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
  private static class SevenBitCleanPluginCfgServerImpl implements
    SevenBitCleanPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SevenBitCleanPluginCfg> impl;

    /** The value of the "attribute-type" property. */
    private final SortedSet<AttributeType> pAttributeType;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;



    /** Private constructor. */
    private SevenBitCleanPluginCfgServerImpl(ServerManagedObject<? extends SevenBitCleanPluginCfg> impl) {
      this.impl = impl;
      this.pAttributeType = impl.getPropertyValues(INSTANCE.getAttributeTypePropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSevenBitCleanChangeListener(
        ConfigurationChangeListener<SevenBitCleanPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSevenBitCleanChangeListener(
        ConfigurationChangeListener<SevenBitCleanPluginCfg> listener) {
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
    public Class<? extends SevenBitCleanPluginCfg> configurationClass() {
      return SevenBitCleanPluginCfg.class;
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
