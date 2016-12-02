package com.crivero.microservice.employee.dao;

import java.util.List;

import com.crivero.microservice.employee.Employee;

public interface EmployeeDao {

	void delete(String id);

	void save(String id, String name, String address);

	List<Employee> getEmployees();

}