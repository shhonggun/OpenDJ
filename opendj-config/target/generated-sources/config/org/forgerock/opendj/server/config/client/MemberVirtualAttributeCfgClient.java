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



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;
import org.forgerock.opendj.server.config.server.MemberVirtualAttributeCfg;



/**
 * A client-side interface for reading and modifying Member Virtual
 * Attribute settings.
 * <p>
 * The Member Virtual Attribute generates a member or uniqueMember
 * attribute whose values are the DNs of the members of a specified
 * virtual static group.
 */
public interface MemberVirtualAttributeCfgClient extends VirtualAttributeCfgClient {

  /**
   * Get the configuration definition associated with this Member Virtual Attribute.
   *
   * @return Returns the configuration definition associated with this Member Virtual Attribute.
   */
  ManagedObjectDefinition<? extends MemberVirtualAttributeCfgClient, ? extends MemberVirtualAttributeCfg> definition();



  /**
   * Gets the "allow-retrieving-membership" property.
   * <p>
   * Indicates whether to handle requests that request all values for
   * the virtual attribute.
   * <p>
   * This operation can be very expensive in some cases and is not
   * consistent with the primary function of virtual static groups,
   * which is to make it possible to use static group idioms to
   * determine whether a given user is a member. If this attribute is
   * set to false, attempts to retrieve the entire set of values
   * receive an empty set, and only attempts to determine whether the
   * attribute has a specific value or set of values (which is the
   * primary anticipated use for virtual static groups) are handled
   * properly.
   *
   * @return Returns the value of the "allow-retrieving-membership" property.
   */
  boolean isAllowRetrievingMembership();



  /**
   * Sets the "allow-retrieving-membership" property.
   * <p>
   * Indicates whether to handle requests that request all values for
   * the virtual attribute.
   * <p>
   * This operation can be very expensive in some cases and is not
   * consistent with the primary function of virtual static groups,
   * which is to make it possible to use static group idioms to
   * determine whether a given user is a member. If this attribute is
   * set to false, attempts to retrieve the entire set of values
   * receive an empty set, and only attempts to determine whether the
   * attribute has a specific value or set of values (which is the
   * primary anticipated use for virtual static groups) are handled
   * properly.
   *
   * @param value The value of the "allow-retrieving-membership" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAllowRetrievingMembership(boolean value) throws PropertyException;



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

}
