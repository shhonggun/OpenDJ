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
import org.forgerock.opendj.config.EnumPropertyDefinition;
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
import org.forgerock.opendj.server.config.client.PluginCfgClient;
import org.forgerock.opendj.server.config.server.PluginCfg;



/**
 * An interface for querying the Plugin managed object definition meta
 * information.
 * <p>
 * Plugins provide a mechanism for executing custom code at specified
 * points in operation processing and in the course of other events
 * like connection establishment and termination, server startup and
 * shutdown, and LDIF import and export.
 */
public final class PluginCfgDefn extends ManagedObjectDefinition<PluginCfgClient, PluginCfg> {

  /** The singleton configuration definition instance. */
  private static final PluginCfgDefn INSTANCE = new PluginCfgDefn();



  /**
   * Defines the set of permissable values for the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   */
  public static enum PluginType {

    /**
     * Invoked before sending an intermediate repsonse message to the
     * client.
     */
    INTERMEDIATERESPONSE("intermediateresponse"),



    /**
     * Invoked for each operation to be written during an LDIF export.
     */
    LDIFEXPORT("ldifexport"),



    /**
     * Invoked for each entry read during an LDIF import.
     */
    LDIFIMPORT("ldifimport"),



    /**
     * Invoked at the beginning of an LDIF import session.
     */
    LDIFIMPORTBEGIN("ldifimportbegin"),



    /**
     * Invoked at the end of an LDIF import session.
     */
    LDIFIMPORTEND("ldifimportend"),



    /**
     * Invoked whenever a new connection is established to the server.
     */
    POSTCONNECT("postconnect"),



    /**
     * Invoked whenever an existing connection is terminated (by
     * either the client or the server).
     */
    POSTDISCONNECT("postdisconnect"),



    /**
     * Invoked after completing the abandon processing.
     */
    POSTOPERATIONABANDON("postoperationabandon"),



    /**
     * Invoked after completing the core add processing but before
     * sending the response to the client.
     */
    POSTOPERATIONADD("postoperationadd"),



    /**
     * Invoked after completing the core bind processing but before
     * sending the response to the client.
     */
    POSTOPERATIONBIND("postoperationbind"),



    /**
     * Invoked after completing the core compare processing but before
     * sending the response to the client.
     */
    POSTOPERATIONCOMPARE("postoperationcompare"),



    /**
     * Invoked after completing the core delete processing but before
     * sending the response to the client.
     */
    POSTOPERATIONDELETE("postoperationdelete"),



    /**
     * Invoked after completing the core extended processing but
     * before sending the response to the client.
     */
    POSTOPERATIONEXTENDED("postoperationextended"),



    /**
     * Invoked after completing the core modify processing but before
     * sending the response to the client.
     */
    POSTOPERATIONMODIFY("postoperationmodify"),



    /**
     * Invoked after completing the core modify DN processing but
     * before sending the response to the client.
     */
    POSTOPERATIONMODIFYDN("postoperationmodifydn"),



    /**
     * Invoked after completing the core search processing but before
     * sending the response to the client.
     */
    POSTOPERATIONSEARCH("postoperationsearch"),



    /**
     * Invoked after completing the unbind processing.
     */
    POSTOPERATIONUNBIND("postoperationunbind"),



    /**
     * Invoked after sending the add response to the client.
     */
    POSTRESPONSEADD("postresponseadd"),



    /**
     * Invoked after sending the bind response to the client.
     */
    POSTRESPONSEBIND("postresponsebind"),



    /**
     * Invoked after sending the compare response to the client.
     */
    POSTRESPONSECOMPARE("postresponsecompare"),



    /**
     * Invoked after sending the delete response to the client.
     */
    POSTRESPONSEDELETE("postresponsedelete"),



    /**
     * Invoked after sending the extended response to the client.
     */
    POSTRESPONSEEXTENDED("postresponseextended"),



    /**
     * Invoked after sending the modify response to the client.
     */
    POSTRESPONSEMODIFY("postresponsemodify"),



    /**
     * Invoked after sending the modify DN response to the client.
     */
    POSTRESPONSEMODIFYDN("postresponsemodifydn"),



    /**
     * Invoked after sending the search result done message to the
     * client.
     */
    POSTRESPONSESEARCH("postresponsesearch"),



    /**
     * Invoked after completing post-synchronization processing for an
     * add operation.
     */
    POSTSYNCHRONIZATIONADD("postsynchronizationadd"),



    /**
     * Invoked after completing post-synchronization processing for a
     * delete operation.
     */
    POSTSYNCHRONIZATIONDELETE("postsynchronizationdelete"),



    /**
     * Invoked after completing post-synchronization processing for a
     * modify operation.
     */
    POSTSYNCHRONIZATIONMODIFY("postsynchronizationmodify"),



    /**
     * Invoked after completing post-synchronization processing for a
     * modify DN operation.
     */
    POSTSYNCHRONIZATIONMODIFYDN("postsynchronizationmodifydn"),



    /**
     * Invoked prior to performing the core add processing.
     */
    PREOPERATIONADD("preoperationadd"),



    /**
     * Invoked prior to performing the core bind processing.
     */
    PREOPERATIONBIND("preoperationbind"),



    /**
     * Invoked prior to performing the core compare processing.
     */
    PREOPERATIONCOMPARE("preoperationcompare"),



    /**
     * Invoked prior to performing the core delete processing.
     */
    PREOPERATIONDELETE("preoperationdelete"),



    /**
     * Invoked prior to performing the core extended processing.
     */
    PREOPERATIONEXTENDED("preoperationextended"),



    /**
     * Invoked prior to performing the core modify processing.
     */
    PREOPERATIONMODIFY("preoperationmodify"),



    /**
     * Invoked prior to performing the core modify DN processing.
     */
    PREOPERATIONMODIFYDN("preoperationmodifydn"),



    /**
     * Invoked prior to performing the core search processing.
     */
    PREOPERATIONSEARCH("preoperationsearch"),



    /**
     * Invoked prior to parsing an abandon request.
     */
    PREPARSEABANDON("preparseabandon"),



    /**
     * Invoked prior to parsing an add request.
     */
    PREPARSEADD("preparseadd"),



    /**
     * Invoked prior to parsing a bind request.
     */
    PREPARSEBIND("preparsebind"),



    /**
     * Invoked prior to parsing a compare request.
     */
    PREPARSECOMPARE("preparsecompare"),



    /**
     * Invoked prior to parsing a delete request.
     */
    PREPARSEDELETE("preparsedelete"),



    /**
     * Invoked prior to parsing an extended request.
     */
    PREPARSEEXTENDED("preparseextended"),



    /**
     * Invoked prior to parsing a modify request.
     */
    PREPARSEMODIFY("preparsemodify"),



    /**
     * Invoked prior to parsing a modify DN request.
     */
    PREPARSEMODIFYDN("preparsemodifydn"),



    /**
     * Invoked prior to parsing a search request.
     */
    PREPARSESEARCH("preparsesearch"),



    /**
     * Invoked prior to parsing an unbind request.
     */
    PREPARSEUNBIND("preparseunbind"),



    /**
     * Invoked before sending a search result entry to the client.
     */
    SEARCHRESULTENTRY("searchresultentry"),



    /**
     * Invoked before sending a search result reference to the client.
     */
    SEARCHRESULTREFERENCE("searchresultreference"),



    /**
     * Invoked during a graceful directory server shutdown.
     */
    SHUTDOWN("shutdown"),



    /**
     * Invoked during the directory server startup process.
     */
    STARTUP("startup"),



    /**
     * Invoked in the course of deleting a subordinate entry of a
     * delete operation.
     */
    SUBORDINATEDELETE("subordinatedelete"),



    /**
     * Invoked in the course of moving or renaming an entry
     * subordinate to the target of a modify DN operation.
     */
    SUBORDINATEMODIFYDN("subordinatemodifydn");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private PluginType(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ENABLED;



  /** The "invoke-for-internal-operations" property definition. */
  private static final BooleanPropertyDefinition PD_INVOKE_FOR_INTERNAL_OPERATIONS;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "plugin-type" property definition. */
  private static final EnumPropertyDefinition<PluginType> PD_PLUGIN_TYPE;



  /** Build the "enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "enabled"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Boolean>());
      PD_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ENABLED);
  }



  /** Build the "invoke-for-internal-operations" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "invoke-for-internal-operations");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "invoke-for-internal-operations"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_INVOKE_FOR_INTERNAL_OPERATIONS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_INVOKE_FOR_INTERNAL_OPERATIONS);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.plugin.DirectoryServerPlugin");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "plugin-type" property definition. */
  static {
      EnumPropertyDefinition.Builder<PluginType> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "plugin-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "plugin-type"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<PluginType>());
      builder.setEnumClass(PluginType.class);
      PD_PLUGIN_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_TYPE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Plugin configuration definition singleton.
   *
   * @return Returns the Plugin configuration definition singleton.
   */
  public static PluginCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PluginCfgDefn() {
    super("plugin", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PluginCfgClient createClientConfiguration(
      ManagedObject<? extends PluginCfgClient> impl) {
    return new PluginCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PluginCfg createServerConfiguration(
      ServerManagedObject<? extends PluginCfg> impl) {
    return new PluginCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PluginCfg> getServerConfigurationClass() {
    return PluginCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the plug-in is enabled for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PD_ENABLED;
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
    return PD_INVOKE_FOR_INTERNAL_OPERATIONS;
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
    return PD_JAVA_CLASS;
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
    return PD_PLUGIN_TYPE;
  }



  /**
   * Managed object client implementation.
   */
  private static class PluginCfgClientImpl implements
    PluginCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PluginCfgClient> impl;



    /** Private constructor. */
    private PluginCfgClientImpl(
        ManagedObject<? extends PluginCfgClient> impl) {
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
    public ManagedObjectDefinition<? extends PluginCfgClient, ? extends PluginCfg> definition() {
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
  private static class PluginCfgServerImpl implements
    PluginCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PluginCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "invoke-for-internal-operations" property. */
    private final boolean pInvokeForInternalOperations;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "plugin-type" property. */
    private final SortedSet<PluginType> pPluginType;



    /** Private constructor. */
    private PluginCfgServerImpl(ServerManagedObject<? extends PluginCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pInvokeForInternalOperations = impl.getPropertyValue(INSTANCE.getInvokeForInternalOperationsPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pPluginType = impl.getPropertyValues(INSTANCE.getPluginTypePropertyDefinition());
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
    public Class<? extends PluginCfg> configurationClass() {
      return PluginCfg.class;
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
