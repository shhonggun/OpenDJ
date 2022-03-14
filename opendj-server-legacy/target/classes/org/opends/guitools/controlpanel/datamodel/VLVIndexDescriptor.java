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
 * Portions Copyright 2015-2016 ForgeRock AS.
 */

package org.opends.guitools.controlpanel.datamodel;

import java.util.Collections;
import java.util.List;

import org.forgerock.opendj.ldap.SearchScope;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.server.config.meta.BackendVLVIndexCfgDefn;

/**
 * The class used to describe the VLV index configuration.
 */
public class VLVIndexDescriptor extends AbstractIndexDescriptor
{
  private final DN baseDN;
  private final SearchScope scope;
  private final String filter;
  private List<VLVSortOrder> sortOrder = Collections.emptyList();
  private int hashCode;

  /**
   * Constructor for the VLVIndexDescriptor.
   *
   * @param name
   *          the name of the index.
   * @param backend
   *          the backend where the index is defined.
   * @param baseDN
   *          the baseDN of the search indexed by the VLV index.
   * @param scope
   *          the scope of the search indexed by the VLV index.
   * @param filter
   *          the filter or the search indexed by the VLV index.
   * @param sortOrder
   *          the sort order list of the VLV index.
   */
  public VLVIndexDescriptor(String name, BackendDescriptor backend, DN baseDN, SearchScope scope, String filter,
      List<VLVSortOrder> sortOrder)
  {
    super(name, backend);
    this.baseDN = baseDN;
    this.scope = scope;
    this.filter = filter;
    this.sortOrder = Collections.unmodifiableList(sortOrder);

    recalculateHashCode();
  }

  @Override
  public int compareTo(AbstractIndexDescriptor o)
  {
    return getName().toLowerCase().compareTo(o.getName().toLowerCase());
  }

  @Override
  public int hashCode()
  {
    return hashCode;
  }

  /**
   * Returns the baseDN of the search indexed by the VLV index.
   *
   * @return the baseDN of the search indexed by the VLV index.
   */
  public DN getBaseDN()
  {
    return baseDN;
  }

  /**
   * Returns the filter of the search indexed by the VLV index.
   *
   * @return the filter of the search indexed by the VLV index.
   */
  public String getFilter()
  {
    return filter;
  }

  /**
   * Returns the scope of the search indexed by the VLV index.
   *
   * @return the scope of the search indexed by the VLV index.
   */
  public SearchScope getScope()
  {
    return scope;
  }

  /**
   * Returns the sort order list of the VLV index.
   *
   * @return the sort order list of the VLV index.
   */
  public List<VLVSortOrder> getSortOrder()
  {
    return sortOrder;
  }

  @Override
  public boolean equals(Object o)
  {
    if (o == this)
    {
      return true;
    }
    if (!(o instanceof VLVIndexDescriptor))
    {
      return false;
    }

    final VLVIndexDescriptor index = (VLVIndexDescriptor) o;
    return index.getName().equalsIgnoreCase(getName())
        && index.getBaseDN().equals(getBaseDN())
        && index.getFilter().equals(getFilter())
        && index.getScope() == getScope()
        && index.getSortOrder().equals(getSortOrder())
        && backendIdEqual(index);
  }

  private boolean backendIdEqual(VLVIndexDescriptor index)
  {
    return getBackend() != null
        && index.getBackend() != null
        // Only compare the backend IDs.  In this context is better to
        // do this since the backend object contains some state (like
        // number entries) that can change.
        && getBackend().getBackendID().equals(index.getBackend().getBackendID());
  }

  @Override
  protected void recalculateHashCode()
  {
    final StringBuilder sb = new StringBuilder();
    for (final VLVSortOrder s : sortOrder)
    {
      sb.append(s.getAttributeName()).append(s.isAscending()).append(",");
    }
    if (getBackend() != null)
    {
      sb.append(getBackend().getBackendID());
    }
    hashCode = (getName()+baseDN+scope+filter+sb).hashCode();
  }

  /**
   * Returns the equivalent {@code BackendVLVIndexCfgDefn.Scope} to the provided
   * search scope.
   *
   * @param scope
   *          The {@code SearchScope} to convert.
   * @return the equivalent {@code BackendVLVIndexCfgDefn.Scope} to the provided
   *         search scope.
   */
  public static BackendVLVIndexCfgDefn.Scope getBackendVLVIndexScope(final SearchScope scope)
  {
    switch (scope.asEnum())
    {
    case BASE_OBJECT:
      return BackendVLVIndexCfgDefn.Scope.BASE_OBJECT;
    case SINGLE_LEVEL:
      return BackendVLVIndexCfgDefn.Scope.SINGLE_LEVEL;
    case SUBORDINATES:
      return BackendVLVIndexCfgDefn.Scope.SUBORDINATE_SUBTREE;
    case WHOLE_SUBTREE:
      return BackendVLVIndexCfgDefn.Scope.WHOLE_SUBTREE;
    case UNKNOWN:
    default:
      throw new IllegalArgumentException("Unsupported SearchScope: " + scope);
    }
  }

  /**
   * Convert the provided {@code BackendVLVIndexCfgDefn.Scope} to
   * {@code SearchScope}.
   *
   * @param scope
   *          The scope to convert.
   * @return the provided {@code BackendVLVIndexCfgDefn.Scope} to
   *         {@code SearchScope}
   */
  public static SearchScope toSearchScope(final BackendVLVIndexCfgDefn.Scope scope)
  {
    switch (scope)
    {
    case BASE_OBJECT:
      return SearchScope.BASE_OBJECT;
    case SINGLE_LEVEL:
      return SearchScope.SINGLE_LEVEL;
    case SUBORDINATE_SUBTREE:
      return SearchScope.SUBORDINATES;
    case WHOLE_SUBTREE:
      return SearchScope.WHOLE_SUBTREE;
    default:
      throw new IllegalArgumentException("Unsupported BackendVLVIndexCfgDefn.Scope: " + scope);
    }
  }
}
