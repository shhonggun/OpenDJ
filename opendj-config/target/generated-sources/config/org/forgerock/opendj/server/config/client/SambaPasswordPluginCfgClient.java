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
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.PluginCfgDefn.PluginType;
import org.forgerock.opendj.server.config.meta.SambaPasswordPluginCfgDefn.PwdSyncPolicy;
import org.forgerock.opendj.server.config.server.SambaPasswordPluginCfg;



/**
 * A client-side interface for reading and modifying Samba Password
 * Plugin settings.
 * <p>
 * Samba Password Synchronization Plugin.
 */
public interface SambaPasswordPluginCfgClient extends PluginCfgClient {

  /**
   * Get the configuration definition associated with this Samba Password Plugin.
   *
   * @return Returns the configuration definition associated with this Samba Password Plugin.
   */
  ManagedObjectDefinition<? extends SambaPasswordPluginCfgClient, ? extends SambaPasswordPluginCfg> definition();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the plug-in implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @return Returns the values of the "plugin-type" property.
   */
  SortedSet<PluginType> getPluginType();



  /**
   * Sets the "plugin-type" property.
   * <p>
   * Specifies the set of plug-in types for the plug-in, which
   * specifies the times at which the plug-in is invoked.
   *
   * @param values The values of the "plugin-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPluginType(Collection<PluginType> values) throws PropertyException;



  /**
   * Gets the "pwd-sync-policy" property.
   * <p>
   * Specifies which Samba passwords should be kept synchronized.
   *
   * @return Returns the values of the "pwd-sync-policy" property.
   */
  SortedSet<PwdSyncPolicy> getPwdSyncPolicy();



  /**
   * Sets the "pwd-sync-policy" property.
   * <p>
   * Specifies which Samba passwords should be kept synchronized.
   *
   * @param values The values of the "pwd-sync-policy" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setPwdSyncPolicy(Collection<PwdSyncPolicy> values) throws PropertyException;



  /**
   * Gets the "samba-administrator-dn" property.
   * <p>
   * Specifies the distinguished name of the user which Samba uses to
   * perform Password Modify extended operations against this directory
   * server in order to synchronize the userPassword attribute after
   * the LanMan or NT passwords have been updated.
   * <p>
   * The user must have the 'password-reset' privilege and should not
   * be a root user. This user name can be used in order to identify
   * Samba connections and avoid double re-synchronization of the same
   * password. If this property is left undefined, then no password
   * updates will be skipped.
   *
   * @return Returns the value of the "samba-administrator-dn" property.
   */
  DN getSambaAdministratorDN();



  /**
   * Sets the "samba-administrator-dn" property.
   * <p>
   * Specifies the distinguished name of the user which Samba uses to
   * perform Password Modify extended operations against this directory
   * server in order to synchronize the userPassword attribute after
   * the LanMan or NT passwords have been updated.
   * <p>
   * The user must have the 'password-reset' privilege and should not
   * be a root user. This user name can be used in order to identify
   * Samba connections and avoid double re-synchronization of the same
   * password. If this property is left undefined, then no password
   * updates will be skipped.
   *
   * @param value The value of the "samba-administrator-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSambaAdministratorDN(DN value) throws PropertyException;

}
