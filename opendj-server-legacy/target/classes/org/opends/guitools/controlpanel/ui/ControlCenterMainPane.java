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
 * Copyright 2008-2009 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */

package org.opends.guitools.controlpanel.ui;

import static org.opends.messages.AdminToolMessages.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.DN;
import org.opends.guitools.controlpanel.datamodel.ControlPanelInfo;
import org.opends.guitools.controlpanel.datamodel.ServerDescriptor;
import org.opends.guitools.controlpanel.event.ConfigChangeListener;
import org.opends.guitools.controlpanel.event.ConfigurationChangeEvent;
import org.opends.guitools.controlpanel.util.Utilities;

/**
 * The main panel of the control panel.  It contains a split pane.  On the left
 * we have some actions and on the right some global information about the
 * server.
 */
public class ControlCenterMainPane extends JPanel
{
  private static final long serialVersionUID = -8939025523701408656L;
  private StatusPanel statusPane;
  private JLabel lAuthenticatedAs =
    Utilities.createInlineHelpLabel(LocalizableMessage.EMPTY);

  /**
   * Constructor.
   * @param info the control panel info.
   */
  public ControlCenterMainPane(ControlPanelInfo info)
  {
    super(new GridBagLayout());
    setOpaque(true); //content panes must be opaque
    JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    split.setOpaque(true); //content panes must be opaque

    statusPane = new StatusPanel();
    statusPane.setInfo(info);

    MainActionsPane mainActionsPane = new MainActionsPane();
    mainActionsPane.setInfo(info);
    JScrollPane accordionScroll = Utilities.createScrollPane(mainActionsPane);
    accordionScroll.getViewport().setBackground(
        ColorAndFontConstants.greyBackground);

//  Create a split pane with the two scroll panes in it.
    split.setLeftComponent(accordionScroll);

    split.setRightComponent(statusPane);
    split.setResizeWeight(0.0);

    split.setDividerLocation(accordionScroll.getPreferredSize().width + 2);

    split.setPreferredSize(
        new Dimension(split.getPreferredSize().width + 4,
            split.getPreferredSize().height));
    info.addConfigChangeListener(new ConfigChangeListener()
    {
      private boolean lastStatusStopped;
      @Override
      public void configurationChanged(final ConfigurationChangeEvent ev)
      {
        final boolean displayLogin;
        if (ev.getNewDescriptor().getStatus() !=
          ServerDescriptor.ServerStatus.STARTED)
        {
          lastStatusStopped = true;
          displayLogin = false;
        }
        else if (lastStatusStopped && !ev.getNewDescriptor().isAuthenticated())
        {
          lastStatusStopped = false;
          displayLogin = true;
        }
        else
        {
          displayLogin = false;
        }
        SwingUtilities.invokeLater(new Runnable()
        {
          @Override
          public void run()
          {
            updateAuthenticationLabel(ev.getNewDescriptor());
            if (displayLogin)
            {
              getLoginDialog().setVisible(true);
              getLoginDialog().toFront();
            }
          }
        });
      }
    });

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    add(split, gbc);

    JPanel infoPanel = new JPanel(new GridBagLayout());
    gbc.gridy = 1;
    gbc.weighty = 0.0;
    add(infoPanel, gbc);

    infoPanel.setOpaque(false);
    infoPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
        ColorAndFontConstants.defaultBorderColor));
    gbc.weightx = 0.0;
    gbc.weighty = 0.0;
    gbc.insets = new Insets(5, 5, 5, 5);
    infoPanel.add(lAuthenticatedAs, gbc);
    gbc.gridx = 1;
    gbc.weightx = 1.0;
    gbc.insets.left = 0;
    gbc.insets.right = 0;
    lAuthenticatedAs.setText("Qjlabel");
    infoPanel.add(
        Box.createVerticalStrut(lAuthenticatedAs.getPreferredSize().height),
        gbc);
    if (info.getServerDescriptor() != null)
    {
      updateAuthenticationLabel(info.getServerDescriptor());
    }
    else
    {
      lAuthenticatedAs.setText("");
    }
  }

  /**
   * Returns the login dialog used to ask authentication to the user.
   * @return the login dialog used to ask authentication to the user.
   */
  private GenericDialog getLoginDialog()
  {
    return statusPane.getLoginDialog();
  }

  private void updateAuthenticationLabel(ServerDescriptor server)
  {
    if (server.getStatus() ==
      ServerDescriptor.ServerStatus.STARTED)
    {
      if (server.isAuthenticated())
      {
        try
        {
          DN bindDN = statusPane.getInfo().getConnection().getBindDn();
          lAuthenticatedAs.setText(
             INFO_CTRL_PANEL_AUTHENTICATED_AS.get(bindDN).toString());
        }
        catch (Throwable t)
        {
        }
      }
      else
      {
        lAuthenticatedAs.setText(
            INFO_CTRL_PANEL_NOT_AUTHENTICATED.get().toString());
      }
    }
    else if (server.isLocal())
    {
      lAuthenticatedAs.setText(
         INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_NOT_RUNNING.get().toString());
    }
    else
    {
      lAuthenticatedAs.setText(
          INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_REMOTE.get(
              server.getHostname()).toString());
    }
  }

  private static GenericDialog localOrRemoteDlg;
  private static GenericDialog loginDlg;

  /**
   * Returns the dialog that is in charge of asking the user the server
   * to be administer.  This method will return always the same dialog.  The
   * dialog will do all the logic of updating the ControlPanelInfo object.
   * @param info the control panel information object.
   * @return the dialog that is in charge of asking the user the server
   * to be administer.
   */
  public static GenericDialog getLocalOrRemoteDialog(ControlPanelInfo info)
  {
    if (localOrRemoteDlg == null)
    {
      LocalOrRemotePanel localOrRemotePanel = new LocalOrRemotePanel();
      localOrRemotePanel.setInfo(info);
      localOrRemoteDlg = new GenericDialog(Utilities.createFrame(),
          localOrRemotePanel);
      localOrRemoteDlg.setModal(true);
      localOrRemoteDlg.pack();
    }
    return localOrRemoteDlg;
  }

  /**
   * Returns the dialog that is in charge of asking the user the authentication
   * for the local server.  This method will return always the same dialog.
   * @param info the control panel information object.  The
   * dialog will do all the logic of updating the ControlPanelInfo object.
   * @return the dialog that is in charge of asking the user the authentication
   * for the local server.
   */
  public static GenericDialog getLocalServerLoginDialog(ControlPanelInfo info)
  {
    if (loginDlg == null)
    {
      LoginPanel loginPanel = new LoginPanel();
      loginDlg = new GenericDialog(Utilities.createFrame(), loginPanel);
      loginPanel.setInfo(info);
      loginDlg.setModal(true);
    }
    return loginDlg;
  }
}
