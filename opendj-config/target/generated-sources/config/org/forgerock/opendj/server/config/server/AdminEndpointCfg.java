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
 * A server-side interface for querying Admin Endpoint settings.
 * <p>
 * The Admin Endpoint provides RESTful access to OpenDJ's monitoring
 * and configuration backends.
 */
public interface AdminEndpointCfg extends HTTPEndpointCfg {

  /**
   * Gets the configuration class associated with this Admin Endpoint.
   *
   * @return Returns the configuration class associated with this Admin Endpoint.
   */
  Class<? extends AdminEndpointCfg> configurationClass();



  /**
   * Register to be notified when this Admin Endpoint is changed.
   *
   * @param listener
   *          The Admin Endpoint configuration change listener.
   */
  void addAdminEndpointChangeListener(ConfigurationChangeListener<AdminEndpointCfg> listener);



  /**
   * Deregister an existing Admin Endpoint configuration change listener.
   *
   * @param listener
   *          The Admin Endpoint configuration change listener.
   */
  void removeAdminEndpointChangeListener(ConfigurationChangeListener<AdminEndpointCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Admin Endpoint implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
