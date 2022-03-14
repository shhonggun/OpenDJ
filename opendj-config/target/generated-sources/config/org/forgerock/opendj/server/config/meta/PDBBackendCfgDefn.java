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
package org.forgerock.opendj.server.config.meta;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.BackendIndexCfgClient;
import org.forgerock.opendj.server.config.client.BackendVLVIndexCfgClient;
import org.forgerock.opendj.server.config.client.PDBBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.BackendIndexCfg;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;
import org.forgerock.opendj.server.config.server.PDBBackendCfg;
import org.forgerock.opendj.server.config.server.PluggableBackendCfg;



/**
 * An interface for querying the PDB Backend managed object definition
 * meta information.
 * <p>
 * A PDB Backend stores application data in a Persistit database.
 */
public final class PDBBackendCfgDefn extends ManagedObjectDefinition<PDBBackendCfgClient, PDBBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final PDBBackendCfgDefn INSTANCE = new PDBBackendCfgDefn();



  /** The "db-cache-percent" property definition. */
  private static final IntegerPropertyDefinition PD_DB_CACHE_PERCENT;



  /** The "db-cache-size" property definition. */
  private static final SizePropertyDefinition PD_DB_CACHE_SIZE;



  /** The "db-checkpointer-wakeup-interval" property definition. */
  private static final DurationPropertyDefinition PD_DB_CHECKPOINTER_WAKEUP_INTERVAL;



  /** The "db-directory" property definition. */
  private static final StringPropertyDefinition PD_DB_DIRECTORY;



  /** The "db-directory-permissions" property definition. */
  private static final StringPropertyDefinition PD_DB_DIRECTORY_PERMISSIONS;



  /** The "db-txn-no-sync" property definition. */
  private static final BooleanPropertyDefinition PD_DB_TXN_NO_SYNC;



  /** The "disk-full-threshold" property definition. */
  private static final SizePropertyDefinition PD_DISK_FULL_THRESHOLD;



  /** The "disk-low-threshold" property definition. */
  private static final SizePropertyDefinition PD_DISK_LOW_THRESHOLD;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "db-cache-percent" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-cache-percent");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-cache-percent"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("50");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(90);
      builder.setLowerLimit(1);
      PD_DB_CACHE_PERCENT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CACHE_PERCENT);
  }



  /** Build the "db-cache-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "db-cache-size");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-cache-size"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0 MB");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit("0 MB");
      PD_DB_CACHE_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CACHE_SIZE);
  }



  /** Build the "db-checkpointer-wakeup-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "db-checkpointer-wakeup-interval");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-checkpointer-wakeup-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("15s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("3600");
      builder.setLowerLimit("10");
      PD_DB_CHECKPOINTER_WAKEUP_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CHECKPOINTER_WAKEUP_INTERVAL);
  }



  /** Build the "db-directory" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "db-directory");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-directory"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("db");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_DIRECTORY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_DIRECTORY);
  }



  /** Build the "db-directory-permissions" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "db-directory-permissions");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "db-directory-permissions"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("700");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern("^7[0-7][0-7]$", "MODE");
      PD_DB_DIRECTORY_PERMISSIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_DIRECTORY_PERMISSIONS);
  }



  /** Build the "db-txn-no-sync" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-txn-no-sync");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-txn-no-sync"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_TXN_NO_SYNC = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_TXN_NO_SYNC);
  }



  /** Build the "disk-full-threshold" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "disk-full-threshold");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disk-full-threshold"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("100 megabytes");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit("0");
      PD_DISK_FULL_THRESHOLD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISK_FULL_THRESHOLD);
  }



  /** Build the "disk-low-threshold" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "disk-low-threshold");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disk-low-threshold"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("200 megabytes");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit("0");
      PD_DISK_LOW_THRESHOLD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISK_LOW_THRESHOLD);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.pdb.PDBBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the PDB Backend configuration definition singleton.
   *
   * @return Returns the PDB Backend configuration definition
   *         singleton.
   */
  public static PDBBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PDBBackendCfgDefn() {
    super("pdb-backend", PluggableBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PDBBackendCfgClient createClientConfiguration(
      ManagedObject<? extends PDBBackendCfgClient> impl) {
    return new PDBBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PDBBackendCfg createServerConfiguration(
      ServerManagedObject<? extends PDBBackendCfg> impl) {
    return new PDBBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PDBBackendCfg> getServerConfigurationClass() {
    return PDBBackendCfg.class;
  }



  /**
   * Get the "backend-id" property definition.
   * <p>
   * Specifies a name to identify the associated backend.
   * <p>
   * The name must be unique among all backends in the server. The
   * backend ID may not be altered after the backend is created in the
   * server.
   *
   * @return Returns the "backend-id" property definition.
   */
  public StringPropertyDefinition getBackendIdPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getBackendIdPropertyDefinition();
  }



  /**
   * Get the "base-dn" property definition.
   * <p>
   * Specifies the base DN(s) for the data that the backend handles.
   * <p>
   * A single backend may be responsible for one or more base DNs.
   * Note that no two backends may have the same base DN although one
   * backend may have a base DN that is below a base DN provided by
   * another backend (similar to the use of sub-suffixes in the Sun
   * Java System Directory Server). If any of the base DNs is
   * subordinate to a base DN for another backend, then all base DNs
   * for that backend must be subordinate to that same base DN.
   *
   * @return Returns the "base-dn" property definition.
   */
  public DNPropertyDefinition getBaseDNPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getBaseDNPropertyDefinition();
  }



  /**
   * Get the "cipher-key-length" property definition.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the "cipher-key-length" property definition.
   */
  public IntegerPropertyDefinition getCipherKeyLengthPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getCipherKeyLengthPropertyDefinition();
  }



  /**
   * Get the "cipher-transformation" property definition.
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
   * @return Returns the "cipher-transformation" property definition.
   */
  public StringPropertyDefinition getCipherTransformationPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getCipherTransformationPropertyDefinition();
  }



  /**
   * Get the "compact-encoding" property definition.
   * <p>
   * Indicates whether the backend should use a compact form when
   * encoding entries by compressing the attribute descriptions and
   * object class sets.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data.
   *
   * @return Returns the "compact-encoding" property definition.
   */
  public BooleanPropertyDefinition getCompactEncodingPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getCompactEncodingPropertyDefinition();
  }



  /**
   * Get the "confidentiality-enabled" property definition.
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
   * @return Returns the "confidentiality-enabled" property definition.
   */
  public BooleanPropertyDefinition getConfidentialityEnabledPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getConfidentialityEnabledPropertyDefinition();
  }



  /**
   * Get the "db-cache-percent" property definition.
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
   * @return Returns the "db-cache-percent" property definition.
   */
  public IntegerPropertyDefinition getDBCachePercentPropertyDefinition() {
    return PD_DB_CACHE_PERCENT;
  }



  /**
   * Get the "db-cache-size" property definition.
   * <p>
   * The amount of JVM memory to allocate to the database cache.
   * <p>
   * Specifies the amount of memory that should be used for caching
   * database contents. A value of "0 MB" indicates that the
   * db-cache-percent property should be used instead to specify the
   * cache size.
   *
   * @return Returns the "db-cache-size" property definition.
   */
  public SizePropertyDefinition getDBCacheSizePropertyDefinition() {
    return PD_DB_CACHE_SIZE;
  }



  /**
   * Get the "db-checkpointer-wakeup-interval" property definition.
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
   * @return Returns the "db-checkpointer-wakeup-interval" property definition.
   */
  public DurationPropertyDefinition getDBCheckpointerWakeupIntervalPropertyDefinition() {
    return PD_DB_CHECKPOINTER_WAKEUP_INTERVAL;
  }



  /**
   * Get the "db-directory" property definition.
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
   * @return Returns the "db-directory" property definition.
   */
  public StringPropertyDefinition getDBDirectoryPropertyDefinition() {
    return PD_DB_DIRECTORY;
  }



  /**
   * Get the "db-directory-permissions" property definition.
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
   * @return Returns the "db-directory-permissions" property definition.
   */
  public StringPropertyDefinition getDBDirectoryPermissionsPropertyDefinition() {
    return PD_DB_DIRECTORY_PERMISSIONS;
  }



  /**
   * Get the "db-txn-no-sync" property definition.
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
   * @return Returns the "db-txn-no-sync" property definition.
   */
  public BooleanPropertyDefinition getDBTxnNoSyncPropertyDefinition() {
    return PD_DB_TXN_NO_SYNC;
  }



  /**
   * Get the "disk-full-threshold" property definition.
   * <p>
   * Full disk threshold to limit database updates
   * <p>
   * When the available free space on the disk used by this database
   * instance falls below the value specified, no updates are permitted
   * and the server returns an UNWILLING_TO_PERFORM error. Updates are
   * allowed again as soon as free space rises above the threshold.
   *
   * @return Returns the "disk-full-threshold" property definition.
   */
  public SizePropertyDefinition getDiskFullThresholdPropertyDefinition() {
    return PD_DISK_FULL_THRESHOLD;
  }



  /**
   * Get the "disk-low-threshold" property definition.
   * <p>
   * Low disk threshold to limit database updates
   * <p>
   * Specifies the "low" free space on the disk. When the available
   * free space on the disk used by this database instance falls below
   * the value specified, protocol updates on this database are
   * permitted only by a user with the BYPASS_LOCKDOWN privilege.
   *
   * @return Returns the "disk-low-threshold" property definition.
   */
  public SizePropertyDefinition getDiskLowThresholdPropertyDefinition() {
    return PD_DISK_LOW_THRESHOLD;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the backend is enabled in the server.
   * <p>
   * If a backend is not enabled, then its contents are not accessible
   * when processing operations.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "entries-compressed" property definition.
   * <p>
   * Indicates whether the backend should attempt to compress entries
   * before storing them in the database.
   * <p>
   * Note that this property applies only to the entries themselves
   * and does not impact the index data. Further, the effectiveness of
   * the compression is based on the type of data contained in the
   * entry.
   *
   * @return Returns the "entries-compressed" property definition.
   */
  public BooleanPropertyDefinition getEntriesCompressedPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getEntriesCompressedPropertyDefinition();
  }



  /**
   * Get the "import-offheap-memory-size" property definition.
   * <p>
   * Specifies the amount of off-heap memory dedicated to the online
   * operation (import-ldif, rebuild-index).
   *
   * @return Returns the "import-offheap-memory-size" property definition.
   */
  public SizePropertyDefinition getImportOffheapMemorySizePropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getImportOffheapMemorySizePropertyDefinition();
  }



  /**
   * Get the "index-entry-limit" property definition.
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
   * @return Returns the "index-entry-limit" property definition.
   */
  public IntegerPropertyDefinition getIndexEntryLimitPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getIndexEntryLimitPropertyDefinition();
  }



  /**
   * Get the "index-filter-analyzer-enabled" property definition.
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
   * @return Returns the "index-filter-analyzer-enabled" property definition.
   */
  public BooleanPropertyDefinition getIndexFilterAnalyzerEnabledPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getIndexFilterAnalyzerEnabledPropertyDefinition();
  }



  /**
   * Get the "index-filter-analyzer-max-filters" property definition.
   * <p>
   * The maximum number of search filter statistics to keep.
   * <p>
   * When the maximum number of search filter is reached, the least
   * used one will be deleted.
   *
   * @return Returns the "index-filter-analyzer-max-filters" property definition.
   */
  public IntegerPropertyDefinition getIndexFilterAnalyzerMaxFiltersPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getIndexFilterAnalyzerMaxFiltersPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the backend implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "preload-time-limit" property definition.
   * <p>
   * Specifies the length of time that the backend is allowed to spend
   * "pre-loading" data when it is initialized.
   * <p>
   * The pre-load process is used to pre-populate the database cache,
   * so that it can be more quickly available when the server is
   * processing requests. A duration of zero means there is no
   * pre-load.
   *
   * @return Returns the "preload-time-limit" property definition.
   */
  public DurationPropertyDefinition getPreloadTimeLimitPropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getPreloadTimeLimitPropertyDefinition();
  }



  /**
   * Get the "writability-mode" property definition.
   * <p>
   * Specifies the behavior that the backend should use when
   * processing write operations.
   *
   * @return Returns the "writability-mode" property definition.
   */
  public EnumPropertyDefinition<WritabilityMode> getWritabilityModePropertyDefinition() {
    return PluggableBackendCfgDefn.getInstance().getWritabilityModePropertyDefinition();
  }



  /**
   * Get the "backend-indexes" relation definition.
   *
   * @return Returns the "backend-indexes" relation definition.
   */
  public InstantiableRelationDefinition<BackendIndexCfgClient,BackendIndexCfg> getBackendIndexesRelationDefinition() {
    return PluggableBackendCfgDefn.getInstance().getBackendIndexesRelationDefinition();
  }



  /**
   * Get the "backend-vlv-indexes" relation definition.
   *
   * @return Returns the "backend-vlv-indexes" relation definition.
   */
  public InstantiableRelationDefinition<BackendVLVIndexCfgClient,BackendVLVIndexCfg> getBackendVLVIndexesRelationDefinition() {
    return PluggableBackendCfgDefn.getInstance().getBackendVLVIndexesRelationDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class PDBBackendCfgClientImpl implements
    PDBBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PDBBackendCfgClient> impl;



    /** Private constructor. */
    private PDBBackendCfgClientImpl(
        ManagedObject<? extends PDBBackendCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public String getBackendId() {
      return impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBackendId(String value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getBackendIdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBaseDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getBaseDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public int getCipherKeyLength() {
      return impl.getPropertyValue(INSTANCE.getCipherKeyLengthPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCipherKeyLength(Integer value) {
      impl.setPropertyValue(INSTANCE.getCipherKeyLengthPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getCipherTransformation() {
      return impl.getPropertyValue(INSTANCE.getCipherTransformationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCipherTransformation(String value) {
      impl.setPropertyValue(INSTANCE.getCipherTransformationPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isCompactEncoding() {
      return impl.getPropertyValue(INSTANCE.getCompactEncodingPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCompactEncoding(Boolean value) {
      impl.setPropertyValue(INSTANCE.getCompactEncodingPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isConfidentialityEnabled() {
      return impl.getPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConfidentialityEnabled(Boolean value) {
      impl.setPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getDBCachePercent() {
      return impl.getPropertyValue(INSTANCE.getDBCachePercentPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBCachePercent(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBCachePercentPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDBCacheSize() {
      return impl.getPropertyValue(INSTANCE.getDBCacheSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBCacheSize(Long value) {
      impl.setPropertyValue(INSTANCE.getDBCacheSizePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDBCheckpointerWakeupInterval() {
      return impl.getPropertyValue(INSTANCE.getDBCheckpointerWakeupIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBCheckpointerWakeupInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getDBCheckpointerWakeupIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getDBDirectory() {
      return impl.getPropertyValue(INSTANCE.getDBDirectoryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBDirectory(String value) {
      impl.setPropertyValue(INSTANCE.getDBDirectoryPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getDBDirectoryPermissions() {
      return impl.getPropertyValue(INSTANCE.getDBDirectoryPermissionsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBDirectoryPermissions(String value) {
      impl.setPropertyValue(INSTANCE.getDBDirectoryPermissionsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDBTxnNoSync() {
      return impl.getPropertyValue(INSTANCE.getDBTxnNoSyncPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBTxnNoSync(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDBTxnNoSyncPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDiskFullThreshold() {
      return impl.getPropertyValue(INSTANCE.getDiskFullThresholdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDiskFullThreshold(Long value) {
      impl.setPropertyValue(INSTANCE.getDiskFullThresholdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDiskLowThreshold() {
      return impl.getPropertyValue(INSTANCE.getDiskLowThresholdPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDiskLowThreshold(Long value) {
      impl.setPropertyValue(INSTANCE.getDiskLowThresholdPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Boolean isEnabled() {
      return impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isEntriesCompressed() {
      return impl.getPropertyValue(INSTANCE.getEntriesCompressedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEntriesCompressed(Boolean value) {
      impl.setPropertyValue(INSTANCE.getEntriesCompressedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Long getImportOffheapMemorySize() {
      return impl.getPropertyValue(INSTANCE.getImportOffheapMemorySizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setImportOffheapMemorySize(Long value) {
      impl.setPropertyValue(INSTANCE.getImportOffheapMemorySizePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getIndexEntryLimit() {
      return impl.getPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexEntryLimit(Integer value) {
      impl.setPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isIndexFilterAnalyzerEnabled() {
      return impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexFilterAnalyzerEnabled(Boolean value) {
      impl.setPropertyValue(INSTANCE.getIndexFilterAnalyzerEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getIndexFilterAnalyzerMaxFilters() {
      return impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerMaxFiltersPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIndexFilterAnalyzerMaxFilters(Integer value) {
      impl.setPropertyValue(INSTANCE.getIndexFilterAnalyzerMaxFiltersPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getPreloadTimeLimit() {
      return impl.getPropertyValue(INSTANCE.getPreloadTimeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPreloadTimeLimit(Long value) {
      impl.setPropertyValue(INSTANCE.getPreloadTimeLimitPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setWritabilityMode(WritabilityMode value) {
      impl.setPropertyValue(INSTANCE.getWritabilityModePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String[] listBackendIndexes() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getBackendIndexesRelationDefinition());
    }



    /** {@inheritDoc} */
    public BackendIndexCfgClient getBackendIndex(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getBackendIndexesRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends BackendIndexCfgClient> M createBackendIndex(
        ManagedObjectDefinition<M, ? extends BackendIndexCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getBackendIndexesRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeBackendIndex(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getBackendIndexesRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public String[] listBackendVLVIndexes() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getBackendVLVIndexesRelationDefinition());
    }



    /** {@inheritDoc} */
    public BackendVLVIndexCfgClient getBackendVLVIndex(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getBackendVLVIndexesRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends BackendVLVIndexCfgClient> M createBackendVLVIndex(
        ManagedObjectDefinition<M, ? extends BackendVLVIndexCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getBackendVLVIndexesRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeBackendVLVIndex(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getBackendVLVIndexesRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PDBBackendCfgClient, ? extends PDBBackendCfg> definition() {
      return INSTANCE;
    }



    /** {@inheritDoc} */
    public PropertyProvider properties() {
      return impl;
    }



    /** {@inheritDoc} */
    public void commit() throws ManagedObjectAlreadyExistsException,
        MissingMandatoryPropertiesException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.commit();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }



  /**
   * Managed object server implementation.
   */
  private static class PDBBackendCfgServerImpl implements
    PDBBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PDBBackendCfg> impl;

    /** The value of the "backend-id" property. */
    private final String pBackendId;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "cipher-key-length" property. */
    private final int pCipherKeyLength;

    /** The value of the "cipher-transformation" property. */
    private final String pCipherTransformation;

    /** The value of the "compact-encoding" property. */
    private final boolean pCompactEncoding;

    /** The value of the "confidentiality-enabled" property. */
    private final boolean pConfidentialityEnabled;

    /** The value of the "db-cache-percent" property. */
    private final int pDBCachePercent;

    /** The value of the "db-cache-size" property. */
    private final long pDBCacheSize;

    /** The value of the "db-checkpointer-wakeup-interval" property. */
    private final long pDBCheckpointerWakeupInterval;

    /** The value of the "db-directory" property. */
    private final String pDBDirectory;

    /** The value of the "db-directory-permissions" property. */
    private final String pDBDirectoryPermissions;

    /** The value of the "db-txn-no-sync" property. */
    private final boolean pDBTxnNoSync;

    /** The value of the "disk-full-threshold" property. */
    private final long pDiskFullThreshold;

    /** The value of the "disk-low-threshold" property. */
    private final long pDiskLowThreshold;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "entries-compressed" property. */
    private final boolean pEntriesCompressed;

    /** The value of the "import-offheap-memory-size" property. */
    private final Long pImportOffheapMemorySize;

    /** The value of the "index-entry-limit" property. */
    private final int pIndexEntryLimit;

    /** The value of the "index-filter-analyzer-enabled" property. */
    private final boolean pIndexFilterAnalyzerEnabled;

    /** The value of the "index-filter-analyzer-max-filters" property. */
    private final int pIndexFilterAnalyzerMaxFilters;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "preload-time-limit" property. */
    private final long pPreloadTimeLimit;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private PDBBackendCfgServerImpl(ServerManagedObject<? extends PDBBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pCipherKeyLength = impl.getPropertyValue(INSTANCE.getCipherKeyLengthPropertyDefinition());
      this.pCipherTransformation = impl.getPropertyValue(INSTANCE.getCipherTransformationPropertyDefinition());
      this.pCompactEncoding = impl.getPropertyValue(INSTANCE.getCompactEncodingPropertyDefinition());
      this.pConfidentialityEnabled = impl.getPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition());
      this.pDBCachePercent = impl.getPropertyValue(INSTANCE.getDBCachePercentPropertyDefinition());
      this.pDBCacheSize = impl.getPropertyValue(INSTANCE.getDBCacheSizePropertyDefinition());
      this.pDBCheckpointerWakeupInterval = impl.getPropertyValue(INSTANCE.getDBCheckpointerWakeupIntervalPropertyDefinition());
      this.pDBDirectory = impl.getPropertyValue(INSTANCE.getDBDirectoryPropertyDefinition());
      this.pDBDirectoryPermissions = impl.getPropertyValue(INSTANCE.getDBDirectoryPermissionsPropertyDefinition());
      this.pDBTxnNoSync = impl.getPropertyValue(INSTANCE.getDBTxnNoSyncPropertyDefinition());
      this.pDiskFullThreshold = impl.getPropertyValue(INSTANCE.getDiskFullThresholdPropertyDefinition());
      this.pDiskLowThreshold = impl.getPropertyValue(INSTANCE.getDiskLowThresholdPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pEntriesCompressed = impl.getPropertyValue(INSTANCE.getEntriesCompressedPropertyDefinition());
      this.pImportOffheapMemorySize = impl.getPropertyValue(INSTANCE.getImportOffheapMemorySizePropertyDefinition());
      this.pIndexEntryLimit = impl.getPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition());
      this.pIndexFilterAnalyzerEnabled = impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerEnabledPropertyDefinition());
      this.pIndexFilterAnalyzerMaxFilters = impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerMaxFiltersPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPreloadTimeLimit = impl.getPropertyValue(INSTANCE.getPreloadTimeLimitPropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPDBChangeListener(
        ConfigurationChangeListener<PDBBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePDBChangeListener(
        ConfigurationChangeListener<PDBBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addPluggableChangeListener(
        ConfigurationChangeListener<PluggableBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePluggableChangeListener(
        ConfigurationChangeListener<PluggableBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addLocalChangeListener(
        ConfigurationChangeListener<LocalBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeLocalChangeListener(
        ConfigurationChangeListener<LocalBackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<BackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<BackendCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getBackendId() {
      return pBackendId;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getBaseDN() {
      return pBaseDN;
    }



    /** {@inheritDoc} */
    public int getCipherKeyLength() {
      return pCipherKeyLength;
    }



    /** {@inheritDoc} */
    public String getCipherTransformation() {
      return pCipherTransformation;
    }



    /** {@inheritDoc} */
    public boolean isCompactEncoding() {
      return pCompactEncoding;
    }



    /** {@inheritDoc} */
    public boolean isConfidentialityEnabled() {
      return pConfidentialityEnabled;
    }



    /** {@inheritDoc} */
    public int getDBCachePercent() {
      return pDBCachePercent;
    }



    /** {@inheritDoc} */
    public long getDBCacheSize() {
      return pDBCacheSize;
    }



    /** {@inheritDoc} */
    public long getDBCheckpointerWakeupInterval() {
      return pDBCheckpointerWakeupInterval;
    }



    /** {@inheritDoc} */
    public String getDBDirectory() {
      return pDBDirectory;
    }



    /** {@inheritDoc} */
    public String getDBDirectoryPermissions() {
      return pDBDirectoryPermissions;
    }



    /** {@inheritDoc} */
    public boolean isDBTxnNoSync() {
      return pDBTxnNoSync;
    }



    /** {@inheritDoc} */
    public long getDiskFullThreshold() {
      return pDiskFullThreshold;
    }



    /** {@inheritDoc} */
    public long getDiskLowThreshold() {
      return pDiskLowThreshold;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isEntriesCompressed() {
      return pEntriesCompressed;
    }



    /** {@inheritDoc} */
    public Long getImportOffheapMemorySize() {
      return pImportOffheapMemorySize;
    }



    /** {@inheritDoc} */
    public int getIndexEntryLimit() {
      return pIndexEntryLimit;
    }



    /** {@inheritDoc} */
    public boolean isIndexFilterAnalyzerEnabled() {
      return pIndexFilterAnalyzerEnabled;
    }



    /** {@inheritDoc} */
    public int getIndexFilterAnalyzerMaxFilters() {
      return pIndexFilterAnalyzerMaxFilters;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public long getPreloadTimeLimit() {
      return pPreloadTimeLimit;
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public String[] listBackendIndexes() {
      return impl.listChildren(INSTANCE.getBackendIndexesRelationDefinition());
    }



    /** {@inheritDoc} */
    public BackendIndexCfg getBackendIndex(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getBackendIndexesRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addBackendIndexAddListener(
        ConfigurationAddListener<BackendIndexCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getBackendIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeBackendIndexAddListener(
        ConfigurationAddListener<BackendIndexCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getBackendIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addBackendIndexDeleteListener(
        ConfigurationDeleteListener<BackendIndexCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getBackendIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeBackendIndexDeleteListener(
        ConfigurationDeleteListener<BackendIndexCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getBackendIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public String[] listBackendVLVIndexes() {
      return impl.listChildren(INSTANCE.getBackendVLVIndexesRelationDefinition());
    }



    /** {@inheritDoc} */
    public BackendVLVIndexCfg getBackendVLVIndex(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getBackendVLVIndexesRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addBackendVLVIndexAddListener(
        ConfigurationAddListener<BackendVLVIndexCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getBackendVLVIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeBackendVLVIndexAddListener(
        ConfigurationAddListener<BackendVLVIndexCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getBackendVLVIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addBackendVLVIndexDeleteListener(
        ConfigurationDeleteListener<BackendVLVIndexCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getBackendVLVIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeBackendVLVIndexDeleteListener(
        ConfigurationDeleteListener<BackendVLVIndexCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getBackendVLVIndexesRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends PDBBackendCfg> configurationClass() {
      return PDBBackendCfg.class;
    }



    /** {@inheritDoc} */
    public DN dn() {
      return impl.getDN();
    }



    /** {@inheritDoc} */
    public String name() {
      return impl.getName();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }
}
