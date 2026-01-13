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
		Application_Locaters ap = new Application_Locaters(d);

		int step=1;
		
		String Plaintiff_firstname = data.get("First Name");

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
		input_feilds.get(0).sendKeys(Plaintiff_firstname);
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
        WebElement Toast = lg.toast();
		try{Toast = lg.toast();
			String toast=Toast.getText().trim();
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>🟨 Actual:</b> ✅ Toast after adding plaintiff = "+toast);
			Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ Final Result:</b> Plaintiff add flow executed for Email="+data.get("Email")+" | Phone="+data.get("Phone number"));
			System.out.println(toast);
			rp.wait_for_invisibility(Toast);}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>🟨 Actual:</b> ❌ Toast not captured after Add Plaintiff (toast not visible / locator issue).");
			Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Final Result:</b> Form submitted but success confirmation was not captured for Email="+data.get("Email"));
			throw e;}
		rp.Scroll_to_element(ap.table_body());
		Thread.sleep(1200);
		List<WebElement> table_rows;
		try {
		table_rows = ap.rows();}
		catch(Exception tabs) {
			Thread.sleep(800);
			table_rows = ap.rows();}
			WebElement first_row = table_rows.get(0);
			String First_row_contents = first_row.getText().trim();
			System.out.println(First_row_contents.contains(Plaintiff_firstname)?"Testcase passed added plaintiff "+Plaintiff_firstname+ " shown in first row of above table":"Testcase failed added plaintiff "+Plaintiff_firstname+ " not shown in first row of above table");}
	
	
	@DataProvider
	public Object[][] plaintiffData() {

		TreeMap<String, String> p1 = new TreeMap<>();
	    p1.put("First Name", "Élodie");
	    p1.put("Middle Name", "Maëlle");
	    p1.put("Last Name", "Beaulac");
	    p1.put("Name Suffix", "II");
	    p1.put("Email", "elodie.beaulac5211@mailto.plus");
	    p1.put("Social Security Number", "963-21-9021");
	    p1.put("Phone number", "4167325211");
	    p1.put("Date of Birth", "02/11/1991");
	    p1.put("State", "Ontario");
	    p1.put("Zip code", "M5V2T6");
	    p1.put("Address Line 1", "250 Front Street West, Tower South, Suite 1208");
	    p1.put("Address Line 2", "Attn: Intake Desk, Deliver to Lobby Concierge, Call on arrival");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Mathieu");
	    p2.put("Middle Name", "Olivier");
	    p2.put("Last Name", "Lafrenière");
	    p2.put("Name Suffix", "Jr");
	    p2.put("Email", "mathieu.lafreniere7342@mailto.plus");
	    p2.put("Social Security Number", "963-22-9022");
	    p2.put("Phone number", "5146087342");
	    p2.put("Date of Birth", "07/03/1989");
	    p2.put("State", "Quebec");
	    p2.put("Zip code", "H2Y1C6");
	    p2.put("Address Line 1", "80 Rue Saint-Paul Ouest, Vieux-Montréal, Suite 905");
	    p2.put("Address Line 2", "Security desk sign-in required, leave package with Reception B");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Kiera");
	    p3.put("Middle Name", "Noëlle");
	    p3.put("Last Name", "MacKinnon");
	    p3.put("Name Suffix", "III");
	    p3.put("Email", "kiera.mackinnon9063@mailto.plus");
	    p3.put("Social Security Number", "963-23-9023");
	    p3.put("Phone number", "6044159063");
	    p3.put("Date of Birth", "11/28/1992");
	    p3.put("State", "British Columbia");
	    p3.put("Zip code", "V6C3N2");
	    p3.put("Address Line 1", "1055 West Georgia Street, Coal Harbour Offices, Suite 1710");
	    p3.put("Address Line 2", "Deliveries weekdays 9–4, use Main Lobby, concierge holds for signature");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Bastien");
	    p4.put("Middle Name", "Rémi");
	    p4.put("Last Name", "Desrochers");
	    p4.put("Name Suffix", "Sr");
	    p4.put("Email", "bastien.desrochers1874@mailto.plus");
	    p4.put("Social Security Number", "963-24-9024");
	    p4.put("Phone number", "7806391874");
	    p4.put("Date of Birth", "01/19/1990");
	    p4.put("State", "Alberta");
	    p4.put("Zip code", "T5J0K1");
	    p4.put("Address Line 1", "10180 101 Street NW, Downtown Core, Suite 2200");
	    p4.put("Address Line 2", "Front desk drop-off only, include label: “PLAINTIFF FILE”");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Sienna");
	    p5.put("Middle Name", "Claire");
	    p5.put("Last Name", "Tremblay-Leduc");
	    p5.put("Name Suffix", "IV");
	    p5.put("Email", "sienna.tremblayleduc4405@mailto.plus");
	    p5.put("Social Security Number", "963-25-9025");
	    p5.put("Phone number", "9024014405");
	    p5.put("Date of Birth", "05/08/1993");
	    p5.put("State", "Nova Scotia");
	    p5.put("Zip code", "B3J3K8");
	    p5.put("Address Line 1", "1791 Barrington Street, Waterfront District, Suite 608");
	    p5.put("Address Line 2", "Leave with Reception if door is closed, call-on-arrival requested");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Callum");
	    p6.put("Middle Name", "Étienne");
	    p6.put("Last Name", "Bouchard");
	    p6.put("Name Suffix", "II");
	    p6.put("Email", "callum.bouchard7726@mailto.plus");
	    p6.put("Social Security Number", "963-26-9026");
	    p6.put("Phone number", "6135087726");
	    p6.put("Date of Birth", "09/12/1988");
	    p6.put("State", "Ontario");
	    p6.put("Zip code", "K1P5G4");
	    p6.put("Address Line 1", "130 Albert Street, Parliament Corridor, Suite 1505");
	    p6.put("Address Line 2", "Deliver to Lobby Desk C, visitor badge required for elevator");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Amélie");
	    p7.put("Middle Name", "Sophie");
	    p7.put("Last Name", "Gagnon");
	    p7.put("Name Suffix", "Jr");
	    p7.put("Email", "amelie.gagnon3187@mailto.plus");
	    p7.put("Social Security Number", "963-27-9027");
	    p7.put("Phone number", "4386203187");
	    p7.put("Date of Birth", "12/02/1994");
	    p7.put("State", "Quebec");
	    p7.put("Zip code", "G1V0A6");
	    p7.put("Address Line 1", "2828 Boulevard Laurier, Sainte-Foy, Suite 1202");
	    p7.put("Address Line 2", "Drop at reception A, include reference: QC-INT-1202");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Rowan");
	    p8.put("Middle Name", "Declan");
	    p8.put("Last Name", "Henderson");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "rowan.henderson6908@mailto.plus");
	    p8.put("Social Security Number", "963-28-9028");
	    p8.put("Phone number", "2045876908");
	    p8.put("Date of Birth", "03/26/1991");
	    p8.put("State", "Manitoba");
	    p8.put("Zip code", "R3C4T3");
	    p8.put("Address Line 1", "1 Lombard Place, Exchange District, Suite 905");
	    p8.put("Address Line 2", "Security scan required, deliveries weekdays only");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Talia");
	    p9.put("Middle Name", "Jade");
	    p9.put("Last Name", "Sinclair");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "talia.sinclair2479@mailto.plus");
	    p9.put("Social Security Number", "963-29-9029");
	    p9.put("Phone number", "3065742479");
	    p9.put("Date of Birth", "06/17/1989");
	    p9.put("State", "Saskatchewan");
	    p9.put("Zip code", "S4P3Y2");
	    p9.put("Address Line 1", "2400 13th Avenue, Downtown, Suite 610");
	    p9.put("Address Line 2", "Deliver to main lobby, ask for Intake Coordinator");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Noah");
	    p10.put("Middle Name", "Laurent");
	    p10.put("Last Name", "Chénier");
	    p10.put("Name Suffix", "IV");
	    p10.put("Email", "noah.chenier8030@mailto.plus");
	    p10.put("Social Security Number", "963-30-9030");
	    p10.put("Phone number", "7095558030");
	    p10.put("Date of Birth", "10/21/1992");
	    p10.put("State", "Newfoundland and Labrador");
	    p10.put("Zip code", "A1C5N5");
	    p10.put("Address Line 1", "10 Kenmount Road, Business Park, Suite 410");
	    p10.put("Address Line 2", "Leave package with reception, signature required on delivery");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Hana");
	    p11.put("Middle Name", "Sakura");
	    p11.put("Last Name", "Evermoor");
	    p11.put("Name Suffix", "II");
	    p11.put("Email", "hana.evermoor.n1p5@mailto.plus");
	    p11.put("Social Security Number", "975-11-4211");
	    p11.put("Phone number", "904-555-2481");
	    p11.put("Date of Birth", "11/12/1988");
	    p11.put("State", "Florida");
	    p11.put("Zip code", "33136");
	    p11.put("Address Line 1", "350 Northeast 1st Avenue, Midtown Commerce Terrace, Suite 1220");
	    p11.put("Address Line 2", "Concierge only, Include note: “Hold for Sign-off”, Do not leave with security");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Kendall");
	    p12.put("Middle Name", "Brielle");
	    p12.put("Last Name", "Cedarstone");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "kendall.cedarstone.z6u2@mailto.plus");
	    p12.put("Social Security Number", "975-12-4212");
	    p12.put("Phone number", "702-555-9017");
	    p12.put("Date of Birth", "02/16/1993");
	    p12.put("State", "Nevada");
	    p12.put("Zip code", "89109");
	    p12.put("Address Line 1", "3700 Las Vegas Boulevard South, Strip Concourse, Suite 1020, South Tower");
	    p12.put("Address Line 2", "Signature required, Concierge only, Add note: “Do Not Leave Unattended”");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Leander");
	    p13.put("Middle Name", "Hugo");
	    p13.put("Last Name", "Frostwick");
	    p13.put("Name Suffix", "III");
	    p13.put("Email", "leander.frostwick.b3u8@mailto.plus");
	    p13.put("Social Security Number", "975-13-4213");
	    p13.put("Phone number", "502-555-7319");
	    p13.put("Date of Birth", "04/25/1991");
	    p13.put("State", "Kentucky");
	    p13.put("Zip code", "40202");
	    p13.put("Address Line 1", "500 West Jefferson Street, Riverfront Commerce Center, Suite 1406, East Entrance");
	    p13.put("Address Line 2", "Records Intake Room 14A, Deliveries: Weekdays 10AM–3PM");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Inaya");
	    p14.put("Middle Name", "Rumi");
	    p14.put("Last Name", "Moonridge");
	    p14.put("Name Suffix", "Sr");
	    p14.put("Email", "inaya.moonridge.c8m4@mailto.plus");
	    p14.put("Social Security Number", "975-14-4214");
	    p14.put("Phone number", "317-555-1569");
	    p14.put("Date of Birth", "01/06/1994");
	    p14.put("State", "Indiana");
	    p14.put("Zip code", "46204");
	    p14.put("Address Line 1", "50 West Washington Street, Statehouse District, Suite 905, North Corridor");
	    p14.put("Address Line 2", "Reception Desk B, Badge required for elevator, Visitor parking Level 1");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Zara");
	    p15.put("Middle Name", "Imani");
	    p15.put("Last Name", "Harborwyn");
	    p15.put("Name Suffix", "IV");
	    p15.put("Email", "zara.harborwyn.r5t0@mailto.plus");
	    p15.put("Social Security Number", "975-15-4215");
	    p15.put("Phone number", "505-555-4682");
	    p15.put("Date of Birth", "09/02/1989");
	    p15.put("State", "New Mexico");
	    p15.put("Zip code", "87102");
	    p15.put("Address Line 1", "201 3rd Street NW, Rio Grande Business Arcade, Suite 1182, Downtown");
	    p15.put("Address Line 2", "Packages logged at Security Desk, Deliveries: Main Lobby, Add label “INTAKE”");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Noah");
	    p16.put("Middle Name", "Elias");
	    p16.put("Last Name", "Ridgeford");
	    p16.put("Name Suffix", "II");
	    p16.put("Email", "noah.ridgeford.h2x7@mailto.plus");
	    p16.put("Social Security Number", "975-16-4216");
	    p16.put("Phone number", "504-555-7924");
	    p16.put("Date of Birth", "03/15/1990");
	    p16.put("State", "Louisiana");
	    p16.put("Zip code", "70112");
	    p16.put("Address Line 1", "935 Gravier Street, Crescent City Arcade, Suite 2112, CBD");
	    p16.put("Address Line 2", "Attn: Intake Ops, Deliver to Lobby Desk, Note: “Hold for Signature”");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Aria");
	    p17.put("Middle Name", "Celina");
	    p17.put("Last Name", "Thornhaven");
	    p17.put("Name Suffix", "Jr");
	    p17.put("Email", "aria.thornhaven.p2c6@mailto.plus");
	    p17.put("Social Security Number", "975-17-4217");
	    p17.put("Phone number", "816-555-9207");
	    p17.put("Date of Birth", "12/20/1992");
	    p17.put("State", "Missouri");
	    p17.put("Zip code", "64105");
	    p17.put("Address Line 1", "1200 Main Street, River Market Center, Suite 1512, Downtown");
	    p17.put("Address Line 2", "Dock deliveries via 12th Street entrance, Dock #1, Call front desk");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Mateo");
	    p18.put("Middle Name", "Julian");
	    p18.put("Last Name", "Crownfield");
	    p18.put("Name Suffix", "III");
	    p18.put("Email", "mateo.crownfield.y9k1@mailto.plus");
	    p18.put("Social Security Number", "975-18-4218");
	    p18.put("Phone number", "212-555-3741");
	    p18.put("Date of Birth", "06/21/1989");
	    p18.put("State", "New York");
	    p18.put("Zip code", "10013");
	    p18.put("Address Line 1", "120 Hudson Street, Tribeca Row, Suite 1920, North Wing");
	    p18.put("Address Line 2", "Security badge required, Elevator access via Lobby Kiosk, Mailbox Tag: NY-19");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Elowen");
	    p19.put("Middle Name", "Simone");
	    p19.put("Last Name", "Foxmere");
	    p19.put("Name Suffix", "Sr");
	    p19.put("Email", "elowen.foxmere.v1n6@mailto.plus");
	    p19.put("Social Security Number", "975-19-4219");
	    p19.put("Phone number", "907-555-6403");
	    p19.put("Date of Birth", "05/07/1994");
	    p19.put("State", "Alaska");
	    p19.put("Zip code", "99503");
	    p19.put("Address Line 1", "4200 Minnesota Drive, Midtown Office Exchange, Suite 910, West Corridor");
	    p19.put("Address Line 2", "Use Main Lobby, Call-on-arrival, Leave with Reception if door closed");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Rohan");
	    p20.put("Middle Name", "Kiran");
	    p20.put("Last Name", "Waveridge");
	    p20.put("Name Suffix", "IV");
	    p20.put("Email", "rohan.waveridge.g4t8@mailto.plus");
	    p20.put("Social Security Number", "975-20-4220");
	    p20.put("Phone number", "513-555-2086");
	    p20.put("Date of Birth", "10/09/1988");
	    p20.put("State", "Ohio");
	    p20.put("Zip code", "45202");
	    p20.put("Address Line 1", "312 Walnut Street, Riverfront Legal Arcade, Suite 520, Downtown Core");
	    p20.put("Address Line 2", "Mail Stop QC-05, Deliver to Reception A, Visitor parking Garage Level 2");
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
	        {p16},{p17},{p18},{p19},{p20}, 
	        {p21},{p22},{p23},{p24},{p25},
	        {p26},{p27},{p28},{p29},{p30}, 
	        {p31},{p32},{p33},{p34},{p35},
	        {p36},{p37},{p38},{p39},{p40},
	        {p41},{p42},{p43},{p44},{p45},
	        {p46},{p47},{p48},{p49},{p50} */
	    };
	}







}
	
	
	
	
	
	
	


