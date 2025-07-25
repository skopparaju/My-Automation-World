package com.app.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import com.flipkart.webpages.FlipkartHomePage;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FlipkartStepdefinition  {
	
	
	
	FlipkartHomePage FHP = new FlipkartHomePage();
	
	

	
	String actual = "";
	String expected = "";
	List<String> actual_List;
	
	List<String> expected_List;
	
	@Then("^Validate user should able to navigates to mobiles page$")
	public void validate_user_should_able_to_navigates_to_mobiles_page() throws Exception {
		Thread.sleep(1000);
		FHP.clickClose();

       FHP.clickMobiles();
		
		 actual = FHP.getTitle();
		
		Reporter.addStepLog("The current title of the page is "+actual);
		
		 expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		Reporter.addStepLog("The  title should display is "+expected);
		assertEquals(expected,actual);
	}
	
	@When("^User Search for a product$")
	public void User_for_product() throws Exception {
		Thread.sleep(1000);
		FHP.clickClose();
		FHP.enterPoductName("Iphone");
		FHP.clickSearch();
		
		
		Thread.sleep(1000);
		
	}

	
	@Then("^Validate Search result lable should display$")
	public void Validate_Search_result_lable_should_display() {
		
		expected_List = new ArrayList<String>();
		 actual_List = FHP.getSortOptions();
		
		Reporter.addStepLog("The sort options for the product  are "+actual_List);
		String values ="Relevance,Popularity,Price -- Low to High,Price -- High to Low,Newest First";
		
		String[] options = values.split(",");
		
		for(String option:options) {
			expected_List.add(option);	
		} 	
	


		
		Reporter.addStepLog("The sort options for the product  should contain "+expected_List);
		
		assertEquals(expected_List,actual_List);


		
	}
}
