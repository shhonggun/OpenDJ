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
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.meta.ReferentialIntegrityPluginCfgDefn.CheckReferencesScopeCriteria;
import org.forgerock.opendj.server.config.server.ReferentialIntegrityPluginCfg;



/**
 * A client-side interface for reading and modifying Referential
 * Integrity Plugin settings.
 * <p>
 * The Referential Integrity Plugin maintains referential integrity
 * for DN valued attributes.
 */
public interface ReferentialIntegrityPluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Referential Integrity Plugin.
   *
   * @return Returns the configuration definition associated with this Referential Integrity Plugin.
   */
  ManagedObjectDefinition<? extends ReferentialIntegrityPluginCfgClient, ? extends ReferentialIntegrityPluginCfg> definition();



  /**
   * Gets the "attribute-type" property.
   * <p>
   * Specifies the attribute types for which referential integrity is
   * to be maintained.
   * <p>
   * At least one attribute type must be specified, and the syntax of
   * any attributes must be either a distinguished name
   * (1.3.6.1.4.1.1466.115.121.1.12) or name and optional UID
   * (1.3.6.1.4.1.1466.115.121.1.34).
   *
   * @return Returns the values of the "attribute-type" property.
   */
  SortedSet<AttributeType> getAttributeType();



  /**
   * Sets the "attribute-type" property.
   * <p>
   * Specifies the attribute types for which referential integrity is
   * to be maintained.
   * <p>
   * At least one attribute type must be specified, and the syntax of
   * any attributes must be either a distinguished name
   * (1.3.6.1.4.1.1466.115.121.1.12) or name and optional UID
   * (1.3.6.1.4.1.1466.115.121.1.34).
   *
   * @param values The values of the "attribute-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAttributeType(Collection<AttributeType> values) throws PropertyException;



  /**
   * Gets the "base-dn" property.
   * <p>
   * Specifies the base DN that limits the scope within which
   * referential integrity is maintained.
   *
   * @return Returns the values of the "base-dn" property.
   */
  SortedSet<DN> getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * Specifies the base DN that limits the scope within which
   * referential integrity is maintained.
   *
   * @param values The values of the "base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setBaseDN(Collection<DN> values) throws PropertyException;



  /**
   * Gets the "check-references" property.
   * <p>
   * Specifies whether reference attributes must refer to existing
   * entries.
   * <p>
   * When this property is set to true, this plugin will ensure that
   * any new references added as part of an add or modify operation
   * point to existing entries, and that the referenced entries match
   * the filter criteria for the referencing attribute, if specified.
   *
   * @return Returns the value of the "check-references" property.
   */
  boolean isCheckReferences();



  /**
   * Sets the "check-references" property.
   * <p>
   * Specifies whether reference attributes must refer to existing
   * entries.
   * <p>
   * When this property is set to true, this plugin will ensure that
   * any new references added as part of an add or modify operation
   * point to existing entries, and that the referenced entries match
   * the filter criteria for the referencing attribute, if specified.
   *
   * @param value The value of the "check-references" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCheckReferences(Boolean value) throws PropertyException;



  /**
   * Gets the "check-references-filter-criteria" property.
   * <p>
   * Specifies additional filter criteria which will be enforced when
   * checking references.
   * <p>
   * If a reference attribute has filter criteria defined then this
   * plugin will ensure that any new references added as part of an add
   * or modify operation refer to an existing entry which matches the
   * specified filter.
   *
   * @return Returns the values of the "check-references-filter-criteria" property.
   */
  SortedSet<String> getCheckReferencesFilterCriteria();



  /**
   * Sets the "check-references-filter-criteria" property.
   * <p>
   * Specifies additional filter criteria which will be enforced when
   * checking references.
   * <p>
   * If a reference attribute has filter criteria defined then this
   * plugin will ensure that any new references added as part of an add
   * or modify operation refer to an existing entry which matches the
   * specified filter.
   *
   * @param values The values of the "check-references-filter-criteria" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setCheckReferencesFilterCriteria(Collection<String> values) throws PropertyException;



  /**
   * Gets the "check-references-scope-criteria" property.
   * <p>
   * Specifies whether referenced entries must reside within the same
   * naming context as the entry containing the reference.
   * <p>
   * The reference scope will only be enforced when reference checking
   * is enabled.
   *
   * @return Returns the value of the "check-references-scope-criteria" property.
   */
  CheckReferencesScopeCriteria getCheckReferencesScopeCriteria();



  /**
   * Sets the "check-references-scope-criteria" property.
   * <p>
   * Specifies whether referenced entries must reside within the same
   * naming context as the entry containing the reference.
   * <p>
   * The reference scope will only be enforced when reference checking
   * is enabled.
   *
   * @param value The value of the "check-references-scope-criteria" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCheckReferencesScopeCriteria(CheckReferencesScopeCriteria value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "log-file" property.
   * <p>
   * Specifies the log file location where the update records are
   * written when the plug-in is in background-mode processing.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "referint".
   *
   * @return Returns the value of the "log-file" property.
   */
  String getLogFile();



  /**
   * Sets the "log-file" property.
   * <p>
   * Specifies the log file location where the update records are
   * written when the plug-in is in background-mode processing.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "referint".
   *
   * @param value The value of the "log-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogFile(String value) throws PropertyException;



  /**
   * Gets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the values of the "plugin-type" property.
   */
  SortedSet<PluginType> getPluginType();



  /**
   * Sets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @param values The values of the "plugin-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPluginType(Collection<PluginType> values) throws PropertyException;



  /**
   * Gets the "update-interval" property.
   * <p>
   * Specifies the interval in seconds when referential integrity
   * updates are made.
   * <p>
   * If this value is 0, then the updates are made synchronously in
   * the foreground.
   *
   * @return Returns the value of the "update-interval" property.
   */
  long getUpdateInterval();



  /**
   * Sets the "update-interval" property.
   * <p>
   * Specifies the interval in seconds when referential integrity
   * updates are made.
   * <p>
   * If this value is 0, then the updates are made synchronously in
   * the foreground.
   *
   * @param value The value of the "update-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setUpdateInterval(Long value) throws PropertyException;

}
