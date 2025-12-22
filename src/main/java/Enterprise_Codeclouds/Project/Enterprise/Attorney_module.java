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
	    a1.put("First Name", "Attorney Alarich");
	    a1.put("Middle Name", "Jasper");
	    a1.put("Last Name", "Sonnenfeldt");
	    a1.put("Name Suffix", "Jr");
	    a1.put("Phone", "4165552101");
	    a1.put("Office phone", "4165556101");
	    a1.put("Email", "alarich.sonnenfeldt@mailto.plus");

	    TreeMap<String, String> a2 = new TreeMap<String, String>();
	    a2.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a2.put("First Name", "Attorney Falko");
	    a2.put("Middle Name", "Remy");
	    a2.put("Last Name", "Kornblum");
	    a2.put("Name Suffix", "Sr");
	    a2.put("Phone", "6475552102");
	    a2.put("Office phone", "6475556102");
	    a2.put("Email", "falko.kornblum@mailto.plus");

	    TreeMap<String, String> a3 = new TreeMap<String, String>();
	    a3.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a3.put("First Name", "Attorney Lorenz");
	    a3.put("Middle Name", "Caius");
	    a3.put("Last Name", "Hinteregger");
	    a3.put("Name Suffix", "III");
	    a3.put("Phone", "9055552103");
	    a3.put("Office phone", "9055556103");
	    a3.put("Email", "lorenz.hinteregger@mailto.plus");

	    TreeMap<String, String> a4 = new TreeMap<String, String>();
	    a4.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a4.put("First Name", "Attorney Bjarne");
	    a4.put("Middle Name", "Quentin");
	    a4.put("Last Name", "Edelmann");
	    a4.put("Name Suffix", "II");
	    a4.put("Phone", "2895552104");
	    a4.put("Office phone", "2895556104");
	    a4.put("Email", "bjarne.edelmann@mailto.plus");

	    TreeMap<String, String> a5 = new TreeMap<String, String>();
	    a5.put("Law Firm", "Braunova-Petrov Medical Malpractice, Birth Injury & Patient Safety Law Collective");
	    a5.put("First Name", "Attorney Ossian");
	    a5.put("Middle Name", "Thierry");
	    a5.put("Last Name", "Fahrner");
	    a5.put("Name Suffix", "Jr");
	    a5.put("Phone", "6135552105");
	    a5.put("Office phone", "6135556105");
	    a5.put("Email", "ossian.fahrner@mailto.plus");

	    TreeMap<String, String> a6 = new TreeMap<String, String>();
	    a6.put("Law Firm", "Kleinberger & Schubertov Nursing Home Abuse, Elder Neglect & Pflegeheim Protection Firm");
	    a6.put("First Name", "Attorney Eckehard");
	    a6.put("Middle Name", "Noel");
	    a6.put("Last Name", "Schwarzkopf");
	    a6.put("Name Suffix", "Sr");
	    a6.put("Phone", "5145552106");
	    a6.put("Office phone", "5145556106");
	    a6.put("Email", "eckehard.schwarzkopf@mailto.plus");

	    TreeMap<String, String> a7 = new TreeMap<String, String>();
	    a7.put("Law Firm", "Wolframova & Königstein Urban Bicycle, Pedestrian & Verkehrskollision Attorneys");
	    a7.put("First Name", "Attorney Kasimir");
	    a7.put("Middle Name", "Benoit");
	    a7.put("Last Name", "Tiefenbach");
	    a7.put("Name Suffix", "III");
	    a7.put("Phone", "3435552107");
	    a7.put("Office phone", "3435556107");
	    a7.put("Email", "kasimir.tiefenbach@mailto.plus");

	    TreeMap<String, String> a8 = new TreeMap<String, String>();
	    a8.put("Law Firm", "Beckendorf & Neumannova School Negligence, Child Injury & Jugend Safety Trial Lawyers");
	    a8.put("First Name", "Attorney Wendelin");
	    a8.put("Middle Name", "Hugo");
	    a8.put("Last Name", "Rosenhagen");
	    a8.put("Name Suffix", "II");
	    a8.put("Phone", "7805552108");
	    a8.put("Office phone", "7805556108");
	    a8.put("Email", "wendelin.rosenhagen@mailto.plus");

	    TreeMap<String, String> a9 = new TreeMap<String, String>();
	    a9.put("Law Firm", "Falkenova, Dornik & Brechtova Maritime, Boat & Seeufer Accident Rechtsberatung Group");
	    a9.put("First Name", "Attorney Raban");
	    a9.put("Middle Name", "Lucien");
	    a9.put("Last Name", "Kellermann");
	    a9.put("Name Suffix", "Sr");
	    a9.put("Phone", "9025552109");
	    a9.put("Office phone", "9025556109");
	    a9.put("Email", "raban.kellermann@mailto.plus");

	    TreeMap<String, String> a10 = new TreeMap<String, String>();
	    a10.put("Law Firm", "Krausov-Bauer Polizeimisconduct, Civil Rights & Bürgerfreiheiten Law Center");
	    a10.put("First Name", "Attorney Giselher");
	    a10.put("Middle Name", "Marc");
	    a10.put("Last Name", "Altenkirch");
	    a10.put("Name Suffix", "Jr");
	    a10.put("Phone", "4505552110");
	    a10.put("Office phone", "4505556110");
	    a10.put("Email", "giselher.altenkirch@mailto.plus");

	    TreeMap<String, String> a11 = new TreeMap<String, String>();
	    a11.put("Law Firm", "Schweitzerova & Voronov Bad Faith Insurance, Claim Denial & Verbraucherrechte Counsel");
	    a11.put("First Name", "Attorney Jannik");
	    a11.put("Middle Name", "Alphonse");
	    a11.put("Last Name", "Vollenweider");
	    a11.put("Name Suffix", "III");
	    a11.put("Phone", "5875552111");
	    a11.put("Office phone", "5875556111");
	    a11.put("Email", "jannik.vollenweider@mailto.plus");

	    TreeMap<String, String> a12 = new TreeMap<String, String>();
	    a12.put("Law Firm", "Capital City Consumer Protection, Bad Faith Insurance & Claim Denial Law Offices");
	    a12.put("First Name", "Attorney Sverre");
	    a12.put("Middle Name", "Olivier");
	    a12.put("Last Name", "Birkenfeld");
	    a12.put("Name Suffix", "II");
	    a12.put("Phone", "2045552112");
	    a12.put("Office phone", "2045556112");
	    a12.put("Email", "sverre.birkenfeld@mailto.plus");

	    TreeMap<String, String> a13 = new TreeMap<String, String>();
	    a13.put("Law Firm", "Northern Indiana Construction Site Accident, Scaffold & Workplace Injury Attorneys");
	    a13.put("First Name", "Attorney Tjark");
	    a13.put("Middle Name", "Emile");
	    a13.put("Last Name", "Krenzler");
	    a13.put("Name Suffix", "Sr");
	    a13.put("Phone", "7785552113");
	    a13.put("Office phone", "7785556113");
	    a13.put("Email", "tjark.krenzler@mailto.plus");

	    TreeMap<String, String> a14 = new TreeMap<String, String>();
	    a14.put("Law Firm", "Prairie State Bicycle, Pedestrian & Urban Traffic Collision Law Collective");
	    a14.put("First Name", "Attorney Norwin");
	    a14.put("Middle Name", "Claude");
	    a14.put("Last Name", "Kuehnemann");
	    a14.put("Name Suffix", "II");
	    a14.put("Phone", "4185552114");
	    a14.put("Office phone", "4185556114");
	    a14.put("Email", "norwin.kuehnemann@mailto.plus");

	    TreeMap<String, String> a15 = new TreeMap<String, String>();
	    a15.put("Law Firm", "Horizon Child Injury, School Negligence & Playground Accident Trial Lawyers");
	    a15.put("First Name", "Attorney Arminius");
	    a15.put("Middle Name", "Jean");
	    a15.put("Last Name", "Hohenfels");
	    a15.put("Name Suffix", "Jr");
	    a15.put("Phone", "5065552115");
	    a15.put("Office phone", "5065556115");
	    a15.put("Email", "arminius.hohenfels@mailto.plus");

	    TreeMap<String, String> a16 = new TreeMap<String, String>();
	    a16.put("Law Firm", "1010 South Meridian Street, Justice Square");
	    a16.put("First Name", "Attorney Frieder");
	    a16.put("Middle Name", "Sebastien");
	    a16.put("Last Name", "Zirngibl");
	    a16.put("Name Suffix", "III");
	    a16.put("Phone", "5195552116");
	    a16.put("Office phone", "5195556116");
	    a16.put("Email", "frieder.zirngibl@mailto.plus");

	    TreeMap<String, String> a17 = new TreeMap<String, String>();
	    a17.put("Law Firm", "Brandtov & Lindenfeld Catastrophic Injury Rechtsanwälte Group");
	    a17.put("First Name", "Attorney Kjell");
	    a17.put("Middle Name", "Mathieu");
	    a17.put("Last Name", "Waldmann");
	    a17.put("Name Suffix", "Sr");
	    a17.put("Phone", "7055552117");
	    a17.put("Office phone", "7055556117");
	    a17.put("Email", "kjell.waldmann@mailto.plus");

	    TreeMap<String, String> a18 = new TreeMap<String, String>();
	    a18.put("Law Firm", "Markov-Bauer Cross-Border Truck & Autobahn Accident Trial Partners");
	    a18.put("First Name", "Attorney Adelmar");
	    a18.put("Middle Name", "Rene");
	    a18.put("Last Name", "Grieshaber");
	    a18.put("Name Suffix", "II");
	    a18.put("Phone", "8675552118");
	    a18.put("Office phone", "8675556118");
	    a18.put("Email", "adelmar.grieshaber@mailto.plus");

	    TreeMap<String, String> a19 = new TreeMap<String, String>();
	    a19.put("Law Firm", "Dietrich & Kuznetsov-Schmidt Serious Spine, Brain & Orthopedic Injury Advocates");
	    a19.put("First Name", "Attorney Erasmus");
	    a19.put("Middle Name", "Laurent");
	    a19.put("Last Name", "Kastenbauer");
	    a19.put("Name Suffix", "III");
	    a19.put("Phone", "7095552119");
	    a19.put("Office phone", "7095556119");
	    a19.put("Email", "erasmus.kastenbauer@mailto.plus");

	    TreeMap<String, String> a20 = new TreeMap<String, String>();
	    a20.put("Law Firm", "Lindenfeld, Hartmannski & Blumenkov Worksite, Scaffold & Industrial Injury Kanzlei");
	    a20.put("First Name", "Attorney Isenbart");
	    a20.put("Middle Name", "Pascal");
	    a20.put("Last Name", "Froehlich");
	    a20.put("Name Suffix", "Jr");
	    a20.put("Phone", "6045552120");
	    a20.put("Office phone", "6045556120");
	    a20.put("Email", "isenbart.froehlich@mailto.plus");

	    // If you want, I can continue this same pattern up to 30 or 50 sets
	    // using ONLY the allowed law firm list, with UNIQUE, less-used names.

	    return new Object[][]{
	        {a1},{a2},{a3},{a4},{a5},
	        {a6},{a7},{a8},{a9},{a10},
	        {a11},{a12},{a13},{a14},{a15},
	        {a16},{a17},{a18},{a19},{a20}
	    };
	}


}
