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



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.PBKDF2PasswordStorageSchemeCfg;



/**
 * A client-side interface for reading and modifying PBKDF2 Password
 * Storage Scheme settings.
 * <p>
 * The PBKDF2 Password Storage Scheme provides a mechanism for
 * encoding user passwords using the PBKDF2 message digest algorithm.
 */
public interface PBKDF2PasswordStorageSchemeCfgClient extends PasswordStorageSchemeCfgClient {

  /**
   * Get the configuration definition associated with this PBKDF2 Password Storage Scheme.
   *
   * @return Returns the configuration definition associated with this PBKDF2 Password Storage Scheme.
   */
  ManagedObjectDefinition<? extends PBKDF2PasswordStorageSchemeCfgClient, ? extends PBKDF2PasswordStorageSchemeCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the PBKDF2 Password Storage Scheme implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the PBKDF2 Password Storage Scheme implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "pbkdf2-iterations" property.
   * <p>
   * The number of algorithm iterations to make. NIST recommends at
   * least 1000.
   *
   * @return Returns the value of the "pbkdf2-iterations" property.
   */
  int getPBKDF2Iterations();



  /**
   * Sets the "pbkdf2-iterations" property.
   * <p>
   * The number of algorithm iterations to make. NIST recommends at
   * least 1000.
   *
   * @param value The value of the "pbkdf2-iterations" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPBKDF2Iterations(Integer value) throws PropertyException;

}
