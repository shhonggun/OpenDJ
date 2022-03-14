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
import org.forgerock.opendj.config.DurationPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.SoftReferenceEntryCacheCfgClient;
import org.forgerock.opendj.server.config.server.EntryCacheCfg;
import org.forgerock.opendj.server.config.server.SoftReferenceEntryCacheCfg;



/**
 * An interface for querying the Soft Reference Entry Cache managed
 * object definition meta information.
 * <p>
 * The Soft Reference Entry Cache is a directory server entry cache
 * implementation that uses soft references to manage objects to allow
 * them to be freed if the JVM is running low on memory.
 */
public final class SoftReferenceEntryCacheCfgDefn extends ManagedObjectDefinition<SoftReferenceEntryCacheCfgClient, SoftReferenceEntryCacheCfg> {

  /** The singleton configuration definition instance. */
  private static final SoftReferenceEntryCacheCfgDefn INSTANCE = new SoftReferenceEntryCacheCfgDefn();



  /** The "exclude-filter" property definition. */
  private static final StringPropertyDefinition PD_EXCLUDE_FILTER;



  /** The "include-filter" property definition. */
  private static final StringPropertyDefinition PD_INCLUDE_FILTER;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "lock-timeout" property definition. */
  private static final DurationPropertyDefinition PD_LOCK_TIMEOUT;



  /** Build the "exclude-filter" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "exclude-filter");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "exclude-filter"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_EXCLUDE_FILTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_EXCLUDE_FILTER);
  }



  /** Build the "include-filter" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "include-filter");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "include-filter"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_INCLUDE_FILTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INCLUDE_FILTER);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SoftReferenceEntryCache");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.EntryCache");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "lock-timeout" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "lock-timeout");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "lock-timeout"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("3000ms");
      builder.setDefaultBehaviorProvider(provider);
      builder.setAllowUnlimited(true);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("0");
      PD_LOCK_TIMEOUT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LOCK_TIMEOUT);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("database"));
  }



  /**
   * Get the Soft Reference Entry Cache configuration definition
   * singleton.
   *
   * @return Returns the Soft Reference Entry Cache configuration
   *         definition singleton.
   */
  public static SoftReferenceEntryCacheCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SoftReferenceEntryCacheCfgDefn() {
    super("soft-reference-entry-cache", EntryCacheCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SoftReferenceEntryCacheCfgClient createClientConfiguration(
      ManagedObject<? extends SoftReferenceEntryCacheCfgClient> impl) {
    return new SoftReferenceEntryCacheCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SoftReferenceEntryCacheCfg createServerConfiguration(
      ServerManagedObject<? extends SoftReferenceEntryCacheCfg> impl) {
    return new SoftReferenceEntryCacheCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SoftReferenceEntryCacheCfg> getServerConfigurationClass() {
    return SoftReferenceEntryCacheCfg.class;
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
    return EntryCacheCfgDefn.getInstance().getCacheLevelPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Soft Reference Entry Cache is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return EntryCacheCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "exclude-filter" property definition.
   * <p>
   * The set of filters that define the entries that should be
   * excluded from the cache.
   *
   * @return Returns the "exclude-filter" property definition.
   */
  public StringPropertyDefinition getExcludeFilterPropertyDefinition() {
    return PD_EXCLUDE_FILTER;
  }



  /**
   * Get the "include-filter" property definition.
   * <p>
   * The set of filters that define the entries that should be
   * included in the cache.
   *
   * @return Returns the "include-filter" property definition.
   */
  public StringPropertyDefinition getIncludeFilterPropertyDefinition() {
    return PD_INCLUDE_FILTER;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Soft Reference Entry Cache implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "lock-timeout" property definition.
   * <p>
   * Specifies the length of time in milliseconds to wait while
   * attempting to acquire a read or write lock.
   *
   * @return Returns the "lock-timeout" property definition.
   */
  public DurationPropertyDefinition getLockTimeoutPropertyDefinition() {
    return PD_LOCK_TIMEOUT;
  }



  /**
   * Managed object client implementation.
   */
  private static class SoftReferenceEntryCacheCfgClientImpl implements
    SoftReferenceEntryCacheCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SoftReferenceEntryCacheCfgClient> impl;



    /** Private constructor. */
    private SoftReferenceEntryCacheCfgClientImpl(
        ManagedObject<? extends SoftReferenceEntryCacheCfgClient> impl) {
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
    public SortedSet<String> getExcludeFilter() {
      return impl.getPropertyValues(INSTANCE.getExcludeFilterPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setExcludeFilter(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getExcludeFilterPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIncludeFilter() {
      return impl.getPropertyValues(INSTANCE.getIncludeFilterPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setIncludeFilter(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getIncludeFilterPropertyDefinition(), values);
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
    public long getLockTimeout() {
      return impl.getPropertyValue(INSTANCE.getLockTimeoutPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setLockTimeout(Long value) {
      impl.setPropertyValue(INSTANCE.getLockTimeoutPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SoftReferenceEntryCacheCfgClient, ? extends SoftReferenceEntryCacheCfg> definition() {
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
  private static class SoftReferenceEntryCacheCfgServerImpl implements
    SoftReferenceEntryCacheCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SoftReferenceEntryCacheCfg> impl;

    /** The value of the "cache-level" property. */
    private final int pCacheLevel;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "exclude-filter" property. */
    private final SortedSet<String> pExcludeFilter;

    /** The value of the "include-filter" property. */
    private final SortedSet<String> pIncludeFilter;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "lock-timeout" property. */
    private final long pLockTimeout;



    /** Private constructor. */
    private SoftReferenceEntryCacheCfgServerImpl(ServerManagedObject<? extends SoftReferenceEntryCacheCfg> impl) {
      this.impl = impl;
      this.pCacheLevel = impl.getPropertyValue(INSTANCE.getCacheLevelPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pExcludeFilter = impl.getPropertyValues(INSTANCE.getExcludeFilterPropertyDefinition());
      this.pIncludeFilter = impl.getPropertyValues(INSTANCE.getIncludeFilterPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pLockTimeout = impl.getPropertyValue(INSTANCE.getLockTimeoutPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSoftReferenceChangeListener(
        ConfigurationChangeListener<SoftReferenceEntryCacheCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSoftReferenceChangeListener(
        ConfigurationChangeListener<SoftReferenceEntryCacheCfg> listener) {
      impl.deregisterChangeListener(listener);
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
    public SortedSet<String> getExcludeFilter() {
      return pExcludeFilter;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getIncludeFilter() {
      return pIncludeFilter;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public long getLockTimeout() {
      return pLockTimeout;
    }



    /** {@inheritDoc} */
    public Class<? extends SoftReferenceEntryCacheCfg> configurationClass() {
      return SoftReferenceEntryCacheCfg.class;
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
