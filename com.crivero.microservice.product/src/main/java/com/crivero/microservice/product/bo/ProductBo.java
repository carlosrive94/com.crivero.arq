package com.crivero.microservice.product.bo;

import java.util.List;

import com.crivero.microservice.product.Product;

public interface ProductBo {

	void save(String id, String name, String company);

	void delete(String id);

	List<Product> getProducts();

}