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
import org.forgerock.opendj.ldap.schema.AttributeType;



/**
 * A server-side interface for querying Subject DN To User Attribute
 * Certificate Mapper settings.
 * <p>
 * The Subject DN To User Attribute Certificate Mapper maps client
 * certificates to user entries by looking for the certificate subject
 * DN in a specified attribute of user entries.
 */
public interface SubjectDNToUserAttributeCertificateMapperCfg extends CertificateMapperCfg {

  /**
   * Gets the configuration class associated with this Subject DN To User Attribute Certificate Mapper.
   *
   * @return Returns the configuration class associated with this Subject DN To User Attribute Certificate Mapper.
   */
  Class<? extends SubjectDNToUserAttributeCertificateMapperCfg> configurationClass();



  /**
   * Register to be notified when this Subject DN To User Attribute Certificate Mapper is changed.
   *
   * @param listener
   *          The Subject DN To User Attribute Certificate Mapper configuration change listener.
   */
  void addSubjectDNToUserAttributeChangeListener(ConfigurationChangeListener<SubjectDNToUserAttributeCertificateMapperCfg> listener);



  /**
   * Deregister an existing Subject DN To User Attribute Certificate Mapper configuration change listener.
   *
   * @param listener
   *          The Subject DN To User Attribute Certificate Mapper configuration change listener.
   */
  void removeSubjectDNToUserAttributeChangeListener(ConfigurationChangeListener<SubjectDNToUserAttributeCertificateMapperCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Subject DN To User Attribute Certificate Mapper
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "subject-attribute" property.
   * <p>
   * Specifies the name or OID of the attribute whose value should
   * exactly match the certificate subject DN.
   *
   * @return Returns the value of the "subject-attribute" property.
   */
  AttributeType getSubjectAttribute();



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
