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
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.GetConnectionIdExtendedOperationHandlerCfgClient;
import org.forgerock.opendj.server.config.server.ExtendedOperationHandlerCfg;
import org.forgerock.opendj.server.config.server.GetConnectionIdExtendedOperationHandlerCfg;



/**
 * An interface for querying the Get Connection Id Extended Operation
 * Handler managed object definition meta information.
 * <p>
 * The Get Connection Id Extended Operation Handler provides a
 * mechanism for clients to obtain the internal connection ID that the
 * server uses to reference their client connection.
 */
public final class GetConnectionIdExtendedOperationHandlerCfgDefn extends ManagedObjectDefinition<GetConnectionIdExtendedOperationHandlerCfgClient, GetConnectionIdExtendedOperationHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final GetConnectionIdExtendedOperationHandlerCfgDefn INSTANCE = new GetConnectionIdExtendedOperationHandlerCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.GetConnectionIDExtendedOperation");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.ExtendedOperationHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Get Connection Id Extended Operation Handler
   * configuration definition singleton.
   *
   * @return Returns the Get Connection Id Extended Operation Handler
   *         configuration definition singleton.
   */
  public static GetConnectionIdExtendedOperationHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private GetConnectionIdExtendedOperationHandlerCfgDefn() {
    super("get-connection-id-extended-operation-handler", ExtendedOperationHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public GetConnectionIdExtendedOperationHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfgClient> impl) {
    return new GetConnectionIdExtendedOperationHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public GetConnectionIdExtendedOperationHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfg> impl) {
    return new GetConnectionIdExtendedOperationHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<GetConnectionIdExtendedOperationHandlerCfg> getServerConfigurationClass() {
    return GetConnectionIdExtendedOperationHandlerCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Get Connection Id Extended Operation
   * Handler is enabled (that is, whether the types of extended
   * operations are allowed in the server).
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return ExtendedOperationHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Get Connection Id Extended Operation Handler
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class GetConnectionIdExtendedOperationHandlerCfgClientImpl implements
    GetConnectionIdExtendedOperationHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfgClient> impl;



    /** Private constructor. */
    private GetConnectionIdExtendedOperationHandlerCfgClientImpl(
        ManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfgClient> impl) {
      this.impl = impl;
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
    public ManagedObjectDefinition<? extends GetConnectionIdExtendedOperationHandlerCfgClient, ? extends GetConnectionIdExtendedOperationHandlerCfg> definition() {
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
  private static class GetConnectionIdExtendedOperationHandlerCfgServerImpl implements
    GetConnectionIdExtendedOperationHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private GetConnectionIdExtendedOperationHandlerCfgServerImpl(ServerManagedObject<? extends GetConnectionIdExtendedOperationHandlerCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addGetConnectionIdChangeListener(
        ConfigurationChangeListener<GetConnectionIdExtendedOperationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeGetConnectionIdChangeListener(
        ConfigurationChangeListener<GetConnectionIdExtendedOperationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ExtendedOperationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ExtendedOperationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public Class<? extends GetConnectionIdExtendedOperationHandlerCfg> configurationClass() {
      return GetConnectionIdExtendedOperationHandlerCfg.class;
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
