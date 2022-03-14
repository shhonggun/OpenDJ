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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.Scope;



/**
 * A server-side interface for querying Virtual Attribute settings.
 * <p>
 * Virtual Attributes are responsible for dynamically generating
 * attribute values that appear in entries but are not persistently
 * stored in the backend.
 */
public interface VirtualAttributeCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Virtual Attribute.
   *
   * @return Returns the configuration class associated with this Virtual Attribute.
   */
  Class<? extends VirtualAttributeCfg> configurationClass();



  /**
   * Register to be notified when this Virtual Attribute is changed.
   *
   * @param listener
   *          The Virtual Attribute configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<VirtualAttributeCfg> listener);



  /**
   * Deregister an existing Virtual Attribute configuration change listener.
   *
   * @param listener
   *          The Virtual Attribute configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<VirtualAttributeCfg> listener);



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
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DNs for the branches containing entries that
   * are eligible to use this virtual attribute.
   * <p>
   * If no values are given, then the server generates virtual
   * attributes anywhere in the server.
   *
   * @return Returns an unmodifiable set containing the values of the "base-dn" property.
   */
  SortedSet<DN> getBaseDN();



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
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Virtual Attribute is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



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
   * @return Returns an unmodifiable set containing the values of the "filter" property.
   */
  SortedSet<String> getFilter();



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
   * @return Returns an unmodifiable set containing the values of the "group-dn" property.
   */
  SortedSet<DN> getGroupDN();



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
   * Gets the "scope" property.
   * <p>
   * Specifies the LDAP scope associated with base DNs for entries
   * that are eligible to use this virtual attribute.
   *
   * @return Returns the value of the "scope" property.
   */
  Scope getScope();

}
