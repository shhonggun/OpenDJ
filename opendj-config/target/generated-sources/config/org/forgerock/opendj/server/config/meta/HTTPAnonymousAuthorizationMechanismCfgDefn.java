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
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.HTTPAnonymousAuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.server.HTTPAnonymousAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;



/**
 * An interface for querying the HTTP Anonymous Authorization
 * Mechanism managed object definition meta information.
 * <p>
 * The HTTP Anonymous Authorization Mechanism is used to define static
 * authorization.
 */
public final class HTTPAnonymousAuthorizationMechanismCfgDefn extends ManagedObjectDefinition<HTTPAnonymousAuthorizationMechanismCfgClient, HTTPAnonymousAuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPAnonymousAuthorizationMechanismCfgDefn INSTANCE = new HTTPAnonymousAuthorizationMechanismCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "user-dn" property definition. */
  private static final DNPropertyDefinition PD_USER_DN;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.protocols.http.authz.HttpAnonymousAuthorizationMechanism");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.protocols.http.authz.HttpAuthorizationMechanism");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "user-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "user-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "user-dn"));
      PD_USER_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_DN);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  /**
   * Get the HTTP Anonymous Authorization Mechanism configuration
   * definition singleton.
   *
   * @return Returns the HTTP Anonymous Authorization Mechanism
   *         configuration definition singleton.
   */
  public static HTTPAnonymousAuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPAnonymousAuthorizationMechanismCfgDefn() {
    super("http-anonymous-authorization-mechanism", HTTPAuthorizationMechanismCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public HTTPAnonymousAuthorizationMechanismCfgClient createClientConfiguration(
      ManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfgClient> impl) {
    return new HTTPAnonymousAuthorizationMechanismCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public HTTPAnonymousAuthorizationMechanismCfg createServerConfiguration(
      ServerManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfg> impl) {
    return new HTTPAnonymousAuthorizationMechanismCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<HTTPAnonymousAuthorizationMechanismCfg> getServerConfigurationClass() {
    return HTTPAnonymousAuthorizationMechanismCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Anonymous Authorization Mechanism is
   * enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPAuthorizationMechanismCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Anonymous Authorization Mechanism
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "user-dn" property definition.
   * <p>
   * The authorization DN which will be used for performing anonymous
   * operations.
   *
   * @return Returns the "user-dn" property definition.
   */
  public DNPropertyDefinition getUserDNPropertyDefinition() {
    return PD_USER_DN;
  }



  /**
   * Managed object client implementation.
   */
  private static class HTTPAnonymousAuthorizationMechanismCfgClientImpl implements
    HTTPAnonymousAuthorizationMechanismCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfgClient> impl;



    /** Private constructor. */
    private HTTPAnonymousAuthorizationMechanismCfgClientImpl(
        ManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfgClient> impl) {
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
    public DN getUserDN() {
      return impl.getPropertyValue(INSTANCE.getUserDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserDN(DN value) {
      impl.setPropertyValue(INSTANCE.getUserDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends HTTPAnonymousAuthorizationMechanismCfgClient, ? extends HTTPAnonymousAuthorizationMechanismCfg> definition() {
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
  private static class HTTPAnonymousAuthorizationMechanismCfgServerImpl implements
    HTTPAnonymousAuthorizationMechanismCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "user-dn" property. */
    private final DN pUserDN;



    /** Private constructor. */
    private HTTPAnonymousAuthorizationMechanismCfgServerImpl(ServerManagedObject<? extends HTTPAnonymousAuthorizationMechanismCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pUserDN = impl.getPropertyValue(INSTANCE.getUserDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addHTTPAnonymousAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPAnonymousAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeHTTPAnonymousAuthorizationMechanismChangeListener(
        ConfigurationChangeListener<HTTPAnonymousAuthorizationMechanismCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<HTTPAuthorizationMechanismCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<HTTPAuthorizationMechanismCfg> listener) {
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
    public DN getUserDN() {
      return pUserDN;
    }



    /** {@inheritDoc} */
    public Class<? extends HTTPAnonymousAuthorizationMechanismCfg> configurationClass() {
      return HTTPAnonymousAuthorizationMechanismCfg.class;
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
