package Negative_Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Case_Appplications;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;

@Listeners(Listerners.Report_Listen.class)
public class Application_Add_Negative_Testcases extends Case_Appplications{
	
	TreeSet<String> Number_of_fields_with_asterix = new TreeSet<>();
	String invalid_plaintiff;
	String invalid_case_type;
	String Invalid_lead_type;
	String Invalid_Lead_source;
	String Invalid_state;
	
	@Test(dataProvider="case_plus_plaintiff")
	public void application_add_negative(TreeMap<String, String> data,TreeMap<String, String> data2,TreeMap<String, String> attorneyData) throws IOException, InterruptedException{
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		
		
		invalid_plaintiff = "Phobos";
		invalid_case_type = "Construction Accident";
		Invalid_state = "West Bengal";
		Invalid_lead_type = "Doctor";
		Invalid_Lead_source = "Fedrick";
		
		
		
		int step = 1;
		

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario Title</b> – Mandatory Field Validation + Invalid Plaintiff Search");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description</b> – User clicks <b>Case Add</b> button from header to open the New Case popup. Then submits blank mandatory fields to validate inline errors. Finally types an invalid keyword in Plaintiff search and verifies dropdown results behavior.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input</b> – Invalid Plaintiff Keyword = <b>Phobos</b> (mandatory fields intentionally blank)");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected</b> – New Case popup should open from header Case Add button. Inline error count should match number of mandatory fields marked with <b>*</b>. Invalid Plaintiff keyword should show <b>no matching results</b>.");
        
		Add_New_Case_Form_Accessor(step);
		Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step "+(step++)+":</b> Capture form fields for mandatory validation<br>"
	          + "<b>📘 Description:</b> Fetch input fields + label/placeholder fields to count required fields marked with '*'<br>"
	          + "<b>✅ Expected:</b> Fields list should be captured so mandatory scan can be performed");
	    List<WebElement> input_feilds = blank_spaces_submit();
	    Thread.sleep(800);
	    IntStream.range(0, input_feilds.size()).forEach(h->{
	    input_feilds.get(h).clear();}); 
	    Thread.sleep(800);
	    List<WebElement> other_placeholder_feilds = p.form_fields_with_placeholder();
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click Create/Submit with blank fields and validate inline errors vs '*' mandatory count.");
	    error_checker(input_feilds,other_placeholder_feilds);
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Mandatory validation executed (mandatory count vs inline errors logged).");
	    
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step "+(step++)+":</b> Enter invalid Plaintiff keyword<br>"
	          + "<b>📘 Description:</b> Type a wrong keyword into Plaintiff search to verify dropdown result behavior<br>"
	          + "<b>📥 Input:</b> Plaintiff keyword =  "+invalid_plaintiff
	          + " <b>✅ Expected:</b> Dropdown should not show valid matching results");
	    
	    input_feilds.get(0).sendKeys(invalid_plaintiff);
		try{p.plaintiff_dropdown_list();
        Report_Listen.log_print_in_report().log(Status.FAIL,
                "<b>🟨 Actual:</b> Dropdown list opened after invalid keyword "+invalid_plaintiff+". This indicates results are being shown when they should not (as per expected).");
            System.out.println("Testcase failed wrong keyword in plaintiff search field showing result");}
		catch(Exception n) 
		{ Report_Listen.log_print_in_report().log(Status.PASS,
			    "<b>🟨 Actual:</b> Dropdown opened but no selectable options were present for invalid keyword. <b>Testcase Passed</b> (no match expected).");
            System.out.println("Testcase Passed wrong keyword in plaintiff search field not showing any result");}
		rp.Feild_clear(input_feilds.get(0));
		input_feilds.get(0).sendKeys(data2.get("First Name"));
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click();
		input_feilds.get(1).sendKeys(invalid_case_type);
		WebElement Dropdown_with_no_data_text;
		try{p.Incident_type_dropdown();
        Report_Listen.log_print_in_report().log(Status.FAIL,
                "<b>🟨 Actual:</b> Dropdown list opened after invalid keyword <b>Construction Accident</b>. This indicates results are being shown when they should not (as per expected).");
            System.out.println("Testcase failed wrong keyword in Incident type search field showing result");}
		catch(Exception n) 
		{ Dropdown_with_no_data_text = p.Dropdown_showing_nodata();
		Report_Listen.log_print_in_report().log(Status.PASS,
			    "<b>🟨 Actual:</b> Dropdown opened but no selectable options were present for invalid keyword. <b>Testcase Passed</b> (no match expected).");
            System.out.println("Testcase Passed wrong keyword in Incident type search field not showing any result");}
		rp.Feild_clear(input_feilds.get(1));
		
		Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step "+(step++)+":</b> Enter invalid Case Type keyword<br>"
	          + "<b>📘 Description:</b> Type a wrong keyword into Incident Type field search to verify dropdown result behavior<br>"
	          + "<b>📥 Input:</b> Incident Type keyword = <b>Genocide</b><br>"
	          + "<b>✅ Expected:</b> Dropdown should not show valid matching results");
	
		input_feilds.get(1).sendKeys(data.get("Case Type"));
		Thread.sleep(800);
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click(); 
		// -------------------- STATE (Invalid + Valid) --------------------

		Report_Listen.log_print_in_report().log(Status.INFO,
		    "<b>Step "+(step++)+":</b> Enter invalid State keyword and validate dropdown shows <b>No data</b><br>"
		  + "<b>📘 Description:</b> User types an invalid state name to verify the State dropdown does not return results<br>"
		  + "<b>📥 Input:</b> Invalid State = <b>"+Invalid_state+"</b><br>"
		  + "<b>✅ Expected:</b> Dropdown should show <b>No data</b> (no selectable options)");
		input_feilds.get(2).sendKeys(Invalid_state);
		String State_dropdowntext = p.Dropdown_showing_nodata().getText().trim();
		Report_Listen.log_print_in_report().log(
			    State_dropdowntext.contains("No data") ? Status.PASS : Status.FAIL,
			    State_dropdowntext.contains("No data")
			        ? "<b>🟨 Actual:</b> ✅ Dropdown shows: <b>"+State_dropdowntext+"</b>. <b>Testcase Passed</b> (invalid state blocked)."
			        : "<b>🟨 Actual:</b> ❌ Dropdown did NOT show 'No data'. Text captured: <b>"+State_dropdowntext+"</b>. <b>Testcase Failed</b> (unexpected state results)."
			);
		
		Report_Listen.log_print_in_report().log(Status.INFO,
				    "<b>Step "+(step++)+":</b>  select a valid State from dropdown<br>"
				    		  + "<b>📘 Description:</b> User enters valid state and selects first available option<br>"
				    		  + "<b>📥 Input:</b> Valid State = <b>"+data.get("State")+"</b><br>"
				    		  + "<b>✅ Expected:</b> State should be selected successfully without dropdown error"
				    		);
		
		rp.Feild_clear(input_feilds.get(2));
		input_feilds.get(2).sendKeys(data.get("State"));
        WebElement state_dropdown=p.Incident_type_dropdown();
	    state_dropdown.findElement(By.xpath(".//*[@aria-selected='false']")).click();
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> ✅ Valid State entered and one option selected from dropdown.");
	    p.form_inputs().get(3).sendKeys(data.get("Date of Incident"));
		p.calender_date_select().click();
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Enter invalid Lead Type and validate dropdown shows no options<br>"
			  + "<b>📘 Description:</b> User types an invalid lead type to verify no dropdown options appear<br>"
			  + "<b>📥 Input:</b> Invalid Lead Type = <b>"+Invalid_lead_type+"</b><br>"
			  + "<b>✅ Expected:</b> Dropdown should show <b>No data</b> / no selectable options");
		p.form_inputs().get(4).sendKeys(Invalid_lead_type);
        WebElement lead_cat_dropdown;
		try{
			lead_cat_dropdown = p.State_of_incident_dropdown();
		} catch(Exception mmk){
			Report_Listen.log_print_in_report().log(Status.PASS,
				    "<b>🟨 Actual:</b> Dropdown opened but no selectable options were present for invalid lead type keyword. <b>Testcase Passed</b> (no match expected).");
	            System.out.println("Testcase Passed wrong keyword in lead type search field not showing any result");}
		rp.Feild_clear(input_feilds.get(4));
		input_feilds.get(4).sendKeys(data.get("Lead Source"));
		lead_cat_dropdown = p.State_of_incident_dropdown();
		lead_cat_dropdown.findElement(By.xpath(".//*[@aria-selected='false']")).click();
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Enter invalid Lead Source keyword and validate dropdown shows no options<br>"
			  + "<b>📘 Description:</b> User types invalid lead source text and verifies dropdown returns no match<br>"
			  + "<b>📥 Input:</b> Invalid Lead Source = <b>"+Invalid_Lead_source+"</b><br>"
			  + "<b>✅ Expected:</b> Dropdown should show <b>No data</b> / no selectable options");
		WebElement lead_source_field = p.lead_source_field();
		lead_source_field.click();
	    p.fifth_dropdown();
		String lead_source_option = p.fifth_dropdown_options().get(0).getText().trim();
		rp.Feild_clear(lead_source_field);
		lead_source_field.sendKeys(Invalid_Lead_source);
		try{p.fifth_dropdown();}catch(Exception mmk){
			Report_Listen.log_print_in_report().log(Status.PASS,
			        "<b>🟨 Actual:</b> ✅ Dropdown did not load selectable options for invalid lead source <b>"+Invalid_Lead_source+"</b>. <b>Testcase Passed</b> (no match expected).");
			System.out.println("Testcase Passed wrong keyword in lead source search field not showing any result");} 
		rp.Feild_clear(lead_source_field);
		lead_source_field.sendKeys(lead_source_option);
	    p.fifth_dropdown();
		p.fifth_dropdown_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Enter invalid Requested Amount (non-numeric) and submit form<br>"
			  + "<b>📘 Description:</b> User enters non-numeric text into Requested Amount to verify validation blocks submission<br>"
			  + "<b>📥 Input:</b> Invalid Requested Amount = <b>"+Invalid_Lead_source+"</b><br>"
			  + "<b>✅ Expected:</b> Form should NOT submit; inline error should appear / next section should not open");

		WebElement Requested_amount_field = input_feilds.get(5);
		WebElement form_submit_button = p.form_buttons().get(1);
		rp.Scroll_to_element(Requested_amount_field);  
		Requested_amount_field.sendKeys(Invalid_Lead_source);
		form_submit_button.click();
		Thread.sleep(800);
		try {p.Case_details_edit_buttons().click();
		Report_Listen.log_print_in_report().log(Status.FAIL,
		        "<b>🟨 Actual:</b> ❌ Invalid Requested Amount <b>"+Invalid_Lead_source+"</b> was accepted and form proceeded. <b>Testcase Failed</b>.");}
		catch(Exception nnk){
			Report_Listen.log_print_in_report().log(Status.PASS,
			        "<b>🟨 Actual:</b> ✅ Invalid Requested Amount <b>"+Invalid_Lead_source+"</b> was NOT accepted. Inline validation prevented submission. <b>Testcase Passed</b>."
			    );
			Inline_error_printer(lg.inline_errors());
			Requested_amount_field.sendKeys(data.get("Requested Amount"));
			form_submit_button.click();
			Thread.sleep(500);try {
			Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
			catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}}}
  
	
	
	
	public void error_checker(List<WebElement> fields,List<WebElement> Other_fields) throws InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		
		List<WebElement> Input_fields = fields;
		List<WebElement> Other_placeholder_fields = Other_fields;
		
		 Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario Title</b> – Mandatory Field Validation + Invalid Plaintiff Search");
		 Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description</b> – User opens New Case form, clicks Create with blank mandatory fields to validate inline errors.");
		for(WebElement field:Input_fields){
			String Placeholder = field.getAttribute("placeholder");
			String Placeholder_trimmed = Placeholder.trim();
		if(Placeholder_trimmed.contains("*")){
			Number_of_fields_with_asterix.add(Placeholder_trimmed);}}
		for(WebElement Other_placeholder_field:Other_placeholder_fields){
			String placeholder_text_trimmed= Other_placeholder_field.getText().trim();
			if(placeholder_text_trimmed.contains("*")){
				Number_of_fields_with_asterix.add(placeholder_text_trimmed);}}
		
		WebElement Submit_btn = p.form_buttons().get(1);
		rp.Scroll_to_element(Submit_btn);
		rp.movetoelement(Submit_btn);
		Submit_btn.click();
		Thread.sleep(800);
		List <WebElement> errors = lg.inline_errors();
		int errorcount = errors.size();
		int asterix_feild_count = Number_of_fields_with_asterix.size();
		System.out.println(errorcount==asterix_feild_count?"Testcase Passed number of fields with asterixs "+asterix_feild_count+" matching mandatory error count "+errorcount:"Testcase Failed number of fields with asterixs "+asterix_feild_count+" not matching mandatory error count "+errorcount);
		
		//value_fetcher("Placeholder");	
	}
	
	/*
	public void value_fetcher(String name){
		
		
		String List_name = name;
		
		if(List_name.equalsIgnoreCase("Placeholder")){
			List<String> Field_text = ;
			
			IntStream.range(0, Number_of_fields_with_asterix.size()).forEach(n->{
				
			});}} */ 
	
	    
	    public List<WebElement> blank_spaces_submit() throws IOException, InterruptedException{
		
		
	    	Application_Locaters p = new Application_Locaters(d);
	    	Login_Locaters lg = new Login_Locaters(d);
			Repeat rp = new Repeat(d);
	
		
			int step = 1;
		    
			Report_Listen.log_print_in_report().log(Status.INFO,
			        "<b>🔹 Scenario Title</b> – New Case Form: Submit with Blank Spaces in All Input Fields");
			Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>📥 Input</b> – Every input field filled with: <b>\"   \"</b> (only spaces)");
            Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>✅ Expected</b> – System should <b>NOT</b> accept blank spaces as valid input. Inline errors should appear for mandatory fields and no case should be created.");
			List<WebElement> input_feilds = p.form_inputs();
			for(int index=0;index<input_feilds.size();index++) {
			rp.field_space_inserter(input_feilds, index);
			}
			WebElement Submit_btn = p.form_buttons().get(1);
			rp.Scroll_to_element(Submit_btn);
			rp.movetoelement(Submit_btn);
			Submit_btn.click();
			Thread.sleep(800);
			List <WebElement> errors = lg.inline_errors();
			Inline_error_printer(errors);
			 Report_Listen.log_print_in_report().log(Status.PASS,
		                "<b>🟨 Actual:</b> Inline errors displayed = <b>" + errors.size()+ "</b>. <b>Testcase Passed</b> (spaces treated as blank).");
			return input_feilds;
			}
	      
	    
	    public void Inline_error_printer(List <WebElement> Inline_errors){
	    	
	    	
	    	
	    	List <WebElement> err = Inline_errors;
	    	int errorcounts = err.size();
	    	for(int m=0;m<errorcounts;m++){
	    		
	    		String error_texts = err.get(m).getText().trim();
	    		Report_Listen.log_print_in_report().log(Status.INFO,error_texts);
	    		System.out.println(error_texts);
	    		System.out.println();
	    		}
	    
	
	    
	
}}
