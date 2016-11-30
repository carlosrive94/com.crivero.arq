package com.crivero.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crivero.app.services.EmployeeService;
import com.crivero.arq.module.root.domain.Employee;
import com.crivero.microservice.employee.bo.EmployeeBo;

@Service("employeeService")
public class EmployeeServiceMicroImpl implements EmployeeService {

	@Autowired
	EmployeeBo employeeBo;

	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		for (com.crivero.microservice.employee.Employee e : employeeBo.getEmployees())
			employees.add(new Employee(e.getId(), e.getName(), e.getAddress()));
		return employees;
	}

	public void insertEmployee(String id, String name, String address) {
		employeeBo.save(id, name, address);
	}

	public void removeEmployee(String id) {
		employeeBo.delete(id);
	}

}
