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
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying HTTP Oauth2 Authorization
 * Mechanism settings.
 * <p>
 * The HTTP Oauth2 Authorization Mechanism is used to define HTTP
 * OAuth2 authorization mechanism.
 */
public interface HTTPOauth2AuthorizationMechanismCfg extends HTTPAuthorizationMechanismCfg {

  /**
   * Gets the configuration class associated with this HTTP Oauth2 Authorization Mechanism.
   *
   * @return Returns the configuration class associated with this HTTP Oauth2 Authorization Mechanism.
   */
  Class<? extends HTTPOauth2AuthorizationMechanismCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Oauth2 Authorization Mechanism is changed.
   *
   * @param listener
   *          The HTTP Oauth2 Authorization Mechanism configuration change listener.
   */
  void addHTTPOauth2AuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2AuthorizationMechanismCfg> listener);



  /**
   * Deregister an existing HTTP Oauth2 Authorization Mechanism configuration change listener.
   *
   * @param listener
   *          The HTTP Oauth2 Authorization Mechanism configuration change listener.
   */
  void removeHTTPOauth2AuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2AuthorizationMechanismCfg> listener);



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
   * Gets the "access-token-cache-expiration" property.
   * <p>
   * Token cache expiration
   *
   * @return Returns the value of the "access-token-cache-expiration" property.
   */
  Long getAccessTokenCacheExpiration();



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
   * Gets the "identity-mapper" property as a DN.
   * <p>
   * > Specifies the name of the identity mapper to use in conjunction
   * with the authzid-json-pointer to get the user corresponding to the
   * acccess-token.
   *
   * @return Returns the DN value of the "identity-mapper" property.
   */
  DN getIdentityMapperDN();



  /**
   * Gets the "required-scope" property.
   * <p>
   * Scopes required to grant access to the service.
   *
   * @return Returns an unmodifiable set containing the values of the "required-scope" property.
   */
  SortedSet<String> getRequiredScope();

}
