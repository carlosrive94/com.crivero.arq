package com.crivero.web.service.employees.service;

import java.util.ArrayList;
import java.util.List;

import org.wso2.ws.dataservice.ComCriveroDataService;
import org.wso2.ws.dataservice.DataServiceFault_Exception;

import com.crivero.web.service.employees.dto.Employee;

public class EmployeeServiceWSOImpl implements EmployeeServiceWSO {

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

	public String insertEmployee(String id, String name, String address) {
		ComCriveroDataService c = new ComCriveroDataService();
		try {
			c.getSOAP11Endpoint().insertEmployee(id, name, address);
		} catch (Exception e) {
			return "Error inserting employee";
		}
		return "Employee inserted successfully";
	}

	public String removeEmployee(String id) {
		ComCriveroDataService c = new ComCriveroDataService();
		try {
			c.getSOAP11Endpoint().deleteEmployeeById(id);
		} catch (Exception e) {
			return "Error removing employee";
		}
		return "Employee removed successfully";
	}
}
