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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectOption;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.RootDSEBackendCfgClient;
import org.forgerock.opendj.server.config.server.RootDSEBackendCfg;



/**
 * An interface for querying the Root DSE Backend managed object
 * definition meta information.
 * <p>
 * The Root DSE Backend contains the directory server root DSE.
 */
public final class RootDSEBackendCfgDefn extends ManagedObjectDefinition<RootDSEBackendCfgClient, RootDSEBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final RootDSEBackendCfgDefn INSTANCE = new RootDSEBackendCfgDefn();



  /** The "show-all-attributes" property definition. */
  private static final BooleanPropertyDefinition PD_SHOW_ALL_ATTRIBUTES;



  /** The "show-subordinate-naming-contexts" property definition. */
  private static final BooleanPropertyDefinition PD_SHOW_SUBORDINATE_NAMING_CONTEXTS;



  /** Build the "show-all-attributes" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "show-all-attributes");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "show-all-attributes"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_SHOW_ALL_ATTRIBUTES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SHOW_ALL_ATTRIBUTES);
  }



  /** Build the "show-subordinate-naming-contexts" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "show-subordinate-naming-contexts");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "show-subordinate-naming-contexts"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_SHOW_SUBORDINATE_NAMING_CONTEXTS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SHOW_SUBORDINATE_NAMING_CONTEXTS);
  }



  // Register the options associated with this managed object definition.
  static {
    INSTANCE.registerOption(ManagedObjectOption.ADVANCED);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Root DSE Backend configuration definition singleton.
   *
   * @return Returns the Root DSE Backend configuration definition
   *         singleton.
   */
  public static RootDSEBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private RootDSEBackendCfgDefn() {
    super("root-dse-backend", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public RootDSEBackendCfgClient createClientConfiguration(
      ManagedObject<? extends RootDSEBackendCfgClient> impl) {
    return new RootDSEBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public RootDSEBackendCfg createServerConfiguration(
      ServerManagedObject<? extends RootDSEBackendCfg> impl) {
    return new RootDSEBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<RootDSEBackendCfg> getServerConfigurationClass() {
    return RootDSEBackendCfg.class;
  }



  /**
   * Get the "show-all-attributes" property definition.
   * <p>
   * Indicates whether all attributes in the root DSE are to be
   * treated like user attributes (and therefore returned to clients by
   * default) regardless of the directory server schema configuration.
   *
   * @return Returns the "show-all-attributes" property definition.
   */
  public BooleanPropertyDefinition getShowAllAttributesPropertyDefinition() {
    return PD_SHOW_ALL_ATTRIBUTES;
  }



  /**
   * Get the "show-subordinate-naming-contexts" property definition.
   * <p>
   * Indicates whether subordinate naming contexts should be visible
   * in the namingContexts attribute of the RootDSE. By default only
   * top level naming contexts are visible
   *
   * @return Returns the "show-subordinate-naming-contexts" property definition.
   */
  public BooleanPropertyDefinition getShowSubordinateNamingContextsPropertyDefinition() {
    return PD_SHOW_SUBORDINATE_NAMING_CONTEXTS;
  }



  /**
   * Managed object client implementation.
   */
  private static class RootDSEBackendCfgClientImpl implements
    RootDSEBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends RootDSEBackendCfgClient> impl;



    /** Private constructor. */
    private RootDSEBackendCfgClientImpl(
        ManagedObject<? extends RootDSEBackendCfgClient> impl) {
      this.impl = impl;
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
    public boolean isShowSubordinateNamingContexts() {
      return impl.getPropertyValue(INSTANCE.getShowSubordinateNamingContextsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setShowSubordinateNamingContexts(boolean value) {
      impl.setPropertyValue(INSTANCE.getShowSubordinateNamingContextsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends RootDSEBackendCfgClient, ? extends RootDSEBackendCfg> definition() {
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
  private static class RootDSEBackendCfgServerImpl implements
    RootDSEBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends RootDSEBackendCfg> impl;

    /** The value of the "show-all-attributes" property. */
    private final boolean pShowAllAttributes;

    /** The value of the "show-subordinate-naming-contexts" property. */
    private final boolean pShowSubordinateNamingContexts;



    /** Private constructor. */
    private RootDSEBackendCfgServerImpl(ServerManagedObject<? extends RootDSEBackendCfg> impl) {
      this.impl = impl;
      this.pShowAllAttributes = impl.getPropertyValue(INSTANCE.getShowAllAttributesPropertyDefinition());
      this.pShowSubordinateNamingContexts = impl.getPropertyValue(INSTANCE.getShowSubordinateNamingContextsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<RootDSEBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<RootDSEBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isShowAllAttributes() {
      return pShowAllAttributes;
    }



    /** {@inheritDoc} */
    public boolean isShowSubordinateNamingContexts() {
      return pShowSubordinateNamingContexts;
    }



    /** {@inheritDoc} */
    public Class<? extends RootDSEBackendCfg> configurationClass() {
      return RootDSEBackendCfg.class;
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
