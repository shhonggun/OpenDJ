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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;



/**
 * A server-side interface for querying Unique Attribute Plugin
 * settings.
 * <p>
 * The Unique Attribute Plugin enforces constraints on the value of an
 * attribute within a portion of the directory.
 */
public interface UniqueAttributePluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this Unique Attribute Plugin.
   *
   * @return Returns the configuration class associated with this Unique Attribute Plugin.
   */
  Class<? extends UniqueAttributePluginCfg> configurationClass();



  /**
   * Register to be notified when this Unique Attribute Plugin is changed.
   *
   * @param listener
   *          The Unique Attribute Plugin configuration change listener.
   */
  void addUniqueAttributeChangeListener(ConfigurationChangeListener<UniqueAttributePluginCfg> listener);



  /**
   * Deregister an existing Unique Attribute Plugin configuration change listener.
   *
   * @param listener
   *          The Unique Attribute Plugin configuration change listener.
   */
  void removeUniqueAttributeChangeListener(ConfigurationChangeListener<UniqueAttributePluginCfg> listener);



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies a base DN within which the attribute must be unique.
   *
   * @return Returns an unmodifiable set containing the values of the "base-dn" property.
   */
  SortedSet<DN> getBaseDN();



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



  /**
   * Gets the "type" property.
   * <p>
   * Specifies the type of attributes to check for value uniqueness.
   *
   * @return Returns an unmodifiable set containing the values of the "type" property.
   */
  SortedSet<AttributeType> getType();

}
