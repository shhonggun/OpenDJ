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
import org.forgerock.opendj.server.config.server.FixedTimeLogRotationPolicyCfg;



/**
 * A client-side interface for reading and modifying Fixed Time Log
 * Rotation Policy settings.
 * <p>
 * Rotation policy based on a fixed time of day.
 */
public interface FixedTimeLogRotationPolicyCfgClient extends LogRotationPolicyCfgClient {

  /**
   * Get the configuration definition associated with this Fixed Time Log Rotation Policy.
   *
   * @return Returns the configuration definition associated with this Fixed Time Log Rotation Policy.
   */
  ManagedObjectDefinition<? extends FixedTimeLogRotationPolicyCfgClient, ? extends FixedTimeLogRotationPolicyCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Fixed Time Log Rotation Policy implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Fixed Time Log Rotation Policy implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "time-of-day" property.
   * <p>
   * Specifies the time of day at which log rotation should occur.
   *
   * @return Returns the values of the "time-of-day" property.
   */
  SortedSet<String> getTimeOfDay();



  /**
   * Sets the "time-of-day" property.
   * <p>
   * Specifies the time of day at which log rotation should occur.
   *
   * @param values The values of the "time-of-day" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setTimeOfDay(Collection<String> values) throws PropertyException;

}
