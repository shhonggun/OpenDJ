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
 * Copyright 2007-2008 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.server.backends;

import static org.forgerock.util.Reject.*;
import static org.opends.messages.BackendMessages.*;
import static org.opends.server.util.ServerConstants.*;
import static org.opends.server.util.StaticUtils.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.server.ConfigChangeResult;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.ldap.ConditionResult;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SearchScope;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.server.LDIFBackendCfg;
import org.opends.server.api.AlertGenerator;
import org.opends.server.api.LocalBackend;
import org.opends.server.controls.SubtreeDeleteControl;
import org.opends.server.core.AddOperation;
import org.opends.server.core.DeleteOperation;
import org.opends.server.core.DirectoryServer;
import org.opends.server.core.ModifyDNOperation;
import org.opends.server.core.ModifyOperation;
import org.opends.server.core.SearchOperation;
import org.opends.server.core.ServerContext;
import org.opends.server.types.BackupConfig;
import org.opends.server.types.BackupDirectory;
import org.opends.server.types.Control;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;
import org.opends.server.types.ExistingFileBehavior;
import org.opends.server.types.IndexType;
import org.opends.server.types.InitializationException;
import org.opends.server.types.LDIFExportConfig;
import org.opends.server.types.LDIFImportConfig;
import org.opends.server.types.LDIFImportResult;
import org.opends.server.types.RestoreConfig;
import org.opends.server.types.SearchFilter;
import org.opends.server.util.LDIFException;
import org.opends.server.util.LDIFReader;
import org.opends.server.util.LDIFWriter;
import org.opends.server.util.StaticUtils;

/**
 * This class provides a backend implementation that stores the underlying data
 * in an LDIF file.  When the backend is initialized, the contents of the
 * backend are read into memory and all read operations are performed purely
 * from memory.  Write operations cause the underlying LDIF file to be
 * re-written on disk.
 */
public class LDIFBackend
       extends LocalBackend<LDIFBackendCfg>
       implements ConfigurationChangeListener<LDIFBackendCfg>, AlertGenerator
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /** The base DNs for this backend. */
  private Set<DN> baseDNs;

  /** The mapping between parent DNs and their immediate children. */
  private final Map<DN, Set<DN>> childDNs = new HashMap<>();

  /** The set of supported controls for this backend. */
  private final Set<String> supportedControls =
      Collections.singleton(OID_SUBTREE_DELETE_CONTROL);

  /** The current configuration for this backend. */
  private LDIFBackendCfg currentConfig;

  /** The mapping between entry DNs and the corresponding entries. */
  private final Map<DN, Entry> entryMap = new LinkedHashMap<>();

  /** A read-write lock used to protect access to this backend. */
  private final ReentrantReadWriteLock backendLock = new ReentrantReadWriteLock();

  /** The path to the LDIF file containing the data for this backend. */
  private String ldifFilePath;

  /** The server context. */
  private ServerContext serverContext;

  /**
   * Creates a new backend with the provided information.  All backend
   * implementations must implement a default constructor that use
   * <CODE>super()</CODE> to invoke this constructor.
   */
  public LDIFBackend()
  {
  }

  @Override
  public void openBackend()
         throws ConfigException, InitializationException
  {
    // We won't support anything other than exactly one base DN in this implementation.
    // If we were to add such support in the future, we would likely want
    // to separate the data for each base DN into a separate entry map.
    if (baseDNs == null || baseDNs.size() != 1)
    {
      throw new ConfigException(ERR_LDIF_BACKEND_MULTIPLE_BASE_DNS.get(currentConfig.dn()));
    }

    for (DN dn : baseDNs)
    {
      try
      {
        serverContext.getBackendConfigManager().registerBaseDN(dn, this, currentConfig.isIsPrivateBackend());
      }
      catch (Exception e)
      {
        logger.traceException(e);

        LocalizableMessage message = ERR_BACKEND_CANNOT_REGISTER_BASEDN.get(
            dn, getExceptionMessage(e));
        throw new InitializationException(message, e);
      }
    }

    DirectoryServer.registerAlertGenerator(this);

    readLDIF();
  }

  /**
   * Reads the contents of the LDIF backing file into memory.
   *
   * @throws  InitializationException  If a problem occurs while reading the
   *                                   LDIF file.
   */
  private void readLDIF()
          throws InitializationException
  {
    File ldifFile = getFileForPath(ldifFilePath);
    if (! ldifFile.exists())
    {
      // This is fine.  We will just start with an empty backend.
      if (logger.isTraceEnabled())
      {
        logger.trace("LDIF backend starting empty because LDIF file " +
                         ldifFilePath + " does not exist");
      }

      entryMap.clear();
      childDNs.clear();
      return;
    }

    try
    {
      importLDIF(new LDIFImportConfig(ldifFile.getAbsolutePath()), false);
    }
    catch (DirectoryException de)
    {
      throw new InitializationException(de.getMessageObject(), de);
    }
  }

  /**
   * Writes the current set of entries to the target LDIF file.  The new LDIF
   * will first be created as a temporary file and then renamed into place.  The
   * caller must either hold the write lock for this backend, or must ensure
   * that it's in some other state that guarantees exclusive access to the data.
   *
   * @throws  DirectoryException  If a problem occurs that prevents the updated
   *                              LDIF from being written.
   */
  private void writeLDIF()
          throws DirectoryException
  {
    File ldifFile = getFileForPath(ldifFilePath);
    File tempFile = new File(ldifFile.getAbsolutePath() + ".new");
    File oldFile  = new File(ldifFile.getAbsolutePath() + ".old");

    // Write the new data to a temporary file.
    LDIFWriter writer;
    try
    {
      LDIFExportConfig exportConfig =
           new LDIFExportConfig(tempFile.getAbsolutePath(),
                                ExistingFileBehavior.OVERWRITE);
      writer = new LDIFWriter(exportConfig);
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_CREATING_FILE.get(
                       tempFile.getAbsolutePath(),
                       currentConfig.dn(),
                       stackTraceToSingleLineString(e));
      DirectoryServer.sendAlertNotification(this,
                           ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE, m);
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }

    for (Entry entry : entryMap.values())
    {
      try
      {
        writer.writeEntry(entry);
      }
      catch (Exception e)
      {
        logger.traceException(e);

        StaticUtils.close(writer);

        LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_WRITING_FILE.get(
                         tempFile.getAbsolutePath(),
                         currentConfig.dn(),
                         stackTraceToSingleLineString(e));
        DirectoryServer.sendAlertNotification(this,
                             ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE, m);
        throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                     m, e);
      }
    }

    // On Linux the final write() on a file can actually fail but not throw an Exception.
    // The close() will throw an Exception in this case so we MUST check for Exceptions
    // here.
    try
    {
        writer.close();
    }
    catch (Exception e)
    {
      logger.traceException(e);
      LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_CLOSING_FILE.get(
                       tempFile.getAbsolutePath(),
                       currentConfig.dn(),
                       stackTraceToSingleLineString(e));
      DirectoryServer.sendAlertNotification(this,
                           ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE, m);
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }

    // Extra sanity check
    if (!entryMap.isEmpty() && tempFile.exists() && tempFile.length() == 0)
    {
      LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_EMPTY_FILE.get(
                       tempFile.getAbsolutePath(),
                       currentConfig.dn());
      DirectoryServer.sendAlertNotification(this,
                           ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE, m);
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m);
    }

    if (tempFile.exists())
    {
      // Rename the existing "live" file out of the way and move the new file
      // into place.
      try
      {
        oldFile.delete();
      }
      catch (Exception e)
      {
        logger.traceException(e);
      }
    }

    try
    {
      if (ldifFile.exists())
      {
        ldifFile.renameTo(oldFile);
      }
    }
    catch (Exception e)
    {
      logger.traceException(e);
    }

    try
    {
      tempFile.renameTo(ldifFile);
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_RENAMING_FILE.get(
                       tempFile.getAbsolutePath(),
                       ldifFile.getAbsolutePath(),
                       currentConfig.dn(),
                       stackTraceToSingleLineString(e));
      DirectoryServer.sendAlertNotification(this,
                           ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE, m);
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }
  }

  @Override
  public void closeBackend()
  {
    backendLock.writeLock().lock();

    try
    {
      currentConfig.removeLDIFChangeListener(this);
      DirectoryServer.deregisterAlertGenerator(this);

      for (DN dn : baseDNs)
      {
        try
        {
          serverContext.getBackendConfigManager().deregisterBaseDN(dn);
        }
        catch (Exception e)
        {
          logger.traceException(e);
        }
      }
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  @Override
  public Set<DN> getBaseDNs()
  {
    return baseDNs;
  }

  @Override
  public long getEntryCount()
  {
    backendLock.readLock().lock();

    try
    {
      if (entryMap != null)
      {
        return entryMap.size();
      }

      return -1;
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public boolean isIndexed(AttributeType attributeType, IndexType indexType)
  {
    // All searches in this backend will always be considered indexed.
    return true;
  }

  @Override
  public ConditionResult hasSubordinates(DN entryDN)
         throws DirectoryException
  {
    backendLock.readLock().lock();

    try
    {
      Set<DN> childDNSet = childDNs.get(entryDN);
      if (childDNSet == null || childDNSet.isEmpty())
      {
        // It could be that the entry doesn't exist, in which case we should
        // throw an exception.
        if (entryMap.containsKey(entryDN))
        {
          return ConditionResult.FALSE;
        }
        else
        {
          throw new DirectoryException(ResultCode.NO_SUCH_OBJECT,
              ERR_LDIF_BACKEND_HAS_SUBORDINATES_NO_SUCH_ENTRY.get(entryDN));
        }
      }
      else
      {
        return ConditionResult.TRUE;
      }
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public long getNumberOfChildren(DN parentDN) throws DirectoryException
  {
    checkNotNull(parentDN, "parentDN must not be null");
    return getNumberOfSubordinates(parentDN, false);
  }

  @Override
  public long getNumberOfEntriesInBaseDN(DN baseDN) throws DirectoryException
  {
    checkNotNull(baseDN, "baseDN must not be null");
    if (!baseDNs.contains(baseDN))
    {
      throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM,
          ERR_LDIF_BACKEND_NUM_SUBORDINATES_NO_SUCH_ENTRY.get(baseDN));
    }
    final int baseDNIfExists = childDNs.containsKey(baseDN) ? 1 : 0;
    return getNumberOfSubordinates(baseDN, true) + baseDNIfExists;
  }

  private long getNumberOfSubordinates(DN entryDN, boolean includeSubtree) throws DirectoryException
  {
    backendLock.readLock().lock();

    try
    {
      Set<DN> childDNSet = childDNs.get(entryDN);
      if (childDNSet == null || childDNSet.isEmpty())
      {
        // It could be that the entry doesn't exist, in which case we should
        // throw an exception.
        if (entryMap.containsKey(entryDN))
        {
          return 0L;
        }
        throw new DirectoryException(ResultCode.NO_SUCH_OBJECT, ERR_LDIF_BACKEND_NUM_SUBORDINATES_NO_SUCH_ENTRY
            .get(entryDN));
      }

      if (!includeSubtree)
      {
        return childDNSet.size();
      }

      long count = 0;
      for (DN childDN : childDNSet)
      {
        count += getNumberOfSubordinates(childDN, true);
        count++;
      }
      return count;
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public Entry getEntry(DN entryDN)
  {
    backendLock.readLock().lock();

    try
    {
      return entryMap.get(entryDN);
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public boolean entryExists(DN entryDN)
  {
    backendLock.readLock().lock();

    try
    {
      return entryMap.containsKey(entryDN);
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public void addEntry(Entry entry, AddOperation addOperation)
         throws DirectoryException
  {
    backendLock.writeLock().lock();

    try
    {
      // Make sure that the target entry does not already exist, but that its
      // parent does exist (or that the entry being added is the base DN).
      DN entryDN = entry.getName();
      if (entryMap.containsKey(entryDN))
      {
        LocalizableMessage m = ERR_LDIF_BACKEND_ADD_ALREADY_EXISTS.get(entryDN);
        throw new DirectoryException(ResultCode.ENTRY_ALREADY_EXISTS, m);
      }

      if (baseDNs.contains(entryDN))
      {
        entryMap.put(entryDN, entry.duplicate(false));
        writeLDIF();
        return;
      }
      else
      {
        DN parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(entryDN);
        if (parentDN != null && entryMap.containsKey(parentDN))
        {
          entryMap.put(entryDN, entry.duplicate(false));

          Set<DN> childDNSet = childDNs.get(parentDN);
          if (childDNSet == null)
          {
            childDNSet = new HashSet<>();
            childDNs.put(parentDN, childDNSet);
          }
          childDNSet.add(entryDN);
          writeLDIF();
          return;
        }
        else
        {
          LocalizableMessage m = ERR_LDIF_BACKEND_ADD_MISSING_PARENT.get(entryDN);
          throw new DirectoryException(ResultCode.NO_SUCH_OBJECT, m, findMatchedDN(parentDN), null);
        }
      }
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  private DN findMatchedDN(DN parentDN)
  {
    if (parentDN != null)
    {
      while (true)
      {
        parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(parentDN);
        if (parentDN == null)
        {
          return null;
        }
        else if (entryMap.containsKey(parentDN))
        {
          return parentDN;
        }
      }
    }
    return null;
  }

  @Override
  public void deleteEntry(DN entryDN, DeleteOperation deleteOperation)
         throws DirectoryException
  {
    backendLock.writeLock().lock();

    try
    {
      // Get the DN of the target entry's parent, if it exists.  We'll need to
      // also remove the reference to the target entry from the parent's set of
      // children.
      DN parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(entryDN);

      // Make sure that the target entry exists.  If not, then fail.
      if (! entryMap.containsKey(entryDN))
      {
        DN matchedDN = null;
        while (parentDN != null)
        {
          if (entryMap.containsKey(parentDN))
          {
            matchedDN = parentDN;
            break;
          }

          parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(parentDN);
        }

        LocalizableMessage m = ERR_LDIF_BACKEND_DELETE_NO_SUCH_ENTRY.get(entryDN);
        throw new DirectoryException(ResultCode.NO_SUCH_OBJECT, m, matchedDN, null);
      }

      // See if the target entry has any children.  If so, then we'll only
      // delete it if the request contains the subtree delete control (in
      // which case we'll delete the entire subtree).
      Set<DN> childDNSet = childDNs.get(entryDN);
      if (childDNSet == null || childDNSet.isEmpty())
      {
        entryMap.remove(entryDN);
        childDNs.remove(entryDN);

        if (parentDN != null)
        {
          Set<DN> parentChildren = childDNs.get(parentDN);
          if (parentChildren != null)
          {
            parentChildren.remove(entryDN);
            if (parentChildren.isEmpty())
            {
              childDNs.remove(parentDN);
            }
          }
        }
      }
      else
      {
        boolean subtreeDelete = deleteOperation != null
            && deleteOperation
                .getRequestControl(SubtreeDeleteControl.DECODER) != null;

        if (! subtreeDelete)
        {
          LocalizableMessage m = ERR_LDIF_BACKEND_DELETE_NONLEAF.get(entryDN);
          throw new DirectoryException(ResultCode.NOT_ALLOWED_ON_NONLEAF, m);
        }

        entryMap.remove(entryDN);
        childDNs.remove(entryDN);

        if (parentDN != null)
        {
          Set<DN> parentChildren = childDNs.get(parentDN);
          if (parentChildren != null)
          {
            parentChildren.remove(entryDN);
            if (parentChildren.isEmpty())
            {
              childDNs.remove(parentDN);
            }
          }
        }

        for (DN childDN : childDNSet)
        {
          subtreeDelete(childDN);
        }
      }

      writeLDIF();
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  /**
   * Removes the specified entry and any subordinates that it may have from
   * the backend.  This method assumes that the caller holds the backend write
   * lock.
   *
   * @param  entryDN  The DN of the entry to remove, along with all of its
   *                  subordinate entries.
   */
  private void subtreeDelete(DN entryDN)
  {
    entryMap.remove(entryDN);
    Set<DN> childDNSet = childDNs.remove(entryDN);
    if (childDNSet != null)
    {
      for (DN childDN : childDNSet)
      {
        subtreeDelete(childDN);
      }
    }
  }

  @Override
  public void replaceEntry(Entry oldEntry, Entry newEntry,
      ModifyOperation modifyOperation) throws DirectoryException
  {
    backendLock.writeLock().lock();

    try
    {
      // Make sure that the target entry exists.  If not, then fail.
      DN entryDN = newEntry.getName();
      if (! entryMap.containsKey(entryDN))
      {
        DN matchedDN = null;
        DN parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(entryDN);
        while (parentDN != null)
        {
          if (entryMap.containsKey(parentDN))
          {
            matchedDN = parentDN;
            break;
          }

          parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(parentDN);
        }

        LocalizableMessage m = ERR_LDIF_BACKEND_MODIFY_NO_SUCH_ENTRY.get(entryDN);
        throw new DirectoryException(ResultCode.NO_SUCH_OBJECT, m, matchedDN, null);
      }

      entryMap.put(entryDN, newEntry.duplicate(false));
      writeLDIF();
      return;
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  @Override
  public void renameEntry(DN currentDN, Entry entry,
                          ModifyDNOperation modifyDNOperation)
         throws DirectoryException
  {
    backendLock.writeLock().lock();

    try
    {
      // Make sure that the original entry exists and that the new entry doesn't
      // exist but its parent does.
      DN newDN = entry.getName();
      if (! entryMap.containsKey(currentDN))
      {
        DN matchedDN = null;
        DN parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(currentDN);
        while (parentDN != null)
        {
          if (entryMap.containsKey(parentDN))
          {
            matchedDN = parentDN;
            break;
          }

          parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(parentDN);
        }

        LocalizableMessage m = ERR_LDIF_BACKEND_MODDN_NO_SUCH_SOURCE_ENTRY.get(currentDN);
        throw new DirectoryException(ResultCode.NO_SUCH_OBJECT, m, matchedDN, null);
      }

      if (entryMap.containsKey(newDN))
      {
        LocalizableMessage m = ERR_LDIF_BACKEND_MODDN_TARGET_ENTRY_ALREADY_EXISTS.get(newDN);
        throw new DirectoryException(ResultCode.ENTRY_ALREADY_EXISTS, m);
      }

      DN newParentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(newDN);
      if (! entryMap.containsKey(newParentDN))
      {
        throw new DirectoryException(ResultCode.NO_SUCH_OBJECT,
            ERR_LDIF_BACKEND_MODDN_NEW_PARENT_DOESNT_EXIST.get(newParentDN));
      }

      // Remove the entry from the list of children for the old parent and
      // add the new entry DN to the set of children for the new parent.
      DN oldParentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(currentDN);
      Set<DN> parentChildDNs = childDNs.get(oldParentDN);
      if (parentChildDNs != null)
      {
        parentChildDNs.remove(currentDN);
        if (parentChildDNs.isEmpty()
            && modifyDNOperation.getNewSuperior() != null)
        {
          childDNs.remove(oldParentDN);
        }
      }

      parentChildDNs = childDNs.get(newParentDN);
      if (parentChildDNs == null)
      {
        parentChildDNs = new HashSet<>();
        childDNs.put(newParentDN, parentChildDNs);
      }
      parentChildDNs.add(newDN);

      // If the entry has children, then we'll need to work on the whole
      // subtree.  Otherwise, just work on the target entry.
      Set<DN> childDNSet = childDNs.remove(currentDN);
      entryMap.remove(currentDN);
      entryMap.put(newDN, entry.duplicate(false));
      if (childDNSet != null && !childDNSet.isEmpty())
      {
        for (DN childDN : childDNSet)
        {
          subtreeRename(childDN, newDN);
        }
      }
      writeLDIF();
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  /**
   * Moves the specified entry and all of its children so that they are
   * appropriately placed below the given new parent DN.  This method assumes
   * that the caller holds the backend write lock.
   *
   * @param  entryDN      The DN of the entry to move/rename.
   * @param  newParentDN  The DN of the new parent under which the entry should
   *                      be placed.
   */
  private void subtreeRename(DN entryDN, DN newParentDN)
  {
    Set<DN> childDNSet = childDNs.remove(entryDN);
    DN newEntryDN = newParentDN.child(entryDN.rdn());

    Entry oldEntry = entryMap.remove(entryDN);
    if (oldEntry == null)
    {
      // This should never happen.
      if (logger.isTraceEnabled())
      {
        logger.trace("Subtree rename encountered entry DN " +
                            entryDN + " for nonexistent entry.");
      }
      return;
    }

    Entry newEntry = oldEntry.duplicate(false);
    newEntry.setDN(newEntryDN);
    entryMap.put(newEntryDN, newEntry);

    Set<DN> parentChildren = childDNs.get(newParentDN);
    if (parentChildren == null)
    {
      parentChildren = new HashSet<>();
      childDNs.put(newParentDN, parentChildren);
    }
    parentChildren.add(newEntryDN);

    if (childDNSet != null)
    {
      for (DN childDN : childDNSet)
      {
        subtreeRename(childDN, newEntryDN);
      }
    }
  }

  @Override
  public void search(SearchOperation searchOperation)
         throws DirectoryException
  {
    backendLock.readLock().lock();

    try
    {
      // Get the base DN, scope, and filter for the search.
      DN           baseDN = searchOperation.getBaseDN();
      SearchScope  scope  = searchOperation.getScope();
      SearchFilter filter = searchOperation.getFilter();

      // Make sure the base entry exists if it's supposed to be in this backend.
      Entry baseEntry = entryMap.get(baseDN);
      if (baseEntry == null && handlesEntry(baseDN))
      {
        DN matchedDN = serverContext.getBackendConfigManager().getParentDNInSuffix(baseDN);
        while (matchedDN != null)
        {
          if (entryMap.containsKey(matchedDN))
          {
            break;
          }

          matchedDN = serverContext.getBackendConfigManager().getParentDNInSuffix(matchedDN);
        }

        LocalizableMessage m = ERR_LDIF_BACKEND_SEARCH_NO_SUCH_BASE.get(baseDN);
        throw new DirectoryException(
                ResultCode.NO_SUCH_OBJECT, m, matchedDN, null);
      }

      if (baseEntry != null)
      {
        baseEntry = baseEntry.duplicate(true);
      }

      // If it's a base-level search, then just get that entry and return it if
      // it matches the filter.
      if (scope == SearchScope.BASE_OBJECT)
      {
        if (filter.matchesEntry(baseEntry))
        {
          searchOperation.returnEntry(baseEntry, new LinkedList<Control>());
        }
      }
      else
      {
        // Walk through all entries and send the ones that match.
        for (Entry e : entryMap.values())
        {
          e = e.duplicate(true);
          if (e.matchesBaseAndScope(baseDN, scope) && filter.matchesEntry(e))
          {
            searchOperation.returnEntry(e, new LinkedList<Control>());
          }
        }
      }
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  @Override
  public Set<String> getSupportedControls()
  {
    return supportedControls;
  }

  @Override
  public Set<String> getSupportedFeatures()
  {
    return Collections.emptySet();
  }

  @Override
  public boolean supports(BackendOperation backendOperation)
  {
    switch (backendOperation)
    {
    case LDIF_EXPORT:
    case LDIF_IMPORT:
      return true;

    default:
      return false;
    }
  }

  @Override
  public void exportLDIF(LDIFExportConfig exportConfig)
         throws DirectoryException
  {
    backendLock.readLock().lock();

    try (LDIFWriter ldifWriter = newLDIFWriter(exportConfig))
    {
      // Walk through all the entries and write them to LDIF.
      for (Entry entry : entryMap.values())
      {
        DN entryDN = entry.getName();
        try
        {
          ldifWriter.writeEntry(entry);
        }
        catch (Exception e)
        {
          LocalizableMessage m =
              ERR_LDIF_BACKEND_CANNOT_WRITE_ENTRY_TO_LDIF.get(entryDN, stackTraceToSingleLineString(e));
          throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m, e);
        }
      }
    }
    catch (IOException ignoreOnClose)
    {
      logger.traceException(ignoreOnClose);
    }
    finally
    {
      backendLock.readLock().unlock();
    }
  }

  private LDIFWriter newLDIFWriter(LDIFExportConfig exportConfig) throws DirectoryException
  {
    try
    {
      return new LDIFWriter(exportConfig);
    }
    catch (Exception e)
    {
      logger.traceException(e);
      LocalizableMessage m = ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_WRITER.get(stackTraceToSingleLineString(e));
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m, e);
    }
  }

  @Override
  public LDIFImportResult importLDIF(LDIFImportConfig importConfig, ServerContext serverContext)
      throws DirectoryException
  {
    return importLDIF(importConfig, true);
  }

  /**
   * Processes an LDIF import operation, optionally writing the resulting LDIF
   * to disk.
   *
   * @param  importConfig  The LDIF import configuration.
   * @param  writeLDIF     Indicates whether the LDIF backing file for this
   *                       backend should be updated when the import is
   *                       complete.  This should only be {@code false} when
   *                       reading the LDIF as the backend is coming online.
   */
  private LDIFImportResult importLDIF(LDIFImportConfig importConfig,
                                     boolean writeLDIF)
         throws DirectoryException
  {
    backendLock.writeLock().lock();

    try (LDIFReader reader = newLDIFReader(importConfig))
    {
      entryMap.clear();
      childDNs.clear();

      try
      {
        while (true)
        {
          Entry e = null;
          try
          {
            e = reader.readEntry();
            if (e == null)
            {
              break;
            }
          }
          catch (LDIFException le)
          {
            if (! le.canContinueReading())
            {
              LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_READING_LDIF.get(
                               stackTraceToSingleLineString(le));
              throw new DirectoryException(
                             DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m, le);
            }
            continue;
          }

          // Make sure that we don't already have an entry with the same DN.  If
          // a duplicate is encountered, then log a message and continue.
          DN entryDN = e.getName();
          if (entryMap.containsKey(entryDN))
          {
            LocalizableMessage m =
                ERR_LDIF_BACKEND_DUPLICATE_ENTRY.get(ldifFilePath, currentConfig.dn(), entryDN);
            logger.error(m);
            reader.rejectLastEntry(m);
            continue;
          }

          // If the entry DN is a base DN, then add it with no more processing.
          if (baseDNs.contains(entryDN))
          {
            entryMap.put(entryDN, e);
            continue;
          }

          // Make sure that the parent exists.  If not, then reject the entry.
          if (!isBelowBaseDN(entryDN))
          {
            LocalizableMessage m = ERR_LDIF_BACKEND_ENTRY_OUT_OF_SCOPE.get(
                ldifFilePath, currentConfig.dn(), entryDN);
            logger.error(m);
            reader.rejectLastEntry(m);
            continue;
          }

          DN parentDN = serverContext.getBackendConfigManager().getParentDNInSuffix(entryDN);
          if (parentDN == null || !entryMap.containsKey(parentDN))
          {
            LocalizableMessage m = ERR_LDIF_BACKEND_MISSING_PARENT.get(
                ldifFilePath, currentConfig.dn(), entryDN);
            logger.error(m);
            reader.rejectLastEntry(m);
            continue;
          }

          // The entry does not exist but its parent does, so add it and update
          // the set of children for the parent.
          entryMap.put(entryDN, e);

          Set<DN> childDNSet = childDNs.get(parentDN);
          if (childDNSet == null)
          {
            childDNSet = new HashSet<>();
            childDNs.put(parentDN, childDNSet);
          }

          childDNSet.add(entryDN);
        }

        if (writeLDIF)
        {
          writeLDIF();
        }

        return new LDIFImportResult(reader.getEntriesRead(),
                                    reader.getEntriesRejected(),
                                    reader.getEntriesIgnored());
      }
      catch (DirectoryException de)
      {
        throw de;
      }
      catch (Exception e)
      {
        LocalizableMessage m = ERR_LDIF_BACKEND_ERROR_READING_LDIF.get(stackTraceToSingleLineString(e));
        throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m, e);
      }
    }
    finally
    {
      backendLock.writeLock().unlock();
    }
  }

  private boolean isBelowBaseDN(DN entryDN)
  {
    for (DN baseDN : baseDNs)
    {
      if (baseDN.isSuperiorOrEqualTo(entryDN))
      {
        return true;
      }
    }
    return false;
  }

  private LDIFReader newLDIFReader(LDIFImportConfig importConfig) throws DirectoryException
  {
    try
    {
      return new LDIFReader(importConfig);
    }
    catch (Exception e)
    {
      LocalizableMessage m = ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_READER.get(stackTraceToSingleLineString(e));
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(), m, e);
    }
  }

  @Override
  public void createBackup(BackupConfig backupConfig)
         throws DirectoryException
  {
    LocalizableMessage message = ERR_LDIF_BACKEND_BACKUP_RESTORE_NOT_SUPPORTED.get();
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM, message);
  }

  @Override
  public void removeBackup(BackupDirectory backupDirectory, String backupID)
         throws DirectoryException
  {
    LocalizableMessage message = ERR_LDIF_BACKEND_BACKUP_RESTORE_NOT_SUPPORTED.get();
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM, message);
  }

  @Override
  public void restoreBackup(RestoreConfig restoreConfig)
         throws DirectoryException
  {
    LocalizableMessage message = ERR_LDIF_BACKEND_BACKUP_RESTORE_NOT_SUPPORTED.get();
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM, message);
  }

  @Override
  public void configureBackend(LDIFBackendCfg config, ServerContext serverContext) throws ConfigException
  {
    this.serverContext = serverContext;
    if (config != null)
    {
      currentConfig = config;
      currentConfig.addLDIFChangeListener(this);

      baseDNs = currentConfig.getBaseDN();
      if (baseDNs.size() != 1)
      {
        throw new ConfigException(ERR_LDIF_BACKEND_MULTIPLE_BASE_DNS.get(currentConfig.dn()));
      }

      ldifFilePath = currentConfig.getLDIFFile();
    }
  }

  @Override
  public boolean isConfigurationChangeAcceptable(LDIFBackendCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    boolean configAcceptable = true;

    // Make sure that there is only a single base DN.
    if (configuration.getBaseDN().size() != 1)
    {
      unacceptableReasons.add(ERR_LDIF_BACKEND_MULTIPLE_BASE_DNS.get(configuration.dn()));
      configAcceptable = false;
    }

    return configAcceptable;
  }

  @Override
  public ConfigChangeResult applyConfigurationChange(
                                 LDIFBackendCfg configuration)
  {
    // We don't actually need to do anything in response to this.  However, if
    // the base DNs or LDIF file are different from what we're currently using
    // then indicate that admin action is required.
    final ConfigChangeResult ccr = new ConfigChangeResult();

    if (ldifFilePath != null)
    {
      File currentLDIF = getFileForPath(ldifFilePath);
      File newLDIF     = getFileForPath(configuration.getLDIFFile());
      if (! currentLDIF.equals(newLDIF))
      {
        ccr.addMessage(INFO_LDIF_BACKEND_LDIF_FILE_CHANGED.get());
        ccr.setAdminActionRequired(true);
      }
    }

    if (baseDNs != null && !baseDNs.equals(configuration.getBaseDN()))
    {
      ccr.addMessage(INFO_LDIF_BACKEND_BASE_DN_CHANGED.get());
      ccr.setAdminActionRequired(true);
    }

    currentConfig = configuration;
    return ccr;
  }

  @Override
  public DN getComponentEntryDN()
  {
    return currentConfig.dn();
  }

  @Override
  public String getClassName()
  {
    return LDIFBackend.class.getName();
  }

  @Override
  public Map<String,String> getAlerts()
  {
    Map<String,String> alerts = new LinkedHashMap<>();
    alerts.put(ALERT_TYPE_LDIF_BACKEND_CANNOT_WRITE_UPDATE,
               ALERT_DESCRIPTION_LDIF_BACKEND_CANNOT_WRITE_UPDATE);
    return alerts;
  }
}
