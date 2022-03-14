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
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.GenericConstraint;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.CharacterSetPasswordValidatorCfgClient;
import org.forgerock.opendj.server.config.server.CharacterSetPasswordValidatorCfg;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;



/**
 * An interface for querying the Character Set Password Validator
 * managed object definition meta information.
 * <p>
 * The Character Set Password Validator determines whether a proposed
 * password is acceptable by checking whether it contains a sufficient
 * number of characters from one or more user-defined character sets
 * and ranges.
 */
public final class CharacterSetPasswordValidatorCfgDefn extends ManagedObjectDefinition<CharacterSetPasswordValidatorCfgClient, CharacterSetPasswordValidatorCfg> {

  /** The singleton configuration definition instance. */
  private static final CharacterSetPasswordValidatorCfgDefn INSTANCE = new CharacterSetPasswordValidatorCfgDefn();



  /** The "allow-unclassified-characters" property definition. */
  private static final BooleanPropertyDefinition PD_ALLOW_UNCLASSIFIED_CHARACTERS;



  /** The "character-set" property definition. */
  private static final StringPropertyDefinition PD_CHARACTER_SET;



  /** The "character-set-ranges" property definition. */
  private static final StringPropertyDefinition PD_CHARACTER_SET_RANGES;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "min-character-sets" property definition. */
  private static final IntegerPropertyDefinition PD_MIN_CHARACTER_SETS;



  /** Build the "allow-unclassified-characters" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "allow-unclassified-characters");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "allow-unclassified-characters"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ALLOW_UNCLASSIFIED_CHARACTERS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOW_UNCLASSIFIED_CHARACTERS);
  }



  /** Build the "character-set" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "character-set");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "character-set"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "character-set"));
      builder.setCaseInsensitive(false);
      PD_CHARACTER_SET = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHARACTER_SET);
  }



  /** Build the "character-set-ranges" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "character-set-ranges");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "character-set-ranges"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "character-set-ranges"));
      builder.setCaseInsensitive(false);
      PD_CHARACTER_SET_RANGES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CHARACTER_SET_RANGES);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.CharacterSetPasswordValidator");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordValidator");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "min-character-sets" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "min-character-sets");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "min-character-sets"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "min-character-sets"));
      PD_MIN_CHARACTER_SETS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MIN_CHARACTER_SETS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.or(Conditions.isPresent("character-set"), Conditions.isPresent("character-set-ranges"))));
  }



  /**
   * Get the Character Set Password Validator configuration definition
   * singleton.
   *
   * @return Returns the Character Set Password Validator
   *         configuration definition singleton.
   */
  public static CharacterSetPasswordValidatorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private CharacterSetPasswordValidatorCfgDefn() {
    super("character-set-password-validator", PasswordValidatorCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public CharacterSetPasswordValidatorCfgClient createClientConfiguration(
      ManagedObject<? extends CharacterSetPasswordValidatorCfgClient> impl) {
    return new CharacterSetPasswordValidatorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public CharacterSetPasswordValidatorCfg createServerConfiguration(
      ServerManagedObject<? extends CharacterSetPasswordValidatorCfg> impl) {
    return new CharacterSetPasswordValidatorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<CharacterSetPasswordValidatorCfg> getServerConfigurationClass() {
    return CharacterSetPasswordValidatorCfg.class;
  }



  /**
   * Get the "allow-unclassified-characters" property definition.
   * <p>
   * Indicates whether this password validator allows passwords to
   * contain characters outside of any of the user-defined character
   * sets and ranges.
   * <p>
   * If this is "false", then only those characters in the
   * user-defined character sets and ranges may be used in passwords.
   * Any password containing a character not included in any character
   * set or range will be rejected.
   *
   * @return Returns the "allow-unclassified-characters" property definition.
   */
  public BooleanPropertyDefinition getAllowUnclassifiedCharactersPropertyDefinition() {
    return PD_ALLOW_UNCLASSIFIED_CHARACTERS;
  }



  /**
   * Get the "character-set" property definition.
   * <p>
   * Specifies a character set containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that set.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the set which may be zero, indicating that the
   * character set is optional) followed by a colon and the characters
   * to include in that set (for example,
   * "3:abcdefghijklmnopqrstuvwxyz" indicates that a user password must
   * contain at least three characters from the set of lowercase ASCII
   * letters). Multiple character sets can be defined in separate
   * values, although no character can appear in more than one
   * character set.
   *
   * @return Returns the "character-set" property definition.
   */
  public StringPropertyDefinition getCharacterSetPropertyDefinition() {
    return PD_CHARACTER_SET;
  }



  /**
   * Get the "character-set-ranges" property definition.
   * <p>
   * Specifies a character range containing characters that a password
   * may contain and a value indicating the minimum number of
   * characters required from that range.
   * <p>
   * Each value must be an integer (indicating the minimum required
   * characters from the range which may be zero, indicating that the
   * character range is optional) followed by a colon and one or more
   * range specifications. A range specification is 3 characters: the
   * first character allowed, a minus, and the last character allowed.
   * For example, "3:A-Za-z0-9". The ranges in each value should not
   * overlap, and the characters in each range specification should be
   * ordered.
   *
   * @return Returns the "character-set-ranges" property definition.
   */
  public StringPropertyDefinition getCharacterSetRangesPropertyDefinition() {
    return PD_CHARACTER_SET_RANGES;
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
   * Get the "min-character-sets" property definition.
   * <p>
   * Specifies the minimum number of character sets and ranges that a
   * password must contain.
   * <p>
   * This property should only be used in conjunction with optional
   * character sets and ranges (those requiring zero characters). Its
   * value must include any mandatory character sets and ranges (those
   * requiring greater than zero characters). This is useful in
   * situations where a password must contain characters from mandatory
   * character sets and ranges, and characters from at least N optional
   * character sets and ranges. For example, it is quite common to
   * require that a password contains at least one non-alphanumeric
   * character as well as characters from two alphanumeric character
   * sets (lower-case, upper-case, digits). In this case, this property
   * should be set to 3.
   *
   * @return Returns the "min-character-sets" property definition.
   */
  public IntegerPropertyDefinition getMinCharacterSetsPropertyDefinition() {
    return PD_MIN_CHARACTER_SETS;
  }



  /**
   * Managed object client implementation.
   */
  private static class CharacterSetPasswordValidatorCfgClientImpl implements
    CharacterSetPasswordValidatorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends CharacterSetPasswordValidatorCfgClient> impl;



    /** Private constructor. */
    private CharacterSetPasswordValidatorCfgClientImpl(
        ManagedObject<? extends CharacterSetPasswordValidatorCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Boolean isAllowUnclassifiedCharacters() {
      return impl.getPropertyValue(INSTANCE.getAllowUnclassifiedCharactersPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowUnclassifiedCharacters(boolean value) {
      impl.setPropertyValue(INSTANCE.getAllowUnclassifiedCharactersPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCharacterSet() {
      return impl.getPropertyValues(INSTANCE.getCharacterSetPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCharacterSet(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getCharacterSetPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCharacterSetRanges() {
      return impl.getPropertyValues(INSTANCE.getCharacterSetRangesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCharacterSetRanges(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getCharacterSetRangesPropertyDefinition(), values);
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
    public Integer getMinCharacterSets() {
      return impl.getPropertyValue(INSTANCE.getMinCharacterSetsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMinCharacterSets(Integer value) {
      impl.setPropertyValue(INSTANCE.getMinCharacterSetsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends CharacterSetPasswordValidatorCfgClient, ? extends CharacterSetPasswordValidatorCfg> definition() {
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
  private static class CharacterSetPasswordValidatorCfgServerImpl implements
    CharacterSetPasswordValidatorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends CharacterSetPasswordValidatorCfg> impl;

    /** The value of the "allow-unclassified-characters" property. */
    private final boolean pAllowUnclassifiedCharacters;

    /** The value of the "character-set" property. */
    private final SortedSet<String> pCharacterSet;

    /** The value of the "character-set-ranges" property. */
    private final SortedSet<String> pCharacterSetRanges;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "min-character-sets" property. */
    private final Integer pMinCharacterSets;



    /** Private constructor. */
    private CharacterSetPasswordValidatorCfgServerImpl(ServerManagedObject<? extends CharacterSetPasswordValidatorCfg> impl) {
      this.impl = impl;
      this.pAllowUnclassifiedCharacters = impl.getPropertyValue(INSTANCE.getAllowUnclassifiedCharactersPropertyDefinition());
      this.pCharacterSet = impl.getPropertyValues(INSTANCE.getCharacterSetPropertyDefinition());
      this.pCharacterSetRanges = impl.getPropertyValues(INSTANCE.getCharacterSetRangesPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMinCharacterSets = impl.getPropertyValue(INSTANCE.getMinCharacterSetsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addCharacterSetChangeListener(
        ConfigurationChangeListener<CharacterSetPasswordValidatorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeCharacterSetChangeListener(
        ConfigurationChangeListener<CharacterSetPasswordValidatorCfg> listener) {
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
    public boolean isAllowUnclassifiedCharacters() {
      return pAllowUnclassifiedCharacters;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCharacterSet() {
      return pCharacterSet;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getCharacterSetRanges() {
      return pCharacterSetRanges;
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
    public Integer getMinCharacterSets() {
      return pMinCharacterSets;
    }



    /** {@inheritDoc} */
    public Class<? extends CharacterSetPasswordValidatorCfg> configurationClass() {
      return CharacterSetPasswordValidatorCfg.class;
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
