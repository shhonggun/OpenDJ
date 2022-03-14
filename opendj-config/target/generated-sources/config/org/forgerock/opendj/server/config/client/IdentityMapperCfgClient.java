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



import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;



/**
 * A client-side interface for reading and modifying Identity Mapper
 * settings.
 * <p>
 * Identity Mappers are responsible for establishing a mapping between
 * an identifier string provided by a client, and the entry for the
 * user that corresponds to that identifier. Identity Mappers are used
 * to process several SASL mechanisms to map an authorization ID (e.g.,
 * a Kerberos principal when using GSSAPI) to a directory user. They
 * are also used when processing requests with the proxied
 * authorization control.
 */
public interface IdentityMapperCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Identity Mapper.
   *
   * @return Returns the configuration definition associated with this Identity Mapper.
   */
  ManagedObjectDefinition<? extends IdentityMapperCfgClient, ? extends IdentityMapperCfg> definition();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Identity Mapper is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the Identity Mapper is enabled for use.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Identity Mapper implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Identity Mapper implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
