package learning.testData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import learning.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //This will help in running test in parallel so that results are not jumbled up in report
	}
	 
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+" PASSED");
	}
	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String filePath = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			filePath = getScreenShot(result.getMethod().getMethodName()+result.getInstanceName(), driver);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	 
	 
}
