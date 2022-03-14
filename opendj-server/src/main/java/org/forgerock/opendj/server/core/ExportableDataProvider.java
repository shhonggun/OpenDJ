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
 * Portions Copyright 2013-2016 ForgeRock AS.
 */
package org.forgerock.opendj.server.core;

import org.forgerock.opendj.ldap.LdapPromise;
import org.forgerock.opendj.ldap.LdapResultHandler;
import org.forgerock.opendj.ldif.EntryWriter;

/**
 * A data provider which supports LDIF export functionality.
 * <p>
 * FIXME: the async APIs used below are a bad fit. We do not want to return an
 * {@link org.forgerock.opendj.ldap.LdapException}. We really need a more generic promises API.
 */
public interface ExportableDataProvider {

    /**
     * Exports the contents of this data provider to the provided entry writer.
     * <p>
     * Note that the server will not explicitly initialize this data provider
     * before calling this method.
     *
     * @param writer
     *            The entry writer.
     * @param handler
     *            A handler which will be notified when the export completes.
     * @return A promise representing the completion of the export.
     */
    LdapPromise<Void> exportEntries(EntryWriter writer, LdapResultHandler<Void> handler);

    /**
     * Returns the ID of this data provider.
     *
     * @return The ID of this data provider.
     */
    DataProviderID getDataProviderID();
}
