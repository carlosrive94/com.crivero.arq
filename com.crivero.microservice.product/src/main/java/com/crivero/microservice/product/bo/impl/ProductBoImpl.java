package com.crivero.microservice.product.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crivero.microservice.product.Product;
import com.crivero.microservice.product.bo.ProductBo;
import com.crivero.microservice.product.dao.ProductDao;

@Repository("productBo")
public class ProductBoImpl implements ProductBo {

	@Autowired
	ProductDao productDao;

	public void save(Product product) {
		
	}

	public void delete(String id) {
		productDao.delete(id);
	}

	@Override
	public void save(String id, String name, String company) {
		productDao.save(id, name, company);		
	}

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

}