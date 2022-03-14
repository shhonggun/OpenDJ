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
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.meta.ProfilerPluginCfgDefn.ProfileAction;
import org.forgerock.opendj.server.config.server.ProfilerPluginCfg;



/**
 * A client-side interface for reading and modifying Profiler Plugin
 * settings.
 * <p>
 * The Profiler plug-in captures profiling information about
 * operations performed inside the JVM while the OpenDJ directory
 * server is running.
 */
public interface ProfilerPluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Profiler Plugin.
   *
   * @return Returns the configuration definition associated with this Profiler Plugin.
   */
  ManagedObjectDefinition<? extends ProfilerPluginCfgClient, ? extends ProfilerPluginCfg> definition();



  /**
   * Gets the "enable-profiling-on-startup" property.
   * <p>
   * Indicates whether the profiler plug-in is to start collecting
   * data automatically when the directory server is started.
   * <p>
   * This property is read only when the server is started, and any
   * changes take effect on the next restart. This property is
   * typically set to "false" unless startup profiling is required,
   * because otherwise the volume of data that can be collected can
   * cause the server to run out of memory if it is not turned off in a
   * timely manner.
   *
   * @return Returns the value of the "enable-profiling-on-startup" property.
   */
  Boolean isEnableProfilingOnStartup();



  /**
   * Sets the "enable-profiling-on-startup" property.
   * <p>
   * Indicates whether the profiler plug-in is to start collecting
   * data automatically when the directory server is started.
   * <p>
   * This property is read only when the server is started, and any
   * changes take effect on the next restart. This property is
   * typically set to "false" unless startup profiling is required,
   * because otherwise the volume of data that can be collected can
   * cause the server to run out of memory if it is not turned off in a
   * timely manner.
   *
   * @param value The value of the "enable-profiling-on-startup" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEnableProfilingOnStartup(boolean value) throws PropertyException;



  /**
   * Gets the "invoke-for-internal-operations" property.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @return Returns the value of the "invoke-for-internal-operations" property.
   */
  boolean isInvokeForInternalOperations();



  /**
   * Sets the "invoke-for-internal-operations" property.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @param value The value of the "invoke-for-internal-operations" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setInvokeForInternalOperations(Boolean value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the values of the "plugin-type" property.
   */
  SortedSet<PluginType> getPluginType();



  /**
   * Sets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @param values The values of the "plugin-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPluginType(Collection<PluginType> values) throws PropertyException;



  /**
   * Gets the "profile-action" property.
   * <p>
   * Specifies the action that should be taken by the profiler.
   * <p>
   * A value of "start" causes the profiler thread to start collecting
   * data if it is not already active. A value of "stop" causes the
   * profiler thread to stop collecting data and write it to disk, and
   * a value of "cancel" causes the profiler thread to stop collecting
   * data and discard anything that has been captured. These operations
   * occur immediately.
   *
   * @return Returns the value of the "profile-action" property.
   */
  ProfileAction getProfileAction();



  /**
   * Sets the "profile-action" property.
   * <p>
   * Specifies the action that should be taken by the profiler.
   * <p>
   * A value of "start" causes the profiler thread to start collecting
   * data if it is not already active. A value of "stop" causes the
   * profiler thread to stop collecting data and write it to disk, and
   * a value of "cancel" causes the profiler thread to stop collecting
   * data and discard anything that has been captured. These operations
   * occur immediately.
   *
   * @param value The value of the "profile-action" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setProfileAction(ProfileAction value) throws PropertyException;



  /**
   * Gets the "profile-directory" property.
   * <p>
   * Specifies the path to the directory where profile information is
   * to be written. This path may be either an absolute path or a path
   * that is relative to the root of the OpenDJ directory server
   * instance.
   * <p>
   * The directory must exist and the directory server must have
   * permission to create new files in it.
   *
   * @return Returns the value of the "profile-directory" property.
   */
  String getProfileDirectory();



  /**
   * Sets the "profile-directory" property.
   * <p>
   * Specifies the path to the directory where profile information is
   * to be written. This path may be either an absolute path or a path
   * that is relative to the root of the OpenDJ directory server
   * instance.
   * <p>
   * The directory must exist and the directory server must have
   * permission to create new files in it.
   *
   * @param value The value of the "profile-directory" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setProfileDirectory(String value) throws PropertyException;



  /**
   * Gets the "profile-sample-interval" property.
   * <p>
   * Specifies the sample interval in milliseconds to be used when
   * capturing profiling information in the server.
   * <p>
   * When capturing data, the profiler thread sleeps for this length
   * of time between calls to obtain traces for all threads running in
   * the JVM.
   *
   * @return Returns the value of the "profile-sample-interval" property.
   */
  Long getProfileSampleInterval();



  /**
   * Sets the "profile-sample-interval" property.
   * <p>
   * Specifies the sample interval in milliseconds to be used when
   * capturing profiling information in the server.
   * <p>
   * When capturing data, the profiler thread sleeps for this length
   * of time between calls to obtain traces for all threads running in
   * the JVM.
   *
   * @param value The value of the "profile-sample-interval" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setProfileSampleInterval(long value) throws PropertyException;

}
