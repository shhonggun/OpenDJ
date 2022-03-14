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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.SizePropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.FreeDiskSpaceLogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.server.FreeDiskSpaceLogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;



/**
 * An interface for querying the Free Disk Space Log Retention Policy
 * managed object definition meta information.
 * <p>
 * Retention policy based on the free disk space available.
 */
public final class FreeDiskSpaceLogRetentionPolicyCfgDefn extends ManagedObjectDefinition<FreeDiskSpaceLogRetentionPolicyCfgClient, FreeDiskSpaceLogRetentionPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final FreeDiskSpaceLogRetentionPolicyCfgDefn INSTANCE = new FreeDiskSpaceLogRetentionPolicyCfgDefn();



  /** The "free-disk-space" property definition. */
  private static final SizePropertyDefinition PD_FREE_DISK_SPACE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "free-disk-space" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "free-disk-space");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "free-disk-space"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setLowerLimit("1");
      PD_FREE_DISK_SPACE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_FREE_DISK_SPACE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.FreeDiskSpaceRetentionPolicy");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.RetentionPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Free Disk Space Log Retention Policy configuration
   * definition singleton.
   *
   * @return Returns the Free Disk Space Log Retention Policy
   *         configuration definition singleton.
   */
  public static FreeDiskSpaceLogRetentionPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FreeDiskSpaceLogRetentionPolicyCfgDefn() {
    super("free-disk-space-log-retention-policy", LogRetentionPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FreeDiskSpaceLogRetentionPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfgClient> impl) {
    return new FreeDiskSpaceLogRetentionPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FreeDiskSpaceLogRetentionPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfg> impl) {
    return new FreeDiskSpaceLogRetentionPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FreeDiskSpaceLogRetentionPolicyCfg> getServerConfigurationClass() {
    return FreeDiskSpaceLogRetentionPolicyCfg.class;
  }



  /**
   * Get the "free-disk-space" property definition.
   * <p>
   * Specifies the minimum amount of free disk space that should be
   * available on the file system on which the archived log files are
   * stored.
   *
   * @return Returns the "free-disk-space" property definition.
   */
  public SizePropertyDefinition getFreeDiskSpacePropertyDefinition() {
    return PD_FREE_DISK_SPACE;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Free Disk Space Log Retention Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class FreeDiskSpaceLogRetentionPolicyCfgClientImpl implements
    FreeDiskSpaceLogRetentionPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfgClient> impl;



    /** Private constructor. */
    private FreeDiskSpaceLogRetentionPolicyCfgClientImpl(
        ManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Long getFreeDiskSpace() {
      return impl.getPropertyValue(INSTANCE.getFreeDiskSpacePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFreeDiskSpace(long value) {
      impl.setPropertyValue(INSTANCE.getFreeDiskSpacePropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends FreeDiskSpaceLogRetentionPolicyCfgClient, ? extends FreeDiskSpaceLogRetentionPolicyCfg> definition() {
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
  private static class FreeDiskSpaceLogRetentionPolicyCfgServerImpl implements
    FreeDiskSpaceLogRetentionPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfg> impl;

    /** The value of the "free-disk-space" property. */
    private final long pFreeDiskSpace;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private FreeDiskSpaceLogRetentionPolicyCfgServerImpl(ServerManagedObject<? extends FreeDiskSpaceLogRetentionPolicyCfg> impl) {
      this.impl = impl;
      this.pFreeDiskSpace = impl.getPropertyValue(INSTANCE.getFreeDiskSpacePropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFreeDiskSpaceChangeListener(
        ConfigurationChangeListener<FreeDiskSpaceLogRetentionPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFreeDiskSpaceChangeListener(
        ConfigurationChangeListener<FreeDiskSpaceLogRetentionPolicyCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public long getFreeDiskSpace() {
      return pFreeDiskSpace;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends FreeDiskSpaceLogRetentionPolicyCfg> configurationClass() {
      return FreeDiskSpaceLogRetentionPolicyCfg.class;
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
