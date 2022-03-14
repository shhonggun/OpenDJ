//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.7 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2022.03.14 시간 10:34:15 AM KST 
//


package org.opends.dsml.protocol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Filter complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="Filter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{urn:oasis:names:tc:DSML:2:0:core}FilterGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filter", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "and",
    "or",
    "not",
    "equalityMatch",
    "substrings",
    "greaterOrEqual",
    "lessOrEqual",
    "present",
    "approxMatch",
    "extensibleMatch"
})
public class Filter {

    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected FilterSet and;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected FilterSet or;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected Filter not;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeValueAssertion equalityMatch;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected SubstringFilter substrings;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeValueAssertion greaterOrEqual;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeValueAssertion lessOrEqual;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeDescription present;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AttributeValueAssertion approxMatch;
    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected MatchingRuleAssertion extensibleMatch;

    /**
     * and 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FilterSet }
     *     
     */
    public FilterSet getAnd() {
        return and;
    }

    /**
     * and 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterSet }
     *     
     */
    public void setAnd(FilterSet value) {
        this.and = value;
    }

    /**
     * or 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link FilterSet }
     *     
     */
    public FilterSet getOr() {
        return or;
    }

    /**
     * or 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterSet }
     *     
     */
    public void setOr(FilterSet value) {
        this.or = value;
    }

    /**
     * not 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Filter }
     *     
     */
    public Filter getNot() {
        return not;
    }

    /**
     * not 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Filter }
     *     
     */
    public void setNot(Filter value) {
        this.not = value;
    }

    /**
     * equalityMatch 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public AttributeValueAssertion getEqualityMatch() {
        return equalityMatch;
    }

    /**
     * equalityMatch 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public void setEqualityMatch(AttributeValueAssertion value) {
        this.equalityMatch = value;
    }

    /**
     * substrings 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link SubstringFilter }
     *     
     */
    public SubstringFilter getSubstrings() {
        return substrings;
    }

    /**
     * substrings 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link SubstringFilter }
     *     
     */
    public void setSubstrings(SubstringFilter value) {
        this.substrings = value;
    }

    /**
     * greaterOrEqual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public AttributeValueAssertion getGreaterOrEqual() {
        return greaterOrEqual;
    }

    /**
     * greaterOrEqual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public void setGreaterOrEqual(AttributeValueAssertion value) {
        this.greaterOrEqual = value;
    }

    /**
     * lessOrEqual 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public AttributeValueAssertion getLessOrEqual() {
        return lessOrEqual;
    }

    /**
     * lessOrEqual 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public void setLessOrEqual(AttributeValueAssertion value) {
        this.lessOrEqual = value;
    }

    /**
     * present 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeDescription }
     *     
     */
    public AttributeDescription getPresent() {
        return present;
    }

    /**
     * present 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeDescription }
     *     
     */
    public void setPresent(AttributeDescription value) {
        this.present = value;
    }

    /**
     * approxMatch 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public AttributeValueAssertion getApproxMatch() {
        return approxMatch;
    }

    /**
     * approxMatch 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeValueAssertion }
     *     
     */
    public void setApproxMatch(AttributeValueAssertion value) {
        this.approxMatch = value;
    }

    /**
     * extensibleMatch 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link MatchingRuleAssertion }
     *     
     */
    public MatchingRuleAssertion getExtensibleMatch() {
        return extensibleMatch;
    }

    /**
     * extensibleMatch 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchingRuleAssertion }
     *     
     */
    public void setExtensibleMatch(MatchingRuleAssertion value) {
        this.extensibleMatch = value;
    }

}
