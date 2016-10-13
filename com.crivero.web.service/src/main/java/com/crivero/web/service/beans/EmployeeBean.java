package com.crivero.web.service.beans;

import java.util.ArrayList;
import java.util.List;

import org.wso2.ws.dataservice.ComCriveroDataService;
import org.wso2.ws.dataservice.DataServiceFault_Exception;

public class EmployeeBean {

	public List<Employee> getEmployees() {
		ComCriveroDataService c = new ComCriveroDataService();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			for (org.wso2.ws.dataservice.Employee e : c.getSOAP11Endpoint().getEmployees()) {
				employees.add(new Employee(e.getID(), e.getNAME(), e.getADDRESS()));
			}
		} catch (DataServiceFault_Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public void insertEmployee(String id, String name, String address) {
		ComCriveroDataService c = new ComCriveroDataService();
		c.getSOAP11Endpoint().insertEmployee(id, name, address);
	}

	public void removeEmployee(String id) {
		ComCriveroDataService c = new ComCriveroDataService();
		c.getSOAP11Endpoint().deleteEmployeeById(id);
	}
}
