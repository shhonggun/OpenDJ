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
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.HTTPAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.Rest2ldapEndpointCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPEndpointCfg;
import org.forgerock.opendj.server.config.server.Rest2ldapEndpointCfg;



/**
 * An interface for querying the Rest2ldap Endpoint managed object
 * definition meta information.
 * <p>
 * The Rest2ldap Endpoint provides RESTful access to LDAP application
 * data using a set of customizable data transformations.
 */
public final class Rest2ldapEndpointCfgDefn extends ManagedObjectDefinition<Rest2ldapEndpointCfgClient, Rest2ldapEndpointCfg> {

  /** The singleton configuration definition instance. */
  private static final Rest2ldapEndpointCfgDefn INSTANCE = new Rest2ldapEndpointCfgDefn();



  /** The "config-directory" property definition. */
  private static final StringPropertyDefinition PD_CONFIG_DIRECTORY;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "config-directory" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "config-directory");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "config-directory"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "DIRECTORY");
      PD_CONFIG_DIRECTORY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONFIG_DIRECTORY);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.rest2ldap.Rest2LdapEndpoint");
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
   * Get the Rest2ldap Endpoint configuration definition singleton.
   *
   * @return Returns the Rest2ldap Endpoint configuration definition
   *         singleton.
   */
  public static Rest2ldapEndpointCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private Rest2ldapEndpointCfgDefn() {
    super("rest2ldap-endpoint", HTTPEndpointCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public Rest2ldapEndpointCfgClient createClientConfiguration(
      ManagedObject<? extends Rest2ldapEndpointCfgClient> impl) {
    return new Rest2ldapEndpointCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public Rest2ldapEndpointCfg createServerConfiguration(
      ServerManagedObject<? extends Rest2ldapEndpointCfg> impl) {
    return new Rest2ldapEndpointCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<Rest2ldapEndpointCfg> getServerConfigurationClass() {
    return Rest2ldapEndpointCfg.class;
  }



  /**
   * Get the "authorization-mechanism" property definition.
   * <p>
   * The HTTP authorization mechanisms supported by this Rest2ldap
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
   * Get the "config-directory" property definition.
   * <p>
   * The directory containing the Rest2Ldap configuration file(s) for
   * this specific endpoint.
   * <p>
   * The directory must be readable by the server and may contain
   * multiple configuration files, one for each supported version of
   * the REST endpoint. If a relative path is used then it will be
   * resolved against the server's instance directory.
   *
   * @return Returns the "config-directory" property definition.
   */
  public StringPropertyDefinition getConfigDirectoryPropertyDefinition() {
    return PD_CONFIG_DIRECTORY;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Rest2ldap Endpoint is enabled.
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
   * provides the Rest2ldap Endpoint implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class Rest2ldapEndpointCfgClientImpl implements
    Rest2ldapEndpointCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends Rest2ldapEndpointCfgClient> impl;



    /** Private constructor. */
    private Rest2ldapEndpointCfgClientImpl(
        ManagedObject<? extends Rest2ldapEndpointCfgClient> impl) {
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
    public String getConfigDirectory() {
      return impl.getPropertyValue(INSTANCE.getConfigDirectoryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConfigDirectory(String value) {
      impl.setPropertyValue(INSTANCE.getConfigDirectoryPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends Rest2ldapEndpointCfgClient, ? extends Rest2ldapEndpointCfg> definition() {
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
  private static class Rest2ldapEndpointCfgServerImpl implements
    Rest2ldapEndpointCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends Rest2ldapEndpointCfg> impl;

    /** The value of the "authorization-mechanism" property. */
    private final SortedSet<String> pAuthorizationMechanism;

    /** The value of the "base-path" property. */
    private final String pBasePath;

    /** The value of the "config-directory" property. */
    private final String pConfigDirectory;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private Rest2ldapEndpointCfgServerImpl(ServerManagedObject<? extends Rest2ldapEndpointCfg> impl) {
      this.impl = impl;
      this.pAuthorizationMechanism = impl.getPropertyValues(INSTANCE.getAuthorizationMechanismPropertyDefinition());
      this.pBasePath = impl.getPropertyValue(INSTANCE.getBasePathPropertyDefinition());
      this.pConfigDirectory = impl.getPropertyValue(INSTANCE.getConfigDirectoryPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addRest2ldapEndpointChangeListener(
        ConfigurationChangeListener<Rest2ldapEndpointCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeRest2ldapEndpointChangeListener(
        ConfigurationChangeListener<Rest2ldapEndpointCfg> listener) {
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
    public String getConfigDirectory() {
      return pConfigDirectory;
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
    public Class<? extends Rest2ldapEndpointCfg> configurationClass() {
      return Rest2ldapEndpointCfg.class;
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
