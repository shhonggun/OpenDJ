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
 * A server-side interface for querying Cram MD5 SASL Mechanism
 * Handler settings.
 * <p>
 * The CRAM-MD5 SASL mechanism provides the ability for clients to
 * perform password-based authentication in a manner that does not
 * expose their password in the clear.
 */
public interface CramMD5SASLMechanismHandlerCfg extends SASLMechanismHandlerCfg {

  /**
   * Gets the configuration class associated with this Cram MD5 SASL Mechanism Handler.
   *
   * @return Returns the configuration class associated with this Cram MD5 SASL Mechanism Handler.
   */
  Class<? extends CramMD5SASLMechanismHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Cram MD5 SASL Mechanism Handler is changed.
   *
   * @param listener
   *          The Cram MD5 SASL Mechanism Handler configuration change listener.
   */
  void addCramMD5ChangeListener(ConfigurationChangeListener<CramMD5SASLMechanismHandlerCfg> listener);



  /**
   * Deregister an existing Cram MD5 SASL Mechanism Handler configuration change listener.
   *
   * @param listener
   *          The Cram MD5 SASL Mechanism Handler configuration change listener.
   */
  void removeCramMD5ChangeListener(ConfigurationChangeListener<CramMD5SASLMechanismHandlerCfg> listener);



  /**
   * Gets the "identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper used with this SASL
   * mechanism handler to match the authentication ID included in the
   * SASL bind request to the corresponding user in the directory.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Gets the "identity-mapper" property as a DN.
   * <p>
   * Specifies the name of the identity mapper used with this SASL
   * mechanism handler to match the authentication ID included in the
   * SASL bind request to the corresponding user in the directory.
   *
   * @return Returns the DN value of the "identity-mapper" property.
   */
  DN getIdentityMapperDN();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SASL mechanism handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
