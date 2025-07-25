package com.app.webactions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.Zip;
import org.zeroturnaround.zip.ZipUtil;

import com.app.filehandles.ExcelHandling;
import com.app.filehandles.PropertyFileHandling;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPageActions extends PropertyFileHandling {

	static WebDriver driver;
	 private static final String OUTPUT_ZIP_FILE = System.getProperty("user.dir")+"\\ZippedReports.zip" ;
	    private static final String SOURCE_FOLDER = System.getProperty("user.dir") + "/Reports"; 


	    
	   List<String>     fileList = new ArrayList < String > ();

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

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(System.getProperty("user.dir") + "/ScreenShots/"+ssName+".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	
public void generateZippedReport() {
	try {
	ZipUtil.pack(new File(System.getProperty("user.dir") + "/Reports"), new File(System.getProperty("user.dir")+"\\CucumberAutomation.zip"));
	}catch(Exception e) {
	e.printStackTrace();	
	}
	}

	
	public void deleteAllReports() {

		File directory = new File(System.getProperty("user.dir") + "/Reports");

		File[] files = directory.listFiles();
		for (File file : files) {

			file.delete();

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

		List<String> listData = new ArrayList<String>();

		for (WebElement ele : getElements(locator)) {

			listData.add(ele.getText());
		}

		;
		return listData;

	}
	
	
	public void pressEnter(By locator) {
		
		getElement(locator).sendKeys(Keys.ENTER);
		
	}

	
	public void quit() {
		driver.quit();
	}
}
