package com.crivero.arq.module.web.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class ServiceClient<T> implements InitializingBean, ApplicationContextAware {

	private T service;
	
	private Class<T> serviceClass;
	
	private ApplicationContext applicationContext;

	protected ServiceClient(Class<T> serviceClass) {
		this.serviceClass = serviceClass;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		T service = applicationContext.getBean(serviceClass);
		this.service = service;
	}

	public T getService() {
		return service;
	}
	
}
