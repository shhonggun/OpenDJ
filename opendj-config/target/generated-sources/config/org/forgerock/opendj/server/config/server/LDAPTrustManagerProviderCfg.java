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
 * A server-side interface for querying LDAP Trust Manager Provider
 * settings.
 * <p>
 * The LDAP trust manager provider determines whether to trust a
 * presented certificate based on whether that certificate exists in an
 * LDAP key store managed by the server.
 */
public interface LDAPTrustManagerProviderCfg extends TrustManagerProviderCfg {

  /**
   * Gets the configuration class associated with this LDAP Trust Manager Provider.
   *
   * @return Returns the configuration class associated with this LDAP Trust Manager Provider.
   */
  Class<? extends LDAPTrustManagerProviderCfg> configurationClass();



  /**
   * Register to be notified when this LDAP Trust Manager Provider is changed.
   *
   * @param listener
   *          The LDAP Trust Manager Provider configuration change listener.
   */
  void addLDAPChangeListener(ConfigurationChangeListener<LDAPTrustManagerProviderCfg> listener);



  /**
   * Deregister an existing LDAP Trust Manager Provider configuration change listener.
   *
   * @param listener
   *          The LDAP Trust Manager Provider configuration change listener.
   */
  void removeLDAPChangeListener(ConfigurationChangeListener<LDAPTrustManagerProviderCfg> listener);



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
   * Trust Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "trust-store-pin" property.
   * <p>
   * Specifies the clear-text PIN needed to access the LDAP Trust
   * Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin" property.
   */
  String getTrustStorePin();



  /**
   * Gets the "trust-store-pin-environment-variable" property.
   * <p>
   * Specifies the name of the environment variable that contains the
   * clear-text PIN needed to access the LDAP Trust Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin-environment-variable" property.
   */
  String getTrustStorePinEnvironmentVariable();



  /**
   * Gets the "trust-store-pin-file" property.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * LDAP Trust Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin-file" property.
   */
  String getTrustStorePinFile();



  /**
   * Gets the "trust-store-pin-property" property.
   * <p>
   * Specifies the name of the Java property that contains the
   * clear-text PIN needed to access the LDAP Trust Manager Provider .
   *
   * @return Returns the value of the "trust-store-pin-property" property.
   */
  String getTrustStorePinProperty();

}
