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
import org.forgerock.opendj.server.config.client.SizeLimitLogRotationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;
import org.forgerock.opendj.server.config.server.SizeLimitLogRotationPolicyCfg;



/**
 * An interface for querying the Size Limit Log Rotation Policy
 * managed object definition meta information.
 * <p>
 * Rotation policy based on the size of the log file.
 */
public final class SizeLimitLogRotationPolicyCfgDefn extends ManagedObjectDefinition<SizeLimitLogRotationPolicyCfgClient, SizeLimitLogRotationPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final SizeLimitLogRotationPolicyCfgDefn INSTANCE = new SizeLimitLogRotationPolicyCfgDefn();



  /** The "file-size-limit" property definition. */
  private static final SizePropertyDefinition PD_FILE_SIZE_LIMIT;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "file-size-limit" property definition. */
  static {
      SizePropertyDefinition.Builder builder = SizePropertyDefinition.createBuilder(INSTANCE, "file-size-limit");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "file-size-limit"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setLowerLimit("1");
      PD_FILE_SIZE_LIMIT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_FILE_SIZE_LIMIT);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.SizeBasedRotationPolicy");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.RotationPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the Size Limit Log Rotation Policy configuration definition
   * singleton.
   *
   * @return Returns the Size Limit Log Rotation Policy configuration
   *         definition singleton.
   */
  public static SizeLimitLogRotationPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SizeLimitLogRotationPolicyCfgDefn() {
    super("size-limit-log-rotation-policy", LogRotationPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SizeLimitLogRotationPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends SizeLimitLogRotationPolicyCfgClient> impl) {
    return new SizeLimitLogRotationPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SizeLimitLogRotationPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends SizeLimitLogRotationPolicyCfg> impl) {
    return new SizeLimitLogRotationPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SizeLimitLogRotationPolicyCfg> getServerConfigurationClass() {
    return SizeLimitLogRotationPolicyCfg.class;
  }



  /**
   * Get the "file-size-limit" property definition.
   * <p>
   * Specifies the maximum size that a log file can reach before it is
   * rotated.
   *
   * @return Returns the "file-size-limit" property definition.
   */
  public SizePropertyDefinition getFileSizeLimitPropertyDefinition() {
    return PD_FILE_SIZE_LIMIT;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Size Limit Log Rotation Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SizeLimitLogRotationPolicyCfgClientImpl implements
    SizeLimitLogRotationPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SizeLimitLogRotationPolicyCfgClient> impl;



    /** Private constructor. */
    private SizeLimitLogRotationPolicyCfgClientImpl(
        ManagedObject<? extends SizeLimitLogRotationPolicyCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Long getFileSizeLimit() {
      return impl.getPropertyValue(INSTANCE.getFileSizeLimitPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setFileSizeLimit(long value) {
      impl.setPropertyValue(INSTANCE.getFileSizeLimitPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends SizeLimitLogRotationPolicyCfgClient, ? extends SizeLimitLogRotationPolicyCfg> definition() {
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
  private static class SizeLimitLogRotationPolicyCfgServerImpl implements
    SizeLimitLogRotationPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SizeLimitLogRotationPolicyCfg> impl;

    /** The value of the "file-size-limit" property. */
    private final long pFileSizeLimit;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private SizeLimitLogRotationPolicyCfgServerImpl(ServerManagedObject<? extends SizeLimitLogRotationPolicyCfg> impl) {
      this.impl = impl;
      this.pFileSizeLimit = impl.getPropertyValue(INSTANCE.getFileSizeLimitPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSizeLimitChangeListener(
        ConfigurationChangeListener<SizeLimitLogRotationPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSizeLimitChangeListener(
        ConfigurationChangeListener<SizeLimitLogRotationPolicyCfg> listener) {
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
    public long getFileSizeLimit() {
      return pFileSizeLimit;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends SizeLimitLogRotationPolicyCfg> configurationClass() {
      return SizeLimitLogRotationPolicyCfg.class;
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
