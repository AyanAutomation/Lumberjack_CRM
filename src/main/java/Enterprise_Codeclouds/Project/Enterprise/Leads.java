package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		
		 // ---------- Fetch all values from map ONCE (Option A style) ----------
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

	    String previousSettlementAdvance = form_data.get("Have you previously received a settlement advance for this case?");
	    String previousSettlementAdvanceExplain = form_data.get("Explain (Previous Settlement Advance)");

	    String otherPeopleInjured = form_data.get("Were other people injured in this accident?");
	    String otherPeopleInjuredExplain = form_data.get("Explain (Other People Injured)");

	    String behindOnChildSupport = form_data.get("Are you currently behind on child support?");
	    String behindOnChildSupportExplain = form_data.get("Explain (Behind on Child Support)");
	    
	    String enrolledGovernmentHealthCoverage = form_data.get("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?");
	    String enrolledGovernmentHealthCoverageExplain = form_data.get("Explain (Governmental Health Coverage)");
		
		String frontend_url = f.Data_Fetcher("Frontend_URL");
		d.get(frontend_url);
		WebElement form_=p.Form();
		rp.Scroll_to_element(form_);
		Thread.sleep(800);
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
		WebElement Lawyer_name= p.lawyer_name();
		rp.Scroll_to_element(Lawyer_name);
		mail_address.sendKeys(lawyerName);
		p.lawyer_phone().sendKeys(lawyerPhone);
		p.law_firm_name().sendKeys(lawFirmName);
		WebElement submit= ap.Submit_button();
		
		rp.movetoelement(submit);
		submit.click();
		p.accident_date().sendKeys(accidentDate);
		p.accident_location().sendKeys(accidentLocation);
		p.accident_description().sendKeys(accidentDescription);
		p.accident_injuries().sendKeys(injuriesDescription);
		List<WebElement> Buttons= p.below_buttons();
		WebElement next_button = Buttons.get(1);
		rp.movetoelement(next_button);
		next_button.click();
		List<WebElement> first_question_block_buttons;
		try {first_question_block_buttons = p.First_questions_buttons();}
		catch(Exception first_question_button){
			Thread.sleep(800);
			first_question_block_buttons = p.First_questions_buttons();}
		if(enrolledGovernmentHealthCoverage.contains("YES")){
			first_question_block_buttons.get(1).click();}
		if(enrolledGovernmentHealthCoverage.contains("NO")){
			first_question_block_buttons.get(0).click();}
		if(enrolledGovernmentHealthCoverage.contains("I DON'T KNOW")){
			first_question_block_buttons.get(2).click();
		    WebElement Healthcare_description = p.healthcare_enrollment_explain();
		    rp.movetoelement(Healthcare_description);
		    Thread.sleep(800);
		    Healthcare_description.sendKeys(enrolledGovernmentHealthCoverageExplain);}
		List<WebElement> second_question_block_buttons = p.second_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			second_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			second_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			second_question_block_buttons.get(2).click();
			WebElement other_incidents_description = p.other_incidents_explain();
			rp.movetoelement(other_incidents_description);
			Thread.sleep(800);
			other_incidents_description.sendKeys(injuredOtherTraumaticExplain);}
		List<WebElement> Third_question_block_buttons = p.Third_questions_buttons();
		if(violationNoAutoInsurance.contains("YES")){
			Third_question_block_buttons.get(1).click();}
		if(violationNoAutoInsurance.contains("NO")){
			Third_question_block_buttons.get(0).click();}
		if(violationNoAutoInsurance.contains("I DON'T KNOW")){
			Third_question_block_buttons.get(2).click();
			WebElement insurance_violation_description = p.insurance_violation_explain();
			rp.movetoelement(insurance_violation_description);
			Thread.sleep(800);
			insurance_violation_description.sendKeys(violationNoAutoInsuranceExplain);}
		List<WebElement> fourth_question_block_buttons = p.Fourth_questions_buttons();
		if(previousSettlementAdvance.contains("YES")){
			fourth_question_block_buttons.get(1).click();}
		if(previousSettlementAdvance.contains("NO")){
			fourth_question_block_buttons.get(0).click();}
		if(previousSettlementAdvance.contains("I DON'T KNOW")){
			fourth_question_block_buttons.get(2).click();
			WebElement previous_advance_description = p.previous_advance_explain();
			rp.movetoelement(previous_advance_description);
			Thread.sleep(800);
			previous_advance_description.sendKeys(previousSettlementAdvanceExplain);}
		List<WebElement> fifth_question_block_buttons = p.Fifth_questions_buttons();
		if(otherPeopleInjured.contains("YES")){
			fifth_question_block_buttons.get(1).click();}
		if(otherPeopleInjured.contains("NO")){
			fifth_question_block_buttons.get(0).click();}
		if(otherPeopleInjured.contains("I DON'T KNOW")){
			fifth_question_block_buttons.get(2).click();
			WebElement others_injured_description = p.others_injured_explain();
			rp.movetoelement(others_injured_description);
			Thread.sleep(800);
			others_injured_description.sendKeys(otherPeopleInjuredExplain);}
		List<WebElement> Sixth_question_block_buttons = p.sixth_questions_buttons();
		if(behindOnChildSupport.contains("YES")){
			Sixth_question_block_buttons.get(1).click();}
		if(behindOnChildSupport.contains("NO")){
			Sixth_question_block_buttons.get(0).click();}
		if(behindOnChildSupport.contains("I DON'T KNOW")){
			Sixth_question_block_buttons.get(2).click();
			WebElement child_support_description = p.child_support_explain();
			rp.movetoelement(child_support_description);
			Thread.sleep(800);
			child_support_description.sendKeys(behindOnChildSupportExplain);}
		List<WebElement> Third_form_Buttons= p.below_buttons();
		WebElement third_form_next_button = Third_form_Buttons.get(1);
		rp.movetoelement(third_form_next_button);
		third_form_next_button.click();
		p.form_submit_success(); 
	}
		
		@DataProvider
	    public Object[][] applyNowData() {

	        // -------------------- App 1 --------------------
			TreeMap<String, String> d1 = new TreeMap<>();

			d1.put("I am seeking an advance of", "19500");

			// ✅ Tweaked from your provided full-name list (minor spelling tweak + still contains "Test")
			d1.put("Your Full Name", "Test Adrien René Lambertt");

			d1.put("Date of Birth", "09/17/1991");
			d1.put("Phone Number", "9176384209");
			d1.put("Email", "test.adrien.lambertt.z9r2k7@yopmail.com");
			d1.put("Mailing Street Address", "315 King Street East, Unit 907");
			d1.put("City", "Hamilton");
			d1.put("State", "New York");

			d1.put("Lawyer's Name", "Test Mireille Dagenais");
			d1.put("Lawyer's Phone Number", "9176407716");

			// ✅ Tweaked from your provided law-firm list (BayState Casebuilders → tiny casing + suffix)
			d1.put("Law Firm Name", "BayState CaseBuilders, PLLC");

			d1.put("When did the accident happen?", "11/21/2024");
			d1.put("Where did the accident happen?", "Rochester, NY");

			d1.put("Describe the accident",
			        "Test scenario: Side-swipe on a multi-lane road during evening traffic. A vehicle in the adjacent lane drifted left while changing lanes and clipped my front quarter panel, "
			      + "forcing me to correct sharply to avoid the curb. The impact felt minor at first, but the steering immediately pulled and a warning light appeared on the dash. "
			      + "We pulled into a nearby lot; I took wide-angle and close-up photos, captured the other vehicle’s plate, and noted the exact intersection, lane position, and weather conditions. "
			      + "The other driver initially apologized and offered to exchange info, then suddenly claimed I “sped up” and caused the contact. Police were called; it took time for an officer to arrive. "
			      + "This paragraph is intentionally long to stress UI behavior: wrapping, card height expansion, scrollbar appearance, and whether any text overlaps buttons or breaks spacing.\n\n"
			      + "Extra stress lines: multiple sentences, punctuation, parentheses (like this), and a forced line break to validate consistent rendering across steps and after back/next navigation.");

			d1.put("Describe the injuries you sustained during the accident",
			        "Neck stiffness starting later that night, upper back tightness between the shoulder blades, and intermittent tingling down the left arm when lifting or turning quickly. "
			      + "Visited urgent care; advised rest, heat/ice rotation, and follow-up with physiotherapy. "
			      + "Added length + a line break to test the textarea and any saved preview card.\n"
			      + "If symptoms persist, provider mentioned imaging may be recommended.");

			d1.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d1.put("Explain (Other Traumatic Incidents)",
			        "Minor slip on stairs about 6 weeks later caused a bruised knee; no ER visit. Included only to test YES-path + explain persistence and long-text storage.");

			d1.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d1.put("Explain (No Auto Insurance Violation)", "");

			d1.put("Have you previously received a settlement advance for this case?", "I DON'T KNOW");
			d1.put("Explain (Previous Settlement Advance)",
			        "Not sure if a prior discussion with a different provider counts as an 'advance'; no signed paperwork available right now. Selecting for coverage of I DON'T KNOW + explain.");

			d1.put("Were other people injured in this accident?", "NO");
			d1.put("Explain (Other People Injured)", "");

			d1.put("Are you currently behind on child support?", "NO");
			d1.put("Explain (Behind on Child Support)", "");

			d1.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d1.put("Explain (Governmental Health Coverage)",
			        "Coverage status is unclear due to recent plan changes and pending eligibility confirmation. Included to verify optional explain text wrapping, save behavior, and step-to-step persistence.");

		    // -------------------- App 2 --------------------
			// -------------------- App 2 --------------------
			TreeMap<String, String> d2 = new TreeMap<>();
			d2.put("I am seeking an advance of", "8700");
			d2.put("Your Full Name", "Test Anaïs Clara Lefebvree"); // tweak from list
			d2.put("Date of Birth", "10/03/1989");
			d2.put("Phone Number", "2017786432");
			d2.put("Email", "test.anais.lefebvree.u6k3p1@yopmail.com");
			d2.put("Mailing Street Address", "155 Rue Saint-Jacques, Apt 14B");
			d2.put("City", "Montréal");
			d2.put("State", "New Jersey");

			d2.put("Lawyer's Name", "Test Gabriel Deslauriers");
			d2.put("Lawyer's Phone Number", "2017791108");
			d2.put("Law Firm Name", "HarborLedger Trial Offices"); // tweak from list

			d2.put("When did the accident happen?", "03/12/2025");
			d2.put("Where did the accident happen?", "Jersey City, NJ");
			d2.put("Describe the accident",
			        "Test scenario: Slip-and-fall in a lobby where the floor looked dry but had a thin film of water near the entrance. "
			      + "I stepped in, turned toward the elevator, and my foot slid out. I fell onto my left side and hit my elbow and hip. "
			      + "A nearby tenant helped me up; building staff later said they had been cleaning but the warning sign was placed too far away. "
			      + "I requested incident documentation and noted the time, lighting, and exact tile area. This text is intentionally long to stress card layout, wrapping, and saved preview truncation.\n\n"
			      + "Extra UI stress: multiple clauses, long sentences, and line breaks to ensure the container doesn’t overflow or clip.");
			d2.put("Describe the injuries you sustained during the accident",
			        "Bruised hip, elbow pain with swelling, and mild dizziness for several hours afterward. Walk-in clinic documented tenderness. "
			      + "Advised rest and follow-up if headaches recur.\n"
			      + "Added extra length to test multi-line persistence.");

			d2.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d2.put("Explain (Other Traumatic Incidents)", "");
			d2.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d2.put("Explain (No Auto Insurance Violation)", "");
			d2.put("Have you previously received a settlement advance for this case?", "NO");
			d2.put("Explain (Previous Settlement Advance)", "");
			d2.put("Were other people injured in this accident?", "I DON'T KNOW");
			d2.put("Explain (Other People Injured)",
			        "No confirmed injuries reported to me; I saw another person nearly slip, but I cannot verify whether they were hurt.");
			d2.put("Are you currently behind on child support?", "NO");
			d2.put("Explain (Behind on Child Support)", "");

			d2.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d2.put("Explain (Governmental Health Coverage)", "");


			// -------------------- App 3 --------------------
			TreeMap<String, String> d3 = new TreeMap<>();
			d3.put("I am seeking an advance of", "24500");
			d3.put("Your Full Name", "Test Maëlle Élise Girarnd"); // tweak from list
			d3.put("Date of Birth", "07/28/1991");
			d3.put("Phone Number", "2026139574");
			d3.put("Email", "test.maelle.girarnd.c8t4n2@yopmail.com");
			d3.put("Mailing Street Address", "180 Wellington Street, Unit 1204");
			d3.put("City", "Ottawa");
			d3.put("State", "District of Columbia");

			d3.put("Lawyer's Name", "Test Thierry Beauchêne");
			d3.put("Lawyer's Phone Number", "2026112407");
			d3.put("Law Firm Name", "Capitol Briefworks LLP"); // tweak

			d3.put("When did the accident happen?", "08/04/2024");
			d3.put("Where did the accident happen?", "Washington, DC");
			d3.put("Describe the accident",
			        "Test scenario: Pedestrian incident at a marked crosswalk. The walk signal was on, and a turning vehicle rolled forward, then accelerated unexpectedly. "
			      + "I stepped back but was still clipped on the side, causing me to stumble and fall. Police and EMS responded; I documented witness names and took photos of the intersection. "
			      + "This is intentionally long so the UI gets stressed (wrapping, card height, button spacing, and preview layout after save).\n\n"
			      + "Extra formatting included to test line breaks and consistent rendering.");
			d3.put("Describe the injuries you sustained during the accident",
			        "Ankle sprain, bruised knee, and recurring lower-back pain that worsens after walking. PT started; prolonged standing is difficult.");

			d3.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d3.put("Explain (Other Traumatic Incidents)",
			        "Minor sports strain (hamstring) several months later; no emergency visit. Included to validate YES + explain flow.");
			d3.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
			d3.put("Explain (No Auto Insurance Violation)",
			        "Uncertain due to being listed as an occasional driver under a family policy previously; selecting to cover I DON'T KNOW branch.");
			d3.put("Have you previously received a settlement advance for this case?", "NO");
			d3.put("Explain (Previous Settlement Advance)", "");
			d3.put("Were other people injured in this accident?", "YES");
			d3.put("Explain (Other People Injured)",
			        "A cyclist braked hard to avoid the vehicle and fell; they reported minor abrasions and left after being checked.");
			d3.put("Are you currently behind on child support?", "NO");
			d3.put("Explain (Behind on Child Support)", "");

			d3.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
			d3.put("Explain (Governmental Health Coverage)",
			        "Currently enrolled under a government coverage program; coordination of benefits is in progress. Added to test YES + long explain wrapping and persistence.");


			// -------------------- App 4 --------------------
			TreeMap<String, String> d4 = new TreeMap<>();
			d4.put("I am seeking an advance of", "13250");
			d4.put("Your Full Name", "Test Jules-Antoine Bastien Laframboisee"); // tweak
			d4.put("Date of Birth", "01/19/1990");
			d4.put("Phone Number", "3129814406");
			d4.put("Email", "test.jules.laframboisee.f3q7v9@yopmail.com");
			d4.put("Mailing Street Address", "500 Rue de la Gauchetière Ouest, Suite 2600");
			d4.put("City", "Halifax");
			d4.put("State", "Illinois");

			d4.put("Lawyer's Name", "Test Rosalie Beaulac");
			d4.put("Lawyer's Phone Number", "3129847712");
			d4.put("Law Firm Name", "Keystone Dispute Lab, P.C."); // tweak

			d4.put("When did the accident happen?", "02/15/2025");
			d4.put("Where did the accident happen?", "Chicago, IL");
			d4.put("Describe the accident",
			        "Test scenario: Multi-car chain reaction on an expressway exit ramp during stop-and-go traffic. My vehicle was struck from behind and pushed forward. "
			      + "The impact happened quickly, and I felt a sharp jolt. Police report filed; tow receipt available. "
			      + "Long text inserted to check if the UI preserves spacing, wraps properly, and doesn’t overlap any buttons in the confirmation card.");
			d4.put("Describe the injuries you sustained during the accident",
			        "Upper back spasm, neck stiffness, and jaw soreness. Symptoms worsened next morning; prescribed anti-inflammatory meds and PT referral.");

			d4.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d4.put("Explain (Other Traumatic Incidents)", "");
			d4.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d4.put("Explain (No Auto Insurance Violation)", "");
			d4.put("Have you previously received a settlement advance for this case?", "YES");
			d4.put("Explain (Previous Settlement Advance)",
			        "Small early-stage advance with another provider; included to validate YES path + long explain persistence in saved preview.");
			d4.put("Were other people injured in this accident?", "I DON'T KNOW");
			d4.put("Explain (Other People Injured)",
			        "I saw one driver holding their shoulder, but I did not get a confirmed EMS report regarding others.");
			d4.put("Are you currently behind on child support?", "NO");
			d4.put("Explain (Behind on Child Support)", "");

			d4.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d4.put("Explain (Governmental Health Coverage)", "");


			// -------------------- App 5 --------------------
			TreeMap<String, String> d5 = new TreeMap<>();
			d5.put("I am seeking an advance of", "6400");
			d5.put("Your Full Name", "Test Émile Raymond Boucharrd"); // tweak
			d5.put("Date of Birth", "05/18/1994");
			d5.put("Phone Number", "3057728164");
			d5.put("Email", "test.emile.boucharrd.m8y2h6@yopmail.com");
			d5.put("Mailing Street Address", "1010 Brickell Avenue, Unit 2912");
			d5.put("City", "Winnipeg");
			d5.put("State", "Florida");

			d5.put("Lawyer's Name", "Test Mélissa Lemieaux");
			d5.put("Lawyer's Phone Number", "3057713302");
			d5.put("Law Firm Name", "SunCoast Liability Ateliér"); // tweak

			d5.put("When did the accident happen?", "12/06/2024");
			d5.put("Where did the accident happen?", "Miami, FL");
			d5.put("Describe the accident",
			        "Test scenario: Side-impact at an intersection after the other driver ran a red light. My car spun and hit a curb. "
			      + "Witness contact info recorded, photos taken, and an incident number requested. "
			      + "Long narrative used to test wrapping and whether the UI truncates cleanly or clips content.");
			d5.put("Describe the injuries you sustained during the accident",
			        "Bruised ribs, shoulder strain, and sleep disruption due to pain. Follow-up visits documented; PT recommended.");

			d5.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d5.put("Explain (Other Traumatic Incidents)", "");
			d5.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
			d5.put("Explain (No Auto Insurance Violation)",
			        "Old lapse during a move; policy reinstated same week. Included to validate YES path + long explanation rendering.");
			d5.put("Have you previously received a settlement advance for this case?", "NO");
			d5.put("Explain (Previous Settlement Advance)", "");
			d5.put("Were other people injured in this accident?", "YES");
			d5.put("Explain (Other People Injured)",
			        "Other driver reported neck pain; ambulance arrived. Included to validate long explain save.");
			d5.put("Are you currently behind on child support?", "NO");
			d5.put("Explain (Behind on Child Support)", "");

			d5.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d5.put("Explain (Governmental Health Coverage)",
			        "Coverage status unclear due to recent plan updates and pending confirmation documents. Included to test I DON'T KNOW selection + optional explain persistence.");


			// -------------------- App 6 --------------------
			TreeMap<String, String> d6 = new TreeMap<>();
			d6.put("I am seeking an advance of", "18200");
			d6.put("Your Full Name", "Test Roseline Océanne Desrochèrre"); // tweak
			d6.put("Date of Birth", "09/03/1991");
			d6.put("Phone Number", "6026631159");
			d6.put("Email", "test.roseline.desrocherre.v1p6r2@yopmail.com");
			d6.put("Mailing Street Address", "2400 E Camelback Road, Suite 550");
			d6.put("City", "Québec City");
			d6.put("State", "Arizona");

			d6.put("Lawyer's Name", "Test Laurent Nadeaux");
			d6.put("Lawyer's Phone Number", "6026616634");
			d6.put("Law Firm Name", "Sonoran Docketwright Offices"); // tweak

			d6.put("When did the accident happen?", "06/22/2024");
			d6.put("Where did the accident happen?", "Phoenix, AZ");
			d6.put("Describe the accident",
			        "Test scenario: Trip-and-fall on uneven pavement outside a retail complex. Cracked concrete with no warning. "
			      + "Fell forward, struck knee and palms, swelling started quickly. "
			      + "Added length to test UI behavior: wrapping, saved preview, and no clipping when navigating back and forth.");
			d6.put("Describe the injuries you sustained during the accident",
			        "Knee swelling and pain, abrasions, and wrist tenderness. Imaging ruled out fracture; ortho follow-up suggested if pain persists.");

			d6.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d6.put("Explain (Other Traumatic Incidents)",
			        "Minor shoulder strain while lifting groceries weeks later; no formal visit. Included for YES-path testing.");
			d6.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d6.put("Explain (No Auto Insurance Violation)", "");
			d6.put("Have you previously received a settlement advance for this case?", "NO");
			d6.put("Explain (Previous Settlement Advance)", "");
			d6.put("Were other people injured in this accident?", "NO");
			d6.put("Explain (Other People Injured)", "");
			d6.put("Are you currently behind on child support?", "I DON'T KNOW");
			d6.put("Explain (Behind on Child Support)",
			        "Not sure how the system defines it; selecting for branch coverage and validation behavior.");

			d6.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d6.put("Explain (Governmental Health Coverage)", "");


			// -------------------- App 7 --------------------
			TreeMap<String, String> d7 = new TreeMap<>();
			d7.put("I am seeking an advance of", "9900");
			d7.put("Your Full Name", "Test Siobhán Mairéad O’Riellynee"); // tweak
			d7.put("Date of Birth", "12/27/1988");
			d7.put("Phone Number", "2065407811");
			d7.put("Email", "test.siobhan.oriellynee.h6t5s1@yopmail.com");
			d7.put("Mailing Street Address", "701 5th Avenue, Floor 44");
			d7.put("City", "Calgary");
			d7.put("State", "Washington");

			d7.put("Lawyer's Name", "Test Érika Chartierr");
			d7.put("Lawyer's Phone Number", "2065429016");
			d7.put("Law Firm Name", "Cascade Claimcraft Legal Studios"); // tweak

			d7.put("When did the accident happen?", "09/09/2024");
			d7.put("Where did the accident happen?", "Seattle, WA");
			d7.put("Describe the accident",
			        "Test scenario: Bicycle lane incident where a parked car door opened into my path. Limited reaction time. I fell and scraped arms and shoulder. "
			      + "Long description to validate card design, truncation behavior, and whether spacing remains consistent on mobile widths.");
			d7.put("Describe the injuries you sustained during the accident",
			        "Shoulder strain, abrasions, and wrist pain when lifting objects. Clinic visit documented; PT recommended.");

			d7.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d7.put("Explain (Other Traumatic Incidents)", "");
			d7.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d7.put("Explain (No Auto Insurance Violation)", "");
			d7.put("Have you previously received a settlement advance for this case?", "NO");
			d7.put("Explain (Previous Settlement Advance)", "");
			d7.put("Were other people injured in this accident?", "NO");
			d7.put("Explain (Other People Injured)", "");
			d7.put("Are you currently behind on child support?", "NO");
			d7.put("Explain (Behind on Child Support)", "");

			d7.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d7.put("Explain (Governmental Health Coverage)",
			        "Not certain whether current plan qualifies as government coverage; included to test I DON'T KNOW + optional explanation handling.");


			// -------------------- App 8 --------------------
			TreeMap<String, String> d8 = new TreeMap<>();
			d8.put("I am seeking an advance of", "22300");
			d8.put("Your Full Name", "Test Kateri Noélie Wapistann"); // tweak
			d8.put("Date of Birth", "03/11/1993");
			d8.put("Phone Number", "3036604428");
			d8.put("Email", "test.kateri.wapistann.r4x8q2@yopmail.com");
			d8.put("Mailing Street Address", "1700 Lincoln Street, Suite 2100");
			d8.put("City", "Vancouver");
			d8.put("State", "Colorado");

			d8.put("Lawyer's Name", "Test Réjean Vermettte");
			d8.put("Lawyer's Phone Number", "3036611188");
			d8.put("Law Firm Name", "FrontRange Trial Mechanix"); // tweak

			d8.put("When did the accident happen?", "01/18/2025");
			d8.put("Where did the accident happen?", "Denver, CO");
			d8.put("Describe the accident",
			        "Test scenario: Worksite trip caused by a loose cable near a loading area. I fell and struck elbow and hip. "
			      + "Incident reported immediately; log created. This text is long to test layout stability across steps, saved preview behavior, and card boundaries.");
			d8.put("Describe the injuries you sustained during the accident",
			        "Elbow swelling, bruised hip, and lower back stiffness. Imaging pending; follow-up scheduled.");

			d8.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
			d8.put("Explain (Other Traumatic Incidents)",
			        "Not sure if a prior minor fall counts; selecting to validate I DON'T KNOW logic and UI state.");
			d8.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d8.put("Explain (No Auto Insurance Violation)", "");
			d8.put("Have you previously received a settlement advance for this case?", "YES");
			d8.put("Explain (Previous Settlement Advance)",
			        "Prior advance received; verifying the form stores long explanation and preserves it after navigation and refresh.");
			d8.put("Were other people injured in this accident?", "NO");
			d8.put("Explain (Other People Injured)", "");
			d8.put("Are you currently behind on child support?", "NO");
			d8.put("Explain (Behind on Child Support)", "");

			d8.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "YES");
			d8.put("Explain (Governmental Health Coverage)",
			        "Enrolled in a government coverage program; benefits coordination is being reviewed. Included to test YES + long explain render and persistence.");


			// -------------------- App 9 --------------------
			TreeMap<String, String> d9 = new TreeMap<>();
			d9.put("I am seeking an advance of", "11400");
			d9.put("Your Full Name", "Test Frédéric Louis Diohn"); // tweak
			d9.put("Date of Birth", "08/08/1990");
			d9.put("Phone Number", "6177712389");
			d9.put("Email", "test.frederic.diohn.n9m4b2@yopmail.com");
			d9.put("Mailing Street Address", "200 Clarendon Street, Suite 1800");
			d9.put("City", "Saskatoon");
			d9.put("State", "Massachusetts");

			d9.put("Lawyer's Name", "Test Céline Beaulieuu");
			d9.put("Lawyer's Phone Number", "6177707729");
			d9.put("Law Firm Name", "BayState Casebuilderz"); // tweak

			d9.put("When did the accident happen?", "04/03/2024");
			d9.put("Where did the accident happen?", "Boston, MA");
			d9.put("Describe the accident",
			        "Test scenario: Public transit sudden stop caused me to lose balance and fall into a pole. No warning announcement. "
			      + "Transit report requested. Intentionally long text to test textarea resizing, saved summary display, and no clipping on tight UI.");
			d9.put("Describe the injuries you sustained during the accident",
			        "Wrist sprain, bruised ribs, and shoulder pain with lifting. Follow-up noted limited range of motion.");

			d9.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
			d9.put("Explain (Other Traumatic Incidents)", "");
			d9.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
			d9.put("Explain (No Auto Insurance Violation)", "");
			d9.put("Have you previously received a settlement advance for this case?", "NO");
			d9.put("Explain (Previous Settlement Advance)", "");
			d9.put("Were other people injured in this accident?", "YES");
			d9.put("Explain (Other People Injured)",
			        "Another passenger fell near the rear door and mentioned shoulder pain. Included to validate long explain persistence.");
			d9.put("Are you currently behind on child support?", "NO");
			d9.put("Explain (Behind on Child Support)", "");

			d9.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "NO");
			d9.put("Explain (Governmental Health Coverage)", "");


			// -------------------- App 10 --------------------
			TreeMap<String, String> d10 = new TreeMap<>();
			d10.put("I am seeking an advance of", "17650");
			d10.put("Your Full Name", "Test Zoé Aurore Poirierx"); // tweak
			d10.put("Date of Birth", "06/25/1992");
			d10.put("Phone Number", "7026609305");
			d10.put("Email", "test.zoe.poirierx.p7v8k2@yopmail.com");
			d10.put("Mailing Street Address", "777 S Grand Central Parkway, Unit 1903");
			d10.put("City", "Edmonton");
			d10.put("State", "Nevada");

			d10.put("Lawyer's Name", "Test Édith Chartreuxx");
			d10.put("Lawyer's Phone Number", "7026617701");
			d10.put("Law Firm Name", "VerdictForge Litigation Atelierr"); // tweak

			d10.put("When did the accident happen?", "07/29/2024");
			d10.put("Where did the accident happen?", "Las Vegas, NV");
			d10.put("Describe the accident",
			        "Test scenario: Parking lot collision while reversing. Other vehicle backed out at the same time; impact to the rear quarter panel. "
			      + "Photos taken; security cameras may exist. Using a long description to stress the UI, including multiple sentences and deliberate formatting.\n\n"
			      + "Goal: verify no overflow, no broken borders, consistent spacing, and proper truncation on summary cards.");
			d10.put("Describe the injuries you sustained during the accident",
			        "Neck stiffness and headache later that day, plus mild nausea. Clinic visit recorded; conservative treatment with rest and anti-inflammatories.");

			d10.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
			d10.put("Explain (Other Traumatic Incidents)",
			        "Minor fall while climbing stairs post-accident; no ER visit. Included to validate YES + long explain retention.");
			d10.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
			d10.put("Explain (No Auto Insurance Violation)",
			        "Not sure; policy history split across provinces/insurers. Selecting for branch coverage.");
			d10.put("Have you previously received a settlement advance for this case?", "NO");
			d10.put("Explain (Previous Settlement Advance)", "");
			d10.put("Were other people injured in this accident?", "NO");
			d10.put("Explain (Other People Injured)", "");
			d10.put("Are you currently behind on child support?", "NO");
			d10.put("Explain (Behind on Child Support)", "");

			d10.put("Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?", "I DON'T KNOW");
			d10.put("Explain (Governmental Health Coverage)",
			        "Not sure whether prior enrollment is still active; pending confirmation from the agency. Included to test optional explain persistence and UI wrapping.");

	        return new Object[][]{
	                { d1 }, { d2 }, { d3 }, { d4 }, { d5 },
	                { d6 }, { d7 }, { d8 }, { d9 }, { d10 } 
	        };
	    }
		
		
		
		
		
		
		
		
	}
	
	
	


