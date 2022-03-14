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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.JsonSchemaCfgClient;
import org.forgerock.opendj.server.config.server.JsonSchemaCfg;
import org.forgerock.opendj.server.config.server.SchemaProviderCfg;



/**
 * An interface for querying the Json Schema managed object definition
 * meta information.
 * <p>
 * The JSON Schema Provider provides the ability to configure
 * customized JSON query matching rules.
 */
public final class JsonSchemaCfgDefn extends ManagedObjectDefinition<JsonSchemaCfgClient, JsonSchemaCfg> {

  /** The singleton configuration definition instance. */
  private static final JsonSchemaCfgDefn INSTANCE = new JsonSchemaCfgDefn();



  /** The "case-sensitive-strings" property definition. */
  private static final BooleanPropertyDefinition PD_CASE_SENSITIVE_STRINGS;



  /** The "ignore-white-space" property definition. */
  private static final BooleanPropertyDefinition PD_IGNORE_WHITE_SPACE;



  /** The "indexed-field" property definition. */
  private static final StringPropertyDefinition PD_INDEXED_FIELD;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "matching-rule-name" property definition. */
  private static final StringPropertyDefinition PD_MATCHING_RULE_NAME;



  /** The "matching-rule-oid" property definition. */
  private static final StringPropertyDefinition PD_MATCHING_RULE_OID;



  /** Build the "case-sensitive-strings" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "case-sensitive-strings");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "case-sensitive-strings"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_CASE_SENSITIVE_STRINGS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CASE_SENSITIVE_STRINGS);
  }



  /** Build the "ignore-white-space" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "ignore-white-space");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ignore-white-space"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_IGNORE_WHITE_SPACE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IGNORE_WHITE_SPACE);
  }



  /** Build the "indexed-field" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "indexed-field");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "indexed-field"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "indexed-field"));
      builder.setPattern(".*", "PATTERN");
      PD_INDEXED_FIELD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEXED_FIELD);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.schema.JsonSchemaProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.schema.SchemaProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "matching-rule-name" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "matching-rule-name");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "matching-rule-name"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "matching-rule-name"));
      PD_MATCHING_RULE_NAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MATCHING_RULE_NAME);
  }



  /** Build the "matching-rule-oid" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "matching-rule-oid");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "matching-rule-oid"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^([0-9.]+\\d)$", "OID");
      PD_MATCHING_RULE_OID = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MATCHING_RULE_OID);
  }



  /**
   * Get the Json Schema configuration definition singleton.
   *
   * @return Returns the Json Schema configuration definition
   *         singleton.
   */
  public static JsonSchemaCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private JsonSchemaCfgDefn() {
    super("json-schema", SchemaProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public JsonSchemaCfgClient createClientConfiguration(
      ManagedObject<? extends JsonSchemaCfgClient> impl) {
    return new JsonSchemaCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public JsonSchemaCfg createServerConfiguration(
      ServerManagedObject<? extends JsonSchemaCfg> impl) {
    return new JsonSchemaCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<JsonSchemaCfg> getServerConfigurationClass() {
    return JsonSchemaCfg.class;
  }



  /**
   * Get the "case-sensitive-strings" property definition.
   * <p>
   * Indicates whether JSON string comparisons should be
   * case-sensitive.
   *
   * @return Returns the "case-sensitive-strings" property definition.
   */
  public BooleanPropertyDefinition getCaseSensitiveStringsPropertyDefinition() {
    return PD_CASE_SENSITIVE_STRINGS;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Json Schema is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return SchemaProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "ignore-white-space" property definition.
   * <p>
   * Indicates whether JSON string comparisons should ignore
   * white-space.
   * <p>
   * When enabled all leading and trailing white space will be removed
   * and intermediate white space will be reduced to a single
   * character.
   *
   * @return Returns the "ignore-white-space" property definition.
   */
  public BooleanPropertyDefinition getIgnoreWhiteSpacePropertyDefinition() {
    return PD_IGNORE_WHITE_SPACE;
  }



  /**
   * Get the "indexed-field" property definition.
   * <p>
   * Specifies which JSON fields should be indexed.
   * <p>
   * A field will be indexed if it matches any of the configured field
   * patterns.
   *
   * @return Returns the "indexed-field" property definition.
   */
  public StringPropertyDefinition getIndexedFieldPropertyDefinition() {
    return PD_INDEXED_FIELD;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Json Schema implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "matching-rule-name" property definition.
   * <p>
   * The name of the custom JSON matching rule.
   *
   * @return Returns the "matching-rule-name" property definition.
   */
  public StringPropertyDefinition getMatchingRuleNamePropertyDefinition() {
    return PD_MATCHING_RULE_NAME;
  }



  /**
   * Get the "matching-rule-oid" property definition.
   * <p>
   * The numeric OID of the custom JSON matching rule.
   *
   * @return Returns the "matching-rule-oid" property definition.
   */
  public StringPropertyDefinition getMatchingRuleOidPropertyDefinition() {
    return PD_MATCHING_RULE_OID;
  }



  /**
   * Managed object client implementation.
   */
  private static class JsonSchemaCfgClientImpl implements
    JsonSchemaCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends JsonSchemaCfgClient> impl;



    /** Private constructor. */
    private JsonSchemaCfgClientImpl(
        ManagedObject<? extends JsonSchemaCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isCaseSensitiveStrings() {
      return impl.getPropertyValue(INSTANCE.getCaseSensitiveStringsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCaseSensitiveStrings(Boolean value) {
      impl.setPropertyValue(INSTANCE.getCaseSensitiveStringsPropertyDefinition(), value);
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
    public boolean isIgnoreWhiteSpace() {
      return impl.getPropertyValue(INSTANCE.getIgnoreWhiteSpacePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIgnoreWhiteSpace(Boolean value) {
      impl.setPropertyValue(INSTANCE.getIgnoreWhiteSpacePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIndexedField() {
      return impl.getPropertyValues(INSTANCE.getIndexedFieldPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexedField(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getIndexedFieldPropertyDefinition(), values);
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
    public String getMatchingRuleName() {
      return impl.getPropertyValue(INSTANCE.getMatchingRuleNamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMatchingRuleName(String value) {
      impl.setPropertyValue(INSTANCE.getMatchingRuleNamePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMatchingRuleOid() {
      return impl.getPropertyValue(INSTANCE.getMatchingRuleOidPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMatchingRuleOid(String value) {
      impl.setPropertyValue(INSTANCE.getMatchingRuleOidPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends JsonSchemaCfgClient, ? extends JsonSchemaCfg> definition() {
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
  private static class JsonSchemaCfgServerImpl implements
    JsonSchemaCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends JsonSchemaCfg> impl;

    /** The value of the "case-sensitive-strings" property. */
    private final boolean pCaseSensitiveStrings;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "ignore-white-space" property. */
    private final boolean pIgnoreWhiteSpace;

    /** The value of the "indexed-field" property. */
    private final SortedSet<String> pIndexedField;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "matching-rule-name" property. */
    private final String pMatchingRuleName;

    /** The value of the "matching-rule-oid" property. */
    private final String pMatchingRuleOid;



    /** Private constructor. */
    private JsonSchemaCfgServerImpl(ServerManagedObject<? extends JsonSchemaCfg> impl) {
      this.impl = impl;
      this.pCaseSensitiveStrings = impl.getPropertyValue(INSTANCE.getCaseSensitiveStringsPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIgnoreWhiteSpace = impl.getPropertyValue(INSTANCE.getIgnoreWhiteSpacePropertyDefinition());
      this.pIndexedField = impl.getPropertyValues(INSTANCE.getIndexedFieldPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMatchingRuleName = impl.getPropertyValue(INSTANCE.getMatchingRuleNamePropertyDefinition());
      this.pMatchingRuleOid = impl.getPropertyValue(INSTANCE.getMatchingRuleOidPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addJsonSchemaChangeListener(
        ConfigurationChangeListener<JsonSchemaCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeJsonSchemaChangeListener(
        ConfigurationChangeListener<JsonSchemaCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<SchemaProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<SchemaProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isCaseSensitiveStrings() {
      return pCaseSensitiveStrings;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isIgnoreWhiteSpace() {
      return pIgnoreWhiteSpace;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIndexedField() {
      return pIndexedField;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getMatchingRuleName() {
      return pMatchingRuleName;
    }



    /** {@inheritDoc} */
    public String getMatchingRuleOid() {
      return pMatchingRuleOid;
    }



    /** {@inheritDoc} */
    public Class<? extends JsonSchemaCfg> configurationClass() {
      return JsonSchemaCfg.class;
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
