//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.7 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2022.03.14 시간 10:34:15 AM KST 
//


package org.opends.dsml.protocol;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FilterSet complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="FilterSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:oasis:names:tc:DSML:2:0:core}FilterGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterSet", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "filterGroup"
})
public class FilterSet {

    @XmlElementRefs({
        @XmlElementRef(name = "lessOrEqual", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "greaterOrEqual", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "present", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "extensibleMatch", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "or", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "approxMatch", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "and", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "equalityMatch", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "not", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "substrings", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> filterGroup;

    /**
     * Gets the value of the filterGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filterGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilterGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AttributeValueAssertion }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeValueAssertion }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeDescription }{@code >}
     * {@link JAXBElement }{@code <}{@link MatchingRuleAssertion }{@code >}
     * {@link JAXBElement }{@code <}{@link FilterSet }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeValueAssertion }{@code >}
     * {@link JAXBElement }{@code <}{@link FilterSet }{@code >}
     * {@link JAXBElement }{@code <}{@link AttributeValueAssertion }{@code >}
     * {@link JAXBElement }{@code <}{@link Filter }{@code >}
     * {@link JAXBElement }{@code <}{@link SubstringFilter }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getFilterGroup() {
        if (filterGroup == null) {
            filterGroup = new ArrayList<JAXBElement<?>>();
        }
        return this.filterGroup;
    }

}
