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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Certificate Mapper settings.
 * <p>
 * Certificate Mappers are responsible for establishing a mapping
 * between a client certificate and the entry for the user that
 * corresponds to that certificate.
 */
public interface CertificateMapperCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Certificate Mapper.
   *
   * @return Returns the configuration class associated with this Certificate Mapper.
   */
  Class<? extends CertificateMapperCfg> configurationClass();



  /**
   * Register to be notified when this Certificate Mapper is changed.
   *
   * @param listener
   *          The Certificate Mapper configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<CertificateMapperCfg> listener);



  /**
   * Deregister an existing Certificate Mapper configuration change listener.
   *
   * @param listener
   *          The Certificate Mapper configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<CertificateMapperCfg> listener);



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Certificate Mapper is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Certificate Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
