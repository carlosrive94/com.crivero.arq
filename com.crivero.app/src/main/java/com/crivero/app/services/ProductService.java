package com.crivero.app.services;

import java.util.List;

import com.crivero.arq.module.root.domain.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void insertProduct(String id, String name, String company);

	public void removeProduct(String id);
}
