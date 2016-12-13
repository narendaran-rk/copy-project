package com.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.driver.DriverManager;
import com.driver.LocalDriverFactory;
import com.pages.HomePage;
import com.pages.ResultsPage;

public class SortByPriceTrain {
	
	WebDriver driver;
	HomePage homePage;
	ResultsPage resultsPage;
	private static String MAC_DRIVER = "/chromedriver";
	
	 @BeforeTest
	 public void setup(){
		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		 //String path = classLoader.getResource("geckodriver.exe").getPath();
		 File cDriver = new File(SortByPriceTrain.class.getResource(MAC_DRIVER).getFile());
		 
	      // Is it executable
	      if (!cDriver.canExecute()) {
	         cDriver.setExecutable(true);
	      }
	      System.setProperty("webdriver.chrome.driver", SortByPriceTrain.class.getResource(MAC_DRIVER).getFile());
		 //System.setProperty("webdriver.gecko.driver", path);
		DriverManager.setWebDriver(LocalDriverFactory.createInstance("chrome"));
		 driver = DriverManager.getDriver();
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	 }
	 
	 @Test
	 public void sortByPrice() throws InterruptedException{
		 homePage = new HomePage(driver);
		 homePage.travelSearch();
		 resultsPage = new ResultsPage(driver);
	     Assert.assertTrue(resultsPage.verifyFlightPriceSort());
	     Assert.assertTrue(resultsPage.verifyTrainPriceSort());
	     Assert.assertTrue(resultsPage.verifyBusPriceSort());
		 		 
	 }

}
