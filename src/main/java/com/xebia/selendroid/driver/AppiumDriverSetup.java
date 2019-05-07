package com.xebia.selendroid.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.xebia.selendroid.util.PropFileHandler;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDriverSetup {

	WebDriver driver;
	PropFileHandler _propFileHandle = new PropFileHandler(new Properties());
	String deviceName = _propFileHandle.readProperty("config", "deviceName");
	String browser = _propFileHandle.readProperty("config", "browser");
	String browser_version = _propFileHandle.readProperty("config", "browser_version");
	String platform = _propFileHandle.readProperty("config", "platform");
	String appPakage = _propFileHandle.readProperty("config", "appPakage");
	String appActivity = _propFileHandle.readProperty("config", "appActivity");
	String remoteURL = _propFileHandle.readProperty("config", "appiumAddress");

	public WebDriver driverSetup() throws MalformedURLException {
		startAppiumServer();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
		capabilities.setCapability(CapabilityType.VERSION, browser_version);
		capabilities.setCapability("platformName", platform);
		capabilities.setCapability("appPackage", appPakage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("automationName", "uiautomator2");

		driver = new AndroidDriver(new URL("http://" + remoteURL + "/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public static void startAppiumServer() {
		try {
			CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
			command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
			command.addArgument("--address", false);
			command.addArgument("0.0.0.0");
			command.addArgument("--port", false);
			command.addArgument("4723");
			command.addArgument("--full-reset", false);
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(1);
			executor.execute(command, resultHandler);
		} catch (ExecuteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
