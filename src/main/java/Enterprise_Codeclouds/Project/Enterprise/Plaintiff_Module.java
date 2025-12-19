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
		sd.Side_menu_option_clicker("Plaintiffs",d);
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
	    p1.put("First Name", "Emanuel");
	    p1.put("Middle Name", "Gregor");
	    p1.put("Last Name", "Schreiber");
	    p1.put("Name Suffix", "Jr");
	    p1.put("Email", "emanuel.schreiber@mailto.plus");
	    p1.put("Social Security Number", "701-18-5532");
	    p1.put("Phone number", "416-555-0301");
	    p1.put("Date of Birth", "01/19/1991");
	    p1.put("State", "Ontario");
	    p1.put("Zip code", "M5H2N2");
	    p1.put("Address Line 1", "100 Queen St W");
	    p1.put("Address Line 2", "Unit 14B");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Timo");
	    p2.put("Middle Name", "Andreas");
	    p2.put("Last Name", "Hartwig");
	    p2.put("Name Suffix", "II");
	    p2.put("Email", "timo.hartwig@mailto.plus");
	    p2.put("Social Security Number", "714-62-1907");
	    p2.put("Phone number", "647-555-0302");
	    p2.put("Date of Birth", "08/07/1989");
	    p2.put("State", "Ontario");
	    p2.put("Zip code", "M4C1A1");
	    p2.put("Address Line 1", "250 Danforth Ave");
	    p2.put("Address Line 2", "Apt 8C");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Matthias");
	    p3.put("Middle Name", "Ulrich");
	    p3.put("Last Name", "Reinhardt");
	    p3.put("Name Suffix", "Sr");
	    p3.put("Email", "matthias.reinhardt@mailto.plus");
	    p3.put("Social Security Number", "728-05-6419");
	    p3.put("Phone number", "905-555-0303");
	    p3.put("Date of Birth", "11/03/1987");
	    p3.put("State", "Ontario");
	    p3.put("Zip code", "L5B4M7");
	    p3.put("Address Line 1", "350 Confederation Pkwy");
	    p3.put("Address Line 2", "Suite 200");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Nico");
	    p4.put("Middle Name", "Sebastian");
	    p4.put("Last Name", "Kessler");
	    p4.put("Name Suffix", "III");
	    p4.put("Email", "nico.kessler@mailto.plus");
	    p4.put("Social Security Number", "705-44-3806");
	    p4.put("Phone number", "437-555-0304");
	    p4.put("Date of Birth", "04/24/1993");
	    p4.put("State", "Ontario");
	    p4.put("Zip code", "M2N7E9");
	    p4.put("Address Line 1", "5000 Yonge St");
	    p4.put("Address Line 2", "Unit 9F");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Benedikt");
	    p5.put("Middle Name", "Moritz");
	    p5.put("Last Name", "Althaus");
	    p5.put("Name Suffix", "Jr");
	    p5.put("Email", "benedikt.althaus@mailto.plus");
	    p5.put("Social Security Number", "719-33-8025");
	    p5.put("Phone number", "416-555-0305");
	    p5.put("Date of Birth", "09/12/1990");
	    p5.put("State", "Ontario");
	    p5.put("Zip code", "M6H3Z8");
	    p5.put("Address Line 1", "800 Dundas St W");
	    p5.put("Address Line 2", "Apt 10D");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Adrian");
	    p6.put("Middle Name", "Ferdinand");
	    p6.put("Last Name", "Kornfeld");
	    p6.put("Name Suffix", "II");
	    p6.put("Email", "adrian.kornfeld@mailto.plus");
	    p6.put("Social Security Number", "732-71-0946");
	    p6.put("Phone number", "647-555-0306");
	    p6.put("Date of Birth", "06/18/1988");
	    p6.put("State", "Ontario");
	    p6.put("Zip code", "M4W1A9");
	    p6.put("Address Line 1", "55 Bloor St E");
	    p6.put("Address Line 2", "Unit 1802");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Erik");
	    p7.put("Middle Name", "Johannes");
	    p7.put("Last Name", "Brandner");
	    p7.put("Name Suffix", "Sr");
	    p7.put("Email", "erik.brandner@mailto.plus");
	    p7.put("Social Security Number", "706-10-7741");
	    p7.put("Phone number", "905-555-0307");
	    p7.put("Date of Birth", "02/02/1992");
	    p7.put("State", "Ontario");
	    p7.put("Zip code", "L6Y0C1");
	    p7.put("Address Line 1", "1 Main St S");
	    p7.put("Address Line 2", "Unit 6B");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Leonard");
	    p8.put("Middle Name", "Klaus");
	    p8.put("Last Name", "Voss");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "leonard.voss@mailto.plus");
	    p8.put("Social Security Number", "720-58-4319");
	    p8.put("Phone number", "416-555-0308");
	    p8.put("Date of Birth", "12/28/1989");
	    p8.put("State", "Ontario");
	    p8.put("Zip code", "M5A0B6");
	    p8.put("Address Line 1", "60 Front St E");
	    p8.put("Address Line 2", "Apt 4A");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Lennox");
	    p9.put("Middle Name", "Matthias");
	    p9.put("Last Name", "Heinrich");
	    p9.put("Name Suffix", "Jr");
	    p9.put("Email", "lennox.heinrich@mailto.plus");
	    p9.put("Social Security Number", "733-26-9017");
	    p9.put("Phone number", "647-555-0309");
	    p9.put("Date of Birth", "03/14/1994");
	    p9.put("State", "Ontario");
	    p9.put("Zip code", "M3J2P3");
	    p9.put("Address Line 1", "1 York University Blvd");
	    p9.put("Address Line 2", "Unit 3C");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Silas");
	    p10.put("Middle Name", "Werner");
	    p10.put("Last Name", "Scholz");
	    p10.put("Name Suffix", "II");
	    p10.put("Email", "silas.scholz@mailto.plus");
	    p10.put("Social Security Number", "715-09-6802");
	    p10.put("Phone number", "437-555-0310");
	    p10.put("Date of Birth", "10/05/1991");
	    p10.put("State", "Ontario");
	    p10.put("Zip code", "M1P4P5");
	    p10.put("Address Line 1", "300 Borough Dr");
	    p10.put("Address Line 2", "Suite 900");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Florian");
	    p11.put("Middle Name", "Niklas");
	    p11.put("Last Name", "Kaufmann");
	    p11.put("Name Suffix", "Sr");
	    p11.put("Email", "florian.kaufmann@mailto.plus");
	    p11.put("Social Security Number", "729-41-3376");
	    p11.put("Phone number", "604-555-0311");
	    p11.put("Date of Birth", "05/22/1988");
	    p11.put("State", "British Columbia");
	    p11.put("Zip code", "V6B0M3");
	    p11.put("Address Line 1", "777 Richards St");
	    p11.put("Address Line 2", "Unit 1507");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Henrik");
	    p12.put("Middle Name", "Paul");
	    p12.put("Last Name", "Brenner");
	    p12.put("Name Suffix", "III");
	    p12.put("Email", "henrik.brenner@mailto.plus");
	    p12.put("Social Security Number", "709-88-5142");
	    p12.put("Phone number", "778-555-0312");
	    p12.put("Date of Birth", "01/27/1990");
	    p12.put("State", "British Columbia");
	    p12.put("Zip code", "V6C2R8");
	    p12.put("Address Line 1", "1055 Dunsmuir St");
	    p12.put("Address Line 2", "Suite 520");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Emil");
	    p13.put("Middle Name", "Armin");
	    p13.put("Last Name", "Seifert");
	    p13.put("Name Suffix", "Jr");
	    p13.put("Email", "emil.seifert@mailto.plus");
	    p13.put("Social Security Number", "734-62-1190");
	    p13.put("Phone number", "604-555-0313");
	    p13.put("Date of Birth", "07/08/1993");
	    p13.put("State", "British Columbia");
	    p13.put("Zip code", "V5K0A1");
	    p13.put("Address Line 1", "1200 Hastings St E");
	    p13.put("Address Line 2", "Apt 7B");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Oskar");
	    p14.put("Middle Name", "Gustav");
	    p14.put("Last Name", "Mertens");
	    p14.put("Name Suffix", "II");
	    p14.put("Email", "oskar.mertens@mailto.plus");
	    p14.put("Social Security Number", "717-35-9004");
	    p14.put("Phone number", "778-555-0314");
	    p14.put("Date of Birth", "11/21/1987");
	    p14.put("State", "British Columbia");
	    p14.put("Zip code", "V6H1A1");
	    p14.put("Address Line 1", "1600 W Broadway");
	    p14.put("Address Line 2", "Unit 6A");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Klaus");
	    p15.put("Middle Name", "Friedrich");
	    p15.put("Last Name", "Stark");
	    p15.put("Name Suffix", "Sr");
	    p15.put("Email", "klaus.stark@mailto.plus");
	    p15.put("Social Security Number", "726-08-4721");
	    p15.put("Phone number", "403-555-0315");
	    p15.put("Date of Birth", "02/13/1986");
	    p15.put("State", "Alberta");
	    p15.put("Zip code", "T2P1A1");
	    p15.put("Address Line 1", "200 8 Ave SW");
	    p15.put("Address Line 2", "Suite 1200");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Ronan");
	    p16.put("Middle Name", "Leopold");
	    p16.put("Last Name", "Falkner");
	    p16.put("Name Suffix", "III");
	    p16.put("Email", "ronan.falkner@mailto.plus");
	    p16.put("Social Security Number", "712-90-3368");
	    p16.put("Phone number", "587-555-0316");
	    p16.put("Date of Birth", "09/30/1992");
	    p16.put("State", "Alberta");
	    p16.put("Zip code", "T5J0N3");
	    p16.put("Address Line 1", "10180 101 St NW");
	    p16.put("Address Line 2", "Unit 12C");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Dieter");
	    p17.put("Middle Name", "Konrad");
	    p17.put("Last Name", "Schulz");
	    p17.put("Name Suffix", "Jr");
	    p17.put("Email", "dieter.schulz@mailto.plus");
	    p17.put("Social Security Number", "735-14-6009");
	    p17.put("Phone number", "780-555-0317");
	    p17.put("Date of Birth", "04/07/1990");
	    p17.put("State", "Alberta");
	    p17.put("Zip code", "T6G2R3");
	    p17.put("Address Line 1", "11011 Jasper Ave NW");
	    p17.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Axel");
	    p18.put("Middle Name", "Bernhard");
	    p18.put("Last Name", "Kramer");
	    p18.put("Name Suffix", "II");
	    p18.put("Email", "axel.kramer@mailto.plus");
	    p18.put("Social Security Number", "718-63-5091");
	    p18.put("Phone number", "403-555-0318");
	    p18.put("Date of Birth", "12/09/1988");
	    p18.put("State", "Alberta");
	    p18.put("Zip code", "T2R1A1");
	    p18.put("Address Line 1", "333 11 Ave SW");
	    p18.put("Address Line 2", "Unit 5F");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Marcel");
	    p19.put("Middle Name", "Heinrich");
	    p19.put("Last Name", "Vogt");
	    p19.put("Name Suffix", "Sr");
	    p19.put("Email", "marcel.vogt@mailto.plus");
	    p19.put("Social Security Number", "730-27-8145");
	    p19.put("Phone number", "780-555-0319");
	    p19.put("Date of Birth", "06/26/1989");
	    p19.put("State", "Alberta");
	    p19.put("Zip code", "T5K0A1");
	    p19.put("Address Line 1", "10155 102 St NW");
	    p19.put("Address Line 2", "Suite 420");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Gavin");
	    p20.put("Middle Name", "Elias");
	    p20.put("Last Name", "Bachmann");
	    p20.put("Name Suffix", "III");
	    p20.put("Email", "gavin.bachmann@mailto.plus");
	    p20.put("Social Security Number", "707-55-2904");
	    p20.put("Phone number", "204-555-0320");
	    p20.put("Date of Birth", "03/03/1993");
	    p20.put("State", "Manitoba");
	    p20.put("Zip code", "R3C1A1");
	    p20.put("Address Line 1", "200 Portage Ave");
	    p20.put("Address Line 2", "Suite 600");

	    TreeMap<String, String> p21 = new TreeMap<>();
	    p21.put("First Name", "Theo");
	    p21.put("Middle Name", "Ludwig");
	    p21.put("Last Name", "Arnoldt");
	    p21.put("Name Suffix", "Jr");
	    p21.put("Email", "theo.arnoldt@mailto.plus");
	    p21.put("Social Security Number", "736-02-4418");
	    p21.put("Phone number", "204-555-0321");
	    p21.put("Date of Birth", "10/14/1991");
	    p21.put("State", "Manitoba");
	    p21.put("Zip code", "R2C0A1");
	    p21.put("Address Line 1", "155 Market Ave");
	    p21.put("Address Line 2", "Unit 8D");

	    TreeMap<String, String> p22 = new TreeMap<>();
	    p22.put("First Name", "Kai");
	    p22.put("Middle Name", "Manuel");
	    p22.put("Last Name", "Dietz");
	    p22.put("Name Suffix", "II");
	    p22.put("Email", "kai.dietz@mailto.plus");
	    p22.put("Social Security Number", "710-41-9063");
	    p22.put("Phone number", "306-555-0322");
	    p22.put("Date of Birth", "02/08/1994");
	    p22.put("State", "Saskatchewan");
	    p22.put("Zip code", "S7K1A1");
	    p22.put("Address Line 1", "200 1st Ave N");
	    p22.put("Address Line 2", "Apt 6A");

	    TreeMap<String, String> p23 = new TreeMap<>();
	    p23.put("First Name", "Nils");
	    p23.put("Middle Name", "Christian");
	    p23.put("Last Name", "Heller");
	    p23.put("Name Suffix", "Sr");
	    p23.put("Email", "nils.heller@mailto.plus");
	    p23.put("Social Security Number", "729-67-1154");
	    p23.put("Phone number", "306-555-0323");
	    p23.put("Date of Birth", "05/26/1988");
	    p23.put("State", "Saskatchewan");
	    p23.put("Zip code", "S4P3Y2");
	    p23.put("Address Line 1", "1770 Hamilton St");
	    p23.put("Address Line 2", "Unit 9B");

	    TreeMap<String, String> p24 = new TreeMap<>();
	    p24.put("First Name", "Hugo");
	    p24.put("Middle Name", "Reinhard");
	    p24.put("Last Name", "Seemann");
	    p24.put("Name Suffix", "III");
	    p24.put("Email", "hugo.seemann@mailto.plus");
	    p24.put("Social Security Number", "716-28-5590");
	    p24.put("Phone number", "902-555-0324");
	    p24.put("Date of Birth", "12/01/1987");
	    p24.put("State", "Nova Scotia");
	    p24.put("Zip code", "B3J2K9");
	    p24.put("Address Line 1", "1801 Hollis St");
	    p24.put("Address Line 2", "Suite 300");

	    TreeMap<String, String> p25 = new TreeMap<>();
	    p25.put("First Name", "Tristan");
	    p25.put("Middle Name", "Gustav");
	    p25.put("Last Name", "Eckhardt");
	    p25.put("Name Suffix", "II");
	    p25.put("Email", "tristan.eckhardt@mailto.plus");
	    p25.put("Social Security Number", "724-93-7002");
	    p25.put("Phone number", "902-555-0325");
	    p25.put("Date of Birth", "04/16/1990");
	    p25.put("State", "Nova Scotia");
	    p25.put("Zip code", "B2Y1A1");
	    p25.put("Address Line 1", "50 Alderney Dr");
	    p25.put("Address Line 2", "Unit 5C");

	    TreeMap<String, String> p26 = new TreeMap<>();
	    p26.put("First Name", "Emmett");
	    p26.put("Middle Name", "Friedrich");
	    p26.put("Last Name", "Sauer");
	    p26.put("Name Suffix", "Jr");
	    p26.put("Email", "emmett.sauer@mailto.plus");
	    p26.put("Social Security Number", "737-16-2841");
	    p26.put("Phone number", "709-555-0326");
	    p26.put("Date of Birth", "09/02/1992");
	    p26.put("State", "Newfoundland and Labrador");
	    p26.put("Zip code", "A1C1A1");
	    p26.put("Address Line 1", "10 Duckworth St");
	    p26.put("Address Line 2", "Apt 4D");

	    TreeMap<String, String> p27 = new TreeMap<>();
	    p27.put("First Name", "Owen");
	    p27.put("Middle Name", "Leopold");
	    p27.put("Last Name", "Krohn");
	    p27.put("Name Suffix", "Sr");
	    p27.put("Email", "owen.krohn@mailto.plus");
	    p27.put("Social Security Number", "708-54-9317");
	    p27.put("Phone number", "709-555-0327");
	    p27.put("Date of Birth", "01/11/1989");
	    p27.put("State", "Newfoundland and Labrador");
	    p27.put("Zip code", "A1A0A1");
	    p27.put("Address Line 1", "100 Kenmount Rd");
	    p27.put("Address Line 2", "Unit 8B");

	    TreeMap<String, String> p28 = new TreeMap<>();
	    p28.put("First Name", "Anton");
	    p28.put("Middle Name", "Niklas");
	    p28.put("Last Name", "Albrecht");
	    p28.put("Name Suffix", "II");
	    p28.put("Email", "anton.albrecht@mailto.plus");
	    p28.put("Social Security Number", "723-60-4108");
	    p28.put("Phone number", "506-555-0328");
	    p28.put("Date of Birth", "06/30/1994");
	    p28.put("State", "New Brunswick");
	    p28.put("Zip code", "E2L4Z6");
	    p28.put("Address Line 1", "1 King St");
	    p28.put("Address Line 2", "Suite 110");

	    TreeMap<String, String> p29 = new TreeMap<>();
	    p29.put("First Name", "Rafael");
	    p29.put("Middle Name", "Bernhard");
	    p29.put("Last Name", "Hennig");
	    p29.put("Name Suffix", "III");
	    p29.put("Email", "rafael.hennig@mailto.plus");
	    p29.put("Social Security Number", "711-82-5396");
	    p29.put("Phone number", "506-555-0329");
	    p29.put("Date of Birth", "10/20/1990");
	    p29.put("State", "New Brunswick");
	    p29.put("Zip code", "E3B1A1");
	    p29.put("Address Line 1", "440 King St");
	    p29.put("Address Line 2", "Apt 7E");

	    TreeMap<String, String> p30 = new TreeMap<>();
	    p30.put("First Name", "Dominik");
	    p30.put("Middle Name", "Ernst");
	    p30.put("Last Name", "Lindner");
	    p30.put("Name Suffix", "Jr");
	    p30.put("Email", "dominik.lindner@mailto.plus");
	    p30.put("Social Security Number", "735-07-2601");
	    p30.put("Phone number", "514-555-0330");
	    p30.put("Date of Birth", "02/17/1991");
	    p30.put("State", "Quebec");
	    p30.put("Zip code", "H3B1A1");
	    p30.put("Address Line 1", "1250 Rene-Levesque Blvd W");
	    p30.put("Address Line 2", "Unit 1207");

	    TreeMap<String, String> p31 = new TreeMap<>();
	    p31.put("First Name", "Julian");
	    p31.put("Middle Name", "Konrad");
	    p31.put("Last Name", "Meier");
	    p31.put("Name Suffix", "II");
	    p31.put("Email", "julian.meier@mailto.plus");
	    p31.put("Social Security Number", "722-41-9067");
	    p31.put("Phone number", "438-555-0331");
	    p31.put("Date of Birth", "07/19/1993");
	    p31.put("State", "Quebec");
	    p31.put("Zip code", "H2X3X1");
	    p31.put("Address Line 1", "350 Rue Saint-Paul E");
	    p31.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p32 = new TreeMap<>();
	    p32.put("First Name", "Micah");
	    p32.put("Middle Name", "Johann");
	    p32.put("Last Name", "Schroeder");
	    p32.put("Name Suffix", "Sr");
	    p32.put("Email", "micah.schroeder@mailto.plus");
	    p32.put("Social Security Number", "707-24-8159");
	    p32.put("Phone number", "613-555-0332");
	    p32.put("Date of Birth", "12/05/1988");
	    p32.put("State", "Ontario");
	    p32.put("Zip code", "K1P1A1");
	    p32.put("Address Line 1", "110 Laurier Ave W");
	    p32.put("Address Line 2", "Suite 610");

	    TreeMap<String, String> p33 = new TreeMap<>();
	    p33.put("First Name", "Caleb");
	    p33.put("Middle Name", "Armin");
	    p33.put("Last Name", "Eberhardt");
	    p33.put("Name Suffix", "III");
	    p33.put("Email", "caleb.eberhardt@mailto.plus");
	    p33.put("Social Security Number", "734-20-5714");
	    p33.put("Phone number", "613-555-0333");
	    p33.put("Date of Birth", "03/09/1992");
	    p33.put("State", "Ontario");
	    p33.put("Zip code", "K2P1L4");
	    p33.put("Address Line 1", "200 Elgin St");
	    p33.put("Address Line 2", "Unit 7B");

	    TreeMap<String, String> p34 = new TreeMap<>();
	    p34.put("First Name", "Nathan");
	    p34.put("Middle Name", "Werner");
	    p34.put("Last Name", "Brunner");
	    p34.put("Name Suffix", "Jr");
	    p34.put("Email", "nathan.brunner@mailto.plus");
	    p34.put("Social Security Number", "718-47-0936");
	    p34.put("Phone number", "902-555-0334");
	    p34.put("Date of Birth", "08/12/1990");
	    p34.put("State", "Nova Scotia");
	    p34.put("Zip code", "B3H1A1");
	    p34.put("Address Line 1", "5909 Spring Garden Rd");
	    p34.put("Address Line 2", "Apt 12B");

	    TreeMap<String, String> p35 = new TreeMap<>();
	    p35.put("First Name", "Levi");
	    p35.put("Middle Name", "Manuel");
	    p35.put("Last Name", "Bergmann");
	    p35.put("Name Suffix", "II");
	    p35.put("Email", "levi.bergmann@mailto.plus");
	    p35.put("Social Security Number", "726-59-8801");
	    p35.put("Phone number", "780-555-0335");
	    p35.put("Date of Birth", "01/22/1994");
	    p35.put("State", "Alberta");
	    p35.put("Zip code", "T5H1A1");
	    p35.put("Address Line 1", "10150 100 St NW");
	    p35.put("Address Line 2", "Suite 310");

	    TreeMap<String, String> p36 = new TreeMap<>();
	    p36.put("First Name", "Marek");
	    p36.put("Middle Name", "Ferdinand");
	    p36.put("Last Name", "Schmidt");
	    p36.put("Name Suffix", "Sr");
	    p36.put("Email", "marek.schmidt@mailto.plus");
	    p36.put("Social Security Number", "709-46-1028");
	    p36.put("Phone number", "905-555-0336");
	    p36.put("Date of Birth", "06/06/1987");
	    p36.put("State", "Ontario");
	    p36.put("Zip code", "L2G1A1");
	    p36.put("Address Line 1", "5000 Victoria Ave");
	    p36.put("Address Line 2", "Apt 5A");

	    TreeMap<String, String> p37 = new TreeMap<>();
	    p37.put("First Name", "Elias");
	    p37.put("Middle Name", "Gerrit");
	    p37.put("Last Name", "Seifert");
	    p37.put("Name Suffix", "III");
	    p37.put("Email", "elias.seifert2@mailto.plus");
	    p37.put("Social Security Number", "735-61-8907");
	    p37.put("Phone number", "604-555-0337");
	    p37.put("Date of Birth", "09/19/1992");
	    p37.put("State", "British Columbia");
	    p37.put("Zip code", "V5T1A1");
	    p37.put("Address Line 1", "800 Kingsway");
	    p37.put("Address Line 2", "Apt 9C");

	    TreeMap<String, String> p38 = new TreeMap<>();
	    p38.put("First Name", "Harrison");
	    p38.put("Middle Name", "Klaus");
	    p38.put("Last Name", "Koenig");
	    p38.put("Name Suffix", "Jr");
	    p38.put("Email", "harrison.koenig@mailto.plus");
	    p38.put("Social Security Number", "720-14-5073");
	    p38.put("Phone number", "778-555-0338");
	    p38.put("Date of Birth", "12/14/1989");
	    p38.put("State", "British Columbia");
	    p38.put("Zip code", "V6E1A1");
	    p38.put("Address Line 1", "1160 Burrard St");
	    p38.put("Address Line 2", "Unit 12D");

	    TreeMap<String, String> p39 = new TreeMap<>();
	    p39.put("First Name", "Roman");
	    p39.put("Middle Name", "Leopold");
	    p39.put("Last Name", "Stahl");
	    p39.put("Name Suffix", "II");
	    p39.put("Email", "roman.stahl@mailto.plus");
	    p39.put("Social Security Number", "713-98-2410");
	    p39.put("Phone number", "587-555-0339");
	    p39.put("Date of Birth", "04/02/1991");
	    p39.put("State", "Alberta");
	    p39.put("Zip code", "T6G2R3");
	    p39.put("Address Line 1", "11011 Jasper Ave NW");
	    p39.put("Address Line 2", "Apt 4C");

	    TreeMap<String, String> p40 = new TreeMap<>();
	    p40.put("First Name", "Theo");
	    p40.put("Middle Name", "Ernst");
	    p40.put("Last Name", "Sattler");
	    p40.put("Name Suffix", "Sr");
	    p40.put("Email", "theo.sattler@mailto.plus");
	    p40.put("Social Security Number", "727-32-6514");
	    p40.put("Phone number", "204-555-0340");
	    p40.put("Date of Birth", "10/01/1988");
	    p40.put("State", "Manitoba");
	    p40.put("Zip code", "R3B1A1");
	    p40.put("Address Line 1", "123 Main St");
	    p40.put("Address Line 2", "Unit 10A");

	    TreeMap<String, String> p41 = new TreeMap<>();
	    p41.put("First Name", "Tristan");
	    p41.put("Middle Name", "Niklas");
	    p41.put("Last Name", "Becker");
	    p41.put("Name Suffix", "III");
	    p41.put("Email", "tristan.becker@mailto.plus");
	    p41.put("Social Security Number", "706-75-9081");
	    p41.put("Phone number", "647-555-0341");
	    p41.put("Date of Birth", "06/12/1993");
	    p41.put("State", "Ontario");
	    p41.put("Zip code", "M5S1A1");
	    p41.put("Address Line 1", "100 St George St");
	    p41.put("Address Line 2", "Unit 3B");

	    TreeMap<String, String> p42 = new TreeMap<>();
	    p42.put("First Name", "Oskar");
	    p42.put("Middle Name", "Bernhard");
	    p42.put("Last Name", "Lang");
	    p42.put("Name Suffix", "Jr");
	    p42.put("Email", "oskar.lang@mailto.plus");
	    p42.put("Social Security Number", "732-20-4479");
	    p42.put("Phone number", "905-555-0342");
	    p42.put("Date of Birth", "01/05/1990");
	    p42.put("State", "Ontario");
	    p42.put("Zip code", "M4Y1A1");
	    p42.put("Address Line 1", "100 Wellesley St E");
	    p42.put("Address Line 2", "Unit 7D");

	    TreeMap<String, String> p43 = new TreeMap<>();
	    p43.put("First Name", "Axel");
	    p43.put("Middle Name", "Christian");
	    p43.put("Last Name", "Vogt");
	    p43.put("Name Suffix", "II");
	    p43.put("Email", "axel.vogt@mailto.plus");
	    p43.put("Social Security Number", "715-40-2318");
	    p43.put("Phone number", "416-555-0343");
	    p43.put("Date of Birth", "12/29/1987");
	    p43.put("State", "Ontario");
	    p43.put("Zip code", "M5V1A1");
	    p43.put("Address Line 1", "88 King St W");
	    p43.put("Address Line 2", "Unit 604");

	    TreeMap<String, String> p44 = new TreeMap<>();
	    p44.put("First Name", "Nico");
	    p44.put("Middle Name", "Gustav");
	    p44.put("Last Name", "Kremer");
	    p44.put("Name Suffix", "Sr");
	    p44.put("Email", "nico.kremer@mailto.plus");
	    p44.put("Social Security Number", "728-67-9980");
	    p44.put("Phone number", "438-555-0344");
	    p44.put("Date of Birth", "03/21/1991");
	    p44.put("State", "Quebec");
	    p44.put("Zip code", "H3A1A1");
	    p44.put("Address Line 1", "845 Sherbrooke St W");
	    p44.put("Address Line 2", "Unit 8C");

	    TreeMap<String, String> p45 = new TreeMap<>();
	    p45.put("First Name", "Levi");
	    p45.put("Middle Name", "Konrad");
	    p45.put("Last Name", "Bauer");
	    p45.put("Name Suffix", "III");
	    p45.put("Email", "levi.bauer@mailto.plus");
	    p45.put("Social Security Number", "737-83-1064");
	    p45.put("Phone number", "514-555-0345");
	    p45.put("Date of Birth", "08/08/1992");
	    p45.put("State", "Quebec");
	    p45.put("Zip code", "H3B1A1");
	    p45.put("Address Line 1", "1250 Rene-Levesque Blvd W");
	    p45.put("Address Line 2", "Unit 906");

	    TreeMap<String, String> p46 = new TreeMap<>();
	    p46.put("First Name", "Emanuel");
	    p46.put("Middle Name", "Armin");
	    p46.put("Last Name", "Keller");
	    p46.put("Name Suffix", "II");
	    p46.put("Email", "emanuel.keller@mailto.plus");
	    p46.put("Social Security Number", "712-05-6640");
	    p46.put("Phone number", "709-555-0346");
	    p46.put("Date of Birth", "02/25/1989");
	    p46.put("State", "Newfoundland and Labrador");
	    p46.put("Zip code", "A1C1A1");
	    p46.put("Address Line 1", "10 Duckworth St");
	    p46.put("Address Line 2", "Apt 9A");

	    TreeMap<String, String> p47 = new TreeMap<>();
	    p47.put("First Name", "Ronan");
	    p47.put("Middle Name", "Matthias");
	    p47.put("Last Name", "Schulte");
	    p47.put("Name Suffix", "Jr");
	    p47.put("Email", "ronan.schulte@mailto.plus");
	    p47.put("Social Security Number", "730-69-2458");
	    p47.put("Phone number", "506-555-0347");
	    p47.put("Date of Birth", "11/11/1993");
	    p47.put("State", "New Brunswick");
	    p47.put("Zip code", "E3B1A1");
	    p47.put("Address Line 1", "440 King St");
	    p47.put("Address Line 2", "Apt 10D");

	    TreeMap<String, String> p48 = new TreeMap<>();
	    p48.put("First Name", "Marcel");
	    p48.put("Middle Name", "Werner");
	    p48.put("Last Name", "Richter");
	    p48.put("Name Suffix", "III");
	    p48.put("Email", "marcel.richter@mailto.plus");
	    p48.put("Social Security Number", "707-91-4082");
	    p48.put("Phone number", "902-555-0348");
	    p48.put("Date of Birth", "04/04/1990");
	    p48.put("State", "Nova Scotia");
	    p48.put("Zip code", "B3J2K9");
	    p48.put("Address Line 1", "1801 Hollis St");
	    p48.put("Address Line 2", "Suite 510");

	    TreeMap<String, String> p49 = new TreeMap<>();
	    p49.put("First Name", "Dieter");
	    p49.put("Middle Name", "Johannes");
	    p49.put("Last Name", "Zimmermann");
	    p49.put("Name Suffix", "Sr");
	    p49.put("Email", "dieter.zimmermann@mailto.plus");
	    p49.put("Social Security Number", "724-10-9903");
	    p49.put("Phone number", "306-555-0349");
	    p49.put("Date of Birth", "09/09/1988");
	    p49.put("State", "Saskatchewan");
	    p49.put("Zip code", "S7K1A1");
	    p49.put("Address Line 1", "200 1st Ave N");
	    p49.put("Address Line 2", "Apt 11B");

	    TreeMap<String, String> p50 = new TreeMap<>();
	    p50.put("First Name", "Nathan");
	    p50.put("Middle Name", "Leopold");
	    p50.put("Last Name", "Engel");
	    p50.put("Name Suffix", "II");
	    p50.put("Email", "nathan.engel@mailto.plus");
	    p50.put("Social Security Number", "716-44-8031");
	    p50.put("Phone number", "403-555-0350");
	    p50.put("Date of Birth", "01/30/1992");
	    p50.put("State", "Alberta");
	    p50.put("Zip code", "T2P1A1");
	    p50.put("Address Line 1", "200 8 Ave SW");
	    p50.put("Address Line 2", "Suite 900");

	    return new Object[][]{
	        {p1},{p2},{p3},{p4},{p5},
	        {p6},{p7},{p8},{p9},{p10},
	        {p11},{p12},{p13},{p14},{p15},
	        {p16},{p17},{p18},{p19},{p20},
	        {p21},{p22},{p23},{p24},{p25},
	        {p26},{p27},{p28},{p29},{p30},
	        {p31},{p32},{p33},{p34},{p35},
	        {p36},{p37},{p38},{p39},{p40},
	        {p41},{p42},{p43},{p44},{p45},
	        {p46},{p47},{p48},{p49},{p50}
	    };
	}







}
	
	
	
	
	
	
	


