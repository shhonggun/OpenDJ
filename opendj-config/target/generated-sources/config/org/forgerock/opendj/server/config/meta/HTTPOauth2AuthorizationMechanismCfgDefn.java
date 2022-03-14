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



import org.forgerock.opendj.config.AbstractManagedObjectDefinition;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.conditions.Conditions;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DurationPropertyDefinition;
import org.forgerock.opendj.config.GenericConstraint;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.server.config.client.HTTPOauth2AuthorizationMechanismCfgClient;
import org.forgerock.opendj.server.config.client.IdentityMapperCfgClient;
import org.forgerock.opendj.server.config.server.HTTPOauth2AuthorizationMechanismCfg;
import org.forgerock.opendj.server.config.server.IdentityMapperCfg;



/**
 * An interface for querying the HTTP Oauth2 Authorization Mechanism
 * managed object definition meta information.
 * <p>
 * The HTTP Oauth2 Authorization Mechanism is used to define HTTP
 * OAuth2 authorization mechanism.
 */
public final class HTTPOauth2AuthorizationMechanismCfgDefn extends AbstractManagedObjectDefinition<HTTPOauth2AuthorizationMechanismCfgClient, HTTPOauth2AuthorizationMechanismCfg> {

  /** The singleton configuration definition instance. */
  private static final HTTPOauth2AuthorizationMechanismCfgDefn INSTANCE = new HTTPOauth2AuthorizationMechanismCfgDefn();



  /** The "access-token-cache-enabled" property definition. */
  private static final BooleanPropertyDefinition PD_ACCESS_TOKEN_CACHE_ENABLED;



  /** The "access-token-cache-expiration" property definition. */
  private static final DurationPropertyDefinition PD_ACCESS_TOKEN_CACHE_EXPIRATION;



  /** The "authzid-json-pointer" property definition. */
  private static final StringPropertyDefinition PD_AUTHZID_JSON_POINTER;



  /** The "identity-mapper" property definition. */
  private static final AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> PD_IDENTITY_MAPPER;



  /** The "required-scope" property definition. */
  private static final StringPropertyDefinition PD_REQUIRED_SCOPE;



  /** Build the "access-token-cache-enabled" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "access-token-cache-enabled");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "access-token-cache-enabled"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_ACCESS_TOKEN_CACHE_ENABLED = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ACCESS_TOKEN_CACHE_ENABLED);
  }



  /** Build the "access-token-cache-expiration" property definition. */
  static {
      DurationPropertyDefinition.Builder builder = DurationPropertyDefinition.createBuilder(INSTANCE, "access-token-cache-expiration");
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "access-token-cache-expiration"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<Long>());
      builder.setAllowUnlimited(false);
      builder.setBaseUnit("s");
      builder.setUpperLimit("2147483647");
      builder.setLowerLimit("0");
      PD_ACCESS_TOKEN_CACHE_EXPIRATION = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_ACCESS_TOKEN_CACHE_EXPIRATION);
  }



  /** Build the "authzid-json-pointer" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "authzid-json-pointer");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "authzid-json-pointer"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_AUTHZID_JSON_POINTER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_AUTHZID_JSON_POINTER);
  }



  /** Build the "identity-mapper" property definition. */
  static {
      AggregationPropertyDefinition.Builder<IdentityMapperCfgClient, IdentityMapperCfg> builder = AggregationPropertyDefinition.createBuilder(INSTANCE, "identity-mapper");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "identity-mapper"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.setParentPath("/");
      builder.setRelationDefinition("identity-mapper");
      builder.setTargetIsEnabledCondition(Conditions.contains("enabled", "true"));
      PD_IDENTITY_MAPPER = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_IDENTITY_MAPPER);
      INSTANCE.registerConstraint(PD_IDENTITY_MAPPER.getSourceConstraint());
  }



  /** Build the "required-scope" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "required-scope");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "required-scope"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_REQUIRED_SCOPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_REQUIRED_SCOPE);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
  }



  // Register the constraints associated with this managed object definition.
  static {
    INSTANCE.registerConstraint(new GenericConstraint(INSTANCE, 1, Conditions.implies(Conditions.contains("access-token-cache-enabled", "true"), Conditions.isPresent("access-token-cache-expiration"))));
  }



  /**
   * Get the HTTP Oauth2 Authorization Mechanism configuration
   * definition singleton.
   *
   * @return Returns the HTTP Oauth2 Authorization Mechanism
   *         configuration definition singleton.
   */
  public static HTTPOauth2AuthorizationMechanismCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private HTTPOauth2AuthorizationMechanismCfgDefn() {
    super("http-oauth2-authorization-mechanism", HTTPAuthorizationMechanismCfgDefn.getInstance());
  }



  /**
   * Get the "access-token-cache-enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Authorization Mechanism is
   * enabled for use.
   *
   * @return Returns the "access-token-cache-enabled" property definition.
   */
  public BooleanPropertyDefinition getAccessTokenCacheEnabledPropertyDefinition() {
    return PD_ACCESS_TOKEN_CACHE_ENABLED;
  }



  /**
   * Get the "access-token-cache-expiration" property definition.
   * <p>
   * Token cache expiration
   *
   * @return Returns the "access-token-cache-expiration" property definition.
   */
  public DurationPropertyDefinition getAccessTokenCacheExpirationPropertyDefinition() {
    return PD_ACCESS_TOKEN_CACHE_EXPIRATION;
  }



  /**
   * Get the "authzid-json-pointer" property definition.
   * <p>
   * Specifies the JSON pointer to the value to use as Authorization
   * ID. The JSON pointer is applied to the resolved access token JSON
   * document. (example: /uid)
   *
   * @return Returns the "authzid-json-pointer" property definition.
   */
  public StringPropertyDefinition getAuthzidJsonPointerPropertyDefinition() {
    return PD_AUTHZID_JSON_POINTER;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the HTTP Oauth2 Authorization Mechanism is
   * enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return HTTPAuthorizationMechanismCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "identity-mapper" property definition.
   * <p>
   * > Specifies the name of the identity mapper to use in conjunction
   * with the authzid-json-pointer to get the user corresponding to the
   * acccess-token.
   *
   * @return Returns the "identity-mapper" property definition.
   */
  public AggregationPropertyDefinition<IdentityMapperCfgClient, IdentityMapperCfg> getIdentityMapperPropertyDefinition() {
    return PD_IDENTITY_MAPPER;
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the HTTP Oauth2 Authorization Mechanism implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return HTTPAuthorizationMechanismCfgDefn.getInstance().getJavaClassPropertyDefinition();
  }



  /**
   * Get the "required-scope" property definition.
   * <p>
   * Scopes required to grant access to the service.
   *
   * @return Returns the "required-scope" property definition.
   */
  public StringPropertyDefinition getRequiredScopePropertyDefinition() {
    return PD_REQUIRED_SCOPE;
  }
}
