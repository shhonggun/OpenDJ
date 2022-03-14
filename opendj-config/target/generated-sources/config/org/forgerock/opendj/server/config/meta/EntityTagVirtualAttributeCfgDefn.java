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
import org.forgerock.opendj.server.config.client.EntityTagVirtualAttributeCfgClient;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.Scope;
import org.forgerock.opendj.server.config.server.EntityTagVirtualAttributeCfg;
import org.forgerock.opendj.server.config.server.VirtualAttributeCfg;



/**
 * An interface for querying the Entity Tag Virtual Attribute managed
 * object definition meta information.
 * <p>
 * The Entity Tag Virtual Attribute ensures that all entries contain
 * an "entity tag" or "Etag" as defined in section 3.11 of RFC 2616.
 */
public final class EntityTagVirtualAttributeCfgDefn extends ManagedObjectDefinition<EntityTagVirtualAttributeCfgClient, EntityTagVirtualAttributeCfg> {

  /** The singleton configuration definition instance. */
  private static final EntityTagVirtualAttributeCfgDefn INSTANCE = new EntityTagVirtualAttributeCfgDefn();



  /**
   * Defines the set of permissable values for the "checksum-algorithm" property.
   * <p>
   * The algorithm which should be used for calculating the entity tag
   * checksum value.
   */
  public static enum ChecksumAlgorithm {

    /**
     * The Adler-32 checksum algorithm which is almost as reliable as
     * a CRC-32 but can be computed much faster.
     */
    ADLER_32("adler-32"),



    /**
     * The CRC-32 checksum algorithm.
     */
    CRC_32("crc-32");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private ChecksumAlgorithm(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE_TYPE;



  /** The "checksum-algorithm" property definition. */
  private static final EnumPropertyDefinition<ChecksumAlgorithm> PD_CHECKSUM_ALGORITHM;



  /** The "conflict-behavior" property definition. */
  private static final EnumPropertyDefinition<ConflictBehavior> PD_CONFLICT_BEHAVIOR;



  /** The "excluded-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_EXCLUDED_ATTRIBUTE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute-type");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute-type"));
      DefaultBehaviorProvider<AttributeType> provider = new DefinedDefaultBehaviorProvider<AttributeType>("etag");
      builder.setDefaultBehaviorProvider(provider);
      PD_ATTRIBUTE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ATTRIBUTE_TYPE);
  }



  /** Build the "checksum-algorithm" property definition. */
  static {
      EnumPropertyDefinition.Builder<ChecksumAlgorithm> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "checksum-algorithm");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "checksum-algorithm"));
      DefaultBehaviorProvider<ChecksumAlgorithm> provider = new DefinedDefaultBehaviorProvider<ChecksumAlgorithm>("adler-32");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(ChecksumAlgorithm.class);
      PD_CHECKSUM_ALGORITHM = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHECKSUM_ALGORITHM);
  }



  /** Build the "conflict-behavior" property definition. */
  static {
      EnumPropertyDefinition.Builder<ConflictBehavior> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "conflict-behavior");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "conflict-behavior"));
      DefaultBehaviorProvider<ConflictBehavior> provider = new DefinedDefaultBehaviorProvider<ConflictBehavior>("real-overrides-virtual");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(ConflictBehavior.class);
      PD_CONFLICT_BEHAVIOR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFLICT_BEHAVIOR);
  }



  /** Build the "excluded-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "excluded-attribute");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "excluded-attribute"));
      DefaultBehaviorProvider<AttributeType> provider = new DefinedDefaultBehaviorProvider<AttributeType>("ds-sync-hist");
      builder.setDefaultBehaviorProvider(provider);
      PD_EXCLUDED_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_EXCLUDED_ATTRIBUTE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.EntityTagVirtualAttributeProvider");
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
   * Get the Entity Tag Virtual Attribute configuration definition
   * singleton.
   *
   * @return Returns the Entity Tag Virtual Attribute configuration
   *         definition singleton.
   */
  public static EntityTagVirtualAttributeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private EntityTagVirtualAttributeCfgDefn() {
    super("entity-tag-virtual-attribute", VirtualAttributeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public EntityTagVirtualAttributeCfgClient createClientConfiguration(
      ManagedObject<? extends EntityTagVirtualAttributeCfgClient> impl) {
    return new EntityTagVirtualAttributeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public EntityTagVirtualAttributeCfg createServerConfiguration(
      ServerManagedObject<? extends EntityTagVirtualAttributeCfg> impl) {
    return new EntityTagVirtualAttributeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<EntityTagVirtualAttributeCfg> getServerConfigurationClass() {
    return EntityTagVirtualAttributeCfg.class;
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
   * Get the "checksum-algorithm" property definition.
   * <p>
   * The algorithm which should be used for calculating the entity tag
   * checksum value.
   *
   * @return Returns the "checksum-algorithm" property definition.
   */
  public EnumPropertyDefinition<ChecksumAlgorithm> getChecksumAlgorithmPropertyDefinition() {
    return PD_CHECKSUM_ALGORITHM;
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
   * Indicates whether the Entity Tag Virtual Attribute is enabled for
   * use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return VirtualAttributeCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "excluded-attribute" property definition.
   * <p>
   * The list of attributes which should be ignored when calculating
   * the entity tag checksum value.
   * <p>
   * Certain attributes like "ds-sync-hist" may vary between replicas
   * due to different purging schedules and should not be included in
   * the checksum.
   *
   * @return Returns the "excluded-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getExcludedAttributePropertyDefinition() {
    return PD_EXCLUDED_ATTRIBUTE;
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
  private static class EntityTagVirtualAttributeCfgClientImpl implements
    EntityTagVirtualAttributeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends EntityTagVirtualAttributeCfgClient> impl;



    /** Private constructor. */
    private EntityTagVirtualAttributeCfgClientImpl(
        ManagedObject<? extends EntityTagVirtualAttributeCfgClient> impl) {
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
    public ChecksumAlgorithm getChecksumAlgorithm() {
      return impl.getPropertyValue(INSTANCE.getChecksumAlgorithmPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setChecksumAlgorithm(ChecksumAlgorithm value) {
      impl.setPropertyValue(INSTANCE.getChecksumAlgorithmPropertyDefinition(), value);
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
    public SortedSet<AttributeType> getExcludedAttribute() {
      return impl.getPropertyValues(INSTANCE.getExcludedAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setExcludedAttribute(Collection<AttributeType> values) {
      impl.setPropertyValues(INSTANCE.getExcludedAttributePropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends EntityTagVirtualAttributeCfgClient, ? extends EntityTagVirtualAttributeCfg> definition() {
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
  private static class EntityTagVirtualAttributeCfgServerImpl implements
    EntityTagVirtualAttributeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends EntityTagVirtualAttributeCfg> impl;

    /** The value of the "attribute-type" property. */
    private final AttributeType pAttributeType;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "checksum-algorithm" property. */
    private final ChecksumAlgorithm pChecksumAlgorithm;

    /** The value of the "conflict-behavior" property. */
    private final ConflictBehavior pConflictBehavior;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "excluded-attribute" property. */
    private final SortedSet<AttributeType> pExcludedAttribute;

    /** The value of the "filter" property. */
    private final SortedSet<String> pFilter;

    /** The value of the "group-dn" property. */
    private final SortedSet<DN> pGroupDN;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "scope" property. */
    private final Scope pScope;



    /** Private constructor. */
    private EntityTagVirtualAttributeCfgServerImpl(ServerManagedObject<? extends EntityTagVirtualAttributeCfg> impl) {
      this.impl = impl;
      this.pAttributeType = impl.getPropertyValue(INSTANCE.getAttributeTypePropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pChecksumAlgorithm = impl.getPropertyValue(INSTANCE.getChecksumAlgorithmPropertyDefinition());
      this.pConflictBehavior = impl.getPropertyValue(INSTANCE.getConflictBehaviorPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pExcludedAttribute = impl.getPropertyValues(INSTANCE.getExcludedAttributePropertyDefinition());
      this.pFilter = impl.getPropertyValues(INSTANCE.getFilterPropertyDefinition());
      this.pGroupDN = impl.getPropertyValues(INSTANCE.getGroupDNPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pScope = impl.getPropertyValue(INSTANCE.getScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addEntityTagChangeListener(
        ConfigurationChangeListener<EntityTagVirtualAttributeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeEntityTagChangeListener(
        ConfigurationChangeListener<EntityTagVirtualAttributeCfg> listener) {
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
    public ChecksumAlgorithm getChecksumAlgorithm() {
      return pChecksumAlgorithm;
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
    public SortedSet<AttributeType> getExcludedAttribute() {
      return pExcludedAttribute;
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
    public Class<? extends EntityTagVirtualAttributeCfg> configurationClass() {
      return EntityTagVirtualAttributeCfg.class;
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
