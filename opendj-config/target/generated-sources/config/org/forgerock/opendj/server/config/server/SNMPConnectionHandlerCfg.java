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
package org.forgerock.opendj.server.config.server;



import java.net.InetAddress;
import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.meta.SNMPConnectionHandlerCfgDefn.SecurityLevel;



/**
 * A server-side interface for querying SNMP Connection Handler
 * settings.
 * <p>
 * The SNMP Connection Handler can be used to process SNMP requests to
 * retrieve monitoring information described by the MIB 2605. Supported
 * protocol are SNMP V1, V2c and V3.
 */
public interface SNMPConnectionHandlerCfg extends ConnectionHandlerCfg {

  /**
   * Gets the configuration class associated with this SNMP Connection Handler.
   *
   * @return Returns the configuration class associated with this SNMP Connection Handler.
   */
  Class<? extends SNMPConnectionHandlerCfg> configurationClass();



  /**
   * Register to be notified when this SNMP Connection Handler is changed.
   *
   * @param listener
   *          The SNMP Connection Handler configuration change listener.
   */
  void addSNMPChangeListener(ConfigurationChangeListener<SNMPConnectionHandlerCfg> listener);



  /**
   * Deregister an existing SNMP Connection Handler configuration change listener.
   *
   * @param listener
   *          The SNMP Connection Handler configuration change listener.
   */
  void removeSNMPChangeListener(ConfigurationChangeListener<SNMPConnectionHandlerCfg> listener);



  /**
   * Gets the "allowed-manager" property.
   * <p>
   * Specifies the hosts of the managers to be granted the access
   * rights. This property is required for SNMP v1 and v2 security
   * configuration. An asterisk (*) opens access to all managers.
   *
   * @return Returns an unmodifiable set containing the values of the "allowed-manager" property.
   */
  SortedSet<String> getAllowedManager();



  /**
   * Gets the "allowed-user" property.
   * <p>
   * Specifies the users to be granted the access rights. This
   * property is required for SNMP v3 security configuration. An
   * asterisk (*) opens access to all users.
   *
   * @return Returns an unmodifiable set containing the values of the "allowed-user" property.
   */
  SortedSet<String> getAllowedUser();



  /**
   * Gets the "community" property.
   * <p>
   * Specifies the v1,v2 community or the v3 context name allowed to
   * access the MIB 2605 monitoring information or the USM MIB. The
   * mapping between "community" and "context name" is set.
   *
   * @return Returns the value of the "community" property.
   */
  String getCommunity();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SNMP Connection Handler implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "listen-address" property.
   * <p>
   * Specifies the address or set of addresses on which this SNMP
   * Connection Handler should listen for connections from SNMP
   * clients.
   * <p>
   * Multiple addresses may be provided as separate values for this
   * attribute. If no values are provided, then the SNMP Connection
   * Handler listens on all interfaces.
   *
   * @return Returns an unmodifiable set containing the values of the "listen-address" property.
   */
  SortedSet<InetAddress> getListenAddress();



  /**
   * Gets the "listen-port" property.
   * <p>
   * Specifies the port number on which the SNMP Connection Handler
   * will listen for connections from clients.
   * <p>
   * Only a single port number may be provided.
   *
   * @return Returns the value of the "listen-port" property.
   */
  int getListenPort();



  /**
   * Gets the "opendmk-jarfile" property.
   * <p>
   * Indicates the OpenDMK runtime jar file location
   *
   * @return Returns the value of the "opendmk-jarfile" property.
   */
  String getOpendmkJarfile();



  /**
   * Gets the "registered-mbean" property.
   * <p>
   * Indicates whether the SNMP objects have to be registered in the
   * directory server MBeanServer or not allowing to access SNMP
   * Objects with RMI connector if enabled.
   *
   * @return Returns the value of the "registered-mbean" property.
   */
  boolean isRegisteredMbean();



  /**
   * Gets the "security-agent-file" property.
   * <p>
   * Specifies the USM security configuration to receive authenticated
   * only SNMP requests.
   *
   * @return Returns the value of the "security-agent-file" property.
   */
  String getSecurityAgentFile();



  /**
   * Gets the "security-level" property.
   * <p>
   * Specifies the type of security level : NoAuthNoPriv : No security
   * mechanisms activated, AuthNoPriv : Authentication activated with
   * no privacy, AuthPriv : Authentication with privacy activated. This
   * property is required for SNMP V3 security configuration.
   *
   * @return Returns the value of the "security-level" property.
   */
  SecurityLevel getSecurityLevel();



  /**
   * Gets the "trap-port" property.
   * <p>
   * Specifies the port to use to send SNMP Traps.
   *
   * @return Returns the value of the "trap-port" property.
   */
  int getTrapPort();



  /**
   * Gets the "traps-community" property.
   * <p>
   * Specifies the community string that must be included in the traps
   * sent to define managers (trap-destinations). This property is used
   * in the context of SNMP v1, v2 and v3.
   *
   * @return Returns the value of the "traps-community" property.
   */
  String getTrapsCommunity();



  /**
   * Gets the "traps-destination" property.
   * <p>
   * Specifies the hosts to which V1 traps will be sent. V1 Traps are
   * sent to every host listed.
   * <p>
   * If this list is empty, V1 traps are sent to "localhost". Each
   * host in the list must be identifed by its name or complete IP
   * Addess.
   *
   * @return Returns an unmodifiable set containing the values of the "traps-destination" property.
   */
  SortedSet<String> getTrapsDestination();

}
