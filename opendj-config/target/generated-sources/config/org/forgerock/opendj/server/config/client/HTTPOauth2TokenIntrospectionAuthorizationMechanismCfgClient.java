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
import org.forgerock.opendj.server.config.server.HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg;



/**
 * A client-side interface for reading and modifying HTTP Oauth2 Token
 * Introspection Authorization Mechanism settings.
 * <p>
 * The HTTP Oauth2 Token Introspection Authorization Mechanism is used
 * to define OAuth2 authorization using an introspection (RFC7662)
 * compliant authorization server.
 */
public interface HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient extends HTTPOauth2AuthorizationMechanismCfgClient {

  /**
   * Get the configuration definition associated with this HTTP Oauth2 Token Introspection Authorization Mechanism.
   *
   * @return Returns the configuration definition associated with this HTTP Oauth2 Token Introspection Authorization Mechanism.
   */
  ManagedObjectDefinition<? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfgClient, ? extends HTTPOauth2TokenIntrospectionAuthorizationMechanismCfg> definition();



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
   * Sets the "authzid-json-pointer" property.
   * <p>
   * Specifies the JSON pointer to the value to use as Authorization
   * ID. The JSON pointer is applied to the resolved access token JSON
   * document. (example: /uid)
   *
   * @param value The value of the "authzid-json-pointer" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAuthzidJsonPointer(String value) throws PropertyException;



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
   * Sets the "client-id" property.
   * <p>
   * Client's ID to use during the HTTP basic authentication against
   * the authorization server.
   *
   * @param value The value of the "client-id" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setClientId(String value) throws PropertyException;



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
   * Sets the "client-secret" property.
   * <p>
   * Client's secret to use during the HTTP basic authentication
   * against the authorization server.
   *
   * @param value The value of the "client-secret" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setClientSecret(String value) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Token Introspection Authorization
   * Mechanism implementation.
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
   * this HTTP Oauth2 Token Introspection Authorization Mechanism .
   *
   * @return Returns the value of the "key-manager-provider" property.
   */
  String getKeyManagerProvider();



  /**
   * Sets the "key-manager-provider" property.
   * <p>
   * Specifies the name of the key manager that should be used with
   * this HTTP Oauth2 Token Introspection Authorization Mechanism .
   *
   * @param value The value of the "key-manager-provider" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyManagerProvider(String value) throws PropertyException;



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
   * Sets the "token-introspection-url" property.
   * <p>
   * Defines the token introspection endpoint URL where the
   * access-token resolution request should be sent. (example:
   * http://example.com/introspect)
   *
   * @param value The value of the "token-introspection-url" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTokenIntrospectionUrl(String value) throws PropertyException;



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
   * Sets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with the remote authorization server.
   *
   * @param value The value of the "trust-manager-provider" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustManagerProvider(String value) throws PropertyException;

}
