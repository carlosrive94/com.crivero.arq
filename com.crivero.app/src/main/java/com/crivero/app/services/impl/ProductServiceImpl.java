/* DEPRECATED

package com.crivero.app.services.impl;

import java.util.ArrayList;

import java.util.List;

import com.crivero.arq.module.root.domain.Product;
import com.crivero.web.service.products.service.ProductServiceWSO;
import com.crivero.app.services.ProductService;

//@Service("productService")
public class ProductServiceImpl implements ProductService {

	public List<Product> getProducts() {
		ProductServiceWSO service = new ProductServiceWSO();
		List<com.crivero.web.service.products.dto.xsd.Product> serviceProducts = service.getProductServiceWSOHttpSoap12Endpoint()
				.getProducts();
		List<Product> products = new ArrayList<Product>();

		for (com.crivero.web.service.products.dto.xsd.Product p : serviceProducts) {
			String id = p.getId().getValue();
			String name = p.getName().getValue();
			String company = p.getCompany().getValue();
			products.add(new Product(id, name, company));
		}
		return products;
	}

	public void insertProduct(String id, String name, String company) {
		ProductServiceWSO service = new ProductServiceWSO();
		service.getProductServiceWSOHttpSoap12Endpoint().insertProduct(id, name, company);
	}

	public void removeProduct(String id) {
		ProductServiceWSO service = new ProductServiceWSO();
		service.getProductServiceWSOHttpSoap12Endpoint().removeProduct(id);
	}
}

*/
