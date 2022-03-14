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
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.CryptoManagerCfg;



/**
 * A client-side interface for reading and modifying Crypto Manager
 * settings.
 * <p>
 * The Crypto Manager provides a common interface for performing
 * compression, decompression, hashing, encryption and other kinds of
 * cryptographic operations.
 */
public interface CryptoManagerCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Crypto Manager.
   *
   * @return Returns the configuration definition associated with this Crypto Manager.
   */
  ManagedObjectDefinition<? extends CryptoManagerCfgClient, ? extends CryptoManagerCfg> definition();



  /**
   * Gets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the value of the "cipher-key-length" property.
   */
  int getCipherKeyLength();



  /**
   * Sets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @param value The value of the "cipher-key-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherKeyLength(Integer value) throws PropertyException;



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
   * Sets the "cipher-transformation" property.
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
   * @param value The value of the "cipher-transformation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherTransformation(String value) throws PropertyException;



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
   * Sets the "digest-algorithm" property.
   * <p>
   * Specifies the preferred message digest algorithm for the
   * directory server.
   *
   * @param value The value of the "digest-algorithm" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDigestAlgorithm(String value) throws PropertyException;



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
   * Sets the "key-wrapping-transformation" property.
   * <p>
   * The preferred key wrapping transformation for the directory
   * server. This value must be the same for all server instances in a
   * replication topology.
   *
   * @param value The value of the "key-wrapping-transformation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyWrappingTransformation(String value) throws PropertyException;



  /**
   * Gets the "mac-algorithm" property.
   * <p>
   * Specifies the preferred MAC algorithm for the directory server.
   *
   * @return Returns the value of the "mac-algorithm" property.
   */
  String getMacAlgorithm();



  /**
   * Sets the "mac-algorithm" property.
   * <p>
   * Specifies the preferred MAC algorithm for the directory server.
   *
   * @param value The value of the "mac-algorithm" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMacAlgorithm(String value) throws PropertyException;



  /**
   * Gets the "mac-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred MAC algorithm.
   *
   * @return Returns the value of the "mac-key-length" property.
   */
  int getMacKeyLength();



  /**
   * Sets the "mac-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred MAC algorithm.
   *
   * @param value The value of the "mac-key-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMacKeyLength(Integer value) throws PropertyException;



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
   * @return Returns the values of the "ssl-cert-nickname" property.
   */
  SortedSet<String> getSSLCertNickname();



  /**
   * Sets the "ssl-cert-nickname" property.
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
   * @param values The values of the "ssl-cert-nickname" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSSLCertNickname(Collection<String> values) throws PropertyException;



  /**
   * Gets the "ssl-cipher-suite" property.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL or TLS communication.
   *
   * @return Returns the values of the "ssl-cipher-suite" property.
   */
  SortedSet<String> getSSLCipherSuite();



  /**
   * Sets the "ssl-cipher-suite" property.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL or TLS communication.
   *
   * @param values The values of the "ssl-cipher-suite" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSSLCipherSuite(Collection<String> values) throws PropertyException;



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
   * Sets the "ssl-encryption" property.
   * <p>
   * Specifies whether SSL/TLS is used to provide encrypted
   * communication between two OpenDJ server components.
   *
   * @param value The value of the "ssl-encryption" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSSLEncryption(Boolean value) throws PropertyException;



  /**
   * Gets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL or TLS communication.
   *
   * @return Returns the values of the "ssl-protocol" property.
   */
  SortedSet<String> getSSLProtocol();



  /**
   * Sets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols that are allowed for use
   * in SSL or TLS communication.
   *
   * @param values The values of the "ssl-protocol" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSSLProtocol(Collection<String> values) throws PropertyException;

}
