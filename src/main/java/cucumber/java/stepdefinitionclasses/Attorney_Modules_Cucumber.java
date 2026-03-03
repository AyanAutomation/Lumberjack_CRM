package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Enterprise_Codeclouds.Project.Enterprise.Attorney_module;
import Enterprise_Codeclouds.Project.Enterprise.SIde_Menu_Handler;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Attorney_Modules_Cucumber extends Attorney_module{
	
	
	public void driver_binder(){
		
		super.d= Base_cucumber.D.get();
		super.Target_url = Base_cucumber.Target_url;
	}

	@Given("Attorney_Add with data:")
	public void Attorney_Add_cucumber(DataTable table) throws IOException, InterruptedException {
	
		// =========================================================
		// 1) These 3 TreeMaps are the FINAL payloads we will send
		//    to the existing TestNG method: Attorney_Add(...)
		//
		//    Think of them as 3 separate "forms":
		//      - Attorney_data  -> Attorney person details
		//      - Law_Firm_Data  -> Law firm details
		//      - Staff_Data     -> Staff contact details
		// =========================================================
		TreeMap<String, String> Attorney_data = new TreeMap<String, String>();
		TreeMap<String, String> Law_Firm_Data = new TreeMap<String, String>();
		TreeMap<String, String> Staff_Data = new TreeMap<String, String>();


		// =========================================================
		// 2) Driver binder:
		//    In Cucumber, WebDriver is created inside Base_cucumber
		//    and stored in ThreadLocal.
		//
		//    Here we "inject" that driver into the TestNG parent class
		//    field `d`, so that the old TestNG methods can reuse it.
		//
		//    Without this, TestNG methods would see driver as null and fail.
		// =========================================================
		
			driver_binder();

			// =========================================================
			// 3) Read the DataTable from the feature file:
			//    The feature provides data like:
			//      | Key                 | Value |
			//      | Attorney.First Name  | ...   |
			//      | LawFirm.Name         | ...   |
			//
			//    `table.asMap(...)` converts that Key/Value table into a Java map.
			//    We store it in `feature_data` because it contains ALL values
			//    coming from the feature file.
			// =========================================================
			TreeMap<String, String> feature_data = new TreeMap<String, String>(table.asMap(String.class, String.class));
			// =========================================================
			// 4) Remove the table column header key:
			//    Because your table has "Key" as the first column name,
			//    sometimes it can appear as an entry in the map.
			//    Removing it keeps the data clean.
			// =========================================================
			feature_data.remove("Key"); 

			// PART-E: Fill Attorney_data (convert feature keys -> TestNG keys)
			// =========================================================
			// IMPORTANT:
			// - Feature uses keys like: "Attorney.First Name"
			// - Your TestNG method expects keys like: "First Name"
			//
			// So we translate:
			//   feature_data["Attorney.First Name"]  -> Attorney_data["First Name"]
			// =========================================================
			Attorney_data.put("First Name", feature_data.get("Attorney.First Name"));
			Attorney_data.put("Middle Name", feature_data.get("Attorney.Middle Name"));
			Attorney_data.put("Last Name", feature_data.get("Attorney.Last Name"));
			Attorney_data.put("Name Suffix", feature_data.get("Attorney.Name Suffix"));
			Attorney_data.put("Phone", feature_data.get("Attorney.Phone"));
			Attorney_data.put("Office phone", feature_data.get("Attorney.Office phone"));
			Attorney_data.put("Email", feature_data.get("Attorney.Email"));

			// =========================================================
			// PART-F: Fill Law_Firm_Data
			// =========================================================
			// In Attorney_Add TestNG flow, Law Firm Name is most important
			// because UI selection happens using name.
			//
			// We also store ID and Phone from feature:
			// - Even if current TestNG code doesn't use them,
			//   keeping them can help future validations or logging.
			// =========================================================
			Law_Firm_Data.put("Name", feature_data.get("LawFirm.Name"));
			Law_Firm_Data.put("ID", feature_data.get("LawFirm.ID"));
			Law_Firm_Data.put("Phone", feature_data.get("LawFirm.Phone"));

			// =========================================================
			// PART-G: Fill Staff_Data
			// =========================================================
			// Same translation concept:
			//   feature_data["Staff.Staff First Name"] -> Staff_Data["Staff First Name"]
			//
			// These keys are used inside TestNG helper method staff_add(...)
			// =========================================================
			Staff_Data.put("Staff First Name", feature_data.get("Staff.Staff First Name"));
			Staff_Data.put("Staff Middle Name", feature_data.get("Staff.Staff Middle Name"));
			Staff_Data.put("Staff Last Name", feature_data.get("Staff.Staff Last Name"));
			Staff_Data.put("Staff Name Suffix", feature_data.get("Staff.Staff Name Suffix"));
			Staff_Data.put("Staff Phone", feature_data.get("Staff.Staff Phone"));
			Staff_Data.put("Staff Office phone", feature_data.get("Staff.Staff Office phone"));
			Staff_Data.put("Staff Email", feature_data.get("Staff.Staff Email"));

			// =========================================================
			// PART-H: Call the existing TestNG method (REUSE)
			// =========================================================
			// This is the key idea of your framework:
			//
			// Instead of writing new Selenium automation in Cucumber,
			// we reuse the already-tested TestNG flow.
			//
			// What Attorney_Add(...) will do internally (in business words):
			// 1) Open the "Attorney" module screen
			// 2) Select the correct Law Firm
			// 3) Fill attorney details in the form
			// 4) Add staff details (popup/modal)
			// 5) Click "Add Attorney"
			// 6) Read toast message and log PASS/FAIL into Extent Report
			// =========================================================
			Attorney_Add(Attorney_data, Law_Firm_Data, Staff_Data);

			// End of step ✅
	}
	
}
