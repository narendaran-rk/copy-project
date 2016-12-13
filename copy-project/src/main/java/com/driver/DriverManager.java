package com.driver;



import org.openqa.selenium.WebDriver;

public class DriverManager {
	
    private static ThreadLocal<WebDriver> WebDriver = new ThreadLocal<WebDriver>();
    
    public static WebDriver getDriver(){
    	return WebDriver.get();
    }

    public static void setWebDriver(WebDriver driver){
    	WebDriver.set(driver);
    }
    
    
}
