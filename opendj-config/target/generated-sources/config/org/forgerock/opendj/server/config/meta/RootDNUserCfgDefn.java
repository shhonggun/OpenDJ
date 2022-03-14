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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.RootDNUserCfgClient;
import org.forgerock.opendj.server.config.server.RootDNUserCfg;



/**
 * An interface for querying the Root DN User managed object
 * definition meta information.
 * <p>
 * A Root DN User are administrative users who can granted special
 * privileges that are not available to non-root users (for example,
 * the ability to bind to the server in lockdown mode).
 */
public final class RootDNUserCfgDefn extends ManagedObjectDefinition<RootDNUserCfgClient, RootDNUserCfg> {

  /** The singleton configuration definition instance. */
  private static final RootDNUserCfgDefn INSTANCE = new RootDNUserCfgDefn();



  /** The "alternate-bind-dn" property definition. */
  private static final DNPropertyDefinition PD_ALTERNATE_BIND_DN;



  /** Build the "alternate-bind-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "alternate-bind-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "alternate-bind-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "alternate-bind-dn"));
      PD_ALTERNATE_BIND_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALTERNATE_BIND_DN);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Root DN User configuration definition singleton.
   *
   * @return Returns the Root DN User configuration definition
   *         singleton.
   */
  public static RootDNUserCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private RootDNUserCfgDefn() {
    super("root-dn-user", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public RootDNUserCfgClient createClientConfiguration(
      ManagedObject<? extends RootDNUserCfgClient> impl) {
    return new RootDNUserCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public RootDNUserCfg createServerConfiguration(
      ServerManagedObject<? extends RootDNUserCfg> impl) {
    return new RootDNUserCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<RootDNUserCfg> getServerConfigurationClass() {
    return RootDNUserCfg.class;
  }



  /**
   * Get the "alternate-bind-dn" property definition.
   * <p>
   * Specifies one or more alternate DNs that can be used to bind to
   * the server as this root user.
   *
   * @return Returns the "alternate-bind-dn" property definition.
   */
  public DNPropertyDefinition getAlternateBindDNPropertyDefinition() {
    return PD_ALTERNATE_BIND_DN;
  }



  /**
   * Managed object client implementation.
   */
  private static class RootDNUserCfgClientImpl implements
    RootDNUserCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends RootDNUserCfgClient> impl;



    /** Private constructor. */
    private RootDNUserCfgClientImpl(
        ManagedObject<? extends RootDNUserCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getAlternateBindDN() {
      return impl.getPropertyValues(INSTANCE.getAlternateBindDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAlternateBindDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getAlternateBindDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends RootDNUserCfgClient, ? extends RootDNUserCfg> definition() {
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
  private static class RootDNUserCfgServerImpl implements
    RootDNUserCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends RootDNUserCfg> impl;

    /** The value of the "alternate-bind-dn" property. */
    private final SortedSet<DN> pAlternateBindDN;



    /** Private constructor. */
    private RootDNUserCfgServerImpl(ServerManagedObject<? extends RootDNUserCfg> impl) {
      this.impl = impl;
      this.pAlternateBindDN = impl.getPropertyValues(INSTANCE.getAlternateBindDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<RootDNUserCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<RootDNUserCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getAlternateBindDN() {
      return pAlternateBindDN;
    }



    /** {@inheritDoc} */
    public Class<? extends RootDNUserCfg> configurationClass() {
      return RootDNUserCfg.class;
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
