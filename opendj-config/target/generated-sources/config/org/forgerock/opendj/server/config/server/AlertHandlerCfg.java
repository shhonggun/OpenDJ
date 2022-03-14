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



/**
 * A server-side interface for querying Alert Handler settings.
 * <p>
 * Alert Handlers are used to notify administrators of significant
 * problems or notable events that occur in the OpenDJ directory
 * server.
 */
public interface AlertHandlerCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Alert Handler.
   *
   * @return Returns the configuration class associated with this Alert Handler.
   */
  Class<? extends AlertHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Alert Handler is changed.
   *
   * @param listener
   *          The Alert Handler configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<AlertHandlerCfg> listener);



  /**
   * Deregister an existing Alert Handler configuration change listener.
   *
   * @param listener
   *          The Alert Handler configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<AlertHandlerCfg> listener);



  /**
   * Gets the "disabled-alert-type" property.
   * <p>
   * Specifies the names of the alert types that are disabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then no alerts with
   * any of the specified types are allowed. If there are no values for
   * this attribute, then only alerts with a type included in the set
   * of enabled alert types are allowed, or if there are no values for
   * the enabled alert types option, then all alert types are allowed.
   *
   * @return Returns an unmodifiable set containing the values of the "disabled-alert-type" property.
   */
  SortedSet<String> getDisabledAlertType();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Alert Handler is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "enabled-alert-type" property.
   * <p>
   * Specifies the names of the alert types that are enabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then only alerts with
   * one of the specified types are allowed (unless they are also
   * included in the disabled alert types). If there are no values for
   * this attribute, then any alert with a type not included in the
   * list of disabled alert types is allowed.
   *
   * @return Returns an unmodifiable set containing the values of the "enabled-alert-type" property.
   */
  SortedSet<String> getEnabledAlertType();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Alert Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
