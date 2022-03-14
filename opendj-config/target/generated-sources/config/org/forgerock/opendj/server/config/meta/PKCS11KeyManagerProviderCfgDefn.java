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
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.PKCS11KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.PKCS11KeyManagerProviderCfg;



/**
 * An interface for querying the PKCS11 Key Manager Provider managed
 * object definition meta information.
 * <p>
 * The PKCS11 Key Manager Provider enables the server to access the
 * private key information through the PKCS11 interface.
 */
public final class PKCS11KeyManagerProviderCfgDefn extends ManagedObjectDefinition<PKCS11KeyManagerProviderCfgClient, PKCS11KeyManagerProviderCfg> {

  /** The singleton configuration definition instance. */
  private static final PKCS11KeyManagerProviderCfgDefn INSTANCE = new PKCS11KeyManagerProviderCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-store-pin" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_PIN;



  /** The "key-store-pin-environment-variable" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_PIN_ENVIRONMENT_VARIABLE;



  /** The "key-store-pin-file" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_PIN_FILE;



  /** The "key-store-pin-property" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_PIN_PROPERTY;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.PKCS11KeyManagerProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.KeyManagerProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-store-pin" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-pin");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-pin"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_KEY_STORE_PIN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_PIN);
  }



  /** Build the "key-store-pin-environment-variable" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-pin-environment-variable");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-pin-environment-variable"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_KEY_STORE_PIN_ENVIRONMENT_VARIABLE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_PIN_ENVIRONMENT_VARIABLE);
  }



  /** Build the "key-store-pin-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-pin-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-pin-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FILE");
      PD_KEY_STORE_PIN_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_PIN_FILE);
  }



  /** Build the "key-store-pin-property" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-pin-property");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-pin-property"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_KEY_STORE_PIN_PROPERTY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_PIN_PROPERTY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the PKCS11 Key Manager Provider configuration definition
   * singleton.
   *
   * @return Returns the PKCS11 Key Manager Provider configuration
   *         definition singleton.
   */
  public static PKCS11KeyManagerProviderCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PKCS11KeyManagerProviderCfgDefn() {
    super("pkcs11-key-manager-provider", KeyManagerProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PKCS11KeyManagerProviderCfgClient createClientConfiguration(
      ManagedObject<? extends PKCS11KeyManagerProviderCfgClient> impl) {
    return new PKCS11KeyManagerProviderCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PKCS11KeyManagerProviderCfg createServerConfiguration(
      ServerManagedObject<? extends PKCS11KeyManagerProviderCfg> impl) {
    return new PKCS11KeyManagerProviderCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PKCS11KeyManagerProviderCfg> getServerConfigurationClass() {
    return PKCS11KeyManagerProviderCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the PKCS11 Key Manager Provider is enabled for
   * use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return KeyManagerProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * PKCS11 Key Manager Provider implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "key-store-pin" property definition.
   * <p>
   * Specifies the clear-text PIN needed to access the PKCS11 Key
   * Manager Provider .
   *
   * @return Returns the "key-store-pin" property definition.
   */
  public StringPropertyDefinition getKeyStorePinPropertyDefinition() {
    return PD_KEY_STORE_PIN;
  }



  /**
   * Get the "key-store-pin-environment-variable" property definition.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @return Returns the "key-store-pin-environment-variable" property definition.
   */
  public StringPropertyDefinition getKeyStorePinEnvironmentVariablePropertyDefinition() {
    return PD_KEY_STORE_PIN_ENVIRONMENT_VARIABLE;
  }



  /**
   * Get the "key-store-pin-file" property definition.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * PKCS11 Key Manager Provider .
   *
   * @return Returns the "key-store-pin-file" property definition.
   */
  public StringPropertyDefinition getKeyStorePinFilePropertyDefinition() {
    return PD_KEY_STORE_PIN_FILE;
  }



  /**
   * Get the "key-store-pin-property" property definition.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @return Returns the "key-store-pin-property" property definition.
   */
  public StringPropertyDefinition getKeyStorePinPropertyPropertyDefinition() {
    return PD_KEY_STORE_PIN_PROPERTY;
  }



  /**
   * Managed object client implementation.
   */
  private static class PKCS11KeyManagerProviderCfgClientImpl implements
    PKCS11KeyManagerProviderCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PKCS11KeyManagerProviderCfgClient> impl;



    /** Private constructor. */
    private PKCS11KeyManagerProviderCfgClientImpl(
        ManagedObject<? extends PKCS11KeyManagerProviderCfgClient> impl) {
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
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getKeyStorePin() {
      return impl.getPropertyValue(INSTANCE.getKeyStorePinPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStorePin(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStorePinPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getKeyStorePinEnvironmentVariable() {
      return impl.getPropertyValue(INSTANCE.getKeyStorePinEnvironmentVariablePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStorePinEnvironmentVariable(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStorePinEnvironmentVariablePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getKeyStorePinFile() {
      return impl.getPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStorePinFile(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getKeyStorePinProperty() {
      return impl.getPropertyValue(INSTANCE.getKeyStorePinPropertyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStorePinProperty(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStorePinPropertyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PKCS11KeyManagerProviderCfgClient, ? extends PKCS11KeyManagerProviderCfg> definition() {
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
  private static class PKCS11KeyManagerProviderCfgServerImpl implements
    PKCS11KeyManagerProviderCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PKCS11KeyManagerProviderCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-store-pin" property. */
    private final String pKeyStorePin;

    /** The value of the "key-store-pin-environment-variable" property. */
    private final String pKeyStorePinEnvironmentVariable;

    /** The value of the "key-store-pin-file" property. */
    private final String pKeyStorePinFile;

    /** The value of the "key-store-pin-property" property. */
    private final String pKeyStorePinProperty;



    /** Private constructor. */
    private PKCS11KeyManagerProviderCfgServerImpl(ServerManagedObject<? extends PKCS11KeyManagerProviderCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyStorePin = impl.getPropertyValue(INSTANCE.getKeyStorePinPropertyDefinition());
      this.pKeyStorePinEnvironmentVariable = impl.getPropertyValue(INSTANCE.getKeyStorePinEnvironmentVariablePropertyDefinition());
      this.pKeyStorePinFile = impl.getPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition());
      this.pKeyStorePinProperty = impl.getPropertyValue(INSTANCE.getKeyStorePinPropertyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPKCS11ChangeListener(
        ConfigurationChangeListener<PKCS11KeyManagerProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePKCS11ChangeListener(
        ConfigurationChangeListener<PKCS11KeyManagerProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<KeyManagerProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<KeyManagerProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public String getKeyStorePin() {
      return pKeyStorePin;
    }



    /** {@inheritDoc} */
    public String getKeyStorePinEnvironmentVariable() {
      return pKeyStorePinEnvironmentVariable;
    }



    /** {@inheritDoc} */
    public String getKeyStorePinFile() {
      return pKeyStorePinFile;
    }



    /** {@inheritDoc} */
    public String getKeyStorePinProperty() {
      return pKeyStorePinProperty;
    }



    /** {@inheritDoc} */
    public Class<? extends PKCS11KeyManagerProviderCfg> configurationClass() {
      return PKCS11KeyManagerProviderCfg.class;
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
