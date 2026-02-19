package cucumber.java.stepdefinitionclasses;

import org.testng.annotations.Listeners;

import Listerners.Report_Listen;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Report_Listen.class)
@CucumberOptions(
		
		features ="src\\main\\java\\cucumber\\feature\\files",
		glue={"cucumber.java.stepdefinitionclasses", "Cumcumber_Negative_Testcases"},
		tags = "@neg_login",
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html"}
		
		)

public class Cucumber_Login_Runner extends AbstractTestNGCucumberTests {

	
	
	
	
}
