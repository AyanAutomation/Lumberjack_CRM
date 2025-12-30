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
	    p1.put("First Name", "Cassimir");
	    p1.put("Middle Name", "Rowan");
	    p1.put("Last Name", "Vandermere");
	    p1.put("Name Suffix", "III");
	    p1.put("Email", "cassimir.vandermere@mailto.plus");
	    p1.put("Social Security Number", "930-11-0301");
	    p1.put("Phone number", "312-555-4301");
	    p1.put("Date of Birth", "03/19/1992");
	    p1.put("State", "Illinois");
	    p1.put("Zip code", "60604");
	    p1.put("Address Line 1", "55 E Monroe St");
	    p1.put("Address Line 2", "Suite 2100");

	    TreeMap<String, String> p2 = new TreeMap<>();
	    p2.put("First Name", "Leontius");
	    p2.put("Middle Name", "Marek");
	    p2.put("Last Name", "Kovalenko");
	    p2.put("Name Suffix", "Jr");
	    p2.put("Email", "leontius.kovalenko@mailto.plus");
	    p2.put("Social Security Number", "930-12-0302");
	    p2.put("Phone number", "317-555-4302");
	    p2.put("Date of Birth", "12/08/1989");
	    p2.put("State", "Indiana");
	    p2.put("Zip code", "46225");
	    p2.put("Address Line 1", "201 N Delaware St");
	    p2.put("Address Line 2", "Apt 14C");

	    TreeMap<String, String> p3 = new TreeMap<>();
	    p3.put("First Name", "Bastien");
	    p3.put("Middle Name", "Oisin");
	    p3.put("Last Name", "Hartwell");
	    p3.put("Name Suffix", "II");
	    p3.put("Email", "bastien.hartwell@mailto.plus");
	    p3.put("Social Security Number", "930-13-0303");
	    p3.put("Phone number", "305-555-4303");
	    p3.put("Date of Birth", "07/27/1994");
	    p3.put("State", "Florida");
	    p3.put("Zip code", "33133");
	    p3.put("Address Line 1", "2701 S Bayshore Dr");
	    p3.put("Address Line 2", "Unit 8B");

	    TreeMap<String, String> p4 = new TreeMap<>();
	    p4.put("First Name", "Eamon");
	    p4.put("Middle Name", "Caius");
	    p4.put("Last Name", "Rosenveil");
	    p4.put("Name Suffix", "Sr");
	    p4.put("Email", "eamon.rosenveil@mailto.plus");
	    p4.put("Social Security Number", "930-14-0304");
	    p4.put("Phone number", "808-555-4304");
	    p4.put("Date of Birth", "04/21/1991");
	    p4.put("State", "Hawaii");
	    p4.put("Zip code", "96814");
	    p4.put("Address Line 1", "1450 Ala Moana Blvd");
	    p4.put("Address Line 2", "Floor 5");

	    TreeMap<String, String> p5 = new TreeMap<>();
	    p5.put("First Name", "Thaddeo");
	    p5.put("Middle Name", "Soren");
	    p5.put("Last Name", "Brunnholt");
	    p5.put("Name Suffix", "III");
	    p5.put("Email", "thaddeo.brunnholt@mailto.plus");
	    p5.put("Social Security Number", "930-15-0305");
	    p5.put("Phone number", "515-555-4305");
	    p5.put("Date of Birth", "09/03/1988");
	    p5.put("State", "Iowa");
	    p5.put("Zip code", "50310");
	    p5.put("Address Line 1", "3220 Ingersoll Ave");
	    p5.put("Address Line 2", "Apt 3A");

	    TreeMap<String, String> p6 = new TreeMap<>();
	    p6.put("First Name", "Ivo");
	    p6.put("Middle Name", "Matteo");
	    p6.put("Last Name", "Schneidermark");
	    p6.put("Name Suffix", "Jr");
	    p6.put("Email", "ivo.schneidermark@mailto.plus");
	    p6.put("Social Security Number", "930-16-0306");
	    p6.put("Phone number", "785-555-4306");
	    p6.put("Date of Birth", "01/11/1993");
	    p6.put("State", "Kansas");
	    p6.put("Zip code", "66604");
	    p6.put("Address Line 1", "215 SE 8th Ave");
	    p6.put("Address Line 2", "Unit 12");

	    TreeMap<String, String> p7 = new TreeMap<>();
	    p7.put("First Name", "Raffael");
	    p7.put("Middle Name", "Noel");
	    p7.put("Last Name", "Hohenwirth");
	    p7.put("Name Suffix", "II");
	    p7.put("Email", "raffael.hohenwirth@mailto.plus");
	    p7.put("Social Security Number", "930-17-0307");
	    p7.put("Phone number", "671-555-4307");
	    p7.put("Date of Birth", "06/02/1990");
	    p7.put("State", "Guam");
	    p7.put("Zip code", "96913");
	    p7.put("Address Line 1", "400 Route 10");
	    p7.put("Address Line 2", "PO Box 307");

	    TreeMap<String, String> p8 = new TreeMap<>();
	    p8.put("First Name", "Ulises");
	    p8.put("Middle Name", "Armin");
	    p8.put("Last Name", "Westridge");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "ulises.westridge@mailto.plus");
	    p8.put("Social Security Number", "930-18-0308");
	    p8.put("Phone number", "208-555-4308");
	    p8.put("Date of Birth", "11/30/1996");
	    p8.put("State", "Idaho");
	    p8.put("Zip code", "83706");
	    p8.put("Address Line 1", "1101 W River St");
	    p8.put("Address Line 2", "Apt 9D");

	    TreeMap<String, String> p9 = new TreeMap<>();
	    p9.put("First Name", "Darian");
	    p9.put("Middle Name", "Elias");
	    p9.put("Last Name", "Kesslerton");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "darian.kesslerton@mailto.plus");
	    p9.put("Social Security Number", "930-19-0309");
	    p9.put("Phone number", "617-555-4309");
	    p9.put("Date of Birth", "02/16/1992");
	    p9.put("State", "Massachusetts");
	    p9.put("Zip code", "02111");
	    p9.put("Address Line 1", "500 Washington St");
	    p9.put("Address Line 2", "Unit 11");

	    TreeMap<String, String> p10 = new TreeMap<>();
	    p10.put("First Name", "Corvin");
	    p10.put("Middle Name", "Jasper");
	    p10.put("Last Name", "Silvertide");
	    p10.put("Name Suffix", "IV");
	    p10.put("Email", "corvin.silvertide@mailto.plus");
	    p10.put("Social Security Number", "930-20-0310");
	    p10.put("Phone number", "646-555-4310");
	    p10.put("Date of Birth", "10/09/1991");
	    p10.put("State", "New York");
	    p10.put("Zip code", "10016");
	    p10.put("Address Line 1", "250 Park Ave");
	    p10.put("Address Line 2", "Floor 19");

	    TreeMap<String, String> p11 = new TreeMap<>();
	    p11.put("First Name", "Merrick");
	    p11.put("Middle Name", "Thiago");
	    p11.put("Last Name", "Blainewood");
	    p11.put("Name Suffix", "III");
	    p11.put("Email", "merrick.blainewood@mailto.plus");
	    p11.put("Social Security Number", "930-21-0311");
	    p11.put("Phone number", "303-555-4311");
	    p11.put("Date of Birth", "08/25/1987");
	    p11.put("State", "Colorado");
	    p11.put("Zip code", "80206");
	    p11.put("Address Line 1", "200 Steele St");
	    p11.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p12 = new TreeMap<>();
	    p12.put("First Name", "Sullivan");
	    p12.put("Middle Name", "Benoit");
	    p12.put("Last Name", "Oberlin");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "sullivan.oberlin@mailto.plus");
	    p12.put("Social Security Number", "930-22-0312");
	    p12.put("Phone number", "206-555-4312");
	    p12.put("Date of Birth", "05/14/1996");
	    p12.put("State", "Washington");
	    p12.put("Zip code", "98104");
	    p12.put("Address Line 1", "700 2nd Ave");
	    p12.put("Address Line 2", "Suite 900");

	    TreeMap<String, String> p13 = new TreeMap<>();
	    p13.put("First Name", "Tomasz");
	    p13.put("Middle Name", "Remy");
	    p13.put("Last Name", "Brandel");
	    p13.put("Name Suffix", "Sr");
	    p13.put("Email", "tomasz.brandel@mailto.plus");
	    p13.put("Social Security Number", "930-23-0313");
	    p13.put("Phone number", "702-555-4313");
	    p13.put("Date of Birth", "01/22/1989");
	    p13.put("State", "Nevada");
	    p13.put("Zip code", "89109");
	    p13.put("Address Line 1", "3700 S Las Vegas Blvd");
	    p13.put("Address Line 2", "Unit 12C");

	    TreeMap<String, String> p14 = new TreeMap<>();
	    p14.put("First Name", "Bramwell");
	    p14.put("Middle Name", "Alaric");
	    p14.put("Last Name", "Kaltrowe");
	    p14.put("Name Suffix", "II");
	    p14.put("Email", "bramwell.kaltrowe@mailto.plus");
	    p14.put("Social Security Number", "930-24-0314");
	    p14.put("Phone number", "504-555-4314");
	    p14.put("Date of Birth", "12/27/1994");
	    p14.put("State", "Louisiana");
	    p14.put("Zip code", "70112");
	    p14.put("Address Line 1", "909 Poydras St");
	    p14.put("Address Line 2", "Apt 7E");

	    TreeMap<String, String> p15 = new TreeMap<>();
	    p15.put("First Name", "Kieran");
	    p15.put("Middle Name", "Fritz");
	    p15.put("Last Name", "Neuschmidt");
	    p15.put("Name Suffix", "Jr");
	    p15.put("Email", "kieran.neuschmidt@mailto.plus");
	    p15.put("Social Security Number", "930-25-0315");
	    p15.put("Phone number", "602-555-4315");
	    p15.put("Date of Birth", "06/17/1990");
	    p15.put("State", "Arizona");
	    p15.put("Zip code", "85012");
	    p15.put("Address Line 1", "601 W Camelback Rd");
	    p15.put("Address Line 2", "Suite 740");

	    TreeMap<String, String> p16 = new TreeMap<>();
	    p16.put("First Name", "Oberon");
	    p16.put("Middle Name", "Lucian");
	    p16.put("Last Name", "Pfaffenton");
	    p16.put("Name Suffix", "III");
	    p16.put("Email", "oberon.pfaffenton@mailto.plus");
	    p16.put("Social Security Number", "930-26-0316");
	    p16.put("Phone number", "615-555-4316");
	    p16.put("Date of Birth", "02/02/1995");
	    p16.put("State", "Tennessee");
	    p16.put("Zip code", "37203");
	    p16.put("Address Line 1", "301 Demonbreun St");
	    p16.put("Address Line 2", "Unit 12D");

	    TreeMap<String, String> p17 = new TreeMap<>();
	    p17.put("First Name", "Nikolai");
	    p17.put("Middle Name", "August");
	    p17.put("Last Name", "Schiffern");
	    p17.put("Name Suffix", "Sr");
	    p17.put("Email", "nikolai.schiffern@mailto.plus");
	    p17.put("Social Security Number", "930-27-0317");
	    p17.put("Phone number", "404-555-4317");
	    p17.put("Date of Birth", "09/12/1992");
	    p17.put("State", "Georgia");
	    p17.put("Zip code", "30309");
	    p17.put("Address Line 1", "999 Peachtree St NE");
	    p17.put("Address Line 2", "Suite 330");

	    TreeMap<String, String> p18 = new TreeMap<>();
	    p18.put("First Name", "Zephyr");
	    p18.put("Middle Name", "Andre");
	    p18.put("Last Name", "Steinmark");
	    p18.put("Name Suffix", "II");
	    p18.put("Email", "zephyr.steinmark@mailto.plus");
	    p18.put("Social Security Number", "930-28-0318");
	    p18.put("Phone number", "313-555-4318");
	    p18.put("Date of Birth", "04/06/1991");
	    p18.put("State", "Michigan");
	    p18.put("Zip code", "48201");
	    p18.put("Address Line 1", "71 W Warren Ave");
	    p18.put("Address Line 2", "Floor 14");

	    TreeMap<String, String> p19 = new TreeMap<>();
	    p19.put("First Name", "Bohdan");
	    p19.put("Middle Name", "Theron");
	    p19.put("Last Name", "Kienzberg");
	    p19.put("Name Suffix", "III");
	    p19.put("Email", "bohdan.kienzberg@mailto.plus");
	    p19.put("Social Security Number", "930-29-0319");
	    p19.put("Phone number", "214-555-4319");
	    p19.put("Date of Birth", "07/05/1996");
	    p19.put("State", "Texas");
	    p19.put("Zip code", "75204");
	    p19.put("Address Line 1", "2800 Swiss Ave");
	    p19.put("Address Line 2", "Unit 6B");

	    TreeMap<String, String> p20 = new TreeMap<>();
	    p20.put("First Name", "Matisse");
	    p20.put("Middle Name", "Luc");
	    p20.put("Last Name", "Buchenridge");
	    p20.put("Name Suffix", "Jr");
	    p20.put("Email", "matisse.buchenridge@mailto.plus");
	    p20.put("Social Security Number", "930-30-0320");
	    p20.put("Phone number", "801-555-4320");
	    p20.put("Date of Birth", "11/28/1991");
	    p20.put("State", "Utah");
	    p20.put("Zip code", "84102");
	    p20.put("Address Line 1", "201 S State St");
	    p20.put("Address Line 2", "Apt 8F");

	    TreeMap<String, String> p21 = new TreeMap<>();
	    p21.put("First Name", "Alarion");
	    p21.put("Middle Name", "Quincy");
	    p21.put("Last Name", "Rivermond");
	    p21.put("Name Suffix", "II");
	    p21.put("Email", "alarion.rivermond@mailto.plus");
	    p21.put("Social Security Number", "930-31-0321");
	    p21.put("Phone number", "212-555-4321");
	    p21.put("Date of Birth", "02/10/1990");
	    p21.put("State", "New York");
	    p21.put("Zip code", "10007");
	    p21.put("Address Line 1", "200 Church St");
	    p21.put("Address Line 2", "Suite 420");

	    TreeMap<String, String> p22 = new TreeMap<>();
	    p22.put("First Name", "Torquil");
	    p22.put("Middle Name", "Leander");
	    p22.put("Last Name", "Zellerman");
	    p22.put("Name Suffix", "Sr");
	    p22.put("Email", "torquil.zellerman@mailto.plus");
	    p22.put("Social Security Number", "930-32-0322");
	    p22.put("Phone number", "303-555-4322");
	    p22.put("Date of Birth", "12/22/1987");
	    p22.put("State", "Colorado");
	    p22.put("Zip code", "80204");
	    p22.put("Address Line 1", "1200 Federal Blvd");
	    p22.put("Address Line 2", "Apt 4A");

	    TreeMap<String, String> p23 = new TreeMap<>();
	    p23.put("First Name", "Simeon");
	    p23.put("Middle Name", "Ernst");
	    p23.put("Last Name", "Vogelsmere");
	    p23.put("Name Suffix", "III");
	    p23.put("Email", "simeon.vogelsmere@mailto.plus");
	    p23.put("Social Security Number", "930-33-0323");
	    p23.put("Phone number", "214-555-4323");
	    p23.put("Date of Birth", "06/24/1991");
	    p23.put("State", "Texas");
	    p23.put("Zip code", "75202");
	    p23.put("Address Line 1", "200 N Akard St");
	    p23.put("Address Line 2", "Unit 10C");

	    TreeMap<String, String> p24 = new TreeMap<>();
	    p24.put("First Name", "Ulric");
	    p24.put("Middle Name", "Johannes");
	    p24.put("Last Name", "Schlottermann");
	    p24.put("Name Suffix", "Jr");
	    p24.put("Email", "ulric.schlottermann@mailto.plus");
	    p24.put("Social Security Number", "930-34-0324");
	    p24.put("Phone number", "312-555-4324");
	    p24.put("Date of Birth", "09/09/1990");
	    p24.put("State", "Illinois");
	    p24.put("Zip code", "60611");
	    p24.put("Address Line 1", "875 N Michigan Ave");
	    p24.put("Address Line 2", "Suite 800");

	    TreeMap<String, String> p25 = new TreeMap<>();
	    p25.put("First Name", "Jorren");
	    p25.put("Middle Name", "Ferdinand");
	    p25.put("Last Name", "Kreuzwald");
	    p25.put("Name Suffix", "II");
	    p25.put("Email", "jorren.kreuzwald@mailto.plus");
	    p25.put("Social Security Number", "930-35-0325");
	    p25.put("Phone number", "317-555-4325");
	    p25.put("Date of Birth", "02/02/1994");
	    p25.put("State", "Indiana");
	    p25.put("Zip code", "46204");
	    p25.put("Address Line 1", "300 N Meridian St");
	    p25.put("Address Line 2", "Apt 7D");

	    TreeMap<String, String> p26 = new TreeMap<>();
	    p26.put("First Name", "Eirik");
	    p26.put("Middle Name", "Friedrich");
	    p26.put("Last Name", "Brennhaven");
	    p26.put("Name Suffix", "Sr");
	    p26.put("Email", "eirik.brennhaven@mailto.plus");
	    p26.put("Social Security Number", "930-36-0326");
	    p26.put("Phone number", "206-555-4326");
	    p26.put("Date of Birth", "10/14/1988");
	    p26.put("State", "Washington");
	    p26.put("Zip code", "98101");
	    p26.put("Address Line 1", "1420 5th Ave");
	    p26.put("Address Line 2", "Floor 9");

	    TreeMap<String, String> p27 = new TreeMap<>();
	    p27.put("First Name", "Malachi");
	    p27.put("Middle Name", "Andreas");
	    p27.put("Last Name", "Schneeford");
	    p27.put("Name Suffix", "III");
	    p27.put("Email", "malachi.schneeford@mailto.plus");
	    p27.put("Social Security Number", "930-37-0327");
	    p27.put("Phone number", "404-555-4327");
	    p27.put("Date of Birth", "08/08/1991");
	    p27.put("State", "Georgia");
	    p27.put("Zip code", "30303");
	    p27.put("Address Line 1", "225 Baker St NW");
	    p27.put("Address Line 2", "Apt 5B");

	    TreeMap<String, String> p28 = new TreeMap<>();
	    p28.put("First Name", "Rune");
	    p28.put("Middle Name", "Niklas");
	    p28.put("Last Name", "Kesselmere");
	    p28.put("Name Suffix", "Jr");
	    p28.put("Email", "rune.kesselmere@mailto.plus");
	    p28.put("Social Security Number", "930-38-0328");
	    p28.put("Phone number", "702-555-4328");
	    p28.put("Date of Birth", "01/01/1993");
	    p28.put("State", "Nevada");
	    p28.put("Zip code", "89102");
	    p28.put("Address Line 1", "3200 W Sahara Ave");
	    p28.put("Address Line 2", "Unit 18A");

	    TreeMap<String, String> p29 = new TreeMap<>();
	    p29.put("First Name", "Viggo");
	    p29.put("Middle Name", "Matthias");
	    p29.put("Last Name", "Brandemont");
	    p29.put("Name Suffix", "II");
	    p29.put("Email", "viggo.brandemont@mailto.plus");
	    p29.put("Social Security Number", "930-39-0329");
	    p29.put("Phone number", "615-555-4329");
	    p29.put("Date of Birth", "06/06/1992");
	    p29.put("State", "Tennessee");
	    p29.put("Zip code", "37212");
	    p29.put("Address Line 1", "2400 West End Ave");
	    p29.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p30 = new TreeMap<>();
	    p30.put("First Name", "Yorick");
	    p30.put("Middle Name", "Gustav");
	    p30.put("Last Name", "Hartmannvale");
	    p30.put("Name Suffix", "Sr");
	    p30.put("Email", "yorick.hartmannvale@mailto.plus");
	    p30.put("Social Security Number", "930-40-0330");
	    p30.put("Phone number", "801-555-4330");
	    p30.put("Date of Birth", "12/12/1987");
	    p30.put("State", "Utah");
	    p30.put("Zip code", "84111");
	    p30.put("Address Line 1", "50 S 200 E");
	    p30.put("Address Line 2", "Suite 600");

	    TreeMap<String, String> p31 = new TreeMap<>();
	    p31.put("First Name", "Elowen");
	    p31.put("Middle Name", "Skye");
	    p31.put("Last Name", "Kronenfield");
	    p31.put("Name Suffix", "III");
	    p31.put("Email", "elowen.kronenfield@mailto.plus");
	    p31.put("Social Security Number", "930-41-0331");
	    p31.put("Phone number", "407-555-4331");
	    p31.put("Date of Birth", "09/20/1990");
	    p31.put("State", "Florida");
	    p31.put("Zip code", "32801");
	    p31.put("Address Line 1", "100 S Eola Dr");
	    p31.put("Address Line 2", "Unit 18");

	    TreeMap<String, String> p32 = new TreeMap<>();
	    p32.put("First Name", "Bjarni");
	    p32.put("Middle Name", "Elias");
	    p32.put("Last Name", "Schwarzenmere");
	    p32.put("Name Suffix", "Jr");
	    p32.put("Email", "bjarni.schwarzenmere@mailto.plus");
	    p32.put("Social Security Number", "930-42-0332");
	    p32.put("Phone number", "415-555-4332");
	    p32.put("Date of Birth", "01/27/1992");
	    p32.put("State", "California");
	    p32.put("Zip code", "94107");
	    p32.put("Address Line 1", "135 Townsend St");
	    p32.put("Address Line 2", "Apt 6");

	    TreeMap<String, String> p33 = new TreeMap<>();
	    p33.put("First Name", "Timo");
	    p33.put("Middle Name", "Leopold");
	    p33.put("Last Name", "Fichtenmere");
	    p33.put("Name Suffix", "II");
	    p33.put("Email", "timo.fichtenmere@mailto.plus");
	    p33.put("Social Security Number", "930-43-0333");
	    p33.put("Phone number", "503-555-4333");
	    p33.put("Date of Birth", "03/03/1991");
	    p33.put("State", "Oregon");
	    p33.put("Zip code", "97205");
	    p33.put("Address Line 1", "121 SW Salmon St");
	    p33.put("Address Line 2", "Suite 410");

	    TreeMap<String, String> p34 = new TreeMap<>();
	    p34.put("First Name", "Kjartan");
	    p34.put("Middle Name", "Sebastian");
	    p34.put("Last Name", "Sonnenmere");
	    p34.put("Name Suffix", "Sr");
	    p34.put("Email", "kjartan.sonnenmere@mailto.plus");
	    p34.put("Social Security Number", "930-44-0334");
	    p34.put("Phone number", "609-555-4334");
	    p34.put("Date of Birth", "12/01/1989");
	    p34.put("State", "New Jersey");
	    p34.put("Zip code", "08608");
	    p34.put("Address Line 1", "225 W State St");
	    p34.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p35 = new TreeMap<>();
	    p35.put("First Name", "Njal");
	    p35.put("Middle Name", "Ferdinand");
	    p35.put("Last Name", "Wintermere");
	    p35.put("Name Suffix", "III");
	    p35.put("Email", "njal.wintermere@mailto.plus");
	    p35.put("Social Security Number", "930-45-0335");
	    p35.put("Phone number", "602-555-4335");
	    p35.put("Date of Birth", "06/18/1990");
	    p35.put("State", "Arizona");
	    p35.put("Zip code", "85003");
	    p35.put("Address Line 1", "100 W Jefferson St");
	    p35.put("Address Line 2", "Apt 12");

	    TreeMap<String, String> p36 = new TreeMap<>();
	    p36.put("First Name", "Osmund");
	    p36.put("Middle Name", "Armin");
	    p36.put("Last Name", "Bergstromer");
	    p36.put("Name Suffix", "II");
	    p36.put("Email", "osmund.bergstromer@mailto.plus");
	    p36.put("Social Security Number", "930-46-0336");
	    p36.put("Phone number", "206-555-4336");
	    p36.put("Date of Birth", "10/10/1992");
	    p36.put("State", "Washington");
	    p36.put("Zip code", "98109");
	    p36.put("Address Line 1", "500 9th Ave N");
	    p36.put("Address Line 2", "Unit 7");

	    TreeMap<String, String> p37 = new TreeMap<>();
	    p37.put("First Name", "Cyran");
	    p37.put("Middle Name", "Werner");
	    p37.put("Last Name", "Rosenwalt");
	    p37.put("Name Suffix", "Jr");
	    p37.put("Email", "cyran.rosenwalt@mailto.plus");
	    p37.put("Social Security Number", "930-47-0337");
	    p37.put("Phone number", "614-555-4337");
	    p37.put("Date of Birth", "01/05/1994");
	    p37.put("State", "Ohio");
	    p37.put("Zip code", "43215");
	    p37.put("Address Line 1", "150 N Front St");
	    p37.put("Address Line 2", "Suite 220");

	    TreeMap<String, String> p38 = new TreeMap<>();
	    p38.put("First Name", "Ilan");
	    p38.put("Middle Name", "Johannes");
	    p38.put("Last Name", "Falkenmere");
	    p38.put("Name Suffix", "III");
	    p38.put("Email", "ilan.falkenmere@mailto.plus");
	    p38.put("Social Security Number", "930-48-0338");
	    p38.put("Phone number", "312-555-4338");
	    p38.put("Date of Birth", "09/09/1991");
	    p38.put("State", "Illinois");
	    p38.put("Zip code", "60607");
	    p38.put("Address Line 1", "900 W Fulton Market");
	    p38.put("Address Line 2", "Unit 14");

	    TreeMap<String, String> p39 = new TreeMap<>();
	    p39.put("First Name", "Jannik");
	    p39.put("Middle Name", "Konrad");
	    p39.put("Last Name", "Ebervale");
	    p39.put("Name Suffix", "II");
	    p39.put("Email", "jannik.ebervale@mailto.plus");
	    p39.put("Social Security Number", "930-49-0339");
	    p39.put("Phone number", "313-555-4339");
	    p39.put("Date of Birth", "12/28/1988");
	    p39.put("State", "Michigan");
	    p39.put("Zip code", "48226");
	    p39.put("Address Line 1", "500 Griswold St");
	    p39.put("Address Line 2", "Floor 10");

	    TreeMap<String, String> p40 = new TreeMap<>();
	    p40.put("First Name", "Lennox");
	    p40.put("Middle Name", "Gustav");
	    p40.put("Last Name", "Hochmere");
	    p40.put("Name Suffix", "Sr");
	    p40.put("Email", "lennox.hochmere@mailto.plus");
	    p40.put("Social Security Number", "930-50-0340");
	    p40.put("Phone number", "603-555-4340");
	    p40.put("Date of Birth", "04/24/1990");
	    p40.put("State", "New Hampshire");
	    p40.put("Zip code", "03101");
	    p40.put("Address Line 1", "900 Elm St");
	    p40.put("Address Line 2", "Apt 2");

	    TreeMap<String, String> p41 = new TreeMap<>();
	    p41.put("First Name", "Tiber");
	    p41.put("Middle Name", "Alois");
	    p41.put("Last Name", "Schwerdtmere");
	    p41.put("Name Suffix", "III");
	    p41.put("Email", "tiber.schwerdtmere@mailto.plus");
	    p41.put("Social Security Number", "930-51-0341");
	    p41.put("Phone number", "702-555-4341");
	    p41.put("Date of Birth", "11/21/1991");
	    p41.put("State", "Nevada");
	    p41.put("Zip code", "89103");
	    p41.put("Address Line 1", "500 S Decatur Blvd");
	    p41.put("Address Line 2", "Unit 4B");

	    TreeMap<String, String> p42 = new TreeMap<>();
	    p42.put("First Name", "Cassian");
	    p42.put("Middle Name", "Benedikt");
	    p42.put("Last Name", "Hirschmere");
	    p42.put("Name Suffix", "Jr");
	    p42.put("Email", "cassian.hirschmere@mailto.plus");
	    p42.put("Social Security Number", "930-52-0342");
	    p42.put("Phone number", "317-555-4342");
	    p42.put("Date of Birth", "01/19/1993");
	    p42.put("State", "Indiana");
	    p42.put("Zip code", "46202");
	    p42.put("Address Line 1", "50 S Meridian St");
	    p42.put("Address Line 2", "Suite 300");

	    TreeMap<String, String> p43 = new TreeMap<>();
	    p43.put("First Name", "Florian");
	    p43.put("Middle Name", "Otto");
	    p43.put("Last Name", "Neubridge");
	    p43.put("Name Suffix", "II");
	    p43.put("Email", "florian.neubridge@mailto.plus");
	    p43.put("Social Security Number", "930-53-0343");
	    p43.put("Phone number", "615-555-4343");
	    p43.put("Date of Birth", "07/08/1994");
	    p43.put("State", "Tennessee");
	    p43.put("Zip code", "37219");
	    p43.put("Address Line 1", "301 Church St");
	    p43.put("Address Line 2", "Apt 14B");

	    TreeMap<String, String> p44 = new TreeMap<>();
	    p44.put("First Name", "Lucien");
	    p44.put("Middle Name", "Elias");
	    p44.put("Last Name", "Kornmere");
	    p44.put("Name Suffix", "Sr");
	    p44.put("Email", "lucien.kornmere@mailto.plus");
	    p44.put("Social Security Number", "930-54-0344");
	    p44.put("Phone number", "305-555-4344");
	    p44.put("Date of Birth", "02/13/1987");
	    p44.put("State", "Florida");
	    p44.put("Zip code", "33131");
	    p44.put("Address Line 1", "701 Brickell Ave");
	    p44.put("Address Line 2", "Apt 9A");

	    TreeMap<String, String> p45 = new TreeMap<>();
	    p45.put("First Name", "Isidore");
	    p45.put("Middle Name", "Friedrich");
	    p45.put("Last Name", "Schwanemere");
	    p45.put("Name Suffix", "III");
	    p45.put("Email", "isidore.schwanemere@mailto.plus");
	    p45.put("Social Security Number", "930-55-0345");
	    p45.put("Phone number", "206-555-4345");
	    p45.put("Date of Birth", "03/14/1990");
	    p45.put("State", "Washington");
	    p45.put("Zip code", "98121");
	    p45.put("Address Line 1", "2121 4th Ave");
	    p45.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p46 = new TreeMap<>();
	    p46.put("First Name", "Valerian");
	    p46.put("Middle Name", "Armin");
	    p46.put("Last Name", "Tannmere");
	    p46.put("Name Suffix", "Jr");
	    p46.put("Email", "valerian.tannmere@mailto.plus");
	    p46.put("Social Security Number", "930-56-0346");
	    p46.put("Phone number", "404-555-4346");
	    p46.put("Date of Birth", "12/05/1991");
	    p46.put("State", "Georgia");
	    p46.put("Zip code", "30313");
	    p46.put("Address Line 1", "190 Marietta St NW");
	    p46.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p47 = new TreeMap<>();
	    p47.put("First Name", "Magnus");
	    p47.put("Middle Name", "Johann");
	    p47.put("Last Name", "Edelmere");
	    p47.put("Name Suffix", "II");
	    p47.put("Email", "magnus.edelmere@mailto.plus");
	    p47.put("Social Security Number", "930-57-0347");
	    p47.put("Phone number", "785-555-4347");
	    p47.put("Date of Birth", "09/30/1992");
	    p47.put("State", "Kansas");
	    p47.put("Zip code", "67202");
	    p47.put("Address Line 1", "100 N Broadway Ave");
	    p47.put("Address Line 2", "Unit 9D");

	    TreeMap<String, String> p48 = new TreeMap<>();
	    p48.put("First Name", "Benedict");
	    p48.put("Middle Name", "Konrad");
	    p48.put("Last Name", "Frostmere");
	    p48.put("Name Suffix", "Sr");
	    p48.put("Email", "benedict.frostmere@mailto.plus");
	    p48.put("Social Security Number", "930-58-0348");
	    p48.put("Phone number", "603-555-4348");
	    p48.put("Date of Birth", "06/26/1989");
	    p48.put("State", "New Hampshire");
	    p48.put("Zip code", "03101");
	    p48.put("Address Line 1", "1000 Canal St");
	    p48.put("Address Line 2", "Apt 5C");

	    TreeMap<String, String> p49 = new TreeMap<>();
	    p49.put("First Name", "Soren");
	    p49.put("Middle Name", "Niklas");
	    p49.put("Last Name", "Hohenmere");
	    p49.put("Name Suffix", "III");
	    p49.put("Email", "soren.hohenmere@mailto.plus");
	    p49.put("Social Security Number", "930-59-0349");
	    p49.put("Phone number", "504-555-4349");
	    p49.put("Date of Birth", "10/05/1989");
	    p49.put("State", "Louisiana");
	    p49.put("Zip code", "70115");
	    p49.put("Address Line 1", "4500 Magazine St");
	    p49.put("Address Line 2", "Apt 7B");

	    TreeMap<String, String> p50 = new TreeMap<>();
	    p50.put("First Name", "Cillian");
	    p50.put("Middle Name", "Matthias");
	    p50.put("Last Name", "Schreibermere");
	    p50.put("Name Suffix", "II");
	    p50.put("Email", "cillian.schreibermere@mailto.plus");
	    p50.put("Social Security Number", "930-60-0350");
	    p50.put("Phone number", "214-555-4350");
	    p50.put("Date of Birth", "01/30/1992");
	    p50.put("State", "Texas");
	    p50.put("Zip code", "75205");
	    p50.put("Address Line 1", "3100 Knox St");
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
	
	
	
	
	
	
	


