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
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.CoreSchemaCfgClient;
import org.forgerock.opendj.server.config.server.CoreSchemaCfg;
import org.forgerock.opendj.server.config.server.SchemaProviderCfg;



/**
 * An interface for querying the Core Schema managed object definition
 * meta information.
 * <p>
 * Core Schema define the core schema elements to load.
 */
public final class CoreSchemaCfgDefn extends ManagedObjectDefinition<CoreSchemaCfgClient, CoreSchemaCfg> {

  /** The singleton configuration definition instance. */
  private static final CoreSchemaCfgDefn INSTANCE = new CoreSchemaCfgDefn();



  /**
   * Defines the set of permissable values for the "json-validation-policy" property.
   * <p>
   * Specifies the policy that will be used when validating JSON
   * syntax values.
   */
  public static enum JsonValidationPolicy {

    /**
     * JSON syntax values will not be validated and, as a result any
     * sequence of bytes will be acceptable.
     */
    DISABLED("disabled"),



    /**
     * JSON syntax values must comply with RFC 7159 except: 1)
     * comments are allowed, 2) single quotes may be used instead of
     * double quotes, and 3) unquoted control characters are allowed in
     * strings.
     */
    LENIENT("lenient"),



    /**
     * JSON syntax values must strictly conform to RFC 7159.
     */
    STRICT("strict");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private JsonValidationPolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "allow-attribute-types-with-no-sup-or-syntax" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_ATTRIBUTE_TYPES_WITH_NO_SUP_OR_SYNTAX;



  /** The "allow-zero-length-values-directory-string" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_ZERO_LENGTH_VALUES_DIRECTORY_STRING;



  /** The "disabled-matching-rule" property definition. */
  private static final StringPropertyDefinition PD_DISABLED_MATCHING_RULE;



  /** The "disabled-syntax" property definition. */
  private static final StringPropertyDefinition PD_DISABLED_SYNTAX;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "json-validation-policy" property definition. */
  private static final EnumPropertyDefinition<JsonValidationPolicy> PD_JSON_VALIDATION_POLICY;



  /** The "strict-format-certificates" property definition. */
  private static final BooleanPropertyDefinition PD_STRICT_FORMAT_CERTIFICATES;



  /** The "strict-format-country-string" property definition. */
  private static final BooleanPropertyDefinition PD_STRICT_FORMAT_COUNTRY_STRING;



  /** The "strict-format-jpeg-photos" property definition. */
  private static final BooleanPropertyDefinition PD_STRICT_FORMAT_JPEG_PHOTOS;



  /** The "strict-format-telephone-numbers" property definition. */
  private static final BooleanPropertyDefinition PD_STRICT_FORMAT_TELEPHONE_NUMBERS;



  /** The "strip-syntax-min-upper-bound-attribute-type-description" property definition. */
  private static final BooleanPropertyDefinition PD_STRIP_SYNTAX_MIN_UPPER_BOUND_ATTRIBUTE_TYPE_DESCRIPTION;



  /** Build the "allow-attribute-types-with-no-sup-or-syntax" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-attribute-types-with-no-sup-or-syntax");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-attribute-types-with-no-sup-or-syntax"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_ATTRIBUTE_TYPES_WITH_NO_SUP_OR_SYNTAX = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_ATTRIBUTE_TYPES_WITH_NO_SUP_OR_SYNTAX);
  }



  /** Build the "allow-zero-length-values-directory-string" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-zero-length-values-directory-string");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-zero-length-values-directory-string"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_ZERO_LENGTH_VALUES_DIRECTORY_STRING = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_ZERO_LENGTH_VALUES_DIRECTORY_STRING);
  }



  /** Build the "disabled-matching-rule" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "disabled-matching-rule");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disabled-matching-rule"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("NONE");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern("^([0-9.]+\\d|NONE)$", "OID");
      PD_DISABLED_MATCHING_RULE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISABLED_MATCHING_RULE);
  }



  /** Build the "disabled-syntax" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "disabled-syntax");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disabled-syntax"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("NONE");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern("^([0-9.]+\\d|NONE)$", "OID");
      PD_DISABLED_SYNTAX = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISABLED_SYNTAX);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.schema.CoreSchemaProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.schema.SchemaProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "json-validation-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<JsonValidationPolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "json-validation-policy");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "json-validation-policy"));
      DefaultBehaviorProvider<JsonValidationPolicy> provider = new DefinedDefaultBehaviorProvider<JsonValidationPolicy>("strict");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(JsonValidationPolicy.class);
      PD_JSON_VALIDATION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JSON_VALIDATION_POLICY);
  }



  /** Build the "strict-format-certificates" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "strict-format-certificates");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "strict-format-certificates"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_STRICT_FORMAT_CERTIFICATES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STRICT_FORMAT_CERTIFICATES);
  }



  /** Build the "strict-format-country-string" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "strict-format-country-string");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "strict-format-country-string"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_STRICT_FORMAT_COUNTRY_STRING = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STRICT_FORMAT_COUNTRY_STRING);
  }



  /** Build the "strict-format-jpeg-photos" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "strict-format-jpeg-photos");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "strict-format-jpeg-photos"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_STRICT_FORMAT_JPEG_PHOTOS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STRICT_FORMAT_JPEG_PHOTOS);
  }



  /** Build the "strict-format-telephone-numbers" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "strict-format-telephone-numbers");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "strict-format-telephone-numbers"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_STRICT_FORMAT_TELEPHONE_NUMBERS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STRICT_FORMAT_TELEPHONE_NUMBERS);
  }



  /** Build the "strip-syntax-min-upper-bound-attribute-type-description" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "strip-syntax-min-upper-bound-attribute-type-description");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "strip-syntax-min-upper-bound-attribute-type-description"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_STRIP_SYNTAX_MIN_UPPER_BOUND_ATTRIBUTE_TYPE_DESCRIPTION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_STRIP_SYNTAX_MIN_UPPER_BOUND_ATTRIBUTE_TYPE_DESCRIPTION);
  }



  /**
   * Get the Core Schema configuration definition singleton.
   *
   * @return Returns the Core Schema configuration definition
   *         singleton.
   */
  public static CoreSchemaCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private CoreSchemaCfgDefn() {
    super("core-schema", SchemaProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public CoreSchemaCfgClient createClientConfiguration(
      ManagedObject<? extends CoreSchemaCfgClient> impl) {
    return new CoreSchemaCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public CoreSchemaCfg createServerConfiguration(
      ServerManagedObject<? extends CoreSchemaCfg> impl) {
    return new CoreSchemaCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<CoreSchemaCfg> getServerConfigurationClass() {
    return CoreSchemaCfg.class;
  }



  /**
   * Get the "allow-attribute-types-with-no-sup-or-syntax" property definition.
   * <p>
   * Indicates whether the schema should allow attribute type
   * definitions that do not declare a superior attribute type or
   * syntax
   * <p>
   * When set to true, invalid attribute type definitions will use the
   * default syntax.
   *
   * @return Returns the "allow-attribute-types-with-no-sup-or-syntax" property definition.
   */
  public BooleanPropertyDefinition getAllowAttributeTypesWithNoSupOrSyntaxPropertyDefinition() {
    return PD_ALLOW_ATTRIBUTE_TYPES_WITH_NO_SUP_OR_SYNTAX;
  }



  /**
   * Get the "allow-zero-length-values-directory-string" property definition.
   * <p>
   * Indicates whether zero-length (that is, an empty string) values
   * are allowed for directory string.
   * <p>
   * This is technically not allowed by the revised LDAPv3
   * specification, but some environments may require it for backward
   * compatibility with servers that do allow it.
   *
   * @return Returns the "allow-zero-length-values-directory-string" property definition.
   */
  public BooleanPropertyDefinition getAllowZeroLengthValuesDirectoryStringPropertyDefinition() {
    return PD_ALLOW_ZERO_LENGTH_VALUES_DIRECTORY_STRING;
  }



  /**
   * Get the "disabled-matching-rule" property definition.
   * <p>
   * The set of disabled matching rules.
   * <p>
   * Matching rules must be specified using the syntax: OID, or use
   * the default value 'NONE' to specify no value.
   *
   * @return Returns the "disabled-matching-rule" property definition.
   */
  public StringPropertyDefinition getDisabledMatchingRulePropertyDefinition() {
    return PD_DISABLED_MATCHING_RULE;
  }



  /**
   * Get the "disabled-syntax" property definition.
   * <p>
   * The set of disabled syntaxes.
   * <p>
   * Syntaxes must be specified using the syntax: OID, or use the
   * default value 'NONE' to specify no value.
   *
   * @return Returns the "disabled-syntax" property definition.
   */
  public StringPropertyDefinition getDisabledSyntaxPropertyDefinition() {
    return PD_DISABLED_SYNTAX;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Core Schema is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return SchemaProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Core Schema implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "json-validation-policy" property definition.
   * <p>
   * Specifies the policy that will be used when validating JSON
   * syntax values.
   *
   * @return Returns the "json-validation-policy" property definition.
   */
  public EnumPropertyDefinition<JsonValidationPolicy> getJsonValidationPolicyPropertyDefinition() {
    return PD_JSON_VALIDATION_POLICY;
  }



  /**
   * Get the "strict-format-certificates" property definition.
   * <p>
   * Indicates whether X.509 Certificate values are required to
   * strictly comply with the standard definition for this syntax.
   * <p>
   * When set to false, certificates will not be validated and, as a
   * result any sequence of bytes will be acceptable.
   *
   * @return Returns the "strict-format-certificates" property definition.
   */
  public BooleanPropertyDefinition getStrictFormatCertificatesPropertyDefinition() {
    return PD_STRICT_FORMAT_CERTIFICATES;
  }



  /**
   * Get the "strict-format-country-string" property definition.
   * <p>
   * Indicates whether country code values are required to strictly
   * comply with the standard definition for this syntax.
   * <p>
   * When set to false, country codes will not be validated and, as a
   * result any string containing 2 characters will be acceptable.
   *
   * @return Returns the "strict-format-country-string" property definition.
   */
  public BooleanPropertyDefinition getStrictFormatCountryStringPropertyDefinition() {
    return PD_STRICT_FORMAT_COUNTRY_STRING;
  }



  /**
   * Get the "strict-format-jpeg-photos" property definition.
   * <p>
   * Indicates whether to require JPEG values to strictly comply with
   * the standard definition for this syntax.
   *
   * @return Returns the "strict-format-jpeg-photos" property definition.
   */
  public BooleanPropertyDefinition getStrictFormatJPEGPhotosPropertyDefinition() {
    return PD_STRICT_FORMAT_JPEG_PHOTOS;
  }



  /**
   * Get the "strict-format-telephone-numbers" property definition.
   * <p>
   * Indicates whether to require telephone number values to strictly
   * comply with the standard definition for this syntax.
   *
   * @return Returns the "strict-format-telephone-numbers" property definition.
   */
  public BooleanPropertyDefinition getStrictFormatTelephoneNumbersPropertyDefinition() {
    return PD_STRICT_FORMAT_TELEPHONE_NUMBERS;
  }



  /**
   * Get the "strip-syntax-min-upper-bound-attribute-type-description" property definition.
   * <p>
   * Indicates whether the suggested minimum upper bound appended to
   * an attribute's syntax OID in it's schema definition Attribute Type
   * Description is stripped off.
   * <p>
   * When retrieving the server's schema, some APIs (JNDI) fail in
   * their syntax lookup methods, because they do not parse this value
   * correctly. This configuration option allows the server to be
   * configured to provide schema definitions these APIs can parse
   * correctly.
   *
   * @return Returns the "strip-syntax-min-upper-bound-attribute-type-description" property definition.
   */
  public BooleanPropertyDefinition getStripSyntaxMinUpperBoundAttributeTypeDescriptionPropertyDefinition() {
    return PD_STRIP_SYNTAX_MIN_UPPER_BOUND_ATTRIBUTE_TYPE_DESCRIPTION;
  }



  /**
   * Managed object client implementation.
   */
  private static class CoreSchemaCfgClientImpl implements
    CoreSchemaCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends CoreSchemaCfgClient> impl;



    /** Private constructor. */
    private CoreSchemaCfgClientImpl(
        ManagedObject<? extends CoreSchemaCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAllowAttributeTypesWithNoSupOrSyntax() {
      return impl.getPropertyValue(INSTANCE.getAllowAttributeTypesWithNoSupOrSyntaxPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowAttributeTypesWithNoSupOrSyntax(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowAttributeTypesWithNoSupOrSyntaxPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAllowZeroLengthValuesDirectoryString() {
      return impl.getPropertyValue(INSTANCE.getAllowZeroLengthValuesDirectoryStringPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowZeroLengthValuesDirectoryString(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowZeroLengthValuesDirectoryStringPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledMatchingRule() {
      return impl.getPropertyValues(INSTANCE.getDisabledMatchingRulePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDisabledMatchingRule(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDisabledMatchingRulePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledSyntax() {
      return impl.getPropertyValues(INSTANCE.getDisabledSyntaxPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDisabledSyntax(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDisabledSyntaxPropertyDefinition(), values);
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
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public JsonValidationPolicy getJsonValidationPolicy() {
      return impl.getPropertyValue(INSTANCE.getJsonValidationPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJsonValidationPolicy(JsonValidationPolicy value) {
      impl.setPropertyValue(INSTANCE.getJsonValidationPolicyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatCertificates() {
      return impl.getPropertyValue(INSTANCE.getStrictFormatCertificatesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStrictFormatCertificates(Boolean value) {
      impl.setPropertyValue(INSTANCE.getStrictFormatCertificatesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatCountryString() {
      return impl.getPropertyValue(INSTANCE.getStrictFormatCountryStringPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStrictFormatCountryString(Boolean value) {
      impl.setPropertyValue(INSTANCE.getStrictFormatCountryStringPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatJPEGPhotos() {
      return impl.getPropertyValue(INSTANCE.getStrictFormatJPEGPhotosPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStrictFormatJPEGPhotos(Boolean value) {
      impl.setPropertyValue(INSTANCE.getStrictFormatJPEGPhotosPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatTelephoneNumbers() {
      return impl.getPropertyValue(INSTANCE.getStrictFormatTelephoneNumbersPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStrictFormatTelephoneNumbers(Boolean value) {
      impl.setPropertyValue(INSTANCE.getStrictFormatTelephoneNumbersPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isStripSyntaxMinUpperBoundAttributeTypeDescription() {
      return impl.getPropertyValue(INSTANCE.getStripSyntaxMinUpperBoundAttributeTypeDescriptionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setStripSyntaxMinUpperBoundAttributeTypeDescription(Boolean value) {
      impl.setPropertyValue(INSTANCE.getStripSyntaxMinUpperBoundAttributeTypeDescriptionPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends CoreSchemaCfgClient, ? extends CoreSchemaCfg> definition() {
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
  private static class CoreSchemaCfgServerImpl implements
    CoreSchemaCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends CoreSchemaCfg> impl;

    /** The value of the "allow-attribute-types-with-no-sup-or-syntax" property. */
    private final boolean pAllowAttributeTypesWithNoSupOrSyntax;

    /** The value of the "allow-zero-length-values-directory-string" property. */
    private final boolean pAllowZeroLengthValuesDirectoryString;

    /** The value of the "disabled-matching-rule" property. */
    private final SortedSet<String> pDisabledMatchingRule;

    /** The value of the "disabled-syntax" property. */
    private final SortedSet<String> pDisabledSyntax;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "json-validation-policy" property. */
    private final JsonValidationPolicy pJsonValidationPolicy;

    /** The value of the "strict-format-certificates" property. */
    private final boolean pStrictFormatCertificates;

    /** The value of the "strict-format-country-string" property. */
    private final boolean pStrictFormatCountryString;

    /** The value of the "strict-format-jpeg-photos" property. */
    private final boolean pStrictFormatJPEGPhotos;

    /** The value of the "strict-format-telephone-numbers" property. */
    private final boolean pStrictFormatTelephoneNumbers;

    /** The value of the "strip-syntax-min-upper-bound-attribute-type-description" property. */
    private final boolean pStripSyntaxMinUpperBoundAttributeTypeDescription;



    /** Private constructor. */
    private CoreSchemaCfgServerImpl(ServerManagedObject<? extends CoreSchemaCfg> impl) {
      this.impl = impl;
      this.pAllowAttributeTypesWithNoSupOrSyntax = impl.getPropertyValue(INSTANCE.getAllowAttributeTypesWithNoSupOrSyntaxPropertyDefinition());
      this.pAllowZeroLengthValuesDirectoryString = impl.getPropertyValue(INSTANCE.getAllowZeroLengthValuesDirectoryStringPropertyDefinition());
      this.pDisabledMatchingRule = impl.getPropertyValues(INSTANCE.getDisabledMatchingRulePropertyDefinition());
      this.pDisabledSyntax = impl.getPropertyValues(INSTANCE.getDisabledSyntaxPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pJsonValidationPolicy = impl.getPropertyValue(INSTANCE.getJsonValidationPolicyPropertyDefinition());
      this.pStrictFormatCertificates = impl.getPropertyValue(INSTANCE.getStrictFormatCertificatesPropertyDefinition());
      this.pStrictFormatCountryString = impl.getPropertyValue(INSTANCE.getStrictFormatCountryStringPropertyDefinition());
      this.pStrictFormatJPEGPhotos = impl.getPropertyValue(INSTANCE.getStrictFormatJPEGPhotosPropertyDefinition());
      this.pStrictFormatTelephoneNumbers = impl.getPropertyValue(INSTANCE.getStrictFormatTelephoneNumbersPropertyDefinition());
      this.pStripSyntaxMinUpperBoundAttributeTypeDescription = impl.getPropertyValue(INSTANCE.getStripSyntaxMinUpperBoundAttributeTypeDescriptionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addCoreSchemaChangeListener(
        ConfigurationChangeListener<CoreSchemaCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeCoreSchemaChangeListener(
        ConfigurationChangeListener<CoreSchemaCfg> listener) {
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
    public boolean isAllowAttributeTypesWithNoSupOrSyntax() {
      return pAllowAttributeTypesWithNoSupOrSyntax;
    }



    /** {@inheritDoc} */
    public boolean isAllowZeroLengthValuesDirectoryString() {
      return pAllowZeroLengthValuesDirectoryString;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledMatchingRule() {
      return pDisabledMatchingRule;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledSyntax() {
      return pDisabledSyntax;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public JsonValidationPolicy getJsonValidationPolicy() {
      return pJsonValidationPolicy;
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatCertificates() {
      return pStrictFormatCertificates;
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatCountryString() {
      return pStrictFormatCountryString;
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatJPEGPhotos() {
      return pStrictFormatJPEGPhotos;
    }



    /** {@inheritDoc} */
    public boolean isStrictFormatTelephoneNumbers() {
      return pStrictFormatTelephoneNumbers;
    }



    /** {@inheritDoc} */
    public boolean isStripSyntaxMinUpperBoundAttributeTypeDescription() {
      return pStripSyntaxMinUpperBoundAttributeTypeDescription;
    }



    /** {@inheritDoc} */
    public Class<? extends CoreSchemaCfg> configurationClass() {
      return CoreSchemaCfg.class;
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
