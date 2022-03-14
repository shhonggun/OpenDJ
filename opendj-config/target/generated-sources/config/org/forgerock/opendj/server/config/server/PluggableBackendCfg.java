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



import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;



/**
 * A server-side interface for querying Pluggable Backend settings.
 * <p>
 * A Pluggable Backend stores application data in a pluggable
 * database.
 */
public interface PluggableBackendCfg extends LocalBackendCfg {

  /**
   * Gets the configuration class associated with this Pluggable Backend.
   *
   * @return Returns the configuration class associated with this Pluggable Backend.
   */
  Class<? extends PluggableBackendCfg> configurationClass();



  /**
   * Register to be notified when this Pluggable Backend is changed.
   *
   * @param listener
   *          The Pluggable Backend configuration change listener.
   */
  void addPluggableChangeListener(ConfigurationChangeListener<PluggableBackendCfg> listener);



  /**
   * Deregister an existing Pluggable Backend configuration change listener.
   *
   * @param listener
   *          The Pluggable Backend configuration change listener.
   */
  void removePluggableChangeListener(ConfigurationChangeListener<PluggableBackendCfg> listener);



  /**
   * Gets the "cipher-key-length" property.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the value of the "cipher-key-length" property.
   */
  int getCipherKeyLength();



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
   * Gets the "import-offheap-memory-size" property.
   * <p>
   * Specifies the amount of off-heap memory dedicated to the online
   * operation (import-ldif, rebuild-index).
   *
   * @return Returns the value of the "import-offheap-memory-size" property.
   */
  Long getImportOffheapMemorySize();



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
   * Gets the "writability-mode" property.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the value of the "writability-mode" property.
   */
  WritabilityMode getWritabilityMode();



  /**
   * Lists the Backend Indexes.
   *
   * @return Returns an array containing the names of the
   *         Backend Indexes.
   */
  String[] listBackendIndexes();



  /**
   * Gets the named Backend Index.
   *
   * @param name
   *          The name of the Backend Index to retrieve.
   * @return Returns the named Backend Index.
   * @throws ConfigException
   *           If the Backend Index could not be found or it
   *           could not be successfully decoded.
   */
  BackendIndexCfg getBackendIndex(String name) throws ConfigException;



  /**
   * Registers to be notified when new Backend Indexes are added.
   *
   * @param listener
   *          The Backend Index configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addBackendIndexAddListener(ConfigurationAddListener<BackendIndexCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend Index configuration add listener.
   *
   * @param listener
   *          The Backend Index configuration add listener.
   */
  void removeBackendIndexAddListener(ConfigurationAddListener<BackendIndexCfg> listener);



  /**
   * Registers to be notified when existing Backend Indexes are deleted.
   *
   * @param listener
   *          The Backend Index configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addBackendIndexDeleteListener(ConfigurationDeleteListener<BackendIndexCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend Index configuration delete listener.
   *
   * @param listener
   *          The Backend Index configuration delete listener.
   */
  void removeBackendIndexDeleteListener(ConfigurationDeleteListener<BackendIndexCfg> listener);



  /**
   * Lists the Backend VLV Indexes.
   *
   * @return Returns an array containing the names of the
   *         Backend VLV Indexes.
   */
  String[] listBackendVLVIndexes();



  /**
   * Gets the named Backend VLV Index.
   *
   * @param name
   *          The name of the Backend VLV Index to retrieve.
   * @return Returns the named Backend VLV Index.
   * @throws ConfigException
   *           If the Backend VLV Index could not be found or it
   *           could not be successfully decoded.
   */
  BackendVLVIndexCfg getBackendVLVIndex(String name) throws ConfigException;



  /**
   * Registers to be notified when new Backend VLV Indexes are added.
   *
   * @param listener
   *          The Backend VLV Index configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addBackendVLVIndexAddListener(ConfigurationAddListener<BackendVLVIndexCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend VLV Index configuration add listener.
   *
   * @param listener
   *          The Backend VLV Index configuration add listener.
   */
  void removeBackendVLVIndexAddListener(ConfigurationAddListener<BackendVLVIndexCfg> listener);



  /**
   * Registers to be notified when existing Backend VLV Indexes are deleted.
   *
   * @param listener
   *          The Backend VLV Index configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addBackendVLVIndexDeleteListener(ConfigurationDeleteListener<BackendVLVIndexCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend VLV Index configuration delete listener.
   *
   * @param listener
   *          The Backend VLV Index configuration delete listener.
   */
  void removeBackendVLVIndexDeleteListener(ConfigurationDeleteListener<BackendVLVIndexCfg> listener);

}
