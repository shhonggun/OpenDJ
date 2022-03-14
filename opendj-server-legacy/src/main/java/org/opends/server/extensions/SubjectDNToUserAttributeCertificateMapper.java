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
 * Copyright 2007-2008 Sun Microsystems, Inc.
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.server.extensions;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.server.ConfigChangeResult;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SearchScope;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.server.config.server.CertificateMapperCfg;
import org.forgerock.opendj.server.config.server.SubjectDNToUserAttributeCertificateMapperCfg;
import org.opends.server.api.LocalBackend;
import org.opends.server.api.CertificateMapper;
import org.opends.server.core.BackendConfigManager;
import org.opends.server.core.DirectoryServer;
import org.opends.server.protocols.internal.InternalClientConnection;
import org.opends.server.protocols.internal.InternalSearchOperation;
import org.opends.server.protocols.internal.SearchRequest;
import org.opends.server.types.*;

import static org.opends.messages.ExtensionMessages.*;
import static org.opends.server.core.BackendConfigManager.NamingContextFilter.PUBLIC;
import static org.opends.server.core.BackendConfigManager.NamingContextFilter.TOP_LEVEL;
import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.protocols.internal.Requests.*;
import static org.opends.server.util.CollectionUtils.*;

/**
 * This class implements a very simple Directory Server certificate mapper that
 * will map a certificate to a user only if that user's entry contains an
 * attribute with the subject of the client certificate.  There must be exactly
 * one matching user entry for the mapping to be successful.
 */
public class SubjectDNToUserAttributeCertificateMapper
       extends CertificateMapper<
                    SubjectDNToUserAttributeCertificateMapperCfg>
       implements ConfigurationChangeListener<
                       SubjectDNToUserAttributeCertificateMapperCfg>
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /** The DN of the configuration entry for this certificate mapper. */
  private DN configEntryDN;

  /** The current configuration for this certificate mapper. */
  private SubjectDNToUserAttributeCertificateMapperCfg currentConfig;

  /** The set of attributes to return in search result entries. */
  private LinkedHashSet<String> requestedAttributes;

  /**
   * Creates a new instance of this certificate mapper.  Note that all actual
   * initialization should be done in the
   * <CODE>initializeCertificateMapper</CODE> method.
   */
  public SubjectDNToUserAttributeCertificateMapper()
  {
    super();
  }

  @Override
  public void initializeCertificateMapper(
                   SubjectDNToUserAttributeCertificateMapperCfg
                        configuration)
         throws ConfigException, InitializationException
  {
    configuration.addSubjectDNToUserAttributeChangeListener(this);

    currentConfig = configuration;
    configEntryDN = configuration.dn();

    // Make sure that the subject attribute is configured for equality in all
    // appropriate backends.
    Set<DN> cfgBaseDNs = configuration.getUserBaseDN();
    BackendConfigManager backendConfigManager =
        DirectoryServer.getInstance().getServerContext().getBackendConfigManager();
    if (cfgBaseDNs == null || cfgBaseDNs.isEmpty())
    {
      cfgBaseDNs = backendConfigManager.getNamingContexts(PUBLIC, TOP_LEVEL);
    }

    AttributeType t = configuration.getSubjectAttribute();
    for (DN baseDN : cfgBaseDNs)
    {
      LocalBackend<?> b = backendConfigManager.findLocalBackendForEntry(baseDN);
      if (b != null && ! b.isIndexed(t, IndexType.EQUALITY))
      {
        logger.warn(WARN_SATUACM_ATTR_UNINDEXED, configuration.dn(),
            t.getNameOrOID(), b.getBackendID());
      }
    }

    // Create the attribute list to include in search requests.  We want to
    // include all user and operational attributes.
    requestedAttributes = newLinkedHashSet("*", "+");
  }

  @Override
  public void finalizeCertificateMapper()
  {
    currentConfig.removeSubjectDNToUserAttributeChangeListener(this);
  }

  @Override
  public Entry mapCertificateToUser(Certificate[] certificateChain)
         throws DirectoryException
  {
    SubjectDNToUserAttributeCertificateMapperCfg config =
         currentConfig;
    AttributeType subjectAttributeType = config.getSubjectAttribute();

    // Make sure that a peer certificate was provided.
    if (certificateChain == null || certificateChain.length == 0)
    {
      LocalizableMessage message = ERR_SDTUACM_NO_PEER_CERTIFICATE.get();
      throw new DirectoryException(ResultCode.INVALID_CREDENTIALS, message);
    }

    // Get the first certificate in the chain.  It must be an X.509 certificate.
    X509Certificate peerCertificate;
    try
    {
      peerCertificate = (X509Certificate) certificateChain[0];
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage message = ERR_SDTUACM_PEER_CERT_NOT_X509.get(certificateChain[0].getType());
      throw new DirectoryException(ResultCode.INVALID_CREDENTIALS, message);
    }

    // Get the subject from the peer certificate and use it to create a search
    // filter.
    X500Principal peerPrincipal = peerCertificate.getSubjectX500Principal();
    String peerName = peerPrincipal.getName(X500Principal.RFC2253);
    SearchFilter filter = SearchFilter.createEqualityFilter(
        subjectAttributeType, ByteString.valueOfUtf8(peerName));

    // If we have an explicit set of base DNs, then use it.  Otherwise, use the
    // set of public naming contexts in the server.
    Collection<DN> baseDNs = config.getUserBaseDN();
    if (baseDNs == null || baseDNs.isEmpty())
    {
      baseDNs = DirectoryServer.getInstance().getServerContext().getBackendConfigManager()
          .getNamingContexts(PUBLIC, TOP_LEVEL);
    }

    // For each base DN, issue an internal search in an attempt to map the
    // certificate.
    Entry userEntry = null;
    InternalClientConnection conn = getRootConnection();
    for (DN baseDN : baseDNs)
    {
      final SearchRequest request = newSearchRequest(baseDN, SearchScope.WHOLE_SUBTREE, filter)
          .setSizeLimit(1)
          .setTimeLimit(10)
          .addAttribute(requestedAttributes);
      InternalSearchOperation searchOperation = conn.processSearch(request);
      switch (searchOperation.getResultCode().asEnum())
      {
        case SUCCESS:
          // This is fine.  No action needed.
          break;

        case NO_SUCH_OBJECT:
          // The search base doesn't exist.  Not an ideal situation, but we'll
          // ignore it.
          break;

        case SIZE_LIMIT_EXCEEDED:
          // Multiple entries matched the filter.  This is not acceptable.
          LocalizableMessage message = ERR_SDTUACM_MULTIPLE_SEARCH_MATCHING_ENTRIES.get(
                        peerName);
          throw new DirectoryException(
                  ResultCode.INVALID_CREDENTIALS, message);

        case TIME_LIMIT_EXCEEDED:
        case ADMIN_LIMIT_EXCEEDED:
          // The search criteria was too inefficient.
          message = ERR_SDTUACM_INEFFICIENT_SEARCH.get(peerName, searchOperation.getErrorMessage());
          throw new DirectoryException(searchOperation.getResultCode(), message);

        default:
          // Just pass on the failure that was returned for this search.
          message = ERR_SDTUACM_SEARCH_FAILED.get(peerName, searchOperation.getErrorMessage());
          throw new DirectoryException(searchOperation.getResultCode(), message);
      }

      for (SearchResultEntry entry : searchOperation.getSearchEntries())
      {
        if (userEntry == null)
        {
          userEntry = entry;
        }
        else
        {
          LocalizableMessage message = ERR_SDTUACM_MULTIPLE_MATCHING_ENTRIES.
              get(peerName, userEntry.getName(), entry.getName());
          throw new DirectoryException(ResultCode.INVALID_CREDENTIALS, message);
        }
      }
    }

    // If we've gotten here, then we either found exactly one user entry or we
    // didn't find any.  Either way, return the entry or null to the caller.
    return userEntry;
  }

  @Override
  public boolean isConfigurationAcceptable(CertificateMapperCfg configuration,
                                           List<LocalizableMessage> unacceptableReasons)
  {
    SubjectDNToUserAttributeCertificateMapperCfg config =
         (SubjectDNToUserAttributeCertificateMapperCfg) configuration;
    return isConfigurationChangeAcceptable(config, unacceptableReasons);
  }

  @Override
  public boolean isConfigurationChangeAcceptable(
                      SubjectDNToUserAttributeCertificateMapperCfg
                           configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    return true;
  }

  @Override
  public ConfigChangeResult applyConfigurationChange(
              SubjectDNToUserAttributeCertificateMapperCfg
                   configuration)
  {
    currentConfig = configuration;
    return new ConfigChangeResult();
  }
}
