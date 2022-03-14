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
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;



/**
 * A client-side interface for reading and modifying Connection
 * Handler settings.
 * <p>
 * Connection Handlers are responsible for handling all interaction
 * with the clients, including accepting the connections, reading
 * requests, and sending responses.
 */
public interface ConnectionHandlerCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Connection Handler.
   *
   * @return Returns the configuration definition associated with this Connection Handler.
   */
  ManagedObjectDefinition<? extends ConnectionHandlerCfgClient, ? extends ConnectionHandlerCfg> definition();



  /**
   * Gets the "allowed-client" property.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the values of the "allowed-client" property.
   */
  SortedSet<AddressMask> getAllowedClient();



  /**
   * Sets the "allowed-client" property.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @param values The values of the "allowed-client" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAllowedClient(Collection<AddressMask> values) throws PropertyException;



  /**
   * Gets the "denied-client" property.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask. If both allowed and denied client masks are defined and a
   * client connection matches one or more masks in both lists, then
   * the connection is denied. If only a denied list is specified, then
   * any client not matching a mask in that list is allowed.
   *
   * @return Returns the values of the "denied-client" property.
   */
  SortedSet<AddressMask> getDeniedClient();



  /**
   * Sets the "denied-client" property.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask. If both allowed and denied client masks are defined and a
   * client connection matches one or more masks in both lists, then
   * the connection is denied. If only a denied list is specified, then
   * any client not matching a mask in that list is allowed.
   *
   * @param values The values of the "denied-client" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setDeniedClient(Collection<AddressMask> values) throws PropertyException;



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Connection Handler is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the Connection Handler is enabled.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Connection Handler implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
