package com.reggy.bdd.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.reggy.Base;
import com.reggy.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;



public class Hooks {
	
    @BeforeAll
    public static void before_or_after_all() {
        System.out.println("Before All: Test execution started: "+Base.getCurrentDateAndTime());
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed: " + scenario.getName());
            byte[] screenshotBytes = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "img_"+Base.getCurrentDateAndTime()+".png");
            if(Base.driver!=null) {
            	Base.closeBrowser();
            	Base.logInfoMessage("Closing Browser...");
            }
        }
    }

    @AfterAll
    public static void tearDown() {
        Base.logInfoMessage("After All: Test execution completed.");
        // ExtentCucumberAdapter automatically flushes the report
        if(Base.driver!=null) {
        	Base.closeBrowser();
        	Base.logInfoMessage("Closing Browser...");
        }
    }
    
}
