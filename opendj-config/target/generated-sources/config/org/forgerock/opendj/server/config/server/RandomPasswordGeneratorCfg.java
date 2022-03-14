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



import java.util.SortedSet;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;



/**
 * A server-side interface for querying Random Password Generator
 * settings.
 * <p>
 * The Random Password Generator creates random passwords based on
 * fixed-length strings built from one or more character sets.
 */
public interface RandomPasswordGeneratorCfg extends PasswordGeneratorCfg {

  /**
   * Gets the configuration class associated with this Random Password Generator.
   *
   * @return Returns the configuration class associated with this Random Password Generator.
   */
  Class<? extends RandomPasswordGeneratorCfg> configurationClass();



  /**
   * Register to be notified when this Random Password Generator is changed.
   *
   * @param listener
   *          The Random Password Generator configuration change listener.
   */
  void addRandomChangeListener(ConfigurationChangeListener<RandomPasswordGeneratorCfg> listener);



  /**
   * Deregister an existing Random Password Generator configuration change listener.
   *
   * @param listener
   *          The Random Password Generator configuration change listener.
   */
  void removeRandomChangeListener(ConfigurationChangeListener<RandomPasswordGeneratorCfg> listener);



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Random Password Generator implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Gets the "password-character-set" property.
   * <p>
   * Specifies one or more named character sets.
   * <p>
   * This is a multi-valued property, with each value defining a
   * different character set. The format of the character set is the
   * name of the set followed by a colon and the characters that are in
   * that set. For example, the value
   * "alpha:abcdefghijklmnopqrstuvwxyz" defines a character set named
   * "alpha" containing all of the lower-case ASCII alphabetic
   * characters.
   *
   * @return Returns an unmodifiable set containing the values of the "password-character-set" property.
   */
  SortedSet<String> getPasswordCharacterSet();



  /**
   * Gets the "password-format" property.
   * <p>
   * Specifies the format to use for the generated password.
   * <p>
   * The value is a comma-delimited list of elements in which each of
   * those elements is comprised of the name of a character set defined
   * in the password-character-set property, a colon, and the number of
   * characters to include from that set. For example, a value of
   * "alpha:3,numeric:2,alpha:3" generates an 8-character password in
   * which the first three characters are from the "alpha" set, the
   * next two are from the "numeric" set, and the final three are from
   * the "alpha" set.
   *
   * @return Returns the value of the "password-format" property.
   */
  String getPasswordFormat();

}
