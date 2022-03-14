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
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.guitools.controlpanel.ui;

import static org.opends.messages.AdminToolMessages.*;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.TreePath;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.Attribute;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldif.LDIFEntryReader;
import org.opends.guitools.controlpanel.task.OfflineUpdateException;
import org.opends.guitools.controlpanel.util.Utilities;
import org.opends.server.types.OpenDsException;

/** The panel displaying an LDIF view of an entry. */
public class LDIFViewEntryPanel extends ViewEntryPanel
{
  /** Callback that sets the viewport's view position. */
  private static final class SetViewPosition implements Runnable
  {
    private final Point p;
    private final JScrollPane scroll;

    private SetViewPosition(JScrollPane scroll, Point p)
    {
      this.p = p;
      this.scroll = scroll;
    }

    @Override
    public void run()
    {
      if (p != null && scroll.getViewport().contains(p))
      {
        scroll.getViewport().setViewPosition(p);
      }
    }
  }

  private static final long serialVersionUID = 2775960608128921072L;
  private JScrollPane editableScroll;
  private JScrollPane readOnlyScroll;
  private JTextArea editableAttributes;
  private JTextArea readOnlyAttributes;
  private Entry searchResult;

  /** Default constructor. */
  public LDIFViewEntryPanel()
  {
    createLayout();
  }

  @Override
  public Component getPreferredFocusComponent()
  {
    return editableAttributes;
  }

  /** Creates the layout of the panel (but the contents are not populated here). */
  private void createLayout()
  {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weightx = 1.0;

    addTitlePanel(this, gbc);

    gbc.gridy ++;
    gbc.insets.top = 10;

    editableAttributes = Utilities.createTextArea(LocalizableMessage.EMPTY, 20, 30);
    editableAttributes.getDocument().addDocumentListener(new DocumentListener()
    {
      @Override
      public void insertUpdate(DocumentEvent ev)
      {
        notifyListeners();
      }

      @Override
      public void changedUpdate(DocumentEvent ev)
      {
        notifyListeners();
      }

      @Override
      public void removeUpdate(DocumentEvent ev)
      {
        notifyListeners();
      }
    });
    gbc.weighty = 0.6;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridy ++;
    editableScroll = Utilities.createScrollPane(editableAttributes);
    add(editableScroll, gbc);


    gbc.weighty = 0.0;
    gbc.insets.top = 10;
    JLabel lReadOnly = Utilities.createPrimaryLabel(
        INFO_CTRL_PANEL_NON_EDITABLE_ATTRIBUTES.get());
    gbc.gridy ++;
    add(lReadOnly, gbc);
    gbc.insets.top = 5;
    readOnlyAttributes = Utilities.createNonEditableTextArea(LocalizableMessage.EMPTY, 10, 30);
    gbc.weightx = 1.0;
    gbc.weighty = 0.4;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridy ++;
    readOnlyScroll = Utilities.createScrollPane(readOnlyAttributes);
    add(readOnlyScroll, gbc);
  }

  @Override
  public void update(Entry sr, boolean isReadOnly, TreePath path)
  {
    boolean sameEntry = false;
    if (searchResult != null && sr != null)
    {
      sameEntry = searchResult.getName().equals(sr.getName());
    }

    searchResult = sr;
    updateTitle(sr, path);

    StringBuilder sb = new StringBuilder();
    sb.append("dn: ").append(sr.getName());

    if (isReadOnly)
    {
      editableScroll.setVisible(false);
      for (Attribute attr : sr.getAllAttributes())
      {
        final String attrName = attr.getAttributeDescriptionAsString();
        for (ByteString v : attr)
        {
          sb.append("\n").append(getLDIFLine(attrName, v));
        }
      }
      final Point p1 = sameEntry ?
          readOnlyScroll.getViewport().getViewPosition() : new Point(0, 0);
      readOnlyAttributes.setText(sb.toString());
      SwingUtilities.invokeLater(new SetViewPosition(readOnlyScroll, p1));
    }
    else
    {
      editableScroll.setVisible(true);

      for (Attribute attr : sr.getAllAttributes())
      {
        String attrName = attr.getAttributeDescriptionAsString();
        if (!schemaReadOnlyAttributesLowerCase.contains(attrName.toLowerCase()))
        {
          for (ByteString v : attr)
          {
            sb.append("\n").append(getLDIFLine(attrName, v));
          }
        }
      }
      final Point p1 = sameEntry ?
          editableScroll.getViewport().getViewPosition() : new Point(0, 0);
      ignoreEntryChangeEvents = true;
      editableAttributes.setText(sb.toString());
      ignoreEntryChangeEvents = false;

      SwingUtilities.invokeLater(new SetViewPosition(editableScroll, p1));
      // Read-only attributes
      boolean oneLineAdded = false;
      sb = new StringBuilder();
      for (String attrName : schemaReadOnlyAttributes)
      {
        Attribute attr = sr.getAttribute(attrName);
        if (attr != null)
        {
          for (ByteString v : attr)
          {
            if (oneLineAdded)
            {
              sb.append("\n");
            }
            oneLineAdded = true;
            sb.append(getLDIFLine(attrName, v));
          }
        }
      }
      final Point p2 = sameEntry ?
          readOnlyScroll.getViewport().getViewPosition() : new Point(0, 0);
      readOnlyAttributes.setText(sb.toString());
      SwingUtilities.invokeLater(new SetViewPosition(readOnlyScroll, p2));
    }
  }

  @Override
  public GenericDialog.ButtonType getButtonType()
  {
    return GenericDialog.ButtonType.NO_BUTTON;
  }


  @Override
  protected String getDisplayedDN()
  {
    String dn = null;
    // Do it fast, this is called to update the dn displayed in the title.
    String ldif = getLDIF();
    int index = ldif.toLowerCase().indexOf("dn: ");
    if (index != -1)
    {
      int index2 = ldif.indexOf("\n", index);
      if (index2 != -1)
      {
        dn = ldif.substring(index + 3, index2).trim();
      }
    }
    return dn;
  }

  @Override
  protected List<Object> getValues(String attrName)
  {
    throw new IllegalStateException("This method should not be called.");
  }

  @Override
  public Entry getEntry() throws OpenDsException
  {
    String ldif = getLDIF();
    try (LDIFEntryReader reader = new LDIFEntryReader(ldif))
    {
      Entry entry = reader.readEntry();
      addValuesInRDN(entry);
      return entry;
    }
    catch (IOException ioe)
    {
      throw new OfflineUpdateException(
          ERR_CTRL_PANEL_ERROR_CHECKING_ENTRY.get(ioe), ioe);
    }
  }

  /**
   * Returns the LDIF representation of the entry, only returns the editable
   * attributes.
   * @return the LDIF representation of the entry.
   */
  private String getLDIF()
  {
    return editableAttributes.getText();
  }

  /**
   * Returns the equivalent LDIF line for a given attribute and value.
   * @param attrName the attribute name.
   * @param value the value.
   * @return the equivalent LDIF line for the provided attribute and value.
   */
  private String getLDIFLine(String attrName, ByteString value)
  {
    String v = value.toString();
    if (isBinary(attrName) || Utilities.hasControlCharaters(v))
    {
      // To indicate that is base64 encoded
      return attrName + ":: " + value.toBase64String();
    }
    return attrName + ": " + v;
  }
}
