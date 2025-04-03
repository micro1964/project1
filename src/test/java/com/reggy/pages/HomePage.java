package com.reggy.pages;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reggy.Base;
import com.reggy.utils.PageUtils;
import com.reggy.utils.PropertiesHandler;



public class HomePage extends Base{
	@FindBy(xpath = "//*[@id=\"my-text-id\"]") private WebElement TextInputTextField;
	@FindBy(xpath = "//input[@name='my-password']") private WebElement PasswordField;
	@FindBy(xpath = "//textarea[@name='my-textarea']") private WebElement TextArea;
	@FindBy(xpath = "//input[@name='my-disabled']") private WebElement DisabledInput;
	@FindBy(xpath = "//input[@name='my-readonly']") private WebElement ReadOnlyInput;
	@FindBy(xpath = "//a[contains(@href, 'index.html')]") private WebElement ReturnToIndexLink;
	@FindBy(xpath = "//select[@name='my-select']") private WebElement DropdownList;
	@FindBy(name = "my-datalist") private WebElement DataListInput;
	@FindBy(name = "my-file") private WebElement FileInputField;
	@FindBy(id = "my-check-1") private WebElement CheckBox;
	@FindBy(id = "my-check-2") private WebElement DefaultCheckBox;
	@FindBy(id = "my-radio-1") private WebElement CheckedRadioButton;
	@FindBy(id = "my-radio-2") private WebElement DefaultRadioButton;
	@FindBy(xpath = "//button[text()='Submit']") private WebElement SubmitButton;
	@FindBy(name = "my-colors") private WebElement ColorPicker;
	@FindBy(name = "my-date") private WebElement DateInput;
	@FindBy(name = "my-range") private WebElement RangeInput;
	








	

	
	


	PageUtils pageUtils = new PageUtils();
	
	WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	public HomePage() {
		this.driver = getDriver();
		PageFactory.initElements(driver, this);
		logDebugMessage("PageFactory initialised on HomePage.");
	}
	
	
    // Set the range input value using JavaScript (e.g., set to value '7')
    public void setRangeValueUsingJS(int value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));";
        js.executeScript(script, RangeInput, value);
    }

    // Get the current value from the range input
    public String getRangeValue() {
        return RangeInput.getAttribute("value");
    }
	
	
	
	// Upload a file by setting the file path
    public void uploadFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            FileInputField.sendKeys(file.getAbsolutePath());
        } else {
            logInfoMessage("File not found: " + filePath);
        }
    }
	
	public String getWindowTitle() {
		logInfoMessage("Retrieving the browser title");
		return driver.getTitle();
	}
	
	public void setTextInputTextField(String input) {
		pageUtils.setTextField(TextInputTextField, input);
	}
	
	public String getTextInputTextFieldContents() {
		return pageUtils.getTextFieldContents(TextInputTextField);
	}
	
	public void setPasswordTextField(String input) {
		pageUtils.setTextField(PasswordField, input);
	}
	
	public String getPasswordTextFieldContents() {
		return pageUtils.getTextFieldContents(PasswordField);
	}
	
	public void setTextAreaField(String input) {
		pageUtils.setTextField(TextArea, input);
	}
	
	public String getTextAreaFieldContents() {
		return pageUtils.getTextFieldContents(TextArea);
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
