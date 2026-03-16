package cucumber.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\main\\java\\cucumber\\feature\\files\\Case_Module.feature",
	    glue = "cucumber.java.stepdefinitionclasses",
	    monochrome = true,
	    tags = "@Lien_Calculate",
	    plugin = {
	        "pretty",
	        "summary",
	        "json:target/cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
		
		)



public class Lien_Calculator extends AbstractTestNGCucumberTests{

}
