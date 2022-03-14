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



import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Similarity Based Password
 * Validator settings.
 * <p>
 * The Similarity Based Password Validator determines whether a
 * proposed password is acceptable by measuring how similar it is to
 * the user's current password.
 */
public interface SimilarityBasedPasswordValidatorCfg extends PasswordValidatorCfg {

  /**
   * Gets the configuration class associated with this Similarity Based Password Validator.
   *
   * @return Returns the configuration class associated with this Similarity Based Password Validator.
   */
  Class<? extends SimilarityBasedPasswordValidatorCfg> configurationClass();



  /**
   * Register to be notified when this Similarity Based Password Validator is changed.
   *
   * @param listener
   *          The Similarity Based Password Validator configuration change listener.
   */
  void addSimilarityBasedChangeListener(ConfigurationChangeListener<SimilarityBasedPasswordValidatorCfg> listener);



  /**
   * Deregister an existing Similarity Based Password Validator configuration change listener.
   *
   * @param listener
   *          The Similarity Based Password Validator configuration change listener.
   */
  void removeSimilarityBasedChangeListener(ConfigurationChangeListener<SimilarityBasedPasswordValidatorCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the password validator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "min-password-difference" property.
   * <p>
   * Specifies the minimum difference of new and old password.
   * <p>
   * A value of zero indicates that no difference between passwords is
   * acceptable.
   *
   * @return Returns the value of the "min-password-difference" property.
   */
  int getMinPasswordDifference();

}
