//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.03 at 01:07:22 PM IST 
//


package com.bfds.saec.batch.file.domain.in.infoage_individual;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matchIndicatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="matchIndicatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "matchIndicatorType")
@XmlEnum
public enum MatchIndicatorType {

    M,
    H,
    N;

    public String value() {
        return name();
    }

    public static MatchIndicatorType fromValue(String v) {
        return valueOf(v);
    }

}