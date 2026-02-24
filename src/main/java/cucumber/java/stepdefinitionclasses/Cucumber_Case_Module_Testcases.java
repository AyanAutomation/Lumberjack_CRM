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
	
	   private void bindDriver() {
	        super.d = Base_cucumber.d;
	    }
	

public void Add_New_Case_Form_Accessor(int s) throws IOException, InterruptedException{
		
	    
	
		Application_Locaters p = new Application_Locaters(d);
		Header_functionality_manager hd = new Header_functionality_manager();
		
		int step = s;
		Report_Listen.log_print_in_report().log(Status.INFO,
			    "<b>Step "+(step++)+":</b> Click <b>Case Add</b> button from Header<br>"
			  + "<b>📘 Description:</b> User uses header Case Add button to directly open the New Case Add popup<br>"
			  + "<b>✅ Expected:</b> New Case popup should open");
	        hd.header_buttons_clicker(s,d);
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Header <b>Case Add</b> button clicked.");
	        Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>Step "+(step++)+":</b> Verify New Case popup is opened<br>"
	         + "<b>📘 Description:</b> System should display the case creation popup/form after header Case Add click<br>"
	         + "<b>✅ Expected:</b> New Case Add popup form should be visible and ready for input");
			p.Popup_add_form();}
	
  

     
     

     @Given("Add_case_cucumber with data:")
     public void Add_case_cucumber(DataTable table) throws IOException, InterruptedException{ 
	 
    	 bindDriver();

         // ✅ One map only (no TreeMap objects)
    	 Map<String, String> data = new TreeMap<>(table.asMap(String.class, String.class));
    	 data.remove("Key");

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

         int step = 0;

         Add_New_Case_Form_Accessor(step);
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

         tab_selector("Contacts",d);
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
             tab_selector("Applications",d);
             Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully on retry attempt.");
         } catch (Exception tab_click) {
             Thread.sleep(800);
             tab_selector("Applications",d);
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
         System.out.println();}


   @Given("Buyout_Add_and_Fees_changed_in_Revised_Contract with data:")
   public void Buyout_Add_and_Fees_changed_in_Revised_Contract(DataTable table)
        throws InterruptedException, IOException {

	bindDriver();

    // ✅ One map only
    Map<String, String> data = new TreeMap<>(table.asMap(String.class, String.class));
    data.remove("Key"); // because feature table has | Key | Value |

    // ✅ Dynamic system dates INLINE
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String today  = LocalDate.now().format(fmt);
    String expiry = LocalDate.now().plusYears(4).format(fmt);

    data.put("Case.Payment Date", today);
    data.put("Case.Agreement Date", today);
    data.put("Case.Interest Start Date", today);
    data.put("Case.Buyout Expiry Date", expiry);

    Application_Locaters p = new Application_Locaters(d);
    Login_Locaters lg = new Login_Locaters(d);
    Repeat rp = new Repeat(d);
    JavascriptExecutor js = (JavascriptExecutor) d;

    // ✅ Cucumber-friendly Attorney helper (your new module)
    Attorney_Modules_Cucumber at = new Attorney_Modules_Cucumber();

    monthly_emi.clear();

    // ==========================================================
    // ✅ FETCH ONCE & REUSE
    // ==========================================================
    final String plaintiffFirstName = data.get("Plaintiff.First Name");

    final String caseType        = data.get("Case.Case Type");
    final String state           = data.get("Case.State");
    final String incidentDate    = data.get("Case.Date of Incident");
    final String leadSource      = data.get("Case.Lead Source");
    final String requestedAmount = data.get("Case.Requested Amount");
    final String summary         = data.get("Case.Summary");
    final String courtIndex      = data.get("Case.Court Index Number");

    final String buyoutFunderName = data.get("Case.Buyout Funder Name");
    final String buyoutExpiryDate = data.get("Case.Buyout Expiry Date");

    final int buyoutAmount     = Integer.parseInt(data.get("Case.Buyout Amount"));
    final int approvedAmount   = Integer.parseInt(data.get("Case.Approved Amount"));
    final int documentPrepFee  = Integer.parseInt(data.get("Case.Document prep fee"));
    final int fundTransferFee  = Integer.parseInt(data.get("Case.Fund transfer fee"));
    final int rateOfReturn     = Integer.parseInt(data.get("Case.Rate of Return"));

    // ---- Calculations ----
    // NOTE: You earlier used ONLY Approved for funded amount in this scenario. Keeping same logic.
    final double fundedAmount = approvedAmount;
    final double annualInterestAmount  = (fundedAmount * rateOfReturn) / 100;
    final double monthlyInterestAmount = annualInterestAmount / 12;
    final double monthlyPayableAmount  = fundedAmount + monthlyInterestAmount + documentPrepFee + fundTransferFee;

    final double monthlyPayableAmount_2d  = Double.parseDouble(String.format("%.2f", monthlyPayableAmount));
    final double monthlyInterestAmount_2d = Double.parseDouble(String.format("%.2f", monthlyInterestAmount));

    // ==========================================================
    // Scenario Header Logs
    // ==========================================================
    int step = 1;
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🔹 Scenario Title:</b> Buyout Add + Fees Changed in Revised Contract<br>"
          + "<b>📘 Description:</b> Create case → generate contract → sign flow trigger → capture payoff before → revise contract → capture payoff after revise.<br>"
          + "<b>📥 Input:</b> Plaintiff=" + plaintiffFirstName + " | CourtIndex=" + courtIndex + " | CaseType=" + caseType + "<br>"
          + "<b>✅ Expected:</b> Contract editor opens, revised contract validations pass, payoff values are captured as expected."
    );

    System.out.println("\n==================================================");
    System.out.println("[SCENARIO] Buyout Add + Fees Changed in Revised Contract");
    System.out.println("Plaintiff First Name : " + plaintiffFirstName);
    System.out.println("Court Index Number   : " + courtIndex);
    System.out.println("Case Type            : " + caseType);
    System.out.println("==================================================\n");

    // ==========================================================
    // Step 1: Open New Case Form  ✅ (constant index)
    // ==========================================================
    Add_New_Case_Form_Accessor(0);
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> New Case form/popup opened.");

    // ==========================================================
    // Step 2: Select Plaintiff
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Search and select existing Plaintiff from dropdown.<br>"
          + "<b>📥 Input:</b> Plaintiff First Name = <b>" + plaintiffFirstName + "</b><br>"
          + "<b>✅ Expected:</b> Plaintiff should be selected from dropdown."
    );
    p.form_inputs().get(0).sendKeys(plaintiffFirstName);
    p.plaintiff_dropdown_list();
    p.Plaintiff_options().get(0).click();
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Plaintiff selected = " + plaintiffFirstName);

    // ==========================================================
    // Step 3: Case Type
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Select Incident/Case Type from dropdown.<br>"
          + "<b>📥 Input:</b> Case Type = <b>" + caseType + "</b><br>"
          + "<b>✅ Expected:</b> Case Type should be selected from dropdown list."
    );
    p.form_inputs().get(1).sendKeys(caseType);
    p.form_inputs().get(1).click();
    p.Incident_type_dropdown();
    option_printers("Incident Options are ", p.Incident_options());
    p.Incident_options().get(0).click();
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Incident/Case type selected for input = " + caseType);

    // ==========================================================
    // Step 4: State
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Select State of Incident from dropdown.<br>"
          + "<b>📥 Input:</b> State = <b>" + state + "</b><br>"
          + "<b>✅ Expected:</b> State should be selected from dropdown list."
    );
    p.form_inputs().get(2).sendKeys(state);
    p.form_inputs().get(2).click();
    p.State_of_incident_dropdown();
    p.State_of_incident_options().get(0).click();
    Thread.sleep(500);
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> State selected = " + state);

    // ==========================================================
    // Step 5: Date of Incident
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Enter Date of Incident and confirm date selection.<br>"
          + "<b>📥 Input:</b> Date of Incident = <b>" + incidentDate + "</b><br>"
          + "<b>✅ Expected:</b> Date should be entered and calendar selection should be applied."
    );
    WebElement calender_field = p.form_inputs().get(3);
    calender_field.sendKeys(incidentDate);
    calender_field.click();
    p.calender_date_select().click();
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Date of Incident entered/selected = " + incidentDate);

    // ==========================================================
    // Step 6: Lead Type + Lead Source
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Select Lead Type and Lead Source.<br>"
          + "<b>📥 Input:</b> Lead Source = <b>" + leadSource + "</b><br>"
          + "<b>✅ Expected:</b> Lead Type & Lead Source should be selected."
    );
    rp.Scroll_to_element(p.form_inputs().get(4));
    p.form_inputs().get(4).sendKeys(leadSource);
    p.Lead_Type_dropdown();
    p.Lead_category_options().get(0).click();
    p.form_inputs().get(5).click();
    p.Lead_dropdown();
    p.Leadoptions().get(0).click();
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Lead type/source selected (Lead Source input = " + leadSource + ")");

    // ==========================================================
    // Step 7: Requested Amount + Create Case
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Enter Requested Amount and click Create/Save Case.<br>"
          + "<b>📥 Input:</b> Requested Amount = <b>" + requestedAmount + "</b><br>"
          + "<b>✅ Expected:</b> Case should be created and a toast may appear."
    );
    rp.Scroll_to_element(p.form_inputs().get(5));
    p.form_inputs().get(6).sendKeys(requestedAmount);
    p.form_buttons().get(1).click();
    Thread.sleep(800);

    // toast is optional; Case ID must be captured regardless
    try { Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d); }
    catch (Exception ignore) {}

    WebElement CaseId = p.Case_ID_Tag();
    String Case_ID = CaseId.getText().trim();
    System.out.println("Case ID : " + Case_ID + "\n");

    // ==========================================================
    // Step 8: Update Summary/Court Index
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Open Case Details edit popup and update Summary + Court Index Number.<br>"
          + "<b>📥 Input:</b> Court Index = <b>" + courtIndex + "</b><br>"
          + "<b>✅ Expected:</b> Details should save without UI errors."
    );

    p.Case_details_edit_buttons().click();
    p.Summary_feild().sendKeys(summary);
    p.Court_index_input().sendKeys(courtIndex);
    p.Edit_form_buttons().get(1).click();
    Thread.sleep(500);

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Case details saved (Summary updated, Court Index saved = " + courtIndex + ")");

    // ==========================================================
    // Step 9: Contacts tab → Add Attorney
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Go to Contacts tab and link an Attorney contact from list.<br>"
          + "<b>📥 Input:</b> Attorney First Name = <b>" + data.get("Attorney.First Name") + "</b><br>"
          + "<b>✅ Expected:</b> Attorney should be added to case contacts."
    );

    tab_selector("Contacts", d);

    WebElement Add_Contact_Button = p.Contact_AddButton_ContactTab();
    rp.Scroll_to_element(Add_Contact_Button);
    try { Add_Contact_Button.click(); }
    catch (Exception e) { Thread.sleep(800); Add_Contact_Button.click(); }

    p.Contact_type_dropdown_list();

    for (WebElement Cn_opt : p.Contact_type_Options()) {
        if (Cn_opt.getText().trim().equalsIgnoreCase("Attorney")) {
            Cn_opt.click();
            break;
        }
    }

    p.pop_up_contact_list();
    Thread.sleep(800);

    // Search attorney
    p.Popup_modal_search().sendKeys(data.get("Attorney.First Name"));
    Thread.sleep(800);

    // Close toast if blocks list
    try { lg.Toast_close_button().click(); } catch (Exception ignore) {}

    // Select first result; if not present → add attorney via cucumber module then retry
    try {
        p.List_Checkboxes().get(0).click();
    } catch (Exception attorney_not_present) {

        // ✅ This must exist as your cucumber overload:
        // public void Atttorney_Add_through_case(Map<String,String> data, WebDriver d)
        at.Atttorney_Add_through_case(data, d);

        Thread.sleep(800);
        try { lg.Toast_close_button().click(); } catch (Exception ignore) {}
        p.List_Checkboxes().get(0).click();
    }

    Thread.sleep(600);
    WebElement Import_button = p.import_Button();
    rp.Scroll_to_element(Import_button);
    Import_button.click();

    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Attorney contact selected and added to case contacts.");

    // ==========================================================
    // Step 10: Applications tab + Buyout modal
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Go to Applications tab.<br>"
          + "<b>✅ Expected:</b> Applications tab should open."
    );

    rp.Scroll_to_element(p.Application_tab_bar());
    try {
        tab_selector("Applications", d);
        Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully (1st attempt).");
    } catch (Exception tab_click) {
        Thread.sleep(800);
        tab_selector("Applications", d);
        Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully (Retry Attempt).");
    }

    // Close toast if present
    try { lg.Toast_close_button().click(); } catch (Exception ignore) {}

    // Open Buyout modal
    p.Application_amount_edit_buttons().get(1).click();
    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Buyout modal opened.");

    // ==========================================================
    // Step 11: Fill Buyout Modal (Funder, Amount, Expiry)
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Fill Buyout details and save.<br>"
          + "<b>📥 Input:</b> Funder=" + buyoutFunderName + " | Amount=" + buyoutAmount + " | Expiry=" + buyoutExpiryDate
    );

    p.Modal_Input_Feilds().get(0).sendKeys(buyoutFunderName);
    p.Modal_Input_Feilds().get(1).sendKeys(String.valueOf(buyoutAmount));
    p.Modal_Input_Feilds().get(2).sendKeys(buyoutExpiryDate);
    p.Higlighted_calender_date().click();
    p.modal_buttons().get(1).click();
    Thread.sleep(800);

    try { Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d); }
    catch (Exception e) {
        Report_Listen.log_print_in_report().log(Status.INFO,
                "<b>🟨 Actual:</b> Toast after Buyout save not captured (toast not visible / locator issue).");
    }

    // ==========================================================
    // Step 12: Approved Amount
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Open Approved Amount edit and enter Approved Amount.<br>"
          + "<b>📥 Input:</b> Approved Amount = <b>" + approvedAmount + "</b>"
    );

    List<WebElement> Amount_edit_buttons;
    try {
        Amount_edit_buttons = p.Application_amount_edit_buttons();
        Amount_edit_buttons.get(2).click();
    } catch (Exception em) {
        Thread.sleep(800);
        Amount_edit_buttons = p.Application_amount_edit_buttons();
        Amount_edit_buttons.get(2).click();
    }

    p.Application_Amount_input_Fields().get(0).sendKeys(String.valueOf(approvedAmount));
    p.table_body().click();
    Thread.sleep(800);

    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Approved Amount entered = " + approvedAmount);

    // ==========================================================
    // Step 13: Status = APPROVED
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Update Application Status to APPROVED from dropdown."
    );

    WebElement status_dropdown = p.Application_Details_Dropdown_Feild();
    rp.movetoelement(status_dropdown);
    status_dropdown.click();
    p.plaintiff_dropdown_list();

    for (WebElement Stat_opt : p.Plaintiff_options()) {
        if (Stat_opt.getText().trim().contains("APPROVED")) {
            Stat_opt.click();
            break;
        }
    }

    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Application status set to APPROVED.");

    // ==========================================================
    // Step 14: Generate Contract modal
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Click Generate Contract and wait for Contract popup/modal."
    );

    p.Generate_contract_button().click();
    p.popup_modal();
    Thread.sleep(800);
    rp.movetoelement(p.Popup_add_form());
    Thread.sleep(800);

    // ==========================================================
    // Step 15: Fill Fees + RoR
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Fill contract fee fields and Rate of Return.<br>"
          + "<b>📥 Input:</b> DocPrep=" + documentPrepFee + " | FundTransfer=" + fundTransferFee + " | RoR=" + rateOfReturn
    );

    List<WebElement> Fee_feilds = p.fee_amount_feilds();
    rp.Scroll_to_element(Fee_feilds.get(0));
    rp.Feild_clear(Fee_feilds.get(0));
    Fee_feilds.get(0).sendKeys(String.valueOf(documentPrepFee));

    rp.Feild_clear(Fee_feilds.get(1));
    Fee_feilds.get(1).sendKeys(String.valueOf(fundTransferFee));

    rp.Scroll_to_element(p.rate_of_return_feild());
    rp.Feild_clear(p.rate_of_return_feild());
    p.rate_of_return_feild().sendKeys(String.valueOf(rateOfReturn));

    // ==========================================================
    // Step 16: Agreement + Interest Start dates + Generate
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Enter Agreement Date + Interest Start Date and generate contract.<br>"
          + "<b>📥 Input:</b> Agreement Date=" + data.get("Case.Agreement Date") + " | Interest Start Date=" + data.get("Case.Interest Start Date")
    );

    rp.Scroll_to_element(p.Agreement_Date_feild());
    p.Agreement_Date_feild().sendKeys(data.get("Case.Agreement Date"));
    p.calender_date_select().click();

    p.Interest_Start_Date().sendKeys(data.get("Case.Interest Start Date"));
    p.rate_of_return_feild().click();
    Thread.sleep(600);

    WebElement Generate_Contract_Button = p.Submit_button();
    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
    js.executeScript("arguments[0].click();", Generate_Contract_Button);
    Thread.sleep(800);

    try {
        p.Contract_editor();
        Report_Listen.log_print_in_report().log(Status.PASS, "<b>🟨 Actual:</b> ✅ Contract Editor opened successfully.");
    } catch (Exception e) {
        Report_Listen.log_print_in_report().log(Status.FAIL,
                "<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Retrying click once.");
        WebElement btn = p.Submit_button();
        rp.wait_for_theElement_tobe_clickable(btn);
        js.executeScript("arguments[0].click();", btn);
    }

    // ==========================================================
    // Step 17: iframe → read lien table + validations
    // ==========================================================
    WebElement new_frame = p.contract_doc_iframe();
    d.switchTo().frame(new_frame);
    Thread.sleep(1000);

    String calc_log =
            "<b>🧮 First Month Payable Calculation</b><br>"
          + "<b>Approved Amount:</b> " + String.format("%.2f", (double) approvedAmount) + "<br>"
          + "<b>Funded Amount:</b> " + String.format("%.2f", fundedAmount) + "<br>"
          + "<b>Rate of Return (%):</b> " + String.format("%.2f", (double) rateOfReturn) + "<br>"
          + "<b>Monthly Interest:</b> " + String.format("%.2f", monthlyInterestAmount) + "<br>"
          + "<b>Doc Prep Fee:</b> " + String.format("%.2f", (double) documentPrepFee) + "<br>"
          + "<b>Fund Transfer Fee:</b> " + String.format("%.2f", (double) fundTransferFee) + "<br>"
          + "<b>✅ First Month Payable:</b> <b>" + String.format("%.2f", monthlyPayableAmount) + "</b>";

    Report_Listen.log_print_in_report().log(Status.INFO, calc_log);

    rp.Scroll_to_element(p.Contract_lien_table());

    for (WebElement cell : p.Cell_datas()) {
        String cell_text = cell.getText().trim();
        if (!cell_text.contains("/")) {
            double cell_value = Double.parseDouble(cell_text.replace(",", "").replace("$", "").trim());
            double cell_value_2d = Double.parseDouble(String.format("%.2f", cell_value));

            if (Math.abs(monthlyPayableAmount_2d - cell_value) < 0.01) {
                Report_Listen.log_print_in_report().log(Status.PASS,
                        "<b>✅ PASS:</b> First month payable matched.<br>"
                      + "<b>Expected:</b> " + monthlyPayableAmount_2d + "<br>"
                      + "<b>Actual:</b> " + cell_value_2d);
            }

            monthly_emi.add(cell_value_2d);
        }
    }

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Validate future months lien calculation from Contract Lien table.<br>"
          + "<b>✅ Expected:</b> For every month >= 1, (Current - Previous) should equal Monthly Interest = "
          + String.format("%.2f", monthlyInterestAmount_2d)
    );
    future_months_calculations_check(monthly_emi, monthlyInterestAmount);

    // ==========================================================
    // Step 18: Save contract + toast
    // ==========================================================
    d.switchTo().defaultContent();
    Thread.sleep(800);

    Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++) + ":</b> Click Save Changes and capture toast.");
    p.Save_changes_button().click();

    try {
        String contract_saved_ = lg.toast().getText().trim();
        Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Contract saved toast:</b> " + contract_saved_);
        try { lg.Toast_close_button().click(); } catch (Exception ignore) {}
    } catch (Exception e) {
        Report_Listen.log_print_in_report().log(Status.FAIL,
                "<b>❌ Save toast not captured</b> (toast not visible / locator issue).");
        throw e;
    }

    // ==========================================================
    // Step 19: Manual Sign-in + lien generation
    // ==========================================================
    new FluentWait<WebDriver>(d)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    WebElement Sign_in_button_;
    try {
        WebElement Cancel_Contract = p.Cancel_Contract_Button();
        Thread.sleep(1000);
        rp.wait_for_invisibility(Cancel_Contract);

        Sign_in_button_ = p.Manual_sign_in_button();
        rp.movetoelement(Sign_in_button_);
        rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
        Sign_in_button_.click();
        manual_lien_generation(Sign_in_button_);
    } catch (Exception ignore) {
        Thread.sleep(800);
        Sign_in_button_ = p.Manual_sign_in_button();
        rp.movetoelement(Sign_in_button_);
        rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
        Sign_in_button_.click();
        manual_lien_generation(Sign_in_button_);
    }

    // ==========================================================
    // Step 20: Payoff before → revise → payoff after
    // ==========================================================
    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Capture payoff values BEFORE revise contract.<br>"
          + "<b>📥 Input:</b> Case ID = <b>" + Case_ID + "</b>"
    );
    Pay_off_lien_list_Before_payment(Case_ID);

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Revise Contract (Buyout reduced + validations).<br>"
          + "<b>📥 Input:</b> Buyout Funder=" + buyoutFunderName + " | Expiry=" + buyoutExpiryDate
    );

    // ✅ You must have this overload:
    // Revise_Contract(Map<String,String> data)
    Revise_Contract(data);

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>Step " + (step++) + ":</b> Capture payoff values AFTER revise contract.<br>"
          + "<b>📥 Input:</b> Case ID = <b>" + Case_ID + "</b>"
    );

    // ✅ You must have these overloads:
    // Pay_off_lien_list_After_Revise_contract(Map<String,String> data, String caseId)
    // Payment_Calculator(Map<String,String> data, String caseId)
    Pay_off_lien_list_After_Revise_contract(data, Case_ID);
    Payment_Calculator(data, Case_ID);

    Report_Listen.log_print_in_report().log(Status.PASS,
            "<b>✅ Scenario Completed:</b> Payoff before/after revise captured and revise contract validations executed.<br>"
          + "<b>Case ID:</b> " + Case_ID);

    System.out.println("✅ Scenario Completed for Case ID: " + Case_ID + "\n");
}

   public void Revise_Contract(Map<String, String> data) throws InterruptedException, IOException {

	    TreeMap<String, String> Case_Data = new TreeMap<>();

	    // Map keys are your Cucumber-prefixed keys
	    Case_Data.put("Buyout Amount", data.get("Case.Buyout Amount"));
	    Case_Data.put("Buyout Funder Name", data.get("Case.Buyout Funder Name"));
	    Case_Data.put("Buyout Expiry Date", data.get("Case.Buyout Expiry Date"));

	    // Reuse your already-tested TestNG logic
	    super.Revise_Contract(Case_Data);
	}
  
   
   public void Message_Template_Creator(Map<String,String> data) throws Exception {
	    TreeMap<String,String> tm = new TreeMap<>();
	    tm.put("Title", data.get("Case.SMS Message Title"));          // or Email.Subject if you prefer
	    tm.put("Message body", data.get("Case.SMS Message Body"));    // or Email.Message
	    super.Message_Template_Creator(tm);
	}
   
   public void Pay_off_lien_list_After_Revise_contract(Map<String, String> data, String id)
        throws IOException, InterruptedException {

    // Build minimal TreeMap for compatibility (even empty is ok since your logic doesn’t use it)
    TreeMap<String, String> Case_Data = new TreeMap<>();

    // Optional: only if TestNG version expects these keys (safe to include)
    Case_Data.put("Buyout Amount", data.get("Case.Buyout Amount"));
    Case_Data.put("Buyout Funder Name", data.get("Case.Buyout Funder Name"));
    Case_Data.put("Buyout Expiry Date", data.get("Case.Buyout Expiry Date"));

    super.Pay_off_lien_list_After_Revise_contract(Case_Data, id);
}


  // Overloaded version for Cucumber parameter acceptance
     public void Payment_Calculator(Map<String, String> data, String caseId) throws IOException, InterruptedException {

    	    TreeMap<String, String> t = new TreeMap<>();
    	    t.put("Payment Mode",        data.get("Case.Payment Mode"));
    	    t.put("Payment Type",        data.get("Case.Payment Type"));
    	    t.put("Payer Name",          data.get("Case.Payer Name"));
    	    t.put("Payment Date",        data.get("Case.Payment Date"));
    	    t.put("Notes / Remarks",     data.get("Case.Notes / Remarks"));
    	    t.put("Document prep fee",   data.get("Case.Document prep fee"));
    	    t.put("Fund transfer fee",   data.get("Case.Fund transfer fee"));

    	    // Call TestNG version (this will automatically call TestNG Payment_Logger)
    	    super.Payment_Calculator(t, caseId);
    	}
     
     public String Payment_Logger(Map<String, String> data, String caseId) throws IOException, InterruptedException {

    	    // Build the TreeMap shape expected by TestNG zone
    	    TreeMap<String, String> t = new TreeMap<>();
    	    t.put("Payment Mode",        data.get("Case.Payment Mode"));
    	    t.put("Payment Type",        data.get("Case.Payment Type"));
    	    t.put("Payer Name",          data.get("Case.Payer Name"));
    	    t.put("Payment Date",        data.get("Case.Payment Date"));
    	    t.put("Notes / Remarks",     data.get("Case.Notes / Remarks"));
    	    t.put("Document prep fee",   data.get("Case.Document prep fee"));
    	    t.put("Fund transfer fee",   data.get("Case.Fund transfer fee"));

    	    // Call TestNG version (in Case_Appplications)
    	    return super.Payment_Logger(t, caseId);
    	}


     public void Underwriting_Notes(Map<String, String> data) throws InterruptedException, IOException {

    	    // Build the TreeMap shape expected by TestNG
    	    TreeMap<String, String> Case_Data = new TreeMap<>();
    	    Case_Data.put("Underwriting Notes", data.get("Case.Underwriting Notes"));
    	    Case_Data.put("Underwriting Tag",   data.get("Case.Underwriting Tag"));

    	    // Call the TestNG implementation
    	    super.Underwriting_Notes(Case_Data);
    	}}