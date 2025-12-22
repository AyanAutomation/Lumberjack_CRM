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

		TreeMap<String, String> p1 = new TreeMap<String, String>();
	    p1.put("First Name", "Korbinian");
	    p1.put("Middle Name", "Alois");
	    p1.put("Last Name", "Falkenrath");
	    p1.put("Name Suffix", "Jr");
	    p1.put("Email", "korbinian.falkenrath@mailto.plus");
	    p1.put("Social Security Number", "900-11-0001");
	    p1.put("Phone number", "312-555-2101");
	    p1.put("Date of Birth", "02/14/1991");
	    p1.put("State", "Illinois");
	    p1.put("Zip code", "60601");
	    p1.put("Address Line 1", "221 Lake Shore Dr");
	    p1.put("Address Line 2", "Apt 10B");

	    TreeMap<String, String> p2 = new TreeMap<String, String>();
	    p2.put("First Name", "Kajetan");
	    p2.put("Middle Name", "Leopold");
	    p2.put("Last Name", "Reichenbach");
	    p2.put("Name Suffix", "Sr");
	    p2.put("Email", "kajetan.reichenbach@mailto.plus");
	    p2.put("Social Security Number", "900-12-0002");
	    p2.put("Phone number", "317-555-2102");
	    p2.put("Date of Birth", "11/09/1988");
	    p2.put("State", "Indiana");
	    p2.put("Zip code", "46204");
	    p2.put("Address Line 1", "410 Meridian St");
	    p2.put("Address Line 2", "Suite 210");

	    TreeMap<String, String> p3 = new TreeMap<String, String>();
	    p3.put("First Name", "Tassilo");
	    p3.put("Middle Name", "Gregor");
	    p3.put("Last Name", "Hagedorn");
	    p3.put("Name Suffix", "II");
	    p3.put("Email", "tassilo.hagedorn@mailto.plus");
	    p3.put("Social Security Number", "900-13-0003");
	    p3.put("Phone number", "305-555-2103");
	    p3.put("Date of Birth", "07/23/1994");
	    p3.put("State", "Florida");
	    p3.put("Zip code", "33101");
	    p3.put("Address Line 1", "980 Biscayne Blvd");
	    p3.put("Address Line 2", "Unit 6A");

	    TreeMap<String, String> p4 = new TreeMap<String, String>();
	    p4.put("First Name", "Severin");
	    p4.put("Middle Name", "Matthias");
	    p4.put("Last Name", "Gruenwald");
	    p4.put("Name Suffix", "III");
	    p4.put("Email", "severin.gruenwald@mailto.plus");
	    p4.put("Social Security Number", "900-14-0004");
	    p4.put("Phone number", "808-555-2104");
	    p4.put("Date of Birth", "04/02/1992");
	    p4.put("State", "Hawaii");
	    p4.put("Zip code", "96813");
	    p4.put("Address Line 1", "700 Ala Moana Blvd");
	    p4.put("Address Line 2", "Floor 4");

	    TreeMap<String, String> p5 = new TreeMap<String, String>();
	    p5.put("First Name", "Anselm");
	    p5.put("Middle Name", "Konrad");
	    p5.put("Last Name", "Felsenstein");
	    p5.put("Name Suffix", "Jr");
	    p5.put("Email", "anselm.felsenstein@mailto.plus");
	    p5.put("Social Security Number", "900-15-0005");
	    p5.put("Phone number", "515-555-2105");
	    p5.put("Date of Birth", "09/18/1989");
	    p5.put("State", "Iowa");
	    p5.put("Zip code", "50309");
	    p5.put("Address Line 1", "1500 Grand Ave");
	    p5.put("Address Line 2", "Apt 11C");

	    TreeMap<String, String> p6 = new TreeMap<String, String>();
	    p6.put("First Name", "Leander");
	    p6.put("Middle Name", "Friedrich");
	    p6.put("Last Name", "Eisenhauer");
	    p6.put("Name Suffix", "Sr");
	    p6.put("Email", "leander.eisenhauer@mailto.plus");
	    p6.put("Social Security Number", "900-16-0006");
	    p6.put("Phone number", "785-555-2106");
	    p6.put("Date of Birth", "01/30/1990");
	    p6.put("State", "Kansas");
	    p6.put("Zip code", "66603");
	    p6.put("Address Line 1", "901 S Kansas Ave");
	    p6.put("Address Line 2", "Room 16");

	    TreeMap<String, String> p7 = new TreeMap<String, String>();
	    p7.put("First Name", "Ruediger");
	    p7.put("Middle Name", "Benedikt");
	    p7.put("Last Name", "Tannenbaum");
	    p7.put("Name Suffix", "II");
	    p7.put("Email", "ruediger.tannenbaum@mailto.plus");
	    p7.put("Social Security Number", "900-17-0007");
	    p7.put("Phone number", "671-555-2107");
	    p7.put("Date of Birth", "06/11/1993");
	    p7.put("State", "Guam");
	    p7.put("Zip code", "96910");
	    p7.put("Address Line 1", "12 Marine Corps Dr");
	    p7.put("Address Line 2", "PO Box 90");

	    TreeMap<String, String> p8 = new TreeMap<String, String>();
	    p8.put("First Name", "Wolfram");
	    p8.put("Middle Name", "Niklas");
	    p8.put("Last Name", "Morgenstern");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "wolfram.morgenstern@mailto.plus");
	    p8.put("Social Security Number", "900-18-0008");
	    p8.put("Phone number", "208-555-2108");
	    p8.put("Date of Birth", "12/05/1996");
	    p8.put("State", "Idaho");
	    p8.put("Zip code", "83702");
	    p8.put("Address Line 1", "500 W Main St");
	    p8.put("Address Line 2", "Apt 3D");

	    TreeMap<String, String> p9 = new TreeMap<String, String>();
	    p9.put("First Name", "Gereon");
	    p9.put("Middle Name", "Werner");
	    p9.put("Last Name", "Heidenreich");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "gereon.heidenreich@mailto.plus");
	    p9.put("Social Security Number", "900-19-0009");
	    p9.put("Phone number", "617-555-2109");
	    p9.put("Date of Birth", "03/07/1992");
	    p9.put("State", "Massachusetts");
	    p9.put("Zip code", "02108");
	    p9.put("Address Line 1", "45 Beacon St");
	    p9.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p10 = new TreeMap<String, String>();
	    p10.put("First Name", "Othmar");
	    p10.put("Middle Name", "Siegfried");
	    p10.put("Last Name", "Silbermann");
	    p10.put("Name Suffix", "II");
	    p10.put("Email", "othmar.silbermann@mailto.plus");
	    p10.put("Social Security Number", "900-20-0010");
	    p10.put("Phone number", "646-555-2110");
	    p10.put("Date of Birth", "10/21/1994");
	    p10.put("State", "New York");
	    p10.put("Zip code", "10001");
	    p10.put("Address Line 1", "350 7th Ave");
	    p10.put("Address Line 2", "Apt 21A");

	    TreeMap<String, String> p11 = new TreeMap<String, String>();
	    p11.put("First Name", "Hartwig");
	    p11.put("Middle Name", "Elias");
	    p11.put("Last Name", "Niedermaier");
	    p11.put("Name Suffix", "III");
	    p11.put("Email", "hartwig.niedermaier@mailto.plus");
	    p11.put("Social Security Number", "900-21-0011");
	    p11.put("Phone number", "303-555-2111");
	    p11.put("Date of Birth", "08/12/1991");
	    p11.put("State", "Colorado");
	    p11.put("Zip code", "80202");
	    p11.put("Address Line 1", "1600 California St");
	    p11.put("Address Line 2", "Suite 950");

	    TreeMap<String, String> p12 = new TreeMap<String, String>();
	    p12.put("First Name", "Winfried");
	    p12.put("Middle Name", "Gustav");
	    p12.put("Last Name", "Oberhuber");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "winfried.oberhuber@mailto.plus");
	    p12.put("Social Security Number", "900-22-0012");
	    p12.put("Phone number", "206-555-2112");
	    p12.put("Date of Birth", "05/29/1996");
	    p12.put("State", "Washington");
	    p12.put("Zip code", "98101");
	    p12.put("Address Line 1", "1200 5th Ave");
	    p12.put("Address Line 2", "Floor 7");

	    TreeMap<String, String> p13 = new TreeMap<String, String>();
	    p13.put("First Name", "Siegmund");
	    p13.put("Middle Name", "Otto");
	    p13.put("Last Name", "Brandstetter");
	    p13.put("Name Suffix", "Sr");
	    p13.put("Email", "siegmund.brandstetter@mailto.plus");
	    p13.put("Social Security Number", "900-23-0013");
	    p13.put("Phone number", "702-555-2113");
	    p13.put("Date of Birth", "01/16/1988");
	    p13.put("State", "Nevada");
	    p13.put("Zip code", "89101");
	    p13.put("Address Line 1", "200 S Las Vegas Blvd");
	    p13.put("Address Line 2", "Unit 12C");

	    TreeMap<String, String> p14 = new TreeMap<String, String>();
	    p14.put("First Name", "Dietmar");
	    p14.put("Middle Name", "Andreas");
	    p14.put("Last Name", "Kaltwasser");
	    p14.put("Name Suffix", "II");
	    p14.put("Email", "dietmar.kaltwasser@mailto.plus");
	    p14.put("Social Security Number", "900-24-0014");
	    p14.put("Phone number", "504-555-2114");
	    p14.put("Date of Birth", "12/09/1993");
	    p14.put("State", "Louisiana");
	    p14.put("Zip code", "70112");
	    p14.put("Address Line 1", "909 Poydras St");
	    p14.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p15 = new TreeMap<String, String>();
	    p15.put("First Name", "Ruprecht");
	    p15.put("Middle Name", "Philipp");
	    p15.put("Last Name", "Neuschwander");
	    p15.put("Name Suffix", "Jr");
	    p15.put("Email", "ruprecht.neuschwander@mailto.plus");
	    p15.put("Social Security Number", "900-25-0015");
	    p15.put("Phone number", "602-555-2115");
	    p15.put("Date of Birth", "06/03/1990");
	    p15.put("State", "Arizona");
	    p15.put("Zip code", "85004");
	    p15.put("Address Line 1", "1 N Central Ave");
	    p15.put("Address Line 2", "Suite 740");

	    TreeMap<String, String> p16 = new TreeMap<String, String>();
	    p16.put("First Name", "Eckhart");
	    p16.put("Middle Name", "Camille");
	    p16.put("Last Name", "Pfaffenberger");
	    p16.put("Name Suffix", "III");
	    p16.put("Email", "eckhart.pfaffenberger@mailto.plus");
	    p16.put("Social Security Number", "900-26-0016");
	    p16.put("Phone number", "615-555-2116");
	    p16.put("Date of Birth", "02/27/1995");
	    p16.put("State", "Tennessee");
	    p16.put("Zip code", "37219");
	    p16.put("Address Line 1", "301 Church St");
	    p16.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p17 = new TreeMap<String, String>();
	    p17.put("First Name", "Hinnerk");
	    p17.put("Middle Name", "Alexander");
	    p17.put("Last Name", "Schifferle");
	    p17.put("Name Suffix", "Sr");
	    p17.put("Email", "hinnerk.schifferle@mailto.plus");
	    p17.put("Social Security Number", "900-27-0017");
	    p17.put("Phone number", "404-555-2117");
	    p17.put("Date of Birth", "09/01/1992");
	    p17.put("State", "Georgia");
	    p17.put("Zip code", "30303");
	    p17.put("Address Line 1", "200 Peachtree St");
	    p17.put("Address Line 2", "Suite 330");

	    TreeMap<String, String> p18 = new TreeMap<String, String>();
	    p18.put("First Name", "Xaver");
	    p18.put("Middle Name", "Andre");
	    p18.put("Last Name", "Steigerwald");
	    p18.put("Name Suffix", "II");
	    p18.put("Email", "xaver.steigerwald@mailto.plus");
	    p18.put("Social Security Number", "900-28-0018");
	    p18.put("Phone number", "313-555-2118");
	    p18.put("Date of Birth", "04/10/1989");
	    p18.put("State", "Michigan");
	    p18.put("Zip code", "48226");
	    p18.put("Address Line 1", "500 Woodward Ave");
	    p18.put("Address Line 2", "Floor 14");

	    TreeMap<String, String> p19 = new TreeMap<String, String>();
	    p19.put("First Name", "Kaspar");
	    p19.put("Middle Name", "Theron");
	    p19.put("Last Name", "Kienzle");
	    p19.put("Name Suffix", "III");
	    p19.put("Email", "kaspar.kienzle@mailto.plus");
	    p19.put("Social Security Number", "900-29-0019");
	    p19.put("Phone number", "214-555-2119");
	    p19.put("Date of Birth", "07/19/1996");
	    p19.put("State", "Texas");
	    p19.put("Zip code", "75201");
	    p19.put("Address Line 1", "2100 Ross Ave");
	    p19.put("Address Line 2", "Unit 6B");

	    TreeMap<String, String> p20 = new TreeMap<String, String>();
	    p20.put("First Name", "Thilo");
	    p20.put("Middle Name", "Luc");
	    p20.put("Last Name", "Buchenwald");
	    p20.put("Name Suffix", "Jr");
	    p20.put("Email", "thilo.buchenwald@mailto.plus");
	    p20.put("Social Security Number", "900-30-0020");
	    p20.put("Phone number", "801-555-2120");
	    p20.put("Date of Birth", "11/15/1991");
	    p20.put("State", "Utah");
	    p20.put("Zip code", "84111");
	    p20.put("Address Line 1", "50 S Main St");
	    p20.put("Address Line 2", "Apt 8F");

	    // ---- 21 to 50 (all new uncommon names) ----

	    TreeMap<String, String> p21 = new TreeMap<String, String>();
	    p21.put("First Name", "Arvid");
	    p21.put("Middle Name", "Markus");
	    p21.put("Last Name", "Himmelbauer");
	    p21.put("Name Suffix", "II");
	    p21.put("Email", "arvid.himmelbauer@mailto.plus");
	    p21.put("Social Security Number", "900-31-0021");
	    p21.put("Phone number", "617-555-2121");
	    p21.put("Date of Birth", "02/10/1993");
	    p21.put("State", "Massachusetts");
	    p21.put("Zip code", "02110");
	    p21.put("Address Line 1", "101 Federal St");
	    p21.put("Address Line 2", "Suite 420");

	    TreeMap<String, String> p22 = new TreeMap<String, String>();
	    p22.put("First Name", "Torsten");
	    p22.put("Middle Name", "Leopold");
	    p22.put("Last Name", "Ziegelmeyer");
	    p22.put("Name Suffix", "Sr");
	    p22.put("Email", "torsten.ziegelmeyer@mailto.plus");
	    p22.put("Social Security Number", "900-32-0022");
	    p22.put("Phone number", "303-555-2122");
	    p22.put("Date of Birth", "12/22/1987");
	    p22.put("State", "Colorado");
	    p22.put("Zip code", "80203");
	    p22.put("Address Line 1", "900 Grant St");
	    p22.put("Address Line 2", "Apt 4A");

	    TreeMap<String, String> p23 = new TreeMap<String, String>();
	    p23.put("First Name", "Soeren");
	    p23.put("Middle Name", "Ernst");
	    p23.put("Last Name", "Vogelsang");
	    p23.put("Name Suffix", "III");
	    p23.put("Email", "soeren.vogelsang@mailto.plus");
	    p23.put("Social Security Number", "900-33-0023");
	    p23.put("Phone number", "214-555-2123");
	    p23.put("Date of Birth", "06/05/1991");
	    p23.put("State", "Texas");
	    p23.put("Zip code", "75202");
	    p23.put("Address Line 1", "150 N Pearl St");
	    p23.put("Address Line 2", "Unit 10C");

	    TreeMap<String, String> p24 = new TreeMap<String, String>();
	    p24.put("First Name", "Ulrich");
	    p24.put("Middle Name", "Johannes");
	    p24.put("Last Name", "Schlotterbeck");
	    p24.put("Name Suffix", "Jr");
	    p24.put("Email", "ulrich.schlotterbeck@mailto.plus");
	    p24.put("Social Security Number", "900-34-0024");
	    p24.put("Phone number", "312-555-2124");
	    p24.put("Date of Birth", "09/09/1990");
	    p24.put("State", "Illinois");
	    p24.put("Zip code", "60606");
	    p24.put("Address Line 1", "233 S Wacker Dr");
	    p24.put("Address Line 2", "Suite 800");

	    TreeMap<String, String> p25 = new TreeMap<String, String>();
	    p25.put("First Name", "Jorrit");
	    p25.put("Middle Name", "Ferdinand");
	    p25.put("Last Name", "Kreuzer");
	    p25.put("Name Suffix", "II");
	    p25.put("Email", "jorrit.kreuzer@mailto.plus");
	    p25.put("Social Security Number", "900-35-0025");
	    p25.put("Phone number", "317-555-2125");
	    p25.put("Date of Birth", "02/02/1994");
	    p25.put("State", "Indiana");
	    p25.put("Zip code", "46202");
	    p25.put("Address Line 1", "1 N Capitol Ave");
	    p25.put("Address Line 2", "Apt 7D");

	    TreeMap<String, String> p26 = new TreeMap<String, String>();
	    p26.put("First Name", "Eike");
	    p26.put("Middle Name", "Friedrich");
	    p26.put("Last Name", "Brennholz");
	    p26.put("Name Suffix", "Sr");
	    p26.put("Email", "eike.brennholz@mailto.plus");
	    p26.put("Social Security Number", "900-36-0026");
	    p26.put("Phone number", "206-555-2126");
	    p26.put("Date of Birth", "10/14/1988");
	    p26.put("State", "Washington");
	    p26.put("Zip code", "98104");
	    p26.put("Address Line 1", "700 5th Ave");
	    p26.put("Address Line 2", "Floor 9");

	    TreeMap<String, String> p27 = new TreeMap<String, String>();
	    p27.put("First Name", "Malte");
	    p27.put("Middle Name", "Andreas");
	    p27.put("Last Name", "Schneefeld");
	    p27.put("Name Suffix", "III");
	    p27.put("Email", "malte.schneefeld@mailto.plus");
	    p27.put("Social Security Number", "900-37-0027");
	    p27.put("Phone number", "404-555-2127");
	    p27.put("Date of Birth", "08/08/1991");
	    p27.put("State", "Georgia");
	    p27.put("Zip code", "30308");
	    p27.put("Address Line 1", "800 Peachtree St NE");
	    p27.put("Address Line 2", "Apt 5B");

	    TreeMap<String, String> p28 = new TreeMap<String, String>();
	    p28.put("First Name", "Rune");
	    p28.put("Middle Name", "Niklas");
	    p28.put("Last Name", "Kesseldorf");
	    p28.put("Name Suffix", "Jr");
	    p28.put("Email", "rune.kesseldorf@mailto.plus");
	    p28.put("Social Security Number", "900-38-0028");
	    p28.put("Phone number", "702-555-2128");
	    p28.put("Date of Birth", "01/01/1993");
	    p28.put("State", "Nevada");
	    p28.put("Zip code", "89109");
	    p28.put("Address Line 1", "3555 S Las Vegas Blvd");
	    p28.put("Address Line 2", "Unit 18A");

	    TreeMap<String, String> p29 = new TreeMap<String, String>();
	    p29.put("First Name", "Viggo");
	    p29.put("Middle Name", "Matthias");
	    p29.put("Last Name", "Brandauer");
	    p29.put("Name Suffix", "II");
	    p29.put("Email", "viggo.brandauer@mailto.plus");
	    p29.put("Social Security Number", "900-39-0029");
	    p29.put("Phone number", "615-555-2129");
	    p29.put("Date of Birth", "06/06/1992");
	    p29.put("State", "Tennessee");
	    p29.put("Zip code", "37203");
	    p29.put("Address Line 1", "1200 Broadway");
	    p29.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p30 = new TreeMap<String, String>();
	    p30.put("First Name", "Yorick");
	    p30.put("Middle Name", "Gustav");
	    p30.put("Last Name", "Hartmannsdorf");
	    p30.put("Name Suffix", "Sr");
	    p30.put("Email", "yorick.hartmannsdorf@mailto.plus");
	    p30.put("Social Security Number", "900-40-0030");
	    p30.put("Phone number", "801-555-2130");
	    p30.put("Date of Birth", "12/12/1987");
	    p30.put("State", "Utah");
	    p30.put("Zip code", "84101");
	    p30.put("Address Line 1", "100 S Main St");
	    p30.put("Address Line 2", "Suite 600");

	    TreeMap<String, String> p31 = new TreeMap<String, String>();
	    p31.put("First Name", "Alaric");
	    p31.put("Middle Name", "Theo");
	    p31.put("Last Name", "Kronenberger");
	    p31.put("Name Suffix", "III");
	    p31.put("Email", "alaric.kronenberger@mailto.plus");
	    p31.put("Social Security Number", "900-41-0031");
	    p31.put("Phone number", "407-555-2131");
	    p31.put("Date of Birth", "09/20/1990");
	    p31.put("State", "Florida");
	    p31.put("Zip code", "32801");
	    p31.put("Address Line 1", "100 S Orange Ave");
	    p31.put("Address Line 2", "Unit 18");

	    TreeMap<String, String> p32 = new TreeMap<String, String>();
	    p32.put("First Name", "Bjarne");
	    p32.put("Middle Name", "Elias");
	    p32.put("Last Name", "Schwarzwald");
	    p32.put("Name Suffix", "Jr");
	    p32.put("Email", "bjarne.schwarzwald@mailto.plus");
	    p32.put("Social Security Number", "900-42-0032");
	    p32.put("Phone number", "415-555-2132");
	    p32.put("Date of Birth", "01/27/1992");
	    p32.put("State", "California");
	    p32.put("Zip code", "94103");
	    p32.put("Address Line 1", "50 3rd St");
	    p32.put("Address Line 2", "Apt 6");

	    TreeMap<String, String> p33 = new TreeMap<String, String>();
	    p33.put("First Name", "Timo");
	    p33.put("Middle Name", "Leopold");
	    p33.put("Last Name", "Fichtenbaum");
	    p33.put("Name Suffix", "II");
	    p33.put("Email", "timo.fichtenbaum@mailto.plus");
	    p33.put("Social Security Number", "900-43-0033");
	    p33.put("Phone number", "503-555-2133");
	    p33.put("Date of Birth", "03/03/1991");
	    p33.put("State", "Oregon");
	    p33.put("Zip code", "97204");
	    p33.put("Address Line 1", "700 SW 5th Ave");
	    p33.put("Address Line 2", "Suite 410");

	    TreeMap<String, String> p34 = new TreeMap<String, String>();
	    p34.put("First Name", "Kjell");
	    p34.put("Middle Name", "Sebastian");
	    p34.put("Last Name", "Sonnenfeld");
	    p34.put("Name Suffix", "Sr");
	    p34.put("Email", "kjell.sonnenfeld@mailto.plus");
	    p34.put("Social Security Number", "900-44-0034");
	    p34.put("Phone number", "609-555-2134");
	    p34.put("Date of Birth", "12/01/1989");
	    p34.put("State", "New Jersey");
	    p34.put("Zip code", "08608");
	    p34.put("Address Line 1", "120 E State St");
	    p34.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p35 = new TreeMap<String, String>();
	    p35.put("First Name", "Njal");
	    p35.put("Middle Name", "Ferdinand");
	    p35.put("Last Name", "Winterhalder");
	    p35.put("Name Suffix", "III");
	    p35.put("Email", "njal.winterhalder@mailto.plus");
	    p35.put("Social Security Number", "900-45-0035");
	    p35.put("Phone number", "602-555-2135");
	    p35.put("Date of Birth", "06/18/1990");
	    p35.put("State", "Arizona");
	    p35.put("Zip code", "85003");
	    p35.put("Address Line 1", "100 W Washington St");
	    p35.put("Address Line 2", "Apt 12");

	    TreeMap<String, String> p36 = new TreeMap<String, String>();
	    p36.put("First Name", "Oberon");
	    p36.put("Middle Name", "Armin");
	    p36.put("Last Name", "Bergstrom");
	    p36.put("Name Suffix", "II");
	    p36.put("Email", "oberon.bergstrom@mailto.plus");
	    p36.put("Social Security Number", "900-46-0036");
	    p36.put("Phone number", "206-555-2136");
	    p36.put("Date of Birth", "10/10/1992");
	    p36.put("State", "Washington");
	    p36.put("Zip code", "98109");
	    p36.put("Address Line 1", "500 Westlake Ave N");
	    p36.put("Address Line 2", "Unit 7");

	    TreeMap<String, String> p37 = new TreeMap<String, String>();
	    p37.put("First Name", "Cyrill");
	    p37.put("Middle Name", "Werner");
	    p37.put("Last Name", "Rosenkranz");
	    p37.put("Name Suffix", "Jr");
	    p37.put("Email", "cyrill.rosenkranz@mailto.plus");
	    p37.put("Social Security Number", "900-47-0037");
	    p37.put("Phone number", "614-555-2137");
	    p37.put("Date of Birth", "01/05/1994");
	    p37.put("State", "Ohio");
	    p37.put("Zip code", "43215");
	    p37.put("Address Line 1", "150 N High St");
	    p37.put("Address Line 2", "Suite 220");

	    TreeMap<String, String> p38 = new TreeMap<String, String>();
	    p38.put("First Name", "Ivo");
	    p38.put("Middle Name", "Johannes");
	    p38.put("Last Name", "Falkenstein");
	    p38.put("Name Suffix", "III");
	    p38.put("Email", "ivo.falkenstein@mailto.plus");
	    p38.put("Social Security Number", "900-48-0038");
	    p38.put("Phone number", "312-555-2138");
	    p38.put("Date of Birth", "09/09/1991");
	    p38.put("State", "Illinois");
	    p38.put("Zip code", "60607");
	    p38.put("Address Line 1", "900 W Randolph St");
	    p38.put("Address Line 2", "Unit 14");

	    TreeMap<String, String> p39 = new TreeMap<String, String>();
	    p39.put("First Name", "Jannik");
	    p39.put("Middle Name", "Konrad");
	    p39.put("Last Name", "Eberhardt");
	    p39.put("Name Suffix", "II");
	    p39.put("Email", "jannik.eberhardt@mailto.plus");
	    p39.put("Social Security Number", "900-49-0039");
	    p39.put("Phone number", "313-555-2139");
	    p39.put("Date of Birth", "12/28/1988");
	    p39.put("State", "Michigan");
	    p39.put("Zip code", "48226");
	    p39.put("Address Line 1", "500 Woodward Ave");
	    p39.put("Address Line 2", "Floor 10");

	    TreeMap<String, String> p40 = new TreeMap<String, String>();
	    p40.put("First Name", "Lennart");
	    p40.put("Middle Name", "Gustav");
	    p40.put("Last Name", "Hochstetter");
	    p40.put("Name Suffix", "Sr");
	    p40.put("Email", "lennart.hochstetter@mailto.plus");
	    p40.put("Social Security Number", "900-50-0040");
	    p40.put("Phone number", "603-555-2140");
	    p40.put("Date of Birth", "04/24/1990");
	    p40.put("State", "New Hampshire");
	    p40.put("Zip code", "03101");
	    p40.put("Address Line 1", "1000 Elm St");
	    p40.put("Address Line 2", "Apt 2");

	    TreeMap<String, String> p41 = new TreeMap<String, String>();
	    p41.put("First Name", "Tiberius");
	    p41.put("Middle Name", "Alois");
	    p41.put("Last Name", "Schwerdtfeger");
	    p41.put("Name Suffix", "III");
	    p41.put("Email", "tiberius.schwerdtfeger@mailto.plus");
	    p41.put("Social Security Number", "900-51-0041");
	    p41.put("Phone number", "702-555-2141");
	    p41.put("Date of Birth", "11/21/1991");
	    p41.put("State", "Nevada");
	    p41.put("Zip code", "89103");
	    p41.put("Address Line 1", "500 S Decatur Blvd");
	    p41.put("Address Line 2", "Unit 4B");

	    TreeMap<String, String> p42 = new TreeMap<String, String>();
	    p42.put("First Name", "Cassian");
	    p42.put("Middle Name", "Benedikt");
	    p42.put("Last Name", "Hirschfeld");
	    p42.put("Name Suffix", "Jr");
	    p42.put("Email", "cassian.hirschfeld@mailto.plus");
	    p42.put("Social Security Number", "900-52-0042");
	    p42.put("Phone number", "317-555-2142");
	    p42.put("Date of Birth", "01/19/1993");
	    p42.put("State", "Indiana");
	    p42.put("Zip code", "46225");
	    p42.put("Address Line 1", "50 S Capitol Ave");
	    p42.put("Address Line 2", "Suite 300");

	    TreeMap<String, String> p43 = new TreeMap<String, String>();
	    p43.put("First Name", "Florian");
	    p43.put("Middle Name", "Otto");
	    p43.put("Last Name", "Neubauer");
	    p43.put("Name Suffix", "II");
	    p43.put("Email", "florian.neubauer@mailto.plus");
	    p43.put("Social Security Number", "900-53-0043");
	    p43.put("Phone number", "615-555-2143");
	    p43.put("Date of Birth", "07/08/1994");
	    p43.put("State", "Tennessee");
	    p43.put("Zip code", "37219");
	    p43.put("Address Line 1", "301 Church St");
	    p43.put("Address Line 2", "Apt 14B");

	    TreeMap<String, String> p44 = new TreeMap<String, String>();
	    p44.put("First Name", "Lucian");
	    p44.put("Middle Name", "Elias");
	    p44.put("Last Name", "Kornblum");
	    p44.put("Name Suffix", "Sr");
	    p44.put("Email", "lucian.kornblum@mailto.plus");
	    p44.put("Social Security Number", "900-54-0044");
	    p44.put("Phone number", "305-555-2144");
	    p44.put("Date of Birth", "02/13/1987");
	    p44.put("State", "Florida");
	    p44.put("Zip code", "33130");
	    p44.put("Address Line 1", "200 Brickell Ave");
	    p44.put("Address Line 2", "Apt 9A");

	    TreeMap<String, String> p45 = new TreeMap<String, String>();
	    p45.put("First Name", "Isidor");
	    p45.put("Middle Name", "Friedrich");
	    p45.put("Last Name", "Schwanenberg");
	    p45.put("Name Suffix", "III");
	    p45.put("Email", "isidor.schwanenberg@mailto.plus");
	    p45.put("Social Security Number", "900-55-0045");
	    p45.put("Phone number", "206-555-2145");
	    p45.put("Date of Birth", "03/14/1990");
	    p45.put("State", "Washington");
	    p45.put("Zip code", "98121");
	    p45.put("Address Line 1", "2121 6th Ave");
	    p45.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p46 = new TreeMap<String, String>();
	    p46.put("First Name", "Valentin");
	    p46.put("Middle Name", "Armin");
	    p46.put("Last Name", "Tannhaeuser");
	    p46.put("Name Suffix", "Jr");
	    p46.put("Email", "valentin.tannhaeuser@mailto.plus");
	    p46.put("Social Security Number", "900-56-0046");
	    p46.put("Phone number", "404-555-2146");
	    p46.put("Date of Birth", "12/05/1991");
	    p46.put("State", "Georgia");
	    p46.put("Zip code", "30313");
	    p46.put("Address Line 1", "190 Marietta St NW");
	    p46.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p47 = new TreeMap<String, String>();
	    p47.put("First Name", "Magnus");
	    p47.put("Middle Name", "Johann");
	    p47.put("Last Name", "Edelweiss");
	    p47.put("Name Suffix", "II");
	    p47.put("Email", "magnus.edelweiss@mailto.plus");
	    p47.put("Social Security Number", "900-57-0047");
	    p47.put("Phone number", "785-555-2147");
	    p47.put("Date of Birth", "09/30/1992");
	    p47.put("State", "Kansas");
	    p47.put("Zip code", "66604");
	    p47.put("Address Line 1", "1200 Topeka Blvd");
	    p47.put("Address Line 2", "Unit 9D");

	    TreeMap<String, String> p48 = new TreeMap<String, String>();
	    p48.put("First Name", "Benedict");
	    p48.put("Middle Name", "Konrad");
	    p48.put("Last Name", "Frostmann");
	    p48.put("Name Suffix", "Sr");
	    p48.put("Email", "benedict.frostmann@mailto.plus");
	    p48.put("Social Security Number", "900-58-0048");
	    p48.put("Phone number", "603-555-2148");
	    p48.put("Date of Birth", "06/26/1989");
	    p48.put("State", "New Hampshire");
	    p48.put("Zip code", "03101");
	    p48.put("Address Line 1", "1000 Elm St");
	    p48.put("Address Line 2", "Apt 5C");

	    TreeMap<String, String> p49 = new TreeMap<String, String>();
	    p49.put("First Name", "Sullivan");
	    p49.put("Middle Name", "Niklas");
	    p49.put("Last Name", "Hohenberg");
	    p49.put("Name Suffix", "III");
	    p49.put("Email", "sullivan.hohenberg@mailto.plus");
	    p49.put("Social Security Number", "900-59-0049");
	    p49.put("Phone number", "504-555-2149");
	    p49.put("Date of Birth", "10/05/1989");
	    p49.put("State", "Louisiana");
	    p49.put("Zip code", "70130");
	    p49.put("Address Line 1", "1 Canal St");
	    p49.put("Address Line 2", "Apt 7B");

	    TreeMap<String, String> p50 = new TreeMap<String, String>();
	    p50.put("First Name", "Cillian");
	    p50.put("Middle Name", "Matthias");
	    p50.put("Last Name", "Schreiber");
	    p50.put("Name Suffix", "II");
	    p50.put("Email", "cillian.schreiber@mailto.plus");
	    p50.put("Social Security Number", "900-60-0050");
	    p50.put("Phone number", "214-555-2150");
	    p50.put("Date of Birth", "01/30/1992");
	    p50.put("State", "Texas");
	    p50.put("Zip code", "75204");
	    p50.put("Address Line 1", "3000 McKinney Ave");
	    p50.put("Address Line 2", "Unit 7C");

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
	
	
	
	
	
	
	


