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
 * A server-side interface for querying Password Modify Extended
 * Operation Handler settings.
 * <p>
 * The Password Modify Extended Operation Handler allows end users to
 * change their own passwords, or administrators to reset user
 * passwords.
 */
public interface PasswordModifyExtendedOperationHandlerCfg extends ExtendedOperationHandlerCfg {

  /**
   * Gets the configuration class associated with this Password Modify Extended Operation Handler.
   *
   * @return Returns the configuration class associated with this Password Modify Extended Operation Handler.
   */
  Class<? extends PasswordModifyExtendedOperationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Password Modify Extended Operation Handler is changed.
   *
   * @param listener
   *          The Password Modify Extended Operation Handler configuration change listener.
   */
  void addPasswordModifyChangeListener(ConfigurationChangeListener<PasswordModifyExtendedOperationHandlerCfg> listener);



  /**
   * Deregister an existing Password Modify Extended Operation Handler configuration change listener.
   *
   * @param listener
   *          The Password Modify Extended Operation Handler configuration change listener.
   */
  void removePasswordModifyChangeListener(ConfigurationChangeListener<PasswordModifyExtendedOperationHandlerCfg> listener);



  /**
   * Gets the "identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper that should be used in
   * conjunction with the password modify extended operation.
   * <p>
   * This property is used to identify a user based on an
   * authorization ID in the 'u:' form. Changes to this property take
   * effect immediately.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Gets the "identity-mapper" property as a DN.
   * <p>
   * Specifies the name of the identity mapper that should be used in
   * conjunction with the password modify extended operation.
   * <p>
   * This property is used to identify a user based on an
   * authorization ID in the 'u:' form. Changes to this property take
   * effect immediately.
   *
   * @return Returns the DN value of the "identity-mapper" property.
   */
  DN getIdentityMapperDN();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Password Modify Extended Operation Handler
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
