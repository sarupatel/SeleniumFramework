package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		System.out.println("TEST " + result.getName()+ " PASSED");
	}
}
