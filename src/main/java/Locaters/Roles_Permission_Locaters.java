package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Repeatative_codes.Repeat;

public class Roles_Permission_Locaters extends Repeat{
	
	
	
	@FindBy(xpath="(//*[text()='Role Name'])[1]")
	private WebElement  Landed_in_role_page; 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement  Submit_button;  
	@FindBy(xpath="(//*[text()='Group Name'])[1]")
	private WebElement  Landed_in_group_page; 
	@FindBy(xpath="//*[contains(@class,'ant-select-selector')]")
	private WebElement  Role_dropdown_field;
	@FindBy(name="name")
	private WebElement  Group_name_feild; 
	@FindBy(xpath="//*[contains(@class,'ant-select-item-option-content')]")
	private List <WebElement>  Role_dropdown_options;
	@FindBy(xpath="(//*[contains(@class,'rc-virtual-list')])[1]")
	private WebElement Dropdown; 
	@FindBy(xpath="//*[@class='ant-select-selection-search']//input")
	private WebElement  Role_Field; /*
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
	
	
	
	
	public Roles_Permission_Locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
	
	
	public WebElement Landed_in_role_page(){
	wait_for_theElement(Landed_in_role_page);
	return Landed_in_role_page;}   
	public WebElement Submit_button(){
	wait_for_theElement(Submit_button);
	return Submit_button;} 
	public WebElement Landed_in_group_page(){
	wait_for_theElement(Landed_in_group_page);
	return Landed_in_group_page;} 
	public WebElement Role_dropdown_field(){
	wait_for_theElement(Role_dropdown_field);
	return Role_dropdown_field;}   
	public WebElement Group_name_feild(){
	wait_for_theElement(Group_name_feild);
	return Group_name_feild;} 
	public List <WebElement> Role_dropdown_options(){
	List<WebElement> Role_dropdown_options=wait_for_nested(Dropdown(),By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return Role_dropdown_options;} 
	public WebElement Dropdown(){
	wait_for_theElement(Dropdown);
	return Dropdown;} 
	public WebElement Role_Field(){
	wait_for_theElement(Role_Field);
	return Role_Field;} /*
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;}
	public List <WebElement> (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;} */

}
