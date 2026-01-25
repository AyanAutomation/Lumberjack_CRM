package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;


@Listeners(Listerners.Report_Listen.class)
public class Login extends Base{
	
	
   
	public void login(WebDriver d) throws IOException, InterruptedException{
		
	Login_Locaters lg = new Login_Locaters(d);	
	Data_Reader f = new Data_Reader();
	Repeat rp = new Repeat(d);
		
	d.manage().deleteAllCookies();
	d.get(Target_url);
	lg.id_field().sendKeys(f.Data_Fetcher("Login_id"));	
	lg.password_field().sendKeys(f.Data_Fetcher("Pass"));	
	lg.password_eye_button().click();
	//Report_Listen.log_print_in_report().log(Status.INFO, "Checking with valid Password and email");
	lg.buttons().get(1).click();
	Thread.sleep(500);
	WebElement Toast = lg.toast();
	String toast_message = Toast.getText();
	Login_negative_testcases.Toast_printer(toast_message);
	System.out.println();
	lg.Toast_close_button().click();
	rp.wait_for_invisibility(Toast);
	lg.login_confirmation();	
	}

}
