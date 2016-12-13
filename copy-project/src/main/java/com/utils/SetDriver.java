package com.utils;

import java.io.File;


public class SetDriver {

	private static String MacDriver = LoadProperty.getProperty("chromedriver");
	
	public static void setUpChromeDriver(){
		//System.out.println(MacDriver);
		File cDriver = new File(SetDriver.class.getResource(MacDriver).getFile());
		
		if (!cDriver.canExecute()) {
	         cDriver.setExecutable(true);
	      }
	      System.setProperty("webdriver.chrome.driver", SetDriver.class.getResource(MacDriver).getFile());
	}
	
  
	

}
