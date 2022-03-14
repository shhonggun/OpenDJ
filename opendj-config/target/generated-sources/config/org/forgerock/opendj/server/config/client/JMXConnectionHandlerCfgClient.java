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



import java.net.InetAddress;
import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.JMXConnectionHandlerCfg;



/**
 * A client-side interface for reading and modifying JMX Connection
 * Handler settings.
 * <p>
 * The JMX Connection Handler is used to interact with clients using
 * the Java Management Extensions (JMX) protocol.
 */
public interface JMXConnectionHandlerCfgClient extends ConnectionHandlerCfgClient {

  /**
   * Get the configuration definition associated with this JMX Connection Handler.
   *
   * @return Returns the configuration definition associated with this JMX Connection Handler.
   */
  ManagedObjectDefinition<? extends JMXConnectionHandlerCfgClient, ? extends JMXConnectionHandlerCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the JMX Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the JMX Connection Handler implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this JMX Connection Handler .
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Sets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this JMX Connection Handler .
   *
   * @param value The value of the "key-manager-provider" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyManagerProvider(String value) throws PropertyException;



  /**
   * Gets the "listen-address" property.
   * <p>
   * Specifies the address on which this JMX Connection Handler should
   * listen for connections from JMX clients.
   * <p>
   * If no value is provided, then the JMX Connection Handler listens
   * on all interfaces.
   *
   * @return Returns the value of the "listen-address" property.
   */
  InetAddress getListenAddress();



  /**
   * Sets the "listen-address" property.
   * <p>
   * Specifies the address on which this JMX Connection Handler should
   * listen for connections from JMX clients.
   * <p>
   * If no value is provided, then the JMX Connection Handler listens
   * on all interfaces.
   *
   * @param value The value of the "listen-address" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setListenAddress(InetAddress value) throws PropertyException;



  /**
   * Gets the "listen-port" property.
   * <p>
   * Specifies the port number on which the JMX Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the value of the "listen-port" property.
   */
  Integer getListenPort();



  /**
   * Sets the "listen-port" property.
   * <p>
   * Specifies the port number on which the JMX Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @param value The value of the "listen-port" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setListenPort(int value) throws PropertyException;



  /**
   * Gets the "rmi-port" property.
   * <p>
   * Specifies the port number on which the JMX RMI service will
   * listen for connections from clients. A value of 0 indicates the
   * service to choose a port of its own.
   * <p>
   * If the value provided is different than 0, the value will be used
   * as the RMI port. Otherwise, the RMI service will choose a port of
   * its own.
   *
   * @return Returns the value of the "rmi-port" property.
   */
  int getRmiPort();



  /**
   * Sets the "rmi-port" property.
   * <p>
   * Specifies the port number on which the JMX RMI service will
   * listen for connections from clients. A value of 0 indicates the
   * service to choose a port of its own.
   * <p>
   * If the value provided is different than 0, the value will be used
   * as the RMI port. Otherwise, the RMI service will choose a port of
   * its own.
   *
   * @param value The value of the "rmi-port" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setRmiPort(Integer value) throws PropertyException;



  /**
   * Gets the "ssl-cert-nickname" property.
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
   * @return Returns the values of the "ssl-cert-nickname" property.
   */
  SortedSet<String> getSSLCertNickname();



  /**
   * Sets the "ssl-cert-nickname" property.
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
   * @param values The values of the "ssl-cert-nickname" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setSSLCertNickname(Collection<String> values) throws PropertyException;



  /**
   * Gets the "use-ssl" property.
   * <p>
   * Indicates whether the JMX Connection Handler should use SSL.
   * <p>
   * If enabled, the JMX Connection Handler will use SSL to encrypt
   * communication with the clients.
   *
   * @return Returns the value of the "use-ssl" property.
   */
  boolean isUseSSL();



  /**
   * Sets the "use-ssl" property.
   * <p>
   * Indicates whether the JMX Connection Handler should use SSL.
   * <p>
   * If enabled, the JMX Connection Handler will use SSL to encrypt
   * communication with the clients.
   *
   * @param value The value of the "use-ssl" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setUseSSL(Boolean value) throws PropertyException;

}
