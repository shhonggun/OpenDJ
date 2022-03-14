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
import org.forgerock.opendj.server.config.client.SizeLimitLogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.SizeLimitLogRetentionPolicyCfg;



/**
 * An interface for querying the Size Limit Log Retention Policy
 * managed object definition meta information.
 * <p>
 * Retention policy based on the amount of space taken by all the log
 * files on disk.
 */
public final class SizeLimitLogRetentionPolicyCfgDefn extends ManagedObjectDefinition<SizeLimitLogRetentionPolicyCfgClient, SizeLimitLogRetentionPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final SizeLimitLogRetentionPolicyCfgDefn INSTANCE = new SizeLimitLogRetentionPolicyCfgDefn();



  /** The "disk-space-used" property definition. */
  private static final SizePropertyDefinition PD_DISK_SPACE_USED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "disk-space-used" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "disk-space-used");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "disk-space-used"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setLowerLimit("1");
      PD_DISK_SPACE_USED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_DISK_SPACE_USED);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.SizeBasedRetentionPolicy");
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
   * Get the Size Limit Log Retention Policy configuration definition
   * singleton.
   *
   * @return Returns the Size Limit Log Retention Policy configuration
   *         definition singleton.
   */
  public static SizeLimitLogRetentionPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SizeLimitLogRetentionPolicyCfgDefn() {
    super("size-limit-log-retention-policy", LogRetentionPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SizeLimitLogRetentionPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends SizeLimitLogRetentionPolicyCfgClient> impl) {
    return new SizeLimitLogRetentionPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SizeLimitLogRetentionPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends SizeLimitLogRetentionPolicyCfg> impl) {
    return new SizeLimitLogRetentionPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SizeLimitLogRetentionPolicyCfg> getServerConfigurationClass() {
    return SizeLimitLogRetentionPolicyCfg.class;
  }



  /**
   * Get the "disk-space-used" property definition.
   * <p>
   * Specifies the maximum total disk space used by the log files.
   *
   * @return Returns the "disk-space-used" property definition.
   */
  public SizePropertyDefinition getDiskSpaceUsedPropertyDefinition() {
    return PD_DISK_SPACE_USED;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Size Limit Log Retention Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SizeLimitLogRetentionPolicyCfgClientImpl implements
    SizeLimitLogRetentionPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SizeLimitLogRetentionPolicyCfgClient> impl;



    /** Private constructor. */
    private SizeLimitLogRetentionPolicyCfgClientImpl(
        ManagedObject<? extends SizeLimitLogRetentionPolicyCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Long getDiskSpaceUsed() {
      return impl.getPropertyValue(INSTANCE.getDiskSpaceUsedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDiskSpaceUsed(long value) {
      impl.setPropertyValue(INSTANCE.getDiskSpaceUsedPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends SizeLimitLogRetentionPolicyCfgClient, ? extends SizeLimitLogRetentionPolicyCfg> definition() {
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
  private static class SizeLimitLogRetentionPolicyCfgServerImpl implements
    SizeLimitLogRetentionPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SizeLimitLogRetentionPolicyCfg> impl;

    /** The value of the "disk-space-used" property. */
    private final long pDiskSpaceUsed;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private SizeLimitLogRetentionPolicyCfgServerImpl(ServerManagedObject<? extends SizeLimitLogRetentionPolicyCfg> impl) {
      this.impl = impl;
      this.pDiskSpaceUsed = impl.getPropertyValue(INSTANCE.getDiskSpaceUsedPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSizeLimitChangeListener(
        ConfigurationChangeListener<SizeLimitLogRetentionPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSizeLimitChangeListener(
        ConfigurationChangeListener<SizeLimitLogRetentionPolicyCfg> listener) {
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
    public long getDiskSpaceUsed() {
      return pDiskSpaceUsed;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends SizeLimitLogRetentionPolicyCfg> configurationClass() {
      return SizeLimitLogRetentionPolicyCfg.class;
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
