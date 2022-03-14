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



import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;



/**
 * A server-side interface for querying Null Backend settings.
 * <p>
 * The Null Backend provides a directory server backend that
 * implements a /dev/null like behavior for development and testing.
 */
public interface NullBackendCfg extends LocalBackendCfg {

  /**
   * Gets the configuration class associated with this Null Backend.
   *
   * @return Returns the configuration class associated with this Null Backend.
   */
  Class<? extends NullBackendCfg> configurationClass();



  /**
   * Register to be notified when this Null Backend is changed.
   *
   * @param listener
   *          The Null Backend configuration change listener.
   */
  void addNullChangeListener(ConfigurationChangeListener<NullBackendCfg> listener);



  /**
   * Deregister an existing Null Backend configuration change listener.
   *
   * @param listener
   *          The Null Backend configuration change listener.
   */
  void removeNullChangeListener(ConfigurationChangeListener<NullBackendCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();

}
