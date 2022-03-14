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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.ExternalSASLMechanismHandlerCfgDefn.CertificateValidationPolicy;



/**
 * A server-side interface for querying External SASL Mechanism
 * Handler settings.
 * <p>
 * The External SASL Mechanism Handler performs all processing related
 * to SASL EXTERNAL authentication.
 */
public interface ExternalSASLMechanismHandlerCfg extends SASLMechanismHandlerCfg {

  /**
   * Gets the configuration class associated with this External SASL Mechanism Handler.
   *
   * @return Returns the configuration class associated with this External SASL Mechanism Handler.
   */
  Class<? extends ExternalSASLMechanismHandlerCfg> configurationClass();



  /**
   * Register to be notified when this External SASL Mechanism Handler is changed.
   *
   * @param listener
   *          The External SASL Mechanism Handler configuration change listener.
   */
  void addExternalChangeListener(ConfigurationChangeListener<ExternalSASLMechanismHandlerCfg> listener);



  /**
   * Deregister an existing External SASL Mechanism Handler configuration change listener.
   *
   * @param listener
   *          The External SASL Mechanism Handler configuration change listener.
   */
  void removeExternalChangeListener(ConfigurationChangeListener<ExternalSASLMechanismHandlerCfg> listener);



  /**
   * Gets the "certificate-attribute" property.
   * <p>
   * Specifies the name of the attribute to hold user certificates.
   * <p>
   * This property must specify the name of a valid attribute type
   * defined in the server schema.
   *
   * @return Returns the value of the "certificate-attribute" property.
   */
  AttributeType getCertificateAttribute();



  /**
   * Gets the "certificate-mapper" property.
   * <p>
   * Specifies the name of the certificate mapper that should be used
   * to match client certificates to user entries.
   *
   * @return Returns the value of the "certificate-mapper" property.
   */
  String getCertificateMapper();



  /**
   * Gets the "certificate-mapper" property as a DN.
   * <p>
   * Specifies the name of the certificate mapper that should be used
   * to match client certificates to user entries.
   *
   * @return Returns the DN value of the "certificate-mapper"
   *         property.
   */
  DN getCertificateMapperDN();



  /**
   * Gets the "certificate-validation-policy" property.
   * <p>
   * Indicates whether to attempt to validate the peer certificate
   * against a certificate held in the user's entry.
   *
   * @return Returns the value of the "certificate-validation-policy" property.
   */
  CertificateValidationPolicy getCertificateValidationPolicy();



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
