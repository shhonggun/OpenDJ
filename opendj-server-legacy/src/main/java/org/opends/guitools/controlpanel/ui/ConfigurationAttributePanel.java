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
 * Copyright 2008 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.guitools.controlpanel.ui;

import static org.opends.messages.AdminToolMessages.*;
import org.forgerock.i18n.LocalizableMessage;

/** The panel that displays a configuration attribute definition. */
public class ConfigurationAttributePanel extends StandardAttributePanel
{
  private static final long serialVersionUID = -6072885354690411482L;

  @Override
  public LocalizableMessage getTitle()
  {
    return INFO_CTRL_PANEL_CONFIGURATION_ATTRIBUTE_TITLE.get();
  }
}
