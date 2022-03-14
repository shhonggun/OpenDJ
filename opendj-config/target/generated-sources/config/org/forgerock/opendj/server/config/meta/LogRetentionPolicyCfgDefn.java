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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.LogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;



/**
 * An interface for querying the Log Retention Policy managed object
 * definition meta information.
 * <p>
 * Log Retention Policies are used to specify when log files should be
 * cleaned.
 */
public final class LogRetentionPolicyCfgDefn extends ManagedObjectDefinition<LogRetentionPolicyCfgClient, LogRetentionPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final LogRetentionPolicyCfgDefn INSTANCE = new LogRetentionPolicyCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.loggers.RetentionPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Log Retention Policy configuration definition singleton.
   *
   * @return Returns the Log Retention Policy configuration definition
   *         singleton.
   */
  public static LogRetentionPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private LogRetentionPolicyCfgDefn() {
    super("log-retention-policy", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public LogRetentionPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends LogRetentionPolicyCfgClient> impl) {
    return new LogRetentionPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public LogRetentionPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends LogRetentionPolicyCfg> impl) {
    return new LogRetentionPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<LogRetentionPolicyCfg> getServerConfigurationClass() {
    return LogRetentionPolicyCfg.class;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Log Retention Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class LogRetentionPolicyCfgClientImpl implements
    LogRetentionPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends LogRetentionPolicyCfgClient> impl;



    /** Private constructor. */
    private LogRetentionPolicyCfgClientImpl(
        ManagedObject<? extends LogRetentionPolicyCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends LogRetentionPolicyCfgClient, ? extends LogRetentionPolicyCfg> definition() {
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
  private static class LogRetentionPolicyCfgServerImpl implements
    LogRetentionPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends LogRetentionPolicyCfg> impl;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private LogRetentionPolicyCfgServerImpl(ServerManagedObject<? extends LogRetentionPolicyCfg> impl) {
      this.impl = impl;
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<LogRetentionPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<LogRetentionPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends LogRetentionPolicyCfg> configurationClass() {
      return LogRetentionPolicyCfg.class;
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
