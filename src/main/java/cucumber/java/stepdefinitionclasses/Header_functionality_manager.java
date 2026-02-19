package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Locaters.Header_locaters;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;

public class Header_functionality_manager extends Login_cucumber{
	
	
public	WebDriver d= Base_cucumber.d;
	
	
	public void header_buttons_clicker(int button_index) throws IOException, InterruptedException{
		
		Header_locaters p = new Header_locaters(d);
		
		
		login_through_cucumber(d);
		p.Header_buttons().get(button_index).click();}
	
	
      public void header_search(String Keyword) throws IOException, InterruptedException{
		
		Header_locaters p = new Header_locaters(d);
		
		
		login_through_cucumber(d);
		p.Header_search().sendKeys(Keyword);
		p.search_dropdown();}
      
      public void header_dropdown_option_selector(String Option) throws IOException, InterruptedException{
    	  
    	  Header_locaters p = new Header_locaters(d); 	  
    	  Login_Locaters lg = new Login_Locaters(d);	
    	  Repeat rp = new Repeat(d);
    	  
    	  
    	  login_through_cucumber(d);
    	 // rp.wait_for_invisibility(lg.toast());
          p.header_profile_section().click();
          List<WebElement> Header_Dropdown_Options = p.Header_dropdown_options();
          for(WebElement opt:Header_Dropdown_Options){
        	  
        	  if(opt.getText().trim().equalsIgnoreCase(Option)){
        		  
        		  opt.click();
        		  break;}}}

}
