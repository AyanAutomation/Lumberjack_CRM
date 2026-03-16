package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Locaters.Login_Locaters;
import Locaters.Sidemenu_Locaters;
import Repeatative_codes.Repeat;

public class SideMenu_Handler_Cucumber {
	
	
	
	 public static void Side_menu_option_clicker_by_cucumber(String menu_option, WebDriver d , String Submenuoption) throws IOException, InterruptedException{
	 
		Sidemenu_Locaters p = new Sidemenu_Locaters(d);
	    Login_Locaters lg = new Login_Locaters(d);
	    Repeat rp = new Repeat(d);
	 
	    Login_cucumber.login_through_cucumber(d);
	    Thread.sleep(800);
	    p.Side_Menu();
        List<WebElement> menuoptions = p.Sidemenu_Options();
    	
    	if(menu_option.contains("Firm & Counsel")||menu_option.contains("Access Control")){
    		
    		Outerloop:
    		for(WebElement menuopt:menuoptions){
            	if(menuopt.getText().trim().contains(menu_option)){
            		rp.movetoelement(menuopt);
            		Thread.sleep(800);
            		menuopt.click();
            		Thread.sleep(800);
            		WebElement Toast_A;
            	  try{Toast_A = lg.Toast_close_button();
            	  rp.movetoelement(Toast_A);
            	  Toast_A.click();}catch(Exception toast_cancel){/*
            	  Toast_A = lg.Toast_close_button();
            	  rp.movetoelement(Toast_A);
            	  Toast_A.click(); */
            	  System.out.println("Exception found in Side menu option Toast close thereby retried");
            	  }List<WebElement> menuoptns = p.submenu_options();
            		for(WebElement menuoptn:menuoptns ){
            	if(menuoptn.getText().trim().contains(Submenuoption)){
            		menuoptn.click();
            		Thread.sleep(800);
            		WebElement Toast_B;
            	try {Toast_B = lg.Toast_close_button();
        		     rp.movetoelement(Toast_B);
        		     Toast_B.click();}
            	catch(Exception taost_b_cancel) {
            	 Toast_B = lg.Toast_close_button();
       		     rp.movetoelement(Toast_B);
       		     Toast_B.click();
       		     System.out.println("Exception found in Side menu option Toast close thereby retried");}
            		break Outerloop;
            		}}
            	}}}
    	
    		
    	else {
    			
            for(WebElement menuopt:menuoptions){
        	if(menuopt.getText().trim().contains(menu_option)){
        		
        		menuopt.click();
        		Thread.sleep(800);
        		break;}}}
	    
	    
	    
	 }
}
