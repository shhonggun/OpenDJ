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



import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Dynamic Group Implementation
 * settings.
 * <p>
 * The Dynamic Group Implementation provides a grouping mechanism in
 * which the group membership is determined based on criteria defined
 * in one or more LDAP URLs.
 */
public interface DynamicGroupImplementationCfg extends GroupImplementationCfg {

  /**
   * Gets the configuration class associated with this Dynamic Group Implementation.
   *
   * @return Returns the configuration class associated with this Dynamic Group Implementation.
   */
  Class<? extends DynamicGroupImplementationCfg> configurationClass();



  /**
   * Register to be notified when this Dynamic Group Implementation is changed.
   *
   * @param listener
   *          The Dynamic Group Implementation configuration change listener.
   */
  void addDynamicChangeListener(ConfigurationChangeListener<DynamicGroupImplementationCfg> listener);



  /**
   * Deregister an existing Dynamic Group Implementation configuration change listener.
   *
   * @param listener
   *          The Dynamic Group Implementation configuration change listener.
   */
  void removeDynamicChangeListener(ConfigurationChangeListener<DynamicGroupImplementationCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Dynamic Group Implementation implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
