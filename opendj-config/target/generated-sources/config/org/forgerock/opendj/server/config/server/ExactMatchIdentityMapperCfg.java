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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;



/**
 * A server-side interface for querying Exact Match Identity Mapper
 * settings.
 * <p>
 * The Exact Match Identity Mapper maps an identifier string to user
 * entries by searching for the entry containing a specified attribute
 * whose value is the provided identifier. For example, the username
 * provided by the client for DIGEST-MD5 authentication must match the
 * value of the uid attribute
 */
public interface ExactMatchIdentityMapperCfg extends IdentityMapperCfg {

  /**
   * Gets the configuration class associated with this Exact Match Identity Mapper.
   *
   * @return Returns the configuration class associated with this Exact Match Identity Mapper.
   */
  Class<? extends ExactMatchIdentityMapperCfg> configurationClass();



  /**
   * Register to be notified when this Exact Match Identity Mapper is changed.
   *
   * @param listener
   *          The Exact Match Identity Mapper configuration change listener.
   */
  void addExactMatchChangeListener(ConfigurationChangeListener<ExactMatchIdentityMapperCfg> listener);



  /**
   * Deregister an existing Exact Match Identity Mapper configuration change listener.
   *
   * @param listener
   *          The Exact Match Identity Mapper configuration change listener.
   */
  void removeExactMatchChangeListener(ConfigurationChangeListener<ExactMatchIdentityMapperCfg> listener);



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
   * @return Returns an unmodifiable set containing the values of the "match-attribute" property.
   */
  SortedSet<AttributeType> getMatchAttribute();



  /**
   * Gets the "match-base-dn" property.
   * <p>
   * Specifies the set of base DNs below which to search for users.
   * <p>
   * The base DNs will be used when performing searches to map the
   * provided ID string to a user entry. If multiple values are given,
   * searches are performed below all specified base DNs.
   *
   * @return Returns an unmodifiable set containing the values of the "match-base-dn" property.
   */
  SortedSet<DN> getMatchBaseDN();

}
