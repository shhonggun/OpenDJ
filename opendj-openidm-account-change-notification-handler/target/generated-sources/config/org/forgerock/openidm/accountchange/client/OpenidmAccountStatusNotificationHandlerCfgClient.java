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
package org.forgerock.openidm.accountchange.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.AccountStatusNotificationHandlerCfgClient;
import org.forgerock.openidm.accountchange.meta.OpenidmAccountStatusNotificationHandlerCfgDefn.OpenidmCompatMode;
import org.forgerock.openidm.accountchange.server.OpenidmAccountStatusNotificationHandlerCfg;



/**
 * A client-side interface for reading and modifying Openidm Account
 * Status Notification Handler settings.
 * <p>
 * The Openidm Account Status Notification Handler is an account
 * status notification handler that listens to two kind of changes:
 * password change and password reset. The changes are either
 * immediately sent to OpenIDM or first stored locally and sent later
 * to OpenIDM at the provided interval. The communication with OpenIDM
 * is done through HTTP or HTTPS, with optional SSL client
 * authentication.
 */
public interface OpenidmAccountStatusNotificationHandlerCfgClient extends AccountStatusNotificationHandlerCfgClient {

  /**
   * Get the configuration definition associated with this Openidm Account Status Notification Handler.
   *
   * @return Returns the configuration definition associated with this Openidm Account Status Notification Handler.
   */
  ManagedObjectDefinition<? extends OpenidmAccountStatusNotificationHandlerCfgClient, ? extends OpenidmAccountStatusNotificationHandlerCfg> definition();



  /**
   * Gets the "attribute-type" property.
   * <p>
   * Specifies the attribute types that this plug-in will send along
   * with the password change.
   * <p>
   * Zero or more attribute types can be specified.
   *
   * @return Returns the values of the "attribute-type" property.
   */
  SortedSet<AttributeType> getAttributeType();



  /**
   * Sets the "attribute-type" property.
   * <p>
   * Specifies the attribute types that this plug-in will send along
   * with the password change.
   * <p>
   * Zero or more attribute types can be specified.
   *
   * @param values The values of the "attribute-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAttributeType(Collection<AttributeType> values) throws PropertyException;



  /**
   * Gets the "certificate-subject-dn" property.
   * <p>
   * Specifies the subject DN of the certificate used by OpenIDM.
   * <p>
   * The subject DN is used to retrieve the OpenIDM certificate in the
   * truststore. This certificate's public key is necessary to encrypt
   * the JSON content sent to OpenIDM.
   *
   * @return Returns the value of the "certificate-subject-dn" property.
   */
  DN getCertificateSubjectDN();



  /**
   * Sets the "certificate-subject-dn" property.
   * <p>
   * Specifies the subject DN of the certificate used by OpenIDM.
   * <p>
   * The subject DN is used to retrieve the OpenIDM certificate in the
   * truststore. This certificate's public key is necessary to encrypt
   * the JSON content sent to OpenIDM.
   *
   * @param value The value of the "certificate-subject-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCertificateSubjectDN(DN value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Openidm Account Status Notification Handler
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Openidm Account Status Notification Handler
   * implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this Openidm Account Status Notification Handler.
   * <p>
   * It must be provided when ssl-cert-nickname is provided, and must
   * contain a certificate corresponding to the nickname.
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Sets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this Openidm Account Status Notification Handler.
   * <p>
   * It must be provided when ssl-cert-nickname is provided, and must
   * contain a certificate corresponding to the nickname.
   *
   * @param value The value of the "key-manager-provider" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyManagerProvider(String value) throws PropertyException;



  /**
   * Gets the "log-file" property.
   * <p>
   * Specifies the log file location where the changed passwords are
   * written when the plug-in cannot contact OpenIDM.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "pwsync". Passwords in this file
   * will be encrypted.
   *
   * @return Returns the value of the "log-file" property.
   */
  String getLogFile();



  /**
   * Sets the "log-file" property.
   * <p>
   * Specifies the log file location where the changed passwords are
   * written when the plug-in cannot contact OpenIDM.
   * <p>
   * The default location is the logs directory of the server
   * instance, using the file name "pwsync". Passwords in this file
   * will be encrypted.
   *
   * @param value The value of the "log-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setLogFile(String value) throws PropertyException;



  /**
   * Gets the "openidm-compat-mode" property.
   * <p>
   * Specifies OpenIDM Compatibility Mode.
   *
   * @return Returns the value of the "openidm-compat-mode" property.
   */
  OpenidmCompatMode getOpenidmCompatMode();



  /**
   * Sets the "openidm-compat-mode" property.
   * <p>
   * Specifies OpenIDM Compatibility Mode.
   *
   * @param value The value of the "openidm-compat-mode" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOpenidmCompatMode(OpenidmCompatMode value) throws PropertyException;



  /**
   * Gets the "openidm-password" property.
   * <p>
   * Specifies the password to use for HTTP Basic Authentication.
   * <p>
   * The password must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @return Returns the value of the "openidm-password" property.
   */
  String getOpenidmPassword();



  /**
   * Sets the "openidm-password" property.
   * <p>
   * Specifies the password to use for HTTP Basic Authentication.
   * <p>
   * The password must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @param value The value of the "openidm-password" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOpenidmPassword(String value) throws PropertyException;



  /**
   * Gets the "openidm-url" property.
   * <p>
   * Specifies the URL to OpenIDM endpoint.
   * <p>
   * The URL can be either HTTP or HTTPS.
   *
   * @return Returns the value of the "openidm-url" property.
   */
  String getOpenidmUrl();



  /**
   * Sets the "openidm-url" property.
   * <p>
   * Specifies the URL to OpenIDM endpoint.
   * <p>
   * The URL can be either HTTP or HTTPS.
   *
   * @param value The value of the "openidm-url" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOpenidmUrl(String value) throws PropertyException;



  /**
   * Gets the "openidm-username" property.
   * <p>
   * Specifies the username to use for HTTP Basic Authentication.
   * <p>
   * The username must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @return Returns the value of the "openidm-username" property.
   */
  String getOpenidmUsername();



  /**
   * Sets the "openidm-username" property.
   * <p>
   * Specifies the username to use for HTTP Basic Authentication.
   * <p>
   * The username must be provided when client certification is not
   * activated, i.e. when no ssl-cert-nickname is provided.
   *
   * @param value The value of the "openidm-username" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOpenidmUsername(String value) throws PropertyException;



  /**
   * Gets the "password-attribute" property.
   * <p>
   * Specifies the attribute type used to hold user passwords in JSON
   * returned to OpenIDM.
   * <p>
   * This attribute type must be defined in the managed object schema
   * in OpenIDM, and it must have either the user password or auth
   * password syntax.
   *
   * @return Returns the value of the "password-attribute" property.
   */
  String getPasswordAttribute();



  /**
   * Sets the "password-attribute" property.
   * <p>
   * Specifies the attribute type used to hold user passwords in JSON
   * returned to OpenIDM.
   * <p>
   * This attribute type must be defined in the managed object schema
   * in OpenIDM, and it must have either the user password or auth
   * password syntax.
   *
   * @param value The value of the "password-attribute" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPasswordAttribute(String value) throws PropertyException;



  /**
   * Gets the "private-key-alias" property.
   * <p>
   * Specifies the alias of the private key that should be used by
   * OpenIDM to decrypt the encrypted JSON content of the requests.
   * <p>
   * The encryption of the JSON content sent to OpenIDM requires this
   * alias.
   *
   * @return Returns the value of the "private-key-alias" property.
   */
  String getPrivateKeyAlias();



  /**
   * Sets the "private-key-alias" property.
   * <p>
   * Specifies the alias of the private key that should be used by
   * OpenIDM to decrypt the encrypted JSON content of the requests.
   * <p>
   * The encryption of the JSON content sent to OpenIDM requires this
   * alias.
   *
   * @param value The value of the "private-key-alias" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPrivateKeyAlias(String value) throws PropertyException;



  /**
   * Gets the "query-id" property.
   * <p>
   * Specifies the query-id for the patch-by-query request.
   * <p>
   * This must match the query ID defined in the managed object
   * service in OpenIDM.
   *
   * @return Returns the value of the "query-id" property.
   */
  String getQueryId();



  /**
   * Sets the "query-id" property.
   * <p>
   * Specifies the query-id for the patch-by-query request.
   * <p>
   * This must match the query ID defined in the managed object
   * service in OpenIDM.
   *
   * @param value The value of the "query-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setQueryId(String value) throws PropertyException;



  /**
   * Gets the "ssl-cert-nickname" property.
   * <p>
   * Specifies the SSL certificate nickname, which is the alias under
   * which is stored the client certificate in the keystore. It must be
   * provided to activate SSL client authentication when requesting
   * OpenIDM.
   * <p>
   * The SSL certificate nickname is necessary to ensure that the
   * appropriate client certificate is retrieved from the keystore when
   * SSL client authentication is required and multiples certificates
   * are present in the keystore.
   *
   * @return Returns the value of the "ssl-cert-nickname" property.
   */
  String getSSLCertNickname();



  /**
   * Sets the "ssl-cert-nickname" property.
   * <p>
   * Specifies the SSL certificate nickname, which is the alias under
   * which is stored the client certificate in the keystore. It must be
   * provided to activate SSL client authentication when requesting
   * OpenIDM.
   * <p>
   * The SSL certificate nickname is necessary to ensure that the
   * appropriate client certificate is retrieved from the keystore when
   * SSL client authentication is required and multiples certificates
   * are present in the keystore.
   *
   * @param value The value of the "ssl-cert-nickname" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSSLCertNickname(String value) throws PropertyException;



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Openidm Account Status Notification Handler.
   * <p>
   * It must contain the OpenIDM certificate with the subject DN
   * equals to the certificate-subject-dn property.
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Sets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used with
   * the Openidm Account Status Notification Handler.
   * <p>
   * It must contain the OpenIDM certificate with the subject DN
   * equals to the certificate-subject-dn property.
   *
   * @param value The value of the "trust-manager-provider" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustManagerProvider(String value) throws PropertyException;



  /**
   * Gets the "update-interval" property.
   * <p>
   * Specifies the interval when passwords update notifications are
   * sent.
   * <p>
   * If this value is 0, then updates are sent synchronously. If this
   * value is strictly superior to zero, then updates are first stored
   * locally, then sent asynchronously by a background thread.
   *
   * @return Returns the value of the "update-interval" property.
   */
  long getUpdateInterval();



  /**
   * Sets the "update-interval" property.
   * <p>
   * Specifies the interval when passwords update notifications are
   * sent.
   * <p>
   * If this value is 0, then updates are sent synchronously. If this
   * value is strictly superior to zero, then updates are first stored
   * locally, then sent asynchronously by a background thread.
   *
   * @param value The value of the "update-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setUpdateInterval(long value) throws PropertyException;

}
