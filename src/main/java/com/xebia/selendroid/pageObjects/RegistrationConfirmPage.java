package com.xebia.selendroid.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmPage {
	WebDriver driver;

	@FindBy(xpath = "//android.widget.Button[@text='Register User']")
	private WebElement btnRegister;
	
	public RegistrationConfirmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickRegister() {
		btnRegister.click(); 
		
	}
}
