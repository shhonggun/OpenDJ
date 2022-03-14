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
 * Copyright 2007-2010 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.server.tools.status;

import static com.forgerock.opendj.cli.ArgumentConstants.*;
import static com.forgerock.opendj.cli.Utils.*;
import static java.util.concurrent.TimeUnit.*;

import static org.forgerock.opendj.ldap.LDAPConnectionFactory.*;
import static org.forgerock.util.Utils.*;
import static org.forgerock.util.time.Duration.*;
import static org.opends.messages.AdminToolMessages.*;
import static org.opends.messages.QuickSetupMessages.*;
import static org.opends.messages.QuickSetupMessages.INFO_NOT_AVAILABLE_LABEL;
import static org.opends.messages.ToolMessages.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.AdminException;
import org.forgerock.opendj.config.LDAPProfile;
import org.forgerock.opendj.config.client.ManagementContext;
import org.forgerock.opendj.config.client.ldap.LDAPManagementContext;
import org.forgerock.opendj.ldap.AuthenticationException;
import org.forgerock.opendj.ldap.AuthorizationException;
import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SSLContextBuilder;
import org.forgerock.opendj.ldap.TrustManagers;
import org.forgerock.util.Options;
import org.opends.admin.ads.util.ApplicationTrustManager;
import org.opends.admin.ads.util.ConnectionWrapper;
import org.opends.guitools.controlpanel.datamodel.BackendDescriptor;
import org.opends.guitools.controlpanel.datamodel.BaseDNDescriptor;
import org.opends.guitools.controlpanel.datamodel.BaseDNTableModel;
import org.opends.guitools.controlpanel.datamodel.ConfigReadException;
import org.opends.guitools.controlpanel.datamodel.ConnectionHandlerDescriptor;
import org.opends.guitools.controlpanel.datamodel.ConnectionHandlerTableModel;
import org.opends.guitools.controlpanel.datamodel.ConnectionProtocolPolicy;
import org.opends.guitools.controlpanel.datamodel.ControlPanelInfo;
import org.opends.guitools.controlpanel.datamodel.ServerDescriptor;
import org.opends.guitools.controlpanel.util.ControlPanelLog;
import org.opends.guitools.controlpanel.util.Utilities;
import org.opends.server.admin.client.cli.SecureConnectionCliArgs;
import org.opends.server.loggers.JDKLogging;
import org.opends.server.types.InitializationException;
import org.opends.server.types.NullOutputStream;
import org.opends.server.util.BuildVersion;
import org.opends.server.util.StaticUtils;
import org.opends.server.util.cli.LDAPConnectionConsoleInteraction;

import com.forgerock.opendj.cli.ArgumentException;
import com.forgerock.opendj.cli.ClientException;
import com.forgerock.opendj.cli.ConnectionFactoryProvider;
import com.forgerock.opendj.cli.ConsoleApplication;
import com.forgerock.opendj.cli.IntegerArgument;
import com.forgerock.opendj.cli.ReturnCode;
import com.forgerock.opendj.cli.StringArgument;
import com.forgerock.opendj.cli.TableBuilder;
import com.forgerock.opendj.cli.TextTablePrinter;

/**
 * The class used to provide some CLI interface to display status.
 * This class basically is in charge of parsing the data provided by the
 * user in the command line.
 */
public class StatusCli extends ConsoleApplication
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  private static final boolean ALLOW_ANONYMOUS_IF_NON_INTERACTIVE = true;

  private boolean displayMustAuthenticateLegend;
  private boolean displayMustStartLegend;

  /** Prefix for log files. */
  private static final String LOG_FILE_PREFIX = "opendj-status-";
  /** Suffix for log files. */
  private static final String LOG_FILE_SUFFIX = ".log";

  private ApplicationTrustManager interactiveTrustManager;
  private boolean useInteractiveTrustManager;

  /** The argument parser. */
  private StatusCliArgumentParser argParser;

  /**
   * Constructor for the status cli object.
   *
   * @param out
   *          The print stream to use for standard output.
   * @param err
   *          The print stream to use for standard error.
   */
  private StatusCli(PrintStream out, PrintStream err)
  {
    super(out, err);
  }

  /**
   * The main method for the status CLI tool.
   *
   * @param args The command-line arguments provided to this program.
   */
  public static void main(String[] args)
  {
    int retCode = mainCLI(args, System.out, System.err);
    if(retCode != 0)
    {
      System.exit(retCode);
    }
  }

  /**
   * Parses the provided command-line arguments and uses that information to run
   * the status tool.
   *
   * @param args
   *          The command-line arguments provided to this program.
   * @param outStream
   *          The output stream to use for standard output, or {@code null}
   *          if standard output is not needed.
   * @param errStream
   *          The output stream to use for standard error, or {@code null}
   *          if standard error is not needed.
   * @return The return code.
   */
  public static int mainCLI(String[] args, OutputStream outStream, OutputStream errStream)
  {
    PrintStream out = NullOutputStream.wrapOrNullStream(outStream);
    PrintStream err = NullOutputStream.wrapOrNullStream(errStream);
    JDKLogging.disableLogging();

    try {
      ControlPanelLog.initLogFileHandler(
              File.createTempFile(LOG_FILE_PREFIX, LOG_FILE_SUFFIX));
      ControlPanelLog.initPackage("org.opends.server.tools.status");
    } catch (Throwable t) {
      System.err.println("Unable to initialize log");
      t.printStackTrace();
    }

    final StatusCli statusCli = new StatusCli(out, err);
    int retCode = statusCli.execute(args);
    if (retCode == 0)
    {
      ControlPanelLog.closeAndDeleteLogFile();
    }
    return retCode;
  }

  /**
   * Parses the provided command-line arguments and uses that information to run
   * the status CLI.
   *
   * @param args
   *          The command-line arguments provided to this program.
   * @return The return code of the process.
   */
  private int execute(String[] args) {
    argParser = new StatusCliArgumentParser(StatusCli.class.getName());
    try {
      argParser.initializeGlobalArguments(getOutputStream());
    } catch (ArgumentException ae) {
      println(ERR_CANNOT_INITIALIZE_ARGS.get(ae.getMessage()));
      return ReturnCode.CLIENT_SIDE_PARAM_ERROR.get();
    }

    argParser.getSecureArgsList().initArgumentsWithConfiguration(argParser);

    // Validate user provided data
    try {
      argParser.parseArguments(args);
    } catch (ArgumentException ae) {
      argParser.displayMessageAndUsageReference(getErrStream(), ERR_ERROR_PARSING_ARGS.get(ae.getMessage()));
      return ReturnCode.CLIENT_SIDE_PARAM_ERROR.get();
    }

    //  If we should just display usage or version information,
    // then print it and exit.
    if (argParser.usageOrVersionDisplayed()) {
      return ReturnCode.SUCCESS.get();
    }

    // Checks the version - if upgrade required, the tool is unusable
    try
    {
      BuildVersion.checkVersionMismatch();
    }
    catch (InitializationException e)
    {
      println(e.getMessageObject());
      return 1;
    }

    int v = argParser.validateGlobalOptions(getErrorStream());
    if (v != ReturnCode.SUCCESS.get()) {
      println(LocalizableMessage.raw(argParser.getUsage()));
      return v;
    }

    final ControlPanelInfo controlInfo = ControlPanelInfo.getInstance();
    controlInfo.setTrustManager(getTrustManager());
    controlInfo.setConnectTimeout(argParser.getConnectTimeout());
    controlInfo.regenerateDescriptor();

    if (controlInfo.getServerDescriptor().getStatus() == ServerDescriptor.ServerStatus.STARTED)
    {
      DN bindDn = null;
      String bindPwd = null;

      // This is done because we do not need to ask the user about these
      // parameters. We force their presence in the
      // LDAPConnectionConsoleInteraction, this done, it will not prompt
      // the user for them.
      controlInfo.setConnectionPolicy(ConnectionProtocolPolicy.USE_ADMIN);
      int port = controlInfo.getAdminConnectorHostPort().getPort();
      final SecureConnectionCliArgs secureArgsList = argParser.getSecureArgsList();
      final StringArgument hostNameArg = secureArgsList.getHostNameArg();
      hostNameArg.setPresent(true);
      hostNameArg.addValue(hostNameArg.getDefaultValue());
      final IntegerArgument portArg = secureArgsList.getPortArg();
      portArg.setPresent(true);
      portArg.addValue(Integer.toString(port));
      // We already know if SSL or StartTLS can be used.  If we cannot
      // use them we will not propose them in the connection parameters
      // and if none of them can be used we will just not ask for the
      // protocol to be used.
      final LDAPConnectionConsoleInteraction ci =
          new LDAPConnectionConsoleInteraction(this, secureArgsList, ALLOW_ANONYMOUS_IF_NON_INTERACTIVE);
      try
      {
        ci.run(false);
      }
      catch (ArgumentException e)
      {
        argParser.displayMessageAndUsageReference(getErrStream(), e.getMessageObject());
        return ReturnCode.CLIENT_SIDE_PARAM_ERROR.get();
      }

      boolean managementContextOpened = false;
      try
      {
        if (argParser.isInteractive())
        {
          bindDn = ci.getBindDN();
          bindPwd = ci.getBindPassword();
        }
        else
        {
          bindDn = DN.valueOf(argParser.getBindDN());
          bindPwd = argParser.getBindPassword();
        }
        if (bindPwd != null && !bindPwd.isEmpty())
        {
          try (ManagementContext mContext = getManagementContextFromConnection(ci))
          {
            managementContextOpened = true;
            interactiveTrustManager = ci.getTrustManager();
            controlInfo.setTrustManager(interactiveTrustManager);
            useInteractiveTrustManager = true;
          }
          catch (IOException e)
          {
            logger.traceException(e);
          }
        }
      } catch (ClientException e) {
        println(e.getMessageObject());
        return ReturnCode.CLIENT_SIDE_PARAM_ERROR.get();
      }

      if (managementContextOpened)
      {
        try (ConnectionWrapper conn = Utilities.getAdminConnection(controlInfo, bindDn, bindPwd))
        {
          controlInfo.setConnection(conn);
          controlInfo.regenerateDescriptor();
          writeStatus(controlInfo);

          if (!controlInfo.getServerDescriptor().getExceptions().isEmpty()) {
            return ReturnCode.ERROR_INITIALIZING_SERVER.get();
          }
        } catch (IOException e) {
          // This should not happen but this is useful information to
          // diagnose the error.
          println();
          println(INFO_ERROR_READING_SERVER_CONFIGURATION.get(e));
          return ReturnCode.ERROR_INITIALIZING_SERVER.get();
        } catch (ConfigReadException e) {
          // This should not happen but this is useful information to
          // diagnose the error.
          println();
          println(e.getMessageObject());
          return ReturnCode.ERROR_INITIALIZING_SERVER.get();
        }
      } else {
        // The user did not provide authentication: just display the
        // information we can get reading the config file.
        writeStatus(controlInfo);
        return ReturnCode.ERROR_USER_CANCELLED.get();
      }
    } else {
      writeStatus(controlInfo);
    }

    return ReturnCode.SUCCESS.get();
  }

  private void writeStatus(ControlPanelInfo controlInfo)
  {
    if (controlInfo.getServerDescriptor() == null)
    {
      controlInfo.regenerateDescriptor();
    }
    writeStatus(controlInfo.getServerDescriptor());
    int period = argParser.getRefreshPeriod();
    boolean first = true;
    while (period > 0)
    {
      long timeToSleep = period * 1000;
      if (!first)
      {
        long t1 = System.currentTimeMillis();
        controlInfo.regenerateDescriptor();
        long t2 = System.currentTimeMillis();

        timeToSleep = timeToSleep - t2 + t1;
      }

      if (timeToSleep > 0)
      {
        StaticUtils.sleep(timeToSleep);
      }
      println();
      println(LocalizableMessage.raw("          ---------------------"));
      println();
      writeStatus(controlInfo.getServerDescriptor());
      first = false;
    }
  }

  private void writeStatus(ServerDescriptor desc)
  {
    LocalizableMessage[] labels =
      {
        INFO_SERVER_STATUS_LABEL.get(),
        INFO_CONNECTIONS_LABEL.get(),
        INFO_HOSTNAME_LABEL.get(),
        INFO_ADMINISTRATIVE_USERS_LABEL.get(),
        INFO_INSTALLATION_PATH_LABEL.get(),
        INFO_OPENDS_VERSION_LABEL.get(),
        INFO_JAVA_VERSION_LABEL.get(),
        INFO_CTRL_PANEL_ADMIN_CONNECTOR_LABEL.get()
      };
    int labelWidth = 0;
    LocalizableMessage title = INFO_SERVER_STATUS_TITLE.get();
    if (!isScriptFriendly())
    {
      for (LocalizableMessage label : labels)
      {
        labelWidth = Math.max(labelWidth, label.length());
      }
      println();
      println(centerTitle(title));
    }
    writeStatusContents(desc, labelWidth);
    writeCurrentConnectionContents(desc, labelWidth);
    if (!isScriptFriendly())
    {
      println();
    }

    title = INFO_SERVER_DETAILS_TITLE.get();
    if (!isScriptFriendly())
    {
      println(centerTitle(title));
    }
    writeHostnameContents(desc, labelWidth);
    writeAdministrativeUserContents(desc, labelWidth);
    writeInstallPathContents(desc, labelWidth);
    boolean sameInstallAndInstance = desc.sameInstallAndInstance();
    if (!sameInstallAndInstance)
    {
      writeInstancePathContents(desc, labelWidth);
    }
    writeVersionContents(desc, labelWidth);
    writeJavaVersionContents(desc, labelWidth);
    writeAdminConnectorContents(desc, labelWidth);
    if (!isScriptFriendly())
    {
      println();
    }

    writeListenerContents(desc);
    if (!isScriptFriendly())
    {
      println();
    }

    writeBaseDNContents(desc);

    writeErrorContents(desc);

    if (!isScriptFriendly())
    {
      if (displayMustStartLegend)
      {
        println();
        println(INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LEGEND.get());
      }
      else if (displayMustAuthenticateLegend)
      {
        println();
        println(INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LEGEND.get());
      }
    }
    println();
  }

  /**
   * Writes the status contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerStatusDescriptor object.
   */
  private void writeStatusContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_SERVER_STATUS_LABEL.get(), getStatus(desc).toString(), maxLabelWidth);
  }

  private LocalizableMessage getStatus(ServerDescriptor desc)
  {
    switch (desc.getStatus())
    {
    case STARTED:
      return INFO_SERVER_STARTED_LABEL.get();
    case STOPPED:
      return INFO_SERVER_STOPPED_LABEL.get();
    case STARTING:
      return INFO_SERVER_STARTING_LABEL.get();
    case STOPPING:
      return INFO_SERVER_STOPPING_LABEL.get();
    case NOT_CONNECTED_TO_REMOTE:
      return INFO_SERVER_NOT_CONNECTED_TO_REMOTE_STATUS_LABEL.get();
    case UNKNOWN:
      return INFO_SERVER_UNKNOWN_STATUS_LABEL.get();
    default:
      throw new IllegalStateException("Unknown status: "+desc.getStatus());
    }
  }

  /**
   * Writes the current connection contents displaying with what is specified in
   * the provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   */
  private void writeCurrentConnectionContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_CONNECTIONS_LABEL.get(), getNbConnection(desc), maxLabelWidth);
  }

  private String getNbConnection(ServerDescriptor desc)
  {
    if (desc.getStatus() == ServerDescriptor.ServerStatus.STARTED)
    {
      final int nConn = desc.getOpenConnections();
      if (nConn >= 0)
      {
        return String.valueOf(nConn);
      }
      else if (!desc.isAuthenticated() || !desc.getExceptions().isEmpty())
      {
        return getNotAvailableBecauseAuthenticationIsRequiredText();
      }
      else
      {
        return getNotAvailableText();
      }
    }
    return getNotAvailableBecauseServerIsDownText();
  }

  /**
   * Writes the host name contents.
   *
   * @param desc
   *          The ServerDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeHostnameContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_HOSTNAME_LABEL.get(), desc.getHostname(), maxLabelWidth);
  }

  /**
   * Writes the administrative user contents displaying with what is specified
   * in the provided ServerStatusDescriptor object.
   *
   * @param desc
   *          The ServerStatusDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeAdministrativeUserContents(ServerDescriptor desc, int maxLabelWidth)
  {
    Set<DN> administrators = desc.getAdministrativeUsers();
    if (!administrators.isEmpty())
    {
      TreeSet<DN> ordered = new TreeSet<>(administrators);
      for (DN dn : ordered)
      {
        writeLabelValue(INFO_ADMINISTRATIVE_USERS_LABEL.get(), dn.toString(), maxLabelWidth);
      }
    }
    else
    {
      writeLabelValue(INFO_ADMINISTRATIVE_USERS_LABEL.get(), getErrorText(desc), maxLabelWidth);
    }
  }

  private String getErrorText(ServerDescriptor desc)
  {
    if (desc.getStatus() == ServerDescriptor.ServerStatus.STARTED
        && (!desc.isAuthenticated() || !desc.getExceptions().isEmpty()))
    {
      return getNotAvailableBecauseAuthenticationIsRequiredText();
    }
    return getNotAvailableText();
  }

  /**
   * Writes the install path contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeInstallPathContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_INSTALLATION_PATH_LABEL.get(), desc.getInstallPath(), maxLabelWidth);
  }

  /**
   * Writes the instance path contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeInstancePathContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_CTRL_PANEL_INSTANCE_PATH_LABEL.get(), desc.getInstancePath(), maxLabelWidth);
  }

  /**
   * Updates the server version contents displaying with what is specified in
   * the provided ServerDescriptor object. This method must be called from the
   * event thread.
   *
   * @param desc
   *          The ServerDescriptor object.
   */
  private void writeVersionContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_OPENDS_VERSION_LABEL.get(), desc.getOpenDSVersion(), maxLabelWidth);
  }

  /**
   * Updates the java version contents displaying with what is specified in the
   * provided ServerDescriptor object. This method must be called from the event
   * thread.
   *
   * @param desc
   *          The ServerDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeJavaVersionContents(ServerDescriptor desc, int maxLabelWidth)
  {
    writeLabelValue(INFO_JAVA_VERSION_LABEL.get(), getJavaVersion(desc), maxLabelWidth);
  }

  private String getJavaVersion(ServerDescriptor desc)
  {
    if (desc.getStatus() == ServerDescriptor.ServerStatus.STARTED)
    {
      if (!desc.isAuthenticated() || !desc.getExceptions().isEmpty())
      {
        return getNotAvailableBecauseAuthenticationIsRequiredText();
      }
      return desc.getJavaVersion();
    }
    return getNotAvailableBecauseServerIsDownText();
  }

  /**
   * Updates the admin connector contents displaying with what is specified in
   * the provided ServerDescriptor object. This method must be called from the
   * event thread.
   *
   * @param desc
   *          The ServerDescriptor object.
   * @param maxLabelWidth
   *          The maximum label width of the left label.
   */
  private void writeAdminConnectorContents(ServerDescriptor desc, int maxLabelWidth)
  {
    ConnectionHandlerDescriptor adminConnector = desc.getAdminConnector();
    LocalizableMessage text = adminConnector != null
        ? INFO_CTRL_PANEL_ADMIN_CONNECTOR_DESCRIPTION.get(adminConnector.getPort())
        : INFO_NOT_AVAILABLE_SHORT_LABEL.get();
    writeLabelValue(INFO_CTRL_PANEL_ADMIN_CONNECTOR_LABEL.get(), text.toString(), maxLabelWidth);
  }

  /**
   * Writes the listeners contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   */
  private void writeListenerContents(ServerDescriptor desc)
  {
    if (!isScriptFriendly())
    {
      LocalizableMessage title = INFO_LISTENERS_TITLE.get();
      println(centerTitle(title));
    }

    Set<ConnectionHandlerDescriptor> allHandlers = desc.getConnectionHandlers();
    if (allHandlers.isEmpty())
    {
      if (desc.getStatus() == ServerDescriptor.ServerStatus.STARTED)
      {
        if (!desc.isAuthenticated())
        {
          println(INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LABEL.get());
        }
        else
        {
          println(INFO_NO_LISTENERS_FOUND.get());
        }
      }
      else
      {
        println(INFO_NO_LISTENERS_FOUND.get());
      }
    }
    else
    {
      ConnectionHandlerTableModel connHandlersTableModel =
        new ConnectionHandlerTableModel(false);
      connHandlersTableModel.setData(allHandlers);
      writeConnectionHandlersTableModel(connHandlersTableModel, desc);
    }
  }

  /**
   * Writes the base DN contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   */
  private void writeBaseDNContents(ServerDescriptor desc)
  {
    LocalizableMessage title = INFO_DATABASES_TITLE.get();
    if (!isScriptFriendly())
    {
      println(centerTitle(title));
    }

    Set<BaseDNDescriptor> replicas = new HashSet<>();
    Set<BackendDescriptor> bs = desc.getBackends();
    for (BackendDescriptor backend: bs)
    {
      if (!backend.isConfigBackend())
      {
        replicas.addAll(backend.getBaseDns());
      }
    }
    if (replicas.isEmpty())
    {
      if (desc.getStatus() == ServerDescriptor.ServerStatus.STARTED)
      {
        if (!desc.isAuthenticated())
        {
          println(INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LABEL.get());
        }
        else
        {
          println(INFO_NO_DBS_FOUND.get());
        }
      }
      else
      {
        println(INFO_NO_DBS_FOUND.get());
      }
    }
    else
    {
      BaseDNTableModel baseDNTableModel = new BaseDNTableModel(true, false);
      baseDNTableModel.setData(replicas, desc.getStatus(), desc.isAuthenticated());

      writeBaseDNTableModel(baseDNTableModel, desc);
    }
  }

  /**
   * Writes the error label contents displaying with what is specified in the
   * provided ServerDescriptor object.
   *
   * @param desc
   *          The ServerDescriptor object.
   */
  private void writeErrorContents(ServerDescriptor desc)
  {
    for (Exception ex : desc.getExceptions())
    {
      LocalizableMessage errorMsg = ex instanceof AdminException ?
          ((AdminException) ex).getMessageObject() : LocalizableMessage.raw(ex.getMessage());
      if (errorMsg != null)
      {
        println();
        println(errorMsg);
      }
    }
  }

  /**
   * Returns the not available text explaining that the data is not available
   * because the server is down.
   *
   * @return the text.
   */
  private String getNotAvailableBecauseServerIsDownText()
  {
    displayMustStartLegend = true;
    return INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LABEL.get().toString();
  }

  /**
   * Returns the not available text explaining that the data is not available
   * because authentication is required.
   *
   * @return the text.
   */
  private String getNotAvailableBecauseAuthenticationIsRequiredText()
  {
    displayMustAuthenticateLegend = true;
    return INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LABEL.get().toString();
  }

  /**
   * Returns the not available text explaining that the data is not available.
   *
   * @return the text.
   */
  private String getNotAvailableText()
  {
    return INFO_NOT_AVAILABLE_LABEL.get().toString();
  }

  /**
   * Writes the contents of the provided table model simulating a table layout
   * using text.
   *
   * @param tableModel
   *          The connection handler table model.
   * @param desc
   *          The Server Status descriptor.
   */
  private void writeConnectionHandlersTableModel(
      ConnectionHandlerTableModel tableModel,
      ServerDescriptor desc)
  {
    if (isScriptFriendly())
    {
      for (int i=0; i<tableModel.getRowCount(); i++)
      {
        // Get the host name, it can be multivalued.
        String[] hostNames = getHostNames(tableModel, i);
        for (String hostName : hostNames)
        {
          println(LocalizableMessage.raw("-"));
          for (int j=0; j<tableModel.getColumnCount(); j++)
          {
            LocalizableMessageBuilder line = new LocalizableMessageBuilder();
            line.append(tableModel.getColumnName(j)).append(": ");
            if (j == 0)
            {
              // It is the hostName
              line.append(getCellValue(hostName, desc));
            }
            else
            {
              line.append(getCellValue(tableModel.getValueAt(i, j), desc));
            }
            println(line.toMessage());
          }
        }
      }
    }
    else
    {
      TableBuilder table = new TableBuilder();
      for (int i=0; i< tableModel.getColumnCount(); i++)
      {
        table.appendHeading(LocalizableMessage.raw(tableModel.getColumnName(i)));
      }
      for (int i=0; i<tableModel.getRowCount(); i++)
      {
        // Get the host name, it can be multivalued.
        String[] hostNames = getHostNames(tableModel, i);
        for (String hostName : hostNames)
        {
          table.startRow();
          for (int j=0; j<tableModel.getColumnCount(); j++)
          {
            if (j == 0)
            {
              // It is the hostName
              table.appendCell(getCellValue(hostName, desc));
            }
            else
            {
              table.appendCell(getCellValue(tableModel.getValueAt(i, j), desc));
            }
          }
        }
      }
      TextTablePrinter printer = new TextTablePrinter(getOutputStream());
      printer.setColumnSeparator(LIST_TABLE_SEPARATOR);
      table.print(printer);
    }
  }

  private String[] getHostNames(ConnectionHandlerTableModel tableModel, int row)
  {
   String v = (String)tableModel.getValueAt(row, 0);
   String htmlTag = "<html>";
   if (v.toLowerCase().startsWith(htmlTag))
   {
     v = v.substring(htmlTag.length());
   }
   return v.split("<br>");
  }

  private String getCellValue(Object v, ServerDescriptor desc)
  {
    if (v != null)
    {
      if (v instanceof String)
      {
        return (String) v;
      }
      else if (v instanceof Integer)
      {
        int nEntries = ((Integer)v).intValue();
        if (nEntries >= 0)
        {
          return String.valueOf(nEntries);
        }
        else if (!desc.isAuthenticated() || !desc.getExceptions().isEmpty())
        {
          return getNotAvailableBecauseAuthenticationIsRequiredText();
        }
        else
        {
          return getNotAvailableText();
        }
      }
      else
      {
        throw new IllegalStateException("Unknown object type: "+v);
      }
    }
    return getNotAvailableText();
  }

  /**
   * Writes the contents of the provided base DN table model. Every base DN is
   * written in a block containing pairs of labels and values.
   *
   * @param tableModel
   *          The TableModel.
   * @param desc
   *          The Server Status descriptor.
   */
  private void writeBaseDNTableModel(BaseDNTableModel tableModel, ServerDescriptor desc)
  {
    boolean isRunning = desc.getStatus() == ServerDescriptor.ServerStatus.STARTED;

    int labelWidth = 0;
    int labelWidthWithoutReplicated = 0;
    LocalizableMessage[] labels = new LocalizableMessage[tableModel.getColumnCount()];
    for (int i=0; i<tableModel.getColumnCount(); i++)
    {
      LocalizableMessage header = LocalizableMessage.raw(tableModel.getColumnName(i));
      labels[i] = new LocalizableMessageBuilder(header).append(":").toMessage();
      labelWidth = Math.max(labelWidth, labels[i].length());
      if (i != 4 && i != 5)
      {
        labelWidthWithoutReplicated =
          Math.max(labelWidthWithoutReplicated, labels[i].length());
      }
    }

    LocalizableMessage replicatedLabel = INFO_BASEDN_REPLICATED_LABEL.get();
    for (int i=0; i<tableModel.getRowCount(); i++)
    {
      if (isScriptFriendly())
      {
        println(LocalizableMessage.raw("-"));
      }
      else if (i > 0)
      {
        println();
      }
      for (int j=0; j<tableModel.getColumnCount(); j++)
      {
        Object v = tableModel.getValueAt(i, j);
        String value = getValue(desc, isRunning, v);

        boolean doWrite = true;
        boolean isReplicated =
          replicatedLabel.toString().equals(
              String.valueOf(tableModel.getValueAt(i, 3)));
        if (j == 4 || j == 5)
        {
          // If the suffix is not replicated we do not have to display these lines
          doWrite = isReplicated;
        }
        if (doWrite)
        {
          writeLabelValue(labels[j], value,
              isReplicated?labelWidth:labelWidthWithoutReplicated);
        }
      }
    }
  }

  private String getValue(ServerDescriptor desc, boolean isRunning, Object v)
  {
    if (v != null)
    {
      if (v == BaseDNTableModel.NOT_AVAILABLE_SERVER_DOWN)
      {
        return getNotAvailableBecauseServerIsDownText();
      }
      else if (v == BaseDNTableModel.NOT_AVAILABLE_AUTHENTICATION_REQUIRED)
      {
        return getNotAvailableBecauseAuthenticationIsRequiredText();
      }
      else if (v == BaseDNTableModel.NOT_AVAILABLE)
      {
        return getNotAvailableText(desc, isRunning);
      }
      else if (v instanceof String)
      {
        return (String) v;
      }
      else if (v instanceof LocalizableMessage)
      {
        return ((LocalizableMessage) v).toString();
      }
      else if (v instanceof Integer)
      {
        final int nEntries = ((Integer) v).intValue();
        if (nEntries >= 0)
        {
          return String.valueOf(nEntries);
        }
        return getNotAvailableText(desc, isRunning);
      }
      else
      {
        throw new IllegalStateException("Unknown object type: " + v);
      }
    }
    return "";
  }

  private String getNotAvailableText(ServerDescriptor desc, boolean isRunning)
  {
    if (!isRunning)
    {
      return getNotAvailableBecauseServerIsDownText();
    }
    if (!desc.isAuthenticated() || !desc.getExceptions().isEmpty())
    {
      return getNotAvailableBecauseAuthenticationIsRequiredText();
    }
    return getNotAvailableText();
  }

  private void writeLabelValue(final LocalizableMessage label, final String value, final int maxLabelWidth)
  {
    final LocalizableMessageBuilder buf = new LocalizableMessageBuilder();
    buf.append(label);

    int extra = maxLabelWidth - label.length();
    for (int i = 0; i<extra; i++)
    {
      buf.append(" ");
    }
    buf.append(" ").append(value);
    println(buf.toMessage());
  }

  private LocalizableMessage centerTitle(final LocalizableMessage text)
  {
    if (text.length() <= MAX_LINE_WIDTH - 8)
    {
      final LocalizableMessageBuilder buf = new LocalizableMessageBuilder();
      int extra = Math.min(10,
          (MAX_LINE_WIDTH - 8 - text.length()) / 2);
      for (int i=0; i<extra; i++)
      {
        buf.append(" ");
      }
      buf.append("--- ").append(text).append(" ---");
      return buf.toMessage();
    }
    return text;
  }

  /**
   * Returns the trust manager to be used by this application.
   *
   * @return the trust manager to be used by this application.
   */
  private ApplicationTrustManager getTrustManager()
  {
    if (useInteractiveTrustManager)
    {
      return interactiveTrustManager;
    }
    return argParser.getTrustManager();
  }

  @Override
  public boolean isAdvancedMode()
  {
    return false;
  }

  @Override
  public boolean isInteractive() {
    return argParser.isInteractive();
  }

  @Override
  public boolean isMenuDrivenMode() {
    return true;
  }

  @Override
  public boolean isQuiet() {
    return false;
  }

  @Override
  public boolean isScriptFriendly() {
    return argParser.isScriptFriendly();
  }

  @Override
  public boolean isVerbose() {
    return true;
  }

  /** FIXME Common code with DSConfigand tools*. This method needs to be moved. */
  private ManagementContext getManagementContextFromConnection(
      final LDAPConnectionConsoleInteraction ci) throws ClientException
  {
    // Interact with the user though the console to get
    // LDAP connection information
    final String hostName = getHostNameForLdapUrl(ci.getHostName());
    final Integer portNumber = ci.getPortNumber();
    final DN bindDN = ci.getBindDN();
    final String bindPassword = ci.getBindPassword();
    TrustManager trustManager = ci.getTrustManager();
    final KeyManager keyManager = ci.getKeyManager();

    // This connection should always be secure. useSSL = true.
    Connection connection = null;
    LDAPConnectionFactory factory = null;
    while (true)
    {
      try
      {
        final SSLContextBuilder sslBuilder = new SSLContextBuilder();
        sslBuilder.setTrustManager(trustManager == null ? TrustManagers.trustAll() : trustManager);
        sslBuilder.setKeyManager(keyManager);
        final Options options = Options.defaultOptions()
            .set(CONNECT_TIMEOUT, duration(ci.getConnectTimeout(), MILLISECONDS))
            .set(SSL_USE_STARTTLS, ci.useStartTLS())
            .set(SSL_CONTEXT, sslBuilder.getSSLContext())
            .set(SSL_ENABLED_PROTOCOLS, ConnectionFactoryProvider.getDefaultProtocols());

        factory = new LDAPConnectionFactory(hostName, portNumber, options);
        connection = factory.getConnection();
        connection.bind(bindDN.toString(), bindPassword.toCharArray());
        break;
      }
      catch (LdapException e)
      {
        if (ci.isTrustStoreInMemory() && e.getCause() instanceof SSLException
            && e.getCause().getCause() instanceof CertificateException)
        {
          String authType = null;
          if (trustManager instanceof ApplicationTrustManager)
          { // FIXME use PromptingTrustManager
            ApplicationTrustManager appTrustManager =
                (ApplicationTrustManager) trustManager;
            authType = appTrustManager.getLastRefusedAuthType();
            X509Certificate[] cert = appTrustManager.getLastRefusedChain();

            if (ci.checkServerCertificate(cert, authType, hostName))
            {
              // If the certificate is trusted, update the trust manager.
              trustManager = ci.getTrustManager();
              // Try to connect again.
              continue;
            }
          }
        }
        if (e.getCause() instanceof SSLException)
        {
          LocalizableMessage message =
              ERR_FAILED_TO_CONNECT_NOT_TRUSTED.get(hostName, portNumber);
          throw new ClientException(ReturnCode.CLIENT_SIDE_CONNECT_ERROR,
              message);
        }
        if (e.getCause() instanceof AuthorizationException)
        {
          throw new ClientException(ReturnCode.AUTH_METHOD_NOT_SUPPORTED,
              ERR_SIMPLE_BIND_NOT_SUPPORTED.get());
        }
        else if (e.getCause() instanceof AuthenticationException
            || e.getResult().getResultCode() == ResultCode.INVALID_CREDENTIALS)
        {
          // Status Cli must not fail when un-authenticated.
          return null;
        }
        throw new ClientException(ReturnCode.CLIENT_SIDE_CONNECT_ERROR,
            ERR_FAILED_TO_CONNECT.get(hostName, portNumber));
      }
      catch (GeneralSecurityException e)
      {
        LocalizableMessage message =
            ERR_FAILED_TO_CONNECT.get(hostName, portNumber);
        throw new ClientException(ReturnCode.CLIENT_SIDE_CONNECT_ERROR, message);
      }
      finally
      {
        closeSilently(factory, connection);
      }
    }

    return LDAPManagementContext.newManagementContext(connection, LDAPProfile.getInstance());
  }
}
