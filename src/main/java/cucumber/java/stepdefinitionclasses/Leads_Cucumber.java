package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import Enterprise_Codeclouds.Project.Enterprise.Leads;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Leads_Cucumber extends Leads{
	
	
	public void driver_binder() {

		super.d = Base_cucumber.D.get();
		super.Target_url = Base_cucumber.Target_url;}
	
	@Given("Frontend_ApplyNow with data:")
	public void Frontend_ApplyNow_with_data(DataTable table) throws IOException, InterruptedException {
		
		
		driver_binder();
		TreeMap<String, String> form_data = new TreeMap<String, String>(table.asMap(String.class, String.class));
		form_data.remove("Key");

		frontend_form_filler(form_data);}
    
	 
	@Given("Lead_List_Data_Reader_and_clicker")
	public void Lead_List_Data_Reader_and_clicker_cucumber() throws IOException, InterruptedException {

		driver_binder();

		// ✅ reuse exact TestNG method
		// NOTE:
		// This will always use the hardcoded lead:
		// "Richardson charles"
		// because that value is fixed inside the TestNG method itself.
		Lead_List_Data_Reader_and_clicker();
	}

}
