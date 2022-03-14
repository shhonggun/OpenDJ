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
 * <p>MatchingRuleAssertion complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="MatchingRuleAssertion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value" type="{urn:oasis:names:tc:DSML:2:0:core}DsmlValue"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dnAttributes" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="matchingRule" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{urn:oasis:names:tc:DSML:2:0:core}AttributeDescriptionValue" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchingRuleAssertion", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "value"
})
public class MatchingRuleAssertion {

    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core", required = true, type = String.class)
    protected Object value;
    @XmlAttribute(name = "dnAttributes")
    protected Boolean dnAttributes;
    @XmlAttribute(name = "matchingRule")
    protected String matchingRule;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * value 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Object getValue() {
        return value;
    }

    /**
     * value 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * dnAttributes 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDnAttributes() {
        if (dnAttributes == null) {
            return false;
        } else {
            return dnAttributes;
        }
    }

    /**
     * dnAttributes 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDnAttributes(Boolean value) {
        this.dnAttributes = value;
    }

    /**
     * matchingRule 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchingRule() {
        return matchingRule;
    }

    /**
     * matchingRule 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchingRule(String value) {
        this.matchingRule = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
