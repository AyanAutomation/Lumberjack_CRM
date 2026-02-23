package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Enterprise_Codeclouds.Project.Enterprise.SIde_Menu_Handler;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Attorney_Modules_Cucumber {

	
	public void Atttorney_Add_through_case(Map<String, String> data, WebDriver d) throws IOException, InterruptedException {
	    Application_Locaters p = new Application_Locaters(d);
	    Repeat rp = new Repeat(d);
	    Login_Locaters lg = new Login_Locaters(d);

	    WebElement Create_Contact = p.Create_Contact_button();
	    rp.Scroll_to_element(Create_Contact);
	    Create_Contact.click();

	    List<WebElement> attorney_inputs = p.second_popup_form_inputs();
	    
	    // Mapping flat Cucumber keys to the UI fields
	    attorney_inputs.get(0).sendKeys(data.get("Law Firm.Name")); 
	    p.plaintiff_dropdown_list();
	    p.Plaintiff_options().get(0).click();
	    
	    attorney_inputs.get(1).sendKeys(data.get("Attorney.First Name"));
	    attorney_inputs.get(2).sendKeys(data.get("Attorney.Middle Name"));
	    attorney_inputs.get(3).sendKeys(data.get("Attorney.Last Name"));
	    attorney_inputs.get(4).sendKeys(data.get("Attorney.Name Suffix"));
	    attorney_inputs.get(5).sendKeys(data.get("Attorney.Phone"));
	    attorney_inputs.get(6).sendKeys(data.get("Attorney.Office phone"));
	    attorney_inputs.get(7).sendKeys(data.get("Attorney.Email"));

	    WebElement Add_Attorney_Button = p.second_popup_form_buttons().get(2);
	    rp.Scroll_to_element(Add_Attorney_Button);
	    Add_Attorney_Button.click();
	    
	    Thread.sleep(800);	
	    WebElement Local_Toast = lg.toast();
	    Login_negative_testcases.Toast_printer(Local_Toast.getText().trim(), d);
	    Thread.sleep(600);
	}
	
	
	
	
}
