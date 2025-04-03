package com.reggy.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/com/reggy/bdd/featurefiles/"},
glue= {"com.reggy.bdd.stepdefinitions"},
plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CukeTest extends AbstractTestNGCucumberTests{

}
