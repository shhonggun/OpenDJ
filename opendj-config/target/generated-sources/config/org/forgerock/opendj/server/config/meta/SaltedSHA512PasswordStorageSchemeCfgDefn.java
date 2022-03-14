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
import org.forgerock.opendj.server.config.client.SaltedSHA512PasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.SaltedSHA512PasswordStorageSchemeCfg;



/**
 * An interface for querying the Salted SHA512 Password Storage Scheme
 * managed object definition meta information.
 * <p>
 * The Salted SHA512 Password Storage Scheme provides a mechanism for
 * encoding user passwords using a salted form of the 512-bit SHA-2
 * message digest algorithm.
 */
public final class SaltedSHA512PasswordStorageSchemeCfgDefn extends ManagedObjectDefinition<SaltedSHA512PasswordStorageSchemeCfgClient, SaltedSHA512PasswordStorageSchemeCfg> {

  /** The singleton configuration definition instance. */
  private static final SaltedSHA512PasswordStorageSchemeCfgDefn INSTANCE = new SaltedSHA512PasswordStorageSchemeCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SaltedSHA512PasswordStorageScheme");
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
   * Get the Salted SHA512 Password Storage Scheme configuration
   * definition singleton.
   *
   * @return Returns the Salted SHA512 Password Storage Scheme
   *         configuration definition singleton.
   */
  public static SaltedSHA512PasswordStorageSchemeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SaltedSHA512PasswordStorageSchemeCfgDefn() {
    super("salted-sha512-password-storage-scheme", PasswordStorageSchemeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SaltedSHA512PasswordStorageSchemeCfgClient createClientConfiguration(
      ManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfgClient> impl) {
    return new SaltedSHA512PasswordStorageSchemeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SaltedSHA512PasswordStorageSchemeCfg createServerConfiguration(
      ServerManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfg> impl) {
    return new SaltedSHA512PasswordStorageSchemeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SaltedSHA512PasswordStorageSchemeCfg> getServerConfigurationClass() {
    return SaltedSHA512PasswordStorageSchemeCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Salted SHA512 Password Storage Scheme is
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
   * provides the Salted SHA512 Password Storage Scheme implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SaltedSHA512PasswordStorageSchemeCfgClientImpl implements
    SaltedSHA512PasswordStorageSchemeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfgClient> impl;



    /** Private constructor. */
    private SaltedSHA512PasswordStorageSchemeCfgClientImpl(
        ManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends SaltedSHA512PasswordStorageSchemeCfgClient, ? extends SaltedSHA512PasswordStorageSchemeCfg> definition() {
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
  private static class SaltedSHA512PasswordStorageSchemeCfgServerImpl implements
    SaltedSHA512PasswordStorageSchemeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private SaltedSHA512PasswordStorageSchemeCfgServerImpl(ServerManagedObject<? extends SaltedSHA512PasswordStorageSchemeCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSaltedSHA512ChangeListener(
        ConfigurationChangeListener<SaltedSHA512PasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSaltedSHA512ChangeListener(
        ConfigurationChangeListener<SaltedSHA512PasswordStorageSchemeCfg> listener) {
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
    public Class<? extends SaltedSHA512PasswordStorageSchemeCfg> configurationClass() {
      return SaltedSHA512PasswordStorageSchemeCfg.class;
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
