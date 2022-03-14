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
 * Copyright 2006-2010 Sun Microsystems, Inc.
 * Portions Copyright 2013-2016 ForgeRock AS.
 */
package org.opends.server.core;

import static org.opends.messages.ConfigMessages.*;
import static org.opends.server.util.StaticUtils.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.server.config.meta.MonitorProviderCfgDefn;
import org.forgerock.opendj.server.config.server.MonitorProviderCfg;
import org.forgerock.opendj.server.config.server.RootCfg;
import org.opends.server.api.MonitorProvider;
import org.forgerock.opendj.config.server.ConfigChangeResult;
import org.forgerock.opendj.ldap.DN;
import org.opends.server.types.InitializationException;

/**
 * This class defines a utility that will be used to manage the set of monitor
 * providers defined in the Directory Server.  It will initialize the monitor
 * providers when the server starts, and then will manage any additions,
 * removals, or modifications to any providers while the server is running.
 */
public class MonitorConfigManager
       implements ConfigurationChangeListener<MonitorProviderCfg>,
                  ConfigurationAddListener<MonitorProviderCfg>,
                  ConfigurationDeleteListener<MonitorProviderCfg>
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /** A mapping between the DNs of the config entries and the associated monitor providers. */
  private final ConcurrentHashMap<DN,MonitorProvider<?>> monitors;

  private final ServerContext serverContext;

  /**
   * Creates a new instance of this monitor provider config manager.
   *
   * @param serverContext
   *            The server context.
   */
  public MonitorConfigManager(ServerContext serverContext)
  {
    this.serverContext = serverContext;
    monitors = new ConcurrentHashMap<>();
  }

  /**
   * Initializes all monitor providers currently defined in the Directory Server
   * configuration.  This should only be called at Directory Server startup.
   *
   * @throws  ConfigException  If a configuration problem causes the monitor
   *                           provider initialization process to fail.
   *
   * @throws  InitializationException  If a problem occurs while initializing
   *                                   the monitor providers that is not related
   *                                   to the server configuration.
   */
  public void initializeMonitorProviders()
         throws ConfigException, InitializationException
  {
    RootCfg rootConfiguration = serverContext.getRootConfig();
    rootConfiguration.addMonitorProviderAddListener(this);
    rootConfiguration.addMonitorProviderDeleteListener(this);

    //Initialize the existing monitor providers.
    for (String name : rootConfiguration.listMonitorProviders())
    {
      MonitorProviderCfg monitorConfig =
           rootConfiguration.getMonitorProvider(name);
      monitorConfig.addChangeListener(this);

      if (monitorConfig.isEnabled())
      {
        String className = monitorConfig.getJavaClass();
        try
        {
          MonitorProvider<? extends MonitorProviderCfg> monitor =
               loadMonitor(className, monitorConfig);
          monitors.put(monitorConfig.dn(), monitor);
          DirectoryServer.registerMonitorProvider(monitor);
        }
        catch (InitializationException ie)
        {
          logger.error(ie.getMessageObject());
          continue;
        }
      }
    }
  }

  @Override
  public boolean isConfigurationAddAcceptable(
                      MonitorProviderCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    if (configuration.isEnabled())
    {
      // Get the name of the class and make sure we can instantiate it as a
      // monitor provider.
      String className = configuration.getJavaClass();
      try
      {
        loadMonitor(className, null);
      }
      catch (InitializationException ie)
      {
        unacceptableReasons.add(ie.getMessageObject());
        return false;
      }
    }

    // If we've gotten here, then it's fine.
    return true;
  }

  @Override
  public ConfigChangeResult applyConfigurationAdd(
                                 MonitorProviderCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    configuration.addChangeListener(this);

    if (! configuration.isEnabled())
    {
      return ccr;
    }

    MonitorProvider<? extends MonitorProviderCfg> monitor = null;

    // Get the name of the class and make sure we can instantiate it as a
    // monitor provider.
    String className = configuration.getJavaClass();
    try
    {
      monitor = loadMonitor(className, configuration);
    }
    catch (InitializationException ie)
    {
      ccr.setResultCodeIfSuccess(DirectoryServer.getCoreConfigManager().getServerErrorResultCode());
      ccr.addMessage(ie.getMessageObject());
    }

    if (ccr.getResultCode() == ResultCode.SUCCESS)
    {
      monitors.put(configuration.dn(), monitor);
      DirectoryServer.registerMonitorProvider(monitor);
    }

    return ccr;
  }

  @Override
  public boolean isConfigurationDeleteAcceptable(
                      MonitorProviderCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    // It will always be acceptable to delete or disable a monitor provider.
    return true;
  }

  @Override
  public ConfigChangeResult applyConfigurationDelete(
                                 MonitorProviderCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    MonitorProvider<?> monitor = monitors.remove(configuration.dn());
    if (monitor != null)
    {
      DirectoryServer.deregisterMonitorProvider(monitor);
      monitor.finalizeMonitorProvider();
    }

    return ccr;
  }

  @Override
  public boolean isConfigurationChangeAcceptable(
                      MonitorProviderCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    if (configuration.isEnabled())
    {
      // Get the name of the class and make sure we can instantiate it as a
      // monitor provider.
      String className = configuration.getJavaClass();
      try
      {
        loadMonitor(className, null);
      }
      catch (InitializationException ie)
      {
        unacceptableReasons.add(ie.getMessageObject());
        return false;
      }
    }

    // If we've gotten here, then it's fine.
    return true;
  }

  @Override
  public ConfigChangeResult applyConfigurationChange(
                                 MonitorProviderCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    // Get the existing monitor provider if it's already enabled.
    MonitorProvider<?> existingMonitor = monitors.get(configuration.dn());

    // If the new configuration has the monitor disabled, then disable it if it
    // is enabled, or do nothing if it's already disabled.
    if (! configuration.isEnabled())
    {
      if (existingMonitor != null)
      {
        DirectoryServer.deregisterMonitorProvider(existingMonitor);
        MonitorProvider<?> monitor = monitors.remove(configuration.dn());
        if (monitor != null)
        {
          monitor.finalizeMonitorProvider();
        }
      }

      return ccr;
    }

    // Get the class for the monitor provider.  If the monitor is already
    // enabled, then we shouldn't do anything with it although if the class has
    // changed then we'll at least need to indicate that administrative action
    // is required.  If the monitor is disabled, then instantiate the class and
    // initialize and register it as a monitor provider.
    String className = configuration.getJavaClass();
    if (existingMonitor != null)
    {
      if (! className.equals(existingMonitor.getClass().getName()))
      {
        ccr.setAdminActionRequired(true);
      }

      return ccr;
    }

    MonitorProvider<? extends MonitorProviderCfg> monitor = null;
    try
    {
      monitor = loadMonitor(className, configuration);
    }
    catch (InitializationException ie)
    {
      ccr.setResultCodeIfSuccess(DirectoryServer.getCoreConfigManager().getServerErrorResultCode());
      ccr.addMessage(ie.getMessageObject());
    }

    if (ccr.getResultCode() == ResultCode.SUCCESS)
    {
      monitors.put(configuration.dn(), monitor);
      DirectoryServer.registerMonitorProvider(monitor);
    }

    return ccr;
  }

  /**
   * Loads the specified class, instantiates it as a monitor provider, and
   * optionally initializes that instance.
   *
   * @param  className      The fully-qualified name of the monitor provider
   *                        class to load, instantiate, and initialize.
   * @param  configuration  The configuration to use to initialize the monitor
   *                        provider, or {@code null} if the monitor provider
   *                        should not be initialized.
   *
   * @return  The possibly initialized monitor provider.
   *
   * @throws  InitializationException  If a problem occurred while attempting to
   *                                   initialize the monitor provider.
   */
  private <T extends MonitorProviderCfg> MonitorProvider<T>
               loadMonitor(String className, T configuration)
          throws InitializationException
  {
    try
    {
      MonitorProviderCfgDefn definition = MonitorProviderCfgDefn.getInstance();
      ClassPropertyDefinition propertyDefinition =
           definition.getJavaClassPropertyDefinition();
      @SuppressWarnings("unchecked")
      Class<? extends MonitorProvider<T>> providerClass =
          (Class<? extends MonitorProvider<T>>) propertyDefinition
              .loadClass(className, MonitorProvider.class);
      MonitorProvider<T> monitor = providerClass.newInstance();

      if (configuration != null)
      {
        monitor.initializeMonitorProvider(configuration);
      }

      return monitor;
    }
    catch (Exception e)
    {
      LocalizableMessage message = ERR_CONFIG_MONITOR_INITIALIZATION_FAILED.
          get(className, configuration.dn(), stackTraceToSingleLineString(e));
      throw new InitializationException(message, e);
    }
  }
}
