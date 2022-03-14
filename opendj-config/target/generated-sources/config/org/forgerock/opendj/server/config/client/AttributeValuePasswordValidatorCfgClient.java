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



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.server.AttributeValuePasswordValidatorCfg;



/**
 * A client-side interface for reading and modifying Attribute Value
 * Password Validator settings.
 * <p>
 * The Attribute Value Password Validator attempts to determine
 * whether a proposed password is acceptable for use by determining
 * whether that password is contained in any attribute within the
 * user's entry.
 */
public interface AttributeValuePasswordValidatorCfgClient extends PasswordValidatorCfgClient {

  /**
   * Get the configuration definition associated with this Attribute Value Password Validator.
   *
   * @return Returns the configuration definition associated with this Attribute Value Password Validator.
   */
  ManagedObjectDefinition<? extends AttributeValuePasswordValidatorCfgClient, ? extends AttributeValuePasswordValidatorCfg> definition();



  /**
   * Gets the "check-substrings" property.
   * <p>
   * Indicates whether this password validator is to match portions of
   * the password string against attribute values.
   * <p>
   * If "false" then only match the entire password against attribute
   * values otherwise ("true") check whether the password contains
   * attribute values.
   *
   * @return Returns the value of the "check-substrings" property.
   */
  boolean isCheckSubstrings();



  /**
   * Sets the "check-substrings" property.
   * <p>
   * Indicates whether this password validator is to match portions of
   * the password string against attribute values.
   * <p>
   * If "false" then only match the entire password against attribute
   * values otherwise ("true") check whether the password contains
   * attribute values.
   *
   * @param value The value of the "check-substrings" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCheckSubstrings(Boolean value) throws PropertyException;



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
   * Gets the "match-attribute" property.
   * <p>
   * Specifies the name(s) of the attribute(s) whose values should be
   * checked to determine whether they match the provided password. If
   * no values are provided, then the server checks if the proposed
   * password matches the value of any attribute in the user's entry.
   *
   * @return Returns the values of the "match-attribute" property.
   */
  SortedSet<AttributeType> getMatchAttribute();



  /**
   * Sets the "match-attribute" property.
   * <p>
   * Specifies the name(s) of the attribute(s) whose values should be
   * checked to determine whether they match the provided password. If
   * no values are provided, then the server checks if the proposed
   * password matches the value of any attribute in the user's entry.
   *
   * @param values The values of the "match-attribute" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setMatchAttribute(Collection<AttributeType> values) throws PropertyException;



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
   * Indicates whether this password validator should test the
   * reversed value of the provided password as well as the order in
   * which it was given.
   *
   * @return Returns the value of the "test-reversed-password" property.
   */
  Boolean isTestReversedPassword();



  /**
   * Sets the "test-reversed-password" property.
   * <p>
   * Indicates whether this password validator should test the
   * reversed value of the provided password as well as the order in
   * which it was given.
   *
   * @param value The value of the "test-reversed-password" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTestReversedPassword(boolean value) throws PropertyException;

}
