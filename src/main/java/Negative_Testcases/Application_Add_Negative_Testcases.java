package Negative_Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Case_Appplications;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;

public class Application_Add_Negative_Testcases extends Case_Appplications{
	
	TreeSet<String> Number_of_fields_with_asterix = new TreeSet<>();
	
	@Test(dataProvider="case_plus_plaintiff")
	public void application_add(TreeMap<String, String> data, TreeMap<String, String> data2) throws IOException, InterruptedException{
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		
		header_buttons_clicker(0);
		p.Popup_add_form();
		
	    List<WebElement> input_feilds = p.form_inputs();
	    List<WebElement> other_placeholder_feilds = p.form_fields_with_placeholder();
	    error_checker(input_feilds,other_placeholder_feilds);
	    input_feilds.get(0).sendKeys("Phobos");
		try{p.plaintiff_dropdown_list();
		System.out.println("Testcase failed wrong keyword in plaintiff search field showing result");}
		catch(Exception n) 
		{System.out.println("Testcase Passed wrong keyword in plaintiff search field not showing any result");
		p.plaintiff_dropdown_list();}
	}
  
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
			Number_of_fields_with_asterix.add(Placeholder_trimmed);}
		for(WebElement Other_placeholder_field:Other_placeholder_fields){
			String placeholder_text_trimmed= Other_placeholder_field.getText().trim();
			if(placeholder_text_trimmed.contains("*")){
				Number_of_fields_with_asterix.add(placeholder_text_trimmed);}}}
		
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
}
