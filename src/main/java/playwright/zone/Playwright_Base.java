package playwright.zone;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;

public class Playwright_Base {
	
	public Playwright pw;
	public Browser browser;
	public Page page;
	public static String Target_url;
	
	
	public void Setup() throws IOException{
		
		Data_Reader f = new Data_Reader();
		Target_url = System.getProperty("url") != null ? System.getProperty("url"):f.Data_Fetcher("Url");
		String Browser = System.getProperty("Browsername") != null ? System.getProperty("Browsername"): f.Data_Fetcher("Browser");
		pw = Playwright.create();
		
		BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
		if (Browser.toLowerCase().contains("headless")) {
			options.setHeadless(true);
		} else {
			options.setHeadless(false);
		}
		if(Browser.equalsIgnoreCase("Chrome")){
			
			browser = pw.chromium().launch(options);}
		if(Browser.equalsIgnoreCase("Firefox")){
			
			browser=pw.firefox().launch(options);}
		page = browser.newPage();
		page.setViewportSize(1536, 864);
	}
	
	@AfterMethod
	public void Kill() {

		if (page != null) {
			page.close();
		}
		if (browser != null) {
			browser.close();
		}
		if (pw != null) {
			pw.close();
		}
	}

}
