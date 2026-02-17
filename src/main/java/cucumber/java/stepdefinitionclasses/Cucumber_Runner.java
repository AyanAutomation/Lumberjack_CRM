package cucumber.java.stepdefinitionclasses;

import org.testng.annotations.Listeners;

import Listerners.Report_Listen;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(Report_Listen.class)
@CucumberOptions(
		
		features ="src\\main\\java\\cucumber\\feature\\files",
		glue={"cucumber.java.stepdefinitionclasses"},
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html"}
		
		)

public class Cucumber_Runner extends AbstractTestNGCucumberTests {

	
	
	
	
}
