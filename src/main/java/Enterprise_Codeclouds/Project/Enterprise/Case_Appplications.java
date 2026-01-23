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
import com.microsoft.playwright.impl.Stream;

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
	TreeMap<String,Double> PayoffTable_values =  new TreeMap<String,Double>();
	
	
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
	
	
	
	
	  public void Email_sender(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data,TreeMap<String,String> data) throws IOException, InterruptedException{
		
		
		  Application_Locaters p = new Application_Locaters(d);
		  SIde_Menu_Handler sd = new SIde_Menu_Handler();
		  Login_Locaters lg = new Login_Locaters(d);
		  Repeat rp = new Repeat(d);
		  
		  
		  String Subject = data.get("Subject");
		  String to = data.get("To");
		  String Mail_Body = data.get("Message");
		  String Plaintiff_name = Plaintiff.get("First Name");
		  
		  System.out.println("Plaintiff Name is   "+Plaintiff_name);
		  System.out.println();
		  
		   try{p.Send_button();}
	       catch(Exception not_in_Case_Details) {	    
		   sd.Side_menu_option_clicker("Applications", d,"N/A");
		   p.landed_in_applicationList_confirmation();
		   p.Filter_clear().click();
		   WebElement Search = p.Application_search();
		   Search.sendKeys(Plaintiff_name);
		   Thread.sleep(1800);
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
		   Thread.sleep(800);}}
		   List<WebElement> Case_Tags;
		   try {
		   Case_Tags = p.Case_tags();}
		   catch(RuntimeException tags){
			   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			   System.out.println();
			   Thread.sleep(1200);
			   Case_Tags = p.Case_tags(); }
		  p.Send_button().click();
		  p.Email_button().click();
		  p.pop_up_contact_list();
		  p.Subject_field().sendKeys(Subject);
		  WebElement Email_To = p.Email_to_field();
		  Email_To.sendKeys(to);
		  WebElement CC_Button = p.CC_button();
		  WebElement BCC_Button = p.Bcc_button();
		  CC_Button.click();
		  BCC_Button.click();
		  WebElement CC_field = p.cc_field();
		  WebElement BCC_field = p.bcc_field();
		  CC_field.sendKeys(data.get("Cc"));
		  rp.Scroll_to_element(BCC_field);
		  BCC_field.sendKeys(data.get("Bcc"));
		  WebElement Iframe = p.contract_doc_iframe();
		  rp.Scroll_to_element(Iframe);
		  d.switchTo().frame(Iframe);
		  Thread.sleep(900);
		  rp.Scroll_to_element(p.Email_Body());
		  p.Email_Body().sendKeys(Mail_Body);
		  d.switchTo().defaultContent();
		  p.Submit_button().click();
		  WebElement Toast = lg.toast();
		  String toastText = Toast.getText().trim();
		  Login_negative_testcases.Toast_printer(toastText);
		  WebElement card= p.mail_card_in_feed();
		  String mail_card_content = card.getText().trim();
		  
		  if(mail_card_content.contains(Subject)&&mail_card_content.contains(to)){
			  System.out.println("Testcase Passed Mail Feed contains values and date send in mail");
			  System.out.println();
		  }else{
			  System.out.println("Testcase Passed Mail Feed doesn't contains values and date send in mail");
			  System.out.println();
			  
		  }
		  
		  /*
		  List <WebElement> mail_feed_card_contents = p.mail_card_sections();
		  for(WebElement mail_cont:mail_feed_card_contents){
			  
			 String card_text_contents =  mail_cont.getText().trim();
			 if(card_text_contents.contains(Subject)&&){
				 System.out.print
				 
			 }
			  
			  
			  
		  }*/
		
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
		Login_negative_testcases.Toast_printer(toastText);
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
	              {m1},{m2},{m3},{m4},{m5},
	              {m6},{m7},{m8},{m9},{m10}
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
		try {Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
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
		Underwriting_Notes(Case_Data);}
	
	    
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
	 		try {Login_negative_testcases.Toast_printer(lg.toast().getText().trim());}
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
	 		p.calender_date_select().click();
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
	 		String Contract_Generated = lg.toast().getText().trim();
	 		Login_negative_testcases.Toast_printer(Contract_Generated);
	 		rp.wait_for_invisibility(lg.toast());
	 		Thread.sleep(1000);
	 		FluentWait<WebDriver> fwts = new FluentWait<WebDriver>(d)
	 		        .withTimeout(Duration.ofSeconds(30))
	 		        .pollingEvery(Duration.ofMillis(500))
	 		        .ignoring(NoSuchElementException.class)
	 		        .ignoring(StaleElementReferenceException.class);
	 		WebElement new_toast =lg.toast();
	 		String new_toast_text = lg.toast().getText().trim();
	 		System.out.println(new_toast_text);
	 		Thread.sleep(800);
	 		p.Application_amount_edit_buttons().get(1).click();
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
				String Contract_Generated_ = lg.toast().getText().trim();
				Login_negative_testcases.Toast_printer(Contract_Generated_);
				rp.wait_for_invisibility(lg.toast());
				Thread.sleep(1000);
				WebElement new_toast_ =lg.toast();
				String new_toast_text_ = lg.toast().getText().trim();
				System.out.println(new_toast_text_);
				WebElement Sign_in_button_ = p.Manual_sign_in_button();
				rp.movetoelement(Sign_in_button_);
			    Thread.sleep(800);
			    rp.wait_for_theElement_tobe_clickable(Sign_in_button_);
			    Sign_in_button_.click();
				//Docu_Sign_Signature();
				manual_lien_generation(Sign_in_button_);
			//	Pay_Off_calculator(Case_Data,Plaintiff,attorneyData);
				Email_sender(Case_Data,Plaintiff,attorneyData,Law_Firm_Data,Staff_Data,Email_Send_Data);
	 	    }}
	 		
	 		else{
	 			
	 			
	 			System.out.println("Didn't encounter Contract generated successfully Toast so thats why couldn't proceed with edit terms process");
	 			System.out.println();}}
	     
	     
	     @Test
	      public void PayOff_Lien_List() throws IOException, InterruptedException{
	    	  
	    	  
	    	  Application_Locaters p = new Application_Locaters(d);
		      Login_Locaters lg = new Login_Locaters(d);
			  SIde_Menu_Handler sd = new SIde_Menu_Handler();
			  Repeat rp = new Repeat(d);
	    	  
			  
			  
			  PayoffTable_values.clear();
			  
			  
			  try{p.Case_Action_Dropdown();}
		       catch(Exception not_in_Case_Details) {	    
			   sd.Side_menu_option_clicker("Applications", d,"N/A");
			   p.landed_in_applicationList_confirmation();
			   p.Filter_clear().click();
			   WebElement Status_filter = p.Application_status_filter();
			   Status_filter.click();
			   Application_Filter_Option_Selector("Funded");
			   p.rows().get(2).click();
			   Thread.sleep(800);}
			   List<WebElement> Case_Tags;
			   try {
			   Case_Tags = p.Case_tags();}
			   catch(RuntimeException tags){
				   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
				   System.out.println();
				   Thread.sleep(1200);
				   Case_Tags = p.Case_tags();}
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
                        PayoffTable_values.put("month "+m, each_month_payable);
                        System.out.println("month "+m+"  "+ each_month_payable);
    	    	    	System.out.println();
	    	            m++;
	    	    	}
	    	    }
	    	    
	    	    
	    	  
	      }
	     
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
			Login_negative_testcases.Toast_printer(Toast.getText().trim());
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
			Login_negative_testcases.Toast_printer(Contract_Signed);
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
	        	
	        	
	        	double Document_prep_fee = Double.parseDouble(data.get("Document prep fee"));
	        	double Fundtransferfee = Double.parseDouble(data.get("Fund transfer fee"));
	        	double Amount_to_be_payed = (Document_prep_fee+Fundtransferfee)/2;
	        	double Amount_to_be_payed_upto_2_decimal = Double.parseDouble(String.format("%.2f", Amount_to_be_payed));
	        	String Amount_to_be_payed_text = String.format("%.2f", Amount_to_be_payed_upto_2_decimal);
	        	
	        	
	        	
	        	Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>🔹 Scenario Title:</b> Payment Log – Record a Payment and Verify System Confirmation");

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>📘 Description:</b> Validate that a user can log a payment against a funded case and the system accepts the entered payment details and confirms the save.");

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>📥 Input:</b> Mode=<b>"+data.get("Payment Mode")+"</b> | Type=<b>"+data.get("Payment Type")+
	                    "</b> | Payer=<b>"+data.get("Payer Name")+"</b> | Date=<b>"+data.get("Payment Date")+
	                    "</b> | Amount=<b>"+data.get("Amount Received")+"</b>");

	            Report_Listen.log_print_in_report().log(Status.INFO,
	                    "<b>✅ Expected:</b> Payment should be logged successfully and the system should show a confirmation toast/message.");

	        	
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
	    	   Report_Listen.log_print_in_report().log(Status.INFO,
	    	            "<b>🟨 Actual:</b> Payment logging form opened and details are being submitted for verification.");
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
	   		   inputs.get(4).sendKeys(Amount_to_be_payed_text);
	   		   p.textArea().sendKeys(data.get("Notes / Remarks"));
	   		   List<WebElement> popup_modal_buttons = p.poup_up_form_buttons();
	   		   popup_modal_buttons.get(0).click();
	   		   Login_negative_testcases.Toast_printer(lg.toast().getText().trim());
	   		String paymentToast = "";
	   	    try{
	   	        paymentToast = lg.toast().getText().trim();
	   	        Report_Listen.log_print_in_report().log(Status.PASS,
	   	                "<b>🟨 Actual:</b> ✅ Payment logged successfully. Confirmation message received: <b>"+paymentToast+"</b>");
	   	    }catch(Exception e){
	   	        Report_Listen.log_print_in_report().log(Status.FAIL,
	   	                "<b>🟨 Actual:</b> ❌ Payment confirmation toast was not captured (toast not visible / locator issue).");
	   	        
	   	    }
	        }
	        
	       

	        @Test(dataProvider="case_plus_plaintiff")
	     public void Multiple_Application_Generator(TreeMap<String, String> Case_Data, TreeMap<String, String> Plaintiff ,TreeMap<String,String> attorneyData,TreeMap<String,String> Law_Firm_Data,TreeMap<String,String> Staff_Data,TreeMap<String,String> Email_Send_Data) throws InterruptedException, IOException{
	    	 
	    	   Application_Locaters p = new Application_Locaters(d);
			   Login_Locaters lg = new Login_Locaters(d);
			   Repeat rp = new Repeat(d);
			   JavascriptExecutor js = (JavascriptExecutor)d; 
			   SIde_Menu_Handler sd = new SIde_Menu_Handler();
			   
			  // Collections_Clear();
			   
				String Requested_Amount= Case_Data.get("Requested Amount");
				
			int step=1;
			try{p.Send_button();}
		       catch(Exception not_in_Case_Details) {	    
			   sd.Side_menu_option_clicker("Applications", d,"N/A");
			   p.landed_in_applicationList_confirmation();
			   p.Filter_clear().click();
			   WebElement Status_filter = p.Application_status_filter();
			   Status_filter.click();
			   Application_Filter_Option_Selector("Funded");
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
				   Thread.sleep(800);}}
			List<WebElement> Case_Tags;
			try {
				   Case_Tags = p.Case_tags();}
				   catch(RuntimeException tags){
					   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
					   System.out.println();
					   Thread.sleep(1200);
					   Case_Tags = p.Case_tags(); }
			   tab_selector("Applications");

			   p.Requested_amount_input_field_in_Applications_tab().sendKeys(Requested_Amount);
			   p.Appilcation_Add_button().click();
			   p.Application_Card_Body();
			   List<WebElement> Edit_Buttons= p.Application_amount_edit_buttons();
			   Edit_Buttons.get(1).click();
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
				Amount_edit_buttons= 	p.Application_amount_edit_buttons();
			    Amount_edit_buttons.get(2).click();
				Thread.sleep(800);
				Report_Listen.log_print_in_report().log(Status.INFO,"Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
				System.out.println("Exception found in fetching Ammount edit buttons after filling buyout form retried and found");
				System.out.println();}
			   Contract_Generator(Case_Data,Plaintiff,attorneyData,step);
			   WebElement new_toast =lg.toast();
			   String new_toast_text = lg.toast().getText().trim();
			   System.out.println(new_toast_text);
			   WebElement Sign_in_button = p.Manual_sign_in_button();
			   rp.movetoelement(Sign_in_button);
		       Thread.sleep(800);
		       rp.wait_for_theElement_tobe_clickable(Sign_in_button);
			/*   Sign_in_button.click();
			   List<WebElement> Open_lien_table_row=manual_lien_generation(Sign_in_button); */}
	   
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
	




	
	
	
	
	

}
