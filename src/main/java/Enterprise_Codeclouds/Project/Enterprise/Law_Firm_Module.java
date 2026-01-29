package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Attorney_Locaters;
import Locaters.Law_firm_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Law_Firm_Module extends Attorney_module{
	
	
	@Test(dataProvider="lawFirmData")
	public void Add_Law_Firm(TreeMap<String,String>data) throws IOException, InterruptedException{
		
		Law_firm_Locaters pp = new Law_firm_Locaters(d);	
		SIde_Menu_Handler sd=new SIde_Menu_Handler();
		Plaintiff_Locaters p=new Plaintiff_Locaters(d);
		Application_Locaters ap = new Application_Locaters(d);
		Repeat rp=new Repeat(d);
		Login_Locaters lg=new Login_Locaters(d);
		
		
		
		String Firm_name = data.get("Name");
		sd.Side_menu_option_clicker("Firm & Counsel",d,"Law Firm");	
		pp.landed_in_Law_Firm_module();
		rp.Scroll_to_element(p.form());
		Thread.sleep(800);	
		List<WebElement> input_feilds=p.inputs();	
 
		input_feilds.get(0).sendKeys(Firm_name);;
	    input_feilds.get(1).sendKeys(data.get("Phone"));
		input_feilds.get(5).sendKeys(data.get("State"));
		ap.plaintiff_dropdown_list();
		ap.Plaintiff_options().get(0).click();
		input_feilds.get(4).sendKeys(data.get("City"));	
		input_feilds.get(6).sendKeys(data.get("Zip code"));
		input_feilds.get(2).sendKeys(data.get("Street Address 1"));
		input_feilds.get(3).sendKeys(data.get("Street Address 2"));	

		WebElement Add_Law_Frim_Button=p.form_buttons().get(0);
		rp.Scroll_to_element(Add_Law_Frim_Button);
		Add_Law_Frim_Button.click();
		Thread.sleep(800);	
		WebElement Toast_cancel_button = lg.Toast_close_button();
		String taost= lg.toast().getText().trim();
		Login_negative_testcases.Toast_printer(taost);
		Toast_cancel_button.click();}
		
	
	   @Test(dataProvider="law_plus_attorney")
	   public void Law_firm_contact_Add_through_Case_Contact(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff) throws IOException, InterruptedException{
		   
		    SIde_Menu_Handler sd = new SIde_Menu_Handler();
			Application_Locaters p = new Application_Locaters(d);
			Repeat rp = new Repeat(d);
			Login_Locaters lg = new Login_Locaters(d);
			Law_firm_Locaters pp = new Law_firm_Locaters(d);
			
	     String	Law_Firm_Name = law_firm.get("Name");	
		
		WebElement Create_Contact;
		try{Create_Contact = p.Create_Contact_button();}
		catch(Exception not_inside_case_contact_list){
			sd.Side_menu_option_clicker("Applications", d,"N/A");
			p.landed_in_applicationList_confirmation();	
			p.rows().get(1).click();
			Thread.sleep(800);}	
		List<WebElement> Case_Tags;
		   try {
		   Case_Tags = p.Case_tags();}
		   catch(RuntimeException tags){
			   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			   System.out.println();
			   Thread.sleep(1200);
			   Case_Tags = p.Case_tags(); }
		    tab_selector("Contacts");
			p.lawFirm_AddButton_ContactTab();
			rp.Scroll_to_element(p.Contact_AddButton_ContactTab());
			p.Contact_AddButton_ContactTab().click();
			p.Contact_type_dropdown_list();
			List<WebElement> Contact_Options = p.Contact_type_Options();
			for(WebElement Cn_opt:Contact_Options){
			if(Cn_opt.getText().trim().equalsIgnoreCase("Law Firm Contact")){
					Cn_opt.click();
					break;}}
			p.pop_up_contact_list(); 
			p.pop_up_contact_list();
			Thread.sleep(800);
			p.Popup_modal_search().sendKeys(Law_Firm_Name);
			Thread.sleep(800);
			WebElement toast = lg.toast();
			rp.wait_for_invisibility(toast);
			try {
			p.List_Checkboxes().get(0).click();}
			catch(Exception Law_firm_){
				WebElement CreateContact = p.Create_Contact_button();
				rp.Scroll_to_element(CreateContact);
				CreateContact.click();
				List<WebElement> Law_firm_contacts_inputs = p.second_popup_form_inputs();
				Law_firm_contacts_inputs.get(0).sendKeys(Law_Firm_Name);
				p.plaintiff_dropdown_list();
				p.Plaintiff_options().get(0).click();
				Law_firm_contacts_inputs.get(1).sendKeys(data.get("First Name"));
				Law_firm_contacts_inputs.get(2).sendKeys(data.get("Middle Name"));
				Law_firm_contacts_inputs.get(3).sendKeys(data.get("Last Name"));
				Law_firm_contacts_inputs.get(4).sendKeys(data.get("Name Suffix"));
				Law_firm_contacts_inputs.get(5).sendKeys(data.get("Phone"));
				Law_firm_contacts_inputs.get(6).sendKeys(data.get("Office phone"));
				Law_firm_contacts_inputs.get(7).sendKeys(data.get("Email"));
			/*	WebElement Add_staff_button= p.second_popup_form_buttons().get(1);
				Add_staff_button.click();
				List<WebElement> fields = p.Third_popup_form_inputs();
				WebElement Staff_pop_up_form = p.Third_popup_form();
				WebElement Staff_Add_button= p.Third_popup_form_buttons().get(1);
				staff_add(staff,fields,Staff_pop_up_form,Staff_Add_button); */
				WebElement Add_Create_Contact_Button=p.second_popup_form_buttons().get(2);
				rp.Scroll_to_element(Add_Create_Contact_Button);
				Add_Create_Contact_Button.click();
				Thread.sleep(800);	
				WebElement Toast = lg.toast();
				String taost= Toast.getText().trim();
				Login_negative_testcases.Toast_printer(taost);}}
	
	  @Test(dataProvider="lawFirmEditData")
	  public void law_firm_Address_edit_and_its_reflection_in_case_contact_details(TreeMap<String,String> data) throws IOException, InterruptedException{
		  
		     Application_Locaters p = new Application_Locaters(d);
			 SIde_Menu_Handler sd = new SIde_Menu_Handler();
			 Login_Locaters lg = new Login_Locaters(d);
			 Repeat rp = new Repeat(d);
			 Law_firm_Locaters pp = new Law_firm_Locaters(d);
			 Plaintiff_Locaters plaintiff = new Plaintiff_Locaters(d);
		  
			 int step = 1;
			 
			 
			 String Case_id = "CA2600365";
		  
			 String Firm_name = data.get("Name");
			 String State = data.get("State");
			 String City = data.get("City");
			 String Zip = data.get("Zip code");
			 String Address_line_1 = data.get("Street Address 1");
			 String Address_line_2 = data.get("Street Address 2");
			 
			 StringBuilder header = new StringBuilder();
			    header.append("<b>🔹 Scenario Title:</b> Law Firm Address Edit → Verify Updated Address reflects in Case Contacts<br>");
			    header.append("<b>📘 Description:</b> Edit a Law Firm’s address in <b>Firm & Counsel</b> module, then re-open the same funded case and confirm the updated address is reflected in <b>Contacts</b> tab for that Law Firm.<br>");
			    header.append("<b>📥 Input (Edited Address):</b><br>");
			    header.append("• State: <b>").append(State).append("</b><br>");
			    header.append("• City: <b>").append(City).append("</b><br>");
			    header.append("• Zip: <b>").append(Zip).append("</b><br>");
			    header.append("• Address Line 1: <b>").append(Address_line_1).append("</b><br>");
			    header.append("• Address Line 2: <b>").append(Address_line_2).append("</b><br>");
			    header.append("<b>✅ Expected:</b> The updated address should be visible in Law Firm module list and also in the case’s Contacts tab for that Law Firm.");

			    Report_Listen.log_print_in_report().log(Status.INFO, header.toString());

			    System.out.println("\n==================================================");
			    System.out.println("[SCENARIO] Law Firm Address Edit -> Reflection in Case Contacts");
			    System.out.println("[CASE] " + Case_id);
			    System.out.println("[Edited Address Input]");
			    System.out.println("State        : " + State);
			    System.out.println("City         : " + City);
			    System.out.println("Zip          : " + Zip);
			    System.out.println("Address Line1: " + Address_line_1);
			    System.out.println("Address Line2: " + Address_line_2);
			    System.out.println("Expected     : Updated address should reflect in Law Firm list & Case Contacts");
			    System.out.println("==================================================\n");


			    // ==========================================================
			    // Step 1: Open the case and capture current linked Law Firm name
			    // ==========================================================
			    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step "+(step++)+":</b> Open Applications → search the case → open case details.");
			    System.out.println("[Step] Open Applications -> Search case -> Open case details");
		   	 
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		   WebElement Search = p.Application_search();
		   Search.sendKeys(Case_id);
		   Thread.sleep(800);
		   WebElement Toast_One = lg.Toast_close_button();
		   rp.movetoelement(Toast_One);
		   Toast_One.click();
		   Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Toast closed (Toast 1).");
	       System.out.println("Actual: Toast closed (Toast 1).");
	       WebElement Toast_Two;
	       try{
	           Toast_Two = lg.Toast_close_button();
	           rp.movetoelement(Toast_Two);
	           Toast_Two.click();
	           Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Toast closed (Toast 2).");
	           System.out.println("Actual: Toast closed (Toast 2).");
	       }
	       catch(Exception Toast_close){
	           Toast_Two = lg.Toast_close_button();
	           rp.movetoelement(Toast_Two);
	           Toast_Two.click();
	           System.out.println("Exception found in Toast two close thereby retried");
	           Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Toast 2 close required retry and succeeded.");
	       }
		   List<WebElement> result_rows;
		  try {
		   result_rows = p.rows();
		   result_rows.get(0).click();
		   Thread.sleep(800);}
		  catch(Exception Result_still_not_fetched){
			 System.out.println("Exception Found in fetching result rows thereby retrying");
			 System.out.println();
		   Thread.sleep(800);  
		   result_rows = p.rows();
		   result_rows.get(0).click();
		   Thread.sleep(800);}
		   List<WebElement> Case_Tags;
		   try {
		   Case_Tags = p.Case_tags();}
		   catch(RuntimeException tags){
			   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			   System.out.println();
			   Thread.sleep(1200);
			   Case_Tags = p.Case_tags();}
		   tab_selector("Contacts");
		   p.Law_firm_info_title_text();
		   String Law_firm_name = pp.Law_firm_name_incard().getText().trim();
		   //System.out.println(Law_firm_name);
		   sd.Side_menu_option_clicker("Firm & Counsel",d,"Law Firm");	
		   pp.landed_in_Law_Firm_module();
		   p.View_all_Button().click();
		   WebElement search = pp.Law_firm_search_box();
		   search.sendKeys(Law_firm_name);
		   Thread.sleep(1800);
		   List<WebElement> law_firm_results;
		  try {
			  law_firm_results = p.rows();
			  law_firm_results.get(0).click();
		   Thread.sleep(800);}
		  catch(Exception Result_still_not_fetched){
			 System.out.println("Exception Found in fetching result rows thereby retrying");
			 System.out.println();
		   Thread.sleep(800);  
		   law_firm_results = p.rows();
		   law_firm_results.get(0).click();
		   Thread.sleep(800);}
		   WebElement Toast_A= lg.Toast_close_button();
		   Toast_A.click();
		   Thread.sleep(800);
		   WebElement Toast_B = lg.Toast_close_button();
		   Toast_B.click();
		   Thread.sleep(800);  /*
		   WebElement Toast_C= lg.Toast_close_button();
		   Toast_C.click(); */
		   
		   
		   Thread.sleep(800);  
	       p.Edit_button().click();
	       pp.Landed_in_Law_firm_edit_form();
	       List<WebElement> input_feilds=plaintiff.inputs();
	       rp.Feild_clear(input_feilds.get(0));
	       input_feilds.get(0).sendKeys(Firm_name);
	       rp.Feild_clear(input_feilds.get(1));
		   input_feilds.get(1).sendKeys(data.get("Phone"));
		   rp.Feild_clear(input_feilds.get(2));
		   input_feilds.get(2).sendKeys(data.get("Street Address 1"));/*
		    */
		   rp.Feild_clear(input_feilds.get(3));
		   input_feilds.get(3).sendKeys(data.get("Street Address 2"));
		   rp.Feild_clear(input_feilds.get(4));
		   input_feilds.get(4).sendKeys(data.get("City"));
		   rp.Feild_clear(input_feilds.get(5));
		   input_feilds.get(5).sendKeys(data.get("State"));
		   p.plaintiff_dropdown_list();
		   p.Plaintiff_options().get(0).click();
		   rp.Feild_clear(input_feilds.get(6));
		   input_feilds.get(6).sendKeys(data.get("Zip code"));	

			WebElement Add_Law_Frim_Button=plaintiff.form_buttons().get(0);
			rp.Scroll_to_element(Add_Law_Frim_Button);
			Add_Law_Frim_Button.click();
			Thread.sleep(800);	
			WebElement Toast_cancel_button = lg.Toast_close_button();
			String taost= lg.toast().getText().trim();
			Login_negative_testcases.Toast_printer(taost);
			Toast_cancel_button.click();
			Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step "+(step++)+":</b> Verify updated address is displayed in Law Firm list (Address column).");
		    System.out.println("[Step] Verify updated address in Law Firm list (Address column)");
			WebElement Again_search = pp.Law_firm_search_box();
			Again_search.sendKeys(Firm_name);
			   Thread.sleep(1800);
			    List<WebElement> Refetch_law_firm_results;
			    List<WebElement> Address_data_in_rows;

			    String Address = "";
			    try {
			        Refetch_law_firm_results = p.rows();
			        Address_data_in_rows = pp.Law_firm_Address_column_Cells_datas();
			        Address = Address_data_in_rows.get(0).getText().trim();
			        Thread.sleep(800);
			    }
			    catch(Exception Result_still_not_fetched){
			        System.out.println("Exception Found in fetching result rows thereby retrying");
			        System.out.println();
			        Refetch_law_firm_results = p.rows();
			        Address_data_in_rows = pp.Law_firm_Address_column_Cells_datas();
			        Address = Address_data_in_rows.get(0).getText().trim();
			    }

			    // Keep your original single-line console pass/fail (existing style)
			    System.out.println(Address.contains(State)&&Address.contains(City)&&Address.contains(Zip)&&Address.contains(Address_line_1)&&Address.contains(Address_line_2)
			            ?"Testcase Passed City, State and Address details properly shown"
			            :"Testcase Failed City, State and Address details not properly shown");
			    System.out.println();

			    // Client-friendly PASS/FAIL + reasons (Extent + Console)
			    StringBuilder missing1 = new StringBuilder();
			    if (!Address.contains(State)) missing1.append("• Missing State: ").append(State).append("<br>");
			    if (!Address.contains(City)) missing1.append("• Missing City: ").append(City).append("<br>");
			    if (!Address.contains(Zip)) missing1.append("• Missing Zip: ").append(Zip).append("<br>");
			    if (!Address.contains(Address_line_1)) missing1.append("• Missing Address Line 1: ").append(Address_line_1).append("<br>");
			    if (!Address.contains(Address_line_2)) missing1.append("• Missing Address Line 2: ").append(Address_line_2).append("<br>");

			    boolean listAddressMatch = (missing1.length() == 0);

			    StringBuilder extent1 = new StringBuilder();
			    extent1.append("<b>🏢 Law Firm List Address Verification</b><br>");
			    extent1.append("<b>Displayed Address (UI):</b><br>").append(Address).append("<br><br>");
			    extent1.append("<b>Payment not involved.</b> This is only address reflection check.<br><br>");
			    extent1.append("<b>Result:</b> ").append(listAddressMatch ? "PASS (All parts matched)" : "FAIL (Mismatch found)").append("<br>");
			    if(!listAddressMatch){
			        extent1.append("<b>Mismatch Reason(s):</b><br>").append(missing1.toString());
			    }

			    Report_Listen.log_print_in_report().log(listAddressMatch ? Status.PASS : Status.FAIL, extent1.toString());

			    System.out.println("[Law Firm List Address Verification]");
			    System.out.println("Displayed Address (UI): " + Address);
			    if(listAddressMatch){
			        System.out.println("Result: PASS (All parts matched)");
			    }else{
			        System.out.println("Result: FAIL (Mismatch found)");
			        if (!Address.contains(State)) System.out.println(" - Missing State: " + State);
			        if (!Address.contains(City)) System.out.println(" - Missing City: " + City);
			        if (!Address.contains(Zip)) System.out.println(" - Missing Zip: " + Zip);
			        if (!Address.contains(Address_line_1)) System.out.println(" - Missing Address Line 1: " + Address_line_1);
			        if (!Address.contains(Address_line_2)) System.out.println(" - Missing Address Line 2: " + Address_line_2);
			    }
			    System.out.println();


			    // ==========================================================
			    // Step 4: Re-open same Case and validate address in Case Contacts card
			    // ==========================================================
			    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step "+(step++)+":</b> Re-open the same case and verify updated address reflects inside Case → Contacts (Law Firm card).");
			    System.out.println("[Step] Re-open same case -> Contacts -> verify Law Firm address in case card");

			    sd.Side_menu_option_clicker("Applications", d,"N/A");
			    p.landed_in_applicationList_confirmation();
			    p.Filter_clear().click();

			    WebElement Search_two = p.Application_search();
			    Search_two.sendKeys(Case_id); // fixed: earlier code was using Search by mistake
			    Thread.sleep(800);

			    // Toast closes (existing pattern)
			    try{
			        WebElement Toast_Three = lg.Toast_close_button();
			        rp.movetoelement(Toast_Three);
			        Toast_Three.click();
			    }catch(Exception e){
			        // silent
			    }

			    WebElement Toast_Four;
			    try{
			        Toast_Four = lg.Toast_close_button();
			        rp.movetoelement(Toast_Four);
			        Toast_Four.click();
			    }
			    catch(Exception Toast_closes){
			        Toast_Four = lg.Toast_close_button();
			        rp.movetoelement(Toast_Four);
			        Toast_Four.click();
			        System.out.println("Exception found in Toast two close thereby retried");
			    }

			    List<WebElement> result_rows_two;
			    try {
			        result_rows_two = p.rows();
			        result_rows_two.get(0).click();
			        Thread.sleep(800);
			    }
			    catch(Exception Result_still_not_fetched){
			        System.out.println("Exception Found in fetching result rows thereby retrying");
			        System.out.println();
			        Thread.sleep(800);
			        result_rows_two = p.rows();
			        result_rows_two.get(0).click();
			        Thread.sleep(800);
			    }

			    List<WebElement> Case_Tags_One;
			    try {
			        Case_Tags_One = p.Case_tags();
			    }
			    catch(RuntimeException tags){
			        System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			        System.out.println();
			        Thread.sleep(1200);
			        Case_Tags_One = p.Case_tags();
			    }

			    tab_selector("Contacts");
			    p.Law_firm_info_title_text();

			    WebElement Address_element_incase_contact = pp.Case_contact_law_firm_address();
			    String Address_incase_contact_text = Address_element_incase_contact.getText().trim();

			    // Keep your original single-line console pass/fail (existing style)
			    System.out.println(Address_incase_contact_text.contains(State)&&Address_incase_contact_text.contains(City)&&Address_incase_contact_text.contains(Zip)
			            &&Address_incase_contact_text.contains(Address_line_1)&&Address_incase_contact_text.contains(Address_line_2)
			            ?"Testcase Passed City, State and Address details properly shown in case law firm contact"
			            :"Testcase Failed City, State and Address details not properly shown in case law firm contact");
			    System.out.println();

			    // Client-friendly PASS/FAIL + reasons (Extent + Console)
			    StringBuilder missing2 = new StringBuilder();
			    if (!Address_incase_contact_text.contains(State)) missing2.append("• Missing State: ").append(State).append("<br>");
			    if (!Address_incase_contact_text.contains(City)) missing2.append("• Missing City: ").append(City).append("<br>");
			    if (!Address_incase_contact_text.contains(Zip)) missing2.append("• Missing Zip: ").append(Zip).append("<br>");
			    if (!Address_incase_contact_text.contains(Address_line_1)) missing2.append("• Missing Address Line 1: ").append(Address_line_1).append("<br>");
			    if (!Address_incase_contact_text.contains(Address_line_2)) missing2.append("• Missing Address Line 2: ").append(Address_line_2).append("<br>");

			    boolean caseContactAddressMatch = (missing2.length() == 0);

			    StringBuilder extent2 = new StringBuilder();
			    extent2.append("<b>📇 Case Contacts Address Verification (Law Firm)</b><br>");
			    extent2.append("<b>Displayed Address (UI):</b><br>").append(Address_incase_contact_text).append("<br><br>");
			    extent2.append("<b>Result:</b> ").append(caseContactAddressMatch ? "PASS (All parts matched)" : "FAIL (Mismatch found)").append("<br>");
			    if(!caseContactAddressMatch){
			        extent2.append("<b>Mismatch Reason(s):</b><br>").append(missing2.toString());
			    }

			    Report_Listen.log_print_in_report().log(caseContactAddressMatch ? Status.PASS : Status.FAIL, extent2.toString());

			    System.out.println("[Case Contacts Address Verification - Law Firm]");
			    System.out.println("Displayed Address (UI): " + Address_incase_contact_text);
			    if(caseContactAddressMatch){
			        System.out.println("Result: PASS (All parts matched)");
			    }else{
			        System.out.println("Result: FAIL (Mismatch found)");
			        if (!Address_incase_contact_text.contains(State)) System.out.println(" - Missing State: " + State);
			        if (!Address_incase_contact_text.contains(City)) System.out.println(" - Missing City: " + City);
			        if (!Address_incase_contact_text.contains(Zip)) System.out.println(" - Missing Zip: " + Zip);
			        if (!Address_incase_contact_text.contains(Address_line_1)) System.out.println(" - Missing Address Line 1: " + Address_line_1);
			        if (!Address_incase_contact_text.contains(Address_line_2)) System.out.println(" - Missing Address Line 2: " + Address_line_2);
			    }
			    System.out.println();


			    // ==========================================================
			    // Final Summary (Client friendly)
			    // ==========================================================
			    StringBuilder finalSummary = new StringBuilder();
			    finalSummary.append("<b>✅ Final Summary:</b><br>");
			    finalSummary.append("• Law Firm list address verification: <b>").append(listAddressMatch ? "PASS" : "FAIL").append("</b><br>");
			    finalSummary.append("• Case contacts address verification: <b>").append(caseContactAddressMatch ? "PASS" : "FAIL").append("</b><br>");

			    Report_Listen.log_print_in_report().log((listAddressMatch && caseContactAddressMatch) ? Status.PASS : Status.FAIL, finalSummary.toString());

			    System.out.println("[FINAL SUMMARY]");
			    System.out.println("Law Firm list address verification : " + (listAddressMatch ? "PASS" : "FAIL"));
			    System.out.println("Case contacts address verification : " + (caseContactAddressMatch ? "PASS" : "FAIL"));
			    System.out.println();
			}
		  
	  
	
	
	
	
	
		@DataProvider
		public Object[][] lawFirmData() {

		    // ✅ Keys mapped to your "Add Law Firm" modal:
		    // Name, Phone, City, State, Street Address 1, Street Address 2, Zip code

			TreeMap<String, String> lf1 = new TreeMap<>();
		    lf1.put("Name", "VerdictForge Litigation Atelier");
		    lf1.put("Phone", "3024389017");
		    lf1.put("City", "Wilmington");
		    lf1.put("State", "Delaware");
		    lf1.put("Street Address 1", "919 N Market St, Brandywine Commerce Center, Main Lobby");
		    lf1.put("Street Address 2", "Suite 1204, Intake: Desk 3, Elevator Bank A");
		    lf1.put("Zip code", "19801");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "NorthStar Docketworks");
		    lf2.put("Phone", "8026317742");
		    lf2.put("City", "Burlington");
		    lf2.put("State", "Vermont");
		    lf2.put("Street Address 1", "100 Main St, Lakefront Professional Building, Street Entrance");
		    lf2.put("Street Address 2", "Floor 6, Suite 6B, Delivery: Reception Window");
		    lf2.put("Zip code", "05401");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "Cascade Claimcraft Legal Studio");
		    lf3.put("Phone", "5032196804");
		    lf3.put("City", "Portland");
		    lf3.put("State", "Oregon");
		    lf3.put("Street Address 1", "111 SW 5th Ave, Pioneer District Office Arcade, Security Desk");
		    lf3.put("Street Address 2", "Suite 1740, Mail Stop OR-17, Signature Required");
		    lf3.put("Zip code", "97204");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "Keystone Dispute Lab");
		    lf4.put("Phone", "4127765409");
		    lf4.put("City", "Pittsburgh");
		    lf4.put("State", "Pennsylvania");
		    lf4.put("Street Address 1", "600 Grant St, Steel City Tower, Concourse Entry");
		    lf4.put("Street Address 2", "Suite 2109, Intake: Counter B, Visitor Badge Needed");
		    lf4.put("Zip code", "15219");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Peachtree Litigation Works");
		    lf5.put("Phone", "4049152638");
		    lf5.put("City", "Atlanta");
		    lf5.put("State", "Georgia");
		    lf5.put("Street Address 1", "191 Peachtree St NE, Midtown Commerce Annex, Main Lobby");
		    lf5.put("Street Address 2", "Floor 14, Suite 1402, Deliveries: Desk A");
		    lf5.put("Zip code", "30303");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "HarborLedger Trial Office");
		    lf6.put("Phone", "4106821570");
		    lf6.put("City", "Baltimore");
		    lf6.put("State", "Maryland");
		    lf6.put("Street Address 1", "10 Light St, Inner Harbor Business Tower, West Entrance");
		    lf6.put("Street Address 2", "Suite 1806, Intake: Room 18C, Package Scan at Security");
		    lf6.put("Zip code", "21202");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "BayState Casebuilders");
		    lf7.put("Phone", "5084339261");
		    lf7.put("City", "Worcester");
		    lf7.put("State", "Massachusetts");
		    lf7.put("Street Address 1", "255 Park Ave, Downtown Professional Row, Main Desk");
		    lf7.put("Street Address 2", "Suite 901, Mail Stop MA-09, Leave with Reception");
		    lf7.put("Zip code", "01609");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "MillCity Docket Foundry");
		    lf8.put("Phone", "6125078436");
		    lf8.put("City", "Minneapolis");
		    lf8.put("State", "Minnesota");
		    lf8.put("Street Address 1", "120 S 6th St, Skyway Commerce Plaza, North Lobby");
		    lf8.put("Street Address 2", "Suite 2405, Intake: Desk 2, Elevator Bank C");
		    lf8.put("Zip code", "55402");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "Gateway Pleading House");
		    lf9.put("Phone", "3147905524");
		    lf9.put("City", "St. Louis");
		    lf9.put("State", "Missouri");
		    lf9.put("Street Address 1", "1 S Memorial Dr, Arch District Office Tower, Main Lobby");
		    lf9.put("Street Address 2", "Floor 16, Suite 1608, Deliveries: Weekdays Only");
		    lf9.put("Zip code", "63102");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "PrairieMotion Claims Studio");
		    lf10.put("Phone", "3166881049");
		    lf10.put("City", "Wichita");
		    lf10.put("State", "Kansas");
		    lf10.put("Street Address 1", "100 N Broadway St, Old Town Commerce Block, East Entrance");
		    lf10.put("Street Address 2", "Suite 705, Intake: Window 1, Visitor Parking Level 2");
		    lf10.put("Zip code", "67202");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "FrontRange Trial Mechanics");
		    lf11.put("Phone", "7195338702");
		    lf11.put("City", "Colorado Springs");
		    lf11.put("State", "Colorado");
		    lf11.put("Street Address 1", "2 N Cascade Ave, Civic Center Office Annex, South Lobby");
		    lf11.put("Street Address 2", "Suite 1109, Intake: Desk C, Badge Pickup at Security");
		    lf11.put("Zip code", "80903");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "Capitol Briefworks");
		    lf12.put("Phone", "5129401168");
		    lf12.put("City", "Austin");
		    lf12.put("State", "Texas");
		    lf12.put("Street Address 1", "600 Congress Ave, Downtown Commerce Gallery, Main Entrance");
		    lf12.put("Street Address 2", "Suite 2204, Mail Stop TX-22, Deliver to Reception B");
		    lf12.put("Zip code", "78701");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "SunCoast Liability Atelier");
		    lf13.put("Phone", "8137714056");
		    lf13.put("City", "Tampa");
		    lf13.put("State", "Florida");
		    lf13.put("Street Address 1", "201 N Franklin St, Riverwalk Business Center, Security Desk");
		    lf13.put("Street Address 2", "Suite 1907, Intake: Room 19A, Call-on-arrival");
		    lf13.put("Zip code", "33602");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "InlandBrief Trial Rooms");
		    lf14.put("Phone", "5096287341");
		    lf14.put("City", "Spokane");
		    lf14.put("State", "Washington");
		    lf14.put("Street Address 1", "601 W 1st Ave, Downtown Office Promenade, West Lobby");
		    lf14.put("Street Address 2", "Suite 1403, Intake: Desk 1, Package Scan Required");
		    lf14.put("Zip code", "99201");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "Silicon Valley Caseworks Bureau");
		    lf15.put("Phone", "4086159027");
		    lf15.put("City", "San Jose");
		    lf15.put("State", "California");
		    lf15.put("Street Address 1", "1 S Market St, Plaza District Office Tower, Main Lobby");
		    lf15.put("Street Address 2", "Suite 2010, Intake: Counter A, Visitor Badge Needed");
		    lf15.put("Zip code", "95113");

		    TreeMap<String, String> lf16 = new TreeMap<>();
		    lf16.put("Name", "DuPage Trialcraft Office");
		    lf16.put("Phone", "6304417305");
		    lf16.put("City", "Naperville");
		    lf16.put("State", "Illinois");
		    lf16.put("Street Address 1", "175 W Jackson Ave, Riverwalk Professional Center, Lobby Level");
		    lf16.put("Street Address 2", "Suite 905, Mail Stop IL-09, Deliveries: Reception");
		    lf16.put("Zip code", "60540");

		    TreeMap<String, String> lf17 = new TreeMap<>();
		    lf17.put("Name", "RiverBend Pleading Studio");
		    lf17.put("Phone", "8123709184");
		    lf17.put("City", "Evansville");
		    lf17.put("State", "Indiana");
		    lf17.put("Street Address 1", "20 NW 1st St, Downtown Commerce Row, North Entrance");
		    lf17.put("Street Address 2", "Suite 604, Intake: Desk B, Visitor Parking Garage A");
		    lf17.put("Zip code", "47708");

		    TreeMap<String, String> lf18 = new TreeMap<>();
		    lf18.put("Name", "SummitCourt Litigation Desk");
		    lf18.put("Phone", "3307926031");
		    lf18.put("City", "Akron");
		    lf18.put("State", "Ohio");
		    lf18.put("Street Address 1", "1 S Main St, Courthouse District Office Annex, Main Lobby");
		    lf18.put("Street Address 2", "Suite 1506, Intake: Room 15D, Signature Required");
		    lf18.put("Zip code", "44308");

		    TreeMap<String, String> lf19 = new TreeMap<>();
		    lf19.put("Name", "Sonoran Docketwright Office");
		    lf19.put("Phone", "4806281975");
		    lf19.put("City", "Mesa");
		    lf19.put("State", "Arizona");
		    lf19.put("Street Address 1", "40 N Center St, Downtown Commerce Atrium, East Lobby");
		    lf19.put("Street Address 2", "Suite 1210, Intake: Desk 2, Call Reception on Arrival");
		    lf19.put("Zip code", "85201");

		    TreeMap<String, String> lf20 = new TreeMap<>();
		    lf20.put("Name", "SangreBrief Civil Practice Atelier");
		    lf20.put("Phone", "5056447813");
		    lf20.put("City", "Santa Fe");
		    lf20.put("State", "New Mexico");
		    lf20.put("Street Address 1", "201 W Marcy St, Capitol District Office Block, Main Desk");
		    lf20.put("Street Address 2", "Suite 708, Mail Stop NM-07, Deliveries Weekdays Only");
		    lf20.put("Zip code", "87501");

		    return new Object[][]{
		        {lf1},{lf2},{lf3},{lf4},{lf5},
		        {lf6},{lf7},{lf8},{lf9},{lf10},
		        {lf11},{lf12},{lf13},{lf14},{lf15},
		        {lf16},{lf17},{lf18},{lf19},{lf20} 
		    };
		}

		@DataProvider
		public Object[][] lawFirmEditData() {

		    TreeMap<String, String> lf1 = new TreeMap<>();
		    lf1.put("Name", "ObsidianQuill Legal Cartography LLP");
		    lf1.put("Phone", "9076183427");
		    lf1.put("City", "Anchorage");
		    lf1.put("State", "Alaska");
		    lf1.put("Street Address 1", "701 W 8th Ave, Aurora Trade Center");
		    lf1.put("Street Address 2", "Suite 1460");
		    lf1.put("Zip code", "99501");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "JuniperWrit Docket Atelier");
		    lf2.put("Phone", "5204739186");
		    lf2.put("City", "Tucson");
		    lf2.put("State", "Arizona");
		    lf2.put("Street Address 1", "177 N Church Ave, Cobalt Commons");
		    lf2.put("Street Address 2", "Floor 9, Suite 905");
		    lf2.put("Zip code", "85701");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "RedwoodVellum Casewrights PC");
		    lf3.put("Phone", "4157286039");
		    lf3.put("City", "San Francisco");
		    lf3.put("State", "California");
		    lf3.put("Street Address 1", "580 California St, Meridian Exchange Building");
		    lf3.put("Street Address 2", "Suite 1740");
		    lf3.put("Zip code", "94104");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "PinyonLedger Trialworks Group");
		    lf4.put("Phone", "9705562418");
		    lf4.put("City", "Fort Collins");
		    lf4.put("State", "Colorado");
		    lf4.put("Street Address 1", "201 S College Ave, Northgate Professional Plaza");
		    lf4.put("Street Address 2", "Unit 1206");
		    lf4.put("Zip code", "80524");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Seabrook Pleadings & Proofhouse");
		    lf5.put("Phone", "8609047712");
		    lf5.put("City", "New Haven");
		    lf5.put("State", "Connecticut");
		    lf5.put("Street Address 1", "195 Church St, Harborstone Towers");
		    lf5.put("Street Address 2", "Suite 802");
		    lf5.put("Zip code", "06510");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "Hearthline Motion Drafting Co.");
		    lf6.put("Phone", "3027715064");
		    lf6.put("City", "Newark");
		    lf6.put("State", "Delaware");
		    lf6.put("Street Address 1", "800 N King St, Ironleaf Center");
		    lf6.put("Street Address 2", "Suite 910");
		    lf6.put("Zip code", "19711");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "MarinerGlyph Litigation Rooms");
		    lf7.put("Phone", "8503186642");
		    lf7.put("City", "Tallahassee");
		    lf7.put("State", "Florida");
		    lf7.put("Street Address 1", "215 S Monroe St, Capitol Walk Offices");
		    lf7.put("Street Address 2", "Suite 1312");
		    lf7.put("Zip code", "32301");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "CrescentWrit Civil Briefworks");
		    lf8.put("Phone", "7064429831");
		    lf8.put("City", "Augusta");
		    lf8.put("State", "Georgia");
		    lf8.put("Street Address 1", "699 Broad St, Riverfront Commerce House");
		    lf8.put("Street Address 2", "Floor 7, Suite 704");
		    lf8.put("Zip code", "30901");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "PacificCharter Docket Bureau");
		    lf9.put("Phone", "6717774028");
		    lf9.put("City", "Hagåtña");
		    lf9.put("State", "Guam");
		    lf9.put("Street Address 1", "245 Archbishop Flores St, Plaza San Vitores");
		    lf9.put("Street Address 2", "Suite 402");
		    lf9.put("Zip code", "96910");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "KoaStencil Trialcraft Partners");
		    lf10.put("Phone", "8085239167");
		    lf10.put("City", "Honolulu");
		    lf10.put("State", "Hawaii");
		    lf10.put("Street Address 1", "1132 Bishop St, Makai Exchange Tower");
		    lf10.put("Street Address 2", "Suite 1806");
		    lf10.put("Zip code", "96813");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "Sawtooth Pleading Foundry");
		    lf11.put("Phone", "2086147392");
		    lf11.put("City", "Boise");
		    lf11.put("State", "Idaho");
		    lf11.put("Street Address 1", "950 W Bannock St, Clearwater Offices");
		    lf11.put("Street Address 2", "Suite 1115");
		    lf11.put("Zip code", "83702");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "PrairieKnot Case Mechanics");
		    lf12.put("Phone", "2179053184");
		    lf12.put("City", "Springfield");
		    lf12.put("State", "Illinois");
		    lf12.put("Street Address 1", "1 N Old State Capitol Plaza, Lincoln Arcade");
		    lf12.put("Street Address 2", "Suite 640");
		    lf12.put("Zip code", "62701");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "MonumentBrief Litigation Annex");
		    lf13.put("Phone", "3176104289");
		    lf13.put("City", "Indianapolis");
		    lf13.put("State", "Indiana");
		    lf13.put("Street Address 1", "151 N Delaware St, Meridian Crest Building");
		    lf13.put("Street Address 2", "Floor 12, Suite 1209");
		    lf13.put("Zip code", "46204");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "Cornfield Ledger Counselworks");
		    lf14.put("Phone", "5157206391");
		    lf14.put("City", "Des Moines");
		    lf14.put("State", "Iowa");
		    lf14.put("Street Address 1", "801 Walnut St, Raccoon River Trade Tower");
		    lf14.put("Street Address 2", "Suite 1703");
		    lf14.put("Zip code", "50309");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "FlintArc Docket & Motion Studio");
		    lf15.put("Phone", "3166149057");
		    lf15.put("City", "Topeka");
		    lf15.put("State", "Kansas");
		    lf15.put("Street Address 1", "110 SE 6th Ave, Sunflower Commerce Center");
		    lf15.put("Street Address 2", "Suite 905");
		    lf15.put("Zip code", "66603");

		    TreeMap<String, String> lf16 = new TreeMap<>();
		    lf16.put("Name", "Bluegrass Pleadings Cooperative");
		    lf16.put("Phone", "2705087741");
		    lf16.put("City", "Bowling Green");
		    lf16.put("State", "Kentucky");
		    lf16.put("Street Address 1", "600 W Main Ave, Cumberland Row Offices");
		    lf16.put("Street Address 2", "Suite 510");
		    lf16.put("Zip code", "42101");

		    TreeMap<String, String> lf17 = new TreeMap<>();
		    lf17.put("Name", "BayouQuorum Trial Draft House");
		    lf17.put("Phone", "3187714906");
		    lf17.put("City", "Shreveport");
		    lf17.put("State", "Louisiana");
		    lf17.put("Street Address 1", "333 Texas St, Red River Commerce Hall");
		    lf17.put("Street Address 2", "Floor 8, Suite 812");
		    lf17.put("Zip code", "71101");

		    TreeMap<String, String> lf18 = new TreeMap<>();
		    lf18.put("Name", "PineHarbor Litigation Scriptorium");
		    lf18.put("Phone", "2076159834");
		    lf18.put("City", "Portland");
		    lf18.put("State", "Maine");
		    lf18.put("Street Address 1", "477 Congress St, Casco Exchange Building");
		    lf18.put("Street Address 2", "Suite 710");
		    lf18.put("Zip code", "04101");

		    TreeMap<String, String> lf19 = new TreeMap<>();
		    lf19.put("Name", "Chesapeake Pleading Loom");
		    lf19.put("Phone", "2406147728");
		    lf19.put("City", "Rockville");
		    lf19.put("State", "Maryland");
		    lf19.put("Street Address 1", "51 Monroe St, Courthouse Square Offices");
		    lf19.put("Street Address 2", "Suite 905");
		    lf19.put("Zip code", "20850");

		    TreeMap<String, String> lf20 = new TreeMap<>();
		    lf20.put("Name", "GraniteBay Casewright Atelier");
		    lf20.put("Phone", "6036112049");
		    lf20.put("City", "Concord");
		    lf20.put("State", "New Hampshire");
		    lf20.put("Street Address 1", "1 Eagle Square, Merrimack Trade House");
		    lf20.put("Street Address 2", "Suite 604");
		    lf20.put("Zip code", "03301");

		    return new Object[][]{
		        {lf1},{lf2}, {lf3}, {lf4}, {lf5},
		        {lf6}, {lf7}, {lf8}, {lf9}, {lf10},
		        {lf11}, {lf12}, {lf13}, {lf14}, {lf15},
		        {lf16}, {lf17}, {lf18}, {lf19}, {lf20} 
		    };
		}

		
		
		
		
		
	

}
