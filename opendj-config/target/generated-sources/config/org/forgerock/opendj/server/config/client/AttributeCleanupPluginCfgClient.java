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
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.AttributeCleanupPluginCfg;



/**
 * A client-side interface for reading and modifying Attribute Cleanup
 * Plugin settings.
 * <p>
 * A pre-parse plugin which can be used to remove and rename
 * attributes in ADD and MODIFY requests before being processed.
 */
public interface AttributeCleanupPluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Attribute Cleanup Plugin.
   *
   * @return Returns the configuration definition associated with this Attribute Cleanup Plugin.
   */
  ManagedObjectDefinition<? extends AttributeCleanupPluginCfgClient, ? extends AttributeCleanupPluginCfg> definition();



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
   * Sets the "invoke-for-internal-operations" property.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @param value The value of the "invoke-for-internal-operations" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setInvokeForInternalOperations(Boolean value) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the values of the "plugin-type" property.
   */
  SortedSet<PluginType> getPluginType();



  /**
   * Sets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @param values The values of the "plugin-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPluginType(Collection<PluginType> values) throws PropertyException;



  /**
   * Gets the "remove-inbound-attributes" property.
   * <p>
   * A list of attributes which should be removed from incoming add or
   * modify requests.
   *
   * @return Returns the values of the "remove-inbound-attributes" property.
   */
  SortedSet<String> getRemoveInboundAttributes();



  /**
   * Sets the "remove-inbound-attributes" property.
   * <p>
   * A list of attributes which should be removed from incoming add or
   * modify requests.
   *
   * @param values The values of the "remove-inbound-attributes" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRemoveInboundAttributes(Collection<String> values) throws PropertyException;



  /**
   * Gets the "rename-inbound-attributes" property.
   * <p>
   * A list of attributes which should be renamed in incoming add or
   * modify requests.
   *
   * @return Returns the values of the "rename-inbound-attributes" property.
   */
  SortedSet<String> getRenameInboundAttributes();



  /**
   * Sets the "rename-inbound-attributes" property.
   * <p>
   * A list of attributes which should be renamed in incoming add or
   * modify requests.
   *
   * @param values The values of the "rename-inbound-attributes" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRenameInboundAttributes(Collection<String> values) throws PropertyException;

}
