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
		    lf1.put("Name", "Northlake Injury & Trial Counsel");
		    lf1.put("Phone", "3125556101");
		    lf1.put("City", "Chicago");
		    lf1.put("State", "Illinois");
		    lf1.put("Street Address 1", "120 N LaSalle St");
		    lf1.put("Street Address 2", "Suite 1800");
		    lf1.put("Zip code", "60602");

		    TreeMap<String, String> lf2 = new TreeMap<>();
		    lf2.put("Name", "Meridian Civil Litigation Partners");
		    lf2.put("Phone", "3175556102");
		    lf2.put("City", "Indianapolis");
		    lf2.put("State", "Indiana");
		    lf2.put("Street Address 1", "50 W Washington St");
		    lf2.put("Street Address 2", "Floor 9");
		    lf2.put("Zip code", "46204");

		    TreeMap<String, String> lf3 = new TreeMap<>();
		    lf3.put("Name", "Lakefront Medical Negligence Group");
		    lf3.put("Phone", "2165556103");
		    lf3.put("City", "Cleveland");
		    lf3.put("State", "Ohio");
		    lf3.put("Street Address 1", "200 Public Square");
		    lf3.put("Street Address 2", "Suite 2200");
		    lf3.put("Zip code", "44114");

		    TreeMap<String, String> lf4 = new TreeMap<>();
		    lf4.put("Name", "Bluegrass Wrongful Death Advocates");
		    lf4.put("Phone", "5025556104");
		    lf4.put("City", "Louisville");
		    lf4.put("State", "Kentucky");
		    lf4.put("Street Address 1", "500 W Jefferson St");
		    lf4.put("Street Address 2", "Ste 1400");
		    lf4.put("Zip code", "40202");

		    TreeMap<String, String> lf5 = new TreeMap<>();
		    lf5.put("Name", "Great Lakes Products Liability Law Center");
		    lf5.put("Phone", "3135556105");
		    lf5.put("City", "Detroit");
		    lf5.put("State", "Michigan");
		    lf5.put("Street Address 1", "500 Woodward Ave");
		    lf5.put("Street Address 2", "Floor 12");
		    lf5.put("Zip code", "48226");

		    TreeMap<String, String> lf6 = new TreeMap<>();
		    lf6.put("Name", "Capitol Employment Disputes Attorneys");
		    lf6.put("Phone", "6145556106");
		    lf6.put("City", "Columbus");
		    lf6.put("State", "Ohio");
		    lf6.put("Street Address 1", "150 N High St");
		    lf6.put("Street Address 2", "Suite 700");
		    lf6.put("Zip code", "43215");

		    TreeMap<String, String> lf7 = new TreeMap<>();
		    lf7.put("Name", "Windy City Civil Rights Defense Group");
		    lf7.put("Phone", "7735556107");
		    lf7.put("City", "Chicago");
		    lf7.put("State", "Illinois");
		    lf7.put("Street Address 1", "233 S Wacker Dr");
		    lf7.put("Street Address 2", "Suite 900");
		    lf7.put("Zip code", "60606");

		    TreeMap<String, String> lf8 = new TreeMap<>();
		    lf8.put("Name", "Riverbend Premises Liability Counsel");
		    lf8.put("Phone", "5135556108");
		    lf8.put("City", "Cincinnati");
		    lf8.put("State", "Ohio");
		    lf8.put("Street Address 1", "312 Walnut St");
		    lf8.put("Street Address 2", "Apt 5B");
		    lf8.put("Zip code", "45202");

		    TreeMap<String, String> lf9 = new TreeMap<>();
		    lf9.put("Name", "Hoosier Workers Compensation Chambers");
		    lf9.put("Phone", "2605556109");
		    lf9.put("City", "Fort Wayne");
		    lf9.put("State", "Indiana");
		    lf9.put("Street Address 1", "200 E Main St");
		    lf9.put("Street Address 2", "Suite 300");
		    lf9.put("Zip code", "46802");

		    TreeMap<String, String> lf10 = new TreeMap<>();
		    lf10.put("Name", "Motor Crash & Insurance Disputes PLLC");
		    lf10.put("Phone", "6155556110");
		    lf10.put("City", "Nashville");
		    lf10.put("State", "Tennessee");
		    lf10.put("Street Address 1", "301 Church St");
		    lf10.put("Street Address 2", "Floor 10");
		    lf10.put("Zip code", "37219");

		    TreeMap<String, String> lf11 = new TreeMap<>();
		    lf11.put("Name", "Atlantic Coastal Maritime & Jones Act Counsel");
		    lf11.put("Phone", "9045556111");
		    lf11.put("City", "Jacksonville");
		    lf11.put("State", "Florida");
		    lf11.put("Street Address 1", "76 S Laura St");
		    lf11.put("Street Address 2", "Suite 1400");
		    lf11.put("Zip code", "32202");

		    TreeMap<String, String> lf12 = new TreeMap<>();
		    lf12.put("Name", "Lone Star Breach of Contract Litigation");
		    lf12.put("Phone", "2145556112");
		    lf12.put("City", "Dallas");
		    lf12.put("State", "Texas");
		    lf12.put("Street Address 1", "1700 Pacific Ave");
		    lf12.put("Street Address 2", "Unit 18C");
		    lf12.put("Zip code", "75201");

		    TreeMap<String, String> lf13 = new TreeMap<>();
		    lf13.put("Name", "Desert State Slip & Fall Trial Group");
		    lf13.put("Phone", "6025556113");
		    lf13.put("City", "Phoenix");
		    lf13.put("State", "Arizona");
		    lf13.put("Street Address 1", "20 E Van Buren St");
		    lf13.put("Street Address 2", "Suite 740");
		    lf13.put("Zip code", "85004");

		    TreeMap<String, String> lf14 = new TreeMap<>();
		    lf14.put("Name", "Evergreen Medical Malpractice Review Team");
		    lf14.put("Phone", "2065556114");
		    lf14.put("City", "Seattle");
		    lf14.put("State", "Washington");
		    lf14.put("Street Address 1", "600 Pine St");
		    lf14.put("Street Address 2", "Floor 11");
		    lf14.put("Zip code", "98101");

		    TreeMap<String, String> lf15 = new TreeMap<>();
		    lf15.put("Name", "Rocky Mountain Discrimination & Wage Claims");
		    lf15.put("Phone", "3035556115");
		    lf15.put("City", "Denver");
		    lf15.put("State", "Colorado");
		    lf15.put("Street Address 1", "1430 Wynkoop St");
		    lf15.put("Street Address 2", "Suite 500");
		    lf15.put("Zip code", "80202");

		    return new Object[][]{
		        {lf1},{lf2},{lf3},{lf4},{lf5},
		        {lf6},{lf7},{lf8},{lf9},{lf10},
		        {lf11},{lf12},{lf13},{lf14},{lf15}
		    };
		}

		
		
		
		
		
		
	

}
