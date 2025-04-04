package com.reggy.bdd.stepdefinitions;

import org.testng.AssertJUnit;

import com.reggy.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	HomePage homePage = new HomePage();
	
	String strInput = "sampletext";
	String strInput2 = "random text";
	String strDropdownItem = "Three";
	
	@Given("I am on the application under test")
	public void i_am_on_the_application_under_test() {		 
	    AssertJUnit.assertEquals(homePage.getWindowTitle(),"Web form");
	}

	@When("I type in the TextInput textfield")
	public void i_type_in_the_text_input_textfield() {
		homePage.setTextInputTextField(strInput);
	}

	@Then("I can retrieve the contents typed into the TextInput textfield")
	public void i_can_retrieve_the_contents_typed_into_the_text_input_textfield() {
		String actualResults = homePage.getTextInputTextFieldContents();
		AssertJUnit.assertEquals(strInput, actualResults);
		HomePage.closeBrowser();
	}

	@When("I type in the Password textfield")
	public void i_type_in_the_password_textfield() {
		homePage.setPasswordTextField(strInput);	
	}

	@Then("I can retrieve the contents typed into the Password textfield")
	public void i_can_retrieve_the_contents_typed_into_the_password_textfield() {
		String actualResults = homePage.getPasswordTextFieldContents();
		AssertJUnit.assertEquals(strInput, actualResults);
		HomePage.closeBrowser();
	}

	@When("I type in the TextArea section")
	public void i_type_in_the_text_area_section() {
		homePage.setTextAreaField(strInput2);
	}

	@Then("I can retrieve the contents typed into the TextArea section")
	public void i_can_retrieve_the_contents_typed_into_the_text_area_section() {
		String expectedResults ="random text";
		String actualResults = homePage.getTextAreaFieldContents();
		AssertJUnit.assertEquals(expectedResults, actualResults);
		HomePage.closeBrowser();
	}

	@When("I view the DisabledInput textfield")
	public void i_view_the_disabled_input_textfield() {
		AssertJUnit.assertEquals(true,homePage.isDisabledInputDisplayed());
	}

	@Then("The DisabledInput textfield is disabled")
	public void the_disabled_input_textfield_is_disabled() {
	   AssertJUnit.assertEquals(false,homePage.isDisabledInputEnabled());
	   //homePage.closeBrowser();
	}

	@Then("I cannot retrieve the contents of the textfield")
	public void i_cannot_retrieve_the_contents_of_the_textfield() {
		AssertJUnit.assertEquals(true,homePage.getTextFromDisabledInputField().isEmpty());
		HomePage.closeBrowser();
	}

	@When("I view the ReadOnly textfield")
	public void i_view_the_read_only_textfield() {
	    AssertJUnit.assertEquals(true, homePage.isReadOnlyFieldDisplayed());
	}

	@Then("The ReadOnly textfield is disabled")
	public void the_read_only_textfield_is_disabled() {
		AssertJUnit.assertEquals(false, homePage.isReadOnlyFieldEnabled());
		//homePage.closeBrowser();
	}

	@Then("I can retrieve the contents of the textfield")
	public void i_can_retrieve_the_contents_of_the_textfield() {
		AssertJUnit.assertEquals(false,homePage.getTextFromReadOnlyField().isEmpty());
		HomePage.closeBrowser();
	}

	@When("I select an item from the dropdown list")
	public void i_select_an_item_from_the_dropdown_list() {
	    homePage.selectByVisibleText(strDropdownItem);
	}

	@Then("The item is displayed as selected")
	public void the_item_is_displayed_as_selected() {
	    String actualResults = homePage.getSelectedOption();
	    AssertJUnit.assertEquals(strDropdownItem, actualResults);
	    HomePage.closeBrowser();
	}




}
