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
import org.forgerock.opendj.server.config.server.CharacterSetPasswordValidatorCfg;



/**
 * A client-side interface for reading and modifying Character Set
 * Password Validator settings.
 * <p>
 * The Character Set Password Validator determines whether a proposed
 * password is acceptable by checking whether it contains a sufficient
 * number of characters from one or more user-defined character sets
 * and ranges.
 */
public interface CharacterSetPasswordValidatorCfgClient extends PasswordValidatorCfgClient {

  /**
   * Get the configuration definition associated with this Character Set Password Validator.
   *
   * @return Returns the configuration definition associated with this Character Set Password Validator.
   */
  ManagedObjectDefinition<? extends CharacterSetPasswordValidatorCfgClient, ? extends CharacterSetPasswordValidatorCfg> definition();



  /**
   * Gets the "allow-unclassified-characters" property.
   * <p>
   * Indicates whether this password validator allows passwords to
   * contain characters outside of any of the user-defined character
   * sets and ranges.
   * <p>
   * If this is "false", then only those characters in the
   * user-defined character sets and ranges may be used in passwords.
   * Any password containing a character not included in any character
   * set or range will be rejected.
   *
   * @return Returns the value of the "allow-unclassified-characters" property.
   */
  Boolean isAllowUnclassifiedCharacters();



  /**
   * Sets the "allow-unclassified-characters" property.
   * <p>
   * Indicates whether this password validator allows passwords to
   * contain characters outside of any of the user-defined character
   * sets and ranges.
   * <p>
   * If this is "false", then only those characters in the
   * user-defined character sets and ranges may be used in passwords.
   * Any password containing a character not included in any character
   * set or range will be rejected.
   *
   * @param value The value of the "allow-unclassified-characters" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAllowUnclassifiedCharacters(boolean value) throws PropertyException;



  /**
   * Gets the "character-set" property.
   * <p>
   * Specifies a character set containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that set.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the set which may be zero, indicating that the
   * character set is optional) followed by a colon and the characters
   * to include in that set (for example,
   * "3:abcdefghijklmnopqrstuvwxyz" indicates that a user password must
   * contain at least three characters from the set of lowercase ASCII
   * letters). Multiple character sets can be defined in separate
   * values, although no character can appear in more than one
   * character set.
   *
   * @return Returns the values of the "character-set" property.
   */
  SortedSet<String> getCharacterSet();



  /**
   * Sets the "character-set" property.
   * <p>
   * Specifies a character set containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that set.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the set which may be zero, indicating that the
   * character set is optional) followed by a colon and the characters
   * to include in that set (for example,
   * "3:abcdefghijklmnopqrstuvwxyz" indicates that a user password must
   * contain at least three characters from the set of lowercase ASCII
   * letters). Multiple character sets can be defined in separate
   * values, although no character can appear in more than one
   * character set.
   *
   * @param values The values of the "character-set" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setCharacterSet(Collection<String> values) throws PropertyException;



  /**
   * Gets the "character-set-ranges" property.
   * <p>
   * Specifies a character range containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that range.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the range which may be zero, indicating that the
   * character range is optional) followed by a colon and one or more
   * range specifications. A range specification is 3 characters: the
   * first character allowed, a minus, and the last character allowed.
   * For example, "3:A-Za-z0-9". The ranges in each value should not
   * overlap, and the characters in each range specification should be
   * ordered.
   *
   * @return Returns the values of the "character-set-ranges" property.
   */
  SortedSet<String> getCharacterSetRanges();



  /**
   * Sets the "character-set-ranges" property.
   * <p>
   * Specifies a character range containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that range.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the range which may be zero, indicating that the
   * character range is optional) followed by a colon and one or more
   * range specifications. A range specification is 3 characters: the
   * first character allowed, a minus, and the last character allowed.
   * For example, "3:A-Za-z0-9". The ranges in each value should not
   * overlap, and the characters in each range specification should be
   * ordered.
   *
   * @param values The values of the "character-set-ranges" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setCharacterSetRanges(Collection<String> values) throws PropertyException;



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
   * Gets the "min-character-sets" property.
   * <p>
   * Specifies the minimum number of character sets and ranges that a
   * password must contain.
   * <p>
   * This property should only be used in conjunction with optional
   * character sets and ranges (those requiring zero characters). Its
   * value must include any mandatory character sets and ranges (those
   * requiring greater than zero characters). This is useful in
   * situations where a password must contain characters from mandatory
   * character sets and ranges, and characters from at least N optional
   * character sets and ranges. For example, it is quite common to
   * require that a password contains at least one non-alphanumeric
   * character as well as characters from two alphanumeric character
   * sets (lower-case, upper-case, digits). In this case, this property
   * should be set to 3.
   *
   * @return Returns the value of the "min-character-sets" property.
   */
  Integer getMinCharacterSets();



  /**
   * Sets the "min-character-sets" property.
   * <p>
   * Specifies the minimum number of character sets and ranges that a
   * password must contain.
   * <p>
   * This property should only be used in conjunction with optional
   * character sets and ranges (those requiring zero characters). Its
   * value must include any mandatory character sets and ranges (those
   * requiring greater than zero characters). This is useful in
   * situations where a password must contain characters from mandatory
   * character sets and ranges, and characters from at least N optional
   * character sets and ranges. For example, it is quite common to
   * require that a password contains at least one non-alphanumeric
   * character as well as characters from two alphanumeric character
   * sets (lower-case, upper-case, digits). In this case, this property
   * should be set to 3.
   *
   * @param value The value of the "min-character-sets" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMinCharacterSets(Integer value) throws PropertyException;

}
