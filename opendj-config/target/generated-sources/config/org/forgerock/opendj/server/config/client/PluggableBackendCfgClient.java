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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendIndexCfg;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;
import org.forgerock.opendj.server.config.server.PluggableBackendCfg;



/**
 * A client-side interface for reading and modifying Pluggable Backend
 * settings.
 * <p>
 * A Pluggable Backend stores application data in a pluggable
 * database.
 */
public interface PluggableBackendCfgClient extends LocalBackendCfgClient {

  /**
   * Get the configuration definition associated with this Pluggable Backend.
   *
   * @return Returns the configuration definition associated with this Pluggable Backend.
   */
  ManagedObjectDefinition<? extends PluggableBackendCfgClient, ? extends PluggableBackendCfg> definition();



  /**
   * Gets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the value of the "cipher-key-length" property.
   */
  int getCipherKeyLength();



  /**
   * Sets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @param value The value of the "cipher-key-length" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherKeyLength(Integer value) throws PropertyException;



  /**
   * Gets the "cipher-transformation" property.
   * <p>
   * Specifies the cipher for the directory server. The syntax is
   * "algorithm/mode/padding".
   * <p>
   * The full transformation is required: specifying only an algorithm
   * and allowing the cipher provider to supply the default mode and
   * padding is not supported, because there is no guarantee these
   * default values are the same among different implementations. Some
   * cipher algorithms, including RC4 and ARCFOUR, do not have a mode
   * or padding, and hence must be specified using NONE for the mode
   * field and NoPadding for the padding field. For example,
   * RC4/NONE/NoPadding.
   *
   * @return Returns the value of the "cipher-transformation" property.
   */
  String getCipherTransformation();



  /**
   * Sets the "cipher-transformation" property.
   * <p>
   * Specifies the cipher for the directory server. The syntax is
   * "algorithm/mode/padding".
   * <p>
   * The full transformation is required: specifying only an algorithm
   * and allowing the cipher provider to supply the default mode and
   * padding is not supported, because there is no guarantee these
   * default values are the same among different implementations. Some
   * cipher algorithms, including RC4 and ARCFOUR, do not have a mode
   * or padding, and hence must be specified using NONE for the mode
   * field and NoPadding for the padding field. For example,
   * RC4/NONE/NoPadding.
   *
   * @param value The value of the "cipher-transformation" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCipherTransformation(String value) throws PropertyException;



  /**
   * Gets the "compact-encoding" property.
   * <p>
   * Indicates whether the backend should use a compact form when
   * encoding entries by compressing the attribute descriptions and
   * object class sets.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data.
   *
   * @return Returns the value of the "compact-encoding" property.
   */
  boolean isCompactEncoding();



  /**
   * Sets the "compact-encoding" property.
   * <p>
   * Indicates whether the backend should use a compact form when
   * encoding entries by compressing the attribute descriptions and
   * object class sets.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data.
   *
   * @param value The value of the "compact-encoding" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setCompactEncoding(Boolean value) throws PropertyException;



  /**
   * Gets the "confidentiality-enabled" property.
   * <p>
   * Indicates whether the backend should make entries in database
   * files readable only by Directory Server.
   * <p>
   * Confidentiality is achieved by enrypting entries before writing
   * them to the underlying storage. Entry encryption will protect data
   * on disk from unauthorised parties reading the files; for complete
   * protection, also set confidentiality for sensitive attributes
   * indexes. The property cannot be set to false if some of the
   * indexes have confidentiality set to true.
   *
   * @return Returns the value of the "confidentiality-enabled" property.
   */
  boolean isConfidentialityEnabled();



  /**
   * Sets the "confidentiality-enabled" property.
   * <p>
   * Indicates whether the backend should make entries in database
   * files readable only by Directory Server.
   * <p>
   * Confidentiality is achieved by enrypting entries before writing
   * them to the underlying storage. Entry encryption will protect data
   * on disk from unauthorised parties reading the files; for complete
   * protection, also set confidentiality for sensitive attributes
   * indexes. The property cannot be set to false if some of the
   * indexes have confidentiality set to true.
   *
   * @param value The value of the "confidentiality-enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConfidentialityEnabled(Boolean value) throws PropertyException;



  /**
   * Gets the "entries-compressed" property.
   * <p>
   * Indicates whether the backend should attempt to compress entries
   * before storing them in the database.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data. Further, the effectiveness of
   * the compression is based on the type of data contained in the
   * entry.
   *
   * @return Returns the value of the "entries-compressed" property.
   */
  boolean isEntriesCompressed();



  /**
   * Sets the "entries-compressed" property.
   * <p>
   * Indicates whether the backend should attempt to compress entries
   * before storing them in the database.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data. Further, the effectiveness of
   * the compression is based on the type of data contained in the
   * entry.
   *
   * @param value The value of the "entries-compressed" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setEntriesCompressed(Boolean value) throws PropertyException;



  /**
   * Gets the "import-offheap-memory-size" property.
   * <p>
   * Specifies the amount of off-heap memory dedicated to the online
   * operation (import-ldif, rebuild-index).
   *
   * @return Returns the value of the "import-offheap-memory-size" property.
   */
  Long getImportOffheapMemorySize();



  /**
   * Sets the "import-offheap-memory-size" property.
   * <p>
   * Specifies the amount of off-heap memory dedicated to the online
   * operation (import-ldif, rebuild-index).
   *
   * @param value The value of the "import-offheap-memory-size" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setImportOffheapMemorySize(Long value) throws PropertyException;



  /**
   * Gets the "index-entry-limit" property.
   * <p>
   * Specifies the maximum number of entries that is allowed to match
   * a given index key before that particular index key is no longer
   * maintained.
   * <p>
   * This property is analogous to the ALL IDs threshold in the Sun
   * Java System Directory Server. Note that this is the default limit
   * for the backend, and it may be overridden on a per-attribute
   * basis.A value of 0 means there is no limit.
   *
   * @return Returns the value of the "index-entry-limit" property.
   */
  int getIndexEntryLimit();



  /**
   * Sets the "index-entry-limit" property.
   * <p>
   * Specifies the maximum number of entries that is allowed to match
   * a given index key before that particular index key is no longer
   * maintained.
   * <p>
   * This property is analogous to the ALL IDs threshold in the Sun
   * Java System Directory Server. Note that this is the default limit
   * for the backend, and it may be overridden on a per-attribute
   * basis.A value of 0 means there is no limit.
   *
   * @param value The value of the "index-entry-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIndexEntryLimit(Integer value) throws PropertyException;



  /**
   * Gets the "index-filter-analyzer-enabled" property.
   * <p>
   * Indicates whether to gather statistical information about the
   * search filters processed by the directory server while evaluating
   * the usage of indexes.
   * <p>
   * Analyzing indexes requires gathering search filter usage patterns
   * from user requests, especially for values as specified in the
   * filters and subsequently looking the status of those values into
   * the index files. When a search requests is processed, internal or
   * user generated, a first phase uses indexes to find potential
   * entries to be returned. Depending on the search filter, if the
   * index of one of the specified attributes matches too many entries
   * (exceeds the index entry limit), the search becomes non-indexed.
   * In any case, all entries thus gathered (or the entire DIT) are
   * matched against the filter for actually returning the search
   * result.
   *
   * @return Returns the value of the "index-filter-analyzer-enabled" property.
   */
  boolean isIndexFilterAnalyzerEnabled();



  /**
   * Sets the "index-filter-analyzer-enabled" property.
   * <p>
   * Indicates whether to gather statistical information about the
   * search filters processed by the directory server while evaluating
   * the usage of indexes.
   * <p>
   * Analyzing indexes requires gathering search filter usage patterns
   * from user requests, especially for values as specified in the
   * filters and subsequently looking the status of those values into
   * the index files. When a search requests is processed, internal or
   * user generated, a first phase uses indexes to find potential
   * entries to be returned. Depending on the search filter, if the
   * index of one of the specified attributes matches too many entries
   * (exceeds the index entry limit), the search becomes non-indexed.
   * In any case, all entries thus gathered (or the entire DIT) are
   * matched against the filter for actually returning the search
   * result.
   *
   * @param value The value of the "index-filter-analyzer-enabled" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIndexFilterAnalyzerEnabled(Boolean value) throws PropertyException;



  /**
   * Gets the "index-filter-analyzer-max-filters" property.
   * <p>
   * The maximum number of search filter statistics to keep.
   * <p>
   * When the maximum number of search filter is reached, the least
   * used one will be deleted.
   *
   * @return Returns the value of the "index-filter-analyzer-max-filters" property.
   */
  int getIndexFilterAnalyzerMaxFilters();



  /**
   * Sets the "index-filter-analyzer-max-filters" property.
   * <p>
   * The maximum number of search filter statistics to keep.
   * <p>
   * When the maximum number of search filter is reached, the least
   * used one will be deleted.
   *
   * @param value The value of the "index-filter-analyzer-max-filters" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setIndexFilterAnalyzerMaxFilters(Integer value) throws PropertyException;



  /**
   * Gets the "preload-time-limit" property.
   * <p>
   * Specifies the length of time that the backend is allowed to spend
   * "pre-loading" data when it is initialized.
   * <p>
   * The pre-load process is used to pre-populate the database cache,
   * so that it can be more quickly available when the server is
   * processing requests. A duration of zero means there is no
   * pre-load.
   *
   * @return Returns the value of the "preload-time-limit" property.
   */
  long getPreloadTimeLimit();



  /**
   * Sets the "preload-time-limit" property.
   * <p>
   * Specifies the length of time that the backend is allowed to spend
   * "pre-loading" data when it is initialized.
   * <p>
   * The pre-load process is used to pre-populate the database cache,
   * so that it can be more quickly available when the server is
   * processing requests. A duration of zero means there is no
   * pre-load.
   *
   * @param value The value of the "preload-time-limit" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPreloadTimeLimit(Long value) throws PropertyException;



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



  /**
   * Lists the Backend Indexes.
   *
   * @return Returns an array containing the names of the Backend
   *         Indexes.
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listBackendIndexes() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Backend Index.
   *
   * @param name
   *           The name of the Backend Index to retrieve.
   * @return Returns the named Backend Index.
   * @throws DefinitionDecodingException
   *           If the named Backend Index was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Backend Index was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Backend Index was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  BackendIndexCfgClient getBackendIndex(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Backend Index. The new Backend Index will initially
   * not contain any property values (including mandatory properties).
   * Once the Backend Index has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Backend Index being created.
   * @param d
   *          The definition of the Backend Index to be created.
   * @param name
   *          The name of the new Backend Index.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Backend Index. This
   *          argument can be <code>null<code>.
   * @return Returns a new Backend Index configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Backend Index is invalid.
   */
  <C extends BackendIndexCfgClient> C createBackendIndex(
      ManagedObjectDefinition<C, ? extends BackendIndexCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Backend Index.
   *
   * @param name
   *          The name of the Backend Index to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Backend Index does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Backend Index due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeBackendIndex(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Backend VLV Indexes.
   *
   * @return Returns an array containing the names of the Backend VLV
   *         Indexes.
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listBackendVLVIndexes() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Backend VLV Index.
   *
   * @param name
   *           The name of the Backend VLV Index to retrieve.
   * @return Returns the named Backend VLV Index.
   * @throws DefinitionDecodingException
   *           If the named Backend VLV Index was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Backend VLV Index was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Backend VLV Index was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  BackendVLVIndexCfgClient getBackendVLVIndex(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Backend VLV Index. The new Backend VLV Index will
   * initially not contain any property values (including mandatory
   * properties). Once the Backend VLV Index has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Backend VLV Index being created.
   * @param d
   *          The definition of the Backend VLV Index to be created.
   * @param name
   *          The name of the new Backend VLV Index.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Backend VLV Index.
   *          This argument can be <code>null<code>.
   * @return Returns a new Backend VLV Index configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Backend VLV Index is invalid.
   */
  <C extends BackendVLVIndexCfgClient> C createBackendVLVIndex(
      ManagedObjectDefinition<C, ? extends BackendVLVIndexCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Backend VLV Index.
   *
   * @param name
   *          The name of the Backend VLV Index to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Backend VLV Index does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Backend VLV Index
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Pluggable Backend has been removed from the
   *           server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeBackendVLVIndex(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;

}
