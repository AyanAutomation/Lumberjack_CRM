package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listerners.Report_Listen;
import Locaters.Application_Locaters;
import Locaters.Attorney_Locaters;
import Locaters.Login_Locaters;
import Locaters.Plaintiff_Locaters;
import Negative_Testcases.Login_negative_testcases;
import Repeatative_codes.Repeat;

public class Attorney_module extends Plaintiff_Module{
	
	
	
	@Test(dataProvider="law_plus_attorney")
	public void Attorney_Add(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff) throws IOException, InterruptedException{
		
	Attorney_Locaters pp = new Attorney_Locaters(d);	
	SIde_Menu_Handler sd=new SIde_Menu_Handler();
	Plaintiff_Locaters p=new Plaintiff_Locaters(d);
	Application_Locaters ap = new Application_Locaters(d);
	Repeat rp=new Repeat(d);
	Login_Locaters lg=new Login_Locaters(d);
	
	String Law_Firm = law_firm.get("Name");
	Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🔹 Scenario Title:</b> Add Attorney – Create Attorney under selected Law Firm and confirm save");

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>📘 Description:</b> Validate that a user can add a new <b>Attorney</b> under a selected <b>Law Firm</b>, optionally add staff details, and the system saves the attorney successfully.");

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>📥 Input:</b> Law Firm=<b>"+Law_Firm+"</b> | Attorney Name=<b>"+data.get("First Name")+" "+data.get("Last Name")+
            "</b> | Email=<b>"+data.get("Email")+"</b> | Phone=<b>"+data.get("Phone")+
            "</b> | Office Phone=<b>"+data.get("Office phone")+"</b>");

    Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>✅ Expected:</b> Attorney should be created under the selected Law Firm and a confirmation toast/message should appear.");

	sd.Side_menu_option_clicker("Firm & Counsel",d,"Attorney");	
	pp.Landed_in_attorney_module();	
	rp.Scroll_to_element(p.form());
	Thread.sleep(800);	
	List<WebElement> input_feilds=p.inputs();	
	input_feilds.get(0).clear();
	input_feilds.get(0).sendKeys(Law_Firm);;
	ap.plaintiff_dropdown_list();
	Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Law Firm search performed and firm selection is being verified.");
	List<WebElement> options = ap.Plaintiff_options();
	for(WebElement option:options){
		if(option.getText().trim().contains(Law_Firm)){
			option.click();
			break;}}
	input_feilds.get(1).sendKeys(data.get("First Name"));
	input_feilds.get(2).sendKeys(data.get("Middle Name"));
	input_feilds.get(3).sendKeys(data.get("Last Name"));	
	input_feilds.get(4).sendKeys(data.get("Name Suffix"));
	input_feilds.get(5).sendKeys(data.get("Phone"));
	input_feilds.get(6).sendKeys(data.get("Office phone"));	
	input_feilds.get(7).sendKeys(data.get("Email"));
	WebElement Add_staff_button= p.form_buttons().get(1);
	//Add_staff_button.click();
	Report_Listen.log_print_in_report().log(Status.INFO,
            "<b>🟨 Actual:</b> Attorney details entered. Staff details (if applicable) are being added before final submission.");
	List<WebElement> fields = ap.form_inputs();
	WebElement Submit_Button = ap.form_buttons().get(1);
	WebElement popup_form = ap.Popup_add_form();
	staff_add(staff,fields,popup_form,Submit_Button);
	WebElement Add_Attorney_Button=p.form_buttons().get(2);
	rp.Scroll_to_element(Add_Attorney_Button);
	Add_Attorney_Button.click();
	Thread.sleep(800);	
	String taost= lg.toast().getText().trim();
	Login_negative_testcases.Toast_printer(taost);
	try{
        String toast_text = lg.toast().getText().trim();
        Report_Listen.log_print_in_report().log(Status.PASS,
                "<b>🟨 Actual:</b> ✅ Attorney created successfully under <b>"+Law_Firm+
                "</b>. Confirmation message received: <b>"+toast_text+"</b>");
    }catch(Exception e){
        Report_Listen.log_print_in_report().log(Status.FAIL,
                "<b>🟨 Actual:</b> ❌ Attorney save confirmation toast was not captured (toast not visible / locator issue).");
        throw e;
    }
	}
	
	
	
	public void Atttorney_Add_through_case(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff,WebDriver d) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		Login_Locaters lg = new Login_Locaters(d);
	
            WebElement Create_Contact = p.Create_Contact_button();
			rp.Scroll_to_element(Create_Contact);
			Create_Contact.click();
			List<WebElement> attorney_inputs = p.second_popup_form_inputs();
			attorney_inputs.get(0).sendKeys(law_firm.get("Name"));
			p.plaintiff_dropdown_list();
			p.Plaintiff_options().get(0).click();
			attorney_inputs.get(1).sendKeys(data.get("First Name"));
			attorney_inputs.get(2).sendKeys(data.get("Middle Name"));
			attorney_inputs.get(3).sendKeys(data.get("Last Name"));
			attorney_inputs.get(4).sendKeys(data.get("Name Suffix"));
			attorney_inputs.get(5).sendKeys(data.get("Phone"));
			attorney_inputs.get(6).sendKeys(data.get("Office phone"));
			attorney_inputs.get(7).sendKeys(data.get("Email"));/*
			WebElement Add_staff_button= p.second_popup_form_buttons().get(1);
			Add_staff_button.click();
			List<WebElement> fields = p.Third_popup_form_inputs();
			WebElement Staff_pop_up_form = p.Third_popup_form();
			WebElement Staff_Add_button= p.Third_popup_form_buttons().get(1);
			staff_add(staff,fields,Staff_pop_up_form,Staff_Add_button);*/
			WebElement Add_Attorney_Button=p.second_popup_form_buttons().get(2);
			rp.Scroll_to_element(Add_Attorney_Button);
			Add_Attorney_Button.click();
			Thread.sleep(800);	
			WebElement Local_Toast = lg.toast();
			String taost= Local_Toast.getText().trim();
			Login_negative_testcases.Toast_printer(taost);
		    Thread.sleep(600);}
	
	
	public void staff_add(TreeMap<String, String> data,List<WebElement>Form_fields,WebElement pop_up_form,WebElement Submit_button){
		
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		
		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>🔹 Scenario Title:</b> Add Staff – Save staff details and confirm popup closes");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📘 Description:</b> Validate that staff details can be entered and saved, and the staff add popup closes after successful submission.");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>📥 Input:</b> Staff Name=<b>"+data.get("Staff First Name")+" "+data.get("Staff Last Name")+
				"</b> | Email=<b>"+data.get("Staff Email")+"</b> | Phone=<b>"+data.get("Staff Phone")+
				"</b> | Office Phone=<b>"+data.get("Staff Office phone")+"</b>");

		Report_Listen.log_print_in_report().log(Status.INFO,
				"<b>✅ Expected:</b> Staff should be added successfully and the staff popup/form should close (no popup should remain visible).");

		
		List<WebElement> fields = Form_fields;
		fields.get(0).sendKeys(data.get("Staff First Name"));
		fields.get(1).sendKeys(data.get("Staff Middle Name"));
		fields.get(2).sendKeys(data.get("Staff Last Name"));
		fields.get(3).sendKeys(data.get("Staff Name Suffix"));
		fields.get(4).sendKeys(data.get("Staff Phone"));
		fields.get(5).sendKeys(data.get("Staff Office phone"));
		fields.get(6).sendKeys(data.get("Staff Email"));
		WebElement Add_button = Submit_button;
		Add_button.click();
		try{
			rp.wait_for_invisibility(pop_up_form);
			Report_Listen.log_print_in_report().log(Status.PASS,
					"<b>🟨 Actual:</b> ✅ Staff details saved and popup closed successfully.");
		}catch(Exception e){
			Report_Listen.log_print_in_report().log(Status.FAIL,
					"<b>🟨 Actual:</b> ❌ Staff popup did not close after clicking Add/Submit (save may have failed or UI did not respond).");
			throw e;
		}
	}
	
	
	@DataProvider
	public Object[][] attorneyfData() {

		TreeMap<String, String> a1 = new TreeMap<>();
	    a1.put("First Name", "Attorney Maëlys");
	    a1.put("Middle Name", "Rowan");
	    a1.put("Last Name", "Beausoleil");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "9897406123");
	    a1.put("Office phone", "9897418123");
	    a1.put("Email", "attorney.maelys.beausoleil01@yopmail.com");

	    TreeMap<String, String> a2 = new TreeMap<>();
	    a2.put("First Name", "Attorney Éloïse");
	    a2.put("Middle Name", "Graham");
	    a2.put("Last Name", "Montpetit");
	    a2.put("Name Suffix", "Jr");
	    a2.put("Phone", "9897406124");
	    a2.put("Office phone", "9897418124");
	    a2.put("Email", "attorney.eloise.montpetit02@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<>();
	    a3.put("First Name", "Attorney Callum");
	    a3.put("Middle Name", "Jasper");
	    a3.put("Last Name", "Kincaid-Rowe");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9897406125");
	    a3.put("Office phone", "9897418125");
	    a3.put("Email", "attorney.callum.kincaidrowe03@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<>();
	    a4.put("First Name", "Attorney Siobhan");
	    a4.put("Middle Name", "Noëlle");
	    a4.put("Last Name", "Bélanger");
	    a4.put("Name Suffix", "Sr");
	    a4.put("Phone", "9897406126");
	    a4.put("Office phone", "9897418126");
	    a4.put("Email", "attorney.siobhan.belanger04@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<>();
	    a5.put("First Name", "Attorney Théodore");
	    a5.put("Middle Name", "Finn");
	    a5.put("Last Name", "Ducharme");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "9897406127");
	    a5.put("Office phone", "9897418127");
	    a5.put("Email", "attorney.theodore.ducharme05@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<>();
	    a6.put("First Name", "Attorney Mireille");
	    a6.put("Middle Name", "Blaise");
	    a6.put("Last Name", "Laframboise");
	    a6.put("Name Suffix", "II");
	    a6.put("Phone", "9897406128");
	    a6.put("Office phone", "9897418128");
	    a6.put("Email", "attorney.mireille.laframboise06@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<>();
	    a7.put("First Name", "Attorney Lachlan");
	    a7.put("Middle Name", "Émile");
	    a7.put("Last Name", "MacQuarrie");
	    a7.put("Name Suffix", "Jr");
	    a7.put("Phone", "9897406129");
	    a7.put("Office phone", "9897418129");
	    a7.put("Email", "attorney.lachlan.macquarrie07@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<>();
	    a8.put("First Name", "Attorney Geneviève");
	    a8.put("Middle Name", "Sage");
	    a8.put("Last Name", "Thibodeau");
	    a8.put("Name Suffix", "III");
	    a8.put("Phone", "9897406130");
	    a8.put("Office phone", "9897418130");
	    a8.put("Email", "attorney.genevieve.thibodeau08@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<>();
	    a9.put("First Name", "Attorney Rhys");
	    a9.put("Middle Name", "Olivier");
	    a9.put("Last Name", "Deslauriers");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "9897406131");
	    a9.put("Office phone", "9897418131");
	    a9.put("Email", "attorney.rhys.deslauriers09@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<>();
	    a10.put("First Name", "Attorney Ainsley");
	    a10.put("Middle Name", "Claire");
	    a10.put("Last Name", "Houde");
	    a10.put("Name Suffix", "IV");
	    a10.put("Phone", "9897406132");
	    a10.put("Office phone", "9897418132");
	    a10.put("Email", "attorney.ainsley.houde10@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<>();
	    a11.put("First Name", "Attorney Étienne");
	    a11.put("Middle Name", "Reid");
	    a11.put("Last Name", "Cormier");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "9897406133");
	    a11.put("Office phone", "9897418133");
	    a11.put("Email", "attorney.etienne.cormier11@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<>();
	    a12.put("First Name", "Attorney Bronwen");
	    a12.put("Middle Name", "Luc");
	    a12.put("Last Name", "Chartrand");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "9897406134");
	    a12.put("Office phone", "9897418134");
	    a12.put("Email", "attorney.bronwen.chartrand12@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<>();
	    a13.put("First Name", "Attorney Dashiell");
	    a13.put("Middle Name", "Noah");
	    a13.put("Last Name", "Vézina");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "9897406135");
	    a13.put("Office phone", "9897418135");
	    a13.put("Email", "attorney.dashiell.vezina13@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<>();
	    a14.put("First Name", "Attorney Rosalie");
	    a14.put("Middle Name", "Quinn");
	    a14.put("Last Name", "Beauchamp");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "9897406136");
	    a14.put("Office phone", "9897418136");
	    a14.put("Email", "attorney.rosalie.beauchamp14@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<>();
	    a15.put("First Name", "Attorney Soren");
	    a15.put("Middle Name", "Mathieu");
	    a15.put("Last Name", "Paquette");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "9897406137");
	    a15.put("Office phone", "9897418137");
	    a15.put("Email", "attorney.soren.paquette15@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<>();
	    a16.put("First Name", "Attorney Nadine");
	    a16.put("Middle Name", "Éloi");
	    a16.put("Last Name", "Gagnon-Lévesque");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "9897406138");
	    a16.put("Office phone", "9897418138");
	    a16.put("Email", "attorney.nadine.gagnonlevesque16@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<>();
	    a17.put("First Name", "Attorney Kieran");
	    a17.put("Middle Name", "Jules");
	    a17.put("Last Name", "Marchand");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "9897406139");
	    a17.put("Office phone", "9897418139");
	    a17.put("Email", "attorney.kieran.marchand17@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<>();
	    a18.put("First Name", "Attorney Anaïs");
	    a18.put("Middle Name", "Benoît");
	    a18.put("Last Name", "Bourque");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "9897406140");
	    a18.put("Office phone", "9897418140");
	    a18.put("Email", "attorney.anais.bourque18@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<>();
	    a19.put("First Name", "Attorney Declan");
	    a19.put("Middle Name", "Hugh");
	    a19.put("Last Name", "Tremblay-Fox");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "9897406141");
	    a19.put("Office phone", "9897418141");
	    a19.put("Email", "attorney.declan.tremblayfox19@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<>();
	    a20.put("First Name", "Attorney Vivienne");
	    a20.put("Middle Name", "Maeve");
	    a20.put("Last Name", "Landry");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "9897406142");
	    a20.put("Office phone", "9897418142");
	    a20.put("Email", "attorney.vivienne.landry20@mailto.plus");

	    return new Object[][]{
	        {a1},{a2},{a3},{a4},{a5},
	        {a6},{a7},{a8},{a9},{a10},
	        {a11},{a12},{a13},{a14},{a15},
	        {a16},{a17},{a18},{a19},{a20}
	    };
	    
	}
	
	@DataProvider
	public Object[][] Staff_data() {

	
		TreeMap<String, String> s1 = new TreeMap<>();
	    s1.put("Staff First Name", "Staff Nivaren");
	    s1.put("Staff Middle Name", "Calix");
	    s1.put("Staff Last Name", "Thornwick");
	    s1.put("Staff Name Suffix", "II");
	    s1.put("Staff Phone", "9716043825");
	    s1.put("Staff Office phone", "9718821460");
	    s1.put("Staff Email", "staff.nivaren.thornwick25@mailto.plus");

	    TreeMap<String, String> s2 = new TreeMap<>();
	    s2.put("Staff First Name", "Staff Mirelia");
	    s2.put("Staff Middle Name", "Solene");
	    s2.put("Staff Last Name", "Ashmont");
	    s2.put("Staff Name Suffix", "Jr");
	    s2.put("Staff Phone", "4157382069");
	    s2.put("Staff Office phone", "4159057341");
	    s2.put("Staff Email", "staff.mirelia.ashmont69@mailto.plus");

	    TreeMap<String, String> s3 = new TreeMap<>();
	    s3.put("Staff First Name", "Staff Corven");
	    s3.put("Staff Middle Name", "Bastien");
	    s3.put("Staff Last Name", "Wetherby");
	    s3.put("Staff Name Suffix", "III");
	    s3.put("Staff Phone", "6194027851");
	    s3.put("Staff Office phone", "6199041876");
	    s3.put("Staff Email", "staff.corven.wetherby51@mailto.plus");

	    TreeMap<String, String> s4 = new TreeMap<>();
	    s4.put("Staff First Name", "Staff Elowen");
	    s4.put("Staff Middle Name", "Rhiannon");
	    s4.put("Staff Last Name", "Harrowdale");
	    s4.put("Staff Name Suffix", "Sr");
	    s4.put("Staff Phone", "2065839174");
	    s4.put("Staff Office phone", "2069073518");
	    s4.put("Staff Email", "staff.elowen.harrowdale74@mailto.plus");

	    TreeMap<String, String> s5 = new TreeMap<>();
	    s5.put("Staff First Name", "Staff Tavion");
	    s5.put("Staff Middle Name", "Lucien");
	    s5.put("Staff Last Name", "Kingsmere");
	    s5.put("Staff Name Suffix", "IV");
	    s5.put("Staff Phone", "3037164082");
	    s5.put("Staff Office phone", "3039026657");
	    s5.put("Staff Email", "staff.tavion.kingsmere82@mailto.plus");

	    TreeMap<String, String> s6 = new TreeMap<>();
	    s6.put("Staff First Name", "Staff Kaelina");
	    s6.put("Staff Middle Name", "Odette");
	    s6.put("Staff Last Name", "Briarholt");
	    s6.put("Staff Name Suffix", "II");
	    s6.put("Staff Phone", "5126398047");
	    s6.put("Staff Office phone", "5129043716");
	    s6.put("Staff Email", "staff.kaelina.briarholt47@mailto.plus");

	    TreeMap<String, String> s7 = new TreeMap<>();
	    s7.put("Staff First Name", "Staff Rovenna");
	    s7.put("Staff Middle Name", "Marin");
	    s7.put("Staff Last Name", "Quarryn");
	    s7.put("Staff Name Suffix", "Jr");
	    s7.put("Staff Phone", "7045831096");
	    s7.put("Staff Office phone", "7049062841");
	    s7.put("Staff Email", "staff.rovenna.quarryn96@mailto.plus");

	    TreeMap<String, String> s8 = new TreeMap<>();
	    s8.put("Staff First Name", "Staff Doriane");
	    s8.put("Staff Middle Name", "Noemi");
	    s8.put("Staff Last Name", "Valewood");
	    s8.put("Staff Name Suffix", "III");
	    s8.put("Staff Phone", "6174029683");
	    s8.put("Staff Office phone", "6179054172");
	    s8.put("Staff Email", "staff.doriane.valewood83@mailto.plus");

	    TreeMap<String, String> s9 = new TreeMap<>();
	    s9.put("Staff First Name", "Staff Erynden");
	    s9.put("Staff Middle Name", "Pascal");
	    s9.put("Staff Last Name", "Stormley");
	    s9.put("Staff Name Suffix", "Sr");
	    s9.put("Staff Phone", "4167385129");
	    s9.put("Staff Office phone", "4169072638");
	    s9.put("Staff Email", "staff.erynden.stormley29@mailto.plus");

	    TreeMap<String, String> s10 = new TreeMap<>();
	    s10.put("Staff First Name", "Staff Selvara");
	    s10.put("Staff Middle Name", "Giselle");
	    s10.put("Staff Last Name", "Montclair");
	    s10.put("Staff Name Suffix", "IV");
	    s10.put("Staff Phone", "5146093874");
	    s10.put("Staff Office phone", "5149027415");
	    s10.put("Staff Email", "staff.selvara.montclair74@mailto.plus");

	    TreeMap<String, String> s11 = new TreeMap<>();
	    s11.put("Staff First Name", "Staff Iveron");
	    s11.put("Staff Middle Name", "Quentin");
	    s11.put("Staff Last Name", "Hollingmere");
	    s11.put("Staff Name Suffix", "II");
	    s11.put("Staff Phone", "4035829176");
	    s11.put("Staff Office phone", "4039051287");
	    s11.put("Staff Email", "staff.iveron.hollingmere76@mailto.plus");

	    TreeMap<String, String> s12 = new TreeMap<>();
	    s12.put("Staff First Name", "Staff Maelis");
	    s12.put("Staff Middle Name", "Celeste");
	    s12.put("Staff Last Name", "Falkner");
	    s12.put("Staff Name Suffix", "Jr");
	    s12.put("Staff Phone", "6044170289");
	    s12.put("Staff Office phone", "6049035174");
	    s12.put("Staff Email", "staff.maelis.falkner89@mailto.plus");

	    TreeMap<String, String> s13 = new TreeMap<>();
	    s13.put("Staff First Name", "Staff Leontis");
	    s13.put("Staff Middle Name", "Benoit");
	    s13.put("Staff Last Name", "Ambervale");
	    s13.put("Staff Name Suffix", "III");
	    s13.put("Staff Phone", "7805938162");
	    s13.put("Staff Office phone", "7809052471");
	    s13.put("Staff Email", "staff.leontis.ambervale62@mailto.plus");

	    TreeMap<String, String> s14 = new TreeMap<>();
	    s14.put("Staff First Name", "Staff Nymera");
	    s14.put("Staff Middle Name", "Rafael");
	    s14.put("Staff Last Name", "Dunleavy");
	    s14.put("Staff Name Suffix", "Sr");
	    s14.put("Staff Phone", "2896071945");
	    s14.put("Staff Office phone", "2899047362");
	    s14.put("Staff Email", "staff.nymera.dunleavy45@mailto.plus");

	    TreeMap<String, String> s15 = new TreeMap<>();
	    s15.put("Staff First Name", "Staff Kellanor");
	    s15.put("Staff Middle Name", "Yseult");
	    s15.put("Staff Last Name", "Ravenhurst");
	    s15.put("Staff Name Suffix", "IV");
	    s15.put("Staff Phone", "5194832071");
	    s15.put("Staff Office phone", "5199078846");
	    s15.put("Staff Email", "staff.kellanor.ravenhurst71@mailto.plus");

	    TreeMap<String, String> s16 = new TreeMap<>();
	    s16.put("Staff First Name", "Staff Orlena");
	    s16.put("Staff Middle Name", "Simone");
	    s16.put("Staff Last Name", "Wexford");
	    s16.put("Staff Name Suffix", "II");
	    s16.put("Staff Phone", "6137204958");
	    s16.put("Staff Office phone", "6139061307");
	    s16.put("Staff Email", "staff.orlena.wexford58@mailto.plus");

	    TreeMap<String, String> s17 = new TreeMap<>();
	    s17.put("Staff First Name", "Staff Tavrena");
	    s17.put("Staff Middle Name", "Elio");
	    s17.put("Staff Last Name", "Briarwick");
	    s17.put("Staff Name Suffix", "Jr");
	    s17.put("Staff Phone", "9053718264");
	    s17.put("Staff Office phone", "9059034178");
	    s17.put("Staff Email", "staff.tavrena.briarwick64@mailto.plus");

	    TreeMap<String, String> s18 = new TreeMap<>();
	    s18.put("Staff First Name", "Staff Elaric");
	    s18.put("Staff Middle Name", "Nadine");
	    s18.put("Staff Last Name", "Hawkridge");
	    s18.put("Staff Name Suffix", "III");
	    s18.put("Staff Phone", "6475820936");
	    s18.put("Staff Office phone", "6479046112");
	    s18.put("Staff Email", "staff.elaric.hawkridge36@mailto.plus");

	    TreeMap<String, String> s19 = new TreeMap<>();
	    s19.put("Staff First Name", "Staff Mireven");
	    s19.put("Staff Middle Name", "Caspian");
	    s19.put("Staff Last Name", "Alderwyn");
	    s19.put("Staff Name Suffix", "Sr");
	    s19.put("Staff Phone", "4167392501");
	    s19.put("Staff Office phone", "4169074385");
	    s19.put("Staff Email", "staff.mireven.alderwyn01@mailto.plus");

	    TreeMap<String, String> s20 = new TreeMap<>();
	    s20.put("Staff First Name", "Staff Coralie");
	    s20.put("Staff Middle Name", "Marcellin");
	    s20.put("Staff Last Name", "Ashbourne");
	    s20.put("Staff Name Suffix", "IV");
	    s20.put("Staff Phone", "5146039817");
	    s20.put("Staff Office phone", "5149057249");
	    s20.put("Staff Email", "staff.coralie.ashbourne17@mailto.plus");

	    return new Object[][]{
	        {s1},{s2},{s3},{s4},{s5},
	        {s6},{s7},{s8},{s9},{s10},
	        {s11},{s12},{s13},{s14},{s15},
	        {s16},{s17},{s18},{s19},{s20} 
	    };
	}


	@DataProvider
	public Object[][] law_plus_attorney(){
		
		
		Law_Firm_Module lfm = new Law_Firm_Module();
		
		Object[][] attorney_datas = attorneyfData();
		Object[][] law_firm_data = lfm.lawFirmData();
		Object[][] Staff_datas = Staff_data();
		
		int n = Math.min(attorney_datas.length,Math.min(law_firm_data.length, Staff_datas.length));
		Object[][] final_set = new Object[n][3];
		
		for(int i=0;i<n;i++){
			   final_set[i][0] = attorney_datas[i][0];      
		       final_set[i][1] = law_firm_data[i][0]; 
		       final_set[i][2] = Staff_datas[i][0]; 
		    }
		    return final_set;
		
		
	}

}
