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
 * A server-side interface for querying HTTP Endpoint settings.
 * <p>
 * The HTTP Endpoint is used to define HTTP endpoint.
 */
public interface HTTPEndpointCfg extends Configuration {

  /**
   * Gets the configuration class associated with this HTTP Endpoint.
   *
   * @return Returns the configuration class associated with this HTTP Endpoint.
   */
  Class<? extends HTTPEndpointCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Endpoint is changed.
   *
   * @param listener
   *          The HTTP Endpoint configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<HTTPEndpointCfg> listener);



  /**
   * Deregister an existing HTTP Endpoint configuration change listener.
   *
   * @param listener
   *          The HTTP Endpoint configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<HTTPEndpointCfg> listener);



  /**
   * Gets the "authorization-mechanism" property.
   * <p>
   * The HTTP authorization mechanisms supported by this HTTP
   * Endpoint.
   *
   * @return Returns an unmodifiable set containing the values of the "authorization-mechanism" property.
   */
  SortedSet<String> getAuthorizationMechanism();



  /**
   * Gets the "authorization-mechanism" property as a set of DNs.
   * <p>
   * The HTTP authorization mechanisms supported by this HTTP
   * Endpoint.
   *
   * @return Returns the DN values of the "authorization-mechanism"
   *         property.
   */
  SortedSet<DN> getAuthorizationMechanismDNs();



  /**
   * Gets the "base-path" property.
   * <p>
   * All HTTP requests matching the base path or subordinate to it
   * will be routed to the HTTP endpoint unless a more specific HTTP
   * endpoint is found.
   *
   * @return Returns the value of the "base-path" property.
   */
  String getBasePath();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the HTTP Endpoint is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Endpoint implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
