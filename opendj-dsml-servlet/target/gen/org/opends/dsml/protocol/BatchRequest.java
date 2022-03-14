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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BatchRequest complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BatchRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authRequest" type="{urn:oasis:names:tc:DSML:2:0:core}AuthRequest" minOccurs="0"/>
 *         &lt;group ref="{urn:oasis:names:tc:DSML:2:0:core}BatchRequests" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="requestID" type="{urn:oasis:names:tc:DSML:2:0:core}RequestID" />
 *       &lt;attribute name="processing" default="sequential">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="sequential"/>
 *             &lt;enumeration value="parallel"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="responseOrder" default="sequential">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="sequential"/>
 *             &lt;enumeration value="unordered"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="onError" default="exit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="resume"/>
 *             &lt;enumeration value="exit"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", propOrder = {
    "authRequest",
    "batchRequests"
})
public class BatchRequest {

    @XmlElement(namespace = "urn:oasis:names:tc:DSML:2:0:core")
    protected AuthRequest authRequest;
    @XmlElements({
        @XmlElement(name = "searchRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = SearchRequest.class),
        @XmlElement(name = "modifyRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = ModifyRequest.class),
        @XmlElement(name = "addRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = AddRequest.class),
        @XmlElement(name = "delRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = DelRequest.class),
        @XmlElement(name = "modDNRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = ModifyDNRequest.class),
        @XmlElement(name = "compareRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = CompareRequest.class),
        @XmlElement(name = "abandonRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = AbandonRequest.class),
        @XmlElement(name = "extendedRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core", type = ExtendedRequest.class)
    })
    protected List<DsmlMessage> batchRequests;
    @XmlAttribute(name = "requestID")
    protected String requestID;
    @XmlAttribute(name = "processing")
    protected String processing;
    @XmlAttribute(name = "responseOrder")
    protected String responseOrder;
    @XmlAttribute(name = "onError")
    protected String onError;

    /**
     * authRequest 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AuthRequest }
     *     
     */
    public AuthRequest getAuthRequest() {
        return authRequest;
    }

    /**
     * authRequest 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthRequest }
     *     
     */
    public void setAuthRequest(AuthRequest value) {
        this.authRequest = value;
    }

    /**
     * Gets the value of the batchRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchRequest }
     * {@link ModifyRequest }
     * {@link AddRequest }
     * {@link DelRequest }
     * {@link ModifyDNRequest }
     * {@link CompareRequest }
     * {@link AbandonRequest }
     * {@link ExtendedRequest }
     * 
     * 
     */
    public List<DsmlMessage> getBatchRequests() {
        if (batchRequests == null) {
            batchRequests = new ArrayList<DsmlMessage>();
        }
        return this.batchRequests;
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

    /**
     * processing 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessing() {
        if (processing == null) {
            return "sequential";
        } else {
            return processing;
        }
    }

    /**
     * processing 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessing(String value) {
        this.processing = value;
    }

    /**
     * responseOrder 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseOrder() {
        if (responseOrder == null) {
            return "sequential";
        } else {
            return responseOrder;
        }
    }

    /**
     * responseOrder 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseOrder(String value) {
        this.responseOrder = value;
    }

    /**
     * onError 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnError() {
        if (onError == null) {
            return "exit";
        } else {
            return onError;
        }
    }

    /**
     * onError 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnError(String value) {
        this.onError = value;
    }

}
