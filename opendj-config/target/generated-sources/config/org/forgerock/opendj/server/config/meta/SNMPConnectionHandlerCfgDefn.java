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



import java.net.InetAddress;
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
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.IntegerPropertyDefinition;
import org.forgerock.opendj.config.IPAddressMaskPropertyDefinition;
import org.forgerock.opendj.config.IPAddressPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.SNMPConnectionHandlerCfgClient;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.SNMPConnectionHandlerCfg;



/**
 * An interface for querying the SNMP Connection Handler managed
 * object definition meta information.
 * <p>
 * The SNMP Connection Handler can be used to process SNMP requests to
 * retrieve monitoring information described by the MIB 2605. Supported
 * protocol are SNMP V1, V2c and V3.
 */
public final class SNMPConnectionHandlerCfgDefn extends ManagedObjectDefinition<SNMPConnectionHandlerCfgClient, SNMPConnectionHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final SNMPConnectionHandlerCfgDefn INSTANCE = new SNMPConnectionHandlerCfgDefn();



  /**
   * Defines the set of permissable values for the "security-level" property.
   * <p>
   * Specifies the type of security level : NoAuthNoPriv : No security
   * mechanisms activated, AuthNoPriv : Authentication activated with
   * no privacy, AuthPriv : Authentication with privacy activated. This
   * property is required for SNMP V3 security configuration.
   */
  public static enum SecurityLevel {

    /**
     * Authentication activated with no privacy.
     */
    AUTHNOPRIV("authnopriv"),



    /**
     * Authentication with privacy activated.
     */
    AUTHPRIV("authpriv"),



    /**
     * No security mechanisms activated.
     */
    NOAUTHNOPRIV("noauthnopriv");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private SecurityLevel(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "allowed-manager" property definition. */
  private static final StringPropertyDefinition PD_ALLOWED_MANAGER;



  /** The "allowed-user" property definition. */
  private static final StringPropertyDefinition PD_ALLOWED_USER;



  /** The "community" property definition. */
  private static final StringPropertyDefinition PD_COMMUNITY;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "listen-address" property definition. */
  private static final IPAddressPropertyDefinition PD_LISTEN_ADDRESS;



  /** The "listen-port" property definition. */
  private static final IntegerPropertyDefinition PD_LISTEN_PORT;



  /** The "opendmk-jarfile" property definition. */
  private static final StringPropertyDefinition PD_OPENDMK_JARFILE;



  /** The "registered-mbean" property definition. */
  private static final BooleanPropertyDefinition PD_REGISTERED_MBEAN;



  /** The "security-agent-file" property definition. */
  private static final StringPropertyDefinition PD_SECURITY_AGENT_FILE;



  /** The "security-level" property definition. */
  private static final EnumPropertyDefinition<SecurityLevel> PD_SECURITY_LEVEL;



  /** The "trap-port" property definition. */
  private static final IntegerPropertyDefinition PD_TRAP_PORT;



  /** The "traps-community" property definition. */
  private static final StringPropertyDefinition PD_TRAPS_COMMUNITY;



  /** The "traps-destination" property definition. */
  private static final StringPropertyDefinition PD_TRAPS_DESTINATION;



  /** Build the "allowed-manager" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "allowed-manager");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "allowed-manager"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("*");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOWED_MANAGER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOWED_MANAGER);
  }



  /** Build the "allowed-user" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "allowed-user");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "allowed-user"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("*");
      builder.setDefaultBehaviorProvider(provider);
      PD_ALLOWED_USER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ALLOWED_USER);
  }



  /** Build the "community" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "community");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "community"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("OpenDJ");
      builder.setDefaultBehaviorProvider(provider);
      PD_COMMUNITY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_COMMUNITY);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.snmp.SNMPConnectionHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.ConnectionHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "listen-address" property definition. */
  static {
      IPAddressPropertyDefinition.Builder builder = IPAddressPropertyDefinition.createBuilder(INSTANCE, "listen-address");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.READ_ONLY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.SERVER_RESTART, INSTANCE, "listen-address"));
      DefaultBehaviorProvider<InetAddress> provider = new DefinedDefaultBehaviorProvider<InetAddress>("0.0.0.0");
      builder.setDefaultBehaviorProvider(provider);
      PD_LISTEN_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LISTEN_ADDRESS);
  }



  /** Build the "listen-port" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "listen-port");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "listen-port"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      builder.setUpperLimit(65535);
      builder.setLowerLimit(1);
      PD_LISTEN_PORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_LISTEN_PORT);
  }



  /** Build the "opendmk-jarfile" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "opendmk-jarfile");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "opendmk-jarfile"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_OPENDMK_JARFILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_OPENDMK_JARFILE);
  }



  /** Build the "registered-mbean" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "registered-mbean");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "registered-mbean"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_REGISTERED_MBEAN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REGISTERED_MBEAN);
  }



  /** Build the "security-agent-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "security-agent-file");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "security-agent-file"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("config/snmp/security/opendj-snmp.security");
      builder.setDefaultBehaviorProvider(provider);
      PD_SECURITY_AGENT_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SECURITY_AGENT_FILE);
  }



  /** Build the "security-level" property definition. */
  static {
      EnumPropertyDefinition.Builder<SecurityLevel> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "security-level");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "security-level"));
      DefaultBehaviorProvider<SecurityLevel> provider = new DefinedDefaultBehaviorProvider<SecurityLevel>("authnopriv");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(SecurityLevel.class);
      PD_SECURITY_LEVEL = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SECURITY_LEVEL);
  }



  /** Build the "trap-port" property definition. */
  static {
      IntegerPropertyDefinition.Builder builder = IntegerPropertyDefinition.createBuilder(INSTANCE, "trap-port");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "trap-port"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Integer>());
      PD_TRAP_PORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRAP_PORT);
  }



  /** Build the "traps-community" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "traps-community");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "traps-community"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("OpenDJ");
      builder.setDefaultBehaviorProvider(provider);
      PD_TRAPS_COMMUNITY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRAPS_COMMUNITY);
  }



  /** Build the "traps-destination" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "traps-destination");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "traps-destination"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "traps-destination"));
      PD_TRAPS_DESTINATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_TRAPS_DESTINATION);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the SNMP Connection Handler configuration definition
   * singleton.
   *
   * @return Returns the SNMP Connection Handler configuration
   *         definition singleton.
   */
  public static SNMPConnectionHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SNMPConnectionHandlerCfgDefn() {
    super("snmp-connection-handler", ConnectionHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SNMPConnectionHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends SNMPConnectionHandlerCfgClient> impl) {
    return new SNMPConnectionHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SNMPConnectionHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends SNMPConnectionHandlerCfg> impl) {
    return new SNMPConnectionHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SNMPConnectionHandlerCfg> getServerConfigurationClass() {
    return SNMPConnectionHandlerCfg.class;
  }



  /**
   * Get the "allowed-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are allowed to establish connections to this SNMP
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the "allowed-client" property definition.
   */
  public IPAddressMaskPropertyDefinition getAllowedClientPropertyDefinition() {
    return ConnectionHandlerCfgDefn.getInstance().getAllowedClientPropertyDefinition();
  }



  /**
   * Get the "allowed-manager" property definition.
   * <p>
   * Specifies the hosts of the managers to be granted the access
   * rights. This property is required for SNMP v1 and v2 security
   * configuration. An asterisk (*) opens access to all managers.
   *
   * @return Returns the "allowed-manager" property definition.
   */
  public StringPropertyDefinition getAllowedManagerPropertyDefinition() {
    return PD_ALLOWED_MANAGER;
  }



  /**
   * Get the "allowed-user" property definition.
   * <p>
   * Specifies the users to be granted the access rights. This
   * property is required for SNMP v3 security configuration. An
   * asterisk (*) opens access to all users.
   *
   * @return Returns the "allowed-user" property definition.
   */
  public StringPropertyDefinition getAllowedUserPropertyDefinition() {
    return PD_ALLOWED_USER;
  }



  /**
   * Get the "community" property definition.
   * <p>
   * Specifies the v1,v2 community or the v3 context name allowed to
   * access the MIB 2605 monitoring information or the USM MIB. The
   * mapping between "community" and "context name" is set.
   *
   * @return Returns the "community" property definition.
   */
  public StringPropertyDefinition getCommunityPropertyDefinition() {
    return PD_COMMUNITY;
  }



  /**
   * Get the "denied-client" property definition.
   * <p>
   * Specifies a set of host names or address masks that determine the
   * clients that are not allowed to establish connections to this SNMP
   * Connection Handler.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask. If both allowed and denied client masks are defined and a
   * client connection matches one or more masks in both lists, then
   * the connection is denied. If only a denied list is specified, then
   * any client not matching a mask in that list is allowed.
   *
   * @return Returns the "denied-client" property definition.
   */
  public IPAddressMaskPropertyDefinition getDeniedClientPropertyDefinition() {
    return ConnectionHandlerCfgDefn.getInstance().getDeniedClientPropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SNMP Connection Handler is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return ConnectionHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SNMP Connection Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "listen-address" property definition.
   * <p>
   * Specifies the address or set of addresses on which this SNMP
   * Connection Handler should listen for connections from SNMP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the SNMP Connection
   * Handler listens on all interfaces.
   *
   * @return Returns the "listen-address" property definition.
   */
  public IPAddressPropertyDefinition getListenAddressPropertyDefinition() {
    return PD_LISTEN_ADDRESS;
  }



  /**
   * Get the "listen-port" property definition.
   * <p>
   * Specifies the port number on which the SNMP Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the "listen-port" property definition.
   */
  public IntegerPropertyDefinition getListenPortPropertyDefinition() {
    return PD_LISTEN_PORT;
  }



  /**
   * Get the "opendmk-jarfile" property definition.
   * <p>
   * Indicates the OpenDMK runtime jar file location
   *
   * @return Returns the "opendmk-jarfile" property definition.
   */
  public StringPropertyDefinition getOpendmkJarfilePropertyDefinition() {
    return PD_OPENDMK_JARFILE;
  }



  /**
   * Get the "registered-mbean" property definition.
   * <p>
   * Indicates whether the SNMP objects have to be registered in the
   * directory server MBeanServer or not allowing to access SNMP
   * Objects with RMI connector if enabled.
   *
   * @return Returns the "registered-mbean" property definition.
   */
  public BooleanPropertyDefinition getRegisteredMbeanPropertyDefinition() {
    return PD_REGISTERED_MBEAN;
  }



  /**
   * Get the "security-agent-file" property definition.
   * <p>
   * Specifies the USM security configuration to receive authenticated
   * only SNMP requests.
   *
   * @return Returns the "security-agent-file" property definition.
   */
  public StringPropertyDefinition getSecurityAgentFilePropertyDefinition() {
    return PD_SECURITY_AGENT_FILE;
  }



  /**
   * Get the "security-level" property definition.
   * <p>
   * Specifies the type of security level : NoAuthNoPriv : No security
   * mechanisms activated, AuthNoPriv : Authentication activated with
   * no privacy, AuthPriv : Authentication with privacy activated. This
   * property is required for SNMP V3 security configuration.
   *
   * @return Returns the "security-level" property definition.
   */
  public EnumPropertyDefinition<SecurityLevel> getSecurityLevelPropertyDefinition() {
    return PD_SECURITY_LEVEL;
  }



  /**
   * Get the "trap-port" property definition.
   * <p>
   * Specifies the port to use to send SNMP Traps.
   *
   * @return Returns the "trap-port" property definition.
   */
  public IntegerPropertyDefinition getTrapPortPropertyDefinition() {
    return PD_TRAP_PORT;
  }



  /**
   * Get the "traps-community" property definition.
   * <p>
   * Specifies the community string that must be included in the traps
   * sent to define managers (trap-destinations). This property is used
   * in the context of SNMP v1, v2 and v3.
   *
   * @return Returns the "traps-community" property definition.
   */
  public StringPropertyDefinition getTrapsCommunityPropertyDefinition() {
    return PD_TRAPS_COMMUNITY;
  }



  /**
   * Get the "traps-destination" property definition.
   * <p>
   * Specifies the hosts to which V1 traps will be sent. V1 Traps are
   * sent to every host listed.
   * <p>
   * If this list is empty, V1 traps are sent to "localhost". Each
   * host in the list must be identifed by its name or complete IP
   * Addess.
   *
   * @return Returns the "traps-destination" property definition.
   */
  public StringPropertyDefinition getTrapsDestinationPropertyDefinition() {
    return PD_TRAPS_DESTINATION;
  }



  /**
   * Managed object client implementation.
   */
  private static class SNMPConnectionHandlerCfgClientImpl implements
    SNMPConnectionHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SNMPConnectionHandlerCfgClient> impl;



    /** Private constructor. */
    private SNMPConnectionHandlerCfgClientImpl(
        ManagedObject<? extends SNMPConnectionHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getAllowedClient() {
      return impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowedClient(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getAllowedClientPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedManager() {
      return impl.getPropertyValues(INSTANCE.getAllowedManagerPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowedManager(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getAllowedManagerPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedUser() {
      return impl.getPropertyValues(INSTANCE.getAllowedUserPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setAllowedUser(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getAllowedUserPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public String getCommunity() {
      return impl.getPropertyValue(INSTANCE.getCommunityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCommunity(String value) {
      impl.setPropertyValue(INSTANCE.getCommunityPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getDeniedClient() {
      return impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDeniedClient(Collection<AddressMask> values) {
      impl.setPropertyValues(INSTANCE.getDeniedClientPropertyDefinition(), values);
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
    public SortedSet<InetAddress> getListenAddress() {
      return impl.getPropertyValues(INSTANCE.getListenAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setListenAddress(Collection<InetAddress> values) throws PropertyException {
      impl.setPropertyValues(INSTANCE.getListenAddressPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public Integer getListenPort() {
      return impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setListenPort(int value) {
      impl.setPropertyValue(INSTANCE.getListenPortPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getOpendmkJarfile() {
      return impl.getPropertyValue(INSTANCE.getOpendmkJarfilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setOpendmkJarfile(String value) {
      impl.setPropertyValue(INSTANCE.getOpendmkJarfilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isRegisteredMbean() {
      return impl.getPropertyValue(INSTANCE.getRegisteredMbeanPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRegisteredMbean(Boolean value) {
      impl.setPropertyValue(INSTANCE.getRegisteredMbeanPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getSecurityAgentFile() {
      return impl.getPropertyValue(INSTANCE.getSecurityAgentFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSecurityAgentFile(String value) {
      impl.setPropertyValue(INSTANCE.getSecurityAgentFilePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SecurityLevel getSecurityLevel() {
      return impl.getPropertyValue(INSTANCE.getSecurityLevelPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSecurityLevel(SecurityLevel value) {
      impl.setPropertyValue(INSTANCE.getSecurityLevelPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public Integer getTrapPort() {
      return impl.getPropertyValue(INSTANCE.getTrapPortPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrapPort(int value) {
      impl.setPropertyValue(INSTANCE.getTrapPortPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getTrapsCommunity() {
      return impl.getPropertyValue(INSTANCE.getTrapsCommunityPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrapsCommunity(String value) {
      impl.setPropertyValue(INSTANCE.getTrapsCommunityPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getTrapsDestination() {
      return impl.getPropertyValues(INSTANCE.getTrapsDestinationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setTrapsDestination(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getTrapsDestinationPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SNMPConnectionHandlerCfgClient, ? extends SNMPConnectionHandlerCfg> definition() {
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
  private static class SNMPConnectionHandlerCfgServerImpl implements
    SNMPConnectionHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SNMPConnectionHandlerCfg> impl;

    /** The value of the "allowed-client" property. */
    private final SortedSet<AddressMask> pAllowedClient;

    /** The value of the "allowed-manager" property. */
    private final SortedSet<String> pAllowedManager;

    /** The value of the "allowed-user" property. */
    private final SortedSet<String> pAllowedUser;

    /** The value of the "community" property. */
    private final String pCommunity;

    /** The value of the "denied-client" property. */
    private final SortedSet<AddressMask> pDeniedClient;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "listen-address" property. */
    private final SortedSet<InetAddress> pListenAddress;

    /** The value of the "listen-port" property. */
    private final int pListenPort;

    /** The value of the "opendmk-jarfile" property. */
    private final String pOpendmkJarfile;

    /** The value of the "registered-mbean" property. */
    private final boolean pRegisteredMbean;

    /** The value of the "security-agent-file" property. */
    private final String pSecurityAgentFile;

    /** The value of the "security-level" property. */
    private final SecurityLevel pSecurityLevel;

    /** The value of the "trap-port" property. */
    private final int pTrapPort;

    /** The value of the "traps-community" property. */
    private final String pTrapsCommunity;

    /** The value of the "traps-destination" property. */
    private final SortedSet<String> pTrapsDestination;



    /** Private constructor. */
    private SNMPConnectionHandlerCfgServerImpl(ServerManagedObject<? extends SNMPConnectionHandlerCfg> impl) {
      this.impl = impl;
      this.pAllowedClient = impl.getPropertyValues(INSTANCE.getAllowedClientPropertyDefinition());
      this.pAllowedManager = impl.getPropertyValues(INSTANCE.getAllowedManagerPropertyDefinition());
      this.pAllowedUser = impl.getPropertyValues(INSTANCE.getAllowedUserPropertyDefinition());
      this.pCommunity = impl.getPropertyValue(INSTANCE.getCommunityPropertyDefinition());
      this.pDeniedClient = impl.getPropertyValues(INSTANCE.getDeniedClientPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pListenAddress = impl.getPropertyValues(INSTANCE.getListenAddressPropertyDefinition());
      this.pListenPort = impl.getPropertyValue(INSTANCE.getListenPortPropertyDefinition());
      this.pOpendmkJarfile = impl.getPropertyValue(INSTANCE.getOpendmkJarfilePropertyDefinition());
      this.pRegisteredMbean = impl.getPropertyValue(INSTANCE.getRegisteredMbeanPropertyDefinition());
      this.pSecurityAgentFile = impl.getPropertyValue(INSTANCE.getSecurityAgentFilePropertyDefinition());
      this.pSecurityLevel = impl.getPropertyValue(INSTANCE.getSecurityLevelPropertyDefinition());
      this.pTrapPort = impl.getPropertyValue(INSTANCE.getTrapPortPropertyDefinition());
      this.pTrapsCommunity = impl.getPropertyValue(INSTANCE.getTrapsCommunityPropertyDefinition());
      this.pTrapsDestination = impl.getPropertyValues(INSTANCE.getTrapsDestinationPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSNMPChangeListener(
        ConfigurationChangeListener<SNMPConnectionHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSNMPChangeListener(
        ConfigurationChangeListener<SNMPConnectionHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<ConnectionHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<ConnectionHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getAllowedClient() {
      return pAllowedClient;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedManager() {
      return pAllowedManager;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getAllowedUser() {
      return pAllowedUser;
    }



    /** {@inheritDoc} */
    public String getCommunity() {
      return pCommunity;
    }



    /** {@inheritDoc} */
    public SortedSet<AddressMask> getDeniedClient() {
      return pDeniedClient;
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
    public SortedSet<InetAddress> getListenAddress() {
      return pListenAddress;
    }



    /** {@inheritDoc} */
    public int getListenPort() {
      return pListenPort;
    }



    /** {@inheritDoc} */
    public String getOpendmkJarfile() {
      return pOpendmkJarfile;
    }



    /** {@inheritDoc} */
    public boolean isRegisteredMbean() {
      return pRegisteredMbean;
    }



    /** {@inheritDoc} */
    public String getSecurityAgentFile() {
      return pSecurityAgentFile;
    }



    /** {@inheritDoc} */
    public SecurityLevel getSecurityLevel() {
      return pSecurityLevel;
    }



    /** {@inheritDoc} */
    public int getTrapPort() {
      return pTrapPort;
    }



    /** {@inheritDoc} */
    public String getTrapsCommunity() {
      return pTrapsCommunity;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getTrapsDestination() {
      return pTrapsDestination;
    }



    /** {@inheritDoc} */
    public Class<? extends SNMPConnectionHandlerCfg> configurationClass() {
      return SNMPConnectionHandlerCfg.class;
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
