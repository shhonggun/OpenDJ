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
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2015-2016 ForgeRock AS.
 */
package org.opends.server.api;

import org.opends.server.types.BackupConfig;

/**
 * This interface defines a set of methods that may be used to notify
 * various Directory Server components whenever a backend backup task
 * is about to begin or has just completed.  Note that these methods
 * will only be invoked for the backup task and not for offline backup
 * processing.
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.VOLATILE,
     mayInstantiate=false,
     mayExtend=true,
     mayInvoke=false)
public interface BackupTaskListener
{
  /**
   * Performs any processing that might be necessary just before the
   * server begins processing on a backup task.  This may include
   * flushing any outstanding writes to disk so they are included in
   * the backup and/or pausing interaction with the provided backend
   * while the backup is in progress.
   *
   * @param  backend  The backend to be archived.
   * @param  config   Configuration information about the backup to be
   *                  performed.
   */
  void processBackupBegin(LocalBackend<?> backend, BackupConfig config);

  /**
   * Performs any processing that might be necessary after the server
   * has completed processing on a backup task.  Note that this will
   * always be called when backup processing completes, regardless of
   * whether it was successful.
   *
   * @param  backend     The backend that was archived.
   * @param  config      Configuration information about the backup
   *                     that was performed.
   * @param  successful  Indicates whether the backup operation
   *                     completed successfully.
   */
  void processBackupEnd(LocalBackend<?> backend, BackupConfig config, boolean successful);
}
