package Locaters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Repeatative_codes.Repeat;

public class Application_Locaters extends Repeat{
	
	
	@FindBy(xpath="//div[@class='ant-modal-body']")
	private WebElement Popup_add_form;
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[1]")
	private WebElement  plaintiff_dropdown_list; 
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[2]")
	private WebElement  Incident_type_dropdown;
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[3]")
	private WebElement  State_of_incident_dropdown; 
	@FindBy(xpath="(//div[@class='rc-virtual-list-holder-inner'])[2]//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]")
	private List <WebElement> Incident_options ; 
	@FindBy(xpath="//*[@class='ant-picker-content']//*[@class='ant-picker-cell ant-picker-cell-hover ant-picker-cell-selected ant-picker-cell-in-view']")
	private WebElement  calender_date_select; 
	@FindBy(xpath="//div[@class='ant-modal-body']//parent::form//div[@class='ant-space-item']//button")
	private List <WebElement> form_buttons; 
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[4]")
	private WebElement  Lead_Type_dropdown; 
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[5]")
	private WebElement Lead_dropdown; 
	@FindBy(xpath="//div[@class='ant-card-extra']")
	private WebElement  Case_details_edit_buttons;
	@FindBy(xpath="//form")
	private WebElement Edit_form; 
	@FindBy(xpath="//*[@class='ant-select-clear']")
	private WebElement  status_field_clear_button;
	@FindBy(xpath="//*[text()='ALL APPLICATIONS']")
	private WebElement  landed_in_applicationList_confirmation;
	@FindBy(xpath="//tbody")
	private WebElement table_body;
	@FindBy(xpath="//*[@class='ant-card-head-wrapper']")
	private WebElement  Application_page_top_section;
	@FindBy(xpath="//span[@class='ant-tag ant-tag-geekblue css-1egwh03']")
	private WebElement Case_id_tag;
	@FindBy(xpath="//ul[@class='ant-menu-overflow ant-menu ant-menu-root ant-menu-horizontal ant-menu-light css-1egwh03']")
	private WebElement  Application_tab_bar;
	@FindBy(xpath="//*[@aria-label='delete']")
	private WebElement  Delete_button;
	@FindBy(xpath="//*[@class='ant-modal-body']")
	private WebElement  delete_popup_modal;/*
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
	private WebElement  ; */
	
	
	public Application_Locaters(WebDriver d){
	super(d);	
	PageFactory.initElements(d, this);}
	
	
	public WebElement Popup_add_form(){
	wait_for_theElement(Popup_add_form);
	return Popup_add_form;}
	public List <WebElement> form_inputs(){
	Popup_add_form();
	List <WebElement> form_inputs = Popup_add_form().findElements(By.xpath(".//input"));
	wait_for_theElement(form_inputs);
	return form_inputs;}
	public WebElement plaintiff_dropdown_list(){
	wait_for_theElement(plaintiff_dropdown_list);
	return plaintiff_dropdown_list;}
	public WebElement Incident_type_dropdown(){
	wait_for_theElement(Incident_type_dropdown);
	return Incident_type_dropdown;}
	public WebElement State_of_incident_dropdown(){
	wait_for_theElement(State_of_incident_dropdown);
	return State_of_incident_dropdown;} 
	public List<WebElement> Plaintiff_options(){
	plaintiff_dropdown_list();
	List<WebElement> Plaintiff_option = plaintiff_dropdown_list().findElements(By.xpath(".//*[@aria-selected='false']"));
	wait_for_theElement(Plaintiff_option);
	return Plaintiff_option;} 
	public List<WebElement> Incident_options(){
	WebElement panel=Incident_type_dropdown();
	List<WebElement> Incident_options=wait_for_nested(panel,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return Incident_options;}
	public List<WebElement> State_of_incident_options(){
	WebElement Droplist=State_of_incident_dropdown();
	List<WebElement> state_options=wait_for_nested(Droplist,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return state_options;} 
	public WebElement calender_date_select(){
	wait_for_theElement(calender_date_select);
	return calender_date_select;} 
	public List<WebElement> Lead_category_options(){
	WebElement Lead_Dropdownlist=Lead_Type_dropdown();
	List<WebElement> lead_cat_options=wait_for_nested(Lead_Dropdownlist,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return lead_cat_options;} 
	public List<WebElement> Leadoptions(){
	WebElement Lead_Dropdownlist=Lead_dropdown();
	List<WebElement> lead_options=wait_for_nested(Lead_Dropdownlist,By.xpath(".//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]"));
	return lead_options;} 
	public List<WebElement> form_buttons(){
	wait_for_theElement(form_buttons);
	return form_buttons;} 
	public WebElement Lead_Type_dropdown(){
	wait_for_theElement(Lead_Type_dropdown);
	return Lead_Type_dropdown;}
	public WebElement Lead_dropdown(){
	wait_for_theElement(Lead_dropdown);
	return Lead_dropdown;} 
	public WebElement Case_details_edit_buttons(){
	wait_for_theElement(Case_details_edit_buttons);
	return Case_details_edit_buttons;}
	public WebElement Edit_form(){
	wait_for_theElement(Edit_form);
	return Edit_form;} 
	public List <WebElement> Edit_form_inputs(){
	List <WebElement> Edit_form_inputs = Edit_form().findElements(By.xpath(".//input"));
	wait_for_theElement(Edit_form_inputs);
	return Edit_form_inputs;}
	public List <WebElement> Edit_form_buttons(){
	List <WebElement> Edit_form_buttons = Edit_form().findElements(By.xpath(".//button"));
	wait_for_theElement(Edit_form_buttons);
	return Edit_form_buttons;} 
	public WebElement Court_index_input(){
	WebElement Court_index_input= Edit_form().findElement(By.xpath(".//input[@type='text']"));
	wait_for_theElement(Court_index_input);
	return Court_index_input;} 
	public WebElement status_field_clear_button(){
	wait_for_theElement(status_field_clear_button);
	return status_field_clear_button;}
	public WebElement landed_in_applicationList_confirmation(){
	wait_for_theElement(landed_in_applicationList_confirmation);
	return landed_in_applicationList_confirmation;}
	public WebElement table_body(){
	wait_for_theElement(table_body);
	return table_body;}
	public WebElement Application_page_top_section(){
	wait_for_theElement(Application_page_top_section);
	return Application_page_top_section;}
	public WebElement Application_search(){
	WebElement Application_search = Application_page_top_section().findElement(By.xpath(".//input[@type='text']"));
	wait_for_theElement(Application_search);
	return Application_search;}
	public List <WebElement> rows(){
	List <WebElement> rows = table_body().findElements(By.xpath(".//tr[@class='ant-table-row ant-table-row-level-0']"));
	wait_for_theElement(rows);
	return rows;}
	public WebElement Case_id_tag(){
	wait_for_theElement(Case_id_tag);
	return Case_id_tag;}
	public WebElement Application_tab_bar(){
	wait_for_theElement(Application_tab_bar);
	return Application_tab_bar;}
	public List <WebElement> tabs(){
	List <WebElement> tabs = Application_tab_bar().findElements(By.xpath(".//li[@role='menuitem']"));
	wait_for_theElement(tabs);
	return tabs;} 
	public WebElement Delete_button(){
	wait_for_theElement(Delete_button);
	return Delete_button;}
	public WebElement delete_popup_modal(){
	wait_for_theElement(delete_popup_modal);
	return delete_popup_modal;}
	public List <WebElement> modal_buttons(){
	List <WebElement> modal_buttons = delete_popup_modal().findElements(By.xpath(".//button"));
	wait_for_theElement(modal_buttons);
	return modal_buttons;}
	public WebElement Summary_feild(){
	WebElement Summary_feild= Edit_form().findElement(By.xpath(".//textarea"));
	wait_for_theElement(Summary_feild);
	return Summary_feild;}   

}
