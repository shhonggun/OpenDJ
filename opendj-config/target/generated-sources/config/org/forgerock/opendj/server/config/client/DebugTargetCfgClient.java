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
import org.forgerock.opendj.server.config.server.DebugTargetCfg;



/**
 * A client-side interface for reading and modifying Debug Target
 * settings.
 * <p>
 * Debug Targets define the types of messages logged by the debug
 * logPublisher.
 */
public interface DebugTargetCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Debug Target.
   *
   * @return Returns the configuration definition associated with this Debug Target.
   */
  ManagedObjectDefinition<? extends DebugTargetCfgClient, ? extends DebugTargetCfg> definition();



  /**
   * Gets the "debug-exceptions-only" property.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @return Returns the value of the "debug-exceptions-only" property.
   */
  boolean isDebugExceptionsOnly();



  /**
   * Sets the "debug-exceptions-only" property.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @param value The value of the "debug-exceptions-only" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDebugExceptionsOnly(Boolean value) throws PropertyException;



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
   * Sets the "debug-scope" property.
   * <p>
   * Specifies the fully-qualified OpenDJ Java package, class, or
   * method affected by the settings in this target definition. Use the
   * number character (#) to separate the class name and the method
   * name (that is, org.opends.server.core.DirectoryServer#startUp).
   * <p>
   * This property is read-only and can only be modified during
   * creation of a Debug Target.
   *
   * @param value The value of the "debug-scope" property.
   * @throws PropertyException
   *           If the new value is invalid.
   * @throws PropertyException
   *           If this Debug Target is not being initialized.
   */
  void setDebugScope(String value) throws PropertyException, PropertyException;



  /**
   * Gets the "enabled" property.
   * <p>
   * Indicates whether the Debug Target is enabled.
   *
   * @return Returns the value of the "enabled" property.
   */
  Boolean isEnabled();



  /**
   * Sets the "enabled" property.
   * <p>
   * Indicates whether the Debug Target is enabled.
   *
   * @param value The value of the "enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnabled(boolean value) throws PropertyException;



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
   * Sets the "include-throwable-cause" property.
   * <p>
   * Specifies the property to indicate whether to include the cause
   * of exceptions in exception thrown and caught messages.
   *
   * @param value The value of the "include-throwable-cause" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIncludeThrowableCause(Boolean value) throws PropertyException;



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
   * Sets the "omit-method-entry-arguments" property.
   * <p>
   * Specifies the property to indicate whether to include method
   * arguments in debug messages.
   *
   * @param value The value of the "omit-method-entry-arguments" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOmitMethodEntryArguments(Boolean value) throws PropertyException;



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
   * Sets the "omit-method-return-value" property.
   * <p>
   * Specifies the property to indicate whether to include the return
   * value in debug messages.
   *
   * @param value The value of the "omit-method-return-value" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setOmitMethodReturnValue(Boolean value) throws PropertyException;



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



  /**
   * Sets the "throwable-stack-frames" property.
   * <p>
   * Specifies the property to indicate the number of stack frames to
   * include in the stack trace for method entry and exception thrown
   * messages.
   *
   * @param value The value of the "throwable-stack-frames" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setThrowableStackFrames(Integer value) throws PropertyException;

}
