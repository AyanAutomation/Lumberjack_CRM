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
		    lf1.put("Name", "Lakeshore Verdict & Settlement Counsel");
		    lf1.put("Phone", "3125557201");
		    lf1.put("City", "Chicago");
		    lf1.put("State", "Illinois");
		    lf1.put("Street Address 1", "200 S Wacker Dr, One Riverside Plaza, Lobby Level");
		    lf1.put("Street Address 2", "Suite 2450, Intake Desk: West Corridor, Elevator Bank C");
		    lf1.put("Zip code", "60606");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "Circle City Plaintiff Strategy Chambers");
		    lf2.put("Phone", "3175557202");
		    lf2.put("City", "Indianapolis");
		    lf2.put("State", "Indiana");
		    lf2.put("Street Address 1", "135 N Pennsylvania St, Monument Circle Office Arcade, North Tower");
		    lf2.put("Street Address 2", "Floor 16, Suite 1605, Reception Desk B");
		    lf2.put("Zip code", "46204");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "Cuyahoga Injury Review & Trial Group");
		    lf3.put("Phone", "2165557203");
		    lf3.put("City", "Cleveland");
		    lf3.put("State", "Ohio");
		    lf3.put("Street Address 1", "55 Public Square, Terminal Tower Annex, Concourse Entry");
		    lf3.put("Street Address 2", "Suite 2100, Mail Stop TT-21, Deliver to Intake Window 2");
		    lf3.put("Zip code", "44113");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "Derby City Wrongful Death & Liability Advocates");
		    lf4.put("Phone", "5025557204");
		    lf4.put("City", "Louisville");
		    lf4.put("State", "Kentucky");
		    lf4.put("Street Address 1", "500 W Jefferson St, Riverfront Commerce Center, East Entrance");
		    lf4.put("Street Address 2", "Ste 1400, Records Intake: Room 14A, Signature Required");
		    lf4.put("Zip code", "40202");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Motor City Product Defect Litigation Studio");
		    lf5.put("Phone", "3135557205");
		    lf5.put("City", "Detroit");
		    lf5.put("State", "Michigan");
		    lf5.put("Street Address 1", "100 Renaissance Center, Riverfront Tower, Check-in Desk A");
		    lf5.put("Street Address 2", "Floor 29, Suite 2912, Deliveries: Weekdays 9AM–4PM");
		    lf5.put("Zip code", "48243");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "Scioto Employment Claims & Wage Recovery Counsel");
		    lf6.put("Phone", "6145557206");
		    lf6.put("City", "Columbus");
		    lf6.put("State", "Ohio");
		    lf6.put("Street Address 1", "41 S High St, Statehouse District Professional Block, South Lobby");
		    lf6.put("Street Address 2", "Suite 2320, Intake Desk C, Leave with Reception if Door Closed");
		    lf6.put("Zip code", "43215");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "West Loop Civil Rights & Police Conduct Counsel");
		    lf7.put("Phone", "7735557207");
		    lf7.put("City", "Chicago");
		    lf7.put("State", "Illinois");
		    lf7.put("Street Address 1", "233 S Wacker Dr, Skyline Concourse Offices, Main Lobby Security");
		    lf7.put("Street Address 2", "Suite 980, Elevator Bank B, Attn: Intake Coordinator");
		    lf7.put("Zip code", "60606");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "Queen City Premises Liability Trial Partners");
		    lf8.put("Phone", "5135557208");
		    lf8.put("City", "Cincinnati");
		    lf8.put("State", "Ohio");
		    lf8.put("Street Address 1", "312 Walnut St, Riverfront Legal Arcade, Corner Entrance on 4th St");
		    lf8.put("Street Address 2", "Suite 505, Mail Stop QC-05, Deliver to Reception A");
		    lf8.put("Zip code", "45202");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "Summit City Workers Comp & Lien Resolution Forum");
		    lf9.put("Phone", "2605557209");
		    lf9.put("City", "Fort Wayne");
		    lf9.put("State", "Indiana");
		    lf9.put("Street Address 1", "127 W Berry St, Courthouse Corridor Office Row, North Entrance");
		    lf9.put("Street Address 2", "Suite 840, Claims Intake Desk, Visitor Badge Required");
		    lf9.put("Zip code", "46802");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "Music City Crash Claims & Insurance Dispute Counsel");
		    lf10.put("Phone", "6155557210");
		    lf10.put("City", "Nashville");
		    lf10.put("State", "Tennessee");
		    lf10.put("Street Address 1", "150 4th Ave N, Downtown Commerce Atrium, Broadway Side Entry");
		    lf10.put("Street Address 2", "Floor 19, Suite 1908, Deliveries: Reception Desk B");
		    lf10.put("Zip code", "37219");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "First Coast Maritime & Dock Injury Counsel");
		    lf11.put("Phone", "9045557211");
		    lf11.put("City", "Jacksonville");
		    lf11.put("State", "Florida");
		    lf11.put("Street Address 1", "76 S Laura St, River City Financial Center, Main Lobby");
		    lf11.put("Street Address 2", "Suite 1415, Attn: Intake Ops, Leave Package with Concierge");
		    lf11.put("Zip code", "32202");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "Uptown Contract Disputes & Business Torts PLLC");
		    lf12.put("Phone", "2145557212");
		    lf12.put("City", "Dallas");
		    lf12.put("State", "Texas");
		    lf12.put("Street Address 1", "2101 Cedar Springs Rd, Crescent District Office Gallery, North Wing");
		    lf12.put("Street Address 2", "Suite 1550, Mail Stop TX-15, Deliver to Intake Window");
		    lf12.put("Zip code", "75201");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "Sonoran Slip-Fall & Negligence Litigation Group");
		    lf13.put("Phone", "6025557213");
		    lf13.put("City", "Phoenix");
		    lf13.put("State", "Arizona");
		    lf13.put("Street Address 1", "201 E Washington St, Copper Square Office Terrace, East Lobby");
		    lf13.put("Street Address 2", "Suite 1545, Deliveries: Weekdays Only, Reception Desk A2");
		    lf13.put("Zip code", "85004");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "Puget Sound Medical Malpractice Audit Counsel");
		    lf14.put("Phone", "2065557214");
		    lf14.put("City", "Seattle");
		    lf14.put("State", "Washington");
		    lf14.put("Street Address 1", "800 5th Ave, Emerald Plaza Offices, Main Entrance Security Desk");
		    lf14.put("Street Address 2", "Suite 2680, Attn: Records Intake, Package Scan Required");
		    lf14.put("Zip code", "98104");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "Front Range Discrimination & Retaliation Counsel");
		    lf15.put("Phone", "3035557215");
		    lf15.put("City", "Denver");
		    lf15.put("State", "Colorado");
		    lf15.put("Street Address 1", "1700 Lincoln St, Civic Center Professional Annex, East Tower Lobby");
		    lf15.put("Street Address 2", "Suite 3100, Intake Desk: Room 31F, Visitor Parking P2");
		    lf15.put("Zip code", "80202");

		    return new Object[][]{
		        {lf1},{lf2},{lf3},{lf4},{lf5},
		        {lf6},{lf7},{lf8},{lf9},{lf10},
		        {lf11},{lf12},{lf13},{lf14},{lf15} 
		    };
		}

		
		
		
		
		
		
	

}
