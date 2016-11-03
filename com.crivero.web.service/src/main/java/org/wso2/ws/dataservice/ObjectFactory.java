
package org.wso2.ws.dataservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.wso2.ws.dataservice package. 
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

    private final static QName _Employees_QNAME = new QName("http://ws.wso2.org/dataservice", "employees");
    private final static QName _Products_QNAME = new QName("http://ws.wso2.org/dataservice", "products");
    private final static QName _REQUESTSTATUS_QNAME = new QName("http://ws.wso2.org/dataservice", "REQUEST_STATUS");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.wso2.ws.dataservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataServiceFault }
     * 
     */
    public DataServiceFault createDataServiceFault() {
        return new DataServiceFault();
    }

    /**
     * Create an instance of {@link DATASERVICERESPONSE }
     * 
     */
    public DATASERVICERESPONSE createDATASERVICERESPONSE() {
        return new DATASERVICERESPONSE();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link InsertEmployee }
     * 
     */
    public InsertEmployee createInsertEmployee() {
        return new InsertEmployee();
    }

    /**
     * Create an instance of {@link DataServiceFault.SourceDataService }
     * 
     */
    public DataServiceFault.SourceDataService createDataServiceFaultSourceDataService() {
        return new DataServiceFault.SourceDataService();
    }

    /**
     * Create an instance of {@link DeleteProductById }
     * 
     */
    public DeleteProductById createDeleteProductById() {
        return new DeleteProductById();
    }

    /**
     * Create an instance of {@link Products }
     * 
     */
    public Products createProducts() {
        return new Products();
    }

    /**
     * Create an instance of {@link Employees }
     * 
     */
    public Employees createEmployees() {
        return new Employees();
    }

    /**
     * Create an instance of {@link InsertProduct }
     * 
     */
    public InsertProduct createInsertProduct() {
        return new InsertProduct();
    }

    /**
     * Create an instance of {@link DeleteEmployeeById }
     * 
     */
    public DeleteEmployeeById createDeleteEmployeeById() {
        return new DeleteEmployeeById();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Employees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "employees")
    public JAXBElement<Employees> createEmployees(Employees value) {
        return new JAXBElement<Employees>(_Employees_QNAME, Employees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Products }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "products")
    public JAXBElement<Products> createProducts(Products value) {
        return new JAXBElement<Products>(_Products_QNAME, Products.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "REQUEST_STATUS")
    public JAXBElement<String> createREQUESTSTATUS(String value) {
        return new JAXBElement<String>(_REQUESTSTATUS_QNAME, String.class, null, value);
    }

}
