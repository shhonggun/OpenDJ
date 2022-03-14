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
import org.forgerock.opendj.server.config.server.PKCS11KeyManagerProviderCfg;



/**
 * A client-side interface for reading and modifying PKCS11 Key
 * Manager Provider settings.
 * <p>
 * The PKCS11 Key Manager Provider enables the server to access the
 * private key information through the PKCS11 interface.
 */
public interface PKCS11KeyManagerProviderCfgClient extends KeyManagerProviderCfgClient {

  /**
   * Get the configuration definition associated with this PKCS11 Key Manager Provider.
   *
   * @return Returns the configuration definition associated with this PKCS11 Key Manager Provider.
   */
  ManagedObjectDefinition<? extends PKCS11KeyManagerProviderCfgClient, ? extends PKCS11KeyManagerProviderCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * PKCS11 Key Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * PKCS11 Key Manager Provider implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "key-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the PKCS11 Key
   * Manager Provider .
   *
   * @return Returns the value of the "key-store-pin" property.
   */
  String getKeyStorePin();



  /**
   * Sets the "key-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the PKCS11 Key
   * Manager Provider .
   *
   * @param value The value of the "key-store-pin" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStorePin(String value) throws PropertyException;



  /**
   * Gets the "key-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-environment-variable" property.
   */
  String getKeyStorePinEnvironmentVariable();



  /**
   * Sets the "key-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @param value The value of the "key-store-pin-environment-variable" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStorePinEnvironmentVariable(String value) throws PropertyException;



  /**
   * Gets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * PKCS11 Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-file" property.
   */
  String getKeyStorePinFile();



  /**
   * Sets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * PKCS11 Key Manager Provider .
   *
   * @param value The value of the "key-store-pin-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStorePinFile(String value) throws PropertyException;



  /**
   * Gets the "key-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-property" property.
   */
  String getKeyStorePinProperty();



  /**
   * Sets the "key-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the PKCS11 Key Manager Provider .
   *
   * @param value The value of the "key-store-pin-property" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setKeyStorePinProperty(String value) throws PropertyException;

}
