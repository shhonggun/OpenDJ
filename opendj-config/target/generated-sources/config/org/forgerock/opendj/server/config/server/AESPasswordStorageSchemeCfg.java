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
 * A server-side interface for querying AES Password Storage Scheme
 * settings.
 * <p>
 * The AES Password Storage Scheme provides a mechanism for encoding
 * user passwords using the AES reversible encryption mechanism.
 */
public interface AESPasswordStorageSchemeCfg extends PasswordStorageSchemeCfg {

  /**
   * Gets the configuration class associated with this AES Password Storage Scheme.
   *
   * @return Returns the configuration class associated with this AES Password Storage Scheme.
   */
  Class<? extends AESPasswordStorageSchemeCfg> configurationClass();



  /**
   * Register to be notified when this AES Password Storage Scheme is changed.
   *
   * @param listener
   *          The AES Password Storage Scheme configuration change listener.
   */
  void addAESChangeListener(ConfigurationChangeListener<AESPasswordStorageSchemeCfg> listener);



  /**
   * Deregister an existing AES Password Storage Scheme configuration change listener.
   *
   * @param listener
   *          The AES Password Storage Scheme configuration change listener.
   */
  void removeAESChangeListener(ConfigurationChangeListener<AESPasswordStorageSchemeCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the AES Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
