package com.crivero.arq.module.literals;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component("literalsProvider")
public class LiteralsProvider {

	@Autowired
	private ApplicationContext context;
	
	private Locale locale;
	
	public LiteralsProvider(){
		locale = new Locale("es_ES");
	}
	
	public void setLanguage(String language){
		locale = new Locale(language);
	}

	public String getLiteral(String key, Object[] obj) {
		String s;
		try {
			s = context.getMessage(key, obj, locale);
		} catch (NoSuchMessageException e) {
			s = "LITERAL_NOT_FOUND";
		}
		return s;
	}

}
