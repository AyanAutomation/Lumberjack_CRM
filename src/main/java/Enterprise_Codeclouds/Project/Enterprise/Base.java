package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected static ThreadLocal<WebDriver> D = new ThreadLocal<WebDriver>();
	public String Target_url;
	protected WebDriver d;
	
	@BeforeMethod
	public void setup() throws IOException{
		
		
    Data_Reader f = new Data_Reader();
		
	String Browser = System.getProperty("Browsername")!=null ? System.getProperty("Browsername") : f.Data_Fetcher("Browser");	
	Target_url = System.getProperty("url")!=null ? System.getProperty("url"):f.Data_Fetcher("Url");
	
	WebDriver local_d;
	
	if(Browser.contains("Chrome")){
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(Browser.contains("headless")) {
		options.addArguments("headless");}
		local_d = new ChromeDriver(options);
        
        D.set(local_d);}
	if(Browser.equalsIgnoreCase("Firefox")){
		
		 WebDriverManager.firefoxdriver().setup();
		 local_d = new FirefoxDriver();
         
         D.set(local_d);}
	d= D.get();
	d.manage().window().maximize();
	}
	
	
	
	@AfterMethod
	public void Kill(){
 
		if(d!=null){
			
       d.quit();
       D.remove();}
	
	

}}
