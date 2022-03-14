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



/**
 * A server-side interface for querying Dsee Compat Access Control
 * Handler settings.
 * <p>
 * The Dsee Compat Access Control Handler provides an implementation
 * that uses syntax compatible with the Sun Java System Directory
 * Server Enterprise Edition access control handlers.
 */
public interface DseeCompatAccessControlHandlerCfg extends AccessControlHandlerCfg {

  /**
   * Gets the configuration class associated with this Dsee Compat Access Control Handler.
   *
   * @return Returns the configuration class associated with this Dsee Compat Access Control Handler.
   */
  Class<? extends DseeCompatAccessControlHandlerCfg> configurationClass();



  /**
   * Register to be notified when this Dsee Compat Access Control Handler is changed.
   *
   * @param listener
   *          The Dsee Compat Access Control Handler configuration change listener.
   */
  void addDseeCompatChangeListener(ConfigurationChangeListener<DseeCompatAccessControlHandlerCfg> listener);



  /**
   * Deregister an existing Dsee Compat Access Control Handler configuration change listener.
   *
   * @param listener
   *          The Dsee Compat Access Control Handler configuration change listener.
   */
  void removeDseeCompatChangeListener(ConfigurationChangeListener<DseeCompatAccessControlHandlerCfg> listener);



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
   * @return Returns an unmodifiable set containing the values of the "global-aci" property.
   */
  SortedSet<String> getGlobalACI();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Dsee Compat Access Control Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
