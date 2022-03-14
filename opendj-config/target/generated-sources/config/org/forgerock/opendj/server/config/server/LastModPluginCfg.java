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
 * A server-side interface for querying Last Mod Plugin settings.
 * <p>
 * The Last Mod Plugin is used to ensure that the creatorsName and
 * createTimestamp attributes are included in an entry whenever it is
 * added to the server and also to ensure that the modifiersName and
 * modifyTimestamp attributes are updated whenever an entry is modified
 * or renamed.
 */
public interface LastModPluginCfg extends PluginCfg {

  /**
   * Gets the configuration class associated with this Last Mod Plugin.
   *
   * @return Returns the configuration class associated with this Last Mod Plugin.
   */
  Class<? extends LastModPluginCfg> configurationClass();



  /**
   * Register to be notified when this Last Mod Plugin is changed.
   *
   * @param listener
   *          The Last Mod Plugin configuration change listener.
   */
  void addLastModChangeListener(ConfigurationChangeListener<LastModPluginCfg> listener);



  /**
   * Deregister an existing Last Mod Plugin configuration change listener.
   *
   * @param listener
   *          The Last Mod Plugin configuration change listener.
   */
  void removeLastModChangeListener(ConfigurationChangeListener<LastModPluginCfg> listener);



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
