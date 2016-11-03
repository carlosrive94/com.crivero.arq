package com.crivero.web.service.products.service;

import java.util.List;

import com.crivero.web.service.products.dto.Product;

public interface ProductServiceWSO {

	public List<Product> getProducts();

	public String insertProduct(String id, String name, String company);

	public String removeProduct(String id);
}
