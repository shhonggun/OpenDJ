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
import org.forgerock.opendj.server.config.server.DseeCompatAccessControlHandlerCfg;



/**
 * A client-side interface for reading and modifying Dsee Compat
 * Access Control Handler settings.
 * <p>
 * The Dsee Compat Access Control Handler provides an implementation
 * that uses syntax compatible with the Sun Java System Directory
 * Server Enterprise Edition access control handlers.
 */
public interface DseeCompatAccessControlHandlerCfgClient extends AccessControlHandlerCfgClient {

  /**
   * Get the configuration definition associated with this Dsee Compat Access Control Handler.
   *
   * @return Returns the configuration definition associated with this Dsee Compat Access Control Handler.
   */
  ManagedObjectDefinition<? extends DseeCompatAccessControlHandlerCfgClient, ? extends DseeCompatAccessControlHandlerCfg> definition();



  /**
   * Gets the "global-aci" property.
   * <p>
   * Defines global access control rules.
   * <p>
   * Global access control rules apply to all entries anywhere in the
   * data managed by the OpenDJ directory server. The global access
   * control rules may be overridden by more specific access control
   * rules placed in the data.
   *
   * @return Returns the values of the "global-aci" property.
   */
  SortedSet<String> getGlobalACI();



  /**
   * Sets the "global-aci" property.
   * <p>
   * Defines global access control rules.
   * <p>
   * Global access control rules apply to all entries anywhere in the
   * data managed by the OpenDJ directory server. The global access
   * control rules may be overridden by more specific access control
   * rules placed in the data.
   *
   * @param values The values of the "global-aci" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setGlobalACI(Collection<String> values) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Dsee Compat Access Control Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Dsee Compat Access Control Handler implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;

}
