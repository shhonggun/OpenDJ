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
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.ExternalChangelogDomainCfgClient;
import org.forgerock.opendj.server.config.server.ExternalChangelogDomainCfg;



/**
 * An interface for querying the External Changelog Domain managed
 * object definition meta information.
 * <p>
 * The External Changelog Domain provides configuration of the
 * external changelog for the replication domain.
 */
public final class ExternalChangelogDomainCfgDefn extends ManagedObjectDefinition<ExternalChangelogDomainCfgClient, ExternalChangelogDomainCfg> {

  /** The singleton configuration definition instance. */
  private static final ExternalChangelogDomainCfgDefn INSTANCE = new ExternalChangelogDomainCfgDefn();



  /** The "ecl-include" property definition. */
  private static final StringPropertyDefinition PD_ECL_INCLUDE;



  /** The "ecl-include-for-deletes" property definition. */
  private static final StringPropertyDefinition PD_ECL_INCLUDE_FOR_DELETES;



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** Build the "ecl-include" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ecl-include");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ecl-include"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_ECL_INCLUDE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ECL_INCLUDE);
  }



  /** Build the "ecl-include-for-deletes" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "ecl-include-for-deletes");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "ecl-include-for-deletes"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_ECL_INCLUDE_FOR_DELETES = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ECL_INCLUDE_FOR_DELETES);
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



  /**
   * Get the External Changelog Domain configuration definition
   * singleton.
   *
   * @return Returns the External Changelog Domain configuration
   *         definition singleton.
   */
  public static ExternalChangelogDomainCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private ExternalChangelogDomainCfgDefn() {
    super("external-changelog-domain", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public ExternalChangelogDomainCfgClient createClientConfiguration(
      ManagedObject<? extends ExternalChangelogDomainCfgClient> impl) {
    return new ExternalChangelogDomainCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public ExternalChangelogDomainCfg createServerConfiguration(
      ServerManagedObject<? extends ExternalChangelogDomainCfg> impl) {
    return new ExternalChangelogDomainCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<ExternalChangelogDomainCfg> getServerConfigurationClass() {
    return ExternalChangelogDomainCfg.class;
  }



  /**
   * Get the "ecl-include" property definition.
   * <p>
   * Specifies a list of attributes which should be published with
   * every change log entry, regardless of whether the attribute itself
   * has changed.
   * <p>
   * The list of attributes may include wild cards such as "*" and "+"
   * as well as object class references prefixed with an ampersand, for
   * example "@person". The included attributes will be published using
   * the "includedAttributes" operational attribute as a single LDIF
   * value rather like the "changes" attribute. For modify and modifyDN
   * operations the included attributes will be taken from the entry
   * before any changes were applied.
   *
   * @return Returns the "ecl-include" property definition.
   */
  public StringPropertyDefinition getECLIncludePropertyDefinition() {
    return PD_ECL_INCLUDE;
  }



  /**
   * Get the "ecl-include-for-deletes" property definition.
   * <p>
   * Specifies a list of attributes which should be published with
   * every delete operation change log entry, in addition to those
   * specified by the "ecl-include" property.
   * <p>
   * This property provides a means for applications to archive
   * entries after they have been deleted. See the description of the
   * "ecl-include" property for further information about how the
   * included attributes are published.
   *
   * @return Returns the "ecl-include-for-deletes" property definition.
   */
  public StringPropertyDefinition getECLIncludeForDeletesPropertyDefinition() {
    return PD_ECL_INCLUDE_FOR_DELETES;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the External Changelog Domain is enabled. To
   * enable computing the change numbers, set the Replication Server's
   * "ds-cfg-compute-change-number" property to true.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
  }



  /**
   * Managed object client implementation.
   */
  private static class ExternalChangelogDomainCfgClientImpl implements
    ExternalChangelogDomainCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends ExternalChangelogDomainCfgClient> impl;



    /** Private constructor. */
    private ExternalChangelogDomainCfgClientImpl(
        ManagedObject<? extends ExternalChangelogDomainCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getECLInclude() {
      return impl.getPropertyValues(INSTANCE.getECLIncludePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setECLInclude(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getECLIncludePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getECLIncludeForDeletes() {
      return impl.getPropertyValues(INSTANCE.getECLIncludeForDeletesPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setECLIncludeForDeletes(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getECLIncludeForDeletesPropertyDefinition(), values);
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
    public ManagedObjectDefinition<? extends ExternalChangelogDomainCfgClient, ? extends ExternalChangelogDomainCfg> definition() {
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
  private static class ExternalChangelogDomainCfgServerImpl implements
    ExternalChangelogDomainCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends ExternalChangelogDomainCfg> impl;

    /** The value of the "ecl-include" property. */
    private final SortedSet<String> pECLInclude;

    /** The value of the "ecl-include-for-deletes" property. */
    private final SortedSet<String> pECLIncludeForDeletes;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;



    /** Private constructor. */
    private ExternalChangelogDomainCfgServerImpl(ServerManagedObject<? extends ExternalChangelogDomainCfg> impl) {
      this.impl = impl;
      this.pECLInclude = impl.getPropertyValues(INSTANCE.getECLIncludePropertyDefinition());
      this.pECLIncludeForDeletes = impl.getPropertyValues(INSTANCE.getECLIncludeForDeletesPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ExternalChangelogDomainCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ExternalChangelogDomainCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getECLInclude() {
      return pECLInclude;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getECLIncludeForDeletes() {
      return pECLIncludeForDeletes;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public Class<? extends ExternalChangelogDomainCfg> configurationClass() {
      return ExternalChangelogDomainCfg.class;
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
