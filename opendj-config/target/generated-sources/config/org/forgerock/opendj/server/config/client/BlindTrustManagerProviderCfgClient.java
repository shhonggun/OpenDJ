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
import org.forgerock.opendj.server.config.server.BlindTrustManagerProviderCfg;



/**
 * A client-side interface for reading and modifying Blind Trust
 * Manager Provider settings.
 * <p>
 * The blind trust manager provider always trusts any certificate that
 * is presented to it, regardless of its issuer, subject, and validity
 * dates.
 */
public interface BlindTrustManagerProviderCfgClient extends TrustManagerProviderCfgClient {

  /**
   * Get the configuration definition associated with this Blind Trust Manager Provider.
   *
   * @return Returns the configuration definition associated with this Blind Trust Manager Provider.
   */
  ManagedObjectDefinition<? extends BlindTrustManagerProviderCfgClient, ? extends BlindTrustManagerProviderCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Blind Trust Manager Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Blind Trust Manager Provider implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
