package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	 public WebDriver d;
	public static String Target_url;
	
	
	@BeforeMethod
	public void setup() throws IOException{
		
		d = new ChromeDriver();	
    Data_Reader f = new Data_Reader();
		
	String Browser = System.getProperty("Browsername")!=null ? System.getProperty("Browsername") : f.Data_Fetcher("Browser");	
	Target_url = System.getProperty("url")!=null ? System.getProperty("url"):f.Data_Fetcher("Url");
	
	if(Browser.equalsIgnoreCase("Chrome")){
		
		WebDriverManager.chromedriver().setup();
        //d = new ChromeDriver();
        d.manage().window().maximize();}
	
	if(Browser.equalsIgnoreCase("Firefox")){
		
		 WebDriverManager.firefoxdriver().setup();
         d = new FirefoxDriver();
         d.manage().window().maximize();}
	
	
	}
	
	
	
	@AfterMethod
	public void Kill(){
		
		if(d!=null){
			
			//d.quit();
			}
		
		
		
		
	}
	
	

}
