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
package org.opends.server.extensions;

import static org.opends.messages.ExtensionMessages.*;
import static org.opends.server.extensions.ExtensionsConstants.*;
import static org.opends.server.util.StaticUtils.*;

import java.util.Arrays;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.i18n.slf4j.LocalizedLogger;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.Base64;
import org.forgerock.opendj.ldap.ByteSequence;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.server.config.server.AESPasswordStorageSchemeCfg;
import org.opends.server.api.PasswordStorageScheme;
import org.opends.server.core.DirectoryServer;
import org.opends.server.types.CryptoManager;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.InitializationException;

/**
 * This class defines a Directory Server password storage scheme that will
 * encode values using the AES reversible encryption algorithm.  This
 * implementation supports only the user password syntax and not the auth
 * password syntax.
 */
public class AESPasswordStorageScheme
       extends PasswordStorageScheme<AESPasswordStorageSchemeCfg>
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /**
   * The reference to the Directory Server crypto manager that we will use to
   * handle the encryption/decryption.
   */
  private CryptoManager cryptoManager;

  /**
   * Creates a new instance of this password storage scheme.  Note that no
   * initialization should be performed here, as all initialization should be
   * done in the {@code initializePasswordStorageScheme} method.
   */
  public AESPasswordStorageScheme()
  {
    super();
  }

  @Override
  public void initializePasswordStorageScheme(
                   AESPasswordStorageSchemeCfg configuration)
         throws ConfigException, InitializationException
  {
    cryptoManager = DirectoryServer.getInstance().getServerContext().getCryptoManager();
  }

  @Override
  public String getStorageSchemeName()
  {
    return STORAGE_SCHEME_NAME_AES;
  }

  @Override
  public ByteString encodePassword(ByteSequence plaintext)
         throws DirectoryException
  {
    byte[] plaintextBytes = null;
    try
    {
      // TODO: Can we avoid this copy?
      plaintextBytes = plaintext.toByteArray();
      byte[] encodedBytes = cryptoManager.encrypt(CIPHER_TRANSFORMATION_AES,
                                                  KEY_SIZE_AES,
                                                  plaintextBytes);
      return ByteString.valueOfUtf8(Base64.encode(encodedBytes));
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage m = ERR_PWSCHEME_CANNOT_ENCRYPT.get(STORAGE_SCHEME_NAME_AES,
                                                  getExceptionMessage(e));
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }
    finally
    {
      if (plaintextBytes != null)
      {
        Arrays.fill(plaintextBytes, (byte) 0);
      }
    }
  }

  @Override
  public ByteString encodePasswordWithScheme(ByteSequence plaintext)
         throws DirectoryException
  {
    StringBuilder buffer = new StringBuilder();
    buffer.append('{');
    buffer.append(STORAGE_SCHEME_NAME_AES);
    buffer.append('}');
    byte[] plaintextBytes = null;
    try
    {
      // TODO: Can we avoid this copy?
      plaintextBytes = plaintext.toByteArray();
      byte[] encodedBytes = cryptoManager.encrypt(CIPHER_TRANSFORMATION_AES,
                                                  KEY_SIZE_AES,
                                                  plaintextBytes);
      buffer.append(Base64.encode(encodedBytes));
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage m = ERR_PWSCHEME_CANNOT_ENCRYPT.get(STORAGE_SCHEME_NAME_AES,
                                                  getExceptionMessage(e));
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }
    finally
    {
      if (plaintextBytes != null)
      {
        Arrays.fill(plaintextBytes, (byte) 0);
      }
    }

    return ByteString.valueOfUtf8(buffer);
  }

  @Override
  public boolean passwordMatches(ByteSequence plaintextPassword,
                                 ByteSequence storedPassword)
  {
    try
    {
      ByteString decryptedPassword =
          ByteString.wrap(cryptoManager.decrypt(
                  Base64.decode(storedPassword.toString()).toByteArray()));
      return plaintextPassword.equals(decryptedPassword);
    }
    catch (Exception e)
    {
      logger.traceException(e);

      return false;
    }
  }

  @Override
  public boolean isReversible()
  {
    return true;
  }

  @Override
  public ByteString getPlaintextValue(ByteSequence storedPassword)
         throws DirectoryException
  {
    try
    {
      byte[] decryptedPassword =
           cryptoManager.decrypt(Base64.decode(storedPassword.toString()).toByteArray());
      return ByteString.wrap(decryptedPassword);
    }
    catch (Exception e)
    {
      logger.traceException(e);

      LocalizableMessage m = ERR_PWSCHEME_CANNOT_DECRYPT.get(STORAGE_SCHEME_NAME_AES,
                                                  getExceptionMessage(e));
      throw new DirectoryException(DirectoryServer.getCoreConfigManager().getServerErrorResultCode(),
                                   m, e);
    }
  }

  @Override
  public boolean supportsAuthPasswordSyntax()
  {
    // This storage scheme does not support the authentication password syntax.
    return false;
  }

  @Override
  public ByteString encodeAuthPassword(ByteSequence plaintext)
         throws DirectoryException
  {
    LocalizableMessage message =
        ERR_PWSCHEME_DOES_NOT_SUPPORT_AUTH_PASSWORD.get(getStorageSchemeName());
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM, message);
  }

  @Override
  public boolean authPasswordMatches(ByteSequence plaintextPassword,
                                     String authInfo, String authValue)
  {
    // This storage scheme does not support the authentication password syntax.
    return false;
  }

  @Override
  public ByteString getAuthPasswordPlaintextValue(String authInfo,
                                                  String authValue)
         throws DirectoryException
  {
    LocalizableMessage message =
        ERR_PWSCHEME_DOES_NOT_SUPPORT_AUTH_PASSWORD.get(getStorageSchemeName());
    throw new DirectoryException(ResultCode.UNWILLING_TO_PERFORM, message);
  }

  @Override
  public boolean isStorageSchemeSecure()
  {
    // This password storage scheme should be considered secure.
    return true;
  }
}
