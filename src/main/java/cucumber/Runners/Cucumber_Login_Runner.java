package cucumber.Runners;

import org.testng.annotations.Listeners;

import Listerners.Report_Listen;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Report_Listen.class)
@CucumberOptions(
		
		features ={"src\\main\\java\\cucumber\\feature\\files\\cumcumber_login_.feature",
				"src\\main\\java\\cucumber\\feature\\files\\Negative_Login.feature"},
		glue={"cucumber.java.stepdefinitionclasses", "Cumcumber_Negative_Testcases"},
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html"}
		)

public class Cucumber_Login_Runner extends AbstractTestNGCucumberTests {

	
	
	
	
}
