package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Law_firm_Locaters extends Repeat{
	
	
	@FindBy(xpath="//*[text()='RECENT REGISTERED LAW FIRMS']") 
	private WebElement  landed_in_Law_Firm_module; /*
	@FindBy(xpath="")
	private List <WebElement>  ;*/
	@FindBy(xpath="(//*[@class='ant-card-body']//*[contains(@class,'ant-typography css-')])[3]")
	private WebElement  Law_firm_name_incard; 
	@FindBy(xpath="//input[@placeholder='Search law firm...']")
	private WebElement  Law_firm_search_box; 
	@FindBy(xpath="//*[text()='Edit Law Firm']")
	private WebElement Landed_in_Law_firm_edit_form; 
	@FindBy(xpath="//*[contains(@class,'ant-table-row ant-table-row-level')]//td[3]")
	private List <WebElement> Law_firm_column_Cells_data; 
	@FindBy(xpath="(//*[contains(@class,'ant-descriptions-item-content')])[7]")
	private WebElement  Case_contact_law_firm_address;/*
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
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	
	
	
	
	
	*/
	
	
	public Law_firm_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	

	public WebElement landed_in_Law_Firm_module(){
	wait_for_theElement(landed_in_Law_Firm_module);
	return landed_in_Law_Firm_module;}   
    public WebElement Law_firm_name_incard(){
	wait_for_theElement(Law_firm_name_incard);
	return Law_firm_name_incard;} 
	public WebElement Law_firm_search_box(){
	wait_for_theElement(Law_firm_search_box);
	return Law_firm_search_box;}    
	public WebElement Landed_in_Law_firm_edit_form(){
	wait_for_theElement(Landed_in_Law_firm_edit_form);
	return Landed_in_Law_firm_edit_form;}
	public List <WebElement> Law_firm_Address_column_Cells_datas(){
	wait_for_theElement(Law_firm_column_Cells_data);
	return Law_firm_column_Cells_data;}   
	public WebElement Case_contact_law_firm_address(){
	wait_for_theElement(Case_contact_law_firm_address);
	return Case_contact_law_firm_address;}/*
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}	
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
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

