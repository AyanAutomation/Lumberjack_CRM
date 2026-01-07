package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Plaintiff_Module extends Case_Appplications{
	
	@Test(dataProvider="plaintiffData")
	public void Plaintiff_Add(TreeMap<String,String> data) throws IOException, InterruptedException{

		SIde_Menu_Handler sd=new SIde_Menu_Handler();
		Plaintiff_Locaters p=new Plaintiff_Locaters(d);
		Repeat rp=new Repeat(d);
		Login_Locaters lg=new Login_Locaters(d);

		int step=1;

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario Title:</b> Add New Plaintiff with Valid Details");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description:</b> User opens Plaintiffs module from side menu, fills all mandatory plaintiff details (name, contact, DOB, state/zip, address) and submits the form to create a new plaintiff profile.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input:</b> FirstName="+data.get("First Name")+", MiddleName="+data.get("Middle Name")+", LastName="+data.get("Last Name")+", Suffix="+data.get("Name Suffix")+", Email="+data.get("Email")+", SSN="+data.get("Social Security Number")+", Phone="+data.get("Phone number")+", DOB="+data.get("Date of Birth")+", State="+data.get("State")+", Zip="+data.get("Zip code")+", Address1="+data.get("Address Line 1")+", Address2="+data.get("Address Line 2"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected:</b> System should create the plaintiff without validation errors and show a success toast. Newly created plaintiff should be visible in the plaintiff list or profile view.");

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Open Plaintiffs module from side menu.");
		sd.Side_menu_option_clicker("Plaintiffs",d,"N/A");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Clicked Plaintiffs option in side menu.");

		Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Verify user landed inside Plaintiffs module.");
		p.landed_in_plaintiff_module();
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Plaintiffs module landing verification executed.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Scroll to Add Plaintiff form.");
		rp.Scroll_to_element(p.form());
		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Add Plaintiff form is in view.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Name fields (First, Middle, Last, Suffix).");
		List<WebElement> input_feilds=p.inputs();
		input_feilds.get(0).sendKeys(data.get("First Name"));
		input_feilds.get(1).sendKeys(data.get("Middle Name"));
		input_feilds.get(2).sendKeys(data.get("Last Name"));
		input_feilds.get(3).sendKeys(data.get("Name Suffix"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Name fields filled for plaintiff = "+data.get("First Name")+" "+data.get("Middle Name")+" "+data.get("Last Name")+" "+data.get("Name Suffix"));
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Contact + Identity details (Email, SSN, Phone).");
		input_feilds.get(4).sendKeys(data.get("Email"));
		input_feilds.get(5).sendKeys(data.get("Social Security Number"));
		input_feilds.get(6).sendKeys(data.get("Phone number"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Email/SSN/Phone filled (Email="+data.get("Email")+", SSN="+data.get("Social Security Number")+", Phone="+data.get("Phone number")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill DOB + Location details (DOB, State, Zip).");
		input_feilds.get(7).sendKeys(data.get("Date of Birth"));
		input_feilds.get(8).sendKeys(data.get("State"));
		input_feilds.get(9).sendKeys(data.get("Zip code"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> DOB/State/Zip filled (DOB="+data.get("Date of Birth")+", State="+data.get("State")+", Zip="+data.get("Zip code")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Fill Address fields (Address Line 1 & 2).");
		List<WebElement> textArea_areas=p.text_area_fields();
		rp.Scroll_to_element(textArea_areas.get(0));
		textArea_areas.get(0).sendKeys(data.get("Address Line 1"));
		textArea_areas.get(1).sendKeys(data.get("Address Line 2"));
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Address fields filled (Address1="+data.get("Address Line 1")+", Address2="+data.get("Address Line 2")+")");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Click Add Plaintiff button to submit the form.");
		WebElement Add_plaintiff_Button=p.form_buttons().get(0);
		rp.Scroll_to_element(Add_plaintiff_Button);
		Add_plaintiff_Button.click();
		Thread.sleep(800);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual:</b> Add Plaintiff button clicked.");
        Report_Listen.log_print_in_report().log(Status.INFO,"<b>Step "+(step++)+":</b> Capture toast message after submission.");
		try{
			String toast=lg.toast().getText().trim();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Toast after adding plaintiff = "+toast);
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Plaintiff add flow executed for Email="+data.get("Email")+" | Phone="+data.get("Phone number"));
			System.out.println(toast);
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Toast not captured after Add Plaintiff (toast not visible / locator issue).");
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Form submitted but success confirmation was not captured for Email="+data.get("Email"));
			throw e;
		}
	}
	
	
	@DataProvider
	public Object[][] plaintiffData() {

		TreeMap<String, String> p1 = new TreeMap<>();
	    p1.put("First Name", "Calytrix");
	    p1.put("Middle Name", "Aurelia");
	    p1.put("Last Name", "Voxenfield");
	    p1.put("Name Suffix", "III");
	    p1.put("Email", "calytrix.voxenfield@mailto.plus");
	    p1.put("Social Security Number", "974-01-7001");
	    p1.put("Phone number", "907-555-9701");
	    p1.put("Date of Birth", "02/11/1992");
	    p1.put("State", "Alaska");
	    p1.put("Zip code", "99501");
	    p1.put("Address Line 1", "510 L Street, Anchorage Civic Commerce Complex, Tower C, Suite 1420, Downtown Grid, Two Blocks from Delaney Park Strip");
	    p1.put("Address Line 2", "Front Desk: Security Window 1, Delivery Notes: Ask for “Mail Log Binder,” Elevator Access Requires Temporary Badge, Leave with Concierge if After 4PM");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Brevian");
	    p2.put("Middle Name", "Sébastien");
	    p2.put("Last Name", "Hawkridge");
	    p2.put("Name Suffix", "Jr");
	    p2.put("Email", "brevian.hawkridge@mailto.plus");
	    p2.put("Social Security Number", "974-02-7002");
	    p2.put("Phone number", "617-555-9702");
	    p2.put("Date of Birth", "06/27/1989");
	    p2.put("State", "Massachusetts");
	    p2.put("Zip code", "02110");
	    p2.put("Address Line 1", "101 Federal Street, Harborpoint Executive Arcade, Suite 2405, Financial District Edge, Adjacent to South Station Pedestrian Cut-Through");
	    p2.put("Address Line 2", "Mail Stop: FED-24, Attn: Intake Operations Desk, Delivery: Main Lobby Only, Do Not Use Side Door, Include Reference: “HPX-2405-IN”");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Nyxara");
	    p3.put("Middle Name", "Celestine");
	    p3.put("Last Name", "Gravelane");
	    p3.put("Name Suffix", "II");
	    p3.put("Email", "nyxara.gravelane@mailto.plus");
	    p3.put("Social Security Number", "974-03-7003");
	    p3.put("Phone number", "415-555-9703");
	    p3.put("Date of Birth", "09/05/1991");
	    p3.put("State", "California");
	    p3.put("Zip code", "94104");
	    p3.put("Address Line 1", "580 California Street, Crestline Business Galleria, Suite 1975, Bay View Corridor, Between Kearny St and Montgomery St, Near Transamerica Redwood Plaza");
	    p3.put("Address Line 2", "Reception: Desk B, Delivery Note: Call on Arrival, Package Scan Required, Place Envelope in “Case Intake” Tray, Do Not Leave with Building Security");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Tavian");
	    p4.put("Middle Name", "Orion");
	    p4.put("Last Name", "Duskbourne");
	    p4.put("Name Suffix", "Sr");
	    p4.put("Email", "tavian.duskbourne@mailto.plus");
	    p4.put("Social Security Number", "974-04-7004");
	    p4.put("Phone number", "303-555-9704");
	    p4.put("Date of Birth", "12/14/1988");
	    p4.put("State", "Colorado");
	    p4.put("Zip code", "80202");
	    p4.put("Address Line 1", "1700 Lincoln Street, Mile-High Legal Exchange Center, Suite 3100, East Tower, Across from Civic Center Park, Near Light Rail Station Entrance");
	    p4.put("Address Line 2", "Office 31F, Attn: Records Intake, Deliveries: Weekdays 9AM–4:30PM, Visitor Parking: Garage Level P2, Request Validation at Reception");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Elowen");
	    p5.put("Middle Name", "Marielle");
	    p5.put("Last Name", "Cinderbrook");
	    p5.put("Name Suffix", "IV");
	    p5.put("Email", "elowen.cinderbrook@mailto.plus");
	    p5.put("Social Security Number", "974-05-7005");
	    p5.put("Phone number", "312-555-9705");
	    p5.put("Date of Birth", "03/29/1993");
	    p5.put("State", "Illinois");
	    p5.put("Zip code", "60606");
	    p5.put("Address Line 1", "200 West Madison Street, Loop Professional Concourse, Suite 2210, South-West Wing, Near Daley Plaza and Blue Line Station Corridor");
	    p5.put("Address Line 2", "Mail Code: WM-22, Attn: Intake Coordinator, Delivery: Use Main Lobby, Ask for Reception “A2,” Add Note: “Signature Required – Hold”");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Jorvik");
	    p6.put("Middle Name", "Leopold");
	    p6.put("Last Name", "Sablecroft");
	    p6.put("Name Suffix", "II");
	    p6.put("Email", "jorvik.sablecroft@mailto.plus");
	    p6.put("Social Security Number", "974-06-7006");
	    p6.put("Phone number", "504-555-9706");
	    p6.put("Date of Birth", "07/18/1990");
	    p6.put("State", "Louisiana");
	    p6.put("Zip code", "70130");
	    p6.put("Address Line 1", "601 Tchoupitoulas Street, Riverbend Commerce Atrium, Suite 1850, Warehouse District, Near Convention Center Loading Zone and Riverwalk Entrance");
	    p6.put("Address Line 2", "Unit 18B, Attn: Intake Ops, Delivery Instructions: Check in with Lobby Security, Log Package in Register, Leave with Concierge if Office Door Closed");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Marzena");
	    p7.put("Middle Name", "Katarina");
	    p7.put("Last Name", "Ashenford");
	    p7.put("Name Suffix", "Jr");
	    p7.put("Email", "marzena.ashenford@mailto.plus");
	    p7.put("Social Security Number", "974-07-7007");
	    p7.put("Phone number", "602-555-9707");
	    p7.put("Date of Birth", "11/22/1992");
	    p7.put("State", "Arizona");
	    p7.put("Zip code", "85004");
	    p7.put("Address Line 1", "201 East Washington Street, Copper State Business Terrace, Suite 1545, Downtown Phoenix Core, Steps from CityScape and Central Ave Light Rail Stop");
	    p7.put("Address Line 2", "Suite 15D, Attn: Records Intake, Delivery Notes: Main Lobby Only, Bring Photo ID for Visitor Badge, Leave Envelope in “Intake” Slot");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Sapphira");
	    p8.put("Middle Name", "Noelle");
	    p8.put("Last Name", "Junewick");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "sapphira.junewick@mailto.plus");
	    p8.put("Social Security Number", "974-08-7008");
	    p8.put("Phone number", "206-555-9708");
	    p8.put("Date of Birth", "01/07/1994");
	    p8.put("State", "Washington");
	    p8.put("Zip code", "98104");
	    p8.put("Address Line 1", "901 Fifth Avenue, Emerald City Executive Tower, Suite 2680, Downtown Seattle Spine, Near Pioneer Square Corridor and Waterfront Overlook");
	    p8.put("Address Line 2", "Office 26C, Attn: Intake Team, Delivery: Security Desk Scan Mandatory, Label Must Include “ECX-2680,” Do Not Leave Packages Unattended");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Quillan");
	    p9.put("Middle Name", "Everett");
	    p9.put("Last Name", "Brackenveil");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "quillan.brackenveil@mailto.plus");
	    p9.put("Social Security Number", "974-09-7009");
	    p9.put("Phone number", "313-555-9709");
	    p9.put("Date of Birth", "05/16/1988");
	    p9.put("State", "Michigan");
	    p9.put("Zip code", "48226");
	    p9.put("Address Line 1", "100 Renaissance Center, Lakeshore Commerce Arcade, Suite 3015, Detroit Riverfront, Near People Mover Station and Jefferson Avenue Ramp");
	    p9.put("Address Line 2", "Mail Stop: RC-30, Attn: Intake Operations, Delivery Instructions: Use Tower Entrance A, Security Sign-in Required, Hold for Office Stamp");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Ishani");
	    p10.put("Middle Name", "Saanvi");
	    p10.put("Last Name", "Briarwoode");
	    p10.put("Name Suffix", "II");
	    p10.put("Email", "ishani.briarwoode@mailto.plus");
	    p10.put("Social Security Number", "974-10-7010");
	    p10.put("Phone number", "214-555-9710");
	    p10.put("Date of Birth", "08/24/1991");
	    p10.put("State", "Texas");
	    p10.put("Zip code", "75201");
	    p10.put("Address Line 1", "2001 Ross Avenue, Arts District Corporate Promenade, Suite 2140, North Wing, Adjacent to Klyde Warren Park Walkway and DART Station Access");
	    p10.put("Address Line 2", "Suite 21E, Attn: Intake Desk, Delivery Hours: 9AM–4PM, Parking: Visitor Garage Level 2, Present Ticket for Validation at Reception");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Eamon");
	    p11.put("Middle Name", "Thaddeus");
	    p11.put("Last Name", "Stonequarry");
	    p11.put("Name Suffix", "IV");
	    p11.put("Email", "eamon.stonequarry@mailto.plus");
	    p11.put("Social Security Number", "974-11-7011");
	    p11.put("Phone number", "614-555-9711");
	    p11.put("Date of Birth", "10/02/1989");
	    p11.put("State", "Ohio");
	    p11.put("Zip code", "43215");
	    p11.put("Address Line 1", "41 South High Street, Scioto River Commerce Pavilion, Suite 2330, Downtown Columbus Core, Across from Statehouse Grounds and Riverfront Path");
	    p11.put("Address Line 2", "Office 23B, Attn: Compliance Intake, Delivery Notes: Reception Desk C, Add Label “CASE FILE – HOLD,” Do Not Route to General Mailroom");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Vespera");
	    p12.put("Middle Name", "Danielle");
	    p12.put("Last Name", "Frostwarren");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "vespera.frostwarren@mailto.plus");
	    p12.put("Social Security Number", "974-12-7012");
	    p12.put("Phone number", "919-555-9712");
	    p12.put("Date of Birth", "04/19/1993");
	    p12.put("State", "North Carolina");
	    p12.put("Zip code", "27601");
	    p12.put("Address Line 1", "421 Fayetteville Street, Capitol Square Office Exchange, Suite 1615, Downtown Raleigh Grid, Near Convention Center Skybridge Entrance");
	    p12.put("Address Line 2", "Unit 16D, Attn: Intake Operations, Delivery: Main Entrance Only, Obtain Visitor Badge at Kiosk, Leave with Reception if Door Closed");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Kenjirō");
	    p13.put("Middle Name", "Takumi");
	    p13.put("Last Name", "Windelmarch");
	    p13.put("Name Suffix", "Sr");
	    p13.put("Email", "kenjiro.windelmarch@mailto.plus");
	    p13.put("Social Security Number", "974-13-7013");
	    p13.put("Phone number", "702-555-9713");
	    p13.put("Date of Birth", "12/09/1988");
	    p13.put("State", "Nevada");
	    p13.put("Zip code", "89109");
	    p13.put("Address Line 1", "3750 Las Vegas Boulevard South, Strip Business Concourse, Suite 1125, South Tower, Adjacent to Rideshare Pickup Zone and Pedestrian Bridge");
	    p13.put("Address Line 2", "Suite 11A, Attn: Intake Desk, Delivery Notes: Concierge Only, Include “Signature Required – Do Not Leave,” Use Main Lobby for Package Scan");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Aurelian");
	    p14.put("Middle Name", "Quincy");
	    p14.put("Last Name", "Starrowell");
	    p14.put("Name Suffix", "III");
	    p14.put("Email", "aurelian.starrowell@mailto.plus");
	    p14.put("Social Security Number", "974-14-7014");
	    p14.put("Phone number", "303-555-9714");
	    p14.put("Date of Birth", "01/26/1994");
	    p14.put("State", "Colorado");
	    p14.put("Zip code", "80203");
	    p14.put("Address Line 1", "1100 Broadway, Capitol Hill Professional Gallery, Suite 905, East Corridor, Near Civic Center Station and Museum District Walkways");
	    p14.put("Address Line 2", "Office 9E, Attn: Intake Specialist, Delivery: Lobby Desk 1, Elevator Bank A, Floor 9, Mark Envelope “CONFIDENTIAL – INTAKE”");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Marcelline");
	    p15.put("Middle Name", "Beatrix");
	    p15.put("Last Name", "Cedarwynter");
	    p15.put("Name Suffix", "II");
	    p15.put("Email", "marcelline.cedarwynter@mailto.plus");
	    p15.put("Social Security Number", "974-15-7015");
	    p15.put("Phone number", "505-555-9715");
	    p15.put("Date of Birth", "06/03/1990");
	    p15.put("State", "New Mexico");
	    p15.put("Zip code", "87102");
	    p15.put("Address Line 1", "500 Marquette Avenue NW, Rio Grande Business Arcade, Suite 1440, Downtown Albuquerque, Near Civic Plaza Steps and Rail Runner Terminal Access");
	    p15.put("Address Line 2", "Unit 14B, Attn: Intake Operations, Delivery Notes: Main Lobby, Packages Logged at Security Desk, Add Note: “Hold for Signature”");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Darian");
	    p16.put("Middle Name", "Matthieu");
	    p16.put("Last Name", "Emberwold");
	    p16.put("Name Suffix", "Jr");
	    p16.put("Email", "darian.emberwold@mailto.plus");
	    p16.put("Social Security Number", "974-16-7016");
	    p16.put("Phone number", "317-555-9716");
	    p16.put("Date of Birth", "09/28/1989");
	    p16.put("State", "Indiana");
	    p16.put("Zip code", "46204");
	    p16.put("Address Line 1", "201 North Illinois Street, Monument Circle Office Promenade, Suite 1720, Downtown Core, Near City-County Building and War Memorial Plaza");
	    p16.put("Address Line 2", "Suite 17C, Attn: Records Intake, Delivery: Reception B, Provide Reference “IND-1720-INT,” Do Not Leave with Building Security");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Avyanna");
	    p17.put("Middle Name", "Cressida");
	    p17.put("Last Name", "Ironvale");
	    p17.put("Name Suffix", "IV");
	    p17.put("Email", "avyanna.ironvale@mailto.plus");
	    p17.put("Social Security Number", "974-17-7017");
	    p17.put("Phone number", "615-555-9717");
	    p17.put("Date of Birth", "11/17/1992");
	    p17.put("State", "Tennessee");
	    p17.put("Zip code", "37219");
	    p17.put("Address Line 1", "150 4th Avenue North, Nashville Commerce Atrium, Suite 2250, Downtown Core, Near Broadway Corridor and Riverfront Footbridge");
	    p17.put("Address Line 2", "Office 22D, Attn: Intake Coordinator, Delivery: Weekdays Only, Visitor Parking: Garage Level 3, Ask Reception for Validation Stamp");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Zayden");
	    p18.put("Middle Name", "Khalil");
	    p18.put("Last Name", "Brightmere");
	    p18.put("Name Suffix", "II");
	    p18.put("Email", "zayden.brightmere@mailto.plus");
	    p18.put("Social Security Number", "974-18-7018");
	    p18.put("Phone number", "305-555-9718");
	    p18.put("Date of Birth", "04/07/1991");
	    p18.put("State", "Florida");
	    p18.put("Zip code", "33130");
	    p18.put("Address Line 1", "1001 Brickell Bay Drive, Midtown Commerce Terrace, Suite 1285, Brickell Financial Core, Near MetroMover Station and Bayfront Walkway");
	    p18.put("Address Line 2", "Unit 12F, Attn: Intake Desk, Delivery Notes: Concierge Only, Label “HOLD FOR SIGN-OFF,” No Lobby Drop-Off Without Scan");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Iskaryon");
	    p19.put("Middle Name", "Leontine");
	    p19.put("Last Name", "Frostcairn");
	    p19.put("Name Suffix", "Sr");
	    p19.put("Email", "iskaryon.frostcairn@mailto.plus");
	    p19.put("Social Security Number", "974-19-7019");
	    p19.put("Phone number", "808-555-9719");
	    p19.put("Date of Birth", "02/15/1994");
	    p19.put("State", "Hawaii");
	    p19.put("Zip code", "96813");
	    p19.put("Address Line 1", "700 Bishop Street, Pacific Commerce Atrium, Suite 1330, Downtown Honolulu Core, Near Harborfront Access Road and Chinatown Edge");
	    p19.put("Address Line 2", "Suite 13A, Attn: Records Intake, Delivery: Main Lobby Counter 2, Call-on-arrival Required, Leave with Reception if Door Closed");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Zorya");
	    p20.put("Middle Name", "Evangeline");
	    p20.put("Last Name", "Mooncarrow");
	    p20.put("Name Suffix", "III");
	    p20.put("Email", "zorya.mooncarrow@mailto.plus");
	    p20.put("Social Security Number", "974-20-7020");
	    p20.put("Phone number", "816-555-9720");
	    p20.put("Date of Birth", "10/12/1988");
	    p20.put("State", "Missouri");
	    p20.put("Zip code", "64106");
	    p20.put("Address Line 1", "1100 Walnut Street, River Market Professional Exchange, Suite 1620, Downtown Kansas City, Near Courthouse Steps and Streetcar Main Stop");
	    p20.put("Address Line 2", "Office 16C, Attn: Intake Operations, Dock Deliveries: Use 12th Street Entrance, Dock #2, Delivery Window: 9AM–4PM");


	    // ---- 21 to 50 (fresh new names + ids) ----

	    TreeMap<String, String> p21 = new TreeMap<>();
	    p21.put("First Name", "Ulwin");
	    p21.put("Middle Name", "Viktor");
	    p21.put("Last Name", "Himmelgrove");
	    p21.put("Name Suffix", "II");
	    p21.put("Email", "ulwin.himmelgrove@mailto.plus");
	    p21.put("Social Security Number", "950-31-0521");
	    p21.put("Phone number", "617-555-4521");
	    p21.put("Date of Birth", "02/10/1993");
	    p21.put("State", "Massachusetts");
	    p21.put("Zip code", "02110");
	    p21.put("Address Line 1", "101 Federal St");
	    p21.put("Address Line 2", "Suite 420");

	    TreeMap<String, String> p22 = new TreeMap<>();
	    p22.put("First Name", "Vaughan");
	    p22.put("Middle Name", "Willem");
	    p22.put("Last Name", "Ziegelcroft");
	    p22.put("Name Suffix", "Sr");
	    p22.put("Email", "vaughan.ziegelcroft@mailto.plus");
	    p22.put("Social Security Number", "950-32-0522");
	    p22.put("Phone number", "303-555-4522");
	    p22.put("Date of Birth", "12/22/1987");
	    p22.put("State", "Colorado");
	    p22.put("Zip code", "80203");
	    p22.put("Address Line 1", "900 Grant St");
	    p22.put("Address Line 2", "Apt 4A");

	    TreeMap<String, String> p23 = new TreeMap<>();
	    p23.put("First Name", "Wystan");
	    p23.put("Middle Name", "Xavier");
	    p23.put("Last Name", "Vogelspring");
	    p23.put("Name Suffix", "III");
	    p23.put("Email", "wystan.vogelspring@mailto.plus");
	    p23.put("Social Security Number", "950-33-0523");
	    p23.put("Phone number", "214-555-4523");
	    p23.put("Date of Birth", "06/05/1991");
	    p23.put("State", "Texas");
	    p23.put("Zip code", "75202");
	    p23.put("Address Line 1", "150 N Pearl St");
	    p23.put("Address Line 2", "Unit 10C");

	    TreeMap<String, String> p24 = new TreeMap<>();
	    p24.put("First Name", "Xeno");
	    p24.put("Middle Name", "Yann");
	    p24.put("Last Name", "Schlotterridge");
	    p24.put("Name Suffix", "Jr");
	    p24.put("Email", "xeno.schlotterridge@mailto.plus");
	    p24.put("Social Security Number", "950-34-0524");
	    p24.put("Phone number", "312-555-4524");
	    p24.put("Date of Birth", "09/09/1990");
	    p24.put("State", "Illinois");
	    p24.put("Zip code", "60606");
	    p24.put("Address Line 1", "233 S Wacker Dr");
	    p24.put("Address Line 2", "Suite 800");

	    TreeMap<String, String> p25 = new TreeMap<>();
	    p25.put("First Name", "Yorick");
	    p25.put("Middle Name", "Zeno");
	    p25.put("Last Name", "Kreuzhaven");
	    p25.put("Name Suffix", "II");
	    p25.put("Email", "yorick.kreuzhaven@mailto.plus");
	    p25.put("Social Security Number", "950-35-0525");
	    p25.put("Phone number", "317-555-4525");
	    p25.put("Date of Birth", "02/02/1994");
	    p25.put("State", "Indiana");
	    p25.put("Zip code", "46202");
	    p25.put("Address Line 1", "1 N Capitol Ave");
	    p25.put("Address Line 2", "Apt 7D");

	    TreeMap<String, String> p26 = new TreeMap<>();
	    p26.put("First Name", "Zephyr");
	    p26.put("Middle Name", "Aldo");
	    p26.put("Last Name", "Brennfield");
	    p26.put("Name Suffix", "Sr");
	    p26.put("Email", "zephyr.brennfield@mailto.plus");
	    p26.put("Social Security Number", "950-36-0526");
	    p26.put("Phone number", "206-555-4526");
	    p26.put("Date of Birth", "10/14/1988");
	    p26.put("State", "Washington");
	    p26.put("Zip code", "98104");
	    p26.put("Address Line 1", "700 5th Ave");
	    p26.put("Address Line 2", "Floor 9");

	    TreeMap<String, String> p27 = new TreeMap<>();
	    p27.put("First Name", "Aldric");
	    p27.put("Middle Name", "Bram");
	    p27.put("Last Name", "Schneeridge");
	    p27.put("Name Suffix", "III");
	    p27.put("Email", "aldric.schneeridge@mailto.plus");
	    p27.put("Social Security Number", "950-37-0527");
	    p27.put("Phone number", "404-555-4527");
	    p27.put("Date of Birth", "08/08/1991");
	    p27.put("State", "Georgia");
	    p27.put("Zip code", "30308");
	    p27.put("Address Line 1", "800 Peachtree St NE");
	    p27.put("Address Line 2", "Apt 5B");

	    TreeMap<String, String> p28 = new TreeMap<>();
	    p28.put("First Name", "Briar");
	    p28.put("Middle Name", "Corin");
	    p28.put("Last Name", "Kesselwyn");
	    p28.put("Name Suffix", "Jr");
	    p28.put("Email", "briar.kesselwyn@mailto.plus");
	    p28.put("Social Security Number", "950-38-0528");
	    p28.put("Phone number", "702-555-4528");
	    p28.put("Date of Birth", "01/01/1993");
	    p28.put("State", "Nevada");
	    p28.put("Zip code", "89109");
	    p28.put("Address Line 1", "3555 S Las Vegas Blvd");
	    p28.put("Address Line 2", "Unit 18A");

	    TreeMap<String, String> p29 = new TreeMap<>();
	    p29.put("First Name", "Cyran");
	    p29.put("Middle Name", "Dane");
	    p29.put("Last Name", "Brandewald");
	    p29.put("Name Suffix", "II");
	    p29.put("Email", "cyran.brandewald@mailto.plus");
	    p29.put("Social Security Number", "950-39-0529");
	    p29.put("Phone number", "615-555-4529");
	    p29.put("Date of Birth", "06/06/1992");
	    p29.put("State", "Tennessee");
	    p29.put("Zip code", "37203");
	    p29.put("Address Line 1", "1200 Broadway");
	    p29.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p30 = new TreeMap<>();
	    p30.put("First Name", "Dario");
	    p30.put("Middle Name", "Elias");
	    p30.put("Last Name", "Hartmere");
	    p30.put("Name Suffix", "Sr");
	    p30.put("Email", "dario.hartmere@mailto.plus");
	    p30.put("Social Security Number", "950-40-0530");
	    p30.put("Phone number", "801-555-4530");
	    p30.put("Date of Birth", "12/12/1987");
	    p30.put("State", "Utah");
	    p30.put("Zip code", "84101");
	    p30.put("Address Line 1", "100 S Main St");
	    p30.put("Address Line 2", "Suite 600");

	    TreeMap<String, String> p31 = new TreeMap<>();
	    p31.put("First Name", "Elwood");
	    p31.put("Middle Name", "Fionn");
	    p31.put("Last Name", "Kronenvail");
	    p31.put("Name Suffix", "III");
	    p31.put("Email", "elwood.kronenvail@mailto.plus");
	    p31.put("Social Security Number", "950-41-0531");
	    p31.put("Phone number", "407-555-4531");
	    p31.put("Date of Birth", "09/20/1990");
	    p31.put("State", "Florida");
	    p31.put("Zip code", "32801");
	    p31.put("Address Line 1", "100 S Orange Ave");
	    p31.put("Address Line 2", "Unit 18");

	    TreeMap<String, String> p32 = new TreeMap<>();
	    p32.put("First Name", "Falk");
	    p32.put("Middle Name", "Gustaf");
	    p32.put("Last Name", "Schwarzridge");
	    p32.put("Name Suffix", "Jr");
	    p32.put("Email", "falk.schwarzridge@mailto.plus");
	    p32.put("Social Security Number", "950-42-0532");
	    p32.put("Phone number", "415-555-4532");
	    p32.put("Date of Birth", "01/27/1992");
	    p32.put("State", "California");
	    p32.put("Zip code", "94103");
	    p32.put("Address Line 1", "50 3rd St");
	    p32.put("Address Line 2", "Apt 6");

	    TreeMap<String, String> p33 = new TreeMap<>();
	    p33.put("First Name", "Garrick");
	    p33.put("Middle Name", "Hale");
	    p33.put("Last Name", "Fichtenmoor");
	    p33.put("Name Suffix", "II");
	    p33.put("Email", "garrick.fichtenmoor@mailto.plus");
	    p33.put("Social Security Number", "950-43-0533");
	    p33.put("Phone number", "503-555-4533");
	    p33.put("Date of Birth", "03/03/1991");
	    p33.put("State", "Oregon");
	    p33.put("Zip code", "97204");
	    p33.put("Address Line 1", "700 SW 5th Ave");
	    p33.put("Address Line 2", "Suite 410");

	    TreeMap<String, String> p34 = new TreeMap<>();
	    p34.put("First Name", "Halvor");
	    p34.put("Middle Name", "Ilan");
	    p34.put("Last Name", "Sonnenbrook");
	    p34.put("Name Suffix", "Sr");
	    p34.put("Email", "halvor.sonnenbrook@mailto.plus");
	    p34.put("Social Security Number", "950-44-0534");
	    p34.put("Phone number", "609-555-4534");
	    p34.put("Date of Birth", "12/01/1989");
	    p34.put("State", "New Jersey");
	    p34.put("Zip code", "08608");
	    p34.put("Address Line 1", "120 E State St");
	    p34.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p35 = new TreeMap<>();
	    p35.put("First Name", "Isen");
	    p35.put("Middle Name", "Jasper");
	    p35.put("Last Name", "Wintercoil");
	    p35.put("Name Suffix", "III");
	    p35.put("Email", "isen.wintercoil@mailto.plus");
	    p35.put("Social Security Number", "950-45-0535");
	    p35.put("Phone number", "602-555-4535");
	    p35.put("Date of Birth", "06/18/1990");
	    p35.put("State", "Arizona");
	    p35.put("Zip code", "85003");
	    p35.put("Address Line 1", "100 W Washington St");
	    p35.put("Address Line 2", "Apt 12");

	    TreeMap<String, String> p36 = new TreeMap<>();
	    p36.put("First Name", "Jareth");
	    p36.put("Middle Name", "Kieran");
	    p36.put("Last Name", "Bergstrum");
	    p36.put("Name Suffix", "II");
	    p36.put("Email", "jareth.bergstrum@mailto.plus");
	    p36.put("Social Security Number", "950-46-0536");
	    p36.put("Phone number", "206-555-4536");
	    p36.put("Date of Birth", "10/10/1992");
	    p36.put("State", "Washington");
	    p36.put("Zip code", "98109");
	    p36.put("Address Line 1", "500 Westlake Ave N");
	    p36.put("Address Line 2", "Unit 7");

	    TreeMap<String, String> p37 = new TreeMap<>();
	    p37.put("First Name", "Kellan");
	    p37.put("Middle Name", "Lucan");
	    p37.put("Last Name", "Rosenwirth");
	    p37.put("Name Suffix", "Jr");
	    p37.put("Email", "kellan.rosenwirth@mailto.plus");
	    p37.put("Social Security Number", "950-47-0537");
	    p37.put("Phone number", "614-555-4537");
	    p37.put("Date of Birth", "01/05/1994");
	    p37.put("State", "Ohio");
	    p37.put("Zip code", "43215");
	    p37.put("Address Line 1", "150 N High St");
	    p37.put("Address Line 2", "Suite 220");

	    TreeMap<String, String> p38 = new TreeMap<>();
	    p38.put("First Name", "Lorian");
	    p38.put("Middle Name", "Milo");
	    p38.put("Last Name", "Falkenwick");
	    p38.put("Name Suffix", "III");
	    p38.put("Email", "lorian.falkenwick@mailto.plus");
	    p38.put("Social Security Number", "950-48-0538");
	    p38.put("Phone number", "312-555-4538");
	    p38.put("Date of Birth", "09/09/1991");
	    p38.put("State", "Illinois");
	    p38.put("Zip code", "60607");
	    p38.put("Address Line 1", "900 W Randolph St");
	    p38.put("Address Line 2", "Unit 14");

	    TreeMap<String, String> p39 = new TreeMap<>();
	    p39.put("First Name", "Maddox");
	    p39.put("Middle Name", "Nico");
	    p39.put("Last Name", "Eberhollow");
	    p39.put("Name Suffix", "II");
	    p39.put("Email", "maddox.eberhollow@mailto.plus");
	    p39.put("Social Security Number", "950-49-0539");
	    p39.put("Phone number", "313-555-4539");
	    p39.put("Date of Birth", "12/28/1988");
	    p39.put("State", "Michigan");
	    p39.put("Zip code", "48226");
	    p39.put("Address Line 1", "500 Woodward Ave");
	    p39.put("Address Line 2", "Floor 10");

	    TreeMap<String, String> p40 = new TreeMap<>();
	    p40.put("First Name", "Nerys");
	    p40.put("Middle Name", "Otis");
	    p40.put("Last Name", "Hochfeld");
	    p40.put("Name Suffix", "Sr");
	    p40.put("Email", "nerys.hochfeld@mailto.plus");
	    p40.put("Social Security Number", "950-50-0540");
	    p40.put("Phone number", "603-555-4540");
	    p40.put("Date of Birth", "04/24/1990");
	    p40.put("State", "New Hampshire");
	    p40.put("Zip code", "03101");
	    p40.put("Address Line 1", "1000 Elm St");
	    p40.put("Address Line 2", "Apt 2");

	    TreeMap<String, String> p41 = new TreeMap<>();
	    p41.put("First Name", "Orwyn");
	    p41.put("Middle Name", "Pax");
	    p41.put("Last Name", "Schwerdtvale");
	    p41.put("Name Suffix", "III");
	    p41.put("Email", "orwyn.schwerdtvale@mailto.plus");
	    p41.put("Social Security Number", "950-51-0541");
	    p41.put("Phone number", "702-555-4541");
	    p41.put("Date of Birth", "11/21/1991");
	    p41.put("State", "Nevada");
	    p41.put("Zip code", "89103");
	    p41.put("Address Line 1", "500 S Decatur Blvd");
	    p41.put("Address Line 2", "Unit 4B");

	    TreeMap<String, String> p42 = new TreeMap<>();
	    p42.put("First Name", "Phelan");
	    p42.put("Middle Name", "Quade");
	    p42.put("Last Name", "Hirschmoor");
	    p42.put("Name Suffix", "Jr");
	    p42.put("Email", "phelan.hirschmoor@mailto.plus");
	    p42.put("Social Security Number", "950-52-0542");
	    p42.put("Phone number", "317-555-4542");
	    p42.put("Date of Birth", "01/19/1993");
	    p42.put("State", "Indiana");
	    p42.put("Zip code", "46225");
	    p42.put("Address Line 1", "50 S Capitol Ave");
	    p42.put("Address Line 2", "Suite 300");

	    TreeMap<String, String> p43 = new TreeMap<>();
	    p43.put("First Name", "Quillan");
	    p43.put("Middle Name", "Rafe");
	    p43.put("Last Name", "Neubergin");
	    p43.put("Name Suffix", "II");
	    p43.put("Email", "quillan.neubergin@mailto.plus");
	    p43.put("Social Security Number", "950-53-0543");
	    p43.put("Phone number", "615-555-4543");
	    p43.put("Date of Birth", "07/08/1994");
	    p43.put("State", "Tennessee");
	    p43.put("Zip code", "37219");
	    p43.put("Address Line 1", "250 Church St");
	    p43.put("Address Line 2", "Apt 14B");

	    TreeMap<String, String> p44 = new TreeMap<>();
	    p44.put("First Name", "Riven");
	    p44.put("Middle Name", "Simeon");
	    p44.put("Last Name", "Kornbrook");
	    p44.put("Name Suffix", "Sr");
	    p44.put("Email", "riven.kornbrook@mailto.plus");
	    p44.put("Social Security Number", "950-54-0544");
	    p44.put("Phone number", "305-555-4544");
	    p44.put("Date of Birth", "02/13/1987");
	    p44.put("State", "Florida");
	    p44.put("Zip code", "33130");
	    p44.put("Address Line 1", "200 Brickell Ave");
	    p44.put("Address Line 2", "Apt 9A");

	    TreeMap<String, String> p45 = new TreeMap<>();
	    p45.put("First Name", "Silas");
	    p45.put("Middle Name", "Tomas");
	    p45.put("Last Name", "Schwanewick");
	    p45.put("Name Suffix", "III");
	    p45.put("Email", "silas.schwanewick@mailto.plus");
	    p45.put("Social Security Number", "950-55-0545");
	    p45.put("Phone number", "206-555-4545");
	    p45.put("Date of Birth", "03/14/1990");
	    p45.put("State", "Washington");
	    p45.put("Zip code", "98121");
	    p45.put("Address Line 1", "2121 6th Ave");
	    p45.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p46 = new TreeMap<>();
	    p46.put("First Name", "Tavian");
	    p46.put("Middle Name", "Ulmer");
	    p46.put("Last Name", "Tannhaevik");
	    p46.put("Name Suffix", "Jr");
	    p46.put("Email", "tavian.tannhaevik@mailto.plus");
	    p46.put("Social Security Number", "950-56-0546");
	    p46.put("Phone number", "404-555-4546");
	    p46.put("Date of Birth", "12/05/1991");
	    p46.put("State", "Georgia");
	    p46.put("Zip code", "30313");
	    p46.put("Address Line 1", "190 Marietta St NW");
	    p46.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p47 = new TreeMap<>();
	    p47.put("First Name", "Ulric");
	    p47.put("Middle Name", "Vance");
	    p47.put("Last Name", "Edelwirth");
	    p47.put("Name Suffix", "II");
	    p47.put("Email", "ulric.edelwirth@mailto.plus");
	    p47.put("Social Security Number", "950-57-0547");
	    p47.put("Phone number", "785-555-4547");
	    p47.put("Date of Birth", "09/30/1992");
	    p47.put("State", "Kansas");
	    p47.put("Zip code", "66604");
	    p47.put("Address Line 1", "1200 Topeka Blvd");
	    p47.put("Address Line 2", "Unit 9D");

	    TreeMap<String, String> p48 = new TreeMap<>();
	    p48.put("First Name", "Valen");
	    p48.put("Middle Name", "Wren");
	    p48.put("Last Name", "Frostwick");
	    p48.put("Name Suffix", "Sr");
	    p48.put("Email", "valen.frostwick@mailto.plus");
	    p48.put("Social Security Number", "950-58-0548");
	    p48.put("Phone number", "603-555-4548");
	    p48.put("Date of Birth", "06/26/1989");
	    p48.put("State", "New Hampshire");
	    p48.put("Zip code", "03101");
	    p48.put("Address Line 1", "1000 Elm St");
	    p48.put("Address Line 2", "Apt 5C");

	    TreeMap<String, String> p49 = new TreeMap<>();
	    p49.put("First Name", "Wendell");
	    p49.put("Middle Name", "Xander");
	    p49.put("Last Name", "Hohenmere");
	    p49.put("Name Suffix", "III");
	    p49.put("Email", "wendell.hohenmere@mailto.plus");
	    p49.put("Social Security Number", "950-59-0549");
	    p49.put("Phone number", "504-555-4549");
	    p49.put("Date of Birth", "10/05/1989");
	    p49.put("State", "Louisiana");
	    p49.put("Zip code", "70130");
	    p49.put("Address Line 1", "1 Canal St");
	    p49.put("Address Line 2", "Apt 7B");

	    TreeMap<String, String> p50 = new TreeMap<>();
	    p50.put("First Name", "Xavian");
	    p50.put("Middle Name", "Yulian");
	    p50.put("Last Name", "Schreiberwyn");
	    p50.put("Name Suffix", "II");
	    p50.put("Email", "xavian.schreiberwyn@mailto.plus");
	    p50.put("Social Security Number", "950-60-0550");
	    p50.put("Phone number", "214-555-4550");
	    p50.put("Date of Birth", "01/30/1992");
	    p50.put("State", "Texas");
	    p50.put("Zip code", "75204");
	    p50.put("Address Line 1", "3000 McKinney Ave");
	    p50.put("Address Line 2", "Unit 7C");

	    return new Object[][]{
	        {p1},{p2},{p3},{p4},{p5},
	        {p6},{p7},{p8},{p9},{p10},/*
	        {p11},{p12},{p13},{p14},{p15},
	        {p16},{p17},{p18},{p19},{p20}, /*
	        {p21},{p22},{p23},{p24},{p25},
	        {p26},{p27},{p28},{p29},{p30}, 
	        {p31},{p32},{p33},{p34},{p35},
	        {p36},{p37},{p38},{p39},{p40},
	        {p41},{p42},{p43},{p44},{p45},
	        {p46},{p47},{p48},{p49},{p50} */
	    };
	}







}
	
	
	
	
	
	
	


