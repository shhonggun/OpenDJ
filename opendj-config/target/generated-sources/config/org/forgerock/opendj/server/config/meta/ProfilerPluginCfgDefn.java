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
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.ProfilerPluginCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.ProfilerPluginCfg;



/**
 * An interface for querying the Profiler Plugin managed object
 * definition meta information.
 * <p>
 * The Profiler plug-in captures profiling information about
 * operations performed inside the JVM while the OpenDJ directory
 * server is running.
 */
public final class ProfilerPluginCfgDefn extends ManagedObjectDefinition<ProfilerPluginCfgClient, ProfilerPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final ProfilerPluginCfgDefn INSTANCE = new ProfilerPluginCfgDefn();



  /**
   * Defines the set of permissable values for the "profile-action" property.
   * <p>
   * Specifies the action that should be taken by the profiler.
   * <p>
   * A value of "start" causes the profiler thread to start collecting
   * data if it is not already active. A value of "stop" causes the
   * profiler thread to stop collecting data and write it to disk, and
   * a value of "cancel" causes the profiler thread to stop collecting
   * data and discard anything that has been captured. These operations
   * occur immediately.
   */
  public static enum ProfileAction {

    /**
     * Stop collecting profile data and discard what has been
     * captured.
     */
    CANCEL("cancel"),



    /**
     * Do not take any action.
     */
    NONE("none"),



    /**
     * Start collecting profile data.
     */
    START("start"),



    /**
     * Stop collecting profile data and write what has been captured
     * to a file in the profile directory.
     */
    STOP("stop");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private ProfileAction(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "enable-profiling-on-startup" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLE_PROFILING_ON_STARTUP;



  /** The "invoke-for-internal-operations" property definition. */
  private static final BooleanPropertyDefinition PD_INVOKE_FOR_INTERNAL_OPERATIONS;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** The "profile-action" property definition. */
  private static final EnumPropertyDefinition<ProfileAction> PD_PROFILE_ACTION;



  /** The "profile-directory" property definition. */
  private static final StringPropertyDefinition PD_PROFILE_DIRECTORY;



  /** The "profile-sample-interval" property definition. */
  private static final DurationPropertyDefinition PD_PROFILE_SAMPLE_INTERVAL;



  /** Build the "enable-profiling-on-startup" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enable-profiling-on-startup");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enable-profiling-on-startup"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLE_PROFILING_ON_STARTUP = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLE_PROFILING_ON_STARTUP);
  }



  /** Build the "invoke-for-internal-operations" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "invoke-for-internal-operations");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "invoke-for-internal-operations"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_INVOKE_FOR_INTERNAL_OPERATIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INVOKE_FOR_INTERNAL_OPERATIONS);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.plugins.profiler.ProfilerPlugin");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.plugin.DirectoryServerPlugin");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "plugin-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<PluginType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "plugin-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "plugin-type"));
      DefaultBehaviorProvider<PluginType> provider = new DefinedDefaultBehaviorProvider<PluginType>("startup");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(PluginType.class);
      PD_PLUGIN_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_TYPE);
  }



  /** Build the "profile-action" property definition. */
  static {
      EnumPropertyDefinition.Builder<ProfileAction> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "profile-action");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "profile-action"));
      DefaultBehaviorProvider<ProfileAction> provider = new DefinedDefaultBehaviorProvider<ProfileAction>("none");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(ProfileAction.class);
      PD_PROFILE_ACTION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PROFILE_ACTION);
  }



  /** Build the "profile-directory" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "profile-directory");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "profile-directory"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "DIR");
      PD_PROFILE_DIRECTORY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PROFILE_DIRECTORY);
  }



  /** Build the "profile-sample-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "profile-sample-interval");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "profile-sample-interval"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setBaseUnit("ms");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("1");
      PD_PROFILE_SAMPLE_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PROFILE_SAMPLE_INTERVAL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Profiler Plugin configuration definition singleton.
   *
   * @return Returns the Profiler Plugin configuration definition
   *         singleton.
   */
  public static ProfilerPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ProfilerPluginCfgDefn() {
    super("profiler-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ProfilerPluginCfgClient createClientConfiguration(
      ManagedObject<? extends ProfilerPluginCfgClient> impl) {
    return new ProfilerPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ProfilerPluginCfg createServerConfiguration(
      ServerManagedObject<? extends ProfilerPluginCfg> impl) {
    return new ProfilerPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ProfilerPluginCfg> getServerConfigurationClass() {
    return ProfilerPluginCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the plug-in is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PluginCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "enable-profiling-on-startup" property definition.
   * <p>
   * Indicates whether the profiler plug-in is to start collecting
   * data automatically when the directory server is started.
   * <p>
   * This property is read only when the server is started, and any
   * changes take effect on the next restart. This property is
   * typically set to "false" unless startup profiling is required,
   * because otherwise the volume of data that can be collected can
   * cause the server to run out of memory if it is not turned off in a
   * timely manner.
   *
   * @return Returns the "enable-profiling-on-startup" property definition.
   */
  public BooleanPropertyDefinition getEnableProfilingOnStartupPropertyDefinition() {
    return PD_ENABLE_PROFILING_ON_STARTUP;
  }



  /**
   * Get the "invoke-for-internal-operations" property definition.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @return Returns the "invoke-for-internal-operations" property definition.
   */
  public BooleanPropertyDefinition getInvokeForInternalOperationsPropertyDefinition() {
    return PD_INVOKE_FOR_INTERNAL_OPERATIONS;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "plugin-type" property definition.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the "plugin-type" property definition.
   */
  public EnumPropertyDefinition<PluginType> getPluginTypePropertyDefinition() {
    return PD_PLUGIN_TYPE;
  }



  /**
   * Get the "profile-action" property definition.
   * <p>
   * Specifies the action that should be taken by the profiler.
   * <p>
   * A value of "start" causes the profiler thread to start collecting
   * data if it is not already active. A value of "stop" causes the
   * profiler thread to stop collecting data and write it to disk, and
   * a value of "cancel" causes the profiler thread to stop collecting
   * data and discard anything that has been captured. These operations
   * occur immediately.
   *
   * @return Returns the "profile-action" property definition.
   */
  public EnumPropertyDefinition<ProfileAction> getProfileActionPropertyDefinition() {
    return PD_PROFILE_ACTION;
  }



  /**
   * Get the "profile-directory" property definition.
   * <p>
   * Specifies the path to the directory where profile information is
   * to be written. This path may be either an absolute path or a path
   * that is relative to the root of the OpenDJ directory server
   * instance.
   * <p>
   * The directory must exist and the directory server must have
   * permission to create new files in it.
   *
   * @return Returns the "profile-directory" property definition.
   */
  public StringPropertyDefinition getProfileDirectoryPropertyDefinition() {
    return PD_PROFILE_DIRECTORY;
  }



  /**
   * Get the "profile-sample-interval" property definition.
   * <p>
   * Specifies the sample interval in milliseconds to be used when
   * capturing profiling information in the server.
   * <p>
   * When capturing data, the profiler thread sleeps for this length
   * of time between calls to obtain traces for all threads running in
   * the JVM.
   *
   * @return Returns the "profile-sample-interval" property definition.
   */
  public DurationPropertyDefinition getProfileSampleIntervalPropertyDefinition() {
    return PD_PROFILE_SAMPLE_INTERVAL;
  }



  /**
   * Managed object client implementation.
   */
  private static class ProfilerPluginCfgClientImpl implements
    ProfilerPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ProfilerPluginCfgClient> impl;



    /** Private constructor. */
    private ProfilerPluginCfgClientImpl(
        ManagedObject<? extends ProfilerPluginCfgClient> impl) {
      this.impl = impl;
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
    public Boolean isEnableProfilingOnStartup() {
      return impl.getPropertyValue(INSTANCE.getEnableProfilingOnStartupPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnableProfilingOnStartup(boolean value) {
      impl.setPropertyValue(INSTANCE.getEnableProfilingOnStartupPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isInvokeForInternalOperations() {
      return impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setInvokeForInternalOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition(), value);
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
    public SortedSet<PluginType> getPluginType() {
      return impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginType(Collection<PluginType> values) {
      impl.setPropertyValues(INSTANCE.getPluginTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ProfileAction getProfileAction() {
      return impl.getPropertyValue(INSTANCE.getProfileActionPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setProfileAction(ProfileAction value) {
      impl.setPropertyValue(INSTANCE.getProfileActionPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getProfileDirectory() {
      return impl.getPropertyValue(INSTANCE.getProfileDirectoryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setProfileDirectory(String value) {
      impl.setPropertyValue(INSTANCE.getProfileDirectoryPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Long getProfileSampleInterval() {
      return impl.getPropertyValue(INSTANCE.getProfileSampleIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setProfileSampleInterval(long value) {
      impl.setPropertyValue(INSTANCE.getProfileSampleIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends ProfilerPluginCfgClient, ? extends ProfilerPluginCfg> definition() {
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
  private static class ProfilerPluginCfgServerImpl implements
    ProfilerPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ProfilerPluginCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "enable-profiling-on-startup" property. */
    private final boolean pEnableProfilingOnStartup;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;

    /** The value of the "profile-action" property. */
    private final ProfileAction pProfileAction;

    /** The value of the "profile-directory" property. */
    private final String pProfileDirectory;

    /** The value of the "profile-sample-interval" property. */
    private final long pProfileSampleInterval;



    /** Private constructor. */
    private ProfilerPluginCfgServerImpl(ServerManagedObject<? extends ProfilerPluginCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pEnableProfilingOnStartup = impl.getPropertyValue(INSTANCE.getEnableProfilingOnStartupPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
      this.pProfileAction = impl.getPropertyValue(INSTANCE.getProfileActionPropertyDefinition());
      this.pProfileDirectory = impl.getPropertyValue(INSTANCE.getProfileDirectoryPropertyDefinition());
      this.pProfileSampleInterval = impl.getPropertyValue(INSTANCE.getProfileSampleIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addProfilerChangeListener(
        ConfigurationChangeListener<ProfilerPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeProfilerChangeListener(
        ConfigurationChangeListener<ProfilerPluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isEnableProfilingOnStartup() {
      return pEnableProfilingOnStartup;
    }



    /** {@inheritDoc} */
    public boolean isInvokeForInternalOperations() {
      return pInvokeForInternalOperations;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public SortedSet<PluginType> getPluginType() {
      return pPluginType;
    }



    /** {@inheritDoc} */
    public ProfileAction getProfileAction() {
      return pProfileAction;
    }



    /** {@inheritDoc} */
    public String getProfileDirectory() {
      return pProfileDirectory;
    }



    /** {@inheritDoc} */
    public long getProfileSampleInterval() {
      return pProfileSampleInterval;
    }



    /** {@inheritDoc} */
    public Class<? extends ProfilerPluginCfg> configurationClass() {
      return ProfilerPluginCfg.class;
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
