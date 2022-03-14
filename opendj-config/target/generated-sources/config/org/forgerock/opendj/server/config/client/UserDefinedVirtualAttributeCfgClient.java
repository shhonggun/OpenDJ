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
import org.forgerock.opendj.server.config.server.UserDefinedVirtualAttributeCfg;



/**
 * A client-side interface for reading and modifying User Defined
 * Virtual Attribute settings.
 * <p>
 * The User Defined Virtual Attribute creates virtual attributes with
 * user-defined values in entries that match the criteria defined in
 * the plug-in's configuration.
 */
public interface UserDefinedVirtualAttributeCfgClient extends VirtualAttributeCfgClient {

  /**
   * Get the configuration definition associated with this User Defined Virtual Attribute.
   *
   * @return Returns the configuration definition associated with this User Defined Virtual Attribute.
   */
  ManagedObjectDefinition<? extends UserDefinedVirtualAttributeCfgClient, ? extends UserDefinedVirtualAttributeCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "value" property.
   * <p>
   * Specifies the values to be included in the virtual attribute.
   *
   * @return Returns the values of the "value" property.
   */
  SortedSet<String> getValue();



  /**
   * Sets the "value" property.
   * <p>
   * Specifies the values to be included in the virtual attribute.
   *
   * @param values The values of the "value" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setValue(Collection<String> values) throws PropertyException;

}
