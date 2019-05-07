package com.xebia.selendroid.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(xpath = "//android.widget.EditText[@index='2']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='email of the customer']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement txtName;
	
	@FindBy(xpath = "//android.widget.CheckBox")
	private WebElement chkTerms;
	
	@FindBy(xpath = "//android.widget.Button")
	private WebElement btnRegistor;
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void enterUserName(String email) {
		txtUserName.clear(); 
		txtUserName.sendKeys(email); 
	}
	
	public void enterEmail(String name) {
		txtEmail.clear(); 
		txtEmail.sendKeys(name); 
	}
	
	public void enterPassword(String name) {
		txtPassword.clear(); 
		txtPassword.sendKeys(name); 
	}
	
	public void checkTermsAndCond() {
		chkTerms.click();
	}
	
	public void clickRegister() {
		btnRegistor.click();  
	}
	
	public String getName() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		return txtName.getAttribute("text");
	}
	
	public boolean isRegisterButtonDisplayed() {
		return btnRegistor.isDisplayed();
	}
	
}
