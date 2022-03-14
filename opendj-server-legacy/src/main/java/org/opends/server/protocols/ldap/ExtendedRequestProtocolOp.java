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
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.server.protocols.ldap;


import java.io.IOException;

import org.forgerock.opendj.io.*;
import org.forgerock.opendj.ldap.ByteString;

import org.forgerock.i18n.slf4j.LocalizedLogger;
import static org.opends.server.protocols.ldap.LDAPConstants.*;
import static org.opends.server.util.ServerConstants.*;


/**
 * This class defines the structures and methods for an LDAP extended request
 * protocol op, which is used to request some special type of processing defined
 * in an extension to the LDAP protocol.
 */
public class ExtendedRequestProtocolOp
       extends ProtocolOp
{
  private static final LocalizedLogger logger = LocalizedLogger.getLoggerForThisClass();

  /** The value for this extended request. */
  private ByteString value;

  /** The OID for this extended request. */
  private String oid;



  /**
   * Creates a new extended request protocol op with the specified OID and no
   * value.
   *
   * @param  oid  The OID for this extended request.
   */
  public ExtendedRequestProtocolOp(String oid)
  {
    this.oid   = oid;
    this.value = null;
  }



  /**
   * Creates a new extended request protocol op with the specified OID and
   * value.
   *
   * @param  oid    The OID for this extended request.
   * @param  value  The value for this extended request.
   */
  public ExtendedRequestProtocolOp(String oid, ByteString value)
  {
    this.oid   = oid;
    this.value = value;
  }



  /**
   * Retrieves the OID for this extended request.
   *
   * @return  The OID for this extended request.
   */
  public String getOID()
  {
    return oid;
  }


  /**
   * Retrieves the value for this extended request.
   *
   * @return  The value for this extended request, or <CODE>null</CODE> if there
   *          is no value.
   */
  public ByteString getValue()
  {
    return value;
  }



  /**
   * Retrieves the BER type for this protocol op.
   *
   * @return  The BER type for this protocol op.
   */
  @Override
  public byte getType()
  {
    return OP_TYPE_EXTENDED_REQUEST;
  }



  /**
   * Retrieves the name for this protocol op type.
   *
   * @return  The name for this protocol op type.
   */
  @Override
  public String getProtocolOpName()
  {
    return "Extended Request";
  }

  /**
   * Writes this protocol op to an ASN.1 output stream.
   *
   * @param stream The ASN.1 output stream to write to.
   * @throws IOException If a problem occurs while writing to the stream.
   */
  @Override
  public void write(ASN1Writer stream) throws IOException
  {
    stream.writeStartSequence(OP_TYPE_EXTENDED_REQUEST);
    stream.writeOctetString(TYPE_EXTENDED_REQUEST_OID, oid);

    if(value != null)
    {
      stream.writeOctetString(TYPE_EXTENDED_REQUEST_VALUE, value);
    }

    stream.writeEndSequence();
  }



  /**
   * Appends a string representation of this LDAP protocol op to the provided
   * buffer.
   *
   * @param  buffer  The buffer to which the string should be appended.
   */
  @Override
  public void toString(StringBuilder buffer)
  {
    buffer.append("ExtendedRequest(oid=");
    buffer.append(oid);

    if (value != null)
    {
      buffer.append(", value=");
      buffer.append(value);
    }

    buffer.append(")");
  }



  /**
   * Appends a multi-line string representation of this LDAP protocol op to the
   * provided buffer.
   *
   * @param  buffer  The buffer to which the information should be appended.
   * @param  indent  The number of spaces from the margin that the lines should
   *                 be indented.
   */
  @Override
  public void toString(StringBuilder buffer, int indent)
  {
    StringBuilder indentBuf = new StringBuilder(indent);
    for (int i=0 ; i < indent; i++)
    {
      indentBuf.append(' ');
    }

    buffer.append(indentBuf);
    buffer.append("Extended Request");
    buffer.append(EOL);

    buffer.append(indentBuf);
    buffer.append("  OID:  ");
    buffer.append(oid);
    buffer.append(EOL);

    if (value != null)
    {
      buffer.append(indentBuf);
      buffer.append("  Value:");
      buffer.append(EOL);
      buffer.append(value.toHexPlusAsciiString(indent+4));
    }
  }
}

