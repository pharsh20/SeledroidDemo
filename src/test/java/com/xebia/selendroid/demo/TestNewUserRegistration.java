package com.xebia.selendroid.demo;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.xebia.selendroid.driver.AppiumDriverSetup;
import com.xebia.selendroid.pageObjects.HomePage;
import com.xebia.selendroid.pageObjects.RegistrationConfirmPage;
import com.xebia.selendroid.pageObjects.RegistrationPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestNewUserRegistration {

	HomePage home;
	RegistrationPage regis;
	RegistrationConfirmPage regisConfm;

	WebDriver driver;

	@Before
	public void driverSetup() throws MalformedURLException {
		driver = new AppiumDriverSetup().driverSetup();

	}

	@Given("^Application is open$")
	public void application_is_open() throws Throwable {
		home = new HomePage(driver);
		Assert.assertTrue(home.isNewUserButtonDisplayed());
		throw new PendingException();
	}

	@Given("^I navigate to new user registration screen$")
	public void i_navigate_to_new_user_registration_screen() throws Throwable {

		home.clickNewUserButton();
		throw new PendingException();
	}

	@When("^I enter all valid data \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_enter_all_valid_data(String firstName, String password, String email, String name) throws Throwable {
		regis = new RegistrationPage(driver);
		regis.enterUserName(firstName);
		regis.enterPassword(password);
		regis.enterEmail(email);
		Assert.assertTrue("Displayed Name didn't match the expected", regis.getName().contains(name));

		throw new PendingException();
	}

	@When("^accept terms and register$")
	public void accept_terms_and_register() throws Throwable {
		regis.checkTermsAndCond();
		regis.clickRegister();

		regisConfm = new RegistrationConfirmPage(driver);
		regisConfm.clickRegister();

		throw new PendingException();
	}

	@Then("^User should be register$")
	public void user_should_be_register() throws Throwable {
		Assert.assertTrue("Register button is not displayed", home.isNewUserButtonDisplayed());
		throw new PendingException();
	}

	@When("^I click display text$")
	public void i_click_display_text() throws Throwable {
		home.clickDisplayText();
		throw new PendingException();
	}

	@Then("^I see text$")
	public void i_see_text() throws Throwable {
		Assert.assertTrue(home.getDisplayedText().contains("Text is sometimes displayed"));
		throw new PendingException();
	}

	@Then("^I click display toast$")
	public void i_click_display_toast() throws Throwable {
		home.clickDisplayToast();
		throw new PendingException();
	}

	@Then("^I see toast$")
	public void i_see_toast() throws Throwable {
		Assert.assertTrue(home.getToastText().contains("Hello selendroid toast!"));
		throw new PendingException();
	}

	@Then("^I click display pop up$")
	public void i_click_display_pop_up() throws Throwable {
		home.clickOpenPopUp();
		throw new PendingException();
	}

	@Then("^I see and dsimiss pop up$")
	public void i_see_pop_up() throws Throwable {
		home.dismissPopUP();
		throw new PendingException();
	}

	@After
	public void stopAppium() throws Exception {
		try {
			driver.quit();
			String[] command = { "/usr/bin/killall", "-KILL", "node" };
			Runtime.getRuntime().exec(command);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
