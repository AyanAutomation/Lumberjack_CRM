package cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/main/java/cucumber/feature/files/Attorney_Staff.feature",
		glue="cucumber.java.stepdefinitionclasses",
		tags="@Attorney",
		monochrome=true,
		plugin={
		        "pretty",
		        "summary",
		        "json:target/cucumber.json",
		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		    })


public class Attorney_Module_Runner extends AbstractTestNGCucumberTests{

}
