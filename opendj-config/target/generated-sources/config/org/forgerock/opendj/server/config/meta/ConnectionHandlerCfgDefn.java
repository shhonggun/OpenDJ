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
import org.forgerock.opendj.config.IPAddressMaskPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.ConnectionHandlerCfgClient;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;



/**
 * An interface for querying the Connection Handler managed object
 * definition meta information.
 * <p>
 * Connection Handlers are responsible for handling all interaction
 * with the clients, including accepting the connections, reading
 * requests, and sending responses.
 */
public final class ConnectionHandlerCfgDefn extends ManagedObjectDefinition<ConnectionHandlerCfgClient, ConnectionHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final ConnectionHandlerCfgDefn INSTANCE = new ConnectionHandlerCfgDefn();



  /** The "allowed-client" property definition. */
  private static final IPAddressMaskPropertyDefinition PD_ALLOWED_CLIENT;



  /** The "denied-client" property definition. */
  private static final IPAddressMaskPropertyDefinition PD_DENIED_CLIENT;



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "allowed-client" property definition. */
  static {
      IPAddressMaskPropertyDefinition.Builder builder = IPAddressMaskPropertyDefinition.createBuilder(INSTANCE, "allowed-client");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allowed-client"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<AddressMask>(INSTANCE, "allowed-client"));
      PD_ALLOWED_CLIENT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOWED_CLIENT);
  }



  /** Build the "denied-client" property definition. */
  static {
      IPAddressMaskPropertyDefinition.Builder builder = IPAddressMaskPropertyDefinition.createBuilder(INSTANCE, "denied-client");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "denied-client"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<AddressMask>(INSTANCE, "denied-client"));
      PD_DENIED_CLIENT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DENIED_CLIENT);
  }



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.ConnectionHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Connection Handler configuration definition singleton.
   *
   * @return Returns the Connection Handler configuration definition
   *         singleton.
   */
  public static ConnectionHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ConnectionHandlerCfgDefn() {
    super("connection-handler", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ConnectionHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends ConnectionHandlerCfgClient> impl) {
    return new ConnectionHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ConnectionHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends ConnectionHandlerCfg> impl) {
    return new ConnectionHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ConnectionHandlerCfg> getServerConfigurationClass() {
    return ConnectionHandlerCfg.class;
  }



  /**
   * Get the "allowed-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the "allowed-client" property definition.
   */
  public IPAddressMaskPropertyDefinition getAllowedClientPropertyDefinition() {
    return PD_ALLOWED_CLIENT;
  }



  /**
   * Get the "denied-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask. If both allowed and denied client masks are defined and a
   * client connection matches one or more masks in both lists, then
   * the connection is denied. If only a denied list is specified, then
   * any client not matching a mask in that list is allowed.
   *
   * @return Returns the "denied-client" property definition.
   */
  public IPAddressMaskPropertyDefinition getDeniedClientPropertyDefinition() {
    return PD_DENIED_CLIENT;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Connection Handler is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Connection Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class ConnectionHandlerCfgClientImpl implements
    ConnectionHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ConnectionHandlerCfgClient> impl;



    /** Private constructor. */
    private ConnectionHandlerCfgClientImpl(
        ManagedObject<? extends ConnectionHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getAllowedClient() {
      return impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowedClient(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getAllowedClientPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getDeniedClient() {
      return impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDeniedClient(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getDeniedClientPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends ConnectionHandlerCfgClient, ? extends ConnectionHandlerCfg> definition() {
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
  private static class ConnectionHandlerCfgServerImpl implements
    ConnectionHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ConnectionHandlerCfg> impl;

    /** The value of the "allowed-client" property. */
    private final SortedSet<AddressMask> pAllowedClient;

    /** The value of the "denied-client" property. */
    private final SortedSet<AddressMask> pDeniedClient;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private ConnectionHandlerCfgServerImpl(ServerManagedObject<? extends ConnectionHandlerCfg> impl) {
      this.impl = impl;
      this.pAllowedClient = impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
      this.pDeniedClient = impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ConnectionHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ConnectionHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getAllowedClient() {
      return pAllowedClient;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getDeniedClient() {
      return pDeniedClient;
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
    public Class<? extends ConnectionHandlerCfg> configurationClass() {
      return ConnectionHandlerCfg.class;
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
