package com.app.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.flipkart.webpages.FlipkartHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartStepdefinition {

    FlipkartHomePage FHP = new FlipkartHomePage();

    String actual = "";
    String expected = "";
    List<String> actual_List;
    List<String> expected_List;

    @Then("^Validate user should able to navigates to mobiles page$")
    public void validate_user_should_able_to_navigates_to_mobiles_page() throws Exception {
        Thread.sleep(1000);
        FHP.clickMobiles();
        actual = FHP.getTitle();
        expected = "Mobile Phones Online at Best Prices in India";
        assertEquals("Mismatch in page title ",expected, actual);
        ExtentCucumberAdapter.addTestStepLog("Successfully navigated to mobiles page");
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
        expected_List = new ArrayList<>();
        actual_List = FHP.getSortOptions();

        String values = "Relevance,Popularity,Price -- Low to High,Price -- High to Low,Newest First";
        String[] options = values.split(",");

        for (String option : options) {
            expected_List.add(option);
        }


        assertEquals(expected_List, actual_List);
    }
}