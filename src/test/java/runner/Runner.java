package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	//format={"pretty","json:path/to/json_repot.json"},	
	features=("src/test/resources/Features"),
	glue={"StepDefinitions"},
	plugin = {"pretty", "json:target/json_report.json"},
	tags= ("@Regression"))
	
public class Runner extends AbstractTestNGCucumberTests{

}
//target plugins like monochrome ,pretty
//add tags and reporting in runner file