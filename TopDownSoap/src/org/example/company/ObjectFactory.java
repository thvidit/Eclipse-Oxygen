
package org.example.company;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.company package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmployeeIdList_QNAME = new QName("http://www.example.org/company", "EmployeeIdList");
    private final static QName _EmployeeInfoList_QNAME = new QName("http://www.example.org/company", "EmployeeInfoList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.company
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmployeeIdWrapper }
     * 
     */
    public EmployeeIdWrapper createEmployeeIdWrapper() {
        return new EmployeeIdWrapper();
    }

    /**
     * Create an instance of {@link EmployeeInfoWrapper }
     * 
     */
    public EmployeeInfoWrapper createEmployeeInfoWrapper() {
        return new EmployeeInfoWrapper();
    }

    /**
     * Create an instance of {@link EmployeeInfo }
     * 
     */
    public EmployeeInfo createEmployeeInfo() {
        return new EmployeeInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeIdWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/company", name = "EmployeeIdList")
    public JAXBElement<EmployeeIdWrapper> createEmployeeIdList(EmployeeIdWrapper value) {
        return new JAXBElement<EmployeeIdWrapper>(_EmployeeIdList_QNAME, EmployeeIdWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeInfoWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/company", name = "EmployeeInfoList")
    public JAXBElement<EmployeeInfoWrapper> createEmployeeInfoList(EmployeeInfoWrapper value) {
        return new JAXBElement<EmployeeInfoWrapper>(_EmployeeInfoList_QNAME, EmployeeInfoWrapper.class, null, value);
    }

}
