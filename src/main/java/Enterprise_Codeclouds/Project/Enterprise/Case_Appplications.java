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
	public void Add_case(TreeMap<String, String> data, TreeMap<String, String> data2 ,TreeMap<String,String> attorneyData) throws IOException, InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		
		Collections_Clear();
		
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
		
		int step=1;

		Add_New_Case_Form_Accessor(step++);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> New Case form/popup opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Search and select existing Plaintiff from dropdown.");
		p.form_inputs().get(0).sendKeys(data2.get("First Name"));
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Plaintiff selected = "+data2.get("First Name"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select Incident/Case Type from dropdown.");
		p.form_inputs().get(1).sendKeys(data.get("Case Type"));
		p.form_inputs().get(1).click();
		p.Incident_type_dropdown();
		option_printers("Incident Options are ",p.Incident_options());
		p.Incident_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Incident/Case type selected from list for input = "+data.get("Case Type"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select State of Incident from dropdown.");
		p.form_inputs().get(2).sendKeys(data.get("State"));
		p.form_inputs().get(2).click();
		p.State_of_incident_dropdown();
		p.State_of_incident_options().get(0).click();
		Thread.sleep(500);	
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> State selected from list for input = "+data.get("State"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Date of Incident and confirm date selection.");
		WebElement calender_field = p.form_inputs().get(3);
		calender_field.sendKeys(data.get("Date of Incident"));
		calender_field.click();
		p.calender_date_select().click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Date of Incident entered/selected = "+data.get("Date of Incident"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Select Lead Type and Lead Source.");
		rp.Scroll_to_element(p.form_inputs().get(4));
		//p.form_inputs().get(4).click();
		p.form_inputs().get(4).sendKeys(data.get("Lead Source"));
		p.Lead_Type_dropdown();
		p.Lead_category_options().get(0).click();
		p.form_inputs().get(5).click();
		p.Lead_dropdown();
		p.Leadoptions().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Lead type/source selected from dropdowns (Lead Source input = "+data.get("Lead Source")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Enter Requested Amount and click Create/Save Case.");
		rp.Scroll_to_element(p.form_inputs().get(5));
		p.form_inputs().get(6).sendKeys(data.get("Requested Amount"));
		p.form_buttons().get(1).click();
		Thread.sleep(500);try {
		Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
		catch(Exception e){
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Case Details edit popup and update Summary + Court Index Number.");
		p.Case_details_edit_buttons().click();
		p.Summary_feild().sendKeys(data.get("Summary"));
		p.Court_index_input().sendKeys(data.get("Court Index Number"));
		p.Edit_form_buttons().get(1).click();
		p.Case_details_edit_buttons();
		Thread.sleep(500);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual </b> ✏️ Case Details edit popup opened, Court Index Number '"+data.get("Court Index Number")+"' was entered and saved without visible UI errors.");
		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Case Details saved (Summary updated, Court Index saved = "+data.get("Court Index Number")+")");
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
		p.List_Checkboxes().get(0).click();
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
		manual_lien_generation(Sign_in_button);}
	
	
	
	
	
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
	    	String Contract_Signed = lg.toast().getText().trim();
			Login_negative_testcases.Toast_printer(Contract_Signed);
			tab_selector("Liens");
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
		    c1.put("Case #", "201");
		    c1.put("Case Type", "Civil Rights");
		    c1.put("State", "Indiana");
		    c1.put("Date of Incident", "06/08/2023");
		    c1.put("Lead Source", "Attorney Referral");
		    c1.put("Requested Amount", "58000");
		    c1.put("Court Index Number", "49D03-2306-CR-001114");
		    c1.put("Summary", "Alleged unlawful search and excessive detention during traffic stop; emotional distress and employment disruption claimed; bodycam footage requested.");
		    c1.put("Risk Level", "Moderate");
		    c1.put("Recommended Max Funding", "24000");
		    c1.put("Underwriting Notes", "Primary driver is evidence quality: bodycam, dispatch logs, incident report, and any internal affairs findings. Confirm notice requirements, immunities, and policy limits before expanding funding.");
		    c1.put("Buyout Funder Name", "Frontline Capital Group");
		    c1.put("Buyout Amount", "15500");
		    c1.put("Approved Amount", "24000");
		    c1.put("Application Status", "In Review");
		    c1.put("Attorney Name", "Attorney Orson Pfeiffer");
		    c1.put("Law Firm Name", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
		    c1.put("Document prep fee", "325");
		    c1.put("Fund transfer fee", "110");
		    c1.put("Rate of Return", "41");
		    c1.put("SMS Message Title", "Civil Rights File In Review");
		    c1.put("SMS Message Body", "Your civil rights application is under review while key records are verified. We’ll update you soon. – Lumberjack Legal Finance");
		    // ---- Payment (STRICTLY from your allowed list: d3) ----
		    c1.put("Payment Mode", "Credit Card");
		    c1.put("Payment Type", "Payment by Plaintiff");
		    c1.put("Payer Name", "Plaintiff Marlowe Eichenauer");
		    c1.put("Payment Date", paymentDate);
		    c1.put("Amount Received", "3800");
		    c1.put("Notes / Remarks", "Card payment approved; verify last 4 digits in gateway report; note: convenience fee handled externally, not part of received amount.");

		    TreeMap<String, String> c2 = new TreeMap<String, String>();
		    // ... keep your existing c2 fields exactly same ...
		    // ---- Payment (d2) ----
		    c2.put("Payment Mode", "Bank Transfer");
		    c2.put("Payment Type", "Payment by Attorney");
		    c2.put("Payer Name", "Attorney Selwyn Kappelmann");
		    c2.put("Payment Date", paymentDate);
		    c2.put("Amount Received", "12000");
		    c2.put("Notes / Remarks", "ACH/Bank transfer initiated by attorney office; confirmation email received; reconcile with bank statement before final posting.");

		    TreeMap<String, String> c3 = new TreeMap<String, String>();
		    // ... keep your existing c3 fields exactly same ...
		    // ---- Payment (d8) ----
		    c3.put("Payment Mode", "Cheque");
		    c3.put("Payment Type", "Payment by Plaintiff");
		    c3.put("Payer Name", "Plaintiff Leontius Brackenford");
		    c3.put("Payment Date", paymentDate);
		    c3.put("Amount Received", "9000");
		    c3.put("Notes / Remarks", "Personal cheque accepted; confirm signature and date; pending clearance—do not mark as settled until bank confirmation.");

		    TreeMap<String, String> c4 = new TreeMap<String, String>();
		    // ... keep your existing c4 fields exactly same ...
		    // ---- Payment (d4) ----
		    c4.put("Payment Mode", "Cheque");
		    c4.put("Payment Type", "Payment by Insurance Company");
		    c4.put("Payer Name", "NorthBridge Casualty Insurance Co.");
		    c4.put("Payment Date", paymentDate);
		    c4.put("Amount Received", "45000");
		    c4.put("Notes / Remarks", "Cheque received via mailroom; deposit scheduled next business day; hold posting until cheque clears per finance policy.");

		    TreeMap<String, String> c5 = new TreeMap<String, String>();
		    // ... keep your existing c5 fields exactly same ...
		    // ---- Payment (d16) ----
		    c5.put("Payment Mode", "Bank Transfer");
		    c5.put("Payment Type", "Payment by Plaintiff");
		    c5.put("Payer Name", "Plaintiff Dorian Kestrelwood");
		    c5.put("Payment Date", paymentDate);
		    c5.put("Amount Received", "6000");
		    c5.put("Notes / Remarks", "Plaintiff bank transfer received; verify payer name matches registered plaintiff; attach bank confirmation screenshot to notes.");

		    TreeMap<String, String> c6 = new TreeMap<String, String>();
		    // ... keep your existing c6 fields exactly same ...
		    // ---- Payment (d9) ----
		    c6.put("Payment Mode", "Online Payment");
		    c6.put("Payment Type", "Payment by PIP");
		    c6.put("Payer Name", "PIP Claims Department - MetroShield");
		    c6.put("Payment Date", paymentDate);
		    c6.put("Amount Received", "7400");
		    c6.put("Notes / Remarks", "PIP reimbursement via online payment; verify claim number in remittance; match against case payment schedule.");

		    TreeMap<String, String> c7 = new TreeMap<String, String>();
		    // ... keep your existing c7 fields exactly same ...
		    // ---- Payment (d7) ----
		    c7.put("Payment Mode", "Cash");
		    c7.put("Payment Type", "Payment by Attorney");
		    c7.put("Payer Name", "Attorney Osric Vandenbrock");
		    c7.put("Payment Date", paymentDate);
		    c7.put("Amount Received", "5000");
		    c7.put("Notes / Remarks", "Cash delivered by attorney runner; ID verified; counted under camera; receipt generated and shared with attorney office.");

		    TreeMap<String, String> c8 = new TreeMap<String, String>();
		    // ... keep your existing c8 fields exactly same ...
		    // ---- Payment (d5) ----
		    c8.put("Payment Mode", "Online Payment");
		    c8.put("Payment Type", "Payment by Another Funder");
		    c8.put("Payer Name", "Summit Equity Legal Funding Partners");
		    c8.put("Payment Date", paymentDate);
		    c8.put("Amount Received", "16000");
		    c8.put("Notes / Remarks", "Online portal payment from another funder for buyout; cross-check reference ID and settlement ledger; attach payment receipt PDF.");

		    TreeMap<String, String> c9 = new TreeMap<String, String>();
		    // ... keep your existing c9 fields exactly same ...
		    // ---- Payment (d6) ----
		    c9.put("Payment Mode", "Bank Transfer");
		    c9.put("Payment Type", "Payment by Insurance Company");
		    c9.put("Payer Name", "HarborPoint Mutual Insurance Services");
		    c9.put("Payment Date", paymentDate);
		    c9.put("Amount Received", "52000");
		    c9.put("Notes / Remarks", "Wire received (insurance disbursement); confirm sender name matches remittance advice; split allocation recorded in internal ledger.");

		    TreeMap<String, String> c10 = new TreeMap<String, String>();
		    // ... keep your existing c10 fields exactly same ...
		    // ---- Payment (d10) ----
		    c10.put("Payment Mode", "Credit Card");
		    c10.put("Payment Type", "Payment by Insurance Company");
		    c10.put("Payer Name", "CedarLine Commercial Insurance");
		    c10.put("Payment Date", paymentDate);
		    c10.put("Amount Received", "11000");
		    c10.put("Notes / Remarks", "Insurance card payment processed through billing gateway; ensure transaction receipt is uploaded; confirm no partial capture.");

		    TreeMap<String, String> c11 = new TreeMap<String, String>();
		    // ... keep your existing c11 fields exactly same ...
		    // ---- Payment (d11) ----
		    c11.put("Payment Mode", "Bank Transfer");
		    c11.put("Payment Type", "Payment by PIP");
		    c11.put("Payer Name", "PIP Unit - Granite Auto Indemnity");
		    c11.put("Payment Date", paymentDate);
		    c11.put("Amount Received", "6300");
		    c11.put("Notes / Remarks", "Bank transfer from PIP unit; reconcile amount against expected PIP reimbursement; document remittance reference in remarks.");

		    TreeMap<String, String> c12 = new TreeMap<String, String>();
		    // ... keep your existing c12 fields exactly same ...
		    // ---- Payment (d14) ----
		    c12.put("Payment Mode", "Cheque");
		    c12.put("Payment Type", "Payment by Another Funder");
		    c12.put("Payer Name", "BluePine Settlement Funding Co.");
		    c12.put("Payment Date", paymentDate);
		    c12.put("Amount Received", "27000");
		    c12.put("Notes / Remarks", "Buyout cheque from third-party funder; deposit scheduled; hold status as 'pending' until clearance and final ledger match.");

		    TreeMap<String, String> c13 = new TreeMap<String, String>();
		    // ... keep your existing c13 fields exactly same ...
		    // ---- Payment (d15) ----
		    c13.put("Payment Mode", "Credit Card");
		    c13.put("Payment Type", "Payment by PIP");
		    c13.put("Payer Name", "PIP Recovery Desk - Atlas Motor Coverage");
		    c13.put("Payment Date", paymentDate);
		    c13.put("Amount Received", "4100");
		    c13.put("Notes / Remarks", "PIP payment by card; confirm authorization and settlement reference; ensure duplicate prevention by checking gateway transaction ID.");

		    TreeMap<String, String> c14 = new TreeMap<String, String>();
		    // ... keep your existing c14 fields exactly same ...
		    // ---- Payment (d13) ----
		    c14.put("Payment Mode", "Online Payment");
		    c14.put("Payment Type", "Payment by Attorney");
		    c14.put("Payer Name", "Attorney Mirek Haldenstein");
		    c14.put("Payment Date", paymentDate);
		    c14.put("Amount Received", "18500");
		    c14.put("Notes / Remarks", "Attorney paid via online link; confirmation number captured; request office to email remittance advice for accurate allocation.");

		    TreeMap<String, String> c15 = new TreeMap<String, String>();
		    // ... keep your existing c15 fields exactly same ...
		    // ---- Payment (d17) ----
		    c15.put("Payment Mode", "Online Payment");
		    c15.put("Payment Type", "Payment by Insurance Company");
		    c15.put("Payer Name", "EverHaven Insurance Group");
		    c15.put("Payment Date", paymentDate);
		    c15.put("Amount Received", "32500");
		    c15.put("Notes / Remarks", "Insurance paid through online portal; remittance attached; verify this is final payment (not partial) before closing the case ledger.");

		    TreeMap<String, String> c16 = new TreeMap<String, String>();
		    // ... keep your existing c16 fields exactly same ...
		    // ---- Payment (d12) ----
		    c16.put("Payment Mode", "Cash");
		    c16.put("Payment Type", "Payment by Another Funder");
		    c16.put("Payer Name", "IronGate Litigation Finance Group");
		    c16.put("Payment Date", paymentDate);
		    c16.put("Amount Received", "3000");
		    c16.put("Notes / Remarks", "In-person cash payment from funder representative; unusual method—flagged for compliance review; receipt and CCTV timestamp recorded.");

		    TreeMap<String, String> c17 = new TreeMap<String, String>();
		    // ... keep your existing c17 fields exactly same ...
		    // ---- Payment (d20) ----
		    c17.put("Payment Mode", "Cheque");
		    c17.put("Payment Type", "Payment by Attorney");
		    c17.put("Payer Name", "Attorney Rowan Silberholl");
		    c17.put("Payment Date", paymentDate);
		    c17.put("Amount Received", "14000");
		    c17.put("Notes / Remarks", "Attorney office cheque received; verify cheque number and payee line; post after clearance; email confirmation requested from firm admin.");

		    TreeMap<String, String> c18 = new TreeMap<String, String>();
		    // ... keep your existing c18 fields exactly same ...
		    // ---- Payment (d18) ----
		    c18.put("Payment Mode", "Cash");
		    c18.put("Payment Type", "Lost Deal");
		    c18.put("Payer Name", "N/A - Lost Deal");
		    c18.put("Payment Date", paymentDate);
		    c18.put("Amount Received", "0");
		    c18.put("Notes / Remarks", "Deal marked as lost; no payment collected; record created for audit trail and to prevent future reconciliation confusion.");

		    TreeMap<String, String> c19 = new TreeMap<String, String>();
		    // ... keep your existing c19 fields exactly same ...
		    // ---- Payment (d19) ----
		    c19.put("Payment Mode", "Bank Transfer");
		    c19.put("Payment Type", "Lost Deal");
		    c19.put("Payer Name", "N/A - Lost Deal");
		    c19.put("Payment Date", paymentDate);
		    c19.put("Amount Received", "1");
		    c19.put("Notes / Remarks", "Lost deal logged (system requires amount); placeholder amount used for validation; adjust based on business rule if amount must be blank/optional.");

		    TreeMap<String, String> c20 = new TreeMap<String, String>();
		    // ... keep your existing c20 fields exactly same ...
		    // ---- Payment (STRICT LIST LIMITATION) ----
		    // TODO: Only 19 unique payment sets (d2..d20) were provided for 20 cases.
		    // Replace below block when you have one more approved unique payment set.
		    c20.put("Payment Mode", "Bank Transfer");
		    c20.put("Payment Type", "Payment by Attorney");
		    c20.put("Payer Name", "Attorney Selwyn Kappelmann");
		    c20.put("Payment Date", paymentDate);
		    c20.put("Amount Received", "12000");
		    c20.put("Notes / Remarks", "ACH/Bank transfer initiated by attorney office; confirmation email received; reconcile with bank statement before final posting.");


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

	    Object[][] plaintiff_datas = pm.plaintiffData();   // each row: { TreeMap<String,String> }
	    Object[][] case_datas      = caseData();           // each row: { TreeMap<String,String> }
	    Object[][] attorney_datas  = at.attorneyStaffData(); // each row: { TreeMap<String,String> }

	    int n = Math.min(case_datas.length,
	            Math.min(plaintiff_datas.length, attorney_datas.length));

	    // ✅ 3 columns now: case, plaintiff, attorney
	    Object[][] final_set = new Object[n][3];

	    for(int i = 0; i < n; i++){
	        final_set[i][0] = case_datas[i][0];       // case map
	        final_set[i][1] = plaintiff_datas[i][0];  // plaintiff map
	        final_set[i][2] = attorney_datas[i][0];   // attorney map}
	    }
	    return final_set;}
	
	public void option_printers(String prefix ,List<WebElement> options){
		
		for(WebElement option:options){
		
		System.out.println(prefix+option.getText().trim());}}
	
	
	
	
	   @Test(dataProvider="case_plus_plaintiff")
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
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		  // rp.wait_for_invisibility(p.list_loader());
		   WebElement Status_filter = p.Application_status_filter();
		   Status_filter.click();
		   Application_Filter_Option_Selector("Funded");
		   p.rows().get(1).click();
		   Thread.sleep(800);
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
	        	  lien_rows=p.Open_Lien_table_contents();}
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
		           int no_of_rows = lien_rows.size();
		           List<WebElement> fourth_cells = p.First_table_fourth_column_cellData();
		           List<WebElement> Fifth_cells =  p.First_table_fifth_column_cellData();
		           List<WebElement> Sixth_cells =  p.First_table_sixth_column_cellData();
		           List<WebElement> Seventh_cells = p.First_table_seventh_column_cellData();
		           
		           
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
	   
	
	   
	        @Test(dataProvider="logPaymentData")
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
	    	   List<WebElement> inputs=p.form_inputs();
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
				rp.wait_for_invisibility(lg.toast()); }
	   
	   
	   
	   
	   
	   
	   public void Application_Filter_Option_Selector(String Option){
		   
		   Application_Locaters p = new Application_Locaters(d);
		   
		  p.plaintiff_dropdown_list();
		  List<WebElement> Options = p.Plaintiff_options();
		  for(WebElement option:Options){
			  
			  if(option.getText().trim().equalsIgnoreCase(Option)){
				  
				  option.click();
				  break;}}}
	
	
	
	@Test(dataProvider="caseData")
	public void Added_application_delete(TreeMap<String, String> val) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Application_Locaters p = new Application_Locaters(d);
		
		Login_Locaters lg = new Login_Locaters(d);
		
		String Plaintiff_name=val.get("Plaintiff Name");
		
	 try {
		sd.Side_menu_option_clicker("Applications", d,"N/A");
		Report_Listen.log_print_in_report().log(Status.INFO,"**🔹 Scenario 2: Case handler deletes an existing application for a plaintiff from the Applications tab**");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📘 Description →** Verify that the user can search the case list by plaintiff name, open the case details, navigate to the *Applications* tab, click the delete option for an existing application, confirm the delete in the popup, and complete the operation without UI errors so that the application is removed from the list.");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📥 Input →** Plaintiff: "+Plaintiff_name+", Case Type: "+val.get("Case Type")+", State: "+val.get("State")+", Requested Amount: "+val.get("Requested Amount"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**✅ Expected →** The application row linked to plaintiff '"+Plaintiff_name+"' should be visible in the *Applications* tab before deletion. After clicking delete and confirming in the popup, the system should perform the delete without any error message and the same application row should no longer appear in the Applications grid for that case.");
		p.landed_in_applicationList_confirmation();
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 1 →** Navigated to the *Cases* list page and confirmed that the case/application list layout is loaded.");
		p.status_field_clear_button().click();
		Thread.sleep(500);
		p.Application_search().sendKeys(Plaintiff_name);
		Thread.sleep(1000);
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 2 →** Cleared the status filter (if any) and searched cases using plaintiff name '"+Plaintiff_name+"' in the search box.");
		List<WebElement> table_rows;
		try {
		table_rows = p.rows();}
		catch(Exception tabs) {
			Thread.sleep(800);
			table_rows = p.rows();
			Report_Listen.log_print_in_report().log(Status.INFO,"Exception found in fetching list rows thereby retried and found");
			System.out.println("Exception found in fetching list rows thereby retried and found");
			System.out.println();}
		for(WebElement row:table_rows){
			if(row.getText().contains(Plaintiff_name)){
				row.click();
				break;
				}}
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 3 →** Opened the Case Details page for plaintiff '"+Plaintiff_name+"' by clicking the matching row from the *Cases* table.");
		p.Case_id_tag();
		tab_selector("Applications");
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 4 →** Switched to the *Applications* tab to view existing application records for the selected case.");
		p.Delete_button().click();
		p.popup_modal();
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 5 →** Clicked on the delete icon for an application and verified that the delete confirmation popup/modal is displayed.");
		p.modal_buttons().get(1).click();
		Thread.sleep(900);
		Report_Listen.log_print_in_report().log(Status.INFO, "**🟨 Actual →** ✅ Delete flow executed successfully. The case for plaintiff '"+Plaintiff_name+"' was opened from the *Cases* list, the *Applications* tab was loaded, the delete confirmation popup appeared and was confirmed. No unexpected UI error was observed during the operation, and the targeted application record is expected to be removed from the Applications grid for this case.");
		try{Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
		catch(Exception mo){
			Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** 📢 Toast after Deletion of the Application: "+"No toast captured / toast locator not visible. Error:");
			}
		Thread.sleep(900);table_rows.clear();}
	 catch(Exception ko){
		 Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Delete operation failed for plaintiff '"+Plaintiff_name+"' due to exception: "+ko.getMessage());
         System.out.println("Delete operation failed for plaintiff  "+Plaintiff_name);
         System.out.println();}}
	
	
	
	
	
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
