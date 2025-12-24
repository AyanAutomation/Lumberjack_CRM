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
	    a1.put("First Name", "Attorney Cassian");
	    a1.put("Middle Name", "Alaric");
	    a1.put("Last Name", "Hohenstauf");
	    a1.put("Name Suffix", "II");
	    a1.put("Phone", "4165554201");
	    a1.put("Office phone", "4165558201");
	    a1.put("Email", "cassian.hohenstauf@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<String, String>();
	    a2.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a2.put("First Name", "Attorney Evander");
	    a2.put("Middle Name", "Benoit");
	    a2.put("Last Name", "Kaltenbrunn");
	    a2.put("Name Suffix", "Sr");
	    a2.put("Phone", "6475554202");
	    a2.put("Office phone", "6475558202");
	    a2.put("Email", "evander.kaltenbrunn@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<String, String>();
	    a3.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a3.put("First Name", "Attorney Leander");
	    a3.put("Middle Name", "Quentin");
	    a3.put("Last Name", "Stahlberg");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9055554203");
	    a3.put("Office phone", "9055558203");
	    a3.put("Email", "leander.stahlberg@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<String, String>();
	    a4.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a4.put("First Name", "Attorney Thaddeus");
	    a4.put("Middle Name", "Matteo");
	    a4.put("Last Name", "Rosenwald");
	    a4.put("Name Suffix", "Jr");
	    a4.put("Phone", "2895554204");
	    a4.put("Office phone", "2895558204");
	    a4.put("Email", "thaddeus.rosenwald@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<String, String>();
	    a5.put("Law Firm", "Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective");
	    a5.put("First Name", "Attorney Oskar");
	    a5.put("Middle Name", "Lucien");
	    a5.put("Last Name", "Falkenrath");
	    a5.put("Name Suffix", "IV");
	    a5.put("Phone", "6135554205");
	    a5.put("Office phone", "6135558205");
	    a5.put("Email", "oskar.falkenrath@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<String, String>();
	    a6.put("Law Firm", "Kleinberger & Schubertov Nursing Home Abuse, Elder Neglect & Pflegeheim Protection Firm");
	    a6.put("First Name", "Attorney Sylvester");
	    a6.put("Middle Name", "Noel");
	    a6.put("Last Name", "Schneefeld");
	    a6.put("Name Suffix", "Sr");
	    a6.put("Phone", "5145554206");
	    a6.put("Office phone", "5145558206");
	    a6.put("Email", "sylvester.schneefeld@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<String, String>();
	    a7.put("Law Firm", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
	    a7.put("First Name", "Attorney Gideon");
	    a7.put("Middle Name", "Sebastien");
	    a7.put("Last Name", "Eisenwald");
	    a7.put("Name Suffix", "II");
	    a7.put("Phone", "3435554207");
	    a7.put("Office phone", "3435558207");
	    a7.put("Email", "gideon.eisenwald@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<String, String>();
	    a8.put("Law Firm", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
	    a8.put("First Name", "Attorney Marcel");
	    a8.put("Middle Name", "Remy");
	    a8.put("Last Name", "Blumenfeld");
	    a8.put("Name Suffix", "Jr");
	    a8.put("Phone", "7805554208");
	    a8.put("Office phone", "7805558208");
	    a8.put("Email", "marcel.blumenfeld@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<String, String>();
	    a9.put("Law Firm", "Falkenova, Dornik & Brechtova Maritime, Boat & Seeufer Accident Rechtsberatung Group");
	    a9.put("First Name", "Attorney Dorian");
	    a9.put("Middle Name", "Claude");
	    a9.put("Last Name", "Hohenbruck");
	    a9.put("Name Suffix", "III");
	    a9.put("Phone", "9025554209");
	    a9.put("Office phone", "9025558209");
	    a9.put("Email", "dorian.hohenbruck@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<String, String>();
	    a10.put("Law Firm", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
	    a10.put("First Name", "Attorney Roderick");
	    a10.put("Middle Name", "Jasper");
	    a10.put("Last Name", "Sternwalt");
	    a10.put("Name Suffix", "Sr");
	    a10.put("Phone", "4505554210");
	    a10.put("Office phone", "4505558210");
	    a10.put("Email", "roderick.sternwalt@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<String, String>();
	    a11.put("Law Firm", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
	    a11.put("First Name", "Attorney Alphonse");
	    a11.put("Middle Name", "Thierry");
	    a11.put("Last Name", "Waldmann");
	    a11.put("Name Suffix", "II");
	    a11.put("Phone", "5875554211");
	    a11.put("Office phone", "5875558211");
	    a11.put("Email", "alphonse.waldmann@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<String, String>();
	    a12.put("Law Firm", "Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices");
	    a12.put("First Name", "Attorney Benedict");
	    a12.put("Middle Name", "Pascal");
	    a12.put("Last Name", "Kronfeld");
	    a12.put("Name Suffix", "Jr");
	    a12.put("Phone", "2045554212");
	    a12.put("Office phone", "2045558212");
	    a12.put("Email", "benedict.kronfeld@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<String, String>();
	    a13.put("Law Firm", "Northern Indiana Construction Site Accident, Scaffold & Workplace Injury Attorneys");
	    a13.put("First Name", "Attorney Magnus");
	    a13.put("Middle Name", "Caius");
	    a13.put("Last Name", "Rosenheim");
	    a13.put("Name Suffix", "III");
	    a13.put("Phone", "7785554213");
	    a13.put("Office phone", "7785558213");
	    a13.put("Email", "magnus.rosenheim@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<String, String>();
	    a14.put("Law Firm", "Prairie State Bicycle, Pedestrian & Urban Traffic Collision Law Collective");
	    a14.put("First Name", "Attorney Cedric");
	    a14.put("Middle Name", "Hugo");
	    a14.put("Last Name", "Dachsner");
	    a14.put("Name Suffix", "Sr");
	    a14.put("Phone", "4185554214");
	    a14.put("Office phone", "4185558214");
	    a14.put("Email", "cedric.dachsner@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<String, String>();
	    a15.put("Law Firm", "Horizon Child Injury, School Negligence & Playground Accident Trial Lawyers");
	    a15.put("First Name", "Attorney Emilian");
	    a15.put("Middle Name", "Marc");
	    a15.put("Last Name", "Eichenstein");
	    a15.put("Name Suffix", "IV");
	    a15.put("Phone", "5065554215");
	    a15.put("Office phone", "5065558215");
	    a15.put("Email", "emilian.eichenstein@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<String, String>();
	    a16.put("Law Firm", "1010 South Meridian Street, Justice Square");
	    a16.put("First Name", "Attorney Florian");
	    a16.put("Middle Name", "Anselm");
	    a16.put("Last Name", "Kieselberg");
	    a16.put("Name Suffix", "II");
	    a16.put("Phone", "5195554216");
	    a16.put("Office phone", "5195558216");
	    a16.put("Email", "florian.kieselberg@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<String, String>();
	    a17.put("Law Firm", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
	    a17.put("First Name", "Attorney Casimir");
	    a17.put("Middle Name", "Noel");
	    a17.put("Last Name", "Hirschfeld");
	    a17.put("Name Suffix", "Jr");
	    a17.put("Phone", "7055554217");
	    a17.put("Office phone", "7055558217");
	    a17.put("Email", "casimir.hirschfeld@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<String, String>();
	    a18.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a18.put("First Name", "Attorney Rowan");
	    a18.put("Middle Name", "Bastian");
	    a18.put("Last Name", "Vogelhardt");
	    a18.put("Name Suffix", "III");
	    a18.put("Phone", "8675554218");
	    a18.put("Office phone", "8675558218");
	    a18.put("Email", "rowan.vogelhardt@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<String, String>();
	    a19.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a19.put("First Name", "Attorney Silas");
	    a19.put("Middle Name", "Matthieu");
	    a19.put("Last Name", "Schwarzenau");
	    a19.put("Name Suffix", "Sr");
	    a19.put("Phone", "7095554219");
	    a19.put("Office phone", "7095558219");
	    a19.put("Email", "silas.schwarzenau@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<String, String>();
	    a20.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a20.put("First Name", "Attorney Percival");
	    a20.put("Middle Name", "Quirin");
	    a20.put("Last Name", "Tiefenborn");
	    a20.put("Name Suffix", "IV");
	    a20.put("Phone", "6045554220");
	    a20.put("Office phone", "6045558220");
	    a20.put("Email", "percival.tiefenborn@mailto.plus");

	    return new Object[][]{
	        {a1},{a2},{a3},{a4},{a5},
	        {a6},{a7},{a8},{a9},{a10},
	        {a11},{a12},{a13},{a14},{a15},
	        {a16},{a17},{a18},{a19},{a20}
	    };
	}



}
