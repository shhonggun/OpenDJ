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
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.TimeLimitLogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;
import org.forgerock.opendj.server.config.server.TimeLimitLogRotationPolicyCfg;



/**
 * An interface for querying the Time Limit Log Rotation Policy
 * managed object definition meta information.
 * <p>
 * Rotation policy based on the time since last rotation.
 */
public final class TimeLimitLogRotationPolicyCfgDefn extends ManagedObjectDefinition<TimeLimitLogRotationPolicyCfgClient, TimeLimitLogRotationPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final TimeLimitLogRotationPolicyCfgDefn INSTANCE = new TimeLimitLogRotationPolicyCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "rotation-interval" property definition. */
  private static final DurationPropertyDefinition PD_ROTATION_INTERVAL;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.TimeLimitRotationPolicy");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.RotationPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "rotation-interval" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "rotation-interval");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "rotation-interval"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setBaseUnit("ms");
      builder.setLowerLimit("1");
      PD_ROTATION_INTERVAL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ROTATION_INTERVAL);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Time Limit Log Rotation Policy configuration definition
   * singleton.
   *
   * @return Returns the Time Limit Log Rotation Policy configuration
   *         definition singleton.
   */
  public static TimeLimitLogRotationPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private TimeLimitLogRotationPolicyCfgDefn() {
    super("time-limit-log-rotation-policy", LogRotationPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public TimeLimitLogRotationPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends TimeLimitLogRotationPolicyCfgClient> impl) {
    return new TimeLimitLogRotationPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public TimeLimitLogRotationPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends TimeLimitLogRotationPolicyCfg> impl) {
    return new TimeLimitLogRotationPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<TimeLimitLogRotationPolicyCfg> getServerConfigurationClass() {
    return TimeLimitLogRotationPolicyCfg.class;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Time Limit Log Rotation Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "rotation-interval" property definition.
   * <p>
   * Specifies the time interval between rotations.
   *
   * @return Returns the "rotation-interval" property definition.
   */
  public DurationPropertyDefinition getRotationIntervalPropertyDefinition() {
    return PD_ROTATION_INTERVAL;
  }



  /**
   * Managed object client implementation.
   */
  private static class TimeLimitLogRotationPolicyCfgClientImpl implements
    TimeLimitLogRotationPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends TimeLimitLogRotationPolicyCfgClient> impl;



    /** Private constructor. */
    private TimeLimitLogRotationPolicyCfgClientImpl(
        ManagedObject<? extends TimeLimitLogRotationPolicyCfgClient> impl) {
      this.impl = impl;
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
    public Long getRotationInterval() {
      return impl.getPropertyValue(INSTANCE.getRotationIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRotationInterval(long value) {
      impl.setPropertyValue(INSTANCE.getRotationIntervalPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends TimeLimitLogRotationPolicyCfgClient, ? extends TimeLimitLogRotationPolicyCfg> definition() {
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
  private static class TimeLimitLogRotationPolicyCfgServerImpl implements
    TimeLimitLogRotationPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends TimeLimitLogRotationPolicyCfg> impl;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "rotation-interval" property. */
    private final long pRotationInterval;



    /** Private constructor. */
    private TimeLimitLogRotationPolicyCfgServerImpl(ServerManagedObject<? extends TimeLimitLogRotationPolicyCfg> impl) {
      this.impl = impl;
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pRotationInterval = impl.getPropertyValue(INSTANCE.getRotationIntervalPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addTimeLimitChangeListener(
        ConfigurationChangeListener<TimeLimitLogRotationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeTimeLimitChangeListener(
        ConfigurationChangeListener<TimeLimitLogRotationPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<LogRotationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<LogRotationPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public long getRotationInterval() {
      return pRotationInterval;
    }



    /** {@inheritDoc} */
    public Class<? extends TimeLimitLogRotationPolicyCfg> configurationClass() {
      return TimeLimitLogRotationPolicyCfg.class;
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
