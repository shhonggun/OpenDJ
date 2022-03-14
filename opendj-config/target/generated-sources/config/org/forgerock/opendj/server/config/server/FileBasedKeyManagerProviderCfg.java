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
 * A server-side interface for querying File Based Key Manager
 * Provider settings.
 * <p>
 * The File Based Key Manager Provider can be used to obtain the
 * server certificate from a key store file on the local file system.
 */
public interface FileBasedKeyManagerProviderCfg extends KeyManagerProviderCfg {

  /**
   * Gets the configuration class associated with this File Based Key Manager Provider.
   *
   * @return Returns the configuration class associated with this File Based Key Manager Provider.
   */
  Class<? extends FileBasedKeyManagerProviderCfg> configurationClass();



  /**
   * Register to be notified when this File Based Key Manager Provider is changed.
   *
   * @param listener
   *          The File Based Key Manager Provider configuration change listener.
   */
  void addFileBasedChangeListener(ConfigurationChangeListener<FileBasedKeyManagerProviderCfg> listener);



  /**
   * Deregister an existing File Based Key Manager Provider configuration change listener.
   *
   * @param listener
   *          The File Based Key Manager Provider configuration change listener.
   */
  void removeFileBasedChangeListener(ConfigurationChangeListener<FileBasedKeyManagerProviderCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Key Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "key-store-file" property.
   * <p>
   * Specifies the path to the file that contains the private key
   * information. This may be an absolute path, or a path that is
   * relative to the OpenDJ instance root.
   * <p>
   * Changes to this property will take effect the next time that the
   * key manager is accessed.
   *
   * @return Returns the value of the "key-store-file" property.
   */
  String getKeyStoreFile();



  /**
   * Gets the "key-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the File Based Key
   * Manager Provider .
   *
   * @return Returns the value of the "key-store-pin" property.
   */
  String getKeyStorePin();



  /**
   * Gets the "key-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the File Based Key Manager
   * Provider .
   *
   * @return Returns the value of the "key-store-pin-environment-variable" property.
   */
  String getKeyStorePinEnvironmentVariable();



  /**
   * Gets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * File Based Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-file" property.
   */
  String getKeyStorePinFile();



  /**
   * Gets the "key-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the File Based Key Manager
   * Provider .
   *
   * @return Returns the value of the "key-store-pin-property" property.
   */
  String getKeyStorePinProperty();



  /**
   * Gets the "key-store-type" property.
   * <p>
   * Specifies the format for the data in the key store file.
   * <p>
   * Valid values should always include 'JKS' and 'PKCS12', but
   * different implementations may allow other values as well. If no
   * value is provided, the JVM-default value is used. Changes to this
   * configuration attribute will take effect the next time that the
   * key manager is accessed.
   *
   * @return Returns the value of the "key-store-type" property.
   */
  String getKeyStoreType();

}
