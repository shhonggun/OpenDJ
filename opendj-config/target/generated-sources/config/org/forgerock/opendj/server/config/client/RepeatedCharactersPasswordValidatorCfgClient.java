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
import org.forgerock.opendj.server.config.server.RepeatedCharactersPasswordValidatorCfg;



/**
 * A client-side interface for reading and modifying Repeated
 * Characters Password Validator settings.
 * <p>
 * The Repeated Characters Password Validator is used to determine
 * whether a proposed password is acceptable based on the number of
 * times any character appears consecutively in a password value.
 */
public interface RepeatedCharactersPasswordValidatorCfgClient extends PasswordValidatorCfgClient {

  /**
   * Get the configuration definition associated with this Repeated Characters Password Validator.
   *
   * @return Returns the configuration definition associated with this Repeated Characters Password Validator.
   */
  ManagedObjectDefinition<? extends RepeatedCharactersPasswordValidatorCfgClient, ? extends RepeatedCharactersPasswordValidatorCfg> definition();



  /**
   * Gets the "case-sensitive-validation" property.
   * <p>
   * Indicates whether this password validator should treat password
   * characters in a case-sensitive manner.
   * <p>
   * If the value of this property is false, the validator ignores any
   * differences in capitalization when looking for consecutive
   * characters in the password. If the value is true, the validator
   * considers a character to be repeating only if all consecutive
   * occurrences use the same capitalization.
   *
   * @return Returns the value of the "case-sensitive-validation" property.
   */
  Boolean isCaseSensitiveValidation();



  /**
   * Sets the "case-sensitive-validation" property.
   * <p>
   * Indicates whether this password validator should treat password
   * characters in a case-sensitive manner.
   * <p>
   * If the value of this property is false, the validator ignores any
   * differences in capitalization when looking for consecutive
   * characters in the password. If the value is true, the validator
   * considers a character to be repeating only if all consecutive
   * occurrences use the same capitalization.
   *
   * @param value The value of the "case-sensitive-validation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCaseSensitiveValidation(boolean value) throws PropertyException;



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
   * Gets the "max-consecutive-length" property.
   * <p>
   * Specifies the maximum number of times that any character can
   * appear consecutively in a password value.
   * <p>
   * A value of zero indicates that no maximum limit is enforced.
   *
   * @return Returns the value of the "max-consecutive-length" property.
   */
  Integer getMaxConsecutiveLength();



  /**
   * Sets the "max-consecutive-length" property.
   * <p>
   * Specifies the maximum number of times that any character can
   * appear consecutively in a password value.
   * <p>
   * A value of zero indicates that no maximum limit is enforced.
   *
   * @param value The value of the "max-consecutive-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMaxConsecutiveLength(int value) throws PropertyException;

}
