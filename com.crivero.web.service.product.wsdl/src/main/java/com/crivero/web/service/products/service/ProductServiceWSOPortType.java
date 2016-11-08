package com.crivero.web.service.products.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2016-11-08T13:38:09.741+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebService(targetNamespace = "http://service.products.service.web.crivero.com", name = "productServiceWSOPortType")
@XmlSeeAlso({ObjectFactory.class, com.crivero.web.service.products.dto.xsd.ObjectFactory.class})
public interface ProductServiceWSOPortType {

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "urn:insertProduct", output = "urn:insertProductResponse")
    @RequestWrapper(localName = "insertProduct", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.InsertProduct")
    @WebMethod(action = "urn:insertProduct")
    @ResponseWrapper(localName = "insertProductResponse", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.InsertProductResponse")
    public java.lang.String insertProduct(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "company", targetNamespace = "")
        java.lang.String company
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "urn:getProducts", output = "urn:getProductsResponse")
    @RequestWrapper(localName = "getProducts", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.GetProducts")
    @WebMethod(action = "urn:getProducts")
    @ResponseWrapper(localName = "getProductsResponse", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.GetProductsResponse")
    public java.util.List<com.crivero.web.service.products.dto.xsd.Product> getProducts();

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "urn:removeProduct", output = "urn:removeProductResponse")
    @RequestWrapper(localName = "removeProduct", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.RemoveProduct")
    @WebMethod(action = "urn:removeProduct")
    @ResponseWrapper(localName = "removeProductResponse", targetNamespace = "http://service.products.service.web.crivero.com", className = "com.crivero.web.service.products.service.RemoveProductResponse")
    public java.lang.String removeProduct(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id
    );
}
