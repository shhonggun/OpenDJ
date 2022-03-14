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
 * A server-side interface for querying Traditional Work Queue
 * settings.
 * <p>
 * The Traditional Work Queue is a type of work queue that uses a
 * number of worker threads that watch a queue and pick up an operation
 * to process whenever one becomes available.
 */
public interface TraditionalWorkQueueCfg extends WorkQueueCfg {

  /**
   * Gets the configuration class associated with this Traditional Work Queue.
   *
   * @return Returns the configuration class associated with this Traditional Work Queue.
   */
  Class<? extends TraditionalWorkQueueCfg> configurationClass();



  /**
   * Register to be notified when this Traditional Work Queue is changed.
   *
   * @param listener
   *          The Traditional Work Queue configuration change listener.
   */
  void addTraditionalChangeListener(ConfigurationChangeListener<TraditionalWorkQueueCfg> listener);



  /**
   * Deregister an existing Traditional Work Queue configuration change listener.
   *
   * @param listener
   *          The Traditional Work Queue configuration change listener.
   */
  void removeTraditionalChangeListener(ConfigurationChangeListener<TraditionalWorkQueueCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Traditional Work Queue implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "max-work-queue-capacity" property.
   * <p>
   * Specifies the maximum number of queued operations that can be in
   * the work queue at any given time.
   * <p>
   * If the work queue is already full and additional requests are
   * received by the server, then the server front end, and possibly
   * the client, will be blocked until the work queue has available
   * capacity.
   *
   * @return Returns the value of the "max-work-queue-capacity" property.
   */
  int getMaxWorkQueueCapacity();



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
