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
import org.forgerock.opendj.server.config.client.TripleDESPasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.TripleDESPasswordStorageSchemeCfg;



/**
 * An interface for querying the Triple DES Password Storage Scheme
 * managed object definition meta information.
 * <p>
 * The Triple DES Password Storage Scheme provides a mechanism for
 * encoding user passwords using the triple-DES (DES/EDE) reversible
 * encryption mechanism.
 */
public final class TripleDESPasswordStorageSchemeCfgDefn extends ManagedObjectDefinition<TripleDESPasswordStorageSchemeCfgClient, TripleDESPasswordStorageSchemeCfg> {

  /** The singleton configuration definition instance. */
  private static final TripleDESPasswordStorageSchemeCfgDefn INSTANCE = new TripleDESPasswordStorageSchemeCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.TripleDESPasswordStorageScheme");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordStorageScheme");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Triple DES Password Storage Scheme configuration
   * definition singleton.
   *
   * @return Returns the Triple DES Password Storage Scheme
   *         configuration definition singleton.
   */
  public static TripleDESPasswordStorageSchemeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private TripleDESPasswordStorageSchemeCfgDefn() {
    super("triple-des-password-storage-scheme", PasswordStorageSchemeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public TripleDESPasswordStorageSchemeCfgClient createClientConfiguration(
      ManagedObject<? extends TripleDESPasswordStorageSchemeCfgClient> impl) {
    return new TripleDESPasswordStorageSchemeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public TripleDESPasswordStorageSchemeCfg createServerConfiguration(
      ServerManagedObject<? extends TripleDESPasswordStorageSchemeCfg> impl) {
    return new TripleDESPasswordStorageSchemeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<TripleDESPasswordStorageSchemeCfg> getServerConfigurationClass() {
    return TripleDESPasswordStorageSchemeCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Triple DES Password Storage Scheme is
   * enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PasswordStorageSchemeCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Triple DES Password Storage Scheme implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class TripleDESPasswordStorageSchemeCfgClientImpl implements
    TripleDESPasswordStorageSchemeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends TripleDESPasswordStorageSchemeCfgClient> impl;



    /** Private constructor. */
    private TripleDESPasswordStorageSchemeCfgClientImpl(
        ManagedObject<? extends TripleDESPasswordStorageSchemeCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends TripleDESPasswordStorageSchemeCfgClient, ? extends TripleDESPasswordStorageSchemeCfg> definition() {
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
  private static class TripleDESPasswordStorageSchemeCfgServerImpl implements
    TripleDESPasswordStorageSchemeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends TripleDESPasswordStorageSchemeCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private TripleDESPasswordStorageSchemeCfgServerImpl(ServerManagedObject<? extends TripleDESPasswordStorageSchemeCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addTripleDESChangeListener(
        ConfigurationChangeListener<TripleDESPasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeTripleDESChangeListener(
        ConfigurationChangeListener<TripleDESPasswordStorageSchemeCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PasswordStorageSchemeCfg> listener) {
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
    public Class<? extends TripleDESPasswordStorageSchemeCfg> configurationClass() {
      return TripleDESPasswordStorageSchemeCfg.class;
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
