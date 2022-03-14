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



import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.schema.AttributeType;



/**
 * A server-side interface for querying Attribute Value Password
 * Validator settings.
 * <p>
 * The Attribute Value Password Validator attempts to determine
 * whether a proposed password is acceptable for use by determining
 * whether that password is contained in any attribute within the
 * user's entry.
 */
public interface AttributeValuePasswordValidatorCfg extends PasswordValidatorCfg {

  /**
   * Gets the configuration class associated with this Attribute Value Password Validator.
   *
   * @return Returns the configuration class associated with this Attribute Value Password Validator.
   */
  Class<? extends AttributeValuePasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Attribute Value Password Validator is changed.
   *
   * @param listener
   *          The Attribute Value Password Validator configuration change listener.
   */
  void addAttributeValueChangeListener(ConfigurationChangeListener<AttributeValuePasswordValidatorCfg> listener);



  /**
   * Deregister an existing Attribute Value Password Validator configuration change listener.
   *
   * @param listener
   *          The Attribute Value Password Validator configuration change listener.
   */
  void removeAttributeValueChangeListener(ConfigurationChangeListener<AttributeValuePasswordValidatorCfg> listener);



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
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "match-attribute" property.
   * <p>
   * Specifies the name(s) of the attribute(s) whose values should be
   * checked to determine whether they match the provided password. If
   * no values are provided, then the server checks if the proposed
   * password matches the value of any attribute in the user's entry.
   *
   * @return Returns an unmodifiable set containing the values of the "match-attribute" property.
   */
  SortedSet<AttributeType> getMatchAttribute();



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
   * Indicates whether this password validator should test the
   * reversed value of the provided password as well as the order in
   * which it was given.
   *
   * @return Returns the value of the "test-reversed-password" property.
   */
  boolean isTestReversedPassword();

}
