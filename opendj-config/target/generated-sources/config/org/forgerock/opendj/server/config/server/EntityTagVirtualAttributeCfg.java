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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.EntityTagVirtualAttributeCfgDefn.ChecksumAlgorithm;
import org.forgerock.opendj.server.config.meta.VirtualAttributeCfgDefn.ConflictBehavior;



/**
 * A server-side interface for querying Entity Tag Virtual Attribute
 * settings.
 * <p>
 * The Entity Tag Virtual Attribute ensures that all entries contain
 * an "entity tag" or "Etag" as defined in section 3.11 of RFC 2616.
 */
public interface EntityTagVirtualAttributeCfg extends VirtualAttributeCfg {

  /**
   * Gets the configuration class associated with this Entity Tag Virtual Attribute.
   *
   * @return Returns the configuration class associated with this Entity Tag Virtual Attribute.
   */
  Class<? extends EntityTagVirtualAttributeCfg> configurationClass();



  /**
   * Register to be notified when this Entity Tag Virtual Attribute is changed.
   *
   * @param listener
   *          The Entity Tag Virtual Attribute configuration change listener.
   */
  void addEntityTagChangeListener(ConfigurationChangeListener<EntityTagVirtualAttributeCfg> listener);



  /**
   * Deregister an existing Entity Tag Virtual Attribute configuration change listener.
   *
   * @param listener
   *          The Entity Tag Virtual Attribute configuration change listener.
   */
  void removeEntityTagChangeListener(ConfigurationChangeListener<EntityTagVirtualAttributeCfg> listener);



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
   * Gets the "checksum-algorithm" property.
   * <p>
   * The algorithm which should be used for calculating the entity tag
   * checksum value.
   *
   * @return Returns the value of the "checksum-algorithm" property.
   */
  ChecksumAlgorithm getChecksumAlgorithm();



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
   * Gets the "excluded-attribute" property.
   * <p>
   * The list of attributes which should be ignored when calculating
   * the entity tag checksum value.
   * <p>
   * Certain attributes like "ds-sync-hist" may vary between replicas
   * due to different purging schedules and should not be included in
   * the checksum.
   *
   * @return Returns an unmodifiable set containing the values of the "excluded-attribute" property.
   */
  SortedSet<AttributeType> getExcludedAttribute();



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
