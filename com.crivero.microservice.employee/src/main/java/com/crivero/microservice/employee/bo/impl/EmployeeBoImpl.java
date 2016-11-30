package com.crivero.microservice.employee.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crivero.microservice.employee.Employee;
import com.crivero.microservice.employee.bo.EmployeeBo;
import com.crivero.microservice.employee.dao.EmployeeDao;

@Repository("employeeBo")
public class EmployeeBoImpl implements EmployeeBo {

	@Autowired
	EmployeeDao employeeDao;

	public void save(Employee employee) {
		
	}

	public void delete(String id) {
		employeeDao.delete(id);
	}

	@Override
	public void save(String id, String name, String address) {
		employeeDao.save(id, name, address);		
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

}