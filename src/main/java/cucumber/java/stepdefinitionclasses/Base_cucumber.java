package cucumber.java.stepdefinitionclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_cucumber {

	public static WebDriver d;
    public static String Target_url;

    @Before
    public void setup() throws IOException {

        Data_Reader f = new Data_Reader();

        String browser = System.getProperty("Browsername") != null
                ? System.getProperty("Browsername")
                : f.Data_Fetcher("Browser");

        Target_url = System.getProperty("url") != null
                ? System.getProperty("url")
                : f.Data_Fetcher("Url");

        if (browser.toLowerCase().contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browser.toLowerCase().contains("headless")) {
                options.addArguments("headless");
            }
            d = new ChromeDriver(options);
        } else {
            WebDriverManager.firefoxdriver().setup();
            d = new FirefoxDriver();
        }

        d.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (d != null) {
        	
        	d.quit();}
        
    }
}
