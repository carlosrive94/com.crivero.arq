package com.crivero.microservice.product;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.crivero.microservice.HibernateConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfiguration.class)
public class ProductHibernateConfiguration {

	@Autowired
	HibernateConfiguration hibernateConfiguration;

	@Bean
	public LocalSessionFactoryBean productSessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(hibernateConfiguration.dataSource());
		lsfb.setHibernateProperties(hibernateConfiguration.hibernateProperties());
		lsfb.setPackagesToScan(new String[] { "com.criverom.microservice.product" });
		lsfb.setAnnotatedClasses(Product.class);
		return lsfb;
	}
}
