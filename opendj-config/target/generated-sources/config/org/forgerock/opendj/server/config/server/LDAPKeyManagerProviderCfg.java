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
 * A server-side interface for querying LDAP Key Manager Provider
 * settings.
 * <p>
 * The LDAP key manager provider uses an LDAP key store managed by the
 * server to obtain server certificates.
 */
public interface LDAPKeyManagerProviderCfg extends KeyManagerProviderCfg {

  /**
   * Gets the configuration class associated with this LDAP Key Manager Provider.
   *
   * @return Returns the configuration class associated with this LDAP Key Manager Provider.
   */
  Class<? extends LDAPKeyManagerProviderCfg> configurationClass();



  /**
   * Register to be notified when this LDAP Key Manager Provider is changed.
   *
   * @param listener
   *          The LDAP Key Manager Provider configuration change listener.
   */
  void addLDAPChangeListener(ConfigurationChangeListener<LDAPKeyManagerProviderCfg> listener);



  /**
   * Deregister an existing LDAP Key Manager Provider configuration change listener.
   *
   * @param listener
   *          The LDAP Key Manager Provider configuration change listener.
   */
  void removeLDAPChangeListener(ConfigurationChangeListener<LDAPKeyManagerProviderCfg> listener);



  /**
   * Gets the "base-dn" property.
   * <p>
   * The base DN beneath which LDAP key store entries are located.
   *
   * @return Returns the value of the "base-dn" property.
   */
  DN getBaseDN();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the LDAP
   * Key Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "key-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the LDAP Key
   * Manager Provider .
   *
   * @return Returns the value of the "key-store-pin" property.
   */
  String getKeyStorePin();



  /**
   * Gets the "key-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the LDAP Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-environment-variable" property.
   */
  String getKeyStorePinEnvironmentVariable();



  /**
   * Gets the "key-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * LDAP Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-file" property.
   */
  String getKeyStorePinFile();



  /**
   * Gets the "key-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the LDAP Key Manager Provider .
   *
   * @return Returns the value of the "key-store-pin-property" property.
   */
  String getKeyStorePinProperty();

}
