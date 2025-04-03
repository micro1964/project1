package com.reggy.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.reggy.pages.HomePage;
import com.reggy.utils.PropertiesHandler;


@Listeners(com.reggy.utils.TestListener.class)
public class HomePageTests {
	
	
	private static final Logger logger = LogManager.getLogger(HomePageTests.class);

	HomePage homePage = new HomePage();
	
	@Test(priority=1)
	public void checkIAmOnHomePage() {
		AssertJUnit.assertEquals(homePage.getWindowTitle(),"Web form");
	}
	
	@Test(priority=2)
	public void checkICanSetAndGetTextInputFieldContents() {
		String strInput = "sampletext";
		homePage.setTextInputTextField(strInput);
		
		String actualResults = homePage.getTextInputTextFieldContents();
		
		AssertJUnit.assertEquals(strInput, actualResults);
	}
	
	@Test(priority=3)
	public void checkIcanSetAndGetPasswordFieldContents() {
		String input ="password";
		homePage.setPasswordTextField(input);
		
		String actualResults = homePage.getPasswordTextFieldContents();
		
		AssertJUnit.assertEquals(input, actualResults);
	}
	
	@Test(priority=4)
	public void checkIcanSetAndGetTextAreaFieldContents() {
		String input ="random text";
		homePage.setTextAreaField(input);
		
		String actualResults = homePage.getTextAreaFieldContents();
		
		AssertJUnit.assertEquals(input, actualResults);
	}
	
	private static void logInfoMessage(String message) {
		logger.info(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
	
	private static void logErrorMessage(String message) {
		logger.error(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
	
	private static void logDebugMessage(String message) {
		logger.debug(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
}
