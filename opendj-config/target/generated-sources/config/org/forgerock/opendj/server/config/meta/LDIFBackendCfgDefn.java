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
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
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
import org.forgerock.opendj.server.config.client.LDIFBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.LDIFBackendCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;



/**
 * An interface for querying the LDIF Backend managed object
 * definition meta information.
 * <p>
 * The LDIF Backend provides a mechanism for interacting with data
 * stored in an LDIF file.
 */
public final class LDIFBackendCfgDefn extends ManagedObjectDefinition<LDIFBackendCfgClient, LDIFBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final LDIFBackendCfgDefn INSTANCE = new LDIFBackendCfgDefn();



  /** The "is-private-backend" property definition. */
  private static final BooleanPropertyDefinition PD_IS_PRIVATE_BACKEND;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "ldif-file" property definition. */
  private static final StringPropertyDefinition PD_LDIF_FILE;



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** Build the "is-private-backend" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "is-private-backend");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "is-private-backend"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_IS_PRIVATE_BACKEND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IS_PRIVATE_BACKEND);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.LDIFBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "ldif-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ldif-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "ldif-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_LDIF_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LDIF_FILE);
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



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the LDIF Backend configuration definition singleton.
   *
   * @return Returns the LDIF Backend configuration definition
   *         singleton.
   */
  public static LDIFBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private LDIFBackendCfgDefn() {
    super("ldif-backend", LocalBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public LDIFBackendCfgClient createClientConfiguration(
      ManagedObject<? extends LDIFBackendCfgClient> impl) {
    return new LDIFBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public LDIFBackendCfg createServerConfiguration(
      ServerManagedObject<? extends LDIFBackendCfg> impl) {
    return new LDIFBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<LDIFBackendCfg> getServerConfigurationClass() {
    return LDIFBackendCfg.class;
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
   * Get the "is-private-backend" property definition.
   * <p>
   * Indicates whether the backend should be considered a private
   * backend, which indicates that it is used for storing operational
   * data rather than user-defined information.
   *
   * @return Returns the "is-private-backend" property definition.
   */
  public BooleanPropertyDefinition getIsPrivateBackendPropertyDefinition() {
    return PD_IS_PRIVATE_BACKEND;
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
   * Get the "ldif-file" property definition.
   * <p>
   * Specifies the path to the LDIF file containing the data for this
   * backend.
   *
   * @return Returns the "ldif-file" property definition.
   */
  public StringPropertyDefinition getLDIFFilePropertyDefinition() {
    return PD_LDIF_FILE;
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
  private static class LDIFBackendCfgClientImpl implements
    LDIFBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends LDIFBackendCfgClient> impl;



    /** Private constructor. */
    private LDIFBackendCfgClientImpl(
        ManagedObject<? extends LDIFBackendCfgClient> impl) {
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
    public boolean isIsPrivateBackend() {
      return impl.getPropertyValue(INSTANCE.getIsPrivateBackendPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIsPrivateBackend(Boolean value) {
      impl.setPropertyValue(INSTANCE.getIsPrivateBackendPropertyDefinition(), value);
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
    public String getLDIFFile() {
      return impl.getPropertyValue(INSTANCE.getLDIFFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLDIFFile(String value) {
      impl.setPropertyValue(INSTANCE.getLDIFFilePropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends LDIFBackendCfgClient, ? extends LDIFBackendCfg> definition() {
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
  private static class LDIFBackendCfgServerImpl implements
    LDIFBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends LDIFBackendCfg> impl;

    /** The value of the "backend-id" property. */
    private final String pBackendId;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "is-private-backend" property. */
    private final boolean pIsPrivateBackend;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "ldif-file" property. */
    private final String pLDIFFile;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private LDIFBackendCfgServerImpl(ServerManagedObject<? extends LDIFBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIsPrivateBackend = impl.getPropertyValue(INSTANCE.getIsPrivateBackendPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLDIFFile = impl.getPropertyValue(INSTANCE.getLDIFFilePropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addLDIFChangeListener(
        ConfigurationChangeListener<LDIFBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeLDIFChangeListener(
        ConfigurationChangeListener<LDIFBackendCfg> listener) {
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
    public boolean isIsPrivateBackend() {
      return pIsPrivateBackend;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getLDIFFile() {
      return pLDIFFile;
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public Class<? extends LDIFBackendCfg> configurationClass() {
      return LDIFBackendCfg.class;
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
