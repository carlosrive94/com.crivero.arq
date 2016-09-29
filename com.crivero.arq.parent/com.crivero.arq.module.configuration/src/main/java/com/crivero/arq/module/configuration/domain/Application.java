package com.crivero.arq.module.configuration.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("application")
public class Application {

	@Autowired
	@Qualifier("applicationUser")
	private ApplicationUser user;

	@Override
	public String toString() {
		return "Application [user=" + user + "]";
	}
}
