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



/**
 * A server-side interface for querying Fixed Time Log Rotation Policy
 * settings.
 * <p>
 * Rotation policy based on a fixed time of day.
 */
public interface FixedTimeLogRotationPolicyCfg extends LogRotationPolicyCfg {

  /**
   * Gets the configuration class associated with this Fixed Time Log Rotation Policy.
   *
   * @return Returns the configuration class associated with this Fixed Time Log Rotation Policy.
   */
  Class<? extends FixedTimeLogRotationPolicyCfg> configurationClass();



  /**
   * Register to be notified when this Fixed Time Log Rotation Policy is changed.
   *
   * @param listener
   *          The Fixed Time Log Rotation Policy configuration change listener.
   */
  void addFixedTimeChangeListener(ConfigurationChangeListener<FixedTimeLogRotationPolicyCfg> listener);



  /**
   * Deregister an existing Fixed Time Log Rotation Policy configuration change listener.
   *
   * @param listener
   *          The Fixed Time Log Rotation Policy configuration change listener.
   */
  void removeFixedTimeChangeListener(ConfigurationChangeListener<FixedTimeLogRotationPolicyCfg> listener);



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
   * Gets the "time-of-day" property.
   * <p>
   * Specifies the time of day at which log rotation should occur.
   *
   * @return Returns an unmodifiable set containing the values of the "time-of-day" property.
   */
  SortedSet<String> getTimeOfDay();

}
