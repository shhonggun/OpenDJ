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
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.server.api;

import static org.opends.messages.BackendMessages.*;

import java.util.Collection;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.ConditionResult;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.MatchingRule;
import org.forgerock.opendj.ldap.schema.UnknownSchemaElementException;
import org.opends.server.backends.RebuildConfig;
import org.opends.server.backends.VerifyConfig;
import org.opends.server.core.AddOperation;
import org.opends.server.core.DeleteOperation;
import org.opends.server.core.DirectoryServer;
import org.opends.server.core.ModifyDNOperation;
import org.opends.server.core.ModifyOperation;
import org.opends.server.core.PersistentSearch;
import org.opends.server.core.PersistentSearch.CancellationCallback;
import org.opends.server.core.SearchOperation;
import org.opends.server.core.ServerContext;
import org.opends.server.monitors.LocalBackendMonitor;
import org.opends.server.types.BackupConfig;
import org.opends.server.types.BackupDirectory;
import org.opends.server.types.CanceledOperationException;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;
import org.opends.server.types.IndexType;
import org.opends.server.types.InitializationException;
import org.opends.server.types.LDIFExportConfig;
import org.opends.server.types.LDIFImportConfig;
import org.opends.server.types.LDIFImportResult;
import org.opends.server.types.RestoreConfig;
import org.opends.server.types.SearchFilter;
import org.opends.server.types.WritabilityMode;
/**
 * This class defines the set of methods and structures that must be
 * implemented for a Directory Server backend.
 *
 * @param <C>
 *          the type of the BackendCfg for the current backend
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.VOLATILE,
     mayInstantiate=false,
     mayExtend=true,
     mayInvoke=false)
public abstract class LocalBackend<C extends Configuration> extends Backend<C>
// should have been BackendCfg instead of Configuration
{
  /** Indicates whether this is a private backend or one that holds user data. */
  private boolean isPrivateBackend;

  /** The writability mode for this backend. */
  private WritabilityMode writabilityMode = WritabilityMode.ENABLED;

  /** The set of persistent searches registered with this backend. */
  private final ConcurrentLinkedQueue<PersistentSearch> persistentSearches = new ConcurrentLinkedQueue<>();

  /** The backend monitor associated with this backend. */
  private LocalBackendMonitor backendMonitor;

  /**
   * Opens this backend based on the information provided when the backend was configured.
   * It also should open any underlying storage and register all suffixes with the server.
   *
   * @see #configureBackend
   *
   * @throws  ConfigException  If an unrecoverable problem arises while opening the backend.
   *
   * @throws  InitializationException  If a problem occurs during opening that is not
   *                                   related to the server configuration.
   */
  @Override
  public abstract void openBackend() throws ConfigException, InitializationException;

  @Override
  public final void finalizeBackend()
  {
    for (PersistentSearch psearch : persistentSearches)
    {
      psearch.cancel();
    }
    persistentSearches.clear();
    closeBackend();
  }

  /**
   * Performs any necessary work to finally close this backend, particularly
   * closing any underlying databases or connections and deregistering
   * any suffixes that it manages with the Directory Server.
   * <p>
   * It will be called as final step of <code>finalizeBackend()</code>,
   * so subclasses might override it.
   * </p>
   */
  public void closeBackend()
  {
  }

  /**
   * Indicates whether search operations which target the specified
   * attribute in the indicated manner would be considered indexed
   * in this backend.  The operation should be considered indexed only
   * if the specified operation can be completed efficiently within
   * the backend.
   * <BR><BR>
   * Note that this method should return a general result that covers
   * all values of the specified attribute.  If a the specified
   * attribute is indexed in the indicated manner but some particular
   * values may still be treated as unindexed (e.g., if the number of
   * entries with that attribute value exceeds some threshold), then
   * this method should still return {@code true} for the specified
   * attribute and index type.
   *
   * @param  attributeType  The attribute type for which to make the
   *                        determination.
   * @param  indexType      The index type for which to make the
   *                        determination.
   *
   * @return  {@code true} if search operations targeting the
   *          specified attribute in the indicated manner should be
   *          considered indexed, or {@code false} if not.
   */
  public abstract boolean isIndexed(AttributeType attributeType, IndexType indexType);

  /**
   * Indicates whether extensible match search operations that target
   * the specified attribute with the given matching rule should be
   * considered indexed in this backend.
   *
   * @param  attributeType  The attribute type for which to make the
   *                        determination.
   * @param  matchingRule   The matching rule for which to make the
   *                        determination.
   *
   * @return  {@code true} if extensible match search operations
   *          targeting the specified attribute with the given
   *          matching rule should be considered indexed, or
   *          {@code false} if not.
   */
  private boolean isIndexed(AttributeType attributeType, MatchingRule matchingRule)
  {
    return false; // FIXME This should be overridden by the JE Backend at least!
  }

  /**
   * Indicates whether a subtree search using the provided filter
   * would be indexed in this backend.  This default implementation
   * uses a rough set of logic that makes a best-effort determination.
   * Subclasses that provide a more complete indexing mechanism may
   * wish to override this method and provide a more accurate result.
   *
   * @param  filter  The search filter for which to make the
   *                 determination.
   *
   * @return  {@code true} if it is believed that the provided filter
   *          would be indexed in this backend, or {@code false} if
   *          not.
   */
  public boolean isIndexed(SearchFilter filter)
  {
    switch (filter.getFilterType())
    {
      case AND:
        // At least one of the subordinate filter components must be
        // indexed.
        for (SearchFilter f : filter.getFilterComponents())
        {
          if (isIndexed(f))
          {
            return true;
          }
        }
        return false;


      case OR:
        for (SearchFilter f : filter.getFilterComponents())
        {
          if (! isIndexed(f))
          {
            return false;
          }
        }
        return !filter.getFilterComponents().isEmpty();


      case NOT:
        // NOT filters are not considered indexed by default.
        return false;

      case EQUALITY:
        return isIndexed(filter.getAttributeType(), IndexType.EQUALITY);

      case SUBSTRING:
        return isIndexed(filter.getAttributeType(), IndexType.SUBSTRING);

      case GREATER_OR_EQUAL:
        return isIndexed(filter.getAttributeType(), IndexType.GREATER_OR_EQUAL);

      case LESS_OR_EQUAL:
        return isIndexed(filter.getAttributeType(), IndexType.LESS_OR_EQUAL);

      case PRESENT:
        return isIndexed(filter.getAttributeType(), IndexType.PRESENCE);

      case APPROXIMATE_MATCH:
        return isIndexed(filter.getAttributeType(), IndexType.APPROXIMATE);

      case EXTENSIBLE_MATCH:
        // The attribute type must be provided for us to make the
        // determination.  If a matching rule ID is provided, then
        // we'll use it as well, but if not then we'll use the
        // default equality matching rule for the attribute type.
        AttributeType attrType = filter.getAttributeType();
        if (attrType == null)
        {
          return false;
        }

        String matchingRuleID = filter.getMatchingRuleID();
        MatchingRule matchingRule = getMatchingRule(attrType, matchingRuleID);
        // FIXME isIndexed() always return false down below
        return matchingRule != null && isIndexed(attrType, matchingRule);


      default:
        return false;
    }
  }

  private MatchingRule getMatchingRule(AttributeType attrType, String matchingRuleID)
  {
    if (matchingRuleID == null)
    {
      return attrType.getEqualityMatchingRule();
    }

    try
    {
      return DirectoryServer.getInstance().getServerContext().getSchema().getMatchingRule(matchingRuleID);
    }
    catch (UnknownSchemaElementException e)
    {
      return null;
    }
  }

  /**
   * Indicates whether the requested entry has any subordinates.
   *
   * @param entryDN The distinguished name of the entry.
   *
   * @return {@code ConditionResult.TRUE} if the entry has one or more
   *         subordinates or {@code ConditionResult.FALSE} otherwise
   *         or {@code ConditionResult.UNDEFINED} if it can not be
   *         determined.
   *
   * @throws DirectoryException  If a problem occurs while trying to
   *                              retrieve the entry.
   */
  public abstract ConditionResult hasSubordinates(DN entryDN) throws DirectoryException;

  /**
   * Retrieves the number of subordinates immediately below the requested entry.
   *
   * @param parentDN
   *          The distinguished name of the parent.
   * @return The number of subordinate entries for the requested entry.
   * @throws DirectoryException
   *           If baseDN isn't a base dn managed by this backend or if a problem occurs while trying to retrieve the
   *           entry.
   * @throws NullPointerException
   *           if baseDN is null.
   */
  public abstract long getNumberOfChildren(DN parentDN) throws DirectoryException;

  /**
   * Retrieves the number of entries for the specified base DN including all entries from the requested entry to the
   * lowest level in the tree.
   *
   * @param baseDN
   *          The base distinguished name.
   * @return The number of subordinate entries including the base dn.
   * @throws DirectoryException
   *           If baseDN isn't a base dn managed by this backend or if a problem occurs while trying to retrieve the
   *           entry.
   * @throws NullPointerException
   *           if baseDN is null.
   */
  public abstract long getNumberOfEntriesInBaseDN(DN baseDN) throws DirectoryException;

  /**
   * Indicates whether an entry with the specified DN exists in the backend. The default
   * implementation calls {@code getEntry}, but backend implementations may override this with a
   * more efficient version. The caller is not required to hold any locks on the specified DN.
   *
   * @param entryDN
   *          The DN of the entry for which to determine existence.
   * @return {@code true} if the specified entry exists in this backend, or {@code false} if it does
   *         not.
   * @throws DirectoryException
   *           If a problem occurs while trying to make the determination.
   */
  public boolean entryExists(DN entryDN) throws DirectoryException
  {
    return getEntry(entryDN) != null;
  }

  /**
   * Retrieves the requested entry from this backend. The caller is not required to hold any locks
   * on the specified DN.
   *
   * @param entryDN
   *          The distinguished name of the entry to retrieve.
   * @return The requested entry, or {@code null} if the entry does not exist.
   * @throws DirectoryException
   *           If a problem occurs while trying to retrieve the entry.
   */
  public abstract Entry getEntry(DN entryDN) throws DirectoryException;

  /**
   * Adds the provided entry to this backend.  This method must ensure
   * that the entry is appropriate for the backend and that no entry
   * already exists with the same DN.  The caller must hold a write
   * lock on the DN of the provided entry.
   *
   * @param  entry         The entry to add to this backend.
   * @param  addOperation  The add operation with which the new entry
   *                       is associated.  This may be {@code null}
   *                       for adds performed internally.
   *
   * @throws  DirectoryException  If a problem occurs while trying to
   *                              add the entry.
   *
   * @throws CanceledOperationException  If this backend noticed and
   *                                       reacted to a request to
   *                                       cancel or abandon the add
   *                                       operation.
   */
  public abstract void addEntry(Entry entry, AddOperation addOperation)
         throws DirectoryException, CanceledOperationException;

  /**
   * Removes the specified entry from this backend.  This method must
   * ensure that the entry exists and that it does not have any
   * subordinate entries (unless the backend supports a subtree delete
   * operation and the client included the appropriate information in
   * the request).  The caller must hold a write lock on the provided
   * entry DN.
   *
   * @param  entryDN          The DN of the entry to remove from this
   *                          backend.
   * @param  deleteOperation  The delete operation with which this
   *                          action is associated.  This may be
   *                          {@code null} for deletes performed
   *                          internally.
   *
   * @throws  DirectoryException  If a problem occurs while trying to
   *                              remove the entry.
   *
   * @throws CanceledOperationException  If this backend noticed and
   *                                       reacted to a request to
   *                                       cancel or abandon the
   *                                       delete operation.
   */
  public abstract void deleteEntry(DN entryDN, DeleteOperation deleteOperation)
         throws DirectoryException, CanceledOperationException;

  /**
   * Replaces the specified entry with the provided entry in this
   * backend. The backend must ensure that an entry already exists
   * with the same DN as the provided entry. The caller must hold a
   * write lock on the DN of the provided entry.
   *
   * @param oldEntry
   *          The original entry that is being replaced.
   * @param newEntry
   *          The new entry to use in place of the existing entry with
   *          the same DN.
   * @param modifyOperation
   *          The modify operation with which this action is
   *          associated. This may be {@code null} for modifications
   *          performed internally.
   * @throws DirectoryException
   *           If a problem occurs while trying to replace the entry.
   * @throws CanceledOperationException
   *           If this backend noticed and reacted to a request to
   *           cancel or abandon the modify operation.
   */
  public abstract void replaceEntry(Entry oldEntry, Entry newEntry,
      ModifyOperation modifyOperation) throws DirectoryException,
      CanceledOperationException;

  /**
   * Moves and/or renames the provided entry in this backend, altering
   * any subordinate entries as necessary. This must ensure that an
   * entry already exists with the provided current DN, and that no
   * entry exists with the target DN of the provided entry. The caller
   * must hold write locks on both the current DN and the new DN for
   * the entry.
   *
   * @param currentDN
   *          The current DN of the entry to be moved/renamed.
   * @param entry
   *          The new content to use for the entry.
   * @param modifyDNOperation
   *          The modify DN operation with which this action is
   *          associated. This may be {@code null} for modify DN
   *          operations performed internally.
   * @throws DirectoryException
   *           If a problem occurs while trying to perform the rename.
   * @throws CanceledOperationException
   *           If this backend noticed and reacted to a request to
   *           cancel or abandon the modify DN operation.
   */
  public abstract void renameEntry(DN currentDN, Entry entry, ModifyDNOperation modifyDNOperation)
         throws DirectoryException, CanceledOperationException;

  /**
   * Processes the specified search in this backend.  Matching entries
   * should be provided back to the core server using the
   * {@code SearchOperation.returnEntry} method.  The caller is not
   * required to have any locks when calling this operation.
   *
   * @param  searchOperation  The search operation to be processed.
   *
   * @throws  DirectoryException  If a problem occurs while processing
   *                              the search.
   *
   * @throws CanceledOperationException  If this backend noticed and
   *                                       reacted to a request to
   *                                       cancel or abandon the
   *                                       search operation.
   */
  public abstract void search(SearchOperation searchOperation)
         throws DirectoryException, CanceledOperationException;

  /** Enumeration of optional backend operations. */
  public static enum BackendOperation
  {
    /** Indicates whether this backend supports indexing attributes to speed up searches. */
    INDEXING,
    /** Indicates whether this backend supports exporting the data it contains to an LDIF file. */
    LDIF_EXPORT,
    /** Indicates whether this backend supports importing its data from an LDIF file. */
    LDIF_IMPORT,
    /**
     * Indicates whether this backend provides a backup mechanism of any kind. This method is used
     * by the backup process when backing up all backends to determine whether this backend is one
     * that should be skipped. It should only return {@code true} for backends that it is not
     * possible to archive directly (e.g., those that don't store their data locally, but rather
     * pass through requests to some other repository).
     */
    BACKUP,
    /** Indicates whether this backend can restore a backup. */
    RESTORE;
  }

  /**
   * Indicates whether this backend supports the provided backend operation.
   *
   * @param backendOperation
   *          the backend operation
   * @return {@code true} if this backend supports the provided backend operation, {@code false}
   *         otherwise.
   */
  public abstract boolean supports(BackendOperation backendOperation);

  /**
   * Exports the contents of this backend to LDIF. This method should only be called if
   * {@link #supports(BackendOperation)} with {@link BackendOperation#LDIF_EXPORT} returns
   * {@code true}.
   * <p>
   * Note that the server will not explicitly initialize this backend before calling this method.
   *
   * @param exportConfig
   *          The configuration to use when performing the export.
   * @throws DirectoryException
   *           If a problem occurs while performing the LDIF export.
   */
  public abstract void exportLDIF(LDIFExportConfig exportConfig) throws DirectoryException;

  /**
   * Imports information from an LDIF file into this backend. This method should only be called if
   * {@link #supports(BackendOperation)} with {@link BackendOperation#LDIF_IMPORT} returns
   * {@code true}.
   * <p>
   * Note that the server will not explicitly initialize this backend before calling this method.
   *
   * @param importConfig
   *          The configuration to use when performing the import.
   * @param serverContext
   *          The server context
   * @return Information about the result of the import processing.
   * @throws DirectoryException
   *           If a problem occurs while performing the LDIF import.
   */
  public abstract LDIFImportResult importLDIF(LDIFImportConfig importConfig, ServerContext serverContext)
      throws DirectoryException;

  /**
   * Verify the integrity of the backend instance.
   *
   * @param verifyConfig
   *          The verify configuration.
   * @return The results of the operation.
   * @throws ConfigException
   *           If an unrecoverable problem arises during initialization.
   * @throws InitializationException
   *           If a problem occurs during initialization that is not related to the server
   *           configuration.
   * @throws DirectoryException
   *           If a Directory Server error occurs.
   */
  public long verifyBackend(VerifyConfig verifyConfig)
      throws InitializationException, ConfigException, DirectoryException
  {
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM,
        ERR_INDEXES_NOT_SUPPORTED.get(getBackendID()));
  }

  /**
   * Rebuild indexes in the backend instance. Note that the server will not explicitly initialize
   * this backend before calling this method.
   *
   * @param rebuildConfig
   *          The rebuild configuration.
   * @param serverContext
   *          The server context for this instance
   * @throws ConfigException
   *           If an unrecoverable problem arises during initialization.
   * @throws InitializationException
   *           If a problem occurs during initialization that is not related to the server
   *           configuration.
   * @throws DirectoryException
   *           If a Directory Server error occurs.
   */
  public void rebuildBackend(RebuildConfig rebuildConfig, ServerContext serverContext)
      throws InitializationException, ConfigException, DirectoryException
  {
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM,
        ERR_INDEXES_NOT_SUPPORTED.get(getBackendID()));
  }

  /**
   * Creates a backup of the contents of this backend in a form that may be restored at a later date
   * if necessary. This method should only be called if {@link #supports(BackendOperation)} with
   * {@link BackendOperation#BACKUP} returns {@code true}.
   * <p>
   * Note that the server will not explicitly initialize this backend before calling this method.
   *
   * @param backupConfig
   *          The configuration to use when performing the backup.
   * @throws DirectoryException
   *           If a problem occurs while performing the backup.
   */
  public abstract void createBackup(BackupConfig backupConfig) throws DirectoryException;

  /**
   * Removes the specified backup if it is possible to do so.
   *
   * @param  backupDirectory  The backup directory structure with
   *                          which the specified backup is
   *                          associated.
   * @param  backupID         The backup ID for the backup to be
   *                          removed.
   *
   * @throws  DirectoryException  If it is not possible to remove the
   *                              specified backup for some reason
   *                              (e.g., no such backup exists or
   *                              there are other backups that are
   *                              dependent upon it).
   */
  public abstract void removeBackup(BackupDirectory backupDirectory, String backupID)
         throws DirectoryException;

  /**
   * Restores a backup of the contents of this backend. This method should only be called if
   * {@link #supports(BackendOperation)} with {@link BackendOperation#RESTORE} returns {@code true}.
   * <p>
   * Note that the server will not explicitly initialize this backend before calling this method.
   *
   * @param restoreConfig
   *          The configuration to use when performing the restore.
   * @throws DirectoryException
   *           If a problem occurs while performing the restore.
   */
  public abstract void restoreBackup(RestoreConfig restoreConfig) throws DirectoryException;

  /**
   * Retrieves the writability mode for this backend.
   *
   * @return  The writability mode for this backend.
   */
  public final WritabilityMode getWritabilityMode()
  {
    return writabilityMode;
  }

  /**
   * Specifies the writability mode for this backend.
   *
   * @param  writabilityMode  The writability mode for this backend.
   */
  public final void setWritabilityMode(WritabilityMode writabilityMode)
  {
    this.writabilityMode = writabilityMode != null ? writabilityMode : WritabilityMode.ENABLED;
  }

  @Override
  public final boolean isPrivateBackend()
  {
    return isPrivateBackend;
  }

  /**
   * Specifies whether this backend holds private data or user data.
   *
   * @param  isPrivateBackend  Specifies whether this backend holds
   *                           private data or user data.
   */
  public final void setPrivateBackend(boolean isPrivateBackend)
  {
    this.isPrivateBackend = isPrivateBackend;
  }

  @Override
  public final boolean isDefaultRoute()
  {
    return false;
  }

  /**
   * Registers the provided persistent search operation with this backend so
   * that it will be notified of any add, delete, modify, or modify DN
   * operations that are performed.
   *
   * @param persistentSearch
   *          The persistent search operation to register with this backend
   * @throws DirectoryException
   *           If a problem occurs while registering the persistent search
   */
  public void registerPersistentSearch(PersistentSearch persistentSearch) throws DirectoryException
  {
    persistentSearches.add(persistentSearch);

    persistentSearch.registerCancellationCallback(new CancellationCallback()
    {
      @Override
      public void persistentSearchCancelled(PersistentSearch psearch)
      {
        persistentSearches.remove(psearch);
      }
    });
  }

  /**
   * Returns the persistent searches currently active against this local
   * backend.
   *
   * @return the list of persistent searches currently active against this local
   *         backend
   */
  public Queue<PersistentSearch> getPersistentSearches()
  {
    return persistentSearches;
  }

  /**
   * Retrieves the total number of entries contained in this backend,
   * if that information is available.
   *
   * @return  The total number of entries contained in this backend,
   *          or -1 if that information is not available.
   */
  public abstract long getEntryCount();

  /**
   * Indicates whether this backend should be used to handle
   * operations for the provided entry.
   *
   * @param  entryDN  The DN of the entry for which to make the
   *                  determination.
   *
   * @return  {@code true} if this backend handles operations for the
   *          provided entry, or {@code false} if it does not.
   */
  public final boolean handlesEntry(DN entryDN)
  {
    Backend<?> backend =
        DirectoryServer.getInstance().getServerContext().getBackendConfigManager().findBackendForEntry(entryDN);
    return backend != null && backend == this;
  }

  /**
   * Retrieves the backend monitor that is associated with this
   * backend.
   *
   * @return  The backend monitor that is associated with this
   *          backend, or {@code null} if none has been assigned.
   */
  public final LocalBackendMonitor getBackendMonitor()
  {
    return backendMonitor;
  }

  /**
   * Sets the backend monitor for this backend.
   *
   * @param  backendMonitor  The backend monitor for this backend.
   */
  public final void setBackendMonitor(LocalBackendMonitor backendMonitor)
  {
    this.backendMonitor = backendMonitor;
  }

  /**
   * Indicates whether this backend supports the specified control.
   *
   * @param  controlOID  The OID of the control for which to make the
   *                     determination.
   *
   * @return  {@code true} if this backends supports the control with
   *          the specified OID, or {@code false} if it does not.
   */
  public final boolean supportsControl(String controlOID)
  {
    Set<String> supportedControls = getSupportedControls();
    return supportedControls != null && supportedControls.contains(controlOID);
  }

  /**
   * Indicates whether a backend should be used to handle operations
   * for the provided entry given the set of base DNs and exclude DNs.
   *
   * @param  entryDN     The DN of the entry for which to make the
   *                     determination.
   * @param  baseDNs     The set of base DNs for the backend.
   * @param  excludeDNs  The set of DNs that should be excluded from
   *                     the backend.
   *
   * @return  {@code true} if the backend should handle operations for
   *          the provided entry, or {@code false} if it does not.
   */
  public static boolean handlesEntry(DN entryDN, Collection<DN> baseDNs, Collection<DN> excludeDNs)
  {
    for (DN baseDN : baseDNs)
    {
      if (entryDN.isSubordinateOrEqualTo(baseDN) && !isExcluded(excludeDNs, entryDN))
      {
        return true;
      }
    }
    return false;
  }

  private static boolean isExcluded(Collection<DN> excludeDNs, DN entryDN)
  {
    if (excludeDNs == null || excludeDNs.isEmpty())
    {
      return false;
    }
    for (DN excludeDN : excludeDNs)
    {
      if (entryDN.isSubordinateOrEqualTo(excludeDN))
      {
        return true;
      }
    }
    return false;
  }
}
