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
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.server.core;

import static org.assertj.core.api.Assertions.*;
import static org.forgerock.opendj.ldap.requests.Requests.*;
import static org.forgerock.opendj.ldap.schema.CoreSchema.*;
import static org.opends.server.TestCaseUtils.*;
import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.protocols.ldap.LDAPConstants.*;
import static org.opends.server.types.NullOutputStream.nullPrintStream;
import static org.opends.server.util.CollectionUtils.*;
import static org.testng.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.config.client.ManagementContext;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.requests.AddRequest;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.ldap.schema.ObjectClass;
import org.forgerock.opendj.server.config.client.GlobalCfgClient;
import org.forgerock.opendj.server.config.meta.GlobalCfgDefn;
import org.opends.server.TestCaseUtils;
import org.opends.server.api.LocalBackend;
import org.opends.server.plugins.DisconnectClientPlugin;
import org.opends.server.plugins.ShortCircuitPlugin;
import org.opends.server.plugins.UpdatePreOpPlugin;
import org.opends.server.protocols.ldap.AddRequestProtocolOp;
import org.opends.server.protocols.ldap.LDAPAttribute;
import org.opends.server.protocols.ldap.LDAPMessage;
import com.forgerock.opendj.ldap.tools.LDAPModify;
import org.opends.server.tools.RemoteConnection;
import org.opends.server.types.Attribute;
import org.opends.server.types.Attributes;
import org.opends.server.types.CancelRequest;
import org.opends.server.types.CancelResult;
import org.opends.server.types.Control;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;
import org.opends.server.types.LockManager.DNLock;
import org.opends.server.types.Operation;
import org.opends.server.types.RawAttribute;
import org.opends.server.types.WritabilityMode;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** A set of test cases for add operations. */
@SuppressWarnings("javadoc")
public class AddOperationTestCase
       extends OperationTestCase
{
  /** Some of the tests disable the backends, so we reenable them here. */
  @AfterMethod(alwaysRun=true)
  public void reenableBackend() throws DirectoryException {
    LocalBackend<?> b =
        TestCaseUtils.getServerContext().getBackendConfigManager().findLocalBackendForEntry(DN.valueOf("o=test"));
    b.setWritabilityMode(WritabilityMode.ENABLED);
  }

  /**
   * Retrieves a set of add operations that may be used for testing.
   *
   * @return  A set of add operations that may be used for testing.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @DataProvider(name = "addOperations")
  public Object[][] getAddOperations() throws Exception
  {
    List<Control> noControls = new ArrayList<>();

    List<RawAttribute> ldapAttrList = rawAttributes();

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    // @formatter:off
    return new Object[][] {
      { newAddOperationBasis("ou=People,o=test", ldapAttrList, null) },
      { newAddOperationBasis("ou=People,o=test", ldapAttrList, noControls) },
      { newAddOperationBasis(entry, null) },
      { newAddOperationBasis(entry, noControls) },
    };
    // @formatter:on
  }

  private AddOperationBasis newAddOperationBasis(
      String entryDn, List<RawAttribute> rawAttributes, List<Control> controls)
  {
    return new AddOperationBasis(getRootConnection(), nextOperationID(), nextMessageID(),
        controls, ByteString.valueOfUtf8(entryDn), rawAttributes);
  }

  private AddOperationBasis newAddOperationBasis(Entry e, List<Control> controls)
  {
    return new AddOperationBasis(getRootConnection(), nextOperationID(), nextMessageID(), controls, e);
  }

  @Override
  protected Operation[] createTestOperations() throws Exception
  {
    Object[][]  objs = getAddOperations();
    Operation[] ops  = new Operation[objs.length];
    for (int i=0; i < objs.length; i++)
    {
      ops[i] = (Operation) objs[i][0];
    }

    return ops;
  }

  /**
   * Tests the <CODE>getRawEntryDN</CODE> and <CODE>setRawEntryDN</CODE>
   * methods.
   *
   * @param  addOperation  The add operation to be tested.
   */
  @Test(dataProvider = "addOperations")
  public void testGetAndSetRawEntryDN(AddOperation addOperation)
  {
    ByteString originalDN = addOperation.getRawEntryDN();
    assertNotNull(originalDN);

    addOperation.setRawEntryDN(ByteString.valueOfUtf8("uid=test,o=test"));
    assertNotNull(addOperation.getRawEntryDN());
    assertEquals(addOperation.getRawEntryDN(),
                 ByteString.valueOfUtf8("uid=test,o=test"));

    addOperation.setRawEntryDN(originalDN);
    assertNotNull(addOperation.getRawEntryDN());
    assertEquals(addOperation.getRawEntryDN(), originalDN);
  }

  /**
   * Tests the <CODE>getEntryDN</CODE> method for the case in which we expect
   * the rawEntryDN to be decoded.
   */
  @Test
  public void testGetEntryDNInitiallyNull()
  {
    List<RawAttribute> ldapAttrList = rawAttributes();

    AddOperationBasis addOperation =
         newAddOperationBasis("ou=People,o=test", ldapAttrList, null);
    assertNotNull(addOperation.getEntryDN());
  }

  private List<RawAttribute> rawAttributes()
  {
    return newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organizationalUnit")),
        new LDAPAttribute("ou", "People"));
  }

  private List<RawAttribute> newRawAttributes(RawAttribute... attributes)
  {
    return newArrayList(attributes);
  }

  private ArrayList<ByteString> byteStrings(final String... v)
  {
    ArrayList<ByteString> values = new ArrayList<>();
    for (String s : v)
    {
      values.add(ByteString.valueOfUtf8(s));
    }
    return values;
  }

  /**
   * Tests the <CODE>getEntryDN</CODE> method for the case in which we expect
   * the DN to be initially non-null.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testGetEntryDNInitiallyNonNull() throws Exception
  {
    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    AddOperationBasis addOperation = newAddOperationBasis(entry, null);
    assertNotNull(addOperation.getEntryDN());
  }

  /**
   * Tests the <CODE>getEntryDN</CODE> method for the case in which we expect
   * the DN to be initially non-null but then becomes null after the raw DN is
   * changed, and <CODE>getEntryDN</CODE> method recomputes it again
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testGetEntryDNNonNullChangedToNull() throws Exception
  {
    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    AddOperationBasis addOperation = newAddOperationBasis(entry, null);
    assertNotNull(addOperation.getEntryDN());

    addOperation.setRawEntryDN(ByteString.valueOfUtf8("ou=Users,o=test"));
    assertNotNull(addOperation.getEntryDN());
  }

  /**
   * Tests the <CODE>getRawAttributes</CODE>, <CODE>addRawAttribute</CODE>, and
   * <CODE>setRawAttributes</CODE> methods.
   *
   * @param  addOperation  The add operation to be tested.
   */
  @Test(dataProvider = "addOperations")
  public void testGetAndSetRawAttributes(AddOperation addOperation)
  {
    List<RawAttribute> rawAttrs = addOperation.getRawAttributes();
    assertNotNull(rawAttrs);
    assertFalse(rawAttrs.isEmpty());

    List<RawAttribute> copiedAttrs = new ArrayList<>(rawAttrs);
    copiedAttrs.add(new LDAPAttribute("description", "foo"));
    addOperation.setRawAttributes(copiedAttrs);

    assertTrue(find(addOperation, "description"));

    addOperation.setRawAttributes(rawAttrs);

    assertFalse(find(addOperation, "description"));
  }

  private boolean find(AddOperation addOperation, final String attrName)
  {
    for (RawAttribute a : addOperation.getRawAttributes())
    {
      if (attrName.equalsIgnoreCase(a.getAttributeType()))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Tests the <CODE>addObjectClass</CODE> method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testAddObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    UpdatePreOpPlugin.reset();

    ObjectClass oc = getExtensibleObjectObjectClass();
    UpdatePreOpPlugin.addObjectClassToAdd(oc);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    assertTrue(e.hasObjectClass(oc));

    UpdatePreOpPlugin.reset();
  }

  /**
   * Tests the <CODE>removeObjectClass</CODE> method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testRemoveObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "objectClass: extensibleObject",
         "ou: People");

    UpdatePreOpPlugin.reset();

    ObjectClass oc = getExtensibleObjectObjectClass();
    UpdatePreOpPlugin.addObjectClassToRemove(oc);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    assertFalse(e.hasObjectClass(oc));

    UpdatePreOpPlugin.reset();
  }

  /**
   * Tests the <CODE>setAttribute</CODE> method for an attribute that already
   * exists.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSetAttributeOverwrite() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People",
         "description: foo");

    UpdatePreOpPlugin.reset();

    Attribute a = Attributes.create("description", "bar");
    UpdatePreOpPlugin.addAttributeToSet(a);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    Iterable<Attribute> attrList = e.getAllAttributes(a.getAttributeDescription());
    assertThat(attrList).isNotEmpty();

    boolean foundFoo = false;
    boolean foundBar = false;
    for (Attribute attr : attrList)
    {
      if (attr.contains(ByteString.valueOfUtf8("foo")))
      {
        foundFoo = true;
      }

      if (attr.contains(ByteString.valueOfUtf8("bar")))
      {
        foundBar = true;
      }
    }

    assertFalse(foundFoo);
    assertTrue(foundBar);

    UpdatePreOpPlugin.reset();
  }

  /**
   * Tests the <CODE>setAttribute</CODE> method for an attribute that doesn't
   * exist.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSetAttributeAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    UpdatePreOpPlugin.reset();

    Attribute a = Attributes.create("description", "foo");
    UpdatePreOpPlugin.addAttributeToSet(a);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    assertThat(e.getAllAttributes(a.getAttributeDescription().getAttributeType())).isNotEmpty();

    UpdatePreOpPlugin.reset();
  }

  /**
   * Tests the <CODE>removeAttribute</CODE> method.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSetAttributeRemove() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People",
         "description: foo");

    UpdatePreOpPlugin.reset();

    AttributeType attrType = getDescriptionAttributeType();
    UpdatePreOpPlugin.addAttributeToRemove(attrType);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    assertThat(e.getAllAttributes(attrType)).isEmpty();

    UpdatePreOpPlugin.reset();
  }

  /**
   * Invokes methods to retrieve members of an add operation after it has
   * completed.
   *
   * @param  addOperation  The add operation to examine.  It should have
   *                       completed successfully.
   */
  private void retrieveCompletedOperationElements(AddOperation addOperation)
  {
    assertTrue(addOperation.getProcessingStartTime() > 0);
    assertTrue(addOperation.getProcessingStopTime() >=
               addOperation.getProcessingStartTime());
    assertTrue(addOperation.getProcessingTime() >= 0);
  }

  /**
   * Tests an internal add operation that should be successful using raw
   * arguments.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessRaw() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    AddOperation addOperation = getRootConnection().processAdd("ou=People,o=test", rawAttributes());
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);
  }

  /**
   * Tests an internal add operation that should be successful using processed
   * arguments.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessProcessed() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);
  }

  /**
   * Tests an internal add operation that fails because it contains a malformed
   * DN.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureMalformedDN() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    AddOperation addOperation = getRootConnection().processAdd("invalid", rawAttributes());
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests an internal add operation that fails because it contains the DN of
   * an entry that already exists.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureAlreadyExists() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organization")),
        new LDAPAttribute("o", "test"));

    AddOperation addOperation = getRootConnection().processAdd("o=test", attrs);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests an internal add operation that fails because it is a suffix that
   * doesn't exist.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureNoSuchSuffix() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organization")),
        new LDAPAttribute("o", "undefined"));

    AddOperation addOperation = getRootConnection().processAdd("o=undefined", attrs);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests an internal add operation that fails because it is below a suffix
   * that doesn't exist.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureNoSuchSuffixParent() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    AddOperation addOperation = getRootConnection().processAdd("ou=People,o=undefined", rawAttributes());
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests an internal add operation that fails because its parent does not exist.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureNoSuchParent() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    AddOperation addOperation = getRootConnection().processAdd("ou=People,o=missing,o=test", rawAttributes());
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests an external add operation that fails because it contains an attribute
   * that is marked no-user-modification.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testExternalAddFailureNoUserModification() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("localhost", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");

      long addRequests  = ldapStatistics.getAddRequests();
      long addResponses = ldapStatistics.getAddResponses();

      AddRequest addRequest = newAddRequest("ou=People,o=test")
          .addAttribute("objectClass", "top", "organizationalUnit")
          .addAttribute("ou", "People")
          .addAttribute("creatorsName", "cn=Directory Manager")
          .addAttribute("createTimestamp", "20060101000000Z");
      addFailure(conn, addRequest);

      assertEquals(ldapStatistics.getAddRequests(), addRequests+1);
      waitForAddResponsesStat(addResponses+1);
    }
  }

  /**
   * Tests an internal add operation that fails because it has an undefined
   * objectclass.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureUndefinedObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "undefined")),
        new LDAPAttribute("ou", "People"));

    AddOperation addOperation = getRootConnection().processAdd(ByteString.valueOfUtf8("ou=People,o=test"), attrs);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that contains a user-modifiable
   * operational attribute.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithOperationalAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password",
         "ds-pwp-password-policy-dn: cn=Clear UserPassword Policy," +
              "cn=Password Policies,cn=config");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);
  }

  /**
   * Tests a successful internal add operation that contains an attribute with
   * multiple values where the values are spread throughout the entry.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulDisjointAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organizationalUnit")),
        new LDAPAttribute("description", "foo"),
        new LDAPAttribute("ou", "People"),
        new LDAPAttribute("description", "bar"));

    AddOperation addOperation = getRootConnection().processAdd(ByteString.valueOfUtf8("ou=People,o=test"), attrs);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that contains raw attributes with
   * options.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithRawAttributeOptions() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organizationalUnit")),
        new LDAPAttribute("description", "foo"),
        new LDAPAttribute("ou", "People"),
        new LDAPAttribute("description;lang-en-us", "foo"));

    AddOperation addOperation = getRootConnection().processAdd(ByteString.valueOfUtf8("ou=People,o=test"), attrs);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that contains raw attributes with
   * options and an attribute that doesn't have any values without options.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithRawAttributeOptionsOnlyOptions() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "organizationalUnit")),
        new LDAPAttribute("ou", "People"),
        new LDAPAttribute("description;lang-en-us", "foo"));

    AddOperation addOperation = getRootConnection().processAdd(ByteString.valueOfUtf8("ou=People,o=test"), attrs);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that contains attributes with
   * options.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithAttributeOptions() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "uid;lang-en-us: test.user",
         "givenName: Test",
         "givenName;lang-en-us: Test",
         "sn: User",
         "sn;lang-en-us: User",
         "cn: Test User",
         "cn;lang-en-us: Test User",
         "userPassword: password");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);
  }

  /**
   * Tests an internal add operation that fails because it attempts to add the
   * root DSE.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureRootDSE() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    List<RawAttribute> attrs = newRawAttributes(
        new LDAPAttribute("objectClass", newArrayList("top", "ds-root-dse", "extensibleObject")),
        new LDAPAttribute("cn", "Root DSE"));

    AddOperation addOperation =
         getRootConnection().processAdd(ByteString.empty(), attrs);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that is missing RDN attributes.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithMissingRDNAttributes() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("ou=People,o=test"));
    Iterable<Attribute> attrList = e.getAllAttributes("ou");
    assertThat(attrList).isNotEmpty();
  }

  /**
   * Tests a failed internal add operation that is missing RDN attributes.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureWithMissingRDNAttributes() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    setAddMissingRDNAttribute(false);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);

    setAddMissingRDNAttribute(true);
  }

  private void setAddMissingRDNAttribute(boolean value) throws Exception
  {
    try (ManagementContext conf = getServer().getConfiguration())
    {
      GlobalCfgClient globalCfg = conf.getRootConfiguration().getGlobalConfiguration();
      globalCfg.setAddMissingRDNAttributes(value);
      globalCfg.commit();
    }
  }

  /**
   * Tests a successful internal add operation that is missing an objectclass
   * in the hierarchical chain.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulWithMissingParentObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    Entry e = DirectoryServer.getEntry(DN.valueOf("uid=test.user,o=test"));
    List<Attribute> attrList = e.getAllAttributes(getObjectClassAttributeType());
    assertTrue(findAttributeValueIgnoreCase(attrList, "top"));
  }

  private boolean findAttributeValueIgnoreCase(List<Attribute> attrs, String valueToFind)
  {
    for (Attribute a : attrs)
    {
      for (ByteString v : a)
      {
        if (valueToFind.equalsIgnoreCase(v.toString()))
        {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Tests a failed internal add operation that doesn't have any objectclasses.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureNoObjectClasses() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "ou: People");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that only has an abstract
   * objectclass.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureOnlyAbstractObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "ou: People");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that doesn't have any structural
   * objectclass (only abstract and auxiliary).
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureNoStructuralObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: extensibleObject",
         "ou: People");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that has multiple structural
   * objectclasses.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureMultipleStructuralObjectClasses() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "objectClass: person",
         "ou: People",
         "cn: Test User",
         "sn: User");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that is missing a required attribute.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureMissingRequiredAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "userPassword: password"); // Missing cn

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that is missing a required attribute
   * but has the extensibleObject objectClass (which shouldn't change anything).
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureMissingRequiredAttributeExtensibleObject() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "objectClass: extensibleObject",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "userPassword: password"); // Missing cn

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation that contains an attribute not
   * allowed by any objectclass.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureDisallowedAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password",
         "dc: Not allowed by inetOrgPerson");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a successful internal add operation that contains an attribute not
   * allowed by any standard objectclass in the entry but is allowed by
   * extensibleObject.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessfulDisallowedAttributeExtensibleObject() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "objectClass: extensibleObject",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password",
         "dc: Not allowed by inetOrgPerson but allowed by extensibleObject");

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);
  }

  /**
   * Tests the behavior of the server when attempting to perform an add \
   * operation with an entry containing an attribute with zero values.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureEmptyAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(false);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: o=test",
         "objectClass: top",
         "objectClass: organization",
         "o: test");

    AttributeType attrType = getDescriptionAttributeType();
    Map<AttributeType,List<Attribute>> userAttrs = entry.getUserAttributes();
    userAttrs.put(attrType, newArrayList(Attributes.empty(attrType)));

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
  }

  /**
   * Tests a failed internal add operation with the server in complete read-only
   * mode.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureServerCompletelyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password");

    setWritabilityMode(GlobalCfgDefn.WritabilityMode.DISABLED);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);

    setWritabilityMode(GlobalCfgDefn.WritabilityMode.ENABLED);
  }

  static void setWritabilityMode(GlobalCfgDefn.WritabilityMode mode) throws Exception
  {
    try (ManagementContext conf = getServer().getConfiguration())
    {
      GlobalCfgClient globalCfg = conf.getRootConfiguration().getGlobalConfiguration();
      globalCfg.setWritabilityMode(mode);
      globalCfg.commit();
    }
  }

  /**
   * Tests a successful internal add operation with the server in read-only mode
   * for external operations but allowed for internal operations.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessServerExternallyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password");

    setWritabilityMode(GlobalCfgDefn.WritabilityMode.INTERNAL_ONLY);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    setWritabilityMode(GlobalCfgDefn.WritabilityMode.ENABLED);
  }

  /**
   * Tests a failed external add operation with the server in read-only mode
   * for external operations but allowed for internal operations.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testExternalAddFailureServerExternallyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("localhost", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");

      setWritabilityMode(GlobalCfgDefn.WritabilityMode.INTERNAL_ONLY);

      long addRequests  = ldapStatistics.getAddRequests();
      long addResponses = ldapStatistics.getAddResponses();

      AddRequest addRequest =
          newAddRequest("ou=People,o=test")
          .addAttribute("objectClass", "top", "organizationalUnit")
          .addAttribute("ou", "People");
      addFailure(conn, addRequest);

      assertEquals(ldapStatistics.getAddRequests(), addRequests+1);
      waitForAddResponsesStat(addResponses+1);

      setWritabilityMode(GlobalCfgDefn.WritabilityMode.ENABLED);
    }
  }

  private void addFailure(RemoteConnection conn, AddRequest addRequest) throws Exception
  {
    LDAPMessage message = conn.add(addRequest, false);
    assertNotEquals(message.getAddResponseProtocolOp().getResultCode(), ResultCode.SUCCESS.intValue());
  }

  /**
   * Tests a failed internal add operation with the backend in complete
   * read-only mode.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddFailureBackendCompletelyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password");

    LocalBackend<?> b =
        TestCaseUtils.getServerContext().getBackendConfigManager().findLocalBackendForEntry(DN.valueOf("o=test"));
    b.setWritabilityMode(WritabilityMode.DISABLED);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);

    b.setWritabilityMode(WritabilityMode.ENABLED);
  }

  /**
   * Tests a successful internal add operation with the backend in read-only
   * mode for external operations but allowed for internal operations.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testInternalAddSuccessBackendExternallyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: uid=test.user,o=test",
         "objectClass: top",
         "objectClass: person",
         "objectClass: organizationalPerson",
         "objectClass: inetOrgPerson",
         "uid: test.user",
         "givenName: Test",
         "sn: User",
         "cn: Test User",
         "userPassword: password");

    LocalBackend<?> b =
        TestCaseUtils.getServerContext().getBackendConfigManager().findLocalBackendForEntry(DN.valueOf("o=test"));
    b.setWritabilityMode(WritabilityMode.INTERNAL_ONLY);

    AddOperation addOperation = getRootConnection().processAdd(entry);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    retrieveCompletedOperationElements(addOperation);

    b.setWritabilityMode(WritabilityMode.ENABLED);
  }

  /**
   * Tests a failed external add operation with the backend in read-only mode
   * for external operations but allowed for internal operations.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testExternalAddFailureBackendExternallyReadOnly() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("localhost", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");

      LocalBackend<?> b =
          TestCaseUtils.getServerContext().getBackendConfigManager().findLocalBackendForEntry(DN.valueOf("o=test"));
      b.setWritabilityMode(WritabilityMode.INTERNAL_ONLY);

      long addRequests  = ldapStatistics.getAddRequests();
      long addResponses = ldapStatistics.getAddResponses();

      AddRequest addRequest =
          newAddRequest("ou=People,o=test")
          .addAttribute("objectClass", "top", "organizationalUnit")
          .addAttribute("ou", "People");
      addFailure(conn, addRequest);

      assertEquals(ldapStatistics.getAddRequests(), addRequests+1);
      waitForAddResponsesStat(addResponses+1);

      b.setWritabilityMode(WritabilityMode.ENABLED);
    }
  }

  /**
   * Tests to ensure that any registered add notification listeners are invoked
   * for a successful add operation.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testSuccessWithNotificationListener() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    TestChangeNotificationListener changeListener =
         new TestChangeNotificationListener();
    DirectoryServer.registerInternalPlugin(changeListener);
    try{
      assertEquals(changeListener.getAddCount(), 0);

      Entry entry = TestCaseUtils.makeEntry(
          "dn: ou=People,o=test",
          "objectClass: top",
          "objectClass: organizationalUnit",
          "ou: People");

      AddOperation addOperation = getRootConnection().processAdd(entry);
      assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
      retrieveCompletedOperationElements(addOperation);

      assertEquals(changeListener.getAddCount(), 1);
    }finally {
      DirectoryServer.deregisterInternalPlugin(changeListener);
    }
  }

  /**
   * Tests to ensure that any registered add notification listeners are not
   * invoked for a failed add operation.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testFailureWithNotificationListener() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    TestChangeNotificationListener changeListener =
         new TestChangeNotificationListener();
    DirectoryServer.registerInternalPlugin(changeListener);
    try{
      assertEquals(changeListener.getAddCount(), 0);

      Entry entry = TestCaseUtils.makeEntry(
          "dn: ou=People,ou=nonexistent,o=test",
          "objectClass: top",
          "objectClass: organizationalUnit",
          "ou: People");

      AddOperation addOperation = getRootConnection().processAdd(entry);
      assertNotEquals(addOperation.getResultCode(), ResultCode.SUCCESS);

      assertEquals(changeListener.getAddCount(), 0);
    }finally {
      DirectoryServer.deregisterInternalPlugin(changeListener);
    }
  }

  /**
   * Tests an add operation that gets canceled before startup.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testCancelBeforeStartup() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    AddOperationBasis addOperation = newAddOperationBasis(entry, null);
    addOperation.abort(newCancelRequest("testCancelBeforeStartup"));
    addOperation.run();
    assertEquals(addOperation.getResultCode(), ResultCode.CANCELLED);
  }

  /**
   * Tests an add operation that gets canceled before startup.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testCancelAfterOperation() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    Entry entry = TestCaseUtils.makeEntry(
         "dn: ou=People,o=test",
         "objectClass: top",
         "objectClass: organizationalUnit",
         "ou: People");

    AddOperationBasis addOperation = newAddOperationBasis(entry, null);
    addOperation.run();

    CancelResult cancelResult = addOperation.cancel(newCancelRequest("testCancelAfterOperation"));

    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(cancelResult.getResultCode(), ResultCode.TOO_LATE);
  }

  private CancelRequest newCancelRequest(String cancelReason)
  {
    return new CancelRequest(false, LocalizableMessage.raw(cancelReason));
  }

  /**
   * Tests an add operation in which the server cannot obtain a lock on the
   * target entry because there is already a read lock held on it.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test(groups = "slow")
  public void testCannotLockEntry() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    final DNLock entryLock = DirectoryServer.getLockManager().tryReadLockEntry(DN.valueOf("ou=People,o=test"));
    try
    {
      Entry entry = TestCaseUtils.makeEntry(
           "dn: ou=People,o=test",
           "objectClass: top",
           "objectClass: organizationalUnit",
           "ou: People");

      AddOperation addOperation = getRootConnection().processAdd(entry);
      assertEquals(addOperation.getResultCode(), ResultCode.BUSY);
    }
    finally
    {
      entryLock.unlock();
    }
  }

  /**
   * Tests an add operation that should be disconnected in a pre-parse plugin.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testDisconnectInPreParseAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("127.0.0.1", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");
      addDisconnect(conn, "PreParse");
    }
  }

  private void addDisconnect(RemoteConnection conn, String section) throws Exception
  {
    writeAddRequest(conn, rawAttributes(), section);

    LDAPMessage message = conn.readMessage();
    if (message != null)
    {
      // If we got an element back, then it must be a notice of disconnect
      // unsolicited notification.
      assertEquals(message.getProtocolOpType(), OP_TYPE_EXTENDED_RESPONSE);
    }
  }

  private void writeAddRequest(RemoteConnection conn, List<RawAttribute> attrs, String section) throws IOException
  {
    AddRequestProtocolOp addRequest = new AddRequestProtocolOp(ByteString.valueOfUtf8("ou=People,o=test"), attrs);
    conn.writeMessage(addRequest, DisconnectClientPlugin.createDisconnectControlList(section));
  }

  /**
   * Tests an add operation that should be disconnected in a pre-operation
   * plugin.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testDisconnectInPreOperationAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("127.0.0.1", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");
      addDisconnect(conn, "PreOperation");
    }
  }

  /**
   * Tests an add operation that should be disconnected in a post-operation
   * plugin.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testDisconnectInPostOperationAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("127.0.0.1", TestCaseUtils.getServerLdapPort());)
    {
      conn.bind("cn=Directory Manager", "password");
      addDisconnect(conn, "PostOperation");
    }
  }

  /**
   * Tests an add operation that should be disconnected in a post-response plugin.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testDisconnectInPostResponseAdd() throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    try (RemoteConnection conn = new RemoteConnection("127.0.0.1", TestCaseUtils.getServerLdapPort()))
    {
      conn.bind("cn=Directory Manager", "password");
      writeAddRequest(conn, rawAttributes(), "PostResponse");

      while (true)
      {
        LDAPMessage message = conn.readMessage();
        if (message == null)
        {
          // The connection has been closed.
          return;
        }

        switch (message.getProtocolOpType())
        {
        case OP_TYPE_ADD_RESPONSE:
          // This was expected.  The disconnect didn't happen until after the
          // response was sent.
          break;
        case OP_TYPE_EXTENDED_RESPONSE:
          // The server is notifying us that it will be closing the connection.
          return;
        default:
          // This is a problem.  It's an unexpected response.
          Assert.fail("Unexpected response message " + message +
              " encountered in testDisconnectInPostResponseAdd");
          break;
        }
      }
    }
  }

  /**
   * Tests an add operation that attempts to add an entry with a user attribute
   * marked OBSOLETE in the server schema.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testAddObsoleteUserAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(false);

    String path = TestCaseUtils.createTempFile(
         "dn: cn=schema",
         "changetype: modify",
         "add: attributeTypes",
         "attributeTypes: ( testaddobsoleteuserattribute-oid " +
              "NAME 'testAddObsoleteUserAttribute' OBSOLETE " +
              "SYNTAX 1.3.6.1.4.1.1466.115.121.1.15 SINGLE-VALUE " +
              "X-ORGIN 'SchemaBackendTestCase' )");

    String attrName = "testaddobsoleteuserattribute";
    assertFalse(DirectoryServer.getInstance().getServerContext().getSchema().hasAttributeType(attrName));

    String[] args =
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertEquals(LDAPModify.run(nullPrintStream(), System.err, args), 0);
    assertTrue(DirectoryServer.getInstance().getServerContext().getSchema().hasAttributeType(attrName));

    path = TestCaseUtils.createTempFile(
         "dn: o=test",
         "changetype: add",
         "objectClass: top",
         "objectClass: organization",
         "objectClass: extensibleObject",
         "o: test",
         "testAddObsoleteUserAttribute: foo");

    args = new String[]
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertFalse(LDAPModify.run(nullPrintStream(), nullPrintStream(), args) == 0);
  }

  /**
   * Tests an add operation that attempts to add an entry with an operational
   * attribute marked OBSOLETE in the server schema.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testAddObsoleteOperationalAttribute() throws Exception
  {
    TestCaseUtils.initializeTestBackend(false);

    String path = TestCaseUtils.createTempFile(
         "dn: cn=schema",
         "changetype: modify",
         "add: attributeTypes",
         "attributeTypes: ( testaddobsoleteoperationalattribute-oid " +
              "NAME 'testAddObsoleteOperationalAttribute' OBSOLETE " +
              "SYNTAX 1.3.6.1.4.1.1466.115.121.1.15 SINGLE-VALUE " +
              "USAGE directoryOperation X-ORGIN 'SchemaBackendTestCase' )");

    String attrName = "testaddobsoleteoperationalattribute";
    assertFalse(DirectoryServer.getInstance().getServerContext().getSchema().hasAttributeType(attrName));

    String[] args =
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertEquals(LDAPModify.run(nullPrintStream(), System.err, args), 0);
    assertTrue(DirectoryServer.getInstance().getServerContext().getSchema().hasAttributeType(attrName));

    path = TestCaseUtils.createTempFile(
         "dn: o=test",
         "changetype: add",
         "objectClass: top",
         "objectClass: organization",
         "objectClass: extensibleObject",
         "o: test",
         "testAddObsoleteOperationalAttribute: foo");

    args = new String[]
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertFalse(LDAPModify.run(nullPrintStream(), nullPrintStream(), args) == 0);
  }

  /**
   * Tests an add operation that attempts to add an entry with an auxiliary
   * objectclass marked OBSOLETE in the server schema.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testAddObsoleteObjectClass() throws Exception
  {
    TestCaseUtils.initializeTestBackend(false);

    String path = TestCaseUtils.createTempFile(
         "dn: cn=schema",
         "changetype: modify",
         "add: objectClasses",
         "objectClasses: ( testaddobsoleteobjectclass-oid " +
              "NAME 'testAddObsoleteObjectClass' OBSOLETE AUXILIARY " +
              "MAY description X-ORGIN 'SchemaBackendTestCase' )");

    String ocName = "testaddobsoleteobjectclass";
    assertFalse(DirectoryServer.getInstance().getServerContext().getSchema().hasObjectClass(ocName));

    String[] args =
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertEquals(LDAPModify.run(nullPrintStream(), System.err, args), 0);
    assertTrue(DirectoryServer.getInstance().getServerContext().getSchema().hasObjectClass(ocName));

    path = TestCaseUtils.createTempFile(
         "dn: o=test",
         "changetype: add",
         "objectClass: top",
         "objectClass: organization",
         "objectClass: testAddObsoleteObjectClass",
         "o: test");

    args = new String[]
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D", "cn=Directory Manager",
      "-w", "password",
      "-f", path
    };

    assertFalse(LDAPModify.run(nullPrintStream(), nullPrintStream(), args) == 0);
  }

  /**
   * Tests the behavior of the server when short-circuiting out of an add
   * operation in the pre-parse phase with a success result code.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void testShortCircuitInPreParse() throws Exception
  {
    TestCaseUtils.initializeTestBackend(false);

    List<Control> controls = ShortCircuitPlugin.createShortCircuitControlList(0, "PreParse");

    List<RawAttribute> rawAttrs = newRawAttributes(
        RawAttribute.create("objectClass", byteStrings("top", "organization")),
        RawAttribute.create("o", "test"));

    AddOperationBasis addOperation = newAddOperationBasis("o=test", rawAttrs, controls);
    addOperation.run();
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    assertFalse(DirectoryServer.entryExists(DN.valueOf("o=test")));
  }
}
