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
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.server.SubjectDNToUserAttributeCertificateMapperCfg;



/**
 * A client-side interface for reading and modifying Subject DN To
 * User Attribute Certificate Mapper settings.
 * <p>
 * The Subject DN To User Attribute Certificate Mapper maps client
 * certificates to user entries by looking for the certificate subject
 * DN in a specified attribute of user entries.
 */
public interface SubjectDNToUserAttributeCertificateMapperCfgClient extends CertificateMapperCfgClient {

  /**
   * Get the configuration definition associated with this Subject DN To User Attribute Certificate Mapper.
   *
   * @return Returns the configuration definition associated with this Subject DN To User Attribute Certificate Mapper.
   */
  ManagedObjectDefinition<? extends SubjectDNToUserAttributeCertificateMapperCfgClient, ? extends SubjectDNToUserAttributeCertificateMapperCfg> definition();



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Subject DN To User Attribute Certificate Mapper
   * implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



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
   * Sets the "subject-attribute" property.
   * <p>
   * Specifies the name or OID of the attribute whose value should
   * exactly match the certificate subject DN.
   *
   * @param value The value of the "subject-attribute" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSubjectAttribute(AttributeType value) throws PropertyException;



  /**
   * Gets the "user-base-dn" property.
   * <p>
   * Specifies the base DNs that should be used when performing
   * searches to map the client certificate to a user entry.
   *
   * @return Returns the values of the "user-base-dn" property.
   */
  SortedSet<DN> getUserBaseDN();



  /**
   * Sets the "user-base-dn" property.
   * <p>
   * Specifies the base DNs that should be used when performing
   * searches to map the client certificate to a user entry.
   *
   * @param values The values of the "user-base-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setUserBaseDN(Collection<DN> values) throws PropertyException;

}
