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
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.guitools.controlpanel.ui;

import static org.opends.messages.AdminToolMessages.*;
import static org.opends.server.util.CollectionUtils.*;
import static org.opends.server.util.ServerConstants.*;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.tree.TreePath;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.AVA;
import org.forgerock.opendj.ldap.Attribute;
import org.forgerock.opendj.ldap.AttributeDescription;
import org.forgerock.opendj.ldap.Base64;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldap.LinkedAttribute;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.ObjectClass;
import org.forgerock.opendj.ldap.schema.ObjectClassType;
import org.opends.guitools.controlpanel.datamodel.BinaryValue;
import org.opends.guitools.controlpanel.datamodel.ObjectClassValue;
import org.opends.guitools.controlpanel.event.ConfigurationChangeEvent;
import org.opends.guitools.controlpanel.event.LDAPEntryChangedEvent;
import org.opends.guitools.controlpanel.event.LDAPEntryChangedListener;
import org.opends.guitools.controlpanel.ui.nodes.BasicNode;
import org.opends.guitools.controlpanel.util.Utilities;
import org.opends.server.schema.SchemaConstants;
import org.opends.server.types.OpenDsException;
import org.forgerock.opendj.ldap.schema.Schema;

/**
 * Abstract class containing code shared by the different LDAP entry view
 * panels (Simplified View, Attribute View and LDIF View).
 */
public abstract class ViewEntryPanel extends StatusGenericPanel
{
  private static final long serialVersionUID = -1908757626234678L;
  /** The read-only attributes as they appear on the schema. */
  protected SortedSet<String> schemaReadOnlyAttributes = new TreeSet<>();
  /** The read-only attributes in lower case. */
  protected SortedSet<String> schemaReadOnlyAttributesLowerCase = new TreeSet<>();
  /** The editable operational attributes. */
  protected SortedSet<String> editableOperationalAttrNames = new TreeSet<>();
  private JLabel title= Utilities.createDefaultLabel();

  private Set<LDAPEntryChangedListener> listeners = new LinkedHashSet<>();

  /** Whether the entry change events should be ignored or not. */
  protected boolean ignoreEntryChangeEvents;

  /** Static boolean used to know whether only attributes with values should be displayed or not. */
  protected static boolean displayOnlyWithAttrs = true;

  @Override
  public void okClicked()
  {
    // No ok button
  }

  /**
   * Returns an Entry object representing what the panel is displaying.
   * @return an Entry object representing what the panel is displaying.
   * @throws OpenDsException if the entry cannot be generated (in particular if
   * the user provided invalid data).
   */
  public abstract Entry getEntry() throws OpenDsException;

  /**
   * Updates the contents of the panel.
   * @param sr the search result to be used to update the panel.
   * @param isReadOnly whether the entry is read-only or not.
   * @param path the tree path associated with the entry in the tree.
   */
  public abstract void update(Entry sr, boolean isReadOnly, TreePath path);

  /**
   * Adds a title panel to the container.
   * @param c the container where the title panel must be added.
   * @param gbc the grid bag constraints to be used.
   */
  protected void addTitlePanel(Container c, GridBagConstraints gbc)
  {
    c.add(title, gbc);
  }

  /**
   * Whether the schema must be checked or not.
   * @return <CODE>true</CODE> if the server is configured to check schema and
   * <CODE>false</CODE> otherwise.
   */
  protected boolean checkSchema()
  {
    return getInfo().getServerDescriptor().isSchemaEnabled();
  }

  /**
   * Adds an LDAP entry change listener.
   * @param listener the listener.
   */
  public void addLDAPEntryChangedListener(LDAPEntryChangedListener listener)
  {
    listeners.add(listener);
  }

  /**
   * Removes an LDAP entry change listener.
   * @param listener the listener.
   */
  public void removeLDAPEntryChangedListener(LDAPEntryChangedListener listener)
  {
    listeners.remove(listener);
  }

  @Override
  public boolean requiresBorder()
  {
    return true;
  }

  /**
   * Returns the DN of the entry that the user is editing (it might differ
   * from the DN of the entry in the tree if the user modified the DN).
   * @return the DN of the entry that the user is editing.
   */
  protected abstract String getDisplayedDN();

  /** Notifies the entry changed listeners that the entry changed. */
  protected void notifyListeners()
  {
    if (ignoreEntryChangeEvents)
    {
      return;
    }
    // TODO: With big entries this is pretty slow.  Until there is a fix, try
    // simply to update the dn
    String dn = getDisplayedDN();
    if (dn != null && !dn.equals(title.getText()))
    {
      title.setText(dn);
    }
    LDAPEntryChangedEvent ev = new LDAPEntryChangedEvent(this, null);
    for (LDAPEntryChangedListener listener : listeners)
    {
      listener.entryChanged(ev);
    }
  }

  /**
   * Updates the title panel with the provided entry.
   * @param sr the search result.
   * @param path the path to the node of the entry selected in the tree.  Used
   * to display the same icon as in the tree.
   */
  protected void updateTitle(Entry sr, TreePath path)
  {
    final DN dn = sr.getName();
    if (dn != null && dn.size() > 0)
    {
      title.setText(dn.toString());
    }
    else if (path != null)
    {
      BasicNode node = (BasicNode)path.getLastPathComponent();
      title.setText(node.getDisplayName());
    }

    if (path != null)
    {
      BasicNode node = (BasicNode)path.getLastPathComponent();
      title.setIcon(node.getIcon());
    }
    else
    {
      title.setIcon(null);
    }

    Attribute ocs = sr.getAttribute(OBJECTCLASS_ATTRIBUTE_TYPE_NAME);
    Schema schema = getInfo().getServerDescriptor().getSchema();
    if (!ocs.isEmpty() && schema != null)
    {
      ObjectClassValue ocDesc = getObjectClassDescriptor(ocs, schema);
      StringBuilder sb = new StringBuilder();
      sb.append("<html>");
      if (ocDesc.getStructural() != null)
      {
        sb.append(INFO_CTRL_OBJECTCLASS_DESCRIPTOR.get(ocDesc.getStructural()));
      }
      if (!ocDesc.getAuxiliary().isEmpty())
      {
        if (sb.length() > 0)
        {
          sb.append("<br>");
        }
        sb.append(INFO_CTRL_AUXILIARY_OBJECTCLASS_DESCRIPTOR.get(
            Utilities.getStringFromCollection(ocDesc.getAuxiliary(), ", ")));
      }
      title.setToolTipText(sb.toString());
    }
    else
    {
      title.setToolTipText(null);
    }
  }

  /**
   * Returns an object class value representing all the object class values of
   * the entry.
   * @param ocAttr the list of object class values.
   * @param schema the schema.
   * @return an object class value representing all the object class values of
   * the entry.
   */
  protected ObjectClassValue getObjectClassDescriptor(Iterable<ByteString> ocAttr, Schema schema)
  {
    ObjectClass structuralObjectClass = null;
    SortedSet<String> auxiliaryClasses = new TreeSet<>();
    for (ByteString oc : ocAttr)
    {
      ObjectClass objectClass = schema.getObjectClass(oc.toString());
      if (!objectClass.isPlaceHolder())
      {
        if (objectClass.getObjectClassType() == ObjectClassType.STRUCTURAL)
        {
          if (structuralObjectClass == null || objectClass.isDescendantOf(structuralObjectClass))
          {
            structuralObjectClass = objectClass;
          }
        }
        else
        {
          String name = objectClass.getNameOrOID();
          if (!SchemaConstants.TOP_OBJECTCLASS_NAME.equals(name))
          {
            auxiliaryClasses.add(objectClass.getNameOrOID());
          }
        }
      }
    }
    String structural = structuralObjectClass != null ? structuralObjectClass.getNameOrOID() : null;
    return new ObjectClassValue(structural, auxiliaryClasses);
  }

  /**
   * Adds the values in the RDN to the entry definition.
   * @param entry the entry to be updated.
   */
  protected void addValuesInRDN(Entry entry)
  {
    // Add the values in the RDN if they are not there
    for (AVA ava : entry.getName().rdn())
    {
      String attrName = ava.getAttributeName();
      ByteString value = ava.getAttributeValue();
      boolean done = false;
      for (Attribute attr : entry.getAllAttributes(attrName))
      {
        // TODO JNR use Entry.getAttribute(AttributeDescription) instead?
        if (attr.getAttributeDescription().toString().equals(attrName))
        {
          List<ByteString> newValues = getValues(attr);
          newValues.add(value);
          entry.addAttribute(attr, newValues);
          done = true;
          break;
        }
      }
      if (!done)
      {
        AttributeDescription attrDesc = AttributeDescription.create(ava.getAttributeType());
        entry.addAttribute(new LinkedAttribute(attrDesc, value), newArrayList(value));
      }
    }
  }

  private List<ByteString> getValues(Attribute attr)
  {
    List<ByteString> newValues = new ArrayList<>();
    Iterator<ByteString> it = attr.iterator();
    while (it.hasNext())
    {
      newValues.add(it.next());
    }
    return newValues;
  }

  @Override
  public LocalizableMessage getTitle()
  {
    return INFO_CTRL_PANEL_EDIT_LDAP_ENTRY_TITLE.get();
  }

  @Override
  public void configurationChanged(ConfigurationChangeEvent ev)
  {
    Schema schema = ev.getNewDescriptor().getSchema();
    if (schema != null && schemaReadOnlyAttributes.isEmpty())
    {
      schemaReadOnlyAttributes.clear();
      schemaReadOnlyAttributesLowerCase.clear();
      for (AttributeType attr : schema.getAttributeTypes())
      {
        if (attr.isNoUserModification())
        {
          String attrName = attr.getNameOrOID();
          schemaReadOnlyAttributes.add(attrName);
          schemaReadOnlyAttributesLowerCase.add(attrName.toLowerCase());
        }
        else if (attr.isOperational())
        {
          editableOperationalAttrNames.add(attr.getNameOrOID());
        }
      }
    }
  }

  /**
   * Appends the LDIF line corresponding to the value of an
   * attribute to the provided StringBuilder.
   * @param sb the StringBuilder that must be updated.
   * @param attrName the attribute name.
   * @param value the attribute value.
   */
  protected void appendLDIFLine(StringBuilder sb, String attrName, Object value)
  {
    if (value instanceof ObjectClassValue)
    {
      ObjectClassValue ocValue = (ObjectClassValue)value;
      if (ocValue.getStructural() != null)
      {
        appendPlain(sb, attrName, ocValue.getStructural());

        Schema schema = getInfo().getServerDescriptor().getSchema();
        if (schema != null)
        {
          ObjectClass oc = schema.getObjectClass(ocValue.getStructural());
          if (!oc.isPlaceHolder())
          {
            for (String name : getObjectClassSuperiorValues(oc))
            {
              appendPlain(sb, attrName, name);
            }
          }
        }
      }
      for (String v : ocValue.getAuxiliary())
      {
        appendPlain(sb, attrName, v);
      }
    }
    else if (value instanceof ByteString)
    {
      ByteString v = (ByteString) value;
      if (v.length() > 0)
      {
        appendBase64(sb, attrName, v.toBase64String());
      }
    }
    else if (value instanceof byte[])
    {
      if (((byte[])value).length > 0)
      {
        appendBase64(sb, attrName, Base64.encode((byte[]) value));
      }
    }
    else if (value instanceof BinaryValue)
    {
      appendBase64(sb, attrName, ((BinaryValue) value).getBase64());
    }
    else if (String.valueOf(value).trim().length() > 0)
    {
      appendPlain(sb, attrName, value);
    }
  }

  private void appendPlain(StringBuilder sb, String attrName, Object value)
  {
    sb.append("\n");
    sb.append(attrName).append(": ").append(value);
  }

  private void appendBase64(StringBuilder sb, String attrName, String base64Value)
  {
    sb.append("\n");
    sb.append(attrName).append(":: ").append(base64Value);
  }

  /**
   * Returns <CODE>true</CODE> if the provided attribute name has password
   * syntax and <CODE>false</CODE> otherwise.
   * @param attrName the attribute name.
   * @return <CODE>true</CODE> if the provided attribute name has password
   * syntax and <CODE>false</CODE> otherwise.
   */
  protected boolean isPassword(String attrName)
  {
    Schema schema = getInfo().getServerDescriptor().getSchema();
    return Utilities.hasPasswordSyntax(attrName, schema);
  }

  /**
   * Gets the values associated with a given attribute.  The values are the
   * ones displayed in the panel.
   * @param attrName the attribute name.
   * @return the values associated with a given attribute.
   */
  protected abstract List<Object> getValues(String attrName);

  /**
   * Sets the values displayed in the panel for a given attribute in the
   * provided search result.
   * @param sr the search result to be updated.
   * @param attrName the attribute name.
   */
  protected void setValues(Entry sr, String attrName)
  {
    List<Object> values = getValues(attrName);
    final LinkedAttribute attr = new LinkedAttribute(attrName);
    for (Object value : values)
    {
      if (value instanceof ObjectClassValue)
      {
        ObjectClassValue ocValue = (ObjectClassValue)value;
        if (ocValue.getStructural() != null)
        {
          attr.add(ocValue.getStructural());
        }
        SortedSet<String> auxiliaries = ocValue.getAuxiliary();
        for (String auxiliary : auxiliaries)
        {
          attr.add(auxiliary);
        }
      }
      else if (value instanceof byte[])
      {
        attr.add((byte[]) value);
      }
      else if (value instanceof BinaryValue)
      {
        try
        {
          attr.add(((BinaryValue) value).getBytes());
        }
        catch (ParseException pe)
        {
         throw new RuntimeException("Unexpected error: "+pe, pe);
        }
      }
      else
      {
        String s = String.valueOf(value);
        if (s.trim().length() > 0)
        {
          attr.add(s);
        }
      }
    }
    if (!attr.isEmpty())
    {
      sr.removeAttribute(attr.getAttributeDescription());
      sr.addAttribute(attr);
    }
  }

  /**
   * Returns whether the provided attribute name is an editable attribute.
   * @param attrDesc the attribute description.
   * @param schema the schema.
   * @return {@code true} if the provided attribute name is an editable
   * attribute, {@code false} otherwise.
   */
  public static boolean isEditable(AttributeDescription attrDesc, Schema schema)
  {
    String attrName = attrDesc.getNameOrOID();
    if (schema != null && schema.hasAttributeType(attrName))
    {
      AttributeType attrType = schema.getAttributeType(attrName);
      return !attrType.isNoUserModification();
    }
    return false;
  }

  /**
   * Returns the list of superior object classes (to top) for a given object class.
   * @param oc the object class.
   * @return the set of superior object classes for a given object classes.
   */
  protected Set<String> getObjectClassSuperiorValues(ObjectClass oc)
  {
    Set<String> names = new LinkedHashSet<>();
    Set<ObjectClass> parents = oc.getSuperiorClasses();
    if (parents != null && !parents.isEmpty())
    {
      for (ObjectClass parent : parents)
      {
        names.add(parent.getNameOrOID());
        names.addAll(getObjectClassSuperiorValues(parent));
      }
    }
    return names;
  }
}
