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
import org.forgerock.opendj.ldap.AddressMask;



/**
 * A server-side interface for querying Connection Handler settings.
 * <p>
 * Connection Handlers are responsible for handling all interaction
 * with the clients, including accepting the connections, reading
 * requests, and sending responses.
 */
public interface ConnectionHandlerCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Connection Handler.
   *
   * @return Returns the configuration class associated with this Connection Handler.
   */
  Class<? extends ConnectionHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Connection Handler is changed.
   *
   * @param listener
   *          The Connection Handler configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<ConnectionHandlerCfg> listener);



  /**
   * Deregister an existing Connection Handler configuration change listener.
   *
   * @param listener
   *          The Connection Handler configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<ConnectionHandlerCfg> listener);



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
   * @return Returns an unmodifiable set containing the values of the "allowed-client" property.
   */
  SortedSet<AddressMask> getAllowedClient();



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
   * @return Returns an unmodifiable set containing the values of the "denied-client" property.
   */
  SortedSet<AddressMask> getDeniedClient();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Connection Handler is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
