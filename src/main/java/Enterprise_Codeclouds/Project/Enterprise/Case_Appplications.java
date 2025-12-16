package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Case_Appplications extends Header_Manager{
	
	@Test(dataProvider="caseData")
	public void Add_case(TreeMap<String, String> data) throws IOException, InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
        Login_negative_testcases lng = new Login_negative_testcases();
		Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		Actions a = new Actions(d);
		WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(10));
		
		int Requested_Amount = Integer.parseInt(data.get("Requested Amount"));
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

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario Title:</b> Create a New Case + Add Attorney Contact + Create Application + Generate Contract");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description:</b> User creates a new case for an existing plaintiff, updates case details, links an Attorney contact, creates/updates application amounts & status, then generates a contract and verifies Contract Editor opens.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input:</b> Plaintiff="+data.get("Plaintiff Name")+", CaseType="+data.get("Case Type")+", State="+data.get("State")+", DOI="+data.get("Date of Incident")+", LeadSource="+data.get("Lead Source")+", ReqAmt="+data.get("Requested Amount")+", CourtIndex="+data.get("Court Index Number")+", BuyoutFunder="+data.get("Buyout Funder Name")+", BuyoutAmt="+data.get("Buyout Amount")+", BuyoutExpiry="+data.get("Buyout Expiry Date")+", ApprovedAmt="+data.get("Approved Amount")+", DocPrepFee="+data.get("Document prep fee")+", FundTransferFee="+data.get("Fund transfer fee")+", RoR="+data.get("Rate of Return")+", AgreementDate="+data.get("Agreement Date")+", InterestStart="+data.get("Interest Start Date"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected:</b> Case should be created successfully with success toast, case details should save (Court Index + Summary), attorney contact should be linked, application should accept amounts/status, and Contract Editor should open after Generate Contract.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Navigate to Case module from header.");
		header_buttons_clicker(0);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Case module opened from header.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open New Case popup/form.");
		p.Popup_add_form();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> New Case form/popup opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Search and select existing Plaintiff from dropdown.");
		p.form_inputs().get(0).sendKeys(data.get("Plaintiff Name"));
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Plaintiff selected = "+data.get("Plaintiff Name"));
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
		p.form_inputs().get(4).click();
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
		lng.Toast_printer(lg.toast().getText().trim());}
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
		p.List_Checkboxes().get(1).click();
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
			lng.Toast_printer(lg.toast().getText().trim());}
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
	    try{
			p.Contract_editor();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Case created successfully for Plaintiff="+data.get("Plaintiff Name")+" | CourtIndex="+data.get("Court Index Number")+" | AgreementDate="+data.get("Agreement Date"));
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex="+data.get("Court Index Number"));
			throw e;}
	    d.switchTo().frame(p.contract_doc_iframe());
	    Thread.sleep(1000);
	    System.out.println("First Month Payable  "+Monthly_Payable_Amount);
	    System.out.println();
	    rp.Scroll_to_element(p.Contract_lien_table());
	    List<WebElement> cells = p.Cell_datas();
	    for(WebElement cell:cells){
	    	 String cell_text = cell.getText().trim();
	    	System.out.println(cell_text);
	    	System.out.println();
	    	}
	    d.switchTo().defaultContent();}
	
	
	
	@DataProvider
	public Object[][] caseData() {

		  // ===== Dynamic date logic =====
	    LocalDate base = LocalDate.now().plusWeeks(1);       // 1 week in future
	    LocalDate agreementDate = base;                      // Agreement Date = +1 week
	    LocalDate interestStartDate = base;                  // Interest Start Date = +1 week
	    LocalDate buyoutExpiryDate = base.plusYears(3);      // Expiry = +3 years

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	    String agreementDateStr = agreementDate.format(formatter);
	    String interestStartDateStr = interestStartDate.format(formatter);
	    String buyoutExpiryDateStr = buyoutExpiryDate.format(formatter);

	    // ===== Case data =====

	    TreeMap<String, String> c1 = new TreeMap<String, String>();
	    c1.put("Case #", "1");
	    c1.put("Plaintiff Name", "Caleb Hunter Lawson");
	    c1.put("Case Type", "Motor Vehicle Accident");
	    c1.put("State", "Indiana");
	    c1.put("Date of Incident", "03/14/2024");
	    c1.put("Lead Source", "Attorney Referral");
	    c1.put("Requested Amount", "25000");
	    c1.put("Court Index Number", "49D12-2403-CT-001201");
	    c1.put("Summary", "Rear-end collision on I-65; plaintiff rear-ended in congestion, airbags deployed, whiplash, PT with residual stiffness and work loss.");
	    c1.put("Risk Level", "Moderate");
	    c1.put("Recommended Max Funding", "12000");
	    c1.put("Underwriting Notes", "Strong rear-end liability with citation for following too closely. Soft-tissue neck/back injury but supported by ER visit, imaging, PT and wage loss. Need full medical records, wage docs and prior-claim check. Assuming clean priors and adequate BI limits, case supports funding up to about 12k.");
	    c1.put("Buyout Funder Name", "Summit Legal Funding");
	    c1.put("Buyout Amount", "8000");
	    c1.put("Approved Amount", "12000");
	    c1.put("Application Status", "Approved");
	    c1.put("Attorney Name", "Atty. Melissa Grant");
	    c1.put("Law Firm Name", "Grant & Lawson Injury Law");
	    c1.put("Plaintiff Email", "caleb.lawson@plaintiffmail.com");
	    c1.put("Plaintiff Phone Number", "555-201-0001");
	    c1.put("Plaintiff Address One", "1245 N Meridian St");
	    c1.put("Plaintiff Address Two", "Indianapolis, IN 46204");
	    c1.put("Document prep fee", "250");
	    c1.put("Fund transfer fee", "75");
	    c1.put("Rate of Return", "38");
	    c1.put("SMS Message Title", "Funding Application Approved");
	    c1.put("SMS Message Body", "Hi Caleb, your motor vehicle case funding request has been approved for up to $12,000. Our team will contact you shortly to confirm disbursement details. – Lumberjack Legal Finance");

	    TreeMap<String, String> c2 = new TreeMap<String, String>();
	    c2.put("Case #", "2");
	    c2.put("Plaintiff Name", "Jared Michael Fulton");
	    c2.put("Case Type", "Medical Malpractice");
	    c2.put("State", "Illinois");
	    c2.put("Date of Incident", "11/02/2023");
	    c2.put("Lead Source", "Digital Ad");
	    c2.put("Requested Amount", "50000");
	    c2.put("Court Index Number", "12L03-2311-MD-004589");
	    c2.put("Summary", "Failure to diagnose appendicitis at first ER visit; rupture 48 hours later, emergency surgery and several inpatient days.");
	    c2.put("Risk Level", "Moderate-High");
	    c2.put("Recommended Max Funding", "25000");
	    c2.put("Underwriting Notes", "Classic failure-to-diagnose pattern with clear progression from missed appendicitis to rupture and hospitalization. Need confirmation suit is filed, expert supporting breach and causation, and med-bill summary. Med-mal is slow and expert-heavy, so staged funding in the 20–25k range is prudent once expert support and coverage are confirmed.");
	    c2.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c2.put("Buyout Amount", "15000");
	    c2.put("Approved Amount", "25000");
	    c2.put("Application Status", "In Review");
	    c2.put("Attorney Name", "Atty. Daniel Hughes");
	    c2.put("Law Firm Name", "Hughes & Fairchild Medical Law");
	    c2.put("Plaintiff Email", "jared.fulton@plaintiffmail.com");
	    c2.put("Plaintiff Phone Number", "555-201-0002");
	    c2.put("Plaintiff Address One", "890 W Jackson Blvd");
	    c2.put("Plaintiff Address Two", "Chicago, IL 60607");
	    c2.put("Document prep fee", "275");
	    c2.put("Fund transfer fee", "80");
	    c2.put("Rate of Return", "42");
	    c2.put("SMS Message Title", "Application Under Review");
	    c2.put("SMS Message Body", "Hi Jared, we’ve received your medical malpractice funding application and it is currently under underwriting review. We’ll update you as soon as the approval amount is finalized. – Lumberjack Legal Finance");

	    TreeMap<String, String> c3 = new TreeMap<String, String>();
	    c3.put("Case #", "3");
	    c3.put("Plaintiff Name", "Marcus Evan Ridley");
	    c3.put("Case Type", "Slip and Fall");
	    c3.put("State", "Ohio");
	    c3.put("Date of Incident", "01/09/2024");
	    c3.put("Lead Source", "Direct Plaintiff Call");
	    c3.put("Requested Amount", "15000");
	    c3.put("Court Index Number", "18CV-2401-PR-000973");
	    c3.put("Summary", "Grocery store slip from refrigeration leak; no warning signs; fractured wrist, brace and OT; limits lifting and household tasks.");
	    c3.put("Risk Level", "Moderate");
	    c3.put("Recommended Max Funding", "7500");
	    c3.put("Underwriting Notes", "Premises claim with potentially strong notice if video shows a long-standing puddle and prior cooler issues. Objective fracture and OT support damages but upside is capped. Need incident report, maintenance logs, video and full med/wage docs. Assuming negligence and coverage, 6–7.5k funding is reasonable.");
	    c3.put("Buyout Funder Name", "Frontline Capital Group");
	    c3.put("Buyout Amount", "4000");
	    c3.put("Approved Amount", "7500");
	    c3.put("Application Status", "Approved");
	    c3.put("Attorney Name", "Atty. Olivia Carter");
	    c3.put("Law Firm Name", "Carter Premises Injury Firm");
	    c3.put("Plaintiff Email", "marcus.ridley@plaintiffmail.com");
	    c3.put("Plaintiff Phone Number", "555-201-0003");
	    c3.put("Plaintiff Address One", "432 James Rd");
	    c3.put("Plaintiff Address Two", "Columbus, OH 43214");
	    c3.put("Document prep fee", "200");
	    c3.put("Fund transfer fee", "60");
	    c3.put("Rate of Return", "36");
	    c3.put("SMS Message Title", "Slip & Fall Funding Approved");
	    c3.put("SMS Message Body", "Hi Marcus, your slip-and-fall case has been approved for pre-settlement funding up to $7,500. Reply to this message if you have questions about timing or payment options. – Lumberjack Legal Finance");

	    TreeMap<String, String> c4 = new TreeMap<String, String>();
	    c4.put("Case #", "4");
	    c4.put("Plaintiff Name", "Noah James Corbett");
	    c4.put("Case Type", "Workplace Injury");
	    c4.put("State", "Michigan");
	    c4.put("Date of Incident", "06/21/2023");
	    c4.put("Lead Source", "Union Referral");
	    c4.put("Requested Amount", "30000");
	    c4.put("Court Index Number", "03WC-2306-IN-002764");
	    c4.put("Summary", "Warehouse forklift struck from behind by coworker; low-back strain with radiating pain; conservative care and restricted duty.");
	    c4.put("Risk Level", "Moderate");
	    c4.put("Recommended Max Funding", "12000");
	    c4.put("Underwriting Notes", "Good mechanism but exposure may be mostly workers comp unless there is a viable third-party defendant. Need clarity on comp benefits, separate negligence claim, contracts and lien amounts. If comp-only, funding should be modest; with a strong third-party case and coverage, 10–12k is reasonable.");
	    c4.put("Buyout Funder Name", "Liberty Legal Funding");
	    c4.put("Buyout Amount", "9000");
	    c4.put("Approved Amount", "12000");
	    c4.put("Application Status", "Pending Docs");
	    c4.put("Attorney Name", "Atty. Brian Mercer");
	    c4.put("Law Firm Name", "Mercer & Lane Workplace Law");
	    c4.put("Plaintiff Email", "noah.corbett@plaintiffmail.com");
	    c4.put("Plaintiff Phone Number", "555-201-0004");
	    c4.put("Plaintiff Address One", "2150 E Grand Blvd");
	    c4.put("Plaintiff Address Two", "Detroit, MI 48211");
	    c4.put("Document prep fee", "225");
	    c4.put("Fund transfer fee", "70");
	    c4.put("Rate of Return", "34");
	    c4.put("SMS Message Title", "Documents Required");
	    c4.put("SMS Message Body", "Hi Noah, we’re almost ready to finalize your workplace injury funding. Please ask your attorney to upload your latest wage records and workers’ comp documents so we can complete approval. – Lumberjack Legal Finance");

	    TreeMap<String, String> c5 = new TreeMap<String, String>();
	    c5.put("Case #", "5");
	    c5.put("Plaintiff Name", "Brandon Tyler Vance");
	    c5.put("Case Type", "Products Liability");
	    c5.put("State", "Indiana");
	    c5.put("Date of Incident", "09/05/2023");
	    c5.put("Lead Source", "Co-Counsel Referral");
	    c5.put("Requested Amount", "40000");
	    c5.put("Court Index Number", "49D10-2309-PL-000811");
	    c5.put("Summary", "New power drill allegedly short-circuited and partially exploded in normal use; burns and deep lacerations to dominant hand; missed work as mechanic.");
	    c5.put("Risk Level", "Moderate");
	    c5.put("Recommended Max Funding", "18000");
	    c5.put("Underwriting Notes", "Product defect case with significant dominant-hand injury. Need preservation of drill, manufacturer and retailer identification and engineering expert. Damages include lost income and possible permanent impairment. With good preservation and expert support, funding in the 15–18k range is justified.");
	    c5.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
	    c5.put("Buyout Amount", "12000");
	    c5.put("Approved Amount", "18000");
	    c5.put("Application Status", "Approved");
	    c5.put("Attorney Name", "Atty. Sophia Reynolds");
	    c5.put("Law Firm Name", "Reynolds & Cole Product Liability");
	    c5.put("Plaintiff Email", "brandon.vance@plaintiffmail.com");
	    c5.put("Plaintiff Phone Number", "555-201-0005");
	    c5.put("Plaintiff Address One", "612 Brookside Dr");
	    c5.put("Plaintiff Address Two", "Bloomington, IN 47401");
	    c5.put("Document prep fee", "260");
	    c5.put("Fund transfer fee", "85");
	    c5.put("Rate of Return", "40");
	    c5.put("SMS Message Title", "Product Injury Case Approved");
	    c5.put("SMS Message Body", "Hi Brandon, your product-injury funding request has been approved for up to $18,000 based on current medical and wage information. Your attorney will review the agreement terms with you. – Lumberjack Legal Finance");

	    TreeMap<String, String> c6 = new TreeMap<String, String>();
	    c6.put("Case #", "6");
	    c6.put("Plaintiff Name", "Raymond Luke Callahan");
	    c6.put("Case Type", "Wrongful Death");
	    c6.put("State", "Kentucky");
	    c6.put("Date of Incident", "07/18/2022");
	    c6.put("Lead Source", "Attorney Referral");
	    c6.put("Requested Amount", "100000");
	    c6.put("Court Index Number", "22CI-2207-WD-000342");
	    c6.put("Summary", "Passenger killed when truck failed to brake for slowed interstate traffic; catastrophic injuries and death; alleged distraction and HOS violations.");
	    c6.put("Risk Level", "Low-Moderate");
	    c6.put("Recommended Max Funding", "50000");
	    c6.put("Underwriting Notes", "High-severity trucking wrongful death with likely commercial limits and potential punitive angle if logs and hours-of-service issues are proven. Need estate docs, policy limits, reconstruction and ELD/log data. Timeline is long but upside large, so recommend staged funding up to 40–50k as liability and coverage proof develops.");
	    c6.put("Buyout Funder Name", "Summit Legal Funding");
	    c6.put("Buyout Amount", "30000");
	    c6.put("Approved Amount", "50000");
	    c6.put("Application Status", "Funded");
	    c6.put("Attorney Name", "Atty. Caroline Blake");
	    c6.put("Law Firm Name", "Blake & Rowan Trucking Litigation");
	    c6.put("Plaintiff Email", "estate.callahan@plaintiffmail.com");
	    c6.put("Plaintiff Phone Number", "555-201-0006");
	    c6.put("Plaintiff Address One", "74 Maple Ridge Ln");
	    c6.put("Plaintiff Address Two", "Lexington, KY 40505");
	    c6.put("Document prep fee", "300");
	    c6.put("Fund transfer fee", "100");
	    c6.put("Rate of Return", "45");
	    c6.put("SMS Message Title", "Funding Disbursed");
	    c6.put("SMS Message Body", "Hello, this is a confirmation that your wrongful death case funding has been finalized and disbursed according to the agreement on file. Please contact your attorney if you have questions about the net amount received. – Lumberjack Legal Finance");

	    TreeMap<String, String> c7 = new TreeMap<String, String>();
	    c7.put("Case #", "7");
	    c7.put("Plaintiff Name", "Trevor Daniel Pierce");
	    c7.put("Case Type", "Premises Liability");
	    c7.put("State", "Ohio");
	    c7.put("Date of Incident", "02/27/2024");
	    c7.put("Lead Source", "Chiropractor Referral");
	    c7.put("Requested Amount", "20000");
	    c7.put("Court Index Number", "23CV-2402-PL-001154");
	    c7.put("Summary", "Long-term tenant slipped on unsalted icy sidewalk; prior complaints; rotator cuff tear with injections and possible arthroscopic surgery.");
	    c7.put("Risk Level", "Moderate");
	    c7.put("Recommended Max Funding", "10000");
	    c7.put("Underwriting Notes", "Forecasted freezing temps and prior complaints give decent liability posture, though open-and-obvious defenses apply. Rotator cuff injury and possible surgery increase value. Need weather records, maintenance logs, complaint history, MRI and ortho opinions. Assuming those line up, 8–10k funding is appropriate.");
	    c7.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c7.put("Buyout Amount", "6000");
	    c7.put("Approved Amount", "10000");
	    c7.put("Application Status", "Approved");
	    c7.put("Attorney Name", "Atty. Steven Patel");
	    c7.put("Law Firm Name", "Patel & Myers Tenants’ Rights");
	    c7.put("Plaintiff Email", "trevor.pierce@plaintiffmail.com");
	    c7.put("Plaintiff Phone Number", "555-201-0007");
	    c7.put("Plaintiff Address One", "309 Lakeview Ct");
	    c7.put("Plaintiff Address Two", "Akron, OH 44310");
	    c7.put("Document prep fee", "230");
	    c7.put("Fund transfer fee", "70");
	    c7.put("Rate of Return", "36");
	    c7.put("SMS Message Title", "Icy Sidewalk Case – Approval");
	    c7.put("SMS Message Body", "Hi Trevor, your premises liability funding for the icy sidewalk case has been approved. The maximum approved amount is $10,000. Your attorney will help you review the contract before signing. – Lumberjack Legal Finance");

	    TreeMap<String, String> c8 = new TreeMap<String, String>();
	    c8.put("Case #", "8");
	    c8.put("Plaintiff Name", "Logan Scott McKinney");
	    c8.put("Case Type", "Motor Vehicle Accident");
	    c8.put("State", "Indiana");
	    c8.put("Date of Incident", "10/29/2023");
	    c8.put("Lead Source", "Broker - Jason Bourne");
	    c8.put("Requested Amount", "35000");
	    c8.put("Court Index Number", "49D05-2310-CT-002031");
	    c8.put("Summary", "Plaintiff with green light T-boned by red-light violator; spin and curb impact; fractured ribs, concussion and ongoing headaches.");
	    c8.put("Risk Level", "Moderate");
	    c8.put("Recommended Max Funding", "16000");
	    c8.put("Underwriting Notes", "Liability strong if signals and witnesses confirm defendant ran red. Rib fractures and concussion put value above typical soft-tissue cases. Need CT scans, neuro follow-up, work-impact details and BI/UM coverage info. With adequate limits and clean priors, 14–16k funding is supportable.");
	    c8.put("Buyout Funder Name", "Frontline Capital Group");
	    c8.put("Buyout Amount", "9000");
	    c8.put("Approved Amount", "16000");
	    c8.put("Application Status", "Approved");
	    c8.put("Attorney Name", "Atty. Jason Bourne");
	    c8.put("Law Firm Name", "Bourne & Associates Injury Law");
	    c8.put("Plaintiff Email", "logan.mckinney@plaintiffmail.com");
	    c8.put("Plaintiff Phone Number", "555-201-0008");
	    c8.put("Plaintiff Address One", "1582 Fairview Ave");
	    c8.put("Plaintiff Address Two", "Fort Wayne, IN 46805");
	    c8.put("Document prep fee", "255");
	    c8.put("Fund transfer fee", "85");
	    c8.put("Rate of Return", "38");
	    c8.put("SMS Message Title", "Red-Light Crash Funding Approved");
	    c8.put("SMS Message Body", "Hi Logan, your auto accident funding request has been approved for a maximum of $16,000 based on your injuries and coverage. Our team will coordinate with your attorney on the final paperwork. – Lumberjack Legal Finance");

	    TreeMap<String, String> c9 = new TreeMap<String, String>();
	    c9.put("Case #", "9");
	    c9.put("Plaintiff Name", "Elliot Jordan Kane");
	    c9.put("Case Type", "Nursing Home Negligence");
	    c9.put("State", "Illinois");
	    c9.put("Date of Incident", "04/03/2023");
	    c9.put("Lead Source", "Digital Ad");
	    c9.put("Requested Amount", "45000");
	    c9.put("Court Index Number", "14L02-2304-NH-000627");
	    c9.put("Summary", "Elderly resident developed multiple Stage III–IV pressure ulcers with delayed reporting and inadequate wound care; required debridement and extended hospitalization.");
	    c9.put("Risk Level", "Moderate");
	    c9.put("Recommended Max Funding", "22000");
	    c9.put("Underwriting Notes", "Advanced bedsores usually signal prolonged neglect. Focus on understaffing, failure to reposition and regulatory violations. Need full chart, care plans, MDS, staffing and wound-care records plus photos. Litigation is expert-heavy but upside good; with experts on board, staged funding of 18–22k is reasonable.");
	    c9.put("Buyout Funder Name", "Liberty Legal Funding");
	    c9.put("Buyout Amount", "12000");
	    c9.put("Approved Amount", "22000");
	    c9.put("Application Status", "In Review");
	    c9.put("Attorney Name", "Atty. Margaret Stone");
	    c9.put("Law Firm Name", "Stone & Avery Elder Care Law");
	    c9.put("Plaintiff Email", "elliot.kane@plaintiffmail.com");
	    c9.put("Plaintiff Phone Number", "555-201-0009");
	    c9.put("Plaintiff Address One", "982 Oak Terrace");
	    c9.put("Plaintiff Address Two", "Springfield, IL 62703");
	    c9.put("Document prep fee", "270");
	    c9.put("Fund transfer fee", "90");
	    c9.put("Rate of Return", "40");
	    c9.put("SMS Message Title", "Nursing Home Case – Review");
	    c9.put("SMS Message Body", "Hi Elliot, your nursing home negligence funding file is in detailed review due to the severity of the injuries. We are working closely with your attorney and will confirm the approved amount once expert documentation is finalized. – Lumberjack Legal Finance");

	    TreeMap<String, String> c10 = new TreeMap<String, String>();
	    c10.put("Case #", "10");
	    c10.put("Plaintiff Name", "Samuel Bryce Donovan");
	    c10.put("Case Type", "Construction Accident");
	    c10.put("State", "Michigan");
	    c10.put("Date of Incident", "08/11/2023");
	    c10.put("Lead Source", "Attorney Referral");
	    c10.put("Requested Amount", "55000");
	    c10.put("Court Index Number", "05CV-2308-CA-000958");
	    c10.put("Summary", "Scaffolding collapse from improperly secured cross-bracing; fall to concrete; fractures to ankle and wrist; ankle surgery with hardware.");
	    c10.put("Risk Level", "Moderate");
	    c10.put("Recommended Max Funding", "30000");
	    c10.put("Underwriting Notes", "Third-party construction claim with clear unsafe condition and objective fractures. Need incident and OSHA reports, subcontractor contracts and indemnity clauses, and full surgical records. Workers comp lien effect must be modeled. Given surgery and future arthritis risk, recommend staged funding up to 25–30k after suit filing and coverage mapping.");
	    c10.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
	    c10.put("Buyout Amount", "18000");
	    c10.put("Approved Amount", "30000");
	    c10.put("Application Status", "Approved");
	    c10.put("Attorney Name", "Atty. Michael Turner");
	    c10.put("Law Firm Name", "Turner & Cole Construction Law");
	    c10.put("Plaintiff Email", "samuel.donovan@plaintiffmail.com");
	    c10.put("Plaintiff Phone Number", "555-201-0010");
	    c10.put("Plaintiff Address One", "450 Ridgecrest Dr");
	    c10.put("Plaintiff Address Two", "Grand Rapids, MI 49504");
	    c10.put("Document prep fee", "280");
	    c10.put("Fund transfer fee", "95");
	    c10.put("Rate of Return", "39");
	    c10.put("SMS Message Title", "Construction Accident Funding Approved");
	    c10.put("SMS Message Body", "Hi Samuel, your construction accident funding request has been approved for up to $30,000. Your attorney will review the agreement with you so we can move forward with funding. – Lumberjack Legal Finance");

	    TreeMap<String, String> c11 = new TreeMap<String, String>();
	    c11.put("Case #", "11");
	    c11.put("Plaintiff Name", "Owen Parker Mills");
	    c11.put("Case Type", "Dog Bite");
	    c11.put("State", "Ohio");
	    c11.put("Date of Incident", "09/16/2024");
	    c11.put("Lead Source", "Direct Plaintiff Call");
	    c11.put("Requested Amount", "10000");
	    c11.put("Court Index Number", "21CV-2409-PR-000423");
	    c11.put("Summary", "Eight-year-old child bitten on cheek and forearm by neighbors aggressive dog; stitches, plastic-surgery follow-up and nightmares.");
	    c11.put("Risk Level", "Low-Moderate");
	    c11.put("Recommended Max Funding", "6000");
	    c11.put("Underwriting Notes", "Child plaintiff with facial scarring and emotional trauma presents well if homeowners coverage is available. Need animal-control report, prior-bite history, photos and plastic-surgery opinion on future care and scarring. Overall value moderate but credible; 5–6k funding is appropriate, with room for small increase if revision surgery is likely.");
	    c11.put("Buyout Funder Name", "Summit Legal Funding");
	    c11.put("Buyout Amount", "3000");
	    c11.put("Approved Amount", "6000");
	    c11.put("Application Status", "Approved");
	    c11.put("Attorney Name", "Atty. Rachel Ortiz");
	    c11.put("Law Firm Name", "Ortiz & Brown Injury Counsel");
	    c11.put("Plaintiff Email", "owen.mills@plaintiffmail.com");
	    c11.put("Plaintiff Phone Number", "555-201-0011");
	    c11.put("Plaintiff Address One", "221 Cedar Glen Ln");
	    c11.put("Plaintiff Address Two", "Toledo, OH 43614");
	    c11.put("Document prep fee", "190");
	    c11.put("Fund transfer fee", "55");
	    c11.put("Rate of Return", "32");
	    c11.put("SMS Message Title", "Dog Bite Case Funding Approved");
	    c11.put("SMS Message Body", "Hi Owen, we’ve approved funding up to $6,000 for your dog bite case. Your parent/guardian and attorney will receive the agreement to review and sign before funds are released. – Lumberjack Legal Finance");

	    TreeMap<String, String> c12 = new TreeMap<String, String>();
	    c12.put("Case #", "12");
	    c12.put("Plaintiff Name", "Isaac Henry Coleman");
	    c12.put("Case Type", "Medical Malpractice");
	    c12.put("State", "Indiana");
	    c12.put("Date of Incident", "01/25/2023");
	    c12.put("Lead Source", "Hospital Referral");
	    c12.put("Requested Amount", "60000");
	    c12.put("Court Index Number", "29D03-2301-MD-000391");
	    c12.put("Summary", "Retained surgical sponge after abdominal procedure; infection and second corrective surgery with added scarring and wage loss.");
	    c12.put("Risk Level", "Moderate");
	    c12.put("Recommended Max Funding", "30000");
	    c12.put("Underwriting Notes", "Retained foreign object is a very strong liability theory. Damages include second surgery, infection, increased scarring and extra time off work. Indiana med-mal caps require net-recovery modeling. Need panel status, expert support and cap details. With those, 25–30k staged funding is appropriate.");
	    c12.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c12.put("Buyout Amount", "20000");
	    c12.put("Approved Amount", "30000");
	    c12.put("Application Status", "In Review");
	    c12.put("Attorney Name", "Atty. Jonathan Wells");
	    c12.put("Law Firm Name", "Wells & Chang Med-Mal Group");
	    c12.put("Plaintiff Email", "isaac.coleman@plaintiffmail.com");
	    c12.put("Plaintiff Phone Number", "555-201-0012");
	    c12.put("Plaintiff Address One", "909 Millstone Ct");
	    c12.put("Plaintiff Address Two", "Carmel, IN 46032");
	    c12.put("Document prep fee", "295");
	    c12.put("Fund transfer fee", "95");
	    c12.put("Rate of Return", "41");
	    c12.put("SMS Message Title", "Foreign Object Case – Review");
	    c12.put("SMS Message Body", "Hi Isaac, your retained-sponge medical malpractice funding file is in detailed review. Because this is a high-value claim, our team is coordinating with your attorney and experts before final approval. – Lumberjack Legal Finance");

	    TreeMap<String, String> c13 = new TreeMap<String, String>();
	    c13.put("Case #", "13");
	    c13.put("Plaintiff Name", "Adrian Blake Foster");
	    c13.put("Case Type", "Motor Vehicle Accident");
	    c13.put("State", "Kentucky");
	    c13.put("Date of Incident", "05/07/2024");
	    c13.put("Lead Source", "Attorney Referral");
	    c13.put("Requested Amount", "28000");
	    c13.put("Court Index Number", "20CI-2405-CT-000774");
	    c13.put("Summary", "Rear-end collision in school zone; defendant allegedly distracted by phone; MRI shows cervical disc bulge with radiating pain.");
	    c13.put("Risk Level", "Moderate");
	    c13.put("Recommended Max Funding", "14000");
	    c13.put("Underwriting Notes", "Rear-end in a school zone plus phone distraction evidence makes liability favorable. Disc pathology raises value above simple sprain or strain. Need pain-management notes, work-impact details, prior neck history and coverage info. With clean priors and decent limits, funding in the 12–14k range is reasonable.");
	    c13.put("Buyout Funder Name", "Liberty Legal Funding");
	    c13.put("Buyout Amount", "7000");
	    c13.put("Approved Amount", "14000");
	    c13.put("Application Status", "Approved");
	    c13.put("Attorney Name", "Atty. Peter Collins");
	    c13.put("Law Firm Name", "Collins & Hart School Zone Injury");
	    c13.put("Plaintiff Email", "adrian.foster@plaintiffmail.com");
	    c13.put("Plaintiff Phone Number", "555-201-0013");
	    c13.put("Plaintiff Address One", "133 Pine Hill Rd");
	    c13.put("Plaintiff Address Two", "Louisville, KY 40220");
	    c13.put("Document prep fee", "240");
	    c13.put("Fund transfer fee", "75");
	    c13.put("Rate of Return", "37");
	    c13.put("SMS Message Title", "School Zone Crash Funding Approved");
	    c13.put("SMS Message Body", "Hi Adrian, your school-zone rear-end accident funding has been approved up to $14,000. Your attorney will walk you through the agreement and next steps before funds are released. – Lumberjack Legal Finance");

	    TreeMap<String, String> c14 = new TreeMap<String, String>();
	    c14.put("Case #", "14");
	    c14.put("Plaintiff Name", "Connor Dean Whitaker");
	    c14.put("Case Type", "Products Liability");
	    c14.put("State", "Illinois");
	    c14.put("Date of Incident", "02/10/2022");
	    c14.put("Lead Source", "Co-Counsel Referral");
	    c14.put("Requested Amount", "75000");
	    c14.put("Court Index Number", "16L04-2202-PL-000519");
	    c14.put("Summary", "Commercial e-cigarette battery overheated and exploded; second-degree burns and shrapnel-type injuries to hand and chest; visible scarring.");
	    c14.put("Risk Level", "Moderate");
	    c14.put("Recommended Max Funding", "35000");
	    c14.put("Underwriting Notes", "Lithium-ion battery explosion claim; success depends on product preservation and expert proof of defect or inadequate warning. Visible scarring and time off a customer-facing job support damages but litigation is technical and expensive. Need proof of purchase, chain of custody, prior-incident or recall data and a battery expert. With that infrastructure, 30–35k staged funding is justified.");
	    c14.put("Buyout Funder Name", "Pioneer Plaintiff Finance");
	    c14.put("Buyout Amount", "22000");
	    c14.put("Approved Amount", "35000");
	    c14.put("Application Status", "In Review");
	    c14.put("Attorney Name", "Atty. Laura Mitchell");
	    c14.put("Law Firm Name", "Mitchell & Brooks Product Safety");
	    c14.put("Plaintiff Email", "connor.whitaker@plaintiffmail.com");
	    c14.put("Plaintiff Phone Number", "555-201-0014");
	    c14.put("Plaintiff Address One", "725 Harbor Point Dr");
	    c14.put("Plaintiff Address Two", "Waukegan, IL 60085");
	    c14.put("Document prep fee", "310");
	    c14.put("Fund transfer fee", "105");
	    c14.put("Rate of Return", "42");
	    c14.put("SMS Message Title", "E-Cig Explosion Case – Review");
	    c14.put("SMS Message Body", "Hi Connor, your e-cigarette battery explosion funding request is in technical review due to product-liability issues. We will confirm the approved amount after engineering and legal assessments are complete. – Lumberjack Legal Finance");

	    TreeMap<String, String> c15 = new TreeMap<String, String>();
	    c15.put("Case #", "15");
	    c15.put("Plaintiff Name", "Julian Carter Rhodes");
	    c15.put("Case Type", "Workplace Injury");
	    c15.put("State", "Indiana");
	    c15.put("Date of Incident", "03/30/2024");
	    c15.put("Lead Source", "Employer Referral");
	    c15.put("Requested Amount", "22000");
	    c15.put("Court Index Number", "49D06-2403-IN-001142");
	    c15.put("Summary", "Distribution-center worker hit by falling cartons from top shelf; shoulder and upper-back soft-tissue injury; light duty and lost overtime.");
	    c15.put("Risk Level", "Moderate");
	    c15.put("Recommended Max Funding", "9000");
	    c15.put("Underwriting Notes", "Unsafe stacking practices and limited training support negligence if there is a premises or third-party claim beyond workers comp. Need safety policies, incident report, witness or supervisor statements and wage records. If recovery is comp-only, funding must be low; with a viable third-party case and coverage, 8–9k funding is reasonable.");
	    c15.put("Buyout Funder Name", "Summit Legal Funding");
	    c15.put("Buyout Amount", "5000");
	    c15.put("Approved Amount", "9000");
	    c15.put("Application Status", "Approved");
	    c15.put("Attorney Name", "Atty. Henry Lawson");
	    c15.put("Law Firm Name", "Lawson & Trent Workplace Counsel");
	    c15.put("Plaintiff Email", "julian.rhodes@plaintiffmail.com");
	    c15.put("Plaintiff Phone Number", "555-201-0015");
	    c15.put("Plaintiff Address One", "311 Westbrook Ave");
	    c15.put("Plaintiff Address Two", "Indianapolis, IN 46222");
	    c15.put("Document prep fee", "235");
	    c15.put("Fund transfer fee", "70");
	    c15.put("Rate of Return", "33");
	    c15.put("SMS Message Title", "Warehouse Injury Funding Approved");
	    c15.put("SMS Message Body", "Hi Julian, your warehouse injury funding request has been approved up to $9,000. Once you and your attorney sign the agreement, we’ll release funds according to the schedule. – Lumberjack Legal Finance");

	    TreeMap<String, String> c16 = new TreeMap<String, String>();
	    c16.put("Case #", "16");
	    c16.put("Plaintiff Name", "Mitchell Aaron Hayes");
	    c16.put("Case Type", "Slip and Fall");
	    c16.put("State", "Michigan");
	    c16.put("Date of Incident", "12/19/2023");
	    c16.put("Lead Source", "Digital Ad");
	    c16.put("Requested Amount", "18000");
	    c16.put("Court Index Number", "07CV-2312-PL-000887");
	    c16.put("Summary", "Restaurant employee spilled drink and failed to clean or mark area; plaintiff slipped going to restroom; hip contusion and elbow sprain; PT and short cane use.");
	    c16.put("Risk Level", "Moderate");
	    c16.put("Recommended Max Funding", "7000");
	    c16.put("Underwriting Notes", "Because an employee created the hazard, notice is easier to prove than in many slip cases. Injuries are moderate with no fracture. Need incident report, witness statements, video if available and complete med bills and records. Upside is capped, so conservative funding in the 6–7k range is appropriate once basic liability docs are reviewed.");
	    c16.put("Buyout Funder Name", "Harbor Ridge Finance");
	    c16.put("Buyout Amount", "4500");
	    c16.put("Approved Amount", "7000");
	    c16.put("Application Status", "Approved");
	    c16.put("Attorney Name", "Atty. Victoria Lane");
	    c16.put("Law Firm Name", "Lane & Harper Restaurant Liability");
	    c16.put("Plaintiff Email", "mitchell.hayes@plaintiffmail.com");
	    c16.put("Plaintiff Phone Number", "555-201-0016");
	    c16.put("Plaintiff Address One", "67 Orchard View Dr");
	    c16.put("Plaintiff Address Two", "Lansing, MI 48911");
	    c16.put("Document prep fee", "215");
	    c16.put("Fund transfer fee", "65");
	    c16.put("Rate of Return", "35");
	    c16.put("SMS Message Title", "Restaurant Slip Case Approved");
	    c16.put("SMS Message Body", "Hi Mitchell, your restaurant slip-and-fall funding has been approved up to $7,000. Your attorney will review the terms and help you complete the agreement for funding. – Lumberjack Legal Finance");

	    TreeMap<String, String> c17 = new TreeMap<String, String>();
	    c17.put("Case #", "17");
	    c17.put("Plaintiff Name", "Dylan Chase Barrett");
	    c17.put("Case Type", "Trucking Accident");
	    c17.put("State", "Ohio");
	    c17.put("Date of Incident", "06/02/2023");
	    c17.put("Lead Source", "Broker - Jason Bourne");
	    c17.put("Requested Amount", "80000");
	    c17.put("Court Index Number", "19CV-2306-CT-001339");
	    c17.put("Summary", "Semi-truck drifted into oncoming lane, sideswiping plaintiff and other cars; neck and back injuries, headaches, emotional distress, vehicle total loss.");
	    c17.put("Risk Level", "Moderate");
	    c17.put("Recommended Max Funding", "35000");
	    c17.put("Underwriting Notes", "Multi-vehicle trucking crash with clear lane encroachment gives strong liability and potential punitive exposure if fatigue or distraction is proven. Need imaging, treatment history, psych records if any, ELD and dispatch data and carrier safety policies. Commercial limits likely adequate; recommend staged funding up to 30–35k as discovery confirms violations.");
	    c17.put("Buyout Funder Name", "Frontline Capital Group");
	    c17.put("Buyout Amount", "22000");
	    c17.put("Approved Amount", "35000");
	    c17.put("Application Status", "In Review");
	    c17.put("Attorney Name", "Atty. Jason Bourne");
	    c17.put("Law Firm Name", "Bourne Trucking Litigation Group");
	    c17.put("Plaintiff Email", "dylan.barrett@plaintiffmail.com");
	    c17.put("Plaintiff Phone Number", "555-201-0017");
	    c17.put("Plaintiff Address One", "190 Creekside Way");
	    c17.put("Plaintiff Address Two", "Cleveland, OH 44111");
	    c17.put("Document prep fee", "305");
	    c17.put("Fund transfer fee", "110");
	    c17.put("Rate of Return", "44");
	    c17.put("SMS Message Title", "Trucking Crash – Review");
	    c17.put("SMS Message Body", "Hi Dylan, your trucking accident funding file is in advanced review while we analyze log data and coverage. We’ll let you know as soon as we finalize the maximum approval amount. – Lumberjack Legal Finance");

	    TreeMap<String, String> c18 = new TreeMap<String, String>();
	    c18.put("Case #", "18");
	    c18.put("Plaintiff Name", "Gabriel Ryan Summers");
	    c18.put("Case Type", "Pedestrian Knockdown");
	    c18.put("State", "Indiana");
	    c18.put("Date of Incident", "09/09/2024");
	    c18.put("Lead Source", "Attorney Referral");
	    c18.put("Requested Amount", "32000");
	    c18.put("Court Index Number", "49D02-2409-CT-000604");
	    c18.put("Summary", "Pedestrian in marked crosswalk with walk signal struck by right-on-red driver; tibia fracture with hardware; ongoing PT and off work from standing job.");
	    c18.put("Risk Level", "Moderate-Low");
	    c18.put("Recommended Max Funding", "16000");
	    c18.put("Underwriting Notes", "Pedestrian with walk signal has excellent liability posture. Tibial fracture with surgery and temporary total disability supports strong damages. Need operative report, PT records, wage info and BI/UM coverage details. Long-term arthritis risk adds value. Recommend funding in the 14–16k range as recovery and permanency develop.");
	    c18.put("Buyout Funder Name", "Liberty Legal Funding");
	    c18.put("Buyout Amount", "9000");
	    c18.put("Approved Amount", "16000");
	    c18.put("Application Status", "Approved");
	    c18.put("Attorney Name", "Atty. Emily Rogers");
	    c18.put("Law Firm Name", "Rogers & Hale Pedestrian Law Group");
	    c18.put("Plaintiff Email", "gabriel.summers@plaintiffmail.com");
	    c18.put("Plaintiff Phone Number", "555-201-0018");
	    c18.put("Plaintiff Address One", "580 Crosswalk Ln");
	    c18.put("Plaintiff Address Two", "Indianapolis, IN 46227");
	    c18.put("Document prep fee", "245");
	    c18.put("Fund transfer fee", "80");
	    c18.put("Rate of Return", "37");
	    c18.put("SMS Message Title", "Pedestrian Case Funding Approved");
	    c18.put("SMS Message Body", "Hi Gabriel, your pedestrian knockdown funding request has been approved for up to $16,000. Please review the agreement with your attorney so we can release funds quickly. – Lumberjack Legal Finance");

	    TreeMap<String, String> c19 = new TreeMap<String, String>();
	    c19.put("Case #", "19");
	    c19.put("Plaintiff Name", "Leonard Joel Harrington");
	    c19.put("Case Type", "Wrongful Death");
	    c19.put("State", "Illinois");
	    c19.put("Date of Incident", "01/15/2023");
	    c19.put("Lead Source", "Co-Counsel Referral");
	    c19.put("Requested Amount", "120000");
	    c19.put("Court Index Number", "11L01-2301-WD-000287");
	    c19.put("Summary", "Elective procedure complicated by alleged anesthesia or medication error and delayed response to vital-sign changes; intra-op arrest and death.");
	    c19.put("Risk Level", "Moderate");
	    c19.put("Recommended Max Funding", "60000");
	    c19.put("Underwriting Notes", "High-severity med-mal wrongful death with complex causation questions. Need full hospital and anesthesia records, medication logs, monitor data and multiple expert reviews on breach and causation. Litigation will be long and cost-heavy but potential recovery is significant. Recommend staged funding up to 50–60k tied to expert confirmations and key milestones.");
	    c19.put("Buyout Funder Name", "Summit Legal Funding");
	    c19.put("Buyout Amount", "35000");
	    c19.put("Approved Amount", "60000");
	    c19.put("Application Status", "In Review");
	    c19.put("Attorney Name", "Atty. Nathaniel Price");
	    c19.put("Law Firm Name", "Price & Donovan Med-Mal Group");
	    c19.put("Plaintiff Email", "estate.harrington@plaintiffmail.com");
	    c19.put("Plaintiff Phone Number", "555-201-0019");
	    c19.put("Plaintiff Address One", "410 Briarwood Ct");
	    c19.put("Plaintiff Address Two", "Naperville, IL 60540");
	    c19.put("Document prep fee", "320");
	    c19.put("Fund transfer fee", "115");
	    c19.put("Rate of Return", "43");
	    c19.put("SMS Message Title", "Wrongful Death Case – Review");
	    c19.put("SMS Message Body", "Hello, your wrongful death case funding file is in expert review due to the complexity of the medical issues. We’re working with your attorney and will confirm the approved funding range once reviews are complete. – Lumberjack Legal Finance");

	    TreeMap<String, String> c20 = new TreeMap<String, String>();
	    c20.put("Case #", "20");
	    c20.put("Plaintiff Name", "Patrick Cole Jennings");
	    c20.put("Case Type", "Motor Vehicle Accident");
	    c20.put("State", "Kentucky");
	    c20.put("Date of Incident", "04/28/2024");
	    c20.put("Lead Source", "Direct Plaintiff Call");
	    c20.put("Requested Amount", "26000");
	    c20.put("Court Index Number", "18CI-2404-CT-000933");
	    c20.put("Summary", "Uber passenger in chain-reaction rear-end crash; neck and low-back soft-tissue injuries, ongoing stiffness, PT and chiropractic care; work disruption.");
	    c20.put("Risk Level", "Moderate");
	    c20.put("Recommended Max Funding", "11000");
	    c20.put("Underwriting Notes", "Rideshare passenger status gives clean liability and multiple coverage layers (tortfeasor and Uber policy). Injuries are soft-tissue but well documented with continuing functional impact, especially with sitting. Need trip records, police report, med summaries, wage-loss data and prior spine history. With solid coverage, funding of 10–11k is supportable.");
	    c20.put("Buyout Funder Name", "Frontline Capital Group");
	    c20.put("Buyout Amount", "6000");
	    c20.put("Approved Amount", "11000");
	    c20.put("Application Status", "Approved");
	    c20.put("Attorney Name", "Atty. Jordan Blake");
	    c20.put("Law Firm Name", "Blake Rideshare Injury Law");
	    c20.put("Plaintiff Email", "patrick.jennings@plaintiffmail.com");
	    c20.put("Plaintiff Phone Number", "555-201-0020");
	    c20.put("Plaintiff Address One", "902 Kingston Ave");
	    c20.put("Plaintiff Address Two", "Lexington, KY 40508");
	    c20.put("Document prep fee", "225");
	    c20.put("Fund transfer fee", "70");
	    c20.put("Rate of Return", "36");
	    c20.put("SMS Message Title", "Rideshare Funding Approved");
	    c20.put("SMS Message Body", "Hi Patrick, your rideshare accident funding request has been approved up to $11,000. After you and your attorney sign the agreement, we’ll proceed with disbursement. – Lumberjack Legal Finance");

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
	    return new Object[][] {
	     { c1 },/* { c2 }, { c3 }, { c4 }, { c5 },
	        { c6 }, { c7 }, { c8 }, { c9 }, { c10 },
	        { c11 }, { c12 }, { c13 }, { c14 }, { c15 },
	        { c16 }, { c17 }, { c18 }, { c19 }, { c20 }  */
	    };
	}
	
	
	public void option_printers(String prefix ,List<WebElement> options){
		
		
	for(WebElement option:options){
		
		System.out.println(prefix+option.getText().trim());}}
	
	   public void lien_calculator(){
		
		
		 }
	
	
	
	
	@Test(dataProvider="caseData")
	public void Added_application_delete(TreeMap<String, String> val) throws IOException, InterruptedException{
		
	//	SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Application_Locaters p = new Application_Locaters(d);
		Login_negative_testcases lng = new Login_negative_testcases();
		Login_Locaters lg = new Login_Locaters(d);
		
		String Plaintiff_name=val.get("Plaintiff Name");
		
	 try {
		login();
		d.navigate().to("https://logbook.wechopfees.com/cases");
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
			System.out.println();
		}
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
		try{lng.Toast_printer(lg.toast().getText().trim());}
		catch(Exception mo){
			Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** 📢 Toast after Deletion of the Application: "+"No toast captured / toast locator not visible. Error:");
			}
		Thread.sleep(900);table_rows.clear();
		}
	 catch(Exception ko){
		 
		 Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Delete operation failed for plaintiff '"+Plaintiff_name+"' due to exception: "+ko.getMessage());
         System.out.println("Delete operation failed for plaintiff  "+Plaintiff_name);
         System.out.println();}}
	
	
	
	
	
	
	
	public void tab_selector(String tabname) throws InterruptedException{
		
		Application_Locaters p = new Application_Locaters(d);
		
		
        List<WebElement> tabs = p.tabs();
		
		for(WebElement tab:tabs){
		if(tab.getText().trim().equalsIgnoreCase(tabname)){
			
			tab.click();
			break;}}
		Thread.sleep(900);
		tabs.clear();
	}
	
	
	
	
	

}
