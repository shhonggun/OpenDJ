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



import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.DebugTargetCfgClient;
import org.forgerock.opendj.server.config.server.DebugTargetCfg;



/**
 * An interface for querying the Debug Target managed object
 * definition meta information.
 * <p>
 * Debug Targets define the types of messages logged by the debug
 * logPublisher.
 */
public final class DebugTargetCfgDefn extends ManagedObjectDefinition<DebugTargetCfgClient, DebugTargetCfg> {

  /** The singleton configuration definition instance. */
  private static final DebugTargetCfgDefn INSTANCE = new DebugTargetCfgDefn();



  /** The "debug-exceptions-only" property definition. */
  private static final BooleanPropertyDefinition PD_DEBUG_EXCEPTIONS_ONLY;



  /** The "debug-scope" property definition. */
  private static final StringPropertyDefinition PD_DEBUG_SCOPE;



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "include-throwable-cause" property definition. */
  private static final BooleanPropertyDefinition PD_INCLUDE_THROWABLE_CAUSE;



  /** The "omit-method-entry-arguments" property definition. */
  private static final BooleanPropertyDefinition PD_OMIT_METHOD_ENTRY_ARGUMENTS;



  /** The "omit-method-return-value" property definition. */
  private static final BooleanPropertyDefinition PD_OMIT_METHOD_RETURN_VALUE;



  /** The "throwable-stack-frames" property definition. */
  private static final IntegerPropertyDefinition PD_THROWABLE_STACK_FRAMES;



  /** Build the "debug-exceptions-only" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "debug-exceptions-only");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "debug-exceptions-only"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_DEBUG_EXCEPTIONS_ONLY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEBUG_EXCEPTIONS_ONLY);
  }



  /** Build the "debug-scope" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "debug-scope");
      builder.setOption(PropertyOption.READ_ONLY);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "debug-scope"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^([A-Za-z][A-Za-z0-9_]*\\.)*[A-Za-z][A-Za-z0-9_]*(#[A-Za-z][A-Za-z0-9_]*)?$", "STRING");
      PD_DEBUG_SCOPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DEBUG_SCOPE);
  }



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "include-throwable-cause" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "include-throwable-cause");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "include-throwable-cause"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_INCLUDE_THROWABLE_CAUSE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INCLUDE_THROWABLE_CAUSE);
  }



  /** Build the "omit-method-entry-arguments" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "omit-method-entry-arguments");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "omit-method-entry-arguments"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_OMIT_METHOD_ENTRY_ARGUMENTS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OMIT_METHOD_ENTRY_ARGUMENTS);
  }



  /** Build the "omit-method-return-value" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "omit-method-return-value");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "omit-method-return-value"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_OMIT_METHOD_RETURN_VALUE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OMIT_METHOD_RETURN_VALUE);
  }



  /** Build the "throwable-stack-frames" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "throwable-stack-frames");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "throwable-stack-frames"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("0");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(0);
      PD_THROWABLE_STACK_FRAMES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_THROWABLE_STACK_FRAMES);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Debug Target configuration definition singleton.
   *
   * @return Returns the Debug Target configuration definition
   *         singleton.
   */
  public static DebugTargetCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private DebugTargetCfgDefn() {
    super("debug-target", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public DebugTargetCfgClient createClientConfiguration(
      ManagedObject<? extends DebugTargetCfgClient> impl) {
    return new DebugTargetCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public DebugTargetCfg createServerConfiguration(
      ServerManagedObject<? extends DebugTargetCfg> impl) {
    return new DebugTargetCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<DebugTargetCfg> getServerConfigurationClass() {
    return DebugTargetCfg.class;
  }



  /**
   * Get the "debug-exceptions-only" property definition.
   * <p>
   * Indicates whether only logs with exception should be logged.
   *
   * @return Returns the "debug-exceptions-only" property definition.
   */
  public BooleanPropertyDefinition getDebugExceptionsOnlyPropertyDefinition() {
    return PD_DEBUG_EXCEPTIONS_ONLY;
  }



  /**
   * Get the "debug-scope" property definition.
   * <p>
   * Specifies the fully-qualified OpenDJ Java package, class, or
   * method affected by the settings in this target definition. Use the
   * number character (#) to separate the class name and the method
   * name (that is, org.opends.server.core.DirectoryServer#startUp).
   *
   * @return Returns the "debug-scope" property definition.
   */
  public StringPropertyDefinition getDebugScopePropertyDefinition() {
    return PD_DEBUG_SCOPE;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Debug Target is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
  }



  /**
   * Get the "include-throwable-cause" property definition.
   * <p>
   * Specifies the property to indicate whether to include the cause
   * of exceptions in exception thrown and caught messages.
   *
   * @return Returns the "include-throwable-cause" property definition.
   */
  public BooleanPropertyDefinition getIncludeThrowableCausePropertyDefinition() {
    return PD_INCLUDE_THROWABLE_CAUSE;
  }



  /**
   * Get the "omit-method-entry-arguments" property definition.
   * <p>
   * Specifies the property to indicate whether to include method
   * arguments in debug messages.
   *
   * @return Returns the "omit-method-entry-arguments" property definition.
   */
  public BooleanPropertyDefinition getOmitMethodEntryArgumentsPropertyDefinition() {
    return PD_OMIT_METHOD_ENTRY_ARGUMENTS;
  }



  /**
   * Get the "omit-method-return-value" property definition.
   * <p>
   * Specifies the property to indicate whether to include the return
   * value in debug messages.
   *
   * @return Returns the "omit-method-return-value" property definition.
   */
  public BooleanPropertyDefinition getOmitMethodReturnValuePropertyDefinition() {
    return PD_OMIT_METHOD_RETURN_VALUE;
  }



  /**
   * Get the "throwable-stack-frames" property definition.
   * <p>
   * Specifies the property to indicate the number of stack frames to
   * include in the stack trace for method entry and exception thrown
   * messages.
   *
   * @return Returns the "throwable-stack-frames" property definition.
   */
  public IntegerPropertyDefinition getThrowableStackFramesPropertyDefinition() {
    return PD_THROWABLE_STACK_FRAMES;
  }



  /**
   * Managed object client implementation.
   */
  private static class DebugTargetCfgClientImpl implements
    DebugTargetCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends DebugTargetCfgClient> impl;



    /** Private constructor. */
    private DebugTargetCfgClientImpl(
        ManagedObject<? extends DebugTargetCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public boolean isDebugExceptionsOnly() {
      return impl.getPropertyValue(INSTANCE.getDebugExceptionsOnlyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDebugExceptionsOnly(Boolean value) {
      impl.setPropertyValue(INSTANCE.getDebugExceptionsOnlyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getDebugScope() {
      return impl.getPropertyValue(INSTANCE.getDebugScopePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDebugScope(String value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getDebugScopePropertyDefinition(), value);
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
    public boolean isIncludeThrowableCause() {
      return impl.getPropertyValue(INSTANCE.getIncludeThrowableCausePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIncludeThrowableCause(Boolean value) {
      impl.setPropertyValue(INSTANCE.getIncludeThrowableCausePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isOmitMethodEntryArguments() {
      return impl.getPropertyValue(INSTANCE.getOmitMethodEntryArgumentsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOmitMethodEntryArguments(Boolean value) {
      impl.setPropertyValue(INSTANCE.getOmitMethodEntryArgumentsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isOmitMethodReturnValue() {
      return impl.getPropertyValue(INSTANCE.getOmitMethodReturnValuePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOmitMethodReturnValue(Boolean value) {
      impl.setPropertyValue(INSTANCE.getOmitMethodReturnValuePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public int getThrowableStackFrames() {
      return impl.getPropertyValue(INSTANCE.getThrowableStackFramesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setThrowableStackFrames(Integer value) {
      impl.setPropertyValue(INSTANCE.getThrowableStackFramesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends DebugTargetCfgClient, ? extends DebugTargetCfg> definition() {
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
  private static class DebugTargetCfgServerImpl implements
    DebugTargetCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends DebugTargetCfg> impl;

    /** The value of the "debug-exceptions-only" property. */
    private final boolean pDebugExceptionsOnly;

    /** The value of the "debug-scope" property. */
    private final String pDebugScope;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "include-throwable-cause" property. */
    private final boolean pIncludeThrowableCause;

    /** The value of the "omit-method-entry-arguments" property. */
    private final boolean pOmitMethodEntryArguments;

    /** The value of the "omit-method-return-value" property. */
    private final boolean pOmitMethodReturnValue;

    /** The value of the "throwable-stack-frames" property. */
    private final int pThrowableStackFrames;



    /** Private constructor. */
    private DebugTargetCfgServerImpl(ServerManagedObject<? extends DebugTargetCfg> impl) {
      this.impl = impl;
      this.pDebugExceptionsOnly = impl.getPropertyValue(INSTANCE.getDebugExceptionsOnlyPropertyDefinition());
      this.pDebugScope = impl.getPropertyValue(INSTANCE.getDebugScopePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pIncludeThrowableCause = impl.getPropertyValue(INSTANCE.getIncludeThrowableCausePropertyDefinition());
      this.pOmitMethodEntryArguments = impl.getPropertyValue(INSTANCE.getOmitMethodEntryArgumentsPropertyDefinition());
      this.pOmitMethodReturnValue = impl.getPropertyValue(INSTANCE.getOmitMethodReturnValuePropertyDefinition());
      this.pThrowableStackFrames = impl.getPropertyValue(INSTANCE.getThrowableStackFramesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<DebugTargetCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<DebugTargetCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isDebugExceptionsOnly() {
      return pDebugExceptionsOnly;
    }



    /** {@inheritDoc} */
    public String getDebugScope() {
      return pDebugScope;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isIncludeThrowableCause() {
      return pIncludeThrowableCause;
    }



    /** {@inheritDoc} */
    public boolean isOmitMethodEntryArguments() {
      return pOmitMethodEntryArguments;
    }



    /** {@inheritDoc} */
    public boolean isOmitMethodReturnValue() {
      return pOmitMethodReturnValue;
    }



    /** {@inheritDoc} */
    public int getThrowableStackFrames() {
      return pThrowableStackFrames;
    }



    /** {@inheritDoc} */
    public Class<? extends DebugTargetCfg> configurationClass() {
      return DebugTargetCfg.class;
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
