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
 * A server-side interface for querying MD5 Password Storage Scheme
 * settings.
 * <p>
 * The MD5 Password Storage Scheme provides a mechanism for encoding
 * user passwords using an unsalted form of the MD5 message digest
 * algorithm. Because the implementation does not use any kind of
 * salting mechanism, a given password always has the same encoded
 * form.
 */
public interface MD5PasswordStorageSchemeCfg extends PasswordStorageSchemeCfg {

  /**
   * Gets the configuration class associated with this MD5 Password Storage Scheme.
   *
   * @return Returns the configuration class associated with this MD5 Password Storage Scheme.
   */
  Class<? extends MD5PasswordStorageSchemeCfg> configurationClass();



  /**
   * Register to be notified when this MD5 Password Storage Scheme is changed.
   *
   * @param listener
   *          The MD5 Password Storage Scheme configuration change listener.
   */
  void addMD5ChangeListener(ConfigurationChangeListener<MD5PasswordStorageSchemeCfg> listener);



  /**
   * Deregister an existing MD5 Password Storage Scheme configuration change listener.
   *
   * @param listener
   *          The MD5 Password Storage Scheme configuration change listener.
   */
  void removeMD5ChangeListener(ConfigurationChangeListener<MD5PasswordStorageSchemeCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the MD5 Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
