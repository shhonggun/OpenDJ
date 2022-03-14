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
 * A server-side interface for querying Password Validator settings.
 * <p>
 * Password Validators are responsible for determining whether a
 * proposed password is acceptable for use and could include checks
 * like ensuring it meets minimum length requirements, that it has an
 * appropriate range of characters, or that it is not in the history.
 */
public interface PasswordValidatorCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Password Validator.
   *
   * @return Returns the configuration class associated with this Password Validator.
   */
  Class<? extends PasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Password Validator is changed.
   *
   * @param listener
   *          The Password Validator configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<PasswordValidatorCfg> listener);



  /**
   * Deregister an existing Password Validator configuration change listener.
   *
   * @param listener
   *          The Password Validator configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<PasswordValidatorCfg> listener);



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the password validator is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
