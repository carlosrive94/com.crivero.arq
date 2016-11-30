package com.crivero.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crivero.app.services.ProductService;
import com.crivero.arq.module.root.domain.Product;
import com.crivero.microservice.product.bo.ProductBo;

@Service("productService")
public class ProductServiceMicroImpl implements ProductService {

	@Autowired
	ProductBo productBo;

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		for (com.crivero.microservice.product.Product p : productBo.getProducts())
			products.add(new Product(p.getId(), p.getName(), p.getCompany()));
		return products;
	}

	public void insertProduct(String id, String name, String address) {
		productBo.save(id, name, address);
	}

	public void removeProduct(String id) {
		productBo.delete(id);
	}

}