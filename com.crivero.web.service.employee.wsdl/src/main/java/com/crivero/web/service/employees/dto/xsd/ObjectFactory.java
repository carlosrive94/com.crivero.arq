
package com.crivero.web.service.employees.dto.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.crivero.web.service.employees.dto.xsd package. 
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

    private final static QName _EmployeeId_QNAME = new QName("", "id");
    private final static QName _EmployeeAddress_QNAME = new QName("", "address");
    private final static QName _EmployeeName_QNAME = new QName("", "name");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.crivero.web.service.employees.dto.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = Employee.class)
    public JAXBElement<String> createEmployeeId(String value) {
        return new JAXBElement<String>(_EmployeeId_QNAME, String.class, Employee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address", scope = Employee.class)
    public JAXBElement<String> createEmployeeAddress(String value) {
        return new JAXBElement<String>(_EmployeeAddress_QNAME, String.class, Employee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name", scope = Employee.class)
    public JAXBElement<String> createEmployeeName(String value) {
        return new JAXBElement<String>(_EmployeeName_QNAME, String.class, Employee.class, value);
    }

}
