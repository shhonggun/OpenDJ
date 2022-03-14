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
 * A server-side interface for querying HTTP Basic Authorization
 * Mechanism settings.
 * <p>
 * The HTTP Basic Authorization Mechanism authenticates the end-user
 * using credentials extracted from the HTTP Basic 'Authorization'
 * header.
 */
public interface HTTPBasicAuthorizationMechanismCfg extends HTTPAuthorizationMechanismCfg {

  /**
   * Gets the configuration class associated with this HTTP Basic Authorization Mechanism.
   *
   * @return Returns the configuration class associated with this HTTP Basic Authorization Mechanism.
   */
  Class<? extends HTTPBasicAuthorizationMechanismCfg> configurationClass();



  /**
   * Register to be notified when this HTTP Basic Authorization Mechanism is changed.
   *
   * @param listener
   *          The HTTP Basic Authorization Mechanism configuration change listener.
   */
  void addHTTPBasicAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPBasicAuthorizationMechanismCfg> listener);



  /**
   * Deregister an existing HTTP Basic Authorization Mechanism configuration change listener.
   *
   * @param listener
   *          The HTTP Basic Authorization Mechanism configuration change listener.
   */
  void removeHTTPBasicAuthorizationMechanismChangeListener(ConfigurationChangeListener<HTTPBasicAuthorizationMechanismCfg> listener);



  /**
   * Gets the "alt-authentication-enabled" property.
   * <p>
   * Specifies whether user credentials may be provided using
   * alternative headers to the standard 'Authorize' header.
   *
   * @return Returns the value of the "alt-authentication-enabled" property.
   */
  boolean isAltAuthenticationEnabled();



  /**
   * Gets the "alt-password-header" property.
   * <p>
   * Alternate HTTP headers to get the user's password from.
   *
   * @return Returns the value of the "alt-password-header" property.
   */
  String getAltPasswordHeader();



  /**
   * Gets the "alt-username-header" property.
   * <p>
   * Alternate HTTP headers to get the user's name from.
   *
   * @return Returns the value of the "alt-username-header" property.
   */
  String getAltUsernameHeader();



  /**
   * Gets the "identity-mapper" property.
   * <p>
   * > Specifies the name of the identity mapper used to get the
   * user's entry corresponding to the user-id provided in the HTTP
   * authentication header.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Gets the "identity-mapper" property as a DN.
   * <p>
   * > Specifies the name of the identity mapper used to get the
   * user's entry corresponding to the user-id provided in the HTTP
   * authentication header.
   *
   * @return Returns the DN value of the "identity-mapper" property.
   */
  DN getIdentityMapperDN();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Basic Authorization Mechanism implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
