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
 * A server-side interface for querying Start TLS Extended Operation
 * Handler settings.
 * <p>
 * The Start TLS Extended Operation Handler provides the ability
 * clients to use the StartTLS extended operation to initiate a secure
 * communication channel over an otherwise clear-text LDAP connection.
 */
public interface StartTLSExtendedOperationHandlerCfg extends ExtendedOperationHandlerCfg {

  /**
   * Gets the configuration class associated with this Start TLS Extended Operation Handler.
   *
   * @return Returns the configuration class associated with this Start TLS Extended Operation Handler.
   */
  Class<? extends StartTLSExtendedOperationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Start TLS Extended Operation Handler is changed.
   *
   * @param listener
   *          The Start TLS Extended Operation Handler configuration change listener.
   */
  void addStartTLSChangeListener(ConfigurationChangeListener<StartTLSExtendedOperationHandlerCfg> listener);



  /**
   * Deregister an existing Start TLS Extended Operation Handler configuration change listener.
   *
   * @param listener
   *          The Start TLS Extended Operation Handler configuration change listener.
   */
  void removeStartTLSChangeListener(ConfigurationChangeListener<StartTLSExtendedOperationHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Start TLS Extended Operation Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}