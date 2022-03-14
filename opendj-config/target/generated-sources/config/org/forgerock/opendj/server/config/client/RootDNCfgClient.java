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
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.meta.RootDNCfgDefn.DefaultRootPrivilegeName;
import org.forgerock.opendj.server.config.server.RootDNCfg;
import org.forgerock.opendj.server.config.server.RootDNUserCfg;



/**
 * A client-side interface for reading and modifying Root DN settings.
 * <p>
 * The Root DN configuration contains all the Root DN Users defined in
 * the directory server. In addition, it also defines the default set
 * of privileges that Root DN Users automatically inherit.
 */
public interface RootDNCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Root DN.
   *
   * @return Returns the configuration definition associated with this Root DN.
   */
  ManagedObjectDefinition<? extends RootDNCfgClient, ? extends RootDNCfg> definition();



  /**
   * Gets the "default-root-privilege-name" property.
   * <p>
   * Specifies the names of the privileges that root users will be
   * granted by default.
   *
   * @return Returns the values of the "default-root-privilege-name" property.
   */
  SortedSet<DefaultRootPrivilegeName> getDefaultRootPrivilegeName();



  /**
   * Sets the "default-root-privilege-name" property.
   * <p>
   * Specifies the names of the privileges that root users will be
   * granted by default.
   *
   * @param values The values of the "default-root-privilege-name" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setDefaultRootPrivilegeName(Collection<DefaultRootPrivilegeName> values) throws PropertyException;



  /**
   * Lists the Root DN Users.
   *
   * @return Returns an array containing the names of the Root DN
   *         Users.
   * @throws ConcurrentModificationException
   *           If this Root DN has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listRootDNUsers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Root DN User.
   *
   * @param name
   *           The name of the Root DN User to retrieve.
   * @return Returns the named Root DN User.
   * @throws DefinitionDecodingException
   *           If the named Root DN User was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Root DN User was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Root DN User was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root DN has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  RootDNUserCfgClient getRootDNUser(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Root DN User. The new Root DN User will initially
   * not contain any property values (including mandatory properties).
   * Once the Root DN User has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Root DN User being created.
   * @param d
   *          The definition of the Root DN User to be created.
   * @param name
   *          The name of the new Root DN User.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Root DN User. This
   *          argument can be <code>null<code>.
   * @return Returns a new Root DN User configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Root DN User is invalid.
   */
  <C extends RootDNUserCfgClient> C createRootDNUser(
      ManagedObjectDefinition<C, ? extends RootDNUserCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Root DN User.
   *
   * @param name
   *          The name of the Root DN User to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Root DN User does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Root DN User due to
   *           some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root DN has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeRootDNUser(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;

}
