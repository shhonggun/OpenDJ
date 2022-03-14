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
 * A server-side interface for querying Subject Equals DN Certificate
 * Mapper settings.
 * <p>
 * The Subject Equals DN Certificate Mapper maps client certificates
 * to user entries based on the assumption that the certificate subject
 * is the same as the DN of the target user entry.
 */
public interface SubjectEqualsDNCertificateMapperCfg extends CertificateMapperCfg {

  /**
   * Gets the configuration class associated with this Subject Equals DN Certificate Mapper.
   *
   * @return Returns the configuration class associated with this Subject Equals DN Certificate Mapper.
   */
  Class<? extends SubjectEqualsDNCertificateMapperCfg> configurationClass();



  /**
   * Register to be notified when this Subject Equals DN Certificate Mapper is changed.
   *
   * @param listener
   *          The Subject Equals DN Certificate Mapper configuration change listener.
   */
  void addSubjectEqualsDNChangeListener(ConfigurationChangeListener<SubjectEqualsDNCertificateMapperCfg> listener);



  /**
   * Deregister an existing Subject Equals DN Certificate Mapper configuration change listener.
   *
   * @param listener
   *          The Subject Equals DN Certificate Mapper configuration change listener.
   */
  void removeSubjectEqualsDNChangeListener(ConfigurationChangeListener<SubjectEqualsDNCertificateMapperCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Subject Equals DN Certificate Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
