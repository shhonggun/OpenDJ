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
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.HTTPConnectionHandlerCfgClient;
import org.forgerock.opendj.server.config.client.KeyManagerProviderCfgClient;
import org.forgerock.opendj.server.config.client.TrustManagerProviderCfgClient;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.HTTPConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;



/**
 * An interface for querying the HTTP Connection Handler managed
 * object definition meta information.
 * <p>
 * HTTP Connection Handlers provide HTTP services built on top of the
 * underlying LDAP directory.
 */
public final class HTTPConnectionHandlerCfgDefn extends ManagedObjectDefinition<HTTPConnectionHandlerCfgClient, HTTPConnectionHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPConnectionHandlerCfgDefn INSTANCE = new HTTPConnectionHandlerCfgDefn();



  /**
   * Defines the set of permissable values for the "ssl-client-auth-policy" property.
   * <p>
   * Specifies the policy that the HTTP Connection Handler should use
   * regarding client SSL certificates. Clients can use the SASL
   * EXTERNAL mechanism only if the policy is set to "optional" or
   * "required".
   * <p>
   * This is only applicable if clients are allowed to use SSL.
   */
  public static enum SSLClientAuthPolicy {

    /**
     * Clients must not provide their own certificates when performing
     * SSL negotiation.
     */
    DISABLED("disabled"),



    /**
     * Clients are requested to provide their own certificates when
     * performing SSL negotiation. The connection is nevertheless
     * accepted if the client does not provide a certificate.
     */
    OPTIONAL("optional"),



    /**
     * Clients are required to provide their own certificates when
     * performing SSL negotiation and are refused access if they do not
     * provide a certificate.
     */
    REQUIRED("required");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private SSLClientAuthPolicy(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "accept-backlog" property definition. */
  private static final IntegerPropertyDefinition PD_ACCEPT_BACKLOG;



  /** The "allow-tcp-reuse-address" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_TCP_REUSE_ADDRESS;



  /** The "buffer-size" property definition. */
  private static final SizePropertyDefinition PD_BUFFER_SIZE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "keep-stats" property definition. */
  private static final BooleanPropertyDefinition PD_KEEP_STATS;



  /** The "key-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> PD_KEY_MANAGER_PROVIDER;



  /** The "listen-address" property definition. */
  private static final IPAddressPropertyDefinition PD_LISTEN_ADDRESS;



  /** The "listen-port" property definition. */
  private static final IntegerPropertyDefinition PD_LISTEN_PORT;



  /** The "max-blocked-write-time-limit" property definition. */
  private static final DurationPropertyDefinition PD_MAX_BLOCKED_WRITE_TIME_LIMIT;



  /** The "max-concurrent-ops-per-connection" property definition. */
  private static final IntegerPropertyDefinition PD_MAX_CONCURRENT_OPS_PER_CONNECTION;



  /** The "max-request-size" property definition. */
  private static final SizePropertyDefinition PD_MAX_REQUEST_SIZE;



  /** The "num-request-handlers" property definition. */
  private static final IntegerPropertyDefinition PD_NUM_REQUEST_HANDLERS;



  /** The "ssl-cert-nickname" property definition. */
  private static final StringPropertyDefinition PD_SSL_CERT_NICKNAME;



  /** The "ssl-cipher-suite" property definition. */
  private static final StringPropertyDefinition PD_SSL_CIPHER_SUITE;



  /** The "ssl-client-auth-policy" property definition. */
  private static final EnumPropertyDefinition<SSLClientAuthPolicy> PD_SSL_CLIENT_AUTH_POLICY;



  /** The "ssl-protocol" property definition. */
  private static final StringPropertyDefinition PD_SSL_PROTOCOL;



  /** The "trust-manager-provider" property definition. */
  private static final AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> PD_TRUST_MANAGER_PROVIDER;



  /** The "use-ssl" property definition. */
  private static final BooleanPropertyDefinition PD_USE_SSL;



  /** The "use-tcp-keep-alive" property definition. */
  private static final BooleanPropertyDefinition PD_USE_TCP_KEEP_ALIVE;



  /** The "use-tcp-no-delay" property definition. */
  private static final BooleanPropertyDefinition PD_USE_TCP_NO_DELAY;



  /** Build the "accept-backlog" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "accept-backlog");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "accept-backlog"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("128");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(1);
      PD_ACCEPT_BACKLOG = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ACCEPT_BACKLOG);
  }



  /** Build the "allow-tcp-reuse-address" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-tcp-reuse-address");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "allow-tcp-reuse-address"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOW_TCP_REUSE_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_TCP_REUSE_ADDRESS);
  }



  /** Build the "buffer-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "buffer-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "buffer-size"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("4096 bytes");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("2147483647b");
      builder.setLowerLimit("1b");
      PD_BUFFER_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BUFFER_SIZE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.HTTPConnectionHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.ConnectionHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "keep-stats" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "keep-stats");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "keep-stats"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_KEEP_STATS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEEP_STATS);
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
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "listen-address"));
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



  /** Build the "max-blocked-write-time-limit" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "max-blocked-write-time-limit");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-blocked-write-time-limit"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("2 minutes");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("0");
      PD_MAX_BLOCKED_WRITE_TIME_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_BLOCKED_WRITE_TIME_LIMIT);
  }



  /** Build the "max-concurrent-ops-per-connection" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "max-concurrent-ops-per-connection");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-concurrent-ops-per-connection"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "max-concurrent-ops-per-connection"));
      builder.setLowerLimit(0);
      PD_MAX_CONCURRENT_OPS_PER_CONNECTION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_CONCURRENT_OPS_PER_CONNECTION);
  }



  /** Build the "max-request-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "max-request-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-request-size"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("5 megabytes");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("2147483647b");
      PD_MAX_REQUEST_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_REQUEST_SIZE);
  }



  /** Build the "num-request-handlers" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "num-request-handlers");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "num-request-handlers"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "num-request-handlers"));
      builder.setLowerLimit(1);
      PD_NUM_REQUEST_HANDLERS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NUM_REQUEST_HANDLERS);
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



  /** Build the "ssl-cipher-suite" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ssl-cipher-suite");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ssl-cipher-suite"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "ssl-cipher-suite"));
      PD_SSL_CIPHER_SUITE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CIPHER_SUITE);
  }



  /** Build the "ssl-client-auth-policy" property definition. */
  static {
      EnumPropertyDefinition.Builder<SSLClientAuthPolicy> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "ssl-client-auth-policy");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "ssl-client-auth-policy"));
      DefaultBehaviorProvider<SSLClientAuthPolicy> provider = new DefinedDefaultBehaviorProvider<SSLClientAuthPolicy>("optional");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(SSLClientAuthPolicy.class);
      PD_SSL_CLIENT_AUTH_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SSL_CLIENT_AUTH_POLICY);
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
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "trust-manager-provider"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "trust-manager-provider"));
      builder.setParentPath("/");
      builder.setRelationDefinition("trust-manager-provider");
      builder.setTargetNeedsEnablingCondition(Conditions.and(Conditions.contains("enabled", "true"), Conditions.contains("use-ssl", "true")));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_TRUST_MANAGER_PROVIDER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRUST_MANAGER_PROVIDER);
      INSTANCE.registerConstraint(PD_TRUST_MANAGER_PROVIDER.getSourceConstraint());
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



  /** Build the "use-tcp-keep-alive" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-tcp-keep-alive");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "use-tcp-keep-alive"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_TCP_KEEP_ALIVE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_TCP_KEEP_ALIVE);
  }



  /** Build the "use-tcp-no-delay" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "use-tcp-no-delay");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "use-tcp-no-delay"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_USE_TCP_NO_DELAY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USE_TCP_NO_DELAY);
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
   * Get the HTTP Connection Handler configuration definition
   * singleton.
   *
   * @return Returns the HTTP Connection Handler configuration
   *         definition singleton.
   */
  public static HTTPConnectionHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPConnectionHandlerCfgDefn() {
    super("http-connection-handler", ConnectionHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPConnectionHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPConnectionHandlerCfgClient> impl) {
    return new HTTPConnectionHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPConnectionHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPConnectionHandlerCfg> impl) {
    return new HTTPConnectionHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPConnectionHandlerCfg> getServerConfigurationClass() {
    return HTTPConnectionHandlerCfg.class;
  }



  /**
   * Get the "accept-backlog" property definition.
   * <p>
   * Specifies the maximum number of pending connection attempts that
   * are allowed to queue up in the accept backlog before the server
   * starts rejecting new connection attempts.
   * <p>
   * This is primarily an issue for cases in which a large number of
   * connections are established to the server in a very short period
   * of time (for example, a benchmark utility that creates a large
   * number of client threads that each have their own connection to
   * the server) and the connection handler is unable to keep up with
   * the rate at which the new connections are established.
   *
   * @return Returns the "accept-backlog" property definition.
   */
  public IntegerPropertyDefinition getAcceptBacklogPropertyDefinition() {
    return PD_ACCEPT_BACKLOG;
  }



  /**
   * Get the "allowed-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this HTTP
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
   * Get the "allow-tcp-reuse-address" property definition.
   * <p>
   * Indicates whether the HTTP Connection Handler should reuse socket
   * descriptors.
   * <p>
   * If enabled, the SO_REUSEADDR socket option is used on the server
   * listen socket to potentially allow the reuse of socket descriptors
   * for clients in a TIME_WAIT state. This may help the server avoid
   * temporarily running out of socket descriptors in cases in which a
   * very large number of short-lived connections have been established
   * from the same client system.
   *
   * @return Returns the "allow-tcp-reuse-address" property definition.
   */
  public BooleanPropertyDefinition getAllowTCPReuseAddressPropertyDefinition() {
    return PD_ALLOW_TCP_REUSE_ADDRESS;
  }



  /**
   * Get the "buffer-size" property definition.
   * <p>
   * Specifies the size in bytes of the HTTP response message write
   * buffer.
   * <p>
   * This property specifies write buffer size allocated by the server
   * for each client connection and used to buffer HTTP response
   * messages data when writing.
   *
   * @return Returns the "buffer-size" property definition.
   */
  public SizePropertyDefinition getBufferSizePropertyDefinition() {
    return PD_BUFFER_SIZE;
  }



  /**
   * Get the "denied-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this HTTP
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
   * Indicates whether the HTTP Connection Handler is enabled.
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
   * provides the HTTP Connection Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "keep-stats" property definition.
   * <p>
   * Indicates whether the HTTP Connection Handler should keep
   * statistics.
   * <p>
   * If enabled, the HTTP Connection Handler maintains statistics
   * about the number and types of operations requested over HTTP and
   * the amount of data sent and received.
   *
   * @return Returns the "keep-stats" property definition.
   */
  public BooleanPropertyDefinition getKeepStatsPropertyDefinition() {
    return PD_KEEP_STATS;
  }



  /**
   * Get the "key-manager-provider" property definition.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Connection Handler .
   *
   * @return Returns the "key-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<KeyManagerProviderCfgClient, KeyManagerProviderCfg> getKeyManagerProviderPropertyDefinition() {
    return PD_KEY_MANAGER_PROVIDER;
  }



  /**
   * Get the "listen-address" property definition.
   * <p>
   * Specifies the address or set of addresses on which this HTTP
   * Connection Handler should listen for connections from HTTP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the HTTP Connection
   * Handler listens on all interfaces.
   *
   * @return Returns the "listen-address" property definition.
   */
  public IPAddressPropertyDefinition getListenAddressPropertyDefinition() {
    return PD_LISTEN_ADDRESS;
  }



  /**
   * Get the "listen-port" property definition.
   * <p>
   * Specifies the port number on which the HTTP Connection Handler
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
   * Get the "max-blocked-write-time-limit" property definition.
   * <p>
   * Specifies the maximum length of time that attempts to write data
   * to HTTP clients should be allowed to block.
   * <p>
   * If an attempt to write data to a client takes longer than this
   * length of time, then the client connection is terminated.
   *
   * @return Returns the "max-blocked-write-time-limit" property definition.
   */
  public DurationPropertyDefinition getMaxBlockedWriteTimeLimitPropertyDefinition() {
    return PD_MAX_BLOCKED_WRITE_TIME_LIMIT;
  }



  /**
   * Get the "max-concurrent-ops-per-connection" property definition.
   * <p>
   * Specifies the maximum number of internal operations that each
   * HTTP client connection can execute concurrently.
   * <p>
   * This property allow to limit the impact that each HTTP request
   * can have on the whole server by limiting the number of internal
   * operations that each HTTP request can execute concurrently. A
   * value of 0 means that no limit is enforced.
   *
   * @return Returns the "max-concurrent-ops-per-connection" property definition.
   */
  public IntegerPropertyDefinition getMaxConcurrentOpsPerConnectionPropertyDefinition() {
    return PD_MAX_CONCURRENT_OPS_PER_CONNECTION;
  }



  /**
   * Get the "max-request-size" property definition.
   * <p>
   * Specifies the size in bytes of the largest HTTP request message
   * that will be allowed by the HTTP Connection Handler.
   * <p>
   * This can help prevent denial-of-service attacks by clients that
   * indicate they send extremely large requests to the server causing
   * it to attempt to allocate large amounts of memory.
   *
   * @return Returns the "max-request-size" property definition.
   */
  public SizePropertyDefinition getMaxRequestSizePropertyDefinition() {
    return PD_MAX_REQUEST_SIZE;
  }



  /**
   * Get the "num-request-handlers" property definition.
   * <p>
   * Specifies the number of request handlers that are used to read
   * requests from clients.
   * <p>
   * The HTTP Connection Handler uses one thread to accept new
   * connections from clients, but uses one or more additional threads
   * to read requests from existing client connections. This ensures
   * that new requests are read efficiently and that the connection
   * handler itself does not become a bottleneck when the server is
   * under heavy load from many clients at the same time.
   *
   * @return Returns the "num-request-handlers" property definition.
   */
  public IntegerPropertyDefinition getNumRequestHandlersPropertyDefinition() {
    return PD_NUM_REQUEST_HANDLERS;
  }



  /**
   * Get the "ssl-cert-nickname" property definition.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the HTTP Connection Handler should use when
   * performing SSL communication. The property can be used multiple
   * times (referencing different nicknames) when server certificates
   * with different public key algorithms are used in parallel (for
   * example, RSA, DSA, and ECC-based algorithms). When a nickname
   * refers to an asymmetric (public/private) key pair, the nickname
   * for the public key certificate and associated private key entry
   * must match exactly. A single nickname is used to retrieve both the
   * public key and the private key.
   * <p>
   * This is only applicable when the HTTP Connection Handler is
   * configured to use SSL.
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
   * Get the "ssl-client-auth-policy" property definition.
   * <p>
   * Specifies the policy that the HTTP Connection Handler should use
   * regarding client SSL certificates. Clients can use the SASL
   * EXTERNAL mechanism only if the policy is set to "optional" or
   * "required".
   * <p>
   * This is only applicable if clients are allowed to use SSL.
   *
   * @return Returns the "ssl-client-auth-policy" property definition.
   */
  public EnumPropertyDefinition<SSLClientAuthPolicy> getSSLClientAuthPolicyPropertyDefinition() {
    return PD_SSL_CLIENT_AUTH_POLICY;
  }



  /**
   * Get the "ssl-protocol" property definition.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL communication.
   *
   * @return Returns the "ssl-protocol" property definition.
   */
  public StringPropertyDefinition getSSLProtocolPropertyDefinition() {
    return PD_SSL_PROTOCOL;
  }



  /**
   * Get the "trust-manager-provider" property definition.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the HTTP Connection Handler .
   *
   * @return Returns the "trust-manager-provider" property definition.
   */
  public AggregationPropertyDefinition<TrustManagerProviderCfgClient, TrustManagerProviderCfg> getTrustManagerProviderPropertyDefinition() {
    return PD_TRUST_MANAGER_PROVIDER;
  }



  /**
   * Get the "use-ssl" property definition.
   * <p>
   * Indicates whether the HTTP Connection Handler should use SSL.
   * <p>
   * If enabled, the HTTP Connection Handler will use SSL to encrypt
   * communication with the clients.
   *
   * @return Returns the "use-ssl" property definition.
   */
  public BooleanPropertyDefinition getUseSSLPropertyDefinition() {
    return PD_USE_SSL;
  }



  /**
   * Get the "use-tcp-keep-alive" property definition.
   * <p>
   * Indicates whether the HTTP Connection Handler should use TCP
   * keep-alive.
   * <p>
   * If enabled, the SO_KEEPALIVE socket option is used to indicate
   * that TCP keepalive messages should periodically be sent to the
   * client to verify that the associated connection is still valid.
   * This may also help prevent cases in which intermediate network
   * hardware could silently drop an otherwise idle client connection,
   * provided that the keepalive interval configured in the underlying
   * operating system is smaller than the timeout enforced by the
   * network hardware.
   *
   * @return Returns the "use-tcp-keep-alive" property definition.
   */
  public BooleanPropertyDefinition getUseTCPKeepAlivePropertyDefinition() {
    return PD_USE_TCP_KEEP_ALIVE;
  }



  /**
   * Get the "use-tcp-no-delay" property definition.
   * <p>
   * Indicates whether the HTTP Connection Handler should use TCP
   * no-delay.
   * <p>
   * If enabled, the TCP_NODELAY socket option is used to ensure that
   * response messages to the client are sent immediately rather than
   * potentially waiting to determine whether additional response
   * messages can be sent in the same packet. In most cases, using the
   * TCP_NODELAY socket option provides better performance and lower
   * response times, but disabling it may help for some cases in which
   * the server sends a large number of entries to a client in response
   * to a search request.
   *
   * @return Returns the "use-tcp-no-delay" property definition.
   */
  public BooleanPropertyDefinition getUseTCPNoDelayPropertyDefinition() {
    return PD_USE_TCP_NO_DELAY;
  }



  /**
   * Managed object client implementation.
   */
  private static class HTTPConnectionHandlerCfgClientImpl implements
    HTTPConnectionHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPConnectionHandlerCfgClient> impl;



    /** Private constructor. */
    private HTTPConnectionHandlerCfgClientImpl(
        ManagedObject<? extends HTTPConnectionHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public int getAcceptBacklog() {
      return impl.getPropertyValue(INSTANCE.getAcceptBacklogPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAcceptBacklog(Integer value) {
      impl.setPropertyValue(INSTANCE.getAcceptBacklogPropertyDefinition(), value);
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
    public boolean isAllowTCPReuseAddress() {
      return impl.getPropertyValue(INSTANCE.getAllowTCPReuseAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowTCPReuseAddress(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowTCPReuseAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getBufferSize() {
      return impl.getPropertyValue(INSTANCE.getBufferSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBufferSize(Long value) {
      impl.setPropertyValue(INSTANCE.getBufferSizePropertyDefinition(), value);
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
    public boolean isKeepStats() {
      return impl.getPropertyValue(INSTANCE.getKeepStatsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeepStats(Boolean value) {
      impl.setPropertyValue(INSTANCE.getKeepStatsPropertyDefinition(), value);
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
    public long getMaxBlockedWriteTimeLimit() {
      return impl.getPropertyValue(INSTANCE.getMaxBlockedWriteTimeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxBlockedWriteTimeLimit(Long value) {
      impl.setPropertyValue(INSTANCE.getMaxBlockedWriteTimeLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getMaxConcurrentOpsPerConnection() {
      return impl.getPropertyValue(INSTANCE.getMaxConcurrentOpsPerConnectionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxConcurrentOpsPerConnection(Integer value) {
      impl.setPropertyValue(INSTANCE.getMaxConcurrentOpsPerConnectionPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getMaxRequestSize() {
      return impl.getPropertyValue(INSTANCE.getMaxRequestSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxRequestSize(Long value) {
      impl.setPropertyValue(INSTANCE.getMaxRequestSizePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getNumRequestHandlers() {
      return impl.getPropertyValue(INSTANCE.getNumRequestHandlersPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setNumRequestHandlers(Integer value) {
      impl.setPropertyValue(INSTANCE.getNumRequestHandlersPropertyDefinition(), value);
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
    public SSLClientAuthPolicy getSSLClientAuthPolicy() {
      return impl.getPropertyValue(INSTANCE.getSSLClientAuthPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSSLClientAuthPolicy(SSLClientAuthPolicy value) {
      impl.setPropertyValue(INSTANCE.getSSLClientAuthPolicyPropertyDefinition(), value);
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
    public boolean isUseSSL() {
      return impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseSSL(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseSSLPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUseTCPKeepAlive() {
      return impl.getPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseTCPKeepAlive(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isUseTCPNoDelay() {
      return impl.getPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUseTCPNoDelay(Boolean value) {
      impl.setPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends HTTPConnectionHandlerCfgClient, ? extends HTTPConnectionHandlerCfg> definition() {
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
  private static class HTTPConnectionHandlerCfgServerImpl implements
    HTTPConnectionHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPConnectionHandlerCfg> impl;

    /** The value of the "accept-backlog" property. */
    private final int pAcceptBacklog;

    /** The value of the "allowed-client" property. */
    private final SortedSet<AddressMask> pAllowedClient;

    /** The value of the "allow-tcp-reuse-address" property. */
    private final boolean pAllowTCPReuseAddress;

    /** The value of the "buffer-size" property. */
    private final long pBufferSize;

    /** The value of the "denied-client" property. */
    private final SortedSet<AddressMask> pDeniedClient;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "keep-stats" property. */
    private final boolean pKeepStats;

    /** The value of the "key-manager-provider" property. */
    private final String pKeyManagerProvider;

    /** The value of the "listen-address" property. */
    private final SortedSet<InetAddress> pListenAddress;

    /** The value of the "listen-port" property. */
    private final int pListenPort;

    /** The value of the "max-blocked-write-time-limit" property. */
    private final long pMaxBlockedWriteTimeLimit;

    /** The value of the "max-concurrent-ops-per-connection" property. */
    private final Integer pMaxConcurrentOpsPerConnection;

    /** The value of the "max-request-size" property. */
    private final long pMaxRequestSize;

    /** The value of the "num-request-handlers" property. */
    private final Integer pNumRequestHandlers;

    /** The value of the "ssl-cert-nickname" property. */
    private final SortedSet<String> pSSLCertNickname;

    /** The value of the "ssl-cipher-suite" property. */
    private final SortedSet<String> pSSLCipherSuite;

    /** The value of the "ssl-client-auth-policy" property. */
    private final SSLClientAuthPolicy pSSLClientAuthPolicy;

    /** The value of the "ssl-protocol" property. */
    private final SortedSet<String> pSSLProtocol;

    /** The value of the "trust-manager-provider" property. */
    private final String pTrustManagerProvider;

    /** The value of the "use-ssl" property. */
    private final boolean pUseSSL;

    /** The value of the "use-tcp-keep-alive" property. */
    private final boolean pUseTCPKeepAlive;

    /** The value of the "use-tcp-no-delay" property. */
    private final boolean pUseTCPNoDelay;



    /** Private constructor. */
    private HTTPConnectionHandlerCfgServerImpl(ServerManagedObject<? extends HTTPConnectionHandlerCfg> impl) {
      this.impl = impl;
      this.pAcceptBacklog = impl.getPropertyValue(INSTANCE.getAcceptBacklogPropertyDefinition());
      this.pAllowedClient = impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
      this.pAllowTCPReuseAddress = impl.getPropertyValue(INSTANCE.getAllowTCPReuseAddressPropertyDefinition());
      this.pBufferSize = impl.getPropertyValue(INSTANCE.getBufferSizePropertyDefinition());
      this.pDeniedClient = impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeepStats = impl.getPropertyValue(INSTANCE.getKeepStatsPropertyDefinition());
      this.pKeyManagerProvider = impl.getPropertyValue(INSTANCE.getKeyManagerProviderPropertyDefinition());
      this.pListenAddress = impl.getPropertyValues(INSTANCE.getListenAddressPropertyDefinition());
      this.pListenPort = impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
      this.pMaxBlockedWriteTimeLimit = impl.getPropertyValue(INSTANCE.getMaxBlockedWriteTimeLimitPropertyDefinition());
      this.pMaxConcurrentOpsPerConnection = impl.getPropertyValue(INSTANCE.getMaxConcurrentOpsPerConnectionPropertyDefinition());
      this.pMaxRequestSize = impl.getPropertyValue(INSTANCE.getMaxRequestSizePropertyDefinition());
      this.pNumRequestHandlers = impl.getPropertyValue(INSTANCE.getNumRequestHandlersPropertyDefinition());
      this.pSSLCertNickname = impl.getPropertyValues(INSTANCE.getSSLCertNicknamePropertyDefinition());
      this.pSSLCipherSuite = impl.getPropertyValues(INSTANCE.getSSLCipherSuitePropertyDefinition());
      this.pSSLClientAuthPolicy = impl.getPropertyValue(INSTANCE.getSSLClientAuthPolicyPropertyDefinition());
      this.pSSLProtocol = impl.getPropertyValues(INSTANCE.getSSLProtocolPropertyDefinition());
      this.pTrustManagerProvider = impl.getPropertyValue(INSTANCE.getTrustManagerProviderPropertyDefinition());
      this.pUseSSL = impl.getPropertyValue(INSTANCE.getUseSSLPropertyDefinition());
      this.pUseTCPKeepAlive = impl.getPropertyValue(INSTANCE.getUseTCPKeepAlivePropertyDefinition());
      this.pUseTCPNoDelay = impl.getPropertyValue(INSTANCE.getUseTCPNoDelayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPChangeListener(
        ConfigurationChangeListener<HTTPConnectionHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPChangeListener(
        ConfigurationChangeListener<HTTPConnectionHandlerCfg> listener) {
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
    public int getAcceptBacklog() {
      return pAcceptBacklog;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getAllowedClient() {
      return pAllowedClient;
    }



    /** {@inheritDoc} */
    public boolean isAllowTCPReuseAddress() {
      return pAllowTCPReuseAddress;
    }



    /** {@inheritDoc} */
    public long getBufferSize() {
      return pBufferSize;
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
    public boolean isKeepStats() {
      return pKeepStats;
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
    public long getMaxBlockedWriteTimeLimit() {
      return pMaxBlockedWriteTimeLimit;
    }



    /** {@inheritDoc} */
    public Integer getMaxConcurrentOpsPerConnection() {
      return pMaxConcurrentOpsPerConnection;
    }



    /** {@inheritDoc} */
    public long getMaxRequestSize() {
      return pMaxRequestSize;
    }



    /** {@inheritDoc} */
    public Integer getNumRequestHandlers() {
      return pNumRequestHandlers;
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
    public SSLClientAuthPolicy getSSLClientAuthPolicy() {
      return pSSLClientAuthPolicy;
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
    public boolean isUseSSL() {
      return pUseSSL;
    }



    /** {@inheritDoc} */
    public boolean isUseTCPKeepAlive() {
      return pUseTCPKeepAlive;
    }



    /** {@inheritDoc} */
    public boolean isUseTCPNoDelay() {
      return pUseTCPNoDelay;
    }



    /** {@inheritDoc} */
    public Class<? extends HTTPConnectionHandlerCfg> configurationClass() {
      return HTTPConnectionHandlerCfg.class;
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
