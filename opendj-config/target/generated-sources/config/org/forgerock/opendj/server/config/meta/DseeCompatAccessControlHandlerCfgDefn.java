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
import org.forgerock.opendj.config.ACIPropertyDefinition;
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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.DseeCompatAccessControlHandlerCfgClient;
import org.forgerock.opendj.server.config.server.AccessControlHandlerCfg;
import org.forgerock.opendj.server.config.server.DseeCompatAccessControlHandlerCfg;



/**
 * An interface for querying the Dsee Compat Access Control Handler
 * managed object definition meta information.
 * <p>
 * The Dsee Compat Access Control Handler provides an implementation
 * that uses syntax compatible with the Sun Java System Directory
 * Server Enterprise Edition access control handlers.
 */
public final class DseeCompatAccessControlHandlerCfgDefn extends ManagedObjectDefinition<DseeCompatAccessControlHandlerCfgClient, DseeCompatAccessControlHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final DseeCompatAccessControlHandlerCfgDefn INSTANCE = new DseeCompatAccessControlHandlerCfgDefn();



  /** The "global-aci" property definition. */
  private static final ACIPropertyDefinition PD_GLOBAL_ACI;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "global-aci" property definition. */
  static {
      ACIPropertyDefinition.Builder builder = ACIPropertyDefinition.createBuilder(INSTANCE, "global-aci");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "global-aci"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "global-aci"));
      PD_GLOBAL_ACI = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_GLOBAL_ACI);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.authorization.dseecompat.AciHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AccessControlHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the Dsee Compat Access Control Handler configuration
   * definition singleton.
   *
   * @return Returns the Dsee Compat Access Control Handler
   *         configuration definition singleton.
   */
  public static DseeCompatAccessControlHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private DseeCompatAccessControlHandlerCfgDefn() {
    super("dsee-compat-access-control-handler", AccessControlHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public DseeCompatAccessControlHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends DseeCompatAccessControlHandlerCfgClient> impl) {
    return new DseeCompatAccessControlHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public DseeCompatAccessControlHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends DseeCompatAccessControlHandlerCfg> impl) {
    return new DseeCompatAccessControlHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<DseeCompatAccessControlHandlerCfg> getServerConfigurationClass() {
    return DseeCompatAccessControlHandlerCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Dsee Compat Access Control Handler is
   * enabled. If set to FALSE, then no access control is enforced, and
   * any client (including unauthenticated or anonymous clients) could
   * be allowed to perform any operation if not subject to other
   * restrictions, such as those enforced by the privilege subsystem.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AccessControlHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "global-aci" property definition.
   * <p>
   * Defines global access control rules.
   * <p>
   * Global access control rules apply to all entries anywhere in the
   * data managed by the OpenDJ directory server. The global access
   * control rules may be overridden by more specific access control
   * rules placed in the data.
   *
   * @return Returns the "global-aci" property definition.
   */
  public ACIPropertyDefinition getGlobalACIPropertyDefinition() {
    return PD_GLOBAL_ACI;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Dsee Compat Access Control Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class DseeCompatAccessControlHandlerCfgClientImpl implements
    DseeCompatAccessControlHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends DseeCompatAccessControlHandlerCfgClient> impl;



    /** Private constructor. */
    private DseeCompatAccessControlHandlerCfgClientImpl(
        ManagedObject<? extends DseeCompatAccessControlHandlerCfgClient> impl) {
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
    public SortedSet<String> getGlobalACI() {
      return impl.getPropertyValues(INSTANCE.getGlobalACIPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setGlobalACI(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getGlobalACIPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends DseeCompatAccessControlHandlerCfgClient, ? extends DseeCompatAccessControlHandlerCfg> definition() {
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
  private static class DseeCompatAccessControlHandlerCfgServerImpl implements
    DseeCompatAccessControlHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends DseeCompatAccessControlHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "global-aci" property. */
    private final SortedSet<String> pGlobalACI;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private DseeCompatAccessControlHandlerCfgServerImpl(ServerManagedObject<? extends DseeCompatAccessControlHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pGlobalACI = impl.getPropertyValues(INSTANCE.getGlobalACIPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addDseeCompatChangeListener(
        ConfigurationChangeListener<DseeCompatAccessControlHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeDseeCompatChangeListener(
        ConfigurationChangeListener<DseeCompatAccessControlHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AccessControlHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AccessControlHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getGlobalACI() {
      return pGlobalACI;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends DseeCompatAccessControlHandlerCfg> configurationClass() {
      return DseeCompatAccessControlHandlerCfg.class;
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
