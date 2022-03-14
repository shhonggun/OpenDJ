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



import java.net.InetAddress;
import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.GenericConstraint;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.IPAddressMaskPropertyDefinition;
import org.forgerock.opendj.config.IPAddressPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.JMXConnectionHandlerCfgClient;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.JMXConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;



/**
 * An interface for querying the JMX Connection Handler managed object
 * definition meta information.
 * <p>
 * The JMX Connection Handler is used to interact with clients using
 * the Java Management Extensions (JMX) protocol.
 */
public final class JMXConnectionHandlerCfgDefn extends ManagedObjectDefinition<JMXConnectionHandlerCfgClient, JMXConnectionHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final JMXConnectionHandlerCfgDefn INSTANCE = new JMXConnectionHandlerCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "listen-address" property definition. */
  private static final IPAddressPropertyDefinition PD_LISTEN_ADDRESS;



  /** The "listen-port" property definition. */
  private static final IntegerPropertyDefinition PD_LISTEN_PORT;



  /** The "rmi-port" property definition. */
  private static final IntegerPropertyDefinition PD_RMI_PORT;



  /** The "ssl-cert-nickname" property definition. */
  private static final StringPropertyDefinition PD_SSL_CERT_NICKNAME;



  /** The "use-ssl" property definition. */
  private static final BooleanPropertyDefinition PD_USE_SSL;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.jmx.JmxConnectionHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.ConnectionHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<KeyManagerProviderCfgClient, KeyManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "key-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-manager-provider"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("key-manager-provider");
      builder.setTargetNeedsEnablingCondition(Conditions.and(Conditions.contains("enabled", "true"), Conditions.contains("use-ssl", "true")));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_KEY_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_KEY_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "listen-address" property definition. */
  static {
      IPAddressPropertyDefinition.Builder builder = IPAddressPropertyDefinition.createBuilder(INSTANCE, "listen-address");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "listen-address"));
      DefaultBehaviorProvider<InetAddress> provider = new DefinedDefaultBehaviorProvider<InetAddress>("0.0.0.0");
      builder.setDefaultBehaviorProvider(provider);
      PD_LISTEN_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LISTEN_ADDRESS);
  }



  /** Build the "listen-port" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "listen-port");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "listen-port"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setUpperLimit(65535);
      builder.setLowerLimit(1);
      PD_LISTEN_PORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LISTEN_PORT);
  }



  /** Build the "rmi-port" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "rmi-port");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "rmi-port"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(65535);
      builder.setLowerLimit(0);
      PD_RMI_PORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RMI_PORT);
  }



  /** Build the "ssl-cert-nickname" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cert-nickname");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "ssl-cert-nickname"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-cert-nickname"));
      PD_SSL_CERT_NICKNAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CERT_NICKNAME);
  }



  /** Build the "use-ssl" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-ssl");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "use-ssl"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_SSL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_SSL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.contains("enabled", "true"), Conditions.implies(Conditions.contains("use-ssl", "true"), Conditions.isPresent("key-manager-provider")))));
  }



  /**
   * Get the JMX Connection Handler configuration definition
   * singleton.
   *
   * @return Returns the JMX Connection Handler configuration
   *         definition singleton.
   */
  public static JMXConnectionHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private JMXConnectionHandlerCfgDefn() {
    super("jmx-connection-handler", ConnectionHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public JMXConnectionHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends JMXConnectionHandlerCfgClient> impl) {
    return new JMXConnectionHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public JMXConnectionHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends JMXConnectionHandlerCfg> impl) {
    return new JMXConnectionHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<JMXConnectionHandlerCfg> getServerConfigurationClass() {
    return JMXConnectionHandlerCfg.class;
  }



  /**
   * Get the "allowed-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this JMX
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the "allowed-client" property definition.
   */
  public IPAddressMaskPropertyDefinition getAllowedClientPropertyDefinition() {
    return ConnectionHandlerCfgDefn.getInstance().getAllowedClientPropertyDefinition();
  }



  /**
   * Get the "denied-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this JMX
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
    return ConnectionHandlerCfgDefn.getInstance().getDeniedClientPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the JMX Connection Handler is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return ConnectionHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the JMX Connection Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "key-manager-provider" property definition.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this JMX Connection Handler .
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return PD_KEY_MANAGER_PROVIDER;
  }



  /**
   * Get the "listen-address" property definition.
   * <p>
   * Specifies the address on which this JMX Connection Handler should
   * listen for connections from JMX clients.
   * <p>
   * If no value is provided, then the JMX Connection Handler listens
   * on all interfaces.
   *
   * @return Returns the "listen-address" property definition.
   */
  public IPAddressPropertyDefinition getListenAddressPropertyDefinition() {
    return PD_LISTEN_ADDRESS;
  }



  /**
   * Get the "listen-port" property definition.
   * <p>
   * Specifies the port number on which the JMX Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the "listen-port" property definition.
   */
  public IntegerPropertyDefinition getListenPortPropertyDefinition() {
    return PD_LISTEN_PORT;
  }



  /**
   * Get the "rmi-port" property definition.
   * <p>
   * Specifies the port number on which the JMX RMI service will
   * listen for connections from clients. A value of 0 indicates the
   * service to choose a port of its own.
   * <p>
   * If the value provided is different than 0, the value will be used
   * as the RMI port. Otherwise, the RMI service will choose a port of
   * its own.
   *
   * @return Returns the "rmi-port" property definition.
   */
  public IntegerPropertyDefinition getRmiPortPropertyDefinition() {
    return PD_RMI_PORT;
  }



  /**
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the JMX Connection Handler should use when
   * performing SSL communication. The property can be used multiple
   * times (referencing different nicknames) when server certificates
   * with different public key algorithms are used in parallel (for
   * example, RSA, DSA, and ECC-based algorithms). When a nickname
   * refers to an asymmetric (public/private) key pair, the nickname
   * for the public key certificate and associated private key entry
   * must match exactly. A single nickname is used to retrieve both the
   * public key and the private key.
   * <p>
   * This is only applicable when the JMX Connection Handler is
   * configured to use SSL.
   *
   * @return Returns the "ssl-cert-nickname" property definition.
   */
  public StringPropertyDefinition getSSLCertNicknamePropertyDefinition() {
    return PD_SSL_CERT_NICKNAME;
  }



  /**
   * Get the "use-ssl" property definition.
   * <p>
   * Indicates whether the JMX Connection Handler should use SSL.
   * <p>
   * If enabled, the JMX Connection Handler will use SSL to encrypt
   * communication with the clients.
   *
   * @return Returns the "use-ssl" property definition.
   */
  public BooleanPropertyDefinition getUseSSLPropertyDefinition() {
    return PD_USE_SSL;
  }



  /**
   * Managed object client implementation.
   */
  private static class JMXConnectionHandlerCfgClientImpl implements
    JMXConnectionHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends JMXConnectionHandlerCfgClient> impl;



    /** Private constructor. */
    private JMXConnectionHandlerCfgClientImpl(
        ManagedObject<? extends JMXConnectionHandlerCfgClient> impl) {
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
    public String getKeyManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public InetAddress getListenAddress() {
      return impl.getPropertyValue(INSTANCE.getListenAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setListenAddress(InetAddress value) {
      impl.setPropertyValue(INSTANCE.getListenAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getListenPort() {
      return impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setListenPort(int value) {
      impl.setPropertyValue(INSTANCE.getListenPortPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getRmiPort() {
      return impl.getPropertyValue(INSTANCE.getRmiPortPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRmiPort(Integer value) {
      impl.setPropertyValue(INSTANCE.getRmiPortPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCertNickname() {
      return impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLCertNickname(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isUseSSL() {
      return impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseSSL(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseSSLPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends JMXConnectionHandlerCfgClient, ? extends JMXConnectionHandlerCfg> definition() {
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
  private static class JMXConnectionHandlerCfgServerImpl implements
    JMXConnectionHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends JMXConnectionHandlerCfg> impl;

    /** The value of the "allowed-client" property. */
    private final SortedSet<AddressMask> pAllowedClient;

    /** The value of the "denied-client" property. */
    private final SortedSet<AddressMask> pDeniedClient;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "listen-address" property. */
    private final InetAddress pListenAddress;

    /** The value of the "listen-port" property. */
    private final int pListenPort;

    /** The value of the "rmi-port" property. */
    private final int pRmiPort;

    /** The value of the "ssl-cert-nickname" property. */
    private final SortedSet<String> pSSLCertNickname;

    /** The value of the "use-ssl" property. */
    private final boolean pUseSSL;



    /** Private constructor. */
    private JMXConnectionHandlerCfgServerImpl(ServerManagedObject<? extends JMXConnectionHandlerCfg> impl) {
      this.impl = impl;
      this.pAllowedClient = impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
      this.pDeniedClient = impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pListenAddress = impl.getPropertyValue(INSTANCE.getListenAddressPropertyDefinition());
      this.pListenPort = impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
      this.pRmiPort = impl.getPropertyValue(INSTANCE.getRmiPortPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pUseSSL = impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addJMXChangeListener(
        ConfigurationChangeListener<JMXConnectionHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeJMXChangeListener(
        ConfigurationChangeListener<JMXConnectionHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public String getKeyManagerProvider() {
      return pKeyManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getKeyManagerProviderDN() {
      String value = getKeyManagerProvider();
      if (value == null) return null;
      return INSTANCE.getKeyManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public InetAddress getListenAddress() {
      return pListenAddress;
    }



    /** {@inheritDoc} */
    public int getListenPort() {
      return pListenPort;
    }



    /** {@inheritDoc} */
    public int getRmiPort() {
      return pRmiPort;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCertNickname() {
      return pSSLCertNickname;
    }



    /** {@inheritDoc} */
    public boolean isUseSSL() {
      return pUseSSL;
    }



    /** {@inheritDoc} */
    public Class<? extends JMXConnectionHandlerCfg> configurationClass() {
      return JMXConnectionHandlerCfg.class;
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
