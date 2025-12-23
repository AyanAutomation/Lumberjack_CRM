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
	
	
	
	@Test(dataProvider="attorneyStaffData")
	public void Attorney_Add(TreeMap<String, String> data) throws IOException, InterruptedException{
		
	Attorney_Locaters pp = new Attorney_Locaters(d);	
	SIde_Menu_Handler sd=new SIde_Menu_Handler();
	Plaintiff_Locaters p=new Plaintiff_Locaters(d);
	Application_Locaters ap = new Application_Locaters(d);
	Repeat rp=new Repeat(d);
	Login_Locaters lg=new Login_Locaters(d);
	
	String Law_Firm = data.get("Law Firm");
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

	    TreeMap<String, String> a1 = new TreeMap<String, String>();
	    a1.put("Law Firm", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
	    a1.put("First Name", "Attorney Arved");
	    a1.put("Middle Name", "Quirin");
	    a1.put("Last Name", "Hirschmann");
	    a1.put("Name Suffix", "III");
	    a1.put("Phone", "4165553101");
	    a1.put("Office phone", "4165557101");
	    a1.put("Email", "arved.hirschmann@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<String, String>();
	    a2.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a2.put("First Name", "Attorney Leofric");
	    a2.put("Middle Name", "Bastian");
	    a2.put("Last Name", "Kaltwasser");
	    a2.put("Name Suffix", "Sr");
	    a2.put("Phone", "6475553102");
	    a2.put("Office phone", "6475557102");
	    a2.put("Email", "leofric.kaltwasser@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<String, String>();
	    a3.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a3.put("First Name", "Attorney Severin");
	    a3.put("Middle Name", "Anselm");
	    a3.put("Last Name", "Tannenberg");
	    a3.put("Name Suffix", "II");
	    a3.put("Phone", "9055553103");
	    a3.put("Office phone", "9055557103");
	    a3.put("Email", "severin.tannenberg@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<String, String>();
	    a4.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a4.put("First Name", "Attorney Ulric");
	    a4.put("Middle Name", "Matthieu");
	    a4.put("Last Name", "Reichenauer");
	    a4.put("Name Suffix", "Jr");
	    a4.put("Phone", "2895553104");
	    a4.put("Office phone", "2895557104");
	    a4.put("Email", "ulric.reichenauer@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<String, String>();
	    a5.put("Law Firm", "Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective");
	    a5.put("First Name", "Attorney Gero");
	    a5.put("Middle Name", "Lucien");
	    a5.put("Last Name", "Falkenhayn");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "6135553105");
	    a5.put("Office phone", "6135557105");
	    a5.put("Email", "gero.falkenhayn@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<String, String>();
	    a6.put("Law Firm", "Kleinberger & Schubertov Nursing Home Abuse, Elder Neglect & Pflegeheim Protection Firm");
	    a6.put("First Name", "Attorney Winrich");
	    a6.put("Middle Name", "Olivier");
	    a6.put("Last Name", "Schneeberger");
	    a6.put("Name Suffix", "Sr");
	    a6.put("Phone", "5145553106");
	    a6.put("Office phone", "5145557106");
	    a6.put("Email", "winrich.schneeberger@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<String, String>();
	    a7.put("Law Firm", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
	    a7.put("First Name", "Attorney Cedric");
	    a7.put("Middle Name", "Noel");
	    a7.put("Last Name", "Eisenhauer");
	    a7.put("Name Suffix", "II");
	    a7.put("Phone", "3435553107");
	    a7.put("Office phone", "3435557107");
	    a7.put("Email", "cedric.eisenhauer@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<String, String>();
	    a8.put("Law Firm", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
	    a8.put("First Name", "Attorney Dieter");
	    a8.put("Middle Name", "Remy");
	    a8.put("Last Name", "Blumenrath");
	    a8.put("Name Suffix", "Jr");
	    a8.put("Phone", "7805553108");
	    a8.put("Office phone", "7805557108");
	    a8.put("Email", "dieter.blumenrath@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<String, String>();
	    a9.put("Law Firm", "Falkenova, Dornik & Brechtova Maritime, Boat & Seeufer Accident Rechtsberatung Group");
	    a9.put("First Name", "Attorney Alwin");
	    a9.put("Middle Name", "Claude");
	    a9.put("Last Name", "Hohenegger");
	    a9.put("Name Suffix", "III");
	    a9.put("Phone", "9025553109");
	    a9.put("Office phone", "9025557109");
	    a9.put("Email", "alwin.hohenegger@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<String, String>();
	    a10.put("Law Firm", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
	    a10.put("First Name", "Attorney Korbinian");
	    a10.put("Middle Name", "Jasper");
	    a10.put("Last Name", "Sternbach");
	    a10.put("Name Suffix", "Sr");
	    a10.put("Phone", "4505553110");
	    a10.put("Office phone", "4505557110");
	    a10.put("Email", "korbinian.sternbach@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<String, String>();
	    a11.put("Law Firm", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
	    a11.put("First Name", "Attorney Isidor");
	    a11.put("Middle Name", "Benoit");
	    a11.put("Last Name", "Waldkirch");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "5875553111");
	    a11.put("Office phone", "5875557111");
	    a11.put("Email", "isidor.waldkirch@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<String, String>();
	    a12.put("Law Firm", "Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices");
	    a12.put("First Name", "Attorney Alaric");
	    a12.put("Middle Name", "Thierry");
	    a12.put("Last Name", "Kronauer");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "2045553112");
	    a12.put("Office phone", "2045557112");
	    a12.put("Email", "alaric.kronauer@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<String, String>();
	    a13.put("Law Firm", "Northern Indiana Construction Site Accident, Scaffold & Workplace Injury Attorneys");
	    a13.put("First Name", "Attorney Fedor");
	    a13.put("Middle Name", "Caius");
	    a13.put("Last Name", "Rosenkranz");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "7785553113");
	    a13.put("Office phone", "7785557113");
	    a13.put("Email", "fedor.rosenkranz@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<String, String>();
	    a14.put("Law Firm", "Prairie State Bicycle, Pedestrian & Urban Traffic Collision Law Collective");
	    a14.put("First Name", "Attorney Emmerich");
	    a14.put("Middle Name", "Sebastien");
	    a14.put("Last Name", "Dachsberger");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "4185553114");
	    a14.put("Office phone", "4185557114");
	    a14.put("Email", "emmerich.dachsberger@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<String, String>();
	    a15.put("Law Firm", "Horizon Child Injury, School Negligence & Playground Accident Trial Lawyers");
	    a15.put("First Name", "Attorney Volker");
	    a15.put("Middle Name", "Hugo");
	    a15.put("Last Name", "Eichenwald");
	    a15.put("Name Suffix", "II");
	    a15.put("Phone", "5065553115");
	    a15.put("Office phone", "5065557115");
	    a15.put("Email", "volker.eichenwald@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<String, String>();
	    a16.put("Law Firm", "1010 South Meridian Street, Justice Square");
	    a16.put("First Name", "Attorney Waldemar");
	    a16.put("Middle Name", "Marc");
	    a16.put("Last Name", "Kieselmann");
	    a16.put("Name Suffix", "IV");
	    a16.put("Phone", "5195553116");
	    a16.put("Office phone", "5195557116");
	    a16.put("Email", "waldemar.kieselmann@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<String, String>();
	    a17.put("Law Firm", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
	    a17.put("First Name", "Attorney Anno");
	    a17.put("Middle Name", "Pascal");
	    a17.put("Last Name", "Hirschauer");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "7055553117");
	    a17.put("Office phone", "7055557117");
	    a17.put("Email", "anno.hirschauer@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<String, String>();
	    a18.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a18.put("First Name", "Attorney Eamon");
	    a18.put("Middle Name", "Quentin");
	    a18.put("Last Name", "Vogelmann");
	    a18.put("Name Suffix", "II");
	    a18.put("Phone", "8675553118");
	    a18.put("Office phone", "8675557118");
	    a18.put("Email", "eamon.vogelmann@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<String, String>();
	    a19.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a19.put("First Name", "Attorney Kuno");
	    a19.put("Middle Name", "Emile");
	    a19.put("Last Name", "Schwarzwald");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "7095553119");
	    a19.put("Office phone", "7095557119");
	    a19.put("Email", "kuno.schwarzwald@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<String, String>();
	    a20.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a20.put("First Name", "Attorney Lorcan");
	    a20.put("Middle Name", "Alphonse");
	    a20.put("Last Name", "Tiefenthaler");
	    a20.put("Name Suffix", "III");
	    a20.put("Phone", "6045553120");
	    a20.put("Office phone", "6045557120");
	    a20.put("Email", "lorcan.tiefenthaler@mailto.plus");

	    return new Object[][]{
	     /*   {a1},{a2},{a3},*/{a4},/*{a5},
	        {a6},{a7},{a8},{a9},{a10},*/
	        {a11},/*{a12},{a13},{a14},{a15},
	        {a16},{a17},{a18},{a19},*/{a20}
	    };
	}



}
