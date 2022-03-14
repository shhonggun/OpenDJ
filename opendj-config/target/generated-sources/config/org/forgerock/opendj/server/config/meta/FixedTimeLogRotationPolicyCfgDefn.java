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
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
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
import org.forgerock.opendj.server.config.client.FixedTimeLogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.FixedTimeLogRotationPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;



/**
 * An interface for querying the Fixed Time Log Rotation Policy
 * managed object definition meta information.
 * <p>
 * Rotation policy based on a fixed time of day.
 */
public final class FixedTimeLogRotationPolicyCfgDefn extends ManagedObjectDefinition<FixedTimeLogRotationPolicyCfgClient, FixedTimeLogRotationPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final FixedTimeLogRotationPolicyCfgDefn INSTANCE = new FixedTimeLogRotationPolicyCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "time-of-day" property definition. */
  private static final StringPropertyDefinition PD_TIME_OF_DAY;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.FixedTimeRotationPolicy");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.RotationPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "time-of-day" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "time-of-day");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "time-of-day"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern("^(([0-1][0-9])|([2][0-3]))([0-5][0-9])$", "HHmm");
      PD_TIME_OF_DAY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TIME_OF_DAY);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Fixed Time Log Rotation Policy configuration definition
   * singleton.
   *
   * @return Returns the Fixed Time Log Rotation Policy configuration
   *         definition singleton.
   */
  public static FixedTimeLogRotationPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FixedTimeLogRotationPolicyCfgDefn() {
    super("fixed-time-log-rotation-policy", LogRotationPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FixedTimeLogRotationPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends FixedTimeLogRotationPolicyCfgClient> impl) {
    return new FixedTimeLogRotationPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FixedTimeLogRotationPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends FixedTimeLogRotationPolicyCfg> impl) {
    return new FixedTimeLogRotationPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FixedTimeLogRotationPolicyCfg> getServerConfigurationClass() {
    return FixedTimeLogRotationPolicyCfg.class;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Fixed Time Log Rotation Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "time-of-day" property definition.
   * <p>
   * Specifies the time of day at which log rotation should occur.
   *
   * @return Returns the "time-of-day" property definition.
   */
  public StringPropertyDefinition getTimeOfDayPropertyDefinition() {
    return PD_TIME_OF_DAY;
  }



  /**
   * Managed object client implementation.
   */
  private static class FixedTimeLogRotationPolicyCfgClientImpl implements
    FixedTimeLogRotationPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FixedTimeLogRotationPolicyCfgClient> impl;



    /** Private constructor. */
    private FixedTimeLogRotationPolicyCfgClientImpl(
        ManagedObject<? extends FixedTimeLogRotationPolicyCfgClient> impl) {
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
    public SortedSet<String> getTimeOfDay() {
      return impl.getPropertyValues(INSTANCE.getTimeOfDayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTimeOfDay(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getTimeOfDayPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends FixedTimeLogRotationPolicyCfgClient, ? extends FixedTimeLogRotationPolicyCfg> definition() {
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
  private static class FixedTimeLogRotationPolicyCfgServerImpl implements
    FixedTimeLogRotationPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FixedTimeLogRotationPolicyCfg> impl;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "time-of-day" property. */
    private final SortedSet<String> pTimeOfDay;



    /** Private constructor. */
    private FixedTimeLogRotationPolicyCfgServerImpl(ServerManagedObject<? extends FixedTimeLogRotationPolicyCfg> impl) {
      this.impl = impl;
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pTimeOfDay = impl.getPropertyValues(INSTANCE.getTimeOfDayPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFixedTimeChangeListener(
        ConfigurationChangeListener<FixedTimeLogRotationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFixedTimeChangeListener(
        ConfigurationChangeListener<FixedTimeLogRotationPolicyCfg> listener) {
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
    public SortedSet<String> getTimeOfDay() {
      return pTimeOfDay;
    }



    /** {@inheritDoc} */
    public Class<? extends FixedTimeLogRotationPolicyCfg> configurationClass() {
      return FixedTimeLogRotationPolicyCfg.class;
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
