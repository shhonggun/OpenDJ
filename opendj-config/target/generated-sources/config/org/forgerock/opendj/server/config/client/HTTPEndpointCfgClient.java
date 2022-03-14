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
import org.forgerock.opendj.server.config.server.HTTPEndpointCfg;



/**
 * A client-side interface for reading and modifying HTTP Endpoint
 * settings.
 * <p>
 * The HTTP Endpoint is used to define HTTP endpoint.
 */
public interface HTTPEndpointCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this HTTP Endpoint.
   *
   * @return Returns the configuration definition associated with this HTTP Endpoint.
   */
  ManagedObjectDefinition<? extends HTTPEndpointCfgClient, ? extends HTTPEndpointCfg> definition();



  /**
   * Gets the "authorization-mechanism" property.
   * <p>
   * The HTTP authorization mechanisms supported by this HTTP
   * Endpoint.
   *
   * @return Returns the values of the "authorization-mechanism" property.
   */
  SortedSet<String> getAuthorizationMechanism();



  /**
   * Sets the "authorization-mechanism" property.
   * <p>
   * The HTTP authorization mechanisms supported by this HTTP
   * Endpoint.
   *
   * @param values The values of the "authorization-mechanism" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAuthorizationMechanism(Collection<String> values) throws PropertyException;



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
   * Sets the "base-path" property.
   * <p>
   * All HTTP requests matching the base path or subordinate to it
   * will be routed to the HTTP endpoint unless a more specific HTTP
   * endpoint is found.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a HTTP Endpoint.
   *
   * @param value The value of the "base-path" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this HTTP Endpoint is not being initialized.
   */
  void setBasePath(String value) throws PropertyException, PropertyException;



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the HTTP Endpoint is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the HTTP Endpoint is enabled.
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
   * provides the HTTP Endpoint implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Endpoint implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
