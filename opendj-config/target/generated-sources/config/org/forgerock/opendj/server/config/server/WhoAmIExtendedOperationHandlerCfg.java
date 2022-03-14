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
 * A server-side interface for querying Who Am I Extended Operation
 * Handler settings.
 * <p>
 * The Who Am I Extended Operation Handler provides the ability for
 * clients to request their authorization identity using the "Who Am
 * I?" extended operation as defined in RFC 4532.
 */
public interface WhoAmIExtendedOperationHandlerCfg extends ExtendedOperationHandlerCfg {

  /**
   * Gets the configuration class associated with this Who Am I Extended Operation Handler.
   *
   * @return Returns the configuration class associated with this Who Am I Extended Operation Handler.
   */
  Class<? extends WhoAmIExtendedOperationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Who Am I Extended Operation Handler is changed.
   *
   * @param listener
   *          The Who Am I Extended Operation Handler configuration change listener.
   */
  void addWhoAmIChangeListener(ConfigurationChangeListener<WhoAmIExtendedOperationHandlerCfg> listener);



  /**
   * Deregister an existing Who Am I Extended Operation Handler configuration change listener.
   *
   * @param listener
   *          The Who Am I Extended Operation Handler configuration change listener.
   */
  void removeWhoAmIChangeListener(ConfigurationChangeListener<WhoAmIExtendedOperationHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Who Am I Extended Operation Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
