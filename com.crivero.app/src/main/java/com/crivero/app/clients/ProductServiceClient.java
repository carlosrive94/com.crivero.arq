package com.crivero.app.clients;

import org.springframework.stereotype.Service;

import com.crivero.app.services.ProductService;
import com.crivero.arq.module.web.service.ServiceClient;

@Service("productServiceClient")
public class ProductServiceClient extends ServiceClient<ProductService> {

	public ProductServiceClient() {
		super(ProductService.class);
	}

}
