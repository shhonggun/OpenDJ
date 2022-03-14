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
package org.opends.guitools.controlpanel.datamodel;

import static org.opends.messages.AdminToolMessages.*;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.server.config.meta.BackendIndexCfgDefn.IndexType;

/**
 * The table model for the indexes.  This is the table model used by the table
 * that appears on the right side of the Manage Index dialog when the user
 * clicks on the node "Index" and it gives a global view of the indexes
 * defined on a given backend.
 */
public class IndexTableModel extends AbstractIndexTableModel
{

  private static final long serialVersionUID = 6979651281772979301L;

  @Override
  protected String[] getColumnNames()
  {
    return new String[] {
        getHeader(INFO_CTRL_PANEL_INDEXES_HEADER_ATTRIBUTE.get(), 30),
        getHeader(INFO_CTRL_PANEL_INDEXES_HEADER_ENTRY_LIMIT.get(), 30),
        getHeader(INFO_CTRL_PANEL_INDEXES_HEADER_INDEX_TYPES.get(), 30),
        getHeader(INFO_CTRL_PANEL_INDEXES_HEADER_REQUIRES_REBUILD.get(), 30)
    };
  }

  /**
   * Comparable implementation.
   * @param index1 the first index descriptor to compare.
   * @param index2 the second index descriptor to compare.
   * @return 1 if according to the sorting options set by the user the first
   * index descriptor must be put before the second descriptor, 0 if they
   * are equivalent in terms of sorting and -1 if the second descriptor must
   * be put before the first descriptor.
   */
  @Override
  public int compare(AbstractIndexDescriptor index1,
      AbstractIndexDescriptor index2)
  {
    int result;
    IndexDescriptor i1 = (IndexDescriptor)index1;
    IndexDescriptor i2 = (IndexDescriptor)index2;

    int[] possibleResults = {compareNames(i1, i2), compareEntryLimits(i1, i2),
        compareTypes(i1, i2), compareRebuildRequired(i1, i2)};
    result = possibleResults[sortColumn];
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
    if (!sortAscending)
    {
      result = -result;
    }
    return result;
  }

  @Override
  protected String[] getLine(AbstractIndexDescriptor index)
  {
    IndexDescriptor i = (IndexDescriptor)index;
    return new String[] {
      i.getName(), getEntryLimitValue(i), getIndexTypeString(i),
      getRebuildRequiredString(i).toString()
    };
  }

  /**
   * Returns the String representing the entry limit value of the index.
   * @return the String representing the entry limit value of the index.
   */
  private String getEntryLimitValue(IndexDescriptor i)
  {
    if (i.getEntryLimit() >= 0)
    {
      return String.valueOf(i.getEntryLimit());
    }
    else
    {
      return INFO_NOT_APPLICABLE_LABEL.get().toString();
    }
  }

  // Comparison methods.

  private int compareNames(IndexDescriptor i1, IndexDescriptor i2)
  {
    return i1.getName().compareTo(i2.getName());
  }

  private int compareEntryLimits(IndexDescriptor i1, IndexDescriptor i2)
  {
    return getEntryLimitValue(i1).compareTo(getEntryLimitValue(i2));
  }

  private int compareTypes(IndexDescriptor i1, IndexDescriptor i2)
  {
    return getIndexTypeString(i1).compareTo(getIndexTypeString(i2));
  }

  /**
   * Returns the String representation of the index type for the index.
   * @param index the index.
   * @return the String representation of the index type for the index.
   */
  private String getIndexTypeString(IndexDescriptor index)
  {
    StringBuilder sb = new StringBuilder();
    for (IndexType type : index.getTypes())
    {
      if (sb.length() > 0)
      {
        sb.append(", ");
      }
      sb.append(getIndexName(type));
    }
    if (sb.length() == 0)
    {
      sb.append(INFO_NOT_APPLICABLE_LABEL.get());
    }
    return sb.toString();
  }

  private LocalizableMessage getIndexName(IndexType type)
  {
    switch (type)
    {
    case SUBSTRING:
      return INFO_CTRL_PANEL_INDEX_SUBSTRING.get();
    case ORDERING:
      return INFO_CTRL_PANEL_INDEX_ORDERING.get();
    case PRESENCE:
      return INFO_CTRL_PANEL_INDEX_PRESENCE.get();
    case EQUALITY:
      return INFO_CTRL_PANEL_INDEX_EQUALITY.get();
    case APPROXIMATE:
      return INFO_CTRL_PANEL_INDEX_APPROXIMATE.get();
    default:
      throw new RuntimeException("Unknown index type: "+type);
    }
  }
}
