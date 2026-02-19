package cucumber.java.stepdefinitionclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Header_Manager;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import io.cucumber.java.en.Given;


public class Cucumber_Case_Module_Testcases {
	
	
@Given("Add form Accessor {int}")
public void Add_New_Case_Form_Accessor(int s) throws IOException, InterruptedException{
		
	    WebDriver d = Base_cucumber.d;
	
		Application_Locaters p = new Application_Locaters(d);
		Header_functionality_manager hd = new Header_functionality_manager();
		
		int step = s;
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Click <b>Case Add</b> button from Header<br>"
			  + "<b>📘 Description:</b> User uses header Case Add button to directly open the New Case Add popup<br>"
			  + "<b>✅ Expected:</b> New Case popup should open");
	        hd.header_buttons_clicker(s);
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Header <b>Case Add</b> button clicked.");
	        Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>Step "+(step++)+":</b> Verify New Case popup is opened<br>"
	         + "<b>📘 Description:</b> System should display the case creation popup/form after header Case Add click<br>"
	         + "<b>✅ Expected:</b> New Case Add popup form should be visible and ready for input");
			p.Popup_add_form();}
	
	
	

}
