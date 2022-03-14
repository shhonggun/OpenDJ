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



import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.AccessControlHandlerCfg;



/**
 * A client-side interface for reading and modifying Access Control
 * Handler settings.
 * <p>
 * Access Control Handlers manage the application-wide access control.
 * The OpenDJ access control handler is defined through an extensible
 * interface, so that alternate implementations can be created. Only
 * one access control handler may be active in the server at any given
 * time.
 */
public interface AccessControlHandlerCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Access Control Handler.
   *
   * @return Returns the configuration definition associated with this Access Control Handler.
   */
  ManagedObjectDefinition<? extends AccessControlHandlerCfgClient, ? extends AccessControlHandlerCfg> definition();



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
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the Access Control Handler is enabled. If set
   * to FALSE, then no access control is enforced, and any client
   * (including unauthenticated or anonymous clients) could be allowed
   * to perform any operation if not subject to other restrictions,
   * such as those enforced by the privilege subsystem.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Access Control Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Access Control Handler implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
