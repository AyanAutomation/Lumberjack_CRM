package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		Group_feild.click();
	    Thread.sleep(800);
	    dropdown_list_option_fetcher(Group_name);
		WebElement Add_Law_Frim_Button=pt.form_buttons().get(0);
		rp.Scroll_to_element(Add_Law_Frim_Button);
		Add_Law_Frim_Button.click();
		Thread.sleep(800);	
		WebElement Toast= lg.toast();
		String toast= Toast.getText().trim();
		Login_negative_testcases.Toast_printer(toast);
		}
	    
	
	
	public void dropdown_list_option_fetcher(String name) throws InterruptedException{
		
		User_Module_Locaters ap = new User_Module_Locaters(d);
	     JavascriptExecutor js = (JavascriptExecutor)d;
	     Repeat rp=new Repeat(d);
			
	     String Group_name = name;
			
	     WebElement Dropdown_list= ap.Inner_dropdown_holder();
	     rp.movetoelement(Dropdown_list);
         Thread.sleep(800);	
	     js.executeScript("document.querySelector('.rc-virtual-list-holder').scrollBy(0,60)");
	     TreeSet<String> option_set= new TreeSet<String>();
	     OuterLoop:
	      for(int i=0;i<4;i++) {
	    	  option_set.clear(); 
	        List<WebElement> group_options = Dropdown_list.findElements(By.xpath(".//*[@aria-selected='false']"));
	     
       
	        for(WebElement opt:group_options){
	            String option_text = opt.getText().trim();
	            option_set.add(option_text);
	            if(option_text.equalsIgnoreCase(Group_name)){
	               
	                opt.click();
	                ap.item_selected();
	                break OuterLoop;}}
	        
	        if(option_set.contains(Group_name)) {
	        	 
	        	 break OuterLoop;
	        }else{
	        	
	        	option_set.clear();
	        	rp.movetoelement(Dropdown_list);
	            Thread.sleep(800);
	        	js.executeScript("document.querySelector('.rc-virtual-list-holder').scrollBy(0,160)");
	        	Thread.sleep(800);
	        	List<WebElement> new_group_options = Dropdown_list.findElements(By.xpath(".//*[@aria-selected='false']"));
	   	     
	            
		        for(WebElement opt:new_group_options){
		            String option_text = opt.getText().trim();
		            option_set.add(option_text);
		            if(option_text.equalsIgnoreCase(Group_name)){
		               
		                opt.click();
		                ap.item_selected();
		                break OuterLoop;}}
	        }
	        
	        
       }
	
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
	    u1.put("First Name", "Zevorin");
	    u1.put("Middle Name", "Alaric");
	    u1.put("Last Name", "Duskendale");
	    u1.put("Phone Number (Primary)", "9867345801");
	    u1.put("Phone Number (Secondary)", "3579681201");
	    u1.put("Email", "zevorin.duskendale01@yopmail.com");

	    TreeMap<String, String> u2 = new TreeMap<>();
	    u2.put("First Name", "Elyndra");
	    u2.put("Middle Name", "Mireya");
	    u2.put("Last Name", "Quillovar");
	    u2.put("Phone Number (Primary)", "9867345802");
	    u2.put("Phone Number (Secondary)", "3579681202");
	    u2.put("Email", "elyndra.quillovar02@yopmail.com");

	    TreeMap<String, String> u3 = new TreeMap<>();
	    u3.put("First Name", "Caedwyn");
	    u3.put("Middle Name", "Thane");
	    u3.put("Last Name", "Ravenshade");
	    u3.put("Phone Number (Primary)", "9867345803");
	    u3.put("Phone Number (Secondary)", "3579681203");
	    u3.put("Email", "caedwyn.ravenshade03@yopmail.com");

	    TreeMap<String, String> u4 = new TreeMap<>();
	    u4.put("First Name", "Briselle");
	    u4.put("Middle Name", "Odette");
	    u4.put("Last Name", "Kestrenwald");
	    u4.put("Phone Number (Primary)", "9867345804");
	    u4.put("Phone Number (Secondary)", "3579681204");
	    u4.put("Email", "briselle.kestrenwald04@yopmail.com");

	    TreeMap<String, String> u5 = new TreeMap<>();
	    u5.put("First Name", "Nivara");
	    u5.put("Middle Name", "Selene");
	    u5.put("Last Name", "Stoneglen");
	    u5.put("Phone Number (Primary)", "9867345805");
	    u5.put("Phone Number (Secondary)", "3579681205");
	    u5.put("Email", "nivara.stoneglen05@yopmail.com");

	    TreeMap<String, String> u6 = new TreeMap<>();
	    u6.put("First Name", "Iskren");
	    u6.put("Middle Name", "Devik");
	    u6.put("Last Name", "Moorquill");
	    u6.put("Phone Number (Primary)", "9867345806");
	    u6.put("Phone Number (Secondary)", "3579681206");
	    u6.put("Email", "iskren.moorquill06@yopmail.com");

	    TreeMap<String, String> u7 = new TreeMap<>();
	    u7.put("First Name", "Soravel");
	    u7.put("Middle Name", "Noemi");
	    u7.put("Last Name", "Brindleforge");
	    u7.put("Phone Number (Primary)", "9867345807");
	    u7.put("Phone Number (Secondary)", "3579681207");
	    u7.put("Email", "soravel.brindleforge07@yopmail.com");

	    TreeMap<String, String> u8 = new TreeMap<>();
	    u8.put("First Name", "Leondria");
	    u8.put("Middle Name", "Rueben");
	    u8.put("Last Name", "Ashwinter");
	    u8.put("Phone Number (Primary)", "9867345808");
	    u8.put("Phone Number (Secondary)", "3579681208");
	    u8.put("Email", "leondria.ashwinter08@yopmail.com");

	    TreeMap<String, String> u9 = new TreeMap<>();
	    u9.put("First Name", "Kairith");
	    u9.put("Middle Name", "Orrin");
	    u9.put("Last Name", "Velmorrow");
	    u9.put("Phone Number (Primary)", "9867345809");
	    u9.put("Phone Number (Secondary)", "3579681209");
	    u9.put("Email", "kairith.velmorrow09@yopmail.com");

	    TreeMap<String, String> u10 = new TreeMap<>();
	    u10.put("First Name", "Ysolen");
	    u10.put("Middle Name", "Esme");
	    u10.put("Last Name", "Crownfen");
	    u10.put("Phone Number (Primary)", "9867345810");
	    u10.put("Phone Number (Secondary)", "3579681210");
	    u10.put("Email", "ysolen.crownfen10@yopmail.com");

	    TreeMap<String, String> u11 = new TreeMap<>();
	    u11.put("First Name", "Rhovan");
	    u11.put("Middle Name", "Keiran");
	    u11.put("Last Name", "Lindenmere");
	    u11.put("Phone Number (Primary)", "9867345811");
	    u11.put("Phone Number (Secondary)", "3579681211");
	    u11.put("Email", "rhovan.lindenmere11@yopmail.com");

	    TreeMap<String, String> u12 = new TreeMap<>();
	    u12.put("First Name", "Aurevon");
	    u12.put("Middle Name", "Paxen");
	    u12.put("Last Name", "Merrisgate");
	    u12.put("Phone Number (Primary)", "9867345812");
	    u12.put("Phone Number (Secondary)", "3579681212");
	    u12.put("Email", "aurevon.merrisgate12@yopmail.com");

	    TreeMap<String, String> u13 = new TreeMap<>();
	    u13.put("First Name", "Saskirin");
	    u13.put("Middle Name", "Liora");
	    u13.put("Last Name", "Vinterbrook");
	    u13.put("Phone Number (Primary)", "9867345813");
	    u13.put("Phone Number (Secondary)", "3579681213");
	    u13.put("Email", "saskirin.vinterbrook13@yopmail.com");

	    TreeMap<String, String> u14 = new TreeMap<>();
	    u14.put("First Name", "Naveth");
	    u14.put("Middle Name", "Ryojin");
	    u14.put("Last Name", "Hearthcairn");
	    u14.put("Phone Number (Primary)", "9867345814");
	    u14.put("Phone Number (Secondary)", "3579681214");
	    u14.put("Email", "naveth.hearthcairn14@yopmail.com");

	    TreeMap<String, String> u15 = new TreeMap<>();
	    u15.put("First Name", "Meadorin");
	    u15.put("Middle Name", "Skylah");
	    u15.put("Last Name", "Glenward");
	    u15.put("Phone Number (Primary)", "9867345815");
	    u15.put("Phone Number (Secondary)", "3579681215");
	    u15.put("Email", "meadorin.glenward15@yopmail.com");

	    TreeMap<String, String> u16 = new TreeMap<>();
	    u16.put("First Name", "Zubaryn");
	    u16.put("Middle Name", "Irfel");
	    u16.put("Last Name", "Cresthollow");
	    u16.put("Phone Number (Primary)", "9867345816");
	    u16.put("Phone Number (Secondary)", "3579681216");
	    u16.put("Email", "zubaryn.cresthollow16@yopmail.com");

	    TreeMap<String, String> u17 = new TreeMap<>();
	    u17.put("First Name", "Elowira");
	    u17.put("Middle Name", "Faylen");
	    u17.put("Last Name", "Rookhaven");
	    u17.put("Phone Number (Primary)", "9867345817");
	    u17.put("Phone Number (Secondary)", "3579681217");
	    u17.put("Email", "elowira.rookhaven17@yopmail.com");

	    TreeMap<String, String> u18 = new TreeMap<>();
	    u18.put("First Name", "Kezryn");
	    u18.put("Middle Name", "Nellis");
	    u18.put("Last Name", "Briarcrest");
	    u18.put("Phone Number (Primary)", "9867345818");
	    u18.put("Phone Number (Secondary)", "3579681218");
	    u18.put("Email", "kezryn.briarcrest18@yopmail.com");

	    TreeMap<String, String> u19 = new TreeMap<>();
	    u19.put("First Name", "Tenzaril");
	    u19.put("Middle Name", "Pemra");
	    u19.put("Last Name", "Rivenshield");
	    u19.put("Phone Number (Primary)", "9867345819");
	    u19.put("Phone Number (Secondary)", "3579681219");
	    u19.put("Email", "tenzaril.rivenshield19@yopmail.com");

	    TreeMap<String, String> u20 = new TreeMap<>();
	    u20.put("First Name", "Marcelin");
	    u20.put("Middle Name", "Judren");
	    u20.put("Last Name", "Wrenholt");
	    u20.put("Phone Number (Primary)", "9867345820");
	    u20.put("Phone Number (Secondary)", "3579681220");
	    u20.put("Email", "marcelin.wrenholt20@yopmail.com");

	    return new Object[][]{
	    /*    {u1},{u2},{u3},{u4},{u5},
	        {u6},*/{u7},/*{u8},{u9},*/{u10},/*
	        {u11},{u12},{u13},{u14},{u15}, 
	        {u16},{u17},{u18},{u19},{u20} */
	    };
	}

	


}
