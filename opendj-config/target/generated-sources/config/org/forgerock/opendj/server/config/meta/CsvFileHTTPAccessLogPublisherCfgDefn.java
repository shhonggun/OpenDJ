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
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.CsvFileHTTPAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.client.LogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.CsvFileHTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.HTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the Csv File HTTP Access Log Publisher
 * managed object definition meta information.
 * <p>
 * Csv File HTTP Access Log Publishers publish HTTP access messages to
 * CSV files.
 */
public final class CsvFileHTTPAccessLogPublisherCfgDefn extends ManagedObjectDefinition<CsvFileHTTPAccessLogPublisherCfgClient, CsvFileHTTPAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final CsvFileHTTPAccessLogPublisherCfgDefn INSTANCE = new CsvFileHTTPAccessLogPublisherCfgDefn();



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
      builder.setPattern(".*", "EOL SYMBOLS");
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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.CommonAuditHTTPAccessLogPublisher");
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



  /**
   * Get the Csv File HTTP Access Log Publisher configuration
   * definition singleton.
   *
   * @return Returns the Csv File HTTP Access Log Publisher
   *         configuration definition singleton.
   */
  public static CsvFileHTTPAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private CsvFileHTTPAccessLogPublisherCfgDefn() {
    super("csv-file-http-access-log-publisher", HTTPAccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public CsvFileHTTPAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends CsvFileHTTPAccessLogPublisherCfgClient> impl) {
    return new CsvFileHTTPAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public CsvFileHTTPAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends CsvFileHTTPAccessLogPublisherCfg> impl) {
    return new CsvFileHTTPAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<CsvFileHTTPAccessLogPublisherCfg> getServerConfigurationClass() {
    return CsvFileHTTPAccessLogPublisherCfg.class;
  }



  /**
   * Get the "asynchronous" property definition.
   * <p>
   * Indicates whether the Csv File HTTP Access Log Publisher will
   * publish records asynchronously.
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
   * Indicates whether the Csv File HTTP Access Log Publisher is
   * enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPAccessLogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the Csv
   * File HTTP Access Log Publisher implementation.
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
   * Csv File HTTP Access Log Publisher .
   *
   * @return Returns the "key-store-pin-file" property definition.
   */
  public StringPropertyDefinition getKeyStorePinFilePropertyDefinition() {
    return PD_KEY_STORE_PIN_FILE;
  }



  /**
   * Get the "log-directory" property definition.
   * <p>
   * The directory to use for the log files generated by the Csv File
   * HTTP Access Log Publisher. The path to the directory is relative
   * to the server root.
   *
   * @return Returns the "log-directory" property definition.
   */
  public StringPropertyDefinition getLogDirectoryPropertyDefinition() {
    return PD_LOG_DIRECTORY;
  }



  /**
   * Get the "retention-policy" property definition.
   * <p>
   * The retention policy to use for the Csv File HTTP Access Log
   * Publisher .
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
   * The rotation policy to use for the Csv File HTTP Access Log
   * Publisher .
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
   * Specifies the interval at which to sign the log file when secure
   * option is enabled.
   *
   * @return Returns the "signature-time-interval" property definition.
   */
  public DurationPropertyDefinition getSignatureTimeIntervalPropertyDefinition() {
    return PD_SIGNATURE_TIME_INTERVAL;
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
   * Managed object client implementation.
   */
  private static class CsvFileHTTPAccessLogPublisherCfgClientImpl implements
    CsvFileHTTPAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends CsvFileHTTPAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private CsvFileHTTPAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends CsvFileHTTPAccessLogPublisherCfgClient> impl) {
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
    public boolean isTamperEvident() {
      return impl.getPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTamperEvident(Boolean value) {
      impl.setPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends CsvFileHTTPAccessLogPublisherCfgClient, ? extends CsvFileHTTPAccessLogPublisherCfg> definition() {
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
  private static class CsvFileHTTPAccessLogPublisherCfgServerImpl implements
    CsvFileHTTPAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends CsvFileHTTPAccessLogPublisherCfg> impl;

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

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "key-store-file" property. */
    private final String pKeyStoreFile;

    /** The value of the "key-store-pin-file" property. */
    private final String pKeyStorePinFile;

    /** The value of the "log-directory" property. */
    private final String pLogDirectory;

    /** The value of the "retention-policy" property. */
    private final SortedSet<String> pRetentionPolicy;

    /** The value of the "rotation-policy" property. */
    private final SortedSet<String> pRotationPolicy;

    /** The value of the "signature-time-interval" property. */
    private final long pSignatureTimeInterval;

    /** The value of the "tamper-evident" property. */
    private final boolean pTamperEvident;



    /** Private constructor. */
    private CsvFileHTTPAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends CsvFileHTTPAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pAsynchronous = impl.getPropertyValue(INSTANCE.getAsynchronousPropertyDefinition());
      this.pAutoFlush = impl.getPropertyValue(INSTANCE.getAutoFlushPropertyDefinition());
      this.pCsvDelimiterChar = impl.getPropertyValue(INSTANCE.getCsvDelimiterCharPropertyDefinition());
      this.pCsvEolSymbols = impl.getPropertyValue(INSTANCE.getCsvEolSymbolsPropertyDefinition());
      this.pCsvQuoteChar = impl.getPropertyValue(INSTANCE.getCsvQuoteCharPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pKeyStoreFile = impl.getPropertyValue(INSTANCE.getKeyStoreFilePropertyDefinition());
      this.pKeyStorePinFile = impl.getPropertyValue(INSTANCE.getKeyStorePinFilePropertyDefinition());
      this.pLogDirectory = impl.getPropertyValue(INSTANCE.getLogDirectoryPropertyDefinition());
      this.pRetentionPolicy = impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
      this.pRotationPolicy = impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
      this.pSignatureTimeInterval = impl.getPropertyValue(INSTANCE.getSignatureTimeIntervalPropertyDefinition());
      this.pTamperEvident = impl.getPropertyValue(INSTANCE.getTamperEvidentPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addCsvFileHTTPAccessChangeListener(
        ConfigurationChangeListener<CsvFileHTTPAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeCsvFileHTTPAccessChangeListener(
        ConfigurationChangeListener<CsvFileHTTPAccessLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addHTTPAccessChangeListener(
        ConfigurationChangeListener<HTTPAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPAccessChangeListener(
        ConfigurationChangeListener<HTTPAccessLogPublisherCfg> listener) {
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
    public boolean isTamperEvident() {
      return pTamperEvident;
    }



    /** {@inheritDoc} */
    public Class<? extends CsvFileHTTPAccessLogPublisherCfg> configurationClass() {
      return CsvFileHTTPAccessLogPublisherCfg.class;
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
