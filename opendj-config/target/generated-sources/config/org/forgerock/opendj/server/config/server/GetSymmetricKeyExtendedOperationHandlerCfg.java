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
 * A server-side interface for querying Get Symmetric Key Extended
 * Operation Handler settings.
 * <p>
 * The Get Symmetric Key Extended Operation Handler is used by the
 * OpenDJ cryptographic framework for creating and obtaining symmetric
 * encryption keys.
 */
public interface GetSymmetricKeyExtendedOperationHandlerCfg extends ExtendedOperationHandlerCfg {

  /**
   * Gets the configuration class associated with this Get Symmetric Key Extended Operation Handler.
   *
   * @return Returns the configuration class associated with this Get Symmetric Key Extended Operation Handler.
   */
  Class<? extends GetSymmetricKeyExtendedOperationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Get Symmetric Key Extended Operation Handler is changed.
   *
   * @param listener
   *          The Get Symmetric Key Extended Operation Handler configuration change listener.
   */
  void addGetSymmetricKeyChangeListener(ConfigurationChangeListener<GetSymmetricKeyExtendedOperationHandlerCfg> listener);



  /**
   * Deregister an existing Get Symmetric Key Extended Operation Handler configuration change listener.
   *
   * @param listener
   *          The Get Symmetric Key Extended Operation Handler configuration change listener.
   */
  void removeGetSymmetricKeyChangeListener(ConfigurationChangeListener<GetSymmetricKeyExtendedOperationHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Get Symmetric Key Extended Operation Handler
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
