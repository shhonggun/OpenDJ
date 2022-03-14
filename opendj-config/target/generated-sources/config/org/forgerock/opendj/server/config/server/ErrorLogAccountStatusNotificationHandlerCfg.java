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
import org.forgerock.opendj.server.config.meta.ErrorLogAccountStatusNotificationHandlerCfgDefn.AccountStatusNotificationType;



/**
 * A server-side interface for querying Error Log Account Status
 * Notification Handler settings.
 * <p>
 * The Error Log Account Status Notification Handler is a notification
 * handler that writes information to the server error log whenever an
 * appropriate account status event occurs.
 */
public interface ErrorLogAccountStatusNotificationHandlerCfg extends AccountStatusNotificationHandlerCfg {

  /**
   * Gets the configuration class associated with this Error Log Account Status Notification Handler.
   *
   * @return Returns the configuration class associated with this Error Log Account Status Notification Handler.
   */
  Class<? extends ErrorLogAccountStatusNotificationHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Error Log Account Status Notification Handler is changed.
   *
   * @param listener
   *          The Error Log Account Status Notification Handler configuration change listener.
   */
  void addErrorLogChangeListener(ConfigurationChangeListener<ErrorLogAccountStatusNotificationHandlerCfg> listener);



  /**
   * Deregister an existing Error Log Account Status Notification Handler configuration change listener.
   *
   * @param listener
   *          The Error Log Account Status Notification Handler configuration change listener.
   */
  void removeErrorLogChangeListener(ConfigurationChangeListener<ErrorLogAccountStatusNotificationHandlerCfg> listener);



  /**
   * Gets the "account-status-notification-type" property.
   * <p>
   * Indicates which types of event can trigger an account status
   * notification.
   *
   * @return Returns an unmodifiable set containing the values of the "account-status-notification-type" property.
   */
  SortedSet<AccountStatusNotificationType> getAccountStatusNotificationType();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Error Log Account Status Notification Handler
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
