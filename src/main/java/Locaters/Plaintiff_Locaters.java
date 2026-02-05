package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Plaintiff_Locaters extends Repeat{

	
	
	@FindBy(xpath="//*[text()='Add New Plaintiff']")
	private WebElement  landed_in_plaintiff_module;
	@FindBy(xpath="//form")
	private WebElement form; 
	@FindBy(xpath="//*[text()='Plaintiff Details']") 
	private WebElement Landed_in_Plaintiff_details_page;
	@FindBy(xpath="//label")
	private List <WebElement> Labels;
	@FindBy(xpath="//div[@class='ant-form-item-control-input-content']")
	private List <WebElement> Values; 
	@FindBy(xpath="//*[text()='Edit']/..")
	private WebElement Edit_button;
	@FindBy(xpath="//*[@placeholder='City']")
	private WebElement City_Field;
	@FindBy(xpath="//*[@class='ant-select-selection-item']")
	private WebElement State_field;
	@FindBy(xpath="//textarea")
	private List <WebElement> Text_Areas;
	@FindBy(name="zipcode")
	private WebElement Zipcode_Field;
	@FindBy(xpath="//*[text()='Back']/..")
	private WebElement Back_button; 
	@FindBy(xpath="//*[text()='ALL REGISTERED PLAINTIFFS']")
	private WebElement Landed_in_Plaintiff_List;/*
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ; 
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	
	
	
	
	
	*/
	
	
	public Plaintiff_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	

	public WebElement landed_in_plaintiff_module(){
	wait_for_theElement(landed_in_plaintiff_module);
	return landed_in_plaintiff_module;}   
	public WebElement form(){
	wait_for_theElement(form);
	return form;}
	public List <WebElement> inputs(){
	form();
	List <WebElement> inputs = form().findElements(By.xpath(".//input"));
	wait_for_theElement(inputs);
	return inputs;}  
	public WebElement Landed_in_Plaintiff_details_page(){
	wait_for_theElement(Landed_in_Plaintiff_details_page);
	return Landed_in_Plaintiff_details_page;}
	public List <WebElement> Labels(){
	wait_for_theElement(Labels);
	return Labels;} 
	public List <WebElement> form_buttons(){
	List <WebElement> form_buttons = form().findElements(By.xpath(".//button"));
	wait_for_theElement(form_buttons);
	return form_buttons;}	
	public List <WebElement> text_area_fields(){
	List <WebElement> text_area_fields = form().findElements(By.xpath(".//textarea"));
	wait_for_theElement(text_area_fields);
	return text_area_fields;}    
	public List <WebElement> Values(){
	wait_for_theElement(Values);
	return Values;}
    public WebElement Edit_button(){
	wait_for_theElement(Edit_button);
	return Edit_button;}
	public WebElement City_Field(){
	wait_for_theElement(City_Field);
	return City_Field;}   
	public WebElement State_field(){
	wait_for_theElement(State_field);
	return State_field;}	
	public List <WebElement> Text_Areas(){
	wait_for_theElement(Text_Areas);
	return Text_Areas;}   
	public WebElement Zipcode_Field(){
	wait_for_theElement(Zipcode_Field);
	return Zipcode_Field;}
	public WebElement Back_button(){
	wait_for_theElement(Back_button);
	return Back_button;}   
	public WebElement Landed_in_Plaintiff_List(){
	wait_for_theElement(Landed_in_Plaintiff_List);
	return Landed_in_Plaintiff_List;}/* 
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
