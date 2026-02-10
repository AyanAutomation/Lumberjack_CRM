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
		List<WebElement> first_question_block_buttons = p.First_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			first_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			first_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			first_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> second_question_block_buttons = p.second_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			second_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			second_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			second_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> Third_question_block_buttons = p.Third_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			Third_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			Third_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			Third_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> fourth_question_block_buttons = p.Fourth_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			fourth_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			fourth_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			fourth_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> fifth_question_block_buttons = p.Fifth_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			fifth_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			fifth_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			fifth_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> Sixth_question_block_buttons = p.sixth_questions_buttons();
		if(injuredOtherTraumatic.contains("YES")){
			Sixth_question_block_buttons.get(1).click();}
		if(injuredOtherTraumatic.contains("NO")){
			Sixth_question_block_buttons.get(0).click();}
		if(injuredOtherTraumatic.contains("I DON'T KNOW")){
			Sixth_question_block_buttons.get(2).click();
			p.healthcare_enrollment_explain().sendKeys(null);}
		List<WebElement> Third_form_Buttons= p.below_buttons();
		WebElement third_form_next_button = Third_form_Buttons.get(1);
		rp.movetoelement(third_form_next_button);
		third_form_next_button.click();
		
	}
		
		@DataProvider
	    public Object[][] applyNowData() {

	        // -------------------- App 1 --------------------
	        TreeMap<String, String> d1 = new TreeMap<>();
	        d1.put("I am seeking an advance of", "15000");
	        d1.put("Your Full Name", "Test Aiden MacLeod");
	        d1.put("Date of Birth", "02/14/1992");
	        d1.put("Phone Number", "6469013728");
	        d1.put("Email", "test.aiden.macleod.7q4m1@yopmail.com");
	        d1.put("Mailing Street Address", "88 Bloor Street West, Unit 1206");
	        d1.put("City", "Toronto");
	        d1.put("State", "New York");

	        d1.put("Lawyer's Name", "Test Claire Ouellet");
	        d1.put("Lawyer's Phone Number", "6469031184");
	        d1.put("Law Firm Name", "Test Northlake Counsel Group");

	        d1.put("When did the accident happen?", "10/12/2024");
	        d1.put("Where did the accident happen?", "Buffalo, NY");
	        d1.put("Describe the accident",
	                "Test scenario: Rear-end collision in slow traffic during light rain. The vehicle behind failed to stop and pushed my car into the vehicle ahead. "
	              + "Airbags did not deploy, but the impact caused a sharp forward jerk. Police attended, a report number was provided, and photos were taken from multiple angles. "
	              + "There were passengers in my car; everyone was shaken. The other driver admitted distraction, but later claimed I stopped abruptly. "
	              + "This description is intentionally long to test wrapping, card height expansion, and whether the UI breaks or overlaps adjacent components.\n\n"
	              + "Extra details: timestamps, lane notes, weather notes, and quote-style paragraphs to test rendering across devices.");
	        d1.put("Describe the injuries you sustained during the accident",
	                "Neck pain (whiplash), headache, mild lower back strain, and intermittent shoulder tingling. Urgent care visit documented. "
	              + "Physio recommended. Testing long text + line breaks.\nFollow-up may require MRI if symptoms persist.");

	        d1.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
	        d1.put("Explain (Other Traumatic Incidents)", "");
	        d1.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d1.put("Explain (No Auto Insurance Violation)", "");
	        d1.put("Have you previously received a settlement advance for this case?", "NO");
	        d1.put("Explain (Previous Settlement Advance)", "");
	        d1.put("Were other people injured in this accident?", "YES");
	        d1.put("Explain (Other People Injured)",
	                "Passenger reported wrist pain and was evaluated at a walk-in clinic. No fractures, but follow-up imaging was suggested.");
	        d1.put("Are you currently behind on child support?", "I DON'T KNOW");
	        d1.put("Explain (Behind on Child Support)",
	                "Selecting 'I DON'T KNOW' for test coverage of conditional logic and server-side validation.");

	        // -------------------- App 2 --------------------
	        TreeMap<String, String> d2 = new TreeMap<>();
	        d2.put("I am seeking an advance of", "8000");
	        d2.put("Your Full Name", "Test Éloïse Tremblay");
	        d2.put("Date of Birth", "11/06/1989");
	        d2.put("Phone Number", "7187742069");
	        d2.put("Email", "test.eloise.tremblay.k2v9p@yopmail.com");
	        d2.put("Mailing Street Address", "2210 Rue Sainte-Catherine Ouest, Apt 8C");
	        d2.put("City", "Montréal");
	        d2.put("State", "New Jersey");

	        d2.put("Lawyer's Name", "Test Jordan Sinclair");
	        d2.put("Lawyer's Phone Number", "7187719983");
	        d2.put("Law Firm Name", "Test Harbour & Alder Law");

	        d2.put("When did the accident happen?", "03/05/2025");
	        d2.put("Where did the accident happen?", "Newark, NJ");
	        d2.put("Describe the accident",
	                "Slip-and-fall inside a building lobby where the floor was recently mopped and signage was unclear. "
	              + "Fell backward while turning, braced with right hand, and lightly struck the back of head. "
	              + "Security footage requested. Long narrative to test textarea growth and save preview layout.");
	        d2.put("Describe the injuries you sustained during the accident",
	                "Sprained right wrist, bruised hip, dizziness and nausea consistent with mild concussion symptoms. ER visit documented. "
	              + "Rest, limited screen time, and follow-up advised.");

	        d2.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
	        d2.put("Explain (Other Traumatic Incidents)",
	                "Minor low-speed fender-bender two months later. No medical visit. Added purely to test conditional capture + display.");
	        d2.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d2.put("Explain (No Auto Insurance Violation)", "");
	        d2.put("Have you previously received a settlement advance for this case?", "I DON'T KNOW");
	        d2.put("Explain (Previous Settlement Advance)",
	                "Unsure; no paperwork available at the moment. Selecting this for test coverage.");
	        d2.put("Were other people injured in this accident?", "NO");
	        d2.put("Explain (Other People Injured)", "");
	        d2.put("Are you currently behind on child support?", "NO");
	        d2.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 3 --------------------
	        TreeMap<String, String> d3 = new TreeMap<>();
	        d3.put("I am seeking an advance of", "25000");
	        d3.put("Your Full Name", "Test Rowan Chenier");
	        d3.put("Date of Birth", "07/22/1991");
	        d3.put("Phone Number", "2029186457");
	        d3.put("Email", "test.rowan.chenier.9x7td@yopmail.com");
	        d3.put("Mailing Street Address", "1400 14th Street NW, Unit 506");
	        d3.put("City", "Ottawa");
	        d3.put("State", "District of Columbia");

	        d3.put("Lawyer's Name", "Test Priya Desrosiers");
	        d3.put("Lawyer's Phone Number", "2029151028");
	        d3.put("Law Firm Name", "Test Capital Bridge Injury Law");

	        d3.put("When did the accident happen?", "08/19/2024");
	        d3.put("Where did the accident happen?", "Washington, DC");
	        d3.put("Describe the accident",
	                "Pedestrian struck at a crosswalk by a turning vehicle. Walk signal was on. Driver slowed then accelerated unexpectedly. "
	              + "Police and EMS attended. Long description to stress UI components, especially the saved card and any truncation/ellipsis behavior.");
	        d3.put("Describe the injuries you sustained during the accident",
	                "Knee contusion, ankle sprain, recurring lower-back pain. PT started; prolonged standing is difficult.");

	        d3.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
	        d3.put("Explain (Other Traumatic Incidents)", "");
	        d3.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
	        d3.put("Explain (No Auto Insurance Violation)", "Uncertain due to being listed as an occasional driver previously; selecting for test coverage.");
	        d3.put("Have you previously received a settlement advance for this case?", "NO");
	        d3.put("Explain (Previous Settlement Advance)", "");
	        d3.put("Were other people injured in this accident?", "YES");
	        d3.put("Explain (Other People Injured)", "A cyclist nearby fell while avoiding the vehicle; reported minor abrasions.");
	        d3.put("Are you currently behind on child support?", "NO");
	        d3.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 4 --------------------
	        TreeMap<String, String> d4 = new TreeMap<>();
	        d4.put("I am seeking an advance of", "12000");
	        d4.put("Your Full Name", "Test Maeve O'Rourke");
	        d4.put("Date of Birth", "01/09/1990");
	        d4.put("Phone Number", "3127604189");
	        d4.put("Email", "test.maeve.orourke.q8n2z@yopmail.com");
	        d4.put("Mailing Street Address", "500 Rue de la Gauchetière Ouest, Suite 2400");
	        d4.put("City", "Halifax");
	        d4.put("State", "Illinois");

	        d4.put("Lawyer's Name", "Test Simon Beaulieu");
	        d4.put("Lawyer's Phone Number", "3127609907");
	        d4.put("Law Firm Name", "Test Lakefront Trial Chambers");

	        d4.put("When did the accident happen?", "02/07/2025");
	        d4.put("Where did the accident happen?", "Chicago, IL");
	        d4.put("Describe the accident",
	                "Multi-car chain reaction on expressway exit ramp. My vehicle was hit from behind and pushed forward. "
	              + "Traffic was stop-and-go; visibility fair. Police report filed; tow receipt available. "
	              + "Using extra-long text to check alignment, scrolling, and whether the form layout stays stable on save/next steps.");
	        d4.put("Describe the injuries you sustained during the accident",
	                "Upper back spasm, neck stiffness, and jaw soreness. Symptoms worsened next morning. Prescribed anti-inflammatory meds and physio referral.");

	        d4.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
	        d4.put("Explain (Other Traumatic Incidents)", "");
	        d4.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d4.put("Explain (No Auto Insurance Violation)", "");
	        d4.put("Have you previously received a settlement advance for this case?", "YES");
	        d4.put("Explain (Previous Settlement Advance)",
	                "Small prior advance from another funder in early stage; adding details to verify long saved explanations do not break cards or overflow.");
	        d4.put("Were other people injured in this accident?", "I DON'T KNOW");
	        d4.put("Explain (Other People Injured)",
	                "I saw one driver holding their shoulder, but I did not get confirmation from EMS or police on others' injuries.");
	        d4.put("Are you currently behind on child support?", "NO");
	        d4.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 5 --------------------
	        TreeMap<String, String> d5 = new TreeMap<>();
	        d5.put("I am seeking an advance of", "6000");
	        d5.put("Your Full Name", "Test Luc Morissette");
	        d5.put("Date of Birth", "05/18/1994");
	        d5.put("Phone Number", "3059187746");
	        d5.put("Email", "test.luc.morissette.m4h7c@yopmail.com");
	        d5.put("Mailing Street Address", "1010 Brickell Avenue, Unit 2912");
	        d5.put("City", "Winnipeg");
	        d5.put("State", "Florida");

	        d5.put("Lawyer's Name", "Test Danielle Lacroix");
	        d5.put("Lawyer's Phone Number", "3059173302");
	        d5.put("Law Firm Name", "Test Meridian Injury Partners");

	        d5.put("When did the accident happen?", "12/01/2024");
	        d5.put("Where did the accident happen?", "Miami, FL");
	        d5.put("Describe the accident",
	                "Side-impact at an intersection after another driver ran a red light. My car spun and hit a curb. "
	              + "Witness contact info recorded. This paragraph is purposely long to test responsive behavior and whether the notes/cards truncate cleanly.");
	        d5.put("Describe the injuries you sustained during the accident",
	                "Bruised ribs, shoulder strain, and sleep disruption due to pain. Follow-up visits documented; PT recommended.");

	        d5.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
	        d5.put("Explain (Other Traumatic Incidents)", "");
	        d5.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "YES");
	        d5.put("Explain (No Auto Insurance Violation)",
	                "Old lapse during a move; policy reinstated same week. Adding this to test long explain + YES selection handling.");
	        d5.put("Have you previously received a settlement advance for this case?", "NO");
	        d5.put("Explain (Previous Settlement Advance)", "");
	        d5.put("Were other people injured in this accident?", "YES");
	        d5.put("Explain (Other People Injured)",
	                "Other driver reported neck pain at scene; ambulance arrived. Including details to validate long text save.");
	        d5.put("Are you currently behind on child support?", "NO");
	        d5.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 6 --------------------
	        TreeMap<String, String> d6 = new TreeMap<>();
	        d6.put("I am seeking an advance of", "18000");
	        d6.put("Your Full Name", "Test Noémie Gagnon");
	        d6.put("Date of Birth", "09/03/1991");
	        d6.put("Phone Number", "6027741159");
	        d6.put("Email", "test.noemie.gagnon.v6p2r@yopmail.com");
	        d6.put("Mailing Street Address", "2400 E Camelback Road, Suite 550");
	        d6.put("City", "Québec City");
	        d6.put("State", "Arizona");

	        d6.put("Lawyer's Name", "Test Ethan Charbonneau");
	        d6.put("Lawyer's Phone Number", "6027726634");
	        d6.put("Law Firm Name", "Test Sonoran Case Counsel");

	        d6.put("When did the accident happen?", "06/22/2024");
	        d6.put("Where did the accident happen?", "Phoenix, AZ");
	        d6.put("Describe the accident",
	                "Trip-and-fall on uneven pavement outside a retail complex. The area had cracked concrete and no visible warning. "
	              + "Fell forward, struck knee and palms, and had immediate swelling. Added length for UI stress testing, including multi-sentence paragraphs and punctuation-heavy content.");
	        d6.put("Describe the injuries you sustained during the accident",
	                "Knee swelling and pain, abrasion wounds, and wrist tenderness. Imaging ruled out fracture. Follow-up with orthopedics suggested if pain persists.");

	        d6.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
	        d6.put("Explain (Other Traumatic Incidents)",
	                "Separate minor sports strain after the accident; listed for testing long explain text and storage.");
	        d6.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d6.put("Explain (No Auto Insurance Violation)", "");
	        d6.put("Have you previously received a settlement advance for this case?", "NO");
	        d6.put("Explain (Previous Settlement Advance)", "");
	        d6.put("Were other people injured in this accident?", "NO");
	        d6.put("Explain (Other People Injured)", "");
	        d6.put("Are you currently behind on child support?", "I DON'T KNOW");
	        d6.put("Explain (Behind on Child Support)",
	                "Not sure about the system’s definition; choosing for test coverage.");

	        // -------------------- App 7 --------------------
	        TreeMap<String, String> d7 = new TreeMap<>();
	        d7.put("I am seeking an advance of", "9500");
	        d7.put("Your Full Name", "Test Kieran Levesque");
	        d7.put("Date of Birth", "12/27/1988");
	        d7.put("Phone Number", "2068815407");
	        d7.put("Email", "test.kieran.levesque.h9t5s@yopmail.com");
	        d7.put("Mailing Street Address", "701 5th Avenue, Floor 44");
	        d7.put("City", "Calgary");
	        d7.put("State", "Washington");

	        d7.put("Lawyer's Name", "Test Mira Bouchard");
	        d7.put("Lawyer's Phone Number", "2068829016");
	        d7.put("Law Firm Name", "Test Cascade Legal Associates");

	        d7.put("When did the accident happen?", "09/09/2024");
	        d7.put("Where did the accident happen?", "Seattle, WA");
	        d7.put("Describe the accident",
	                "Bicycle collision with a car door opening into the bike lane. I was riding at moderate speed and had limited time to react. "
	              + "I fell and scraped my arms and shoulder. Purposefully long to validate card design, responsive behavior, and saved content preview truncation.");
	        d7.put("Describe the injuries you sustained during the accident",
	                "Shoulder strain, deep abrasions, and persistent wrist pain when lifting objects. Clinic visit documented; PT recommended.");

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

	        // -------------------- App 8 --------------------
	        TreeMap<String, String> d8 = new TreeMap<>();
	        d8.put("I am seeking an advance of", "22000");
	        d8.put("Your Full Name", "Test Amélie Fortin");
	        d8.put("Date of Birth", "03/11/1993");
	        d8.put("Phone Number", "3037716642");
	        d8.put("Email", "test.amelie.fortin.r3x8q@yopmail.com");
	        d8.put("Mailing Street Address", "1700 Lincoln Street, Suite 2100");
	        d8.put("City", "Vancouver");
	        d8.put("State", "Colorado");

	        d8.put("Lawyer's Name", "Test Olivier Martel");
	        d8.put("Lawyer's Phone Number", "3037701188");
	        d8.put("Law Firm Name", "Test FrontRange Litigation Desk");

	        d8.put("When did the accident happen?", "01/18/2025");
	        d8.put("Where did the accident happen?", "Denver, CO");
	        d8.put("Describe the accident",
	                "Worksite incident: a loose cable caused a trip near a loading area. I fell and struck my elbow and hip. "
	              + "Reported immediately; incident log created. Long text inserted to test layout across multiple steps and ensure no clipping or horizontal scroll appears.");
	        d8.put("Describe the injuries you sustained during the accident",
	                "Elbow swelling, bruised hip, and lower back stiffness. Imaging pending; follow-up scheduled.");

	        d8.put("Since your accident, have you been injured in any other traumatic incidents?", "I DON'T KNOW");
	        d8.put("Explain (Other Traumatic Incidents)",
	                "Not sure if a prior minor fall counts; selecting to validate 'I DON'T KNOW' behavior.");
	        d8.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d8.put("Explain (No Auto Insurance Violation)", "");
	        d8.put("Have you previously received a settlement advance for this case?", "YES");
	        d8.put("Explain (Previous Settlement Advance)",
	                "Advance received previously; verifying if the form accepts long explanation and preserves text exactly after navigation.");
	        d8.put("Were other people injured in this accident?", "NO");
	        d8.put("Explain (Other People Injured)", "");
	        d8.put("Are you currently behind on child support?", "NO");
	        d8.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 9 --------------------
	        TreeMap<String, String> d9 = new TreeMap<>();
	        d9.put("I am seeking an advance of", "11000");
	        d9.put("Your Full Name", "Test Félix Côté");
	        d9.put("Date of Birth", "08/08/1990");
	        d9.put("Phone Number", "6179023481");
	        d9.put("Email", "test.felix.cote.n7m4b@yopmail.com");
	        d9.put("Mailing Street Address", "200 Clarendon Street, Suite 1800");
	        d9.put("City", "Saskatoon");
	        d9.put("State", "Massachusetts");

	        d9.put("Lawyer's Name", "Test Renée Paquette");
	        d9.put("Lawyer's Phone Number", "6179057729");
	        d9.put("Law Firm Name", "Test BayState Injury Counsel");

	        d9.put("When did the accident happen?", "04/03/2024");
	        d9.put("Where did the accident happen?", "Boston, MA");
	        d9.put("Describe the accident",
	                "Public transit incident: sudden stop caused me to lose balance and fall against a pole. No warning announcement. "
	              + "Transit report requested. Text intentionally long to test textarea resize and saved summary display under tight UI constraints.");
	        d9.put("Describe the injuries you sustained during the accident",
	                "Wrist sprain, bruised ribs, and lingering shoulder pain with lifting. Follow-up visit noted limited range of motion.");

	        d9.put("Since your accident, have you been injured in any other traumatic incidents?", "NO");
	        d9.put("Explain (Other Traumatic Incidents)", "");
	        d9.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "NO");
	        d9.put("Explain (No Auto Insurance Violation)", "");
	        d9.put("Have you previously received a settlement advance for this case?", "NO");
	        d9.put("Explain (Previous Settlement Advance)", "");
	        d9.put("Were other people injured in this accident?", "YES");
	        d9.put("Explain (Other People Injured)",
	                "Another passenger fell near the rear door; they mentioned shoulder pain. Including to test long explain storage.");
	        d9.put("Are you currently behind on child support?", "NO");
	        d9.put("Explain (Behind on Child Support)", "");

	        // -------------------- App 10 --------------------
	        TreeMap<String, String> d10 = new TreeMap<>();
	        d10.put("I am seeking an advance of", "17500");
	        d10.put("Your Full Name", "Test Chloé Deschamps");
	        d10.put("Date of Birth", "06/25/1992");
	        d10.put("Phone Number", "7028816305");
	        d10.put("Email", "test.chloe.deschamps.p5v8k@yopmail.com");
	        d10.put("Mailing Street Address", "777 S Grand Central Parkway, Unit 1903");
	        d10.put("City", "Edmonton");
	        d10.put("State", "Nevada");

	        d10.put("Lawyer's Name", "Test Gabriel Fournier");
	        d10.put("Lawyer's Phone Number", "7028847701");
	        d10.put("Law Firm Name", "Test Desert Ridge Trial Group");

	        d10.put("When did the accident happen?", "07/29/2024");
	        d10.put("Where did the accident happen?", "Las Vegas, NV");
	        d10.put("Describe the accident",
	                "Parking lot collision while reversing. Other vehicle backed out at the same time; impact to rear quarter panel. "
	              + "Photos taken; security cameras may exist. Long description to stress UI, including multiple sentences and deliberate formatting.\n\n"
	              + "Goal: verify no overflow, no broken borders, and consistent spacing when saved and displayed on any summary/preview card.");
	        d10.put("Describe the injuries you sustained during the accident",
	                "Neck stiffness, headache starting later that day, and mild nausea. Clinic visit recorded; conservative treatment with rest and anti-inflammatories.");

	        d10.put("Since your accident, have you been injured in any other traumatic incidents?", "YES");
	        d10.put("Explain (Other Traumatic Incidents)",
	                "Minor fall while climbing stairs post-accident; no ER visit. Included to test data retention across steps.");
	        d10.put("In the 5 years before the accident, did you have a violation for no auto insurance?", "I DON'T KNOW");
	        d10.put("Explain (No Auto Insurance Violation)",
	                "Not sure; policy history split across provinces/insurers. Selecting for test coverage.");
	        d10.put("Have you previously received a settlement advance for this case?", "NO");
	        d10.put("Explain (Previous Settlement Advance)", "");
	        d10.put("Were other people injured in this accident?", "NO");
	        d10.put("Explain (Other People Injured)", "");
	        d10.put("Are you currently behind on child support?", "NO");
	        d10.put("Explain (Behind on Child Support)", "");

	        return new Object[][]{
	                { d1 },/* { d2 }, { d3 }, { d4 }, { d5 },
	                { d6 }, { d7 }, { d8 }, { d9 }, { d10 }*/
	        };
	    }
		
		
		
		
		
		
		
		
	}
	
	
	


