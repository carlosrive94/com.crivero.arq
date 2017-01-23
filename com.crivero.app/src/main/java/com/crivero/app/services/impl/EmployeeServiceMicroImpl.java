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

import com.crivero.app.services.EmployeeService;
import com.crivero.arq.module.configuration.AppProperties;
import com.crivero.arq.module.root.domain.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service("employeeService")
public class EmployeeServiceMicroImpl implements EmployeeService {

	@Autowired
	private AppProperties appProperties;
	final static Logger logger = LogManager.getLogger(EmployeeServiceMicroImpl.class.getName());

	private HttpURLConnection getConnection(URL url) throws IOException {
		if (appProperties.getProperty("proxy-necessary").equals("true")) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.116.8.100", 8080));
			return (HttpURLConnection) url.openConnection(proxy);
		} else
			return (HttpURLConnection) url.openConnection();
	}

	private String getMicroServiceURL() {
		String employeeMsURL = System.getenv("EMPLOYEE_MS_URL");
		if (employeeMsURL == null)
			employeeMsURL = appProperties.getProperty("employee-microservice-url");
		return employeeMsURL;
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		try {
			URL url = new URL(getMicroServiceURL());
			HttpURLConnection conn = getConnection(url);
			conn.setRequestMethod("GET");
			Reader reader = new InputStreamReader(conn.getInputStream());
			Type listType = new TypeToken<List<Employee>>() {
			}.getType();
			employees = new Gson().fromJson(reader, listType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public void insertEmployee(String id, String name, String address) {
		try {
			URL url = new URL(
					getMicroServiceURL() + "/employee/save?id=" + id + "&name=" + name + "&address=" + address);
			HttpURLConnection conn = getConnection(url);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			logger.info(conn.getResponseCode() + ":" + conn.getResponseMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeEmployee(String id) {
		try {
			URL url = new URL(getMicroServiceURL() + "/employee/delete?id=" + id);
			HttpURLConnection conn = getConnection(url);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			logger.info(conn.getResponseCode() + ":" + conn.getResponseMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
