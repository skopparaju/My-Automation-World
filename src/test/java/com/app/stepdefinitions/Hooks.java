package com.app.stepdefinitions;

import java.io.IOException;

import com.app.webactions.WebPageActions;
import com.aventstack.extentreports.ExtentReports;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks extends WebPageActions{
	
	
	@Before
	public void setUp() throws Exception {
		deleteAllReports();
		String browser = getProperty("Browser");
		String url = getProperty("URL");
		launchBroswer(browser);
		sendUrl(url);

		
	}
	
	
	
	@After()
	public void tearDown(Scenario scenario) throws Exception {
		
	String scenarionName =	scenario.getName();
		
		if(scenario.isFailed()) {
		getScreenShot(scenarionName);
		
		String path = System.getProperty("user.dir")+"/ScreenShots/"+scenarionName+".png";
		
		Reporter.addScreenCaptureFromPath(path);
		
		}
		
	ExtentReports report =	Reporter.getExtentReport();
	
	report.flush();
		
		quit();
		generateZippedReport();
		
	}
		

	


}
