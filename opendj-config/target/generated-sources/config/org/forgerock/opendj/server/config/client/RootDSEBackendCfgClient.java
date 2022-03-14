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



import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.RootDSEBackendCfg;



/**
 * A client-side interface for reading and modifying Root DSE Backend
 * settings.
 * <p>
 * The Root DSE Backend contains the directory server root DSE.
 */
public interface RootDSEBackendCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Root DSE Backend.
   *
   * @return Returns the configuration definition associated with this Root DSE Backend.
   */
  ManagedObjectDefinition<? extends RootDSEBackendCfgClient, ? extends RootDSEBackendCfg> definition();



  /**
   * Gets the "show-all-attributes" property.
   * <p>
   * Indicates whether all attributes in the root DSE are to be
   * treated like user attributes (and therefore returned to clients by
   * default) regardless of the directory server schema configuration.
   *
   * @return Returns the value of the "show-all-attributes" property.
   */
  Boolean isShowAllAttributes();



  /**
   * Sets the "show-all-attributes" property.
   * <p>
   * Indicates whether all attributes in the root DSE are to be
   * treated like user attributes (and therefore returned to clients by
   * default) regardless of the directory server schema configuration.
   *
   * @param value The value of the "show-all-attributes" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setShowAllAttributes(boolean value) throws PropertyException;



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



  /**
   * Sets the "show-subordinate-naming-contexts" property.
   * <p>
   * Indicates whether subordinate naming contexts should be visible
   * in the namingContexts attribute of the RootDSE. By default only
   * top level naming contexts are visible
   *
   * @param value The value of the "show-subordinate-naming-contexts" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setShowSubordinateNamingContexts(boolean value) throws PropertyException;

}
