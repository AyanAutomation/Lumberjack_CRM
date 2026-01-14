package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Locaters.User_Module_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class User_Module extends Header_Manager{
	
	
	@Test(dataProvider="User_and_group_Data")
	public void user_add(TreeMap<String, String> data,TreeMap<String, String> Group_data) throws IOException, InterruptedException{
		
		
		User_Module_Locaters p = new User_Module_Locaters(d);
		Plaintiff_Locaters pt=new Plaintiff_Locaters(d);
		Application_Locaters ap = new Application_Locaters(d);
		Repeat rp=new Repeat(d);
		Login_Locaters lg=new Login_Locaters(d);
		
		String user_name = data.get("First Name");
		String Group_name = Group_data.get("Group Name");
		
		header_dropdown_option_selector("My Preferences");
		p.landed_in_user_module();
		rp.Scroll_to_element(pt.form());
		p.First_Name().sendKeys(user_name);
		p.Middle_Name().sendKeys(data.get("Middle Name"));
		p.Last_Name().sendKeys(data.get("Last Name"));
		List<WebElement> phone_number_fields = p.ph_number_fields();
		phone_number_fields.get(0).sendKeys(data.get("Phone Number (Primary)"));
		phone_number_fields.get(1).sendKeys(data.get("Phone Number (Secondary)"));
		p.email().sendKeys(data.get("Email"));
		WebElement Group_feild = p.Group_feild();
		rp.movetoelement(Group_feild);
		Group_feild.click();
		Group_feild.sendKeys(Group_name);
		Thread.sleep(800);
        ap.plaintiff_dropdown_list();
		List<WebElement> group_options = ap.Plaintiff_options();
		for(WebElement opt:group_options){
			String option_text = opt.getText().trim();
			if(option_text.equalsIgnoreCase(Group_name)){
				System.out.println(option_text);
				opt.click();
				break;}} 
		WebElement Add_Law_Frim_Button=pt.form_buttons().get(0);
		rp.Scroll_to_element(Add_Law_Frim_Button);
		Add_Law_Frim_Button.click();
		Thread.sleep(800);	
		WebElement Toast= lg.toast();
		String toast= Toast.getText().trim();
		Login_negative_testcases.Toast_printer(toast);
		}
	    
	
	@DataProvider
	public Object[][] User_and_group_Data(){
		
		Access_Permissions ac = new Access_Permissions();
		
		Object[][] user_datas = UserData();
		Object[][] group_data = ac.roleData();
		
		int n = Math.min(user_datas.length, group_data.length);
		Object[][] final_set = new Object[n][2];
		for(int i=0;i<n;i++){
			   final_set[i][0] = user_datas[i][0];      
		       final_set[i][1] = group_data[i][0]; 
		    }
		
		return final_set;
	}
	
	
	@DataProvider
	public Object[][] UserData() {


		TreeMap<String, String> u1 = new TreeMap<>();
	    u1.put("First Name", "Avenor");
	    u1.put("Middle Name", "Kyren");
	    u1.put("Last Name", "Thornveil");
	    u1.put("Phone Number (Primary)", "9867123401");
	    u1.put("Phone Number (Secondary)", "3579128401");
	    u1.put("Email", "avenor.thornveil01@yopmail.com");

	    TreeMap<String, String> u2 = new TreeMap<>();
	    u2.put("First Name", "Elviora");
	    u2.put("Middle Name", "Maelis");
	    u2.put("Last Name", "Quenridge");
	    u2.put("Phone Number (Primary)", "9867123402");
	    u2.put("Phone Number (Secondary)", "3579128402");
	    u2.put("Email", "elviora.quenridge02@yopmail.com");

	    TreeMap<String, String> u3 = new TreeMap<>();
	    u3.put("First Name", "Tavryn");
	    u3.put("Middle Name", "Iver");
	    u3.put("Last Name", "Rookmere");
	    u3.put("Phone Number (Primary)", "9867123403");
	    u3.put("Phone Number (Secondary)", "3579128403");
	    u3.put("Email", "tavryn.rookmere03@yopmail.com");

	    TreeMap<String, String> u4 = new TreeMap<>();
	    u4.put("First Name", "Brynola");
	    u4.put("Middle Name", "Sage");
	    u4.put("Last Name", "Kerrithorne");
	    u4.put("Phone Number (Primary)", "9867123404");
	    u4.put("Phone Number (Secondary)", "3579128404");
	    u4.put("Email", "brynola.kerrithorne04@yopmail.com");

	    TreeMap<String, String> u5 = new TreeMap<>();
	    u5.put("First Name", "Nayorin");
	    u5.put("Middle Name", "Reina");
	    u5.put("Last Name", "Stoneweld");
	    u5.put("Phone Number (Primary)", "9867123405");
	    u5.put("Phone Number (Secondary)", "3579128405");
	    u5.put("Email", "nayorin.stoneweld05@yopmail.com");

	    TreeMap<String, String> u6 = new TreeMap<>();
	    u6.put("First Name", "Ishven");
	    u6.put("Middle Name", "Devran");
	    u6.put("Last Name", "Moorwyn");
	    u6.put("Phone Number (Primary)", "9867123406");
	    u6.put("Phone Number (Secondary)", "3579128406");
	    u6.put("Email", "ishven.moorwyn06@yopmail.com");

	    TreeMap<String, String> u7 = new TreeMap<>();
	    u7.put("First Name", "Sorayna");
	    u7.put("Middle Name", "Noira");
	    u7.put("Last Name", "Brindlehart");
	    u7.put("Phone Number (Primary)", "9867123407");
	    u7.put("Phone Number (Secondary)", "3579128407");
	    u7.put("Email", "sorayna.brindlehart07@yopmail.com");

	    TreeMap<String, String> u8 = new TreeMap<>();
	    u8.put("First Name", "Leocindra");
	    u8.put("Middle Name", "Rue");
	    u8.put("Last Name", "Ashfallow");
	    u8.put("Phone Number (Primary)", "9867123408");
	    u8.put("Phone Number (Secondary)", "3579128408");
	    u8.put("Email", "leocindra.ashfallow08@yopmail.com");

	    TreeMap<String, String> u9 = new TreeMap<>();
	    u9.put("First Name", "Kairen");
	    u9.put("Middle Name", "Omri");
	    u9.put("Last Name", "Velthorn");
	    u9.put("Phone Number (Primary)", "9867123409");
	    u9.put("Phone Number (Secondary)", "3579128409");
	    u9.put("Email", "kairen.velthorn09@yopmail.com");

	    TreeMap<String, String> u10 = new TreeMap<>();
	    u10.put("First Name", "Yariel");
	    u10.put("Middle Name", "Esmae");
	    u10.put("Last Name", "Crownhallow");
	    u10.put("Phone Number (Primary)", "9867123410");
	    u10.put("Phone Number (Secondary)", "3579128410");
	    u10.put("Email", "yariel.crownhallow10@yopmail.com");

	    TreeMap<String, String> u11 = new TreeMap<>();
	    u11.put("First Name", "Ronivar");
	    u11.put("Middle Name", "Keir");
	    u11.put("Last Name", "Lindenmark");
	    u11.put("Phone Number (Primary)", "9867123411");
	    u11.put("Phone Number (Secondary)", "3579128411");
	    u11.put("Email", "ronivar.lindenmark11@yopmail.com");

	    TreeMap<String, String> u12 = new TreeMap<>();
	    u12.put("First Name", "Aurelian");
	    u12.put("Middle Name", "Paz");
	    u12.put("Last Name", "Merriswold");
	    u12.put("Phone Number (Primary)", "9867123412");
	    u12.put("Phone Number (Secondary)", "3579128412");
	    u12.put("Email", "aurelian.merriswold12@yopmail.com");

	    TreeMap<String, String> u13 = new TreeMap<>();
	    u13.put("First Name", "Saskiora");
	    u13.put("Middle Name", "Livra");
	    u13.put("Last Name", "Vintermere");
	    u13.put("Phone Number (Primary)", "9867123413");
	    u13.put("Phone Number (Secondary)", "3579128413");
	    u13.put("Email", "saskiora.vintermere13@yopmail.com");

	    TreeMap<String, String> u14 = new TreeMap<>();
	    u14.put("First Name", "Naviren");
	    u14.put("Middle Name", "Ryo");
	    u14.put("Last Name", "Hearthwyn");
	    u14.put("Phone Number (Primary)", "9867123414");
	    u14.put("Phone Number (Secondary)", "3579128414");
	    u14.put("Email", "naviren.hearthwyn14@yopmail.com");

	    TreeMap<String, String> u15 = new TreeMap<>();
	    u15.put("First Name", "Meador");
	    u15.put("Middle Name", "Skye");
	    u15.put("Last Name", "Glenvarn");
	    u15.put("Phone Number (Primary)", "9867123415");
	    u15.put("Phone Number (Secondary)", "3579128415");
	    u15.put("Email", "meador.glenvarn15@yopmail.com");

	    TreeMap<String, String> u16 = new TreeMap<>();
	    u16.put("First Name", "Zubairen");
	    u16.put("Middle Name", "Irfan");
	    u16.put("Last Name", "Crestvale");
	    u16.put("Phone Number (Primary)", "9867123416");
	    u16.put("Phone Number (Secondary)", "3579128416");
	    u16.put("Email", "zubairen.crestvale16@yopmail.com");

	    TreeMap<String, String> u17 = new TreeMap<>();
	    u17.put("First Name", "Elowynne");
	    u17.put("Middle Name", "Fayen");
	    u17.put("Last Name", "Rookspire");
	    u17.put("Phone Number (Primary)", "9867123417");
	    u17.put("Phone Number (Secondary)", "3579128417");
	    u17.put("Email", "elowynne.rookspire17@yopmail.com");

	    TreeMap<String, String> u18 = new TreeMap<>();
	    u18.put("First Name", "Kezaria");
	    u18.put("Middle Name", "Nell");
	    u18.put("Last Name", "Briarhold");
	    u18.put("Phone Number (Primary)", "9867123418");
	    u18.put("Phone Number (Secondary)", "3579128418");
	    u18.put("Email", "kezaria.briarhold18@yopmail.com");

	    TreeMap<String, String> u19 = new TreeMap<>();
	    u19.put("First Name", "Tenzaro");
	    u19.put("Middle Name", "Pema");
	    u19.put("Last Name", "Rivenshore");
	    u19.put("Phone Number (Primary)", "9867123419");
	    u19.put("Phone Number (Secondary)", "3579128419");
	    u19.put("Email", "tenzaro.rivenshore19@yopmail.com");

	    TreeMap<String, String> u20 = new TreeMap<>();
	    u20.put("First Name", "Marcellan");
	    u20.put("Middle Name", "Jude");
	    u20.put("Last Name", "Wrenmoor");
	    u20.put("Phone Number (Primary)", "9867123420");
	    u20.put("Phone Number (Secondary)", "3579128420");
	    u20.put("Email", "marcellan.wrenmoor20@yopmail.com");

	    return new Object[][]{
	        {u1},{u2},{u3},{u4},{u5},
	        {u6},{u7},{u8},{u9},{u10},
	        {u11},{u12},{u13},{u14},{u15},
	        {u16},{u17},{u18},{u19},{u20} 
	    };
	}

	


}
