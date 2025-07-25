package com.app.webactions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.zeroturnaround.zip.ZipUtil;
import com.app.filehandles.PropertyFileHandling;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPageActions extends PropertyFileHandling {

    static WebDriver driver;

    public void launchBroswer(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
    }

    public void sendUrl(String url) {
        driver.get(url);
    }

    public void getScreenShot(String ssName) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + ssName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateZippedReport() {
        try {
            ZipUtil.pack(
                new File(System.getProperty("user.dir") + "/Reports"),
                new File(System.getProperty("user.dir") + "\\CucumberAutomation.zip")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllReports() {
        File directory = new File(System.getProperty("user.dir") + "/Reports");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        getElement(locator).click();
    }

    public void enterTextInTextBox(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<String> getTextFormListofWebElements(By locator) {
        List<String> listData = new ArrayList<>();
        for (WebElement ele : getElements(locator)) {
            listData.add(ele.getText());
        }
        return listData;
    }

    public void pressEnter(By locator) {
        getElement(locator).sendKeys(Keys.ENTER);
    }

    public void quit() {
        driver.quit();
    }
}