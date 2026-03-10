package cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src\\main\\java\\cucumber\\feature\\files\\Leads.feature",
		glue="cucumber.java.stepdefinitionclasses",
		tags=" @leadsadmin",
		monochrome=true,
		plugin={
				"pretty",
				"summary",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			}
		)

public class Lead_runner extends AbstractTestNGCucumberTests{

}
