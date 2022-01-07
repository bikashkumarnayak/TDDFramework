package com.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;

public  class LocaterFactory {

	LocaterFactory(){
		
	}
	
	private final static Map<String,Function<String,By>>  map=new HashMap<>();
	static {
		map.put("xpath", By::xpath);
		map.put("id", By::id);
		map.put("className", By::className);
		map.put("name", By::name);
		map.put("cssSelector", By::cssSelector);
		map.put("linkText", By::linkText);
		map.put("partialLinkText", By::partialLinkText);
		map.put("tagName", By::tagName);
	}
	
	public static By getLocater(String locater,String value) {
		return map.get(locater).apply(value);
	}
}
