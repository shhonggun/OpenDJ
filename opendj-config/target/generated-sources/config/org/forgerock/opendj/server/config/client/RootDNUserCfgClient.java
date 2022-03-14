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
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.server.RootDNUserCfg;



/**
 * A client-side interface for reading and modifying Root DN User
 * settings.
 * <p>
 * A Root DN User are administrative users who can granted special
 * privileges that are not available to non-root users (for example,
 * the ability to bind to the server in lockdown mode).
 */
public interface RootDNUserCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Root DN User.
   *
   * @return Returns the configuration definition associated with this Root DN User.
   */
  ManagedObjectDefinition<? extends RootDNUserCfgClient, ? extends RootDNUserCfg> definition();



  /**
   * Gets the "alternate-bind-dn" property.
   * <p>
   * Specifies one or more alternate DNs that can be used to bind to
   * the server as this root user.
   *
   * @return Returns the values of the "alternate-bind-dn" property.
   */
  SortedSet<DN> getAlternateBindDN();



  /**
   * Sets the "alternate-bind-dn" property.
   * <p>
   * Specifies one or more alternate DNs that can be used to bind to
   * the server as this root user.
   *
   * @param values The values of the "alternate-bind-dn" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setAlternateBindDN(Collection<DN> values) throws PropertyException;

}
