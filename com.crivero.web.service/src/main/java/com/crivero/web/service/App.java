package com.crivero.web.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crivero.web.service.beans.Employee;
import com.crivero.web.service.beans.EmployeeBean;

public class App {

	public static void main(String args[]) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		EmployeeBean bean = (EmployeeBean) context.getBean("EmployeeBean");
		for(Employee e : bean.getEmployees()) System.out.println(e.getName());
		context.close();
	}

}