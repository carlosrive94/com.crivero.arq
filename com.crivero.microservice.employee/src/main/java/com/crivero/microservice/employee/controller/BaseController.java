package com.crivero.microservice.employee.controller;

import com.crivero.microservice.employee.Employee;
import com.crivero.microservice.employee.bo.EmployeeBo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@Autowired
	EmployeeBo employeeBo;

	@RequestMapping(value = { "/", "/employees" })
	public List<Employee> getEmployees() {
		return employeeBo.getEmployees();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/delete")
	public void delete(@RequestParam(value = "id") String id) {
		employeeBo.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee/save")
	public void save(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
			@RequestParam(value = "address") String address) {
		employeeBo.save(id, name, address);
	}

}
