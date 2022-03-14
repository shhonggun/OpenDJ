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
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;



/**
 * A server-side interface for querying LDAP Attribute Description
 * List Plugin settings.
 * <p>
 * The LDAP Attribute Description List Plugin provides the ability for
 * clients to include an attribute list in a search request that names
 * object classes instead of (or in addition to) attributes.
 */
public interface LDAPAttributeDescriptionListPluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this LDAP Attribute Description List Plugin.
   *
   * @return Returns the configuration class associated with this LDAP Attribute Description List Plugin.
   */
  Class<? extends LDAPAttributeDescriptionListPluginCfg> configurationClass();



  /**
   * Register to be notified when this LDAP Attribute Description List Plugin is changed.
   *
   * @param listener
   *          The LDAP Attribute Description List Plugin configuration change listener.
   */
  void addLDAPAttributeDescriptionListChangeListener(ConfigurationChangeListener<LDAPAttributeDescriptionListPluginCfg> listener);



  /**
   * Deregister an existing LDAP Attribute Description List Plugin configuration change listener.
   *
   * @param listener
   *          The LDAP Attribute Description List Plugin configuration change listener.
   */
  void removeLDAPAttributeDescriptionListChangeListener(ConfigurationChangeListener<LDAPAttributeDescriptionListPluginCfg> listener);



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
   * Gets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns an unmodifiable set containing the values of the "plugin-type" property.
   */
  SortedSet<PluginType> getPluginType();

}
