package com.xebia.selendroid.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebViewInteractionPage {

	WebDriver driver; 
	
	@FindBy(xpath = "//android.widget.TextView[@index='1']")
	private WebElement txtName ;
	
	
	
	public WebViewInteractionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
}
