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
import org.forgerock.opendj.server.config.meta.CryptPasswordStorageSchemeCfgDefn.CryptPasswordStorageEncryptionAlgorithm;



/**
 * A server-side interface for querying Crypt Password Storage Scheme
 * settings.
 * <p>
 * The Crypt Password Storage Scheme provides a mechanism for encoding
 * user passwords like Unix crypt does. Like on most Unix systems, the
 * password may be encrypted using different algorithms, either Unix
 * crypt, md5, sha256 or sha512.
 */
public interface CryptPasswordStorageSchemeCfg extends PasswordStorageSchemeCfg {

  /**
   * Gets the configuration class associated with this Crypt Password Storage Scheme.
   *
   * @return Returns the configuration class associated with this Crypt Password Storage Scheme.
   */
  Class<? extends CryptPasswordStorageSchemeCfg> configurationClass();



  /**
   * Register to be notified when this Crypt Password Storage Scheme is changed.
   *
   * @param listener
   *          The Crypt Password Storage Scheme configuration change listener.
   */
  void addCryptChangeListener(ConfigurationChangeListener<CryptPasswordStorageSchemeCfg> listener);



  /**
   * Deregister an existing Crypt Password Storage Scheme configuration change listener.
   *
   * @param listener
   *          The Crypt Password Storage Scheme configuration change listener.
   */
  void removeCryptChangeListener(ConfigurationChangeListener<CryptPasswordStorageSchemeCfg> listener);



  /**
   * Gets the "crypt-password-storage-encryption-algorithm" property.
   * <p>
   * Specifies the algorithm to use to encrypt new passwords.
   * <p>
   * Select the crypt algorithm to use to encrypt new passwords. The
   * value can either be "unix", which means the password is encrypted
   * with the weak Unix crypt algorithm, or "md5" which means the
   * password is encrypted with the BSD MD5 algorithm and has a $1$
   * prefix, or "sha256" which means the password is encrypted with the
   * SHA256 algorithm and has a $5$ prefix, or "sha512" which means the
   * password is encrypted with the SHA512 algorithm and has a $6$
   * prefix.
   *
   * @return Returns the value of the "crypt-password-storage-encryption-algorithm" property.
   */
  CryptPasswordStorageEncryptionAlgorithm getCryptPasswordStorageEncryptionAlgorithm();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Crypt Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
