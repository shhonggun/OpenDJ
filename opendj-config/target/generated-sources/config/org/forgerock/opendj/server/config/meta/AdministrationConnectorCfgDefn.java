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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.IPAddressPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
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
import org.forgerock.opendj.server.config.client.AdministrationConnectorCfgClient;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.AdministrationConnectorCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the Administration Connector managed
 * object definition meta information.
 * <p>
 * The Administration Connector is used to interact with
 * administration tools using LDAP.
 */
public final class AdministrationConnectorCfgDefn extends ManagedObjectDefinition<AdministrationConnectorCfgClient, AdministrationConnectorCfg> {

  /** The singleton configuration definition instance. */
  private static final AdministrationConnectorCfgDefn INSTANCE = new AdministrationConnectorCfgDefn();



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "listen-address" property definition. */
  private static final IPAddressPropertyDefinition PD_LISTEN_ADDRESS;



  /** The "listen-port" property definition. */
  private static final IntegerPropertyDefinition PD_LISTEN_PORT;



  /** The "ssl-cert-nickname" property definition. */
  private static final StringPropertyDefinition PD_SSL_CERT_NICKNAME;



  /** The "ssl-cipher-suite" property definition. */
  private static final StringPropertyDefinition PD_SSL_CIPHER_SUITE;



  /** The "ssl-protocol" property definition. */
  private static final StringPropertyDefinition PD_SSL_PROTOCOL;



  /** The "trust-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> PD_TRUST_MANAGER_PROVIDER;



  /** Build the "key-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<KeyManagerProviderCfgClient, KeyManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "key-manager-provider");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "key-manager-provider"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("key-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_KEY_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_KEY_MANAGER_PROVIDER.getSourceConstraint());
  }



  /** Build the "listen-address" property definition. */
  static {
      IPAddressPropertyDefinition.Builder builder = IPAddressPropertyDefinition.createBuilder(INSTANCE, "listen-address");
      builder.setOption(PropertyOption.MULTI_VALUED);
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



  /** Build the "ssl-cert-nickname" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cert-nickname");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "ssl-cert-nickname"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-cert-nickname"));
      PD_SSL_CERT_NICKNAME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CERT_NICKNAME);
  }



  /** Build the "ssl-cipher-suite" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cipher-suite");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-cipher-suite"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-cipher-suite"));
      PD_SSL_CIPHER_SUITE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CIPHER_SUITE);
  }



  /** Build the "ssl-protocol" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-protocol");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-protocol"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-protocol"));
      PD_SSL_PROTOCOL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_PROTOCOL);
  }



  /** Build the "trust-manager-provider" property definition. */
  static {
      AggregationPropertyDefinition.Builder<TrustManagerProviderCfgClient, TrustManagerProviderCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "trust-manager-provider");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "trust-manager-provider"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "trust-manager-provider"));
      builder.setParentPath("/");
      builder.setRelationDefinition("trust-manager-provider");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_TRUST_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_TRUST_MANAGER_PROVIDER.getSourceConstraint());
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Administration Connector configuration definition
   * singleton.
   *
   * @return Returns the Administration Connector configuration
   *         definition singleton.
   */
  public static AdministrationConnectorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private AdministrationConnectorCfgDefn() {
    super("administration-connector", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public AdministrationConnectorCfgClient createClientConfiguration(
      ManagedObject<? extends AdministrationConnectorCfgClient> impl) {
    return new AdministrationConnectorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public AdministrationConnectorCfg createServerConfiguration(
      ServerManagedObject<? extends AdministrationConnectorCfg> impl) {
    return new AdministrationConnectorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<AdministrationConnectorCfg> getServerConfigurationClass() {
    return AdministrationConnectorCfg.class;
  }



  /**
   * Get the "key-manager-provider" property definition.
   * <p>
   * Specifies the name of the key manager that is used with the
   * Administration Connector .
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return PD_KEY_MANAGER_PROVIDER;
  }



  /**
   * Get the "listen-address" property definition.
   * <p>
   * Specifies the address or set of addresses on which this
   * Administration Connector should listen for connections from LDAP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the Administration
   * Connector listens on all interfaces.
   *
   * @return Returns the "listen-address" property definition.
   */
  public IPAddressPropertyDefinition getListenAddressPropertyDefinition() {
    return PD_LISTEN_ADDRESS;
  }



  /**
   * Get the "listen-port" property definition.
   * <p>
   * Specifies the port number on which the Administration Connector
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
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the Administration Connector should use when
   * performing SSL communication. The property can be used multiple
   * times (referencing different nicknames) when server certificates
   * with different public key algorithms are used in parallel (for
   * example, RSA, DSA, and ECC-based algorithms). When a nickname
   * refers to an asymmetric (public/private) key pair, the nickname
   * for the public key certificate and associated private key entry
   * must match exactly. A single nickname is used to retrieve both the
   * public key and the private key.
   *
   * @return Returns the "ssl-cert-nickname" property definition.
   */
  public StringPropertyDefinition getSSLCertNicknamePropertyDefinition() {
    return PD_SSL_CERT_NICKNAME;
  }



  /**
   * Get the "ssl-cipher-suite" property definition.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL communication.
   *
   * @return Returns the "ssl-cipher-suite" property definition.
   */
  public StringPropertyDefinition getSSLCipherSuitePropertyDefinition() {
    return PD_SSL_CIPHER_SUITE;
  }



  /**
   * Get the "ssl-protocol" property definition.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL or StartTLS communication.
   *
   * @return Returns the "ssl-protocol" property definition.
   */
  public StringPropertyDefinition getSSLProtocolPropertyDefinition() {
    return PD_SSL_PROTOCOL;
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that is used with the
   * Administration Connector .
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return PD_TRUST_MANAGER_PROVIDER;
  }



  /**
   * Managed object client implementation.
   */
  private static class AdministrationConnectorCfgClientImpl implements
    AdministrationConnectorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends AdministrationConnectorCfgClient> impl;



    /** Private constructor. */
    private AdministrationConnectorCfgClientImpl(
        ManagedObject<? extends AdministrationConnectorCfgClient> impl) {
      this.impl = impl;
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
    public SortedSet<InetAddress> getListenAddress() {
      return impl.getPropertyValues(INSTANCE.getListenAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setListenAddress(Collection<InetAddress> values) {
      impl.setPropertyValues(INSTANCE.getListenAddressPropertyDefinition(), values);
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
    public SortedSet<String> getSSLCertNickname() {
      return impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLCertNickname(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCipherSuite() {
      return impl.getPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLCipherSuite(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLProtocol() {
      return impl.getPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLProtocol(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends AdministrationConnectorCfgClient, ? extends AdministrationConnectorCfg> definition() {
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
  private static class AdministrationConnectorCfgServerImpl implements
    AdministrationConnectorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends AdministrationConnectorCfg> impl;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "listen-address" property. */
    private final SortedSet<InetAddress> pListenAddress;

    /** The value of the "listen-port" property. */
    private final int pListenPort;

    /** The value of the "ssl-cert-nickname" property. */
    private final SortedSet<String> pSSLCertNickname;

    /** The value of the "ssl-cipher-suite" property. */
    private final SortedSet<String> pSSLCipherSuite;

    /** The value of the "ssl-protocol" property. */
    private final SortedSet<String> pSSLProtocol;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;



    /** Private constructor. */
    private AdministrationConnectorCfgServerImpl(ServerManagedObject<? extends AdministrationConnectorCfg> impl) {
      this.impl = impl;
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pListenAddress = impl.getPropertyValues(INSTANCE.getListenAddressPropertyDefinition());
      this.pListenPort = impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pSSLCipherSuite = impl.getPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition());
      this.pSSLProtocol = impl.getPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AdministrationConnectorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AdministrationConnectorCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public SortedSet<InetAddress> getListenAddress() {
      return pListenAddress;
    }



    /** {@inheritDoc} */
    public int getListenPort() {
      return pListenPort;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCertNickname() {
      return pSSLCertNickname;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCipherSuite() {
      return pSSLCipherSuite;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLProtocol() {
      return pSSLProtocol;
    }



    /** {@inheritDoc} */
    public String getTrustManagerProvider() {
      return pTrustManagerProvider;
    }



    /**
     * {@inheritDoc}
     */
    public DN getTrustManagerProviderDN() {
      String value = getTrustManagerProvider();
      if (value == null) return null;
      return INSTANCE.getTrustManagerProviderPropertyDefinition().getChildDN(value);
    }



    /** {@inheritDoc} */
    public Class<? extends AdministrationConnectorCfg> configurationClass() {
      return AdministrationConnectorCfg.class;
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
