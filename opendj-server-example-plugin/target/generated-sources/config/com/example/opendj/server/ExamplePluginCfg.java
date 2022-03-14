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
package com.example.opendj.server;



import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.server.PluginCfg;



/**
 * A server-side interface for querying Example Plugin settings.
 * <p>
 * An example "Hello World" plugin.
 */
public interface ExamplePluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this Example Plugin.
   *
   * @return Returns the configuration class associated with this Example Plugin.
   */
  Class<? extends ExamplePluginCfg> configurationClass();



  /**
   * Register to be notified when this Example Plugin is changed.
   *
   * @param listener
   *          The Example Plugin configuration change listener.
   */
  void addExampleChangeListener(ConfigurationChangeListener<ExamplePluginCfg> listener);



  /**
   * Deregister an existing Example Plugin configuration change listener.
   *
   * @param listener
   *          The Example Plugin configuration change listener.
   */
  void removeExampleChangeListener(ConfigurationChangeListener<ExamplePluginCfg> listener);



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
   * Gets the "message" property.
   * <p>
   * The message to be logged.
   *
   * @return Returns the value of the "message" property.
   */
  String getMessage();

}
