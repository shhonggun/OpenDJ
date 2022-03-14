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



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;



/**
 * A server-side interface for querying Root settings.
 * <p>
 * The root configuration provides an entry point to the rest of the
 * OpenDJ configuration.
 */
public interface RootCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Root.
   *
   * @return Returns the configuration class associated with this Root.
   */
  Class<? extends RootCfg> configurationClass();



  /**
   * Gets the Access Control Handler.
   *
   * @return Returns the Access Control Handler.
   * @throws ConfigException
   *           If the Access Control Handler could not be found or it could not
   *           be successfully decoded.
   */
  AccessControlHandlerCfg getAccessControlHandler() throws ConfigException;



  /**
   * Lists the Account Status Notification Handlers.
   *
   * @return Returns an array containing the names of the
   *         Account Status Notification Handlers.
   */
  String[] listAccountStatusNotificationHandlers();



  /**
   * Gets the named Account Status Notification Handler.
   *
   * @param name
   *          The name of the Account Status Notification Handler to retrieve.
   * @return Returns the named Account Status Notification Handler.
   * @throws ConfigException
   *           If the Account Status Notification Handler could not be found or it
   *           could not be successfully decoded.
   */
  AccountStatusNotificationHandlerCfg getAccountStatusNotificationHandler(String name) throws ConfigException;



  /**
   * Registers to be notified when new Account Status Notification Handlers are added.
   *
   * @param listener
   *          The Account Status Notification Handler configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addAccountStatusNotificationHandlerAddListener(ConfigurationAddListener<AccountStatusNotificationHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Account Status Notification Handler configuration add listener.
   *
   * @param listener
   *          The Account Status Notification Handler configuration add listener.
   */
  void removeAccountStatusNotificationHandlerAddListener(ConfigurationAddListener<AccountStatusNotificationHandlerCfg> listener);



  /**
   * Registers to be notified when existing Account Status Notification Handlers are deleted.
   *
   * @param listener
   *          The Account Status Notification Handler configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addAccountStatusNotificationHandlerDeleteListener(ConfigurationDeleteListener<AccountStatusNotificationHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Account Status Notification Handler configuration delete listener.
   *
   * @param listener
   *          The Account Status Notification Handler configuration delete listener.
   */
  void removeAccountStatusNotificationHandlerDeleteListener(ConfigurationDeleteListener<AccountStatusNotificationHandlerCfg> listener);



  /**
   * Gets the Administration Connector.
   *
   * @return Returns the Administration Connector.
   * @throws ConfigException
   *           If the Administration Connector could not be found or it could not
   *           be successfully decoded.
   */
  AdministrationConnectorCfg getAdministrationConnector() throws ConfigException;



  /**
   * Lists the Alert Handlers.
   *
   * @return Returns an array containing the names of the
   *         Alert Handlers.
   */
  String[] listAlertHandlers();



  /**
   * Gets the named Alert Handler.
   *
   * @param name
   *          The name of the Alert Handler to retrieve.
   * @return Returns the named Alert Handler.
   * @throws ConfigException
   *           If the Alert Handler could not be found or it
   *           could not be successfully decoded.
   */
  AlertHandlerCfg getAlertHandler(String name) throws ConfigException;



  /**
   * Registers to be notified when new Alert Handlers are added.
   *
   * @param listener
   *          The Alert Handler configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addAlertHandlerAddListener(ConfigurationAddListener<AlertHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Alert Handler configuration add listener.
   *
   * @param listener
   *          The Alert Handler configuration add listener.
   */
  void removeAlertHandlerAddListener(ConfigurationAddListener<AlertHandlerCfg> listener);



  /**
   * Registers to be notified when existing Alert Handlers are deleted.
   *
   * @param listener
   *          The Alert Handler configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addAlertHandlerDeleteListener(ConfigurationDeleteListener<AlertHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Alert Handler configuration delete listener.
   *
   * @param listener
   *          The Alert Handler configuration delete listener.
   */
  void removeAlertHandlerDeleteListener(ConfigurationDeleteListener<AlertHandlerCfg> listener);



  /**
   * Lists the Backends.
   *
   * @return Returns an array containing the names of the
   *         Backends.
   */
  String[] listBackends();



  /**
   * Gets the named Backend.
   *
   * @param name
   *          The name of the Backend to retrieve.
   * @return Returns the named Backend.
   * @throws ConfigException
   *           If the Backend could not be found or it
   *           could not be successfully decoded.
   */
  BackendCfg getBackend(String name) throws ConfigException;



  /**
   * Registers to be notified when new Backends are added.
   *
   * @param listener
   *          The Backend configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addBackendAddListener(ConfigurationAddListener<BackendCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend configuration add listener.
   *
   * @param listener
   *          The Backend configuration add listener.
   */
  void removeBackendAddListener(ConfigurationAddListener<BackendCfg> listener);



  /**
   * Registers to be notified when existing Backends are deleted.
   *
   * @param listener
   *          The Backend configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addBackendDeleteListener(ConfigurationDeleteListener<BackendCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Backend configuration delete listener.
   *
   * @param listener
   *          The Backend configuration delete listener.
   */
  void removeBackendDeleteListener(ConfigurationDeleteListener<BackendCfg> listener);



  /**
   * Lists the Certificate Mappers.
   *
   * @return Returns an array containing the names of the
   *         Certificate Mappers.
   */
  String[] listCertificateMappers();



  /**
   * Gets the named Certificate Mapper.
   *
   * @param name
   *          The name of the Certificate Mapper to retrieve.
   * @return Returns the named Certificate Mapper.
   * @throws ConfigException
   *           If the Certificate Mapper could not be found or it
   *           could not be successfully decoded.
   */
  CertificateMapperCfg getCertificateMapper(String name) throws ConfigException;



  /**
   * Registers to be notified when new Certificate Mappers are added.
   *
   * @param listener
   *          The Certificate Mapper configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addCertificateMapperAddListener(ConfigurationAddListener<CertificateMapperCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Certificate Mapper configuration add listener.
   *
   * @param listener
   *          The Certificate Mapper configuration add listener.
   */
  void removeCertificateMapperAddListener(ConfigurationAddListener<CertificateMapperCfg> listener);



  /**
   * Registers to be notified when existing Certificate Mappers are deleted.
   *
   * @param listener
   *          The Certificate Mapper configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addCertificateMapperDeleteListener(ConfigurationDeleteListener<CertificateMapperCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Certificate Mapper configuration delete listener.
   *
   * @param listener
   *          The Certificate Mapper configuration delete listener.
   */
  void removeCertificateMapperDeleteListener(ConfigurationDeleteListener<CertificateMapperCfg> listener);



  /**
   * Lists the Connection Handlers.
   *
   * @return Returns an array containing the names of the
   *         Connection Handlers.
   */
  String[] listConnectionHandlers();



  /**
   * Gets the named Connection Handler.
   *
   * @param name
   *          The name of the Connection Handler to retrieve.
   * @return Returns the named Connection Handler.
   * @throws ConfigException
   *           If the Connection Handler could not be found or it
   *           could not be successfully decoded.
   */
  ConnectionHandlerCfg getConnectionHandler(String name) throws ConfigException;



  /**
   * Registers to be notified when new Connection Handlers are added.
   *
   * @param listener
   *          The Connection Handler configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addConnectionHandlerAddListener(ConfigurationAddListener<ConnectionHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Connection Handler configuration add listener.
   *
   * @param listener
   *          The Connection Handler configuration add listener.
   */
  void removeConnectionHandlerAddListener(ConfigurationAddListener<ConnectionHandlerCfg> listener);



  /**
   * Registers to be notified when existing Connection Handlers are deleted.
   *
   * @param listener
   *          The Connection Handler configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addConnectionHandlerDeleteListener(ConfigurationDeleteListener<ConnectionHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Connection Handler configuration delete listener.
   *
   * @param listener
   *          The Connection Handler configuration delete listener.
   */
  void removeConnectionHandlerDeleteListener(ConfigurationDeleteListener<ConnectionHandlerCfg> listener);



  /**
   * Gets the Crypto Manager.
   *
   * @return Returns the Crypto Manager.
   * @throws ConfigException
   *           If the Crypto Manager could not be found or it could not
   *           be successfully decoded.
   */
  CryptoManagerCfg getCryptoManager() throws ConfigException;



  /**
   * Lists the Entry Caches.
   *
   * @return Returns an array containing the names of the
   *         Entry Caches.
   */
  String[] listEntryCaches();



  /**
   * Gets the named Entry Cache.
   *
   * @param name
   *          The name of the Entry Cache to retrieve.
   * @return Returns the named Entry Cache.
   * @throws ConfigException
   *           If the Entry Cache could not be found or it
   *           could not be successfully decoded.
   */
  EntryCacheCfg getEntryCache(String name) throws ConfigException;



  /**
   * Registers to be notified when new Entry Caches are added.
   *
   * @param listener
   *          The Entry Cache configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addEntryCacheAddListener(ConfigurationAddListener<EntryCacheCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Entry Cache configuration add listener.
   *
   * @param listener
   *          The Entry Cache configuration add listener.
   */
  void removeEntryCacheAddListener(ConfigurationAddListener<EntryCacheCfg> listener);



  /**
   * Registers to be notified when existing Entry Caches are deleted.
   *
   * @param listener
   *          The Entry Cache configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addEntryCacheDeleteListener(ConfigurationDeleteListener<EntryCacheCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Entry Cache configuration delete listener.
   *
   * @param listener
   *          The Entry Cache configuration delete listener.
   */
  void removeEntryCacheDeleteListener(ConfigurationDeleteListener<EntryCacheCfg> listener);



  /**
   * Lists the Extended Operation Handlers.
   *
   * @return Returns an array containing the names of the
   *         Extended Operation Handlers.
   */
  String[] listExtendedOperationHandlers();



  /**
   * Gets the named Extended Operation Handler.
   *
   * @param name
   *          The name of the Extended Operation Handler to retrieve.
   * @return Returns the named Extended Operation Handler.
   * @throws ConfigException
   *           If the Extended Operation Handler could not be found or it
   *           could not be successfully decoded.
   */
  ExtendedOperationHandlerCfg getExtendedOperationHandler(String name) throws ConfigException;



  /**
   * Registers to be notified when new Extended Operation Handlers are added.
   *
   * @param listener
   *          The Extended Operation Handler configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addExtendedOperationHandlerAddListener(ConfigurationAddListener<ExtendedOperationHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Extended Operation Handler configuration add listener.
   *
   * @param listener
   *          The Extended Operation Handler configuration add listener.
   */
  void removeExtendedOperationHandlerAddListener(ConfigurationAddListener<ExtendedOperationHandlerCfg> listener);



  /**
   * Registers to be notified when existing Extended Operation Handlers are deleted.
   *
   * @param listener
   *          The Extended Operation Handler configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addExtendedOperationHandlerDeleteListener(ConfigurationDeleteListener<ExtendedOperationHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Extended Operation Handler configuration delete listener.
   *
   * @param listener
   *          The Extended Operation Handler configuration delete listener.
   */
  void removeExtendedOperationHandlerDeleteListener(ConfigurationDeleteListener<ExtendedOperationHandlerCfg> listener);



  /**
   * Gets the Global Configuration.
   *
   * @return Returns the Global Configuration.
   * @throws ConfigException
   *           If the Global Configuration could not be found or it could not
   *           be successfully decoded.
   */
  GlobalCfg getGlobalConfiguration() throws ConfigException;



  /**
   * Lists the Group Implementations.
   *
   * @return Returns an array containing the names of the
   *         Group Implementations.
   */
  String[] listGroupImplementations();



  /**
   * Gets the named Group Implementation.
   *
   * @param name
   *          The name of the Group Implementation to retrieve.
   * @return Returns the named Group Implementation.
   * @throws ConfigException
   *           If the Group Implementation could not be found or it
   *           could not be successfully decoded.
   */
  GroupImplementationCfg getGroupImplementation(String name) throws ConfigException;



  /**
   * Registers to be notified when new Group Implementations are added.
   *
   * @param listener
   *          The Group Implementation configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addGroupImplementationAddListener(ConfigurationAddListener<GroupImplementationCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Group Implementation configuration add listener.
   *
   * @param listener
   *          The Group Implementation configuration add listener.
   */
  void removeGroupImplementationAddListener(ConfigurationAddListener<GroupImplementationCfg> listener);



  /**
   * Registers to be notified when existing Group Implementations are deleted.
   *
   * @param listener
   *          The Group Implementation configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addGroupImplementationDeleteListener(ConfigurationDeleteListener<GroupImplementationCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Group Implementation configuration delete listener.
   *
   * @param listener
   *          The Group Implementation configuration delete listener.
   */
  void removeGroupImplementationDeleteListener(ConfigurationDeleteListener<GroupImplementationCfg> listener);



  /**
   * Lists the HTTP Authorization Mechanisms.
   *
   * @return Returns an array containing the names of the
   *         HTTP Authorization Mechanisms.
   */
  String[] listHTTPAuthorizationMechanisms();



  /**
   * Gets the named HTTP Authorization Mechanism.
   *
   * @param name
   *          The name of the HTTP Authorization Mechanism to retrieve.
   * @return Returns the named HTTP Authorization Mechanism.
   * @throws ConfigException
   *           If the HTTP Authorization Mechanism could not be found or it
   *           could not be successfully decoded.
   */
  HTTPAuthorizationMechanismCfg getHTTPAuthorizationMechanism(String name) throws ConfigException;



  /**
   * Registers to be notified when new HTTP Authorization Mechanisms are added.
   *
   * @param listener
   *          The HTTP Authorization Mechanism configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addHTTPAuthorizationMechanismAddListener(ConfigurationAddListener<HTTPAuthorizationMechanismCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing HTTP Authorization Mechanism configuration add listener.
   *
   * @param listener
   *          The HTTP Authorization Mechanism configuration add listener.
   */
  void removeHTTPAuthorizationMechanismAddListener(ConfigurationAddListener<HTTPAuthorizationMechanismCfg> listener);



  /**
   * Registers to be notified when existing HTTP Authorization Mechanisms are deleted.
   *
   * @param listener
   *          The HTTP Authorization Mechanism configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addHTTPAuthorizationMechanismDeleteListener(ConfigurationDeleteListener<HTTPAuthorizationMechanismCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing HTTP Authorization Mechanism configuration delete listener.
   *
   * @param listener
   *          The HTTP Authorization Mechanism configuration delete listener.
   */
  void removeHTTPAuthorizationMechanismDeleteListener(ConfigurationDeleteListener<HTTPAuthorizationMechanismCfg> listener);



  /**
   * Lists the HTTP Endpoints.
   *
   * @return Returns an array containing the names of the
   *         HTTP Endpoints.
   */
  String[] listHTTPEndpoints();



  /**
   * Gets the named HTTP Endpoint.
   *
   * @param name
   *          The name of the HTTP Endpoint to retrieve.
   * @return Returns the named HTTP Endpoint.
   * @throws ConfigException
   *           If the HTTP Endpoint could not be found or it
   *           could not be successfully decoded.
   */
  HTTPEndpointCfg getHTTPEndpoint(String name) throws ConfigException;



  /**
   * Registers to be notified when new HTTP Endpoints are added.
   *
   * @param listener
   *          The HTTP Endpoint configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addHTTPEndpointAddListener(ConfigurationAddListener<HTTPEndpointCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing HTTP Endpoint configuration add listener.
   *
   * @param listener
   *          The HTTP Endpoint configuration add listener.
   */
  void removeHTTPEndpointAddListener(ConfigurationAddListener<HTTPEndpointCfg> listener);



  /**
   * Registers to be notified when existing HTTP Endpoints are deleted.
   *
   * @param listener
   *          The HTTP Endpoint configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addHTTPEndpointDeleteListener(ConfigurationDeleteListener<HTTPEndpointCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing HTTP Endpoint configuration delete listener.
   *
   * @param listener
   *          The HTTP Endpoint configuration delete listener.
   */
  void removeHTTPEndpointDeleteListener(ConfigurationDeleteListener<HTTPEndpointCfg> listener);



  /**
   * Lists the Identity Mappers.
   *
   * @return Returns an array containing the names of the
   *         Identity Mappers.
   */
  String[] listIdentityMappers();



  /**
   * Gets the named Identity Mapper.
   *
   * @param name
   *          The name of the Identity Mapper to retrieve.
   * @return Returns the named Identity Mapper.
   * @throws ConfigException
   *           If the Identity Mapper could not be found or it
   *           could not be successfully decoded.
   */
  IdentityMapperCfg getIdentityMapper(String name) throws ConfigException;



  /**
   * Registers to be notified when new Identity Mappers are added.
   *
   * @param listener
   *          The Identity Mapper configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addIdentityMapperAddListener(ConfigurationAddListener<IdentityMapperCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Identity Mapper configuration add listener.
   *
   * @param listener
   *          The Identity Mapper configuration add listener.
   */
  void removeIdentityMapperAddListener(ConfigurationAddListener<IdentityMapperCfg> listener);



  /**
   * Registers to be notified when existing Identity Mappers are deleted.
   *
   * @param listener
   *          The Identity Mapper configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addIdentityMapperDeleteListener(ConfigurationDeleteListener<IdentityMapperCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Identity Mapper configuration delete listener.
   *
   * @param listener
   *          The Identity Mapper configuration delete listener.
   */
  void removeIdentityMapperDeleteListener(ConfigurationDeleteListener<IdentityMapperCfg> listener);



  /**
   * Lists the Key Manager Providers.
   *
   * @return Returns an array containing the names of the
   *         Key Manager Providers.
   */
  String[] listKeyManagerProviders();



  /**
   * Gets the named Key Manager Provider.
   *
   * @param name
   *          The name of the Key Manager Provider to retrieve.
   * @return Returns the named Key Manager Provider.
   * @throws ConfigException
   *           If the Key Manager Provider could not be found or it
   *           could not be successfully decoded.
   */
  KeyManagerProviderCfg getKeyManagerProvider(String name) throws ConfigException;



  /**
   * Registers to be notified when new Key Manager Providers are added.
   *
   * @param listener
   *          The Key Manager Provider configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addKeyManagerProviderAddListener(ConfigurationAddListener<KeyManagerProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Key Manager Provider configuration add listener.
   *
   * @param listener
   *          The Key Manager Provider configuration add listener.
   */
  void removeKeyManagerProviderAddListener(ConfigurationAddListener<KeyManagerProviderCfg> listener);



  /**
   * Registers to be notified when existing Key Manager Providers are deleted.
   *
   * @param listener
   *          The Key Manager Provider configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addKeyManagerProviderDeleteListener(ConfigurationDeleteListener<KeyManagerProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Key Manager Provider configuration delete listener.
   *
   * @param listener
   *          The Key Manager Provider configuration delete listener.
   */
  void removeKeyManagerProviderDeleteListener(ConfigurationDeleteListener<KeyManagerProviderCfg> listener);



  /**
   * Lists the Log Publishers.
   *
   * @return Returns an array containing the names of the
   *         Log Publishers.
   */
  String[] listLogPublishers();



  /**
   * Gets the named Log Publisher.
   *
   * @param name
   *          The name of the Log Publisher to retrieve.
   * @return Returns the named Log Publisher.
   * @throws ConfigException
   *           If the Log Publisher could not be found or it
   *           could not be successfully decoded.
   */
  LogPublisherCfg getLogPublisher(String name) throws ConfigException;



  /**
   * Registers to be notified when new Log Publishers are added.
   *
   * @param listener
   *          The Log Publisher configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addLogPublisherAddListener(ConfigurationAddListener<LogPublisherCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Publisher configuration add listener.
   *
   * @param listener
   *          The Log Publisher configuration add listener.
   */
  void removeLogPublisherAddListener(ConfigurationAddListener<LogPublisherCfg> listener);



  /**
   * Registers to be notified when existing Log Publishers are deleted.
   *
   * @param listener
   *          The Log Publisher configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addLogPublisherDeleteListener(ConfigurationDeleteListener<LogPublisherCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Publisher configuration delete listener.
   *
   * @param listener
   *          The Log Publisher configuration delete listener.
   */
  void removeLogPublisherDeleteListener(ConfigurationDeleteListener<LogPublisherCfg> listener);



  /**
   * Lists the Log Retention Policies.
   *
   * @return Returns an array containing the names of the
   *         Log Retention Policies.
   */
  String[] listLogRetentionPolicies();



  /**
   * Gets the named Log Retention Policy.
   *
   * @param name
   *          The name of the Log Retention Policy to retrieve.
   * @return Returns the named Log Retention Policy.
   * @throws ConfigException
   *           If the Log Retention Policy could not be found or it
   *           could not be successfully decoded.
   */
  LogRetentionPolicyCfg getLogRetentionPolicy(String name) throws ConfigException;



  /**
   * Registers to be notified when new Log Retention Policies are added.
   *
   * @param listener
   *          The Log Retention Policy configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addLogRetentionPolicyAddListener(ConfigurationAddListener<LogRetentionPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Retention Policy configuration add listener.
   *
   * @param listener
   *          The Log Retention Policy configuration add listener.
   */
  void removeLogRetentionPolicyAddListener(ConfigurationAddListener<LogRetentionPolicyCfg> listener);



  /**
   * Registers to be notified when existing Log Retention Policies are deleted.
   *
   * @param listener
   *          The Log Retention Policy configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addLogRetentionPolicyDeleteListener(ConfigurationDeleteListener<LogRetentionPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Retention Policy configuration delete listener.
   *
   * @param listener
   *          The Log Retention Policy configuration delete listener.
   */
  void removeLogRetentionPolicyDeleteListener(ConfigurationDeleteListener<LogRetentionPolicyCfg> listener);



  /**
   * Lists the Log Rotation Policies.
   *
   * @return Returns an array containing the names of the
   *         Log Rotation Policies.
   */
  String[] listLogRotationPolicies();



  /**
   * Gets the named Log Rotation Policy.
   *
   * @param name
   *          The name of the Log Rotation Policy to retrieve.
   * @return Returns the named Log Rotation Policy.
   * @throws ConfigException
   *           If the Log Rotation Policy could not be found or it
   *           could not be successfully decoded.
   */
  LogRotationPolicyCfg getLogRotationPolicy(String name) throws ConfigException;



  /**
   * Registers to be notified when new Log Rotation Policies are added.
   *
   * @param listener
   *          The Log Rotation Policy configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addLogRotationPolicyAddListener(ConfigurationAddListener<LogRotationPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Rotation Policy configuration add listener.
   *
   * @param listener
   *          The Log Rotation Policy configuration add listener.
   */
  void removeLogRotationPolicyAddListener(ConfigurationAddListener<LogRotationPolicyCfg> listener);



  /**
   * Registers to be notified when existing Log Rotation Policies are deleted.
   *
   * @param listener
   *          The Log Rotation Policy configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addLogRotationPolicyDeleteListener(ConfigurationDeleteListener<LogRotationPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Log Rotation Policy configuration delete listener.
   *
   * @param listener
   *          The Log Rotation Policy configuration delete listener.
   */
  void removeLogRotationPolicyDeleteListener(ConfigurationDeleteListener<LogRotationPolicyCfg> listener);



  /**
   * Lists the Monitor Providers.
   *
   * @return Returns an array containing the names of the
   *         Monitor Providers.
   */
  String[] listMonitorProviders();



  /**
   * Gets the named Monitor Provider.
   *
   * @param name
   *          The name of the Monitor Provider to retrieve.
   * @return Returns the named Monitor Provider.
   * @throws ConfigException
   *           If the Monitor Provider could not be found or it
   *           could not be successfully decoded.
   */
  MonitorProviderCfg getMonitorProvider(String name) throws ConfigException;



  /**
   * Registers to be notified when new Monitor Providers are added.
   *
   * @param listener
   *          The Monitor Provider configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addMonitorProviderAddListener(ConfigurationAddListener<MonitorProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Monitor Provider configuration add listener.
   *
   * @param listener
   *          The Monitor Provider configuration add listener.
   */
  void removeMonitorProviderAddListener(ConfigurationAddListener<MonitorProviderCfg> listener);



  /**
   * Registers to be notified when existing Monitor Providers are deleted.
   *
   * @param listener
   *          The Monitor Provider configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addMonitorProviderDeleteListener(ConfigurationDeleteListener<MonitorProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Monitor Provider configuration delete listener.
   *
   * @param listener
   *          The Monitor Provider configuration delete listener.
   */
  void removeMonitorProviderDeleteListener(ConfigurationDeleteListener<MonitorProviderCfg> listener);



  /**
   * Lists the Password Generators.
   *
   * @return Returns an array containing the names of the
   *         Password Generators.
   */
  String[] listPasswordGenerators();



  /**
   * Gets the named Password Generator.
   *
   * @param name
   *          The name of the Password Generator to retrieve.
   * @return Returns the named Password Generator.
   * @throws ConfigException
   *           If the Password Generator could not be found or it
   *           could not be successfully decoded.
   */
  PasswordGeneratorCfg getPasswordGenerator(String name) throws ConfigException;



  /**
   * Registers to be notified when new Password Generators are added.
   *
   * @param listener
   *          The Password Generator configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addPasswordGeneratorAddListener(ConfigurationAddListener<PasswordGeneratorCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Generator configuration add listener.
   *
   * @param listener
   *          The Password Generator configuration add listener.
   */
  void removePasswordGeneratorAddListener(ConfigurationAddListener<PasswordGeneratorCfg> listener);



  /**
   * Registers to be notified when existing Password Generators are deleted.
   *
   * @param listener
   *          The Password Generator configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addPasswordGeneratorDeleteListener(ConfigurationDeleteListener<PasswordGeneratorCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Generator configuration delete listener.
   *
   * @param listener
   *          The Password Generator configuration delete listener.
   */
  void removePasswordGeneratorDeleteListener(ConfigurationDeleteListener<PasswordGeneratorCfg> listener);



  /**
   * Lists the Password Policies.
   *
   * @return Returns an array containing the names of the
   *         Password Policies.
   */
  String[] listPasswordPolicies();



  /**
   * Gets the named Password Policy.
   *
   * @param name
   *          The name of the Password Policy to retrieve.
   * @return Returns the named Password Policy.
   * @throws ConfigException
   *           If the Password Policy could not be found or it
   *           could not be successfully decoded.
   */
  AuthenticationPolicyCfg getPasswordPolicy(String name) throws ConfigException;



  /**
   * Registers to be notified when new Password Policies are added.
   *
   * @param listener
   *          The Password Policy configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addPasswordPolicyAddListener(ConfigurationAddListener<AuthenticationPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Policy configuration add listener.
   *
   * @param listener
   *          The Password Policy configuration add listener.
   */
  void removePasswordPolicyAddListener(ConfigurationAddListener<AuthenticationPolicyCfg> listener);



  /**
   * Registers to be notified when existing Password Policies are deleted.
   *
   * @param listener
   *          The Password Policy configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addPasswordPolicyDeleteListener(ConfigurationDeleteListener<AuthenticationPolicyCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Policy configuration delete listener.
   *
   * @param listener
   *          The Password Policy configuration delete listener.
   */
  void removePasswordPolicyDeleteListener(ConfigurationDeleteListener<AuthenticationPolicyCfg> listener);



  /**
   * Lists the Password Storage Schemes.
   *
   * @return Returns an array containing the names of the
   *         Password Storage Schemes.
   */
  String[] listPasswordStorageSchemes();



  /**
   * Gets the named Password Storage Scheme.
   *
   * @param name
   *          The name of the Password Storage Scheme to retrieve.
   * @return Returns the named Password Storage Scheme.
   * @throws ConfigException
   *           If the Password Storage Scheme could not be found or it
   *           could not be successfully decoded.
   */
  PasswordStorageSchemeCfg getPasswordStorageScheme(String name) throws ConfigException;



  /**
   * Registers to be notified when new Password Storage Schemes are added.
   *
   * @param listener
   *          The Password Storage Scheme configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addPasswordStorageSchemeAddListener(ConfigurationAddListener<PasswordStorageSchemeCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Storage Scheme configuration add listener.
   *
   * @param listener
   *          The Password Storage Scheme configuration add listener.
   */
  void removePasswordStorageSchemeAddListener(ConfigurationAddListener<PasswordStorageSchemeCfg> listener);



  /**
   * Registers to be notified when existing Password Storage Schemes are deleted.
   *
   * @param listener
   *          The Password Storage Scheme configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addPasswordStorageSchemeDeleteListener(ConfigurationDeleteListener<PasswordStorageSchemeCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Storage Scheme configuration delete listener.
   *
   * @param listener
   *          The Password Storage Scheme configuration delete listener.
   */
  void removePasswordStorageSchemeDeleteListener(ConfigurationDeleteListener<PasswordStorageSchemeCfg> listener);



  /**
   * Lists the Password Validators.
   *
   * @return Returns an array containing the names of the
   *         Password Validators.
   */
  String[] listPasswordValidators();



  /**
   * Gets the named Password Validator.
   *
   * @param name
   *          The name of the Password Validator to retrieve.
   * @return Returns the named Password Validator.
   * @throws ConfigException
   *           If the Password Validator could not be found or it
   *           could not be successfully decoded.
   */
  PasswordValidatorCfg getPasswordValidator(String name) throws ConfigException;



  /**
   * Registers to be notified when new Password Validators are added.
   *
   * @param listener
   *          The Password Validator configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addPasswordValidatorAddListener(ConfigurationAddListener<PasswordValidatorCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Validator configuration add listener.
   *
   * @param listener
   *          The Password Validator configuration add listener.
   */
  void removePasswordValidatorAddListener(ConfigurationAddListener<PasswordValidatorCfg> listener);



  /**
   * Registers to be notified when existing Password Validators are deleted.
   *
   * @param listener
   *          The Password Validator configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addPasswordValidatorDeleteListener(ConfigurationDeleteListener<PasswordValidatorCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Password Validator configuration delete listener.
   *
   * @param listener
   *          The Password Validator configuration delete listener.
   */
  void removePasswordValidatorDeleteListener(ConfigurationDeleteListener<PasswordValidatorCfg> listener);



  /**
   * Gets the Plugin Root.
   *
   * @return Returns the Plugin Root.
   * @throws ConfigException
   *           If the Plugin Root could not be found or it could not
   *           be successfully decoded.
   */
  PluginRootCfg getPluginRoot() throws ConfigException;



  /**
   * Gets the Root DN.
   *
   * @return Returns the Root DN.
   * @throws ConfigException
   *           If the Root DN could not be found or it could not
   *           be successfully decoded.
   */
  RootDNCfg getRootDN() throws ConfigException;



  /**
   * Gets the Root DSE Backend.
   *
   * @return Returns the Root DSE Backend.
   * @throws ConfigException
   *           If the Root DSE Backend could not be found or it could not
   *           be successfully decoded.
   */
  RootDSEBackendCfg getRootDSEBackend() throws ConfigException;



  /**
   * Lists the SASL Mechanism Handlers.
   *
   * @return Returns an array containing the names of the
   *         SASL Mechanism Handlers.
   */
  String[] listSASLMechanismHandlers();



  /**
   * Gets the named SASL Mechanism Handler.
   *
   * @param name
   *          The name of the SASL Mechanism Handler to retrieve.
   * @return Returns the named SASL Mechanism Handler.
   * @throws ConfigException
   *           If the SASL Mechanism Handler could not be found or it
   *           could not be successfully decoded.
   */
  SASLMechanismHandlerCfg getSASLMechanismHandler(String name) throws ConfigException;



  /**
   * Registers to be notified when new SASL Mechanism Handlers are added.
   *
   * @param listener
   *          The SASL Mechanism Handler configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addSASLMechanismHandlerAddListener(ConfigurationAddListener<SASLMechanismHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing SASL Mechanism Handler configuration add listener.
   *
   * @param listener
   *          The SASL Mechanism Handler configuration add listener.
   */
  void removeSASLMechanismHandlerAddListener(ConfigurationAddListener<SASLMechanismHandlerCfg> listener);



  /**
   * Registers to be notified when existing SASL Mechanism Handlers are deleted.
   *
   * @param listener
   *          The SASL Mechanism Handler configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addSASLMechanismHandlerDeleteListener(ConfigurationDeleteListener<SASLMechanismHandlerCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing SASL Mechanism Handler configuration delete listener.
   *
   * @param listener
   *          The SASL Mechanism Handler configuration delete listener.
   */
  void removeSASLMechanismHandlerDeleteListener(ConfigurationDeleteListener<SASLMechanismHandlerCfg> listener);



  /**
   * Lists the Schema Providers.
   *
   * @return Returns an array containing the names of the
   *         Schema Providers.
   */
  String[] listSchemaProviders();



  /**
   * Gets the named Schema Provider.
   *
   * @param name
   *          The name of the Schema Provider to retrieve.
   * @return Returns the named Schema Provider.
   * @throws ConfigException
   *           If the Schema Provider could not be found or it
   *           could not be successfully decoded.
   */
  SchemaProviderCfg getSchemaProvider(String name) throws ConfigException;



  /**
   * Registers to be notified when new Schema Providers are added.
   *
   * @param listener
   *          The Schema Provider configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addSchemaProviderAddListener(ConfigurationAddListener<SchemaProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Schema Provider configuration add listener.
   *
   * @param listener
   *          The Schema Provider configuration add listener.
   */
  void removeSchemaProviderAddListener(ConfigurationAddListener<SchemaProviderCfg> listener);



  /**
   * Registers to be notified when existing Schema Providers are deleted.
   *
   * @param listener
   *          The Schema Provider configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addSchemaProviderDeleteListener(ConfigurationDeleteListener<SchemaProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Schema Provider configuration delete listener.
   *
   * @param listener
   *          The Schema Provider configuration delete listener.
   */
  void removeSchemaProviderDeleteListener(ConfigurationDeleteListener<SchemaProviderCfg> listener);



  /**
   * Lists the Service Discovery Mechanisms.
   *
   * @return Returns an array containing the names of the
   *         Service Discovery Mechanisms.
   */
  String[] listServiceDiscoveryMechanisms();



  /**
   * Gets the named Service Discovery Mechanism.
   *
   * @param name
   *          The name of the Service Discovery Mechanism to retrieve.
   * @return Returns the named Service Discovery Mechanism.
   * @throws ConfigException
   *           If the Service Discovery Mechanism could not be found or it
   *           could not be successfully decoded.
   */
  ServiceDiscoveryMechanismCfg getServiceDiscoveryMechanism(String name) throws ConfigException;



  /**
   * Registers to be notified when new Service Discovery Mechanisms are added.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addServiceDiscoveryMechanismAddListener(ConfigurationAddListener<ServiceDiscoveryMechanismCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Service Discovery Mechanism configuration add listener.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration add listener.
   */
  void removeServiceDiscoveryMechanismAddListener(ConfigurationAddListener<ServiceDiscoveryMechanismCfg> listener);



  /**
   * Registers to be notified when existing Service Discovery Mechanisms are deleted.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addServiceDiscoveryMechanismDeleteListener(ConfigurationDeleteListener<ServiceDiscoveryMechanismCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Service Discovery Mechanism configuration delete listener.
   *
   * @param listener
   *          The Service Discovery Mechanism configuration delete listener.
   */
  void removeServiceDiscoveryMechanismDeleteListener(ConfigurationDeleteListener<ServiceDiscoveryMechanismCfg> listener);



  /**
   * Lists the Synchronization Providers.
   *
   * @return Returns an array containing the names of the
   *         Synchronization Providers.
   */
  String[] listSynchronizationProviders();



  /**
   * Gets the named Synchronization Provider.
   *
   * @param name
   *          The name of the Synchronization Provider to retrieve.
   * @return Returns the named Synchronization Provider.
   * @throws ConfigException
   *           If the Synchronization Provider could not be found or it
   *           could not be successfully decoded.
   */
  SynchronizationProviderCfg getSynchronizationProvider(String name) throws ConfigException;



  /**
   * Registers to be notified when new Synchronization Providers are added.
   *
   * @param listener
   *          The Synchronization Provider configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addSynchronizationProviderAddListener(ConfigurationAddListener<SynchronizationProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Synchronization Provider configuration add listener.
   *
   * @param listener
   *          The Synchronization Provider configuration add listener.
   */
  void removeSynchronizationProviderAddListener(ConfigurationAddListener<SynchronizationProviderCfg> listener);



  /**
   * Registers to be notified when existing Synchronization Providers are deleted.
   *
   * @param listener
   *          The Synchronization Provider configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addSynchronizationProviderDeleteListener(ConfigurationDeleteListener<SynchronizationProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Synchronization Provider configuration delete listener.
   *
   * @param listener
   *          The Synchronization Provider configuration delete listener.
   */
  void removeSynchronizationProviderDeleteListener(ConfigurationDeleteListener<SynchronizationProviderCfg> listener);



  /**
   * Lists the Trust Manager Providers.
   *
   * @return Returns an array containing the names of the
   *         Trust Manager Providers.
   */
  String[] listTrustManagerProviders();



  /**
   * Gets the named Trust Manager Provider.
   *
   * @param name
   *          The name of the Trust Manager Provider to retrieve.
   * @return Returns the named Trust Manager Provider.
   * @throws ConfigException
   *           If the Trust Manager Provider could not be found or it
   *           could not be successfully decoded.
   */
  TrustManagerProviderCfg getTrustManagerProvider(String name) throws ConfigException;



  /**
   * Registers to be notified when new Trust Manager Providers are added.
   *
   * @param listener
   *          The Trust Manager Provider configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addTrustManagerProviderAddListener(ConfigurationAddListener<TrustManagerProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Trust Manager Provider configuration add listener.
   *
   * @param listener
   *          The Trust Manager Provider configuration add listener.
   */
  void removeTrustManagerProviderAddListener(ConfigurationAddListener<TrustManagerProviderCfg> listener);



  /**
   * Registers to be notified when existing Trust Manager Providers are deleted.
   *
   * @param listener
   *          The Trust Manager Provider configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addTrustManagerProviderDeleteListener(ConfigurationDeleteListener<TrustManagerProviderCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Trust Manager Provider configuration delete listener.
   *
   * @param listener
   *          The Trust Manager Provider configuration delete listener.
   */
  void removeTrustManagerProviderDeleteListener(ConfigurationDeleteListener<TrustManagerProviderCfg> listener);



  /**
   * Lists the Virtual Attributes.
   *
   * @return Returns an array containing the names of the
   *         Virtual Attributes.
   */
  String[] listVirtualAttributes();



  /**
   * Gets the named Virtual Attribute.
   *
   * @param name
   *          The name of the Virtual Attribute to retrieve.
   * @return Returns the named Virtual Attribute.
   * @throws ConfigException
   *           If the Virtual Attribute could not be found or it
   *           could not be successfully decoded.
   */
  VirtualAttributeCfg getVirtualAttribute(String name) throws ConfigException;



  /**
   * Registers to be notified when new Virtual Attributes are added.
   *
   * @param listener
   *          The Virtual Attribute configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addVirtualAttributeAddListener(ConfigurationAddListener<VirtualAttributeCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Virtual Attribute configuration add listener.
   *
   * @param listener
   *          The Virtual Attribute configuration add listener.
   */
  void removeVirtualAttributeAddListener(ConfigurationAddListener<VirtualAttributeCfg> listener);



  /**
   * Registers to be notified when existing Virtual Attributes are deleted.
   *
   * @param listener
   *          The Virtual Attribute configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addVirtualAttributeDeleteListener(ConfigurationDeleteListener<VirtualAttributeCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Virtual Attribute configuration delete listener.
   *
   * @param listener
   *          The Virtual Attribute configuration delete listener.
   */
  void removeVirtualAttributeDeleteListener(ConfigurationDeleteListener<VirtualAttributeCfg> listener);



  /**
   * Gets the Work Queue.
   *
   * @return Returns the Work Queue.
   * @throws ConfigException
   *           If the Work Queue could not be found or it could not
   *           be successfully decoded.
   */
  WorkQueueCfg getWorkQueue() throws ConfigException;

}
