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
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.DebugLogPublisherCfgClient;
import org.forgerock.opendj.server.config.client.DebugTargetCfgClient;
import org.forgerock.opendj.server.config.server.DebugLogPublisherCfg;
import org.forgerock.opendj.server.config.server.DebugTargetCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;



/**
 * An interface for querying the Debug Log Publisher managed object
 * definition meta information.
 * <p>
 * Debug Log Publishers are responsible for distributing debug log
 * messages from the debug logger to a destination.
 */
public final class DebugLogPublisherCfgDefn extends ManagedObjectDefinition<DebugLogPublisherCfgClient, DebugLogPublisherCfg> {

  /** The singleton configuration definition instance. */
  private static final DebugLogPublisherCfgDefn INSTANCE = new DebugLogPublisherCfgDefn();



  /** The "default-debug-exceptions-only" property definition. */
  private static final BooleanPropertyDefinition PD_DEFAULT_DEBUG_EXCEPTIONS_ONLY;



  /** The "default-include-throwable-cause" property definition. */
  private static final BooleanPropertyDefinition PD_DEFAULT_INCLUDE_THROWABLE_CAUSE;



  /** The "default-omit-method-entry-arguments" property definition. */
  private static final BooleanPropertyDefinition PD_DEFAULT_OMIT_METHOD_ENTRY_ARGUMENTS;



  /** The "default-omit-method-return-value" property definition. */
  private static final BooleanPropertyDefinition PD_DEFAULT_OMIT_METHOD_RETURN_VALUE;



  /** The "default-throwable-stack-frames" property definition. */
  private static final IntegerPropertyDefinition PD_DEFAULT_THROWABLE_STACK_FRAMES;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "debug-targets" relation definition. */
  private static final InstantiableRelationDefinition<DebugTargetCfgClient, DebugTargetCfg> RD_DEBUG_TARGETS;



  /** Build the "default-debug-exceptions-only" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "default-debug-exceptions-only");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-debug-exceptions-only"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DEFAULT_DEBUG_EXCEPTIONS_ONLY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_DEBUG_EXCEPTIONS_ONLY);
  }



  /** Build the "default-include-throwable-cause" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "default-include-throwable-cause");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-include-throwable-cause"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_DEFAULT_INCLUDE_THROWABLE_CAUSE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_INCLUDE_THROWABLE_CAUSE);
  }



  /** Build the "default-omit-method-entry-arguments" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "default-omit-method-entry-arguments");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-omit-method-entry-arguments"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DEFAULT_OMIT_METHOD_ENTRY_ARGUMENTS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_OMIT_METHOD_ENTRY_ARGUMENTS);
  }



  /** Build the "default-omit-method-return-value" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "default-omit-method-return-value");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-omit-method-return-value"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DEFAULT_OMIT_METHOD_RETURN_VALUE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_OMIT_METHOD_RETURN_VALUE);
  }



  /** Build the "default-throwable-stack-frames" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "default-throwable-stack-frames");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "default-throwable-stack-frames"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("2147483647");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_DEFAULT_THROWABLE_STACK_FRAMES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEFAULT_THROWABLE_STACK_FRAMES);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.DebugLogPublisher");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.LogPublisher");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Build the "debug-targets" relation definition.
  static {
    InstantiableRelationDefinition.Builder<DebugTargetCfgClient, DebugTargetCfg> builder =
      new InstantiableRelationDefinition.Builder<DebugTargetCfgClient, DebugTargetCfg>(INSTANCE, "debug-target", "debug-targets", DebugTargetCfgDefn.getInstance());
    builder.setNamingProperty(DebugTargetCfgDefn.getInstance().getDebugScopePropertyDefinition());
    RD_DEBUG_TARGETS = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_DEBUG_TARGETS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Debug Log Publisher configuration definition singleton.
   *
   * @return Returns the Debug Log Publisher configuration definition
   *         singleton.
   */
  public static DebugLogPublisherCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private DebugLogPublisherCfgDefn() {
    super("debug-log-publisher", LogPublisherCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public DebugLogPublisherCfgClient createClientConfiguration(
      ManagedObject<? extends DebugLogPublisherCfgClient> impl) {
    return new DebugLogPublisherCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public DebugLogPublisherCfg createServerConfiguration(
      ServerManagedObject<? extends DebugLogPublisherCfg> impl) {
    return new DebugLogPublisherCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<DebugLogPublisherCfg> getServerConfigurationClass() {
    return DebugLogPublisherCfg.class;
  }



  /**
   * Get the "default-debug-exceptions-only" property definition.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @return Returns the "default-debug-exceptions-only" property definition.
   */
  public BooleanPropertyDefinition getDefaultDebugExceptionsOnlyPropertyDefinition() {
    return PD_DEFAULT_DEBUG_EXCEPTIONS_ONLY;
  }



  /**
   * Get the "default-include-throwable-cause" property definition.
   * <p>
   * Indicates whether to include the cause of exceptions in exception
   * thrown and caught messages logged by default.
   *
   * @return Returns the "default-include-throwable-cause" property definition.
   */
  public BooleanPropertyDefinition getDefaultIncludeThrowableCausePropertyDefinition() {
    return PD_DEFAULT_INCLUDE_THROWABLE_CAUSE;
  }



  /**
   * Get the "default-omit-method-entry-arguments" property definition.
   * <p>
   * Indicates whether to include method arguments in debug messages
   * logged by default.
   *
   * @return Returns the "default-omit-method-entry-arguments" property definition.
   */
  public BooleanPropertyDefinition getDefaultOmitMethodEntryArgumentsPropertyDefinition() {
    return PD_DEFAULT_OMIT_METHOD_ENTRY_ARGUMENTS;
  }



  /**
   * Get the "default-omit-method-return-value" property definition.
   * <p>
   * Indicates whether to include the return value in debug messages
   * logged by default.
   *
   * @return Returns the "default-omit-method-return-value" property definition.
   */
  public BooleanPropertyDefinition getDefaultOmitMethodReturnValuePropertyDefinition() {
    return PD_DEFAULT_OMIT_METHOD_RETURN_VALUE;
  }



  /**
   * Get the "default-throwable-stack-frames" property definition.
   * <p>
   * Indicates the number of stack frames to include in the stack
   * trace for method entry and exception thrown messages.
   *
   * @return Returns the "default-throwable-stack-frames" property definition.
   */
  public IntegerPropertyDefinition getDefaultThrowableStackFramesPropertyDefinition() {
    return PD_DEFAULT_THROWABLE_STACK_FRAMES;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Debug Log Publisher is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return LogPublisherCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * The fully-qualified name of the Java class that provides the
   * Debug Log Publisher implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "debug-targets" relation definition.
   *
   * @return Returns the "debug-targets" relation definition.
   */
  public InstantiableRelationDefinition<DebugTargetCfgClient,DebugTargetCfg> getDebugTargetsRelationDefinition() {
    return RD_DEBUG_TARGETS;
  }



  /**
   * Managed object client implementation.
   */
  private static class DebugLogPublisherCfgClientImpl implements
    DebugLogPublisherCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends DebugLogPublisherCfgClient> impl;



    /** Private constructor. */
    private DebugLogPublisherCfgClientImpl(
        ManagedObject<? extends DebugLogPublisherCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isDefaultDebugExceptionsOnly() {
      return impl.getPropertyValue(INSTANCE.getDefaultDebugExceptionsOnlyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultDebugExceptionsOnly(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDefaultDebugExceptionsOnlyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDefaultIncludeThrowableCause() {
      return impl.getPropertyValue(INSTANCE.getDefaultIncludeThrowableCausePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultIncludeThrowableCause(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDefaultIncludeThrowableCausePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDefaultOmitMethodEntryArguments() {
      return impl.getPropertyValue(INSTANCE.getDefaultOmitMethodEntryArgumentsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultOmitMethodEntryArguments(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDefaultOmitMethodEntryArgumentsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isDefaultOmitMethodReturnValue() {
      return impl.getPropertyValue(INSTANCE.getDefaultOmitMethodReturnValuePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultOmitMethodReturnValue(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDefaultOmitMethodReturnValuePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getDefaultThrowableStackFrames() {
      return impl.getPropertyValue(INSTANCE.getDefaultThrowableStackFramesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDefaultThrowableStackFrames(Integer value) {
      impl.setPropertyValue(INSTANCE.getDefaultThrowableStackFramesPropertyDefinition(), value);
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
    public String[] listDebugTargets() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getDebugTargetsRelationDefinition());
    }



    /** {@inheritDoc} */
    public DebugTargetCfgClient getDebugTarget(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getDebugTargetsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends DebugTargetCfgClient> M createDebugTarget(
        ManagedObjectDefinition<M, ? extends DebugTargetCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getDebugTargetsRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeDebugTarget(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getDebugTargetsRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends DebugLogPublisherCfgClient, ? extends DebugLogPublisherCfg> definition() {
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
  private static class DebugLogPublisherCfgServerImpl implements
    DebugLogPublisherCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends DebugLogPublisherCfg> impl;

    /** The value of the "default-debug-exceptions-only" property. */
    private final boolean pDefaultDebugExceptionsOnly;

    /** The value of the "default-include-throwable-cause" property. */
    private final boolean pDefaultIncludeThrowableCause;

    /** The value of the "default-omit-method-entry-arguments" property. */
    private final boolean pDefaultOmitMethodEntryArguments;

    /** The value of the "default-omit-method-return-value" property. */
    private final boolean pDefaultOmitMethodReturnValue;

    /** The value of the "default-throwable-stack-frames" property. */
    private final int pDefaultThrowableStackFrames;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private DebugLogPublisherCfgServerImpl(ServerManagedObject<? extends DebugLogPublisherCfg> impl) {
      this.impl = impl;
      this.pDefaultDebugExceptionsOnly = impl.getPropertyValue(INSTANCE.getDefaultDebugExceptionsOnlyPropertyDefinition());
      this.pDefaultIncludeThrowableCause = impl.getPropertyValue(INSTANCE.getDefaultIncludeThrowableCausePropertyDefinition());
      this.pDefaultOmitMethodEntryArguments = impl.getPropertyValue(INSTANCE.getDefaultOmitMethodEntryArgumentsPropertyDefinition());
      this.pDefaultOmitMethodReturnValue = impl.getPropertyValue(INSTANCE.getDefaultOmitMethodReturnValuePropertyDefinition());
      this.pDefaultThrowableStackFrames = impl.getPropertyValue(INSTANCE.getDefaultThrowableStackFramesPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addDebugChangeListener(
        ConfigurationChangeListener<DebugLogPublisherCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeDebugChangeListener(
        ConfigurationChangeListener<DebugLogPublisherCfg> listener) {
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
    public boolean isDefaultDebugExceptionsOnly() {
      return pDefaultDebugExceptionsOnly;
    }



    /** {@inheritDoc} */
    public boolean isDefaultIncludeThrowableCause() {
      return pDefaultIncludeThrowableCause;
    }



    /** {@inheritDoc} */
    public boolean isDefaultOmitMethodEntryArguments() {
      return pDefaultOmitMethodEntryArguments;
    }



    /** {@inheritDoc} */
    public boolean isDefaultOmitMethodReturnValue() {
      return pDefaultOmitMethodReturnValue;
    }



    /** {@inheritDoc} */
    public int getDefaultThrowableStackFrames() {
      return pDefaultThrowableStackFrames;
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
    public String[] listDebugTargets() {
      return impl.listChildren(INSTANCE.getDebugTargetsRelationDefinition());
    }



    /** {@inheritDoc} */
    public DebugTargetCfg getDebugTarget(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getDebugTargetsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addDebugTargetAddListener(
        ConfigurationAddListener<DebugTargetCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getDebugTargetsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeDebugTargetAddListener(
        ConfigurationAddListener<DebugTargetCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getDebugTargetsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addDebugTargetDeleteListener(
        ConfigurationDeleteListener<DebugTargetCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getDebugTargetsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeDebugTargetDeleteListener(
        ConfigurationDeleteListener<DebugTargetCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getDebugTargetsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends DebugLogPublisherCfg> configurationClass() {
      return DebugLogPublisherCfg.class;
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
