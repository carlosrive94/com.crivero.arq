package com.crivero.app.services.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crivero.arq.module.root.domain.Employee;
import com.crivero.web.service.employees.service.EmployeeServiceWSO;
import com.crivero.app.services.EmployeeService;

//@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public List<Employee> getEmployees() {
		EmployeeServiceWSO service = new EmployeeServiceWSO();
		List<com.crivero.web.service.employees.dto.xsd.Employee> serviceEmployees = service
				.getEmployeeServiceWSOHttpSoap11Endpoint().getEmployees();
		List<Employee> employees = new ArrayList<Employee>();

		for (com.crivero.web.service.employees.dto.xsd.Employee e : serviceEmployees) {
			String id = e.getId().getValue();
			String name = e.getName().getValue();
			String address = e.getAddress().getValue();
			employees.add(new Employee(id, name, address));
		}
		return employees;
	}

	public void insertEmployee(String id, String name, String address) {
		EmployeeServiceWSO service = new EmployeeServiceWSO();
		service.getEmployeeServiceWSOHttpSoap11Endpoint().insertEmployee(id, name, address);
	}

	public void removeEmployee(String id) {
		EmployeeServiceWSO service = new EmployeeServiceWSO();
		service.getEmployeeServiceWSOHttpSoap11Endpoint().removeEmployee(id);
	}
}
