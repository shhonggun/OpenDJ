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
 * A server-side interface for querying Unique Characters Password
 * Validator settings.
 * <p>
 * The Unique Characters Password Validator is used to determine
 * whether a proposed password is acceptable based on the number of
 * unique characters that it contains.
 */
public interface UniqueCharactersPasswordValidatorCfg extends PasswordValidatorCfg {

  /**
   * Gets the configuration class associated with this Unique Characters Password Validator.
   *
   * @return Returns the configuration class associated with this Unique Characters Password Validator.
   */
  Class<? extends UniqueCharactersPasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Unique Characters Password Validator is changed.
   *
   * @param listener
   *          The Unique Characters Password Validator configuration change listener.
   */
  void addUniqueCharactersChangeListener(ConfigurationChangeListener<UniqueCharactersPasswordValidatorCfg> listener);



  /**
   * Deregister an existing Unique Characters Password Validator configuration change listener.
   *
   * @param listener
   *          The Unique Characters Password Validator configuration change listener.
   */
  void removeUniqueCharactersChangeListener(ConfigurationChangeListener<UniqueCharactersPasswordValidatorCfg> listener);



  /**
   * Gets the "case-sensitive-validation" property.
   * <p>
   * Indicates whether this password validator should treat password
   * characters in a case-sensitive manner.
   * <p>
   * A value of true indicates that the validator does not consider a
   * capital letter to be the same as its lower-case counterpart. A
   * value of false indicates that the validator ignores differences in
   * capitalization when looking at the number of unique characters in
   * the password.
   *
   * @return Returns the value of the "case-sensitive-validation" property.
   */
  boolean isCaseSensitiveValidation();



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
   * Gets the "min-unique-characters" property.
   * <p>
   * Specifies the minimum number of unique characters that a password
   * will be allowed to contain.
   * <p>
   * A value of zero indicates that no minimum value is enforced.
   *
   * @return Returns the value of the "min-unique-characters" property.
   */
  int getMinUniqueCharacters();

}
