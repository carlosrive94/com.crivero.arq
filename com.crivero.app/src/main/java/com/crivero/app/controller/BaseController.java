package com.crivero.app.controller;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crivero.app.clients.EmployeeServiceClient;
import com.crivero.app.clients.ProductServiceClient;
import com.crivero.arq.module.configuration.AppProperties;
import com.crivero.arq.module.literals.LiteralsProvider;
import com.crivero.arq.module.root.domain.Application;
import com.crivero.arq.module.root.domain.Employee;
import com.crivero.arq.module.root.domain.Product;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	private static final String VIEW_EMPLOYEES = "employees";
	private static final String VIEW_PRODUCTS = "products";
	private static final String VIEW_PRIMEFACES = "primefaces";
	private static final String VIEW_LITERALS = "literals";
	private static final String VIEW_PROPERTIES = "properties";
	private static final String VIEW_SIMPLEBEAN = "simplebean";
	final static Logger logger = LogManager.getLogger(BaseController.class.getName());

	@Autowired
	private Application application;

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private LiteralsProvider literalsProvider;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private ProductServiceClient productServiceClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/simpleBean", method = RequestMethod.GET)
	public String simpleBean(ModelMap model) {
		String msg = "";
		msg = "Simple bean: " + application + "\n";
		model.addAttribute("bean1", msg);
		return VIEW_SIMPLEBEAN;
	}

	@RequestMapping(value = "/properties", method = RequestMethod.GET)
	public String properties(ModelMap model) {
		String msg = "";

		String property1 = appProperties.getProperty("hello.url");
		msg = "Property from a file: " + property1;
		model.addAttribute("property1", msg);

		String property2 = appProperties.getProperty("hello.db");
		msg = "Propery from default: " + property2;
		model.addAttribute("property2", msg);

		String property3 = appProperties.getProperty("error.lalala");
		msg = "Propery not found: " + property3;
		model.addAttribute("property3", msg);

		return VIEW_PROPERTIES;
	}

	@RequestMapping(value = "/literals", method = RequestMethod.GET)
	public String literals(ModelMap model) {
		String msg = "";
		String literal1 = literalsProvider.getLiteral("customer.name", new Object[] { 28, "google.com" }, Locale.US);
		msg = "Literal en: " + literal1;
		model.addAttribute("literal1", msg);

		String literal2 = literalsProvider.getLiteral("customer.name", new Object[] { 28, "forocoches.com" },
				new Locale("ES"));
		msg = "Literal es: " + literal2;
		model.addAttribute("literal2", msg);

		String literal3 = literalsProvider.getLiteral("customer.namer", new Object[] { 28, "google.com" },
				new Locale("ES"));
		msg = "Literal not found: " + literal3;
		model.addAttribute("literal3", msg);
		return VIEW_LITERALS;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String employees(ModelMap model) {
		String msg = "";
		String employees = "";
		for (Employee e : employeeServiceClient.getService().getEmployees()) {
			employees += "{" + e.getId() + ": " + e.getName() + "}, ";
		}
		msg = "Employees: " + employees;
		model.addAttribute("employees", msg);
		return VIEW_EMPLOYEES;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(ModelMap model, @RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name, @RequestParam(value = "address") String address) {
		employeeServiceClient.getService().insertEmployee(id, name, address);
		return "redirect:" + VIEW_EMPLOYEES;
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(ModelMap model, @RequestParam(value = "id") String id) {
		employeeServiceClient.getService().removeEmployee(id);
		return "redirect:" + VIEW_EMPLOYEES;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(ModelMap model) {
		String msg = "";
		String products = "";
		for (Product p : productServiceClient.getService().getProducts()) {
			products += "{" + p.getId() + ": " + p.getName() + "}, ";
		}
		msg = "Products: " + products;
		model.addAttribute("products", msg);
		return VIEW_PRODUCTS;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(ModelMap model, @RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name, @RequestParam(value = "company") String company) {
		productServiceClient.getService().insertProduct(id, name, company);
		return "redirect:" + VIEW_PRODUCTS;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(ModelMap model, @RequestParam(value = "id") String id) {
		productServiceClient.getService().removeProduct(id);
		return "redirect:" + VIEW_PRODUCTS;
	}

	@RequestMapping(value = "/primefaces", method = RequestMethod.GET)
	public String primefaces(ModelMap model) {
		return VIEW_PRIMEFACES;
	}
}