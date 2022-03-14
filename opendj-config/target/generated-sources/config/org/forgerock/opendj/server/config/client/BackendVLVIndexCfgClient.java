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



import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.BackendVLVIndexCfgDefn.Scope;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;



/**
 * A client-side interface for reading and modifying Backend VLV Index
 * settings.
 * <p>
 * Backend VLV Indexes are used to store information about a specific
 * search request that makes it possible to efficiently process them
 * using the VLV control.
 */
public interface BackendVLVIndexCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Backend VLV Index.
   *
   * @return Returns the configuration definition associated with this Backend VLV Index.
   */
  ManagedObjectDefinition<? extends BackendVLVIndexCfgClient, ? extends BackendVLVIndexCfg> definition();



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DN used in the search query that is being
   * indexed.
   *
   * @return Returns the value of the "base-dn" property.
   */
  DN getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * Specifies the base DN used in the search query that is being
   * indexed.
   *
   * @param value The value of the "base-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBaseDN(DN value) throws PropertyException;



  /**
   * Gets the "filter" property.
   * <p>
   * Specifies the LDAP filter used in the query that is being
   * indexed.
   *
   * @return Returns the value of the "filter" property.
   */
  String getFilter();



  /**
   * Sets the "filter" property.
   * <p>
   * Specifies the LDAP filter used in the query that is being
   * indexed.
   *
   * @param value The value of the "filter" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setFilter(String value) throws PropertyException;



  /**
   * Gets the "name" property.
   * <p>
   * Specifies a unique name for this VLV index.
   *
   * @return Returns the value of the "name" property.
   */
  String getName();



  /**
   * Sets the "name" property.
   * <p>
   * Specifies a unique name for this VLV index.
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Backend VLV Index.
   *
   * @param value The value of the "name" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Backend VLV Index is not being initialized.
   */
  void setName(String value) throws PropertyException, PropertyException;



  /**
   * Gets the "scope" property.
   * <p>
   * Specifies the LDAP scope of the query that is being indexed.
   *
   * @return Returns the value of the "scope" property.
   */
  Scope getScope();



  /**
   * Sets the "scope" property.
   * <p>
   * Specifies the LDAP scope of the query that is being indexed.
   *
   * @param value The value of the "scope" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setScope(Scope value) throws PropertyException;



  /**
   * Gets the "sort-order" property.
   * <p>
   * Specifies the names of the attributes that are used to sort the
   * entries for the query being indexed.
   * <p>
   * Multiple attributes can be used to determine the sort order by
   * listing the attribute names from highest to lowest precedence.
   * Optionally, + or - can be prefixed to the attribute name to sort
   * the attribute in ascending order or descending order respectively.
   *
   * @return Returns the value of the "sort-order" property.
   */
  String getSortOrder();



  /**
   * Sets the "sort-order" property.
   * <p>
   * Specifies the names of the attributes that are used to sort the
   * entries for the query being indexed.
   * <p>
   * Multiple attributes can be used to determine the sort order by
   * listing the attribute names from highest to lowest precedence.
   * Optionally, + or - can be prefixed to the attribute name to sort
   * the attribute in ascending order or descending order respectively.
   *
   * @param value The value of the "sort-order" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSortOrder(String value) throws PropertyException;

}
