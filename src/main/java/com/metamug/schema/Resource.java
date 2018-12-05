//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2016.01.07 at 10:53:17 AM IST
//
package com.metamug.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"desc", "request"})
@XmlRootElement(name = "Resource")
public class Resource {

    @XmlElement(name = "Desc")
    protected String desc;
    @XmlElement(name = "Request")
    protected List<Request> request;
    @XmlAttribute(name = "v", required = true)
    protected double version;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "parent")
    protected String parent;
    @XmlAttribute(name = "auth")
    private String auth;
    
    private boolean testable = false;
    
    public boolean isTestable() {
        return testable;        
    }
    
    public void setTestable(boolean t) {
        testable = t;
    }

    /**
     * Gets the value of the desc property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the request property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there is
     * not a <CODE>set</CODE> method for the request property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequest().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Request }
     *
     *
     * @return
     */
    public List<Request> getRequest() {
        if (request == null) {
            request = new ArrayList<>();
        }
        return this.request;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     */
    public double getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param version
     */
    public void setVersion(double version) {
        this.version = version;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the parent property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setParent(String value) {
        this.parent = value;
    }

    /**
     *
     * @return
     */
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
