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
import org.forgerock.opendj.server.config.server.ExternalHTTPAccessLogPublisherCfg;



/**
 * A client-side interface for reading and modifying External HTTP
 * Access Log Publisher settings.
 * <p>
 * External HTTP Access Log Publishers publish HTTP access messages to
 * an external handler.
 */
public interface ExternalHTTPAccessLogPublisherCfgClient extends HTTPAccessLogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this External HTTP Access Log Publisher.
   *
   * @return Returns the configuration definition associated with this External HTTP Access Log Publisher.
   */
  ManagedObjectDefinition<? extends ExternalHTTPAccessLogPublisherCfgClient, ? extends ExternalHTTPAccessLogPublisherCfg> definition();



  /**
   * Gets the "config-file" property.
   * <p>
   * The JSON configuration file that defines the External HTTP Access
   * Log Publisher. The content of the JSON configuration file depends
   * on the type of external audit event handler. The path to the file
   * is relative to the server root.
   *
   * @return Returns the value of the "config-file" property.
   */
  String getConfigFile();



  /**
   * Sets the "config-file" property.
   * <p>
   * The JSON configuration file that defines the External HTTP Access
   * Log Publisher. The content of the JSON configuration file depends
   * on the type of external audit event handler. The path to the file
   * is relative to the server root.
   *
   * @param value The value of the "config-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConfigFile(String value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * External HTTP Access Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * External HTTP Access Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
