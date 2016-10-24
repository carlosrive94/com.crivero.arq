package com.crivero.app.controller;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crivero.app.clients.EmployeeServiceClient;
import com.crivero.arq.module.configuration.AppProperties;
import com.crivero.arq.module.literals.LiteralsProvider;
import com.crivero.arq.module.root.domain.Application;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	final static Logger logger = LogManager.getLogger(BaseController.class.getName());

	@Autowired
	private Application application;

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private LiteralsProvider literalsProvider;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		String msg = "";

		String employees = employeeServiceClient.getService().getEmployees().toString();

		String literal1 = literalsProvider.getLiteral("customer.name", new Object[] { 28, "google.com" }, Locale.US);
		String literal2 = literalsProvider.getLiteral("customer.namer", new Object[] { 28, "google.com" },
				new Locale("ES"));
		String property1 = appProperties.getProperty("hello.url");
		String property2 = appProperties.getProperty("hello.db");
		String property3 = appProperties.getProperty("error.lalala");

		msg = "Simple bean: " + application + "\n";
		model.addAttribute("message1", msg);
		msg = "Property from a file: " + property1 + "\n";
		model.addAttribute("message2", msg);
		msg = "Propery from default: " + property2 + "\n";
		model.addAttribute("message3", msg);
		msg = "Propery not found: " + property3 + "\n";
		model.addAttribute("message4", msg);
		msg = "Literal: " + literal1 + "\n";
		model.addAttribute("message5", msg);
		msg = "Literal not found: " + literal2 + "\n";
		model.addAttribute("message6", msg);
		msg = "Employees: " + employees;
		model.addAttribute("message7", msg);

		logger.info("app opened");

		return VIEW_INDEX;

	}
}