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
import org.forgerock.opendj.ldap.AddressMask;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.AccessLogFilteringCriteriaCfgDefn.LogRecordType;
import org.forgerock.opendj.server.config.server.AccessLogFilteringCriteriaCfg;



/**
 * A client-side interface for reading and modifying Access Log
 * Filtering Criteria settings.
 * <p>
 * A set of rules which together determine whether a log record should
 * be logged or not.
 */
public interface AccessLogFilteringCriteriaCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Access Log Filtering Criteria.
   *
   * @return Returns the configuration definition associated with this Access Log Filtering Criteria.
   */
  ManagedObjectDefinition<? extends AccessLogFilteringCriteriaCfgClient, ? extends AccessLogFilteringCriteriaCfg> definition();



  /**
   * Gets the "connection-client-address-equal-to" property.
   * <p>
   * Filters log records associated with connections which match at
   * least one of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the values of the "connection-client-address-equal-to" property.
   */
  SortedSet<AddressMask> getConnectionClientAddressEqualTo();



  /**
   * Sets the "connection-client-address-equal-to" property.
   * <p>
   * Filters log records associated with connections which match at
   * least one of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @param values The values of the "connection-client-address-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setConnectionClientAddressEqualTo(Collection<AddressMask> values) throws PropertyException;



  /**
   * Gets the "connection-client-address-not-equal-to" property.
   * <p>
   * Filters log records associated with connections which do not
   * match any of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @return Returns the values of the "connection-client-address-not-equal-to" property.
   */
  SortedSet<AddressMask> getConnectionClientAddressNotEqualTo();



  /**
   * Sets the "connection-client-address-not-equal-to" property.
   * <p>
   * Filters log records associated with connections which do not
   * match any of the specified client host names or address masks.
   * <p>
   * Valid values include a host name, a fully qualified domain name,
   * a domain name, an IP address, or a subnetwork with subnetwork
   * mask.
   *
   * @param values The values of the "connection-client-address-not-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setConnectionClientAddressNotEqualTo(Collection<AddressMask> values) throws PropertyException;



  /**
   * Gets the "connection-port-equal-to" property.
   * <p>
   * Filters log records associated with connections to any of the
   * specified listener port numbers.
   *
   * @return Returns the values of the "connection-port-equal-to" property.
   */
  SortedSet<Integer> getConnectionPortEqualTo();



  /**
   * Sets the "connection-port-equal-to" property.
   * <p>
   * Filters log records associated with connections to any of the
   * specified listener port numbers.
   *
   * @param values The values of the "connection-port-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setConnectionPortEqualTo(Collection<Integer> values) throws PropertyException;



  /**
   * Gets the "connection-protocol-equal-to" property.
   * <p>
   * Filters log records associated with connections which match any
   * of the specified protocols.
   * <p>
   * Typical values include "ldap", "ldaps", or "jmx".
   *
   * @return Returns the values of the "connection-protocol-equal-to" property.
   */
  SortedSet<String> getConnectionProtocolEqualTo();



  /**
   * Sets the "connection-protocol-equal-to" property.
   * <p>
   * Filters log records associated with connections which match any
   * of the specified protocols.
   * <p>
   * Typical values include "ldap", "ldaps", or "jmx".
   *
   * @param values The values of the "connection-protocol-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setConnectionProtocolEqualTo(Collection<String> values) throws PropertyException;



  /**
   * Gets the "log-record-type" property.
   * <p>
   * Filters log records based on their type.
   *
   * @return Returns the values of the "log-record-type" property.
   */
  SortedSet<LogRecordType> getLogRecordType();



  /**
   * Sets the "log-record-type" property.
   * <p>
   * Filters log records based on their type.
   *
   * @param values The values of the "log-record-type" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setLogRecordType(Collection<LogRecordType> values) throws PropertyException;



  /**
   * Gets the "request-target-dn-equal-to" property.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching at least one of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the values of the "request-target-dn-equal-to" property.
   */
  SortedSet<String> getRequestTargetDNEqualTo();



  /**
   * Sets the "request-target-dn-equal-to" property.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching at least one of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @param values The values of the "request-target-dn-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRequestTargetDNEqualTo(Collection<String> values) throws PropertyException;



  /**
   * Gets the "request-target-dn-not-equal-to" property.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching none of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the values of the "request-target-dn-not-equal-to" property.
   */
  SortedSet<String> getRequestTargetDNNotEqualTo();



  /**
   * Sets the "request-target-dn-not-equal-to" property.
   * <p>
   * Filters operation log records associated with operations which
   * target entries matching none of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @param values The values of the "request-target-dn-not-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setRequestTargetDNNotEqualTo(Collection<String> values) throws PropertyException;



  /**
   * Gets the "response-etime-greater-than" property.
   * <p>
   * Filters operation response log records associated with operations
   * which took longer than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the value of the "response-etime-greater-than" property.
   */
  Integer getResponseEtimeGreaterThan();



  /**
   * Sets the "response-etime-greater-than" property.
   * <p>
   * Filters operation response log records associated with operations
   * which took longer than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param value The value of the "response-etime-greater-than" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setResponseEtimeGreaterThan(Integer value) throws PropertyException;



  /**
   * Gets the "response-etime-less-than" property.
   * <p>
   * Filters operation response log records associated with operations
   * which took less than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the value of the "response-etime-less-than" property.
   */
  Integer getResponseEtimeLessThan();



  /**
   * Sets the "response-etime-less-than" property.
   * <p>
   * Filters operation response log records associated with operations
   * which took less than the specified number of milli-seconds to
   * complete.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param value The value of the "response-etime-less-than" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setResponseEtimeLessThan(Integer value) throws PropertyException;



  /**
   * Gets the "response-result-code-equal-to" property.
   * <p>
   * Filters operation response log records associated with operations
   * which include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the values of the "response-result-code-equal-to" property.
   */
  SortedSet<Integer> getResponseResultCodeEqualTo();



  /**
   * Sets the "response-result-code-equal-to" property.
   * <p>
   * Filters operation response log records associated with operations
   * which include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param values The values of the "response-result-code-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setResponseResultCodeEqualTo(Collection<Integer> values) throws PropertyException;



  /**
   * Gets the "response-result-code-not-equal-to" property.
   * <p>
   * Filters operation response log records associated with operations
   * which do not include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the values of the "response-result-code-not-equal-to" property.
   */
  SortedSet<Integer> getResponseResultCodeNotEqualTo();



  /**
   * Sets the "response-result-code-not-equal-to" property.
   * <p>
   * Filters operation response log records associated with operations
   * which do not include any of the specified result codes.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param values The values of the "response-result-code-not-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setResponseResultCodeNotEqualTo(Collection<Integer> values) throws PropertyException;



  /**
   * Gets the "search-response-is-indexed" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which were either indexed or unindexed.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the value of the "search-response-is-indexed" property.
   */
  Boolean isSearchResponseIsIndexed();



  /**
   * Sets the "search-response-is-indexed" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which were either indexed or unindexed.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param value The value of the "search-response-is-indexed" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSearchResponseIsIndexed(Boolean value) throws PropertyException;



  /**
   * Gets the "search-response-nentries-greater-than" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned more than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the value of the "search-response-nentries-greater-than" property.
   */
  Integer getSearchResponseNentriesGreaterThan();



  /**
   * Sets the "search-response-nentries-greater-than" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned more than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param value The value of the "search-response-nentries-greater-than" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSearchResponseNentriesGreaterThan(Integer value) throws PropertyException;



  /**
   * Gets the "search-response-nentries-less-than" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned less than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @return Returns the value of the "search-response-nentries-less-than" property.
   */
  Integer getSearchResponseNentriesLessThan();



  /**
   * Sets the "search-response-nentries-less-than" property.
   * <p>
   * Filters search operation response log records associated with
   * searches which returned less than the specified number of entries.
   * <p>
   * It is recommended to only use this criteria in conjunction with
   * the "combined" output mode of the access logger, since this filter
   * criteria is only applied to response log messages.
   *
   * @param value The value of the "search-response-nentries-less-than" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setSearchResponseNentriesLessThan(Integer value) throws PropertyException;



  /**
   * Gets the "user-dn-equal-to" property.
   * <p>
   * Filters log records associated with users matching at least one
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the values of the "user-dn-equal-to" property.
   */
  SortedSet<String> getUserDNEqualTo();



  /**
   * Sets the "user-dn-equal-to" property.
   * <p>
   * Filters log records associated with users matching at least one
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @param values The values of the "user-dn-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setUserDNEqualTo(Collection<String> values) throws PropertyException;



  /**
   * Gets the "user-dn-not-equal-to" property.
   * <p>
   * Filters log records associated with users which do not match any
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @return Returns the values of the "user-dn-not-equal-to" property.
   */
  SortedSet<String> getUserDNNotEqualTo();



  /**
   * Sets the "user-dn-not-equal-to" property.
   * <p>
   * Filters log records associated with users which do not match any
   * of the specified DN patterns.
   * <p>
   * Valid DN filters are strings composed of zero or more wildcards.
   * A double wildcard ** replaces one or more RDN components (as in
   * uid=dmiller,**,dc=example,dc=com). A simple wildcard * replaces
   * either a whole RDN, or a whole type, or a value substring (as in
   * uid=bj*,ou=people,dc=example,dc=com).
   *
   * @param values The values of the "user-dn-not-equal-to" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setUserDNNotEqualTo(Collection<String> values) throws PropertyException;



  /**
   * Gets the "user-is-member-of" property.
   * <p>
   * Filters log records associated with users which are members of at
   * least one of the specified groups.
   *
   * @return Returns the values of the "user-is-member-of" property.
   */
  SortedSet<DN> getUserIsMemberOf();



  /**
   * Sets the "user-is-member-of" property.
   * <p>
   * Filters log records associated with users which are members of at
   * least one of the specified groups.
   *
   * @param values The values of the "user-is-member-of" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setUserIsMemberOf(Collection<DN> values) throws PropertyException;



  /**
   * Gets the "user-is-not-member-of" property.
   * <p>
   * Filters log records associated with users which are not members
   * of any of the specified groups.
   *
   * @return Returns the values of the "user-is-not-member-of" property.
   */
  SortedSet<DN> getUserIsNotMemberOf();



  /**
   * Sets the "user-is-not-member-of" property.
   * <p>
   * Filters log records associated with users which are not members
   * of any of the specified groups.
   *
   * @param values The values of the "user-is-not-member-of" property.
   * @throws PropertyException
   *           If one or more of the new values are invalid.
   */
  void setUserIsNotMemberOf(Collection<DN> values) throws PropertyException;

}
