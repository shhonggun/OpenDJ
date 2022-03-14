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
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.BcryptPasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.server.BcryptPasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;



/**
 * An interface for querying the Bcrypt Password Storage Scheme
 * managed object definition meta information.
 * <p>
 * The Bcrypt Password Storage Scheme provides a mechanism for
 * encoding user passwords using the bcrypt message digest algorithm.
 */
public final class BcryptPasswordStorageSchemeCfgDefn extends ManagedObjectDefinition<BcryptPasswordStorageSchemeCfgClient, BcryptPasswordStorageSchemeCfg> {

  /** The singleton configuration definition instance. */
  private static final BcryptPasswordStorageSchemeCfgDefn INSTANCE = new BcryptPasswordStorageSchemeCfgDefn();



  /** The "bcrypt-cost" property definition. */
  private static final IntegerPropertyDefinition PD_BCRYPT_COST;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "bcrypt-cost" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "bcrypt-cost");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "bcrypt-cost"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("12");
      builder.setDefaultBehaviorProvider(provider);
      builder.setUpperLimit(30);
      builder.setLowerLimit(1);
      PD_BCRYPT_COST = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_BCRYPT_COST);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.BcryptPasswordStorageScheme");
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
   * Get the Bcrypt Password Storage Scheme configuration definition
   * singleton.
   *
   * @return Returns the Bcrypt Password Storage Scheme configuration
   *         definition singleton.
   */
  public static BcryptPasswordStorageSchemeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private BcryptPasswordStorageSchemeCfgDefn() {
    super("bcrypt-password-storage-scheme", PasswordStorageSchemeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public BcryptPasswordStorageSchemeCfgClient createClientConfiguration(
      ManagedObject<? extends BcryptPasswordStorageSchemeCfgClient> impl) {
    return new BcryptPasswordStorageSchemeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public BcryptPasswordStorageSchemeCfg createServerConfiguration(
      ServerManagedObject<? extends BcryptPasswordStorageSchemeCfg> impl) {
    return new BcryptPasswordStorageSchemeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<BcryptPasswordStorageSchemeCfg> getServerConfigurationClass() {
    return BcryptPasswordStorageSchemeCfg.class;
  }



  /**
   * Get the "bcrypt-cost" property definition.
   * <p>
   * The cost parameter specifies a key expansion iteration count as a
   * power of two. A default value of 12 (2^12 iterations) is
   * considered in 2016 as a reasonable balance between responsiveness
   * and security for regular users.
   *
   * @return Returns the "bcrypt-cost" property definition.
   */
  public IntegerPropertyDefinition getBcryptCostPropertyDefinition() {
    return PD_BCRYPT_COST;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Bcrypt Password Storage Scheme is enabled
   * for use.
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
   * provides the Bcrypt Password Storage Scheme implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class BcryptPasswordStorageSchemeCfgClientImpl implements
    BcryptPasswordStorageSchemeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends BcryptPasswordStorageSchemeCfgClient> impl;



    /** Private constructor. */
    private BcryptPasswordStorageSchemeCfgClientImpl(
        ManagedObject<? extends BcryptPasswordStorageSchemeCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public int getBcryptCost() {
      return impl.getPropertyValue(INSTANCE.getBcryptCostPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setBcryptCost(Integer value) {
      impl.setPropertyValue(INSTANCE.getBcryptCostPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends BcryptPasswordStorageSchemeCfgClient, ? extends BcryptPasswordStorageSchemeCfg> definition() {
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
  private static class BcryptPasswordStorageSchemeCfgServerImpl implements
    BcryptPasswordStorageSchemeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends BcryptPasswordStorageSchemeCfg> impl;

    /** The value of the "bcrypt-cost" property. */
    private final int pBcryptCost;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private BcryptPasswordStorageSchemeCfgServerImpl(ServerManagedObject<? extends BcryptPasswordStorageSchemeCfg> impl) {
      this.impl = impl;
      this.pBcryptCost = impl.getPropertyValue(INSTANCE.getBcryptCostPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addBcryptChangeListener(
        ConfigurationChangeListener<BcryptPasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeBcryptChangeListener(
        ConfigurationChangeListener<BcryptPasswordStorageSchemeCfg> listener) {
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
    public int getBcryptCost() {
      return pBcryptCost;
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
    public Class<? extends BcryptPasswordStorageSchemeCfg> configurationClass() {
      return BcryptPasswordStorageSchemeCfg.class;
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
