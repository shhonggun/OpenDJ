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
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.ReplicationServiceDiscoveryMechanismCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.ReplicationServiceDiscoveryMechanismCfg;
import org.forgerock.opendj.server.config.server.ServiceDiscoveryMechanismCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the Replication Service Discovery
 * Mechanism managed object definition meta information.
 * <p>
 * A Replication Service Discovery Mechanism returns the set of
 * directory servers participating in a replication topology.
 */
public final class ReplicationServiceDiscoveryMechanismCfgDefn extends ManagedObjectDefinition<ReplicationServiceDiscoveryMechanismCfgClient, ReplicationServiceDiscoveryMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final ReplicationServiceDiscoveryMechanismCfgDefn INSTANCE = new ReplicationServiceDiscoveryMechanismCfgDefn();



  /** The "bind-dn" property definition. */
  private static final DNPropertyDefinition PD_BIND_DN;



  /** The "bind-password" property definition. */
  private static final StringPropertyDefinition PD_BIND_PASSWORD;



  /** The "discovery-interval" property definition. */
  private static final DurationPropertyDefinition PD_DISCOVERY_INTERVAL;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "primary-group-id" property definition. */
  private static final IntegerPropertyDefinition PD_PRIMARY_GROUP_ID;



  /** The "replication-server" property definition. */
  private static final StringPropertyDefinition PD_REPLICATION_SERVER;



  /** Build the "bind-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "bind-dn");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "bind-dn"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<DN>());
      PD_BIND_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BIND_DN);
  }



  /** Build the "bind-password" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "bind-password");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "bind-password"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_BIND_PASSWORD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BIND_PASSWORD);
  }



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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.proxy.ReplicationServiceDiscoveryMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.backends.proxy.ServiceDiscoveryMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "primary-group-id" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "primary-group-id");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "primary-group-id"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "primary-group-id"));
      PD_PRIMARY_GROUP_ID = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PRIMARY_GROUP_ID);
  }



  /** Build the "replication-server" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "replication-server");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "replication-server"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^.+:[0-9]+$", "HOST:PORT");
      PD_REPLICATION_SERVER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REPLICATION_SERVER);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("service-discovery"));
  }



  /**
   * Get the Replication Service Discovery Mechanism configuration
   * definition singleton.
   *
   * @return Returns the Replication Service Discovery Mechanism
   *         configuration definition singleton.
   */
  public static ReplicationServiceDiscoveryMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ReplicationServiceDiscoveryMechanismCfgDefn() {
    super("replication-service-discovery-mechanism", ServiceDiscoveryMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ReplicationServiceDiscoveryMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends ReplicationServiceDiscoveryMechanismCfgClient> impl) {
    return new ReplicationServiceDiscoveryMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ReplicationServiceDiscoveryMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends ReplicationServiceDiscoveryMechanismCfg> impl) {
    return new ReplicationServiceDiscoveryMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ReplicationServiceDiscoveryMechanismCfg> getServerConfigurationClass() {
    return ReplicationServiceDiscoveryMechanismCfg.class;
  }



  /**
   * Get the "bind-dn" property definition.
   * <p>
   * The bind DN for periodically reading replication server
   * configurations
   * <p>
   * The bind DN must be present on all replication servers and
   * directory servers, it must be able to read the server
   * configuration.
   *
   * @return Returns the "bind-dn" property definition.
   */
  public DNPropertyDefinition getBindDNPropertyDefinition() {
    return PD_BIND_DN;
  }



  /**
   * Get the "bind-password" property definition.
   * <p>
   * The bind password for periodically reading replication server
   * configurations
   * <p>
   * The bind password must be the same on all replication and
   * directory servers
   *
   * @return Returns the "bind-password" property definition.
   */
  public StringPropertyDefinition getBindPasswordPropertyDefinition() {
    return PD_BIND_PASSWORD;
  }



  /**
   * Get the "discovery-interval" property definition.
   * <p>
   * Interval between two replication server configuration discovery
   * queries.
   * <p>
   * Specifies how frequently to query a replication server
   * configuration in order to discover information about available
   * directory server replicas.
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
   * provides the Replication Service Discovery Mechanism
   * implementation.
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
   * this Replication Service Discovery Mechanism.
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getKeyManagerProviderPropertyDefinition();
  }



  /**
   * Get the "primary-group-id" property definition.
   * <p>
   * Replication domain group ID of preferred directory server
   * replicas.
   * <p>
   * Directory server replicas with this replication domain group ID
   * will be preferred over other directory server replicas. Secondary
   * server replicas will only be used when all primary server replicas
   * become unavailable.
   *
   * @return Returns the "primary-group-id" property definition.
   */
  public IntegerPropertyDefinition getPrimaryGroupIdPropertyDefinition() {
    return PD_PRIMARY_GROUP_ID;
  }



  /**
   * Get the "replication-server" property definition.
   * <p>
   * Specifies the list of replication servers to contact periodically
   * when discovering server replicas.
   *
   * @return Returns the "replication-server" property definition.
   */
  public StringPropertyDefinition getReplicationServerPropertyDefinition() {
    return PD_REPLICATION_SERVER;
  }



  /**
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the Replication Service Discovery Mechanism should
   * use when performing SSL communication. The property can be used
   * multiple times (referencing different nicknames) when server
   * certificates with different public key algorithms are used in
   * parallel (for example, RSA, DSA, and ECC-based algorithms). When a
   * nickname refers to an asymmetric (public/private) key pair, the
   * nickname for the public key certificate and associated private key
   * entry must match exactly. A single nickname is used to retrieve
   * both the public key and the private key.
   * <p>
   * This is only applicable when the Replication Service Discovery
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
   * the Replication Service Discovery Mechanism.
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getTrustManagerProviderPropertyDefinition();
  }



  /**
   * Get the "use-ssl" property definition.
   * <p>
   * Indicates whether the Replication Service Discovery Mechanism
   * should use SSL.
   * <p>
   * If enabled, the Replication Service Discovery Mechanism will use
   * SSL to encrypt communication with the clients.
   *
   * @return Returns the "use-ssl" property definition.
   */
  public BooleanPropertyDefinition getUseSSLPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getUseSSLPropertyDefinition();
  }



  /**
   * Get the "use-start-tls" property definition.
   * <p>
   * Indicates whether the Replication Service Discovery Mechanism
   * should use Start TLS.
   * <p>
   * If enabled, the Replication Service Discovery Mechanism will use
   * Start TLS to encrypt communication with remote servers.
   *
   * @return Returns the "use-start-tls" property definition.
   */
  public BooleanPropertyDefinition getUseStartTLSPropertyDefinition() {
    return ServiceDiscoveryMechanismCfgDefn.getInstance().getUseStartTLSPropertyDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class ReplicationServiceDiscoveryMechanismCfgClientImpl implements
    ReplicationServiceDiscoveryMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ReplicationServiceDiscoveryMechanismCfgClient> impl;



    /** Private constructor. */
    private ReplicationServiceDiscoveryMechanismCfgClientImpl(
        ManagedObject<? extends ReplicationServiceDiscoveryMechanismCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public DN getBindDN() {
      return impl.getPropertyValue(INSTANCE.getBindDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBindDN(DN value) {
      impl.setPropertyValue(INSTANCE.getBindDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getBindPassword() {
      return impl.getPropertyValue(INSTANCE.getBindPasswordPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBindPassword(String value) {
      impl.setPropertyValue(INSTANCE.getBindPasswordPropertyDefinition(), value);
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
    public Integer getPrimaryGroupId() {
      return impl.getPropertyValue(INSTANCE.getPrimaryGroupIdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPrimaryGroupId(Integer value) {
      impl.setPropertyValue(INSTANCE.getPrimaryGroupIdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getReplicationServer() {
      return impl.getPropertyValues(INSTANCE.getReplicationServerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setReplicationServer(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getReplicationServerPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends ReplicationServiceDiscoveryMechanismCfgClient, ? extends ReplicationServiceDiscoveryMechanismCfg> definition() {
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
  private static class ReplicationServiceDiscoveryMechanismCfgServerImpl implements
    ReplicationServiceDiscoveryMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ReplicationServiceDiscoveryMechanismCfg> impl;

    /** The value of the "bind-dn" property. */
    private final DN pBindDN;

    /** The value of the "bind-password" property. */
    private final String pBindPassword;

    /** The value of the "discovery-interval" property. */
    private final long pDiscoveryInterval;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "primary-group-id" property. */
    private final Integer pPrimaryGroupId;

    /** The value of the "replication-server" property. */
    private final SortedSet<String> pReplicationServer;

    /** The value of the "ssl-cert-nickname" property. */
    private final SortedSet<String> pSSLCertNickname;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;

    /** The value of the "use-ssl" property. */
    private final boolean pUseSSL;

    /** The value of the "use-start-tls" property. */
    private final boolean pUseStartTLS;



    /** Private constructor. */
    private ReplicationServiceDiscoveryMechanismCfgServerImpl(ServerManagedObject<? extends ReplicationServiceDiscoveryMechanismCfg> impl) {
      this.impl = impl;
      this.pBindDN = impl.getPropertyValue(INSTANCE.getBindDNPropertyDefinition());
      this.pBindPassword = impl.getPropertyValue(INSTANCE.getBindPasswordPropertyDefinition());
      this.pDiscoveryInterval = impl.getPropertyValue(INSTANCE.getDiscoveryIntervalPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pPrimaryGroupId = impl.getPropertyValue(INSTANCE.getPrimaryGroupIdPropertyDefinition());
      this.pReplicationServer = impl.getPropertyValues(INSTANCE.getReplicationServerPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
      this.pUseSSL = impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
      this.pUseStartTLS = impl.getPropertyValue(INSTANCE.getUseStartTLSPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addReplicationChangeListener(
        ConfigurationChangeListener<ReplicationServiceDiscoveryMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationChangeListener(
        ConfigurationChangeListener<ReplicationServiceDiscoveryMechanismCfg> listener) {
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
    public DN getBindDN() {
      return pBindDN;
    }



    /** {@inheritDoc} */
    public String getBindPassword() {
      return pBindPassword;
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
    public Integer getPrimaryGroupId() {
      return pPrimaryGroupId;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getReplicationServer() {
      return pReplicationServer;
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
    public Class<? extends ReplicationServiceDiscoveryMechanismCfg> configurationClass() {
      return ReplicationServiceDiscoveryMechanismCfg.class;
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
