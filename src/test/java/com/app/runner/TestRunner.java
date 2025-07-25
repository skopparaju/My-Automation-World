package com.app.runner;

    import org.junit.runner.RunWith;
    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;

    @RunWith(Cucumber.class)
    @CucumberOptions(
        features = "src/test/resources/Features",
        glue = "com.app.stepdefinitions",
        plugin = {
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@NavigateMobilesPage",
        monochrome = true
    )
    public class TestRunner {
    }