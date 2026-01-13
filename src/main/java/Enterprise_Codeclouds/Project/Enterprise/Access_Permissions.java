package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		System.out.println("Toast Not found after saving Underwriting Notes");
		System.out.println();}
		
		
	}
    
    @DataProvider
    public Object[][] roleData() {

        TreeMap<String, String> r1 = new TreeMap<>();
        r1.put("Role Name", "User View and List");

        TreeMap<String, String> r2 = new TreeMap<>();
        r2.put("Role Name", "Case Underwriting View Verify and List");

        TreeMap<String, String> r3 = new TreeMap<>();
        r3.put("Role Name", "Case Liens Create Update View and List");

        TreeMap<String, String> r4 = new TreeMap<>();
        r4.put("Role Name", "Case Contacts Update View and List");

        TreeMap<String, String> r5 = new TreeMap<>();
        r5.put("Role Name", "Plaintiff Create View and List");

        TreeMap<String, String> r6 = new TreeMap<>();
        r6.put("Role Name", "Law Firm Create Update View and List");

        TreeMap<String, String> r7 = new TreeMap<>();
        r7.put("Role Name", "Documents View and List");

        TreeMap<String, String> r8 = new TreeMap<>();
        r8.put("Role Name", "Email View List and Verify");

        TreeMap<String, String> r9 = new TreeMap<>();
        r9.put("Role Name", "Messages View and List");

        TreeMap<String, String> r10 = new TreeMap<>();
        r10.put("Role Name", "Access Control Roles Create Update and List");

        return new Object[][]{
            {r1},{r2},{r3},{r4},{r5},
            {r6},{r7},{r8},{r9},{r10}
        };
    }


}
