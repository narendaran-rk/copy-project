package com.listeners;


import org.testng.IExecutionListener;

import com.utils.SetDriver;

public class WebDriverListener implements IExecutionListener {

	
	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		
	}

	public void onExecutionStart() {
	   SetDriver.setUpChromeDriver();
		
	}

}