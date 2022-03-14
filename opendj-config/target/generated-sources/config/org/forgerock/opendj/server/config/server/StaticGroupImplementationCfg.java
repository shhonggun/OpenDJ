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
 * A server-side interface for querying Static Group Implementation
 * settings.
 * <p>
 * The Static Group Implementation provides a grouping mechanism in
 * which the group membership is based on an explicit list of the DNs
 * of the users that are members of the group.
 */
public interface StaticGroupImplementationCfg extends GroupImplementationCfg {

  /**
   * Gets the configuration class associated with this Static Group Implementation.
   *
   * @return Returns the configuration class associated with this Static Group Implementation.
   */
  Class<? extends StaticGroupImplementationCfg> configurationClass();



  /**
   * Register to be notified when this Static Group Implementation is changed.
   *
   * @param listener
   *          The Static Group Implementation configuration change listener.
   */
  void addStaticChangeListener(ConfigurationChangeListener<StaticGroupImplementationCfg> listener);



  /**
   * Deregister an existing Static Group Implementation configuration change listener.
   *
   * @param listener
   *          The Static Group Implementation configuration change listener.
   */
  void removeStaticChangeListener(ConfigurationChangeListener<StaticGroupImplementationCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Static Group Implementation implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
