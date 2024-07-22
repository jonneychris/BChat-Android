package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChatSettingsPage extends ActionsClass{

	AndroidDriver driver;
	public ChatSettingsPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
	@AndroidFindBy(id="io.beldex.bchat:id/title")
	private WebElement pageTitle;
	
	@AndroidFindBy(id="io.beldex.bchat:id/back")
	private WebElement btnBackArrow;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement SwipebtnEnterKey;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.Switch")
	private WebElement SwipebtnDelteOld;
	
	
	public String pageTitle () {
		return pageTitle.getText();
	}
	
	public void click_Back_Arrow () {
		btnBackArrow.click();
	}

	public void click_Swipe_button_In_Enter_key () {
		SwipebtnEnterKey.click();
	}
	
	public void click_Swipe_button_In_delete () {
		SwipebtnDelteOld.click();
	}
}
