package Locaters;

import java.util.List;
import java.util.NoSuchElementException;

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
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[5]")
	private WebElement  fifth_dropdown;
	@FindBy(xpath="(//div[@class='rc-virtual-list-holder-inner'])[2]//div[contains(@class,'ant-select-item') and contains(@class,'ant-select-item-option') and @title]")
	private List <WebElement> Incident_options ; 
	@FindBy(xpath="//*[@class='ant-picker-content']//*[@class='ant-picker-cell ant-picker-cell-hover ant-picker-cell-selected ant-picker-cell-in-view ant-picker-cell-today']")
	private WebElement  calender_date_select; 
	@FindBy(xpath="//*[@class='ant-picker-content']//*[@class='ant-picker-cell ant-picker-cell-hover ant-picker-cell-selected ant-picker-cell-in-view']")
	private WebElement Backup_calender_date_select; 
	@FindBy(xpath="//div[@class='ant-modal-body']//parent::form//div[@class='ant-space-item']//button")
	private List <WebElement> form_buttons; 
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[4]")
	private WebElement  Lead_Type_dropdown; 
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[5]")
	private WebElement Lead_dropdown; 
	@FindBy(xpath="//div[@class='ant-card-extra']")
	private WebElement Case_details_edit_buttons;
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
	private WebElement  popup_modal;
	@FindBy(xpath="//*[@aria-label='edit']")
	private List <WebElement> Application_amount_edit_buttons;
	@FindBy(xpath="//div[@class='ant-descriptions-view']")
	private WebElement  Application_details_Section;
	@FindBy(xpath="//*[@aria-label='cloud-download']/..//span[text()=' GENERATE CONTRACT ']")
	private WebElement  Generate_contract_button;
	@FindBy(xpath="//*[@class='ant-card-actions']//*[@class='ant-select-selection-item']")
	private WebElement  Application_Details_Dropdown_Feild; 
	@FindBy(xpath="//*[text()='ADD NEW LAWFIRM']")
	private WebElement  lawFirm_AddButton_ContactTab;
	@FindBy(xpath="//*[@class='ant-card-extra']//button//span[text()='ADD NEW CONTACT']")
	private WebElement  Contact_AddButton_ContactTab;
	@FindBy(xpath="(//div[contains(@class,'ant-dropdown')][.//ul[contains(@class,'ant-dropdown-menu')]])[last()]")
	private WebElement  Contact_type_option_dropdown_list;
	@FindBy(xpath="//div[@role='dialog']")
	private WebElement  pop_up_contact_list;
	@FindBy(xpath="(//div[@role='dialog']//div[@class='ant-space-item'])/..")
	private WebElement  pop_up_contact_list_Footer; 
	@FindBy(xpath="//*[@class='tox-editor-container']")
	private WebElement Contract_editor; 
	@FindBy(xpath="(//tbody[contains(@class,'ant-table-tbody')]//tr[not(@aria-hidden='true')]//td[contains(@class,'ant-table-cell')][.//div[contains(@class,'ant-space')]]//button[contains(@class,'ant-btn') and contains(@class,'ant-btn-dangerous')])[1]")
	private WebElement  Contact_list_attorney_delete_button; 
	@FindBy(xpath="//form//div[@class='ant-table-content']//input[@type='text']")
	private WebElement  rate_of_return_feild;
	@FindBy(xpath="(//*[@role='dialog']//button)[4]")
	private WebElement contract_generator_button; 
	@FindBy(xpath="//iframe")
	private WebElement  contract_doc_iframe; 
	@FindBy(xpath="//table[@class='main-table mce-item-table']")
	private WebElement Contract_lien_table;
	@FindBy(xpath="(//*[text()='Save Changes']/..)[1]")
	private WebElement  Save_changes_button; 
	@FindBy(xpath="//*[@class='ant-empty-description']")
	private WebElement  Dropdown_showing_nodata; 
	@FindBy(xpath="(//*[@class='ant-card-body'])[3]")
	private WebElement  Plaintiff_section_in_contacts_tab; 
	@FindBy(xpath="(//*[@class='ant-card-actions']//button//span[text()='SIGNED MANUALLY '])[1]")
	private WebElement  Manual_sign_in_button;
	@FindBy(xpath="(//div[contains(@class,'ant-modal') and not(contains(@style,'display: none'))]//input[@type='file'])[last()]")
	private WebElement  upload; 
	@FindBy(xpath="//*[@class='ant-upload-list-item-name']")
	private WebElement  file_upload_preview_confirmation; 
	@FindBy(xpath="(//tbody[@class='ant-table-tbody'])[1]//tr[@class='ant-table-row ant-table-row-level-0']")
	private List <WebElement> Open_Lien_table_contents; 
	@FindBy(xpath="//input[@id='rc_select_6']")
	private WebElement  lead_source_field; 
	@FindBy(xpath="//*[@aria-label='import']/../..")
	private WebElement  import_Button; 
	@FindBy(xpath="//*[@class='ant-select-clear']")
	private WebElement Filter_clear; 
	@FindBy(xpath="a//*[@class='ant-spin-container']")
	private WebElement list_loader; 
	@FindBy(xpath="//*[contains(@class,'ant-tag ant-tag')]")
	private List <WebElement> Case_tags; 
	@FindBy(xpath="//*[@class='ant-table-content'][1]//*[@class='ant-empty-description']")
	private WebElement  Lien_table_empty; 
	@FindBy(xpath="(//tbody[@class='ant-table-tbody'])[1]")
	private WebElement First_table_body; 
	@FindBy(xpath="//div[@class='ant-card-body']//button")
	private WebElement Case_Action_Dropdown; 
	@FindBy(xpath="//div[@class='ant-dropdown css-1egwh03 ant-dropdown-placement-bottomLeft']//*[@role='menu']")
	private WebElement Case_Action_Dropdown_list; 
	@FindBy(xpath="//textArea")
	private WebElement textArea; 
	@FindBy(xpath="(//button[contains(@class,'ant-btn-color-primary ant-btn-variant-solid')])[3]")
	private WebElement  Create_Contact_button; 
	@FindBy(xpath="(//div[@class='ant-modal-body'])[2]")
	private WebElement  second_pop_up_form; 
	@FindBy(xpath="(//div[@class='ant-modal-body'])[3]")
	private WebElement  Third_popup_form; 
	@FindBy(xpath="(//*[@aria-label='plus']/..)[2]")
	private WebElement Notes_Add_Button; 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Submit_Button;
	@FindBy(xpath="//*[text()=' EDIT TERMS ']/..")
	private WebElement  Edit_contract_button;
	@FindBy(xpath="//span[text()='Add Buyout']")
	private WebElement  Add_buyout_button_inside_edit_contract_from;
	@FindBy(xpath="//span[normalize-space()='Funder Name']/following::input[1]")
	private WebElement  Buyout_funder_name_inside_pop_up_modal_form;
	@FindBy(xpath="//span[normalize-space()='Buyout Amount']/following::input[1]")
	private WebElement  Buyout_Amount_inside_pop_up_modal_form;
	@FindBy(xpath="//span[normalize-space()='Expiry On']/following::input[1]")
	private WebElement  Buyout_Date_inside_pop_up_modal_form; 
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Submit_button; 
	@FindBy(xpath="//*[contains(@class,'ant-btn-dangerous ant-btn-color-dangerous ant-btn-variant-text')]")
	private WebElement  Cancel_Contract_Button; 
	@FindBy(xpath="(//*[@class='ant-float-btn-body']/..)[1]")
	private WebElement Send_button;
	@FindBy(xpath="(//*[@class='ant-float-btn-body']/..)[2]")
	private WebElement  Email_button;
	@FindBy(xpath="(//*[@class='ant-float-btn-body']/..)[3]")
	private WebElement SMS_Send_Button;
	@FindBy(xpath="//*[text()=' SAVED MESSAGES ']/..")
	private WebElement Saved_Message_button;
	@FindBy(xpath="//*[contains(@class,'ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-ligh')]")
	private WebElement  Message_Template_Dropdown_list;
	@FindBy(xpath="//*[text()='Save New Message']")
	private WebElement  Landed_In_Template_Creation_Form;
	@FindBy(xpath="//*[text()='SEND SMS']")
	private WebElement  Landed_in_sms_send_form; 
	@FindBy(xpath="(//input[@type='text' or contains(@class,'ant-input-outlined')])[2]")
	private WebElement  Subject_field;
	@FindBy(xpath="(//input[@type='search'])[4]")
	private WebElement  Email_to_field;
	@FindBy(xpath="(//*[contains(@class,'ant-select-dropdown-placement-bottomLeft')])[2]")
	private WebElement  Email_to_option_dropdown;
	@FindBy(xpath="//body[@spellcheck='false']")
	private WebElement  Email_Body; 
	@FindBy(xpath="//*[text()='Cc']/..")
	private WebElement CC_button;
	@FindBy(xpath="(//input[@type='search'])[5]")
	private WebElement cc_field;
	@FindBy(xpath="(//input[@type='search'])[6]")
	private WebElement bcc_field;
	@FindBy(xpath="//*[text()='Bcc']/..")
	private WebElement Bcc_button;
	@FindBy(xpath="//*[contains(@class,'ant-descriptions ant-descriptions-small')]")
	private WebElement  Application_Card_Body; 
	@FindBy(xpath="//*[@class='case-feed-container']")
	private WebElement  Case_Feed_Section; 
	@FindBy(xpath="(//*[@class='ant-timeline-item-content']//div)[1]")
	private WebElement  mail_card_in_feed; 
	@FindBy(xpath="//*[text()='Payoff Details']/..")
	private WebElement  Payoff_Button;
	@FindBy(xpath="//*[text()='Payoff Table']")
	private WebElement  Payoff_table;
	@FindBy(xpath="//*[text()='Remove']/..")
	private WebElement Remove_Button;
	@FindBy(xpath="//*[text()='Edit']/..")
	private WebElement Edit_button;
	@FindBy(xpath="//*[contains(@class,'ant-descriptions-item-content')]")
	private List <WebElement> Description_content_items;
	@FindBy(xpath="//*[text()='Edit Details']")
	private WebElement Edit_details_title_form;
	@FindBy(xpath="//*[text()='LAW FIRM INFO']")
	private WebElement Law_firm_info_title_text;
	@FindBy(xpath="//*[contains(@class,'ant-descriptions-item-label ant-descriptions-item-no-colon')]")
	private List <WebElement> Description_content_Labels; 
	@FindBy(xpath="//h3")
	private WebElement Title_plaintiff_name;/*
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
	public List <WebElement> payment_logger_form_inputs(){
	Popup_add_form();
	List <WebElement> payment_logger_form_inputs = Popup_add_form().findElements(By.xpath(".//input[@type='search' or @type='text' or @placeholder='Select date' or @name='amount']"));
	wait_for_theElement(payment_logger_form_inputs);
	return payment_logger_form_inputs;}
	public List <WebElement> form_fields_with_placeholder(){
	Popup_add_form();
	List <WebElement> form_fields_with_placeholder = Popup_add_form().findElements(By.xpath(".//*[@class='ant-select-selection-placeholder']"));
	wait_for_theElement(form_fields_with_placeholder);
	return form_fields_with_placeholder;}
	public List <WebElement> poup_up_form_buttons(){
    List <WebElement> poup_up_form_buttons = Popup_add_form().findElements(By.xpath(".//button"));
	wait_for_theElement(poup_up_form_buttons);
	return poup_up_form_buttons;}
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
	List<WebElement> Plaintiff_option = plaintiff_dropdown_list().findElements(By.xpath(".//*[@aria-selected='false' or @aria-selected='true']"));
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
	try {wait_for_theElement(calender_date_select);
	return calender_date_select;}
	catch(Exception switch_to_backup_locater){
	try {Thread.sleep(800);
	wait_for_theElement(Backup_calender_date_select);
	return Backup_calender_date_select;
	}catch(Exception mmo)
	{By Date_element = By.xpath("//*[@class='ant-picker-content']//*[@class='ant-picker-cell ant-picker-cell-hover ant-picker-cell-selected ant-picker-cell-in-view ant-picker-cell-today']");
	return wait_for_presenceBy(Date_element);}}} 
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
    public WebElement Application_status_filter(){
	WebElement Application_status_filter = Application_page_top_section().findElement(By.xpath(".//*[@class='ant-select-selector']"));
	wait_for_theElement(Application_status_filter);
	return Application_status_filter;}
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
	public WebElement popup_modal(){
	wait_for_theElement(popup_modal);
	return popup_modal;}
	public List <WebElement> modal_buttons(){
	List <WebElement> modal_buttons = popup_modal().findElements(By.xpath(".//button"));
	wait_for_theElement(modal_buttons);
	return modal_buttons;}
	public WebElement Summary_feild(){
	WebElement Summary_feild= Edit_form().findElement(By.xpath(".//textarea"));
	wait_for_theElement(Summary_feild);
	return Summary_feild;}   
	public List <WebElement> Application_amount_edit_buttons(){
	wait_for_theElement(Application_amount_edit_buttons);
	return Application_amount_edit_buttons;}    
	public List <WebElement> Modal_Input_Feilds(){
	List <WebElement> Modal_Input_Feilds = popup_modal().findElements(By.xpath(".//input"));
	wait_for_theElement(Modal_Input_Feilds);
	return Modal_Input_Feilds;}   
	public WebElement Application_details_Section(){
	wait_for_theElement(Application_details_Section);
	return Application_details_Section;}   
	public List <WebElement> Application_Amount_input_Fields(){
	List <WebElement> Application_Amount_input_Fields = Application_details_Section().findElements(By.xpath(".//input[@role='spinbutton']"));
	wait_for_theElement(Application_Amount_input_Fields);
	return Application_Amount_input_Fields;}   
	public WebElement Generate_contract_button(){
	wait_for_theElement(Generate_contract_button);
	return Generate_contract_button;}   
	public WebElement Application_Details_Dropdown_Feild(){
	wait_for_theElement(Application_Details_Dropdown_Feild);
	return Application_Details_Dropdown_Feild;}    
	public WebElement lawFirm_AddButton_ContactTab(){
	try{
	wait_for_theElement(lawFirm_AddButton_ContactTab);
	return lawFirm_AddButton_ContactTab;}
	catch(Exception Add_button_not_found){
	wait_for_theElement(Remove_Button);
	return Remove_Button;}}   
	public WebElement Contact_AddButton_ContactTab(){
	wait_for_theElement(Contact_AddButton_ContactTab);
	return Contact_AddButton_ContactTab;}   
	public WebElement Contact_type_dropdown_list(){
	wait_for_theElement(Contact_type_option_dropdown_list);
	return Contact_type_option_dropdown_list;}   
	public List <WebElement> Contact_type_Options(){
	WebElement Contact_type_option_dropdown = Contact_type_dropdown_list();
	List <WebElement> Contact_type_Options = wait_for_nested(Contact_type_option_dropdown,By.xpath(".//li"));
	return Contact_type_Options;}   
	public List <WebElement> List_Checkboxes(){
	List <WebElement> List_Checkboxes = pop_up_contact_list().findElements(By.xpath(".//input[@type='checkbox']"));
	wait_for_theElement(List_Checkboxes);
	return List_Checkboxes;}   
	public WebElement Popup_modal_search(){
	WebElement Popup_modal_search = pop_up_contact_list().findElement(By.xpath(".//input[@type='text']"));
	wait_for_theElement(Popup_modal_search);
	return Popup_modal_search;}   
	public WebElement pop_up_contact_list(){
	wait_for_theElement(pop_up_contact_list);
	return pop_up_contact_list;}   
	public WebElement pop_up_contact_list_Footer(){
	wait_for_theElement(pop_up_contact_list_Footer);
	return pop_up_contact_list_Footer;}   
	public List <WebElement> popup_contact_list_footer_buttons(){
	List <WebElement> popup_contact_list_footer_buttons = pop_up_contact_list_Footer().findElements(By.xpath(".//button"));
	wait_for_theElement(popup_contact_list_footer_buttons);
	return popup_contact_list_footer_buttons;}   
	public WebElement Contact_list_attorney_delete_button(){
    wait_for_theElement(Contact_list_attorney_delete_button);
	return Contact_list_attorney_delete_button;}   
	public WebElement Contract_editor(){
	wait_for_theElement(Contract_editor);
	return Contract_editor;}  
	public List <WebElement> fee_amount_feilds(){
	List <WebElement> fee_amount_feilds = Edit_form().findElements(By.xpath(".//input[@placeholder='Fee Amount']"));
	wait_for_theElement(fee_amount_feilds);
	return fee_amount_feilds;} 
    public WebElement rate_of_return_feild(){
	wait_for_theElement(rate_of_return_feild);
	return rate_of_return_feild;}   
	public WebElement Interest_Start_Date(){
	WebElement Interest_Start_Date = Edit_form().findElement(By.xpath(".//input[@placeholder='Interest Start Date']"));
	wait_for_theElement(Interest_Start_Date);
	return Interest_Start_Date;}   
	public WebElement Agreement_Date_feild(){
	WebElement Agreement_Date_feild = Edit_form().findElement(By.xpath(".//input[@placeholder='Agreement Date']"));
	wait_for_theElement(Agreement_Date_feild);
	return Agreement_Date_feild;}    
	public WebElement contract_generator_button(){
	wait_for_theElement(contract_generator_button);
	return contract_generator_button;}  
	public WebElement contract_doc_iframe(){
	wait_for_theElement(contract_doc_iframe);
	return contract_doc_iframe;}    
	public WebElement Contract_lien_table(){
	wait_for_theElement(Contract_lien_table);
	return Contract_lien_table;}    
	public List <WebElement> Cell_datas(){
	Contract_lien_table();
	List <WebElement> Cell_datas = Contract_lien_table().findElements(By.xpath(".//tr//td"));
	wait_for_theElement(Cell_datas); 
	return Cell_datas;}   
	public WebElement Save_changes_button(){
	wait_for_theElement(Save_changes_button);
	return Save_changes_button;}     
	public WebElement Dropdown_showing_nodata(){
	wait_for_theElement(Dropdown_showing_nodata);
	return Dropdown_showing_nodata;}    
	public WebElement Plaintiff_section_in_contacts_tab(){
	wait_for_theElement(Plaintiff_section_in_contacts_tab);
	return Plaintiff_section_in_contacts_tab;}   
	public List <WebElement> Plaintiff_feild_labels_and_values(){
	List <WebElement> Palintiff_feild_labels_and_values = Plaintiff_section_in_contacts_tab().findElements(By.xpath(".//span"));
	wait_for_theElement(Palintiff_feild_labels_and_values);
	return Palintiff_feild_labels_and_values;}   
	public WebElement Requested_amount_input_field_in_Applications_tab(){
	WebElement Requested_amount_input_field_in_Applications_tab = Plaintiff_section_in_contacts_tab().findElement(By.xpath(".//input"));
	wait_for_theElement(Requested_amount_input_field_in_Applications_tab);
	return Requested_amount_input_field_in_Applications_tab;}
	public WebElement Appilcation_Add_button(){
	WebElement Appilcation_Add_button = Plaintiff_section_in_contacts_tab().findElement(By.xpath(".//button"));
	wait_for_theElement(Appilcation_Add_button);
	return Appilcation_Add_button;}
	public WebElement Manual_sign_in_button(){
	wait_for_theElement(Manual_sign_in_button);
	return Manual_sign_in_button;}   
	public WebElement upload(){
	By uploadBy = By.xpath("(//div[contains(@class,'ant-modal') and not(contains(@style,'display: none'))]//input[@type='file'])[last()]");
	return wait_for_presenceBy(uploadBy);}   
	public WebElement file_upload_preview_confirmation(){
	wait_for_theElement(file_upload_preview_confirmation);
	return file_upload_preview_confirmation;}    
	public List <WebElement> Open_Lien_table_contents(){
	wait_for_theElement(Open_Lien_table_contents);
	return Open_Lien_table_contents;}   
	public WebElement fifth_dropdown(){
	wait_for_theElement(fifth_dropdown);
	return fifth_dropdown;}   
	public List<WebElement> fifth_dropdown_options(){
	fifth_dropdown();
	List<WebElement> fifth_dropdown_options = fifth_dropdown().findElements(By.xpath(".//*[@aria-selected='false']"));
	wait_for_theElement(fifth_dropdown_options);
	return fifth_dropdown_options;}   
	public WebElement lead_source_field(){
	wait_for_theElement(lead_source_field);
	return lead_source_field;}   
	public WebElement import_Button(){
	wait_for_theElement(import_Button);
	return import_Button;}   
	public WebElement Filter_clear(){
	wait_for_theElement(Filter_clear);
	return Filter_clear;}   
	public WebElement list_loader(){
	wait_for_theElement(list_loader);
	return list_loader;}    
	public List <WebElement> Case_tags(){
	wait_for_theElement(Case_tags);
	return Case_tags;}    
	public WebElement Lien_table_empty(){
	wait_for_theElement(Lien_table_empty);
	return Lien_table_empty;}   
	public WebElement First_table_body(){
	wait_for_theElement(First_table_body);
	return First_table_body;} 
	public List <WebElement> First_table_first_column_cells(){
	List<WebElement> First_table_first_column_cellData = First_table_body().findElements(By.xpath(".//td[1]"));
	wait_for_theElement(First_table_first_column_cellData);
	return First_table_first_column_cellData;}   
	public List <WebElement> First_table_second_column_cells(){
	List<WebElement> First_table_second_column_cells = First_table_body().findElements(By.xpath(".//td[2]"));
	wait_for_theElement(First_table_second_column_cells);
	return First_table_second_column_cells;}
	public List <WebElement> First_table_Third_column_cellData(){
	List<WebElement> First_table_Third_column_cellData = First_table_body().findElements(By.xpath(".//td[3]"));
	wait_for_theElement(First_table_Third_column_cellData);
	return First_table_Third_column_cellData;}
	public List <WebElement> First_table_fourth_column_cellData(){
	List<WebElement> First_table_fourth_column_cellData = First_table_body().findElements(By.xpath(".//td[4]"));
	wait_for_theElement(First_table_fourth_column_cellData);
	return First_table_fourth_column_cellData;}
	public List <WebElement> First_table_fifth_column_cellData(){
	List<WebElement> First_table_fifth_column_cellData = First_table_body().findElements(By.xpath(".//td[5]"));
	wait_for_theElement(First_table_fifth_column_cellData);
	return First_table_fifth_column_cellData;}
	public List <WebElement> First_table_sixth_column_cellData(){
	List<WebElement> First_table_sixth_column_cellData = First_table_body().findElements(By.xpath(".//td[6]"));
	wait_for_theElement(First_table_sixth_column_cellData);
	return First_table_sixth_column_cellData;}
	public List <WebElement> First_table_seventh_column_cellData(){
	List<WebElement> First_table_seventh_column_cellData = First_table_body().findElements(By.xpath(".//td[7]"));
	wait_for_theElement(First_table_seventh_column_cellData);
	return First_table_seventh_column_cellData;}
	public List <WebElement> Action_column_cells(){
	List<WebElement> First_table_first_column_cellData = First_table_body().findElements(By.xpath(".//td[8]"));
	wait_for_theElement(First_table_first_column_cellData);
	return First_table_first_column_cellData;} 
	public WebElement Case_Action_Dropdown(){
	wait_for_theElement(Case_Action_Dropdown);
	return Case_Action_Dropdown;}   
	public WebElement Case_Action_Dropdown_list(){
	wait_for_theElement(Case_Action_Dropdown_list);
	return Case_Action_Dropdown_list;}   
	public List <WebElement> Case_Dropdown_Options(){
	List <WebElement> Case_Dropdown_Options = Case_Action_Dropdown_list().findElements(By.xpath(".//*[@role='menuitem']"));
	wait_for_theElement(Case_Dropdown_Options);
	return Case_Dropdown_Options;}   
	public WebElement textArea(){
	wait_for_theElement(textArea);
	return textArea;}   
	public WebElement Create_Contact_button(){
	wait_for_theElement(Create_Contact_button);
	return Create_Contact_button;}   
	public WebElement second_pop_up_form(){
	wait_for_theElement(second_pop_up_form);
	return second_pop_up_form;}   
	public List <WebElement> second_popup_form_inputs(){
	List <WebElement> second_popup_form_inputs = second_pop_up_form().findElements(By.xpath(".//input"));
	wait_for_theElement(second_popup_form_inputs);
	return second_popup_form_inputs;} 
	public List <WebElement> second_popup_form_TextArea(){
	List <WebElement> second_popup_form_TextArea = second_pop_up_form().findElements(By.xpath(".//textarea"));
	wait_for_theElement(second_popup_form_TextArea);
	return second_popup_form_TextArea;} 
	public List <WebElement> second_popup_form_buttons(){
	List <WebElement> second_popup_form_buttons = second_pop_up_form().findElements(By.xpath(".//button"));
	wait_for_theElement(second_popup_form_buttons);
	return second_popup_form_buttons;}  
	public WebElement Third_popup_form(){
	wait_for_theElement(Third_popup_form);
	return Third_popup_form;}   
	public List <WebElement> Third_popup_form_inputs(){
	List <WebElement> Third_popup_form_inputs = Third_popup_form().findElements(By.xpath(".//input"));
	wait_for_theElement(Third_popup_form_inputs);
	return Third_popup_form_inputs;} 
	public List <WebElement> Third_popup_form_buttons(){
	List <WebElement> Third_popup_form_buttons = Third_popup_form().findElements(By.xpath(".//button"));
	wait_for_theElement(Third_popup_form_buttons);
	return Third_popup_form_buttons;}  
	public WebElement Notes_Add_Button(){
	wait_for_theElement(Notes_Add_Button);
	return Notes_Add_Button;}   
	public WebElement Submit_Button(){
	wait_for_theElement(Submit_Button);
	return Submit_Button;}   
	public WebElement Edit_contract_button(){
	wait_for_theElement(Edit_contract_button);
	return Edit_contract_button;}   
	public WebElement Add_buyout_button_inside_edit_contract_from(){
	wait_for_theElement(Add_buyout_button_inside_edit_contract_from);
	return Add_buyout_button_inside_edit_contract_from;}    
	public WebElement Buyout_funder_name_inside_pop_up_modal_form(){
	wait_for_theElement(Buyout_funder_name_inside_pop_up_modal_form);
	return Buyout_funder_name_inside_pop_up_modal_form;}   
	public WebElement Buyout_Amount_inside_pop_up_modal_form(){
	wait_for_theElement(Buyout_Amount_inside_pop_up_modal_form);
	return Buyout_Amount_inside_pop_up_modal_form;}   
	public WebElement Buyout_Date_inside_pop_up_modal_form(){
	wait_for_theElement(Buyout_Date_inside_pop_up_modal_form);
	return Buyout_Date_inside_pop_up_modal_form;}   
	public WebElement Submit_button(){
	wait_for_theElement(Submit_button);
	return Submit_button;}   
	public WebElement Cancel_Contract_Button(){
	wait_for_theElement(Cancel_Contract_Button);
	return Cancel_Contract_Button;}   
	public WebElement Send_button(){
	wait_for_theElement(Send_button);
	return Send_button;}   
	public WebElement Email_button(){
	wait_for_theElement(Email_button);
	return Email_button;} 
	public WebElement SMS_Send_Button(){
	wait_for_theElement(SMS_Send_Button);
	return SMS_Send_Button;}    
	public WebElement Saved_Message_button(){
	wait_for_theElement(Saved_Message_button);
	return Saved_Message_button;}   
	public WebElement Message_Template_Dropdown_list(){
	wait_for_theElement(Message_Template_Dropdown_list);
	return Message_Template_Dropdown_list;}   
	public List <WebElement> Message_Template_Option(){
	List <WebElement> Message_Template_Option = Message_Template_Dropdown_list().findElements(By.xpath(".//li[@role='menuitem']"));
	wait_for_theElement(Message_Template_Option);
	return Message_Template_Option;}   
	public WebElement Landed_In_Template_Creation_Form(){
	wait_for_theElement(Landed_In_Template_Creation_Form);
	return Landed_In_Template_Creation_Form;}   
	public WebElement Landed_in_sms_send_form(){
	wait_for_theElement(Landed_in_sms_send_form);
	return Landed_in_sms_send_form;}   
	public WebElement Subject_field(){
	wait_for_theElement(Subject_field);
	return Subject_field;}   
	public WebElement Email_to_field(){
	wait_for_theElement(Email_to_field);
	wait_for_Clickable(Email_to_field);
	return Email_to_field;}   
	public WebElement Email_to_option_dropdown(){
	wait_for_theElement(Email_to_option_dropdown);
	return Email_to_option_dropdown;}   
	public WebElement Email_Body(){
	wait_for_theElement(Email_Body);
	return Email_Body;}   
	public WebElement CC_button(){
	wait_for_theElement(CC_button);
	return CC_button;}   
	public WebElement cc_field(){
	wait_for_theElement(cc_field);
	return cc_field;}   
	public WebElement bcc_field(){
	wait_for_theElement(bcc_field);
	return bcc_field;}   
	public WebElement Bcc_button(){
	wait_for_theElement(Bcc_button);
	return Bcc_button;}   
	public WebElement Application_Card_Body(){
	wait_for_theElement(Application_Card_Body);
	return Application_Card_Body;}   
	public WebElement Case_Feed_Section(){
	wait_for_theElement(Case_Feed_Section);
	return Case_Feed_Section;}   
	public List <WebElement> mail_card_sections(){
	List <WebElement> mail_card_sections = Case_Feed_Section().findElements(By.xpath(".//*[contains(@class,'ant-typography')]"));
	wait_for_theElement(mail_card_sections);
	return mail_card_sections;}   
	public WebElement mail_card_in_feed(){
	wait_for_theElement(mail_card_in_feed);
	return mail_card_in_feed;}    
	public WebElement Payoff_Button(){
	By payoff_button = By.xpath("//*[text()='Payoff Details']/..");
	WebElement Payoff_Button= wait_for_presenceBy(payoff_button);
	return Payoff_Button;}   
	public WebElement Payoff_table_title(){
	wait_for_theElement(Payoff_table);
	return Payoff_table;}   
	public WebElement modal_table(){
	WebElement modal_table = popup_modal().findElement(By.xpath(".//tbody"));
	wait_for_theElement(modal_table);
	return modal_table;}   
	public List <WebElement> modal_table_cells(){
	List <WebElement> modal_table_cells = modal_table().findElements(By.xpath(".//td[contains(@class,'ant-table-cell')]"));
	wait_for_theElement(modal_table_cells);
	return modal_table_cells;}   
	public WebElement Edit_button(){
	wait_for_theElement(Edit_button);
	return Edit_button;}   
	public List <WebElement> Description_content_items(){
	wait_for_theElement(Description_content_items);
	return Description_content_items;}   
	public WebElement Edit_details_title_form(){
	wait_for_theElement(Edit_details_title_form);
	return Edit_details_title_form;}   
	public WebElement Law_firm_info_title_text(){
	wait_for_theElement(Law_firm_info_title_text);
	return Law_firm_info_title_text;}   
	public List <WebElement> Description_content_Labels(){
	wait_for_theElement(Description_content_Labels);
	return Description_content_Labels;}    
	public WebElement Title_plaintiff_name(){
	wait_for_theElement(Title_plaintiff_name);
	return Title_plaintiff_name;}   /*
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
	return ;}   
	public WebElement (){
	wait_for_theElement();
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
