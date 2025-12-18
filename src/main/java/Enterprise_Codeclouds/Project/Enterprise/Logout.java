package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import Locaters.Login_Locaters;
import Locaters.Logout_locaters;

public class Logout extends Login{
	
	
	
	public void logout() throws IOException, InterruptedException{
		
		
		Logout_locaters lg = new Logout_locaters(d);
		Login_Locaters lgin = new Login_Locaters(d);
		
		try{
			
			lgin.login_confirmation();
			
			
		}catch(Exception kk){
			
			login(d);
			
			
		}
		
		
		
		
	}

}
