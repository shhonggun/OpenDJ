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
 * A server-side interface for querying Dictionary Password Validator
 * settings.
 * <p>
 * The Dictionary Password Validator determines whether a proposed
 * password is acceptable based on whether the given password value
 * appears in a provided dictionary file.
 */
public interface DictionaryPasswordValidatorCfg extends PasswordValidatorCfg {

  /**
   * Gets the configuration class associated with this Dictionary Password Validator.
   *
   * @return Returns the configuration class associated with this Dictionary Password Validator.
   */
  Class<? extends DictionaryPasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Dictionary Password Validator is changed.
   *
   * @param listener
   *          The Dictionary Password Validator configuration change listener.
   */
  void addDictionaryChangeListener(ConfigurationChangeListener<DictionaryPasswordValidatorCfg> listener);



  /**
   * Deregister an existing Dictionary Password Validator configuration change listener.
   *
   * @param listener
   *          The Dictionary Password Validator configuration change listener.
   */
  void removeDictionaryChangeListener(ConfigurationChangeListener<DictionaryPasswordValidatorCfg> listener);



  /**
   * Gets the "case-sensitive-validation" property.
   * <p>
   * Indicates whether this password validator is to treat password
   * characters in a case-sensitive manner.
   * <p>
   * If it is set to true, then the validator rejects a password only
   * if it appears in the dictionary with exactly the same
   * capitalization as provided by the user.
   *
   * @return Returns the value of the "case-sensitive-validation" property.
   */
  boolean isCaseSensitiveValidation();



  /**
   * Gets the "check-substrings" property.
   * <p>
   * Indicates whether this password validator is to match portions of
   * the password string against dictionary words.
   * <p>
   * If "false" then only match the entire password against words
   * otherwise ("true") check whether the password contains words.
   *
   * @return Returns the value of the "check-substrings" property.
   */
  boolean isCheckSubstrings();



  /**
   * Gets the "dictionary-file" property.
   * <p>
   * Specifies the path to the file containing a list of words that
   * cannot be used as passwords.
   * <p>
   * It should be formatted with one word per line. The value can be
   * an absolute path or a path that is relative to the OpenDJ instance
   * root.
   *
   * @return Returns the value of the "dictionary-file" property.
   */
  String getDictionaryFile();



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
   * Gets the "min-substring-length" property.
   * <p>
   * Indicates the minimal length of the substring within the password
   * in case substring checking is enabled.
   * <p>
   * If "check-substrings" option is set to true, then this parameter
   * defines the length of the smallest word which should be used for
   * substring matching. Use with caution because values below 3 might
   * disqualify valid passwords.
   *
   * @return Returns the value of the "min-substring-length" property.
   */
  int getMinSubstringLength();



  /**
   * Gets the "test-reversed-password" property.
   * <p>
   * Indicates whether this password validator is to test the reversed
   * value of the provided password as well as the order in which it
   * was given.
   * <p>
   * For example, if the user provides a new password of "password"
   * and this configuration attribute is set to true, then the value
   * "drowssap" is also tested against attribute values in the user's
   * entry.
   *
   * @return Returns the value of the "test-reversed-password" property.
   */
  boolean isTestReversedPassword();

}
