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
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.TopCfgDefn;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.server.config.client.AuthenticationPolicyCfgClient;
import org.forgerock.opendj.server.config.server.AuthenticationPolicyCfg;



/**
 * An interface for querying the Authentication Policy managed object
 * definition meta information.
 * <p>
 * Authentication Policies define the policies which should be used
 * for authenticating users and managing the password and other account
 * related state.
 */
public final class AuthenticationPolicyCfgDefn extends AbstractManagedObjectDefinition<AuthenticationPolicyCfgClient, AuthenticationPolicyCfg> {

  /** The singleton configuration definition instance. */
  private static final AuthenticationPolicyCfgDefn INSTANCE = new AuthenticationPolicyCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      builder.addInstanceOf("org.opends.server.api.AuthenticationPolicyFactory");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Authentication Policy configuration definition singleton.
   *
   * @return Returns the Authentication Policy configuration
   *         definition singleton.
   */
  public static AuthenticationPolicyCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private AuthenticationPolicyCfgDefn() {
    super("authentication-policy", TopCfgDefn.getInstance());
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class which
   * provides the Authentication Policy implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }
}
