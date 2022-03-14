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
import org.forgerock.opendj.server.config.meta.ErrorLogPublisherCfgDefn.DefaultSeverity;
import org.forgerock.opendj.server.config.server.ErrorLogPublisherCfg;



/**
 * A client-side interface for reading and modifying Error Log
 * Publisher settings.
 * <p>
 * Error Log Publishers are responsible for distributing error log
 * messages from the error logger to a destination.
 */
public interface ErrorLogPublisherCfgClient extends LogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this Error Log Publisher.
   *
   * @return Returns the configuration definition associated with this Error Log Publisher.
   */
  ManagedObjectDefinition<? extends ErrorLogPublisherCfgClient, ? extends ErrorLogPublisherCfg> definition();



  /**
   * Gets the "default-severity" property.
   * <p>
   * Specifies the default severity levels for the logger.
   *
   * @return Returns the values of the "default-severity" property.
   */
  SortedSet<DefaultSeverity> getDefaultSeverity();



  /**
   * Sets the "default-severity" property.
   * <p>
   * Specifies the default severity levels for the logger.
   *
   * @param values The values of the "default-severity" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setDefaultSeverity(Collection<DefaultSeverity> values) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Error Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Error Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "override-severity" property.
   * <p>
   * Specifies the override severity levels for the logger based on
   * the category of the messages.
   * <p>
   * Each override severity level should include the category and the
   * severity levels to log for that category, for example,
   * core=error,info,warning. Valid categories are: core, extensions,
   * protocol, config, log, util, schema, plugin, jeb, backend, tools,
   * task, access-control, admin, sync, version, quicksetup,
   * admin-tool, dsconfig, user-defined. Valid severities are: all,
   * error, info, warning, notice, debug.
   *
   * @return Returns the values of the "override-severity" property.
   */
  SortedSet<String> getOverrideSeverity();



  /**
   * Sets the "override-severity" property.
   * <p>
   * Specifies the override severity levels for the logger based on
   * the category of the messages.
   * <p>
   * Each override severity level should include the category and the
   * severity levels to log for that category, for example,
   * core=error,info,warning. Valid categories are: core, extensions,
   * protocol, config, log, util, schema, plugin, jeb, backend, tools,
   * task, access-control, admin, sync, version, quicksetup,
   * admin-tool, dsconfig, user-defined. Valid severities are: all,
   * error, info, warning, notice, debug.
   *
   * @param values The values of the "override-severity" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setOverrideSeverity(Collection<String> values) throws PropertyException;

}
