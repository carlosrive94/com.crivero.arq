package com.crivero.microservice.employee.bo;

import java.util.List;

import com.crivero.microservice.employee.Employee;

public interface EmployeeBo {

	void save(String id, String name, String address);

	void delete(String id);

	List<Employee> getEmployees();

}