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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Root DSE Backend settings.
 * <p>
 * The Root DSE Backend contains the directory server root DSE.
 */
public interface RootDSEBackendCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Root DSE Backend.
   *
   * @return Returns the configuration class associated with this Root DSE Backend.
   */
  Class<? extends RootDSEBackendCfg> configurationClass();



  /**
   * Register to be notified when this Root DSE Backend is changed.
   *
   * @param listener
   *          The Root DSE Backend configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<RootDSEBackendCfg> listener);



  /**
   * Deregister an existing Root DSE Backend configuration change listener.
   *
   * @param listener
   *          The Root DSE Backend configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<RootDSEBackendCfg> listener);



  /**
   * Gets the "show-all-attributes" property.
   * <p>
   * Indicates whether all attributes in the root DSE are to be
   * treated like user attributes (and therefore returned to clients by
   * default) regardless of the directory server schema configuration.
   *
   * @return Returns the value of the "show-all-attributes" property.
   */
  boolean isShowAllAttributes();



  /**
   * Gets the "show-subordinate-naming-contexts" property.
   * <p>
   * Indicates whether subordinate naming contexts should be visible
   * in the namingContexts attribute of the RootDSE. By default only
   * top level naming contexts are visible
   *
   * @return Returns the value of the "show-subordinate-naming-contexts" property.
   */
  boolean isShowSubordinateNamingContexts();

}
