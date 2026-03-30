package cucumber.java.stepdefinitionclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Listerners.Report_Listen;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_cucumber {

	// This ThreadLocal is storing WebDriver thread wise.
	public static ThreadLocal<WebDriver> D = new ThreadLocal<>();

	// This variable stores target URL globally for cucumber flow.
	public static String Target_url;

	@Before
	public void setup(Scenario scenario) throws IOException {

		Data_Reader f = new Data_Reader();

		String browser = System.getProperty("Browsername") != null? System.getProperty("Browsername"): f.Data_Fetcher("Browser");
        Target_url = System.getProperty("url") != null? System.getProperty("url"): f.Data_Fetcher("Url");

		WebDriver d;

		if (browser.toLowerCase().contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			if (browser.toLowerCase().contains("headless")) {
				options.addArguments("headless");}

			d = new ChromeDriver(options);}
		
		else {

			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();} 

		d.manage().window().maximize();

		// Store current scenario driver in ThreadLocal
		D.set(d);

		// Create current scenario's report node in the same listener flow
		Report_Listen.cucumber_test_initializer(scenario.getName());
	}

	@After
	public void tearDown() {

		WebDriver d = D.get(); 

		// Close current scenario browser
		
	    // d.quit();  

		// Remove driver from ThreadLocal
		D.remove();
	}

	@AfterAll
	public static void flush_cucumber_report() {

		Report_Listen.cucumber_report_flush();
	}
}