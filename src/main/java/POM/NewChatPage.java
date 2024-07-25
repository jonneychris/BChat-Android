package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewChatPage extends ActionsClass {

	AndroidDriver driver;
	public NewChatPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New Chat']")
	private WebElement pageTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement BchatIDOrBNSNameTextBox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='1']")
	private WebElement btnLetsBChat;
	
	public String Pagetitle() {
		String title = pageTitle.getText();
		return title;
	}

	public void Check_with_ValidId_1 () {
		BchatIDOrBNSNameTextBox.sendKeys("bdfdd35e38a8c0c3022b9ba791b611bab297fec0ca3a6e82547435876419ff2e0b");
		btnLetsBChat.click();
	}
	
	public void Check_with_ValidId_2 () {
		BchatIDOrBNSNameTextBox.sendKeys("bdb1c1832438f00669476dcf8d8ef6c4efdb49feeb4c389036f46db91951584b24");
		btnLetsBChat.click();
	}
	
}
