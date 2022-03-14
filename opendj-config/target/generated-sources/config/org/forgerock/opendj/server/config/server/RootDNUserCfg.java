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
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying Root DN User settings.
 * <p>
 * A Root DN User are administrative users who can granted special
 * privileges that are not available to non-root users (for example,
 * the ability to bind to the server in lockdown mode).
 */
public interface RootDNUserCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Root DN User.
   *
   * @return Returns the configuration class associated with this Root DN User.
   */
  Class<? extends RootDNUserCfg> configurationClass();



  /**
   * Register to be notified when this Root DN User is changed.
   *
   * @param listener
   *          The Root DN User configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<RootDNUserCfg> listener);



  /**
   * Deregister an existing Root DN User configuration change listener.
   *
   * @param listener
   *          The Root DN User configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<RootDNUserCfg> listener);



  /**
   * Gets the "alternate-bind-dn" property.
   * <p>
   * Specifies one or more alternate DNs that can be used to bind to
   * the server as this root user.
   *
   * @return Returns an unmodifiable set containing the values of the "alternate-bind-dn" property.
   */
  SortedSet<DN> getAlternateBindDN();

}
