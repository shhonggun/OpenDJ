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
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.meta.LDAPPassThroughAuthenticationPolicyCfgDefn.MappingPolicy;



/**
 * A server-side interface for querying LDAP Pass Through
 * Authentication Policy settings.
 * <p>
 * An authentication policy for users whose credentials are managed by
 * a remote LDAP directory service.
 */
public interface LDAPPassThroughAuthenticationPolicyCfg extends AuthenticationPolicyCfg {

  /**
   * Gets the configuration class associated with this LDAP Pass Through Authentication Policy.
   *
   * @return Returns the configuration class associated with this LDAP Pass Through Authentication Policy.
   */
  Class<? extends LDAPPassThroughAuthenticationPolicyCfg> configurationClass();



  /**
   * Register to be notified when this LDAP Pass Through Authentication Policy is changed.
   *
   * @param listener
   *          The LDAP Pass Through Authentication Policy configuration change listener.
   */
  void addLDAPPassThroughChangeListener(ConfigurationChangeListener<LDAPPassThroughAuthenticationPolicyCfg> listener);



  /**
   * Deregister an existing LDAP Pass Through Authentication Policy configuration change listener.
   *
   * @param listener
   *          The LDAP Pass Through Authentication Policy configuration change listener.
   */
  void removeLDAPPassThroughChangeListener(ConfigurationChangeListener<LDAPPassThroughAuthenticationPolicyCfg> listener);



  /**
   * Gets the "cached-password-storage-scheme" property.
   * <p>
   * Specifies the name of a password storage scheme which should be
   * used for encoding cached passwords.
   * <p>
   * Changing the password storage scheme will cause all existing
   * cached passwords to be discarded.
   *
   * @return Returns the value of the "cached-password-storage-scheme" property.
   */
  String getCachedPasswordStorageScheme();



  /**
   * Gets the "cached-password-storage-scheme" property as a DN.
   * <p>
   * Specifies the name of a password storage scheme which should be
   * used for encoding cached passwords.
   * <p>
   * Changing the password storage scheme will cause all existing
   * cached passwords to be discarded.
   *
   * @return Returns the DN value of the
   *         "cached-password-storage-scheme" property.
   */
  DN getCachedPasswordStorageSchemeDN();



  /**
   * Gets the "cached-password-ttl" property.
   * <p>
   * Specifies the maximum length of time that a locally cached
   * password may be used for authentication before it is refreshed
   * from the remote LDAP service.
   * <p>
   * This property represents a cache timeout. Increasing the timeout
   * period decreases the frequency that bind operations are delegated
   * to the remote LDAP service, but increases the risk of users
   * authenticating using stale passwords. Note that authentication
   * attempts which fail because the provided password does not match
   * the locally cached password will always be retried against the
   * remote LDAP service.
   *
   * @return Returns the value of the "cached-password-ttl" property.
   */
  long getCachedPasswordTTL();



  /**
   * Gets the "connection-timeout" property.
   * <p>
   * Specifies the timeout used when connecting to remote LDAP
   * directory servers, performing SSL negotiation, and for individual
   * search and bind requests.
   * <p>
   * If the timeout expires then the current operation will be aborted
   * and retried against another LDAP server if one is available.
   *
   * @return Returns the value of the "connection-timeout" property.
   */
  long getConnectionTimeout();



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class which
   * provides the LDAP Pass Through Authentication Policy
   * implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "mapped-attribute" property.
   * <p>
   * Specifies one or more attributes in the user's entry whose
   * value(s) will determine the bind DN used when authenticating to
   * the remote LDAP directory service. This property is mandatory when
   * using the "mapped-bind" or "mapped-search" mapping policies.
   * <p>
   * At least one value must be provided. All values must refer to the
   * name or OID of an attribute type defined in the directory server
   * schema. At least one of the named attributes must exist in a
   * user's local entry in order for authentication to proceed. When
   * multiple attributes or values are found in the user's entry then
   * the behavior is determined by the mapping policy.
   *
   * @return Returns an unmodifiable set containing the values of the "mapped-attribute" property.
   */
  SortedSet<AttributeType> getMappedAttribute();



  /**
   * Gets the "mapped-search-base-dn" property.
   * <p>
   * Specifies the set of base DNs below which to search for users in
   * the remote LDAP directory service. This property is mandatory when
   * using the "mapped-search" mapping policy.
   * <p>
   * If multiple values are given, searches are performed below all
   * specified base DNs.
   *
   * @return Returns an unmodifiable set containing the values of the "mapped-search-base-dn" property.
   */
  SortedSet<DN> getMappedSearchBaseDN();



  /**
   * Gets the "mapped-search-bind-dn" property.
   * <p>
   * Specifies the bind DN which should be used to perform user
   * searches in the remote LDAP directory service.
   *
   * @return Returns the value of the "mapped-search-bind-dn" property.
   */
  DN getMappedSearchBindDN();



  /**
   * Gets the "mapped-search-bind-password" property.
   * <p>
   * Specifies the bind password which should be used to perform user
   * searches in the remote LDAP directory service.
   *
   * @return Returns the value of the "mapped-search-bind-password" property.
   */
  String getMappedSearchBindPassword();



  /**
   * Gets the "mapped-search-bind-password-environment-variable" property.
   * <p>
   * Specifies the name of an environment variable containing the bind
   * password which should be used to perform user searches in the
   * remote LDAP directory service.
   *
   * @return Returns the value of the "mapped-search-bind-password-environment-variable" property.
   */
  String getMappedSearchBindPasswordEnvironmentVariable();



  /**
   * Gets the "mapped-search-bind-password-file" property.
   * <p>
   * Specifies the name of a file containing the bind password which
   * should be used to perform user searches in the remote LDAP
   * directory service.
   *
   * @return Returns the value of the "mapped-search-bind-password-file" property.
   */
  String getMappedSearchBindPasswordFile();



  /**
   * Gets the "mapped-search-bind-password-property" property.
   * <p>
   * Specifies the name of a Java property containing the bind
   * password which should be used to perform user searches in the
   * remote LDAP directory service.
   *
   * @return Returns the value of the "mapped-search-bind-password-property" property.
   */
  String getMappedSearchBindPasswordProperty();



  /**
   * Gets the "mapped-search-filter-template" property.
   * <p>
   * If defined, overrides the filter used when searching for the
   * user, substituting %s with the value of the local entry's
   * "mapped-attribute".
   * <p>
   * The filter-template may include ZERO or ONE %s substitutions. If
   * multiple mapped-attributes are configured, multiple renditions of
   * this template will be aggregated into one larger filter using an
   * OR (|) operator. An example use-case for this property would be to
   * use a different attribute type on the mapped search. For example,
   * mapped-attribute could be set to "uid" and filter-template to
   * "(samAccountName=%s)". You can also use the filter to restrict
   * search results. For example: "(&(uid=%s)(objectclass=student))"
   *
   * @return Returns the value of the "mapped-search-filter-template" property.
   */
  String getMappedSearchFilterTemplate();



  /**
   * Gets the "mapping-policy" property.
   * <p>
   * Specifies the mapping algorithm for obtaining the bind DN from
   * the user's entry.
   *
   * @return Returns the value of the "mapping-policy" property.
   */
  MappingPolicy getMappingPolicy();



  /**
   * Gets the "primary-remote-ldap-server" property.
   * <p>
   * Specifies the primary list of remote LDAP servers which should be
   * used for pass through authentication.
   * <p>
   * If more than one LDAP server is specified then operations may be
   * distributed across them. If all of the primary LDAP servers are
   * unavailable then operations will fail-over to the set of secondary
   * LDAP servers, if defined.
   *
   * @return Returns an unmodifiable set containing the values of the "primary-remote-ldap-server" property.
   */
  SortedSet<String> getPrimaryRemoteLDAPServer();



  /**
   * Gets the "secondary-remote-ldap-server" property.
   * <p>
   * Specifies the secondary list of remote LDAP servers which should
   * be used for pass through authentication in the event that the
   * primary LDAP servers are unavailable.
   * <p>
   * If more than one LDAP server is specified then operations may be
   * distributed across them. Operations will be rerouted to the
   * primary LDAP servers as soon as they are determined to be
   * available.
   *
   * @return Returns an unmodifiable set containing the values of the "secondary-remote-ldap-server" property.
   */
  SortedSet<String> getSecondaryRemoteLDAPServer();



  /**
   * Gets the "source-address" property.
   * <p>
   * If specified, the server will bind to the address before
   * connecting to the remote server.
   * <p>
   * The address must be one assigned to an existing network
   * interface.
   *
   * @return Returns the value of the "source-address" property.
   */
  InetAddress getSourceAddress();



  /**
   * Gets the "ssl-cipher-suite" property.
   * <p>
   * Specifies the names of the SSL cipher suites that are allowed for
   * use in SSL based LDAP connections.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-cipher-suite" property.
   */
  SortedSet<String> getSSLCipherSuite();



  /**
   * Gets the "ssl-protocol" property.
   * <p>
   * Specifies the names of the SSL protocols which are allowed for
   * use in SSL based LDAP connections.
   *
   * @return Returns an unmodifiable set containing the values of the "ssl-protocol" property.
   */
  SortedSet<String> getSSLProtocol();



  /**
   * Gets the "trust-manager-provider" property.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with remote LDAP directory servers.
   *
   * @return Returns the value of the "trust-manager-provider" property.
   */
  String getTrustManagerProvider();



  /**
   * Gets the "trust-manager-provider" property as a DN.
   * <p>
   * Specifies the name of the trust manager that should be used when
   * negotiating SSL connections with remote LDAP directory servers.
   *
   * @return Returns the DN value of the "trust-manager-provider"
   *         property.
   */
  DN getTrustManagerProviderDN();



  /**
   * Gets the "use-password-caching" property.
   * <p>
   * Indicates whether passwords should be cached locally within the
   * user's entry.
   *
   * @return Returns the value of the "use-password-caching" property.
   */
  boolean isUsePasswordCaching();



  /**
   * Gets the "use-ssl" property.
   * <p>
   * Indicates whether the LDAP Pass Through Authentication Policy
   * should use SSL.
   * <p>
   * If enabled, the LDAP Pass Through Authentication Policy will use
   * SSL to encrypt communication with the clients.
   *
   * @return Returns the value of the "use-ssl" property.
   */
  boolean isUseSSL();



  /**
   * Gets the "use-tcp-keep-alive" property.
   * <p>
   * Indicates whether LDAP connections should use TCP keep-alive.
   * <p>
   * If enabled, the SO_KEEPALIVE socket option is used to indicate
   * that TCP keepalive messages should periodically be sent to the
   * client to verify that the associated connection is still valid.
   * This may also help prevent cases in which intermediate network
   * hardware could silently drop an otherwise idle client connection,
   * provided that the keepalive interval configured in the underlying
   * operating system is smaller than the timeout enforced by the
   * network hardware.
   *
   * @return Returns the value of the "use-tcp-keep-alive" property.
   */
  boolean isUseTCPKeepAlive();



  /**
   * Gets the "use-tcp-no-delay" property.
   * <p>
   * Indicates whether LDAP connections should use TCP no-delay.
   * <p>
   * If enabled, the TCP_NODELAY socket option is used to ensure that
   * response messages to the client are sent immediately rather than
   * potentially waiting to determine whether additional response
   * messages can be sent in the same packet. In most cases, using the
   * TCP_NODELAY socket option provides better performance and lower
   * response times, but disabling it may help for some cases in which
   * the server sends a large number of entries to a client in response
   * to a search request.
   *
   * @return Returns the value of the "use-tcp-no-delay" property.
   */
  boolean isUseTCPNoDelay();

}
