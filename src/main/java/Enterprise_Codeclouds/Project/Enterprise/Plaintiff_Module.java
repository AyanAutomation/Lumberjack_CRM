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
	    p1.put("First Name", "Albrecht");
	    p1.put("Middle Name", "Cyrill");
	    p1.put("Last Name", "Falkenhagen");
	    p1.put("Name Suffix", "III");
	    p1.put("Email", "albrecht.falkenhagen@mailto.plus");
	    p1.put("Social Security Number", "920-11-0201");
	    p1.put("Phone number", "312-555-4201");
	    p1.put("Date of Birth", "01/23/1991");
	    p1.put("State", "Illinois");
	    p1.put("Zip code", "60603");
	    p1.put("Address Line 1", "120 N LaSalle St");
	    p1.put("Address Line 2", "Suite 1800");

	    TreeMap<String, String> p2 = new TreeMap<String, String>();
	    p2.put("First Name", "Clemens");
	    p2.put("Middle Name", "Otto");
	    p2.put("Last Name", "Reuterwald");
	    p2.put("Name Suffix", "Jr");
	    p2.put("Email", "clemens.reuterwald@mailto.plus");
	    p2.put("Social Security Number", "920-12-0202");
	    p2.put("Phone number", "317-555-4202");
	    p2.put("Date of Birth", "10/05/1988");
	    p2.put("State", "Indiana");
	    p2.put("Zip code", "46202");
	    p2.put("Address Line 1", "50 W Washington St");
	    p2.put("Address Line 2", "Apt 9C");

	    TreeMap<String, String> p3 = new TreeMap<String, String>();
	    p3.put("First Name", "Hadrian");
	    p3.put("Middle Name", "Niklas");
	    p3.put("Last Name", "Silberbauer");
	    p3.put("Name Suffix", "II");
	    p3.put("Email", "hadrian.silberbauer@mailto.plus");
	    p3.put("Social Security Number", "920-13-0203");
	    p3.put("Phone number", "305-555-4203");
	    p3.put("Date of Birth", "06/14/1994");
	    p3.put("State", "Florida");
	    p3.put("Zip code", "33130");
	    p3.put("Address Line 1", "500 Brickell Ave");
	    p3.put("Address Line 2", "Unit 21D");

	    TreeMap<String, String> p4 = new TreeMap<String, String>();
	    p4.put("First Name", "Erasmus");
	    p4.put("Middle Name", "Leopold");
	    p4.put("Last Name", "Oberfeld");
	    p4.put("Name Suffix", "Sr");
	    p4.put("Email", "erasmus.oberfeld@mailto.plus");
	    p4.put("Social Security Number", "920-14-0204");
	    p4.put("Phone number", "808-555-4204");
	    p4.put("Date of Birth", "04/02/1992");
	    p4.put("State", "Hawaii");
	    p4.put("Zip code", "96813");
	    p4.put("Address Line 1", "700 Bishop St");
	    p4.put("Address Line 2", "Floor 9");

	    TreeMap<String, String> p5 = new TreeMap<String, String>();
	    p5.put("First Name", "Gunnar");
	    p5.put("Middle Name", "Konrad");
	    p5.put("Last Name", "Winterborn");
	    p5.put("Name Suffix", "III");
	    p5.put("Email", "gunnar.winterborn@mailto.plus");
	    p5.put("Social Security Number", "920-15-0205");
	    p5.put("Phone number", "515-555-4205");
	    p5.put("Date of Birth", "09/18/1989");
	    p5.put("State", "Iowa");
	    p5.put("Zip code", "50309");
	    p5.put("Address Line 1", "600 Locust St");
	    p5.put("Address Line 2", "Apt 12B");

	    TreeMap<String, String> p6 = new TreeMap<String, String>();
	    p6.put("First Name", "Ilarion");
	    p6.put("Middle Name", "Friedrich");
	    p6.put("Last Name", "Bergwirth");
	    p6.put("Name Suffix", "Jr");
	    p6.put("Email", "ilarion.bergwirth@mailto.plus");
	    p6.put("Social Security Number", "920-16-0206");
	    p6.put("Phone number", "785-555-4206");
	    p6.put("Date of Birth", "02/28/1995");
	    p6.put("State", "Kansas");
	    p6.put("Zip code", "66603");
	    p6.put("Address Line 1", "900 SW Jackson St");
	    p6.put("Address Line 2", "Unit 5A");

	    TreeMap<String, String> p7 = new TreeMap<String, String>();
	    p7.put("First Name", "Soren");
	    p7.put("Middle Name", "Benedikt");
	    p7.put("Last Name", "Tannenfeld");
	    p7.put("Name Suffix", "II");
	    p7.put("Email", "soren.tannenfeld@mailto.plus");
	    p7.put("Social Security Number", "920-17-0207");
	    p7.put("Phone number", "671-555-4207");
	    p7.put("Date of Birth", "06/11/1993");
	    p7.put("State", "Guam");
	    p7.put("Zip code", "96910");
	    p7.put("Address Line 1", "22 Marine Corps Dr");
	    p7.put("Address Line 2", "PO Box 211");

	    TreeMap<String, String> p8 = new TreeMap<String, String>();
	    p8.put("First Name", "Tobias");
	    p8.put("Middle Name", "Niklas");
	    p8.put("Last Name", "Morgenfeld");
	    p8.put("Name Suffix", "III");
	    p8.put("Email", "tobias.morgenfeld@mailto.plus");
	    p8.put("Social Security Number", "920-18-0208");
	    p8.put("Phone number", "208-555-4208");
	    p8.put("Date of Birth", "12/05/1996");
	    p8.put("State", "Idaho");
	    p8.put("Zip code", "83702");
	    p8.put("Address Line 1", "999 W Main St");
	    p8.put("Address Line 2", "Apt 4D");

	    TreeMap<String, String> p9 = new TreeMap<String, String>();
	    p9.put("First Name", "Edmund");
	    p9.put("Middle Name", "Werner");
	    p9.put("Last Name", "Heidenstern");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "edmund.heidenstern@mailto.plus");
	    p9.put("Social Security Number", "920-19-0209");
	    p9.put("Phone number", "617-555-4209");
	    p9.put("Date of Birth", "03/07/1992");
	    p9.put("State", "Massachusetts");
	    p9.put("Zip code", "02108");
	    p9.put("Address Line 1", "1 Beacon St");
	    p9.put("Address Line 2", "Unit 9");

	    TreeMap<String, String> p10 = new TreeMap<String, String>();
	    p10.put("First Name", "Quentin");
	    p10.put("Middle Name", "Siegfried");
	    p10.put("Last Name", "Silbermann");
	    p10.put("Name Suffix", "IV");
	    p10.put("Email", "quentin.silbermann@mailto.plus");
	    p10.put("Social Security Number", "920-20-0210");
	    p10.put("Phone number", "646-555-4210");
	    p10.put("Date of Birth", "10/21/1994");
	    p10.put("State", "New York");
	    p10.put("Zip code", "10001");
	    p10.put("Address Line 1", "450 8th Ave");
	    p10.put("Address Line 2", "Apt 31A");

	    TreeMap<String, String> p11 = new TreeMap<String, String>();
	    p11.put("First Name", "Hartmann");
	    p11.put("Middle Name", "Elias");
	    p11.put("Last Name", "Niederberger");
	    p11.put("Name Suffix", "III");
	    p11.put("Email", "hartmann.niederberger@mailto.plus");
	    p11.put("Social Security Number", "920-21-0211");
	    p11.put("Phone number", "303-555-4211");
	    p11.put("Date of Birth", "08/12/1991");
	    p11.put("State", "Colorado");
	    p11.put("Zip code", "80203");
	    p11.put("Address Line 1", "500 E Colfax Ave");
	    p11.put("Address Line 2", "Apt 6F");

	    TreeMap<String, String> p12 = new TreeMap<String, String>();
	    p12.put("First Name", "Winfred");
	    p12.put("Middle Name", "Gustav");
	    p12.put("Last Name", "Oberhaeuser");
	    p12.put("Name Suffix", "Jr");
	    p12.put("Email", "winfred.oberhaeuser@mailto.plus");
	    p12.put("Social Security Number", "920-22-0212");
	    p12.put("Phone number", "206-555-4212");
	    p12.put("Date of Birth", "05/29/1996");
	    p12.put("State", "Washington");
	    p12.put("Zip code", "98101");
	    p12.put("Address Line 1", "600 Pine St");
	    p12.put("Address Line 2", "Floor 10");

	    TreeMap<String, String> p13 = new TreeMap<String, String>();
	    p13.put("First Name", "Siegbert");
	    p13.put("Middle Name", "Otto");
	    p13.put("Last Name", "Brandstetter");
	    p13.put("Name Suffix", "Sr");
	    p13.put("Email", "siegbert.brandstetter@mailto.plus");
	    p13.put("Social Security Number", "920-23-0213");
	    p13.put("Phone number", "702-555-4213");
	    p13.put("Date of Birth", "01/16/1988");
	    p13.put("State", "Nevada");
	    p13.put("Zip code", "89101");
	    p13.put("Address Line 1", "300 S 4th St");
	    p13.put("Address Line 2", "Unit 12C");

	    TreeMap<String, String> p14 = new TreeMap<String, String>();
	    p14.put("First Name", "Dietrich");
	    p14.put("Middle Name", "Andreas");
	    p14.put("Last Name", "Kaltwasser");
	    p14.put("Name Suffix", "II");
	    p14.put("Email", "dietrich.kaltwasser@mailto.plus");
	    p14.put("Social Security Number", "920-24-0214");
	    p14.put("Phone number", "504-555-4214");
	    p14.put("Date of Birth", "12/09/1993");
	    p14.put("State", "Louisiana");
	    p14.put("Zip code", "70130");
	    p14.put("Address Line 1", "700 Magazine St");
	    p14.put("Address Line 2", "Apt 9E");

	    TreeMap<String, String> p15 = new TreeMap<String, String>();
	    p15.put("First Name", "Ruprecht");
	    p15.put("Middle Name", "Philipp");
	    p15.put("Last Name", "Neuschwander");
	    p15.put("Name Suffix", "Jr");
	    p15.put("Email", "ruprecht.neuschwander@mailto.plus");
	    p15.put("Social Security Number", "920-25-0215");
	    p15.put("Phone number", "602-555-4215");
	    p15.put("Date of Birth", "06/03/1990");
	    p15.put("State", "Arizona");
	    p15.put("Zip code", "85004");
	    p15.put("Address Line 1", "20 E Van Buren St");
	    p15.put("Address Line 2", "Suite 740");

	    TreeMap<String, String> p16 = new TreeMap<String, String>();
	    p16.put("First Name", "Eckart");
	    p16.put("Middle Name", "Camille");
	    p16.put("Last Name", "Pfaffenberger");
	    p16.put("Name Suffix", "III");
	    p16.put("Email", "eckart.pfaffenberger@mailto.plus");
	    p16.put("Social Security Number", "920-26-0216");
	    p16.put("Phone number", "615-555-4216");
	    p16.put("Date of Birth", "02/27/1995");
	    p16.put("State", "Tennessee");
	    p16.put("Zip code", "37219");
	    p16.put("Address Line 1", "250 Church St");
	    p16.put("Address Line 2", "Apt 12D");

	    TreeMap<String, String> p17 = new TreeMap<String, String>();
	    p17.put("First Name", "Hendrik");
	    p17.put("Middle Name", "Alexander");
	    p17.put("Last Name", "Schifferle");
	    p17.put("Name Suffix", "Sr");
	    p17.put("Email", "hendrik.schifferle@mailto.plus");
	    p17.put("Social Security Number", "920-27-0217");
	    p17.put("Phone number", "404-555-4217");
	    p17.put("Date of Birth", "09/01/1992");
	    p17.put("State", "Georgia");
	    p17.put("Zip code", "30308");
	    p17.put("Address Line 1", "600 Peachtree St NE");
	    p17.put("Address Line 2", "Suite 330");

	    TreeMap<String, String> p18 = new TreeMap<String, String>();
	    p18.put("First Name", "Xander");
	    p18.put("Middle Name", "Andre");
	    p18.put("Last Name", "Steigerwald");
	    p18.put("Name Suffix", "II");
	    p18.put("Email", "xander.steigerwald@mailto.plus");
	    p18.put("Social Security Number", "920-28-0218");
	    p18.put("Phone number", "313-555-4218");
	    p18.put("Date of Birth", "04/10/1989");
	    p18.put("State", "Michigan");
	    p18.put("Zip code", "48226");
	    p18.put("Address Line 1", "200 Woodward Ave");
	    p18.put("Address Line 2", "Floor 14");

	    TreeMap<String, String> p19 = new TreeMap<String, String>();
	    p19.put("First Name", "Kasimir");
	    p19.put("Middle Name", "Theron");
	    p19.put("Last Name", "Kienzle");
	    p19.put("Name Suffix", "III");
	    p19.put("Email", "kasimir.kienzle@mailto.plus");
	    p19.put("Social Security Number", "920-29-0219");
	    p19.put("Phone number", "214-555-4219");
	    p19.put("Date of Birth", "07/19/1996");
	    p19.put("State", "Texas");
	    p19.put("Zip code", "75201");
	    p19.put("Address Line 1", "1700 Pacific Ave");
	    p19.put("Address Line 2", "Unit 6B");

	    TreeMap<String, String> p20 = new TreeMap<String, String>();
	    p20.put("First Name", "Thilo");
	    p20.put("Middle Name", "Luc");
	    p20.put("Last Name", "Buchenwald");
	    p20.put("Name Suffix", "Jr");
	    p20.put("Email", "thilo.buchenwald@mailto.plus");
	    p20.put("Social Security Number", "920-30-0220");
	    p20.put("Phone number", "801-555-4220");
	    p20.put("Date of Birth", "11/15/1991");
	    p20.put("State", "Utah");
	    p20.put("Zip code", "84101");
	    p20.put("Address Line 1", "60 E South Temple");
	    p20.put("Address Line 2", "Apt 8F");

	    return new Object[][]{
	        {p1},{p2},{p3},{p4},{p5},
	        {p6},{p7},{p8},{p9},{p10},
	        {p11},{p12},{p13},{p14},{p15},
	        {p16},{p17},{p18},{p19},{p20}
	    };
	}







}
	
	
	
	
	
	
	


