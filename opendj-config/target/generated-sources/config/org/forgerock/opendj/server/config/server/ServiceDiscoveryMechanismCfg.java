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



import java.util.SortedSet;
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying Service Discovery Mechanism
 * settings.
 * <p>
 * A Service Discovery Mechanism identifies a set of LDAP servers for
 * load balancing
 */
public interface ServiceDiscoveryMechanismCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Service Discovery Mechanism.
   *
   * @return Returns the configuration class associated with this Service Discovery Mechanism.
   */
  Class<? extends ServiceDiscoveryMechanismCfg> configurationClass();



  /**
   * Register to be notified when this Service Discovery Mechanism is changed.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<ServiceDiscoveryMechanismCfg> listener);



  /**
   * Deregister an existing Service Discovery Mechanism configuration change listener.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<ServiceDiscoveryMechanismCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Service Discovery Mechanism implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this Service Discovery Mechanism.
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Gets the "key-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this Service Discovery Mechanism.
   *
   * @return Returns the DN value of the "key-manager-provider"
   *         property.
   */
  DN getKeyManagerProviderDN();



  /**
   * Gets the "ssl-cert-nickname" property.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the Service Discovery Mechanism should use when
   * performing SSL communication. The property can be used multiple
   * times (referencing different nicknames) when server certificates
   * with different public key algorithms are used in parallel (for
   * example, RSA, DSA, and ECC-based algorithms). When a nickname
   * refers to an asymmetric (public/private) key pair, the nickname
   * for the public key certificate and associated private key entry
   * must match exactly. A single nickname is used to retrieve both the
   * public key and the private key.
   * <p>
   * This is only applicable when the Service Discovery Mechanism is
   * configured to use SSL.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-cert-nickname" property.
   */
  SortedSet<String> getSSLCertNickname();



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Service Discovery Mechanism.
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Gets the "trust-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Service Discovery Mechanism.
   *
   * @return Returns the DN value of the "trust-manager-provider"
   *         property.
   */
  DN getTrustManagerProviderDN();



  /**
   * Gets the "use-ssl" property.
   * <p>
   * Indicates whether the Service Discovery Mechanism should use SSL.
   * <p>
   * If enabled, the Service Discovery Mechanism will use SSL to
   * encrypt communication with the clients.
   *
   * @return Returns the value of the "use-ssl" property.
   */
  boolean isUseSSL();



  /**
   * Gets the "use-start-tls" property.
   * <p>
   * Indicates whether the Service Discovery Mechanism should use
   * Start TLS.
   * <p>
   * If enabled, the Service Discovery Mechanism will use Start TLS to
   * encrypt communication with remote servers.
   *
   * @return Returns the value of the "use-start-tls" property.
   */
  boolean isUseStartTLS();

}
