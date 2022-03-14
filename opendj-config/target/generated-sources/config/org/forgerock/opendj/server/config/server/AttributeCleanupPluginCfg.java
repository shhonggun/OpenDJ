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
 * A server-side interface for querying Attribute Cleanup Plugin
 * settings.
 * <p>
 * A pre-parse plugin which can be used to remove and rename
 * attributes in ADD and MODIFY requests before being processed.
 */
public interface AttributeCleanupPluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this Attribute Cleanup Plugin.
   *
   * @return Returns the configuration class associated with this Attribute Cleanup Plugin.
   */
  Class<? extends AttributeCleanupPluginCfg> configurationClass();



  /**
   * Register to be notified when this Attribute Cleanup Plugin is changed.
   *
   * @param listener
   *          The Attribute Cleanup Plugin configuration change listener.
   */
  void addAttributeCleanupChangeListener(ConfigurationChangeListener<AttributeCleanupPluginCfg> listener);



  /**
   * Deregister an existing Attribute Cleanup Plugin configuration change listener.
   *
   * @param listener
   *          The Attribute Cleanup Plugin configuration change listener.
   */
  void removeAttributeCleanupChangeListener(ConfigurationChangeListener<AttributeCleanupPluginCfg> listener);



  /**
   * Gets the "invoke-for-internal-operations" property.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @return Returns the value of the "invoke-for-internal-operations" property.
   */
  boolean isInvokeForInternalOperations();



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
   * Gets the "remove-inbound-attributes" property.
   * <p>
   * A list of attributes which should be removed from incoming add or
   * modify requests.
   *
   * @return Returns an unmodifiable set containing the values of the "remove-inbound-attributes" property.
   */
  SortedSet<String> getRemoveInboundAttributes();



  /**
   * Gets the "rename-inbound-attributes" property.
   * <p>
   * A list of attributes which should be renamed in incoming add or
   * modify requests.
   *
   * @return Returns an unmodifiable set containing the values of the "rename-inbound-attributes" property.
   */
  SortedSet<String> getRenameInboundAttributes();

}
