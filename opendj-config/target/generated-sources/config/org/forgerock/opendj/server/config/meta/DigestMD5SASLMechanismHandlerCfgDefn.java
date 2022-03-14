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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.DigestMD5SASLMechanismHandlerCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.server.DigestMD5SASLMechanismHandlerCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.SASLMechanismHandlerCfg;



/**
 * An interface for querying the Digest MD5 SASL Mechanism Handler
 * managed object definition meta information.
 * <p>
 * The DIGEST-MD5 SASL mechanism is used to perform all processing
 * related to SASL DIGEST-MD5 authentication.
 */
public final class DigestMD5SASLMechanismHandlerCfgDefn extends ManagedObjectDefinition<DigestMD5SASLMechanismHandlerCfgClient, DigestMD5SASLMechanismHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final DigestMD5SASLMechanismHandlerCfgDefn INSTANCE = new DigestMD5SASLMechanismHandlerCfgDefn();



  /**
   * Defines the set of permissable values for the "quality-of-protection" property.
   * <p>
   * The name of a property that specifies the quality of protection
   * the server will support.
   */
  public static enum QualityOfProtection {

    /**
     * Quality of protection equals authentication with integrity and
     * confidentiality protection.
     */
    CONFIDENTIALITY("confidentiality"),



    /**
     * Quality of protection equals authentication with integrity
     * protection.
     */
    INTEGRITY("integrity"),



    /**
     * QOP equals authentication only.
     */
    NONE("none");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private QualityOfProtection(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "identity-mapper" property definition. */
  private static final AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> PD_IDENTITY_MAPPER;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "quality-of-protection" property definition. */
  private static final EnumPropertyDefinition<QualityOfProtection> PD_QUALITY_OF_PROTECTION;



  /** The "realm" property definition. */
  private static final StringPropertyDefinition PD_REALM;



  /** The "server-fqdn" property definition. */
  private static final StringPropertyDefinition PD_SERVER_FQDN;



  /** Build the "identity-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<IdentityMapperCfgClient, IdentityMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "identity-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "identity-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("identity-mapper");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_IDENTITY_MAPPER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IDENTITY_MAPPER);
      INSTANCE.registerConstraint(PD_IDENTITY_MAPPER.getSourceConstraint());
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.DigestMD5SASLMechanismHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.SASLMechanismHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "quality-of-protection" property definition. */
  static {
      EnumPropertyDefinition.Builder<QualityOfProtection> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "quality-of-protection");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "quality-of-protection"));
      DefaultBehaviorProvider<QualityOfProtection> provider = new DefinedDefaultBehaviorProvider<QualityOfProtection>("none");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(QualityOfProtection.class);
      PD_QUALITY_OF_PROTECTION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_QUALITY_OF_PROTECTION);
  }



  /** Build the "realm" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "realm");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "realm"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "realm"));
      builder.setPattern(".*", "STRING");
      PD_REALM = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REALM);
  }



  /** Build the "server-fqdn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "server-fqdn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "server-fqdn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "server-fqdn"));
      builder.setPattern(".*", "STRING");
      PD_SERVER_FQDN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SERVER_FQDN);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the Digest MD5 SASL Mechanism Handler configuration
   * definition singleton.
   *
   * @return Returns the Digest MD5 SASL Mechanism Handler
   *         configuration definition singleton.
   */
  public static DigestMD5SASLMechanismHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private DigestMD5SASLMechanismHandlerCfgDefn() {
    super("digest-md5-sasl-mechanism-handler", SASLMechanismHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public DigestMD5SASLMechanismHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends DigestMD5SASLMechanismHandlerCfgClient> impl) {
    return new DigestMD5SASLMechanismHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public DigestMD5SASLMechanismHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends DigestMD5SASLMechanismHandlerCfg> impl) {
    return new DigestMD5SASLMechanismHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<DigestMD5SASLMechanismHandlerCfg> getServerConfigurationClass() {
    return DigestMD5SASLMechanismHandlerCfg.class;
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
   * Get the "identity-mapper" property definition.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the authentication or
   * authorization ID included in the SASL bind request to the
   * corresponding user in the directory.
   *
   * @return Returns the "identity-mapper" property definition.
   */
  public AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> getIdentityMapperPropertyDefinition() {
    return PD_IDENTITY_MAPPER;
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
   * Get the "quality-of-protection" property definition.
   * <p>
   * The name of a property that specifies the quality of protection
   * the server will support.
   *
   * @return Returns the "quality-of-protection" property definition.
   */
  public EnumPropertyDefinition<QualityOfProtection> getQualityOfProtectionPropertyDefinition() {
    return PD_QUALITY_OF_PROTECTION;
  }



  /**
   * Get the "realm" property definition.
   * <p>
   * Specifies the realms that is to be used by the server for
   * DIGEST-MD5 authentication.
   * <p>
   * If this value is not provided, then the server defaults to use
   * the fully qualified hostname of the machine.
   *
   * @return Returns the "realm" property definition.
   */
  public StringPropertyDefinition getRealmPropertyDefinition() {
    return PD_REALM;
  }



  /**
   * Get the "server-fqdn" property definition.
   * <p>
   * Specifies the DNS-resolvable fully-qualified domain name for the
   * server that is used when validating the digest-uri parameter
   * during the authentication process.
   * <p>
   * If this configuration attribute is present, then the server
   * expects that clients use a digest-uri equal to "ldap/" followed by
   * the value of this attribute. For example, if the attribute has a
   * value of "directory.example.com", then the server expects clients
   * to use a digest-uri of "ldap/directory.example.com". If no value
   * is provided, then the server does not attempt to validate the
   * digest-uri provided by the client and accepts any value.
   *
   * @return Returns the "server-fqdn" property definition.
   */
  public StringPropertyDefinition getServerFqdnPropertyDefinition() {
    return PD_SERVER_FQDN;
  }



  /**
   * Managed object client implementation.
   */
  private static class DigestMD5SASLMechanismHandlerCfgClientImpl implements
    DigestMD5SASLMechanismHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends DigestMD5SASLMechanismHandlerCfgClient> impl;



    /** Private constructor. */
    private DigestMD5SASLMechanismHandlerCfgClientImpl(
        ManagedObject<? extends DigestMD5SASLMechanismHandlerCfgClient> impl) {
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
    public String getIdentityMapper() {
      return impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIdentityMapper(String value) {
      impl.setPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition(), value);
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
    public QualityOfProtection getQualityOfProtection() {
      return impl.getPropertyValue(INSTANCE.getQualityOfProtectionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setQualityOfProtection(QualityOfProtection value) {
      impl.setPropertyValue(INSTANCE.getQualityOfProtectionPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getRealm() {
      return impl.getPropertyValue(INSTANCE.getRealmPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRealm(String value) {
      impl.setPropertyValue(INSTANCE.getRealmPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getServerFqdn() {
      return impl.getPropertyValue(INSTANCE.getServerFqdnPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setServerFqdn(String value) {
      impl.setPropertyValue(INSTANCE.getServerFqdnPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends DigestMD5SASLMechanismHandlerCfgClient, ? extends DigestMD5SASLMechanismHandlerCfg> definition() {
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
  private static class DigestMD5SASLMechanismHandlerCfgServerImpl implements
    DigestMD5SASLMechanismHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends DigestMD5SASLMechanismHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "identity-mapper" property. */
    private final String pIdentityMapper;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "quality-of-protection" property. */
    private final QualityOfProtection pQualityOfProtection;

    /** The value of the "realm" property. */
    private final String pRealm;

    /** The value of the "server-fqdn" property. */
    private final String pServerFqdn;



    /** Private constructor. */
    private DigestMD5SASLMechanismHandlerCfgServerImpl(ServerManagedObject<? extends DigestMD5SASLMechanismHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIdentityMapper = impl.getPropertyValue(INSTANCE.getIdentityMapperPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pQualityOfProtection = impl.getPropertyValue(INSTANCE.getQualityOfProtectionPropertyDefinition());
      this.pRealm = impl.getPropertyValue(INSTANCE.getRealmPropertyDefinition());
      this.pServerFqdn = impl.getPropertyValue(INSTANCE.getServerFqdnPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addDigestMD5ChangeListener(
        ConfigurationChangeListener<DigestMD5SASLMechanismHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeDigestMD5ChangeListener(
        ConfigurationChangeListener<DigestMD5SASLMechanismHandlerCfg> listener) {
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
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getIdentityMapper() {
      return pIdentityMapper;
    }



    /**
     * {@inheritDoc}
     */
    public DN getIdentityMapperDN() {
      String value = getIdentityMapper();
      if (value == null) return null;
      return INSTANCE.getIdentityMapperPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public QualityOfProtection getQualityOfProtection() {
      return pQualityOfProtection;
    }



    /** {@inheritDoc} */
    public String getRealm() {
      return pRealm;
    }



    /** {@inheritDoc} */
    public String getServerFqdn() {
      return pServerFqdn;
    }



    /** {@inheritDoc} */
    public Class<? extends DigestMD5SASLMechanismHandlerCfg> configurationClass() {
      return DigestMD5SASLMechanismHandlerCfg.class;
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
