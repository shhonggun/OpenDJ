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
 * Copyright 2008-2009 Sun Microsystems, Inc.
 * Portions Copyright 2014-2016 ForgeRock AS.
 */
package org.opends.server.schema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.ResultCode;
import org.opends.server.TestCaseUtils;
import org.opends.server.controls.ServerSideSortRequestControl;
import org.opends.server.controls.VLVRequestControl;
import org.opends.server.protocols.internal.InternalSearchOperation;
import org.opends.server.protocols.internal.SearchRequest;
import com.forgerock.opendj.ldap.tools.LDAPModify;
import org.opends.server.types.Control;
import org.opends.server.types.Entry;
import org.opends.server.types.LDAPException;
import org.opends.server.types.SearchResultEntry;
import org.opends.server.util.CollectionUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.Arrays.*;

import static org.forgerock.opendj.ldap.SearchScope.*;
import static org.opends.server.protocols.internal.InternalClientConnection.*;
import static org.opends.server.protocols.internal.Requests.*;
import static org.opends.server.types.NullOutputStream.nullPrintStream;
import static org.testng.Assert.*;

/** Integration tests for collation matching rules. */
@SuppressWarnings("javadoc")
public final class CollationMatchingRuleTest
        extends SchemaTestCase
{
  /**
   * Ensures that the Directory Server is running before executing the testcases.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @BeforeClass
  public void startServer()
         throws Exception
  {
    TestCaseUtils.startServer();
    TestCaseUtils.initializeTestBackend(true);
    user1 = DN.valueOf("cn=user1,dc=example,dc=com");
    user2 = DN.valueOf("cn=user2,dc=example,dc=com");
    user3 = DN.valueOf("cn=user3,dc=example,dc=com");
    user4 = DN.valueOf("cn=user4,dc=example,dc=com");
  }

  /**
   * Test to verify an ADD of an entry containing international characters.
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test
  public void addEntry() throws Exception
  {
    String filePath = TestCaseUtils.createTempFile(
            "dn: uid=user,o=test",
            "objectClass: person",
            "objectClass: organizationalPerson",
            "objectClass: inetorgperson",
            "objectClass: top",
            "departmentNumber:: w4NiYzExMQ==",
            "carLicense:: w6liZTI=",
            "uid: user",
            "cn:: U8ODbmNoZXo=",
            "sn:: UXXDqWJlYw==");
    String[] args = new String []
    {
      "-h", "127.0.0.1",
      "-p", String.valueOf(TestCaseUtils.getServerLdapPort()),
      "-D","cn=directory manager",
      "-w","password",
      "-f", filePath,
    };
    int err = LDAPModify.run(nullPrintStream(), nullPrintStream(), args);
    assertEquals(err,0);
  }

  /** Test to search the collation equality matching rule using OID. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationEqualityUsingOID() throws Exception
  {
    //Search the collation rule with OID of en and no suffix in the filter.
    SearchRequest request =
        newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "cn:1.3.6.1.4.1.42.2.27.9.4.34.1:=sanchez");
    searchCollationAtLeastOneEntryReturned(request);
  }

  /** Test to search the collation equality matching rule using language Tag. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationEqualityUsingLanguageTag() throws Exception
  {
    //Search the collation rule with language tag of en and no suffix
    //in the filter.
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "cn:en:=sanchez");
    searchCollationAtLeastOneEntryReturned(request);
  }

  /** Test to search the collation Less than matching rule using OID and suffix. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationLTUsingOIDSuffix() throws Exception
  {
    //Search the collation rule with OID of es and suffix in the filter.
    String filter = "departmentnumber:1.3.6.1.4.1.42.2.27.9.4.49.1.1:=abc120";
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, filter);
    searchCollationAtLeastOneEntryReturned(request);
  }

  /**
   * Test to search the collation Less than Equal to matching rule using Language Tag and suffix.
   */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationLTEUsingLanguageSuffix() throws Exception
  {
    //Search the collation rule with tag of fr and suffix in the filter.
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "carLicense:fr.2:=ebe2");
    searchCollationAtLeastOneEntryReturned(request);
  }

  /** Test to search the collation Greater than matching rule using language tag. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationGTUsingLanguage() throws Exception
  {
    //Search the collation rule with tag of fr in the filter.
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "carLicense:fr.5:=ebe1");
    searchCollationAtLeastOneEntryReturned(request);
  }

  /** Test to search the collation Greater than Equal to matching rule using language tag. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationGTEUsingLanguage() throws Exception
  {
    //Search the collation rule with tag of es and suffix in the filter.
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "departmentnumber:es.4:=abc111");
    searchCollationAtLeastOneEntryReturned(request);
  }

  /** Test to search the collation substring matching rule using language tag and suffix. */
  @Test(dependsOnMethods = "addEntry")
  public void searchCollationSubstring() throws Exception
  {
    /*Search the collation rule with tag of en and suffix in the filter.
     *It searches for string quebec against the value of sn which is
     * Qu\u00e9bec.
     */
    SearchRequest request = newSearchRequest("uid=user,o=test", WHOLE_SUBTREE, "sn:en.6:=*u*bec");
    searchCollationAtLeastOneEntryReturned(request);
  }

  private void searchCollationAtLeastOneEntryReturned(SearchRequest request)
  {
    InternalSearchOperation searchOperation = getRootConnection().processSearch(request);
    assertEquals(searchOperation.getResultCode(), ResultCode.SUCCESS);
    List<SearchResultEntry> entries = searchOperation.getSearchEntries();
    assertNotNull(entries.get(0));
  }

  private DN user1;
  private DN user2 ;
  private DN user3;
  private DN user4;

  /**
   * Test to verify the Sort control works well with the Collation
   * Less-than-equal-to matching rule and French Locale.
   */
  @Test
  public void testSortControlLTERule() throws Exception
  {
    List<DN> expectedDNOrder = asList(user4, user3, user2, user1);
    List<Control> requestControls = serverSideSortControl("displayname:fr");
    validateSortControl("displayname:fr-FR.6:=A*", expectedDNOrder, requestControls);
  }

  /**
   * Test to verify the Sort control works with Collation equality
   * matching rule and Spanish locale.
   */
  @Test
  public void testSortControlEQRule() throws Exception
  {
    List<DN> expectedDNOrder = asList(user4, user3, user2, user1);
    List<Control> requestControls = serverSideSortControl("displayname:es");
    validateSortControl("displayname:es.6:=A*", expectedDNOrder, requestControls);
  }

  /**
   * Test to verify the Sort control works with Collation greater
   * than matching rule and English locale in a descending order.
   */
  @Test
  public void testSortControlGTRule() throws Exception
  {
    List<DN> expectedDNOrder = asList(user1, user2, user3, user4);
    List<Control> requestControls = serverSideSortControl("-displayname:en");
    validateSortControl("displayname:en-US.6:=A*", expectedDNOrder, requestControls);
  }

  /** Tests the Sort control with the VLV control using a collation equality matching rule. */
  @Test
  public void testVLVSortControl() throws Exception
  {
    List<DN> expectedDNOrder = asList(user4, user3, user2, user1);
    List<Control> requestControls = CollectionUtils.<Control> newArrayList(
        new ServerSideSortRequestControl("displayname:fr"),
        new VLVRequestControl(0, 4, 1, 0));
    validateSortControl("objectclass=inetOrgPerson", expectedDNOrder, requestControls);
  }

  private List<Control> serverSideSortControl(String sortOrderString) throws LDAPException
  {
    return Arrays.<Control> asList(new ServerSideSortRequestControl(sortOrderString));
  }

  private void validateSortControl(String searchFilter, List<DN> expectedDNOrder, List<Control> requestControls)
      throws Exception
  {
    try
    {
      populateEntriesForControl();

      SearchRequest request = newSearchRequest(DN.valueOf("dc=example,dc=com"), WHOLE_SUBTREE, searchFilter)
          .addControl(requestControls);
      InternalSearchOperation internalSearch = getRootConnection().processSearch(request);
      assertEquals(internalSearch.getResultCode(), ResultCode.SUCCESS);
      assertEquals(getDNs(internalSearch), expectedDNOrder);
    }
    finally
    {
      TestCaseUtils.clearBackend("userRoot");
    }
  }

  private ArrayList<DN> getDNs(InternalSearchOperation internalSearch)
  {
    ArrayList<DN> results = new ArrayList<>();
    for (Entry e : internalSearch.getSearchEntries())
    {
      results.add(e.getName());
    }
    return results;
  }

  private void populateEntriesForControl() throws Exception
  {
    TestCaseUtils.clearBackend("userRoot", "dc=example,dc=com");
    TestCaseUtils.addEntries(
      "dn: cn=user1,dc=example,dc=com",
      "objectclass: inetorgperson",
      "cn: user1",
      "sn: user1",
      "uid: user1",
      "displayname:: QXVy4oiawqlsaWVuNA==",
      "",
      "dn: cn=user2,dc=example,dc=com",
      "objectclass: inetorgperson",
      "cn: user2",
      "sn: user2",
      "uid: user2",
      "displayname:: QXVy4oiawqlsaWVuMw==",
      "",
      "dn: cn=user3,dc=example,dc=com",
      "objectclass: inetorgperson",
      "cn: user3",
      "sn: user3",
      "uid: user3",
      "displayname:: QXVy4oiawqlsaWVuMg==",
      "",
      "dn: cn=user4,dc=example,dc=com",
      "objectclass: inetorgperson",
      "cn: user4",
      "sn: user4",
      "uid: user4",
      "displayname:: QXVy4oiawqlsaWVuMQ=="
    );
  }
}
