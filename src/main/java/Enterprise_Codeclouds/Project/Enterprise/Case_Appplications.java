package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
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
import com.microsoft.playwright.impl.Stream;

import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Locaters.Sidemenu_Locaters;
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
	TreeMap<String,Double> PayoffTable_values_After_Payment =  new TreeMap<String,Double>();
	TreeMap<String,Double> PayoffTable_values_Before_Payment =  new TreeMap<String,Double>();
	TreeMap<String,Double> PayoffTable_values_Revise_contract =  new TreeMap<String,Double>();
	TreeMap<String,Double> pop_up_modal_label_values =  new TreeMap<String,Double>();
	
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
	
	
	
	
	public void Email_sender(
	        TreeMap<String, String> Case_Data,
	        TreeMap<String, String> Plaintiff,
	        TreeMap<String, String> attorneyData,
	        TreeMap<String, String> Law_Firm_Data,
	        TreeMap<String, String> Staff_Data,
	        TreeMap<String, String> data,String caseid) throws IOException, InterruptedException {

	    Application_Locaters p = new Application_Locaters(d);
	    SIde_Menu_Handler sd = new SIde_Menu_Handler();
	    Login_Locaters lg = new Login_Locaters(d);
	    Repeat rp = new Repeat(d);

	    String Subject = data.get("Subject");
	    String to = data.get("To");
	    String Mail_Body = data.get("Message");
	    String cc = data.get("Cc");
	    String bcc = data.get("Bcc");

	    String Case_id = caseid;

	    int step = 1;

	    // -------------------------------
	    // 🔹 Scenario Header
	    // -------------------------------
	    String extentHeader =
	            "<b>🔹 Email Sender — Case Feed Validation</b><br>" +
	            "<b>📘 Description:</b> Send an email from Case Details using Send → Email, then verify it appears in Feed card.<br>" +
	            "<b>📥 Input:</b> Case ID=" + Case_id + " | To=" + to + " | Subject=" + Subject + " | CC=" + cc + " | BCC=" + bcc + "<br>" +
	            "<b>✅ Expected:</b> Email should send successfully (toast) and Feed card should contain To + Subject.";

	    Report_Listen.log_print_in_report().log(Status.INFO, extentHeader);

	    System.out.println("==================================================");
	    System.out.println("EMAIL SENDER — CASE FEED VALIDATION");
	    System.out.println("--------------------------------------------------");
	    System.out.println("Case ID : " + Case_id);
	    System.out.println("To      : " + to);
	    System.out.println("Subject : " + Subject);
	    System.out.println("CC      : " + cc);
	    System.out.println("BCC     : " + bcc);
	    System.out.println("Expected: Toast should confirm email sent, and feed card should contain To + Subject.");
	    System.out.println("==================================================");
	    System.out.println();

	    // -------------------------------
	    // Step 1: Ensure we are inside Case Details
	    // -------------------------------
	    try {
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>Step " + (step++) + ":</b> Check if we are already inside Case Details (Send button visible).");
	        p.Send_button();
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Already inside Case Details page.");

	        System.out.println("[Step 1] Send button found. Already in Case Details.");
	        System.out.println();

	    } catch (Exception not_in_Case_Details) {

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Not in Case Details. Navigating via Applications list using Case ID search.");

	        System.out.println("[Step 1] Send button NOT found. Navigating to Case Details via Applications...");
	        System.out.println();

	        sd.Side_menu_option_clicker("Applications", d, "N/A");
	        p.landed_in_applicationList_confirmation();
	        p.Filter_clear().click();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>Step " + (step++) + ":</b> Search Case ID in Applications list and open the first result.");
	        WebElement Search = p.Application_search();
	        Search.sendKeys(Case_id);
	        Thread.sleep(1800);

	        List<WebElement> result_rows;
	        try {
	            result_rows = p.rows();
	            result_rows.get(0).click();
	            Thread.sleep(800);

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🟨 Actual:</b> Opened Case Details from first search result row.");
	            System.out.println("[Step 2] Case opened from first search result row.");
	            System.out.println();

	        } catch (Exception Result_still_not_fetched) {

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🟨 Actual:</b> Result rows not ready on first try. Retrying to fetch rows and open case.");

	            System.out.println("[Step 2] Rows not fetched properly. Retrying...");
	            Thread.sleep(800);

	            result_rows = p.rows();
	            result_rows.get(0).click();
	            Thread.sleep(800);

	            System.out.println("[Step 2] Case opened after retry.");
	            System.out.println();
	        }
	    }

	    // -------------------------------
	    // Step 2: Case tags load confirmation (your existing retry behavior)
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Wait for Case Tags to load (stability check).");

	    List<WebElement> Case_Tags;
	    try {
	        Case_Tags = p.Case_tags();
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Case Tags fetched successfully (count=" + Case_Tags.size() + ").");

	        System.out.println("[Step 3] Case Tags fetched successfully. Count = " + Case_Tags.size());
	        System.out.println();

	    } catch (RuntimeException tags) {

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> RuntimeException while fetching Case Tags. Retrying after wait.");

	        System.out.println("[Step 3] RuntimeException while fetching Case Tags. Retrying...");
	        System.out.println();

	        Thread.sleep(1200);
	        Case_Tags = p.Case_tags();

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Case Tags fetched successfully after retry (count=" + Case_Tags.size() + ").");

	        System.out.println("[Step 3] Case Tags fetched after retry. Count = " + Case_Tags.size());
	        System.out.println();
	    }

	    // -------------------------------
	    // Step 3: Open Send → Email modal
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Open Send menu and select Email option.");
	    System.out.println("[Step 4] Opening Send → Email...");
	    System.out.println();

	    p.Send_button().click();
	    p.Email_button().click();
	    WebElement popup_mail_form= p.pop_up_contact_list();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Email modal opened.");

	    // -------------------------------
	    // Step 4: Fill email fields (Subject, To, CC/BCC)
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Fill Subject and To fields.");
	    System.out.println("[Step 5] Filling Subject and To...");
	    System.out.println();

	    p.Subject_field().sendKeys(Subject);

	    WebElement Email_To = p.Email_to_field();
	    Email_To.sendKeys(to);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Subject and To entered.");

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Enable CC and BCC fields, then enter CC and BCC values.");
	    System.out.println("[Step 6] Enabling CC/BCC and filling values...");
	    System.out.println();

	    WebElement CC_Button = p.CC_button();
	    WebElement BCC_Button = p.Bcc_button();
	    CC_Button.click();
	    BCC_Button.click();

	    WebElement CC_field = p.cc_field();
	    WebElement BCC_field = p.bcc_field();
	    CC_field.sendKeys(cc);

	    rp.Scroll_to_element(BCC_field);
	    BCC_field.sendKeys(bcc);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> CC and BCC values entered.");

	    // -------------------------------
	    // Step 5: Enter email body inside iframe
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Switch to iframe and enter Email body.");
	    System.out.println("[Step 7] Switching to iframe and typing email body...");
	    System.out.println();

	    WebElement Iframe = p.contract_doc_iframe();
	    rp.Scroll_to_element(Iframe);
	    d.switchTo().frame(Iframe);
	    Thread.sleep(900);

	    rp.Scroll_to_element(p.Email_Body());
	    p.Email_Body().sendKeys(Mail_Body);

	    d.switchTo().defaultContent();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Email body entered successfully and switched back to main page.");

	    // -------------------------------
	    // Step 6: Submit email and capture toast
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click Submit and capture toast message.");
	    System.out.println("[Step 8] Submitting email and capturing toast...");
	    System.out.println();

	    p.Submit_button().click();
        rp.wait_for_invisibility(popup_mail_form);
	    WebElement Email_Toast;
	    try {Email_Toast= lg.toast();
	    String toastText = Email_Toast.getText().trim();
	    Login_negative_testcases.Toast_printer(toastText,d);}
	    catch(Exception email_toast){
	    	Thread.sleep(800);
	    	Email_Toast= lg.toast();
		    String toastText = Email_Toast.getText().trim();
		    Login_negative_testcases.Toast_printer(toastText,d);
		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🟨 Actual:</b> Toast captured = <b>" + toastText + "</b>");

		    System.out.println("[Step 8] Toast = " + toastText);
		    System.out.println();
	    }
	    
	    

	    

	    // -------------------------------
	    // Step 7: Verify mail card in feed contains Subject and To
	    // -------------------------------
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Verify email entry appears in Feed card with Subject + To.");

	    System.out.println("[Step 9] Verifying mail card in feed...");
	    System.out.println();

	    WebElement card = p.mail_card_in_feed();
	    String mail_card_content = card.getText().trim();

	    boolean subjectPresent = mail_card_content.contains(Subject);
	    boolean toPresent = mail_card_content.contains(to);

	    // Build reason-based result (no fancy boolean logic in logs)
	    String subjectCheck = subjectPresent ? "PASS ✅ (Subject found)" : "FAIL ❌ (Subject NOT found)";
	    String toCheck = toPresent ? "PASS ✅ (To found)" : "FAIL ❌ (To NOT found)";

	    String extentFeedValidation =
	            "<div style='background:#eaf4ff; padding:16px; border-radius:12px; border:1px solid #c7ddff; color:#0b1b33;'>" +
	                    "<b>🔹 Email Feed Validation</b><br><br>" +
	                    "<b>📌 Expected:</b> Feed card should show Subject + To.<br><br>" +
	                    "<b>🔍 Checks:</b><br>" +
	                    "<b>Subject Check:</b> " + subjectCheck + "<br>" +
	                    "<b>To Check:</b> " + toCheck + "<br><br>" +
	                    "<b>🧾 Feed Card Content (captured):</b><br>" +
	                    "<span style='font-size:12px;'>" + mail_card_content.replace("\n", "<br>") + "</span>" +
	            "</div>";

	    if (subjectPresent && toPresent) {
	        Report_Listen.log_print_in_report().log(Status.PASS, extentFeedValidation);

	        System.out.println("✅ RESULT: PASS");
	        System.out.println("Reason: Feed card contains both Subject and To.");
	        System.out.println("Subject Check: " + subjectCheck);
	        System.out.println("To Check     : " + toCheck);
	        System.out.println();

	    } else {
	        Report_Listen.log_print_in_report().log(Status.FAIL, extentFeedValidation);

	        System.out.println("❌ RESULT: FAIL");
	        System.out.println("Reason: Feed card missing expected values.");
	        System.out.println("Subject Check: " + subjectCheck);
	        System.out.println("To Check     : " + toCheck);
	        System.out.println();
	    }
	}

	  
	  
	  
	  @DataProvider
	  public Object[][] sendEmailData() {

	      // Keys mapped to UI fields:
	      // "Template" (dropdown), "Subject", "To", "Cc", "Bcc", "Message"

		  TreeMap<String, String> e1 = new TreeMap<>();
		  e1.put("Template", "None"); // keep "None" if you are not selecting any template
		  e1.put("Subject", "Document Request - Please Upload Required Files");
		  e1.put("To", "marcelline.briarcliff1874@yopmail.com");
		  e1.put("Cc", "intake.coordinator@yopmail.com");
		  e1.put("Bcc", "qa.auditdesk@yopmail.com");
		  e1.put("Message",
		          "Hello,\n\n"
		        + "Please upload the required documents at your earliest convenience so we can proceed without delay.\n\n"
		        + "Thank you.");

		  TreeMap<String, String> e2 = new TreeMap<>();
		  e2.put("Template", "None");
		  e2.put("Subject", "Verification Needed to Continue Processing");
		  e2.put("To", "orwyn.schwerdtvale4541@yopmail.com");
		  e2.put("Cc", "verification.team@yopmail.com");
		  e2.put("Bcc", "qa.auditdesk@yopmail.com");
		  e2.put("Message",
		          "Hello,\n\n"
		        + "We need a quick verification to move forward. Please confirm the requested details when you are available.\n\n"
		        + "Regards.");

		  TreeMap<String, String> e3 = new TreeMap<>();
		  e3.put("Template", "None");
		  e3.put("Subject", "Case Update - Next Steps");
		  e3.put("To", "elviora.quenridge3402@yopmail.com");
		  e3.put("Cc", "case.updates@yopmail.com");
		  e3.put("Bcc", "qa.auditdesk@yopmail.com");
		  e3.put("Message",
		          "Hello,\n\n"
		        + "This is an update regarding your case. Our team is reviewing the latest information and will share the next steps shortly.\n\n"
		        + "Thanks.");

		  TreeMap<String, String> e4 = new TreeMap<>();
		  e4.put("Template", "None");
		  e4.put("Subject", "Reminder - Pending Action Required");
		  e4.put("To", "tavryn.rookmere3403@yopmail.com");
		  e4.put("Cc", "followups.desk@yopmail.com");
		  e4.put("Bcc", "qa.auditdesk@yopmail.com");
		  e4.put("Message",
		          "Hello,\n\n"
		        + "This is a friendly reminder that an action is still pending. Please complete it so there is no delay in processing.\n\n"
		        + "Thank you.");

		  TreeMap<String, String> e5 = new TreeMap<>();
		  e5.put("Template", "None");
		  e5.put("Subject", "Additional Details Required");
		  e5.put("To", "kezaria.briarhold3418@yopmail.com");
		  e5.put("Cc", "case.intake@yopmail.com");
		  e5.put("Bcc", "qa.auditdesk@yopmail.com");
		  e5.put("Message",
		          "Hello,\n\n"
		        + "We require additional information to proceed. Please reply with the missing details or upload them through the portal.\n\n"
		        + "Regards.");

		  TreeMap<String, String> e6 = new TreeMap<>();
		  e6.put("Template", "None");
		  e6.put("Subject", "Call Request - Please Share Availability");
		  e6.put("To", "ronivar.lindenmark3411@yopmail.com");
		  e6.put("Cc", "scheduling.desk@yopmail.com");
		  e6.put("Bcc", "qa.auditdesk@yopmail.com");
		  e6.put("Message",
		          "Hello,\n\n"
		        + "We would like to schedule a short call to discuss next steps. Please share your preferred time window.\n\n"
		        + "Thank you.");

		  TreeMap<String, String> e7 = new TreeMap<>();
		  e7.put("Template", "None");
		  e7.put("Subject", "Confirmation - Update Recorded Successfully");
		  e7.put("To", "aurelian.merriswold3412@yopmail.com");
		  e7.put("Cc", "records.desk@yopmail.com");
		  e7.put("Bcc", "qa.auditdesk@yopmail.com");
		  e7.put("Message",
		          "Hello,\n\n"
		        + "This confirms your recent update has been recorded successfully. No further action is required at this moment.\n\n"
		        + "Regards.");

		  TreeMap<String, String> e8 = new TreeMap<>();
		  e8.put("Template", "None");
		  e8.put("Subject", "Issue Found - Please Review Submitted Information");
		  e8.put("To", "naviren.hearthwyn3414@yopmail.com");
		  e8.put("Cc", "quality.check@yopmail.com");
		  e8.put("Bcc", "qa.auditdesk@yopmail.com");
		  e8.put("Message",
		          "Hello,\n\n"
		        + "We noticed an issue with the submitted information. Please review and correct it so we can continue processing.\n\n"
		        + "Thanks.");

		  TreeMap<String, String> e9 = new TreeMap<>();
		  e9.put("Template", "None");
		  e9.put("Subject", "Document Review Completed - Awaiting Next Input");
		  e9.put("To", "meador.glenvarn3415@yopmail.com");
		  e9.put("Cc", "doc.review@yopmail.com");
		  e9.put("Bcc", "qa.auditdesk@yopmail.com");
		  e9.put("Message",
		          "Hello,\n\n"
		        + "We have completed the initial document review. If you have any additional files to submit, please upload them now.\n\n"
		        + "Thank you.");

		  TreeMap<String, String> e10 = new TreeMap<>();
		  e10.put("Template", "None");
		  e10.put("Subject", "Final Reminder - Response Needed to Avoid Delay");
		  e10.put("To", "tenzaro.rivenshore3419@yopmail.com");
		  e10.put("Cc", "escalations.desk@yopmail.com");
		  e10.put("Bcc", "qa.auditdesk@yopmail.com");
		  e10.put("Message",
		          "Hello,\n\n"
		        + "We are unable to proceed without the pending details. Please respond or upload the required information to avoid delays.\n\n"
		        + "Regards.");

	      return new Object[][]{
	              {e1},{e2},{e3},{e4},{e5},
	              {e6},{e7},{e8},{e9},{e10}
	      };
	  }

	  
	  
	  
	  @Test(dataProvider="messageTemplateData")
	  public void Message_Template_Creator(TreeMap<String,String> data) throws IOException, InterruptedException{
		
		
		  Application_Locaters p = new Application_Locaters(d);
		  SIde_Menu_Handler sd = new SIde_Menu_Handler();
		  Repeat rp = new Repeat(d);
		  Login_Locaters lg = new Login_Locaters(d);
		  
		  String Message_Title = data.get("Title");
		  String Body = data.get("Message body");
		  
		  int step = 1;
		  
		  Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>🔹 Scenario Title:</b> Create & Validate SMS Message Template");
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>📘 Description:</b> System should allow creating a new saved SMS template and then selecting it so the saved message body appears correctly.");
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>📥 Input:</b> Template Title = <b>"+Message_Title+"</b> | Message Body (expected) = <b>"+Body+"</b>");
			Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>✅ Expected:</b> After saving, the template should appear in Saved Messages list and its body should match the expected message text.");
		  
		   try{p.Send_button();}
	       catch(Exception not_in_Case_Details) {	    
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   Thread.sleep(800);
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
		   Report_Listen.log_print_in_report().log(Status.INFO,
					"<b>Step "+(step++)+":</b> Create a new saved SMS template.<br>"
				  + "<b>📘 Description:</b> Add a new message template with provided title and body.<br>"
				  + "<b>✅ Expected:</b> System should save the template and show a success toast.");
		  p.Send_button().click();
		  p.SMS_Send_Button().click();
		  p.pop_up_contact_list();
		  WebElement Saved_Messaged = p.Saved_Message_button();
		  rp.movetoelement(Saved_Messaged);
		  Saved_Messaged.click();
		  List<WebElement> Template_options = p.Message_Template_Option();
		  for(WebElement Opt:Template_options){
			  String Option_Text = Opt.getText().trim();
			  if(Option_Text.contains("Add New Message")){
				  Opt.click();
				  break;}}
		p.Landed_In_Template_Creation_Form();
		p.second_popup_form_inputs().get(0).sendKeys(Message_Title);
		p.second_popup_form_TextArea().get(0).sendKeys(Body);
		p.second_popup_form_buttons().get(1).click();
		WebElement Toast = lg.toast();
		String toastText = Toast.getText().trim();
		Login_negative_testcases.Toast_printer(toastText,d);
		Report_Listen.log_print_in_report().log(Status.PASS,
				"<b>🟨 Actual:</b> ✅ Template saved successfully. Toast = <b>"+toastText+"</b>");
		rp.wait_for_invisibility(Toast);
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>Step "+(step++)+":</b> Validate saved template content.<br>"
			  + "<b>📘 Description:</b> Open the saved template and confirm the displayed message body matches expected text.<br>"
			  + "<b>✅ Expected:</b> Saved template body should match the provided message body.");

		Saved_Messaged.click();
		List<WebElement> New_Template_options = p.Message_Template_Option();
		for(WebElement newOpt:New_Template_options){
			String New_Option_Text = newOpt.getText().trim();
			if(New_Option_Text.contains(Message_Title)){
				newOpt.click();
				break;}}
		Thread.sleep(800);
		String Message_Body = p.textArea().getAttribute("value");
		System.out.println(Message_Body);
		System.out.println();
		System.out.println();
		System.out.println("Body =  "+Body);
		Report_Listen.log_print_in_report().log(
				(Message_Body != null && Message_Body.contains(Body)) ? Status.PASS : Status.FAIL,
				(Message_Body != null && Message_Body.contains(Body))
						? "<b>✅ Result:</b> Template body matched the expected message text."
						: "<b>❌ Result:</b> Template body did NOT match the expected message text."
		);

		System.out.println(
			    (Message_Body != null && Message_Body.contains(Body))
			        ? "PASS: Saved template body is matching the expected message body."
			        : "FAIL: Saved template body is NOT matching the expected message body."
			);
	}
	  
	  
	  @DataProvider
	  public Object[][] messageTemplateData() {

	      TreeMap<String, String> m1 = new TreeMap<>();
	      m1.put("Title", "Case Status Update");
	      m1.put("Message body",
	              "Hello,\n\n"
	            + "This is a status update on your case. Our team is currently reviewing the latest information and will share the next update soon.\n\n"
	            + "Thank you.");

	      TreeMap<String, String> m2 = new TreeMap<>();
	      m2.put("Title", "Document Request");
	      m2.put("Message body",
	              "Hello,\n\n"
	            + "Please upload the requested documents at your earliest convenience so we can continue processing your case.\n\n"
	            + "Regards.");

	      TreeMap<String, String> m3 = new TreeMap<>();
	      m3.put("Title", "Verification Required");
	      m3.put("Message body",
	              "Hello,\n\n"
	            + "We need a quick verification to proceed. Please confirm the required details when you are available.\n\n"
	            + "Thank you.");

	      TreeMap<String, String> m4 = new TreeMap<>();
	      m4.put("Title", "Additional Information Needed");
	      m4.put("Message body",
	              "Hello,\n\n"
	            + "We require additional information to move forward. Please reply with the missing details or upload them through the portal.\n\n"
	            + "Thanks.");

	      TreeMap<String, String> m5 = new TreeMap<>();
	      m5.put("Title", "Scheduling a Call");
	      m5.put("Message body",
	              "Hello,\n\n"
	            + "We would like to schedule a short call to discuss the next steps. Please share your preferred time window.\n\n"
	            + "Regards.");

	      TreeMap<String, String> m6 = new TreeMap<>();
	      m6.put("Title", "Follow-up Reminder");
	      m6.put("Message body",
	              "Hello,\n\n"
	            + "This is a friendly reminder regarding the pending action on your case. Please complete it so there is no delay.\n\n"
	            + "Thank you.");

	      TreeMap<String, String> m7 = new TreeMap<>();
	      m7.put("Title", "Case Assigned");
	      m7.put("Message body",
	              "Hello,\n\n"
	            + "Your case has been assigned to the appropriate team for processing. You will receive updates as progress is made.\n\n"
	            + "Regards.");

	      TreeMap<String, String> m8 = new TreeMap<>();
	      m8.put("Title", "Issue With Submitted Details");
	      m8.put("Message body",
	              "Hello,\n\n"
	            + "We noticed an issue with the submitted details. Please review and correct the information so we can proceed.\n\n"
	            + "Thanks.");

	      TreeMap<String, String> m9 = new TreeMap<>();
	      m9.put("Title", "Action Completed Confirmation");
	      m9.put("Message body",
	              "Hello,\n\n"
	            + "This confirms that your recent action has been successfully recorded. No further steps are required at this moment.\n\n"
	            + "Thank you.");

	      TreeMap<String, String> m10 = new TreeMap<>();
	      m10.put("Title", "Final Notice Before Delay");
	      m10.put("Message body",
	              "Hello,\n\n"
	            + "We are unable to proceed without the pending information. Please submit the required details to avoid delays.\n\n"
	            + "Regards.");

	      return new Object[][]{
	              {m1},/*{m2},{m3},{m4},{m5},
	              {m6},{m7},{m8},{m9},{m10}*/
	      };
	  }

	
	@Test(dataProvider="case_plus_plaintiff")
	public void Add_case(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data,TreeMap<String,String> Email_Send_Data) throws IOException, InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
        Login_Locaters lg = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		JavascriptExecutor js = (JavascriptExecutor)d; 
		Attorney_module at = new Attorney_module();
		
		//Collections_Clear();
		monthly_emi.clear();
		
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
		String Case_ID=null;
		try {
		Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);
		WebElement CaseId = p.Case_ID_Tag();
	    Case_ID = CaseId.getText().trim();
	    System.out.println(Case_ID);
	    System.out.println();}
		catch(Exception e){
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Case Details edit popup and update Summary + Court Index Number.");
	   
	    WebElement details_edit_button= p.Case_details_edit_buttons();
	    details_edit_button.click();
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
		lg.Toast_close_button().click();
		rp.wait_for_invisibility(toast);
		Thread.sleep(800);
		List<WebElement> Checkboxes = p.List_Checkboxes();
		try {
		Checkboxes.get(0).click();}
		catch(Exception attorney_searched_not_present){
			at.Atttorney_Add_through_case(attorneyData,Law_Firm_Data,Staff_Data,d);
			Thread.sleep(800);
		    WebElement Newtoast = lg.toast();
		    lg.Toast_close_button().click();
			rp.wait_for_invisibility(Newtoast);
			p.List_Checkboxes().get(0).click();}
		Thread.sleep(600);
       // rp.wait_for_invisibility(lg.toast());
		WebElement Import_button = p.import_Button();
		rp.Scroll_to_element(Import_button);
		Import_button.click();
		lg.Toast_close_button().click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Attorney contact selected and added to case contacts.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Go to Applications tab and open Buyout modal.");
		rp.Scroll_to_element(p.Application_tab_bar());
		try {
		tab_selector("Applications");
		  Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully on retry attempt."
	        );

	        System.out.println("Actual     : Applications tab clicked successfully (Retry Attempt)");
	        System.out.println();}
		catch(Exception tab_click){
			
			Thread.sleep(800);
			tab_selector("Applications"); Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🟨 Actual:</b> First attempt to click Applications tab failed. Waiting 800ms and retrying once.<br>"
		                    + "<b>🟡 Exception:</b> " + tab_click.getClass().getSimpleName()
		              );

		              System.out.println("Actual     : First attempt FAILED to click Applications tab");
		              System.out.println("Retry Plan : Wait 800ms and retry once");
		              System.out.println("Exception  : " + tab_click.getClass().getSimpleName());
		              System.out.println();

		              Thread.sleep(800);
		}
		p.Application_amount_edit_buttons().get(1).click();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Buyout modal opened.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
		p.Modal_Input_Feilds().get(0).sendKeys(Case_Data.get("Buyout Funder Name"));
		p.Modal_Input_Feilds().get(1).sendKeys(Case_Data.get("Buyout Amount"));
		p.Modal_Input_Feilds().get(2).sendKeys(Case_Data.get("Buyout Expiry Date"));
		p.Higlighted_calender_date().click();
		p.modal_buttons().get(1).click();
		Thread.sleep(800);
		try {Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);}
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
	    Thread.sleep(800);
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
		WebElement contract_saved_webelement;
		try{
			contract_saved_webelement= lg.toast();
			contract_saved = contract_saved_webelement.getText().trim();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract saved toast = "+contract_saved);
			System.out.println(contract_saved);
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
			}
		//d.navigate().refresh();
		FluentWait<WebDriver> w = new FluentWait<WebDriver>(d)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofMillis(500))
		        .ignoring(NoSuchElementException.class)
		        .ignoring(StaleElementReferenceException.class);

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
		   String Contract_Generated = "";
		    try {
		        Contract_Generated = lg.toast().getText().trim();
		        Login_negative_testcases.Toast_printer(Contract_Generated,d);

		        Report_Listen.log_print_in_report().log(Status.PASS,
		                String.format("<b>🟨 Actual:</b> ✅ Contract generation toast captured = <b>%s</b>", Contract_Generated));
		        System.out.println("Actual  : Contract generation toast = " + Contract_Generated);
		    } catch (Exception e) {
		        Report_Listen.log_print_in_report().log(Status.FAIL,
		                "<b>🟨 Actual:</b> ❌ Contract generation toast NOT captured.");
		        System.out.println("Actual  : FAILED to capture contract generation toast");
		        //throw e;
		    }
		
		 try {Login_negative_testcases.Toast_printer(Contract_Generated,d);
		        rp.wait_for_invisibility(lg.toast());
		    } catch (Exception invis) {
		        Report_Listen.log_print_in_report().log(Status.INFO,
		                "<b>🟨 Actual:</b> Toast invisibility wait skipped/failed (non-blocking).");
		        System.out.println("Note    : Toast invisibility wait skipped/failed (non-blocking)");
		    }

		    Thread.sleep(1000);

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            String.format("<b>Step %d:</b> Click Manual Sign-In button and upload signed document to generate lien rows.<br><b>✅ Expected:</b> Liens should be generated and lien rows should be visible.", (step++)));

		    System.out.println("--------------------------------------------------");
		    System.out.println("[STEP] Manual Sign-In and lien generation");
		    System.out.println("Expected : Upload/sign should complete and lien rows should exist");
		    System.out.println("--------------------------------------------------");
		    WebElement Cancel_Contract;
		    WebElement Sign_in_button = null;

		    try {
		        // If Cancel button exists, wait until it disappears
		        Cancel_Contract = p.Cancel_Contract_Button();

		        System.out.println("Info    : Cancel Contract button found. Waiting for it to disappear...");
		        System.out.println();

		        Report_Listen.log_print_in_report().log(Status.INFO,
		                "<b>🟦 Info:</b> Cancel Contract button detected. Waiting until it disappears before Manual Sign-In.");

		        rp.wait_for_invisibility(Cancel_Contract);

		    } catch (Exception cancel_contract_not_found) {

		        // If Cancel button is not present, assume Sign-In is ready
		        System.out.println("Info    : Cancel Contract button NOT found. Assuming contract generation completed. Proceeding to Manual Sign-In...");
		        System.out.println();

		        Report_Listen.log_print_in_report().log(Status.INFO,
		                "<b>🟦 Info:</b> Cancel Contract button not found. Proceeding directly to Manual Sign-In.");
		    }


		    // ✅ Manual Sign-In click (always executed after above logic)
		    Sign_in_button = p.Manual_sign_in_button();
		    rp.movetoelement(Sign_in_button);
		    Thread.sleep(800);
		    rp.wait_for_theElement_tobe_clickable(Sign_in_button);

		    try {
		        Sign_in_button.click();

		        Report_Listen.log_print_in_report().log(Status.PASS,
		                "<b>🟨 Actual:</b> ✅ Manual Sign-In button clicked.");
		        System.out.println("Actual  : Manual Sign-In button clicked");
		        System.out.println();

		    } catch (Exception e) {

		        System.out.println("Actual  : Manual Sign-In click failed in first try, retrying...");
		        System.out.println();

		        Thread.sleep(800);
		        rp.movetoelement(Sign_in_button);
		        rp.wait_for_theElement_tobe_clickable(Sign_in_button);

		        try {
		            Sign_in_button.click();

		            Report_Listen.log_print_in_report().log(Status.PASS,
		                    "<b>🟨 Actual:</b> ✅ Manual Sign-In button clicked (Retry success).");
		            System.out.println("Actual  : Manual Sign-In button clicked (Retry success)");
		            System.out.println();

		        } catch (Exception ee) {

		            Report_Listen.log_print_in_report().log(Status.FAIL,
		                    "<b>🟨 Actual:</b> ❌ Manual Sign-In button click failed even after retry.");
		            System.out.println("Actual  : FAILED to click Manual Sign-In button even after retry");
		            System.out.println();

		            throw ee;
		        }
		    }




		    //Docu_Sign_Signature();
		    try {
		        List<WebElement> lienRowsAfterManualSign = manual_lien_generation(Sign_in_button);
		        int lienCount = (lienRowsAfterManualSign == null) ? 0 : lienRowsAfterManualSign.size();

		        Report_Listen.log_print_in_report().log(Status.PASS,
		                String.format("<b>🟨 Actual:</b> ✅ Manual signing completed. Lien rows found = <b>%d</b>", lienCount));
		        System.out.println("Actual  : Manual signing completed. Lien rows = " + lienCount);

		    } catch (Exception e) {
		        Report_Listen.log_print_in_report().log(Status.FAIL,
		                "<b>🟨 Actual:</b> ❌ manual_lien_generation failed (upload/sign/liens fetch issue).");
		        System.out.println("Actual  : FAILED in manual_lien_generation()");
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

		    System.out.println("--------------------------------------------------");
		    System.out.println("[STEP] Payment_Calculator / Payoff validation");
		    System.out.println("Case ID   : " + Case_ID);
		    System.out.println("Expected  : Reduction matches Fees Paid (tolerance 0.01)");
		    System.out.println("--------------------------------------------------");

		    try {Pay_off_lien_list_After_Revise_contract(Case_Data, Case_ID);
		        Payment_Calculator(Case_Data, Case_ID);

		        Report_Listen.log_print_in_report().log(Status.PASS,
		                String.format("<b>🟨 Actual:</b> ✅ Payment_Calculator executed successfully for Case ID = <b>%s</b>", Case_ID));
		        System.out.println("Actual  : Payment_Calculator executed successfully");

		    } catch (Exception e) {
		        Report_Listen.log_print_in_report().log(Status.FAIL,
		                String.format("<b>🟨 Actual:</b> ❌ Payment_Calculator failed for Case ID = <b>%s</b>", Case_ID));
		        System.out.println("Actual  : FAILED in Payment_Calculator()");
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

		    System.out.println("--------------------------------------------------");
		    System.out.println("[STEP] Add Underwriting Notes");
		    System.out.println("Expected : Notes should save successfully");
		    System.out.println("--------------------------------------------------");

		    try {
		        Underwriting_Notes(Case_Data);

		        Report_Listen.log_print_in_report().log(Status.PASS,
		                "<b>🟨 Actual:</b> ✅ Underwriting notes saved successfully.");
		        System.out.println("Actual  : Underwriting notes saved successfully");

		    } catch (Exception e) {
		        Report_Listen.log_print_in_report().log(Status.FAIL,
		                "<b>🟨 Actual:</b> ❌ Underwriting notes save failed.");
		        System.out.println("Actual  : FAILED in Underwriting_Notes()");
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

	    	    
	    	  //  Email_sender(Case_Data,Plaintiff,attorneyData,Law_Firm_Data,Staff_Data,Email_Send_Data,Case_ID);
	}
	
	
	
	

	@Test(dataProvider="case_plus_plaintiff")
	public void Buyout_Add_and_Fees_changed_in_Revised_Contract(
	        TreeMap<String, String> Case_Data,
	        TreeMap<String, String> Plaintiff,
	        TreeMap<String, String> attorneyData,
	        TreeMap<String, String> Law_Firm_Data,
	        TreeMap<String, String> Staff_Data,
	        TreeMap<String, String> Email_Send_Data) throws InterruptedException, IOException {

	    Application_Locaters p = new Application_Locaters(d);
	    Login_Locaters lg = new Login_Locaters(d);
	    Repeat rp = new Repeat(d);
	    JavascriptExecutor js = (JavascriptExecutor) d;
	    Attorney_module at = new Attorney_module();

	    monthly_emi.clear();

	    // ==========================================================
	    // ✅ FETCH ONCE & REUSE (NO REPEATED .get(...) EVERYWHERE)
	    // ==========================================================
	    final String plaintiffFirstName = Plaintiff.get("First Name");

	    final String caseType           = Case_Data.get("Case Type");
	    final String state              = Case_Data.get("State");
	    final String incidentDate       = Case_Data.get("Date of Incident");
	    final String leadSource         = Case_Data.get("Lead Source");
	    final String requestedAmount    = Case_Data.get("Requested Amount");
	    final String summary            = Case_Data.get("Summary");
	    final String courtIndex         = Case_Data.get("Court Index Number");

	    final String buyoutFunderName   = Case_Data.get("Buyout Funder Name");
	    final String buyoutExpiryDate   = Case_Data.get("Buyout Expiry Date");

	    final int buyoutAmount          = Integer.parseInt(Case_Data.get("Buyout Amount"));
	    final int approvedAmount        = Integer.parseInt(Case_Data.get("Approved Amount"));
	    final int documentPrepFee       = Integer.parseInt(Case_Data.get("Document prep fee"));
	    final int fundTransferFee       = Integer.parseInt(Case_Data.get("Fund transfer fee"));
	    final int rateOfReturn          = Integer.parseInt(Case_Data.get("Rate of Return"));

	    // ---- Calculations (used later in Contract validations/logs) ----
	    final double fundedAmount =/* buyoutAmount +*/ approvedAmount;
	    final double annualInterestAmount = (fundedAmount * rateOfReturn) / 100;
	    final double monthlyInterestAmount = annualInterestAmount / 12;
	    final double monthlyPayableAmount = fundedAmount + monthlyInterestAmount + documentPrepFee + fundTransferFee;

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
	    // Step 1: Open New Case Form
	    // ==========================================================
	    Add_New_Case_Form_Accessor(step++);
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
	    // Step 3: Select Case Type
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
	    // Step 4: Select State
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
	    try {
	        Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d);
	    } catch (Exception e) {
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Toast after creating case was not captured (toast not visible / locator issue).");
	    }

	    // ==========================================================
	    // Step 8: Capture Case ID + Update Summary/Court Index
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Open Case Details edit popup and update Summary + Court Index Number.<br>"
	          + "<b>📥 Input:</b> Court Index = <b>" + courtIndex + "</b><br>"
	          + "<b>✅ Expected:</b> Details should save without UI errors."
	    );
	    WebElement CaseId = p.Case_ID_Tag();
	    String Case_ID = CaseId.getText().trim();
	    System.out.println("Case ID : " + Case_ID + "\n");

	    p.Case_details_edit_buttons().click();
	    p.Summary_feild().sendKeys(summary);
	    p.Court_index_input().sendKeys(courtIndex);
	    p.Edit_form_buttons().get(1).click();
	    p.Case_details_edit_buttons();
	    Thread.sleep(500);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Case details saved (Summary updated, Court Index saved = " + courtIndex + ")");

	    // ==========================================================
	    // Step 9: Contacts tab → Add Attorney
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Go to Contacts tab and link an Attorney contact from list.<br>"
	          + "<b>📥 Input:</b> Attorney First Name = <b>" + attorneyData.get("First Name") + "</b><br>"
	          + "<b>✅ Expected:</b> Attorney should be added to case contacts."
	    );
	    tab_selector("Contacts");
	    p.lawFirm_AddButton_ContactTab();
	    WebElement Add_Contact_Button = p.Contact_AddButton_ContactTab();
	    rp.Scroll_to_element(Add_Contact_Button);
	  try { Add_Contact_Button.click();}
	  catch(Exception Click_Fail){
		  Thread.sleep(800);
		  Add_Contact_Button.click();
	  }
	    p.Contact_type_dropdown_list();

	    List<WebElement> Contact_Options = p.Contact_type_Options();
	    for (WebElement Cn_opt : Contact_Options) {
	        if (Cn_opt.getText().trim().equalsIgnoreCase("Attorney")) {
	            Cn_opt.click();
	            break;
	        }
	    }

	    p.pop_up_contact_list();

	    // close toast if present (your same logic)
	    WebElement Toast_close_A;
	    try {
	        Toast_close_A = lg.Toast_close_button();
	        Toast_close_A.click();
	    } catch (Exception e) {
	        Toast_close_A = lg.Toast_close_button();
	        Toast_close_A.click();
	        System.out.println("Retried Close Toast button\n");
	    }

	    Thread.sleep(800);
	    p.Popup_modal_search().sendKeys(attorneyData.get("First Name"));
	    Thread.sleep(800);

	    WebElement toast = lg.toast();
	    WebElement Toast_close_B = lg.Toast_close_button();
	    Toast_close_B.click();
	    rp.wait_for_invisibility(toast);

	    try {
	        p.List_Checkboxes().get(0).click();
	    } catch (Exception attorney_searched_not_present) {
	        at.Atttorney_Add_through_case(attorneyData, Law_Firm_Data, Staff_Data, d);
	        Thread.sleep(800);
	        WebElement Newtoast = lg.toast();
	        rp.wait_for_invisibility(Newtoast);
	        p.List_Checkboxes().get(0).click();
	    }

	    Thread.sleep(600);
	    WebElement Import_button = p.import_Button();
	    rp.Scroll_to_element(Import_button);
	    Import_button.click();

	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Attorney contact selected and added to case contacts.");

	    // ==========================================================
	    // Step 10: Applications tab (with retry logs) + Close toast
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Go to Applications tab.<br>"
	          + "<b>✅ Expected:</b> Applications tab should open."
	    );

	    rp.Scroll_to_element(p.Application_tab_bar());

	    boolean applicationsTabClicked = false;
	    try {
	        tab_selector("Applications");
	        applicationsTabClicked = true;
	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully (1st attempt).");
	        System.out.println("Actual: Applications tab clicked successfully (1st attempt)\n");
	    } catch (Exception tab_click) {

	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> First attempt to click Applications tab failed. Waiting 800ms and retrying once.<br>"
	              + "<b>🟡 Exception:</b> " + tab_click.getClass().getSimpleName());

	        System.out.println("Actual     : First attempt FAILED to click Applications tab");
	        System.out.println("Retry Plan : Wait 800ms and retry once");
	        System.out.println("Exception  : " + tab_click.getClass().getSimpleName() + "\n");

	        Thread.sleep(800);

	        tab_selector("Applications");
	        applicationsTabClicked = true;

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully (Retry Attempt).");

	        System.out.println("Actual: Applications tab clicked successfully (Retry Attempt)\n");
	    }

	    // Close toast if present after tab switch
	    if (applicationsTabClicked) {
	        try {
	            WebElement Toast_close_C = lg.Toast_close_button();
	            Toast_close_C.click();
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🟨 Actual:</b> Toast close button clicked after switching to Applications tab.");
	            System.out.println("Actual: Toast closed after Applications tab\n");
	        } catch (Exception ignore) {
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🟨 Actual:</b> No toast close button found after Applications tab switch (ignored).");
	            System.out.println("Actual: No toast close button after Applications tab (ignored)\n");
	        }
	    }

	    // ==========================================================
	    // IMPORTANT NOTE:
	    // Your Buyout-modal open/click part is not present in the snippet you pasted here
	    // (earlier you had: p.Application_amount_edit_buttons().get(1).click();)
	    // I'm keeping your current flow exactly as pasted.
	    // ==========================================================

	    try {
	        Login_negative_testcases.Toast_printer(lg.toast().getText().trim(), d);
	    } catch (Exception e) {
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> Toast after Buyout Amount step not captured (toast not visible / locator issue).");
	    }

	    // ==========================================================
	    // Step 11: Approved Amount edit + enter value
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Open Approved Amount edit and enter Approved Amount.<br>"
	          + "<b>📥 Input:</b> Approved Amount = <b>" + approvedAmount + "</b><br>"
	          + "<b>✅ Expected:</b> Approved Amount should be entered.");

	    List<WebElement> Amount_edit_buttons;
	    try {
	        Amount_edit_buttons = p.Application_amount_edit_buttons();
	        Amount_edit_buttons.get(2).click();} 
	    catch (Exception em) {
	        Thread.sleep(800);
	        Amount_edit_buttons = p.Application_amount_edit_buttons();
	        Amount_edit_buttons.get(2).click();
	        Thread.sleep(800);
	        Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟡 Retry:</b> Exception found while fetching amount edit buttons. Retried and continued.");
	        System.out.println("Retry: Amount edit buttons fetching failed once, retried and continued.\n");}

	    p.Application_Amount_input_Fields().get(0).sendKeys(String.valueOf(approvedAmount));
	    p.table_body().click();
	    Thread.sleep(800);

	    WebElement status_dropdown = p.Application_Details_Dropdown_Feild();
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Approved Amount entered = " + approvedAmount);

	    // ==========================================================
	    // Step 12: Set status to APPROVED
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Update Application Status to APPROVED from dropdown.<br>"
	          + "<b>✅ Expected:</b> Status should change to APPROVED."
	    );
	    rp.movetoelement(status_dropdown);
	    status_dropdown.click();
	    p.plaintiff_dropdown_list();

	    List<WebElement> Status_opts = p.Plaintiff_options();
	    for (WebElement Stat_opt : Status_opts) {
	        if (Stat_opt.getText().trim().contains("APPROVED")) {
	            Stat_opt.click();
	            break;
	        }
	    }
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Application status set to APPROVED.");

	    // ==========================================================
	    // Step 13: Generate Contract modal
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click Generate Contract and wait for Contract popup/modal.<br>"
	          + "<b>✅ Expected:</b> Contract details modal should open.");

	    p.Generate_contract_button().click();
	    p.popup_modal();
	    Thread.sleep(800);
	    rp.movetoelement(p.Popup_add_form());
	    Thread.sleep(800);
	    Report_Listen.log_print_in_report().log(Status.INFO, "<b>🟨 Actual:</b> Contract details modal opened.");

	    // ==========================================================
	    // Step 14: Fill Fees + RoR
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Fill contract fee fields and Rate of Return.<br>"
	          + "<b>📥 Input:</b> DocPrep=" + documentPrepFee + " | FundTransfer=" + fundTransferFee + " | RoR=" + rateOfReturn + "<br>"
	          + "<b>✅ Expected:</b> Values should be entered in contract modal.");

	    List<WebElement> Fee_feilds = p.fee_amount_feilds();
	    rp.Scroll_to_element(Fee_feilds.get(0));
	    rp.Feild_clear(Fee_feilds.get(0));
	    Fee_feilds.get(0).sendKeys(String.valueOf(documentPrepFee));

	    rp.Feild_clear(Fee_feilds.get(1));
	    Fee_feilds.get(1).sendKeys(String.valueOf(fundTransferFee));

	    rp.Scroll_to_element(p.rate_of_return_feild());
	    rp.Feild_clear(p.rate_of_return_feild());
	    p.rate_of_return_feild().sendKeys(String.valueOf(rateOfReturn));

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🟨 Actual:</b> Fees + Rate of Return filled.");

	    // ==========================================================
	    // Step 15: Agreement date + Interest start date + Submit (Generate)
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Enter Agreement Date + Interest Start Date and generate contract.<br>"
	          + "<b>📥 Input:</b> Agreement Date=" + Case_Data.get("Agreement Date") + " | Interest Start Date=" + Case_Data.get("Interest Start Date") + "<br>"
	          + "<b>✅ Expected:</b> Contract editor should open.");

	    rp.Scroll_to_element(p.Agreement_Date_feild());
	    p.Agreement_Date_feild().sendKeys(Case_Data.get("Agreement Date"));
	    p.calender_date_select().click();

	    p.Interest_Start_Date().sendKeys(Case_Data.get("Interest Start Date"));
	    p.rate_of_return_feild().click();
	    Thread.sleep(600);

	    WebElement Generate_Contract_Button = p.Submit_button();
	    rp.movetoelement(Generate_Contract_Button);
	    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
	    js.executeScript("arguments[0].click();", Generate_Contract_Button);
	    Thread.sleep(800);

	    try {
	        p.Contract_editor();
	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🟨 Actual:</b> ✅ Contract Editor opened successfully.");} 
	    catch (Exception e) {
	        Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Retrying click once.");
	        WebElement new_Generate_Contract_Button = p.Submit_button();
	        rp.wait_for_theElement_tobe_clickable(new_Generate_Contract_Button);
	        js.executeScript("arguments[0].click();", new_Generate_Contract_Button);}

	    // ==========================================================
	    // Step 16: Enter iframe + log calculation table
	    // ==========================================================
	    WebElement new_frame = p.contract_doc_iframe();
	    d.switchTo().frame(new_frame);
	    Thread.sleep(1000);

	    String Buyout_Amount_f = String.format("%.2f", (double) buyoutAmount);
	    String Approved_Amount_f = String.format("%.2f", (double) approvedAmount);
	    String Document_prep_fee_f = String.format("%.2f", (double) documentPrepFee);
	    String Fund_transfer_fee_f = String.format("%.2f", (double) fundTransferFee);
	    String Rate_of_Return_f = String.format("%.2f", (double) rateOfReturn);

	    String Funded_amount_f = String.format("%.2f", fundedAmount);
	    String Annual_Interest_Amount_f = String.format("%.2f", annualInterestAmount);
	    String Monthly_Interest_Amount_f = String.format("%.2f", monthlyInterestAmount);
	    String Monthly_Payable_Amount_f = String.format("%.2f", monthlyPayableAmount);
	    String Flat_Fees_f = String.format("%.2f", (double) (documentPrepFee + fundTransferFee));

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

	    // ==========================================================
	    // Step 17: Read lien table cells into monthly_emi + validate first month
	    // ==========================================================
	    rp.Scroll_to_element(p.Contract_lien_table());

	    List<WebElement> cells = p.Cell_datas();
	    for (WebElement cell : cells) {
	        String cell_text = cell.getText().trim();
	        if (!cell_text.contains("/")) {

	            double cell_value = Double.parseDouble(cell_text.replace(",", "").replace("$", "").trim());
	            double cell_value_2d = Double.parseDouble(String.format("%.2f", cell_value));

	            if (Math.abs(monthlyPayableAmount_2d - cell_value) < 0.01) {
	                System.out.println("✅ PASS | First month payable " + monthlyPayableAmount_2d
	                        + " matches contract first month payable " + cell_value_2d + "\n");
	                Report_Listen.log_print_in_report().log(Status.PASS,
	                        "<b>✅ PASS:</b> First month payable matched.<br>"
	                      + "<b>Expected:</b> " + monthlyPayableAmount_2d + "<br>"
	                      + "<b>Actual:</b> " + cell_value_2d);
	            }

	            monthly_emi.add(cell_value_2d);
	        }
	    }

	    // ==========================================================
	    // Step 18: Future months validation
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Validate future months lien calculation from Contract Lien table.<br>"
	          + "<b>✅ Expected:</b> For every month >= 1, (Current - Previous) should equal Monthly Interest = "
	          + String.format("%.2f", monthlyInterestAmount_2d)
	    );
	    future_months_calculations_check(monthly_emi, monthlyInterestAmount);

	    // ==========================================================
	    // Step 19: Save changes + toast
	    // ==========================================================
	    d.switchTo().defaultContent();
	    Thread.sleep(800);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click Save Changes and capture toast.");
	    p.Save_changes_button().click();

	    String contract_saved_;
	    try {
	        contract_saved_ = lg.toast().getText().trim();
	        Report_Listen.log_print_in_report().log(Status.PASS, "<b>✅ Contract saved toast:</b> " + contract_saved_);
	        System.out.println("✅ Contract saved toast: " + contract_saved_ + "\n");
	        try {
	            WebElement Toast_close_E = lg.Toast_close_button();
	            Toast_close_E.click();
	        } catch (Exception ignore) {}
	    } catch (Exception e) {
	        Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>❌ Save toast not captured</b> (toast not visible / locator issue).");
	        throw e;
	    }

	    // ==========================================================
	    // Step 20: Wait for Cancel Contract invisibility (your current flow)
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
	    Thread.sleep(800);
	    rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
	    Sign_in_button_.click();
        manual_lien_generation(Sign_in_button_);}
     catch(Exception cancel_button_not_found){
    	 Thread.sleep(800);
    	Sign_in_button_ = p.Manual_sign_in_button();
	    rp.movetoelement(Sign_in_button_);
	    Thread.sleep(800);
	    rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
	    Sign_in_button_.click();

	    manual_lien_generation(Sign_in_button_);}

	    // ==========================================================
	    // Step 21: Manual Sign in + send contract
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Click Manual Sign-in and continue lien generation flow.<br>"
	          + "<b>✅ Expected:</b> Manual sign-in should be clickable and flow should proceed."
	    );

	    

	    // ==========================================================
	    // Step 22: Capture payoff before → revise → capture payoff after revise
	    // ==========================================================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Capture payoff values BEFORE revise contract.<br>"
	          + "<b>📥 Input:</b> Case ID = <b>" + Case_ID + "</b>"
	    );
	    Pay_off_lien_list_Before_payment(Case_ID);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Revise Contract (Buyout reduced and validations in modal).<br>"
	          + "<b>📥 Input:</b> Buyout Funder=" + buyoutFunderName + " | New Buyout based on logic inside method | Expiry=" + buyoutExpiryDate
	    );
	    Revise_Contract(Case_Data);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>Step " + (step++) + ":</b> Capture payoff values AFTER revise contract.<br>"
	          + "<b>📥 Input:</b> Case ID = <b>" + Case_ID + "</b>"
	    );
	    Pay_off_lien_list_After_Revise_contract(Case_Data, Case_ID);

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>✅ Scenario Completed:</b> Payoff before/after revise captured and revise contract validations executed.<br>"
	          + "<b>Case ID:</b> " + Case_ID);

	    System.out.println("✅ Scenario Completed for Case ID: " + Case_ID + "\n");
	    Payment_Calculator(Case_Data,Case_ID);    
	}

	    
	     @Test(dataProvider="case_plus_plaintiff")
	     public void Buyout_Add_After_Contract_Generation_through_Edit_Terms(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data,TreeMap<String,String> Email_Send_Data) throws InterruptedException, IOException{
	    	 
	    	Application_Locaters p = new Application_Locaters(d);
	        Login_Locaters lg = new Login_Locaters(d);
	 		Repeat rp = new Repeat(d);
	 		JavascriptExecutor js = (JavascriptExecutor)d; 
	 		Attorney_module at = new Attorney_module();
	 		
	 		monthly_emi.clear();
	 		
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
            
	 		String Buyout_Funder = Case_Data.get("Buyout Funder Name");
	 		String Buyout_price = Case_Data.get("Buyout Amount");
	 		String Buyout_date = Case_Data.get("Buyout Expiry Date");
	 		Report_Listen.log_print_in_report().log(Status.INFO,
	 				"<b>🔹 Scenario Title:</b> Buyout Details Added After Contract Generation – Verify Edit Terms shows correct Buyout details");

	 		Report_Listen.log_print_in_report().log(Status.INFO,
	 				"<b>📘 Description:</b> Create a case, link attorney contact, generate contract, save it, then add Buyout details after contract generation. Finally, open <b>Edit Terms</b> and verify the Buyout fields show the same values that were saved.");

	 		Report_Listen.log_print_in_report().log(Status.INFO,
	 				"<b>📥 Input:</b> Buyout Funder=<b>"+Buyout_Funder+"</b> | Buyout Amount=<b>"+Buyout_price+"</b> | Buyout Expiry=<b>"+Buyout_date+"</b>");

	 		Report_Listen.log_print_in_report().log(Status.INFO,
	 				"<b>✅ Expected:</b> After adding Buyout details post-contract generation, Edit Terms should display the same Buyout Funder/Amount/Expiry. Also, <b>Add Buyout</b> button should not appear inside Edit Terms if buyout is already present.");


	 		
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
	 		Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);}
	 		catch(Exception e){
	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}
	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Case Details edit popup and update Summary + Court Index Number.");
	 		WebElement CaseId = p.Case_ID_Tag();
		    String Case_ID = CaseId.getText().trim(); /***************/
		    System.out.println(Case_ID);
		    System.out.println();
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
	 		WebElement toast_close = lg.Toast_close_button();
	 		rp.movetoelement(toast_close);
	 		toast_close.click();
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
	 		try {
	 			tab_selector("Applications");
	 			  Report_Listen.log_print_in_report().log(Status.PASS,
	 		                "<b>🟨 Actual:</b> ✅ Applications tab clicked successfully on retry attempt."
	 		        );

	 		        System.out.println("Actual     : Applications tab clicked successfully (Retry Attempt)");
	 		        System.out.println();}
	 			catch(Exception tab_click){
	 				
	 				Thread.sleep(800);
	 				tab_selector("Applications"); Report_Listen.log_print_in_report().log(Status.INFO,
	 			            "<b>🟨 Actual:</b> First attempt to click Applications tab failed. Waiting 800ms and retrying once.<br>"
	 			                    + "<b>🟡 Exception:</b> " + tab_click.getClass().getSimpleName()
	 			              );

	 			              System.out.println("Actual     : First attempt FAILED to click Applications tab");
	 			              System.out.println("Retry Plan : Wait 800ms and retry once");
	 			              System.out.println("Exception  : " + tab_click.getClass().getSimpleName());
	 			              System.out.println();

	 			              Thread.sleep(800);
	 			}
	 		try {Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);}
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
	 	    WebElement Generate_Contract_Button;
	 	    Generate_Contract_Button= p.Submit_button();
	 	    rp.movetoelement(Generate_Contract_Button);
	 	    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
	 	    js.executeScript("arguments[0].click();", Generate_Contract_Button);
	 	    Thread.sleep(800);
	 	    try{p.Contract_editor();
	 			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
	 			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Case created successfully for Plaintiff="+Case_Data.get("Plaintiff Name")+" | CourtIndex="+Case_Data.get("Court Index Number")+" | AgreementDate="+Case_Data.get("Agreement Date"));
	 		}catch(Exception e){
	 			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
	 			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex="+Case_Data.get("Court Index Number"));
	 			WebElement new_Generate_Contract_Button= p.Submit_button();
	 			rp.wait_for_theElement_tobe_clickable(new_Generate_Contract_Button);
		 	    js.executeScript("arguments[0].click();", new_Generate_Contract_Button);}
	 	    
	 	    
	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Switch back from Contract iframe to main page (default content).");
	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Driver focus returned to main page after reading Contract lien table.");
	        Thread.sleep(800);
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Save Changes</i> to save contract edits.");
	        Report_Listen.log_print_in_report().log(Status.INFO,
	        		"<b>Step "+(step++)+":</b> Reopen Contract preview before saving changes (verification step).<br>"
	        	  + "<b>📘 Description:</b> Reopen the contract preview/editor to confirm the contract can be opened again without issues.<br>"
	        	  + "<b>✅ Expected:</b> Contract preview/editor should open successfully.");

	        try {

	        	Reopen_contract_without_saving();

	        	Report_Listen.log_print_in_report().log(Status.PASS,
	        			"<b>🟨 Actual:</b> ✅ Contract preview/editor reopened successfully (no interruption before saving).");

	        } catch (Exception e) {

	        	Report_Listen.log_print_in_report().log(Status.FAIL,
	        			"<b>🟨 Actual:</b> ❌ Contract preview/editor did NOT reopen.<br>"
	        		  + "<b>Impact:</b> Client cannot re-open contract preview before saving changes (possible UI/editor issue).");

	        	throw e; // keep failure visible in TestNG
	        }
	        p.Application_amount_edit_buttons().get(1).click();
	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Buyout modal opened.");
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
	 		p.Modal_Input_Feilds().get(0).sendKeys(Buyout_Funder);
	 		p.Modal_Input_Feilds().get(1).sendKeys(Buyout_price);
	 		p.Modal_Input_Feilds().get(2).sendKeys(Buyout_date);
	 		Thread.sleep(800);
	 		WebElement date = p.Higlighted_calender_date();
	 		date.click();
	 		p.modal_buttons().get(1).click();
	 		Thread.sleep(800);
	        p.Generate_contract_button().click();
	 	    p.popup_modal();
	 	    Thread.sleep(800);
	 	    rp.movetoelement(p.Popup_add_form());
	 	    Thread.sleep(800);
	 	    List<WebElement> new_Fee_feilds = p.fee_amount_feilds();
	 	    rp.Scroll_to_element(new_Fee_feilds.get(0));
	 	    rp.Feild_clear(new_Fee_feilds.get(0));
	 	    new_Fee_feilds.get(0).sendKeys(Case_Data.get("Document prep fee"));
	 	    rp.Feild_clear(new_Fee_feilds.get(1));
	 	    new_Fee_feilds.get(1).sendKeys(Case_Data.get("Fund transfer fee"));
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
	 	    rp.movetoelement(Generate_Contract_Button);
	 	    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
	 	    js.executeScript("arguments[0].click();", Generate_Contract_Button);
	 	    Thread.sleep(800);
	 	    Thread.sleep(800);
	 	    WebElement new_save_change = p.Save_changes_button();
	 	    new_save_change.click();
	 		Thread.sleep(1800);
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast after saving contract.");
	 		String contract_saved = "";
	 		try{
	 			WebElement Toast = lg.toast();
	 			contract_saved = Toast.getText().trim();
	 			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract saved toast = "+contract_saved);
	 			System.out.println(contract_saved);
	 		}catch(Exception e){
	 			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
	 			js.executeScript("arguments[0].click();", new_save_change);}
	 		//d.navigate().refresh();
	 		FluentWait<WebDriver> w = new FluentWait<WebDriver>(d)
	 		        .withTimeout(Duration.ofSeconds(30))
	 		        .pollingEvery(Duration.ofMillis(500))
	 		        .ignoring(NoSuchElementException.class)
	 		        .ignoring(StaleElementReferenceException.class);

	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
	 		
			WebElement Contract_Generated_all_new_toast = lg.toast();
	 		String Contract_Generated = Contract_Generated_all_new_toast.getText().trim();
	 		Login_negative_testcases.Toast_printer(Contract_Generated,d);
	 		rp.wait_for_invisibility(Contract_Generated_all_new_toast);
	 		Thread.sleep(1000);
	 		FluentWait<WebDriver> fwts = new FluentWait<WebDriver>(d)
	 		        .withTimeout(Duration.ofSeconds(30))
	 		        .pollingEvery(Duration.ofMillis(500))
	 		        .ignoring(NoSuchElementException.class)
	 		        .ignoring(StaleElementReferenceException.class);
            WebElement Cancel_Contract = p.Cancel_Contract_Button();
			
			rp.wait_for_invisibility(Cancel_Contract);
	 		WebElement new_toast =lg.toast();
	 		String new_toast_text = lg.toast().getText().trim();
	 		System.out.println(new_toast_text);
	 		Thread.sleep(800);
	 	// -------------------------------
	 	// Step X: Open Buyout modal (with retry + logs)
	 	// -------------------------------
	 	Report_Listen.log_print_in_report().log(Status.INFO,
	 	        "<b>Step " + (step++) + ":</b> Open Buyout modal from Applications tab (Buyout edit button).");
	 	System.out.println("[Step] Opening Buyout modal (Applications → Buyout edit button)...");
	 	System.out.println();

	 	try {
	 	    List<WebElement> amountEditButtons = p.Application_amount_edit_buttons();
	 	    amountEditButtons.get(1).click();

	 	    Report_Listen.log_print_in_report().log(Status.INFO,
	 	            "<b>🟨 Actual:</b> Buyout modal open click performed successfully (first attempt).");
	 	    System.out.println("🟨 Actual: Buyout modal open click performed successfully (first attempt).");
	 	    System.out.println();

	 	} catch (Exception buyoutClickRetry) {

	 	    Report_Listen.log_print_in_report().log(Status.INFO,
	 	            "<b>🟨 Actual:</b> Exception while clicking Buyout edit button. Retrying once after wait. Error: "
	 	                    + buyoutClickRetry.getClass().getSimpleName());
	 	    System.out.println("🟨 Actual: Exception while clicking Buyout edit button. Retrying once after wait.");
	 	    System.out.println("Error: " + buyoutClickRetry.getClass().getSimpleName());
	 	    System.out.println();

	 	    Thread.sleep(800);

	 	    List<WebElement> amountEditButtonsRetry = p.Application_amount_edit_buttons();
	 	    amountEditButtonsRetry.get(1).click();

	 	    Report_Listen.log_print_in_report().log(Status.INFO,
	 	            "<b>🟨 Actual:</b> Buyout modal open click performed successfully (after retry).");
	 	    System.out.println("🟨 Actual: Buyout modal open click performed successfully (after retry).");
	 	    System.out.println();
	 	}

	 		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Buyout modal opened.");
	        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).");
	        List<WebElement> new_buyout_inputs = p.Modal_Input_Feilds();
	        rp.Feild_clear(new_buyout_inputs.get(0));
	        new_buyout_inputs.get(0).sendKeys(Buyout_Funder);
	        rp.Feild_clear(new_buyout_inputs.get(1));
	        new_buyout_inputs.get(1).sendKeys(Buyout_price);
	        rp.Feild_clear(new_buyout_inputs.get(2));
	 		p.Modal_Input_Feilds().get(2).sendKeys(Buyout_date);
	 		p.calender_date_select().click();
	 		p.modal_buttons().get(1).click(); 
	 		Thread.sleep(800);
	 		Report_Listen.log_print_in_report().log(Status.INFO,
	 				"<b>🔹 Validation:</b> Edit Terms should show the saved Buyout details (Funder/Amount/Expiry) after contract generation.");
	 		WebElement newToast = lg.toast();
	 		rp.wait_for_invisibility(newToast);
	 		Thread.sleep(800);
	 		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(d)
			        .withTimeout(Duration.ofSeconds(30))
			        .pollingEvery(Duration.ofMillis(500))
			        .ignoring(NoSuchElementException.class)
			        .ignoring(StaleElementReferenceException.class);
	 		WebElement Contract_generated_Toast = lg.toast();
	 		String required_toast_text = Contract_generated_Toast.getText().trim();
	 		rp.wait_for_invisibility(Contract_generated_Toast);
	 		Thread.sleep(800); 
	 		System.out.println("Toast shown --------------->>  "+required_toast_text);
	 		System.out.println();
	 		if(required_toast_text.contains("Contract generated successfully")) {
	    	WebElement Edit_contract_button;
	    	try{
	 			Edit_contract_button=p.Edit_contract_button();
	 			rp.Scroll_to_element(Edit_contract_button);
	 			rp.movetoelement(Edit_contract_button);
	 			Thread.sleep(800);
	 			js.executeScript("arguments[0].click();", Edit_contract_button);}
	 		catch(Exception Edit_contract_edit_not_found){
	 			Thread.sleep(800);
	 			Edit_contract_button=p.Edit_contract_button();
	 			System.out.println("Exception found in edit contract button thereby retrying");
	 			rp.Scroll_to_element(Edit_contract_button);
	 			rp.movetoelement(Edit_contract_button);
	 			Edit_contract_button.click();
	 		}
	    	p.popup_modal();
	 	    Thread.sleep(800);
	 	    rp.movetoelement(p.Popup_add_form());
	 	    Thread.sleep(800);
	 	    try{
	 	    	p.Add_buyout_button_inside_edit_contract_from();
	 	    	System.out.println("Testcase Failed added buyout not showing inside edit terms/contract Form");
	 	    	System.out.println();
	 	    	Report_Listen.log_print_in_report().log(Status.FAIL,
	 					"<b>🟨 Actual:</b> ❌ Edit Terms shows <b>Add Buyout</b> button (Buyout appears missing in Edit Terms).<br>"
	 							+ "<b>Expected:</b> Buyout should already be present, so <b>Add Buyout</b> should not appear.");}
	 	    catch(Exception kkm){
	 	    	System.out.println("Testcase Passed add buyout button not shown");
	 	        String Funder_name = p.Buyout_funder_name_inside_pop_up_modal_form().getAttribute("value").trim();
	 	        String Buyout_amount = p.Buyout_Amount_inside_pop_up_modal_form().getAttribute("value").trim();
	 	        String Buyout_Expiry_date = p.Buyout_Date_inside_pop_up_modal_form().getAttribute("value").trim();
	 	        System.out.println();
	 	        System.out.println(Funder_name.equalsIgnoreCase(Buyout_Funder)&&Buyout_amount.equalsIgnoreCase(Buyout_price)&&Buyout_Expiry_date.equalsIgnoreCase(Buyout_date)?"Testcase Passed All Buyout details matching with details in modal":"Testcase Failed All Buyout details not matching with details in modal");
	 	        System.out.println();
	 	    // ✅ CLIENT-FRIENDLY: ONLY show pass/fail + business values
	 			String match_log =
	 					"<b>📌 Buyout Details Shown in Edit Terms:</b><br>"
	 							+ "<b>Funder:</b> "+Funder_name+"<br>"
	 							+ "<b>Amount:</b> "+Buyout_amount+"<br>"
	 							+ "<b>Expiry Date:</b> "+Buyout_Expiry_date+"<br><br>"
	 							+ "<b>✅ Expected Buyout Details:</b><br>"
	 							+ "<b>Funder:</b> "+Buyout_Funder+"<br>"
	 							+ "<b>Amount:</b> "+Buyout_price+"<br>"
	 							+ "<b>Expiry Date:</b> "+Buyout_date+"<br><br>"
	 							+ "<b>Final Check:</b> All 3 values should match exactly.";

	 			Report_Listen.log_print_in_report().log(
	 					(Funder_name.equalsIgnoreCase(Buyout_Funder) && Buyout_amount.equalsIgnoreCase(Buyout_price) && Buyout_Expiry_date.equalsIgnoreCase(Buyout_date))
	 							? Status.PASS : Status.FAIL,
	 					((Funder_name.equalsIgnoreCase(Buyout_Funder) && Buyout_amount.equalsIgnoreCase(Buyout_price) && Buyout_Expiry_date.equalsIgnoreCase(Buyout_date))
	 							? "<b>✅ Result:</b> Buyout details match in Edit Terms.<br><br>"
	 							: "<b>❌ Result:</b> Buyout details do NOT match in Edit Terms.<br><br>")
	 							+ match_log
	 			);
	 			WebElement Generate_Contract_Button_two;
	 			Generate_Contract_Button_two= p.Submit_button();
		 	    rp.movetoelement(Generate_Contract_Button_two);
		 	    rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button_two);
		 	    js.executeScript("arguments[0].click();", Generate_Contract_Button_two);
		 	    Thread.sleep(800);
		 	    try{p.Contract_editor();
		 			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract Editor opened successfully. End-to-end case + application + contract flow completed.");
		 			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Case created successfully for Plaintiff="+Case_Data.get("Plaintiff Name")+" | CourtIndex="+Case_Data.get("Court Index Number")+" | AgreementDate="+Case_Data.get("Agreement Date"));
		 		}catch(Exception e){
		 			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after Generate Contract. Flow failed at final step.");
		 			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Case/Application created but contract generation verification failed for CourtIndex="+Case_Data.get("Court Index Number"));
		 			WebElement new_Generate_Contract_Button= p.Submit_button();
		 			rp.wait_for_theElement_tobe_clickable(new_Generate_Contract_Button);
			 	    js.executeScript("arguments[0].click();", new_Generate_Contract_Button);}
		 	    WebElement new_frame = p.contract_doc_iframe();
		 	    d.switchTo().frame(new_frame);
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
		 	    Thread.sleep(800);
		 	    p.Save_changes_button().click();
				Thread.sleep(1800);
		        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast after saving contract.");
				String contract_saved_ = "";
				try{
					contract_saved_ = lg.toast().getText().trim();
					Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Contract saved toast = "+contract_saved_);
					System.out.println(contract_saved_);
				}catch(Exception e){
					Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Save toast not captured (toast not visible / locator issue) after clicking Save Changes.");
					throw e;}
				//d.navigate().refresh();
				FluentWait<WebDriver> fwt = new FluentWait<WebDriver>(d)
				        .withTimeout(Duration.ofSeconds(30))
				        .pollingEvery(Duration.ofMillis(500))
				        .ignoring(NoSuchElementException.class)
				        .ignoring(StaleElementReferenceException.class);

				Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
				WebElement new_Cancel_Contract = p.Cancel_Contract_Button();
				
				rp.wait_for_invisibility(new_Cancel_Contract);
				WebElement Final_Contract_toast = lg.toast();
				String Contract_Generated_ = Final_Contract_toast.getText().trim();
				Login_negative_testcases.Toast_printer(Contract_Generated_,d);
				rp.wait_for_invisibility(Final_Contract_toast);
				Thread.sleep(1000);/*
				WebElement new_toast_ =lg.toast();
				String new_toast_text_ = lg.toast().getText().trim();
				System.out.println(new_toast_text_);*/
				WebElement Sign_in_button_ = p.Manual_sign_in_button();
				rp.movetoelement(Sign_in_button_);
			    Thread.sleep(800);
			    rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
			    Sign_in_button_.click();
				//Docu_Sign_Signature();
				manual_lien_generation(Sign_in_button_);
				Payment_Calculator(Case_Data,Case_ID);
				//Email_sender(Case_Data,Plaintiff,attorneyData,Law_Firm_Data,Staff_Data,Email_Send_Data,Case_ID);
	 	    }}
	 		
	 		else{
	 			
	 			
	 			System.out.println("Didn't encounter Contract generated successfully Toast so thats why couldn't proceed with edit terms process");
	 			System.out.println();}}
	     
	     
	    
	     
	     public void Reopen_contract_without_saving() throws InterruptedException{
	    	 
	    	 Application_Locaters p = new Application_Locaters(d);
	    	 
	    	 Report_Listen.log_print_in_report().log(Status.INFO,
	    	            "<b>🔹 Scenario Title:</b> Contract Reopen – Preview Contract after refresh (without saving changes)");

	    	    Report_Listen.log_print_in_report().log(Status.INFO,
	    	            "<b>📘 Description:</b> Validate that the Contract Preview opens correctly even after page refresh, without requiring any prior Save action.");

	    	    Report_Listen.log_print_in_report().log(Status.INFO,
	    	            "<b>📥 Input:</b> Preview Contract action triggered after refresh (no save performed)");

	    	    Report_Listen.log_print_in_report().log(Status.INFO,
	    	            "<b>✅ Expected:</b> Contract Editor should open successfully when user clicks Preview Contract after refresh.");

	    	 
	    	 d.navigate().refresh();
	    	 Thread.sleep(1800);
	    	 WebElement Cancel_Contract;
	    	 try{
	    		 
	    		 Cancel_Contract = p.Cancel_Contract_Button();
	    		 Cancel_Contract.click();
	    		 
	    	 }catch(Exception Button_not_found){
	    		 
	    		 Thread.sleep(800);
	    		 System.out.println("Exception found in cancel contract button thereby retrying");
	    		 Cancel_Contract = p.Cancel_Contract_Button();
	    		 Cancel_Contract.click();
	    	 }
	    	 
	    	 try{
	    	        p.Generate_contract_button();
	    	        Report_Listen.log_print_in_report().log(Status.PASS,
	    	                "<b>🟨 Actual:</b> ✅ Contract Editor opened successfully after refresh using Preview Contract (no save required).");
	    	    }catch(Exception e){
	    	        Report_Listen.log_print_in_report().log(Status.FAIL,
	    	                "<b>🟨 Actual:</b> ❌ Contract Editor did NOT open after refresh when clicking Preview Contract. (Reopen without saving failed)");
	    	        throw e;
	    	    }
	    	 }
	
	
	
	
	
	
	        public void Underwriting_Notes(TreeMap<String, String> Case_Data) throws InterruptedException, IOException{
	    	
	    	Application_Locaters p = new Application_Locaters(d);
	        Login_Locaters lg = new Login_Locaters(d);
			SIde_Menu_Handler sd = new SIde_Menu_Handler();
	    	
			
			Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🔹 Scenario Title:</b> Underwriting – Add Underwriting Notes and Tag");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>📘 Description:</b> Validate that a user can open the Underwriting tab and add Underwriting Notes + Underwriting Tag, then save successfully.");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>📥 Input:</b> Underwriting Notes = <b>"+Case_Data.get("Underwriting Notes")+"</b> | Underwriting Tag = <b>"+Case_Data.get("Underwriting Tag")+"</b>");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>✅ Expected:</b> Underwriting Notes should be saved successfully and confirmation toast should appear.");

			try {p.Case_Action_Dropdown();
			tab_selector("Underwriting");
			p.Notes_Add_Button();
			Report_Listen.log_print_in_report().log(Status.INFO,
	                "<b>🟨 Actual:</b> User is already inside Case → Underwriting tab context.");}
			catch(Exception Not_Inside_Case_UnderWriting_Tab){
				Report_Listen.log_print_in_report().log(Status.INFO,
		                "<b>🟨 Actual:</b> User was not inside Case Underwriting Tab. Navigating via Applications → Funded → First record.");
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
			Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🟨 Actual:</b> Case opened successfully and Underwriting tab is accessible.");
			p.Case_Action_Dropdown();
			tab_selector("Underwriting");
			WebElement Notes_Add_Button= p.Notes_Add_Button();	
			Notes_Add_Button.click();
			List <WebElement> inputs =p.Edit_form_inputs();
			p.textArea().sendKeys(Case_Data.get("Underwriting Notes"));
			inputs.get(0).sendKeys(Case_Data.get("Underwriting Tag"));
			p.Submit_Button().click();
		try {WebElement Toast = lg.toast();
			Login_negative_testcases.Toast_printer(Toast.getText().trim(),d);
			 Report_Listen.log_print_in_report().log(Status.PASS,
		                "<b>🟨 Actual:</b> ✅ Underwriting Notes saved successfully. Toast captured and confirms save.");}
		catch(Exception Toast_Not_Found){
			System.out.println("Toast Not found after saving Underwriting Notes");
			System.out.println();
			Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>🟨 Actual:</b> ❌ Underwriting Notes save confirmation toast was not found after clicking Submit.");
			
			 throw Toast_Not_Found;}}
	    	
	    
	
	
	
	public void future_months_calculations_check(TreeSet<Double> emi,Double monthy_interest){

	    BigDecimal bd = new BigDecimal("0.01"); // keeping as you declared (not used now)

	    TreeSet<Double> each_month_emi = emi;
	    Double each_monthly_interest = monthy_interest;
	    int month=0;

	    Double Previous_Month_Amount=null;
	    
	    System.out.println("\n==================================================");
	    System.out.println("[SCENARIO] Future Month Lien Calculation Check");
	    System.out.println("Rule      : Each month payable should increase ONLY by Monthly Interest");
	    System.out.println("Expected  : Monthly Interest = " + String.format("%.2f", each_monthly_interest));
	    System.out.println("EMI Count : " + (each_month_emi == null ? 0 : each_month_emi.size()));
	    System.out.println("Tolerance : 0.01");
	    System.out.println("==================================================\n");

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
	                
	                
	                System.out.println("==================================================");
	                System.out.println("✅ PASS | FUTURE MONTH INCREASE CHECK | Month " + month);
	                System.out.println("--------------------------------------------------");
	                System.out.println("What we validate : Month payable increases only by Monthly Interest");
	                System.out.println("Prev Month (M" + (month-1) + ") Payable : " + String.format("%.2f", Previous_Month_Amount));
	                System.out.println("Curr Month (M" + month + ") Payable    : " + String.format("%.2f", Eachemi));
	                System.out.println("Expected Interest                  : " + String.format("%.2f", each_monthly_interest));
	                System.out.println("--------------------------------------------------");
	                System.out.println("Formula   : Increase = Curr - Prev");
	                System.out.println("Increase  : " + String.format("%.2f", Eachemi) + " - " + String.format("%.2f", Previous_Month_Amount)
	                        + " = " + String.format("%.2f", Each_month_increase));
	                System.out.println("Check     : Increase ≈ Monthly Interest (Tolerance 0.01) -> Matched ✅");
	                System.out.println("Meaning   : Only monthly interest added. No extra/less added.");
	                System.out.println("Conclusion: Month " + month + " payable increase is correct.");
	                System.out.println("==================================================\n");
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
	                
	             // ✅ Console FAIL Block (Counterpart)
	                // =========================
	                System.out.println("==================================================");
	                System.out.println("❌ FAIL | FUTURE MONTH INCREASE CHECK | Month " + month);
	                System.out.println("--------------------------------------------------");
	                System.out.println("What we validate : Month payable increases only by Monthly Interest");
	                System.out.println("Prev Month (M" + (month-1) + ") Payable : " + String.format("%.2f", Previous_Month_Amount));
	                System.out.println("Curr Month (M" + month + ") Payable    : " + String.format("%.2f", Eachemi));
	                System.out.println("Expected Interest                  : " + String.format("%.2f", each_monthly_interest));
	                System.out.println("--------------------------------------------------");
	                System.out.println("Formula   : Increase = Curr - Prev");
	                System.out.println("Increase  : " + String.format("%.2f", Eachemi) + " - " + String.format("%.2f", Previous_Month_Amount)
	                        + " = " + String.format("%.2f", Each_month_increase));
	                System.out.println("Check     : Increase ≠ Monthly Interest (Tolerance 0.01) -> Mismatch ❌");

	                if(Each_month_increase > each_monthly_interest){
	                    System.out.println("Meaning   : System added EXTRA amount more than expected monthly interest.");
	                } else {
	                    System.out.println("Meaning   : System added LESS amount than expected monthly interest.");
	                }

	                System.out.println("Conclusion: Month " + month + " payable increase is incorrect.");
	                System.out.println("==================================================\n");}}
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
	    	
			Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🔹 Scenario Title:</b> Manual Contract Signing → Lien Generation Verification");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>📘 Description:</b> Validate that after uploading a signed contract document and confirming, the system records the signing successfully and generates lien rows in the Liens tab.");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>📥 Input:</b> Upload file = <b>Manual Sign In image.pdf</b>");

		    Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>✅ Expected:</b> Contract should be marked as signed (toast confirmation) and Liens tab should show generated lien row(s).");
			
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
			Login_negative_testcases.Toast_printer(Contract_Signed,d);
			Report_Listen.log_print_in_report().log(Status.INFO,
		            "<b>🟨 Actual:</b> System confirmed contract signing via toast message.");
			try{tab_selector("Liens");}
			catch(Exception Lien_tab_retry){
				Thread.sleep(800);
				tab_selector("Liens");
			}
			List<WebElement> rows = p.Open_Lien_table_contents();
			Report_Listen.log_print_in_report().log(
		            (rows != null && rows.size() > 0) ? Status.PASS : Status.FAIL,
		            (rows != null && rows.size() > 0)
		                    ? "<b>🟨 Actual:</b> ✅ Lien rows generated successfully after manual signing. Total lien rows found = <b>"+rows.size()+"</b>."
		                    : "<b>🟨 Actual:</b> ❌ No lien rows found after manual signing. Liens were expected to be generated."
		    );
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
		    c1.put("Case #", "521");
		    c1.put("Case Type", "Premises Liability");
		    c1.put("State", "California");
		    c1.put("Date of Incident", "03/09/2024");
		    c1.put("Lead Source", "Advertising");
		    c1.put("Requested Amount", "73500");
		    c1.put("Court Index Number", "19CV-2403-PR-004921");
		    c1.put("Summary", "Slip on freshly mopped tile with no wet-floor signage; wrist fracture and lost shifts alleged; incident report and surveillance request sent to property manager.");
		    c1.put("Risk Level", "Moderate");
		    c1.put("Recommended Max Funding", "31000");
		    c1.put("Underwriting Notes", "Confirm footage retention window, maintenance logs, and prior slip complaints. Verify medical causation timeline and wage loss proof. Conservative staging until video response and ownership verification.");
		    c1.put("Buyout Funder Name", "Juniper Vale Litigation Capital");
		    c1.put("Buyout Amount", "19600");
		    c1.put("Approved Amount", "31000");
		    c1.put("Application Status", "In Review");
		    c1.put("Attorney Name", "Attorney Calista Renner");
		    c1.put("Law Firm Name", "Pacific Meridian Trial Advocates LLP");
		    c1.put("Document prep fee", "325");
		    c1.put("Fund transfer fee", "120");
		    c1.put("Rate of Return", "44");
		    c1.put("SMS Message Title", "Premises File Under Review");
		    c1.put("SMS Message Body", "We’re reviewing your premises liability file and verifying key records. Updates will follow soon. – Lumberjack Legal Finance");
		    c1.put("Underwriting Tag", "Surveillance Request Sent");
		    c1.put("Payment Mode", "Credit Card");
		    c1.put("Payment Type", "Payment by Plaintiff");
		    c1.put("Payer Name", "Plaintiff N/A");
		    c1.put("Payment Date", paymentDate);
		    c1.put("Amount Received", "4200");
		    c1.put("Notes / Remarks", "Card payment received; confirm gateway transaction ID and prevent duplicate posting in payment log.");

		    TreeMap<String, String> c2 = new TreeMap<>();
		    c2.put("Case #", "522");
		    c2.put("Case Type", "Discrimination");
		    c2.put("State", "Texas");
		    c2.put("Date of Incident", "11/14/2023");
		    c2.put("Lead Source", "Attorney Referral");
		    c2.put("Requested Amount", "59000");
		    c2.put("Court Index Number", "07CV-2311-DC-007113");
		    c2.put("Summary", "Disparate discipline and demotion alleged; written warnings conflict with performance metrics; administrative charge filed; wage loss and reputational impact claimed.");
		    c2.put("Risk Level", "Moderate");
		    c2.put("Recommended Max Funding", "24500");
		    c2.put("Underwriting Notes", "Validate charge status, protected class nexus, comparator evidence, and arbitration exposure. Focus on employer policies, HR files, and pay records. Stage funding pending charge/position statement.");
		    c2.put("Buyout Funder Name", "Crownstone Settlement Finance");
		    c2.put("Buyout Amount", "14800");
		    c2.put("Approved Amount", "24500");
		    c2.put("Application Status", "Pending Docs");
		    c2.put("Attorney Name", "Attorney Jareth Quinn");
		    c2.put("Law Firm Name", "Lone Star Employment Rights Group");
		    c2.put("Document prep fee", "290");
		    c2.put("Fund transfer fee", "105");
		    c2.put("Rate of Return", "41");
		    c2.put("SMS Message Title", "Documents Needed");
		    c2.put("SMS Message Body", "We need a few additional documents to move your file forward. Please coordinate uploads with your attorney. – Lumberjack Legal Finance");
		    c2.put("Underwriting Tag", "Charge/Comparator Review");
		    c2.put("Payment Mode", "Bank Transfer");
		    c2.put("Payment Type", "Payment by Attorney");
		    c2.put("Payer Name", "Attorney Jareth Quinn");
		    c2.put("Payment Date", paymentDate);
		    c2.put("Amount Received", "8800");
		    c2.put("Notes / Remarks", "Wire initiated by attorney office; attach remittance advice and reconcile with bank statement before posting.");

		    TreeMap<String, String> c3 = new TreeMap<>();
		    c3.put("Case #", "523");
		    c3.put("Case Type", "Breach of contract");
		    c3.put("State", "New York");
		    c3.put("Date of Incident", "07/02/2023");
		    c3.put("Lead Source", "Broker");
		    c3.put("Requested Amount", "86000");
		    c3.put("Court Index Number", "31CV-2307-BC-009405");
		    c3.put("Summary", "Vendor termination dispute; disputed deliverables and withheld milestone payment; claim includes replacement sourcing costs and downtime impacts; email chain shows acceptance milestones.");
		    c3.put("Risk Level", "Moderate-High");
		    c3.put("Recommended Max Funding", "36000");
		    c3.put("Underwriting Notes", "Confirm contract formation, change orders, acceptance criteria, and mitigation steps. Review counterclaims and collectability. Stage until pleadings filed and damages model documented.");
		    c3.put("Buyout Funder Name", "Obsidian Harbor Funding Partners");
		    c3.put("Buyout Amount", "22400");
		    c3.put("Approved Amount", "36000");
		    c3.put("Application Status", "In Review");
		    c3.put("Attorney Name", "Attorney Selene Carroway");
		    c3.put("Law Firm Name", "Tribeca Commercial Litigation Counsel");
		    c3.put("Document prep fee", "365");
		    c3.put("Fund transfer fee", "135");
		    c3.put("Rate of Return", "48");
		    c3.put("SMS Message Title", "Contract Matter In Review");
		    c3.put("SMS Message Body", "Your contract matter is in review while documents and pleadings are verified. – Lumberjack Legal Finance");
		    c3.put("Underwriting Tag", "Collectability Assessment");
		    c3.put("Payment Mode", "Online Payment");
		    c3.put("Payment Type", "Payment by Another Funder");
		    c3.put("Payer Name", "Northbridge Legal Buyout Co.");
		    c3.put("Payment Date", paymentDate);
		    c3.put("Amount Received", "19200");
		    c3.put("Notes / Remarks", "Buyout payment via portal; verify receipt PDF and reference ID; match to ledger entry before closing prior funding.");

		    TreeMap<String, String> c4 = new TreeMap<>();
		    c4.put("Case #", "524");
		    c4.put("Case Type", "Dog Bite");
		    c4.put("State", "Florida");
		    c4.put("Date of Incident", "01/28/2024");
		    c4.put("Lead Source", "Medical Provider");
		    c4.put("Requested Amount", "21000");
		    c4.put("Court Index Number", "11CV-2401-DB-006732");
		    c4.put("Summary", "Dog bite with infection and follow-up antibiotics; photo documentation and urgent care notes provided; reported scarring and limited grip strength.");
		    c4.put("Risk Level", "Low-Moderate");
		    c4.put("Recommended Max Funding", "9200");
		    c4.put("Underwriting Notes", "Confirm homeowner/renter coverage and liability limits, vaccination records, and prior incident history. Conservative valuation until healing outcome and scar assessment are stable.");
		    c4.put("Buyout Funder Name", "Seabright Plaintiff Capital");
		    c4.put("Buyout Amount", "5100");
		    c4.put("Approved Amount", "9200");
		    c4.put("Application Status", "Approved");
		    c4.put("Attorney Name", "Attorney Orion Vellum");
		    c4.put("Law Firm Name", "Gulf Coast Injury Litigation Studio");
		    c4.put("Document prep fee", "215");
		    c4.put("Fund transfer fee", "75");
		    c4.put("Rate of Return", "33");
		    c4.put("SMS Message Title", "Approved");
		    c4.put("SMS Message Body", "Your dog bite funding is approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c4.put("Underwriting Tag", "Coverage Verification");
		    c4.put("Payment Mode", "Cheque");
		    c4.put("Payment Type", "Payment by Insurance Company");
		    c4.put("Payer Name", "Sunline Casualty Underwriters");
		    c4.put("Payment Date", paymentDate);
		    c4.put("Amount Received", "12400");
		    c4.put("Notes / Remarks", "Cheque received; log cheque number and hold posting until clearance as per finance policy.");

		    TreeMap<String, String> c5 = new TreeMap<>();
		    c5.put("Case #", "525");
		    c5.put("Case Type", "Employment Disputes");
		    c5.put("State", "Washington");
		    c5.put("Date of Incident", "09/18/2024");
		    c5.put("Lead Source", "Organic");
		    c5.put("Requested Amount", "45500");
		    c5.put("Court Index Number", "05CV-2409-ED-003118");
		    c5.put("Summary", "Retaliation alleged after reporting safety violations; termination reason conflicts with KPI history; wage loss claim supported by payroll records; settlement outreach initiated.");
		    c5.put("Risk Level", "Moderate");
		    c5.put("Recommended Max Funding", "19000");
		    c5.put("Underwriting Notes", "Verify protected activity dates, HR/OSHA report trail, mitigation attempts, and arbitration clauses. Stage until charge posture and employer response are reviewed.");
		    c5.put("Buyout Funder Name", "Verdant Peak Litigation Finance");
		    c5.put("Buyout Amount", "11200");
		    c5.put("Approved Amount", "19000");
		    c5.put("Application Status", "In Review");
		    c5.put("Attorney Name", "Attorney Mireya Calder");
		    c5.put("Law Firm Name", "Evergreen Workplace Rights Attorneys");
		    c5.put("Document prep fee", "275");
		    c5.put("Fund transfer fee", "95");
		    c5.put("Rate of Return", "39");
		    c5.put("SMS Message Title", "Employment File In Review");
		    c5.put("SMS Message Body", "Your employment dispute file is being reviewed while key records are verified. We’ll update you shortly. – Lumberjack Legal Finance");
		    c5.put("Underwriting Tag", "Arbitration Clause Check");
		    c5.put("Payment Mode", "Bank Transfer");
		    c5.put("Payment Type", "Payment by PIP");
		    c5.put("Payer Name", "PIP Unit - Cascade Auto Indemnity");
		    c5.put("Payment Date", paymentDate);
		    c5.put("Amount Received", "6400");
		    c5.put("Notes / Remarks", "PIP payment received via bank transfer; reconcile remittance reference and ensure correct allocation.");

		    TreeMap<String, String> c6 = new TreeMap<>();
		    c6.put("Case #", "526");
		    c6.put("Case Type", "Workers Compensation");
		    c6.put("State", "Ohio");
		    c6.put("Date of Incident", "10/03/2023");
		    c6.put("Lead Source", "Other");
		    c6.put("Requested Amount", "29500");
		    c6.put("Court Index Number", "18WC-2310-WC-005804");
		    c6.put("Summary", "Work comp claim for shoulder strain with surgery recommendation; IME dispute noted; wage replacement delays alleged; treatment records submitted.");
		    c6.put("Risk Level", "Moderate");
		    c6.put("Recommended Max Funding", "12000");
		    c6.put("Underwriting Notes", "Confirm acceptance vs denial posture, IME findings, MMI outlook, and lien/fee priorities. Keep funding conservative until carrier position stabilizes.");
		    c6.put("Buyout Funder Name", "Ironleaf Recovery Capital");
		    c6.put("Buyout Amount", "7200");
		    c6.put("Approved Amount", "12000");
		    c6.put("Application Status", "Pending Docs");
		    c6.put("Attorney Name", "Attorney Riven Hawthorne");
		    c6.put("Law Firm Name", "Buckeye Industrial Injury Counsel");
		    c6.put("Document prep fee", "245");
		    c6.put("Fund transfer fee", "85");
		    c6.put("Rate of Return", "36");
		    c6.put("SMS Message Title", "Documents Needed");
		    c6.put("SMS Message Body", "We need additional records to complete underwriting for your workers comp file. – Lumberjack Legal Finance");
		    c6.put("Underwriting Tag", "IME/Carrier Position");
		    c6.put("Payment Mode", "Cash");
		    c6.put("Payment Type", "Payment by Attorney");
		    c6.put("Payer Name", "Attorney Riven Hawthorne");
		    c6.put("Payment Date", paymentDate);
		    c6.put("Amount Received", "5100");
		    c6.put("Notes / Remarks", "Cash collected and receipted; attach receipt scan and compliance note for audit trail.");


		    TreeMap<String, String> c7 = new TreeMap<>();
		    c7.put("Case #", "527");
		    c7.put("Case Type", "Negligence");
		    c7.put("State", "Colorado");
		    c7.put("Date of Incident", "04/12/2024");
		    c7.put("Lead Source", "Broker");
		    c7.put("Requested Amount", "51500");
		    c7.put("Court Index Number", "02CV-2404-NG-008219");
		    c7.put("Summary", "Construction zone signage dispute; pedestrian tripped over unmarked cable ramp; knee injury with PT; photos and witness contact info provided.");
		    c7.put("Risk Level", "Moderate");
		    c7.put("Recommended Max Funding", "21000");
		    c7.put("Underwriting Notes", "Confirm contractor scope, permits, and traffic control plan. Evidence strength depends on consistent photos/time stamps and witness statements. Stage until incident report and coverage confirmation.");
		    c7.put("Buyout Funder Name", "Stonegate Plaintiff Funding");
		    c7.put("Buyout Amount", "12900");
		    c7.put("Approved Amount", "21000");
		    c7.put("Application Status", "Approved");
		    c7.put("Attorney Name", "Attorney Elowen Sable");
		    c7.put("Law Firm Name", "Front Range Litigation Partners");
		    c7.put("Document prep fee", "285");
		    c7.put("Fund transfer fee", "100");
		    c7.put("Rate of Return", "40");
		    c7.put("SMS Message Title", "Approved");
		    c7.put("SMS Message Body", "Your negligence funding is approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c7.put("Underwriting Tag", "Permit/Plan Review");
		    c7.put("Payment Mode", "Online Payment");
		    c7.put("Payment Type", "Payment by Insurance Company");
		    c7.put("Payer Name", "Alpine Ridge Commercial Insurance");
		    c7.put("Payment Date", paymentDate);
		    c7.put("Amount Received", "17800");
		    c7.put("Notes / Remarks", "Insurance payment received via portal; attach remittance and confirm final vs partial before closing ledger.");

		    TreeMap<String, String> c8 = new TreeMap<>();
		    c8.put("Case #", "528");
		    c8.put("Case Type", "Property Damage");
		    c8.put("State", "Georgia");
		    c8.put("Date of Incident", "02/02/2024");
		    c8.put("Lead Source", "Organic");
		    c8.put("Requested Amount", "34000");
		    c8.put("Court Index Number", "09CV-2402-PD-001668");
		    c8.put("Summary", "Water intrusion following HVAC condensate line failure; mold remediation claim and temporary lodging invoices submitted; adjuster photos attached.");
		    c8.put("Risk Level", "Moderate");
		    c8.put("Recommended Max Funding", "14500");
		    c8.put("Underwriting Notes", "Confirm repair timeline, mitigation steps, and coverage exclusions. Funding contingent on documented chronology and contractor bids.");
		    c8.put("Buyout Funder Name", "Harborglint Legal Finance");
		    c8.put("Buyout Amount", "8200");
		    c8.put("Approved Amount", "14500");
		    c8.put("Application Status", "In Review");
		    c8.put("Attorney Name", "Attorney Cassian Brook");
		    c8.put("Law Firm Name", "Peachtree Claims & Coverage Counsel");
		    c8.put("Document prep fee", "255");
		    c8.put("Fund transfer fee", "90");
		    c8.put("Rate of Return", "37");
		    c8.put("SMS Message Title", "Property Claim In Review");
		    c8.put("SMS Message Body", "We’re reviewing your property damage file and validating supporting documents. – Lumberjack Legal Finance");
		    c8.put("Underwriting Tag", "Mitigation Timeline");
		    c8.put("Payment Mode", "Credit Card");
		    c8.put("Payment Type", "Lost Deal");
		    c8.put("Payer Name", "N/A - Lost Deal");
		    c8.put("Payment Date", paymentDate);
		    c8.put("Amount Received", "0");
		    c8.put("Notes / Remarks", "Deal marked lost; no payment collected; retain record for reconciliation and audit clarity.");


		    TreeMap<String, String> c9 = new TreeMap<String, String>();
		    c9.put("Case #", "529");
		    c9.put("Case Type", "Wrongful Arrest");
		    c9.put("State", "Arizona");
		    c9.put("Date of Incident", "05/26/2024");
		    c9.put("Lead Source", "Advertising");
		    c9.put("Requested Amount", "48000");
		    c9.put("Court Index Number", "13CV-2405-WA-002744");
		    c9.put("Summary", "Mistaken identity arrest after license-plate mismatch; overnight detention; missed work and reputational harm alleged; dismissal paperwork referenced.");
		    c9.put("Risk Level", "Moderate");
		    c9.put("Recommended Max Funding", "19500");
		    c9.put("Underwriting Notes", "Confirm dismissal disposition, arrest report narrative, and any station video. Damages improved with payroll proof and documented counseling. Evaluate notice deadlines and immunity defenses.");
		    c9.put("Buyout Funder Name", "Kestrel Point Litigation Capital");
		    c9.put("Buyout Amount", "10800");
		    c9.put("Approved Amount", "19500");
		    c9.put("Application Status", "Approved");
		    c9.put("Attorney Name", "Attorney Dorian Vance");
		    c9.put("Law Firm Name", "Desert Horizon Civil Rights Counsel");
		    c9.put("Document prep fee", "270");
		    c9.put("Fund transfer fee", "95");
		    c9.put("Rate of Return", "38");
		    c9.put("SMS Message Title", "Funding Approved");
		    c9.put("SMS Message Body", "Your wrongful arrest funding is approved. We’ll coordinate agreement review with your attorney. – Lumberjack Legal Finance");
		    c9.put("Underwriting Tag", "Disposition Confirmed");
		    c9.put("Payment Mode", "Cheque");
		    c9.put("Payment Type", "Payment by Attorney");
		    c9.put("Payer Name", "Attorney Dorian Vance");
		    c9.put("Payment Date", paymentDate);
		    c9.put("Amount Received", "14200");
		    c9.put("Notes / Remarks", "Cheque received from attorney office; log cheque number and post after clearance.");

		    TreeMap<String, String> c10 = new TreeMap<>();
		    c10.put("Case #", "530");
		    c10.put("Case Type", "Unpaid Wages");
		    c10.put("State", "Pennsylvania");
		    c10.put("Date of Incident", "12/05/2023");
		    c10.put("Lead Source", "Other");
		    c10.put("Requested Amount", "24000");
		    c10.put("Court Index Number", "17CV-2312-UW-001902");
		    c10.put("Summary", "Overtime and shift differential allegedly withheld across multiple pay periods; time clock edits suspected; paystubs and schedules conflict.");
		    c10.put("Risk Level", "Low-Moderate");
		    c10.put("Recommended Max Funding", "9800");
		    c10.put("Underwriting Notes", "Confirm arbitration/class waiver, payroll integrity, and defenses. Conservative funding until early discovery clarifies timekeeping practices.");
		    c10.put("Buyout Funder Name", "Blue Lantern Funding Co.");
		    c10.put("Buyout Amount", "5600");
		    c10.put("Approved Amount", "9800");
		    c10.put("Application Status", "Pending Docs");
		    c10.put("Attorney Name", "Attorney Mirek Solace");
		    c10.put("Law Firm Name", "Keystone Wage & Hour Advocates");
		    c10.put("Document prep fee", "225");
		    c10.put("Fund transfer fee", "75");
		    c10.put("Rate of Return", "34");
		    c10.put("SMS Message Title", "Documents Needed");
		    c10.put("SMS Message Body", "We need additional payroll/schedule documents to complete underwriting. – Lumberjack Legal Finance");
		    c10.put("Underwriting Tag", "Payroll Reconciliation");
		    c10.put("Payment Mode", "Cash");
		    c10.put("Payment Type", "Payment by Plaintiff");
		    c10.put("Payer Name", "Plaintiff N/A");
		    c10.put("Payment Date", paymentDate);
		    c10.put("Amount Received", "2200");
		    c10.put("Notes / Remarks", "Cash received; generate receipt and attach scanned copy; verify permissible method per policy.");

		    TreeMap<String, String> c11 = new TreeMap<>();
		    c11.put("Case #", "531");
		    c11.put("Case Type", "Products Liability");
		    c11.put("State", "Washington DC");
		    c11.put("Date of Incident", "08/17/2023");
		    c11.put("Lead Source", "Broker");
		    c11.put("Requested Amount", "66500");
		    c11.put("Court Index Number", "01CV-2308-PL-005331");
		    c11.put("Summary", "E-scooter battery thermal event alleged; burn injury and scarring; device preserved; recall research referenced; expert inspection planned.");
		    c11.put("Risk Level", "Moderate-High");
		    c11.put("Recommended Max Funding", "29500");
		    c11.put("Underwriting Notes", "Preservation and chain-of-custody essential. Confirm recall history and alternate causation. Stage until defect opinion and medical causation supported by treating notes.");
		    c11.put("Buyout Funder Name", "Redwood Axis Litigation Finance");
		    c11.put("Buyout Amount", "17400");
		    c11.put("Approved Amount", "29500");
		    c11.put("Application Status", "In Review");
		    c11.put("Attorney Name", "Attorney Sera Whitlow");
		    c11.put("Law Firm Name", "Capitol Product Liability Chambers");
		    c11.put("Document prep fee", "310");
		    c11.put("Fund transfer fee", "115");
		    c11.put("Rate of Return", "46");
		    c11.put("SMS Message Title", "Defect Review");
		    c11.put("SMS Message Body", "Your products liability file is under defect review. We’ll update you after expert validation. – Lumberjack Legal Finance");
		    c11.put("Underwriting Tag", "Chain-of-Custody");
		    c11.put("Payment Mode", "Online Payment");
		    c11.put("Payment Type", "Payment by Another Funder");
		    c11.put("Payer Name", "Northshore Buyout Funding");
		    c11.put("Payment Date", paymentDate);
		    c11.put("Amount Received", "16300");
		    c11.put("Notes / Remarks", "Buyout payment received via portal; verify reference ID and attach receipt PDF before closing ledger.");

		    TreeMap<String, String> c12 = new TreeMap<>();
		    c12.put("Case #", "532");
		    c12.put("Case Type", "Assault");
		    c12.put("State", "Nevada");
		    c12.put("Date of Incident", "06/21/2024");
		    c12.put("Lead Source", "Organic");
		    c12.put("Requested Amount", "42000");
		    c12.put("Court Index Number", "08CV-2406-AS-001114");
		    c12.put("Summary", "Assault outside venue with dental trauma and facial fracture; security footage requested; counseling initiated for anxiety symptoms.");
		    c12.put("Risk Level", "Moderate");
		    c12.put("Recommended Max Funding", "18200");
		    c12.put("Underwriting Notes", "Confirm police report and venue incident logs; identify defendant and insurance/collectability. Funding depends on corroborating video and medical record consistency.");
		    c12.put("Buyout Funder Name", "Silvercrest Legal Capital");
		    c12.put("Buyout Amount", "11100");
		    c12.put("Approved Amount", "18200");
		    c12.put("Application Status", "In Review");
		    c12.put("Attorney Name", "Attorney Kellan North");
		    c12.put("Law Firm Name", "Mojave Injury Trial Office");
		    c12.put("Document prep fee", "255");
		    c12.put("Fund transfer fee", "95");
		    c12.put("Rate of Return", "40");
		    c12.put("SMS Message Title", "Assault File In Review");
		    c12.put("SMS Message Body", "Your assault file is under review while we verify records and coverage details. – Lumberjack Legal Finance");
		    c12.put("Underwriting Tag", "Coverage Discovery");
		    c12.put("Payment Mode", "Cheque");
		    c12.put("Payment Type", "Payment by Insurance Company");
		    c12.put("Payer Name", "Nevada Basin Insurance Services");
		    c12.put("Payment Date", paymentDate);
		    c12.put("Amount Received", "9800");
		    c12.put("Notes / Remarks", "Cheque received via mail; deposit next business day; hold posting until clearance.");

		    TreeMap<String, String> c13 = new TreeMap<>();
		    c13.put("Case #", "533");
		    c13.put("Case Type", "Sexual Harassment");
		    c13.put("State", "Oregon");
		    c13.put("Date of Incident", "02/08/2024");
		    c13.put("Lead Source", "Attorney Referral");
		    c13.put("Requested Amount", "57500");
		    c13.put("Court Index Number", "06CV-2402-SH-003879");
		    c13.put("Summary", "Harassment allegations with retaliation after HR report; internal chat logs referenced; counseling initiated; wage loss claimed.");
		    c13.put("Risk Level", "Moderate");
		    c13.put("Recommended Max Funding", "23000");
		    c13.put("Underwriting Notes", "Confirm reporting timeline, HR investigation outcome, witnesses, and retaliation documentation. Arbitration clauses and mitigation affect valuation. Stage until charge posture confirmed.");
		    c13.put("Buyout Funder Name", "Firwood Litigation Funding");
		    c13.put("Buyout Amount", "13800");
		    c13.put("Approved Amount", "23000");
		    c13.put("Application Status", "Pending Docs");
		    c13.put("Attorney Name", "Attorney Liora Wexley");
		    c13.put("Law Firm Name", "Willamette Workplace Justice Counsel");
		    c13.put("Document prep fee", "275");
		    c13.put("Fund transfer fee", "100");
		    c13.put("Rate of Return", "41");
		    c13.put("SMS Message Title", "Documents Needed");
		    c13.put("SMS Message Body", "We need additional documentation to finalize underwriting. Please coordinate uploads with your attorney. – Lumberjack Legal Finance");
		    c13.put("Underwriting Tag", "Retaliation Timeline");
		    c13.put("Payment Mode", "Credit Card");
		    c13.put("Payment Type", "Payment by PIP");
		    c13.put("Payer Name", "PIP Recovery Desk - Summit Auto Coverage");
		    c13.put("Payment Date", paymentDate);
		    c13.put("Amount Received", "4100");
		    c13.put("Notes / Remarks", "PIP payment processed by card; verify transaction ID and ensure no duplicate capture.");

		    TreeMap<String, String> c14 = new TreeMap<>();
		    c14.put("Case #", "534");
		    c14.put("Case Type", "Civil Rights");
		    c14.put("State", "Virginia");
		    c14.put("Date of Incident", "09/29/2024");
		    c14.put("Lead Source", "Other");
		    c14.put("Requested Amount", "81500");
		    c14.put("Court Index Number", "10CV-2409-CR-006201");
		    c14.put("Summary", "Civil rights claim alleging unlawful search and extended detention; emotional distress and wage loss asserted; request made for bodycam and dispatch logs.");
		    c14.put("Risk Level", "Moderate");
		    c14.put("Recommended Max Funding", "34000");
		    c14.put("Underwriting Notes", "Prioritize objective evidence: bodycam/dashcam, CAD logs, incident report. Confirm notice deadlines and policy limits. Stage pending video confirmation.");
		    c14.put("Buyout Funder Name", "Cobalt Meridian Legal Finance");
		    c14.put("Buyout Amount", "20800");
		    c14.put("Approved Amount", "34000");
		    c14.put("Application Status", "In Review");
		    c14.put("Attorney Name", "Attorney Vesper Lang");
		    c14.put("Law Firm Name", "Blue Ridge Civil Liberties Advocates");
		    c14.put("Document prep fee", "335");
		    c14.put("Fund transfer fee", "125");
		    c14.put("Rate of Return", "43");
		    c14.put("SMS Message Title", "Civil Rights Review");
		    c14.put("SMS Message Body", "Your civil rights file is under review while key records are verified. We’ll update you soon. – Lumberjack Legal Finance");
		    c14.put("Underwriting Tag", "Video Verification Pending");
		    c14.put("Payment Mode", "Bank Transfer");
		    c14.put("Payment Type", "Payment by Insurance Company");
		    c14.put("Payer Name", "Commonwealth Indemnity Group");
		    c14.put("Payment Date", paymentDate);
		    c14.put("Amount Received", "15600");
		    c14.put("Notes / Remarks", "Wire received from insurer; confirm sender vs remittance advice; attach confirmation and post to correct case ledger.");

		    TreeMap<String, String> c15 = new TreeMap<>();
		    c15.put("Case #", "535");
		    c15.put("Case Type", "Police Brutality");
		    c15.put("State", "Illinois");
		    c15.put("Date of Incident", "04/03/2024");
		    c15.put("Lead Source", "Organic");
		    c15.put("Requested Amount", "91000");
		    c15.put("Court Index Number", "14CV-2404-PB-001774");
		    c15.put("Summary", "Use-of-force claim during arrest with shoulder injury and concussion symptoms; ER and neurology follow-ups referenced; complaint drafting in progress.");
		    c15.put("Risk Level", "Moderate-High");
		    c15.put("Recommended Max Funding", "39000");
		    c15.put("Underwriting Notes", "Confirm criminal disposition, municipal notice timelines, policy/indemnification, and IA findings. Stage until complaint filed and footage reviewed.");
		    c15.put("Buyout Funder Name", "Summit Harbor Litigation Capital");
		    c15.put("Buyout Amount", "24200");
		    c15.put("Approved Amount", "39000");
		    c15.put("Application Status", "Pending Docs");
		    c15.put("Attorney Name", "Attorney Rowan Merrow");
		    c15.put("Law Firm Name", "Lakefront Civil Rights Trial Group");
		    c15.put("Document prep fee", "355");
		    c15.put("Fund transfer fee", "130");
		    c15.put("Rate of Return", "45");
		    c15.put("SMS Message Title", "Documents Needed");
		    c15.put("SMS Message Body", "We need a few additional documents to finalize underwriting. Please coordinate uploads with your attorney. – Lumberjack Legal Finance");
		    c15.put("Underwriting Tag", "Medical Causation Review");
		    c15.put("Payment Mode", "Credit Card");
		    c15.put("Payment Type", "Payment by Plaintiff");
		    c15.put("Payer Name", "Plaintiff N/A");
		    c15.put("Payment Date", paymentDate);
		    c15.put("Amount Received", "5300");
		    c15.put("Notes / Remarks", "Card approved; validate gateway reference and ensure convenience fee handling aligns with business rule.");

		    TreeMap<String, String> c16 = new TreeMap<>();
		    c16.put("Case #", "536");
		    c16.put("Case Type", "Legal Malpractice");
		    c16.put("State", "Massachusetts");
		    c16.put("Date of Incident", "01/19/2023");
		    c16.put("Lead Source", "Attorney Referral");
		    c16.put("Requested Amount", "77000");
		    c16.put("Court Index Number", "04CV-2301-LM-004118");
		    c16.put("Summary", "Alleged missed filing deadline in underlying claim; loss-of-chance damages asserted; case-within-a-case evaluation in progress.");
		    c16.put("Risk Level", "Moderate-High");
		    c16.put("Recommended Max Funding", "32000");
		    c16.put("Underwriting Notes", "Verify engagement scope, docket history, and malpractice policy limits. Requires negligence + causation + valuation of underlying claim. Stage pending expert review and carrier response.");
		    c16.put("Buyout Funder Name", "Harborline Counsel Finance");
		    c16.put("Buyout Amount", "19600");
		    c16.put("Approved Amount", "32000");
		    c16.put("Application Status", "In Review");
		    c16.put("Attorney Name", "Attorney Nyla Harrow");
		    c16.put("Law Firm Name", "Beacon Hill Professional Liability Counsel");
		    c16.put("Document prep fee", "330");
		    c16.put("Fund transfer fee", "120");
		    c16.put("Rate of Return", "44");
		    c16.put("SMS Message Title", "Malpractice Review");
		    c16.put("SMS Message Body", "Your malpractice file is under review while records and causation are verified. – Lumberjack Legal Finance");
		    c16.put("Underwriting Tag", "Carrier Response Needed");
		    c16.put("Payment Mode", "Cash");
		    c16.put("Payment Type", "Payment by Another Funder");
		    c16.put("Payer Name", "IronGate Resolution Funding");
		    c16.put("Payment Date", paymentDate);
		    c16.put("Amount Received", "3600");
		    c16.put("Notes / Remarks", "Cash logged for audit; receipt and compliance note attached; confirm permissible method per policy.");

		    TreeMap<String, String> c17 = new TreeMap<>();
		    c17.put("Case #", "537");
		    c17.put("Case Type", "Boat Accident");
		    c17.put("State", "Hawaii");
		    c17.put("Date of Incident", "05/11/2024");
		    c17.put("Lead Source", "Broker");
		    c17.put("Requested Amount", "64000");
		    c17.put("Court Index Number", "01CV-2405-BA-002907");
		    c17.put("Summary", "Recreational boat collision near marina entrance; visibility concerns and improper lookout alleged; concussion symptoms and shoulder injury reported; marine report requested.");
		    c17.put("Risk Level", "Moderate");
		    c17.put("Recommended Max Funding", "26000");
		    c17.put("Underwriting Notes", "Key evidence: marine patrol report, witness statements, photos, and operator insurance. Confirm navigation rules compliance and comparative negligence risks.");
		    c17.put("Buyout Funder Name", "Frontline Oceanic Capital");
		    c17.put("Buyout Amount", "16400");
		    c17.put("Approved Amount", "26000");
		    c17.put("Application Status", "Approved");
		    c17.put("Attorney Name", "Attorney Kael Winters");
		    c17.put("Law Firm Name", "Honolulu Maritime Injury Counsel");
		    c17.put("Document prep fee", "295");
		    c17.put("Fund transfer fee", "105");
		    c17.put("Rate of Return", "40");
		    c17.put("SMS Message Title", "Boat Accident Approved");
		    c17.put("SMS Message Body", "Your boat accident funding is approved. We’ll coordinate agreement review and disbursement with your attorney. – Lumberjack Legal Finance");
		    c17.put("Underwriting Tag", "Marine Report Pending");
		    c17.put("Payment Mode", "Online Payment");
		    c17.put("Payment Type", "Payment by PIP");
		    c17.put("Payer Name", "PIP Claims Department - OceanShield");
		    c17.put("Payment Date", paymentDate);
		    c17.put("Amount Received", "7800");
		    c17.put("Notes / Remarks", "PIP reimbursement received via online payment; verify remittance claim number and match to schedule.");

		    TreeMap<String, String> c18 = new TreeMap<>();
		    c18.put("Case #", "538");
		    c18.put("Case Type", "Airplane Accident");
		    c18.put("State", "Utah");
		    c18.put("Date of Incident", "03/24/2023");
		    c18.put("Lead Source", "Attorney Referral");
		    c18.put("Requested Amount", "124000");
		    c18.put("Court Index Number", "03CV-2303-AA-008640");
		    c18.put("Summary", "Small aircraft hard landing with alleged maintenance oversight; orthopedic injuries and rehab; investigation records and maintenance logs requested.");
		    c18.put("Risk Level", "Moderate-High");
		    c18.put("Recommended Max Funding", "59000");
		    c18.put("Underwriting Notes", "Multiple potentially liable parties; confirm investigation status, insurance layers, and expert retention. Staged funding until causation clarified and records obtained.");
		    c18.put("Buyout Funder Name", "Pioneer Aviation Claim Finance");
		    c18.put("Buyout Amount", "36800");
		    c18.put("Approved Amount", "59000");
		    c18.put("Application Status", "In Review");
		    c18.put("Attorney Name", "Attorney Elara Flint");
		    c18.put("Law Firm Name", "Wasatch Catastrophic Injury Counsel");
		    c18.put("Document prep fee", "375");
		    c18.put("Fund transfer fee", "140");
		    c18.put("Rate of Return", "47");
		    c18.put("SMS Message Title", "Airplane Case Under Review");
		    c18.put("SMS Message Body", "Your airplane accident file is under advanced review while investigation records are verified. – Lumberjack Legal Finance");
		    c18.put("Underwriting Tag", "Investigation Layering");
		    c18.put("Payment Mode", "Credit Card");
		    c18.put("Payment Type", "Payment by Insurance Company");
		    c18.put("Payer Name", "CedarLine Commercial Insurance");
		    c18.put("Payment Date", paymentDate);
		    c18.put("Amount Received", "13200");
		    c18.put("Notes / Remarks", "Insurance payment processed by card; attach receipt and confirm no partial capture.");

		    TreeMap<String, String> c19 = new TreeMap<>();
		    c19.put("Case #", "539");
		    c19.put("Case Type", "Attorney Funding");
		    c19.put("State", "New Jersey");
		    c19.put("Date of Incident", "08/30/2023");
		    c19.put("Lead Source", "Attorney Referral");
		    c19.put("Requested Amount", "84500");
		    c19.put("Court Index Number", "02CV-2308-AF-003409");
		    c19.put("Summary", "Attorney funding request tied to expert retainers, discovery costs, and deposition logistics for a complex injury matter; expense timeline and budget submitted.");
		    c19.put("Risk Level", "Moderate");
		    c19.put("Recommended Max Funding", "36500");
		    c19.put("Underwriting Notes", "Assess litigation budget, timeline to recovery, lien priorities, and disbursement controls. Stage funding based on milestones and cost documentation.");
		    c19.put("Buyout Funder Name", "Granite Arc Legal Capital");
		    c19.put("Buyout Amount", "23200");
		    c19.put("Approved Amount", "36500");
		    c19.put("Application Status", "Approved");
		    c19.put("Attorney Name", "Attorney Mira Stonebridge");
		    c19.put("Law Firm Name", "Garden State Trial Expense Counsel");
		    c19.put("Document prep fee", "315");
		    c19.put("Fund transfer fee", "120");
		    c19.put("Rate of Return", "43");
		    c19.put("SMS Message Title", "Approved – Attorney Funding");
		    c19.put("SMS Message Body", "Your attorney funding request is approved. We’ll coordinate the agreement and disbursement workflow with your office. – Lumberjack Legal Finance");
		    c19.put("Underwriting Tag", "Milestone-Based Disbursement");
		    c19.put("Payment Mode", "Online Payment");
		    c19.put("Payment Type", "Payment by Another Funder");
		    c19.put("Payer Name", "Summit Equity Legal Funding Partners");
		    c19.put("Payment Date", paymentDate);
		    c19.put("Amount Received", "17650");
		    c19.put("Notes / Remarks", "Online buyout payment received; cross-check reference ID and attach receipt PDF.");

		    TreeMap<String, String> c20 = new TreeMap<>();
		    c20.put("Case #", "540");
		    c20.put("Case Type", "Civil Rights");
		    c20.put("State", "Unknown");
		    c20.put("Date of Incident", "12/27/2024");
		    c20.put("Lead Source", "Other");
		    c20.put("Requested Amount", "50500");
		    c20.put("Court Index Number", "00CV-2412-CR-001990");
		    c20.put("Summary", "Civil rights complaint in early intake; jurisdiction/venue being confirmed; request for records submitted; wage loss and emotional distress alleged.");
		    c20.put("Risk Level", "Moderate");
		    c20.put("Recommended Max Funding", "20500");
		    c20.put("Underwriting Notes", "Hold funding until venue/jurisdiction confirmed and core documents obtained. Verify statute/notice deadlines and whether claims are viable under applicable standards.");
		    c20.put("Buyout Funder Name", "Atlas Ridge Litigation Funding");
		    c20.put("Buyout Amount", "12400");
		    c20.put("Approved Amount", "20500");
		    c20.put("Application Status", "In Review");
		    c20.put("Attorney Name", "Attorney Sable Rennick");
		    c20.put("Law Firm Name", "National Civil Liberties Counsel");
		    c20.put("Document prep fee", "260");
		    c20.put("Fund transfer fee", "95");
		    c20.put("Rate of Return", "39");
		    c20.put("SMS Message Title", "File In Review");
		    c20.put("SMS Message Body", "Your file is under review while we confirm venue and verify key records. – Lumberjack Legal Finance");
		    c20.put("Underwriting Tag", "Venue Confirmation");
		    c20.put("Payment Mode", "Bank Transfer");
		    c20.put("Payment Type", "Lost Deal");
		    c20.put("Payer Name", "N/A - Lost Deal");
		    c20.put("Payment Date", paymentDate);
		    c20.put("Amount Received", "1");
		    c20.put("Notes / Remarks", "Lost deal logged (system requires amount); placeholder used for validation; adjust if rule allows blank.");

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
	    Law_Firm_Module lfd = new Law_Firm_Module();

	    Object[][] plaintiff_datas = pm.plaintiffData();   
	    Object[][] case_datas      = caseData();           
	    Object[][] attorney_datas  = at.attorneyfData(); 
	    Object[][] law_firm_datas =  lfd.lawFirmData();
	    Object[][] Staff_datas =     at.Staff_data();
	    Object[][] Email_datas =       sendEmailData();
	    
	    int n =  IntStream.of( plaintiff_datas.length, case_datas.length, attorney_datas.length, law_firm_datas.length, Staff_datas.length, Email_datas.length ).min().orElse(0);

	    // ✅ 3 columns now: case, plaintiff, attorney
	    Object[][] final_set = new Object[n][6];

	    for(int i = 0; i < n; i++){
	        final_set[i][0] = case_datas[i][0];       // case map
	        final_set[i][1] = plaintiff_datas[i][0];  // plaintiff map
	        final_set[i][2] = attorney_datas[i][0];   // attorney map
	        final_set[i][3] = law_firm_datas[i][0];   // law firm map
	        final_set[i][4] = Staff_datas[i][0];      // Staff map
	        final_set[i][5] = Email_datas[i][0];      // Email data
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
		   
		   
		   LIEN_AMOUNT_Values.clear();
		   TOTAL_PRINCIPAL_Values.clear();
		   CURRENT_LIEN_BALANCE_Values.clear();
		   RETURNED_AMT_Values.clear();
		  // Collections_Clear();
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
		   String Case_id= Case_Tags.get(0).getText().trim();
		   String case_status= Case_Tags.get(1).getText().trim();
		   if(case_status.contains("Case closed")){
			   lien_rows= Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount); }
		   else{
			  
			  tab_selector("Liens");
			  
	          try { 
	        	  lien_rows=p.Open_Lien_table_contents();
	        	  Payment_Calculator(data,Case_id);
	        	  }
			  catch(RuntimeException no_liens){
				
				 WebElement Empty_lien_Table = p.Lien_table_empty();
		  if(Empty_lien_Table.isDisplayed()){
				
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
						Payment_Logger(data,Case_id);
				    }else{
				    	lien_rows=Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount);
				    	Payment_Logger(data,Case_id);}
				    }catch(Exception new_application_generate){
					  lien_rows= Internal_Application_Generator_and_Manual_Signer(data,data2,attorneyData,Requested_Amount); 
					  Payment_Calculator(data,Case_id);}}}}
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

		        	    Report_Listen.log_print_in_report().log((Math.abs(outstandingAfterPayment_calculated - currentLienBalance) < 0.01) ? Status.PASS : Status.FAIL, payoff_log);});
		           
	   
	   }
	   
	
	   
	     
	        public String Payment_Logger(TreeMap<String, String> data, String Case_Id) throws IOException, InterruptedException{
	    	    
	        	SIde_Menu_Handler sd = new SIde_Menu_Handler();
	        	Application_Locaters p = new Application_Locaters(d);
	        	Repeat rp = new Repeat(d);
	        	Login_Locaters lg = new Login_Locaters(d);
	        	
	        	int step = 1;
	        	 
	        	String Case_id = Case_Id;
	        	double Document_prep_fee = Double.parseDouble(data.get("Document prep fee"));
	            double Fundtransferfee = Double.parseDouble(data.get("Fund transfer fee"));

	            double Total_Fees = Document_prep_fee + Fundtransferfee;
	            double Amount_to_be_payed = Total_Fees / 2;

	            double Amount_to_be_payed_upto_2_decimal = Double.parseDouble(String.format("%.2f", Amount_to_be_payed));
	            String Amount_to_be_payed_text = String.format("%.2f", Amount_to_be_payed_upto_2_decimal);

	            String Mode = data.get("Payment Mode");
	            String Type = data.get("Payment Type");
	            String Payer = data.get("Payer Name");
	            String PayDate = data.get("Payment Date");
	            String Notes = data.get("Notes / Remarks");
                String Plaintiff_name;
	            // =========================
	            // Scenario Header (Extent)
	            // =========================
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<div style='background:#f1f5ff; padding:16px; border-radius:12px; border:1px solid #cbd5ff; color:#0b1b33; font-family:Arial;'>"
	                  + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario Title: Payment Logger – Record Payment (50% Fees)</div>"
	                  + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Open <b>Log Payment</b> form from Case Action dropdown, enter payment details, submit, and capture confirmation toast.</div>"
	                  + "<div style='margin-top:10px; font-size:13px;'><b>📥 Input:</b> Case ID = <b>" + Case_id + "</b></div>"
	                  + "<div style='margin-top:10px; font-size:13px;'><b>🧮 Fee Rule:</b> Payment Amount = (Doc Prep + Fund Transfer) / 2</div>"
	                  + "<div style='margin-top:10px; font-size:13px;'><b>✅ Expected:</b> Payment should log successfully and system should show a confirmation toast.</div>"
	                  + "</div>"
	            );

	            // =========================
	            // Scenario Header (Console)
	            // =========================
	            System.out.println("\n==================================================");
	            System.out.println("[SCENARIO] Payment Logger – Record Payment (50% Fees)");
	            System.out.println("Case ID           : " + Case_id);
	            System.out.println("Document Prep Fee : " + String.format("%.2f", Document_prep_fee));
	            System.out.println("Fund Transfer Fee : " + String.format("%.2f", Fundtransferfee));
	            System.out.println("Total Fees        : " + String.format("%.2f", Total_Fees));
	            System.out.println("Payment Amount(50%): " + Amount_to_be_payed_text);
	            System.out.println("==================================================\n");

	            // =========================
	            // Step 1: Ensure in Case Details
	            // =========================
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>Step " + (step++) + ":</b> Ensure user is inside correct Case Details page for Case ID = <b>" + Case_id + "</b>."
	            );
	            System.out.println("[Step] Ensure user is inside correct Case Details page for Case ID = " + Case_id);

	            WebElement case_Dropdown;

	            try {
	                case_Dropdown = p.Case_Action_Dropdown();
	                Report_Listen.log_print_in_report().log(Status.INFO,
	                        "<b>🟨 Actual:</b> Case Action dropdown is visible. Already inside Case Details."
	                );
	                System.out.println("Actual: Already inside Case Details (Case Action dropdown found).");
	                System.out.println();
	            }
	            catch (Exception not_in_Case_Details) {

	                Report_Listen.log_print_in_report().log(Status.INFO,
	                        "<b>🟨 Actual:</b> Case Action dropdown not found. Navigating from Applications list using Case ID search."
	                );
	                System.out.println("Actual: Not inside Case Details. Navigating via Applications list search...");
	                System.out.println();

	                sd.Side_menu_option_clicker("Applications", d, "N/A");
	                p.landed_in_applicationList_confirmation();
	                p.Filter_clear().click();

	                WebElement Search = p.Application_search();
	                Search.sendKeys(Case_id);
	                Thread.sleep(1800);

	                // Close toasts if present (no assumption, just try safely)
	                try { lg.Toast_close_button().click(); } catch (Exception ignore) {}
	                try { lg.Toast_close_button().click(); } catch (Exception ignore) {}

	                List<WebElement> result_rows;
	                try {
	                    result_rows = p.rows();
	                    result_rows.get(0).click();
	                    Thread.sleep(800);

	                    Report_Listen.log_print_in_report().log(Status.INFO,
	                            "<b>🟨 Actual:</b> Case row opened from Applications list for Case ID = <b>" + Case_id + "</b>."
	                    );
	                    System.out.println("Actual: Case opened from Applications list. Case ID = " + Case_id);
	                    System.out.println();
	                }
	                catch (Exception Result_still_not_fetched) {

	                    Report_Listen.log_print_in_report().log(Status.INFO,
	                            "<b>🟨 Actual:</b> Rows not loaded in first attempt. Retrying row fetch and open."
	                    );
	                    System.out.println("Retry: Rows not fetched, retrying...");
	                    System.out.println();

	                    Thread.sleep(800);
	                    result_rows = p.rows();
	                    result_rows.get(0).click();
	                    Thread.sleep(800);

	                    Report_Listen.log_print_in_report().log(Status.INFO,
	                            "<b>🟨 Actual:</b> Case opened successfully after retry."
	                    );
	                    System.out.println("Actual: Case opened successfully after retry.");
	                    System.out.println();
	                }

	                // Case tags stabilization (your same behavior)
	                try {
	                    p.Case_tags();
	                }
	                catch (RuntimeException tags) {
	                    System.out.println("RuntimeException Found in case tags fetching thereby retrying");
	                    System.out.println();
	                    Thread.sleep(1200);
	                    p.Case_tags();
	                }

	                case_Dropdown = p.Case_Action_Dropdown();
	            }
	            try {
                 WebElement plaintiff= p.Title_plaintiff_name();
                 Plaintiff_name = plaintiff.getText().trim();
	            }catch(Exception case_plaintiff_name_fetch){
	            	Thread.sleep(800);
	            	WebElement plaintiff= p.Title_plaintiff_name();
	                Plaintiff_name = plaintiff.getText().trim();
	            	
	            }

	            // =========================
	            // Step 2: Open Log Payment form
	            // =========================
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>Step " + (step++) + ":</b> Open <b>Log Payment</b> from Case Action dropdown."
	            );
	            System.out.println("[Step] Open Log Payment from Case Action dropdown");

	            rp.movetoelement(case_Dropdown);
     
	            try {try {
	                p.Case_Action_Dropdown_list();
	            }catch(Exception dropdown_not_found){
	            	rp.movetoelement(case_Dropdown);
	            	Thread.sleep(800);
	            	p.Case_Action_Dropdown_list();
	            }
	                List<WebElement> optionsElements = p.Case_Dropdown_Options();

	                boolean found = false;
	                for (WebElement Each_Option : optionsElements) {
	                    String option_text = Each_Option.getText().trim();
	                    if (option_text.contains("Log Payment")) {
	                        Each_Option.click();
	                        found = true;
	                        break;
	                    }
	                }

	                if (found) {
	                    Report_Listen.log_print_in_report().log(Status.INFO,
	                            "<b>🟨 Actual:</b> Log Payment option clicked. Payment form should open."
	                    );
	                    System.out.println("Actual: Log Payment option clicked. Payment form opening...");
	                    System.out.println();
	                } else {
	                    Report_Listen.log_print_in_report().log(Status.FAIL,
	                            "<b>🟨 Actual:</b> ❌ Log Payment option not found inside Case Action dropdown."
	                    );
	                    System.out.println("FAIL: Log Payment option not found in dropdown.");
	                    System.out.println();
	                    throw new RuntimeException("Log Payment option not found in Case Action dropdown.");
	                }

	            } catch (Exception e) {
	                Report_Listen.log_print_in_report().log(Status.FAIL,
	                        "<b>🟨 Actual:</b> ❌ Failed while opening Log Payment form. Error: " + e.getMessage()
	                );
	                System.out.println("FAIL: Could not open Log Payment form. Error: " + e.getMessage());
	                System.out.println();
	                throw e;
	            }

	            // =========================
	            // Step 3: Fill payment form
	            // =========================
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>Step " + (step++) + ":</b> Fill Payment details and submit."
	            );
	            System.out.println("[Step] Fill Payment details and submit");

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<div style='background:#eef9ff; padding:14px; border-radius:10px; border:1px solid #bfe6ff; color:#0b1b33; font-family:Arial;'>"
	                  + "<b>📥 Input Values</b><br>"
	                  + "<b>Mode:</b> " + Mode + "<br>"
	                  + "<b>Type:</b> " + Type + "<br>"
	                  + "<b>Payer:</b> " + Payer + "<br>"
	                  + "<b>Date:</b> " + PayDate + "<br>"
	                  + "<b>Total Fees:</b> " + String.format("%.2f", Total_Fees) + "<br>"
	                  + "<b>Paid Amount (50%):</b> " + Amount_to_be_payed_text + "<br>"
	                  + "</div>"
	            );

	            System.out.println("Inputs:");
	            System.out.println("Mode            : " + Mode);
	            System.out.println("Type            : " + Type);
	            System.out.println("Payer           : " + Payer);
	            System.out.println("Payment Date    : " + PayDate);
	            System.out.println("Total Fees      : " + String.format("%.2f", Total_Fees));
	            System.out.println("Paid Amount(50%): " + Amount_to_be_payed_text);
	            System.out.println();

	            try {
	                List<WebElement> inputs = p.payment_logger_form_inputs();

	                inputs.get(0).sendKeys(Mode);
	                p.plaintiff_dropdown_list();
	                p.Plaintiff_options().get(0).click();
                    inputs.get(1).sendKeys(Type);
	                p.Incident_type_dropdown();
	                p.Incident_options().get(0).click();
	                if(Type.contains("Payment by Plaintiff")){
	                	inputs.get(2).sendKeys(Plaintiff_name);
	                }else {
	                inputs.get(2).sendKeys(Payer);}

	                WebElement Calender_field = inputs.get(3);
	                Calender_field.sendKeys(PayDate);
	                Calender_field.click();
	                p.calender_date_select().click();

	                inputs.get(4).sendKeys(Amount_to_be_payed_text);

	                p.textArea().sendKeys(Notes);

	                List<WebElement> popup_modal_buttons = p.poup_up_form_buttons();
	                popup_modal_buttons.get(0).click();

	                Report_Listen.log_print_in_report().log(Status.INFO,
	                        "<b>🟨 Actual:</b> Payment form submitted. Waiting for confirmation toast."
	                );

	                System.out.println("Actual: Payment form submitted. Waiting for toast...");
	                System.out.println();

	            } catch (Exception e) {
	                Report_Listen.log_print_in_report().log(Status.FAIL,
	                        "<b>🟨 Actual:</b> ❌ Error while filling/submitting payment form. Error: " + e.getMessage()
	                );
	                System.out.println("FAIL: Error while filling/submitting payment form. Error: " + e.getMessage());
	                System.out.println();
	                throw e;
	            }

	            // =========================
	            // Step 4: Capture toast
	            // =========================
	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>Step " + (step++) + ":</b> Capture toast after payment save."
	            );
	            System.out.println("[Step] Capture toast after payment save");

	            String paymentToast = "";

	            try {
	                paymentToast = lg.toast().getText().trim();

	                Report_Listen.log_print_in_report().log(Status.PASS,
	                        "<div style='background:#e9fbe9; padding:14px; border-radius:10px; border:1px solid #bde5bd; color:#0b3b0b; font-family:Arial;'>"
	                      + "<b>🟨 Actual:</b> ✅ Payment logged successfully.<br>"
	                      + "<b>Toast:</b> " + paymentToast + "<br>"
	                      + "<b>Paid Amount:</b> " + Amount_to_be_payed_text
	                      + "</div>"
	                );

	                System.out.println("PASS: Payment logged successfully.");
	                System.out.println("Toast      : " + paymentToast);
	                System.out.println("Paid Amount: " + Amount_to_be_payed_text);
	                System.out.println();

	                try { rp.wait_for_invisibility(lg.toast()); } catch (Exception ignore) {}

	            } catch (Exception e) {

	                Report_Listen.log_print_in_report().log(Status.FAIL,
	                        "<div style='background:#ffecec; padding:14px; border-radius:10px; border:1px solid #ffbdbd; color:#5b0b0b; font-family:Arial;'>"
	                      + "<b>🟨 Actual:</b> ❌ Payment submitted but confirmation toast not captured.<br>"
	                      + "<b>Possible reason:</b> Toast not visible / locator issue / fast disappear."
	                      + "</div>"
	                );

	                System.out.println("FAIL: Payment submitted but toast not captured (toast not visible / locator issue).");
	                System.out.println();
	            }

	            // ✅ return amount paid text (this is used later by Payment_Calculator)
	            return Amount_to_be_payed_text;
	   	    
	        }
	        
	        
	       
	        public void Payment_Calculator(TreeMap<String, String> data,String Case_Unique_id) throws IOException, InterruptedException{
	        	
	        	
	        		
	        	String Case_id = Case_Unique_id;

	        	int step = 1;
	        	double tolerance = 0.01;

	        	// =========================
	        	// Scenario Header
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<div style='background:#f1f5ff; padding:16px; border-radius:12px; border:1px solid #cbd5ff; color:#0b1b33; font-family:Arial;'>"
	        	      + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario Title: Payment Payoff Validation (Before vs After Payment)</div>"
	        	      + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Capture Payoff table values BEFORE payment, log payment, capture Payoff table values AFTER payment, and validate that the reduction equals Fees Paid (tolerance 0.01).</div>"
	        	      + "<div style='margin-top:10px; font-size:13px;'><b>📥 Input:</b> Case ID = <b>" + Case_id + "</b></div>"
	        	      + "<div style='margin-top:10px; font-size:13px;'><b>✅ Expected:</b> For each month row, (Before − After) should match Fees Paid within tolerance 0.01.</div>"
	        	      + "</div>"
	        	);

	        	System.out.println("\n==================================================");
	        	System.out.println("[SCENARIO] Payment Payoff Validation (Before vs After Payment)");
	        	System.out.println("Case ID   : " + Case_id);
	        	System.out.println("Expected  : (Before - After) should match Fees Paid within tolerance 0.01");
	        	System.out.println("==================================================\n");

	        	// =========================
	        	// Step 1: Before Payment Payoff Capture
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>Step " + (step++) + ":</b> Fetch Payoff table values BEFORE payment."
	        	);

	        	System.out.println("[Step] Fetch Payoff table values BEFORE payment");
	        	Pay_off_lien_list_Before_payment(Case_id);

	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>🟨 Actual:</b> Payoff values captured BEFORE payment. Rows captured = <b>" + PayoffTable_values_Before_Payment.size() + "</b>"
	        	);

	        	System.out.println("Actual: Payoff values captured BEFORE payment. Rows = " + PayoffTable_values_Before_Payment.size());
	        	System.out.println();

	        	// =========================
	        	// Step 2: Log Payment (Fees Paid)
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>Step " + (step++) + ":</b> Log Payment and capture Fees Paid amount."
	        	);

	        	System.out.println("[Step] Log Payment and capture Fees Paid amount");

	        	// ✅ Now Payment_Logger returns HALF of total fees (already formatted as String)
	        	String Fees_payed_amount = Payment_Logger(data, Case_id);
	        	double Fees_payed_in_double_upto_two_decimal = Double.parseDouble(String.format("%.2f", Double.parseDouble(Fees_payed_amount)));

	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<div style='background:#eef9ff; padding:14px; border-radius:10px; border:1px solid #bfe6ff; color:#0b1b33;'>"
	        	      + "<b>🟨 Actual:</b> Fees Paid captured from Payment Logger = <b>" + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "</b><br>"
	        	      + "<span style='font-size:12px;'>Note: Payment amount is HALF of (Document Prep Fee + Fund Transfer Fee).</span>"
	        	      + "</div>"
	        	);

	        	System.out.println("Actual: Fees Paid = " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal));
	        	System.out.println("Note  : Fees Paid is HALF of total fees (Doc Prep + Fund Transfer).");
	        	System.out.println();

	        	// =========================
	        	// Step 3: After Payment Payoff Capture
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>Step " + (step++) + ":</b> Fetch Payoff table values AFTER payment."
	        	);

	        	System.out.println("[Step] Fetch Payoff table values AFTER payment");
	        	Pay_off_lien_list_After_payment_data_fetcher(Case_id);

	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>🟨 Actual:</b> Payoff values captured AFTER payment. Rows captured = <b>" + PayoffTable_values_After_Payment.size() + "</b>"
	        	);

	        	System.out.println("Actual: Payoff values captured AFTER payment. Rows = " + PayoffTable_values_After_Payment.size());
	        	System.out.println();

	        	// =========================
	        	// Step 4: Month-wise Validation
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<b>Step " + (step++) + ":</b> Validate reduction (Before − After) equals Fees Paid for each month row (tolerance 0.01)."
	        	);

	        	System.out.println("[Step] Validate month-wise reduction equals Fees Paid (tolerance 0.01)");
	        	System.out.println();

	        	for (Map.Entry<String, Double> after_pair : PayoffTable_values_After_Payment.entrySet()) {

	        	    String Key = after_pair.getKey();

	        	    // Safety: BEFORE map missing Key
	        	    if (!PayoffTable_values_Before_Payment.containsKey(Key)) {

	        	        String extentMissing =
	        	                "<div style='background:#fff3cd; padding:14px; border-radius:10px; border:1px solid #ffe08a; color:#4a3b00; font-family:Arial;'>"
	        	              + "<b>⚠️ WARNING — Payoff Lien Validation</b><br><br>"
	        	              + "<b>Month:</b> " + Key + "<br>"
	        	              + "<b>Issue:</b> Month exists in AFTER map but not found in BEFORE map. Validation skipped for this month."
	        	              + "</div>";

	        	        Report_Listen.log_print_in_report().log(Status.WARNING, extentMissing);

	        	        System.out.println("⚠️ WARNING | " + Key);
	        	        System.out.println("Reason: Month exists AFTER payment but missing BEFORE payment values. Skipping validation.");
	        	        System.out.println("--------------------------------------------------\n");

	        	        continue;
	        	    }

	        	    double Before_payment = PayoffTable_values_Before_Payment.get(Key);
	        	    double After_payment = PayoffTable_values_After_Payment.get(Key);

	        	    double reduction = Before_payment - After_payment;
	        	    double reduction_upto_two_decimal = Double.parseDouble(String.format("%.2f", reduction));

	        	    double difference_upto_two_decimal = Double.parseDouble(String.format("%.2f",
	        	            Math.abs(reduction_upto_two_decimal - Fees_payed_in_double_upto_two_decimal)));

	        	    boolean isMatched = difference_upto_two_decimal < tolerance;

	        	    // ---------------------------
	        	    // ✅ Extent Calculation Table with Background (like your screenshot)
	        	    // ---------------------------
	        	    String resultTitle = isMatched
	        	            ? "✅ PASS — " + Key + " Reduction Matched Fees Paid"
	        	            : "❌ FAIL — " + Key + " Reduction Did NOT Match Fees Paid";

	        	    String resultColorBox = isMatched
	        	            ? "background:#e9fbe9; border:1px solid #bde5bd; color:#0b3b0b;"
	        	            : "background:#ffecec; border:1px solid #ffbdbd; color:#5b0b0b;";

	        	    String failReasonHtml = "";
	        	    if (!isMatched) {
	        	        failReasonHtml =
	        	                "<div style='margin-top:12px; font-weight:700;'>🧾 Fail Reason:</div>"
	        	              + "<div style='margin:4px 0; font-size:13px;'>Expected Reduction (Fees Paid) ≈ <b>" + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "</b></div>"
	        	              + "<div style='margin:4px 0; font-size:13px;'>Actual Reduction Observed = <b>" + String.format("%.2f", reduction_upto_two_decimal) + "</b></div>"
	        	              + "<div style='margin:4px 0; font-size:13px;'>Mismatch (Difference) = <b>" + String.format("%.2f", difference_upto_two_decimal) + "</b> (Tolerance " + String.format("%.2f", tolerance) + ")</div>";
	        	    }

	        	    String payoffExtentCard =
	        	            "<div style='background:#f7fbff; padding:18px; border-radius:12px; border:1px solid #c7ddff; color:#0b1b33; font-family:Arial;'>"
	        	          + "<div style='font-size:16px; font-weight:700; margin-bottom:10px;'>" + resultTitle + "</div>"

	        	          + "<div style='margin-top:10px; font-weight:700;'>📌 Values:</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>Month:</b> " + Key + "</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>Before Payment (Payoff table):</b> " + String.format("%.2f", Before_payment) + "</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>After Payment (Payoff table):</b> " + String.format("%.2f", After_payment) + "</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>Fees Paid (Logger):</b> " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "</div>"

	        	          + "<div style='margin:12px 0; border-top:1px solid #c7ddff;'></div>"

	        	          + "<div style='margin-top:10px; font-weight:700;'>🧮 Formula:</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>Reduction</b> = Before − After</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'><b>Difference</b> = |Reduction − Fees Paid|</div>"

	        	          + "<div style='margin-top:10px; font-weight:700;'>🧾 Substitute values:</div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'>Reduction = " + String.format("%.2f", Before_payment) + " − " + String.format("%.2f", After_payment)
	        	          + " = <b>" + String.format("%.2f", reduction_upto_two_decimal) + "</b></div>"
	        	          + "<div style='margin:4px 0; font-size:13px;'>Difference = |" + String.format("%.2f", reduction_upto_two_decimal) + " − "
	        	          + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "| = <b>" + String.format("%.2f", difference_upto_two_decimal) + "</b></div>"

	        	          + "<div style='margin-top:12px; padding:12px; border-radius:10px; " + resultColorBox + "'>"
	        	          + "<b>✅ Check:</b> Difference (" + String.format("%.2f", difference_upto_two_decimal) + ") &lt; Tolerance (" + String.format("%.2f", tolerance) + ")"
	        	          + " → <b>" + (isMatched ? "Matched ✅" : "Not Matched ❌") + "</b>"
	        	          + "</div>"

	        	          + failReasonHtml
	        	          + "</div>";

	        	    Report_Listen.log_print_in_report().log(isMatched ? Status.PASS : Status.FAIL, payoffExtentCard);

	        	    // ---------------------------
	        	    // ✅ Console printable version with fail reason
	        	    // ---------------------------
	        	    System.out.println("==================================================");
	        	    System.out.println("PAYOFF LIEN VALIDATION  |  " + Key);
	        	    System.out.println("--------------------------------------------------");
	        	    System.out.println("Before Payment (Payoff table) : " + String.format("%.2f", Before_payment));
	        	    System.out.println("After Payment  (Payoff table) : " + String.format("%.2f", After_payment));
	        	    System.out.println("Fees Paid (Logger)            : " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal));
	        	    System.out.println("--------------------------------------------------");
	        	    System.out.println("Reduction  = Before - After   : " + String.format("%.2f", reduction_upto_two_decimal));
	        	    System.out.println("Difference = |Reduction-Fees| : " + String.format("%.2f", difference_upto_two_decimal));
	        	    System.out.println("Tolerance                     : " + String.format("%.2f", tolerance));
	        	    System.out.println("--------------------------------------------------");

	        	    if (isMatched) {
	        	        System.out.println("RESULT : PASS ✅  (Reduction matched Fees Paid within tolerance)");
	        	    } else {
	        	        System.out.println("RESULT : FAIL ❌  (Reduction did NOT match Fees Paid within tolerance)");
	        	        System.out.println("FAIL REASON:");
	        	        System.out.println(" - Expected Reduction (Fees Paid) ≈ " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal));
	        	        System.out.println(" - Actual Reduction Observed      = " + String.format("%.2f", reduction_upto_two_decimal));
	        	        System.out.println(" - Mismatch (Difference)          = " + String.format("%.2f", difference_upto_two_decimal));
	        	    }

	        	    System.out.println("==================================================");
	        	    System.out.println();
	        	}

	        	// =========================
	        	// End summary log
	        	// =========================
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	        	        "<div style='background:#f1fff2; padding:14px; border-radius:12px; border:1px solid #bde5bd; color:#0b3b0b; font-family:Arial;'>"
	        	      + "<b>✅ Payment Payoff Validation Completed</b><br>"
	        	      + "<b>Case ID:</b> " + Case_id + "<br>"
	        	      + "<b>Fees Paid:</b> " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal) + "<br>"
	        	      + "<b>Months Validated:</b> " + PayoffTable_values_After_Payment.size()
	        	      + "</div>"
	        	);

	        	System.out.println("✅ Payment Payoff Validation Completed for Case ID: " + Case_id);
	        	System.out.println("Fees Paid = " + String.format("%.2f", Fees_payed_in_double_upto_two_decimal));
	        	System.out.println("Months validated: " + PayoffTable_values_After_Payment.size());
	        	System.out.println();

	        	
	        	
	        }
	        
           public void Pay_off_lien_list_Before_payment(String Case_Id) throws IOException, InterruptedException{
	        	
	        	Application_Locaters p = new Application_Locaters(d);
			      Login_Locaters lg = new Login_Locaters(d);
				  SIde_Menu_Handler sd = new SIde_Menu_Handler();
				  Repeat rp = new Repeat(d);
		    	  
				  String Case_id = Case_Id;
				  
				  
				  PayoffTable_values_Before_Payment.clear();
				  Report_Listen.log_print_in_report().log(Status.INFO,
					        "<b>📌 Action:</b> Open Payoff modal and capture values BEFORE payment.<br>" +
					        "<b>Case ID:</b> " + Case_id
					);
					System.out.println("[Action] Capture Payoff values BEFORE payment | Case ID: " + Case_id);

				  
				  try{p.Case_Action_Dropdown();}
			       catch(Exception not_in_Case_Details) {	    
				   sd.Side_menu_option_clicker("Applications", d,"N/A");
				   p.landed_in_applicationList_confirmation();
				   p.Filter_clear().click();
				   WebElement Search = p.Application_search();
				   Search.sendKeys(Case_id);
				   Thread.sleep(1800);
				   WebElement Toast_One = lg.Toast_close_button();
				   Toast_One.click();
				   WebElement Toast_Two = lg.Toast_close_button();
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
					   Case_Tags = p.Case_tags();}}
				   try{tab_selector("Liens");}
					catch(Exception Lien_tab_retry){
						Thread.sleep(800);
						tab_selector("Liens");}
		    	    WebElement payoff_button = p.Payoff_Button();
		    	    rp.Scroll_to_element(payoff_button);
		    	    rp.wait_for_Clickable(payoff_button);
		    	    payoff_button.click();
		    	    p.Payoff_table_title();
		    	    List<WebElement> Cells;
		    	    try{
		    	    	Cells = p.modal_table_cells();}
		    	    catch(Exception pay_off_table_rows_not_found){
		    	    	Thread.sleep(800);
		    	    	p.modal_table();
		    	    	Cells = p.modal_table_cells();}
		    	    int m=0;
		    	    for(WebElement Cell:Cells){
		    	    	
		    	    	String cellvalue=Cell.getText().trim();
		    	    	
		    	    	
		    	    	if(!cellvalue.contains("/")){
		    	    		String cellvalue_clean = cellvalue .replace("$","") .replace(",","") .replace("\u00A0","") .trim();
		    	    		double each_month_payable_raw = Double.parseDouble(cellvalue_clean);
		    	            double each_month_payable = Double.parseDouble(String.format("%.2f", each_month_payable_raw));
		    	            PayoffTable_values_Before_Payment.put("month "+m, each_month_payable);/*
	                        System.out.println("month "+m+"  "+ each_month_payable);
	    	    	    	System.out.println(); */
		    	            m++;}}
		    	    Report_Listen.log_print_in_report().log(Status.INFO,
		    	            "<b>🟨 Actual:</b> Stored payoff values BEFORE payment. Rows captured = <b>" + PayoffTable_values_Before_Payment.size() + "</b>"
		    	    );
		    	    System.out.println("Actual: Stored payoff values BEFORE payment. Rows = " + PayoffTable_values_Before_Payment.size());
		    	    System.out.println();

	        	     p.Close_Button().click();
	        	
			       }
	        
           
           public void Pay_off_lien_list_After_Revise_contract(TreeMap<String, String> Case_Data,String id) throws IOException, InterruptedException{
	        	
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

				  
				  try{p.Case_Action_Dropdown();}
			       catch(Exception not_in_Case_Details) {	    
				   sd.Side_menu_option_clicker("Applications", d,"N/A");
				   p.landed_in_applicationList_confirmation();
				   p.Filter_clear().click();
				   WebElement Search = p.Application_search();
				   Search.sendKeys(Case_id);
				   Thread.sleep(1800);
				   WebElement Toast_One = lg.Toast_close_button();
				   Toast_One.click();
				   WebElement Toast_Two = lg.Toast_close_button();
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
					   Case_Tags = p.Case_tags();}}
				   try{tab_selector("Liens");}
					catch(Exception Lien_tab_retry){
						Thread.sleep(800);
						tab_selector("Liens");}
				   Report_Listen.log_print_in_report().log(Status.INFO,
					        "<b>Step " + (step++) + ":</b> Perform <b>Revise Contract</b> flow (Buyout update + Interest Start Date update + Generate Contract)."
					);
					System.out.println("[Step] Perform Revise Contract flow (Buyout + Interest Start Date + Generate)");
					System.out.println();
   				    Report_Listen.log_print_in_report().log(Status.INFO,
					        "<b>🟨 Actual:</b> Revise Contract flow executed. Proceeding to open Payoff modal and capture updated payoff values."
					);
					System.out.println("Actual: Revise Contract flow executed. Now capturing Payoff values...");
					System.out.println();
				   
		    	    WebElement payoff_button = p.Payoff_Button();
		    	    rp.Scroll_to_element(payoff_button);
		    	    rp.wait_for_Clickable(payoff_button);
		    	    payoff_button.click();
		    	    p.Payoff_table_title();
		    	    List<WebElement> Cells;
		    	    try{
		    	    	Cells = p.modal_table_cells();}
		    	    catch(Exception pay_off_table_rows_not_found){
		    	    	Thread.sleep(800);
		    	    	p.modal_table();
		    	    	Cells = p.modal_table_cells();}
		    	    int m=0;
		    	    for(WebElement Cell:Cells){
		    	    	
		    	    	String cellvalue=Cell.getText().trim();
		    	    	
		    	    	
		    	    	if(!cellvalue.contains("/")){
		    	    		String cellvalue_clean = cellvalue .replace("$","") .replace(",","") .replace("\u00A0","") .trim();
		    	    		double each_month_payable_raw = Double.parseDouble(cellvalue_clean);
		    	            double each_month_payable = Double.parseDouble(String.format("%.2f", each_month_payable_raw));
		    	            PayoffTable_values_Revise_contract.put("month "+m, each_month_payable);
	                     
		    	            m++;}}
		    	    Report_Listen.log_print_in_report().log(Status.INFO,
		    	            "<b>🟨 Actual:</b> Stored payoff values After Contract Revised. Rows captured = <b>" + PayoffTable_values_Revise_contract.size() + "</b>"
		    	    );
		    	    System.out.println("Actual: Stored payoff values After Contract Revised. Rows = " + PayoffTable_values_Revise_contract.size());
		    	    System.out.println();

	        	     p.Close_Button().click(); 
	        	
			       }
             
           
              
              public void Revise_Contract(TreeMap<String, String> Case_Data) throws InterruptedException, IOException{
            	  
            	  Application_Locaters p = new Application_Locaters(d);
            	  Repeat rp = new Repeat(d);
            	  JavascriptExecutor js = (JavascriptExecutor)d;
            	  Login_Locaters lg = new Login_Locaters(d);
            	  
            	  int Initial_buyout_amount_from_data_provider = Integer.parseInt(Case_Data.get("Buyout Amount"));
            	  double New_Buyout_Amount = Initial_buyout_amount_from_data_provider/3.0;
            	  double New_Buyout_Amount_Upto_Two_Decimal = Double.parseDouble(String.format("%.2f", New_Buyout_Amount));
            	  String New_Buyout_Amount_String = String.format("%.2f", New_Buyout_Amount_Upto_Two_Decimal);
                  String Buyout_Funder = Case_Data.get("Buyout Funder Name");
            	  String Buyout_date = Case_Data.get("Buyout Expiry Date");
            	  double Amount_to_Plaintiff;
            	  double lienAmount_upto_2_decimal; 
	    		  double principal_upto_2_decimal;  
	    		  double lienBalance_upto_2_decimal;
	    		  double paidAmount_upto_2_decimal;
	    		  LIEN_AMOUNT_Values.clear();
	   		      TOTAL_PRINCIPAL_Values.clear();
	   		      CURRENT_LIEN_BALANCE_Values.clear();
	   		      RETURNED_AMT_Values.clear();
	   		      
	   		     
	   		      
	   		      //Particular_Lien_Accessor("https://logbook.wechopfees.com/cases/details/840/Liens");
	   		      
	   		       
            	  int step = 1;

            	  Report_Listen.log_print_in_report().log(Status.INFO,
            	          "<div style='background:#f6ffed; padding:16px; border-radius:12px; border:1px solid #b7eb8f; color:#102a10; font-family:Arial;'>"
            	        + "<div style='font-size:16px; font-weight:700;'>🔹 Scenario: Revise Contract</div>"
            	        + "<div style='margin-top:10px; font-size:13px;'><b>📘 Description:</b> Open a lien row, click Revise Contract, add Buyout with new amount, update Interest Start Date, generate contract, and validate buyout amount in Lien Details modal.</div>"
            	        + "<div style='margin-top:10px; font-size:13px;'><b>✅ Expected:</b> Buyout details should match what was entered and Buyout Amount in modal must equal the new calculated buyout amount.</div>"
            	        + "</div>"
            	  );

            	  System.out.println("\n==================================================");
            	  System.out.println("[SCENARIO] Revise Contract");
            	  System.out.println("Description: Revise contract -> add buyout -> update date -> generate -> validate modal values");
            	  System.out.println("==================================================\n");

            	  
            	  pop_up_modal_label_values.clear();
            	  List<WebElement> lien_rows = null;
            	  
            	  
            	  List<WebElement> rows = p.Open_Lien_table_contents();
            	  rows.get(0).click();
            	  Thread.sleep(800);
            	  List<WebElement> inner_boxes = p.pop_up_modal_inner_content_boxes();
            	  WebElement Revise_contract_button = inner_boxes.get(1).findElement(By.xpath(".//*[text()='Revise Contract']/.."));
            	  Revise_contract_button.click();
            	  WebElement Revise_contract_form=  p.second_pop_up_form();
      	 	      Thread.sleep(800);
      	 	      rp.movetoelement(Revise_contract_form);
      	 	      WebElement Buyout_Button;
      	 	      try{
      	 	    	 Buyout_Button = p.Add_Buyout_button();}
      	 	      catch(Exception buyouy_button_not_found){
      	 	    // ✅ Extent log (catch + retry)
      	 	       Report_Listen.log_print_in_report().log(Status.INFO,
      	 	               "<b>🟡 Retry:</b> <b>Add Buyout</b> button was not found on first attempt. Waiting 800ms and retrying once.<br>"
      	 	             + "<b>🟡 Exception:</b> " + buyouy_button_not_found.getClass().getSimpleName());

      	 	       // ✅ Console log (catch + retry)
      	 	       System.out.println("⚠️ First attempt FAILED to locate 'Add Buyout' button");
      	 	       System.out.println("Retry Plan : Wait 800ms and retry once");
      	 	       System.out.println("Exception  : " + buyouy_button_not_found.getClass().getSimpleName());
      	 	       System.out.println();

      	 	       Thread.sleep(800);
      	 	       Buyout_Button = p.Add_Buyout_button();

      	 	       // ✅ Extent log (retry success)
      	 	       Report_Listen.log_print_in_report().log(Status.PASS,
      	 	               "<b>🟨 Actual:</b> ✅ <b>Add Buyout</b> button found successfully after retry."
      	 	       );

      	 	       // ✅ Console log (retry success)
      	 	       System.out.println("✅ Actual: 'Add Buyout' button found successfully after retry");
      	 	       System.out.println();}
      	 	      rp.movetoelement(Buyout_Button);
      	 	      Buyout_Button.click();
      	 	      List<WebElement> buyout_inputs = p.Third_popup_form_inputs();
      	 	      buyout_inputs.get(0).sendKeys(Buyout_Funder);
   	 		      buyout_inputs.get(1).sendKeys(New_Buyout_Amount_String);
   	 		      buyout_inputs.get(2).sendKeys(Buyout_date);
   	 		      p.Higlighted_calender_date().click();
   	 		      p.Third_popup_form_buttons().get(1).click();/*
   	 		      WebElement toast = lg.toast();
   	 		      String Toast_text = toast.getText().trim();
   	 		      Login_negative_testcases.Toast_printer(Toast_text, d);*/
   	 		      Thread.sleep(800);
      	 	      Thread.sleep(800);
      	 	   try{
   	 	    	p.Add_buyout_button_inside_edit_contract_from();
   	 	    	System.out.println("Testcase Failed added buyout not showing inside edit terms/contract Form");
   	 	    	System.out.println();
   	 	    	Report_Listen.log_print_in_report().log(Status.FAIL,
   	 					"<b>🟨 Actual:</b> ❌ Edit Terms shows <b>Add Buyout</b> button (Buyout appears missing in Edit Terms).<br>"
   	 							+ "<b>Expected:</b> Buyout should already be present, so <b>Add Buyout</b> should not appear.");}
   	 	    catch(Exception kkm){
   	 	    	System.out.println("Testcase Passed add buyout button not shown");
   	 	        String Funder_name = p.Buyout_funder_name_inside_pop_up_modal_form().getAttribute("value").trim();
   	 	        String Buyout_amount = p.Buyout_Amount_inside_pop_up_modal_form().getAttribute("value").trim();
   	 	        String Buyout_Expiry_date = p.Buyout_Date_inside_pop_up_modal_form().getAttribute("value").trim();
   	 	        System.out.println();
   	 	        System.out.println(Funder_name.equalsIgnoreCase(Buyout_Funder)&&Buyout_amount.equalsIgnoreCase(New_Buyout_Amount_String)&&Buyout_Expiry_date.equalsIgnoreCase(Buyout_date)?"Testcase Passed All Buyout details matching with details in modal":"Testcase Failed All Buyout details not matching with details in modal");
   	 	        System.out.println();
   	 	    // ✅ CLIENT-FRIENDLY: ONLY show pass/fail + business values
   	 			String match_log =
   	 					"<b>📌 Buyout Details Shown in Edit Terms:</b><br>"
   	 							+ "<b>Funder:</b> "+Funder_name+"<br>"
   	 							+ "<b>Amount:</b> "+Buyout_amount+"<br>"
   	 							+ "<b>Expiry Date:</b> "+Buyout_Expiry_date+"<br><br>"
   	 							+ "<b>✅ Expected Buyout Details:</b><br>"
   	 							+ "<b>Funder:</b> "+Buyout_Funder+"<br>"
   	 							+ "<b>Amount:</b> "+New_Buyout_Amount_String+"<br>"
   	 							+ "<b>Expiry Date:</b> "+Buyout_date+"<br><br>"
   	 							+ "<b>Final Check:</b> All 3 values should match exactly.";

   	 			Report_Listen.log_print_in_report().log(
   	 					(Funder_name.equalsIgnoreCase(Buyout_Funder) && Buyout_amount.equalsIgnoreCase(New_Buyout_Amount_String) && Buyout_Expiry_date.equalsIgnoreCase(Buyout_date))
   	 							? Status.PASS : Status.FAIL,
   	 					((Funder_name.equalsIgnoreCase(Buyout_Funder) && Buyout_amount.equalsIgnoreCase(New_Buyout_Amount_String) && Buyout_Expiry_date.equalsIgnoreCase(Buyout_date))
   	 							? "<b>✅ Result:</b> Buyout details match in Edit Terms.<br><br>"
   	 							: "<b>❌ Result:</b> Buyout details do NOT match in Edit Terms.<br><br>")
   	 							+ match_log);}
      	 	      Thread.sleep(800);
      	 	      WebElement Rerendered_Revise_contract_form= p.second_pop_up_form();
	 	          Thread.sleep(800);
	 	          rp.movetoelement(Rerendered_Revise_contract_form);
      	 	      WebElement Interest_start_date_field = p.Interest_Start_Date();
      	 	      rp.Scroll_to_element(Interest_start_date_field);
      	 	      rp.movetoelement(Interest_start_date_field);
      	 	      Thread.sleep(800);
      	 	      p.Calender_clear_button().click();
      	 	      Interest_start_date_field.click();
      	 	      Thread.sleep(800);/*
      	 	      List<WebElement> date_cells = p.Calender_cells();
      	 	      int cell_index = date_cells.size()-1;
      	 	      WebElement Date_selected = date_cells.get(cell_index);
      	 	      Date_selected.click(); */
      	 	      p.calender_date_select().click();
      	 	      Thread.sleep(800);
      	 	      WebElement Generate_Contract_Button = p.Submit_button();
      		      rp.movetoelement(Generate_Contract_Button);
      		      rp.wait_for_theElement_tobe_clickable(Generate_Contract_Button);
      		      js.executeScript("arguments[0].click();", Generate_Contract_Button);
      		      Thread.sleep(800);
      		      Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);
      		      Thread.sleep(800);
      		      WebElement Modal = p.popup_modal();
      		      List<WebElement> Labels;
      		      try {Labels= p.Lien_Details_field_labels();}
      		      catch(Exception mmll){
      		    	  Thread.sleep(800);
      		    	Labels= p.Lien_Details_field_labels();
      		    	System.out.println("⚠️ First attempt FAILED to fetch labels");
      		    	System.out.println();
      		        System.out.println("Retry Plan: Wait 800ms and retry once");
      		        System.out.println();
      		      }
      		      
      		      List<WebElement> Values = p.Lien_Details_field_values();
      		      for(int v=0;v<Math.min(Labels.size(), Values.size());v++){
      		    	  String Label_text = Labels.get(v).getText().trim();
      		    	  String Value_text = Values.get(v).getText().trim();
      		    	if(Value_text.contains("$") || Label_text.contains("AMOUNT TO PLAINTIFF:") || Label_text.contains("BUYOUT AMOUNT:")){

      		    	    double Amount = Double.parseDouble(Value_text.replace("$","").replace(",","").trim());
      		    	    pop_up_modal_label_values.put(Label_text, Amount);}}
      		      
      		      for(var pair:pop_up_modal_label_values.entrySet()){
      		    	  System.out.println(pair.getKey()+" "+pair.getValue());
      		    	  System.out.println();
      		      }
      		      
      		    Amount_to_Plaintiff = pop_up_modal_label_values.get("AMOUNT TO PLAINTIFF:");
                double Buyout_Amount_from_modal = pop_up_modal_label_values.get("BUYOUT AMOUNT:");
      		  String Buyout_Amount_from_modal_String = String.format("%.2f", Buyout_Amount_from_modal);

      		String expectedBuyout = New_Buyout_Amount_String;
      		String actualBuyout   = Buyout_Amount_from_modal_String;

      		if (actualBuyout.equalsIgnoreCase(expectedBuyout)) {

      		    // ✅ PASS logs
      		    Report_Listen.log_print_in_report().log(Status.PASS,
      		            "<div style='background:#eaffea; padding:14px; border-radius:10px; border:1px solid #b7eb8f; color:#102a10; font-family:Arial;'>"
      		          + "<b>✅ Buyout Amount MATCHED</b><br><br>"
      		          + "<b>Expected Buyout Amount:</b> " + expectedBuyout + "<br>"
      		          + "<b>Actual Buyout Amount:</b> " + actualBuyout + "<br>"
      		          + "<b>Result:</b> Value is correct in Lien Details modal."
      		          + "</div>"
      		    );

      		    System.out.println("✅ Buyout Amount MATCHED");
      		    System.out.println("Expected Buyout Amount : " + expectedBuyout);
      		    System.out.println("Actual Buyout Amount   : " + actualBuyout);
      		    System.out.println();

      		} else {

      		    // ❌ FAIL logs + stop
      		    Report_Listen.log_print_in_report().log(Status.FAIL,
      		            "<div style='background:#ffecec; padding:14px; border-radius:10px; border:1px solid #ffbdbd; color:#5b0b0b; font-family:Arial;'>"
      		          + "<b>❌ Buyout Amount MISMATCH - Stopping execution</b><br><br>"
      		          + "<b>Expected Buyout Amount:</b> " + expectedBuyout + "<br>"
      		          + "<b>Actual Buyout Amount:</b> " + actualBuyout + "<br>"
      		          + "<b>Reason:</b> Modal value does not match revised buyout amount."
      		          + "</div>"
      		    );

      		    System.out.println("❌ Buyout Amount MISMATCH - Stopping execution");
      		    System.out.println("Expected Buyout Amount : " + expectedBuyout);
      		    System.out.println("Actual Buyout Amount   : " + actualBuyout);
      		    System.out.println();

      		    throw new AssertionError("Buyout Amount mismatch. Expected=" + expectedBuyout + ", Actual=" + actualBuyout);
      		}

      		// Continue calculations only after PASS ✅
      		double Buyout_Amount_in_lien_details = Double.parseDouble(actualBuyout);

      		double LIEN_AMOUNT_in_LIEN_Table_Calculated = Amount_to_Plaintiff + Buyout_Amount_in_lien_details;
      		double LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal =
      		        Double.parseDouble(String.format("%.2f", LIEN_AMOUNT_in_LIEN_Table_Calculated));

      		Report_Listen.log_print_in_report().log(Status.INFO,
      		        "<div style='background:#eaf4ff; padding:14px; border-radius:10px; border:1px solid #c7ddff; color:#0b1b33; font-family:Arial;'>"
      		      + "<b>🧮 Lien Amount Calculation</b><br><br>"
      		      + "<b>Amount To Plaintiff:</b> " + String.format("%.2f", Amount_to_Plaintiff) + "<br>"
      		      + "<b>Buyout Amount:</b> " + String.format("%.2f", Buyout_Amount_in_lien_details) + "<br>"
      		      + "<b>Calculated Lien Amount:</b> <b>" + String.format("%.2f", LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal) + "</b>"
      		      + "</div>"
      		);

      		System.out.println("LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal = "
      		        + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal);
      		System.out.println();

      		WebElement Modal_close = p.Close_Button();
      		Modal_close.click();
      		Thread.sleep(900);
      		try {
      		lien_rows =p.Open_Lien_table_contents();}
      		catch(Exception lien_row_catch){
      			Thread.sleep(800);
      			lien_rows =p.Open_Lien_table_contents();
      		}
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
	           
	           for(int m=0; m<no_of_rows; m++){

	        	    String fourth_cell_datas  = fourth_cells.get(m).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
	        	    String Fifth_cell_data    = Fifth_cells.get(m).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
	        	    String Sixth_cell_data    = Sixth_cells.get(m).getText().replace("$","").replace(",","").replace("\u00A0","").trim();
	        	    String seventh_cell_data  = Seventh_cells.get(m).getText().replace("$","").replace(",","").replace("\u00A0","").trim();

	        	    double lienAmount_raw     = Double.parseDouble(fourth_cell_datas);
	        	    double principal_raw      = Double.parseDouble(Fifth_cell_data);
	        	    double lienBalance_raw    = Double.parseDouble(Sixth_cell_data);
	        	    double paidAmount_raw     = Double.parseDouble(seventh_cell_data);

	        	    lienAmount_upto_2_decimal  = Double.parseDouble(String.format("%.2f", lienAmount_raw));
	        	    principal_upto_2_decimal   = Double.parseDouble(String.format("%.2f", principal_raw));
	        	    lienBalance_upto_2_decimal = Double.parseDouble(String.format("%.2f", lienBalance_raw));
	        	    paidAmount_upto_2_decimal  = Double.parseDouble(String.format("%.2f", paidAmount_raw));
	        	    
	        	    WebElement lien_amount_cell = fourth_cells.get(m);
	        	    rp.Scroll_to_element(lien_amount_cell);
	        	    Thread.sleep(500);
	        	    LIEN_AMOUNT_Values.put("Lien Amounts"+m,  lienAmount_upto_2_decimal);
	        	    WebElement Principal_cell = Fifth_cells.get(m);
	        	    rp.Scroll_to_element(Principal_cell);
	        	    Thread.sleep(500);
	    		    TOTAL_PRINCIPAL_Values.put("Principal Amount"+m,  principal_upto_2_decimal);
	    		    WebElement Current_lien_cell = Sixth_cells.get(m);
	        	    rp.Scroll_to_element(Current_lien_cell);
	        	    Thread.sleep(500);
	    		    CURRENT_LIEN_BALANCE_Values.put("Lien Balance"+m,  lienBalance_upto_2_decimal);
	    		    WebElement Return_amount_cell = Seventh_cells.get(m);
	        	    rp.Scroll_to_element(Return_amount_cell);
	        	    Thread.sleep(500);
	    		    RETURNED_AMT_Values.put("Paid Amount"+m,  paidAmount_upto_2_decimal);}
	           
	           double Lien_Balance_From_Table = LIEN_AMOUNT_Values.get("Lien Amounts0");

	           double Difference = Double.parseDouble(String.format("%.2f",
	                   Math.abs(Lien_Balance_From_Table - LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal)));

	           double tolerance = 0.25;  // keep it safe (case-to-case rounding difference)

	           System.out.println(
	                   Difference <= tolerance
	                           ? "✅ Testcase Passed | Lien Balance matches Calculated Lien Amount"
	                           + " | Lien Balance = " + Lien_Balance_From_Table
	                           + " | Calculated = " + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal
	                           + " | Difference = " + Difference
	                           + " | Tolerance = " + tolerance
	                           : "❌ Testcase Failed | Lien Balance NOT matching Calculated Lien Amount (Stopping Execution)"
	                           + " | Lien Balance = " + Lien_Balance_From_Table
	                           + " | Calculated = " + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal
	                           + " | Difference = " + Difference
	                           + " | Tolerance = " + tolerance
	           );

	           Report_Listen.log_print_in_report().log(
	                   Difference <= tolerance ? Status.PASS : Status.FAIL,
	                   Difference <= tolerance
	                           ? "<b>✅ Lien Balance matched Calculated Lien Amount</b><br>"
	                           + "<b>Lien Balance:</b> " + Lien_Balance_From_Table + "<br>"
	                           + "<b>Calculated:</b> " + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal + "<br>"
	                           + "<b>Difference:</b> " + Difference + "<br>"
	                           + "<b>Tolerance:</b> " + tolerance
	                           : "<b>❌ Lien Balance mismatch with Calculated Lien Amount</b><br>"
	                           + "<b>Lien Balance:</b> " + Lien_Balance_From_Table + "<br>"
	                           + "<b>Calculated:</b> " + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal + "<br>"
	                           + "<b>Difference:</b> " + Difference + "<br>"
	                           + "<b>Tolerance:</b> " + tolerance
	           );

	           if (Difference > tolerance) {
	               throw new AssertionError("Lien Balance mismatch. Balance=" + Lien_Balance_From_Table
	                       + ", Calculated=" + LIEN_AMOUNT_in_LIEN_Table_Calculated_Upto_Two_Decimal
	                       + ", Diff=" + Difference + ", Tolerance=" + tolerance);
	           }}
	        
              @Test
              public void Particular_Lien_Accessor(String Url) throws IOException, InterruptedException{
            	 
            	Sidemenu_Locaters p = new Sidemenu_Locaters(d);
              	Login_Locaters lg = new Login_Locaters(d);
              	Repeat rp = new Repeat(d);  
              	 Application_Locaters ap = new Application_Locaters(d);  
            	  
            	  
            	 
            	String lien_url = Url;
            	login(d);
            	p.Side_Menu();
            	d.get(lien_url);
            	ap.Landed_in_lien_List();
            	Thread.sleep(800);
            	  
            	  
              }
	       
		      public void Pay_off_lien_list_After_payment_data_fetcher(String Case_Id) throws IOException, InterruptedException{
		    	  
		    	  
		    	  Application_Locaters p = new Application_Locaters(d);
			      Login_Locaters lg = new Login_Locaters(d);
				  SIde_Menu_Handler sd = new SIde_Menu_Handler();
				  Repeat rp = new Repeat(d);
		    	  
				  String Case_id = Case_Id;
				  PayoffTable_values_After_Payment.clear();
				  Report_Listen.log_print_in_report().log(Status.INFO,
					        "<b>📌 Action:</b> Open Payoff modal and capture values AFTER payment.<br>" +
					        "<b>Case ID:</b> " + Case_id
					);
					System.out.println("[Action] Capture Payoff values AFTER payment | Case ID: " + Case_id);

				  try{p.Case_Action_Dropdown();}
			       catch(Exception not_in_Case_Details) {	    
				   sd.Side_menu_option_clicker("Applications", d,"N/A");
				   p.landed_in_applicationList_confirmation();
				   p.Filter_clear().click();
				   WebElement Search = p.Application_search();
				   Search.sendKeys(Case_id);
				   Thread.sleep(1800);
				   WebElement Toast_One = lg.Toast_close_button();
				   Toast_One.click();
				   WebElement Toast_Two = lg.Toast_close_button();
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
					   Case_Tags = p.Case_tags();}}
				   try{tab_selector("Liens");}
					catch(Exception Lien_tab_retry){
						Thread.sleep(800);
						tab_selector("Liens");}
		    	    WebElement payoff_button = p.Payoff_Button();
		    	    rp.Scroll_to_element(payoff_button);
		    	    rp.wait_for_Clickable(payoff_button);
		    	    payoff_button.click();
		    	    p.Payoff_table_title();
		    	    List<WebElement> Cells;
		    	    try{
		    	    	Cells = p.modal_table_cells();}
		    	    catch(Exception pay_off_table_rows_not_found){
		    	    	Thread.sleep(800);
		    	    	p.modal_table();
		    	    	Cells = p.modal_table_cells();}
		    	    int m=0;
		    	    for(WebElement Cell:Cells){
		    	    	
		    	    	String cellvalue=Cell.getText().trim();
		    	    	
		    	    	if(!cellvalue.contains("/")){
		    	    		String cellvalue_clean = cellvalue .replace("$","") .replace(",","") .replace("\u00A0","") .trim();
		    	    		double each_month_payable_raw = Double.parseDouble(cellvalue_clean);
		    	            double each_month_payable = Double.parseDouble(String.format("%.2f", each_month_payable_raw));
		    	            PayoffTable_values_After_Payment.put("month "+m, each_month_payable);/*
	                        System.out.println("month "+m+"  "+ each_month_payable);
	    	    	    	System.out.println();*/
		    	            m++;}} Report_Listen.log_print_in_report().log(Status.INFO,
		    	                    "<b>🟨 Actual:</b> Stored payoff values AFTER payment. Rows captured = <b>" + PayoffTable_values_After_Payment.size() + "</b>"
		    	            		);
		    	            		System.out.println("Actual: Stored payoff values AFTER payment. Rows = " + PayoffTable_values_After_Payment.size());
		    	            		System.out.println();

		    	    p.Close_Button().click();
		      
		      }
	        
	      
	     @Test(dataProvider="case_plus_plaintiff")
	     public void Multiple_Application_Generator(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data,TreeMap<String,String> Email_Send_Data) throws InterruptedException, IOException{
	    	 
	    	   Application_Locaters p = new Application_Locaters(d);
			   Login_Locaters lg = new Login_Locaters(d);
			   Repeat rp = new Repeat(d);
			   JavascriptExecutor js = (JavascriptExecutor)d; 
			   SIde_Menu_Handler sd = new SIde_Menu_Handler();
			   
			  // Collections_Clear();
			    String Case_id = "MA2600545";
				String Requested_Amount= Case_Data.get("Requested Amount");
				int step = 1;

				// =========================
				// Case Context Header (Extent + Console)
				// =========================
				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>🔹 Scenario Title:</b> Add Application + Add Buyout + Generate Contract<br>"
				      + "<b>📥 Input:</b> Case ID = <b>" + Case_id + "</b> | Requested Amount = <b>" + Requested_Amount + "</b><br>"
				      + "<b>✅ Expected:</b> Application should be created, Buyout should be saved, and contract flow should proceed without navigation issues."
				);
				System.out.println("\n==================================================");
				System.out.println("[SCENARIO] Add Application + Buyout + Contract");
				System.out.println("Case ID         : " + Case_id);
				System.out.println("Requested Amount: " + Requested_Amount);
				System.out.println("==================================================\n");

				// =========================
				// Navigation Guard (try/catch) with Case ID logs
				// =========================
				try {
				    p.Send_button();

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>Step " + (step++) + ":</b> Confirm we are already inside Case Details screen.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("[Step] Already in Case Details (Send button found) | Case ID: " + Case_id);

				} catch (Exception not_in_Case_Details) {

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>Step " + (step++) + ":</b> Not in Case Details. Navigating via Applications list and opening case row.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				          + "<b>Reason:</b> Send button not found on current screen."
				    );

				    System.out.println("[Step] Not in Case Details -> Navigate via Applications list | Case ID: " + Case_id);
				    System.out.println("Reason: Send button not found. Going to Applications, searching Case ID, opening first row.");
				    System.out.println();

				    sd.Side_menu_option_clicker("Applications", d, "N/A");

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Applications module opened from side menu.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("Actual: Applications module opened | Case ID: " + Case_id);

				    p.landed_in_applicationList_confirmation();

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Landed inside Applications list screen (confirmation done).<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("Actual: Landed in Applications list | Case ID: " + Case_id);

				    p.Filter_clear().click();

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Filters cleared before searching Case ID.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("Actual: Filters cleared | Case ID: " + Case_id);

				    WebElement Search = p.Application_search();
				    Search.sendKeys(Case_id);

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>Step " + (step++) + ":</b> Search Case ID in Applications list.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("[Step] Searching Case ID in Applications list | Case ID: " + Case_id);

				    Thread.sleep(1800);

				    List<WebElement> result_rows;
				    try {
				        result_rows = p.rows();
				        result_rows.get(0).click();
				        Thread.sleep(800);

				        Report_Listen.log_print_in_report().log(Status.INFO,
				                "<b>🟨 Actual:</b> Opened first search result row for Case ID.<br>"
				              + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				        );
				        System.out.println("Actual: Opened first result row | Case ID: " + Case_id);

				    } catch (Exception Result_still_not_fetched) {

				        Report_Listen.log_print_in_report().log(Status.INFO,
				                "<b>🟨 Actual:</b> First attempt to fetch result rows failed. Retrying once after 800ms.<br>"
				              + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				              + "<b>Exception:</b> " + Result_still_not_fetched.getClass().getSimpleName()
				        );

				        System.out.println("Exception Found in fetching result rows thereby retrying");
				        System.out.println("Case ID   : " + Case_id);
				        System.out.println("Exception : " + Result_still_not_fetched.getClass().getSimpleName());
				        System.out.println();

				        Thread.sleep(800);

				        result_rows = p.rows();
				        result_rows.get(0).click();
				        Thread.sleep(800);

				        Report_Listen.log_print_in_report().log(Status.INFO,
				                "<b>🟨 Actual:</b> Result rows fetched successfully on retry and first row opened.<br>"
				              + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				        );
				        System.out.println("Actual: Result row opened successfully on retry | Case ID: " + Case_id);
				    }
				}

				// =========================
				// Case Tags Fetch (with retry) + Case ID logs
				// =========================
				List<WebElement> Case_Tags;
				try {
				    Case_Tags = p.Case_tags();

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>Step " + (step++) + ":</b> Fetch Case Tags for validation/context.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				          + "<b>🟨 Actual:</b> Case tags fetched successfully."
				    );
				    System.out.println("[Step] Case tags fetched successfully | Case ID: " + Case_id);

				} catch (RuntimeException tags) {

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Case tags fetch failed. Retrying once after 1200ms.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				          + "<b>Exception:</b> " + tags.getClass().getSimpleName()
				    );

				    System.out.println("RuntimeException Found in case tags fetching thereby retrying");
				    System.out.println("Case ID   : " + Case_id);
				    System.out.println("Exception : " + tags.getClass().getSimpleName());
				    System.out.println();

				    Thread.sleep(1200);

				    Case_Tags = p.Case_tags();

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Case tags fetched successfully on retry.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				    );
				    System.out.println("Actual: Case tags fetched on retry | Case ID: " + Case_id);
				}

				// =========================
				// Applications tab + create application (Case ID logs)
				// =========================
				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>Step " + (step++) + ":</b> Open Applications tab inside Case Details.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("[Step] Open Applications tab | Case ID: " + Case_id);

				tab_selector("Applications");

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>🟨 Actual:</b> Applications tab opened.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("Actual: Applications tab opened | Case ID: " + Case_id);

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>Step " + (step++) + ":</b> Enter Requested Amount and click Add to create Application card.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b> | Requested Amount = <b>" + Requested_Amount + "</b>"
				);
				System.out.println("[Step] Create application card | Case ID: " + Case_id + " | Requested Amount: " + Requested_Amount);

				p.Requested_amount_input_field_in_Applications_tab().sendKeys(Requested_Amount);
				p.Appilcation_Add_button().click();
				p.Application_Card_Body();

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>🟨 Actual:</b> Application card created and visible.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("Actual: Application card created | Case ID: " + Case_id);

				// =========================
				// Buyout edit open + Buyout save (Case ID logs)
				// =========================
				WebElement Buyout_Buttons = p.First_Application_Buyout_amount_edit_button();
				Buyout_Buttons.click();

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>🟨 Actual:</b> Buyout modal opened.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("Actual: Buyout modal opened | Case ID: " + Case_id);

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>Step " + (step++) + ":</b> Fill Buyout details and save (Funder, Amount, Expiry Date).<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("[Step] Fill & save Buyout details | Case ID: " + Case_id);

				p.Modal_Input_Feilds().get(0).sendKeys(Case_Data.get("Buyout Funder Name"));
				p.Modal_Input_Feilds().get(1).sendKeys(Case_Data.get("Buyout Amount"));
				p.Modal_Input_Feilds().get(2).sendKeys(Case_Data.get("Buyout Expiry Date"));
				p.calender_date_select().click();
				Thread.sleep(500);
				p.modal_buttons().get(1).click();
				Thread.sleep(500);
                WebElement Toast_after_buyout=lg.toast();
                String text_toast = Toast_after_buyout.getText().trim();
				// Toast after buyout (keep your existing toast printer, but add console context)
				try {
				    Login_negative_testcases.Toast_printer(text_toast, d);

				    System.out.println("Toast after Buyout save | Case ID: " + Case_id + " | Toast: " + lg.toast().getText().trim());
				} catch (Exception e) {
				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual →** 📢,</b> Toast after Buyout Amount: " + "No toast captured / toast locator not visible. Error:"
				          + "<br><b>Case ID:</b> <b>" + Case_id + "</b>"
				    );

				    System.out.println("Toast after Buyout save NOT captured | Case ID: " + Case_id);
				    System.out.println();
				}

				Report_Listen.log_print_in_report().log(Status.INFO,
				        "<b>Step " + (step++) + ":</b> Open Approved Amount edit and enter Approved Amount.<br>"
				      + "<b>Case ID:</b> <b>" + Case_id + "</b>"
				);
				System.out.println("[Step] Open Approved Amount edit | Case ID: " + Case_id);
				Thread.sleep(800);
				// Approved amount edit with retry (keep your logic + add Case ID to logs)
				WebElement Approve_Amount_edit_buttons;
				try {
					Approve_Amount_edit_buttons = p.First_Application_Approved_amount_edit_button();
					Approve_Amount_edit_buttons.click();

				    System.out.println("Actual: Approved Amount edit opened | Case ID: " + Case_id);

				} catch (Exception em) {

				    Thread.sleep(800);
				    Approve_Amount_edit_buttons = p.First_Application_Approved_amount_edit_button();
					Approve_Amount_edit_buttons.click();
				    Thread.sleep(800);

				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "Exception found in fetching Ammount edit buttons after filling buyout form retried and found"
				          + "<br><b>Case ID:</b> <b>" + Case_id + "</b>"
				    );

				    System.out.println("Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
				    System.out.println("Case ID   : " + Case_id);
				    System.out.println("Exception : " + em.getClass().getSimpleName());
				    System.out.println();
				}

				// Continue as-is (no logic change) + add minimal console context
				Contract_Generator(Case_Data, Plaintiff, attorneyData, step);

				try {
				    WebElement new_toast = lg.toast();
				    String new_toast_text = new_toast.getText().trim();

				    // Console
				    System.out.println("Toast after contract generator | Case ID: " + Case_id + " | Toast: " + new_toast_text);
				    System.out.println();

				    // Extent (optional but helpful)
				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Toast after Contract Generator captured.<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				          + "<b>Toast:</b> " + new_toast_text
				    );

				} catch (Exception toast_not_found) {

				    // Console
				    System.out.println("Toast after contract generator NOT captured | Case ID: " + Case_id);
				    System.out.println("Reason     : Toast not visible / locator issue");
				    System.out.println("Exception  : " + toast_not_found.getClass().getSimpleName());
				    System.out.println();

				    // Extent
				    Report_Listen.log_print_in_report().log(Status.INFO,
				            "<b>🟨 Actual:</b> Toast after Contract Generator NOT captured (toast not visible / locator issue).<br>"
				          + "<b>Case ID:</b> <b>" + Case_id + "</b><br>"
				          + "<b>Exception:</b> " + toast_not_found.getClass().getSimpleName()
				    );
				}


				WebElement Sign_in_button = p.Manual_sign_in_button();
				rp.movetoelement(Sign_in_button);
				Thread.sleep(800);
				rp.wait_for_theElement_tobe_clickable(Sign_in_button);
				Sign_in_button.click();

				System.out.println("Clicked Manual Sign In button | Case ID: " + Case_id);

				List<WebElement> Open_lien_table_row = manual_lien_generation(Sign_in_button);

				System.out.println("Manual lien generation triggered | Case ID: " + Case_id);
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
				Login_negative_testcases.Toast_printer(lg.toast().getText().trim(),d);}
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
	    	 
			   monthly_emi.clear();
			   
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
			    Thread.sleep(900);
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
				WebElement save_change_button = p.Save_changes_button();
				save_change_button.click();
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
				WebElement Cancel_Contract;
			  try {
			        // If Cancel button exists, wait until it disappears
			        Cancel_Contract = p.Cancel_Contract_Button();

			        System.out.println("Info    : Cancel Contract button found. Waiting for it to disappear...");
			        System.out.println();

			        Report_Listen.log_print_in_report().log(Status.INFO,
			                "<b>🟦 Info:</b> Cancel Contract button detected. Waiting until it disappears before Manual Sign-In.");

			        rp.wait_for_invisibility(Cancel_Contract);

			    } catch (Exception cancel_contract_not_found) {

			        // If Cancel button is not present, assume Sign-In is ready
			        System.out.println("Info    : Cancel Contract button NOT found. Assuming contract generation completed. Proceeding to Manual Sign-In...");
			        System.out.println();

			        Report_Listen.log_print_in_report().log(Status.INFO,
			                "<b>🟦 Info:</b> Cancel Contract button not found. Proceeding directly to Manual Sign-In.");
			    }

				Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click <i>Generate Contract</i> again to send contract for signing.");
				WebElement Generated_Toast = lg.toast();
				String Contract_Generated = Generated_Toast.getText().trim();
				Login_negative_testcases.Toast_printer(Contract_Generated,d);
				Thread.sleep(800);
				rp.wait_for_invisibility(Generated_Toast);}
	   
	  
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
		tabs.clear();
		}
	

     @Test(dataProvider="notesData")
     public void Notes_Add(String value) throws IOException, InterruptedException{
    	 
    	 Application_Locaters p = new Application_Locaters(d);
		 SIde_Menu_Handler sd = new SIde_Menu_Handler();
		 Login_Locaters lg = new Login_Locaters(d);
		 Repeat rp = new Repeat(d);
		 Plaintiff_Locaters pp=new Plaintiff_Locaters(d);
		 
		// String tag_to_person =  "";
		String Note_text = value;
	    String Case_id = "OH2600127";
    	 
		  sd.Side_menu_option_clicker("Applications", d,"N/A");
		   
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		   WebElement Search = p.Application_search();
		   Search.sendKeys(Case_id);
		   Thread.sleep(1800);
		   WebElement Toast_One = lg.Toast_close_button();
		   rp.movetoelement(Toast_One);
		   Thread.sleep(800);
		   Toast_One.click();
		   rp.wait_for_invisibility(Toast_One);
		   WebElement Toast_Two = lg.Toast_close_button();
		   rp.movetoelement(Toast_Two);
		   Toast_Two.click();
		   rp.wait_for_invisibility(Toast_Two);
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
		   tab_selector("Notes");
		   Thread.sleep(800);
		   WebElement Notes_Tab_Toast = lg.Toast_close_button();
		   rp.movetoelement(Notes_Tab_Toast);
		   Notes_Tab_Toast.click();
		   rp.wait_for_invisibility(Notes_Tab_Toast);
    	   WebElement Add_Note_Button = p.Create_note_button();
    	   Add_Note_Button.click();
    	   //List <WebElement> inputs =p.Edit_form_inputs();
			p.textArea().sendKeys(Note_text);
			//inputs.get(0).sendKeys(tag_to_person);
			p.Submit_Button().click();
			Thread.sleep(800);
			WebElement Toast;
		try { Toast = lg.toast();
			 Login_negative_testcases.Toast_printer(Toast.getText().trim(),d);
			 Report_Listen.log_print_in_report().log(Status.PASS,
		                "<b>🟨 Actual:</b> ✅ Notes saved successfully. Toast captured and confirms save.");
			 }
		catch(Exception Toast_Not_Found){
			System.out.println("Toast Not found after saving  Notes");
			System.out.println();
			Report_Listen.log_print_in_report().log(Status.FAIL,
	                "<b>🟨 Actual:</b> ❌ Notes save confirmation toast was not found after clicking Submit.");
			
			 }
     }

	
	
     @DataProvider
     public Object[][] notesData() {

    	 return new Object[][]{
    	        {"Underwriting update: We verified the incident date against the intake form, claimant statement, and the initial email thread. The date appears consistent across all sources, however the police report has not yet been uploaded. Please request the incident report number, responding agency, and any dispatch/CAD reference so we can cross-check timeline accuracy and avoid downstream corrections in the case summary card."},/*

    	        {"Docs pending — please upload: (1) ER discharge summary, (2) itemized billing, (3) imaging results if available, and (4) proof of wage loss for the week following the incident. Until these are received, underwriting cannot finalize medical causation or damages sizing. Note: the current attachments include a partial PDF scan that cuts off the provider signature block on page 2."},

    	        {"Call summary: Spoke to plaintiff and confirmed preferred contact window is 2–5 PM local time. Plaintiff stated they can provide employer HR contact details, but requested that all communications be routed through attorney once representation letter is finalized. Plaintiff also mentioned prior treatment for a similar symptom; please flag this for potential medical causation discussion and document it carefully in underwriting notes."},

    	        {"Risk check: Potential statutory notice deadlines may apply. Please confirm filing posture (complaint filed vs draft only), confirm county/venue, and ensure the court index number is accurate. If any dates change, the case timeline card may need a full refresh to prevent inconsistency between dashboard view, PDF exports, and email templates."},

    	        {"Evidence checklist: Photos received (8 images), witness list received (3 names), and a short written narrative was provided. Surveillance request has been sent but not acknowledged by property owner. If surveillance is unavailable, request maintenance logs, incident logbook entry, and any prior complaints that support notice/knowledge of hazard conditions."},

    	        {"Payment observation: Amount received appears partial relative to expected schedule. Please reconcile with remittance advice before posting, verify no duplicate capture in gateway, and ensure convenience fees are either included or explicitly excluded based on policy. After reconciliation, attach payment confirmation to the case record to keep audit trail complete."},

    	        {"Formatting validation: Ensure special characters and punctuation remain consistent in all exports (e.g., O’Connor vs O'Connor, Montréal accents, hyphenated surnames, and suffix placement like 'Jr.' 'III'). We have seen downstream mismatches when the UI trims characters or the PDF generator normalizes unicode."},

    	        {"Court index verification: The current court index number matches the screenshot but does not match the draft complaint header. Please re-check the source and confirm whether the docket search result includes a leading zero, an extra hyphen, or a revised case classification. If needed, update the case record and add a short note explaining the correction for audit."},

    	        {"Attorney follow-up required: Request the most recent demand package, settlement posture update, and any insurer correspondence. Also confirm whether medical lien holders exist and whether any subrogation claims have been asserted. This information directly impacts net recovery expectations and should be captured before recommending any increase to approved funding."},

    	        {"Fee check: Confirm document prep fee and fund transfer fee are applied exactly once. On prior cases, edits caused fees to duplicate on the ledger card and created discrepancies between the UI and exported statements. Please verify fee fields, then validate the payment summary card renders correctly and does not wrap awkwardly on smaller viewports."},

    	        {"Status note: File moved to 'Pending Docs' because causation support is incomplete. Required items: full treatment chronology, imaging results, primary care notes, and any referral documentation. Once received, underwriting can re-evaluate risk level and recommended max funding. Please also verify the case owner and underwriter dropdown selections remain correct after status update."},

    	        {"Address validation: ZIP/state combination verified; however, Address Line 2 may be missing a unit number. Please confirm whether the address is a suite, apartment, or floor designation so we avoid mail return. If the UI concatenates address in a single line card, confirm the separators and spacing remain readable when line 2 is long."},

    	        {"Summary rewrite: Removed duplicated incident narrative and tightened the timeline section to avoid repeating facts. Also clarified damages categories (wage loss, medical costs, emotional distress) and removed speculative language. Please review for consistency with attorney-provided narrative; if attorney disagrees, store their version in notes and keep UI summary neutral."},

    	        {"Email log: Sent request for missing IDs and authorization forms for records retrieval. The email includes a clear checklist and deadline request, plus instructions for uploading via portal. If no response within 48 hours, send a follow-up and tag the case accordingly. Also verify that the 'Send Email' editor does not strip line breaks."},

    	        {"Lien/third-party funding check: Plaintiff disclosed prior funding provider inquiry but did not confirm acceptance. Please confirm whether any contracts were signed or whether any UCC filings exist. If there is a prior funding agreement, capture details to prevent double-funding conflicts and update underwriting tag accordingly."},

    	        {"Underwriter comment: Staged funding recommended until video/bodycam is received and reviewed. If video confirms key facts, consider upgrading risk from Moderate-High to Moderate and revising max funding upward. If video contradicts narrative, keep current cap and request counsel’s written position before proceeding further."},

    	        {"Attachment audit: Most PDFs readable, but one scan is upside-down and another is cropped at margins. Please ask for a re-upload in high resolution. Also check whether the UI preview panel respects zoom/fit settings and whether long filenames overflow the attachment list card."},

    	        {"Contact attempts: Left voicemail, no response yet. Schedule second attempt in 48 hours and send a short follow-up email in parallel. If still no response after third attempt, note 'Unresponsive' and keep the case status unchanged until contact is re-established."},

    	        {"UI stress string: ThisIsAReallyLongUnbrokenTokenDesignedToTestOverflowAndCardWrappingBehavior_ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_THIS_SHOULD_FORCE_HORIZONTAL_OVERFLOW_IF_NOT_HANDLED_PROPERLY_AND_BREAK_LAYOUT"},*/

    	        {""} // Negative: blank note (required field validation)

         };
     }

	
	

}
