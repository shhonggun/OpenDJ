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
 * Portions Copyright 2015 ForgeRock AS.
 */
package org.opends.server.util;



import java.io.File;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.forgerock.util.Reject;
import org.opends.server.TestCaseUtils;

import static org.testng.Assert.*;



/**
 * This class provides a test case that can be used to ensure that all source
 * packages also include a package-info.java file with javadoc and annotation
 * information about that package.
 */
public class PackageInfoTestCase
       extends UtilTestCase
{
  /** The directory that serves as the top-level source root. */
  private File sourceRoot;



  /**
   * Ensure that the source root directories are initialized properly.
   */
  @BeforeClass
  public void setUp()
  {
    String rootDir = System.getProperty(TestCaseUtils.PROPERTY_BUILD_ROOT);
    assertNotNull(rootDir);

    File buildRoot = new File(rootDir);
    assertTrue(buildRoot.exists());

    sourceRoot = new File(buildRoot, "src");
    assertTrue(sourceRoot.exists());
  }



  /**
   * Retrieves a set of File objects that point to directories that contain ADS
   * source.
   *
   * @return  A set of File objects that point to directories that contain ADS
   *          source.
   */
  @DataProvider(name = "adsSourceDirectories")
  public Object[][] getADSSourceDirectories()
  {
    File adsSourceRoot = new File(sourceRoot, "main/java/org/opends/admin/ads");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(adsSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Retrieves a set of File objects that point to directories that contain
   * admin source.
   *
   * @return  A set of File objects that point to directories that contain
   *          admin source.
   */
  @DataProvider(name = "adminSourceDirectories")
  public Object[][] getAdminSourceDirectories()
  {
    File adminSourceRoot = new File(sourceRoot, "admin");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(adminSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Retrieves a set of File objects that point to directories that contain
   * build tools source.
   *
   * @return  A set of File objects that point to directories that contain build
   *          tools source.
   */
  @DataProvider(name = "buildToolsSourceDirectories")
  public Object[][] getBuildToolsSourceDirectories()
  {
    File buildToolsSourceRoot = new File(sourceRoot, "build-tools");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(buildToolsSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Retrieves a set of File objects that point to directories that contain
   * GUI tools source.
   *
   * @return  A set of File objects that point to directories that contain
   *          GUI tools source.
   */
  @DataProvider(name = "guiToolsSourceDirectories")
  public Object[][] getGUIToolsSourceDirectories()
  {
    File guiToolsSourceRoot = new File(sourceRoot, "main/java/org/opends/guitools");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(guiToolsSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Retrieves a set of File objects that point to directories that contain
   * QuickSetup source.
   *
   * @return  A set of File objects that point to directories that contain
   *          server source.
   */
  @DataProvider(name = "quickSetupSourceDirectories")
  public Object[][] getQuickSetupSourceDirectories()
  {
    File quickSetupSourceRoot = new File(sourceRoot, "main/java/org/opends/quicksetup");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(quickSetupSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Retrieves a set of File objects that point to directories that contain
   * server source.
   *
   * @return  A set of File objects that point to directories that contain
   *          server source.
   */
  @DataProvider(name = "serverSourceDirectories")
  public Object[][] getServerSourceDirectories()
  {
    File serverSourceRoot = new File(sourceRoot, "main/java");
    ArrayList<File> sourceDirs = new ArrayList<>();
    getSourceDirectories(serverSourceRoot, sourceDirs);

    Object[][] returnArray = new Object[sourceDirs.size()][1];
    for (int i=0; i < returnArray.length; i++)
    {
      returnArray[i][0] = sourceDirs.get(i);
    }

    return returnArray;
  }



  /**
   * Recursively descends the filesystem structure, identifying directories that
   * contain Java source code and adding them to the provided list.
   *
   * @param  startingPoint      The directory that marks the starting point at
   *                            which to begin.
   * @param  sourceDirectories  The list of identified source directories, to
   *                            which any new source directories will be added.
   */
  private void getSourceDirectories(File startingPoint,
                                    ArrayList<File> sourceDirectories)
  {
    Reject.ifFalse(startingPoint.isDirectory(), startingPoint.getAbsolutePath() + " is not a directory.");
    boolean added = false;
    for (File f : startingPoint.listFiles())
    {
      if (f.isDirectory())
      {
        if (! f.getName().equals(".svn"))
        {
          getSourceDirectories(f, sourceDirectories);
        }
      }
      else if (f.isFile() && f.getName().endsWith(".java"))
      {
        if (! added)
        {
          sourceDirectories.add(startingPoint);
          added = true;
        }
      }
    }
  }



  /**
   * Ensure that all ADS source file packages include a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="adsSourceDirectories")
  public void testADSPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that all admin source file packages include a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="adminSourceDirectories")
  public void testAdminPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that all build tools source file packages include a
   * package-info.java file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="buildToolsSourceDirectories")
  public void testBuildToolsPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that all GUI tools source file packages include a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="guiToolsSourceDirectories")
  public void testGUIToolsPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that all QuickSetup source file packages include a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="quickSetupSourceDirectories")
  public void testQuickSetupPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that all server source file packages include a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory for which to make the determination.
   */
  @Test(dataProvider="serverSourceDirectories")
  public void testServerPackageInfoExists(File sourceDirectory)
         throws Exception
  {
    checkPackageInfoFileExistsInternal(sourceDirectory);
  }



  /**
   * Ensure that the provided source directory contains a package-info.java
   * file.
   *
   * @param  sourceDirectory  The directory in which to verify the existence of
   *                          a package-info.java file.
   */
  private void checkPackageInfoFileExistsInternal(File sourceDirectory)
  {
    assertTrue(sourceDirectory.exists());
    assertTrue(sourceDirectory.isDirectory());

    File packageInfoFile = new File(sourceDirectory, "package-info.java");
    assertTrue(packageInfoFile.exists(),
               "Source directory " + sourceDirectory.getAbsolutePath() +
               " does not contain a package-info.java file.");
  }
}

