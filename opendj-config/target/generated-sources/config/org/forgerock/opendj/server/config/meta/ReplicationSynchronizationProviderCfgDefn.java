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
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.OptionalRelationDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.ReplicationDomainCfgClient;
import org.forgerock.opendj.server.config.client.ReplicationServerCfgClient;
import org.forgerock.opendj.server.config.client.ReplicationSynchronizationProviderCfgClient;
import org.forgerock.opendj.server.config.server.ReplicationDomainCfg;
import org.forgerock.opendj.server.config.server.ReplicationServerCfg;
import org.forgerock.opendj.server.config.server.ReplicationSynchronizationProviderCfg;
import org.forgerock.opendj.server.config.server.SynchronizationProviderCfg;



/**
 * An interface for querying the Replication Synchronization Provider
 * managed object definition meta information.
 * <p>
 * The Replication Synchronization Provider provides multi-master
 * replication of data across multiple directory server instances.
 */
public final class ReplicationSynchronizationProviderCfgDefn extends ManagedObjectDefinition<ReplicationSynchronizationProviderCfgClient, ReplicationSynchronizationProviderCfg> {

  /** The singleton configuration definition instance. */
  private static final ReplicationSynchronizationProviderCfgDefn INSTANCE = new ReplicationSynchronizationProviderCfgDefn();



  /** The "connection-timeout" property definition. */
  private static final DurationPropertyDefinition PD_CONNECTION_TIMEOUT;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "num-update-replay-threads" property definition. */
  private static final IntegerPropertyDefinition PD_NUM_UPDATE_REPLAY_THREADS;



  /** The "replication-domains" relation definition. */
  private static final InstantiableRelationDefinition<ReplicationDomainCfgClient, ReplicationDomainCfg> RD_REPLICATION_DOMAINS;



  /** The "replication-server" relation definition. */
  private static final OptionalRelationDefinition<ReplicationServerCfgClient, ReplicationServerCfg> RD_REPLICATION_SERVER;



  /** Build the "connection-timeout" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "connection-timeout");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "connection-timeout"));
      DefaultBehaviorProvider<Long> provider = new DefinedDefaultBehaviorProvider<Long>("5 seconds");
      builder.setDefaultBehaviorProvider(provider);
      builder.setBaseUnit("ms");
      builder.setLowerLimit("0");
      PD_CONNECTION_TIMEOUT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CONNECTION_TIMEOUT);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.replication.plugin.MultimasterReplication");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.SynchronizationProvider");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "num-update-replay-threads" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "num-update-replay-threads");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "num-update-replay-threads"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<Integer>(INSTANCE, "num-update-replay-threads"));
      builder.setUpperLimit(65535);
      builder.setLowerLimit(1);
      PD_NUM_UPDATE_REPLAY_THREADS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_NUM_UPDATE_REPLAY_THREADS);
  }



  // Build the "replication-domains" relation definition.
  static {
    InstantiableRelationDefinition.Builder<ReplicationDomainCfgClient, ReplicationDomainCfg> builder =
      new InstantiableRelationDefinition.Builder<ReplicationDomainCfgClient, ReplicationDomainCfg>(INSTANCE, "replication-domain", "replication-domains", ReplicationDomainCfgDefn.getInstance());
    RD_REPLICATION_DOMAINS = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_REPLICATION_DOMAINS);
  }



  // Build the "replication-server" relation definition.
  static {
    OptionalRelationDefinition.Builder<ReplicationServerCfgClient, ReplicationServerCfg> builder =
      new OptionalRelationDefinition.Builder<ReplicationServerCfgClient, ReplicationServerCfg>(INSTANCE, "replication-server", ReplicationServerCfgDefn.getInstance());
    RD_REPLICATION_SERVER = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_REPLICATION_SERVER);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("replication"));
  }



  /**
   * Get the Replication Synchronization Provider configuration
   * definition singleton.
   *
   * @return Returns the Replication Synchronization Provider
   *         configuration definition singleton.
   */
  public static ReplicationSynchronizationProviderCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ReplicationSynchronizationProviderCfgDefn() {
    super("replication-synchronization-provider", SynchronizationProviderCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ReplicationSynchronizationProviderCfgClient createClientConfiguration(
      ManagedObject<? extends ReplicationSynchronizationProviderCfgClient> impl) {
    return new ReplicationSynchronizationProviderCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ReplicationSynchronizationProviderCfg createServerConfiguration(
      ServerManagedObject<? extends ReplicationSynchronizationProviderCfg> impl) {
    return new ReplicationSynchronizationProviderCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ReplicationSynchronizationProviderCfg> getServerConfigurationClass() {
    return ReplicationSynchronizationProviderCfg.class;
  }



  /**
   * Get the "connection-timeout" property definition.
   * <p>
   * Specifies the timeout used when connecting to peers and when
   * performing SSL negotiation.
   *
   * @return Returns the "connection-timeout" property definition.
   */
  public DurationPropertyDefinition getConnectionTimeoutPropertyDefinition() {
    return PD_CONNECTION_TIMEOUT;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Replication Synchronization Provider is
   * enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return SynchronizationProviderCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Replication Synchronization Provider implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "num-update-replay-threads" property definition.
   * <p>
   * Specifies the number of update replay threads.
   * <p>
   * This value is the number of threads created for replaying every
   * updates received for all the replication domains.
   *
   * @return Returns the "num-update-replay-threads" property definition.
   */
  public IntegerPropertyDefinition getNumUpdateReplayThreadsPropertyDefinition() {
    return PD_NUM_UPDATE_REPLAY_THREADS;
  }



  /**
   * Get the "replication-domains" relation definition.
   *
   * @return Returns the "replication-domains" relation definition.
   */
  public InstantiableRelationDefinition<ReplicationDomainCfgClient,ReplicationDomainCfg> getReplicationDomainsRelationDefinition() {
    return RD_REPLICATION_DOMAINS;
  }



  /**
   * Get the "replication-server" relation definition.
   *
   * @return Returns the "replication-server" relation definition.
   */
  public OptionalRelationDefinition<ReplicationServerCfgClient,ReplicationServerCfg> getReplicationServerRelationDefinition() {
    return RD_REPLICATION_SERVER;
  }



  /**
   * Managed object client implementation.
   */
  private static class ReplicationSynchronizationProviderCfgClientImpl implements
    ReplicationSynchronizationProviderCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ReplicationSynchronizationProviderCfgClient> impl;



    /** Private constructor. */
    private ReplicationSynchronizationProviderCfgClientImpl(
        ManagedObject<? extends ReplicationSynchronizationProviderCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public long getConnectionTimeout() {
      return impl.getPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setConnectionTimeout(Long value) {
      impl.setPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition(), value);
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
    public Integer getNumUpdateReplayThreads() {
      return impl.getPropertyValue(INSTANCE.getNumUpdateReplayThreadsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setNumUpdateReplayThreads(Integer value) {
      impl.setPropertyValue(INSTANCE.getNumUpdateReplayThreadsPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String[] listReplicationDomains() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getReplicationDomainsRelationDefinition());
    }



    /** {@inheritDoc} */
    public ReplicationDomainCfgClient getReplicationDomain(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getReplicationDomainsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends ReplicationDomainCfgClient> M createReplicationDomain(
        ManagedObjectDefinition<M, ? extends ReplicationDomainCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getReplicationDomainsRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeReplicationDomain(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getReplicationDomainsRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public boolean hasReplicationServer() throws ConcurrentModificationException,
        LdapException {
      return impl.hasChild(INSTANCE.getReplicationServerRelationDefinition());
    }



    /** {@inheritDoc} */
    public ReplicationServerCfgClient getReplicationServer()
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getReplicationServerRelationDefinition()).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends ReplicationServerCfgClient> M createReplicationServer(
        ManagedObjectDefinition<M, ? extends ReplicationServerCfg> d, Collection<PropertyException> exceptions) {
      return impl.createChild(INSTANCE.getReplicationServerRelationDefinition(), d, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removeReplicationServer()
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getReplicationServerRelationDefinition());
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends ReplicationSynchronizationProviderCfgClient, ? extends ReplicationSynchronizationProviderCfg> definition() {
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
  private static class ReplicationSynchronizationProviderCfgServerImpl implements
    ReplicationSynchronizationProviderCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ReplicationSynchronizationProviderCfg> impl;

    /** The value of the "connection-timeout" property. */
    private final long pConnectionTimeout;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "num-update-replay-threads" property. */
    private final Integer pNumUpdateReplayThreads;



    /** Private constructor. */
    private ReplicationSynchronizationProviderCfgServerImpl(ServerManagedObject<? extends ReplicationSynchronizationProviderCfg> impl) {
      this.impl = impl;
      this.pConnectionTimeout = impl.getPropertyValue(INSTANCE.getConnectionTimeoutPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pNumUpdateReplayThreads = impl.getPropertyValue(INSTANCE.getNumUpdateReplayThreadsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addReplicationChangeListener(
        ConfigurationChangeListener<ReplicationSynchronizationProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationChangeListener(
        ConfigurationChangeListener<ReplicationSynchronizationProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<SynchronizationProviderCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<SynchronizationProviderCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public long getConnectionTimeout() {
      return pConnectionTimeout;
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
    public Integer getNumUpdateReplayThreads() {
      return pNumUpdateReplayThreads;
    }



    /** {@inheritDoc} */
    public String[] listReplicationDomains() {
      return impl.listChildren(INSTANCE.getReplicationDomainsRelationDefinition());
    }



    /** {@inheritDoc} */
    public ReplicationDomainCfg getReplicationDomain(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getReplicationDomainsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addReplicationDomainAddListener(
        ConfigurationAddListener<ReplicationDomainCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getReplicationDomainsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationDomainAddListener(
        ConfigurationAddListener<ReplicationDomainCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getReplicationDomainsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addReplicationDomainDeleteListener(
        ConfigurationDeleteListener<ReplicationDomainCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getReplicationDomainsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationDomainDeleteListener(
        ConfigurationDeleteListener<ReplicationDomainCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getReplicationDomainsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public boolean hasReplicationServer() {
      return impl.hasChild(INSTANCE.getReplicationServerRelationDefinition());
    }



    /** {@inheritDoc} */
    public ReplicationServerCfg getReplicationServer() throws ConfigException {
      return impl.getChild(INSTANCE.getReplicationServerRelationDefinition()).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addReplicationServerAddListener(
        ConfigurationAddListener<ReplicationServerCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getReplicationServerRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationServerAddListener(
        ConfigurationAddListener<ReplicationServerCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getReplicationServerRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addReplicationServerDeleteListener(
        ConfigurationDeleteListener<ReplicationServerCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getReplicationServerRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removeReplicationServerDeleteListener(
        ConfigurationDeleteListener<ReplicationServerCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getReplicationServerRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends ReplicationSynchronizationProviderCfg> configurationClass() {
      return ReplicationSynchronizationProviderCfg.class;
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
