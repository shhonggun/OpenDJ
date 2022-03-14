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
import org.forgerock.opendj.server.config.meta.GSSAPISASLMechanismHandlerCfgDefn.QualityOfProtection;



/**
 * A server-side interface for querying GSSAPI SASL Mechanism Handler
 * settings.
 * <p>
 * The GSSAPI SASL mechanism performs all processing related to SASL
 * GSSAPI authentication using Kerberos V5.
 */
public interface GSSAPISASLMechanismHandlerCfg extends SASLMechanismHandlerCfg {

  /**
   * Gets the configuration class associated with this GSSAPI SASL Mechanism Handler.
   *
   * @return Returns the configuration class associated with this GSSAPI SASL Mechanism Handler.
   */
  Class<? extends GSSAPISASLMechanismHandlerCfg> configurationClass();



  /**
   * Register to be notified when this GSSAPI SASL Mechanism Handler is changed.
   *
   * @param listener
   *          The GSSAPI SASL Mechanism Handler configuration change listener.
   */
  void addGSSAPIChangeListener(ConfigurationChangeListener<GSSAPISASLMechanismHandlerCfg> listener);



  /**
   * Deregister an existing GSSAPI SASL Mechanism Handler configuration change listener.
   *
   * @param listener
   *          The GSSAPI SASL Mechanism Handler configuration change listener.
   */
  void removeGSSAPIChangeListener(ConfigurationChangeListener<GSSAPISASLMechanismHandlerCfg> listener);



  /**
   * Gets the "identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the Kerberos principal
   * included in the SASL bind request to the corresponding user in the
   * directory.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Gets the "identity-mapper" property as a DN.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the Kerberos principal
   * included in the SASL bind request to the corresponding user in the
   * directory.
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



  /**
   * Gets the "kdc-address" property.
   * <p>
   * Specifies the address of the KDC that is to be used for Kerberos
   * processing.
   * <p>
   * If provided, this property must be a fully-qualified
   * DNS-resolvable name. If this property is not provided, then the
   * server attempts to determine it from the system-wide Kerberos
   * configuration.
   *
   * @return Returns the value of the "kdc-address" property.
   */
  String getKdcAddress();



  /**
   * Gets the "keytab" property.
   * <p>
   * Specifies the path to the keytab file that should be used for
   * Kerberos processing.
   * <p>
   * If provided, this is either an absolute path or one that is
   * relative to the server instance root.
   *
   * @return Returns the value of the "keytab" property.
   */
  String getKeytab();



  /**
   * Gets the "principal-name" property.
   * <p>
   * Specifies the principal name.
   * <p>
   * It can either be a simple user name or a service name such as
   * host/example.com. If this property is not provided, then the
   * server attempts to build the principal name by appending the fully
   * qualified domain name to the string "ldap/".
   *
   * @return Returns the value of the "principal-name" property.
   */
  String getPrincipalName();



  /**
   * Gets the "quality-of-protection" property.
   * <p>
   * The name of a property that specifies the quality of protection
   * the server will support.
   *
   * @return Returns the value of the "quality-of-protection" property.
   */
  QualityOfProtection getQualityOfProtection();



  /**
   * Gets the "realm" property.
   * <p>
   * Specifies the realm to be used for GSSAPI authentication.
   *
   * @return Returns the value of the "realm" property.
   */
  String getRealm();



  /**
   * Gets the "server-fqdn" property.
   * <p>
   * Specifies the DNS-resolvable fully-qualified domain name for the
   * system.
   *
   * @return Returns the value of the "server-fqdn" property.
   */
  String getServerFqdn();

}
