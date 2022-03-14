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
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.quicksetup.installer;

import static com.forgerock.opendj.cli.ArgumentConstants.*;
import static com.forgerock.opendj.cli.Utils.*;
import static com.forgerock.opendj.util.OperatingSystem.*;

import static org.forgerock.opendj.ldap.SearchScope.*;
import static org.forgerock.opendj.ldap.requests.Requests.*;
import static org.forgerock.util.Utils.*;
import static org.opends.admin.ads.ServerDescriptor.*;
import static org.opends.admin.ads.ServerDescriptor.ServerProperty.*;
import static org.opends.admin.ads.util.ConnectionUtils.*;
import static org.opends.admin.ads.util.PreferredConnection.Type.*;
import static org.opends.messages.QuickSetupMessages.*;
import static org.opends.quicksetup.Step.*;
import static org.opends.quicksetup.installer.DataReplicationOptions.Type.*;
import static org.opends.quicksetup.installer.InstallProgressStep.*;
import static org.opends.quicksetup.util.Utils.*;
import static org.opends.server.backends.task.TaskState.*;

import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.ldap.Rdn;
import javax.swing.JPanel;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.i18n.LocalizableMessageDescriptor.Arg0;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.ldap.AuthenticationException;
import org.forgerock.opendj.ldap.AuthorizationException;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.EntryNotFoundException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.requests.AddRequest;
import org.forgerock.opendj.ldap.requests.SearchRequest;
import org.forgerock.opendj.ldap.responses.SearchResultEntry;
import org.forgerock.opendj.server.config.client.BackendCfgClient;
import org.forgerock.opendj.server.config.server.BackendCfg;
import org.opends.admin.ads.ADSContext;
import org.opends.admin.ads.ADSContextException;
import org.opends.admin.ads.ReplicaDescriptor;
import org.opends.admin.ads.ServerDescriptor;
import org.opends.admin.ads.SuffixDescriptor;
import org.opends.admin.ads.TopologyCache;
import org.opends.admin.ads.TopologyCacheException;
import org.opends.admin.ads.TopologyCacheFilter;
import org.opends.admin.ads.util.ApplicationTrustManager;
import org.opends.admin.ads.util.ConnectionWrapper;
import org.opends.admin.ads.util.PreferredConnection;
import org.opends.quicksetup.ApplicationException;
import org.opends.quicksetup.ButtonName;
import org.opends.quicksetup.Constants;
import org.opends.quicksetup.Installation;
import org.opends.quicksetup.JavaArguments;
import org.opends.quicksetup.LicenseFile;
import org.opends.quicksetup.ProgressStep;
import org.opends.quicksetup.ReturnCode;
import org.opends.quicksetup.SecurityOptions;
import org.opends.quicksetup.Step;
import org.opends.quicksetup.UserData;
import org.opends.quicksetup.UserDataCertificateException;
import org.opends.quicksetup.UserDataConfirmationException;
import org.opends.quicksetup.UserDataException;
import org.opends.quicksetup.WizardStep;
import org.opends.quicksetup.event.ButtonActionListener;
import org.opends.quicksetup.event.ButtonEvent;
import org.opends.quicksetup.installer.ui.DataOptionsPanel;
import org.opends.quicksetup.installer.ui.DataReplicationPanel;
import org.opends.quicksetup.installer.ui.GlobalAdministratorPanel;
import org.opends.quicksetup.installer.ui.InstallLicensePanel;
import org.opends.quicksetup.installer.ui.InstallReviewPanel;
import org.opends.quicksetup.installer.ui.InstallWelcomePanel;
import org.opends.quicksetup.installer.ui.RemoteReplicationPortsPanel;
import org.opends.quicksetup.installer.ui.RuntimeOptionsPanel;
import org.opends.quicksetup.installer.ui.ServerSettingsPanel;
import org.opends.quicksetup.installer.ui.SuffixesToReplicatePanel;
import org.opends.quicksetup.ui.FieldName;
import org.opends.quicksetup.ui.FinishedPanel;
import org.opends.quicksetup.ui.GuiApplication;
import org.opends.quicksetup.ui.ProgressPanel;
import org.opends.quicksetup.ui.QuickSetup;
import org.opends.quicksetup.ui.QuickSetupDialog;
import org.opends.quicksetup.ui.QuickSetupErrorPanel;
import org.opends.quicksetup.ui.QuickSetupStepPanel;
import org.opends.quicksetup.ui.UIFactory;
import org.opends.quicksetup.util.FileManager;
import org.opends.quicksetup.util.IncompatibleVersionException;
import org.opends.quicksetup.util.ServerController;
import org.opends.quicksetup.util.Utils;
import org.opends.server.backends.task.TaskState;
import org.opends.server.tools.BackendTypeHelper;
import org.opends.server.tools.BackendTypeHelper.BackendTypeUIAdapter;
import org.opends.server.types.HostPort;
import org.opends.server.util.CertificateManager;
import org.opends.server.util.CollectionUtils;
import org.opends.server.util.DynamicConstants;
import org.opends.server.util.Platform.KeyType;
import org.opends.server.util.SetupUtils;
import org.opends.server.util.StaticUtils;

import com.forgerock.opendj.util.OperatingSystem;

/**
 * This is an abstract class that is in charge of actually performing the
 * installation.
 *
 * It just takes a UserData object and based on that installs OpenDJ.
 *
 * When there is an update during the installation it will notify the
 * ProgressUpdateListener objects that have been added to it.  The
 * notification will send a ProgressUpdateEvent.
 *
 * This class is supposed to be fully independent of the graphical layout.
 *
 * Note that we can use freely the class org.opends.server.util.SetupUtils as
 * it is included in quicksetup.jar.
 */
public class Installer extends GuiApplication
{
  /** The minimum integer value that can be used for a port. */
  public static final int MIN_PORT_VALUE = 1;
  /** The maximum integer value that can be used for a port. */
  public static final int MAX_PORT_VALUE = 65535;

  /** The name of the backend created on setup. */
  public static final String ROOT_BACKEND_NAME = "userRoot";

  /** Constants used to do checks. */
  private static final int MIN_DIRECTORY_MANAGER_PWD = 1;

  private static final int MIN_NUMBER_ENTRIES = 1;
  private static final int MAX_NUMBER_ENTRIES = 10000000;

  /**
   * If the user decides to import more than this number of entries, the import
   * process of automatically generated data will be verbose.
   */
  private static final int THRESHOLD_AUTOMATIC_DATA_VERBOSE = 20000;

  /**
   * If the user decides to import a number of entries higher than this
   * threshold, the start process will be verbose.
   */
  private static final int THRESHOLD_VERBOSE_START = 100000;

  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  private TopologyCache lastLoadedCache;

  /** Indicates that we've detected that there is something installed. */
  private boolean forceToDisplaySetup;

  /** When true indicates that the user has canceled this operation. */
  private boolean canceled;
  private boolean javaVersionCheckFailed;

  /** Map containing information about what has been configured remotely. */
  private final Map<ServerDescriptor, ConfiguredReplication> hmConfiguredRemoteReplication = new HashMap<>();

  /** Set of progress steps that have been completed. */
  private final Set<InstallProgressStep> completedProgress = new HashSet<>();
  private final List<WizardStep> listSteps = new ArrayList<>();
  private final Set<WizardStep> SUBSTEPS = CollectionUtils.<WizardStep> newHashSet(
      Step.CREATE_GLOBAL_ADMINISTRATOR,
      Step.SUFFIXES_OPTIONS,
      Step.NEW_SUFFIX_OPTIONS,
      Step.REMOTE_REPLICATION_PORTS);

  private final Map<WizardStep, WizardStep> hmPreviousSteps = new HashMap<>();

  private char[] selfSignedCertPw;

  private boolean registeredNewServerOnRemote;
  private boolean createdAdministrator;
  private boolean createdRemoteAds;
  private String lastImportProgress;

  /** Aliases of self-signed certificates. */
  private static final String[] SELF_SIGNED_CERT_ALIASES = {
    SecurityOptions.SELF_SIGNED_CERT_ALIAS,
    SecurityOptions.SELF_SIGNED_EC_CERT_ALIAS
  };

  /**
   * The threshold in minutes used to know whether we must display a warning
   * informing that there is a server clock difference between two servers whose
   * contents are being replicated.
   */
  public static final int THRESHOLD_CLOCK_DIFFERENCE_WARNING = 5;

  /** This map contains the ratio associated with each step. */
  private final Map<ProgressStep, Integer> hmRatio = new HashMap<>();
  /** This map contains the summary associated with each step. */
  private final Map<ProgressStep, LocalizableMessage> hmSummary = new HashMap<>();

  private ApplicationException applicationException;

  /** Actually performs the install in this thread. The thread is blocked. */
  @Override
  public void run()
  {
    applicationException = null;
    PrintStream origErr = System.err;
    PrintStream origOut = System.out;
    try
    {
      initMaps();
      System.setErr(getApplicationErrorStream());
      System.setOut(getApplicationOutputStream());
      checkAbort();

      setCurrentProgressStep(InstallProgressStep.CONFIGURING_SERVER);
      configureServer();
      checkAbort();

      LicenseFile.createFileLicenseApproved(getInstallationPath());
      checkAbort();

      createData();
      checkAbort();

      if (isWindows() && getUserData().getEnableWindowsService())
      {
        showStepStarted(InstallProgressStep.ENABLING_WINDOWS_SERVICE);
        enableWindowsService();
        checkAbort();
      }

      if (mustStart())
      {
        startServer();
      }

      if (mustCreateAds())
      {
        showStepStarted(InstallProgressStep.CONFIGURING_ADS);
        updateADS();
        checkAbort();
      }

      if (mustConfigureReplication())
      {
        showStepStarted(InstallProgressStep.CONFIGURING_REPLICATION);
        createReplicatedBackendsIfRequired();
        configureReplication();
        checkAbort();
      }

      if (mustInitializeSuffixes())
      {
        showStepStarted(InstallProgressStep.INITIALIZE_REPLICATED_SUFFIXES);
        initializeSuffixes();
        checkAbort();
      }

      if (mustStop())
      {
        showStepStarted(InstallProgressStep.STOPPING_SERVER);
        stopServer(new ServerController(this));
      }

      checkAbort();
      updateSummaryWithServerState(hmSummary, true);
      setCurrentProgressStep(InstallProgressStep.FINISHED_SUCCESSFULLY);
      notifyListeners(null);
      tempLogFile.deleteLogFileAfterSuccess();
    }
    catch (final ApplicationException ex)
    {
      logger.error(LocalizableMessage.raw("Caught exception: "+ex, ex));
      if (ReturnCode.CANCELED.equals(ex.getType())) {
        uninstall();
        setCurrentProgressStep(InstallProgressStep.FINISHED_CANCELED);
        notifyListeners(null);
      } else {
        handleInstallationError(ex);
      }
      applicationException = ex;
    }
    catch (final Throwable t)
    {
      final ApplicationException ex =
          new ApplicationException(ReturnCode.BUG, getThrowableMsg(INFO_BUG_MSG.get(), t), t);
      handleInstallationError(ex);
      applicationException = ex;
    }
    finally
    {
      System.setErr(origErr);
      System.setOut(origOut);
    }
  }

  private void showStepStarted(final InstallProgressStep step)
  {
    if (isVerbose())
    {
      notifyListeners(getTaskSeparator());
    }
    setCurrentProgressStep(step);
  }

  private void startServer() throws ApplicationException
  {
    final boolean verbose = isStartVerbose();
    if (verbose)
    {
      notifyListeners(getTaskSeparator());
    }
    setCurrentProgressStep(InstallProgressStep.STARTING_SERVER);
    final PointAdder pointAdder = new PointAdder();
    if (!verbose)
    {
      notifyListeners(getFormattedProgress(INFO_PROGRESS_STARTING_NON_VERBOSE.get()));
      pointAdder.start();
    }
    try
    {
      new ServerController(this).startServer(!verbose);
    }
    finally
    {
      if (!verbose)
      {
        pointAdder.stop();
      }
    }
    notifyListeners(verbose ? getLineBreak() : getFormattedDoneWithLineBreak());
    checkAbort();
  }

  private void handleInstallationError(final ApplicationException exception)
  {
    stopServerIfNeeded();
    notifyListeners(getLineBreak());
    updateSummaryWithServerState(hmSummary, true);
    setCurrentProgressStep(InstallProgressStep.FINISHED_WITH_ERROR);
    notifyListeners(getFormattedError(exception, true));
    logger.error(LocalizableMessage.raw("Error installing.", exception));
    notifyListeners(getLineBreak());
    notifyListenersOfExistingLogFile();
  }

  private void stopServerIfNeeded()
  {
    final Installation installation = getInstallation();
    if (installation.getStatus().isServerRunning())
    {
      try
      {
        stopServer(new ServerController(installation));
      }
      catch (final ApplicationException t)
      {
        logger.info(LocalizableMessage.raw("error stopping server", t));
      }
    }
  }

  private void stopServer(final ServerController serverController) throws ApplicationException
  {
    if (isVerbose())
    {
      serverController.stopServer(false);
    }
    else
    {
      notifyListeners(getFormattedWithPoints(INFO_PROGRESS_STOPPING_NON_VERBOSE.get()));
      serverController.stopServer(true);
      notifyListeners(getFormattedDoneWithLineBreak());
    }
  }

  @Override
  public Integer getRatio(ProgressStep status)
  {
    return hmRatio.get(status);
  }

  @Override
  public LocalizableMessage getSummary(ProgressStep status)
  {
    return hmSummary.get(status);
  }

  /**
   * Returns the exception from the run() method, if any.
   * @return the ApplicationException raised during the run() method, if any.
   *         null otherwise.
   */
  public ApplicationException getApplicationException()
  {
    return applicationException;
  }

  private void uninstall() {
    notifyListeners(getTaskSeparator());
    if (!isVerbose())
    {
      notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CANCELING.get()));
    }
    else
    {
      notifyListeners(
          getFormattedProgressWithLineBreak(INFO_SUMMARY_CANCELING.get()));
    }
    Installation installation = getInstallation();
    FileManager fm = new FileManager(this);

    stopServerIfNeeded();
    uninstallServices();
    revertToBaseConfiguration(installation, fm);
    cleanupSSLIfNeeded(installation, fm);

    // Remove the databases
    try {
      fm.deleteChildren(installation.getDatabasesDirectory());
    } catch (ApplicationException e) {
      logger.info(LocalizableMessage.raw("Error deleting databases", e));
    }

    if (!isVerbose())
    {
      notifyListeners(getFormattedDoneWithLineBreak());
    }
  }

  private void revertToBaseConfiguration(final Installation installation, final FileManager fm)
  {
    try
    {
      File newConfig = fm.copy(installation.getBaseConfigurationFile(),
          installation.getConfigurationDirectory(), true);
      fm.rename(newConfig, installation.getCurrentConfigurationFile());
    }
    catch (ApplicationException ae)
    {
      logger.info(LocalizableMessage.raw("failed to restore base configuration", ae));
    }
  }

  private void cleanupSSLIfNeeded(final Installation installation, final FileManager fm)
  {
    final SecurityOptions sec = getUserData().getSecurityOptions();
    if (sec.getEnableSSL() || sec.getEnableStartTLS())
    {
      if (SecurityOptions.CertificateType.SELF_SIGNED_CERTIFICATE.equals(sec.getCertificateType()))
      {
        final CertificateManager cm = new CertificateManager(
            getSelfSignedKeystorePath(), CertificateManager.KEY_STORE_TYPE_JKS, getSelfSignedCertificatePwd());
        try
        {
          for (final String alias : SELF_SIGNED_CERT_ALIASES)
          {
            if (cm.aliasInUse(alias))
            {
              cm.removeCertificate(alias);
            }
          }
        }
        catch (KeyStoreException e)
        {
          logger.info(LocalizableMessage.raw("Error deleting self signed certification", e));
        }
      }

      final File configDir = installation.getConfigurationDirectory();
      removeFileIfExists(fm, configDir, "keystore");
      removeFileIfExists(fm, configDir, "keystore.pin");
      removeFileIfExists(fm, configDir, "truststore");
    }
  }

  private void removeFileIfExists(final FileManager fileManager, final File configDir, final String fileName)
  {
    final File file = new File(configDir, fileName);
    if (file.exists())
    {
      try
      {
        fileManager.delete(file);
      }
      catch (ApplicationException e)
      {
        logger.info(LocalizableMessage.raw("Failed to delete " + fileName, e));
      }
    }
  }

  private void initMaps()
  {
    initSummaryMap(hmSummary, true);

    final List<InstallProgressStep> steps = new ArrayList<>();
    steps.add(InstallProgressStep.CONFIGURING_SERVER);
    if (createNotReplicatedSuffix())
    {
      switch (getUserData().getNewSuffixOptions().getType())
      {
      case CREATE_BASE_ENTRY:
        steps.add(InstallProgressStep.CREATING_BASE_ENTRY);
        break;
      case IMPORT_FROM_LDIF_FILE:
        steps.add(InstallProgressStep.IMPORTING_LDIF);
        break;
      case IMPORT_AUTOMATICALLY_GENERATED_DATA:
        steps.add(InstallProgressStep.IMPORTING_AUTOMATICALLY_GENERATED);
        break;
      }
    }

    if (isWindows() && getUserData().getEnableWindowsService())
    {
      steps.add(InstallProgressStep.ENABLING_WINDOWS_SERVICE);
    }

    if (mustStart())
    {
      steps.add(InstallProgressStep.STARTING_SERVER);
    }

    if (mustCreateAds())
    {
      steps.add(InstallProgressStep.CONFIGURING_ADS);
    }

    if (mustConfigureReplication())
    {
      steps.add(InstallProgressStep.CONFIGURING_REPLICATION);
    }

    if (mustInitializeSuffixes())
    {
      steps.add(InstallProgressStep.INITIALIZE_REPLICATED_SUFFIXES);
    }

    if (mustStop())
    {
      steps.add(InstallProgressStep.STOPPING_SERVER);
    }

    int totalTime = 0;
    for (final InstallProgressStep step : steps) {
      totalTime += step.getRelativeDuration();
    }

    int cumulatedTime = 0;
    for (InstallProgressStep s : steps)
    {
      Integer statusTime = s.getRelativeDuration();
      hmRatio.put(s, (100 * cumulatedTime) / totalTime);
      cumulatedTime += statusTime;
    }
    hmRatio.put(InstallProgressStep.FINISHED_SUCCESSFULLY, 100);
    hmRatio.put(InstallProgressStep.FINISHED_WITH_ERROR, 100);
    hmRatio.put(InstallProgressStep.FINISHED_CANCELED, 100);
  }

  @Override
  public String getInstallationPath()
  {
    return Utils.getInstallPathFromClasspath();
  }

  @Override
  public String getInstancePath()
  {
    String installPath =  Utils.getInstallPathFromClasspath();
    return Utils.getInstancePathFromInstallPath(installPath);
  }

  private void notifyListenersOfExistingLogFile()
  {
    if (tempLogFile.isEnabled())
    {
      final String tempLogFilePath = tempLogFile.getPath();
      notifyListeners(getFormattedProgress(INFO_GENERAL_PROVIDE_LOG_IN_ERROR.get(tempLogFilePath)));
      notifyListeners(getLineBreak());
    }
  }

  /** Creates a default instance. */
  public Installer()
  {
    addStepsInOrder(listSteps, LicenseFile.exists());
  }

  @Override
  public boolean isCancellable()
  {
    return true;
  }

  @Override
  public UserData createUserData()
  {
    UserData ud = new UserData();
    ud.setServerLocation(getDefaultServerLocation());
    initializeUserDataWithUserArguments(ud, getUserArguments());
    return ud;
  }

  private void initializeUserDataWithUserArguments(UserData ud, String[] userArguments)
  {
    for (int i = 0; i < userArguments.length; i++)
    {
      if ("--connectTimeout".equalsIgnoreCase(userArguments[i]))
      {
        if (i < userArguments.length - 1)
        {
          String sTimeout = userArguments[i + 1];
          try
          {
            ud.setConnectTimeout(Integer.valueOf(sTimeout));
          }
          catch (Throwable t)
          {
            logger.warn(LocalizableMessage.raw("Error getting connect timeout: " + t, t));
          }
        }
        break;
      }
    }
  }

  @Override
  public void forceToDisplay()
  {
    forceToDisplaySetup = true;
  }

  @Override
  public boolean canGoBack(WizardStep step)
  {
    return step != WELCOME && step != PROGRESS && step != FINISHED;
  }

  @Override
  public boolean canGoForward(WizardStep step)
  {
    return step != REVIEW && step != PROGRESS && step != FINISHED;
  }

  @Override
  public boolean canFinish(WizardStep step)
  {
    return step == REVIEW;
  }

    @Override
  public boolean isSubStep(WizardStep step)
  {
    return SUBSTEPS.contains(step);
  }

  @Override
  public boolean isVisible(WizardStep step, UserData userData)
  {
    if (step == CREATE_GLOBAL_ADMINISTRATOR)
    {
      return userData.mustCreateAdministrator();
    }
    else if (step == NEW_SUFFIX_OPTIONS)
    {
      SuffixesToReplicateOptions suf = userData.getSuffixesToReplicateOptions();
      return suf != null && suf.getType() != SuffixesToReplicateOptions.Type.REPLICATE_WITH_EXISTING_SUFFIXES;
    }
    else if (step == SUFFIXES_OPTIONS)
    {
      DataReplicationOptions repl = userData.getReplicationOptions();
      return repl != null && repl.getType() != DataReplicationOptions.Type.STANDALONE
          && repl.getType() != DataReplicationOptions.Type.FIRST_IN_TOPOLOGY;
    }
    else if (step == REMOTE_REPLICATION_PORTS)
    {
      return isVisible(SUFFIXES_OPTIONS, userData)
          && !userData.getRemoteWithNoReplicationPort().isEmpty()
          && userData.getSuffixesToReplicateOptions().getType() ==
              SuffixesToReplicateOptions.Type.REPLICATE_WITH_EXISTING_SUFFIXES;
    }
    return true;
  }

  @Override
  public boolean isVisible(WizardStep step, QuickSetup qs)
  {
    return isVisible(step, getUserData());
  }

  @Override
  public boolean finishClicked(final WizardStep cStep, final QuickSetup qs)
  {
    if (cStep != Step.REVIEW)
    {
      throw new IllegalStateException("Cannot click on finish when we are not in the Review window");
    }

    updateUserDataForReviewPanel(qs);
    qs.launch();
    qs.setCurrentStep(Step.PROGRESS);
    // Installer responsible for updating the user data and launching
    return false;
  }

    @Override
  public void nextClicked(WizardStep cStep, QuickSetup qs)
  {
    if (cStep == PROGRESS)
    {
      throw new IllegalStateException("Cannot click on next from progress step");
    }
    else if (cStep == REVIEW)
    {
      throw new IllegalStateException("Cannot click on next from review step");
    }
    else if (cStep == FINISHED)
    {
      throw new IllegalStateException("Cannot click on next from finished step");
    }
  }

  @Override
  public void closeClicked(WizardStep cStep, QuickSetup qs)
  {
    if (cStep == PROGRESS)
    {
      if (isFinished()
          || qs.displayConfirmation(INFO_CONFIRM_CLOSE_INSTALL_MSG.get(), INFO_CONFIRM_CLOSE_INSTALL_TITLE.get()))
      {
        qs.quit();
      }
    }
    else if (cStep == FINISHED)
    {
      qs.quit();
    }
    else
    {
      throw new IllegalStateException("Close only can be clicked on PROGRESS step");
    }
  }

  @Override
  public boolean isFinished()
  {
    return getCurrentProgressStep() == InstallProgressStep.FINISHED_SUCCESSFULLY
        || getCurrentProgressStep() == InstallProgressStep.FINISHED_CANCELED
        || getCurrentProgressStep() == InstallProgressStep.FINISHED_WITH_ERROR;
  }

  @Override
  public void cancel()
  {
    setCurrentProgressStep(InstallProgressStep.WAITING_TO_CANCEL);
    notifyListeners(null);
    this.canceled = true;
  }

  @Override
  public void quitClicked(WizardStep cStep, QuickSetup qs)
  {
    if (cStep == FINISHED)
    {
      qs.quit();
    }
    else if (cStep == PROGRESS)
    {
      throw new IllegalStateException("Cannot click on quit from progress step");
    }
    else if (installStatus.isInstalled())
    {
      qs.quit();
    }
    else if (javaVersionCheckFailed)
    {
      qs.quit();
    }
    else if (qs.displayConfirmation(INFO_CONFIRM_QUIT_INSTALL_MSG.get(), INFO_CONFIRM_QUIT_INSTALL_TITLE.get()))
    {
      qs.quit();
    }
  }

  @Override
  public ButtonName getInitialFocusButtonName()
  {
    if (!installStatus.isInstalled() || forceToDisplaySetup)
    {
      return ButtonName.NEXT;
    }
    else if (installStatus.canOverwriteCurrentInstall())
    {
      return ButtonName.CONTINUE_INSTALL;
    }
    else
    {
      return ButtonName.QUIT;
    }
  }

  @Override
  public JPanel createFramePanel(QuickSetupDialog dlg)
  {
    JPanel p;
    javaVersionCheckFailed = true;
    try
    {
      Utils.checkJavaVersion();
      javaVersionCheckFailed = false;
      if (installStatus.isInstalled() && !forceToDisplaySetup)
      {
        p = dlg.getInstalledPanel();
      }
      else
      {
        p = super.createFramePanel(dlg);
      }
    }
    catch (IncompatibleVersionException ijv)
    {
      LocalizableMessageBuilder sb = new LocalizableMessageBuilder();
      sb.append(Utils.breakHtmlString(Utils.getHtml(ijv.getMessageObject().toString()),
          Constants.MAX_CHARS_PER_LINE_IN_DIALOG));
      QuickSetupErrorPanel errPanel = new QuickSetupErrorPanel(this, sb.toMessage());
      final QuickSetupDialog fDlg = dlg;
      errPanel.addButtonActionListener(new ButtonActionListener()
      {
        @Override
        public void buttonActionPerformed(ButtonEvent ev)
        {
          // assumes that we are called in the event thread.
          // Simulate a close button event
          fDlg.notifyButtonEvent(ButtonName.QUIT);
        }
      });
      p = errPanel;
    }
    return p;
  }

  @Override
  public Set<? extends WizardStep> getWizardSteps()
  {
    return Collections.unmodifiableSet(new HashSet<WizardStep>(listSteps));
  }

  @Override
  public QuickSetupStepPanel createWizardStepPanel(WizardStep step)
  {
    if (step instanceof Step)
    {
      switch ((Step) step)
      {
      case WELCOME:
        return new InstallWelcomePanel(this);
      case LICENSE:
        return new InstallLicensePanel(this);
      case SERVER_SETTINGS:
        return new ServerSettingsPanel(this);
      case REPLICATION_OPTIONS:
        return new DataReplicationPanel(this);
      case CREATE_GLOBAL_ADMINISTRATOR:
        return new GlobalAdministratorPanel(this);
      case SUFFIXES_OPTIONS:
        return new SuffixesToReplicatePanel(this);
      case REMOTE_REPLICATION_PORTS:
        return new RemoteReplicationPortsPanel(this);
      case NEW_SUFFIX_OPTIONS:
        return new DataOptionsPanel(this);
      case RUNTIME_OPTIONS:
        return new RuntimeOptionsPanel(this);
      case REVIEW:
        return new InstallReviewPanel(this);
      case PROGRESS:
        return new ProgressPanel(this);
      case FINISHED:
        return new FinishedPanel(this);
      }
    }
    return null;
  }

  @Override
  public void windowClosing(QuickSetupDialog dlg, WindowEvent evt)
  {
    if (installStatus.isInstalled() && forceToDisplaySetup)
    {
      // Simulate a close button event
      dlg.notifyButtonEvent(ButtonName.QUIT);
    }
    else if (dlg.getDisplayedStep() == Step.PROGRESS)
    {
      // Simulate a close button event
      dlg.notifyButtonEvent(ButtonName.CLOSE);
    }
    else
    {
      // Simulate a quit button event
      dlg.notifyButtonEvent(ButtonName.QUIT);
    }
  }

  @Override
  public LocalizableMessage getCloseButtonToolTip()
  {
    return INFO_CLOSE_BUTTON_INSTALL_TOOLTIP.get();
  }

  @Override
  public LocalizableMessage getQuitButtonToolTip()
  {
    return INFO_QUIT_BUTTON_INSTALL_TOOLTIP.get();
  }

  @Override
  public LocalizableMessage getFinishButtonToolTip()
  {
    return INFO_FINISH_BUTTON_INSTALL_TOOLTIP.get();
  }

  @Override
  public int getExtraDialogHeight()
  {
    return UIFactory.EXTRA_DIALOG_HEIGHT;
  }

  @Override
  public void previousClicked(WizardStep cStep, QuickSetup qs)
  {
    if (cStep == WELCOME)
    {
      throw new IllegalStateException("Cannot click on previous from progress step");
    }
    else if (cStep == PROGRESS)
    {
      throw new IllegalStateException("Cannot click on previous from progress step");
    }
    else if (cStep == FINISHED)
    {
      throw new IllegalStateException("Cannot click on previous from finished step");
    }
  }

  @Override
  public LocalizableMessage getFrameTitle()
  {
    return Utils.getCustomizedObject("INFO_FRAME_INSTALL_TITLE", INFO_FRAME_INSTALL_TITLE
        .get(DynamicConstants.PRODUCT_NAME), LocalizableMessage.class);
  }

  /** Indicates the current progress step. */
  private InstallProgressStep currentProgressStep = InstallProgressStep.NOT_STARTED;

  @Override
  public void setWizardDialogState(QuickSetupDialog dlg, UserData userData, WizardStep step)
  {
    if (!installStatus.isInstalled() || forceToDisplaySetup)
    {
      // Set the default button for the frame
      if (step == REVIEW)
      {
        dlg.setFocusOnButton(ButtonName.FINISH);
        dlg.setDefaultButton(ButtonName.FINISH);
      }
      else if (step == WELCOME)
      {
        dlg.setDefaultButton(ButtonName.NEXT);
        dlg.setFocusOnButton(ButtonName.NEXT);
      }
      else if (step == PROGRESS || step == FINISHED)
      {
        dlg.setDefaultButton(ButtonName.CLOSE);
        dlg.setFocusOnButton(ButtonName.CLOSE);
      }
      else
      {
        dlg.setDefaultButton(ButtonName.NEXT);
      }
    }
  }

  @Override
  public ProgressStep getCurrentProgressStep()
  {
    return currentProgressStep;
  }

  @Override
  public WizardStep getFirstWizardStep()
  {
    return WELCOME;
  }

  @Override
  public WizardStep getNextWizardStep(WizardStep step)
  {
    WizardStep next = getNextWizardStep0(step);
    if (next != null)
    {
      hmPreviousSteps.put(next, step);
    }
    return next;
  }

  private WizardStep getNextWizardStep0(WizardStep step)
  {
    if (step == Step.REPLICATION_OPTIONS)
    {
      if (getUserData().mustCreateAdministrator())
      {
        return Step.CREATE_GLOBAL_ADMINISTRATOR;
      }

      switch (getUserData().getReplicationOptions().getType())
      {
      case FIRST_IN_TOPOLOGY:
      case STANDALONE:
        return Step.NEW_SUFFIX_OPTIONS;
      default:
        return Step.SUFFIXES_OPTIONS;
      }
    }
    else if (step == Step.SUFFIXES_OPTIONS)
    {
      switch (getUserData().getSuffixesToReplicateOptions().getType())
      {
      case REPLICATE_WITH_EXISTING_SUFFIXES:
        if (!getUserData().getRemoteWithNoReplicationPort().isEmpty())
        {
          return Step.REMOTE_REPLICATION_PORTS;
        }
        return Step.RUNTIME_OPTIONS;
      default:
        return Step.NEW_SUFFIX_OPTIONS;
      }
    }
    else if (step == Step.REMOTE_REPLICATION_PORTS)
    {
      return Step.RUNTIME_OPTIONS;
    }
    else
    {
      int i = listSteps.indexOf(step);
      if (i != -1 && i + 1 < listSteps.size())
      {
        return listSteps.get(i + 1);
      }
    }
    return null;
  }

  @Override
  public LinkedHashSet<WizardStep> getOrderedSteps()
  {
    LinkedHashSet<WizardStep> orderedSteps = new LinkedHashSet<>();
    addStepsInOrder(orderedSteps, listSteps.contains(LICENSE));
    return orderedSteps;
  }

  private void addStepsInOrder(Collection<WizardStep> steps, boolean licenseExists)
  {
    steps.add(WELCOME);
    if (licenseExists)
    {
      steps.add(LICENSE);
    }
    steps.add(SERVER_SETTINGS);
    steps.add(REPLICATION_OPTIONS);
    steps.add(CREATE_GLOBAL_ADMINISTRATOR);
    steps.add(SUFFIXES_OPTIONS);
    steps.add(REMOTE_REPLICATION_PORTS);
    steps.add(NEW_SUFFIX_OPTIONS);
    steps.add(RUNTIME_OPTIONS);
    steps.add(REVIEW);
    steps.add(PROGRESS);
    steps.add(FINISHED);
  }

  @Override
  public WizardStep getPreviousWizardStep(WizardStep step)
  {
    //  Try with the steps calculated in method getNextWizardStep.
    WizardStep prev = hmPreviousSteps.get(step);

    if (prev == null)
    {
      int i = listSteps.indexOf(step);
      if (i != -1 && i > 0)
      {
        prev = listSteps.get(i - 1);
      }
    }
    return prev;
  }

  @Override
  public WizardStep getFinishedStep()
  {
    return Step.FINISHED;
  }

  /**
   * Uninstalls installed services. This is to be used when the user has elected
   * to cancel an installation.
   */
  private void uninstallServices()
  {
    if (completedProgress.contains(InstallProgressStep.ENABLING_WINDOWS_SERVICE))
    {
      try
      {
        new InstallerHelper().disableWindowsService();
      }
      catch (ApplicationException ae)
      {
        logger.info(LocalizableMessage.raw("Error disabling Windows service", ae));
      }
    }

    unconfigureRemote();
  }

  /**
   * Creates the template files based in the contents of the UserData object.
   * These templates files are used to generate automatically data. To generate
   * the template file the code will basically take into account the value of
   * the base dn and the number of entries to be generated.
   *
   * @return a list of file objects pointing to the create template files.
   * @throws ApplicationException
   *           if an error occurs.
   */
  private File createTemplateFile() throws ApplicationException
  {
    try
    {
      Set<String> baseDNs = new LinkedHashSet<>(getUserData().getNewSuffixOptions().getBaseDns());
      int nEntries = getUserData().getNewSuffixOptions().getNumberEntries();
      return SetupUtils.createTemplateFile(baseDNs, nEntries);
    }
    catch (IOException ioe)
    {
      LocalizableMessage failedMsg = getThrowableMsg(INFO_ERROR_CREATING_TEMP_FILE.get(), ioe);
      throw new ApplicationException(ReturnCode.FILE_SYSTEM_ACCESS_ERROR, failedMsg, ioe);
    }
  }

  /**
   * This methods configures the server based on the contents of the UserData
   * object provided in the constructor.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void configureServer() throws ApplicationException
  {
    notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CONFIGURING.get()));
    copyTemplateInstance();
    writeOpenDSJavaHome();
    writeHostName();
    checkAbort();

    List<String> argList = CollectionUtils.newArrayList(
        "-c", getConfigurationFile(),
        "-h", getUserData().getHostName(),
        "-p", String.valueOf(getUserData().getServerPort()),
        "--adminConnectorPort", String.valueOf(getUserData().getAdminConnectorPort()));

    final SecurityOptions sec = getUserData().getSecurityOptions();
    // TODO: even if the user does not configure SSL maybe we should choose
    // a secure port that is not being used and that we can actually use.
    if (sec.getEnableSSL())
    {
      argList.add("-P");
      argList.add(String.valueOf(sec.getSslPort()));
    }

    if (sec.getEnableStartTLS())
    {
      argList.add("-q");
    }

    addCertificateArguments(sec, argList);
    // For the moment do not enable JMX
    if (getUserData().getServerJMXPort() > 0)
    {
      argList.add("-x");
      argList.add(String.valueOf(getUserData().getServerJMXPort()));
    }

    argList.add("-D");
    argList.add(getUserData().getDirectoryManagerDn().toString());

    argList.add("-w");
    argList.add(getUserData().getDirectoryManagerPwd());

    final ManagedObjectDefinition<? extends BackendCfgClient, ? extends BackendCfg> backendType =
        getUserData().getBackendType();
    if (backendType != null)
    {
      argList.add("--" + OPTION_LONG_BACKEND_TYPE);
      argList.add(BackendTypeHelper.filterSchemaBackendName(backendType.getName()));
    }

    if (createNotReplicatedSuffix())
    {
      for (String baseDn : getUserData().getNewSuffixOptions().getBaseDns())
      {
        argList.add("-b");
        argList.add(baseDn);
      }
    }

    argList.add("-R");
    argList.add(getInstallation().getRootDirectory().getAbsolutePath());

    final String[] args = new String[argList.size()];
    argList.toArray(args);
    StringBuilder cmd = new StringBuilder();
    boolean nextPassword = false;
    for (String s : argList)
    {
      if (cmd.length() > 0)
      {
        cmd.append(" ");
      }
      if (nextPassword)
      {
        cmd.append("{rootUserPassword}");
      }
      else
      {
        cmd.append(s);
      }
      nextPassword = "-w".equals(s);
    }
    logger.info(LocalizableMessage.raw("configure DS cmd: " + cmd));
    final InstallerHelper helper = new InstallerHelper();
    setNotifyListeners(false);
    InvokeThread thread = new InvokeThread()
    {
      @Override
      public void run()
      {
        try
        {
          if (helper.invokeConfigureServer(args) != 0)
          {
            ae = new ApplicationException(ReturnCode.CONFIGURATION_ERROR, INFO_ERROR_CONFIGURING.get(), null);
          }
          else if (getUserData().getNewSuffixOptions().getBaseDns().isEmpty())
          {
            helper.deleteBackend(ROOT_BACKEND_NAME);
          }
        }
        catch (ApplicationException aex)
        {
          ae = aex;
        }
        catch (Throwable t)
        {
          ae = new ApplicationException(
              ReturnCode.CONFIGURATION_ERROR, getThrowableMsg(INFO_ERROR_CONFIGURING.get(), t), t);
        }
        finally
        {
          setNotifyListeners(true);
        }
        isOver = true;
      }

      @Override
      public void abort()
      {
        // TODO: implement the abort
      }
    };
    invokeLongOperation(thread);
    notifyListeners(getFormattedDoneWithLineBreak());
    checkAbort();
    configureCertificate(sec);
  }

  private void configureCertificate(SecurityOptions sec) throws ApplicationException
  {
    try
    {
      SecurityOptions.CertificateType certType = sec.getCertificateType();
      if (certType != SecurityOptions.CertificateType.NO_CERTIFICATE)
      {
        notifyListeners(getFormattedWithPoints(INFO_PROGRESS_UPDATING_CERTIFICATES.get()));
      }

      switch (certType)
      {
      case NO_CERTIFICATE:
        // Nothing to do
        break;
      case SELF_SIGNED_CERTIFICATE:
        String pwd = getSelfSignedCertificatePwd();
        final CertificateManager certManager =
            new CertificateManager(getSelfSignedKeystorePath(), CertificateManager.KEY_STORE_TYPE_JKS, pwd);
        for (String alias : sec.getAliasesToUse())
        {
          final KeyType keyType = KeyType.getTypeOrDefault(alias);
          certManager.generateSelfSignedCertificate(keyType, alias, getSelfSignedCertificateSubjectDN(keyType),
              getSelfSignedCertificateValidity());
          SetupUtils.exportCertificate(certManager, alias, getTemporaryCertificatePath());
          configureTrustStore(CertificateManager.KEY_STORE_TYPE_JKS, alias, pwd);
        }
        break;

      case JKS:
        configureKeyAndTrustStore(sec.getKeystorePath(), CertificateManager.KEY_STORE_TYPE_JKS,
            CertificateManager.KEY_STORE_TYPE_JKS, sec);
        break;

      case JCEKS:
        configureKeyAndTrustStore(sec.getKeystorePath(), CertificateManager.KEY_STORE_TYPE_JCEKS,
            CertificateManager.KEY_STORE_TYPE_JCEKS, sec);
        break;

      case PKCS12:
        configureKeyAndTrustStore(sec.getKeystorePath(), CertificateManager.KEY_STORE_TYPE_PKCS12,
            CertificateManager.KEY_STORE_TYPE_JKS, sec);
        break;

      case PKCS11:
        configureKeyAndTrustStore(CertificateManager.KEY_STORE_PATH_PKCS11, CertificateManager.KEY_STORE_TYPE_PKCS11,
            CertificateManager.KEY_STORE_TYPE_JKS, sec);
        break;

      default:
        throw new IllegalStateException("Unknown certificate type: " + certType);
      }

      if (certType != SecurityOptions.CertificateType.NO_CERTIFICATE)
      {
        notifyListeners(getFormattedDoneWithLineBreak());
      }
    }
    catch (Throwable t)
    {
      logger.error(LocalizableMessage.raw("Error configuring certificate: " + t, t));
      throw new ApplicationException(
          ReturnCode.CONFIGURATION_ERROR, getThrowableMsg(INFO_ERROR_CONFIGURING_CERTIFICATE.get(), t), t);
    }
  }

  private void configureKeyAndTrustStore(final String keyStorePath, final String keyStoreType,
      final String trustStoreType, final SecurityOptions sec) throws Exception
  {
    final String keystorePassword = sec.getKeystorePassword();
    CertificateManager certManager = new CertificateManager(keyStorePath, keyStoreType, keystorePassword);
    for (String keyStoreAlias : sec.getAliasesToUse())
    {
      SetupUtils.exportCertificate(certManager, keyStoreAlias, getTemporaryCertificatePath());
      configureTrustStore(trustStoreType, keyStoreAlias, keystorePassword);
    }
  }

  private void configureTrustStore(final String type, final String keyStoreAlias, final String password)
      throws Exception
  {
    final String alias = keyStoreAlias != null ? keyStoreAlias : SELF_SIGNED_CERT_ALIASES[0];
    final CertificateManager trustMgr = new CertificateManager(getTrustManagerPath(), type, password);
    trustMgr.addCertificate(alias, new File(getTemporaryCertificatePath()));

    createProtectedFile(getKeystorePinPath(), password);
    final File f = new File(getTemporaryCertificatePath());
    f.delete();
  }

  private void addCertificateArguments(SecurityOptions sec, List<String> argList)
  {
    final Collection<String> aliasInKeyStore = sec.getAliasesToUse();

    switch (sec.getCertificateType())
    {
    case SELF_SIGNED_CERTIFICATE:
      argList.add("-k");
      argList.add("cn=JKS,cn=Key Manager Providers,cn=config");
      argList.add("-t");
      argList.add("cn=JKS,cn=Trust Manager Providers,cn=config");
      break;
    case JKS:
      addCertificateArguments(argList, sec, aliasInKeyStore, "cn=JKS,cn=Key Manager Providers,cn=config",
          "cn=JKS,cn=Trust Manager Providers,cn=config");
      break;
    case JCEKS:
      addCertificateArguments(argList, sec, aliasInKeyStore, "cn=JCEKS,cn=Key Manager Providers,cn=config",
          "cn=JCEKS,cn=Trust Manager Providers,cn=config");
      break;
    case PKCS12:
      addCertificateArguments(argList, sec, aliasInKeyStore, "cn=PKCS12,cn=Key Manager Providers,cn=config",
          "cn=JKS,cn=Trust Manager Providers,cn=config");
      break;
    case PKCS11:
      addCertificateArguments(argList, null, aliasInKeyStore, "cn=PKCS11,cn=Key Manager Providers,cn=config",
          "cn=JKS,cn=Trust Manager Providers,cn=config");
      break;
    case NO_CERTIFICATE:
      // Nothing to do.
      break;
    default:
      throw new IllegalStateException("Unknown certificate type: " + sec.getCertificateType());
    }
  }

  private static void addCertificateArguments(List<String> argList, SecurityOptions sec,
      Collection<String> aliasesInKeyStore, String keyStoreDN, String trustStoreDN)
  {
    argList.add("-k");
    argList.add(keyStoreDN);
    argList.add("-t");
    argList.add(trustStoreDN);
    if (sec != null)
    {
      argList.add("-m");
      argList.add(sec.getKeystorePath());
    }
    for(String alias : aliasesInKeyStore)
    {
      argList.add("-a");
      argList.add(alias);
    }
  }

  /**
   * This methods creates the base entry for the suffix based on the contents of
   * the UserData object provided in the constructor.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void createBaseEntry() throws ApplicationException
  {
    LinkedList<String> baseDns = getUserData().getNewSuffixOptions().getBaseDns();
    if (baseDns.size() == 1)
    {
      notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_BASE_ENTRY.get(baseDns.getFirst())));
    }
    else
    {
      notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_BASE_ENTRIES.get()));
    }

    final InstallerHelper helper = new InstallerHelper();

    LinkedList<File> ldifFiles = new LinkedList<>();

    for (String baseDn : baseDns)
    {
      ldifFiles.add(helper.createBaseEntryTempFile(baseDn));
    }
    checkAbort();

    List<String> argList = new ArrayList<>();
    argList.add("-n");
    argList.add(ROOT_BACKEND_NAME);
    for (File f : ldifFiles)
    {
      argList.add("-l");
      argList.add(f.getAbsolutePath());
    }
    argList.add("-F");
    argList.add("-Q");
    argList.add("--offline");
    argList.add("--noPropertiesFile");

    final String[] args = new String[argList.size()];
    argList.toArray(args);

    setNotifyListeners(false);

    InvokeThread thread = new InvokeThread()
    {
      @Override
      public void run()
      {
        try
        {
          int result = helper.invokeImportLDIF(Installer.this, args);

          if (result != 0)
          {
            ae = new ApplicationException(ReturnCode.IMPORT_ERROR, INFO_ERROR_CREATING_BASE_ENTRY.get(), null);
          }
        }
        catch (Throwable t)
        {
          ae =
              new ApplicationException(ReturnCode.IMPORT_ERROR,
                  getThrowableMsg(INFO_ERROR_CREATING_BASE_ENTRY.get(), t), t);
        }
        finally
        {
          setNotifyListeners(true);
        }
        isOver = true;
      }

      @Override
      public void abort()
      {
        // TODO: implement the abort
      }
    };
    invokeLongOperation(thread);
    notifyListeners(getFormattedDoneWithLineBreak());
  }

  /**
   * This methods imports the contents of an LDIF file based on the contents of
   * the UserData object provided in the constructor.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void importLDIF() throws ApplicationException
  {
    LinkedList<String> ldifPaths = getUserData().getNewSuffixOptions().getLDIFPaths();
    LocalizableMessageBuilder mb = new LocalizableMessageBuilder();
    if (ldifPaths.size() > 1)
    {
      if (isVerbose())
      {
        mb.append(getFormattedProgress(INFO_PROGRESS_IMPORTING_LDIFS.get(joinAsString(", ", ldifPaths))));
        mb.append(getLineBreak());
      }
      else
      {
        mb.append(getFormattedProgress(INFO_PROGRESS_IMPORTING_LDIFS_NON_VERBOSE.get(joinAsString(", ", ldifPaths))));
      }
    }
    else if (isVerbose())
    {
      mb.append(getFormattedProgress(INFO_PROGRESS_IMPORTING_LDIF.get(ldifPaths.getFirst())));
      mb.append(getLineBreak());
    }
    else
    {
      mb.append(getFormattedProgress(INFO_PROGRESS_IMPORTING_LDIF_NON_VERBOSE.get(ldifPaths.getFirst())));
    }
    notifyListeners(mb.toMessage());

    final PointAdder pointAdder = new PointAdder();

    if (!isVerbose())
    {
      setNotifyListeners(false);
      pointAdder.start();
    }

    List<String> argList = new ArrayList<>();
    argList.add("--offline");
    argList.add("-n");
    argList.add(ROOT_BACKEND_NAME);
    for (String ldifPath : ldifPaths)
    {
      argList.add("-l");
      argList.add(ldifPath);
    }
    argList.add("-F");
    String rejectedFile = getUserData().getNewSuffixOptions().getRejectedFile();
    if (rejectedFile != null)
    {
      argList.add("-R");
      argList.add(rejectedFile);
    }
    String skippedFile = getUserData().getNewSuffixOptions().getSkippedFile();
    if (skippedFile != null)
    {
      argList.add("--skipFile");
      argList.add(skippedFile);
    }

    argList.add("--noPropertiesFile");

    final String[] args = new String[argList.size()];
    argList.toArray(args);

    InvokeThread thread = new InvokeThread()
    {
      @Override
      public void run()
      {
        try
        {
          InstallerHelper helper = new InstallerHelper();
          int result = helper.invokeImportLDIF(Installer.this, args);

          if (result != 0)
          {
            ae = new ApplicationException(ReturnCode.IMPORT_ERROR, INFO_ERROR_IMPORTING_LDIF.get(), null);
          }
        }
        catch (Throwable t)
        {
          ae = new ApplicationException(
              ReturnCode.IMPORT_ERROR, getThrowableMsg(INFO_ERROR_IMPORTING_LDIF.get(), t), t);
        }
        finally
        {
          if (!isVerbose())
          {
            setNotifyListeners(true);
            pointAdder.stop();
          }
        }
        isOver = true;
      }

      @Override
      public void abort()
      {
        // TODO: implement the abort
      }
    };
    try
    {
      invokeLongOperation(thread);
    }
    catch (ApplicationException ae)
    {
      if (!isVerbose() && lastImportProgress != null)
      {
        notifyListeners(getFormattedProgress(LocalizableMessage.raw(lastImportProgress)));
        notifyListeners(getLineBreak());
      }
      throw ae;
    }
    if (!isVerbose())
    {
      if (lastImportProgress == null)
      {
        notifyListeners(getFormattedDoneWithLineBreak());
      }
      else
      {
        notifyListeners(getFormattedProgress(LocalizableMessage.raw(lastImportProgress)));
        notifyListeners(getLineBreak());
      }
    }
  }

  /**
   * This methods imports automatically generated data based on the contents of
   * the UserData object provided in the constructor.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void importAutomaticallyGenerated() throws ApplicationException
  {
    File templatePath = createTemplateFile();
    int nEntries = getUserData().getNewSuffixOptions().getNumberEntries();
    LocalizableMessageBuilder mb = new LocalizableMessageBuilder();
    if (isVerbose() || nEntries > THRESHOLD_AUTOMATIC_DATA_VERBOSE)
    {
      mb.append(getFormattedProgress(INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED.get(nEntries)));
      mb.append(getLineBreak());
    }
    else
    {
      mb.append(getFormattedProgress(INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED_NON_VERBOSE.get(nEntries)));
    }
    notifyListeners(mb.toMessage());

    final PointAdder pointAdder = new PointAdder();
    if (!isVerbose())
    {
      pointAdder.start();
    }

    if (!isVerbose())
    {
      setNotifyListeners(false);
    }
    final List<String> argList = new ArrayList<>();
    argList.add("--offline");
    argList.add("-n");
    argList.add(ROOT_BACKEND_NAME);
    argList.add("-A");
    argList.add(templatePath.getAbsolutePath());
    argList.add("-s"); // seed
    argList.add("0");
    argList.add("-F");
    argList.add("--noPropertiesFile");

    final String[] args = new String[argList.size()];
    argList.toArray(args);

    InvokeThread thread = new InvokeThread()
    {
      @Override
      public void run()
      {
        try
        {
          InstallerHelper helper = new InstallerHelper();
          int result = helper.invokeImportLDIF(Installer.this, args);

          if (result != 0)
          {
            ae = new ApplicationException(
                ReturnCode.IMPORT_ERROR, INFO_ERROR_IMPORT_LDIF_TOOL_RETURN_CODE.get(result), null);
          }
        }
        catch (Throwable t)
        {
          ae = new ApplicationException(ReturnCode.IMPORT_ERROR, getThrowableMsg(
                      INFO_ERROR_IMPORT_AUTOMATICALLY_GENERATED.get(joinAsString(" ", argList),
                      t.getLocalizedMessage()), t), t);
        }
        finally
        {
          if (!isVerbose())
          {
            setNotifyListeners(true);
            if (ae != null)
            {
              pointAdder.stop();
            }
          }
        }
        isOver = true;
      }

      @Override
      public void abort()
      {
        // TODO: implement the abort
      }
    };
    invokeLongOperation(thread);
    if (!isVerbose())
    {
      pointAdder.stop();
      notifyListeners(getFormattedDoneWithLineBreak());
    }
  }

  /**
   * This method undoes the modifications made in other servers in terms of
   * replication. This method assumes that we are aborting the Installer and
   * that is why it does not call checkAbort.
   */
  private void unconfigureRemote()
  {
    if (registeredNewServerOnRemote || createdAdministrator || createdRemoteAds)
    {
      // Try to connect
      DataReplicationOptions repl = getUserData().getReplicationOptions();
      AuthenticationData auth = repl.getAuthenticationData();
      if (isVerbose())
      {
        notifyListeners(getFormattedWithPoints(INFO_PROGRESS_UNCONFIGURING_ADS_ON_REMOTE.get(auth.getHostPort())));
      }
      try (ConnectionWrapper connectionWrapper = createConnection(auth))
      {
        ADSContext adsContext = new ADSContext(connectionWrapper);
        if (createdRemoteAds)
        {
          adsContext.removeAdminData(true);
        }
        else
        {
          if (registeredNewServerOnRemote)
          {
            try
            {
              adsContext.unregisterServer(getNewServerAdsProperties(getUserData()));
            }
            catch (ADSContextException ace)
            {
              if (ace.getError() != ADSContextException.ErrorType.NOT_YET_REGISTERED)
              {
                throw ace;
              }
              // Else, nothing to do: this may occur if the new server has been
              // unregistered on another server and the modification has been
              // already propagated by replication.
            }
          }
          if (createdAdministrator)
          {
            adsContext.deleteAdministrator(getAdministratorProperties(getUserData()));
          }
        }
        if (isVerbose())
        {
          notifyListeners(getFormattedDoneWithLineBreak());
        }
      }
      catch (Throwable t)
      {
        notifyListeners(getFormattedError(t, true));
      }
    }
    InstallerHelper helper = new InstallerHelper();
    for (Map.Entry<ServerDescriptor, ConfiguredReplication> entry : hmConfiguredRemoteReplication.entrySet())
    {
      ServerDescriptor server = entry.getKey();
      notifyListeners(getFormattedWithPoints(INFO_PROGRESS_UNCONFIGURING_REPLICATION_REMOTE.get(getHostPort(server))));
      try (ConnectionWrapper connectionWrapper = getRemoteConnection(server))
      {
        helper.unconfigureReplication(connectionWrapper, entry.getValue());
      }
      catch (ApplicationException ae)
      {
        notifyListeners(getFormattedError(ae, true));
      }
      notifyListeners(getFormattedDoneWithLineBreak());
    }
  }

  /**
   * This method configures the backends and suffixes that must be replicated.
   * The setup uses the same backend names as in the remote servers. If userRoot
   * is not one of the backends defined in the remote servers, it deletes it
   * from the configuration. NOTE: this method assumes that the server is
   * running.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void createReplicatedBackendsIfRequired() throws ApplicationException
  {
    if (FIRST_IN_TOPOLOGY == getUserData().getReplicationOptions().getType())
    {
      return;
    }
    notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_REPLICATED_BACKENDS.get()));

    // The keys are the backend IDs and the values the list of base DNs.
    final Map<String, Set<DN>> hmBackendSuffix = new HashMap<>();
    final SuffixesToReplicateOptions suffixData = getUserData().getSuffixesToReplicateOptions();
    populateBackendsToCreate(hmBackendSuffix, suffixData.getSuffixes());
    createReplicatedBackends(hmBackendSuffix, suffixData.getSuffixBackendTypes());
    notifyListeners(getFormattedDoneWithLineBreak());
    checkAbort();
  }

  /**
   * The criteria to choose the name of the backend is to try to have the
   * configuration of the other server. The algorithm consists on putting the
   * remote servers in a list and pick the backend as they appear on the list.
   */
  private void populateBackendsToCreate(Map<String, Set<DN>> hmBackendSuffix, Set<SuffixDescriptor> suffixes)
  {
    Set<ServerDescriptor> serverList = getServerListFromSuffixes(suffixes);
    for (SuffixDescriptor suffix : suffixes)
    {
      final ReplicaDescriptor replica = retrieveReplicaForSuffix(serverList, suffix);
      if (replica != null)
      {
        final String backendId = getOrAddBackend(hmBackendSuffix, replica.getBackendId());
        hmBackendSuffix.get(backendId).add(suffix.getDN());
      }
    }
  }

  private Set<ServerDescriptor> getServerListFromSuffixes(Set<SuffixDescriptor> suffixes)
  {
    Set<ServerDescriptor> serverList = new LinkedHashSet<>();
    for (SuffixDescriptor suffix : suffixes)
    {
      for (ReplicaDescriptor replica : suffix.getReplicas())
      {
        serverList.add(replica.getServer());
      }
    }
    return serverList;
  }

  private ReplicaDescriptor retrieveReplicaForSuffix(Set<ServerDescriptor> serverList, SuffixDescriptor suffix)
  {
    for (ServerDescriptor server : serverList)
    {
      for (ReplicaDescriptor replica : suffix.getReplicas())
      {
        if (replica.getServer() == server)
        {
          return replica;
        }
      }
    }
    return null;
  }

  private String getOrAddBackend(Map<String, Set<DN>> hmBackendSuffix, String backendId)
  {
    for (String storedBackend : hmBackendSuffix.keySet())
    {
      if (storedBackend.equalsIgnoreCase(backendId))
      {
        return storedBackend;
      }
    }
    hmBackendSuffix.put(backendId, new HashSet<DN>());
    return backendId;
  }

  private void createReplicatedBackends(final Map<String, Set<DN>> hmBackendSuffix,
      final Map<String, BackendTypeUIAdapter> backendTypes) throws ApplicationException
  {
    try (ConnectionWrapper connection = createLocalConnection())
    {
      final InstallerHelper helper = new InstallerHelper();
      for (Map.Entry<String, Set<DN>> entry : hmBackendSuffix.entrySet())
      {
        String backendId = entry.getKey();
        helper.createBackend(connection, backendId, entry.getValue(),
            backendTypes.get(backendId).getBackend());
      }
    }
    catch (LdapException e)
    {
      LocalizableMessage failedMsg = getThrowableMsg(INFO_ERROR_CONNECTING_TO_LOCAL.get(), e);
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, failedMsg, e);
    }
  }

  /**
   * This method creates the replication configuration for the suffixes on the
   * the local server (and eventually in the remote servers) to synchronize
   * things. NOTE: this method assumes that the server is running.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void configureReplication() throws ApplicationException
  {
    notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CONFIGURING_REPLICATION.get()));

    InstallerHelper helper = new InstallerHelper();
    Set<Integer> knownReplicaServerIds = new HashSet<>();
    Set<Integer> knownReplicationServerIds = new HashSet<>();
    if (lastLoadedCache != null)
    {
      for (SuffixDescriptor suffix : lastLoadedCache.getSuffixes())
      {
        for (ReplicaDescriptor replica : suffix.getReplicas())
        {
          knownReplicaServerIds.add(replica.getServerId());
        }
      }
      for (ServerDescriptor server : lastLoadedCache.getServers())
      {
        Object v = server.getServerProperties().get(REPLICATION_SERVER_ID);
        if (v != null)
        {
          knownReplicationServerIds.add((Integer) v);
        }
      }
    }
    else
    {
      /* There is no ADS anywhere. Just use the SuffixDescriptors we found */
      for (SuffixDescriptor suffix : getUserData().getSuffixesToReplicateOptions().getAvailableSuffixes())
      {
        for (ReplicaDescriptor replica : suffix.getReplicas())
        {
          knownReplicaServerIds.add(replica.getServerId());
          Object v = replica.getServer().getServerProperties().get(REPLICATION_SERVER_ID);
          if (v != null)
          {
            knownReplicationServerIds.add((Integer) v);
          }
        }
      }
    }

    /*
     * For each suffix specified by the user, create a map from the suffix DN to
     * the set of replication servers. The initial instance in a topology is a
     * degenerate case. Also, collect a set of all observed replication servers
     * as the set of ADS suffix replicas (all instances hosting the replication
     * server also replicate ADS).
     */
    Map<DN, Set<HostPort>> replicationServers = new HashMap<>();
    Set<HostPort> adsServers = new HashSet<>();

    if (getUserData().getReplicationOptions().getType() == DataReplicationOptions.Type.FIRST_IN_TOPOLOGY)
    {
      List<String> baseDns = getUserData().getNewSuffixOptions().getBaseDns();
      Set<HostPort> h = new HashSet<>();
      h.add(getLocalReplicationServer());
      adsServers.add(getLocalReplicationServer());
      for (String dnStr : baseDns)
      {
        replicationServers.put(DN.valueOf(dnStr), h);
      }
    }
    else
    {
      Set<SuffixDescriptor> suffixes = getUserData().getSuffixesToReplicateOptions().getSuffixes();
      for (SuffixDescriptor suffix : suffixes)
      {
        Set<HostPort> h = new HashSet<>(suffix.getReplicationServers());
        adsServers.addAll(suffix.getReplicationServers());
        h.add(getLocalReplicationServer());
        adsServers.add(getLocalReplicationServer());
        for (ReplicaDescriptor replica : suffix.getReplicas())
        {
          ServerDescriptor server = replica.getServer();
          AuthenticationData repPort = getUserData().getRemoteWithNoReplicationPort().get(server);
          if (repPort != null)
          {
            HostPort serverDisplay = new HostPort(server.getHostName(), repPort.getPort());
            h.add(serverDisplay);
            adsServers.add(serverDisplay);
          }
        }
        replicationServers.put(suffix.getDN(), h);
      }
    }
    replicationServers.put(ADSContext.getAdministrationSuffixDN(), adsServers);
    replicationServers.put(Constants.SCHEMA_DN, new HashSet<HostPort>(adsServers));

    long localTime = -1;
    long localTimeMeasureTime = -1;
    HostPort localServerDisplay = null;
    try (ConnectionWrapper conn = createLocalConnection())
    {
      helper.configureReplication(conn, replicationServers,
          getUserData().getReplicationOptions().getReplicationPort(),
          getUserData().getReplicationOptions().useSecureReplication(),
          knownReplicationServerIds,
          knownReplicaServerIds);
      localTimeMeasureTime = System.currentTimeMillis();
      localTime = Utils.getServerClock(conn);
      localServerDisplay = conn.getHostPort();
    }
    catch (LdapException ne)
    {
      LocalizableMessage failedMsg = getThrowableMsg(INFO_ERROR_CONNECTING_TO_LOCAL.get(), ne);
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, failedMsg, ne);
    }
    notifyListeners(getFormattedDoneWithLineBreak());
    checkAbort();

    if (getUserData().getReplicationOptions().getType() == DataReplicationOptions.Type.IN_EXISTING_TOPOLOGY)
    {
      Map<ServerDescriptor, Set<ReplicaDescriptor>> hm = new HashMap<>();
      for (SuffixDescriptor suffix : getUserData().getSuffixesToReplicateOptions().getSuffixes())
      {
        for (ReplicaDescriptor replica : suffix.getReplicas())
        {
          Set<ReplicaDescriptor> replicas = hm.get(replica.getServer());
          if (replicas == null)
          {
            replicas = new HashSet<>();
            hm.put(replica.getServer(), replicas);
          }
          replicas.add(replica);
        }
      }
      for (Map.Entry<ServerDescriptor, Set<ReplicaDescriptor>> entry : hm.entrySet())
      {
        ServerDescriptor server = entry.getKey();
        notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CONFIGURING_REPLICATION_REMOTE.get(getHostPort(server))));
        Integer v = (Integer) server.getServerProperties().get(REPLICATION_SERVER_PORT);
        int replicationPort;
        boolean enableSecureReplication;
        if (v != null)
        {
          replicationPort = v;
          enableSecureReplication = false;
        }
        else
        {
          AuthenticationData authData = getUserData().getRemoteWithNoReplicationPort().get(server);
          if (authData != null)
          {
            replicationPort = authData.getPort();
            enableSecureReplication = authData.useSecureConnection();
          }
          else
          {
            replicationPort = Constants.DEFAULT_REPLICATION_PORT;
            enableSecureReplication = false;
            logger.warn(LocalizableMessage.raw("Could not find replication port for: " + getHostPort(server)));
          }
        }
        Set<DN> dns = new HashSet<>();
        for (ReplicaDescriptor replica : entry.getValue())
        {
          dns.add(replica.getSuffix().getDN());
        }
        dns.add(ADSContext.getAdministrationSuffixDN());
        dns.add(Constants.SCHEMA_DN);
        Map<DN, Set<HostPort>> remoteReplicationServers = new HashMap<>();
        for (DN dn : dns)
        {
          Set<HostPort> repServer = replicationServers.get(dn);
          if (repServer == null)
          {
            // Do the comparison manually
            for (Map.Entry<DN, Set<HostPort>> rs1 : replicationServers.entrySet())
            {
              DN dn1 = rs1.getKey();
              if (dn.equals(dn1))
              {
                repServer = rs1.getValue();
                dn = dn1;
                break;
              }
            }
          }
          if (repServer != null)
          {
            remoteReplicationServers.put(dn, repServer);
          }
          else
          {
            logger.warn(LocalizableMessage.raw("Could not find replication server for: " + dn));
          }
        }

        try (ConnectionWrapper conn = getRemoteConnection(server))
        {
          ConfiguredReplication repl = helper.configureReplication(
              conn, remoteReplicationServers, replicationPort, enableSecureReplication,
              knownReplicationServerIds, knownReplicaServerIds);
          long remoteTimeMeasureTime = System.currentTimeMillis();
          long remoteTime = Utils.getServerClock(conn);
          if (localTime != -1
              && remoteTime != -1
              && Math.abs(localTime - remoteTime - localTimeMeasureTime + remoteTimeMeasureTime) >
          THRESHOLD_CLOCK_DIFFERENCE_WARNING * 60 * 1000)
          {
            notifyListeners(getFormattedWarning(INFO_WARNING_SERVERS_CLOCK_DIFFERENCE.get(
                localServerDisplay, conn.getHostPort(), THRESHOLD_CLOCK_DIFFERENCE_WARNING)));
          }

          hmConfiguredRemoteReplication.put(server, repl);
        }

        notifyListeners(getFormattedDoneWithLineBreak());
        checkAbort();
      }
    }
  }

  /**
   * This methods enables this server as a Windows service.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void enableWindowsService() throws ApplicationException
  {
    notifyListeners(getFormattedWithPoints(INFO_PROGRESS_ENABLING_WINDOWS_SERVICE.get()));
    InstallerHelper helper = new InstallerHelper();
    helper.enableWindowsService();
    notifyListeners(getLineBreak());
  }

  /**
   * Updates the contents of the provided map with the localized summary
   * strings.
   *
   * @param hmSummary
   *          the Map to be updated.
   * @param isCli
   *          a boolean to indicate if the install is using CLI or GUI
   */
  private void initSummaryMap(Map<ProgressStep, LocalizableMessage> hmSummary, boolean isCli)
  {
    put(hmSummary, NOT_STARTED, INFO_SUMMARY_INSTALL_NOT_STARTED);
    put(hmSummary, CONFIGURING_SERVER, INFO_SUMMARY_CONFIGURING);
    put(hmSummary, CREATING_BASE_ENTRY, INFO_SUMMARY_CREATING_BASE_ENTRY);
    put(hmSummary, IMPORTING_LDIF, INFO_SUMMARY_IMPORTING_LDIF);
    put(hmSummary, IMPORTING_AUTOMATICALLY_GENERATED, INFO_SUMMARY_IMPORTING_AUTOMATICALLY_GENERATED);
    put(hmSummary, CONFIGURING_REPLICATION, INFO_SUMMARY_CONFIGURING_REPLICATION);
    put(hmSummary, STARTING_SERVER, INFO_SUMMARY_STARTING);
    put(hmSummary, STOPPING_SERVER, INFO_SUMMARY_STOPPING);
    put(hmSummary, CONFIGURING_ADS, INFO_SUMMARY_CONFIGURING_ADS);
    put(hmSummary, INITIALIZE_REPLICATED_SUFFIXES, INFO_SUMMARY_INITIALIZE_REPLICATED_SUFFIXES);
    put(hmSummary, ENABLING_WINDOWS_SERVICE, INFO_SUMMARY_ENABLING_WINDOWS_SERVICE);
    put(hmSummary, WAITING_TO_CANCEL, INFO_SUMMARY_WAITING_TO_CANCEL);
    put(hmSummary, CANCELING, INFO_SUMMARY_CANCELING);

    Installation installation = getInstallation();
    String cmd = Utils.addWordBreaks(getPath(installation.getControlPanelCommandFile()), 60, 5);
    if (!isCli)
    {
      cmd = UIFactory.applyFontToHtml(cmd, UIFactory.INSTRUCTIONS_MONOSPACE_FONT);
    }
    String formattedPath =
        Utils.addWordBreaks(formatter.getFormattedText(LocalizableMessage.raw(getPath(new File(getInstancePath()))))
            .toString(), 60, 5);
    LocalizableMessage successMessage =
        Utils.getCustomizedObject("INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY",
            INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY.get(DynamicConstants.PRODUCT_NAME,
                DynamicConstants.PRODUCT_NAME, formattedPath, INFO_GENERAL_SERVER_STOPPED.get(),
                DynamicConstants.DOC_QUICK_REFERENCE_GUIDE, DynamicConstants.PRODUCT_NAME, cmd),
            LocalizableMessage.class);
    hmSummary.put(FINISHED_SUCCESSFULLY, getFormattedSuccess(successMessage));
    hmSummary.put(FINISHED_CANCELED, getFormattedSuccess(INFO_SUMMARY_INSTALL_FINISHED_CANCELED.get()));
    hmSummary.put(FINISHED_WITH_ERROR,
        getFormattedError(INFO_SUMMARY_INSTALL_FINISHED_WITH_ERROR.get(INFO_GENERAL_SERVER_STOPPED.get(), cmd)));
  }

  private void put(Map<ProgressStep, LocalizableMessage> hmSummary, InstallProgressStep step, Arg0 msg)
  {
    hmSummary.put(step, getFormattedSummary(msg.get()));
  }

  /**
   * Updates the messages in the summary with the state of the server.
   *
   * @param hmSummary
   *          the Map containing the messages.
   * @param isCli
   *          a boolean to indicate if the install is using CLI or GUI
   */
  private void updateSummaryWithServerState(Map<ProgressStep, LocalizableMessage> hmSummary, Boolean isCli)
  {
    Installation installation = getInstallation();
    String cmd = getPath(installation.getControlPanelCommandFile());
    if (!isCli)
    {
      cmd = Utils.addWordBreaks(UIFactory.applyFontToHtml(cmd, UIFactory.INSTRUCTIONS_MONOSPACE_FONT), 60, 5);
    }
    LocalizableMessage status;
    if (installation.getStatus().isServerRunning())
    {
      status = INFO_GENERAL_SERVER_STARTED.get();
    }
    else
    {
      status = INFO_GENERAL_SERVER_STOPPED.get();
    }
    String formattedPath =
        Utils.addWordBreaks(formatter.getFormattedText(LocalizableMessage.raw(getPath(new File(getInstancePath()))))
            .toString(), 60, 5);
    LocalizableMessage successMessage =
        Utils.getCustomizedObject("INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY",
            INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY.get(DynamicConstants.PRODUCT_NAME,
                DynamicConstants.PRODUCT_NAME, formattedPath, status, DynamicConstants.DOC_QUICK_REFERENCE_GUIDE,
                DynamicConstants.PRODUCT_NAME, cmd), LocalizableMessage.class);
    hmSummary.put(InstallProgressStep.FINISHED_SUCCESSFULLY, getFormattedSuccess(successMessage));
    hmSummary.put(InstallProgressStep.FINISHED_WITH_ERROR, getFormattedError(INFO_SUMMARY_INSTALL_FINISHED_WITH_ERROR
        .get(status, cmd)));
  }

  /**
   * Checks the value of <code>canceled</code> field and throws an
   * ApplicationException if true. This indicates that the user has canceled
   * this operation and the process of aborting should begin as soon as
   * possible.
   *
   * @throws ApplicationException
   *           thrown if <code>canceled</code>
   */
  @Override
  public void checkAbort() throws ApplicationException
  {
    if (canceled)
    {
      setCurrentProgressStep(InstallProgressStep.CANCELING);
      notifyListeners(null);
      throw new ApplicationException(ReturnCode.CANCELED, INFO_INSTALL_CANCELED.get(), null);
    }
  }

  /**
   * Writes the host name to a file that will be used by the server to generate
   * a self-signed certificate.
   */
  private void writeHostName()
  {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(getHostNameFile(), false)))
    {
      writer.append(getUserData().getHostName());
    }
    catch (IOException ioe)
    {
      logger.warn(LocalizableMessage.raw("Error writing host name file: " + ioe, ioe));
    }
  }

  /**
   * Returns the file path where the host name is to be written.
   *
   * @return the file path where the host name is to be written.
   */
  private String getHostNameFile()
  {
    return Utils.getPath(getInstallation().getInstanceDirectory().getAbsolutePath(),SetupUtils.HOST_NAME_FILE);
  }

  /**
   * Writes the java home that we are using for the setup in a file. This way we
   * can use this java home even if the user has not set OPENDJ_JAVA_HOME when
   * running the different scripts.
   */
  private void writeOpenDSJavaHome()
  {
    try
    {
      // This isn't likely to happen, and it's not a serious problem even if
      // it does.
      InstallerHelper helper = new InstallerHelper();
      helper.writeSetOpenDSJavaHome(getUserData(), getInstallationPath());
    }
    catch (Exception e)
    {
      logger.warn(LocalizableMessage.raw("Error writing OpenDJ Java Home file: " + e, e));
    }
  }

  /**
   * These methods validate the data provided by the user in the panels and
   * update the userData object according to that content.
   *
   * @param cStep
   *          the current step of the wizard
   * @param qs
   *          QuickStart controller
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  @Override
  public void updateUserData(WizardStep cStep, QuickSetup qs) throws UserDataException
  {
    if (cStep == SERVER_SETTINGS)
    {
      updateUserDataForServerSettingsPanel(qs);
    }
    else if (cStep == REPLICATION_OPTIONS)
    {
      updateUserDataForReplicationOptionsPanel(qs);
    }
    else if (cStep == CREATE_GLOBAL_ADMINISTRATOR)
    {
      updateUserDataForCreateAdministratorPanel(qs);
    }
    else if (cStep == SUFFIXES_OPTIONS)
    {
      updateUserDataForSuffixesOptionsPanel(qs);
    }
    else if (cStep == REMOTE_REPLICATION_PORTS)
    {
      updateUserDataForRemoteReplicationPorts(qs);
    }
    else if (cStep == NEW_SUFFIX_OPTIONS)
    {
      updateUserDataForNewSuffixOptionsPanel(qs);
    }
    else if (cStep == RUNTIME_OPTIONS)
    {
      updateUserDataForRuntimeOptionsPanel(qs);
    }
    else if (cStep == REVIEW)
    {
      updateUserDataForReviewPanel(qs);
    }
  }

  /**
   * Sets the current progress step of the installation process.
   *
   * @param currentProgressStep
   *          the current progress step of the installation process.
   */
  private void setCurrentProgressStep(InstallProgressStep currentProgressStep)
  {
    if (currentProgressStep != null)
    {
      this.completedProgress.add(currentProgressStep);
    }
    this.currentProgressStep = currentProgressStep;
  }

  /**
   * This methods updates the data on the server based on the contents of the
   * UserData object provided in the constructor.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void createData() throws ApplicationException
  {
    if (createNotReplicatedSuffix()
        && NewSuffixOptions.Type.LEAVE_DATABASE_EMPTY != getUserData().getNewSuffixOptions().getType())
    {
      currentProgressStep = getUserData().getNewSuffixOptions().getInstallProgressStep();
      if (isVerbose())
      {
        notifyListeners(getTaskSeparator());
      }

      switch (getUserData().getNewSuffixOptions().getType())
      {
      case CREATE_BASE_ENTRY:
        createBaseEntry();
        break;
      case IMPORT_FROM_LDIF_FILE:
        importLDIF();
        break;
      case IMPORT_AUTOMATICALLY_GENERATED_DATA:
        importAutomaticallyGenerated();
        break;
      default:
        break;
      }
    }
  }

  /**
   * This method initialize the contents of the synchronized servers with the
   * contents of the first server we find.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void initializeSuffixes() throws ApplicationException
  {
    ConnectionWrapper conn = null;
    try
    {
      conn = createLocalConnection();
    }
    catch (Throwable t)
    {
      LocalizableMessage failedMsg = getThrowableMsg(INFO_ERROR_CONNECTING_TO_LOCAL.get(), t);
      StaticUtils.close(conn);
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, failedMsg, t);
    }

    Set<SuffixDescriptor> suffixes = getUserData().getSuffixesToReplicateOptions().getSuffixes();
    DN adminSuffixDn = ADSContext.getAdministrationSuffixDN();
    DN schemaDn = Constants.SCHEMA_DN;

    /* Initialize local ADS and schema contents using any replica. */
    {
      ServerDescriptor server = suffixes.iterator().next().getReplicas().iterator().next().getServer();
      try (ConnectionWrapper remoteConn = getRemoteConnection(server))
      {
        TopologyCacheFilter filter = new TopologyCacheFilter();
        filter.setSearchMonitoringInformation(false);
        filter.addBaseDNToSearch(adminSuffixDn);
        filter.addBaseDNToSearch(schemaDn);
        ServerDescriptor s = createStandalone(remoteConn, filter);
        for (ReplicaDescriptor replica : s.getReplicas())
        {
          DN dn = replica.getSuffix().getDN();
          if (dn.equals(adminSuffixDn))
          {
            suffixes.add(replica.getSuffix());
          }
          else if (dn.equals(schemaDn))
          {
            suffixes.add(replica.getSuffix());
          }
        }
      }
      catch (IOException e)
      {
        LocalizableMessage msg = Utils.getMessageForException(e);
        throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, msg, e);
      }
    }

    for (SuffixDescriptor suffix : suffixes)
    {
      DN dn = suffix.getDN();

      ReplicaDescriptor replica = suffix.getReplicas().iterator().next();
      ServerDescriptor server = replica.getServer();
      HostPort hostPort = getHostPort(server);

      boolean isADS = dn.equals(adminSuffixDn);
      boolean isSchema = dn.equals(schemaDn);
      if (isADS)
      {
        if (isVerbose())
        {
          notifyListeners(getFormattedWithPoints(INFO_PROGRESS_INITIALIZING_ADS.get()));
        }
      }
      else if (isSchema)
      {
        if (isVerbose())
        {
          notifyListeners(getFormattedWithPoints(INFO_PROGRESS_INITIALIZING_SCHEMA.get()));
        }
      }
      else
      {
        notifyListeners(getFormattedProgress(INFO_PROGRESS_INITIALIZING_SUFFIX.get(dn, hostPort)));
        notifyListeners(getLineBreak());
      }
      try
      {
        int replicaServerId = replica.getServerId();
        if (replicaServerId == -1)
        {
          // This occurs if the remote server had not replication configured.
          try (ConnectionWrapper remoteConn = getRemoteConnection(server))
          {
            TopologyCacheFilter filter = new TopologyCacheFilter();
            filter.setSearchMonitoringInformation(false);
            filter.addBaseDNToSearch(dn);
            ServerDescriptor s = createStandalone(remoteConn, filter);
            for (ReplicaDescriptor r : s.getReplicas())
            {
              if (r.getSuffix().getDN().equals(dn))
              {
                replicaServerId = r.getServerId();
              }
            }
          }
          catch (IOException e)
          {
            LocalizableMessage msg = Utils.getMessageForException(e);
            throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, msg, e);
          }
        }
        if (replicaServerId == -1)
        {
          throw new ApplicationException(ReturnCode.APPLICATION_ERROR, ERR_COULD_NOT_FIND_REPLICATIONID.get(dn), null);
        }
        StaticUtils.sleep(3000);
        int nTries = 5;
        boolean initDone = false;
        while (!initDone)
        {
          try
          {
            logger.info(LocalizableMessage.raw("Calling initializeSuffix with base DN: " + dn));
            logger.info(LocalizableMessage.raw("Try number: " + (6 - nTries)));
            logger.info(LocalizableMessage.raw("serverId of source replica: " + replicaServerId));
            initializeSuffix(conn, replicaServerId, dn, !isADS && !isSchema, hostPort);
            initDone = true;
          }
          catch (PeerNotFoundException pnfe)
          {
            logger.info(LocalizableMessage.raw("Peer could not be found"));
            if (nTries == 1)
            {
              throw new ApplicationException(ReturnCode.APPLICATION_ERROR, pnfe.getMessageObject(), null);
            }
            StaticUtils.sleep((5 - nTries) * 3000);
          }
          nTries--;
        }
      }
      catch (ApplicationException ae)
      {
        StaticUtils.close(conn);
        throw ae;
      }
      if ((isADS || isSchema) && isVerbose())
      {
        notifyListeners(getFormattedDone());
        notifyListeners(getLineBreak());
      }
      checkAbort();
    }
  }

  /**
   * This method updates the ADS contents (and creates the according suffixes).
   * If the user specified an existing topology, the new instance is registered
   * with that ADS (the ADS might need to be created), and the local ADS will be
   * populated when the local server is added to the remote server's ADS
   * replication domain in a subsequent step. Otherwise, an ADS is created on
   * the new instance and the server is registered with the new ADS. NOTE: this
   * method assumes that the local server and any remote server are running.
   *
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private void updateADS() throws ApplicationException
  {
    DataReplicationOptions repl = getUserData().getReplicationOptions();
    boolean isRemoteServer = repl.getType() == DataReplicationOptions.Type.IN_EXISTING_TOPOLOGY;
    AuthenticationData auth = isRemoteServer ? repl.getAuthenticationData() : null;
    ConnectionWrapper remoteConn = null; // Bound to remote ADS host (if any).
    ConnectionWrapper localConn = null; // Bound to local server.
    ADSContext adsContext = null; // Bound to ADS host (via one of above).

    /*
     * Outer try-catch-finally to convert occurrences of LdapException and ADSContextException to
     * ApplicationException and clean up connections.
     */
    try
    {
      if (isRemoteServer)
      {
        remoteConn = createConnection(auth);
        adsContext = new ADSContext(remoteConn); // adsContext owns remoteCtx

        /*
         * Check the remote server for ADS. If it does not exist, create the
         * initial ADS there and register the server with itself.
         */
        if (!adsContext.hasAdminData())
        {
          if (isVerbose())
          {
            notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_ADS_ON_REMOTE.get(auth.getHostPort())));
          }

          adsContext.createAdminData(null);
          TopologyCacheFilter filter = new TopologyCacheFilter();
          filter.setSearchMonitoringInformation(false);
          filter.setSearchBaseDNInformation(false);
          ServerDescriptor server = createStandalone(remoteConn, filter);
          server.updateAdsPropertiesWithServerProperties();
          adsContext.registerServer(server.getAdsProperties());
          createdRemoteAds = true;
          if (isVerbose())
          {
            notifyListeners(getFormattedDoneWithLineBreak());
          }
          checkAbort();
        }
      }

      /* Act on local server depending on if using remote or local ADS */
      if (isVerbose())
      {
        notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_ADS.get()));
      }
      localConn = createLocalConnection();
      if (!isRemoteServer)
      {
        /* Configure local server to have an ADS */
        adsContext = new ADSContext(localConn); // adsContext owns localCtx
        adsContext.createAdminData(null);
      }
      /* Register new server in ADS. */
      TopologyCacheFilter filter = new TopologyCacheFilter();
      filter.setSearchMonitoringInformation(false);
      filter.setSearchBaseDNInformation(false);
      ServerDescriptor server = createStandalone(localConn, filter);
      server.updateAdsPropertiesWithServerProperties();
      if (0 == adsContext.registerOrUpdateServer(server.getAdsProperties()))
      {
        if (isRemoteServer)
        {
          registeredNewServerOnRemote = true;
        }
      }
      else
      {
        logger.warn(LocalizableMessage.raw("Server was already registered. Updating " + "server registration."));
      }
      if (isRemoteServer)
      {
        seedAdsTrustStore(localConn, adsContext.getTrustedCertificates());
      }
      if (isVerbose())
      {
        notifyListeners(getFormattedDoneWithLineBreak());
      }
      checkAbort();

      /* Add global administrator if the user specified one. */
      if (getUserData().mustCreateAdministrator())
      {
        try
        {
          if (isVerbose())
          {
            notifyListeners(getFormattedWithPoints(INFO_PROGRESS_CREATING_ADMINISTRATOR.get()));
          }
          adsContext.createAdministrator(getAdministratorProperties(getUserData()));
          if (isRemoteServer && !createdRemoteAds)
          {
            createdAdministrator = true;
          }
          if (isVerbose())
          {
            notifyListeners(getFormattedDoneWithLineBreak());
          }
          checkAbort();
        }
        catch (ADSContextException ade)
        {
          if (ade.getError() == ADSContextException.ErrorType.ALREADY_REGISTERED)
          {
            notifyListeners(getFormattedWarning(INFO_ADMINISTRATOR_ALREADY_REGISTERED.get()));
            adsContext.unregisterServer(server.getAdsProperties());
            adsContext.registerServer(server.getAdsProperties());
          }
          else
          {
            throw ade;
          }
        }
      }
    }
    catch (LdapException ne)
    {
      LocalizableMessage msg;
      if (isRemoteServer)
      {
        msg = getMessageForException(ne, auth.getHostPort().toString());
      }
      else
      {
        msg = Utils.getMessageForException(ne);
      }
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, msg, ne);
    }
    catch (IOException e)
    {
      LocalizableMessage msg;
      if (isRemoteServer)
      {
        msg = getMessageForException(e, auth.getHostPort().toString());
      }
      else
      {
        msg = Utils.getMessageForException(e);
      }
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, msg, e);
    }
    catch (ADSContextException ace)
    {
      throw new ApplicationException(ReturnCode.CONFIGURATION_ERROR, (isRemoteServer ? INFO_REMOTE_ADS_EXCEPTION.get(
          auth.getHostPort(), ace.getMessageObject()) : INFO_ADS_EXCEPTION.get(ace)), ace);
    }
    finally
    {
      StaticUtils.close(remoteConn, localConn);
    }
  }

  private ConnectionWrapper createConnection(AuthenticationData auth) throws LdapException
  {
    HostPort hostPort = auth.getHostPort();
    DN dn = auth.getDn();
    String pwd = auth.getPwd();

    if (auth.useSecureConnection())
    {
      ApplicationTrustManager trustManager = getTrustManager();
      trustManager.setHost(hostPort.getHost());
      return new ConnectionWrapper(hostPort, LDAPS, dn, pwd, getConnectTimeout(), getTrustManager());
    }
    else
    {
      return new ConnectionWrapper(hostPort, LDAP, dn, pwd, getConnectTimeout(), getTrustManager());
    }
  }

  /**
   * Tells whether we must create a suffix that we are not going to replicate
   * with other servers or not.
   *
   * @return {@code true} if we must create a new suffix and {@code false} otherwise.
   */
  private boolean createNotReplicatedSuffix()
  {
    DataReplicationOptions repl = getUserData().getReplicationOptions();

    SuffixesToReplicateOptions suf = getUserData().getSuffixesToReplicateOptions();

    return repl.getType() == DataReplicationOptions.Type.FIRST_IN_TOPOLOGY
        || repl.getType() == DataReplicationOptions.Type.STANDALONE
        || suf.getType() == SuffixesToReplicateOptions.Type.NEW_SUFFIX_IN_TOPOLOGY;
  }

  /**
   * Returns whether we must configure replication.
   *
   * @return {@code true} if we must configure replication and {@code false} otherwise.
   */
  private boolean mustConfigureReplication()
  {
    return getUserData().getReplicationOptions().getType() != DataReplicationOptions.Type.STANDALONE;
  }

  /**
   * Returns whether we must create the ADS.
   *
   * @return {@code true} if we must create the ADS and {@code false} otherwise.
   */
  private boolean mustCreateAds()
  {
    return getUserData().getReplicationOptions().getType() != DataReplicationOptions.Type.STANDALONE;
  }

  /**
   * Returns whether we must start the server.
   *
   * @return {@code true} if we must start the server and {@code false} otherwise.
   */
  private boolean mustStart()
  {
    return getUserData().getStartServer() || mustCreateAds();
  }

  /**
   * Returns whether the start server must be launched in verbose mode.
   * <p>
   * The verbose flag is not enough because in the case where many entries have been imported,
   * the startup phase can take long.
   *
   * @return {@code true} if the start server must be launched in verbose mode and {@code false} otherwise.
   */
  private boolean isStartVerbose()
  {
    if (isVerbose())
    {
      return true;
    }
    boolean manyEntriesToImport = false;
    NewSuffixOptions.Type type = getUserData().getNewSuffixOptions().getType();
    if (type == NewSuffixOptions.Type.IMPORT_FROM_LDIF_FILE)
    {
      long mbTotalSize = 0;
      LinkedList<String> ldifPaths = getUserData().getNewSuffixOptions().getLDIFPaths();
      for (String ldifPath : ldifPaths)
      {
        File f = new File(ldifPath);
        mbTotalSize += f.length();
      }
      // Assume entries of 1kb
      if (mbTotalSize > THRESHOLD_VERBOSE_START * 1024)
      {
        manyEntriesToImport = true;
      }
    }
    else if (type == NewSuffixOptions.Type.IMPORT_AUTOMATICALLY_GENERATED_DATA)
    {
      int nEntries = getUserData().getNewSuffixOptions().getNumberEntries();
      if (nEntries > THRESHOLD_VERBOSE_START)
      {
        manyEntriesToImport = true;
      }
    }
    return manyEntriesToImport;
  }

  /**
   * Returns whether we must stop the server.
   * <p>
   * The server might be stopped if the user asked not to start it at the end
   * of the installation and it was started temporarily to update its configuration.
   *
   * @return {@code true} if we must stop the server and {@code false} otherwise.
   */
  private boolean mustStop()
  {
    return !getUserData().getStartServer() && mustCreateAds();
  }

  /**
   * Returns whether we must initialize suffixes.
   *
   * @return {@code true} if we must initialize suffixes and {@code false} otherwise.
   */
  private boolean mustInitializeSuffixes()
  {
    return getUserData().getReplicationOptions().getType() == DataReplicationOptions.Type.IN_EXISTING_TOPOLOGY;
  }

  /**
   * Returns the list of preferred URLs to connect to remote servers. In fact it
   * returns only the URL to the remote server specified by the user in the
   * replication options panel. The method returns a list for convenience with
   * other interfaces.
   * <p>
   * NOTE: this method assumes that the UserData object has
   * already been updated with the host and port of the remote server.
   *
   * @return the list of preferred URLs to connect to remote servers.
   */
  private Set<PreferredConnection> getPreferredConnections()
  {
    Set<PreferredConnection> cnx = new LinkedHashSet<>();
    DataReplicationOptions repl = getUserData().getReplicationOptions();
    if (repl.getType() == DataReplicationOptions.Type.IN_EXISTING_TOPOLOGY)
    {
      AuthenticationData auth = repl.getAuthenticationData();
      if (auth != null)
      {
        cnx.add(new PreferredConnection(auth.getHostPort(), auth.getConnectionType()));
      }
    }
    return cnx;
  }

  private Map<ADSContext.ServerProperty, Object> getNewServerAdsProperties(UserData userData)
  {
    Map<ADSContext.ServerProperty, Object> serverProperties = new HashMap<>();
    serverProperties.put(ADSContext.ServerProperty.HOST_NAME, userData.getHostName());
    serverProperties.put(ADSContext.ServerProperty.LDAP_PORT, String.valueOf(userData.getServerPort()));
    serverProperties.put(ADSContext.ServerProperty.LDAP_ENABLED, "true");

    // TODO: even if the user does not configure SSL maybe we should choose
    // a secure port that is not being used and that we can actually use.
    SecurityOptions sec = userData.getSecurityOptions();
    if (sec.getEnableSSL())
    {
      serverProperties.put(ADSContext.ServerProperty.LDAPS_PORT, String.valueOf(sec.getSslPort()));
      serverProperties.put(ADSContext.ServerProperty.LDAPS_ENABLED, "true");
    }
    else
    {
      serverProperties.put(ADSContext.ServerProperty.LDAPS_PORT, "636");
      serverProperties.put(ADSContext.ServerProperty.LDAPS_ENABLED, "false");
    }

    if (sec.getEnableStartTLS())
    {
      serverProperties.put(ADSContext.ServerProperty.STARTTLS_ENABLED, "true");
    }
    else
    {
      serverProperties.put(ADSContext.ServerProperty.STARTTLS_ENABLED, "false");
    }

    serverProperties.put(ADSContext.ServerProperty.JMX_PORT, "1689");
    serverProperties.put(ADSContext.ServerProperty.JMX_ENABLED, "false");

    serverProperties.put(ADSContext.ServerProperty.INSTANCE_PATH, getInstallPathFromClasspath());

    String serverID = serverProperties.get(ADSContext.ServerProperty.HOST_NAME) + ":" + userData.getServerPort();

    /* TODO: do we want to ask this specifically to the user? */
    serverProperties.put(ADSContext.ServerProperty.ID, serverID);
    serverProperties.put(ADSContext.ServerProperty.HOST_OS, OperatingSystem.getOperatingSystem().toString());

    return serverProperties;
  }

  private Map<ADSContext.AdministratorProperty, Object> getAdministratorProperties(UserData userData)
  {
    Map<ADSContext.AdministratorProperty, Object> adminProperties = new HashMap<>();
    adminProperties.put(ADSContext.AdministratorProperty.UID, userData.getGlobalAdministratorUID());
    adminProperties.put(ADSContext.AdministratorProperty.PASSWORD, userData.getGlobalAdministratorPassword());
    adminProperties.put(ADSContext.AdministratorProperty.DESCRIPTION,
                        INFO_GLOBAL_ADMINISTRATOR_DESCRIPTION.get().toString());
    return adminProperties;
  }

  /**
   * Validate the data provided by the user in the server settings panel and
   * update the userData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  private void updateUserDataForServerSettingsPanel(QuickSetup qs) throws UserDataException
  {
    List<LocalizableMessage> errorMsgs = new ArrayList<>();

    // Check the host is not empty.
    // TODO: check that the host name is valid...
    String hostName = qs.getFieldStringValue(FieldName.HOST_NAME);
    if (hostName == null || hostName.trim().length() == 0)
    {
      errorMsgs.add(INFO_EMPTY_HOST_NAME.get());
      qs.displayFieldInvalid(FieldName.HOST_NAME, true);
    }
    else
    {
      qs.displayFieldInvalid(FieldName.HOST_NAME, false);
      getUserData().setHostName(hostName);
    }

    // Check the port
    String sPort = qs.getFieldStringValue(FieldName.SERVER_PORT);
    int port = -1;
    try
    {
      port = Integer.parseInt(sPort);
      if (port < MIN_PORT_VALUE || port > MAX_PORT_VALUE)
      {
        errorMsgs.add(INFO_INVALID_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
        qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
      }
      else if (!canUseAsPort(port))
      {
        errorMsgs.add(getCannotBindErrorMessage(port));
        qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
      }
      else
      {
        getUserData().setServerPort(port);
        qs.displayFieldInvalid(FieldName.SERVER_PORT, false);
      }
    }
    catch (NumberFormatException nfe)
    {
      errorMsgs.add(INFO_INVALID_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
      qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
    }

    //  Check the admin connector port
    sPort = qs.getFieldStringValue(FieldName.ADMIN_CONNECTOR_PORT);
    int adminConnectorPort = -1;
    try
    {
      adminConnectorPort = Integer.parseInt(sPort);
      if (adminConnectorPort < MIN_PORT_VALUE || adminConnectorPort > MAX_PORT_VALUE)
      {
        errorMsgs.add(INFO_INVALID_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
        qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, true);
      }
      else if (!canUseAsPort(adminConnectorPort))
      {
        errorMsgs.add(getCannotBindErrorMessage(adminConnectorPort));
        qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, true);
      }
      else if (adminConnectorPort == port)
      {
        errorMsgs.add(INFO_ADMIN_CONNECTOR_VALUE_SEVERAL_TIMES.get());
        qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
        qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, true);
      }
      else
      {
        getUserData().setAdminConnectorPort(adminConnectorPort);
        qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, false);
      }
    }
    catch (NumberFormatException nfe)
    {
      errorMsgs.add(INFO_INVALID_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
      qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, true);
    }

    // Check the secure port
    SecurityOptions sec = (SecurityOptions) qs.getFieldValue(FieldName.SECURITY_OPTIONS);
    int securePort = sec.getSslPort();
    if (sec.getEnableSSL())
    {
      if (securePort < MIN_PORT_VALUE || securePort > MAX_PORT_VALUE)
      {
        errorMsgs.add(INFO_INVALID_SECURE_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
        qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, true);
      }
      else if (!canUseAsPort(securePort))
      {
        errorMsgs.add(getCannotBindErrorMessage(securePort));
        qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, true);
      }
      else if (port == securePort)
      {
        errorMsgs.add(INFO_EQUAL_PORTS.get());
        qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, true);
        qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
      }
      else if (adminConnectorPort == securePort)
      {
        errorMsgs.add(INFO_ADMIN_CONNECTOR_VALUE_SEVERAL_TIMES.get());
        qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, true);
        qs.displayFieldInvalid(FieldName.ADMIN_CONNECTOR_PORT, true);
      }
      else
      {
        getUserData().setSecurityOptions(sec);
        qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, false);
      }
    }
    else
    {
      getUserData().setSecurityOptions(sec);
      qs.displayFieldInvalid(FieldName.SECURITY_OPTIONS, false);
    }

    // Check the Directory Manager DN
    String dmDn = qs.getFieldStringValue(FieldName.DIRECTORY_MANAGER_DN);

    if (dmDn == null || dmDn.trim().length() == 0)
    {
      errorMsgs.add(INFO_EMPTY_DIRECTORY_MANAGER_DN.get());
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_DN, true);
    }
    else if (!isDN(dmDn))
    {
      errorMsgs.add(INFO_NOT_A_DIRECTORY_MANAGER_DN.get());
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_DN, true);
    }
    else if (isConfigurationDn(dmDn))
    {
      errorMsgs.add(INFO_DIRECTORY_MANAGER_DN_IS_CONFIG_DN.get());
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_DN, true);
    }
    else
    {
      getUserData().setDirectoryManagerDn(DN.valueOf(dmDn));
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_DN, false);
    }

    // Check the provided passwords
    String pwd1 = qs.getFieldStringValue(FieldName.DIRECTORY_MANAGER_PWD);
    String pwd2 = qs.getFieldStringValue(FieldName.DIRECTORY_MANAGER_PWD_CONFIRM);
    if (pwd1 == null)
    {
      pwd1 = "";
    }

    boolean pwdValid = true;
    if (!pwd1.equals(pwd2))
    {
      errorMsgs.add(INFO_NOT_EQUAL_PWD.get());
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_PWD_CONFIRM, true);
      pwdValid = false;
    }
    if (pwd1.length() < MIN_DIRECTORY_MANAGER_PWD)
    {
      errorMsgs.add(INFO_PWD_TOO_SHORT.get(MIN_DIRECTORY_MANAGER_PWD));
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_PWD, true);
      if (pwd2 == null || pwd2.length() < MIN_DIRECTORY_MANAGER_PWD)
      {
        qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_PWD_CONFIRM, true);
      }
      pwdValid = false;
    }

    if (pwdValid)
    {
      getUserData().setDirectoryManagerPwd(pwd1);
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_PWD, false);
      qs.displayFieldInvalid(FieldName.DIRECTORY_MANAGER_PWD_CONFIRM, false);
    }

    // For the moment do not enable JMX
    int defaultJMXPort = UserData.getDefaultJMXPort(new int[] { port, securePort });
    if (defaultJMXPort != -1)
    {
      //getUserData().setServerJMXPort(defaultJMXPort);
      getUserData().setServerJMXPort(-1);
    }

    if (!errorMsgs.isEmpty())
    {
      throw new UserDataException(Step.SERVER_SETTINGS, getMessageFromCollection(errorMsgs, "\n"));
    }
  }

  private LocalizableMessage getCannotBindErrorMessage(int port)
  {
    if (isPrivilegedPort(port))
    {
      return INFO_CANNOT_BIND_PRIVILEDGED_PORT.get(port);
    }
    return INFO_CANNOT_BIND_PORT.get(port);
  }

  /**
   * Validate the data provided by the user in the data options panel and update
   * the userData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  private void updateUserDataForReplicationOptionsPanel(QuickSetup qs) throws UserDataException
  {
    boolean hasGlobalAdministrators = false;
    int replicationPort = -1;
    boolean secureReplication = false;
    Integer port = null;
    List<LocalizableMessage> errorMsgs = new ArrayList<>();

    DataReplicationOptions.Type type = (DataReplicationOptions.Type) qs.getFieldValue(FieldName.REPLICATION_OPTIONS);
    String host = qs.getFieldStringValue(FieldName.REMOTE_SERVER_HOST);
    String dnStr = qs.getFieldStringValue(FieldName.REMOTE_SERVER_DN);
    DN dn = dnStr != null ? DN.valueOf(dnStr) : null;
    String pwd = qs.getFieldStringValue(FieldName.REMOTE_SERVER_PWD);

    if (type != DataReplicationOptions.Type.STANDALONE)
    {
      // Check replication port
      replicationPort = checkReplicationPort(qs, errorMsgs);
      secureReplication = (Boolean) qs.getFieldValue(FieldName.REPLICATION_SECURE);
    }

    UserDataConfirmationException confirmEx = null;
    switch (type)
    {
    case IN_EXISTING_TOPOLOGY:
    {
      String sPort = qs.getFieldStringValue(FieldName.REMOTE_SERVER_PORT);
      checkRemoteHostPortDnAndPwd(host, sPort, dn, pwd, qs, errorMsgs);

      if (errorMsgs.isEmpty())
      {
        port = Integer.parseInt(sPort);
        // Try to connect
        boolean[] globalAdmin = { hasGlobalAdministrators };
        DN[] effectiveDn = { dn };
        try
        {
          updateUserDataWithADS(host, port, dn, pwd, qs, errorMsgs, globalAdmin, effectiveDn);
        }
        catch (UserDataConfirmationException e)
        {
          confirmEx = e;
        }
        hasGlobalAdministrators = globalAdmin[0];
        dn = effectiveDn[0];
      }
      break;
    }
    case STANDALONE:
    {
      getUserData().setSuffixesToReplicateOptions(
          new SuffixesToReplicateOptions(SuffixesToReplicateOptions.Type.NO_SUFFIX_TO_REPLICATE,
              new HashSet<SuffixDescriptor>(), new HashSet<SuffixDescriptor>()));
      break;
    }
    case FIRST_IN_TOPOLOGY:
    {
      getUserData().setSuffixesToReplicateOptions(
          new SuffixesToReplicateOptions(SuffixesToReplicateOptions.Type.NEW_SUFFIX_IN_TOPOLOGY,
              new HashSet<SuffixDescriptor>(), new HashSet<SuffixDescriptor>()));
      break;
    }
    default:
      throw new IllegalStateException("Do not know what to do with type: " + type);
    }

    if (errorMsgs.isEmpty())
    {
      AuthenticationData auth = new AuthenticationData();
      auth.setHostPort(new HostPort("".equals(host) ? null : host, port != null ? port : 0));
      auth.setDn(dn);
      auth.setPwd(pwd);
      auth.setUseSecureConnection(true);

      getUserData().setReplicationOptions(createDataReplicationOptions(replicationPort, secureReplication, type, auth));
      getUserData().createAdministrator(
          !hasGlobalAdministrators && type == DataReplicationOptions.Type.IN_EXISTING_TOPOLOGY);
    }
    if (!errorMsgs.isEmpty())
    {
      throw new UserDataException(Step.REPLICATION_OPTIONS, getMessageFromCollection(errorMsgs, "\n"));
    }
    if (confirmEx != null)
    {
      throw confirmEx;
    }
  }

  private DataReplicationOptions createDataReplicationOptions(int replicationPort, boolean secureReplication,
      DataReplicationOptions.Type type, AuthenticationData auth)
  {
    switch (type)
    {
    case IN_EXISTING_TOPOLOGY:
      return DataReplicationOptions.createInExistingTopology(auth, replicationPort, secureReplication);
    case STANDALONE:
      return DataReplicationOptions.createStandalone();
    case FIRST_IN_TOPOLOGY:
      return DataReplicationOptions.createFirstInTopology(replicationPort, secureReplication);
    default:
      throw new IllegalStateException("Do not know what to do with type: " + type);
    }
  }

  private int checkReplicationPort(QuickSetup qs, List<LocalizableMessage> errorMsgs)
  {
    int replicationPort = -1;
    String sPort = qs.getFieldStringValue(FieldName.REPLICATION_PORT);
    try
    {
      replicationPort = Integer.parseInt(sPort);
      if (replicationPort < MIN_PORT_VALUE || replicationPort > MAX_PORT_VALUE)
      {
        errorMsgs.add(INFO_INVALID_REPLICATION_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
        qs.displayFieldInvalid(FieldName.SERVER_PORT, true);
      }
      else if (!canUseAsPort(replicationPort))
      {
        errorMsgs.add(getCannotBindErrorMessage(replicationPort));
        qs.displayFieldInvalid(FieldName.REPLICATION_PORT, true);
      }
      else
      {
        /* Check that we did not chose this port for another protocol */
        SecurityOptions sec = getUserData().getSecurityOptions();
        if (replicationPort == getUserData().getServerPort() || replicationPort == getUserData().getServerJMXPort()
            || (replicationPort == sec.getSslPort() && sec.getEnableSSL()))
        {
          errorMsgs.add(INFO_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL.get());
          qs.displayFieldInvalid(FieldName.REPLICATION_PORT, true);
        }
        else
        {
          qs.displayFieldInvalid(FieldName.REPLICATION_PORT, false);
        }
      }
    }
    catch (NumberFormatException nfe)
    {
      errorMsgs.add(INFO_INVALID_REPLICATION_PORT_VALUE_RANGE.get(MIN_PORT_VALUE, MAX_PORT_VALUE));
      qs.displayFieldInvalid(FieldName.REPLICATION_PORT, true);
    }
    return replicationPort;
  }

  private void checkRemoteHostPortDnAndPwd(String host, String sPort, DN dn, String pwd, QuickSetup qs,
      List<LocalizableMessage> errorMsgs)
  {
    // Check host
    if (host == null || host.length() == 0)
    {
      errorMsgs.add(INFO_EMPTY_REMOTE_HOST.get());
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_HOST, true);
    }
    else
    {
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_HOST, false);
    }

    // Check port
    try
    {
      Integer.parseInt(sPort);
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PORT, false);
    }
    catch (Throwable t)
    {
      errorMsgs.add(INFO_INVALID_REMOTE_PORT.get());
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PORT, true);
    }

    // Check dn
    if (dn == null || dn.size() == 0)
    {
      errorMsgs.add(INFO_EMPTY_REMOTE_DN.get());
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_DN, true);
    }
    else
    {
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_DN, false);
    }

    // Check password
    if (pwd == null || pwd.length() == 0)
    {
      errorMsgs.add(INFO_EMPTY_REMOTE_PWD.get());
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PWD, true);
    }
    else
    {
      qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PWD, false);
    }
  }

  private void updateUserDataWithADS(String host, int port, DN dn, String pwd, QuickSetup qs,
      List<LocalizableMessage> errorMsgs, boolean[] hasGlobalAdministrators, DN[] effectiveDn)
      throws UserDataException
  {
    host = getHostNameForLdapUrl(host);
    HostPort hostPort = new HostPort(host, port);

    ApplicationTrustManager trustManager = getTrustManager();
    trustManager.setHost(host);
    trustManager.resetLastRefusedItems();
    try (ConnectionWrapper conn = newConnectionWrapper(dn, pwd, effectiveDn, hostPort, trustManager))
    {
      ADSContext adsContext = new ADSContext(conn);
      if (adsContext.hasAdminData())
      {
        /* Check if there are already global administrators */
        Set<?> administrators = adsContext.readAdministratorRegistry();
        hasGlobalAdministrators[0] = !administrators.isEmpty();
        Set<TopologyCacheException> exceptions = updateUserDataWithSuffixesInADS(adsContext, trustManager);
        Set<LocalizableMessage> exceptionMsgs = new LinkedHashSet<>();
        /* Check the exceptions and see if we throw them or not. */
        for (TopologyCacheException e : exceptions)
        {
          switch (e.getType())
          {
          case NOT_GLOBAL_ADMINISTRATOR:
            LocalizableMessage errorMsg = INFO_NOT_GLOBAL_ADMINISTRATOR_PROVIDED.get();
            throw new UserDataException(Step.REPLICATION_OPTIONS, errorMsg);
          case GENERIC_CREATING_CONNECTION:
            if (isCertificateException(e.getCause()))
            {
              UserDataCertificateException.Type excType;
              ApplicationTrustManager.Cause cause = null;
              if (e.getTrustManager() != null)
              {
                cause = e.getTrustManager().getLastRefusedCause();
              }
              logger.info(LocalizableMessage.raw("Certificate exception cause: " + cause));
              excType = toUserDataCertificateExceptionType(cause);
              if (excType != null)
              {
                HostPort hostPort2 = e.getHostPort();
                String h = hostPort2.getHost();
                int p = hostPort2.getPort();
                throw new UserDataCertificateException(Step.REPLICATION_OPTIONS, INFO_CERTIFICATE_EXCEPTION.get(h, p),
                    e.getCause(), h, p, e.getTrustManager().getLastRefusedChain(), e.getTrustManager()
                        .getLastRefusedAuthType(), excType);
              }
            }
            break;
          default:
            break;
          }
          exceptionMsgs.add(getMessage(e));
        }
        if (!exceptionMsgs.isEmpty())
        {
          LocalizableMessage confirmationMsg =
              INFO_ERROR_READING_REGISTERED_SERVERS_CONFIRM.get(getMessageFromCollection(exceptionMsgs, "\n"));
          throw new UserDataConfirmationException(Step.REPLICATION_OPTIONS, confirmationMsg);
        }
      }
      else
      {
        updateUserDataWithSuffixesInServer(conn);
      }
    }
    catch (UserDataException ude)
    {
      throw ude;
    }
    catch (Throwable t)
    {
      logger.info(LocalizableMessage.raw("Error connecting to remote server.", t));
      if (isCertificateException(t))
      {
        UserDataCertificateException.Type excType;
        ApplicationTrustManager.Cause cause = trustManager.getLastRefusedCause();
        logger.info(LocalizableMessage.raw("Certificate exception cause: " + cause));
        excType = toUserDataCertificateExceptionType(cause);
        if (excType != null)
        {
          throw new UserDataCertificateException(Step.REPLICATION_OPTIONS, INFO_CERTIFICATE_EXCEPTION.get(host, port),
              t, host, port, trustManager.getLastRefusedChain(), trustManager.getLastRefusedAuthType(), excType);
        }
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_HOST, true);
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PORT, true);
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_DN, true);
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PWD, true);
        errorMsgs.add(INFO_CANNOT_CONNECT_TO_REMOTE_GENERIC.get(host + ":" + port, t));
      }
      else if (t instanceof LdapException)
      {
        errorMsgs.add(getMessageForException((LdapException) t, host + ":" + port));
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_DN, true);
        qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PWD, true);
        if (!(t instanceof AuthorizationException) && !(t instanceof AuthenticationException))
        {
          qs.displayFieldInvalid(FieldName.REMOTE_SERVER_HOST, true);
          qs.displayFieldInvalid(FieldName.REMOTE_SERVER_PORT, true);
        }
      }
      else if (t instanceof ADSContextException)
      {
        errorMsgs.add(INFO_REMOTE_ADS_EXCEPTION.get(host + ":" + port, t));
      }
      else
      {
        throw new UserDataException(Step.REPLICATION_OPTIONS, getThrowableMsg(INFO_BUG_MSG.get(), t));
      }
    }
  }

  private UserDataCertificateException.Type toUserDataCertificateExceptionType(ApplicationTrustManager.Cause cause)
  {
    switch (cause)
    {
    case NOT_TRUSTED:
      return UserDataCertificateException.Type.NOT_TRUSTED;
    case HOST_NAME_MISMATCH:
      return UserDataCertificateException.Type.HOST_NAME_MISMATCH;
    default:
      return null;
    }
  }

  private ConnectionWrapper newConnectionWrapper(DN dn, String pwd, DN[] effectiveDn, HostPort hostPort,
      ApplicationTrustManager trustManager) throws Throwable
  {
    try
    {
      effectiveDn[0] = dn;
      return new ConnectionWrapper(hostPort, LDAPS, dn, pwd, getConnectTimeout(), trustManager);
    }
    catch (Throwable t)
    {
      if (isCertificateException(t))
      {
        throw t;
      }
      // Try using a global administrator
      dn = ADSContext.getAdministratorDN(dn.toString());
      effectiveDn[0] = dn;
      return new ConnectionWrapper(hostPort, LDAPS, dn, pwd, getConnectTimeout(), trustManager);
    }
  }

  /**
   * Validate the data provided by the user in the create global administrator
   * panel and update the UserInstallData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  private void updateUserDataForCreateAdministratorPanel(QuickSetup qs) throws UserDataException
  {
    List<LocalizableMessage> errorMsgs = new ArrayList<>();

    // Check the Global Administrator UID
    String uid = qs.getFieldStringValue(FieldName.GLOBAL_ADMINISTRATOR_UID);

    if (uid == null || uid.trim().length() == 0)
    {
      errorMsgs.add(INFO_EMPTY_ADMINISTRATOR_UID.get());
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_UID, true);
    }
    else
    {
      getUserData().setGlobalAdministratorUID(uid);
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_UID, false);
    }

    // Check the provided passwords
    String pwd1 = qs.getFieldStringValue(FieldName.GLOBAL_ADMINISTRATOR_PWD);
    String pwd2 = qs.getFieldStringValue(FieldName.GLOBAL_ADMINISTRATOR_PWD_CONFIRM);
    if (pwd1 == null)
    {
      pwd1 = "";
    }

    boolean pwdValid = true;
    if (!pwd1.equals(pwd2))
    {
      errorMsgs.add(INFO_NOT_EQUAL_PWD.get());
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_PWD_CONFIRM, true);
      pwdValid = false;
    }
    if (pwd1.length() < MIN_DIRECTORY_MANAGER_PWD)
    {
      errorMsgs.add(INFO_PWD_TOO_SHORT.get(MIN_DIRECTORY_MANAGER_PWD));
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_PWD, true);
      if (pwd2 == null || pwd2.length() < MIN_DIRECTORY_MANAGER_PWD)
      {
        qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_PWD_CONFIRM, true);
      }
      pwdValid = false;
    }

    if (pwdValid)
    {
      getUserData().setGlobalAdministratorPassword(pwd1);
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_PWD, false);
      qs.displayFieldInvalid(FieldName.GLOBAL_ADMINISTRATOR_PWD_CONFIRM, false);
    }

    if (!errorMsgs.isEmpty())
    {
      throw new UserDataException(Step.CREATE_GLOBAL_ADMINISTRATOR, getMessageFromCollection(errorMsgs, "\n"));
    }
  }

  /**
   * Validate the data provided by the user in the replicate suffixes options
   * panel and update the UserInstallData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  @SuppressWarnings("unchecked")
  private void updateUserDataForSuffixesOptionsPanel(QuickSetup qs) throws UserDataException
  {
    List<LocalizableMessage> errorMsgs = new ArrayList<>();
    if (qs.getFieldValue(FieldName.SUFFIXES_TO_REPLICATE_OPTIONS) ==
        SuffixesToReplicateOptions.Type.REPLICATE_WITH_EXISTING_SUFFIXES)
    {
      Set<?> s = (Set<?>) qs.getFieldValue(FieldName.SUFFIXES_TO_REPLICATE);
      if (s.isEmpty())
      {
        errorMsgs.add(INFO_NO_SUFFIXES_CHOSEN_TO_REPLICATE.get());
        qs.displayFieldInvalid(FieldName.SUFFIXES_TO_REPLICATE, true);
      }
      else
      {
        Set<SuffixDescriptor> chosen = new HashSet<>();
        for (Object o : s)
        {
          chosen.add((SuffixDescriptor) o);
        }
        qs.displayFieldInvalid(FieldName.SUFFIXES_TO_REPLICATE, false);
        Set<SuffixDescriptor> available = getUserData().getSuffixesToReplicateOptions().getAvailableSuffixes();
        Map<String, BackendTypeUIAdapter> suffixesBackendTypes =
            (Map<String, BackendTypeUIAdapter>) qs.getFieldValue(FieldName.SUFFIXES_TO_REPLICATE_BACKEND_TYPE);
        SuffixesToReplicateOptions options = new SuffixesToReplicateOptions(
            SuffixesToReplicateOptions.Type.REPLICATE_WITH_EXISTING_SUFFIXES, available, chosen, suffixesBackendTypes);
        getUserData().setSuffixesToReplicateOptions(options);
      }
      getUserData().setRemoteWithNoReplicationPort(getRemoteWithNoReplicationPort(getUserData()));
    }
    else
    {
      Set<SuffixDescriptor> available = getUserData().getSuffixesToReplicateOptions().getAvailableSuffixes();
      Set<SuffixDescriptor> chosen = getUserData().getSuffixesToReplicateOptions().getSuffixes();
      SuffixesToReplicateOptions options =
          new SuffixesToReplicateOptions(SuffixesToReplicateOptions.Type.NEW_SUFFIX_IN_TOPOLOGY, available, chosen);
      getUserData().setSuffixesToReplicateOptions(options);
    }

    if (!errorMsgs.isEmpty())
    {
      throw new UserDataException(Step.SUFFIXES_OPTIONS, getMessageFromCollection(errorMsgs, "\n"));
    }
  }

  /**
   * Validate the data provided by the user in the remote server replication
   * port panel and update the userData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  private void updateUserDataForRemoteReplicationPorts(QuickSetup qs) throws UserDataException
  {
    List<LocalizableMessage> errorMsgs = new ArrayList<>();
    Map<ServerDescriptor, AuthenticationData> servers = getUserData().getRemoteWithNoReplicationPort();
    Map<?, ?> hm = (Map<?, ?>) qs.getFieldValue(FieldName.REMOTE_REPLICATION_PORT);
    Map<?, ?> hmSecure = (Map<?, ?>) qs.getFieldValue(FieldName.REMOTE_REPLICATION_SECURE);
    for (ServerDescriptor server : servers.keySet())
    {
      String hostName = server.getHostName();
      boolean secureReplication = (Boolean) hmSecure.get(server.getId());
      String sPort = (String) hm.get(server.getId());
      try
      {
        int replicationPort = Integer.parseInt(sPort);
        if (replicationPort < MIN_PORT_VALUE || replicationPort > MAX_PORT_VALUE)
        {
          errorMsgs.add(INFO_INVALID_REMOTE_REPLICATION_PORT_VALUE_RANGE.get(getHostPort(server), MIN_PORT_VALUE,
              MAX_PORT_VALUE));
        }
        if (hostName.equalsIgnoreCase(getUserData().getHostName()))
        {
          int securePort = -1;
          if (getUserData().getSecurityOptions().getEnableSSL())
          {
            securePort = getUserData().getSecurityOptions().getSslPort();
          }
          if (replicationPort == getUserData().getServerPort() || replicationPort == getUserData().getServerJMXPort()
              || replicationPort == getUserData().getReplicationOptions().getReplicationPort()
              || replicationPort == securePort)
          {
            errorMsgs.add(INFO_REMOTE_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL.get(getHostPort(server)));
          }
        }
        AuthenticationData authData = new AuthenticationData();
        authData.setPort(replicationPort);
        authData.setUseSecureConnection(secureReplication);
        servers.put(server, authData);
      }
      catch (NumberFormatException nfe)
      {
        errorMsgs.add(INFO_INVALID_REMOTE_REPLICATION_PORT_VALUE_RANGE.get(hostName, MIN_PORT_VALUE, MAX_PORT_VALUE));
      }
    }

    if (!errorMsgs.isEmpty())
    {
      qs.displayFieldInvalid(FieldName.REMOTE_REPLICATION_PORT, true);
      throw new UserDataException(Step.REMOTE_REPLICATION_PORTS, getMessageFromCollection(errorMsgs, "\n"));
    }
    else
    {
      qs.displayFieldInvalid(FieldName.REMOTE_REPLICATION_PORT, false);
      getUserData().setRemoteWithNoReplicationPort(servers);
    }
  }

  /**
   * Validate the data provided by the user in the new suffix data options panel
   * and update the UserInstallData object according to that content.
   *
   * @throws UserDataException
   *           if the data provided by the user is not valid.
   */
  @SuppressWarnings("unchecked")
  private void updateUserDataForNewSuffixOptionsPanel(final QuickSetup ui) throws UserDataException
  {
    final List<LocalizableMessage> errorMsgs = new ArrayList<>();
    // Singleton list with the provided baseDN (if exists and valid)
    List<String> baseDn = new LinkedList<>();
    boolean validBaseDn = checkProvidedBaseDn(ui, baseDn, errorMsgs);
    final NewSuffixOptions dataOptions = checkImportData(ui, baseDn, validBaseDn, errorMsgs);

    if (dataOptions != null)
    {
      getUserData().setBackendType((ManagedObjectDefinition<? extends BackendCfgClient, ? extends BackendCfg>)
          ui.getFieldValue(FieldName.BACKEND_TYPE));
      getUserData().setNewSuffixOptions(dataOptions);
    }

    if (!errorMsgs.isEmpty())
    {
      throw new UserDataException(Step.NEW_SUFFIX_OPTIONS,
          getMessageFromCollection(errorMsgs, Constants.LINE_SEPARATOR));
    }
  }

  private NewSuffixOptions checkImportData(final QuickSetup ui, final List<String> baseDn, final boolean validBaseDn,
      final List<LocalizableMessage> errorMsgs)
  {
    if (baseDn.isEmpty())
    {
      return NewSuffixOptions.createEmpty(baseDn);
    }

    final NewSuffixOptions.Type type = (NewSuffixOptions.Type) ui.getFieldValue(FieldName.DATA_OPTIONS);
    switch (type)
    {
    case IMPORT_FROM_LDIF_FILE:
      return checkImportLDIFFile(ui, baseDn, validBaseDn, errorMsgs);

    case IMPORT_AUTOMATICALLY_GENERATED_DATA:
      return checkImportGeneratedData(ui, baseDn, validBaseDn, errorMsgs);

    default:
      if (validBaseDn)
      {
        return type == NewSuffixOptions.Type.CREATE_BASE_ENTRY ? NewSuffixOptions.createBaseEntry(baseDn)
            : NewSuffixOptions.createEmpty(baseDn);
      }
    }

    return null;
  }

  private NewSuffixOptions checkImportGeneratedData(final QuickSetup ui, final List<String> baseDn,
      final boolean validBaseDn, final List<LocalizableMessage> errorMsgs)
  {
    boolean fieldIsValid = true;
    final List<LocalizableMessage> localErrorMsgs = new LinkedList<>();
    final String nEntries = ui.getFieldStringValue(FieldName.NUMBER_ENTRIES);
    if (nEntries == null || "".equals(nEntries.trim()))
    {
      localErrorMsgs.add(INFO_NO_NUMBER_ENTRIES.get());
      fieldIsValid = false;
    }
    else
    {
      boolean nEntriesValid = false;
      try
      {
        int n = Integer.parseInt(nEntries);
        nEntriesValid = n >= MIN_NUMBER_ENTRIES && n <= MAX_NUMBER_ENTRIES;
      }
      catch (NumberFormatException nfe)
      {
        /* do nothing */
      }

      if (!nEntriesValid)
      {
        localErrorMsgs.add(INFO_INVALID_NUMBER_ENTRIES_RANGE.get(MIN_NUMBER_ENTRIES, MAX_NUMBER_ENTRIES));
        fieldIsValid = false;
      }
    }

    ui.displayFieldInvalid(FieldName.NUMBER_ENTRIES, !fieldIsValid);
    if (validBaseDn && localErrorMsgs.isEmpty())
    {
      return NewSuffixOptions.createAutomaticallyGenerated(baseDn, Integer.parseInt(nEntries));
    }
    errorMsgs.addAll(localErrorMsgs);

    return null;
  }

  private NewSuffixOptions checkImportLDIFFile(final QuickSetup ui, final List<String> baseDn,
      final boolean validBaseDn, final List<LocalizableMessage> errorMsgs)
  {
    final boolean fieldIsValid = false;
    final String ldifPath = ui.getFieldStringValue(FieldName.LDIF_PATH);
    if (ldifPath == null || ldifPath.trim().isEmpty())
    {
      errorMsgs.add(INFO_NO_LDIF_PATH.get());
    }
    else if (!fileExists(ldifPath))
    {
      errorMsgs.add(INFO_LDIF_FILE_DOES_NOT_EXIST.get());
    }
    else if (validBaseDn)
    {
      return NewSuffixOptions.createImportFromLDIF(baseDn, Collections.singletonList(ldifPath), null, null);
    }
    ui.displayFieldInvalid(FieldName.LDIF_PATH, !fieldIsValid);

    return null;
  }

  private boolean checkProvidedBaseDn(final QuickSetup ui, final List<String> baseDn,
      final List<LocalizableMessage> errorMsgs)
  {
    boolean validBaseDn = true;
    String dn = ui.getFieldStringValue(FieldName.DIRECTORY_BASE_DN);
    if (dn == null || dn.trim().length() == 0)
    {
      // Do nothing, the user does not want to provide a base DN.
      dn = "";
    }
    else if (!isDN(dn))
    {
      validBaseDn = false;
      errorMsgs.add(INFO_NOT_A_BASE_DN.get());
    }
    else if (isConfigurationDn(dn))
    {
      validBaseDn = false;
      errorMsgs.add(INFO_BASE_DN_IS_CONFIGURATION_DN.get());
    }
    else
    {
      baseDn.add(dn);
    }
    ui.displayFieldInvalid(FieldName.DIRECTORY_BASE_DN, !validBaseDn);

    return validBaseDn;
  }

  /** Update the userData object according to the content of the runtime options panel. */
  private void updateUserDataForRuntimeOptionsPanel(QuickSetup qs)
  {
    getUserData().setJavaArguments(UserData.SERVER_SCRIPT_NAME,
        (JavaArguments) qs.getFieldValue(FieldName.SERVER_JAVA_ARGUMENTS));
    getUserData().setJavaArguments(UserData.IMPORT_SCRIPT_NAME,
        (JavaArguments) qs.getFieldValue(FieldName.IMPORT_JAVA_ARGUMENTS));
  }

  /** Update the userData object according to the content of the review panel. */
  private void updateUserDataForReviewPanel(QuickSetup qs)
  {
    Boolean b = (Boolean) qs.getFieldValue(FieldName.SERVER_START_INSTALLER);
    getUserData().setStartServer(b);
    b = (Boolean) qs.getFieldValue(FieldName.ENABLE_WINDOWS_SERVICE);
    getUserData().setEnableWindowsService(b);
  }

  /** Update the UserInstallData with the contents we discover in the ADS. */
  private Set<TopologyCacheException> updateUserDataWithSuffixesInADS(ADSContext adsContext,
      ApplicationTrustManager trustManager) throws TopologyCacheException
  {
    Set<TopologyCacheException> exceptions = new HashSet<>();
    SuffixesToReplicateOptions suf = getUserData().getSuffixesToReplicateOptions();
    SuffixesToReplicateOptions.Type type;

    if (suf == null || suf.getType() == SuffixesToReplicateOptions.Type.NO_SUFFIX_TO_REPLICATE)
    {
      type = SuffixesToReplicateOptions.Type.NO_SUFFIX_TO_REPLICATE;
    }
    else
    {
      type = SuffixesToReplicateOptions.Type.NEW_SUFFIX_IN_TOPOLOGY;
    }
    lastLoadedCache = new TopologyCache(adsContext, trustManager, getConnectTimeout());
    // We cannot use getPreferredConnections since the user data has not been updated yet.
    lastLoadedCache.setPreferredConnections(PreferredConnection.getPreferredConnections(adsContext.getConnection()));
    lastLoadedCache.reloadTopology();
    Set<SuffixDescriptor> suffixes = lastLoadedCache.getSuffixes();
    Set<SuffixDescriptor> moreSuffixes = null;
    if (suf != null)
    {
      moreSuffixes = suf.getSuffixes();
    }
    getUserData().setSuffixesToReplicateOptions(new SuffixesToReplicateOptions(type, suffixes, moreSuffixes));

    /*
     * Analyze if we had any exception while loading servers. For the moment
     * only throw the exception found if the user did not provide the
     * Administrator DN and this caused a problem authenticating in one server
     * or if there is a certificate problem.
     */
    Set<ServerDescriptor> servers = lastLoadedCache.getServers();
    for (ServerDescriptor server : servers)
    {
      TopologyCacheException e = server.getLastException();
      if (e != null)
      {
        exceptions.add(e);
      }
    }
    return exceptions;
  }

  /**
   * Update the UserInstallData object with the contents of the server to which
   * we are connected with the provided connection.
   */
  private void updateUserDataWithSuffixesInServer(ConnectionWrapper conn) throws IOException
  {
    SuffixesToReplicateOptions suf = getUserData().getSuffixesToReplicateOptions();
    SuffixesToReplicateOptions.Type type;
    Set<SuffixDescriptor> suffixes = new HashSet<>();
    if (suf != null)
    {
      type = suf.getType();
    }
    else
    {
      type = SuffixesToReplicateOptions.Type.NEW_SUFFIX_IN_TOPOLOGY;
    }

    ServerDescriptor s = createStandalone(conn, new TopologyCacheFilter());
    Set<ReplicaDescriptor> replicas = s.getReplicas();
    for (ReplicaDescriptor replica : replicas)
    {
      suffixes.add(replica.getSuffix());
    }
    Set<SuffixDescriptor> moreSuffixes = null;
    if (suf != null)
    {
      moreSuffixes = suf.getSuffixes();
    }
    getUserData().setSuffixesToReplicateOptions(new SuffixesToReplicateOptions(type, suffixes, moreSuffixes));
  }

  /**
   * Returns the keystore path to be used for generating a self-signed
   * certificate.
   *
   * @return the keystore path to be used for generating a self-signed
   *         certificate.
   */
  private String getSelfSignedKeystorePath()
  {
    return getPath2("keystore");
  }

  /**
   * Returns the trustmanager path to be used for generating a self-signed
   * certificate.
   *
   * @return the trustmanager path to be used for generating a self-signed
   *         certificate.
   */
  private String getTrustManagerPath()
  {
    return getPath2("truststore");
  }

  /**
   * Returns the path of the self-signed that we export to be able to create a
   * truststore.
   *
   * @return the path of the self-signed that is exported.
   */
  private String getTemporaryCertificatePath()
  {
    return getPath2("server-cert.txt");
  }

  /**
   * Returns the path to be used to store the password of the keystore.
   *
   * @return the path to be used to store the password of the keystore.
   */
  private String getKeystorePinPath()
  {
    return getPath2("keystore.pin");
  }

  private String getPath2(String relativePath)
  {
    String parentFile = getPath(getInstancePath(), Installation.CONFIG_PATH_RELATIVE);
    return getPath(parentFile, relativePath);
  }

  /**
   * Returns the validity period to be used to generate the self-signed
   * certificate.
   *
   * @return the validity period to be used to generate the self-signed
   *         certificate.
   */
  private int getSelfSignedCertificateValidity()
  {
    return 20 * 365;
  }

  /**
   * Returns the Subject DN to be used to generate the self-signed certificate.
   *
   * @return the Subject DN to be used to generate the self-signed certificate.
   */
  private String getSelfSignedCertificateSubjectDN(KeyType keyType)
  {
    return "cn=" + Rdn.escapeValue(getUserData().getHostName()) + ",O=OpenDJ " + keyType + " Self-Signed Certificate";
  }

  /**
   * Returns the self-signed certificate password used for this session. This
   * method calls <code>createSelfSignedCertificatePwd()</code> the first time
   * this method is called.
   *
   * @return the self-signed certificate password used for this session.
   */
  private String getSelfSignedCertificatePwd()
  {
    if (selfSignedCertPw == null)
    {
      selfSignedCertPw = SetupUtils.createSelfSignedCertificatePwd();
    }
    return new String(selfSignedCertPw);
  }

  private Map<ServerDescriptor, AuthenticationData> getRemoteWithNoReplicationPort(UserData userData)
  {
    Map<ServerDescriptor, AuthenticationData> servers = new HashMap<>();
    Set<SuffixDescriptor> suffixes = userData.getSuffixesToReplicateOptions().getSuffixes();
    for (SuffixDescriptor suffix : suffixes)
    {
      for (ReplicaDescriptor replica : suffix.getReplicas())
      {
        ServerDescriptor server = replica.getServer();
        Object v = server.getServerProperties().get(IS_REPLICATION_SERVER);
        if (!Boolean.TRUE.equals(v))
        {
          AuthenticationData authData = new AuthenticationData();
          authData.setPort(Constants.DEFAULT_REPLICATION_PORT);
          authData.setUseSecureConnection(false);
          servers.put(server, authData);
        }
      }
    }
    return servers;
  }

  private ConnectionWrapper createLocalConnection() throws LdapException
  {
    UserData uData = getUserData();
    HostPort hostPort = new HostPort(uData.getHostName(), uData.getAdminConnectorPort());
    DN dn = uData.getDirectoryManagerDn();
    String pwd = uData.getDirectoryManagerPwd();
    return new ConnectionWrapper(hostPort, LDAPS, dn, pwd, getConnectTimeout(), null);
  }

  /**
   * Gets a connection based on the information that appears on the
   * provided ServerDescriptor.
   *
   * @param server
   *          the object describing the server.
   * @return the connection to the remote server.
   * @throws ApplicationException
   *           if something goes wrong.
   */
  private ConnectionWrapper getRemoteConnection(ServerDescriptor server) throws ApplicationException
  {
    Map<ADSContext.ServerProperty, Object> adsProperties;
    AuthenticationData auth = getUserData().getReplicationOptions().getAuthenticationData();
    if (!server.isRegistered())
    {
      /*
       * Create adsProperties to be able to use the class ServerLoader to get
       * the connection. Just update the connection parameters with what the
       * user chose in the Topology Options panel (i.e. even if SSL is enabled
       * on the remote server, use standard LDAP to connect to the server if the
       * user specified the LDAP port: this avoids having an issue with the
       * certificate if it has not been accepted previously by the user).
       */
      adsProperties = new HashMap<>();
      adsProperties.put(ADSContext.ServerProperty.HOST_NAME, server.getHostName());
      if (auth.useSecureConnection())
      {
        adsProperties.put(ADSContext.ServerProperty.LDAPS_PORT, String.valueOf(auth.getPort()));
        adsProperties.put(ADSContext.ServerProperty.LDAPS_ENABLED, "true");
      }
      else
      {
        adsProperties.put(ADSContext.ServerProperty.LDAP_PORT, String.valueOf(auth.getPort()));
        adsProperties.put(ADSContext.ServerProperty.LDAP_ENABLED, "true");
      }
      server.setAdsProperties(adsProperties);
    }
    return getRemoteConnection(server, auth.getDn(), auth.getPwd(), getConnectTimeout(), getPreferredConnections());
  }

  /**
   * Initializes a suffix with the contents of a replica that has a given
   * replication id.
   *
   * @param conn
   *          the connection to the server whose suffix we want to initialize.
   * @param replicaServerId
   *          the server ID of the replica we want to use to initialize the
   *          contents of the suffix.
   * @param suffixDn
   *          the dn of the suffix.
   * @param displayProgress
   *          whether we want to display progress or not.
   * @param sourceServerDisplay
   *          the string to be used to represent the server that contains the
   *          data that will be used to initialize the suffix.
   * @throws ApplicationException
   *           if an unexpected error occurs.
   * @throws PeerNotFoundException
   *           if the replication mechanism cannot find a peer.
   */
  public void initializeSuffix(ConnectionWrapper conn, int replicaServerId, DN suffixDn, boolean displayProgress,
      HostPort sourceServerDisplay) throws ApplicationException, PeerNotFoundException
  {
    boolean taskCreated = false;
    int i = 1;
    boolean isOver = false;
    String dn = "";
    AddRequest addRequest = newAddRequest(dn)
        .addAttribute("objectclass", "top", "ds-task", "ds-task-initialize-from-remote-replica")
        .addAttribute("ds-task-class-name", "org.opends.server.tasks.InitializeTask")
        .addAttribute("ds-task-initialize-domain-dn", suffixDn.toString())
        .addAttribute("ds-task-initialize-replica-server-id", String.valueOf(replicaServerId));
    while (!taskCreated)
    {
      checkAbort();
      String id = "quicksetup-initialize" + i;
      dn = "ds-task-id=" + id + ",cn=Scheduled Tasks,cn=Tasks";
      addRequest
          .setName(dn)
          .replaceAttribute("ds-task-id", id);
      try
      {
        conn.getConnection().add(addRequest);
        taskCreated = true;
        logger.info(LocalizableMessage.raw("created task entry: " + addRequest));
      }
      catch (LdapException e)
      {
        if (e.getResult().getResultCode() == ResultCode.ENTRY_ALREADY_EXISTS)
        {
          logger.warn(LocalizableMessage.raw("A task with dn: " + dn + " already existed."));
        }
        else
        {
          logger.error(LocalizableMessage.raw("Error creating task " + addRequest, e));
          throw new ApplicationException(ReturnCode.APPLICATION_ERROR, getThrowableMsg(
              INFO_ERROR_LAUNCHING_INITIALIZATION.get(sourceServerDisplay), e), e);
        }
      }
      i++;
    }

    // Wait until it is over
    SearchRequest searchRequest =
        newSearchRequest(dn, BASE_OBJECT, "(objectclass=*)", "ds-task-unprocessed-entry-count",
            "ds-task-processed-entry-count", "ds-task-log-message", "ds-task-state");
    LocalizableMessage lastDisplayedMsg = null;
    String lastLogMsg = null;
    long lastTimeMsgDisplayed = -1;
    long lastTimeMsgLogged = -1;
    long totalEntries = 0;
    while (!isOver)
    {
      if (canceled)
      {
        // TODO: we should try to cleanly abort the initialize.  As we have
        // aborted the install, the server will be stopped and the remote
        // server will receive a connect error.
        checkAbort();
      }
      StaticUtils.sleep(500);
      if (canceled)
      {
        // TODO: we should try to cleanly abort the initialize.  As we have
        // aborted the install, the server will be stopped and the remote
        // server will receive a connect error.
        checkAbort();
      }

      try
      {
        SearchResultEntry sr = conn.getConnection().searchSingleEntry(searchRequest);
        // Get the number of entries that have been handled and a percentage...
        long processed = sr.parseAttribute("ds-task-processed-entry-count").asLong();
        long unprocessed = sr.parseAttribute("ds-task-unprocessed-entry-count").asLong();
        totalEntries = Math.max(totalEntries, processed + unprocessed);

        LocalizableMessage msg = getLocalizedMessage(lastDisplayedMsg, processed, unprocessed);
        // TODO JNR extract method
        if (msg != null)
        {
          long currentTime = System.currentTimeMillis();
          long minRefreshPeriod = getMinRefreshPeriodInMillis(totalEntries);
          if (currentTime - minRefreshPeriod > lastTimeMsgLogged)
          {
            lastTimeMsgLogged = currentTime;
            logger.info(LocalizableMessage.raw("Progress msg: " + msg));
          }
          if (displayProgress && currentTime - minRefreshPeriod > lastTimeMsgDisplayed && !msg.equals(lastDisplayedMsg))
          {
            notifyListeners(getFormattedProgress(msg));
            lastDisplayedMsg = msg;
            notifyListeners(getLineBreak());
            lastTimeMsgDisplayed = currentTime;
          }
        }

        String logMsg = firstValueAsString(sr, "ds-task-log-message");
        if (logMsg != null && !logMsg.equals(lastLogMsg))
        {
          logger.info(LocalizableMessage.raw(logMsg));
          lastLogMsg = logMsg;
        }
        InstallerHelper helper = new InstallerHelper();
        String state = firstValueAsString(sr, "ds-task-state");
        TaskState taskState = TaskState.fromString(state);

        if (TaskState.isDone(taskState) || taskState == STOPPED_BY_ERROR)
        {
          isOver = true;
          LocalizableMessage errorMsg;
          logger.info(LocalizableMessage.raw("Last task entry: " + sr));
          if (displayProgress && msg != null && !msg.equals(lastDisplayedMsg))
          {
            notifyListeners(getFormattedProgress(msg));
            lastDisplayedMsg = msg;
            notifyListeners(getLineBreak());
          }

          if (lastLogMsg != null)
          {
            errorMsg =
                INFO_ERROR_DURING_INITIALIZATION_LOG.get(sourceServerDisplay, lastLogMsg, state, sourceServerDisplay);
          }
          else
          {
            errorMsg = INFO_ERROR_DURING_INITIALIZATION_NO_LOG.get(sourceServerDisplay, state, sourceServerDisplay);
          }

          logger.warn(LocalizableMessage.raw("Processed errorMsg: " + errorMsg));
          if (taskState == COMPLETED_WITH_ERRORS)
          {
            if (displayProgress)
            {
              notifyListeners(getFormattedWarning(errorMsg));
            }
          }
          else if (!TaskState.isSuccessful(taskState) || taskState == STOPPED_BY_ERROR)
          {
            ApplicationException ae = new ApplicationException(ReturnCode.APPLICATION_ERROR, errorMsg, null);
            if (lastLogMsg == null || helper.isPeersNotFoundError(lastLogMsg))
            {
              logger.warn(LocalizableMessage.raw("Throwing peer not found error.  " + "Last Log Msg: " + lastLogMsg));
              // Assume that this is a peer not found error.
              throw new PeerNotFoundException(errorMsg);
            }
            else
            {
              logger.error(LocalizableMessage.raw("Throwing ApplicationException."));
              throw ae;
            }
          }
          else if (displayProgress)
          {
            logger.info(LocalizableMessage.raw("Initialization completed successfully."));
            notifyListeners(getFormattedProgress(INFO_SUFFIX_INITIALIZED_SUCCESSFULLY.get()));
            notifyListeners(getLineBreak());
          }
        }
      }
      catch (EntryNotFoundException x)
      {
        isOver = true;
        logger.info(LocalizableMessage.raw("Initialization entry not found."));
        if (displayProgress)
        {
          notifyListeners(getFormattedProgress(INFO_SUFFIX_INITIALIZED_SUCCESSFULLY.get()));
          notifyListeners(getLineBreak());
        }
      }
      catch (LdapException e)
      {
        throw new ApplicationException(ReturnCode.APPLICATION_ERROR, getThrowableMsg(INFO_ERROR_POOLING_INITIALIZATION
            .get(sourceServerDisplay), e), e);
      }
    }
    resetGenerationId(conn, suffixDn, sourceServerDisplay);
  }

  private LocalizableMessage getLocalizedMessage(LocalizableMessage lastDisplayedMsg, long processed, long unprocessed)
  {
    if (processed != -1 && unprocessed != -1)
    {
      if (processed + unprocessed > 0)
      {
        long perc = (100 * processed) / (processed + unprocessed);
        return INFO_INITIALIZE_PROGRESS_WITH_PERCENTAGE.get(processed, perc);
      }
      else
      {
        // return INFO_NO_ENTRIES_TO_INITIALIZE.get();
        return null;
      }
    }
    else if (processed != -1)
    {
      return INFO_INITIALIZE_PROGRESS_WITH_PROCESSED.get(processed);
    }
    else if (unprocessed != -1)
    {
      return INFO_INITIALIZE_PROGRESS_WITH_UNPROCESSED.get(unprocessed);
    }
    else
    {
      return lastDisplayedMsg;
    }
  }

  /** Refresh period: to avoid having too many lines in the log */
  private long getMinRefreshPeriodInMillis(long totalEntries)
  {
    if (totalEntries < 100)
    {
      return 0;
    }
    else if (totalEntries < 1000)
    {
      return 1000;
    }
    else if (totalEntries < 10000)
    {
      return 5000;
    }
    else
    {
      return 10000;
    }
  }

  /**
   * Returns the configuration file path to be used when invoking the
   * command-lines.
   *
   * @return the configuration file path to be used when invoking the
   *         command-lines.
   */
  private String getConfigurationFile()
  {
    return getPath(getInstallation().getCurrentConfigurationFile());
  }

  private HostPort getLocalReplicationServer()
  {
    final UserData uData = getUserData();
    return new HostPort(uData.getHostName(), uData.getReplicationOptions().getReplicationPort());
  }

  private void resetGenerationId(ConnectionWrapper conn, DN suffixDn, HostPort sourceServerDisplay)
      throws ApplicationException
  {
    boolean taskCreated = false;
    int i = 1;
    boolean isOver = false;
    String dn = "";
    AddRequest addRequest = newAddRequest(dn)
        .addAttribute("objectclass", "top", "ds-task", "ds-task-reset-generation-id")
        .addAttribute("ds-task-class-name", "org.opends.server.tasks.SetGenerationIdTask")
        .addAttribute("ds-task-reset-generation-id-domain-base-dn", suffixDn.toString());
    while (!taskCreated)
    {
      checkAbort();
      String id = "quicksetup-reset-generation-id-" + i;
      dn = "ds-task-id=" + id + ",cn=Scheduled Tasks,cn=Tasks";
      addRequest
          .setName(dn)
          .replaceAttribute("ds-task-id", id);
      try
      {
        conn.getConnection().add(addRequest);

        taskCreated = true;
        logger.info(LocalizableMessage.raw("created task entry: " + addRequest));
      }
      catch (LdapException e)
      {
        if (e.getResult().getResultCode() != ResultCode.ENTRY_ALREADY_EXISTS)
        {
          logger.error(LocalizableMessage.raw("Error creating task " + addRequest, e));
          throw new ApplicationException(ReturnCode.APPLICATION_ERROR, getThrowableMsg(
              INFO_ERROR_LAUNCHING_INITIALIZATION.get(sourceServerDisplay), e), e);
        }
      }
      i++;
    }

    // Wait until it is over
    String lastLogMsg = null;
    while (!isOver)
    {
      StaticUtils.sleep(500);
      try
      {
        SearchRequest searchRequest =
            newSearchRequest(dn, BASE_OBJECT, "(objectclass=*)", "ds-task-log-message", "ds-task-state");
        SearchResultEntry sr = conn.getConnection().searchSingleEntry(searchRequest);

        String logMsg = firstValueAsString(sr, "ds-task-log-message");
        if (logMsg != null && !logMsg.equals(lastLogMsg))
        {
          logger.info(LocalizableMessage.raw(logMsg));
          lastLogMsg = logMsg;
        }

        String state = firstValueAsString(sr, "ds-task-state");
        TaskState taskState = TaskState.fromString(state);
        if (TaskState.isDone(taskState) || taskState == STOPPED_BY_ERROR)
        {
          isOver = true;
          LocalizableMessage errorMsg = lastLogMsg != null ?
              INFO_ERROR_DURING_INITIALIZATION_LOG.get(sourceServerDisplay, lastLogMsg, state, sourceServerDisplay)
            : INFO_ERROR_DURING_INITIALIZATION_NO_LOG.get(sourceServerDisplay, state, sourceServerDisplay);

          if (taskState == COMPLETED_WITH_ERRORS)
          {
            logger.warn(LocalizableMessage.raw("Completed with error: " + errorMsg));
            notifyListeners(getFormattedWarning(errorMsg));
          }
          else if (!TaskState.isSuccessful(taskState) || taskState == STOPPED_BY_ERROR)
          {
            logger.warn(LocalizableMessage.raw("Error: " + errorMsg));
            throw new ApplicationException(ReturnCode.APPLICATION_ERROR, errorMsg, null);
          }
        }
      }
      catch (EntryNotFoundException x)
      {
        isOver = true;
      }
      catch (LdapException e)
      {
        throw new ApplicationException(ReturnCode.APPLICATION_ERROR,
            getThrowableMsg(INFO_ERROR_POOLING_INITIALIZATION.get(sourceServerDisplay), e), e);
      }
    }
  }

  /**
   * Invokes a long operation in a separate thread and checks whether the user
   * canceled the operation or not.
   *
   * @param thread
   *          the Thread that must be launched.
   * @throws ApplicationException
   *           if there was an error executing the task or if the user canceled
   *           the installer.
   */
  private void invokeLongOperation(InvokeThread thread) throws ApplicationException
  {
    try
    {
      thread.start();
      while (!thread.isOver() && thread.isAlive())
      {
        if (canceled)
        {
          // Try to abort the thread
          try
          {
            thread.abort();
          }
          catch (Throwable t)
          {
            logger.warn(LocalizableMessage.raw("Error cancelling thread: " + t, t));
          }
        }
        else if (thread.getException() != null)
        {
          throw thread.getException();
        }
        else
        {
          StaticUtils.sleep(100);
        }
      }
      if (thread.getException() != null)
      {
        throw thread.getException();
      }
      if (canceled)
      {
        checkAbort();
      }
    }
    catch (ApplicationException e)
    {
      logger.error(LocalizableMessage.raw("Error: " + e, e));
      throw e;
    }
    catch (Throwable t)
    {
      logger.error(LocalizableMessage.raw("Error: " + t, t));
      throw new ApplicationException(ReturnCode.BUG, getThrowableMsg(INFO_BUG_MSG.get(), t), t);
    }
  }

  /**
   * Returns the host port representation of the server to be used in progress
   * and error messages. It takes into account the fact the host and port
   * provided by the user in the replication options panel. NOTE: the code
   * assumes that the user data with the contents of the replication options has
   * already been updated.
   *
   * @param server
   *          the ServerDescriptor.
   * @return the host port string representation of the provided server.
   */
  private HostPort getHostPort(ServerDescriptor server)
  {
    HostPort hostPort = null;

    for (PreferredConnection connection : getPreferredConnections())
    {
      HostPort hp = connection.getHostPort();
      if (hp.equals(server.getLdapHostPort()))
      {
        hostPort = server.getHostPort(false);
      }
      else if (hp.equals(server.getLdapsHostPort()))
      {
        hostPort = server.getHostPort(true);
      }
    }
    if (hostPort == null)
    {
      hostPort = server.getHostPort(true);
    }
    return hostPort;
  }

  @Override
  protected void applicationPrintStreamReceived(String message)
  {
    InstallerHelper helper = new InstallerHelper();
    String parsedMessage = helper.getImportProgressMessage(message);
    if (parsedMessage != null)
    {
      lastImportProgress = parsedMessage;
    }
  }

  /**
   * Returns the timeout to be used to connect in milliseconds.
   *
   * @return the timeout to be used to connect in milliseconds. Returns
   *         {@code 0} if there is no timeout.
   */
  private int getConnectTimeout()
  {
    return getUserData().getConnectTimeout();
  }

  /**
   * Copies the template instance files into the instance directory.
   *
   * @throws ApplicationException
   *           If an IO error occurred.
   */
  private void copyTemplateInstance() throws ApplicationException
  {
    FileManager fileManager = new FileManager();
    fileManager.synchronize(getInstallation().getTemplateDirectory(), getInstallation().getInstanceDirectory());
  }
}

/** Class used to be able to cancel long operations. */
abstract class InvokeThread extends Thread
{
  protected boolean isOver;
  protected ApplicationException ae;

  /**
   * Returns whether the thread is over.
   *
   * @return {@code true} if the thread is over and {@code false} otherwise.
   */
  public boolean isOver()
  {
    return isOver;
  }

  /**
   * Returns the exception that was encountered running the thread.
   *
   * @return the exception that was encountered running the thread.
   */
  public ApplicationException getException()
  {
    return ae;
  }

  @Override
  public abstract void run();

  /** Abort this thread. */
  public abstract void abort();
}
