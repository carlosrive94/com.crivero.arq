package com.crivero.microservice.product.dao;

import java.util.List;

import com.crivero.microservice.product.Product;

public interface ProductDao {

	void delete(String id);

	void save(String id, String name, String company);

	List<Product> getProducts();

}