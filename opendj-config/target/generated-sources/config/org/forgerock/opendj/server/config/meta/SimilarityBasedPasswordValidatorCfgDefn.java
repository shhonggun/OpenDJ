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
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.SimilarityBasedPasswordValidatorCfgClient;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;
import org.forgerock.opendj.server.config.server.SimilarityBasedPasswordValidatorCfg;



/**
 * An interface for querying the Similarity Based Password Validator
 * managed object definition meta information.
 * <p>
 * The Similarity Based Password Validator determines whether a
 * proposed password is acceptable by measuring how similar it is to
 * the user's current password.
 */
public final class SimilarityBasedPasswordValidatorCfgDefn extends ManagedObjectDefinition<SimilarityBasedPasswordValidatorCfgClient, SimilarityBasedPasswordValidatorCfg> {

  /** The singleton configuration definition instance. */
  private static final SimilarityBasedPasswordValidatorCfgDefn INSTANCE = new SimilarityBasedPasswordValidatorCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "min-password-difference" property definition. */
  private static final IntegerPropertyDefinition PD_MIN_PASSWORD_DIFFERENCE;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SimilarityBasedPasswordValidator");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordValidator");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "min-password-difference" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "min-password-difference");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "min-password-difference"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setUpperLimit(2147483647);
      builder.setLowerLimit(0);
      PD_MIN_PASSWORD_DIFFERENCE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MIN_PASSWORD_DIFFERENCE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Similarity Based Password Validator configuration
   * definition singleton.
   *
   * @return Returns the Similarity Based Password Validator
   *         configuration definition singleton.
   */
  public static SimilarityBasedPasswordValidatorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SimilarityBasedPasswordValidatorCfgDefn() {
    super("similarity-based-password-validator", PasswordValidatorCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SimilarityBasedPasswordValidatorCfgClient createClientConfiguration(
      ManagedObject<? extends SimilarityBasedPasswordValidatorCfgClient> impl) {
    return new SimilarityBasedPasswordValidatorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SimilarityBasedPasswordValidatorCfg createServerConfiguration(
      ServerManagedObject<? extends SimilarityBasedPasswordValidatorCfg> impl) {
    return new SimilarityBasedPasswordValidatorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SimilarityBasedPasswordValidatorCfg> getServerConfigurationClass() {
    return SimilarityBasedPasswordValidatorCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the password validator is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PasswordValidatorCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "min-password-difference" property definition.
   * <p>
   * Specifies the minimum difference of new and old password.
   * <p>
   * A value of zero indicates that no difference between passwords is
   * acceptable.
   *
   * @return Returns the "min-password-difference" property definition.
   */
  public IntegerPropertyDefinition getMinPasswordDifferencePropertyDefinition() {
    return PD_MIN_PASSWORD_DIFFERENCE;
  }



  /**
   * Managed object client implementation.
   */
  private static class SimilarityBasedPasswordValidatorCfgClientImpl implements
    SimilarityBasedPasswordValidatorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SimilarityBasedPasswordValidatorCfgClient> impl;



    /** Private constructor. */
    private SimilarityBasedPasswordValidatorCfgClientImpl(
        ManagedObject<? extends SimilarityBasedPasswordValidatorCfgClient> impl) {
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
    public Integer getMinPasswordDifference() {
      return impl.getPropertyValue(INSTANCE.getMinPasswordDifferencePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMinPasswordDifference(int value) {
      impl.setPropertyValue(INSTANCE.getMinPasswordDifferencePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SimilarityBasedPasswordValidatorCfgClient, ? extends SimilarityBasedPasswordValidatorCfg> definition() {
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
  private static class SimilarityBasedPasswordValidatorCfgServerImpl implements
    SimilarityBasedPasswordValidatorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SimilarityBasedPasswordValidatorCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "min-password-difference" property. */
    private final int pMinPasswordDifference;



    /** Private constructor. */
    private SimilarityBasedPasswordValidatorCfgServerImpl(ServerManagedObject<? extends SimilarityBasedPasswordValidatorCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMinPasswordDifference = impl.getPropertyValue(INSTANCE.getMinPasswordDifferencePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSimilarityBasedChangeListener(
        ConfigurationChangeListener<SimilarityBasedPasswordValidatorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSimilarityBasedChangeListener(
        ConfigurationChangeListener<SimilarityBasedPasswordValidatorCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PasswordValidatorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PasswordValidatorCfg> listener) {
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
    public int getMinPasswordDifference() {
      return pMinPasswordDifference;
    }



    /** {@inheritDoc} */
    public Class<? extends SimilarityBasedPasswordValidatorCfg> configurationClass() {
      return SimilarityBasedPasswordValidatorCfg.class;
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
