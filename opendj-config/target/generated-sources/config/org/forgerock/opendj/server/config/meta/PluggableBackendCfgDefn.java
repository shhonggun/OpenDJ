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



import org.forgerock.opendj.config.AbstractManagedObjectDefinition;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefaultManagedObject;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.client.BackendIndexCfgClient;
import org.forgerock.opendj.server.config.client.BackendVLVIndexCfgClient;
import org.forgerock.opendj.server.config.client.PluggableBackendCfgClient;
import org.forgerock.opendj.server.config.meta.BackendIndexCfgDefn;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendIndexCfg;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;
import org.forgerock.opendj.server.config.server.PluggableBackendCfg;



/**
 * An interface for querying the Pluggable Backend managed object
 * definition meta information.
 * <p>
 * A Pluggable Backend stores application data in a pluggable
 * database.
 */
public final class PluggableBackendCfgDefn extends AbstractManagedObjectDefinition<PluggableBackendCfgClient, PluggableBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final PluggableBackendCfgDefn INSTANCE = new PluggableBackendCfgDefn();



  /** The "cipher-key-length" property definition. */
  private static final IntegerPropertyDefinition PD_CIPHER_KEY_LENGTH;



  /** The "cipher-transformation" property definition. */
  private static final StringPropertyDefinition PD_CIPHER_TRANSFORMATION;



  /** The "compact-encoding" property definition. */
  private static final BooleanPropertyDefinition PD_COMPACT_ENCODING;



  /** The "confidentiality-enabled" property definition. */
  private static final BooleanPropertyDefinition PD_CONFIDENTIALITY_ENABLED;



  /** The "entries-compressed" property definition. */
  private static final BooleanPropertyDefinition PD_ENTRIES_COMPRESSED;



  /** The "import-offheap-memory-size" property definition. */
  private static final SizePropertyDefinition PD_IMPORT_OFFHEAP_MEMORY_SIZE;



  /** The "index-entry-limit" property definition. */
  private static final IntegerPropertyDefinition PD_INDEX_ENTRY_LIMIT;



  /** The "index-filter-analyzer-enabled" property definition. */
  private static final BooleanPropertyDefinition PD_INDEX_FILTER_ANALYZER_ENABLED;



  /** The "index-filter-analyzer-max-filters" property definition. */
  private static final IntegerPropertyDefinition PD_INDEX_FILTER_ANALYZER_MAX_FILTERS;



  /** The "preload-time-limit" property definition. */
  private static final DurationPropertyDefinition PD_PRELOAD_TIME_LIMIT;



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** The "backend-indexes" relation definition. */
  private static final InstantiableRelationDefinition<BackendIndexCfgClient, BackendIndexCfg> RD_BACKEND_INDEXES;



  /** The "backend-vlv-indexes" relation definition. */
  private static final InstantiableRelationDefinition<BackendVLVIndexCfgClient, BackendVLVIndexCfg> RD_BACKEND_VLV_INDEXES;



  /** Build the "cipher-key-length" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "cipher-key-length");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "cipher-key-length"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("128");
      builder.setDefaultBehaviorProvider(provider);
      PD_CIPHER_KEY_LENGTH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CIPHER_KEY_LENGTH);
  }



  /** Build the "cipher-transformation" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "cipher-transformation");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "cipher-transformation"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("AES/CBC/PKCS5Padding");
      builder.setDefaultBehaviorProvider(provider);
      PD_CIPHER_TRANSFORMATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CIPHER_TRANSFORMATION);
  }



  /** Build the "compact-encoding" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "compact-encoding");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "compact-encoding"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_COMPACT_ENCODING = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_COMPACT_ENCODING);
  }



  /** Build the "confidentiality-enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "confidentiality-enabled");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "confidentiality-enabled"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_CONFIDENTIALITY_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFIDENTIALITY_ENABLED);
  }



  /** Build the "entries-compressed" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "entries-compressed");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "entries-compressed"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ENTRIES_COMPRESSED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENTRIES_COMPRESSED);
  }



  /** Build the "import-offheap-memory-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "import-offheap-memory-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "import-offheap-memory-size"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Long>(INSTANCE, "import-offheap-memory-size"));
      builder.setLowerLimit("0 MB");
      PD_IMPORT_OFFHEAP_MEMORY_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IMPORT_OFFHEAP_MEMORY_SIZE);
  }



  /** Build the "index-entry-limit" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "index-entry-limit");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "index-entry-limit"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("4000");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_INDEX_ENTRY_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_ENTRY_LIMIT);
  }



  /** Build the "index-filter-analyzer-enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "index-filter-analyzer-enabled");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "index-filter-analyzer-enabled"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_INDEX_FILTER_ANALYZER_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_FILTER_ANALYZER_ENABLED);
  }



  /** Build the "index-filter-analyzer-max-filters" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "index-filter-analyzer-max-filters");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "index-filter-analyzer-max-filters"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("25");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(1);
      PD_INDEX_FILTER_ANALYZER_MAX_FILTERS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INDEX_FILTER_ANALYZER_MAX_FILTERS);
  }



  /** Build the "preload-time-limit" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "preload-time-limit");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "preload-time-limit"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("0s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_PRELOAD_TIME_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PRELOAD_TIME_LIMIT);
  }



  /** Build the "writability-mode" property definition. */
  static {
      EnumPropertyDefinition.Builder<WritabilityMode> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "writability-mode");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "writability-mode"));
      DefaultBehaviorProvider<WritabilityMode> provider = new DefinedDefaultBehaviorProvider<WritabilityMode>("enabled");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(WritabilityMode.class);
      PD_WRITABILITY_MODE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_WRITABILITY_MODE);
  }



  // Build the "backend-indexes" relation definition.
  static {
    InstantiableRelationDefinition.Builder<BackendIndexCfgClient, BackendIndexCfg> builder =
      new InstantiableRelationDefinition.Builder<BackendIndexCfgClient, BackendIndexCfg>(INSTANCE, "backend-index", "backend-indexes", BackendIndexCfgDefn.getInstance());
    builder.setNamingProperty(BackendIndexCfgDefn.getInstance().getAttributePropertyDefinition());
    {
      DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg> dmoBuilder = new DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg>(BackendIndexCfgDefn.getInstance());
      dmoBuilder.setPropertyValues("index-type", "presence");
      dmoBuilder.setPropertyValues("attribute", "aci");
      builder.setDefaultManagedObject("aci", dmoBuilder.getInstance());
    }
    {
      DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg> dmoBuilder = new DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg>(BackendIndexCfgDefn.getInstance());
      dmoBuilder.setPropertyValues("index-type", "equality");
      dmoBuilder.setPropertyValues("attribute", "entryUUID");
      builder.setDefaultManagedObject("entryUUID", dmoBuilder.getInstance());
    }
    {
      DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg> dmoBuilder = new DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg>(BackendIndexCfgDefn.getInstance());
      dmoBuilder.setPropertyValues("index-type", "equality");
      dmoBuilder.setPropertyValues("attribute", "objectClass");
      builder.setDefaultManagedObject("objectClass", dmoBuilder.getInstance());
    }
    {
      DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg> dmoBuilder = new DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg>(BackendIndexCfgDefn.getInstance());
      dmoBuilder.setPropertyValues("index-type", "ordering");
      dmoBuilder.setPropertyValues("attribute", "ds-sync-hist");
      builder.setDefaultManagedObject("ds-sync-hist", dmoBuilder.getInstance());
    }
    {
      DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg> dmoBuilder = new DefaultManagedObject.Builder<BackendIndexCfgClient, BackendIndexCfg>(BackendIndexCfgDefn.getInstance());
      dmoBuilder.setPropertyValues("index-type", "equality");
      dmoBuilder.setPropertyValues("attribute", "ds-sync-conflict");
      builder.setDefaultManagedObject("ds-sync-conflict", dmoBuilder.getInstance());
    }
    RD_BACKEND_INDEXES = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_BACKEND_INDEXES);
  }



  // Build the "backend-vlv-indexes" relation definition.
  static {
    InstantiableRelationDefinition.Builder<BackendVLVIndexCfgClient, BackendVLVIndexCfg> builder =
      new InstantiableRelationDefinition.Builder<BackendVLVIndexCfgClient, BackendVLVIndexCfg>(INSTANCE, "backend-vlv-index", "backend-vlv-indexes", BackendVLVIndexCfgDefn.getInstance());
    builder.setNamingProperty(BackendVLVIndexCfgDefn.getInstance().getNamePropertyDefinition());
    RD_BACKEND_VLV_INDEXES = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_BACKEND_VLV_INDEXES);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Pluggable Backend configuration definition singleton.
   *
   * @return Returns the Pluggable Backend configuration definition
   *         singleton.
   */
  public static PluggableBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PluggableBackendCfgDefn() {
    super("pluggable-backend", LocalBackendCfgDefn.getInstance());
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
    return LocalBackendCfgDefn.getInstance().getBackendIdPropertyDefinition();
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
    return LocalBackendCfgDefn.getInstance().getBaseDNPropertyDefinition();
  }



  /**
   * Get the "cipher-key-length" property definition.
   * <p>
   * Specifies the key length in bits for the preferred cipher.
   *
   * @return Returns the "cipher-key-length" property definition.
   */
  public IntegerPropertyDefinition getCipherKeyLengthPropertyDefinition() {
    return PD_CIPHER_KEY_LENGTH;
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
    return PD_CIPHER_TRANSFORMATION;
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
    return PD_COMPACT_ENCODING;
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
    return PD_CONFIDENTIALITY_ENABLED;
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
    return LocalBackendCfgDefn.getInstance().getEnabledPropertyDefinition();
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
    return PD_ENTRIES_COMPRESSED;
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
    return PD_IMPORT_OFFHEAP_MEMORY_SIZE;
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
    return PD_INDEX_ENTRY_LIMIT;
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
    return PD_INDEX_FILTER_ANALYZER_ENABLED;
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
    return PD_INDEX_FILTER_ANALYZER_MAX_FILTERS;
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
    return LocalBackendCfgDefn.getInstance().getJavaClassPropertyDefinition();
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
    return PD_PRELOAD_TIME_LIMIT;
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
    return PD_WRITABILITY_MODE;
  }



  /**
   * Get the "backend-indexes" relation definition.
   *
   * @return Returns the "backend-indexes" relation definition.
   */
  public InstantiableRelationDefinition<BackendIndexCfgClient,BackendIndexCfg> getBackendIndexesRelationDefinition() {
    return RD_BACKEND_INDEXES;
  }



  /**
   * Get the "backend-vlv-indexes" relation definition.
   *
   * @return Returns the "backend-vlv-indexes" relation definition.
   */
  public InstantiableRelationDefinition<BackendVLVIndexCfgClient,BackendVLVIndexCfg> getBackendVLVIndexesRelationDefinition() {
    return RD_BACKEND_VLV_INDEXES;
  }
}
