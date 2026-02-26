package cucumber.Runners;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(Listerners.Report_Listen.class)
@CucumberOptions(
    features = "src/main/java/cucumber/feature/files",
    glue = {"cucumber.java.stepdefinitionclasses", "Cumcumber_Negative_Testcases"},
    monochrome = true,
    tags = "@case_plus_plaintiff or @revise_contract",
    plugin = {
        "pretty",
        "summary",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class Case_Add_Runer extends AbstractTestNGCucumberTests { }