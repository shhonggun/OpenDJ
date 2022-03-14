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
 * A server-side interface for querying Cancel Extended Operation
 * Handler settings.
 * <p>
 * The Cancel Extended Operation Handler provides support for the LDAP
 * cancel extended operation as defined in RFC 3909.
 */
public interface CancelExtendedOperationHandlerCfg extends ExtendedOperationHandlerCfg {

  /**
   * Gets the configuration class associated with this Cancel Extended Operation Handler.
   *
   * @return Returns the configuration class associated with this Cancel Extended Operation Handler.
   */
  Class<? extends CancelExtendedOperationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Cancel Extended Operation Handler is changed.
   *
   * @param listener
   *          The Cancel Extended Operation Handler configuration change listener.
   */
  void addCancelChangeListener(ConfigurationChangeListener<CancelExtendedOperationHandlerCfg> listener);



  /**
   * Deregister an existing Cancel Extended Operation Handler configuration change listener.
   *
   * @param listener
   *          The Cancel Extended Operation Handler configuration change listener.
   */
  void removeCancelChangeListener(ConfigurationChangeListener<CancelExtendedOperationHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Cancel Extended Operation Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
