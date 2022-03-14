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
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.FractionalLDIFImportPluginCfgClient;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.server.FractionalLDIFImportPluginCfg;
import org.forgerock.opendj.server.config.server.PluginCfg;



/**
 * An interface for querying the Fractional LDIF Import Plugin managed
 * object definition meta information.
 * <p>
 * The Fractional LDIF Import Plugin is used internally by the
 * replication plugin to support fractional replication.
 */
public final class FractionalLDIFImportPluginCfgDefn extends ManagedObjectDefinition<FractionalLDIFImportPluginCfgClient, FractionalLDIFImportPluginCfg> {

  /** The singleton configuration definition instance. */
  private static final FractionalLDIFImportPluginCfgDefn INSTANCE = new FractionalLDIFImportPluginCfgDefn();



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Fractional LDIF Import Plugin configuration definition
   * singleton.
   *
   * @return Returns the Fractional LDIF Import Plugin configuration
   *         definition singleton.
   */
  public static FractionalLDIFImportPluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private FractionalLDIFImportPluginCfgDefn() {
    super("fractional-ldif-import-plugin", PluginCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public FractionalLDIFImportPluginCfgClient createClientConfiguration(
      ManagedObject<? extends FractionalLDIFImportPluginCfgClient> impl) {
    return new FractionalLDIFImportPluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public FractionalLDIFImportPluginCfg createServerConfiguration(
      ServerManagedObject<? extends FractionalLDIFImportPluginCfg> impl) {
    return new FractionalLDIFImportPluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<FractionalLDIFImportPluginCfg> getServerConfigurationClass() {
    return FractionalLDIFImportPluginCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the plug-in is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PluginCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "invoke-for-internal-operations" property definition.
   * <p>
   * Indicates whether the plug-in should be invoked for internal
   * operations.
   * <p>
   * Any plug-in that can be invoked for internal operations must
   * ensure that it does not create any new internal operatons that can
   * cause the same plug-in to be re-invoked.
   *
   * @return Returns the "invoke-for-internal-operations" property definition.
   */
  public BooleanPropertyDefinition getInvokeForInternalOperationsPropertyDefinition() {
    return PluginCfgDefn.getInstance().getInvokeForInternalOperationsPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PluginCfgDefn.getInstance().getJavaClassPropertyDefinition();
  }



  /**
   * Get the "plugin-type" property definition.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the "plugin-type" property definition.
   */
  public EnumPropertyDefinition<PluginType> getPluginTypePropertyDefinition() {
    return PluginCfgDefn.getInstance().getPluginTypePropertyDefinition();
  }



  /**
   * Managed object client implementation.
   */
  private static class FractionalLDIFImportPluginCfgClientImpl implements
    FractionalLDIFImportPluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends FractionalLDIFImportPluginCfgClient> impl;



    /** Private constructor. */
    private FractionalLDIFImportPluginCfgClientImpl(
        ManagedObject<? extends FractionalLDIFImportPluginCfgClient> impl) {
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
    public boolean isInvokeForInternalOperations() {
      return impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setInvokeForInternalOperations(Boolean value) {
      impl.setPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition(), value);
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
    public SortedSet<PluginType> getPluginType() {
      return impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginType(Collection<PluginType> values) {
      impl.setPropertyValues(INSTANCE.getPluginTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends FractionalLDIFImportPluginCfgClient, ? extends FractionalLDIFImportPluginCfg> definition() {
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
  private static class FractionalLDIFImportPluginCfgServerImpl implements
    FractionalLDIFImportPluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends FractionalLDIFImportPluginCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;



    /** Private constructor. */
    private FractionalLDIFImportPluginCfgServerImpl(ServerManagedObject<? extends FractionalLDIFImportPluginCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addFractionalLDIFImportChangeListener(
        ConfigurationChangeListener<FractionalLDIFImportPluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeFractionalLDIFImportChangeListener(
        ConfigurationChangeListener<FractionalLDIFImportPluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PluginCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public boolean isInvokeForInternalOperations() {
      return pInvokeForInternalOperations;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public SortedSet<PluginType> getPluginType() {
      return pPluginType;
    }



    /** {@inheritDoc} */
    public Class<? extends FractionalLDIFImportPluginCfg> configurationClass() {
      return FractionalLDIFImportPluginCfg.class;
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
