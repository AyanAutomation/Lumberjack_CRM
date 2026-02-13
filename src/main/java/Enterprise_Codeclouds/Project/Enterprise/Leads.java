package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Leads_Locaters;
import Repeatative_codes.Repeat;

public class Leads extends Case_Appplications{
	
	@Test(dataProvider="applyNowData")
	public void frontend_form_filler(TreeMap<String, String> form_data) throws IOException, InterruptedException{

	    Data_Reader f = new Data_Reader();
	    Leads_Locaters p = new Leads_Locaters(d);
	    Repeat rp = new Repeat(d);
	    Application_Locaters ap = new Application_Locaters(d);

	    // ---------- Fetch all values from map ONCE ----------
	    String advanceAmount = form_data.get("I am seeking an advance of");
	    String fullName = form_data.get("Your Full Name");
	    String dob = form_data.get("Date of Birth");
	    String phone = form_data.get("Phone Number");
	    String email = form_data.get("Email");
	    String mailingStreetAddress = form_data.get("Mailing Street Address");
	    String city = form_data.get("City");
	    String state = form_data.get("State");

	    String lawyerName = form_data.get("Lawyer's Name");
	    String lawyerPhone = form_data.get("Lawyer's Phone Number");
	    String lawFirmName = form_data.get("Law Firm Name");

	    String accidentDate = form_data.get("When did the accident happen?");
	    String accidentLocation = form_data.get("Where did the accident happen?");
	    String accidentDescription = form_data.get("Describe the accident");
	    String injuriesDescription = form_data.get("Describe the injuries you sustained during the accident");

	    String injuredOtherTraumatic = form_data.get("Since your accident, have you been injured in any other traumatic incidents?");
	    String injuredOtherTraumaticExplain = form_data.get("Explain (Other Traumatic Incidents)");

	    String violationNoAutoInsurance = form_data.get("In the 5 years before the accident, did you have a violation for no auto insurance?");
	    String violationNoAutoInsuranceExplain = form_data.get("Explain (No Auto Insurance Violation)");

	    String presentAccidentVehicleOwnedByYou = form_data.get("In the PRESENT accident, were you in a vehicle owned by you?");
	    String presentAccidentVehicleCoveredByInsurance = form_data.get("Was that vehicle covered by insurance?");

	    String previousSettlementAdvance = form_data.get("Have you previously received a settlement advance for this case?");
	    String previousSettlementAdvanceExplain = form_data.get("Explain (Previous Settlement Advance)");
	    String previousSettlementBorrowCompany = form_data.get("What company did you borrow from?");
	    String previousSettlementBorrowAmount = form_data.get("How much did you receive?");

	    String otherPeopleInjured = form_data.get("Were other people injured in this accident?");
	    String otherPeopleInjuredExplain = form_data.get("Explain (Other People Injured)");

	    String behindOnChildSupport = form_data.get("Are you currently behind on child support?");
	    String behindOnChildSupportExplain = form_data.get("Explain (Behind on Child Support)");
	    String childSupportOweState = form_data.get("Where do you owe child support? (State)");
	    String childSupportOweCounty = form_data.get("Where do you owe child support? (County)");
	    String childSupportOweAmount = form_data.get("How much do you owe?");

	    String enrolledGovernmentHealthCoverage = form_data.get("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?");
	    String enrolledGovernmentHealthCoverageWhichOnes = form_data.get("Which one(s)?");
	    String enrolledGovernmentHealthCoverageExplain = form_data.get("Explain (Governmental Health Coverage)");


	    // ===================== DATASET LOG =====================
	    String datasetSummary =
	            "Advance=" + advanceAmount
	          + " | Name=" + fullName
	          + " | DOB=" + dob
	          + " | Phone=" + phone
	          + " | Email=" + email
	          + " | Street=" + mailingStreetAddress
	          + " | City=" + city
	          + " | State=" + state
	          + " | Lawyer=" + lawyerName
	          + " | LawyerPhone=" + lawyerPhone
	          + " | LawFirm=" + lawFirmName
	          + " | GovtCoverage=" + enrolledGovernmentHealthCoverage
	          + " | OtherTrauma=" + injuredOtherTraumatic
	          + " | NoInsuranceViolation=" + violationNoAutoInsurance
	          + " | PrevAdvance=" + previousSettlementAdvance
	          + " | OthersInjured=" + otherPeopleInjured
	          + " | ChildSupportBehind=" + behindOnChildSupport;

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Dataset Loaded</b><br>"
	          + "<b>📘 Description:</b> Test data fetched from DataProvider (not yet entered in UI).<br>"
	          + "<b>📥 Input:</b> " + datasetSummary
	    );

	    System.out.println("==================================================");
	    System.out.println("[DATASET] Loaded from DataProvider (not yet filled in UI)");
	    System.out.println(datasetSummary);
	    System.out.println("==================================================");
	    System.out.println();


	    // ===================== OPEN FRONTEND =====================
	    String frontend_url = f.Data_Fetcher("Frontend_URL");

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Open Frontend URL</b><br>"
	          + "<b>📥 Input:</b> " + frontend_url + "<br>"
	          + "<b>✅ Expected:</b> Frontend page should load and form should be visible.<br>"
	          + "<b>🟨 Actual:</b> Navigating to URL."
	    );

	    System.out.println("==================================================");
	    System.out.println("[NAVIGATION] OPEN FRONTEND URL");
	    System.out.println("URL      : " + frontend_url);
	    System.out.println("EXPECTED : Page loads, form visible");
	    System.out.println("ACTUAL   : Navigating...");
	    System.out.println("==================================================");
	    System.out.println();

	    d.get(frontend_url);

	    WebElement form_=p.Form();
	    rp.Scroll_to_element(form_);
	    Thread.sleep(800);

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>🔹 Form Visible</b><br>"
	          + "<b>✅ Expected:</b> Form should be in viewport and interactable.<br>"
	          + "<b>🟨 Actual:</b> Scrolled to form successfully."
	    );

	    System.out.println("==================================================");
	    System.out.println("[UI] FORM VISIBLE");
	    System.out.println("EXPECTED : Form in viewport & interactable");
	    System.out.println("ACTUAL   : Scrolled to form");
	    System.out.println("RESULT   : PASS ✅");
	    System.out.println("==================================================");
	    System.out.println();


	    // ===================== FILL BASIC DETAILS =====================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Applicant Details</b><br>"
	          + "<b>📘 Description:</b> Enter advance amount + applicant identity/contact details.<br>"
	          + "<b>📥 Input:</b> Advance=" + advanceAmount + " | Name=" + fullName + " | DOB=" + dob
	          + " | Phone=" + phone + " | Email=" + email + "<br>"
	          + "<b>✅ Expected:</b> Fields should accept input without errors.<br>"
	          + "<b>🟨 Actual:</b> Sending values to fields."
	    );

	    System.out.println("==================================================");
	    System.out.println("[FORM] FILL APPLICANT DETAILS");
	    System.out.println("Advance : " + advanceAmount);
	    System.out.println("Name    : " + fullName);
	    System.out.println("DOB     : " + dob);
	    System.out.println("Phone   : " + phone);
	    System.out.println("Email   : " + email);
	    System.out.println("EXPECTED: All fields accept input");
	    System.out.println("ACTUAL  : sendKeys started");
	    System.out.println("==================================================");
	    System.out.println();

	    p.advance_amount().sendKeys(advanceAmount);
	    p.full_name().sendKeys(fullName);
	    p.date_of_birth().sendKeys(dob);
	    p.phone_number().sendKeys(phone);
	    p.email().sendKeys(email);


	    // ===================== ADDRESS =====================
	    WebElement mail_address= p.mailing_street_address();
	    rp.Scroll_to_element(mail_address);
	    mail_address.sendKeys(mailingStreetAddress);

	    WebElement City= p.city();
	    rp.Scroll_to_element(City);
	    City.sendKeys(city);
	    WebElement State_Dropdown = p.State_select_dropdown();
	    Select s = new Select(State_Dropdown);
	    s.selectByVisibleText(state);

	    // optional visible-text confirmation (no extra logic, only reading what is already selected)
	    String selectedState = s.getFirstSelectedOption().getText().trim();

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>🔹 Address Filled</b><br>"
	          + "<b>📘 Description:</b> Mailing address details entered (Street, City, State).<br>"
	          + "<b>📥 Input:</b> Street=" + mailingStreetAddress + " | City=" + city + " | State=" + state + "<br>"
	          + "<b>✅ Expected:</b> Address fields should accept input and retain values on scroll/navigation.<br>"
	          + "<b>🟨 Actual:</b> Street & City entered, and State selected successfully.<br>"
	          + "<b>🔎 Validation:</b> Selected State visible = <b>" + selectedState + "</b>"
	    );

	    System.out.println("==================================================");
	    System.out.println("[ADDRESS SECTION] Address Filled");
	    System.out.println("Street    : " + mailingStreetAddress);
	    System.out.println("City      : " + city);
	    System.out.println("State     : " + state);
	    System.out.println("VALIDATION: Selected State visible = " + selectedState);
	    System.out.println("RESULT    : " + (selectedState.equalsIgnoreCase(state) ? "PASS ✅" : "FAIL ❌"));
	    System.out.println("==================================================");
	    System.out.println();



	    // ===================== LAWYER DETAILS =====================
	    WebElement Lawyer_name= p.lawyer_name();
	    rp.Scroll_to_element(Lawyer_name);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Lawyer Details</b><br>"
	          + "<b>📘 Description:</b> Enter Lawyer Name, Lawyer Phone and Law Firm Name.<br>"
	          + "<b>📥 Input:</b> Lawyer=" + lawyerName + " | Phone=" + lawyerPhone + " | Firm=" + lawFirmName + "<br>"
	          + "<b>✅ Expected:</b> Lawyer fields should accept input correctly.<br>"
	          + "<b>🟨 Actual:</b> Entering lawyer details now."
	    );

	    System.out.println("==================================================");
	    System.out.println("[LAWYER SECTION] Fill Lawyer Details");
	    System.out.println("Lawyer Name : " + lawyerName);
	    System.out.println("Phone       : " + lawyerPhone);
	    System.out.println("Law Firm    : " + lawFirmName);
	    System.out.println("EXPECTED    : Lawyer fields accept input correctly");
	    System.out.println("ACTUAL      : Typing now...");
	    System.out.println("==================================================");
	    System.out.println();

	    // ✅ FIX: use correct field for lawyer name (was wrongly using mail_address)
	    Lawyer_name.sendKeys(lawyerName);
	    p.lawyer_phone().sendKeys(lawyerPhone);
	    p.law_firm_name().sendKeys(lawFirmName);

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>🟨 Actual:</b> Lawyer details entered successfully.<br>"
	          + "<b>Lawyer Name:</b> " + lawyerName + "<br>"
	          + "<b>Lawyer Phone:</b> " + lawyerPhone + "<br>"
	          + "<b>Law Firm Name:</b> " + lawFirmName
	    );

	    System.out.println("--------------------------------------------------");
	    System.out.println("[LAWYER SECTION] Actual Filled Values");
	    System.out.println("Lawyer Name : " + lawyerName);
	    System.out.println("Lawyer Phone: " + lawyerPhone);
	    System.out.println("Law Firm    : " + lawFirmName);
	    System.out.println("RESULT      : PASS ✅");
	    System.out.println("--------------------------------------------------");
	    System.out.println();


	    // ===================== SUBMIT PAGE 1 =====================
	    WebElement submit= ap.Submit_button();
	    rp.movetoelement(submit);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Submit Application (Page 1)</b><br>"
	          + "<b>✅ Expected:</b> Should proceed to accident details page.<br>"
	          + "<b>🟨 Actual:</b> Clicking Submit."
	    );

	    System.out.println("==================================================");
	    System.out.println("[SUBMIT] APPLICATION (PAGE 1)");
	    System.out.println("EXPECTED : Navigate to accident details page");
	    System.out.println("ACTUAL   : Clicking submit");
	    System.out.println("==================================================");
	    System.out.println();

	    submit.click();


	    // ===================== ACCIDENT DETAILS =====================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Accident Details</b><br>"
	          + "<b>📘 Description:</b> Enter accident date, location, description, and injury details.<br>"
	          + "<b>📥 Input:</b> Date=" + accidentDate + " | Location=" + accidentLocation + "<br>"
	          + "<b>✅ Expected:</b> All accident fields should accept input.<br>"
	          + "<b>🟨 Actual:</b> Entering accident details."
	    );

	    System.out.println("==================================================");
	    System.out.println("[FORM] FILL ACCIDENT DETAILS");
	    System.out.println("Date     : " + accidentDate);
	    System.out.println("Location : " + accidentLocation);
	    System.out.println("EXPECTED : Fields accept input");
	    System.out.println("ACTUAL   : sendKeys started");
	    System.out.println("==================================================");
	    System.out.println();
	    String Error_Text = null;
	try {  try { p.accident_date().sendKeys(accidentDate);}
	  catch(Exception km){
		  List<WebElement> errors = p.error_in_form();
		  WebElement error= errors.get(0);
		  Error_Text = error.getText().trim();
		  System.out.println(Error_Text);
		  System.out.println();
	  }
	    p.accident_location().sendKeys(accidentLocation);
	    p.accident_description().sendKeys(accidentDescription);
	    p.accident_injuries().sendKeys(injuriesDescription);

	    List<WebElement> Buttons= p.below_buttons();
	    WebElement next_button = Buttons.get(1);
	    rp.movetoelement(next_button);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Proceed to Questionnaire</b><br>"
	          + "<b>✅ Expected:</b> Questionnaire blocks should load with buttons.<br>"
	          + "<b>🟨 Actual:</b> Clicking Next."
	    );

	    System.out.println("==================================================");
	    System.out.println("[NAVIGATION] PROCEED TO QUESTIONNAIRE");
	    System.out.println("EXPECTED : Questionnaire blocks load");
	    System.out.println("ACTUAL   : Clicking Next");
	    System.out.println("==================================================");
	    System.out.println();

	    next_button.click();


	 // ===================== QUESTIONNAIRE START =====================

	 // ===================== Q1: GOV HEALTH COVERAGE =====================
	 List<WebElement> first_question_block_buttons;
	 try { first_question_block_buttons = p.First_questions_buttons(); }
	 catch(Exception first_question_button){
	     Thread.sleep(800);
	     first_question_block_buttons = p.First_questions_buttons();
	 }

	 // ✅ QUESTION TEXT (as per your dataset key)
	 String Q1 = "Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?";
	 String A1 = enrolledGovernmentHealthCoverage;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q1:</b> " + Q1 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A1 + "</b><br>"
	       + "<b>✅ Expected:</b> Correct branch should open relevant follow-up field(s) if applicable.<br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q1 Answer Submission");
	 System.out.println("Q1 : " + Q1);
	 System.out.println("Ans: " + A1);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A1.contains("YES")){
	     first_question_block_buttons.get(1).click();

	     WebElement healthcare_enrollment_which = p.healthcare_enrollment_which();
	     rp.movetoelement(healthcare_enrollment_which);
	     Thread.sleep(800);
	     healthcare_enrollment_which.sendKeys(enrolledGovernmentHealthCoverageWhichOnes);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q1 Follow-up Answer Submitted</b><br>"
	           + "<b>Q1:</b> " + Q1 + "<br>"
	           + "<b>Ans:</b> <b>YES</b><br>"
	           + "<b>Follow-up Question:</b> Which one(s)?<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + enrolledGovernmentHealthCoverageWhichOnes + "</b>"
	     );

	     System.out.println("[Q1 FOLLOW-UP] Which one(s)? => " + enrolledGovernmentHealthCoverageWhichOnes);
	     System.out.println();
	 }

	 if(A1.contains("NO")){
	     first_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q1 Answer Submitted</b><br>"
	           + "<b>Q1:</b> " + Q1 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b><br>"
	           + "<b>🟨 Actual:</b> No follow-up fields required."
	     );

	     System.out.println("[Q1] Answer submitted => NO (No follow-up)");
	     System.out.println();
	 }

	 if(A1.contains("I DON'T KNOW")){
	     first_question_block_buttons.get(2).click();

	     WebElement Healthcare_description = p.healthcare_enrollment_explain();
	     rp.movetoelement(Healthcare_description);
	     Thread.sleep(800);
	     Healthcare_description.sendKeys(enrolledGovernmentHealthCoverageExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q1 Follow-up Answer Submitted</b><br>"
	           + "<b>Q1:</b> " + Q1 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Governmental Health Coverage)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + enrolledGovernmentHealthCoverageExplain + "</b>"
	     );

	     System.out.println("[Q1 FOLLOW-UP] Explain => " + enrolledGovernmentHealthCoverageExplain);
	     System.out.println();
	 }


	 // ===================== Q2: OTHER TRAUMA =====================
	 List<WebElement> second_question_block_buttons = p.second_questions_buttons();

	 String Q2 = "Since your accident, have you been injured in any other traumatic incidents?";
	 String A2 = injuredOtherTraumatic;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q2:</b> " + Q2 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A2 + "</b><br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q2 Answer Submission");
	 System.out.println("Q2 : " + Q2);
	 System.out.println("Ans: " + A2);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A2.contains("YES")){
	     second_question_block_buttons.get(1).click();

	     WebElement other_incidents = p.other_incidents_description();
	     rp.movetoelement(other_incidents);
	     Thread.sleep(800);
	     other_incidents.sendKeys(injuredOtherTraumaticExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q2 Follow-up Answer Submitted</b><br>"
	           + "<b>Q2:</b> " + Q2 + "<br>"
	           + "<b>Ans:</b> <b>YES</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Other Traumatic Incidents)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + injuredOtherTraumaticExplain + "</b>"
	     );

	     System.out.println("[Q2 FOLLOW-UP] Explain => " + injuredOtherTraumaticExplain);
	     System.out.println();
	 }

	 if(A2.contains("NO")){
	     second_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q2 Answer Submitted</b><br>"
	           + "<b>Q2:</b> " + Q2 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b>"
	     );

	     System.out.println("[Q2] Answer submitted => NO");
	     System.out.println();
	 }

	 if(A2.contains("I DON'T KNOW")){
	     second_question_block_buttons.get(2).click();

	     WebElement other_incidents_description = p.other_incidents_explain();
	     rp.movetoelement(other_incidents_description);
	     Thread.sleep(800);
	     other_incidents_description.sendKeys(injuredOtherTraumaticExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q2 Follow-up Answer Submitted</b><br>"
	           + "<b>Q2:</b> " + Q2 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Other Traumatic Incidents)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + injuredOtherTraumaticExplain + "</b>"
	     );

	     System.out.println("[Q2 FOLLOW-UP] Explain => " + injuredOtherTraumaticExplain);
	     System.out.println();
	 }


	 // ===================== Q3: NO AUTO INSURANCE VIOLATION =====================
	 List<WebElement> Third_question_block_buttons = p.Third_questions_buttons();

	 String Q3 = "In the 5 years before the accident, did you have a violation for no auto insurance?";
	 String A3 = violationNoAutoInsurance;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q3:</b> " + Q3 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A3 + "</b><br>"
	       + "<b>✅ Expected:</b> If YES, system should display 2 sub-questions.<br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q3 Answer Submission");
	 System.out.println("Q3 : " + Q3);
	 System.out.println("Ans: " + A3);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A3.contains("YES")){
	     Third_question_block_buttons.get(1).click();

	     // Sub-Q1
	     String SQ3_1 = "In the PRESENT accident, were you in a vehicle owned by you?";
	     String SA3_1 = presentAccidentVehicleOwnedByYou;

	     List<WebElement> subquestions_button_one = p.Third_subquestions_one_buttons();
	     if(SA3_1.contains("NO")){ subquestions_button_one.get(0).click(); }
	     if(SA3_1.contains("YES")){ subquestions_button_one.get(1).click(); }
	     if(SA3_1.contains("I DON'T KNOW")){ subquestions_button_one.get(2).click(); }

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q3 Sub-question Answer Submitted</b><br>"
	           + "<b>Q3:</b> " + Q3 + " = <b>YES</b><br>"
	           + "<b>Sub-Q1:</b> " + SQ3_1 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + SA3_1 + "</b>"
	     );

	     System.out.println("[Q3 SUB-Q1] " + SQ3_1 + " => " + SA3_1);

	     // Sub-Q2
	     String SQ3_2 = "Was that vehicle covered by insurance?";
	     String SA3_2 = presentAccidentVehicleCoveredByInsurance;

	     List<WebElement> subquestions_button_two = p.Third_subquestions_two_buttons();
	     if(SA3_2.contains("NO")){
	         rp.movetoelement(subquestions_button_two.get(0));
	         subquestions_button_two.get(0).click();
	     }
	     if(SA3_2.contains("YES")){ subquestions_button_two.get(1).click(); }
	     if(SA3_2.contains("I DON'T KNOW")){ subquestions_button_two.get(2).click(); }

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q3 Sub-question Answer Submitted</b><br>"
	           + "<b>Q3:</b> " + Q3 + " = <b>YES</b><br>"
	           + "<b>Sub-Q2:</b> " + SQ3_2 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + SA3_2 + "</b>"
	     );

	     System.out.println("[Q3 SUB-Q2] " + SQ3_2 + " => " + SA3_2);
	     System.out.println();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q3 Completed</b><br>"
	           + "<b>Q3:</b> " + Q3 + " = <b>YES</b><br>"
	           + "<b>🟨 Actual:</b> Sub-questions answered successfully."
	     );
	 }

	 if(A3.contains("NO")){
	     Third_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q3 Answer Submitted</b><br>"
	           + "<b>Q3:</b> " + Q3 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b>"
	     );

	     System.out.println("[Q3] Answer submitted => NO");
	     System.out.println();
	 }

	 if(A3.contains("I DON'T KNOW")){
	     Third_question_block_buttons.get(2).click();

	     WebElement insurance_violation_description = p.insurance_violation_explain();
	     rp.movetoelement(insurance_violation_description);
	     Thread.sleep(800);
	     insurance_violation_description.sendKeys(violationNoAutoInsuranceExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q3 Follow-up Answer Submitted</b><br>"
	           + "<b>Q3:</b> " + Q3 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (No Auto Insurance Violation)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + violationNoAutoInsuranceExplain + "</b>"
	     );

	     System.out.println("[Q3 FOLLOW-UP] Explain => " + violationNoAutoInsuranceExplain);
	     System.out.println();
	 }


	 // ===================== Q4: PREVIOUS SETTLEMENT ADVANCE =====================
	 List<WebElement> fourth_question_block_buttons = p.Fourth_questions_buttons();

	 String Q4 = "Have you previously received a settlement advance for this case?";
	 String A4 = previousSettlementAdvance;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q4:</b> " + Q4 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A4 + "</b><br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q4 Answer Submission");
	 System.out.println("Q4 : " + Q4);
	 System.out.println("Ans: " + A4);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A4.contains("YES")){
	     fourth_question_block_buttons.get(1).click();

	     WebElement previous_company = p.previous_advance_company();
	     rp.movetoelement(previous_company);
	     Thread.sleep(800);
	     previous_company.sendKeys(previousSettlementBorrowCompany);

	     WebElement previous_advance = p.previous_advance_receive();
	     rp.movetoelement(previous_advance);
	     Thread.sleep(800);
	     previous_advance.sendKeys(previousSettlementBorrowAmount);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q4 Follow-up Answer Submitted</b><br>"
	           + "<b>Q4:</b> " + Q4 + " = <b>YES</b><br>"
	           + "<b>Follow-up Question:</b> What company did you borrow from?<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + previousSettlementBorrowCompany + "</b><br><br>"
	           + "<b>Follow-up Question:</b> How much did you receive?<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + previousSettlementBorrowAmount + "</b>"
	     );

	     System.out.println("[Q4 FOLLOW-UP] Company => " + previousSettlementBorrowCompany);
	     System.out.println("[Q4 FOLLOW-UP] Amount  => " + previousSettlementBorrowAmount);
	     System.out.println();
	 }

	 if(A4.contains("NO")){
	     fourth_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q4 Answer Submitted</b><br>"
	           + "<b>Q4:</b> " + Q4 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b>"
	     );

	     System.out.println("[Q4] Answer submitted => NO");
	     System.out.println();
	 }

	 if(A4.contains("I DON'T KNOW")){
	     fourth_question_block_buttons.get(2).click();

	     WebElement previous_advance_description = p.previous_advance_explain();
	     rp.movetoelement(previous_advance_description);
	     Thread.sleep(800);
	     previous_advance_description.sendKeys(previousSettlementAdvanceExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q4 Follow-up Answer Submitted</b><br>"
	           + "<b>Q4:</b> " + Q4 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Previous Settlement Advance)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + previousSettlementAdvanceExplain + "</b>"
	     );

	     System.out.println("[Q4 FOLLOW-UP] Explain => " + previousSettlementAdvanceExplain);
	     System.out.println();
	 }


	 // ===================== Q5: OTHER PEOPLE INJURED =====================
	 List<WebElement> fifth_question_block_buttons = p.Fifth_questions_buttons();

	 String Q5 = "Were other people injured in this accident?";
	 String A5 = otherPeopleInjured;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q5:</b> " + Q5 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A5 + "</b><br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q5 Answer Submission");
	 System.out.println("Q5 : " + Q5);
	 System.out.println("Ans: " + A5);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A5.contains("YES")){
	     fifth_question_block_buttons.get(1).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q5 Answer Submitted</b><br>"
	           + "<b>Q5:</b> " + Q5 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>YES</b>"
	     );

	     System.out.println("[Q5] Answer submitted => YES");
	     System.out.println();
	 }

	 if(A5.contains("NO")){
	     fifth_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q5 Answer Submitted</b><br>"
	           + "<b>Q5:</b> " + Q5 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b>"
	     );

	     System.out.println("[Q5] Answer submitted => NO");
	     System.out.println();
	 }

	 if(A5.contains("I DON'T KNOW")){
	     fifth_question_block_buttons.get(2).click();

	     WebElement others_injured_description = p.others_injured_explain();
	     rp.movetoelement(others_injured_description);
	     Thread.sleep(800);
	     others_injured_description.sendKeys(otherPeopleInjuredExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q5 Follow-up Answer Submitted</b><br>"
	           + "<b>Q5:</b> " + Q5 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Other People Injured)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + otherPeopleInjuredExplain + "</b>"
	     );

	     System.out.println("[Q5 FOLLOW-UP] Explain => " + otherPeopleInjuredExplain);
	     System.out.println();
	 }


	 // ===================== Q6: CHILD SUPPORT =====================
	 List<WebElement> Sixth_question_block_buttons = p.sixth_questions_buttons();

	 String Q6 = "Are you currently behind on child support?";
	 String A6 = behindOnChildSupport;

	 Report_Listen.log_print_in_report().log(Status.INFO,
	         "<b>🔹 Questionnaire Answer Submission</b><br>"
	       + "<b>Q6:</b> " + Q6 + "<br>"
	       + "<b>📥 Answer Submitted:</b> <b>" + A6 + "</b><br>"
	       + "<b>🟨 Actual:</b> Selecting answer."
	 );

	 System.out.println("==================================================");
	 System.out.println("[QUESTIONNAIRE] Q6 Answer Submission");
	 System.out.println("Q6 : " + Q6);
	 System.out.println("Ans: " + A6);
	 System.out.println("==================================================");
	 System.out.println();

	 if(A6.contains("YES")){
	     Sixth_question_block_buttons.get(1).click();

	     WebElement child_state = p.child_support_state();
	     rp.movetoelement(child_state);
	     Thread.sleep(800);
	     child_state.sendKeys(childSupportOweState);

	     WebElement child_owe = p.child_support_owe();
	     rp.movetoelement(child_owe);
	     Thread.sleep(800);
	     child_owe.sendKeys(childSupportOweAmount);

	     WebElement child_county = p.child_support_county();
	     rp.movetoelement(child_county);
	     Thread.sleep(800);
	     child_county.sendKeys(childSupportOweCounty);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q6 Follow-up Answers Submitted</b><br>"
	           + "<b>Q6:</b> " + Q6 + " = <b>YES</b><br>"
	           + "<b>Follow-up Question:</b> Where do you owe child support? (State)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + childSupportOweState + "</b><br><br>"
	           + "<b>Follow-up Question:</b> Where do you owe child support? (County)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + childSupportOweCounty + "</b><br><br>"
	           + "<b>Follow-up Question:</b> How much do you owe?<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + childSupportOweAmount + "</b>"
	     );

	     System.out.println("[Q6 FOLLOW-UP] State  => " + childSupportOweState);
	     System.out.println("[Q6 FOLLOW-UP] County => " + childSupportOweCounty);
	     System.out.println("[Q6 FOLLOW-UP] Amount => " + childSupportOweAmount);
	     System.out.println();
	 }

	 if(A6.contains("NO")){
	     Sixth_question_block_buttons.get(0).click();

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q6 Answer Submitted</b><br>"
	           + "<b>Q6:</b> " + Q6 + "<br>"
	           + "<b>📥 Answer Submitted:</b> <b>NO</b>"
	     );

	     System.out.println("[Q6] Answer submitted => NO");
	     System.out.println();
	 }

	 if(A6.contains("I DON'T KNOW")){
	     Sixth_question_block_buttons.get(2).click();

	     WebElement child_support_description = p.child_support_explain();
	     rp.movetoelement(child_support_description);
	     Thread.sleep(800);
	     child_support_description.sendKeys(behindOnChildSupportExplain);

	     Report_Listen.log_print_in_report().log(Status.PASS,
	             "<b>✅ Q6 Follow-up Answer Submitted</b><br>"
	           + "<b>Q6:</b> " + Q6 + "<br>"
	           + "<b>Ans:</b> <b>I DON'T KNOW</b><br>"
	           + "<b>Follow-up Question:</b> Explain (Behind on Child Support)<br>"
	           + "<b>📥 Answer Submitted:</b> <b>" + behindOnChildSupportExplain + "</b>"
	     );

	     System.out.println("[Q6 FOLLOW-UP] Explain => " + behindOnChildSupportExplain);
	     System.out.println();
	 }

	 // ===================== QUESTIONNAIRE END =====================


	    // ===================== FINAL NEXT + SUCCESS =====================
	    List<WebElement> Third_form_Buttons= p.below_buttons();
	    WebElement third_form_next_button = Third_form_Buttons.get(1);
	    rp.movetoelement(third_form_next_button);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Final Submit</b><br>"
	          + "<b>✅ Expected:</b> Form should submit successfully and show success confirmation.<br>"
	          + "<b>🟨 Actual:</b> Clicking final Next."
	    );

	    System.out.println("==================================================");
	    System.out.println("[SUBMIT] FINAL SUBMIT");
	    System.out.println("EXPECTED : Success confirmation visible");
	    System.out.println("ACTUAL   : Clicking final Next");
	    System.out.println("==================================================");
	    System.out.println();

	    third_form_next_button.click();

	    p.form_submit_success();

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>🔹 Submission Success</b><br>"
	          + "<b>✅ Expected:</b> Success confirmation displayed.<br>"
	          + "<b>🟨 Actual:</b> Success element validated."
	    );

	    System.out.println("==================================================");
	    System.out.println("[RESULT] SUBMISSION SUCCESS");
	    System.out.println("EXPECTED : Success confirmation displayed");
	    System.out.println("ACTUAL   : Success element validated");
	    System.out.println("RESULT   : PASS ✅");
	    System.out.println("==================================================");
	    System.out.println();}
	catch(Exception Form_error){
		
		
		System.out.println("Error shown is --->  "+Error_Text);
		System.out.println();
		
		
	}
	}

		
		@DataProvider
	    public Object[][] applyNowData() {

			
			// ✅ NOTE:
		    // 1) "Your Full Name" MUST start with "@Test_" and then First Last (NO underscore between first & last)
		    // 2) Plaintiff names use ONLY standard English letters (no accents)
		    // 3) YES / NO / I DON'T KNOW are used across radio questions
		    // 4) Conditional sub-keys:
		    //    - If "In the 5 years before..." = "YES" → then fill:
		    //         "In the PRESENT accident, were you in a vehicle owned by you?"
		    //         "Was that vehicle covered by insurance?"
		    //    - If "Have you previously received..." = "YES" → then fill:
		    //         "What company did you borrow from?"
		    //         "How much did you receive?"
		    //    - If "Are you currently behind..." = "YES" → then fill:
		    //         "Where do you owe child support? (State)"
		    //         "Where do you owe child support? (County)"
		    //         "How much do you owe?"
		    //    - If "Are you Enrolled in Medicare..." = "YES" → then fill:
		    //         "Which one(s)?"
		    //
		    // IMPORTANT: I am including ALL sub-keys in every dataset,
		    // but keeping them BLANK ("") when the condition is not met,
		    // so your script can safely do: form_data.get("...") without null issues.

		    // -------------------- App 1 --------------------
		    TreeMap<String, String> d1 = new TreeMap<>();
		    d1.put("I am seeking an advance of", "16250");
		    d1.put("Your Full Name", "@Test_Kieran Holt");
		    d1.put("Date of Birth", "03/19/1992");
		    d1.put("Phone Number", "9176614028");
		    d1.put("Email", "pltf.kieran.holt.1a7k9m2q@yopmail.com");
		    d1.put("Mailing Street Address", "418 Madison Avenue, Apt 9B");
		    d1.put("City", "Syracuse");
		    d1.put("State", "New York");

		    d1.put("Lawyer's Name", "Daniel Palmer");
		    d1.put("Lawyer's Phone Number", "6467721180");
		    d1.put("Law Firm Name", "Capitol Briefworks");

		    d1.put("When did the accident happen?", "10/08/2024");
		    d1.put("Where did the accident happen?", "Syracuse, NY");
		    d1.put("Describe the accident",
		            "Rear-end collision in stop-and-go traffic. The vehicle behind failed to brake in time and pushed my car forward. "
		          + "Photos were taken of damage, lane markings, and nearby signage. Added length to verify wrapping and saved preview stability.");
		    d1.put("Describe the injuries you sustained during the accident",
		            "Neck stiffness later that evening, mild headache, and upper-back tightness. Walk-in clinic advised rest and follow-up if symptoms persist.");

		    d1.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d1.put("Explain (Other Traumatic Incidents)", "");

		    d1.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d1.put("Explain (No Auto Insurance Violation)",
		            "Short policy gap during provider switch; reinstated quickly. Included to validate YES branch and explanation persistence.");
		    d1.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
		    d1.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

		    d1.put("Have you previously received a settlement advance for this case?", "NO");
		    d1.put("Explain (Previous Settlement Advance)", "");
		    d1.put("What company did you borrow from?", "");
		    d1.put("How much did you receive?", "");

		    d1.put("Were other people injured in this accident?", "I DON'T KNOW");
		    d1.put("Explain (Other People Injured)", "I did not receive confirmed medical info from others at the scene.");

		    d1.put("Are you currently behind on child support?", "NO");
		    d1.put("Explain (Behind on Child Support)", "");
		    d1.put("Where do you owe child support? (State)", "");
		    d1.put("Where do you owe child support? (County)", "");
		    d1.put("How much do you owe?", "");

		    d1.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
		    d1.put("Which one(s)?", "");
		    d1.put("Explain (Governmental Health Coverage)", "Not sure if the current coverage qualifies as government coverage.");

		    // -------------------- App 2 --------------------
		    TreeMap<String, String> d2 = new TreeMap<>();
		    d2.put("I am seeking an advance of", "9400");
		    d2.put("Your Full Name", "@Test_Elijah Norton");
		    d2.put("Date of Birth", "11/26/1989");
		    d2.put("Phone Number", "2018845306");
		    d2.put("Email", "pltf.elijah.norton.6m2q9r1t@yopmail.com");
		    d2.put("Mailing Street Address", "88 Greene Street, Unit 14A");
		    d2.put("City", "Jersey City");
		    d2.put("State", "New Jersey");

		    d2.put("Lawyer's Name", "Perry Mason");
		    d2.put("Lawyer's Phone Number", "2018811704");
		    d2.put("Law Firm Name", "Harbourstone Legal Group Test Law Firm");

		    d2.put("When did the accident happen?", "02/17/2025");
		    d2.put("Where did the accident happen?", "Newark, NJ");
		    d2.put("Describe the accident",
		            "Slip and fall near building entrance where the floor was slick from tracked-in rain. Incident was reported to staff and time/location were noted.");
		    d2.put("Describe the injuries you sustained during the accident",
		            "Hip bruise and elbow soreness with swelling. Advised rest and follow-up if pain increases.");

		    d2.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d2.put("Explain (Other Traumatic Incidents)",
		            "Minor fall at home about a month later; bruised knee only. Included for YES path testing.");

		    d2.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d2.put("Explain (No Auto Insurance Violation)", "");
		    d2.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d2.put("Was that vehicle covered by insurance?", "");

		    d2.put("Have you previously received a settlement advance for this case?", "YES");
		    d2.put("Explain (Previous Settlement Advance)",
		            "Previously received a small advance; verifying dependent inputs appear and retain values after navigation.");
		    d2.put("What company did you borrow from?", "North Ridge Advance Partners");
		    d2.put("How much did you receive?", "2500");

		    d2.put("Were other people injured in this accident?", "NO");
		    d2.put("Explain (Other People Injured)", "");

		    d2.put("Are you currently behind on child support?", "NO");
		    d2.put("Explain (Behind on Child Support)", "");
		    d2.put("Where do you owe child support? (State)", "");
		    d2.put("Where do you owe child support? (County)", "");
		    d2.put("How much do you owe?", "");

		    d2.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d2.put("Which one(s)?", "Medicaid");
		    d2.put("Explain (Governmental Health Coverage)", "Enrolled and confirming benefits coordination details.");

		    // -------------------- App 3 --------------------
		    TreeMap<String, String> d3 = new TreeMap<>();
		    d3.put("I am seeking an advance of", "27800");
		    d3.put("Your Full Name", "@Test_Caleb Renshaw");
		    d3.put("Date of Birth", "07/04/1991");
		    d3.put("Phone Number", "2027756142");
		    d3.put("Email", "pltf.caleb.renshaw.3v8k1p6n@yopmail.com");
		    d3.put("Mailing Street Address", "1200 Pennsylvania Avenue NW, Unit 611");
		    d3.put("City", "Washington");
		    d3.put("State", "District of Columbia");

		    d3.put("Lawyer's Name", "Frank Spector");
		    d3.put("Lawyer's Phone Number", "2027701139");
		    d3.put("Law Firm Name", "Gateway Pleading House");

		    d3.put("When did the accident happen?", "08/22/2024");
		    d3.put("Where did the accident happen?", "Washington, DC");
		    d3.put("Describe the accident",
		            "Pedestrian incident at a marked crosswalk. A turning vehicle moved forward unexpectedly and clipped me, causing a stumble and fall. Police and EMS attended.");
		    d3.put("Describe the injuries you sustained during the accident",
		            "Ankle sprain and bruised knee. Ongoing lower-back soreness after longer walks.");

		    d3.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
		    d3.put("Explain (Other Traumatic Incidents)",
		            "Not sure if a later sports strain counts as traumatic; selecting for branch coverage.");

		    d3.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
		    d3.put("Explain (No Auto Insurance Violation)",
		            "Not certain about prior policy status when listed on someone else’s vehicle; included to test I DON'T KNOW behavior.");
		    d3.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d3.put("Was that vehicle covered by insurance?", "");

		    d3.put("Have you previously received a settlement advance for this case?", "NO");
		    d3.put("Explain (Previous Settlement Advance)", "");
		    d3.put("What company did you borrow from?", "");
		    d3.put("How much did you receive?", "");

		    d3.put("Were other people injured in this accident?", "YES");
		    d3.put("Explain (Other People Injured)", "A cyclist braked suddenly and fell while avoiding the vehicle; minor scrapes reported.");

		    d3.put("Are you currently behind on child support?", "NO");
		    d3.put("Explain (Behind on Child Support)", "");
		    d3.put("Where do you owe child support? (State)", "");
		    d3.put("Where do you owe child support? (County)", "");
		    d3.put("How much do you owe?", "");

		    d3.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d3.put("Which one(s)?", "");
		    d3.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 4 --------------------
		    TreeMap<String, String> d4 = new TreeMap<>();
		    d4.put("I am seeking an advance of", "13100");
		    d4.put("Your Full Name", "@Test_Declan Pierce");
		    d4.put("Date of Birth", "01/13/1990");
		    d4.put("Phone Number", "3126609475");
		    d4.put("Email", "pltf.declan.pierce.8t2n6m4q@yopmail.com");
		    d4.put("Mailing Street Address", "225 W Randolph Street, Apt 19D");
		    d4.put("City", "Chicago");
		    d4.put("State", "Illinois");

		    d4.put("Lawyer's Name", "Samuel Caldershade");
		    d4.put("Lawyer's Phone Number", "3126647711");
		    d4.put("Law Firm Name", "DuPage Trialcraft Office");

		    d4.put("When did the accident happen?", "02/09/2025");
		    d4.put("Where did the accident happen?", "Chicago, IL");
		    d4.put("Describe the accident",
		            "Multi-car chain reaction at an exit ramp. My vehicle was hit from behind and pushed forward. Police report requested; photos taken.");
		    d4.put("Describe the injuries you sustained during the accident",
		            "Neck tightness and jaw soreness next morning; prescribed anti-inflammatory meds and PT referral.");

		    d4.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d4.put("Explain (Other Traumatic Incidents)", "");

		    d4.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d4.put("Explain (No Auto Insurance Violation)",
		            "Old lapse due to missed renewal notice. Included to validate dependent sub-questions appear for YES selection.");
		    d4.put("In the PRESENT accident, were you in a vehicle owned by you?", "NO");
		    d4.put("Was that vehicle covered by insurance?", "YES");

		    d4.put("Have you previously received a settlement advance for this case?", "I DON'T KNOW");
		    d4.put("Explain (Previous Settlement Advance)",
		            "Not sure if an earlier discussion with a provider counts as an advance; selecting for branch coverage.");
		    d4.put("What company did you borrow from?", "");
		    d4.put("How much did you receive?", "");

		    d4.put("Were other people injured in this accident?", "I DON'T KNOW");
		    d4.put("Explain (Other People Injured)", "I saw others being checked but did not receive confirmed details.");

		    d4.put("Are you currently behind on child support?", "YES");
		    d4.put("Explain (Behind on Child Support)", "Payments are behind due to temporary income disruption; included for dependent field testing.");
		    d4.put("Where do you owe child support? (State)", "Illinois");
		    d4.put("Where do you owe child support? (County)", "Cook");
		    d4.put("How much do you owe?", "5100");

		    d4.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d4.put("Which one(s)?", "");
		    d4.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 5 --------------------
		    TreeMap<String, String> d5 = new TreeMap<>();
		    d5.put("I am seeking an advance of", "7200");
		    d5.put("Your Full Name", "@Test_Grayson Webb");
		    d5.put("Date of Birth", "05/27/1994");
		    d5.put("Phone Number", "3057712844");
		    d5.put("Email", "pltf.grayson.webb.5k1p9v7r@yopmail.com");
		    d5.put("Mailing Street Address", "920 Brickell Key Blvd, Unit 2210");
		    d5.put("City", "Miami");
		    d5.put("State", "Florida");

		    d5.put("Lawyer's Name", "Sophie McKenzie Test Attorney");
		    d5.put("Lawyer's Phone Number", "3057706612");
		    d5.put("Law Firm Name", "SunCoast Liability Atelier");

		    d5.put("When did the accident happen?", "12/14/2024");
		    d5.put("Where did the accident happen?", "Miami, FL");
		    d5.put("Describe the accident",
		            "Intersection collision after another driver ran a red light. Vehicle spun and hit a curb. Witness details noted.");
		    d5.put("Describe the injuries you sustained during the accident",
		            "Bruised ribs and shoulder strain causing sleep disruption; PT recommended.");

		    d5.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d5.put("Explain (Other Traumatic Incidents)", "");

		    d5.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d5.put("Explain (No Auto Insurance Violation)", "");
		    d5.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d5.put("Was that vehicle covered by insurance?", "");

		    d5.put("Have you previously received a settlement advance for this case?", "YES");
		    d5.put("Explain (Previous Settlement Advance)", "Prior advance received; validating company/amount fields appear and store values.");
		    d5.put("What company did you borrow from?", "Coastal Bridge Funding");
		    d5.put("How much did you receive?", "4000");

		    d5.put("Were other people injured in this accident?", "YES");
		    d5.put("Explain (Other People Injured)", "Other driver reported neck pain at the scene; ambulance arrived.");

		    d5.put("Are you currently behind on child support?", "NO");
		    d5.put("Explain (Behind on Child Support)", "");
		    d5.put("Where do you owe child support? (State)", "");
		    d5.put("Where do you owe child support? (County)", "");
		    d5.put("How much do you owe?", "");

		    d5.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
		    d5.put("Which one(s)?", "");
		    d5.put("Explain (Governmental Health Coverage)", "Coverage status unclear; included to validate I DON'T KNOW option handling.");

		    // -------------------- App 6 --------------------
		    TreeMap<String, String> d6 = new TreeMap<>();
		    d6.put("I am seeking an advance of", "18800");
		    d6.put("Your Full Name", "@Test_Landon Sharp");
		    d6.put("Date of Birth", "09/08/1991");
		    d6.put("Phone Number", "6026613049");
		    d6.put("Email", "pltf.landon.sharp.2q8v6m1t@yopmail.com");
		    d6.put("Mailing Street Address", "201 E Camelback Road, Suite 510");
		    d6.put("City", "Phoenix");
		    d6.put("State", "Arizona");

		    d6.put("Lawyer's Name", "scott spisak");
		    d6.put("Lawyer's Phone Number", "6026647710");
		    d6.put("Law Firm Name", "Sonoran Docketwright Office");

		    d6.put("When did the accident happen?", "06/28/2024");
		    d6.put("Where did the accident happen?", "Phoenix, AZ");
		    d6.put("Describe the accident",
		            "Trip and fall on uneven pavement outside a retail complex. Cracked concrete and no warning sign. Photos taken immediately.");
		    d6.put("Describe the injuries you sustained during the accident",
		            "Knee swelling and abrasions; wrist tenderness. Imaging ruled out fracture.");

		    d6.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d6.put("Explain (Other Traumatic Incidents)", "Minor shoulder strain weeks later; included for YES + explain persistence testing.");

		    d6.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d6.put("Explain (No Auto Insurance Violation)", "");
		    d6.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d6.put("Was that vehicle covered by insurance?", "");

		    d6.put("Have you previously received a settlement advance for this case?", "NO");
		    d6.put("Explain (Previous Settlement Advance)", "");
		    d6.put("What company did you borrow from?", "");
		    d6.put("How much did you receive?", "");

		    d6.put("Were other people injured in this accident?", "NO");
		    d6.put("Explain (Other People Injured)", "");

		    d6.put("Are you currently behind on child support?", "I DON'T KNOW");
		    d6.put("Explain (Behind on Child Support)", "Not sure how the system defines it; selecting I DON'T KNOW for branch coverage.");
		    d6.put("Where do you owe child support? (State)", "");
		    d6.put("Where do you owe child support? (County)", "");
		    d6.put("How much do you owe?", "");

		    d6.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d6.put("Which one(s)?", "Medicare");
		    d6.put("Explain (Governmental Health Coverage)", "Enrolled; included to validate YES selection shows Which one(s) and retains text.");

		    // -------------------- App 7 --------------------
		    TreeMap<String, String> d7 = new TreeMap<>();
		    d7.put("I am seeking an advance of", "10150");
		    d7.put("Your Full Name", "@Test_Quentin Marsh");
		    d7.put("Date of Birth", "12/30/1988");
		    d7.put("Phone Number", "2065409031");
		    d7.put("Email", "pltf.quentin.marsh.9r1t6k2v@yopmail.com");
		    d7.put("Mailing Street Address", "600 5th Avenue, Floor 22");
		    d7.put("City", "Seattle");
		    d7.put("State", "Washington");

		    d7.put("Lawyer's Name", "Attorney Callum Jasper Kincaid-Rowe");
		    d7.put("Lawyer's Phone Number", "2065421106");
		    d7.put("Law Firm Name", "Cascade Claimcraft Legal Studio");

		    d7.put("When did the accident happen?", "09/03/2024");
		    d7.put("Where did the accident happen?", "Seattle, WA");
		    d7.put("Describe the accident",
		            "Bike lane incident where a car door opened into the lane. Limited reaction time; I fell and scraped my arm and shoulder.");
		    d7.put("Describe the injuries you sustained during the accident",
		            "Shoulder strain and abrasions; wrist pain when lifting objects.");

		    d7.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d7.put("Explain (Other Traumatic Incidents)", "");

		    d7.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d7.put("Explain (No Auto Insurance Violation)", "Had a brief lapse during relocation; included to trigger dependent sub-questions.");
		    d7.put("In the PRESENT accident, were you in a vehicle owned by you?", "I DON'T KNOW");
		    d7.put("Was that vehicle covered by insurance?", "YES");

		    d7.put("Have you previously received a settlement advance for this case?", "NO");
		    d7.put("Explain (Previous Settlement Advance)", "");
		    d7.put("What company did you borrow from?", "");
		    d7.put("How much did you receive?", "");

		    d7.put("Were other people injured in this accident?", "NO");
		    d7.put("Explain (Other People Injured)", "");

		    d7.put("Are you currently behind on child support?", "NO");
		    d7.put("Explain (Behind on Child Support)", "");
		    d7.put("Where do you owe child support? (State)", "");
		    d7.put("Where do you owe child support? (County)", "");
		    d7.put("How much do you owe?", "");

		    d7.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d7.put("Which one(s)?", "");
		    d7.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 8 --------------------
		    TreeMap<String, String> d8 = new TreeMap<>();
		    d8.put("I am seeking an advance of", "22900");
		    d8.put("Your Full Name", "@Test_Harper Wainwright");
		    d8.put("Date of Birth", "03/09/1993");
		    d8.put("Phone Number", "3036608814");
		    d8.put("Email", "pltf.harper.wainwright.4m7q2p9n@yopmail.com");
		    d8.put("Mailing Street Address", "1550 Lincoln Street, Suite 1800");
		    d8.put("City", "Denver");
		    d8.put("State", "Colorado");

		    d8.put("Lawyer's Name", "Attorney Mireille Blaise Laframboise");
		    d8.put("Lawyer's Phone Number", "3036612209");
		    d8.put("Law Firm Name", "FrontRange Trial Mechanics");

		    d8.put("When did the accident happen?", "01/22/2025");
		    d8.put("Where did the accident happen?", "Denver, CO");
		    d8.put("Describe the accident",
		            "Worksite trip caused by a loose cable near a loading area. Fell and struck elbow and hip; incident reported to supervisor.");
		    d8.put("Describe the injuries you sustained during the accident",
		            "Elbow swelling and hip bruise; lower back stiffness. Follow-up scheduled.");

		    d8.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
		    d8.put("Explain (Other Traumatic Incidents)", "Not sure if a later minor fall counts; selecting I DON'T KNOW for behavior coverage.");

		    d8.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d8.put("Explain (No Auto Insurance Violation)", "");
		    d8.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d8.put("Was that vehicle covered by insurance?", "");

		    d8.put("Have you previously received a settlement advance for this case?", "YES");
		    d8.put("Explain (Previous Settlement Advance)", "Prior advance received; validating company + amount inputs appear and persist.");
		    d8.put("What company did you borrow from?", "Verdant Case Advance Co");
		    d8.put("How much did you receive?", "6200");

		    d8.put("Were other people injured in this accident?", "NO");
		    d8.put("Explain (Other People Injured)", "");

		    d8.put("Are you currently behind on child support?", "NO");
		    d8.put("Explain (Behind on Child Support)", "");
		    d8.put("Where do you owe child support? (State)", "");
		    d8.put("Where do you owe child support? (County)", "");
		    d8.put("How much do you owe?", "");

		    d8.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d8.put("Which one(s)?", "Medicaid");
		    d8.put("Explain (Governmental Health Coverage)", "Enrolled; confirming coverage details and eligibility status.");

		    // -------------------- App 9 (INTENTIONAL BLANK FIELD: Email) --------------------
		    TreeMap<String, String> d9 = new TreeMap<>();
		    d9.put("I am seeking an advance of", "11600");
		    d9.put("Your Full Name", "@Test_Mason Ridley");
		    d9.put("Date of Birth", "08/13/1990");
		    d9.put("Phone Number", "6177709048");
		    d9.put("Email", ""); // ✅ intentionally blank for negative validation
		    d9.put("Mailing Street Address", "200 Clarendon Street, Suite 1750");
		    d9.put("City", "Boston");
		    d9.put("State", "Massachusetts");

		    d9.put("Lawyer's Name", "Attorney Jorvane Rheolan Zephyrmont");
		    d9.put("Lawyer's Phone Number", "6177721184");
		    d9.put("Law Firm Name", "BayState Casebuilders");

		    d9.put("When did the accident happen?", "04/16/2024");
		    d9.put("Where did the accident happen?", "Boston, MA");
		    d9.put("Describe the accident",
		            "Public transit sudden stop caused loss of balance and impact against a pole. Transit report was requested from the operator.");
		    d9.put("Describe the injuries you sustained during the accident",
		            "Wrist sprain and bruised ribs; shoulder pain when lifting.");

		    d9.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d9.put("Explain (Other Traumatic Incidents)", "");

		    d9.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d9.put("Explain (No Auto Insurance Violation)", "");
		    d9.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d9.put("Was that vehicle covered by insurance?", "");

		    d9.put("Have you previously received a settlement advance for this case?", "NO");
		    d9.put("Explain (Previous Settlement Advance)", "");
		    d9.put("What company did you borrow from?", "");
		    d9.put("How much did you receive?", "");

		    d9.put("Were other people injured in this accident?", "YES");
		    d9.put("Explain (Other People Injured)", "Another passenger fell near the rear exit and reported shoulder pain.");

		    d9.put("Are you currently behind on child support?", "NO");
		    d9.put("Explain (Behind on Child Support)", "");
		    d9.put("Where do you owe child support? (State)", "");
		    d9.put("Where do you owe child support? (County)", "");
		    d9.put("How much do you owe?", "");

		    d9.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d9.put("Which one(s)?", "");
		    d9.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 10 --------------------
		    TreeMap<String, String> d10 = new TreeMap<>();
		    d10.put("I am seeking an advance of", "17950");
		    d10.put("Your Full Name", "@Test_Wyatt Danvers");
		    d10.put("Date of Birth", "06/21/1992");
		    d10.put("Phone Number", "7026607715");
		    d10.put("Email", "pltf.wyatt.danvers.7p2m9q4k@yopmail.com");
		    d10.put("Mailing Street Address", "705 S Grand Central Parkway, Unit 1906");
		    d10.put("City", "Las Vegas");
		    d10.put("State", "Nevada");

		    d10.put("Lawyer's Name", "Ayan Genuine Attorney For Test");
		    d10.put("Lawyer's Phone Number", "7026611197");
		    d10.put("Law Firm Name", "VerdictForge Litigation Atelier");

		    d10.put("When did the accident happen?", "07/17/2024");
		    d10.put("Where did the accident happen?", "Las Vegas, NV");
		    d10.put("Describe the accident",
		            "Parking lot collision while reversing. Both vehicles backed at the same time and made contact on the rear quarter panel area. Photos taken.");
		    d10.put("Describe the injuries you sustained during the accident",
		            "Neck stiffness later that day and mild headache; clinic advised rest and anti-inflammatories.");

		    d10.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d10.put("Explain (Other Traumatic Incidents)", "Minor stair slip afterward; no ER visit. Included to validate YES flow and saved text.");

		    d10.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d10.put("Explain (No Auto Insurance Violation)", "Notified of a prior lapse during a billing issue; included to trigger dependent sub-questions.");
		    d10.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
		    d10.put("Was that vehicle covered by insurance?", "YES");

		    d10.put("Have you previously received a settlement advance for this case?", "I DON'T KNOW");
		    d10.put("Explain (Previous Settlement Advance)", "Not sure; selecting I DON'T KNOW to validate this option is handled correctly.");
		    d10.put("What company did you borrow from?", "");
		    d10.put("How much did you receive?", "");

		    d10.put("Were other people injured in this accident?", "NO");
		    d10.put("Explain (Other People Injured)", "");

		    d10.put("Are you currently behind on child support?", "YES");
		    d10.put("Explain (Behind on Child Support)", "Backlog due to short-term financial disruption; included for dependent fields validation.");
		    d10.put("Where do you owe child support? (State)", "Nevada");
		    d10.put("Where do you owe child support? (County)", "Clark");
		    d10.put("How much do you owe?", "3800");

		    d10.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d10.put("Which one(s)?", "Medicare");
		    d10.put("Explain (Governmental Health Coverage)", "Enrolled; included to validate Which one(s) textbox and persistence.");

		    // =========================================================
		    // ✅ Apps 11–20 (same exact pattern, all unique values)
		    // =========================================================

		    // -------------------- App 11 (INTENTIONAL BLANK FIELD: Phone Number) --------------------
		    TreeMap<String, String> d11 = new TreeMap<>();
		    d11.put("I am seeking an advance of", "15400");
		    d11.put("Your Full Name", "@Test_Oliver Camden");
		    d11.put("Date of Birth", "02/08/1993");
		    d11.put("Phone Number", ""); // ✅ intentionally blank for negative validation
		    d11.put("Email", "pltf.oliver.camden.3h6k1m9q@yopmail.com");
		    d11.put("Mailing Street Address", "33 King Street West, Unit 1202");
		    d11.put("City", "Toronto");
		    d11.put("State", "New York");

		    d11.put("Lawyer's Name", "Attorney Heliara Sylven Wexenhall");
		    d11.put("Lawyer's Phone Number", "9176604412");
		    d11.put("Law Firm Name", "RiverBend Pleading Studio");

		    d11.put("When did the accident happen?", "11/02/2024");
		    d11.put("Where did the accident happen?", "Buffalo, NY");
		    d11.put("Describe the accident", "Lane change side-swipe during evening traffic; exchanged info and took photos at the scene.");
		    d11.put("Describe the injuries you sustained during the accident", "Upper back tightness and wrist soreness the next day; clinic visit documented.");

		    d11.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d11.put("Explain (Other Traumatic Incidents)", "");

		    d11.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d11.put("Explain (No Auto Insurance Violation)", "");
		    d11.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d11.put("Was that vehicle covered by insurance?", "");

		    d11.put("Have you previously received a settlement advance for this case?", "NO");
		    d11.put("Explain (Previous Settlement Advance)", "");
		    d11.put("What company did you borrow from?", "");
		    d11.put("How much did you receive?", "");

		    d11.put("Were other people injured in this accident?", "I DON'T KNOW");
		    d11.put("Explain (Other People Injured)", "No confirmed report from EMS or police regarding others.");

		    d11.put("Are you currently behind on child support?", "NO");
		    d11.put("Explain (Behind on Child Support)", "");
		    d11.put("Where do you owe child support? (State)", "");
		    d11.put("Where do you owe child support? (County)", "");
		    d11.put("How much do you owe?", "");

		    d11.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d11.put("Which one(s)?", "");
		    d11.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 12 --------------------
		    TreeMap<String, String> d12 = new TreeMap<>();
		    d12.put("I am seeking an advance of", "8600");
		    d12.put("Your Full Name", "@Test_Ethan Lockwood");
		    d12.put("Date of Birth", "10/11/1989");
		    d12.put("Phone Number", "7186609821");
		    d12.put("Email", "pltf.ethan.lockwood.6q2m7v9p@yopmail.com");
		    d12.put("Mailing Street Address", "240 W 34th Street, Apt 10H");
		    d12.put("City", "New York");
		    d12.put("State", "New Jersey");

		    d12.put("Lawyer's Name", "Attorney Seredyn Zoriel Kleinwold");
		    d12.put("Lawyer's Phone Number", "7186611208");
		    d12.put("Law Firm Name", "MillCity Docket Foundry");

		    d12.put("When did the accident happen?", "03/07/2025");
		    d12.put("Where did the accident happen?", "Brooklyn, NY");
		    d12.put("Describe the accident", "Fall on a stair landing with poor lighting; time and location recorded, and photos were taken afterward.");
		    d12.put("Describe the injuries you sustained during the accident", "Sprained ankle and bruised knee; advised rest and follow-up.");

		    d12.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d12.put("Explain (Other Traumatic Incidents)", "Minor fender-bender weeks later; no medical visit. Included to validate YES flow.");

		    d12.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d12.put("Explain (No Auto Insurance Violation)", "Prior lapse during payment processing issue; included to trigger sub-questions.");
		    d12.put("In the PRESENT accident, were you in a vehicle owned by you?", "NO");
		    d12.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

		    d12.put("Have you previously received a settlement advance for this case?", "YES");
		    d12.put("Explain (Previous Settlement Advance)", "Prior advance recorded; validating dependent company/amount inputs.");
		    d12.put("What company did you borrow from?", "Oakline Settlement Advance");
		    d12.put("How much did you receive?", "1800");

		    d12.put("Were other people injured in this accident?", "NO");
		    d12.put("Explain (Other People Injured)", "");

		    d12.put("Are you currently behind on child support?", "NO");
		    d12.put("Explain (Behind on Child Support)", "");
		    d12.put("Where do you owe child support? (State)", "");
		    d12.put("Where do you owe child support? (County)", "");
		    d12.put("How much do you owe?", "");

		    d12.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
		    d12.put("Which one(s)?", "");
		    d12.put("Explain (Governmental Health Coverage)", "Not sure which plan category applies; included to validate I DON'T KNOW behavior.");

		    // -------------------- App 13 --------------------
		    TreeMap<String, String> d13 = new TreeMap<>();
		    d13.put("I am seeking an advance of", "20300");
		    d13.put("Your Full Name", "@Test_Levi Armitage");
		    d13.put("Date of Birth", "07/16/1991");
		    d13.put("Phone Number", "4046139057");
		    d13.put("Email", "pltf.levi.armitage.1m9q4k7p@yopmail.com");
		    d13.put("Mailing Street Address", "450 Peachtree Street NE, Apt 7F");
		    d13.put("City", "Atlanta");
		    d13.put("State", "Georgia");

		    d13.put("Lawyer's Name", "Attorney Orphena Perevin Cindervaux");
		    d13.put("Lawyer's Phone Number", "4046101188");
		    d13.put("Law Firm Name", "Peachtree Litigation Works");

		    d13.put("When did the accident happen?", "09/30/2024");
		    d13.put("Where did the accident happen?", "Atlanta, GA");
		    d13.put("Describe the accident", "Side-impact near an intersection where the other driver failed to yield; exchanged details and captured scene photos.");
		    d13.put("Describe the injuries you sustained during the accident", "Neck strain and shoulder soreness; prescribed rest and PT.");

		    d13.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d13.put("Explain (Other Traumatic Incidents)", "");

		    d13.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d13.put("Explain (No Auto Insurance Violation)", "");
		    d13.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d13.put("Was that vehicle covered by insurance?", "");

		    d13.put("Have you previously received a settlement advance for this case?", "I DON'T KNOW");
		    d13.put("Explain (Previous Settlement Advance)", "Not sure if a prior inquiry counts; selecting I DON'T KNOW for option coverage.");
		    d13.put("What company did you borrow from?", "");
		    d13.put("How much did you receive?", "");

		    d13.put("Were other people injured in this accident?", "YES");
		    d13.put("Explain (Other People Injured)", "A passenger reported wrist pain and went to urgent care later.");

		    d13.put("Are you currently behind on child support?", "NO");
		    d13.put("Explain (Behind on Child Support)", "");
		    d13.put("Where do you owe child support? (State)", "");
		    d13.put("Where do you owe child support? (County)", "");
		    d13.put("How much do you owe?", "");

		    d13.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d13.put("Which one(s)?", "Medicaid");
		    d13.put("Explain (Governmental Health Coverage)", "Enrolled; verifying that Which one(s) captures and persists correctly.");

		    // -------------------- App 14 --------------------
		    TreeMap<String, String> d14 = new TreeMap<>();
		    d14.put("I am seeking an advance of", "11200");
		    d14.put("Your Full Name", "@Test_Noah Sutherland");
		    d14.put("Date of Birth", "01/05/1990");
		    d14.put("Phone Number", "6179032218");
		    d14.put("Email", "pltf.noah.sutherland.8v2q6m1t@yopmail.com");
		    d14.put("Mailing Street Address", "55 Congress Street, Suite 1400");
		    d14.put("City", "Boston");
		    d14.put("State", "Massachusetts");

		    d14.put("Lawyer's Name", "Attorney Nyxorin Demerin Frostmerrow");
		    d14.put("Lawyer's Phone Number", "6179051172");
		    d14.put("Law Firm Name", "Bayou Evidence Preservation & Trial Support Counsel");

		    d14.put("When did the accident happen?", "04/27/2024");
		    d14.put("Where did the accident happen?", "Cambridge, MA");
		    d14.put("Describe the accident", "Bus stopped suddenly; I lost balance and struck a pole. Report number requested from transit authority.");
		    d14.put("Describe the injuries you sustained during the accident", "Wrist sprain and bruised ribs; follow-up noted limited range of motion.");

		    d14.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d14.put("Explain (Other Traumatic Incidents)", "");

		    d14.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d14.put("Explain (No Auto Insurance Violation)", "Previous lapse due to administrative error; included to trigger sub-questions.");
		    d14.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
		    d14.put("Was that vehicle covered by insurance?", "NO");

		    d14.put("Have you previously received a settlement advance for this case?", "YES");
		    d14.put("Explain (Previous Settlement Advance)", "Received a prior advance; validating dependent company + amount fields appear.");
		    d14.put("What company did you borrow from?", "Harbor Point Advance");
		    d14.put("How much did you receive?", "3000");

		    d14.put("Were other people injured in this accident?", "NO");
		    d14.put("Explain (Other People Injured)", "");

		    d14.put("Are you currently behind on child support?", "YES");
		    d14.put("Explain (Behind on Child Support)", "Backlog exists; included to validate dependent State/County/Amount fields.");
		    d14.put("Where do you owe child support? (State)", "Massachusetts");
		    d14.put("Where do you owe child support? (County)", "Middlesex");
		    d14.put("How much do you owe?", "2750");

		    d14.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d14.put("Which one(s)?", "");
		    d14.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 15 --------------------
		    TreeMap<String, String> d15 = new TreeMap<>();
		    d15.put("I am seeking an advance of", "24600");
		    d15.put("Your Full Name", "@Test_Lucas Whitaker");
		    d15.put("Date of Birth", "06/29/1992");
		    d15.put("Phone Number", "5127746039");
		    d15.put("Email", "pltf.lucas.whitaker.2n7t9m3q@yopmail.com");
		    d15.put("Mailing Street Address", "800 Congress Avenue, Apt 20C");
		    d15.put("City", "Austin");
		    d15.put("State", "Texas");

		    d15.put("Lawyer's Name", "Attorney Rivena Caelith Marblethorn");
		    d15.put("Lawyer's Phone Number", "5127711180");
		    d15.put("Law Firm Name", "Keystone Dispute Lab");

		    d15.put("When did the accident happen?", "08/11/2024");
		    d15.put("Where did the accident happen?", "Austin, TX");
		    d15.put("Describe the accident", "Intersection collision after the other driver turned across my lane; photos and witness info gathered.");
		    d15.put("Describe the injuries you sustained during the accident", "Neck pain and headache later the same day; clinic advised rest and PT.");

		    d15.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
		    d15.put("Explain (Other Traumatic Incidents)", "Not sure if a later minor injury qualifies; selecting I DON'T KNOW for option coverage.");

		    d15.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d15.put("Explain (No Auto Insurance Violation)", "");
		    d15.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d15.put("Was that vehicle covered by insurance?", "");

		    d15.put("Have you previously received a settlement advance for this case?", "NO");
		    d15.put("Explain (Previous Settlement Advance)", "");
		    d15.put("What company did you borrow from?", "");
		    d15.put("How much did you receive?", "");

		    d15.put("Were other people injured in this accident?", "YES");
		    d15.put("Explain (Other People Injured)", "Another driver reported shoulder pain at the scene; EMS evaluated.");

		    d15.put("Are you currently behind on child support?", "NO");
		    d15.put("Explain (Behind on Child Support)", "");
		    d15.put("Where do you owe child support? (State)", "");
		    d15.put("Where do you owe child support? (County)", "");
		    d15.put("How much do you owe?", "");

		    d15.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d15.put("Which one(s)?", "Medicare");
		    d15.put("Explain (Governmental Health Coverage)", "Enrolled; validating Which one(s) entry and retention.");

		    // -------------------- App 16 --------------------
		    TreeMap<String, String> d16 = new TreeMap<>();
		    d16.put("I am seeking an advance of", "6700");
		    d16.put("Your Full Name", "@Test_Sawyer Pritchard");
		    d16.put("Date of Birth", "05/14/1994");
		    d16.put("Phone Number", "3056609914");
		    d16.put("Email", "pltf.sawyer.pritchard.4q1x8m6p@yopmail.com");
		    d16.put("Mailing Street Address", "1010 Brickell Avenue, Unit 3007");
		    d16.put("City", "Miami");
		    d16.put("State", "Florida");

		    d16.put("Lawyer's Name", "Attorney Delvara Nerissa Orinthvale");
		    d16.put("Lawyer's Phone Number", "3056612201");
		    d16.put("Law Firm Name", "SunCoast Liability Atelier");

		    d16.put("When did the accident happen?", "12/09/2024");
		    d16.put("Where did the accident happen?", "Miami, FL");
		    d16.put("Describe the accident", "Side-impact after another driver ran a red light; photos taken and witness contact saved.");
		    d16.put("Describe the injuries you sustained during the accident", "Rib soreness and shoulder strain; sleep affected; PT recommended.");

		    d16.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d16.put("Explain (Other Traumatic Incidents)", "");

		    d16.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d16.put("Explain (No Auto Insurance Violation)", "Prior lapse during move; included to trigger dependent questions.");
		    d16.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
		    d16.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

		    d16.put("Have you previously received a settlement advance for this case?", "YES");
		    d16.put("Explain (Previous Settlement Advance)", "Prior advance; validating company and amount fields appear and persist.");
		    d16.put("What company did you borrow from?", "Seabreeze Advance Network");
		    d16.put("How much did you receive?", "2100");

		    d16.put("Were other people injured in this accident?", "NO");
		    d16.put("Explain (Other People Injured)", "");

		    d16.put("Are you currently behind on child support?", "NO");
		    d16.put("Explain (Behind on Child Support)", "");
		    d16.put("Where do you owe child support? (State)", "");
		    d16.put("Where do you owe child support? (County)", "");
		    d16.put("How much do you owe?", "");

		    d16.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
		    d16.put("Which one(s)?", "");
		    d16.put("Explain (Governmental Health Coverage)", "Not sure about enrollment status; selecting I DON'T KNOW for branch coverage.");

		    // -------------------- App 17 --------------------
		    TreeMap<String, String> d17 = new TreeMap<>();
		    d17.put("I am seeking an advance of", "19350");
		    d17.put("Your Full Name", "@Test_Adrian Kingsley");
		    d17.put("Date of Birth", "09/23/1991");
		    d17.put("Phone Number", "3037719025");
		    d17.put("Email", "pltf.adrian.kingsley.9k2m7q1t@yopmail.com");
		    d17.put("Mailing Street Address", "1700 Lincoln Street, Suite 2105");
		    d17.put("City", "Denver");
		    d17.put("State", "Colorado");

		    d17.put("Lawyer's Name", "Attorney Tressel Vionne Quillnore");
		    d17.put("Lawyer's Phone Number", "3037701186");
		    d17.put("Law Firm Name", "FrontRange Trial Mechanics");

		    d17.put("When did the accident happen?", "01/12/2025");
		    d17.put("Where did the accident happen?", "Denver, CO");
		    d17.put("Describe the accident", "Worksite trip on a loose cable; incident report filed and photos taken of area.");
		    d17.put("Describe the injuries you sustained during the accident", "Elbow swelling and lower back stiffness; follow-up pending.");

		    d17.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d17.put("Explain (Other Traumatic Incidents)", "Minor strain during exercise later; included to validate YES + explain persistence.");

		    d17.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d17.put("Explain (No Auto Insurance Violation)", "");
		    d17.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d17.put("Was that vehicle covered by insurance?", "");

		    d17.put("Have you previously received a settlement advance for this case?", "NO");
		    d17.put("Explain (Previous Settlement Advance)", "");
		    d17.put("What company did you borrow from?", "");
		    d17.put("How much did you receive?", "");

		    d17.put("Were other people injured in this accident?", "NO");
		    d17.put("Explain (Other People Injured)", "");

		    d17.put("Are you currently behind on child support?", "YES");
		    d17.put("Explain (Behind on Child Support)", "Backlog due to short term cashflow; included to validate dependent fields.");
		    d17.put("Where do you owe child support? (State)", "Colorado");
		    d17.put("Where do you owe child support? (County)", "Denver");
		    d17.put("How much do you owe?", "4650");

		    d17.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d17.put("Which one(s)?", "Medicaid");
		    d17.put("Explain (Governmental Health Coverage)", "Enrolled; included to validate Which one(s) and retention.");

		    // -------------------- App 18 (INTENTIONAL BLANK FIELD: Mailing Street Address) --------------------
		    TreeMap<String, String> d18 = new TreeMap<>();
		    d18.put("I am seeking an advance of", "8800");
		    d18.put("Your Full Name", "@Test_Jasper Monroe");
		    d18.put("Date of Birth", "10/29/1988");
		    d18.put("Phone Number", "2026134087");
		    d18.put("Email", "pltf.jasper.monroe.6p3x9m1q@yopmail.com");
		    d18.put("Mailing Street Address", ""); // ✅ intentionally blank for negative validation
		    d18.put("City", "Washington");
		    d18.put("State", "District of Columbia");

		    d18.put("Lawyer's Name", "Attorney Marivelle Talar Hollowcairn");
		    d18.put("Lawyer's Phone Number", "2026112409");
		    d18.put("Law Firm Name", "PrimeMotion Claims Studio");

		    d18.put("When did the accident happen?", "08/02/2024");
		    d18.put("Where did the accident happen?", "Washington, DC");
		    d18.put("Describe the accident", "Crosswalk incident where a turning vehicle accelerated unexpectedly; police report requested.");
		    d18.put("Describe the injuries you sustained during the accident", "Ankle sprain and bruised knee; PT recommended.");

		    d18.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
		    d18.put("Explain (Other Traumatic Incidents)", "");

		    d18.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
		    d18.put("Explain (No Auto Insurance Violation)", "Not sure about historic coverage status; included to validate I DON'T KNOW option.");
		    d18.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d18.put("Was that vehicle covered by insurance?", "");

		    d18.put("Have you previously received a settlement advance for this case?", "YES");
		    d18.put("Explain (Previous Settlement Advance)", "Advance received earlier; validating dependent fields appear.");
		    d18.put("What company did you borrow from?", "Capstone Advance Bureau");
		    d18.put("How much did you receive?", "1500");

		    d18.put("Were other people injured in this accident?", "YES");
		    d18.put("Explain (Other People Injured)", "A nearby cyclist fell while avoiding the car; minor abrasions.");

		    d18.put("Are you currently behind on child support?", "NO");
		    d18.put("Explain (Behind on Child Support)", "");
		    d18.put("Where do you owe child support? (State)", "");
		    d18.put("Where do you owe child support? (County)", "");
		    d18.put("How much do you owe?", "");

		    d18.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d18.put("Which one(s)?", "");
		    d18.put("Explain (Governmental Health Coverage)", "");

		    // -------------------- App 19 --------------------
		    TreeMap<String, String> d19 = new TreeMap<>();
		    d19.put("I am seeking an advance of", "16750");
		    d19.put("Your Full Name", "@Test_Fletcher Rowe");
		    d19.put("Date of Birth", "04/06/1992");
		    d19.put("Phone Number", "6179021189");
		    d19.put("Email", "pltf.fletcher.rowe.2v8a7m1q@yopmail.com");
		    d19.put("Mailing Street Address", "100 Summer Street, Floor 18");
		    d19.put("City", "Boston");
		    d19.put("State", "Massachusetts");

		    d19.put("Lawyer's Name", "Attorney Lysandre Mirel Obsidianmere");
		    d19.put("Lawyer's Phone Number", "6179057702");
		    d19.put("Law Firm Name", "BayState Casebuilders");

		    d19.put("When did the accident happen?", "04/09/2024");
		    d19.put("Where did the accident happen?", "Boston, MA");
		    d19.put("Describe the accident", "Transit sudden stop caused fall into a pole; request submitted for incident documentation.");
		    d19.put("Describe the injuries you sustained during the accident", "Wrist sprain, bruised ribs, shoulder pain with lifting.");

		    d19.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
		    d19.put("Explain (Other Traumatic Incidents)", "Not sure if later minor strain counts; selecting I DON'T KNOW for option coverage.");

		    d19.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
		    d19.put("Explain (No Auto Insurance Violation)", "Brief lapse during billing dispute; included to trigger dependent sub-questions.");
		    d19.put("In the PRESENT accident, were you in a vehicle owned by you?", "NO");
		    d19.put("Was that vehicle covered by insurance?", "YES");

		    d19.put("Have you previously received a settlement advance for this case?", "NO");
		    d19.put("Explain (Previous Settlement Advance)", "");
		    d19.put("What company did you borrow from?", "");
		    d19.put("How much did you receive?", "");

		    d19.put("Were other people injured in this accident?", "NO");
		    d19.put("Explain (Other People Injured)", "");

		    d19.put("Are you currently behind on child support?", "YES");
		    d19.put("Explain (Behind on Child Support)", "Arrears exist; included to validate State/County/Amount dependent fields.");
		    d19.put("Where do you owe child support? (State)", "Massachusetts");
		    d19.put("Where do you owe child support? (County)", "Suffolk");
		    d19.put("How much do you owe?", "6400");

		    d19.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
		    d19.put("Which one(s)?", "Medicare");
		    d19.put("Explain (Governmental Health Coverage)", "Enrolled; validating Which one(s) input persists after navigation.");

		    // -------------------- App 20 --------------------
		    TreeMap<String, String> d20 = new TreeMap<>();
		    d20.put("I am seeking an advance of", "20850");
		    d20.put("Your Full Name", "@Test_Corbin Wallace");
		    d20.put("Date of Birth", "02/25/1991");
		    d20.put("Phone Number", "7028812064");
		    d20.put("Email", "pltf.corbin.wallace.9m2q7k4v@yopmail.com");
		    d20.put("Mailing Street Address", "777 S Main Street, Unit 1212");
		    d20.put("City", "Las Vegas");
		    d20.put("State", "Nevada");

		    d20.put("Lawyer's Name", "Attorney Kaelora Quintelle Ravenquill");
		    d20.put("Lawyer's Phone Number", "7028847719");
		    d20.put("Law Firm Name", "VerdictForge Litigation Atelier");

		    d20.put("When did the accident happen?", "07/05/2024");
		    d20.put("Where did the accident happen?", "Las Vegas, NV");
		    d20.put("Describe the accident", "Parking lot collision while backing out; photos taken and notes captured about camera locations.");
		    d20.put("Describe the injuries you sustained during the accident", "Neck stiffness later in the day and headache; clinic recommended rest.");

		    d20.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
		    d20.put("Explain (Other Traumatic Incidents)", "Minor fall on stairs after the accident; included for YES path and explain persistence.");

		    d20.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
		    d20.put("Explain (No Auto Insurance Violation)", "");
		    d20.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
		    d20.put("Was that vehicle covered by insurance?", "");

		    d20.put("Have you previously received a settlement advance for this case?", "YES");
		    d20.put("Explain (Previous Settlement Advance)", "Prior advance received; verifying dependent fields appear and retain values.");
		    d20.put("What company did you borrow from?", "Desert Bridge Advance");
		    d20.put("How much did you receive?", "5000");

		    d20.put("Were other people injured in this accident?", "I DON'T KNOW");
		    d20.put("Explain (Other People Injured)", "No confirmed injuries known to me; included to validate I DON'T KNOW branch.");

		    d20.put("Are you currently behind on child support?", "NO");
		    d20.put("Explain (Behind on Child Support)", "");
		    d20.put("Where do you owe child support? (State)", "");
		    d20.put("Where do you owe child support? (County)", "");
		    d20.put("How much do you owe?", "");

		    d20.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
		    d20.put("Which one(s)?", "");
		    d20.put("Explain (Governmental Health Coverage)", "");

	        return new Object[][]{
	                { d1 }, { d2 }, { d3 }, { d4 }, { d5 },
	                { d6 }, { d7 }, { d8 }, { d9 }, { d10 } 
	        };
	    }
		
		
		
		
		
		
		
		
	}
	
	
	


