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
	
	
	@Test(dataProvider="UserData")
	public void user_add(TreeMap<String, String> data) throws IOException, InterruptedException{
		
		
		User_Module_Locaters p = new User_Module_Locaters(d);
		Plaintiff_Locaters pt=new Plaintiff_Locaters(d);
		Application_Locaters ap = new Application_Locaters(d);
		Repeat rp=new Repeat(d);
		Login_Locaters lg=new Login_Locaters(d);
		
		String user_name = data.get("First Name");
		String Group_name = data.get("Groups");
		
		header_dropdown_option_selector("My Preferences");
		p.landed_in_user_module();
		rp.Scroll_to_element(pt.form());
		List<WebElement> input_feilds= pt.inputs();
		input_feilds.get(0).sendKeys(user_name);;
	    input_feilds.get(1).sendKeys(data.get("Middle Name"));
		input_feilds.get(2).sendKeys(data.get("Last Name"));
		input_feilds.get(3).sendKeys(data.get("Phone Number (Primary)"));	
		input_feilds.get(4).sendKeys(data.get("Phone Number (Secondary)"));
		input_feilds.get(5).sendKeys(data.get("Email"));
		input_feilds.get(6).click();	
		ap.plaintiff_dropdown_list();
		List<WebElement> group_options = ap.Plaintiff_options();
		for(WebElement opt:group_options){
			if(opt.getText().trim().contains(Group_name)){
				opt.click();}}
		WebElement Add_Law_Frim_Button=pt.form_buttons().get(0);
		rp.Scroll_to_element(Add_Law_Frim_Button);
		Add_Law_Frim_Button.click();
		Thread.sleep(800);	
		String taost= lg.toast().getText().trim();
		Login_negative_testcases.Toast_printer(taost);}
	    
	
	
	
	
	@DataProvider
	public Object[][] UserData() {


	    TreeMap<String, String> u1 = new TreeMap<>();
	    u1.put("First Name", "Anvay");
	    u1.put("Middle Name", "Kiron");
	    u1.put("Last Name", "Halderwyn");
	    u1.put("Phone Number (Primary)", "9714387051");
	    u1.put("Phone Number (Secondary)", "4586139041");
	    u1.put("Email", "anvay.halderwyn7051@mailto.plus");
	    u1.put("Groups", "Super Admin");

	    TreeMap<String, String> u2 = new TreeMap<>();
	    u2.put("First Name", "Eulalia");
	    u2.put("Middle Name", "Maren");
	    u2.put("Last Name", "Quistrel");
	    u2.put("Phone Number (Primary)", "6238051742");
	    u2.put("Phone Number (Secondary)", "5206948832");
	    u2.put("Email", "eulalia.quistrel1742@mailto.plus");
	    u2.put("Groups", "New Group");

	    TreeMap<String, String> u3 = new TreeMap<>();
	    u3.put("First Name", "Tamsin");
	    u3.put("Middle Name", "Ivo");
	    u3.put("Last Name", "Ridgeley");
	    u3.put("Phone Number (Primary)", "3157724603");
	    u3.put("Phone Number (Secondary)", "5859013373");
	    u3.put("Email", "tamsin.ridgeley4603@mailto.plus");
	    u3.put("Groups", "Test Group");

	    TreeMap<String, String> u4 = new TreeMap<>();
	    u4.put("First Name", "Bodhi");
	    u4.put("Middle Name", "Sage");
	    u4.put("Last Name", "Kerrivane");
	    u4.put("Phone Number (Primary)", "9186402914");
	    u4.put("Phone Number (Secondary)", "5398846204");
	    u4.put("Email", "bodhi.kerrivane2914@mailto.plus");
	    u4.put("Groups", "Submodule test group");

	    TreeMap<String, String> u5 = new TreeMap<>();
	    u5.put("First Name", "Nayeli");
	    u5.put("Middle Name", "Reina");
	    u5.put("Last Name", "Stonevoss");
	    u5.put("Phone Number (Primary)", "4025178395");
	    u5.put("Phone Number (Secondary)", "5317781465");
	    u5.put("Email", "nayeli.stonevoss8395@mailto.plus");
	    u5.put("Groups", "New Group,Test Group");

	    TreeMap<String, String> u6 = new TreeMap<>();
	    u6.put("First Name", "Ishaan");
	    u6.put("Middle Name", "Dev");
	    u6.put("Last Name", "Moorfield");
	    u6.put("Phone Number (Primary)", "7079365526");
	    u6.put("Phone Number (Secondary)", "9166042196");
	    u6.put("Email", "ishaan.moorfield5526@mailto.plus");
	    u6.put("Groups", "Test Group,Submodule test group");

	    TreeMap<String, String> u7 = new TreeMap<>();
	    u7.put("First Name", "Soraya");
	    u7.put("Middle Name", "Noor");
	    u7.put("Last Name", "Brindleham");
	    u7.put("Phone Number (Primary)", "9194831077");
	    u7.put("Phone Number (Secondary)", "2527609447");
	    u7.put("Email", "soraya.brindleham1077@mailto.plus");
	    u7.put("Groups", "Super Admin,New Group");

	    TreeMap<String, String> u8 = new TreeMap<>();
	    u8.put("First Name", "Leocadia");
	    u8.put("Middle Name", "Rue");
	    u8.put("Last Name", "Ashbriar");
	    u8.put("Phone Number (Primary)", "5126749838");
	    u8.put("Phone Number (Secondary)", "7375801168");
	    u8.put("Email", "leocadia.ashbriar9838@mailto.plus");
	    u8.put("Groups", "New Group,Submodule test group");

	    TreeMap<String, String> u9 = new TreeMap<>();
	    u9.put("First Name", "Kairav");
	    u9.put("Middle Name", "Omri");
	    u9.put("Last Name", "Velmont");
	    u9.put("Phone Number (Primary)", "6469052289");
	    u9.put("Phone Number (Secondary)", "3327416609");
	    u9.put("Email", "kairav.velmont2289@mailto.plus");
	    u9.put("Groups", "Test Group,Super Admin");

	    TreeMap<String, String> u10 = new TreeMap<>();
	    u10.put("First Name", "Yara");
	    u10.put("Middle Name", "Esme");
	    u10.put("Last Name", "Crownhill");
	    u10.put("Phone Number (Primary)", "2168394750");
	    u10.put("Phone Number (Secondary)", "4407821190");
	    u10.put("Email", "yara.crownhill4750@mailto.plus");
	    u10.put("Groups", "Submodule test group,Super Admin");

	    TreeMap<String, String> u11 = new TreeMap<>();
	    u11.put("First Name", "Ronan");
	    u11.put("Middle Name", "Keir");
	    u11.put("Last Name", "Lindenrow");
	    u11.put("Phone Number (Primary)", "4807169301");
	    u11.put("Phone Number (Secondary)", "6025397081");
	    u11.put("Email", "ronan.lindenrow9301@mailto.plus");
	    u11.put("Groups", "New Group,Test Group,Submodule test group");

	    TreeMap<String, String> u12 = new TreeMap<>();
	    u12.put("First Name", "Aurelio");
	    u12.put("Middle Name", "Paz");
	    u12.put("Last Name", "Merrivale");
	    u12.put("Phone Number (Primary)", "3036587422");
	    u12.put("Phone Number (Secondary)", "7203419052");
	    u12.put("Email", "aurelio.merrivale7422@mailto.plus");
	    u12.put("Groups", "New Group,Test Group,Submodule test group,Super Admin");

	    TreeMap<String, String> u13 = new TreeMap<>();
	    u13.put("First Name", "Saskia");
	    u13.put("Middle Name", "Liv");
	    u13.put("Last Name", "Vinteron");
	    u13.put("Phone Number (Primary)", "8014972633");
	    u13.put("Phone Number (Secondary)", "3856087713");
	    u13.put("Email", "saskia.vinteron2633@mailto.plus");
	    u13.put("Groups", "New Group");

	    TreeMap<String, String> u14 = new TreeMap<>();
	    u14.put("First Name", "Navin");
	    u14.put("Middle Name", "Ryo");
	    u14.put("Last Name", "Hearthlane");
	    u14.put("Phone Number (Primary)", "6158205144");
	    u14.put("Phone Number (Secondary)", "6294779014");
	    u14.put("Email", "navin.hearthlane5144@mailto.plus");
	    u14.put("Groups", "Test Group");

	    TreeMap<String, String> u15 = new TreeMap<>();
	    u15.put("First Name", "Meadow");
	    u15.put("Middle Name", "Skye");
	    u15.put("Last Name", "Glenwarren");
	    u15.put("Phone Number (Primary)", "2067339855");
	    u15.put("Phone Number (Secondary)", "4256017725");
	    u15.put("Email", "meadow.glenwarren9855@mailto.plus");
	    u15.put("Groups", "Submodule test group");

	    TreeMap<String, String> u16 = new TreeMap<>();
	    u16.put("First Name", "Zubair");
	    u16.put("Middle Name", "Irfan");
	    u16.put("Last Name", "Crestmore");
	    u16.put("Phone Number (Primary)", "9046821966");
	    u16.put("Phone Number (Secondary)", "3865194406");
	    u16.put("Email", "zubair.crestmore1966@mailto.plus");
	    u16.put("Groups", "New Group,Test Group");

	    TreeMap<String, String> u17 = new TreeMap<>();
	    u17.put("First Name", "Elowen");
	    u17.put("Middle Name", "Faye");
	    u17.put("Last Name", "Rookhaven");
	    u17.put("Phone Number (Primary)", "5057493077");
	    u17.put("Phone Number (Secondary)", "5756142387");
	    u17.put("Email", "elowen.rookhaven3077@mailto.plus");
	    u17.put("Groups", "Test Group,Super Admin");

	    TreeMap<String, String> u18 = new TreeMap<>();
	    u18.put("First Name", "Keziah");
	    u18.put("Middle Name", "Nell");
	    u18.put("Last Name", "Briarwick");
	    u18.put("Phone Number (Primary)", "3176084188");
	    u18.put("Phone Number (Secondary)", "4637712098");
	    u18.put("Email", "keziah.briarwick4188@mailto.plus");
	    u18.put("Groups", "Super Admin,New Group");

	    TreeMap<String, String> u19 = new TreeMap<>();
	    u19.put("First Name", "Tenzin");
	    u19.put("Middle Name", "Pema");
	    u19.put("Last Name", "Rivenshaw");
	    u19.put("Phone Number (Primary)", "9138275299");
	    u19.put("Phone Number (Secondary)", "8166947709");
	    u19.put("Email", "tenzin.rivenshaw5299@mailto.plus");
	    u19.put("Groups", "New Group,Submodule test group");

	    TreeMap<String, String> u20 = new TreeMap<>();
	    u20.put("First Name", "Marcellus");
	    u20.put("Middle Name", "Jude");
	    u20.put("Last Name", "Wrenford");
	    u20.put("Phone Number (Primary)", "7026157400");
	    u20.put("Phone Number (Secondary)", "7255031960");
	    u20.put("Email", "marcellus.wrenford7400@mailto.plus");
	    u20.put("Groups", "New Group,Test Group,Submodule test group");

	    return new Object[][]{/*
	      {u1},{u2},{u3},{u4},{u5},
	        {u6},{u7},{u8},{u9},{u10},
	        {u11},{u12},{u13},{u14},{u15},
	        {u16},{u17},{u18},{u19},*/{u20}
	    };
	}


}
