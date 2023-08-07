package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThridClass {

	@AfterSuite
	public void afterExecution() {
		System.out.println("After All Execution Completed");
	}
	
	@Test
	public void method1() {
		System.out.println("Method1");
	}
	
	@Test
	public void method2() {
		System.out.println("Method2");
	}
	
	@Test
	public void method3() {
		System.out.println("Method3");
	}
	
	@Test(enabled=false)
	public void operationAdd() {
		System.out.println("Sum of 3 and 5 is: " + (3+5));
	}
	
	@Parameters({"URL", "Username/ID"})
	@Test
	public void operationSubtract(String url, String user) {
		System.out.println("Subtract 5 from 10 gives: " + (10-5));
		System.out.println(url + " " + user);
	}
	
	@Test(groups= {"Smoke"})
	public void operationMultiply() {
		System.out.println("Multiplication of 4 and 7 gives: " + (4*7));
	}
	
	@Test(dependsOnMethods= {"operationSubtract", "operationMultiply"})
	public void operationDivision() {
		System.out.println("Division of 9 by 3 gives: " + (9/3));
	}
	
	@BeforeSuite
	public void beforeExecution() {
		System.out.println("Before any execution started");
	}
	
	@BeforeClass
	public void beforeClassExecution() {
		System.out.println("Before any execution started in class Thrid");
	}
	
	@AfterClass
	public void afterClassExecution() {
		System.out.println("After all execution completed in class Thrid");
	}
}
