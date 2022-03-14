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
import org.forgerock.opendj.server.config.client.PBKDF2PasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PBKDF2PasswordStorageSchemeCfg;



/**
 * An interface for querying the PBKDF2 Password Storage Scheme
 * managed object definition meta information.
 * <p>
 * The PBKDF2 Password Storage Scheme provides a mechanism for
 * encoding user passwords using the PBKDF2 message digest algorithm.
 */
public final class PBKDF2PasswordStorageSchemeCfgDefn extends ManagedObjectDefinition<PBKDF2PasswordStorageSchemeCfgClient, PBKDF2PasswordStorageSchemeCfg> {

  /** The singleton configuration definition instance. */
  private static final PBKDF2PasswordStorageSchemeCfgDefn INSTANCE = new PBKDF2PasswordStorageSchemeCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "pbkdf2-iterations" property definition. */
  private static final IntegerPropertyDefinition PD_PBKDF2_ITERATIONS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.PBKDF2PasswordStorageScheme");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordStorageScheme");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "pbkdf2-iterations" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "pbkdf2-iterations");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "pbkdf2-iterations"));
      DefaultBehaviorProvider<Integer> provider = new DefinedDefaultBehaviorProvider<Integer>("10000");
      builder.setDefaultBehaviorProvider(provider);
      builder.setLowerLimit(1);
      PD_PBKDF2_ITERATIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PBKDF2_ITERATIONS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the PBKDF2 Password Storage Scheme configuration definition
   * singleton.
   *
   * @return Returns the PBKDF2 Password Storage Scheme configuration
   *         definition singleton.
   */
  public static PBKDF2PasswordStorageSchemeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PBKDF2PasswordStorageSchemeCfgDefn() {
    super("pbkdf2-password-storage-scheme", PasswordStorageSchemeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PBKDF2PasswordStorageSchemeCfgClient createClientConfiguration(
      ManagedObject<? extends PBKDF2PasswordStorageSchemeCfgClient> impl) {
    return new PBKDF2PasswordStorageSchemeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PBKDF2PasswordStorageSchemeCfg createServerConfiguration(
      ServerManagedObject<? extends PBKDF2PasswordStorageSchemeCfg> impl) {
    return new PBKDF2PasswordStorageSchemeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PBKDF2PasswordStorageSchemeCfg> getServerConfigurationClass() {
    return PBKDF2PasswordStorageSchemeCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the PBKDF2 Password Storage Scheme is enabled
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
   * provides the PBKDF2 Password Storage Scheme implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "pbkdf2-iterations" property definition.
   * <p>
   * The number of algorithm iterations to make. NIST recommends at
   * least 1000.
   *
   * @return Returns the "pbkdf2-iterations" property definition.
   */
  public IntegerPropertyDefinition getPBKDF2IterationsPropertyDefinition() {
    return PD_PBKDF2_ITERATIONS;
  }



  /**
   * Managed object client implementation.
   */
  private static class PBKDF2PasswordStorageSchemeCfgClientImpl implements
    PBKDF2PasswordStorageSchemeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PBKDF2PasswordStorageSchemeCfgClient> impl;



    /** Private constructor. */
    private PBKDF2PasswordStorageSchemeCfgClientImpl(
        ManagedObject<? extends PBKDF2PasswordStorageSchemeCfgClient> impl) {
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
    public int getPBKDF2Iterations() {
      return impl.getPropertyValue(INSTANCE.getPBKDF2IterationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPBKDF2Iterations(Integer value) {
      impl.setPropertyValue(INSTANCE.getPBKDF2IterationsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PBKDF2PasswordStorageSchemeCfgClient, ? extends PBKDF2PasswordStorageSchemeCfg> definition() {
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
  private static class PBKDF2PasswordStorageSchemeCfgServerImpl implements
    PBKDF2PasswordStorageSchemeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PBKDF2PasswordStorageSchemeCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "pbkdf2-iterations" property. */
    private final int pPBKDF2Iterations;



    /** Private constructor. */
    private PBKDF2PasswordStorageSchemeCfgServerImpl(ServerManagedObject<? extends PBKDF2PasswordStorageSchemeCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPBKDF2Iterations = impl.getPropertyValue(INSTANCE.getPBKDF2IterationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addPBKDF2ChangeListener(
        ConfigurationChangeListener<PBKDF2PasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removePBKDF2ChangeListener(
        ConfigurationChangeListener<PBKDF2PasswordStorageSchemeCfg> listener) {
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
    public int getPBKDF2Iterations() {
      return pPBKDF2Iterations;
    }



    /** {@inheritDoc} */
    public Class<? extends PBKDF2PasswordStorageSchemeCfg> configurationClass() {
      return PBKDF2PasswordStorageSchemeCfg.class;
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
