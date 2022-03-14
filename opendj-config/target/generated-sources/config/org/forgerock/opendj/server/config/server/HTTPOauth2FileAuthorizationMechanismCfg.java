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



/**
 * A server-side interface for querying HTTP Oauth2 File Authorization
 * Mechanism settings.
 * <p>
 * The HTTP Oauth2 File Authorization Mechanism is used to define
 * OAuth2 authorization through a file based access-token resolution.
 * For test purpose only, this mechanism is looking up for JSON
 * access-token files under the specified path.
 */
public interface HTTPOauth2FileAuthorizationMechanismCfg extends HTTPOauth2AuthorizationMechanismCfg {

  /**
   * Gets the configuration class associated with this HTTP Oauth2 File Authorization Mechanism.
   *
   * @return Returns the configuration class associated with this HTTP Oauth2 File Authorization Mechanism.
   */
  Class<? extends HTTPOauth2FileAuthorizationMechanismCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Oauth2 File Authorization Mechanism is changed.
   *
   * @param listener
   *          The HTTP Oauth2 File Authorization Mechanism configuration change listener.
   */
  void addHTTPOauth2FileAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2FileAuthorizationMechanismCfg> listener);



  /**
   * Deregister an existing HTTP Oauth2 File Authorization Mechanism configuration change listener.
   *
   * @param listener
   *          The HTTP Oauth2 File Authorization Mechanism configuration change listener.
   */
  void removeHTTPOauth2FileAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPOauth2FileAuthorizationMechanismCfg> listener);



  /**
   * Gets the "access-token-directory" property.
   * <p>
   * Directory containing token files. File names must be equal to the
   * token strings. The file content must a JSON object with the
   * following attributes: 'scope', 'expireTime' and all the field(s)
   * needed to resolve the authzIdTemplate.
   *
   * @return Returns the value of the "access-token-directory" property.
   */
  String getAccessTokenDirectory();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 File Authorization Mechanism
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
