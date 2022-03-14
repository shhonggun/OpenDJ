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
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.Scope;
import org.forgerock.opendj.server.config.server.VirtualAttributeCfg;



/**
 * A client-side interface for reading and modifying Virtual Attribute
 * settings.
 * <p>
 * Virtual Attributes are responsible for dynamically generating
 * attribute values that appear in entries but are not persistently
 * stored in the backend.
 */
public interface VirtualAttributeCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Virtual Attribute.
   *
   * @return Returns the configuration definition associated with this Virtual Attribute.
   */
  ManagedObjectDefinition<? extends VirtualAttributeCfgClient, ? extends VirtualAttributeCfg> definition();



  /**
   * Gets the "attribute-type" property.
   * <p>
   * Specifies the attribute type for the attribute whose values are
   * to be dynamically assigned by the virtual attribute.
   *
   * @return Returns the value of the "attribute-type" property.
   */
  AttributeType getAttributeType();



  /**
   * Sets the "attribute-type" property.
   * <p>
   * Specifies the attribute type for the attribute whose values are
   * to be dynamically assigned by the virtual attribute.
   *
   * @param value The value of the "attribute-type" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAttributeType(AttributeType value) throws PropertyException;



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DNs for the branches containing entries that
   * are eligible to use this virtual attribute.
   * <p>
   * If no values are given, then the server generates virtual
   * attributes anywhere in the server.
   *
   * @return Returns the values of the "base-dn" property.
   */
  SortedSet<DN> getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * Specifies the base DNs for the branches containing entries that
   * are eligible to use this virtual attribute.
   * <p>
   * If no values are given, then the server generates virtual
   * attributes anywhere in the server.
   *
   * @param values The values of the "base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setBaseDN(Collection<DN> values) throws PropertyException;



  /**
   * Gets the "conflict-behavior" property.
   * <p>
   * Specifies the behavior that the server is to exhibit for entries
   * that already contain one or more real values for the associated
   * attribute.
   *
   * @return Returns the value of the "conflict-behavior" property.
   */
  ConflictBehavior getConflictBehavior();



  /**
   * Sets the "conflict-behavior" property.
   * <p>
   * Specifies the behavior that the server is to exhibit for entries
   * that already contain one or more real values for the associated
   * attribute.
   *
   * @param value The value of the "conflict-behavior" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConflictBehavior(ConflictBehavior value) throws PropertyException;



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Virtual Attribute is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the Virtual Attribute is enabled for use.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "filter" property.
   * <p>
   * Specifies the search filters to be applied against entries to
   * determine if the virtual attribute is to be generated for those
   * entries.
   * <p>
   * If no values are given, then any entry is eligible to have the
   * value generated. If one or more filters are specified, then only
   * entries that match at least one of those filters are allowed to
   * have the virtual attribute.
   *
   * @return Returns the values of the "filter" property.
   */
  SortedSet<String> getFilter();



  /**
   * Sets the "filter" property.
   * <p>
   * Specifies the search filters to be applied against entries to
   * determine if the virtual attribute is to be generated for those
   * entries.
   * <p>
   * If no values are given, then any entry is eligible to have the
   * value generated. If one or more filters are specified, then only
   * entries that match at least one of those filters are allowed to
   * have the virtual attribute.
   *
   * @param values The values of the "filter" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setFilter(Collection<String> values) throws PropertyException;



  /**
   * Gets the "group-dn" property.
   * <p>
   * Specifies the DNs of the groups whose members can be eligible to
   * use this virtual attribute.
   * <p>
   * If no values are given, then group membership is not taken into
   * account when generating the virtual attribute. If one or more
   * group DNs are specified, then only members of those groups are
   * allowed to have the virtual attribute.
   *
   * @return Returns the values of the "group-dn" property.
   */
  SortedSet<DN> getGroupDN();



  /**
   * Sets the "group-dn" property.
   * <p>
   * Specifies the DNs of the groups whose members can be eligible to
   * use this virtual attribute.
   * <p>
   * If no values are given, then group membership is not taken into
   * account when generating the virtual attribute. If one or more
   * group DNs are specified, then only members of those groups are
   * allowed to have the virtual attribute.
   *
   * @param values The values of the "group-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setGroupDN(Collection<DN> values) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "scope" property.
   * <p>
   * Specifies the LDAP scope associated with base DNs for entries
   * that are eligible to use this virtual attribute.
   *
   * @return Returns the value of the "scope" property.
   */
  Scope getScope();



  /**
   * Sets the "scope" property.
   * <p>
   * Specifies the LDAP scope associated with base DNs for entries
   * that are eligible to use this virtual attribute.
   *
   * @param value The value of the "scope" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setScope(Scope value) throws PropertyException;

}
