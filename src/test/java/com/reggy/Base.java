package com.reggy;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.reggy.Base;
import com.reggy.utils.PropertiesHandler;

public class Base {
	
	public static WebDriver driver;

    private static final Logger logger = LogManager.getLogger(Base.class);
	
    public static ExtentReports extent;
    public static ExtentTest test;
    
    
    public Base() {
    	extent = setUpExtentReports();
    }
    
	public static WebDriver getDriver() {

		try {

			switch (PropertiesHandler.getConfig("browserType")) {
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				
				driver = new ChromeDriver(options);
				logInfoMessage("Chrome Driver is selected.");
				break;

			case "firefox":
				driver = new FirefoxDriver();
				logInfoMessage("Firefox Driver is selected.");
				break;

			case "internetexplorer":
				driver = new InternetExplorerDriver();
				logInfoMessage("Internet Explorer Driver is selected.");
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				logInfoMessage("Internet Explorer Driver is selected.");
				break;
			case "edge":
				driver = new EdgeDriver();
				logInfoMessage("Edge Driver is selected.");
				break;
			default:
				driver = new ChromeDriver();
				logInfoMessage("By default, Chrome Driver is selected");
				break;
			}

		} catch (Exception ex) {
			logErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());
		}

		// Maximise Window
		driver.manage().window().maximize();
		
		// Navigate to Application under test
		goToApplicationUnderTest();
		
		return driver;
	}

	public static void closeBrowser() {
		Set<String> handles = driver.getWindowHandles();
		logInfoMessage("Window handles: - "+handles.size());
		driver.quit();
		logInfoMessage("Closing Browser!!!");
	}

	public static void goToApplicationUnderTest() {
		try {
			Thread.sleep(Duration.ofSeconds(2));
			String sUrl = PropertiesHandler.getConfig("applicationUnderTest");
			driver.get(sUrl);
			logInfoMessage("Navigating to: - "+sUrl);
		} catch (Exception ex) {
			logErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}
	
	public static String getCurrentDateAndTime() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
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
	
	
	public ExtentReports setUpExtentReports() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(PropertiesHandler.testResources+"reports/TestReport_"+PropertiesHandler.getDateTimeNow()+".html");
        htmlReporter.config().setDocumentTitle(PropertiesHandler.getConfig("documentTitle"));
        htmlReporter.config().setReportName(PropertiesHandler.getConfig("reportName"));
        htmlReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "localhost-Dev");
        extent.setSystemInfo("Operating System Name", System.getProperty("os.name"));
        extent.setSystemInfo("Operating System Version", System.getProperty("os.version"));
        extent.setSystemInfo("System Architecture", System.getProperty("os.arch"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Browser Type", PropertiesHandler.getConfig("browserType"));
        
        logInfoMessage("Setting up Extent Reports on:- "+PropertiesHandler.getDateTimeNow());
        return extent;
		}
	
	public static ExtentReports getInstance() {
		extent = null;
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = PropertiesHandler.testResources+"reports/BddReport_" + timestamp + ".html";

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            extent = new ExtentReports();
            extent.setSystemInfo("Environment", "localhost-Dev");
            extent.setSystemInfo("Operating System Name", System.getProperty("os.name"));
            extent.setSystemInfo("Operating System Version", System.getProperty("os.version"));
            extent.setSystemInfo("System Architecture", System.getProperty("os.arch"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            extent.setSystemInfo("Browser Type", PropertiesHandler.getConfig("browserType"));
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
	
	public static void tearDownExtentReports() {
        extent.flush();
        logInfoMessage("Cleaning Extent Reports resources on:- "+PropertiesHandler.getDateTimeNow());
        closeBrowser();
    }
}
