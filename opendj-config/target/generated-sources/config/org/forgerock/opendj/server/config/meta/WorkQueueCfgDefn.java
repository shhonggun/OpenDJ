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
import org.forgerock.opendj.server.config.client.WorkQueueCfgClient;
import org.forgerock.opendj.server.config.server.WorkQueueCfg;



/**
 * An interface for querying the Work Queue managed object definition
 * meta information.
 * <p>
 * The Work Queue provides the configuration for the server work queue
 * and is responsible for ensuring that requests received from clients
 * are processed in a timely manner.
 */
public final class WorkQueueCfgDefn extends ManagedObjectDefinition<WorkQueueCfgClient, WorkQueueCfg> {

  /** The singleton configuration definition instance. */
  private static final WorkQueueCfgDefn INSTANCE = new WorkQueueCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.WorkQueue");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Work Queue configuration definition singleton.
   *
   * @return Returns the Work Queue configuration definition
   *         singleton.
   */
  public static WorkQueueCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private WorkQueueCfgDefn() {
    super("work-queue", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public WorkQueueCfgClient createClientConfiguration(
      ManagedObject<? extends WorkQueueCfgClient> impl) {
    return new WorkQueueCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public WorkQueueCfg createServerConfiguration(
      ServerManagedObject<? extends WorkQueueCfg> impl) {
    return new WorkQueueCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<WorkQueueCfg> getServerConfigurationClass() {
    return WorkQueueCfg.class;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Work Queue implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class WorkQueueCfgClientImpl implements
    WorkQueueCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends WorkQueueCfgClient> impl;



    /** Private constructor. */
    private WorkQueueCfgClientImpl(
        ManagedObject<? extends WorkQueueCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends WorkQueueCfgClient, ? extends WorkQueueCfg> definition() {
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
  private static class WorkQueueCfgServerImpl implements
    WorkQueueCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends WorkQueueCfg> impl;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private WorkQueueCfgServerImpl(ServerManagedObject<? extends WorkQueueCfg> impl) {
      this.impl = impl;
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<WorkQueueCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<WorkQueueCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public Class<? extends WorkQueueCfg> configurationClass() {
      return WorkQueueCfg.class;
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
