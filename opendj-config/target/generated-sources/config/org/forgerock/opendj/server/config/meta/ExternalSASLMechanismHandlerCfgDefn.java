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



import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AttributeTypePropertyDefinition;
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
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.CertificateMapperCfgClient;
import org.forgerock.opendj.server.config.client.ExternalSASLMechanismHandlerCfgClient;
import org.forgerock.opendj.server.config.server.CertificateMapperCfg;
import org.forgerock.opendj.server.config.server.ExternalSASLMechanismHandlerCfg;
import org.forgerock.opendj.server.config.server.SASLMechanismHandlerCfg;



/**
 * An interface for querying the External SASL Mechanism Handler
 * managed object definition meta information.
 * <p>
 * The External SASL Mechanism Handler performs all processing related
 * to SASL EXTERNAL authentication.
 */
public final class ExternalSASLMechanismHandlerCfgDefn extends ManagedObjectDefinition<ExternalSASLMechanismHandlerCfgClient, ExternalSASLMechanismHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final ExternalSASLMechanismHandlerCfgDefn INSTANCE = new ExternalSASLMechanismHandlerCfgDefn();



  /**
   * Defines the set of permissable values for the "certificate-validation-policy" property.
   * <p>
   * Indicates whether to attempt to validate the peer certificate
   * against a certificate held in the user's entry.
   */
  public static enum CertificateValidationPolicy {

    /**
     * Always require the peer certificate to be present in the user's
     * entry.
     */
    ALWAYS("always"),



    /**
     * If the user's entry contains one or more certificates, require
     * that one of them match the peer certificate.
     */
    IFPRESENT("ifpresent"),



    /**
     * Do not look for the peer certificate to be present in the
     * user's entry.
     */
    NEVER("never");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private CertificateValidationPolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "certificate-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_CERTIFICATE_ATTRIBUTE;



  /** The "certificate-mapper" property definition. */
  private static final AggregationPropertyDefinition<CertificateMapperCfgClient, CertificateMapperCfg> PD_CERTIFICATE_MAPPER;



  /** The "certificate-validation-policy" property definition. */
  private static final EnumPropertyDefinition<CertificateValidationPolicy> PD_CERTIFICATE_VALIDATION_POLICY;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "certificate-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "certificate-attribute");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "certificate-attribute"));
      DefaultBehaviorProvider<AttributeType> provider = new DefinedDefaultBehaviorProvider<AttributeType>("userCertificate");
      builder.setDefaultBehaviorProvider(provider);
      PD_CERTIFICATE_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CERTIFICATE_ATTRIBUTE);
  }



  /** Build the "certificate-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<CertificateMapperCfgClient, CertificateMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "certificate-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "certificate-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("certificate-mapper");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_CERTIFICATE_MAPPER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CERTIFICATE_MAPPER);
      INSTANCE.registerConstraint(PD_CERTIFICATE_MAPPER.getSourceConstraint());
  }



  /** Build the "certificate-validation-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<CertificateValidationPolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "certificate-validation-policy");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "certificate-validation-policy"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<CertificateValidationPolicy>());
      builder.setEnumClass(CertificateValidationPolicy.class);
      PD_CERTIFICATE_VALIDATION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CERTIFICATE_VALIDATION_POLICY);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.ExternalSASLMechanismHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.SASLMechanismHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the External SASL Mechanism Handler configuration definition
   * singleton.
   *
   * @return Returns the External SASL Mechanism Handler configuration
   *         definition singleton.
   */
  public static ExternalSASLMechanismHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ExternalSASLMechanismHandlerCfgDefn() {
    super("external-sasl-mechanism-handler", SASLMechanismHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ExternalSASLMechanismHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends ExternalSASLMechanismHandlerCfgClient> impl) {
    return new ExternalSASLMechanismHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ExternalSASLMechanismHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends ExternalSASLMechanismHandlerCfg> impl) {
    return new ExternalSASLMechanismHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ExternalSASLMechanismHandlerCfg> getServerConfigurationClass() {
    return ExternalSASLMechanismHandlerCfg.class;
  }



  /**
   * Get the "certificate-attribute" property definition.
   * <p>
   * Specifies the name of the attribute to hold user certificates.
   * <p>
   * This property must specify the name of a valid attribute type
   * defined in the server schema.
   *
   * @return Returns the "certificate-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getCertificateAttributePropertyDefinition() {
    return PD_CERTIFICATE_ATTRIBUTE;
  }



  /**
   * Get the "certificate-mapper" property definition.
   * <p>
   * Specifies the name of the certificate mapper that should be used
   * to match client certificates to user entries.
   *
   * @return Returns the "certificate-mapper" property definition.
   */
  public AggregationPropertyDefinition<CertificateMapperCfgClient, CertificateMapperCfg> getCertificateMapperPropertyDefinition() {
    return PD_CERTIFICATE_MAPPER;
  }



  /**
   * Get the "certificate-validation-policy" property definition.
   * <p>
   * Indicates whether to attempt to validate the peer certificate
   * against a certificate held in the user's entry.
   *
   * @return Returns the "certificate-validation-policy" property definition.
   */
  public EnumPropertyDefinition<CertificateValidationPolicy> getCertificateValidationPolicyPropertyDefinition() {
    return PD_CERTIFICATE_VALIDATION_POLICY;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SASL mechanism handler is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return SASLMechanismHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SASL mechanism handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class ExternalSASLMechanismHandlerCfgClientImpl implements
    ExternalSASLMechanismHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ExternalSASLMechanismHandlerCfgClient> impl;



    /** Private constructor. */
    private ExternalSASLMechanismHandlerCfgClientImpl(
        ManagedObject<? extends ExternalSASLMechanismHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public AttributeType getCertificateAttribute() {
      return impl.getPropertyValue(INSTANCE.getCertificateAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCertificateAttribute(AttributeType value) {
      impl.setPropertyValue(INSTANCE.getCertificateAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getCertificateMapper() {
      return impl.getPropertyValue(INSTANCE.getCertificateMapperPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCertificateMapper(String value) {
      impl.setPropertyValue(INSTANCE.getCertificateMapperPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public CertificateValidationPolicy getCertificateValidationPolicy() {
      return impl.getPropertyValue(INSTANCE.getCertificateValidationPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCertificateValidationPolicy(CertificateValidationPolicy value) {
      impl.setPropertyValue(INSTANCE.getCertificateValidationPolicyPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends ExternalSASLMechanismHandlerCfgClient, ? extends ExternalSASLMechanismHandlerCfg> definition() {
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
  private static class ExternalSASLMechanismHandlerCfgServerImpl implements
    ExternalSASLMechanismHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ExternalSASLMechanismHandlerCfg> impl;

    /** The value of the "certificate-attribute" property. */
    private final AttributeType pCertificateAttribute;

    /** The value of the "certificate-mapper" property. */
    private final String pCertificateMapper;

    /** The value of the "certificate-validation-policy" property. */
    private final CertificateValidationPolicy pCertificateValidationPolicy;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private ExternalSASLMechanismHandlerCfgServerImpl(ServerManagedObject<? extends ExternalSASLMechanismHandlerCfg> impl) {
      this.impl = impl;
      this.pCertificateAttribute = impl.getPropertyValue(INSTANCE.getCertificateAttributePropertyDefinition());
      this.pCertificateMapper = impl.getPropertyValue(INSTANCE.getCertificateMapperPropertyDefinition());
      this.pCertificateValidationPolicy = impl.getPropertyValue(INSTANCE.getCertificateValidationPolicyPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addExternalChangeListener(
        ConfigurationChangeListener<ExternalSASLMechanismHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeExternalChangeListener(
        ConfigurationChangeListener<ExternalSASLMechanismHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<SASLMechanismHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<SASLMechanismHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public AttributeType getCertificateAttribute() {
      return pCertificateAttribute;
    }



    /** {@inheritDoc} */
    public String getCertificateMapper() {
      return pCertificateMapper;
    }



    /**
     * {@inheritDoc}
     */
    public DN getCertificateMapperDN() {
      String value = getCertificateMapper();
      if (value == null) return null;
      return INSTANCE.getCertificateMapperPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public CertificateValidationPolicy getCertificateValidationPolicy() {
      return pCertificateValidationPolicy;
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
    public Class<? extends ExternalSASLMechanismHandlerCfg> configurationClass() {
      return ExternalSASLMechanismHandlerCfg.class;
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
