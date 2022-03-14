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
import org.forgerock.opendj.server.config.client.FileBasedTrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.FileBasedTrustManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the File Based Trust Manager Provider
 * managed object definition meta information.
 * <p>
 * The file-based trust manager provider determines whether to trust a
 * presented certificate based on whether that certificate exists in a
 * server trust store file.
 */
public final class FileBasedTrustManagerProviderCfgDefn extends ManagedObjectDefinition<FileBasedTrustManagerProviderCfgClient, FileBasedTrustManagerProviderCfg> {

  /** The singleton configuration definition instance. */
  private static final FileBasedTrustManagerProviderCfgDefn INSTANCE = new FileBasedTrustManagerProviderCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "trust-store-file" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_FILE;



  /** The "trust-store-pin" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_PIN;



  /** The "trust-store-pin-environment-variable" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_PIN_ENVIRONMENT_VARIABLE;



  /** The "trust-store-pin-file" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_PIN_FILE;



  /** The "trust-store-pin-property" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_PIN_PROPERTY;



  /** The "trust-store-type" property definition. */
  private static final StringPropertyDefinition PD_TRUST_STORE_TYPE;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.FileBasedTrustManagerProvider");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.TrustManagerProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "trust-store-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_TRUST_STORE_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_FILE);
  }



  /** Build the "trust-store-pin" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-pin");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-pin"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TRUST_STORE_PIN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_PIN);
  }



  /** Build the "trust-store-pin-environment-variable" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-pin-environment-variable");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-pin-environment-variable"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TRUST_STORE_PIN_ENVIRONMENT_VARIABLE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_PIN_ENVIRONMENT_VARIABLE);
  }



  /** Build the "trust-store-pin-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-pin-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-pin-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TRUST_STORE_PIN_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_PIN_FILE);
  }



  /** Build the "trust-store-pin-property" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-pin-property");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-pin-property"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TRUST_STORE_PIN_PROPERTY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_PIN_PROPERTY);
  }



  /** Build the "trust-store-type" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-type");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-type"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_TRUST_STORE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_TYPE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the File Based Trust Manager Provider configuration
   * definition singleton.
   *
   * @return Returns the File Based Trust Manager Provider
   *         configuration definition singleton.
   */
  public static FileBasedTrustManagerProviderCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FileBasedTrustManagerProviderCfgDefn() {
    super("file-based-trust-manager-provider", TrustManagerProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FileBasedTrustManagerProviderCfgClient createClientConfiguration(
      ManagedObject<? extends FileBasedTrustManagerProviderCfgClient> impl) {
    return new FileBasedTrustManagerProviderCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FileBasedTrustManagerProviderCfg createServerConfiguration(
      ServerManagedObject<? extends FileBasedTrustManagerProviderCfg> impl) {
    return new FileBasedTrustManagerProviderCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FileBasedTrustManagerProviderCfg> getServerConfigurationClass() {
    return FileBasedTrustManagerProviderCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicate whether the File Based Trust Manager Provider is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return TrustManagerProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Trust Manager Provider implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "trust-store-file" property definition.
   * <p>
   * Specifies the path to the file containing the trust information.
   * It can be an absolute path or a path that is relative to the
   * OpenDJ instance root.
   * <p>
   * Changes to this configuration attribute take effect the next time
   * that the trust manager is accessed.
   *
   * @return Returns the "trust-store-file" property definition.
   */
  public StringPropertyDefinition getTrustStoreFilePropertyDefinition() {
    return PD_TRUST_STORE_FILE;
  }



  /**
   * Get the "trust-store-pin" property definition.
   * <p>
   * Specifies the clear-text PIN needed to access the File Based
   * Trust Manager Provider .
   *
   * @return Returns the "trust-store-pin" property definition.
   */
  public StringPropertyDefinition getTrustStorePinPropertyDefinition() {
    return PD_TRUST_STORE_PIN;
  }



  /**
   * Get the "trust-store-pin-environment-variable" property definition.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @return Returns the "trust-store-pin-environment-variable" property definition.
   */
  public StringPropertyDefinition getTrustStorePinEnvironmentVariablePropertyDefinition() {
    return PD_TRUST_STORE_PIN_ENVIRONMENT_VARIABLE;
  }



  /**
   * Get the "trust-store-pin-file" property definition.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * File Based Trust Manager Provider .
   *
   * @return Returns the "trust-store-pin-file" property definition.
   */
  public StringPropertyDefinition getTrustStorePinFilePropertyDefinition() {
    return PD_TRUST_STORE_PIN_FILE;
  }



  /**
   * Get the "trust-store-pin-property" property definition.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @return Returns the "trust-store-pin-property" property definition.
   */
  public StringPropertyDefinition getTrustStorePinPropertyPropertyDefinition() {
    return PD_TRUST_STORE_PIN_PROPERTY;
  }



  /**
   * Get the "trust-store-type" property definition.
   * <p>
   * Specifies the format for the data in the trust store file.
   * <p>
   * Valid values always include 'JKS' and 'PKCS12', but different
   * implementations can allow other values as well. If no value is
   * provided, then the JVM default value is used. Changes to this
   * configuration attribute take effect the next time that the trust
   * manager is accessed.
   *
   * @return Returns the "trust-store-type" property definition.
   */
  public StringPropertyDefinition getTrustStoreTypePropertyDefinition() {
    return PD_TRUST_STORE_TYPE;
  }



  /**
   * Managed object client implementation.
   */
  private static class FileBasedTrustManagerProviderCfgClientImpl implements
    FileBasedTrustManagerProviderCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FileBasedTrustManagerProviderCfgClient> impl;



    /** Private constructor. */
    private FileBasedTrustManagerProviderCfgClientImpl(
        ManagedObject<? extends FileBasedTrustManagerProviderCfgClient> impl) {
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
    public String getTrustStoreFile() {
      return impl.getPropertyValue(INSTANCE.getTrustStoreFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStoreFile(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStoreFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustStorePin() {
      return impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStorePin(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStorePinPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustStorePinEnvironmentVariable() {
      return impl.getPropertyValue(INSTANCE.getTrustStorePinEnvironmentVariablePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStorePinEnvironmentVariable(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStorePinEnvironmentVariablePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustStorePinFile() {
      return impl.getPropertyValue(INSTANCE.getTrustStorePinFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStorePinFile(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStorePinFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustStorePinProperty() {
      return impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStorePinProperty(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStorePinPropertyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrustStoreType() {
      return impl.getPropertyValue(INSTANCE.getTrustStoreTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustStoreType(String value) {
      impl.setPropertyValue(INSTANCE.getTrustStoreTypePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends FileBasedTrustManagerProviderCfgClient, ? extends FileBasedTrustManagerProviderCfg> definition() {
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
  private static class FileBasedTrustManagerProviderCfgServerImpl implements
    FileBasedTrustManagerProviderCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FileBasedTrustManagerProviderCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "trust-store-file" property. */
    private final String pTrustStoreFile;

    /** The value of the "trust-store-pin" property. */
    private final String pTrustStorePin;

    /** The value of the "trust-store-pin-environment-variable" property. */
    private final String pTrustStorePinEnvironmentVariable;

    /** The value of the "trust-store-pin-file" property. */
    private final String pTrustStorePinFile;

    /** The value of the "trust-store-pin-property" property. */
    private final String pTrustStorePinProperty;

    /** The value of the "trust-store-type" property. */
    private final String pTrustStoreType;



    /** Private constructor. */
    private FileBasedTrustManagerProviderCfgServerImpl(ServerManagedObject<? extends FileBasedTrustManagerProviderCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pTrustStoreFile = impl.getPropertyValue(INSTANCE.getTrustStoreFilePropertyDefinition());
      this.pTrustStorePin = impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyDefinition());
      this.pTrustStorePinEnvironmentVariable = impl.getPropertyValue(INSTANCE.getTrustStorePinEnvironmentVariablePropertyDefinition());
      this.pTrustStorePinFile = impl.getPropertyValue(INSTANCE.getTrustStorePinFilePropertyDefinition());
      this.pTrustStorePinProperty = impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyPropertyDefinition());
      this.pTrustStoreType = impl.getPropertyValue(INSTANCE.getTrustStoreTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFileBasedChangeListener(
        ConfigurationChangeListener<FileBasedTrustManagerProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFileBasedChangeListener(
        ConfigurationChangeListener<FileBasedTrustManagerProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<TrustManagerProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<TrustManagerProviderCfg> listener) {
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
    public String getTrustStoreFile() {
      return pTrustStoreFile;
    }



    /** {@inheritDoc} */
    public String getTrustStorePin() {
      return pTrustStorePin;
    }



    /** {@inheritDoc} */
    public String getTrustStorePinEnvironmentVariable() {
      return pTrustStorePinEnvironmentVariable;
    }



    /** {@inheritDoc} */
    public String getTrustStorePinFile() {
      return pTrustStorePinFile;
    }



    /** {@inheritDoc} */
    public String getTrustStorePinProperty() {
      return pTrustStorePinProperty;
    }



    /** {@inheritDoc} */
    public String getTrustStoreType() {
      return pTrustStoreType;
    }



    /** {@inheritDoc} */
    public Class<? extends FileBasedTrustManagerProviderCfg> configurationClass() {
      return FileBasedTrustManagerProviderCfg.class;
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
