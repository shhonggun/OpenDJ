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
 * Copyright 2006-2010 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.opends.server.core;

import static org.assertj.core.api.Assertions.*;
import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.protocols.internal.Requests.*;
import static org.opends.server.types.NullOutputStream.nullPrintStream;
import static org.opends.server.util.CollectionUtils.*;
import static org.opends.server.util.ServerConstants.*;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.assertj.core.api.SoftAssertions;
import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.DereferenceAliasesPolicy;
import org.forgerock.opendj.ldap.ResultCode;
import org.forgerock.opendj.ldap.SearchScope;
import org.forgerock.opendj.ldap.schema.ObjectClass;
import org.opends.server.TestCaseUtils;
import org.opends.server.controls.MatchedValuesControl;
import org.opends.server.controls.MatchedValuesFilter;
import org.opends.server.controls.SubentriesControl;
import org.opends.server.plugins.InvocationCounterPlugin;
import org.opends.server.protocols.internal.InternalSearchOperation;
import org.opends.server.protocols.internal.Requests;
import org.opends.server.protocols.internal.SearchRequest;
import org.opends.server.protocols.ldap.LDAPAttribute;
import org.opends.server.protocols.ldap.LDAPConstants;
import org.opends.server.protocols.ldap.LDAPControl;
import org.opends.server.protocols.ldap.LDAPFilter;
import org.opends.server.protocols.ldap.LDAPMessage;
import org.opends.server.protocols.ldap.LDAPResultCode;
import org.opends.server.protocols.ldap.SearchRequestProtocolOp;
import org.opends.server.protocols.ldap.SearchResultDoneProtocolOp;
import org.opends.server.protocols.ldap.SearchResultEntryProtocolOp;
import com.forgerock.opendj.ldap.tools.LDAPModify;
import org.opends.server.tools.RemoteConnection;
import org.opends.server.types.Attribute;
import org.opends.server.types.Control;
import org.opends.server.types.DirectoryException;
import org.opends.server.types.Entry;
import org.opends.server.types.Operation;
import org.opends.server.types.SearchResultEntry;
import org.opends.server.types.SearchResultReference;
import org.opends.server.util.StaticUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SuppressWarnings("javadoc")
public class SearchOperationTestCase extends OperationTestCase
{
  private static final String SUFFIX = "dc=example,dc=com";
  private static final String BASE = "o=Test Core Search,dc=example,dc=com";

  private Entry testEntry;
  private int ldapAttrCount;

  @BeforeClass
  public void setUp() throws Exception
  {
    TestCaseUtils.startServer();
    TestCaseUtils.clearBackend("userRoot","dc=example,dc=com");

    DN suffixDN = DN.valueOf(SUFFIX);
    if (!DirectoryServer.entryExists(suffixDN))
    {
      processAdd(StaticUtils.createEntry(suffixDN));
    }

    DN baseDN = DN.valueOf(BASE);
    if (!DirectoryServer.entryExists(baseDN))
    {
      processAdd(StaticUtils.createEntry(baseDN));
    }

    TestCaseUtils.addEntry(
         "dn: cn=subentry," + BASE,
         "objectclass: ldapsubentry");

    // Add a test entry.
    testEntry = TestCaseUtils.makeEntry(
         "dn: uid=rogasawara," + BASE,
         "userpassword: password",
         "objectclass: top",
         "objectclass: person",
         "objectclass: organizationalPerson",
         "objectclass: inetOrgPerson",
         "uid: rogasawara",
         "mail: rogasawara@airius.co.jp",
         "givenname;lang-ja:: 44Ot44OJ44OL44O8",
         "sn;lang-ja:: 5bCP56yg5Y6f",
         "cn;lang-ja:: 5bCP56yg5Y6fIOODreODieODi+ODvA==",
         "title;lang-ja:: 5Za25qWt6YOoIOmDqOmVtw==",
         "preferredlanguage: ja",
         "givenname:: 44Ot44OJ44OL44O8",
         "sn:: 5bCP56yg5Y6f",
         "cn:: 5bCP56yg5Y6fIOODreODieODi+ODvA==",
         "title:: 5Za25qWt6YOoIOmDqOmVtw==",
         "givenname;lang-ja;phonetic:: 44KN44Gp44Gr44O8",
         "sn;lang-ja;phonetic:: 44GK44GM44GV44KP44KJ",
         "cn;lang-ja;phonetic:: 44GK44GM44GV44KP44KJIOOCjeOBqeOBq+ODvA==",
         "title;lang-ja;phonetic:: " +
              "44GI44GE44GO44KH44GG44G2IOOBtuOBoeOCh+OBhg==",
         "givenname;lang-en: Rodney",
         "sn;lang-en: Ogasawara",
         "cn;lang-en: Rodney Ogasawara",
         "title;lang-en: Sales, Director"
    );

    // Calculate the total number of LDAP attributes in this entry.
    ldapAttrCount = 1; // For the objectclass attribute.
    for (Attribute a : testEntry.getAllAttributes())
    {
      ldapAttrCount += a.size();
    }

    // The add operation changes the attributes, so let's duplicate the entry.
    processAdd(testEntry.duplicate(false));

    // referral entry.
    TestCaseUtils.addEntry(
         "dn: ou=People," + BASE,
         "objectclass: extensibleobject",
         "objectclass: referral",
         "ref: ldap://hostb/OU=People,O=MNN,C=US",
         "ref: ldap://hostc/OU=People,O=MNN,C=US");

    // level 1 entry.
    TestCaseUtils.addEntry(
        "dn: ou=level1," + BASE,
        "objectclass: top",
        "objectclass: organizationalunit",
        "ou: level1");

    // level 2 entry.
    TestCaseUtils.addEntry(
        "dn: ou=level2,ou=level1," + BASE,
        "objectclass: top",
        "objectclass: organizationalunit",
        "ou: level2");

    // referral 2 entry.
    TestCaseUtils.addEntry(
        "dn: ou=level3,ou=level2,ou=level1," + BASE,
        "objectclass: extensibleobject",
        "objectclass: referral",
        "ref: ldap://hostb/OU=People,O=MNN,C=US",
        "ref: ldap://hostc/OU=People,O=MNN,C=US",
        "ref: ldap://hostd/OU=People,O=MNN,C=US");
  }

  private void processAdd(Entry e) throws DirectoryException
  {
    AddOperation addOperation = getRootConnection().processAdd(e);
    assertEquals(addOperation.getResultCode(), ResultCode.SUCCESS);
    assertNotNull(DirectoryServer.getEntry(e.getName()));
  }

  @Override
  protected Operation[] createTestOperations() throws Exception
  {
    return new Operation[0];
  }

  /**
   * Invokes a number of operation methods on the provided search operation
   * for which all processing has been completed.
   *
   * @param  searchOperation  The operation to be tested.
   */
  private void examineCompletedOperation(SearchOperation searchOperation)
  {
    assertTrue(searchOperation.getProcessingStartTime() > 0);
    assertTrue(searchOperation.getProcessingStopTime() > 0);
    assertTrue(searchOperation.getProcessingTime() >= 0);

    ensurePostReponseHasRun();
  }

  private Entry getSingleEntry(InternalSearchOperation searchOperation)
  {
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
    examineCompletedOperation(searchOperation);

    return searchOperation.getSearchEntries().getFirst();
  }

  private SearchResultEntryProtocolOp searchExternalForSingleEntry(
       SearchRequestProtocolOp searchRequest,
       ArrayList<Control> controls)
       throws Exception
  {
    // Establish a connection to the server.
    try (RemoteConnection conn = new RemoteConnection("localhost", TestCaseUtils.getServerLdapPort()))
    {
      bindAsManager(conn);

      // Since we are going to be watching the post-response count, we need to
      // wait for the server to become idle before kicking off the next request
      // to ensure that any remaining post-response processing from the previous
      // operation has completed.
      assertTrue(DirectoryServer.getWorkQueue().waitUntilIdle(10000));

      InvocationCounterPlugin.resetAllCounters();

      long searchRequests   = ldapStatistics.getSearchRequests();
      long searchEntries    = ldapStatistics.getSearchResultEntries();
      long searchReferences = ldapStatistics.getSearchResultReferences();
      long searchesDone     = ldapStatistics.getSearchResultsDone();

      conn.writeMessage(searchRequest, controls);

      LDAPMessage message;
      SearchResultEntryProtocolOp searchResultEntry = null;
      SearchResultDoneProtocolOp searchResultDone = null;
      while (searchResultDone == null && (message = conn.readMessage()) != null)
      {
        switch (message.getProtocolOpType())
        {
          case LDAPConstants.OP_TYPE_SEARCH_RESULT_ENTRY:
            searchResultEntry = message.getSearchResultEntryProtocolOp();
            searchEntries++;
            break;

          case LDAPConstants.OP_TYPE_SEARCH_RESULT_REFERENCE:
            searchReferences++;
            break;

          case LDAPConstants.OP_TYPE_SEARCH_RESULT_DONE:
            searchResultDone = message.getSearchResultDoneProtocolOp();
            assertThat(searchResultDone.getResultCode()).isEqualTo(LDAPResultCode.SUCCESS);
//            assertEquals(InvocationCounterPlugin.waitForPostResponse(), 1);
            searchesDone++;
            break;
        }
      }

      TestCaseUtils.quiesceServer();
      assertEquals(ldapStatistics.getSearchRequests(), searchRequests+1);
      assertEquals(ldapStatistics.getSearchResultEntries(), searchEntries);
      assertEquals(ldapStatistics.getSearchResultReferences(), searchReferences);
      assertEquals(ldapStatistics.getSearchResultsDone(), searchesDone);

      return searchResultEntry;
    }
  }

  private void bindAsManager(RemoteConnection conn) throws Exception
  {
    // Since we are going to be watching the post-response count, we need to
    // wait for the server to become idle before kicking off the next request to
    // ensure that any remaining post-response processing from the previous
    // operation has completed.
    assertTrue(DirectoryServer.getWorkQueue().waitUntilIdle(10000));

    InvocationCounterPlugin.resetAllCounters();
    conn.bind("cn=Directory Manager", "password");
  }

  @Test
  public void testSearchInternal() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = newSearchRequest(DN.valueOf(BASE), SearchScope.WHOLE_SUBTREE);
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 4);
    assertEquals(searchOperation.getReferencesSent(), 2);
    assertEquals(searchOperation.getErrorMessage().length(), 0);

    examineCompletedOperation(searchOperation);
  }

  @Test
  public void testSearchNonExistingDN_baseObject() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request =
        Requests.newSearchRequest("uid=doesNotExist," + BASE, SearchScope.BASE_OBJECT, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.NO_SUCH_OBJECT);
  }

  @Test
  public void testSearchExistingDN_baseObject() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = Requests.newSearchRequest(BASE, SearchScope.BASE_OBJECT, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.SUCCESS);
    assertThat(getEntryNames(searchOp)).containsExactly(BASE);
  }

  @Test
  public void testSearchNonExistingDN_singleLevel() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request =
        Requests.newSearchRequest("uid=doesNotExist," + BASE, SearchScope.SINGLE_LEVEL, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.NO_SUCH_OBJECT);
  }

  @Test
  public void testSearchExistingDN_singleLevel() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = Requests.newSearchRequest(BASE, SearchScope.SINGLE_LEVEL, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.SUCCESS);
    assertThat(getEntryNames(searchOp)).containsExactly(
        "uid=rogasawara," + BASE,
        "ou=level1," + BASE);
  }

  @Test
  public void testSearchNonExisting_subordinates() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request =
        Requests.newSearchRequest("uid=doesNotExist," + BASE, SearchScope.SUBORDINATES, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.NO_SUCH_OBJECT);
  }

  @Test
  public void testSearchExistingDN_subordinates() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = Requests.newSearchRequest(BASE, SearchScope.SUBORDINATES, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.SUCCESS);
    assertThat(getEntryNames(searchOp)).containsExactly(
        "uid=rogasawara," + BASE,
        "ou=level1," + BASE,
        "ou=level2,ou=level1," + BASE);
  }

  @Test
  public void testSearchNonExisting_wholeSubtree() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request =
        Requests.newSearchRequest("uid=doesNotExist," + BASE, SearchScope.WHOLE_SUBTREE, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.NO_SUCH_OBJECT);
  }

  @Test
  public void testSearchExistingDN_wholeSubtree() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = Requests.newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(objectclass=*)");
    InternalSearchOperation searchOp = getRootConnection().processSearch(request);
    assertThat(searchOp.getResultCode()).isEqualTo(ResultCode.SUCCESS);
    assertThat(getEntryNames(searchOp)).containsExactly(
        BASE,
        "uid=rogasawara," + BASE,
        "ou=level1," + BASE,
        "ou=level2,ou=level1," + BASE);
  }

  private List<String> getEntryNames(InternalSearchOperation searchOp)
  {
    List<SearchResultEntry> entries = searchOp.getSearchEntries();
    List<String> results = new ArrayList<>(entries.size());
    for (SearchResultEntry entry : entries)
    {
      results.add(entry.getName().toString());
    }
    return results;
  }

  @Test
  public void testSearchInternalUnspecifiedAttributes() throws Exception
  {
    InternalSearchOperation searchOperation = newInternalSearchOperation("(objectclass=inetorgperson)");
    Entry resultEntry = getSingleEntry(searchOperation);
    assertObjectClassesAndUserAttributes(
        resultEntry, testEntry.getObjectClasses(), testEntry.getUserAttributes().size() + 1);
    assertThat(resultEntry.getOperationalAttributes()).isEmpty();
  }

  @Test
  public void testSearchInternalUnspecifiedAttributesOmitValues() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = Requests.newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(objectclass=inetorgperson)")
        .setTypesOnly(true);
    Entry resultEntry = getSingleEntry(getRootConnection().processSearch(request));
    assertEntrySizes(resultEntry, 0, testEntry.getUserAttributes().size() + 1, 0);
  }

  @Test
  public void testSearchInternalAllOperationalAttributes() throws Exception
  {
    InternalSearchOperation searchOperation = newInternalSearchOperation("(objectclass=inetorgperson)", "+");
    Entry resultEntry = getSingleEntry(searchOperation);
    assertThat(resultEntry.getObjectClasses()).isEmpty();
    assertThat(resultEntry.getUserAttributes()).isEmpty();
    assertThat(resultEntry.getOperationalAttributes()).isNotEmpty();
  }

  @Test
  public void testSearchInternalAllUserAndOperationalAttributes() throws Exception
  {
    InternalSearchOperation searchOperation = newInternalSearchOperation("(objectclass=inetorgperson)", "*", "+");
    Entry resultEntry = getSingleEntry(searchOperation);
    assertObjectClassesAndUserAttributes(
        resultEntry, testEntry.getObjectClasses(), testEntry.getUserAttributes().size() + 1);
    assertThat(resultEntry.getOperationalAttributes()).isNotEmpty();
  }

  @Test
  public void testSearchInternalAllUserAttributesPlusSelectedOperational() throws Exception
  {
    InternalSearchOperation searchOperation =
        newInternalSearchOperation("(objectclass=inetorgperson)", "*", "createtimestamp");
    Entry resultEntry = getSingleEntry(searchOperation);
    assertObjectClassesAndUserAttributes(
        resultEntry, testEntry.getObjectClasses(), testEntry.getUserAttributes().size() + 1);
    assertThat(resultEntry.getOperationalAttributes()).hasSize(1);
  }

  private void assertObjectClassesAndUserAttributes(Entry resultEntry, Map<ObjectClass, String> objectClasses,
      int nbUserAttrs)
  {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(resultEntry.getObjectClasses()).as("Object classes").isEqualTo(objectClasses);
    softly.assertThat(resultEntry.getUserAttributes()).as("User attributes").hasSize(nbUserAttrs);
    softly.assertAll();
  }

  @Test
  public void testSearchInternalSelectedAttributes() throws Exception
  {
    InternalSearchOperation searchOperation =
        newInternalSearchOperation("(objectclass=inetorgperson)", "uid", "createtimestamp");
    Entry resultEntry = getSingleEntry(searchOperation);
    assertEntrySizes(resultEntry, 0, 1, 1);
  }

  private void assertEntrySizes(Entry resultEntry, int nbOCs, int nbUserAttrs, int nbOperationalAttrs)
  {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(resultEntry.getObjectClasses()).as("Object classes").hasSize(nbOCs);
    softly.assertThat(resultEntry.getUserAttributes()).as("User attributes").hasSize(nbUserAttrs);
    softly.assertThat(resultEntry.getOperationalAttributes()).as("Operational attributes").hasSize(nbOperationalAttrs);
    softly.assertAll();
  }

  private InternalSearchOperation newInternalSearchOperation(String filter, String... attributes) throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();
    SearchRequest request = newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, filter)
        .addAttribute(attributes);
    return getRootConnection().processSearch(request);
  }

  @Test
  public void testSearchExternalUnspecifiedAttributes() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              null);
    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(ldapAttrCount);
  }

  @Test
  public void testSearchExternalAllUserAttributes() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("*"));
    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(ldapAttrCount);
  }

  @Test
  public void testSearchExternalUnspecifiedAttributesOmitValues() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              true,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              null);
    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    // The attributes will include the objectclass type.
    assertThat(searchResultEntry.getAttributes()).hasSize(ldapAttrCount);
    for (LDAPAttribute a : searchResultEntry.getAttributes())
    {
      assertThat(a.getValues()).isEmpty();
    }
  }

  @Test
  public void testSearchExternalAllUserAttributesOmitValues() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              true,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("*"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    // The attributes will include the objectclass type.
    assertThat(searchResultEntry.getAttributes()).hasSize(ldapAttrCount);
    for (LDAPAttribute a : searchResultEntry.getAttributes())
    {
      assertThat(a.getValues()).isEmpty();
    }
  }

  @Test
  public void testSearchExternalObjectClassAttribute() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("objectclass"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(1);
    assertThat(searchResultEntry.getAttributes().getFirst().getValues()).hasSize(4);
  }

  @Test
  public void testSearchExternalObjectClassAttributeOmitValues() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              true,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("objectclass"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(1);
    assertThat(searchResultEntry.getAttributes().getFirst().getValues()).isEmpty();
  }

  @Test
  public void testSearchExternalSelectedAttributes() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("uid", "createtimestamp"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(2);
  }

  @Test
  public void testSearchExternalAttributeWithSubtypes() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("title"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(4);
  }

  @Test
  public void testSearchExternalAttributeWithSubtypesOmitValues() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              true,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("title"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);

    assertThat(searchResultEntry.getAttributes()).hasSize(4);
    for (LDAPAttribute a : searchResultEntry.getAttributes())
    {
      assertThat(a.getValues()).isEmpty();
    }
  }

  @Test
  public void testSearchExternalAttributeWithOptions() throws Exception
  {
    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              newLinkedHashSet("title;lang-ja;phonetic"));

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, null);
    assertThat(searchResultEntry.getAttributes()).hasSize(1);
  }

  @Test
  public void testSearchExternalMatchedValues() throws Exception
  {
    // Add a matched values control.
    LDAPFilter ldapFilter = LDAPFilter.decode("(title=*director*)");
    ArrayList<MatchedValuesFilter> filters = newArrayList(MatchedValuesFilter.createFromLDAPFilter(ldapFilter));
    Control mvc = new MatchedValuesControl(true, filters);
    ArrayList<Control> controls = newArrayList(mvc);

    SearchRequestProtocolOp searchRequest =
         new SearchRequestProtocolOp(
              ByteString.valueOfUtf8(BASE),
              SearchScope.WHOLE_SUBTREE,
              DereferenceAliasesPolicy.NEVER,
              Integer.MAX_VALUE,
              Integer.MAX_VALUE,
              false,
              LDAPFilter.decode("(objectclass=inetorgperson)"),
              null);

    SearchResultEntryProtocolOp searchResultEntry = searchExternalForSingleEntry(searchRequest, controls);

    // Per RFC 3876, an attribute that has no values selected is returned
    // with an empty set of values.  We should therefore expect all the
    // attributes but only one value.
    int valueCount = 0;
    for (LDAPAttribute a : searchResultEntry.getAttributes())
    {
      valueCount += a.getValues().size();
    }
    assertEquals(valueCount, 1);
  }

  @Test
  public void testSearchInternalReferences() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(objectclass=inetorgperson)");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);

    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getReferencesSent(), 2);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
    examineCompletedOperation(searchOperation);

    List<SearchResultReference> references = searchOperation.getSearchReferences();
    assertThat(references).hasSize(2);

    // One contains 2 URLs, the other contains 3. Cannot guarantee
    // ordering of the returned references, so just check the total is correct.
    int urls = references.get(0).getReferralURLs().size() +
        references.get(1).getReferralURLs().size();

    assertEquals(urls, 5);
  }

  /**
   * This does a single-level search that finds one referral object, but
   * not the one in a deeper subtree.
   *
   * @throws Exception
   */
  @Test
  public void testSearchSingleDeepReferences() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = newSearchRequest(BASE, SearchScope.SINGLE_LEVEL, "(ou=*)");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);

    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getReferencesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
    examineCompletedOperation(searchOperation);

    List<SearchResultReference> references = searchOperation.getSearchReferences();
    assertThat(references).hasSize(1);
    assertThat(references.get(0).getReferralURLs()).hasSize(2);
  }

  @Test
  public void testSearchInternalSubEntryEqualityFilter() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(objectclass=ldapsubentry)");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
  }

  @Test
  public void testSearchInternalSubEntryControl() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = Requests.newSearchRequest(DN.valueOf(BASE), SearchScope.WHOLE_SUBTREE)
        .addControl(new SubentriesControl(true, true));
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
  }

  @Test
  public void testSearchInternalLegacySubEntryControl() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request = Requests.newSearchRequest(DN.valueOf(BASE), SearchScope.WHOLE_SUBTREE)
        .addControl(new LDAPControl(OID_LDUP_SUBENTRIES, true));
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
  }

  @Test
  public void testSearchInternalSubEntryAndFilter() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request1 = newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(&(cn=*)(objectclass=ldapsubentry))");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request1);

    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);

    SearchRequest request2 =
        newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(&(&(cn=*)(objectclass=ldapsubentry)))");
    searchOperation = getRootConnection().processSearch(request2);

    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 1);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
  }

  @Test
  public void testSearchInternalSubEntryOrFilter() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    SearchRequest request =
        newSearchRequest(BASE, SearchScope.WHOLE_SUBTREE, "(|(objectclass=ldapsubentry)(objectclass=top))");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);

    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertEquals(searchOperation.getEntriesSent(), 5);
    assertEquals(searchOperation.getErrorMessage().length(), 0);
  }

  @Test
  public void testSearchInternalMatchedDN() throws Exception
  {
    InvocationCounterPlugin.resetAllCounters();

    TestCaseUtils.initializeTestBackend(true);

    SearchRequest request = newSearchRequest(DN.valueOf("ou=nonexistent,o=test"), SearchScope.WHOLE_SUBTREE);
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.NO_SUCH_OBJECT);
    assertNotNull(searchOperation.getMatchedDN());
  }

  /** Determines how attributes should be filtered in search operations. */
  private enum AttributeFilterType {
    DEFAULT, WILDCARDS, ENUMERATED;
  }

  /**
   * Returns test data for testSearchInternalAttributeFilters.
   *
   * @return The test data.
   */
  @DataProvider(name = "testSearchInternalAttributeFilters")
  public Object[][] createTestSearchInternalAttributeFiltersData()
  {
    return new Object[][] {
        {AttributeFilterType.DEFAULT,     false, false, false},
        {AttributeFilterType.DEFAULT,     false, false, true},
        {AttributeFilterType.DEFAULT,     false, true,  false},
        {AttributeFilterType.DEFAULT,     false, true,  true},
        {AttributeFilterType.DEFAULT,     true,  false, false},
        {AttributeFilterType.DEFAULT,     true,  false, true},
        {AttributeFilterType.DEFAULT,     true,  true,  false},
        {AttributeFilterType.DEFAULT,     true,  true,  true},
        {AttributeFilterType.WILDCARDS,   false, false, false},
        {AttributeFilterType.WILDCARDS,   false, false, true},
        {AttributeFilterType.WILDCARDS,   false, true,  false},
        {AttributeFilterType.WILDCARDS,   false, true,  true},
        {AttributeFilterType.WILDCARDS,   true,  false, false},
        {AttributeFilterType.WILDCARDS,   true,  false, true},
        {AttributeFilterType.WILDCARDS,   true,  true,  false},
        {AttributeFilterType.WILDCARDS,   true,  true,  true},
        {AttributeFilterType.ENUMERATED,  false, false, false},
        {AttributeFilterType.ENUMERATED,  false, false, true},
        {AttributeFilterType.ENUMERATED,  false, true,  false},
        {AttributeFilterType.ENUMERATED,  false, true,  true},
        {AttributeFilterType.ENUMERATED,  true,  false, false},
        {AttributeFilterType.ENUMERATED,  true,  false, true},
        {AttributeFilterType.ENUMERATED,  true,  true,  false},
        {AttributeFilterType.ENUMERATED,  true,  true,  true},
    };
  }

  /**
   * Tests that attribute filtering is performed correctly for real and
   * virtual attributes when various combinations of typesOnly, and the
   * real-attributes-only and virtual-attributes-only controls are used
   * (issues 3446 and 3726).
   *
   * @param filterType
   *          Specifies how attributes should be filtered.
   * @param typesOnly
   *          Strip attribute values.
   * @param stripVirtualAttributes
   *          Strip virtual attributes.
   * @param stripRealAttributes
   *          Strip real attributes.
   * @throws Exception
   *           If an unexpected problem occurs.
   */
  @Test(dataProvider = "testSearchInternalAttributeFilters")
  public void testSearchInternalAttributeFilters(
      AttributeFilterType filterType, boolean typesOnly,
      boolean stripVirtualAttributes, boolean stripRealAttributes)
      throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    // Real attributes (these are all user attributes).
    List<String> realAttrTypes =
        Arrays.asList("objectclass", "uid", "cn", "sn", "givenname", "userpassword");

    // Virtual attributes (these are all operational attributes).
    List<String> virtualAttrTypes =
        Arrays.asList("numsubordinates", "hassubordinates",
            "subschemasubentry", "entrydn", "ismemberof");

    String userDNString = "uid=test.user,o=test";
    DN userDN = DN.valueOf(userDNString);

    TestCaseUtils.addEntry("dn: " + userDNString,
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "userPassword: password");

    final SearchRequest request = Requests.newSearchRequest(userDN, SearchScope.BASE_OBJECT);
    request.setTypesOnly(typesOnly);
    switch (filterType)
    {
    case DEFAULT:
      // Only user attributes.
      break;
    case WILDCARDS:
      request.addAttribute("*", "+");
      break;
    case ENUMERATED:
      request.addAttribute(realAttrTypes);
      request.addAttribute(virtualAttrTypes);
      break;
    }

    if (stripRealAttributes)
    {
      request.addControl(new LDAPControl(OID_VIRTUAL_ATTRS_ONLY, false));
    }
    if (stripVirtualAttributes)
    {
      request.addControl(new LDAPControl(OID_REAL_ATTRS_ONLY, false));
    }

    InternalSearchOperation search = getRootConnection().processSearch(request);
    assertEquals(search.getResultCode(), ResultCode.SUCCESS);

    LinkedList<SearchResultEntry> entries = search.getSearchEntries();
    assertThat(entries).hasSize(1);

    Entry entry = entries.getFirst();
    assertEquals(entry.getName(), userDN);

    // Check real attributes and virtual (operational) attributes.
    List<String> messages = new LinkedList<>();
    checkRealAttributes(typesOnly, stripRealAttributes, realAttrTypes, entry, messages);
    checkVirtualOperationalAttributes(filterType, typesOnly, stripVirtualAttributes, virtualAttrTypes, entry, messages);
    assertThat(messages).isEmpty();
  }

  private void checkVirtualOperationalAttributes(AttributeFilterType filterType, boolean typesOnly,
      boolean stripVirtualAttributes, List<String> virtualAttrTypes, Entry entry, List<String> messages)
  {
    for (String attrType : virtualAttrTypes)
    {
      Iterable<Attribute> attrs = entry.getAllAttributes(attrType);

      if (stripVirtualAttributes)
      {
        if (!isEmpty(attrs))
        {
          messages.add("Unexpected virtual attribute: " + attrType);
        }
      }
      else if (filterType == AttributeFilterType.DEFAULT)
      {
        if (!isEmpty(attrs))
        {
          messages.add("Unexpected operational attribute: " + attrType);
        }
      }
      else if ("ismemberof".equals(attrType))
      {
        // isMemberOf should never be returned as user is not in any groups.
        if (!isEmpty(attrs))
        {
          messages.add("Unexpected isMemberOf attribute");
        }
      }
      else
      {
        Iterator<Attribute> attrsIt = attrs.iterator();
        if (!attrsIt.hasNext())
        {
          messages.add("Missing virtual attribute: " + attrType);
        }
        else
        {
          Attribute attr = attrsIt.next();
          if (typesOnly)
          {
            if (!attr.isEmpty())
            {
              messages.add("Unexpected non-empty virtual attribute: " + attrType);
            }
          }
          else
          {
            if (attr.isEmpty())
            {
              messages.add("Unexpected empty virtual attribute: " + attrType);
            }
          }
        }
      }
    }
  }

  private List<String> checkRealAttributes(boolean typesOnly, boolean stripRealAttributes, List<String> realAttrTypes,
      Entry entry, List<String> messages)
  {
    for (String attrType : realAttrTypes)
    {
      Iterable<Attribute> attrs = entry.getAllAttributes(attrType);

      if (stripRealAttributes)
      {
        if (!isEmpty(attrs))
        {
          messages.add("Unexpected real attribute: " + attrType);
        }
      }
      else
      {
        Iterator<Attribute> attrsIt = attrs.iterator();
        if (!attrsIt.hasNext())
        {
          messages.add("Missing real attribute: " + attrType);
        }
        else
        {
          Attribute attr = attrsIt.next();
          if (typesOnly)
          {
            if (!attr.isEmpty())
            {
              messages.add("Unexpected non-empty real attribute: " + attrType);
            }
          }
          else
          {
            if (attr.isEmpty())
            {
              messages.add("Unexpected empty real attribute: " + attrType);
            }
          }
        }
      }
    }
    return messages;
  }



  /**
   * Returns test data for testSearchInternalUserAttributeNames.
   *
   * @return The test data.
   */
  @DataProvider(name = "testSearchInternalUserAttributeNames")
  public Object[][] createTestSearchInternalUserAttributeNamesData()
  {
    // First array is the requested attributes.
    // Second array is the expected attribute names in the entry.
    return new Object[][] {
        {
            Arrays.<String>asList(),
            Arrays.asList("objectClass", "cn", "cn;lang-fr") },
        {
            Arrays.asList("*", "+"),
            Arrays.asList("objectClass", "cn", "cn;lang-fr", "entryDN", "createTimestamp") },
        {
            Arrays.asList("objectClass", "cn", "cn;lang-fr", "entryDN", "createTimestamp"),
            Arrays.asList("objectClass", "cn", "cn;lang-fr", "entryDN", "createTimestamp") },
        {
            Arrays.asList("OBJECTCLASS", "commonName", "commonName;LANG-FR", "entrydn", "CREATETIMESTAMP"),
            Arrays.asList("OBJECTCLASS", "commonName", "commonName;LANG-FR", "entrydn", "CREATETIMESTAMP") },
        {
            Arrays.asList("*", "+", "OBJECTCLASS", "commonName",
                "commonName;LANG-FR", "entrydn", "CREATETIMESTAMP"),
            Arrays.asList("OBJECTCLASS", "commonName", "commonName;LANG-FR", "entrydn", "CREATETIMESTAMP") },
        { Arrays.asList("name"), Arrays.asList("givenName", "sn", "cn", "cn;lang-fr") },
        { Arrays.asList("name;lang-fr"), Arrays.asList("cn;lang-fr") },
        { Arrays.asList("name;LANG-FR"), Arrays.asList("cn;LANG-FR") }, };
  }

  /**
   * Tests that attributes are returned from internal searches using the
   * attribute name requested by the user.
   *
   * @param requestedAttributes
   *          The list of requested attributes names.
   * @param expectedAttributes
   *          The list of expected attribute names.
   * @throws Exception
   *           If an unexpected problem occurs.
   */
  @Test(dataProvider = "testSearchInternalUserAttributeNames")
  public void testSearchInternalUserAttributeNames(
      List<String> requestedAttributes, List<String> expectedAttributes)
      throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String userDNString = "uid=test.user,o=test";
    DN userDN = DN.valueOf(userDNString);

    TestCaseUtils.addEntry("dn: " + userDNString,
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "cn;lang-fr: Test Usager",
        "userPassword: password");

    SearchRequest request = Requests.newSearchRequest(userDN, SearchScope.BASE_OBJECT)
        .addAttribute(requestedAttributes);
    InternalSearchOperation search = getRootConnection().processSearch(request);
    assertEquals(search.getResultCode(), ResultCode.SUCCESS);

    LinkedList<SearchResultEntry> entries = search.getSearchEntries();
    assertThat(entries).hasSize(1);

    Entry entry = entries.getFirst();
    assertEquals(entry.getName(), userDN);

    // Check all expected attributes are present and have the user requested name.
    assertThat(getAttributeNames(entry)).containsAll(expectedAttributes);
  }

  private Set<String> getAttributeNames(Entry entry)
  {
    Set<String> actualNames = new HashSet<>();
    for (Attribute attribute : entry.getAllAttributes())
    {
      actualNames.add(attribute.getAttributeDescription().toString());
    }
    return actualNames;
  }

  /**
   * Tests that attributes are returned from external searches using the
   * attribute name requested by the user.
   *
   * @param requestedAttributes
   *          The list of requested attributes names.
   * @param expectedAttributes
   *          The list of expected attribute names.
   * @throws Exception
   *           If an unexpected problem occurs.
   */
  @Test(dataProvider = "testSearchInternalUserAttributeNames")
  public void testSearchExternalUserAttributeNames(
      List<String> requestedAttributes, List<String> expectedAttributes)
      throws Exception
  {
    TestCaseUtils.initializeTestBackend(true);

    String userDNString = "uid=test.user,o=test";
    DN userDN = DN.valueOf(userDNString);

    TestCaseUtils.addEntry("dn: " + userDNString,
        "objectClass: top",
        "objectClass: person",
        "objectClass: organizationalPerson",
        "objectClass: inetOrgPerson",
        "uid: test.user",
        "givenName: Test",
        "sn: User",
        "cn: Test User",
        "cn;lang-fr: Test Usager",
        "userPassword: password");

    SearchRequestProtocolOp searchRequest =
      new SearchRequestProtocolOp(
          ByteString.valueOfUtf8(userDNString),
          SearchScope.BASE_OBJECT,
          DereferenceAliasesPolicy.NEVER,
          Integer.MAX_VALUE,
          Integer.MAX_VALUE,
          false,
          LDAPFilter.objectClassPresent(),
          new LinkedHashSet<>(requestedAttributes));

    SearchResultEntryProtocolOp entry = searchExternalForSingleEntry(searchRequest, null);
    assertEquals(entry.getDN(), userDN);

    // Check all expected attributes are present and have the user requested name.
    assertThat(getAttributeNames(entry)).containsAll(expectedAttributes);
  }

  private Set<String> getAttributeNames(SearchResultEntryProtocolOp entry)
  {
    LinkedList<LDAPAttribute> attrList = entry.getAttributes();
    Set<String> actualNames = new HashSet<>();
    for (LDAPAttribute attribute : attrList)
    {
      actualNames.add(attribute.getAttributeType());
    }
    return actualNames;
  }

  /** Tests the one-level search with a lower allid threshold value. */
  @Test
  public void testOneLevelSearchWithAllIDThreshold() throws Exception
  {
    //Set a lower value for allid threshold. We set 2.
    setAllIdThreshold(2);
    //Add entries.
    String filePath = TestCaseUtils.createTempFile(
    "dn: ou=unit1,dc=example,dc=com\n" +
    "objectclass: top\n" +
    "objectclass: organizationalUnit\n" +
    "ou: unit1\n" +
    "\n" +
    "dn: ou=unit2,dc=example,dc=com\n" +
    "objectclass: top\n" +
    "objectclass: organizationalUnit\n" +
    "ou: unit2\n" +
    "\n" +
    "dn: ou=unit3,dc=example,dc=com\n" +
    "objectclass: top\n" +
    "objectclass: organizationalUnit\n" +
    "ou: unit3\n");

    String[]  args = new String []
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D","cn=directory manager",
      "-w","password",
      "-f", filePath
    };
    int err = LDAPModify.run(nullPrintStream(), nullPrintStream(), args);

    assertEquals(err,0);

    SearchRequest request =
        newSearchRequest("dc=example,dc=com", SearchScope.SINGLE_LEVEL, "(objectclass=organizationalUnit)");
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    assertThat(searchOperation.getSearchEntries()).hasSize(3);
    //restore the allid threshold.
    setAllIdThreshold(4000);
  }

  /** Sets a value of the allid threshold. */
  private void setAllIdThreshold(int value) throws Exception
  {
    //Change the allid threshold value.
    String filePath = TestCaseUtils.createTempFile(
    "dn: ds-cfg-backend-id=userRoot,cn=Backends,cn=config",
    "changetype: modify",
    "delete: ds-cfg-index-entry-limit",
    "-",
    "add: ds-cfg-index-entry-limit",
    "ds-cfg-index-entry-limit: "+value
    );
    String[] args = new String []
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D","cn=directory manager",
      "-w","password",
      "-f", filePath
    };
    int err = LDAPModify.run(nullPrintStream(), nullPrintStream(), args);
    assertEquals(err, 0);
  }
}
