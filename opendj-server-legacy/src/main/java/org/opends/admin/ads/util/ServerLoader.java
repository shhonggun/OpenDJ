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
 * Copyright 2008-2010 Sun Microsystems, Inc.
 * Portions Copyright 2013-2016 ForgeRock AS.
 */
package org.opends.admin.ads.util;

import static org.forgerock.opendj.ldap.LdapException.*;
import static org.forgerock.opendj.ldap.ResultCode.*;
import static org.opends.admin.ads.util.PreferredConnection.Type.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.ldap.AuthenticationException;
import org.forgerock.opendj.ldap.AuthorizationException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.ResultCode;
import org.opends.admin.ads.ADSContext;
import org.opends.admin.ads.ADSContext.ServerProperty;
import org.opends.admin.ads.ServerDescriptor;
import org.opends.admin.ads.TopologyCacheException;
import org.opends.admin.ads.TopologyCacheException.Type;
import org.opends.admin.ads.TopologyCacheFilter;
import org.opends.server.types.HostPort;

import com.forgerock.opendj.cli.Utils;

/**
 * Class used to load the configuration of a server.  Basically the code
 * uses some provided properties and authentication information to connect
 * to the server and then generate a ServerDescriptor object based on the
 * read configuration.
 */
public class ServerLoader extends Thread
{
  private final Map<ServerProperty, Object> serverProperties;
  private boolean isOver;
  private boolean isInterrupted;
  private HostPort lastLdapHostPort;
  private TopologyCacheException lastException;
  private ServerDescriptor serverDescriptor;
  private final ApplicationTrustManager trustManager;
  private final int timeout;
  private final DN dn;
  private final String pwd;
  private final LinkedHashSet<PreferredConnection> preferredLDAPURLs;
  private final TopologyCacheFilter filter;

  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /**
   * Constructor.
   * @param serverProperties the server properties of the server we want to
   * load.
   * @param dn the DN that we must use to bind to the server.
   * @param pwd the password that we must use to bind to the server.
   * @param trustManager the ApplicationTrustManager to be used when we try
   * to connect to the server.
   * @param timeout the timeout to establish the connection in milliseconds.
   * Use {@code 0} to express no timeout.
   * @param preferredLDAPURLs the list of preferred LDAP URLs that we want
   * to use to connect to the server.  They will be used only if they correspond
   * to the URLs that we found in the the server properties.
   * @param filter the topology cache filter to be used.  This can be used not
   * to retrieve all the information.
   */
  public ServerLoader(Map<ServerProperty,Object> serverProperties,
      DN dn, String pwd, ApplicationTrustManager trustManager, int timeout,
      Set<PreferredConnection> preferredLDAPURLs,
      TopologyCacheFilter filter)
  {
    this.serverProperties = serverProperties;
    this.dn = dn;
    this.pwd = pwd;
    this.trustManager = trustManager;
    this.timeout = timeout;
    this.preferredLDAPURLs = new LinkedHashSet<>(preferredLDAPURLs);
    this.filter = filter;
  }

  /**
   * Returns the ServerDescriptor that could be retrieved.
   * @return the ServerDescriptor that could be retrieved.
   */
  public ServerDescriptor getServerDescriptor()
  {
    if (serverDescriptor == null)
    {
      serverDescriptor = ServerDescriptor.createStandalone(serverProperties);
    }
    serverDescriptor.setLastException(lastException);
    return serverDescriptor;
  }

  /**
   * Returns the last exception that occurred while trying to generate
   * the ServerDescriptor object.
   * @return the last exception that occurred while trying to generate
   * the ServerDescriptor object.
   */
  public TopologyCacheException getLastException()
  {
    return lastException;
  }

  @Override
  public void interrupt()
  {
    if (!isOver)
    {
      isInterrupted = true;
      HostPort ldapUrl = lastLdapHostPort;
      if (ldapUrl == null)
      {
        try
        {
          LinkedHashSet<PreferredConnection> urls = getLDAPURLsByPreference();
          if (!urls.isEmpty())
          {
            ldapUrl = urls.iterator().next().getHostPort();
          }
        }
        catch (LdapException e)
        {
          lastException = new TopologyCacheException(
              TopologyCacheException.Type.GENERIC_READING_SERVER,
              newLdapException(ResultCode.CLIENT_SIDE_PARAM_ERROR,
              e.getLocalizedMessage()), trustManager, ldapUrl);
        }
      }
      final String diagnosticMsg = "Timeout reading server: " + ldapUrl;
      lastException = new TopologyCacheException(
          TopologyCacheException.Type.TIMEOUT,
          newLdapException(ResultCode.TIME_LIMIT_EXCEEDED, diagnosticMsg),
          trustManager, ldapUrl);
      logger.warn(LocalizableMessage.raw(diagnosticMsg));
    }
    super.interrupt();
  }

  /** The method where we try to generate the ServerDescriptor object. */
  @Override
  public void run()
  {
    lastException = null;
    boolean connCreated = false;
    try (ConnectionWrapper conn = createConnectionWrapper())
    {
      connCreated = true;
      serverDescriptor = ServerDescriptor.createStandalone(conn, filter);
      serverDescriptor.setAdsProperties(serverProperties);
      serverDescriptor.updateAdsPropertiesWithServerProperties();
    }
    catch (AuthorizationException e)
    {
      logger.warn(LocalizableMessage.raw("Permissions error reading server: " + lastLdapHostPort, e));
      Type type = isAdministratorDn()
          ? TopologyCacheException.Type.NO_PERMISSIONS
          : TopologyCacheException.Type.NOT_GLOBAL_ADMINISTRATOR;
      lastException = new TopologyCacheException(type, e, trustManager, lastLdapHostPort);
    }
    catch (AuthenticationException e)
    {
      logger.warn(LocalizableMessage.raw("Authentication exception: " + lastLdapHostPort, e));
      Type type = isAdministratorDn()
          ? TopologyCacheException.Type.GENERIC_READING_SERVER
          : TopologyCacheException.Type.NOT_GLOBAL_ADMINISTRATOR;
      lastException = new TopologyCacheException(type, e, trustManager, lastLdapHostPort);
    }
    catch (LdapException e)
    {
      logger.warn(LocalizableMessage.raw("LdapException error reading server: " + lastLdapHostPort, e));
      Type type = connCreated
          ? TopologyCacheException.Type.GENERIC_READING_SERVER
          : TopologyCacheException.Type.GENERIC_CREATING_CONNECTION;
      lastException = new TopologyCacheException(type, e, trustManager, lastLdapHostPort);
    }
    catch (Throwable t)
    {
      if (!isInterrupted)
      {
        logger.warn(LocalizableMessage.raw("Generic error reading server: " + lastLdapHostPort, t));
        logger.warn(LocalizableMessage.raw("server Properties: " + serverProperties));
        lastException = new TopologyCacheException(TopologyCacheException.Type.BUG, t);
      }
    }
    finally
    {
      isOver = true;
    }
  }

  /**
   * Returns a Connection Wrapper.
   *
   * @return the connection wrapper
   * @throws LdapException
   *           If an error occurs.
   */
  public ConnectionWrapper createConnectionWrapper() throws LdapException
  {
    if (trustManager != null)
    {
      trustManager.resetLastRefusedItems();

      String host = (String)serverProperties.get(ServerProperty.HOST_NAME);
      trustManager.setHost(host);
    }

    /* Try to connect to the server in a certain order of preference.  If an
     * URL fails, we will try with the others.
     */
    for (PreferredConnection conn : getLDAPURLsByPreference())
    {
      lastLdapHostPort = conn.getHostPort();
      return new ConnectionWrapper(conn.getHostPort(), conn.getType(), dn, pwd, timeout, trustManager);
    }
    return null;
  }

  /**
   * Returns the non-secure LDAP URL for the given server properties.  It
   * returns NULL if according to the server properties no non-secure LDAP URL
   * can be generated (LDAP disabled or port not defined).
   * @param serverProperties the server properties to be used to generate
   * the non-secure LDAP URL.
   * @return the non-secure LDAP URL for the given server properties.
   */
  private String getLdapUrl(Map<ServerProperty,Object> serverProperties)
  {
    if (isLdapEnabled(serverProperties))
    {
      return "ldap://" + getHostNameForLdapUrl(serverProperties) + ":"
          + serverProperties.get(ServerProperty.LDAP_PORT);
    }
    return null;
  }

  /**
   * Returns the StartTLS LDAP URL for the given server properties.  It
   * returns NULL if according to the server properties no StartTLS LDAP URL
   * can be generated (StartTLS disabled or port not defined).
   * @param serverProperties the server properties to be used to generate
   * the StartTLS LDAP URL.
   * @return the StartTLS LDAP URL for the given server properties.
   */
  private String getStartTlsLdapUrl(Map<ServerProperty,Object> serverProperties)
  {
    if (isStartTlsEnabled(serverProperties))
    {
      return "ldap://" + getHostNameForLdapUrl(serverProperties) + ":"
          + serverProperties.get(ServerProperty.LDAP_PORT);
    }
    return null;
  }

  /**
   * Returns the LDAPs URL for the given server properties.  It
   * returns NULL if according to the server properties no LDAPS URL
   * can be generated (LDAPS disabled or port not defined).
   * @param serverProperties the server properties to be used to generate
   * the LDAPS URL.
   * @return the LDAPS URL for the given server properties.
   */
  private String getLdapsUrl(Map<ServerProperty,Object> serverProperties)
  {
    if (isLdapsEnabled(serverProperties))
    {
      return "ldaps://" + getHostNameForLdapUrl(serverProperties) + ":"
          + serverProperties.get(ServerProperty.LDAPS_PORT);
    }
    return null;
  }

  /**
   * Returns the administration connector URL for the given server properties.
   * It returns NULL if according to the server properties no administration
   * connector URL can be generated.
   * @param serverProperties the server properties to be used to generate
   * the administration connector URL.
   * @return the administration connector URL for the given server properties.
   */
  private String getAdminConnectorUrl(
    Map<ServerProperty,Object> serverProperties)
  {
    if (isPropertyEnabled(serverProperties, ServerProperty.ADMIN_ENABLED))
    {
      Object adminPort = serverProperties.get(ServerProperty.ADMIN_PORT);
      if (adminPort != null)
      {
        return "ldaps://" + getHostNameForLdapUrl(serverProperties) + ":" + adminPort;
      }
    }
    return null;
  }

  private boolean isLdapEnabled(Map<ServerProperty, Object> serverProperties)
  {
    return isPropertyEnabled(serverProperties, ServerProperty.LDAP_ENABLED);
  }

  private boolean isLdapsEnabled(Map<ServerProperty, Object> serverProperties)
  {
    return isPropertyEnabled(serverProperties, ServerProperty.LDAPS_ENABLED);
  }

  private boolean isStartTlsEnabled(Map<ServerProperty, Object> serverProperties)
  {
    return isLdapEnabled(serverProperties) && isPropertyEnabled(serverProperties, ServerProperty.STARTTLS_ENABLED);
  }

  private boolean isPropertyEnabled(Map<ServerProperty, Object> serverProperties, ServerProperty property)
  {
    Object v = serverProperties.get(property);
    return v != null && "true".equalsIgnoreCase(v.toString());
  }

  /**
   * Returns the host name to be used to generate an LDAP URL based on the
   * contents of the provided server properties.
   * @param serverProperties the server properties.
   * @return the host name to be used to generate an LDAP URL based on the
   * contents of the provided server properties.
   */
  private String getHostNameForLdapUrl(
      Map<ServerProperty,Object> serverProperties)
  {
    String host = (String)serverProperties.get(ServerProperty.HOST_NAME);
    return Utils.getHostNameForLdapUrl(host);
  }

  /**
   * Returns whether the DN provided in the constructor is a Global
   * Administrator DN or not.
   * @return <CODE>true</CODE> if the DN provided in the constructor is a Global
   * Administrator DN and <CODE>false</CODE> otherwise.
   */
  private boolean isAdministratorDn()
  {
    try
    {
      return dn.isSubordinateOrEqualTo(ADSContext.getAdministratorContainerDN());
    }
    catch (Throwable t)
    {
      logger.warn(LocalizableMessage.raw("Error parsing authentication DNs.", t));
      return false;
    }
  }

  /**
   * Returns the list of LDAP URLs that can be used to connect to the server.
   * They are ordered so that the first URL is the preferred URL to be used.
   * @return the list of LDAP URLs that can be used to connect to the server.
   * They are ordered so that the first URL is the preferred URL to be used.
   * @throws LdapException if a problem occurs decoding the ldapURLs
   */
  private LinkedHashSet<PreferredConnection> getLDAPURLsByPreference() throws LdapException
  {
    LinkedHashSet<PreferredConnection> ldapUrls = new LinkedHashSet<>();

    String adminConnectorUrl = getAdminConnectorUrl(serverProperties);
    String ldapsUrl = getLdapsUrl(serverProperties);
    String startTLSUrl = getStartTlsLdapUrl(serverProperties);
    String ldapUrl = getLdapUrl(serverProperties);

    // Check the preferred connections passed in the constructor.
    for (PreferredConnection connection : preferredLDAPURLs)
    {
      String url = connection.getLDAPURL();
      org.opends.admin.ads.util.PreferredConnection.Type type = connection.getType();
      if (url.equalsIgnoreCase(adminConnectorUrl)
          || (url.equalsIgnoreCase(ldapsUrl) && type == LDAPS)
          || (url.equalsIgnoreCase(startTLSUrl) && type == START_TLS)
          || (url.equalsIgnoreCase(ldapUrl) && type == LDAP))
      {
        ldapUrls.add(connection);
      }
    }

    if (adminConnectorUrl != null)
    {
      ldapUrls.add(newPreferredConnection(adminConnectorUrl, LDAPS));
    }
    if (ldapsUrl != null)
    {
      ldapUrls.add(newPreferredConnection(ldapsUrl, LDAPS));
    }
    if (startTLSUrl != null)
    {
      ldapUrls.add(newPreferredConnection(startTLSUrl, START_TLS));
    }
    if (ldapUrl != null)
    {
      ldapUrls.add(newPreferredConnection(ldapUrl, LDAP));
    }
    return ldapUrls;
  }

  private PreferredConnection newPreferredConnection(String ldapUrl, PreferredConnection.Type type) throws LdapException
  {
    return new PreferredConnection(toHostPort(ldapUrl), type);
  }

  /**
   * Converts an ldapUrl to a HostPort.
   *
   * @param ldapUrl
   *          the ldapUrl to convert
   * @return the host and port extracted from the ldapUrl
   * @throws LdapException
   *           if the ldapUrl is not a valid URL
   */
  public static HostPort toHostPort(String ldapUrl) throws LdapException
  {
    try
    {
      URI uri = new URI(ldapUrl);
      return new HostPort(uri.getHost(), uri.getPort());
    }
    catch (URISyntaxException e)
    {
      throw newLdapException(CLIENT_SIDE_PARAM_ERROR, e.getLocalizedMessage() + ". LDAP URL was: \"" + ldapUrl + "\"");
    }
  }
}
