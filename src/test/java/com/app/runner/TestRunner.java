package com.app.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags= {"@ValidateSortOptions,@NavigateMobilesPage1"},
		features= {"src/test/resources/Features"},
		glue= {"com.app.stepdefinitions"},
		plugin = {"pretty","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:Reports/CucumberAutomation.html"},
		
		monochrome=true
		
		)


public class TestRunner {
	
	
	@AfterClass
	public static void writeExtentReport() {
		
	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	
	
	
}
	

}
