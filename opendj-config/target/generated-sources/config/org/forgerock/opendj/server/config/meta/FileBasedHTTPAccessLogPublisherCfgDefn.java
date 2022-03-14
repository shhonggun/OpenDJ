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
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.FileBasedHTTPAccessLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.client.LogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.FileBasedHTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.HTTPAccessLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the File Based HTTP Access Log Publisher
 * managed object definition meta information.
 * <p>
 * File Based HTTP Access Log Publishers publish HTTP access messages
 * to the file system.
 */
public final class FileBasedHTTPAccessLogPublisherCfgDefn extends ManagedObjectDefinition<FileBasedHTTPAccessLogPublisherCfgClient, FileBasedHTTPAccessLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final FileBasedHTTPAccessLogPublisherCfgDefn INSTANCE = new FileBasedHTTPAccessLogPublisherCfgDefn();



  /** The "append" property definition. */
  private static final BooleanPropertyDefinition PD_APPEND;



  /** The "asynchronous" property definition. */
  private static final BooleanPropertyDefinition PD_ASYNCHRONOUS;



  /** The "auto-flush" property definition. */
  private static final BooleanPropertyDefinition PD_AUTO_FLUSH;



  /** The "buffer-size" property definition. */
  private static final SizePropertyDefinition PD_BUFFER_SIZE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "log-file" property definition. */
  private static final StringPropertyDefinition PD_LOG_FILE;



  /** The "log-file-permissions" property definition. */
  private static final StringPropertyDefinition PD_LOG_FILE_PERMISSIONS;



  /** The "log-format" property definition. */
  private static final StringPropertyDefinition PD_LOG_FORMAT;



  /** The "log-record-time-format" property definition. */
  private static final StringPropertyDefinition PD_LOG_RECORD_TIME_FORMAT;



  /** The "queue-size" property definition. */
  private static final IntegerPropertyDefinition PD_QUEUE_SIZE;



  /** The "retention-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> PD_RETENTION_POLICY;



  /** The "rotation-policy" property definition. */
  private static final AggregationPropertyDefinition<LogRotationPolicyCfgClient, LogRotationPolicyCfg> PD_ROTATION_POLICY;



  /** The "time-interval" property definition. */
  private static final DurationPropertyDefinition PD_TIME_INTERVAL;



  /** Build the "append" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "append");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "append"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_APPEND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_APPEND);
  }



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



  /** Build the "buffer-size" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "buffer-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "buffer-size"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("64kb");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit("1");
      PD_BUFFER_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BUFFER_SIZE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.TextHTTPAccessLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "log-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "log-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FILE");
      PD_LOG_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_FILE);
  }



  /** Build the "log-file-permissions" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-file-permissions");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-file-permissions"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("640");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern("^([0-7][0-7][0-7])$", "MODE");
      PD_LOG_FILE_PERMISSIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_FILE_PERMISSIONS);
  }



  /** Build the "log-format" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-format");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-format"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("cs-host c-ip cs-username x-datetime cs-method cs-uri-stem cs-uri-query cs-version sc-status cs(User-Agent) x-connection-id x-etime x-transaction-id");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern("[a-zA-Z0-9-()]+( [a-zA-Z0-9-()]+)*", "FORMAT");
      PD_LOG_FORMAT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_FORMAT);
  }



  /** Build the "log-record-time-format" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "log-record-time-format");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "log-record-time-format"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("dd/MMM/yyyy:HH:mm:ss Z");
      builder.setDefaultBehaviorProvider(provider);
      builder.setPattern(".*", "STRING");
      PD_LOG_RECORD_TIME_FORMAT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOG_RECORD_TIME_FORMAT);
  }



  /** Build the "queue-size" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "queue-size");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "queue-size"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("5000");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(1);
      PD_QUEUE_SIZE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_QUEUE_SIZE);
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



  /** Build the "time-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "time-interval");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "time-interval"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("5s");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("1");
      PD_TIME_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TIME_INTERVAL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the File Based HTTP Access Log Publisher configuration
   * definition singleton.
   *
   * @return Returns the File Based HTTP Access Log Publisher
   *         configuration definition singleton.
   */
  public static FileBasedHTTPAccessLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FileBasedHTTPAccessLogPublisherCfgDefn() {
    super("file-based-http-access-log-publisher", HTTPAccessLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FileBasedHTTPAccessLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends FileBasedHTTPAccessLogPublisherCfgClient> impl) {
    return new FileBasedHTTPAccessLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FileBasedHTTPAccessLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends FileBasedHTTPAccessLogPublisherCfg> impl) {
    return new FileBasedHTTPAccessLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FileBasedHTTPAccessLogPublisherCfg> getServerConfigurationClass() {
    return FileBasedHTTPAccessLogPublisherCfg.class;
  }



  /**
   * Get the "append" property definition.
   * <p>
   * Specifies whether to append to existing log files.
   *
   * @return Returns the "append" property definition.
   */
  public BooleanPropertyDefinition getAppendPropertyDefinition() {
    return PD_APPEND;
  }



  /**
   * Get the "asynchronous" property definition.
   * <p>
   * Indicates whether the File Based HTTP Access Log Publisher will
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
   * Get the "buffer-size" property definition.
   * <p>
   * Specifies the log file buffer size.
   *
   * @return Returns the "buffer-size" property definition.
   */
  public SizePropertyDefinition getBufferSizePropertyDefinition() {
    return PD_BUFFER_SIZE;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the File Based HTTP Access Log Publisher is
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
   * The fully-qualified name of the Java class that provides the File
   * Based HTTP Access Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "log-file" property definition.
   * <p>
   * The file name to use for the log files generated by the File
   * Based HTTP Access Log Publisher. The path to the file is relative
   * to the server root.
   *
   * @return Returns the "log-file" property definition.
   */
  public StringPropertyDefinition getLogFilePropertyDefinition() {
    return PD_LOG_FILE;
  }



  /**
   * Get the "log-file-permissions" property definition.
   * <p>
   * The UNIX permissions of the log files created by this File Based
   * HTTP Access Log Publisher.
   *
   * @return Returns the "log-file-permissions" property definition.
   */
  public StringPropertyDefinition getLogFilePermissionsPropertyDefinition() {
    return PD_LOG_FILE_PERMISSIONS;
  }



  /**
   * Get the "log-format" property definition.
   * <p>
   * Specifies how log records should be formatted and written to the
   * HTTP access log.
   *
   * @return Returns the "log-format" property definition.
   */
  public StringPropertyDefinition getLogFormatPropertyDefinition() {
    return PD_LOG_FORMAT;
  }



  /**
   * Get the "log-record-time-format" property definition.
   * <p>
   * Specifies the format string that is used to generate log record
   * timestamps.
   *
   * @return Returns the "log-record-time-format" property definition.
   */
  public StringPropertyDefinition getLogRecordTimeFormatPropertyDefinition() {
    return PD_LOG_RECORD_TIME_FORMAT;
  }



  /**
   * Get the "queue-size" property definition.
   * <p>
   * The maximum number of log records that can be stored in the
   * asynchronous queue.
   *
   * @return Returns the "queue-size" property definition.
   */
  public IntegerPropertyDefinition getQueueSizePropertyDefinition() {
    return PD_QUEUE_SIZE;
  }



  /**
   * Get the "retention-policy" property definition.
   * <p>
   * The retention policy to use for the File Based HTTP Access Log
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
   * The rotation policy to use for the File Based HTTP Access Log
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
   * Get the "time-interval" property definition.
   * <p>
   * Specifies the interval at which to check whether the log files
   * need to be rotated.
   *
   * @return Returns the "time-interval" property definition.
   */
  public DurationPropertyDefinition getTimeIntervalPropertyDefinition() {
    return PD_TIME_INTERVAL;
  }



  /**
   * Managed object client implementation.
   */
  private static class FileBasedHTTPAccessLogPublisherCfgClientImpl implements
    FileBasedHTTPAccessLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FileBasedHTTPAccessLogPublisherCfgClient> impl;



    /** Private constructor. */
    private FileBasedHTTPAccessLogPublisherCfgClientImpl(
        ManagedObject<? extends FileBasedHTTPAccessLogPublisherCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isAppend() {
      return impl.getPropertyValue(INSTANCE.getAppendPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAppend(Boolean value) {
      impl.setPropertyValue(INSTANCE.getAppendPropertyDefinition(), value);
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
    public long getBufferSize() {
      return impl.getPropertyValue(INSTANCE.getBufferSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBufferSize(Long value) {
      impl.setPropertyValue(INSTANCE.getBufferSizePropertyDefinition(), value);
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
    public String getLogFile() {
      return impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogFile(String value) {
      impl.setPropertyValue(INSTANCE.getLogFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLogFilePermissions() {
      return impl.getPropertyValue(INSTANCE.getLogFilePermissionsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogFilePermissions(String value) {
      impl.setPropertyValue(INSTANCE.getLogFilePermissionsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLogFormat() {
      return impl.getPropertyValue(INSTANCE.getLogFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogFormat(String value) {
      impl.setPropertyValue(INSTANCE.getLogFormatPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getLogRecordTimeFormat() {
      return impl.getPropertyValue(INSTANCE.getLogRecordTimeFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLogRecordTimeFormat(String value) {
      impl.setPropertyValue(INSTANCE.getLogRecordTimeFormatPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getQueueSize() {
      return impl.getPropertyValue(INSTANCE.getQueueSizePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setQueueSize(Integer value) {
      impl.setPropertyValue(INSTANCE.getQueueSizePropertyDefinition(), value);
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
    public long getTimeInterval() {
      return impl.getPropertyValue(INSTANCE.getTimeIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTimeInterval(Long value) {
      impl.setPropertyValue(INSTANCE.getTimeIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends FileBasedHTTPAccessLogPublisherCfgClient, ? extends FileBasedHTTPAccessLogPublisherCfg> definition() {
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
  private static class FileBasedHTTPAccessLogPublisherCfgServerImpl implements
    FileBasedHTTPAccessLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FileBasedHTTPAccessLogPublisherCfg> impl;

    /** The value of the "append" property. */
    private final boolean pAppend;

    /** The value of the "asynchronous" property. */
    private final boolean pAsynchronous;

    /** The value of the "auto-flush" property. */
    private final boolean pAutoFlush;

    /** The value of the "buffer-size" property. */
    private final long pBufferSize;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "log-file" property. */
    private final String pLogFile;

    /** The value of the "log-file-permissions" property. */
    private final String pLogFilePermissions;

    /** The value of the "log-format" property. */
    private final String pLogFormat;

    /** The value of the "log-record-time-format" property. */
    private final String pLogRecordTimeFormat;

    /** The value of the "queue-size" property. */
    private final int pQueueSize;

    /** The value of the "retention-policy" property. */
    private final SortedSet<String> pRetentionPolicy;

    /** The value of the "rotation-policy" property. */
    private final SortedSet<String> pRotationPolicy;

    /** The value of the "time-interval" property. */
    private final long pTimeInterval;



    /** Private constructor. */
    private FileBasedHTTPAccessLogPublisherCfgServerImpl(ServerManagedObject<? extends FileBasedHTTPAccessLogPublisherCfg> impl) {
      this.impl = impl;
      this.pAppend = impl.getPropertyValue(INSTANCE.getAppendPropertyDefinition());
      this.pAsynchronous = impl.getPropertyValue(INSTANCE.getAsynchronousPropertyDefinition());
      this.pAutoFlush = impl.getPropertyValue(INSTANCE.getAutoFlushPropertyDefinition());
      this.pBufferSize = impl.getPropertyValue(INSTANCE.getBufferSizePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLogFile = impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
      this.pLogFilePermissions = impl.getPropertyValue(INSTANCE.getLogFilePermissionsPropertyDefinition());
      this.pLogFormat = impl.getPropertyValue(INSTANCE.getLogFormatPropertyDefinition());
      this.pLogRecordTimeFormat = impl.getPropertyValue(INSTANCE.getLogRecordTimeFormatPropertyDefinition());
      this.pQueueSize = impl.getPropertyValue(INSTANCE.getQueueSizePropertyDefinition());
      this.pRetentionPolicy = impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
      this.pRotationPolicy = impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
      this.pTimeInterval = impl.getPropertyValue(INSTANCE.getTimeIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFileBasedHTTPAccessChangeListener(
        ConfigurationChangeListener<FileBasedHTTPAccessLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFileBasedHTTPAccessChangeListener(
        ConfigurationChangeListener<FileBasedHTTPAccessLogPublisherCfg> listener) {
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
    public boolean isAppend() {
      return pAppend;
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
    public long getBufferSize() {
      return pBufferSize;
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
    public String getLogFile() {
      return pLogFile;
    }



    /** {@inheritDoc} */
    public String getLogFilePermissions() {
      return pLogFilePermissions;
    }



    /** {@inheritDoc} */
    public String getLogFormat() {
      return pLogFormat;
    }



    /** {@inheritDoc} */
    public String getLogRecordTimeFormat() {
      return pLogRecordTimeFormat;
    }



    /** {@inheritDoc} */
    public int getQueueSize() {
      return pQueueSize;
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
    public long getTimeInterval() {
      return pTimeInterval;
    }



    /** {@inheritDoc} */
    public Class<? extends FileBasedHTTPAccessLogPublisherCfg> configurationClass() {
      return FileBasedHTTPAccessLogPublisherCfg.class;
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
