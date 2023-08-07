package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="learning.stepDefinition", monochrome=true, plugin= {"html:target/cucumber.html"}, tags = "@ErrorValidation") 
//monochrome helps you to read the reports, runs only ErrorValidation test scenario
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

		
}
