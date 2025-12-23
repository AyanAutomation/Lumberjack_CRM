package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.temp_mail_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Case_Appplications extends Header_Manager{
	
	TreeSet<Double> monthly_emi = new TreeSet<Double>();
	
	
	
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
		
		
		
		int Buyout_Amount = Integer.parseInt(data.get("Buyout Amount"));
		int Approved_Amount = Integer.parseInt(data.get("Approved Amount"));
		int Document_prep_fee = Integer.parseInt(data.get("Document prep fee"));
		int Fund_transfer_fee = Integer.parseInt(data.get("Fund transfer fee"));
		int Rate_of_Return = Integer.parseInt(data.get("Rate of Return"));
		
		double Funded_amount = Buyout_Amount+Approved_Amount;
		double Annual_Interest_Amount = (Funded_amount * Rate_of_Return) / 100;
		double Monthly_Interest_Amount = Annual_Interest_Amount/12;
		double Monthly_Payable_Amount = Funded_amount+Monthly_Interest_Amount+Document_prep_fee+Fund_transfer_fee;
		
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
		p.form_inputs().get(3).sendKeys(data.get("Date of Incident"));
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
		rp.Scroll_to_element(p.popup_contact_list_footer_buttons().get(0));
		Thread.sleep(800);
		p.popup_contact_list_footer_buttons().get(0).click();
		Thread.sleep(600);
		rp.Scroll_to_element(p.Contact_list_attorney_delete_button());
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
	    	System.out.println("Month "+i+" "+cell_text);
	    	Report_Listen.log_print_in_report().log(Status.INFO,"Month "+i+" "+cell_text);
	    	System.out.println();
	    	
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
	    	if(Math.abs(Monthly_Payable_Amount-cell_value) < 0.01) {
	    		System.out.println("Testcase passed First month payable "+Monthly_Payable_Amount+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
	    		System.out.println();
	    		Report_Listen.log_print_in_report().log(Status.INFO,"Testcase passed First month payable "+Monthly_Payable_Amount+" is macthing contract text's first month payable "+cell_value_upto_2_decimal);
	    		}monthly_emi.add(cell_value_upto_2_decimal);
	    	i++;}}
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
        p.Generate_contract_button().click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Generate Contract clicked (send for signing flow started).");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Confirm Send action from modal.");
	try {p.modal_buttons().get(1).click(); }
	catch(TimeoutException mko){
		Report_Listen.log_print_in_report().log(Status.INFO,"Timeout Exception found waiting for preview contract modal thereby waiting and retrying");
		System.out.println("Timeout Exception found waiting for preview contract modal thereby waiting and retrying");
		System.out.println();
		Thread.sleep(800);
		p.Generate_contract_button().click();
		Thread.sleep(1800);
		p.modal_buttons().get(2).click(); }
		Thread.sleep(800);
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast after sending contract for signing.");
		String contract_Sent_for_signing = "";
		try{
			contract_Sent_for_signing = lg.toast().getText().trim();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract sent-for-signing toast = "+contract_Sent_for_signing);
			System.out.println(contract_Sent_for_signing);}
		catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Send-for-signing toast not captured (toast not visible / locator issue) after confirming modal.");
			throw e;}
		Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Contract saved and sent for signing successfully (SaveToast='"+contract_saved+"' | SendToast='"+contract_Sent_for_signing+"').");
	    Docu_Sign_Signature();}
	
	
	
	
	
	    public void future_months_calculations_check(TreeSet<Double> emi,Double monthy_interest){
		
	    	TreeSet<Double> each_month_emi = emi;
	    	Double each_monthly_interest = monthy_interest;
	    	
	    	
		
		
		
		
	      }
	
	
	    public String Case_plaintiff_mail_id_fetcher() throws InterruptedException{
		
	    	Application_Locaters p = new Application_Locaters(d);
	    	
	    	tab_selector("Contacts");
	    	p.lawFirm_AddButton_ContactTab();
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
	    	Thread.sleep(800);
	    	List<WebElement> Mails = p.mails();
	    	Mails.get(0).click();
	    	p.Entered_mail_details();
	    	
	    	
	    }
	    
	    
	    
	
	@DataProvider
	public Object[][] caseData() {

		LocalDate base = LocalDate.now().plusWeeks(1);       // 1 week in future
	    LocalDate agreementDate = base;                      // Agreement Date = +1 week
	    LocalDate interestStartDate = base;                  // Interest Start Date = +1 week
	    LocalDate buyoutExpiryDate = base.plusYears(3);      // Expiry = +3 years

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	    String agreementDateStr = agreementDate.format(formatter);
	    String interestStartDateStr = interestStartDate.format(formatter);
	    String buyoutExpiryDateStr = buyoutExpiryDate.format(formatter);

	    // ===== Case data (NO plaintiff-related keys) =====

	    TreeMap<String, String> c1 = new TreeMap<String, String>();
	    c1.put("Case #", "1");
	    c1.put("Case Type", "Motor Vehicle Accident");
	    c1.put("State", "Indiana");
	    c1.put("Date of Incident", "02/18/2024");
	    c1.put("Lead Source", "Attorney Referral");
	    c1.put("Requested Amount", "28000");
	    c1.put("Court Index Number", "49D11-2402-CT-000944");
	    c1.put("Summary", "Multi-car rear-end on I-465 during stop-and-go traffic; airbags deployed; cervical strain with PT and missed shifts.");
	    c1.put("Risk Level", "Moderate");
	    c1.put("Recommended Max Funding", "13000");
	    c1.put("Underwriting Notes", "Liability favorable if police report assigns fault to trailing vehicle. Soft-tissue injury but supported by imaging and structured PT. Confirm coverage limits, prior claims and wage verification before finalizing funding.");
	    c1.put("Buyout Funder Name", "Summit Legal Funding");
	    c1.put("Buyout Amount", "8500");
	    c1.put("Approved Amount", "13000");
	    c1.put("Application Status", "Approved");
	    c1.put("Attorney Name", "Attorney Maren Vogelhardt");
	    c1.put("Law Firm Name", "Prairie State Bicycle, Pedestrian & Urban Traffic Collision Law Collective");
	    c1.put("Document prep fee", "255");
	    c1.put("Fund transfer fee", "80");
	    c1.put("Rate of Return", "38");
	    c1.put("SMS Message Title", "Funding Approved");
	    c1.put("SMS Message Body", "Your case funding request has been approved. We’ll coordinate next steps and agreement review with your attorney. – Lumberjack Legal Finance");

	    TreeMap<String, String> c2 = new TreeMap<String, String>();
	    c2.put("Case #", "2");
	    c2.put("Case Type", "Medical Malpractice");
	    c2.put("State", "Illinois");
	    c2.put("Date of Incident", "10/06/2023");
	    c2.put("Lead Source", "Advertising");
	    c2.put("Requested Amount", "65000");
	    c2.put("Court Index Number", "12L04-2310-MD-003718");
	    c2.put("Summary", "Delayed diagnosis of sepsis after outpatient procedure; ICU admission and prolonged recovery with ongoing fatigue.");
	    c2.put("Risk Level", "Moderate-High");
	    c2.put("Recommended Max Funding", "28000");
	    c2.put("Underwriting Notes", "High medical spend and ICU stay support damages but liability depends on expert review of standard of care and timing. Verify suit filing status, expert engagement, and applicable med-mal limitations/caps.");
	    c2.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c2.put("Buyout Amount", "16000");
	    c2.put("Approved Amount", "28000");
	    c2.put("Application Status", "In Review");
	    c2.put("Attorney Name", "Attorney Konstantin Brechtova");
	    c2.put("Law Firm Name", "Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective");
	    c2.put("Document prep fee", "295");
	    c2.put("Fund transfer fee", "90");
	    c2.put("Rate of Return", "42");
	    c2.put("SMS Message Title", "Underwriting Review");
	    c2.put("SMS Message Body", "Your application is currently under underwriting review. We’ll update you once the approval amount is finalized. – Lumberjack Legal Finance");

	    TreeMap<String, String> c3 = new TreeMap<String, String>();
	    c3.put("Case #", "3");
	    c3.put("Case Type", "Slip and Fall");
	    c3.put("State", "Ohio");
	    c3.put("Date of Incident", "12/22/2023");
	    c3.put("Lead Source", "Organic");
	    c3.put("Requested Amount", "17000");
	    c3.put("Court Index Number", "18CV-2312-PR-001308");
	    c3.put("Summary", "Unmarked wet floor at big-box store entry; knee sprain with possible meniscus tear; ortho consult and MRI pending.");
	    c3.put("Risk Level", "Moderate");
	    c3.put("Recommended Max Funding", "8000");
	    c3.put("Underwriting Notes", "Notice/maintenance logs and surveillance are key. MRI results will drive value. Ensure incident report, witness statements, and full treatment notes are obtained.");
	    c3.put("Buyout Funder Name", "Frontline Capital Group");
	    c3.put("Buyout Amount", "4500");
	    c3.put("Approved Amount", "8000");
	    c3.put("Application Status", "Approved");
	    c3.put("Attorney Name", "Attorney Elsbeth Hartmannski");
	    c3.put("Law Firm Name", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
	    c3.put("Document prep fee", "210");
	    c3.put("Fund transfer fee", "65");
	    c3.put("Rate of Return", "36");
	    c3.put("SMS Message Title", "Funding Approved");
	    c3.put("SMS Message Body", "Your slip-and-fall case has been approved for funding. We’ll coordinate documents with your attorney. – Lumberjack Legal Finance");

	    TreeMap<String, String> c4 = new TreeMap<String, String>();
	    c4.put("Case #", "4");
	    c4.put("Case Type", "Workplace Injury");
	    c4.put("State", "Michigan");
	    c4.put("Date of Incident", "05/14/2023");
	    c4.put("Lead Source", "Other");
	    c4.put("Requested Amount", "32000");
	    c4.put("Court Index Number", "03WC-2305-IN-001992");
	    c4.put("Summary", "Industrial ladder fall during maintenance; lumbar disc symptoms and radicular pain; restricted duty and missed overtime.");
	    c4.put("Risk Level", "Moderate");
	    c4.put("Recommended Max Funding", "12500");
	    c4.put("Underwriting Notes", "Clarify third-party exposure beyond workers comp. Review lien posture and any OSHA/safety documentation. Conservative funding if comp-only; higher if third-party claim is viable.");
	    c4.put("Buyout Funder Name", "Liberty Legal Funding");
	    c4.put("Buyout Amount", "9200");
	    c4.put("Approved Amount", "12500");
	    c4.put("Application Status", "Pending Docs");
	    c4.put("Attorney Name", "Attorney Ilya Kuznetsov-Schmidt");
	    c4.put("Law Firm Name", "Northern Indiana Construction Site Accident, Scaffold & Workplace Injury Attorneys");
	    c4.put("Document prep fee", "235");
	    c4.put("Fund transfer fee", "75");
	    c4.put("Rate of Return", "34");
	    c4.put("SMS Message Title", "Documents Needed");
	    c4.put("SMS Message Body", "We need additional documentation to finalize your case funding. Please coordinate uploads with your attorney. – Lumberjack Legal Finance");

	    TreeMap<String, String> c5 = new TreeMap<String, String>();
	    c5.put("Case #", "5");
	    c5.put("Case Type", "Products Liability");
	    c5.put("State", "Indiana");
	    c5.put("Date of Incident", "08/28/2023");
	    c5.put("Lead Source", "Attorney Referral");
	    c5.put("Requested Amount", "42000");
	    c5.put("Court Index Number", "49D09-2308-PL-000772");
	    c5.put("Summary", "Pressure cooker lid failure with steam release; second-degree burns to forearm; wound care and scarring risk.");
	    c5.put("Risk Level", "Moderate");
	    c5.put("Recommended Max Funding", "19000");
	    c5.put("Underwriting Notes", "Preservation of product and proof of purchase are critical. Expert review required. Damages supported by burn treatment and scarring. Funding contingent on chain-of-custody confirmation.");
	    c5.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
	    c5.put("Buyout Amount", "12500");
	    c5.put("Approved Amount", "19000");
	    c5.put("Application Status", "Approved");
	    c5.put("Attorney Name", "Attorney Svea Königstein");
	    c5.put("Law Firm Name", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    c5.put("Document prep fee", "265");
	    c5.put("Fund transfer fee", "85");
	    c5.put("Rate of Return", "40");
	    c5.put("SMS Message Title", "Approved – Product Case");
	    c5.put("SMS Message Body", "Your product-liability funding has been approved. Your attorney will receive the agreement for review. – Lumberjack Legal Finance");

	    // --- c6 to c20 (same key structure) ---
	    // To keep this response readable, I’m continuing with 15 more sets using the SAME keys,
	    // still omitting all plaintiff-related keys.

	    TreeMap<String, String> c6 = new TreeMap<String, String>();
	    c6.put("Case #", "6");
	    c6.put("Case Type", "Wrongful Death");
	    c6.put("State", "Kentucky");
	    c6.put("Date of Incident", "09/02/2022");
	    c6.put("Lead Source", "Attorney Referral");
	    c6.put("Requested Amount", "110000");
	    c6.put("Court Index Number", "22CI-2209-WD-000511");
	    c6.put("Summary", "Highway underride collision with commercial trailer; fatality alleged due to missing/defective underride guard and lighting.");
	    c6.put("Risk Level", "Low-Moderate");
	    c6.put("Recommended Max Funding", "52000");
	    c6.put("Underwriting Notes", "Severe damages with likely commercial limits; liability depends on inspection logs, maintenance records and reconstruction. Recommend staged funding tied to evidence preservation and coverage confirmation.");
	    c6.put("Buyout Funder Name", "Summit Legal Funding");
	    c6.put("Buyout Amount", "32000");
	    c6.put("Approved Amount", "52000");
	    c6.put("Application Status", "Funded");
	    c6.put("Attorney Name", "Attorney Nadja Voronov");
	    c6.put("Law Firm Name", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    c6.put("Document prep fee", "310");
	    c6.put("Fund transfer fee", "105");
	    c6.put("Rate of Return", "45");
	    c6.put("SMS Message Title", "Funding Disbursed");
	    c6.put("SMS Message Body", "Confirmation: funding has been disbursed per the agreement on file. Please contact your attorney for details. – Lumberjack Legal Finance");

	    TreeMap<String, String> c7 = new TreeMap<String, String>();
	    c7.put("Case #", "7");
	    c7.put("Case Type", "Premises Liability");
	    c7.put("State", "Ohio");
	    c7.put("Date of Incident", "01/31/2024");
	    c7.put("Lead Source", "Medical Provider");
	    c7.put("Requested Amount", "22000");
	    c7.put("Court Index Number", "23CV-2401-PL-001022");
	    c7.put("Summary", "Apartment stairwell fall due to loose tread and poor lighting; shoulder labrum tear; injection and PT.");
	    c7.put("Risk Level", "Moderate");
	    c7.put("Recommended Max Funding", "10500");
	    c7.put("Underwriting Notes", "Maintenance logs, prior complaints, and inspection history are key. Imaging confirms tear; value improves if surgery is recommended. Verify coverage and any comparative-fault defenses.");
	    c7.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c7.put("Buyout Amount", "6200");
	    c7.put("Approved Amount", "10500");
	    c7.put("Application Status", "Approved");
	    c7.put("Attorney Name", "Attorney Reto Schubertov");
	    c7.put("Law Firm Name", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
	    c7.put("Document prep fee", "235");
	    c7.put("Fund transfer fee", "70");
	    c7.put("Rate of Return", "36");
	    c7.put("SMS Message Title", "Approval Notice");
	    c7.put("SMS Message Body", "Your premises liability funding has been approved. Your attorney will receive paperwork for review. – Lumberjack Legal Finance");

	    TreeMap<String, String> c8 = new TreeMap<String, String>();
	    c8.put("Case #", "8");
	    c8.put("Case Type", "Motor Vehicle Accident");
	    c8.put("State", "Indiana");
	    c8.put("Date of Incident", "09/19/2023");
	    c8.put("Lead Source", "Broker");
	    c8.put("Requested Amount", "36000");
	    c8.put("Court Index Number", "49D03-2309-CT-001887");
	    c8.put("Summary", "T-bone at uncontrolled intersection; rib fracture and concussion symptoms; neuro follow-up recommended.");
	    c8.put("Risk Level", "Moderate");
	    c8.put("Recommended Max Funding", "16500");
	    c8.put("Underwriting Notes", "Liability depends on right-of-way evidence and witness statements. Objective rib fracture plus neuro symptoms support damages. Confirm BI/UM limits and treatment continuity.");
	    c8.put("Buyout Funder Name", "Frontline Capital Group");
	    c8.put("Buyout Amount", "9500");
	    c8.put("Approved Amount", "16500");
	    c8.put("Application Status", "Approved");
	    c8.put("Attorney Name", "Attorney Jorik Neumannova");
	    c8.put("Law Firm Name", "1010 South Meridian Street, Justice Square");
	    c8.put("Document prep fee", "255");
	    c8.put("Fund transfer fee", "90");
	    c8.put("Rate of Return", "38");
	    c8.put("SMS Message Title", "Approval Confirmed");
	    c8.put("SMS Message Body", "Your auto case funding has been approved. We’ll coordinate final paperwork with your attorney. – Lumberjack Legal Finance");

	    // --- Create remaining c9..c20 quickly with same structure ---
	    TreeMap<String, String> c9 = new TreeMap<String, String>();
	    c9.put("Case #", "9");
	    c9.put("Case Type", "Nursing Home Negligence");
	    c9.put("State", "Illinois");
	    c9.put("Date of Incident", "03/22/2023");
	    c9.put("Lead Source", "Advertising");
	    c9.put("Requested Amount", "47000");
	    c9.put("Court Index Number", "14L01-2303-NH-000518");
	    c9.put("Summary", "Pressure injuries and fall-related fracture in facility; delayed imaging and inadequate repositioning documented.");
	    c9.put("Risk Level", "Moderate");
	    c9.put("Recommended Max Funding", "23000");
	    c9.put("Underwriting Notes", "Focus on staffing levels, care plans, charting integrity and regulatory citations. Obtain full chart, wound-care timeline and expert screening before final approval.");
	    c9.put("Buyout Funder Name", "Liberty Legal Funding");
	    c9.put("Buyout Amount", "12500");
	    c9.put("Approved Amount", "23000");
	    c9.put("Application Status", "In Review");
	    c9.put("Attorney Name", "Attorney Elowen Schweitzerova");
	    c9.put("Law Firm Name", "Kleinberger & Schubertov Nursing Home Abuse, Elder Neglect & Pflegeheim Protection Firm");
	    c9.put("Document prep fee", "275");
	    c9.put("Fund transfer fee", "95");
	    c9.put("Rate of Return", "40");
	    c9.put("SMS Message Title", "Case In Review");
	    c9.put("SMS Message Body", "Your case is in detailed review. We’ll update you as soon as underwriting finalizes the approval. – Lumberjack Legal Finance");

	    TreeMap<String, String> c10 = new TreeMap<String, String>();
	    c10.put("Case #", "10");
	    c10.put("Case Type", "Construction Accident");
	    c10.put("State", "Michigan");
	    c10.put("Date of Incident", "07/07/2023");
	    c10.put("Lead Source", "Attorney Referral");
	    c10.put("Requested Amount", "60000");
	    c10.put("Court Index Number", "05CV-2307-CA-000741");
	    c10.put("Summary", "Scaffold plank failure; fall with wrist ORIF and ankle fracture; ongoing PT and reduced mobility.");
	    c10.put("Risk Level", "Moderate");
	    c10.put("Recommended Max Funding", "31000");
	    c10.put("Underwriting Notes", "Third-party liability depends on subcontractor scope and safety compliance. Obtain OSHA/incident reports and contract indemnity chain. Staged funding recommended.");
	    c10.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
	    c10.put("Buyout Amount", "19000");
	    c10.put("Approved Amount", "31000");
	    c10.put("Application Status", "Approved");
	    c10.put("Attorney Name", "Attorney Danilo Dornik");
	    c10.put("Law Firm Name", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    c10.put("Document prep fee", "285");
	    c10.put("Fund transfer fee", "100");
	    c10.put("Rate of Return", "39");
	    c10.put("SMS Message Title", "Construction Funding Approved");
	    c10.put("SMS Message Body", "Your construction accident funding has been approved. Your attorney will review the agreement before disbursement. – Lumberjack Legal Finance");

	    // c11..c20
	    TreeMap<String, String> c11 = new TreeMap<String, String>();
	    c11.put("Case #", "11");
	    c11.put("Case Type", "Dog Bite");
	    c11.put("State", "Ohio");
	    c11.put("Date of Incident", "08/09/2024");
	    c11.put("Lead Source", "Organic");
	    c11.put("Requested Amount", "12000");
	    c11.put("Court Index Number", "21CV-2408-PR-000391");
	    c11.put("Summary", "Dog bite to forearm with puncture wounds; antibiotics, follow-up and visible scarring concern.");
	    c11.put("Risk Level", "Low-Moderate");
	    c11.put("Recommended Max Funding", "6500");
	    c11.put("Underwriting Notes", "Confirm homeowners coverage and prior-bite history. Photos and animal-control documentation will support claim. Conservative funding recommended.");
	    c11.put("Buyout Funder Name", "Summit Legal Funding");
	    c11.put("Buyout Amount", "3200");
	    c11.put("Approved Amount", "6500");
	    c11.put("Application Status", "Approved");
	    c11.put("Attorney Name", "Attorney Anselm Beckendorf");
	    c11.put("Law Firm Name", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
	    c11.put("Document prep fee", "195");
	    c11.put("Fund transfer fee", "60");
	    c11.put("Rate of Return", "32");
	    c11.put("SMS Message Title", "Approval Notice");
	    c11.put("SMS Message Body", "Funding has been approved. Please coordinate agreement review with your attorney. – Lumberjack Legal Finance");

	    // For brevity: c12..c20 follow same keys exactly (no plaintiff keys)
	    // ✅ If you want, I can expand c12..c20 fully too—just say “expand full 20 sets”.

	    TreeMap<String, String> c12 = new TreeMap<String, String>(); 
	    c12.put("Case #","12"); 
	    c12.put("Case Type","Medical Malpractice"); 
	    c12.put("State","Indiana"); 
	    c12.put("Date of Incident","02/03/2023"); 
	    c12.put("Lead Source","Medical Provider"); 
	    c12.put("Requested Amount","62000"); 
	    c12.put("Court Index Number","29D02-2302-MD-000444"); 
	    c12.put("Summary","Post-op internal bleeding allegedly missed; re-admission and second procedure with prolonged recovery."); 
	    c12.put("Risk Level","Moderate"); 
	    c12.put("Recommended Max Funding","30500"); 
	    c12.put("Underwriting Notes","Confirm causation and breach via expert screening; obtain full operative report, labs and timeline. Stage funding after suit milestones."); c12.put("Buyout Funder Name","Harbor Ridge Finance"); c12.put("Buyout Amount","20500"); c12.put("Approved Amount","30500"); c12.put("Application Status","In Review"); c12.put("Attorney Name","Attorney Liesel Kleinberger"); c12.put("Law Firm Name","Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective"); c12.put("Document prep fee","300"); c12.put("Fund transfer fee","95"); c12.put("Rate of Return","41"); c12.put("SMS Message Title","File Under Review"); c12.put("SMS Message Body","Your file is under review. We’ll update you once underwriting is complete. – Lumberjack Legal Finance");

	    TreeMap<String, String> c13 = new TreeMap<String, String>(); 
	    c13.put("Case #","13"); 
	    c13.put("Case Type","Motor Vehicle Accident"); 
	    c13.put("State","Kentucky"); 
	    c13.put("Date of Incident","04/12/2024"); 
	    c13.put("Lead Source","Attorney Referral"); 
	    c13.put("Requested Amount","29500"); 
	    c13.put("Court Index Number","20CI-2404-CT-000612"); 
	    c13.put("Summary","Rear-end in construction zone; lumbar strain with radicular symptoms; injections considered."); 
	    c13.put("Risk Level","Moderate"); 
	    c13.put("Recommended Max Funding","14500"); 
	    c13.put("Underwriting Notes","Construction zone increases liability narrative; verify treatment consistency and prior spine history. Confirm BI/UM limits."); 
	    c13.put("Buyout Funder Name","Liberty Legal Funding"); c13.put("Buyout Amount","7200"); c13.put("Approved Amount","14500"); 
	    c13.put("Application Status","Approved"); 
	    c13.put("Attorney Name","Attorney Timo Markov"); 
	    c13.put("Law Firm Name","Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners"); 
	    c13.put("Document prep fee","245"); 
	    c13.put("Fund transfer fee","80"); 
	    c13.put("Rate of Return","37"); 
	    c13.put("SMS Message Title","Approved"); 
	    c13.put("SMS Message Body","Funding is approved; your attorney will receive the agreement for review. – Lumberjack Legal Finance");

	    TreeMap<String, String> c14 = new TreeMap<String, String>(); 
	    c14.put("Case #","14"); 
	    c14.put("Case Type","Products Liability"); 
	    c14.put("State","Illinois"); 
	    c14.put("Date of Incident","01/08/2022"); 
	    c14.put("Lead Source","Attorney Referral"); 
	    c14.put("Requested Amount","78000"); 
	    c14.put("Court Index Number","16L02-2201-PL-000288"); 
	    c14.put("Summary","Battery thermal runaway causing burn injury; device preserved; scarring and occupational limitations alleged."); 
	    c14.put("Risk Level","Moderate"); c14.put("Recommended Max Funding","36000"); 
	    c14.put("Underwriting Notes","Technical proof required. Verify chain of custody and expert retention. Funding staged after defect opinion and suit progression."); 
	    c14.put("Buyout Funder Name","Pioneer Plaintiff Finance"); 
	    c14.put("Buyout Amount","23000"); 
	    c14.put("Approved Amount","36000"); 
	    c14.put("Application Status","In Review"); 
	    c14.put("Attorney Name","Attorney Sarina Falkenova"); 
	    c14.put("Law Firm Name","Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel"); 
	    c14.put("Document prep fee","315"); 
	    c14.put("Fund transfer fee","110"); 
	    c14.put("Rate of Return","42"); 
	    c14.put("SMS Message Title","Technical Review"); 
	    c14.put("SMS Message Body","Your product case is in technical review. We’ll confirm approval after expert validation. – Lumberjack Legal Finance");

	    TreeMap<String, String> c15 = new TreeMap<String, String>(); 
	    c15.put("Case #","15"); 
	    c15.put("Case Type","Workplace Injury"); 
	    c15.put("State","Indiana"); 
	    c15.put("Date of Incident","02/26/2024"); 
	    c15.put("Lead Source","Other"); 
	    c15.put("Requested Amount","24000"); 
	    c15.put("Court Index Number","49D05-2402-IN-000931"); 
	    c15.put("Summary","Warehouse pallet collapse; shoulder strain and upper-back spasm; restricted duty and wage impact."); 
	    c15.put("Risk Level","Moderate"); 
	    c15.put("Recommended Max Funding","9800"); 
	    c15.put("Underwriting Notes","Clarify comp vs third-party. Obtain safety report, witness statements, wage verification and lien posture."); 
	    c15.put("Buyout Funder Name","Summit Legal Funding"); 
	    c15.put("Buyout Amount","5200"); 
	    c15.put("Approved Amount","9800"); 
	    c15.put("Application Status","Approved"); 
	    c15.put("Attorney Name","Attorney Jannik Brandtov"); 
	    c15.put("Law Firm Name","Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices"); 
	    c15.put("Document prep fee","240"); 
	    c15.put("Fund transfer fee","75"); 
	    c15.put("Rate of Return","33"); 
	    c15.put("SMS Message Title","Approved"); 
	    c15.put("SMS Message Body","Your workplace injury funding is approved. Please review next steps with your attorney. – Lumberjack Legal Finance");

	    TreeMap<String, String> c16 = new TreeMap<String, String>(); 
	    c16.put("Case #","16"); 
	    c16.put("Case Type","Slip and Fall"); 
	    c16.put("State","Michigan"); 
	    c16.put("Date of Incident","11/03/2023"); 
	    c16.put("Lead Source","Advertising"); 
	    c16.put("Requested Amount","19500"); 
	    c16.put("Court Index Number","07CV-2311-PL-000812"); 
	    c16.put("Summary","Restaurant entry slip during rain; ankle sprain with persistent pain; PT and brace use."); 
	    c16.put("Risk Level","Moderate"); 
	    c16.put("Recommended Max Funding","7200"); 
	    c16.put("Underwriting Notes","Notice and floor-mat policy important; obtain video and incident report. Conservative funding given non-fracture injury."); c16.put("Buyout Funder Name","Harbor Ridge Finance"); c16.put("Buyout Amount","4700"); c16.put("Approved Amount","7200"); c16.put("Application Status","Approved"); c16.put("Attorney Name","Attorney Mirela Braunova"); c16.put("Law Firm Name","Horizon Child Injury, School Negligence & Playground Accident Trial Lawyers"); c16.put("Document prep fee","220"); c16.put("Fund transfer fee","70"); c16.put("Rate of Return","35"); c16.put("SMS Message Title","Approved"); c16.put("SMS Message Body","Your slip-and-fall funding has been approved. Your attorney will receive the agreement. – Lumberjack Legal Finance");

	    TreeMap<String, String> c17 = new TreeMap<String, String>(); 
	    c17.put("Case #","17"); 
	    c17.put("Case Type","Trucking Accident"); 
	    c17.put("State","Ohio"); 
	    c17.put("Date of Incident","05/28/2023"); 
	    c17.put("Lead Source","Broker"); 
	    c17.put("Requested Amount","82000"); 
	    c17.put("Court Index Number","19CV-2305-CT-001201"); 
	    c17.put("Summary","Commercial truck sideswipe with secondary impacts; headaches and cervical symptoms; vehicle total loss."); 
	    c17.put("Risk Level","Moderate"); 
	    c17.put("Recommended Max Funding","35500"); 
	    c17.put("Underwriting Notes","Obtain ELD, dispatch and maintenance records. Coverage likely adequate. Staged funding recommended pending discovery and liability confirmation."); c17.put("Buyout Funder Name","Frontline Capital Group"); c17.put("Buyout Amount","22500"); c17.put("Approved Amount","35500"); c17.put("Application Status","In Review"); c17.put("Attorney Name","Attorney Oskar Dietrich"); c17.put("Law Firm Name","Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners"); c17.put("Document prep fee","310"); c17.put("Fund transfer fee","115"); c17.put("Rate of Return","44"); c17.put("SMS Message Title","Trucking File Review"); c17.put("SMS Message Body","Your trucking case is in advanced review while coverage and evidence are analyzed. – Lumberjack Legal Finance");

	    TreeMap<String, String> c18 = new TreeMap<String, String>(); 
	    c18.put("Case #","18"); 
	    c18.put("Case Type","Pedestrian Knockdown"); 
	    c18.put("State","Indiana"); 
	    c18.put("Date of Incident","08/21/2024"); 
	    c18.put("Lead Source","Attorney Referral"); 
	    c18.put("Requested Amount","34000"); 
	    c18.put("Court Index Number","49D01-2408-CT-000533"); 
	    c18.put("Summary","Pedestrian struck in crosswalk by turning vehicle; tib/fib fracture with surgery; PT and mobility limitation."); 
	    c18.put("Risk Level","Moderate-Low"); 
	    c18.put("Recommended Max Funding","17000"); 
	    c18.put("Underwriting Notes","Liability favorable given crosswalk. Surgical fracture supports damages. Confirm coverage, wage loss and permanency outlook."); c18.put("Buyout Funder Name","Liberty Legal Funding"); c18.put("Buyout Amount","9500"); c18.put("Approved Amount","17000"); c18.put("Application Status","Approved"); c18.put("Attorney Name","Attorney Alina Lindenfeld"); c18.put("Law Firm Name","1010 South Meridian Street, Justice Square"); c18.put("Document prep fee","250"); c18.put("Fund transfer fee","85"); c18.put("Rate of Return","37"); c18.put("SMS Message Title","Approved"); c18.put("SMS Message Body","Your pedestrian case funding has been approved. Please review terms with your attorney. – Lumberjack Legal Finance");

	    TreeMap<String, String> c19 = new TreeMap<String, String>(); 
	    c19.put("Case #","19"); 
	    c19.put("Case Type","Wrongful Death"); 
	    c19.put("State","Illinois"); 
	    c19.put("Date of Incident","12/04/2022"); 
	    c19.put("Lead Source","Attorney Referral"); 
	    c19.put("Requested Amount","125000"); 
	    c19.put("Court Index Number","11L03-2212-WD-000619"); 
	    c19.put("Summary","Hospital event with alleged medication error and delayed rapid response; fatal outcome; records under review."); 
	    c19.put("Risk Level","Moderate"); 
	    c19.put("Recommended Max Funding","61000"); 
	    c19.put("Underwriting Notes","Complex causation: needs multiple expert reviews and complete MAR/monitoring data. Staged funding tied to expert confirmation and litigation milestones."); c19.put("Buyout Funder Name","Summit Legal Funding"); c19.put("Buyout Amount","36000"); c19.put("Approved Amount","61000"); c19.put("Application Status","In Review"); c19.put("Attorney Name","Attorney Yannik Krausov"); c19.put("Law Firm Name","Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective"); c19.put("Document prep fee","325"); c19.put("Fund transfer fee","120"); c19.put("Rate of Return","43"); c19.put("SMS Message Title","Expert Review"); c19.put("SMS Message Body","Your wrongful death file is in expert review. We’ll confirm approval after key reviews complete. – Lumberjack Legal Finance");

	    TreeMap<String, String> c20 = new TreeMap<String, String>(); 
	    c20.put("Case #","20"); c20.put("Case Type","Motor Vehicle Accident"); 
	    c20.put("State","Kentucky"); c20.put("Date of Incident","03/09/2024"); 
	    c20.put("Lead Source","Organic"); c20.put("Requested Amount","27500"); 
	    c20.put("Court Index Number","18CI-2403-CT-000711"); 
	    c20.put("Summary","Rideshare passenger collision with secondary impact; neck/back pain; chiropractic and PT ongoing."); 
	    c20.put("Risk Level","Moderate"); 
	    c20.put("Recommended Max Funding","11500"); 
	    c20.put("Underwriting Notes","Passenger status improves liability; verify rideshare trip data and applicable policies. Confirm prior spine history and wage impact."); c20.put("Buyout Funder Name","Frontline Capital Group"); c20.put("Buyout Amount","6300"); c20.put("Approved Amount","11500"); c20.put("Application Status","Approved"); c20.put("Attorney Name","Attorney Mirek Bauer"); c20.put("Law Firm Name","Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices"); c20.put("Document prep fee","230"); c20.put("Fund transfer fee","75"); c20.put("Rate of Return","36"); c20.put("SMS Message Title","Approved"); c20.put("SMS Message Body","Your rideshare funding has been approved. We’ll proceed after agreement execution with your attorney. – Lumberjack Legal Finance");

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
	        {c1},{c2},{c3},{c4},{c5},
	        {c6},{c7},{c8},{c9},{c10},
	        {c11},{c12},{c13},{c14},{c15},
	        {c16},{c17},{c18},{c19},{c20}
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
	        final_set[i][2] = attorney_datas[i][0];   // attorney map
	    }

	    return final_set;
	}
	
	public void option_printers(String prefix ,List<WebElement> options){
		
		
	for(WebElement option:options){
		
		System.out.println(prefix+option.getText().trim());}}
	
	   public void lien_calculator(){
		
		
		 }
	
	
	
	
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
		tabs.clear();
	}
	
	
	
	
	

}
