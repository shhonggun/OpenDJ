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



import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.DN;



/**
 * A server-side interface for querying Subject Attribute To User
 * Attribute Certificate Mapper settings.
 * <p>
 * The Subject Attribute To User Attribute Certificate Mapper maps
 * client certificates to user entries by mapping the values of
 * attributes contained in the certificate subject to attributes
 * contained in user entries.
 */
public interface SubjectAttributeToUserAttributeCertificateMapperCfg extends CertificateMapperCfg {

  /**
   * Gets the configuration class associated with this Subject Attribute To User Attribute Certificate Mapper.
   *
   * @return Returns the configuration class associated with this Subject Attribute To User Attribute Certificate Mapper.
   */
  Class<? extends SubjectAttributeToUserAttributeCertificateMapperCfg> configurationClass();



  /**
   * Register to be notified when this Subject Attribute To User Attribute Certificate Mapper is changed.
   *
   * @param listener
   *          The Subject Attribute To User Attribute Certificate Mapper configuration change listener.
   */
  void addSubjectAttributeToUserAttributeChangeListener(ConfigurationChangeListener<SubjectAttributeToUserAttributeCertificateMapperCfg> listener);



  /**
   * Deregister an existing Subject Attribute To User Attribute Certificate Mapper configuration change listener.
   *
   * @param listener
   *          The Subject Attribute To User Attribute Certificate Mapper configuration change listener.
   */
  void removeSubjectAttributeToUserAttributeChangeListener(ConfigurationChangeListener<SubjectAttributeToUserAttributeCertificateMapperCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Subject Attribute To User Attribute Certificate
   * Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "subject-attribute-mapping" property.
   * <p>
   * Specifies a mapping between certificate attributes and user
   * attributes.
   * <p>
   * Each value should be in the form "certattr:userattr" where
   * certattr is the name of the attribute in the certificate subject
   * and userattr is the name of the corresponding attribute in user
   * entries. There may be multiple mappings defined, and when
   * performing the mapping values for all attributes present in the
   * certificate subject that have mappings defined must be present in
   * the corresponding user entries.
   *
   * @return Returns an unmodifiable set containing the values of the "subject-attribute-mapping" property.
   */
  SortedSet<String> getSubjectAttributeMapping();



  /**
   * Gets the "user-base-dn" property.
   * <p>
   * Specifies the base DNs that should be used when performing
   * searches to map the client certificate to a user entry.
   *
   * @return Returns an unmodifiable set containing the values of the "user-base-dn" property.
   */
  SortedSet<DN> getUserBaseDN();

}
