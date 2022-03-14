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
 * Copyright 2006-2009 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.server.util;

/**
 * This file contains a number of constants that are used throughout the
 * Directory Server source.  It was dynamically generated as part of the
 * Directory Server build process and should not be edited directly.
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.UNCOMMITTED,
     mayInstantiate=false,
     mayExtend=false,
     mayInvoke=true)
public final class DynamicConstants
{
  /** The official full product name for the Directory Server. */
  public static String PRODUCT_NAME = "ChaKanLDAP Server";
  /** The short product name for the Directory Server. */
  public static String SHORT_NAME = "ChakanLDAP";

  /** The major version number for the Directory Server. */
  public static int MAJOR_VERSION = 4;
  /** The minor version number for the Directory Server. */
  public static int MINOR_VERSION = 4;

  /** The point version number for the Directory Server. */
  public static int POINT_VERSION = 11;

  /** The official build number for the Directory Server. s*/
  public static int BUILD_NUMBER = 0;

  /** The version qualifier string for the Directory Server. */
  public static String VERSION_QUALIFIER = "";

  /** The set of bug IDs for fixes included in this build of the Directory Server. */
  public static String FIX_IDS = "";

  /** The build ID for the generated build of the Directory Server. */
  public static String BUILD_ID = "20220314103333";
  /** The username of the user that created this build. */
  public static String BUILD_USER = "홍군";
  /** The Java version used to generate this build. */
  public static String BUILD_JAVA_VERSION = "1.8.0_281";
  /** The vendor for the Java version used to generate this build. */
  public static String BUILD_JAVA_VENDOR = "Oracle Corporation";
  /** The JVM version used to generate this build. */
  public static String BUILD_JVM_VERSION = "25.281-b09";
  /** The vendor for the JVM used to generate this build. */
  public static String BUILD_JVM_VENDOR = "Oracle Corporation";
  /** The operating system on which this build was generated. */
  public static String BUILD_OS = "Windows 10 10.0 amd64";

  /**
   * Indicates whether this is a debug build of the Directory Server that may
   * include additional debugging facilities not available in standard release
   * versions.
   */
  public static boolean DEBUG_BUILD = false;

  /** The revision on which this build is based. */
  public static String REVISION = "c175f2ba986ea2510c5f7c34c3bfc07d92ead146";

  /** The version control url repository location on which this build is based. */
  public static String URL_REPOSITORY = "https://github.com/OpenIdentityPlatform/OpenDJ/opendj-server-legacy";
  /** The documentation home. */
  public static String DOC_REFERENCE_HOME = "${docHomepageUrl}";
  /** The documentation url. */
  public static String DOC_REFERENCE_WIKI = "${docWikiUrl}";
  /** The documentation url. */
  public static String DOC_QUICK_REFERENCE_GUIDE = "${docGuideRefUrl}";

   /** The administration guide. */
   public static String ADMINISTRATION_GUIDE_URL = "${docGuideAdminUrl}";

  /** A string representation of the version number. */
  public static String VERSION_NUMBER_STRING = String.format("%s.%s.%s", MAJOR_VERSION, MINOR_VERSION, POINT_VERSION);
  /** A string representation of the version number. */
  public static String OPENDJ_NUMBER_STRING = VERSION_NUMBER_STRING;
  /** A string representation of the release version. */
  public static String RELEASE_VERSION_STRING = OPENDJ_NUMBER_STRING;


  /**
   * Test if a specific class is provided to overwrite the BUILD definitions
   * By the release definitions provided by
   * org.opends.server.util.ReleaseDefinition
   */

  static {
     try {
        Class<?> c = Class.forName("org.opends.server.util.ReleaseDefinition");
        Object obj = c.newInstance();

        try {
         PRODUCT_NAME = (String)c.getField("PRODUCT_NAME").get(obj);
        }
        catch (Exception ex) {}
        try {
         SHORT_NAME = (String)c.getField("SHORT_NAME").get(obj);
        }
        catch (Exception ex) {}
        try {
         MAJOR_VERSION = (Integer)c.getField("MAJOR_VERSION").get(obj);
        }
        catch (Exception ex) {}
        try {
         MINOR_VERSION = (Integer)c.getField("MINOR_VERSION").get(obj);
        }
        catch (Exception ex) {}
        try {
         POINT_VERSION = (Integer)c.getField("POINT_VERSION").get(obj);
        }
        catch (Exception ex) {}
        try {
         BUILD_NUMBER = (Integer)c.getField("BUILD_NUMBER").get(obj);
        }
        catch (Exception ex) {}
        try {
         VERSION_QUALIFIER = (String)c.getField("VERSION_QUALIFIER").get(obj);
        }
        catch (Exception ex) {}
        try {
         FIX_IDS = (String)c.getField("FIX_IDS").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_ID = (String)c.getField("BUILD_ID").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_USER = (String)c.getField("BUILD_USER").get(obj);
        }
        catch (Exception ex) {}
        try{
         REVISION = (String)c.getField("REVISION_NUMBER").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_JAVA_VERSION = (String)c.getField("BUILD_JAVA_VERSION").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_JAVA_VENDOR = (String)c.getField("BUILD_JAVA_VENDOR").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_JVM_VERSION = (String)c.getField("BUILD_JVM_VERSION").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_JVM_VENDOR = (String)c.getField("BUILD_JVM_VENDOR").get(obj);
        }
        catch (Exception ex) {}
        try{
         BUILD_OS = (String)c.getField("BUILD_OS").get(obj);
        }
        catch (Exception ex) {}
        try{
         DEBUG_BUILD = (Boolean)c.getField("DEBUG_BUILD").get(obj);
        }
        catch (Exception ex) {}
        try{
         URL_REPOSITORY = (String)c.getField("URL_REPOSITORY").get(obj);
        }
        catch (Exception ex) {}
        try{
         DOC_REFERENCE_WIKI =
            (String)c.getField("DOC_REFERENCE_WIKI").get(obj);
        }
        catch(Exception ex) {}
        try{
         DOC_QUICK_REFERENCE_GUIDE =
            (String)c.getField("DOC_QUICK_REFERENCE_GUIDE").get(obj);
        }
        catch(Exception ex) {}
        try{
         ADMINISTRATION_GUIDE_URL =
           (String)c.getField("ADMINISTRATION_GUIDE_URL").get(obj);
        }
        catch(Exception ex) {}
        try{
         VERSION_NUMBER_STRING =
                 (String)c.getField("VERSION_NUMBER_STRING").get(obj);
        }
        catch (Exception ex) {}
        try{
         RELEASE_VERSION_STRING = VERSION_NUMBER_STRING
                 + " (OpenDJ version = "
                 + OPENDJ_NUMBER_STRING + ")" ;
        }
        catch (Exception ex) {}
      } catch (Exception ex) {}
  }

  /** A compact version string for this product, suitable for use in path names and similar cases. */
  public static String COMPACT_VERSION_STRING =
       SHORT_NAME + "-" + VERSION_NUMBER_STRING;

  /** A full version string for this product. */
  public static String FULL_VERSION_STRING = PRODUCT_NAME + " " + RELEASE_VERSION_STRING
      + (VERSION_QUALIFIER != null && !VERSION_QUALIFIER.isEmpty() ? "-" + VERSION_QUALIFIER : "")
      + (FIX_IDS != null && !FIX_IDS.isEmpty() ? "+" + FIX_IDS : "");

  /** A printable version string for this product. */
  public static final String PRINTABLE_VERSION_STRING =
       FULL_VERSION_STRING + System.getProperty("line.separator") +
       "Build " + BUILD_ID + System.getProperty("line.separator");
}
