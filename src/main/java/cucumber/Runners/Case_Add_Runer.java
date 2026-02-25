package cucumber.Runners;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src\\main\\java\\cucumber\\feature\\files\\Case_Module.feature",
		glue = "cucumber.java.stepdefinitionclasses",
		monochrome=true,
		tags="@case_plus_plaintiff or @revise_contract",plugin = {"pretty", "html:target/cucumber.html"}
		
		)
@Listeners(Listerners.Report_Listen.class)
public class Case_Add_Runer extends AbstractTestNGCucumberTests{
	
	

}
