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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.server.RegularExpressionIdentityMapperCfg;



/**
 * A client-side interface for reading and modifying Regular
 * Expression Identity Mapper settings.
 * <p>
 * The Regular Expression Identity Mapper provides a way to use a
 * regular expression to translate the provided identifier when
 * searching for the appropriate user entry.
 */
public interface RegularExpressionIdentityMapperCfgClient extends IdentityMapperCfgClient {

  /**
   * Get the configuration definition associated with this Regular Expression Identity Mapper.
   *
   * @return Returns the configuration definition associated with this Regular Expression Identity Mapper.
   */
  ManagedObjectDefinition<? extends RegularExpressionIdentityMapperCfgClient, ? extends RegularExpressionIdentityMapperCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Regular Expression Identity Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Regular Expression Identity Mapper implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "match-attribute" property.
   * <p>
   * Specifies the name or OID of the attribute whose value should
   * match the provided identifier string after it has been processed
   * by the associated regular expression.
   * <p>
   * All values must refer to the name or OID of an attribute type
   * defined in the directory server schema. If multiple attributes or
   * OIDs are provided, at least one of those attributes must contain
   * the provided ID string value in exactly one entry.
   *
   * @return Returns the values of the "match-attribute" property.
   */
  SortedSet<AttributeType> getMatchAttribute();



  /**
   * Sets the "match-attribute" property.
   * <p>
   * Specifies the name or OID of the attribute whose value should
   * match the provided identifier string after it has been processed
   * by the associated regular expression.
   * <p>
   * All values must refer to the name or OID of an attribute type
   * defined in the directory server schema. If multiple attributes or
   * OIDs are provided, at least one of those attributes must contain
   * the provided ID string value in exactly one entry.
   *
   * @param values The values of the "match-attribute" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setMatchAttribute(Collection<AttributeType> values) throws PropertyException;



  /**
   * Gets the "match-base-dn" property.
   * <p>
   * Specifies the base DN(s) that should be used when performing
   * searches to map the provided ID string to a user entry. If
   * multiple values are given, searches are performed below all the
   * specified base DNs.
   *
   * @return Returns the values of the "match-base-dn" property.
   */
  SortedSet<DN> getMatchBaseDN();



  /**
   * Sets the "match-base-dn" property.
   * <p>
   * Specifies the base DN(s) that should be used when performing
   * searches to map the provided ID string to a user entry. If
   * multiple values are given, searches are performed below all the
   * specified base DNs.
   *
   * @param values The values of the "match-base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setMatchBaseDN(Collection<DN> values) throws PropertyException;



  /**
   * Gets the "match-pattern" property.
   * <p>
   * Specifies the regular expression pattern that is used to identify
   * portions of the ID string that will be replaced.
   * <p>
   * Any portion of the ID string that matches this pattern is
   * replaced in accordance with the provided replace pattern (or is
   * removed if no replace pattern is specified). If multiple
   * substrings within the given ID string match this pattern, all
   * occurrences are replaced. If no part of the given ID string
   * matches this pattern, the ID string is not altered. Exactly one
   * match pattern value must be provided, and it must be a valid
   * regular expression as described in the API documentation for the
   * java.util.regex.Pattern class, including support for capturing
   * groups.
   *
   * @return Returns the value of the "match-pattern" property.
   */
  String getMatchPattern();



  /**
   * Sets the "match-pattern" property.
   * <p>
   * Specifies the regular expression pattern that is used to identify
   * portions of the ID string that will be replaced.
   * <p>
   * Any portion of the ID string that matches this pattern is
   * replaced in accordance with the provided replace pattern (or is
   * removed if no replace pattern is specified). If multiple
   * substrings within the given ID string match this pattern, all
   * occurrences are replaced. If no part of the given ID string
   * matches this pattern, the ID string is not altered. Exactly one
   * match pattern value must be provided, and it must be a valid
   * regular expression as described in the API documentation for the
   * java.util.regex.Pattern class, including support for capturing
   * groups.
   *
   * @param value The value of the "match-pattern" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMatchPattern(String value) throws PropertyException;



  /**
   * Gets the "replace-pattern" property.
   * <p>
   * Specifies the replacement pattern that should be used for
   * substrings in the ID string that match the provided regular
   * expression pattern.
   * <p>
   * If no replacement pattern is provided, then any matching portions
   * of the ID string will be removed (i.e., replaced with an empty
   * string). The replacement pattern may include a string from a
   * capturing group by using a dollar sign ($) followed by an integer
   * value that indicates which capturing group should be used.
   *
   * @return Returns the value of the "replace-pattern" property.
   */
  String getReplacePattern();



  /**
   * Sets the "replace-pattern" property.
   * <p>
   * Specifies the replacement pattern that should be used for
   * substrings in the ID string that match the provided regular
   * expression pattern.
   * <p>
   * If no replacement pattern is provided, then any matching portions
   * of the ID string will be removed (i.e., replaced with an empty
   * string). The replacement pattern may include a string from a
   * capturing group by using a dollar sign ($) followed by an integer
   * value that indicates which capturing group should be used.
   *
   * @param value The value of the "replace-pattern" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setReplacePattern(String value) throws PropertyException;

}
