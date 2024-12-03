package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewPage extends ActionsClass{

	AndroidDriver driver;
	public NewPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy (xpath="//android.widget.TextView[@text=\"New Chat\"]")
	private WebElement btnNewChat;
	
	@AndroidFindBy(accessibility = "wallet settings")
	private WebElement searchIcon;
	
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchTextBox;
	
	@AndroidFindBy(accessibility = "clear search text")
	private WebElement cancleIconInTextbox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Search people and groups\"]")
	private WebElement searchtextBoxPlaceholder;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Invite a Friend\"]")
	private WebElement optionInviteFriend;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Note to Self\"]")
	private WebElement optionNoteToSelf;
	
	@AndroidFindBy(accessibility = "Back")
	private WebElement btnBcakArrow;
	
	@AndroidFindBy(accessibility = "Cancel")
	private WebElement cancel_In_Invite;
	
	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View")
	private WebElement ElementOfContact;
	
	public void open_NewChat () {
		btnNewChat.click();
	}
	
	public String get_Contact_value_from_List (String contactname) {
		return driver.findElement(By.xpath("//android.widget.TextView[@text=\""+contactname+"\"]")).getText();
		
	}
	
	public void Enter_values_in_search_textbox (String value) {
		searchIcon.click();
		searchTextBox.sendKeys(value);
		
	}
	public void click_search_icon () {
		searchIcon.click();
	}
	
	public void clear_Values_in_Search_textbox () {
		searchTextBox.clear();
	}
	
	public void click_Invite_friend () {
		optionInviteFriend.click();
	}
	
	public void click_cancel_in_search_textbox () {
		cancleIconInTextbox.click();
	}
		
	public String search_textBox_Placeholder () {
		return searchtextBoxPlaceholder.getText();
	}
	
	public void click_cancel_in_Invite () {
		cancel_In_Invite.click();
	}
	
	public void click_Back_Arrow () {
		btnBcakArrow.click();
	}
	
	public void paste_Values_in_Search_Textbox (String value) {
		Copy_And_Paste_Values(value,searchTextBox);
	}
	
	public void Click_Note_to_Self () {
		optionNoteToSelf.click();
	}
	
	public WebElement get_Element_of_contact () {
	      return ElementOfContact;
	}
	
	public String get_Values_From_Search_textbox () {
		return searchTextBox.getText();
	}
}
