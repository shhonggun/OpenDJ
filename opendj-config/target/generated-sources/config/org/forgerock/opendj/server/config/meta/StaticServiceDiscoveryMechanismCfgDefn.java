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
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.StaticServiceDiscoveryMechanismCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.ServiceDiscoveryMechanismCfg;
import org.forgerock.opendj.server.config.server.StaticServiceDiscoveryMechanismCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the Static Service Discovery Mechanism
 * managed object definition meta information.
 * <p>
 * A Static Service Discovery Mechanism returns a fixed list of LDAP
 * directory servers.
 */
public final class StaticServiceDiscoveryMechanismCfgDefn extends ManagedObjectDefinition<StaticServiceDiscoveryMechanismCfgClient, StaticServiceDiscoveryMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final StaticServiceDiscoveryMechanismCfgDefn INSTANCE = new StaticServiceDiscoveryMechanismCfgDefn();



  /** The "discovery-interval" property definition. */
  private static final DurationPropertyDefinition PD_DISCOVERY_INTERVAL;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "primary-server" property definition. */
  private static final StringPropertyDefinition PD_PRIMARY_SERVER;



  /** The "secondary-server" property definition. */
  private static final StringPropertyDefinition PD_SECONDARY_SERVER;



  /** Build the "discovery-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "discovery-interval");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "discovery-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("60s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setLowerLimit("1s");
      PD_DISCOVERY_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISCOVERY_INTERVAL);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.proxy.StaticServiceDiscoveryMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.backends.proxy.ServiceDiscoveryMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "primary-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "primary-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "primary-server"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^.+:[0-9]+$", "HOST:PORT");
      PD_PRIMARY_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PRIMARY_SERVER);
  }



  /** Build the "secondary-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "secondary-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "secondary-server"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^.+:[0-9]+$", "HOST:PORT");
      PD_SECONDARY_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SECONDARY_SERVER);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("service-discovery"));
  }



  /**
   * Get the Static Service Discovery Mechanism configuration
   * definition singleton.
   *
   * @return Returns the Static Service Discovery Mechanism
   *         configuration definition singleton.
   */
  public static StaticServiceDiscoveryMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private StaticServiceDiscoveryMechanismCfgDefn() {
    super("static-service-discovery-mechanism", ServiceDiscoveryMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public StaticServiceDiscoveryMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends StaticServiceDiscoveryMechanismCfgClient> impl) {
    return new StaticServiceDiscoveryMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public StaticServiceDiscoveryMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends StaticServiceDiscoveryMechanismCfg> impl) {
    return new StaticServiceDiscoveryMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<StaticServiceDiscoveryMechanismCfg> getServerConfigurationClass() {
    return StaticServiceDiscoveryMechanismCfg.class;
  }



  /**
   * Get the "discovery-interval" property definition.
   * <p>
   * Interval between two server configuration discovery executions.
   * <p>
   * Specifies how frequently to read the configuration of the servers
   * in order to discover their new information.
   *
   * @return Returns the "discovery-interval" property definition.
   */
  public DurationPropertyDefinition getDiscoveryIntervalPropertyDefinition() {
    return PD_DISCOVERY_INTERVAL;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Static Service Discovery Mechanism implementation.
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
   * this Static Service Discovery Mechanism.
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getKeyManagerProviderPropertyDefinition();
  }



  /**
   * Get the "primary-server" property definition.
   * <p>
   * Specifies a list of servers that will be used in preference to
   * secondary servers when available.
   *
   * @return Returns the "primary-server" property definition.
   */
  public StringPropertyDefinition getPrimaryServerPropertyDefinition() {
    return PD_PRIMARY_SERVER;
  }



  /**
   * Get the "secondary-server" property definition.
   * <p>
   * Specifies a list of servers that will be used in place of primary
   * servers when all primary servers are unavailable.
   *
   * @return Returns the "secondary-server" property definition.
   */
  public StringPropertyDefinition getSecondaryServerPropertyDefinition() {
    return PD_SECONDARY_SERVER;
  }



  /**
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the Static Service Discovery Mechanism should use
   * when performing SSL communication. The property can be used
   * multiple times (referencing different nicknames) when server
   * certificates with different public key algorithms are used in
   * parallel (for example, RSA, DSA, and ECC-based algorithms). When a
   * nickname refers to an asymmetric (public/private) key pair, the
   * nickname for the public key certificate and associated private key
   * entry must match exactly. A single nickname is used to retrieve
   * both the public key and the private key.
   * <p>
   * This is only applicable when the Static Service Discovery
   * Mechanism is configured to use SSL.
   *
   * @return Returns the "ssl-cert-nickname" property definition.
   */
  public StringPropertyDefinition getSSLCertNicknamePropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getSSLCertNicknamePropertyDefinition();
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Static Service Discovery Mechanism.
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getTrustManagerProviderPropertyDefinition();
  }



  /**
   * Get the "use-ssl" property definition.
   * <p>
   * Indicates whether the Static Service Discovery Mechanism should
   * use SSL.
   * <p>
   * If enabled, the Static Service Discovery Mechanism will use SSL
   * to encrypt communication with the clients.
   *
   * @return Returns the "use-ssl" property definition.
   */
  public BooleanPropertyDefinition getUseSSLPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getUseSSLPropertyDefinition();
  }



  /**
   * Get the "use-start-tls" property definition.
   * <p>
   * Indicates whether the Static Service Discovery Mechanism should
   * use Start TLS.
   * <p>
   * If enabled, the Static Service Discovery Mechanism will use Start
   * TLS to encrypt communication with remote servers.
   *
   * @return Returns the "use-start-tls" property definition.
   */
  public BooleanPropertyDefinition getUseStartTLSPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getUseStartTLSPropertyDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class StaticServiceDiscoveryMechanismCfgClientImpl implements
    StaticServiceDiscoveryMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends StaticServiceDiscoveryMechanismCfgClient> impl;



    /** Private constructor. */
    private StaticServiceDiscoveryMechanismCfgClientImpl(
        ManagedObject<? extends StaticServiceDiscoveryMechanismCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public long getDiscoveryInterval() {
      return impl.getPropertyValue(INSTANCE.getDiscoveryIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDiscoveryInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getDiscoveryIntervalPropertyDefinition(), value);
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
    public SortedSet<String> getPrimaryServer() {
      return impl.getPropertyValues(INSTANCE.getPrimaryServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPrimaryServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getPrimaryServerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSecondaryServer() {
      return impl.getPropertyValues(INSTANCE.getSecondaryServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSecondaryServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getSecondaryServerPropertyDefinition(), values);
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
    public String getTrustManagerProvider() {
      return impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrustManagerProvider(String value) {
      impl.setPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition(), value);
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
    public boolean isUseStartTLS() {
      return impl.getPropertyValue(INSTANCE.getUseStartTLSPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseStartTLS(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseStartTLSPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends StaticServiceDiscoveryMechanismCfgClient, ? extends StaticServiceDiscoveryMechanismCfg> definition() {
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
  private static class StaticServiceDiscoveryMechanismCfgServerImpl implements
    StaticServiceDiscoveryMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends StaticServiceDiscoveryMechanismCfg> impl;

    /** The value of the "discovery-interval" property. */
    private final long pDiscoveryInterval;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "primary-server" property. */
    private final SortedSet<String> pPrimaryServer;

    /** The value of the "secondary-server" property. */
    private final SortedSet<String> pSecondaryServer;

    /** The value of the "ssl-cert-nickname" property. */
    private final SortedSet<String> pSSLCertNickname;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;

    /** The value of the "use-ssl" property. */
    private final boolean pUseSSL;

    /** The value of the "use-start-tls" property. */
    private final boolean pUseStartTLS;



    /** Private constructor. */
    private StaticServiceDiscoveryMechanismCfgServerImpl(ServerManagedObject<? extends StaticServiceDiscoveryMechanismCfg> impl) {
      this.impl = impl;
      this.pDiscoveryInterval = impl.getPropertyValue(INSTANCE.getDiscoveryIntervalPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pPrimaryServer = impl.getPropertyValues(INSTANCE.getPrimaryServerPropertyDefinition());
      this.pSecondaryServer = impl.getPropertyValues(INSTANCE.getSecondaryServerPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
      this.pUseSSL = impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
      this.pUseStartTLS = impl.getPropertyValue(INSTANCE.getUseStartTLSPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addStaticChangeListener(
        ConfigurationChangeListener<StaticServiceDiscoveryMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeStaticChangeListener(
        ConfigurationChangeListener<StaticServiceDiscoveryMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ServiceDiscoveryMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ServiceDiscoveryMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public long getDiscoveryInterval() {
      return pDiscoveryInterval;
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
    public SortedSet<String> getPrimaryServer() {
      return pPrimaryServer;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSecondaryServer() {
      return pSecondaryServer;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getSSLCertNickname() {
      return pSSLCertNickname;
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
    public boolean isUseSSL() {
      return pUseSSL;
    }



    /** {@inheritDoc} */
    public boolean isUseStartTLS() {
      return pUseStartTLS;
    }



    /** {@inheritDoc} */
    public Class<? extends StaticServiceDiscoveryMechanismCfg> configurationClass() {
      return StaticServiceDiscoveryMechanismCfg.class;
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
