package com.tests;

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
	
	 @BeforeTest
	 public void setup(){
		 ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		 String path = classLoader.getResource("geckodriver.exe").getPath();
		 System.setProperty("webdriver.gecko.driver", path);
		DriverManager.setWebDriver(LocalDriverFactory.createInstance("firefox"));
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
