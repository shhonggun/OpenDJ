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
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.PasswordGeneratorCfgClient;
import org.forgerock.opendj.server.config.server.PasswordGeneratorCfg;



/**
 * An interface for querying the Password Generator managed object
 * definition meta information.
 * <p>
 * Password Generators are used by the password modify extended
 * operation to construct a new password for the user.
 */
public final class PasswordGeneratorCfgDefn extends ManagedObjectDefinition<PasswordGeneratorCfgClient, PasswordGeneratorCfg> {

  /** The singleton configuration definition instance. */
  private static final PasswordGeneratorCfgDefn INSTANCE = new PasswordGeneratorCfgDefn();



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.PasswordGenerator");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Password Generator configuration definition singleton.
   *
   * @return Returns the Password Generator configuration definition
   *         singleton.
   */
  public static PasswordGeneratorCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PasswordGeneratorCfgDefn() {
    super("password-generator", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PasswordGeneratorCfgClient createClientConfiguration(
      ManagedObject<? extends PasswordGeneratorCfgClient> impl) {
    return new PasswordGeneratorCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PasswordGeneratorCfg createServerConfiguration(
      ServerManagedObject<? extends PasswordGeneratorCfg> impl) {
    return new PasswordGeneratorCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PasswordGeneratorCfg> getServerConfigurationClass() {
    return PasswordGeneratorCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Password Generator is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Password Generator implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class PasswordGeneratorCfgClientImpl implements
    PasswordGeneratorCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PasswordGeneratorCfgClient> impl;



    /** Private constructor. */
    private PasswordGeneratorCfgClientImpl(
        ManagedObject<? extends PasswordGeneratorCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends PasswordGeneratorCfgClient, ? extends PasswordGeneratorCfg> definition() {
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
  private static class PasswordGeneratorCfgServerImpl implements
    PasswordGeneratorCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PasswordGeneratorCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private PasswordGeneratorCfgServerImpl(ServerManagedObject<? extends PasswordGeneratorCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
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
    public Class<? extends PasswordGeneratorCfg> configurationClass() {
      return PasswordGeneratorCfg.class;
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
