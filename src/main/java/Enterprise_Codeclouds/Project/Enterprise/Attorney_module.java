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
	public void Attorney_Add(TreeMap<String, String> data,TreeMap<String, String> law_firm) throws IOException, InterruptedException{
		
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
	WebElement Add_Attorney_Button=p.form_buttons().get(2);
	rp.Scroll_to_element(Add_Attorney_Button);
	Add_Attorney_Button.click();
	Thread.sleep(800);	
	String taost= lg.toast().getText().trim();
	Login_negative_testcases.Toast_printer(taost);
	}
	
	
	
	@DataProvider
	public Object[][] attorneyStaffData() {

		TreeMap<String, String> a1 = new TreeMap<>();
	    a1.put("First Name", "Attorney Aelthorin");
	    a1.put("Middle Name", "Quorvayne");
	    a1.put("Last Name", "Vexelthorne");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "9887773001");
	    a1.put("Office phone", "9888884001");
	    a1.put("Email", "attorney.aelthorin.vexelthorne.k7q1@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<>();
	    a2.put("First Name", "Attorney Brionyra");
	    a2.put("Middle Name", "Selwynne");
	    a2.put("Last Name", "Krynnemont");
	    a2.put("Name Suffix", "Jr");
	    a2.put("Phone", "9887773002");
	    a2.put("Office phone", "9888884002");
	    a2.put("Email", "attorney.brionyra.krynnemont.m2v8@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<>();
	    a3.put("First Name", "Attorney Corvandel");
	    a3.put("Middle Name", "Rhaedric");
	    a3.put("Last Name", "Draxenvale");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9887773003");
	    a3.put("Office phone", "9888884003");
	    a3.put("Email", "attorney.corvandel.draxenvale.p9c4@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<>();
	    a4.put("First Name", "Attorney Delpharyn");
	    a4.put("Middle Name", "Nivoria");
	    a4.put("Last Name", "Orriscarrow");
	    a4.put("Name Suffix", "Sr");
	    a4.put("Phone", "9887773004");
	    a4.put("Office phone", "9888884004");
	    a4.put("Email", "attorney.delpharyn.orriscarrow.t6n3@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<>();
	    a5.put("First Name", "Attorney Eryndorin");
	    a5.put("Middle Name", "Lucavere");
	    a5.put("Last Name", "Thornquillon");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "9887773005");
	    a5.put("Office phone", "9888884005");
	    a5.put("Email", "attorney.eryndorin.thornquillon.h4x9@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<>();
	    a6.put("First Name", "Attorney Faelistra");
	    a6.put("Middle Name", "Junoria");
	    a6.put("Last Name", "Sablewright");
	    a6.put("Name Suffix", "II");
	    a6.put("Phone", "9887773006");
	    a6.put("Office phone", "9888884006");
	    a6.put("Email", "attorney.faelistra.sablewright.r1j7@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<>();
	    a7.put("First Name", "Attorney Galrenic");
	    a7.put("Middle Name", "Kestovar");
	    a7.put("Last Name", "Myridanth");
	    a7.put("Name Suffix", "Jr");
	    a7.put("Phone", "9887773007");
	    a7.put("Office phone", "9888884007");
	    a7.put("Email", "attorney.galrenic.myridanth.w8d2@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<>();
	    a8.put("First Name", "Attorney Heliandra");
	    a8.put("Middle Name", "Sylphine");
	    a8.put("Last Name", "Wexenford");
	    a8.put("Name Suffix", "III");
	    a8.put("Phone", "9887773008");
	    a8.put("Office phone", "9888884008");
	    a8.put("Email", "attorney.heliandra.wexenford.y5k0@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<>();
	    a9.put("First Name", "Attorney Iskaviel");
	    a9.put("Middle Name", "Vespera");
	    a9.put("Last Name", "Crownmireaux");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "9887773009");
	    a9.put("Office phone", "9888884009");
	    a9.put("Email", "attorney.iskaviel.crownmireaux.z3q6@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<>();
	    a10.put("First Name", "Attorney Jorvannis");
	    a10.put("Middle Name", "Rheomir");
	    a10.put("Last Name", "Zephyrnault");
	    a10.put("Name Suffix", "IV");
	    a10.put("Phone", "9887773010");
	    a10.put("Office phone", "9888884010");
	    a10.put("Email", "attorney.jorvannis.zephyrnault.b7u1@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<>();
	    a11.put("First Name", "Attorney Kaeloria");
	    a11.put("Middle Name", "Quintessa");
	    a11.put("Last Name", "Ravenquarry");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "9887773011");
	    a11.put("Office phone", "9888884011");
	    a11.put("Email", "attorney.kaeloria.ravenquarry.c9m5@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<>();
	    a12.put("First Name", "Attorney Lysandric");
	    a12.put("Middle Name", "Mirelle");
	    a12.put("Last Name", "Obsidianhart");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "9887773012");
	    a12.put("Office phone", "9888884012");
	    a12.put("Email", "attorney.lysandric.obsidianhart.f2r8@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<>();
	    a13.put("First Name", "Attorney Maristane");
	    a13.put("Middle Name", "Talarin");
	    a13.put("Last Name", "Hollowcairn");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "9887773013");
	    a13.put("Office phone", "9888884013");
	    a13.put("Email", "attorney.maristane.hollowcairn.n6p4@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<>();
	    a14.put("First Name", "Attorney Nyxandra");
	    a14.put("Middle Name", "Demeris");
	    a14.put("Last Name", "Frostmeridian");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "9887773014");
	    a14.put("Office phone", "9888884014");
	    a14.put("Email", "attorney.nyxandra.frostmeridian.s1v9@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<>();
	    a15.put("First Name", "Attorney Orpheline");
	    a15.put("Middle Name", "Peregrin");
	    a15.put("Last Name", "Cindervaleux");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "9887773015");
	    a15.put("Office phone", "9888884015");
	    a15.put("Email", "attorney.orpheline.cindervaleux.g8t3@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<>();
	    a16.put("First Name", "Attorney Quorimel");
	    a16.put("Middle Name", "Vallorin");
	    a16.put("Last Name", "Stormeichen");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "9887773016");
	    a16.put("Office phone", "9888884016");
	    a16.put("Email", "attorney.quorimel.stormeichen.j4x7@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<>();
	    a17.put("First Name", "Attorney Rivenna");
	    a17.put("Middle Name", "Caelith");
	    a17.put("Last Name", "Marblethistledown");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "9887773017");
	    a17.put("Office phone", "9888884017");
	    a17.put("Email", "attorney.rivenna.marblethistledown.l0q2@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<>();
	    a18.put("First Name", "Attorney Seredane");
	    a18.put("Middle Name", "Zorion");
	    a18.put("Last Name", "Kleinvorst");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "9887773018");
	    a18.put("Office phone", "9888884018");
	    a18.put("Email", "attorney.seredane.kleinvorst.v3n6@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<>();
	    a19.put("First Name", "Attorney Tressavian");
	    a19.put("Middle Name", "Vionette");
	    a19.put("Last Name", "Quillnevarre");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "9887773019");
	    a19.put("Office phone", "9888884019");
	    a19.put("Email", "attorney.tressavian.quillnevarre.d7m1@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<>();
	    a20.put("First Name", "Attorney Wulfric");
	    a20.put("Middle Name", "Ysolde");
	    a20.put("Last Name", "Briarnocturne");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "9887773020");
	    a20.put("Office phone", "9888884020");
	    a20.put("Email", "attorney.wulfric.briarnocturne.p5k8@mailto.plus");

	    return new Object[][]{
	     /*   {a1},*/{a2},{a3},{a4},{a5},
	        {a6},{a7},{a8},{a9},{a10},
	        {a11},{a12},{a13},{a14},{a15},
	        {a16},{a17},{a18},{a19},{a20} 
	    };
	}

	@DataProvider
	public Object[][] law_plus_attorney(){
		
		
		Law_Firm_Module lfm = new Law_Firm_Module();
		
		Object[][] attorney_datas = attorneyStaffData();
		Object[][] law_firm_data = lfm.lawFirmData();
		
		int n = Math.min(attorney_datas.length, law_firm_data.length);
		Object[][] final_set = new Object[n][2];
		
		for(int i=0;i<n;i++){
			   final_set[i][0] = attorney_datas[i][0];      
		       final_set[i][1] = law_firm_data[i][0]; 
		       
		    }
		    return final_set;
		
		
	}

}
