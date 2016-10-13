package com.crivero.web.service.beans;

import java.util.List;

import org.wso2.ws.dataservice.ComCriveroDataService;
import org.wso2.ws.dataservice.DataServiceFault_Exception;
import org.wso2.ws.dataservice.Employee;

public class EmployeeBean {

	public List<Employee> getEmployees(){
		ComCriveroDataService c = new ComCriveroDataService();
		List<Employee> employees = null;
		try {
			employees = c.getSOAP11Endpoint().getEmployees();
		} catch (DataServiceFault_Exception e) {
			e.printStackTrace();
		}
		return employees;		
	}
	
	public void insertEmployee(String id, String name, String address){
		ComCriveroDataService c = new ComCriveroDataService();
		c.getSOAP11Endpoint().insertEmployee(id, name, address);
	}
	
	public void removeEmployee(String id){
		ComCriveroDataService c = new ComCriveroDataService();
		c.getSOAP11Endpoint().deleteEmployeeById(id);
	}
}
