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
 */
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.PluginRootCfg;



/**
 * A client-side interface for reading and modifying Plugin Root
 * settings.
 * <p>
 * The Plugin Root defines the parent entry for all plug-ins defined
 * in the server.
 */
public interface PluginRootCfgClient extends ConfigurationClient {

  /**
   * Get the configuration definition associated with this Plugin Root.
   *
   * @return Returns the configuration definition associated with this Plugin Root.
   */
  ManagedObjectDefinition<? extends PluginRootCfgClient, ? extends PluginRootCfg> definition();



  /**
   * Gets the "plugin-order-intermediate-response" property.
   * <p>
   * Specifies the order in which intermediate response plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-intermediate-response" property.
   */
  String getPluginOrderIntermediateResponse();



  /**
   * Sets the "plugin-order-intermediate-response" property.
   * <p>
   * Specifies the order in which intermediate response plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-intermediate-response" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderIntermediateResponse(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-ldif-export" property.
   * <p>
   * Specifies the order in which LDIF export plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-ldif-export" property.
   */
  String getPluginOrderLDIFExport();



  /**
   * Sets the "plugin-order-ldif-export" property.
   * <p>
   * Specifies the order in which LDIF export plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-ldif-export" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderLDIFExport(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-ldif-import" property.
   * <p>
   * Specifies the order in which LDIF import plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-ldif-import" property.
   */
  String getPluginOrderLDIFImport();



  /**
   * Sets the "plugin-order-ldif-import" property.
   * <p>
   * Specifies the order in which LDIF import plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-ldif-import" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderLDIFImport(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-ldif-import-begin" property.
   * <p>
   * Specifies the order in which LDIF import begin plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-ldif-import-begin" property.
   */
  String getPluginOrderLDIFImportBegin();



  /**
   * Sets the "plugin-order-ldif-import-begin" property.
   * <p>
   * Specifies the order in which LDIF import begin plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-ldif-import-begin" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderLDIFImportBegin(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-ldif-import-end" property.
   * <p>
   * Specifies the order in which LDIF import end plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-ldif-import-end" property.
   */
  String getPluginOrderLDIFImportEnd();



  /**
   * Sets the "plugin-order-ldif-import-end" property.
   * <p>
   * Specifies the order in which LDIF import end plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-ldif-import-end" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderLDIFImportEnd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-connect" property.
   * <p>
   * Specifies the order in which post-connect plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-connect" property.
   */
  String getPluginOrderPostConnect();



  /**
   * Sets the "plugin-order-post-connect" property.
   * <p>
   * Specifies the order in which post-connect plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-connect" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostConnect(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-disconnect" property.
   * <p>
   * Specifies the order in which post-disconnect plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-disconnect" property.
   */
  String getPluginOrderPostDisconnect();



  /**
   * Sets the "plugin-order-post-disconnect" property.
   * <p>
   * Specifies the order in which post-disconnect plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-disconnect" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostDisconnect(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-abandon" property.
   * <p>
   * Specifies the order in which post-operation abandon plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-abandon" property.
   */
  String getPluginOrderPostOperationAbandon();



  /**
   * Sets the "plugin-order-post-operation-abandon" property.
   * <p>
   * Specifies the order in which post-operation abandon plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-abandon" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationAbandon(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-add" property.
   * <p>
   * Specifies the order in which post-operation add plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-add" property.
   */
  String getPluginOrderPostOperationAdd();



  /**
   * Sets the "plugin-order-post-operation-add" property.
   * <p>
   * Specifies the order in which post-operation add plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-add" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationAdd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-bind" property.
   * <p>
   * Specifies the order in which post-operation bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-bind" property.
   */
  String getPluginOrderPostOperationBind();



  /**
   * Sets the "plugin-order-post-operation-bind" property.
   * <p>
   * Specifies the order in which post-operation bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-bind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationBind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-compare" property.
   * <p>
   * Specifies the order in which post-operation compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-compare" property.
   */
  String getPluginOrderPostOperationCompare();



  /**
   * Sets the "plugin-order-post-operation-compare" property.
   * <p>
   * Specifies the order in which post-operation compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-compare" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationCompare(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-delete" property.
   * <p>
   * Specifies the order in which post-operation delete plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-delete" property.
   */
  String getPluginOrderPostOperationDelete();



  /**
   * Sets the "plugin-order-post-operation-delete" property.
   * <p>
   * Specifies the order in which post-operation delete plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-extended" property.
   * <p>
   * Specifies the order in which post-operation extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-extended" property.
   */
  String getPluginOrderPostOperationExtended();



  /**
   * Sets the "plugin-order-post-operation-extended" property.
   * <p>
   * Specifies the order in which post-operation extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-extended" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationExtended(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-modify" property.
   * <p>
   * Specifies the order in which post-operation modify plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-modify" property.
   */
  String getPluginOrderPostOperationModify();



  /**
   * Sets the "plugin-order-post-operation-modify" property.
   * <p>
   * Specifies the order in which post-operation modify plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-modify" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationModify(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-modify-dn" property.
   * <p>
   * Specifies the order in which post-operation modify DN plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-modify-dn" property.
   */
  String getPluginOrderPostOperationModifyDN();



  /**
   * Sets the "plugin-order-post-operation-modify-dn" property.
   * <p>
   * Specifies the order in which post-operation modify DN plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationModifyDN(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-search" property.
   * <p>
   * Specifies the order in which post-operation search plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-search" property.
   */
  String getPluginOrderPostOperationSearch();



  /**
   * Sets the "plugin-order-post-operation-search" property.
   * <p>
   * Specifies the order in which post-operation search plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-search" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationSearch(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-operation-unbind" property.
   * <p>
   * Specifies the order in which post-operation unbind plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-operation-unbind" property.
   */
  String getPluginOrderPostOperationUnbind();



  /**
   * Sets the "plugin-order-post-operation-unbind" property.
   * <p>
   * Specifies the order in which post-operation unbind plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-operation-unbind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostOperationUnbind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-add" property.
   * <p>
   * Specifies the order in which post-response add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-add" property.
   */
  String getPluginOrderPostResponseAdd();



  /**
   * Sets the "plugin-order-post-response-add" property.
   * <p>
   * Specifies the order in which post-response add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-add" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseAdd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-bind" property.
   * <p>
   * Specifies the order in which post-response bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-bind" property.
   */
  String getPluginOrderPostResponseBind();



  /**
   * Sets the "plugin-order-post-response-bind" property.
   * <p>
   * Specifies the order in which post-response bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-bind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseBind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-compare" property.
   * <p>
   * Specifies the order in which post-response compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-compare" property.
   */
  String getPluginOrderPostResponseCompare();



  /**
   * Sets the "plugin-order-post-response-compare" property.
   * <p>
   * Specifies the order in which post-response compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-compare" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseCompare(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-delete" property.
   * <p>
   * Specifies the order in which post-response delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-delete" property.
   */
  String getPluginOrderPostResponseDelete();



  /**
   * Sets the "plugin-order-post-response-delete" property.
   * <p>
   * Specifies the order in which post-response delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-extended" property.
   * <p>
   * Specifies the order in which post-response extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-extended" property.
   */
  String getPluginOrderPostResponseExtended();



  /**
   * Sets the "plugin-order-post-response-extended" property.
   * <p>
   * Specifies the order in which post-response extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-extended" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseExtended(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-modify" property.
   * <p>
   * Specifies the order in which post-response modify plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-modify" property.
   */
  String getPluginOrderPostResponseModify();



  /**
   * Sets the "plugin-order-post-response-modify" property.
   * <p>
   * Specifies the order in which post-response modify plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-modify" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseModify(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-modify-dn" property.
   * <p>
   * Specifies the order in which post-response modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-modify-dn" property.
   */
  String getPluginOrderPostResponseModifyDN();



  /**
   * Sets the "plugin-order-post-response-modify-dn" property.
   * <p>
   * Specifies the order in which post-response modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseModifyDN(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-response-search" property.
   * <p>
   * Specifies the order in which post-response search plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-response-search" property.
   */
  String getPluginOrderPostResponseSearch();



  /**
   * Sets the "plugin-order-post-response-search" property.
   * <p>
   * Specifies the order in which post-response search plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-response-search" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostResponseSearch(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-synchronization-add" property.
   * <p>
   * Specifies the order in which post-synchronization add plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-synchronization-add" property.
   */
  String getPluginOrderPostSynchronizationAdd();



  /**
   * Sets the "plugin-order-post-synchronization-add" property.
   * <p>
   * Specifies the order in which post-synchronization add plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-synchronization-add" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostSynchronizationAdd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-synchronization-delete" property.
   * <p>
   * Specifies the order in which post-synchronization delete plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-synchronization-delete" property.
   */
  String getPluginOrderPostSynchronizationDelete();



  /**
   * Sets the "plugin-order-post-synchronization-delete" property.
   * <p>
   * Specifies the order in which post-synchronization delete plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-synchronization-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostSynchronizationDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-synchronization-modify" property.
   * <p>
   * Specifies the order in which post-synchronization modify plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-synchronization-modify" property.
   */
  String getPluginOrderPostSynchronizationModify();



  /**
   * Sets the "plugin-order-post-synchronization-modify" property.
   * <p>
   * Specifies the order in which post-synchronization modify plug-ins
   * are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-synchronization-modify" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostSynchronizationModify(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-post-synchronization-modify-dn" property.
   * <p>
   * Specifies the order in which post-synchronization modify DN
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-post-synchronization-modify-dn" property.
   */
  String getPluginOrderPostSynchronizationModifyDN();



  /**
   * Sets the "plugin-order-post-synchronization-modify-dn" property.
   * <p>
   * Specifies the order in which post-synchronization modify DN
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-post-synchronization-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPostSynchronizationModifyDN(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-add" property.
   * <p>
   * Specifies the order in which pre-operation add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-add" property.
   */
  String getPluginOrderPreOperationAdd();



  /**
   * Sets the "plugin-order-pre-operation-add" property.
   * <p>
   * Specifies the order in which pre-operation add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-add" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationAdd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-bind" property.
   * <p>
   * Specifies the order in which pre-operation bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-bind" property.
   */
  String getPluginOrderPreOperationBind();



  /**
   * Sets the "plugin-order-pre-operation-bind" property.
   * <p>
   * Specifies the order in which pre-operation bind plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-bind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationBind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-compare" property.
   * <p>
   * Specifies the order in which pre-operation compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-compare" property.
   */
  String getPluginOrderPreOperationCompare();



  /**
   * Sets the "plugin-order-pre-operation-compare" property.
   * <p>
   * Specifies the order in which pre-operation compare plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-compare" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationCompare(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-delete" property.
   * <p>
   * Specifies the order in which pre-operation delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-delete" property.
   */
  String getPluginOrderPreOperationDelete();



  /**
   * Sets the "plugin-order-pre-operation-delete" property.
   * <p>
   * Specifies the order in which pre-operation delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-extended" property.
   * <p>
   * Specifies the order in which pre-operation extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-extended" property.
   */
  String getPluginOrderPreOperationExtended();



  /**
   * Sets the "plugin-order-pre-operation-extended" property.
   * <p>
   * Specifies the order in which pre-operation extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-extended" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationExtended(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-modify" property.
   * <p>
   * Specifies the order in which pre-operation modify plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-modify" property.
   */
  String getPluginOrderPreOperationModify();



  /**
   * Sets the "plugin-order-pre-operation-modify" property.
   * <p>
   * Specifies the order in which pre-operation modify plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-modify" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationModify(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-modify-dn" property.
   * <p>
   * Specifies the order in which pre-operation modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-modify-dn" property.
   */
  String getPluginOrderPreOperationModifyDN();



  /**
   * Sets the "plugin-order-pre-operation-modify-dn" property.
   * <p>
   * Specifies the order in which pre-operation modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationModifyDN(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-operation-search" property.
   * <p>
   * Specifies the order in which pre-operation search plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-operation-search" property.
   */
  String getPluginOrderPreOperationSearch();



  /**
   * Sets the "plugin-order-pre-operation-search" property.
   * <p>
   * Specifies the order in which pre-operation search plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-operation-search" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreOperationSearch(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-abandon" property.
   * <p>
   * Specifies the order in which pre-parse abandon plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-abandon" property.
   */
  String getPluginOrderPreParseAbandon();



  /**
   * Sets the "plugin-order-pre-parse-abandon" property.
   * <p>
   * Specifies the order in which pre-parse abandon plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-abandon" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseAbandon(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-add" property.
   * <p>
   * Specifies the order in which pre-parse add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-add" property.
   */
  String getPluginOrderPreParseAdd();



  /**
   * Sets the "plugin-order-pre-parse-add" property.
   * <p>
   * Specifies the order in which pre-parse add plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-add" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseAdd(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-bind" property.
   * <p>
   * Specifies the order in which pre-parse bind plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-bind" property.
   */
  String getPluginOrderPreParseBind();



  /**
   * Sets the "plugin-order-pre-parse-bind" property.
   * <p>
   * Specifies the order in which pre-parse bind plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-bind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseBind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-compare" property.
   * <p>
   * Specifies the order in which pre-parse compare plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-compare" property.
   */
  String getPluginOrderPreParseCompare();



  /**
   * Sets the "plugin-order-pre-parse-compare" property.
   * <p>
   * Specifies the order in which pre-parse compare plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-compare" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseCompare(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-delete" property.
   * <p>
   * Specifies the order in which pre-parse delete plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-delete" property.
   */
  String getPluginOrderPreParseDelete();



  /**
   * Sets the "plugin-order-pre-parse-delete" property.
   * <p>
   * Specifies the order in which pre-parse delete plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-extended" property.
   * <p>
   * Specifies the order in which pre-parse extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-extended" property.
   */
  String getPluginOrderPreParseExtended();



  /**
   * Sets the "plugin-order-pre-parse-extended" property.
   * <p>
   * Specifies the order in which pre-parse extended operation
   * plug-ins are to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-extended" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseExtended(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-modify" property.
   * <p>
   * Specifies the order in which pre-parse modify plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-modify" property.
   */
  String getPluginOrderPreParseModify();



  /**
   * Sets the "plugin-order-pre-parse-modify" property.
   * <p>
   * Specifies the order in which pre-parse modify plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-modify" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseModify(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-modify-dn" property.
   * <p>
   * Specifies the order in which pre-parse modify DN plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-modify-dn" property.
   */
  String getPluginOrderPreParseModifyDN();



  /**
   * Sets the "plugin-order-pre-parse-modify-dn" property.
   * <p>
   * Specifies the order in which pre-parse modify DN plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseModifyDN(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-search" property.
   * <p>
   * Specifies the order in which pre-parse search plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-search" property.
   */
  String getPluginOrderPreParseSearch();



  /**
   * Sets the "plugin-order-pre-parse-search" property.
   * <p>
   * Specifies the order in which pre-parse search plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-search" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseSearch(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-pre-parse-unbind" property.
   * <p>
   * Specifies the order in which pre-parse unbind plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-pre-parse-unbind" property.
   */
  String getPluginOrderPreParseUnbind();



  /**
   * Sets the "plugin-order-pre-parse-unbind" property.
   * <p>
   * Specifies the order in which pre-parse unbind plug-ins are to be
   * loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-pre-parse-unbind" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderPreParseUnbind(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-search-result-entry" property.
   * <p>
   * Specifies the order in which search result entry plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-search-result-entry" property.
   */
  String getPluginOrderSearchResultEntry();



  /**
   * Sets the "plugin-order-search-result-entry" property.
   * <p>
   * Specifies the order in which search result entry plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-search-result-entry" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderSearchResultEntry(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-search-result-reference" property.
   * <p>
   * Specifies the order in which search result reference plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-search-result-reference" property.
   */
  String getPluginOrderSearchResultReference();



  /**
   * Sets the "plugin-order-search-result-reference" property.
   * <p>
   * Specifies the order in which search result reference plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-search-result-reference" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderSearchResultReference(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-shutdown" property.
   * <p>
   * Specifies the order in which shutdown plug-ins are to be loaded
   * and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-shutdown" property.
   */
  String getPluginOrderShutdown();



  /**
   * Sets the "plugin-order-shutdown" property.
   * <p>
   * Specifies the order in which shutdown plug-ins are to be loaded
   * and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-shutdown" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderShutdown(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-startup" property.
   * <p>
   * Specifies the order in which startup plug-ins are to be loaded
   * and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-startup" property.
   */
  String getPluginOrderStartup();



  /**
   * Sets the "plugin-order-startup" property.
   * <p>
   * Specifies the order in which startup plug-ins are to be loaded
   * and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-startup" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderStartup(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-subordinate-delete" property.
   * <p>
   * Specifies the order in which subordinate delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-subordinate-delete" property.
   */
  String getPluginOrderSubordinateDelete();



  /**
   * Sets the "plugin-order-subordinate-delete" property.
   * <p>
   * Specifies the order in which subordinate delete plug-ins are to
   * be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-subordinate-delete" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderSubordinateDelete(String value) throws PropertyException;



  /**
   * Gets the "plugin-order-subordinate-modify-dn" property.
   * <p>
   * Specifies the order in which subordinate modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @return Returns the value of the "plugin-order-subordinate-modify-dn" property.
   */
  String getPluginOrderSubordinateModifyDN();



  /**
   * Sets the "plugin-order-subordinate-modify-dn" property.
   * <p>
   * Specifies the order in which subordinate modify DN plug-ins are
   * to be loaded and invoked.
   * <p>
   * The value is a comma-delimited list of plug-in names (where the
   * plug-in name is the RDN value from the plug-in configuration entry
   * DN). The list can include at most one asterisk to indicate the
   * position of any unspecified plug-in (and the relative order of
   * those unspecified plug-ins is undefined).
   *
   * @param value The value of the "plugin-order-subordinate-modify-dn" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setPluginOrderSubordinateModifyDN(String value) throws PropertyException;



  /**
   * Lists the Plugins.
   *
   * @return Returns an array containing the names of the Plugins.
   * @throws ConcurrentModificationException
   *           If this Plugin Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listPlugins() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Plugin.
   *
   * @param name
   *           The name of the Plugin to retrieve.
   * @return Returns the named Plugin.
   * @throws DefinitionDecodingException
   *           If the named Plugin was found but its type could not be
   *           determined.
   * @throws ManagedObjectDecodingException
   *           If the named Plugin was found but one or more of its
   *           properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Plugin was not found on the server.
   * @throws ConcurrentModificationException
   *           If this Plugin Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  PluginCfgClient getPlugin(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Plugin. The new Plugin will initially not contain
   * any property values (including mandatory properties). Once the
   * Plugin has been configured it can be added to the server using the
   * {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Plugin being created.
   * @param d
   *          The definition of the Plugin to be created.
   * @param name
   *          The name of the new Plugin.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Plugin. This argument
   *          can be <code>null<code>.
   * @return Returns a new Plugin configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Plugin is invalid.
   */
  <C extends PluginCfgClient> C createPlugin(
      ManagedObjectDefinition<C, ? extends PluginCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Plugin.
   *
   * @param name
   *          The name of the Plugin to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Plugin does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Plugin due to some
   *           server-side constraint which cannot be satisfied (for
   *           example, if it is referenced by another managed object).
   * @throws ConcurrentModificationException
   *           If this Plugin Root has been removed from the server by
   *           another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removePlugin(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;

}
