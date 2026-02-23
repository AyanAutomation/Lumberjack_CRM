package cucumber.Runners;

import org.testng.annotations.Listeners;

import Listerners.Report_Listen;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Report_Listen.class)
@CucumberOptions(
		
		features ="src\\main\\java\\cucumber\\feature\\files",
		glue={ "cucumber.java.stepdefinitionclasses", "Cumcumber_Negative_Testcases" },
		monochrome = true,
		tags = "@negative_Validation or @positve_login",
		plugin = {"pretty", "html:target/cucumber.html"}
		)

public class Cucumber_Login_Runner extends AbstractTestNGCucumberTests {

	
	
	
	
}
