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
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying Administration Connector
 * settings.
 * <p>
 * The Administration Connector is used to interact with
 * administration tools using LDAP.
 */
public interface AdministrationConnectorCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Administration Connector.
   *
   * @return Returns the configuration class associated with this Administration Connector.
   */
  Class<? extends AdministrationConnectorCfg> configurationClass();



  /**
   * Register to be notified when this Administration Connector is changed.
   *
   * @param listener
   *          The Administration Connector configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<AdministrationConnectorCfg> listener);



  /**
   * Deregister an existing Administration Connector configuration change listener.
   *
   * @param listener
   *          The Administration Connector configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<AdministrationConnectorCfg> listener);



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that is used with the
   * Administration Connector .
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Gets the "key-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the key manager that is used with the
   * Administration Connector .
   *
   * @return Returns the DN value of the "key-manager-provider"
   *         property.
   */
  DN getKeyManagerProviderDN();



  /**
   * Gets the "listen-address" property.
   * <p>
   * Specifies the address or set of addresses on which this
   * Administration Connector should listen for connections from LDAP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the Administration
   * Connector listens on all interfaces.
   *
   * @return Returns an unmodifiable set containing the values of the "listen-address" property.
   */
  SortedSet<InetAddress> getListenAddress();



  /**
   * Gets the "listen-port" property.
   * <p>
   * Specifies the port number on which the Administration Connector
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the value of the "listen-port" property.
   */
  int getListenPort();



  /**
   * Gets the "ssl-cert-nickname" property.
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
   * Gets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL or StartTLS communication.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-protocol" property.
   */
  SortedSet<String> getSSLProtocol();



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that is used with the
   * Administration Connector .
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Gets the "trust-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the trust manager that is used with the
   * Administration Connector .
   *
   * @return Returns the DN value of the "trust-manager-provider"
   *         property.
   */
  DN getTrustManagerProviderDN();

}
