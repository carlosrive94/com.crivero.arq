package com.crivero.web.service.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crivero.web.service.employee.dto.Employee;

/*
 * To test the web service
 */
public class App {
	
	public static void main(String args[]) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		EmployeeServiceWSO service = (EmployeeServiceWSO) context.getBean("employeeServiceWSO");
		for (Employee e : service.getEmployees())
			System.out.println(e.getName());
		context.close();
	}

}