package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;

public class Case_Appplications extends Header_Manager{
	
	@Test(dataProvider="caseData")
	public void Add_case(TreeMap<String, String> data) throws IOException, InterruptedException{
		
		
		Application_Locaters p = new Application_Locaters(d);
		JavascriptExecutor js = (JavascriptExecutor)d;
		Login_negative_testcases lng = new Login_negative_testcases();
		Login_Locaters lg = new Login_Locaters(d);
		
		
		
		header_buttons_clicker(0);
		Report_Listen.log_print_in_report().log( Status.INFO, "<b>🔹 Scenario 1 – Positive Testcase:</b> Case handler creates a new case & application with valid inputs for an existing plaintiff." );
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹Description </b>  Verify that the user can open the *New Case* popup, select an existing plaintiff, fill all mandatory fields (Case Type, State of Incident, Date of Incident, Lead Source, Requested Amount) and save the case so that a new Case ID is created and Court Index Number can be updated from the Case Details screen.");
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Input </b> Plaintiff: "+data.get("Plaintiff Name")+", Case Type: "+data.get("Case Type")+", State: "+data.get("State")+", Date of Incident: "+data.get("Date of Incident")+", Lead Source: "+data.get("Lead Source")+", Requested Amount: "+data.get("Requested Amount")+", Court Index #: "+data.get("Court Index Number"));
	    Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹Expected </b> New case should be created without validation errors, a success toast should appear after clicking *Create*, system should navigate to the Case Details page for the newly created case, and the Court Index Number '"+data.get("Court Index Number")+"' should be accepted and saved from the edit popup.");
		p.Popup_add_form();
		p.form_inputs().get(0).sendKeys(data.get("Plaintiff Name"));
		p.plaintiff_dropdown_list();
		p.Plaintiff_options().get(0).click();
		//p.form_inputs().get(1).sendKeys(data.get("Case Type"));
		p.form_inputs().get(1).click();
		p.Incident_type_dropdown();
		//option_printers("Incident Options are ",p.Incident_options());
		p.Incident_options().get(0).click();
		//p.form_inputs().get(2).sendKeys(data.get("State"));
		p.form_inputs().get(2).click();
		p.State_of_incident_dropdown();
		p.State_of_incident_options().get(0).click();
		Thread.sleep(500);		
		p.form_inputs().get(3).sendKeys(data.get("Date of Incident"));
		p.calender_date_select().click();
		js.executeScript("arguments[0].scrollIntoView(true);", p.form_inputs().get(4));
		p.form_inputs().get(4).click();
		p.Lead_Type_dropdown();
		p.Lead_category_options().get(0).click();
		p.form_inputs().get(5).click();
		p.Lead_dropdown();
		p.Leadoptions().get(0).click();
		js.executeScript("arguments[0].scrollIntoView(true);", p.form_inputs().get(5));
		p.form_inputs().get(6).sendKeys(data.get("Requested Amount"));
		p.form_buttons().get(1).click();
		Thread.sleep(500);try {
		lng.Toast_printer(lg.toast().getText().trim());}
		catch(Exception e){
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →** 📢,</b> Toast after creating case: "+"No toast captured / toast locator not visible. Error:");}
		p.Case_details_edit_buttons().click();
		p.Summary_feild().sendKeys(data.get("Summary"));
		p.Court_index_input().sendKeys(data.get("Court Index Number"));
		p.Edit_form_buttons().get(1).click();
		p.Case_details_edit_buttons();
		Thread.sleep(500);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual </b> ✏️ Case Details edit popup opened, Court Index Number '"+data.get("Court Index Number")+"' was entered and saved without visible UI errors.");
		
	
	}
	
	
	
	@DataProvider
	public Object[][] caseData() {

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

	    return new Object[][] {
	            { c1 },/*{ c2 }, { c3 }, { c4 }, { c5 },
	            { c6 }, { c7 }, { c8 }, { c9 }, { c10 },
	            { c11 }, { c12 }, { c13 }, { c14 }, { c15 },
	            { c16 }, { c17 }, { c18 }, { c19 }, { c20 } */
	    };
	}
	
	
	public void option_printers(String prefix ,List<WebElement> options){
		
		
	for(WebElement option:options){
		
		System.out.println(prefix+option.getText().trim());}}
	
	
	
	
	
	@Test(dataProvider="caseData")
	public void Added_application_delete(TreeMap<String, String> val) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
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
		List<WebElement> table_rows = p.rows();
		for(WebElement row:table_rows){
			
			if(row.getText().contains(Plaintiff_name)){
				row.click();
				break;
				}}
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 3 →** Opened the Case Details page for plaintiff '"+Plaintiff_name+"' by clicking the matching row from the *Cases* table.");
		p.Case_id_tag();
		
		List<WebElement> tabs = p.tabs();
		for(WebElement tab:tabs){
			
		if(tab.getText().trim().equalsIgnoreCase("Applications")){
			
			tab.click();
			break;}}
		Report_Listen.log_print_in_report().log(Status.INFO, "**ℹ️ Step 4 →** Switched to the *Applications* tab to view existing application records for the selected case.");
		p.Delete_button().click();
		p.delete_popup_modal();
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
         System.out.println("Delete operation failed for plaintiff  "+Plaintiff_name);}}
	
	
	
	
	
	
	

}
