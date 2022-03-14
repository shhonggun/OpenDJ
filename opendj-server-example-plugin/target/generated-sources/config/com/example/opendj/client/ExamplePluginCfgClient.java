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
package com.example.opendj.client;



import com.example.opendj.server.ExamplePluginCfg;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.client.PluginCfgClient;



/**
 * A client-side interface for reading and modifying Example Plugin
 * settings.
 * <p>
 * An example "Hello World" plugin.
 */
public interface ExamplePluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Example Plugin.
   *
   * @return Returns the configuration definition associated with this Example Plugin.
   */
  ManagedObjectDefinition<? extends ExamplePluginCfgClient, ? extends ExamplePluginCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "message" property.
   * <p>
   * The message to be logged.
   *
   * @return Returns the value of the "message" property.
   */
  String getMessage();



  /**
   * Sets the "message" property.
   * <p>
   * The message to be logged.
   *
   * @param value The value of the "message" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMessage(String value) throws PropertyException;

}
