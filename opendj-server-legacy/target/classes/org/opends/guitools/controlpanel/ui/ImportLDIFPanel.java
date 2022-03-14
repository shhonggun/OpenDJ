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
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.guitools.controlpanel.ui;

import static com.forgerock.opendj.cli.Utils.OBFUSCATED_VALUE;

import static org.opends.messages.AdminToolMessages.*;
import static org.opends.messages.QuickSetupMessages.*;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.DN;
import org.opends.admin.ads.util.ConnectionWrapper;
import org.opends.guitools.controlpanel.datamodel.BackendDescriptor;
import org.opends.guitools.controlpanel.datamodel.BaseDNDescriptor;
import org.opends.guitools.controlpanel.datamodel.ControlPanelInfo;
import org.opends.guitools.controlpanel.datamodel.ServerDescriptor;
import org.opends.guitools.controlpanel.event.BrowseActionListener;
import org.opends.guitools.controlpanel.event.ConfigurationChangeEvent;
import org.opends.guitools.controlpanel.task.Task;
import org.opends.guitools.controlpanel.util.Utilities;
import org.opends.quicksetup.ui.UIFactory;
import org.opends.quicksetup.util.Utils;
import org.opends.server.tools.ImportLDIF;
import org.opends.server.tools.dsreplication.ReplicationCliArgumentParser;
import org.opends.server.tools.dsreplication.ReplicationCliException;
import org.opends.server.tools.dsreplication.ReplicationCliMain;

/** The panel where the user can import the contents of an LDIF file to the server. */
public class ImportLDIFPanel extends InclusionExclusionPanel
{
  private static final long serialVersionUID = 1143246529610229229L;
  private JComboBox<String> backends;
  private JTextField file;
  private JCheckBox dataCompressed;
  private JCheckBox rejectNotSchemaCompliant;
  private JCheckBox writeRejects;
  private JCheckBox writeSkips;
  private JTextField threads;
  private JTextField rejectsFile;
  private JTextField skipsFile;
  private JCheckBox overwriteRejectsFile;
  private JCheckBox overwriteSkipsFile;
  private JButton bBrowse;
  private JButton rejectsBrowse;
  private JButton skipsBrowse;

  private JLabel lBackend;
  private JLabel lNoBackendsFound;
  private JLabel lFile;
  private JLabel lSchemaValidation;
  private JLabel lDNValidation;
  private JLabel lThreads;
  private JLabel lRejectsFile;
  private JLabel lSkipsFile;
  private JLabel lRemoteFileHelp;
  private JLabel lRemoteRejectsHelp;
  private JLabel lRemoteSkipsHelp;

  private DocumentListener documentListener;

  /** Default constructor. */
  public ImportLDIFPanel()
  {
    super();
    createLayout();
  }

  @Override
  public LocalizableMessage getTitle()
  {
    return INFO_CTRL_PANEL_IMPORT_LDIF_TITLE.get();
  }

  @Override
  public Component getPreferredFocusComponent()
  {
    return file;
  }

  @Override
  public void toBeDisplayed(boolean visible)
  {
    if (visible)
    {
      documentListener.changedUpdate(null);
    }
  }

  /** Creates the layout of the panel (but the contents are not populated here). */
  private void createLayout()
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    addErrorPane(gbc);

    gbc.gridy ++;
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    lBackend = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_BACKEND_LABEL.get());
    add(lBackend, gbc);
    gbc.insets.left = 10;
    gbc.gridx = 1;
    backends = Utilities.createComboBox();
    backends.setModel(new DefaultComboBoxModel<>(new String[]{}));
    gbc.gridwidth = 2;
    add(backends, gbc);
    lNoBackendsFound = Utilities.createDefaultLabel(INFO_CTRL_PANEL_NO_BACKENDS_FOUND_LABEL.get());
    add(lNoBackendsFound, gbc);
    lNoBackendsFound.setVisible(false);
    gbc.insets.top = 10;
    lBackend.setLabelFor(backends);
    lNoBackendsFound.setLabelFor(lBackend);

    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.insets.left = 0;
    gbc.gridwidth = 1;
    lFile = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_FILE_TO_IMPORT_LABEL.get());
    add(lFile, gbc);

    gbc.gridx = 1;
    gbc.insets.left = 10;
    file = Utilities.createTextField();
    lFile.setLabelFor(file);
    documentListener = new DocumentListener()
    {
      @Override
      public void changedUpdate(DocumentEvent ev)
      {
        String text = file.getText().trim();
        setEnabledOK(text.length() > 0 && !errorPane.isVisible());
      }

      @Override
      public void removeUpdate(DocumentEvent ev)
      {
        changedUpdate(ev);
      }

      @Override
      public void insertUpdate(DocumentEvent ev)
      {
        changedUpdate(ev);
      }
    };
    file.getDocument().addDocumentListener(documentListener);
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(file, gbc);
    bBrowse = Utilities.createButton(INFO_CTRL_PANEL_BROWSE_BUTTON_LABEL.get());
    bBrowse.addActionListener(
        new BrowseActionListener(file, BrowseActionListener.BrowseType.OPEN_LDIF_FILE,  this));
    gbc.gridx = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.0;
    bBrowse.setOpaque(false);
    add(bBrowse, gbc);

    lRemoteFileHelp = Utilities.createInlineHelpLabel(INFO_CTRL_PANEL_REMOTE_SERVER_PATH.get());
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.insets.top = 3;
    gbc.insets.left = 10;
    gbc.gridy ++;
    add(lRemoteFileHelp, gbc);
    lRemoteFileHelp.setLabelFor(file);

    gbc.gridx = 1;
    gbc.gridy ++;
    gbc.insets.left = 30;
    gbc.insets.top = 5;
    gbc.gridwidth = 2;
    dataCompressed = Utilities.createCheckBox(INFO_CTRL_PANEL_DATA_IN_FILE_COMPRESSED.get());
    dataCompressed.setOpaque(false);
    add(dataCompressed, gbc);

    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.insets.left = 0;
    gbc.insets.top = 10;
    gbc.gridwidth = 1;
    lSchemaValidation = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_SCHEMA_VALIDATION_LABEL.get());
    add(lSchemaValidation, gbc);

    gbc.gridx = 1;
    rejectNotSchemaCompliant = Utilities.createCheckBox(INFO_CTRL_PANEL_REJECT_NOT_SCHEMA_COMPLIANT_LABEL.get());
    rejectNotSchemaCompliant.setSelected(true);
    gbc.insets.left = 10;
    add(rejectNotSchemaCompliant, gbc);
    lSchemaValidation.setLabelFor(rejectNotSchemaCompliant);

    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.insets.left = 0;
    lThreads = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_IMPORT_THREADS_LABEL.get());
    add(lThreads, gbc);

    gbc.gridx = 1;
    threads = Utilities.createShortTextField();
    gbc.gridwidth = 2;
    gbc.fill = GridBagConstraints.NONE;
    threads.setToolTipText(INFO_CTRL_PANEL_IMPORT_THREADS_TOOLTIP.get().toString());
    gbc.insets.left = 10;
    add(threads, gbc);
    lThreads.setLabelFor(threads);

    gbc.insets.top = 3;
    gbc.gridy ++;
    add(Utilities.createInlineHelpLabel(INFO_CTRL_PANEL_IMPORT_THREADS_HELP.get()), gbc);

    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.insets.left = 0;
    gbc.insets.top = 10;
    gbc.gridwidth = 1;
    lRejectsFile = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_REJECTS_FILE_LABEL.get());
    add(lRejectsFile, gbc);

    gbc.gridx = 1;
    writeRejects = Utilities.createCheckBox(INFO_CTRL_PANEL_WRITE_REJECTS_FILE_LABEL.get());
    writeRejects.setSelected(false);
    gbc.insets.left = 10;
    add(writeRejects, gbc);
    lRejectsFile.setLabelFor(writeRejects);

    gbc.gridx = 1;
    gbc.gridy++;
    gbc.insets.left = 30;
    gbc.insets.top = 5;
    rejectsFile = Utilities.createTextField();
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(rejectsFile, gbc);
    rejectsBrowse = Utilities.createButton(INFO_CTRL_PANEL_BROWSE_BUTTON_LABEL.get());
    rejectsBrowse.addActionListener(
        new BrowseActionListener(rejectsFile, BrowseActionListener.BrowseType.CREATE_GENERIC_FILE,  this));
    gbc.gridx = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.0;
    gbc.insets.left = 10;
    rejectsBrowse.setOpaque(false);
    add(rejectsBrowse, gbc);

    lRemoteRejectsHelp = Utilities.createInlineHelpLabel(INFO_CTRL_PANEL_REMOTE_SERVER_PATH.get());
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.insets.top = 3;
    gbc.insets.left = 10;
    gbc.gridy ++;
    add(lRemoteRejectsHelp, gbc);

    gbc.gridx = 1;
    gbc.gridy ++;
    gbc.insets.left = 30;
    gbc.gridwidth = 2;
    overwriteRejectsFile = Utilities.createCheckBox(INFO_CTRL_PANEL_OVERWRITE_REJECTS_FILE_LABEL.get());
    overwriteRejectsFile.setOpaque(false);
    add(overwriteRejectsFile, gbc);
    lRemoteRejectsHelp.setLabelFor(overwriteRejectsFile);

    ChangeListener changeListener = new ChangeListener()
    {
      @Override
      public void stateChanged(ChangeEvent ev)
      {
        rejectsFile.setEnabled(writeRejects.isSelected());
        rejectsBrowse.setEnabled(writeRejects.isSelected());
        overwriteRejectsFile.setEnabled(writeRejects.isSelected());
      }
    };
    writeRejects.addChangeListener(changeListener);
    writeRejects.setSelected(false);
    changeListener.stateChanged(null);

    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.insets.left = 0;
    gbc.insets.top = 10;
    gbc.gridwidth = 1;
    lSkipsFile = Utilities.createPrimaryLabel(INFO_CTRL_PANEL_SKIPS_FILE_LABEL.get());
    add(lSkipsFile, gbc);

    gbc.gridx = 1;
    writeSkips = Utilities.createCheckBox(INFO_CTRL_PANEL_WRITE_SKIPS_FILE_LABEL.get());
    writeSkips.setSelected(false);
    gbc.insets.left = 10;
    add(writeSkips, gbc);
    lSkipsFile.setLabelFor(writeSkips);

    gbc.gridx = 1;
    gbc.gridy++;
    gbc.insets.left = 30;
    gbc.insets.top = 5;
    skipsFile = Utilities.createTextField();
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(skipsFile, gbc);
    skipsBrowse = Utilities.createButton(INFO_CTRL_PANEL_BROWSE_BUTTON_LABEL.get());
    skipsBrowse.addActionListener(
        new BrowseActionListener(skipsFile, BrowseActionListener.BrowseType.CREATE_GENERIC_FILE,  this));
    gbc.gridx = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.0;
    gbc.insets.left = 10;
    skipsBrowse.setOpaque(false);
    add(skipsBrowse, gbc);

    lRemoteSkipsHelp = Utilities.createInlineHelpLabel(INFO_CTRL_PANEL_REMOTE_SERVER_PATH.get());
    gbc.gridx = 1;
    gbc.gridwidth = 2;
    gbc.insets.top = 3;
    gbc.insets.left = 10;
    gbc.gridy ++;
    add(lRemoteSkipsHelp, gbc);

    gbc.gridx = 1;
    gbc.gridy ++;
    gbc.insets.left = 30;
    gbc.gridwidth = 2;
    overwriteSkipsFile = Utilities.createCheckBox(INFO_CTRL_PANEL_OVERWRITE_SKIPS_FILE_LABEL.get());
    overwriteSkipsFile.setOpaque(false);
    add(overwriteSkipsFile, gbc);
    lRemoteSkipsHelp.setLabelFor(overwriteSkipsFile);

    changeListener = new ChangeListener()
    {
      @Override
      public void stateChanged(ChangeEvent ev)
      {
        skipsFile.setEnabled(writeSkips.isSelected());
        skipsBrowse.setEnabled(writeSkips.isSelected());
        overwriteSkipsFile.setEnabled(writeSkips.isSelected());
      }
    };
    writeSkips.addChangeListener(changeListener);
    writeSkips.setSelected(false);
    changeListener.stateChanged(null);

    changeListener = new ChangeListener()
    {
      @Override
      public void stateChanged(ChangeEvent ev)
      {
        if (ev.getSource() == overwriteSkipsFile)
        {
          overwriteRejectsFile.setSelected(overwriteSkipsFile.isSelected());
        }
        if (ev.getSource() == overwriteRejectsFile)
        {
          overwriteSkipsFile.setSelected(overwriteRejectsFile.isSelected());
        }
      }
    };
    overwriteRejectsFile.addChangeListener(changeListener);
    overwriteSkipsFile.addChangeListener(changeListener);

    gbc.insets.top = 10;
    gbc.insets.left = 0;
    gbc.gridy ++;
    gbc.gridx = 0;
    gbc.gridwidth = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(createDataExclusionOptions(new JLabel[]{}, new Component[]{}), gbc);
    gbc.gridy ++;
    gbc.insets.top = 15;
    add(createDataInclusionOptions(new JLabel[]{}, new Component[]{}), gbc);

    addBottomGlue(gbc);
  }

  @Override
  public void configurationChanged(ConfigurationChangeEvent ev)
  {
    ServerDescriptor desc = ev.getNewDescriptor();
    updateSimpleBackendComboBoxModel(backends, lNoBackendsFound, desc);
    updateErrorPaneAndOKButtonIfAuthRequired(desc,
      isLocal() ? INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_IMPORT.get() :
      INFO_CTRL_PANEL_CANNOT_CONNECT_TO_REMOTE_DETAILS.get(desc.getHostname()));
    SwingUtilities.invokeLater(new Runnable()
    {
      @Override
      public void run()
      {
        lRemoteFileHelp.setVisible(!isLocal());
        bBrowse.setVisible(isLocal());
        rejectsBrowse.setVisible(isLocal());
        skipsBrowse.setVisible(isLocal());
        lRemoteRejectsHelp.setVisible(!isLocal());
        lRemoteSkipsHelp.setVisible(!isLocal());
      }
    });
  }

  @Override
  protected void checkOKButtonEnable()
  {
    documentListener.changedUpdate(null);
  }

  @Override
  public void okClicked()
  {
    setPrimaryValid(lBackend);
    setPrimaryValid(lFile);
    setPrimaryValid(lRejectsFile);
    setPrimaryValid(lSkipsFile);
    setPrimaryValid(lThreads);
    final LinkedHashSet<LocalizableMessage> errors = new LinkedHashSet<>();

    String backendName = (String)backends.getSelectedItem();
    if (backendName == null)
    {
      errors.add(ERR_CTRL_PANEL_NO_BACKEND_SELECTED.get());
      setPrimaryInvalid(lBackend);
    }

    String ldifPath = file.getText();
    if (ldifPath == null || "".equals(ldifPath.trim()))
    {
      errors.add(INFO_NO_LDIF_PATH.get());
      setPrimaryInvalid(lFile);
    } else if (isLocal() && !Utils.fileExists(ldifPath))
    {
      errors.add(INFO_LDIF_FILE_DOES_NOT_EXIST.get());
      setPrimaryInvalid(lFile);
    }

    String sThread = threads.getText().trim();
    if (sThread.length() > 0)
    {
      try
      {
        int threads = Integer.parseInt(sThread);
        if (threads < 1)
        {
          errors.add(ERR_IMPORT_THREAD_NUMBER_INVALID.get());
          setPrimaryInvalid(lThreads);
        }
      }
      catch (Throwable t)
      {
        errors.add(ERR_IMPORT_THREAD_NUMBER_INVALID.get());
        setPrimaryInvalid(lThreads);
      }
    }

    if (writeRejects.isSelected())
    {
      String rejectPath = rejectsFile.getText();
      if (rejectPath == null || "".equals(rejectPath.trim()))
      {
        errors.add(ERR_CTRL_PANEL_REJECTS_FILE_REQUIRED.get());
        setPrimaryInvalid(lRejectsFile);
      }
      else if (writeSkips.isSelected() && new File(rejectPath).equals(new File(skipsFile.getText())))
      {
        errors.add(ERR_CTRL_PANEL_REJECTS_AND_SKIPS_MUST_BE_DIFFERENT.get());
        setPrimaryInvalid(lRejectsFile);
        setPrimaryInvalid(lSkipsFile);
      }
    }

    if (writeSkips.isSelected())
    {
      String skipPath = skipsFile.getText();
      if (skipPath == null || "".equals(skipPath.trim()))
      {
        errors.add(ERR_CTRL_PANEL_SKIPS_FILE_REQUIRED.get());
        setPrimaryInvalid(lSkipsFile);
      }
    }

    updateIncludeExclude(errors, backendName);

    if (errors.isEmpty())
    {
      ProgressDialog progressDialog = new ProgressDialog(
          Utilities.createFrame(),
          Utilities.getParentDialog(this), getTitle(), getInfo());
      ImportTask newTask = new ImportTask(getInfo(), progressDialog);
      for (Task task : getInfo().getTasks())
      {
        task.canLaunch(newTask, errors);
      }
      boolean initializeAll = false;
      if (errors.isEmpty())
      {
        Set<DN> replicatedBaseDNs = getReplicatedBaseDNs();
        boolean canInitialize = !replicatedBaseDNs.isEmpty() && isServerRunning();
        if (canInitialize)
        {
          ArrayList<String> dns = new ArrayList<>();
          for (DN dn : replicatedBaseDNs)
          {
            dns.add(dn.toString());
          }
          initializeAll = displayConfirmationDialog(
              INFO_CTRL_PANEL_CONFIRMATION_REQUIRED_SUMMARY.get(),
              INFO_CTRL_PANEL_CONFIRMATION_INITIALIZE_ALL_DETAILS.get(Utilities.getStringFromCollection(dns, "<br>")));
        }

        newTask.setInitializeAll(initializeAll);
        launchOperation(newTask,
            INFO_CTRL_PANEL_IMPORTING_LDIF_SUMMARY.get(backends.getSelectedItem()),
            INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_SUMMARY.get(),
            INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_DETAILS.get(),
            ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_SUMMARY.get(),
            null,
            ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_DETAILS,
            progressDialog);
        progressDialog.setVisible(true);
        Utilities.getParentDialog(this).setVisible(false);
      }
    }
    if (!errors.isEmpty())
    {
      displayErrorDialog(errors);
    }
  }

  @Override
  public void cancelClicked()
  {
    setPrimaryValid(lBackend);
    setPrimaryValid(lFile);
    setPrimaryValid(lSchemaValidation);
    setPrimaryValid(lDNValidation);
    setPrimaryValid(lThreads);
    setPrimaryValid(lRejectsFile);
    setPrimaryValid(lSkipsFile);
    super.cancelClicked();
  }

  private Set<DN> getReplicatedBaseDNs()
  {
    Set<DN> baseDNs = new TreeSet<>();
    String backendID = (String)backends.getSelectedItem();
    if (backendID != null)
    {
      for (BackendDescriptor backend :
        getInfo().getServerDescriptor().getBackends())
      {
        if (backendID.equalsIgnoreCase(backend.getBackendID()))
        {
          for (BaseDNDescriptor baseDN : backend.getBaseDns())
          {
            if (baseDN.getReplicaID() != -1)
            {
              baseDNs.add(baseDN.getDn());
            }
          }
        }
      }
    }
    return baseDNs;
  }

  /** The class that performs the import. */
  private class ImportTask extends InclusionExclusionTask
  {
    private Set<String> backendSet;
    private String fileName;
    private boolean initializeAll;
    private Set<DN> replicatedBaseDNs;

    /**
     * The constructor of the task.
     * @param info the control panel info.
     * @param dlg the progress dialog that shows the progress of the task.
     */
    private ImportTask(ControlPanelInfo info, ProgressDialog dlg)
    {
      super(info, dlg);
      backendSet = new HashSet<>();
      backendSet.add((String)backends.getSelectedItem());
      fileName = file.getText();
      replicatedBaseDNs = getReplicatedBaseDNs();
    }

    private void setInitializeAll(boolean initializeAll)
    {
      this.initializeAll = initializeAll;
    }

    @Override
    public Type getType()
    {
      return Type.IMPORT_LDIF;
    }

    @Override
    public LocalizableMessage getTaskDescription()
    {
      return INFO_CTRL_PANEL_IMPORT_TASK_DESCRIPTION.get(fileName, backendSet.iterator().next());
    }

    @Override
    public boolean canLaunch(Task taskToBeLaunched, Collection<LocalizableMessage> incompatibilityReasons)
    {
      boolean canLaunch = true;
      if (state == State.RUNNING && runningOnSameServer(taskToBeLaunched))
      {
        // All the operations are incompatible if they apply to this backend.
        Set<String> backends = new TreeSet<>(taskToBeLaunched.getBackends());
        backends.retainAll(getBackends());
        if (!backends.isEmpty())
        {
          incompatibilityReasons.add(getIncompatibilityMessage(this, taskToBeLaunched));
          canLaunch = false;
        }
      }
      return canLaunch;
    }

    @Override
    protected ArrayList<String> getCommandLineArguments()
    {
      ArrayList<String> args = new ArrayList<>();
      args.add("--ldifFile");
      args.add(fileName);
      args.add("--backendID");
      args.add((String)backends.getSelectedItem());
      if (dataCompressed.isSelected())
      {
        args.add("--isCompressed");
      }
      if (!rejectNotSchemaCompliant.isSelected())
      {
        args.add("--skipSchemaValidation");
      }

      String sThread = threads.getText().trim();
      if (sThread.length() > 0)
      {
        args.add("--threadCount");
        args.add(sThread);
      }

      if (writeRejects.isSelected())
      {
        args.add("--rejectFile");
        args.add(rejectsFile.getText());
      }

      if (writeSkips.isSelected())
      {
        args.add("--skipFile");
        args.add(skipsFile.getText());
      }

      if ((writeRejects.isSelected() || writeSkips.isSelected()) && overwriteRejectsFile.isSelected())
      {
        args.add("--overwrite");
      }

      args.addAll(super.getCommandLineArguments());

      if (isServerRunning())
      {
        args.addAll(getConfigCommandLineArguments());
      }

      args.add(getNoPropertiesFileArgument());

      return args;
    }

    @Override
    protected String getCommandLinePath()
    {
      return getCommandLinePath("import-ldif");
    }

    @Override
    public void runTask()
    {
      state = State.RUNNING;
      lastException = null;
      try
      {
        ArrayList<String> arguments = getCommandLineArguments();

        String[] args = new String[arguments.size()];

        arguments.toArray(args);
        if (isServerRunning())
        {
          returnCode = ImportLDIF.mainImportLDIF(args, false, outPrintStream, errorPrintStream);
          if (returnCode == 0 && initializeAll)
          {
            initializeAll();
          }
        }
        else
        {
          returnCode = executeCommandLine(getCommandLinePath(), args);
        }
        if (returnCode != 0)
        {
          state = State.FINISHED_WITH_ERROR;
        }
        else
        {
          for (String backend : getBackends())
          {
            getInfo().unregisterModifiedIndexesInBackend(backend);
          }
          state = State.FINISHED_SUCCESSFULLY;
        }
      }
      catch (Throwable t)
      {
        lastException = t;
        state = State.FINISHED_WITH_ERROR;
      }
      HashSet<BackendDescriptor> backends = new HashSet<>();
      for (BackendDescriptor backend : getInfo().getServerDescriptor().getBackends())
      {
        for (String backendID : getBackends())
        {
          if (backendID.equalsIgnoreCase(backend.getBackendID()))
          {
            backends.add(backend);
            break;
          }
        }
      }
      if (!backends.isEmpty())
      {
        getInfo().backendPopulated(backends);
      }
    }

    @Override
    public Set<String> getBackends()
    {
      return backendSet;
    }

    private void initializeAll() throws ReplicationCliException
    {
      ReplicationCliMain repl = new ReplicationCliMain(outPrintStream, errorPrintStream);
      getProgressDialog().appendProgressHtml(UIFactory.HTML_SEPARATOR+"<br><br>");

      String cmd = getCommandLineToInitializeAll();

      getProgressDialog().appendProgressHtml(Utilities.applyFont(
          INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_INITIALIZE_ALL.get()+ "<br><b>"+cmd+"</b><br><br>",
          ColorAndFontConstants.progressFont));

      ConnectionWrapper conn = getInfo().getConnection();
      for (DN baseDN : replicatedBaseDNs)
      {
        LocalizableMessage msg = INFO_PROGRESS_INITIALIZING_SUFFIX.get(baseDN, conn.getHostPort());
        getProgressDialog().appendProgressHtml(Utilities.applyFont(msg + "<br>", ColorAndFontConstants.progressFont));
        repl.initializeAllSuffix(baseDN, conn, true);
      }
    }

    private String getCommandLineToInitializeAll()
    {
      String cmdLineName = getCommandLinePath("dsreplication");
      ArrayList<String> args = new ArrayList<>();
      args.add(ReplicationCliArgumentParser.INITIALIZE_ALL_REPLICATION_SUBCMD_NAME);
      args.add("--hostName");
      args.add(getInfo().getServerDescriptor().getHostname());
      args.add("--port");
      args.add(String.valueOf(getInfo().getConnection().getHostPort().getPort()));
      for (DN baseDN : replicatedBaseDNs)
      {
        args.add("--baseDN");
        args.add(baseDN.toString());
      }
      args.add("--adminUID");
      args.add("admin");
      args.add("--adminPassword");
      args.add(OBFUSCATED_VALUE);
      args.add("--trustAll");
      args.add("--no-prompt");

      return Task.getEquivalentCommandLine(cmdLineName, args);
    }
  }
}
