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
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.server.config.meta.RootDNCfgDefn.DefaultRootPrivilegeName;



/**
 * A server-side interface for querying Root DN settings.
 * <p>
 * The Root DN configuration contains all the Root DN Users defined in
 * the directory server. In addition, it also defines the default set
 * of privileges that Root DN Users automatically inherit.
 */
public interface RootDNCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Root DN.
   *
   * @return Returns the configuration class associated with this Root DN.
   */
  Class<? extends RootDNCfg> configurationClass();



  /**
   * Register to be notified when this Root DN is changed.
   *
   * @param listener
   *          The Root DN configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<RootDNCfg> listener);



  /**
   * Deregister an existing Root DN configuration change listener.
   *
   * @param listener
   *          The Root DN configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<RootDNCfg> listener);



  /**
   * Gets the "default-root-privilege-name" property.
   * <p>
   * Specifies the names of the privileges that root users will be
   * granted by default.
   *
   * @return Returns an unmodifiable set containing the values of the "default-root-privilege-name" property.
   */
  SortedSet<DefaultRootPrivilegeName> getDefaultRootPrivilegeName();



  /**
   * Lists the Root DN Users.
   *
   * @return Returns an array containing the names of the
   *         Root DN Users.
   */
  String[] listRootDNUsers();



  /**
   * Gets the named Root DN User.
   *
   * @param name
   *          The name of the Root DN User to retrieve.
   * @return Returns the named Root DN User.
   * @throws ConfigException
   *           If the Root DN User could not be found or it
   *           could not be successfully decoded.
   */
  RootDNUserCfg getRootDNUser(String name) throws ConfigException;



  /**
   * Registers to be notified when new Root DN Users are added.
   *
   * @param listener
   *          The Root DN User configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addRootDNUserAddListener(ConfigurationAddListener<RootDNUserCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Root DN User configuration add listener.
   *
   * @param listener
   *          The Root DN User configuration add listener.
   */
  void removeRootDNUserAddListener(ConfigurationAddListener<RootDNUserCfg> listener);



  /**
   * Registers to be notified when existing Root DN Users are deleted.
   *
   * @param listener
   *          The Root DN User configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addRootDNUserDeleteListener(ConfigurationDeleteListener<RootDNUserCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Root DN User configuration delete listener.
   *
   * @param listener
   *          The Root DN User configuration delete listener.
   */
  void removeRootDNUserDeleteListener(ConfigurationDeleteListener<RootDNUserCfg> listener);

}
