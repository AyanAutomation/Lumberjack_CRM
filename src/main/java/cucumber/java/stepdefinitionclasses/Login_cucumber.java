package cucumber.java.stepdefinitionclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Enterprise_Codeclouds.Project.Enterprise.Data_Reader;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;
import io.cucumber.java.en.Given;

public class Login_cucumber {

	
	@Given("Postive Login Testcase") 
	public static void login_through_cucumber(WebDriver driver) throws InterruptedException, IOException{
		
		 WebDriver d = driver==null ? Base_cucumber.d: driver ;
        String Target_url = Base_cucumber.Target_url;
		
        Login_Locaters lg = new Login_Locaters(d);
        Data_Reader f = new Data_Reader();
        Repeat rp = new Repeat(d);

        d.manage().deleteAllCookies();
        d.get(Target_url);

        lg.id_field().sendKeys(f.Data_Fetcher("Login_id"));
        lg.password_field().sendKeys(f.Data_Fetcher("Pass"));
        lg.password_eye_button().click();

        lg.buttons().get(1).click();
        Thread.sleep(500);

        WebElement toast = lg.toast();
        String toast_message = toast.getText();

        Login_negative_testcases.Toast_printer(toast_message, d);

        rp.wait_for_invisibility(toast);
        lg.login_confirmation();
		
		
	}
}
