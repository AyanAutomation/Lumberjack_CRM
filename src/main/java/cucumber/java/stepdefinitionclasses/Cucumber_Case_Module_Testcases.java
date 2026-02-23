package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Attorney_module;
import Enterprise_Codeclouds.Project.Enterprise.Case_Appplications;
import Enterprise_Codeclouds.Project.Enterprise.SIde_Menu_Handler;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;



public class Cucumber_Case_Module_Testcases extends Case_Appplications{
	
	public WebDriver d = Base_cucumber.d;
	

public void Add_New_Case_Form_Accessor(int s) throws IOException, InterruptedException{
		
	    
	
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
	
  

     
     

     @Given("Add_case_cucumber with data:")
     public void Add_case_cucumber(DataTable table) throws IOException, InterruptedException{ 
	 
    	 WebDriver d = Base_cucumber.d;

         // ✅ One map only (no TreeMap objects)
    	 Map<String, String> data = new TreeMap<>(table.asMap(String.class, String.class));

         // ✅ Dynamic system dates INLINE (no helper methods)
         DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
         String today = LocalDate.now().format(fmt);
         String expiry = LocalDate.now().plusYears(4).format(fmt);

         data.put("Case.Payment Date", today);
         data.put("Case.Agreement Date", today);
         data.put("Case.Interest Start Date", today);
         data.put("Case.Buyout Expiry Date", expiry);

         Application_Locaters p = new Application_Locaters(d);
         Login_Locaters lg = new Login_Locaters(d);
         Repeat rp = new Repeat(d);
         JavascriptExecutor js = (JavascriptExecutor) d;
         Attorney_Modules_Cucumber at = new Attorney_Modules_Cucumber();

         //Collections_Clear();
         monthly_emi.clear();

         int Buyout_Amount = Integer.parseInt(data.get("Case.Buyout Amount"));
         int Approved_Amount = Integer.parseInt(data.get("Case.Approved Amount"));
         int Document_prep_fee = Integer.parseInt(data.get("Case.Document prep fee"));
         int Fund_transfer_fee = Integer.parseInt(data.get("Case.Fund transfer fee"));
         int Rate_of_Return = Integer.parseInt(data.get("Case.Rate of Return"));

         double Funded_amount = Buyout_Amount + Approved_Amount;
         double Annual_Interest_Amount = (Funded_amount * Rate_of_Return) / 100;
         double Monthly_Interest_Amount = Annual_Interest_Amount / 12;
         double Monthly_Payable_Amount = Funded_amount + Monthly_Interest_Amount + Document_prep_fee + Fund_transfer_fee;

         double Monthly_Payable_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Payable_Amount));
         double Monthly_Interest_Amount_upto_2_decimal = Double.parseDouble(String.format("%.2f", Monthly_Interest_Amount));

         int step = 1;

         Add_New_Case_Form_Accessor(step++);
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> New Case form/popup opened.");

         // ========== Plaintiff ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Search and select existing Plaintiff from dropdown.");
         p.form_inputs().get(0).sendKeys(data.get("Plaintiff.First Name"));
         p.plaintiff_dropdown_list();
         p.Plaintiff_options().get(0).click();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plaintiff selected = " + data.get("Plaintiff.First Name"));

         // ========== Case Type ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select Incident/Case Type from dropdown.");
         p.form_inputs().get(1).sendKeys(data.get("Case.Case Type"));
         p.form_inputs().get(1).click();
         p.Incident_type_dropdown();
         option_printers("Incident Options are ", p.Incident_options());
         p.Incident_options().get(0).click();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Incident/Case type selected from list for input = " + data.get("Case.Case Type"));

         // ========== State ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select State of Incident from dropdown.");
         p.form_inputs().get(2).sendKeys(data.get("Case.State"));
         p.form_inputs().get(2).click();
         p.State_of_incident_dropdown();
         p.State_of_incident_options().get(0).click();
         Thread.sleep(500);
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> State selected from list for input = " + data.get("Case.State"));

         // ========== Date of Incident ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter Date of Incident and confirm date selection.");
         WebElement calender_field = p.form_inputs().get(3);
         calender_field.sendKeys(data.get("Case.Date of Incident"));
         calender_field.click();
         p.calender_date_select().click();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Date of Incident entered/selected = " + data.get("Case.Date of Incident"));

         // ========== Lead Source ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Select Lead Type and Lead Source.");
         rp.Scroll_to_element(p.form_inputs().get(4));
         p.form_inputs().get(4).sendKeys(data.get("Case.Lead Source"));
         p.Lead_Type_dropdown();
         p.Lead_category_options().get(0).click();
         p.form_inputs().get(5).click();
         p.Lead_dropdown();
         p.Leadoptions().get(0).click();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead type/source selected from dropdowns (Lead Source input = " + data.get("Case.Lead Source") + ")");

         // ========== Requested Amount + Create ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter Requested Amount and click Create/Save Case.");
         rp.Scroll_to_element(p.form_inputs().get(5));
         p.form_inputs().get(6).sendKeys(data.get("Case.Requested Amount"));
         p.form_buttons().get(1).click();
         Thread.sleep(500);

         String Case_ID = null;
         try {
             Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d);
             WebElement CaseId = p.Case_ID_Tag();
             Case_ID = CaseId.getText().trim();
             System.out.println(Case_ID);
             System.out.println();
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual →</b> Toast after creating case: No toast captured / toast locator not visible.");
         }

         // ========== Edit Case Details ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open Case Details edit popup and update Summary + Court Index Number.");

         WebElement details_edit_button = p.Case_details_edit_buttons();
         details_edit_button.click();
         p.Summary_feild().sendKeys(data.get("Case.Summary"));
         p.Court_index_input().sendKeys(data.get("Case.Court Index Number"));
         p.Edit_form_buttons().get(1).click();
         p.Case_details_edit_buttons();
         Thread.sleep(500);

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>🟨 Actual:</b> Case Details saved (Summary updated, Court Index saved = " + data.get("Case.Court Index Number") + ")");

         // ========== Contacts Tab (Attorney import) ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Go to Contacts tab and link an Attorney contact from list.");

         tab_selector("Contacts");
         p.lawFirm_AddButton_ContactTab();
         rp.Scroll_to_element(p.Contact_AddButton_ContactTab());
         p.Contact_AddButton_ContactTab().click();
         p.Contact_type_dropdown_list();

         List<WebElement> Contact_Options = p.Contact_type_Options();
         for (WebElement Cn_opt : Contact_Options) {
             if (Cn_opt.getText().trim().equalsIgnoreCase("Attorney")) {
                 Cn_opt.click();
                 break;
             }
         }

         p.pop_up_contact_list();
         Thread.sleep(800);

         p.Popup_modal_search().sendKeys(data.get("Attorney.First Name"));
         Thread.sleep(800);

         WebElement toast = lg.toast();
         lg.Toast_close_button().click();
         rp.wait_for_invisibility(toast);
         Thread.sleep(800);

         List<WebElement> Checkboxes = p.List_Checkboxes();
         try {
             Checkboxes.get(0).click();
         } catch (Exception attorney_searched_not_present) {

             // ✅ You said: "no new TreeMaps". So call an overloaded method in Attorney_module that accepts Map OR direct strings.
             // Preferred: make this overload in Attorney_module:
             // Atttorney_Add_through_case(Map<String,String> data, WebDriver d)
             at.Atttorney_Add_through_case(data, d);

             Thread.sleep(800);
             WebElement Newtoast = lg.toast();
             lg.Toast_close_button().click();
             rp.wait_for_invisibility(Newtoast);
             p.List_Checkboxes().get(0).click();
         }

         Thread.sleep(600);
         WebElement Import_button = p.import_Button();
         rp.Scroll_to_element(Import_button);
         Import_button.click();
         lg.Toast_close_button().click();

         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Attorney contact selected and added to case contacts.");

         // ========== Applications Tab ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Go to Applications tab and open Buyout modal.");
         rp.Scroll_to_element(p.Application_tab_bar());

         try {
             tab_selector("Applications");
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully on retry attempt.");
         } catch (Exception tab_click) {
             Thread.sleep(800);
             tab_selector("Applications");
             Report_Listen.log_print_in_report().log(Status.INFO,
                     "<b>🟨 Actual:</b> First attempt to click Applications tab failed. Waiting 800ms and retrying once.<br>"
                             + "<b>🟡 Exception:</b> " + tab_click.getClass().getSimpleName());
             Thread.sleep(800);
         }

         p.Application_amount_edit_buttons().get(1).click();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Buyout modal opened.");

         // ========== Buyout Modal ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
         p.Modal_Input_Feilds().get(0).sendKeys(data.get("Case.Buyout Funder Name"));
         p.Modal_Input_Feilds().get(1).sendKeys(data.get("Case.Buyout Amount"));
         p.Modal_Input_Feilds().get(2).sendKeys(data.get("Case.Buyout Expiry Date"));
         p.Higlighted_calender_date().click();
         p.modal_buttons().get(1).click();
         Thread.sleep(800);

         try {
             Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d);
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual →</b> Toast after Buyout Amount: No toast captured / locator not visible.");
         }

         // ========== Approved Amount ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Open Approved Amount edit and enter Approved Amount.");

         List<WebElement> Amount_edit_buttons;
         try {
             Amount_edit_buttons = p.Application_amount_edit_buttons();
             Amount_edit_buttons.get(2).click();
         } catch (Exception em) {
             Thread.sleep(800);
             Amount_edit_buttons = p.Application_amount_edit_buttons();
             Amount_edit_buttons.get(2).click();
             Thread.sleep(800);
             Report_Listen.log_print_in_report().log(Status.INFO, "Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
             System.out.println("Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
             System.out.println();
         }

         p.Application_Amount_input_Fields().get(0).sendKeys(data.get("Case.Approved Amount"));
         p.table_body().click();
         Thread.sleep(800);

         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Approved Amount entered = " + data.get("Case.Approved Amount"));

         // ========== Status APPROVED ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Update Application Status to APPROVED from dropdown.");
         rp.movetoelement(p.Application_Details_Dropdown_Feild());
         p.Application_Details_Dropdown_Feild().click();
         p.plaintiff_dropdown_list();

         List<WebElement> Status_opts = p.Plaintiff_options();
         for (WebElement Stat_opt : Status_opts) {
             if (Stat_opt.getText().trim().contains("APPROVED")) {
                 Stat_opt.click();
                 break;
             }
         }
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Application status set to APPROVED.");

         // ========== Generate Contract ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Generate Contract and wait for Contract popup/modal.");
         p.Generate_contract_button().click();
         p.popup_modal();
         Thread.sleep(800);
         rp.movetoelement(p.Popup_add_form());
         Thread.sleep(800);
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Contract details modal opened.");

         // ========== Fees + RoR ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Fill contract fee fields and Rate of Return.");
         List<WebElement> Fee_feilds = p.fee_amount_feilds();
         rp.Scroll_to_element(Fee_feilds.get(0));
         rp.Feild_clear(Fee_feilds.get(0));
         Fee_feilds.get(0).sendKeys(data.get("Case.Document prep fee"));

         rp.Feild_clear(Fee_feilds.get(1));
         Fee_feilds.get(1).sendKeys(data.get("Case.Fund transfer fee"));

         rp.Scroll_to_element(p.rate_of_return_feild());
         rp.Feild_clear(p.rate_of_return_feild());
         p.rate_of_return_feild().sendKeys(data.get("Case.Rate of Return"));

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>🟨 Actual:</b> Fees + Rate of Return filled (DocPrep=" + data.get("Case.Document prep fee")
                         + ", FundTransfer=" + data.get("Case.Fund transfer fee")
                         + ", RoR=" + data.get("Case.Rate of Return") + ")");

         // ========== Agreement + Interest Dates ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Enter Agreement Date + Interest Start Date and confirm date selection.");
         rp.Scroll_to_element(p.Agreement_Date_feild());
         p.Agreement_Date_feild().sendKeys(data.get("Case.Agreement Date"));
         p.calender_date_select().click();

         p.Interest_Start_Date().sendKeys(data.get("Case.Interest Start Date"));
         p.rate_of_return_feild().click();
         Thread.sleep(600);

         WebElement Generate_Contract_Button = p.contract_generator_button();
         rp.movetoelement(Generate_Contract_Button);
         rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
         js.executeScript("arguments[0].click();", Generate_Contract_Button);
         Thread.sleep(800);

         try {
             p.Contract_editor();
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
             Report_Listen.log_print_in_report().log(Status.PASS,
                     "<b>✅ Final Result:</b> Case created successfully for Plaintiff=" + data.get("Plaintiff.First Name")
                             + " | CourtIndex=" + data.get("Case.Court Index Number")
                             + " | AgreementDate=" + data.get("Case.Agreement Date"));
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex=" + data.get("Case.Court Index Number"));
             throw e;
         }

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
         for (WebElement cell : cells) {
             String cell_text = cell.getText().trim();
             if (!cell_text.contains("/")) {
                 double cell_value = Double.parseDouble(cell_text.replace(",", "").replace("$", "").trim());
                 double cell_value_upto_2_decimal = Double.parseDouble(String.format("%.2f", cell_value));

                 if (Math.abs(Monthly_Payable_Amount_upto_2_decimal - cell_value) < 0.01) {
                     System.out.println("Testcase passed First month payable " + Monthly_Payable_Amount_upto_2_decimal + " is macthing contract text's first month payable " + cell_value_upto_2_decimal);
                     System.out.println();
                     Report_Listen.log_print_in_report().log(Status.INFO, "Testcase passed First month payable " + Monthly_Payable_Amount_upto_2_decimal + " is macthing contract text's first month payable " + cell_value_upto_2_decimal);
                 }
                 monthly_emi.add(cell_value_upto_2_decimal);
             }
         }

         // ---------- FUTURE MONTH VALIDATION ----------
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Validate future months lien calculation from Contract Lien table.");
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>📘 Description:</b> Each month lien should increase only by Monthly Interest compared to previous month.");
         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>✅ Expected:</b> For every month >= 1, (Current Month Payable - Previous Month Payable) should equal Monthly Interest = " + Monthly_Interest_Amount + ".");

         future_months_calculations_check(monthly_emi, Monthly_Interest_Amount);

         d.switchTo().defaultContent();
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Switch back from Contract iframe to main page (default content).");
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Driver focus returned to main page after reading Contract lien table.");
         Thread.sleep(800);

         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click <i>Save Changes</i> to save contract edits.");
         p.Save_changes_button().click();
         Thread.sleep(1800);

         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Capture toast after saving contract.");
         try {
             WebElement contract_saved_webelement = lg.toast();
             String contract_saved = contract_saved_webelement.getText().trim();
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Contract saved toast = " + contract_saved);
             System.out.println(contract_saved);
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
         }

         FluentWait<WebDriver> w = new FluentWait<WebDriver>(d)
                 .withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofMillis(500))
                 .ignoring(NoSuchElementException.class)
                 .ignoring(StaleElementReferenceException.class);

         // ========== Generate Contract again (send for signing) ==========
         Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click <i>Generate Contract</i> again to send contract for signing.");

         String Contract_Generated = "";
         try {
             Contract_Generated = lg.toast().getText().trim();
             Login_negative_testcases.Toast_printer(Contract_Generated, d);

             Report_Listen.log_print_in_report().log(Status.PASS,
                     String.format("<b>🟨 Actual:</b> ✅ Contract generation toast captured = <b>%s</b>", Contract_Generated));
             System.out.println("Actual  : Contract generation toast = " + Contract_Generated);
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>🟨 Actual:</b> ❌ Contract generation toast NOT captured.");
             System.out.println("Actual  : FAILED to capture contract generation toast");
         }

         try {
             Login_negative_testcases.Toast_printer(Contract_Generated, d);
             rp.wait_for_invisibility(lg.toast());
         } catch (Exception invis) {
             Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Toast invisibility wait skipped/failed (non-blocking).");
             System.out.println("Note    : Toast invisibility wait skipped/failed (non-blocking)");
         }

         Thread.sleep(1000);

         // ========== Manual Sign-In + lien generation ==========
         Report_Listen.log_print_in_report().log(Status.INFO,
                 String.format("<b>Step %d:</b> Click Manual Sign-In button and upload signed document to generate lien rows.<br><b>✅ Expected:</b> Liens should be generated and lien rows should be visible.", (step++)));

         System.out.println("--------------------------------------------------");
         System.out.println("[STEP] Manual Sign-In and lien generation");
         System.out.println("Expected : Upload/sign should complete and lien rows should exist");
         System.out.println("--------------------------------------------------");

         WebElement Cancel_Contract;
         WebElement Sign_in_button;

         try {
             Cancel_Contract = p.Cancel_Contract_Button();
             Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟦 Info:</b> Cancel Contract button detected. Waiting until it disappears before Manual Sign-In.");
             rp.wait_for_invisibility(Cancel_Contract);
         } catch (Exception cancel_contract_not_found) {
             Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟦 Info:</b> Cancel Contract button not found. Proceeding directly to Manual Sign-In.");
         }

         Sign_in_button = p.Manual_sign_in_button();
         rp.movetoelement(Sign_in_button);
         Thread.sleep(800);
         rp.wait_for_theElement_tobe_clickable(Sign_in_button);

         try {
             Sign_in_button.click();
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Manual Sign-In button clicked.");
         } catch (Exception e) {
             Thread.sleep(800);
             rp.movetoelement(Sign_in_button);
             rp.wait_for_theElement_tobe_clickable(Sign_in_button);
             Sign_in_button.click();
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Manual Sign-In button clicked (Retry success).");
         }

         try {
             List<WebElement> lienRowsAfterManualSign = manual_lien_generation(Sign_in_button);
             int lienCount = (lienRowsAfterManualSign == null) ? 0 : lienRowsAfterManualSign.size();

             Report_Listen.log_print_in_report().log(Status.PASS,
                     String.format("<b>🟨 Actual:</b> ✅ Manual signing completed. Lien rows found = <b>%d</b>", lienCount));
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>🟨 Actual:</b> ❌ manual_lien_generation failed (upload/sign/liens fetch issue).");
             throw e;
         }

         // =========================
         // ✅ Payment Calculator (Payoff validation)
         // =========================
         Report_Listen.log_print_in_report().log(Status.INFO,
                 String.format("<b>Step %d:</b> Run Payment_Calculator to validate payoff reduction after payment.<br>"
                                 + "<b>📥 Input:</b> Case ID = <b>%s</b><br>"
                                 + "<b>✅ Expected:</b> Reduction should match fees paid (tolerance 0.01).",
                         (step++), Case_ID));

         try {
             // ✅ change these method signatures to accept Map<String,String> data instead of TreeMap Case_Data
             Pay_off_lien_list_After_Revise_contract(data, Case_ID);
             Payment_Calculator(data, Case_ID);

             Report_Listen.log_print_in_report().log(Status.PASS,
                     String.format("<b>🟨 Actual:</b> ✅ Payment_Calculator executed successfully for Case ID = <b>%s</b>", Case_ID));
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL,
                     String.format("<b>🟨 Actual:</b> ❌ Payment_Calculator failed for Case ID = <b>%s</b>", Case_ID));
             throw e;
         }

         // =========================
         // ✅ Underwriting Notes
         // =========================
         Report_Listen.log_print_in_report().log(Status.INFO,
                 String.format("<b>Step %d:</b> Add Underwriting Notes for this case.<br>"
                                 + "<b>📥 Input:</b> Underwriting Notes + Tag from dataset<br>"
                                 + "<b>✅ Expected:</b> Notes should save and toast should appear.",
                         (step++)));

         try {
             // ✅ change this signature to accept Map<String,String> data
             Underwriting_Notes(data);

             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Underwriting notes saved successfully.");
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "<b>🟨 Actual:</b> ❌ Underwriting notes save failed.");
             throw e;
         }

         // =========================
         // ✅ END
         // =========================
         Report_Listen.log_print_in_report().log(Status.INFO,
                 String.format("<b>✅ End of Test:</b> Add_case completed for Case ID = <b>%s</b>", Case_ID));

         System.out.println("==================================================");
         System.out.println("[END] Add_case completed successfully");
         System.out.println("Case ID : " + Case_ID);
         System.out.println("==================================================");
         System.out.println();
 		
 		
	
                          }






  // Overloaded version for Cucumber parameter acceptance
     public void Pay_off_lien_list_After_Revise_contract(Map<String, String> Case_Data, String id) throws IOException, InterruptedException {
         
         Application_Locaters p = new Application_Locaters(d);
         Login_Locaters lg = new Login_Locaters(d);
         SIde_Menu_Handler sd = new SIde_Menu_Handler();
         Repeat rp = new Repeat(d);
         
         int step = 1;
         String Case_id = id;
         
         PayoffTable_values_Revise_contract.clear();
         
         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<div style='background:#f1f5ff; padding:16px; border-radius:12px; border:1px solid #cbd5ff; color:#0b1b33; font-family:Arial;'>"
               + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario: Payoff Values Capture AFTER Revise Contract</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Navigate to the case, revise contract (buyout + interest start date), then open Payoff modal and capture month-wise payoff values.</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📥 Input:</b> Case ID = <b>" + Case_id + "</b></div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>✅ Expected:</b> After contract revision, Payoff modal should load and payoff rows should be captured into map.</div>"
               + "</div>"
         );

         System.out.println("\n==================================================");
         System.out.println("[SCENARIO] Payoff Values Capture AFTER Revise Contract");
         System.out.println("Case ID   : " + Case_id);
         System.out.println("Expected  : Payoff rows should be visible and stored after revise contract");
         System.out.println("==================================================\n");

         try {
             p.Case_Action_Dropdown();
         } catch (Exception not_in_Case_Details) {	    
             sd.Side_menu_option_clicker("Applications", d, "N/A");
             p.landed_in_applicationList_confirmation();
             p.Filter_clear().click();
             WebElement Search = p.Application_search();
             Search.sendKeys(Case_id);
             Thread.sleep(1800);
             
             // Handle potential toasts overlapping search results
             try { lg.Toast_close_button().click(); } catch(Exception e) {}
             try { lg.Toast_close_button().click(); } catch(Exception e) {}
             
             List<WebElement> result_rows;
             try {
                 result_rows = p.rows();
                 result_rows.get(0).click();
                 Thread.sleep(800);
             } catch (Exception Result_still_not_fetched) {
                 System.out.println("Exception Found in fetching result rows thereby retrying");
                 Thread.sleep(800);  
                 result_rows = p.rows();
                 result_rows.get(0).click();
                 Thread.sleep(800);
             }
             
             try {
                 p.Case_tags();
             } catch (RuntimeException tags) {
                 System.out.println("RuntimeException Found in case tags fetching thereby retrying");
                 Thread.sleep(1200);
                 p.Case_tags(); 
             }
         }
         
         try {
             tab_selector("Liens");
         } catch (Exception Lien_tab_retry) {
             Thread.sleep(800);
             tab_selector("Liens");
         }
         
         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>Step " + (step++) + ":</b> Perform <b>Revise Contract</b> flow (Buyout update + Interest Start Date update + Generate Contract)."
         );
         
         WebElement payoff_button = p.Payoff_Button();
         rp.Scroll_to_element(payoff_button);
         rp.wait_for_Clickable(payoff_button);
         payoff_button.click();
         p.Payoff_table_title();
         
         List<WebElement> Cells;
         try {
             Cells = p.modal_table_cells();
         } catch (Exception pay_off_table_rows_not_found) {
             Thread.sleep(800);
             p.modal_table();
             Cells = p.modal_table_cells();
         }
         
         int m = 0;
         for (WebElement Cell : Cells) {
             String cellvalue = Cell.getText().trim();
             if (!cellvalue.contains("/")) {
                 String cellvalue_clean = cellvalue.replace("$", "").replace(",", "").replace("\u00A0", "").trim();
                 double each_month_payable_raw = Double.parseDouble(cellvalue_clean);
                 double each_month_payable = Double.parseDouble(String.format("%.2f", each_month_payable_raw));
                 PayoffTable_values_Revise_contract.put("month " + m, each_month_payable);
                 m++;
             }
         }
         
         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>🟨 Actual:</b> Stored payoff values After Contract Revised. Rows captured = <b>" + PayoffTable_values_Revise_contract.size() + "</b>"
         );
         
         p.Close_Button().click(); 
     }


  // Overloaded version for Cucumber parameter acceptance
     public void Payment_Calculator(Map<String, String> data, String Case_Unique_id) throws IOException, InterruptedException {
         
         String Case_id = Case_Unique_id;
         int step = 1;
         double tolerance = 0.01;

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<div style='background:#f1f5ff; padding:16px; border-radius:12px; border:1px solid #cbd5ff; color:#0b1b33; font-family:Arial;'>"
               + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario Title: Payment Payoff Validation (Before vs After Payment)</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Capture Payoff table values BEFORE payment, log payment, capture Payoff table values AFTER payment, and validate reduction.</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📥 Input:</b> Case ID = <b>" + Case_id + "</b></div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>✅ Expected:</b> (Before − After) should match Fees Paid within tolerance 0.01.</div>"
               + "</div>"
         );

         System.out.println("[Step] Fetch Payoff table values BEFORE payment");
         Pay_off_lien_list_Before_payment(Case_id);

         System.out.println("[Step] Log Payment and capture Fees Paid amount");
         
         // Call your payment logger which returns the formatted string of the amount paid
         String Fees_payed_amount = Payment_Logger(data, Case_id);
         double Fees_payed_in_double_upto_two_decimal = Double.parseDouble(String.format("%.2f", Double.parseDouble(Fees_payed_amount)));

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<div style='background:#eef9ff; padding:14px; border-radius:10px; border:1px solid #bfe6ff; color:#0b1b33;'>"
               + "<b>🟨 Actual:</b> Fees Paid captured from Payment Logger = <b>" + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "</b><br>"
               + "</div>"
         );

         System.out.println("[Step] Fetch Payoff table values AFTER payment");
         Pay_off_lien_list_After_payment_data_fetcher(Case_id);

         for (Map.Entry<String, Double> after_pair : PayoffTable_values_After_Payment.entrySet()) {
             String Key = after_pair.getKey();

             if (!PayoffTable_values_Before_Payment.containsKey(Key)) {
                 continue;
             }

             double Before_payment = PayoffTable_values_Before_Payment.get(Key);
             double After_payment = PayoffTable_values_After_Payment.get(Key);

             double reduction = Before_payment - After_payment;
             double reduction_upto_two_decimal = Double.parseDouble(String.format("%.2f", reduction));
             double difference = Double.parseDouble(String.format("%.2f", Math.abs(reduction_upto_two_decimal - Fees_payed_in_double_upto_two_decimal)));

             boolean isMatched = difference < tolerance;

             String resultColorBox = isMatched ? "background:#e9fbe9; border:1px solid #bde5bd; color:#0b3b0b;" : "background:#ffecec; border:1px solid #ffbdbd; color:#5b0b0b;";

             String payoffExtentCard =
                     "<div style='background:#f7fbff; padding:18px; border-radius:12px; border:1px solid #c7ddff; color:#0b1b33; font-family:Arial;'>"
                   + "<div style='font-size:16px; font-weight:700; margin-bottom:10px;'>" + (isMatched ? "✅ PASS" : "❌ FAIL") + " — " + Key + "</div>"
                   + "<b>Before:</b> " + String.format("%.2f", Before_payment) + "<br>"
                   + "<b>After:</b> " + String.format("%.2f", After_payment) + "<br>"
                   + "<b>Reduction:</b> " + String.format("%.2f", reduction_upto_two_decimal) + "<br>"
                   + "<b>Fees Paid:</b> " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "<br>"
                   + "<div style='margin-top:12px; padding:12px; border-radius:10px; " + resultColorBox + "'>"
                   + "<b>Difference:</b> " + String.format("%.2f", difference) + " (Tolerance: " + tolerance + ")"
                   + "</div>"
                   + "</div>";

             Report_Listen.log_print_in_report().log(isMatched ? Status.PASS : Status.FAIL, payoffExtentCard);
         }
     }
     
  // Overloaded version for Cucumber parameter acceptance
     public String Payment_Logger(Map<String, String> data, String Case_Id) throws IOException, InterruptedException {
         
         SIde_Menu_Handler sd = new SIde_Menu_Handler();
         Application_Locaters p = new Application_Locaters(d);
         Repeat rp = new Repeat(d);
         Login_Locaters lg = new Login_Locaters(d);
         
         int step = 1;
         String Case_id = Case_Id;

         // Use keys matching your Cucumber Map format
         double Document_prep_fee = Double.parseDouble(data.get("Case.Document prep fee"));
         double Fundtransferfee = Double.parseDouble(data.get("Case.Fund transfer fee"));

         double Total_Fees = Document_prep_fee + Fundtransferfee;
         double Amount_to_be_payed = Total_Fees / 2;

         double Amount_to_be_payed_upto_2_decimal = Double.parseDouble(String.format("%.2f", Amount_to_be_payed));
         String Amount_to_be_payed_text = String.format("%.2f", Amount_to_be_payed_upto_2_decimal);

         String Mode = data.get("Case.Payment Mode");
         String Type = data.get("Case.Payment Type");
         String Payer = data.get("Case.Payer Name");
         String PayDate = data.get("Case.Payment Date");
         String Notes = data.get("Case.Notes / Remarks");
         String Plaintiff_name;

         // =========================
         // Scenario Header (Extent)
         // =========================
         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<div style='background:#f1f5ff; padding:16px; border-radius:12px; border:1px solid #cbd5ff; color:#0b1b33; font-family:Arial;'>"
               + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario Title: Payment Logger – Record Payment (50% Fees)</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Open <b>Log Payment</b> form, enter payment details, and verify success.</div>"
               + "<div style='margin-top:10px; font-size:13px;'><b>📥 Input:</b> Case ID = <b>" + Case_id + "</b></div>"
               + "</div>"
         );

         // =========================
         // Step 1: Ensure in Case Details
         // =========================
         WebElement case_Dropdown;
         try {
             case_Dropdown = p.Case_Action_Dropdown();
         } catch (Exception not_in_Case_Details) {
             sd.Side_menu_option_clicker("Applications", d, "N/A");
             p.landed_in_applicationList_confirmation();
             p.Filter_clear().click();

             WebElement Search = p.Application_search();
             Search.sendKeys(Case_id);
             Thread.sleep(1800);

             try { lg.Toast_close_button().click(); } catch (Exception ignore) {}

             List<WebElement> result_rows = p.rows();
             result_rows.get(0).click();
             Thread.sleep(800);

             try { p.Case_tags(); } catch (RuntimeException tags) { Thread.sleep(1200); p.Case_tags(); }
             case_Dropdown = p.Case_Action_Dropdown();
         }

         try {
             WebElement plaintiff = p.Title_plaintiff_name();
             Plaintiff_name = plaintiff.getText().trim();
         } catch (Exception e) {
             Thread.sleep(800);
             Plaintiff_name = p.Title_plaintiff_name().getText().trim();
         }

         // =========================
         // Step 2: Open Log Payment form
         // =========================
         rp.movetoelement(case_Dropdown);
         try {
             p.Case_Action_Dropdown_list();
         } catch (Exception e) {
             rp.movetoelement(case_Dropdown);
             Thread.sleep(800);
             p.Case_Action_Dropdown_list();
         }

         List<WebElement> optionsElements = p.Case_Dropdown_Options();
         boolean found = false;
         for (WebElement Each_Option : optionsElements) {
             if (Each_Option.getText().trim().contains("Log Payment")) {
                 Each_Option.click();
                 found = true;
                 break;
             }
         }

         if (!found) throw new RuntimeException("Log Payment option not found in Case Action dropdown.");

         // =========================
         // Step 3: Fill payment form
         // =========================
         List<WebElement> inputs = p.payment_logger_form_inputs();
         inputs.get(0).sendKeys(Mode);
         p.plaintiff_dropdown_list();
         p.Plaintiff_options().get(0).click();

         inputs.get(1).sendKeys(Type);
         p.Incident_type_dropdown();
         p.Incident_options().get(0).click();

         if (Type.contains("Payment by Plaintiff")) {
             inputs.get(2).sendKeys(Plaintiff_name);
         } else {
             inputs.get(2).sendKeys(Payer);
         }

         WebElement Calender_field = inputs.get(3);
         Calender_field.sendKeys(PayDate);
         Calender_field.click();
         p.calender_date_select().click();

         inputs.get(4).sendKeys(Amount_to_be_payed_text);
         p.textArea().sendKeys(Notes);

         p.poup_up_form_buttons().get(0).click();

         // =========================
         // Step 4: Capture toast
         // =========================
         try {
             String paymentToast = lg.toast().getText().trim();
             Report_Listen.log_print_in_report().log(Status.PASS, "✅ Payment logged successfully. Toast: " + paymentToast);
             try { rp.wait_for_invisibility(lg.toast()); } catch (Exception ignore) {}
         } catch (Exception e) {
             Report_Listen.log_print_in_report().log(Status.FAIL, "❌ Payment confirmation toast not captured.");
         }

         return Amount_to_be_payed_text;
     }





  // Overloaded version for Cucumber parameter acceptance
     public void Underwriting_Notes(Map<String, String> Case_Data) throws InterruptedException, IOException {
         
         Application_Locaters p = new Application_Locaters(d);
         Login_Locaters lg = new Login_Locaters(d);
         SIde_Menu_Handler sd = new SIde_Menu_Handler();

         // Note: We use keys matching the Cucumber Map format (e.g., "Case.Underwriting Notes")
         String notesContent = Case_Data.get("Case.Underwriting Notes");
         String tagContent = Case_Data.get("Case.Underwriting Tag");

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>🔹 Scenario Title:</b> Underwriting – Add Underwriting Notes and Tag");

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>📘 Description:</b> Validate that a user can open the Underwriting tab and add Underwriting Notes + Underwriting Tag, then save successfully.");

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>📥 Input:</b> Underwriting Notes = <b>" + notesContent + "</b> | Underwriting Tag = <b>" + tagContent + "</b>");

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>✅ Expected:</b> Underwriting Notes should be saved successfully and confirmation toast should appear.");

         try {
             p.Case_Action_Dropdown();
             tab_selector("Underwriting");
             p.Notes_Add_Button();
             Report_Listen.log_print_in_report().log(Status.INFO,
                     "<b>🟨 Actual:</b> User is already inside Case → Underwriting tab context.");
         } catch (Exception Not_Inside_Case_UnderWriting_Tab) {
             Report_Listen.log_print_in_report().log(Status.INFO,
                     "<b>🟨 Actual:</b> User was not inside Case Underwriting Tab. Navigating via Applications → Funded → First record.");
             sd.Side_menu_option_clicker("Applications", d, "N/A");
             p.landed_in_applicationList_confirmation();
             p.Filter_clear().click();
             
             WebElement Status_filter = p.Application_status_filter();
             Status_filter.click();
             Application_Filter_Option_Selector("Funded");
             p.rows().get(0).click();
             Thread.sleep(800);
         }

         List<WebElement> Case_Tags;
         try {
             Case_Tags = p.Case_tags();
         } catch (RuntimeException tags) {
             System.out.println("RuntimeException Found in case tags fetching thereby retrying");
             Thread.sleep(1200);
             Case_Tags = p.Case_tags();
         }

         Report_Listen.log_print_in_report().log(Status.INFO,
                 "<b>🟨 Actual:</b> Case opened successfully and Underwriting tab is accessible.");
         
         p.Case_Action_Dropdown();
         tab_selector("Underwriting");
         
         WebElement Notes_Add_Button = p.Notes_Add_Button();	
         Notes_Add_Button.click();
         
         List<WebElement> inputs = p.Edit_form_inputs();
         p.textArea().sendKeys(notesContent);
         inputs.get(0).sendKeys(tagContent);
         p.Submit_Button().click();

         try {
             WebElement Toast = lg.toast();
             Login_negative_testcases.Toast_printer(Toast.getText().trim(), d);
             Report_Listen.log_print_in_report().log(Status.PASS,
                     "<b>🟨 Actual:</b> ✅ Underwriting Notes saved successfully. Toast captured and confirms save.");
         } catch (Exception Toast_Not_Found) {
             System.out.println("Toast Not found after saving Underwriting Notes");
             Report_Listen.log_print_in_report().log(Status.FAIL,
                     "<b>🟨 Actual:</b> ❌ Underwriting Notes save confirmation toast was not found after clicking Submit.");
             throw Toast_Not_Found;
         }
     }}