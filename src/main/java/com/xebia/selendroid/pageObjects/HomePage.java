package com.xebia.selendroid.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='startUserRegistrationCD']")
	private WebElement btnNewUser;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='buttonStartWebviewCD']")
	private WebElement btnStartWeb;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc='visibleButtonTestCD']")
	private WebElement btnDisplayText;
	
	@FindBy(xpath = "//android.widget.Button[@text='Display Popup Window']")
	private WebElement btnOpenPopUp;
	
	@FindBy(xpath = "//android.widget.Button[@text='Displays a Toast']")
	private WebElement btnDisplayToast;
	
	@FindBy(xpath = "//android.widget.TextView[@index='1']")
	private WebElement lblDisplayedText;
	
	@FindBy(xpath = "//android.widget.Toast[1]")
	private WebElement toast;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickNewUserButton() {
		btnNewUser.click();
	}
	
	public boolean isNewUserButtonDisplayed() {
		return btnNewUser.isDisplayed();
	}
	
	public void clickStartWebButton() {
		btnStartWeb.click();
	}
	
	public void clickDisplayText() {
		btnDisplayText.click();
	}
	
	public void clickDisplayToast() {
		btnDisplayToast.click();
	}
	
	public void clickOpenPopUp() {
		btnOpenPopUp.click();
	}
	
	public void dismissPopUP() {
		driver.switchTo().alert().dismiss(); 
	}
	
	public String getToastText() {
		return toast.getAttribute("name") ;
	}
	
	public String getDisplayedText() {
		return lblDisplayedText.getText() ;
	}
}
