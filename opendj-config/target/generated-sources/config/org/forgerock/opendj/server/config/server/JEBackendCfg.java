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



import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying JE Backend settings.
 * <p>
 * A JE Backend stores application data in a Berkeley DB Java Edition
 * database.
 */
public interface JEBackendCfg extends PluggableBackendCfg {

  /**
   * Gets the configuration class associated with this JE Backend.
   *
   * @return Returns the configuration class associated with this JE Backend.
   */
  Class<? extends JEBackendCfg> configurationClass();



  /**
   * Register to be notified when this JE Backend is changed.
   *
   * @param listener
   *          The JE Backend configuration change listener.
   */
  void addJEChangeListener(ConfigurationChangeListener<JEBackendCfg> listener);



  /**
   * Deregister an existing JE Backend configuration change listener.
   *
   * @param listener
   *          The JE Backend configuration change listener.
   */
  void removeJEChangeListener(ConfigurationChangeListener<JEBackendCfg> listener);



  /**
   * Gets the "db-cache-percent" property.
   * <p>
   * Specifies the percentage of JVM memory to allocate to the
   * database cache.
   * <p>
   * Specifies the percentage of memory available to the JVM that
   * should be used for caching database contents. Note that this is
   * only used if the value of the db-cache-size property is set to "0
   * MB". Otherwise, the value of that property is used instead to
   * control the cache size configuration.
   *
   * @return Returns the value of the "db-cache-percent" property.
   */
  int getDBCachePercent();



  /**
   * Gets the "db-cache-size" property.
   * <p>
   * The amount of JVM memory to allocate to the database cache.
   * <p>
   * Specifies the amount of memory that should be used for caching
   * database contents. A value of "0 MB" indicates that the
   * db-cache-percent property should be used instead to specify the
   * cache size.
   *
   * @return Returns the value of the "db-cache-size" property.
   */
  long getDBCacheSize();



  /**
   * Gets the "db-checkpointer-bytes-interval" property.
   * <p>
   * Specifies the maximum number of bytes that may be written to the
   * database before it is forced to perform a checkpoint.
   * <p>
   * This can be used to bound the recovery time that may be required
   * if the database environment is opened without having been properly
   * closed. If this property is set to a non-zero value, the
   * checkpointer wakeup interval is not used. To use time-based
   * checkpointing, set this property to zero.
   *
   * @return Returns the value of the "db-checkpointer-bytes-interval" property.
   */
  long getDBCheckpointerBytesInterval();



  /**
   * Gets the "db-checkpointer-wakeup-interval" property.
   * <p>
   * Specifies the maximum length of time that may pass between
   * checkpoints.
   * <p>
   * Note that this is only used if the value of the checkpointer
   * bytes interval is zero.
   *
   * @return Returns the value of the "db-checkpointer-wakeup-interval" property.
   */
  long getDBCheckpointerWakeupInterval();



  /**
   * Gets the "db-cleaner-min-utilization" property.
   * <p>
   * Specifies the occupancy percentage for "live" data in this
   * backend's database.
   * <p>
   * When the amount of "live" data in the database drops below this
   * value, cleaners will act to increase the occupancy percentage by
   * compacting the database.
   *
   * @return Returns the value of the "db-cleaner-min-utilization" property.
   */
  int getDBCleanerMinUtilization();



  /**
   * Gets the "db-directory" property.
   * <p>
   * Specifies the path to the filesystem directory that is used to
   * hold the Berkeley DB Java Edition database files containing the
   * data for this backend.
   * <p>
   * The path may be either an absolute path or a path relative to the
   * directory containing the base of the OpenDJ directory server
   * installation. The path may be any valid directory path in which
   * the server has appropriate permissions to read and write files and
   * has sufficient space to hold the database contents.
   *
   * @return Returns the value of the "db-directory" property.
   */
  String getDBDirectory();



  /**
   * Gets the "db-directory-permissions" property.
   * <p>
   * Specifies the permissions that should be applied to the directory
   * containing the server database files.
   * <p>
   * They should be expressed as three-digit octal values, which is
   * the traditional representation for UNIX file permissions. The
   * three digits represent the permissions that are available for the
   * directory's owner, group members, and other users (in that order),
   * and each digit is the octal representation of the read, write, and
   * execute bits. Note that this only impacts permissions on the
   * database directory and not on the files written into that
   * directory. On UNIX systems, the user's umask controls permissions
   * given to the database files.
   *
   * @return Returns the value of the "db-directory-permissions" property.
   */
  String getDBDirectoryPermissions();



  /**
   * Gets the "db-evictor-core-threads" property.
   * <p>
   * Specifies the core number of threads in the eviction thread pool.
   * <p>
   * Specifies the core number of threads in the eviction thread pool.
   * These threads help keep memory usage within cache bounds,
   * offloading work from application threads. db-evictor-core-threads,
   * db-evictor-max-threads and db-evictor-keep-alive are used to
   * configure the core, max and keepalive attributes for the eviction
   * thread pool.
   *
   * @return Returns the value of the "db-evictor-core-threads" property.
   */
  int getDBEvictorCoreThreads();



  /**
   * Gets the "db-evictor-keep-alive" property.
   * <p>
   * The duration that excess threads in the eviction thread pool will
   * stay idle. After this period, idle threads will terminate.
   * <p>
   * The duration that excess threads in the eviction thread pool will
   * stay idle. After this period, idle threads will terminate.
   * db-evictor-core-threads, db-evictor-max-threads and
   * db-evictor-keep-alive are used to configure the core, max and
   * keepalive attributes for the eviction thread pool.
   *
   * @return Returns the value of the "db-evictor-keep-alive" property.
   */
  long getDBEvictorKeepAlive();



  /**
   * Gets the "db-evictor-lru-only" property.
   * <p>
   * Indicates whether the database should evict existing data from
   * the cache based on an LRU policy (where the least recently used
   * information will be evicted first).
   * <p>
   * If set to "false", then the eviction keeps internal nodes of the
   * underlying Btree in the cache over leaf nodes, even if the leaf
   * nodes have been accessed more recently. This may be a better
   * configuration for databases in which only a very small portion of
   * the data is cached.
   *
   * @return Returns the value of the "db-evictor-lru-only" property.
   */
  boolean isDBEvictorLruOnly();



  /**
   * Gets the "db-evictor-max-threads" property.
   * <p>
   * Specifies the maximum number of threads in the eviction thread
   * pool.
   * <p>
   * Specifies the maximum number of threads in the eviction thread
   * pool. These threads help keep memory usage within cache bounds,
   * offloading work from application threads. db-evictor-core-threads,
   * db-evictor-max-threads and db-evictor-keep-alive are used to
   * configure the core, max and keepalive attributes for the eviction
   * thread pool.
   *
   * @return Returns the value of the "db-evictor-max-threads" property.
   */
  int getDBEvictorMaxThreads();



  /**
   * Gets the "db-evictor-nodes-per-scan" property.
   * <p>
   * Specifies the number of Btree nodes that should be evicted from
   * the cache in a single pass if it is determined that it is
   * necessary to free existing data in order to make room for new
   * information.
   * <p>
   * Changes to this property do not take effect until the backend is
   * restarted. It is recommended that you also change this property
   * when you set db-evictor-lru-only to false. This setting controls
   * the number of Btree nodes that are considered, or sampled, each
   * time a node is evicted. A setting of 10 often produces good
   * results, but this may vary from application to application. The
   * larger the nodes per scan, the more accurate the algorithm.
   * However, don't set it too high. When considering larger numbers of
   * nodes for each eviction, the evictor may delay the completion of a
   * given database operation, which impacts the response time of the
   * application thread. In JE 4.1 and later, setting this value too
   * high in an application that is largely CPU bound can reduce the
   * effectiveness of cache eviction. It's best to start with the
   * default value, and increase it gradually to see if it is
   * beneficial for your application.
   *
   * @return Returns the value of the "db-evictor-nodes-per-scan" property.
   */
  int getDBEvictorNodesPerScan();



  /**
   * Gets the "db-log-filecache-size" property.
   * <p>
   * Specifies the size of the file handle cache.
   * <p>
   * The file handle cache is used to keep as much opened log files as
   * possible. When the cache is smaller than the number of logs, the
   * database needs to close some handles and open log files it needs,
   * resulting in less optimal performances. Ideally, the size of the
   * cache should be higher than the number of files contained in the
   * database. Make sure the OS number of open files per process is
   * also tuned appropriately.
   *
   * @return Returns the value of the "db-log-filecache-size" property.
   */
  int getDBLogFilecacheSize();



  /**
   * Gets the "db-log-file-max" property.
   * <p>
   * Specifies the maximum size for a database log file.
   *
   * @return Returns the value of the "db-log-file-max" property.
   */
  long getDBLogFileMax();



  /**
   * Gets the "db-logging-file-handler-on" property.
   * <p>
   * Indicates whether the database should maintain a je.info file in
   * the same directory as the database log directory.
   * <p>
   * This file contains information about the internal processing
   * performed by the underlying database.
   *
   * @return Returns the value of the "db-logging-file-handler-on" property.
   */
  boolean isDBLoggingFileHandlerOn();



  /**
   * Gets the "db-logging-level" property.
   * <p>
   * Specifies the log level that should be used by the database when
   * it is writing information into the je.info file.
   * <p>
   * The database trace logging level is (in increasing order of
   * verbosity) chosen from: OFF, SEVERE, WARNING, INFO, CONFIG, FINE,
   * FINER, FINEST, ALL.
   *
   * @return Returns the value of the "db-logging-level" property.
   */
  String getDBLoggingLevel();



  /**
   * Gets the "db-num-cleaner-threads" property.
   * <p>
   * Specifies the number of threads that the backend should maintain
   * to keep the database log files at or near the desired utilization.
   * <p>
   * In environments with high write throughput, multiple cleaner
   * threads may be required to maintain the desired utilization.
   *
   * @return Returns the value of the "db-num-cleaner-threads" property.
   */
  Integer getDBNumCleanerThreads();



  /**
   * Gets the "db-num-lock-tables" property.
   * <p>
   * Specifies the number of lock tables that are used by the
   * underlying database.
   * <p>
   * This can be particularly important to help improve scalability by
   * avoiding contention on systems with large numbers of CPUs. The
   * value of this configuration property should be set to a prime
   * number that is less than or equal to the number of worker threads
   * configured for use in the server.
   *
   * @return Returns the value of the "db-num-lock-tables" property.
   */
  Integer getDBNumLockTables();



  /**
   * Gets the "db-run-cleaner" property.
   * <p>
   * Indicates whether the cleaner threads should be enabled to
   * compact the database.
   * <p>
   * The cleaner threads are used to periodically compact the database
   * when it reaches a percentage of occupancy lower than the amount
   * specified by the db-cleaner-min-utilization property. They
   * identify database files with a low percentage of live data, and
   * relocate their remaining live data to the end of the log.
   *
   * @return Returns the value of the "db-run-cleaner" property.
   */
  boolean isDBRunCleaner();



  /**
   * Gets the "db-txn-no-sync" property.
   * <p>
   * Indicates whether database writes should be primarily written to
   * an internal buffer but not immediately written to disk.
   * <p>
   * Setting the value of this configuration attribute to "true" may
   * improve write performance but could cause the most recent changes
   * to be lost if the OpenDJ directory server or the underlying JVM
   * exits abnormally, or if an OS or hardware failure occurs (a
   * behavior similar to running with transaction durability disabled
   * in the Sun Java System Directory Server).
   *
   * @return Returns the value of the "db-txn-no-sync" property.
   */
  boolean isDBTxnNoSync();



  /**
   * Gets the "db-txn-write-no-sync" property.
   * <p>
   * Indicates whether the database should synchronously flush data as
   * it is written to disk.
   * <p>
   * If this value is set to "false", then all data written to disk is
   * synchronously flushed to persistent storage and thereby providing
   * full durability. If it is set to "true", then data may be cached
   * for a period of time by the underlying operating system before
   * actually being written to disk. This may improve performance, but
   * could cause the most recent changes to be lost in the event of an
   * underlying OS or hardware failure (but not in the case that the
   * OpenDJ directory server or the JVM exits abnormally).
   *
   * @return Returns the value of the "db-txn-write-no-sync" property.
   */
  boolean isDBTxnWriteNoSync();



  /**
   * Gets the "disk-full-threshold" property.
   * <p>
   * Full disk threshold to limit database updates
   * <p>
   * When the available free space on the disk used by this database
   * instance falls below the value specified, no updates are permitted
   * and the server returns an UNWILLING_TO_PERFORM error. Updates are
   * allowed again as soon as free space rises above the threshold.
   *
   * @return Returns the value of the "disk-full-threshold" property.
   */
  long getDiskFullThreshold();



  /**
   * Gets the "disk-low-threshold" property.
   * <p>
   * Low disk threshold to limit database updates
   * <p>
   * Specifies the "low" free space on the disk. When the available
   * free space on the disk used by this database instance falls below
   * the value specified, protocol updates on this database are
   * permitted only by a user with the BYPASS_LOCKDOWN privilege.
   *
   * @return Returns the value of the "disk-low-threshold" property.
   */
  long getDiskLowThreshold();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "je-property" property.
   * <p>
   * Specifies the database and environment properties for the
   * Berkeley DB Java Edition database serving the data for this
   * backend.
   * <p>
   * Any Berkeley DB Java Edition property can be specified using the
   * following form: property-name=property-value. Refer to OpenDJ
   * documentation for further information on related properties, their
   * implications, and range values. The definitive identification of
   * all the property parameters is available in the example.properties
   * file of Berkeley DB Java Edition distribution.
   *
   * @return Returns an unmodifiable set containing the values of the "je-property" property.
   */
  SortedSet<String> getJEProperty();

}
