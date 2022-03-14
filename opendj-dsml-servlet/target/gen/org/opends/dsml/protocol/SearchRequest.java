//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.7 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2022.03.14 시간 10:34:15 AM KST 
//


package org.opends.dsml.protocol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SearchRequest complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="SearchRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:DSML:2:0:core}DsmlMessage">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{urn:oasis:names:tc:DSML:2:0:core}Filter"/>
 *         &lt;element name="attributes" type="{urn:oasis:names:tc:DSML:2:0:core}AttributeDescriptions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dn" use="required" type="{urn:oasis:names:tc:DSML:2:0:core}DsmlDN" />
 *       &lt;attribute name="scope" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="baseObject"/>
 *             &lt;enumeration value="singleLevel"/>
 *             &lt;enumeration value="wholeSubtree"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="derefAliases" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="neverDerefAliases"/>
 *             &lt;enumeration value="derefInSearching"/>
 *             &lt;enumeration value="derefFindingBaseObj"/>
 *             &lt;enumeration value="derefAlways"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="sizeLimit" type="{urn:oasis:names:tc:DSML:2:0:core}MAXINT" default="0" />
 *       &lt;attribute name="timeLimit" type="{urn:oasis:names:tc:DSML:2:0:core}MAXINT" default="0" />
 *       &lt;attribute name="typesOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "filter",
    "attributes"
})
public class SearchRequest
    extends DsmlMessage
{

    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core", required = true)
    protected Filter filter;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeDescriptions attributes;
    @XmlAttribute(name = "dn", required = true)
    protected String dn;
    @XmlAttribute(name = "scope", required = true)
    protected String scope;
    @XmlAttribute(name = "derefAliases", required = true)
    protected String derefAliases;
    @XmlAttribute(name = "sizeLimit")
    protected Long sizeLimit;
    @XmlAttribute(name = "timeLimit")
    protected Long timeLimit;
    @XmlAttribute(name = "typesOnly")
    protected Boolean typesOnly;

    /**
     * filter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Filter }
     *     
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * filter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Filter }
     *     
     */
    public void setFilter(Filter value) {
        this.filter = value;
    }

    /**
     * attributes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeDescriptions }
     *     
     */
    public AttributeDescriptions getAttributes() {
        return attributes;
    }

    /**
     * attributes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeDescriptions }
     *     
     */
    public void setAttributes(AttributeDescriptions value) {
        this.attributes = value;
    }

    /**
     * dn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDn() {
        return dn;
    }

    /**
     * dn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDn(String value) {
        this.dn = value;
    }

    /**
     * scope 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * scope 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * derefAliases 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDerefAliases() {
        return derefAliases;
    }

    /**
     * derefAliases 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDerefAliases(String value) {
        this.derefAliases = value;
    }

    /**
     * sizeLimit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getSizeLimit() {
        if (sizeLimit == null) {
            return  0L;
        } else {
            return sizeLimit;
        }
    }

    /**
     * sizeLimit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSizeLimit(Long value) {
        this.sizeLimit = value;
    }

    /**
     * timeLimit 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getTimeLimit() {
        if (timeLimit == null) {
            return  0L;
        } else {
            return timeLimit;
        }
    }

    /**
     * timeLimit 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeLimit(Long value) {
        this.timeLimit = value;
    }

    /**
     * typesOnly 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTypesOnly() {
        if (typesOnly == null) {
            return false;
        } else {
            return typesOnly;
        }
    }

    /**
     * typesOnly 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTypesOnly(Boolean value) {
        this.typesOnly = value;
    }

}
