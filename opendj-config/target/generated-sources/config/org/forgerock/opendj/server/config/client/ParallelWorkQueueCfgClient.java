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



import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.server.config.server.ParallelWorkQueueCfg;



/**
 * A client-side interface for reading and modifying Parallel Work
 * Queue settings.
 * <p>
 * The Parallel Work Queue is a type of work queue that uses a number
 * of worker threads that watch a queue and pick up an operation to
 * process whenever one becomes available.
 */
public interface ParallelWorkQueueCfgClient extends WorkQueueCfgClient {

  /**
   * Get the configuration definition associated with this Parallel Work Queue.
   *
   * @return Returns the configuration definition associated with this Parallel Work Queue.
   */
  ManagedObjectDefinition<? extends ParallelWorkQueueCfgClient, ? extends ParallelWorkQueueCfg> definition();



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Parallel Work Queue implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



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



  /**
   * Sets the "num-worker-threads" property.
   * <p>
   * Specifies the number of worker threads to be used for processing
   * operations placed in the queue.
   * <p>
   * If the value is increased, the additional worker threads are
   * created immediately. If the value is reduced, the appropriate
   * number of threads are destroyed as operations complete processing.
   *
   * @param value The value of the "num-worker-threads" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setNumWorkerThreads(Integer value) throws PropertyException;

}
