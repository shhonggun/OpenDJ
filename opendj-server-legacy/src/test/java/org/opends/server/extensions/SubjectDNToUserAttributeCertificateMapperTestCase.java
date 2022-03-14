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
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.server.extensions;

import static org.forgerock.opendj.ldap.ModificationType.*;
import static org.forgerock.opendj.ldap.requests.Requests.*;
import static org.opends.server.TestCaseUtils.runLdapSearchTrustCertificateForSession;
import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.types.NullOutputStream.nullPrintStream;
import static org.testng.Assert.*;

import java.io.File;
import java.util.List;

import org.forgerock.opendj.config.server.ConfigException;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.server.config.meta.SubjectDNToUserAttributeCertificateMapperCfgDefn;
import org.opends.server.TestCaseUtils;
import org.opends.server.core.DirectoryServer;
import org.opends.server.core.ModifyOperation;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;
import org.opends.server.types.InitializationException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * A set of test cases for the Subject DN to User Attribute certificate mapper.
 */
public class SubjectDNToUserAttributeCertificateMapperTestCase
       extends ExtensionsTestCase
{
  /**
   * Ensures that the Directory Server is running.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @BeforeClass
  public void startServer()
         throws Exception
  {
    TestCaseUtils.startServer();
  }



  /**
   * Retrieves a set of invalid configurations that cannot be used to
   * initialize the certificate mapper.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @DataProvider(name = "invalidConfigs")
  public Object[][] getInvalidConfigurations() throws Exception
  {
    List<Entry> entries = TestCaseUtils.makeEntries(
      "dn: cn=No Subject Attr,cn=Certificate Mappers,cn=config",
      "objectClass: top",
      "objectClass: ds-cfg-certificate-mapper",
      "objectClass: ds-cfg-subject-dn-to-user-attribute-certificate-mapper",
      "cn: No Subject Attr",
      "ds-cfg-java-class: org.opends.server.extensions.SubjectDNToUserAttributeCertificateMapper",
      "ds-cfg-enabled: true",
      "",
      "dn: cn=Undefined Subject Attr,cn=Certificate Mappers,cn=config",
      "objectClass: top",
      "objectClass: ds-cfg-certificate-mapper",
      "objectClass: ds-cfg-subject-dn-to-user-attribute-certificate-mapper",
      "cn: Undefined Subject Attr",
      "ds-cfg-java-class: org.opends.server.extensions.SubjectDNToUserAttributeCertificateMapper",
      "ds-cfg-enabled: true",
      "ds-cfg-subject-attribute: undefined",
      "",
      "dn: cn=Invalid Base DN,cn=Certificate Mappers,cn=config",
      "objectClass: top",
      "objectClass: ds-cfg-certificate-mapper",
      "objectClass: ds-cfg-subject-dn-to-user-attribute-certificate-mapper",
      "cn: Invalid Base DN",
      "ds-cfg-java-class: org.opends.server.extensions.SubjectDNToUserAttributeCertificateMapper",
      "ds-cfg-enabled: true",
      "ds-cfg-subject-attribute: ds-certificate-subject-dn",
      "ds-cfg-user-base-dn: invalid");


    Object[][] configEntries = new Object[entries.size()][1];
    for (int i=0; i < configEntries.length; i++)
    {
      configEntries[i] = new Object[] { entries.get(i) };
    }

    return configEntries;
  }



  /**
   * Tests initialization with an invalid configuration.
   *
   * @param  e  The configuration entry to use to initialize the certificate
   *            mapper.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(dataProvider = "invalidConfigs",
        expectedExceptions = { ConfigException.class,
                               InitializationException.class })
  public void testInvalidConfigs(Entry e)
         throws Exception
  {
    InitializationUtils.initializeCertificateMapper(
                new SubjectDNToUserAttributeCertificateMapper(),
                e,
                SubjectDNToUserAttributeCertificateMapperCfgDefn.getInstance());
  }



  /**
   * Tests a successful mapping using the default configuration.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSuccessfulMappingDefaultConfig()
         throws Exception
  {
    enableMapper();

    try
    {
      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntry(
        "dn: uid=test.user,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "ds-certificate-subject-dn: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertEquals(runLdapSearchTrustCertificateForSession(args), 0);
    }
    finally
    {
      disableMapper();
    }
  }



  /**
   * Tests a successful mapping using a configuration with a different subject
   * attribute.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSuccessfulMappingAlternateSubjectAttribute()
         throws Exception
  {
    enableMapper();

    try
    {
      setSubjectAttribute("manager");

      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntry(
        "dn: uid=test.user,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "manager: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertEquals(runLdapSearchTrustCertificateForSession(args), 0);
    }
    finally
    {
      disableMapper();
      setSubjectAttribute("ds-certificate-subject-dn");
    }
  }



  /**
   * Tests a successful mapping using a configuration with a different set of
   * base DNs.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSuccessfulMappingAlternateBaseDNs()
         throws Exception
  {
    enableMapper();

    try
    {
      setBaseDNs(new String[] { "o=test" });

      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntry(
        "dn: uid=test.user,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "ds-certificate-subject-dn: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertEquals(runLdapSearchTrustCertificateForSession(args), 0);
    }
    finally
    {
      disableMapper();
      setSubjectAttribute("ds-certificate-subject-dn");
    }
  }



  /**
   * Tests a failed mapping when there are no users that should match.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testFailedMappingNoUsers()
         throws Exception
  {
    enableMapper();

    try
    {
      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntry(
        "dn: cn=Test User,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertFalse(runLdapSearchTrustCertificateForSession(args) == 0);
    }
    finally
    {
      disableMapper();
    }
  }



  /**
   * Tests a failed mapping when there are multiple users that match the
   * critieria.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testFailedMappingMultipleUsers()
         throws Exception
  {
    enableMapper();

    try
    {
      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntries(
        "dn: uid=test.user1,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user1",
        "givenName: Test",
        "sn: User",
        "cn: Test User 1",
        "ds-certificate-subject-dn: CN=Test User, O=Test",
        "",
        "dn: uid=test.user2,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user2",
        "givenName: Test",
        "sn: User",
        "cn: Test User 2",
        "ds-certificate-subject-dn: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertFalse(runLdapSearchTrustCertificateForSession(args) == 0);
    }
    finally
    {
      disableMapper();
    }
  }



  /**
   * Tests a failed mapping when there are no users below the configured base
   * DNs that match the criteria.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testFailedMappingNoUserBelowBaseDNs()
         throws Exception
  {
    enableMapper();

    try
    {
      setBaseDNs(new String[] { "dc=example,dc=com" });

      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntries(
        "dn: uid=test.user,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "ds-certificate-subject-dn: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "",
        "-s", "base",
        "(objectClass=*)"
      };

      assertFalse(runLdapSearchTrustCertificateForSession(nullPrintStream(), nullPrintStream(), args) == 0);
    }
    finally
    {
      disableMapper();
      setBaseDNs(null);
    }
  }



  /**
   * Tests to ensure that an attmept to remove the subject attribute will fail.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testRemoveSubjectAttribute()
         throws Exception
  {
    String mapperDN = "cn=Subject DN to User Attribute,cn=Certificate Mappers,cn=config";

    ModifyRequest modifyRequest = newModifyRequest(mapperDN)
        .addModification(DELETE, "ds-cfg-subject-attribute");
    ModifyOperation modifyOperation = getRootConnection().processModify(modifyRequest);
    assertNotSame(modifyOperation.getResultCode(), ResultCode.SUCCESS);
  }



  /**
   * Tests to ensure that an attempt to set an undefined subject attribute will fail.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { AssertionError.class })
  public void testSetUndefinedSubjectAttribute()
         throws Exception
  {
    setSubjectAttribute("undefined");
  }



  /**
   * Tests to ensure that an attempt to set an invalid base DN will fail.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(expectedExceptions = { AssertionError.class })
  public void testSetInvalidBaseDN()
         throws Exception
  {
    setBaseDNs(new String[] { "invalid" });
  }



  /**
   * Alters the configuration of the SASL EXTERNAL mechanism handler so that it
   * uses the Subject DN to User Attribute certificate mapper.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  private void enableMapper()
          throws Exception
  {
    String externalDN = "cn=EXTERNAL,cn=SASL Mechanisms,cn=config";
    String mapperDN = "cn=Subject DN to User Attribute,cn=Certificate Mappers,cn=config";

    assertModifyReplaceIsSuccess(externalDN, "ds-cfg-certificate-mapper", mapperDN);
  }



  /**
   * Alters the configuration of the SASL EXTERNAL mechanism handler so that it
   * uses the Subject Equals DN certificate mapper.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  private void disableMapper()
          throws Exception
  {
    String externalDN = "cn=EXTERNAL,cn=SASL Mechanisms,cn=config";
    String mapperDN = "cn=Subject Equals DN,cn=Certificate Mappers,cn=config";

    assertModifyReplaceIsSuccess(externalDN, "ds-cfg-certificate-mapper", mapperDN);
  }



  /**
   * Alters the configuration of the Subject DN to User Attribute certificate
   * mapper so that it will look for the subject DN in the specified attribute.
   *
   * @param  attrName  The name of the attribute in which to look for the
   *                   certificate subject.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  private void setSubjectAttribute(String attrName)
          throws Exception
  {
    String mapperDN = "cn=Subject DN to User Attribute,cn=Certificate Mappers,cn=config";

    assertModifyReplaceIsSuccess(mapperDN, "ds-cfg-subject-attribute", attrName);
  }



  /**
   * Alters the configuration of the Subject DN to User Attribute certificate
   * mapper so that it will look for the subject DN below the specified set of
   * base DNs.
   *
   * @param  baseDNs  The set of base DNs to use when mapping certificates to
   *                  users.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  private void setBaseDNs(Object[] baseDNs) throws Exception
  {
    String mapperDN = "cn=Subject DN to User Attribute,cn=Certificate Mappers,cn=config";

    assertModifyReplaceIsSuccess(mapperDN, "ds-cfg-user-base-dn", baseDNs);
  }

  /**
   * Tests a successful mapping using the default configuration, and
   * verify that user can do a privileged action (read config).
   * Verification for issue OPENDJ-459.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testPrivilegeWithSuccessfulMappingDefaultConfig() throws Exception
  {
    enableMapper();

    try
    {
      TestCaseUtils.initializeTestBackend(true);
      TestCaseUtils.addEntry(
        "dn: uid=test.user,o=test",
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "objectClass: ds-certificate-user",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "ds-privilege-name: config-read",
        "ds-certificate-subject-dn: CN=Test User, O=Test");



      String keyStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                            "config" + File.separator + "client.keystore";
      String trustStorePath = DirectoryServer.getInstanceRoot() + File.separator +
                              "config" + File.separator + "client.truststore";

      String[] args =
      {
        "--noPropertiesFile",
        "-h", "127.0.0.1",
        "-p", String.valueOf(TestCaseUtils.getServerLdapsPort()),
        "-Z",
        "-K", keyStorePath,
        "-W", "password",
        "-P", trustStorePath,
        "-o", "mech=EXTERNAL",
        "-N", "client-cert",
        "-b", "cn=config",
        "-s", "sub",
        "(objectClass=*)"
      };

      assertEquals(runLdapSearchTrustCertificateForSession(args), 0);
    }
    finally
    {
      disableMapper();
    }
  }

  private void assertModifyReplaceIsSuccess(String mapperDN, String attrName, Object... attrValues)
      throws DirectoryException
  {
    ModifyRequest modifyRequest = newModifyRequest(mapperDN);
    if (attrValues != null)
    {
      modifyRequest.addModification(REPLACE, attrName, attrValues);
    }
    else
    {
      modifyRequest.addModification(REPLACE, attrName);
    }
    ModifyOperation modifyOperation = getRootConnection().processModify(modifyRequest);
    assertEquals(modifyOperation.getResultCode(), ResultCode.SUCCESS);
  }
}
