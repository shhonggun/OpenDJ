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
 * A server-side interface for querying Clear Password Storage Scheme
 * settings.
 * <p>
 * The Clear Password Storage Scheme provides a mechanism for storing
 * user passwords in clear text, without any form of obfuscation.
 */
public interface ClearPasswordStorageSchemeCfg extends PasswordStorageSchemeCfg {

  /**
   * Gets the configuration class associated with this Clear Password Storage Scheme.
   *
   * @return Returns the configuration class associated with this Clear Password Storage Scheme.
   */
  Class<? extends ClearPasswordStorageSchemeCfg> configurationClass();



  /**
   * Register to be notified when this Clear Password Storage Scheme is changed.
   *
   * @param listener
   *          The Clear Password Storage Scheme configuration change listener.
   */
  void addClearChangeListener(ConfigurationChangeListener<ClearPasswordStorageSchemeCfg> listener);



  /**
   * Deregister an existing Clear Password Storage Scheme configuration change listener.
   *
   * @param listener
   *          The Clear Password Storage Scheme configuration change listener.
   */
  void removeClearChangeListener(ConfigurationChangeListener<ClearPasswordStorageSchemeCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Clear Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
