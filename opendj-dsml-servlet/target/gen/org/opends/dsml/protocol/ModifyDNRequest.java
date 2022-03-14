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
 * <p>ModifyDNRequest complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ModifyDNRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:DSML:2:0:core}DsmlMessage">
 *       &lt;attribute name="dn" use="required" type="{urn:oasis:names:tc:DSML:2:0:core}DsmlDN" />
 *       &lt;attribute name="newrdn" use="required" type="{urn:oasis:names:tc:DSML:2:0:core}DsmlRDN" />
 *       &lt;attribute name="deleteoldrdn" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="newSuperior" type="{urn:oasis:names:tc:DSML:2:0:core}DsmlDN" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyDNRequest", namespace = "urn:oasis:names:tc:DSML:2:0:core")
public class ModifyDNRequest
    extends DsmlMessage
{

    @XmlAttribute(name = "dn", required = true)
    protected String dn;
    @XmlAttribute(name = "newrdn", required = true)
    protected String newrdn;
    @XmlAttribute(name = "deleteoldrdn")
    protected Boolean deleteoldrdn;
    @XmlAttribute(name = "newSuperior")
    protected String newSuperior;

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
     * newrdn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewrdn() {
        return newrdn;
    }

    /**
     * newrdn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewrdn(String value) {
        this.newrdn = value;
    }

    /**
     * deleteoldrdn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDeleteoldrdn() {
        if (deleteoldrdn == null) {
            return true;
        } else {
            return deleteoldrdn;
        }
    }

    /**
     * deleteoldrdn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteoldrdn(Boolean value) {
        this.deleteoldrdn = value;
    }

    /**
     * newSuperior 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSuperior() {
        return newSuperior;
    }

    /**
     * newSuperior 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSuperior(String value) {
        this.newSuperior = value;
    }

}
