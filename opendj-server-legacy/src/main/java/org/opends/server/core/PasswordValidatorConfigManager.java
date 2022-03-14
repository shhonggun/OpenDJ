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
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.server.core;

import static org.opends.messages.ConfigMessages.*;
import static org.opends.server.util.StaticUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.util.Utils;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.server.config.meta.PasswordValidatorCfgDefn;
import org.forgerock.opendj.server.config.server.PasswordValidatorCfg;
import org.forgerock.opendj.server.config.server.RootCfg;
import org.opends.server.api.PasswordValidator;
import org.forgerock.opendj.config.server.ConfigChangeResult;
import org.forgerock.opendj.ldap.DN;
import org.opends.server.types.InitializationException;

/**
 * This class defines a utility that will be used to manage the set of
 * password validators defined in the Directory Server.  It will initialize the
 * validators when the server starts, and then will manage any additions,
 * removals, or modifications to any password validators while the server is
 * running.
 */
public class PasswordValidatorConfigManager
       implements ConfigurationChangeListener<PasswordValidatorCfg>,
                  ConfigurationAddListener<PasswordValidatorCfg>,
                  ConfigurationDeleteListener<PasswordValidatorCfg>
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /** A mapping between the DNs of the config entries and the associated password validators. */
  private final ConcurrentHashMap<DN,PasswordValidator> passwordValidators;

  private final ServerContext serverContext;

  /**
   * Creates a new instance of this password validator config manager.
   *
   * @param serverContext
   *            The server context.
   */
  public PasswordValidatorConfigManager(ServerContext serverContext)
  {
    this.serverContext = serverContext;
    passwordValidators = new ConcurrentHashMap<>();
  }

  /**
   * Initializes all password validators currently defined in the Directory
   * Server configuration.  This should only be called at Directory Server
   * startup.
   *
   * @throws  ConfigException  If a configuration problem causes the password
   *                           validator initialization process to fail.
   *
   * @throws  InitializationException  If a problem occurs while initializing
   *                                   the password validators that is not
   *                                   related to the server configuration.
   */
  public void initializePasswordValidators()
         throws ConfigException, InitializationException
  {
    RootCfg rootConfiguration = serverContext.getRootConfig();
    rootConfiguration.addPasswordValidatorAddListener(this);
    rootConfiguration.addPasswordValidatorDeleteListener(this);

    //Initialize the existing password validators.
    for (String validatorName : rootConfiguration.listPasswordValidators())
    {
      PasswordValidatorCfg validatorConfiguration =
           rootConfiguration.getPasswordValidator(validatorName);
      validatorConfiguration.addChangeListener(this);

      if (validatorConfiguration.isEnabled())
      {
        String className = validatorConfiguration.getJavaClass();
        try
        {
          PasswordValidator<? extends PasswordValidatorCfg>
               validator = loadValidator(className, validatorConfiguration,
                                         true);
          passwordValidators.put(validatorConfiguration.dn(), validator);
          DirectoryServer.registerPasswordValidator(validatorConfiguration.dn(),
                                                    validator);
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
                      PasswordValidatorCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    if (configuration.isEnabled())
    {
      // Get the name of the class and make sure we can instantiate it as a
      // password validator.
      String className = configuration.getJavaClass();
      try
      {
        loadValidator(className, configuration, false);
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
                                 PasswordValidatorCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    configuration.addChangeListener(this);

    if (! configuration.isEnabled())
    {
      return ccr;
    }

    PasswordValidator<? extends PasswordValidatorCfg>
         passwordValidator = null;

    // Get the name of the class and make sure we can instantiate it as a
    // password validator.
    String className = configuration.getJavaClass();
    try
    {
      passwordValidator = loadValidator(className, configuration, true);
    }
    catch (InitializationException ie)
    {
      ccr.setResultCodeIfSuccess(DirectoryServer.getCoreConfigManager().getServerErrorResultCode());
      ccr.addMessage(ie.getMessageObject());
    }

    if (ccr.getResultCode() == ResultCode.SUCCESS)
    {
      passwordValidators.put(configuration.dn(), passwordValidator);
      DirectoryServer.registerPasswordValidator(configuration.dn(), passwordValidator);
    }

    return ccr;
  }

  @Override
  public boolean isConfigurationDeleteAcceptable(
                      PasswordValidatorCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    // FIXME -- We should try to perform some check to determine whether the
    // password validator is in use.
    return true;
  }

  @Override
  public ConfigChangeResult applyConfigurationDelete(
                                 PasswordValidatorCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    DirectoryServer.deregisterPasswordValidator(configuration.dn());

    PasswordValidator passwordValidator =
         passwordValidators.remove(configuration.dn());
    if (passwordValidator != null)
    {
      passwordValidator.finalizePasswordValidator();
    }

    return ccr;
  }

  @Override
  public boolean isConfigurationChangeAcceptable(
                      PasswordValidatorCfg configuration,
                      List<LocalizableMessage> unacceptableReasons)
  {
    if (configuration.isEnabled())
    {
      // Get the name of the class and make sure we can instantiate it as a
      // password validator.
      String className = configuration.getJavaClass();
      try
      {
        loadValidator(className, configuration, false);
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
                                 PasswordValidatorCfg configuration)
  {
    final ConfigChangeResult ccr = new ConfigChangeResult();

    // Get the existing validator if it's already enabled.
    PasswordValidator existingValidator =
         passwordValidators.get(configuration.dn());

    // If the new configuration has the validator disabled, then disable it if
    // it is enabled, or do nothing if it's already disabled.
    if (! configuration.isEnabled())
    {
      if (existingValidator != null)
      {
        DirectoryServer.deregisterPasswordValidator(configuration.dn());

        PasswordValidator passwordValidator =
             passwordValidators.remove(configuration.dn());
        if (passwordValidator != null)
        {
          passwordValidator.finalizePasswordValidator();
        }
      }

      return ccr;
    }

    // Get the class for the password validator.  If the validator is already
    // enabled, then we shouldn't do anything with it although if the class has
    // changed then we'll at least need to indicate that administrative action
    // is required.  If the validator is disabled, then instantiate the class
    // and initialize and register it as a password validator.
    String className = configuration.getJavaClass();
    if (existingValidator != null)
    {
      if (! className.equals(existingValidator.getClass().getName()))
      {
        ccr.setAdminActionRequired(true);
      }

      return ccr;
    }

    PasswordValidator<? extends PasswordValidatorCfg>
         passwordValidator = null;
    try
    {
      passwordValidator = loadValidator(className, configuration, true);
    }
    catch (InitializationException ie)
    {
      ccr.setResultCodeIfSuccess(DirectoryServer.getCoreConfigManager().getServerErrorResultCode());
      ccr.addMessage(ie.getMessageObject());
    }

    if (ccr.getResultCode() == ResultCode.SUCCESS)
    {
      passwordValidators.put(configuration.dn(), passwordValidator);
      DirectoryServer.registerPasswordValidator(configuration.dn(), passwordValidator);
    }

    return ccr;
  }

  /**
   * Loads the specified class, instantiates it as a password validator, and
   * optionally initializes that instance.
   *
   * @param  className      The fully-qualified name of the password validator
   *                        class to load, instantiate, and initialize.
   * @param  configuration  The configuration to use to initialize the
   *                        password validator.  It must not be {@code null}.
   * @param  initialize     Indicates whether the password validator instance
   *                        should be initialized.
   *
   * @return  The possibly initialized password validator.
   *
   * @throws  InitializationException  If a problem occurred while attempting to
   *                                   initialize the password validator.
   */
  private <T extends PasswordValidatorCfg> PasswordValidator<T>
               loadValidator(String className,
                             T configuration,
                             boolean initialize)
          throws InitializationException
  {
    try
    {
      PasswordValidatorCfgDefn definition =
           PasswordValidatorCfgDefn.getInstance();
      ClassPropertyDefinition propertyDefinition =
           definition.getJavaClassPropertyDefinition();
      Class<? extends PasswordValidator> validatorClass =
           propertyDefinition.loadClass(className, PasswordValidator.class);
      PasswordValidator<T> validator = validatorClass.newInstance();

      if (initialize)
      {
        validator.initializePasswordValidator(configuration);
      }
      else
      {
        List<LocalizableMessage> unacceptableReasons = new ArrayList<>();
        if (!validator.isConfigurationAcceptable(configuration, unacceptableReasons))
        {
          String reasons = Utils.joinAsString(".  ", unacceptableReasons);
          throw new InitializationException(
              ERR_CONFIG_PWVALIDATOR_CONFIG_NOT_ACCEPTABLE.get(configuration.dn(), reasons));
        }
      }

      return validator;
    }
    catch (Exception e)
    {
      LocalizableMessage message = ERR_CONFIG_PWVALIDATOR_INITIALIZATION_FAILED.
          get(className, configuration.dn(), stackTraceToSingleLineString(e));
      throw new InitializationException(message, e);
    }
  }
}
