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
import org.forgerock.opendj.server.config.server.FileBasedTrustManagerProviderCfg;



/**
 * A client-side interface for reading and modifying File Based Trust
 * Manager Provider settings.
 * <p>
 * The file-based trust manager provider determines whether to trust a
 * presented certificate based on whether that certificate exists in a
 * server trust store file.
 */
public interface FileBasedTrustManagerProviderCfgClient extends TrustManagerProviderCfgClient {

  /**
   * Get the configuration definition associated with this File Based Trust Manager Provider.
   *
   * @return Returns the configuration definition associated with this File Based Trust Manager Provider.
   */
  ManagedObjectDefinition<? extends FileBasedTrustManagerProviderCfgClient, ? extends FileBasedTrustManagerProviderCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Trust Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Trust Manager Provider implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "trust-store-file" property.
   * <p>
   * Specifies the path to the file containing the trust information.
   * It can be an absolute path or a path that is relative to the
   * OpenDJ instance root.
   * <p>
   * Changes to this configuration attribute take effect the next time
   * that the trust manager is accessed.
   *
   * @return Returns the value of the "trust-store-file" property.
   */
  String getTrustStoreFile();



  /**
   * Sets the "trust-store-file" property.
   * <p>
   * Specifies the path to the file containing the trust information.
   * It can be an absolute path or a path that is relative to the
   * OpenDJ instance root.
   * <p>
   * Changes to this configuration attribute take effect the next time
   * that the trust manager is accessed.
   *
   * @param value The value of the "trust-store-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStoreFile(String value) throws PropertyException;



  /**
   * Gets the "trust-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the File Based
   * Trust Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin" property.
   */
  String getTrustStorePin();



  /**
   * Sets the "trust-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the File Based
   * Trust Manager Provider .
   *
   * @param value The value of the "trust-store-pin" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStorePin(String value) throws PropertyException;



  /**
   * Gets the "trust-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @return Returns the value of the "trust-store-pin-environment-variable" property.
   */
  String getTrustStorePinEnvironmentVariable();



  /**
   * Sets the "trust-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @param value The value of the "trust-store-pin-environment-variable" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStorePinEnvironmentVariable(String value) throws PropertyException;



  /**
   * Gets the "trust-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * File Based Trust Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin-file" property.
   */
  String getTrustStorePinFile();



  /**
   * Sets the "trust-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * File Based Trust Manager Provider .
   *
   * @param value The value of the "trust-store-pin-file" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStorePinFile(String value) throws PropertyException;



  /**
   * Gets the "trust-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @return Returns the value of the "trust-store-pin-property" property.
   */
  String getTrustStorePinProperty();



  /**
   * Sets the "trust-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the File Based Trust Manager
   * Provider .
   *
   * @param value The value of the "trust-store-pin-property" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStorePinProperty(String value) throws PropertyException;



  /**
   * Gets the "trust-store-type" property.
   * <p>
   * Specifies the format for the data in the trust store file.
   * <p>
   * Valid values always include 'JKS' and 'PKCS12', but different
   * implementations can allow other values as well. If no value is
   * provided, then the JVM default value is used. Changes to this
   * configuration attribute take effect the next time that the trust
   * manager is accessed.
   *
   * @return Returns the value of the "trust-store-type" property.
   */
  String getTrustStoreType();



  /**
   * Sets the "trust-store-type" property.
   * <p>
   * Specifies the format for the data in the trust store file.
   * <p>
   * Valid values always include 'JKS' and 'PKCS12', but different
   * implementations can allow other values as well. If no value is
   * provided, then the JVM default value is used. Changes to this
   * configuration attribute take effect the next time that the trust
   * manager is accessed.
   *
   * @param value The value of the "trust-store-type" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setTrustStoreType(String value) throws PropertyException;

}
