package Repeatative_codes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Repeat {

	WebDriver d;
	
	
	
	public Repeat(WebDriver d){
		
		this.d=d;}
	
	
   public void wait_for_theElement(WebElement element){
		
		WebDriverWait w = new WebDriverWait(d,Duration.ofSeconds(10));
	    w.until(ExpectedConditions.visibilityOf(element));}
	
	
	public void wait_for_theElement(List <WebElement> element){
		 
	     if (element == null || element.isEmpty()) {
		 throw new RuntimeException("Element list is null or empty. Check the locator or timing."); }
	     
	   	 WebDriverWait w = new WebDriverWait(d,Duration.ofSeconds(10));
	   	 w.until(ExpectedConditions.visibilityOfAllElements(element));
	   	 
		 }
		
    public void movetoelement(WebElement element){
			
			Actions a = new Actions(d);
			a.moveToElement(element).build().perform();}
		 
    public void Scroll_to_element(WebElement element){
			 
			 JavascriptExecutor js = (JavascriptExecutor)d;
			 js.executeScript("arguments[0].scrollIntoView(true);", element);}
	
    public void Feild_clear(WebElement element){
		 
    	element.sendKeys(Keys.CONTROL,"a");
    	element.sendKeys(Keys.DELETE);}
    
    public List<WebElement> wait_for_nested(WebElement parent, By childLocator){
        WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(10));
      return  w.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, childLocator));
    }
	
}
