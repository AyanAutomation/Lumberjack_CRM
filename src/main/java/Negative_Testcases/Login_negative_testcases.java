package Negative_Testcases;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Base;
import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Enterprise_Codeclouds.Project.Enterprise.Login;
import Listerners.Report_Listen;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;
@Listeners(Listerners.Report_Listen.class)
public class Login_negative_testcases extends Base{
	
	
	@Test(dataProvider="login_datas")
	public void login_validation(TreeMap<String,String> val) throws InterruptedException, IOException{
		
		Login_Locaters l = new Login_Locaters(d);
		Repeat rp = new Repeat(d);

		d.get(Target_url);
		l.buttons().get(1).click();
		Thread.sleep(500);

		// === SCENARIO 1 ===
		Report_Listen.log_print_in_report().log(Status.INFO,"**🔹 Scenario 1: User attempts login without entering Email or Password**");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📘 Description →** The user clicks the Login button without providing any credentials. The purpose is to verify that the system prevents login and highlights both fields as mandatory.");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📥 Input →** Email: [BLANK], Password: [BLANK]");
		Report_Listen.log_print_in_report().log(Status.INFO,"**✅ Expected →** The system should show inline validation errors for both fields: 'Email is required' and 'Password is required'.");
		List<WebElement> errors1 = l.inline_errors();
		for(WebElement error:errors1){Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Error Message: "+error.getText());}
		errors1.clear();

		// === SCENARIO 2 ===
		l.id_field().sendKeys(val.get("id"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**🔹 Scenario 2: User enters only Email and attempts login (Password left blank)**");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📘 Description →** The user provides a valid Email but leaves the Password field empty. The test checks whether the system identifies the missing password and prevents login.");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📥 Input →** Email: " + val.get("id") + ", Password: [BLANK]");
		Report_Listen.log_print_in_report().log(Status.INFO,"**✅ Expected →** The system should display a validation message indicating the Password field is required.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		List<WebElement> errors2 = l.inline_errors();
		for(WebElement error:errors2){Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Error Message: "+error.getText());}
		errors2.clear();
		rp.Feild_clear(l.id_field());

		// === SCENARIO 3 ===
		l.password_field().sendKeys(val.get("pass"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**🔹 Scenario 3: User enters Password but keeps Email field blank**");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📘 Description →** The user enters a Password but leaves the Email empty. This scenario validates that the system detects the missing Email and shows the appropriate validation message.");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📥 Input →** Email: [BLANK], Password: " + val.get("pass"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**✅ Expected →** The system should display a validation message indicating the Email field is required.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		List<WebElement> errors3 = l.inline_errors();
		for(WebElement error:errors3){Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Error Message: "+error.getText());}
		errors3.clear();
		rp.Feild_clear(l.password_field());

		// === SCENARIO 4 ===
		l.id_field().sendKeys(val.get("id"));
		l.password_field().sendKeys(val.get("pass"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**🔹 Scenario 4: User attempts login using invalid Email and Password**");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📘 Description →** The user enters invalid credentials that do not exist in the system. The purpose is to verify that the system rejects unauthorized login and shows a clear error notification.");
		Report_Listen.log_print_in_report().log(Status.INFO,"**📥 Input →** Email: " + val.get("id") + ", Password: " + val.get("pass"));
		Report_Listen.log_print_in_report().log(Status.INFO,"**✅ Expected →** A toast message should appear stating: 'Invalid Email or Password' or a similar rejection message.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		String toast = l.toast().getText();
		Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** 📢 Toast Message: " + toast);
		System.out.println(toast);
		if(toast.contains("Login successful!")){l.login_confirmation();}
		else{Report_Listen.log_print_in_report().log(Status.FAIL,"❌ Toast: Login failed. Invalid Email Or Password.");}

		Report_Listen.log_print_in_report().log(Status.INFO,"-------------------------------------------------------------------------");
		Report_Listen.log_print_in_report().log(Status.PASS,"✅ All negative login validations executed successfully for Email: "+val.get("id"));

		}
		
	
	

	@DataProvider
	public Object[][] login_datas() throws IOException{
		
		Data_Reader f = new Data_Reader();
		
		TreeMap<String,String> lg1 = new TreeMap<String,String>();
		lg1.put("id", f.Data_Fetcher("Login_id"));
		lg1.put("pass", "22355");
		TreeMap<String,String> lg2 = new TreeMap<String,String>();
		lg2.put("id", "aknnnb202@bm.com");
		lg2.put("pass", f.Data_Fetcher("Pass"));
		TreeMap<String,String> lg3 = new TreeMap<String,String>();
		lg3.put("id", "aknnnb202@bm.com");
		lg3.put("pass", "4455m235");

		
		return new Object[][] {{lg1},{lg2},{lg3}};
		}
	
	
	
	public void inline_error_printer(){
		
		Login_Locaters l = new Login_Locaters(d);
		
	    List<WebElement> errors = l.inline_errors();

	    if (errors.isEmpty()) {
	        Report_Listen.log_print_in_report().log(Status.WARNING, "⚠ No inline errors found");
	    } else {
	        for (WebElement error : errors) {
	            Report_Listen.log_print_in_report().log(Status.INFO, "❌ Error Message: " + error.getText());
	            System.out.println(error.getText());
	        }
	    }
	    errors.clear();}
	
	   public void Toast_printer(String Toast){
		
		   if (Toast.toLowerCase().contains("success")) {
		        Report_Listen.log_print_in_report().log(Status.PASS, "✅ Toast: " + Toast);
		    } else {
		        Report_Listen.log_print_in_report().log(Status.FAIL, "❌ Toast: " + Toast);
		    }
		    System.out.println(Toast);}
	   
	   
	
	
	
	

}
