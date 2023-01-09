package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	features="Features",
	glue={"StepDefinitions"})
	
public class Runner extends AbstractTestNGCucumberTests{

}
//target plugins like monochrome ,pretty
//