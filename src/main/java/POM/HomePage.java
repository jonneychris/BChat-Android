package POM;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ActionsClass {

	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="io.beldex.bchat:id/bchatHeaderImage")
	private WebElement pageTitle;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Save your seed']")
	private WebElement PopupSaveSeed;
	
	@AndroidFindBy(id="io.beldex.bchat:id/okButton")
	private WebElement buttonOk;
	
	@AndroidFindBy(id="io.beldex.bchat:id/profileButton")
	private WebElement btnMenuDrawer;
		
	@AndroidFindBy(xpath="android.widget.TextView[@text='Search']")
	private WebElement titleSearch;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchBarBackButton")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement btncancel;
	
	
	@AndroidFindBy(accessibility="clear")
	private WebElement btntextboxcancel;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement groupsIcon;
	
	//@AndroidFindBy(id="io.beldex.bchat:id/gradientView")
	//private WebElement chathistory;
	 
	
	
	@AndroidFindBy(id="io.beldex.bchat:id/emptyStateContainerText")
	public WebElement BlankChatScreen;
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1632][1026,1800]']")
	private WebElement btnNewChat;
	//android.view.View[1][480,1632][1026,1800]
	//[480,1632][1026,1800]
	//android.view.View
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1800][1026,1968]']")
	private WebElement btnSecretGroup;
	
	@AndroidFindBy (xpath="//android.view.View[@bounds='[480,1968][1026,2136]']")
	private WebElement btnSocialGroup;
	
	//@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[45,190][165,280]']")
	//private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Note to Self']")
	private WebElement optionNoteToMyself;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	private WebElement textboxSearch;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]")
	private WebElement FirstChatItem;
	
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]")
	private WebElement SecondChatItem;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Block']")
	private WebElement optionBlock;
	
	@AndroidFindBy(xpath="//android.widget.TextView[1][@text='Block Contact']")
	private WebElement BlockContactPopupTitle;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.Button")
	private WebElement btnCancelInBlockContactPopup;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.widget.Button")
	private WebElement btnYesInBlockContactPopup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/conversationViewDisplayNameTextView")
	private WebElement DisplayNameOfChatItem;
	
	@AndroidFindBy(id="io.beldex.bchat:id/recyclerView")
	private WebElement oldMessages;
	
	public  String popuptitle() {
		String popupTitle = PopupSaveSeed.getText();
		return popupTitle;
	}
	
	public void click_Option_Note_To_Myself () {
		optionNoteToMyself.click();
	}
	
	public void clickok() {
		buttonOk.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void clickMenuDrawer() {
		btnMenuDrawer.click();
	}
	
	public String searchTitle() {
		 String text= titleSearch.getText();
		 return text;
	}
	
	public void clickSearch() {
		textboxSearch.click();
		
	}
	
	public void clickBackArrow() {
		btnBackArrow.click();
	}
	
	public void OpenNewChat() {
		groupsIcon.click();
		btnNewChat.click();
	}

public void openNewSecretGroup() {
	groupsIcon.click();
	btnSecretGroup.click();
	}

public void openJoinSocialGroup() {
	groupsIcon.click();
	btnSocialGroup.click();
}


public String SearchPlaceholder () {
	return textboxSearch.getText();
}

public void ClickCancel() {
	btncancel.click();
}

public void pastevalues(String text) {
	textboxSearch.click();
	Copy_And_Paste_Values(text, textboxSearch);
}

public void clearTextBox () {
	textboxSearch.clear();
}

public void enterValues (String text) {
	textboxSearch.click();
	textboxSearch.sendKeys(text);
}

public void click_cancel_icon_inside_textbox () {
	btntextboxcancel.click();
}

public boolean visiblity_of_placeholder () {
	boolean result =textboxSearch.isDisplayed();
	return result;
}
public boolean visblity_of_crusor() {
	boolean result =textboxSearch.equals(activeElement());
 return result;
}

public void Block_First_Contact () {
	longPress(DisplayNameOfChatItem);
	optionBlock.click();
	btnYesInBlockContactPopup.click();		
}

public void Block_Second_Contact () {
	longPress(SecondChatItem);
	optionBlock.click();
	btnYesInBlockContactPopup.click();		
}

public String get_DisplayName_Or_Id_Of_ChatItem() {
	 return DisplayNameOfChatItem.getText();	 
}

public List OldMessages () {
	int messagelist =oldMessages.getSize();
	 
	for(int i=0;i <=  ;i++) {
		
	}
	return null;
	
}

}
