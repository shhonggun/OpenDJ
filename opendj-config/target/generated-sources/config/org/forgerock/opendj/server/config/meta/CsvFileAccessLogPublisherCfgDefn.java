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
import java.util.TreeSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
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
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.GenericConstraint;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.AccessLogFilteringCriteriaCfgClient;
import org.forgerock.opendj.server.config.client.CsvFileAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.client.LogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.meta.AccessLogPublisherCfgDefn.FilteringPolicy;
import org.forgerock.opendj.server.config.server.AccessLogFilteringCriteriaCfg;
import org.forgerock.opendj.server.config.server.AccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.CsvFileAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the Csv File Access Log Publisher managed
 * object definition meta information.
 * <p>
 * Csv File Access Log Publishers publish access messages to CSV
 * files.
 */
public final class CsvFileAccessLogPublisherCfgDefn extends ManagedObjectDefinition<CsvFileAccessLogPublisherCfgClient, CsvFileAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final CsvFileAccessLogPublisherCfgDefn INSTANCE = new CsvFileAccessLogPublisherCfgDefn();



  /** The "asynchronous" property definition. */
  private static final BooleanPropertyDefinition PD_ASYNCHRONOUS;



  /** The "auto-flush" property definition. */
  private static final BooleanPropertyDefinition PD_AUTO_FLUSH;



  /** The "csv-delimiter-char" property definition. */
  private static final StringPropertyDefinition PD_CSV_DELIMITER_CHAR;



  /** The "csv-eol-symbols" property definition. */
  private static final StringPropertyDefinition PD_CSV_EOL_SYMBOLS;



  /** The "csv-quote-char" property definition. */
  private static final StringPropertyDefinition PD_CSV_QUOTE_CHAR;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "key-store-file" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_FILE;



  /** The "key-store-pin-file" property definition. */
  private static final StringPropertyDefinition PD_KEY_STORE_PIN_FILE;



  /** The "log-control-oids" property definition. */
  private static final BooleanPropertyDefinition PD_LOG_CONTROL_OIDS;



  /** The "log-directory" property definition. */
  private static final StringPropertyDefinition PD_LOG_DIRECTORY;



  /** The "retention-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> PD_RETENTION_POLICY;



  /** The "rotation-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRotationPolicyCfgClient, LogRotationPolicyCfg> PD_ROTATION_POLICY;



  /** The "signature-time-interval" property definition. */
  private static final DurationPropertyDefinition PD_SIGNATURE_TIME_INTERVAL;



  /** The "tamper-evident" property definition. */
  private static final BooleanPropertyDefinition PD_TAMPER_EVIDENT;



  /** Build the "asynchronous" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "asynchronous");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "asynchronous"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_ASYNCHRONOUS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ASYNCHRONOUS);
  }



  /** Build the "auto-flush" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "auto-flush");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "auto-flush"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_AUTO_FLUSH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_AUTO_FLUSH);
  }



  /** Build the "csv-delimiter-char" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "csv-delimiter-char");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "csv-delimiter-char"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>(",");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "DELIMITER CHARACTER");
      PD_CSV_DELIMITER_CHAR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CSV_DELIMITER_CHAR);
  }



  /** Build the "csv-eol-symbols" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "csv-eol-symbols");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "csv-eol-symbols"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "csv-eol-symbols"));
      builder.setPattern(".*", "STRING");
      PD_CSV_EOL_SYMBOLS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CSV_EOL_SYMBOLS);
  }



  /** Build the "csv-quote-char" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "csv-quote-char");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "csv-quote-char"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("\"");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "QUOTE CHARACTER");
      PD_CSV_QUOTE_CHAR = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CSV_QUOTE_CHAR);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.CsvFileAccessLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "key-store-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FILE");
      PD_KEY_STORE_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_FILE);
  }



  /** Build the "key-store-pin-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "key-store-pin-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "key-store-pin-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FILE");
      PD_KEY_STORE_PIN_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_KEY_STORE_PIN_FILE);
  }



  /** Build the "log-control-oids" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "log-control-oids");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-control-oids"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_LOG_CONTROL_OIDS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_CONTROL_OIDS);
  }



  /** Build the "log-directory" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-directory");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "log-directory"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("logs");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "DIRECTORY");
      PD_LOG_DIRECTORY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_DIRECTORY);
  }



  /** Build the "retention-policy" property definition. */
  static {
      AggregationPropertyDefinition.Builder<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "retention-policy");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "retention-policy"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "retention-policy"));
      builder.setParentPath("/");
      builder.setRelationDefinition("log-retention-policy");
      PD_RETENTION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RETENTION_POLICY);
      INSTANCE.registerConstraint(PD_RETENTION_POLICY.getSourceConstraint());
  }



  /** Build the "rotation-policy" property definition. */
  static {
      AggregationPropertyDefinition.Builder<LogRotationPolicyCfgClient, LogRotationPolicyCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "rotation-policy");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "rotation-policy"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "rotation-policy"));
      builder.setParentPath("/");
      builder.setRelationDefinition("log-rotation-policy");
      PD_ROTATION_POLICY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ROTATION_POLICY);
      INSTANCE.registerConstraint(PD_ROTATION_POLICY.getSourceConstraint());
  }



  /** Build the "signature-time-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "signature-time-interval");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "signature-time-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("3s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("1");
      PD_SIGNATURE_TIME_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SIGNATURE_TIME_INTERVAL);
  }



  /** Build the "tamper-evident" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "tamper-evident");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "tamper-evident"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_TAMPER_EVIDENT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TAMPER_EVIDENT);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.and(Conditions.contains("enabled", "true"), Conditions.contains("tamper-evident", "true")), Conditions.and(Conditions.isPresent("key-store-file"), Conditions.isPresent("key-store-pin-file")))));
  }



  /**
   * Get the Csv File Access Log Publisher configuration definition
   * singleton.
   *
   * @return Returns the Csv File Access Log Publisher configuration
   *         definition singleton.
   */
  public static CsvFileAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private CsvFileAccessLogPublisherCfgDefn() {
    super("csv-file-access-log-publisher", AccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public CsvFileAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends CsvFileAccessLogPublisherCfgClient> impl) {
    return new CsvFileAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public CsvFileAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends CsvFileAccessLogPublisherCfg> impl) {
    return new CsvFileAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<CsvFileAccessLogPublisherCfg> getServerConfigurationClass() {
    return CsvFileAccessLogPublisherCfg.class;
  }



  /**
   * Get the "asynchronous" property definition.
   * <p>
   * Indicates whether the Csv File Access Log Publisher will publish
   * records asynchronously.
   *
   * @return Returns the "asynchronous" property definition.
   */
  public BooleanPropertyDefinition getAsynchronousPropertyDefinition() {
    return PD_ASYNCHRONOUS;
  }



  /**
   * Get the "auto-flush" property definition.
   * <p>
   * Specifies whether to flush the writer after every log record.
   * <p>
   * If the asynchronous writes option is used, the writer is flushed
   * after all the log records in the queue are written.
   *
   * @return Returns the "auto-flush" property definition.
   */
  public BooleanPropertyDefinition getAutoFlushPropertyDefinition() {
    return PD_AUTO_FLUSH;
  }



  /**
   * Get the "csv-delimiter-char" property definition.
   * <p>
   * The delimiter character to use when writing in CSV format.
   *
   * @return Returns the "csv-delimiter-char" property definition.
   */
  public StringPropertyDefinition getCsvDelimiterCharPropertyDefinition() {
    return PD_CSV_DELIMITER_CHAR;
  }



  /**
   * Get the "csv-eol-symbols" property definition.
   * <p>
   * The string that marks the end of a line.
   *
   * @return Returns the "csv-eol-symbols" property definition.
   */
  public StringPropertyDefinition getCsvEolSymbolsPropertyDefinition() {
    return PD_CSV_EOL_SYMBOLS;
  }



  /**
   * Get the "csv-quote-char" property definition.
   * <p>
   * The character to append and prepend to a CSV field when writing
   * in CSV format.
   *
   * @return Returns the "csv-quote-char" property definition.
   */
  public StringPropertyDefinition getCsvQuoteCharPropertyDefinition() {
    return PD_CSV_QUOTE_CHAR;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Csv File Access Log Publisher is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "filtering-policy" property definition.
   * <p>
   * Specifies how filtering criteria should be applied to log
   * records.
   *
   * @return Returns the "filtering-policy" property definition.
   */
  public EnumPropertyDefinition<FilteringPolicy> getFilteringPolicyPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getFilteringPolicyPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the Csv
   * File Access Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "key-store-file" property definition.
   * <p>
   * Specifies the path to the file that contains the private key
   * information. This may be an absolute path, or a path that is
   * relative to the OpenDJ instance root.
   * <p>
   * Changes to this property will take effect the next time that the
   * key store is accessed.
   *
   * @return Returns the "key-store-file" property definition.
   */
  public StringPropertyDefinition getKeyStoreFilePropertyDefinition() {
    return PD_KEY_STORE_FILE;
  }



  /**
   * Get the "key-store-pin-file" property definition.
   * <p>
   * Specifies the path to the text file whose only contents should be
   * a single line containing the clear-text PIN needed to access the
   * Csv File Access Log Publisher .
   *
   * @return Returns the "key-store-pin-file" property definition.
   */
  public StringPropertyDefinition getKeyStorePinFilePropertyDefinition() {
    return PD_KEY_STORE_PIN_FILE;
  }



  /**
   * Get the "log-control-oids" property definition.
   * <p>
   * Specifies whether control OIDs will be included in operation log
   * records.
   *
   * @return Returns the "log-control-oids" property definition.
   */
  public BooleanPropertyDefinition getLogControlOidsPropertyDefinition() {
    return PD_LOG_CONTROL_OIDS;
  }



  /**
   * Get the "log-directory" property definition.
   * <p>
   * The directory to use for the log files generated by the Csv File
   * Access Log Publisher. The path to the directory is relative to the
   * server root.
   *
   * @return Returns the "log-directory" property definition.
   */
  public StringPropertyDefinition getLogDirectoryPropertyDefinition() {
    return PD_LOG_DIRECTORY;
  }



  /**
   * Get the "retention-policy" property definition.
   * <p>
   * The retention policy to use for the Csv File Access Log Publisher
   * .
   * <p>
   * When multiple policies are used, log files are cleaned when any
   * of the policy's conditions are met.
   *
   * @return Returns the "retention-policy" property definition.
   */
  public AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> getRetentionPolicyPropertyDefinition() {
    return PD_RETENTION_POLICY;
  }



  /**
   * Get the "rotation-policy" property definition.
   * <p>
   * The rotation policy to use for the Csv File Access Log Publisher
   * .
   * <p>
   * When multiple policies are used, rotation will occur if any
   * policy's conditions are met.
   *
   * @return Returns the "rotation-policy" property definition.
   */
  public AggregationPropertyDefinition<LogRotationPolicyCfgClient, LogRotationPolicyCfg> getRotationPolicyPropertyDefinition() {
    return PD_ROTATION_POLICY;
  }



  /**
   * Get the "signature-time-interval" property definition.
   * <p>
   * Specifies the interval at which to sign the log file when the
   * tamper-evident option is enabled.
   *
   * @return Returns the "signature-time-interval" property definition.
   */
  public DurationPropertyDefinition getSignatureTimeIntervalPropertyDefinition() {
    return PD_SIGNATURE_TIME_INTERVAL;
  }



  /**
   * Get the "suppress-internal-operations" property definition.
   * <p>
   * Indicates whether internal operations (for example, operations
   * that are initiated by plugins) should be logged along with the
   * operations that are requested by users.
   *
   * @return Returns the "suppress-internal-operations" property definition.
   */
  public BooleanPropertyDefinition getSuppressInternalOperationsPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getSuppressInternalOperationsPropertyDefinition();
  }



  /**
   * Get the "suppress-synchronization-operations" property definition.
   * <p>
   * Indicates whether access messages that are generated by
   * synchronization operations should be suppressed.
   *
   * @return Returns the "suppress-synchronization-operations" property definition.
   */
  public BooleanPropertyDefinition getSuppressSynchronizationOperationsPropertyDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getSuppressSynchronizationOperationsPropertyDefinition();
  }



  /**
   * Get the "tamper-evident" property definition.
   * <p>
   * Specifies whether the log should be signed in order to detect
   * tampering.
   * <p>
   * Every log record will be signed, making it possible to verify
   * that the log has not been tampered with. This feature has a
   * significative impact on performance of the server.
   *
   * @return Returns the "tamper-evident" property definition.
   */
  public BooleanPropertyDefinition getTamperEvidentPropertyDefinition() {
    return PD_TAMPER_EVIDENT;
  }



  /**
   * Get the "access-log-filtering-criteria" relation definition.
   *
   * @return Returns the "access-log-filtering-criteria" relation definition.
   */
  public InstantiableRelationDefinition<AccessLogFilteringCriteriaCfgClient,AccessLogFilteringCriteriaCfg> getAccessLogFilteringCriteriaRelationDefinition() {
    return AccessLogPublisherCfgDefn.getInstance().getAccessLogFilteringCriteriaRelationDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class CsvFileAccessLogPublisherCfgClientImpl implements
    CsvFileAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends CsvFileAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private CsvFileAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends CsvFileAccessLogPublisherCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAsynchronous() {
      return impl.getPropertyValue(INSTANCE.getAsynchronousPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAsynchronous(boolean value) {
      impl.setPropertyValue(INSTANCE.getAsynchronousPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isAutoFlush() {
      return impl.getPropertyValue(INSTANCE.getAutoFlushPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAutoFlush(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAutoFlushPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getCsvDelimiterChar() {
      return impl.getPropertyValue(INSTANCE.getCsvDelimiterCharPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCsvDelimiterChar(String value) {
      impl.setPropertyValue(INSTANCE.getCsvDelimiterCharPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getCsvEolSymbols() {
      return impl.getPropertyValue(INSTANCE.getCsvEolSymbolsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCsvEolSymbols(String value) {
      impl.setPropertyValue(INSTANCE.getCsvEolSymbolsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getCsvQuoteChar() {
      return impl.getPropertyValue(INSTANCE.getCsvQuoteCharPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCsvQuoteChar(String value) {
      impl.setPropertyValue(INSTANCE.getCsvQuoteCharPropertyDefinition(), value);
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
    public FilteringPolicy getFilteringPolicy() {
      return impl.getPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFilteringPolicy(FilteringPolicy value) {
      impl.setPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition(), value);
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
    public String getKeyStoreFile() {
      return impl.getPropertyValue(INSTANCE.getKeyStoreFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStoreFile(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStoreFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getKeyStorePinFile() {
      return impl.getPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setKeyStorePinFile(String value) {
      impl.setPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isLogControlOids() {
      return impl.getPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogControlOids(Boolean value) {
      impl.setPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLogDirectory() {
      return impl.getPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogDirectory(String value) {
      impl.setPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRetentionPolicy() {
      return impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRetentionPolicy(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRotationPolicy() {
      return impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRotationPolicy(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public long getSignatureTimeInterval() {
      return impl.getPropertyValue(INSTANCE.getSignatureTimeIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSignatureTimeInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getSignatureTimeIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSuppressInternalOperations() {
      return impl.getPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSuppressInternalOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSuppressSynchronizationOperations() {
      return impl.getPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSuppressSynchronizationOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isTamperEvident() {
      return impl.getPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTamperEvident(Boolean value) {
      impl.setPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String[] listAccessLogFilteringCriteria() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition());
    }



    /** {@inheritDoc} */
    public AccessLogFilteringCriteriaCfgClient getAccessLogFilteringCriteria(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends AccessLogFilteringCriteriaCfgClient> M createAccessLogFilteringCriteria(
        ManagedObjectDefinition<M, ? extends AccessLogFilteringCriteriaCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteria(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends CsvFileAccessLogPublisherCfgClient, ? extends CsvFileAccessLogPublisherCfg> definition() {
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
  private static class CsvFileAccessLogPublisherCfgServerImpl implements
    CsvFileAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends CsvFileAccessLogPublisherCfg> impl;

    /** The value of the "asynchronous" property. */
    private final boolean pAsynchronous;

    /** The value of the "auto-flush" property. */
    private final boolean pAutoFlush;

    /** The value of the "csv-delimiter-char" property. */
    private final String pCsvDelimiterChar;

    /** The value of the "csv-eol-symbols" property. */
    private final String pCsvEolSymbols;

    /** The value of the "csv-quote-char" property. */
    private final String pCsvQuoteChar;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "filtering-policy" property. */
    private final FilteringPolicy pFilteringPolicy;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-store-file" property. */
    private final String pKeyStoreFile;

    /** The value of the "key-store-pin-file" property. */
    private final String pKeyStorePinFile;

    /** The value of the "log-control-oids" property. */
    private final boolean pLogControlOids;

    /** The value of the "log-directory" property. */
    private final String pLogDirectory;

    /** The value of the "retention-policy" property. */
    private final SortedSet<String> pRetentionPolicy;

    /** The value of the "rotation-policy" property. */
    private final SortedSet<String> pRotationPolicy;

    /** The value of the "signature-time-interval" property. */
    private final long pSignatureTimeInterval;

    /** The value of the "suppress-internal-operations" property. */
    private final boolean pSuppressInternalOperations;

    /** The value of the "suppress-synchronization-operations" property. */
    private final boolean pSuppressSynchronizationOperations;

    /** The value of the "tamper-evident" property. */
    private final boolean pTamperEvident;



    /** Private constructor. */
    private CsvFileAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends CsvFileAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pAsynchronous = impl.getPropertyValue(INSTANCE.getAsynchronousPropertyDefinition());
      this.pAutoFlush = impl.getPropertyValue(INSTANCE.getAutoFlushPropertyDefinition());
      this.pCsvDelimiterChar = impl.getPropertyValue(INSTANCE.getCsvDelimiterCharPropertyDefinition());
      this.pCsvEolSymbols = impl.getPropertyValue(INSTANCE.getCsvEolSymbolsPropertyDefinition());
      this.pCsvQuoteChar = impl.getPropertyValue(INSTANCE.getCsvQuoteCharPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pFilteringPolicy = impl.getPropertyValue(INSTANCE.getFilteringPolicyPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyStoreFile = impl.getPropertyValue(INSTANCE.getKeyStoreFilePropertyDefinition());
      this.pKeyStorePinFile = impl.getPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition());
      this.pLogControlOids = impl.getPropertyValue(INSTANCE.getLogControlOidsPropertyDefinition());
      this.pLogDirectory = impl.getPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition());
      this.pRetentionPolicy = impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
      this.pRotationPolicy = impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
      this.pSignatureTimeInterval = impl.getPropertyValue(INSTANCE.getSignatureTimeIntervalPropertyDefinition());
      this.pSuppressInternalOperations = impl.getPropertyValue(INSTANCE.getSuppressInternalOperationsPropertyDefinition());
      this.pSuppressSynchronizationOperations = impl.getPropertyValue(INSTANCE.getSuppressSynchronizationOperationsPropertyDefinition());
      this.pTamperEvident = impl.getPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addCsvFileAccessChangeListener(
        ConfigurationChangeListener<CsvFileAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeCsvFileAccessChangeListener(
        ConfigurationChangeListener<CsvFileAccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addAccessChangeListener(
        ConfigurationChangeListener<AccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeAccessChangeListener(
        ConfigurationChangeListener<AccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<LogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<LogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isAsynchronous() {
      return pAsynchronous;
    }



    /** {@inheritDoc} */
    public boolean isAutoFlush() {
      return pAutoFlush;
    }



    /** {@inheritDoc} */
    public String getCsvDelimiterChar() {
      return pCsvDelimiterChar;
    }



    /** {@inheritDoc} */
    public String getCsvEolSymbols() {
      return pCsvEolSymbols;
    }



    /** {@inheritDoc} */
    public String getCsvQuoteChar() {
      return pCsvQuoteChar;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public FilteringPolicy getFilteringPolicy() {
      return pFilteringPolicy;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getKeyStoreFile() {
      return pKeyStoreFile;
    }



    /** {@inheritDoc} */
    public String getKeyStorePinFile() {
      return pKeyStorePinFile;
    }



    /** {@inheritDoc} */
    public boolean isLogControlOids() {
      return pLogControlOids;
    }



    /** {@inheritDoc} */
    public String getLogDirectory() {
      return pLogDirectory;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRetentionPolicy() {
      return pRetentionPolicy;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getRetentionPolicyDNs() {
      SortedSet<String> values = getRetentionPolicy();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getRetentionPolicyPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRotationPolicy() {
      return pRotationPolicy;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getRotationPolicyDNs() {
      SortedSet<String> values = getRotationPolicy();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getRotationPolicyPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public long getSignatureTimeInterval() {
      return pSignatureTimeInterval;
    }



    /** {@inheritDoc} */
    public boolean isSuppressInternalOperations() {
      return pSuppressInternalOperations;
    }



    /** {@inheritDoc} */
    public boolean isSuppressSynchronizationOperations() {
      return pSuppressSynchronizationOperations;
    }



    /** {@inheritDoc} */
    public boolean isTamperEvident() {
      return pTamperEvident;
    }



    /** {@inheritDoc} */
    public String[] listAccessLogFilteringCriteria() {
      return impl.listChildren(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition());
    }



    /** {@inheritDoc} */
    public AccessLogFilteringCriteriaCfg getAccessLogFilteringCriteria(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addAccessLogFilteringCriteriaAddListener(
        ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteriaAddListener(
        ConfigurationAddListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addAccessLogFilteringCriteriaDeleteListener(
        ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeAccessLogFilteringCriteriaDeleteListener(
        ConfigurationDeleteListener<AccessLogFilteringCriteriaCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getAccessLogFilteringCriteriaRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends CsvFileAccessLogPublisherCfg> configurationClass() {
      return CsvFileAccessLogPublisherCfg.class;
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
