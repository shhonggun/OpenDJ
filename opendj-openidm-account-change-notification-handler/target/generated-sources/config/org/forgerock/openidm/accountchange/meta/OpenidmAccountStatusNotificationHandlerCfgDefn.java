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
package org.forgerock.openidm.accountchange.meta;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
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
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.meta.AccountStatusNotificationHandlerCfgDefn;
import org.forgerock.opendj.server.config.server.AccountStatusNotificationHandlerCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;
import org.forgerock.openidm.accountchange.client.OpenidmAccountStatusNotificationHandlerCfgClient;
import org.forgerock.openidm.accountchange.server.OpenidmAccountStatusNotificationHandlerCfg;



/**
 * An interface for querying the Openidm Account Status Notification
 * Handler managed object definition meta information.
 * <p>
 * The Openidm Account Status Notification Handler is an account
 * status notification handler that listens to two kind of changes:
 * password change and password reset. The changes are either
 * immediately sent to OpenIDM or first stored locally and sent later
 * to OpenIDM at the provided interval. The communication with OpenIDM
 * is done through HTTP or HTTPS, with optional SSL client
 * authentication.
 */
public final class OpenidmAccountStatusNotificationHandlerCfgDefn extends ManagedObjectDefinition<OpenidmAccountStatusNotificationHandlerCfgClient, OpenidmAccountStatusNotificationHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final OpenidmAccountStatusNotificationHandlerCfgDefn INSTANCE = new OpenidmAccountStatusNotificationHandlerCfgDefn();



  /**
   * Defines the set of permissable values for the "openidm-compat-mode" property.
   * <p>
   * Specifies OpenIDM Compatibility Mode.
   */
  public static enum OpenidmCompatMode {

    /**
     * Use version 2 OpenIDM Compatibility Mode.
     */
    V2("V2"),



    /**
     * Use version 3 OpenIDM Compatibility Mode.
     */
    V3("V3");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private OpenidmCompatMode(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_ATTRIBUTE_TYPE;



  /** The "certificate-subject-dn" property definition. */
  private static final DNPropertyDefinition PD_CERTIFICATE_SUBJECT_DN;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "log-file" property definition. */
  private static final StringPropertyDefinition PD_LOG_FILE;



  /** The "openidm-compat-mode" property definition. */
  private static final EnumPropertyDefinition<OpenidmCompatMode> PD_OPENIDM_COMPAT_MODE;



  /** The "openidm-password" property definition. */
  private static final StringPropertyDefinition PD_OPENIDM_PASSWORD;



  /** The "openidm-url" property definition. */
  private static final StringPropertyDefinition PD_OPENIDM_URL;



  /** The "openidm-username" property definition. */
  private static final StringPropertyDefinition PD_OPENIDM_USERNAME;



  /** The "password-attribute" property definition. */
  private static final StringPropertyDefinition PD_PASSWORD_ATTRIBUTE;



  /** The "private-key-alias" property definition. */
  private static final StringPropertyDefinition PD_PRIVATE_KEY_ALIAS;



  /** The "query-id" property definition. */
  private static final StringPropertyDefinition PD_QUERY_ID;



  /** The "ssl-cert-nickname" property definition. */
  private static final StringPropertyDefinition PD_SSL_CERT_NICKNAME;



  /** The "trust-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> PD_TRUST_MANAGER_PROVIDER;



  /** The "update-interval" property definition. */
  private static final DurationPropertyDefinition PD_UPDATE_INTERVAL;



  /** Build the "attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "attribute-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "attribute-type"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<AttributeType>(INSTANCE, "attribute-type"));
      PD_ATTRIBUTE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ATTRIBUTE_TYPE);
  }



  /** Build the "certificate-subject-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "certificate-subject-dn");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "certificate-subject-dn"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_CERTIFICATE_SUBJECT_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CERTIFICATE_SUBJECT_DN);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.forgerock.openidm.accountchange.OpenidmAccountStatusNotificationHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AccountStatusNotificationHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<KeyManagerProviderCfgClient, KeyManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "key-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-manager-provider"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("key-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_KEY_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_KEY_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "log-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-file"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("logs/pwsync");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "FILE");
      PD_LOG_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_FILE);
  }



  /** Build the "openidm-compat-mode" property definition. */
  static {
      EnumPropertyDefinition.Builder<OpenidmCompatMode> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "openidm-compat-mode");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "openidm-compat-mode"));
      DefaultBehaviorProvider<OpenidmCompatMode> provider = new DefinedDefaultBehaviorProvider<OpenidmCompatMode>("V3");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(OpenidmCompatMode.class);
      PD_OPENIDM_COMPAT_MODE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OPENIDM_COMPAT_MODE);
  }



  /** Build the "openidm-password" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "openidm-password");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "openidm-password"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_OPENIDM_PASSWORD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OPENIDM_PASSWORD);
  }



  /** Build the "openidm-url" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "openidm-url");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "openidm-url"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "URL");
      PD_OPENIDM_URL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OPENIDM_URL);
  }



  /** Build the "openidm-username" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "openidm-username");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "openidm-username"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_OPENIDM_USERNAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OPENIDM_USERNAME);
  }



  /** Build the "password-attribute" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "password-attribute");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-attribute"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("password");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "STRING");
      PD_PASSWORD_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_ATTRIBUTE);
  }



  /** Build the "private-key-alias" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "private-key-alias");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "private-key-alias"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("openidm-localhost");
      builder.setDefaultBehaviorProvider(provider);
      PD_PRIVATE_KEY_ALIAS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PRIVATE_KEY_ALIAS);
  }



  /** Build the "query-id" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "query-id");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "query-id"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("for-userName");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "STRING");
      PD_QUERY_ID = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_QUERY_ID);
  }



  /** Build the "ssl-cert-nickname" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cert-nickname");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-cert-nickname"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_SSL_CERT_NICKNAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CERT_NICKNAME);
  }



  /** Build the "trust-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<TrustManagerProviderCfgClient, TrustManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "trust-manager-provider");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-manager-provider"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("trust-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_TRUST_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_TRUST_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "update-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "update-interval");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "update-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setAllowUnlimited(false);
      builder.setBaseUnit("s");
      PD_UPDATE_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_UPDATE_INTERVAL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Openidm Account Status Notification Handler configuration
   * definition singleton.
   *
   * @return Returns the Openidm Account Status Notification Handler
   *         configuration definition singleton.
   */
  public static OpenidmAccountStatusNotificationHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private OpenidmAccountStatusNotificationHandlerCfgDefn() {
    super("openidm-account-status-notification-handler", AccountStatusNotificationHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public OpenidmAccountStatusNotificationHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfgClient> impl) {
    return new OpenidmAccountStatusNotificationHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public OpenidmAccountStatusNotificationHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfg> impl) {
    return new OpenidmAccountStatusNotificationHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<OpenidmAccountStatusNotificationHandlerCfg> getServerConfigurationClass() {
    return OpenidmAccountStatusNotificationHandlerCfg.class;
  }



  /**
   * Get the "attribute-type" property definition.
   * <p>
   * Specifies the attribute types that this plug-in will send along
   * with the password change.
   * <p>
   * Zero or more attribute types can be specified.
   *
   * @return Returns the "attribute-type" property definition.
   */
  public AttributeTypePropertyDefinition getAttributeTypePropertyDefinition() {
    return PD_ATTRIBUTE_TYPE;
  }



  /**
   * Get the "certificate-subject-dn" property definition.
   * <p>
   * Specifies the subject DN of the certificate used by OpenIDM.
   * <p>
   * The subject DN is used to retrieve the OpenIDM certificate in the
   * truststore. This certificate's public key is necessary to encrypt
   * the JSON content sent to OpenIDM.
   *
   * @return Returns the "certificate-subject-dn" property definition.
   */
  public DNPropertyDefinition getCertificateSubjectDNPropertyDefinition() {
    return PD_CERTIFICATE_SUBJECT_DN;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Openidm Account Status Notification Handler
   * is enabled. Only enabled handlers are invoked whenever a related
   * event occurs in the server.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AccountStatusNotificationHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Openidm Account Status Notification Handler
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "key-manager-provider" property definition.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this Openidm Account Status Notification Handler.
   * <p>
   * It must be provided when ssl-cert-nickname is provided, and must
   * contain a certificate corresponding to the nickname.
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return PD_KEY_MANAGER_PROVIDER;
  }



  /**
   * Get the "log-file" property definition.
   * <p>
   * Specifies the log file location where the changed passwords are
   * written when the plug-in cannot contact OpenIDM.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "pwsync". Passwords in this file
   * will be encrypted.
   *
   * @return Returns the "log-file" property definition.
   */
  public StringPropertyDefinition getLogFilePropertyDefinition() {
    return PD_LOG_FILE;
  }



  /**
   * Get the "openidm-compat-mode" property definition.
   * <p>
   * Specifies OpenIDM Compatibility Mode.
   *
   * @return Returns the "openidm-compat-mode" property definition.
   */
  public EnumPropertyDefinition<OpenidmCompatMode> getOpenidmCompatModePropertyDefinition() {
    return PD_OPENIDM_COMPAT_MODE;
  }



  /**
   * Get the "openidm-password" property definition.
   * <p>
   * Specifies the password to use for HTTP Basic Authentication.
   * <p>
   * The password must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @return Returns the "openidm-password" property definition.
   */
  public StringPropertyDefinition getOpenidmPasswordPropertyDefinition() {
    return PD_OPENIDM_PASSWORD;
  }



  /**
   * Get the "openidm-url" property definition.
   * <p>
   * Specifies the URL to OpenIDM endpoint.
   * <p>
   * The URL can be either HTTP or HTTPS.
   *
   * @return Returns the "openidm-url" property definition.
   */
  public StringPropertyDefinition getOpenidmUrlPropertyDefinition() {
    return PD_OPENIDM_URL;
  }



  /**
   * Get the "openidm-username" property definition.
   * <p>
   * Specifies the username to use for HTTP Basic Authentication.
   * <p>
   * The username must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @return Returns the "openidm-username" property definition.
   */
  public StringPropertyDefinition getOpenidmUsernamePropertyDefinition() {
    return PD_OPENIDM_USERNAME;
  }



  /**
   * Get the "password-attribute" property definition.
   * <p>
   * Specifies the attribute type used to hold user passwords in JSON
   * returned to OpenIDM.
   * <p>
   * This attribute type must be defined in the managed object schema
   * in OpenIDM, and it must have either the user password or auth
   * password syntax.
   *
   * @return Returns the "password-attribute" property definition.
   */
  public StringPropertyDefinition getPasswordAttributePropertyDefinition() {
    return PD_PASSWORD_ATTRIBUTE;
  }



  /**
   * Get the "private-key-alias" property definition.
   * <p>
   * Specifies the alias of the private key that should be used by
   * OpenIDM to decrypt the encrypted JSON content of the requests.
   * <p>
   * The encryption of the JSON content sent to OpenIDM requires this
   * alias.
   *
   * @return Returns the "private-key-alias" property definition.
   */
  public StringPropertyDefinition getPrivateKeyAliasPropertyDefinition() {
    return PD_PRIVATE_KEY_ALIAS;
  }



  /**
   * Get the "query-id" property definition.
   * <p>
   * Specifies the query-id for the patch-by-query request.
   * <p>
   * This must match the query ID defined in the managed object
   * service in OpenIDM.
   *
   * @return Returns the "query-id" property definition.
   */
  public StringPropertyDefinition getQueryIdPropertyDefinition() {
    return PD_QUERY_ID;
  }



  /**
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the SSL certificate nickname, which is the alias under
   * which is stored the client certificate in the keystore. It must be
   * provided to activate SSL client authentication when requesting
   * OpenIDM.
   * <p>
   * The SSL certificate nickname is necessary to ensure that the
   * appropriate client certificate is retrieved from the keystore when
   * SSL client authentication is required and multiples certificates
   * are present in the keystore.
   *
   * @return Returns the "ssl-cert-nickname" property definition.
   */
  public StringPropertyDefinition getSSLCertNicknamePropertyDefinition() {
    return PD_SSL_CERT_NICKNAME;
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Openidm Account Status Notification Handler.
   * <p>
   * It must contain the OpenIDM certificate with the subject DN
   * equals to the certificate-subject-dn property.
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return PD_TRUST_MANAGER_PROVIDER;
  }



  /**
   * Get the "update-interval" property definition.
   * <p>
   * Specifies the interval when passwords update notifications are
   * sent.
   * <p>
   * If this value is 0, then updates are sent synchronously. If this
   * value is strictly superior to zero, then updates are first stored
   * locally, then sent asynchronously by a background thread.
   *
   * @return Returns the "update-interval" property definition.
   */
  public DurationPropertyDefinition getUpdateIntervalPropertyDefinition() {
    return PD_UPDATE_INTERVAL;
  }



  /**
   * Managed object client implementation.
   */
  private static class OpenidmAccountStatusNotificationHandlerCfgClientImpl implements
    OpenidmAccountStatusNotificationHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfgClient> impl;



    /** Private constructor. */
    private OpenidmAccountStatusNotificationHandlerCfgClientImpl(
        ManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfgClient> impl) {
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
    public DN getCertificateSubjectDN() {
      return impl.getPropertyValue(INSTANCE.getCertificateSubjectDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCertificateSubjectDN(DN value) {
      impl.setPropertyValue(INSTANCE.getCertificateSubjectDNPropertyDefinition(), value);
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
    public String getKeyManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLogFile() {
      return impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogFile(String value) {
      impl.setPropertyValue(INSTANCE.getLogFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public OpenidmCompatMode getOpenidmCompatMode() {
      return impl.getPropertyValue(INSTANCE.getOpenidmCompatModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOpenidmCompatMode(OpenidmCompatMode value) {
      impl.setPropertyValue(INSTANCE.getOpenidmCompatModePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getOpenidmPassword() {
      return impl.getPropertyValue(INSTANCE.getOpenidmPasswordPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOpenidmPassword(String value) {
      impl.setPropertyValue(INSTANCE.getOpenidmPasswordPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getOpenidmUrl() {
      return impl.getPropertyValue(INSTANCE.getOpenidmUrlPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOpenidmUrl(String value) {
      impl.setPropertyValue(INSTANCE.getOpenidmUrlPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getOpenidmUsername() {
      return impl.getPropertyValue(INSTANCE.getOpenidmUsernamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOpenidmUsername(String value) {
      impl.setPropertyValue(INSTANCE.getOpenidmUsernamePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPasswordAttribute() {
      return impl.getPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordAttribute(String value) {
      impl.setPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPrivateKeyAlias() {
      return impl.getPropertyValue(INSTANCE.getPrivateKeyAliasPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPrivateKeyAlias(String value) {
      impl.setPropertyValue(INSTANCE.getPrivateKeyAliasPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getQueryId() {
      return impl.getPropertyValue(INSTANCE.getQueryIdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setQueryId(String value) {
      impl.setPropertyValue(INSTANCE.getQueryIdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getSSLCertNickname() {
      return impl.getPropertyValue(INSTANCE.getSSLCertNicknamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLCertNickname(String value) {
      impl.setPropertyValue(INSTANCE.getSSLCertNicknamePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getUpdateInterval() {
      return impl.getPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUpdateInterval(long value) {
      impl.setPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends OpenidmAccountStatusNotificationHandlerCfgClient, ? extends OpenidmAccountStatusNotificationHandlerCfg> definition() {
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
  private static class OpenidmAccountStatusNotificationHandlerCfgServerImpl implements
    OpenidmAccountStatusNotificationHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfg> impl;

    /** The value of the "attribute-type" property. */
    private final SortedSet<AttributeType> pAttributeType;

    /** The value of the "certificate-subject-dn" property. */
    private final DN pCertificateSubjectDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "log-file" property. */
    private final String pLogFile;

    /** The value of the "openidm-compat-mode" property. */
    private final OpenidmCompatMode pOpenidmCompatMode;

    /** The value of the "openidm-password" property. */
    private final String pOpenidmPassword;

    /** The value of the "openidm-url" property. */
    private final String pOpenidmUrl;

    /** The value of the "openidm-username" property. */
    private final String pOpenidmUsername;

    /** The value of the "password-attribute" property. */
    private final String pPasswordAttribute;

    /** The value of the "private-key-alias" property. */
    private final String pPrivateKeyAlias;

    /** The value of the "query-id" property. */
    private final String pQueryId;

    /** The value of the "ssl-cert-nickname" property. */
    private final String pSSLCertNickname;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;

    /** The value of the "update-interval" property. */
    private final long pUpdateInterval;



    /** Private constructor. */
    private OpenidmAccountStatusNotificationHandlerCfgServerImpl(ServerManagedObject<? extends OpenidmAccountStatusNotificationHandlerCfg> impl) {
      this.impl = impl;
      this.pAttributeType = impl.getPropertyValues(INSTANCE.getAttributeTypePropertyDefinition());
      this.pCertificateSubjectDN = impl.getPropertyValue(INSTANCE.getCertificateSubjectDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pLogFile = impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
      this.pOpenidmCompatMode = impl.getPropertyValue(INSTANCE.getOpenidmCompatModePropertyDefinition());
      this.pOpenidmPassword = impl.getPropertyValue(INSTANCE.getOpenidmPasswordPropertyDefinition());
      this.pOpenidmUrl = impl.getPropertyValue(INSTANCE.getOpenidmUrlPropertyDefinition());
      this.pOpenidmUsername = impl.getPropertyValue(INSTANCE.getOpenidmUsernamePropertyDefinition());
      this.pPasswordAttribute = impl.getPropertyValue(INSTANCE.getPasswordAttributePropertyDefinition());
      this.pPrivateKeyAlias = impl.getPropertyValue(INSTANCE.getPrivateKeyAliasPropertyDefinition());
      this.pQueryId = impl.getPropertyValue(INSTANCE.getQueryIdPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValue(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
      this.pUpdateInterval = impl.getPropertyValue(INSTANCE.getUpdateIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addOpenidmChangeListener(
        ConfigurationChangeListener<OpenidmAccountStatusNotificationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeOpenidmChangeListener(
        ConfigurationChangeListener<OpenidmAccountStatusNotificationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AccountStatusNotificationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AccountStatusNotificationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getAttributeType() {
      return pAttributeType;
    }



    /** {@inheritDoc} */
    public DN getCertificateSubjectDN() {
      return pCertificateSubjectDN;
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
    public String getKeyManagerProvider() {
      return pKeyManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getKeyManagerProviderDN() {
      String value = getKeyManagerProvider();
      if (value == null) return null;
      return INSTANCE.getKeyManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public String getLogFile() {
      return pLogFile;
    }



    /** {@inheritDoc} */
    public OpenidmCompatMode getOpenidmCompatMode() {
      return pOpenidmCompatMode;
    }



    /** {@inheritDoc} */
    public String getOpenidmPassword() {
      return pOpenidmPassword;
    }



    /** {@inheritDoc} */
    public String getOpenidmUrl() {
      return pOpenidmUrl;
    }



    /** {@inheritDoc} */
    public String getOpenidmUsername() {
      return pOpenidmUsername;
    }



    /** {@inheritDoc} */
    public String getPasswordAttribute() {
      return pPasswordAttribute;
    }



    /** {@inheritDoc} */
    public String getPrivateKeyAlias() {
      return pPrivateKeyAlias;
    }



    /** {@inheritDoc} */
    public String getQueryId() {
      return pQueryId;
    }



    /** {@inheritDoc} */
    public String getSSLCertNickname() {
      return pSSLCertNickname;
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return pTrustManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getTrustManagerProviderDN() {
      String value = getTrustManagerProvider();
      if (value == null) return null;
      return INSTANCE.getTrustManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public long getUpdateInterval() {
      return pUpdateInterval;
    }



    /** {@inheritDoc} */
    public Class<? extends OpenidmAccountStatusNotificationHandlerCfg> configurationClass() {
      return OpenidmAccountStatusNotificationHandlerCfg.class;
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
