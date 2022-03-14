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
package org.forgerock.opendj.server.config.meta;



import java.util.Collection;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.InstantiableRelationDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.config.server.ConfigurationAddListener;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ConfigurationDeleteListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.PluginCfgClient;
import org.forgerock.opendj.server.config.client.PluginRootCfgClient;
import org.forgerock.opendj.server.config.server.PluginCfg;
import org.forgerock.opendj.server.config.server.PluginRootCfg;



/**
 * An interface for querying the Plugin Root managed object definition
 * meta information.
 * <p>
 * The Plugin Root defines the parent entry for all plug-ins defined
 * in the server.
 */
public final class PluginRootCfgDefn extends ManagedObjectDefinition<PluginRootCfgClient, PluginRootCfg> {

  /** The singleton configuration definition instance. */
  private static final PluginRootCfgDefn INSTANCE = new PluginRootCfgDefn();



  /** The "plugin-order-intermediate-response" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_INTERMEDIATE_RESPONSE;



  /** The "plugin-order-ldif-export" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_LDIF_EXPORT;



  /** The "plugin-order-ldif-import" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_LDIF_IMPORT;



  /** The "plugin-order-ldif-import-begin" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_LDIF_IMPORT_BEGIN;



  /** The "plugin-order-ldif-import-end" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_LDIF_IMPORT_END;



  /** The "plugin-order-post-connect" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_CONNECT;



  /** The "plugin-order-post-disconnect" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_DISCONNECT;



  /** The "plugin-order-post-operation-abandon" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_ABANDON;



  /** The "plugin-order-post-operation-add" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_ADD;



  /** The "plugin-order-post-operation-bind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_BIND;



  /** The "plugin-order-post-operation-compare" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_COMPARE;



  /** The "plugin-order-post-operation-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_DELETE;



  /** The "plugin-order-post-operation-extended" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_EXTENDED;



  /** The "plugin-order-post-operation-modify" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_MODIFY;



  /** The "plugin-order-post-operation-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_MODIFY_DN;



  /** The "plugin-order-post-operation-search" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_SEARCH;



  /** The "plugin-order-post-operation-unbind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_OPERATION_UNBIND;



  /** The "plugin-order-post-response-add" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_ADD;



  /** The "plugin-order-post-response-bind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_BIND;



  /** The "plugin-order-post-response-compare" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_COMPARE;



  /** The "plugin-order-post-response-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_DELETE;



  /** The "plugin-order-post-response-extended" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_EXTENDED;



  /** The "plugin-order-post-response-modify" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY;



  /** The "plugin-order-post-response-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY_DN;



  /** The "plugin-order-post-response-search" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_RESPONSE_SEARCH;



  /** The "plugin-order-post-synchronization-add" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_ADD;



  /** The "plugin-order-post-synchronization-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_DELETE;



  /** The "plugin-order-post-synchronization-modify" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY;



  /** The "plugin-order-post-synchronization-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY_DN;



  /** The "plugin-order-pre-operation-add" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_ADD;



  /** The "plugin-order-pre-operation-bind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_BIND;



  /** The "plugin-order-pre-operation-compare" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_COMPARE;



  /** The "plugin-order-pre-operation-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_DELETE;



  /** The "plugin-order-pre-operation-extended" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_EXTENDED;



  /** The "plugin-order-pre-operation-modify" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY;



  /** The "plugin-order-pre-operation-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY_DN;



  /** The "plugin-order-pre-operation-search" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_OPERATION_SEARCH;



  /** The "plugin-order-pre-parse-abandon" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_ABANDON;



  /** The "plugin-order-pre-parse-add" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_ADD;



  /** The "plugin-order-pre-parse-bind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_BIND;



  /** The "plugin-order-pre-parse-compare" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_COMPARE;



  /** The "plugin-order-pre-parse-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_DELETE;



  /** The "plugin-order-pre-parse-extended" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_EXTENDED;



  /** The "plugin-order-pre-parse-modify" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_MODIFY;



  /** The "plugin-order-pre-parse-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_MODIFY_DN;



  /** The "plugin-order-pre-parse-search" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_SEARCH;



  /** The "plugin-order-pre-parse-unbind" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_PRE_PARSE_UNBIND;



  /** The "plugin-order-search-result-entry" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_SEARCH_RESULT_ENTRY;



  /** The "plugin-order-search-result-reference" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_SEARCH_RESULT_REFERENCE;



  /** The "plugin-order-shutdown" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_SHUTDOWN;



  /** The "plugin-order-startup" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_STARTUP;



  /** The "plugin-order-subordinate-delete" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_SUBORDINATE_DELETE;



  /** The "plugin-order-subordinate-modify-dn" property definition. */
  private static final StringPropertyDefinition PD_PLUGIN_ORDER_SUBORDINATE_MODIFY_DN;



  /** The "plugins" relation definition. */
  private static final InstantiableRelationDefinition<PluginCfgClient, PluginCfg> RD_PLUGINS;



  /** Build the "plugin-order-intermediate-response" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-intermediate-response");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-intermediate-response"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-intermediate-response"));
      PD_PLUGIN_ORDER_INTERMEDIATE_RESPONSE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_INTERMEDIATE_RESPONSE);
  }



  /** Build the "plugin-order-ldif-export" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-ldif-export");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-ldif-export"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-ldif-export"));
      PD_PLUGIN_ORDER_LDIF_EXPORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_LDIF_EXPORT);
  }



  /** Build the "plugin-order-ldif-import" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-ldif-import");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-ldif-import"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-ldif-import"));
      PD_PLUGIN_ORDER_LDIF_IMPORT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_LDIF_IMPORT);
  }



  /** Build the "plugin-order-ldif-import-begin" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-ldif-import-begin");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-ldif-import-begin"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-ldif-import-begin"));
      PD_PLUGIN_ORDER_LDIF_IMPORT_BEGIN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_LDIF_IMPORT_BEGIN);
  }



  /** Build the "plugin-order-ldif-import-end" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-ldif-import-end");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-ldif-import-end"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-ldif-import-end"));
      PD_PLUGIN_ORDER_LDIF_IMPORT_END = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_LDIF_IMPORT_END);
  }



  /** Build the "plugin-order-post-connect" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-connect");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-connect"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-connect"));
      PD_PLUGIN_ORDER_POST_CONNECT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_CONNECT);
  }



  /** Build the "plugin-order-post-disconnect" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-disconnect");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-disconnect"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-disconnect"));
      PD_PLUGIN_ORDER_POST_DISCONNECT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_DISCONNECT);
  }



  /** Build the "plugin-order-post-operation-abandon" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-abandon");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-abandon"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-abandon"));
      PD_PLUGIN_ORDER_POST_OPERATION_ABANDON = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_ABANDON);
  }



  /** Build the "plugin-order-post-operation-add" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-add"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-add"));
      PD_PLUGIN_ORDER_POST_OPERATION_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_ADD);
  }



  /** Build the "plugin-order-post-operation-bind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-bind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-bind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-bind"));
      PD_PLUGIN_ORDER_POST_OPERATION_BIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_BIND);
  }



  /** Build the "plugin-order-post-operation-compare" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-compare");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-compare"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-compare"));
      PD_PLUGIN_ORDER_POST_OPERATION_COMPARE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_COMPARE);
  }



  /** Build the "plugin-order-post-operation-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-delete"));
      PD_PLUGIN_ORDER_POST_OPERATION_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_DELETE);
  }



  /** Build the "plugin-order-post-operation-extended" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-extended");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-extended"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-extended"));
      PD_PLUGIN_ORDER_POST_OPERATION_EXTENDED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_EXTENDED);
  }



  /** Build the "plugin-order-post-operation-modify" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-modify");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-modify"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-modify"));
      PD_PLUGIN_ORDER_POST_OPERATION_MODIFY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_MODIFY);
  }



  /** Build the "plugin-order-post-operation-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-modify-dn"));
      PD_PLUGIN_ORDER_POST_OPERATION_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_MODIFY_DN);
  }



  /** Build the "plugin-order-post-operation-search" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-search");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-search"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-search"));
      PD_PLUGIN_ORDER_POST_OPERATION_SEARCH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_SEARCH);
  }



  /** Build the "plugin-order-post-operation-unbind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-operation-unbind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-operation-unbind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-operation-unbind"));
      PD_PLUGIN_ORDER_POST_OPERATION_UNBIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_OPERATION_UNBIND);
  }



  /** Build the "plugin-order-post-response-add" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-add"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-add"));
      PD_PLUGIN_ORDER_POST_RESPONSE_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_ADD);
  }



  /** Build the "plugin-order-post-response-bind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-bind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-bind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-bind"));
      PD_PLUGIN_ORDER_POST_RESPONSE_BIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_BIND);
  }



  /** Build the "plugin-order-post-response-compare" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-compare");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-compare"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-compare"));
      PD_PLUGIN_ORDER_POST_RESPONSE_COMPARE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_COMPARE);
  }



  /** Build the "plugin-order-post-response-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-delete"));
      PD_PLUGIN_ORDER_POST_RESPONSE_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_DELETE);
  }



  /** Build the "plugin-order-post-response-extended" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-extended");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-extended"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-extended"));
      PD_PLUGIN_ORDER_POST_RESPONSE_EXTENDED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_EXTENDED);
  }



  /** Build the "plugin-order-post-response-modify" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-modify");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-modify"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-modify"));
      PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY);
  }



  /** Build the "plugin-order-post-response-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-modify-dn"));
      PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY_DN);
  }



  /** Build the "plugin-order-post-response-search" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-response-search");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-response-search"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-response-search"));
      PD_PLUGIN_ORDER_POST_RESPONSE_SEARCH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_RESPONSE_SEARCH);
  }



  /** Build the "plugin-order-post-synchronization-add" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-synchronization-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-synchronization-add"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-synchronization-add"));
      PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_ADD);
  }



  /** Build the "plugin-order-post-synchronization-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-synchronization-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-synchronization-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-synchronization-delete"));
      PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_DELETE);
  }



  /** Build the "plugin-order-post-synchronization-modify" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-synchronization-modify");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-synchronization-modify"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-synchronization-modify"));
      PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY);
  }



  /** Build the "plugin-order-post-synchronization-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-post-synchronization-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-post-synchronization-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-post-synchronization-modify-dn"));
      PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY_DN);
  }



  /** Build the "plugin-order-pre-operation-add" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-add"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-add"));
      PD_PLUGIN_ORDER_PRE_OPERATION_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_ADD);
  }



  /** Build the "plugin-order-pre-operation-bind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-bind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-bind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-bind"));
      PD_PLUGIN_ORDER_PRE_OPERATION_BIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_BIND);
  }



  /** Build the "plugin-order-pre-operation-compare" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-compare");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-compare"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-compare"));
      PD_PLUGIN_ORDER_PRE_OPERATION_COMPARE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_COMPARE);
  }



  /** Build the "plugin-order-pre-operation-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-delete"));
      PD_PLUGIN_ORDER_PRE_OPERATION_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_DELETE);
  }



  /** Build the "plugin-order-pre-operation-extended" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-extended");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-extended"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-extended"));
      PD_PLUGIN_ORDER_PRE_OPERATION_EXTENDED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_EXTENDED);
  }



  /** Build the "plugin-order-pre-operation-modify" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-modify");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-modify"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-modify"));
      PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY);
  }



  /** Build the "plugin-order-pre-operation-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-modify-dn"));
      PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY_DN);
  }



  /** Build the "plugin-order-pre-operation-search" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-operation-search");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-operation-search"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-operation-search"));
      PD_PLUGIN_ORDER_PRE_OPERATION_SEARCH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_OPERATION_SEARCH);
  }



  /** Build the "plugin-order-pre-parse-abandon" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-abandon");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-abandon"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-abandon"));
      PD_PLUGIN_ORDER_PRE_PARSE_ABANDON = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_ABANDON);
  }



  /** Build the "plugin-order-pre-parse-add" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-add");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-add"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-add"));
      PD_PLUGIN_ORDER_PRE_PARSE_ADD = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_ADD);
  }



  /** Build the "plugin-order-pre-parse-bind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-bind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-bind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-bind"));
      PD_PLUGIN_ORDER_PRE_PARSE_BIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_BIND);
  }



  /** Build the "plugin-order-pre-parse-compare" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-compare");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-compare"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-compare"));
      PD_PLUGIN_ORDER_PRE_PARSE_COMPARE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_COMPARE);
  }



  /** Build the "plugin-order-pre-parse-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-delete"));
      PD_PLUGIN_ORDER_PRE_PARSE_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_DELETE);
  }



  /** Build the "plugin-order-pre-parse-extended" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-extended");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-extended"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-extended"));
      PD_PLUGIN_ORDER_PRE_PARSE_EXTENDED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_EXTENDED);
  }



  /** Build the "plugin-order-pre-parse-modify" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-modify");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-modify"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-modify"));
      PD_PLUGIN_ORDER_PRE_PARSE_MODIFY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_MODIFY);
  }



  /** Build the "plugin-order-pre-parse-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-modify-dn"));
      PD_PLUGIN_ORDER_PRE_PARSE_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_MODIFY_DN);
  }



  /** Build the "plugin-order-pre-parse-search" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-search");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-search"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-search"));
      PD_PLUGIN_ORDER_PRE_PARSE_SEARCH = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_SEARCH);
  }



  /** Build the "plugin-order-pre-parse-unbind" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-pre-parse-unbind");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-pre-parse-unbind"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-pre-parse-unbind"));
      PD_PLUGIN_ORDER_PRE_PARSE_UNBIND = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_PRE_PARSE_UNBIND);
  }



  /** Build the "plugin-order-search-result-entry" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-search-result-entry");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-search-result-entry"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-search-result-entry"));
      PD_PLUGIN_ORDER_SEARCH_RESULT_ENTRY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_SEARCH_RESULT_ENTRY);
  }



  /** Build the "plugin-order-search-result-reference" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-search-result-reference");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-search-result-reference"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-search-result-reference"));
      PD_PLUGIN_ORDER_SEARCH_RESULT_REFERENCE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_SEARCH_RESULT_REFERENCE);
  }



  /** Build the "plugin-order-shutdown" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-shutdown");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-shutdown"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-shutdown"));
      PD_PLUGIN_ORDER_SHUTDOWN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_SHUTDOWN);
  }



  /** Build the "plugin-order-startup" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-startup");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-startup"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-startup"));
      PD_PLUGIN_ORDER_STARTUP = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_STARTUP);
  }



  /** Build the "plugin-order-subordinate-delete" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-subordinate-delete");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-subordinate-delete"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-subordinate-delete"));
      PD_PLUGIN_ORDER_SUBORDINATE_DELETE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_SUBORDINATE_DELETE);
  }



  /** Build the "plugin-order-subordinate-modify-dn" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "plugin-order-subordinate-modify-dn");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "plugin-order-subordinate-modify-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "plugin-order-subordinate-modify-dn"));
      PD_PLUGIN_ORDER_SUBORDINATE_MODIFY_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_PLUGIN_ORDER_SUBORDINATE_MODIFY_DN);
  }



  // Build the "plugins" relation definition.
  static {
    InstantiableRelationDefinition.Builder<PluginCfgClient, PluginCfg> builder =
      new InstantiableRelationDefinition.Builder<PluginCfgClient, PluginCfg>(INSTANCE, "plugin", "plugins", PluginCfgDefn.getInstance());
    RD_PLUGINS = builder.getInstance();
    INSTANCE.registerRelationDefinition(RD_PLUGINS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the Plugin Root configuration definition singleton.
   *
   * @return Returns the Plugin Root configuration definition
   *         singleton.
   */
  public static PluginRootCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private PluginRootCfgDefn() {
    super("plugin-root", TopCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public PluginRootCfgClient createClientConfiguration(
      ManagedObject<? extends PluginRootCfgClient> impl) {
    return new PluginRootCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public PluginRootCfg createServerConfiguration(
      ServerManagedObject<? extends PluginRootCfg> impl) {
    return new PluginRootCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<PluginRootCfg> getServerConfigurationClass() {
    return PluginRootCfg.class;
  }



  /**
   * Get the "plugin-order-intermediate-response" property definition.
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
   * @return Returns the "plugin-order-intermediate-response" property definition.
   */
  public StringPropertyDefinition getPluginOrderIntermediateResponsePropertyDefinition() {
    return PD_PLUGIN_ORDER_INTERMEDIATE_RESPONSE;
  }



  /**
   * Get the "plugin-order-ldif-export" property definition.
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
   * @return Returns the "plugin-order-ldif-export" property definition.
   */
  public StringPropertyDefinition getPluginOrderLDIFExportPropertyDefinition() {
    return PD_PLUGIN_ORDER_LDIF_EXPORT;
  }



  /**
   * Get the "plugin-order-ldif-import" property definition.
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
   * @return Returns the "plugin-order-ldif-import" property definition.
   */
  public StringPropertyDefinition getPluginOrderLDIFImportPropertyDefinition() {
    return PD_PLUGIN_ORDER_LDIF_IMPORT;
  }



  /**
   * Get the "plugin-order-ldif-import-begin" property definition.
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
   * @return Returns the "plugin-order-ldif-import-begin" property definition.
   */
  public StringPropertyDefinition getPluginOrderLDIFImportBeginPropertyDefinition() {
    return PD_PLUGIN_ORDER_LDIF_IMPORT_BEGIN;
  }



  /**
   * Get the "plugin-order-ldif-import-end" property definition.
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
   * @return Returns the "plugin-order-ldif-import-end" property definition.
   */
  public StringPropertyDefinition getPluginOrderLDIFImportEndPropertyDefinition() {
    return PD_PLUGIN_ORDER_LDIF_IMPORT_END;
  }



  /**
   * Get the "plugin-order-post-connect" property definition.
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
   * @return Returns the "plugin-order-post-connect" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostConnectPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_CONNECT;
  }



  /**
   * Get the "plugin-order-post-disconnect" property definition.
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
   * @return Returns the "plugin-order-post-disconnect" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostDisconnectPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_DISCONNECT;
  }



  /**
   * Get the "plugin-order-post-operation-abandon" property definition.
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
   * @return Returns the "plugin-order-post-operation-abandon" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationAbandonPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_ABANDON;
  }



  /**
   * Get the "plugin-order-post-operation-add" property definition.
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
   * @return Returns the "plugin-order-post-operation-add" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationAddPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_ADD;
  }



  /**
   * Get the "plugin-order-post-operation-bind" property definition.
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
   * @return Returns the "plugin-order-post-operation-bind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationBindPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_BIND;
  }



  /**
   * Get the "plugin-order-post-operation-compare" property definition.
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
   * @return Returns the "plugin-order-post-operation-compare" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationComparePropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_COMPARE;
  }



  /**
   * Get the "plugin-order-post-operation-delete" property definition.
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
   * @return Returns the "plugin-order-post-operation-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_DELETE;
  }



  /**
   * Get the "plugin-order-post-operation-extended" property definition.
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
   * @return Returns the "plugin-order-post-operation-extended" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationExtendedPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_EXTENDED;
  }



  /**
   * Get the "plugin-order-post-operation-modify" property definition.
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
   * @return Returns the "plugin-order-post-operation-modify" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationModifyPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_MODIFY;
  }



  /**
   * Get the "plugin-order-post-operation-modify-dn" property definition.
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
   * @return Returns the "plugin-order-post-operation-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_MODIFY_DN;
  }



  /**
   * Get the "plugin-order-post-operation-search" property definition.
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
   * @return Returns the "plugin-order-post-operation-search" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationSearchPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_SEARCH;
  }



  /**
   * Get the "plugin-order-post-operation-unbind" property definition.
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
   * @return Returns the "plugin-order-post-operation-unbind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostOperationUnbindPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_OPERATION_UNBIND;
  }



  /**
   * Get the "plugin-order-post-response-add" property definition.
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
   * @return Returns the "plugin-order-post-response-add" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseAddPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_ADD;
  }



  /**
   * Get the "plugin-order-post-response-bind" property definition.
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
   * @return Returns the "plugin-order-post-response-bind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseBindPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_BIND;
  }



  /**
   * Get the "plugin-order-post-response-compare" property definition.
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
   * @return Returns the "plugin-order-post-response-compare" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseComparePropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_COMPARE;
  }



  /**
   * Get the "plugin-order-post-response-delete" property definition.
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
   * @return Returns the "plugin-order-post-response-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_DELETE;
  }



  /**
   * Get the "plugin-order-post-response-extended" property definition.
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
   * @return Returns the "plugin-order-post-response-extended" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseExtendedPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_EXTENDED;
  }



  /**
   * Get the "plugin-order-post-response-modify" property definition.
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
   * @return Returns the "plugin-order-post-response-modify" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseModifyPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY;
  }



  /**
   * Get the "plugin-order-post-response-modify-dn" property definition.
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
   * @return Returns the "plugin-order-post-response-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_MODIFY_DN;
  }



  /**
   * Get the "plugin-order-post-response-search" property definition.
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
   * @return Returns the "plugin-order-post-response-search" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostResponseSearchPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_RESPONSE_SEARCH;
  }



  /**
   * Get the "plugin-order-post-synchronization-add" property definition.
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
   * @return Returns the "plugin-order-post-synchronization-add" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostSynchronizationAddPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_ADD;
  }



  /**
   * Get the "plugin-order-post-synchronization-delete" property definition.
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
   * @return Returns the "plugin-order-post-synchronization-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostSynchronizationDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_DELETE;
  }



  /**
   * Get the "plugin-order-post-synchronization-modify" property definition.
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
   * @return Returns the "plugin-order-post-synchronization-modify" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostSynchronizationModifyPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY;
  }



  /**
   * Get the "plugin-order-post-synchronization-modify-dn" property definition.
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
   * @return Returns the "plugin-order-post-synchronization-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderPostSynchronizationModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_POST_SYNCHRONIZATION_MODIFY_DN;
  }



  /**
   * Get the "plugin-order-pre-operation-add" property definition.
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
   * @return Returns the "plugin-order-pre-operation-add" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationAddPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_ADD;
  }



  /**
   * Get the "plugin-order-pre-operation-bind" property definition.
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
   * @return Returns the "plugin-order-pre-operation-bind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationBindPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_BIND;
  }



  /**
   * Get the "plugin-order-pre-operation-compare" property definition.
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
   * @return Returns the "plugin-order-pre-operation-compare" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationComparePropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_COMPARE;
  }



  /**
   * Get the "plugin-order-pre-operation-delete" property definition.
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
   * @return Returns the "plugin-order-pre-operation-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_DELETE;
  }



  /**
   * Get the "plugin-order-pre-operation-extended" property definition.
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
   * @return Returns the "plugin-order-pre-operation-extended" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationExtendedPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_EXTENDED;
  }



  /**
   * Get the "plugin-order-pre-operation-modify" property definition.
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
   * @return Returns the "plugin-order-pre-operation-modify" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationModifyPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY;
  }



  /**
   * Get the "plugin-order-pre-operation-modify-dn" property definition.
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
   * @return Returns the "plugin-order-pre-operation-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_MODIFY_DN;
  }



  /**
   * Get the "plugin-order-pre-operation-search" property definition.
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
   * @return Returns the "plugin-order-pre-operation-search" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreOperationSearchPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_OPERATION_SEARCH;
  }



  /**
   * Get the "plugin-order-pre-parse-abandon" property definition.
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
   * @return Returns the "plugin-order-pre-parse-abandon" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseAbandonPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_ABANDON;
  }



  /**
   * Get the "plugin-order-pre-parse-add" property definition.
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
   * @return Returns the "plugin-order-pre-parse-add" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseAddPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_ADD;
  }



  /**
   * Get the "plugin-order-pre-parse-bind" property definition.
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
   * @return Returns the "plugin-order-pre-parse-bind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseBindPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_BIND;
  }



  /**
   * Get the "plugin-order-pre-parse-compare" property definition.
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
   * @return Returns the "plugin-order-pre-parse-compare" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseComparePropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_COMPARE;
  }



  /**
   * Get the "plugin-order-pre-parse-delete" property definition.
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
   * @return Returns the "plugin-order-pre-parse-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_DELETE;
  }



  /**
   * Get the "plugin-order-pre-parse-extended" property definition.
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
   * @return Returns the "plugin-order-pre-parse-extended" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseExtendedPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_EXTENDED;
  }



  /**
   * Get the "plugin-order-pre-parse-modify" property definition.
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
   * @return Returns the "plugin-order-pre-parse-modify" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseModifyPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_MODIFY;
  }



  /**
   * Get the "plugin-order-pre-parse-modify-dn" property definition.
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
   * @return Returns the "plugin-order-pre-parse-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_MODIFY_DN;
  }



  /**
   * Get the "plugin-order-pre-parse-search" property definition.
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
   * @return Returns the "plugin-order-pre-parse-search" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseSearchPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_SEARCH;
  }



  /**
   * Get the "plugin-order-pre-parse-unbind" property definition.
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
   * @return Returns the "plugin-order-pre-parse-unbind" property definition.
   */
  public StringPropertyDefinition getPluginOrderPreParseUnbindPropertyDefinition() {
    return PD_PLUGIN_ORDER_PRE_PARSE_UNBIND;
  }



  /**
   * Get the "plugin-order-search-result-entry" property definition.
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
   * @return Returns the "plugin-order-search-result-entry" property definition.
   */
  public StringPropertyDefinition getPluginOrderSearchResultEntryPropertyDefinition() {
    return PD_PLUGIN_ORDER_SEARCH_RESULT_ENTRY;
  }



  /**
   * Get the "plugin-order-search-result-reference" property definition.
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
   * @return Returns the "plugin-order-search-result-reference" property definition.
   */
  public StringPropertyDefinition getPluginOrderSearchResultReferencePropertyDefinition() {
    return PD_PLUGIN_ORDER_SEARCH_RESULT_REFERENCE;
  }



  /**
   * Get the "plugin-order-shutdown" property definition.
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
   * @return Returns the "plugin-order-shutdown" property definition.
   */
  public StringPropertyDefinition getPluginOrderShutdownPropertyDefinition() {
    return PD_PLUGIN_ORDER_SHUTDOWN;
  }



  /**
   * Get the "plugin-order-startup" property definition.
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
   * @return Returns the "plugin-order-startup" property definition.
   */
  public StringPropertyDefinition getPluginOrderStartupPropertyDefinition() {
    return PD_PLUGIN_ORDER_STARTUP;
  }



  /**
   * Get the "plugin-order-subordinate-delete" property definition.
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
   * @return Returns the "plugin-order-subordinate-delete" property definition.
   */
  public StringPropertyDefinition getPluginOrderSubordinateDeletePropertyDefinition() {
    return PD_PLUGIN_ORDER_SUBORDINATE_DELETE;
  }



  /**
   * Get the "plugin-order-subordinate-modify-dn" property definition.
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
   * @return Returns the "plugin-order-subordinate-modify-dn" property definition.
   */
  public StringPropertyDefinition getPluginOrderSubordinateModifyDNPropertyDefinition() {
    return PD_PLUGIN_ORDER_SUBORDINATE_MODIFY_DN;
  }



  /**
   * Get the "plugins" relation definition.
   *
   * @return Returns the "plugins" relation definition.
   */
  public InstantiableRelationDefinition<PluginCfgClient,PluginCfg> getPluginsRelationDefinition() {
    return RD_PLUGINS;
  }



  /**
   * Managed object client implementation.
   */
  private static class PluginRootCfgClientImpl implements
    PluginRootCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends PluginRootCfgClient> impl;



    /** Private constructor. */
    private PluginRootCfgClientImpl(
        ManagedObject<? extends PluginRootCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public String getPluginOrderIntermediateResponse() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderIntermediateResponsePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderIntermediateResponse(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderIntermediateResponsePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFExport() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderLDIFExportPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderLDIFExport(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderLDIFExportPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImport() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderLDIFImport(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderLDIFImportPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImportBegin() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportBeginPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderLDIFImportBegin(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderLDIFImportBeginPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImportEnd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportEndPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderLDIFImportEnd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderLDIFImportEndPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostConnect() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostConnectPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostConnect(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostConnectPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostDisconnect() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostDisconnectPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostDisconnect(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostDisconnectPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationAbandon() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationAbandonPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationAbandon(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationAbandonPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationAdd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationAdd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationBind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationBindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationBind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationBindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationCompare() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationComparePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationCompare(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationComparePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationExtended() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationExtendedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationExtended(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationExtendedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationModify() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationModifyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationModify(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationModifyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationSearch() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationSearchPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationSearch(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationSearchPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationUnbind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationUnbindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostOperationUnbind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostOperationUnbindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseAdd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseAdd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseBind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseBindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseBind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseBindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseCompare() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseComparePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseCompare(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseComparePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseExtended() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseExtendedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseExtended(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseExtendedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseModify() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseModifyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseModify(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseModifyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseSearch() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseSearchPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostResponseSearch(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostResponseSearchPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationAdd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostSynchronizationAdd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostSynchronizationAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostSynchronizationDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostSynchronizationDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationModify() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostSynchronizationModify(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPostSynchronizationModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationAdd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationAdd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationBind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationBindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationBind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationBindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationCompare() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationComparePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationCompare(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationComparePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationExtended() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationExtendedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationExtended(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationExtendedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationModify() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationModifyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationModify(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationModifyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationSearch() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationSearchPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreOperationSearch(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreOperationSearchPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseAbandon() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseAbandonPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseAbandon(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseAbandonPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseAdd() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseAddPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseAdd(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseAddPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseBind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseBindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseBind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseBindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseCompare() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseComparePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseCompare(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseComparePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseExtended() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseExtendedPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseExtended(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseExtendedPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseModify() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseModifyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseModify(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseModifyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseSearch() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseSearchPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseSearch(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseSearchPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseUnbind() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderPreParseUnbindPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderPreParseUnbind(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderPreParseUnbindPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderSearchResultEntry() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderSearchResultEntryPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderSearchResultEntry(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderSearchResultEntryPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderSearchResultReference() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderSearchResultReferencePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderSearchResultReference(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderSearchResultReferencePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderShutdown() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderShutdownPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderShutdown(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderShutdownPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderStartup() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderStartupPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderStartup(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderStartupPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderSubordinateDelete() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderSubordinateDeletePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderSubordinateDelete(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderSubordinateDeletePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getPluginOrderSubordinateModifyDN() {
      return impl.getPropertyValue(INSTANCE.getPluginOrderSubordinateModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setPluginOrderSubordinateModifyDN(String value) {
      impl.setPropertyValue(INSTANCE.getPluginOrderSubordinateModifyDNPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String[] listPlugins() throws ConcurrentModificationException,
        LdapException {
      return impl.listChildren(INSTANCE.getPluginsRelationDefinition());
    }



    /** {@inheritDoc} */
    public PluginCfgClient getPlugin(String name)
        throws DefinitionDecodingException, ManagedObjectDecodingException,
        ManagedObjectNotFoundException, ConcurrentModificationException,
        LdapException {
      return impl.getChild(INSTANCE.getPluginsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public <M extends PluginCfgClient> M createPlugin(
        ManagedObjectDefinition<M, ? extends PluginCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException {
      return impl.createChild(INSTANCE.getPluginsRelationDefinition(), d, name, exceptions).getConfiguration();
    }



    /** {@inheritDoc} */
    public void removePlugin(String name)
        throws ManagedObjectNotFoundException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.removeChild(INSTANCE.getPluginsRelationDefinition(), name);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends PluginRootCfgClient, ? extends PluginRootCfg> definition() {
      return INSTANCE;
    }



    /** {@inheritDoc} */
    public PropertyProvider properties() {
      return impl;
    }



    /** {@inheritDoc} */
    public void commit() throws ManagedObjectAlreadyExistsException,
        MissingMandatoryPropertiesException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.commit();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }



  /**
   * Managed object server implementation.
   */
  private static class PluginRootCfgServerImpl implements
    PluginRootCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends PluginRootCfg> impl;

    /** The value of the "plugin-order-intermediate-response" property. */
    private final String pPluginOrderIntermediateResponse;

    /** The value of the "plugin-order-ldif-export" property. */
    private final String pPluginOrderLDIFExport;

    /** The value of the "plugin-order-ldif-import" property. */
    private final String pPluginOrderLDIFImport;

    /** The value of the "plugin-order-ldif-import-begin" property. */
    private final String pPluginOrderLDIFImportBegin;

    /** The value of the "plugin-order-ldif-import-end" property. */
    private final String pPluginOrderLDIFImportEnd;

    /** The value of the "plugin-order-post-connect" property. */
    private final String pPluginOrderPostConnect;

    /** The value of the "plugin-order-post-disconnect" property. */
    private final String pPluginOrderPostDisconnect;

    /** The value of the "plugin-order-post-operation-abandon" property. */
    private final String pPluginOrderPostOperationAbandon;

    /** The value of the "plugin-order-post-operation-add" property. */
    private final String pPluginOrderPostOperationAdd;

    /** The value of the "plugin-order-post-operation-bind" property. */
    private final String pPluginOrderPostOperationBind;

    /** The value of the "plugin-order-post-operation-compare" property. */
    private final String pPluginOrderPostOperationCompare;

    /** The value of the "plugin-order-post-operation-delete" property. */
    private final String pPluginOrderPostOperationDelete;

    /** The value of the "plugin-order-post-operation-extended" property. */
    private final String pPluginOrderPostOperationExtended;

    /** The value of the "plugin-order-post-operation-modify" property. */
    private final String pPluginOrderPostOperationModify;

    /** The value of the "plugin-order-post-operation-modify-dn" property. */
    private final String pPluginOrderPostOperationModifyDN;

    /** The value of the "plugin-order-post-operation-search" property. */
    private final String pPluginOrderPostOperationSearch;

    /** The value of the "plugin-order-post-operation-unbind" property. */
    private final String pPluginOrderPostOperationUnbind;

    /** The value of the "plugin-order-post-response-add" property. */
    private final String pPluginOrderPostResponseAdd;

    /** The value of the "plugin-order-post-response-bind" property. */
    private final String pPluginOrderPostResponseBind;

    /** The value of the "plugin-order-post-response-compare" property. */
    private final String pPluginOrderPostResponseCompare;

    /** The value of the "plugin-order-post-response-delete" property. */
    private final String pPluginOrderPostResponseDelete;

    /** The value of the "plugin-order-post-response-extended" property. */
    private final String pPluginOrderPostResponseExtended;

    /** The value of the "plugin-order-post-response-modify" property. */
    private final String pPluginOrderPostResponseModify;

    /** The value of the "plugin-order-post-response-modify-dn" property. */
    private final String pPluginOrderPostResponseModifyDN;

    /** The value of the "plugin-order-post-response-search" property. */
    private final String pPluginOrderPostResponseSearch;

    /** The value of the "plugin-order-post-synchronization-add" property. */
    private final String pPluginOrderPostSynchronizationAdd;

    /** The value of the "plugin-order-post-synchronization-delete" property. */
    private final String pPluginOrderPostSynchronizationDelete;

    /** The value of the "plugin-order-post-synchronization-modify" property. */
    private final String pPluginOrderPostSynchronizationModify;

    /** The value of the "plugin-order-post-synchronization-modify-dn" property. */
    private final String pPluginOrderPostSynchronizationModifyDN;

    /** The value of the "plugin-order-pre-operation-add" property. */
    private final String pPluginOrderPreOperationAdd;

    /** The value of the "plugin-order-pre-operation-bind" property. */
    private final String pPluginOrderPreOperationBind;

    /** The value of the "plugin-order-pre-operation-compare" property. */
    private final String pPluginOrderPreOperationCompare;

    /** The value of the "plugin-order-pre-operation-delete" property. */
    private final String pPluginOrderPreOperationDelete;

    /** The value of the "plugin-order-pre-operation-extended" property. */
    private final String pPluginOrderPreOperationExtended;

    /** The value of the "plugin-order-pre-operation-modify" property. */
    private final String pPluginOrderPreOperationModify;

    /** The value of the "plugin-order-pre-operation-modify-dn" property. */
    private final String pPluginOrderPreOperationModifyDN;

    /** The value of the "plugin-order-pre-operation-search" property. */
    private final String pPluginOrderPreOperationSearch;

    /** The value of the "plugin-order-pre-parse-abandon" property. */
    private final String pPluginOrderPreParseAbandon;

    /** The value of the "plugin-order-pre-parse-add" property. */
    private final String pPluginOrderPreParseAdd;

    /** The value of the "plugin-order-pre-parse-bind" property. */
    private final String pPluginOrderPreParseBind;

    /** The value of the "plugin-order-pre-parse-compare" property. */
    private final String pPluginOrderPreParseCompare;

    /** The value of the "plugin-order-pre-parse-delete" property. */
    private final String pPluginOrderPreParseDelete;

    /** The value of the "plugin-order-pre-parse-extended" property. */
    private final String pPluginOrderPreParseExtended;

    /** The value of the "plugin-order-pre-parse-modify" property. */
    private final String pPluginOrderPreParseModify;

    /** The value of the "plugin-order-pre-parse-modify-dn" property. */
    private final String pPluginOrderPreParseModifyDN;

    /** The value of the "plugin-order-pre-parse-search" property. */
    private final String pPluginOrderPreParseSearch;

    /** The value of the "plugin-order-pre-parse-unbind" property. */
    private final String pPluginOrderPreParseUnbind;

    /** The value of the "plugin-order-search-result-entry" property. */
    private final String pPluginOrderSearchResultEntry;

    /** The value of the "plugin-order-search-result-reference" property. */
    private final String pPluginOrderSearchResultReference;

    /** The value of the "plugin-order-shutdown" property. */
    private final String pPluginOrderShutdown;

    /** The value of the "plugin-order-startup" property. */
    private final String pPluginOrderStartup;

    /** The value of the "plugin-order-subordinate-delete" property. */
    private final String pPluginOrderSubordinateDelete;

    /** The value of the "plugin-order-subordinate-modify-dn" property. */
    private final String pPluginOrderSubordinateModifyDN;



    /** Private constructor. */
    private PluginRootCfgServerImpl(ServerManagedObject<? extends PluginRootCfg> impl) {
      this.impl = impl;
      this.pPluginOrderIntermediateResponse = impl.getPropertyValue(INSTANCE.getPluginOrderIntermediateResponsePropertyDefinition());
      this.pPluginOrderLDIFExport = impl.getPropertyValue(INSTANCE.getPluginOrderLDIFExportPropertyDefinition());
      this.pPluginOrderLDIFImport = impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportPropertyDefinition());
      this.pPluginOrderLDIFImportBegin = impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportBeginPropertyDefinition());
      this.pPluginOrderLDIFImportEnd = impl.getPropertyValue(INSTANCE.getPluginOrderLDIFImportEndPropertyDefinition());
      this.pPluginOrderPostConnect = impl.getPropertyValue(INSTANCE.getPluginOrderPostConnectPropertyDefinition());
      this.pPluginOrderPostDisconnect = impl.getPropertyValue(INSTANCE.getPluginOrderPostDisconnectPropertyDefinition());
      this.pPluginOrderPostOperationAbandon = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationAbandonPropertyDefinition());
      this.pPluginOrderPostOperationAdd = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationAddPropertyDefinition());
      this.pPluginOrderPostOperationBind = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationBindPropertyDefinition());
      this.pPluginOrderPostOperationCompare = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationComparePropertyDefinition());
      this.pPluginOrderPostOperationDelete = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationDeletePropertyDefinition());
      this.pPluginOrderPostOperationExtended = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationExtendedPropertyDefinition());
      this.pPluginOrderPostOperationModify = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationModifyPropertyDefinition());
      this.pPluginOrderPostOperationModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationModifyDNPropertyDefinition());
      this.pPluginOrderPostOperationSearch = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationSearchPropertyDefinition());
      this.pPluginOrderPostOperationUnbind = impl.getPropertyValue(INSTANCE.getPluginOrderPostOperationUnbindPropertyDefinition());
      this.pPluginOrderPostResponseAdd = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseAddPropertyDefinition());
      this.pPluginOrderPostResponseBind = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseBindPropertyDefinition());
      this.pPluginOrderPostResponseCompare = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseComparePropertyDefinition());
      this.pPluginOrderPostResponseDelete = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseDeletePropertyDefinition());
      this.pPluginOrderPostResponseExtended = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseExtendedPropertyDefinition());
      this.pPluginOrderPostResponseModify = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseModifyPropertyDefinition());
      this.pPluginOrderPostResponseModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseModifyDNPropertyDefinition());
      this.pPluginOrderPostResponseSearch = impl.getPropertyValue(INSTANCE.getPluginOrderPostResponseSearchPropertyDefinition());
      this.pPluginOrderPostSynchronizationAdd = impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationAddPropertyDefinition());
      this.pPluginOrderPostSynchronizationDelete = impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationDeletePropertyDefinition());
      this.pPluginOrderPostSynchronizationModify = impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyPropertyDefinition());
      this.pPluginOrderPostSynchronizationModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderPostSynchronizationModifyDNPropertyDefinition());
      this.pPluginOrderPreOperationAdd = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationAddPropertyDefinition());
      this.pPluginOrderPreOperationBind = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationBindPropertyDefinition());
      this.pPluginOrderPreOperationCompare = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationComparePropertyDefinition());
      this.pPluginOrderPreOperationDelete = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationDeletePropertyDefinition());
      this.pPluginOrderPreOperationExtended = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationExtendedPropertyDefinition());
      this.pPluginOrderPreOperationModify = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationModifyPropertyDefinition());
      this.pPluginOrderPreOperationModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationModifyDNPropertyDefinition());
      this.pPluginOrderPreOperationSearch = impl.getPropertyValue(INSTANCE.getPluginOrderPreOperationSearchPropertyDefinition());
      this.pPluginOrderPreParseAbandon = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseAbandonPropertyDefinition());
      this.pPluginOrderPreParseAdd = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseAddPropertyDefinition());
      this.pPluginOrderPreParseBind = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseBindPropertyDefinition());
      this.pPluginOrderPreParseCompare = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseComparePropertyDefinition());
      this.pPluginOrderPreParseDelete = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseDeletePropertyDefinition());
      this.pPluginOrderPreParseExtended = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseExtendedPropertyDefinition());
      this.pPluginOrderPreParseModify = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseModifyPropertyDefinition());
      this.pPluginOrderPreParseModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseModifyDNPropertyDefinition());
      this.pPluginOrderPreParseSearch = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseSearchPropertyDefinition());
      this.pPluginOrderPreParseUnbind = impl.getPropertyValue(INSTANCE.getPluginOrderPreParseUnbindPropertyDefinition());
      this.pPluginOrderSearchResultEntry = impl.getPropertyValue(INSTANCE.getPluginOrderSearchResultEntryPropertyDefinition());
      this.pPluginOrderSearchResultReference = impl.getPropertyValue(INSTANCE.getPluginOrderSearchResultReferencePropertyDefinition());
      this.pPluginOrderShutdown = impl.getPropertyValue(INSTANCE.getPluginOrderShutdownPropertyDefinition());
      this.pPluginOrderStartup = impl.getPropertyValue(INSTANCE.getPluginOrderStartupPropertyDefinition());
      this.pPluginOrderSubordinateDelete = impl.getPropertyValue(INSTANCE.getPluginOrderSubordinateDeletePropertyDefinition());
      this.pPluginOrderSubordinateModifyDN = impl.getPropertyValue(INSTANCE.getPluginOrderSubordinateModifyDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PluginRootCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PluginRootCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public String getPluginOrderIntermediateResponse() {
      return pPluginOrderIntermediateResponse;
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFExport() {
      return pPluginOrderLDIFExport;
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImport() {
      return pPluginOrderLDIFImport;
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImportBegin() {
      return pPluginOrderLDIFImportBegin;
    }



    /** {@inheritDoc} */
    public String getPluginOrderLDIFImportEnd() {
      return pPluginOrderLDIFImportEnd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostConnect() {
      return pPluginOrderPostConnect;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostDisconnect() {
      return pPluginOrderPostDisconnect;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationAbandon() {
      return pPluginOrderPostOperationAbandon;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationAdd() {
      return pPluginOrderPostOperationAdd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationBind() {
      return pPluginOrderPostOperationBind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationCompare() {
      return pPluginOrderPostOperationCompare;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationDelete() {
      return pPluginOrderPostOperationDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationExtended() {
      return pPluginOrderPostOperationExtended;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationModify() {
      return pPluginOrderPostOperationModify;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationModifyDN() {
      return pPluginOrderPostOperationModifyDN;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationSearch() {
      return pPluginOrderPostOperationSearch;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostOperationUnbind() {
      return pPluginOrderPostOperationUnbind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseAdd() {
      return pPluginOrderPostResponseAdd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseBind() {
      return pPluginOrderPostResponseBind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseCompare() {
      return pPluginOrderPostResponseCompare;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseDelete() {
      return pPluginOrderPostResponseDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseExtended() {
      return pPluginOrderPostResponseExtended;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseModify() {
      return pPluginOrderPostResponseModify;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseModifyDN() {
      return pPluginOrderPostResponseModifyDN;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostResponseSearch() {
      return pPluginOrderPostResponseSearch;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationAdd() {
      return pPluginOrderPostSynchronizationAdd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationDelete() {
      return pPluginOrderPostSynchronizationDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationModify() {
      return pPluginOrderPostSynchronizationModify;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPostSynchronizationModifyDN() {
      return pPluginOrderPostSynchronizationModifyDN;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationAdd() {
      return pPluginOrderPreOperationAdd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationBind() {
      return pPluginOrderPreOperationBind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationCompare() {
      return pPluginOrderPreOperationCompare;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationDelete() {
      return pPluginOrderPreOperationDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationExtended() {
      return pPluginOrderPreOperationExtended;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationModify() {
      return pPluginOrderPreOperationModify;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationModifyDN() {
      return pPluginOrderPreOperationModifyDN;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreOperationSearch() {
      return pPluginOrderPreOperationSearch;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseAbandon() {
      return pPluginOrderPreParseAbandon;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseAdd() {
      return pPluginOrderPreParseAdd;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseBind() {
      return pPluginOrderPreParseBind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseCompare() {
      return pPluginOrderPreParseCompare;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseDelete() {
      return pPluginOrderPreParseDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseExtended() {
      return pPluginOrderPreParseExtended;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseModify() {
      return pPluginOrderPreParseModify;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseModifyDN() {
      return pPluginOrderPreParseModifyDN;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseSearch() {
      return pPluginOrderPreParseSearch;
    }



    /** {@inheritDoc} */
    public String getPluginOrderPreParseUnbind() {
      return pPluginOrderPreParseUnbind;
    }



    /** {@inheritDoc} */
    public String getPluginOrderSearchResultEntry() {
      return pPluginOrderSearchResultEntry;
    }



    /** {@inheritDoc} */
    public String getPluginOrderSearchResultReference() {
      return pPluginOrderSearchResultReference;
    }



    /** {@inheritDoc} */
    public String getPluginOrderShutdown() {
      return pPluginOrderShutdown;
    }



    /** {@inheritDoc} */
    public String getPluginOrderStartup() {
      return pPluginOrderStartup;
    }



    /** {@inheritDoc} */
    public String getPluginOrderSubordinateDelete() {
      return pPluginOrderSubordinateDelete;
    }



    /** {@inheritDoc} */
    public String getPluginOrderSubordinateModifyDN() {
      return pPluginOrderSubordinateModifyDN;
    }



    /** {@inheritDoc} */
    public String[] listPlugins() {
      return impl.listChildren(INSTANCE.getPluginsRelationDefinition());
    }



    /** {@inheritDoc} */
    public PluginCfg getPlugin(String name) throws ConfigException {
      return impl.getChild(INSTANCE.getPluginsRelationDefinition(), name).getConfiguration();
    }



    /** {@inheritDoc} */
    public void addPluginAddListener(
        ConfigurationAddListener<PluginCfg> listener) throws ConfigException {
      impl.registerAddListener(INSTANCE.getPluginsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removePluginAddListener(
        ConfigurationAddListener<PluginCfg> listener) {
      impl.deregisterAddListener(INSTANCE.getPluginsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void addPluginDeleteListener(
        ConfigurationDeleteListener<PluginCfg> listener) throws ConfigException {
      impl.registerDeleteListener(INSTANCE.getPluginsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public void removePluginDeleteListener(
        ConfigurationDeleteListener<PluginCfg> listener) {
      impl.deregisterDeleteListener(INSTANCE.getPluginsRelationDefinition(), listener);
    }



    /** {@inheritDoc} */
    public Class<? extends PluginRootCfg> configurationClass() {
      return PluginRootCfg.class;
    }



    /** {@inheritDoc} */
    public DN dn() {
      return impl.getDN();
    }



    /** {@inheritDoc} */
    public String name() {
      return impl.getName();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }
}
