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
 * Copyright 2008-2010 Sun Microsystems, Inc.
 * Portions Copyright 2012-2016 ForgeRock AS.
 */
package org.opends.server.extensions;

import java.util.List;

import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SearchScope;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.CoreSchema;
import org.opends.server.TestCaseUtils;
import org.opends.server.core.DeleteOperation;
import org.opends.server.core.DirectoryServer;
import org.opends.server.protocols.internal.InternalClientConnection;
import org.opends.server.protocols.internal.InternalSearchOperation;
import org.opends.server.protocols.internal.Requests;
import org.opends.server.protocols.internal.SearchRequest;
import com.forgerock.opendj.ldap.tools.LDAPModify;
import org.opends.server.types.Attribute;
import org.opends.server.types.VirtualAttributeRule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.protocols.internal.Requests.*;
import static org.opends.server.types.NullOutputStream.nullPrintStream;
import static org.testng.Assert.*;

/**
 * A set of test cases for the user-defined virtual attribute provider.
 */
public class UserDefinedVirtualAttributeProviderTestCase
       extends ExtensionsTestCase
{
  /** The attribute type for the description attribute. */
  private AttributeType descriptionType;


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

    descriptionType = CoreSchema.getDescriptionAttributeType();
  }



  /**
   * Tests the methods which are part of the virtual group API using a
   * single-valued virtual attribute.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testRuleAPISingleValued()
         throws Exception
  {
   String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
   TestCaseUtils.addEntry(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: real-overrides-virtual",
      "ds-cfg-value: single value");

    try
    {
      SearchRequest request = Requests.newSearchRequest(DN.valueOf(ruleDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation =
          new InternalSearchOperation(getRootConnection(), nextOperationID(), nextMessageID(), request);

      for (VirtualAttributeRule rule : DirectoryServer.getVirtualAttributes())
      {
        if (rule.getAttributeType().equals(descriptionType))
        {
          UserDefinedVirtualAttributeProvider provider =
              (UserDefinedVirtualAttributeProvider) rule.getProvider();

          assertFalse(provider.isMultiValued());
          assertFalse(provider.isSearchable(rule, searchOperation, false));
          assertFalse(provider.isSearchable(rule, searchOperation, true));

          provider.processSearch(rule, searchOperation);
          assertEquals(searchOperation.getResultCode(),
              ResultCode.UNWILLING_TO_PERFORM);
        }
      }
    }
    finally
    {
      DeleteOperation deleteOperation = getRootConnection().processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }



  /**
   * Tests the methods which are part of the virtual group API using a
   * multi-valued virtual attribute.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testRuleAPIMultiValued()
         throws Exception
  {
   String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
   TestCaseUtils.addEntry(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: real-overrides-virtual",
      "ds-cfg-value: first value",
      "ds-cfg-value: second value");

    try
    {
      SearchRequest request = Requests.newSearchRequest(DN.valueOf(ruleDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation =
          new InternalSearchOperation(getRootConnection(), nextOperationID(), nextMessageID(), request);

      for (VirtualAttributeRule rule : DirectoryServer.getVirtualAttributes())
      {
        if (rule.getAttributeType().equals(descriptionType))
        {
          UserDefinedVirtualAttributeProvider provider =
              (UserDefinedVirtualAttributeProvider) rule.getProvider();

          assertTrue(provider.isMultiValued());
          assertFalse(provider.isSearchable(rule, searchOperation, false));
          assertFalse(provider.isSearchable(rule, searchOperation, true));

          provider.processSearch(rule, searchOperation);
          assertEquals(searchOperation.getResultCode(),
              ResultCode.UNWILLING_TO_PERFORM);
        }
      }
    }
    finally
    {
      DeleteOperation deleteOperation = getRootConnection().processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }

  /**
   * Tests the creation of a description virtual attribute when there is only a
   * single virtual value and no real value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSingleDescriptionOnlyVirtual()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String value  = "This is the virtual value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: real-overrides-virtual",
      "ds-cfg-value: " + value,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test");

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request = newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute attr = attrList.get(0);
      assertEquals(attr.size(), 1);
      assertTrue(attr.contains(ByteString.valueOfUtf8(value)));
    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }



  /**
   * Tests the creation of a description virtual attribute when there are
   * multiple virtual values and no real value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testMultipleDescriptionsOnlyVirtual()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String value1 = "This is the first virtual value";
    String value2 = "This is the second virtual value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: real-overrides-virtual",
      "ds-cfg-value: " + value1,
      "ds-cfg-value: " + value2,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test");

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request = newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute attr = attrList.get(0);
      assertEquals(attr.size(), 2);
      assertTrue(attr.contains(ByteString.valueOfUtf8(value1)));
      assertTrue(attr.contains(ByteString.valueOfUtf8(value2)));
    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }



  /**
   * Tests the creation of a description virtual attribute when real values
   * should override virtual values and the entry has a real value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSingleDescriptionRealOverridesVirtual()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String virtualValue = "This is the virtual value";
    String realValue    = "This is the real value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: real-overrides-virtual",
      "ds-cfg-value: " + virtualValue,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test",
      "description: " + realValue);

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request = newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute attr = attrList.get(0);
      assertEquals(attr.size(), 1);
      assertTrue(attr.contains(ByteString.valueOfUtf8(realValue)));
    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }



  /**
   * Tests the creation of a description virtual attribute when virtual values
   * should override real values and the entry has a real value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSingleDescriptionVirtualOverridesReal()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String virtualValue = "This is the virtual value";
    String realValue    = "This is the real value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: virtual-overrides-real",
      "ds-cfg-value: " + virtualValue,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test",
      "description: " + realValue);

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request = newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute attr = attrList.get(0);
      assertEquals(attr.size(), 1);
      assertTrue(attr.contains(ByteString.valueOfUtf8(virtualValue)));
    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }


  /**
   * Tests the creation of a description virtual attribute when real and virtual
   * values should be merged and the entry has a real value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSingleDescriptionMergeRealAndVirtual()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String virtualValue = "This is the virtual value";
    String realValue    = "This is the real value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: merge-real-and-virtual",
      "ds-cfg-value: " + virtualValue,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test",
      "description: " + realValue);

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request = newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT);
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute a = attrList.get(0);
      assertEquals(a.size(), 2);

      assertTrue(a.contains(ByteString.valueOfUtf8(realValue)));
      assertTrue(a.contains(ByteString.valueOfUtf8(virtualValue)));

    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }



  /**
   * Tests the creation of a description virtual attribute when real and
   * virtual values should be merged and the entry has a real value.
   * <p>
   * Returning a subset of attributes is handled differently to all
   * attributes. This tests fix for issue 3779.
   *
   * @throws Exception
   *           If an unexpected problem occurs.
   */
  @Test
  public void testSingleDescriptionMergeRealAndVirtualWithAttrList()
         throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN = "uid=test.user,o=test";
    String virtualValue = "This is the virtual value";
    String realValue    = "This is the real value";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: true",
      "ds-cfg-attribute-type: description",
      "ds-cfg-conflict-behavior: merge-real-and-virtual",
      "ds-cfg-value: " + virtualValue,
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: test",
      "description: " + realValue);

    InternalClientConnection conn = getRootConnection();
    try
    {
      final SearchRequest request =
          newSearchRequest(DN.valueOf(userDN), SearchScope.BASE_OBJECT).addAttribute("description");
      InternalSearchOperation searchOperation = conn.processSearch(request);

      List<Attribute> attrList = searchOperation.getSearchEntries().get(0).getAllAttributes(descriptionType);
      assertEquals(attrList.size(), 1);

      Attribute a = attrList.get(0);
      assertEquals(a.size(), 2);

      assertTrue(a.contains(ByteString.valueOfUtf8(realValue)));
      assertTrue(a.contains(ByteString.valueOfUtf8(virtualValue)));
    }
    finally
    {
      DeleteOperation deleteOperation =
          conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }


  private void testSetupVirtualPasswordPolicyDN(String policyDN, String ruleDN) throws Exception
  {
    TestCaseUtils.addEntries(
            "dn: " + policyDN,
            "objectClass: top",
            "objectClass: ds-cfg-password-policy",
            "cn: Test Policy",
            "ds-cfg-password-attribute: userPassword",
            "ds-cfg-default-password-storage-scheme: " +
                    "cn=Salted SHA-1,cn=Password Storage Schemes,cn=config",
            "ds-cfg-allow-expired-password-changes: false",
            "ds-cfg-allow-multiple-password-values: false",
            "ds-cfg-allow-pre-encoded-passwords: false",
            "ds-cfg-allow-user-password-changes: true",
            "ds-cfg-expire-passwords-without-warning: false",
            "ds-cfg-force-change-on-add: false",
            "ds-cfg-force-change-on-reset: false",
            "ds-cfg-grace-login-count: 0",
            "ds-cfg-idle-lockout-interval: 0 seconds",
            "ds-cfg-lockout-failure-count: 0",
            "ds-cfg-lockout-duration: 0 seconds",
            "ds-cfg-lockout-failure-expiration-interval: 0 seconds",
            "ds-cfg-min-password-age: 0 seconds",
            "ds-cfg-max-password-age: 0 seconds",
            "ds-cfg-max-password-reset-age: 0 seconds",
            "ds-cfg-password-expiration-warning-interval: 5 days",
            "ds-cfg-password-change-requires-current-password: true",
            "ds-cfg-password-validator: cn=Length-Based Password Validator," +
                    "cn=Password Validators,cn=config",
            "ds-cfg-require-secure-authentication: false",
            "ds-cfg-require-secure-password-changes: false",
            "ds-cfg-skip-validation-for-administrators: false",
            "",
            "dn: " + ruleDN,
            "objectClass: top",
            "objectClass: ds-cfg-virtual-attribute",
            "objectClass: ds-cfg-user-defined-virtual-attribute",
            "cn: User-Defined Test",
            "ds-cfg-java-class: org.opends.server.extensions." +
                    "UserDefinedVirtualAttributeProvider",
            "ds-cfg-enabled: true",
            "ds-cfg-attribute-type: ds-pwp-password-policy-dn",
            "ds-cfg-conflict-behavior: merge-real-and-virtual",
            "ds-cfg-value: " + policyDN);
  }


  /**
   * Tests to ensure that the user-defined virtual attribute provider can be
   * used to apply a custom password policy for a user.  The custom password
   * policy will reject passwords shorter than six characters, whereas the
   * default policy will not.
   */
  @Test
  public void testVirtualPasswordPolicyDN() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String policyDN = "cn=Test Policy,cn=Password Policies,cn=config";
    String ruleDN   = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN   = "uid=test.user,o=test";

    testSetupVirtualPasswordPolicyDN(policyDN, ruleDN);
    try
    {
      assertEquals(TestCaseUtils.addEntryOperation(
              "dn: " + userDN,
              "objectClass: top",
              "objectClass: person",
              "objectClass: organizationalPerson",
              "objectClass: inetOrgPerson",
              "uid: test.user",
              "givenName: Test",
              "sn: User",
              "cn: Test User",
              "userPassword: testtest"),
              ResultCode.SUCCESS);

      String path1 =
          TestCaseUtils.createTempFile("dn: " + userDN,
              "changetype: modify", "replace: userPassword",
              "userPassword: short");

      String[] args1 =
          { "-h", "127.0.0.1", "-p",
              String.valueOf(TestCaseUtils.getServerLdapPort()), "-D",
              "cn=Directory Manager", "-w", "password", "-f", path1 };

      assertFalse(LDAPModify.run(nullPrintStream(), nullPrintStream(), args1) == 0);

      String path2 =
          TestCaseUtils.createTempFile("dn: " + ruleDN,
              "changetype: modify", "replace: ds-cfg-enabled",
              "ds-cfg-enabled: false");

      String[] args2 =
          new String[] { "-h", "127.0.0.1", "-p",
              String.valueOf(TestCaseUtils.getServerAdminPort()), "-Z",
              "-X", "-D", "cn=Directory Manager", "-w", "password",
              "-f", path2 };

      assertEquals(LDAPModify.run(nullPrintStream(), nullPrintStream(), args2), 0);
      assertEquals(LDAPModify.run(nullPrintStream(), nullPrintStream(), args1), 0);
    }
    finally
    {
      InternalClientConnection conn = getRootConnection();

      DeleteOperation deleteOperation = conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);

      deleteOperation = conn.processDelete(DN.valueOf(policyDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }


  /**
   * Tests to ensure that the user-defined virtual attribute provider can be used to apply a custom password
   * policy for a user. The custom password policy will reject passwords shorter than six characters,
   * whereas the default policy will not. This test verifies that adding a user with a short password fails.
   */
  @Test
  public void testVirtualPasswordPolicyDNForAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String policyDN = "cn=Test Policy,cn=Password Policies,cn=config";
    String ruleDN   = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";

    testSetupVirtualPasswordPolicyDN(policyDN, ruleDN);
    try {
      assertEquals(TestCaseUtils.addEntryOperation(
              "dn: uid=test.user,o=test",
              "objectClass: top",
              "objectClass: person",
              "objectClass: organizationalPerson",
              "objectClass: inetOrgPerson",
              "uid: test.user",
              "givenName: Test",
              "sn: User",
              "cn: Test User",
              "userPassword: test"
      ), ResultCode.CONSTRAINT_VIOLATION);
    }
    finally {
      InternalClientConnection conn = getRootConnection();

      DeleteOperation deleteOperation = conn.processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);

      deleteOperation = conn.processDelete(DN.valueOf(policyDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }


  /**
   * Tests to ensure that the user-defined virtual attribute provider can be
   * used to grant a privilege to a user.
   */
  @Test
  public void testVirtualPrivilege() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String ruleDN   = "cn=User-Defined Test,cn=Virtual Attributes,cn=config";
    String userDN   = "uid=test.user,o=test";

    TestCaseUtils.addEntries(
      "dn: " + ruleDN,
      "objectClass: top",
      "objectClass: ds-cfg-virtual-attribute",
      "objectClass: ds-cfg-user-defined-virtual-attribute",
      "cn: User-Defined Test",
      "ds-cfg-java-class: org.opends.server.extensions." +
           "UserDefinedVirtualAttributeProvider",
      "ds-cfg-enabled: false",
      "ds-cfg-attribute-type: ds-privilege-name",
      "ds-cfg-conflict-behavior: merge-real-and-virtual",
      "ds-cfg-value: bypass-acl",
      "",
      "dn: " + userDN,
      "objectClass: top",
      "objectClass: person",
      "objectClass: organizationalPerson",
      "objectClass: inetOrgPerson",
      "uid: test.user",
      "givenName: Test",
      "sn: User",
      "cn: Test User",
      "userPassword: password");

    try
    {
      String path1 =
          TestCaseUtils.createTempFile("dn: o=test",
              "changetype: modify", "replace: description",
              "description: foo");

      String[] args1 =
          { "-h", "127.0.0.1", "-p",
              String.valueOf(TestCaseUtils.getServerLdapPort()), "-D",
              userDN, "-w", "password", "-f", path1 };

      assertFalse(LDAPModify.run(nullPrintStream(), nullPrintStream(), args1) == 0);

      String path2 =
          TestCaseUtils.createTempFile("dn: " + ruleDN,
              "changetype: modify", "replace: ds-cfg-enabled",
              "ds-cfg-enabled: true");

      String[] args2 =
          new String[] { "-h", "127.0.0.1", "-p",
              String.valueOf(TestCaseUtils.getServerAdminPort()), "-Z",
              "-X", "-D", "cn=Directory Manager", "-w", "password",
              "-f", path2 };

      assertEquals(LDAPModify.run(nullPrintStream(), nullPrintStream(), args2), 0);
      assertEquals(LDAPModify.run(nullPrintStream(), nullPrintStream(), args1), 0);
    }
    finally
    {
      DeleteOperation deleteOperation = getRootConnection().processDelete(DN.valueOf(ruleDN));
      assertEquals(deleteOperation.getResultCode(), ResultCode.SUCCESS);
    }
  }
}

