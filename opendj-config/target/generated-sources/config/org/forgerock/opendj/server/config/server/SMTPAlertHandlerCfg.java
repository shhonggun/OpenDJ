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
 * A server-side interface for querying SMTP Alert Handler settings.
 * <p>
 * The SMTP Alert Handler may be used to send e-mail messages to
 * notify administrators of significant events that occur within the
 * server.
 */
public interface SMTPAlertHandlerCfg extends AlertHandlerCfg {

  /**
   * Gets the configuration class associated with this SMTP Alert Handler.
   *
   * @return Returns the configuration class associated with this SMTP Alert Handler.
   */
  Class<? extends SMTPAlertHandlerCfg> configurationClass();



  /**
   * Register to be notified when this SMTP Alert Handler is changed.
   *
   * @param listener
   *          The SMTP Alert Handler configuration change listener.
   */
  void addSMTPChangeListener(ConfigurationChangeListener<SMTPAlertHandlerCfg> listener);



  /**
   * Deregister an existing SMTP Alert Handler configuration change listener.
   *
   * @param listener
   *          The SMTP Alert Handler configuration change listener.
   */
  void removeSMTPChangeListener(ConfigurationChangeListener<SMTPAlertHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SMTP Alert Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "message-body" property.
   * <p>
   * Specifies the body that should be used for email messages
   * generated by this alert handler.
   * <p>
   * The token "%%%%alert-type%%%%" is dynamically replaced with the
   * alert type string. The token "%%%%alert-id%%%%" is dynamically
   * replaced with the alert ID value. The token
   * "%%%%alert-message%%%%" is dynamically replaced with the alert
   * message. The token "\\n" is replaced with an end-of-line marker.
   *
   * @return Returns the value of the "message-body" property.
   */
  String getMessageBody();



  /**
   * Gets the "message-subject" property.
   * <p>
   * Specifies the subject that should be used for email messages
   * generated by this alert handler.
   * <p>
   * The token "%%%%alert-type%%%%" is dynamically replaced with the
   * alert type string. The token "%%%%alert-id%%%%" is dynamically
   * replaced with the alert ID value. The token
   * "%%%%alert-message%%%%" is dynamically replaced with the alert
   * message. The token "\\n" is replaced with an end-of-line marker.
   *
   * @return Returns the value of the "message-subject" property.
   */
  String getMessageSubject();



  /**
   * Gets the "recipient-address" property.
   * <p>
   * Specifies an email address to which the messages should be sent.
   * <p>
   * Multiple values may be provided if there should be more than one
   * recipient.
   *
   * @return Returns an unmodifiable set containing the values of the "recipient-address" property.
   */
  SortedSet<String> getRecipientAddress();



  /**
   * Gets the "sender-address" property.
   * <p>
   * Specifies the email address to use as the sender for messages
   * generated by this alert handler.
   *
   * @return Returns the value of the "sender-address" property.
   */
  String getSenderAddress();

}
