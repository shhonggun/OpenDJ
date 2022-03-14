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
 * Copyright 2006-2010 Sun Microsystems, Inc.
 * Portions Copyright 2013-2016 ForgeRock AS.
 */
package org.opends.server.tasks;

import static org.opends.messages.BackendMessages.*;
import static org.opends.server.config.ConfigConstants.*;
import static org.opends.server.util.StaticUtils.*;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.opends.messages.TaskMessages;
import org.opends.server.backends.task.Task;
import org.opends.server.backends.task.TaskState;
import org.opends.server.replication.plugin.LDAPReplicationDomain;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;

/**
 * This class provides an implementation of a Directory Server task that can
 * be used to import data from an LDIF file into a backend.
 */
public class InitializeTargetTask extends Task
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  // Config properties
  private String domainString;
  private LDAPReplicationDomain domain;
  private int target;
  private long total;

  @Override
  public LocalizableMessage getDisplayName() {
    return TaskMessages.INFO_TASK_INITIALIZE_TARGET_NAME.get();
  }

  /** {@inheritDoc} */
  @Override
  public void initializeTask() throws DirectoryException
  {
    if (TaskState.isDone(getTaskState()))
    {
      return;
    }

    // FIXME -- Do we need any special authorization here?
    Entry taskEntry = getTaskEntry();

    domainString = TaskUtils.getSingleValueString(taskEntry.getAllAttributes(ATTR_TASK_INITIALIZE_TARGET_DOMAIN_DN));

    try
    {
      DN dn = DN.valueOf(domainString);
      // We can assume that this is an LDAP replication domain
      domain = LDAPReplicationDomain.retrievesReplicationDomain(dn);
    }
    catch(DirectoryException e)
    {
      LocalizableMessageBuilder mb = new LocalizableMessageBuilder();
      mb.append(TaskMessages.ERR_TASK_INITIALIZE_INVALID_DN.get());
      mb.append(" ");
      mb.append(stackTraceToSingleLineString(e));
      throw new DirectoryException(ResultCode.INVALID_DN_SYNTAX, e);
    }

    target = domain.decodeTarget(TaskUtils.getSingleValueString(
        taskEntry.getAllAttributes(ATTR_TASK_INITIALIZE_TARGET_SCOPE)));

    setTotal(0);
  }

  @Override
  protected TaskState runTask()
  {
    if (logger.isTraceEnabled())
    {
      logger.trace("[IE] InitializeTargetTask is starting on domain: " + domain.getBaseDN());
    }

    try
    {
      domain.initializeRemote(target, this);
    }
    catch (DirectoryException e)
    {
      logger.traceException(e);

      // This log will go to the task log message
      logger.error(ERR_TASK_EXECUTE_FAILED, getTaskEntryDN(), stackTraceToSingleLineString(e));

      return TaskState.STOPPED_BY_ERROR;
    }
    return TaskState.COMPLETED_SUCCESSFULLY;
  }

  /**
   * Set the total number of entries expected to be exported.
   * @param total The total number of entries.
   * @throws DirectoryException when a problem occurs
   */
  public void setTotal(long total) throws DirectoryException
  {
    this.total = total;
    replaceAttributeValue(ATTR_TASK_INITIALIZE_LEFT, String.valueOf(total));
    replaceAttributeValue(ATTR_TASK_INITIALIZE_DONE, String.valueOf(0));
  }

  /**
   * Set the total number of entries still to be exported.
   * @param left The total number of entries to be exported.
   * @throws DirectoryException when a problem occurs
   */
  public void setLeft(long left)  throws DirectoryException
  {
    replaceAttributeValue(ATTR_TASK_INITIALIZE_LEFT, String.valueOf(left));
    replaceAttributeValue(ATTR_TASK_INITIALIZE_DONE,String.valueOf(total-left));
  }
}
