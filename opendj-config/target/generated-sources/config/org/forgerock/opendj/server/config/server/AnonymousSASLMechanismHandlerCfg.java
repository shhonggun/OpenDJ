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
 * A server-side interface for querying Anonymous SASL Mechanism
 * Handler settings.
 * <p>
 * The ANONYMOUS SASL mechanism provides the ability for clients to
 * perform an anonymous bind using a SASL mechanism.
 */
public interface AnonymousSASLMechanismHandlerCfg extends SASLMechanismHandlerCfg {

  /**
   * Gets the configuration class associated with this Anonymous SASL Mechanism Handler.
   *
   * @return Returns the configuration class associated with this Anonymous SASL Mechanism Handler.
   */
  Class<? extends AnonymousSASLMechanismHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Anonymous SASL Mechanism Handler is changed.
   *
   * @param listener
   *          The Anonymous SASL Mechanism Handler configuration change listener.
   */
  void addAnonymousChangeListener(ConfigurationChangeListener<AnonymousSASLMechanismHandlerCfg> listener);



  /**
   * Deregister an existing Anonymous SASL Mechanism Handler configuration change listener.
   *
   * @param listener
   *          The Anonymous SASL Mechanism Handler configuration change listener.
   */
  void removeAnonymousChangeListener(ConfigurationChangeListener<AnonymousSASLMechanismHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SASL mechanism handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
