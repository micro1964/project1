package com.reggy.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reggy.Base;

public class TestListener implements ITestListener{
	
	ExtentReports e = Base.extent;
	ExtentTest t;
	
	@Override
	public void onStart(ITestContext context) {
		//context.getName()
		//ITestListener.super.onStart(context);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		t = e.createTest(result.getName());
		t.pass("The actual results are as expected");
		t.log(Status.PASS, "Results are as expected");
		}
	
	@Override
	public void onTestFailure(ITestResult result) {
		t = e.createTest(result.getName());
		
		try {	
			String sFilename = TestUtil.captureScreenshot();
			t.addScreenCaptureFromPath(sFilename);
			t.fail("The actual results don't match the expected");
			t.log(Status.FAIL, result.getThrowable());
		}
		catch(Exception e) {
			result.getThrowable();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		t = e.createTest(result.getName());
		t.skip("This test was skipped");
		t.log(Status.SKIP, "Test not executed");
		}


	@Override
	public void onFinish(ITestContext context) {
		//e.flush();
		Base.tearDownExtentReports();
	}

	
	
}
