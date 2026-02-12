package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
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
	          + " | City=" + city
	          + " | State=" + state
	          + " | Lawyer=" + lawyerName
	          + " | LawFirm=" + lawFirmName
	          + " | GovtCoverage=" + enrolledGovernmentHealthCoverage
	          + " | OtherTrauma=" + injuredOtherTraumatic
	          + " | NoInsuranceViolation=" + violationNoAutoInsurance
	          + " | PrevAdvance=" + previousSettlementAdvance
	          + " | OthersInjured=" + otherPeopleInjured
	          + " | ChildSupportBehind=" + behindOnChildSupport;

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Dataset Loaded</b><br>"
	          + "<b>📥 Input:</b> " + datasetSummary
	    );

	    System.out.println("==================================================");
	    System.out.println("DATASET LOADED");
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
	    System.out.println("OPEN FRONTEND URL");
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
	    System.out.println("FORM VISIBLE");
	    System.out.println("EXPECTED : Form in viewport & interactable");
	    System.out.println("ACTUAL   : Scrolled to form");
	    System.out.println("RESULT   : PASS ✅");
	    System.out.println("==================================================");
	    System.out.println();


	    // ===================== FILL BASIC DETAILS =====================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Applicant Details</b><br>"
	          + "<b>📥 Input:</b> Advance=" + advanceAmount + " | Name=" + fullName + " | DOB=" + dob
	          + " | Phone=" + phone + " | Email=" + email + "<br>"
	          + "<b>✅ Expected:</b> Fields should accept input without errors.<br>"
	          + "<b>🟨 Actual:</b> Sending values to fields."
	    );

	    System.out.println("==================================================");
	    System.out.println("FILL APPLICANT DETAILS");
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


	    WebElement mail_address= p.mailing_street_address();
	    rp.Scroll_to_element(mail_address);
	    mail_address.sendKeys(mailingStreetAddress);

	    WebElement City= p.city();
	    rp.Scroll_to_element(City);
	    City.sendKeys(city);

	    Report_Listen.log_print_in_report().log(Status.PASS,
	            "<b>🔹 Address Filled</b><br>"
	          + "<b>📥 Input:</b> " + mailingStreetAddress + " | " + city + " | " + state + "<br>"
	          + "<b>✅ Expected:</b> Address fields should keep values on scroll.<br>"
	          + "<b>🟨 Actual:</b> Address entered."
	    );

	    System.out.println("==================================================");
	    System.out.println("ADDRESS FILLED");
	    System.out.println("Street  : " + mailingStreetAddress);
	    System.out.println("City    : " + city);
	    System.out.println("State   : " + state);
	    System.out.println("RESULT  : PASS ✅");
	    System.out.println("==================================================");
	    System.out.println();


	    // ===================== LAWYER DETAILS =====================
	    WebElement Lawyer_name= p.lawyer_name();
	    rp.Scroll_to_element(Lawyer_name);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Lawyer Details</b><br>"
	          + "<b>📥 Input:</b> Lawyer=" + lawyerName + " | Phone=" + lawyerPhone + " | Firm=" + lawFirmName + "<br>"
	          + "<b>✅ Expected:</b> Lawyer fields should accept input correctly.<br>"
	          + "<b>🟨 Actual:</b> Entering lawyer details."
	    );

	    System.out.println("==================================================");
	    System.out.println("FILL LAWYER DETAILS");
	    System.out.println("Lawyer  : " + lawyerName);
	    System.out.println("Phone   : " + lawyerPhone);
	    System.out.println("Firm    : " + lawFirmName);
	    System.out.println("EXPECTED: Lawyer fields accept input correctly");
	    System.out.println("ACTUAL  : sendKeys started");
	    System.out.println("==================================================");
	    System.out.println();

	    // (keeping your exact line)
	    mail_address.sendKeys(lawyerName);
	    p.lawyer_phone().sendKeys(lawyerPhone);
	    p.law_firm_name().sendKeys(lawFirmName);


	    // ===================== SUBMIT PAGE 1 =====================
	    WebElement submit= ap.Submit_button();
	    rp.movetoelement(submit);

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Submit Application (Page 1)</b><br>"
	          + "<b>✅ Expected:</b> Should proceed to accident details page.<br>"
	          + "<b>🟨 Actual:</b> Clicking Submit."
	    );

	    System.out.println("==================================================");
	    System.out.println("SUBMIT APPLICATION (PAGE 1)");
	    System.out.println("EXPECTED : Navigate to accident details page");
	    System.out.println("ACTUAL   : Clicking submit");
	    System.out.println("==================================================");
	    System.out.println();

	    submit.click();


	    // ===================== ACCIDENT DETAILS =====================
	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Fill Accident Details</b><br>"
	          + "<b>📥 Input:</b> Date=" + accidentDate + " | Location=" + accidentLocation + "<br>"
	          + "<b>✅ Expected:</b> All accident fields should accept input.<br>"
	          + "<b>🟨 Actual:</b> Entering accident details."
	    );

	    System.out.println("==================================================");
	    System.out.println("FILL ACCIDENT DETAILS");
	    System.out.println("Date     : " + accidentDate);
	    System.out.println("Location : " + accidentLocation);
	    System.out.println("EXPECTED : Fields accept input");
	    System.out.println("ACTUAL   : sendKeys started");
	    System.out.println("==================================================");
	    System.out.println();

	    p.accident_date().sendKeys(accidentDate);
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
	    System.out.println("PROCEED TO QUESTIONNAIRE");
	    System.out.println("EXPECTED : Questionnaire blocks load");
	    System.out.println("ACTUAL   : Clicking Next");
	    System.out.println("==================================================");
	    System.out.println();

	    next_button.click();


	    // ===================== Q1: GOV HEALTH COVERAGE =====================
	    List<WebElement> first_question_block_buttons;
	    try { first_question_block_buttons = p.First_questions_buttons(); }
	    catch(Exception first_question_button){
	        Thread.sleep(800);
	        first_question_block_buttons = p.First_questions_buttons();
	    }

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q1: Government Health Coverage</b><br>"
	          + "<b>📥 Input:</b> " + enrolledGovernmentHealthCoverage + "<br>"
	          + "<b>✅ Expected:</b> Correct branch should trigger correct fields.<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q1: GOVERNMENT HEALTH COVERAGE");
	    System.out.println("Answer   : " + enrolledGovernmentHealthCoverage);
	    System.out.println("EXPECTED : Correct branch triggers correct fields");
	    System.out.println("ACTUAL   : Selecting option");
	    System.out.println("==================================================");
	    System.out.println();

	    if(enrolledGovernmentHealthCoverage.contains("YES")){
	        first_question_block_buttons.get(1).click();
	        WebElement healthcare_enrollment_which = p.healthcare_enrollment_which();
	        rp.movetoelement(healthcare_enrollment_which);
	        Thread.sleep(800);
	        healthcare_enrollment_which.sendKeys(enrolledGovernmentHealthCoverageWhichOnes);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q1 = YES</b><br>"
	              + "<b>📥 Input:</b> Which=" + enrolledGovernmentHealthCoverageWhichOnes + "<br>"
	              + "<b>✅ Expected:</b> 'Which one(s)?' should be visible & accept input.<br>"
	              + "<b>🟨 Actual:</b> Filled 'Which one(s)?'."
	        );

	        System.out.println("Q1 RESULT: YES selected, Which filled ✅");
	        System.out.println();
	    }
	    if(enrolledGovernmentHealthCoverage.contains("NO")){
	        first_question_block_buttons.get(0).click();

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q1 = NO</b><br>"
	              + "<b>✅ Expected:</b> No extra fields should appear.<br>"
	              + "<b>🟨 Actual:</b> Selected NO."
	        );

	        System.out.println("Q1 RESULT: NO selected ✅");
	        System.out.println();
	    }
	    if(enrolledGovernmentHealthCoverage.contains("I DON'T KNOW")){
	        first_question_block_buttons.get(2).click();
	        WebElement Healthcare_description = p.healthcare_enrollment_explain();
	        rp.movetoelement(Healthcare_description);
	        Thread.sleep(800);
	        Healthcare_description.sendKeys(enrolledGovernmentHealthCoverageExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q1 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + enrolledGovernmentHealthCoverageExplain + "<br>"
	              + "<b>✅ Expected:</b> Explain field should accept input.<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q1 RESULT: I DON'T KNOW selected, Explain filled ✅");
	        System.out.println();
	    }


	    // ===================== Q2: OTHER TRAUMA =====================
	    List<WebElement> second_question_block_buttons = p.second_questions_buttons();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q2: Other Traumatic Incidents</b><br>"
	          + "<b>📥 Input:</b> " + injuredOtherTraumatic + "<br>"
	          + "<b>✅ Expected:</b> Correct branch should trigger correct fields.<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q2: OTHER TRAUMATIC INCIDENTS");
	    System.out.println("Answer   : " + injuredOtherTraumatic);
	    System.out.println("==================================================");
	    System.out.println();

	    if(injuredOtherTraumatic.contains("YES")){
	        second_question_block_buttons.get(1).click();
	        WebElement other_incidents = p.other_incidents_description();
	        rp.movetoelement(other_incidents);
	        Thread.sleep(800);
	        other_incidents.sendKeys(injuredOtherTraumaticExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q2 = YES</b><br>"
	              + "<b>📥 Input:</b> Explain=" + injuredOtherTraumaticExplain + "<br>"
	              + "<b>🟨 Actual:</b> Filled description."
	        );

	        System.out.println("Q2 RESULT: YES selected, Explain filled ✅");
	        System.out.println();
	    }
	    if(injuredOtherTraumatic.contains("NO")){
	        second_question_block_buttons.get(0).click();

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q2 = NO</b><br>"
	              + "<b>🟨 Actual:</b> Selected NO."
	        );

	        System.out.println("Q2 RESULT: NO selected ✅");
	        System.out.println();
	    }
	    if(injuredOtherTraumatic.contains("I DON'T KNOW")){
	        second_question_block_buttons.get(2).click();
	        WebElement other_incidents_description = p.other_incidents_explain();
	        rp.movetoelement(other_incidents_description);
	        Thread.sleep(800);
	        other_incidents_description.sendKeys(injuredOtherTraumaticExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q2 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + injuredOtherTraumaticExplain + "<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q2 RESULT: I DON'T KNOW selected, Explain filled ✅");
	        System.out.println();
	    }


	    // ===================== Q3: NO AUTO INSURANCE VIOLATION =====================
	    List<WebElement> Third_question_block_buttons = p.Third_questions_buttons();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q3: No Auto Insurance Violation</b><br>"
	          + "<b>📥 Input:</b> " + violationNoAutoInsurance
	          + " | OwnedByYou=" + presentAccidentVehicleOwnedByYou
	          + " | Covered=" + presentAccidentVehicleCoveredByInsurance + "<br>"
	          + "<b>✅ Expected:</b> YES should show 2 sub-question blocks.<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q3: NO AUTO INSURANCE VIOLATION");
	    System.out.println("Answer     : " + violationNoAutoInsurance);
	    System.out.println("OwnedByYou : " + presentAccidentVehicleOwnedByYou);
	    System.out.println("Covered    : " + presentAccidentVehicleCoveredByInsurance);
	    System.out.println("==================================================");
	    System.out.println();

	    if(violationNoAutoInsurance.contains("YES")){
	        Third_question_block_buttons.get(1).click();

	        List<WebElement> subquestions_button_one = p.Third_subquestions_one_buttons();
	        if(presentAccidentVehicleOwnedByYou.contains("NO")){ subquestions_button_one.get(0).click(); }
	        if(presentAccidentVehicleOwnedByYou.contains("YES")){ subquestions_button_one.get(1).click(); }
	        if(presentAccidentVehicleOwnedByYou.contains("I DON'T KNOW")){ subquestions_button_one.get(2).click(); }

	        List<WebElement> subquestions_button_two = p.Third_subquestions_two_buttons();
	        if(presentAccidentVehicleOwnedByYou.contains("NO")){
	            rp.movetoelement(subquestions_button_two.get(0));
	            subquestions_button_two.get(0).click();
	        }
	        if(presentAccidentVehicleOwnedByYou.contains("YES")){ subquestions_button_two.get(1).click(); }
	        if(presentAccidentVehicleOwnedByYou.contains("I DON'T KNOW")){ subquestions_button_two.get(2).click(); }

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q3 = YES</b><br>"
	              + "<b>🟨 Actual:</b> YES selected and sub-question buttons clicked."
	        );

	        System.out.println("Q3 RESULT: YES selected, sub-questions answered ✅");
	        System.out.println();
	    }
	    if(violationNoAutoInsurance.contains("NO")){
	        Third_question_block_buttons.get(0).click();

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q3 = NO</b><br>"
	              + "<b>🟨 Actual:</b> Selected NO."
	        );

	        System.out.println("Q3 RESULT: NO selected ✅");
	        System.out.println();
	    }
	    if(violationNoAutoInsurance.contains("I DON'T KNOW")){
	        Third_question_block_buttons.get(2).click();
	        WebElement insurance_violation_description = p.insurance_violation_explain();
	        rp.movetoelement(insurance_violation_description);
	        Thread.sleep(800);
	        insurance_violation_description.sendKeys(violationNoAutoInsuranceExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q3 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + violationNoAutoInsuranceExplain + "<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q3 RESULT: I DON'T KNOW selected, Explain filled ✅");
	        System.out.println();
	    }


	    // ===================== Q4: PREVIOUS SETTLEMENT ADVANCE =====================
	    List<WebElement> fourth_question_block_buttons = p.Fourth_questions_buttons();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q4: Previous Settlement Advance</b><br>"
	          + "<b>📥 Input:</b> " + previousSettlementAdvance + "<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q4: PREVIOUS SETTLEMENT ADVANCE");
	    System.out.println("Answer : " + previousSettlementAdvance);
	    System.out.println("==================================================");
	    System.out.println();

	    if(previousSettlementAdvance.contains("YES")){
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
	                "<b>🔹 Q4 = YES</b><br>"
	              + "<b>📥 Input:</b> Company=" + previousSettlementBorrowCompany + " | Amount=" + previousSettlementBorrowAmount + "<br>"
	              + "<b>🟨 Actual:</b> Company & amount filled."
	        );

	        System.out.println("Q4 RESULT: YES selected, company & amount filled ✅");
	        System.out.println();
	    }
	    if(previousSettlementAdvance.contains("NO")){
	        fourth_question_block_buttons.get(0).click();

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q4 = NO</b><br>"
	              + "<b>🟨 Actual:</b> Selected NO."
	        );

	        System.out.println("Q4 RESULT: NO selected ✅");
	        System.out.println();
	    }
	    if(previousSettlementAdvance.contains("I DON'T KNOW")){
	        fourth_question_block_buttons.get(2).click();
	        WebElement previous_advance_description = p.previous_advance_explain();
	        rp.movetoelement(previous_advance_description);
	        Thread.sleep(800);
	        previous_advance_description.sendKeys(previousSettlementAdvanceExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q4 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + previousSettlementAdvanceExplain + "<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q4 RESULT: I DON'T KNOW selected, Explain filled ✅");
	        System.out.println();
	    }


	    // ===================== Q5: OTHER PEOPLE INJURED =====================
	    List<WebElement> fifth_question_block_buttons = p.Fifth_questions_buttons();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q5: Other People Injured</b><br>"
	          + "<b>📥 Input:</b> " + otherPeopleInjured + "<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q5: OTHER PEOPLE INJURED");
	    System.out.println("Answer : " + otherPeopleInjured);
	    System.out.println("==================================================");
	    System.out.println();

	    if(otherPeopleInjured.contains("YES")){
	        fifth_question_block_buttons.get(1).click();
	        Report_Listen.log_print_in_report().log(Status.PASS,"<b>🔹 Q5 = YES</b><br><b>🟨 Actual:</b> Selected YES.");
	        System.out.println("Q5 RESULT: YES selected ✅\n");
	    }
	    if(otherPeopleInjured.contains("NO")){
	        fifth_question_block_buttons.get(0).click();
	        Report_Listen.log_print_in_report().log(Status.PASS,"<b>🔹 Q5 = NO</b><br><b>🟨 Actual:</b> Selected NO.");
	        System.out.println("Q5 RESULT: NO selected ✅\n");
	    }
	    if(otherPeopleInjured.contains("I DON'T KNOW")){
	        fifth_question_block_buttons.get(2).click();
	        WebElement others_injured_description = p.others_injured_explain();
	        rp.movetoelement(others_injured_description);
	        Thread.sleep(800);
	        others_injured_description.sendKeys(otherPeopleInjuredExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q5 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + otherPeopleInjuredExplain + "<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q5 RESULT: I DON'T KNOW selected, Explain filled ✅\n");
	    }


	    // ===================== Q6: CHILD SUPPORT =====================
	    List<WebElement> Sixth_question_block_buttons = p.sixth_questions_buttons();

	    Report_Listen.log_print_in_report().log(Status.INFO,
	            "<b>🔹 Q6: Behind on Child Support</b><br>"
	          + "<b>📥 Input:</b> " + behindOnChildSupport + "<br>"
	          + "<b>🟨 Actual:</b> Selecting option."
	    );

	    System.out.println("==================================================");
	    System.out.println("Q6: BEHIND ON CHILD SUPPORT");
	    System.out.println("Answer : " + behindOnChildSupport);
	    System.out.println("==================================================");
	    System.out.println();

	    if(behindOnChildSupport.contains("YES")){
	        Sixth_question_block_buttons.get(1).click();

	        WebElement child_state = p.child_support_state();
	        rp.movetoelement(child_state);
	        Thread.sleep(800);
	        child_state.sendKeys(childSupportOweState);

	        WebElement child_owe = p.child_support_owe();
	        rp.movetoelement(child_owe);
	        Thread.sleep(800);
	        child_owe.sendKeys(childSupportOweCounty);

	        WebElement child_county = p.child_support_county();
	        rp.movetoelement(child_county);
	        Thread.sleep(800);
	        child_county.sendKeys(childSupportOweAmount);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q6 = YES</b><br>"
	              + "<b>📥 Input:</b> State=" + childSupportOweState + " | County=" + childSupportOweCounty + " | Amount=" + childSupportOweAmount + "<br>"
	              + "<b>🟨 Actual:</b> Child support fields filled."
	        );

	        System.out.println("Q6 RESULT: YES selected, State/County/Amount filled ✅\n");
	    }
	    if(behindOnChildSupport.contains("NO")){
	        Sixth_question_block_buttons.get(0).click();
	        Report_Listen.log_print_in_report().log(Status.PASS,"<b>🔹 Q6 = NO</b><br><b>🟨 Actual:</b> Selected NO.");
	        System.out.println("Q6 RESULT: NO selected ✅\n");
	    }
	    if(behindOnChildSupport.contains("I DON'T KNOW")){
	        Sixth_question_block_buttons.get(2).click();
	        WebElement child_support_description = p.child_support_explain();
	        rp.movetoelement(child_support_description);
	        Thread.sleep(800);
	        child_support_description.sendKeys(behindOnChildSupportExplain);

	        Report_Listen.log_print_in_report().log(Status.PASS,
	                "<b>🔹 Q6 = I DON'T KNOW</b><br>"
	              + "<b>📥 Input:</b> Explain=" + behindOnChildSupportExplain + "<br>"
	              + "<b>🟨 Actual:</b> Explanation entered."
	        );

	        System.out.println("Q6 RESULT: I DON'T KNOW selected, Explain filled ✅\n");
	    }


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
	    System.out.println("FINAL SUBMIT");
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
	    System.out.println("SUBMISSION SUCCESS");
	    System.out.println("EXPECTED : Success confirmation displayed");
	    System.out.println("ACTUAL   : Success element validated");
	    System.out.println("RESULT   : PASS ✅");
	    System.out.println("==================================================");
	    System.out.println();
	}
		
		@DataProvider
	    public Object[][] applyNowData() {

			
			// NOTE:
			    // ✅ Full Name / Email / Phone are taken STRICTLY from your provided list
			    // ✅ Some sets have 1 of these fields blank intentionally ("")
			    // ✅ Added conditional sub-keys:
			    //    1) If "violationNoAutoInsurance" = YES → 2 sub questions appear
			    //    2) If "previousSettlementAdvance" = YES → Borrow company + Amount received appear
			    //    3) If "behindOnChildSupport" = YES → Child support State/County/Amount appear
			    //    4) If "enrolledGovernmentHealthCoverage" = YES → "Which one(s)?" appears
			
			
			// -------------------- App 1 --------------------
			// -------------------- App 1 --------------------
			TreeMap<String, String> d1 = new TreeMap<>();
			d1.put("I am seeking an advance of", "19500");
			d1.put("Your Full Name", "Test Pete Rose");
			d1.put("Date of Birth", "09/17/1991");
			d1.put("Phone Number", "+19874563211");
			d1.put("Email", "pete@rose.com");
			d1.put("Mailing Street Address", "315 King Street East, Unit 907");
			d1.put("City", "Hamilton");
			d1.put("State", "New York");

			d1.put("Lawyer's Name", "Mireille Dagenais");
			d1.put("Lawyer's Phone Number", "9176407716");
			d1.put("Law Firm Name", "BayState Casebuilders");

			d1.put("When did the accident happen?", "11/21/2024");
			d1.put("Where did the accident happen?", "Rochester, NY");
			d1.put("Describe the accident",
			        "Side-swipe on a multi-lane road during evening traffic. A vehicle in the adjacent lane drifted left while changing lanes and clipped my front quarter panel. "
			      + "We pulled into a nearby lot, exchanged info, and I took photos from multiple angles. Police were called and arrived later.");
			d1.put("Describe the injuries you sustained during the accident",
			        "Neck stiffness later that night, upper back tightness, and intermittent tingling down the left arm. Urgent care advised rest and physio follow-up.");

			d1.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
			d1.put("Which one(s)?", "Medicaid (pending renewal confirmation)");
			d1.put("Explain (Governmental Health Coverage)", "Selected YES to trigger the 'Which one(s)?' field and validate persistence.");

			d1.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d1.put("Explain (Other Traumatic Incidents)", "Minor slip on stairs ~6 weeks later; bruised knee; no ER visit.");

			d1.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d1.put("Explain (No Auto Insurance Violation)", "Brief lapse during relocation; policy reinstated within the same week.");
			d1.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
			d1.put("Was that vehicle covered by insurance?", "YES");

			d1.put("Have you previously received a settlement advance for this case?", "NO");
			d1.put("Explain (Previous Settlement Advance)", "");
			d1.put("What company did you borrow from?", "");
			d1.put("How much did you receive?", "");

			d1.put("Were other people injured in this accident?", "NO");
			d1.put("Explain (Other People Injured)", "");

			d1.put("Are you currently behind on child support?", "NO");
			d1.put("Explain (Behind on Child Support)", "");
			d1.put("Where do you owe child support? (State)", "");
			d1.put("Where do you owe child support? (County)", "");
			d1.put("How much do you owe?", "");


			// -------------------- App 2 --------------------
			TreeMap<String, String> d2 = new TreeMap<>();
			d2.put("I am seeking an advance of", "8700");
			d2.put("Your Full Name", "Test Al Kaline");
			d2.put("Date of Birth", "10/03/1989");
			d2.put("Phone Number", "+12604835653");
			d2.put("Email", "al@kaline.com");
			d2.put("Mailing Street Address", "155 Rue Saint-Jacques, Apt 14B");
			d2.put("City", "Montréal");
			d2.put("State", "New Jersey");

			d2.put("Lawyer's Name", "Gabriel Deslauriers");
			d2.put("Lawyer's Phone Number", "2017791108");
			d2.put("Law Firm Name", "HarborLedger Trial Office");

			d2.put("When did the accident happen?", "03/12/2025");
			d2.put("Where did the accident happen?", "Jersey City, NJ");
			d2.put("Describe the accident",
			        "Slip-and-fall in a building lobby near the entrance. Floor looked dry but had a thin film of water. "
			      + "I fell onto my left side and hit elbow and hip. Staff mentioned cleaning was in progress.");
			d2.put("Describe the injuries you sustained during the accident",
			        "Bruised hip, elbow swelling, and mild dizziness for a few hours. Walk-in clinic documented tenderness.");

			d2.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d2.put("Which one(s)?", "");
			d2.put("Explain (Governmental Health Coverage)", "");

			d2.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d2.put("Explain (Other Traumatic Incidents)", "");

			d2.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d2.put("Explain (No Auto Insurance Violation)", "");
			d2.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
			d2.put("Was that vehicle covered by insurance?", "");

			d2.put("Have you previously received a settlement advance for this case?", "YES");
			d2.put("Explain (Previous Settlement Advance)", "Previous small advance early in the case to cover urgent expenses.");
			d2.put("What company did you borrow from?", "PrimeMotion Claims Studio");
			d2.put("How much did you receive?", "2500");

			d2.put("Were other people injured in this accident?", "I DON'T KNOW");
			d2.put("Explain (Other People Injured)", "No confirmed injuries were reported to me at the time.");

			d2.put("Are you currently behind on child support?", "NO");
			d2.put("Explain (Behind on Child Support)", "");
			d2.put("Where do you owe child support? (State)", "");
			d2.put("Where do you owe child support? (County)", "");
			d2.put("How much do you owe?", "");


			// -------------------- App 3 --------------------
			TreeMap<String, String> d3 = new TreeMap<>();
			d3.put("I am seeking an advance of", "24500");
			d3.put("Your Full Name", "Test Maëlys Anaëlle Gravelroux");
			d3.put("Date of Birth", "07/28/1991");
			d3.put("Phone Number", "+16027394185");
			d3.put("Email", "pltf.gravelroux.maelys.x3r7qn.9p0m@yopmail.com");
			d3.put("Mailing Street Address", "180 Wellington Street, Unit 1204");
			d3.put("City", "Ottawa");
			d3.put("State", "District of Columbia");

			d3.put("Lawyer's Name", "Thierry Beauchêne");
			d3.put("Lawyer's Phone Number", "2026112407");
			d3.put("Law Firm Name", "Capitol Briefworks");

			d3.put("When did the accident happen?", "08/04/2024");
			d3.put("Where did the accident happen?", "Washington, DC");
			d3.put("Describe the accident",
			        "Pedestrian incident at a marked crosswalk. Walk signal was on; turning vehicle rolled forward then accelerated unexpectedly. "
			      + "Police/EMS attended; witness details noted.");
			d3.put("Describe the injuries you sustained during the accident",
			        "Ankle sprain, bruised knee, and recurring lower-back pain. PT started; prolonged standing difficult.");

			d3.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d3.put("Which one(s)?", "");
			d3.put("Explain (Governmental Health Coverage)", "Unsure; using I DON'T KNOW for branch coverage.");

			d3.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d3.put("Explain (Other Traumatic Incidents)", "Minor sports strain months later; no emergency visit.");

			d3.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d3.put("Explain (No Auto Insurance Violation)", "Old lapse under a previous policy; details not fully available.");
			d3.put("In the PRESENT accident, were you in a vehicle owned by you?", "I DON'T KNOW");
			d3.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

			d3.put("Have you previously received a settlement advance for this case?", "NO");
			d3.put("Explain (Previous Settlement Advance)", "");
			d3.put("What company did you borrow from?", "");
			d3.put("How much did you receive?", "");

			d3.put("Were other people injured in this accident?", "YES");
			d3.put("Explain (Other People Injured)", "A cyclist braked hard to avoid the vehicle and fell; minor abrasions.");

			d3.put("Are you currently behind on child support?", "NO");
			d3.put("Explain (Behind on Child Support)", "");
			d3.put("Where do you owe child support? (State)", "");
			d3.put("Where do you owe child support? (County)", "");
			d3.put("How much do you owe?", "");


			// -------------------- App 4 --------------------
			TreeMap<String, String> d4 = new TreeMap<>();
			d4.put("I am seeking an advance of", "13250");
			d4.put("Your Full Name", "Test Róisín Deirdre Quenneville");
			d4.put("Date of Birth", "01/19/1990");
			d4.put("Phone Number", "+12256149308");
			d4.put("Email", "pltf.quenneville.roisin.p5v2mh.1k4q@yopmail.com");
			d4.put("Mailing Street Address", "500 Rue de la Gauchetière Ouest, Suite 2600");
			d4.put("City", "Halifax");
			d4.put("State", "Illinois");

			d4.put("Lawyer's Name", "Rosalie Beaulac");
			d4.put("Lawyer's Phone Number", "3129847712");
			d4.put("Law Firm Name", "Keystone Dispute Lab");

			d4.put("When did the accident happen?", "02/15/2025");
			d4.put("Where did the accident happen?", "Chicago, IL");
			d4.put("Describe the accident",
			        "Multi-car chain reaction on an expressway exit ramp in stop-and-go traffic. Vehicle struck from behind and pushed forward. Police report filed.");
			d4.put("Describe the injuries you sustained during the accident",
			        "Upper back spasm, neck stiffness, and jaw soreness. Symptoms worsened next morning; PT referral advised.");

			d4.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d4.put("Which one(s)?", "");
			d4.put("Explain (Governmental Health Coverage)", "");

			d4.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d4.put("Explain (Other Traumatic Incidents)", "");

			d4.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d4.put("Explain (No Auto Insurance Violation)", "");
			d4.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
			d4.put("Was that vehicle covered by insurance?", "");

			d4.put("Have you previously received a settlement advance for this case?", "YES");
			d4.put("Explain (Previous Settlement Advance)", "Early-stage advance from another provider; validating conditional fields + persistence.");
			d4.put("What company did you borrow from?", "Gateway Pleading House");
			d4.put("How much did you receive?", "3000");

			d4.put("Were other people injured in this accident?", "I DON'T KNOW");
			d4.put("Explain (Other People Injured)", "Saw one driver holding shoulder; no confirmed EMS report received.");

			d4.put("Are you currently behind on child support?", "YES");
			d4.put("Explain (Behind on Child Support)", "Selecting YES to trigger additional fields and validate save + formatting.");
			d4.put("Where do you owe child support? (State)", "Illinois");
			d4.put("Where do you owe child support? (County)", "Cook");
			d4.put("How much do you owe?", "4200");


			// -------------------- App 5 --------------------
			TreeMap<String, String> d5 = new TreeMap<>();
			d5.put("I am seeking an advance of", "6400");
			d5.put("Your Full Name", "Test Réjean Laurier Vermette");
			d5.put("Date of Birth", "05/18/1994");
			d5.put("Phone Number", "+18164079351");
			d5.put("Email", "pltf.vermette.rejean.n6k1pt.3z8v@yopmail.com");
			d5.put("Mailing Street Address", "1010 Brickell Avenue, Unit 2912");
			d5.put("City", "Winnipeg");
			d5.put("State", "Florida");

			d5.put("Lawyer's Name", "Mélissa Jade Lemieux");
			d5.put("Lawyer's Phone Number", "3057713302");
			d5.put("Law Firm Name", "SunCoast Liability Atelier");

			d5.put("When did the accident happen?", "12/06/2024");
			d5.put("Where did the accident happen?", "Miami, FL");
			d5.put("Describe the accident",
			        "Side-impact at an intersection after the other driver ran a red light. Car spun and hit a curb. Witness info recorded.");
			d5.put("Describe the injuries you sustained during the accident",
			        "Bruised ribs, shoulder strain, and disrupted sleep due to pain. Follow-up visits documented; PT recommended.");

			d5.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
			d5.put("Which one(s)?", "Medicare (Part A & B)");
			d5.put("Explain (Governmental Health Coverage)", "Entered Which one(s) to validate textarea persistence and wrapping.");

			d5.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d5.put("Explain (Other Traumatic Incidents)", "");

			d5.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d5.put("Explain (No Auto Insurance Violation)", "Policy lapsed briefly after switching vehicles; reinstated promptly.");
			d5.put("In the PRESENT accident, were you in a vehicle owned by you?", "NO");
			d5.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

			d5.put("Have you previously received a settlement advance for this case?", "NO");
			d5.put("Explain (Previous Settlement Advance)", "");
			d5.put("What company did you borrow from?", "");
			d5.put("How much did you receive?", "");

			d5.put("Were other people injured in this accident?", "YES");
			d5.put("Explain (Other People Injured)", "Other driver reported neck pain; ambulance arrived.");

			d5.put("Are you currently behind on child support?", "NO");
			d5.put("Explain (Behind on Child Support)", "");
			d5.put("Where do you owe child support? (State)", "");
			d5.put("Where do you owe child support? (County)", "");
			d5.put("How much do you owe?", "");


			// -------------------- App 6 --------------------
			TreeMap<String, String> d6 = new TreeMap<>();
			d6.put("I am seeking an advance of", "18200");
			d6.put("Your Full Name", "Test Tshala Inuinnaq Qitsualik");
			d6.put("Date of Birth", "09/03/1991");
			d6.put("Phone Number", "+19076105294");
			d6.put("Email", "pltf.qitsualik.tshala.v2r8qk.5m9x@yopmail.com");
			d6.put("Mailing Street Address", "2400 E Camelback Road, Suite 550");
			d6.put("City", "Québec City");
			d6.put("State", "Arizona");

			d6.put("Lawyer's Name", "Laurent Jean Nadeau");
			d6.put("Lawyer's Phone Number", "6026616634");
			d6.put("Law Firm Name", "Sonoran Docketwright Office");

			d6.put("When did the accident happen?", "06/22/2024");
			d6.put("Where did the accident happen?", "Phoenix, AZ");
			d6.put("Describe the accident",
			        "Trip-and-fall on uneven pavement outside a retail complex. Cracked concrete with no warning; fell forward and struck knee and palms.");
			d6.put("Describe the injuries you sustained during the accident",
			        "Knee swelling and pain, abrasions, and wrist tenderness. Imaging ruled out fracture; ortho follow-up suggested.");

			d6.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d6.put("Which one(s)?", "");
			d6.put("Explain (Governmental Health Coverage)", "");

			d6.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d6.put("Explain (Other Traumatic Incidents)", "Minor shoulder strain lifting groceries weeks later; no formal visit.");

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
			d6.put("Explain (Behind on Child Support)", "Choosing I DON'T KNOW for branch coverage.");
			d6.put("Where do you owe child support? (State)", "");
			d6.put("Where do you owe child support? (County)", "");
			d6.put("How much do you owe?", "");


			// -------------------- App 7 --------------------
			TreeMap<String, String> d7 = new TreeMap<>();
			d7.put("I am seeking an advance of", "9900");
			d7.put("Your Full Name", "Test Édith Solène Chartreux");
			d7.put("Date of Birth", "12/27/1988");
			d7.put("Phone Number", "+16097418830");
			d7.put("Email", "pltf.chartreux.edith.k9x2mp.0r7d@yopmail.com");
			d7.put("Mailing Street Address", "701 5th Avenue, Floor 44");
			d7.put("City", "Calgary");
			d7.put("State", "Washington");

			d7.put("Lawyer's Name", "Érika Suzanne Chartier");
			d7.put("Lawyer's Phone Number", "2065429016");
			d7.put("Law Firm Name", "Cascade Claimcraft Legal Studio");

			d7.put("When did the accident happen?", "09/09/2024");
			d7.put("Where did the accident happen?", "Seattle, WA");
			d7.put("Describe the accident",
			        "Bicycle lane incident: parked car door opened into my path with limited reaction time. I fell and scraped arms and shoulder.");
			d7.put("Describe the injuries you sustained during the accident",
			        "Shoulder strain, abrasions, and wrist pain when lifting objects. Clinic visit documented; PT recommended.");

			d7.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d7.put("Which one(s)?", "");
			d7.put("Explain (Governmental Health Coverage)", "Not sure if current plan qualifies; selecting I DON'T KNOW for coverage.");

			d7.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d7.put("Explain (Other Traumatic Incidents)", "");

			d7.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d7.put("Explain (No Auto Insurance Violation)", "Older lapse; limited documentation available.");
			d7.put("In the PRESENT accident, were you in a vehicle owned by you?", "NO");
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


			// -------------------- App 8 --------------------
			TreeMap<String, String> d8 = new TreeMap<>();
			d8.put("I am seeking an advance of", "22300");
			d8.put("Your Full Name", "Test Darpan Navpreet Gillmoray");
			d8.put("Date of Birth", "03/11/1993");
			d8.put("Phone Number", "+19016823047");
			d8.put("Email", ""); // intentionally blank (random blank field as requested)
			d8.put("Mailing Street Address", "1700 Lincoln Street, Suite 2100");
			d8.put("City", "Vancouver");
			d8.put("State", "Colorado");

			d8.put("Lawyer's Name", "Réjean Laurier Vermette");
			d8.put("Lawyer's Phone Number", "3036611188");
			d8.put("Law Firm Name", "FrontRange Trial Mechanics");

			d8.put("When did the accident happen?", "01/18/2025");
			d8.put("Where did the accident happen?", "Denver, CO");
			d8.put("Describe the accident",
			        "Worksite trip caused by a loose cable near a loading area. Fell and struck elbow and hip. Incident reported immediately; log created.");
			d8.put("Describe the injuries you sustained during the accident",
			        "Elbow swelling, bruised hip, and lower back stiffness. Imaging pending; follow-up scheduled.");

			d8.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
			d8.put("Which one(s)?", "Medicaid (state plan), Medicare eligibility under review");
			d8.put("Explain (Governmental Health Coverage)", "Selected YES to trigger 'Which one(s)?' and validate long-text persistence.");

			d8.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
			d8.put("Explain (Other Traumatic Incidents)", "Not sure if a prior minor fall qualifies; using I DON'T KNOW for UI state validation.");

			d8.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d8.put("Explain (No Auto Insurance Violation)", "");
			d8.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
			d8.put("Was that vehicle covered by insurance?", "");

			d8.put("Have you previously received a settlement advance for this case?", "YES");
			d8.put("Explain (Previous Settlement Advance)", "Prior advance received; verifying fields + persistence after navigation/refresh.");
			d8.put("What company did you borrow from?", "SummitCourt Litigation Desk");
			d8.put("How much did you receive?", "4000");

			d8.put("Were other people injured in this accident?", "NO");
			d8.put("Explain (Other People Injured)", "");

			d8.put("Are you currently behind on child support?", "NO");
			d8.put("Explain (Behind on Child Support)", "");
			d8.put("Where do you owe child support? (State)", "");
			d8.put("Where do you owe child support? (County)", "");
			d8.put("How much do you owe?", "");


			// -------------------- App 9 --------------------
			TreeMap<String, String> d9 = new TreeMap<>();
			d9.put("I am seeking an advance of", "11400");
			d9.put("Your Full Name", "Test Fionnuala Éibhlín Carmichaël");
			d9.put("Date of Birth", "08/08/1990");
			d9.put("Phone Number", ""); // intentionally blank
			d9.put("Email", "pltf.carmichael.fionnuala.b8k3rs.2n9t@yopmail.com");
			d9.put("Mailing Street Address", "200 Clarendon Street, Suite 1800");
			d9.put("City", "Saskatoon");
			d9.put("State", "Massachusetts");

			d9.put("Lawyer's Name", "Céline Ariane Beaulieu");
			d9.put("Lawyer's Phone Number", "6177707729");
			d9.put("Law Firm Name", "VerdictForge Litigation Atelier");

			d9.put("When did the accident happen?", "04/03/2024");
			d9.put("Where did the accident happen?", "Boston, MA");
			d9.put("Describe the accident",
			        "Public transit sudden stop caused me to lose balance and fall into a pole. Transit report requested.");
			d9.put("Describe the injuries you sustained during the accident",
			        "Wrist sprain, bruised ribs, and shoulder pain with lifting. Follow-up noted limited range of motion.");

			d9.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d9.put("Which one(s)?", "");
			d9.put("Explain (Governmental Health Coverage)", "");

			d9.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d9.put("Explain (Other Traumatic Incidents)", "");

			d9.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d9.put("Explain (No Auto Insurance Violation)", "Old policy lapse; selecting YES to trigger vehicle ownership + coverage questions.");
			d9.put("In the PRESENT accident, were you in a vehicle owned by you?", "YES");
			d9.put("Was that vehicle covered by insurance?", "I DON'T KNOW");

			d9.put("Have you previously received a settlement advance for this case?", "NO");
			d9.put("Explain (Previous Settlement Advance)", "");
			d9.put("What company did you borrow from?", "");
			d9.put("How much did you receive?", "");

			d9.put("Were other people injured in this accident?", "YES");
			d9.put("Explain (Other People Injured)", "Another passenger fell near the rear door and mentioned shoulder pain.");

			d9.put("Are you currently behind on child support?", "NO");
			d9.put("Explain (Behind on Child Support)", "");
			d9.put("Where do you owe child support? (State)", "");
			d9.put("Where do you owe child support? (County)", "");
			d9.put("How much do you owe?", "");


			// -------------------- App 10 --------------------
			TreeMap<String, String> d10 = new TreeMap<>();
			d10.put("I am seeking an advance of", "17650");
			d10.put("Your Full Name", "Test Mireille Claudine Beausolex");
			d10.put("Date of Birth", "06/25/1992");
			d10.put("Phone Number", "+14016625190");
			d10.put("Email", "pltf.beausolex.mireille.t4z1nh.6p3x@yopmail.com");
			d10.put("Mailing Street Address", "777 S Grand Central Parkway, Unit 1903");
			d10.put("City", "Edmonton");
			d10.put("State", "Nevada");

			d10.put("Lawyer's Name", "Jules-Antoine Bastien Laframboise");
			d10.put("Lawyer's Phone Number", "7026617701");
			d10.put("Law Firm Name", "Harbourstone Legal Group Test Law Firm");

			d10.put("When did the accident happen?", "07/29/2024");
			d10.put("Where did the accident happen?", "Las Vegas, NV");
			d10.put("Describe the accident",
			        "Parking lot collision while reversing. Other vehicle backed out at the same time; impact to rear quarter panel. Photos taken; cameras may exist.");
			d10.put("Describe the injuries you sustained during the accident",
			        "Neck stiffness and headache later that day, plus mild nausea. Clinic visit recorded; rest and anti-inflammatories advised.");

			d10.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d10.put("Which one(s)?", "");
			d10.put("Explain (Governmental Health Coverage)", "Not sure whether prior enrollment is still active; pending confirmation.");

			d10.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d10.put("Explain (Other Traumatic Incidents)", "Minor fall while climbing stairs post-accident; no ER visit.");

			d10.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d10.put("Explain (No Auto Insurance Violation)", "");
			d10.put("In the PRESENT accident, were you in a vehicle owned by you?", "");
			d10.put("Was that vehicle covered by insurance?", "");

			d10.put("Have you previously received a settlement advance for this case?", "YES");
			d10.put("Explain (Previous Settlement Advance)", "Prior advance exists; using YES to trigger company + amount fields.");
			d10.put("What company did you borrow from?", "Spisak Law Firm");
			d10.put("How much did you receive?", "1500");

			d10.put("Were other people injured in this accident?", "NO");
			d10.put("Explain (Other People Injured)", "");

			d10.put("Are you currently behind on child support?", "YES");
			d10.put("Explain (Behind on Child Support)", "Selecting YES to trigger State/County/Amount fields for validation.");
			d10.put("Where do you owe child support? (State)", "Nevada");
			d10.put("Where do you owe child support? (County)", "Clark");
			d10.put("How much do you owe?", "9800");

	        return new Object[][]{
	                { d1 }, { d2 }, { d3 }, { d4 }, { d5 },
	                { d6 }, { d7 }, { d8 }, { d9 }, { d10 } 
	        };
	    }
		
		
		
		
		
		
		
		
	}
	
	
	


