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
import org.forgerock.opendj.config.IntegerPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.EntryCacheCfgClient;
import org.forgerock.opendj.server.config.server.EntryCacheCfg;



/**
 * An interface for querying the Entry Cache managed object definition
 * meta information.
 * <p>
 * Entry Caches are responsible for caching entries which are likely
 * to be accessed by client applications in order to improve OpenDJ
 * directory server performance.
 */
public final class EntryCacheCfgDefn extends ManagedObjectDefinition<EntryCacheCfgClient, EntryCacheCfg> {

  /** The singleton configuration definition instance. */
  private static final EntryCacheCfgDefn INSTANCE = new EntryCacheCfgDefn();



  /** The "cache-level" property definition. */
  private static final IntegerPropertyDefinition PD_CACHE_LEVEL;



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "cache-level" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "cache-level");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "cache-level"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setLowerLimit(1);
      PD_CACHE_LEVEL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CACHE_LEVEL);
  }



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
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.EntryCache");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Entry Cache configuration definition singleton.
   *
   * @return Returns the Entry Cache configuration definition
   *         singleton.
   */
  public static EntryCacheCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private EntryCacheCfgDefn() {
    super("entry-cache", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public EntryCacheCfgClient createClientConfiguration(
      ManagedObject<? extends EntryCacheCfgClient> impl) {
    return new EntryCacheCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public EntryCacheCfg createServerConfiguration(
      ServerManagedObject<? extends EntryCacheCfg> impl) {
    return new EntryCacheCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<EntryCacheCfg> getServerConfigurationClass() {
    return EntryCacheCfg.class;
  }



  /**
   * Get the "cache-level" property definition.
   * <p>
   * Specifies the cache level in the cache order if more than one
   * instance of the cache is configured.
   *
   * @return Returns the "cache-level" property definition.
   */
  public IntegerPropertyDefinition getCacheLevelPropertyDefinition() {
    return PD_CACHE_LEVEL;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Entry Cache is enabled.
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
   * provides the Entry Cache implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class EntryCacheCfgClientImpl implements
    EntryCacheCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends EntryCacheCfgClient> impl;



    /** Private constructor. */
    private EntryCacheCfgClientImpl(
        ManagedObject<? extends EntryCacheCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Integer getCacheLevel() {
      return impl.getPropertyValue(INSTANCE.getCacheLevelPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCacheLevel(int value) {
      impl.setPropertyValue(INSTANCE.getCacheLevelPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends EntryCacheCfgClient, ? extends EntryCacheCfg> definition() {
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
  private static class EntryCacheCfgServerImpl implements
    EntryCacheCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends EntryCacheCfg> impl;

    /** The value of the "cache-level" property. */
    private final int pCacheLevel;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private EntryCacheCfgServerImpl(ServerManagedObject<? extends EntryCacheCfg> impl) {
      this.impl = impl;
      this.pCacheLevel = impl.getPropertyValue(INSTANCE.getCacheLevelPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<EntryCacheCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<EntryCacheCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public int getCacheLevel() {
      return pCacheLevel;
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
    public Class<? extends EntryCacheCfg> configurationClass() {
      return EntryCacheCfg.class;
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
