package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.FunctionLibrary;


/*Updated by Sakthi Ganesh-12/12/16
 *
 */

public class ResultsPage extends BasePage {

	WebDriver driver;

	public ResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[@data-key='dw.sorting.price']")
	WebElement priceSort;

	@FindBy(xpath = "//div[contains(@class, 'resultPrice')]/div[contains(@class,'priceContainer')]/span/span[contains(@class,'priceMain')]")
	List<WebElement> trvlResultList;

	@FindBy(xpath = "//div[contains(@class,'ResultTabs')]//li[1]/a")
	WebElement train;

	@FindBy(xpath = "//div[contains(@class,'ResultTabs')]//li[2]/a")
	WebElement flight;

	@FindBy(xpath = "//div[contains(@class,'ResultTabs')]//li[3]/a")
	WebElement bus;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextPage;

	@FindBy(xpath = "//div[contains(@class,'Paging__active')]")
	WebElement activePage;

	@FindBy(xpath = "//div[contains(@class,'tabsBody')]/div/div[1]//div/span[@data-key='dw.select']")
	WebElement select;

	@FindBy(xpath = "//span[contains(text(),'Alternative dates')]")
	WebElement altDate;

	List<Integer> sortedPrice = new ArrayList<Integer>();

	public Boolean verifyTrainPriceSort() {
		train.click();
		Boolean isSorted = verifySort();
		System.out.println("Train" + isSorted);
		return isSorted;
	}

	public Boolean verifyBusPriceSort() {
		bus.click();
		Boolean isSorted = verifySort();
		System.out.println("Bus" + isSorted);
		return isSorted;
	}

	public Boolean verifyFlightPriceSort() {
		getChildWindow();
		flight.click();
		Boolean isSorted = verifySort();
		System.out.println("Flight" + isSorted);
		return isSorted;
	}
    //gets the listed prices and verifies if the list is sorted
	public Boolean verifySort() {
		sortedPrice.clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		for (WebElement element : trvlResultList) {
			sortedPrice.add(Integer.parseInt(element.getText()));
		}
        //to get the list of prices if more than one page is present
		try {
			if (nextPage.isDisplayed()) {
				int y = 1;
				sortedPrice.clear();
               /*while pagination exists and price list is shown for the date selected
				For Alternate dates, the loop is aborted*/
				while (driver
						.findElements(
								By.xpath("//div[contains(@class,'Paging__cell') and contains(text(),"
										+ "\'" + y + "\')]")).size() > 0
						&& driver
								.findElements(
										By.xpath("//span[contains(text(),'Alternative dates')]"))
								.size() == 0) {

					for (WebElement element : trvlResultList) {
						String price = element.getText();
						price = FunctionLibrary.removeComma(price);
					    sortedPrice.add(Integer.parseInt(price));
					}

					y++;
					WebElement clickNext = wait
							.until(ExpectedConditions.elementToBeClickable(By
									.xpath("//div[contains(@class,'Paging__cell') and contains(text(),"
											+ "\'" + y + "\')]")));
					executor.executeScript("arguments[0].click();", clickNext);

				}

			}
		} catch (Exception e) {
			System.out.println("No more Next Page");

		}

		Boolean isItSorted = isSorted(sortedPrice);
		sortedPrice.clear();
		return isItSorted;

	}

}