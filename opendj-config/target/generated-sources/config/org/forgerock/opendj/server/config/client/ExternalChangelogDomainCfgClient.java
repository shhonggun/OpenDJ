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
import org.forgerock.opendj.server.config.server.ExternalChangelogDomainCfg;



/**
 * A client-side interface for reading and modifying External
 * Changelog Domain settings.
 * <p>
 * The External Changelog Domain provides configuration of the
 * external changelog for the replication domain.
 */
public interface ExternalChangelogDomainCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this External Changelog Domain.
   *
   * @return Returns the configuration definition associated with this External Changelog Domain.
   */
  ManagedObjectDefinition<? extends ExternalChangelogDomainCfgClient, ? extends ExternalChangelogDomainCfg> definition();



  /**
   * Gets the "ecl-include" property.
   * <p>
   * Specifies a list of attributes which should be published with
   * every change log entry, regardless of whether the attribute itself
   * has changed.
   * <p>
   * The list of attributes may include wild cards such as "*" and "+"
   * as well as object class references prefixed with an ampersand, for
   * example "@person". The included attributes will be published using
   * the "includedAttributes" operational attribute as a single LDIF
   * value rather like the "changes" attribute. For modify and modifyDN
   * operations the included attributes will be taken from the entry
   * before any changes were applied.
   *
   * @return Returns the values of the "ecl-include" property.
   */
  SortedSet<String> getECLInclude();



  /**
   * Sets the "ecl-include" property.
   * <p>
   * Specifies a list of attributes which should be published with
   * every change log entry, regardless of whether the attribute itself
   * has changed.
   * <p>
   * The list of attributes may include wild cards such as "*" and "+"
   * as well as object class references prefixed with an ampersand, for
   * example "@person". The included attributes will be published using
   * the "includedAttributes" operational attribute as a single LDIF
   * value rather like the "changes" attribute. For modify and modifyDN
   * operations the included attributes will be taken from the entry
   * before any changes were applied.
   *
   * @param values The values of the "ecl-include" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setECLInclude(Collection<String> values) throws PropertyException;



  /**
   * Gets the "ecl-include-for-deletes" property.
   * <p>
   * Specifies a list of attributes which should be published with
   * every delete operation change log entry, in addition to those
   * specified by the "ecl-include" property.
   * <p>
   * This property provides a means for applications to archive
   * entries after they have been deleted. See the description of the
   * "ecl-include" property for further information about how the
   * included attributes are published.
   *
   * @return Returns the values of the "ecl-include-for-deletes" property.
   */
  SortedSet<String> getECLIncludeForDeletes();



  /**
   * Sets the "ecl-include-for-deletes" property.
   * <p>
   * Specifies a list of attributes which should be published with
   * every delete operation change log entry, in addition to those
   * specified by the "ecl-include" property.
   * <p>
   * This property provides a means for applications to archive
   * entries after they have been deleted. See the description of the
   * "ecl-include" property for further information about how the
   * included attributes are published.
   *
   * @param values The values of the "ecl-include-for-deletes" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setECLIncludeForDeletes(Collection<String> values) throws PropertyException;



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the External Changelog Domain is enabled. To
   * enable computing the change numbers, set the Replication Server's
   * "ds-cfg-compute-change-number" property to true.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the External Changelog Domain is enabled. To
   * enable computing the change numbers, set the Replication Server's
   * "ds-cfg-compute-change-number" property to true.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;

}
