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



import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying HTTP Oauth2 Token
 * Introspection Authorization Mechanism settings.
 * <p>
 * The HTTP Oauth2 Token Introspection Authorization Mechanism is used
 * to define OAuth2 authorization using an introspection (RFC7662)
 * compliant authorization server.
 */
public interface HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg extends HTTPOauth2AuthorizationMechanismCfg {

  /**
   * Gets the configuration class associated with this HTTP Oauth2 Token Introspection Authorization Mechanism.
   *
   * @return Returns the configuration class associated with this HTTP Oauth2 Token Introspection Authorization Mechanism.
   */
  Class<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Oauth2 Token Introspection Authorization Mechanism is changed.
   *
   * @param listener
   *          The HTTP Oauth2 Token Introspection Authorization Mechanism configuration change listener.
   */
  void addHTTPOauth2TokenIntrospectionAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> listener);



  /**
   * Deregister an existing HTTP Oauth2 Token Introspection Authorization Mechanism configuration change listener.
   *
   * @param listener
   *          The HTTP Oauth2 Token Introspection Authorization Mechanism configuration change listener.
   */
  void removeHTTPOauth2TokenIntrospectionAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> listener);



  /**
   * Gets the "authzid-json-pointer" property.
   * <p>
   * Specifies the JSON pointer to the value to use as Authorization
   * ID. The JSON pointer is applied to the resolved access token JSON
   * document. (example: /uid)
   *
   * @return Returns the value of the "authzid-json-pointer" property.
   */
  String getAuthzidJsonPointer();



  /**
   * Gets the "client-id" property.
   * <p>
   * Client's ID to use during the HTTP basic authentication against
   * the authorization server.
   *
   * @return Returns the value of the "client-id" property.
   */
  String getClientId();



  /**
   * Gets the "client-secret" property.
   * <p>
   * Client's secret to use during the HTTP basic authentication
   * against the authorization server.
   *
   * @return Returns the value of the "client-secret" property.
   */
  String getClientSecret();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Token Introspection Authorization
   * Mechanism implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Oauth2 Token Introspection Authorization Mechanism .
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Gets the "key-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Oauth2 Token Introspection Authorization Mechanism .
   *
   * @return Returns the DN value of the "key-manager-provider"
   *         property.
   */
  DN getKeyManagerProviderDN();



  /**
   * Gets the "token-introspection-url" property.
   * <p>
   * Defines the token introspection endpoint URL where the
   * access-token resolution request should be sent. (example:
   * http://example.com/introspect)
   *
   * @return Returns the value of the "token-introspection-url" property.
   */
  String getTokenIntrospectionUrl();



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with the remote authorization server.
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Gets the "trust-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with the remote authorization server.
   *
   * @return Returns the DN value of the "trust-manager-provider"
   *         property.
   */
  DN getTrustManagerProviderDN();

}
