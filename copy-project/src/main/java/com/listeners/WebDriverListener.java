package com.listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.driver.DriverManager;
import com.driver.LocalDriverFactory;
import com.utils.SetDriver;

public class WebDriverListener implements IInvokedMethodListener {

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		SetDriver.setUpChromeDriver();
		DriverManager.setWebDriver(LocalDriverFactory.createInstance(method.getTestMethod().getXmlTest().getParameters().get("browserName")));
		WebDriver driver = DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}