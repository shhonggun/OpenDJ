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
package org.forgerock.opendj.server.config.server;



import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;



/**
 * A server-side interface for querying Plugin Root settings.
 * <p>
 * The Plugin Root defines the parent entry for all plug-ins defined
 * in the server.
 */
public interface PluginRootCfg extends Configuration {

  /**
   * Gets the configuration class associated with this Plugin Root.
   *
   * @return Returns the configuration class associated with this Plugin Root.
   */
  Class<? extends PluginRootCfg> configurationClass();



  /**
   * Register to be notified when this Plugin Root is changed.
   *
   * @param listener
   *          The Plugin Root configuration change listener.
   */
  void addChangeListener(ConfigurationChangeListener<PluginRootCfg> listener);



  /**
   * Deregister an existing Plugin Root configuration change listener.
   *
   * @param listener
   *          The Plugin Root configuration change listener.
   */
  void removeChangeListener(ConfigurationChangeListener<PluginRootCfg> listener);



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
   * Lists the Plugins.
   *
   * @return Returns an array containing the names of the
   *         Plugins.
   */
  String[] listPlugins();



  /**
   * Gets the named Plugin.
   *
   * @param name
   *          The name of the Plugin to retrieve.
   * @return Returns the named Plugin.
   * @throws ConfigException
   *           If the Plugin could not be found or it
   *           could not be successfully decoded.
   */
  PluginCfg getPlugin(String name) throws ConfigException;



  /**
   * Registers to be notified when new Plugins are added.
   *
   * @param listener
   *          The Plugin configuration add listener.
   * @throws ConfigException
   *          If the add listener could not be registered.
   */
  void addPluginAddListener(ConfigurationAddListener<PluginCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Plugin configuration add listener.
   *
   * @param listener
   *          The Plugin configuration add listener.
   */
  void removePluginAddListener(ConfigurationAddListener<PluginCfg> listener);



  /**
   * Registers to be notified when existing Plugins are deleted.
   *
   * @param listener
   *          The Plugin configuration delete listener.
   * @throws ConfigException
   *          If the delete listener could not be registered.
   */
  void addPluginDeleteListener(ConfigurationDeleteListener<PluginCfg> listener) throws ConfigException;



  /**
   * Deregisters an existing Plugin configuration delete listener.
   *
   * @param listener
   *          The Plugin configuration delete listener.
   */
  void removePluginDeleteListener(ConfigurationDeleteListener<PluginCfg> listener);

}
