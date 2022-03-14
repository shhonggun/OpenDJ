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
 * A server-side interface for querying Length Based Password
 * Validator settings.
 * <p>
 * The Length Based Password Validator is used to determine whether a
 * proposed password is acceptable based on whether the number of
 * characters it contains falls within an acceptable range of values.
 */
public interface LengthBasedPasswordValidatorCfg extends PasswordValidatorCfg {

  /**
   * Gets the configuration class associated with this Length Based Password Validator.
   *
   * @return Returns the configuration class associated with this Length Based Password Validator.
   */
  Class<? extends LengthBasedPasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Length Based Password Validator is changed.
   *
   * @param listener
   *          The Length Based Password Validator configuration change listener.
   */
  void addLengthBasedChangeListener(ConfigurationChangeListener<LengthBasedPasswordValidatorCfg> listener);



  /**
   * Deregister an existing Length Based Password Validator configuration change listener.
   *
   * @param listener
   *          The Length Based Password Validator configuration change listener.
   */
  void removeLengthBasedChangeListener(ConfigurationChangeListener<LengthBasedPasswordValidatorCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "max-password-length" property.
   * <p>
   * Specifies the maximum number of characters that can be included
   * in a proposed password.
   * <p>
   * A value of zero indicates that there will be no upper bound
   * enforced. If both minimum and maximum lengths are defined, then
   * the minimum length must be less than or equal to the maximum
   * length.
   *
   * @return Returns the value of the "max-password-length" property.
   */
  int getMaxPasswordLength();



  /**
   * Gets the "min-password-length" property.
   * <p>
   * Specifies the minimum number of characters that must be included
   * in a proposed password.
   * <p>
   * A value of zero indicates that there will be no lower bound
   * enforced. If both minimum and maximum lengths are defined, then
   * the minimum length must be less than or equal to the maximum
   * length.
   *
   * @return Returns the value of the "min-password-length" property.
   */
  int getMinPasswordLength();

}
