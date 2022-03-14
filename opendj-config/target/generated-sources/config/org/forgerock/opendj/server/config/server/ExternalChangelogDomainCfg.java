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



import java.util.SortedSet;
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying External Changelog Domain
 * settings.
 * <p>
 * The External Changelog Domain provides configuration of the
 * external changelog for the replication domain.
 */
public interface ExternalChangelogDomainCfg extends Configuration {

  /**
   * Gets the configuration class associated with this External Changelog Domain.
   *
   * @return Returns the configuration class associated with this External Changelog Domain.
   */
  Class<? extends ExternalChangelogDomainCfg> configurationClass();



  /**
   * Register to be notified when this External Changelog Domain is changed.
   *
   * @param listener
   *          The External Changelog Domain configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<ExternalChangelogDomainCfg> listener);



  /**
   * Deregister an existing External Changelog Domain configuration change listener.
   *
   * @param listener
   *          The External Changelog Domain configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<ExternalChangelogDomainCfg> listener);



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
   * @return Returns an unmodifiable set containing the values of the "ecl-include" property.
   */
  SortedSet<String> getECLInclude();



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
   * @return Returns an unmodifiable set containing the values of the "ecl-include-for-deletes" property.
   */
  SortedSet<String> getECLIncludeForDeletes();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the External Changelog Domain is enabled. To
   * enable computing the change numbers, set the Replication Server's
   * "ds-cfg-compute-change-number" property to true.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();

}
