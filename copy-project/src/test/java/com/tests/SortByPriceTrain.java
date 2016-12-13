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
import com.utils.LoadProperty;
import com.utils.SetDriver;

public class SortByPriceTrain {
	
	WebDriver driver;
	HomePage homePage;
	ResultsPage resultsPage;

	 @BeforeTest
	 public void setup(){
		DriverManager.setWebDriver(LocalDriverFactory.createInstance("chrome"));
		driver = DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(LoadProperty.getProperty("baseurl"));
		
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
