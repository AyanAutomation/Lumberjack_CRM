package Locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class User_Module_Locaters extends Repeat{

	 
	@FindBy(xpath="//*[text()='RECENT REGISTERED USERS']")
	private WebElement  landed_in_user_module; /*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; */
	
	public User_Module_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	public WebElement landed_in_user_module(){
	wait_for_theElement(landed_in_user_module);
	return landed_in_user_module;} /*
	public WebElement (){
	wait_for_theElement();
	return ;}
	public WebElement (){
	wait_for_theElement();
	return ;} */
}
