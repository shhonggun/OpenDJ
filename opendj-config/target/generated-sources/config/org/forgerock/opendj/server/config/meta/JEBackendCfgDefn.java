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
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.GenericConstraint;
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
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.BackendIndexCfgClient;
import org.forgerock.opendj.server.config.client.BackendVLVIndexCfgClient;
import org.forgerock.opendj.server.config.client.JEBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.BackendIndexCfg;
import org.forgerock.opendj.server.config.server.BackendVLVIndexCfg;
import org.forgerock.opendj.server.config.server.JEBackendCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;
import org.forgerock.opendj.server.config.server.PluggableBackendCfg;



/**
 * An interface for querying the JE Backend managed object definition
 * meta information.
 * <p>
 * A JE Backend stores application data in a Berkeley DB Java Edition
 * database.
 */
public final class JEBackendCfgDefn extends ManagedObjectDefinition<JEBackendCfgClient, JEBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final JEBackendCfgDefn INSTANCE = new JEBackendCfgDefn();



  /** The "db-cache-percent" property definition. */
  private static final IntegerPropertyDefinition PD_DB_CACHE_PERCENT;



  /** The "db-cache-size" property definition. */
  private static final SizePropertyDefinition PD_DB_CACHE_SIZE;



  /** The "db-checkpointer-bytes-interval" property definition. */
  private static final SizePropertyDefinition PD_DB_CHECKPOINTER_BYTES_INTERVAL;



  /** The "db-checkpointer-wakeup-interval" property definition. */
  private static final DurationPropertyDefinition PD_DB_CHECKPOINTER_WAKEUP_INTERVAL;



  /** The "db-cleaner-min-utilization" property definition. */
  private static final IntegerPropertyDefinition PD_DB_CLEANER_MIN_UTILIZATION;



  /** The "db-directory" property definition. */
  private static final StringPropertyDefinition PD_DB_DIRECTORY;



  /** The "db-directory-permissions" property definition. */
  private static final StringPropertyDefinition PD_DB_DIRECTORY_PERMISSIONS;



  /** The "db-evictor-core-threads" property definition. */
  private static final IntegerPropertyDefinition PD_DB_EVICTOR_CORE_THREADS;



  /** The "db-evictor-keep-alive" property definition. */
  private static final DurationPropertyDefinition PD_DB_EVICTOR_KEEP_ALIVE;



  /** The "db-evictor-lru-only" property definition. */
  private static final BooleanPropertyDefinition PD_DB_EVICTOR_LRU_ONLY;



  /** The "db-evictor-max-threads" property definition. */
  private static final IntegerPropertyDefinition PD_DB_EVICTOR_MAX_THREADS;



  /** The "db-evictor-nodes-per-scan" property definition. */
  private static final IntegerPropertyDefinition PD_DB_EVICTOR_NODES_PER_SCAN;



  /** The "db-log-filecache-size" property definition. */
  private static final IntegerPropertyDefinition PD_DB_LOG_FILECACHE_SIZE;



  /** The "db-log-file-max" property definition. */
  private static final SizePropertyDefinition PD_DB_LOG_FILE_MAX;



  /** The "db-logging-file-handler-on" property definition. */
  private static final BooleanPropertyDefinition PD_DB_LOGGING_FILE_HANDLER_ON;



  /** The "db-logging-level" property definition. */
  private static final StringPropertyDefinition PD_DB_LOGGING_LEVEL;



  /** The "db-num-cleaner-threads" property definition. */
  private static final IntegerPropertyDefinition PD_DB_NUM_CLEANER_THREADS;



  /** The "db-num-lock-tables" property definition. */
  private static final IntegerPropertyDefinition PD_DB_NUM_LOCK_TABLES;



  /** The "db-run-cleaner" property definition. */
  private static final BooleanPropertyDefinition PD_DB_RUN_CLEANER;



  /** The "db-txn-no-sync" property definition. */
  private static final BooleanPropertyDefinition PD_DB_TXN_NO_SYNC;



  /** The "db-txn-write-no-sync" property definition. */
  private static final BooleanPropertyDefinition PD_DB_TXN_WRITE_NO_SYNC;



  /** The "disk-full-threshold" property definition. */
  private static final SizePropertyDefinition PD_DISK_FULL_THRESHOLD;



  /** The "disk-low-threshold" property definition. */
  private static final SizePropertyDefinition PD_DISK_LOW_THRESHOLD;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "je-property" property definition. */
  private static final StringPropertyDefinition PD_JE_PROPERTY;



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



  /** Build the "db-checkpointer-bytes-interval" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "db-checkpointer-bytes-interval");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "db-checkpointer-bytes-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("500mb");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("9223372036854775807b");
      builder.setLowerLimit("0b");
      PD_DB_CHECKPOINTER_BYTES_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CHECKPOINTER_BYTES_INTERVAL);
  }



  /** Build the "db-checkpointer-wakeup-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "db-checkpointer-wakeup-interval");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-checkpointer-wakeup-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("30s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("4294");
      builder.setLowerLimit("1");
      PD_DB_CHECKPOINTER_WAKEUP_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CHECKPOINTER_WAKEUP_INTERVAL);
  }



  /** Build the "db-cleaner-min-utilization" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-cleaner-min-utilization");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-cleaner-min-utilization"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("50");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(90);
      builder.setLowerLimit(0);
      PD_DB_CLEANER_MIN_UTILIZATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_CLEANER_MIN_UTILIZATION);
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



  /** Build the "db-evictor-core-threads" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-evictor-core-threads");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-evictor-core-threads"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("1");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_DB_EVICTOR_CORE_THREADS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_EVICTOR_CORE_THREADS);
  }



  /** Build the "db-evictor-keep-alive" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "db-evictor-keep-alive");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-evictor-keep-alive"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("600s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("s");
      builder.setUpperLimit("86400");
      builder.setLowerLimit("1");
      PD_DB_EVICTOR_KEEP_ALIVE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_EVICTOR_KEEP_ALIVE);
  }



  /** Build the "db-evictor-lru-only" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-evictor-lru-only");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-evictor-lru-only"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_EVICTOR_LRU_ONLY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_EVICTOR_LRU_ONLY);
  }



  /** Build the "db-evictor-max-threads" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-evictor-max-threads");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-evictor-max-threads"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("10");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(1);
      PD_DB_EVICTOR_MAX_THREADS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_EVICTOR_MAX_THREADS);
  }



  /** Build the "db-evictor-nodes-per-scan" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-evictor-nodes-per-scan");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-evictor-nodes-per-scan"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("10");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(1000);
      builder.setLowerLimit(1);
      PD_DB_EVICTOR_NODES_PER_SCAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_EVICTOR_NODES_PER_SCAN);
  }



  /** Build the "db-log-filecache-size" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-log-filecache-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-log-filecache-size"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("100");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(3);
      PD_DB_LOG_FILECACHE_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_LOG_FILECACHE_SIZE);
  }



  /** Build the "db-log-file-max" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "db-log-file-max");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-log-file-max"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("100mb");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit("4gib");
      builder.setLowerLimit("1mb");
      PD_DB_LOG_FILE_MAX = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_LOG_FILE_MAX);
  }



  /** Build the "db-logging-file-handler-on" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-logging-file-handler-on");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-logging-file-handler-on"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_LOGGING_FILE_HANDLER_ON = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_LOGGING_FILE_HANDLER_ON);
  }



  /** Build the "db-logging-level" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "db-logging-level");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-logging-level"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("CONFIG");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_LOGGING_LEVEL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_LOGGING_LEVEL);
  }



  /** Build the "db-num-cleaner-threads" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-num-cleaner-threads");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-num-cleaner-threads"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "db-num-cleaner-threads"));
      builder.setLowerLimit(1);
      PD_DB_NUM_CLEANER_THREADS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_NUM_CLEANER_THREADS);
  }



  /** Build the "db-num-lock-tables" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "db-num-lock-tables");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "db-num-lock-tables"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "db-num-lock-tables"));
      builder.setUpperLimit(32767);
      builder.setLowerLimit(1);
      PD_DB_NUM_LOCK_TABLES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_NUM_LOCK_TABLES);
  }



  /** Build the "db-run-cleaner" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-run-cleaner");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-run-cleaner"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_RUN_CLEANER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_RUN_CLEANER);
  }



  /** Build the "db-txn-no-sync" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-txn-no-sync");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-txn-no-sync"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_TXN_NO_SYNC = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_TXN_NO_SYNC);
  }



  /** Build the "db-txn-write-no-sync" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "db-txn-write-no-sync");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "db-txn-write-no-sync"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_DB_TXN_WRITE_NO_SYNC = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DB_TXN_WRITE_NO_SYNC);
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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.jeb.JEBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "je-property" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "je-property");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "je-property"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_JE_PROPERTY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JE_PROPERTY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.contains("enabled", "true"), Conditions.not(Conditions.and(Conditions.contains("db-txn-no-sync", "true"), Conditions.contains("db-txn-write-no-sync", "true"))))));
  }



  /**
   * Get the JE Backend configuration definition singleton.
   *
   * @return Returns the JE Backend configuration definition
   *         singleton.
   */
  public static JEBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private JEBackendCfgDefn() {
    super("je-backend", PluggableBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public JEBackendCfgClient createClientConfiguration(
      ManagedObject<? extends JEBackendCfgClient> impl) {
    return new JEBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public JEBackendCfg createServerConfiguration(
      ServerManagedObject<? extends JEBackendCfg> impl) {
    return new JEBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<JEBackendCfg> getServerConfigurationClass() {
    return JEBackendCfg.class;
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
   * Get the "db-checkpointer-bytes-interval" property definition.
   * <p>
   * Specifies the maximum number of bytes that may be written to the
   * database before it is forced to perform a checkpoint.
   * <p>
   * This can be used to bound the recovery time that may be required
   * if the database environment is opened without having been properly
   * closed. If this property is set to a non-zero value, the
   * checkpointer wakeup interval is not used. To use time-based
   * checkpointing, set this property to zero.
   *
   * @return Returns the "db-checkpointer-bytes-interval" property definition.
   */
  public SizePropertyDefinition getDBCheckpointerBytesIntervalPropertyDefinition() {
    return PD_DB_CHECKPOINTER_BYTES_INTERVAL;
  }



  /**
   * Get the "db-checkpointer-wakeup-interval" property definition.
   * <p>
   * Specifies the maximum length of time that may pass between
   * checkpoints.
   * <p>
   * Note that this is only used if the value of the checkpointer
   * bytes interval is zero.
   *
   * @return Returns the "db-checkpointer-wakeup-interval" property definition.
   */
  public DurationPropertyDefinition getDBCheckpointerWakeupIntervalPropertyDefinition() {
    return PD_DB_CHECKPOINTER_WAKEUP_INTERVAL;
  }



  /**
   * Get the "db-cleaner-min-utilization" property definition.
   * <p>
   * Specifies the occupancy percentage for "live" data in this
   * backend's database.
   * <p>
   * When the amount of "live" data in the database drops below this
   * value, cleaners will act to increase the occupancy percentage by
   * compacting the database.
   *
   * @return Returns the "db-cleaner-min-utilization" property definition.
   */
  public IntegerPropertyDefinition getDBCleanerMinUtilizationPropertyDefinition() {
    return PD_DB_CLEANER_MIN_UTILIZATION;
  }



  /**
   * Get the "db-directory" property definition.
   * <p>
   * Specifies the path to the filesystem directory that is used to
   * hold the Berkeley DB Java Edition database files containing the
   * data for this backend.
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
   * Get the "db-evictor-core-threads" property definition.
   * <p>
   * Specifies the core number of threads in the eviction thread pool.
   * <p>
   * Specifies the core number of threads in the eviction thread pool.
   * These threads help keep memory usage within cache bounds,
   * offloading work from application threads. db-evictor-core-threads,
   * db-evictor-max-threads and db-evictor-keep-alive are used to
   * configure the core, max and keepalive attributes for the eviction
   * thread pool.
   *
   * @return Returns the "db-evictor-core-threads" property definition.
   */
  public IntegerPropertyDefinition getDBEvictorCoreThreadsPropertyDefinition() {
    return PD_DB_EVICTOR_CORE_THREADS;
  }



  /**
   * Get the "db-evictor-keep-alive" property definition.
   * <p>
   * The duration that excess threads in the eviction thread pool will
   * stay idle. After this period, idle threads will terminate.
   * <p>
   * The duration that excess threads in the eviction thread pool will
   * stay idle. After this period, idle threads will terminate.
   * db-evictor-core-threads, db-evictor-max-threads and
   * db-evictor-keep-alive are used to configure the core, max and
   * keepalive attributes for the eviction thread pool.
   *
   * @return Returns the "db-evictor-keep-alive" property definition.
   */
  public DurationPropertyDefinition getDBEvictorKeepAlivePropertyDefinition() {
    return PD_DB_EVICTOR_KEEP_ALIVE;
  }



  /**
   * Get the "db-evictor-lru-only" property definition.
   * <p>
   * Indicates whether the database should evict existing data from
   * the cache based on an LRU policy (where the least recently used
   * information will be evicted first).
   * <p>
   * If set to "false", then the eviction keeps internal nodes of the
   * underlying Btree in the cache over leaf nodes, even if the leaf
   * nodes have been accessed more recently. This may be a better
   * configuration for databases in which only a very small portion of
   * the data is cached.
   *
   * @return Returns the "db-evictor-lru-only" property definition.
   */
  public BooleanPropertyDefinition getDBEvictorLruOnlyPropertyDefinition() {
    return PD_DB_EVICTOR_LRU_ONLY;
  }



  /**
   * Get the "db-evictor-max-threads" property definition.
   * <p>
   * Specifies the maximum number of threads in the eviction thread
   * pool.
   * <p>
   * Specifies the maximum number of threads in the eviction thread
   * pool. These threads help keep memory usage within cache bounds,
   * offloading work from application threads. db-evictor-core-threads,
   * db-evictor-max-threads and db-evictor-keep-alive are used to
   * configure the core, max and keepalive attributes for the eviction
   * thread pool.
   *
   * @return Returns the "db-evictor-max-threads" property definition.
   */
  public IntegerPropertyDefinition getDBEvictorMaxThreadsPropertyDefinition() {
    return PD_DB_EVICTOR_MAX_THREADS;
  }



  /**
   * Get the "db-evictor-nodes-per-scan" property definition.
   * <p>
   * Specifies the number of Btree nodes that should be evicted from
   * the cache in a single pass if it is determined that it is
   * necessary to free existing data in order to make room for new
   * information.
   * <p>
   * Changes to this property do not take effect until the backend is
   * restarted. It is recommended that you also change this property
   * when you set db-evictor-lru-only to false. This setting controls
   * the number of Btree nodes that are considered, or sampled, each
   * time a node is evicted. A setting of 10 often produces good
   * results, but this may vary from application to application. The
   * larger the nodes per scan, the more accurate the algorithm.
   * However, don't set it too high. When considering larger numbers of
   * nodes for each eviction, the evictor may delay the completion of a
   * given database operation, which impacts the response time of the
   * application thread. In JE 4.1 and later, setting this value too
   * high in an application that is largely CPU bound can reduce the
   * effectiveness of cache eviction. It's best to start with the
   * default value, and increase it gradually to see if it is
   * beneficial for your application.
   *
   * @return Returns the "db-evictor-nodes-per-scan" property definition.
   */
  public IntegerPropertyDefinition getDBEvictorNodesPerScanPropertyDefinition() {
    return PD_DB_EVICTOR_NODES_PER_SCAN;
  }



  /**
   * Get the "db-log-filecache-size" property definition.
   * <p>
   * Specifies the size of the file handle cache.
   * <p>
   * The file handle cache is used to keep as much opened log files as
   * possible. When the cache is smaller than the number of logs, the
   * database needs to close some handles and open log files it needs,
   * resulting in less optimal performances. Ideally, the size of the
   * cache should be higher than the number of files contained in the
   * database. Make sure the OS number of open files per process is
   * also tuned appropriately.
   *
   * @return Returns the "db-log-filecache-size" property definition.
   */
  public IntegerPropertyDefinition getDBLogFilecacheSizePropertyDefinition() {
    return PD_DB_LOG_FILECACHE_SIZE;
  }



  /**
   * Get the "db-log-file-max" property definition.
   * <p>
   * Specifies the maximum size for a database log file.
   *
   * @return Returns the "db-log-file-max" property definition.
   */
  public SizePropertyDefinition getDBLogFileMaxPropertyDefinition() {
    return PD_DB_LOG_FILE_MAX;
  }



  /**
   * Get the "db-logging-file-handler-on" property definition.
   * <p>
   * Indicates whether the database should maintain a je.info file in
   * the same directory as the database log directory.
   * <p>
   * This file contains information about the internal processing
   * performed by the underlying database.
   *
   * @return Returns the "db-logging-file-handler-on" property definition.
   */
  public BooleanPropertyDefinition getDBLoggingFileHandlerOnPropertyDefinition() {
    return PD_DB_LOGGING_FILE_HANDLER_ON;
  }



  /**
   * Get the "db-logging-level" property definition.
   * <p>
   * Specifies the log level that should be used by the database when
   * it is writing information into the je.info file.
   * <p>
   * The database trace logging level is (in increasing order of
   * verbosity) chosen from: OFF, SEVERE, WARNING, INFO, CONFIG, FINE,
   * FINER, FINEST, ALL.
   *
   * @return Returns the "db-logging-level" property definition.
   */
  public StringPropertyDefinition getDBLoggingLevelPropertyDefinition() {
    return PD_DB_LOGGING_LEVEL;
  }



  /**
   * Get the "db-num-cleaner-threads" property definition.
   * <p>
   * Specifies the number of threads that the backend should maintain
   * to keep the database log files at or near the desired utilization.
   * <p>
   * In environments with high write throughput, multiple cleaner
   * threads may be required to maintain the desired utilization.
   *
   * @return Returns the "db-num-cleaner-threads" property definition.
   */
  public IntegerPropertyDefinition getDBNumCleanerThreadsPropertyDefinition() {
    return PD_DB_NUM_CLEANER_THREADS;
  }



  /**
   * Get the "db-num-lock-tables" property definition.
   * <p>
   * Specifies the number of lock tables that are used by the
   * underlying database.
   * <p>
   * This can be particularly important to help improve scalability by
   * avoiding contention on systems with large numbers of CPUs. The
   * value of this configuration property should be set to a prime
   * number that is less than or equal to the number of worker threads
   * configured for use in the server.
   *
   * @return Returns the "db-num-lock-tables" property definition.
   */
  public IntegerPropertyDefinition getDBNumLockTablesPropertyDefinition() {
    return PD_DB_NUM_LOCK_TABLES;
  }



  /**
   * Get the "db-run-cleaner" property definition.
   * <p>
   * Indicates whether the cleaner threads should be enabled to
   * compact the database.
   * <p>
   * The cleaner threads are used to periodically compact the database
   * when it reaches a percentage of occupancy lower than the amount
   * specified by the db-cleaner-min-utilization property. They
   * identify database files with a low percentage of live data, and
   * relocate their remaining live data to the end of the log.
   *
   * @return Returns the "db-run-cleaner" property definition.
   */
  public BooleanPropertyDefinition getDBRunCleanerPropertyDefinition() {
    return PD_DB_RUN_CLEANER;
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
   * Get the "db-txn-write-no-sync" property definition.
   * <p>
   * Indicates whether the database should synchronously flush data as
   * it is written to disk.
   * <p>
   * If this value is set to "false", then all data written to disk is
   * synchronously flushed to persistent storage and thereby providing
   * full durability. If it is set to "true", then data may be cached
   * for a period of time by the underlying operating system before
   * actually being written to disk. This may improve performance, but
   * could cause the most recent changes to be lost in the event of an
   * underlying OS or hardware failure (but not in the case that the
   * OpenDJ directory server or the JVM exits abnormally).
   *
   * @return Returns the "db-txn-write-no-sync" property definition.
   */
  public BooleanPropertyDefinition getDBTxnWriteNoSyncPropertyDefinition() {
    return PD_DB_TXN_WRITE_NO_SYNC;
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
   * Get the "je-property" property definition.
   * <p>
   * Specifies the database and environment properties for the
   * Berkeley DB Java Edition database serving the data for this
   * backend.
   * <p>
   * Any Berkeley DB Java Edition property can be specified using the
   * following form: property-name=property-value. Refer to OpenDJ
   * documentation for further information on related properties, their
   * implications, and range values. The definitive identification of
   * all the property parameters is available in the example.properties
   * file of Berkeley DB Java Edition distribution.
   *
   * @return Returns the "je-property" property definition.
   */
  public StringPropertyDefinition getJEPropertyPropertyDefinition() {
    return PD_JE_PROPERTY;
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
  private static class JEBackendCfgClientImpl implements
    JEBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends JEBackendCfgClient> impl;



    /** Private constructor. */
    private JEBackendCfgClientImpl(
        ManagedObject<? extends JEBackendCfgClient> impl) {
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
    public long getDBCheckpointerBytesInterval() {
      return impl.getPropertyValue(INSTANCE.getDBCheckpointerBytesIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBCheckpointerBytesInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getDBCheckpointerBytesIntervalPropertyDefinition(), value);
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
    public int getDBCleanerMinUtilization() {
      return impl.getPropertyValue(INSTANCE.getDBCleanerMinUtilizationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBCleanerMinUtilization(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBCleanerMinUtilizationPropertyDefinition(), value);
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
    public int getDBEvictorCoreThreads() {
      return impl.getPropertyValue(INSTANCE.getDBEvictorCoreThreadsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBEvictorCoreThreads(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBEvictorCoreThreadsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDBEvictorKeepAlive() {
      return impl.getPropertyValue(INSTANCE.getDBEvictorKeepAlivePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBEvictorKeepAlive(Long value) {
      impl.setPropertyValue(INSTANCE.getDBEvictorKeepAlivePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDBEvictorLruOnly() {
      return impl.getPropertyValue(INSTANCE.getDBEvictorLruOnlyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBEvictorLruOnly(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDBEvictorLruOnlyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getDBEvictorMaxThreads() {
      return impl.getPropertyValue(INSTANCE.getDBEvictorMaxThreadsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBEvictorMaxThreads(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBEvictorMaxThreadsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getDBEvictorNodesPerScan() {
      return impl.getPropertyValue(INSTANCE.getDBEvictorNodesPerScanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBEvictorNodesPerScan(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBEvictorNodesPerScanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getDBLogFilecacheSize() {
      return impl.getPropertyValue(INSTANCE.getDBLogFilecacheSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBLogFilecacheSize(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBLogFilecacheSizePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getDBLogFileMax() {
      return impl.getPropertyValue(INSTANCE.getDBLogFileMaxPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBLogFileMax(Long value) {
      impl.setPropertyValue(INSTANCE.getDBLogFileMaxPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDBLoggingFileHandlerOn() {
      return impl.getPropertyValue(INSTANCE.getDBLoggingFileHandlerOnPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBLoggingFileHandlerOn(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDBLoggingFileHandlerOnPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getDBLoggingLevel() {
      return impl.getPropertyValue(INSTANCE.getDBLoggingLevelPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBLoggingLevel(String value) {
      impl.setPropertyValue(INSTANCE.getDBLoggingLevelPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getDBNumCleanerThreads() {
      return impl.getPropertyValue(INSTANCE.getDBNumCleanerThreadsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBNumCleanerThreads(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBNumCleanerThreadsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getDBNumLockTables() {
      return impl.getPropertyValue(INSTANCE.getDBNumLockTablesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBNumLockTables(Integer value) {
      impl.setPropertyValue(INSTANCE.getDBNumLockTablesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDBRunCleaner() {
      return impl.getPropertyValue(INSTANCE.getDBRunCleanerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBRunCleaner(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDBRunCleanerPropertyDefinition(), value);
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
    public boolean isDBTxnWriteNoSync() {
      return impl.getPropertyValue(INSTANCE.getDBTxnWriteNoSyncPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDBTxnWriteNoSync(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDBTxnWriteNoSyncPropertyDefinition(), value);
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
    public SortedSet<String> getJEProperty() {
      return impl.getPropertyValues(INSTANCE.getJEPropertyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJEProperty(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getJEPropertyPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends JEBackendCfgClient, ? extends JEBackendCfg> definition() {
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
  private static class JEBackendCfgServerImpl implements
    JEBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends JEBackendCfg> impl;

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

    /** The value of the "db-checkpointer-bytes-interval" property. */
    private final long pDBCheckpointerBytesInterval;

    /** The value of the "db-checkpointer-wakeup-interval" property. */
    private final long pDBCheckpointerWakeupInterval;

    /** The value of the "db-cleaner-min-utilization" property. */
    private final int pDBCleanerMinUtilization;

    /** The value of the "db-directory" property. */
    private final String pDBDirectory;

    /** The value of the "db-directory-permissions" property. */
    private final String pDBDirectoryPermissions;

    /** The value of the "db-evictor-core-threads" property. */
    private final int pDBEvictorCoreThreads;

    /** The value of the "db-evictor-keep-alive" property. */
    private final long pDBEvictorKeepAlive;

    /** The value of the "db-evictor-lru-only" property. */
    private final boolean pDBEvictorLruOnly;

    /** The value of the "db-evictor-max-threads" property. */
    private final int pDBEvictorMaxThreads;

    /** The value of the "db-evictor-nodes-per-scan" property. */
    private final int pDBEvictorNodesPerScan;

    /** The value of the "db-log-filecache-size" property. */
    private final int pDBLogFilecacheSize;

    /** The value of the "db-log-file-max" property. */
    private final long pDBLogFileMax;

    /** The value of the "db-logging-file-handler-on" property. */
    private final boolean pDBLoggingFileHandlerOn;

    /** The value of the "db-logging-level" property. */
    private final String pDBLoggingLevel;

    /** The value of the "db-num-cleaner-threads" property. */
    private final Integer pDBNumCleanerThreads;

    /** The value of the "db-num-lock-tables" property. */
    private final Integer pDBNumLockTables;

    /** The value of the "db-run-cleaner" property. */
    private final boolean pDBRunCleaner;

    /** The value of the "db-txn-no-sync" property. */
    private final boolean pDBTxnNoSync;

    /** The value of the "db-txn-write-no-sync" property. */
    private final boolean pDBTxnWriteNoSync;

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

    /** The value of the "je-property" property. */
    private final SortedSet<String> pJEProperty;

    /** The value of the "preload-time-limit" property. */
    private final long pPreloadTimeLimit;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private JEBackendCfgServerImpl(ServerManagedObject<? extends JEBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pCipherKeyLength = impl.getPropertyValue(INSTANCE.getCipherKeyLengthPropertyDefinition());
      this.pCipherTransformation = impl.getPropertyValue(INSTANCE.getCipherTransformationPropertyDefinition());
      this.pCompactEncoding = impl.getPropertyValue(INSTANCE.getCompactEncodingPropertyDefinition());
      this.pConfidentialityEnabled = impl.getPropertyValue(INSTANCE.getConfidentialityEnabledPropertyDefinition());
      this.pDBCachePercent = impl.getPropertyValue(INSTANCE.getDBCachePercentPropertyDefinition());
      this.pDBCacheSize = impl.getPropertyValue(INSTANCE.getDBCacheSizePropertyDefinition());
      this.pDBCheckpointerBytesInterval = impl.getPropertyValue(INSTANCE.getDBCheckpointerBytesIntervalPropertyDefinition());
      this.pDBCheckpointerWakeupInterval = impl.getPropertyValue(INSTANCE.getDBCheckpointerWakeupIntervalPropertyDefinition());
      this.pDBCleanerMinUtilization = impl.getPropertyValue(INSTANCE.getDBCleanerMinUtilizationPropertyDefinition());
      this.pDBDirectory = impl.getPropertyValue(INSTANCE.getDBDirectoryPropertyDefinition());
      this.pDBDirectoryPermissions = impl.getPropertyValue(INSTANCE.getDBDirectoryPermissionsPropertyDefinition());
      this.pDBEvictorCoreThreads = impl.getPropertyValue(INSTANCE.getDBEvictorCoreThreadsPropertyDefinition());
      this.pDBEvictorKeepAlive = impl.getPropertyValue(INSTANCE.getDBEvictorKeepAlivePropertyDefinition());
      this.pDBEvictorLruOnly = impl.getPropertyValue(INSTANCE.getDBEvictorLruOnlyPropertyDefinition());
      this.pDBEvictorMaxThreads = impl.getPropertyValue(INSTANCE.getDBEvictorMaxThreadsPropertyDefinition());
      this.pDBEvictorNodesPerScan = impl.getPropertyValue(INSTANCE.getDBEvictorNodesPerScanPropertyDefinition());
      this.pDBLogFilecacheSize = impl.getPropertyValue(INSTANCE.getDBLogFilecacheSizePropertyDefinition());
      this.pDBLogFileMax = impl.getPropertyValue(INSTANCE.getDBLogFileMaxPropertyDefinition());
      this.pDBLoggingFileHandlerOn = impl.getPropertyValue(INSTANCE.getDBLoggingFileHandlerOnPropertyDefinition());
      this.pDBLoggingLevel = impl.getPropertyValue(INSTANCE.getDBLoggingLevelPropertyDefinition());
      this.pDBNumCleanerThreads = impl.getPropertyValue(INSTANCE.getDBNumCleanerThreadsPropertyDefinition());
      this.pDBNumLockTables = impl.getPropertyValue(INSTANCE.getDBNumLockTablesPropertyDefinition());
      this.pDBRunCleaner = impl.getPropertyValue(INSTANCE.getDBRunCleanerPropertyDefinition());
      this.pDBTxnNoSync = impl.getPropertyValue(INSTANCE.getDBTxnNoSyncPropertyDefinition());
      this.pDBTxnWriteNoSync = impl.getPropertyValue(INSTANCE.getDBTxnWriteNoSyncPropertyDefinition());
      this.pDiskFullThreshold = impl.getPropertyValue(INSTANCE.getDiskFullThresholdPropertyDefinition());
      this.pDiskLowThreshold = impl.getPropertyValue(INSTANCE.getDiskLowThresholdPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pEntriesCompressed = impl.getPropertyValue(INSTANCE.getEntriesCompressedPropertyDefinition());
      this.pImportOffheapMemorySize = impl.getPropertyValue(INSTANCE.getImportOffheapMemorySizePropertyDefinition());
      this.pIndexEntryLimit = impl.getPropertyValue(INSTANCE.getIndexEntryLimitPropertyDefinition());
      this.pIndexFilterAnalyzerEnabled = impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerEnabledPropertyDefinition());
      this.pIndexFilterAnalyzerMaxFilters = impl.getPropertyValue(INSTANCE.getIndexFilterAnalyzerMaxFiltersPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pJEProperty = impl.getPropertyValues(INSTANCE.getJEPropertyPropertyDefinition());
      this.pPreloadTimeLimit = impl.getPropertyValue(INSTANCE.getPreloadTimeLimitPropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addJEChangeListener(
        ConfigurationChangeListener<JEBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeJEChangeListener(
        ConfigurationChangeListener<JEBackendCfg> listener) {
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
    public long getDBCheckpointerBytesInterval() {
      return pDBCheckpointerBytesInterval;
    }



    /** {@inheritDoc} */
    public long getDBCheckpointerWakeupInterval() {
      return pDBCheckpointerWakeupInterval;
    }



    /** {@inheritDoc} */
    public int getDBCleanerMinUtilization() {
      return pDBCleanerMinUtilization;
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
    public int getDBEvictorCoreThreads() {
      return pDBEvictorCoreThreads;
    }



    /** {@inheritDoc} */
    public long getDBEvictorKeepAlive() {
      return pDBEvictorKeepAlive;
    }



    /** {@inheritDoc} */
    public boolean isDBEvictorLruOnly() {
      return pDBEvictorLruOnly;
    }



    /** {@inheritDoc} */
    public int getDBEvictorMaxThreads() {
      return pDBEvictorMaxThreads;
    }



    /** {@inheritDoc} */
    public int getDBEvictorNodesPerScan() {
      return pDBEvictorNodesPerScan;
    }



    /** {@inheritDoc} */
    public int getDBLogFilecacheSize() {
      return pDBLogFilecacheSize;
    }



    /** {@inheritDoc} */
    public long getDBLogFileMax() {
      return pDBLogFileMax;
    }



    /** {@inheritDoc} */
    public boolean isDBLoggingFileHandlerOn() {
      return pDBLoggingFileHandlerOn;
    }



    /** {@inheritDoc} */
    public String getDBLoggingLevel() {
      return pDBLoggingLevel;
    }



    /** {@inheritDoc} */
    public Integer getDBNumCleanerThreads() {
      return pDBNumCleanerThreads;
    }



    /** {@inheritDoc} */
    public Integer getDBNumLockTables() {
      return pDBNumLockTables;
    }



    /** {@inheritDoc} */
    public boolean isDBRunCleaner() {
      return pDBRunCleaner;
    }



    /** {@inheritDoc} */
    public boolean isDBTxnNoSync() {
      return pDBTxnNoSync;
    }



    /** {@inheritDoc} */
    public boolean isDBTxnWriteNoSync() {
      return pDBTxnWriteNoSync;
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
    public SortedSet<String> getJEProperty() {
      return pJEProperty;
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
    public Class<? extends JEBackendCfg> configurationClass() {
      return JEBackendCfg.class;
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
