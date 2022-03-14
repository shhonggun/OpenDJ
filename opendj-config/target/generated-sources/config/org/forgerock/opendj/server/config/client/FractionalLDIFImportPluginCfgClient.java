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
import org.forgerock.opendj.server.config.server.FractionalLDIFImportPluginCfg;



/**
 * A client-side interface for reading and modifying Fractional LDIF
 * Import Plugin settings.
 * <p>
 * The Fractional LDIF Import Plugin is used internally by the
 * replication plugin to support fractional replication.
 */
public interface FractionalLDIFImportPluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Fractional LDIF Import Plugin.
   *
   * @return Returns the configuration definition associated with this Fractional LDIF Import Plugin.
   */
  ManagedObjectDefinition<? extends FractionalLDIFImportPluginCfgClient, ? extends FractionalLDIFImportPluginCfg> definition();

}
