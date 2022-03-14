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
import org.forgerock.opendj.server.config.server.AccountStatusNotificationHandlerCfg;
import org.forgerock.opendj.server.config.server.AlertHandlerCfg;
import org.forgerock.opendj.server.config.server.AuthenticationPolicyCfg;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.forgerock.opendj.server.config.server.CertificateMapperCfg;
import org.forgerock.opendj.server.config.server.ConnectionHandlerCfg;
import org.forgerock.opendj.server.config.server.EntryCacheCfg;
import org.forgerock.opendj.server.config.server.ExtendedOperationHandlerCfg;
import org.forgerock.opendj.server.config.server.GroupImplementationCfg;
import org.forgerock.opendj.server.config.server.HTTPAuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.HTTPEndpointCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;
import org.forgerock.opendj.server.config.server.KeyManagerProviderCfg;
import org.forgerock.opendj.server.config.server.LogPublisherCfg;
import org.forgerock.opendj.server.config.server.LogRetentionPolicyCfg;
import org.forgerock.opendj.server.config.server.LogRotationPolicyCfg;
import org.forgerock.opendj.server.config.server.MonitorProviderCfg;
import org.forgerock.opendj.server.config.server.PasswordGeneratorCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;
import org.forgerock.opendj.server.config.server.RootCfg;
import org.forgerock.opendj.server.config.server.SASLMechanismHandlerCfg;
import org.forgerock.opendj.server.config.server.SchemaProviderCfg;
import org.forgerock.opendj.server.config.server.ServiceDiscoveryMechanismCfg;
import org.forgerock.opendj.server.config.server.SynchronizationProviderCfg;
import org.forgerock.opendj.server.config.server.TrustManagerProviderCfg;
import org.forgerock.opendj.server.config.server.VirtualAttributeCfg;



/**
 * A client-side interface for reading and modifying Root settings.
 * <p>
 * The root configuration provides an entry point to the rest of the
 * OpenDJ configuration.
 */
public interface RootCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Root.
   *
   * @return Returns the configuration definition associated with this Root.
   */
  ManagedObjectDefinition<? extends RootCfgClient, ? extends RootCfg> definition();



  /**
   * Gets the Access Control Handler.
   *
   * @return Returns the Access Control Handler.
   * @throws DefinitionDecodingException
   *           If the Access Control Handler was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the Access Control Handler was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Access Control Handler could not be found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  AccessControlHandlerCfgClient getAccessControlHandler()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Lists the Account Status Notification Handlers.
   *
   * @return Returns an array containing the names of the Account
   *         Status Notification Handlers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listAccountStatusNotificationHandlers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Account Status Notification Handler.
   *
   * @param name
   *           The name of the Account Status Notification Handler to
   *           retrieve.
   * @return Returns the named Account Status Notification Handler.
   * @throws DefinitionDecodingException
   *           If the named Account Status Notification Handler was
   *           found but its type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Account Status Notification Handler was
   *           found but one or more of its properties could not be
   *           decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Account Status Notification Handler was
   *           not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  AccountStatusNotificationHandlerCfgClient getAccountStatusNotificationHandler(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Account Status Notification Handler. The new
   * Account Status Notification Handler will initially not contain any
   * property values (including mandatory properties). Once the Account
   * Status Notification Handler has been configured it can be added to
   * the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Account Status Notification Handler
   *          being created.
   * @param d
   *          The definition of the Account Status Notification
   *          Handler to be created.
   * @param name
   *          The name of the new Account Status Notification Handler.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Account Status
   *          Notification Handler. This argument can be
   *          <code>null<code>.
   * @return Returns a new Account Status Notification Handler
   *         configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Account Status Notification
   *          Handler is invalid.
   */
  <C extends AccountStatusNotificationHandlerCfgClient> C createAccountStatusNotificationHandler(
      ManagedObjectDefinition<C, ? extends AccountStatusNotificationHandlerCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Account Status Notification Handler.
   *
   * @param name
   *          The name of the Account Status Notification Handler to
   *          remove.
   * @throws ManagedObjectNotFoundException
   *           If the Account Status Notification Handler does not
   *           exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Account Status
   *           Notification Handler due to some server-side constraint
   *           which cannot be satisfied (for example, if it is
   *           referenced by another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeAccountStatusNotificationHandler(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Gets the Administration Connector.
   *
   * @return Returns the Administration Connector.
   * @throws DefinitionDecodingException
   *           If the Administration Connector was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the Administration Connector was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Administration Connector could not be found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  AdministrationConnectorCfgClient getAdministrationConnector()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Lists the Alert Handlers.
   *
   * @return Returns an array containing the names of the Alert
   *         Handlers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listAlertHandlers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Alert Handler.
   *
   * @param name
   *           The name of the Alert Handler to retrieve.
   * @return Returns the named Alert Handler.
   * @throws DefinitionDecodingException
   *           If the named Alert Handler was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Alert Handler was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Alert Handler was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  AlertHandlerCfgClient getAlertHandler(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Alert Handler. The new Alert Handler will initially
   * not contain any property values (including mandatory properties).
   * Once the Alert Handler has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Alert Handler being created.
   * @param d
   *          The definition of the Alert Handler to be created.
   * @param name
   *          The name of the new Alert Handler.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Alert Handler. This
   *          argument can be <code>null<code>.
   * @return Returns a new Alert Handler configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Alert Handler is invalid.
   */
  <C extends AlertHandlerCfgClient> C createAlertHandler(
      ManagedObjectDefinition<C, ? extends AlertHandlerCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Alert Handler.
   *
   * @param name
   *          The name of the Alert Handler to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Alert Handler does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Alert Handler due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeAlertHandler(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Backends.
   *
   * @return Returns an array containing the names of the Backends.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listBackends() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Backend.
   *
   * @param name
   *           The name of the Backend to retrieve.
   * @return Returns the named Backend.
   * @throws DefinitionDecodingException
   *           If the named Backend was found but its type could not
   *           be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Backend was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Backend was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  BackendCfgClient getBackend(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Backend. The new Backend will initially not contain
   * any property values (including mandatory properties). Once the
   * Backend has been configured it can be added to the server using
   * the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Backend being created.
   * @param d
   *          The definition of the Backend to be created.
   * @param name
   *          The name of the new Backend.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Backend. This
   *          argument can be <code>null<code>.
   * @return Returns a new Backend configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Backend is invalid.
   */
  <C extends BackendCfgClient> C createBackend(
      ManagedObjectDefinition<C, ? extends BackendCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Backend.
   *
   * @param name
   *          The name of the Backend to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Backend does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Backend due to some
   *           server-side constraint which cannot be satisfied (for
   *           example, if it is referenced by another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeBackend(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Certificate Mappers.
   *
   * @return Returns an array containing the names of the Certificate
   *         Mappers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listCertificateMappers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Certificate Mapper.
   *
   * @param name
   *           The name of the Certificate Mapper to retrieve.
   * @return Returns the named Certificate Mapper.
   * @throws DefinitionDecodingException
   *           If the named Certificate Mapper was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Certificate Mapper was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Certificate Mapper was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  CertificateMapperCfgClient getCertificateMapper(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Certificate Mapper. The new Certificate Mapper will
   * initially not contain any property values (including mandatory
   * properties). Once the Certificate Mapper has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Certificate Mapper being created.
   * @param d
   *          The definition of the Certificate Mapper to be created.
   * @param name
   *          The name of the new Certificate Mapper.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Certificate Mapper.
   *          This argument can be <code>null<code>.
   * @return Returns a new Certificate Mapper configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Certificate Mapper is invalid.
   */
  <C extends CertificateMapperCfgClient> C createCertificateMapper(
      ManagedObjectDefinition<C, ? extends CertificateMapperCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Certificate Mapper.
   *
   * @param name
   *          The name of the Certificate Mapper to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Certificate Mapper does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Certificate Mapper
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeCertificateMapper(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Connection Handlers.
   *
   * @return Returns an array containing the names of the Connection
   *         Handlers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listConnectionHandlers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Connection Handler.
   *
   * @param name
   *           The name of the Connection Handler to retrieve.
   * @return Returns the named Connection Handler.
   * @throws DefinitionDecodingException
   *           If the named Connection Handler was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Connection Handler was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Connection Handler was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ConnectionHandlerCfgClient getConnectionHandler(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Connection Handler. The new Connection Handler will
   * initially not contain any property values (including mandatory
   * properties). Once the Connection Handler has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Connection Handler being created.
   * @param d
   *          The definition of the Connection Handler to be created.
   * @param name
   *          The name of the new Connection Handler.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Connection Handler.
   *          This argument can be <code>null<code>.
   * @return Returns a new Connection Handler configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Connection Handler is invalid.
   */
  <C extends ConnectionHandlerCfgClient> C createConnectionHandler(
      ManagedObjectDefinition<C, ? extends ConnectionHandlerCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Connection Handler.
   *
   * @param name
   *          The name of the Connection Handler to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Connection Handler does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Connection Handler
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeConnectionHandler(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Gets the Crypto Manager.
   *
   * @return Returns the Crypto Manager.
   * @throws DefinitionDecodingException
   *           If the Crypto Manager was found but its type could not
   *           be determined.
   * @throws ManagedObjectDecodingException
   *           If the Crypto Manager was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Crypto Manager could not be found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  CryptoManagerCfgClient getCryptoManager()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Lists the Entry Caches.
   *
   * @return Returns an array containing the names of the Entry
   *         Caches.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listEntryCaches() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Entry Cache.
   *
   * @param name
   *           The name of the Entry Cache to retrieve.
   * @return Returns the named Entry Cache.
   * @throws DefinitionDecodingException
   *           If the named Entry Cache was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Entry Cache was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Entry Cache was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  EntryCacheCfgClient getEntryCache(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Entry Cache. The new Entry Cache will initially not
   * contain any property values (including mandatory properties). Once
   * the Entry Cache has been configured it can be added to the server
   * using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Entry Cache being created.
   * @param d
   *          The definition of the Entry Cache to be created.
   * @param name
   *          The name of the new Entry Cache.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Entry Cache. This
   *          argument can be <code>null<code>.
   * @return Returns a new Entry Cache configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Entry Cache is invalid.
   */
  <C extends EntryCacheCfgClient> C createEntryCache(
      ManagedObjectDefinition<C, ? extends EntryCacheCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Entry Cache.
   *
   * @param name
   *          The name of the Entry Cache to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Entry Cache does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Entry Cache due to
   *           some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeEntryCache(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Extended Operation Handlers.
   *
   * @return Returns an array containing the names of the Extended
   *         Operation Handlers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listExtendedOperationHandlers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Extended Operation Handler.
   *
   * @param name
   *           The name of the Extended Operation Handler to retrieve.
   * @return Returns the named Extended Operation Handler.
   * @throws DefinitionDecodingException
   *           If the named Extended Operation Handler was found but
   *           its type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Extended Operation Handler was found but
   *           one or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Extended Operation Handler was not found
   *           on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ExtendedOperationHandlerCfgClient getExtendedOperationHandler(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Extended Operation Handler. The new Extended
   * Operation Handler will initially not contain any property values
   * (including mandatory properties). Once the Extended Operation
   * Handler has been configured it can be added to the server using
   * the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Extended Operation Handler being
   *          created.
   * @param d
   *          The definition of the Extended Operation Handler to be
   *          created.
   * @param name
   *          The name of the new Extended Operation Handler.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Extended Operation
   *          Handler. This argument can be <code>null<code>.
   * @return Returns a new Extended Operation Handler configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Extended Operation Handler is
   *          invalid.
   */
  <C extends ExtendedOperationHandlerCfgClient> C createExtendedOperationHandler(
      ManagedObjectDefinition<C, ? extends ExtendedOperationHandlerCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Extended Operation Handler.
   *
   * @param name
   *          The name of the Extended Operation Handler to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Extended Operation Handler does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Extended Operation
   *           Handler due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeExtendedOperationHandler(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Gets the Global Configuration.
   *
   * @return Returns the Global Configuration.
   * @throws DefinitionDecodingException
   *           If the Global Configuration was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the Global Configuration was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Global Configuration could not be found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  GlobalCfgClient getGlobalConfiguration()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Lists the Group Implementations.
   *
   * @return Returns an array containing the names of the Group
   *         Implementations.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listGroupImplementations() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Group Implementation.
   *
   * @param name
   *           The name of the Group Implementation to retrieve.
   * @return Returns the named Group Implementation.
   * @throws DefinitionDecodingException
   *           If the named Group Implementation was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Group Implementation was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Group Implementation was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  GroupImplementationCfgClient getGroupImplementation(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Group Implementation. The new Group Implementation
   * will initially not contain any property values (including
   * mandatory properties). Once the Group Implementation has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Group Implementation being created.
   * @param d
   *          The definition of the Group Implementation to be
   *          created.
   * @param name
   *          The name of the new Group Implementation.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Group Implementation.
   *          This argument can be <code>null<code>.
   * @return Returns a new Group Implementation configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Group Implementation is invalid.
   */
  <C extends GroupImplementationCfgClient> C createGroupImplementation(
      ManagedObjectDefinition<C, ? extends GroupImplementationCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Group Implementation.
   *
   * @param name
   *          The name of the Group Implementation to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Group Implementation does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Group
   *           Implementation due to some server-side constraint which
   *           cannot be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeGroupImplementation(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the HTTP Authorization Mechanisms.
   *
   * @return Returns an array containing the names of the HTTP
   *         Authorization Mechanisms.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listHTTPAuthorizationMechanisms() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named HTTP Authorization Mechanism.
   *
   * @param name
   *           The name of the HTTP Authorization Mechanism to
   *           retrieve.
   * @return Returns the named HTTP Authorization Mechanism.
   * @throws DefinitionDecodingException
   *           If the named HTTP Authorization Mechanism was found but
   *           its type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named HTTP Authorization Mechanism was found but
   *           one or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named HTTP Authorization Mechanism was not found
   *           on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  HTTPAuthorizationMechanismCfgClient getHTTPAuthorizationMechanism(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new HTTP Authorization Mechanism. The new HTTP
   * Authorization Mechanism will initially not contain any property
   * values (including mandatory properties). Once the HTTP
   * Authorization Mechanism has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the HTTP Authorization Mechanism being
   *          created.
   * @param d
   *          The definition of the HTTP Authorization Mechanism to be
   *          created.
   * @param name
   *          The name of the new HTTP Authorization Mechanism.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the HTTP Authorization
   *          Mechanism. This argument can be <code>null<code>.
   * @return Returns a new HTTP Authorization Mechanism configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new HTTP Authorization Mechanism is
   *          invalid.
   */
  <C extends HTTPAuthorizationMechanismCfgClient> C createHTTPAuthorizationMechanism(
      ManagedObjectDefinition<C, ? extends HTTPAuthorizationMechanismCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named HTTP Authorization Mechanism.
   *
   * @param name
   *          The name of the HTTP Authorization Mechanism to remove.
   * @throws ManagedObjectNotFoundException
   *           If the HTTP Authorization Mechanism does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the HTTP Authorization
   *           Mechanism due to some server-side constraint which
   *           cannot be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeHTTPAuthorizationMechanism(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the HTTP Endpoints.
   *
   * @return Returns an array containing the names of the HTTP
   *         Endpoints.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listHTTPEndpoints() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named HTTP Endpoint.
   *
   * @param name
   *           The name of the HTTP Endpoint to retrieve.
   * @return Returns the named HTTP Endpoint.
   * @throws DefinitionDecodingException
   *           If the named HTTP Endpoint was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named HTTP Endpoint was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named HTTP Endpoint was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  HTTPEndpointCfgClient getHTTPEndpoint(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new HTTP Endpoint. The new HTTP Endpoint will initially
   * not contain any property values (including mandatory properties).
   * Once the HTTP Endpoint has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the HTTP Endpoint being created.
   * @param d
   *          The definition of the HTTP Endpoint to be created.
   * @param name
   *          The name of the new HTTP Endpoint.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the HTTP Endpoint. This
   *          argument can be <code>null<code>.
   * @return Returns a new HTTP Endpoint configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new HTTP Endpoint is invalid.
   */
  <C extends HTTPEndpointCfgClient> C createHTTPEndpoint(
      ManagedObjectDefinition<C, ? extends HTTPEndpointCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named HTTP Endpoint.
   *
   * @param name
   *          The name of the HTTP Endpoint to remove.
   * @throws ManagedObjectNotFoundException
   *           If the HTTP Endpoint does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the HTTP Endpoint due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeHTTPEndpoint(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Identity Mappers.
   *
   * @return Returns an array containing the names of the Identity
   *         Mappers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listIdentityMappers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Identity Mapper.
   *
   * @param name
   *           The name of the Identity Mapper to retrieve.
   * @return Returns the named Identity Mapper.
   * @throws DefinitionDecodingException
   *           If the named Identity Mapper was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Identity Mapper was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Identity Mapper was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  IdentityMapperCfgClient getIdentityMapper(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Identity Mapper. The new Identity Mapper will
   * initially not contain any property values (including mandatory
   * properties). Once the Identity Mapper has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Identity Mapper being created.
   * @param d
   *          The definition of the Identity Mapper to be created.
   * @param name
   *          The name of the new Identity Mapper.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Identity Mapper. This
   *          argument can be <code>null<code>.
   * @return Returns a new Identity Mapper configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Identity Mapper is invalid.
   */
  <C extends IdentityMapperCfgClient> C createIdentityMapper(
      ManagedObjectDefinition<C, ? extends IdentityMapperCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Identity Mapper.
   *
   * @param name
   *          The name of the Identity Mapper to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Identity Mapper does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Identity Mapper due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeIdentityMapper(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Key Manager Providers.
   *
   * @return Returns an array containing the names of the Key Manager
   *         Providers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listKeyManagerProviders() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Key Manager Provider.
   *
   * @param name
   *           The name of the Key Manager Provider to retrieve.
   * @return Returns the named Key Manager Provider.
   * @throws DefinitionDecodingException
   *           If the named Key Manager Provider was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Key Manager Provider was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Key Manager Provider was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  KeyManagerProviderCfgClient getKeyManagerProvider(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Key Manager Provider. The new Key Manager Provider
   * will initially not contain any property values (including
   * mandatory properties). Once the Key Manager Provider has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Key Manager Provider being created.
   * @param d
   *          The definition of the Key Manager Provider to be
   *          created.
   * @param name
   *          The name of the new Key Manager Provider.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Key Manager Provider.
   *          This argument can be <code>null<code>.
   * @return Returns a new Key Manager Provider configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Key Manager Provider is invalid.
   */
  <C extends KeyManagerProviderCfgClient> C createKeyManagerProvider(
      ManagedObjectDefinition<C, ? extends KeyManagerProviderCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Key Manager Provider.
   *
   * @param name
   *          The name of the Key Manager Provider to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Key Manager Provider does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Key Manager
   *           Provider due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeKeyManagerProvider(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Log Publishers.
   *
   * @return Returns an array containing the names of the Log
   *         Publishers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listLogPublishers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Log Publisher.
   *
   * @param name
   *           The name of the Log Publisher to retrieve.
   * @return Returns the named Log Publisher.
   * @throws DefinitionDecodingException
   *           If the named Log Publisher was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Log Publisher was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Log Publisher was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  LogPublisherCfgClient getLogPublisher(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Log Publisher. The new Log Publisher will initially
   * not contain any property values (including mandatory properties).
   * Once the Log Publisher has been configured it can be added to the
   * server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Log Publisher being created.
   * @param d
   *          The definition of the Log Publisher to be created.
   * @param name
   *          The name of the new Log Publisher.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Log Publisher. This
   *          argument can be <code>null<code>.
   * @return Returns a new Log Publisher configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Log Publisher is invalid.
   */
  <C extends LogPublisherCfgClient> C createLogPublisher(
      ManagedObjectDefinition<C, ? extends LogPublisherCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Log Publisher.
   *
   * @param name
   *          The name of the Log Publisher to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Log Publisher does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Log Publisher due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeLogPublisher(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Log Retention Policies.
   *
   * @return Returns an array containing the names of the Log
   *         Retention Policies.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listLogRetentionPolicies() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Log Retention Policy.
   *
   * @param name
   *           The name of the Log Retention Policy to retrieve.
   * @return Returns the named Log Retention Policy.
   * @throws DefinitionDecodingException
   *           If the named Log Retention Policy was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Log Retention Policy was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Log Retention Policy was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  LogRetentionPolicyCfgClient getLogRetentionPolicy(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Log Retention Policy. The new Log Retention Policy
   * will initially not contain any property values (including
   * mandatory properties). Once the Log Retention Policy has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Log Retention Policy being created.
   * @param d
   *          The definition of the Log Retention Policy to be
   *          created.
   * @param name
   *          The name of the new Log Retention Policy.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Log Retention Policy.
   *          This argument can be <code>null<code>.
   * @return Returns a new Log Retention Policy configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Log Retention Policy is invalid.
   */
  <C extends LogRetentionPolicyCfgClient> C createLogRetentionPolicy(
      ManagedObjectDefinition<C, ? extends LogRetentionPolicyCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Log Retention Policy.
   *
   * @param name
   *          The name of the Log Retention Policy to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Log Retention Policy does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Log Retention
   *           Policy due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeLogRetentionPolicy(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Log Rotation Policies.
   *
   * @return Returns an array containing the names of the Log Rotation
   *         Policies.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listLogRotationPolicies() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Log Rotation Policy.
   *
   * @param name
   *           The name of the Log Rotation Policy to retrieve.
   * @return Returns the named Log Rotation Policy.
   * @throws DefinitionDecodingException
   *           If the named Log Rotation Policy was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Log Rotation Policy was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Log Rotation Policy was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  LogRotationPolicyCfgClient getLogRotationPolicy(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Log Rotation Policy. The new Log Rotation Policy
   * will initially not contain any property values (including
   * mandatory properties). Once the Log Rotation Policy has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Log Rotation Policy being created.
   * @param d
   *          The definition of the Log Rotation Policy to be created.
   * @param name
   *          The name of the new Log Rotation Policy.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Log Rotation Policy.
   *          This argument can be <code>null<code>.
   * @return Returns a new Log Rotation Policy configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Log Rotation Policy is invalid.
   */
  <C extends LogRotationPolicyCfgClient> C createLogRotationPolicy(
      ManagedObjectDefinition<C, ? extends LogRotationPolicyCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Log Rotation Policy.
   *
   * @param name
   *          The name of the Log Rotation Policy to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Log Rotation Policy does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Log Rotation Policy
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeLogRotationPolicy(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Monitor Providers.
   *
   * @return Returns an array containing the names of the Monitor
   *         Providers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listMonitorProviders() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Monitor Provider.
   *
   * @param name
   *           The name of the Monitor Provider to retrieve.
   * @return Returns the named Monitor Provider.
   * @throws DefinitionDecodingException
   *           If the named Monitor Provider was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Monitor Provider was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Monitor Provider was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  MonitorProviderCfgClient getMonitorProvider(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Monitor Provider. The new Monitor Provider will
   * initially not contain any property values (including mandatory
   * properties). Once the Monitor Provider has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Monitor Provider being created.
   * @param d
   *          The definition of the Monitor Provider to be created.
   * @param name
   *          The name of the new Monitor Provider.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Monitor Provider.
   *          This argument can be <code>null<code>.
   * @return Returns a new Monitor Provider configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Monitor Provider is invalid.
   */
  <C extends MonitorProviderCfgClient> C createMonitorProvider(
      ManagedObjectDefinition<C, ? extends MonitorProviderCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Monitor Provider.
   *
   * @param name
   *          The name of the Monitor Provider to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Monitor Provider does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Monitor Provider
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeMonitorProvider(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Password Generators.
   *
   * @return Returns an array containing the names of the Password
   *         Generators.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listPasswordGenerators() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Password Generator.
   *
   * @param name
   *           The name of the Password Generator to retrieve.
   * @return Returns the named Password Generator.
   * @throws DefinitionDecodingException
   *           If the named Password Generator was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Password Generator was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Password Generator was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  PasswordGeneratorCfgClient getPasswordGenerator(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Password Generator. The new Password Generator will
   * initially not contain any property values (including mandatory
   * properties). Once the Password Generator has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Password Generator being created.
   * @param d
   *          The definition of the Password Generator to be created.
   * @param name
   *          The name of the new Password Generator.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Password Generator.
   *          This argument can be <code>null<code>.
   * @return Returns a new Password Generator configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Password Generator is invalid.
   */
  <C extends PasswordGeneratorCfgClient> C createPasswordGenerator(
      ManagedObjectDefinition<C, ? extends PasswordGeneratorCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Password Generator.
   *
   * @param name
   *          The name of the Password Generator to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Password Generator does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Password Generator
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removePasswordGenerator(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Password Policies.
   *
   * @return Returns an array containing the names of the Password
   *         Policies.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listPasswordPolicies() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Password Policy.
   *
   * @param name
   *           The name of the Password Policy to retrieve.
   * @return Returns the named Password Policy.
   * @throws DefinitionDecodingException
   *           If the named Password Policy was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Password Policy was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Password Policy was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  AuthenticationPolicyCfgClient getPasswordPolicy(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Password Policy. The new Password Policy will
   * initially not contain any property values (including mandatory
   * properties). Once the Password Policy has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Password Policy being created.
   * @param d
   *          The definition of the Password Policy to be created.
   * @param name
   *          The name of the new Password Policy.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Password Policy. This
   *          argument can be <code>null<code>.
   * @return Returns a new Password Policy configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Password Policy is invalid.
   */
  <C extends AuthenticationPolicyCfgClient> C createPasswordPolicy(
      ManagedObjectDefinition<C, ? extends AuthenticationPolicyCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Password Policy.
   *
   * @param name
   *          The name of the Password Policy to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Password Policy does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Password Policy due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removePasswordPolicy(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Password Storage Schemes.
   *
   * @return Returns an array containing the names of the Password
   *         Storage Schemes.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listPasswordStorageSchemes() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Password Storage Scheme.
   *
   * @param name
   *           The name of the Password Storage Scheme to retrieve.
   * @return Returns the named Password Storage Scheme.
   * @throws DefinitionDecodingException
   *           If the named Password Storage Scheme was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Password Storage Scheme was found but one
   *           or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Password Storage Scheme was not found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  PasswordStorageSchemeCfgClient getPasswordStorageScheme(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Password Storage Scheme. The new Password Storage
   * Scheme will initially not contain any property values (including
   * mandatory properties). Once the Password Storage Scheme has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Password Storage Scheme being created.
   * @param d
   *          The definition of the Password Storage Scheme to be
   *          created.
   * @param name
   *          The name of the new Password Storage Scheme.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Password Storage
   *          Scheme. This argument can be <code>null<code>.
   * @return Returns a new Password Storage Scheme configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Password Storage Scheme is
   *          invalid.
   */
  <C extends PasswordStorageSchemeCfgClient> C createPasswordStorageScheme(
      ManagedObjectDefinition<C, ? extends PasswordStorageSchemeCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Password Storage Scheme.
   *
   * @param name
   *          The name of the Password Storage Scheme to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Password Storage Scheme does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Password Storage
   *           Scheme due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removePasswordStorageScheme(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Password Validators.
   *
   * @return Returns an array containing the names of the Password
   *         Validators.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listPasswordValidators() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Password Validator.
   *
   * @param name
   *           The name of the Password Validator to retrieve.
   * @return Returns the named Password Validator.
   * @throws DefinitionDecodingException
   *           If the named Password Validator was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Password Validator was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Password Validator was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  PasswordValidatorCfgClient getPasswordValidator(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Password Validator. The new Password Validator will
   * initially not contain any property values (including mandatory
   * properties). Once the Password Validator has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Password Validator being created.
   * @param d
   *          The definition of the Password Validator to be created.
   * @param name
   *          The name of the new Password Validator.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Password Validator.
   *          This argument can be <code>null<code>.
   * @return Returns a new Password Validator configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Password Validator is invalid.
   */
  <C extends PasswordValidatorCfgClient> C createPasswordValidator(
      ManagedObjectDefinition<C, ? extends PasswordValidatorCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Password Validator.
   *
   * @param name
   *          The name of the Password Validator to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Password Validator does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Password Validator
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removePasswordValidator(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Gets the Plugin Root.
   *
   * @return Returns the Plugin Root.
   * @throws DefinitionDecodingException
   *           If the Plugin Root was found but its type could not be
   *           determined.
   * @throws ManagedObjectDecodingException
   *           If the Plugin Root was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Plugin Root could not be found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  PluginRootCfgClient getPluginRoot()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Gets the Root DN.
   *
   * @return Returns the Root DN.
   * @throws DefinitionDecodingException
   *           If the Root DN was found but its type could not be
   *           determined.
   * @throws ManagedObjectDecodingException
   *           If the Root DN was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Root DN could not be found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  RootDNCfgClient getRootDN()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Gets the Root DSE Backend.
   *
   * @return Returns the Root DSE Backend.
   * @throws DefinitionDecodingException
   *           If the Root DSE Backend was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the Root DSE Backend was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Root DSE Backend could not be found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  RootDSEBackendCfgClient getRootDSEBackend()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Lists the SASL Mechanism Handlers.
   *
   * @return Returns an array containing the names of the SASL
   *         Mechanism Handlers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listSASLMechanismHandlers() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named SASL Mechanism Handler.
   *
   * @param name
   *           The name of the SASL Mechanism Handler to retrieve.
   * @return Returns the named SASL Mechanism Handler.
   * @throws DefinitionDecodingException
   *           If the named SASL Mechanism Handler was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named SASL Mechanism Handler was found but one
   *           or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named SASL Mechanism Handler was not found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  SASLMechanismHandlerCfgClient getSASLMechanismHandler(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new SASL Mechanism Handler. The new SASL Mechanism
   * Handler will initially not contain any property values (including
   * mandatory properties). Once the SASL Mechanism Handler has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the SASL Mechanism Handler being created.
   * @param d
   *          The definition of the SASL Mechanism Handler to be
   *          created.
   * @param name
   *          The name of the new SASL Mechanism Handler.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the SASL Mechanism
   *          Handler. This argument can be <code>null<code>.
   * @return Returns a new SASL Mechanism Handler configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new SASL Mechanism Handler is
   *          invalid.
   */
  <C extends SASLMechanismHandlerCfgClient> C createSASLMechanismHandler(
      ManagedObjectDefinition<C, ? extends SASLMechanismHandlerCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named SASL Mechanism Handler.
   *
   * @param name
   *          The name of the SASL Mechanism Handler to remove.
   * @throws ManagedObjectNotFoundException
   *           If the SASL Mechanism Handler does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the SASL Mechanism
   *           Handler due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeSASLMechanismHandler(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Schema Providers.
   *
   * @return Returns an array containing the names of the Schema
   *         Providers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listSchemaProviders() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Schema Provider.
   *
   * @param name
   *           The name of the Schema Provider to retrieve.
   * @return Returns the named Schema Provider.
   * @throws DefinitionDecodingException
   *           If the named Schema Provider was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Schema Provider was found but one or more
   *           of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Schema Provider was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  SchemaProviderCfgClient getSchemaProvider(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Schema Provider. The new Schema Provider will
   * initially not contain any property values (including mandatory
   * properties). Once the Schema Provider has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Schema Provider being created.
   * @param d
   *          The definition of the Schema Provider to be created.
   * @param name
   *          The name of the new Schema Provider.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Schema Provider. This
   *          argument can be <code>null<code>.
   * @return Returns a new Schema Provider configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Schema Provider is invalid.
   */
  <C extends SchemaProviderCfgClient> C createSchemaProvider(
      ManagedObjectDefinition<C, ? extends SchemaProviderCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Schema Provider.
   *
   * @param name
   *          The name of the Schema Provider to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Schema Provider does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Schema Provider due
   *           to some server-side constraint which cannot be satisfied
   *           (for example, if it is referenced by another managed
   *           object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeSchemaProvider(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Service Discovery Mechanisms.
   *
   * @return Returns an array containing the names of the Service
   *         Discovery Mechanisms.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listServiceDiscoveryMechanisms() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Service Discovery Mechanism.
   *
   * @param name
   *           The name of the Service Discovery Mechanism to
   *           retrieve.
   * @return Returns the named Service Discovery Mechanism.
   * @throws DefinitionDecodingException
   *           If the named Service Discovery Mechanism was found but
   *           its type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Service Discovery Mechanism was found but
   *           one or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Service Discovery Mechanism was not found
   *           on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ServiceDiscoveryMechanismCfgClient getServiceDiscoveryMechanism(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Service Discovery Mechanism. The new Service
   * Discovery Mechanism will initially not contain any property values
   * (including mandatory properties). Once the Service Discovery
   * Mechanism has been configured it can be added to the server using
   * the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Service Discovery Mechanism being
   *          created.
   * @param d
   *          The definition of the Service Discovery Mechanism to be
   *          created.
   * @param name
   *          The name of the new Service Discovery Mechanism.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Service Discovery
   *          Mechanism. This argument can be <code>null<code>.
   * @return Returns a new Service Discovery Mechanism configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Service Discovery Mechanism is
   *          invalid.
   */
  <C extends ServiceDiscoveryMechanismCfgClient> C createServiceDiscoveryMechanism(
      ManagedObjectDefinition<C, ? extends ServiceDiscoveryMechanismCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Service Discovery Mechanism.
   *
   * @param name
   *          The name of the Service Discovery Mechanism to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Service Discovery Mechanism does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Service Discovery
   *           Mechanism due to some server-side constraint which
   *           cannot be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeServiceDiscoveryMechanism(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Synchronization Providers.
   *
   * @return Returns an array containing the names of the
   *         Synchronization Providers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listSynchronizationProviders() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Synchronization Provider.
   *
   * @param name
   *           The name of the Synchronization Provider to retrieve.
   * @return Returns the named Synchronization Provider.
   * @throws DefinitionDecodingException
   *           If the named Synchronization Provider was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Synchronization Provider was found but one
   *           or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Synchronization Provider was not found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  SynchronizationProviderCfgClient getSynchronizationProvider(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Synchronization Provider. The new Synchronization
   * Provider will initially not contain any property values (including
   * mandatory properties). Once the Synchronization Provider has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Synchronization Provider being created.
   * @param d
   *          The definition of the Synchronization Provider to be
   *          created.
   * @param name
   *          The name of the new Synchronization Provider.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Synchronization
   *          Provider. This argument can be <code>null<code>.
   * @return Returns a new Synchronization Provider configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Synchronization Provider is
   *          invalid.
   */
  <C extends SynchronizationProviderCfgClient> C createSynchronizationProvider(
      ManagedObjectDefinition<C, ? extends SynchronizationProviderCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Synchronization Provider.
   *
   * @param name
   *          The name of the Synchronization Provider to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Synchronization Provider does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Synchronization
   *           Provider due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeSynchronizationProvider(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Trust Manager Providers.
   *
   * @return Returns an array containing the names of the Trust
   *         Manager Providers.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listTrustManagerProviders() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Trust Manager Provider.
   *
   * @param name
   *           The name of the Trust Manager Provider to retrieve.
   * @return Returns the named Trust Manager Provider.
   * @throws DefinitionDecodingException
   *           If the named Trust Manager Provider was found but its
   *           type could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Trust Manager Provider was found but one
   *           or more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Trust Manager Provider was not found on
   *           the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  TrustManagerProviderCfgClient getTrustManagerProvider(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Trust Manager Provider. The new Trust Manager
   * Provider will initially not contain any property values (including
   * mandatory properties). Once the Trust Manager Provider has been
   * configured it can be added to the server using the {@link
   * #commit()} method.
   *
   * @param <C>
   *          The type of the Trust Manager Provider being created.
   * @param d
   *          The definition of the Trust Manager Provider to be
   *          created.
   * @param name
   *          The name of the new Trust Manager Provider.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Trust Manager
   *          Provider. This argument can be <code>null<code>.
   * @return Returns a new Trust Manager Provider configuration
   *         instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Trust Manager Provider is
   *          invalid.
   */
  <C extends TrustManagerProviderCfgClient> C createTrustManagerProvider(
      ManagedObjectDefinition<C, ? extends TrustManagerProviderCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Trust Manager Provider.
   *
   * @param name
   *          The name of the Trust Manager Provider to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Trust Manager Provider does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Trust Manager
   *           Provider due to some server-side constraint which cannot
   *           be satisfied (for example, if it is referenced by
   *           another managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeTrustManagerProvider(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Lists the Virtual Attributes.
   *
   * @return Returns an array containing the names of the Virtual
   *         Attributes.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listVirtualAttributes() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Virtual Attribute.
   *
   * @param name
   *           The name of the Virtual Attribute to retrieve.
   * @return Returns the named Virtual Attribute.
   * @throws DefinitionDecodingException
   *           If the named Virtual Attribute was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Virtual Attribute was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Virtual Attribute was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  VirtualAttributeCfgClient getVirtualAttribute(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Virtual Attribute. The new Virtual Attribute will
   * initially not contain any property values (including mandatory
   * properties). Once the Virtual Attribute has been configured it can
   * be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Virtual Attribute being created.
   * @param d
   *          The definition of the Virtual Attribute to be created.
   * @param name
   *          The name of the new Virtual Attribute.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Virtual Attribute.
   *          This argument can be <code>null<code>.
   * @return Returns a new Virtual Attribute configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Virtual Attribute is invalid.
   */
  <C extends VirtualAttributeCfgClient> C createVirtualAttribute(
      ManagedObjectDefinition<C, ? extends VirtualAttributeCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Virtual Attribute.
   *
   * @param name
   *          The name of the Virtual Attribute to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Virtual Attribute does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Virtual Attribute
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeVirtualAttribute(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Gets the Work Queue.
   *
   * @return Returns the Work Queue.
   * @throws DefinitionDecodingException
   *           If the Work Queue was found but its type could not be
   *           determined.
   * @throws ManagedObjectDecodingException
   *           If the Work Queue was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Work Queue could not be found on the server.
   * @throws ConcurrentModificationException
   *           If this Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  WorkQueueCfgClient getWorkQueue()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;

}
