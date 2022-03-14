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
import org.forgerock.opendj.config.IntegerPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.FileCountLogRetentionPolicyCfgClient;
import org.forgerock.opendj.server.config.server.FileCountLogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;



/**
 * An interface for querying the File Count Log Retention Policy
 * managed object definition meta information.
 * <p>
 * Retention policy based on the number of rotated log files on disk.
 */
public final class FileCountLogRetentionPolicyCfgDefn extends ManagedObjectDefinition<FileCountLogRetentionPolicyCfgClient, FileCountLogRetentionPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final FileCountLogRetentionPolicyCfgDefn INSTANCE = new FileCountLogRetentionPolicyCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "number-of-files" property definition. */
  private static final IntegerPropertyDefinition PD_NUMBER_OF_FILES;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.loggers.FileNumberRetentionPolicy");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.loggers.RetentionPolicy");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "number-of-files" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "number-of-files");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "number-of-files"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setLowerLimit(1);
      PD_NUMBER_OF_FILES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NUMBER_OF_FILES);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("logging"));
  }



  /**
   * Get the File Count Log Retention Policy configuration definition
   * singleton.
   *
   * @return Returns the File Count Log Retention Policy configuration
   *         definition singleton.
   */
  public static FileCountLogRetentionPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FileCountLogRetentionPolicyCfgDefn() {
    super("file-count-log-retention-policy", LogRetentionPolicyCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FileCountLogRetentionPolicyCfgClient createClientConfiguration(
      ManagedObject<? extends FileCountLogRetentionPolicyCfgClient> impl) {
    return new FileCountLogRetentionPolicyCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FileCountLogRetentionPolicyCfg createServerConfiguration(
      ServerManagedObject<? extends FileCountLogRetentionPolicyCfg> impl) {
    return new FileCountLogRetentionPolicyCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FileCountLogRetentionPolicyCfg> getServerConfigurationClass() {
    return FileCountLogRetentionPolicyCfg.class;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the File Count Log Retention Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "number-of-files" property definition.
   * <p>
   * Specifies the number of archived log files to retain before the
   * oldest ones are cleaned.
   *
   * @return Returns the "number-of-files" property definition.
   */
  public IntegerPropertyDefinition getNumberOfFilesPropertyDefinition() {
    return PD_NUMBER_OF_FILES;
  }



  /**
   * Managed object client implementation.
   */
  private static class FileCountLogRetentionPolicyCfgClientImpl implements
    FileCountLogRetentionPolicyCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FileCountLogRetentionPolicyCfgClient> impl;



    /** Private constructor. */
    private FileCountLogRetentionPolicyCfgClientImpl(
        ManagedObject<? extends FileCountLogRetentionPolicyCfgClient> impl) {
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
    public Integer getNumberOfFiles() {
      return impl.getPropertyValue(INSTANCE.getNumberOfFilesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setNumberOfFiles(int value) {
      impl.setPropertyValue(INSTANCE.getNumberOfFilesPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends FileCountLogRetentionPolicyCfgClient, ? extends FileCountLogRetentionPolicyCfg> definition() {
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
  private static class FileCountLogRetentionPolicyCfgServerImpl implements
    FileCountLogRetentionPolicyCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FileCountLogRetentionPolicyCfg> impl;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "number-of-files" property. */
    private final int pNumberOfFiles;



    /** Private constructor. */
    private FileCountLogRetentionPolicyCfgServerImpl(ServerManagedObject<? extends FileCountLogRetentionPolicyCfg> impl) {
      this.impl = impl;
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pNumberOfFiles = impl.getPropertyValue(INSTANCE.getNumberOfFilesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFileCountChangeListener(
        ConfigurationChangeListener<FileCountLogRetentionPolicyCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFileCountChangeListener(
        ConfigurationChangeListener<FileCountLogRetentionPolicyCfg> listener) {
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
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public int getNumberOfFiles() {
      return pNumberOfFiles;
    }



    /** {@inheritDoc} */
    public Class<? extends FileCountLogRetentionPolicyCfg> configurationClass() {
      return FileCountLogRetentionPolicyCfg.class;
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
