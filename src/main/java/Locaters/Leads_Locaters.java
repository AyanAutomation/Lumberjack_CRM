package Locaters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import Repeatative_codes.Repeat;

public class Leads_Locaters extends Repeat{
	
	
	
	@FindBy(xpath="//form[@id='application_form']")
	private WebElement Form;
	@FindBy(name="advance_amount")
	private WebElement advance_amount;
	@FindBy(name="full_name")
	private WebElement full_name;
	@FindBy(name="date_of_birth")
	private WebElement date_of_birth;
	@FindBy(name="phone_number")
	private WebElement phone_number;
	@FindBy(name="email")
	private WebElement email;
	@FindBy(name="mailing_street_address")
	private WebElement mailing_street_address;
	@FindBy(name="city")
	private WebElement city;
	@FindBy(name="lawyer_name")
	private WebElement lawyer_name;
	@FindBy(name="lawyer_phone")
	private WebElement lawyer_phone;
	@FindBy(name="law_firm_name")
	private WebElement law_firm_name;
	@FindBy(name="accident_date")
	private WebElement accident_date;
	@FindBy(name="accident_location")
	private WebElement accident_location;
	@FindBy(name="accident_description")
	private WebElement accident_description;
	@FindBy(name="accident_injuries")
	private WebElement accident_injuries; 
	@FindBy(xpath="//button[@type='submit']")
	private List<WebElement> below_buttons ;
	@FindBy(xpath="//label[text()='Are you Enrolled in Medicare, Medicaid, or any other governmental health coverage?']/..//label[@class='radio']")
	private List<WebElement> First_questions_buttons;
	@FindBy(xpath="//label[text()='Since your accident, have you been injured in any other traumatic incidents?']/..//label[@class='radio']")
	private List<WebElement> second_questions_buttons;
	@FindBy(xpath="//label[text()='In the 5 years before the accident, did you have a violation for no auto insurance?']/..//label[@class='radio']")
	private List<WebElement> Third_questions_buttons;
	@FindBy(xpath="//label[text()='Have you previously received a settlement advance for this case?']/..//label[@class='radio']")
	private List<WebElement> Fourth_questions_buttons;
	@FindBy(xpath="//label[text()='Were other people injured in this accident?']/..//label[@class='radio']")
	private List<WebElement> Fifth_questions_buttons;
    @FindBy(xpath="//label[text()='Are you currently behind on child support?']/..//label[@class='radio']")
	private List<WebElement> sixth_questions_buttons; 
	@FindBy(name="healthcare_enrollment_explain")
	private WebElement healthcare_enrollment_explain;
	@FindBy(name="other_incidents_explain")
	private WebElement other_incidents_explain; 
	@FindBy(name="insurance_violation_explain")
	private WebElement insurance_violation_explain;
	@FindBy(name="previous_advance_explain")
	private WebElement previous_advance_explain; 
	@FindBy(name="others_injured_explain")
	private WebElement others_injured_explain;
	@FindBy(name="child_support_explain")
	private WebElement child_support_explain; /*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;  */
	
	public Leads_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	
	
	public WebElement Form(){
	wait_for_theElement(Form);
	return Form;} 
	public WebElement advance_amount(){
	wait_for_theElement(advance_amount);
	return advance_amount;}
	public WebElement full_name(){
	wait_for_theElement(full_name);
	return full_name;}
	public WebElement date_of_birth(){
	wait_for_theElement(date_of_birth);
	return date_of_birth;}
	public WebElement phone_number(){
	wait_for_theElement(phone_number);
	return phone_number;}
	public WebElement email(){
	wait_for_theElement(email);
	return email;}
	public WebElement mailing_street_address(){
	wait_for_theElement(mailing_street_address);
	return mailing_street_address;}
	public WebElement city(){
	wait_for_theElement(city);
	return city;}
	public WebElement lawyer_name(){
	wait_for_theElement(lawyer_name);
	return lawyer_name;}
	public WebElement lawyer_phone(){
	wait_for_theElement(lawyer_phone);
	return lawyer_phone;}
	public WebElement law_firm_name(){
	wait_for_theElement(law_firm_name);
	return law_firm_name;} 
	public WebElement accident_date(){
	wait_for_theElement(accident_date);
	return accident_date;}
	public WebElement accident_location(){
	wait_for_theElement(accident_location);
	return accident_location;}
	public WebElement accident_description(){
	wait_for_theElement(accident_description);
	return accident_description;}
	public WebElement accident_injuries(){
	wait_for_theElement(accident_injuries);
	return accident_injuries;}
	public List<WebElement> below_buttons(){
	wait_for_theElement(below_buttons);
	return below_buttons;}
	public List<WebElement> First_questions_buttons(){
	wait_for_theElement(First_questions_buttons);
	return First_questions_buttons;}
	public List<WebElement> second_questions_buttons(){
	wait_for_theElement(second_questions_buttons);
	return second_questions_buttons;}
	public List<WebElement> Third_questions_buttons(){
	wait_for_theElement(Third_questions_buttons);
	return Third_questions_buttons;}
	public List<WebElement> Fourth_questions_buttons(){
	wait_for_theElement(Fourth_questions_buttons);
	return Fourth_questions_buttons;}
	public List<WebElement> Fifth_questions_buttons(){
	wait_for_theElement(Fifth_questions_buttons);
	return Fifth_questions_buttons;}
	public List<WebElement> sixth_questions_buttons(){
	wait_for_theElement(sixth_questions_buttons);
	return sixth_questions_buttons;} 
	public WebElement healthcare_enrollment_explain(){
	wait_for_theElement(healthcare_enrollment_explain);
	return healthcare_enrollment_explain;}
	public WebElement other_incidents_explain(){
	wait_for_theElement(other_incidents_explain);
	return other_incidents_explain;}
	public WebElement insurance_violation_explain(){
	wait_for_theElement(insurance_violation_explain);
	return insurance_violation_explain;}
	public WebElement previous_advance_explain(){
	wait_for_theElement(previous_advance_explain);
	return previous_advance_explain;}
	public WebElement others_injured_explain(){
	wait_for_theElement(others_injured_explain);
	return others_injured_explain;}
	public WebElement child_support_explain(){
	wait_for_theElement(child_support_explain);
	return child_support_explain;}/*
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} */
	

}
