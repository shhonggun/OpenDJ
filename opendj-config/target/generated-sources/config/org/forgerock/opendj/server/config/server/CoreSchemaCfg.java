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
import org.forgerock.opendj.server.config.meta.CoreSchemaCfgDefn.JsonValidationPolicy;



/**
 * A server-side interface for querying Core Schema settings.
 * <p>
 * Core Schema define the core schema elements to load.
 */
public interface CoreSchemaCfg extends SchemaProviderCfg {

  /**
   * Gets the configuration class associated with this Core Schema.
   *
   * @return Returns the configuration class associated with this Core Schema.
   */
  Class<? extends CoreSchemaCfg> configurationClass();



  /**
   * Register to be notified when this Core Schema is changed.
   *
   * @param listener
   *          The Core Schema configuration change listener.
   */
  void addCoreSchemaChangeListener(ConfigurationChangeListener<CoreSchemaCfg> listener);



  /**
   * Deregister an existing Core Schema configuration change listener.
   *
   * @param listener
   *          The Core Schema configuration change listener.
   */
  void removeCoreSchemaChangeListener(ConfigurationChangeListener<CoreSchemaCfg> listener);



  /**
   * Gets the "allow-attribute-types-with-no-sup-or-syntax" property.
   * <p>
   * Indicates whether the schema should allow attribute type
   * definitions that do not declare a superior attribute type or
   * syntax
   * <p>
   * When set to true, invalid attribute type definitions will use the
   * default syntax.
   *
   * @return Returns the value of the "allow-attribute-types-with-no-sup-or-syntax" property.
   */
  boolean isAllowAttributeTypesWithNoSupOrSyntax();



  /**
   * Gets the "allow-zero-length-values-directory-string" property.
   * <p>
   * Indicates whether zero-length (that is, an empty string) values
   * are allowed for directory string.
   * <p>
   * This is technically not allowed by the revised LDAPv3
   * specification, but some environments may require it for backward
   * compatibility with servers that do allow it.
   *
   * @return Returns the value of the "allow-zero-length-values-directory-string" property.
   */
  boolean isAllowZeroLengthValuesDirectoryString();



  /**
   * Gets the "disabled-matching-rule" property.
   * <p>
   * The set of disabled matching rules.
   * <p>
   * Matching rules must be specified using the syntax: OID, or use
   * the default value 'NONE' to specify no value.
   *
   * @return Returns an unmodifiable set containing the values of the "disabled-matching-rule" property.
   */
  SortedSet<String> getDisabledMatchingRule();



  /**
   * Gets the "disabled-syntax" property.
   * <p>
   * The set of disabled syntaxes.
   * <p>
   * Syntaxes must be specified using the syntax: OID, or use the
   * default value 'NONE' to specify no value.
   *
   * @return Returns an unmodifiable set containing the values of the "disabled-syntax" property.
   */
  SortedSet<String> getDisabledSyntax();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Core Schema implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "json-validation-policy" property.
   * <p>
   * Specifies the policy that will be used when validating JSON
   * syntax values.
   *
   * @return Returns the value of the "json-validation-policy" property.
   */
  JsonValidationPolicy getJsonValidationPolicy();



  /**
   * Gets the "strict-format-certificates" property.
   * <p>
   * Indicates whether X.509 Certificate values are required to
   * strictly comply with the standard definition for this syntax.
   * <p>
   * When set to false, certificates will not be validated and, as a
   * result any sequence of bytes will be acceptable.
   *
   * @return Returns the value of the "strict-format-certificates" property.
   */
  boolean isStrictFormatCertificates();



  /**
   * Gets the "strict-format-country-string" property.
   * <p>
   * Indicates whether country code values are required to strictly
   * comply with the standard definition for this syntax.
   * <p>
   * When set to false, country codes will not be validated and, as a
   * result any string containing 2 characters will be acceptable.
   *
   * @return Returns the value of the "strict-format-country-string" property.
   */
  boolean isStrictFormatCountryString();



  /**
   * Gets the "strict-format-jpeg-photos" property.
   * <p>
   * Indicates whether to require JPEG values to strictly comply with
   * the standard definition for this syntax.
   *
   * @return Returns the value of the "strict-format-jpeg-photos" property.
   */
  boolean isStrictFormatJPEGPhotos();



  /**
   * Gets the "strict-format-telephone-numbers" property.
   * <p>
   * Indicates whether to require telephone number values to strictly
   * comply with the standard definition for this syntax.
   *
   * @return Returns the value of the "strict-format-telephone-numbers" property.
   */
  boolean isStrictFormatTelephoneNumbers();



  /**
   * Gets the "strip-syntax-min-upper-bound-attribute-type-description" property.
   * <p>
   * Indicates whether the suggested minimum upper bound appended to
   * an attribute's syntax OID in it's schema definition Attribute Type
   * Description is stripped off.
   * <p>
   * When retrieving the server's schema, some APIs (JNDI) fail in
   * their syntax lookup methods, because they do not parse this value
   * correctly. This configuration option allows the server to be
   * configured to provide schema definitions these APIs can parse
   * correctly.
   *
   * @return Returns the value of the "strip-syntax-min-upper-bound-attribute-type-description" property.
   */
  boolean isStripSyntaxMinUpperBoundAttributeTypeDescription();

}
