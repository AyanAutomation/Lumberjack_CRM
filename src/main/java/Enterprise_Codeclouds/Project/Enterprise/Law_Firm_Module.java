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
		Login_negative_testcases.Toast_printer(taost);}
		
	
	   @Test(dataProvider="law_plus_attorney")
	   public void Law_firm_contact_Add_through_Case_Contact(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff) throws IOException, InterruptedException{
		   
		    SIde_Menu_Handler sd = new SIde_Menu_Handler();
			Application_Locaters p = new Application_Locaters(d);
			Repeat rp = new Repeat(d);
			Login_Locaters lg = new Login_Locaters(d);
		
			
	     String	Law_Firm_Name = law_firm.get("Name");	
		
		WebElement Create_Contact;
		try{Create_Contact = p.Create_Contact_button();}
		catch(Exception not_inside_case_contact_list){
			sd.Side_menu_option_clicker("Applications", d,"N/A");
			p.landed_in_applicationList_confirmation();	
			p.rows().get(1).click();
			Thread.sleep(800);}	
		List<WebElement> Case_Tags;
		   try {
		   Case_Tags = p.Case_tags();}
		   catch(RuntimeException tags){
			   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
			   System.out.println();
			   Thread.sleep(1200);
			   Case_Tags = p.Case_tags(); }
		    tab_selector("Contacts");
			p.lawFirm_AddButton_ContactTab();
			rp.Scroll_to_element(p.Contact_AddButton_ContactTab());
			p.Contact_AddButton_ContactTab().click();
			p.Contact_type_dropdown_list();
			List<WebElement> Contact_Options = p.Contact_type_Options();
			for(WebElement Cn_opt:Contact_Options){
			if(Cn_opt.getText().trim().equalsIgnoreCase("Law Firm Contact")){
					Cn_opt.click();
					break;}}
			p.pop_up_contact_list(); 
			p.pop_up_contact_list();
			Thread.sleep(800);
			p.Popup_modal_search().sendKeys(Law_Firm_Name);
			Thread.sleep(800);
			WebElement toast = lg.toast();
			rp.wait_for_invisibility(toast);
			try {
			p.List_Checkboxes().get(0).click();}
			catch(Exception Law_firm_){
				WebElement CreateContact = p.Create_Contact_button();
				rp.Scroll_to_element(CreateContact);
				CreateContact.click();
				List<WebElement> Law_firm_contacts_inputs = p.second_popup_form_inputs();
				Law_firm_contacts_inputs.get(0).sendKeys(Law_Firm_Name);
				p.plaintiff_dropdown_list();
				p.Plaintiff_options().get(0).click();
				Law_firm_contacts_inputs.get(1).sendKeys(data.get("First Name"));
				Law_firm_contacts_inputs.get(2).sendKeys(data.get("Middle Name"));
				Law_firm_contacts_inputs.get(3).sendKeys(data.get("Last Name"));
				Law_firm_contacts_inputs.get(4).sendKeys(data.get("Name Suffix"));
				Law_firm_contacts_inputs.get(5).sendKeys(data.get("Phone"));
				Law_firm_contacts_inputs.get(6).sendKeys(data.get("Office phone"));
				Law_firm_contacts_inputs.get(7).sendKeys(data.get("Email"));
			/*	WebElement Add_staff_button= p.second_popup_form_buttons().get(1);
				Add_staff_button.click();
				List<WebElement> fields = p.Third_popup_form_inputs();
				WebElement Staff_pop_up_form = p.Third_popup_form();
				WebElement Staff_Add_button= p.Third_popup_form_buttons().get(1);
				staff_add(staff,fields,Staff_pop_up_form,Staff_Add_button); */
				WebElement Add_Create_Contact_Button=p.second_popup_form_buttons().get(2);
				rp.Scroll_to_element(Add_Create_Contact_Button);
				Add_Create_Contact_Button.click();
				Thread.sleep(800);	
				WebElement Toast = lg.toast();
				String taost= Toast.getText().trim();
				Login_negative_testcases.Toast_printer(taost);}}
	
	
	
	
	
	
	
	
		@DataProvider
		public Object[][] lawFirmData() {

		    // ✅ Keys mapped to your "Add Law Firm" modal:
		    // Name, Phone, City, State, Street Address 1, Street Address 2, Zip code

			TreeMap<String, String> lf1 = new TreeMap<>();
		    lf1.put("Name", "VerdictForge Litigation Atelier");
		    lf1.put("Phone", "3024389017");
		    lf1.put("City", "Wilmington");
		    lf1.put("State", "Delaware");
		    lf1.put("Street Address 1", "919 N Market St, Brandywine Commerce Center, Main Lobby");
		    lf1.put("Street Address 2", "Suite 1204, Intake: Desk 3, Elevator Bank A");
		    lf1.put("Zip code", "19801");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "NorthStar Docketworks");
		    lf2.put("Phone", "8026317742");
		    lf2.put("City", "Burlington");
		    lf2.put("State", "Vermont");
		    lf2.put("Street Address 1", "100 Main St, Lakefront Professional Building, Street Entrance");
		    lf2.put("Street Address 2", "Floor 6, Suite 6B, Delivery: Reception Window");
		    lf2.put("Zip code", "05401");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "Cascade Claimcraft Legal Studio");
		    lf3.put("Phone", "5032196804");
		    lf3.put("City", "Portland");
		    lf3.put("State", "Oregon");
		    lf3.put("Street Address 1", "111 SW 5th Ave, Pioneer District Office Arcade, Security Desk");
		    lf3.put("Street Address 2", "Suite 1740, Mail Stop OR-17, Signature Required");
		    lf3.put("Zip code", "97204");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "Keystone Dispute Lab");
		    lf4.put("Phone", "4127765409");
		    lf4.put("City", "Pittsburgh");
		    lf4.put("State", "Pennsylvania");
		    lf4.put("Street Address 1", "600 Grant St, Steel City Tower, Concourse Entry");
		    lf4.put("Street Address 2", "Suite 2109, Intake: Counter B, Visitor Badge Needed");
		    lf4.put("Zip code", "15219");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Peachtree Litigation Works");
		    lf5.put("Phone", "4049152638");
		    lf5.put("City", "Atlanta");
		    lf5.put("State", "Georgia");
		    lf5.put("Street Address 1", "191 Peachtree St NE, Midtown Commerce Annex, Main Lobby");
		    lf5.put("Street Address 2", "Floor 14, Suite 1402, Deliveries: Desk A");
		    lf5.put("Zip code", "30303");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "HarborLedger Trial Office");
		    lf6.put("Phone", "4106821570");
		    lf6.put("City", "Baltimore");
		    lf6.put("State", "Maryland");
		    lf6.put("Street Address 1", "10 Light St, Inner Harbor Business Tower, West Entrance");
		    lf6.put("Street Address 2", "Suite 1806, Intake: Room 18C, Package Scan at Security");
		    lf6.put("Zip code", "21202");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "BayState Casebuilders");
		    lf7.put("Phone", "5084339261");
		    lf7.put("City", "Worcester");
		    lf7.put("State", "Massachusetts");
		    lf7.put("Street Address 1", "255 Park Ave, Downtown Professional Row, Main Desk");
		    lf7.put("Street Address 2", "Suite 901, Mail Stop MA-09, Leave with Reception");
		    lf7.put("Zip code", "01609");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "MillCity Docket Foundry");
		    lf8.put("Phone", "6125078436");
		    lf8.put("City", "Minneapolis");
		    lf8.put("State", "Minnesota");
		    lf8.put("Street Address 1", "120 S 6th St, Skyway Commerce Plaza, North Lobby");
		    lf8.put("Street Address 2", "Suite 2405, Intake: Desk 2, Elevator Bank C");
		    lf8.put("Zip code", "55402");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "Gateway Pleading House");
		    lf9.put("Phone", "3147905524");
		    lf9.put("City", "St. Louis");
		    lf9.put("State", "Missouri");
		    lf9.put("Street Address 1", "1 S Memorial Dr, Arch District Office Tower, Main Lobby");
		    lf9.put("Street Address 2", "Floor 16, Suite 1608, Deliveries: Weekdays Only");
		    lf9.put("Zip code", "63102");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "PrairieMotion Claims Studio");
		    lf10.put("Phone", "3166881049");
		    lf10.put("City", "Wichita");
		    lf10.put("State", "Kansas");
		    lf10.put("Street Address 1", "100 N Broadway St, Old Town Commerce Block, East Entrance");
		    lf10.put("Street Address 2", "Suite 705, Intake: Window 1, Visitor Parking Level 2");
		    lf10.put("Zip code", "67202");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "FrontRange Trial Mechanics");
		    lf11.put("Phone", "7195338702");
		    lf11.put("City", "Colorado Springs");
		    lf11.put("State", "Colorado");
		    lf11.put("Street Address 1", "2 N Cascade Ave, Civic Center Office Annex, South Lobby");
		    lf11.put("Street Address 2", "Suite 1109, Intake: Desk C, Badge Pickup at Security");
		    lf11.put("Zip code", "80903");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "Capitol Briefworks");
		    lf12.put("Phone", "5129401168");
		    lf12.put("City", "Austin");
		    lf12.put("State", "Texas");
		    lf12.put("Street Address 1", "600 Congress Ave, Downtown Commerce Gallery, Main Entrance");
		    lf12.put("Street Address 2", "Suite 2204, Mail Stop TX-22, Deliver to Reception B");
		    lf12.put("Zip code", "78701");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "SunCoast Liability Atelier");
		    lf13.put("Phone", "8137714056");
		    lf13.put("City", "Tampa");
		    lf13.put("State", "Florida");
		    lf13.put("Street Address 1", "201 N Franklin St, Riverwalk Business Center, Security Desk");
		    lf13.put("Street Address 2", "Suite 1907, Intake: Room 19A, Call-on-arrival");
		    lf13.put("Zip code", "33602");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "InlandBrief Trial Rooms");
		    lf14.put("Phone", "5096287341");
		    lf14.put("City", "Spokane");
		    lf14.put("State", "Washington");
		    lf14.put("Street Address 1", "601 W 1st Ave, Downtown Office Promenade, West Lobby");
		    lf14.put("Street Address 2", "Suite 1403, Intake: Desk 1, Package Scan Required");
		    lf14.put("Zip code", "99201");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "Silicon Valley Caseworks Bureau");
		    lf15.put("Phone", "4086159027");
		    lf15.put("City", "San Jose");
		    lf15.put("State", "California");
		    lf15.put("Street Address 1", "1 S Market St, Plaza District Office Tower, Main Lobby");
		    lf15.put("Street Address 2", "Suite 2010, Intake: Counter A, Visitor Badge Needed");
		    lf15.put("Zip code", "95113");

		    TreeMap<String, String> lf16 = new TreeMap<>();
		    lf16.put("Name", "DuPage Trialcraft Office");
		    lf16.put("Phone", "6304417305");
		    lf16.put("City", "Naperville");
		    lf16.put("State", "Illinois");
		    lf16.put("Street Address 1", "175 W Jackson Ave, Riverwalk Professional Center, Lobby Level");
		    lf16.put("Street Address 2", "Suite 905, Mail Stop IL-09, Deliveries: Reception");
		    lf16.put("Zip code", "60540");

		    TreeMap<String, String> lf17 = new TreeMap<>();
		    lf17.put("Name", "RiverBend Pleading Studio");
		    lf17.put("Phone", "8123709184");
		    lf17.put("City", "Evansville");
		    lf17.put("State", "Indiana");
		    lf17.put("Street Address 1", "20 NW 1st St, Downtown Commerce Row, North Entrance");
		    lf17.put("Street Address 2", "Suite 604, Intake: Desk B, Visitor Parking Garage A");
		    lf17.put("Zip code", "47708");

		    TreeMap<String, String> lf18 = new TreeMap<>();
		    lf18.put("Name", "SummitCourt Litigation Desk");
		    lf18.put("Phone", "3307926031");
		    lf18.put("City", "Akron");
		    lf18.put("State", "Ohio");
		    lf18.put("Street Address 1", "1 S Main St, Courthouse District Office Annex, Main Lobby");
		    lf18.put("Street Address 2", "Suite 1506, Intake: Room 15D, Signature Required");
		    lf18.put("Zip code", "44308");

		    TreeMap<String, String> lf19 = new TreeMap<>();
		    lf19.put("Name", "Sonoran Docketwright Office");
		    lf19.put("Phone", "4806281975");
		    lf19.put("City", "Mesa");
		    lf19.put("State", "Arizona");
		    lf19.put("Street Address 1", "40 N Center St, Downtown Commerce Atrium, East Lobby");
		    lf19.put("Street Address 2", "Suite 1210, Intake: Desk 2, Call Reception on Arrival");
		    lf19.put("Zip code", "85201");

		    TreeMap<String, String> lf20 = new TreeMap<>();
		    lf20.put("Name", "SangreBrief Civil Practice Atelier");
		    lf20.put("Phone", "5056447813");
		    lf20.put("City", "Santa Fe");
		    lf20.put("State", "New Mexico");
		    lf20.put("Street Address 1", "201 W Marcy St, Capitol District Office Block, Main Desk");
		    lf20.put("Street Address 2", "Suite 708, Mail Stop NM-07, Deliveries Weekdays Only");
		    lf20.put("Zip code", "87501");

		    return new Object[][]{
		        {lf1},{lf2},{lf3},{lf4},{lf5},
		        {lf6},{lf7},{lf8},{lf9},{lf10},
		        {lf11},{lf12},{lf13},{lf14},{lf15},
		        {lf16},{lf17},{lf18},{lf19},{lf20} 
		    };
		}

		
		
		
		
		
		
	

}
