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



import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;



/**
 * A server-side interface for querying Collective Attribute
 * Subentries Virtual Attribute settings.
 * <p>
 * The Collective Attribute Subentries Virtual Attribute generates a
 * virtual attribute that specifies all collective attribute subentries
 * that affect the entry.
 */
public interface CollectiveAttributeSubentriesVirtualAttributeCfg extends VirtualAttributeCfg {

  /**
   * Gets the configuration class associated with this Collective Attribute Subentries Virtual Attribute.
   *
   * @return Returns the configuration class associated with this Collective Attribute Subentries Virtual Attribute.
   */
  Class<? extends CollectiveAttributeSubentriesVirtualAttributeCfg> configurationClass();



  /**
   * Register to be notified when this Collective Attribute Subentries Virtual Attribute is changed.
   *
   * @param listener
   *          The Collective Attribute Subentries Virtual Attribute configuration change listener.
   */
  void addCollectiveAttributeSubentriesChangeListener(ConfigurationChangeListener<CollectiveAttributeSubentriesVirtualAttributeCfg> listener);



  /**
   * Deregister an existing Collective Attribute Subentries Virtual Attribute configuration change listener.
   *
   * @param listener
   *          The Collective Attribute Subentries Virtual Attribute configuration change listener.
   */
  void removeCollectiveAttributeSubentriesChangeListener(ConfigurationChangeListener<CollectiveAttributeSubentriesVirtualAttributeCfg> listener);



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
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the virtual attribute
   * provider class that generates the attribute values.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
