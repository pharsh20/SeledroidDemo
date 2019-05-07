package com.xebia.selendroid.demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/com/xebia/selendroid/features" },
		// glue={"com/apium/poc/StepDefinition"},
		plugin = { "html:target/cucumber-html-report" })

public class TestRunner {

}
