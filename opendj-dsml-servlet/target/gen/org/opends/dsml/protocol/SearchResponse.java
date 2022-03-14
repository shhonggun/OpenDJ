//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.7 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2022.03.14 시간 10:34:15 AM KST 
//


package org.opends.dsml.protocol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SearchResponse complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="SearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchResultEntry" type="{urn:oasis:names:tc:DSML:2:0:core}SearchResultEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchResultReference" type="{urn:oasis:names:tc:DSML:2:0:core}SearchResultReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchResultDone" type="{urn:oasis:names:tc:DSML:2:0:core}LDAPResult"/>
 *       &lt;/sequence>
 *       &lt;attribute name="requestID" type="{urn:oasis:names:tc:DSML:2:0:core}RequestID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "searchResultEntry",
    "searchResultReference",
    "searchResultDone"
})
public class SearchResponse {

    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected List<SearchResultEntry> searchResultEntry;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected List<SearchResultReference> searchResultReference;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core", required = true)
    protected LDAPResult searchResultDone;
    @XmlAttribute(name = "requestID")
    protected String requestID;

    /**
     * Gets the value of the searchResultEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchResultEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchResultEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchResultEntry }
     * 
     * 
     */
    public List<SearchResultEntry> getSearchResultEntry() {
        if (searchResultEntry == null) {
            searchResultEntry = new ArrayList<SearchResultEntry>();
        }
        return this.searchResultEntry;
    }

    /**
     * Gets the value of the searchResultReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchResultReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchResultReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchResultReference }
     * 
     * 
     */
    public List<SearchResultReference> getSearchResultReference() {
        if (searchResultReference == null) {
            searchResultReference = new ArrayList<SearchResultReference>();
        }
        return this.searchResultReference;
    }

    /**
     * searchResultDone 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LDAPResult }
     *     
     */
    public LDAPResult getSearchResultDone() {
        return searchResultDone;
    }

    /**
     * searchResultDone 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LDAPResult }
     *     
     */
    public void setSearchResultDone(LDAPResult value) {
        this.searchResultDone = value;
    }

    /**
     * requestID 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * requestID 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

}
