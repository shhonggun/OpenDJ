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
 * Portions Copyright 2016 ForgeRock AS.
 */
package org.opends.server.extensions;

import org.forgerock.opendj.server.config.meta.AESPasswordStorageSchemeCfgDefn;
import org.opends.server.api.PasswordStorageScheme;

/** A set of test cases for the AES password storage scheme. */
public class AESPasswordStorageSchemeTestCase
       extends PasswordStorageSchemeTestCase
{
  /** Creates a new instance of this storage scheme test case. */
  public AESPasswordStorageSchemeTestCase()
  {
    super("cn=AES,cn=Password Storage Schemes,cn=config");
  }

  @Override
  protected PasswordStorageScheme<?> getScheme() throws Exception
  {
    return InitializationUtils.initializePasswordStorageScheme(
        new AESPasswordStorageScheme(), configEntry, AESPasswordStorageSchemeCfgDefn.getInstance());
  }
}
