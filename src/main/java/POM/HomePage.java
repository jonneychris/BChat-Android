package POM;

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
	
	@AndroidFindBy(id="io.beldex.bchat:id/singleModeImageView")
	private WebElement btnSettingsDrawer;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_settings_title")
	private WebElement titleSettings;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchBarTitle")
	private WebElement titleSearch;
	
	@AndroidFindBy(id="io.beldex.bchat:id/searchBarBackButton")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(id="io.beldex.bchat:id/drawer_close_icon")
	private WebElement btncancel;
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[750,2070][990,2293]']")
	private WebElement groupsIcon;
	//[750,2070][990,2293]
//	[792,2106][972,2286]
	/*
	 *
	 * 00000000-0000-35b1-ffff-ffff000002a9
	 * 
	 * 00000000-0000-35b1-ffff-ffff000002a9
	 //00000000-0000-356d-ffff-ffff0000012e
	//const div = document.getElementById("myDIV");
	//div.getElementsByTagName("*")[3].style.backgroundColor = "red";
	//*/
	 
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[456,2106][636,2286]']")
	private WebElement iconNewChat;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[792,1782][972,1928]']")
	private WebElement iconSocialgroup;
	
	@AndroidFindBy (xpath="//android.widget.ImageView[@bounds='[506,1819][686,1999]']")
	private WebElement iconSecretgroup;
	
	@AndroidFindBy(id="io.beldex.bchat:id/emptyStateContainerText")
	public WebElement BlankChatScreen;
	
	//@AndroidFindBy(xpath="//android.widget.ImageView[@bounds='[45,190][165,280]']")
	//private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search people and groups']")
	private WebElement textboxSearch;
	
	public  String popuptitle() {
		String popupTitle = PopupSaveSeed.getText();
		return popupTitle;
	}
	
	public void clickok() {
		buttonOk.click();
	}
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}
	
	public void clickSettingsDrawer() {
		btnSettingsDrawer.click();
	}
	
	public String settingsTitle() {
		 return titleSettings.getText();
	}
	
	public String searchTitle() {
		 return titleSearch.getText();
	}
	
	public void clickSearch() {
		textboxSearch.click();
		
	}
	
	public void clickBackArrow() {
		btnBackArrow.click();
	}
	
	public void OpenNewChat() {
		groupsIcon.click();
		iconNewChat.click();
	}

public void openNewSecretGroup() {
	groupsIcon.click();
	iconSecretgroup.click();
	}

public void openJoinSocialGroup() {
	groupsIcon.click();
	iconSocialgroup.click();
}


public String SearchPlaceholder () {
	return textboxSearch.getText();
}

public void ClickCancel() {
	btncancel.click();
}
}
