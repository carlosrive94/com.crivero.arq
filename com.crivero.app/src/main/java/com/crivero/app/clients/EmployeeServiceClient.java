package com.crivero.app.clients;

import org.springframework.stereotype.Service;

import com.crivero.app.services.EmployeeService;
import com.crivero.arq.module.web.service.ServiceClient;

@Service("employeeServiceClient")
public class EmployeeServiceClient extends ServiceClient<EmployeeService> {

	public EmployeeServiceClient() {
		super(EmployeeService.class);
	}

}
