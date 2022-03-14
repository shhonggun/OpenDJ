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
import org.forgerock.opendj.server.config.server.SizeLimitLogRetentionPolicyCfg;



/**
 * A client-side interface for reading and modifying Size Limit Log
 * Retention Policy settings.
 * <p>
 * Retention policy based on the amount of space taken by all the log
 * files on disk.
 */
public interface SizeLimitLogRetentionPolicyCfgClient extends LogRetentionPolicyCfgClient {

  /**
   * Get the configuration definition associated with this Size Limit Log Retention Policy.
   *
   * @return Returns the configuration definition associated with this Size Limit Log Retention Policy.
   */
  ManagedObjectDefinition<? extends SizeLimitLogRetentionPolicyCfgClient, ? extends SizeLimitLogRetentionPolicyCfg> definition();



  /**
   * Gets the "disk-space-used" property.
   * <p>
   * Specifies the maximum total disk space used by the log files.
   *
   * @return Returns the value of the "disk-space-used" property.
   */
  Long getDiskSpaceUsed();



  /**
   * Sets the "disk-space-used" property.
   * <p>
   * Specifies the maximum total disk space used by the log files.
   *
   * @param value The value of the "disk-space-used" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDiskSpaceUsed(long value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Size Limit Log Retention Policy implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Size Limit Log Retention Policy implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
