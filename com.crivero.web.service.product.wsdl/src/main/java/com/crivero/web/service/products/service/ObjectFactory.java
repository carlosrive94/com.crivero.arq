
package com.crivero.web.service.products.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.crivero.web.service.products.service package. 
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

    private final static QName _InsertProductResponseReturn_QNAME = new QName("", "return");
    private final static QName _InsertProductName_QNAME = new QName("", "name");
    private final static QName _InsertProductCompany_QNAME = new QName("", "company");
    private final static QName _InsertProductId_QNAME = new QName("", "id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.crivero.web.service.products.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertProductResponse }
     * 
     */
    public InsertProductResponse createInsertProductResponse() {
        return new InsertProductResponse();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link InsertProduct }
     * 
     */
    public InsertProduct createInsertProduct() {
        return new InsertProduct();
    }

    /**
     * Create an instance of {@link RemoveProduct }
     * 
     */
    public RemoveProduct createRemoveProduct() {
        return new RemoveProduct();
    }

    /**
     * Create an instance of {@link RemoveProductResponse }
     * 
     */
    public RemoveProductResponse createRemoveProductResponse() {
        return new RemoveProductResponse();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = InsertProductResponse.class)
    public JAXBElement<String> createInsertProductResponseReturn(String value) {
        return new JAXBElement<String>(_InsertProductResponseReturn_QNAME, String.class, InsertProductResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name", scope = InsertProduct.class)
    public JAXBElement<String> createInsertProductName(String value) {
        return new JAXBElement<String>(_InsertProductName_QNAME, String.class, InsertProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "company", scope = InsertProduct.class)
    public JAXBElement<String> createInsertProductCompany(String value) {
        return new JAXBElement<String>(_InsertProductCompany_QNAME, String.class, InsertProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = InsertProduct.class)
    public JAXBElement<String> createInsertProductId(String value) {
        return new JAXBElement<String>(_InsertProductId_QNAME, String.class, InsertProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "id", scope = RemoveProduct.class)
    public JAXBElement<String> createRemoveProductId(String value) {
        return new JAXBElement<String>(_InsertProductId_QNAME, String.class, RemoveProduct.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = RemoveProductResponse.class)
    public JAXBElement<String> createRemoveProductResponseReturn(String value) {
        return new JAXBElement<String>(_InsertProductResponseReturn_QNAME, String.class, RemoveProductResponse.class, value);
    }

}
