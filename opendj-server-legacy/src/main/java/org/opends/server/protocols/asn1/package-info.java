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
 * Portions Copyright 2014 ForgeRock AS.
 */



/**
 * Contains the Directory Server classes for performing encoding and decoding of
 * ASN.1 elements.  This is not specifically a protocol by itself, but it is
 * used in several places throughout the Directory Server in areas like client
 * communication and internal data encoding, and technically ASN.1 elements are
 * considered to be Directory Server protocol elements.
 * <BR><BR>
 * Note that this particular implementation is limited to the subset of elements
 * that are typically used by LDAP clients.  As such, it does not include all
 * ASN.1 element types, particularly elements like OIDs, bit strings, and
 * timestamp values.
 * <BR><BR>
 * Also note that the contents of this package alone are not sufficient for a
 * highly-performant and scalable LDAP implementation.  The process of reading
 * the outermost ASN.1 sequence that comprises the LDAPMessage envelope will
 * best be done within the implementation for the LDAP connection handler.
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.UNCOMMITTED)
package org.opends.server.protocols.asn1;


