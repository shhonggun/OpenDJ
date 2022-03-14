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
 * A server-side interface for querying LDIF Backend settings.
 * <p>
 * The LDIF Backend provides a mechanism for interacting with data
 * stored in an LDIF file.
 */
public interface LDIFBackendCfg extends LocalBackendCfg {

  /**
   * Gets the configuration class associated with this LDIF Backend.
   *
   * @return Returns the configuration class associated with this LDIF Backend.
   */
  Class<? extends LDIFBackendCfg> configurationClass();



  /**
   * Register to be notified when this LDIF Backend is changed.
   *
   * @param listener
   *          The LDIF Backend configuration change listener.
   */
  void addLDIFChangeListener(ConfigurationChangeListener<LDIFBackendCfg> listener);



  /**
   * Deregister an existing LDIF Backend configuration change listener.
   *
   * @param listener
   *          The LDIF Backend configuration change listener.
   */
  void removeLDIFChangeListener(ConfigurationChangeListener<LDIFBackendCfg> listener);



  /**
   * Gets the "is-private-backend" property.
   * <p>
   * Indicates whether the backend should be considered a private
   * backend, which indicates that it is used for storing operational
   * data rather than user-defined information.
   *
   * @return Returns the value of the "is-private-backend" property.
   */
  boolean isIsPrivateBackend();



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
   * Gets the "ldif-file" property.
   * <p>
   * Specifies the path to the LDIF file containing the data for this
   * backend.
   *
   * @return Returns the value of the "ldif-file" property.
   */
  String getLDIFFile();



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
