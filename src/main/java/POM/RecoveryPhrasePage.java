package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utiles.ActionsClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RecoveryPhrasePage extends ActionsClass{

	AndroidDriver driver;
	public RecoveryPhrasePage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="io.beldex.bchat:id/recoveryPhraseCopyIcon")
	private WebElement btnCopyIcon;
	
	@AndroidFindBy(id="io.beldex.bchat:id/registerButton")
	private WebElement btnCotinue;
	
	@AndroidFindBy(id="io.beldex.bchat:id/title_name")
	public WebElement textPageTitle;
	
	
	public String pageTitle() {
		String PageTitle = textPageTitle.getText();
		return PageTitle;
	}
	
	public void ClickContinue() {
		btnCotinue.click();
	}
	
	public void clickCopyIcon() {
		btnCopyIcon.click();
	}
	
	
	
	
}
