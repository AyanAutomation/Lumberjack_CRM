package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Locaters.Application_Locaters;
import Locaters.Attorney_Locaters;
import Locaters.Law_firm_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Law_Firm_Module extends Attorney_module{
	
	
	@Test(dataProvider="lawFirmData")
	public void Add_Law_Firm(TreeMap<String,String>data) throws IOException, InterruptedException{
		
		Law_firm_Locaters pp = new Law_firm_Locaters(d);	
		SIde_Menu_Handler sd=new SIde_Menu_Handler();
		Plaintiff_Locaters p=new Plaintiff_Locaters(d);
		Application_Locaters ap = new Application_Locaters(d);
		Repeat rp=new Repeat(d);
		Login_Locaters lg=new Login_Locaters(d);
		
		
		
		String Firm_name = data.get("Name");
		sd.Side_menu_option_clicker("Firm & Counsel",d,"Law Firm");	
		pp.landed_in_Law_Firm_module();
		rp.Scroll_to_element(p.form());
		Thread.sleep(800);	
		List<WebElement> input_feilds=p.inputs();	
 
		input_feilds.get(0).sendKeys(Firm_name);;
	    input_feilds.get(1).sendKeys(data.get("Phone"));
		input_feilds.get(2).sendKeys(data.get("State"));
		ap.plaintiff_dropdown_list();
		ap.Plaintiff_options().get(0).click();
		input_feilds.get(3).sendKeys(data.get("City"));	
		input_feilds.get(4).sendKeys(data.get("Zip code"));
		input_feilds.get(5).sendKeys(data.get("Street Address 1"));
		input_feilds.get(6).sendKeys(data.get("Street Address 2"));	

		WebElement Add_Law_Frim_Button=p.form_buttons().get(0);
		rp.Scroll_to_element(Add_Law_Frim_Button);
		Add_Law_Frim_Button.click();
		Thread.sleep(800);	
		String taost= lg.toast().getText().trim();
		Login_negative_testcases.Toast_printer(taost);
		
		
		
		
		
		
	}
		
		@DataProvider
		public Object[][] lawFirmData() {

		    // ✅ Keys mapped to your "Add Law Firm" modal:
		    // Name, Phone, City, State, Street Address 1, Street Address 2, Zip code

			TreeMap<String, String> lf1 = new TreeMap<>();
		    lf1.put("Name", "Harborline Catastrophic Injury & Trial Atelier");
		    lf1.put("Phone", "9295558301");
		    lf1.put("City", "New York");
		    lf1.put("State", "New York");
		    lf1.put("Street Address 1", "110 Wall Street, Seaport Financial Arcade, South Lobby Check-in");
		    lf1.put("Street Address 2", "Suite 2410, Intake Window: Desk S2, Elevator Bank D, Visitor Badge Required");
		    lf1.put("Zip code", "10005");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "Cascadia Surgical Negligence Review Counsel");
		    lf2.put("Phone", "9295558302");
		    lf2.put("City", "Seattle");
		    lf2.put("State", "Washington");
		    lf2.put("Street Address 1", "901 5th Avenue, Emerald Plaza Offices, Main Entrance Security Desk");
		    lf2.put("Street Address 2", "Floor 19, Suite 1906, Records Intake: Scan Package at Lobby Counter");
		    lf2.put("Zip code", "98104");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "Bluegrass Liability & Wrongful Death Chambers");
		    lf3.put("Phone", "9295558303");
		    lf3.put("City", "Louisville");
		    lf3.put("State", "Kentucky");
		    lf3.put("Street Address 1", "601 W Main Street, Riverfront Commerce Center, East Entrance");
		    lf3.put("Street Address 2", "Suite 1425, Intake Desk: Room 14A, Signature Required on Delivery");
		    lf3.put("Zip code", "40202");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "High Desert Crash Claims & Coverage Dispute Counsel");
		    lf4.put("Phone", "9295558304");
		    lf4.put("City", "Phoenix");
		    lf4.put("State", "Arizona");
		    lf4.put("Street Address 1", "2 N Central Avenue, Copper Square Office Terrace, North Lobby");
		    lf4.put("Street Address 2", "Suite 1750, Deliver to Reception A1, Weekdays Only 9AM–4PM");
		    lf4.put("Zip code", "85004");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Front Range Wage Recovery & Retaliation Counsel");
		    lf5.put("Phone", "9295558305");
		    lf5.put("City", "Denver");
		    lf5.put("State", "Colorado");
		    lf5.put("Street Address 1", "1700 Broadway, Civic Center Professional Annex, East Tower Lobby");
		    lf5.put("Street Address 2", "Suite 3108, Intake Desk: 31F, Visitor Parking: Garage P2 (Validate at Reception)");
		    lf5.put("Zip code", "80202");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "Gulfstream Maritime & Dock Injury Counsel");
		    lf6.put("Phone", "9295558306");
		    lf6.put("City", "Jacksonville");
		    lf6.put("State", "Florida");
		    lf6.put("Street Address 1", "200 S Hogan Street, River City Financial Center, Main Lobby Check-in");
		    lf6.put("Street Address 2", "Suite 1412, Attn: Intake Ops, Leave Package with Concierge if Office Door Closed");
		    lf6.put("Zip code", "32202");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "Prairie State Product Liability Proof Lab");
		    lf7.put("Phone", "9295558307");
		    lf7.put("City", "Chicago");
		    lf7.put("State", "Illinois");
		    lf7.put("Street Address 1", "200 S Wacker Drive, One Riverside Plaza, Lobby Level Visitor Check-in");
		    lf7.put("Street Address 2", "Suite 2675, Intake Desk: West Corridor, Elevator Bank C, Mail Stop IL-26");
		    lf7.put("Zip code", "60606");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "Circle City Plaintiff Strategy & Lien Resolution Forum");
		    lf8.put("Phone", "9295558308");
		    lf8.put("City", "Indianapolis");
		    lf8.put("State", "Indiana");
		    lf8.put("Street Address 1", "135 N Pennsylvania Street, Monument Circle Office Arcade, North Tower Entrance");
		    lf8.put("Street Address 2", "Floor 16, Suite 1612, Reception Desk B, Deliveries: Weekdays 9AM–5PM");
		    lf8.put("Zip code", "46204");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "Lone Star Contract Disputes & Business Torts Studio");
		    lf9.put("Phone", "9295558309");
		    lf9.put("City", "Dallas");
		    lf9.put("State", "Texas");
		    lf9.put("Street Address 1", "1700 Pacific Avenue, Uptown Commerce Gallery, Main Lobby Security Counter");
		    lf9.put("Street Address 2", "Suite 1822, Mail Stop TX-18, Deliver to Intake Window 1 (Package Scan Required)");
		    lf9.put("Zip code", "75201");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "Great Lakes Class Action & Mass Tort Review Counsel");
		    lf10.put("Phone", "9295558310");
		    lf10.put("City", "Detroit");
		    lf10.put("State", "Michigan");
		    lf10.put("Street Address 1", "500 Woodward Avenue, Riverfront Tower Annex, Check-in Desk A");
		    lf10.put("Street Address 2", "Floor 22, Suite 2214, Deliveries: Reception Desk R2, Weekdays 9AM–4PM");
		    lf10.put("Zip code", "48226");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "Buckeye Premises Liability & Negligence Trial Partners");
		    lf11.put("Phone", "9295558311");
		    lf11.put("City", "Columbus");
		    lf11.put("State", "Ohio");
		    lf11.put("Street Address 1", "155 N High Street, Statehouse District Professional Block, South Lobby");
		    lf11.put("Street Address 2", "Suite 2310, Intake Desk C, Leave with Reception if Door Closed");
		    lf11.put("Zip code", "43215");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "Volunteer State Crash Claims & Coverage Dispute Counsel");
		    lf12.put("Phone", "9295558312");
		    lf12.put("City", "Nashville");
		    lf12.put("State", "Tennessee");
		    lf12.put("Street Address 1", "150 4th Avenue N, Downtown Commerce Atrium, Broadway Side Entry");
		    lf12.put("Street Address 2", "Floor 19, Suite 1911, Deliveries: Reception Desk B, Visitor Badge Required");
		    lf12.put("Zip code", "37219");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "Keystone Bad Faith Insurance & Claim Denial Counsel");
		    lf13.put("Phone", "9295558313");
		    lf13.put("City", "Pittsburgh");
		    lf13.put("State", "Pennsylvania");
		    lf13.put("Street Address 1", "600 Grant Street, Steel City Office Terrace, Main Lobby Check-in");
		    lf13.put("Street Address 2", "Suite 1520, Attn: Intake Operations, Mail Stop PA-15, Package Scan at Security");
		    lf13.put("Zip code", "15219");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "Ocean State Workers Comp & Wage Claims Counsel");
		    lf14.put("Phone", "9295558314");
		    lf14.put("City", "Providence");
		    lf14.put("State", "Rhode Island");
		    lf14.put("Street Address 1", "10 Dorrance Street, Downtown Legal Arcade, North Entrance");
		    lf14.put("Street Address 2", "Suite 900, Claims Intake: Desk 9B, Deliveries: Weekdays Only");
		    lf14.put("Zip code", "02903");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "Empire State Civil Rights & Police Conduct Counsel");
		    lf15.put("Phone", "9295558315");
		    lf15.put("City", "Buffalo");
		    lf15.put("State", "New York");
		    lf15.put("Street Address 1", "200 Delaware Avenue, City Center Office Row, Main Lobby");
		    lf15.put("Street Address 2", "Suite 1210, Attn: Records Intake, Elevator Bank A, Floor 12");
		    lf15.put("Zip code", "14202");

		    TreeMap<String, String> lf16 = new TreeMap<>();
		    lf16.put("Name", "Capital District Regulatory & Administrative Hearing Counsel");
		    lf16.put("Phone", "9295558316");
		    lf16.put("City", "Washington");
		    lf16.put("State", "Washington DC");
		    lf16.put("Street Address 1", "750 9th Street NW, Judiciary Square Business Annex, Main Entrance");
		    lf16.put("Street Address 2", "Suite 1205, Intake Desk: Lobby Counter 2, Package Scan Required");
		    lf16.put("Zip code", "20001");

		    TreeMap<String, String> lf17 = new TreeMap<>();
		    lf17.put("Name", "Armed Forces Claims & Benefits Advocacy Office");
		    lf17.put("Phone", "9295558317");
		    lf17.put("City", "Arlington");
		    lf17.put("State", "Armed Forces Europe");
		    lf17.put("Street Address 1", "1 Defense Way, Service Member Support Center, Main Gate Check-in");
		    lf17.put("Street Address 2", "Suite 410, Attn: Intake Ops, Deliver to Admin Desk, ID Required at Entry");
		    lf17.put("Zip code", "22202");

		    TreeMap<String, String> lf18 = new TreeMap<>();
		    lf18.put("Name", "Aloha Settlement Strategy & Medical Negligence Counsel");
		    lf18.put("Phone", "9295558318");
		    lf18.put("City", "Honolulu");
		    lf18.put("State", "Hawaii");
		    lf18.put("Street Address 1", "1001 Bishop Street, Downtown Honolulu Office Gallery, South Lobby");
		    lf18.put("Street Address 2", "Suite 1810, Reception Desk H1, Deliveries: Weekdays 9AM–4PM");
		    lf18.put("Zip code", "96813");

		    TreeMap<String, String> lf19 = new TreeMap<>();
		    lf19.put("Name", "Bayou Evidence Preservation & Trial Support Counsel");
		    lf19.put("Phone", "9295558319");
		    lf19.put("City", "Baton Rouge");
		    lf19.put("State", "Louisiana");
		    lf19.put("Street Address 1", "445 North Boulevard, Capitol Park Legal Terrace, Main Lobby");
		    lf19.put("Street Address 2", "Suite 915, Attn: Intake Desk, Deliver to Reception, Add Note: “Hold for Signature”");
		    lf19.put("Zip code", "70802");

		    TreeMap<String, String> lf20 = new TreeMap<>();
		    lf20.put("Name", "Granite State Workplace Injury & Disability Counsel");
		    lf20.put("Phone", "9295558320");
		    lf20.put("City", "Manchester");
		    lf20.put("State", "New Hampshire");
		    lf20.put("Street Address 1", "900 Elm Street, Queen City Commerce Atrium, North Lobby");
		    lf20.put("Street Address 2", "Suite 1700, Claims Intake: Desk 17C, Visitor Parking: Garage Level 1");
		    lf20.put("Zip code", "03101");

		    return new Object[][]{
		        {lf1},{lf2},{lf3},{lf4},{lf5},
		        {lf6},{lf7},{lf8},{lf9},{lf10},
		        {lf11},{lf12},{lf13},{lf14},{lf15},
		        {lf16},{lf17},{lf18},{lf19},{lf20}
		    };
		}

		
		
		
		
		
		
	

}
