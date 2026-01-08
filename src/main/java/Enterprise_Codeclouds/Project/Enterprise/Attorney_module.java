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
	staff_add(staff,Add_staff_button);
	WebElement Add_Attorney_Button=p.form_buttons().get(2);
	rp.Scroll_to_element(Add_Attorney_Button);
	Add_Attorney_Button.click();
	Thread.sleep(800);	
	String taost= lg.toast().getText().trim();
	Login_negative_testcases.Toast_printer(taost);
	}
	
	
	public void staff_add(TreeMap<String, String> data,WebElement button){
		
		Application_Locaters p = new Application_Locaters(d);
		Repeat rp = new Repeat(d);
		
		button.click();
		List<WebElement> fields = p.form_inputs();
		fields.get(0).sendKeys(data.get("Staff First Name"));
		fields.get(1).sendKeys(data.get("Staff Middle Name"));
		fields.get(2).sendKeys(data.get("Staff Last Name"));
		fields.get(3).sendKeys(data.get("Staff Name Suffix"));
		fields.get(4).sendKeys(data.get("Staff Phone"));
		fields.get(5).sendKeys(data.get("Staff Office phone"));
		fields.get(6).sendKeys(data.get("Staff Email"));
		WebElement Add_button= p.form_buttons().get(1);
		Add_button.click();
		rp.wait_for_invisibility(p.Popup_add_form());
	}
	
	
	@DataProvider
	public Object[][] attorneyfData() {

		TreeMap<String, String> a1 = new TreeMap<>();
	    a1.put("First Name", "Attorney Axiomara");
	    a1.put("Middle Name", "Velun");
	    a1.put("Last Name", "Thornabyss");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "9551307601");
	    a1.put("Office phone", "9551318801");
	    a1.put("Email", "attorney.axiomara.thornabyss.q7lz4p2n@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<>();
	    a2.put("First Name", "Attorney Brontelius");
	    a2.put("Middle Name", "Caerwyn");
	    a2.put("Last Name", "Wickharrow");
	    a2.put("Name Suffix", "Jr");
	    a2.put("Phone", "9551307602");
	    a2.put("Office phone", "9551318802");
	    a2.put("Email", "attorney.brontelius.wickharrow.m3t9kq8v@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<>();
	    a3.put("First Name", "Attorney Celandrine");
	    a3.put("Middle Name", "Orvessa");
	    a3.put("Last Name", "Glassmoraine");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9551307603");
	    a3.put("Office phone", "9551318803");
	    a3.put("Email", "attorney.celandrine.glassmoraine.r8y1v6jd@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<>();
	    a4.put("First Name", "Attorney Dromedon");
	    a4.put("Middle Name", "Halrix");
	    a4.put("Last Name", "Sablequay");
	    a4.put("Name Suffix", "Sr");
	    a4.put("Phone", "9551307604");
	    a4.put("Office phone", "9551318804");
	    a4.put("Email", "attorney.dromedon.sablequay.p2n7cx5m@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<>();
	    a5.put("First Name", "Attorney Elarisette");
	    a5.put("Middle Name", "Junor");
	    a5.put("Last Name", "Runeviaduct");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "9551307605");
	    a5.put("Office phone", "9551318805");
	    a5.put("Email", "attorney.elarisette.runeviaduct.z6h3q0wt@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<>();
	    a6.put("First Name", "Attorney Fennorik");
	    a6.put("Middle Name", "Mirelle");
	    a6.put("Last Name", "Ironlattice");
	    a6.put("Name Suffix", "II");
	    a6.put("Phone", "9551307606");
	    a6.put("Office phone", "9551318806");
	    a6.put("Email", "attorney.fennorik.ironlattice.b9x4m1qa@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<>();
	    a7.put("First Name", "Attorney Gossamira");
	    a7.put("Middle Name", "Selthic");
	    a7.put("Last Name", "Cinderfjord");
	    a7.put("Name Suffix", "Jr");
	    a7.put("Phone", "9551307607");
	    a7.put("Office phone", "9551318807");
	    a7.put("Email", "attorney.gossamira.cinderfjord.k5u8r2vn@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<>();
	    a8.put("First Name", "Attorney Heliovar");
	    a8.put("Middle Name", "Quillane");
	    a8.put("Last Name", "Oakhollow");
	    a8.put("Name Suffix", "III");
	    a8.put("Phone", "9551307608");
	    a8.put("Office phone", "9551318808");
	    a8.put("Email", "attorney.heliovar.oakhollow.t1c7z9ph@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<>();
	    a9.put("First Name", "Attorney Ivernael");
	    a9.put("Middle Name", "Vosslyn");
	    a9.put("Last Name", "Marbletide");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "9551307609");
	    a9.put("Office phone", "9551318809");
	    a9.put("Email", "attorney.ivernael.marbletide.d4m6k8sx@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<>();
	    a10.put("First Name", "Attorney Jasporyn");
	    a10.put("Middle Name", "Rhalor");
	    a10.put("Last Name", "Briarkeel");
	    a10.put("Name Suffix", "IV");
	    a10.put("Phone", "9551307610");
	    a10.put("Office phone", "9551318810");
	    a10.put("Email", "attorney.jasporyn.briarkeel.n7q2v5ld@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<>();
	    a11.put("First Name", "Attorney Kalythra");
	    a11.put("Middle Name", "Eldren");
	    a11.put("Last Name", "Stormvellum");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "9551307611");
	    a11.put("Office phone", "9551318811");
	    a11.put("Email", "attorney.kalythra.stormvellum.s0w9c3ja@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<>();
	    a12.put("First Name", "Attorney Lumerick");
	    a12.put("Middle Name", "Perevin");
	    a12.put("Last Name", "Gildedcairn");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "9551307612");
	    a12.put("Office phone", "9551318812");
	    a12.put("Email", "attorney.lumerick.gildedcairn.f6t1r8vb@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<>();
	    a13.put("First Name", "Attorney Marnessa");
	    a13.put("Middle Name", "Quenric");
	    a13.put("Last Name", "Ashviolin");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "9551307613");
	    a13.put("Office phone", "9551318813");
	    a13.put("Email", "attorney.marnessa.ashviolin.h3p7x0km@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<>();
	    a14.put("First Name", "Attorney Norellius");
	    a14.put("Middle Name", "Sableen");
	    a14.put("Last Name", "Riveranvil");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "9551307614");
	    a14.put("Office phone", "9551318814");
	    a14.put("Email", "attorney.norellius.riveranvil.j9m2q6cw@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<>();
	    a15.put("First Name", "Attorney Odramira");
	    a15.put("Middle Name", "Velorin");
	    a15.put("Last Name", "Frostcantle");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "9551307615");
	    a15.put("Office phone", "9551318815");
	    a15.put("Email", "attorney.odramira.frostcantle.v2k8n4rz@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<>();
	    a16.put("First Name", "Attorney Prysmond");
	    a16.put("Middle Name", "Calith");
	    a16.put("Last Name", "Obsidianwharf");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "9551307616");
	    a16.put("Office phone", "9551318816");
	    a16.put("Email", "attorney.prysmond.obsidianwharf.q5d1t7xy@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<>();
	    a17.put("First Name", "Attorney Quenvara");
	    a17.put("Middle Name", "Mireth");
	    a17.put("Last Name", "Cobaltgrove");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "9551307617");
	    a17.put("Office phone", "9551318817");
	    a17.put("Email", "attorney.quenvara.cobaltgrove.w8h0p3nl@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<>();
	    a18.put("First Name", "Attorney Ravelion");
	    a18.put("Middle Name", "Zorrel");
	    a18.put("Last Name", "Hearthglaive");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "9551307618");
	    a18.put("Office phone", "9551318818");
	    a18.put("Email", "attorney.ravelion.hearthglaive.c1s6v9qd@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<>();
	    a19.put("First Name", "Attorney Sorynthia");
	    a19.put("Middle Name", "Eldessa");
	    a19.put("Last Name", "Violetcauseway");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "9551307619");
	    a19.put("Office phone", "9551318819");
	    a19.put("Email", "attorney.sorynthia.violetcauseway.m7q4k2tz@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<>();
	    a20.put("First Name", "Attorney Tovinelle");
	    a20.put("Middle Name", "Rhaelis");
	    a20.put("Last Name", "Saffronbreak");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "9551307620");
	    a20.put("Office phone", "9551318820");
	    a20.put("Email", "attorney.tovinelle.saffronbreak.z0x8n5pr@mailto.plus");

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
	    s1.put("Staff First Name", "Staff Zephyrella");
	    s1.put("Staff Middle Name", "Quorinza");
	    s1.put("Staff Last Name", "Vexelmont");
	    s1.put("Staff Name Suffix", "II");
	    s1.put("Staff Phone", "9794317601");
	    s1.put("Staff Office phone", "9794328601");
	    s1.put("Staff Email", "staff.zephyrella.vexelmont.r8q1mz@mailto.plus");

	    TreeMap<String, String> s2 = new TreeMap<>();
	    s2.put("Staff First Name", "Staff Dravionne");
	    s2.put("Staff Middle Name", "Selvayna");
	    s2.put("Staff Last Name", "Kryndelair");
	    s2.put("Staff Name Suffix", "Jr");
	    s2.put("Staff Phone", "9794317602");
	    s2.put("Staff Office phone", "9794328602");
	    s2.put("Staff Email", "staff.dravionne.kryndelair.t2v7kp@mailto.plus");

	    TreeMap<String, String> s3 = new TreeMap<>();
	    s3.put("Staff First Name", "Staff Caelthorin");
	    s3.put("Staff Middle Name", "Rhaemiro");
	    s3.put("Staff Last Name", "Draxenwick");
	    s3.put("Staff Name Suffix", "III");
	    s3.put("Staff Phone", "9794317603");
	    s3.put("Staff Office phone", "9794328603");
	    s3.put("Staff Email", "staff.caelthorin.draxenwick.p4c9nd@mailto.plus");

	    TreeMap<String, String> s4 = new TreeMap<>();
	    s4.put("Staff First Name", "Staff Nymeravia");
	    s4.put("Staff Middle Name", "Vesperin");
	    s4.put("Staff Last Name", "Orrisvale");
	    s4.put("Staff Name Suffix", "Sr");
	    s4.put("Staff Phone", "9794317604");
	    s4.put("Staff Office phone", "9794328604");
	    s4.put("Staff Email", "staff.nymeravia.orrisvale.z6n3ga@mailto.plus");

	    TreeMap<String, String> s5 = new TreeMap<>();
	    s5.put("Staff First Name", "Staff Elyndoriel");
	    s5.put("Staff Middle Name", "Lucavere");
	    s5.put("Staff Last Name", "Thornquarry");
	    s5.put("Staff Name Suffix", "IV");
	    s5.put("Staff Phone", "9794317605");
	    s5.put("Staff Office phone", "9794328605");
	    s5.put("Staff Email", "staff.elyndoriel.thornquarry.h4x9jq@mailto.plus");

	    TreeMap<String, String> s6 = new TreeMap<>();
	    s6.put("Staff First Name", "Staff Faelunessa");
	    s6.put("Staff Middle Name", "Junoriel");
	    s6.put("Staff Last Name", "Sablethorn");
	    s6.put("Staff Name Suffix", "II");
	    s6.put("Staff Phone", "9794317606");
	    s6.put("Staff Office phone", "9794328606");
	    s6.put("Staff Email", "staff.faelunessa.sablethorn.r1j7kd@mailto.plus");

	    TreeMap<String, String> s7 = new TreeMap<>();
	    s7.put("Staff First Name", "Staff Galvadorin");
	    s7.put("Staff Middle Name", "Kestovyn");
	    s7.put("Staff Last Name", "Myridanse");
	    s7.put("Staff Name Suffix", "Jr");
	    s7.put("Staff Phone", "9794317607");
	    s7.put("Staff Office phone", "9794328607");
	    s7.put("Staff Email", "staff.galvadorin.myridanse.w8d2qb@mailto.plus");

	    TreeMap<String, String> s8 = new TreeMap<>();
	    s8.put("Staff First Name", "Staff Heliovanna");
	    s8.put("Staff Middle Name", "Sylphiora");
	    s8.put("Staff Last Name", "Wexenfell");
	    s8.put("Staff Name Suffix", "III");
	    s8.put("Staff Phone", "9794317608");
	    s8.put("Staff Office phone", "9794328608");
	    s8.put("Staff Email", "staff.heliovanna.wexenfell.y5k0zu@mailto.plus");

	    TreeMap<String, String> s9 = new TreeMap<>();
	    s9.put("Staff First Name", "Staff Iskavion");
	    s9.put("Staff Middle Name", "Quintressa");
	    s9.put("Staff Last Name", "Crownmirel");
	    s9.put("Staff Name Suffix", "Sr");
	    s9.put("Staff Phone", "9794317609");
	    s9.put("Staff Office phone", "9794328609");
	    s9.put("Staff Email", "staff.iskavion.crownmirel.k3q6lp@mailto.plus");

	    TreeMap<String, String> s10 = new TreeMap<>();
	    s10.put("Staff First Name", "Staff Jorvandre");
	    s10.put("Staff Middle Name", "Rheomir");
	    s10.put("Staff Last Name", "Zephyrnox");
	    s10.put("Staff Name Suffix", "IV");
	    s10.put("Staff Phone", "9794317610");
	    s10.put("Staff Office phone", "9794328610");
	    s10.put("Staff Email", "staff.jorvandre.zephyrnox.b7u1ex@mailto.plus");

	    TreeMap<String, String> s11 = new TreeMap<>();
	    s11.put("Staff First Name", "Staff Kaelorina");
	    s11.put("Staff Middle Name", "Vallorine");
	    s11.put("Staff Last Name", "Ravenhollow");
	    s11.put("Staff Name Suffix", "II");
	    s11.put("Staff Phone", "9794317611");
	    s11.put("Staff Office phone", "9794328611");
	    s11.put("Staff Email", "staff.kaelorina.ravenhollow.c9m5as@mailto.plus");

	    TreeMap<String, String> s12 = new TreeMap<>();
	    s12.put("Staff First Name", "Staff Lysandorix");
	    s12.put("Staff Middle Name", "Mirelune");
	    s12.put("Staff Last Name", "Obsidianmere");
	    s12.put("Staff Name Suffix", "Jr");
	    s12.put("Staff Phone", "9794317612");
	    s12.put("Staff Office phone", "9794328612");
	    s12.put("Staff Email", "staff.lysandorix.obsidianmere.f2r8km@mailto.plus");

	    TreeMap<String, String> s13 = new TreeMap<>();
	    s13.put("Staff First Name", "Staff Maristavelle");
	    s13.put("Staff Middle Name", "Talarion");
	    s13.put("Staff Last Name", "Hollowcairne");
	    s13.put("Staff Name Suffix", "III");
	    s13.put("Staff Phone", "9794317613");
	    s13.put("Staff Office phone", "9794328613");
	    s13.put("Staff Email", "staff.maristavelle.hollowcairne.n6p4vt@mailto.plus");

	    TreeMap<String, String> s14 = new TreeMap<>();
	    s14.put("Staff First Name", "Staff Nyxaviera");
	    s14.put("Staff Middle Name", "Demeris");
	    s14.put("Staff Last Name", "Frostmerrow");
	    s14.put("Staff Name Suffix", "Sr");
	    s14.put("Staff Phone", "9794317614");
	    s14.put("Staff Office phone", "9794328614");
	    s14.put("Staff Email", "staff.nyxaviera.frostmerrow.s1v9de@mailto.plus");

	    TreeMap<String, String> s15 = new TreeMap<>();
	    s15.put("Staff First Name", "Staff Orphelianne");
	    s15.put("Staff Middle Name", "Peregrin");
	    s15.put("Staff Last Name", "Cindervaux");
	    s15.put("Staff Name Suffix", "IV");
	    s15.put("Staff Phone", "9794317615");
	    s15.put("Staff Office phone", "9794328615");
	    s15.put("Staff Email", "staff.orphelianne.cindervaux.g8t3hx@mailto.plus");

	    TreeMap<String, String> s16 = new TreeMap<>();
	    s16.put("Staff First Name", "Staff Quorimelle");
	    s16.put("Staff Middle Name", "Anselune");
	    s16.put("Staff Last Name", "Stormeichen");
	    s16.put("Staff Name Suffix", "II");
	    s16.put("Staff Phone", "9794317616");
	    s16.put("Staff Office phone", "9794328616");
	    s16.put("Staff Email", "staff.quorimelle.stormeichen.j4x7wy@mailto.plus");

	    TreeMap<String, String> s17 = new TreeMap<>();
	    s17.put("Staff First Name", "Staff Rivenoria");
	    s17.put("Staff Middle Name", "Caelith");
	    s17.put("Staff Last Name", "Marblethistrel");
	    s17.put("Staff Name Suffix", "Jr");
	    s17.put("Staff Phone", "9794317617");
	    s17.put("Staff Office phone", "9794328617");
	    s17.put("Staff Email", "staff.rivenoria.marblethistrel.l0q2pk@mailto.plus");

	    TreeMap<String, String> s18 = new TreeMap<>();
	    s18.put("Staff First Name", "Staff Seredalion");
	    s18.put("Staff Middle Name", "Zorion");
	    s18.put("Staff Last Name", "Kleinvorsten");
	    s18.put("Staff Name Suffix", "III");
	    s18.put("Staff Phone", "9794317618");
	    s18.put("Staff Office phone", "9794328618");
	    s18.put("Staff Email", "staff.seredalion.kleinvorsten.v3n6cr@mailto.plus");

	    TreeMap<String, String> s19 = new TreeMap<>();
	    s19.put("Staff First Name", "Staff Tressavine");
	    s19.put("Staff Middle Name", "Vionette");
	    s19.put("Staff Last Name", "Quillnevarra");
	    s19.put("Staff Name Suffix", "Sr");
	    s19.put("Staff Phone", "9794317619");
	    s19.put("Staff Office phone", "9794328619");
	    s19.put("Staff Email", "staff.tressavine.quillnevarra.d7m1qa@mailto.plus");

	    TreeMap<String, String> s20 = new TreeMap<>();
	    s20.put("Staff First Name", "Staff Wulfrina");
	    s20.put("Staff Middle Name", "Ysolde");
	    s20.put("Staff Last Name", "Briarnoctis");
	    s20.put("Staff Name Suffix", "IV");
	    s20.put("Staff Phone", "9794317620");
	    s20.put("Staff Office phone", "9794328620");
	    s20.put("Staff Email", "staff.wulfrina.briarnoctis.p5k8zn@mailto.plus");

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
