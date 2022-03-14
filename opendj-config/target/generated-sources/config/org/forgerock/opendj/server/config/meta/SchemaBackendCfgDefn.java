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
import org.forgerock.opendj.server.config.client.SchemaBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;
import org.forgerock.opendj.server.config.server.SchemaBackendCfg;



/**
 * An interface for querying the Schema Backend managed object
 * definition meta information.
 * <p>
 * The Schema Backend provides access to the directory server schema
 * information, including the attribute types, object classes,
 * attribute syntaxes, matching rules, matching rule uses, DIT content
 * rules, and DIT structure rules that it contains.
 */
public final class SchemaBackendCfgDefn extends ManagedObjectDefinition<SchemaBackendCfgClient, SchemaBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final SchemaBackendCfgDefn INSTANCE = new SchemaBackendCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "schema-entry-dn" property definition. */
  private static final DNPropertyDefinition PD_SCHEMA_ENTRY_DN;



  /** The "show-all-attributes" property definition. */
  private static final BooleanPropertyDefinition PD_SHOW_ALL_ATTRIBUTES;



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.SchemaBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "schema-entry-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "schema-entry-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "schema-entry-dn"));
      DefaultBehaviorProvider<DN> provider = new DefinedDefaultBehaviorProvider<DN>("cn=schema");
      builder.setDefaultBehaviorProvider(provider);
      PD_SCHEMA_ENTRY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SCHEMA_ENTRY_DN);
  }



  /** Build the "show-all-attributes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "show-all-attributes");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "show-all-attributes"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_SHOW_ALL_ATTRIBUTES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SHOW_ALL_ATTRIBUTES);
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
   * Get the Schema Backend configuration definition singleton.
   *
   * @return Returns the Schema Backend configuration definition
   *         singleton.
   */
  public static SchemaBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SchemaBackendCfgDefn() {
    super("schema-backend", LocalBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SchemaBackendCfgClient createClientConfiguration(
      ManagedObject<? extends SchemaBackendCfgClient> impl) {
    return new SchemaBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SchemaBackendCfg createServerConfiguration(
      ServerManagedObject<? extends SchemaBackendCfg> impl) {
    return new SchemaBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SchemaBackendCfg> getServerConfigurationClass() {
    return SchemaBackendCfg.class;
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
   * Get the "schema-entry-dn" property definition.
   * <p>
   * Defines the base DNs of the subtrees in which the schema
   * information is published in addition to the value included in the
   * base-dn property.
   * <p>
   * The value provided in the base-dn property is the only one that
   * appears in the subschemaSubentry operational attribute of the
   * server's root DSE (which is necessary because that is a
   * single-valued attribute) and as a virtual attribute in other
   * entries. The schema-entry-dn attribute may be used to make the
   * schema information available in other locations to accommodate
   * certain client applications that have been hard-coded to expect
   * the schema to reside in a specific location.
   *
   * @return Returns the "schema-entry-dn" property definition.
   */
  public DNPropertyDefinition getSchemaEntryDNPropertyDefinition() {
    return PD_SCHEMA_ENTRY_DN;
  }



  /**
   * Get the "show-all-attributes" property definition.
   * <p>
   * Indicates whether to treat all attributes in the schema entry as
   * if they were user attributes regardless of their configuration.
   * <p>
   * This may provide compatibility with some applications that expect
   * schema attributes like attributeTypes and objectClasses to be
   * included by default even if they are not requested. Note that the
   * ldapSyntaxes attribute is always treated as operational in order
   * to avoid problems with attempts to modify the schema over
   * protocol.
   *
   * @return Returns the "show-all-attributes" property definition.
   */
  public BooleanPropertyDefinition getShowAllAttributesPropertyDefinition() {
    return PD_SHOW_ALL_ATTRIBUTES;
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
  private static class SchemaBackendCfgClientImpl implements
    SchemaBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SchemaBackendCfgClient> impl;



    /** Private constructor. */
    private SchemaBackendCfgClientImpl(
        ManagedObject<? extends SchemaBackendCfgClient> impl) {
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
    public SortedSet<DN> getSchemaEntryDN() {
      return impl.getPropertyValues(INSTANCE.getSchemaEntryDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSchemaEntryDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getSchemaEntryDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public Boolean isShowAllAttributes() {
      return impl.getPropertyValue(INSTANCE.getShowAllAttributesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setShowAllAttributes(boolean value) {
      impl.setPropertyValue(INSTANCE.getShowAllAttributesPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends SchemaBackendCfgClient, ? extends SchemaBackendCfg> definition() {
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
  private static class SchemaBackendCfgServerImpl implements
    SchemaBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SchemaBackendCfg> impl;

    /** The value of the "backend-id" property. */
    private final String pBackendId;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "schema-entry-dn" property. */
    private final SortedSet<DN> pSchemaEntryDN;

    /** The value of the "show-all-attributes" property. */
    private final boolean pShowAllAttributes;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private SchemaBackendCfgServerImpl(ServerManagedObject<? extends SchemaBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pSchemaEntryDN = impl.getPropertyValues(INSTANCE.getSchemaEntryDNPropertyDefinition());
      this.pShowAllAttributes = impl.getPropertyValue(INSTANCE.getShowAllAttributesPropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSchemaChangeListener(
        ConfigurationChangeListener<SchemaBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSchemaChangeListener(
        ConfigurationChangeListener<SchemaBackendCfg> listener) {
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
    public SortedSet<DN> getSchemaEntryDN() {
      return pSchemaEntryDN;
    }



    /** {@inheritDoc} */
    public boolean isShowAllAttributes() {
      return pShowAllAttributes;
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public Class<? extends SchemaBackendCfg> configurationClass() {
      return SchemaBackendCfg.class;
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
