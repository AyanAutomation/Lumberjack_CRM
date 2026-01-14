package Enterprise_Codeclouds.Project.Enterprise;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Locaters.Roles_Permission_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Access_Permissions extends Case_Appplications{

	
	
	
    @Test(dataProvider="roleData")
	public void Role_Add(TreeMap<String, String> data) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Roles_Permission_Locaters pp = new Roles_Permission_Locaters(d);
		Repeat rp=new Repeat(d);
		Plaintiff_Locaters p=new Plaintiff_Locaters(d);
		Login_Locaters lg = new Login_Locaters(d);
		
		sd.Side_menu_option_clicker("Access Control", d,"Roles");
		pp.Landed_in_role_page();
		rp.Scroll_to_element(p.form());
		Thread.sleep(800);	
		List<WebElement> input_feilds=p.inputs();
		input_feilds.get(0).sendKeys(data.get("Role Name"));
		pp.Submit_button().click();
		try {WebElement Toast = lg.toast();
		Login_negative_testcases.Toast_printer(Toast.getText().trim());}
	    catch(Exception Toast_Not_Found){
		System.out.println("Toast Not found after Role Add");
		System.out.println();}}
    

    @Test(dataProvider="roleData")
	public void Group_Add(TreeMap<String, String> data) throws IOException, InterruptedException, AWTException{
    	
    	SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Roles_Permission_Locaters pp = new Roles_Permission_Locaters(d);
		Repeat rp=new Repeat(d);
		Application_Locaters p=new Application_Locaters(d);
		Plaintiff_Locaters pt=new Plaintiff_Locaters(d);
		Login_Locaters lg = new Login_Locaters(d);
		Robot r = new Robot();
		
		String Role_name = data.get("Role Name");
		
		sd.Side_menu_option_clicker("Access Control", d,"Groups");
		pp.Landed_in_group_page();
		rp.Scroll_to_element(pt.form());
		Thread.sleep(800);	
		pp.Group_name_feild().sendKeys(data.get("Group Name"));  
		pp.Role_dropdown_field().click();
		Thread.sleep(800);
		WebElement dropdown= p.plaintiff_dropdown_list();
		Thread.sleep(800);
		pp.Role_Field().sendKeys(Role_name);
		Thread.sleep(800);
		List<WebElement> role_options = pp.Role_dropdown_options();
    	for(WebElement opt:role_options){
    		
    		String opt_text= opt.getText().trim();
    		System.out.println(opt_text);
    		if(opt_text.equalsIgnoreCase(Role_name)){
    			opt.click();
    			break;}} 
    	pp.Submit_button().click();
		try {WebElement Toast = lg.toast();
		Login_negative_testcases.Toast_printer(Toast.getText().trim());}
	    catch(Exception Toast_Not_Found){
		System.out.println("Toast Not found after Group Add");
		System.out.println();} }
    
    
    
    @DataProvider
    public Object[][] roleData() {

    	TreeMap<String, String> rg1 = new TreeMap<>();
        rg1.put("Role Name", "User Directory Viewer");
        rg1.put("Group Name", "User Directory Team");

        TreeMap<String, String> rg2 = new TreeMap<>();
        rg2.put("Role Name", "Underwriting Review and Verification");
        rg2.put("Group Name", "Underwriting Review Team");

        TreeMap<String, String> rg3 = new TreeMap<>();
        rg3.put("Role Name", "Liens Management Operator");
        rg3.put("Group Name", "Liens Operations Team");

        TreeMap<String, String> rg4 = new TreeMap<>();
        rg4.put("Role Name", "Case Contacts Coordinator");
        rg4.put("Group Name", "Case Contacts Team");

        TreeMap<String, String> rg5 = new TreeMap<>();
        rg5.put("Role Name", "Plaintiff Intake Specialist");
        rg5.put("Group Name", "Plaintiff Intake Team");

        TreeMap<String, String> rg6 = new TreeMap<>();
        rg6.put("Role Name", "Law Firm Records Manager");
        rg6.put("Group Name", "Law Firm Records Team");

        TreeMap<String, String> rg7 = new TreeMap<>();
        rg7.put("Role Name", "Document Library Reviewer");
        rg7.put("Group Name", "Document Review Team");

        TreeMap<String, String> rg8 = new TreeMap<>();
        rg8.put("Role Name", "Email Verification Operator");
        rg8.put("Group Name", "Email Verification Team");

        TreeMap<String, String> rg9 = new TreeMap<>();
        rg9.put("Role Name", "Message Center Viewer");
        rg9.put("Group Name", "Message Monitoring Team");

        TreeMap<String, String> rg10 = new TreeMap<>();
        rg10.put("Role Name", "Access Control Role Administrator");
        rg10.put("Group Name", "Access Control Team");

        return new Object[][]{
            {rg1}, {rg2}, {rg3}, {rg4}, {rg5},
            {rg6}, {rg7}, {rg8}, {rg9}, {rg10} 
        };
    }


}
