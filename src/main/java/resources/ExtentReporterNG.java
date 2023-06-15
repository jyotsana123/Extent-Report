package resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	public static ExtentReports getReportOject() //In this method we prepare extent report configuration
	{
		//two classes are helpful to generate extent report - ExtentReports, ExptentSparkReporter class
		//ExptentSparkReporter class expect a path where your report should be created, This is responsible to creating report
		String path = System.getProperty("user.dir")+"\\reports\\index.html"; //Give path to create report inside the project
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Web Automation Results");
		//ExtentSparkReporter is a helper class which is helping to create some configuration and that will finally report to it's main class
		
		//ExtentReport class is main class which is responsible to create and consolidate all your test execution
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jyotsana Pandey");
		
		//In framework if we have multiple test cases then we need to write all lines in every test methods, Which is not good approach, So we do it in optimized way
		//So I write these lines somewhere so all the test cases will commonly use that without messing up this code in the actual test
		//So for that there is a concept called TestNG listeners and that will awesomely handle this work.
		//Before that we need add extent report dependency in our project (PropFTXAdmin)
		//So first let me do one thing, for the report handling you need to set up metadata like creating extent spark reporter class object, setting report name, document title,
		//so for that under the resource in main java, let me create one new class to exclusively tell it as ExtentReporterNG. So inside this , Let's create one method which will create a report entry and give the object out of it - Get report object
		//Just copy paste these lines in ExtentReporterNG class (PropFTX/PropFTX.resources/ExtentReporterNG)
		//extent.createTest("testcaseName"); //this create entry for each test case
		return extent;
		
		//to get the report after run you need to write listeners tag inside the testng.xml file then your report will be created
	}
}
