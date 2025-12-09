package Locaters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Logout_locaters extends Repeat{

	
	
	 /*
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ;
		@FindBy(xpath="")
		private WebElement  ; */
		
		public Logout_locaters(WebDriver d){
		super(d);	
		PageFactory.initElements(d, this);}
	
		/*
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
