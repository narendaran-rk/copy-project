package com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {
	
	private static String path = "/config.properties";
	
	
	public static String getProperty(String key){
		Properties prop = new Properties();
		InputStream input = null;
		String value = null;
		
		try{
			input = new FileInputStream(LoadProperty.class.getResource(path).getPath());
			prop.load(input);
			value =prop.getProperty(key);
			
		}catch(Exception e){
			
		}
		return value;
		
	}

}
