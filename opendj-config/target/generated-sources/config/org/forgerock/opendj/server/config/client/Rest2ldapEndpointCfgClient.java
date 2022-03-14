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



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.Rest2ldapEndpointCfg;



/**
 * A client-side interface for reading and modifying Rest2ldap
 * Endpoint settings.
 * <p>
 * The Rest2ldap Endpoint provides RESTful access to LDAP application
 * data using a set of customizable data transformations.
 */
public interface Rest2ldapEndpointCfgClient extends HTTPEndpointCfgClient {

  /**
   * Get the configuration definition associated with this Rest2ldap Endpoint.
   *
   * @return Returns the configuration definition associated with this Rest2ldap Endpoint.
   */
  ManagedObjectDefinition<? extends Rest2ldapEndpointCfgClient, ? extends Rest2ldapEndpointCfg> definition();



  /**
   * Gets the "config-directory" property.
   * <p>
   * The directory containing the Rest2Ldap configuration file(s) for
   * this specific endpoint.
   * <p>
   * The directory must be readable by the server and may contain
   * multiple configuration files, one for each supported version of
   * the REST endpoint. If a relative path is used then it will be
   * resolved against the server's instance directory.
   *
   * @return Returns the value of the "config-directory" property.
   */
  String getConfigDirectory();



  /**
   * Sets the "config-directory" property.
   * <p>
   * The directory containing the Rest2Ldap configuration file(s) for
   * this specific endpoint.
   * <p>
   * The directory must be readable by the server and may contain
   * multiple configuration files, one for each supported version of
   * the REST endpoint. If a relative path is used then it will be
   * resolved against the server's instance directory.
   *
   * @param value The value of the "config-directory" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConfigDirectory(String value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Rest2ldap Endpoint implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Rest2ldap Endpoint implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
