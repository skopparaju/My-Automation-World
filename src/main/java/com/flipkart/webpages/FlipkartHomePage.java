package com.flipkart.webpages;

import java.util.List;

import org.openqa.selenium.By;

import com.app.webactions.WebPageActions;

public class FlipkartHomePage extends WebPageActions {
	
	
	By closeButton = By.xpath("(//div/button)[2]");
	
	By mobiles = By.xpath("//span[contains(text(),'Mobiles')]");
	
	By searchBar = By.name("q");
	
	By searchButton = By.xpath("//button[@type='submit']");
	
	By sortOptions = By.xpath("//span[text()='Sort By']/following-sibling::div");
	
	
	public void clickClose() {
		
		clickElement(closeButton);
		
	}
	
	
public void clickMobiles() {
	
	clickElement(mobiles);


}
 

public void enterPoductName(String product) {
	
	enterTextInTextBox(searchBar, product);
	
	
	
}

public void clickSearch() {
	clickElement(searchButton);
}

public List<String> getSortOptions() {
	return getTextFormListofWebElements(sortOptions);
	
}

}
