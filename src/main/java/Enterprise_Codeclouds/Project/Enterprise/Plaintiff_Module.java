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

		TreeMap<String, String> p1 = new TreeMap<String, String>();
	    p1.put("First Name", "Ariana");
	    p1.put("Middle Name", "Noelle");
	    p1.put("Last Name", "Mercier");
	    p1.put("Name Suffix", "Jr");
	    p1.put("Email", "ariana.mercier@mailto.plus");
	    p1.put("Social Security Number", "215-48-7391");
	    p1.put("Phone number", "312-555-0101");
	    p1.put("Date of Birth", "02/14/1993");
	    p1.put("State", "Illinois");
	    p1.put("Zip code", "60601");
	    p1.put("Address Line 1", "221 Lake Shore Dr");
	    p1.put("Address Line 2", "Apt 12B");

	    TreeMap<String, String> p2 = new TreeMap<String, String>();
	    p2.put("First Name", "Ethan");
	    p2.put("Middle Name", "Gabriel");
	    p2.put("Last Name", "Keller");
	    p2.put("Name Suffix", "Sr");
	    p2.put("Email", "ethan.keller@mailto.plus");
	    p2.put("Social Security Number", "487-22-9150");
	    p2.put("Phone number", "317-555-0102");
	    p2.put("Date of Birth", "11/09/1990");
	    p2.put("State", "Indiana");
	    p2.put("Zip code", "46204");
	    p2.put("Address Line 1", "410 Meridian St");
	    p2.put("Address Line 2", "Suite 200");

	    TreeMap<String, String> p3 = new TreeMap<String, String>();
	    p3.put("First Name", "Isla");
	    p3.put("Middle Name", "Renée");
	    p3.put("Last Name", "Fontenot");
	    p3.put("Name Suffix", "III");
	    p3.put("Email", "isla.fontenot@mailto.plus");
	    p3.put("Social Security Number", "103-67-5528");
	    p3.put("Phone number", "305-555-0103");
	    p3.put("Date of Birth", "07/23/1995");
	    p3.put("State", "Florida");
	    p3.put("Zip code", "33101");
	    p3.put("Address Line 1", "980 Biscayne Blvd");
	    p3.put("Address Line 2", "Unit 5A");

	    TreeMap<String, String> p4 = new TreeMap<String, String>();
	    p4.put("First Name", "Leah");
	    p4.put("Middle Name", "Makai");
	    p4.put("Last Name", "Kawasaki");
	    p4.put("Name Suffix", "IV");
	    p4.put("Email", "leah.kawasaki@mailto.plus");
	    p4.put("Social Security Number", "619-05-4412");
	    p4.put("Phone number", "808-555-0104");
	    p4.put("Date of Birth", "04/02/1992");
	    p4.put("State", "Hawaii");
	    p4.put("Zip code", "96813");
	    p4.put("Address Line 1", "700 Ala Moana Blvd");
	    p4.put("Address Line 2", "Floor 3");

	    TreeMap<String, String> p5 = new TreeMap<String, String>();
	    p5.put("First Name", "Calvin");
	    p5.put("Middle Name", "Andre");
	    p5.put("Last Name", "Dufresne");
	    p5.put("Name Suffix", "Jr");
	    p5.put("Email", "calvin.dufresne@mailto.plus");
	    p5.put("Social Security Number", "552-19-8804");
	    p5.put("Phone number", "515-555-0105");
	    p5.put("Date of Birth", "09/18/1989");
	    p5.put("State", "Iowa");
	    p5.put("Zip code", "50309");
	    p5.put("Address Line 1", "1500 Grand Ave");
	    p5.put("Address Line 2", "Apt 9C");

	    TreeMap<String, String> p6 = new TreeMap<String, String>();
	    p6.put("First Name", "Mason");
	    p6.put("Middle Name", "Theodore");
	    p6.put("Last Name", "Hartwell");
	    p6.put("Name Suffix", "Sr");
	    p6.put("Email", "mason.hartwell@mailto.plus");
	    p6.put("Social Security Number", "338-74-2061");
	    p6.put("Phone number", "785-555-0106");
	    p6.put("Date of Birth", "01/30/1991");
	    p6.put("State", "Kansas");
	    p6.put("Zip code", "66603");
	    p6.put("Address Line 1", "901 S Kansas Ave");
	    p6.put("Address Line 2", "Room 14");

	    TreeMap<String, String> p7 = new TreeMap<String, String>();
	    p7.put("First Name", "Serena");
	    p7.put("Middle Name", "Mai");
	    p7.put("Last Name", "Delacruz");
	    p7.put("Name Suffix", "Mrs");
	    p7.put("Email", "serena.delacruz@mailto.plus");
	    p7.put("Social Security Number", "271-90-6643");
	    p7.put("Phone number", "671-555-0107");
	    p7.put("Date of Birth", "06/11/1994");
	    p7.put("State", "Guam");
	    p7.put("Zip code", "96910");
	    p7.put("Address Line 1", "12 Marine Corps Dr");
	    p7.put("Address Line 2", "PO Box 88");

	    TreeMap<String, String> p8 = new TreeMap<String, String>();
	    p8.put("First Name", "Nora");
	    p8.put("Middle Name", "Elise");
	    p8.put("Last Name", "Vandermark");
	    p8.put("Name Suffix", "II");
	    p8.put("Email", "nora.vandermark@mailto.plus");
	    p8.put("Social Security Number", "490-33-7118");
	    p8.put("Phone number", "208-555-0108");
	    p8.put("Date of Birth", "12/05/1996");
	    p8.put("State", "Idaho");
	    p8.put("Zip code", "83702");
	    p8.put("Address Line 1", "500 W Main St");
	    p8.put("Address Line 2", "Apt 2D");

	    TreeMap<String, String> p9 = new TreeMap<String, String>();
	    p9.put("First Name", "Julian");
	    p9.put("Middle Name", "Archer");
	    p9.put("Last Name", "Beaumont");
	    p9.put("Name Suffix", "Sr");
	    p9.put("Email", "julian.beaumont@mailto.plus");
	    p9.put("Social Security Number", "146-29-8034");
	    p9.put("Phone number", "617-555-0109");
	    p9.put("Date of Birth", "03/07/1992");
	    p9.put("State", "Massachusetts");
	    p9.put("Zip code", "02108");
	    p9.put("Address Line 1", "45 Beacon St");
	    p9.put("Address Line 2", "Unit 8");

	    TreeMap<String, String> p10 = new TreeMap<String, String>();
	    p10.put("First Name", "Vivienne");
	    p10.put("Middle Name", "Celeste");
	    p10.put("Last Name", "Laurent");
	    p10.put("Name Suffix", "Jr");
	    p10.put("Email", "vivienne.laurent@mailto.plus");
	    p10.put("Social Security Number", "582-14-9976");
	    p10.put("Phone number", "646-555-0110");
	    p10.put("Date of Birth", "10/21/1994");
	    p10.put("State", "New York");
	    p10.put("Zip code", "10001");
	    p10.put("Address Line 1", "350 7th Ave");
	    p10.put("Address Line 2", "Apt 19A");

	    TreeMap<String, String> p11 = new TreeMap<String, String>();
	    p11.put("First Name", "Logan");
	    p11.put("Middle Name", "Miles");
	    p11.put("Last Name", "Rothman");
	    p11.put("Name Suffix", "III");
	    p11.put("Email", "logan.rothman@mailto.plus");
	    p11.put("Social Security Number", "309-67-2148");
	    p11.put("Phone number", "303-555-0111");
	    p11.put("Date of Birth", "08/12/1991");
	    p11.put("State", "Colorado");
	    p11.put("Zip code", "80202");
	    p11.put("Address Line 1", "1600 California St");
	    p11.put("Address Line 2", "Suite 900");

	    TreeMap<String, String> p12 = new TreeMap<String, String>();
	    p12.put("First Name", "Claire");
	    p12.put("Middle Name", "Adele");
	    p12.put("Last Name", "Monroe");
	    p12.put("Name Suffix", "IV");
	    p12.put("Email", "claire.monroe@mailto.plus");
	    p12.put("Social Security Number", "417-08-6621");
	    p12.put("Phone number", "206-555-0112");
	    p12.put("Date of Birth", "05/29/1996");
	    p12.put("State", "Washington");
	    p12.put("Zip code", "98101");
	    p12.put("Address Line 1", "1200 5th Ave");
	    p12.put("Address Line 2", "Floor 6");

	    TreeMap<String, String> p13 = new TreeMap<String, String>();
	    p13.put("First Name", "Damian");
	    p13.put("Middle Name", "Nico");
	    p13.put("Last Name", "Volkov");
	    p13.put("Name Suffix", "Sr");
	    p13.put("Email", "damian.volkov@mailto.plus");
	    p13.put("Social Security Number", "268-55-9037");
	    p13.put("Phone number", "702-555-0113");
	    p13.put("Date of Birth", "01/16/1988");
	    p13.put("State", "Nevada");
	    p13.put("Zip code", "89101");
	    p13.put("Address Line 1", "200 S Las Vegas Blvd");
	    p13.put("Address Line 2", "Unit 11C");

	    TreeMap<String, String> p14 = new TreeMap<String, String>();
	    p14.put("First Name", "Amaya");
	    p14.put("Middle Name", "Simone");
	    p14.put("Last Name", "Broussard");
	    p14.put("Name Suffix", "II");
	    p14.put("Email", "amaya.broussard@mailto.plus");
	    p14.put("Social Security Number", "593-21-7704");
	    p14.put("Phone number", "504-555-0114");
	    p14.put("Date of Birth", "12/09/1993");
	    p14.put("State", "Louisiana");
	    p14.put("Zip code", "70112");
	    p14.put("Address Line 1", "909 Poydras St");
	    p14.put("Address Line 2", "Apt 7E");

	    TreeMap<String, String> p15 = new TreeMap<String, String>();
	    p15.put("First Name", "Owen");
	    p15.put("Middle Name", "Julian");
	    p15.put("Last Name", "Kensington");
	    p15.put("Name Suffix", "Jr");
	    p15.put("Email", "owen.kensington@mailto.plus");
	    p15.put("Social Security Number", "174-93-5812");
	    p15.put("Phone number", "602-555-0115");
	    p15.put("Date of Birth", "06/03/1990");
	    p15.put("State", "Arizona");
	    p15.put("Zip code", "85004");
	    p15.put("Address Line 1", "1 N Central Ave");
	    p15.put("Address Line 2", "Suite 700");

	    TreeMap<String, String> p16 = new TreeMap<String, String>();
	    p16.put("First Name", "Eliana");
	    p16.put("Middle Name", "Rose");
	    p16.put("Last Name", "Whitfield");
	    p16.put("Name Suffix", "Mrs");
	    p16.put("Email", "eliana.whitfield@mailto.plus");
	    p16.put("Social Security Number", "405-76-2398");
	    p16.put("Phone number", "615-555-0116");
	    p16.put("Date of Birth", "02/27/1995");
	    p16.put("State", "Tennessee");
	    p16.put("Zip code", "37219");
	    p16.put("Address Line 1", "301 Church St");
	    p16.put("Address Line 2", "Apt 10D");

	    TreeMap<String, String> p17 = new TreeMap<String, String>();
	    p17.put("First Name", "Noah");
	    p17.put("Middle Name", "Sebastian");
	    p17.put("Last Name", "Caldwell");
	    p17.put("Name Suffix", "III");
	    p17.put("Email", "noah.caldwell@mailto.plus");
	    p17.put("Social Security Number", "229-61-4407");
	    p17.put("Phone number", "404-555-0117");
	    p17.put("Date of Birth", "09/01/1992");
	    p17.put("State", "Georgia");
	    p17.put("Zip code", "30303");
	    p17.put("Address Line 1", "200 Peachtree St");
	    p17.put("Address Line 2", "Suite 310");

	    TreeMap<String, String> p18 = new TreeMap<String, String>();
	    p18.put("First Name", "Tristan");
	    p18.put("Middle Name", "Louis");
	    p18.put("Last Name", "Marchand");
	    p18.put("Name Suffix", "Sr");
	    p18.put("Email", "tristan.marchand@mailto.plus");
	    p18.put("Social Security Number", "517-24-9086");
	    p18.put("Phone number", "313-555-0118");
	    p18.put("Date of Birth", "04/10/1989");
	    p18.put("State", "Michigan");
	    p18.put("Zip code", "48226");
	    p18.put("Address Line 1", "500 Woodward Ave");
	    p18.put("Address Line 2", "Floor 12");

	    TreeMap<String, String> p19 = new TreeMap<String, String>();
	    p19.put("First Name", "Mila");
	    p19.put("Middle Name", "Josephine");
	    p19.put("Last Name", "Sterling");
	    p19.put("Name Suffix", "II");
	    p19.put("Email", "mila.sterling@mailto.plus");
	    p19.put("Social Security Number", "361-88-7025");
	    p19.put("Phone number", "214-555-0119");
	    p19.put("Date of Birth", "07/19/1996");
	    p19.put("State", "Texas");
	    p19.put("Zip code", "75201");
	    p19.put("Address Line 1", "2100 Ross Ave");
	    p19.put("Address Line 2", "Unit 4B");

	    TreeMap<String, String> p20 = new TreeMap<String, String>();
	    p20.put("First Name", "Adrian");
	    p20.put("Middle Name", "Lucian");
	    p20.put("Last Name", "Moretti");
	    p20.put("Name Suffix", "Jr");
	    p20.put("Email", "adrian.moretti@mailto.plus");
	    p20.put("Social Security Number", "628-09-3157");
	    p20.put("Phone number", "801-555-0120");
	    p20.put("Date of Birth", "11/15/1991");
	    p20.put("State", "Utah");
	    p20.put("Zip code", "84111");
	    p20.put("Address Line 1", "50 S Main St");
	    p20.put("Address Line 2", "Apt 6F");

	    return new Object[][] {
	        { p1 },
	        { p2 },
	        { p3 },
	        { p4 },
	        { p5 },
	        { p6 },
	        { p7 },
	        { p8 },
	        { p9 },
	        { p10 },
	        { p11 },
	        { p12 },
	        { p13 },
	        { p14 },
	        { p15 },
	        { p16 },
	        { p17 },
	        { p18 },
	        { p19 },
	        { p20 }
	    };
	}







}
	
	
	
	
	
	
	


