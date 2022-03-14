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
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.ExternalSASLMechanismHandlerCfgDefn.CertificateValidationPolicy;
import org.forgerock.opendj.server.config.server.ExternalSASLMechanismHandlerCfg;



/**
 * A client-side interface for reading and modifying External SASL
 * Mechanism Handler settings.
 * <p>
 * The External SASL Mechanism Handler performs all processing related
 * to SASL EXTERNAL authentication.
 */
public interface ExternalSASLMechanismHandlerCfgClient extends SASLMechanismHandlerCfgClient {

  /**
   * Get the configuration definition associated with this External SASL Mechanism Handler.
   *
   * @return Returns the configuration definition associated with this External SASL Mechanism Handler.
   */
  ManagedObjectDefinition<? extends ExternalSASLMechanismHandlerCfgClient, ? extends ExternalSASLMechanismHandlerCfg> definition();



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
   * Sets the "certificate-attribute" property.
   * <p>
   * Specifies the name of the attribute to hold user certificates.
   * <p>
   * This property must specify the name of a valid attribute type
   * defined in the server schema.
   *
   * @param value The value of the "certificate-attribute" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCertificateAttribute(AttributeType value) throws PropertyException;



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
   * Sets the "certificate-mapper" property.
   * <p>
   * Specifies the name of the certificate mapper that should be used
   * to match client certificates to user entries.
   *
   * @param value The value of the "certificate-mapper" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCertificateMapper(String value) throws PropertyException;



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
   * Sets the "certificate-validation-policy" property.
   * <p>
   * Indicates whether to attempt to validate the peer certificate
   * against a certificate held in the user's entry.
   *
   * @param value The value of the "certificate-validation-policy" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCertificateValidationPolicy(CertificateValidationPolicy value) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SASL mechanism handler implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
