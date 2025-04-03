package com.reggy.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.reggy.pages.HomePage;


@Listeners(com.reggy.utils.TestListener.class)
public class HomePageTests {
	
	
	//private static final Logger logger = LogManager.getLogger(HomePageTests.class);

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
	
	@Test(priority=5)
	public void checkThatDisabledInputFieldIsDisabled() {
		boolean expectedResults = false;
		boolean actualResults = homePage.isDisabledInputEnabled();
		AssertJUnit.assertEquals(expectedResults, actualResults);
	}
	
	@Test(priority=6)
	public void checkThatICantReadFromDisabledInput() {
		boolean expectedResults = true;
		boolean actualResults;
		if(homePage.getTextFromDisabledInputField().isEmpty()) {
			actualResults = true;
		}
		else {
			actualResults = false;
		}
		AssertJUnit.assertEquals(expectedResults, actualResults);
	}
	
	@Test(priority=7)
	public void checkThatReadOnlyFieldIsDisabled() {
		boolean expectedResults = false;
		boolean actualResults = homePage.isDisabledInputEnabled();
		AssertJUnit.assertEquals(expectedResults, actualResults);
	}
	
	@Test(priority=8)
	public void checkThatICanReadFromReadOnlyField() {
		boolean expectedResults = true;
		boolean actualResults;
		if(!homePage.getTextFromReadOnlyField().isEmpty()) {
			actualResults = true;
		}
		else {
			actualResults = false;
		}
		AssertJUnit.assertEquals(expectedResults, actualResults);
	}
	
}
