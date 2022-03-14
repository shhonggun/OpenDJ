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
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.BackendIndexCfgDefn.IndexType;



/**
 * A server-side interface for querying Backend Index settings.
 * <p>
 * Backend Indexes are used to store information that makes it
 * possible to locate entries very quickly when processing search
 * operations.
 */
public interface BackendIndexCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Backend Index.
   *
   * @return Returns the configuration class associated with this Backend Index.
   */
  Class<? extends BackendIndexCfg> configurationClass();



  /**
   * Register to be notified when this Backend Index is changed.
   *
   * @param listener
   *          The Backend Index configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<BackendIndexCfg> listener);



  /**
   * Deregister an existing Backend Index configuration change listener.
   *
   * @param listener
   *          The Backend Index configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<BackendIndexCfg> listener);



  /**
   * Gets the "attribute" property.
   * <p>
   * Specifies the name of the attribute for which the index is to be
   * maintained.
   *
   * @return Returns the value of the "attribute" property.
   */
  AttributeType getAttribute();



  /**
   * Gets the "confidentiality-enabled" property.
   * <p>
   * Specifies whether contents of the index should be confidential.
   * <p>
   * Setting the flag to true will hash keys for equality type indexes
   * using SHA-1 and encrypt the list of entries matching a substring
   * key for substring indexes.
   *
   * @return Returns the value of the "confidentiality-enabled" property.
   */
  boolean isConfidentialityEnabled();



  /**
   * Gets the "index-entry-limit" property.
   * <p>
   * Specifies the maximum number of entries that are allowed to match
   * a given index key before that particular index key is no longer
   * maintained.
   * <p>
   * This is analogous to the ALL IDs threshold in the Sun Java System
   * Directory Server. If this is specified, its value overrides the JE
   * backend-wide configuration. For no limit, use 0 for the value.
   *
   * @return Returns the value of the "index-entry-limit" property.
   */
  Integer getIndexEntryLimit();



  /**
   * Gets the "index-extensible-matching-rule" property.
   * <p>
   * The extensible matching rule in an extensible index.
   * <p>
   * An extensible matching rule must be specified using either LOCALE
   * or OID of the matching rule.
   *
   * @return Returns an unmodifiable set containing the values of the "index-extensible-matching-rule" property.
   */
  SortedSet<String> getIndexExtensibleMatchingRule();



  /**
   * Gets the "index-type" property.
   * <p>
   * Specifies the type(s) of indexing that should be performed for
   * the associated attribute.
   * <p>
   * For equality, presence, and substring index types, the associated
   * attribute type must have a corresponding matching rule.
   *
   * @return Returns an unmodifiable set containing the values of the "index-type" property.
   */
  SortedSet<IndexType> getIndexType();



  /**
   * Gets the "substring-length" property.
   * <p>
   * The length of substrings in a substring index.
   *
   * @return Returns the value of the "substring-length" property.
   */
  int getSubstringLength();

}
