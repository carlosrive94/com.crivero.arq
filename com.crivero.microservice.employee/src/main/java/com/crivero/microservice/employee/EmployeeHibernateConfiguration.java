package com.crivero.microservice.employee;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class EmployeeHibernateConfiguration  {
	
	private boolean local = false;
	private String pcf_hostname = "us-cdbr-iron-east-04.cleardb.net";
	private String pcf_port = "3306";
	private String pcf_username = "bc7f8a08fdca6e";
	private String pcf_password = "1e12f674";
	private String pcf_schema = "ad_1fa92171941f578"; 

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		if (local) {
			dmds.setUrl("jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC");
			dmds.setUsername("root");
			dmds.setPassword("1234");
		} else {
			dmds.setUrl("jdbc:mysql://" + pcf_hostname + ":" + pcf_port + "/" + pcf_schema
					+ "?useSSL=false&serverTimezone=UTC");
			dmds.setUsername(pcf_username);
			dmds.setPassword(pcf_password);
		}
		return dmds;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
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
