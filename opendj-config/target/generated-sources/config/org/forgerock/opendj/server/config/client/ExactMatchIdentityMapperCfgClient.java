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
import org.forgerock.opendj.server.config.server.ExactMatchIdentityMapperCfg;



/**
 * A client-side interface for reading and modifying Exact Match
 * Identity Mapper settings.
 * <p>
 * The Exact Match Identity Mapper maps an identifier string to user
 * entries by searching for the entry containing a specified attribute
 * whose value is the provided identifier. For example, the username
 * provided by the client for DIGEST-MD5 authentication must match the
 * value of the uid attribute
 */
public interface ExactMatchIdentityMapperCfgClient extends IdentityMapperCfgClient {

  /**
   * Get the configuration definition associated with this Exact Match Identity Mapper.
   *
   * @return Returns the configuration definition associated with this Exact Match Identity Mapper.
   */
  ManagedObjectDefinition<? extends ExactMatchIdentityMapperCfgClient, ? extends ExactMatchIdentityMapperCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Exact Match Identity Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Exact Match Identity Mapper implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "match-attribute" property.
   * <p>
   * Specifies the attribute whose value should exactly match the ID
   * string provided to this identity mapper.
   * <p>
   * At least one value must be provided. All values must refer to the
   * name or OID of an attribute type defined in the directory server
   * schema. If multiple attributes or OIDs are provided, at least one
   * of those attributes must contain the provided ID string value in
   * exactly one entry. The internal search performed includes a
   * logical OR across all of these values.
   *
   * @return Returns the values of the "match-attribute" property.
   */
  SortedSet<AttributeType> getMatchAttribute();



  /**
   * Sets the "match-attribute" property.
   * <p>
   * Specifies the attribute whose value should exactly match the ID
   * string provided to this identity mapper.
   * <p>
   * At least one value must be provided. All values must refer to the
   * name or OID of an attribute type defined in the directory server
   * schema. If multiple attributes or OIDs are provided, at least one
   * of those attributes must contain the provided ID string value in
   * exactly one entry. The internal search performed includes a
   * logical OR across all of these values.
   *
   * @param values The values of the "match-attribute" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setMatchAttribute(Collection<AttributeType> values) throws PropertyException;



  /**
   * Gets the "match-base-dn" property.
   * <p>
   * Specifies the set of base DNs below which to search for users.
   * <p>
   * The base DNs will be used when performing searches to map the
   * provided ID string to a user entry. If multiple values are given,
   * searches are performed below all specified base DNs.
   *
   * @return Returns the values of the "match-base-dn" property.
   */
  SortedSet<DN> getMatchBaseDN();



  /**
   * Sets the "match-base-dn" property.
   * <p>
   * Specifies the set of base DNs below which to search for users.
   * <p>
   * The base DNs will be used when performing searches to map the
   * provided ID string to a user entry. If multiple values are given,
   * searches are performed below all specified base DNs.
   *
   * @param values The values of the "match-base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setMatchBaseDN(Collection<DN> values) throws PropertyException;

}
