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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.RandomPasswordGeneratorCfgClient;
import org.forgerock.opendj.server.config.server.PasswordGeneratorCfg;
import org.forgerock.opendj.server.config.server.RandomPasswordGeneratorCfg;



/**
 * An interface for querying the Random Password Generator managed
 * object definition meta information.
 * <p>
 * The Random Password Generator creates random passwords based on
 * fixed-length strings built from one or more character sets.
 */
public final class RandomPasswordGeneratorCfgDefn extends ManagedObjectDefinition<RandomPasswordGeneratorCfgClient, RandomPasswordGeneratorCfg> {

  /** The singleton configuration definition instance. */
  private static final RandomPasswordGeneratorCfgDefn INSTANCE = new RandomPasswordGeneratorCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "password-character-set" property definition. */
  private static final StringPropertyDefinition PD_PASSWORD_CHARACTER_SET;



  /** The "password-format" property definition. */
  private static final StringPropertyDefinition PD_PASSWORD_FORMAT;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.RandomPasswordGenerator");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordGenerator");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "password-character-set" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "password-character-set");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-character-set"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FORMAT");
      PD_PASSWORD_CHARACTER_SET = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_CHARACTER_SET);
  }



  /** Build the "password-format" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "password-format");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "password-format"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setPattern(".*", "FORMAT");
      PD_PASSWORD_FORMAT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PASSWORD_FORMAT);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Random Password Generator configuration definition
   * singleton.
   *
   * @return Returns the Random Password Generator configuration
   *         definition singleton.
   */
  public static RandomPasswordGeneratorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private RandomPasswordGeneratorCfgDefn() {
    super("random-password-generator", PasswordGeneratorCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public RandomPasswordGeneratorCfgClient createClientConfiguration(
      ManagedObject<? extends RandomPasswordGeneratorCfgClient> impl) {
    return new RandomPasswordGeneratorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public RandomPasswordGeneratorCfg createServerConfiguration(
      ServerManagedObject<? extends RandomPasswordGeneratorCfg> impl) {
    return new RandomPasswordGeneratorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<RandomPasswordGeneratorCfg> getServerConfigurationClass() {
    return RandomPasswordGeneratorCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Random Password Generator is enabled for
   * use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PasswordGeneratorCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Random Password Generator implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "password-character-set" property definition.
   * <p>
   * Specifies one or more named character sets.
   * <p>
   * This is a multi-valued property, with each value defining a
   * different character set. The format of the character set is the
   * name of the set followed by a colon and the characters that are in
   * that set. For example, the value
   * "alpha:abcdefghijklmnopqrstuvwxyz" defines a character set named
   * "alpha" containing all of the lower-case ASCII alphabetic
   * characters.
   *
   * @return Returns the "password-character-set" property definition.
   */
  public StringPropertyDefinition getPasswordCharacterSetPropertyDefinition() {
    return PD_PASSWORD_CHARACTER_SET;
  }



  /**
   * Get the "password-format" property definition.
   * <p>
   * Specifies the format to use for the generated password.
   * <p>
   * The value is a comma-delimited list of elements in which each of
   * those elements is comprised of the name of a character set defined
   * in the password-character-set property, a colon, and the number of
   * characters to include from that set. For example, a value of
   * "alpha:3,numeric:2,alpha:3" generates an 8-character password in
   * which the first three characters are from the "alpha" set, the
   * next two are from the "numeric" set, and the final three are from
   * the "alpha" set.
   *
   * @return Returns the "password-format" property definition.
   */
  public StringPropertyDefinition getPasswordFormatPropertyDefinition() {
    return PD_PASSWORD_FORMAT;
  }



  /**
   * Managed object client implementation.
   */
  private static class RandomPasswordGeneratorCfgClientImpl implements
    RandomPasswordGeneratorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends RandomPasswordGeneratorCfgClient> impl;



    /** Private constructor. */
    private RandomPasswordGeneratorCfgClientImpl(
        ManagedObject<? extends RandomPasswordGeneratorCfgClient> impl) {
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
    public SortedSet<String> getPasswordCharacterSet() {
      return impl.getPropertyValues(INSTANCE.getPasswordCharacterSetPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordCharacterSet(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getPasswordCharacterSetPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getPasswordFormat() {
      return impl.getPropertyValue(INSTANCE.getPasswordFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPasswordFormat(String value) {
      impl.setPropertyValue(INSTANCE.getPasswordFormatPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends RandomPasswordGeneratorCfgClient, ? extends RandomPasswordGeneratorCfg> definition() {
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
  private static class RandomPasswordGeneratorCfgServerImpl implements
    RandomPasswordGeneratorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends RandomPasswordGeneratorCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "password-character-set" property. */
    private final SortedSet<String> pPasswordCharacterSet;

    /** The value of the "password-format" property. */
    private final String pPasswordFormat;



    /** Private constructor. */
    private RandomPasswordGeneratorCfgServerImpl(ServerManagedObject<? extends RandomPasswordGeneratorCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPasswordCharacterSet = impl.getPropertyValues(INSTANCE.getPasswordCharacterSetPropertyDefinition());
      this.pPasswordFormat = impl.getPropertyValue(INSTANCE.getPasswordFormatPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addRandomChangeListener(
        ConfigurationChangeListener<RandomPasswordGeneratorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeRandomChangeListener(
        ConfigurationChangeListener<RandomPasswordGeneratorCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PasswordGeneratorCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PasswordGeneratorCfg> listener) {
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
    public SortedSet<String> getPasswordCharacterSet() {
      return pPasswordCharacterSet;
    }



    /** {@inheritDoc} */
    public String getPasswordFormat() {
      return pPasswordFormat;
    }



    /** {@inheritDoc} */
    public Class<? extends RandomPasswordGeneratorCfg> configurationClass() {
      return RandomPasswordGeneratorCfg.class;
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
