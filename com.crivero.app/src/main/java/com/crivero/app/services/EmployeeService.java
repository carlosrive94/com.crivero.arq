package com.crivero.app.services;
import java.util.List;

import com.crivero.arq.module.root.domain.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void insertEmployee(String id, String name, String address);

	public void removeEmployee(String id);
}
