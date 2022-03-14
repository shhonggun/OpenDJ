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
package org.forgerock.opendj.server.config.server;



import java.net.InetAddress;
import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.HTTPConnectionHandlerCfgDefn.SSLClientAuthPolicy;



/**
 * A server-side interface for querying HTTP Connection Handler
 * settings.
 * <p>
 * HTTP Connection Handlers provide HTTP services built on top of the
 * underlying LDAP directory.
 */
public interface HTTPConnectionHandlerCfg extends ConnectionHandlerCfg {

  /**
   * Gets the configuration class associated with this HTTP Connection Handler.
   *
   * @return Returns the configuration class associated with this HTTP Connection Handler.
   */
  Class<? extends HTTPConnectionHandlerCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Connection Handler is changed.
   *
   * @param listener
   *          The HTTP Connection Handler configuration change listener.
   */
  void addHTTPChangeListener(ConfigurationChangeListener<HTTPConnectionHandlerCfg> listener);



  /**
   * Deregister an existing HTTP Connection Handler configuration change listener.
   *
   * @param listener
   *          The HTTP Connection Handler configuration change listener.
   */
  void removeHTTPChangeListener(ConfigurationChangeListener<HTTPConnectionHandlerCfg> listener);



  /**
   * Gets the "accept-backlog" property.
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
   * @return Returns the value of the "accept-backlog" property.
   */
  int getAcceptBacklog();



  /**
   * Gets the "allow-tcp-reuse-address" property.
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
   * @return Returns the value of the "allow-tcp-reuse-address" property.
   */
  boolean isAllowTCPReuseAddress();



  /**
   * Gets the "buffer-size" property.
   * <p>
   * Specifies the size in bytes of the HTTP response message write
   * buffer.
   * <p>
   * This property specifies write buffer size allocated by the server
   * for each client connection and used to buffer HTTP response
   * messages data when writing.
   *
   * @return Returns the value of the "buffer-size" property.
   */
  long getBufferSize();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "keep-stats" property.
   * <p>
   * Indicates whether the HTTP Connection Handler should keep
   * statistics.
   * <p>
   * If enabled, the HTTP Connection Handler maintains statistics
   * about the number and types of operations requested over HTTP and
   * the amount of data sent and received.
   *
   * @return Returns the value of the "keep-stats" property.
   */
  boolean isKeepStats();



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Connection Handler .
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Gets the "key-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Connection Handler .
   *
   * @return Returns the DN value of the "key-manager-provider"
   *         property.
   */
  DN getKeyManagerProviderDN();



  /**
   * Gets the "listen-address" property.
   * <p>
   * Specifies the address or set of addresses on which this HTTP
   * Connection Handler should listen for connections from HTTP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the HTTP Connection
   * Handler listens on all interfaces.
   *
   * @return Returns an unmodifiable set containing the values of the "listen-address" property.
   */
  SortedSet<InetAddress> getListenAddress();



  /**
   * Gets the "listen-port" property.
   * <p>
   * Specifies the port number on which the HTTP Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the value of the "listen-port" property.
   */
  int getListenPort();



  /**
   * Gets the "max-blocked-write-time-limit" property.
   * <p>
   * Specifies the maximum length of time that attempts to write data
   * to HTTP clients should be allowed to block.
   * <p>
   * If an attempt to write data to a client takes longer than this
   * length of time, then the client connection is terminated.
   *
   * @return Returns the value of the "max-blocked-write-time-limit" property.
   */
  long getMaxBlockedWriteTimeLimit();



  /**
   * Gets the "max-concurrent-ops-per-connection" property.
   * <p>
   * Specifies the maximum number of internal operations that each
   * HTTP client connection can execute concurrently.
   * <p>
   * This property allow to limit the impact that each HTTP request
   * can have on the whole server by limiting the number of internal
   * operations that each HTTP request can execute concurrently. A
   * value of 0 means that no limit is enforced.
   *
   * @return Returns the value of the "max-concurrent-ops-per-connection" property.
   */
  Integer getMaxConcurrentOpsPerConnection();



  /**
   * Gets the "max-request-size" property.
   * <p>
   * Specifies the size in bytes of the largest HTTP request message
   * that will be allowed by the HTTP Connection Handler.
   * <p>
   * This can help prevent denial-of-service attacks by clients that
   * indicate they send extremely large requests to the server causing
   * it to attempt to allocate large amounts of memory.
   *
   * @return Returns the value of the "max-request-size" property.
   */
  long getMaxRequestSize();



  /**
   * Gets the "num-request-handlers" property.
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
   * @return Returns the value of the "num-request-handlers" property.
   */
  Integer getNumRequestHandlers();



  /**
   * Gets the "ssl-cert-nickname" property.
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
   * @return Returns an unmodifiable set containing the values of the "ssl-cert-nickname" property.
   */
  SortedSet<String> getSSLCertNickname();



  /**
   * Gets the "ssl-cipher-suite" property.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL communication.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-cipher-suite" property.
   */
  SortedSet<String> getSSLCipherSuite();



  /**
   * Gets the "ssl-client-auth-policy" property.
   * <p>
   * Specifies the policy that the HTTP Connection Handler should use
   * regarding client SSL certificates. Clients can use the SASL
   * EXTERNAL mechanism only if the policy is set to "optional" or
   * "required".
   * <p>
   * This is only applicable if clients are allowed to use SSL.
   *
   * @return Returns the value of the "ssl-client-auth-policy" property.
   */
  SSLClientAuthPolicy getSSLClientAuthPolicy();



  /**
   * Gets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL communication.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-protocol" property.
   */
  SortedSet<String> getSSLProtocol();



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the HTTP Connection Handler .
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Gets the "trust-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the HTTP Connection Handler .
   *
   * @return Returns the DN value of the "trust-manager-provider"
   *         property.
   */
  DN getTrustManagerProviderDN();



  /**
   * Gets the "use-ssl" property.
   * <p>
   * Indicates whether the HTTP Connection Handler should use SSL.
   * <p>
   * If enabled, the HTTP Connection Handler will use SSL to encrypt
   * communication with the clients.
   *
   * @return Returns the value of the "use-ssl" property.
   */
  boolean isUseSSL();



  /**
   * Gets the "use-tcp-keep-alive" property.
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
   * @return Returns the value of the "use-tcp-keep-alive" property.
   */
  boolean isUseTCPKeepAlive();



  /**
   * Gets the "use-tcp-no-delay" property.
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
   * @return Returns the value of the "use-tcp-no-delay" property.
   */
  boolean isUseTCPNoDelay();

}
