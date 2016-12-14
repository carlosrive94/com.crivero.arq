package com.crivero.microservice.employee;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class EmployeeHibernateConfiguration {

	private String hostname;
	private String port;
	private String username;
	private String password;
	private String name;

	private void updateCredentials() {
		String vcap_services = System.getenv("VCAP_SERVICES");
		if (vcap_services != null && vcap_services.length() > 0) {
			JsonObject obj = (JsonObject) new JsonParser().parse(vcap_services);
			Entry<String, JsonElement> dbEntry = null;
			Set<Entry<String, JsonElement>> entries = obj.entrySet();

			for (Entry<String, JsonElement> eachEntry : entries) {
				if (eachEntry.getKey().equals("cleardb")) {
					dbEntry = eachEntry;
					break;
				}
			}
			if (dbEntry == null) {
				throw new RuntimeException("Could not find cleardb key in VCAP_SERVICES env variable");
			}
			obj = (JsonObject) ((JsonArray) dbEntry.getValue()).get(0);
			JsonObject credentials = (JsonObject) obj.get("credentials");
			hostname = credentials.get("hostname").getAsString();
			port = credentials.get("port").getAsString();
			username = credentials.get("username").getAsString();
			password = credentials.get("password").getAsString();
			name = credentials.get("name").getAsString();
		} else {
			hostname = "localhost";
			port = "3306";
			username = "root";
			password = "1234";
			name = "world";
		}
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		updateCredentials();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://" + hostname + ":" + port + "/" + name + "?useSSL=false&serverTimezone=UTC");
		dmds.setUsername(username);
		dmds.setPassword(password);
		return dmds;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "validate");
		return properties;
	}

	@Bean
	public LocalSessionFactoryBean employeeSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource());
		lsfb.setHibernateProperties(hibernateProperties());
		lsfb.setPackagesToScan(new String[] { "com.criverom.microservice.employee" });
		lsfb.setAnnotatedClasses(Employee.class);
		return lsfb;
	}
}
