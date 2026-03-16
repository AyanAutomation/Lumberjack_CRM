package cucumber.java.stepdefinitionclasses;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import Enterprise_Codeclouds.Project.Enterprise.Attorney_module;
import Enterprise_Codeclouds.Project.Enterprise.Case_Appplications;
import Enterprise_Codeclouds.Project.Enterprise.SIde_Menu_Handler;
import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Login_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Cucumber_Case_Module_Testcases extends Case_Appplications {

	private void bindDriver() {
		super.d = Base_cucumber.D.get();
		super.Target_url = Base_cucumber.Target_url;
	}

	public void Add_New_Case_Form_Accessor(int s) throws IOException, InterruptedException {

		Application_Locaters p = new Application_Locaters(d);
		Header_functionality_manager hd = new Header_functionality_manager();

		int step = s;
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Click <b>Case Add</b> button from Header<br>"
				+ "<b>📘 Description:</b> User uses header Case Add button to directly open the New Case Add popup<br>"
				+ "<b>✅ Expected:</b> New Case popup should open");
		hd.header_buttons_clicker(s, d);
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🟨 Actual:</b> Header <b>Case Add</b> button clicked.");
		Report_Listen.log_print_in_report().log(Status.INFO, "<b>Step " + (step++)
				+ ":</b> Verify New Case popup is opened<br>"
				+ "<b>📘 Description:</b> System should display the case creation popup/form after header Case Add click<br>"
				+ "<b>✅ Expected:</b> New Case Add popup form should be visible and ready for input");
		p.Popup_add_form();
	}

	@Given("Add_case_cucumber with data:")
	public void Add_case_cucumber(DataTable table) throws IOException, InterruptedException {

		// ✅ bind cucumber ThreadLocal driver into parent "d" (Case_Appplications uses
		// "d")
		bindDriver();

		// ✅ One dataset map (Key/Value style from feature)
		TreeMap<String, String> ds = new TreeMap<>(table.asMap(String.class, String.class));
		ds.remove("Key"); // because your table header is | Key | Value |

		// ✅ Always overwrite AUTO dates
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String today = LocalDate.now().format(fmt);
		String expiry = LocalDate.now().plusYears(4).format(fmt);

		ds.put("Case.Payment Date", today);
		ds.put("Case.Agreement Date", today);
		ds.put("Case.Interest Start Date", today);
		ds.put("Case.Buyout Expiry Date", expiry);

		// ==========================================================
		// ✅ Map-1: Case_Data (EXACT keys expected by TestNG Add_case)
		// ==========================================================
		TreeMap<String, String> caseData = new TreeMap<>();

		caseData.put("Case #", ds.get("Case.Case #"));
		caseData.put("Case Type", ds.get("Case.Case Type"));
		caseData.put("State", ds.get("Case.State"));
		caseData.put("Date of Incident", ds.get("Case.Date of Incident"));
		caseData.put("Lead Source", ds.get("Case.Lead Source"));
		caseData.put("Requested Amount", ds.get("Case.Requested Amount"));
		caseData.put("Court Index Number", ds.get("Case.Court Index Number"));
		caseData.put("Summary", ds.get("Case.Summary"));

		// Optional but safe (your other flows/logs reference these)
		caseData.put("Risk Level", ds.get("Case.Risk Level"));
		caseData.put("Recommended Max Funding", ds.get("Case.Recommended Max Funding"));
		caseData.put("Application Status", ds.get("Case.Application Status"));
		caseData.put("Underwriting Notes", ds.get("Case.Underwriting Notes"));
		caseData.put("Underwriting Tag", ds.get("Case.Underwriting Tag"));

		// Contract/Funding numbers (these MUST exist because TestNG uses
		// Integer.parseInt on them)
		caseData.put("Buyout Funder Name", ds.get("Case.Buyout Funder Name"));
		caseData.put("Buyout Expiry Date", ds.get("Case.Buyout Expiry Date"));
		caseData.put("Buyout Amount", ds.get("Case.Buyout Amount"));
		caseData.put("Approved Amount", ds.get("Case.Approved Amount"));
		caseData.put("Document prep fee", ds.get("Case.Document prep fee"));
		caseData.put("Fund transfer fee", ds.get("Case.Fund transfer fee"));
		caseData.put("Rate of Return", ds.get("Case.Rate of Return"));

		// Dates used in contract screens
		caseData.put("Agreement Date", ds.get("Case.Agreement Date"));
		caseData.put("Interest Start Date", ds.get("Case.Interest Start Date"));
		caseData.put("Payment Date", ds.get("Case.Payment Date"));

		// Payment keys (only if your scenario table contains them)
		caseData.put("Payment Mode", ds.get("Case.Payment Mode"));
		caseData.put("Payment Type", ds.get("Case.Payment Type"));
		caseData.put("Payer Name", ds.get("Case.Payer Name"));
		caseData.put("Amount Received", ds.get("Case.Amount Received"));
		caseData.put("Notes / Remarks", ds.get("Case.Notes / Remarks"));

		// SMS template keys (only if present)
		caseData.put("SMS Message Title", ds.get("Case.SMS Message Title"));
		caseData.put("SMS Message Body", ds.get("Case.SMS Message Body"));

		// ==========================================================
		// ✅ Map-2: Plaintiff
		// ==========================================================
		TreeMap<String, String> plaintiff = new TreeMap<>();
		plaintiff.put("First Name", ds.get("Plaintiff.First Name"));
		plaintiff.put("Last Name", ds.get("Plaintiff.Last Name"));
		plaintiff.put("Plaintiff Name", (ds.get("Plaintiff.First Name") + " " + ds.get("Plaintiff.Last Name")).trim());

		// ==========================================================
		// ✅ Map-3: Attorney
		// ==========================================================
		TreeMap<String, String> attorney = new TreeMap<>();
		attorney.put("First Name", ds.get("Attorney.First Name"));
		attorney.put("Email", ds.get("Attorney.Email"));

		// ==========================================================
		// ✅ Map-4: Law Firm
		// ==========================================================
		TreeMap<String, String> lawFirm = new TreeMap<>();
		lawFirm.put("Name", ds.get("LawFirm.Name"));
		lawFirm.put("Law Firm Name", ds.get("LawFirm.Name"));

		// ==========================================================
		// ✅ Map-5: Staff
		// ==========================================================
		TreeMap<String, String> staff = new TreeMap<>();
		staff.put("Staff First Name", ds.get("Staff.Staff First Name"));
		staff.put("Staff Email", ds.get("Staff.Staff Email"));

		// ==========================================================
		// ✅ Map-6: Email payload (signature requirement)
		// ==========================================================
		TreeMap<String, String> email = new TreeMap<>();
		email.put("Template", ds.get("Email.Template"));
		email.put("Subject", ds.get("Email.Subject"));
		email.put("To", ds.get("Email.To"));
		email.put("Cc", ds.get("Email.Cc"));
		email.put("Bcc", ds.get("Email.Bcc"));

		String msg = ds.get("Email.Message");
		email.put("Message", msg == null ? "" : msg.replace("\\n", "\n"));

		// ✅ REUSE your TestNG flow directly
		super.Add_case(caseData, plaintiff, attorney, lawFirm, staff, email);
	}
	
	     @Given("Lien_Details_Calculater")
	     public void Lien_Details_Calculater() throws IOException, InterruptedException{
		 
	    	 bindDriver();
	    	 
	    	 
	    	 Application_Locaters p = new Application_Locaters(d);
	    	 Login_Locaters lg = new Login_Locaters(d);
	 	     Repeat rp = new Repeat(d);
	         Attorney_module at = new Attorney_module();
		  
	 	     
	         
	 
	 	    SideMenu_Handler_Cucumber.Side_menu_option_clicker_by_cucumber("Applications", d,"N/A");
			Thread.sleep(800);
			p.landed_in_applicationList_confirmation();
			p.Filter_clear().click();
			   WebElement Status_filter = p.Application_status_filter();
			   Status_filter.click();
			   Application_Filter_Option_Selector("Funded",d);
			   p.rows().get(1).click();
			   Thread.sleep(800);
			   List<WebElement> Case_Tags;
			   try {
			   Case_Tags = p.Case_tags();}
			   catch(RuntimeException tags){
				   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
				   System.out.println();
				   Thread.sleep(1200);
				   Case_Tags = p.Case_tags();}
			   String Case_id= Case_Tags.get(0).getText().trim();
			   String case_status= Case_Tags.get(1).getText().trim();
			   super.Pay_off_lien_list_Before_payment(Case_id);
	     }
	
	

	@Given("Buyout_Add_and_Fees_changed_in_Revised_Contract with data:")
	public void Buyout_Add_and_Fees_changed_in_Revised_Contract(DataTable table)throws InterruptedException, IOException {

	    bindDriver(); 

	    Map<String, String> raw = new TreeMap<>(table.asMap(String.class, String.class));
	    raw.remove("Key");

	    // Replace AUTO dates (same logic you’re already doing)
	    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String today  = LocalDate.now().format(fmt);
	    String expiry = LocalDate.now().plusYears(4).format(fmt);

	    raw.put("Case.Payment Date", today);
	    raw.put("Case.Agreement Date", today);
	    raw.put("Case.Interest Start Date", today);
	    raw.put("Case.Buyout Expiry Date", expiry);

	    // -------- Build maps EXACTLY like TestNG expects --------
	    TreeMap<String, String> caseData = new TreeMap<>();
	    caseData.put("Case Type",           raw.get("Case.Case Type"));
	    caseData.put("State",              raw.get("Case.State"));
	    caseData.put("Date of Incident",   raw.get("Case.Date of Incident"));
	    caseData.put("Lead Source",        raw.get("Case.Lead Source"));
	    caseData.put("Requested Amount",   raw.get("Case.Requested Amount"));
	    caseData.put("Summary",            raw.get("Case.Summary"));
	    caseData.put("Court Index Number", raw.get("Case.Court Index Number"));
	    caseData.put("Buyout Funder Name", raw.get("Case.Buyout Funder Name"));
	    caseData.put("Buyout Amount",      raw.get("Case.Buyout Amount"));
	    caseData.put("Buyout Expiry Date", raw.get("Case.Buyout Expiry Date"));
	    caseData.put("Approved Amount",    raw.get("Case.Approved Amount"));
	    caseData.put("Document prep fee",  raw.get("Case.Document prep fee"));
	    caseData.put("Fund transfer fee",  raw.get("Case.Fund transfer fee"));
	    caseData.put("Rate of Return",     raw.get("Case.Rate of Return"));

	    TreeMap<String, String> plaintiff = new TreeMap<>();
	    plaintiff.put("First Name", raw.get("Plaintiff.First Name"));
	    plaintiff.put("Last Name",  raw.get("Plaintiff.Last Name"));

	    TreeMap<String, String> attorney = new TreeMap<>();
	    attorney.put("First Name", raw.get("Attorney.First Name"));
	    attorney.put("Email",      raw.get("Attorney.Email"));

	    TreeMap<String, String> lawFirm = new TreeMap<>();
	    lawFirm.put("Name",         raw.get("LawFirm.Name"));
	    lawFirm.put("Law Firm Name",raw.get("LawFirm.Name"));

	    TreeMap<String, String> staff = new TreeMap<>();
	    staff.put("Staff First Name", raw.get("Staff.Staff First Name"));
	    staff.put("Staff Email",      raw.get("Staff.Staff Email"));

	    TreeMap<String, String> email = new TreeMap<>();
	    email.put("Template", raw.get("Email.Template"));
	    email.put("Subject",  raw.get("Email.Subject"));
	    email.put("To",       raw.get("Email.To"));
	    email.put("Cc",       raw.get("Email.Cc"));
	    email.put("Bcc",      raw.get("Email.Bcc"));
	    email.put("Message",  raw.get("Email.Message"));

	    // ✅ REUSE the TestNG business flow
	    super.Buyout_Add_and_Fees_changed_in_Revised_Contract(caseData, plaintiff, attorney, lawFirm, staff, email);

	}

	@Given("Buyout_Add_After_Contract_Generation_through_Edit_Terms with data:")
	public void Buyout_Add_After_Contract_Generation_through_Edit_Terms(DataTable data) throws Exception {

		bindDriver();

		TreeMap<String, String> editTermsDataset = new TreeMap<>(data.asMap(String.class, String.class));
		editTermsDataset.remove("Key");

		// Always overwrite these dates (table contains them as AUTO, so no checks
		// needed)
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String today = LocalDate.now().format(fmt);
		String expiry = LocalDate.now().plusYears(4).format(fmt);

		editTermsDataset.put("Case.Agreement Date", today);
		editTermsDataset.put("Case.Interest Start Date", today);
		editTermsDataset.put("Case.Buyout Expiry Date", expiry);

		// ===== Map-1: Case_Data (exact keys used in TestNG method) =====
		TreeMap<String, String> caseContractData = new TreeMap<>();
		caseContractData.put("Lead Source", editTermsDataset.get("Case.Lead Source"));
		caseContractData.put("Requested Amount", editTermsDataset.get("Case.Requested Amount"));
		caseContractData.put("Case Type", editTermsDataset.get("Case.Case Type"));
		caseContractData.put("State", editTermsDataset.get("Case.State"));
		caseContractData.put("Summary", editTermsDataset.get("Case.Summary"));
		caseContractData.put("Court Index Number", editTermsDataset.get("Case.Court Index Number"));
		caseContractData.put("Date of Incident", editTermsDataset.get("Case.Date of Incident"));

		caseContractData.put("Buyout Funder Name", editTermsDataset.get("Case.Buyout Funder Name"));
		caseContractData.put("Buyout Amount", editTermsDataset.get("Case.Buyout Amount"));
		caseContractData.put("Buyout Expiry Date", editTermsDataset.get("Case.Buyout Expiry Date"));

		caseContractData.put("Approved Amount", editTermsDataset.get("Case.Approved Amount"));
		caseContractData.put("Document prep fee", editTermsDataset.get("Case.Document prep fee"));
		caseContractData.put("Fund transfer fee", editTermsDataset.get("Case.Fund transfer fee"));
		caseContractData.put("Rate of Return", editTermsDataset.get("Case.Rate of Return"));

		caseContractData.put("Agreement Date", editTermsDataset.get("Case.Agreement Date"));
		caseContractData.put("Interest Start Date", editTermsDataset.get("Case.Interest Start Date"));

		// This key is referenced in your TestNG logs, so populate it too (prevents
		// "null" in reports)
		caseContractData.put("Plaintiff Name",
				editTermsDataset.get("Plaintiff.First Name") + " " + editTermsDataset.get("Plaintiff.Last Name"));

		// ===== Map-2: Plaintiff =====
		TreeMap<String, String> plaintiffCard = new TreeMap<>();
		plaintiffCard.put("First Name", editTermsDataset.get("Plaintiff.First Name"));
		plaintiffCard.put("Last Name", editTermsDataset.get("Plaintiff.Last Name"));

		// ===== Map-3: Attorney =====
		TreeMap<String, String> attorneyCard = new TreeMap<>();
		attorneyCard.put("First Name", editTermsDataset.get("Attorney.First Name"));
		attorneyCard.put("Email", editTermsDataset.get("Attorney.Email"));

		// ===== Map-4: Law Firm =====
		TreeMap<String, String> lawFirmCard = new TreeMap<>();
		lawFirmCard.put("Name", editTermsDataset.get("LawFirm.Name"));
		lawFirmCard.put("Law Firm Name", editTermsDataset.get("LawFirm.Name"));

		// ===== Map-5: Staff =====
		TreeMap<String, String> staffOwner = new TreeMap<>();
		staffOwner.put("Staff First Name", editTermsDataset.get("Staff.Staff First Name"));
		staffOwner.put("Staff Email", editTermsDataset.get("Staff.Staff Email"));

		// ===== Map-6: Email (not used in this TestNG method but required by signature)
		// =====
		TreeMap<String, String> emailPacket = new TreeMap<>();
		emailPacket.put("Template", editTermsDataset.get("Email.Template"));
		emailPacket.put("Subject", editTermsDataset.get("Email.Subject"));
		emailPacket.put("To", editTermsDataset.get("Email.To"));
		emailPacket.put("Cc", editTermsDataset.get("Email.Cc"));
		emailPacket.put("Bcc", editTermsDataset.get("Email.Bcc"));
		emailPacket.put("Message", editTermsDataset.get("Email.Message").replace("\\n", "\n"));

		super.Buyout_Add_After_Contract_Generation_through_Edit_Terms(caseContractData, plaintiffCard, attorneyCard,lawFirmCard, staffOwner, emailPacket);
	}

	@Given("Multiple_Application_Generator with data:")
	public void Multiple_Application_Generator(DataTable data) throws Exception {

		bindDriver();

		TreeMap<String, String> generatorDataset = new TreeMap<>(data.asMap(String.class, String.class));
		generatorDataset.remove("Key");

		// Always overwrite dates (table contains these keys as AUTO, so no checks
		// needed)
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String today = LocalDate.now().format(fmt);
		String expiry = LocalDate.now().plusYears(4).format(fmt);

		generatorDataset.put("Case.Payment Date", today);
		generatorDataset.put("Case.Agreement Date", today);
		generatorDataset.put("Case.Interest Start Date", today);
		generatorDataset.put("Case.Buyout Expiry Date", expiry);

		// ===== Build 6 payload maps exactly like TestNG signature =====

		TreeMap<String, String> casePayload = new TreeMap<>();
		casePayload.put("Case #", generatorDataset.get("Case.Case #"));
		casePayload.put("Case Type", generatorDataset.get("Case.Case Type"));
		casePayload.put("State", generatorDataset.get("Case.State"));
		casePayload.put("Date of Incident", generatorDataset.get("Case.Date of Incident"));
		casePayload.put("Lead Source", generatorDataset.get("Case.Lead Source"));
		casePayload.put("Requested Amount", generatorDataset.get("Case.Requested Amount"));
		casePayload.put("Court Index Number", generatorDataset.get("Case.Court Index Number"));
		casePayload.put("Summary", generatorDataset.get("Case.Summary"));

		casePayload.put("Application Status", generatorDataset.get("Case.Application Status"));
		casePayload.put("Risk Level", generatorDataset.get("Case.Risk Level"));
		casePayload.put("Recommended Max Funding", generatorDataset.get("Case.Recommended Max Funding"));
		casePayload.put("Underwriting Notes", generatorDataset.get("Case.Underwriting Notes"));
		casePayload.put("Underwriting Tag", generatorDataset.get("Case.Underwriting Tag"));

		casePayload.put("Buyout Funder Name", generatorDataset.get("Case.Buyout Funder Name"));
		casePayload.put("Buyout Amount", generatorDataset.get("Case.Buyout Amount"));
		casePayload.put("Approved Amount", generatorDataset.get("Case.Approved Amount"));
		casePayload.put("Document prep fee", generatorDataset.get("Case.Document prep fee"));
		casePayload.put("Fund transfer fee", generatorDataset.get("Case.Fund transfer fee"));
		casePayload.put("Rate of Return", generatorDataset.get("Case.Rate of Return"));

		casePayload.put("Payment Date", generatorDataset.get("Case.Payment Date"));
		casePayload.put("Agreement Date", generatorDataset.get("Case.Agreement Date"));
		casePayload.put("Interest Start Date", generatorDataset.get("Case.Interest Start Date"));
		casePayload.put("Buyout Expiry Date", generatorDataset.get("Case.Buyout Expiry Date"));

		casePayload.put("Payment Mode", generatorDataset.get("Case.Payment Mode"));
		casePayload.put("Payment Type", generatorDataset.get("Case.Payment Type"));
		casePayload.put("Payer Name", generatorDataset.get("Case.Payer Name"));
		casePayload.put("Notes / Remarks", generatorDataset.get("Case.Notes / Remarks"));

		casePayload.put("SMS Message Title", generatorDataset.get("Case.SMS Message Title"));
		casePayload.put("SMS Message Body", generatorDataset.get("Case.SMS Message Body"));

		TreeMap<String, String> plaintiffProfile = new TreeMap<>();
		plaintiffProfile.put("First Name", generatorDataset.get("Plaintiff.First Name"));
		plaintiffProfile.put("Last Name", generatorDataset.get("Plaintiff.Last Name"));
		plaintiffProfile.put("Plaintiff Name",
				(generatorDataset.get("Plaintiff.First Name") + " " + generatorDataset.get("Plaintiff.Last Name"))
						.trim());

		TreeMap<String, String> attorneyProfile = new TreeMap<>();
		attorneyProfile.put("First Name", generatorDataset.get("Attorney.First Name"));
		attorneyProfile.put("Email", generatorDataset.get("Attorney.Email"));

		TreeMap<String, String> lawFirmProfile = new TreeMap<>();
		lawFirmProfile.put("Name", generatorDataset.get("LawFirm.Name"));
		lawFirmProfile.put("Law Firm Name", generatorDataset.get("LawFirm.Name"));

		TreeMap<String, String> staffProfile = new TreeMap<>();
		staffProfile.put("Staff First Name", generatorDataset.get("Staff.Staff First Name"));
		staffProfile.put("Staff Email", generatorDataset.get("Staff.Staff Email"));

		TreeMap<String, String> emailDraft = new TreeMap<>();
		emailDraft.put("Template", generatorDataset.get("Email.Template"));
		emailDraft.put("Subject", generatorDataset.get("Email.Subject"));
		emailDraft.put("To", generatorDataset.get("Email.To"));
		emailDraft.put("Cc", generatorDataset.get("Email.Cc"));
		emailDraft.put("Bcc", generatorDataset.get("Email.Bcc"));
		emailDraft.put("Message", generatorDataset.get("Email.Message").replace("\\n", "\n"));

		super.Multiple_Application_Generator(casePayload, plaintiffProfile, attorneyProfile, lawFirmProfile,
				staffProfile, emailDraft);
	}

	public void Revise_Contract(Map<String, String> data) throws InterruptedException, IOException {

		TreeMap<String, String> Case_Data = new TreeMap<>();

		// Map keys are your Cucumber-prefixed keys
		Case_Data.put("Buyout Amount", data.get("Case.Buyout Amount"));
		Case_Data.put("Buyout Funder Name", data.get("Case.Buyout Funder Name"));
		Case_Data.put("Buyout Expiry Date", data.get("Case.Buyout Expiry Date"));

		// Reuse your already-tested TestNG logic
		super.Revise_Contract(Case_Data);
	}

	@Given("Message_Template_Creator with data:")
	public void Message_Template_Creator(DataTable data) throws Exception {

		bindDriver();
		TreeMap<String, String> templateData = new TreeMap<>(data.asMap(String.class, String.class));
		templateData.remove("Key");
		templateData.put("Title", templateData.get("Case.SMS Message Title"));
		templateData.put("Message body", templateData.get("Case.SMS Message Body"));
		super.Message_Template_Creator(templateData);
	}

	@Given("Notes_Add with data:")
	public void Notes_Add(DataTable data) throws Exception {

		bindDriver();

		TreeMap<String, String> notesData = new TreeMap<>(data.asMap(String.class, String.class));
		notesData.remove("Key");

		String noteText = notesData.get("Case.Note Text");

		// TestNG method expects only ONE parameter = note content
		super.Notes_Add(noteText.trim());
	}

	@Given("Particular_Lien_Accessor with data:")
	public void Particular_Lien_Accessor(DataTable data) throws Exception {

		bindDriver();

		TreeMap<String, String> lienAccessInput = new TreeMap<>(data.asMap(String.class, String.class));
		lienAccessInput.remove("Key");

		String lienUrl = lienAccessInput.get("Lien.Url");

		// TestNG method signature: Particular_Lien_Accessor(String Url)
		super.Particular_Lien_Accessor(lienUrl);
	}

	public void Pay_off_lien_list_After_Revise_contract(Map<String, String> data, String id)
			throws IOException, InterruptedException {

		// Build minimal TreeMap for compatibility (even empty is ok since your logic
		// doesn’t use it)
		TreeMap<String, String> Case_Data = new TreeMap<>();

		// Optional: only if TestNG version expects these keys (safe to include)
		Case_Data.put("Buyout Amount", data.get("Case.Buyout Amount"));
		Case_Data.put("Buyout Funder Name", data.get("Case.Buyout Funder Name"));
		Case_Data.put("Buyout Expiry Date", data.get("Case.Buyout Expiry Date"));

		super.Pay_off_lien_list_After_Revise_contract(Case_Data, id);
	}

	// Overloaded version for Cucumber parameter acceptance
	public void Payment_Calculator(Map<String, String> data, String caseId) throws IOException, InterruptedException {

		TreeMap<String, String> t = new TreeMap<>();
		t.put("Payment Mode", data.get("Case.Payment Mode"));
		t.put("Payment Type", data.get("Case.Payment Type"));
		t.put("Payer Name", data.get("Case.Payer Name"));
		t.put("Payment Date", data.get("Case.Payment Date"));
		t.put("Notes / Remarks", data.get("Case.Notes / Remarks"));
		t.put("Document prep fee", data.get("Case.Document prep fee"));
		t.put("Fund transfer fee", data.get("Case.Fund transfer fee"));

		// Call TestNG version (this will automatically call TestNG Payment_Logger)
		super.Payment_Calculator(t, caseId);
	}

	public String Payment_Logger(Map<String, String> data, String caseId) throws IOException, InterruptedException {

		// Build the TreeMap shape expected by TestNG zone
		TreeMap<String, String> t = new TreeMap<>();
		t.put("Payment Mode", data.get("Case.Payment Mode"));
		t.put("Payment Type", data.get("Case.Payment Type"));
		t.put("Payer Name", data.get("Case.Payer Name"));
		t.put("Payment Date", data.get("Case.Payment Date"));
		t.put("Notes / Remarks", data.get("Case.Notes / Remarks"));
		t.put("Document prep fee", data.get("Case.Document prep fee"));
		t.put("Fund transfer fee", data.get("Case.Fund transfer fee"));

		// Call TestNG version (in Case_Appplications)
		return super.Payment_Logger(t, caseId);
	}

	public void Underwriting_Notes(Map<String, String> data) throws InterruptedException, IOException {

		// Build the TreeMap shape expected by TestNG
		TreeMap<String, String> Case_Data = new TreeMap<>();
		Case_Data.put("Underwriting Notes", data.get("Case.Underwriting Notes"));
		Case_Data.put("Underwriting Tag", data.get("Case.Underwriting Tag"));

		// Call the TestNG implementation
		super.Underwriting_Notes(Case_Data);
	}
}