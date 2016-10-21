package com.crivero.web.service.employee;

import java.util.List;

import com.crivero.web.service.employee.dto.Employee;

public interface EmployeeServiceWSO {

	public List<Employee> getEmployees();
	public String insertEmployee(String id, String name, String address);
	public String removeEmployee(String id);
}
