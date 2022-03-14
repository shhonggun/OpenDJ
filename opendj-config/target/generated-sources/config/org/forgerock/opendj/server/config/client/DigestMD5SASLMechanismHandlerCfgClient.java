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
import org.forgerock.opendj.server.config.meta.DigestMD5SASLMechanismHandlerCfgDefn.QualityOfProtection;
import org.forgerock.opendj.server.config.server.DigestMD5SASLMechanismHandlerCfg;



/**
 * A client-side interface for reading and modifying Digest MD5 SASL
 * Mechanism Handler settings.
 * <p>
 * The DIGEST-MD5 SASL mechanism is used to perform all processing
 * related to SASL DIGEST-MD5 authentication.
 */
public interface DigestMD5SASLMechanismHandlerCfgClient extends SASLMechanismHandlerCfgClient {

  /**
   * Get the configuration definition associated with this Digest MD5 SASL Mechanism Handler.
   *
   * @return Returns the configuration definition associated with this Digest MD5 SASL Mechanism Handler.
   */
  ManagedObjectDefinition<? extends DigestMD5SASLMechanismHandlerCfgClient, ? extends DigestMD5SASLMechanismHandlerCfg> definition();



  /**
   * Gets the "identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the authentication or
   * authorization ID included in the SASL bind request to the
   * corresponding user in the directory.
   *
   * @return Returns the value of the "identity-mapper" property.
   */
  String getIdentityMapper();



  /**
   * Sets the "identity-mapper" property.
   * <p>
   * Specifies the name of the identity mapper that is to be used with
   * this SASL mechanism handler to match the authentication or
   * authorization ID included in the SASL bind request to the
   * corresponding user in the directory.
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
   * Sets the "quality-of-protection" property.
   * <p>
   * The name of a property that specifies the quality of protection
   * the server will support.
   *
   * @param value The value of the "quality-of-protection" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setQualityOfProtection(QualityOfProtection value) throws PropertyException;



  /**
   * Gets the "realm" property.
   * <p>
   * Specifies the realms that is to be used by the server for
   * DIGEST-MD5 authentication.
   * <p>
   * If this value is not provided, then the server defaults to use
   * the fully qualified hostname of the machine.
   *
   * @return Returns the value of the "realm" property.
   */
  String getRealm();



  /**
   * Sets the "realm" property.
   * <p>
   * Specifies the realms that is to be used by the server for
   * DIGEST-MD5 authentication.
   * <p>
   * If this value is not provided, then the server defaults to use
   * the fully qualified hostname of the machine.
   *
   * @param value The value of the "realm" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setRealm(String value) throws PropertyException;



  /**
   * Gets the "server-fqdn" property.
   * <p>
   * Specifies the DNS-resolvable fully-qualified domain name for the
   * server that is used when validating the digest-uri parameter
   * during the authentication process.
   * <p>
   * If this configuration attribute is present, then the server
   * expects that clients use a digest-uri equal to "ldap/" followed by
   * the value of this attribute. For example, if the attribute has a
   * value of "directory.example.com", then the server expects clients
   * to use a digest-uri of "ldap/directory.example.com". If no value
   * is provided, then the server does not attempt to validate the
   * digest-uri provided by the client and accepts any value.
   *
   * @return Returns the value of the "server-fqdn" property.
   */
  String getServerFqdn();



  /**
   * Sets the "server-fqdn" property.
   * <p>
   * Specifies the DNS-resolvable fully-qualified domain name for the
   * server that is used when validating the digest-uri parameter
   * during the authentication process.
   * <p>
   * If this configuration attribute is present, then the server
   * expects that clients use a digest-uri equal to "ldap/" followed by
   * the value of this attribute. For example, if the attribute has a
   * value of "directory.example.com", then the server expects clients
   * to use a digest-uri of "ldap/directory.example.com". If no value
   * is provided, then the server does not attempt to validate the
   * digest-uri provided by the client and accepts any value.
   *
   * @param value The value of the "server-fqdn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setServerFqdn(String value) throws PropertyException;

}
