package Cumcumber_Negative_Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Listerners.Report_Listen;
import Locaters.Login_Locaters;
import Repeatative_codes.Repeat;
import cucumber.java.stepdefinitionclasses.Base_cucumber;
import io.cucumber.java.en.Given;



public class Cucumber_Login_negative_testcases {

	
	@Given("^Logging in with username (.+) and password (.+)$")
	public void login_validation_cucumber(String user, String pass) throws IOException, InterruptedException {
		
		WebDriver d = Base_cucumber.d;
		String url = Base_cucumber.Target_url;
		
		Login_Locaters l = new Login_Locaters(d);
		Repeat rp = new Repeat(d);
		Data_Reader f = new Data_Reader();
	   
		String id = user.trim();
	    String password = pass.trim();

	    // resolve username if it's a key
	    if (id.equalsIgnoreCase("Login_id")) {
	        id = f.Data_Fetcher("Login_id");
	    }

	    // resolve password if it's a key
	    if (password.equalsIgnoreCase("Pass")) {
	        password = f.Data_Fetcher("Pass");
	    }
		
	    d.get(url);
		l.buttons().get(1).click();
		Thread.sleep(500);

		// === SCENARIO 1 ===
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹Scenario 1:</b> User attempts login without entering Email or Password**");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description →</b> The user clicks the Login button without providing any credentials. The purpose is to verify that the system prevents login and highlights both fields as mandatory.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input →</b>  <b>Email:</b>  [BLANK], <b>Password:</b> [BLANK]");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected →</b> The system should show inline validation errors for both fields: 'Email is required' and 'Password is required'.");
		List<WebElement> errors1 = l.inline_errors();
		for(WebElement error:errors1){Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →</b> ❌ Error Message: "+error.getText());}
		errors1.clear();

		// === SCENARIO 2 ===
		l.id_field().sendKeys(id);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario 2:</b> User enters only Email and attempts login (Password left blank)**");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description →</b> The user provides a valid Email but leaves the Password field empty. The test checks whether the system identifies the missing password and prevents login.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input →</b> <b>Email:</b> " + id + ", <b>Password:</b> [BLANK]");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected →</b> The system should display a validation message indicating the Password field is required.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		List<WebElement> errors2 = l.inline_errors();
		for(WebElement error:errors2){Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** ❌ Error Message: "+error.getText());}
		errors2.clear();
		rp.Feild_clear(l.id_field());

		// === SCENARIO 3 ===
		l.password_field().sendKeys(password);
		Report_Listen.log_print_in_report().log(Status.INFO,"*<b>🔹 Scenario 3:</b> User enters Password but keeps Email field blank**");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description →</b> The user enters a Password but leaves the Email empty. This scenario validates that the system detects the missing Email and shows the appropriate validation message.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input →</b> <b>Email:</b> [BLANK], <b>Password:</b> " +password);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected →</b> The system should display a validation message indicating the Email field is required.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		List<WebElement> errors3 = l.inline_errors();
		for(WebElement error:errors3){Report_Listen.log_print_in_report().log(Status.INFO,"<b>🟨 Actual →</b> ❌ Error Message: "+error.getText());}
		errors3.clear();
		rp.Feild_clear(l.password_field());

		// === SCENARIO 4 ===
		l.id_field().sendKeys(id);
		l.password_field().sendKeys(password);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>🔹 Scenario 4:</b> User attempts login using invalid Email and Password**");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📘 Description →</b>The user enters invalid credentials that do not exist in the system. The purpose is to verify that the system rejects unauthorized login and shows a clear error notification.");
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>📥 Input →</b> <b>Email:</b> " + id + ", <b>Password:</b> " + password);
		Report_Listen.log_print_in_report().log(Status.INFO,"<b>✅ Expected →</b> A toast message should appear stating: 'Invalid Email or Password' or a similar rejection message.");
		l.buttons().get(1).click();
		Thread.sleep(500);
		String toast = l.toast().getText();
		Report_Listen.log_print_in_report().log(Status.INFO,"**🟨 Actual →** 📢 Toast Message: " + toast);
		System.out.println(toast);
		if(toast.contains("Login successful!")){l.login_confirmation();}
		else{Report_Listen.log_print_in_report().log(Status.FAIL,"<b>❌ Toast:</b> Login failed. Invalid Email Or Password.");}

		Report_Listen.log_print_in_report().log(Status.INFO,"-------------------------------------------------------------------------");
		Report_Listen.log_print_in_report().log(Status.PASS,"<b>✅ All negative login validations executed successfully for Email:</b> "+id);

	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
	
	
	
	
}
