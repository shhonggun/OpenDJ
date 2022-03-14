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
import java.util.TreeSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.AdminEndpointCfgClient;
import org.forgerock.opendj.server.config.client.HTTPAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.server.AdminEndpointCfg;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPEndpointCfg;



/**
 * An interface for querying the Admin Endpoint managed object
 * definition meta information.
 * <p>
 * The Admin Endpoint provides RESTful access to OpenDJ's monitoring
 * and configuration backends.
 */
public final class AdminEndpointCfgDefn extends ManagedObjectDefinition<AdminEndpointCfgClient, AdminEndpointCfg> {

  /** The singleton configuration definition instance. */
  private static final AdminEndpointCfgDefn INSTANCE = new AdminEndpointCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.rest2ldap.AdminEndpoint");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.HttpEndpoint");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Admin Endpoint configuration definition singleton.
   *
   * @return Returns the Admin Endpoint configuration definition
   *         singleton.
   */
  public static AdminEndpointCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private AdminEndpointCfgDefn() {
    super("admin-endpoint", HTTPEndpointCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public AdminEndpointCfgClient createClientConfiguration(
      ManagedObject<? extends AdminEndpointCfgClient> impl) {
    return new AdminEndpointCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public AdminEndpointCfg createServerConfiguration(
      ServerManagedObject<? extends AdminEndpointCfg> impl) {
    return new AdminEndpointCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<AdminEndpointCfg> getServerConfigurationClass() {
    return AdminEndpointCfg.class;
  }



  /**
   * Get the "authorization-mechanism" property definition.
   * <p>
   * The HTTP authorization mechanisms supported by this Admin
   * Endpoint.
   *
   * @return Returns the "authorization-mechanism" property definition.
   */
  public AggregationPropertyDefinition<HTTPAuthorizationMechanismCfgClient, HTTPAuthorizationMechanismCfg> getAuthorizationMechanismPropertyDefinition() {
    return HTTPEndpointCfgDefn.getInstance().getAuthorizationMechanismPropertyDefinition();
  }



  /**
   * Get the "base-path" property definition.
   * <p>
   * All HTTP requests matching the base path or subordinate to it
   * will be routed to the HTTP endpoint unless a more specific HTTP
   * endpoint is found.
   *
   * @return Returns the "base-path" property definition.
   */
  public StringPropertyDefinition getBasePathPropertyDefinition() {
    return HTTPEndpointCfgDefn.getInstance().getBasePathPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Admin Endpoint is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPEndpointCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Admin Endpoint implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class AdminEndpointCfgClientImpl implements
    AdminEndpointCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends AdminEndpointCfgClient> impl;



    /** Private constructor. */
    private AdminEndpointCfgClientImpl(
        ManagedObject<? extends AdminEndpointCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAuthorizationMechanism() {
      return impl.getPropertyValues(INSTANCE.getAuthorizationMechanismPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAuthorizationMechanism(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getAuthorizationMechanismPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getBasePath() {
      return impl.getPropertyValue(INSTANCE.getBasePathPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBasePath(String value) throws PropertyException {
      impl.setPropertyValue(INSTANCE.getBasePathPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends AdminEndpointCfgClient, ? extends AdminEndpointCfg> definition() {
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
  private static class AdminEndpointCfgServerImpl implements
    AdminEndpointCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends AdminEndpointCfg> impl;

    /** The value of the "authorization-mechanism" property. */
    private final SortedSet<String> pAuthorizationMechanism;

    /** The value of the "base-path" property. */
    private final String pBasePath;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private AdminEndpointCfgServerImpl(ServerManagedObject<? extends AdminEndpointCfg> impl) {
      this.impl = impl;
      this.pAuthorizationMechanism = impl.getPropertyValues(INSTANCE.getAuthorizationMechanismPropertyDefinition());
      this.pBasePath = impl.getPropertyValue(INSTANCE.getBasePathPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addAdminEndpointChangeListener(
        ConfigurationChangeListener<AdminEndpointCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeAdminEndpointChangeListener(
        ConfigurationChangeListener<AdminEndpointCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<HTTPEndpointCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<HTTPEndpointCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAuthorizationMechanism() {
      return pAuthorizationMechanism;
    }



    /**
     * {@inheritDoc}
     */
    public SortedSet<DN> getAuthorizationMechanismDNs() {
      SortedSet<String> values = getAuthorizationMechanism();
      SortedSet<DN> dnValues = new TreeSet<DN>();
      for (String value : values) {
        DN dn = INSTANCE.getAuthorizationMechanismPropertyDefinition().getChildDN(value);
        dnValues.add(dn);
      }
      return dnValues;
    }



    /** {@inheritDoc} */
    public String getBasePath() {
      return pBasePath;
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
    public Class<? extends AdminEndpointCfg> configurationClass() {
      return AdminEndpointCfg.class;
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
