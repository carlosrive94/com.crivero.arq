package com.crivero.web.service.employees.service;

import java.util.List;

import com.crivero.web.service.employees.dto.Employee;

public interface EmployeeServiceWSO {

	public List<Employee> getEmployees();
	public String insertEmployee(String id, String name, String address);
	public String removeEmployee(String id);
}
