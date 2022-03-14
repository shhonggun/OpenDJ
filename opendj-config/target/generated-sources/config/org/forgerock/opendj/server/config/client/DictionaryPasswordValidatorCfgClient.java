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
package org.forgerock.opendj.server.config.client;



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.DictionaryPasswordValidatorCfg;



/**
 * A client-side interface for reading and modifying Dictionary
 * Password Validator settings.
 * <p>
 * The Dictionary Password Validator determines whether a proposed
 * password is acceptable based on whether the given password value
 * appears in a provided dictionary file.
 */
public interface DictionaryPasswordValidatorCfgClient extends PasswordValidatorCfgClient {

  /**
   * Get the configuration definition associated with this Dictionary Password Validator.
   *
   * @return Returns the configuration definition associated with this Dictionary Password Validator.
   */
  ManagedObjectDefinition<? extends DictionaryPasswordValidatorCfgClient, ? extends DictionaryPasswordValidatorCfg> definition();



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
   * Sets the "case-sensitive-validation" property.
   * <p>
   * Indicates whether this password validator is to treat password
   * characters in a case-sensitive manner.
   * <p>
   * If it is set to true, then the validator rejects a password only
   * if it appears in the dictionary with exactly the same
   * capitalization as provided by the user.
   *
   * @param value The value of the "case-sensitive-validation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCaseSensitiveValidation(boolean value) throws PropertyException;



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
   * Sets the "check-substrings" property.
   * <p>
   * Indicates whether this password validator is to match portions of
   * the password string against dictionary words.
   * <p>
   * If "false" then only match the entire password against words
   * otherwise ("true") check whether the password contains words.
   *
   * @param value The value of the "check-substrings" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCheckSubstrings(Boolean value) throws PropertyException;



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
   * Sets the "dictionary-file" property.
   * <p>
   * Specifies the path to the file containing a list of words that
   * cannot be used as passwords.
   * <p>
   * It should be formatted with one word per line. The value can be
   * an absolute path or a path that is relative to the OpenDJ instance
   * root.
   *
   * @param value The value of the "dictionary-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDictionaryFile(String value) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



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
   * Sets the "min-substring-length" property.
   * <p>
   * Indicates the minimal length of the substring within the password
   * in case substring checking is enabled.
   * <p>
   * If "check-substrings" option is set to true, then this parameter
   * defines the length of the smallest word which should be used for
   * substring matching. Use with caution because values below 3 might
   * disqualify valid passwords.
   *
   * @param value The value of the "min-substring-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMinSubstringLength(Integer value) throws PropertyException;



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



  /**
   * Sets the "test-reversed-password" property.
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
   * @param value The value of the "test-reversed-password" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTestReversedPassword(boolean value) throws PropertyException;

}
