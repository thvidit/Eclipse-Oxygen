
package org.example.company;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EmployeeTitle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EmployeeTitle"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Manager"/&gt;
 *     &lt;enumeration value="C1 Engineer"/&gt;
 *     &lt;enumeration value="C2 Engineer"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EmployeeTitle")
@XmlEnum
public enum EmployeeTitle {

    @XmlEnumValue("Manager")
    MANAGER("Manager"),
    @XmlEnumValue("C1 Engineer")
    C_1_ENGINEER("C1 Engineer"),
    @XmlEnumValue("C2 Engineer")
    C_2_ENGINEER("C2 Engineer");
    private final String value;

    EmployeeTitle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EmployeeTitle fromValue(String v) {
        for (EmployeeTitle c: EmployeeTitle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
