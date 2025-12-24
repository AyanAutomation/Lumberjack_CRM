package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class temp_mail_Locaters extends Repeat{
	
	
	 /*
	@FindBy(xpath="")
	private List <WebElement>  ; */
	@FindBy(xpath="//form[@id='pre_form']")
	private WebElement form; 
	@FindBy(xpath="//div[@class='inbox']")
	private WebElement inbox_section; /*
	@FindBy(xpath="")
	private List <WebElement>  ; */
	@FindBy(xpath="//*[text()='Back']")
	private WebElement  Entered_mail_details; /*
	@FindBy(xpath="")/*
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
	@FindBy(xpath="")
	private WebElement  ;
	@FindBy(xpath="")
	private List <WebElement>  ;
	@FindBy(xpath="")
	private WebElement  ;
	
	
   */
	
	
	public temp_mail_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}

	
	
	public WebElement form(){
	wait_for_theElement(form);
	return form;} 
	public WebElement mail_id_box(){
	WebElement mail_id_box = form().findElement(By.xpath(".//input[@type='text']"));
	wait_for_theElement(mail_id_box);
	return mail_id_box;}   
	public WebElement inbox_section(){
	wait_for_theElement(inbox_section);
	return inbox_section;}
	public List <WebElement> mails(){
	List <WebElement> mails = inbox_section().findElements(By.xpath(".//*[@class='mail']"));
	wait_for_theElement(mails);
	return mails;}  
	public WebElement Entered_mail_details(){
	wait_for_theElement(Entered_mail_details);
	return Entered_mail_details;} /*
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
	return ;}  */

}
