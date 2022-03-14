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
 * Copyright 2009 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.guitools.controlpanel.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JLabel;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.responses.SearchResultEntry;
import org.opends.guitools.controlpanel.datamodel.BasicMonitoringAttributes;
import org.opends.guitools.controlpanel.datamodel.ServerDescriptor;
import org.opends.guitools.controlpanel.util.ConfigFromConnection;
import org.opends.guitools.controlpanel.util.Utilities;

import static org.opends.admin.ads.util.ConnectionUtils.*;
import static org.opends.guitools.controlpanel.datamodel.BasicMonitoringAttributes.*;
import static org.opends.messages.AdminToolMessages.*;
import static org.opends.messages.BackendMessages.*;

/** The panel displaying the root monitor panel. */
class RootMonitoringPanel extends GeneralMonitoringPanel
{
  private static final long serialVersionUID = 9031734563746269830L;

  private final JLabel openConnections = Utilities.createDefaultLabel();
  private final JLabel maxConnections = Utilities.createDefaultLabel();
  private final JLabel totalConnections = Utilities.createDefaultLabel();
  private final JLabel startTime = Utilities.createDefaultLabel();
  private final JLabel upTime = Utilities.createDefaultLabel();
  private final JLabel version = Utilities.createDefaultLabel();

  /** Default constructor. */
  public RootMonitoringPanel()
  {
    super();
    createLayout();
  }

  @Override
  public Component getPreferredFocusComponent()
  {
    return openConnections;
  }

  /** Creates the layout of the panel (but the contents are not populated here). */
  private void createLayout()
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridy ++;
    JLabel lTitle = Utilities.createTitleLabel(
        INFO_CTRL_PANEL_GENERAL_MONITORING_ROOT.get());
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridwidth = 2;
    gbc.gridy = 0;
    gbc.insets.top = 5;
    gbc.insets.bottom = 7;
    add(lTitle, gbc);

    gbc.insets.bottom = 0;
    gbc.insets.top = 10;
    LocalizableMessage[] labels = {
        INFO_CTRL_PANEL_OPEN_CONNECTIONS_LABEL.get(),
        INFO_CTRL_PANEL_MAX_CONNECTIONS_LABEL.get(),
        INFO_CTRL_PANEL_TOTAL_CONNECTIONS_LABEL.get(),
        INFO_CTRL_PANEL_START_TIME_LABEL.get(),
        INFO_CTRL_PANEL_UP_TIME_LABEL.get(),
        INFO_CTRL_PANEL_OPENDS_VERSION_LABEL.get()
    };
    JLabel[] values = {
        openConnections,
        maxConnections,
        totalConnections,
        startTime,
        upTime,
        version
        };
    gbc.gridy ++;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridwidth = 1;
    for (int i=0; i < labels.length; i++)
    {
      gbc.insets.left = 0;
      gbc.gridx = 0;
      JLabel l = Utilities.createPrimaryLabel(labels[i]);
      add(l, gbc);
      gbc.insets.left = 10;
      gbc.gridx = 1;
      add(values[i], gbc);
      gbc.gridy ++;
    }

    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy ++;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    add(Box.createGlue(), gbc);

    setBorder(PANEL_BORDER);
  }

  @Override
  public void updateContents()
  {
    ServerDescriptor server = null;
    if (getInfo() != null)
    {
      server = getInfo().getServerDescriptor();
    }
    SearchResultEntry sr = null;
    if (server != null)
    {
      sr = server.getRootMonitor();
    }
    if (sr != null)
    {
      JLabel[] ls =
      {
          openConnections,
          maxConnections,
          totalConnections,
          startTime
      };
      BasicMonitoringAttributes[] attrs =
      {
        BasicMonitoringAttributes.CURRENT_CONNECTIONS,
        BasicMonitoringAttributes.MAX_CONNECTIONS,
        BasicMonitoringAttributes.TOTAL_CONNECTIONS,
        BasicMonitoringAttributes.START_DATE
      };
      for (int i=0; i<ls.length; i++)
      {
        ls[i].setText(getMonitoringValue(attrs[i], sr));
      }
      version.setText(server.getOpenDSVersion());
      try
      {
        String start = firstValueAsString(sr, START_DATE.getAttributeName());
        String current = firstValueAsString(sr, CURRENT_DATE.getAttributeName());
        Date startTime = ConfigFromConnection.utcParser.parse(start);
        Date currentTime = ConfigFromConnection.utcParser.parse(current);

        long upSeconds = (currentTime.getTime() - startTime.getTime()) / 1000;
        long upDays = upSeconds / 86400;
        upSeconds %= 86400;
        long upHours = upSeconds / 3600;
        upSeconds %= 3600;
        long upMinutes = upSeconds / 60;
        upSeconds %= 60;
        LocalizableMessage upTimeStr =
          INFO_MONITOR_UPTIME.get(upDays, upHours, upMinutes, upSeconds);

        upTime.setText(upTimeStr.toString());
      }
      catch (Throwable t)
      {
        upTime.setText(NO_VALUE_SET.toString());
      }
    }
    else
    {
      openConnections.setText(NO_VALUE_SET.toString());
      maxConnections.setText(NO_VALUE_SET.toString());
      totalConnections.setText(NO_VALUE_SET.toString());
      startTime.setText(NO_VALUE_SET.toString());
      upTime.setText(NO_VALUE_SET.toString());
      version.setText(NO_VALUE_SET.toString());
    }
  }
}
