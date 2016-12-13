package com.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*created by Sakthi Ganesh-11/12/16
 * 
 */

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(id ="from_filter")
	WebElement frmFilter;
	
	@FindBy(id = "to_filter")
	WebElement toFilter;

	@FindBy(xpath = "//img[@title='Departure date']")
	WebElement calendar;
	
	@FindBy(xpath = "//a[contains(@class,'active')]")
	WebElement dptDate;
		
	@FindBy(id = "search-form__submit-btn")
	WebElement srchButton;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']//li/a")
	List<WebElement> frmList;
	
	@FindBy(xpath = "//ul[@id='ui-id-2']//li/a")
	List<WebElement> toList;
	
	
	 public HomePage(WebDriver driver){
		 super(driver);
		 this.driver = driver;
		
	 }
	
	//Search for places to travel between
	public void travelSearch() throws InterruptedException{
		
		frmFilter.sendKeys("Berlin");
	    listSearch(frmList, "Berlin");
		toFilter.sendKeys("prague");
		listSearch(toList, "Prague");
		calendar.click();
		dptDate.click();
		srchButton.click();
	
				
	}
	
	
	
	
}
