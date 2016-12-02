package com.crivero.microservice.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crivero.microservice.product.Product;
import com.crivero.microservice.product.bo.ProductBo;

@RestController
public class BaseController {

	@Autowired
	ProductBo productBo;

	@RequestMapping(value = { "/", "/products" })
	public List<Product> getProducts() {
		return productBo.getProducts();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/product/delete")
	public void delete(@RequestParam(value = "id") String id) {
		productBo.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/product/save")
	public void save(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
			@RequestParam(value = "company") String company) {
		productBo.save(id, name, company);
	}

}
