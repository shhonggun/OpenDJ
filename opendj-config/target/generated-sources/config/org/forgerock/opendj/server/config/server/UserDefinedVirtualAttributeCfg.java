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



/**
 * A server-side interface for querying User Defined Virtual Attribute
 * settings.
 * <p>
 * The User Defined Virtual Attribute creates virtual attributes with
 * user-defined values in entries that match the criteria defined in
 * the plug-in's configuration.
 */
public interface UserDefinedVirtualAttributeCfg extends VirtualAttributeCfg {

  /**
   * Gets the configuration class associated with this User Defined Virtual Attribute.
   *
   * @return Returns the configuration class associated with this User Defined Virtual Attribute.
   */
  Class<? extends UserDefinedVirtualAttributeCfg> configurationClass();



  /**
   * Register to be notified when this User Defined Virtual Attribute is changed.
   *
   * @param listener
   *          The User Defined Virtual Attribute configuration change listener.
   */
  void addUserDefinedChangeListener(ConfigurationChangeListener<UserDefinedVirtualAttributeCfg> listener);



  /**
   * Deregister an existing User Defined Virtual Attribute configuration change listener.
   *
   * @param listener
   *          The User Defined Virtual Attribute configuration change listener.
   */
  void removeUserDefinedChangeListener(ConfigurationChangeListener<UserDefinedVirtualAttributeCfg> listener);



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
   * Gets the "value" property.
   * <p>
   * Specifies the values to be included in the virtual attribute.
   *
   * @return Returns an unmodifiable set containing the values of the "value" property.
   */
  SortedSet<String> getValue();

}
