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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.HTTPAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.HTTPEndpointCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPEndpointCfg;



/**
 * An interface for querying the HTTP Endpoint managed object
 * definition meta information.
 * <p>
 * The HTTP Endpoint is used to define HTTP endpoint.
 */
public final class HTTPEndpointCfgDefn extends ManagedObjectDefinition<HTTPEndpointCfgClient, HTTPEndpointCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPEndpointCfgDefn INSTANCE = new HTTPEndpointCfgDefn();



  /** The "authorization-mechanism" property definition. */
  private static final AggregationPropertyDefinition<HTTPAuthorizationMechanismCfgClient, HTTPAuthorizationMechanismCfg> PD_AUTHORIZATION_MECHANISM;



  /** The "base-path" property definition. */
  private static final StringPropertyDefinition PD_BASE_PATH;



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "authorization-mechanism" property definition. */
  static {
      AggregationPropertyDefinition.Builder<HTTPAuthorizationMechanismCfgClient, HTTPAuthorizationMechanismCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "authorization-mechanism");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "authorization-mechanism"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("http-authorization-mechanism");
      builder.setTargetNeedsEnablingCondition(Conditions.contains("enabled", "true"));
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_AUTHORIZATION_MECHANISM = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_AUTHORIZATION_MECHANISM);
      INSTANCE.registerConstraint(PD_AUTHORIZATION_MECHANISM.getSourceConstraint());
  }



  /** Build the "base-path" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "base-path");
      builder.setOption(PropertyOption.READ_ONLY);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "base-path"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_BASE_PATH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BASE_PATH);
  }



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.HttpEndpoint");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the HTTP Endpoint configuration definition singleton.
   *
   * @return Returns the HTTP Endpoint configuration definition
   *         singleton.
   */
  public static HTTPEndpointCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPEndpointCfgDefn() {
    super("http-endpoint", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPEndpointCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPEndpointCfgClient> impl) {
    return new HTTPEndpointCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPEndpointCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPEndpointCfg> impl) {
    return new HTTPEndpointCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPEndpointCfg> getServerConfigurationClass() {
    return HTTPEndpointCfg.class;
  }



  /**
   * Get the "authorization-mechanism" property definition.
   * <p>
   * The HTTP authorization mechanisms supported by this HTTP
   * Endpoint.
   *
   * @return Returns the "authorization-mechanism" property definition.
   */
  public AggregationPropertyDefinition<HTTPAuthorizationMechanismCfgClient, HTTPAuthorizationMechanismCfg> getAuthorizationMechanismPropertyDefinition() {
    return PD_AUTHORIZATION_MECHANISM;
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
    return PD_BASE_PATH;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Endpoint is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Endpoint implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class HTTPEndpointCfgClientImpl implements
    HTTPEndpointCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPEndpointCfgClient> impl;



    /** Private constructor. */
    private HTTPEndpointCfgClientImpl(
        ManagedObject<? extends HTTPEndpointCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends HTTPEndpointCfgClient, ? extends HTTPEndpointCfg> definition() {
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
  private static class HTTPEndpointCfgServerImpl implements
    HTTPEndpointCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPEndpointCfg> impl;

    /** The value of the "authorization-mechanism" property. */
    private final SortedSet<String> pAuthorizationMechanism;

    /** The value of the "base-path" property. */
    private final String pBasePath;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private HTTPEndpointCfgServerImpl(ServerManagedObject<? extends HTTPEndpointCfg> impl) {
      this.impl = impl;
      this.pAuthorizationMechanism = impl.getPropertyValues(INSTANCE.getAuthorizationMechanismPropertyDefinition());
      this.pBasePath = impl.getPropertyValue(INSTANCE.getBasePathPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
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
    public Class<? extends HTTPEndpointCfg> configurationClass() {
      return HTTPEndpointCfg.class;
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
