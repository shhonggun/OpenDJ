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
import org.forgerock.opendj.server.config.client.RepeatedCharactersPasswordValidatorCfgClient;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;
import org.forgerock.opendj.server.config.server.RepeatedCharactersPasswordValidatorCfg;



/**
 * An interface for querying the Repeated Characters Password
 * Validator managed object definition meta information.
 * <p>
 * The Repeated Characters Password Validator is used to determine
 * whether a proposed password is acceptable based on the number of
 * times any character appears consecutively in a password value.
 */
public final class RepeatedCharactersPasswordValidatorCfgDefn extends ManagedObjectDefinition<RepeatedCharactersPasswordValidatorCfgClient, RepeatedCharactersPasswordValidatorCfg> {

  /** The singleton configuration definition instance. */
  private static final RepeatedCharactersPasswordValidatorCfgDefn INSTANCE = new RepeatedCharactersPasswordValidatorCfgDefn();



  /** The "case-sensitive-validation" property definition. */
  private static final BooleanPropertyDefinition PD_CASE_SENSITIVE_VALIDATION;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "max-consecutive-length" property definition. */
  private static final IntegerPropertyDefinition PD_MAX_CONSECUTIVE_LENGTH;



  /** Build the "case-sensitive-validation" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "case-sensitive-validation");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "case-sensitive-validation"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_CASE_SENSITIVE_VALIDATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CASE_SENSITIVE_VALIDATION);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.RepeatedCharactersPasswordValidator");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordValidator");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "max-consecutive-length" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "max-consecutive-length");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "max-consecutive-length"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setLowerLimit(0);
      PD_MAX_CONSECUTIVE_LENGTH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MAX_CONSECUTIVE_LENGTH);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Repeated Characters Password Validator configuration
   * definition singleton.
   *
   * @return Returns the Repeated Characters Password Validator
   *         configuration definition singleton.
   */
  public static RepeatedCharactersPasswordValidatorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private RepeatedCharactersPasswordValidatorCfgDefn() {
    super("repeated-characters-password-validator", PasswordValidatorCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public RepeatedCharactersPasswordValidatorCfgClient createClientConfiguration(
      ManagedObject<? extends RepeatedCharactersPasswordValidatorCfgClient> impl) {
    return new RepeatedCharactersPasswordValidatorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public RepeatedCharactersPasswordValidatorCfg createServerConfiguration(
      ServerManagedObject<? extends RepeatedCharactersPasswordValidatorCfg> impl) {
    return new RepeatedCharactersPasswordValidatorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<RepeatedCharactersPasswordValidatorCfg> getServerConfigurationClass() {
    return RepeatedCharactersPasswordValidatorCfg.class;
  }



  /**
   * Get the "case-sensitive-validation" property definition.
   * <p>
   * Indicates whether this password validator should treat password
   * characters in a case-sensitive manner.
   * <p>
   * If the value of this property is false, the validator ignores any
   * differences in capitalization when looking for consecutive
   * characters in the password. If the value is true, the validator
   * considers a character to be repeating only if all consecutive
   * occurrences use the same capitalization.
   *
   * @return Returns the "case-sensitive-validation" property definition.
   */
  public BooleanPropertyDefinition getCaseSensitiveValidationPropertyDefinition() {
    return PD_CASE_SENSITIVE_VALIDATION;
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
   * Get the "max-consecutive-length" property definition.
   * <p>
   * Specifies the maximum number of times that any character can
   * appear consecutively in a password value.
   * <p>
   * A value of zero indicates that no maximum limit is enforced.
   *
   * @return Returns the "max-consecutive-length" property definition.
   */
  public IntegerPropertyDefinition getMaxConsecutiveLengthPropertyDefinition() {
    return PD_MAX_CONSECUTIVE_LENGTH;
  }



  /**
   * Managed object client implementation.
   */
  private static class RepeatedCharactersPasswordValidatorCfgClientImpl implements
    RepeatedCharactersPasswordValidatorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends RepeatedCharactersPasswordValidatorCfgClient> impl;



    /** Private constructor. */
    private RepeatedCharactersPasswordValidatorCfgClientImpl(
        ManagedObject<? extends RepeatedCharactersPasswordValidatorCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Boolean isCaseSensitiveValidation() {
      return impl.getPropertyValue(INSTANCE.getCaseSensitiveValidationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCaseSensitiveValidation(boolean value) {
      impl.setPropertyValue(INSTANCE.getCaseSensitiveValidationPropertyDefinition(), value);
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
    public Integer getMaxConsecutiveLength() {
      return impl.getPropertyValue(INSTANCE.getMaxConsecutiveLengthPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMaxConsecutiveLength(int value) {
      impl.setPropertyValue(INSTANCE.getMaxConsecutiveLengthPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends RepeatedCharactersPasswordValidatorCfgClient, ? extends RepeatedCharactersPasswordValidatorCfg> definition() {
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
  private static class RepeatedCharactersPasswordValidatorCfgServerImpl implements
    RepeatedCharactersPasswordValidatorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends RepeatedCharactersPasswordValidatorCfg> impl;

    /** The value of the "case-sensitive-validation" property. */
    private final boolean pCaseSensitiveValidation;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "max-consecutive-length" property. */
    private final int pMaxConsecutiveLength;



    /** Private constructor. */
    private RepeatedCharactersPasswordValidatorCfgServerImpl(ServerManagedObject<? extends RepeatedCharactersPasswordValidatorCfg> impl) {
      this.impl = impl;
      this.pCaseSensitiveValidation = impl.getPropertyValue(INSTANCE.getCaseSensitiveValidationPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMaxConsecutiveLength = impl.getPropertyValue(INSTANCE.getMaxConsecutiveLengthPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addRepeatedCharactersChangeListener(
        ConfigurationChangeListener<RepeatedCharactersPasswordValidatorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeRepeatedCharactersChangeListener(
        ConfigurationChangeListener<RepeatedCharactersPasswordValidatorCfg> listener) {
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
    public boolean isCaseSensitiveValidation() {
      return pCaseSensitiveValidation;
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
    public int getMaxConsecutiveLength() {
      return pMaxConsecutiveLength;
    }



    /** {@inheritDoc} */
    public Class<? extends RepeatedCharactersPasswordValidatorCfg> configurationClass() {
      return RepeatedCharactersPasswordValidatorCfg.class;
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
