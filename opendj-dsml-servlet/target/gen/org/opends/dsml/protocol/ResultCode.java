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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResultCode complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ResultCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="descr" type="{urn:oasis:names:tc:DSML:2:0:core}LDAPResultCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultCode", namespace = "urn:oasis:names:tc:DSML:2:0:core")
public class ResultCode {

    @XmlAttribute(name = "code", required = true)
    protected int code;
    @XmlAttribute(name = "descr")
    protected LDAPResultCode descr;

    /**
     * code 속성의 값을 가져옵니다.
     * 
     */
    public int getCode() {
        return code;
    }

    /**
     * code 속성의 값을 설정합니다.
     * 
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * descr 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link LDAPResultCode }
     *     
     */
    public LDAPResultCode getDescr() {
        return descr;
    }

    /**
     * descr 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link LDAPResultCode }
     *     
     */
    public void setDescr(LDAPResultCode value) {
        this.descr = value;
    }

}
