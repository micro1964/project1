package com.reggy.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.reggy.Base;

public class PageUtils {

	//WebDriver driver;
	
	public PageUtils() {
		//this.driver = Base.driver;
	}
	private static final Logger logger = LogManager.getLogger(PageUtils.class);
	
	
	
	public void setTextField(WebElement wElement, String strEntry) {
		waitForElementToBeVisible(wElement,TestUtil.TIMEOUT_IN_SECONDS,TestUtil.POLLING_IN_MILLISECONDS);
		wElement.sendKeys(strEntry);
		wElement.sendKeys(Keys.TAB);
		logInfoMessage("Populating Textfield: "+strEntry);
	}
	
	public String getTextFieldContents(WebElement wElement) {
		waitForElementToBeVisible(wElement,TestUtil.TIMEOUT_IN_SECONDS,TestUtil.POLLING_IN_MILLISECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) Base.driver;
		String sText = (String) js.executeScript("return arguments[0].value",wElement);
		//String sText = wElement.getAttribute("value");
		logInfoMessage("Contents of Textfield: "+sText);
		return sText;
	}
	
	
	
	public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds, int pollingInMillis) {
		logInfoMessage("Waiting for WebElement "+element.getAccessibleName());
        FluentWait<WebDriver> wait = new FluentWait<>(Base.driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))  // Maximum wait time
                .pollingEvery(Duration.ofMillis(pollingInMillis))   // Polling interval
                .ignoring(NoSuchElementException.class);           // Ignore NoSuchElementException
        
        wait.until(driver -> element.isDisplayed());
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
