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
import org.forgerock.opendj.server.config.server.JsonFileAccessLogPublisherCfg;



/**
 * A client-side interface for reading and modifying Json File Access
 * Log Publisher settings.
 * <p>
 * Json File Access Log Publishers Publish access messages to Json
 * files.
 */
public interface JsonFileAccessLogPublisherCfgClient extends AccessLogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this Json File Access Log Publisher.
   *
   * @return Returns the configuration definition associated with this Json File Access Log Publisher.
   */
  ManagedObjectDefinition<? extends JsonFileAccessLogPublisherCfgClient, ? extends JsonFileAccessLogPublisherCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the Json
   * File Access Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the Json
   * File Access Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "log-control-oids" property.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @return Returns the value of the "log-control-oids" property.
   */
  boolean isLogControlOids();



  /**
   * Sets the "log-control-oids" property.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @param value The value of the "log-control-oids" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogControlOids(Boolean value) throws PropertyException;



  /**
   * Gets the "log-directory" property.
   * <p>
   * The directory to use for the log files generated by the Json File
   * Access Log Publisher. The path to the directory is relative to the
   * server root.
   *
   * @return Returns the value of the "log-directory" property.
   */
  String getLogDirectory();



  /**
   * Sets the "log-directory" property.
   * <p>
   * The directory to use for the log files generated by the Json File
   * Access Log Publisher. The path to the directory is relative to the
   * server root.
   *
   * @param value The value of the "log-directory" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogDirectory(String value) throws PropertyException;



  /**
   * Gets the "retention-policy" property.
   * <p>
   * The retention policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @return Returns the values of the "retention-policy" property.
   */
  SortedSet<String> getRetentionPolicy();



  /**
   * Sets the "retention-policy" property.
   * <p>
   * The retention policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @param values The values of the "retention-policy" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRetentionPolicy(Collection<String> values) throws PropertyException;



  /**
   * Gets the "rotation-policy" property.
   * <p>
   * The rotation policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @return Returns the values of the "rotation-policy" property.
   */
  SortedSet<String> getRotationPolicy();



  /**
   * Sets the "rotation-policy" property.
   * <p>
   * The rotation policy to use for the Json File Access Log
   * Publisher.
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @param values The values of the "rotation-policy" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRotationPolicy(Collection<String> values) throws PropertyException;

}
