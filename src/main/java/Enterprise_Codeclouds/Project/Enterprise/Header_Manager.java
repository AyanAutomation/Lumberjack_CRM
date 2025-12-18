package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;

import Locaters.Header_locaters;

public class Header_Manager extends Login{
	
	
	public void header_buttons_clicker(int button_index) throws IOException, InterruptedException{
		
		Header_locaters p = new Header_locaters(d);
		
		
		login(d);
		p.Header_buttons().get(button_index).click();}
	
	
      public void header_search(String Keyword) throws IOException, InterruptedException{
		
		Header_locaters p = new Header_locaters(d);
		
		
		login(d);
		p.Header_search().sendKeys(Keyword);
		p.search_dropdown();}
	   

}
