package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Locaters.Sidemenu_Locaters;

public class SIde_Menu_Handler extends Login{
	
	
    public void Side_menu_option_clicker(String menu_option, WebDriver d , String Submenuoption) throws IOException, InterruptedException{
    	
    	Sidemenu_Locaters p = new Sidemenu_Locaters(d);
    	
    	login(d);
    	p.Side_Menu();
    	List<WebElement> menuoptions = p.Sidemenu_Options();
    	
    	if(menu_option.contains("Firm & Counsel")||menu_option.contains("Access Control")){
    		
    		Outerloop:
    		for(WebElement menuopt:menuoptions){
            	if(menuopt.getText().trim().contains(menu_option)){
            		menuopt.click();
            		List<WebElement> menuoptns = p.submenu_options();
            		for(WebElement menuoptn:menuoptns ){
            	if(menuoptn.getText().trim().contains(Submenuoption)){
            		menuoptn.click();
            		break Outerloop;
            		}}
            	}}}
    	
    		
    	else {
    			
            for(WebElement menuopt:menuoptions){
        	if(menuopt.getText().trim().contains(menu_option)){
        		
        		menuopt.click();
        		Thread.sleep(800);
        		break;}}}}	
	
	


}
