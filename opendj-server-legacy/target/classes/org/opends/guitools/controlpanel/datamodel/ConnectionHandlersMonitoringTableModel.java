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
package org.opends.guitools.controlpanel.datamodel;

import static org.opends.admin.ads.util.ConnectionUtils.*;
import static org.opends.messages.AdminToolMessages.*;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.responses.SearchResultEntry;
import org.opends.guitools.controlpanel.datamodel.ConnectionHandlerDescriptor.Protocol;

/** The table model used to display the monitoring information of connection handlers. */
public class ConnectionHandlersMonitoringTableModel extends
MonitoringTableModel<ConnectionHandlerDescriptor,
AddressConnectionHandlerDescriptor>
{
  private static final long serialVersionUID = -8891998773191495L;

  @Override
  protected Set<AddressConnectionHandlerDescriptor> convertToInternalData(
      Set<ConnectionHandlerDescriptor> newData)
  {
    Set<AddressConnectionHandlerDescriptor> newAddresses = new HashSet<>();
    for (ConnectionHandlerDescriptor ch : newData)
    {
      if (ch.getAddresses().isEmpty())
      {
        newAddresses.add(new AddressConnectionHandlerDescriptor(ch, null,
            getMonitoringEntry(null, ch)));
      }
      else
      {
        for (InetAddress address : ch.getAddresses())
        {
          newAddresses.add(new AddressConnectionHandlerDescriptor(ch, address,
              getMonitoringEntry(address, ch)));
        }
      }
    }
    return newAddresses;
  }

  @Override
  public int compare(AddressConnectionHandlerDescriptor desc1,
      AddressConnectionHandlerDescriptor desc2)
  {
    ArrayList<Integer> possibleResults = new ArrayList<>();

    possibleResults.add(compareNames(desc1, desc2));
    possibleResults.addAll(getMonitoringPossibleResults(
        desc1.getMonitoringEntry(), desc2.getMonitoringEntry()));

    int result = possibleResults.get(getSortColumn());
    if (result == 0)
    {
      for (int i : possibleResults)
      {
        if (i != 0)
        {
          result = i;
          break;
        }
      }
    }
    if (!isSortAscending())
    {
      result = -result;
    }
    return result;
  }

  private int compareNames(AddressConnectionHandlerDescriptor ach1,
      AddressConnectionHandlerDescriptor ach2)
  {
    if (Objects.equals(ach1.getAddress(), ach2.getAddress()))
    {
      Integer port1 = Integer.valueOf(ach1.getConnectionHandler().getPort());
      Integer port2 = Integer.valueOf(ach2.getConnectionHandler().getPort());
      return port1.compareTo(port2);
    }
    return getName(ach1).compareTo(getName(ach2));
  }

  @Override
  protected SearchResultEntry getMonitoringEntry(
      AddressConnectionHandlerDescriptor ach)
  {
    return ach.getMonitoringEntry();
  }

  @Override
  protected String getName(AddressConnectionHandlerDescriptor ach)
  {
    StringBuilder sb = new StringBuilder();
    ConnectionHandlerDescriptor ch = ach.getConnectionHandler();
    if (ch.getProtocol() == Protocol.ADMINISTRATION_CONNECTOR)
    {
      sb.append(INFO_CTRL_PANEL_ADMINISTRATION_CONNECTOR_NAME.get(ch.getPort()));
    }
    else
    {
      if (ach.getAddress() != null)
      {
        sb.append(ach.getAddress().getHostAddress()).append(":").append(ch.getPort());
      }
      else
      {
        sb.append(ch.getPort());
      }
      sb.append(" - ");
      switch (ch.getProtocol())
      {
      case OTHER:
        sb.append(ch.getName());
        break;
      default:
        sb.append(ch.getProtocol().getDisplayMessage());
      break;
      }
    }
    return sb.toString();
  }

  private SearchResultEntry getMonitoringEntry(InetAddress address, ConnectionHandlerDescriptor cch)
  {
    for (SearchResultEntry sr : cch.getMonitoringEntries())
    {
      String cn = firstValueAsString(sr, "cn");
      if (cn != null)
      {
        if (address == null)
        {
          return sr;
        }
        if (cn.endsWith(" " + address.getHostAddress() + " port " + cch.getPort() + " Statistics"))
        {
          return sr;
        }
      }
    }
    return null;
  }

  @Override
  protected LocalizableMessage getNameHeader()
  {
    return INFO_CTRL_PANEL_CONNECTION_HANDLER_HEADER.get();
  }
}

/**
 * The table model has one line per address, this object represents that
 * address and all the associated monitoring information.
 */
class AddressConnectionHandlerDescriptor
{
  private final ConnectionHandlerDescriptor ch;
  private final InetAddress address;
  private final SearchResultEntry monitoringEntry;
  private final int hashCode;

  /**
   * Constructor of this data structure.
   * @param ch the connection handler descriptor.
   * @param address the address.
   * @param monitoringEntry the monitoringEntry.
   */
  public AddressConnectionHandlerDescriptor(
      ConnectionHandlerDescriptor ch,
      InetAddress address,
      SearchResultEntry monitoringEntry)
  {
    this.ch = ch;
    this.address = address;
    this.monitoringEntry = monitoringEntry;

    if (address != null)
    {
      hashCode = ch.hashCode() + address.hashCode();
    }
    else
    {
      hashCode = ch.hashCode();
    }
  }

  /**
   * Returns the address.
   * @return the address.
   */
  public InetAddress getAddress()
  {
    return address;
  }

  /**
   * Returns the connection handler descriptor.
   * @return the connection handler descriptor.
   */
  public ConnectionHandlerDescriptor getConnectionHandler()
  {
    return ch;
  }

  /**
   * Returns the monitoring entry.
   * @return the monitoring entry.
   */
  public SearchResultEntry getMonitoringEntry()
  {
    return monitoringEntry;
  }

  @Override
  public int hashCode()
  {
    return hashCode;
  }

  @Override
  public boolean equals(Object o)
  {
    if (o != this)
    {
      return true;
    }
    if (!(o instanceof AddressConnectionHandlerDescriptor))
    {
      return false;
    }
    AddressConnectionHandlerDescriptor ach = (AddressConnectionHandlerDescriptor) o;
    return Objects.equals(getAddress(), ach.getAddress())
        && ach.getConnectionHandler().equals(getConnectionHandler());
  }
}
