package com.pages;

/*created by Sakthi Ganesh-11/12/16
 * 
 */
 

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
   	
    public void listSearch(List<WebElement> elementList, String toPlace){
		
		for(WebElement element:elementList){
	    	if(element.getText().contains(toPlace)){
	    		element.click();
	    	}
	    	
	    }
	}
    //Switch to new window
    public void getChildWindow(){
		 String child = null;
		 String parent = driver.getWindowHandle();
		 Set<String> windowSet = driver.getWindowHandles();
		 Iterator<String> it = windowSet.iterator();
		 while(it.hasNext()){
			  child = it.next();
		 }
		 if(!parent.equals(child)){
		 driver.switchTo().window(child);
		 }
		 
    }
    
   //Verifies if the list it sorted 
    public boolean isSorted(List<Integer> sortedPrice)
    {
        boolean sorted = true;        
        for (int i = 1; i < sortedPrice.size(); i++) {
            if (sortedPrice.get(i-1).compareTo(sortedPrice.get(i)) > 0) 
            	sorted = false;
        }

        return sorted;
    }
	

}
