package Enterprise_Codeclouds.Project.Enterprise;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
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
	
	
	
	public void Atttorney_Add_through_case(TreeMap<String, String> data,TreeMap<String, String> law_firm,TreeMap<String, String> staff,WebDriver d) throws IOException, InterruptedException{
		
		SIde_Menu_Handler sd = new SIde_Menu_Handler();
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		Login_Locaters lg = new Login_Locaters(d);
	
/*	WebElement Create_Contact;
	//try{
		Create_Contact = p.Create_Contact_button();
		
		//} */
	
	
	/*
		catch(Exception not_inside_case_contact_list)
		{
		sd.Side_menu_option_clicker("Applications", d,"N/A");
		p.landed_in_applicationList_confirmation();	
		p.rows().get(1).click();
		Thread.sleep(800);
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
		} */
	
	
	
	
		
		
		WebElement	Create_Contact = p.Create_Contact_button();
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
			Login_negative_testcases.Toast_printer(taost);
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
	    a1.put("First Name", "Attorney Cailen");
	    a1.put("Middle Name", "Voren");
	    a1.put("Last Name", "Ashbourne");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "9724186307");
	    a1.put("Office phone", "9727719046");
	    a1.put("Email", "attorney.cailen.ashbourne61@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<>();
	    a2.put("First Name", "Attorney Mireya");
	    a2.put("Middle Name", "Solenne");
	    a2.put("Last Name", "Hawkridge");
	    a2.put("Name Suffix", "Jr");
	    a2.put("Phone", "6195837421");
	    a2.put("Office phone", "6198062954");
	    a2.put("Email", "attorney.mireya.hawkridge74@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<>();
	    a3.put("First Name", "Attorney Renzo");
	    a3.put("Middle Name", "Calder");
	    a3.put("Last Name", "Wytherby");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "4152679038");
	    a3.put("Office phone", "4157402269");
	    a3.put("Email", "attorney.renzo.wytherby38@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<>();
	    a4.put("First Name", "Attorney Eirwyn");
	    a4.put("Middle Name", "Marcelle");
	    a4.put("Last Name", "Dunleavy");
	    a4.put("Name Suffix", "Sr");
	    a4.put("Phone", "2063915742");
	    a4.put("Office phone", "2068051137");
	    a4.put("Email", "attorney.eirwyn.dunleavy52@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<>();
	    a5.put("First Name", "Attorney Soren");
	    a5.put("Middle Name", "Quillon");
	    a5.put("Last Name", "Falkner");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "3036184950");
	    a5.put("Office phone", "3039026814");
	    a5.put("Email", "attorney.soren.falkner90@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<>();
	    a6.put("First Name", "Attorney Liora");
	    a6.put("Middle Name", "Nadine");
	    a6.put("Last Name", "Kensleigh");
	    a6.put("Name Suffix", "II");
	    a6.put("Phone", "5127391068");
	    a6.put("Office phone", "5128846031");
	    a6.put("Email", "attorney.liora.kensleigh68@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<>();
	    a7.put("First Name", "Attorney Tavish");
	    a7.put("Middle Name", "Elio");
	    a7.put("Last Name", "Brackenwell");
	    a7.put("Name Suffix", "Jr");
	    a7.put("Phone", "7042659813");
	    a7.put("Office phone", "7048305746");
	    a7.put("Email", "attorney.tavish.brackenwell13@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<>();
	    a8.put("First Name", "Attorney Kaori");
	    a8.put("Middle Name", "Yseult");
	    a8.put("Last Name", "Wetherell");
	    a8.put("Name Suffix", "III");
	    a8.put("Phone", "6174827609");
	    a8.put("Office phone", "6179053182");
	    a8.put("Email", "attorney.kaori.wetherell09@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<>();
	    a9.put("First Name", "Attorney Niall");
	    a9.put("Middle Name", "Pascal");
	    a9.put("Last Name", "Ravenhurst");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "6473168025");
	    a9.put("Office phone", "6479041578");
	    a9.put("Email", "attorney.niall.ravenhurst25@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<>();
	    a10.put("First Name", "Attorney Elara");
	    a10.put("Middle Name", "Giselle");
	    a10.put("Last Name", "Montclair");
	    a10.put("Name Suffix", "IV");
	    a10.put("Phone", "9054281673");
	    a10.put("Office phone", "9057902461");
	    a10.put("Email", "attorney.elara.montclair73@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<>();
	    a11.put("First Name", "Attorney Ivo");
	    a11.put("Middle Name", "Caspian");
	    a11.put("Last Name", "Hollingmere");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "4165972308");
	    a11.put("Office phone", "4168804159");
	    a11.put("Email", "attorney.ivo.hollingmere08@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<>();
	    a12.put("First Name", "Attorney Maelle");
	    a12.put("Middle Name", "Rhiannon");
	    a12.put("Last Name", "Briarwick");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "5143726819");
	    a12.put("Office phone", "5149057732");
	    a12.put("Email", "attorney.maelle.briarwick19@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<>();
	    a13.put("First Name", "Attorney Darius");
	    a13.put("Middle Name", "Thorne");
	    a13.put("Last Name", "Kingswell");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "4036189724");
	    a13.put("Office phone", "4039041268");
	    a13.put("Email", "attorney.darius.kingswell24@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<>();
	    a14.put("First Name", "Attorney Selene");
	    a14.put("Middle Name", "Marin");
	    a14.put("Last Name", "Quarryn");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "6042758146");
	    a14.put("Office phone", "6049083417");
	    a14.put("Email", "attorney.selene.quarryn46@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<>();
	    a15.put("First Name", "Attorney Orin");
	    a15.put("Middle Name", "Lucien");
	    a15.put("Last Name", "Ambervale");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "7804165092");
	    a15.put("Office phone", "7809026371");
	    a15.put("Email", "attorney.orin.ambervale92@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<>();
	    a16.put("First Name", "Attorney Nyra");
	    a16.put("Middle Name", "Celeste");
	    a16.put("Last Name", "Stormley");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "2895718304");
	    a16.put("Office phone", "2899071446");
	    a16.put("Email", "attorney.nyra.stormley04@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<>();
	    a17.put("First Name", "Attorney Kellan");
	    a17.put("Middle Name", "Benoit");
	    a17.put("Last Name", "Alderwyn");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "5192837461");
	    a17.put("Office phone", "5199046285");
	    a17.put("Email", "attorney.kellan.alderwyn61@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<>();
	    a18.put("First Name", "Attorney Vesper");
	    a18.put("Middle Name", "Noemi");
	    a18.put("Last Name", "Kestwick");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "6134907258");
	    a18.put("Office phone", "6139083624");
	    a18.put("Email", "attorney.vesper.kestwick58@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<>();
	    a19.put("First Name", "Attorney Rhea");
	    a19.put("Middle Name", "Odette");
	    a19.put("Last Name", "Harrowby");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "9053628149");
	    a19.put("Office phone", "9059075213");
	    a19.put("Email", "attorney.rhea.harrowby49@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<>();
	    a20.put("First Name", "Attorney Leif");
	    a20.put("Middle Name", "Quentin");
	    a20.put("Last Name", "Valewood");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "6475081936");
	    a20.put("Office phone", "6479047761");
	    a20.put("Email", "attorney.leif.valewood36@mailto.plus");

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
