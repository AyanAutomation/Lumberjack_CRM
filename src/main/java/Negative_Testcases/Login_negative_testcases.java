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
	
	
	@Test(dataProvider="loLogin_negative_testcasesgin_datas")
	public void login_validation(TreeMap<String,String> val) throws InterruptedException, IOException{
		
		Login_Locaters l = new Login_Locaters(d);
		Repeat rp = new Repeat(d);

		d.get(Target_url);
	    l.buttons().get(1).click();
		Thread.sleep(800);
		inline_error_printer();
		l.id_field().sendKeys(val.get("id"));
		l.buttons().get(1).click();
		Thread.sleep(800);
		inline_error_printer(); 
	    rp.Feild_clear(l.id_field());
		l.password_field().sendKeys(val.get("pass"));
		l.buttons().get(1).click();
		Thread.sleep(1800);
		inline_error_printer(); 
		rp.Feild_clear(l.password_field());
		l.id_field().sendKeys(val.get("id"));
		l.password_field().sendKeys(val.get("pass"));
		l.buttons().get(1).click();
		Thread.sleep(800);
		String toast_message = l.toast().getText();
		Toast_printer(toast_message);
		if(toast_message.contains("Login successful!")){
			
			l.login_confirmation();}
		
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
		for(WebElement error:errors) {
		Report_Listen.log_print_in_report().log(Status.INFO, error.getText());
		System.out.println(error.getText());}
		errors.clear();}
	
	   public void Toast_printer(String Toast){
		
		   Report_Listen.log_print_in_report().log(Status.INFO, Toast);
			System.out.println(Toast);}
	   
	   
	
	
	
	

}
