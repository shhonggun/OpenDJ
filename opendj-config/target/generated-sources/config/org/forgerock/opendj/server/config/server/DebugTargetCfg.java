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
 * A server-side interface for querying Debug Target settings.
 * <p>
 * Debug Targets define the types of messages logged by the debug
 * logPublisher.
 */
public interface DebugTargetCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Debug Target.
   *
   * @return Returns the configuration class associated with this Debug Target.
   */
  Class<? extends DebugTargetCfg> configurationClass();



  /**
   * Register to be notified when this Debug Target is changed.
   *
   * @param listener
   *          The Debug Target configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<DebugTargetCfg> listener);



  /**
   * Deregister an existing Debug Target configuration change listener.
   *
   * @param listener
   *          The Debug Target configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<DebugTargetCfg> listener);



  /**
   * Gets the "debug-exceptions-only" property.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @return Returns the value of the "debug-exceptions-only" property.
   */
  boolean isDebugExceptionsOnly();



  /**
   * Gets the "debug-scope" property.
   * <p>
   * Specifies the fully-qualified OpenDJ Java package, class, or
   * method affected by the settings in this target definition. Use the
   * number character (#) to separate the class name and the method
   * name (that is, org.opends.server.core.DirectoryServer#startUp).
   *
   * @return Returns the value of the "debug-scope" property.
   */
  String getDebugScope();



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Debug Target is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  boolean isEnabled();



  /**
   * Gets the "include-throwable-cause" property.
   * <p>
   * Specifies the property to indicate whether to include the cause
   * of exceptions in exception thrown and caught messages.
   *
   * @return Returns the value of the "include-throwable-cause" property.
   */
  boolean isIncludeThrowableCause();



  /**
   * Gets the "omit-method-entry-arguments" property.
   * <p>
   * Specifies the property to indicate whether to include method
   * arguments in debug messages.
   *
   * @return Returns the value of the "omit-method-entry-arguments" property.
   */
  boolean isOmitMethodEntryArguments();



  /**
   * Gets the "omit-method-return-value" property.
   * <p>
   * Specifies the property to indicate whether to include the return
   * value in debug messages.
   *
   * @return Returns the value of the "omit-method-return-value" property.
   */
  boolean isOmitMethodReturnValue();



  /**
   * Gets the "throwable-stack-frames" property.
   * <p>
   * Specifies the property to indicate the number of stack frames to
   * include in the stack trace for method entry and exception thrown
   * messages.
   *
   * @return Returns the value of the "throwable-stack-frames" property.
   */
  int getThrowableStackFrames();

}
