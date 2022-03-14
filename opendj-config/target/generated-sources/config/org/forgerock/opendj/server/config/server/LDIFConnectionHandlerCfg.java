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
 * A server-side interface for querying LDIF Connection Handler
 * settings.
 * <p>
 * The LDIF Connection Handler is used to process changes in the
 * server using internal operations, where the changes to process are
 * read from an LDIF file.
 */
public interface LDIFConnectionHandlerCfg extends ConnectionHandlerCfg {

  /**
   * Gets the configuration class associated with this LDIF Connection Handler.
   *
   * @return Returns the configuration class associated with this LDIF Connection Handler.
   */
  Class<? extends LDIFConnectionHandlerCfg> configurationClass();



  /**
   * Register to be notified when this LDIF Connection Handler is changed.
   *
   * @param listener
   *          The LDIF Connection Handler configuration change listener.
   */
  void addLDIFChangeListener(ConfigurationChangeListener<LDIFConnectionHandlerCfg> listener);



  /**
   * Deregister an existing LDIF Connection Handler configuration change listener.
   *
   * @param listener
   *          The LDIF Connection Handler configuration change listener.
   */
  void removeLDIFChangeListener(ConfigurationChangeListener<LDIFConnectionHandlerCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the LDIF Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "ldif-directory" property.
   * <p>
   * Specifies the path to the directory in which the LDIF files
   * should be placed.
   *
   * @return Returns the value of the "ldif-directory" property.
   */
  String getLDIFDirectory();



  /**
   * Gets the "poll-interval" property.
   * <p>
   * Specifies how frequently the LDIF connection handler should check
   * the LDIF directory to determine whether a new LDIF file has been
   * added.
   *
   * @return Returns the value of the "poll-interval" property.
   */
  long getPollInterval();

}
