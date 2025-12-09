package Locaters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Login_Locaters extends Repeat{
	
	
	
	
	@FindBy(name="email")
	private WebElement  id_field;
	@FindBy(name="password")
	private WebElement  password_field;
	@FindBy(xpath="//*[@class='ant-input-suffix']//span")
	private WebElement  password_eye_button;
	@FindBy(xpath="//button")
	private List<WebElement>  buttons;
	@FindBy(xpath="//*[@role='alert']")
	private WebElement toast;
	@FindBy(xpath="//*[@role='menu']")
	private WebElement  login_confirmation; 
	@FindBy(xpath="//*[@class='auth-right']")
	private WebElement  Landed_in_login_page; 
	@FindBy(xpath="//*[@class='ant-form-item-explain-error']")
	private List<WebElement>  inline_errors; /*
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private WebElement  ; */
	
	public Login_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	
 
	 
	public WebElement id_field(){
	wait_for_theElement(id_field);
	return id_field;}
	public WebElement password_field(){
	wait_for_theElement(password_field);
	return password_field;}
	public WebElement password_eye_button(){
	wait_for_theElement(password_eye_button);
	return password_eye_button;}
	public List<WebElement> buttons(){
	wait_for_theElement(buttons);
	return buttons;}
	public WebElement toast(){
	wait_for_theElement(toast);	
	return toast;}
	public WebElement login_confirmation(){
	wait_for_theElement(login_confirmation);
	return login_confirmation;} 
	public WebElement Landed_in_login_page(){
	wait_for_theElement(Landed_in_login_page);
	return Landed_in_login_page;}
	public List<WebElement> inline_errors(){
	wait_for_theElement(inline_errors);
	return inline_errors;} /*
	public WebElement (){
	wait_for_theElement();
	return ;} */ 
	
	
	
	
}
