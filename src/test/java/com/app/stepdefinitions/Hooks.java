package com.app.stepdefinitions;

import com.app.webactions.WebPageActions;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends WebPageActions {

    @Before
    public void setUp() throws Exception {
        deleteAllReports();
        String browser = getProperty("Browser");
        String url = getProperty("URL");
        launchBroswer(browser);
        sendUrl(url);
        ExtentCucumberAdapter.addTestStepLog("Flipkart Application Launched Successfully");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        String scenarionName = scenario.getName();

        if (scenario.isFailed()) {
            getScreenShot(scenarionName);

            String path = System.getProperty("user.dir") + "/ScreenShots/" + scenarionName + ".png";
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(path);

        }
        ExtentService.flush();
        quit();
        generateZippedReport();
    }
}