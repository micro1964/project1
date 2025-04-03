package com.reggy.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.reggy.Base;

public class TestUtil extends Base {
	private static final Logger logger = LogManager.getLogger(TestUtil.class);
	public static final int TIMEOUT_IN_SECONDS = 10;
	public static final int POLLING_IN_MILLISECONDS = 2000;
	
	public static String captureScreenshot() {
		String sFilename="";
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			sFilename = PropertiesHandler.getScreenshotFilename();
			FileUtils.copyFile(scrnshot, new File(sFilename));
			
			logInfoMessage("Screenshot taken");
		} catch (IOException e) {
			logErrorMessage(e.getMessage());
		}
		return sFilename;
	}

	public static void logInfoMessage(String message) {
		logger.info(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
	
	public static void logErrorMessage(String message) {
		logger.error(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
	
	public static void logDebugMessage(String message) {
		logger.debug(PropertiesHandler.getDateTimeNow().toLowerCase()+" "+message);
	}
}
