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
 * A server-side interface for querying Access Control Handler
 * settings.
 * <p>
 * Access Control Handlers manage the application-wide access control.
 * The OpenDJ access control handler is defined through an extensible
 * interface, so that alternate implementations can be created. Only
 * one access control handler may be active in the server at any given
 * time.
 */
public interface AccessControlHandlerCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Access Control Handler.
   *
   * @return Returns the configuration class associated with this Access Control Handler.
   */
  Class<? extends AccessControlHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Access Control Handler is changed.
   *
   * @param listener
   *          The Access Control Handler configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<AccessControlHandlerCfg> listener);



  /**
   * Deregister an existing Access Control Handler configuration change listener.
   *
   * @param listener
   *          The Access Control Handler configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<AccessControlHandlerCfg> listener);



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Access Control Handler is enabled. If set
   * to FALSE, then no access control is enforced, and any client
   * (including unauthenticated or anonymous clients) could be allowed
   * to perform any operation if not subject to other restrictions,
   * such as those enforced by the privilege subsystem.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Access Control Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
