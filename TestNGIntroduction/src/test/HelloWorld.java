package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HelloWorld {

	@Test
	public void displayHelloWorld() {
		System.out.println("Hello World");
	}
	
	@Parameters({"URL"})
	@Test
	public void displayName(String url) {
		System.out.println("My Name is " + url);
	}
	
	@Test
	public void displayBirthDate() {
		System.out.println("Birth date is 1/1/1990");
	}
	
	@Test(groups= {"Smoke"})
	public void goodBye() {
		System.out.println("Good Bye");
	}
	
	@BeforeMethod
	public void beforeMethodExecution() {
		System.out.println("Before Method Execution");
	}
	
	@AfterMethod
	public void afterMethodExecution() {
		System.out.println("After Method Execution");
	}
}
