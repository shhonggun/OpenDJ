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
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying HTTP Anonymous Authorization
 * Mechanism settings.
 * <p>
 * The HTTP Anonymous Authorization Mechanism is used to define static
 * authorization.
 */
public interface HTTPAnonymousAuthorizationMechanismCfg extends HTTPAuthorizationMechanismCfg {

  /**
   * Gets the configuration class associated with this HTTP Anonymous Authorization Mechanism.
   *
   * @return Returns the configuration class associated with this HTTP Anonymous Authorization Mechanism.
   */
  Class<? extends HTTPAnonymousAuthorizationMechanismCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Anonymous Authorization Mechanism is changed.
   *
   * @param listener
   *          The HTTP Anonymous Authorization Mechanism configuration change listener.
   */
  void addHTTPAnonymousAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPAnonymousAuthorizationMechanismCfg> listener);



  /**
   * Deregister an existing HTTP Anonymous Authorization Mechanism configuration change listener.
   *
   * @param listener
   *          The HTTP Anonymous Authorization Mechanism configuration change listener.
   */
  void removeHTTPAnonymousAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPAnonymousAuthorizationMechanismCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Anonymous Authorization Mechanism
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "user-dn" property.
   * <p>
   * The authorization DN which will be used for performing anonymous
   * operations.
   *
   * @return Returns the value of the "user-dn" property.
   */
  DN getUserDN();

}
