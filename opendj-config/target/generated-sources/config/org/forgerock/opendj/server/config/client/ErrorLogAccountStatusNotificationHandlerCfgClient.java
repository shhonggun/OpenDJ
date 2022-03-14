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
import org.forgerock.opendj.server.config.meta.ErrorLogAccountStatusNotificationHandlerCfgDefn.AccountStatusNotificationType;
import org.forgerock.opendj.server.config.server.ErrorLogAccountStatusNotificationHandlerCfg;



/**
 * A client-side interface for reading and modifying Error Log Account
 * Status Notification Handler settings.
 * <p>
 * The Error Log Account Status Notification Handler is a notification
 * handler that writes information to the server error log whenever an
 * appropriate account status event occurs.
 */
public interface ErrorLogAccountStatusNotificationHandlerCfgClient extends AccountStatusNotificationHandlerCfgClient {

  /**
   * Get the configuration definition associated with this Error Log Account Status Notification Handler.
   *
   * @return Returns the configuration definition associated with this Error Log Account Status Notification Handler.
   */
  ManagedObjectDefinition<? extends ErrorLogAccountStatusNotificationHandlerCfgClient, ? extends ErrorLogAccountStatusNotificationHandlerCfg> definition();



  /**
   * Gets the "account-status-notification-type" property.
   * <p>
   * Indicates which types of event can trigger an account status
   * notification.
   *
   * @return Returns the values of the "account-status-notification-type" property.
   */
  SortedSet<AccountStatusNotificationType> getAccountStatusNotificationType();



  /**
   * Sets the "account-status-notification-type" property.
   * <p>
   * Indicates which types of event can trigger an account status
   * notification.
   *
   * @param values The values of the "account-status-notification-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAccountStatusNotificationType(Collection<AccountStatusNotificationType> values) throws PropertyException;



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



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Error Log Account Status Notification Handler
   * implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
