package com.crivero.arq.module.root.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	
	final static Logger logger = LogManager.getLogger(AppInitializer.class.getName());

	@Override
	public void onStartup(ServletContext servletContext) {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);

		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("primefaces.THEME","casablanca");

		// Create the dispatcher servlet's Spring application context
		// AnnotationConfigWebApplicationContext dispatcherContext = new
		// AnnotationConfigWebApplicationContext();
		// dispatcherContext.register(WebMvcConfig.class);

		// Register and map the dispatcher servlet
		Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		logger.info("INITIALIZED SUCCESSFULLY");
	}

}
