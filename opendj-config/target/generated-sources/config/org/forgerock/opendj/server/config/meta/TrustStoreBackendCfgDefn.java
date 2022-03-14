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
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectOption;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.TrustStoreBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;
import org.forgerock.opendj.server.config.server.TrustStoreBackendCfg;



/**
 * An interface for querying the Trust Store Backend managed object
 * definition meta information.
 * <p>
 * The Trust Store Backend provides an LDAP view of a file-based trust
 * store. It is used by the administrative cryptographic framework.
 */
public final class TrustStoreBackendCfgDefn extends ManagedObjectDefinition<TrustStoreBackendCfgClient, TrustStoreBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final TrustStoreBackendCfgDefn INSTANCE = new TrustStoreBackendCfgDefn();



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



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.TrustStoreBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "trust-store-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "trust-store-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-store-file"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("config/ads-truststore");
      builder.setDefaultBehaviorProvider(provider);
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
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "trust-store-type"));
      PD_TRUST_STORE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_STORE_TYPE);
  }



  /** Build the "writability-mode" property definition. */
  static {
      EnumPropertyDefinition.Builder<WritabilityMode> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "writability-mode");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "writability-mode"));
      DefaultBehaviorProvider<WritabilityMode> provider = new DefinedDefaultBehaviorProvider<WritabilityMode>("enabled");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(WritabilityMode.class);
      PD_WRITABILITY_MODE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_WRITABILITY_MODE);
  }



  // Register the options associated with this managed object definition.
  static {
    INSTANCE.registerOption(ManagedObjectOption.ADVANCED);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Trust Store Backend configuration definition singleton.
   *
   * @return Returns the Trust Store Backend configuration definition
   *         singleton.
   */
  public static TrustStoreBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private TrustStoreBackendCfgDefn() {
    super("trust-store-backend", LocalBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public TrustStoreBackendCfgClient createClientConfiguration(
      ManagedObject<? extends TrustStoreBackendCfgClient> impl) {
    return new TrustStoreBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public TrustStoreBackendCfg createServerConfiguration(
      ServerManagedObject<? extends TrustStoreBackendCfg> impl) {
    return new TrustStoreBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<TrustStoreBackendCfg> getServerConfigurationClass() {
    return TrustStoreBackendCfg.class;
  }



  /**
   * Get the "backend-id" property definition.
   * <p>
   * Specifies a name to identify the associated backend.
   * <p>
   * The name must be unique among all backends in the server. The
   * backend ID may not be altered after the backend is created in the
   * server.
   *
   * @return Returns the "backend-id" property definition.
   */
  public StringPropertyDefinition getBackendIdPropertyDefinition() {
    return LocalBackendCfgDefn.getInstance().getBackendIdPropertyDefinition();
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DN(s) for the data that the backend handles.
   * <p>
   * A single backend may be responsible for one or more base DNs.
   * Note that no two backends may have the same base DN although one
   * backend may have a base DN that is below a base DN provided by
   * another backend (similar to the use of sub-suffixes in the Sun
   * Java System Directory Server). If any of the base DNs is
   * subordinate to a base DN for another backend, then all base DNs
   * for that backend must be subordinate to that same base DN.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return LocalBackendCfgDefn.getInstance().getBaseDNPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the backend is enabled in the server.
   * <p>
   * If a backend is not enabled, then its contents are not accessible
   * when processing operations.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return LocalBackendCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "trust-store-file" property definition.
   * <p>
   * Specifies the path to the file that stores the trust information.
   * <p>
   * It may be an absolute path, or a path that is relative to the
   * OpenDJ instance root.
   *
   * @return Returns the "trust-store-file" property definition.
   */
  public StringPropertyDefinition getTrustStoreFilePropertyDefinition() {
    return PD_TRUST_STORE_FILE;
  }



  /**
   * Get the "trust-store-pin" property definition.
   * <p>
   * Specifies the clear-text PIN needed to access the Trust Store
   * Backend .
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
   * clear-text PIN needed to access the Trust Store Backend .
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
   * Trust Store Backend .
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
   * clear-text PIN needed to access the Trust Store Backend .
   *
   * @return Returns the "trust-store-pin-property" property definition.
   */
  public StringPropertyDefinition getTrustStorePinPropertyPropertyDefinition() {
    return PD_TRUST_STORE_PIN_PROPERTY;
  }



  /**
   * Get the "trust-store-type" property definition.
   * <p>
   * Specifies the format for the data in the key store file.
   * <p>
   * Valid values should always include 'JKS' and 'PKCS12', but
   * different implementations may allow other values as well.
   *
   * @return Returns the "trust-store-type" property definition.
   */
  public StringPropertyDefinition getTrustStoreTypePropertyDefinition() {
    return PD_TRUST_STORE_TYPE;
  }



  /**
   * Get the "writability-mode" property definition.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the "writability-mode" property definition.
   */
  public EnumPropertyDefinition<WritabilityMode> getWritabilityModePropertyDefinition() {
    return PD_WRITABILITY_MODE;
  }



  /**
   * Managed object client implementation.
   */
  private static class TrustStoreBackendCfgClientImpl implements
    TrustStoreBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends TrustStoreBackendCfgClient> impl;



    /** Private constructor. */
    private TrustStoreBackendCfgClientImpl(
        ManagedObject<? extends TrustStoreBackendCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public String getBackendId() {
      return impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBackendId(String value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getBackendIdPropertyDefinition(), value);
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
    public WritabilityMode getWritabilityMode() {
      return impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setWritabilityMode(WritabilityMode value) {
      impl.setPropertyValue(INSTANCE.getWritabilityModePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends TrustStoreBackendCfgClient, ? extends TrustStoreBackendCfg> definition() {
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
  private static class TrustStoreBackendCfgServerImpl implements
    TrustStoreBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends TrustStoreBackendCfg> impl;

    /** The value of the "backend-id" property. */
    private final String pBackendId;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

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

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private TrustStoreBackendCfgServerImpl(ServerManagedObject<? extends TrustStoreBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pTrustStoreFile = impl.getPropertyValue(INSTANCE.getTrustStoreFilePropertyDefinition());
      this.pTrustStorePin = impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyDefinition());
      this.pTrustStorePinEnvironmentVariable = impl.getPropertyValue(INSTANCE.getTrustStorePinEnvironmentVariablePropertyDefinition());
      this.pTrustStorePinFile = impl.getPropertyValue(INSTANCE.getTrustStorePinFilePropertyDefinition());
      this.pTrustStorePinProperty = impl.getPropertyValue(INSTANCE.getTrustStorePinPropertyPropertyDefinition());
      this.pTrustStoreType = impl.getPropertyValue(INSTANCE.getTrustStoreTypePropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addTrustStoreChangeListener(
        ConfigurationChangeListener<TrustStoreBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeTrustStoreChangeListener(
        ConfigurationChangeListener<TrustStoreBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addLocalChangeListener(
        ConfigurationChangeListener<LocalBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeLocalChangeListener(
        ConfigurationChangeListener<LocalBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<BackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<BackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getBackendId() {
      return pBackendId;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return pBaseDN;
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
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public Class<? extends TrustStoreBackendCfg> configurationClass() {
      return TrustStoreBackendCfg.class;
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
