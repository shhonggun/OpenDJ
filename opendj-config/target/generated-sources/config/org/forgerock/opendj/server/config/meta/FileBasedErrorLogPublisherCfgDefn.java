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
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.FileBasedErrorLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.client.LogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.meta.ErrorLogPublisherCfgDefn.DefaultSeverity;
import org.forgerock.opendj.server.config.server.ErrorLogPublisherCfg;
import org.forgerock.opendj.server.config.server.FileBasedErrorLogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the File Based Error Log Publisher
 * managed object definition meta information.
 * <p>
 * File Based Error Log Publishers publish error messages to the file
 * system.
 */
public final class FileBasedErrorLogPublisherCfgDefn extends ManagedObjectDefinition<FileBasedErrorLogPublisherCfgClient, FileBasedErrorLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final FileBasedErrorLogPublisherCfgDefn INSTANCE = new FileBasedErrorLogPublisherCfgDefn();



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
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
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
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.TextErrorLogPublisher");
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
   * Get the File Based Error Log Publisher configuration definition
   * singleton.
   *
   * @return Returns the File Based Error Log Publisher configuration
   *         definition singleton.
   */
  public static FileBasedErrorLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FileBasedErrorLogPublisherCfgDefn() {
    super("file-based-error-log-publisher", ErrorLogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FileBasedErrorLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends FileBasedErrorLogPublisherCfgClient> impl) {
    return new FileBasedErrorLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FileBasedErrorLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends FileBasedErrorLogPublisherCfg> impl) {
    return new FileBasedErrorLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FileBasedErrorLogPublisherCfg> getServerConfigurationClass() {
    return FileBasedErrorLogPublisherCfg.class;
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
   * Indicates whether the File Based Error Log Publisher will publish
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
   * If the asynchronous writes option is used, the writer will be
   * flushed after all the log records in the queue are written.
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
   * Get the "default-severity" property definition.
   * <p>
   * Specifies the default severity levels for the logger.
   *
   * @return Returns the "default-severity" property definition.
   */
  public EnumPropertyDefinition<DefaultSeverity> getDefaultSeverityPropertyDefinition() {
    return ErrorLogPublisherCfgDefn.getInstance().getDefaultSeverityPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the File Based Error Log Publisher is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return ErrorLogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the File
   * Based Error Log Publisher implementation.
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
   * Based Error Log Publisher .
   * <p>
   * The path to the file is relative to the server root.
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
   * Error Log Publisher .
   *
   * @return Returns the "log-file-permissions" property definition.
   */
  public StringPropertyDefinition getLogFilePermissionsPropertyDefinition() {
    return PD_LOG_FILE_PERMISSIONS;
  }



  /**
   * Get the "override-severity" property definition.
   * <p>
   * Specifies the override severity levels for the logger based on
   * the category of the messages.
   * <p>
   * Each override severity level should include the category and the
   * severity levels to log for that category, for example,
   * core=error,info,warning. Valid categories are: core, extensions,
   * protocol, config, log, util, schema, plugin, jeb, backend, tools,
   * task, access-control, admin, sync, version, quicksetup,
   * admin-tool, dsconfig, user-defined. Valid severities are: all,
   * error, info, warning, notice, debug.
   *
   * @return Returns the "override-severity" property definition.
   */
  public StringPropertyDefinition getOverrideSeverityPropertyDefinition() {
    return ErrorLogPublisherCfgDefn.getInstance().getOverrideSeverityPropertyDefinition();
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
   * The retention policy to use for the File Based Error Log
   * Publisher .
   * <p>
   * When multiple policies are used, log files will be cleaned when
   * any of the policy's conditions are met.
   *
   * @return Returns the "retention-policy" property definition.
   */
  public AggregationPropertyDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> getRetentionPolicyPropertyDefinition() {
    return PD_RETENTION_POLICY;
  }



  /**
   * Get the "rotation-policy" property definition.
   * <p>
   * The rotation policy to use for the File Based Error Log Publisher
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
  private static class FileBasedErrorLogPublisherCfgClientImpl implements
    FileBasedErrorLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FileBasedErrorLogPublisherCfgClient> impl;



    /** Private constructor. */
    private FileBasedErrorLogPublisherCfgClientImpl(
        ManagedObject<? extends FileBasedErrorLogPublisherCfgClient> impl) {
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
    public SortedSet<DefaultSeverity> getDefaultSeverity() {
      return impl.getPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultSeverity(Collection<DefaultSeverity> values) {
      impl.setPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition(), values);
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
    public SortedSet<String> getOverrideSeverity() {
      return impl.getPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOverrideSeverity(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends FileBasedErrorLogPublisherCfgClient, ? extends FileBasedErrorLogPublisherCfg> definition() {
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
  private static class FileBasedErrorLogPublisherCfgServerImpl implements
    FileBasedErrorLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FileBasedErrorLogPublisherCfg> impl;

    /** The value of the "append" property. */
    private final boolean pAppend;

    /** The value of the "asynchronous" property. */
    private final boolean pAsynchronous;

    /** The value of the "auto-flush" property. */
    private final boolean pAutoFlush;

    /** The value of the "buffer-size" property. */
    private final long pBufferSize;

    /** The value of the "default-severity" property. */
    private final SortedSet<DefaultSeverity> pDefaultSeverity;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "log-file" property. */
    private final String pLogFile;

    /** The value of the "log-file-permissions" property. */
    private final String pLogFilePermissions;

    /** The value of the "override-severity" property. */
    private final SortedSet<String> pOverrideSeverity;

    /** The value of the "queue-size" property. */
    private final int pQueueSize;

    /** The value of the "retention-policy" property. */
    private final SortedSet<String> pRetentionPolicy;

    /** The value of the "rotation-policy" property. */
    private final SortedSet<String> pRotationPolicy;

    /** The value of the "time-interval" property. */
    private final long pTimeInterval;



    /** Private constructor. */
    private FileBasedErrorLogPublisherCfgServerImpl(ServerManagedObject<? extends FileBasedErrorLogPublisherCfg> impl) {
      this.impl = impl;
      this.pAppend = impl.getPropertyValue(INSTANCE.getAppendPropertyDefinition());
      this.pAsynchronous = impl.getPropertyValue(INSTANCE.getAsynchronousPropertyDefinition());
      this.pAutoFlush = impl.getPropertyValue(INSTANCE.getAutoFlushPropertyDefinition());
      this.pBufferSize = impl.getPropertyValue(INSTANCE.getBufferSizePropertyDefinition());
      this.pDefaultSeverity = impl.getPropertyValues(INSTANCE.getDefaultSeverityPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLogFile = impl.getPropertyValue(INSTANCE.getLogFilePropertyDefinition());
      this.pLogFilePermissions = impl.getPropertyValue(INSTANCE.getLogFilePermissionsPropertyDefinition());
      this.pOverrideSeverity = impl.getPropertyValues(INSTANCE.getOverrideSeverityPropertyDefinition());
      this.pQueueSize = impl.getPropertyValue(INSTANCE.getQueueSizePropertyDefinition());
      this.pRetentionPolicy = impl.getPropertyValues(INSTANCE.getRetentionPolicyPropertyDefinition());
      this.pRotationPolicy = impl.getPropertyValues(INSTANCE.getRotationPolicyPropertyDefinition());
      this.pTimeInterval = impl.getPropertyValue(INSTANCE.getTimeIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFileBasedErrorChangeListener(
        ConfigurationChangeListener<FileBasedErrorLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFileBasedErrorChangeListener(
        ConfigurationChangeListener<FileBasedErrorLogPublisherCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addErrorChangeListener(
        ConfigurationChangeListener<ErrorLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeErrorChangeListener(
        ConfigurationChangeListener<ErrorLogPublisherCfg> listener) {
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
    public SortedSet<DefaultSeverity> getDefaultSeverity() {
      return pDefaultSeverity;
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
    public SortedSet<String> getOverrideSeverity() {
      return pOverrideSeverity;
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
    public Class<? extends FileBasedErrorLogPublisherCfg> configurationClass() {
      return FileBasedErrorLogPublisherCfg.class;
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
