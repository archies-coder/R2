//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.27 at 03:21:31 PM IST 
//
package com.metamug.parser.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 *
 * <pre>
 * &lt;simpleType name="paramType"> &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"> &lt;enumeration value="date"/> &lt;enumeration value="datetime"/> &lt;enumeration value="email"/>
 * &lt;enumeration value="number"/> &lt;enumeration value="text"/> &lt;enumeration value="time"/> &lt;enumeration value="url"/> &lt;/restriction> &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "paramType")
@XmlEnum
public enum ParamType {

    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("datetime")
    DATETIME("datetime"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("number")
    NUMBER("number"),
    @XmlEnumValue("text")
    TEXT("text"),
    @XmlEnumValue("time")
    TIME("time"),
    @XmlEnumValue("url")
    URL("url");
    private final String value;

    ParamType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static ParamType fromValue(String value) {
        for (ParamType paramType : ParamType.values()) {
            if (paramType.value.equals(value)) {
                return paramType;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
