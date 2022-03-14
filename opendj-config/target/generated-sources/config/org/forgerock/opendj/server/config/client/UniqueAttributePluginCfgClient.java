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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.UniqueAttributePluginCfg;



/**
 * A client-side interface for reading and modifying Unique Attribute
 * Plugin settings.
 * <p>
 * The Unique Attribute Plugin enforces constraints on the value of an
 * attribute within a portion of the directory.
 */
public interface UniqueAttributePluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Unique Attribute Plugin.
   *
   * @return Returns the configuration definition associated with this Unique Attribute Plugin.
   */
  ManagedObjectDefinition<? extends UniqueAttributePluginCfgClient, ? extends UniqueAttributePluginCfg> definition();



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies a base DN within which the attribute must be unique.
   *
   * @return Returns the values of the "base-dn" property.
   */
  SortedSet<DN> getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * Specifies a base DN within which the attribute must be unique.
   *
   * @param values The values of the "base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setBaseDN(Collection<DN> values) throws PropertyException;



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
   * Gets the "type" property.
   * <p>
   * Specifies the type of attributes to check for value uniqueness.
   *
   * @return Returns the values of the "type" property.
   */
  SortedSet<AttributeType> getType();



  /**
   * Sets the "type" property.
   * <p>
   * Specifies the type of attributes to check for value uniqueness.
   *
   * @param values The values of the "type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setType(Collection<AttributeType> values) throws PropertyException;

}
