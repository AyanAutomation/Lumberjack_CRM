package Locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Roles_Permission_Locaters extends Repeat{
	
	
	
	@FindBy(xpath="(//*[text()='Role Name'])[1]")
	private WebElement  Landed_in_role_page; 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement  Submit_button;  /*
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
	
	
	
	
	public Roles_Permission_Locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
	
	
	public WebElement Landed_in_role_page(){
	wait_for_theElement(Landed_in_role_page);
	return Landed_in_role_page;}   
	public WebElement Submit_button(){
	wait_for_theElement(Submit_button);
	return Submit_button;} /*
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
