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
import org.forgerock.opendj.server.config.server.HTTPOauth2CtsAuthorizationMechanismCfg;



/**
 * A client-side interface for reading and modifying HTTP Oauth2 Cts
 * Authorization Mechanism settings.
 * <p>
 * The HTTP Oauth2 Cts Authorization Mechanism is used to define
 * OAuth2 authorization through a direct access to the CTS (Core Token
 * Service).
 */
public interface HTTPOauth2CtsAuthorizationMechanismCfgClient extends HTTPOauth2AuthorizationMechanismCfgClient {

  /**
   * Get the configuration definition associated with this HTTP Oauth2 Cts Authorization Mechanism.
   *
   * @return Returns the configuration definition associated with this HTTP Oauth2 Cts Authorization Mechanism.
   */
  ManagedObjectDefinition<? extends HTTPOauth2CtsAuthorizationMechanismCfgClient, ? extends HTTPOauth2CtsAuthorizationMechanismCfg> definition();



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
   * Gets the "base-dn" property.
   * <p>
   * The base DN of the Core Token Service where access token are
   * stored. (example:
   * ou=famrecords,ou=openam-session,ou=tokens,dc=example,dc=com)
   *
   * @return Returns the value of the "base-dn" property.
   */
  String getBaseDN();



  /**
   * Sets the "base-dn" property.
   * <p>
   * The base DN of the Core Token Service where access token are
   * stored. (example:
   * ou=famrecords,ou=openam-session,ou=tokens,dc=example,dc=com)
   *
   * @param value The value of the "base-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setBaseDN(String value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Cts Authorization Mechanism
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Cts Authorization Mechanism
   * implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
