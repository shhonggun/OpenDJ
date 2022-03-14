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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.RelativeInheritedDefaultBehaviorProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.BackendIndexCfgClient;
import org.forgerock.opendj.server.config.server.BackendIndexCfg;



/**
 * An interface for querying the Backend Index managed object
 * definition meta information.
 * <p>
 * Backend Indexes are used to store information that makes it
 * possible to locate entries very quickly when processing search
 * operations.
 */
public final class BackendIndexCfgDefn extends ManagedObjectDefinition<BackendIndexCfgClient, BackendIndexCfg> {

  /** The singleton configuration definition instance. */
  private static final BackendIndexCfgDefn INSTANCE = new BackendIndexCfgDefn();



  /**
   * Defines the set of permissable values for the "index-type" property.
   * <p>
   * Specifies the type(s) of indexing that should be performed for
   * the associated attribute.
   * <p>
   * For equality, presence, and substring index types, the associated
   * attribute type must have a corresponding matching rule.
   */
  public static enum IndexType {

    /**
     * This index type is used to improve the efficiency of searches
     * using approximate matching search filters.
     */
    APPROXIMATE("approximate"),



    /**
     * This index type is used to improve the efficiency of searches
     * using equality search filters.
     */
    EQUALITY("equality"),



    /**
     * This index type is used to improve the efficiency of searches
     * using extensible matching search filters.
     */
    EXTENSIBLE("extensible"),



    /**
     * This index type is used to improve the efficiency of searches
     * using "greater than or equal to" or "less then or equal to"
     * search filters.
     */
    ORDERING("ordering"),



    /**
     * This index type is used to improve the efficiency of searches
     * using the presence search filters.
     */
    PRESENCE("presence"),



    /**
     * This index type is used to improve the efficiency of searches
     * using substring search filters.
     */
    SUBSTRING("substring");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private IndexType(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE;



  /** The "confidentiality-enabled" property definition. */
  private static final BooleanPropertyDefinition PD_CONFIDENTIALITY_ENABLED;



  /** The "index-entry-limit" property definition. */
  private static final IntegerPropertyDefinition PD_INDEX_ENTRY_LIMIT;



  /** The "index-extensible-matching-rule" property definition. */
  private static final StringPropertyDefinition PD_INDEX_EXTENSIBLE_MATCHING_RULE;



  /** The "index-type" property definition. */
  private static final EnumPropertyDefinition<IndexType> PD_INDEX_TYPE;



  /** The "substring-length" property definition. */
  private static final IntegerPropertyDefinition PD_SUBSTRING_LENGTH;



  /** Build the "attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute");
      builder.setOption(PropertyOption.READ_ONLY);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ATTRIBUTE);
  }



  /** Build the "confidentiality-enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "confidentiality-enabled");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "confidentiality-enabled"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_CONFIDENTIALITY_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFIDENTIALITY_ENABLED);
  }



  /** Build the "index-entry-limit" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "index-entry-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "index-entry-limit"));
      DefaultBehaviorProvider<Integer> provider = new RelativeInheritedDefaultBehaviorProvider<Integer>(PluggableBackendCfgDefn.getInstance(), "index-entry-limit", 1);
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_INDEX_ENTRY_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_ENTRY_LIMIT);
  }



  /** Build the "index-extensible-matching-rule" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "index-extensible-matching-rule");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "index-extensible-matching-rule"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "index-extensible-matching-rule"));
      builder.setPattern("([a-z][a-z](-[A-Z][A-Z]){0,2}(.(([a-z]{2,3})|\\d))?)|(^\\d.((\\d)+.)+\\d$)", "LOCALE | OID");
      PD_INDEX_EXTENSIBLE_MATCHING_RULE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_EXTENSIBLE_MATCHING_RULE);
  }



  /** Build the "index-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<IndexType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "index-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "index-type"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<IndexType>());
      builder.setEnumClass(IndexType.class);
      PD_INDEX_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_TYPE);
  }



  /** Build the "substring-length" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "substring-length");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "substring-length"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("6");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(3);
      PD_SUBSTRING_LENGTH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SUBSTRING_LENGTH);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Backend Index configuration definition singleton.
   *
   * @return Returns the Backend Index configuration definition
   *         singleton.
   */
  public static BackendIndexCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private BackendIndexCfgDefn() {
    super("backend-index", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public BackendIndexCfgClient createClientConfiguration(
      ManagedObject<? extends BackendIndexCfgClient> impl) {
    return new BackendIndexCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public BackendIndexCfg createServerConfiguration(
      ServerManagedObject<? extends BackendIndexCfg> impl) {
    return new BackendIndexCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<BackendIndexCfg> getServerConfigurationClass() {
    return BackendIndexCfg.class;
  }



  /**
   * Get the "attribute" property definition.
   * <p>
   * Specifies the name of the attribute for which the index is to be
   * maintained.
   *
   * @return Returns the "attribute" property definition.
   */
  public AttributeTypePropertyDefinition getAttributePropertyDefinition() {
    return PD_ATTRIBUTE;
  }



  /**
   * Get the "confidentiality-enabled" property definition.
   * <p>
   * Specifies whether contents of the index should be confidential.
   * <p>
   * Setting the flag to true will hash keys for equality type indexes
   * using SHA-1 and encrypt the list of entries matching a substring
   * key for substring indexes.
   *
   * @return Returns the "confidentiality-enabled" property definition.
   */
  public BooleanPropertyDefinition getConfidentialityEnabledPropertyDefinition() {
    return PD_CONFIDENTIALITY_ENABLED;
  }



  /**
   * Get the "index-entry-limit" property definition.
   * <p>
   * Specifies the maximum number of entries that are allowed to match
   * a given index key before that particular index key is no longer
   * maintained.
   * <p>
   * This is analogous to the ALL IDs threshold in the Sun Java System
   * Directory Server. If this is specified, its value overrides the JE
   * backend-wide configuration. For no limit, use 0 for the value.
   *
   * @return Returns the "index-entry-limit" property definition.
   */
  public IntegerPropertyDefinition getIndexEntryLimitPropertyDefinition() {
    return PD_INDEX_ENTRY_LIMIT;
  }



  /**
   * Get the "index-extensible-matching-rule" property definition.
   * <p>
   * The extensible matching rule in an extensible index.
   * <p>
   * An extensible matching rule must be specified using either LOCALE
   * or OID of the matching rule.
   *
   * @return Returns the "index-extensible-matching-rule" property definition.
   */
  public StringPropertyDefinition getIndexExtensibleMatchingRulePropertyDefinition() {
    return PD_INDEX_EXTENSIBLE_MATCHING_RULE;
  }



  /**
   * Get the "index-type" property definition.
   * <p>
   * Specifies the type(s) of indexing that should be performed for
   * the associated attribute.
   * <p>
   * For equality, presence, and substring index types, the associated
   * attribute type must have a corresponding matching rule.
   *
   * @return Returns the "index-type" property definition.
   */
  public EnumPropertyDefinition<IndexType> getIndexTypePropertyDefinition() {
    return PD_INDEX_TYPE;
  }



  /**
   * Get the "substring-length" property definition.
   * <p>
   * The length of substrings in a substring index.
   *
   * @return Returns the "substring-length" property definition.
   */
  public IntegerPropertyDefinition getSubstringLengthPropertyDefinition() {
    return PD_SUBSTRING_LENGTH;
  }



  /**
   * Managed object client implementation.
   */
  private static class BackendIndexCfgClientImpl implements
    BackendIndexCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends BackendIndexCfgClient> impl;



    /** Private constructor. */
    private BackendIndexCfgClientImpl(
        ManagedObject<? extends BackendIndexCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public AttributeType getAttribute() {
      return impl.getPropertyValue(INSTANCE.getAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAttribute(AttributeType value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isConfidentialityEnabled() {
      return impl.getPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConfidentialityEnabled(Boolean value) {
      impl.setPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getIndexEntryLimit() {
      return impl.getPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexEntryLimit(Integer value) {
      impl.setPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIndexExtensibleMatchingRule() {
      return impl.getPropertyValues(INSTANCE.getIndexExtensibleMatchingRulePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexExtensibleMatchingRule(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getIndexExtensibleMatchingRulePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<IndexType> getIndexType() {
      return impl.getPropertyValues(INSTANCE.getIndexTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexType(Collection<IndexType> values) {
      impl.setPropertyValues(INSTANCE.getIndexTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public int getSubstringLength() {
      return impl.getPropertyValue(INSTANCE.getSubstringLengthPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSubstringLength(Integer value) {
      impl.setPropertyValue(INSTANCE.getSubstringLengthPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends BackendIndexCfgClient, ? extends BackendIndexCfg> definition() {
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
  private static class BackendIndexCfgServerImpl implements
    BackendIndexCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends BackendIndexCfg> impl;

    /** The value of the "attribute" property. */
    private final AttributeType pAttribute;

    /** The value of the "confidentiality-enabled" property. */
    private final boolean pConfidentialityEnabled;

    /** The value of the "index-entry-limit" property. */
    private final Integer pIndexEntryLimit;

    /** The value of the "index-extensible-matching-rule" property. */
    private final SortedSet<String> pIndexExtensibleMatchingRule;

    /** The value of the "index-type" property. */
    private final SortedSet<IndexType> pIndexType;

    /** The value of the "substring-length" property. */
    private final int pSubstringLength;



    /** Private constructor. */
    private BackendIndexCfgServerImpl(ServerManagedObject<? extends BackendIndexCfg> impl) {
      this.impl = impl;
      this.pAttribute = impl.getPropertyValue(INSTANCE.getAttributePropertyDefinition());
      this.pConfidentialityEnabled = impl.getPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition());
      this.pIndexEntryLimit = impl.getPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition());
      this.pIndexExtensibleMatchingRule = impl.getPropertyValues(INSTANCE.getIndexExtensibleMatchingRulePropertyDefinition());
      this.pIndexType = impl.getPropertyValues(INSTANCE.getIndexTypePropertyDefinition());
      this.pSubstringLength = impl.getPropertyValue(INSTANCE.getSubstringLengthPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<BackendIndexCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<BackendIndexCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public AttributeType getAttribute() {
      return pAttribute;
    }



    /** {@inheritDoc} */
    public boolean isConfidentialityEnabled() {
      return pConfidentialityEnabled;
    }



    /** {@inheritDoc} */
    public Integer getIndexEntryLimit() {
      return pIndexEntryLimit;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIndexExtensibleMatchingRule() {
      return pIndexExtensibleMatchingRule;
    }



    /** {@inheritDoc} */
    public SortedSet<IndexType> getIndexType() {
      return pIndexType;
    }



    /** {@inheritDoc} */
    public int getSubstringLength() {
      return pSubstringLength;
    }



    /** {@inheritDoc} */
    public Class<? extends BackendIndexCfg> configurationClass() {
      return BackendIndexCfg.class;
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
