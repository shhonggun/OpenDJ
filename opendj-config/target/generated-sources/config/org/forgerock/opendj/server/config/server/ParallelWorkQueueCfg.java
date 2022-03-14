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
 * A server-side interface for querying Parallel Work Queue settings.
 * <p>
 * The Parallel Work Queue is a type of work queue that uses a number
 * of worker threads that watch a queue and pick up an operation to
 * process whenever one becomes available.
 */
public interface ParallelWorkQueueCfg extends WorkQueueCfg {

  /**
   * Gets the configuration class associated with this Parallel Work Queue.
   *
   * @return Returns the configuration class associated with this Parallel Work Queue.
   */
  Class<? extends ParallelWorkQueueCfg> configurationClass();



  /**
   * Register to be notified when this Parallel Work Queue is changed.
   *
   * @param listener
   *          The Parallel Work Queue configuration change listener.
   */
  void addParallelChangeListener(ConfigurationChangeListener<ParallelWorkQueueCfg> listener);



  /**
   * Deregister an existing Parallel Work Queue configuration change listener.
   *
   * @param listener
   *          The Parallel Work Queue configuration change listener.
   */
  void removeParallelChangeListener(ConfigurationChangeListener<ParallelWorkQueueCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Parallel Work Queue implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "num-worker-threads" property.
   * <p>
   * Specifies the number of worker threads to be used for processing
   * operations placed in the queue.
   * <p>
   * If the value is increased, the additional worker threads are
   * created immediately. If the value is reduced, the appropriate
   * number of threads are destroyed as operations complete processing.
   *
   * @return Returns the value of the "num-worker-threads" property.
   */
  Integer getNumWorkerThreads();

}
