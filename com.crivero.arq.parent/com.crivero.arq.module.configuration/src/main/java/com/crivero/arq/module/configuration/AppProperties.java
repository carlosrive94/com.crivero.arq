package com.crivero.arq.module.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({ "classpath:default.properties", // default
		"classpath:hello.properties" // if same key, this will 'win'
})
public class AppProperties {

	@Autowired
	private Environment env;

	public String getProperty(String property) {
		return env.getProperty(property);
	}
}
