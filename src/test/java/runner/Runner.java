package runner;



import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utility.BrowserUtil;
import utility.FirstandFinal;


@CucumberOptions(
	
	features=("src/test/resources/Features"),
	glue={"StepDefinitions"},
	plugin = {"pretty","summary", "json:target/json_report.json", "html:target/cucumber-report.html"},
	monochrome = true,
	tags= ("@Regression"))
	
public class Runner extends AbstractTestNGCucumberTests{




@AfterClass
public void tearDown() {
	BrowserUtil.exitBrowser(FirstandFinal.driver);
}	
