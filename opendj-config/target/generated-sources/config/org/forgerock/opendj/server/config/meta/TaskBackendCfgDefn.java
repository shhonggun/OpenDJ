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
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectOption;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.TaskBackendCfgClient;
import org.forgerock.opendj.server.config.meta.LocalBackendCfgDefn.WritabilityMode;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.LocalBackendCfg;
import org.forgerock.opendj.server.config.server.TaskBackendCfg;



/**
 * An interface for querying the Task Backend managed object
 * definition meta information.
 * <p>
 * The Task Backend provides a mechanism for scheduling tasks in the
 * OpenDJ directory server. Tasks are intended to provide access to
 * certain types of administrative functions in the server that may not
 * be convenient to perform remotely.
 */
public final class TaskBackendCfgDefn extends ManagedObjectDefinition<TaskBackendCfgClient, TaskBackendCfg> {

  /** The singleton configuration definition instance. */
  private static final TaskBackendCfgDefn INSTANCE = new TaskBackendCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "notification-sender-address" property definition. */
  private static final StringPropertyDefinition PD_NOTIFICATION_SENDER_ADDRESS;



  /** The "task-backing-file" property definition. */
  private static final StringPropertyDefinition PD_TASK_BACKING_FILE;



  /** The "task-retention-time" property definition. */
  private static final DurationPropertyDefinition PD_TASK_RETENTION_TIME;



  /** The "writability-mode" property definition. */
  private static final EnumPropertyDefinition<WritabilityMode> PD_WRITABILITY_MODE;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.backends.task.TaskBackend");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.Backend");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "notification-sender-address" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "notification-sender-address");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "notification-sender-address"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "notification-sender-address"));
      PD_NOTIFICATION_SENDER_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NOTIFICATION_SENDER_ADDRESS);
  }



  /** Build the "task-backing-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "task-backing-file");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "task-backing-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_TASK_BACKING_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TASK_BACKING_FILE);
  }



  /** Build the "task-retention-time" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "task-retention-time");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "task-retention-time"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("24 hours");
      builder.setDefaultBehaviorProvider(provider);
      PD_TASK_RETENTION_TIME = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TASK_RETENTION_TIME);
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



  // Register the options associated with this managed object definition.
  static {
    INSTANCE.registerOption(ManagedObjectOption.ADVANCED);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Task Backend configuration definition singleton.
   *
   * @return Returns the Task Backend configuration definition
   *         singleton.
   */
  public static TaskBackendCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private TaskBackendCfgDefn() {
    super("task-backend", LocalBackendCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public TaskBackendCfgClient createClientConfiguration(
      ManagedObject<? extends TaskBackendCfgClient> impl) {
    return new TaskBackendCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public TaskBackendCfg createServerConfiguration(
      ServerManagedObject<? extends TaskBackendCfg> impl) {
    return new TaskBackendCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<TaskBackendCfg> getServerConfigurationClass() {
    return TaskBackendCfg.class;
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
   * Get the "notification-sender-address" property definition.
   * <p>
   * Specifies the email address to use as the sender (that is, the
   * "From:" address) address for notification mail messages generated
   * when a task completes execution.
   *
   * @return Returns the "notification-sender-address" property definition.
   */
  public StringPropertyDefinition getNotificationSenderAddressPropertyDefinition() {
    return PD_NOTIFICATION_SENDER_ADDRESS;
  }



  /**
   * Get the "task-backing-file" property definition.
   * <p>
   * Specifies the path to the backing file for storing information
   * about the tasks configured in the server.
   * <p>
   * It may be either an absolute path or a relative path to the base
   * of the OpenDJ directory server instance.
   *
   * @return Returns the "task-backing-file" property definition.
   */
  public StringPropertyDefinition getTaskBackingFilePropertyDefinition() {
    return PD_TASK_BACKING_FILE;
  }



  /**
   * Get the "task-retention-time" property definition.
   * <p>
   * Specifies the length of time that task entries should be retained
   * after processing on the associated task has been completed.
   *
   * @return Returns the "task-retention-time" property definition.
   */
  public DurationPropertyDefinition getTaskRetentionTimePropertyDefinition() {
    return PD_TASK_RETENTION_TIME;
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
   * Managed object client implementation.
   */
  private static class TaskBackendCfgClientImpl implements
    TaskBackendCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends TaskBackendCfgClient> impl;



    /** Private constructor. */
    private TaskBackendCfgClientImpl(
        ManagedObject<? extends TaskBackendCfgClient> impl) {
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
    public String getNotificationSenderAddress() {
      return impl.getPropertyValue(INSTANCE.getNotificationSenderAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setNotificationSenderAddress(String value) {
      impl.setPropertyValue(INSTANCE.getNotificationSenderAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTaskBackingFile() {
      return impl.getPropertyValue(INSTANCE.getTaskBackingFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTaskBackingFile(String value) {
      impl.setPropertyValue(INSTANCE.getTaskBackingFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public long getTaskRetentionTime() {
      return impl.getPropertyValue(INSTANCE.getTaskRetentionTimePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTaskRetentionTime(Long value) {
      impl.setPropertyValue(INSTANCE.getTaskRetentionTimePropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends TaskBackendCfgClient, ? extends TaskBackendCfg> definition() {
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
  private static class TaskBackendCfgServerImpl implements
    TaskBackendCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends TaskBackendCfg> impl;

    /** The value of the "backend-id" property. */
    private final String pBackendId;

    /** The value of the "base-dn" property. */
    private final SortedSet<DN> pBaseDN;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "notification-sender-address" property. */
    private final String pNotificationSenderAddress;

    /** The value of the "task-backing-file" property. */
    private final String pTaskBackingFile;

    /** The value of the "task-retention-time" property. */
    private final long pTaskRetentionTime;

    /** The value of the "writability-mode" property. */
    private final WritabilityMode pWritabilityMode;



    /** Private constructor. */
    private TaskBackendCfgServerImpl(ServerManagedObject<? extends TaskBackendCfg> impl) {
      this.impl = impl;
      this.pBackendId = impl.getPropertyValue(INSTANCE.getBackendIdPropertyDefinition());
      this.pBaseDN = impl.getPropertyValues(INSTANCE.getBaseDNPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pNotificationSenderAddress = impl.getPropertyValue(INSTANCE.getNotificationSenderAddressPropertyDefinition());
      this.pTaskBackingFile = impl.getPropertyValue(INSTANCE.getTaskBackingFilePropertyDefinition());
      this.pTaskRetentionTime = impl.getPropertyValue(INSTANCE.getTaskRetentionTimePropertyDefinition());
      this.pWritabilityMode = impl.getPropertyValue(INSTANCE.getWritabilityModePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addTaskChangeListener(
        ConfigurationChangeListener<TaskBackendCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeTaskChangeListener(
        ConfigurationChangeListener<TaskBackendCfg> listener) {
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
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getNotificationSenderAddress() {
      return pNotificationSenderAddress;
    }



    /** {@inheritDoc} */
    public String getTaskBackingFile() {
      return pTaskBackingFile;
    }



    /** {@inheritDoc} */
    public long getTaskRetentionTime() {
      return pTaskRetentionTime;
    }



    /** {@inheritDoc} */
    public WritabilityMode getWritabilityMode() {
      return pWritabilityMode;
    }



    /** {@inheritDoc} */
    public Class<? extends TaskBackendCfg> configurationClass() {
      return TaskBackendCfg.class;
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
