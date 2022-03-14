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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BatchResponse complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BatchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:oasis:names:tc:DSML:2:0:core}BatchResponses" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "BatchResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "batchResponses"
})
public class BatchResponse {

    @XmlElementRefs({
        @XmlElementRef(name = "addResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "errorResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "modDNResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "extendedResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "searchResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "delResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "authResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "modifyResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class),
        @XmlElementRef(name = "compareResponse", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> batchResponses;
    @XmlAttribute(name = "requestID")
    protected String requestID;

    /**
     * Gets the value of the batchResponses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchResponses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchResponses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * {@link JAXBElement }{@code <}{@link ErrorResponse }{@code >}
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * {@link JAXBElement }{@code <}{@link ExtendedResponse }{@code >}
     * {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * {@link JAXBElement }{@code <}{@link LDAPResult }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getBatchResponses() {
        if (batchResponses == null) {
            batchResponses = new ArrayList<JAXBElement<?>>();
        }
        return this.batchResponses;
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
