package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {

	@AfterTest(groups= {"Smoke"})
	public void lastTest() {
		System.out.println("Last Test Execution");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Second Test");
	}
	
	@BeforeTest
	public void firstTest() {
		System.out.println("First Test Executed");
	}
}
