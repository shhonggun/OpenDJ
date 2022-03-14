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
 * A server-side interface for querying Bcrypt Password Storage Scheme
 * settings.
 * <p>
 * The Bcrypt Password Storage Scheme provides a mechanism for
 * encoding user passwords using the bcrypt message digest algorithm.
 */
public interface BcryptPasswordStorageSchemeCfg extends PasswordStorageSchemeCfg {

  /**
   * Gets the configuration class associated with this Bcrypt Password Storage Scheme.
   *
   * @return Returns the configuration class associated with this Bcrypt Password Storage Scheme.
   */
  Class<? extends BcryptPasswordStorageSchemeCfg> configurationClass();



  /**
   * Register to be notified when this Bcrypt Password Storage Scheme is changed.
   *
   * @param listener
   *          The Bcrypt Password Storage Scheme configuration change listener.
   */
  void addBcryptChangeListener(ConfigurationChangeListener<BcryptPasswordStorageSchemeCfg> listener);



  /**
   * Deregister an existing Bcrypt Password Storage Scheme configuration change listener.
   *
   * @param listener
   *          The Bcrypt Password Storage Scheme configuration change listener.
   */
  void removeBcryptChangeListener(ConfigurationChangeListener<BcryptPasswordStorageSchemeCfg> listener);



  /**
   * Gets the "bcrypt-cost" property.
   * <p>
   * The cost parameter specifies a key expansion iteration count as a
   * power of two. A default value of 12 (2^12 iterations) is
   * considered in 2016 as a reasonable balance between responsiveness
   * and security for regular users.
   *
   * @return Returns the value of the "bcrypt-cost" property.
   */
  int getBcryptCost();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Bcrypt Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
