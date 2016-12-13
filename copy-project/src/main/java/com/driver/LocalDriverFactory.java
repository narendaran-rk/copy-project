package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverFactory {
	
	public static WebDriver createInstance(String browserName){
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.equalsIgnoreCase("chrome")) {
             driver = new ChromeDriver();
            return driver;

	}
		return driver;

}
	
}
