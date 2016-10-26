
package com.crivero.web.service.employee;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.crivero.web.service.employee package. 
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

    private final static QName _RemoveEmployeeId_QNAME = new QName("", "id");
    private final static QName _InsertEmployeeAddress_QNAME = new QName("", "address");
    private final static QName _InsertEmployeeName_QNAME = new QName("", "name");
    private final static QName _RemoveEmployeeResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.crivero.web.service.employee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveEmployee }
     * 
     */
    public RemoveEmployee createRemoveEmployee() {
        return new RemoveEmployee();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link InsertEmployeeResponse }
     * 
     */
    public InsertEmployeeResponse createInsertEmployeeResponse() {
        return new InsertEmployeeResponse();
    }

    /**
     * Create an instance of {@link GetEmployeesResponse }
     * 
     */
    public GetEmployeesResponse createGetEmployeesResponse() {
        return new GetEmployeesResponse();
    }

    /**
     * Create an instance of {@link InsertEmployee }
     * 
     */
    public InsertEmployee createInsertEmployee() {
        return new InsertEmployee();
    }

    /**
     * Create an instance of {@link RemoveEmployeeResponse }
     * 
     */
    public RemoveEmployeeResponse createRemoveEmployeeResponse() {
        return new RemoveEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = RemoveEmployee.class)
    public JAXBElement<String> createRemoveEmployeeId(String value) {
        return new JAXBElement<String>(_RemoveEmployeeId_QNAME, String.class, RemoveEmployee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = InsertEmployee.class)
    public JAXBElement<String> createInsertEmployeeId(String value) {
        return new JAXBElement<String>(_RemoveEmployeeId_QNAME, String.class, InsertEmployee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "address", scope = InsertEmployee.class)
    public JAXBElement<String> createInsertEmployeeAddress(String value) {
        return new JAXBElement<String>(_InsertEmployeeAddress_QNAME, String.class, InsertEmployee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name", scope = InsertEmployee.class)
    public JAXBElement<String> createInsertEmployeeName(String value) {
        return new JAXBElement<String>(_InsertEmployeeName_QNAME, String.class, InsertEmployee.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = RemoveEmployeeResponse.class)
    public JAXBElement<String> createRemoveEmployeeResponseReturn(String value) {
        return new JAXBElement<String>(_RemoveEmployeeResponseReturn_QNAME, String.class, RemoveEmployeeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = InsertEmployeeResponse.class)
    public JAXBElement<String> createInsertEmployeeResponseReturn(String value) {
        return new JAXBElement<String>(_RemoveEmployeeResponseReturn_QNAME, String.class, InsertEmployeeResponse.class, value);
    }

}
