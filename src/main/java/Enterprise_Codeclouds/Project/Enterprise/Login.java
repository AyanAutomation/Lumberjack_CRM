package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;


@Listeners(Listerners.Report_Listen.class)
public class Login extends Base{
	
	
    @Test
	public void login() throws IOException, InterruptedException{
		
	Login_Locaters lg = new Login_Locaters(d);	
	Data_Reader f = new Data_Reader();
	Login_negative_testcases ln = new Login_negative_testcases();
		
	d.get(Target_url);
	lg.id_field().sendKeys(f.Data_Fetcher("Login_id"));	
	lg.password_field().sendKeys(f.Data_Fetcher("Pass"));	
	lg.password_eye_button().click();
	lg.buttons().get(1).click();
	Thread.sleep(500);
	String toast_message = lg.toast().getText();
	ln.Toast_printer(toast_message);
	lg.login_confirmation();	
	}

}
