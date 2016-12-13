package com.utils;

/*created by Sakthi Ganesh -13/12/2016
 * 
 */
import java.io.File;

// 1) Class name can be changed to DriverManager or something different SetDriver seems likes a method name
public class SetDriver {

	private static String MacDriver = LoadProperty.getProperty("chromedriver");
	
	//does the setup for chrome driver in mac
	
	public static void setUpChromeDriver(){
		//System.out.println(MacDriver);
		File cDriver = new File(SetDriver.class.getResource(MacDriver).getFile());
		
		if (!cDriver.canExecute()) {
	         cDriver.setExecutable(true);
	      }
	      System.setProperty("webdriver.chrome.driver", SetDriver.class.getResource(MacDriver).getFile());
	}
	
  
	

}
