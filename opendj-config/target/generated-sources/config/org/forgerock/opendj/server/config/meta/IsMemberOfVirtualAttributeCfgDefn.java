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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.IsMemberOfVirtualAttributeCfgClient;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.Scope;
import org.forgerock.opendj.server.config.server.IsMemberOfVirtualAttributeCfg;
import org.forgerock.opendj.server.config.server.VirtualAttributeCfg;



/**
 * An interface for querying the Is Member Of Virtual Attribute
 * managed object definition meta information.
 * <p>
 * The Is Member Of Virtual Attribute generates the isMemberOf
 * operational attribute, which contains the DNs of the groups in which
 * the user is a member.
 */
public final class IsMemberOfVirtualAttributeCfgDefn extends ManagedObjectDefinition<IsMemberOfVirtualAttributeCfgClient, IsMemberOfVirtualAttributeCfg> {

  /** The singleton configuration definition instance. */
  private static final IsMemberOfVirtualAttributeCfgDefn INSTANCE = new IsMemberOfVirtualAttributeCfgDefn();



  /** The "attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE_TYPE;



  /** The "conflict-behavior" property definition. */
  private static final EnumPropertyDefinition<ConflictBehavior> PD_CONFLICT_BEHAVIOR;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute-type");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute-type"));
      DefaultBehaviorProvider<AttributeType> provider = new DefinedDefaultBehaviorProvider<AttributeType>("isMemberOf");
      builder.setDefaultBehaviorProvider(provider);
      PD_ATTRIBUTE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ATTRIBUTE_TYPE);
  }



  /** Build the "conflict-behavior" property definition. */
  static {
      EnumPropertyDefinition.Builder<ConflictBehavior> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "conflict-behavior");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "conflict-behavior"));
      DefaultBehaviorProvider<ConflictBehavior> provider = new DefinedDefaultBehaviorProvider<ConflictBehavior>("virtual-overrides-real");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(ConflictBehavior.class);
      PD_CONFLICT_BEHAVIOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFLICT_BEHAVIOR);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.IsMemberOfVirtualAttributeProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.VirtualAttributeProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Is Member Of Virtual Attribute configuration definition
   * singleton.
   *
   * @return Returns the Is Member Of Virtual Attribute configuration
   *         definition singleton.
   */
  public static IsMemberOfVirtualAttributeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private IsMemberOfVirtualAttributeCfgDefn() {
    super("is-member-of-virtual-attribute", VirtualAttributeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public IsMemberOfVirtualAttributeCfgClient createClientConfiguration(
      ManagedObject<? extends IsMemberOfVirtualAttributeCfgClient> impl) {
    return new IsMemberOfVirtualAttributeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public IsMemberOfVirtualAttributeCfg createServerConfiguration(
      ServerManagedObject<? extends IsMemberOfVirtualAttributeCfg> impl) {
    return new IsMemberOfVirtualAttributeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<IsMemberOfVirtualAttributeCfg> getServerConfigurationClass() {
    return IsMemberOfVirtualAttributeCfg.class;
  }



  /**
   * Get the "attribute-type" property definition.
   * <p>
   * Specifies the attribute type for the attribute whose values are
   * to be dynamically assigned by the virtual attribute.
   *
   * @return Returns the "attribute-type" property definition.
   */
  public AttributeTypePropertyDefinition getAttributeTypePropertyDefinition() {
    return PD_ATTRIBUTE_TYPE;
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DNs for the branches containing entries that
   * are eligible to use this virtual attribute.
   * <p>
   * If no values are given, then the server generates virtual
   * attributes anywhere in the server.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getBaseDNPropertyDefinition();
  }



  /**
   * Get the "conflict-behavior" property definition.
   * <p>
   * Specifies the behavior that the server is to exhibit for entries
   * that already contain one or more real values for the associated
   * attribute.
   *
   * @return Returns the "conflict-behavior" property definition.
   */
  public EnumPropertyDefinition<ConflictBehavior> getConflictBehaviorPropertyDefinition() {
    return PD_CONFLICT_BEHAVIOR;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Is Member Of Virtual Attribute is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "filter" property definition.
   * <p>
   * Specifies the search filters to be applied against entries to
   * determine if the virtual attribute is to be generated for those
   * entries.
   * <p>
   * If no values are given, then any entry is eligible to have the
   * value generated. If one or more filters are specified, then only
   * entries that match at least one of those filters are allowed to
   * have the virtual attribute.
   *
   * @return Returns the "filter" property definition.
   */
  public StringPropertyDefinition getFilterPropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getFilterPropertyDefinition();
  }



  /**
   * Get the "group-dn" property definition.
   * <p>
   * Specifies the DNs of the groups whose members can be eligible to
   * use this virtual attribute.
   * <p>
   * If no values are given, then group membership is not taken into
   * account when generating the virtual attribute. If one or more
   * group DNs are specified, then only members of those groups are
   * allowed to have the virtual attribute.
   *
   * @return Returns the "group-dn" property definition.
   */
  public DNPropertyDefinition getGroupDNPropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getGroupDNPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "scope" property definition.
   * <p>
   * Specifies the LDAP scope associated with base DNs for entries
   * that are eligible to use this virtual attribute.
   *
   * @return Returns the "scope" property definition.
   */
  public EnumPropertyDefinition<Scope> getScopePropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getScopePropertyDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class IsMemberOfVirtualAttributeCfgClientImpl implements
    IsMemberOfVirtualAttributeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends IsMemberOfVirtualAttributeCfgClient> impl;



    /** Private constructor. */
    private IsMemberOfVirtualAttributeCfgClientImpl(
        ManagedObject<? extends IsMemberOfVirtualAttributeCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public AttributeType getAttributeType() {
      return impl.getPropertyValue(INSTANCE.getAttributeTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAttributeType(AttributeType value) {
      impl.setPropertyValue(INSTANCE.getAttributeTypePropertyDefinition(), value);
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
    public ConflictBehavior getConflictBehavior() {
      return impl.getPropertyValue(INSTANCE.getConflictBehaviorPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConflictBehavior(ConflictBehavior value) {
      impl.setPropertyValue(INSTANCE.getConflictBehaviorPropertyDefinition(), value);
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
    public SortedSet<String> getFilter() {
      return impl.getPropertyValues(INSTANCE.getFilterPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFilter(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getFilterPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getGroupDN() {
      return impl.getPropertyValues(INSTANCE.getGroupDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setGroupDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getGroupDNPropertyDefinition(), values);
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
    public Scope getScope() {
      return impl.getPropertyValue(INSTANCE.getScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setScope(Scope value) {
      impl.setPropertyValue(INSTANCE.getScopePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends IsMemberOfVirtualAttributeCfgClient, ? extends IsMemberOfVirtualAttributeCfg> definition() {
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
  private static class IsMemberOfVirtualAttributeCfgServerImpl implements
    IsMemberOfVirtualAttributeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends IsMemberOfVirtualAttributeCfg> impl;

    /** The value of the "attribute-type" property. */
    private final AttributeType pAttributeType;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "conflict-behavior" property. */
    private final ConflictBehavior pConflictBehavior;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "filter" property. */
    private final SortedSet<String> pFilter;

    /** The value of the "group-dn" property. */
    private final SortedSet<DN> pGroupDN;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "scope" property. */
    private final Scope pScope;



    /** Private constructor. */
    private IsMemberOfVirtualAttributeCfgServerImpl(ServerManagedObject<? extends IsMemberOfVirtualAttributeCfg> impl) {
      this.impl = impl;
      this.pAttributeType = impl.getPropertyValue(INSTANCE.getAttributeTypePropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pConflictBehavior = impl.getPropertyValue(INSTANCE.getConflictBehaviorPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pFilter = impl.getPropertyValues(INSTANCE.getFilterPropertyDefinition());
      this.pGroupDN = impl.getPropertyValues(INSTANCE.getGroupDNPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pScope = impl.getPropertyValue(INSTANCE.getScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addIsMemberOfChangeListener(
        ConfigurationChangeListener<IsMemberOfVirtualAttributeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeIsMemberOfChangeListener(
        ConfigurationChangeListener<IsMemberOfVirtualAttributeCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<VirtualAttributeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<VirtualAttributeCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public AttributeType getAttributeType() {
      return pAttributeType;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return pBaseDN;
    }



    /** {@inheritDoc} */
    public ConflictBehavior getConflictBehavior() {
      return pConflictBehavior;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getFilter() {
      return pFilter;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getGroupDN() {
      return pGroupDN;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Scope getScope() {
      return pScope;
    }



    /** {@inheritDoc} */
    public Class<? extends IsMemberOfVirtualAttributeCfg> configurationClass() {
      return IsMemberOfVirtualAttributeCfg.class;
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
