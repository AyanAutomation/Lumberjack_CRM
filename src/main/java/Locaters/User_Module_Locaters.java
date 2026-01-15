package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class User_Module_Locaters extends Repeat{

	 
	@FindBy(xpath="//*[text()='RECENT REGISTERED USERS']")
	private WebElement  landed_in_user_module; 
	@FindBy(xpath="//form")
	private WebElement Form; 
	@FindBy(name="firstName")
	private WebElement  First_Name;
	@FindBy(name="middleName")
	private WebElement  Middle_Name;
	@FindBy(name="lastName")
	private WebElement Last_Name;
	@FindBy(xpath="//input[@type='tel']")
	private List <WebElement> ph_number_fields ; 
	@FindBy(name="email")
	private WebElement email;
	@FindBy(xpath="//span[contains(@class,'ant-select-selection-placeholder') and normalize-space()='Select groups']/ancestor::div[contains(@class,'ant-select')]")
	private WebElement Group_feild; 
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list')])[1]")
	private WebElement Group_dropdown; 
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list-holder-inner')])[1]")
	private WebElement Inner_dropdown_holder;  
	@FindBy(xpath="//*[@class='ant-select-selection-item']")
	private WebElement item_selected; /*
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
	
	public User_Module_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	public WebElement landed_in_user_module(){
	wait_for_theElement(landed_in_user_module);
	return landed_in_user_module;} 
	public WebElement Form(){
	wait_for_theElement(Form);
	return Form;}
	public WebElement First_Name(){
	wait_for_theElement(First_Name);
	return First_Name;} 
	public WebElement Last_Name(){
	wait_for_theElement(Last_Name);
	return Last_Name;}
	public List <WebElement> ph_number_fields(){
	wait_for_theElement(ph_number_fields);
	return ph_number_fields;}
	public WebElement email(){
	wait_for_theElement(email);
	return email;}
	public WebElement Middle_Name(){
	wait_for_theElement(Middle_Name);
	return Middle_Name;}
	public WebElement Group_feild(){
	wait_for_theElement_tobe_clickable(Group_feild);
	return Group_feild;} 
	public WebElement Group_feild_input(){
	WebElement input = Group_feild().findElement(By.xpath(".//input[contains(@class,'ant-select-selection-search-input')]"));
    wait_for_theElement(input); 
    return input;}
	public WebElement Group_dropdown(){
	wait_for_theElement(Group_dropdown);
	return Group_dropdown;}
	public WebElement Inner_dropdown_holder(){
	wait_for_theElement(Inner_dropdown_holder);
	return Inner_dropdown_holder;}
	public List<WebElement> options(){
	WebElement dropdown;
	List<WebElement> options;
	try{
		dropdown= Group_dropdown();
		options = wait_for_nested_presence(dropdown,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	}catch(Exception mm){
		dropdown= Inner_dropdown_holder();
		options = wait_for_nested_presence(dropdown,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	}
	wait_for_theElement(options);
	return options;}
	public WebElement item_selected(){
	wait_for_theElement(item_selected);
	return item_selected;} /*
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} 
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}*/
}
