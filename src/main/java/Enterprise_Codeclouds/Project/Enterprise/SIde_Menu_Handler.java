package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Locaters.Sidemenu_Locaters;

public class SIde_Menu_Handler extends Login{
	
	
    public void Side_menu_option_clicker(String menu_option ) throws IOException, InterruptedException{
    	
    	Sidemenu_Locaters p = new Sidemenu_Locaters(d);
    	
    	login();
    	p.Side_Menu();
    	
    	if(menu_option.contains("Firm & Counsel")||menu_option.contains("Access Control")){
    		
    		
    		List<WebElement> menuoptions = p.Sidemenu_Options();
    		
    		Outerloop:
    		for(WebElement menuopt:menuoptions){
            	if(menuopt.getText().trim().contains(menu_option)){
            		menuopt.click();/*
            		List<WebElement> menuoptns = p.submenu_options();
            		for(WebElement menuoptn:menuoptns ){
            	if(menuoptn.getText().trim().contains(Submenuoption)){
            		menuoptn.click();
            		break Outerloop;
            		}}*/
            	}}}
    		else {
    			
    	List<WebElement> menuoptions = p.Sidemenu_Options();
        for(WebElement menuopt:menuoptions){
        	if(menuopt.getText().trim().contains(menu_option)){
        		
        		menuopt.click();}}}}	
	
	


}
