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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
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
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.BackendVLVIndexCfgClient;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;



/**
 * An interface for querying the Backend VLV Index managed object
 * definition meta information.
 * <p>
 * Backend VLV Indexes are used to store information about a specific
 * search request that makes it possible to efficiently process them
 * using the VLV control.
 */
public final class BackendVLVIndexCfgDefn extends ManagedObjectDefinition<BackendVLVIndexCfgClient, BackendVLVIndexCfg> {

  /** The singleton configuration definition instance. */
  private static final BackendVLVIndexCfgDefn INSTANCE = new BackendVLVIndexCfgDefn();



  /**
   * Defines the set of permissable values for the "scope" property.
   * <p>
   * Specifies the LDAP scope of the query that is being indexed.
   */
  public static enum Scope {

    /**
     * Search the base object only.
     */
    BASE_OBJECT("base-object"),



    /**
     * Search the immediate children of the base object but do not
     * include any of their descendants or the base object itself.
     */
    SINGLE_LEVEL("single-level"),



    /**
     * Search the entire subtree below the base object but do not
     * include the base object itself.
     */
    SUBORDINATE_SUBTREE("subordinate-subtree"),



    /**
     * Search the base object and the entire subtree below the base
     * object.
     */
    WHOLE_SUBTREE("whole-subtree");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private Scope(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "base-dn" property definition. */
  private static final DNPropertyDefinition PD_BASE_DN;



  /** The "filter" property definition. */
  private static final StringPropertyDefinition PD_FILTER;



  /** The "name" property definition. */
  private static final StringPropertyDefinition PD_NAME;



  /** The "scope" property definition. */
  private static final EnumPropertyDefinition<Scope> PD_SCOPE;



  /** The "sort-order" property definition. */
  private static final StringPropertyDefinition PD_SORT_ORDER;



  /** Build the "base-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "base-dn");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "base-dn"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BASE_DN);
  }



  /** Build the "filter" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "filter");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "filter"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_FILTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_FILTER);
  }



  /** Build the "name" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "name");
      builder.setOption(PropertyOption.READ_ONLY);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "name"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_NAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NAME);
  }



  /** Build the "scope" property definition. */
  static {
      EnumPropertyDefinition.Builder<Scope> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "scope");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "scope"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Scope>());
      builder.setEnumClass(Scope.class);
      PD_SCOPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SCOPE);
  }



  /** Build the "sort-order" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "sort-order");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.OTHER, INSTANCE, "sort-order"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "STRING");
      PD_SORT_ORDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SORT_ORDER);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Backend VLV Index configuration definition singleton.
   *
   * @return Returns the Backend VLV Index configuration definition
   *         singleton.
   */
  public static BackendVLVIndexCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private BackendVLVIndexCfgDefn() {
    super("backend-vlv-index", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public BackendVLVIndexCfgClient createClientConfiguration(
      ManagedObject<? extends BackendVLVIndexCfgClient> impl) {
    return new BackendVLVIndexCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public BackendVLVIndexCfg createServerConfiguration(
      ServerManagedObject<? extends BackendVLVIndexCfg> impl) {
    return new BackendVLVIndexCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<BackendVLVIndexCfg> getServerConfigurationClass() {
    return BackendVLVIndexCfg.class;
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DN used in the search query that is being
   * indexed.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return PD_BASE_DN;
  }



  /**
   * Get the "filter" property definition.
   * <p>
   * Specifies the LDAP filter used in the query that is being
   * indexed.
   *
   * @return Returns the "filter" property definition.
   */
  public StringPropertyDefinition getFilterPropertyDefinition() {
    return PD_FILTER;
  }



  /**
   * Get the "name" property definition.
   * <p>
   * Specifies a unique name for this VLV index.
   *
   * @return Returns the "name" property definition.
   */
  public StringPropertyDefinition getNamePropertyDefinition() {
    return PD_NAME;
  }



  /**
   * Get the "scope" property definition.
   * <p>
   * Specifies the LDAP scope of the query that is being indexed.
   *
   * @return Returns the "scope" property definition.
   */
  public EnumPropertyDefinition<Scope> getScopePropertyDefinition() {
    return PD_SCOPE;
  }



  /**
   * Get the "sort-order" property definition.
   * <p>
   * Specifies the names of the attributes that are used to sort the
   * entries for the query being indexed.
   * <p>
   * Multiple attributes can be used to determine the sort order by
   * listing the attribute names from highest to lowest precedence.
   * Optionally, + or - can be prefixed to the attribute name to sort
   * the attribute in ascending order or descending order respectively.
   *
   * @return Returns the "sort-order" property definition.
   */
  public StringPropertyDefinition getSortOrderPropertyDefinition() {
    return PD_SORT_ORDER;
  }



  /**
   * Managed object client implementation.
   */
  private static class BackendVLVIndexCfgClientImpl implements
    BackendVLVIndexCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends BackendVLVIndexCfgClient> impl;



    /** Private constructor. */
    private BackendVLVIndexCfgClientImpl(
        ManagedObject<? extends BackendVLVIndexCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public DN getBaseDN() {
      return impl.getPropertyValue(INSTANCE.getBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBaseDN(DN value) {
      impl.setPropertyValue(INSTANCE.getBaseDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getFilter() {
      return impl.getPropertyValue(INSTANCE.getFilterPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFilter(String value) {
      impl.setPropertyValue(INSTANCE.getFilterPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getName() {
      return impl.getPropertyValue(INSTANCE.getNamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setName(String value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getNamePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Scope getScope() {
      return impl.getPropertyValue(INSTANCE.getScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setScope(Scope value) {
      impl.setPropertyValue(INSTANCE.getScopePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getSortOrder() {
      return impl.getPropertyValue(INSTANCE.getSortOrderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSortOrder(String value) {
      impl.setPropertyValue(INSTANCE.getSortOrderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends BackendVLVIndexCfgClient, ? extends BackendVLVIndexCfg> definition() {
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
  private static class BackendVLVIndexCfgServerImpl implements
    BackendVLVIndexCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends BackendVLVIndexCfg> impl;

    /** The value of the "base-dn" property. */
    private final DN pBaseDN;

    /** The value of the "filter" property. */
    private final String pFilter;

    /** The value of the "name" property. */
    private final String pName;

    /** The value of the "scope" property. */
    private final Scope pScope;

    /** The value of the "sort-order" property. */
    private final String pSortOrder;



    /** Private constructor. */
    private BackendVLVIndexCfgServerImpl(ServerManagedObject<? extends BackendVLVIndexCfg> impl) {
      this.impl = impl;
      this.pBaseDN = impl.getPropertyValue(INSTANCE.getBaseDNPropertyDefinition());
      this.pFilter = impl.getPropertyValue(INSTANCE.getFilterPropertyDefinition());
      this.pName = impl.getPropertyValue(INSTANCE.getNamePropertyDefinition());
      this.pScope = impl.getPropertyValue(INSTANCE.getScopePropertyDefinition());
      this.pSortOrder = impl.getPropertyValue(INSTANCE.getSortOrderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<BackendVLVIndexCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<BackendVLVIndexCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public DN getBaseDN() {
      return pBaseDN;
    }



    /** {@inheritDoc} */
    public String getFilter() {
      return pFilter;
    }



    /** {@inheritDoc} */
    public String getName() {
      return pName;
    }



    /** {@inheritDoc} */
    public Scope getScope() {
      return pScope;
    }



    /** {@inheritDoc} */
    public String getSortOrder() {
      return pSortOrder;
    }



    /** {@inheritDoc} */
    public Class<? extends BackendVLVIndexCfg> configurationClass() {
      return BackendVLVIndexCfg.class;
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
