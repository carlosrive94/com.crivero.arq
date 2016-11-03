package com.crivero.web.service.products.service;

import java.util.ArrayList;
import java.util.List;

import org.wso2.ws.dataservice.ComCriveroDataService;
import org.wso2.ws.dataservice.DataServiceFault_Exception;

import com.crivero.web.service.products.dto.Product;

public class ProductServiceWSOImpl implements ProductServiceWSO {

	public List<Product> getProducts() {
		ComCriveroDataService c = new ComCriveroDataService();
		List<Product> products = new ArrayList<Product>();
		try {
			for (org.wso2.ws.dataservice.Product p : c.getSOAP11Endpoint().getProducts()) {
				products.add(new Product(p.getId(), p.getName(), p.getCompany()));
			}
		} catch (DataServiceFault_Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public String insertProduct(String id, String name, String company) {
		ComCriveroDataService c = new ComCriveroDataService();
		try {
			c.getSOAP11Endpoint().insertProduct(id, name, company);
		} catch (Exception e) {
			return "Error inserting product";
		}
		return "Product inserted successfully";
	}

	public String removeProduct(String id) {
		ComCriveroDataService c = new ComCriveroDataService();
		try {
			c.getSOAP11Endpoint().deleteProductById(id);
		} catch (Exception e) {
			return "Error removing product";
		}
		return "Product removed successfully";
	}
}
