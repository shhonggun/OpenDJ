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
import org.forgerock.opendj.server.config.server.HTTPOauth2AuthorizationMechanismCfg;



/**
 * A client-side interface for reading and modifying HTTP Oauth2
 * Authorization Mechanism settings.
 * <p>
 * The HTTP Oauth2 Authorization Mechanism is used to define HTTP
 * OAuth2 authorization mechanism.
 */
public interface HTTPOauth2AuthorizationMechanismCfgClient extends HTTPAuthorizationMechanismCfgClient {

  /**
   * Get the configuration definition associated with this HTTP Oauth2 Authorization Mechanism.
   *
   * @return Returns the configuration definition associated with this HTTP Oauth2 Authorization Mechanism.
   */
  ManagedObjectDefinition<? extends HTTPOauth2AuthorizationMechanismCfgClient, ? extends HTTPOauth2AuthorizationMechanismCfg> definition();



  /**
   * Gets the "access-token-cache-enabled" property.
   * <p>
   * Indicates whether the HTTP Oauth2 Authorization Mechanism is
   * enabled for use.
   *
   * @return Returns the value of the "access-token-cache-enabled" property.
   */
  boolean isAccessTokenCacheEnabled();



  /**
   * Sets the "access-token-cache-enabled" property.
   * <p>
   * Indicates whether the HTTP Oauth2 Authorization Mechanism is
   * enabled for use.
   *
   * @param value The value of the "access-token-cache-enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAccessTokenCacheEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "access-token-cache-expiration" property.
   * <p>
   * Token cache expiration
   *
   * @return Returns the value of the "access-token-cache-expiration" property.
   */
  Long getAccessTokenCacheExpiration();



  /**
   * Sets the "access-token-cache-expiration" property.
   * <p>
   * Token cache expiration
   *
   * @param value The value of the "access-token-cache-expiration" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAccessTokenCacheExpiration(Long value) throws PropertyException;



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
   * Gets the "identity-mapper" property.
   * <p>
   * > Specifies the name of the identity mapper to use in conjunction
   * with the authzid-json-pointer to get the user corresponding to the
   * acccess-token.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Sets the "identity-mapper" property.
   * <p>
   * > Specifies the name of the identity mapper to use in conjunction
   * with the authzid-json-pointer to get the user corresponding to the
   * acccess-token.
   *
   * @param value The value of the "identity-mapper" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIdentityMapper(String value) throws PropertyException;



  /**
   * Gets the "required-scope" property.
   * <p>
   * Scopes required to grant access to the service.
   *
   * @return Returns the values of the "required-scope" property.
   */
  SortedSet<String> getRequiredScope();



  /**
   * Sets the "required-scope" property.
   * <p>
   * Scopes required to grant access to the service.
   *
   * @param values The values of the "required-scope" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRequiredScope(Collection<String> values) throws PropertyException;

}
