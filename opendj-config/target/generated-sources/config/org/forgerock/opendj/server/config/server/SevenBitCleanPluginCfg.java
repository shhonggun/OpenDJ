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
 * A server-side interface for querying Seven Bit Clean Plugin
 * settings.
 * <p>
 * The Seven Bit Clean Plugin ensures that values for a specified set
 * of attributes are 7-bit clean.
 */
public interface SevenBitCleanPluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this Seven Bit Clean Plugin.
   *
   * @return Returns the configuration class associated with this Seven Bit Clean Plugin.
   */
  Class<? extends SevenBitCleanPluginCfg> configurationClass();



  /**
   * Register to be notified when this Seven Bit Clean Plugin is changed.
   *
   * @param listener
   *          The Seven Bit Clean Plugin configuration change listener.
   */
  void addSevenBitCleanChangeListener(ConfigurationChangeListener<SevenBitCleanPluginCfg> listener);



  /**
   * Deregister an existing Seven Bit Clean Plugin configuration change listener.
   *
   * @param listener
   *          The Seven Bit Clean Plugin configuration change listener.
   */
  void removeSevenBitCleanChangeListener(ConfigurationChangeListener<SevenBitCleanPluginCfg> listener);



  /**
   * Gets the "attribute-type" property.
   * <p>
   * Specifies the name or OID of an attribute type for which values
   * should be checked to ensure that they are 7-bit clean.
   *
   * @return Returns an unmodifiable set containing the values of the "attribute-type" property.
   */
  SortedSet<AttributeType> getAttributeType();



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DN below which the checking is performed.
   * <p>
   * Any attempt to update a value for one of the configured
   * attributes below this base DN must be 7-bit clean for the
   * operation to be allowed.
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

}
