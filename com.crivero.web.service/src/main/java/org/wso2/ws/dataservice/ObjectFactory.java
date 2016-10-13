
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

    private final static QName _REQUESTSTATUS_QNAME = new QName("http://ws.wso2.org/dataservice", "REQUEST_STATUS");
    private final static QName _Empleados_QNAME = new QName("http://ws.wso2.org/dataservice", "empleados");

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
     * Create an instance of {@link DataServiceFault.SourceDataService }
     * 
     */
    public DataServiceFault.SourceDataService createDataServiceFaultSourceDataService() {
        return new DataServiceFault.SourceDataService();
    }

    /**
     * Create an instance of {@link DATASERVICERESPONSE }
     * 
     */
    public DATASERVICERESPONSE createDATASERVICERESPONSE() {
        return new DATASERVICERESPONSE();
    }

    /**
     * Create an instance of {@link DeleteEmployeeById }
     * 
     */
    public DeleteEmployeeById createDeleteEmployeeById() {
        return new DeleteEmployeeById();
    }

    /**
     * Create an instance of {@link InsertEmployee }
     * 
     */
    public InsertEmployee createInsertEmployee() {
        return new InsertEmployee();
    }

    /**
     * Create an instance of {@link GetEmployees }
     * 
     */
    public GetEmployees createGetEmployees() {
        return new GetEmployees();
    }

    /**
     * Create an instance of {@link Empleados }
     * 
     */
    public Empleados createEmpleados() {
        return new Empleados();
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
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "REQUEST_STATUS")
    public JAXBElement<String> createREQUESTSTATUS(String value) {
        return new JAXBElement<String>(_REQUESTSTATUS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empleados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.wso2.org/dataservice", name = "empleados")
    public JAXBElement<Empleados> createEmpleados(Empleados value) {
        return new JAXBElement<Empleados>(_Empleados_QNAME, Empleados.class, null, value);
    }

}
