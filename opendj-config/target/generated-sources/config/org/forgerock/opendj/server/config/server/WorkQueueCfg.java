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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Work Queue settings.
 * <p>
 * The Work Queue provides the configuration for the server work queue
 * and is responsible for ensuring that requests received from clients
 * are processed in a timely manner.
 */
public interface WorkQueueCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Work Queue.
   *
   * @return Returns the configuration class associated with this Work Queue.
   */
  Class<? extends WorkQueueCfg> configurationClass();



  /**
   * Register to be notified when this Work Queue is changed.
   *
   * @param listener
   *          The Work Queue configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<WorkQueueCfg> listener);



  /**
   * Deregister an existing Work Queue configuration change listener.
   *
   * @param listener
   *          The Work Queue configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<WorkQueueCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Work Queue implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
