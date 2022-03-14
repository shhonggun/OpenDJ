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
import org.forgerock.opendj.server.config.server.HTTPBasicAuthorizationMechanismCfg;



/**
 * A client-side interface for reading and modifying HTTP Basic
 * Authorization Mechanism settings.
 * <p>
 * The HTTP Basic Authorization Mechanism authenticates the end-user
 * using credentials extracted from the HTTP Basic 'Authorization'
 * header.
 */
public interface HTTPBasicAuthorizationMechanismCfgClient extends HTTPAuthorizationMechanismCfgClient {

  /**
   * Get the configuration definition associated with this HTTP Basic Authorization Mechanism.
   *
   * @return Returns the configuration definition associated with this HTTP Basic Authorization Mechanism.
   */
  ManagedObjectDefinition<? extends HTTPBasicAuthorizationMechanismCfgClient, ? extends HTTPBasicAuthorizationMechanismCfg> definition();



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
   * Sets the "alt-authentication-enabled" property.
   * <p>
   * Specifies whether user credentials may be provided using
   * alternative headers to the standard 'Authorize' header.
   *
   * @param value The value of the "alt-authentication-enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAltAuthenticationEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "alt-password-header" property.
   * <p>
   * Alternate HTTP headers to get the user's password from.
   *
   * @return Returns the value of the "alt-password-header" property.
   */
  String getAltPasswordHeader();



  /**
   * Sets the "alt-password-header" property.
   * <p>
   * Alternate HTTP headers to get the user's password from.
   *
   * @param value The value of the "alt-password-header" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAltPasswordHeader(String value) throws PropertyException;



  /**
   * Gets the "alt-username-header" property.
   * <p>
   * Alternate HTTP headers to get the user's name from.
   *
   * @return Returns the value of the "alt-username-header" property.
   */
  String getAltUsernameHeader();



  /**
   * Sets the "alt-username-header" property.
   * <p>
   * Alternate HTTP headers to get the user's name from.
   *
   * @param value The value of the "alt-username-header" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setAltUsernameHeader(String value) throws PropertyException;



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
   * Sets the "identity-mapper" property.
   * <p>
   * > Specifies the name of the identity mapper used to get the
   * user's entry corresponding to the user-id provided in the HTTP
   * authentication header.
   *
   * @param value The value of the "identity-mapper" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIdentityMapper(String value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Basic Authorization Mechanism implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Basic Authorization Mechanism implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
