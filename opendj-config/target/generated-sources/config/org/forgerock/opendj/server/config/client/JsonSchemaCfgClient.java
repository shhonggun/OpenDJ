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
import org.forgerock.opendj.server.config.server.JsonSchemaCfg;



/**
 * A client-side interface for reading and modifying Json Schema
 * settings.
 * <p>
 * The JSON Schema Provider provides the ability to configure
 * customized JSON query matching rules.
 */
public interface JsonSchemaCfgClient extends SchemaProviderCfgClient {

  /**
   * Get the configuration definition associated with this Json Schema.
   *
   * @return Returns the configuration definition associated with this Json Schema.
   */
  ManagedObjectDefinition<? extends JsonSchemaCfgClient, ? extends JsonSchemaCfg> definition();



  /**
   * Gets the "case-sensitive-strings" property.
   * <p>
   * Indicates whether JSON string comparisons should be
   * case-sensitive.
   *
   * @return Returns the value of the "case-sensitive-strings" property.
   */
  boolean isCaseSensitiveStrings();



  /**
   * Sets the "case-sensitive-strings" property.
   * <p>
   * Indicates whether JSON string comparisons should be
   * case-sensitive.
   *
   * @param value The value of the "case-sensitive-strings" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCaseSensitiveStrings(Boolean value) throws PropertyException;



  /**
   * Gets the "ignore-white-space" property.
   * <p>
   * Indicates whether JSON string comparisons should ignore
   * white-space.
   * <p>
   * When enabled all leading and trailing white space will be removed
   * and intermediate white space will be reduced to a single
   * character.
   *
   * @return Returns the value of the "ignore-white-space" property.
   */
  boolean isIgnoreWhiteSpace();



  /**
   * Sets the "ignore-white-space" property.
   * <p>
   * Indicates whether JSON string comparisons should ignore
   * white-space.
   * <p>
   * When enabled all leading and trailing white space will be removed
   * and intermediate white space will be reduced to a single
   * character.
   *
   * @param value The value of the "ignore-white-space" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIgnoreWhiteSpace(Boolean value) throws PropertyException;



  /**
   * Gets the "indexed-field" property.
   * <p>
   * Specifies which JSON fields should be indexed.
   * <p>
   * A field will be indexed if it matches any of the configured field
   * patterns.
   *
   * @return Returns the values of the "indexed-field" property.
   */
  SortedSet<String> getIndexedField();



  /**
   * Sets the "indexed-field" property.
   * <p>
   * Specifies which JSON fields should be indexed.
   * <p>
   * A field will be indexed if it matches any of the configured field
   * patterns.
   *
   * @param values The values of the "indexed-field" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setIndexedField(Collection<String> values) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Json Schema implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Json Schema implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "matching-rule-name" property.
   * <p>
   * The name of the custom JSON matching rule.
   *
   * @return Returns the value of the "matching-rule-name" property.
   */
  String getMatchingRuleName();



  /**
   * Sets the "matching-rule-name" property.
   * <p>
   * The name of the custom JSON matching rule.
   *
   * @param value The value of the "matching-rule-name" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMatchingRuleName(String value) throws PropertyException;



  /**
   * Gets the "matching-rule-oid" property.
   * <p>
   * The numeric OID of the custom JSON matching rule.
   *
   * @return Returns the value of the "matching-rule-oid" property.
   */
  String getMatchingRuleOid();



  /**
   * Sets the "matching-rule-oid" property.
   * <p>
   * The numeric OID of the custom JSON matching rule.
   *
   * @param value The value of the "matching-rule-oid" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setMatchingRuleOid(String value) throws PropertyException;

}
