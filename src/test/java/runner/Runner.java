package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	
	features=("src/test/resources/Features"),
	glue={"StepDefinitions"},
	plugin = {"pretty", "json:target/json_report.json"},
	monochrome = true,
	tags= ("@Regression"))
	
public class Runner extends AbstractTestNGCucumberTests{

}
//target plugins like monochrome ,pretty
//add tags and reporting in runner file