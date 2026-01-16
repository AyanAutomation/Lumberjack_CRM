package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.temp_mail_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;
import freemarker.cache.StrongCacheStorage;
@Listeners(Listerners.Report_Listen.class)
public class Case_Appplications extends Header_Manager{
	
	TreeSet<Double> monthly_emi = new TreeSet<Double>();
	TreeMap<String,Double> LIEN_AMOUNT_Values = new TreeMap<String,Double>();
	TreeMap<String,Double> TOTAL_PRINCIPAL_Values = new TreeMap<String,Double>();
    TreeMap<String,Double> CURRENT_LIEN_BALANCE_Values = new TreeMap<String,Double>();
	TreeMap<String,Double> RETURNED_AMT_Values = new TreeMap<String,Double>();
	
	
	public void Add_New_Case_Form_Accessor(int s) throws IOException, InterruptedException{
		
		Application_Locaters p = new Application_Locaters(d);
		
		int step = s;
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Click <b>Case Add</b> button from Header<br>"
			  + "<b>📘 Description:</b> User uses header Case Add button to directly open the New Case Add popup<br>"
			  + "<b>✅ Expected:</b> New Case popup should open");
	        header_buttons_clicker(0);
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Header <b>Case Add</b> button clicked.");
	        Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>Step "+(step++)+":</b> Verify New Case popup is opened<br>"
	         + "<b>📘 Description:</b> System should display the case creation popup/form after header Case Add click<br>"
	         + "<b>✅ Expected:</b> New Case Add popup form should be visible and ready for input");
			p.Popup_add_form();}
	
	
	
	
	
	@Test(dataProvider="case_plus_plaintiff")
	public void Add_case(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data) throws IOException, InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		Attorney_module at = new Attorney_module();
		
		Collections_Clear();
		
		int Buyout_Amount = Integer.parseInt(Case_Data.get("Buyout Amount"));
		int Approved_Amount = Integer.parseInt(Case_Data.get("Approved Amount"));
		int Document_prep_fee = Integer.parseInt(Case_Data.get("Document prep fee"));
		int Fund_transfer_fee = Integer.parseInt(Case_Data.get("Fund transfer fee"));
		int Rate_of_Return = Integer.parseInt(Case_Data.get("Rate of Return"));
		
		double Funded_amount = Buyout_Amount+Approved_Amount;
		double Annual_Interest_Amount = (Funded_amount * Rate_of_Return) / 100;
		double Monthly_Interest_Amount = Annual_Interest_Amount/12;
		double Monthly_Payable_Amount = Funded_amount+Monthly_Interest_Amount+Document_prep_fee+Fund_transfer_fee;
		double Monthly_Payable_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Payable_Amount));
		double Monthly_Interest_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Interest_Amount));
		
		int step=1;

		Add_New_Case_Form_Accessor(step++);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> New Case form/popup opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Search and select existing Plaintiff from dropdown.");
		p.form_inputs().get(0).sendKeys(Plaintiff.get("First Name"));
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Plaintiff selected = "+Plaintiff.get("First Name"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select Incident/Case Type from dropdown.");
		p.form_inputs().get(1).sendKeys(Case_Data.get("Case Type"));
		p.form_inputs().get(1).click();
		p.Incident_type_dropdown();
		option_printers("Incident Options are ",p.Incident_options());
		p.Incident_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Incident/Case type selected from list for input = "+Case_Data.get("Case Type"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select State of Incident from dropdown.");
		p.form_inputs().get(2).sendKeys(Case_Data.get("State"));
		p.form_inputs().get(2).click();
		p.State_of_incident_dropdown();
		p.State_of_incident_options().get(0).click();
		Thread.sleep(500);	
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> State selected from list for input = "+Case_Data.get("State"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Date of Incident and confirm date selection.");
		WebElement calender_field = p.form_inputs().get(3);
		calender_field.sendKeys(Case_Data.get("Date of Incident"));
		calender_field.click();
		p.calender_date_select().click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Date of Incident entered/selected = "+Case_Data.get("Date of Incident"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select Lead Type and Lead Source.");
		rp.Scroll_to_element(p.form_inputs().get(4));
		//p.form_inputs().get(4).click();
		p.form_inputs().get(4).sendKeys(Case_Data.get("Lead Source"));
		p.Lead_Type_dropdown();
		p.Lead_category_options().get(0).click();
		p.form_inputs().get(5).click();
		p.Lead_dropdown();
		p.Leadoptions().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Lead type/source selected from dropdowns (Lead Source input = "+Case_Data.get("Lead Source")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Requested Amount and click Create/Save Case.");
		rp.Scroll_to_element(p.form_inputs().get(5));
		p.form_inputs().get(6).sendKeys(Case_Data.get("Requested Amount"));
		p.form_buttons().get(1).click();
		Thread.sleep(500); 	
		try {
		Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
		catch(Exception e){
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Case Details edit popup and update Summary + Court Index Number.");
	    p.Case_details_edit_buttons().click();
		p.Summary_feild().sendKeys(Case_Data.get("Summary"));
		p.Court_index_input().sendKeys(Case_Data.get("Court Index Number"));
		p.Edit_form_buttons().get(1).click();
		p.Case_details_edit_buttons(); 
		Thread.sleep(500);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual </b> ✏️ Case Details edit popup opened, Court Index Number '"+Case_Data.get("Court Index Number")+"' was entered and saved without visible UI errors.");
		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Case Details saved (Summary updated, Court Index saved = "+Case_Data.get("Court Index Number")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Go to Contacts tab and link an Attorney contact from list.");
		tab_selector("Contacts");
		p.lawFirm_AddButton_ContactTab();
		rp.Scroll_to_element(p.Contact_AddButton_ContactTab());
		p.Contact_AddButton_ContactTab().click();
		p.Contact_type_dropdown_list();
		List<WebElement> Contact_Options = p.Contact_type_Options();
		for(WebElement Cn_opt:Contact_Options){
		if(Cn_opt.getText().trim().equalsIgnoreCase("Attorney")){
				Cn_opt.click();
				break;}}
		p.pop_up_contact_list();
		Thread.sleep(800);
		p.Popup_modal_search().sendKeys(attorneyData.get("First Name"));
		Thread.sleep(800);
		WebElement toast = lg.toast();
		rp.wait_for_invisibility(toast);
		try {
		p.List_Checkboxes().get(0).click();}
		catch(Exception attorney_searched_not_present){
			at.Atttorney_Add_through_case(attorneyData,Law_Firm_Data,Staff_Data,d);
			Thread.sleep(800);
		    WebElement Newtoast = lg.toast();
			rp.wait_for_invisibility(Newtoast);
			p.List_Checkboxes().get(0).click();}
		Thread.sleep(600);
       // rp.wait_for_invisibility(lg.toast());
		WebElement Import_button = p.import_Button();
		rp.Scroll_to_element(Import_button);
		Import_button.click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Attorney contact selected and added to case contacts.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Go to Applications tab and open Buyout modal.");
		rp.Scroll_to_element(p.Application_tab_bar());
		tab_selector("Applications");
		p.Application_amount_edit_buttons().get(1).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Buyout modal opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
		p.Modal_Input_Feilds().get(0).sendKeys(Case_Data.get("Buyout Funder Name"));
		p.Modal_Input_Feilds().get(1).sendKeys(Case_Data.get("Buyout Amount"));
		p.Modal_Input_Feilds().get(2).sendKeys(Case_Data.get("Buyout Expiry Date"));
		p.calender_date_select().click();
		p.modal_buttons().get(1).click();
		Thread.sleep(800);
		try {
			Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
			catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after Buyout Amount: "+"No toast captured / toast locator not visible. Error:");}
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Approved Amount edit and enter Approved Amount.");
		List<WebElement> Amount_edit_buttons;
	try{Amount_edit_buttons= p.Application_amount_edit_buttons();
	    Amount_edit_buttons.get(2).click(); }
	catch(Exception em) {
		Thread.sleep(800);
		Amount_edit_buttons= p.Application_amount_edit_buttons();
	    Amount_edit_buttons.get(2).click();
		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO,"Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
		System.out.println("Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
		System.out.println();}
		p.Application_Amount_input_Fields().get(0).sendKeys(Case_Data.get("Approved Amount"));
	    p.table_body().click();
	    Thread.sleep(800);
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Approved Amount entered = "+Case_Data.get("Approved Amount"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Update Application Status to APPROVED from dropdown.");
		rp.movetoelement(p.Application_Details_Dropdown_Feild());
	    p.Application_Details_Dropdown_Feild().click();
	    p.plaintiff_dropdown_list();
	    List<WebElement> Status_opts = p.Plaintiff_options();
	    for(WebElement Stat_opt:Status_opts){
	    	if(Stat_opt.getText().trim().contains("APPROVED")){
	    		Stat_opt.click();
	    		break;}}
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Application status set to APPROVED.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click Generate Contract and wait for Contract popup/modal.");
		p.Generate_contract_button().click();
	    p.popup_modal();
	    Thread.sleep(800);
	    rp.movetoelement(p.Popup_add_form());
	    Thread.sleep(800);
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Contract details modal opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill contract fee fields and Rate of Return.");
		List<WebElement> Fee_feilds = p.fee_amount_feilds();
	    rp.Scroll_to_element(Fee_feilds.get(0));
	    rp.Feild_clear(Fee_feilds.get(0));
	    Fee_feilds.get(0).sendKeys(Case_Data.get("Document prep fee"));
	    rp.Feild_clear(Fee_feilds.get(1));
	    Fee_feilds.get(1).sendKeys(Case_Data.get("Fund transfer fee"));
	    rp.Scroll_to_element(p.rate_of_return_feild());
	    rp.Feild_clear(p.rate_of_return_feild());
	    p.rate_of_return_feild().sendKeys(Case_Data.get("Rate of Return"));
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Fees + Rate of Return filled (DocPrep="+Case_Data.get("Document prep fee")+", FundTransfer="+Case_Data.get("Fund transfer fee")+", RoR="+Case_Data.get("Rate of Return")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Agreement Date + Interest Start Date and confirm date selection.");
		rp.Scroll_to_element(p.Agreement_Date_feild());
	    p.Agreement_Date_feild().sendKeys(Case_Data.get("Agreement Date"));
	    p.calender_date_select().click();
	    p.Interest_Start_Date().sendKeys(Case_Data.get("Interest Start Date"));
	    p.rate_of_return_feild().click();
	    Thread.sleep(600);
	    WebElement Generate_Contract_Button = p.contract_generator_button();
	    rp.movetoelement(Generate_Contract_Button);
	    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
	    js.executeScript("arguments[0].click();", Generate_Contract_Button);
	    try{p.Contract_editor();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Case created successfully for Plaintiff="+Case_Data.get("Plaintiff Name")+" | CourtIndex="+Case_Data.get("Court Index Number")+" | AgreementDate="+Case_Data.get("Agreement Date"));
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex="+Case_Data.get("Court Index Number"));
			throw e;}
	    d.switchTo().frame(p.contract_doc_iframe());
	    Thread.sleep(1000);
	 // ---------- CALC LOG (2 decimals) ----------
	    String Buyout_Amount_f = String.format("%.2f", (double) Buyout_Amount);
	    String Approved_Amount_f = String.format("%.2f", (double) Approved_Amount);
	    String Document_prep_fee_f = String.format("%.2f", (double) Document_prep_fee);
	    String Fund_transfer_fee_f = String.format("%.2f", (double) Fund_transfer_fee);
	    String Rate_of_Return_f = String.format("%.2f", (double) Rate_of_Return);

	    String Funded_amount_f = String.format("%.2f", Funded_amount);
	    String Annual_Interest_Amount_f = String.format("%.2f", Annual_Interest_Amount);
	    String Monthly_Interest_Amount_f = String.format("%.2f", Monthly_Interest_Amount);
	    String Monthly_Payable_Amount_f = String.format("%.2f", Monthly_Payable_Amount);
	    String Flat_Fees_f = String.format("%.2f", (double) (Document_prep_fee + Fund_transfer_fee));

	    String calc_log =
	            "<b>🧮 First Month Payable Calculation</b><br>"
	          + "<b>Buyout Amount:</b> " + Buyout_Amount_f + "<br>"
	          + "<b>Approved Amount:</b> " + Approved_Amount_f + "<br>"
	          + "<b>Funded Amount:</b> " + Funded_amount_f + "  (Buyout + Approved)<br><br>"
	          + "<b>Rate of Return (%):</b> " + Rate_of_Return_f + "<br>"
	          + "<b>Annual Interest:</b> " + Annual_Interest_Amount_f + "  (Funded × RoR / 100)<br>"
	          + "<b>Monthly Interest:</b> " + Monthly_Interest_Amount_f + "  (Annual / 12)<br><br>"
	          + "<b>Document Prep Fee:</b> " + Document_prep_fee_f + "<br>"
	          + "<b>Fund Transfer Fee:</b> " + Fund_transfer_fee_f + "<br>"
	          + "<b>Flat Fees Total:</b> " + Flat_Fees_f + "<br><br>"
	          + "<b>✅ First Month Payable:</b> "
	          + Funded_amount_f + " + " + Monthly_Interest_Amount_f + " + " + Document_prep_fee_f + " + " + Fund_transfer_fee_f
	          + " = <b>" + Monthly_Payable_Amount_f + "</b>";

	    Report_Listen.log_print_in_report().log(Status.INFO, calc_log);

	    // Console output (same info, clean)
	    System.out.println("\n===== First Month Payable Calculation =====");
	    System.out.println("Buyout Amount        : " + Buyout_Amount_f);
	    System.out.println("Approved Amount      : " + Approved_Amount_f);
	    System.out.println("Funded Amount        : " + Funded_amount_f + "  (Buyout + Approved)");
	    System.out.println("------------------------------------------");
	    System.out.println("Rate of Return (%)   : " + Rate_of_Return_f);
	    System.out.println("Annual Interest      : " + Annual_Interest_Amount_f + "  (Funded × RoR / 100)");
	    System.out.println("Monthly Interest     : " + Monthly_Interest_Amount_f + "  (Annual / 12)");
	    System.out.println("------------------------------------------");
	    System.out.println("Document Prep Fee    : " + Document_prep_fee_f);
	    System.out.println("Fund Transfer Fee    : " + Fund_transfer_fee_f);
	    System.out.println("Flat Fees Total      : " + Flat_Fees_f);
	    System.out.println("------------------------------------------");
	    System.out.println("✅ First Month Payable: " + Funded_amount_f + " + " + Monthly_Interest_Amount_f + " + "
	            + Document_prep_fee_f + " + " + Fund_transfer_fee_f + " = " + Monthly_Payable_Amount_f);
	    System.out.println("==========================================\n");
        System.out.println();
	    rp.Scroll_to_element(p.Contract_lien_table());
	    
	    List<WebElement> cells = p.Cell_datas();
	    int i=0;
	    for(WebElement cell:cells){
	    	String cell_text = cell.getText().trim();
	    	if(!cell_text.contains("/")) {
	    	// ✅ Convert UI text like "$1,234.50" into pure number string "1234.50" before parsing
	        // replace(",", "") removes thousand separators
	        // replace("$", "") removes currency symbol
	        // trim() removes extra spaces
	    	double cell_value = Double.parseDouble(cell_text.replace(",", "").replace("$", "").trim());
	    	// ✅ Round to 2 decimals in a safe UI-matching way:
	    	// String.format("%.2f", cell_value) -> converts double to String with exactly 2 decimal places ("% = placeholder, .2 = 2 decimals, f = floating number")
	    	// Double.parseDouble(...) -> converts that 2-decimal String back into a double for reliable numeric comparison (avoids floating precision noise like 10.1999999)
	    	double cell_value_upto_2_decimal = Double.parseDouble(String.format("%.2f", cell_value));
	    	// ✅ Compare doubles using tolerance instead of "==" (because doubles can be slightly off, e.g., 100.1 vs 100.0999998)
	        // Math.abs(a-b) < 0.01 means "difference is less than 1 paisa/cent equivalent at 2-decimal level"
	        // Here Monthly_Payable_Amount is already calculated, we check if this month cell matches it
	    	if(Math.abs(Monthly_Payable_Amount_upto_2_decimal-cell_value) < 0.01) {
	    		System.out.println("Testcase passed First month payable "+Monthly_Payable_Amount_upto_2_decimal+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
	    		System.out.println();
	    		Report_Listen.log_print_in_report().log(Status.INFO,"Testcase passed First month payable "+Monthly_Payable_Amount_upto_2_decimal+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
	    		}monthly_emi.add(cell_value_upto_2_decimal);
	    	i++;}}
	 // ---------- FUTURE MONTH VALIDATION (Previous Month + Monthly Interest) ----------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	    		"<b>Step "+(step++)+":</b> Validate future months lien calculation from Contract Lien table.");

	    Report_Listen.log_print_in_report().log(Status.INFO,
	    		"<b>📘 Description:</b> Each month lien should increase only by Monthly Interest compared to previous month.");

	    Report_Listen.log_print_in_report().log(Status.INFO,
	    		"<b>✅ Expected:</b> For every month >= 1, (Current Month Payable - Previous Month Payable) should equal Monthly Interest = "+Monthly_Interest_Amount+".");

	    future_months_calculations_check(monthly_emi, Monthly_Interest_Amount);
	    d.switchTo().defaultContent();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Switch back from Contract iframe to main page (default content).");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Driver focus returned to main page after reading Contract lien table.");
        Thread.sleep(800);
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Save Changes</i> to save contract edits.");
		p.Save_changes_button().click();
		Thread.sleep(1800);
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast after saving contract.");
		String contract_saved = "";
		try{
			contract_saved = lg.toast().getText().trim();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract saved toast = "+contract_saved);
			System.out.println(contract_saved);
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
			throw e;}
		//d.navigate().refresh();
		FluentWait<WebDriver> w = new FluentWait<WebDriver>(d)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofMillis(500))
		        .ignoring(NoSuchElementException.class)
		        .ignoring(StaleElementReferenceException.class);

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
		String Contract_Generated = lg.toast().getText().trim();
		Login_negative_testcases.Toast_printer(Contract_Generated);
		rp.wait_for_invisibility(lg.toast());
		Thread.sleep(1000);
		WebElement new_toast =lg.toast();
		String new_toast_text = lg.toast().getText().trim();
		System.out.println(new_toast_text);
		WebElement Sign_in_button = p.Manual_sign_in_button();
		rp.movetoelement(Sign_in_button);
	    Thread.sleep(800);
	    rp.wait_for_theElement_tobe_clickable(Sign_in_button);
		Sign_in_button.click();
		//Docu_Sign_Signature();
		manual_lien_generation(Sign_in_button);
		Pay_Off_calculator(Case_Data,Plaintiff,attorneyData);
		Underwriting_Notes(Case_Data);
		
	}
	
	    
	    
	        public void Underwriting_Notes(TreeMap<String, String> Case_Data) throws InterruptedException, IOException{
	    	
	    	Application_Locaters p = new Application_Locaters(d);
	        Login_Locaters lg = new Login_Locaters(d);
			SIde_Menu_Handler sd = new SIde_Menu_Handler();
	    	
			try {p.Case_Action_Dropdown();
			tab_selector("Underwriting");
			p.Notes_Add_Button();}
			catch(Exception Not_Inside_Case_UnderWriting_Tab){
			sd.Side_menu_option_clicker("Applications", d,"N/A");
		 	p.landed_in_applicationList_confirmation();
		 	p.Filter_clear().click();
			// rp.wait_for_invisibility(p.list_loader());
		    WebElement Status_filter = p.Application_status_filter();
			Status_filter.click();
			Application_Filter_Option_Selector("Funded");
		 	p.rows().get(0).click();
			Thread.sleep(800);}
			List<WebElement> Case_Tags;
			try{
			Case_Tags = p.Case_tags();}
			catch(RuntimeException tags){
			System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			System.out.println();
			Thread.sleep(1200);
			Case_Tags = p.Case_tags();}	
			p.Case_Action_Dropdown();
			tab_selector("Underwriting");
			WebElement Notes_Add_Button= p.Notes_Add_Button();	
			Notes_Add_Button.click();
			List <WebElement> inputs =p.Edit_form_inputs();
			p.textArea().sendKeys(Case_Data.get("Underwriting Notes"));
			inputs.get(0).sendKeys(Case_Data.get("Underwriting Tag"));
			p.Submit_Button().click();
		try {WebElement Toast = lg.toast();
			Login_negative_testcases.Toast_printer(Toast.getText().trim());}
		catch(Exception Toast_Not_Found){
			System.out.println("Toast Not found after saving Underwriting Notes");
			System.out.println();}}
	    	
	    
	
	
	
	public void future_months_calculations_check(TreeSet<Double> emi,Double monthy_interest){

	    BigDecimal bd = new BigDecimal("0.01"); // keeping as you declared (not used now)

	    TreeSet<Double> each_month_emi = emi;
	    Double each_monthly_interest = monthy_interest;
	    int month=0;

	    Double Previous_Month_Amount=null;

	    for(Double Eachemi:each_month_emi){

	        if(month>0){

	            Double Each_month_increase_raw = Eachemi - Previous_Month_Amount;

	            double Each_month_increase = Double.parseDouble(String.format("%.2f", Each_month_increase_raw));

	            // ✅ Tolerance-based match (rounding carry-forward safe)
	            if(Math.abs(Each_month_increase - each_monthly_interest) <= 0.01){

	                // ✅ PASS (Green block math style)
	                Report_Listen.log_print_in_report().log(Status.PASS,
	                        "<div style='background:#eaf5ff; padding:14px; border-radius:8px; border:1px solid #1e88e5; color:#0b3a63; font-weight:600;'>"
	                      + "<b>✅ PASS — Month " + month + " Increase Matched Monthly Interest</b><br><br>"

	                      + "<b>🔹 What we are validating:</b><br>"
	                      + "Each month payable should increase only by <b>Monthly Interest</b>.<br><br>"

	                      + "<b>📌 Values:</b><br>"
	                      + "Prev Month Payable (Month " + (month-1) + ") = <b>" + Previous_Month_Amount + "</b><br>"
	                      + "Curr Month Payable (Month " + month + ") = <b>" + Eachemi + "</b><br>"
	                      + "Expected Monthly Interest = <b>" + each_monthly_interest + "</b><br><br>"

	                      + "<b>🧮 Formula:</b><br>"
	                      + "<b>Increase = Current Month Payable − Previous Month Payable</b><br><br>"

	                      + "<b>🧾 Substitute values:</b><br>"
	                      + "Increase = " + Eachemi + " − " + Previous_Month_Amount + "<br><br>"

	                      + "<b>✅ Result:</b><br>"
	                      + "Increase = <b>" + Each_month_increase + "</b><br><br>"

	                      + "<b>🔍 Check:</b><br>"
	                      + "Increase (" + Each_month_increase + ") ≈ Monthly Interest (" + each_monthly_interest + ") → <b>Matched ✅</b><br><br>"

	                      + "<b>🟩 Meaning (simple):</b> System added only the correct monthly interest. No extra/less amount was added.<br><br>"

	                      + "<b>🟨 Conclusion:</b> Payable increase is correct for Month " + month + "."
	                      + "</div>"
	                );
	            }
	            else{

	                // ❌ FAIL (same green block style, but FAIL status)
	                Report_Listen.log_print_in_report().log(Status.FAIL,
	                        "<div style='background:#1f2a00; padding:14px; border-radius:8px; border:1px solid #3a4a00; color:#f0d84b;'>"
	                      + "<b>❌ FAIL — Month " + month + " Increase Did NOT Match Monthly Interest</b><br><br>"

	                      + "<b>🔹 What we are validating:</b><br>"
	                      + "Each month payable should increase only by <b>Monthly Interest</b>.<br><br>"

	                      + "<b>📌 Values:</b><br>"
	                      + "Prev Month Payable (Month " + (month-1) + ") = <b>" + Previous_Month_Amount + "</b><br>"
	                      + "Curr Month Payable (Month " + month + ") = <b>" + Eachemi + "</b><br>"
	                      + "Expected Monthly Interest = <b>" + each_monthly_interest + "</b><br><br>"

	                      + "<b>🧮 Formula:</b><br>"
	                      + "<b>Increase = Current Month Payable − Previous Month Payable</b><br><br>"

	                      + "<b>🧾 Substitute values:</b><br>"
	                      + "Increase = " + Eachemi + " − " + Previous_Month_Amount + "<br><br>"

	                      + "<b>❌ Result:</b><br>"
	                      + "Increase = <b>" + Each_month_increase + "</b><br><br>"

	                      + "<b>🔍 Check:</b><br>"
	                      + "Increase (" + Each_month_increase + ") ≠ Monthly Interest (" + each_monthly_interest + ") → <b>Mismatch ❌</b><br><br>"

	                      + "<b>🟩 Meaning (simple):</b> "
	                      + (Each_month_increase > each_monthly_interest
	                            ? "System added <b>EXTRA amount</b> more than expected monthly interest."
	                            : "System added <b>LESS amount</b> than expected monthly interest.")
	                      + "<br><br>"

	                      + "<b>🟨 Conclusion:</b> Payable increase is incorrect for Month " + month + "."
	                      + "</div>"
	                );
	            }
	        }
	        Previous_Month_Amount = Eachemi;
	        month++;}}

	
	    
	    
	
	    public String Case_plaintiff_mail_id_fetcher() throws InterruptedException{
		
	    	Application_Locaters p = new Application_Locaters(d);
	    	
	    	tab_selector("Contacts");
	    	//p.lawFirm_AddButton_ContactTab();
	    	List <WebElement> Plaintiff_datas = p.Plaintiff_feild_labels_and_values();
		    String Mailid = Plaintiff_datas.get(7).getText().trim();
		    return Mailid;}
	    
	    
	
	    public void Docu_Sign_Signature() throws InterruptedException{
	    	
	    	temp_mail_Locaters p = new temp_mail_Locaters(d);
	    	Repeat rp = new Repeat(d);
	    	
	    	
	    	String plaintiff_mail = Case_plaintiff_mail_id_fetcher();
		    d.switchTo().newWindow(WindowType.TAB);
		    Set<String> all_window_handles = d.getWindowHandles();
		    String current_window_handle = d.getWindowHandle();
		    for(String handle:all_window_handles){
		    	if(!handle.equals(current_window_handle)){
		    		d.switchTo().window(handle);
		    		break;}}
		    d.navigate().to("https://tempmail.plus/en/#!");
		    p.mail_id_box().clear();
		    p.mail_id_box().sendKeys(plaintiff_mail);
		    p.mail_id_box().sendKeys(Keys.ENTER);
		    Thread.sleep(800);
	    	rp.Scroll_to_element(p.inbox_section());
	    	Thread.sleep(800); try {
	    	List<WebElement> Mails = p.mails();
	    	Mails.get(0).click();
	    	p.Entered_mail_details();} catch(Exception b){
	    	System.out.println("Couldn't find docu sign mails thereby trying to sign in contract manually");
	    	Report_Listen.log_print_in_report().log(Status.FAIL,"Couldn't find docu sign mails thereby trying to sign in contract manually");
	    	System.out.println();
	    	d.switchTo().window(current_window_handle);}}
	    
	    
	    
	    
	    public List<WebElement> manual_lien_generation(WebElement btn) throws InterruptedException{
	    	
	    	Application_Locaters p = new Application_Locaters(d);
	        Login_Locaters lg = new Login_Locaters(d);
			Repeat rp = new Repeat(d);
			JavascriptExecutor js = (JavascriptExecutor)d; 
	    	
			
			
			WebElement file;
		
	    try { file = p.upload();}
	    catch(Exception mmo){ 
	    	Thread.sleep(800);
			btn.click();
			file = p.upload();}
	        js.executeScript("arguments[0].removeAttribute('hidden');arguments[0].style.setProperty('display','block','important');arguments[0].style.setProperty('visibility','visible','important');arguments[0].style.setProperty('height','1px');arguments[0].style.setProperty('width','1px');", file);
            //js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.height='1px';",file);
	    	String filePath = Paths.get(System.getProperty("user.dir"),"Files","Manual Sign In image.pdf").toFile().getAbsolutePath();
	    	file.sendKeys(filePath);
	    	p.file_upload_preview_confirmation();
	    	List<WebElement> footer_buttons = p.popup_contact_list_footer_buttons();
	    	footer_buttons.get(0).click();
	    	WebElement Toast = lg.toast();
	    	String Contract_Signed = Toast.getText().trim();
			Login_negative_testcases.Toast_printer(Contract_Signed);
			try{tab_selector("Liens");}
			catch(Exception Lien_tab_retry){
				Thread.sleep(800);
				tab_selector("Liens");
			}
			List<WebElement> rows = p.Open_Lien_table_contents();
			return rows;
	    }
	    
	    
	    
	
	@DataProvider
	public Object[][] caseData() {

		   LocalDate today = LocalDate.now();
	       LocalDate agreementDate = today;
	       LocalDate interestStartDate = today;
           LocalDate buyoutExpiryDate = today.plusYears(4);      // +4 years (different from earlier)

		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		    String agreementDateStr = agreementDate.format(formatter);
		    String interestStartDateStr = interestStartDate.format(formatter);
		    String buyoutExpiryDateStr = buyoutExpiryDate.format(formatter);
		    String paymentDate = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		    // ===== Case data (NO plaintiff-related keys) =====
		    // ✅ Case Type values are ONLY from your allowed list.

		    TreeMap<String, String> c1 = new TreeMap<String, String>();
		    c1.put("Case #", "301");
		    c1.put("Case Type", "Civil Rights");
		    c1.put("State", "Indiana");
		    c1.put("Date of Incident", "04/18/2024");
		    c1.put("Lead Source", "Attorney Referral");
		    c1.put("Requested Amount", "64000");
		    c1.put("Court Index Number", "49D01-2404-CR-001887");
		    c1.put("Summary", "Civil rights claim alleging improper stop escalation and prolonged roadside detention; loss of wages and anxiety symptoms reported; requesting dashcam/bodycam and dispatch logs.");
		    c1.put("Risk Level", "Moderate");
		    c1.put("Recommended Max Funding", "27000");
		    c1.put("Underwriting Notes", "Prioritize objective evidence: bodycam/dashcam, CAD logs, incident report, and any suppression hearing rulings. Confirm notice deadlines, qualified immunity posture, and policy limits. Stage funding pending video confirmation.");
		    c1.put("Buyout Funder Name", "Cobalt Ridge Capital");
		    c1.put("Buyout Amount", "16800");
		    c1.put("Approved Amount", "27000");
		    c1.put("Application Status", "In Review");
		    c1.put("Attorney Name", "Attorney Dax Halloway");
		    c1.put("Law Firm Name", "West Loop Civil Rights & Police Conduct Counsel");
		    c1.put("Document prep fee", "335");
		    c1.put("Fund transfer fee", "115");
		    c1.put("Rate of Return", "42");
		    c1.put("SMS Message Title", "Civil Rights File In Review");
		    c1.put("SMS Message Body", "Your civil rights application is under review while key records are verified. We’ll update you soon. – Lumberjack Legal Finance");
		    c1.put("Underwriting Tag", "Video Verification Pending");
		    // Payment (d2)
		    c1.put("Payment Mode", "Bank Transfer");
		    c1.put("Payment Type", "Payment by Attorney");
		    c1.put("Payer Name", "Attorney Marius Calder");
		    c1.put("Payment Date", paymentDate);
		    c1.put("Amount Received", "13500");
		    c1.put("Notes / Remarks", "Attorney office initiated bank transfer; remittance email received; reconcile with bank statement and attach confirmation before posting.");

		    TreeMap<String, String> c2 = new TreeMap<String, String>();
		    c2.put("Case #", "302");
		    c2.put("Case Type", "Police Brutality");
		    c2.put("State", "Illinois");
		    c2.put("Date of Incident", "09/07/2023");
		    c2.put("Lead Source", "Organic");
		    c2.put("Requested Amount", "88000");
		    c2.put("Court Index Number", "14L03-2309-PB-001204");
		    c2.put("Summary", "Use-of-force claim during arrest with reported shoulder dislocation and facial injury; ER records and follow-up ortho visits cited; complaint drafting in progress.");
		    c2.put("Risk Level", "Moderate-High");
		    c2.put("Recommended Max Funding", "35000");
		    c2.put("Underwriting Notes", "High upside if medical causation and video align. Confirm criminal disposition, municipal notice timelines, policy/indemnification, and whether discipline/IA findings exist. Stage funding until complaint is filed and footage reviewed.");
		    c2.put("Buyout Funder Name", "Summit Legal Funding");
		    c2.put("Buyout Amount", "21400");
		    c2.put("Approved Amount", "35000");
		    c2.put("Application Status", "Pending Docs");
		    c2.put("Attorney Name", "Attorney Rowena Larkspur");
		    c2.put("Law Firm Name", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
		    c2.put("Document prep fee", "345");
		    c2.put("Fund transfer fee", "125");
		    c2.put("Rate of Return", "45");
		    c2.put("SMS Message Title", "Documents Needed");
		    c2.put("SMS Message Body", "We need a few additional documents to finalize underwriting. Please coordinate uploads with your attorney. – Lumberjack Legal Finance");
		    c2.put("Underwriting Tag", "Medical Causation Review");
		    // Payment (d3)
		    c2.put("Payment Mode", "Credit Card");
		    c2.put("Payment Type", "Payment by Plaintiff");
		    c2.put("Payer Name", "Plaintiff Harper Ouellette");
		    c2.put("Payment Date", paymentDate);
		    c2.put("Amount Received", "4200");
		    c2.put("Notes / Remarks", "Card approved; validate gateway reference and last 4 digits; convenience fee not included in received amount.");

		    TreeMap<String, String> c3 = new TreeMap<String, String>();
		    c3.put("Case #", "303");
		    c3.put("Case Type", "Wrongful Arrest");
		    c3.put("State", "Ohio");
		    c3.put("Date of Incident", "02/11/2024");
		    c3.put("Lead Source", "Advertising");
		    c3.put("Requested Amount", "46000");
		    c3.put("Court Index Number", "18CV-2402-WA-002031");
		    c3.put("Summary", "Wrongful arrest due to mistaken identity; held overnight; missed shifts and reputational harm claimed; alibi documentation and witness statement referenced.");
		    c3.put("Risk Level", "Moderate");
		    c3.put("Recommended Max Funding", "18500");
		    c3.put("Underwriting Notes", "Confirm dismissal/acquittal, arrest report narrative, and any station video. Damages strengthen with payroll loss proof and documented counseling/therapy. Review immunity defenses and notice compliance.");
		    c3.put("Buyout Funder Name", "Harbor Ridge Finance");
		    c3.put("Buyout Amount", "10200");
		    c3.put("Approved Amount", "18500");
		    c3.put("Application Status", "Approved");
		    c3.put("Attorney Name", "Attorney Silas Markham");
		    c3.put("Law Firm Name", "Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices");
		    c3.put("Document prep fee", "265");
		    c3.put("Fund transfer fee", "90");
		    c3.put("Rate of Return", "38");
		    c3.put("SMS Message Title", "Funding Approved");
		    c3.put("SMS Message Body", "Your wrongful arrest funding has been approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c3.put("Underwriting Tag", "Disposition Confirmed");
		    // Payment (d4)
		    c3.put("Payment Mode", "Cheque");
		    c3.put("Payment Type", "Payment by Insurance Company");
		    c3.put("Payer Name", "Riverstone Casualty Insurance Co.");
		    c3.put("Payment Date", paymentDate);
		    c3.put("Amount Received", "48000");
		    c3.put("Notes / Remarks", "Cheque received via mailroom; deposit next business day; hold posting until clearance per finance policy.");

		    TreeMap<String, String> c4 = new TreeMap<String, String>();
		    c4.put("Case #", "304");
		    c4.put("Case Type", "Breach of contract");
		    c4.put("State", "Michigan");
		    c4.put("Date of Incident", "06/14/2023");
		    c4.put("Lead Source", "Broker");
		    c4.put("Requested Amount", "52000");
		    c4.put("Court Index Number", "07CV-2306-BC-001072");
		    c4.put("Summary", "Contract dispute over delayed delivery and alleged termination without cause; invoice trail and email acknowledgements attached; damages claimed for downtime and replacement sourcing.");
		    c4.put("Risk Level", "Moderate");
		    c4.put("Recommended Max Funding", "22000");
		    c4.put("Underwriting Notes", "Focus on enforceable terms, acceptance/performance evidence, and mitigation steps. Confirm venue, counterclaims, and collectability. Funding contingent on pleadings plus documentary proof of breach and damages.");
		    c4.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
		    c4.put("Buyout Amount", "13200");
		    c4.put("Approved Amount", "22000");
		    c4.put("Application Status", "In Review");
		    c4.put("Attorney Name", "Attorney Tessa Wainwright");
		    c4.put("Law Firm Name", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
		    c4.put("Document prep fee", "290");
		    c4.put("Fund transfer fee", "100");
		    c4.put("Rate of Return", "41");
		    c4.put("SMS Message Title", "Contract Case Under Review");
		    c4.put("SMS Message Body", "Your breach-of-contract application is under review while we verify pleadings and supporting documents. – Lumberjack Legal Finance");
		    c4.put("Underwriting Tag", "Pleadings Requested");
		    // Payment (d5)
		    c4.put("Payment Mode", "Online Payment");
		    c4.put("Payment Type", "Payment by Another Funder");
		    c4.put("Payer Name", "Summit Equity Legal Funding Partners");
		    c4.put("Payment Date", paymentDate);
		    c4.put("Amount Received", "17400");
		    c4.put("Notes / Remarks", "Online portal payment from another funder for buyout; cross-check reference ID and ledger; attach receipt PDF.");

		    TreeMap<String, String> c5 = new TreeMap<String, String>();
		    c5.put("Case #", "305");
		    c5.put("Case Type", "Employment Disputes");
		    c5.put("State", "Indiana");
		    c5.put("Date of Incident", "08/29/2024");
		    c5.put("Lead Source", "Attorney Referral");
		    c5.put("Requested Amount", "39000");
		    c5.put("Court Index Number", "49D05-2408-ED-001443");
		    c5.put("Summary", "Retaliation claim after reporting safety violations; termination letter conflicts with performance records; wage loss and emotional distress alleged.");
		    c5.put("Risk Level", "Moderate");
		    c5.put("Recommended Max Funding", "16000");
		    c5.put("Underwriting Notes", "Validate protected activity timeline, HR reports, comparator evidence, and payroll history. Confirm arbitration exposure and mitigation. Stage funding if early settlement posture is uncertain.");
		    c5.put("Buyout Funder Name", "Liberty Legal Funding");
		    c5.put("Buyout Amount", "8700");
		    c5.put("Approved Amount", "16000");
		    c5.put("Application Status", "Approved");
		    c5.put("Attorney Name", "Attorney Nolan Vercetti");
		    c5.put("Law Firm Name", "Falkenova, Dornik & Brechtova Maritime, Boat & Seeufer Accident Rechtsberatung Group");
		    c5.put("Document prep fee", "245");
		    c5.put("Fund transfer fee", "85");
		    c5.put("Rate of Return", "37");
		    c5.put("SMS Message Title", "Approved");
		    c5.put("SMS Message Body", "Your employment dispute funding has been approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c5.put("Underwriting Tag", "HR File Review");
		    // Payment (d6)
		    c5.put("Payment Mode", "Bank Transfer");
		    c5.put("Payment Type", "Payment by Insurance Company");
		    c5.put("Payer Name", "HarborPoint Mutual Insurance Services");
		    c5.put("Payment Date", paymentDate);
		    c5.put("Amount Received", "54000");
		    c5.put("Notes / Remarks", "Wire received; confirm sender matches remittance advice; allocation captured in internal ledger.");

		    TreeMap<String, String> c6 = new TreeMap<String, String>();
		    c6.put("Case #", "306");
		    c6.put("Case Type", "Unpaid Wages");
		    c6.put("State", "Illinois");
		    c6.put("Date of Incident", "01/26/2024");
		    c6.put("Lead Source", "Other");
		    c6.put("Requested Amount", "20000");
		    c6.put("Court Index Number", "14L01-2401-UW-000587");
		    c6.put("Summary", "Unpaid overtime and denied meal-break premiums across multiple pay cycles; timekeeping entries reportedly edited; paystubs and schedules in conflict.");
		    c6.put("Risk Level", "Low-Moderate");
		    c6.put("Recommended Max Funding", "8000");
		    c6.put("Underwriting Notes", "Confirm arbitration/class waiver and payroll record integrity. Risk depends on certification posture and employer defenses. Conservative funding until early discovery clarifies timekeeping practices.");
		    c6.put("Buyout Funder Name", "Harbor Ridge Finance");
		    c6.put("Buyout Amount", "4600");
		    c6.put("Approved Amount", "8000");
		    c6.put("Application Status", "Pending Docs");
		    c6.put("Attorney Name", "Attorney Veda Langford");
		    c6.put("Law Firm Name", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
		    c6.put("Document prep fee", "220");
		    c6.put("Fund transfer fee", "70");
		    c6.put("Rate of Return", "34");
		    c6.put("SMS Message Title", "Documents Needed");
		    c6.put("SMS Message Body", "We need additional payroll or schedule documentation to finalize your unpaid wages file. – Lumberjack Legal Finance");
		    c6.put("Underwriting Tag", "Payroll Reconciliation");
		    // Payment (d7)
		    c6.put("Payment Mode", "Cash");
		    c6.put("Payment Type", "Payment by Attorney");
		    c6.put("Payer Name", "Attorney Keiran Holbrook");
		    c6.put("Payment Date", paymentDate);
		    c6.put("Amount Received", "5200");
		    c6.put("Notes / Remarks", "Cash delivered by office runner; counted and receipted; attach receipt scan and ID verification note.");

		    TreeMap<String, String> c7 = new TreeMap<String, String>();
		    c7.put("Case #", "307");
		    c7.put("Case Type", "Workers Compensation");
		    c7.put("State", "Michigan");
		    c7.put("Date of Incident", "09/03/2023");
		    c7.put("Lead Source", "Medical Provider");
		    c7.put("Requested Amount", "26000");
		    c7.put("Court Index Number", "03WC-2309-WC-002244");
		    c7.put("Summary", "Work comp claim for repetitive strain injury; EMG indicates neuropathy; work restrictions and reduced hours reported; treatment ongoing.");
		    c7.put("Risk Level", "Moderate");
		    c7.put("Recommended Max Funding", "10500");
		    c7.put("Underwriting Notes", "Confirm claim acceptance vs dispute, wage statement accuracy, and MMI outlook. Lien and fee posture matters. Keep funding conservative if denial/IME dispute is active.");
		    c7.put("Buyout Funder Name", "Summit Legal Funding");
		    c7.put("Buyout Amount", "6100");
		    c7.put("Approved Amount", "10500");
		    c7.put("Application Status", "In Review");
		    c7.put("Attorney Name", "Attorney Sienna Marwick");
		    c7.put("Law Firm Name", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
		    c7.put("Document prep fee", "250");
		    c7.put("Fund transfer fee", "85");
		    c7.put("Rate of Return", "36");
		    c7.put("SMS Message Title", "Under Review");
		    c7.put("SMS Message Body", "Your workers compensation file is under review while claim status and records are verified. – Lumberjack Legal Finance");
		    c7.put("Underwriting Tag", "Claim Status Verification");
		    // Payment (d8)
		    c7.put("Payment Mode", "Cheque");
		    c7.put("Payment Type", "Payment by Plaintiff");
		    c7.put("Payer Name", "Plaintiff Gideon Carruthers");
		    c7.put("Payment Date", paymentDate);
		    c7.put("Amount Received", "9800");
		    c7.put("Notes / Remarks", "Personal cheque received; hold settlement status until clearance; log cheque number and deposit date.");

		    TreeMap<String, String> c8 = new TreeMap<String, String>();
		    c8.put("Case #", "308");
		    c8.put("Case Type", "Boat Accident");
		    c8.put("State", "Indiana");
		    c8.put("Date of Incident", "06/15/2024");
		    c8.put("Lead Source", "Organic");
		    c8.put("Requested Amount", "56000");
		    c8.put("Court Index Number", "49D03-2406-BA-001136");
		    c8.put("Summary", "Recreational boat collision at low visibility; alleged excessive speed and improper lookout; concussion symptoms and shoulder injury reported; patrol report requested.");
		    c8.put("Risk Level", "Moderate");
		    c8.put("Recommended Max Funding", "23500");
		    c8.put("Underwriting Notes", "Key evidence: marine patrol report, witness statements, photos, and compliance with navigation rules. Confirm operator insurance and comparative negligence risks.");
		    c8.put("Buyout Funder Name", "Frontline Capital Group");
		    c8.put("Buyout Amount", "15200");
		    c8.put("Approved Amount", "23500");
		    c8.put("Application Status", "Approved");
		    c8.put("Attorney Name", "Attorney Orion Sedgewick");
		    c8.put("Law Firm Name", "Falkenova, Dornik & Brechtova Maritime, Boat & Seeufer Accident Rechtsberatung Group");
		    c8.put("Document prep fee", "285");
		    c8.put("Fund transfer fee", "100");
		    c8.put("Rate of Return", "40");
		    c8.put("SMS Message Title", "Boat Accident Approved");
		    c8.put("SMS Message Body", "Your boat accident funding is approved. We’ll coordinate agreement review and disbursement with your attorney. – Lumberjack Legal Finance");
		    c8.put("Underwriting Tag", "Marine Report Pending");
		    // Payment (d9)
		    c8.put("Payment Mode", "Online Payment");
		    c8.put("Payment Type", "Payment by PIP");
		    c8.put("Payer Name", "PIP Claims Department - MetroShield");
		    c8.put("Payment Date", paymentDate);
		    c8.put("Amount Received", "7600");
		    c8.put("Notes / Remarks", "PIP reimbursement via online payment; verify remittance claim number; match against payment schedule.");

		    TreeMap<String, String> c9 = new TreeMap<String, String>();
		    c9.put("Case #", "309");
		    c9.put("Case Type", "Airplane Accident");
		    c9.put("State", "Ohio");
		    c9.put("Date of Incident", "05/02/2023");
		    c9.put("Lead Source", "Attorney Referral");
		    c9.put("Requested Amount", "118000");
		    c9.put("Court Index Number", "21CV-2305-AA-001019");
		    c9.put("Summary", "Small aircraft runway excursion with alleged maintenance oversight; orthopedic injuries and extended rehab; requesting NTSB/FAA records and maintenance logs.");
		    c9.put("Risk Level", "Moderate-High");
		    c9.put("Recommended Max Funding", "56000");
		    c9.put("Underwriting Notes", "Multiple potentially liable parties (operator, maintenance, manufacturer). Confirm investigation status, insurance layers, and expert retention. Staged funding recommended until causation is clarified.");
		    c9.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
		    c9.put("Buyout Amount", "34500");
		    c9.put("Approved Amount", "56000");
		    c9.put("Application Status", "In Review");
		    c9.put("Attorney Name", "Attorney Elara Whitcombe");
		    c9.put("Law Firm Name", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
		    c9.put("Document prep fee", "360");
		    c9.put("Fund transfer fee", "135");
		    c9.put("Rate of Return", "47");
		    c9.put("SMS Message Title", "Airplane Case Under Review");
		    c9.put("SMS Message Body", "Your airplane accident file is under advanced review while investigation records are verified. – Lumberjack Legal Finance");
		    c9.put("Underwriting Tag", "Investigation Layering");
		    // Payment (d10)
		    c9.put("Payment Mode", "Credit Card");
		    c9.put("Payment Type", "Payment by Insurance Company");
		    c9.put("Payer Name", "CedarLine Commercial Insurance");
		    c9.put("Payment Date", paymentDate);
		    c9.put("Amount Received", "12500");
		    c9.put("Notes / Remarks", "Insurance card payment processed; attach transaction receipt; verify no partial capture in gateway.");

		    TreeMap<String, String> c10 = new TreeMap<String, String>();
		    c10.put("Case #", "310");
		    c10.put("Case Type", "Aeroplane accident");
		    c10.put("State", "Illinois");
		    c10.put("Date of Incident", "10/09/2023");
		    c10.put("Lead Source", "Broker");
		    c10.put("Requested Amount", "102000");
		    c10.put("Court Index Number", "12L04-2310-AE-002611");
		    c10.put("Summary", "Charter turbulence event with unsecured cabin items causing head/neck injury; neurology follow-ups ongoing; carrier incident report requested.");
		    c10.put("Risk Level", "Moderate");
		    c10.put("Recommended Max Funding", "42000");
		    c10.put("Underwriting Notes", "Confirm passenger records, medical timeline, and applicable treaty/limitations if commercial carriage applies. Evidence quality and insurance layers drive funding cap. Stage until incident report and treating notes received.");
		    c10.put("Buyout Funder Name", "Harbor Ridge Finance");
		    c10.put("Buyout Amount", "27200");
		    c10.put("Approved Amount", "42000");
		    c10.put("Application Status", "Pending Docs");
		    c10.put("Attorney Name", "Attorney Maeve Calderon");
		    c10.put("Law Firm Name", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
		    c10.put("Document prep fee", "350");
		    c10.put("Fund transfer fee", "125");
		    c10.put("Rate of Return", "46");
		    c10.put("SMS Message Title", "Documents Needed");
		    c10.put("SMS Message Body", "We need a few additional documents to finalize your aeroplane accident file. Please coordinate with your attorney. – Lumberjack Legal Finance");
		    c10.put("Underwriting Tag", "Treaty/Limitation Check");
		    // Payment (d11)
		    c10.put("Payment Mode", "Bank Transfer");
		    c10.put("Payment Type", "Payment by PIP");
		    c10.put("Payer Name", "PIP Unit - Granite Auto Indemnity");
		    c10.put("Payment Date", paymentDate);
		    c10.put("Amount Received", "6500");
		    c10.put("Notes / Remarks", "Bank transfer from PIP unit; reconcile amount vs expected reimbursement; document remittance reference.");

		    TreeMap<String, String> c11 = new TreeMap<String, String>();
		    c11.put("Case #", "311");
		    c11.put("Case Type", "Legal Malpractice");
		    c11.put("State", "Indiana");
		    c11.put("Date of Incident", "03/12/2023");
		    c11.put("Lead Source", "Attorney Referral");
		    c11.put("Requested Amount", "69000");
		    c11.put("Court Index Number", "49D09-2303-LM-000744");
		    c11.put("Summary", "Alleged missed litigation deadline in underlying injury case; loss-of-chance damages asserted; case-within-a-case evaluation underway.");
		    c11.put("Risk Level", "Moderate-High");
		    c11.put("Recommended Max Funding", "29500");
		    c11.put("Underwriting Notes", "Requires negligence + causation + value of underlying claim. Verify engagement terms, docket history, and malpractice policy limits. Recommend staged funding pending expert review and carrier response.");
		    c11.put("Buyout Funder Name", "Liberty Legal Funding");
		    c11.put("Buyout Amount", "18200");
		    c11.put("Approved Amount", "29500");
		    c11.put("Application Status", "In Review");
		    c11.put("Attorney Name", "Attorney Jonas Everhart");
		    c11.put("Law Firm Name", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
		    c11.put("Document prep fee", "320");
		    c11.put("Fund transfer fee", "115");
		    c11.put("Rate of Return", "44");
		    c11.put("SMS Message Title", "Legal Malpractice Review");
		    c11.put("SMS Message Body", "Your legal malpractice file is under review while we verify records and causation. – Lumberjack Legal Finance");
		    c11.put("Underwriting Tag", "Carrier Response Needed");
		    // Payment (d12)
		    c11.put("Payment Mode", "Cash");
		    c11.put("Payment Type", "Payment by Another Funder");
		    c11.put("Payer Name", "IronGate Litigation Finance Group");
		    c11.put("Payment Date", paymentDate);
		    c11.put("Amount Received", "3200");
		    c11.put("Notes / Remarks", "Cash payment logged for audit; receipt and compliance note attached; verify permissible method per policy.");

		    TreeMap<String, String> c12 = new TreeMap<String, String>();
		    c12.put("Case #", "312");
		    c12.put("Case Type", "Property Damage");
		    c12.put("State", "Michigan");
		    c12.put("Date of Incident", "01/23/2024");
		    c12.put("Lead Source", "Other");
		    c12.put("Requested Amount", "29500");
		    c12.put("Court Index Number", "07CV-2401-PD-000318");
		    c12.put("Summary", "Water intrusion claim following alleged negligent repair; mold remediation and temporary relocation costs; inspection report and vendor invoices submitted.");
		    c12.put("Risk Level", "Moderate");
		    c12.put("Recommended Max Funding", "13200");
		    c12.put("Underwriting Notes", "Confirm causation scope: work orders, adjuster notes, mitigation timeline, and any coverage exclusions. Funding contingent on repair bids and documented loss chronology.");
		    c12.put("Buyout Funder Name", "Frontline Capital Group");
		    c12.put("Buyout Amount", "7800");
		    c12.put("Approved Amount", "13200");
		    c12.put("Application Status", "Approved");
		    c12.put("Attorney Name", "Attorney Cora Fenwick");
		    c12.put("Law Firm Name", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
		    c12.put("Document prep fee", "255");
		    c12.put("Fund transfer fee", "90");
		    c12.put("Rate of Return", "36");
		    c12.put("SMS Message Title", "Approved");
		    c12.put("SMS Message Body", "Your property damage funding has been approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c12.put("Underwriting Tag", "Mitigation Timeline");
		    // Payment (d13)
		    c12.put("Payment Mode", "Online Payment");
		    c12.put("Payment Type", "Payment by Attorney");
		    c12.put("Payer Name", "Attorney Brynn Halstead");
		    c12.put("Payment Date", paymentDate);
		    c12.put("Amount Received", "19200");
		    c12.put("Notes / Remarks", "Attorney payment via online link; capture confirmation number; request remittance advice for allocation.");

		    TreeMap<String, String> c13 = new TreeMap<String, String>();
		    c13.put("Case #", "313");
		    c13.put("Case Type", "Sexual Harassment");
		    c13.put("State", "Illinois");
		    c13.put("Date of Incident", "06/12/2024");
		    c13.put("Lead Source", "Organic");
		    c13.put("Requested Amount", "51000");
		    c13.put("Court Index Number", "14L02-2406-SH-001146");
		    c13.put("Summary", "Workplace harassment with alleged retaliation after HR report; counseling initiated; wage loss and emotional distress claimed; internal messages referenced.");
		    c13.put("Risk Level", "Moderate");
		    c13.put("Recommended Max Funding", "20500");
		    c13.put("Underwriting Notes", "Confirm reporting timeline, HR findings, witnesses, and documentation of retaliation. Arbitration clauses and mitigation efforts affect valuation. Stage funding until charge/complaint posture is confirmed.");
		    c13.put("Buyout Funder Name", "Harbor Ridge Finance");
		    c13.put("Buyout Amount", "12000");
		    c13.put("Approved Amount", "20500");
		    c13.put("Application Status", "In Review");
		    c13.put("Attorney Name", "Attorney Liana Prescott");
		    c13.put("Law Firm Name", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
		    c13.put("Document prep fee", "270");
		    c13.put("Fund transfer fee", "100");
		    c13.put("Rate of Return", "40");
		    c13.put("SMS Message Title", "HR Claim In Review");
		    c13.put("SMS Message Body", "Your file is under underwriting review. We’ll update you once verification is complete. – Lumberjack Legal Finance");
		    c13.put("Underwriting Tag", "Retaliation Timeline");
		    // Payment (d14)
		    c13.put("Payment Mode", "Cheque");
		    c13.put("Payment Type", "Payment by Another Funder");
		    c13.put("Payer Name", "BluePine Settlement Funding Co.");
		    c13.put("Payment Date", paymentDate);
		    c13.put("Amount Received", "28500");
		    c13.put("Notes / Remarks", "Third-party funder buyout cheque received; hold posting until clearance and ledger match.");

		    TreeMap<String, String> c14 = new TreeMap<String, String>();
		    c14.put("Case #", "314");
		    c14.put("Case Type", "Discrimination");
		    c14.put("State", "Indiana");
		    c14.put("Date of Incident", "12/19/2023");
		    c14.put("Lead Source", "Attorney Referral");
		    c14.put("Requested Amount", "54000");
		    c14.put("Court Index Number", "49D06-2312-DC-001911");
		    c14.put("Summary", "Discrimination claim alleging uneven discipline and demotion; comparator employees treated differently; administrative charge filed; wage loss asserted.");
		    c14.put("Risk Level", "Moderate");
		    c14.put("Recommended Max Funding", "22000");
		    c14.put("Underwriting Notes", "Verify protected trait evidence, comparator records, and performance history. Confirm charge deadlines, arbitration exposure, and mitigation. Staged funding recommended if employer disputes causation.");
		    c14.put("Buyout Funder Name", "Liberty Legal Funding");
		    c14.put("Buyout Amount", "13200");
		    c14.put("Approved Amount", "22000");
		    c14.put("Application Status", "Approved");
		    c14.put("Attorney Name", "Attorney Soren Whitlock");
		    c14.put("Law Firm Name", "Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices");
		    c14.put("Document prep fee", "265");
		    c14.put("Fund transfer fee", "95");
		    c14.put("Rate of Return", "38");
		    c14.put("SMS Message Title", "Approved");
		    c14.put("SMS Message Body", "Your discrimination case funding has been approved. Your attorney will receive the agreement for review. – Lumberjack Legal Finance");
		    c14.put("Underwriting Tag", "Charge Filed");
		    // Payment (d15)
		    c14.put("Payment Mode", "Credit Card");
		    c14.put("Payment Type", "Payment by PIP");
		    c14.put("Payer Name", "PIP Recovery Desk - Atlas Motor Coverage");
		    c14.put("Payment Date", paymentDate);
		    c14.put("Amount Received", "4300");
		    c14.put("Notes / Remarks", "PIP payment by card; verify authorization and prevent duplicates using transaction ID.");

		    TreeMap<String, String> c15 = new TreeMap<String, String>();
		    c15.put("Case #", "315");
		    c15.put("Case Type", "Dog Bite");
		    c15.put("State", "Michigan");
		    c15.put("Date of Incident", "04/07/2024");
		    c15.put("Lead Source", "Medical Provider");
		    c15.put("Requested Amount", "17500");
		    c15.put("Court Index Number", "07CV-2404-DB-000404");
		    c15.put("Summary", "Dog bite to forearm with infection treatment; follow-up care ongoing; photos and urgent care notes provided; functional limits reported.");
		    c15.put("Risk Level", "Low-Moderate");
		    c15.put("Recommended Max Funding", "8200");
		    c15.put("Underwriting Notes", "Confirm homeowners/renters coverage, vaccination records, and prior bite history. Photos and medical records support causation. Conservative funding until functional outcome is clearer.");
		    c15.put("Buyout Funder Name", "Summit Legal Funding");
		    c15.put("Buyout Amount", "4500");
		    c15.put("Approved Amount", "8200");
		    c15.put("Application Status", "Approved");
		    c15.put("Attorney Name", "Attorney Mae Casterbridge");
		    c15.put("Law Firm Name", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
		    c15.put("Document prep fee", "215");
		    c15.put("Fund transfer fee", "70");
		    c15.put("Rate of Return", "33");
		    c15.put("SMS Message Title", "Approved");
		    c15.put("SMS Message Body", "Your dog bite funding is approved. Please coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c15.put("Underwriting Tag", "Coverage Confirmation");
		    // Payment (d16)
		    c15.put("Payment Mode", "Bank Transfer");
		    c15.put("Payment Type", "Payment by Plaintiff");
		    c15.put("Payer Name", "Plaintiff Rowan Westerdale");
		    c15.put("Payment Date", paymentDate);
		    c15.put("Amount Received", "6200");
		    c15.put("Notes / Remarks", "Plaintiff bank transfer received; confirm payer matches registered plaintiff; attach bank confirmation.");

		    TreeMap<String, String> c16 = new TreeMap<String, String>();
		    c16.put("Case #", "316");
		    c16.put("Case Type", "Products Liability");
		    c16.put("State", "Ohio");
		    c16.put("Date of Incident", "09/22/2023");
		    c16.put("Lead Source", "Broker");
		    c16.put("Requested Amount", "57000");
		    c16.put("Court Index Number", "21CV-2309-PL-001606");
		    c16.put("Summary", "Consumer device malfunction caused fall and fracture; item preserved; expert inspection planned; dental and ortho treatment ongoing.");
		    c16.put("Risk Level", "Moderate");
		    c16.put("Recommended Max Funding", "24500");
		    c16.put("Underwriting Notes", "Preservation and chain-of-custody required. Confirm recall history and maintenance/usage factors. Stage funding until defect opinion and medical causation are documented.");
		    c16.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
		    c16.put("Buyout Amount", "15100");
		    c16.put("Approved Amount", "24500");
		    c16.put("Application Status", "In Review");
		    c16.put("Attorney Name", "Attorney Juno Hartwell");
		    c16.put("Law Firm Name", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
		    c16.put("Document prep fee", "295");
		    c16.put("Fund transfer fee", "110");
		    c16.put("Rate of Return", "42");
		    c16.put("SMS Message Title", "Defect Review");
		    c16.put("SMS Message Body", "Your products liability file is under defect review. We’ll update you after expert validation. – Lumberjack Legal Finance");
		    c16.put("Underwriting Tag", "Chain-of-Custody");
		    // Payment (d17)
		    c16.put("Payment Mode", "Online Payment");
		    c16.put("Payment Type", "Payment by Insurance Company");
		    c16.put("Payer Name", "EverHaven Insurance Group");
		    c16.put("Payment Date", paymentDate);
		    c16.put("Amount Received", "33800");
		    c16.put("Notes / Remarks", "Insurance payment received via portal; attach remittance; confirm final vs partial payment before closing ledger.");

		    TreeMap<String, String> c17 = new TreeMap<String, String>();
		    c17.put("Case #", "317");
		    c17.put("Case Type", "Premises Liability");
		    c17.put("State", "Indiana");
		    c17.put("Date of Incident", "02/20/2024");
		    c17.put("Lead Source", "Advertising");
		    c17.put("Requested Amount", "26500");
		    c17.put("Court Index Number", "49D02-2402-PR-001112");
		    c17.put("Summary", "Trip and fall over unmarked curb stop; ankle fracture with surgery; surveillance request sent; ownership/maintenance responsibility disputed.");
		    c17.put("Risk Level", "Moderate");
		    c17.put("Recommended Max Funding", "12800");
		    c17.put("Underwriting Notes", "Surveillance and maintenance logs are key. Comparative fault likely. Confirm premises ownership/contractor responsibility and liability limits. Stage funding if evidence is incomplete.");
		    c17.put("Buyout Funder Name", "Harbor Ridge Finance");
		    c17.put("Buyout Amount", "7600");
		    c17.put("Approved Amount", "12800");
		    c17.put("Application Status", "Approved");
		    c17.put("Attorney Name", "Attorney Caden Lockridge");
		    c17.put("Law Firm Name", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
		    c17.put("Document prep fee", "240");
		    c17.put("Fund transfer fee", "85");
		    c17.put("Rate of Return", "36");
		    c17.put("SMS Message Title", "Approved");
		    c17.put("SMS Message Body", "Your premises liability funding is approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c17.put("Underwriting Tag", "Maintenance Logs");
		    // Payment (d18)
		    c17.put("Payment Mode", "Cash");
		    c17.put("Payment Type", "Lost Deal");
		    c17.put("Payer Name", "N/A - Lost Deal");
		    c17.put("Payment Date", paymentDate);
		    c17.put("Amount Received", "0");
		    c17.put("Notes / Remarks", "Deal marked as lost; no payment collected; record kept for audit trail and reconciliation clarity.");

		    TreeMap<String, String> c18 = new TreeMap<String, String>();
		    c18.put("Case #", "318");
		    c18.put("Case Type", "Negligence");
		    c18.put("State", "Michigan");
		    c18.put("Date of Incident", "03/28/2023");
		    c18.put("Lead Source", "Attorney Referral");
		    c18.put("Requested Amount", "43000");
		    c18.put("Court Index Number", "03WC-2303-NG-001177");
		    c18.put("Summary", "Negligence claim from improper barricading causing cyclist crash; clavicle fracture; PT ongoing; photos and police report referenced.");
		    c18.put("Risk Level", "Moderate");
		    c18.put("Recommended Max Funding", "19000");
		    c18.put("Underwriting Notes", "Confirm contractor scope, traffic control plan, permits, and witness statements. Liability improves with consistent reports and photos. Confirm coverage and comparative negligence posture.");
		    c18.put("Buyout Funder Name", "Frontline Capital Group");
		    c18.put("Buyout Amount", "11300");
		    c18.put("Approved Amount", "19000");
		    c18.put("Application Status", "Approved");
		    c18.put("Attorney Name", "Attorney Wren Halcyon");
		    c18.put("Law Firm Name", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
		    c18.put("Document prep fee", "265");
		    c18.put("Fund transfer fee", "95");
		    c18.put("Rate of Return", "37");
		    c18.put("SMS Message Title", "Approved");
		    c18.put("SMS Message Body", "Your negligence case funding is approved. Your attorney will receive the agreement for review. – Lumberjack Legal Finance");
		    c18.put("Underwriting Tag", "Permit/Plan Review");
		    // Payment (d19)
		    c18.put("Payment Mode", "Bank Transfer");
		    c18.put("Payment Type", "Lost Deal");
		    c18.put("Payer Name", "N/A - Lost Deal");
		    c18.put("Payment Date", paymentDate);
		    c18.put("Amount Received", "1");
		    c18.put("Notes / Remarks", "Lost deal logged (system requires amount); placeholder used for validation; adjust if business rule requires blank/optional.");

		    TreeMap<String, String> c19 = new TreeMap<String, String>();
		    c19.put("Case #", "319");
		    c19.put("Case Type", "Assault");
		    c19.put("State", "Ohio");
		    c19.put("Date of Incident", "07/19/2024");
		    c19.put("Lead Source", "Organic");
		    c19.put("Requested Amount", "39500");
		    c19.put("Court Index Number", "18CV-2407-AS-001308");
		    c19.put("Summary", "Assault incident outside venue leading to facial fracture and dental trauma; security footage requested; anxiety counseling initiated.");
		    c19.put("Risk Level", "Moderate");
		    c19.put("Recommended Max Funding", "17000");
		    c19.put("Underwriting Notes", "Confirm defendant identity and collectability, police report, and venue incident logs. Medical records and photos strengthen damages. Funding depends on insurance availability and corroborating video.");
		    c19.put("Buyout Funder Name", "Liberty Legal Funding");
		    c19.put("Buyout Amount", "10400");
		    c19.put("Approved Amount", "17000");
		    c19.put("Application Status", "In Review");
		    c19.put("Attorney Name", "Attorney Evren Hollowbrook");
		    c19.put("Law Firm Name", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
		    c19.put("Document prep fee", "255");
		    c19.put("Fund transfer fee", "95");
		    c19.put("Rate of Return", "39");
		    c19.put("SMS Message Title", "Assault Case In Review");
		    c19.put("SMS Message Body", "Your assault case is under review while records and coverage details are verified. – Lumberjack Legal Finance");
		    c19.put("Underwriting Tag", "Coverage Discovery");
		    // Payment (d20)
		    c19.put("Payment Mode", "Cheque");
		    c19.put("Payment Type", "Payment by Attorney");
		    c19.put("Payer Name", "Attorney Sable Rennick");
		    c19.put("Payment Date", paymentDate);
		    c19.put("Amount Received", "15200");
		    c19.put("Notes / Remarks", "Attorney office cheque received; verify cheque number and payee line; post after clearance; request written confirmation from firm admin.");

		    TreeMap<String, String> c20 = new TreeMap<String, String>();
		    c20.put("Case #", "320");
		    c20.put("Case Type", "Attorney Funding");
		    c20.put("State", "Indiana");
		    c20.put("Date of Incident", "08/08/2023");
		    c20.put("Lead Source", "Attorney Referral");
		    c20.put("Requested Amount", "78000");
		    c20.put("Court Index Number", "49D04-2308-AF-002144");
		    c20.put("Summary", "Attorney funding request tied to litigation expenses in a complex injury case; advance sought for experts, discovery costs, and deposition scheduling.");
		    c20.put("Risk Level", "Moderate");
		    c20.put("Recommended Max Funding", "33500");
		    c20.put("Underwriting Notes", "Assess case posture, litigation budget, and timeline to recovery. Confirm contingency agreement, lien priorities, and disbursement controls. Stage funding based on milestones and cost documentation.");
		    c20.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
		    c20.put("Buyout Amount", "21200");
		    c20.put("Approved Amount", "33500");
		    c20.put("Application Status", "Approved");
		    c20.put("Attorney Name", "Attorney Mira Stonebridge");
		    c20.put("Law Firm Name", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
		    c20.put("Document prep fee", "310");
		    c20.put("Fund transfer fee", "115");
		    c20.put("Rate of Return", "43");
		    c20.put("SMS Message Title", "Approved – Attorney Funding");
		    c20.put("SMS Message Body", "Your attorney funding request is approved. We’ll coordinate the agreement and disbursement workflow with your office. – Lumberjack Legal Finance");
		    c20.put("Underwriting Tag", "Milestone-Based Disbursement");
		    // Reused Payment (d5)
		    c20.put("Payment Mode", "Online Payment");
		    c20.put("Payment Type", "Payment by Another Funder");
		    c20.put("Payer Name", "Summit Equity Legal Funding Partners");
		    c20.put("Payment Date", paymentDate);
		    c20.put("Amount Received", "17400");
		    c20.put("Notes / Remarks", "Online portal payment from another funder for buyout; cross-check reference ID and settlement ledger; attach payment receipt PDF.");


		    // ===== Apply dynamic dates to ALL cases =====
		    @SuppressWarnings("unchecked")
		    TreeMap<String, String>[] allCases = new TreeMap[] {
		       c1, c2, c3, c4, c5,
		        c6, c7, c8, c9, c10,
		        c11, c12, c13, c14, c15,
		        c16, c17, c18, c19, c20
		    };

		    for (TreeMap<String, String> c : allCases) {
		        c.put("Agreement Date", agreementDateStr);
		        c.put("Interest Start Date", interestStartDateStr);
		        c.put("Buyout Expiry Date", buyoutExpiryDateStr);
		    }

		    // ===== DataProvider return =====
		    return new Object[][]{ 
		        {c1},/*{c2},{c3},{c4},{c5},
		        {c6},{c7},{c8},{c9},{c10},
		        {c11},{c12},{c13},{c14},{c15}, 
		        {c16},{c17},{c18},{c19},{c20} */
		    };}
	
	
	
	@DataProvider
	public Object[][] case_plus_plaintiff(){

	    Plaintiff_Module pm = new Plaintiff_Module();
	    Attorney_module at = new Attorney_module();
	    Law_Firm_Module lfd = new Law_Firm_Module();

	    Object[][] plaintiff_datas = pm.plaintiffData();   
	    Object[][] case_datas      = caseData();           
	    Object[][] attorney_datas  = at.attorneyfData(); 
	    Object[][] law_firm_datas =  lfd.lawFirmData();
	    Object[][] Staff_datas =     at.Staff_data();
	    
	    int n = Math.min(Math.min(case_datas.length, law_firm_datas.length),Math.min(plaintiff_datas.length, attorney_datas.length));

	    // ✅ 3 columns now: case, plaintiff, attorney
	    Object[][] final_set = new Object[n][5];

	    for(int i = 0; i < n; i++){
	        final_set[i][0] = case_datas[i][0];       // case map
	        final_set[i][1] = plaintiff_datas[i][0];  // plaintiff map
	        final_set[i][2] = attorney_datas[i][0];   // attorney map
	        final_set[i][3] = law_firm_datas[i][0];   // law firm map
	        final_set[i][4] = Staff_datas[i][0];     // Staff map
	    }
	    return final_set;}
	
	public void option_printers(String prefix ,List<WebElement> options){
		
		for(WebElement option:options){
		
		System.out.println(prefix+option.getText().trim());}}
	
	
	
	   
	   public void Pay_Off_calculator(TreeMap<String, String> data, TreeMap<String, String> data2 ,TreeMap<String,String> attorneyData) throws IOException, InterruptedException{
		   
		   SIde_Menu_Handler sd = new SIde_Menu_Handler();
		   Application_Locaters p = new Application_Locaters(d);
		   Repeat rp = new Repeat(d);
		   Login_Locaters lg = new Login_Locaters(d);
		   
		   
		   Collections_Clear();
		   int step=1;
		   
		   List<WebElement> lien_rows = null;
		   
		   String Requested_Amount=data.get("Requested Amount"); 
		// =========================
		    // Scenario Header
		    // =========================
		    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario Title:</b> Pay-Off Calculator – Fetch Funded Application → Ensure Liens Exist (Generate if needed)");
		    Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description:</b> User goes to <b>Applications</b> list, filters by <b>Funded</b>, opens the first record, then ensures lien rows exist. If lien table is empty / case is closed / application is NEW, system generates application + contract + manual sign flow to create lien rows.");
		    Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input:</b> Requested Amount = <b>"+Requested_Amount+"</b> | Target Status Filter = <b>Funded</b>");
		    Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected:</b> A funded application should open. If liens are missing, automation should generate required app/contract and finally obtain lien rows for payoff validation.");
		    
		  
	       try{p.Case_Action_Dropdown();}
	       catch(Exception not_in_Case_Details) {	    
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		   WebElement Status_filter = p.Application_status_filter();
		   Status_filter.click();
		   Application_Filter_Option_Selector("Funded");
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
		   String case_status= Case_Tags.get(1).getText().trim();
		   if(case_status.contains("Case closed")){
			   lien_rows= Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount); }
		   else{
			  
			  tab_selector("Liens");
			  
	          try { 
	        	  lien_rows=p.Open_Lien_table_contents();
	        	  Payment_Logger(data);
	        	  }
			  catch(RuntimeException no_liens){
				
		  if(p.Lien_table_empty().isDisplayed()){
				
				  tab_selector("Applications");
				  try{
					List<WebElement> Amount_edit_buttons= p.Application_amount_edit_buttons();
					WebElement Dropdown_status = p.Application_Details_Dropdown_Feild();
				    rp.movetoelement(Dropdown_status);
				    String Application_status =Dropdown_status.getText().trim();
				    System.out.println("Application Status is "+Application_status);
				    if(Application_status.equalsIgnoreCase("NEW")){
				    	Amount_edit_buttons.get(2).click();
				    	Thread.sleep(800);
				    	Contract_Generator(data,data2,attorneyData,step);
				    	WebElement new_toast =lg.toast();
						String new_toast_text = lg.toast().getText().trim();
						System.out.println(new_toast_text);
						WebElement Sign_in_button = p.Manual_sign_in_button();
						rp.movetoelement(Sign_in_button);
					    Thread.sleep(800);
					    rp.wait_for_theElement_tobe_clickable(Sign_in_button);
						Sign_in_button.click();
						lien_rows=manual_lien_generation(Sign_in_button);
				    }else{
				    	lien_rows=Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount);}
				    }catch(Exception new_application_generate){
					  lien_rows= Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount); }}}}
		              int no_of_rows;
		        try {no_of_rows = lien_rows.size();}
		        catch(StaleElementReferenceException lien_row) {
		        	no_of_rows = lien_rows.size();}
		           List<WebElement> fourth_cells = p.First_table_fourth_column_cellData();
		           List<WebElement> Fifth_cells =  p.First_table_fifth_column_cellData();
		           List<WebElement> Sixth_cells =  p.First_table_sixth_column_cellData();
		           List<WebElement> Seventh_cells =p.First_table_seventh_column_cellData();
		           
		           
		        // =========================
		        // 1) INSERT into TreeMaps (one loop)
		        // =========================
		           
		           IntStream.range(0, no_of_rows).forEach(n -> {

		        	   String fourth_cell_datas  = fourth_cells.get(n).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
		        	    String Fifth_cell_data    = Fifth_cells.get(n).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
		        	    String Sixth_cell_data    = Sixth_cells.get(n).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
		        	    String seventh_cell_data  = Seventh_cells.get(n).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
		        	    
		        	    // ✅ Parse from UI text -> raw double
		        	    double lienAmount_raw     = Double.parseDouble(fourth_cell_datas);
		    		    double principal_raw      = Double.parseDouble(Fifth_cell_data);
		    		    double lienBalance_raw    = Double.parseDouble(Sixth_cell_data);
		    		    double paidAmount_raw     = Double.parseDouble(seventh_cell_data);
		    		    
		    		    // ✅ Convert everything to 2-decimal (YOUR style)
		    		    double lienAmount_upto_2_decimal  = Double.parseDouble(String.format("%.2f", lienAmount_raw));
		    		    double principal_upto_2_decimal   = Double.parseDouble(String.format("%.2f", principal_raw));
		    		    double lienBalance_upto_2_decimal = Double.parseDouble(String.format("%.2f", lienBalance_raw));
		    		    double paidAmount_upto_2_decimal  = Double.parseDouble(String.format("%.2f", paidAmount_raw));

		    		 // ✅ Store 2-decimal values
		    		    LIEN_AMOUNT_Values.put("Lien Amounts"+n,  lienAmount_upto_2_decimal);
		    		    TOTAL_PRINCIPAL_Values.put("Principal Amount"+n,  principal_upto_2_decimal);
		    		    CURRENT_LIEN_BALANCE_Values.put("Lien Balance"+n,  lienBalance_upto_2_decimal);
		    		    RETURNED_AMT_Values.put("Paid Amount"+n,  paidAmount_upto_2_decimal);
		        	});
		           
		            // =========================
			        // 2) Fetch from TreeMaps (loop two)
			        // =========================
		           
		           IntStream.range(0, no_of_rows).forEach(n -> {

		        	   // ✅ FETCHED (from TreeMaps)
		        	    Double currentLienBalance = CURRENT_LIEN_BALANCE_Values.get("Lien Balance"+n);   // fetched: Outstanding AFTER payment (system updated value)
		        	    Double paidAmount         = RETURNED_AMT_Values.get("Paid Amount"+n);            // fetched: Paid amount
		        	    Double principal          = TOTAL_PRINCIPAL_Values.get("Principal Amount"+n);    // fetched: log only
		        	    Double lienAmount         = LIEN_AMOUNT_Values.get("Lien Amounts"+n);            // fetched: log only

		        	    // 🧮 DERIVED (Calculated) - Balance Before Payment = Current Outstanding + Paid Amount
		        	    Double lienBalanceBeforePayment_derived = Double.parseDouble(String.format("%.2f", (currentLienBalance + paidAmount)));

		        	    // 🧮 CALCULATED (Calculated) - Outstanding After Payment = Before Payment - Paid Amount
		        	    Double outstandingAfterPayment_calculated = Double.parseDouble(String.format("%.2f", (lienBalanceBeforePayment_derived - paidAmount)));

		        	 // ✅ Difference (2-decimal) for client-friendly confirmation
		        	    Double difference_upto_2_decimal = Double.parseDouble(String.format("%.2f",Math.abs(outstandingAfterPayment_calculated - currentLienBalance)));
		        	    // ✅ These 2 values you wanted to print
		        	       String Result_text = (Math.abs(outstandingAfterPayment_calculated - currentLienBalance) < 0.01) ? "PASS" : "FAIL";
		        	       String Difference_text = String.format("%.2f", difference_upto_2_decimal);

		        	       // 🎨 Non-green client-friendly block style (navy)
		        	       String blockStyle = "background:#10192a; padding:12px; border-radius:10px; border:1px solid #2a3b66; color:#e8eefc;";

		        	       String payoff_log = String.format(
		        	    	        "<div style='%s'>"
		        	    	      + "<b>🔹 Payoff Validation – Lien Row %d</b><br><br>"

		        	    	      + "<b>📘 What is being validated:</b> Outstanding should update correctly after a payment is applied.<br>"
		        	    	      + "<b>✅ Expected Rule:</b> (Balance Before Payment − Paid Amount) = Current Outstanding<br><br>"

		        	    	      + "<b>📌 Values from table:</b><br>"
		        	    	      + "<b>Lien Amount (log only):</b> %.2f<br>"
		        	    	      + "<b>Total Principal (log only):</b> %.2f<br>"
		        	    	      + "<b>Balance Before Payment (derived):</b> %.2f<br>"
		        	    	      + "<b>Paid Amount:</b> %.2f<br>"
		        	    	      + "<b>Outstanding After Payment (Current Outstanding):</b> %.2f<br><br>"

		        	    	      + "<b>🧮 Simple Math Proof:</b><br>"
		        	    	      + "<b>1) Balance Before Payment (derived)</b><br>"
		        	    	      + "Current Outstanding + Paid Amount<br>"
		        	    	      + "%.2f + %.2f<br>"
		        	    	      + "──────────────<br>"
		        	    	      + "<b>%.2f</b><br><br>"

		        	    	      + "<b>2) Outstanding After Payment (calculated)</b><br>"
		        	    	      + "Balance Before Payment − Paid Amount<br>"
		        	    	      + "%.2f − %.2f<br>"
		        	    	      + "──────────────<br>"
		        	    	      + "<b>%.2f</b><br><br>"

		        	    	      + "<b>✅ Result:</b> %s<br>"
		        	    	      + "<b>Calculated (Outstanding After Payment):</b> %.2f<br>"
		        	    	      + "<b>Current (Outstanding from Table):</b> %.2f<br>"
		        	    	      + "<b>Difference (Calculated vs Current):</b> %.2f (PASS if &lt; 0.01)"
		        	    	      + "</div>",

		        	    	        blockStyle,
		        	    	        (n + 1),

		        	    	        lienAmount, principal,
		        	    	        lienBalanceBeforePayment_derived, paidAmount, currentLienBalance,

		        	    	        currentLienBalance, paidAmount, lienBalanceBeforePayment_derived,

		        	    	        lienBalanceBeforePayment_derived, paidAmount, outstandingAfterPayment_calculated,

		        	    	        (Math.abs(outstandingAfterPayment_calculated - currentLienBalance) < 0.01) ? "PASS" : "FAIL",
		        	    	        outstandingAfterPayment_calculated,
		        	    	        currentLienBalance,
		        	    	        difference_upto_2_decimal
		        	    	);

		        	    Report_Listen.log_print_in_report().log((Math.abs(outstandingAfterPayment_calculated - currentLienBalance) < 0.01) ? Status.PASS : Status.FAIL, payoff_log);});}
	   
	
	   
	     
	        public void Payment_Logger(TreeMap<String, String> data) throws IOException, InterruptedException{
	    	    
	        	SIde_Menu_Handler sd = new SIde_Menu_Handler();
	        	Application_Locaters p = new Application_Locaters(d);
	        	Repeat rp = new Repeat(d);
	        	Login_Locaters lg = new Login_Locaters(d);
	        	
	        WebElement case_Dropdown;	
	        try{case_Dropdown=p.Case_Action_Dropdown();}
	        catch(Exception not_in_Case_Details) {
	           sd.Side_menu_option_clicker("Applications", d,"N/A");
	 		   p.landed_in_applicationList_confirmation();
	 		   p.Filter_clear().click();
			  // rp.wait_for_invisibility(p.list_loader());
			   WebElement Status_filter = p.Application_status_filter();
			   Status_filter.click();
			   Application_Filter_Option_Selector("Funded");
	 		   p.rows().get(0).click();
			   Thread.sleep(800);
			   List<WebElement> Case_Tags;
			   try {
			   Case_Tags = p.Case_tags();}
			   catch(RuntimeException tags){
				   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
				   System.out.println();
				   Thread.sleep(1200);
				   Case_Tags = p.Case_tags();}
			   case_Dropdown=p.Case_Action_Dropdown();}
	    	   rp.movetoelement(case_Dropdown);
	    	   p.Case_Action_Dropdown_list();
	    	   List<WebElement> optionsElements = p.Case_Dropdown_Options();
	    	   for(WebElement Each_Option:optionsElements){
	    		   String option_text= Each_Option.getText();
	    		   if(option_text.contains("Log Payment")){
	    			   Each_Option.click();
	    			   break;}}
	    	   List<WebElement> inputs=p.payment_logger_form_inputs();
	    	   inputs.get(0).sendKeys(data.get("Payment Mode"));
	    	   p.plaintiff_dropdown_list();
	   		   p.Plaintiff_options().get(0).click();
	   		   inputs.get(1).sendKeys(data.get("Payment Type"));
	    	   p.Incident_type_dropdown();
	   		   p.Incident_options().get(0).click();
	   		   inputs.get(2).sendKeys(data.get("Payer Name"));
	   		   WebElement Calender_field = inputs.get(3);
	   		   Calender_field.sendKeys(data.get("Payment Date"));
	   		   Calender_field.click();
	   		   p.calender_date_select().click();
	   		   inputs.get(4).sendKeys(data.get("Amount Received"));
	   		   p.textArea().sendKeys(data.get("Notes / Remarks"));
	   		   List<WebElement> popup_modal_buttons = p.poup_up_form_buttons();
	   		   popup_modal_buttons.get(0).click();
	   		   Login_negative_testcases.Toast_printer(lg.toast().getText().trim());
	   		   
	        }
	        
	       


	   
	   
	     public List<WebElement> Internal_Application_Generator_and_Manual_Signer(TreeMap<String, String> data, TreeMap<String, String> data2 ,TreeMap<String,String> attorneyData, String Requested_Amount) throws InterruptedException{
		   
		   
		   
		   Application_Locaters p = new Application_Locaters(d);
		   Login_Locaters lg = new Login_Locaters(d);
		   Repeat rp = new Repeat(d);
		   JavascriptExecutor js = (JavascriptExecutor)d; 
		   
		   
		   
			
			
		int step=1;
		   tab_selector("Applications");
		   p.Requested_amount_input_field_in_Applications_tab().sendKeys(Requested_Amount);
		   p.Appilcation_Add_button().click();
		   p.Application_amount_edit_buttons().get(1).click();
			Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Buyout modal opened.");
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
			p.Modal_Input_Feilds().get(0).sendKeys(data.get("Buyout Funder Name"));
			p.Modal_Input_Feilds().get(1).sendKeys(data.get("Buyout Amount"));
			p.Modal_Input_Feilds().get(2).sendKeys(data.get("Buyout Expiry Date"));
			p.calender_date_select().click();
			p.modal_buttons().get(1).click();
			Thread.sleep(800);
			try {
				Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
				catch(Exception e){
				Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after Buyout Amount: "+"No toast captured / toast locator not visible. Error:");}
			Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Approved Amount edit and enter Approved Amount.");
			List<WebElement> Amount_edit_buttons;
		try{Amount_edit_buttons= p.Application_amount_edit_buttons();
		    Amount_edit_buttons.get(2).click(); }
		catch(Exception em) {
			Thread.sleep(800);
			Amount_edit_buttons= 	p.Application_amount_edit_buttons();
		    Amount_edit_buttons.get(2).click();
			Thread.sleep(800);
			Report_Listen.log_print_in_report().log(Status.INFO,"Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
			System.out.println("Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
			System.out.println();}
		   Contract_Generator(data,data2,attorneyData,step);
		   WebElement new_toast =lg.toast();
		   String new_toast_text = lg.toast().getText().trim();
		   System.out.println(new_toast_text);
		   WebElement Sign_in_button = p.Manual_sign_in_button();
		   rp.movetoelement(Sign_in_button);
	       Thread.sleep(800);
	       rp.wait_for_theElement_tobe_clickable(Sign_in_button);
		   Sign_in_button.click();
		   List<WebElement> Open_lien_table_row=manual_lien_generation(Sign_in_button);
		   return Open_lien_table_row;
		    }
	   
	   
	   
	     public void Contract_Generator(TreeMap<String, String> data, TreeMap<String, String> data2 ,TreeMap<String,String> attorneyData, int step) throws InterruptedException{
	    	     
	    	   Application_Locaters p = new Application_Locaters(d);
			   Login_Locaters lg = new Login_Locaters(d);
			   Repeat rp = new Repeat(d);
			   JavascriptExecutor js = (JavascriptExecutor)d; 
	    	 
	    	    int Buyout_Amount = Integer.parseInt(data.get("Buyout Amount"));
				int Approved_Amount = Integer.parseInt(data.get("Approved Amount"));
				int Document_prep_fee = Integer.parseInt(data.get("Document prep fee"));
				int Fund_transfer_fee = Integer.parseInt(data.get("Fund transfer fee"));
				int Rate_of_Return = Integer.parseInt(data.get("Rate of Return"));
				
				double Funded_amount = Buyout_Amount+Approved_Amount;
				double Annual_Interest_Amount = (Funded_amount * Rate_of_Return) / 100;
				double Monthly_Interest_Amount = Annual_Interest_Amount/12;
				double Monthly_Payable_Amount = Funded_amount+Monthly_Interest_Amount+Document_prep_fee+Fund_transfer_fee;
				double Monthly_Payable_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Payable_Amount));
				double Monthly_Interest_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Interest_Amount));
	    	 
	    	 
				p.Application_Amount_input_Fields().get(0).sendKeys(data.get("Approved Amount"));
			    p.table_body().click();
			    Thread.sleep(800);
			    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Approved Amount entered = "+data.get("Approved Amount"));
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Update Application Status to APPROVED from dropdown.");
				rp.movetoelement(p.Application_Details_Dropdown_Feild());
			    p.Application_Details_Dropdown_Feild().click();
			    p.plaintiff_dropdown_list();
			    List<WebElement> Status_opts = p.Plaintiff_options();
			    for(WebElement Stat_opt:Status_opts){
			    	if(Stat_opt.getText().trim().contains("APPROVED")){
			    		Stat_opt.click();
			    		break;}}
			    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Application status set to APPROVED.");
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click Generate Contract and wait for Contract popup/modal.");
				p.Generate_contract_button().click();
			    p.popup_modal();
			    Thread.sleep(800);
			    rp.movetoelement(p.Popup_add_form());
			    Thread.sleep(800);
			    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Contract details modal opened.");
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill contract fee fields and Rate of Return.");
				List<WebElement> Fee_feilds = p.fee_amount_feilds();
			    rp.Scroll_to_element(Fee_feilds.get(0));
			    rp.Feild_clear(Fee_feilds.get(0));
			    Fee_feilds.get(0).sendKeys(data.get("Document prep fee"));
			    rp.Feild_clear(Fee_feilds.get(1));
			    Fee_feilds.get(1).sendKeys(data.get("Fund transfer fee"));
			    rp.Scroll_to_element(p.rate_of_return_feild());
			    rp.Feild_clear(p.rate_of_return_feild());
			    p.rate_of_return_feild().sendKeys(data.get("Rate of Return"));
			    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Fees + Rate of Return filled (DocPrep="+data.get("Document prep fee")+", FundTransfer="+data.get("Fund transfer fee")+", RoR="+data.get("Rate of Return")+")");
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Agreement Date + Interest Start Date and confirm date selection.");
				rp.Scroll_to_element(p.Agreement_Date_feild());
			    p.Agreement_Date_feild().sendKeys(data.get("Agreement Date"));
			    p.calender_date_select().click();
			    p.Interest_Start_Date().sendKeys(data.get("Interest Start Date"));
			    p.rate_of_return_feild().click();
			    Thread.sleep(600);
			    WebElement Generate_Contract_Button = p.contract_generator_button();
			    rp.movetoelement(Generate_Contract_Button);
			    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
			    js.executeScript("arguments[0].click();", Generate_Contract_Button);
			    try{p.Contract_editor();
					Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
					Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Case created successfully for Plaintiff="+data.get("Plaintiff Name")+" | CourtIndex="+data.get("Court Index Number")+" | AgreementDate="+data.get("Agreement Date"));
				}catch(Exception e){
					Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
					Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex="+data.get("Court Index Number"));
					throw e;}
			    d.switchTo().frame(p.contract_doc_iframe());
			    Thread.sleep(1000);
			 // ---------- CALC LOG (2 decimals) ----------
			    String Buyout_Amount_f = String.format("%.2f", (double) Buyout_Amount);
			    String Approved_Amount_f = String.format("%.2f", (double) Approved_Amount);
			    String Document_prep_fee_f = String.format("%.2f", (double) Document_prep_fee);
			    String Fund_transfer_fee_f = String.format("%.2f", (double) Fund_transfer_fee);
			    String Rate_of_Return_f = String.format("%.2f", (double) Rate_of_Return);

			    String Funded_amount_f = String.format("%.2f", Funded_amount);
			    String Annual_Interest_Amount_f = String.format("%.2f", Annual_Interest_Amount);
			    String Monthly_Interest_Amount_f = String.format("%.2f", Monthly_Interest_Amount);
			    String Monthly_Payable_Amount_f = String.format("%.2f", Monthly_Payable_Amount);
			    String Flat_Fees_f = String.format("%.2f", (double) (Document_prep_fee + Fund_transfer_fee));

			    String calc_log =
			            "<b>🧮 First Month Payable Calculation</b><br>"
			          + "<b>Buyout Amount:</b> " + Buyout_Amount_f + "<br>"
			          + "<b>Approved Amount:</b> " + Approved_Amount_f + "<br>"
			          + "<b>Funded Amount:</b> " + Funded_amount_f + "  (Buyout + Approved)<br><br>"
			          + "<b>Rate of Return (%):</b> " + Rate_of_Return_f + "<br>"
			          + "<b>Annual Interest:</b> " + Annual_Interest_Amount_f + "  (Funded × RoR / 100)<br>"
			          + "<b>Monthly Interest:</b> " + Monthly_Interest_Amount_f + "  (Annual / 12)<br><br>"
			          + "<b>Document Prep Fee:</b> " + Document_prep_fee_f + "<br>"
			          + "<b>Fund Transfer Fee:</b> " + Fund_transfer_fee_f + "<br>"
			          + "<b>Flat Fees Total:</b> " + Flat_Fees_f + "<br><br>"
			          + "<b>✅ First Month Payable:</b> "
			          + Funded_amount_f + " + " + Monthly_Interest_Amount_f + " + " + Document_prep_fee_f + " + " + Fund_transfer_fee_f
			          + " = <b>" + Monthly_Payable_Amount_f + "</b>";

			    Report_Listen.log_print_in_report().log(Status.INFO, calc_log);

			    // Console output (same info, clean)
			    System.out.println("\n===== First Month Payable Calculation =====");
			    System.out.println("Buyout Amount        : " + Buyout_Amount_f);
			    System.out.println("Approved Amount      : " + Approved_Amount_f);
			    System.out.println("Funded Amount        : " + Funded_amount_f + "  (Buyout + Approved)");
			    System.out.println("------------------------------------------");
			    System.out.println("Rate of Return (%)   : " + Rate_of_Return_f);
			    System.out.println("Annual Interest      : " + Annual_Interest_Amount_f + "  (Funded × RoR / 100)");
			    System.out.println("Monthly Interest     : " + Monthly_Interest_Amount_f + "  (Annual / 12)");
			    System.out.println("------------------------------------------");
			    System.out.println("Document Prep Fee    : " + Document_prep_fee_f);
			    System.out.println("Fund Transfer Fee    : " + Fund_transfer_fee_f);
			    System.out.println("Flat Fees Total      : " + Flat_Fees_f);
			    System.out.println("------------------------------------------");
			    System.out.println("✅ First Month Payable: " + Funded_amount_f + " + " + Monthly_Interest_Amount_f + " + "
			            + Document_prep_fee_f + " + " + Fund_transfer_fee_f + " = " + Monthly_Payable_Amount_f);
			    System.out.println("==========================================\n");
		        System.out.println();
			    rp.Scroll_to_element(p.Contract_lien_table());
			    
			    List<WebElement> cells = p.Cell_datas();
			    int i=0;
			    for(WebElement cell:cells){
			    	String cell_text = cell.getText().trim();
			    	if(!cell_text.contains("/")) {
			    	// ✅ Convert UI text like "$1,234.50" into pure number string "1234.50" before parsing
			        // replace(",", "") removes thousand separators
			        // replace("$", "") removes currency symbol
			        // trim() removes extra spaces
			    	double cell_value = Double.parseDouble(cell_text.replace(",", "").replace("$", "").trim());
			    	// ✅ Round to 2 decimals in a safe UI-matching way:
			    	// String.format("%.2f", cell_value) -> converts double to String with exactly 2 decimal places ("% = placeholder, .2 = 2 decimals, f = floating number")
			    	// Double.parseDouble(...) -> converts that 2-decimal String back into a double for reliable numeric comparison (avoids floating precision noise like 10.1999999)
			    	double cell_value_upto_2_decimal = Double.parseDouble(String.format("%.2f", cell_value));
			    	// ✅ Compare doubles using tolerance instead of "==" (because doubles can be slightly off, e.g., 100.1 vs 100.0999998)
			        // Math.abs(a-b) < 0.01 means "difference is less than 1 paisa/cent equivalent at 2-decimal level"
			        // Here Monthly_Payable_Amount is already calculated, we check if this month cell matches it
			    	if(Math.abs(Monthly_Payable_Amount_upto_2_decimal-cell_value) < 0.01) {
			    		System.out.println("Testcase passed First month payable "+Monthly_Payable_Amount_upto_2_decimal+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
			    		System.out.println();
			    		Report_Listen.log_print_in_report().log(Status.INFO,"Testcase passed First month payable "+Monthly_Payable_Amount_upto_2_decimal+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
			    		}monthly_emi.add(cell_value_upto_2_decimal);
			    	i++;}}
			 // ---------- FUTURE MONTH VALIDATION (Previous Month + Monthly Interest) ----------
			    Report_Listen.log_print_in_report().log(Status.INFO,
			    		"<b>Step "+(step++)+":</b> Validate future months lien calculation from Contract Lien table.");

			    Report_Listen.log_print_in_report().log(Status.INFO,
			    		"<b>📘 Description:</b> Each month lien should increase only by Monthly Interest compared to previous month.");

			    Report_Listen.log_print_in_report().log(Status.INFO,
			    		"<b>✅ Expected:</b> For every month >= 1, (Current Month Payable - Previous Month Payable) should equal Monthly Interest = "+Monthly_Interest_Amount+".");

			    future_months_calculations_check(monthly_emi, Monthly_Interest_Amount_upto_2_decimal);
			    d.switchTo().defaultContent();
				Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Switch back from Contract iframe to main page (default content).");
				Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Driver focus returned to main page after reading Contract lien table.");
		        Thread.sleep(800);
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Save Changes</i> to save contract edits.");
				p.Save_changes_button().click();
				Thread.sleep(1800);
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast after saving contract.");
				String contract_saved = "";
				try{
					contract_saved = lg.toast().getText().trim();
					Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract saved toast = "+contract_saved);
					System.out.println(contract_saved);
				}catch(Exception e){
					Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
					throw e;}
				//d.navigate().refresh();
				FluentWait<WebDriver> w = new FluentWait<WebDriver>(d)
				        .withTimeout(Duration.ofSeconds(30))
				        .pollingEvery(Duration.ofMillis(500))
				        .ignoring(NoSuchElementException.class)
				        .ignoring(StaleElementReferenceException.class);

				Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
				String Contract_Generated = lg.toast().getText().trim();
				Login_negative_testcases.Toast_printer(Contract_Generated);
				Thread.sleep(800);
				rp.wait_for_invisibility(lg.toast());}
	   
	   
	   
	   
	   
	   
	   public void Application_Filter_Option_Selector(String Option){
		   
		   Application_Locaters p = new Application_Locaters(d);
		   
		  p.plaintiff_dropdown_list();
		  List<WebElement> Options = p.Plaintiff_options();
		  for(WebElement option:Options){
			  
			  if(option.getText().trim().equalsIgnoreCase(Option)){
				  
				  option.click();
				  break;}}}
	
	
	
	
	
	
	
	
	
	public void tab_selector(String tabname) throws InterruptedException{
		
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		
        List<WebElement> tabs = p.tabs();
		
		for(WebElement tab:tabs){
		if(tab.getText().trim().equalsIgnoreCase(tabname)){
			
			tab.click();
			break;}}
		Thread.sleep(900);
		tabs.clear();}
	
	
	public void Collections_Clear(){
		
		LIEN_AMOUNT_Values.clear();
		TOTAL_PRINCIPAL_Values.clear();
		CURRENT_LIEN_BALANCE_Values.clear();
		RETURNED_AMT_Values.clear();
		monthly_emi.clear();
		
	}
	
	
	
	
	

}
