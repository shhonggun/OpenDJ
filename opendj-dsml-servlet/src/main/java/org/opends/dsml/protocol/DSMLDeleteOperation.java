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
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.dsml.protocol;

import java.io.IOException;
import java.util.List;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.DecodeException;
import org.opends.server.protocols.ldap.DeleteRequestProtocolOp;
import org.opends.server.protocols.ldap.DeleteResponseProtocolOp;
import org.opends.server.protocols.ldap.LDAPMessage;
import org.opends.server.protocols.ldap.ProtocolOp;
import org.opends.server.tools.LDAPConnection;
import org.opends.server.types.LDAPException;

/**
 * This class provides the functionality for the performing an
 * LDAP DELETE operation based on the specified DSML request.
 *
 * @author   Vivek Nagar
 */
class DSMLDeleteOperation
{
  private final LDAPConnection connection;

  /**
   * Create an instance with the specified LDAP connection.
   *
   * @param connection    The LDAP connection to send the request on.
   */
  public DSMLDeleteOperation(LDAPConnection connection)
  {
    this.connection = connection;
  }

  /**
   * Perform the LDAP DELETE operation and send the result back to the
   * client.
   *
   * @param  objFactory     The object factory for this operation.
   * @param  deleteRequest  The delete request for this operation.
   * @param  controls       Any required controls (e.g. for proxy authz).
   *
   * @return  The result of the delete operation.
   *
   * @throws  IOException  If an I/O problem occurs.
   *
   * @throws  LDAPException  If an error occurs while interacting with an LDAP
   *                         element.
   *
   * @throws  DecodeException  If an error occurs while interacting with an ASN.1
   *                         element.
   */
  public LDAPResult doOperation(ObjectFactory objFactory,
        DelRequest deleteRequest,
        List<org.opends.server.types.Control> controls)
    throws IOException, LDAPException, DecodeException
  {
    LDAPResult delResponse = objFactory.createLDAPResult();
    delResponse.setRequestID(deleteRequest.getRequestID());

    // Create and send the LDAP delete request to the server.
    ByteString dnStr = ByteString.valueOfUtf8(deleteRequest.getDn());
    ProtocolOp op = new DeleteRequestProtocolOp(dnStr);
    LDAPMessage msg = new LDAPMessage(DSMLServlet.nextMessageID(), op,
        controls);
    connection.getLDAPWriter().writeMessage(msg);

    // Read and decode the LDAP response from the server.
    LDAPMessage responseMessage = connection.getLDAPReader().readMessage();

    DeleteResponseProtocolOp delOp =
          responseMessage.getDeleteResponseProtocolOp();
    int resultCode = delOp.getResultCode();
    LocalizableMessage errorMessage = delOp.getErrorMessage();

    // Set the result code and error message for the DSML response.
    delResponse.setErrorMessage(
            errorMessage != null ? errorMessage.toString() : null);
    ResultCode code = ResultCodeFactory.create(objFactory, resultCode);
    delResponse.setResultCode(code);

    // set the match DN
    DN dn = delOp.getMatchedDN();
    if ( dn != null ) {
      delResponse.setMatchedDN(dn.toString());
    }

    return delResponse;
  }

}

