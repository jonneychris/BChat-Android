package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SecretGroupPage extends ActionsClass {

	AndroidDriver driver;
	public SecretGroupPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Secret Group']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	private WebElement groupNameTextbox;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[2]")
	private WebElement searchContactTextbox;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(accessibility = "search contact and clear search text")
	private WebElement closeIcon;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement btnCreate;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.CheckBox")
	private WebElement firstContactInList;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.CheckBox")
	private WebElement secondContactInList;
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.widget.CheckBox")
	private WebElement thirdContactInList;
	
	@AndroidFindBy(xpath = "//android.view.View[1][@index='5']")
	private WebElement ElementOfContactList;
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]/android.view.View/android.widget.TextView")
	private WebElement placeholderGroupName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[2]/android.view.View/android.widget.TextView")
	private WebElement placeholderSearch;
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void click_Create_button () {
		btnCreate.click();
	}
	
	public void Enter_values_in_GroupName (String value) {
		groupNameTextbox.sendKeys(value);
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}
	
	public void Enter_Values_In_Search_textbox (String value) {
		searchContactTextbox.sendKeys(value);
	}
	
	public WebElement Element_of_Contact_List () {
		return ElementOfContactList;
	}
	
	public String Check_FirstContact_Selected_or_Not () {
		return firstContactInList.getAttribute("checked");
	}
	
	public String Check_SeconContact_Selected_or_Not () {
		return secondContactInList.getAttribute("checked");
	}
	
	public String Check_thirdContact_Selected_or_Not () {
		return thirdContactInList.getAttribute("checked");
	}
	
	public void select_FirstContact_In_List () {
		firstContactInList.click();
	}
	
	public void multiselect_contacts_In_List () {	
		for(int i=1;i<=3;i++) {
			driver.findElement(By.xpath("//android.view.View["+i+"]/android.widget.CheckBox")).click();
		}
	}
	
	public void clear_TextBoxes () {
	groupNameTextbox.clear();
	searchContactTextbox.clear();
	}
	
	public WebElement Element_Of_Screen () {
		 return pageTitle;
	}
	
	public void pasteValues_In_TestBoxes (String value,String value1) {
		Copy_And_Paste_Values(value, groupNameTextbox);
		Copy_And_Paste_Values(value1, searchContactTextbox);
	}
	
	public String get_values_From_GroupName_textBox () {
		return groupNameTextbox.getText();
		
	}
	
   public String get_values_From_Search_textBox () {
		return searchContactTextbox.getText();
	}
   
   public void click_GroupName_textbox () {
	   groupNameTextbox.click();
   }
   
   public void click_Search_textbox () {
	   searchContactTextbox.click();
   }
   
   public String getPlacholder_of_groupName_textbox () {
	    return placeholderGroupName.getText();
   }
 
  public String getPlacholder_of_Search_textbox () {
	    return placeholderSearch.getText();
   }
}
