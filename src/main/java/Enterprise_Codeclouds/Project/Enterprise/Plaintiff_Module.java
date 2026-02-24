package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Plaintiff_Module extends Case_Appplications{
	
	
	HashMap<String,String> plaintiff_label_contents = new HashMap<String,String>();
	TreeMap<String,String> plaintiff_Details_labels_and_contents = new TreeMap<String,String>();
	
	@Test(dataProvider="plaintiffData")
	public void Plaintiff_Add(TreeMap<String,String> data) throws IOException, InterruptedException {

	    SIde_Menu_Handler sd = new SIde_Menu_Handler();
	    Plaintiff_Locaters p = new Plaintiff_Locaters(d);
	    Repeat rp = new Repeat(d);
	    Login_Locaters lg = new Login_Locaters(d);
	    Application_Locaters ap = new Application_Locaters(d);

	    // ✅ Fetch once from map (reuse everywhere)
	    String firstName  = data.get("First Name");
	    String middleName = data.get("Middle Name");
	    String lastName   = data.get("Last Name");
	    String suffix     = data.get("Name Suffix");

	    String email      = data.get("Email");
	    String ssn        = data.get("Social Security Number");
	    String phone      = data.get("Phone number");

	    String dob        = data.get("Date of Birth");
	    String city       = data.get("City");
	    String state      = data.get("State");
	    String zip        = data.get("Zip code");

	    String addr1      = data.get("Address Line 1");
	    String addr2      = data.get("Address Line 2");

	    int step = 1;

	    // =========================
	    // ✅ Scenario Header (Extent)
	    // =========================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Scenario Title:</b> Add New Plaintiff (Create + Verify Details)<br>" +
	            "<b>📘 Description:</b> Open Plaintiffs module, fill form with valid details, submit, capture toast, then verify details in profile.<br>" +
	            "<b>📥 Input:</b> " +
	            "Name=<b>" + firstName + " " + middleName + " " + lastName + " " + suffix + "</b> | " +
	            "Email=<b>" + email + "</b> | Phone=<b>" + phone + "</b> | " +
	            "DOB=<b>" + dob + "</b> | City=<b>" + city + "</b> | State=<b>" + state + "</b> | Zip=<b>" + zip + "</b><br>" +
	            "<b>✅ Expected:</b> Plaintiff should be created successfully and success toast should appear. Newly created plaintiff should be visible and details should match."
	    );

	    // =========================
	    // ✅ Console Header
	    // =========================
	    System.out.println("\n==================================================");
	    System.out.println("[SCENARIO] Add New Plaintiff (Create + Verify Details)");
	    System.out.println("Name   : " + firstName + " " + middleName + " " + lastName + " " + suffix);
	    System.out.println("Email  : " + email);
	    System.out.println("Phone  : " + phone);
	    System.out.println("DOB    : " + dob);
	    System.out.println("State  : " + state + " | Zip: " + zip);
	    System.out.println("==================================================\n");

	    // Step 1
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open Plaintiffs module from side menu.");
	    System.out.println("[Step] Open Plaintiffs module from side menu");
	    sd.Side_menu_option_clicker("Plaintiffs", d, "N/A");
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Clicked Plaintiffs option in side menu.");
	    System.out.println("Actual: Plaintiffs menu clicked\n");

	    // Step 2
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Verify user landed inside Plaintiffs module.");
	    System.out.println("[Step] Verify landing in Plaintiffs module");
	    p.landed_in_plaintiff_module();
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plaintiffs module landing verification executed.");
	    System.out.println("Actual: Landing confirmed\n");

	    // Step 3
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Scroll to Add Plaintiff form.");
	    System.out.println("[Step] Scroll to Add Plaintiff form");
	    rp.Scroll_to_element(p.form());
	    Thread.sleep(800);
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Add Plaintiff form is in view.");
	    System.out.println("Actual: Form visible\n");

	    // Step 4
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill Name fields (First, Middle, Last, Suffix).");
	    System.out.println("[Step] Fill Name fields");
	    List<WebElement> input_fields = p.inputs();
	    input_fields.get(0).sendKeys(firstName);
	    input_fields.get(1).sendKeys(middleName);
	    input_fields.get(2).sendKeys(lastName);
	    input_fields.get(3).sendKeys(suffix);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Name entered = <b>" + firstName + " " + middleName + " " + lastName + " " + suffix + "</b>");
	    System.out.println("Actual: Name filled\n");

	    // Step 5
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill Contact + Identity details (Email, SSN, Phone).");
	    System.out.println("[Step] Fill Email/SSN/Phone");
	    input_fields.get(5).sendKeys(email);
	    input_fields.get(7).sendKeys(ssn);
	    input_fields.get(4).sendKeys(phone);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Contact entered = Email=<b>" + email + "</b> | SSN=<b>" + ssn + "</b> | Phone=<b>" + phone + "</b>");
	    System.out.println("Actual: Contact details filled\n");

	    // Step 6
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill DOB + Location details (DOB, City, State, Zip).");
	    System.out.println("[Step] Fill DOB + City + State + Zip");
	    input_fields.get(6).sendKeys(dob);
	    input_fields.get(8).sendKeys(city);
	    input_fields.get(9).sendKeys(state);

	    ap.plaintiff_dropdown_list();
	    ap.Plaintiff_options().get(0).click();

	    input_fields.get(10).sendKeys(zip);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Location entered = DOB=<b>" + dob + "</b> | City=<b>" + city + "</b> | State=<b>" + state + "</b> | Zip=<b>" + zip + "</b>");
	    System.out.println("Actual: DOB & location filled\n");

	    // Step 7
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill Address fields (Address Line 1 & 2).");
	    System.out.println("[Step] Fill Address fields");
	    List<WebElement> textAreas = p.text_area_fields();
	    rp.Scroll_to_element(textAreas.get(0));
	    textAreas.get(0).sendKeys(addr1);
	    textAreas.get(1).sendKeys(addr2);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Address entered = <b>" + addr1 + "</b> | <b>" + addr2 + "</b>");
	    System.out.println("Actual: Address filled\n");

	    // Step 8
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Add Plaintiff button to submit the form.");
	    System.out.println("[Step] Submit Add Plaintiff form");
	    WebElement addPlaintiffBtn = p.form_buttons().get(0);
	    rp.Scroll_to_element(addPlaintiffBtn);
	    addPlaintiffBtn.click();
	    Thread.sleep(800);

	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Add Plaintiff button clicked.");
	    System.out.println("Actual: Submit clicked\n");

	    // Step 9
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture toast message after submission.");
	    System.out.println("[Step] Capture toast after submission");

	    WebElement toastElement = lg.toast();
	    try {
	        String toastText = toastElement.getText().trim();

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> ✅ Toast captured = <b>" + toastText + "</b>");

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>✅ Final Result:</b> Plaintiff created successfully for Email=<b>" + email + "</b> | Phone=<b>" + phone + "</b>");

	        System.out.println("✅ Toast: " + toastText + "\n");
	        rp.wait_for_invisibility(toastElement);

	    } catch (Exception e) {
	        Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>🟨 Actual:</b> ❌ Toast not captured after Add Plaintiff (toast not visible / locator issue).");

	        Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>❌ Final Result:</b> Form submitted but success confirmation was not captured for Email=<b>" + email + "</b>");

	        System.out.println("❌ FAIL: Toast not captured after submit\n");
	        throw e;
	    }

	    // ✅ same call as your existing flow
	    plaintiff_details_reader(data);
	}

	
	
	
	public void plaintiff_details_reader(TreeMap<String,String> Plaintiff_Add_Data) throws InterruptedException {

	    Plaintiff_Locaters p = new Plaintiff_Locaters(d);
	    Repeat rp = new Repeat(d);
	    Application_Locaters ap = new Application_Locaters(d);

	    // ✅ Fetch once from map (reuse everywhere)
	    String firstName  = Plaintiff_Add_Data.get("First Name");
	    String middleName = Plaintiff_Add_Data.get("Middle Name");
	    String lastName   = Plaintiff_Add_Data.get("Last Name");
	    String suffix     = Plaintiff_Add_Data.get("Name Suffix");

	    String email      = Plaintiff_Add_Data.get("Email");
	    String phone      = Plaintiff_Add_Data.get("Phone number");

	    String dob        = Plaintiff_Add_Data.get("Date of Birth");
	    String city       = Plaintiff_Add_Data.get("City");
	    String state      = Plaintiff_Add_Data.get("State");
	    String addr1      = Plaintiff_Add_Data.get("Address Line 1");
	    String addr2      = Plaintiff_Add_Data.get("Address Line 2");
	    String zip        = Plaintiff_Add_Data.get("Zip code");

	    plaintiff_Details_labels_and_contents.clear();

	    // =========================
	    // Extent Header
	    // =========================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Scenario Title:</b> Plaintiff Details Verification<br>" +
	            "<b>📘 Description:</b> From Plaintiffs list, open first row profile and capture Label-Value pairs, then validate Address contains expected fields.<br>" +
	            "<b>📥 Input:</b> Plaintiff=<b>" + firstName + " " + middleName + " " + lastName + "</b> | Email=<b>" + email + "</b><br>" +
	            "<b>✅ Expected:</b> Newly added plaintiff should appear in top row and Address section should contain city/state/address lines/zip."
	    );

	    // =========================
	    // Console Header
	    // =========================
	    System.out.println("==================================================");
	    System.out.println("[SCENARIO] Plaintiff Details Verification");
	    System.out.println("Expected Plaintiff First Name : " + firstName);
	    System.out.println("Expected Address Should Contain: " + city + ", " + state + ", " + addr1 + ", " + addr2 + ", " + zip);
	    System.out.println("==================================================\n");

	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Action:</b> Read first row from table and verify plaintiff is present.");
	    System.out.println("[Action] Read first row from table");

	    rp.Scroll_to_element(ap.table_body());
	    Thread.sleep(1200);

	    List<WebElement> table_rows;
	    try {
	        table_rows = ap.rows();
	    } catch (Exception tabs) {
	        Thread.sleep(800);
	        table_rows = ap.rows();
	    }

	    WebElement first_row = table_rows.get(0);
	    String first_row_contents = first_row.getText().trim();

	    boolean isPlaintiffPresent = first_row_contents.contains(firstName);

	    Report_Listen.log_print_in_report().log(isPlaintiffPresent ? Status.PASS : Status.FAIL,
	            isPlaintiffPresent
	                    ? "<b>✅ Result:</b> Plaintiff <b>" + firstName + "</b> found in first table row."
	                    : "<b>❌ Result:</b> Plaintiff <b>" + firstName + "</b> NOT found in first table row.");

	    System.out.println(isPlaintiffPresent
	            ? "✅ PASS: Added plaintiff '" + firstName + "' shown in first row."
	            : "❌ FAIL: Added plaintiff '" + firstName + "' NOT shown in first row.");
	    System.out.println();

	    if (isPlaintiffPresent) {

	        Report_Listen.log_print_in_report().log(Status.INFO, "<b>📌 Action:</b> Open plaintiff profile by clicking first row.");
	        System.out.println("[Action] Open plaintiff profile");

	        first_row.click();
	        p.Landed_in_Plaintiff_details_page();
	        Thread.sleep(950);

	        List<WebElement> detailsLabels = p.Labels();
	        List<WebElement> detailsValues = p.Values();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Labels found = <b>" + detailsLabels.size() + "</b> | Values found = <b>" + detailsValues.size() + "</b>");
	        System.out.println("Actual: Labels=" + detailsLabels.size() + " | Values=" + detailsValues.size());
	        System.out.println();

	        if (detailsLabels.size() == detailsValues.size()) {

	            for (int i = 0; i < detailsLabels.size(); i++) {
	                String labelText = detailsLabels.get(i).getText().trim();
	                String valueText = detailsValues.get(i).getText().trim();
	                plaintiff_Details_labels_and_contents.put(labelText, valueText);
	            }

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🟨 Actual:</b> Stored Label-Value pairs = <b>" + plaintiff_Details_labels_and_contents.size() + "</b>");
	            System.out.println("Actual: Stored label-value pairs = " + plaintiff_Details_labels_and_contents.size());
	            System.out.println();

	        } else {
	            Report_Listen.log_print_in_report().log(Status.FAIL,
	                    "<b>❌ Result:</b> Labels and Values count mismatch. Cannot build label-value map reliably.");
	            System.out.println("❌ FAIL: Labels and values count mismatch.\n");
	        }
	    }

	    // =========================
	    // Address validation
	    // =========================
	    for (var pair : plaintiff_Details_labels_and_contents.entrySet()) {

	        String key = pair.getKey();
	        String value = pair.getValue();

	        if (key.contains("Address")) {

	            boolean addressMatched =
	                    value.contains(city) &&
	                    value.contains(state) &&
	                    value.contains(addr1) &&
	                    value.contains(addr2) &&
	                    value.contains(zip);

	            Report_Listen.log_print_in_report().log(addressMatched ? Status.PASS : Status.FAIL,
	                    addressMatched
	                            ? "<b>✅ Address Check:</b> Address contains expected fields.<br><b>Actual:</b> " + value
	                            : "<b>❌ Address Check:</b> Address missing expected fields.<br><b>Actual:</b> " + value +
	                              "<br><b>Expected to contain:</b> " + city + ", " + state + ", " + addr1 + ", " + addr2 + ", " + zip
	            );

	            System.out.println(addressMatched
	                    ? "✅ PASS: Address contains expected details."
	                    : "❌ FAIL: Address does NOT contain expected details.");
	            System.out.println("Actual Address: " + value);
	            System.out.println("Expected to contain: " + city + ", " + state + ", " + addr1 + ", " + addr2 + ", " + zip);
	            System.out.println("--------------------------------------------------\n");
	        }
	    }
	}

		
		
		
		
	
	
	
	@Test(dataProvider="Plaintiff_Add_Edit_Combined_data")
	public void Plaintiff_edit_in_case(TreeMap<String,String> Add_data,TreeMap<String,String> Edit_data) throws IOException, InterruptedException{
		
	
		 Application_Locaters p = new Application_Locaters(d);
		 SIde_Menu_Handler sd = new SIde_Menu_Handler();
		 Login_Locaters lg = new Login_Locaters(d);
		 Repeat rp = new Repeat(d);
		 Plaintiff_Locaters pp=new Plaintiff_Locaters(d);
		 
		 plaintiff_label_contents.clear();
		 
		 String Case_id = "CA2600365";
		 
		 String New_First_Name = Edit_data.get("First Name");
		 String New_Middle_Name = Edit_data.get("Middle Name");
		 String New_Last_Name = Edit_data.get("Last Name");
		 String New_Name_Suffix = Edit_data.get("Name Suffix");
		 String New_Email = Edit_data.get("Email");
		 String New_Social_Security_Number = Edit_data.get("Social Security Number");
		 String New_Phone_number = Edit_data.get("Phone number");
		 String New_Date_of_Birth = Edit_data.get("Date of Birth");
		 String New_State = Edit_data.get("State");
		 String New_City = Edit_data.get("City");
		 String New_Zipcode = Edit_data.get("Zip code");
		 String New_Address_line_One = Edit_data.get("Address Line 1");
		 String New_Address_line_Two = Edit_data.get("Address Line 2");
		 
		 
		 int step = 1;
		 
		 
		 Report_Listen.log_print_in_report().log(Status.INFO, """
	             <b>🔹 Scenario Title:</b> Plaintiff Contact Edit in Case – Save & Verify Updated Values
	             """);

	     Report_Listen.log_print_in_report().log(Status.INFO, String.format("""
	             <b>📘 Description:</b> Open an existing case (<b>%s</b>), edit Plaintiff contact details, save, and verify the Contact summary shows the updated values.
	             """, Case_id));

	     Report_Listen.log_print_in_report().log(Status.INFO, String.format("""
	             <b>📥 Input (New Values):</b><br>
	             <b>Phone:</b> %s<br>
	             <b>City/State/Zip:</b> %s / %s / %s<br>
	             <b>Address Line 1:</b> %s<br>
	             <b>Address Line 2:</b> %s
	             """,
	             New_Phone_number, New_City, New_State, New_Zipcode, New_Address_line_One, New_Address_line_Two));

	     Report_Listen.log_print_in_report().log(Status.INFO, """
	             <b>✅ Expected:</b> After saving, the case’s Plaintiff Contact summary should reflect the updated phone and updated address (line1, line2, city, state, zip).
	             """);
		 
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		   WebElement Search = p.Application_search();
		   Search.sendKeys(Case_id);
		   Thread.sleep(1800);
		   WebElement Toast_One = lg.Toast_close_button();
		   Toast_One.click();
		   WebElement Toast_Two;
		   try {
			  Toast_Two = lg.Toast_close_button();
			  }
		   catch(Exception Toast_close){
			      Thread.sleep(800);
				  Toast_Two = lg.Toast_close_button();
				  }
		   Toast_Two.click();
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
		   tab_selector("Contacts",d);
		   p.Law_firm_info_title_text();
		   p.Edit_button().click();
		   p.Edit_details_title_form();
		   Report_Listen.log_print_in_report().log(Status.INFO, String.format("""
		             <b>Step %d:</b> Update Plaintiff Contact details and save
		             <br><b>📘 What is being validated:</b> Edited Plaintiff details should persist after saving.
		             <br><b>✅ Expected:</b> Save should succeed and updated details should appear in the Contact summary.
		             """, (step++)));
		   List<WebElement> inputs = p.form_inputs();
		   for(WebElement field:inputs){
			   rp.Feild_clear(field);
			   }
		   inputs.get(0).sendKeys(New_First_Name);
		   inputs.get(1).sendKeys(New_Middle_Name);
		   inputs.get(2).sendKeys(New_Last_Name);
		   inputs.get(3).sendKeys(New_Name_Suffix);
		   inputs.get(4).sendKeys(New_Phone_number);
		   inputs.get(5).sendKeys(New_Email);
		   //inputs.get(6).sendKeys(New_Date_of_Birth);
		   //p.calender_date_select().click();
		   String entered_ph_number=inputs.get(4).getAttribute("value");
		   inputs.get(7).sendKeys(New_Social_Security_Number);
		   inputs.get(8).sendKeys(New_City);
		   inputs.get(9).sendKeys(New_State);
		   p.plaintiff_dropdown_list();
		   Thread.sleep(800);
		   p.Plaintiff_options().get(0).click(); 
		   inputs.get(10).sendKeys(New_Zipcode);
		   List<WebElement> textArea_areas=pp.text_area_fields();
		   rp.Scroll_to_element(textArea_areas.get(0));
		   rp.Feild_clear(textArea_areas.get(0));
		   textArea_areas.get(0).sendKeys(New_Address_line_One);
		   rp.Feild_clear(textArea_areas.get(1));
		   textArea_areas.get(1).sendKeys(New_Address_line_Two);
		   p.Submit_button().click();
		   Thread.sleep(1500);
		   WebElement Toast = lg.toast();
			try{Toast = lg.toast();
				String toast=Toast.getText().trim();
				System.out.println(toast);
				System.out.println();
				lg.Toast_close_button().click();
				rp.wait_for_invisibility(Toast);
				Report_Listen.log_print_in_report().log(Status.PASS, String.format("""
		                 <b>🟨 Actual:</b> Save completed successfully.
		                 <br><b>📢 System Message:</b> %s
		                 """, toast));}catch(Exception e){
		        Report_Listen.log_print_in_report().log(Status.FAIL, """
                 <b>🟨 Actual:</b> Save confirmation (toast) could not be captured.
                 <br><b>❌ Result:</b> Unable to confirm save outcome from UI feedback.
                 """);
				throw e;} 
			
			
			Report_Listen.log_print_in_report().log(Status.INFO, String.format("""
		             <b>Step %d:</b> Verify updated values in Plaintiff Contact summary (post-save)
		             <br><b>📘 What is being validated:</b> The Contact summary displays updated Phone and Address after saving.
		             <br><b>✅ Expected:</b> Phone should match the saved phone value; Address should contain line1, line2, city, state, zip.
		             """, (step++)));
			
			List<WebElement> contents_post_edit = p.Description_content_items();
			List<WebElement> contents_Labels_edit = p.Description_content_Labels();
		
			for(int k=0;k<5;k++){
				
				String label = contents_Labels_edit.get(k).getText().trim();
				String content = contents_post_edit.get(k).getText().trim();
				plaintiff_label_contents.put(label, content);}
			
			for(Map.Entry<String, String> each_pair:plaintiff_label_contents.entrySet()){
				
				String key = each_pair.getKey().trim();
				if(key.equalsIgnoreCase("PHONE:")){
					String value = each_pair.getValue().trim();
					
					String phoneExtent = String.format("""
					        <b>📞 Phone Verification</b><br>
					        <b>Expected Phone:</b> %s<br>
					        <b>Displayed Phone:</b> %s<br>
					        <b>Result:</b> %s
					        """,
					        entered_ph_number,
					        value,
					        value.contains(entered_ph_number) ? "PASS (Phone updated correctly)" : "FAIL (Phone not updated / not displayed)"
					);

					String phoneConsole = String.format("""
					        [PHONE VERIFICATION]
					        Expected Phone : %s
					        Displayed Phone: %s
					        Result         : %s
					        """,
					        entered_ph_number,
					        value,
					        value.contains(entered_ph_number) ? "PASS (Phone updated correctly)" : "FAIL (Phone not updated / not displayed)"
					);

					Report_Listen.log_print_in_report().log(value.contains(entered_ph_number) ? Status.PASS : Status.FAIL, phoneExtent);
					System.out.println(phoneConsole);
					System.out.println();
}
				
				if(key.equalsIgnoreCase("ADDRESS:")){
					String Address_value = each_pair.getValue().trim();
					
					boolean cityOk   = Address_value.contains(New_City);
				    boolean stateOk  = Address_value.contains(New_State);
				    boolean zipOk    = Address_value.contains(New_Zipcode);
				    boolean line1Ok  = Address_value.contains(New_Address_line_One);
				    boolean line2Ok  = Address_value.contains(New_Address_line_Two);

				    String missingParts =
				            (!line1Ok ? "Address Line 1, " : "") +
				            (!line2Ok ? "Address Line 2, " : "") +
				            (!New_City.isBlank() && !cityOk ? "City, " : "") +
				            (!New_State.isBlank() && !stateOk ? "State, " : "") +
				            (!New_Zipcode.isBlank() && !zipOk ? "Zip, " : "");

				    missingParts = missingParts.endsWith(", ")
				            ? missingParts.substring(0, missingParts.length() - 2)
				            : missingParts;

				    String finalResultMessage =
				            (cityOk && stateOk && zipOk && line1Ok && line2Ok)
				                    ? "PASS (Address updated correctly)"
				                    : ("FAIL (Missing/Not updated: " + missingParts + ")");

				    String addressExtent = String.format("""
				            <b>🏠 Address Verification</b><br>
				            <b>Displayed Address:</b> %s<br><br>

				            <b>Expected Address Should Contain:</b><br>
				            • Address Line 1: %s<br>
				            • Address Line 2: %s<br>
				            • City: %s<br>
				            • State: %s<br>
				            • Zip: %s<br><br>

				            <b>Result:</b> %s
				            """,
				            Address_value,
				            New_Address_line_One,
				            New_Address_line_Two,
				            New_City,
				            New_State,
				            New_Zipcode,
				            finalResultMessage
				    );

				    String addressConsole = String.format("""
				            [ADDRESS VERIFICATION]
				            Displayed Address:
				            %s

				            Expected Address Should Contain:
				            - Address Line 1: %s
				            - Address Line 2: %s
				            - City          : %s
				            - State         : %s
				            - Zip           : %s

				            Result         : %s
				            """,
				            Address_value,
				            New_Address_line_One,
				            New_Address_line_Two,
				            New_City,
				            New_State,
				            New_Zipcode,
				            finalResultMessage
				    );

				    Report_Listen.log_print_in_report().log(
				            (cityOk && stateOk && zipOk && line1Ok && line2Ok) ? Status.PASS : Status.FAIL,
				            addressExtent
				    );

				    System.out.println(addressConsole);
				    System.out.println();}
				
				if (key.equalsIgnoreCase("SSN:")) {

				    String displayedSSN = each_pair.getValue().trim();      // from UI card
				    String expectedSSN  = New_Social_Security_Number.trim(); // from input/test data

				    boolean ssnMatched = displayedSSN.equalsIgnoreCase(expectedSSN);

				    String ssnExtent = String.format("""
				            <b>🪪 SSN Verification</b><br>
				            <b>Expected SSN:</b> %s<br>
				            <b>Displayed SSN:</b> %s<br>
				            <b>Result:</b> %s
				            """,
				            expectedSSN,
				            displayedSSN,
				            ssnMatched ? "PASS (SSN updated correctly)" : "FAIL (SSN mismatch)"
				    );

				    String ssnConsole = String.format("""
				            [SSN VERIFICATION]
				            Expected SSN : %s
				            Displayed SSN: %s
				            Result       : %s
				            """,
				            expectedSSN,
				            displayedSSN,
				            ssnMatched ? "PASS (SSN updated correctly)" : "FAIL (SSN mismatch)"
				    );

				    Report_Listen.log_print_in_report().log(ssnMatched ? Status.PASS : Status.FAIL, ssnExtent);
				    System.out.println(ssnConsole);
				    System.out.println();
				}
				if (key.equalsIgnoreCase("EMAIL:")) {

				    String displayedEmail = each_pair.getValue().trim();  // from UI card
				    String expectedEmail  = New_Email.trim();             // from input/test data

				    boolean emailMatched = displayedEmail.equalsIgnoreCase(expectedEmail);

				    String emailExtent = String.format("""
				            <b>📧 Email Verification</b><br>
				            <b>Expected Email:</b> %s<br>
				            <b>Displayed Email:</b> %s<br>
				            <b>Result:</b> %s
				            """,
				            expectedEmail,
				            displayedEmail,
				            emailMatched ? "PASS (Email updated correctly)" : "FAIL (Email mismatch)"
				    );

				    String emailConsole = String.format("""
				            [EMAIL VERIFICATION]
				            Expected Email : %s
				            Displayed Email: %s
				            Result         : %s
				            """,
				            expectedEmail,
				            displayedEmail,
				            emailMatched ? "PASS (Email updated correctly)" : "FAIL (Email mismatch)"
				    );

				    Report_Listen.log_print_in_report().log(emailMatched ? Status.PASS : Status.FAIL, emailExtent);
				    System.out.println(emailConsole);
				    System.out.println();
				}
              
				String titleText = p.Title_plaintiff_name().getText().trim();
				String cardText  = p.Plaintiff_name_incard().getText().trim();
				String plaintiffNameExtent =
				        (titleText.contains(New_First_Name) && cardText.contains(New_First_Name))
				                ? String.format("""
				                        <b>✅ Plaintiff Name Update – PASS</b><br><br>
				                        <b>Expected First Name:</b> %s<br><br>
				                        <b>Where it was verified:</b><br>
				                        • <b>Title Name:</b> %s<br>
				                        • <b>Plaintiff Card Name:</b> %s<br><br>
				                        <b>Conclusion:</b> Plaintiff name is updated correctly in both Title and Card.
				                        """, New_First_Name, titleText, cardText)
				                : (titleText.contains(New_First_Name) && !cardText.contains(New_First_Name))
				                ? String.format("""
				                        <b>❌ Plaintiff Name Update – FAIL</b><br><br>
				                        <b>Expected First Name:</b> %s<br><br>
				                        <b>Observed:</b><br>
				                        • <b>Title Name:</b> %s ✅ (updated)<br>
				                        • <b>Plaintiff Card Name:</b> %s ❌ (not updated)<br><br>
				                        <b>Conclusion:</b> Title updated, but Plaintiff Card still shows old/incorrect name.
				                        """, New_First_Name, titleText, cardText)
				                : (!titleText.contains(New_First_Name) && cardText.contains(New_First_Name))
				                ? String.format("""
				                        <b>❌ Plaintiff Name Update – FAIL</b><br><br>
				                        <b>Expected First Name:</b> %s<br><br>
				                        <b>Observed:</b><br>
				                        • <b>Title Name:</b> %s ❌ (not updated)<br>
				                        • <b>Plaintiff Card Name:</b> %s ✅ (updated)<br><br>
				                        <b>Conclusion:</b> Card updated, but Title still shows old/incorrect name.
				                        """, New_First_Name, titleText, cardText)
				                : String.format("""
				                        <b>❌ Plaintiff Name Update – FAIL</b><br><br>
				                        <b>Expected First Name:</b> %s<br><br>
				                        <b>Observed:</b><br>
				                        • <b>Title Name:</b> %s ❌ (not updated)<br>
				                        • <b>Plaintiff Card Name:</b> %s ❌ (not updated)<br><br>
				                        <b>Conclusion:</b> Plaintiff name did not update in both Title and Card after saving.
				                        """, New_First_Name, titleText, cardText);

				Report_Listen.log_print_in_report().log(
				        (titleText.contains(New_First_Name) && cardText.contains(New_First_Name)) ? Status.PASS : Status.FAIL,
				        plaintiffNameExtent
				);

				/* =========================
				   CONSOLE VERSION
				   ========================= */
				String plaintiffNameConsole =
				        (titleText.contains(New_First_Name) && cardText.contains(New_First_Name))
				                ? String.format("""
				                        [PLAINTIFF NAME UPDATE – PASS]
				                        Expected First Name : %s

				                        Title Name          : %s
				                        Card Name           : %s

				                        Conclusion          : Updated correctly in both Title and Card.
				                        """, New_First_Name, titleText, cardText)
				                : (titleText.contains(New_First_Name) && !cardText.contains(New_First_Name))
				                ? String.format("""
				                        [PLAINTIFF NAME UPDATE – FAIL]
				                        Expected First Name : %s

				                        Title Name          : %s   (UPDATED ✅)
				                        Card Name           : %s   (NOT UPDATED ❌)

				                        Conclusion          : Title updated, but Card did not update.
				                        """, New_First_Name, titleText, cardText)
				                : (!titleText.contains(New_First_Name) && cardText.contains(New_First_Name))
				                ? String.format("""
				                        [PLAINTIFF NAME UPDATE – FAIL]
				                        Expected First Name : %s

				                        Title Name          : %s   (NOT UPDATED ❌)
				                        Card Name           : %s   (UPDATED ✅)

				                        Conclusion          : Card updated, but Title did not update.
				                        """, New_First_Name, titleText, cardText)
				                : String.format("""
				                        [PLAINTIFF NAME UPDATE – FAIL]
				                        Expected First Name : %s

				                        Title Name          : %s   (NOT UPDATED ❌)
				                        Card Name           : %s   (NOT UPDATED ❌)

				                        Conclusion          : Neither Title nor Card updated after save.
				                        """, New_First_Name, titleText, cardText);

				System.out.println(plaintiffNameConsole);
				System.out.println();}
			
	
	
	
	}
	
	
	
	@DataProvider
	public Object[][] Plaintiff_Add_Edit_Combined_data(){
		
		
		
		
		Object[][] Add_data = plaintiffData();
		Object[][] Edit_data = plaintiff_Edit_data();
		
		
		int n = Math.min(Add_data.length,Edit_data.length);
		Object[][] final_set = new Object[n][2];
		
		for(int i=0;i<n;i++){
			   final_set[i][0] = Add_data[i][0];      
		       final_set[i][1] = Edit_data[i][0]; 
		       
		    }
		    return final_set;
		
		
	}
	
	
	
	
	
	
	@DataProvider
	public Object[][] plaintiff_Edit_data() {

	    TreeMap<String, String> p1 = new TreeMap<>();
	    p1.put("First Name", "Maëline");
	    p1.put("Middle Name", "Joannie");
	    p1.put("Last Name", "Deslauriers");
	    p1.put("Name Suffix", "II");
	    p1.put("Email", "maeline.deslauriers.q7m3@yopmail.com");
	    p1.put("Social Security Number", "912-11-6041");
	    p1.put("Phone number", "4166041739");
	    p1.put("Date of Birth", "07/14/1992");
	    p1.put("State", "New York");
	    p1.put("City", "Toronto");
	    p1.put("Zip code", "10013");
	    p1.put("Address Line 1", "250 Front Street West");
	    p1.put("Address Line 2", "Suite 1208");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Benoît");
	    p2.put("Middle Name", "Rémi");
	    p2.put("Last Name", "Vaillancourt");
	    p2.put("Name Suffix", "Sr");
	    p2.put("Email", "benoit.vaillancourt.n4k8@yopmail.com");
	    p2.put("Social Security Number", "912-12-5142");
	    p2.put("Phone number", "5145142865");
	    p2.put("Date of Birth", "02/03/1988");
	    p2.put("State", "California");
	    p2.put("City", "Montréal");
	    p2.put("Zip code", "94105");
	    p2.put("Address Line 1", "80 Rue Saint-Paul Ouest");
	    p2.put("Address Line 2", "Apt 905");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Océane");
	    p3.put("Middle Name", "Laurianne");
	    p3.put("Last Name", "Boissonneault");
	    p3.put("Name Suffix", "III");
	    p3.put("Email", "oceane.boissonneault.t9v1@yopmail.com");
	    p3.put("Social Security Number", "912-13-7783");
	    p3.put("Phone number", "6047789136");
	    p3.put("Date of Birth", "11/28/1994");
	    p3.put("State", "Washington");
	    p3.put("City", "Vancouver");
	    p3.put("Zip code", "98101");
	    p3.put("Address Line 1", "1055 West Georgia Street");
	    p3.put("Address Line 2", "Unit 1710");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Geneviève");
	    p4.put("Middle Name", "Soline");
	    p4.put("Last Name", "Charbonneau");
	    p4.put("Name Suffix", "Jr");
	    p4.put("Email", "genevieve.charbonneau.r2f6@yopmail.com");
	    p4.put("Social Security Number", "912-14-4384");
	    p4.put("Phone number", "4383907428");
	    p4.put("Date of Birth", "01/19/1990");
	    p4.put("State", "Florida");
	    p4.put("City", "Laval");
	    p4.put("Zip code", "33130");
	    p4.put("Address Line 1", "3035 Boulevard Le Carrefour");
	    p4.put("Address Line 2", "Suite 610");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Étienne");
	    p5.put("Middle Name", "Marc-Antoine");
	    p5.put("Last Name", "Dumouchel");
	    p5.put("Name Suffix", "IV");
	    p5.put("Email", "etienne.dumouchel.p8x2@yopmail.com");
	    p5.put("Social Security Number", "912-15-4035");
	    p5.put("Phone number", "4035876201");
	    p5.put("Date of Birth", "05/08/1991");
	    p5.put("State", "Texas");
	    p5.put("City", "Calgary");
	    p5.put("Zip code", "73301");
	    p5.put("Address Line 1", "600 4 Avenue SW");
	    p5.put("Address Line 2", "Floor 19");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Ariane");
	    p6.put("Middle Name", "Noélie");
	    p6.put("Last Name", "Laforest");
	    p6.put("Name Suffix", "II");
	    p6.put("Email", "ariane.laforest.c6j9@yopmail.com");
	    p6.put("Social Security Number", "912-16-7806");
	    p6.put("Phone number", "7807809457");
	    p6.put("Date of Birth", "09/12/1989");
	    p6.put("State", "Colorado");
	    p6.put("City", "Edmonton");
	    p6.put("Zip code", "80202");
	    p6.put("Address Line 1", "10180 101 Street NW");
	    p6.put("Address Line 2", "Suite 2200");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Raphaëlle");
	    p7.put("Middle Name", "Mireille");
	    p7.put("Last Name", "Beauchemin");
	    p7.put("Name Suffix", "Sr");
	    p7.put("Email", "raphaelle.beauchemin.h3z7@yopmail.com");
	    p7.put("Social Security Number", "912-17-6137");
	    p7.put("Phone number", "6136137842");
	    p7.put("Date of Birth", "12/02/1993");
	    p7.put("State", "Virginia");
	    p7.put("City", "Ottawa");
	    p7.put("Zip code", "23219");
	    p7.put("Address Line 1", "130 Albert Street");
	    p7.put("Address Line 2", "Suite 1505");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Thierry");
	    p8.put("Middle Name", "Pascal");
	    p8.put("Last Name", "Gagnier");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "thierry.gagnier.w5q1@yopmail.com");
	    p8.put("Social Security Number", "912-18-8198");
	    p8.put("Phone number", "8198195063");
	    p8.put("Date of Birth", "03/26/1990");
	    p8.put("State", "Ohio");
	    p8.put("City", "Gatineau");
	    p8.put("Zip code", "45202");
	    p8.put("Address Line 1", "15 Rue de la Reine");
	    p8.put("Address Line 2", "Apt 402");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Éliane");
	    p9.put("Middle Name", "Cléophée");
	    p9.put("Last Name", "Jodoin");
	    p9.put("Name Suffix", "II");
	    p9.put("Email", "eliane.jodoin.k1r4@yopmail.com");
	    p9.put("Social Security Number", "912-19-9059");
	    p9.put("Phone number", "9059051378");
	    p9.put("Date of Birth", "06/17/1989");
	    p9.put("State", "Michigan");
	    p9.put("City", "Mississauga");
	    p9.put("Zip code", "48226");
	    p9.put("Address Line 1", "100 City Centre Drive");
	    p9.put("Address Line 2", "Unit 2102");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Jérémie");
	    p10.put("Middle Name", "Olivier");
	    p10.put("Last Name", "Pellerin");
	    p10.put("Name Suffix", "IV");
	    p10.put("Email", "jeremie.pellerin.v8n2@yopmail.com");
	    p10.put("Social Security Number", "912-20-2890");
	    p10.put("Phone number", "2892896408");
	    p10.put("Date of Birth", "10/21/1992");
	    p10.put("State", "Illinois");
	    p10.put("City", "Hamilton");
	    p10.put("Zip code", "60606");
	    p10.put("Address Line 1", "1 James Street South");
	    p10.put("Address Line 2", "Suite 700");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Noémie");
	    p11.put("Middle Name", "Faustine");
	    p11.put("Last Name", "Nadeau");
	    p11.put("Name Suffix", "II");
	    p11.put("Email", "noemie.nadeau.b9p6@yopmail.com");
	    p11.put("Social Security Number", "912-21-9021");
	    p11.put("Phone number", "9029024187");
	    p11.put("Date of Birth", "11/12/1988");
	    p11.put("State", "Massachusetts");
	    p11.put("City", "Halifax");
	    p11.put("Zip code", "02108");
	    p11.put("Address Line 1", "1791 Barrington Street");
	    p11.put("Address Line 2", "Suite 608");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Camille");
	    p12.put("Middle Name", "Adélaïde");
	    p12.put("Last Name", "Bilodeau");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "camille.bilodeau.s2d8@yopmail.com");
	    p12.put("Social Security Number", "912-22-2501");
	    p12.put("Phone number", "7057059634");
	    p12.put("Date of Birth", "02/16/1993");
	    p12.put("State", "Pennsylvania");
	    p12.put("City", "Sudbury");
	    p12.put("Zip code", "19103");
	    p12.put("Address Line 1", "40 Elm Street");
	    p12.put("Address Line 2", "Apt 12A");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Félix");
	    p13.put("Middle Name", "Armand");
	    p13.put("Last Name", "Lemelin");
	    p13.put("Name Suffix", "III");
	    p13.put("Email", "felix.lemelin.g7t1@yopmail.com");
	    p13.put("Social Security Number", "912-23-2043");
	    p13.put("Phone number", "2042047715");
	    p13.put("Date of Birth", "04/25/1991");
	    p13.put("State", "Minnesota");
	    p13.put("City", "Winnipeg");
	    p13.put("Zip code", "55401");
	    p13.put("Address Line 1", "1 Lombard Place");
	    p13.put("Address Line 2", "Suite 905");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Élodiane");
	    p14.put("Middle Name", "Rosalie");
	    p14.put("Last Name", "Trempe");
	    p14.put("Name Suffix", "Sr");
	    p14.put("Email", "elodiane.trempe.m4y7@yopmail.com");
	    p14.put("Social Security Number", "912-24-2364");
	    p14.put("Phone number", "2362365089");
	    p14.put("Date of Birth", "01/06/1994");
	    p14.put("State", "Oregon");
	    p14.put("City", "Surrey");
	    p14.put("Zip code", "97205");
	    p14.put("Address Line 1", "13665 104 Avenue");
	    p14.put("Address Line 2", "Unit 1804");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Laurence");
	    p15.put("Middle Name", "Séverine");
	    p15.put("Last Name", "Bourassa");
	    p15.put("Name Suffix", "IV");
	    p15.put("Email", "laurence.bourassa.z8k2@yopmail.com");
	    p15.put("Social Security Number", "912-25-2505");
	    p15.put("Phone number", "2502506912");
	    p15.put("Date of Birth", "09/02/1989");
	    p15.put("State", "Washington DC");
	    p15.put("City", "Victoria");
	    p15.put("Zip code", "20001");
	    p15.put("Address Line 1", "777 Fort Street");
	    p15.put("Address Line 2", "Suite 410");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Mathis");
	    p16.put("Middle Name", "Éloi");
	    p16.put("Last Name", "Rivard");
	    p16.put("Name Suffix", "II");
	    p16.put("Email", "mathis.rivard.u6c1@yopmail.com");
	    p16.put("Social Security Number", "912-26-3066");
	    p16.put("Phone number", "3063061845");
	    p16.put("Date of Birth", "03/15/1990");
	    p16.put("State", "Nevada");
	    p16.put("City", "Saskatoon");
	    p16.put("Zip code", "89109");
	    p16.put("Address Line 1", "2400 13th Avenue");
	    p16.put("Address Line 2", "Suite 610");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Apolline");
	    p17.put("Middle Name", "Marjolaine");
	    p17.put("Last Name", "Couturier");
	    p17.put("Name Suffix", "Jr");
	    p17.put("Email", "apolline.couturier.d5n9@yopmail.com");
	    p17.put("Social Security Number", "912-27-4181");
	    p17.put("Phone number", "4184187350");
	    p17.put("Date of Birth", "12/20/1992");
	    p17.put("State", "Maine");
	    p17.put("City", "Québec City");
	    p17.put("Zip code", "04101");
	    p17.put("Address Line 1", "2828 Boulevard Laurier");
	    p17.put("Address Line 2", "Suite 1202");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Émery");
	    p18.put("Middle Name", "Théodore");
	    p18.put("Last Name", "Sévigny");
	    p18.put("Name Suffix", "III");
	    p18.put("Email", "emery.sevigny.k9h4@yopmail.com");
	    p18.put("Social Security Number", "912-28-5067");
	    p18.put("Phone number", "5875879246");
	    p18.put("Date of Birth", "06/21/1989");
	    p18.put("State", "Arizona");
	    p18.put("City", "Red Deer");
	    p18.put("Zip code", "85004");
	    p18.put("Address Line 1", "4900 49 Street");
	    p18.put("Address Line 2", "Unit 10C");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Bérénice");
	    p19.put("Middle Name", "Édith");
	    p19.put("Last Name", "Goulet");
	    p19.put("Name Suffix", "Sr");
	    p19.put("Email", "berenice.goulet.r7v2@yopmail.com");
	    p19.put("Social Security Number", "912-29-7098");
	    p19.put("Phone number", "7787783054");
	    p19.put("Date of Birth", "05/07/1994");
	    p19.put("State", "Utah");
	    p19.put("City", "Burnaby");
	    p19.put("Zip code", "84101");
	    p19.put("Address Line 1", "4500 Kingsway");
	    p19.put("Address Line 2", "Suite 910");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Loïc");
	    p20.put("Middle Name", "Gaspard");
	    p20.put("Last Name", "Ducharme");
	    p20.put("Name Suffix", "IV");
	    p20.put("Email", "loic.ducharme.p3w8@yopmail.com");
	    p20.put("Social Security Number", "912-30-6131");
	    p20.put("Phone number", "6476478821");
	    p20.put("Date of Birth", "10/09/1988");
	    p20.put("State", "New Jersey");
	    p20.put("City", "Brampton");
	    p20.put("Zip code", "07030");
	    p20.put("Address Line 1", "1 Queen Street East");
	    p20.put("Address Line 2", "Suite 600");

	    return new Object[][]{
	        {p1}, {p2}, {p3}, {p4}, {p5},
	        {p6}, {p7}, {p8}, {p9}, {p10},
	        {p11}, {p12}, {p13}, {p14}, {p15},
	        {p16}, {p17}, {p18}, {p19}, {p20} 
	    };
	}

	
	@DataProvider
	public Object[][] plaintiffData() {

	    TreeMap<String, String> p1 = new TreeMap<>();
	    p1.put("First Name", "Holden");
	    p1.put("Middle Name", "Everett");
	    p1.put("Last Name", "Glassford");
	    p1.put("Name Suffix", "II");
	    p1.put("Email", "pltf.glassford.holden.7p3m9q.2k6v@yopmail.com");
	    p1.put("Social Security Number", "741-62-5038");
	    p1.put("Phone number", "9196403817");
	    p1.put("Date of Birth", "02/14/1991");
	    p1.put("State", "North Carolina");
	    p1.put("City", "Raleigh");
	    p1.put("Zip code", "27601");
	    p1.put("Address Line 1", "230 Fayetteville St");
	    p1.put("Address Line 2", "Unit 1711");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Marston");
	    p2.put("Middle Name", "Elias");
	    p2.put("Last Name", "Cavendish");
	    p2.put("Name Suffix", "Jr");
	    p2.put("Email", "pltf.cavendish.marston.4v8a1m.9q2n@yopmail.com");
	    p2.put("Social Security Number", "752-14-6803");
	    p2.put("Phone number", "4109021865");
	    p2.put("Date of Birth", "10/03/1993");
	    p2.put("State", "Maryland");
	    p2.put("City", "Baltimore");
	    p2.put("Zip code", "21202");
	    p2.put("Address Line 1", "12 Light St");
	    p2.put("Address Line 2", "Suite 1216");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Corinne");
	    p3.put("Middle Name", "Matilda");
	    p3.put("Last Name", "Haverly");
	    p3.put("Name Suffix", "III");
	    p3.put("Email", "pltf.haverly.corinne.6h2m7k.1p9r@yopmail.com");
	    p3.put("Social Security Number", "764-90-2175");
	    p3.put("Phone number", "6172805314");
	    p3.put("Date of Birth", "06/27/1989");
	    p3.put("State", "Massachusetts");
	    p3.put("City", "Cambridge");
	    p3.put("Zip code", "02139");
	    p3.put("Address Line 1", "3 Cambridge Center");
	    p3.put("Address Line 2", "Apt 11D");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Bennett");
	    p4.put("Middle Name", "Quincy");
	    p4.put("Last Name", "Ashbourne");
	    p4.put("Name Suffix", "Sr");
	    p4.put("Email", "pltf.ashbourne.bennett.8k1p4m.7t2n@yopmail.com");
	    p4.put("Social Security Number", "775-33-9406");
	    p4.put("Phone number", "5037104682");
	    p4.put("Date of Birth", "01/20/1990");
	    p4.put("State", "Oregon");
	    p4.put("City", "Portland");
	    p4.put("Zip code", "97204");
	    p4.put("Address Line 1", "113 SW 5th Ave");
	    p4.put("Address Line 2", "Suite 1609");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Harper");
	    p5.put("Middle Name", "Jocelyn");
	    p5.put("Last Name", "Morringate");
	    p5.put("Name Suffix", "IV");
	    p5.put("Email", "pltf.morringate.harper.2m7q9v.5k1p@yopmail.com");
	    p5.put("Social Security Number", "786-41-2907");
	    p5.put("Phone number", "2817046219");
	    p5.put("Date of Birth", "07/02/1992");
	    p5.put("State", "Texas");
	    p5.put("City", "Houston");
	    p5.put("Zip code", "77002");
	    p5.put("Address Line 1", "1003 McKinney St");
	    p5.put("Address Line 2", "Unit 2103");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Declan");
	    p6.put("Middle Name", "Rowan");
	    p6.put("Last Name", "Kinsleigh");
	    p6.put("Name Suffix", "II");
	    p6.put("Email", "pltf.kinsleigh.declan.9n1t3p.6r1m@yopmail.com");
	    p6.put("Social Security Number", "797-05-6182");
	    p6.put("Phone number", "7029301476");
	    p6.put("Date of Birth", "12/11/1988");
	    p6.put("State", "Nevada");
	    p6.put("City", "Las Vegas");
	    p6.put("Zip code", "89101");
	    p6.put("Address Line 1", "203 S Las Vegas Blvd");
	    p6.put("Address Line 2", "Apt 1406");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Amina");
	    p7.put("Middle Name", "Sana");
	    p7.put("Last Name", "Rahbourne");
	    p7.put("Name Suffix", "Jr");
	    p7.put("Email", "pltf.rahbourne.amina.0z6d8k.3m7q@yopmail.com");
	    p7.put("Social Security Number", "708-57-3916");
	    p7.put("Phone number", "3136429058");
	    p7.put("Date of Birth", "09/13/1994");
	    p7.put("State", "Michigan");
	    p7.put("City", "Detroit");
	    p7.put("Zip code", "48226");
	    p7.put("Address Line 1", "110 Renaissance Center");
	    p7.put("Address Line 2", "Suite 1804");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Rosalind");
	    p8.put("Middle Name", "Claire");
	    p8.put("Last Name", "Denwick");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "pltf.denwick.rosalind.4q8v1m.7k2p@yopmail.com");
	    p8.put("Social Security Number", "719-06-8421");
	    p8.put("Phone number", "6124087395");
	    p8.put("Date of Birth", "02/03/1991");
	    p8.put("State", "Minnesota");
	    p8.put("City", "Minneapolis");
	    p8.put("Zip code", "55402");
	    p8.put("Address Line 1", "122 S 6th St");
	    p8.put("Address Line 2", "Unit 1902");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Eamon");
	    p9.put("Middle Name", "Cormac");
	    p9.put("Last Name", "Keystone");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "pltf.keystone.eamon.6p8v2m.1t9c@yopmail.com");
	    p9.put("Social Security Number", "723-41-9086");
	    p9.put("Phone number", "4806094721");
	    p9.put("Date of Birth", "05/18/1990");
	    p9.put("State", "Arizona");
	    p9.put("City", "Phoenix");
	    p9.put("Zip code", "85004");
	    p9.put("Address Line 1", "4 N Central Ave");
	    p9.put("Address Line 2", "Suite 1509");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Maeve");
	    p10.put("Middle Name", "Sabina");
	    p10.put("Last Name", "Theron");
	    p10.put("Name Suffix", "IV");
	    p10.put("Email", "pltf.theron.maeve.1m4z7k.9q2n@yopmail.com");
	    p10.put("Social Security Number", "734-22-5169");
	    p10.put("Phone number", "9047816532");
	    p10.put("Date of Birth", "03/28/1992");
	    p10.put("State", "Florida");
	    p10.put("City", "Jacksonville");
	    p10.put("Zip code", "32202");
	    p10.put("Address Line 1", "60 N Laura St");
	    p10.put("Address Line 2", "Apt 1206");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Talia");
	    p11.put("Middle Name", "Genevieve");
	    p11.put("Last Name", "Kawson");
	    p11.put("Name Suffix", "II");
	    p11.put("Email", "pltf.kawson.talia.7j0v2m.5q9r@yopmail.com");
	    p11.put("Social Security Number", "745-79-2034");
	    p11.put("Phone number", "7206409187");
	    p11.put("Date of Birth", "08/24/1989");
	    p11.put("State", "Colorado");
	    p11.put("City", "Denver");
	    p11.put("Zip code", "80202");
	    p11.put("Address Line 1", "1702 Lincoln St");
	    p11.put("Address Line 2", "Suite 1908");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Julian");
	    p12.put("Middle Name", "Bastien");
	    p12.put("Last Name", "Laford");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "pltf.laford.julian.4v8a9k.2m7q@yopmail.com");
	    p12.put("Social Security Number", "756-18-7942");
	    p12.put("Phone number", "4158602749");
	    p12.put("Date of Birth", "10/09/1993");
	    p12.put("State", "California");
	    p12.put("City", "San Francisco");
	    p12.put("Zip code", "94105");
	    p12.put("Address Line 1", "3 Market St");
	    p12.put("Address Line 2", "Suite 909");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Mirella");
	    p13.put("Middle Name", "Claudine");
	    p13.put("Last Name", "Beaulieux");
	    p13.put("Name Suffix", "III");
	    p13.put("Email", "pltf.beaulieux.mirella.6p3x1t.8k2v@yopmail.com");
	    p13.put("Social Security Number", "767-40-9158");
	    p13.put("Phone number", "4016905124");
	    p13.put("Date of Birth", "02/07/1991");
	    p13.put("State", "Rhode Island");
	    p13.put("City", "Providence");
	    p13.put("Zip code", "02903");
	    p13.put("Address Line 1", "12 Dorrance St");
	    p13.put("Address Line 2", "Unit 1204");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Finley");
	    p14.put("Middle Name", "Eileen");
	    p14.put("Last Name", "Carmick");
	    p14.put("Name Suffix", "Sr");
	    p14.put("Email", "pltf.carmick.finley.2n9t6k.4m7q@yopmail.com");
	    p14.put("Social Security Number", "778-29-5604");
	    p14.put("Phone number", "8039702146");
	    p14.put("Date of Birth", "05/12/1990");
	    p14.put("State", "South Carolina");
	    p14.put("City", "Charleston");
	    p14.put("Zip code", "29401");
	    p14.put("Address Line 1", "30 Broad St");
	    p14.put("Address Line 2", "Apt 7A");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Darian");
	    p15.put("Middle Name", "Navpreet");
	    p15.put("Last Name", "Gilmore");
	    p15.put("Name Suffix", "IV");
	    p15.put("Email", "pltf.gilmore.darian.8q1k2m.6v9p@yopmail.com");
	    p15.put("Social Security Number", "789-70-4126");
	    p15.put("Phone number", "9016407328");
	    p15.put("Date of Birth", "09/06/1992");
	    p15.put("State", "Tennessee");
	    p15.put("City", "Nashville");
	    p15.put("Zip code", "37219");
	    p15.put("Address Line 1", "430 Church St");
	    p15.put("Address Line 2", "Suite 809");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Edith");
	    p16.put("Middle Name", "Solene");
	    p16.put("Last Name", "Charton");
	    p16.put("Name Suffix", "II");
	    p16.put("Email", "pltf.charton.edith.0r7d4m.8k2v@yopmail.com");
	    p16.put("Social Security Number", "790-12-6845");
	    p16.put("Phone number", "6097018836");
	    p16.put("Date of Birth", "01/17/1988");
	    p16.put("State", "New Jersey");
	    p16.put("City", "Jersey City");
	    p16.put("Zip code", "07302");
	    p16.put("Address Line 1", "28 Columbus Dr");
	    p16.put("Address Line 2", "Apt 1211");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Taliah");
	    p17.put("Middle Name", "Inuinnaq");
	    p17.put("Last Name", "Qitson");
	    p17.put("Name Suffix", "Jr");
	    p17.put("Email", "pltf.qitson.taliah.5m9x2q.7k1p@yopmail.com");
	    p17.put("Social Security Number", "701-45-9187");
	    p17.put("Phone number", "9076405291");
	    p17.put("Date of Birth", "12/04/1994");
	    p17.put("State", "Alaska");
	    p17.put("City", "Anchorage");
	    p17.put("Zip code", "99501");
	    p17.put("Address Line 1", "705 W 8th Ave");
	    p17.put("Address Line 2", "Suite 512");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Reagan");
	    p18.put("Middle Name", "Laurier");
	    p18.put("Last Name", "Vermeer");
	    p18.put("Name Suffix", "III");
	    p18.put("Email", "pltf.vermeer.reagan.3z8v6m.1t9c@yopmail.com");
	    p18.put("Social Security Number", "712-66-5309");
	    p18.put("Phone number", "8164609352");
	    p18.put("Date of Birth", "07/09/1989");
	    p18.put("State", "Missouri");
	    p18.put("City", "Kansas City");
	    p18.put("Zip code", "64106");
	    p18.put("Address Line 1", "1104 Main St");
	    p18.put("Address Line 2", "Unit 1207");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Roisin");
	    p19.put("Middle Name", "Deirdre");
	    p19.put("Last Name", "Quenby");
	    p19.put("Name Suffix", "Sr");
	    p19.put("Email", "pltf.quenby.roisin.1k4q8m.6v9p@yopmail.com");
	    p19.put("Social Security Number", "723-58-1047");
	    p19.put("Phone number", "2256409183");
	    p19.put("Date of Birth", "03/03/1990");
	    p19.put("State", "Louisiana");
	    p19.put("City", "Baton Rouge");
	    p19.put("Zip code", "70801");
	    p19.put("Address Line 1", "210 Laurel St");
	    p19.put("Address Line 2", "Suite 1806");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Marlis");
	    p20.put("Middle Name", "Anabelle");
	    p20.put("Last Name", "Gravelton");
	    p20.put("Name Suffix", "IV");
	    p20.put("Email", "pltf.gravelton.marlis.9p0m4q.2n7t@yopmail.com");
	    p20.put("Social Security Number", "734-09-6812");
	    p20.put("Phone number", "6027049186");
	    p20.put("Date of Birth", "10/21/1992");
	    p20.put("State", "Arizona");
	    p20.put("City", "Tempe");
	    p20.put("Zip code", "85281");
	    p20.put("Address Line 1", "80 E Rio Salado Pkwy");
	    p20.put("Address Line 2", "Apt 1409");
	    // ---- 21 to 50 (fresh new names + ids) ----

	    TreeMap<String, String> p21 = new TreeMap<>();
	    p21.put("First Name", "Ulwin");
	    p21.put("Middle Name", "Viktor");
	    p21.put("Last Name", "Himmelgrove");
	    p21.put("Name Suffix", "II");
	    p21.put("Email", "ulwin.himmelgrove@mailto.plus");
	    p21.put("Social Security Number", "950-31-0521");
	    p21.put("Phone number", "617-555-4521");
	    p21.put("Date of Birth", "02/10/1993");
	    p21.put("State", "Massachusetts");
	    p21.put("Zip code", "02110");
	    p21.put("Address Line 1", "101 Federal St");
	    p21.put("Address Line 2", "Suite 420");

	    TreeMap<String, String> p22 = new TreeMap<>();
	    p22.put("First Name", "Vaughan");
	    p22.put("Middle Name", "Willem");
	    p22.put("Last Name", "Ziegelcroft");
	    p22.put("Name Suffix", "Sr");
	    p22.put("Email", "vaughan.ziegelcroft@mailto.plus");
	    p22.put("Social Security Number", "950-32-0522");
	    p22.put("Phone number", "303-555-4522");
	    p22.put("Date of Birth", "12/22/1987");
	    p22.put("State", "Colorado");
	    p22.put("Zip code", "80203");
	    p22.put("Address Line 1", "900 Grant St");
	    p22.put("Address Line 2", "Apt 4A");

	    TreeMap<String, String> p23 = new TreeMap<>();
	    p23.put("First Name", "Wystan");
	    p23.put("Middle Name", "Xavier");
	    p23.put("Last Name", "Vogelspring");
	    p23.put("Name Suffix", "III");
	    p23.put("Email", "wystan.vogelspring@mailto.plus");
	    p23.put("Social Security Number", "950-33-0523");
	    p23.put("Phone number", "214-555-4523");
	    p23.put("Date of Birth", "06/05/1991");
	    p23.put("State", "Texas");
	    p23.put("Zip code", "75202");
	    p23.put("Address Line 1", "150 N Pearl St");
	    p23.put("Address Line 2", "Unit 10C");

	    TreeMap<String, String> p24 = new TreeMap<>();
	    p24.put("First Name", "Xeno");
	    p24.put("Middle Name", "Yann");
	    p24.put("Last Name", "Schlotterridge");
	    p24.put("Name Suffix", "Jr");
	    p24.put("Email", "xeno.schlotterridge@mailto.plus");
	    p24.put("Social Security Number", "950-34-0524");
	    p24.put("Phone number", "312-555-4524");
	    p24.put("Date of Birth", "09/09/1990");
	    p24.put("State", "Illinois");
	    p24.put("Zip code", "60606");
	    p24.put("Address Line 1", "233 S Wacker Dr");
	    p24.put("Address Line 2", "Suite 800");

	    TreeMap<String, String> p25 = new TreeMap<>();
	    p25.put("First Name", "Yorick");
	    p25.put("Middle Name", "Zeno");
	    p25.put("Last Name", "Kreuzhaven");
	    p25.put("Name Suffix", "II");
	    p25.put("Email", "yorick.kreuzhaven@mailto.plus");
	    p25.put("Social Security Number", "950-35-0525");
	    p25.put("Phone number", "317-555-4525");
	    p25.put("Date of Birth", "02/02/1994");
	    p25.put("State", "Indiana");
	    p25.put("Zip code", "46202");
	    p25.put("Address Line 1", "1 N Capitol Ave");
	    p25.put("Address Line 2", "Apt 7D");

	    TreeMap<String, String> p26 = new TreeMap<>();
	    p26.put("First Name", "Zephyr");
	    p26.put("Middle Name", "Aldo");
	    p26.put("Last Name", "Brennfield");
	    p26.put("Name Suffix", "Sr");
	    p26.put("Email", "zephyr.brennfield@mailto.plus");
	    p26.put("Social Security Number", "950-36-0526");
	    p26.put("Phone number", "206-555-4526");
	    p26.put("Date of Birth", "10/14/1988");
	    p26.put("State", "Washington");
	    p26.put("Zip code", "98104");
	    p26.put("Address Line 1", "700 5th Ave");
	    p26.put("Address Line 2", "Floor 9");

	    TreeMap<String, String> p27 = new TreeMap<>();
	    p27.put("First Name", "Aldric");
	    p27.put("Middle Name", "Bram");
	    p27.put("Last Name", "Schneeridge");
	    p27.put("Name Suffix", "III");
	    p27.put("Email", "aldric.schneeridge@mailto.plus");
	    p27.put("Social Security Number", "950-37-0527");
	    p27.put("Phone number", "404-555-4527");
	    p27.put("Date of Birth", "08/08/1991");
	    p27.put("State", "Georgia");
	    p27.put("Zip code", "30308");
	    p27.put("Address Line 1", "800 Peachtree St NE");
	    p27.put("Address Line 2", "Apt 5B");

	    TreeMap<String, String> p28 = new TreeMap<>();
	    p28.put("First Name", "Briar");
	    p28.put("Middle Name", "Corin");
	    p28.put("Last Name", "Kesselwyn");
	    p28.put("Name Suffix", "Jr");
	    p28.put("Email", "briar.kesselwyn@mailto.plus");
	    p28.put("Social Security Number", "950-38-0528");
	    p28.put("Phone number", "702-555-4528");
	    p28.put("Date of Birth", "01/01/1993");
	    p28.put("State", "Nevada");
	    p28.put("Zip code", "89109");
	    p28.put("Address Line 1", "3555 S Las Vegas Blvd");
	    p28.put("Address Line 2", "Unit 18A");

	    TreeMap<String, String> p29 = new TreeMap<>();
	    p29.put("First Name", "Cyran");
	    p29.put("Middle Name", "Dane");
	    p29.put("Last Name", "Brandewald");
	    p29.put("Name Suffix", "II");
	    p29.put("Email", "cyran.brandewald@mailto.plus");
	    p29.put("Social Security Number", "950-39-0529");
	    p29.put("Phone number", "615-555-4529");
	    p29.put("Date of Birth", "06/06/1992");
	    p29.put("State", "Tennessee");
	    p29.put("Zip code", "37203");
	    p29.put("Address Line 1", "1200 Broadway");
	    p29.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p30 = new TreeMap<>();
	    p30.put("First Name", "Dario");
	    p30.put("Middle Name", "Elias");
	    p30.put("Last Name", "Hartmere");
	    p30.put("Name Suffix", "Sr");
	    p30.put("Email", "dario.hartmere@mailto.plus");
	    p30.put("Social Security Number", "950-40-0530");
	    p30.put("Phone number", "801-555-4530");
	    p30.put("Date of Birth", "12/12/1987");
	    p30.put("State", "Utah");
	    p30.put("Zip code", "84101");
	    p30.put("Address Line 1", "100 S Main St");
	    p30.put("Address Line 2", "Suite 600");

	    TreeMap<String, String> p31 = new TreeMap<>();
	    p31.put("First Name", "Elwood");
	    p31.put("Middle Name", "Fionn");
	    p31.put("Last Name", "Kronenvail");
	    p31.put("Name Suffix", "III");
	    p31.put("Email", "elwood.kronenvail@mailto.plus");
	    p31.put("Social Security Number", "950-41-0531");
	    p31.put("Phone number", "407-555-4531");
	    p31.put("Date of Birth", "09/20/1990");
	    p31.put("State", "Florida");
	    p31.put("Zip code", "32801");
	    p31.put("Address Line 1", "100 S Orange Ave");
	    p31.put("Address Line 2", "Unit 18");

	    TreeMap<String, String> p32 = new TreeMap<>();
	    p32.put("First Name", "Falk");
	    p32.put("Middle Name", "Gustaf");
	    p32.put("Last Name", "Schwarzridge");
	    p32.put("Name Suffix", "Jr");
	    p32.put("Email", "falk.schwarzridge@mailto.plus");
	    p32.put("Social Security Number", "950-42-0532");
	    p32.put("Phone number", "415-555-4532");
	    p32.put("Date of Birth", "01/27/1992");
	    p32.put("State", "California");
	    p32.put("Zip code", "94103");
	    p32.put("Address Line 1", "50 3rd St");
	    p32.put("Address Line 2", "Apt 6");

	    TreeMap<String, String> p33 = new TreeMap<>();
	    p33.put("First Name", "Garrick");
	    p33.put("Middle Name", "Hale");
	    p33.put("Last Name", "Fichtenmoor");
	    p33.put("Name Suffix", "II");
	    p33.put("Email", "garrick.fichtenmoor@mailto.plus");
	    p33.put("Social Security Number", "950-43-0533");
	    p33.put("Phone number", "503-555-4533");
	    p33.put("Date of Birth", "03/03/1991");
	    p33.put("State", "Oregon");
	    p33.put("Zip code", "97204");
	    p33.put("Address Line 1", "700 SW 5th Ave");
	    p33.put("Address Line 2", "Suite 410");

	    TreeMap<String, String> p34 = new TreeMap<>();
	    p34.put("First Name", "Halvor");
	    p34.put("Middle Name", "Ilan");
	    p34.put("Last Name", "Sonnenbrook");
	    p34.put("Name Suffix", "Sr");
	    p34.put("Email", "halvor.sonnenbrook@mailto.plus");
	    p34.put("Social Security Number", "950-44-0534");
	    p34.put("Phone number", "609-555-4534");
	    p34.put("Date of Birth", "12/01/1989");
	    p34.put("State", "New Jersey");
	    p34.put("Zip code", "08608");
	    p34.put("Address Line 1", "120 E State St");
	    p34.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p35 = new TreeMap<>();
	    p35.put("First Name", "Isen");
	    p35.put("Middle Name", "Jasper");
	    p35.put("Last Name", "Wintercoil");
	    p35.put("Name Suffix", "III");
	    p35.put("Email", "isen.wintercoil@mailto.plus");
	    p35.put("Social Security Number", "950-45-0535");
	    p35.put("Phone number", "602-555-4535");
	    p35.put("Date of Birth", "06/18/1990");
	    p35.put("State", "Arizona");
	    p35.put("Zip code", "85003");
	    p35.put("Address Line 1", "100 W Washington St");
	    p35.put("Address Line 2", "Apt 12");

	    TreeMap<String, String> p36 = new TreeMap<>();
	    p36.put("First Name", "Jareth");
	    p36.put("Middle Name", "Kieran");
	    p36.put("Last Name", "Bergstrum");
	    p36.put("Name Suffix", "II");
	    p36.put("Email", "jareth.bergstrum@mailto.plus");
	    p36.put("Social Security Number", "950-46-0536");
	    p36.put("Phone number", "206-555-4536");
	    p36.put("Date of Birth", "10/10/1992");
	    p36.put("State", "Washington");
	    p36.put("Zip code", "98109");
	    p36.put("Address Line 1", "500 Westlake Ave N");
	    p36.put("Address Line 2", "Unit 7");

	    TreeMap<String, String> p37 = new TreeMap<>();
	    p37.put("First Name", "Kellan");
	    p37.put("Middle Name", "Lucan");
	    p37.put("Last Name", "Rosenwirth");
	    p37.put("Name Suffix", "Jr");
	    p37.put("Email", "kellan.rosenwirth@mailto.plus");
	    p37.put("Social Security Number", "950-47-0537");
	    p37.put("Phone number", "614-555-4537");
	    p37.put("Date of Birth", "01/05/1994");
	    p37.put("State", "Ohio");
	    p37.put("Zip code", "43215");
	    p37.put("Address Line 1", "150 N High St");
	    p37.put("Address Line 2", "Suite 220");

	    TreeMap<String, String> p38 = new TreeMap<>();
	    p38.put("First Name", "Lorian");
	    p38.put("Middle Name", "Milo");
	    p38.put("Last Name", "Falkenwick");
	    p38.put("Name Suffix", "III");
	    p38.put("Email", "lorian.falkenwick@mailto.plus");
	    p38.put("Social Security Number", "950-48-0538");
	    p38.put("Phone number", "312-555-4538");
	    p38.put("Date of Birth", "09/09/1991");
	    p38.put("State", "Illinois");
	    p38.put("Zip code", "60607");
	    p38.put("Address Line 1", "900 W Randolph St");
	    p38.put("Address Line 2", "Unit 14");

	    TreeMap<String, String> p39 = new TreeMap<>();
	    p39.put("First Name", "Maddox");
	    p39.put("Middle Name", "Nico");
	    p39.put("Last Name", "Eberhollow");
	    p39.put("Name Suffix", "II");
	    p39.put("Email", "maddox.eberhollow@mailto.plus");
	    p39.put("Social Security Number", "950-49-0539");
	    p39.put("Phone number", "313-555-4539");
	    p39.put("Date of Birth", "12/28/1988");
	    p39.put("State", "Michigan");
	    p39.put("Zip code", "48226");
	    p39.put("Address Line 1", "500 Woodward Ave");
	    p39.put("Address Line 2", "Floor 10");

	    TreeMap<String, String> p40 = new TreeMap<>();
	    p40.put("First Name", "Nerys");
	    p40.put("Middle Name", "Otis");
	    p40.put("Last Name", "Hochfeld");
	    p40.put("Name Suffix", "Sr");
	    p40.put("Email", "nerys.hochfeld@mailto.plus");
	    p40.put("Social Security Number", "950-50-0540");
	    p40.put("Phone number", "603-555-4540");
	    p40.put("Date of Birth", "04/24/1990");
	    p40.put("State", "New Hampshire");
	    p40.put("Zip code", "03101");
	    p40.put("Address Line 1", "1000 Elm St");
	    p40.put("Address Line 2", "Apt 2");

	    TreeMap<String, String> p41 = new TreeMap<>();
	    p41.put("First Name", "Orwyn");
	    p41.put("Middle Name", "Pax");
	    p41.put("Last Name", "Schwerdtvale");
	    p41.put("Name Suffix", "III");
	    p41.put("Email", "orwyn.schwerdtvale@mailto.plus");
	    p41.put("Social Security Number", "950-51-0541");
	    p41.put("Phone number", "702-555-4541");
	    p41.put("Date of Birth", "11/21/1991");
	    p41.put("State", "Nevada");
	    p41.put("Zip code", "89103");
	    p41.put("Address Line 1", "500 S Decatur Blvd");
	    p41.put("Address Line 2", "Unit 4B");

	    TreeMap<String, String> p42 = new TreeMap<>();
	    p42.put("First Name", "Phelan");
	    p42.put("Middle Name", "Quade");
	    p42.put("Last Name", "Hirschmoor");
	    p42.put("Name Suffix", "Jr");
	    p42.put("Email", "phelan.hirschmoor@mailto.plus");
	    p42.put("Social Security Number", "950-52-0542");
	    p42.put("Phone number", "317-555-4542");
	    p42.put("Date of Birth", "01/19/1993");
	    p42.put("State", "Indiana");
	    p42.put("Zip code", "46225");
	    p42.put("Address Line 1", "50 S Capitol Ave");
	    p42.put("Address Line 2", "Suite 300");

	    TreeMap<String, String> p43 = new TreeMap<>();
	    p43.put("First Name", "Quillan");
	    p43.put("Middle Name", "Rafe");
	    p43.put("Last Name", "Neubergin");
	    p43.put("Name Suffix", "II");
	    p43.put("Email", "quillan.neubergin@mailto.plus");
	    p43.put("Social Security Number", "950-53-0543");
	    p43.put("Phone number", "615-555-4543");
	    p43.put("Date of Birth", "07/08/1994");
	    p43.put("State", "Tennessee");
	    p43.put("Zip code", "37219");
	    p43.put("Address Line 1", "250 Church St");
	    p43.put("Address Line 2", "Apt 14B");

	    TreeMap<String, String> p44 = new TreeMap<>();
	    p44.put("First Name", "Riven");
	    p44.put("Middle Name", "Simeon");
	    p44.put("Last Name", "Kornbrook");
	    p44.put("Name Suffix", "Sr");
	    p44.put("Email", "riven.kornbrook@mailto.plus");
	    p44.put("Social Security Number", "950-54-0544");
	    p44.put("Phone number", "305-555-4544");
	    p44.put("Date of Birth", "02/13/1987");
	    p44.put("State", "Florida");
	    p44.put("Zip code", "33130");
	    p44.put("Address Line 1", "200 Brickell Ave");
	    p44.put("Address Line 2", "Apt 9A");

	    TreeMap<String, String> p45 = new TreeMap<>();
	    p45.put("First Name", "Silas");
	    p45.put("Middle Name", "Tomas");
	    p45.put("Last Name", "Schwanewick");
	    p45.put("Name Suffix", "III");
	    p45.put("Email", "silas.schwanewick@mailto.plus");
	    p45.put("Social Security Number", "950-55-0545");
	    p45.put("Phone number", "206-555-4545");
	    p45.put("Date of Birth", "03/14/1990");
	    p45.put("State", "Washington");
	    p45.put("Zip code", "98121");
	    p45.put("Address Line 1", "2121 6th Ave");
	    p45.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p46 = new TreeMap<>();
	    p46.put("First Name", "Tavian");
	    p46.put("Middle Name", "Ulmer");
	    p46.put("Last Name", "Tannhaevik");
	    p46.put("Name Suffix", "Jr");
	    p46.put("Email", "tavian.tannhaevik@mailto.plus");
	    p46.put("Social Security Number", "950-56-0546");
	    p46.put("Phone number", "404-555-4546");
	    p46.put("Date of Birth", "12/05/1991");
	    p46.put("State", "Georgia");
	    p46.put("Zip code", "30313");
	    p46.put("Address Line 1", "190 Marietta St NW");
	    p46.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p47 = new TreeMap<>();
	    p47.put("First Name", "Ulric");
	    p47.put("Middle Name", "Vance");
	    p47.put("Last Name", "Edelwirth");
	    p47.put("Name Suffix", "II");
	    p47.put("Email", "ulric.edelwirth@mailto.plus");
	    p47.put("Social Security Number", "950-57-0547");
	    p47.put("Phone number", "785-555-4547");
	    p47.put("Date of Birth", "09/30/1992");
	    p47.put("State", "Kansas");
	    p47.put("Zip code", "66604");
	    p47.put("Address Line 1", "1200 Topeka Blvd");
	    p47.put("Address Line 2", "Unit 9D");

	    TreeMap<String, String> p48 = new TreeMap<>();
	    p48.put("First Name", "Valen");
	    p48.put("Middle Name", "Wren");
	    p48.put("Last Name", "Frostwick");
	    p48.put("Name Suffix", "Sr");
	    p48.put("Email", "valen.frostwick@mailto.plus");
	    p48.put("Social Security Number", "950-58-0548");
	    p48.put("Phone number", "603-555-4548");
	    p48.put("Date of Birth", "06/26/1989");
	    p48.put("State", "New Hampshire");
	    p48.put("Zip code", "03101");
	    p48.put("Address Line 1", "1000 Elm St");
	    p48.put("Address Line 2", "Apt 5C");

	    TreeMap<String, String> p49 = new TreeMap<>();
	    p49.put("First Name", "Wendell");
	    p49.put("Middle Name", "Xander");
	    p49.put("Last Name", "Hohenmere");
	    p49.put("Name Suffix", "III");
	    p49.put("Email", "wendell.hohenmere@mailto.plus");
	    p49.put("Social Security Number", "950-59-0549");
	    p49.put("Phone number", "504-555-4549");
	    p49.put("Date of Birth", "10/05/1989");
	    p49.put("State", "Louisiana");
	    p49.put("Zip code", "70130");
	    p49.put("Address Line 1", "1 Canal St");
	    p49.put("Address Line 2", "Apt 7B");

	    TreeMap<String, String> p50 = new TreeMap<>();
	    p50.put("First Name", "Xavian");
	    p50.put("Middle Name", "Yulian");
	    p50.put("Last Name", "Schreiberwyn");
	    p50.put("Name Suffix", "II");
	    p50.put("Email", "xavian.schreiberwyn@mailto.plus");
	    p50.put("Social Security Number", "950-60-0550");
	    p50.put("Phone number", "214-555-4550");
	    p50.put("Date of Birth", "01/30/1992");
	    p50.put("State", "Texas");
	    p50.put("Zip code", "75204");
	    p50.put("Address Line 1", "3000 McKinney Ave");
	    p50.put("Address Line 2", "Unit 7C");

	    return new Object[][]{
	        {p1},{p2},{p3},{p4},{p5},
	        {p6},{p7},{p8},{p9},{p10},
	        {p11},{p12},{p13},{p14},{p15},
	        {p16},{p17},{p18},{p19},{p20}, /*
	        {p21},{p22},{p23},{p24},{p25},
	        {p26},{p27},{p28},{p29},{p30}, 
	        {p31},{p32},{p33},{p34},{p35},
	        {p36},{p37},{p38},{p39},{p40},
	        {p41},{p42},{p43},{p44},{p45},
	        {p46},{p47},{p48},{p49},{p50} */
	    };
	}





  

}
	
	
	
	
	
	
	


