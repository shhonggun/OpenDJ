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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.server.DebugLogPublisherCfg;
import org.forgerock.opendj.server.config.server.DebugTargetCfg;



/**
 * A client-side interface for reading and modifying Debug Log
 * Publisher settings.
 * <p>
 * Debug Log Publishers are responsible for distributing debug log
 * messages from the debug logger to a destination.
 */
public interface DebugLogPublisherCfgClient extends LogPublisherCfgClient {

  /**
   * Get the configuration definition associated with this Debug Log Publisher.
   *
   * @return Returns the configuration definition associated with this Debug Log Publisher.
   */
  ManagedObjectDefinition<? extends DebugLogPublisherCfgClient, ? extends DebugLogPublisherCfg> definition();



  /**
   * Gets the "default-debug-exceptions-only" property.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @return Returns the value of the "default-debug-exceptions-only" property.
   */
  boolean isDefaultDebugExceptionsOnly();



  /**
   * Sets the "default-debug-exceptions-only" property.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @param value The value of the "default-debug-exceptions-only" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultDebugExceptionsOnly(Boolean value) throws PropertyException;



  /**
   * Gets the "default-include-throwable-cause" property.
   * <p>
   * Indicates whether to include the cause of exceptions in exception
   * thrown and caught messages logged by default.
   *
   * @return Returns the value of the "default-include-throwable-cause" property.
   */
  boolean isDefaultIncludeThrowableCause();



  /**
   * Sets the "default-include-throwable-cause" property.
   * <p>
   * Indicates whether to include the cause of exceptions in exception
   * thrown and caught messages logged by default.
   *
   * @param value The value of the "default-include-throwable-cause" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultIncludeThrowableCause(Boolean value) throws PropertyException;



  /**
   * Gets the "default-omit-method-entry-arguments" property.
   * <p>
   * Indicates whether to include method arguments in debug messages
   * logged by default.
   *
   * @return Returns the value of the "default-omit-method-entry-arguments" property.
   */
  boolean isDefaultOmitMethodEntryArguments();



  /**
   * Sets the "default-omit-method-entry-arguments" property.
   * <p>
   * Indicates whether to include method arguments in debug messages
   * logged by default.
   *
   * @param value The value of the "default-omit-method-entry-arguments" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultOmitMethodEntryArguments(Boolean value) throws PropertyException;



  /**
   * Gets the "default-omit-method-return-value" property.
   * <p>
   * Indicates whether to include the return value in debug messages
   * logged by default.
   *
   * @return Returns the value of the "default-omit-method-return-value" property.
   */
  boolean isDefaultOmitMethodReturnValue();



  /**
   * Sets the "default-omit-method-return-value" property.
   * <p>
   * Indicates whether to include the return value in debug messages
   * logged by default.
   *
   * @param value The value of the "default-omit-method-return-value" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultOmitMethodReturnValue(Boolean value) throws PropertyException;



  /**
   * Gets the "default-throwable-stack-frames" property.
   * <p>
   * Indicates the number of stack frames to include in the stack
   * trace for method entry and exception thrown messages.
   *
   * @return Returns the value of the "default-throwable-stack-frames" property.
   */
  int getDefaultThrowableStackFrames();



  /**
   * Sets the "default-throwable-stack-frames" property.
   * <p>
   * Indicates the number of stack frames to include in the stack
   * trace for method entry and exception thrown messages.
   *
   * @param value The value of the "default-throwable-stack-frames" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setDefaultThrowableStackFrames(Integer value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Debug Log Publisher implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Debug Log Publisher implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Lists the Debug Targets.
   *
   * @return Returns an array containing the names of the Debug
   *         Targets.
   * @throws ConcurrentModificationException
   *           If this Debug Log Publisher has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listDebugTargets() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Debug Target.
   *
   * @param name
   *           The name of the Debug Target to retrieve.
   * @return Returns the named Debug Target.
   * @throws DefinitionDecodingException
   *           If the named Debug Target was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Debug Target was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Debug Target was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Debug Log Publisher has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  DebugTargetCfgClient getDebugTarget(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Debug Target. The new Debug Target will initially
   * not contain any property values (including mandatory properties).
   * Once the Debug Target has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Debug Target being created.
   * @param d
   *          The definition of the Debug Target to be created.
   * @param name
   *          The name of the new Debug Target.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Debug Target. This
   *          argument can be <code>null<code>.
   * @return Returns a new Debug Target configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Debug Target is invalid.
   */
  <C extends DebugTargetCfgClient> C createDebugTarget(
      ManagedObjectDefinition<C, ? extends DebugTargetCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Debug Target.
   *
   * @param name
   *          The name of the Debug Target to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Debug Target does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Debug Target due to
   *           some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Debug Log Publisher has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeDebugTarget(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;

}
