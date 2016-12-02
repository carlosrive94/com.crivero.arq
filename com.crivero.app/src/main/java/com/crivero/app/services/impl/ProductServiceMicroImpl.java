package com.crivero.app.services.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crivero.app.services.ProductService;
import com.crivero.arq.module.configuration.AppProperties;
import com.crivero.arq.module.root.domain.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("productService")
public class ProductServiceMicroImpl implements ProductService {

	@Autowired
	private AppProperties appProperties;	
	private String hostname = "http://comcriveromicroserviceproduct.cfapps.io";
	final static Logger logger = LogManager.getLogger(ProductServiceMicroImpl.class.getName());

	private HttpURLConnection getConnection(URL url) throws IOException {
		if (appProperties.getProperty("com.crivero.app-local").equals("true")) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.116.8.100", 8080));
			return (HttpURLConnection) url.openConnection(proxy);
		} else
			return (HttpURLConnection) url.openConnection();
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		try {
			URL url = new URL(hostname + "/products");
			HttpURLConnection conn = getConnection(url);
			conn.setRequestMethod("GET");
			Reader reader = new InputStreamReader(conn.getInputStream());
			Type listType = new TypeToken<List<Product>>() {
			}.getType();
			products = new Gson().fromJson(reader, listType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public void insertProduct(String id, String name, String company) {
		try {
			URL url = new URL(hostname + "/product/save?id=" + id + "&name=" + name + "&company=" + company);
			HttpURLConnection conn = getConnection(url);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			logger.info(conn.getResponseCode() + ":" + conn.getResponseMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeProduct(String id) {
		try {
			URL url = new URL(hostname + "/product/delete?id=" + id);
			HttpURLConnection conn = getConnection(url);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			logger.info(conn.getResponseCode() + ":" + conn.getResponseMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}