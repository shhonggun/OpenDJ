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



/**
 * A server-side interface for querying Crypto Manager settings.
 * <p>
 * The Crypto Manager provides a common interface for performing
 * compression, decompression, hashing, encryption and other kinds of
 * cryptographic operations.
 */
public interface CryptoManagerCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Crypto Manager.
   *
   * @return Returns the configuration class associated with this Crypto Manager.
   */
  Class<? extends CryptoManagerCfg> configurationClass();



  /**
   * Register to be notified when this Crypto Manager is changed.
   *
   * @param listener
   *          The Crypto Manager configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<CryptoManagerCfg> listener);



  /**
   * Deregister an existing Crypto Manager configuration change listener.
   *
   * @param listener
   *          The Crypto Manager configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<CryptoManagerCfg> listener);



  /**
   * Gets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the value of the "cipher-key-length" property.
   */
  int getCipherKeyLength();



  /**
   * Gets the "cipher-transformation" property.
   * <p>
   * Specifies the cipher for the directory server using the syntax
   * algorithm/mode/padding.
   * <p>
   * The full transformation is required: specifying only an algorithm
   * and allowing the cipher provider to supply the default mode and
   * padding is not supported, because there is no guarantee these
   * default values are the same among different implementations. Some
   * cipher algorithms, including RC4 and ARCFOUR, do not have a mode
   * or padding, and hence must be specified using NONE for the mode
   * field and NoPadding for the padding field. For example,
   * RC4/NONE/NoPadding.
   *
   * @return Returns the value of the "cipher-transformation" property.
   */
  String getCipherTransformation();



  /**
   * Gets the "digest-algorithm" property.
   * <p>
   * Specifies the preferred message digest algorithm for the
   * directory server.
   *
   * @return Returns the value of the "digest-algorithm" property.
   */
  String getDigestAlgorithm();



  /**
   * Gets the "key-wrapping-transformation" property.
   * <p>
   * The preferred key wrapping transformation for the directory
   * server. This value must be the same for all server instances in a
   * replication topology.
   *
   * @return Returns the value of the "key-wrapping-transformation" property.
   */
  String getKeyWrappingTransformation();



  /**
   * Gets the "mac-algorithm" property.
   * <p>
   * Specifies the preferred MAC algorithm for the directory server.
   *
   * @return Returns the value of the "mac-algorithm" property.
   */
  String getMacAlgorithm();



  /**
   * Gets the "mac-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred MAC algorithm.
   *
   * @return Returns the value of the "mac-key-length" property.
   */
  int getMacKeyLength();



  /**
   * Gets the "ssl-cert-nickname" property.
   * <p>
   * Specifies the nicknames (also called the aliases) of the keys or
   * key pairs that the Crypto Manager should use when performing SSL
   * communication. The property can be used multiple times
   * (referencing different nicknames) when server certificates with
   * different public key algorithms are used in parallel (for example,
   * RSA, DSA, and ECC-based algorithms). When a nickname refers to an
   * asymmetric (public/private) key pair, the nickname for the public
   * key certificate and associated private key entry must match
   * exactly. A single nickname is used to retrieve both the public key
   * and the private key.
   * <p>
   * This is only applicable when the Crypto Manager is configured to
   * use SSL.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-cert-nickname" property.
   */
  SortedSet<String> getSSLCertNickname();



  /**
   * Gets the "ssl-cipher-suite" property.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL or TLS communication.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-cipher-suite" property.
   */
  SortedSet<String> getSSLCipherSuite();



  /**
   * Gets the "ssl-encryption" property.
   * <p>
   * Specifies whether SSL/TLS is used to provide encrypted
   * communication between two OpenDJ server components.
   *
   * @return Returns the value of the "ssl-encryption" property.
   */
  boolean isSSLEncryption();



  /**
   * Gets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL or TLS communication.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-protocol" property.
   */
  SortedSet<String> getSSLProtocol();

}
