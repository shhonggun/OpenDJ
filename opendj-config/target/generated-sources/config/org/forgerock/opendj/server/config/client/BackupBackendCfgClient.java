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
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackupBackendCfg;



/**
 * A client-side interface for reading and modifying Backup Backend
 * settings.
 * <p>
 * The Backup Backend provides read-only access to the set of backups
 * that are available for OpenDJ.
 */
public interface BackupBackendCfgClient extends LocalBackendCfgClient {

  /**
   * Get the configuration definition associated with this Backup Backend.
   *
   * @return Returns the configuration definition associated with this Backup Backend.
   */
  ManagedObjectDefinition<? extends BackupBackendCfgClient, ? extends BackupBackendCfg> definition();



  /**
   * Gets the "backup-directory" property.
   * <p>
   * Specifies the path to a backup directory containing one or more
   * backups for a particular backend.
   * <p>
   * This is a multivalued property. Each value may specify a
   * different backup directory if desired (one for each backend for
   * which backups are taken). Values may be either absolute paths or
   * paths that are relative to the base of the OpenDJ directory server
   * installation.
   *
   * @return Returns the values of the "backup-directory" property.
   */
  SortedSet<String> getBackupDirectory();



  /**
   * Sets the "backup-directory" property.
   * <p>
   * Specifies the path to a backup directory containing one or more
   * backups for a particular backend.
   * <p>
   * This is a multivalued property. Each value may specify a
   * different backup directory if desired (one for each backend for
   * which backups are taken). Values may be either absolute paths or
   * paths that are relative to the base of the OpenDJ directory server
   * installation.
   *
   * @param values The values of the "backup-directory" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setBackupDirectory(Collection<String> values) throws PropertyException;



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
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();



  /**
   * Sets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @param value The value of the "writability-mode" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setWritabilityMode(WritabilityMode value) throws PropertyException;

}
