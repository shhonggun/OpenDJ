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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Password Generator settings.
 * <p>
 * Password Generators are used by the password modify extended
 * operation to construct a new password for the user.
 */
public interface PasswordGeneratorCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Password Generator.
   *
   * @return Returns the configuration class associated with this Password Generator.
   */
  Class<? extends PasswordGeneratorCfg> configurationClass();



  /**
   * Register to be notified when this Password Generator is changed.
   *
   * @param listener
   *          The Password Generator configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<PasswordGeneratorCfg> listener);



  /**
   * Deregister an existing Password Generator configuration change listener.
   *
   * @param listener
   *          The Password Generator configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<PasswordGeneratorCfg> listener);



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Password Generator is enabled for use.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Password Generator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();

}
