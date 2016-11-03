package com.crivero.web.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crivero.web.service.employees.dto.Employee;
import com.crivero.web.service.employees.service.EmployeeServiceWSO;
import com.crivero.web.service.products.dto.Product;
import com.crivero.web.service.products.service.ProductServiceWSO;

/*
 * To test the web service
 */
public class App {
	
	public static void main(String args[]) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		EmployeeServiceWSO employeeService = (EmployeeServiceWSO) context.getBean("employeeServiceWSO");
		System.out.println("Employees:");
		for (Employee e : employeeService.getEmployees())
			System.out.println(e.getName());
		
		ProductServiceWSO productService = (ProductServiceWSO) context.getBean("productServiceWSO");
		System.out.println("Products:");
		for (Product p : productService.getProducts())
			System.out.println(p.getName());
		
		context.close();
	}

}