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
 * A server-side interface for querying PDB Backend settings.
 * <p>
 * A PDB Backend stores application data in a Persistit database.
 */
public interface PDBBackendCfg extends PluggableBackendCfg {

  /**
   * Gets the configuration class associated with this PDB Backend.
   *
   * @return Returns the configuration class associated with this PDB Backend.
   */
  Class<? extends PDBBackendCfg> configurationClass();



  /**
   * Register to be notified when this PDB Backend is changed.
   *
   * @param listener
   *          The PDB Backend configuration change listener.
   */
  void addPDBChangeListener(ConfigurationChangeListener<PDBBackendCfg> listener);



  /**
   * Deregister an existing PDB Backend configuration change listener.
   *
   * @param listener
   *          The PDB Backend configuration change listener.
   */
  void removePDBChangeListener(ConfigurationChangeListener<PDBBackendCfg> listener);



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
   * Gets the "db-checkpointer-wakeup-interval" property.
   * <p>
   * Specifies the maximum length of time that may pass between
   * checkpoints.
   * <p>
   * This setting controls the elapsed time between attempts to write
   * a checkpoint to the journal. A longer interval allows more updates
   * to accumulate in buffers before they are required to be written to
   * disk, but also potentially causes recovery from an abrupt
   * termination (crash) to take more time.
   *
   * @return Returns the value of the "db-checkpointer-wakeup-interval" property.
   */
  long getDBCheckpointerWakeupInterval();



  /**
   * Gets the "db-directory" property.
   * <p>
   * Specifies the path to the filesystem directory that is used to
   * hold the Persistit database files containing the data for this
   * backend.
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

}
