package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	sd.Side_menu_option_clicker("Firm & Counsel",d,"Attorney");	
	pp.Landed_in_attorney_module();	
	rp.Scroll_to_element(p.form());
	Thread.sleep(800);	
	List<WebElement> input_feilds=p.inputs();	
	input_feilds.get(0).clear();
	input_feilds.get(0).sendKeys(Law_Firm);;
	ap.plaintiff_dropdown_list();
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
	Add_staff_button.click();
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
	}
	
	
	@Test(dataProvider="law_plus_attorney")
	public void Atttorney_Add_through_case(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		Login_Locaters lg = new Login_Locaters(d);
	
	WebElement Create_Contact;
	try{Create_Contact = p.Create_Contact_button();}
	catch(Exception not_inside_case_contact_list){
		sd.Side_menu_option_clicker("Applications", d,"N/A");
		p.landed_in_applicationList_confirmation();	
		p.rows().get(1).click();
		Thread.sleep(800);}	
	List<WebElement> Case_Tags;
	   try {
	   Case_Tags = p.Case_tags();}
	   catch(RuntimeException tags){
		   System.out.println("RuntimeException Found in case tags fetching thereby retrying");
		   System.out.println();
		   Thread.sleep(1200);
		   Case_Tags = p.Case_tags(); }
	    tab_selector("Contacts");
		p.lawFirm_AddButton_ContactTab();
		rp.Scroll_to_element(p.Contact_AddButton_ContactTab());
		p.Contact_AddButton_ContactTab().click();
		p.Contact_type_dropdown_list();
		List<WebElement> Contact_Options = p.Contact_type_Options();
		for(WebElement Cn_opt:Contact_Options){
		if(Cn_opt.getText().trim().equalsIgnoreCase("Attorney")){
				Cn_opt.click();
				break;}}
		p.pop_up_contact_list();
		Thread.sleep(800);
		p.Popup_modal_search().sendKeys(data.get("First Name"));
		Thread.sleep(800);
		WebElement toast = lg.toast();
		rp.wait_for_invisibility(toast);
		try {
		p.List_Checkboxes().get(0).click();}
		catch(Exception attorney_searched_not_present){
			WebElement CreateContact = p.Create_Contact_button();
			rp.Scroll_to_element(CreateContact);
			CreateContact.click();
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
			attorney_inputs.get(7).sendKeys(data.get("Email"));
			WebElement Add_staff_button= p.second_popup_form_buttons().get(1);
			Add_staff_button.click();
			List<WebElement> fields = p.Third_popup_form_inputs();
			WebElement Staff_pop_up_form = p.Third_popup_form();
			WebElement Staff_Add_button= p.Third_popup_form_buttons().get(1);
			staff_add(staff,fields,Staff_pop_up_form,Staff_Add_button);
			WebElement Add_Attorney_Button=p.second_popup_form_buttons().get(2);
			rp.Scroll_to_element(Add_Attorney_Button);
			Add_Attorney_Button.click();
			Thread.sleep(800);	
			String taost= lg.toast().getText().trim();
			Login_negative_testcases.Toast_printer(taost);}
		Thread.sleep(600);}
	
	
	public void staff_add(TreeMap<String, String> data,List<WebElement>Form_fields,WebElement pop_up_form,WebElement Submit_button){
		
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		
		
		
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
		rp.wait_for_invisibility(pop_up_form);
	}
	
	
	@DataProvider
	public Object[][] attorneyfData() {

	    TreeMap<String, String> a1 = new TreeMap<>();
	    a1.put("First Name", "Attorney Veylinor");
	    a1.put("Middle Name", "Arquen");
	    a1.put("Last Name", "Solbray");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "9817706101");
	    a1.put("Office phone", "9818807101");
	    a1.put("Email", "attorney.veylinor.solbray.k1p4@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<>();
	    a2.put("First Name", "Attorney Nyveria");
	    a2.put("Middle Name", "Selmora");
	    a2.put("Last Name", "Kestrow");
	    a2.put("Name Suffix", "Jr");
	    a2.put("Phone", "9817706102");
	    a2.put("Office phone", "9818807102");
	    a2.put("Email", "attorney.nyveria.kestrow.m7t2@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<>();
	    a3.put("First Name", "Attorney Corvantis");
	    a3.put("Middle Name", "Rhaelor");
	    a3.put("Last Name", "Drexmont");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9817706103");
	    a3.put("Office phone", "9818807103");
	    a3.put("Email", "attorney.corvantis.drexmont.p3c8@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<>();
	    a4.put("First Name", "Attorney Elowrynn");
	    a4.put("Middle Name", "Nivessa");
	    a4.put("Last Name", "Orwindell");
	    a4.put("Name Suffix", "Sr");
	    a4.put("Phone", "9817706104");
	    a4.put("Office phone", "9818807104");
	    a4.put("Email", "attorney.elowrynn.orwindell.q9h1@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<>();
	    a5.put("First Name", "Attorney Bravion");
	    a5.put("Middle Name", "Lucayne");
	    a5.put("Last Name", "Thornwick");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "9817706105");
	    a5.put("Office phone", "9818807105");
	    a5.put("Email", "attorney.bravion.thornwick.r4n6@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<>();
	    a6.put("First Name", "Attorney Kaelindra");
	    a6.put("Middle Name", "Junaria");
	    a6.put("Last Name", "Sablemere");
	    a6.put("Name Suffix", "II");
	    a6.put("Phone", "9817706106");
	    a6.put("Office phone", "9818807106");
	    a6.put("Email", "attorney.kaelindra.sablemere.v2d7@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<>();
	    a7.put("First Name", "Attorney Tressan");
	    a7.put("Middle Name", "Kestovar");
	    a7.put("Last Name", "Myridane");
	    a7.put("Name Suffix", "Jr");
	    a7.put("Phone", "9817706107");
	    a7.put("Office phone", "9818807107");
	    a7.put("Email", "attorney.tressan.myridane.s8k0@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<>();
	    a8.put("First Name", "Attorney Heliovana");
	    a8.put("Middle Name", "Sylphene");
	    a8.put("Last Name", "Wexforde");
	    a8.put("Name Suffix", "III");
	    a8.put("Phone", "9817706108");
	    a8.put("Office phone", "9818807108");
	    a8.put("Email", "attorney.heliovana.wexforde.y5u3@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<>();
	    a9.put("First Name", "Attorney Iskariel");
	    a9.put("Middle Name", "Vespera");
	    a9.put("Last Name", "Crownmire");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "9817706109");
	    a9.put("Office phone", "9818807109");
	    a9.put("Email", "attorney.iskariel.crownmire.z1q9@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<>();
	    a10.put("First Name", "Attorney Jorvellan");
	    a10.put("Middle Name", "Rheomir");
	    a10.put("Last Name", "Zephyrwyn");
	    a10.put("Name Suffix", "IV");
	    a10.put("Phone", "9817706110");
	    a10.put("Office phone", "9818807110");
	    a10.put("Email", "attorney.jorvellan.zephyrwyn.b7m2@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<>();
	    a11.put("First Name", "Attorney Viorenna");
	    a11.put("Middle Name", "Quintessa");
	    a11.put("Last Name", "Ravenholt");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "9817706111");
	    a11.put("Office phone", "9818807111");
	    a11.put("Email", "attorney.viorenna.ravenholt.c6t8@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<>();
	    a12.put("First Name", "Attorney Lysandor");
	    a12.put("Middle Name", "Mirelle");
	    a12.put("Last Name", "Obsidianvale");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "9817706112");
	    a12.put("Office phone", "9818807112");
	    a12.put("Email", "attorney.lysandor.obsidianvale.f3r1@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<>();
	    a13.put("First Name", "Attorney Marivane");
	    a13.put("Middle Name", "Talarin");
	    a13.put("Last Name", "Hollowmere");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "9817706113");
	    a13.put("Office phone", "9818807113");
	    a13.put("Email", "attorney.marivane.hollowmere.n8p5@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<>();
	    a14.put("First Name", "Attorney Nyxaline");
	    a14.put("Middle Name", "Demeris");
	    a14.put("Last Name", "Frostwarden");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "9817706114");
	    a14.put("Office phone", "9818807114");
	    a14.put("Email", "attorney.nyxaline.frostwarden.s0v6@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<>();
	    a15.put("First Name", "Attorney Orphira");
	    a15.put("Middle Name", "Peregrin");
	    a15.put("Last Name", "Cindervaux");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "9817706115");
	    a15.put("Office phone", "9818807115");
	    a15.put("Email", "attorney.orphira.cindervaux.g2h7@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<>();
	    a16.put("First Name", "Attorney Quorinel");
	    a16.put("Middle Name", "Vallorin");
	    a16.put("Last Name", "Stormbriar");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "9817706116");
	    a16.put("Office phone", "9818807116");
	    a16.put("Email", "attorney.quorinel.stormbriar.j4x0@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<>();
	    a17.put("First Name", "Attorney Rivenna");
	    a17.put("Middle Name", "Caelith");
	    a17.put("Last Name", "Marblewyn");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "9817706117");
	    a17.put("Office phone", "9818807117");
	    a17.put("Email", "attorney.rivenna.marblewyn.l9q3@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<>();
	    a18.put("First Name", "Attorney Seredane");
	    a18.put("Middle Name", "Zorion");
	    a18.put("Last Name", "Kleinmere");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "9817706118");
	    a18.put("Office phone", "9818807118");
	    a18.put("Email", "attorney.seredane.kleinmere.v1n9@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<>();
	    a19.put("First Name", "Attorney Talvior");
	    a19.put("Middle Name", "Vionette");
	    a19.put("Last Name", "Quillhollow");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "9817706119");
	    a19.put("Office phone", "9818807119");
	    a19.put("Email", "attorney.talvior.quillhollow.d7m4@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<>();
	    a20.put("First Name", "Attorney Wulferen");
	    a20.put("Middle Name", "Ysolde");
	    a20.put("Last Name", "Briarnoct");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "9817706120");
	    a20.put("Office phone", "9818807120");
	    a20.put("Email", "attorney.wulferen.briarnoct.p5k8@mailto.plus");

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
	    s1.put("Staff First Name", "Staff Kaiven");
	    s1.put("Staff Middle Name", "Orlin");
	    s1.put("Staff Last Name", "Briarlock");
	    s1.put("Staff Name Suffix", "II");
	    s1.put("Staff Phone", "9726608101");
	    s1.put("Staff Office phone", "9727709101");
	    s1.put("Staff Email", "staff.kaiven.briarlock.a1m7@mailto.plus");

	    TreeMap<String, String> s2 = new TreeMap<>();
	    s2.put("Staff First Name", "Staff Nysha");
	    s2.put("Staff Middle Name", "Elara");
	    s2.put("Staff Last Name", "Fenchase");
	    s2.put("Staff Name Suffix", "Jr");
	    s2.put("Staff Phone", "9726608102");
	    s2.put("Staff Office phone", "9727709102");
	    s2.put("Staff Email", "staff.nysha.fenchase.b8q2@mailto.plus");

	    TreeMap<String, String> s3 = new TreeMap<>();
	    s3.put("Staff First Name", "Staff Corwin");
	    s3.put("Staff Middle Name", "Blaise");
	    s3.put("Staff Last Name", "Ashgrove");
	    s3.put("Staff Name Suffix", "III");
	    s3.put("Staff Phone", "9726608103");
	    s3.put("Staff Office phone", "9727709103");
	    s3.put("Staff Email", "staff.corwin.ashgrove.c3t9@mailto.plus");

	    TreeMap<String, String> s4 = new TreeMap<>();
	    s4.put("Staff First Name", "Staff Eleni");
	    s4.put("Staff Middle Name", "Sabine");
	    s4.put("Staff Last Name", "Northwick");
	    s4.put("Staff Name Suffix", "Sr");
	    s4.put("Staff Phone", "9726608104");
	    s4.put("Staff Office phone", "9727709104");
	    s4.put("Staff Email", "staff.eleni.northwick.d6p1@mailto.plus");

	    TreeMap<String, String> s5 = new TreeMap<>();
	    s5.put("Staff First Name", "Staff Viren");
	    s5.put("Staff Middle Name", "Hugo");
	    s5.put("Staff Last Name", "Stormwell");
	    s5.put("Staff Name Suffix", "IV");
	    s5.put("Staff Phone", "9726608105");
	    s5.put("Staff Office phone", "9727709105");
	    s5.put("Staff Email", "staff.viren.stormwell.e4k8@mailto.plus");

	    TreeMap<String, String> s6 = new TreeMap<>();
	    s6.put("Staff First Name", "Staff Mireya");
	    s6.put("Staff Middle Name", "Noelle");
	    s6.put("Staff Last Name", "Silverfen");
	    s6.put("Staff Name Suffix", "II");
	    s6.put("Staff Phone", "9726608106");
	    s6.put("Staff Office phone", "9727709106");
	    s6.put("Staff Email", "staff.mireya.silverfen.f2r6@mailto.plus");

	    TreeMap<String, String> s7 = new TreeMap<>();
	    s7.put("Staff First Name", "Staff Rowan");
	    s7.put("Staff Middle Name", "Caius");
	    s7.put("Staff Last Name", "Hearthmere");
	    s7.put("Staff Name Suffix", "Jr");
	    s7.put("Staff Phone", "9726608107");
	    s7.put("Staff Office phone", "9727709107");
	    s7.put("Staff Email", "staff.rowan.hearthmere.g9n3@mailto.plus");

	    TreeMap<String, String> s8 = new TreeMap<>();
	    s8.put("Staff First Name", "Staff Inaya");
	    s8.put("Staff Middle Name", "Rumi");
	    s8.put("Staff Last Name", "Cedarwyn");
	    s8.put("Staff Name Suffix", "III");
	    s8.put("Staff Phone", "9726608108");
	    s8.put("Staff Office phone", "9727709108");
	    s8.put("Staff Email", "staff.inaya.cedarwyn.h7x0@mailto.plus");

	    TreeMap<String, String> s9 = new TreeMap<>();
	    s9.put("Staff First Name", "Staff Tamsin");
	    s9.put("Staff Middle Name", "Odessa");
	    s9.put("Staff Last Name", "Foxharbor");
	    s9.put("Staff Name Suffix", "Sr");
	    s9.put("Staff Phone", "9726608109");
	    s9.put("Staff Office phone", "9727709109");
	    s9.put("Staff Email", "staff.tamsin.foxharbor.j1v5@mailto.plus");

	    TreeMap<String, String> s10 = new TreeMap<>();
	    s10.put("Staff First Name", "Staff Darian");
	    s10.put("Staff Middle Name", "Soren");
	    s10.put("Staff Last Name", "Waveridge");
	    s10.put("Staff Name Suffix", "IV");
	    s10.put("Staff Phone", "9726608110");
	    s10.put("Staff Office phone", "9727709110");
	    s10.put("Staff Email", "staff.darian.waveridge.k4q7@mailto.plus");

	    TreeMap<String, String> s11 = new TreeMap<>();
	    s11.put("Staff First Name", "Staff Selene");
	    s11.put("Staff Middle Name", "Marisol");
	    s11.put("Staff Last Name", "Stonehollow");
	    s11.put("Staff Name Suffix", "II");
	    s11.put("Staff Phone", "9726608111");
	    s11.put("Staff Office phone", "9727709111");
	    s11.put("Staff Email", "staff.selene.stonehollow.l8m2@mailto.plus");

	    TreeMap<String, String> s12 = new TreeMap<>();
	    s12.put("Staff First Name", "Staff Ethan");
	    s12.put("Staff Middle Name", "Calder");
	    s12.put("Staff Last Name", "Goldbriar");
	    s12.put("Staff Name Suffix", "Jr");
	    s12.put("Staff Phone", "9726608112");
	    s12.put("Staff Office phone", "9727709112");
	    s12.put("Staff Email", "staff.ethan.goldbriar.m5t1@mailto.plus");

	    TreeMap<String, String> s13 = new TreeMap<>();
	    s13.put("Staff First Name", "Staff Zara");
	    s13.put("Staff Middle Name", "Imani");
	    s13.put("Staff Last Name", "Moonridge");
	    s13.put("Staff Name Suffix", "III");
	    s13.put("Staff Phone", "9726608113");
	    s13.put("Staff Office phone", "9727709113");
	    s13.put("Staff Email", "staff.zara.moonridge.n0p9@mailto.plus");

	    TreeMap<String, String> s14 = new TreeMap<>();
	    s14.put("Staff First Name", "Staff Mateo");
	    s14.put("Staff Middle Name", "Julian");
	    s14.put("Staff Last Name", "Ridgeford");
	    s14.put("Staff Name Suffix", "Sr");
	    s14.put("Staff Phone", "9726608114");
	    s14.put("Staff Office phone", "9727709114");
	    s14.put("Staff Email", "staff.mateo.ridgeford.p3c6@mailto.plus");

	    TreeMap<String, String> s15 = new TreeMap<>();
	    s15.put("Staff First Name", "Staff Hana");
	    s15.put("Staff Middle Name", "Sakura");
	    s15.put("Staff Last Name", "Evermoor");
	    s15.put("Staff Name Suffix", "IV");
	    s15.put("Staff Phone", "9726608115");
	    s15.put("Staff Office phone", "9727709115");
	    s15.put("Staff Email", "staff.hana.evermoor.q7h2@mailto.plus");

	    TreeMap<String, String> s16 = new TreeMap<>();
	    s16.put("Staff First Name", "Staff Kendall");
	    s16.put("Staff Middle Name", "Brielle");
	    s16.put("Staff Last Name", "Crownfield");
	    s16.put("Staff Name Suffix", "II");
	    s16.put("Staff Phone", "9726608116");
	    s16.put("Staff Office phone", "9727709116");
	    s16.put("Staff Email", "staff.kendall.crownfield.r2n8@mailto.plus");

	    TreeMap<String, String> s17 = new TreeMap<>();
	    s17.put("Staff First Name", "Staff Elowen");
	    s17.put("Staff Middle Name", "Simone");
	    s17.put("Staff Last Name", "Frostwick");
	    s17.put("Staff Name Suffix", "Jr");
	    s17.put("Staff Phone", "9726608117");
	    s17.put("Staff Office phone", "9727709117");
	    s17.put("Staff Email", "staff.elowen.frostwick.s6k4@mailto.plus");

	    TreeMap<String, String> s18 = new TreeMap<>();
	    s18.put("Staff First Name", "Staff Noah");
	    s18.put("Staff Middle Name", "Elias");
	    s18.put("Staff Last Name", "Harborwyn");
	    s18.put("Staff Name Suffix", "III");
	    s18.put("Staff Phone", "9726608118");
	    s18.put("Staff Office phone", "9727709118");
	    s18.put("Staff Email", "staff.noah.harborwyn.t1d7@mailto.plus");

	    TreeMap<String, String> s19 = new TreeMap<>();
	    s19.put("Staff First Name", "Staff Celine");
	    s19.put("Staff Middle Name", "Faye");
	    s19.put("Staff Last Name", "Wilderbrook");
	    s19.put("Staff Name Suffix", "Sr");
	    s19.put("Staff Phone", "9726608119");
	    s19.put("Staff Office phone", "9727709119");
	    s19.put("Staff Email", "staff.celine.wilderbrook.v9x3@mailto.plus");

	    TreeMap<String, String> s20 = new TreeMap<>();
	    s20.put("Staff First Name", "Staff Aria");
	    s20.put("Staff Middle Name", "Celina");
	    s20.put("Staff Last Name", "Thornhaven");
	    s20.put("Staff Name Suffix", "IV");
	    s20.put("Staff Phone", "9726608120");
	    s20.put("Staff Office phone", "9727709120");
	    s20.put("Staff Email", "staff.aria.thornhaven.w4q0@mailto.plus");

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
