package TestComponent;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportOject();
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());  //we need to pass the method name in the argument 
		                                                               //result object is containing detail about the test case so you can extract test case name with it.
	}

	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed");
	}

	
	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, "Test Failed");
	}

	
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, "Test Skipped");
	}

	
}
